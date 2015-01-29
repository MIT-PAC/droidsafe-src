package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.WWWAuthenticate;

import java.text.ParseException;





public class WWWAuthenticateParser extends ChallengeParser {

    /**
     * Constructor
     * @param wwwAuthenticate -  message to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.087 -0500", hash_original_method = "6138AB6ABE323397A90992BBA6CE68F7", hash_generated_method = "5BBD20962E7C1C2DA74B21C3669D0241")
    
public WWWAuthenticateParser(String wwwAuthenticate) {
        super(wwwAuthenticate);
    }

    /**
     * Cosntructor
     * @param  lexer - lexer to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.090 -0500", hash_original_method = "3C6BB1F0E541627B3210DAEB9F57410E", hash_generated_method = "908EA339A139F1CAC5965C2F8904BBC7")
    
protected WWWAuthenticateParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (WWWAuthenticate object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.092 -0500", hash_original_method = "21D63394A7F5FCF103E716C1D0FF5141", hash_generated_method = "52DAF62CFA21540E7031C5AAEB1696DA")
    
public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("parse");
        try {
            headerName(TokenTypes.WWW_AUTHENTICATE);
            WWWAuthenticate wwwAuthenticate = new WWWAuthenticate();
            super.parse(wwwAuthenticate);
            return wwwAuthenticate;
        } finally {
            if (debug)
                dbg_leave("parse");
        }
    }

    
}

