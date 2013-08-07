package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPDateHeader;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;
import java.util.Calendar;





public class DateParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.359 -0400", hash_original_method = "12ABECDC99786B59BCBD31A7419E2B41", hash_generated_method = "31E9035441D49005C3879B8FD8D40DE2")
    public  DateParser(String date) {
        super(date);
        addTaint(date.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.359 -0400", hash_original_method = "00ADBDEF8E181F85BEA9DD7E552A7849", hash_generated_method = "3AA19BA386E9B78EC047238A34FE54CF")
    protected  DateParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.414 -0400", hash_original_method = "6D964EF3409A9BCD4AB46A00BDF7E85B", hash_generated_method = "2ADC89871103B9D534B1CB89D9E58510")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("DateParser.parse");
        try 
        {
            headerName(TokenTypes.DATE);
            wkday();
            lexer.match(',');
            lexer.match(' ');
            Calendar cal = date();
            lexer.match(' ');
            time(cal);
            lexer.match(' ');
            String tzone = this.lexer.ttoken().toLowerCase();
            if(!"gmt".equals(tzone))            
            {
            java.text.ParseException var8D9243C35232C0B612F4CB18FA64769A_597672107 = createParseException("Bad Time Zone " + tzone);
            var8D9243C35232C0B612F4CB18FA64769A_597672107.addTaint(taint);
            throw var8D9243C35232C0B612F4CB18FA64769A_597672107;
            }
            this.lexer.match('\n');
            SIPDateHeader retval = new SIPDateHeader();
            retval.setDate(cal);
SIPHeader varF9E19AD6135C970F387F77C6F3DE4477_1617877444 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_1617877444.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_1617877444;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("DateParser.parse");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("DateParser.parse");
        //try {
            //headerName(TokenTypes.DATE);
            //wkday();
            //lexer.match(',');
            //lexer.match(' ');
            //Calendar cal = date();
            //lexer.match(' ');
            //time(cal);
            //lexer.match(' ');
            //String tzone = this.lexer.ttoken().toLowerCase();
            //if (!"gmt".equals(tzone))
                //throw createParseException("Bad Time Zone " + tzone);
            //this.lexer.match('\n');
            //SIPDateHeader retval = new SIPDateHeader();
            //retval.setDate(cal);
            //return retval;
        //} finally {
            //if (debug)
                //dbg_leave("DateParser.parse");
        //}
    }

    
}

