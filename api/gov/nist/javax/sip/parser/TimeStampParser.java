package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;
import javax.sip.*;

public class TimeStampParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.049 -0400", hash_original_method = "11301E3D259A26B05B62DD42A72B1913", hash_generated_method = "5AC690BDC2732CF594D2F9D097E94887")
    public  TimeStampParser(String timeStamp) {
        super(timeStamp);
        addTaint(timeStamp.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.050 -0400", hash_original_method = "ABAA3B4AC330CE8F23110008CB442301", hash_generated_method = "5F1B8EB25F098D52D269DEA2CE08F90D")
    protected  TimeStampParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.104 -0400", hash_original_method = "2B179D27AA0FC8FCF5481D4095B4030E", hash_generated_method = "ED9F885392993EA0152D8FC3D6E88246")
    public SIPHeader parse() throws ParseException {
    if(debug)        
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
    if(lexer.lookAhead(0) == '.')                
                {
                    this.lexer.match('.');
                    String secondNumber = this.lexer.number();
                    String s = firstNumber + "." + secondNumber;
                    float ts = Float.parseFloat(s);
                    timeStamp.setTimeStamp(ts);
                } //End block
                else
                {
                    long ts = Long.parseLong(firstNumber);
                    timeStamp.setTime(ts);
                } //End block
            } //End block
            catch (NumberFormatException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1329221046 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_1329221046.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_1329221046;
            } //End block
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_2015259501 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_2015259501.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_2015259501;
            } //End block
            this.lexer.SPorHT();
    if(lexer.lookAhead(0) != '\n')            
            {
                firstNumber = this.lexer.number();
                try 
                {
    if(lexer.lookAhead(0) == '.')                    
                    {
                        this.lexer.match('.');
                        String secondNumber = this.lexer.number();
                        String s = firstNumber + "." + secondNumber;
                        float ts = Float.parseFloat(s);
                        timeStamp.setDelay(ts);
                    } //End block
                    else
                    {
                        int ts = Integer.parseInt(firstNumber);
                        timeStamp.setDelay(ts);
                    } //End block
                } //End block
                catch (NumberFormatException ex)
                {
                    java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1398925395 = createParseException(ex.getMessage());
                    varB8C80F72F95BF6A850D07F4EC5726C09_1398925395.addTaint(taint);
                    throw varB8C80F72F95BF6A850D07F4EC5726C09_1398925395;
                } //End block
                catch (InvalidArgumentException ex)
                {
                    java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1862636560 = createParseException(ex.getMessage());
                    varB8C80F72F95BF6A850D07F4EC5726C09_1862636560.addTaint(taint);
                    throw varB8C80F72F95BF6A850D07F4EC5726C09_1862636560;
                } //End block
            } //End block
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("TimeStampParser.parse");
        } //End block
SIPHeader var3ACB3605A475EC8F851EA2A7FD981522_1434942543 =         timeStamp;
        var3ACB3605A475EC8F851EA2A7FD981522_1434942543.addTaint(taint);
        return var3ACB3605A475EC8F851EA2A7FD981522_1434942543;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

