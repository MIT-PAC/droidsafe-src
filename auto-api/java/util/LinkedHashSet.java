package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.170 -0400", hash_original_method = "FA64C9B63CE04BA03B3070651E56EFED", hash_generated_method = "B99E3A755713053C1BCF05A2186909D1")
    public  LinkedHashSet() {
        super(new LinkedHashMap<E, HashSet<E>>());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.170 -0400", hash_original_method = "D1E784926661CD719EF7E1152646271C", hash_generated_method = "402E1F209664C62953205E8A57DD538F")
    public  LinkedHashSet(int capacity) {
        super(new LinkedHashMap<E, HashSet<E>>(capacity));
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.170 -0400", hash_original_method = "BE6AEEEAC74AB8DE439B6373179C0342", hash_generated_method = "78FDF048425A7640B21F2826C32972F7")
    public  LinkedHashSet(int capacity, float loadFactor) {
        super(new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor));
        addTaint(capacity);
        addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.180 -0400", hash_original_method = "04F711D7424A0EA0A6EA304747ABA554", hash_generated_method = "A10F8970A351D423C9F9A23947EDACF3")
    public  LinkedHashSet(Collection<? extends E> collection) {
        super(new LinkedHashMap<E, HashSet<E>>(collection.size() < 6 ? 11
                : collection.size() * 2));
        {
            Iterator<E> var6348CF19B474F5ACF72F267EFA7F4363_746640936 = (collection).iterator();
            var6348CF19B474F5ACF72F267EFA7F4363_746640936.hasNext();
            E e = var6348CF19B474F5ACF72F267EFA7F4363_746640936.next();
            {
                add(e);
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
        //for (E e : collection) {
            //add(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.180 -0400", hash_original_method = "C32DAC3A2A4103476079105397490F9A", hash_generated_method = "75DBCEB80892A5C84A79172F665DAA8B")
    @Override
     HashMap<E, HashSet<E>> createBackingMap(int capacity, float loadFactor) {
        HashMap<E, HashSet<E>> varB4EAC82CA7396A68D541C85D26508E83_1824897742 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1824897742 = new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor);
        addTaint(capacity);
        addTaint(loadFactor);
        varB4EAC82CA7396A68D541C85D26508E83_1824897742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1824897742;
        // ---------- Original Method ----------
        //return new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.180 -0400", hash_original_field = "AB5DC023C1FE59C566EEDFE5B0F41541", hash_generated_field = "B4D680E633B86EC3873A12FAE9DC5F46")

    private static long serialVersionUID = -2851667679971038690L;
}

