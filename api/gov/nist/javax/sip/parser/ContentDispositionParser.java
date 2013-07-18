package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.core.Token;
import gov.nist.javax.sip.header.ContentDisposition;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ContentDispositionParser extends ParametersParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.038 -0400", hash_original_method = "04008A13B0A5E88C87B63AAF08ED822A", hash_generated_method = "690DFA335DDBFB3F5251BBC4962C114D")
    public  ContentDispositionParser(String contentDisposition) {
        super(contentDisposition);
        addTaint(contentDisposition.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.039 -0400", hash_original_method = "7D9894E3DD1592FE62F944EB2803724D", hash_generated_method = "523EE1F84C89EE7708D60186E2EC3461")
    protected  ContentDispositionParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.091 -0400", hash_original_method = "C25B69CBC1412EAEFB170FBF9B530EF5", hash_generated_method = "C850C3D417E1FEDBE760BFF338ECE625")
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
SIPHeader var001A6EEFB4DC63CD7C230871097073C8_1893789385 =             cd;
            var001A6EEFB4DC63CD7C230871097073C8_1893789385.addTaint(taint);
            return var001A6EEFB4DC63CD7C230871097073C8_1893789385;
        } //End block
        catch (ParseException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_135305603 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_135305603.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_135305603;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("ContentDispositionParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

