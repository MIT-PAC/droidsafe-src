package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicBoolean implements java.io.Serializable {
    private volatile int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.072 -0400", hash_original_method = "2D4043190EFF6FBF71F6E61F91ACE979", hash_generated_method = "923924091060E479D436B5376107B0AA")
    @DSModeled(DSC.SAFE)
    public AtomicBoolean(boolean initialValue) {
        dsTaint.addTaint(initialValue);
        value = initialValue ? 1 : 0;
        // ---------- Original Method ----------
        //value = initialValue ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.072 -0400", hash_original_method = "4EFA45A0BE6632C845A9BA70932A5A0A", hash_generated_method = "6F354300E0EEDCD66A892901A02868C4")
    @DSModeled(DSC.SAFE)
    public AtomicBoolean() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.072 -0400", hash_original_method = "5ABD420FFDECFAFBA90B6FD43E53DADE", hash_generated_method = "096580611D0B860F1DB557DEB385B34B")
    @DSModeled(DSC.SAFE)
    public final boolean get() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return value != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.073 -0400", hash_original_method = "F4EDC6324B18AED31374999FCFCE4700", hash_generated_method = "A71EA1983C28A2D209823458D68FD5D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean compareAndSet(boolean expect, boolean update) {
        dsTaint.addTaint(update);
        dsTaint.addTaint(expect);
        int e;
        e = 1;
        e = 0;
        int u;
        u = 1;
        u = 0;
        boolean var35D2F955F124F37C2BDFC7B5DA6B44FD_46276340 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int e = expect ? 1 : 0;
        //int u = update ? 1 : 0;
        //return unsafe.compareAndSwapInt(this, valueOffset, e, u);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.073 -0400", hash_original_method = "788D44D9ED0FFD916FA1001367F68A82", hash_generated_method = "426F3811D56D548F929DA1A3EA9F7245")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean weakCompareAndSet(boolean expect, boolean update) {
        dsTaint.addTaint(update);
        dsTaint.addTaint(expect);
        int e;
        e = 1;
        e = 0;
        int u;
        u = 1;
        u = 0;
        boolean var35D2F955F124F37C2BDFC7B5DA6B44FD_171144367 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int e = expect ? 1 : 0;
        //int u = update ? 1 : 0;
        //return unsafe.compareAndSwapInt(this, valueOffset, e, u);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.073 -0400", hash_original_method = "FD0CF162327E2AB30C8884FB52F6FB5F", hash_generated_method = "E7C6B05A3B22EC8F926AB6928826023A")
    @DSModeled(DSC.SAFE)
    public final void set(boolean newValue) {
        dsTaint.addTaint(newValue);
        value = newValue ? 1 : 0;
        // ---------- Original Method ----------
        //value = newValue ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.073 -0400", hash_original_method = "CA687482363D6F32107DA02B75F4C570", hash_generated_method = "D3CB832AAE56FE6DEC82923BA12299BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.074 -0400", hash_original_method = "E903BF98EDD2BB9EFF497ED0D64C109B", hash_generated_method = "E6E025B87F33E92E06BC781E20590F62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean getAndSet(boolean newValue) {
        dsTaint.addTaint(newValue);
        {
            boolean current;
            current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_125757163 = (compareAndSet(current, newValue));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.074 -0400", hash_original_method = "A5A2E0E9AE6072C3F7FFFC3FCCD2C5BC", hash_generated_method = "A83F52170E6240CD49E17D009F6A746E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var76A8910923ACC1A33BC7F4EA145596B5_559537363 = (Boolean.toString(get()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Boolean.toString(get());
    }

    
    private static final long serialVersionUID = 4654671469794556979L;
    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    private static final long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicBoolean.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

