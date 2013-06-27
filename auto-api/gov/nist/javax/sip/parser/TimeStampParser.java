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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.327 -0400", hash_original_method = "11301E3D259A26B05B62DD42A72B1913", hash_generated_method = "5AC690BDC2732CF594D2F9D097E94887")
    public  TimeStampParser(String timeStamp) {
        super(timeStamp);
        addTaint(timeStamp.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.328 -0400", hash_original_method = "ABAA3B4AC330CE8F23110008CB442301", hash_generated_method = "5F1B8EB25F098D52D269DEA2CE08F90D")
    protected  TimeStampParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.334 -0400", hash_original_method = "2B179D27AA0FC8FCF5481D4095B4030E", hash_generated_method = "BF31E260FD310ED428DEACEC02E91B93")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1200064206 = null; //Variable for return #1
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
                    boolean var4E25675F44D6ADE040C7E256E7201DEB_1332208851 = (lexer.lookAhead(0) == '.');
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
                boolean varA38820C66B6BCE71087D920E2767FF09_1955384395 = (lexer.lookAhead(0) != '\n');
                {
                    firstNumber = this.lexer.number();
                    try 
                    {
                        {
                            boolean var4E32D9BD2958CE3917EFADE828107656_943417634 = (lexer.lookAhead(0) == '.');
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
        varB4EAC82CA7396A68D541C85D26508E83_1200064206 = timeStamp;
        varB4EAC82CA7396A68D541C85D26508E83_1200064206.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1200064206;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

