package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.751 -0400", hash_original_method = "FA64C9B63CE04BA03B3070651E56EFED", hash_generated_method = "B99E3A755713053C1BCF05A2186909D1")
    public  LinkedHashSet() {
        super(new LinkedHashMap<E, HashSet<E>>());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.752 -0400", hash_original_method = "D1E784926661CD719EF7E1152646271C", hash_generated_method = "402E1F209664C62953205E8A57DD538F")
    public  LinkedHashSet(int capacity) {
        super(new LinkedHashMap<E, HashSet<E>>(capacity));
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.752 -0400", hash_original_method = "BE6AEEEAC74AB8DE439B6373179C0342", hash_generated_method = "78FDF048425A7640B21F2826C32972F7")
    public  LinkedHashSet(int capacity, float loadFactor) {
        super(new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor));
        addTaint(capacity);
        addTaint(loadFactor);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.754 -0400", hash_original_method = "04F711D7424A0EA0A6EA304747ABA554", hash_generated_method = "53E486EE044D9530A0DFB7AF2AC523A7")
    public  LinkedHashSet(Collection<? extends E> collection) {
        super(new LinkedHashMap<E, HashSet<E>>(collection.size() < 6 ? 11
                : collection.size() * 2));
        {
            Iterator<? extends E> var6348CF19B474F5ACF72F267EFA7F4363_1174631741 = (collection).iterator();
            var6348CF19B474F5ACF72F267EFA7F4363_1174631741.hasNext();
            E e = var6348CF19B474F5ACF72F267EFA7F4363_1174631741.next();
            {
                add(e);
            } 
        } 
        addTaint(collection.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.754 -0400", hash_original_method = "C32DAC3A2A4103476079105397490F9A", hash_generated_method = "0C74D7137C0DEB8CB42A3931B8B98075")
    @Override
     HashMap<E, HashSet<E>> createBackingMap(int capacity, float loadFactor) {
        HashMap<E, HashSet<E>> varB4EAC82CA7396A68D541C85D26508E83_606465993 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_606465993 = new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor);
        addTaint(capacity);
        addTaint(loadFactor);
        varB4EAC82CA7396A68D541C85D26508E83_606465993.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_606465993;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.754 -0400", hash_original_field = "AB5DC023C1FE59C566EEDFE5B0F41541", hash_generated_field = "9AC03C289FA70340AC8107CAE1966D0A")

    private static final long serialVersionUID = -2851667679971038690L;
}

