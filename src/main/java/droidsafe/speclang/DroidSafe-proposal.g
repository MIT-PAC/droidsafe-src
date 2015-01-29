grammar DroidSafe;

options {
  language = Java;
  output = AST;
}

tokens {
  SEMI = ';';
  PLUS = '+';
  RPAREN = ')';
  LPAREN = '(';
  COLON = ':';
  COMMA = ',';
  RCURLY ='}';
  LCURLY ='{';
  EQUAL = '=';
  MODES = 'modes';
  ACTIONS = 'actions';
  KINDS = 'kinds';
  GLOBALS = 'globals';
  ENTER = 'enter';
  EXIT = 'exit';
  INT = 'int';
  BOOLEAN = 'boolean';
  STRING = 'string';
  TRUE = 'true';
  FALSE = 'false';
  AND = 'and';
  NOT = 'not';
  OR = 'or';
  
  /* AST Nodes */
  MODE_DECL;
  TYPE;
  
  BOOLEAN_VALUE;
  
  ACTION;
  
  KIND_EXPR;
  VAR_DECL_LIST;
  VAR_DECL;
  
  
  EXPR_LIST;
  
  STRING_EXPR;
  
  INT_EXPR;
  
  NOT_EXPR;
  AND_EXPR;
  OR_EXPR;
  
  STMT_LIST;
  ENTER_STMT;
  EXIT_STMT;
  OUTPUT_EVENT_STMT;
  KINDS_DECLS;
  GLOBALS_DECLS;
  MODES_DECLS;
  ACTIONS_DECLS;
  
  INPUT_EVENT;
  
  SPEC;
}

@header {package droidsafe.speclang;}
@lexer::header {package droidsafe.speclang;}

spec 
  :(MODES mode_declaration_statement+)?
   (KINDS ID (COMMA ID)* SEMI)? 
   (GLOBALS variable_declaration_statement+)?
    ACTIONS action* -> ^(SPEC ^(MODES_DECLS mode_declaration_statement*) ^(KINDS_DECLS ID*) ^(GLOBALS_DECLS variable_declaration_statement*) ^(ACTIONS_DECLS action*))
  ;

boolean_value
  : TRUE -> ^(BOOLEAN_VALUE TRUE)
  | FALSE -> ^(BOOLEAN_VALUE FALSE)
  ;

type  : INT -> ^(TYPE INT)  
  | BOOLEAN -> ^(TYPE BOOLEAN)  
  | STRING -> ^(TYPE STRING)  
  ;
    
mode_declaration_statement 
  : ID EQUAL boolean_value SEMI -> ^(MODE_DECL ID boolean_value) 
  ;
  
/*
mode_expression
  : (boolean_value -> boolean_value
    | ID -> ID
    | NOT nme=mode_expression -> ^(NOT_EXPR $nme)
    ) 
   (AND ame=mode_expression -> ^(AND_EXPR $mode_expression $ame)
   | OR ome=mode_expression -> ^(OR_EXPR $mode_expression $ome))*
  ;
  
  */
mode_expression
  : not_expression ((AND^ | OR^) not_expression)*
  ; 
 
not_expression 
  : NOT mode_expression_atom -> ^(NOT mode_expression_atom)
  | mode_expression_atom
  ; 
  
mode_expression_atom
 : boolean_value 
 | ID 
 | LPAREN! mode_expression RPAREN! 
 ;

kind_expression
  : ID (PLUS ID)* -> ^(KIND_EXPR ID+) 
  | 
  ;
 
variable_declaration_statement 
  : variable_declaration SEMI!;
  
variable_declaration 
  : kind_expression type ID -> ^(VAR_DECL kind_expression type ID) 
  ;
  
variable_declaration_list 
  : variable_declaration (COMMA variable_declaration)* -> ^(VAR_DECL_LIST variable_declaration+) 
  ;
  
input_event 
  : ID LPAREN variable_declaration_list? RPAREN -> ^(INPUT_EVENT ID variable_declaration_list?)
  ; 

string_expression 
  : STRING_LITERAL -> ^(STRING_EXPR STRING_LITERAL)
  ;
  
integer_expression 
  : INT_LITERAL -> ^(INT_EXPR INT_LITERAL)
  ;

expression 
  : string_expression
  | integer_expression 
  | ID
  ;

expression_list 
  : expression  (COMMA expression)* -> expression+ 
  ;

output_event 
  : ID LPAREN expression_list? RPAREN -> ^(OUTPUT_EVENT_STMT ID ^(EXPR_LIST expression_list?))
  ;

statement 
  : ENTER ID SEMI -> ^(ENTER_STMT ID)
  | EXIT ID SEMI -> ^(EXIT_STMT ID)
  | output_event SEMI -> output_event 
  ;
  
statement_list 
  : statement+ -> statement+;

action : 
  mode_expression COLON input_event LCURLY statement_list? RCURLY -> ^(ACTION mode_expression input_event ^(STMT_LIST statement_list?))
  ;


ID  : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT_LITERAL  :  '0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING_LITERAL
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR_LITERAL:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
    

