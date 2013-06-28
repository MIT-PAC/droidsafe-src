package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PhantomReference<T> extends Reference<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.593 -0400", hash_original_method = "269EAD0EE18A562FFF5DDE7409E1AEEE", hash_generated_method = "A20FA90DB9B209F8A1341ABC20FBD0A3")
    public  PhantomReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        addTaint(r.getTaint());
        addTaint(q.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.593 -0400", hash_original_method = "11AC17D1A4195077BEA3CC915127101C", hash_generated_method = "B972714200351F6A47BDE5DD9A543397")
    @Override
    public T get() {
        T varB4EAC82CA7396A68D541C85D26508E83_1937317893 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1937317893 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1937317893.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1937317893;
        // ---------- Original Method ----------
        //return null;
    }

    
}

