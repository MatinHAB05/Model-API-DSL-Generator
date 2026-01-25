set_types = {
    "binary-operation" , # * / = + - eq lst grt...
    "generic-value" , # stringValue , IntValue
    "input-block" , # in endpoints we have response or input block
    "variable-name" , # variable (exm : see factor_relational!)
    "relational-codes" , # relational-codes that have at least one define_variable_relational
    # and exactly one return expr
    "response-block" , #  in endpoints we have response or input block
    "endpoint-block" , # in endpoints we have both response and input block
    "endpoint" ,# endpoint root rule
    "built-in-function" , # Select , Union , Len , Orderby ,...
    "start-program" , # compileinit rule and start of any program




}