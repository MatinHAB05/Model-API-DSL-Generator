from antlr4 import TokenStreamRewriter , FileStream , CommonTokenStream , ParseTreeWalker , InputStream ,
from CustomListner_ast_tree import AST_Listener

from gen import backendgrammerLexer , backendgrammerParser
# DEBUGING MODE !!!

stream = FileStream(r"test_grammer_files\test_debugingMode.txt")
lexer = backendgrammerLexer(stream)
token_stream = CommonTokenStream(lexer)
parser = backendgrammerParser(token_stream)
parse_tree = parser.compileinit()

# --- Build AST with CustomListener ---
ast_builder_listener = AST_Listener()
walker = ParseTreeWalker()
walker.walk(t=parse_tree, listener=ast_builder_listener)
ast = ast_builder_listener.ast