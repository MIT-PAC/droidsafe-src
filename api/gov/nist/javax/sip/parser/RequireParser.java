package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.Require;
import gov.nist.javax.sip.header.RequireList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class RequireParser extends HeaderParser {

    /**
     * Creates a new instance of RequireParser
     * @param require the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.169 -0500", hash_original_method = "36FA164E6C8032C19B516E5C5C1FBE28", hash_generated_method = "242528C7812F1224C6616609509E0754")
    public RequireParser(String require) {
        super(require);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.170 -0500", hash_original_method = "B3FB5559B13CB63E7EB6EFAD451D2F82", hash_generated_method = "B0DAB9385009FD70BEEA1185E52985AA")
    protected RequireParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (RequireList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.171 -0500", hash_original_method = "3025739AB5329DC0A390687D4C2BFD5B", hash_generated_method = "13B71AEB548DF52975090635E15697F9")
    public SIPHeader parse() throws ParseException {
        RequireList requireList = new RequireList();
        if (debug)
            dbg_enter("RequireParser.parse");

        try {
            headerName(TokenTypes.REQUIRE);

            while (lexer.lookAhead(0) != '\n') {
                Require r = new Require();
                r.setHeaderName(SIPHeaderNames.REQUIRE);

                // Parsing the option tag
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                r.setOptionTag(token.getTokenValue());
                this.lexer.SPorHT();

                requireList.add(r);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();

                    r = new Require();

                    // Parsing the option tag
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    r.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();

                    requireList.add(r);
                }

            }
        } finally {
            if (debug)
                dbg_leave("RequireParser.parse");
        }

        return requireList;
    }

    
}

