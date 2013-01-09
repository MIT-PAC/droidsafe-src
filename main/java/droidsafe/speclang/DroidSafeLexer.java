// $ANTLR 3.4 /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g 2013-01-09 15:50:21
package droidsafe.speclang;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class DroidSafeLexer extends Lexer {
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

        private final static Logger logger = LoggerFactory.getLogger(DroidSafeLexer.class);

        public void emitErrorMessage(String msg) {
           logger.error(msg);
        }


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public DroidSafeLexer() {} 
    public DroidSafeLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DroidSafeLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g"; }

    // $ANTLR start "CLASS"
    public final void mCLASS() throws RecognitionException {
        try {
            int _type = CLASS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:18:7: ( '*' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:18:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CLASS"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:19:7: ( ':' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:19:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:20:7: ( ',' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:20:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:21:7: ( '=' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:21:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:22:7: ( 'false' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:22:9: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:23:8: ( '{' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:23:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:24:8: ( '(' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:24:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "OR_VAL"
    public final void mOR_VAL() throws RecognitionException {
        try {
            int _type = OR_VAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:25:8: ( '|' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:25:10: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR_VAL"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:26:6: ( '+' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:26:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:27:8: ( '}' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:27:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:28:8: ( ')' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:28:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:29:6: ( ';' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:29:8: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:30:6: ( 'true' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:30:8: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "WHITELIST"
    public final void mWHITELIST() throws RecognitionException {
        try {
            int _type = WHITELIST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:31:11: ( 'whitelist' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:31:13: 'whitelist'
            {
            match("whitelist"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITELIST"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:158:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '<' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' | '<' | '>' | '$' | '[' | ']' )* )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:158:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '<' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' | '<' | '>' | '$' | '[' | ']' )*
            {
            if ( input.LA(1)=='$'||input.LA(1)=='<'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:158:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' | '<' | '>' | '$' | '[' | ']' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='$'||LA1_0=='.'||(LA1_0 >= '0' && LA1_0 <= '9')||LA1_0=='<'||LA1_0=='>'||(LA1_0 >= 'A' && LA1_0 <= '[')||LA1_0==']'||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:
            	    {
            	    if ( input.LA(1)=='$'||input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= '9')||input.LA(1)=='<'||input.LA(1)=='>'||(input.LA(1) >= 'A' && input.LA(1) <= '[')||input.LA(1)==']'||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:162:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='/') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='/') ) {
                    alt5=1;
                }
                else if ( (LA5_1=='*') ) {
                    alt5=2;
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
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:162:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:162:14: (~ ( '\\n' | '\\r' ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:162:28: ( '\\r' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:162:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:163:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:163:14: ( options {greedy=false; } : . )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='*') ) {
                            int LA4_1 = input.LA(2);

                            if ( (LA4_1=='/') ) {
                                alt4=2;
                            }
                            else if ( ((LA4_1 >= '\u0000' && LA4_1 <= '.')||(LA4_1 >= '0' && LA4_1 <= '\uFFFF')) ) {
                                alt4=1;
                            }


                        }
                        else if ( ((LA4_0 >= '\u0000' && LA4_0 <= ')')||(LA4_0 >= '+' && LA4_0 <= '\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:163:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:166:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:166:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "INT_LITERAL"
    public final void mINT_LITERAL() throws RecognitionException {
        try {
            int _type = INT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:173:14: ( ( '-' )? ( '0' .. '9' )+ )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:173:17: ( '-' )? ( '0' .. '9' )+
            {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:173:17: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:173:18: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:173:24: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT_LITERAL"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:177:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:177:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:177:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\\') ) {
                    alt8=1;
                }
                else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '!')||(LA8_0 >= '#' && LA8_0 <= '[')||(LA8_0 >= ']' && LA8_0 <= '\uFFFF')) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:177:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:177:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "CHAR_LITERAL"
    public final void mCHAR_LITERAL() throws RecognitionException {
        try {
            int _type = CHAR_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:180:13: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:180:16: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:180:21: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\\') ) {
                alt9=1;
            }
            else if ( ((LA9_0 >= '\u0000' && LA9_0 <= '&')||(LA9_0 >= '(' && LA9_0 <= '[')||(LA9_0 >= ']' && LA9_0 <= '\uFFFF')) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:180:23: ESC_SEQ
                    {
                    mESC_SEQ(); 


                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:180:33: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR_LITERAL"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:186:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt10=1;
                    }
                    break;
                case 'u':
                    {
                    alt10=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt10=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:186:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:187:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:188:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:193:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\\') ) {
                int LA11_1 = input.LA(2);

                if ( ((LA11_1 >= '0' && LA11_1 <= '3')) ) {
                    int LA11_2 = input.LA(3);

                    if ( ((LA11_2 >= '0' && LA11_2 <= '7')) ) {
                        int LA11_4 = input.LA(4);

                        if ( ((LA11_4 >= '0' && LA11_4 <= '7')) ) {
                            alt11=1;
                        }
                        else {
                            alt11=2;
                        }
                    }
                    else {
                        alt11=3;
                    }
                }
                else if ( ((LA11_1 >= '4' && LA11_1 <= '7')) ) {
                    int LA11_3 = input.LA(3);

                    if ( ((LA11_3 >= '0' && LA11_3 <= '7')) ) {
                        alt11=2;
                    }
                    else {
                        alt11=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:193:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:194:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:195:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:200:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:200:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:204:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    public void mTokens() throws RecognitionException {
        // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:8: ( CLASS | COLON | COMMA | EQUAL | FALSE | LCURLY | LPAREN | OR_VAL | PLUS | RCURLY | RPAREN | SEMI | TRUE | WHITELIST | ID | COMMENT | WS | INT_LITERAL | STRING_LITERAL | CHAR_LITERAL )
        int alt12=20;
        switch ( input.LA(1) ) {
        case '*':
            {
            alt12=1;
            }
            break;
        case ':':
            {
            alt12=2;
            }
            break;
        case ',':
            {
            alt12=3;
            }
            break;
        case '=':
            {
            alt12=4;
            }
            break;
        case 'f':
            {
            int LA12_5 = input.LA(2);

            if ( (LA12_5=='a') ) {
                int LA12_21 = input.LA(3);

                if ( (LA12_21=='l') ) {
                    int LA12_24 = input.LA(4);

                    if ( (LA12_24=='s') ) {
                        int LA12_27 = input.LA(5);

                        if ( (LA12_27=='e') ) {
                            int LA12_30 = input.LA(6);

                            if ( (LA12_30=='$'||LA12_30=='.'||(LA12_30 >= '0' && LA12_30 <= '9')||LA12_30=='<'||LA12_30=='>'||(LA12_30 >= 'A' && LA12_30 <= '[')||LA12_30==']'||LA12_30=='_'||(LA12_30 >= 'a' && LA12_30 <= 'z')) ) {
                                alt12=15;
                            }
                            else {
                                alt12=5;
                            }
                        }
                        else {
                            alt12=15;
                        }
                    }
                    else {
                        alt12=15;
                    }
                }
                else {
                    alt12=15;
                }
            }
            else {
                alt12=15;
            }
            }
            break;
        case '{':
            {
            alt12=6;
            }
            break;
        case '(':
            {
            alt12=7;
            }
            break;
        case '|':
            {
            alt12=8;
            }
            break;
        case '+':
            {
            alt12=9;
            }
            break;
        case '}':
            {
            alt12=10;
            }
            break;
        case ')':
            {
            alt12=11;
            }
            break;
        case ';':
            {
            alt12=12;
            }
            break;
        case 't':
            {
            int LA12_13 = input.LA(2);

            if ( (LA12_13=='r') ) {
                int LA12_22 = input.LA(3);

                if ( (LA12_22=='u') ) {
                    int LA12_25 = input.LA(4);

                    if ( (LA12_25=='e') ) {
                        int LA12_28 = input.LA(5);

                        if ( (LA12_28=='$'||LA12_28=='.'||(LA12_28 >= '0' && LA12_28 <= '9')||LA12_28=='<'||LA12_28=='>'||(LA12_28 >= 'A' && LA12_28 <= '[')||LA12_28==']'||LA12_28=='_'||(LA12_28 >= 'a' && LA12_28 <= 'z')) ) {
                            alt12=15;
                        }
                        else {
                            alt12=13;
                        }
                    }
                    else {
                        alt12=15;
                    }
                }
                else {
                    alt12=15;
                }
            }
            else {
                alt12=15;
            }
            }
            break;
        case 'w':
            {
            int LA12_14 = input.LA(2);

            if ( (LA12_14=='h') ) {
                int LA12_23 = input.LA(3);

                if ( (LA12_23=='i') ) {
                    int LA12_26 = input.LA(4);

                    if ( (LA12_26=='t') ) {
                        int LA12_29 = input.LA(5);

                        if ( (LA12_29=='e') ) {
                            int LA12_32 = input.LA(6);

                            if ( (LA12_32=='l') ) {
                                int LA12_34 = input.LA(7);

                                if ( (LA12_34=='i') ) {
                                    int LA12_35 = input.LA(8);

                                    if ( (LA12_35=='s') ) {
                                        int LA12_36 = input.LA(9);

                                        if ( (LA12_36=='t') ) {
                                            int LA12_37 = input.LA(10);

                                            if ( (LA12_37=='$'||LA12_37=='.'||(LA12_37 >= '0' && LA12_37 <= '9')||LA12_37=='<'||LA12_37=='>'||(LA12_37 >= 'A' && LA12_37 <= '[')||LA12_37==']'||LA12_37=='_'||(LA12_37 >= 'a' && LA12_37 <= 'z')) ) {
                                                alt12=15;
                                            }
                                            else {
                                                alt12=14;
                                            }
                                        }
                                        else {
                                            alt12=15;
                                        }
                                    }
                                    else {
                                        alt12=15;
                                    }
                                }
                                else {
                                    alt12=15;
                                }
                            }
                            else {
                                alt12=15;
                            }
                        }
                        else {
                            alt12=15;
                        }
                    }
                    else {
                        alt12=15;
                    }
                }
                else {
                    alt12=15;
                }
            }
            else {
                alt12=15;
            }
            }
            break;
        case '$':
        case '<':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 'u':
        case 'v':
        case 'x':
        case 'y':
        case 'z':
            {
            alt12=15;
            }
            break;
        case '/':
            {
            alt12=16;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt12=17;
            }
            break;
        case '-':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt12=18;
            }
            break;
        case '\"':
            {
            alt12=19;
            }
            break;
        case '\'':
            {
            alt12=20;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 12, 0, input);

            throw nvae;

        }

        switch (alt12) {
            case 1 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:10: CLASS
                {
                mCLASS(); 


                }
                break;
            case 2 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:16: COLON
                {
                mCOLON(); 


                }
                break;
            case 3 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:22: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 4 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:28: EQUAL
                {
                mEQUAL(); 


                }
                break;
            case 5 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:34: FALSE
                {
                mFALSE(); 


                }
                break;
            case 6 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:40: LCURLY
                {
                mLCURLY(); 


                }
                break;
            case 7 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:47: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 8 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:54: OR_VAL
                {
                mOR_VAL(); 


                }
                break;
            case 9 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:61: PLUS
                {
                mPLUS(); 


                }
                break;
            case 10 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:66: RCURLY
                {
                mRCURLY(); 


                }
                break;
            case 11 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:73: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 12 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:80: SEMI
                {
                mSEMI(); 


                }
                break;
            case 13 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:85: TRUE
                {
                mTRUE(); 


                }
                break;
            case 14 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:90: WHITELIST
                {
                mWHITELIST(); 


                }
                break;
            case 15 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:100: ID
                {
                mID(); 


                }
                break;
            case 16 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:103: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 17 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:111: WS
                {
                mWS(); 


                }
                break;
            case 18 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:114: INT_LITERAL
                {
                mINT_LITERAL(); 


                }
                break;
            case 19 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:126: STRING_LITERAL
                {
                mSTRING_LITERAL(); 


                }
                break;
            case 20 :
                // /Users/mgordon/research/ds2/src/main/java/droidsafe/speclang/DroidSafe.g:1:141: CHAR_LITERAL
                {
                mCHAR_LITERAL(); 


                }
                break;

        }

    }


 

}