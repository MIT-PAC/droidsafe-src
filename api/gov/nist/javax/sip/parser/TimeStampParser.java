package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;
import gov.nist.javax.sip.header.TimeStamp;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class TimeStampParser extends HeaderParser {

    /**
     * Creates a new instance of TimeStampParser
     * @param timeStamp the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.074 -0500", hash_original_method = "11301E3D259A26B05B62DD42A72B1913", hash_generated_method = "D1724525721DB5F537A5B61C1E9561A4")
    
public TimeStampParser(String timeStamp) {
        super(timeStamp);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.077 -0500", hash_original_method = "ABAA3B4AC330CE8F23110008CB442301", hash_generated_method = "E93F98310B569E946D308E3FD924F807")
    
protected TimeStampParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (TimeStamp object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.081 -0500", hash_original_method = "2B179D27AA0FC8FCF5481D4095B4030E", hash_generated_method = "814C1C407F98A217222553107A0898F8")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("TimeStampParser.parse");
        TimeStamp timeStamp = new TimeStamp();
        try {
            headerName(TokenTypes.TIMESTAMP);

            timeStamp.setHeaderName(SIPHeaderNames.TIMESTAMP);

            this.lexer.SPorHT();
            String firstNumber = this.lexer.number();

            try {

                if (lexer.lookAhead(0) == '.') {
                    this.lexer.match('.');
                    String secondNumber = this.lexer.number();

                    String s = firstNumber + "." + secondNumber;
                    float ts = Float.parseFloat(s);
                    timeStamp.setTimeStamp(ts);
                } else {
                    long ts = Long.parseLong(firstNumber);
                    timeStamp.setTime(ts);
                }


            } catch (NumberFormatException ex) {
                throw createParseException(ex.getMessage());
            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }

            this.lexer.SPorHT();
            if (lexer.lookAhead(0) != '\n') {
                firstNumber = this.lexer.number();

                try {

                    if (lexer.lookAhead(0) == '.') {
                        this.lexer.match('.');
                        String secondNumber = this.lexer.number();

                        String s = firstNumber + "." + secondNumber;
                        float ts = Float.parseFloat(s);
                        timeStamp.setDelay(ts);
                    } else {
                        int ts = Integer.parseInt(firstNumber);
                        timeStamp.setDelay(ts);
                    }


                } catch (NumberFormatException ex) {
                    throw createParseException(ex.getMessage());
                } catch (InvalidArgumentException ex) {
                    throw createParseException(ex.getMessage());
                }
            }

        } finally {
            if (debug)
                dbg_leave("TimeStampParser.parse");
        }

        return timeStamp;
    }

    
}

