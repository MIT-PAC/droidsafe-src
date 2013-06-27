package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class ContentLengthParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.678 -0400", hash_original_method = "2F7FB6593647B33547E0EB2E18989DF0", hash_generated_method = "5ED8D1AD58D21E56F4BC534BC5DF815A")
    public  ContentLengthParser(String contentLength) {
        super(contentLength);
        addTaint(contentLength.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.679 -0400", hash_original_method = "BB8498A5FB1634FA5C58AED3E6D59F31", hash_generated_method = "EFE275CF87D6BF0D63AC78FBF937580A")
    protected  ContentLengthParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.680 -0400", hash_original_method = "E65999CBE5EA336AB02A5D9A8E9D84DC", hash_generated_method = "87C19F2C08A86634E367D0CDDC5B7C7C")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_2081042416 = null; //Variable for return #1
        dbg_enter("ContentLengthParser.enter");
        try 
        {
            ContentLength contentLength;
            contentLength = new ContentLength();
            headerName(TokenTypes.CONTENT_LENGTH);
            String number;
            number = this.lexer.number();
            contentLength.setContentLength(Integer.parseInt(number));
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_2081042416 = contentLength;
        } //End block
        catch (InvalidArgumentException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        catch (NumberFormatException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        finally 
        {
            dbg_leave("ContentLengthParser.leave");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2081042416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2081042416;
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

