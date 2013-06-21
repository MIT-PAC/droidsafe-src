package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.message.SIPRequest;
import java.text.ParseException;
import javax.sip.*;
import gov.nist.core.*;

public class CSeqParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.244 -0400", hash_original_method = "315D7450D70C30EDB72AC7255664118E", hash_generated_method = "04D9C9C683CCD8B75A8D9F0EF7708C03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CSeqParser(String cseq) {
        super(cseq);
        dsTaint.addTaint(cseq);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.244 -0400", hash_original_method = "8A2748B0467C573864DACC8328A787A7", hash_generated_method = "236E7C1CD3684CF91ED32655FEB7ED34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected CSeqParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.244 -0400", hash_original_method = "25983B4EEF6E8D8834C12C4F0FEB872C", hash_generated_method = "84929AB5EBB5BB40EAF3944611E44D90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        try 
        {
            CSeq c;
            c = new CSeq();
            this.lexer.match(TokenTypes.CSEQ);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            String number;
            number = this.lexer.number();
            c.setSeqNumber(Long.parseLong(number));
            this.lexer.SPorHT();
            String m;
            m = SIPRequest.getCannonicalName( method() );
            c.setMethod(m);
            this.lexer.SPorHT();
            this.lexer.match('\n');
        } //End block
        catch (NumberFormatException ex)
        {
            Debug.printStackTrace(ex);
            if (DroidSafeAndroidRuntime.control) throw createParseException("Number format exception");
        } //End block
        catch (InvalidArgumentException ex)
        {
            Debug.printStackTrace(ex);
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

