package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class ContentLanguageParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.153 -0400", hash_original_method = "0E099EDE885EEFB21F71B8A7B980DD82", hash_generated_method = "89C9A160B2C1B8A9C1BDA1A76AFA4AEF")
    public  ContentLanguageParser(String contentLanguage) {
        super(contentLanguage);
        addTaint(contentLanguage.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.153 -0400", hash_original_method = "2896A247DEE95FE46B57871751B12905", hash_generated_method = "FD31EB8813837D78ACC5589B695912D3")
    protected  ContentLanguageParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.224 -0400", hash_original_method = "B9174D052A2AFCDDC5C88393A2D6AF07", hash_generated_method = "E8E14EDD8CF923959B621E82B22B7BBB")
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
                } 
            } 
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_2085606004 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_2085606004.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_2085606004;
        } 
        catch (ParseException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1740611757 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_1740611757.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_1740611757;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("ContentLanguageParser.parse");
        } 
        
        
    }

    
}

