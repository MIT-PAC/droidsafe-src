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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.507 -0400", hash_original_method = "42CBDDB53A445ABDFB908116E235FAA0", hash_generated_method = "42CBDDB53A445ABDFB908116E235FAA0")
    public Parser ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.510 -0400", hash_original_method = "9ECF405713F3BDB595977394FAA46BC3", hash_generated_method = "18F27F7EED6D00C3748F118A93A03A9E")
    protected ParseException createParseException(String exceptionString) {
        ParseException varB4EAC82CA7396A68D541C85D26508E83_2055338616 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2055338616 = new ParseException(
            lexer.getBuffer() + ":" + exceptionString,
            lexer.getPtr());
        addTaint(exceptionString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2055338616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2055338616;
        // ---------- Original Method ----------
        //return new ParseException(
            //lexer.getBuffer() + ":" + exceptionString,
            //lexer.getPtr());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.510 -0400", hash_original_method = "46F79D05E02F5C322F83A2BCE13C7B55", hash_generated_method = "CB69EB7761ACBB5A325897EA90E16C38")
    protected Lexer getLexer() {
        Lexer varB4EAC82CA7396A68D541C85D26508E83_1301756485 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1301756485 = (Lexer) this.lexer;
        varB4EAC82CA7396A68D541C85D26508E83_1301756485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1301756485;
        // ---------- Original Method ----------
        //return (Lexer) this.lexer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.526 -0400", hash_original_method = "2745F417C183E90B52AF06D41C98230A", hash_generated_method = "BC30CCBBE1D56641E9D30F2DF5CC0952")
    protected String sipVersion() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1328628032 = null; //Variable for return #1
        dbg_enter("sipVersion");
        try 
        {
            Token tok;
            tok = lexer.match(SIP);
            {
                boolean var81E5AA51CF3EF1FB1D8623A3AE83C759_774235152 = (!tok.getTokenValue().equalsIgnoreCase("SIP"));
                createParseException("Expecting SIP");
            } //End collapsed parenthetic
            lexer.match('/');
            tok = lexer.match(ID);
            {
                boolean var1B84A423A0AD24015522BC141F627B59_810509150 = (!tok.getTokenValue().equals("2.0"));
                createParseException("Expecting SIP/2.0");
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1328628032 = "SIP/2.0";
        } //End block
        finally 
        {
            dbg_leave("sipVersion");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1328628032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1328628032;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.537 -0400", hash_original_method = "DFEA7962E8FE3DE66D00681F9A6D11E3", hash_generated_method = "9C98167941984FA0287803335D526F28")
    protected String method() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_2058568845 = null; //Variable for return #1
        try 
        {
            dbg_enter("method");
            Token[] tokens;
            tokens = this.lexer.peekNextToken(1);
            Token token;
            token = (Token) tokens[0];
            {
                boolean varF3DFC17C4FCB76412ED072978359296F_971632307 = (token.getTokenType() == INVITE
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
                    varB4EAC82CA7396A68D541C85D26508E83_2058568845 = token.getTokenValue();
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
        varB4EAC82CA7396A68D541C85D26508E83_2058568845.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2058568845;
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

