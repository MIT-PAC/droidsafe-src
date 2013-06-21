package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class MaxForwardsParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.312 -0400", hash_original_method = "005E89A999CEFE80041E010521110160", hash_generated_method = "C8DCB801C32E8C93DAC471E2ECE9C407")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MaxForwardsParser(String contentLength) {
        super(contentLength);
        dsTaint.addTaint(contentLength);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.312 -0400", hash_original_method = "387C44575196A6CA2DFD9A3719D601C5", hash_generated_method = "51D0B8D264EB1AC483E4D2D2CD8C2A26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MaxForwardsParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.312 -0400", hash_original_method = "1EF61729E616CF3DAFF49967F4EF386E", hash_generated_method = "02B093BF33B905CEBD8AA89E5E1EFDAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("MaxForwardsParser.enter");
        try 
        {
            MaxForwards contentLength;
            contentLength = new MaxForwards();
            headerName(TokenTypes.MAX_FORWARDS);
            String number;
            number = this.lexer.number();
            contentLength.setMaxForwards(Integer.parseInt(number));
            this.lexer.SPorHT();
            this.lexer.match('\n');
        } //End block
        catch (InvalidArgumentException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        catch (NumberFormatException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        finally 
        {
            dbg_leave("MaxForwardsParser.leave");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("MaxForwardsParser.enter");
        //try {
            //MaxForwards contentLength = new MaxForwards();
            //headerName(TokenTypes.MAX_FORWARDS);
            //String number = this.lexer.number();
            //contentLength.setMaxForwards(Integer.parseInt(number));
            //this.lexer.SPorHT();
            //this.lexer.match('\n');
            //return contentLength;
        //} catch (InvalidArgumentException ex) {
            //throw createParseException(ex.getMessage());
        //} catch (NumberFormatException ex) {
            //throw createParseException(ex.getMessage());
        //} finally {
            //if (debug)
                //dbg_leave("MaxForwardsParser.leave");
        //}
    }

    
}

