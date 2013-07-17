package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class ContentEncodingParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.103 -0400", hash_original_method = "025E1AD213DC2532673CB1D1FC75B1CC", hash_generated_method = "FFAAEC346361910DA318E1B0118C932F")
    public  ContentEncodingParser(String contentEncoding) {
        super(contentEncoding);
        addTaint(contentEncoding.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.104 -0400", hash_original_method = "15007428AB3C93C7C47122E74B782E26", hash_generated_method = "AF577344E81FCFEAE8DA389C0D71631C")
    protected  ContentEncodingParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.178 -0400", hash_original_method = "8ACC6861A4ACA970AEBA8CCFE6984687", hash_generated_method = "012AB41C28403B26B6CD60A3550274BB")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("ContentEncodingParser.parse");
        ContentEncodingList list = new ContentEncodingList();
        try 
        {
            headerName(TokenTypes.CONTENT_ENCODING);
            while
(lexer.lookAhead(0) != '\n')            
            {
                ContentEncoding cl = new ContentEncoding();
                cl.setHeaderName(SIPHeaderNames.CONTENT_ENCODING);
                this.lexer.SPorHT();
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                cl.setEncoding(token.getTokenValue());
                this.lexer.SPorHT();
                list.add(cl);
                while
(lexer.lookAhead(0) == ',')                
                {
                    cl = new ContentEncoding();
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    this.lexer.match(TokenTypes.ID);
                    this.lexer.SPorHT();
                    token = lexer.getNextToken();
                    cl.setEncoding(token.getTokenValue());
                    this.lexer.SPorHT();
                    list.add(cl);
                } //End block
            } //End block
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_1070799665 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1070799665.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1070799665;
        } //End block
        catch (ParseException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1598971405 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_1598971405.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_1598971405;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("ContentEncodingParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

