package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.header.RSeq;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RSeqParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.428 -0400", hash_original_method = "B348DC5283F0EBC54D9A2FF780CFD084", hash_generated_method = "19E58F9B2E34A4644FEA540BC42B5F57")
    public  RSeqParser(String rseq) {
        super(rseq);
        addTaint(rseq.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.429 -0400", hash_original_method = "5126E3858C9B58BEE1E09B9D0E5DEFC7", hash_generated_method = "7AF2D4D55AEBB49DC8FBC47276DA96F7")
    protected  RSeqParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.449 -0400", hash_original_method = "AB1A0262C7314394004DEB16F5DFE46A", hash_generated_method = "A1AAF21B38D85098E08C0E0D400521EB")
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
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1443390872 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_1443390872.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_1443390872;
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader varB6E01D29654A1562BB86607DADA039F5_772820583 =             rseq;
            varB6E01D29654A1562BB86607DADA039F5_772820583.addTaint(taint);
            return varB6E01D29654A1562BB86607DADA039F5_772820583;
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

