package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;
import gov.nist.javax.sip.header.SubscriptionState;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class SubscriptionStateParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.906 -0400", hash_original_method = "604DE186E2AE6B899B90A7B635A83D11", hash_generated_method = "EE4717884D1C4FD3720AE6096B59C6FE")
    public  SubscriptionStateParser(String subscriptionState) {
        super(subscriptionState);
        addTaint(subscriptionState.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.907 -0400", hash_original_method = "DBAE404317B64960398576BE2AFF6197", hash_generated_method = "3DF077F7D908C07527C65DF0BE095586")
    protected  SubscriptionStateParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.974 -0400", hash_original_method = "0E07F05FFE6C1C2F83533D7132328ECC", hash_generated_method = "E43C436C1C34DEE18B01E15A42B9CF8B")
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
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1765894858 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_1765894858.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_1765894858;
                    } //End block
                    catch (InvalidArgumentException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1738192271 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_1738192271.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_1738192271;
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
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_485290119 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_485290119.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_485290119;
                    } //End block
                    catch (InvalidArgumentException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_905430138 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_905430138.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_905430138;
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
SIPHeader varA52984FDFAEAAD19E4B7B1100E2740EB_594801313 =         subscriptionState;
        varA52984FDFAEAAD19E4B7B1100E2740EB_594801313.addTaint(taint);
        return varA52984FDFAEAAD19E4B7B1100E2740EB_594801313;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

