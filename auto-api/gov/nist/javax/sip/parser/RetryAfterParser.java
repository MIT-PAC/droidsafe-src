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

public class RetryAfterParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.515 -0400", hash_original_method = "72BD428D826DE1DC77C96CF7C6F2A06C", hash_generated_method = "9F48B2007F3E61915AA0824D102A810A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RetryAfterParser(String retryAfter) {
        super(retryAfter);
        dsTaint.addTaint(retryAfter);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.515 -0400", hash_original_method = "E2C340AAC5E92DCEDAC2E3B0DF98081F", hash_generated_method = "5D9616A3095A63BFC3E1C308495B5899")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected RetryAfterParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.516 -0400", hash_original_method = "4F8238CAC8DB557039065AEC5DC20094", hash_generated_method = "459AFB5A9C6EEE10FC3099AEF9152A88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("RetryAfterParser.parse");
        RetryAfter retryAfter;
        retryAfter = new RetryAfter();
        try 
        {
            headerName(TokenTypes.RETRY_AFTER);
            String value;
            value = lexer.number();
            try 
            {
                int ds;
                ds = Integer.parseInt(value);
                retryAfter.setRetryAfter(ds);
            } //End block
            catch (NumberFormatException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
            this.lexer.SPorHT();
            {
                boolean var95A13FB6943DBBB304DBEB25969BEDD8_982958251 = (lexer.lookAhead(0) == '(');
                {
                    String comment;
                    comment = this.lexer.comment();
                    retryAfter.setComment(comment);
                } //End block
            } //End collapsed parenthetic
            this.lexer.SPorHT();
            {
                boolean var23D2B54EEDE70417D1C6C30933AF4A72_220145484 = (lexer.lookAhead(0) == ';');
                {
                    this.lexer.match(';');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    Token token;
                    token = lexer.getNextToken();
                    value = token.getTokenValue();
                    {
                        boolean var7B52631F8F7A6906BB65C64FC5EF0ACE_742559499 = (value.equalsIgnoreCase("duration"));
                        {
                            this.lexer.match('=');
                            this.lexer.SPorHT();
                            value = lexer.number();
                            try 
                            {
                                int duration;
                                duration = Integer.parseInt(value);
                                retryAfter.setDuration(duration);
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
                            this.lexer.SPorHT();
                            this.lexer.match('=');
                            this.lexer.SPorHT();
                            lexer.match(TokenTypes.ID);
                            Token secondToken;
                            secondToken = lexer.getNextToken();
                            String secondValue;
                            secondValue = secondToken.getTokenValue();
                            retryAfter.setParameter(value, secondValue);
                        } //End block
                    } //End collapsed parenthetic
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("RetryAfterParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

