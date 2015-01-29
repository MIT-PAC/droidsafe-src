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
  OR_VAL = '|';
  CLASS = '*';
  WHITELIST = 'whitelist';
  TRUE = 'true';
  FALSE = 'false';
  

  /* AST Nodes */
  EVENT_BLOCK;
  BOOLEAN_VALUE;
  INT_VALUE;
  STRING_VALUE;
  CHAR_VALUE;
  TYPE_VALUE;
  CLASS_VALUE;
  CVALUE_LIST;
  
  STMT_LIST;
  EVENT_BLOCK_DECLS;
  ARGS;
  
  INPUT_EVENT;
  API_CALL;
  API_ACTION;
  ACTION_NAME;

  METHOD;
  CLASS;
  RECEIVER;
  RTYPE;
  
  SPEC;
}

@header {package droidsafe.speclang;
   import org.slf4j.Logger;
   import org.slf4j.LoggerFactory;}
@lexer::header {package droidsafe.speclang;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;}


@parser::members {
    private final static Logger logger = LoggerFactory.getLogger(DroidSafeParser.class);

    public void emitErrorMessage(String msg) {
        logger.error(msg);
    }
}

@lexer::members {
    private final static Logger logger = LoggerFactory.getLogger(DroidSafeLexer.class);

    public void emitErrorMessage(String msg) {
       logger.error(msg);
    }
}

spec 
	:
    whitelist
  	event_block* -> ^(SPEC whitelist ^(EVENT_BLOCK_DECLS event_block*))
  ;
  
whitelist
    : WHITELIST 
        LCURLY
        statement_list?
        RCURLY -> ^(WHITELIST ^(STMT_LIST statement_list?))
    ;

  
input_event 
  : receiver? cname=ID COLON rt=ID mname=ID LPAREN arg_list? RPAREN -> 
        ^(INPUT_EVENT  ^(RECEIVER receiver?) ^(CLASS $cname) ^(RTYPE $rt) ^(METHOD $mname) ^(ARGS arg_list?))
  ; 


boolean_value
  : TRUE -> ^(BOOLEAN_VALUE TRUE)
  | FALSE -> ^(BOOLEAN_VALUE FALSE)
  ;

class_value 
  : CLASS ID -> ID
  ;

concrete_value
  : boolean_value 
  | INT_LITERAL -> ^(INT_VALUE INT_LITERAL)
  | STRING_LITERAL -> ^(STRING_VALUE STRING_LITERAL)
  | CHAR_LITERAL -> ^(CHAR_VALUE CHAR_LITERAL)
  | class_value -> ^(CLASS_VALUE class_value)
  ;

concrete_value_list
  : concrete_value (OR_VAL concrete_value)* -> ^(CVALUE_LIST concrete_value+)
  ;
    
arg
  : ID -> ^(TYPE_VALUE ID)
    | concrete_value_list
  ;

arg_list
    :
    arg (COMMA arg)* -> arg+
    ;

receiver
    : ID  
    | INT_LITERAL
    ;

api_call 
  : receiver? cname=ID COLON rt=ID mname=ID LPAREN arg_list? RPAREN -> 
        ^(API_CALL ^(RECEIVER receiver?) ^(CLASS $cname) ^(RTYPE $rt) ^(METHOD $mname) ^(ARGS arg_list?))
  ;

api_action 
  : name=ID LPAREN arg_list? RPAREN -> ^(API_ACTION ^(ACTION_NAME $name) ^(ARGS arg_list?))
  ;

statement 
  : api_action SEMI -> api_action 
  | api_call SEMI -> api_call 
  ;
  
statement_list 
  : statement+ -> statement+;

event_block : 
   input_event 
        LCURLY 
        statement_list? 
        RCURLY 
        -> ^(EVENT_BLOCK input_event ^(STMT_LIST statement_list?))
  ;


ID  : ('a'..'z'|'A'..'Z'|'_'|'<'|'$') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'.' | '<' | '>' | '$'|'['|']')*
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
    
INT_LITERAL  :  ('-')? ('0'..'9')+
    ;
    
STRING_LITERAL
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR_LITERAL:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;
    
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
    
fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;
    
    
