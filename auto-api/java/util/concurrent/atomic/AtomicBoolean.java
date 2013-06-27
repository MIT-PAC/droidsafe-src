package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicBoolean implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.676 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "AACF1191CE0421BEFC63226B2561E15D")

    private volatile int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.677 -0400", hash_original_method = "2D4043190EFF6FBF71F6E61F91ACE979", hash_generated_method = "FFDDA23FDAF935FA94934FA7D0DF7A90")
    public  AtomicBoolean(boolean initialValue) {
        value = initialValue ? 1 : 0;
        // ---------- Original Method ----------
        //value = initialValue ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.677 -0400", hash_original_method = "4EFA45A0BE6632C845A9BA70932A5A0A", hash_generated_method = "6F354300E0EEDCD66A892901A02868C4")
    public  AtomicBoolean() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.705 -0400", hash_original_method = "5ABD420FFDECFAFBA90B6FD43E53DADE", hash_generated_method = "8C91CE5817B8B256AC51E1DA84E53ACB")
    public final boolean get() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2119727996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2119727996;
        // ---------- Original Method ----------
        //return value != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.706 -0400", hash_original_method = "F4EDC6324B18AED31374999FCFCE4700", hash_generated_method = "C918E56CBC8B68F6DB0FBE3DEB2E92D9")
    public final boolean compareAndSet(boolean expect, boolean update) {
        int e;
        e = 1;
        e = 0;
        int u;
        u = 1;
        u = 0;
        boolean var35D2F955F124F37C2BDFC7B5DA6B44FD_405368410 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415822708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415822708;
        // ---------- Original Method ----------
        //int e = expect ? 1 : 0;
        //int u = update ? 1 : 0;
        //return unsafe.compareAndSwapInt(this, valueOffset, e, u);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.706 -0400", hash_original_method = "788D44D9ED0FFD916FA1001367F68A82", hash_generated_method = "2CC5280B59D10ACA6E7C198E42F0DBCA")
    public boolean weakCompareAndSet(boolean expect, boolean update) {
        int e;
        e = 1;
        e = 0;
        int u;
        u = 1;
        u = 0;
        boolean var35D2F955F124F37C2BDFC7B5DA6B44FD_643848232 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_238502366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_238502366;
        // ---------- Original Method ----------
        //int e = expect ? 1 : 0;
        //int u = update ? 1 : 0;
        //return unsafe.compareAndSwapInt(this, valueOffset, e, u);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.707 -0400", hash_original_method = "FD0CF162327E2AB30C8884FB52F6FB5F", hash_generated_method = "8AC023BF8D2529665F05AB859DBF8644")
    public final void set(boolean newValue) {
        value = newValue ? 1 : 0;
        // ---------- Original Method ----------
        //value = newValue ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.707 -0400", hash_original_method = "CA687482363D6F32107DA02B75F4C570", hash_generated_method = "9F92A13600490ED01BAD600B0276D774")
    public final void lazySet(boolean newValue) {
        int v;
        v = 1;
        v = 0;
        unsafe.putOrderedInt(this, valueOffset, v);
        addTaint(newValue);
        // ---------- Original Method ----------
        //int v = newValue ? 1 : 0;
        //unsafe.putOrderedInt(this, valueOffset, v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.707 -0400", hash_original_method = "E903BF98EDD2BB9EFF497ED0D64C109B", hash_generated_method = "498A8F5DBCA54B3C3AE7D6C9E8A4AD45")
    public final boolean getAndSet(boolean newValue) {
        {
            boolean current;
            current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_820892490 = (compareAndSet(current, newValue));
            } //End collapsed parenthetic
        } //End block
        addTaint(newValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609993192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609993192;
        // ---------- Original Method ----------
        //for (;;) {
            //boolean current = get();
            //if (compareAndSet(current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.717 -0400", hash_original_method = "A5A2E0E9AE6072C3F7FFFC3FCCD2C5BC", hash_generated_method = "31ABEF033A29DFB88B6FAF291C5FBCB5")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1119082967 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1119082967 = Boolean.toString(get());
        varB4EAC82CA7396A68D541C85D26508E83_1119082967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1119082967;
        // ---------- Original Method ----------
        //return Boolean.toString(get());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.717 -0400", hash_original_field = "E90959DB6E9E118F7A3ACE67192B69BA", hash_generated_field = "BB2930D5C77530364A60A59BC5BDAFDA")

    private static long serialVersionUID = 4654671469794556979L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.717 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

    private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.717 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicBoolean.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

