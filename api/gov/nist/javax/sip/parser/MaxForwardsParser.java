package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.MaxForwards;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class MaxForwardsParser extends HeaderParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.032 -0500", hash_original_method = "005E89A999CEFE80041E010521110160", hash_generated_method = "B4643508ECA01382DB745682F05E9AA2")
    
public MaxForwardsParser(String contentLength) {
        super(contentLength);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.035 -0500", hash_original_method = "387C44575196A6CA2DFD9A3719D601C5", hash_generated_method = "653CCD9A1865A2D7CDD60869F61687C8")
    
protected MaxForwardsParser(Lexer lexer) {
        super(lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.038 -0500", hash_original_method = "1EF61729E616CF3DAFF49967F4EF386E", hash_generated_method = "AAEF54DC69F49C6F1283A4394E153EF2")
    
public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("MaxForwardsParser.enter");
        try {
            MaxForwards contentLength = new MaxForwards();
            headerName(TokenTypes.MAX_FORWARDS);
            String number = this.lexer.number();
            contentLength.setMaxForwards(Integer.parseInt(number));
            this.lexer.SPorHT();
            this.lexer.match('\n');
            return contentLength;
        } catch (InvalidArgumentException ex) {
            throw createParseException(ex.getMessage());
        } catch (NumberFormatException ex) {
            throw createParseException(ex.getMessage());
        } finally {
            if (debug)
                dbg_leave("MaxForwardsParser.leave");
        }
    }

    
}

