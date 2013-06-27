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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.918 -0400", hash_original_method = "42CBDDB53A445ABDFB908116E235FAA0", hash_generated_method = "42CBDDB53A445ABDFB908116E235FAA0")
    public Parser ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.919 -0400", hash_original_method = "9ECF405713F3BDB595977394FAA46BC3", hash_generated_method = "1996AD83A33ECFB834DD83E6D80D6C94")
    protected ParseException createParseException(String exceptionString) {
        ParseException varB4EAC82CA7396A68D541C85D26508E83_1476421318 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1476421318 = new ParseException(
            lexer.getBuffer() + ":" + exceptionString,
            lexer.getPtr());
        addTaint(exceptionString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1476421318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1476421318;
        // ---------- Original Method ----------
        //return new ParseException(
            //lexer.getBuffer() + ":" + exceptionString,
            //lexer.getPtr());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.929 -0400", hash_original_method = "46F79D05E02F5C322F83A2BCE13C7B55", hash_generated_method = "A88B9FD5D19460C749020EA0F821B531")
    protected Lexer getLexer() {
        Lexer varB4EAC82CA7396A68D541C85D26508E83_1503922713 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1503922713 = (Lexer) this.lexer;
        varB4EAC82CA7396A68D541C85D26508E83_1503922713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1503922713;
        // ---------- Original Method ----------
        //return (Lexer) this.lexer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.933 -0400", hash_original_method = "2745F417C183E90B52AF06D41C98230A", hash_generated_method = "0F1DF93334EB58AFA11C04322B49D305")
    protected String sipVersion() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1219886132 = null; //Variable for return #1
        dbg_enter("sipVersion");
        try 
        {
            Token tok;
            tok = lexer.match(SIP);
            {
                boolean var81E5AA51CF3EF1FB1D8623A3AE83C759_1287813120 = (!tok.getTokenValue().equalsIgnoreCase("SIP"));
                createParseException("Expecting SIP");
            } //End collapsed parenthetic
            lexer.match('/');
            tok = lexer.match(ID);
            {
                boolean var1B84A423A0AD24015522BC141F627B59_318744632 = (!tok.getTokenValue().equals("2.0"));
                createParseException("Expecting SIP/2.0");
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1219886132 = "SIP/2.0";
        } //End block
        finally 
        {
            dbg_leave("sipVersion");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1219886132.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1219886132;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.935 -0400", hash_original_method = "DFEA7962E8FE3DE66D00681F9A6D11E3", hash_generated_method = "97075203BF83C577B149C048976CE9F6")
    protected String method() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1780104493 = null; //Variable for return #1
        try 
        {
            dbg_enter("method");
            Token[] tokens;
            tokens = this.lexer.peekNextToken(1);
            Token token;
            token = (Token) tokens[0];
            {
                boolean varF3DFC17C4FCB76412ED072978359296F_1353148040 = (token.getTokenType() == INVITE
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
                    varB4EAC82CA7396A68D541C85D26508E83_1780104493 = token.getTokenValue();
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
        varB4EAC82CA7396A68D541C85D26508E83_1780104493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1780104493;
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

