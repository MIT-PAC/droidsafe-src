package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;
import gov.nist.javax.sip.header.Unsupported;
import gov.nist.javax.sip.header.UnsupportedList;

import java.text.ParseException;





public class UnsupportedParser extends HeaderParser {

    /**
     * Creates a new instance of UnsupportedParser
     * @param unsupported - Unsupported header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.031 -0500", hash_original_method = "A2BE521086BBB92362B9FD64733842A2", hash_generated_method = "E688882E7340371BF6866E83AC6F0F8F")
    public UnsupportedParser(String unsupported) {
        super(unsupported);
    }

    /**
     * Constructor
     * @param lexer - the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.032 -0500", hash_original_method = "FB5DFA63EA36D3A5606EA09CE2E82C0B", hash_generated_method = "D3C73A618EC92CB9B987DFFBAE0EA997")
    protected UnsupportedParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (Unsupported object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.033 -0500", hash_original_method = "9F68B71E39A8D368C1910EB63F18B506", hash_generated_method = "EC23550E2D5DC2CBAD5A8C6F680A40F1")
    public SIPHeader parse() throws ParseException {
        UnsupportedList unsupportedList = new UnsupportedList();
        if (debug)
            dbg_enter("UnsupportedParser.parse");

        try {
            headerName(TokenTypes.UNSUPPORTED);

            while (lexer.lookAhead(0) != '\n') {
                this.lexer.SPorHT();
                Unsupported unsupported = new Unsupported();
                unsupported.setHeaderName(SIPHeaderNames.UNSUPPORTED);

                // Parsing the option tag
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                unsupported.setOptionTag(token.getTokenValue());
                this.lexer.SPorHT();

                unsupportedList.add(unsupported);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();

                    unsupported = new Unsupported();

                    // Parsing the option tag
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    unsupported.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();

                    unsupportedList.add(unsupported);
                }

            }
        } finally {
            if (debug)
                dbg_leave("UnsupportedParser.parse");
        }

        return unsupportedList;
    }

    
}

