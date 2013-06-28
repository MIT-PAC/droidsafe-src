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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.719 -0400", hash_original_method = "11301E3D259A26B05B62DD42A72B1913", hash_generated_method = "5AC690BDC2732CF594D2F9D097E94887")
    public  TimeStampParser(String timeStamp) {
        super(timeStamp);
        addTaint(timeStamp.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.719 -0400", hash_original_method = "ABAA3B4AC330CE8F23110008CB442301", hash_generated_method = "5F1B8EB25F098D52D269DEA2CE08F90D")
    protected  TimeStampParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.720 -0400", hash_original_method = "2B179D27AA0FC8FCF5481D4095B4030E", hash_generated_method = "5AE92CF5C1F96DCB3E25F5753F082468")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_998917731 = null; //Variable for return #1
        dbg_enter("TimeStampParser.parse");
        TimeStamp timeStamp = new TimeStamp();
        try 
        {
            headerName(TokenTypes.TIMESTAMP);
            timeStamp.setHeaderName(SIPHeaderNames.TIMESTAMP);
            this.lexer.SPorHT();
            String firstNumber = this.lexer.number();
            try 
            {
                {
                    boolean var4E25675F44D6ADE040C7E256E7201DEB_166238409 = (lexer.lookAhead(0) == '.');
                    {
                        this.lexer.match('.');
                        String secondNumber = this.lexer.number();
                        String s = firstNumber + "." + secondNumber;
                        float ts = Float.parseFloat(s);
                        timeStamp.setTimeStamp(ts);
                    } //End block
                    {
                        long ts = Long.parseLong(firstNumber);
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
                boolean varA38820C66B6BCE71087D920E2767FF09_744233608 = (lexer.lookAhead(0) != '\n');
                {
                    firstNumber = this.lexer.number();
                    try 
                    {
                        {
                            boolean var4E32D9BD2958CE3917EFADE828107656_1488322150 = (lexer.lookAhead(0) == '.');
                            {
                                this.lexer.match('.');
                                String secondNumber = this.lexer.number();
                                String s = firstNumber + "." + secondNumber;
                                float ts = Float.parseFloat(s);
                                timeStamp.setDelay(ts);
                            } //End block
                            {
                                int ts = Integer.parseInt(firstNumber);
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
        varB4EAC82CA7396A68D541C85D26508E83_998917731 = timeStamp;
        varB4EAC82CA7396A68D541C85D26508E83_998917731.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_998917731;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

