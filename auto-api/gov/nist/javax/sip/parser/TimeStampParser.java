package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;
import javax.sip.*;

public class TimeStampParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.604 -0400", hash_original_method = "11301E3D259A26B05B62DD42A72B1913", hash_generated_method = "B5C57C8E0A562FCFFA54DDDAA8D7BEC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TimeStampParser(String timeStamp) {
        super(timeStamp);
        dsTaint.addTaint(timeStamp);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.604 -0400", hash_original_method = "ABAA3B4AC330CE8F23110008CB442301", hash_generated_method = "C64F7565C1718EE41193E2544EFC4493")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected TimeStampParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.605 -0400", hash_original_method = "2B179D27AA0FC8FCF5481D4095B4030E", hash_generated_method = "E2F1C86565E0F797FAF401DF33D35CA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("TimeStampParser.parse");
        TimeStamp timeStamp;
        timeStamp = new TimeStamp();
        try 
        {
            headerName(TokenTypes.TIMESTAMP);
            timeStamp.setHeaderName(SIPHeaderNames.TIMESTAMP);
            this.lexer.SPorHT();
            String firstNumber;
            firstNumber = this.lexer.number();
            try 
            {
                {
                    boolean var4E25675F44D6ADE040C7E256E7201DEB_469129029 = (lexer.lookAhead(0) == '.');
                    {
                        this.lexer.match('.');
                        String secondNumber;
                        secondNumber = this.lexer.number();
                        String s;
                        s = firstNumber + "." + secondNumber;
                        float ts;
                        ts = Float.parseFloat(s);
                        timeStamp.setTimeStamp(ts);
                    } //End block
                    {
                        long ts;
                        ts = Long.parseLong(firstNumber);
                        timeStamp.setTime(ts);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (NumberFormatException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
            this.lexer.SPorHT();
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_891898390 = (lexer.lookAhead(0) != '\n');
                {
                    firstNumber = this.lexer.number();
                    try 
                    {
                        {
                            boolean var4E32D9BD2958CE3917EFADE828107656_1068924416 = (lexer.lookAhead(0) == '.');
                            {
                                this.lexer.match('.');
                                String secondNumber;
                                secondNumber = this.lexer.number();
                                String s;
                                s = firstNumber + "." + secondNumber;
                                float ts;
                                ts = Float.parseFloat(s);
                                timeStamp.setDelay(ts);
                            } //End block
                            {
                                int ts;
                                ts = Integer.parseInt(firstNumber);
                                timeStamp.setDelay(ts);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    catch (NumberFormatException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                    } //End block
                    catch (InvalidArgumentException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("TimeStampParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

