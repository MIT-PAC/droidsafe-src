package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import sun.misc.Unsafe;

public class AtomicReference<V> implements java.io.Serializable {
    private static final long serialVersionUID = -1848883965231344442L;
    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    private static final long valueOffset;
    private volatile V value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.831 -0400", hash_original_method = "BDBA762FEAF5C103321D9E7FB6720E1A", hash_generated_method = "B2EDFADEFD2B1A5BB3E1D654BC22E6A2")
    @DSModeled(DSC.SAFE)
    public AtomicReference(V initialValue) {
        dsTaint.addTaint(initialValue.dsTaint);
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.831 -0400", hash_original_method = "F97CF4B9707D277EAF947474019CC6FE", hash_generated_method = "90CF6A4BE0E319ABC274EEA715990733")
    @DSModeled(DSC.SAFE)
    public AtomicReference() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.831 -0400", hash_original_method = "479D74F52EAA9F8F31AB11658696490B", hash_generated_method = "B42DDB1A7D66537478A916284D357E08")
    @DSModeled(DSC.SAFE)
    public final V get() {
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.831 -0400", hash_original_method = "1165CC32E796F42C2841421B342AA16F", hash_generated_method = "9C8A59540CB0961A27B31B1DD25329E5")
    @DSModeled(DSC.SAFE)
    public final void set(V newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.831 -0400", hash_original_method = "5F145FC62F46FF5FAD786BED834DE8D5", hash_generated_method = "7BBEABE816DAC70F370E7B5284D8D4F8")
    @DSModeled(DSC.SAFE)
    public final void lazySet(V newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        unsafe.putOrderedObject(this, valueOffset, newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedObject(this, valueOffset, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.831 -0400", hash_original_method = "069E7BB7A98500BAF130264F81E7ADC7", hash_generated_method = "08CF39073FDB3526BA5CE29A2AA659CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean compareAndSet(V expect, V update) {
        dsTaint.addTaint(expect.dsTaint);
        dsTaint.addTaint(update.dsTaint);
        boolean varD929F361250D4CC6717086701C855D6C_1192163065 = (unsafe.compareAndSwapObject(this, valueOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.831 -0400", hash_original_method = "801403A92781688D40B445FC7E652974", hash_generated_method = "1F38F29FDC1D6C8D90C54E0759150F28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean weakCompareAndSet(V expect, V update) {
        dsTaint.addTaint(expect.dsTaint);
        dsTaint.addTaint(update.dsTaint);
        boolean varD929F361250D4CC6717086701C855D6C_412191319 = (unsafe.compareAndSwapObject(this, valueOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.831 -0400", hash_original_method = "FD7BCDEFF552AB71FCB964A4983AD19B", hash_generated_method = "8161E43F50904B3532F891D11305F2F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final V getAndSet(V newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        {
            V x;
            x = get();
            {
                boolean varE8F6CAB6887A1A34DFF41A32382DB312_1082224447 = (compareAndSet(x, newValue));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.832 -0400", hash_original_method = "2EE45E1B1B1F9797465CA7143D35DB76", hash_generated_method = "E945B67FA8AA09A5856FF01BFC560A7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varBE6258D4FFF818B536288AC4991D6EF3_1879855790 = (String.valueOf(get()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return String.valueOf(get());
    }

    
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicReference.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}


