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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.537 -0400", hash_original_method = "F0811D6B30C3A9A6294707377FD9E5BC", hash_generated_method = "727EF5D388896159C5EECC3B3F7C57A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StatusLineParser(String statusLine) {
        dsTaint.addTaint(statusLine);
        this.lexer = new Lexer("status_lineLexer", statusLine);
        // ---------- Original Method ----------
        //this.lexer = new Lexer("status_lineLexer", statusLine);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.538 -0400", hash_original_method = "D89BEA50DEDE4DC8C4AB185A28D8567A", hash_generated_method = "27441AE5C6CBD9471F0B9001E330A613")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StatusLineParser(Lexer lexer) {
        dsTaint.addTaint(lexer.dsTaint);
        this.lexer = lexer;
        this.lexer.selectLexer("status_lineLexer");
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("status_lineLexer");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.538 -0400", hash_original_method = "9D10732B3C09BAF61A909B669781A09D", hash_generated_method = "D6759767F073D648D644E9EDB660CB1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.538 -0400", hash_original_method = "11C2A678ADE57722743D10D0059D6373", hash_generated_method = "DA6CE5A3520EE78DAAE4AEB0818951C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String reasonPhrase() throws ParseException {
        String var3A47DE8649510A64F44F101E84845C62_1456524712 = (this.lexer.getRest().trim());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.lexer.getRest().trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.539 -0400", hash_original_method = "FDCF7CDA1662776BB5DD6F85C9EEC616", hash_generated_method = "197914F38B94C3B47173B485A27293FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StatusLine parse() throws ParseException {
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
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        return (StatusLine)dsTaint.getTaint();
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

