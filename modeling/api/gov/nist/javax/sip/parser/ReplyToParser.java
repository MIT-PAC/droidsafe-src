package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ReplyTo;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class ReplyToParser extends AddressParametersParser {

    /**
     * Creates a new instance of ReplyToParser
     * @param replyTo the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.448 -0500", hash_original_method = "9C582C13750EA226F05F84BEF0F6DC1F", hash_generated_method = "B88DE28F9B47FE06D3B19C7105D84DBE")
    
public ReplyToParser(String replyTo) {
        super(replyTo);
    }

    /**
     * Cosntructor
     * param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.451 -0500", hash_original_method = "967233BE7821B2A8956B876F99751025", hash_generated_method = "1A1CFEB064023FAEA3BDDED8D5C52AA2")
    
protected ReplyToParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message and generate the ReplyTo List Object
     * @return SIPHeader the ReplyTo List object
     * @throws SIPParseException if errors occur during the parsing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.453 -0500", hash_original_method = "92CC6877DF7B50AD61B75778CFB22735", hash_generated_method = "44EAD4A20182A38DB6FCBEBB6380CA34")
    
public SIPHeader parse() throws ParseException {
        ReplyTo replyTo = new ReplyTo();
        if (debug)
            dbg_enter("ReplyTo.parse");

        try {
            headerName(TokenTypes.REPLY_TO);

            replyTo.setHeaderName(SIPHeaderNames.REPLY_TO);

            super.parse(replyTo);

            return replyTo;
        } finally {
            if (debug)
                dbg_leave("ReplyTo.parse");
        }

    }

    
}

