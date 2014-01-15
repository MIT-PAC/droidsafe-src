package java.lang.ref;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SoftReference<T> extends Reference<T> {

    /**
     * Constructs a new soft reference to the given referent. The newly created
     * reference is not registered with any reference queue.
     *
     * @param r the referent to track
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.957 -0500", hash_original_method = "580748AA620617AA151344F4D11AC7C2", hash_generated_method = "150253DAD26A10AB954083587CB2FFDD")
    
public SoftReference(T r) {
        super(r, null);
    }

    /**
     * Constructs a new soft reference to the given referent. The newly created
     * reference is registered with the given reference queue.
     *
     * @param r the referent to track
     * @param q the queue to register to the reference object with. A null value
     *          results in a weak reference that is not associated with any
     *          queue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.961 -0500", hash_original_method = "123F9816B0FED05FA5B253267B81F032", hash_generated_method = "A8DF8D86A10B68C4CE29EE706C113C2D")
    
public SoftReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
    }
    
}

