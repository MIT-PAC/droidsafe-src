package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;
import javax.sip.*;

public class RetryAfterParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.516 -0400", hash_original_method = "72BD428D826DE1DC77C96CF7C6F2A06C", hash_generated_method = "E2C7543DA0C1A825C0CFA9D6F4377574")
    public  RetryAfterParser(String retryAfter) {
        super(retryAfter);
        addTaint(retryAfter.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.516 -0400", hash_original_method = "E2C340AAC5E92DCEDAC2E3B0DF98081F", hash_generated_method = "10262A43B95845EE6DCB49933AA67729")
    protected  RetryAfterParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.518 -0400", hash_original_method = "4F8238CAC8DB557039065AEC5DC20094", hash_generated_method = "12B585D5DE236C4B7D84E7B13FED62F3")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1028439868 = null; 
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
            } 
            catch (NumberFormatException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } 
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } 
            this.lexer.SPorHT();
            {
                boolean var95A13FB6943DBBB304DBEB25969BEDD8_736841937 = (lexer.lookAhead(0) == '(');
                {
                    String comment = this.lexer.comment();
                    retryAfter.setComment(comment);
                } 
            } 
            this.lexer.SPorHT();
            {
                boolean var23D2B54EEDE70417D1C6C30933AF4A72_1788342988 = (lexer.lookAhead(0) == ';');
                {
                    this.lexer.match(';');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    Token token = lexer.getNextToken();
                    value = token.getTokenValue();
                    {
                        boolean var7B52631F8F7A6906BB65C64FC5EF0ACE_2099116796 = (value.equalsIgnoreCase("duration"));
                        {
                            this.lexer.match('=');
                            this.lexer.SPorHT();
                            value = lexer.number();
                            try 
                            {
                                int duration = Integer.parseInt(value);
                                retryAfter.setDuration(duration);
                            } 
                            catch (NumberFormatException ex)
                            {
                                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                            } 
                            catch (InvalidArgumentException ex)
                            {
                                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                            } 
                        } 
                        {
                            this.lexer.SPorHT();
                            this.lexer.match('=');
                            this.lexer.SPorHT();
                            lexer.match(TokenTypes.ID);
                            Token secondToken = lexer.getNextToken();
                            String secondValue = secondToken.getTokenValue();
                            retryAfter.setParameter(value, secondValue);
                        } 
                    } 
                    this.lexer.SPorHT();
                } 
            } 
        } 
        finally 
        {
            dbg_leave("RetryAfterParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1028439868 = retryAfter;
        varB4EAC82CA7396A68D541C85D26508E83_1028439868.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1028439868;
        
        
    }

    
}

