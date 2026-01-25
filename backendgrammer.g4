grammar backendgrammer;

compileinit : (modelrole | enumrole | endpointrule)* ;


// MODEL ROLES : **************************************************************************************************************************************

modelrole : 'model' modelname '{' modelblock '}' ;

modelname: variablename;

modelblock : modelenyty+;

modelenyty : fieldname ':' fieldtype ('@' fieldannotaion)* ';';

fieldname : variablename;

fieldtype : variablename;

fieldannotaion : pkoption | nulloption | uniqueoption | validoption | fkoption ;

fkoption: 'foreign-key' '(' modelname '.' fieldname ')';

validoption: 'valid' '[' (validoptionparameter | validoptionparameter (',' validoptionparameter)+)? ']';
validoptionparameter : max_validoptionparameter |
                       min_validoptionparameter |
                       wildpattern_validoptionparameter |
                       include_validoptionparameter |
                       exclude_validoptionparameter;

exclude_validoptionparameter: 'exclude' '=' '{' (genericvalue | genericvalue (',' genericvalue)+)? '}';

include_validoptionparameter: 'include' '=' '{' (genericvalue | genericvalue (',' genericvalue)+)? '}';

wildpattern_validoptionparameter: 'wildpattern' '=' stringvalue;

min_validoptionparameter: 'min' '='  genericvalue;

max_validoptionparameter: 'max' '='  genericvalue;


uniqueoption : 'unique';

nulloption: 'nullable' | 'non-nullable';

pkoption: 'pk';



// ENUM ROLES : **************************************************************************************************************************************

enumrole : 'enum' enumname '{' enumblock '}' ;

enumname : variablename;

enumblock : enumitem | enumitem (',' enumitem)* ;

enumitem : genericvalue ;


// ENDPOINT RULES : **************************************************************************************************************************************

endpointrule : 'endpoint' operationId ':' htttpMethod endpointurl '{' endpoinblock '}';
operationId : variablename ;
htttpMethod : GET_KEY | POST_KEY | PUT_KEY | DELETE_KEY ;
//endpointurl : '/' | ('/' endpointurl_terms)+ '/'?;
//endpointurl_terms : endpointurl_term | endpointurl_term ('-' endpointurl_term)* ;
//endpointurl_term : '{' variablename'}' | variablename ;
endpointurl : stringvalue;

endpoinblock : responseblock ';' inputblock ';' |  inputblock ';' responseblock ';' | responseblock ';' ;
responseblock : 'response' ':' responseblock_inner ;
responseblock_inner : modelname | 'relational' '{' relationalcode '}';
relationalcode : ( define_variable_relational)* '->' expr_relational ';';
define_variable_relational : variablename '=' expr_relational ';';
expr_relational : term_relational | built_in_functions_relational ;
term_relational : term_relational ('+'|'-') idom_relational | idom_relational;
idom_relational :  idom_relational ('*'|'/') factor_relational | factor_relational;
factor_relational : variablename | genericvalue | '(' term_relational ')';

inputblock : 'input' ':' jsonstring ;
jsonstring : stringvalue;

built_in_functions_relational : SELECT_FUNCTION_KEY '<' ( key_value_pair_select_relational (',' key_value_pair_select_relational)* )? '>' '(' expr_relational ')'
                              | PROJECT_FUNCTION_KEY '<' (variablename (',' variablename)*) '>' '(' expr_relational ')'
                              | JOIN_FUNCTION_KEY '<' (variablename (',' variablename)*) '>' '(' expr_relational ',' expr_relational')'
                              | LEN_FUNCTION_KEY '(' expr_relational ')'
                              | SET_FUNCTION_KEY '(' expr_relational ',' expr_relational ')'
                              | ORDERBY_FUNCTION_KEY '(' expr_relational ',' booleanvalue ')'
                              | LIMIT_FUNCTION_KEY '<'term_relational? ',' term_relational? ',' term_relational? '>' '(' expr_relational ')'
                              ;

key_value_pair_select_relational : variablename binary_logical_operation term_relational ;
binary_logical_operation : 'eq' | 'lst' | 'grt' | 'grteq' | 'lsteq' |  'not-eq' | 'not-lst' | 'not-grt' | 'not-grteq' | 'not-lsteq' ;

// SHARED RULES : **************************************************************************************************************************************

genericvalue : intvalue | stringvalue | booleanvalue;

intvalue : ('+'|'-')? DIGITS;
stringvalue : STRINGVALUE;
booleanvalue : BOOLEANVALUE;
variablename : VARIABLEID ;


// KEYWORDS : **************************************************************************************************************************************

MODEL_KEY : 'model' ;
ATSIGN_KEY : '@' ;
FK_KEY : 'foreign-key';
LEFT_CURLBR_KEY : '{' ;
RIGHT_CURLBR_KEY : '}' ;
COLON_KEY : ':';
SEMICOLON_KEY : ';';
LEFT_PAR_KEY : '(';
RIGHT_PAR_KEY : ')';
DOT_KEY : '.';
VALID_KEY : 'valid';
LEFT_BRACKET_KEY : '[';
RIGHT_BRACKET_KEY : ']';
COMMA_KEY : ',';
EQUALSIGN_KEY : '=';
LEFT_ANGLE_BRACKET_KEY : '<' ;
RIGHT_ANGLE_BRACKET_KEY : '>' ;
Exclamation_KEY : '!';
EQUAL_KEY : 'eq' ;
LESSTHAN_KEY : 'lst';
GREATERTHAN_KEY : 'grt';
LESSTHAN_OR_EQUAL_KEY : 'lsteq';
GREATERTHAN_OR_EQUAL_KEY : 'grteq';

NOT_EQUAL_KEY : 'not-eq' ;
NOT_LESSTHAN_KEY : 'not-lst';
NOT_GREATERTHAN_KEY : 'not-grt';
NOT_LESSTHAN_OR_EQUAL_KEY : 'not-lsteq';
NOT_GREATERTHAN_OR_EQUAL_KEY : 'not-grteq';


EXCLUDE_KEY : 'exclude';
INCLUDE_KEY : 'include';
WILD_PATTERN_KEY : 'wildpattern';
MIN_KEY : 'min';
MAX_KEY : 'max';
UNIQUE_KEY : 'unique';
NULLABLE_KEY:'nullable';
NON_NULLABLE_KEY : 'non-nullable';
PK_KEY : 'pk' ;
ENUM_KEY : 'enum' ;
GET_KEY : 'GET' ;
POST_KEY : 'POST';
PUT_KEY : 'PUT' ;
DELETE_KEY : 'DELETE';
RESPONSE_KEY : 'response';
INPUT_KEY : 'input';
RELATIONAL_KEY :  'relational';
RETURN_ARROW_KEY : '->' ;
SELECT_FUNCTION_KEY : 'Select' ;
PROJECT_FUNCTION_KEY : 'Project' ;
JOIN_FUNCTION_KEY : 'Join_inner' | 'Join_outter' | 'Join_left' | 'Join_right' ;
SET_FUNCTION_KEY : 'Union' | 'Intersection' | 'Difference' | 'Cartesian' ;
LIMIT_FUNCTION_KEY : 'Limit' ;
ORDERBY_FUNCTION_KEY : 'Orderby' ;
LEN_FUNCTION_KEY : 'Len';

// LEXERS : **************************************************************************************************************************************

DIGITS : DIGIT+;
STRINGVALUE : '"' ( ESC | . )*? '"' ;
BOOLEANVALUE : 'True' | 'False' ;

fragment ESC : '\\'[nbtr"\\];
fragment DIGIT : [0-9];


VARIABLEID : [a-zA-Z_][_a-zA-Z0-9]*;
SINGLELINE_COMMENT : '//' ~[\n]* -> skip;
MULTILINE_COMMENT : '"""' .*?  '"""' -> skip;

WS : [ \t\r\n]+ -> skip ;
