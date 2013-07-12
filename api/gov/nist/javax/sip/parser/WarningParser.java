package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;
import javax.sip.*;

public class WarningParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.589 -0400", hash_original_method = "38623B910ABA654EC8C258B1F2DD35A3", hash_generated_method = "7571F0DA3DE7DAA09495023E92213CDE")
    public  WarningParser(String warning) {
        super(warning);
        addTaint(warning.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.589 -0400", hash_original_method = "AB9AC91F8631F4AA3239C3547D18BC09", hash_generated_method = "558DDFFCB57EFAB6AF04A2FE9DBB1F70")
    protected  WarningParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.675 -0400", hash_original_method = "5665BE3F4ECC43E3239D3F1D8B9B76A3", hash_generated_method = "B7A13A41AB1931791E791CA9C69BF1D8")
    public SIPHeader parse() throws ParseException {
        WarningList warningList = new WarningList();
    if(debug)        
        dbg_enter("WarningParser.parse");
        try 
        {
            headerName(TokenTypes.WARNING);
            while
(lexer.lookAhead(0) != '\n')            
            {
                Warning warning = new Warning();
                warning.setHeaderName(SIPHeaderNames.WARNING);
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                try 
                {
                    int code = Integer.parseInt(token.getTokenValue());
                    warning.setCode(code);
                } 
                catch (NumberFormatException ex)
                {
                    java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1296742253 = createParseException(ex.getMessage());
                    varB8C80F72F95BF6A850D07F4EC5726C09_1296742253.addTaint(taint);
                    throw varB8C80F72F95BF6A850D07F4EC5726C09_1296742253;
                } 
                catch (InvalidArgumentException ex)
                {
                    java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_296487068 = createParseException(ex.getMessage());
                    varB8C80F72F95BF6A850D07F4EC5726C09_296487068.addTaint(taint);
                    throw varB8C80F72F95BF6A850D07F4EC5726C09_296487068;
                } 
                this.lexer.SPorHT();
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
    if(lexer.lookAhead(0) == ':')                
                {
                    this.lexer.match(':');
                    this.lexer.match(TokenTypes.ID);
                    Token token2 = lexer.getNextToken();
                    warning.setAgent(token.getTokenValue() + ":"
                            + token2.getTokenValue());
                } 
                else
                {
                    warning.setAgent(token.getTokenValue());
                } 
                this.lexer.SPorHT();
                String text = this.lexer.quotedString();
                warning.setText(text);
                this.lexer.SPorHT();
                warningList.add(warning);
                while
(lexer.lookAhead(0) == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    warning = new Warning();
                    this.lexer.match(TokenTypes.ID);
                    Token tok = lexer.getNextToken();
                    try 
                    {
                        int code = Integer.parseInt(tok.getTokenValue());
                        warning.setCode(code);
                    } 
                    catch (NumberFormatException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1671084187 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_1671084187.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_1671084187;
                    } 
                    catch (InvalidArgumentException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_734159658 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_734159658.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_734159658;
                    } 
                    this.lexer.SPorHT();
                    this.lexer.match(TokenTypes.ID);
                    tok = lexer.getNextToken();
    if(lexer.lookAhead(0) == ':')                    
                    {
                        this.lexer.match(':');
                        this.lexer.match(TokenTypes.ID);
                        Token token2 = lexer.getNextToken();
                        warning.setAgent(tok.getTokenValue() + ":"
                                + token2.getTokenValue());
                    } 
                    else
                    {
                        warning.setAgent(tok.getTokenValue());
                    } 
                    this.lexer.SPorHT();
                    text = this.lexer.quotedString();
                    warning.setText(text);
                    this.lexer.SPorHT();
                    warningList.add(warning);
                } 
            } 
        } 
        finally 
        {
    if(debug)            
            dbg_leave("WarningParser.parse");
        } 
SIPHeader var42F0E3ACF43E718FBD7FE1AF4BC220BA_442801622 =         warningList;
        var42F0E3ACF43E718FBD7FE1AF4BC220BA_442801622.addTaint(taint);
        return var42F0E3ACF43E718FBD7FE1AF4BC220BA_442801622;
        
        
    }

    
}

