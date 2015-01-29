package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;
import gov.nist.javax.sip.header.SubscriptionState;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class SubscriptionStateParser extends HeaderParser {

    /**
     * Creates a new instance of SubscriptionStateParser
     * @param subscriptionState the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.842 -0500", hash_original_method = "604DE186E2AE6B899B90A7B635A83D11", hash_generated_method = "2CB7CD056B0E91053905099F59714CD2")
    
public SubscriptionStateParser(String subscriptionState) {
        super(subscriptionState);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.845 -0500", hash_original_method = "DBAE404317B64960398576BE2AFF6197", hash_generated_method = "4342FEB982433B650798D5474441D96B")
    
protected SubscriptionStateParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (SubscriptionState  object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.848 -0500", hash_original_method = "0E07F05FFE6C1C2F83533D7132328ECC", hash_generated_method = "EE89FF9318EFC8DB217D86D0CC0488F3")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("SubscriptionStateParser.parse");

        SubscriptionState subscriptionState = new SubscriptionState();
        try {
            headerName(TokenTypes.SUBSCRIPTION_STATE);

            subscriptionState.setHeaderName(SIPHeaderNames.SUBSCRIPTION_STATE);

            // State:
            lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            subscriptionState.setState(token.getTokenValue());

            while (lexer.lookAhead(0) == ';') {
                this.lexer.match(';');
                this.lexer.SPorHT();
                lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                String value = token.getTokenValue();
                if (value.equalsIgnoreCase("reason")) {
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    value = token.getTokenValue();
                    subscriptionState.setReasonCode(value);
                } else if (value.equalsIgnoreCase("expires")) {
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    value = token.getTokenValue();
                    try {
                        int expires = Integer.parseInt(value);
                        subscriptionState.setExpires(expires);
                    } catch (NumberFormatException ex) {
                        throw createParseException(ex.getMessage());
                    } catch (InvalidArgumentException ex) {
                        throw createParseException(ex.getMessage());
                    }
                } else if (value.equalsIgnoreCase("retry-after")) {
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    value = token.getTokenValue();
                    try {
                        int retryAfter = Integer.parseInt(value);
                        subscriptionState.setRetryAfter(retryAfter);
                    } catch (NumberFormatException ex) {
                        throw createParseException(ex.getMessage());
                    } catch (InvalidArgumentException ex) {
                        throw createParseException(ex.getMessage());
                    }
                } else {
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    Token secondToken = lexer.getNextToken();
                    String secondValue = secondToken.getTokenValue();
                    subscriptionState.setParameter(value, secondValue);
                }
                this.lexer.SPorHT();
            }
        } finally {
            if (debug)
                dbg_leave("SubscriptionStateParser.parse");
        }

        return subscriptionState;
    }

    
}

