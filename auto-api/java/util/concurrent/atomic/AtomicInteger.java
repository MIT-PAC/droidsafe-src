package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicInteger extends Number implements java.io.Serializable {
    private volatile int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.077 -0400", hash_original_method = "A3EEEE607FBEBD432F4111F47BB23345", hash_generated_method = "A5A3231FCF5BD3CA05A6B6C0D6D95245")
    @DSModeled(DSC.SAFE)
    public AtomicInteger(int initialValue) {
        dsTaint.addTaint(initialValue);
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.077 -0400", hash_original_method = "3B74ED36698F9901BA50127D104C26DE", hash_generated_method = "3FC2676712951E4C0961989AC4A65B09")
    @DSModeled(DSC.SAFE)
    public AtomicInteger() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.077 -0400", hash_original_method = "2C5A1089E8025181868581E48D922F38", hash_generated_method = "A7AB7BAE5B4A552A54E6F645B04DCB6B")
    @DSModeled(DSC.SAFE)
    public final int get() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.078 -0400", hash_original_method = "E51FD8A91C159D9D3ED3BF52073569AD", hash_generated_method = "45E199D54B49964DCC84050312A4026A")
    @DSModeled(DSC.SAFE)
    public final void set(int newValue) {
        dsTaint.addTaint(newValue);
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.078 -0400", hash_original_method = "77EB9E59BE67AA43485FF3A0F0492CB7", hash_generated_method = "FD0CD6A54A76220CD84FADB77A951456")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void lazySet(int newValue) {
        dsTaint.addTaint(newValue);
        unsafe.putOrderedInt(this, valueOffset, newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedInt(this, valueOffset, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.078 -0400", hash_original_method = "EFF79965BA8CD7578F2A5616273687C7", hash_generated_method = "D1B3DD49FE88B226D0B2E7A1400AB858")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getAndSet(int newValue) {
        dsTaint.addTaint(newValue);
        {
            int current;
            current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_1730897895 = (compareAndSet(current, newValue));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.079 -0400", hash_original_method = "3CF6D7A3DD4EDBE8D1648E756B160F53", hash_generated_method = "49488652715922D4BFC74A7D40D3DB7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean compareAndSet(int expect, int update) {
        dsTaint.addTaint(update);
        dsTaint.addTaint(expect);
        boolean varA219EEBEFD3FA4DCBF9D61615A3EEAA5_874718444 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.079 -0400", hash_original_method = "22EC2300FEC70C46ECF009D542FC9430", hash_generated_method = "6BFB237BCE9129069E9B86A2CA32B5C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean weakCompareAndSet(int expect, int update) {
        dsTaint.addTaint(update);
        dsTaint.addTaint(expect);
        boolean varA219EEBEFD3FA4DCBF9D61615A3EEAA5_1261790522 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.079 -0400", hash_original_method = "621C33BC86CD3122044A53600F895B29", hash_generated_method = "63C4AF6F8E4405B9D2969FC5921259D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getAndIncrement() {
        {
            int current;
            current = get();
            int next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1984159952 = (compareAndSet(current, next));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.080 -0400", hash_original_method = "D5257E8A410056D1BB1DB7447390EAE5", hash_generated_method = "9E74F445EB93736CD83A4B56DC60C235")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getAndDecrement() {
        {
            int current;
            current = get();
            int next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1379197171 = (compareAndSet(current, next));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.080 -0400", hash_original_method = "4B803B85C89B0C062A735FA86D4518AE", hash_generated_method = "E0D8E996C596125D00B3BCFB78C08A63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getAndAdd(int delta) {
        dsTaint.addTaint(delta);
        {
            int current;
            current = get();
            int next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_2147317671 = (compareAndSet(current, next));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.080 -0400", hash_original_method = "6DC45C427ABFB1C3B7D74803EAAF22FF", hash_generated_method = "F6F10C59F7123142F524EB1D208C37E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int incrementAndGet() {
        {
            int current;
            current = get();
            int next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_80291051 = (compareAndSet(current, next));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.081 -0400", hash_original_method = "4357F9DD6725F5F393683EE2EA89C677", hash_generated_method = "F5D37FBB54D88575B05C5330071AC817")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int decrementAndGet() {
        {
            int current;
            current = get();
            int next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_2076151305 = (compareAndSet(current, next));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.081 -0400", hash_original_method = "5280B98EAB69F2A556138E3D06C4D0D3", hash_generated_method = "D9517106799B72712793428BB72E562B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int addAndGet(int delta) {
        dsTaint.addTaint(delta);
        {
            int current;
            current = get();
            int next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_397949411 = (compareAndSet(current, next));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.082 -0400", hash_original_method = "0CBFF056CB46F189F8DC45AFB469D5F9", hash_generated_method = "80375BE9005D290FBF06E1C50ED562AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var854D207D527D9870148CDFCF5D029E83_797051064 = (Integer.toString(get()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toString(get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.082 -0400", hash_original_method = "B90EC926C8275C97256DF1E0AD9FC076", hash_generated_method = "2152D6967435A839CF4A3984C72CF3F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int intValue() {
        int varA3899375788C01929C876C11142E44FF_133029481 = (get());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.082 -0400", hash_original_method = "41D936CCD9A9D16949AE3FD60738B8AD", hash_generated_method = "6E06E02258505B72A27E2D82B58DDE84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long longValue() {
        long var3647B297BC29A3BA088BCA1543A8629B_437332869 = ((long)get());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return (long)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.082 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "395621DCC8CC04DEBD345573CEB0EC53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float floatValue() {
        float varACA887607DBB4E1678238A769AA68C60_748433707 = ((float)get());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.083 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "68E08FE949C756ECA1FE5819EBE55E44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double doubleValue() {
        double var1116C2BD9A20FF0A436A87C6D78A46AB_1404057792 = ((double)get());
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return (double)get();
    }

    
    private static final long serialVersionUID = 6214790243416807050L;
    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    private static final long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicInteger.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

