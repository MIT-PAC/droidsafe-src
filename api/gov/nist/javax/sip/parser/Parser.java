package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.Debug;
import gov.nist.core.LexerCore;
import gov.nist.core.ParserCore;
import gov.nist.core.Token;
import java.text.ParseException;

public abstract class Parser extends ParserCore implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.316 -0400", hash_original_method = "42CBDDB53A445ABDFB908116E235FAA0", hash_generated_method = "42CBDDB53A445ABDFB908116E235FAA0")
    public Parser ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.316 -0400", hash_original_method = "9ECF405713F3BDB595977394FAA46BC3", hash_generated_method = "89A9E3AE1B29C0BA88EC2E4504615043")
    protected ParseException createParseException(String exceptionString) {
        addTaint(exceptionString.getTaint());
ParseException varC6F38182B58E7A72C677723DBDCE326D_389550042 =         new ParseException(
            lexer.getBuffer() + ":" + exceptionString,
            lexer.getPtr());
        varC6F38182B58E7A72C677723DBDCE326D_389550042.addTaint(taint);
        return varC6F38182B58E7A72C677723DBDCE326D_389550042;
        // ---------- Original Method ----------
        //return new ParseException(
            //lexer.getBuffer() + ":" + exceptionString,
            //lexer.getPtr());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.316 -0400", hash_original_method = "46F79D05E02F5C322F83A2BCE13C7B55", hash_generated_method = "826DDFF0DDF37F3F18B12E90F115A8B1")
    protected Lexer getLexer() {
Lexer varFB96DE3FAEBD0984226EA4F3794EDE62_170017856 =         (Lexer) this.lexer;
        varFB96DE3FAEBD0984226EA4F3794EDE62_170017856.addTaint(taint);
        return varFB96DE3FAEBD0984226EA4F3794EDE62_170017856;
        // ---------- Original Method ----------
        //return (Lexer) this.lexer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.316 -0400", hash_original_method = "2745F417C183E90B52AF06D41C98230A", hash_generated_method = "6F763AE80380F291978BC9FD8D9E0E26")
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
String varAC3FC6DF81C7E6B09314CC9E9CD3CD11_1048211768 =             "SIP/2.0";
            varAC3FC6DF81C7E6B09314CC9E9CD3CD11_1048211768.addTaint(taint);
            return varAC3FC6DF81C7E6B09314CC9E9CD3CD11_1048211768;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.339 -0400", hash_original_method = "DFEA7962E8FE3DE66D00681F9A6D11E3", hash_generated_method = "CAE2D18A4E4250D79E957D3F1AC1C740")
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
String varBC219BAAC41CE19068373FABD4054E59_1928033746 =                 token.getTokenValue();
                varBC219BAAC41CE19068373FABD4054E59_1928033746.addTaint(taint);
                return varBC219BAAC41CE19068373FABD4054E59_1928033746;
            } //End block
            else
            {
                java.text.ParseException varE777E604102ABDF3663EEBD9C14F012E_1791236608 = createParseException("Invalid Method");
                varE777E604102ABDF3663EEBD9C14F012E_1791236608.addTaint(taint);
                throw varE777E604102ABDF3663EEBD9C14F012E_1791236608;
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

