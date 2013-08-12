package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.Debug;
import gov.nist.core.LexerCore;
import gov.nist.core.ParserCore;
import gov.nist.core.Token;

import java.text.ParseException;





public abstract class Parser extends ParserCore implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.164 -0400", hash_original_method = "42CBDDB53A445ABDFB908116E235FAA0", hash_generated_method = "42CBDDB53A445ABDFB908116E235FAA0")
    public Parser ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.164 -0400", hash_original_method = "9ECF405713F3BDB595977394FAA46BC3", hash_generated_method = "DF18F1C01FEA5ED0941C954F65A30BC9")
    protected ParseException createParseException(String exceptionString) {
        addTaint(exceptionString.getTaint());
ParseException varC6F38182B58E7A72C677723DBDCE326D_1040825885 =         new ParseException(
            lexer.getBuffer() + ":" + exceptionString,
            lexer.getPtr());
        varC6F38182B58E7A72C677723DBDCE326D_1040825885.addTaint(taint);
        return varC6F38182B58E7A72C677723DBDCE326D_1040825885;
        // ---------- Original Method ----------
        //return new ParseException(
            //lexer.getBuffer() + ":" + exceptionString,
            //lexer.getPtr());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.164 -0400", hash_original_method = "46F79D05E02F5C322F83A2BCE13C7B55", hash_generated_method = "57C76954B03D07DF816857936E1403A2")
    protected Lexer getLexer() {
Lexer varFB96DE3FAEBD0984226EA4F3794EDE62_1610099786 =         (Lexer) this.lexer;
        varFB96DE3FAEBD0984226EA4F3794EDE62_1610099786.addTaint(taint);
        return varFB96DE3FAEBD0984226EA4F3794EDE62_1610099786;
        // ---------- Original Method ----------
        //return (Lexer) this.lexer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.165 -0400", hash_original_method = "2745F417C183E90B52AF06D41C98230A", hash_generated_method = "58FCF225AAC359B821767473F8C08BF4")
    protected String sipVersion() throws ParseException {
        if(debug)        
        dbg_enter("sipVersion");
        try 
        {
            Token tok = lexer.match(SIP);
            if(!tok.getTokenValue().equalsIgnoreCase("SIP"))            
            createParseException("Expecting SIP");
            lexer.match('/');
            tok = lexer.match(ID);
            if(!tok.getTokenValue().equals("2.0"))            
            createParseException("Expecting SIP/2.0");
String varAC3FC6DF81C7E6B09314CC9E9CD3CD11_620137876 =             "SIP/2.0";
            varAC3FC6DF81C7E6B09314CC9E9CD3CD11_620137876.addTaint(taint);
            return varAC3FC6DF81C7E6B09314CC9E9CD3CD11_620137876;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("sipVersion");
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.190 -0400", hash_original_method = "DFEA7962E8FE3DE66D00681F9A6D11E3", hash_generated_method = "A8800B7D4229DE7C47E2FD17C871D73A")
    protected String method() throws ParseException {
        try 
        {
            if(debug)            
            dbg_enter("method");
            Token[] tokens = this.lexer.peekNextToken(1);
            Token token = (Token) tokens[0];
            if(token.getTokenType() == INVITE
                || token.getTokenType() == ACK
                || token.getTokenType() == OPTIONS
                || token.getTokenType() == BYE
                || token.getTokenType() == REGISTER
                || token.getTokenType() == CANCEL
                || token.getTokenType() == SUBSCRIBE
                || token.getTokenType() == NOTIFY
                || token.getTokenType() == PUBLISH
                || token.getTokenType() == MESSAGE
                || token.getTokenType() == ID)            
            {
                lexer.consume();
String varBC219BAAC41CE19068373FABD4054E59_1727731650 =                 token.getTokenValue();
                varBC219BAAC41CE19068373FABD4054E59_1727731650.addTaint(taint);
                return varBC219BAAC41CE19068373FABD4054E59_1727731650;
            } //End block
            else
            {
                java.text.ParseException varE777E604102ABDF3663EEBD9C14F012E_1899241987 = createParseException("Invalid Method");
                varE777E604102ABDF3663EEBD9C14F012E_1899241987.addTaint(taint);
                throw varE777E604102ABDF3663EEBD9C14F012E_1899241987;
            } //End block
        } //End block
        finally 
        {
            if(Debug.debug)            
            dbg_leave("method");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
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

