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

public class MinExpiresParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.068 -0400", hash_original_method = "958EB85119CB55ADB0187595D23A4161", hash_generated_method = "18AE5AC1AECFE735B4B780AF40AFA3F3")
    public  MinExpiresParser(String minExpires) {
        super(minExpires);
        addTaint(minExpires.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.069 -0400", hash_original_method = "C5E703E21CCA5CEB1F1840058DFBE664", hash_generated_method = "882AED7A38440106939A78D2EDA46308")
    protected  MinExpiresParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.070 -0400", hash_original_method = "67C1C5FB3D4E718484F296CD0580B923", hash_generated_method = "D7451758814B8BEBE597CEFAAF2AD53B")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_2006193604 = null; //Variable for return #1
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
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_2006193604 = minExpires;
        } //End block
        finally 
        {
            dbg_leave("MinExpiresParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2006193604.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2006193604;
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

