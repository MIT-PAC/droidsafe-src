package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.header.ContentLength;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ContentLengthParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.288 -0400", hash_original_method = "2F7FB6593647B33547E0EB2E18989DF0", hash_generated_method = "5ED8D1AD58D21E56F4BC534BC5DF815A")
    public  ContentLengthParser(String contentLength) {
        super(contentLength);
        addTaint(contentLength.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.289 -0400", hash_original_method = "BB8498A5FB1634FA5C58AED3E6D59F31", hash_generated_method = "EFE275CF87D6BF0D63AC78FBF937580A")
    protected  ContentLengthParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.339 -0400", hash_original_method = "E65999CBE5EA336AB02A5D9A8E9D84DC", hash_generated_method = "E4A4D5A1ADB98B308DF0CCAD47560CB0")
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
SIPHeader var9ADA374ACA6AF88A2E93F2C3C80FE244_644126734 =             contentLength;
            var9ADA374ACA6AF88A2E93F2C3C80FE244_644126734.addTaint(taint);
            return var9ADA374ACA6AF88A2E93F2C3C80FE244_644126734;
        } //End block
        catch (InvalidArgumentException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1551118854 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_1551118854.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_1551118854;
        } //End block
        catch (NumberFormatException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1527466689 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_1527466689.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_1527466689;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("ContentLengthParser.leave");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("ContentLengthParser.enter");
        //try {
            //ContentLength contentLength = new ContentLength();
            //headerName(TokenTypes.CONTENT_LENGTH);
            //String number = this.lexer.number();
            //contentLength.setContentLength(Integer.parseInt(number));
            //this.lexer.SPorHT();
            //this.lexer.match('\n');
            //return contentLength;
        //} catch (InvalidArgumentException ex) {
            //throw createParseException(ex.getMessage());
        //} catch (NumberFormatException ex) {
            //throw createParseException(ex.getMessage());
        //} finally {
            //if (debug)
                //dbg_leave("ContentLengthParser.leave");
        //}
    }

    
}

