package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPETag;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;



public class SIPETagParser extends HeaderParser {

    /**
     * Creates a new instance of PriorityParser
     * @param etag the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.644 -0500", hash_original_method = "25835348DC7AD8FF740039B9BA0B006A", hash_generated_method = "7DBC871E34662A75C5F9C0C3FD8B8B0F")
    
public SIPETagParser(String etag) {
        super(etag);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.647 -0500", hash_original_method = "03B2B3729732C2927273E5D90D52F99B", hash_generated_method = "F182C661D1BD3FF2D55AC247ACC1D86B")
    
protected SIPETagParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String header
     * @return SIPHeader (Priority object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.650 -0500", hash_original_method = "2EFAB9CD472E8A9D51A90FC23F3B4B08", hash_generated_method = "2F99CF48367A1485398C659CC2355AF7")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("SIPEtag.parse");

        SIPETag sipEtag = new SIPETag();
        try {
            headerName(TokenTypes.SIP_ETAG);

            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();

            sipEtag.setETag(token.getTokenValue());

            this.lexer.SPorHT();
            this.lexer.match('\n');

            return sipEtag;
        } finally {
            if (debug)
                dbg_leave("SIPEtag.parse");
        }
    }

    
}

