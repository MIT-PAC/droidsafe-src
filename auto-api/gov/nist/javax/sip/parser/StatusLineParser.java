package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class StatusLineParser extends Parser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.564 -0400", hash_original_method = "F0811D6B30C3A9A6294707377FD9E5BC", hash_generated_method = "E81027EBAD77A0EFFD036F8BCDAF3406")
    public  StatusLineParser(String statusLine) {
        this.lexer = new Lexer("status_lineLexer", statusLine);
        addTaint(statusLine.getTaint());
        // ---------- Original Method ----------
        //this.lexer = new Lexer("status_lineLexer", statusLine);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.564 -0400", hash_original_method = "D89BEA50DEDE4DC8C4AB185A28D8567A", hash_generated_method = "7EB1C2D2951F1D19C1A7C1534C61F6E3")
    public  StatusLineParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("status_lineLexer");
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("status_lineLexer");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.564 -0400", hash_original_method = "9D10732B3C09BAF61A909B669781A09D", hash_generated_method = "444357997BDCBFB7C062601E873D45C0")
    protected int statusCode() throws ParseException {
        String scode = this.lexer.number();
        dbg_enter("statusCode");
        try 
        {
            int retval = Integer.parseInt(scode);
        } //End block
        catch (NumberFormatException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(
                lexer.getBuffer() + ":" + ex.getMessage(),
                lexer.getPtr());
        } //End block
        finally 
        {
            dbg_leave("statusCode");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100636970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100636970;
        // ---------- Original Method ----------
        //String scode = this.lexer.number();
        //if (debug)
            //dbg_enter("statusCode");
        //try {
            //int retval = Integer.parseInt(scode);
            //return retval;
        //} catch (NumberFormatException ex) {
            //throw new ParseException(
                //lexer.getBuffer() + ":" + ex.getMessage(),
                //lexer.getPtr());
        //} finally {
            //if (debug)
                //dbg_leave("statusCode");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.565 -0400", hash_original_method = "11C2A678ADE57722743D10D0059D6373", hash_generated_method = "838AD8759C2C838AACCB72C05BA4C7D1")
    protected String reasonPhrase() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1559481039 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1559481039 = this.lexer.getRest().trim();
        varB4EAC82CA7396A68D541C85D26508E83_1559481039.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1559481039;
        // ---------- Original Method ----------
        //return this.lexer.getRest().trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.565 -0400", hash_original_method = "FDCF7CDA1662776BB5DD6F85C9EEC616", hash_generated_method = "5A90C2F3B02C92B1357FDF70FD0B4068")
    public StatusLine parse() throws ParseException {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_474552666 = null; //Variable for return #1
        try 
        {
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
            varB4EAC82CA7396A68D541C85D26508E83_474552666 = retval;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_474552666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_474552666;
        // ---------- Original Method ----------
        //try {
            //if (debug)
                //dbg_enter("parse");
            //StatusLine retval = new StatusLine();
            //String version = this.sipVersion();
            //retval.setSipVersion(version);
            //lexer.SPorHT();
            //int scode = statusCode();
            //retval.setStatusCode(scode);
            //lexer.SPorHT();
            //String rp = reasonPhrase();
            //retval.setReasonPhrase(rp);
            //lexer.SPorHT();
            //return retval;
        //} finally {
            //if (debug)
                //dbg_leave("parse");
        //}
    }

    
}

