package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;
import gov.nist.javax.sip.header.Warning;
import gov.nist.javax.sip.header.WarningList;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class WarningParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.571 -0400", hash_original_method = "38623B910ABA654EC8C258B1F2DD35A3", hash_generated_method = "7571F0DA3DE7DAA09495023E92213CDE")
    public  WarningParser(String warning) {
        super(warning);
        addTaint(warning.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.571 -0400", hash_original_method = "AB9AC91F8631F4AA3239C3547D18BC09", hash_generated_method = "558DDFFCB57EFAB6AF04A2FE9DBB1F70")
    protected  WarningParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.690 -0400", hash_original_method = "5665BE3F4ECC43E3239D3F1D8B9B76A3", hash_generated_method = "D30DEB7A5B1F69C2FDBB0AF3D4726388")
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
                } //End block
                catch (NumberFormatException ex)
                {
                    java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1666283884 = createParseException(ex.getMessage());
                    varB8C80F72F95BF6A850D07F4EC5726C09_1666283884.addTaint(taint);
                    throw varB8C80F72F95BF6A850D07F4EC5726C09_1666283884;
                } //End block
                catch (InvalidArgumentException ex)
                {
                    java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_53843300 = createParseException(ex.getMessage());
                    varB8C80F72F95BF6A850D07F4EC5726C09_53843300.addTaint(taint);
                    throw varB8C80F72F95BF6A850D07F4EC5726C09_53843300;
                } //End block
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
                } //End block
                else
                {
                    warning.setAgent(token.getTokenValue());
                } //End block
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
                    } //End block
                    catch (NumberFormatException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1355492395 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_1355492395.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_1355492395;
                    } //End block
                    catch (InvalidArgumentException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_677565147 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_677565147.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_677565147;
                    } //End block
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
                    } //End block
                    else
                    {
                        warning.setAgent(tok.getTokenValue());
                    } //End block
                    this.lexer.SPorHT();
                    text = this.lexer.quotedString();
                    warning.setText(text);
                    this.lexer.SPorHT();
                    warningList.add(warning);
                } //End block
            } //End block
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("WarningParser.parse");
        } //End block
SIPHeader var42F0E3ACF43E718FBD7FE1AF4BC220BA_1932564838 =         warningList;
        var42F0E3ACF43E718FBD7FE1AF4BC220BA_1932564838.addTaint(taint);
        return var42F0E3ACF43E718FBD7FE1AF4BC220BA_1932564838;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

