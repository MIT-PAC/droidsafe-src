package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.RetryAfter;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class RetryAfterParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.585 -0400", hash_original_method = "72BD428D826DE1DC77C96CF7C6F2A06C", hash_generated_method = "E2C7543DA0C1A825C0CFA9D6F4377574")
    public  RetryAfterParser(String retryAfter) {
        super(retryAfter);
        addTaint(retryAfter.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.585 -0400", hash_original_method = "E2C340AAC5E92DCEDAC2E3B0DF98081F", hash_generated_method = "10262A43B95845EE6DCB49933AA67729")
    protected  RetryAfterParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.644 -0400", hash_original_method = "4F8238CAC8DB557039065AEC5DC20094", hash_generated_method = "E9C9DB96D525DAF8DEA15DEFED31C5C4")
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
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_521583747 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_521583747.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_521583747;
            } //End block
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_768993879 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_768993879.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_768993879;
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
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_151494691 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_151494691.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_151494691;
                    } //End block
                    catch (InvalidArgumentException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1565869439 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_1565869439.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_1565869439;
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
SIPHeader varAD44033E7D0A11FB481AB3B243C3F908_1706159886 =         retryAfter;
        varAD44033E7D0A11FB481AB3B243C3F908_1706159886.addTaint(taint);
        return varAD44033E7D0A11FB481AB3B243C3F908_1706159886;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

