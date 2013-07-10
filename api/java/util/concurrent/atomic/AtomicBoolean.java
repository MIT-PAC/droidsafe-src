package java.util.concurrent.atomic;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicBoolean implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.358 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "AACF1191CE0421BEFC63226B2561E15D")

    private volatile int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.359 -0400", hash_original_method = "2D4043190EFF6FBF71F6E61F91ACE979", hash_generated_method = "FFDDA23FDAF935FA94934FA7D0DF7A90")
    public  AtomicBoolean(boolean initialValue) {
        value = initialValue ? 1 : 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.359 -0400", hash_original_method = "4EFA45A0BE6632C845A9BA70932A5A0A", hash_generated_method = "6F354300E0EEDCD66A892901A02868C4")
    public  AtomicBoolean() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.359 -0400", hash_original_method = "5ABD420FFDECFAFBA90B6FD43E53DADE", hash_generated_method = "3765B6B2EA12CDCDB249209028775F03")
    public final boolean get() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_701873735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_701873735;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.360 -0400", hash_original_method = "F4EDC6324B18AED31374999FCFCE4700", hash_generated_method = "311C614AA7A982265D5B21CD55CABAF7")
    public final boolean compareAndSet(boolean expect, boolean update) {
        int e;
        e = 1;
        e = 0;
        int u;
        u = 1;
        u = 0;
        boolean var35D2F955F124F37C2BDFC7B5DA6B44FD_1592219854 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_460143928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_460143928;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.360 -0400", hash_original_method = "788D44D9ED0FFD916FA1001367F68A82", hash_generated_method = "2381C35653F6402DFA89FD3BDE563BE5")
    public boolean weakCompareAndSet(boolean expect, boolean update) {
        int e;
        e = 1;
        e = 0;
        int u;
        u = 1;
        u = 0;
        boolean var35D2F955F124F37C2BDFC7B5DA6B44FD_1651837417 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922542841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922542841;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.360 -0400", hash_original_method = "FD0CF162327E2AB30C8884FB52F6FB5F", hash_generated_method = "8AC023BF8D2529665F05AB859DBF8644")
    public final void set(boolean newValue) {
        value = newValue ? 1 : 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.361 -0400", hash_original_method = "CA687482363D6F32107DA02B75F4C570", hash_generated_method = "9F92A13600490ED01BAD600B0276D774")
    public final void lazySet(boolean newValue) {
        int v;
        v = 1;
        v = 0;
        unsafe.putOrderedInt(this, valueOffset, v);
        addTaint(newValue);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.361 -0400", hash_original_method = "E903BF98EDD2BB9EFF497ED0D64C109B", hash_generated_method = "EA10A3CABF164C2FA0FE4914C7CACC0B")
    public final boolean getAndSet(boolean newValue) {
        {
            boolean current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_1500508079 = (compareAndSet(current, newValue));
            } 
        } 
        addTaint(newValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306007344 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306007344;
        
        
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.362 -0400", hash_original_method = "A5A2E0E9AE6072C3F7FFFC3FCCD2C5BC", hash_generated_method = "71B00C9395BA95478651E38621AE6AD3")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1810346103 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1810346103 = Boolean.toString(get());
        varB4EAC82CA7396A68D541C85D26508E83_1810346103.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1810346103;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.362 -0400", hash_original_field = "E90959DB6E9E118F7A3ACE67192B69BA", hash_generated_field = "0560675D9B140F497F7B6539FEA0318E")

    private static final long serialVersionUID = 4654671469794556979L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.362 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.362 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicBoolean.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

