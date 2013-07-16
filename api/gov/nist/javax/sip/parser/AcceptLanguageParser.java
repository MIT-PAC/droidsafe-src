package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import gov.nist.javax.sip.header.*;
import javax.sip.*;
import java.text.ParseException;

public class AcceptLanguageParser extends HeaderParser {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.567 -0400", hash_original_method = "4ECD6586A5A6ED08B6159E7C6D7079C1", hash_generated_method = "68B941454870B09E18FF5563FC674CF8")
    public  AcceptLanguageParser(String acceptLanguage) {
        super(acceptLanguage);
        addTaint(acceptLanguage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.568 -0400", hash_original_method = "8738AF37C5C1AC35B7D6DAA26504D715", hash_generated_method = "44799DF67856C143D12EE029A648B896")
    protected  AcceptLanguageParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.658 -0400", hash_original_method = "FB0497E5D9550DB51E743204446EFE6C", hash_generated_method = "324CE1568C0420F633CD5D485CEFF917")
    public SIPHeader parse() throws ParseException {
        AcceptLanguageList acceptLanguageList = new AcceptLanguageList();
    if(debug)        
        dbg_enter("AcceptLanguageParser.parse");
        try 
        {
            headerName(TokenTypes.ACCEPT_LANGUAGE);
            while
(lexer.lookAhead(0) != '\n')            
            {
                AcceptLanguage acceptLanguage = new AcceptLanguage();
                acceptLanguage.setHeaderName(SIPHeaderNames.ACCEPT_LANGUAGE);
    if(lexer.lookAhead(0) != ';')                
                {
                    lexer.match(TokenTypes.ID);
                    Token value = lexer.getNextToken();
                    acceptLanguage.setLanguageRange(value.getTokenValue());
                } //End block
                while
(lexer.lookAhead(0) == ';')                
                {
                    this.lexer.match(';');
                    this.lexer.SPorHT();
                    this.lexer.match('q');
                    this.lexer.SPorHT();
                    this.lexer.match('=');
                    this.lexer.SPorHT();
                    lexer.match(TokenTypes.ID);
                    Token value = lexer.getNextToken();
                    try 
                    {
                        float fl = Float.parseFloat(value.getTokenValue());
                        acceptLanguage.setQValue(fl);
                    } //End block
                    catch (NumberFormatException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_165013819 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_165013819.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_165013819;
                    } //End block
                    catch (InvalidArgumentException ex)
                    {
                        java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_628575028 = createParseException(ex.getMessage());
                        varB8C80F72F95BF6A850D07F4EC5726C09_628575028.addTaint(taint);
                        throw varB8C80F72F95BF6A850D07F4EC5726C09_628575028;
                    } //End block
                    this.lexer.SPorHT();
                } //End block
                acceptLanguageList.add(acceptLanguage);
    if(lexer.lookAhead(0) == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } //End block
                else
                this.lexer.SPorHT();
            } //End block
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("AcceptLanguageParser.parse");
        } //End block
SIPHeader varDFF2A9432D2DD82E108327D2801DB658_155228206 =         acceptLanguageList;
        varDFF2A9432D2DD82E108327D2801DB658_155228206.addTaint(taint);
        return varDFF2A9432D2DD82E108327D2801DB658_155228206;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

