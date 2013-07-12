package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;
import javax.sip.*;

public class RetryAfterParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.686 -0400", hash_original_method = "72BD428D826DE1DC77C96CF7C6F2A06C", hash_generated_method = "E2C7543DA0C1A825C0CFA9D6F4377574")
    public  RetryAfterParser(String retryAfter) {
        super(retryAfter);
        addTaint(retryAfter.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.687 -0400", hash_original_method = "E2C340AAC5E92DCEDAC2E3B0DF98081F", hash_generated_method = "10262A43B95845EE6DCB49933AA67729")
    protected  RetryAfterParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.732 -0400", hash_original_method = "4F8238CAC8DB557039065AEC5DC20094", hash_generated_method = "A4FBFD4AA17812BE88289156DB153B36")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("RetryAfterParser.parse");
        RetryAfter retryAfter = new RetryAfter();
        try 
        {
            headerName(TokenTypes.RETRY_AFTER);
            String value = lexer.number();
            try 
            {
                int ds = Integer.parseInt(value);
                retryAfter.setRetryAfter(ds);
            } //End block
            catch (NumberFormatException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1264435284 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_1264435284.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_1264435284;
            } //End block
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_934448330 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_934448330.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_934448330;
            } //End block
            this.lexer.SPorHT();
    if(lexer.lookAhead(0) == '(')            
            {
                String comment = this.lexer.comment();
                retryAfter.setComment(comment);
            } //End block
            this.lexer.SPorHT();
            while
(lexer.lookAhead(0) == ';')            
            {
                this.lexer.match(';');
                this.lexer.SPorHT();
                lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                value = token.getTokenValue();
    if(value.equalsIgnoreCase("duration"))                
                {
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    value = lexer.number();
                    try 
                    {
                        int duration = Integer.parseInt(value);
                        retryAfter.setDuration(duration);
                    } //End block
                    catch (NumberFormatException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_898829180 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_898829180.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_898829180;
                    } //End block
                    catch (InvalidArgumentException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1919688188 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_1919688188.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_1919688188;
                    } //End block
                } //End block
                else
                {
                    this.lexer.SPorHT();
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    Token secondToken = lexer.getNextToken();
                    String secondValue = secondToken.getTokenValue();
                    retryAfter.setParameter(value, secondValue);
                } //End block
                this.lexer.SPorHT();
            } //End block
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("RetryAfterParser.parse");
        } //End block
SIPHeader varAD44033E7D0A11FB481AB3B243C3F908_889360824 =         retryAfter;
        varAD44033E7D0A11FB481AB3B243C3F908_889360824.addTaint(taint);
        return varAD44033E7D0A11FB481AB3B243C3F908_889360824;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

