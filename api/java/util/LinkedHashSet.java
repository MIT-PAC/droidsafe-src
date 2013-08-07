package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;






public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.760 -0400", hash_original_method = "FA64C9B63CE04BA03B3070651E56EFED", hash_generated_method = "B99E3A755713053C1BCF05A2186909D1")
    public  LinkedHashSet() {
        super(new LinkedHashMap<E, HashSet<E>>());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.761 -0400", hash_original_method = "D1E784926661CD719EF7E1152646271C", hash_generated_method = "402E1F209664C62953205E8A57DD538F")
    public  LinkedHashSet(int capacity) {
        super(new LinkedHashMap<E, HashSet<E>>(capacity));
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.761 -0400", hash_original_method = "BE6AEEEAC74AB8DE439B6373179C0342", hash_generated_method = "C16BEE166C0FB5ACEED8506BB5C89691")
    public  LinkedHashSet(int capacity, float loadFactor) {
        super(new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor));
        addTaint(loadFactor);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.761 -0400", hash_original_method = "04F711D7424A0EA0A6EA304747ABA554", hash_generated_method = "8B59B2B9DCF36FC27AA99B0F9BADC9B8")
    public  LinkedHashSet(Collection<? extends E> collection) {
        super(new LinkedHashMap<E, HashSet<E>>(collection.size() < 6 ? 11
                : collection.size() * 2));
        addTaint(collection.getTaint());
for(E e : collection)
        {
            add(e);
        } //End block
        // ---------- Original Method ----------
        //for (E e : collection) {
            //add(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.762 -0400", hash_original_method = "C32DAC3A2A4103476079105397490F9A", hash_generated_method = "67FB52CFF4A7CA27DA5B3100F8C4A76A")
    @Override
     HashMap<E, HashSet<E>> createBackingMap(int capacity, float loadFactor) {
        addTaint(loadFactor);
        addTaint(capacity);
HashMap<E, HashSet<E>> var0A396D3ACF850ADC853A7EF817D30CE6_120121475 =         new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor);
        var0A396D3ACF850ADC853A7EF817D30CE6_120121475.addTaint(taint);
        return var0A396D3ACF850ADC853A7EF817D30CE6_120121475;
        // ---------- Original Method ----------
        //return new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.762 -0400", hash_original_field = "AB5DC023C1FE59C566EEDFE5B0F41541", hash_generated_field = "9AC03C289FA70340AC8107CAE1966D0A")

    private static final long serialVersionUID = -2851667679971038690L;
}

