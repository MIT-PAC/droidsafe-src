package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class WeakReference<T> extends Reference<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.882 -0400", hash_original_method = "8EA2EBB87AD36DFCCFE2AFAE0E37BC47", hash_generated_method = "A191EB7B7DB8CA82A209ABD0A804EEDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakReference(T r) {
        super(r, null);
        dsTaint.addTaint(r.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.882 -0400", hash_original_method = "5A9A40099BD4C3938AFF91F9B1097812", hash_generated_method = "010BDB20DCD8202D7E0CE7D934D85604")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(q.dsTaint);
        // ---------- Original Method ----------
    }

    
}


