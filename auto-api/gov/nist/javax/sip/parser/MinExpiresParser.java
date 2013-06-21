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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.316 -0400", hash_original_method = "958EB85119CB55ADB0187595D23A4161", hash_generated_method = "90CFED86FEE3CB88448B9EB0AC4DBF88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MinExpiresParser(String minExpires) {
        super(minExpires);
        dsTaint.addTaint(minExpires);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.316 -0400", hash_original_method = "C5E703E21CCA5CEB1F1840058DFBE664", hash_generated_method = "4D6D23ADB7B7D7BF8C1C10E471CEFB14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MinExpiresParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.317 -0400", hash_original_method = "67C1C5FB3D4E718484F296CD0580B923", hash_generated_method = "48FFD427A09BF446A00967CA16D20D0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("MinExpiresParser.parse");
        MinExpires minExpires;
        minExpires = new MinExpires();
        try 
        {
            headerName(TokenTypes.MIN_EXPIRES);
            minExpires.setHeaderName(SIPHeaderNames.MIN_EXPIRES);
            String number;
            number = this.lexer.number();
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
        } //End block
        finally 
        {
            dbg_leave("MinExpiresParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
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

