package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SoftReference<T> extends Reference<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.910 -0400", hash_original_method = "580748AA620617AA151344F4D11AC7C2", hash_generated_method = "44400A0B733754D3D14DB23E92A5622F")
    public  SoftReference(T r) {
        super(r, null);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.911 -0400", hash_original_method = "123F9816B0FED05FA5B253267B81F032", hash_generated_method = "64B0DE7ED1F2DB739A8052AAFD95E6EC")
    public  SoftReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        addTaint(r.getTaint());
        addTaint(q.getTaint());
        // ---------- Original Method ----------
    }

    
}

