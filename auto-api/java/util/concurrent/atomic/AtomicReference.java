package java.util.concurrent.atomic;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicReference<V> implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.546 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "FA4D8CAB2A7D5C460EB507A64EFD91CB")

    private volatile V value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.547 -0400", hash_original_method = "BDBA762FEAF5C103321D9E7FB6720E1A", hash_generated_method = "7EDDAFC99DF1D5B5D132C5D542902760")
    public  AtomicReference(V initialValue) {
        value = initialValue;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.547 -0400", hash_original_method = "F97CF4B9707D277EAF947474019CC6FE", hash_generated_method = "92D86C2B7F31D409EA2507200825BA47")
    public  AtomicReference() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.549 -0400", hash_original_method = "479D74F52EAA9F8F31AB11658696490B", hash_generated_method = "00AC5170AB1350607519DFED9AEFDC1B")
    public final V get() {
        V varB4EAC82CA7396A68D541C85D26508E83_1208979903 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1208979903 = value;
        varB4EAC82CA7396A68D541C85D26508E83_1208979903.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1208979903;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.550 -0400", hash_original_method = "1165CC32E796F42C2841421B342AA16F", hash_generated_method = "9C8571AF8F60E12C4A3246C4368A02A4")
    public final void set(V newValue) {
        value = newValue;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.551 -0400", hash_original_method = "5F145FC62F46FF5FAD786BED834DE8D5", hash_generated_method = "FA5A808455E5A11B201E7A17A0825789")
    public final void lazySet(V newValue) {
        unsafe.putOrderedObject(this, valueOffset, newValue);
        addTaint(newValue.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.552 -0400", hash_original_method = "069E7BB7A98500BAF130264F81E7ADC7", hash_generated_method = "2668FEA2F0D27D146222E87D27420815")
    public final boolean compareAndSet(V expect, V update) {
        boolean varD929F361250D4CC6717086701C855D6C_1848309546 = (unsafe.compareAndSwapObject(this, valueOffset, expect, update));
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_76627074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_76627074;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.553 -0400", hash_original_method = "801403A92781688D40B445FC7E652974", hash_generated_method = "AEF3F5121891B03D8F1AABBCC90C3A55")
    public final boolean weakCompareAndSet(V expect, V update) {
        boolean varD929F361250D4CC6717086701C855D6C_1938953682 = (unsafe.compareAndSwapObject(this, valueOffset, expect, update));
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524662308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524662308;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.556 -0400", hash_original_method = "FD7BCDEFF552AB71FCB964A4983AD19B", hash_generated_method = "185327A375865F2876D521018AB4450C")
    public final V getAndSet(V newValue) {
        V varB4EAC82CA7396A68D541C85D26508E83_1023511392 = null; 
        {
            V x = get();
            {
                boolean varE8F6CAB6887A1A34DFF41A32382DB312_476547590 = (compareAndSet(x, newValue));
                varB4EAC82CA7396A68D541C85D26508E83_1023511392 = x;
            } 
        } 
        addTaint(newValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1023511392.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1023511392;
        
        
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.557 -0400", hash_original_method = "2EE45E1B1B1F9797465CA7143D35DB76", hash_generated_method = "2C0F8B98D7312E01C4EAC576EB723BB3")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1446084627 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1446084627 = String.valueOf(get());
        varB4EAC82CA7396A68D541C85D26508E83_1446084627.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1446084627;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.557 -0400", hash_original_field = "098D80BB574EE518B06DE1E615096325", hash_generated_field = "F377B552F3A51EC0DBE8D7F8863A64C0")

    private static final long serialVersionUID = -1848883965231344442L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.557 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.557 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicReference.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

