package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.util.*;
import java.text.ParseException;

public class DateParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.272 -0400", hash_original_method = "12ABECDC99786B59BCBD31A7419E2B41", hash_generated_method = "C25432953E2545AEE97B1CA24DBE4BE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DateParser(String date) {
        super(date);
        dsTaint.addTaint(date);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.272 -0400", hash_original_method = "00ADBDEF8E181F85BEA9DD7E552A7849", hash_generated_method = "0AA350C0621CCFFCAB9F0B4717518D8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected DateParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.272 -0400", hash_original_method = "6D964EF3409A9BCD4AB46A00BDF7E85B", hash_generated_method = "6E112FF5CEE21C61163F407A5901B306")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("DateParser.parse");
        try 
        {
            headerName(TokenTypes.DATE);
            wkday();
            lexer.match(',');
            lexer.match(' ');
            Calendar cal;
            cal = date();
            lexer.match(' ');
            time(cal);
            lexer.match(' ');
            String tzone;
            tzone = this.lexer.ttoken().toLowerCase();
            {
                boolean var5EA11BFD516A0207FC02AAB158A24C09_1034287449 = (!"gmt".equals(tzone));
                if (DroidSafeAndroidRuntime.control) throw createParseException("Bad Time Zone " + tzone);
            } //End collapsed parenthetic
            this.lexer.match('\n');
            SIPDateHeader retval;
            retval = new SIPDateHeader();
            retval.setDate(cal);
        } //End block
        finally 
        {
            dbg_leave("DateParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
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

