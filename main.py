import os
import sys

sys.path.append(os.getcwd())

from gen.backendgrammerLexer import backendgrammerLexer
from gen.backendgrammerParser import backendgrammerParser
from antlr4 import  FileStream , CommonTokenStream , ParseTreeWalker
from CustomListner_ast_tree import AST_Listener
from helper_functions import visualzation_ast
from PIL import Image

try:
    from django_code_generator import DjangoCodeGenerator
except ImportError:
    print("Error: Could not import 'DjangoCodeGenerator'. Make sure 'django_code_generator.py' exists.")
    sys.exit(1)


DEBUG_AST_MODE = False
SHOW_AST_RES = False  
GENERATE_CODE = True  
INPUT_FILE_PATH = r"./test_grammer_files/test_model_2.txt" 
OUTPUT_DIR = "generated_django_app"

if __name__ == '__main__':
    if DEBUG_AST_MODE:
        from helper_functions import debug
        debug.visual_all_debugingTestcases()

    else:
        print(f"--- Processing File: {INPUT_FILE_PATH} ---")
        
        if not os.path.exists(INPUT_FILE_PATH):
            print(f"Error: Input file '{INPUT_FILE_PATH}' not found.")
            sys.exit(1)

        stream = FileStream(INPUT_FILE_PATH, encoding='utf-8')
        lexer = backendgrammerLexer(stream)
        token_stream = CommonTokenStream(lexer)
        parser = backendgrammerParser(token_stream)
        
        print("Parsing DSL...")
        parse_tree = parser.compileinit()

        ast_builder_listener = AST_Listener()
        walker = ParseTreeWalker()
        walker.walk(t=parse_tree, listener=ast_builder_listener)
        ast = ast_builder_listener.ast 

        if SHOW_AST_RES:
            name = "matin-test"
            print(f"BEGIN : visualization process ---> {name}.jpg")
            try:
                visualzation_ast.draw_ast(ast.root, file_name=name, node_size=7000,
                                          pageframe_size=(128, 27))
                print(f"FINISH : visualization process ---> {name}.jpg")
                
                try:
                    Image.MAX_IMAGE_PIXELS = None 
                    img = Image.open(f"{name}.jpg")
                    img.show()
                except Exception as e:
                    print(f"Image created but could not be opened automatically: {e}")
            except Exception as e:
                print(f"Visualization Warning: {e}")

        if GENERATE_CODE:
            print("\n--- Starting Django Code Generation ---")
            
            generator = DjangoCodeGenerator()
            
            try:
                generated_files = generator.generate(ast.root)
                
                if not os.path.exists(OUTPUT_DIR):
                    os.makedirs(OUTPUT_DIR)
                    print(f"Created output directory: {OUTPUT_DIR}")
                
                for filename, content in generated_files.items():
                    full_path = os.path.join(OUTPUT_DIR, filename)
                    with open(full_path, "w", encoding="utf-8") as f:
                        f.write(content)
                    print(f"✅ Generated: {full_path}")
                
                print("-" * 40)
                print(f"🎉 SUCCESS! Django project files are in '{OUTPUT_DIR}' folder.")
                print("-" * 40)
                
            except Exception as e:
                print(f"❌ Error during code generation: {e}")
                import traceback
                traceback.print_exc()
