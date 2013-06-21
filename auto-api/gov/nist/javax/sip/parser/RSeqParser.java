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

public class RSeqParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.495 -0400", hash_original_method = "B348DC5283F0EBC54D9A2FF780CFD084", hash_generated_method = "0401781123CDF8AF0F4ED8D9A999E6D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RSeqParser(String rseq) {
        super(rseq);
        dsTaint.addTaint(rseq);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.496 -0400", hash_original_method = "5126E3858C9B58BEE1E09B9D0E5DEFC7", hash_generated_method = "6FE4D98A5814089C660F37E65BFA66BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected RSeqParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.496 -0400", hash_original_method = "AB1A0262C7314394004DEB16F5DFE46A", hash_generated_method = "B217548004554CFDEB029088D5C544B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("RSeqParser.parse");
        RSeq rseq;
        rseq = new RSeq();
        try 
        {
            headerName(TokenTypes.RSEQ);
            rseq.setHeaderName(SIPHeaderNames.RSEQ);
            String number;
            number = this.lexer.number();
            try 
            {
                rseq.setSeqNumber(Long.parseLong(number));
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
            dbg_leave("RSeqParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("RSeqParser.parse");
        //RSeq rseq = new RSeq();
        //try {
            //headerName(TokenTypes.RSEQ);
            //rseq.setHeaderName(SIPHeaderNames.RSEQ);
            //String number = this.lexer.number();
            //try {
                //rseq.setSeqNumber(Long.parseLong(number));
            //} catch (InvalidArgumentException ex) {
                //throw createParseException(ex.getMessage());
            //}
            //this.lexer.SPorHT();
            //this.lexer.match('\n');
            //return rseq;
        //} finally {
            //if (debug)
                //dbg_leave("RSeqParser.parse");
        //}
    }

    
}

