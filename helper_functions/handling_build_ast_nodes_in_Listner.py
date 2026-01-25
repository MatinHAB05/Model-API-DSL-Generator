def is_exist_child_in_parent(parent_node, child_node_name):
    method = getattr(parent_node, child_node_name)
    result = method()

    if result is None:
        return False

    if isinstance(result, list):
        return len(result) > 0

    return True


def directly_raw_value(ast,ctx_raw_node,ctx_parent_ast_node):
    ctx_parent_ast_node.val = ast.build_new_node(value=ast.set_value_obj(content= ctx_raw_node.getText(), type="generic-value"),
                                                 children=[] ,
                                                 parent= None
                                                 )

def directly_child_to_parent(ast,ctx_child_ast_node,ctx_parent_ast_node):
    ctx_parent_ast_node.val = ctx_child_ast_node.val


def binary_operation(ast,ctx_operation,ctx_operator,ctx_operand_1 , ctx_operand_2):
   ctx_operation.val = ast.build_new_node(value=ast.set_value_obj(content=ctx_operator.getText(),type="binary-operation") ,
                                          children=[ctx_operand_1.val ,ctx_operand_2.val] ,
                                          parent=None)

def extract_baseInput_and_mainInput(current_function,name_func) :
    main_inputs = []
    base_input = []
    if name_func=="Select" :
        main_inputs.append(current_function.expr_relational(0).val)
        if is_exist_child_in_parent(current_function,"key_value_pair_select_relational") :
            for item_ctx in current_function.key_value_pair_select_relational():
                base_input.append(item_ctx.val)




    elif  name_func=="Project" :
        main_inputs.append(current_function.expr_relational(0).val)
        if is_exist_child_in_parent(current_function,"variablename") :
            for item_ctx in current_function.variablename():
                base_input.append(item_ctx.val)

    elif name_func.startswith("Join") :
        main_inputs.append(current_function.expr_relational(0).val)
        main_inputs.append(current_function.expr_relational(1).val)

        if is_exist_child_in_parent(current_function,"variablename") :
            for item_ctx in current_function.variablename():
                base_input.append(item_ctx.val)


    elif name_func == "Len":
        main_inputs.append(current_function.expr_relational(0).val)

    elif  name_func in [ 'Union' , 'Intersection' , 'Difference' , 'Cartesian' ] :
        main_inputs.append(current_function.expr_relational(0).val)
        main_inputs.append(current_function.expr_relational(1).val)

    elif  name_func=="Orderby" :
        main_inputs.append(current_function.expr_relational(0).val)
        main_inputs.append(current_function.booleanvalue().val)


    elif name_func == "Limit":
        main_inputs.append(current_function.expr_relational(0).val)

        if is_exist_child_in_parent(current_function,"term_relational") :
            for item_ctx in current_function.term_relational():
                base_input.append(item_ctx.val)


    return base_input,main_inputs

