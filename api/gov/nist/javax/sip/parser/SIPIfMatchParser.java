package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPIfMatch;

import java.text.ParseException;





public class SIPIfMatchParser extends HeaderParser {

    /**
     * Creates a new instance of PriorityParser
     * @param etag the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.221 -0500", hash_original_method = "58C73D632C90677B10301C6C3F2EA3A6", hash_generated_method = "33A3C006471E5CE5D2E5DA6D0C127D49")
    public SIPIfMatchParser(String etag) {
        super(etag);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.223 -0500", hash_original_method = "EF4950625B84E18FA318F1BE4AE7C3DD", hash_generated_method = "C23C4D068E2F2026CBFF1A942527A131")
    protected SIPIfMatchParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String header
     * @return SIPHeader (Priority object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.223 -0500", hash_original_method = "3E32D858B03BB295FC48CF43F0845DFE", hash_generated_method = "C25431E8B75315810AEF2908E807AD89")
    public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("SIPIfMatch.parse");

        SIPIfMatch sipIfMatch = new SIPIfMatch();
        try {
            headerName(TokenTypes.SIP_IF_MATCH);

            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();

            sipIfMatch.setETag(token.getTokenValue());

            this.lexer.SPorHT();
            this.lexer.match('\n');

            return sipIfMatch;
        } finally {
            if (debug)
                dbg_leave("SIPIfMatch.parse");
        }
    }

    
}

