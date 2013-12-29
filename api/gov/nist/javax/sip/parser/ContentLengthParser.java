package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ContentLength;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class ContentLengthParser extends HeaderParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.118 -0500", hash_original_method = "2F7FB6593647B33547E0EB2E18989DF0", hash_generated_method = "9C4D9DFFC0D1C1A9DE2B069DC4A89968")
    public ContentLengthParser(String contentLength) {
        super(contentLength);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.119 -0500", hash_original_method = "BB8498A5FB1634FA5C58AED3E6D59F31", hash_generated_method = "D98DAEFA9621F4E5A91CEA9558233A9C")
    protected ContentLengthParser(Lexer lexer) {
        super(lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.120 -0500", hash_original_method = "E65999CBE5EA336AB02A5D9A8E9D84DC", hash_generated_method = "25E385F97A85801C0AE631B0027124C2")
    public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("ContentLengthParser.enter");
        try {
            ContentLength contentLength = new ContentLength();
            headerName(TokenTypes.CONTENT_LENGTH);
            String number = this.lexer.number();
            contentLength.setContentLength(Integer.parseInt(number));
            this.lexer.SPorHT();
            this.lexer.match('\n');
            return contentLength;
        } catch (InvalidArgumentException ex) {
            throw createParseException(ex.getMessage());
        } catch (NumberFormatException ex) {
            throw createParseException(ex.getMessage());
        } finally {
            if (debug)
                dbg_leave("ContentLengthParser.leave");
        }
    }

    
}

