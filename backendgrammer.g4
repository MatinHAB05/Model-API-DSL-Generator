grammar backendgrammer;

compileinit : (modelrole | enumrole)* ;

modelrole : 'model' modelname '{' modelblock '}';

modelname: variablename;

modelblock : (fieldname ':' fieldtype fieldannotaions ';')+;

fieldname : variablename;

fieldtype : numericaltype | texttype | datetimetype | customtype ;

customtype: enumname;

datetimetype: DATE | TIME;

texttype: STRING;

numericaltype: INT;


fieldannotaions : ('@' fieldannotaion)* ;
fieldannotaion : pkoption | nulloption | uniqueoption | validoption | fkoption ;

fkoption: 'foreign-key' '(' modelname '.' fieldname ')';

validoption: 'vaild' '[' validoptionparameters ']';
validoptionparameters : validoptionparameter | validoptionparameter (',' validoptionparameter)+ ;
validoptionparameter : max_validoptionparameter |
                       min_validoptionparameter |
                       wildpattern_validoptionparameter |
                       include_validoptionparameter |
                       exclude_validoptionparameter;

exclude_validoptionparameter: 'exclude' '=' '{' genericvalue* '}';

include_validoptionparameter: 'include' '=' '{' genericvalue* '}';

wildpattern_validoptionparameter: 'wildpattern' '=' '"' wildpattern '"';

min_validoptionparameter: 'min' '='  genericvalue;

max_validoptionparameter: 'max' '='  genericvalue;


uniqueoption : 'unique';

nulloption: 'nullable' | 'non-nullable';

pkoption: 'pk';





enumrole : 'enum' enumname '{' enumblock '}' ;

enumname : variablename;

enumblock : enumitem | enumitem (',' enumitem)* ;

enumitem : genericvalue ;

genericvalue : intvalue | stringvalue | datevalue | timevalue;

intvalue : ('+'|'-')? DIGIT+;
stringvalue : ;
datevalue : DIGIT+ '-' MONTHDIGITS '-' DAYDIGITS;
timevalue :  HOURDIGIT ':' MINUTEDIGIT ':' SECONDDIGIT;



variablename : VARIABLEID ;
wildpattern : '...';

DIGIT : [0-9];
MONTHDIGITS : '0'[1-9] | '1'[0-2];
DAYDIGITS : '0'[1-9] | [12][0-9] | '3'[01] ;
HOURDIGIT : [01][0-9] | '2'[0-3] ;
MINUTEDIGIT : [0-5][0-9] ;
SECONDDIGIT : [0-5][0-9] ;

VARIABLEID : [a-zA-Z_][_a-zA-Z0-9]*;

INT : 'Int';
STRING : 'String';
DATE : 'Date';
TIME : 'Time' ;
