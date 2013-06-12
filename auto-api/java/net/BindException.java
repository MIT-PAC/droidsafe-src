package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class BindException extends SocketException {
    private static final long serialVersionUID = -5945005768251722951L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.174 -0400", hash_original_method = "D66D1C4C5928E000A465F2B26896B637", hash_generated_method = "31EA672D1BE1EB6AF496D12903838026")
    @DSModeled(DSC.SAFE)
    public BindException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.174 -0400", hash_original_method = "6FF32DF773E2792C41FA7AD13FDCFDDC", hash_generated_method = "4E9A1B4F9E4D2AAA7D5F309C77256C0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BindException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.174 -0400", hash_original_method = "C8F93BE3A806C12732DAADB48D8791E4", hash_generated_method = "F29C4493848D01B5043EA4A5EDC58EFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BindException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


