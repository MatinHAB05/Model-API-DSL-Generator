from gen.backendgrammerLexer import backendgrammerLexer
from gen.backendgrammerParser import backendgrammerParser
import os
import random
from antlr4 import  FileStream , CommonTokenStream , ParseTreeWalker
from CustomListner_ast_tree import AST_Listener
from helper_functions import visualzation_ast

def all_debug_testCases(path="test_grammer_files") :
    file_name = [x for x in os.listdir(path) if x.endswith("debugingMode.txt")]
    random.shuffle(file_name)
    random.shuffle(file_name)
    random.shuffle(file_name)  # for reads logs in better style
    return file_name

def visual_all_debugingTestcases(path="test_grammer_files") :

    file_name = all_debug_testCases()

    for name in file_name:
        print("*" * 200 + "\n")
        print(name + " : \n")
        stream = FileStream("test_grammer_files\\" + name)
        lexer = backendgrammerLexer(stream)
        token_stream = CommonTokenStream(lexer)
        parser = backendgrammerParser(token_stream)
        parse_tree = parser.compileinit()

        # --- Build AST with CustomListener ---
        ast_builder_listener = AST_Listener()
        walker = ParseTreeWalker()
        walker.walk(t=parse_tree, listener=ast_builder_listener)
        ast = ast_builder_listener.ast

        print(ast.traverse_ast(ast.root))
        print("BEGIN : visualzation process ---> " + name + ".jpg")
        if "mix" in name:
            visualzation_ast.draw_ast(ast.root, file_name="ast-outputs\\" + name, node_size=7000,
                                      pageframe_size=(512, 64))
        else:
            visualzation_ast.draw_ast(ast.root, file_name="ast-outputs\\" + name, node_size=7000,
                                      pageframe_size=(128, 27))

        print("FINISH : visualzation process ---> " + name + ".jpg\n")
        # Image.MAX_IMAGE_PIXELS = None  # disable protection
        # img = Image.open(f"{file_name}.jpg")
        # img.show()

def visual_debugingTestcase(input_name,path="test_grammer_files")  :
    file_name = all_debug_testCases()
    name = None
    for f in file_name :
        if input_name in f :
            name = f
            break

    if name is None :
        raise Exception(f"NOT FOUND <---> {input_name}")

    print("*" * 200 + "\n")
    print(name + " : \n")
    stream = FileStream("test_grammer_files\\" + name)
    lexer = backendgrammerLexer(stream)
    token_stream = CommonTokenStream(lexer)
    parser = backendgrammerParser(token_stream)
    parse_tree = parser.compileinit()

    # --- Build AST with CustomListener ---
    ast_builder_listener = AST_Listener()
    walker = ParseTreeWalker()
    walker.walk(t=parse_tree, listener=ast_builder_listener)
    ast = ast_builder_listener.ast

    print(ast.traverse_ast(ast.root))
    print("BEGIN : visualzation process ---> " + name + ".jpg")
    if "mix" in name:
        visualzation_ast.draw_ast(ast.root, file_name="ast-outputs\\" + name, node_size=7000,
                                  pageframe_size=(512, 64))
    else:
        visualzation_ast.draw_ast(ast.root, file_name="ast-outputs\\" + name, node_size=7000,
                                  pageframe_size=(128, 27))

    print("FINISH : visualzation process ---> " + name + ".jpg\n")
    # Image.MAX_IMAGE_PIXELS = None  # disable protection
    # img = Image.open(f"{file_name}.jpg")
    # img.show()