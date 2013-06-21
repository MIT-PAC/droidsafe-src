package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicLong extends Number implements java.io.Serializable {
    private volatile long value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.087 -0400", hash_original_method = "6ECA774993D880ABD38A420DC693E35F", hash_generated_method = "FCBEC156987421067743616384B4F21C")
    @DSModeled(DSC.SAFE)
    public AtomicLong(long initialValue) {
        dsTaint.addTaint(initialValue);
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.088 -0400", hash_original_method = "E5BCC7DD3ADE986582FDD04FB62FAAFA", hash_generated_method = "F7B97E703BF9873CEAC0A4C7BFF9C409")
    @DSModeled(DSC.SAFE)
    public AtomicLong() {
        // ---------- Original Method ----------
    }

    
        private static boolean VMSupportsCS8() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.088 -0400", hash_original_method = "558225EAA1BF82052D6B969C16747B7A", hash_generated_method = "278EFDC03EE59091906041D2ACBD2323")
    @DSModeled(DSC.SAFE)
    public final long get() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.088 -0400", hash_original_method = "CA4706358CD81A962EB6E91A1521FBCA", hash_generated_method = "0EC15100CD85E1760ED3892606B77238")
    @DSModeled(DSC.SAFE)
    public final void set(long newValue) {
        dsTaint.addTaint(newValue);
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.088 -0400", hash_original_method = "5F840B47C39798AC1AA2E3C6DCFC9B43", hash_generated_method = "9C1BB81F25D3D3678486423839AAB7BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void lazySet(long newValue) {
        dsTaint.addTaint(newValue);
        unsafe.putOrderedLong(this, valueOffset, newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedLong(this, valueOffset, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.089 -0400", hash_original_method = "390AAB13B16AF188378473BA59BB98BA", hash_generated_method = "C18BCE20C6FDB99866EEBD38FBB02A6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getAndSet(long newValue) {
        dsTaint.addTaint(newValue);
        {
            long current;
            current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_1003122118 = (compareAndSet(current, newValue));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //if (compareAndSet(current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.089 -0400", hash_original_method = "9AFEEC1B0401F372D8D224EE7A6E78FB", hash_generated_method = "32D1212F3E35D1C45F3349B7B2EC7CA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean compareAndSet(long expect, long update) {
        dsTaint.addTaint(update);
        dsTaint.addTaint(expect);
        boolean varF496D4F81A10D81B002043A1EF78AFD4_1557823806 = (unsafe.compareAndSwapLong(this, valueOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.089 -0400", hash_original_method = "CF5E29839097193C76F9677539F6A8BA", hash_generated_method = "86F425FE4BF59069DA2486E0E265FFAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean weakCompareAndSet(long expect, long update) {
        dsTaint.addTaint(update);
        dsTaint.addTaint(expect);
        boolean varF496D4F81A10D81B002043A1EF78AFD4_1208919921 = (unsafe.compareAndSwapLong(this, valueOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.090 -0400", hash_original_method = "0FB09453B9C7F7E3674DED4A168E8FE2", hash_generated_method = "85C59B72E6674A2638B9882BA3269BA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getAndIncrement() {
        {
            long current;
            current = get();
            long next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_333449526 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //long next = current + 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.090 -0400", hash_original_method = "B338EF04AC352C769CAB7069B279216B", hash_generated_method = "B2C28180D42CF5B2CED3942176CDAB36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getAndDecrement() {
        {
            long current;
            current = get();
            long next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1352432004 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //long next = current - 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.090 -0400", hash_original_method = "F13F3FE7BE5ED16E2943CEEE9739382A", hash_generated_method = "C7A81633A6777B480DA5851CF122AFF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getAndAdd(long delta) {
        dsTaint.addTaint(delta);
        {
            long current;
            current = get();
            long next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_694589649 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //long next = current + delta;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.091 -0400", hash_original_method = "0B4DA3D002D9BEE66893798DFD4DBDF7", hash_generated_method = "532433CFAA045A016B705F5920F883EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long incrementAndGet() {
        {
            long current;
            current = get();
            long next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_923853901 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get();
            //long next = current + 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.091 -0400", hash_original_method = "BC527AFE730427BE036B66CE7C20403C", hash_generated_method = "FF7DC9BD7BDA9811F206B533B73FCF79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long decrementAndGet() {
        {
            long current;
            current = get();
            long next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1635264260 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get();
            //long next = current - 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.091 -0400", hash_original_method = "9F7FB16A58B977A4E2DB5A0F397D878E", hash_generated_method = "6F09AFD9D23A7E2B9DDCFDFD7A6D9767")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long addAndGet(long delta) {
        dsTaint.addTaint(delta);
        {
            long current;
            current = get();
            long next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_388133697 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get();
            //long next = current + delta;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.092 -0400", hash_original_method = "87FB115D4E2C883D105781A1EF69130B", hash_generated_method = "1B8943F47002A4CC017B26FE7B0F57D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var1D041168BDE6E7F48389FFDB3BC27B46_35690903 = (Long.toString(get()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Long.toString(get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.092 -0400", hash_original_method = "84EB409D8DAC6A9532DB1B14F662CA95", hash_generated_method = "E66C544281249C859BC6DB6A69B7121C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int intValue() {
        int var44B0419F833AC6EE0D1EEA4F82C029A7_1048232392 = ((int)get());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.092 -0400", hash_original_method = "8D0E58021498DD6F55D0437545A61BE8", hash_generated_method = "EB81C70523CA6B746DE3E225FFABF5E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long longValue() {
        long varA3899375788C01929C876C11142E44FF_1548011205 = (get());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.092 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "4C27C0A9006DE9FA478D3C5EFBF146AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float floatValue() {
        float varACA887607DBB4E1678238A769AA68C60_2129253144 = ((float)get());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.093 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "04C2FC3DE652DE2F49F315337DA3C446")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double doubleValue() {
        double var1116C2BD9A20FF0A436A87C6D78A46AB_1145626893 = ((double)get());
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return (double)get();
    }

    
    private static final long serialVersionUID = 1927816293512124184L;
    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    private static final long valueOffset;
    static final boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicLong.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

