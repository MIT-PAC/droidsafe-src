package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.556 -0400", hash_original_method = "FA64C9B63CE04BA03B3070651E56EFED", hash_generated_method = "B99E3A755713053C1BCF05A2186909D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashSet() {
        super(new LinkedHashMap<E, HashSet<E>>());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.556 -0400", hash_original_method = "D1E784926661CD719EF7E1152646271C", hash_generated_method = "D414A507EF5E83A6AD0099CAC0A393B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashSet(int capacity) {
        super(new LinkedHashMap<E, HashSet<E>>(capacity));
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.557 -0400", hash_original_method = "BE6AEEEAC74AB8DE439B6373179C0342", hash_generated_method = "C3A186DA982D56685D7A11F6E5520EF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashSet(int capacity, float loadFactor) {
        super(new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor));
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.557 -0400", hash_original_method = "04F711D7424A0EA0A6EA304747ABA554", hash_generated_method = "4DF5294C1BF68D21E1A51B44CABB6686")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashSet(Collection<? extends E> collection) {
        super(new LinkedHashMap<E, HashSet<E>>(collection.size() < 6 ? 11
                : collection.size() * 2));
        dsTaint.addTaint(collection.dsTaint);
        {
            Iterator<E> var6348CF19B474F5ACF72F267EFA7F4363_524209810 = (collection).iterator();
            var6348CF19B474F5ACF72F267EFA7F4363_524209810.hasNext();
            E e = var6348CF19B474F5ACF72F267EFA7F4363_524209810.next();
            {
                add(e);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (E e : collection) {
            //add(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.558 -0400", hash_original_method = "C32DAC3A2A4103476079105397490F9A", hash_generated_method = "1B5F69A46AB8B2D7EC71C5B7BEE89A5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     HashMap<E, HashSet<E>> createBackingMap(int capacity, float loadFactor) {
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        HashMap<E, HashSet<E>> varE590245786B3E53DB6D01FF4E08284CE_1129583453 = (new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor));
        return (HashMap<E, HashSet<E>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LinkedHashMap<E, HashSet<E>>(capacity, loadFactor);
    }

    
    private static final long serialVersionUID = -2851667679971038690L;
}

