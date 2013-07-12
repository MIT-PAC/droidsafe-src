package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class ContentDispositionParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.005 -0400", hash_original_method = "04008A13B0A5E88C87B63AAF08ED822A", hash_generated_method = "690DFA335DDBFB3F5251BBC4962C114D")
    public  ContentDispositionParser(String contentDisposition) {
        super(contentDisposition);
        addTaint(contentDisposition.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.020 -0400", hash_original_method = "7D9894E3DD1592FE62F944EB2803724D", hash_generated_method = "523EE1F84C89EE7708D60186E2EC3461")
    protected  ContentDispositionParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.052 -0400", hash_original_method = "C25B69CBC1412EAEFB170FBF9B530EF5", hash_generated_method = "EBACF7A9B8D01574559FC347E14025B0")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("ContentDispositionParser.parse");
        try 
        {
            headerName(TokenTypes.CONTENT_DISPOSITION);
            ContentDisposition cd = new ContentDisposition();
            cd.setHeaderName(SIPHeaderNames.CONTENT_DISPOSITION);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            cd.setDispositionType(token.getTokenValue());
            this.lexer.SPorHT();
            super.parse(cd);
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var001A6EEFB4DC63CD7C230871097073C8_1527786846 =             cd;
            var001A6EEFB4DC63CD7C230871097073C8_1527786846.addTaint(taint);
            return var001A6EEFB4DC63CD7C230871097073C8_1527786846;
        } 
        catch (ParseException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1918394645 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_1918394645.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_1918394645;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("ContentDispositionParser.parse");
        } 
        
        
    }

    
}

