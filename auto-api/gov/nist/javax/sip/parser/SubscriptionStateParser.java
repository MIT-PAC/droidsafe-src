package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;
import javax.sip.*;

public class SubscriptionStateParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.597 -0400", hash_original_method = "604DE186E2AE6B899B90A7B635A83D11", hash_generated_method = "7B80DE7FC33BD27CF2C6FB95BF270E0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubscriptionStateParser(String subscriptionState) {
        super(subscriptionState);
        dsTaint.addTaint(subscriptionState);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.597 -0400", hash_original_method = "DBAE404317B64960398576BE2AFF6197", hash_generated_method = "2456A4B790B6254510139092DD867BCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SubscriptionStateParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.598 -0400", hash_original_method = "0E07F05FFE6C1C2F83533D7132328ECC", hash_generated_method = "55E8D5F40C35809F6FFA20815919C34B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("SubscriptionStateParser.parse");
        SubscriptionState subscriptionState;
        subscriptionState = new SubscriptionState();
        try 
        {
            headerName(TokenTypes.SUBSCRIPTION_STATE);
            subscriptionState.setHeaderName(SIPHeaderNames.SUBSCRIPTION_STATE);
            lexer.match(TokenTypes.ID);
            Token token;
            token = lexer.getNextToken();
            subscriptionState.setState(token.getTokenValue());
            {
                boolean var23D2B54EEDE70417D1C6C30933AF4A72_1172912688 = (lexer.lookAhead(0) == ';');
                {
                    this.lexer.match(';');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    String value;
                    value = token.getTokenValue();
                    {
                        boolean var8CA0A679E60695598CA7208019527079_2126228145 = (value.equalsIgnoreCase("reason"));
                        {
                            this.lexer.match('=');
                            this.lexer.SPorHT();
                            lexer.match(TokenTypes.ID);
                            token = lexer.getNextToken();
                            value = token.getTokenValue();
                            subscriptionState.setReasonCode(value);
                        } //End block
                        {
                            boolean var414B5D94C2993E1BAEBD747D160C7C92_660618664 = (value.equalsIgnoreCase("expires"));
                            {
                                this.lexer.match('=');
                                this.lexer.SPorHT();
                                lexer.match(TokenTypes.ID);
                                token = lexer.getNextToken();
                                value = token.getTokenValue();
                                try 
                                {
                                    int expires;
                                    expires = Integer.parseInt(value);
                                    subscriptionState.setExpires(expires);
                                } //End block
                                catch (NumberFormatException ex)
                                {
                                    if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                                } //End block
                                catch (InvalidArgumentException ex)
                                {
                                    if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                                } //End block
                            } //End block
                            {
                                boolean varBD4F51A266EE0B22E2DF148FAC6041BC_936484789 = (value.equalsIgnoreCase("retry-after"));
                                {
                                    this.lexer.match('=');
                                    this.lexer.SPorHT();
                                    lexer.match(TokenTypes.ID);
                                    token = lexer.getNextToken();
                                    value = token.getTokenValue();
                                    try 
                                    {
                                        int retryAfter;
                                        retryAfter = Integer.parseInt(value);
                                        subscriptionState.setRetryAfter(retryAfter);
                                    } //End block
                                    catch (NumberFormatException ex)
                                    {
                                        if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                                    } //End block
                                    catch (InvalidArgumentException ex)
                                    {
                                        if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                                    } //End block
                                } //End block
                                {
                                    this.lexer.match('=');
                                    this.lexer.SPorHT();
                                    lexer.match(TokenTypes.ID);
                                    Token secondToken;
                                    secondToken = lexer.getNextToken();
                                    String secondValue;
                                    secondValue = secondToken.getTokenValue();
                                    subscriptionState.setParameter(value, secondValue);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("SubscriptionStateParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

