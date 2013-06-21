package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.Debug;
import gov.nist.core.LexerCore;
import gov.nist.core.ParserCore;
import gov.nist.core.Token;
import java.text.ParseException;

public abstract class Parser extends ParserCore implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.445 -0400", hash_original_method = "58307969D5CE2DE2463F9519A7B61467", hash_generated_method = "58307969D5CE2DE2463F9519A7B61467")
        public Parser ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.445 -0400", hash_original_method = "9ECF405713F3BDB595977394FAA46BC3", hash_generated_method = "BDEE402D0ABB4E3B9F8F8FB87B7995C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ParseException createParseException(String exceptionString) {
        dsTaint.addTaint(exceptionString);
        ParseException var2E42C738C9C54AD9EF33E57BAC2A902D_415521575 = (new ParseException(
            lexer.getBuffer() + ":" + exceptionString,
            lexer.getPtr()));
        return (ParseException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ParseException(
            //lexer.getBuffer() + ":" + exceptionString,
            //lexer.getPtr());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.446 -0400", hash_original_method = "46F79D05E02F5C322F83A2BCE13C7B55", hash_generated_method = "7AB6A68A46929FBE84F653E70E12D65F")
    @DSModeled(DSC.SAFE)
    protected Lexer getLexer() {
        return (Lexer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Lexer) this.lexer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.446 -0400", hash_original_method = "2745F417C183E90B52AF06D41C98230A", hash_generated_method = "5A36DF6229D0276777FD3676AA4DA0A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String sipVersion() throws ParseException {
        dbg_enter("sipVersion");
        try 
        {
            Token tok;
            tok = lexer.match(SIP);
            {
                boolean var81E5AA51CF3EF1FB1D8623A3AE83C759_1424764290 = (!tok.getTokenValue().equalsIgnoreCase("SIP"));
                createParseException("Expecting SIP");
            } //End collapsed parenthetic
            lexer.match('/');
            tok = lexer.match(ID);
            {
                boolean var1B84A423A0AD24015522BC141F627B59_1254187460 = (!tok.getTokenValue().equals("2.0"));
                createParseException("Expecting SIP/2.0");
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("sipVersion");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("sipVersion");
        //try {
            //Token tok = lexer.match(SIP);
            //if (!tok.getTokenValue().equalsIgnoreCase("SIP"))
                //createParseException("Expecting SIP");
            //lexer.match('/');
            //tok = lexer.match(ID);
            //if (!tok.getTokenValue().equals("2.0"))
                //createParseException("Expecting SIP/2.0");
            //return "SIP/2.0";
        //} finally {
            //if (debug)
                //dbg_leave("sipVersion");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.446 -0400", hash_original_method = "DFEA7962E8FE3DE66D00681F9A6D11E3", hash_generated_method = "E187D9D7A899B8F1AB17008AFA55E103")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String method() throws ParseException {
        try 
        {
            dbg_enter("method");
            Token[] tokens;
            tokens = this.lexer.peekNextToken(1);
            Token token;
            token = (Token) tokens[0];
            {
                boolean varF3DFC17C4FCB76412ED072978359296F_1535735704 = (token.getTokenType() == INVITE
                || token.getTokenType() == ACK
                || token.getTokenType() == OPTIONS
                || token.getTokenType() == BYE
                || token.getTokenType() == REGISTER
                || token.getTokenType() == CANCEL
                || token.getTokenType() == SUBSCRIBE
                || token.getTokenType() == NOTIFY
                || token.getTokenType() == PUBLISH
                || token.getTokenType() == MESSAGE
                || token.getTokenType() == ID);
                {
                    lexer.consume();
                    String var6425927A19AC0EB604D96983ED3EEAE5_1957160756 = (token.getTokenValue());
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw createParseException("Invalid Method");
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("method");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static final void checkToken( String token ) throws ParseException {
        if (token == null || token.length()==0 ) {
            throw new ParseException("null or empty token", -1 );
        } else {
            for ( int i=0; i<token.length(); ++i ) {
                if ( !LexerCore.isTokenChar( token.charAt(i) )) {
                    throw new ParseException( "Invalid character(s) in string (not allowed in 'token')", i );
                }
            }
        }
    }

    
}

