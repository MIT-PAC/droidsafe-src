package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicReference<V> implements java.io.Serializable {
    private volatile V value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.097 -0400", hash_original_method = "BDBA762FEAF5C103321D9E7FB6720E1A", hash_generated_method = "05D5B767420EF7A1A15FAE9436B3B31D")
    @DSModeled(DSC.SAFE)
    public AtomicReference(V initialValue) {
        dsTaint.addTaint(initialValue.dsTaint);
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.097 -0400", hash_original_method = "F97CF4B9707D277EAF947474019CC6FE", hash_generated_method = "92D86C2B7F31D409EA2507200825BA47")
    @DSModeled(DSC.SAFE)
    public AtomicReference() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.097 -0400", hash_original_method = "479D74F52EAA9F8F31AB11658696490B", hash_generated_method = "80F7DF55C0E81F7D005D4662B4BA6CB3")
    @DSModeled(DSC.SAFE)
    public final V get() {
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.097 -0400", hash_original_method = "1165CC32E796F42C2841421B342AA16F", hash_generated_method = "B6A4CDC89E767FA13BC76547649346A3")
    @DSModeled(DSC.SAFE)
    public final void set(V newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.097 -0400", hash_original_method = "5F145FC62F46FF5FAD786BED834DE8D5", hash_generated_method = "DA32EF2FB45555525140C270D0900488")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void lazySet(V newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        unsafe.putOrderedObject(this, valueOffset, newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedObject(this, valueOffset, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.098 -0400", hash_original_method = "069E7BB7A98500BAF130264F81E7ADC7", hash_generated_method = "D37DDD86A5CD69983C17F1328B43630C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean compareAndSet(V expect, V update) {
        dsTaint.addTaint(update.dsTaint);
        dsTaint.addTaint(expect.dsTaint);
        boolean varD929F361250D4CC6717086701C855D6C_1941325368 = (unsafe.compareAndSwapObject(this, valueOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.098 -0400", hash_original_method = "801403A92781688D40B445FC7E652974", hash_generated_method = "DB94D25ED049FBB05FE26A98257077EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean weakCompareAndSet(V expect, V update) {
        dsTaint.addTaint(update.dsTaint);
        dsTaint.addTaint(expect.dsTaint);
        boolean varD929F361250D4CC6717086701C855D6C_444934936 = (unsafe.compareAndSwapObject(this, valueOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.098 -0400", hash_original_method = "FD7BCDEFF552AB71FCB964A4983AD19B", hash_generated_method = "E0C2BE218E1C474676C7A72B1D7892C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final V getAndSet(V newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        {
            V x;
            x = get();
            {
                boolean varE8F6CAB6887A1A34DFF41A32382DB312_2123774994 = (compareAndSet(x, newValue));
            } //End collapsed parenthetic
        } //End block
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //while (true) {
            //V x = get();
            //if (compareAndSet(x, newValue))
                //return x;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.098 -0400", hash_original_method = "2EE45E1B1B1F9797465CA7143D35DB76", hash_generated_method = "853DDC2B84720A0F2FBC5B432F86331D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varBE6258D4FFF818B536288AC4991D6EF3_564134437 = (String.valueOf(get()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return String.valueOf(get());
    }

    
    private static final long serialVersionUID = -1848883965231344442L;
    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    private static final long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicReference.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

