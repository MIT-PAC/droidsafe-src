tree grammar SpecCreator;

options {
  language = Java;
  tokenVocab = DroidSafe;
  ASTLabelType = CommonTree;
}

@header {package droidsafe.speclang;
      import org.antlr.runtime.*;
      import java.util.HashMap;
      import java.util.LinkedList;
      import java.util.List;
      //import droidsafe.actionlang.*;
      //import droidsafe.actionlang.utils.*;
      import java.io.File;
      import org.slf4j.Logger;
      import org.slf4j.LoggerFactory;
      import droidsafe.android.system.API;
      import soot.NullType;
      import soot.RefLikeType;
      }

@members {
    private final static Logger logger = LoggerFactory.getLogger(SpecCreator.class);
	private SecuritySpecification spec;
	//private DroidActVocab actionDefs;
	private boolean singleMethodParse = false;

	public void setSecuritySpec(SecuritySpecification spec) {
		this.spec = spec;
	}

    public SecuritySpecification getSecuritySpec() {
        return spec;
    }
    
    public void initActions() {
        File avFile = null;
        try {
            avFile =  new File(System.getenv ("APAC_HOME"), "config-files/droidActions.txt");
            //actionDefs = new DroidActVocab(avFile.toString());  
        } catch (Exception e) {
            logger.error("Error opening or parsing actions definition file");
            System.exit(1);
        }
    }
    
    public void setSingleMethodParse() {
        singleMethodParse = true;
    }
}

spec 
	: {initActions();}
     ^(SPEC whitelist ^(EVENT_BLOCK_DECLS event_block*))
  	;


whitelist
    : 
     ^(WHITELIST ^(STMT_LIST statement_list?)) 
        {
            if ($statement_list.value != null) {
            	for (Method e : $statement_list.value) {
                	spec.addOutputEventToWhitelist(e);
            	}
            }
        }
    ;


input_event returns [Method value]
  	: {List<ArgumentValue> args = null; String rec = "";}
   	^(INPUT_EVENT  
            ^(RECEIVER (receiver {rec = $receiver.value;})?)
            ^(CLASS cname=ID) 
            ^(RTYPE rt=ID)
            ^(METHOD mname=ID ) 
            ^(ARGS (arg_list {args = $arg_list.value;})?)) 
        {       
            Method m = null;
            
            /** needs to change...            
            if (rec != null && !rec.equals("")) {
                m = new Method($cname.text, $rt.text, $mname.text, 
                				args != null ? args.toArray(new ArgumentValue[0]):new ArgumentValue[0], rec);
            } else {
                m = new Method($cname.text, $rt.text, $mname.text, 
                			args!=null?args.toArray(new ArgumentValue[0]):new ArgumentValue[0]);
            }
            */		
            $value = m;
        }       
  	; 

boolean_value returns [BooleanValue value]
    : ^(BOOLEAN_VALUE TRUE) { $value = BooleanValue.TRUE;}
    | ^(BOOLEAN_VALUE FALSE) { $value = BooleanValue.FALSE;}
    ;
    
class_value returns [ClassValue value]
  : ^(CLASS_VALUE cv=ID) {$value = new ClassValue($cv.text);}
  ;

concrete_value returns [ConcreteArgumentValue value]
  : ^(INT_VALUE INT_LITERAL) { $value = new IntValue(Integer.parseInt($INT_LITERAL.text)); }
  | ^(STRING_VALUE STRING_LITERAL) { $value = new StringValue($STRING_LITERAL.text.substring(1, $STRING_LITERAL.text.length()-1)); } 
  | ^(CHAR_VALUE CHAR_LITERAL) { $value = new CharValue($CHAR_LITERAL.text.charAt(1)); }
  |  boolean_value { $value = $boolean_value.value; } 
  | class_value {$value = $class_value.value;}
  ; 
    
concrete_values returns [ConcreteListArgumentValue value]
    : {ConcreteListArgumentValue ret = new ConcreteListArgumentValue(NullType.v());}
        ^(CVALUE_LIST
            (
                concrete_value {ret.add($concrete_value.value);}
            )+
        )
        {
            $value = ret;
        }
    ;

arg returns [ArgumentValue value]
  : ^(TYPE_VALUE ID) {$value = new TypeValue($ID.text);}
  | concrete_values {$value = $concrete_values.value;}
  ;

arg_list returns [List<ArgumentValue> value]
    : 
        {LinkedList<ArgumentValue> ret = new LinkedList<ArgumentValue>();}
        (
            arg {ret.add($arg.value);}
        )+
        { $value = ret;}
    ;

receiver returns [String value]
    : ID {$value = $ID.text;}
    | INT_LITERAL {$value = $INT_LITERAL.text;}
    ;

api_call returns [Method value]
  	: {List<ArgumentValue> args = null; String rec = "";}
   	^(API_CALL 
            ^(RECEIVER (receiver {rec = $receiver.value;})?)
            ^(CLASS cname=ID) 
            ^(RTYPE rt=ID)
            ^(METHOD mname=ID ) 
            ^(ARGS (arg_list {args = $arg_list.value;})?)) 
        {
            Method m = null;
            
            /**            
            if (rec != null && !rec.equals("")) {
                m = new Method($cname.text, $rt.text, $mname.text, 
                	args != null ? args.toArray(new ArgumentValue[0]) : new ArgumentValue[0], 
                	rec);
            } else {
                m = new Method($cname.text, $rt.text, $mname.text, 
                args!=null?args.toArray(new ArgumentValue[0]):new ArgumentValue[0]);
            }
            
            if (!m.checkValidSpecMethod()) {
                String msg = "Error: Not a valid method ";
                
                if (API.v().isBannedMethod(m.getSignature(true))) 
                    msg = "Error: Banned method ";
                     
                if (singleMethodParse)
                    logger.error(msg + "in Action File (sorry, don't have line):\n" + m + "\n");
                else {
                
                    logger.error(msg + "in the security specification on line " + $cname.getLine() + ":\n" + m + "\n");
                }
                System.exit(1);
            }
           
            m.setTypes(API.v().findSupportedMethod(m.getSignature(false)));
            */
            $value = m;
        }       
  	; 

api_action returns [List<Method> value]
  : 
        {
            List<ArgumentValue> args = new LinkedList<ArgumentValue>();
        }
            
        ^(API_ACTION 
          ^(ACTION_NAME name=ID) 
          ^(ARGS (arg_list {args = $arg_list.value;})?))
        {   
            $value = new LinkedList<Method>();
            logger.error("Actions not implemented in new DroidSafe.");
            System.exit(1);
        
            /*
            String actionName = $name.text;
            //args defined as the list
            
            String argsString = "";
            
            for (ArgumentValue arg : args) {
                argsString += (arg.toString() + ",");
            }
            
            if (argsString.length() > 0) 
                argsString = argsString.substring(0, argsString.length() - 1);
            
             
            String actionCall = actionName + "(" + argsString + ")";
            
            List<Method> methods = SpecIRHelpers.getMethods(actionDefs, actionCall);
            
            if (methods == null) {
                logger.error("Cannot find action: " + actionCall + " on line " + $name.getLine());
                System.exit(1);
            }
                
            for (Method m : methods)
                if (!m.checkValidSpecMethod()) {
                    logger.error("Not a valid method in Action " + $name.getLine() + ": " + $name.text);
                    System.exit(1);
                }     
                
            $value = methods;
            */    
        }
  ;

statement returns [List<Method> value]
  	:
        api_call {
            LinkedList<Method> methods = new LinkedList<Method>();
            methods.add($api_call.value);
            $value = methods;
        }
    |   api_action {
           $value = $api_action.value;
     }
  	;
  
statement_list returns [List<Method> value]
  	: 
        {LinkedList<Method> ret = new LinkedList<Method>();} 
        (statement {if ($statement.value != null) ret.addAll($statement.value);})+
        {$value = ret;}
 	;
  
event_block 
	: 
    ^(EVENT_BLOCK input_event ^(STMT_LIST statement_list?)) 
        {
            if ($statement_list.value != null)
                spec.addOutputEventToInputEvent($input_event.value, $statement_list.value);
        }

  	;
  

