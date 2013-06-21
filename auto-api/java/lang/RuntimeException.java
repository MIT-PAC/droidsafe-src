package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class RuntimeException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.030 -0400", hash_original_method = "C630CF95A30AC67866F4ABFDC2AE9E1F", hash_generated_method = "2414371380C96DB54D1831DED250C02B")
    @DSModeled(DSC.SAFE)
    public RuntimeException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.030 -0400", hash_original_method = "80B9FEB41572B74366DE05587056CF70", hash_generated_method = "52DDE8D7CC540EE3BC63A2BC2E1B3F23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuntimeException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.030 -0400", hash_original_method = "6494A6C5ABD2EBB06754B14C1D93C94D", hash_generated_method = "8E448796328DD1FCD9D843F71530CCD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuntimeException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        dsTaint.addTaint(throwable.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.030 -0400", hash_original_method = "2585C76CA369FC60FE687924F5D5A532", hash_generated_method = "054A79FAF21FB1B2E068A88498D4901E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuntimeException(Throwable throwable) {
        super(throwable);
        dsTaint.addTaint(throwable.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -7034897190745766939L;
}

