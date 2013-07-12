package java.util.concurrent.atomic;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import sun.misc.Unsafe;

public class AtomicBoolean implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.652 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "AACF1191CE0421BEFC63226B2561E15D")

    private volatile int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.653 -0400", hash_original_method = "2D4043190EFF6FBF71F6E61F91ACE979", hash_generated_method = "FFDDA23FDAF935FA94934FA7D0DF7A90")
    public  AtomicBoolean(boolean initialValue) {
        value = initialValue ? 1 : 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.653 -0400", hash_original_method = "4EFA45A0BE6632C845A9BA70932A5A0A", hash_generated_method = "6F354300E0EEDCD66A892901A02868C4")
    public  AtomicBoolean() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.653 -0400", hash_original_method = "5ABD420FFDECFAFBA90B6FD43E53DADE", hash_generated_method = "D49DADD7DDC9B5D9304401D600ED0B60")
    public final boolean get() {
        boolean var80940A95783E22E347BA247FD5DDC6D8_1388993774 = (value != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739617769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739617769;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.654 -0400", hash_original_method = "F4EDC6324B18AED31374999FCFCE4700", hash_generated_method = "856E5272FB9EBFD2CBBC4C35201D6669")
    public final boolean compareAndSet(boolean expect, boolean update) {
        addTaint(update);
        addTaint(expect);
        int e = expect ? 1 : 0;
        int u = update ? 1 : 0;
        boolean var5CA3B571703752D24BCB264E904FBACC_1008659883 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1915550624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1915550624;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.654 -0400", hash_original_method = "788D44D9ED0FFD916FA1001367F68A82", hash_generated_method = "81215A83F9A8580C423DE29DCDA26868")
    public boolean weakCompareAndSet(boolean expect, boolean update) {
        addTaint(update);
        addTaint(expect);
        int e = expect ? 1 : 0;
        int u = update ? 1 : 0;
        boolean var5CA3B571703752D24BCB264E904FBACC_1828864992 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415987399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_415987399;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.655 -0400", hash_original_method = "FD0CF162327E2AB30C8884FB52F6FB5F", hash_generated_method = "8AC023BF8D2529665F05AB859DBF8644")
    public final void set(boolean newValue) {
        value = newValue ? 1 : 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.655 -0400", hash_original_method = "CA687482363D6F32107DA02B75F4C570", hash_generated_method = "3E2085D30B2D69D5D8186465488AF7D4")
    public final void lazySet(boolean newValue) {
        addTaint(newValue);
        int v = newValue ? 1 : 0;
        unsafe.putOrderedInt(this, valueOffset, v);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.656 -0400", hash_original_method = "E903BF98EDD2BB9EFF497ED0D64C109B", hash_generated_method = "B178CABFF32ACA8E064308726FD16BB2")
    public final boolean getAndSet(boolean newValue) {
        addTaint(newValue);
for(;;)
        {
            boolean current = get();
    if(compareAndSet(current, newValue))            
            {
            boolean var43B5C9175984C071F30B873FDCE0A000_1513270404 = (current);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1519342935 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1519342935;
            }
        } 
        
        
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.656 -0400", hash_original_method = "A5A2E0E9AE6072C3F7FFFC3FCCD2C5BC", hash_generated_method = "37134153D4AD0410A98E6157CD5BB53C")
    public String toString() {
String var04FF01733FCCCBE212341A4CEBFC4CB8_684806915 =         Boolean.toString(get());
        var04FF01733FCCCBE212341A4CEBFC4CB8_684806915.addTaint(taint);
        return var04FF01733FCCCBE212341A4CEBFC4CB8_684806915;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.656 -0400", hash_original_field = "E90959DB6E9E118F7A3ACE67192B69BA", hash_generated_field = "0560675D9B140F497F7B6539FEA0318E")

    private static final long serialVersionUID = 4654671469794556979L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.657 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.657 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicBoolean.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

