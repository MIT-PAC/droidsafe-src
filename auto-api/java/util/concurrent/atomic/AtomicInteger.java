package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import sun.misc.Unsafe;

public class AtomicInteger extends Number implements java.io.Serializable {
    private static final long serialVersionUID = 6214790243416807050L;
    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    private static final long valueOffset;
    private volatile int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "A3EEEE607FBEBD432F4111F47BB23345", hash_generated_method = "A9E3B7AEAB9C2F4AE078233F68A49314")
    @DSModeled(DSC.SAFE)
    public AtomicInteger(int initialValue) {
        dsTaint.addTaint(initialValue);
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "3B74ED36698F9901BA50127D104C26DE", hash_generated_method = "8EF5D87C6DB72544F37AC71380D024D9")
    @DSModeled(DSC.SAFE)
    public AtomicInteger() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "2C5A1089E8025181868581E48D922F38", hash_generated_method = "87D7392F17A8EA915E8BEB3BE23DA072")
    @DSModeled(DSC.SAFE)
    public final int get() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "E51FD8A91C159D9D3ED3BF52073569AD", hash_generated_method = "7C7060437EF8314D44988ECAA569FE3F")
    @DSModeled(DSC.SAFE)
    public final void set(int newValue) {
        dsTaint.addTaint(newValue);
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "77EB9E59BE67AA43485FF3A0F0492CB7", hash_generated_method = "82F0E669DF8316F2115B738DB6993468")
    @DSModeled(DSC.SAFE)
    public final void lazySet(int newValue) {
        dsTaint.addTaint(newValue);
        unsafe.putOrderedInt(this, valueOffset, newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedInt(this, valueOffset, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "EFF79965BA8CD7578F2A5616273687C7", hash_generated_method = "56C6F3BFAE1F8B533984B0E7D1268057")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getAndSet(int newValue) {
        dsTaint.addTaint(newValue);
        {
            int current;
            current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_714413040 = (compareAndSet(current, newValue));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //if (compareAndSet(current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "3CF6D7A3DD4EDBE8D1648E756B160F53", hash_generated_method = "1637D0F5BE8B20FBDC5301D83A762A1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean compareAndSet(int expect, int update) {
        dsTaint.addTaint(expect);
        dsTaint.addTaint(update);
        boolean varA219EEBEFD3FA4DCBF9D61615A3EEAA5_588540935 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "22EC2300FEC70C46ECF009D542FC9430", hash_generated_method = "A8097C00038B76A78186B0305D00BE9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean weakCompareAndSet(int expect, int update) {
        dsTaint.addTaint(expect);
        dsTaint.addTaint(update);
        boolean varA219EEBEFD3FA4DCBF9D61615A3EEAA5_233782065 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "621C33BC86CD3122044A53600F895B29", hash_generated_method = "2ACD01A10B6ED90AA833D3798D2D1406")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getAndIncrement() {
        {
            int current;
            current = get();
            int next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_2097855133 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "D5257E8A410056D1BB1DB7447390EAE5", hash_generated_method = "89099FE6AB351D534BEC4293EFD78F11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getAndDecrement() {
        {
            int current;
            current = get();
            int next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1322364355 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current - 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "4B803B85C89B0C062A735FA86D4518AE", hash_generated_method = "2CDB9B15C6E2742FB6EB2C1A3D50EF4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getAndAdd(int delta) {
        dsTaint.addTaint(delta);
        {
            int current;
            current = get();
            int next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_172527764 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + delta;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "6DC45C427ABFB1C3B7D74803EAAF22FF", hash_generated_method = "C3A76AB2223BC37EDF21E808B25AF481")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int incrementAndGet() {
        {
            int current;
            current = get();
            int next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1163025226 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "4357F9DD6725F5F393683EE2EA89C677", hash_generated_method = "5EE0AF1DC144951A2EB4219394FA74A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int decrementAndGet() {
        {
            int current;
            current = get();
            int next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_603001657 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current - 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "5280B98EAB69F2A556138E3D06C4D0D3", hash_generated_method = "4BB8AFBC14BEDCD363D33075851CB5EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int addAndGet(int delta) {
        dsTaint.addTaint(delta);
        {
            int current;
            current = get();
            int next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1667875762 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + delta;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "0CBFF056CB46F189F8DC45AFB469D5F9", hash_generated_method = "3832942C811BB0D290F57E08D04A7AFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var854D207D527D9870148CDFCF5D029E83_1066606289 = (Integer.toString(get()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toString(get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "B90EC926C8275C97256DF1E0AD9FC076", hash_generated_method = "4C94C78A0DC264AA800ED892EE6AEDF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int intValue() {
        int varA3899375788C01929C876C11142E44FF_1529270832 = (get());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.829 -0400", hash_original_method = "41D936CCD9A9D16949AE3FD60738B8AD", hash_generated_method = "916CE9B9C0ADDDAA669F551816E6095B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long longValue() {
        long var3647B297BC29A3BA088BCA1543A8629B_610262062 = ((long)get());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return (long)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.830 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "07A442440A0317A27D4907A6528FACFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float floatValue() {
        float varACA887607DBB4E1678238A769AA68C60_1507412071 = ((float)get());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.830 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "C7E8A8438F8BBEF914DC0C327D74B04A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double doubleValue() {
        double var1116C2BD9A20FF0A436A87C6D78A46AB_1640693796 = ((double)get());
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return (double)get();
    }

    
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicInteger.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}


