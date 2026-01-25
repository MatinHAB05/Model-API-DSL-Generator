import networkx as nx


# Function to add nodes and edges to the NetworkX graph
def add_to_graph(graph, node, parent=None):
    if node is not None:
        # Add the current node to the graph
        graph.add_node(node.id, label="\n".join([f"type={node.value['type']}",f"content={node.value['content']}"]))
        # If there's a parent, add an edge from the parent to the current node
        if parent is not None:
            graph.add_edge(parent.id, node.id)
        # add the child nodes to the graph
        for child in node.children:
            add_to_graph(graph, child, node)


def transform_ast_to_networkx(ast_root_node):
    graph = nx.DiGraph()
    add_to_graph(graph, ast_root_node)
    return graph


def draw_ast(ast_root_node,file_name="matin_test",pageframe_size=(48,27),margins=0.05,node_size=5000 , node_color="cyan" , node_alpha=0.5,dpi=100):
    from matplotlib import pyplot as plt
    from networkx.drawing.nx_pydot import graphviz_layout
    plt.rcParams["figure.figsize"] = pageframe_size
    graph = transform_ast_to_networkx(ast_root_node)
    pos = graphviz_layout(graph, prog='dot')
    nx.draw(graph, pos, node_size=node_size, labels=nx.get_node_attributes(graph, "label"), alpha=node_alpha, node_color=node_color,
            with_labels=True)
    ax = plt.gca()
    ax.margins(margins)
    plt.axis("off")
    if file_name is not None:
        plt.savefig(fname=file_name+".jpg",dpi=dpi,bbox_inches='tight')
        plt.close()
    else:
        #BUG !
        plt.show()
