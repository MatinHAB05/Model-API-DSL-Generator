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


