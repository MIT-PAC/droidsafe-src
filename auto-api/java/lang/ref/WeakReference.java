package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class WeakReference<T> extends Reference<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.738 -0400", hash_original_method = "8EA2EBB87AD36DFCCFE2AFAE0E37BC47", hash_generated_method = "8489AF33B1A5FEEB073312C618A2938D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakReference(T r) {
        super(r, null);
        dsTaint.addTaint(r.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.738 -0400", hash_original_method = "5A9A40099BD4C3938AFF91F9B1097812", hash_generated_method = "B36A21DD61D69967182C68A37B864E6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(q.dsTaint);
        // ---------- Original Method ----------
    }

    
}

