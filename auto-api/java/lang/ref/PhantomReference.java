package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PhantomReference<T> extends Reference<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.761 -0400", hash_original_method = "269EAD0EE18A562FFF5DDE7409E1AEEE", hash_generated_method = "A20FA90DB9B209F8A1341ABC20FBD0A3")
    public  PhantomReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        addTaint(r.getTaint());
        addTaint(q.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.761 -0400", hash_original_method = "11AC17D1A4195077BEA3CC915127101C", hash_generated_method = "D4FAD5A68F5E43F685728A104EA6D8CC")
    @Override
    public T get() {
        T varB4EAC82CA7396A68D541C85D26508E83_1793874634 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1793874634 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1793874634.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1793874634;
        // ---------- Original Method ----------
        //return null;
    }

    
}

