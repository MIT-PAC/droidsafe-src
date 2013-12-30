package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.RAck;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class RAckParser extends HeaderParser {

    /**
     * Creates a new instance of RAckParser
     * @param rack the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.413 -0500", hash_original_method = "35CA8C822A17FE233ECB2E3810B4D5A5", hash_generated_method = "24C57D0918286878DA98E99F52EEAD4C")
    
public RAckParser(String rack) {
        super(rack);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.416 -0500", hash_original_method = "8178ADDB9459B460DE70CCF5467A1FD6", hash_generated_method = "5A5515353A821A230431DAF89E36F034")
    
protected RAckParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (RAck object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.418 -0500", hash_original_method = "D7A41CF31988627D95B578BB3BBF9822", hash_generated_method = "9630959A166C23AFBB0C2214C1D71B34")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("RAckParser.parse");
        RAck rack = new RAck();
        try {
            headerName(TokenTypes.RACK);

            rack.setHeaderName(SIPHeaderNames.RACK);

            try {
                String number = this.lexer.number();
                rack.setRSequenceNumber(Long.parseLong(number));
                this.lexer.SPorHT();
                number = this.lexer.number();
                rack.setCSequenceNumber(Long.parseLong(number));
                this.lexer.SPorHT();
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                rack.setMethod(token.getTokenValue());

            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }
            this.lexer.SPorHT();
            this.lexer.match('\n');

            return rack;
        } finally {
            if (debug)
                dbg_leave("RAckParser.parse");
        }
    }

    
}

