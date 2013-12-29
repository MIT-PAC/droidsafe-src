package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;
import gov.nist.javax.sip.header.Supported;
import gov.nist.javax.sip.header.SupportedList;

import java.text.ParseException;





public class SupportedParser extends HeaderParser {

    /**
     * Creates a new instance of SupportedParser
     * @param supported the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.017 -0500", hash_original_method = "825F17E8D5A2A3E333D66101B84E14D2", hash_generated_method = "AD4FC447AE529D97C7B0E291B2C3206A")
    public SupportedParser(String supported) {
        super(supported);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.018 -0500", hash_original_method = "6DF629AC3F3B8D2B11653ABB66FFD43C", hash_generated_method = "FE3A22B10F31194FD6592970762C61CD")
    protected SupportedParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (Supported object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.019 -0500", hash_original_method = "0C976477F7A22AE527BAA6379E244E6F", hash_generated_method = "B0673D9789C64E640B95006E1104E706")
    public SIPHeader parse() throws ParseException {
        SupportedList supportedList = new SupportedList();
        if (debug)
            dbg_enter("SupportedParser.parse");

        try {
            headerName(TokenTypes.SUPPORTED);

            while (lexer.lookAhead(0) != '\n') {
                this.lexer.SPorHT();
                Supported supported = new Supported();
                supported.setHeaderName(SIPHeaderNames.SUPPORTED);

                // Parsing the option tag
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                supported.setOptionTag(token.getTokenValue());
                this.lexer.SPorHT();

                supportedList.add(supported);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();

                    supported = new Supported();

                    // Parsing the option tag
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    supported.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();

                    supportedList.add(supported);
                }

            }
        } finally {
            if (debug)
                dbg_leave("SupportedParser.parse");
        }

        return supportedList;
    }

    
}

