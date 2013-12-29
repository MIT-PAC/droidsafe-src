package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.Authorization;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class AuthorizationParser extends ChallengeParser {

    /**
     * Constructor
     * @param authorization Authorization message to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.907 -0500", hash_original_method = "4106C62632F233034B416151FC55AB70", hash_generated_method = "8588119BFD18E5BEEDF80A4333AA85FE")
    public AuthorizationParser(String authorization) {
        super(authorization);
    }

    /**
     * Cosntructor
     * @param lexer Lexer to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.908 -0500", hash_original_method = "7F449A569D89A06236BD64E3F6673F37", hash_generated_method = "BDD5B66C9D2BBFE6BE0A99ED13A0C05C")
    protected AuthorizationParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (Authorization object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.909 -0500", hash_original_method = "EB9857D021AE5F251F44C2032AC6D5E3", hash_generated_method = "C6064836CD5AA019E7038ECC6C074414")
    public SIPHeader parse() throws ParseException {
        dbg_enter("parse");
        try {
            headerName(TokenTypes.AUTHORIZATION);
            Authorization auth = new Authorization();
            super.parse(auth);
            return auth;
        } finally {
            dbg_leave("parse");
        }
    }

    
}

