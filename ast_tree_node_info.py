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
    "enum-block" , # enum block that means that enum have more than 1 item
    "enum" , # enum role begin
    "model" , # model role begin
    "model-entry" , # model-entry role
    "annotation-validation-max" , # max = 7 the "max" op
    "annotation-validation-min",  # min = 4 the "min" op
    "annotation-validation-wildpattern",  # wildpattern = "this is regex pattern so must be RAW" the "wildpattern" op
    "annotation-validation-include",  # include = {...} "include" op
    "annotation-validation-exclude",  # exclude = {...} "exclude" op
    "annotation-validation",  # @valid[...] "valid" op
    "annotation-pk",  # @pk "pk" op
    "annotation-nullable",  # @nullable "nullable" op
    "annotation-non-nullable",  # @non-nullable "non-nullable" op
    "annotation-unique",  # @unique "unique" op
    "annotation-foreign-key",  # @foreign-key "foreign-key" op
    "generic-field-type" , # field types of models like Int , DateTime , String ,
    "custom-field-type",  # field types of models like enums that we declare
    "http-method" , # GET , POST , PUT , DELETE
}