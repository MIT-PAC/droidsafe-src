package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.Organization;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class OrganizationParser extends HeaderParser {

    /**
     * Creates a new instance of OrganizationParser
     * @param organization the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.210 -0500", hash_original_method = "549F69CADB3AF439FF99C26DCF97EF61", hash_generated_method = "CEBA3986A95DFF69F8177CC349644074")
    public OrganizationParser(String organization) {
        super(organization);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.211 -0500", hash_original_method = "5407EA6CAC142FB29C8ECABB6BAE3B2C", hash_generated_method = "412D840A9277F29A5C06FD88841372AC")
    protected OrganizationParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String header
     * @return SIPHeader (Organization object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.212 -0500", hash_original_method = "FCDFEF7484AB928FBE1CF6D95D3DCFBA", hash_generated_method = "1CE88D580E15AA2C14FFEEDCCCA71471")
    public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("OrganizationParser.parse");
        Organization organization = new Organization();
        try {
            headerName(TokenTypes.ORGANIZATION);

            organization.setHeaderName(SIPHeaderNames.ORGANIZATION);

            this.lexer.SPorHT();
            String value = this.lexer.getRest();

            organization.setOrganization(value.trim());

            return organization;
        } finally {
            if (debug)
                dbg_leave("OrganizationParser.parse");
        }
    }

    
}

