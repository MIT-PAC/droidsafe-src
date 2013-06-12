package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import sun.misc.Unsafe;

public class AtomicBoolean implements java.io.Serializable {
    private static final long serialVersionUID = 4654671469794556979L;
    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    private static final long valueOffset;
    private volatile int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.826 -0400", hash_original_method = "2D4043190EFF6FBF71F6E61F91ACE979", hash_generated_method = "65082F581A20A40C90B990050EE1A954")
    @DSModeled(DSC.SAFE)
    public AtomicBoolean(boolean initialValue) {
        dsTaint.addTaint(initialValue);
        value = initialValue ? 1 : 0;
        // ---------- Original Method ----------
        //value = initialValue ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.826 -0400", hash_original_method = "4EFA45A0BE6632C845A9BA70932A5A0A", hash_generated_method = "8CEA6BD588B57EF61B72E37EF3CC1EA0")
    @DSModeled(DSC.SAFE)
    public AtomicBoolean() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.826 -0400", hash_original_method = "5ABD420FFDECFAFBA90B6FD43E53DADE", hash_generated_method = "773A2ADC8CE896E6A7F1EB7F6AB6379F")
    @DSModeled(DSC.SAFE)
    public final boolean get() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return value != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.826 -0400", hash_original_method = "F4EDC6324B18AED31374999FCFCE4700", hash_generated_method = "FBD308E5869C10C78AF013506A8439B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean compareAndSet(boolean expect, boolean update) {
        dsTaint.addTaint(expect);
        dsTaint.addTaint(update);
        int e;
        e = 1;
        e = 0;
        int u;
        u = 1;
        u = 0;
        boolean var35D2F955F124F37C2BDFC7B5DA6B44FD_1008158640 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int e = expect ? 1 : 0;
        //int u = update ? 1 : 0;
        //return unsafe.compareAndSwapInt(this, valueOffset, e, u);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.826 -0400", hash_original_method = "788D44D9ED0FFD916FA1001367F68A82", hash_generated_method = "950CB30657BE0AD284089D9DBC661927")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean weakCompareAndSet(boolean expect, boolean update) {
        dsTaint.addTaint(expect);
        dsTaint.addTaint(update);
        int e;
        e = 1;
        e = 0;
        int u;
        u = 1;
        u = 0;
        boolean var35D2F955F124F37C2BDFC7B5DA6B44FD_1715838549 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int e = expect ? 1 : 0;
        //int u = update ? 1 : 0;
        //return unsafe.compareAndSwapInt(this, valueOffset, e, u);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.826 -0400", hash_original_method = "FD0CF162327E2AB30C8884FB52F6FB5F", hash_generated_method = "28FBE81C25F5DBBBB119213E78DDC13B")
    @DSModeled(DSC.SAFE)
    public final void set(boolean newValue) {
        dsTaint.addTaint(newValue);
        value = newValue ? 1 : 0;
        // ---------- Original Method ----------
        //value = newValue ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.826 -0400", hash_original_method = "CA687482363D6F32107DA02B75F4C570", hash_generated_method = "AB52A79E45B98B1E23FFF9EFB8ADEC22")
    @DSModeled(DSC.SAFE)
    public final void lazySet(boolean newValue) {
        dsTaint.addTaint(newValue);
        int v;
        v = 1;
        v = 0;
        unsafe.putOrderedInt(this, valueOffset, v);
        // ---------- Original Method ----------
        //int v = newValue ? 1 : 0;
        //unsafe.putOrderedInt(this, valueOffset, v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.826 -0400", hash_original_method = "E903BF98EDD2BB9EFF497ED0D64C109B", hash_generated_method = "C881927491A5CEE22ACF0828CD14F69D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean getAndSet(boolean newValue) {
        dsTaint.addTaint(newValue);
        {
            boolean current;
            current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_948320165 = (compareAndSet(current, newValue));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (;;) {
            //boolean current = get();
            //if (compareAndSet(current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.826 -0400", hash_original_method = "A5A2E0E9AE6072C3F7FFFC3FCCD2C5BC", hash_generated_method = "681BFB7D0B803582463CAC00F1C77551")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var76A8910923ACC1A33BC7F4EA145596B5_970867954 = (Boolean.toString(get()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Boolean.toString(get());
    }

    
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicBoolean.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}


