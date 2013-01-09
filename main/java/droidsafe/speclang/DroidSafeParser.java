// $ANTLR 3.4 /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g 2013-01-09 15:50:21
package droidsafe.speclang;
   import org.slf4j.Logger;
   import org.slf4j.LoggerFactory;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class DroidSafeParser extends Parser {
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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public DroidSafeParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public DroidSafeParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return DroidSafeParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g"; }


        private final static Logger logger = LoggerFactory.getLogger(DroidSafeParser.class);

        public void emitErrorMessage(String msg) {
            logger.error(msg);
        }


    public static class spec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "spec"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:76:1: spec : whitelist ( event_block )* -> ^( SPEC whitelist ^( EVENT_BLOCK_DECLS ( event_block )* ) ) ;
    public final DroidSafeParser.spec_return spec() throws RecognitionException {
        DroidSafeParser.spec_return retval = new DroidSafeParser.spec_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        DroidSafeParser.whitelist_return whitelist1 =null;

        DroidSafeParser.event_block_return event_block2 =null;


        RewriteRuleSubtreeStream stream_event_block=new RewriteRuleSubtreeStream(adaptor,"rule event_block");
        RewriteRuleSubtreeStream stream_whitelist=new RewriteRuleSubtreeStream(adaptor,"rule whitelist");
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:77:2: ( whitelist ( event_block )* -> ^( SPEC whitelist ^( EVENT_BLOCK_DECLS ( event_block )* ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:78:5: whitelist ( event_block )*
            {
            pushFollow(FOLLOW_whitelist_in_spec319);
            whitelist1=whitelist();

            state._fsp--;

            stream_whitelist.add(whitelist1.getTree());

            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:79:4: ( event_block )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==INT_LITERAL) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:79:4: event_block
            	    {
            	    pushFollow(FOLLOW_event_block_in_spec324);
            	    event_block2=event_block();

            	    state._fsp--;

            	    stream_event_block.add(event_block2.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // AST REWRITE
            // elements: event_block, whitelist
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 79:17: -> ^( SPEC whitelist ^( EVENT_BLOCK_DECLS ( event_block )* ) )
            {
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:79:20: ^( SPEC whitelist ^( EVENT_BLOCK_DECLS ( event_block )* ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(SPEC, "SPEC")
                , root_1);

                adaptor.addChild(root_1, stream_whitelist.nextTree());

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:79:37: ^( EVENT_BLOCK_DECLS ( event_block )* )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(EVENT_BLOCK_DECLS, "EVENT_BLOCK_DECLS")
                , root_2);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:79:57: ( event_block )*
                while ( stream_event_block.hasNext() ) {
                    adaptor.addChild(root_2, stream_event_block.nextTree());

                }
                stream_event_block.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "spec"


    public static class whitelist_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "whitelist"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:82:1: whitelist : WHITELIST LCURLY ( statement_list )? RCURLY -> ^( WHITELIST ^( STMT_LIST ( statement_list )? ) ) ;
    public final DroidSafeParser.whitelist_return whitelist() throws RecognitionException {
        DroidSafeParser.whitelist_return retval = new DroidSafeParser.whitelist_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token WHITELIST3=null;
        Token LCURLY4=null;
        Token RCURLY6=null;
        DroidSafeParser.statement_list_return statement_list5 =null;


        Object WHITELIST3_tree=null;
        Object LCURLY4_tree=null;
        Object RCURLY6_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_WHITELIST=new RewriteRuleTokenStream(adaptor,"token WHITELIST");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_statement_list=new RewriteRuleSubtreeStream(adaptor,"rule statement_list");
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:83:5: ( WHITELIST LCURLY ( statement_list )? RCURLY -> ^( WHITELIST ^( STMT_LIST ( statement_list )? ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:83:7: WHITELIST LCURLY ( statement_list )? RCURLY
            {
            WHITELIST3=(Token)match(input,WHITELIST,FOLLOW_WHITELIST_in_whitelist357);  
            stream_WHITELIST.add(WHITELIST3);


            LCURLY4=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_whitelist368);  
            stream_LCURLY.add(LCURLY4);


            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:85:9: ( statement_list )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID||LA2_0==INT_LITERAL) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:85:9: statement_list
                    {
                    pushFollow(FOLLOW_statement_list_in_whitelist378);
                    statement_list5=statement_list();

                    state._fsp--;

                    stream_statement_list.add(statement_list5.getTree());

                    }
                    break;

            }


            RCURLY6=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_whitelist389);  
            stream_RCURLY.add(RCURLY6);


            // AST REWRITE
            // elements: WHITELIST, statement_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 86:16: -> ^( WHITELIST ^( STMT_LIST ( statement_list )? ) )
            {
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:86:19: ^( WHITELIST ^( STMT_LIST ( statement_list )? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_WHITELIST.nextNode()
                , root_1);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:86:31: ^( STMT_LIST ( statement_list )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(STMT_LIST, "STMT_LIST")
                , root_2);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:86:43: ( statement_list )?
                if ( stream_statement_list.hasNext() ) {
                    adaptor.addChild(root_2, stream_statement_list.nextTree());

                }
                stream_statement_list.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "whitelist"


    public static class input_event_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_event"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:90:1: input_event : ( receiver )? cname= ID COLON rt= ID mname= ID LPAREN ( arg_list )? RPAREN -> ^( INPUT_EVENT ^( RECEIVER ( receiver )? ) ^( CLASS $cname) ^( RTYPE $rt) ^( METHOD $mname) ^( ARGS ( arg_list )? ) ) ;
    public final DroidSafeParser.input_event_return input_event() throws RecognitionException {
        DroidSafeParser.input_event_return retval = new DroidSafeParser.input_event_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token cname=null;
        Token rt=null;
        Token mname=null;
        Token COLON8=null;
        Token LPAREN9=null;
        Token RPAREN11=null;
        DroidSafeParser.receiver_return receiver7 =null;

        DroidSafeParser.arg_list_return arg_list10 =null;


        Object cname_tree=null;
        Object rt_tree=null;
        Object mname_tree=null;
        Object COLON8_tree=null;
        Object LPAREN9_tree=null;
        Object RPAREN11_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_arg_list=new RewriteRuleSubtreeStream(adaptor,"rule arg_list");
        RewriteRuleSubtreeStream stream_receiver=new RewriteRuleSubtreeStream(adaptor,"rule receiver");
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:91:3: ( ( receiver )? cname= ID COLON rt= ID mname= ID LPAREN ( arg_list )? RPAREN -> ^( INPUT_EVENT ^( RECEIVER ( receiver )? ) ^( CLASS $cname) ^( RTYPE $rt) ^( METHOD $mname) ^( ARGS ( arg_list )? ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:91:5: ( receiver )? cname= ID COLON rt= ID mname= ID LPAREN ( arg_list )? RPAREN
            {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:91:5: ( receiver )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==ID) ) {
                    alt3=1;
                }
            }
            else if ( (LA3_0==INT_LITERAL) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:91:5: receiver
                    {
                    pushFollow(FOLLOW_receiver_in_input_event421);
                    receiver7=receiver();

                    state._fsp--;

                    stream_receiver.add(receiver7.getTree());

                    }
                    break;

            }


            cname=(Token)match(input,ID,FOLLOW_ID_in_input_event426);  
            stream_ID.add(cname);


            COLON8=(Token)match(input,COLON,FOLLOW_COLON_in_input_event428);  
            stream_COLON.add(COLON8);


            rt=(Token)match(input,ID,FOLLOW_ID_in_input_event432);  
            stream_ID.add(rt);


            mname=(Token)match(input,ID,FOLLOW_ID_in_input_event436);  
            stream_ID.add(mname);


            LPAREN9=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_input_event438);  
            stream_LPAREN.add(LPAREN9);


            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:91:52: ( arg_list )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==CHAR_LITERAL||LA4_0==CLASS||LA4_0==FALSE||LA4_0==ID||LA4_0==INT_LITERAL||LA4_0==STRING_LITERAL||LA4_0==TRUE) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:91:52: arg_list
                    {
                    pushFollow(FOLLOW_arg_list_in_input_event440);
                    arg_list10=arg_list();

                    state._fsp--;

                    stream_arg_list.add(arg_list10.getTree());

                    }
                    break;

            }


            RPAREN11=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_input_event443);  
            stream_RPAREN.add(RPAREN11);


            // AST REWRITE
            // elements: arg_list, rt, mname, cname, receiver
            // token labels: mname, rt, cname
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_mname=new RewriteRuleTokenStream(adaptor,"token mname",mname);
            RewriteRuleTokenStream stream_rt=new RewriteRuleTokenStream(adaptor,"token rt",rt);
            RewriteRuleTokenStream stream_cname=new RewriteRuleTokenStream(adaptor,"token cname",cname);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 91:69: -> ^( INPUT_EVENT ^( RECEIVER ( receiver )? ) ^( CLASS $cname) ^( RTYPE $rt) ^( METHOD $mname) ^( ARGS ( arg_list )? ) )
            {
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:92:9: ^( INPUT_EVENT ^( RECEIVER ( receiver )? ) ^( CLASS $cname) ^( RTYPE $rt) ^( METHOD $mname) ^( ARGS ( arg_list )? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(INPUT_EVENT, "INPUT_EVENT")
                , root_1);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:92:24: ^( RECEIVER ( receiver )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(RECEIVER, "RECEIVER")
                , root_2);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:92:35: ( receiver )?
                if ( stream_receiver.hasNext() ) {
                    adaptor.addChild(root_2, stream_receiver.nextTree());

                }
                stream_receiver.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:92:46: ^( CLASS $cname)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CLASS, "CLASS")
                , root_2);

                adaptor.addChild(root_2, stream_cname.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:92:62: ^( RTYPE $rt)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(RTYPE, "RTYPE")
                , root_2);

                adaptor.addChild(root_2, stream_rt.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:92:75: ^( METHOD $mname)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(METHOD, "METHOD")
                , root_2);

                adaptor.addChild(root_2, stream_mname.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:92:92: ^( ARGS ( arg_list )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(ARGS, "ARGS")
                , root_2);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:92:99: ( arg_list )?
                if ( stream_arg_list.hasNext() ) {
                    adaptor.addChild(root_2, stream_arg_list.nextTree());

                }
                stream_arg_list.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "input_event"


    public static class boolean_value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "boolean_value"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:96:1: boolean_value : ( TRUE -> ^( BOOLEAN_VALUE TRUE ) | FALSE -> ^( BOOLEAN_VALUE FALSE ) );
    public final DroidSafeParser.boolean_value_return boolean_value() throws RecognitionException {
        DroidSafeParser.boolean_value_return retval = new DroidSafeParser.boolean_value_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token TRUE12=null;
        Token FALSE13=null;

        Object TRUE12_tree=null;
        Object FALSE13_tree=null;
        RewriteRuleTokenStream stream_FALSE=new RewriteRuleTokenStream(adaptor,"token FALSE");
        RewriteRuleTokenStream stream_TRUE=new RewriteRuleTokenStream(adaptor,"token TRUE");

        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:97:3: ( TRUE -> ^( BOOLEAN_VALUE TRUE ) | FALSE -> ^( BOOLEAN_VALUE FALSE ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==TRUE) ) {
                alt5=1;
            }
            else if ( (LA5_0==FALSE) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:97:5: TRUE
                    {
                    TRUE12=(Token)match(input,TRUE,FOLLOW_TRUE_in_boolean_value509);  
                    stream_TRUE.add(TRUE12);


                    // AST REWRITE
                    // elements: TRUE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 97:10: -> ^( BOOLEAN_VALUE TRUE )
                    {
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:97:13: ^( BOOLEAN_VALUE TRUE )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(BOOLEAN_VALUE, "BOOLEAN_VALUE")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_TRUE.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:98:5: FALSE
                    {
                    FALSE13=(Token)match(input,FALSE,FOLLOW_FALSE_in_boolean_value523);  
                    stream_FALSE.add(FALSE13);


                    // AST REWRITE
                    // elements: FALSE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 98:11: -> ^( BOOLEAN_VALUE FALSE )
                    {
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:98:14: ^( BOOLEAN_VALUE FALSE )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(BOOLEAN_VALUE, "BOOLEAN_VALUE")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_FALSE.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "boolean_value"


    public static class class_value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "class_value"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:101:1: class_value : CLASS ID -> ID ;
    public final DroidSafeParser.class_value_return class_value() throws RecognitionException {
        DroidSafeParser.class_value_return retval = new DroidSafeParser.class_value_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token CLASS14=null;
        Token ID15=null;

        Object CLASS14_tree=null;
        Object ID15_tree=null;
        RewriteRuleTokenStream stream_CLASS=new RewriteRuleTokenStream(adaptor,"token CLASS");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:102:3: ( CLASS ID -> ID )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:102:5: CLASS ID
            {
            CLASS14=(Token)match(input,CLASS,FOLLOW_CLASS_in_class_value545);  
            stream_CLASS.add(CLASS14);


            ID15=(Token)match(input,ID,FOLLOW_ID_in_class_value547);  
            stream_ID.add(ID15);


            // AST REWRITE
            // elements: ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 102:14: -> ID
            {
                adaptor.addChild(root_0, 
                stream_ID.nextNode()
                );

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "class_value"


    public static class concrete_value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "concrete_value"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:105:1: concrete_value : ( boolean_value | INT_LITERAL -> ^( INT_VALUE INT_LITERAL ) | STRING_LITERAL -> ^( STRING_VALUE STRING_LITERAL ) | CHAR_LITERAL -> ^( CHAR_VALUE CHAR_LITERAL ) | class_value -> ^( CLASS_VALUE class_value ) );
    public final DroidSafeParser.concrete_value_return concrete_value() throws RecognitionException {
        DroidSafeParser.concrete_value_return retval = new DroidSafeParser.concrete_value_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token INT_LITERAL17=null;
        Token STRING_LITERAL18=null;
        Token CHAR_LITERAL19=null;
        DroidSafeParser.boolean_value_return boolean_value16 =null;

        DroidSafeParser.class_value_return class_value20 =null;


        Object INT_LITERAL17_tree=null;
        Object STRING_LITERAL18_tree=null;
        Object CHAR_LITERAL19_tree=null;
        RewriteRuleTokenStream stream_INT_LITERAL=new RewriteRuleTokenStream(adaptor,"token INT_LITERAL");
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");
        RewriteRuleTokenStream stream_CHAR_LITERAL=new RewriteRuleTokenStream(adaptor,"token CHAR_LITERAL");
        RewriteRuleSubtreeStream stream_class_value=new RewriteRuleSubtreeStream(adaptor,"rule class_value");
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:106:3: ( boolean_value | INT_LITERAL -> ^( INT_VALUE INT_LITERAL ) | STRING_LITERAL -> ^( STRING_VALUE STRING_LITERAL ) | CHAR_LITERAL -> ^( CHAR_VALUE CHAR_LITERAL ) | class_value -> ^( CLASS_VALUE class_value ) )
            int alt6=5;
            switch ( input.LA(1) ) {
            case FALSE:
            case TRUE:
                {
                alt6=1;
                }
                break;
            case INT_LITERAL:
                {
                alt6=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt6=3;
                }
                break;
            case CHAR_LITERAL:
                {
                alt6=4;
                }
                break;
            case CLASS:
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
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:106:5: boolean_value
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_boolean_value_in_concrete_value564);
                    boolean_value16=boolean_value();

                    state._fsp--;

                    adaptor.addChild(root_0, boolean_value16.getTree());

                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:107:5: INT_LITERAL
                    {
                    INT_LITERAL17=(Token)match(input,INT_LITERAL,FOLLOW_INT_LITERAL_in_concrete_value571);  
                    stream_INT_LITERAL.add(INT_LITERAL17);


                    // AST REWRITE
                    // elements: INT_LITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 107:17: -> ^( INT_VALUE INT_LITERAL )
                    {
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:107:20: ^( INT_VALUE INT_LITERAL )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(INT_VALUE, "INT_VALUE")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_INT_LITERAL.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:108:5: STRING_LITERAL
                    {
                    STRING_LITERAL18=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_concrete_value585);  
                    stream_STRING_LITERAL.add(STRING_LITERAL18);


                    // AST REWRITE
                    // elements: STRING_LITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 108:20: -> ^( STRING_VALUE STRING_LITERAL )
                    {
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:108:23: ^( STRING_VALUE STRING_LITERAL )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(STRING_VALUE, "STRING_VALUE")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_STRING_LITERAL.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 4 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:109:5: CHAR_LITERAL
                    {
                    CHAR_LITERAL19=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_concrete_value599);  
                    stream_CHAR_LITERAL.add(CHAR_LITERAL19);


                    // AST REWRITE
                    // elements: CHAR_LITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 109:18: -> ^( CHAR_VALUE CHAR_LITERAL )
                    {
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:109:21: ^( CHAR_VALUE CHAR_LITERAL )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(CHAR_VALUE, "CHAR_VALUE")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_CHAR_LITERAL.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 5 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:110:5: class_value
                    {
                    pushFollow(FOLLOW_class_value_in_concrete_value613);
                    class_value20=class_value();

                    state._fsp--;

                    stream_class_value.add(class_value20.getTree());

                    // AST REWRITE
                    // elements: class_value
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 110:17: -> ^( CLASS_VALUE class_value )
                    {
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:110:20: ^( CLASS_VALUE class_value )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(CLASS_VALUE, "CLASS_VALUE")
                        , root_1);

                        adaptor.addChild(root_1, stream_class_value.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "concrete_value"


    public static class concrete_value_list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "concrete_value_list"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:113:1: concrete_value_list : concrete_value ( OR_VAL concrete_value )* -> ^( CVALUE_LIST ( concrete_value )+ ) ;
    public final DroidSafeParser.concrete_value_list_return concrete_value_list() throws RecognitionException {
        DroidSafeParser.concrete_value_list_return retval = new DroidSafeParser.concrete_value_list_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token OR_VAL22=null;
        DroidSafeParser.concrete_value_return concrete_value21 =null;

        DroidSafeParser.concrete_value_return concrete_value23 =null;


        Object OR_VAL22_tree=null;
        RewriteRuleTokenStream stream_OR_VAL=new RewriteRuleTokenStream(adaptor,"token OR_VAL");
        RewriteRuleSubtreeStream stream_concrete_value=new RewriteRuleSubtreeStream(adaptor,"rule concrete_value");
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:114:3: ( concrete_value ( OR_VAL concrete_value )* -> ^( CVALUE_LIST ( concrete_value )+ ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:114:5: concrete_value ( OR_VAL concrete_value )*
            {
            pushFollow(FOLLOW_concrete_value_in_concrete_value_list634);
            concrete_value21=concrete_value();

            state._fsp--;

            stream_concrete_value.add(concrete_value21.getTree());

            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:114:20: ( OR_VAL concrete_value )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==OR_VAL) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:114:21: OR_VAL concrete_value
            	    {
            	    OR_VAL22=(Token)match(input,OR_VAL,FOLLOW_OR_VAL_in_concrete_value_list637);  
            	    stream_OR_VAL.add(OR_VAL22);


            	    pushFollow(FOLLOW_concrete_value_in_concrete_value_list639);
            	    concrete_value23=concrete_value();

            	    state._fsp--;

            	    stream_concrete_value.add(concrete_value23.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            // AST REWRITE
            // elements: concrete_value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 114:45: -> ^( CVALUE_LIST ( concrete_value )+ )
            {
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:114:48: ^( CVALUE_LIST ( concrete_value )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CVALUE_LIST, "CVALUE_LIST")
                , root_1);

                if ( !(stream_concrete_value.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_concrete_value.hasNext() ) {
                    adaptor.addChild(root_1, stream_concrete_value.nextTree());

                }
                stream_concrete_value.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "concrete_value_list"


    public static class arg_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arg"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:117:1: arg : ( ID -> ^( TYPE_VALUE ID ) | concrete_value_list );
    public final DroidSafeParser.arg_return arg() throws RecognitionException {
        DroidSafeParser.arg_return retval = new DroidSafeParser.arg_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ID24=null;
        DroidSafeParser.concrete_value_list_return concrete_value_list25 =null;


        Object ID24_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:118:3: ( ID -> ^( TYPE_VALUE ID ) | concrete_value_list )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==CHAR_LITERAL||LA8_0==CLASS||LA8_0==FALSE||LA8_0==INT_LITERAL||LA8_0==STRING_LITERAL||LA8_0==TRUE) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:118:5: ID
                    {
                    ID24=(Token)match(input,ID,FOLLOW_ID_in_arg667);  
                    stream_ID.add(ID24);


                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 118:8: -> ^( TYPE_VALUE ID )
                    {
                        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:118:11: ^( TYPE_VALUE ID )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(TYPE_VALUE, "TYPE_VALUE")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:119:7: concrete_value_list
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_concrete_value_list_in_arg683);
                    concrete_value_list25=concrete_value_list();

                    state._fsp--;

                    adaptor.addChild(root_0, concrete_value_list25.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arg"


    public static class arg_list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arg_list"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:122:1: arg_list : arg ( COMMA arg )* -> ( arg )+ ;
    public final DroidSafeParser.arg_list_return arg_list() throws RecognitionException {
        DroidSafeParser.arg_list_return retval = new DroidSafeParser.arg_list_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COMMA27=null;
        DroidSafeParser.arg_return arg26 =null;

        DroidSafeParser.arg_return arg28 =null;


        Object COMMA27_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_arg=new RewriteRuleSubtreeStream(adaptor,"rule arg");
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:123:5: ( arg ( COMMA arg )* -> ( arg )+ )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:124:5: arg ( COMMA arg )*
            {
            pushFollow(FOLLOW_arg_in_arg_list702);
            arg26=arg();

            state._fsp--;

            stream_arg.add(arg26.getTree());

            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:124:9: ( COMMA arg )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==COMMA) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:124:10: COMMA arg
            	    {
            	    COMMA27=(Token)match(input,COMMA,FOLLOW_COMMA_in_arg_list705);  
            	    stream_COMMA.add(COMMA27);


            	    pushFollow(FOLLOW_arg_in_arg_list707);
            	    arg28=arg();

            	    state._fsp--;

            	    stream_arg.add(arg28.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            // AST REWRITE
            // elements: arg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 124:22: -> ( arg )+
            {
                if ( !(stream_arg.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_arg.hasNext() ) {
                    adaptor.addChild(root_0, stream_arg.nextTree());

                }
                stream_arg.reset();

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arg_list"


    public static class receiver_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "receiver"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:127:1: receiver : ( ID | INT_LITERAL );
    public final DroidSafeParser.receiver_return receiver() throws RecognitionException {
        DroidSafeParser.receiver_return retval = new DroidSafeParser.receiver_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set29=null;

        Object set29_tree=null;

        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:128:5: ( ID | INT_LITERAL )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:
            {
            root_0 = (Object)adaptor.nil();


            set29=(Token)input.LT(1);

            if ( input.LA(1)==ID||input.LA(1)==INT_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set29)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "receiver"


    public static class api_call_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "api_call"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:132:1: api_call : ( receiver )? cname= ID COLON rt= ID mname= ID LPAREN ( arg_list )? RPAREN -> ^( API_CALL ^( RECEIVER ( receiver )? ) ^( CLASS $cname) ^( RTYPE $rt) ^( METHOD $mname) ^( ARGS ( arg_list )? ) ) ;
    public final DroidSafeParser.api_call_return api_call() throws RecognitionException {
        DroidSafeParser.api_call_return retval = new DroidSafeParser.api_call_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token cname=null;
        Token rt=null;
        Token mname=null;
        Token COLON31=null;
        Token LPAREN32=null;
        Token RPAREN34=null;
        DroidSafeParser.receiver_return receiver30 =null;

        DroidSafeParser.arg_list_return arg_list33 =null;


        Object cname_tree=null;
        Object rt_tree=null;
        Object mname_tree=null;
        Object COLON31_tree=null;
        Object LPAREN32_tree=null;
        Object RPAREN34_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_arg_list=new RewriteRuleSubtreeStream(adaptor,"rule arg_list");
        RewriteRuleSubtreeStream stream_receiver=new RewriteRuleSubtreeStream(adaptor,"rule receiver");
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:133:3: ( ( receiver )? cname= ID COLON rt= ID mname= ID LPAREN ( arg_list )? RPAREN -> ^( API_CALL ^( RECEIVER ( receiver )? ) ^( CLASS $cname) ^( RTYPE $rt) ^( METHOD $mname) ^( ARGS ( arg_list )? ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:133:5: ( receiver )? cname= ID COLON rt= ID mname= ID LPAREN ( arg_list )? RPAREN
            {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:133:5: ( receiver )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==ID) ) {
                    alt10=1;
                }
            }
            else if ( (LA10_0==INT_LITERAL) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:133:5: receiver
                    {
                    pushFollow(FOLLOW_receiver_in_api_call757);
                    receiver30=receiver();

                    state._fsp--;

                    stream_receiver.add(receiver30.getTree());

                    }
                    break;

            }


            cname=(Token)match(input,ID,FOLLOW_ID_in_api_call762);  
            stream_ID.add(cname);


            COLON31=(Token)match(input,COLON,FOLLOW_COLON_in_api_call764);  
            stream_COLON.add(COLON31);


            rt=(Token)match(input,ID,FOLLOW_ID_in_api_call768);  
            stream_ID.add(rt);


            mname=(Token)match(input,ID,FOLLOW_ID_in_api_call772);  
            stream_ID.add(mname);


            LPAREN32=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_api_call774);  
            stream_LPAREN.add(LPAREN32);


            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:133:52: ( arg_list )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==CHAR_LITERAL||LA11_0==CLASS||LA11_0==FALSE||LA11_0==ID||LA11_0==INT_LITERAL||LA11_0==STRING_LITERAL||LA11_0==TRUE) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:133:52: arg_list
                    {
                    pushFollow(FOLLOW_arg_list_in_api_call776);
                    arg_list33=arg_list();

                    state._fsp--;

                    stream_arg_list.add(arg_list33.getTree());

                    }
                    break;

            }


            RPAREN34=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_api_call779);  
            stream_RPAREN.add(RPAREN34);


            // AST REWRITE
            // elements: rt, cname, arg_list, receiver, mname
            // token labels: mname, rt, cname
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_mname=new RewriteRuleTokenStream(adaptor,"token mname",mname);
            RewriteRuleTokenStream stream_rt=new RewriteRuleTokenStream(adaptor,"token rt",rt);
            RewriteRuleTokenStream stream_cname=new RewriteRuleTokenStream(adaptor,"token cname",cname);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 133:69: -> ^( API_CALL ^( RECEIVER ( receiver )? ) ^( CLASS $cname) ^( RTYPE $rt) ^( METHOD $mname) ^( ARGS ( arg_list )? ) )
            {
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:134:9: ^( API_CALL ^( RECEIVER ( receiver )? ) ^( CLASS $cname) ^( RTYPE $rt) ^( METHOD $mname) ^( ARGS ( arg_list )? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(API_CALL, "API_CALL")
                , root_1);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:134:20: ^( RECEIVER ( receiver )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(RECEIVER, "RECEIVER")
                , root_2);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:134:31: ( receiver )?
                if ( stream_receiver.hasNext() ) {
                    adaptor.addChild(root_2, stream_receiver.nextTree());

                }
                stream_receiver.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:134:42: ^( CLASS $cname)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CLASS, "CLASS")
                , root_2);

                adaptor.addChild(root_2, stream_cname.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:134:58: ^( RTYPE $rt)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(RTYPE, "RTYPE")
                , root_2);

                adaptor.addChild(root_2, stream_rt.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:134:71: ^( METHOD $mname)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(METHOD, "METHOD")
                , root_2);

                adaptor.addChild(root_2, stream_mname.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:134:88: ^( ARGS ( arg_list )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(ARGS, "ARGS")
                , root_2);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:134:95: ( arg_list )?
                if ( stream_arg_list.hasNext() ) {
                    adaptor.addChild(root_2, stream_arg_list.nextTree());

                }
                stream_arg_list.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "api_call"


    public static class api_action_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "api_action"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:137:1: api_action : name= ID LPAREN ( arg_list )? RPAREN -> ^( API_ACTION ^( ACTION_NAME $name) ^( ARGS ( arg_list )? ) ) ;
    public final DroidSafeParser.api_action_return api_action() throws RecognitionException {
        DroidSafeParser.api_action_return retval = new DroidSafeParser.api_action_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token name=null;
        Token LPAREN35=null;
        Token RPAREN37=null;
        DroidSafeParser.arg_list_return arg_list36 =null;


        Object name_tree=null;
        Object LPAREN35_tree=null;
        Object RPAREN37_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_arg_list=new RewriteRuleSubtreeStream(adaptor,"rule arg_list");
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:138:3: (name= ID LPAREN ( arg_list )? RPAREN -> ^( API_ACTION ^( ACTION_NAME $name) ^( ARGS ( arg_list )? ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:138:5: name= ID LPAREN ( arg_list )? RPAREN
            {
            name=(Token)match(input,ID,FOLLOW_ID_in_api_action845);  
            stream_ID.add(name);


            LPAREN35=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_api_action847);  
            stream_LPAREN.add(LPAREN35);


            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:138:20: ( arg_list )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==CHAR_LITERAL||LA12_0==CLASS||LA12_0==FALSE||LA12_0==ID||LA12_0==INT_LITERAL||LA12_0==STRING_LITERAL||LA12_0==TRUE) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:138:20: arg_list
                    {
                    pushFollow(FOLLOW_arg_list_in_api_action849);
                    arg_list36=arg_list();

                    state._fsp--;

                    stream_arg_list.add(arg_list36.getTree());

                    }
                    break;

            }


            RPAREN37=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_api_action852);  
            stream_RPAREN.add(RPAREN37);


            // AST REWRITE
            // elements: arg_list, name
            // token labels: name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 138:37: -> ^( API_ACTION ^( ACTION_NAME $name) ^( ARGS ( arg_list )? ) )
            {
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:138:40: ^( API_ACTION ^( ACTION_NAME $name) ^( ARGS ( arg_list )? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(API_ACTION, "API_ACTION")
                , root_1);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:138:53: ^( ACTION_NAME $name)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(ACTION_NAME, "ACTION_NAME")
                , root_2);

                adaptor.addChild(root_2, stream_name.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:138:74: ^( ARGS ( arg_list )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(ARGS, "ARGS")
                , root_2);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:138:81: ( arg_list )?
                if ( stream_arg_list.hasNext() ) {
                    adaptor.addChild(root_2, stream_arg_list.nextTree());

                }
                stream_arg_list.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "api_action"


    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:141:1: statement : ( api_action SEMI -> api_action | api_call SEMI -> api_call );
    public final DroidSafeParser.statement_return statement() throws RecognitionException {
        DroidSafeParser.statement_return retval = new DroidSafeParser.statement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token SEMI39=null;
        Token SEMI41=null;
        DroidSafeParser.api_action_return api_action38 =null;

        DroidSafeParser.api_call_return api_call40 =null;


        Object SEMI39_tree=null;
        Object SEMI41_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleSubtreeStream stream_api_action=new RewriteRuleSubtreeStream(adaptor,"rule api_action");
        RewriteRuleSubtreeStream stream_api_call=new RewriteRuleSubtreeStream(adaptor,"rule api_call");
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:142:3: ( api_action SEMI -> api_action | api_call SEMI -> api_call )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==LPAREN) ) {
                    alt13=1;
                }
                else if ( (LA13_1==COLON||LA13_1==ID) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA13_0==INT_LITERAL) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:142:5: api_action SEMI
                    {
                    pushFollow(FOLLOW_api_action_in_statement886);
                    api_action38=api_action();

                    state._fsp--;

                    stream_api_action.add(api_action38.getTree());

                    SEMI39=(Token)match(input,SEMI,FOLLOW_SEMI_in_statement888);  
                    stream_SEMI.add(SEMI39);


                    // AST REWRITE
                    // elements: api_action
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 142:21: -> api_action
                    {
                        adaptor.addChild(root_0, stream_api_action.nextTree());

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:143:5: api_call SEMI
                    {
                    pushFollow(FOLLOW_api_call_in_statement899);
                    api_call40=api_call();

                    state._fsp--;

                    stream_api_call.add(api_call40.getTree());

                    SEMI41=(Token)match(input,SEMI,FOLLOW_SEMI_in_statement901);  
                    stream_SEMI.add(SEMI41);


                    // AST REWRITE
                    // elements: api_call
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 143:19: -> api_call
                    {
                        adaptor.addChild(root_0, stream_api_call.nextTree());

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class statement_list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement_list"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:146:1: statement_list : ( statement )+ -> ( statement )+ ;
    public final DroidSafeParser.statement_list_return statement_list() throws RecognitionException {
        DroidSafeParser.statement_list_return retval = new DroidSafeParser.statement_list_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        DroidSafeParser.statement_return statement42 =null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:147:3: ( ( statement )+ -> ( statement )+ )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:147:5: ( statement )+
            {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:147:5: ( statement )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==ID||LA14_0==INT_LITERAL) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:147:5: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statement_list922);
            	    statement42=statement();

            	    state._fsp--;

            	    stream_statement.add(statement42.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 147:16: -> ( statement )+
            {
                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_0, stream_statement.nextTree());

                }
                stream_statement.reset();

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement_list"


    public static class event_block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "event_block"
    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:149:1: event_block : input_event LCURLY ( statement_list )? RCURLY -> ^( EVENT_BLOCK input_event ^( STMT_LIST ( statement_list )? ) ) ;
    public final DroidSafeParser.event_block_return event_block() throws RecognitionException {
        DroidSafeParser.event_block_return retval = new DroidSafeParser.event_block_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token LCURLY44=null;
        Token RCURLY46=null;
        DroidSafeParser.input_event_return input_event43 =null;

        DroidSafeParser.statement_list_return statement_list45 =null;


        Object LCURLY44_tree=null;
        Object RCURLY46_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_statement_list=new RewriteRuleSubtreeStream(adaptor,"rule statement_list");
        RewriteRuleSubtreeStream stream_input_event=new RewriteRuleSubtreeStream(adaptor,"rule input_event");
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:149:13: ( input_event LCURLY ( statement_list )? RCURLY -> ^( EVENT_BLOCK input_event ^( STMT_LIST ( statement_list )? ) ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:150:4: input_event LCURLY ( statement_list )? RCURLY
            {
            pushFollow(FOLLOW_input_event_in_event_block940);
            input_event43=input_event();

            state._fsp--;

            stream_input_event.add(input_event43.getTree());

            LCURLY44=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_event_block951);  
            stream_LCURLY.add(LCURLY44);


            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:152:9: ( statement_list )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ID||LA15_0==INT_LITERAL) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:152:9: statement_list
                    {
                    pushFollow(FOLLOW_statement_list_in_event_block962);
                    statement_list45=statement_list();

                    state._fsp--;

                    stream_statement_list.add(statement_list45.getTree());

                    }
                    break;

            }


            RCURLY46=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_event_block974);  
            stream_RCURLY.add(RCURLY46);


            // AST REWRITE
            // elements: statement_list, input_event
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 154:9: -> ^( EVENT_BLOCK input_event ^( STMT_LIST ( statement_list )? ) )
            {
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:154:12: ^( EVENT_BLOCK input_event ^( STMT_LIST ( statement_list )? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(EVENT_BLOCK, "EVENT_BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_input_event.nextTree());

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:154:38: ^( STMT_LIST ( statement_list )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(STMT_LIST, "STMT_LIST")
                , root_2);

                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:154:50: ( statement_list )?
                if ( stream_statement_list.hasNext() ) {
                    adaptor.addChild(root_2, stream_statement_list.nextTree());

                }
                stream_statement_list.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "event_block"

    // Delegated rules


 

    public static final BitSet FOLLOW_whitelist_in_spec319 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_event_block_in_spec324 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_WHITELIST_in_whitelist357 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LCURLY_in_whitelist368 = new BitSet(new long[]{0x0000000202800000L});
    public static final BitSet FOLLOW_statement_list_in_whitelist378 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RCURLY_in_whitelist389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_receiver_in_input_event421 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ID_in_input_event426 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_input_event428 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ID_in_input_event432 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ID_in_input_event436 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_input_event438 = new BitSet(new long[]{0x0000050802A00A00L});
    public static final BitSet FOLLOW_arg_list_in_input_event440 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RPAREN_in_input_event443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_boolean_value509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_boolean_value523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_in_class_value545 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ID_in_class_value547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_value_in_concrete_value564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_LITERAL_in_concrete_value571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_concrete_value585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_concrete_value599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_value_in_concrete_value613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concrete_value_in_concrete_value_list634 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_OR_VAL_in_concrete_value_list637 = new BitSet(new long[]{0x0000050002200A00L});
    public static final BitSet FOLLOW_concrete_value_in_concrete_value_list639 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ID_in_arg667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concrete_value_list_in_arg683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arg_in_arg_list702 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_COMMA_in_arg_list705 = new BitSet(new long[]{0x0000050002A00A00L});
    public static final BitSet FOLLOW_arg_in_arg_list707 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_receiver_in_api_call757 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ID_in_api_call762 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_api_call764 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ID_in_api_call768 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ID_in_api_call772 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_api_call774 = new BitSet(new long[]{0x0000050802A00A00L});
    public static final BitSet FOLLOW_arg_list_in_api_call776 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RPAREN_in_api_call779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_api_action845 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_LPAREN_in_api_action847 = new BitSet(new long[]{0x0000050802A00A00L});
    public static final BitSet FOLLOW_arg_list_in_api_action849 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RPAREN_in_api_action852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_api_action_in_statement886 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_api_call_in_statement899 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statement_list922 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_input_event_in_event_block940 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LCURLY_in_event_block951 = new BitSet(new long[]{0x0000000202800000L});
    public static final BitSet FOLLOW_statement_list_in_event_block962 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RCURLY_in_event_block974 = new BitSet(new long[]{0x0000000000000002L});

}