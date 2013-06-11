package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class RuntimeException extends Exception {
    private static final long serialVersionUID = -7034897190745766939L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.411 -0400", hash_original_method = "C630CF95A30AC67866F4ABFDC2AE9E1F", hash_generated_method = "F561D77EA8D231B0F812ABD72319CD35")
    @DSModeled(DSC.SAFE)
    public RuntimeException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.412 -0400", hash_original_method = "80B9FEB41572B74366DE05587056CF70", hash_generated_method = "89E37B0C62FCF45B39B746904C240434")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuntimeException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.415 -0400", hash_original_method = "6494A6C5ABD2EBB06754B14C1D93C94D", hash_generated_method = "C9F773AE4008EC0773067E029DE4980B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuntimeException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        dsTaint.addTaint(throwable.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.418 -0400", hash_original_method = "2585C76CA369FC60FE687924F5D5A532", hash_generated_method = "895D80B3BBA151360B9B2DA1E9FC912B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuntimeException(Throwable throwable) {
        super(throwable);
        dsTaint.addTaint(throwable.dsTaint);
        // ---------- Original Method ----------
    }

    
}


