package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.core.Debug;
import gov.nist.javax.sip.header.CSeq;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.message.SIPRequest;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class CSeqParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.903 -0400", hash_original_method = "315D7450D70C30EDB72AC7255664118E", hash_generated_method = "A8FDE793BDDBAFC103CC08AC2EE3CE0D")
    public  CSeqParser(String cseq) {
        super(cseq);
        addTaint(cseq.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.903 -0400", hash_original_method = "8A2748B0467C573864DACC8328A787A7", hash_generated_method = "206A239BD298BB64B23E3F5F5597EE51")
    protected  CSeqParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.944 -0400", hash_original_method = "25983B4EEF6E8D8834C12C4F0FEB872C", hash_generated_method = "420F56FCEF41616217741D17A97EC87B")
    public SIPHeader parse() throws ParseException {
        try 
        {
            CSeq c = new CSeq();
            this.lexer.match(TokenTypes.CSEQ);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            String number = this.lexer.number();
            c.setSeqNumber(Long.parseLong(number));
            this.lexer.SPorHT();
            String m = SIPRequest.getCannonicalName( method() );
            c.setMethod(m);
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var807FB10045EE51C06BDB74744A6714DF_1042916618 =             c;
            var807FB10045EE51C06BDB74744A6714DF_1042916618.addTaint(taint);
            return var807FB10045EE51C06BDB74744A6714DF_1042916618;
        } //End block
        catch (NumberFormatException ex)
        {
            Debug.printStackTrace(ex);
            java.text.ParseException var47EC6AB6ED56A46F510856200B27A259_1100493333 = createParseException("Number format exception");
            var47EC6AB6ED56A46F510856200B27A259_1100493333.addTaint(taint);
            throw var47EC6AB6ED56A46F510856200B27A259_1100493333;
        } //End block
        catch (InvalidArgumentException ex)
        {
            Debug.printStackTrace(ex);
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_459423164 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_459423164.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_459423164;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

