package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.StatusLine;

import java.text.ParseException;





public class StatusLineParser extends Parser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.787 -0400", hash_original_method = "F0811D6B30C3A9A6294707377FD9E5BC", hash_generated_method = "F397B50EA6E3FCE8DEE7C71AE8627540")
    public  StatusLineParser(String statusLine) {
        addTaint(statusLine.getTaint());
        this.lexer = new Lexer("status_lineLexer", statusLine);
        // ---------- Original Method ----------
        //this.lexer = new Lexer("status_lineLexer", statusLine);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.788 -0400", hash_original_method = "D89BEA50DEDE4DC8C4AB185A28D8567A", hash_generated_method = "7866C00787255358665DC9ECBE14F660")
    public  StatusLineParser(Lexer lexer) {
        addTaint(lexer.getTaint());
        this.lexer = lexer;
        this.lexer.selectLexer("status_lineLexer");
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("status_lineLexer");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.788 -0400", hash_original_method = "9D10732B3C09BAF61A909B669781A09D", hash_generated_method = "51EE534C40DC456902430612E59F2DFA")
    protected int statusCode() throws ParseException {
        String scode = this.lexer.number();
        if(debug)        
        dbg_enter("statusCode");
        try 
        {
            int retval = Integer.parseInt(scode);
            int var020B759ADEF679A47CB9AFE965BB2314_573903412 = (retval);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884493960 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884493960;
        } //End block
        catch (NumberFormatException ex)
        {
            ParseException var74CDDF941F7CAD8CFD93D9838B61FA72_1785873365 = new ParseException(
                lexer.getBuffer() + ":" + ex.getMessage(),
                lexer.getPtr());
            var74CDDF941F7CAD8CFD93D9838B61FA72_1785873365.addTaint(taint);
            throw var74CDDF941F7CAD8CFD93D9838B61FA72_1785873365;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("statusCode");
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.789 -0400", hash_original_method = "11C2A678ADE57722743D10D0059D6373", hash_generated_method = "9028B69187103BA333F47819B9C1A39B")
    protected String reasonPhrase() throws ParseException {
String varC363A8A5C6F4FC7ED22F830028945703_676897867 =         this.lexer.getRest().trim();
        varC363A8A5C6F4FC7ED22F830028945703_676897867.addTaint(taint);
        return varC363A8A5C6F4FC7ED22F830028945703_676897867;
        // ---------- Original Method ----------
        //return this.lexer.getRest().trim();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.790 -0400", hash_original_method = "FDCF7CDA1662776BB5DD6F85C9EEC616", hash_generated_method = "501300B23BFD14B48ABE44A71EEE76F4")
    public StatusLine parse() throws ParseException {
        try 
        {
            if(debug)            
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
StatusLine varF9E19AD6135C970F387F77C6F3DE4477_108545901 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_108545901.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_108545901;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("parse");
        } //End block
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

