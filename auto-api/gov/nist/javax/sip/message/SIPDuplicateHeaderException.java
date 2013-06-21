package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class SIPDuplicateHeaderException extends ParseException {
    protected SIPHeader sipHeader;
    protected SIPMessage sipMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.879 -0400", hash_original_method = "C7110F542E7C86523593AC1F47E9C6EF", hash_generated_method = "4C253A5AAC7358DBE753D8A1CB5E3272")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPDuplicateHeaderException(String msg) {
        super(msg, 0);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.879 -0400", hash_original_method = "33B1FEC769A0D2DAFD3ECF3DA486EB50", hash_generated_method = "09ED786641BD715033558B7D042B1B14")
    @DSModeled(DSC.SAFE)
    public SIPMessage getSIPMessage() {
        return (SIPMessage)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sipMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.880 -0400", hash_original_method = "41260058ED6F5F8ADF876F4D655653A8", hash_generated_method = "22ADE2BACCA650A37A1E7A53C4E157C6")
    @DSModeled(DSC.SAFE)
    public SIPHeader getSIPHeader() {
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.880 -0400", hash_original_method = "E64CE5D80349BACB9139631838659CEE", hash_generated_method = "B4A4B54F1D56C6B6260E090A10E89B03")
    @DSModeled(DSC.SAFE)
    public void setSIPHeader(SIPHeader sipHeader) {
        dsTaint.addTaint(sipHeader.dsTaint);
        // ---------- Original Method ----------
        //this.sipHeader = sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.880 -0400", hash_original_method = "04933E08E06609AAF868A53B1081ADDB", hash_generated_method = "6FF52B6DCB7293714F4016D0AE2191B2")
    @DSModeled(DSC.SAFE)
    public void setSIPMessage(SIPMessage sipMessage) {
        dsTaint.addTaint(sipMessage.dsTaint);
        // ---------- Original Method ----------
        //this.sipMessage = sipMessage;
    }

    
    private static final long serialVersionUID = 8241107266407879291L;
}

