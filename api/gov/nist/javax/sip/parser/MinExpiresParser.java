package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.MinExpires;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class MinExpiresParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.849 -0400", hash_original_method = "958EB85119CB55ADB0187595D23A4161", hash_generated_method = "18AE5AC1AECFE735B4B780AF40AFA3F3")
    public  MinExpiresParser(String minExpires) {
        super(minExpires);
        addTaint(minExpires.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.849 -0400", hash_original_method = "C5E703E21CCA5CEB1F1840058DFBE664", hash_generated_method = "882AED7A38440106939A78D2EDA46308")
    protected  MinExpiresParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.878 -0400", hash_original_method = "67C1C5FB3D4E718484F296CD0580B923", hash_generated_method = "AB5DCA8447FC9EF2E134FA0F97845E08")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("MinExpiresParser.parse");
        MinExpires minExpires = new MinExpires();
        try 
        {
            headerName(TokenTypes.MIN_EXPIRES);
            minExpires.setHeaderName(SIPHeaderNames.MIN_EXPIRES);
            String number = this.lexer.number();
            try 
            {
                minExpires.setExpires(Integer.parseInt(number));
            } //End block
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_909738057 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_909738057.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_909738057;
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var2CB14E4BC396AF8EC6AB3AF46B79F099_1288329995 =             minExpires;
            var2CB14E4BC396AF8EC6AB3AF46B79F099_1288329995.addTaint(taint);
            return var2CB14E4BC396AF8EC6AB3AF46B79F099_1288329995;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("MinExpiresParser.parse");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("MinExpiresParser.parse");
        //MinExpires minExpires = new MinExpires();
        //try {
            //headerName(TokenTypes.MIN_EXPIRES);
            //minExpires.setHeaderName(SIPHeaderNames.MIN_EXPIRES);
            //String number = this.lexer.number();
            //try {
                //minExpires.setExpires(Integer.parseInt(number));
            //} catch (InvalidArgumentException ex) {
                //throw createParseException(ex.getMessage());
            //}
            //this.lexer.SPorHT();
            //this.lexer.match('\n');
            //return minExpires;
        //} finally {
            //if (debug)
                //dbg_leave("MinExpiresParser.parse");
        //}
    }

    
}

