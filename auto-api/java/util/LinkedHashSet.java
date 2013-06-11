package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.Serializable;

public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable {
    private static final long serialVersionUID = -2851667679971038690L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.537 -0400", hash_original_method = "FA64C9B63CE04BA03B3070651E56EFED", hash_generated_method = "00A2F803C8B94AE4C349137C4710FBEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashSet() {
        super(new LinkedHashMap<E, HashSet<E>>());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.537 -0400", hash_original_method = "D1E784926661CD719EF7E1152646271C", hash_generated_method = "DFF3050727DB52218F329EBCBA4B6F2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashSet(int capacity) {
        super(new LinkedHashMap<E, HashSet<E>>(capacity));
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.537 -0400", hash_original_method = "BE6AEEEAC74AB8DE439B6373179C0342", hash_generated_method = "D242591C4A478257E6DD5827DA63D17C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashSet(int capacity, float loadFactor) {
        super(new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor));
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.537 -0400", hash_original_method = "04F711D7424A0EA0A6EA304747ABA554", hash_generated_method = "2FFB3831CAFD5ADB991989052165BBB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashSet(Collection<? extends E> collection) {
        super(new LinkedHashMap<E, HashSet<E>>(collection.size() < 6 ? 11
                : collection.size() * 2));
        dsTaint.addTaint(collection.dsTaint);
        {
            Iterator<E> seatecAstronomy42 = collection.iterator();
            seatecAstronomy42.hasNext();
            E e = seatecAstronomy42.next();
            {
                add(e);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (E e : collection) {
            //add(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.537 -0400", hash_original_method = "C32DAC3A2A4103476079105397490F9A", hash_generated_method = "968ABCB70ADBDAFBA64F6EF49D36C188")
    @DSModeled(DSC.SAFE)
    @Override
     HashMap<E, HashSet<E>> createBackingMap(int capacity, float loadFactor) {
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        return (HashMap<E, HashSet<E>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor);
    }

    
}


