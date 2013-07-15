package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;
import javax.sip.*;

public class SubscriptionStateParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.974 -0400", hash_original_method = "604DE186E2AE6B899B90A7B635A83D11", hash_generated_method = "EE4717884D1C4FD3720AE6096B59C6FE")
    public  SubscriptionStateParser(String subscriptionState) {
        super(subscriptionState);
        addTaint(subscriptionState.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.975 -0400", hash_original_method = "DBAE404317B64960398576BE2AFF6197", hash_generated_method = "3DF077F7D908C07527C65DF0BE095586")
    protected  SubscriptionStateParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.021 -0400", hash_original_method = "0E07F05FFE6C1C2F83533D7132328ECC", hash_generated_method = "6DFF2E668EEF5FFD74CB012102D9DB81")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("SubscriptionStateParser.parse");
        SubscriptionState subscriptionState = new SubscriptionState();
        try 
        {
            headerName(TokenTypes.SUBSCRIPTION_STATE);
            subscriptionState.setHeaderName(SIPHeaderNames.SUBSCRIPTION_STATE);
            lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            subscriptionState.setState(token.getTokenValue());
            while
(lexer.lookAhead(0) == ';')            
            {
                this.lexer.match(';');
                this.lexer.SPorHT();
                lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                String value = token.getTokenValue();
    if(value.equalsIgnoreCase("reason"))                
                {
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    value = token.getTokenValue();
                    subscriptionState.setReasonCode(value);
                } //End block
                else
    if(value.equalsIgnoreCase("expires"))                
                {
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    value = token.getTokenValue();
                    try 
                    {
                        int expires = Integer.parseInt(value);
                        subscriptionState.setExpires(expires);
                    } //End block
                    catch (NumberFormatException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1884280142 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_1884280142.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_1884280142;
                    } //End block
                    catch (InvalidArgumentException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_962089614 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_962089614.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_962089614;
                    } //End block
                } //End block
                else
    if(value.equalsIgnoreCase("retry-after"))                
                {
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    value = token.getTokenValue();
                    try 
                    {
                        int retryAfter = Integer.parseInt(value);
                        subscriptionState.setRetryAfter(retryAfter);
                    } //End block
                    catch (NumberFormatException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1053311612 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_1053311612.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_1053311612;
                    } //End block
                    catch (InvalidArgumentException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_810689689 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_810689689.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_810689689;
                    } //End block
                } //End block
                else
                {
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    Token secondToken = lexer.getNextToken();
                    String secondValue = secondToken.getTokenValue();
                    subscriptionState.setParameter(value, secondValue);
                } //End block
                this.lexer.SPorHT();
            } //End block
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("SubscriptionStateParser.parse");
        } //End block
SIPHeader varA52984FDFAEAAD19E4B7B1100E2740EB_583859670 =         subscriptionState;
        varA52984FDFAEAAD19E4B7B1100E2740EB_583859670.addTaint(taint);
        return varA52984FDFAEAAD19E4B7B1100E2740EB_583859670;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

