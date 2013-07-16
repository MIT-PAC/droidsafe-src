package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.message.SIPRequest;
import java.text.ParseException;
import javax.sip.*;
import gov.nist.core.*;

public class CSeqParser extends HeaderParser {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.887 -0400", hash_original_method = "315D7450D70C30EDB72AC7255664118E", hash_generated_method = "A8FDE793BDDBAFC103CC08AC2EE3CE0D")
    public  CSeqParser(String cseq) {
        super(cseq);
        addTaint(cseq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.888 -0400", hash_original_method = "8A2748B0467C573864DACC8328A787A7", hash_generated_method = "206A239BD298BB64B23E3F5F5597EE51")
    protected  CSeqParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.924 -0400", hash_original_method = "25983B4EEF6E8D8834C12C4F0FEB872C", hash_generated_method = "90F653F7D4097FF1FB501DDD2CC59239")
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
SIPHeader var807FB10045EE51C06BDB74744A6714DF_363789817 =             c;
            var807FB10045EE51C06BDB74744A6714DF_363789817.addTaint(taint);
            return var807FB10045EE51C06BDB74744A6714DF_363789817;
        } //End block
        catch (NumberFormatException ex)
        {
            Debug.printStackTrace(ex);
            java.text.ParseException var47EC6AB6ED56A46F510856200B27A259_697299512 = createParseException("Number format exception");
            var47EC6AB6ED56A46F510856200B27A259_697299512.addTaint(taint);
            throw var47EC6AB6ED56A46F510856200B27A259_697299512;
        } //End block
        catch (InvalidArgumentException ex)
        {
            Debug.printStackTrace(ex);
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_756534673 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_756534673.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_756534673;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

