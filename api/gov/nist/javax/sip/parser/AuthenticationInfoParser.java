package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.javax.sip.header.AuthenticationInfo;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class AuthenticationInfoParser extends ParametersParser {

    /**
     * Creates a new instance of AuthenticationInfoParser
     * @param authenticationInfo the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.670 -0500", hash_original_method = "F28ABF8CFF04CC1C57BCD4E014C95C2B", hash_generated_method = "C52781DE68D0E8381AD445FB0A42C99D")
    public AuthenticationInfoParser(String authenticationInfo) {
        super(authenticationInfo);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.671 -0500", hash_original_method = "49A5BC0E10B199942A909086CCB53299", hash_generated_method = "24775B47F28F9DCC02BCDE0F1B7F22EF")
    protected AuthenticationInfoParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the AuthenticationInfo String header
     * @return SIPHeader (AuthenticationInfoList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.672 -0500", hash_original_method = "2DCD0228D3AB6B3B6D80756266EB3403", hash_generated_method = "BE18C1C14CF0932D529700151D21C78F")
    public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("AuthenticationInfoParser.parse");

        try {
            headerName(TokenTypes.AUTHENTICATION_INFO);

            AuthenticationInfo authenticationInfo = new AuthenticationInfo();
            authenticationInfo.setHeaderName(
                SIPHeaderNames.AUTHENTICATION_INFO);

            this.lexer.SPorHT();

            NameValue nv = super.nameValue();
            authenticationInfo.setParameter(nv);
            this.lexer.SPorHT();
            while (lexer.lookAhead(0) == ',') {
                this.lexer.match(',');
                this.lexer.SPorHT();

                nv = super.nameValue();
                authenticationInfo.setParameter(nv);
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            //this.lexer.match('\n');

            return authenticationInfo;
        } finally {
            if (debug)
                dbg_leave("AuthenticationInfoParser.parse");
        }
    }

    
}

