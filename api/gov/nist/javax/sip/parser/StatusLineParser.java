package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class StatusLineParser extends Parser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.848 -0400", hash_original_method = "F0811D6B30C3A9A6294707377FD9E5BC", hash_generated_method = "F397B50EA6E3FCE8DEE7C71AE8627540")
    public  StatusLineParser(String statusLine) {
        addTaint(statusLine.getTaint());
        this.lexer = new Lexer("status_lineLexer", statusLine);
        // ---------- Original Method ----------
        //this.lexer = new Lexer("status_lineLexer", statusLine);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.849 -0400", hash_original_method = "D89BEA50DEDE4DC8C4AB185A28D8567A", hash_generated_method = "7866C00787255358665DC9ECBE14F660")
    public  StatusLineParser(Lexer lexer) {
        addTaint(lexer.getTaint());
        this.lexer = lexer;
        this.lexer.selectLexer("status_lineLexer");
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("status_lineLexer");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.849 -0400", hash_original_method = "9D10732B3C09BAF61A909B669781A09D", hash_generated_method = "FC0FD5DC0730C016BBEA43FD5FF873B5")
    protected int statusCode() throws ParseException {
        String scode = this.lexer.number();
    if(debug)        
        dbg_enter("statusCode");
        try 
        {
            int retval = Integer.parseInt(scode);
            int var020B759ADEF679A47CB9AFE965BB2314_203512263 = (retval);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707532805 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707532805;
        } //End block
        catch (NumberFormatException ex)
        {
            ParseException var74CDDF941F7CAD8CFD93D9838B61FA72_1495714646 = new ParseException(
                lexer.getBuffer() + ":" + ex.getMessage(),
                lexer.getPtr());
            var74CDDF941F7CAD8CFD93D9838B61FA72_1495714646.addTaint(taint);
            throw var74CDDF941F7CAD8CFD93D9838B61FA72_1495714646;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.850 -0400", hash_original_method = "11C2A678ADE57722743D10D0059D6373", hash_generated_method = "B0736E706C021B181E1DAC281DE2AAA7")
    protected String reasonPhrase() throws ParseException {
String varC363A8A5C6F4FC7ED22F830028945703_1824180787 =         this.lexer.getRest().trim();
        varC363A8A5C6F4FC7ED22F830028945703_1824180787.addTaint(taint);
        return varC363A8A5C6F4FC7ED22F830028945703_1824180787;
        // ---------- Original Method ----------
        //return this.lexer.getRest().trim();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.851 -0400", hash_original_method = "FDCF7CDA1662776BB5DD6F85C9EEC616", hash_generated_method = "5E4C2F1429E0BA41EEC9F33260D11204")
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
StatusLine varF9E19AD6135C970F387F77C6F3DE4477_1143068702 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_1143068702.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_1143068702;
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

