// $ANTLR 3.4 /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g 2013-01-09 15:56:34
package droidsafe.speclang;
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
      

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SpecCreator extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION_NAME", "API_ACTION", "API_CALL", "ARGS", "BOOLEAN_VALUE", "CHAR_LITERAL", "CHAR_VALUE", "CLASS", "CLASS_VALUE", "COLON", "COMMA", "COMMENT", "CVALUE_LIST", "EQUAL", "ESC_SEQ", "EVENT_BLOCK", "EVENT_BLOCK_DECLS", "FALSE", "HEX_DIGIT", "ID", "INPUT_EVENT", "INT_LITERAL", "INT_VALUE", "LCURLY", "LPAREN", "METHOD", "OCTAL_ESC", "OR_VAL", "PLUS", "RCURLY", "RECEIVER", "RPAREN", "RTYPE", "SEMI", "SPEC", "STMT_LIST", "STRING_LITERAL", "STRING_VALUE", "TRUE", "TYPE_VALUE", "UNICODE_ESC", "WHITELIST", "WS"
    };

    public static final int EOF=-1;
    public static final int ACTION_NAME=4;
    public static final int API_ACTION=5;
    public static final int API_CALL=6;
    public static final int ARGS=7;
    public static final int BOOLEAN_VALUE=8;
    public static final int CHAR_LITERAL=9;
    public static final int CHAR_VALUE=10;
    public static final int CLASS=11;
    public static final int CLASS_VALUE=12;
    public static final int COLON=13;
    public static final int COMMA=14;
    public static final int COMMENT=15;
    public static final int CVALUE_LIST=16;
    public static final int EQUAL=17;
    public static final int ESC_SEQ=18;
    public static final int EVENT_BLOCK=19;
    public static final int EVENT_BLOCK_DECLS=20;
    public static final int FALSE=21;
    public static final int HEX_DIGIT=22;
    public static final int ID=23;
    public static final int INPUT_EVENT=24;
    public static final int INT_LITERAL=25;
    public static final int INT_VALUE=26;
    public static final int LCURLY=27;
    public static final int LPAREN=28;
    public static final int METHOD=29;
    public static final int OCTAL_ESC=30;
    public static final int OR_VAL=31;
    public static final int PLUS=32;
    public static final int RCURLY=33;
    public static final int RECEIVER=34;
    public static final int RPAREN=35;
    public static final int RTYPE=36;
    public static final int SEMI=37;
    public static final int SPEC=38;
    public static final int STMT_LIST=39;
    public static final int STRING_LITERAL=40;
    public static final int STRING_VALUE=41;
    public static final int TRUE=42;
    public static final int TYPE_VALUE=43;
    public static final int UNICODE_ESC=44;
    public static final int WHITELIST=45;
    public static final int WS=46;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public SpecCreator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public SpecCreator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return SpecCreator.tokenNames; }
    public String getGrammarFileName() { return "/Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g"; }


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



    // $ANTLR start "spec"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:52:1: spec : ^( SPEC whitelist ^( EVENT_BLOCK_DECLS ( event_block )* ) ) ;
    public final void spec() throws RecognitionException {
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:53:2: ( ^( SPEC whitelist ^( EVENT_BLOCK_DECLS ( event_block )* ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:53:4: ^( SPEC whitelist ^( EVENT_BLOCK_DECLS ( event_block )* ) )
            {
            initActions();

            match(input,SPEC,FOLLOW_SPEC_in_spec66); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_whitelist_in_spec68);
            whitelist();

            state._fsp--;


            match(input,EVENT_BLOCK_DECLS,FOLLOW_EVENT_BLOCK_DECLS_in_spec71); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:54:43: ( event_block )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==EVENT_BLOCK) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:54:43: event_block
                	    {
                	    pushFollow(FOLLOW_event_block_in_spec73);
                	    event_block();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "spec"



    // $ANTLR start "whitelist"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:58:1: whitelist : ^( WHITELIST ^( STMT_LIST ( statement_list )? ) ) ;
    public final void whitelist() throws RecognitionException {
        List<Method> statement_list1 =null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:59:5: ( ^( WHITELIST ^( STMT_LIST ( statement_list )? ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:60:6: ^( WHITELIST ^( STMT_LIST ( statement_list )? ) )
            {
            match(input,WHITELIST,FOLLOW_WHITELIST_in_whitelist100); 

            match(input, Token.DOWN, null); 
            match(input,STMT_LIST,FOLLOW_STMT_LIST_in_whitelist103); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:60:30: ( statement_list )?
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= API_ACTION && LA2_0 <= API_CALL)) ) {
                    alt2=1;
                }
                switch (alt2) {
                    case 1 :
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:60:30: statement_list
                        {
                        pushFollow(FOLLOW_statement_list_in_whitelist105);
                        statement_list1=statement_list();

                        state._fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 



                        if (statement_list1 != null) {
                        	for (Method e : statement_list1) {
                            	spec.addOutputEventToWhitelist(e);
                        	}
                        }
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "whitelist"



    // $ANTLR start "input_event"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:71:1: input_event returns [Method value] : ^( INPUT_EVENT ^( RECEIVER ( receiver )? ) ^( CLASS cname= ID ) ^( RTYPE rt= ID ) ^( METHOD mname= ID ) ^( ARGS ( arg_list )? ) ) ;
    public final Method input_event() throws RecognitionException {
        Method value = null;


        CommonTree cname=null;
        CommonTree rt=null;
        CommonTree mname=null;
        String receiver2 =null;

        List<ArgumentValue> arg_list3 =null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:72:4: ( ^( INPUT_EVENT ^( RECEIVER ( receiver )? ) ^( CLASS cname= ID ) ^( RTYPE rt= ID ) ^( METHOD mname= ID ) ^( ARGS ( arg_list )? ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:72:6: ^( INPUT_EVENT ^( RECEIVER ( receiver )? ) ^( CLASS cname= ID ) ^( RTYPE rt= ID ) ^( METHOD mname= ID ) ^( ARGS ( arg_list )? ) )
            {
            List<ArgumentValue> args = null; String rec = "";

            match(input,INPUT_EVENT,FOLLOW_INPUT_EVENT_in_input_event147); 

            match(input, Token.DOWN, null); 
            match(input,RECEIVER,FOLLOW_RECEIVER_in_input_event164); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:74:24: ( receiver )?
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ID||LA3_0==INT_LITERAL) ) {
                    alt3=1;
                }
                switch (alt3) {
                    case 1 :
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:74:25: receiver
                        {
                        pushFollow(FOLLOW_receiver_in_input_event167);
                        receiver2=receiver();

                        state._fsp--;


                        rec = receiver2;

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input,CLASS,FOLLOW_CLASS_in_input_event187); 

            match(input, Token.DOWN, null); 
            cname=(CommonTree)match(input,ID,FOLLOW_ID_in_input_event191); 

            match(input, Token.UP, null); 


            match(input,RTYPE,FOLLOW_RTYPE_in_input_event208); 

            match(input, Token.DOWN, null); 
            rt=(CommonTree)match(input,ID,FOLLOW_ID_in_input_event212); 

            match(input, Token.UP, null); 


            match(input,METHOD,FOLLOW_METHOD_in_input_event228); 

            match(input, Token.DOWN, null); 
            mname=(CommonTree)match(input,ID,FOLLOW_ID_in_input_event232); 

            match(input, Token.UP, null); 


            match(input,ARGS,FOLLOW_ARGS_in_input_event250); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:78:20: ( arg_list )?
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==CVALUE_LIST||LA4_0==TYPE_VALUE) ) {
                    alt4=1;
                }
                switch (alt4) {
                    case 1 :
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:78:21: arg_list
                        {
                        pushFollow(FOLLOW_arg_list_in_input_event253);
                        arg_list3=arg_list();

                        state._fsp--;


                        args = arg_list3;

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


                   
                        Method m = null;
                        
                                    
                        if (rec != null && !rec.equals("")) {
                            m = new Method((cname!=null?cname.getText():null), (rt!=null?rt.getText():null), (mname!=null?mname.getText():null), 
                            				args != null ? args.toArray(new ArgumentValue[0]):new ArgumentValue[0], rec);
                        } else {
                            m = new Method((cname!=null?cname.getText():null), (rt!=null?rt.getText():null), (mname!=null?mname.getText():null), 
                            			args!=null?args.toArray(new ArgumentValue[0]):new ArgumentValue[0]);
                        }		
                        value = m;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "input_event"



    // $ANTLR start "boolean_value"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:94:1: boolean_value returns [BooleanValue value] : ( ^( BOOLEAN_VALUE TRUE ) | ^( BOOLEAN_VALUE FALSE ) );
    public final BooleanValue boolean_value() throws RecognitionException {
        BooleanValue value = null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:95:5: ( ^( BOOLEAN_VALUE TRUE ) | ^( BOOLEAN_VALUE FALSE ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==BOOLEAN_VALUE) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==DOWN) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==TRUE) ) {
                        alt5=1;
                    }
                    else if ( (LA5_2==FALSE) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:95:7: ^( BOOLEAN_VALUE TRUE )
                    {
                    match(input,BOOLEAN_VALUE,FOLLOW_BOOLEAN_VALUE_in_boolean_value299); 

                    match(input, Token.DOWN, null); 
                    match(input,TRUE,FOLLOW_TRUE_in_boolean_value301); 

                    match(input, Token.UP, null); 


                     value = BooleanValue.TRUE;

                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:96:7: ^( BOOLEAN_VALUE FALSE )
                    {
                    match(input,BOOLEAN_VALUE,FOLLOW_BOOLEAN_VALUE_in_boolean_value313); 

                    match(input, Token.DOWN, null); 
                    match(input,FALSE,FOLLOW_FALSE_in_boolean_value315); 

                    match(input, Token.UP, null); 


                     value = BooleanValue.FALSE;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "boolean_value"



    // $ANTLR start "class_value"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:99:1: class_value returns [ClassValue value] : ^( CLASS_VALUE cv= ID ) ;
    public final ClassValue class_value() throws RecognitionException {
        ClassValue value = null;


        CommonTree cv=null;

        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:100:3: ( ^( CLASS_VALUE cv= ID ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:100:5: ^( CLASS_VALUE cv= ID )
            {
            match(input,CLASS_VALUE,FOLLOW_CLASS_VALUE_in_class_value342); 

            match(input, Token.DOWN, null); 
            cv=(CommonTree)match(input,ID,FOLLOW_ID_in_class_value346); 

            match(input, Token.UP, null); 


            value = new ClassValue((cv!=null?cv.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "class_value"



    // $ANTLR start "concrete_value"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:103:1: concrete_value returns [ConcreteArgumentValue value] : ( ^( INT_VALUE INT_LITERAL ) | ^( STRING_VALUE STRING_LITERAL ) | ^( CHAR_VALUE CHAR_LITERAL ) | boolean_value | class_value );
    public final ConcreteArgumentValue concrete_value() throws RecognitionException {
        ConcreteArgumentValue value = null;


        CommonTree INT_LITERAL4=null;
        CommonTree STRING_LITERAL5=null;
        CommonTree CHAR_LITERAL6=null;
        BooleanValue boolean_value7 =null;

        ClassValue class_value8 =null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:104:3: ( ^( INT_VALUE INT_LITERAL ) | ^( STRING_VALUE STRING_LITERAL ) | ^( CHAR_VALUE CHAR_LITERAL ) | boolean_value | class_value )
            int alt6=5;
            switch ( input.LA(1) ) {
            case INT_VALUE:
                {
                alt6=1;
                }
                break;
            case STRING_VALUE:
                {
                alt6=2;
                }
                break;
            case CHAR_VALUE:
                {
                alt6=3;
                }
                break;
            case BOOLEAN_VALUE:
                {
                alt6=4;
                }
                break;
            case CLASS_VALUE:
                {
                alt6=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:104:5: ^( INT_VALUE INT_LITERAL )
                    {
                    match(input,INT_VALUE,FOLLOW_INT_VALUE_in_concrete_value367); 

                    match(input, Token.DOWN, null); 
                    INT_LITERAL4=(CommonTree)match(input,INT_LITERAL,FOLLOW_INT_LITERAL_in_concrete_value369); 

                    match(input, Token.UP, null); 


                     value = new IntValue(Integer.parseInt((INT_LITERAL4!=null?INT_LITERAL4.getText():null))); 

                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:105:5: ^( STRING_VALUE STRING_LITERAL )
                    {
                    match(input,STRING_VALUE,FOLLOW_STRING_VALUE_in_concrete_value379); 

                    match(input, Token.DOWN, null); 
                    STRING_LITERAL5=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_concrete_value381); 

                    match(input, Token.UP, null); 


                     value = new StringValue((STRING_LITERAL5!=null?STRING_LITERAL5.getText():null).substring(1, (STRING_LITERAL5!=null?STRING_LITERAL5.getText():null).length()-1)); 

                    }
                    break;
                case 3 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:106:5: ^( CHAR_VALUE CHAR_LITERAL )
                    {
                    match(input,CHAR_VALUE,FOLLOW_CHAR_VALUE_in_concrete_value392); 

                    match(input, Token.DOWN, null); 
                    CHAR_LITERAL6=(CommonTree)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_concrete_value394); 

                    match(input, Token.UP, null); 


                     value = new CharValue((CHAR_LITERAL6!=null?CHAR_LITERAL6.getText():null).charAt(1)); 

                    }
                    break;
                case 4 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:107:6: boolean_value
                    {
                    pushFollow(FOLLOW_boolean_value_in_concrete_value404);
                    boolean_value7=boolean_value();

                    state._fsp--;


                     value = boolean_value7; 

                    }
                    break;
                case 5 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:108:5: class_value
                    {
                    pushFollow(FOLLOW_class_value_in_concrete_value413);
                    class_value8=class_value();

                    state._fsp--;


                    value = class_value8;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "concrete_value"



    // $ANTLR start "concrete_values"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:111:1: concrete_values returns [ConcreteListArgumentValue value] : ^( CVALUE_LIST ( concrete_value )+ ) ;
    public final ConcreteListArgumentValue concrete_values() throws RecognitionException {
        ConcreteListArgumentValue value = null;


        ConcreteArgumentValue concrete_value9 =null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:112:5: ( ^( CVALUE_LIST ( concrete_value )+ ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:112:7: ^( CVALUE_LIST ( concrete_value )+ )
            {
            ConcreteListArgumentValue ret = new ConcreteListArgumentValue();

            match(input,CVALUE_LIST,FOLLOW_CVALUE_LIST_in_concrete_values450); 

            match(input, Token.DOWN, null); 
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:114:13: ( concrete_value )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==BOOLEAN_VALUE||LA7_0==CHAR_VALUE||LA7_0==CLASS_VALUE||LA7_0==INT_VALUE||LA7_0==STRING_VALUE) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:115:17: concrete_value
            	    {
            	    pushFollow(FOLLOW_concrete_value_in_concrete_values482);
            	    concrete_value9=concrete_value();

            	    state._fsp--;


            	    ret.add(concrete_value9);

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            match(input, Token.UP, null); 



                        ret.checkAllOneType();
                        value = ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "concrete_values"



    // $ANTLR start "arg"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:124:1: arg returns [ArgumentValue value] : ( ^( TYPE_VALUE ID ) | concrete_values );
    public final ArgumentValue arg() throws RecognitionException {
        ArgumentValue value = null;


        CommonTree ID10=null;
        ConcreteListArgumentValue concrete_values11 =null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:125:3: ( ^( TYPE_VALUE ID ) | concrete_values )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==TYPE_VALUE) ) {
                alt8=1;
            }
            else if ( (LA8_0==CVALUE_LIST) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:125:5: ^( TYPE_VALUE ID )
                    {
                    match(input,TYPE_VALUE,FOLLOW_TYPE_VALUE_in_arg539); 

                    match(input, Token.DOWN, null); 
                    ID10=(CommonTree)match(input,ID,FOLLOW_ID_in_arg541); 

                    match(input, Token.UP, null); 


                    value = new TypeValue((ID10!=null?ID10.getText():null));

                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:126:5: concrete_values
                    {
                    pushFollow(FOLLOW_concrete_values_in_arg550);
                    concrete_values11=concrete_values();

                    state._fsp--;


                    value = concrete_values11;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "arg"



    // $ANTLR start "arg_list"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:129:1: arg_list returns [List<ArgumentValue> value] : ( arg )+ ;
    public final List<ArgumentValue> arg_list() throws RecognitionException {
        List<ArgumentValue> value = null;


        ArgumentValue arg12 =null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:130:5: ( ( arg )+ )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:131:9: ( arg )+
            {
            LinkedList<ArgumentValue> ret = new LinkedList<ArgumentValue>();

            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:132:9: ( arg )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==CVALUE_LIST||LA9_0==TYPE_VALUE) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:133:13: arg
            	    {
            	    pushFollow(FOLLOW_arg_in_arg_list604);
            	    arg12=arg();

            	    state._fsp--;


            	    ret.add(arg12);

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


             value = ret;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "arg_list"



    // $ANTLR start "receiver"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:138:1: receiver returns [String value] : ( ID | INT_LITERAL );
    public final String receiver() throws RecognitionException {
        String value = null;


        CommonTree ID13=null;
        CommonTree INT_LITERAL14=null;

        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:139:5: ( ID | INT_LITERAL )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ID) ) {
                alt10=1;
            }
            else if ( (LA10_0==INT_LITERAL) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:139:7: ID
                    {
                    ID13=(CommonTree)match(input,ID,FOLLOW_ID_in_receiver648); 

                    value = (ID13!=null?ID13.getText():null);

                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:140:7: INT_LITERAL
                    {
                    INT_LITERAL14=(CommonTree)match(input,INT_LITERAL,FOLLOW_INT_LITERAL_in_receiver658); 

                    value = (INT_LITERAL14!=null?INT_LITERAL14.getText():null);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "receiver"



    // $ANTLR start "api_call"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:143:1: api_call returns [Method value] : ^( API_CALL ^( RECEIVER ( receiver )? ) ^( CLASS cname= ID ) ^( RTYPE rt= ID ) ^( METHOD mname= ID ) ^( ARGS ( arg_list )? ) ) ;
    public final Method api_call() throws RecognitionException {
        Method value = null;


        CommonTree cname=null;
        CommonTree rt=null;
        CommonTree mname=null;
        String receiver15 =null;

        List<ArgumentValue> arg_list16 =null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:144:4: ( ^( API_CALL ^( RECEIVER ( receiver )? ) ^( CLASS cname= ID ) ^( RTYPE rt= ID ) ^( METHOD mname= ID ) ^( ARGS ( arg_list )? ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:144:6: ^( API_CALL ^( RECEIVER ( receiver )? ) ^( CLASS cname= ID ) ^( RTYPE rt= ID ) ^( METHOD mname= ID ) ^( ARGS ( arg_list )? ) )
            {
            List<ArgumentValue> args = null; String rec = "";

            match(input,API_CALL,FOLLOW_API_CALL_in_api_call687); 

            match(input, Token.DOWN, null); 
            match(input,RECEIVER,FOLLOW_RECEIVER_in_api_call703); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:146:24: ( receiver )?
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==ID||LA11_0==INT_LITERAL) ) {
                    alt11=1;
                }
                switch (alt11) {
                    case 1 :
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:146:25: receiver
                        {
                        pushFollow(FOLLOW_receiver_in_api_call706);
                        receiver15=receiver();

                        state._fsp--;


                        rec = receiver15;

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input,CLASS,FOLLOW_CLASS_in_api_call726); 

            match(input, Token.DOWN, null); 
            cname=(CommonTree)match(input,ID,FOLLOW_ID_in_api_call730); 

            match(input, Token.UP, null); 


            match(input,RTYPE,FOLLOW_RTYPE_in_api_call747); 

            match(input, Token.DOWN, null); 
            rt=(CommonTree)match(input,ID,FOLLOW_ID_in_api_call751); 

            match(input, Token.UP, null); 


            match(input,METHOD,FOLLOW_METHOD_in_api_call767); 

            match(input, Token.DOWN, null); 
            mname=(CommonTree)match(input,ID,FOLLOW_ID_in_api_call771); 

            match(input, Token.UP, null); 


            match(input,ARGS,FOLLOW_ARGS_in_api_call789); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:150:20: ( arg_list )?
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==CVALUE_LIST||LA12_0==TYPE_VALUE) ) {
                    alt12=1;
                }
                switch (alt12) {
                    case 1 :
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:150:21: arg_list
                        {
                        pushFollow(FOLLOW_arg_list_in_api_call792);
                        arg_list16=arg_list();

                        state._fsp--;


                        args = arg_list16;

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 



                        Method m = null;
                        
                                    
                        if (rec != null && !rec.equals("")) {
                            m = new Method((cname!=null?cname.getText():null), (rt!=null?rt.getText():null), (mname!=null?mname.getText():null), 
                            	args != null ? args.toArray(new ArgumentValue[0]) : new ArgumentValue[0], 
                            	rec);
                        } else {
                            m = new Method((cname!=null?cname.getText():null), (rt!=null?rt.getText():null), (mname!=null?mname.getText():null), 
                            args!=null?args.toArray(new ArgumentValue[0]):new ArgumentValue[0]);
                        }
                        
                        if (!m.checkValidSpecMethod()) {
                            String msg = "Error: Not a valid method ";
                            
                            if (API.v().isBannedMethod(m.toDroidBlazeString(true))) 
                                msg = "Error: Banned method ";
                                 
                            if (singleMethodParse)
                                logger.error(msg + "in Action File (sorry, don't have line):\n" + m + "\n");
                            else {
                            
                                logger.error(msg + "in the security specification on line " + cname.getLine() + ":\n" + m + "\n");
                            }
                            System.exit(1);
                        }
                       
                        m.setTypes(API.v().findSupportedMethod(m.getSignature(false)));
                        
                        value = m;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "api_call"



    // $ANTLR start "api_action"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:185:1: api_action returns [List<Method> value] : ^( API_ACTION ^( ACTION_NAME name= ID ) ^( ARGS ( arg_list )? ) ) ;
    public final List<Method> api_action() throws RecognitionException {
        List<Method> value = null;


        CommonTree name=null;
        List<ArgumentValue> arg_list17 =null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:186:3: ( ^( API_ACTION ^( ACTION_NAME name= ID ) ^( ARGS ( arg_list )? ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:187:9: ^( API_ACTION ^( ACTION_NAME name= ID ) ^( ARGS ( arg_list )? ) )
            {

                        List<ArgumentValue> args = new LinkedList<ArgumentValue>();
                    

            match(input,API_ACTION,FOLLOW_API_ACTION_in_api_action868); 

            match(input, Token.DOWN, null); 
            match(input,ACTION_NAME,FOLLOW_ACTION_NAME_in_api_action882); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,ID,FOLLOW_ID_in_api_action886); 

            match(input, Token.UP, null); 


            match(input,ARGS,FOLLOW_ARGS_in_api_action901); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:193:18: ( arg_list )?
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==CVALUE_LIST||LA13_0==TYPE_VALUE) ) {
                    alt13=1;
                }
                switch (alt13) {
                    case 1 :
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:193:19: arg_list
                        {
                        pushFollow(FOLLOW_arg_list_in_api_action904);
                        arg_list17=arg_list();

                        state._fsp--;


                        args = arg_list17;

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


               
                        value = new LinkedList<Method>();
                        logger.error("Actions not implemented in new DroidSafe.");
                        System.exit(1);
                    
                        /*
                        String actionName = (name!=null?name.getText():null);
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
                            logger.error("Cannot find action: " + actionCall + " on line " + name.getLine());
                            System.exit(1);
                        }
                            
                        for (Method m : methods)
                            if (!m.checkValidSpecMethod()) {
                                logger.error("Not a valid method in Action " + name.getLine() + ": " + (name!=null?name.getText():null));
                                System.exit(1);
                            }     
                            
                        value = methods;
                        */    
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "api_action"



    // $ANTLR start "statement"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:233:1: statement returns [List<Method> value] : ( api_call | api_action );
    public final List<Method> statement() throws RecognitionException {
        List<Method> value = null;


        Method api_call18 =null;

        List<Method> api_action19 =null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:234:4: ( api_call | api_action )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==API_CALL) ) {
                alt14=1;
            }
            else if ( (LA14_0==API_ACTION) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:235:9: api_call
                    {
                    pushFollow(FOLLOW_api_call_in_statement946);
                    api_call18=api_call();

                    state._fsp--;



                                LinkedList<Method> methods = new LinkedList<Method>();
                                methods.add(api_call18);
                                value = methods;
                            

                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:240:9: api_action
                    {
                    pushFollow(FOLLOW_api_action_in_statement958);
                    api_action19=api_action();

                    state._fsp--;



                               value = api_action19;
                         

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "statement"



    // $ANTLR start "statement_list"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:245:1: statement_list returns [List<Method> value] : ( statement )+ ;
    public final List<Method> statement_list() throws RecognitionException {
        List<Method> value = null;


        List<Method> statement20 =null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:246:4: ( ( statement )+ )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:247:9: ( statement )+
            {
            LinkedList<Method> ret = new LinkedList<Method>();

            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:248:9: ( statement )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0 >= API_ACTION && LA15_0 <= API_CALL)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:248:10: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statement_list1002);
            	    statement20=statement();

            	    state._fsp--;


            	    if (statement20 != null) ret.addAll(statement20);

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            value = ret;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "statement_list"



    // $ANTLR start "event_block"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:252:1: event_block : ^( EVENT_BLOCK input_event ^( STMT_LIST ( statement_list )? ) ) ;
    public final void event_block() throws RecognitionException {
        List<Method> statement_list21 =null;

        Method input_event22 =null;


        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:253:2: ( ^( EVENT_BLOCK input_event ^( STMT_LIST ( statement_list )? ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:254:5: ^( EVENT_BLOCK input_event ^( STMT_LIST ( statement_list )? ) )
            {
            match(input,EVENT_BLOCK,FOLLOW_EVENT_BLOCK_in_event_block1037); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_input_event_in_event_block1039);
            input_event22=input_event();

            state._fsp--;


            match(input,STMT_LIST,FOLLOW_STMT_LIST_in_event_block1042); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:254:43: ( statement_list )?
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= API_ACTION && LA16_0 <= API_CALL)) ) {
                    alt16=1;
                }
                switch (alt16) {
                    case 1 :
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/SpecCreator.g:254:43: statement_list
                        {
                        pushFollow(FOLLOW_statement_list_in_event_block1044);
                        statement_list21=statement_list();

                        state._fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 



                        if (statement_list21 != null)
                            spec.addToInputEvent(input_event22, statement_list21);
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "event_block"

    // Delegated rules


 

    public static final BitSet FOLLOW_SPEC_in_spec66 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_whitelist_in_spec68 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_EVENT_BLOCK_DECLS_in_spec71 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_event_block_in_spec73 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_WHITELIST_in_whitelist100 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STMT_LIST_in_whitelist103 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_list_in_whitelist105 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_EVENT_in_input_event147 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_RECEIVER_in_input_event164 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_receiver_in_input_event167 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLASS_in_input_event187 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_input_event191 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RTYPE_in_input_event208 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_input_event212 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_METHOD_in_input_event228 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_input_event232 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_input_event250 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arg_list_in_input_event253 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOOLEAN_VALUE_in_boolean_value299 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TRUE_in_boolean_value301 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOOLEAN_VALUE_in_boolean_value313 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FALSE_in_boolean_value315 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLASS_VALUE_in_class_value342 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_class_value346 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_VALUE_in_concrete_value367 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_LITERAL_in_concrete_value369 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_VALUE_in_concrete_value379 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_concrete_value381 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_VALUE_in_concrete_value392 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_concrete_value394 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_boolean_value_in_concrete_value404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_value_in_concrete_value413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CVALUE_LIST_in_concrete_values450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_concrete_value_in_concrete_values482 = new BitSet(new long[]{0x0000020004001508L});
    public static final BitSet FOLLOW_TYPE_VALUE_in_arg539 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_arg541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_concrete_values_in_arg550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arg_in_arg_list604 = new BitSet(new long[]{0x0000080000010002L});
    public static final BitSet FOLLOW_ID_in_receiver648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_LITERAL_in_receiver658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_API_CALL_in_api_call687 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_RECEIVER_in_api_call703 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_receiver_in_api_call706 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLASS_in_api_call726 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_api_call730 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RTYPE_in_api_call747 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_api_call751 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_METHOD_in_api_call767 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_api_call771 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_api_call789 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arg_list_in_api_call792 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_API_ACTION_in_api_action868 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_NAME_in_api_action882 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_api_action886 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_api_action901 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arg_list_in_api_action904 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_api_call_in_statement946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_api_action_in_statement958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statement_list1002 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_EVENT_BLOCK_in_event_block1037 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_input_event_in_event_block1039 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_STMT_LIST_in_event_block1042 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_list_in_event_block1044 = new BitSet(new long[]{0x0000000000000008L});

}