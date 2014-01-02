package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.StatusLine;

import java.text.ParseException;





public class StatusLineParser extends Parser {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.817 -0500", hash_original_method = "F0811D6B30C3A9A6294707377FD9E5BC", hash_generated_method = "45A7467F6485425BF0A2231D5E2146B6")
    
public StatusLineParser(String statusLine) {
        this.lexer = new Lexer("status_lineLexer", statusLine);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.820 -0500", hash_original_method = "D89BEA50DEDE4DC8C4AB185A28D8567A", hash_generated_method = "565A68D4D95E5B383E36B6445ADC2F52")
    
public StatusLineParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("status_lineLexer");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.822 -0500", hash_original_method = "9D10732B3C09BAF61A909B669781A09D", hash_generated_method = "83308C25865C0CD7AC41B51C79EC64F5")
    
protected int statusCode() throws ParseException {
        String scode = this.lexer.number();
        if (debug)
            dbg_enter("statusCode");
        try {
            int retval = Integer.parseInt(scode);
            return retval;
        } catch (NumberFormatException ex) {
            throw new ParseException(
                lexer.getBuffer() + ":" + ex.getMessage(),
                lexer.getPtr());
        } finally {
            if (debug)
                dbg_leave("statusCode");
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.825 -0500", hash_original_method = "11C2A678ADE57722743D10D0059D6373", hash_generated_method = "1C781FC571E47F1B9DCBF50143D9B699")
    
protected String reasonPhrase() throws ParseException {
        return this.lexer.getRest().trim();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.827 -0500", hash_original_method = "FDCF7CDA1662776BB5DD6F85C9EEC616", hash_generated_method = "4F8540AF10A81A4FE07DA80043968D88")
    
public StatusLine parse() throws ParseException {
        try {
            if (debug)
                dbg_enter("parse");
            StatusLine retval = new StatusLine();
            String version = this.sipVersion();
            retval.setSipVersion(version);
            lexer.SPorHT();
            int scode = statusCode();
            retval.setStatusCode(scode);
            lexer.SPorHT();
            String rp = reasonPhrase();
            retval.setReasonPhrase(rp);
            lexer.SPorHT();
            return retval;
        } finally {
            if (debug)
                dbg_leave("parse");
        }
    }

    
}

