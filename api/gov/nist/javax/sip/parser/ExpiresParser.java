package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.Expires;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class ExpiresParser extends HeaderParser {

    /**
     * protected constructor.
     * @param text is the text of the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.177 -0500", hash_original_method = "A7328899640752C7683A3AAB5686C434", hash_generated_method = "071464AC71F88703F1DBFB2604480B59")
    
public ExpiresParser(String text) {
        super(text);
    }

    /**
     * constructor.
     * @param lexer is the lexer passed in from the enclosing parser.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.180 -0500", hash_original_method = "8C0F40C2F214AF533DDC04CFAC4ADA24", hash_generated_method = "0A0C5A0D6281536807D9F7C35B7BBA1C")
    
protected ExpiresParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * Parse the header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.184 -0500", hash_original_method = "BF637AC6A5CBD4DC0512611361485C35", hash_generated_method = "5720A95E75AB25376B8B192DFC3620A0")
    
public SIPHeader parse() throws ParseException {
        Expires expires = new Expires();
        if (debug)
            dbg_enter("parse");
        try {
            lexer.match(TokenTypes.EXPIRES);
            lexer.SPorHT();
            lexer.match(':');
            lexer.SPorHT();
            String nextId = lexer.getNextId();
            lexer.match('\n');
            try {
                int delta = Integer.parseInt(nextId);
                expires.setExpires(delta);
                return expires;
            } catch (NumberFormatException ex) {
                throw createParseException("bad integer format");
            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }
        } finally {
            if (debug)
                dbg_leave("parse");
        }

    }

    
}

