grammar backendgrammer;

compileinit : (modelrole | enumrole)* ;


// MODEL ROLES :

modelrole : 'model' modelname '{' modelblock '}';

modelname: variablename;

modelblock : (fieldname ':' fieldtype fieldannotaions ';')+;

fieldname : variablename;

fieldtype : variablename;

fieldannotaions : ('@' fieldannotaion)* ;
fieldannotaion : pkoption | nulloption | uniqueoption | validoption | fkoption ;

fkoption: 'foreign-key' '(' modelname '.' fieldname ')';

validoption: 'valid' '[' validoptionparameters? ']';
validoptionparameters : validoptionparameter | validoptionparameter (',' validoptionparameter)+ ;
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



// ENUM ROLES :

enumrole : 'enum' enumname '{' enumblock '}' ;

enumname : variablename;

enumblock : enumitem | enumitem (',' enumitem)* ;

enumitem : genericvalue ;



// SHARED RULES

genericvalue : intvalue | stringvalue | datevalue | timevalue;

intvalue : ('+'|'-')? DIGIT+;
stringvalue : STRINGVALUE;
datevalue : DIGIT+ '-' DIGIT+ '-' DIGIT+;
timevalue :  DIGIT+ ':' DIGIT+ ':' DIGIT+;

variablename : VARIABLEID ;


// LEXERS

DIGIT : [0-9];

STRINGVALUE : '"' ( ~["\\] | '\\' . )* '"' ;


VARIABLEID : [a-zA-Z_][_a-zA-Z0-9]*;

INT : 'Int';
STRING : 'String';
DATE : 'Date';
TIME : 'Time' ;

WS : [ \t\r\n]+ -> skip ;

