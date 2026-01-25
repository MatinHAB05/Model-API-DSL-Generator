from ast_tree_node_info import set_types

class AST_Tree :
    def __init__(self) :
        self.root = None
        self.counter = 0
        self.types = set_types


    class AST_TreeNode :
        def __init__(self, value , children , parent ,id) :
            self.value = value # {"type" : ... , "content" :...}
            self.children = children
            self.parent = parent
            self.id = id

        def __str__(self):
            return str((self.id,self.value))

    def set_value_obj(self,content,type):
        if type not in self.types :
            raise Exception(f"{type}<>{content}")
        return {"type":type,"content":content}

    def build_new_node(self,value,children,parent=None) :
        # for current Node
        node = self.AST_TreeNode(value,children,parent,self.counter)
        self.counter += 1

        # for children of currnet Node
        if children :
            for child in children :
                child.parent = node

        # for parent
        if parent is not None :
            parent.children.append(node)

        return node

    def traverse_ast(self, root_node):
        traversal = []
        # print(root_node)

        if root_node.children is not None and len(root_node.children) > 0:
            for child in root_node.children:
                traversal.extend(self.traverse_ast(child))
        node_dict = dict()
        node_dict['value'] = root_node.value
        node_dict['id'] = root_node.id
        traversal.append((root_node.value['type'],root_node.value['content']))
        return traversal

