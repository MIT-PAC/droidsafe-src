package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicReference<V> implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.952 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "FA4D8CAB2A7D5C460EB507A64EFD91CB")

    private volatile V value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.956 -0400", hash_original_method = "BDBA762FEAF5C103321D9E7FB6720E1A", hash_generated_method = "7EDDAFC99DF1D5B5D132C5D542902760")
    public  AtomicReference(V initialValue) {
        value = initialValue;
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.957 -0400", hash_original_method = "F97CF4B9707D277EAF947474019CC6FE", hash_generated_method = "92D86C2B7F31D409EA2507200825BA47")
    public  AtomicReference() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.958 -0400", hash_original_method = "479D74F52EAA9F8F31AB11658696490B", hash_generated_method = "625C3972F85B90359FE9E9D2CC5B4F7F")
    public final V get() {
        V varB4EAC82CA7396A68D541C85D26508E83_124098721 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_124098721 = value;
        varB4EAC82CA7396A68D541C85D26508E83_124098721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_124098721;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.958 -0400", hash_original_method = "1165CC32E796F42C2841421B342AA16F", hash_generated_method = "9C8571AF8F60E12C4A3246C4368A02A4")
    public final void set(V newValue) {
        value = newValue;
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.958 -0400", hash_original_method = "5F145FC62F46FF5FAD786BED834DE8D5", hash_generated_method = "FA5A808455E5A11B201E7A17A0825789")
    public final void lazySet(V newValue) {
        unsafe.putOrderedObject(this, valueOffset, newValue);
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //unsafe.putOrderedObject(this, valueOffset, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.958 -0400", hash_original_method = "069E7BB7A98500BAF130264F81E7ADC7", hash_generated_method = "7A22969CD6DB3FF0AA5940B06770ACFB")
    public final boolean compareAndSet(V expect, V update) {
        boolean varD929F361250D4CC6717086701C855D6C_990485130 = (unsafe.compareAndSwapObject(this, valueOffset, expect, update));
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_528500707 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_528500707;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.962 -0400", hash_original_method = "801403A92781688D40B445FC7E652974", hash_generated_method = "93785DEBED0AAA9A6363075278363FF0")
    public final boolean weakCompareAndSet(V expect, V update) {
        boolean varD929F361250D4CC6717086701C855D6C_1660354713 = (unsafe.compareAndSwapObject(this, valueOffset, expect, update));
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_438771360 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_438771360;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.976 -0400", hash_original_method = "FD7BCDEFF552AB71FCB964A4983AD19B", hash_generated_method = "F5D8A8EF292EB53C41D2D912DADDDDA2")
    public final V getAndSet(V newValue) {
        V varB4EAC82CA7396A68D541C85D26508E83_598035663 = null; //Variable for return #1
        {
            V x;
            x = get();
            {
                boolean varE8F6CAB6887A1A34DFF41A32382DB312_382021074 = (compareAndSet(x, newValue));
                varB4EAC82CA7396A68D541C85D26508E83_598035663 = x;
            } //End collapsed parenthetic
        } //End block
        addTaint(newValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_598035663.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_598035663;
        // ---------- Original Method ----------
        //while (true) {
            //V x = get();
            //if (compareAndSet(x, newValue))
                //return x;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.977 -0400", hash_original_method = "2EE45E1B1B1F9797465CA7143D35DB76", hash_generated_method = "934A829897D5E9E659EA50E0009C10B6")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_712310193 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_712310193 = String.valueOf(get());
        varB4EAC82CA7396A68D541C85D26508E83_712310193.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_712310193;
        // ---------- Original Method ----------
        //return String.valueOf(get());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.977 -0400", hash_original_field = "098D80BB574EE518B06DE1E615096325", hash_generated_field = "8D5AFC258D184B984A3FB5CEF5457C87")

    private static long serialVersionUID = -1848883965231344442L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.977 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

    private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.977 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicReference.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

