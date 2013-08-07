package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.ContentLanguage;
import gov.nist.javax.sip.header.ContentLanguageList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class ContentLanguageParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.190 -0400", hash_original_method = "0E099EDE885EEFB21F71B8A7B980DD82", hash_generated_method = "89C9A160B2C1B8A9C1BDA1A76AFA4AEF")
    public  ContentLanguageParser(String contentLanguage) {
        super(contentLanguage);
        addTaint(contentLanguage.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.191 -0400", hash_original_method = "2896A247DEE95FE46B57871751B12905", hash_generated_method = "FD31EB8813837D78ACC5589B695912D3")
    protected  ContentLanguageParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.278 -0400", hash_original_method = "B9174D052A2AFCDDC5C88393A2D6AF07", hash_generated_method = "141E1B346828A07C1CB970D75D465F75")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("ContentLanguageParser.parse");
        ContentLanguageList list = new ContentLanguageList();
        try 
        {
            headerName(TokenTypes.CONTENT_LANGUAGE);
            while
(lexer.lookAhead(0) != '\n')            
            {
                this.lexer.SPorHT();
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                ContentLanguage cl = new ContentLanguage( token.getTokenValue() );
                this.lexer.SPorHT();
                list.add(cl);
                while
(lexer.lookAhead(0) == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    this.lexer.match(TokenTypes.ID);
                    this.lexer.SPorHT();
                    token = lexer.getNextToken();
                    cl = new ContentLanguage( token.getTokenValue() );
                    this.lexer.SPorHT();
                    list.add(cl);
                } //End block
            } //End block
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_412900731 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_412900731.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_412900731;
        } //End block
        catch (ParseException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_615154651 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_615154651.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_615154651;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("ContentLanguageParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

