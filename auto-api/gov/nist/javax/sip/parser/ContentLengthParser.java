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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.266 -0400", hash_original_method = "2F7FB6593647B33547E0EB2E18989DF0", hash_generated_method = "8CEF0B75F7D95F1A80D5B8D4C1BC0721")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentLengthParser(String contentLength) {
        super(contentLength);
        dsTaint.addTaint(contentLength);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.267 -0400", hash_original_method = "BB8498A5FB1634FA5C58AED3E6D59F31", hash_generated_method = "696D885D055008750A716052248C6681")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ContentLengthParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.267 -0400", hash_original_method = "E65999CBE5EA336AB02A5D9A8E9D84DC", hash_generated_method = "CE7965823257475D1541FFB264290C1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
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
        return (SIPHeader)dsTaint.getTaint();
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

