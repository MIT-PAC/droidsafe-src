package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;
import gov.nist.javax.sip.header.Warning;
import gov.nist.javax.sip.header.WarningList;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class WarningParser extends HeaderParser {

    /**
     * Constructor
     *
     * @param warning -
     *            Warning header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.546 -0500", hash_original_method = "38623B910ABA654EC8C258B1F2DD35A3", hash_generated_method = "ADAA2404AD9AFA3E4FCBF93E8A04CA7C")
    public WarningParser(String warning) {
        super(warning);
    }

    /**
     * Cosntructor
     *
     * @param lexer -
     *            the lexer to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.547 -0500", hash_original_method = "AB9AC91F8631F4AA3239C3547D18BC09", hash_generated_method = "6BC4FFEC90365BF5E44CE071D60EC134")
    protected WarningParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     *
     * @return SIPHeader (WarningList object)
     * @throws SIPParseException
     *             if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.549 -0500", hash_original_method = "5665BE3F4ECC43E3239D3F1D8B9B76A3", hash_generated_method = "426004DD56479AB68361A155302D98E9")
    public SIPHeader parse() throws ParseException {
        WarningList warningList = new WarningList();
        if (debug)
            dbg_enter("WarningParser.parse");

        try {
            headerName(TokenTypes.WARNING);

            while (lexer.lookAhead(0) != '\n') {
                Warning warning = new Warning();
                warning.setHeaderName(SIPHeaderNames.WARNING);

                // Parsing the 3digits code
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                try {
                    int code = Integer.parseInt(token.getTokenValue());
                    warning.setCode(code);
                } catch (NumberFormatException ex) {
                    throw createParseException(ex.getMessage());
                } catch (InvalidArgumentException ex) {
                    throw createParseException(ex.getMessage());
                }
                this.lexer.SPorHT();

                // Parsing the agent
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                // Bug reported by zvali@dev.java.net
                if (lexer.lookAhead(0) == ':') {
                    this.lexer.match(':');
                    this.lexer.match(TokenTypes.ID);
                    Token token2 = lexer.getNextToken();
                    warning.setAgent(token.getTokenValue() + ":"
                            + token2.getTokenValue());
                } else {
                    warning.setAgent(token.getTokenValue());
                }

                this.lexer.SPorHT();

                // Parsing the text
                String text = this.lexer.quotedString();
                warning.setText(text);
                this.lexer.SPorHT();

                warningList.add(warning);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();

                    warning = new Warning();

                    // Parsing the 3digits code
                    this.lexer.match(TokenTypes.ID);
                    Token tok = lexer.getNextToken();
                    try {
                        int code = Integer.parseInt(tok.getTokenValue());
                        warning.setCode(code);
                    } catch (NumberFormatException ex) {
                        throw createParseException(ex.getMessage());
                    } catch (InvalidArgumentException ex) {
                        throw createParseException(ex.getMessage());
                    }
                    this.lexer.SPorHT();

                    // Parsing the agent
                    this.lexer.match(TokenTypes.ID);
                    tok = lexer.getNextToken();

                    // Bug reported by zvali@dev.java.net

                    if (lexer.lookAhead(0) == ':') {
                        this.lexer.match(':');
                        this.lexer.match(TokenTypes.ID);
                        Token token2 = lexer.getNextToken();
                        warning.setAgent(tok.getTokenValue() + ":"
                                + token2.getTokenValue());
                    } else {
                        warning.setAgent(tok.getTokenValue());
                    }

                    this.lexer.SPorHT();

                    // Parsing the text
                    text = this.lexer.quotedString();
                    warning.setText(text);
                    this.lexer.SPorHT();

                    warningList.add(warning);
                }

            }
        } finally {
            if (debug)
                dbg_leave("WarningParser.parse");
        }

        return warningList;
    }

    
}

