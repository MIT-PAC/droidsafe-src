package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.RetryAfter;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class RetryAfterParser extends HeaderParser {

    /**
     * Creates a new instance of RetryAfterParser
     * @param retryAfter the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.996 -0500", hash_original_method = "72BD428D826DE1DC77C96CF7C6F2A06C", hash_generated_method = "1A2666F65622A32BE62EAD0D1C33774A")
    public RetryAfterParser(String retryAfter) {
        super(retryAfter);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.997 -0500", hash_original_method = "E2C340AAC5E92DCEDAC2E3B0DF98081F", hash_generated_method = "A025D75719A415964E7BF7924231AB3D")
    protected RetryAfterParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (RetryAfter object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.999 -0500", hash_original_method = "4F8238CAC8DB557039065AEC5DC20094", hash_generated_method = "28013C17768ECE56E0D132D11166A41B")
    public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("RetryAfterParser.parse");

        RetryAfter retryAfter = new RetryAfter();
        try {
            headerName(TokenTypes.RETRY_AFTER);

            // mandatory delatseconds:
            String value = lexer.number();
            try {
                int ds = Integer.parseInt(value);
                retryAfter.setRetryAfter(ds);
            } catch (NumberFormatException ex) {
                throw createParseException(ex.getMessage());
            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }

            this.lexer.SPorHT();
            if (lexer.lookAhead(0) == '(') {
                String comment = this.lexer.comment();
                retryAfter.setComment(comment);
            }
            this.lexer.SPorHT();

            while (lexer.lookAhead(0) == ';') {
                this.lexer.match(';');
                this.lexer.SPorHT();
                lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                value = token.getTokenValue();
                if (value.equalsIgnoreCase("duration")) {
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    value = lexer.number();
                    try {
                        int duration = Integer.parseInt(value);
                        retryAfter.setDuration(duration);
                    } catch (NumberFormatException ex) {
                        throw createParseException(ex.getMessage());
                    } catch (InvalidArgumentException ex) {
                        throw createParseException(ex.getMessage());
                    }
                } else {
                    this.lexer.SPorHT();
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    Token secondToken = lexer.getNextToken();
                    String secondValue = secondToken.getTokenValue();
                    retryAfter.setParameter(value, secondValue);
                }
                this.lexer.SPorHT();
            }
        } finally {
            if (debug)
                dbg_leave("RetryAfterParser.parse");
        }

        return retryAfter;
    }

    
}

