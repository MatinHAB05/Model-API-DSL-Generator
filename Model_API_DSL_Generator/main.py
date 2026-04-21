import os
import sys

sys.path.append(os.getcwd())

from gen.backendgrammerLexer import backendgrammerLexer
from gen.backendgrammerParser import backendgrammerParser
from antlr4 import FileStream, CommonTokenStream, ParseTreeWalker
from CustomListner_ast_tree import AST_Listener
from helper_functions import visualzation_ast
from PIL import Image
import argparse

try:
    from django_code_generator import DjangoCodeGenerator
except ImportError:
    print("Error: Could not import 'DjangoCodeGenerator'. Make sure 'django_code_generator.py' exists.")
    sys.exit(1)


def parse_arguments():
    """Parse command line arguments"""
    parser = argparse.ArgumentParser(
        description="DSL to Backend code generator",
        formatter_class=argparse.ArgumentDefaultsHelpFormatter
    )
    parser.add_argument("--version", action="version", version="1.0.0")

    parser.add_argument("--generate", action="store_true",
                        help="Enable Code Generator", default=True)
    parser.add_argument("--astimg", action="store_true",
                        help="Show AST image", default=False)
    parser.add_argument("-i", "--input", help="Input file name", required=True)
    parser.add_argument("-o", "--output", help="Output directory",
                        default="generated_app")
    parser.add_argument("--baseinput", help="Base directory for input file",
                        default=".")
    parser.add_argument("--baseoutput", help="Base directory for output file",
                        default=".")
    parser.add_argument("--target",
                        help="Target framework for code generation from AST tree",
                        default="Django")

    return parser.parse_args()


def main():
    """Main function"""
    print("\n")
    args = parse_arguments()

    DEBUG_AST_MODE = False
    GENERATE_CODE = args.generate
    SHOW_AST_RES = args.astimg
    INPUT_FILE_PATH = os.path.join(args.baseinput, args.input)
    OUTPUT_DIR = os.path.join(args.baseoutput, args.output)
    Target_language = args.target

    if DEBUG_AST_MODE:
        from helper_functions import debug
        debug.visual_all_debugingTestcases()
        return

    print(f"--- Processing File: {INPUT_FILE_PATH} ---")

    if not os.path.exists(INPUT_FILE_PATH):
        print(f"Error: Input file '{INPUT_FILE_PATH}' not found.")
        sys.exit(1)

    # Parse DSL and build AST
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

    # Show AST visualization if requested
    if SHOW_AST_RES:
        name = "ast-output"
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

    # Generate code if requested
    if GENERATE_CODE:
        if Target_language == "Django":
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

        else:
            print("Comming Soon :)")


if __name__ == '__main__':
    main()
