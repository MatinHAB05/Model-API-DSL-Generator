from gen.backendgrammerLexer import backendgrammerLexer
from gen.backendgrammerParser import backendgrammerParser
from antlr4 import  FileStream , CommonTokenStream , ParseTreeWalker
from CustomListner_ast_tree import AST_Listener
from helper_functions import visualzation_ast
from PIL import Image

DEBUG_AST_MODE = False
SHOW_AST_RES = False


if __name__ == '__main__':
    if DEBUG_AST_MODE:
        from helper_functions import debug
        debug.visual_all_debugingTestcases()

    else :
        input_file_path = r"test_grammer_files\test_model_1.txt" # INPUT FILE PATH...
        stream = FileStream(input_file_path)
        lexer = backendgrammerLexer(stream)
        token_stream = CommonTokenStream(lexer)
        parser = backendgrammerParser(token_stream)
        parse_tree = parser.compileinit()

        # --- Build AST with CustomListener ---
        ast_builder_listener = AST_Listener()
        walker = ParseTreeWalker()
        walker.walk(t=parse_tree, listener=ast_builder_listener)
        ast = ast_builder_listener.ast         # THIS IS AST TREE OBJECT !!!


        if SHOW_AST_RES :
            name = "matin-test"
            print("BEGIN : visualzation process ---> " + name + ".jpg")
            visualzation_ast.draw_ast(ast.root, file_name=name, node_size=7000,
                                      pageframe_size=(128, 27))
            print("FINISH : visualzation process ---> " + name + ".jpg\n")
            Image.MAX_IMAGE_PIXELS = None  # disable protection
            img = Image.open(f"{name}.jpg")
            img.show()

