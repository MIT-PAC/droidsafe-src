package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SoftReference<T> extends Reference<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.736 -0400", hash_original_method = "580748AA620617AA151344F4D11AC7C2", hash_generated_method = "F077A3F309E63C32607B0E5052EC7F21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SoftReference(T r) {
        super(r, null);
        dsTaint.addTaint(r.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.737 -0400", hash_original_method = "123F9816B0FED05FA5B253267B81F032", hash_generated_method = "173AB6EBD3EEC44C909656E40146A802")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SoftReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(q.dsTaint);
        // ---------- Original Method ----------
    }

    
}

