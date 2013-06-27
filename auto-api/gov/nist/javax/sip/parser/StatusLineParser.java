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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.243 -0400", hash_original_method = "F0811D6B30C3A9A6294707377FD9E5BC", hash_generated_method = "E81027EBAD77A0EFFD036F8BCDAF3406")
    public  StatusLineParser(String statusLine) {
        this.lexer = new Lexer("status_lineLexer", statusLine);
        addTaint(statusLine.getTaint());
        // ---------- Original Method ----------
        //this.lexer = new Lexer("status_lineLexer", statusLine);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.243 -0400", hash_original_method = "D89BEA50DEDE4DC8C4AB185A28D8567A", hash_generated_method = "7EB1C2D2951F1D19C1A7C1534C61F6E3")
    public  StatusLineParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("status_lineLexer");
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("status_lineLexer");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.244 -0400", hash_original_method = "9D10732B3C09BAF61A909B669781A09D", hash_generated_method = "A9484FF01A82A1847070B0B32577E158")
    protected int statusCode() throws ParseException {
        String scode;
        scode = this.lexer.number();
        dbg_enter("statusCode");
        try 
        {
            int retval;
            retval = Integer.parseInt(scode);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_236704985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_236704985;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.245 -0400", hash_original_method = "11C2A678ADE57722743D10D0059D6373", hash_generated_method = "7037236ABB7EB2718CE5E3B25373DE34")
    protected String reasonPhrase() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1696257553 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1696257553 = this.lexer.getRest().trim();
        varB4EAC82CA7396A68D541C85D26508E83_1696257553.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1696257553;
        // ---------- Original Method ----------
        //return this.lexer.getRest().trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.254 -0400", hash_original_method = "FDCF7CDA1662776BB5DD6F85C9EEC616", hash_generated_method = "FD9551AE6F9F62FF927FD3426545752B")
    public StatusLine parse() throws ParseException {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_1269680468 = null; //Variable for return #1
        try 
        {
            dbg_enter("parse");
            StatusLine retval;
            retval = new StatusLine();
            String version;
            version = this.sipVersion();
            retval.setSipVersion(version);
            lexer.SPorHT();
            int scode;
            scode = statusCode();
            retval.setStatusCode(scode);
            lexer.SPorHT();
            String rp;
            rp = reasonPhrase();
            retval.setReasonPhrase(rp);
            lexer.SPorHT();
            varB4EAC82CA7396A68D541C85D26508E83_1269680468 = retval;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1269680468.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1269680468;
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

