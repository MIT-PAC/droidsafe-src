package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Exception extends Throwable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.696 -0400", hash_original_method = "D33746B9B653741A49B1BE35D2346C75", hash_generated_method = "D55E5C538C9FDD634751B5C812941F3B")
    @DSModeled(DSC.SAFE)
    public Exception() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.697 -0400", hash_original_method = "830A2EF4A7E30C0BE0D23F3C6E3EB88B", hash_generated_method = "CACB5938C7F68DE3BFC290CCBAD123E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Exception(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.697 -0400", hash_original_method = "1CCC5FB7B2239F395100A328B05F71D2", hash_generated_method = "F1430ACEA279079531D510D5380E4F13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Exception(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        dsTaint.addTaint(throwable.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.697 -0400", hash_original_method = "521C63C689E06CBA8E8D56AF626D043A", hash_generated_method = "6B71F5855A424C9E8807D91D38F47686")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Exception(Throwable throwable) {
        super(throwable);
        dsTaint.addTaint(throwable.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -3387516993124229948L;
}

