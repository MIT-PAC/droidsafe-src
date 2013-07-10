package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class ContentLanguageParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.865 -0400", hash_original_method = "0E099EDE885EEFB21F71B8A7B980DD82", hash_generated_method = "89C9A160B2C1B8A9C1BDA1A76AFA4AEF")
    public  ContentLanguageParser(String contentLanguage) {
        super(contentLanguage);
        addTaint(contentLanguage.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.865 -0400", hash_original_method = "2896A247DEE95FE46B57871751B12905", hash_generated_method = "FD31EB8813837D78ACC5589B695912D3")
    protected  ContentLanguageParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.867 -0400", hash_original_method = "B9174D052A2AFCDDC5C88393A2D6AF07", hash_generated_method = "904025DCA0A68C92D2CBE2AB5ED54B68")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_844698106 = null; 
        dbg_enter("ContentLanguageParser.parse");
        ContentLanguageList list = new ContentLanguageList();
        try 
        {
            headerName(TokenTypes.CONTENT_LANGUAGE);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1290445594 = (lexer.lookAhead(0) != '\n');
                {
                    this.lexer.SPorHT();
                    this.lexer.match(TokenTypes.ID);
                    Token token = lexer.getNextToken();
                    ContentLanguage cl = new ContentLanguage( token.getTokenValue() );
                    this.lexer.SPorHT();
                    list.add(cl);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_385993913 = (lexer.lookAhead(0) == ',');
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
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_844698106 = list;
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } 
        finally 
        {
            dbg_leave("ContentLanguageParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_844698106.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_844698106;
        
        
    }

    
}

