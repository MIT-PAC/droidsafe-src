package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import sun.misc.Unsafe;

public class AtomicBoolean implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.111 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "AACF1191CE0421BEFC63226B2561E15D")

    private volatile int value;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.111 -0400", hash_original_method = "2D4043190EFF6FBF71F6E61F91ACE979", hash_generated_method = "FFDDA23FDAF935FA94934FA7D0DF7A90")
    public  AtomicBoolean(boolean initialValue) {
        value = initialValue ? 1 : 0;
        // ---------- Original Method ----------
        //value = initialValue ? 1 : 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.111 -0400", hash_original_method = "4EFA45A0BE6632C845A9BA70932A5A0A", hash_generated_method = "6F354300E0EEDCD66A892901A02868C4")
    public  AtomicBoolean() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.111 -0400", hash_original_method = "5ABD420FFDECFAFBA90B6FD43E53DADE", hash_generated_method = "F7AEE158E2FB3D1A8F3070DB49FCDC71")
    public final boolean get() {
        boolean var80940A95783E22E347BA247FD5DDC6D8_46378998 = (value != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715425769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_715425769;
        // ---------- Original Method ----------
        //return value != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.112 -0400", hash_original_method = "F4EDC6324B18AED31374999FCFCE4700", hash_generated_method = "F4B5459D1989BE5D64C1950310475E92")
    public final boolean compareAndSet(boolean expect, boolean update) {
        addTaint(update);
        addTaint(expect);
        int e = expect ? 1 : 0;
        int u = update ? 1 : 0;
        boolean var5CA3B571703752D24BCB264E904FBACC_534682319 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_588222981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_588222981;
        // ---------- Original Method ----------
        //int e = expect ? 1 : 0;
        //int u = update ? 1 : 0;
        //return unsafe.compareAndSwapInt(this, valueOffset, e, u);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.112 -0400", hash_original_method = "788D44D9ED0FFD916FA1001367F68A82", hash_generated_method = "86328FBBC9E1A8D6ED142FA803E26F98")
    public boolean weakCompareAndSet(boolean expect, boolean update) {
        addTaint(update);
        addTaint(expect);
        int e = expect ? 1 : 0;
        int u = update ? 1 : 0;
        boolean var5CA3B571703752D24BCB264E904FBACC_2038613988 = (unsafe.compareAndSwapInt(this, valueOffset, e, u));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_184424474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_184424474;
        // ---------- Original Method ----------
        //int e = expect ? 1 : 0;
        //int u = update ? 1 : 0;
        //return unsafe.compareAndSwapInt(this, valueOffset, e, u);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.113 -0400", hash_original_method = "FD0CF162327E2AB30C8884FB52F6FB5F", hash_generated_method = "8AC023BF8D2529665F05AB859DBF8644")
    public final void set(boolean newValue) {
        value = newValue ? 1 : 0;
        // ---------- Original Method ----------
        //value = newValue ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.113 -0400", hash_original_method = "CA687482363D6F32107DA02B75F4C570", hash_generated_method = "3E2085D30B2D69D5D8186465488AF7D4")
    public final void lazySet(boolean newValue) {
        addTaint(newValue);
        int v = newValue ? 1 : 0;
        unsafe.putOrderedInt(this, valueOffset, v);
        // ---------- Original Method ----------
        //int v = newValue ? 1 : 0;
        //unsafe.putOrderedInt(this, valueOffset, v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.114 -0400", hash_original_method = "E903BF98EDD2BB9EFF497ED0D64C109B", hash_generated_method = "160F9CCCD494E3F0D96D83D73218DBC9")
    public final boolean getAndSet(boolean newValue) {
        addTaint(newValue);
for(;;)
        {
            boolean current = get();
            if(compareAndSet(current, newValue))            
            {
            boolean var43B5C9175984C071F30B873FDCE0A000_1141651439 = (current);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_150524635 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_150524635;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //boolean current = get();
            //if (compareAndSet(current, newValue))
                //return current;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.114 -0400", hash_original_method = "A5A2E0E9AE6072C3F7FFFC3FCCD2C5BC", hash_generated_method = "16D64B3D16B7B1745EA56BD8F8272A72")
    public String toString() {
String var04FF01733FCCCBE212341A4CEBFC4CB8_484574697 =         Boolean.toString(get());
        var04FF01733FCCCBE212341A4CEBFC4CB8_484574697.addTaint(taint);
        return var04FF01733FCCCBE212341A4CEBFC4CB8_484574697;
        // ---------- Original Method ----------
        //return Boolean.toString(get());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.114 -0400", hash_original_field = "E90959DB6E9E118F7A3ACE67192B69BA", hash_generated_field = "0560675D9B140F497F7B6539FEA0318E")

    private static final long serialVersionUID = 4654671469794556979L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.114 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.114 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicBoolean.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

