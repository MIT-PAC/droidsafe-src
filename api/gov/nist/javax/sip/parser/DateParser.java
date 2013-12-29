package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPDateHeader;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;
import java.util.Calendar;





public class DateParser extends HeaderParser {

    /**
     * Constructor
     * @param date message to parse to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.414 -0500", hash_original_method = "12ABECDC99786B59BCBD31A7419E2B41", hash_generated_method = "ECCFDAF9B606FB989CE4A5FB21DBB820")
    public DateParser(String date) {
        super(date);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.415 -0500", hash_original_method = "00ADBDEF8E181F85BEA9DD7E552A7849", hash_generated_method = "AC46BE51628B2FCF6492970FB346582D")
    protected DateParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * Parse method.
     * @throws ParseException
     * @return  the parsed Date header/
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.416 -0500", hash_original_method = "6D964EF3409A9BCD4AB46A00BDF7E85B", hash_generated_method = "07439D077D477A511AA7AA5CDCA06833")
    public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("DateParser.parse");
        try {
            headerName(TokenTypes.DATE);
            wkday();
            lexer.match(',');
            lexer.match(' ');
            Calendar cal = date();
            lexer.match(' ');
            time(cal);
            lexer.match(' ');
            String tzone = this.lexer.ttoken().toLowerCase();
            if (!"gmt".equals(tzone))
                throw createParseException("Bad Time Zone " + tzone);
            this.lexer.match('\n');
            SIPDateHeader retval = new SIPDateHeader();
            retval.setDate(cal);
            return retval;
        } finally {
            if (debug)
                dbg_leave("DateParser.parse");

        }

    }

    
}

