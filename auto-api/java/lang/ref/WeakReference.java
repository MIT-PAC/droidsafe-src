package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class WeakReference<T> extends Reference<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.833 -0400", hash_original_method = "8EA2EBB87AD36DFCCFE2AFAE0E37BC47", hash_generated_method = "06AD5DEE1861F737B23B2DA4225015F6")
    public  WeakReference(T r) {
        super(r, null);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.833 -0400", hash_original_method = "5A9A40099BD4C3938AFF91F9B1097812", hash_generated_method = "48A6052FC056239B953E75F721340FFC")
    public  WeakReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        addTaint(r.getTaint());
        addTaint(q.getTaint());
        // ---------- Original Method ----------
    }

    
}

