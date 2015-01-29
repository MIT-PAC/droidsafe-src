package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ExtensionHeaderImpl;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;
import java.util.Calendar;
import java.util.TimeZone;





public class HeaderParser extends Parser {

    /**
     * Creates new HeaderParser
     * @param String to parse.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.249 -0500", hash_original_method = "D7BF0781EB1B150DCC61F7ABE4F04AEB", hash_generated_method = "DDA877F9F6A2C3A6C1912809441E01BF")
    
protected HeaderParser(String header) {
        this.lexer = new Lexer("command_keywordLexer", header);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.253 -0500", hash_original_method = "844D98E200F4C4A3FE69D132F5D518A2", hash_generated_method = "D06FF0FE4A2D9010CF5AE47D50DA6792")
    
protected HeaderParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("command_keywordLexer");
    }

    /**
     * Parse the weekday field
     * @return an integer with the calendar content for wkday.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.241 -0500", hash_original_method = "3252974D26894AAD7C4FB2AFA441C9B3", hash_generated_method = "65E8DD258BD4C129EA0C583051839A10")
    
protected int wkday() throws ParseException {
        dbg_enter("wkday");
        try {
            String tok = lexer.ttoken();
            String id = tok.toLowerCase();

            if (TokenNames.MON.equalsIgnoreCase(id))
                return Calendar.MONDAY;
            else if (TokenNames.TUE.equalsIgnoreCase(id))
                return Calendar.TUESDAY;
            else if (TokenNames.WED.equalsIgnoreCase(id))
                return Calendar.WEDNESDAY;
            else if (TokenNames.THU.equalsIgnoreCase(id))
                return Calendar.THURSDAY;
            else if (TokenNames.FRI.equalsIgnoreCase(id))
                return Calendar.FRIDAY;
            else if (TokenNames.SAT.equalsIgnoreCase(id))
                return Calendar.SATURDAY;
            else if (TokenNames.SUN.equalsIgnoreCase(id))
                return Calendar.SUNDAY;
            else
                throw createParseException("bad wkday");
        } finally {
            dbg_leave("wkday");
        }

    }

    /**
     * parse and return a date field.
     * @return a date structure with the parsed value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.244 -0500", hash_original_method = "C8449F66AC8DB5DC1EE33D138B3717DE", hash_generated_method = "CEC1D53DD057269EC187AA89A64290AC")
    
protected Calendar date() throws ParseException {
        try {
            Calendar retval = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            String s1 = lexer.number();
            int day = Integer.parseInt(s1);
            if (day <= 0 || day > 31)
                throw createParseException("Bad day ");
            retval.set(Calendar.DAY_OF_MONTH, day);
            lexer.match(' ');
            String month = lexer.ttoken().toLowerCase();
            if (month.equals("jan")) {
                retval.set(Calendar.MONTH, Calendar.JANUARY);
            } else if (month.equals("feb")) {
                retval.set(Calendar.MONTH, Calendar.FEBRUARY);
            } else if (month.equals("mar")) {
                retval.set(Calendar.MONTH, Calendar.MARCH);
            } else if (month.equals("apr")) {
                retval.set(Calendar.MONTH, Calendar.APRIL);
            } else if (month.equals("may")) {
                retval.set(Calendar.MONTH, Calendar.MAY);
            } else if (month.equals("jun")) {
                retval.set(Calendar.MONTH, Calendar.JUNE);
            } else if (month.equals("jul")) {
                retval.set(Calendar.MONTH, Calendar.JULY);
            } else if (month.equals("aug")) {
                retval.set(Calendar.MONTH, Calendar.AUGUST);
            } else if (month.equals("sep")) {
                retval.set(Calendar.MONTH, Calendar.SEPTEMBER);
            } else if (month.equals("oct")) {
                retval.set(Calendar.MONTH, Calendar.OCTOBER);
            } else if (month.equals("nov")) {
                retval.set(Calendar.MONTH, Calendar.NOVEMBER);
            } else if (month.equals("dec")) {
                retval.set(Calendar.MONTH, Calendar.DECEMBER);
            }
            lexer.match(' ');
            String s2 = lexer.number();
            int yr = Integer.parseInt(s2);
            retval.set(Calendar.YEAR, yr);
            return retval;

        } catch (Exception ex) {
            throw createParseException("bad date field");
        }

    }

    /**
     * Set the time field. This has the format hour:minute:second
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.247 -0500", hash_original_method = "A339A3BD9B311A61AF23D5CD23AA066A", hash_generated_method = "75C8DBB5EA65768EA9E86FB77BE0A833")
    
protected void time(Calendar calendar) throws ParseException {
        try {
            String s = lexer.number();
            int hour = Integer.parseInt(s);
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            lexer.match(':');
            s = lexer.number();
            int min = Integer.parseInt(s);
            calendar.set(Calendar.MINUTE, min);
            lexer.match(':');
            s = lexer.number();
            int sec = Integer.parseInt(s);
            calendar.set(Calendar.SECOND, sec);
        } catch (Exception ex) {
            throw createParseException("error processing time ");

        }

    }

    /**
     * Parse the SIP header from the buffer and return a parsed
     * structure.
     * @throws ParseException if there was an error parsing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.255 -0500", hash_original_method = "D87C47C2DE06FF746589C19C83F3FD66", hash_generated_method = "1D09630F5A69F5EAC7A2799581773E6C")
    
public SIPHeader parse() throws ParseException {
        String name = lexer.getNextToken(':');
        lexer.consume(1);
        String body = lexer.getLine().trim();
        // we dont set any fields because the header is
        // ok
        ExtensionHeaderImpl retval = new ExtensionHeaderImpl(name);
        retval.setValue(body);
        return retval;

    }

    /**
     * Parse the header name until the colon  and chew WS after that.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.258 -0500", hash_original_method = "E611EE61C75972DE5AB5B484EC7DE89C", hash_generated_method = "0175E884F26CE815B1D956FD49795CD4")
    
protected void headerName(int tok) throws ParseException {
        this.lexer.match(tok);
        this.lexer.SPorHT();
        this.lexer.match(':');
        this.lexer.SPorHT();
    }

    
}

