package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class ContentLengthParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.259 -0400", hash_original_method = "2F7FB6593647B33547E0EB2E18989DF0", hash_generated_method = "5ED8D1AD58D21E56F4BC534BC5DF815A")
    public  ContentLengthParser(String contentLength) {
        super(contentLength);
        addTaint(contentLength.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.259 -0400", hash_original_method = "BB8498A5FB1634FA5C58AED3E6D59F31", hash_generated_method = "EFE275CF87D6BF0D63AC78FBF937580A")
    protected  ContentLengthParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.313 -0400", hash_original_method = "E65999CBE5EA336AB02A5D9A8E9D84DC", hash_generated_method = "C04493683124A8C99AF955073BE290C3")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("ContentLengthParser.enter");
        try 
        {
            ContentLength contentLength = new ContentLength();
            headerName(TokenTypes.CONTENT_LENGTH);
            String number = this.lexer.number();
            contentLength.setContentLength(Integer.parseInt(number));
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var9ADA374ACA6AF88A2E93F2C3C80FE244_112309285 =             contentLength;
            var9ADA374ACA6AF88A2E93F2C3C80FE244_112309285.addTaint(taint);
            return var9ADA374ACA6AF88A2E93F2C3C80FE244_112309285;
        } 
        catch (InvalidArgumentException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_524930067 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_524930067.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_524930067;
        } 
        catch (NumberFormatException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1515879887 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_1515879887.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_1515879887;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("ContentLengthParser.leave");
        } 
        
        
            
        
            
            
            
            
            
            
            
        
            
        
            
        
            
                
        
    }

    
}

