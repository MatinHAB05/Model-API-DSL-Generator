from antlr4 import TokenStreamRewriter , FileStream , CommonTokenStream , ParseTreeWalker , InputStream
from CustomListner_ast_tree import AST_Listener


from gen.backendgrammerLexer import backendgrammerLexer
from gen.backendgrammerParser import backendgrammerParser
from helper_functions import visualzation_ast
from PIL import Image
# DEBUGING MODE !!!

file_name = f"test_{2}_enum_debugingMode"
stream = FileStream("test_grammer_files\\"+ file_name+ ".txt")
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
print("BEGIN : visualzation process...")
file_name = 'matin_test'
visualzation_ast.draw_ast(ast.root,file_name=file_name)
print("FINISH : visualzation process ---> " + file_name +".jpg")
Image.MAX_IMAGE_PIXELS = None  # disable protection
img = Image.open(f"{file_name}.jpg")
img.show()