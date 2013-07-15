package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;
import javax.sip.*;

public class RSeqParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.563 -0400", hash_original_method = "B348DC5283F0EBC54D9A2FF780CFD084", hash_generated_method = "19E58F9B2E34A4644FEA540BC42B5F57")
    public  RSeqParser(String rseq) {
        super(rseq);
        addTaint(rseq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.563 -0400", hash_original_method = "5126E3858C9B58BEE1E09B9D0E5DEFC7", hash_generated_method = "7AF2D4D55AEBB49DC8FBC47276DA96F7")
    protected  RSeqParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.580 -0400", hash_original_method = "AB1A0262C7314394004DEB16F5DFE46A", hash_generated_method = "F9552F6A4A59EBC79BA0DFB3B3D240EE")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("RSeqParser.parse");
        RSeq rseq = new RSeq();
        try 
        {
            headerName(TokenTypes.RSEQ);
            rseq.setHeaderName(SIPHeaderNames.RSEQ);
            String number = this.lexer.number();
            try 
            {
                rseq.setSeqNumber(Long.parseLong(number));
            } //End block
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_543145722 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_543145722.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_543145722;
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader varB6E01D29654A1562BB86607DADA039F5_610000632 =             rseq;
            varB6E01D29654A1562BB86607DADA039F5_610000632.addTaint(taint);
            return varB6E01D29654A1562BB86607DADA039F5_610000632;
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("RSeqParser.parse");
        } //End block
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

