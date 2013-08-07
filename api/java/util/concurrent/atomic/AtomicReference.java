package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.annotations.*;
import sun.misc.Unsafe;





public class AtomicReference<V> implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.169 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "FA4D8CAB2A7D5C460EB507A64EFD91CB")

    private volatile V value;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.169 -0400", hash_original_method = "BDBA762FEAF5C103321D9E7FB6720E1A", hash_generated_method = "7EDDAFC99DF1D5B5D132C5D542902760")
    public  AtomicReference(V initialValue) {
        value = initialValue;
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.169 -0400", hash_original_method = "F97CF4B9707D277EAF947474019CC6FE", hash_generated_method = "92D86C2B7F31D409EA2507200825BA47")
    public  AtomicReference() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.170 -0400", hash_original_method = "479D74F52EAA9F8F31AB11658696490B", hash_generated_method = "05CA9BAB0198F73B518D8AFB251D89D1")
    public final V get() {
V varAF280DA2BC37D8BE783D8499160168DE_1735997127 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1735997127.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1735997127;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.170 -0400", hash_original_method = "1165CC32E796F42C2841421B342AA16F", hash_generated_method = "9C8571AF8F60E12C4A3246C4368A02A4")
    public final void set(V newValue) {
        value = newValue;
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.170 -0400", hash_original_method = "5F145FC62F46FF5FAD786BED834DE8D5", hash_generated_method = "8114606CD5414A1E7F9E20E488CCACC7")
    public final void lazySet(V newValue) {
        addTaint(newValue.getTaint());
        unsafe.putOrderedObject(this, valueOffset, newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedObject(this, valueOffset, newValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.171 -0400", hash_original_method = "069E7BB7A98500BAF130264F81E7ADC7", hash_generated_method = "7DE5E0343E04ABAE5FB2B783EEE8DF3A")
    public final boolean compareAndSet(V expect, V update) {
        addTaint(update.getTaint());
        addTaint(expect.getTaint());
        boolean var27878A05386C11842E579CA5897F4133_2071413854 = (unsafe.compareAndSwapObject(this, valueOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1865395556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1865395556;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, valueOffset, expect, update);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.171 -0400", hash_original_method = "801403A92781688D40B445FC7E652974", hash_generated_method = "0D51E2ECA2CC8779F3B1C99C753A4F6E")
    public final boolean weakCompareAndSet(V expect, V update) {
        addTaint(update.getTaint());
        addTaint(expect.getTaint());
        boolean var27878A05386C11842E579CA5897F4133_597007472 = (unsafe.compareAndSwapObject(this, valueOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089914320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089914320;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, valueOffset, expect, update);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.171 -0400", hash_original_method = "FD7BCDEFF552AB71FCB964A4983AD19B", hash_generated_method = "AD66135E7A55BD0684A004721996A125")
    public final V getAndSet(V newValue) {
        addTaint(newValue.getTaint());
        while
(true)        
        {
            V x = get();
            if(compareAndSet(x, newValue))            
            {
V varEA5659DA512DECF23E6D37EE8060D074_1916253256 =             x;
            varEA5659DA512DECF23E6D37EE8060D074_1916253256.addTaint(taint);
            return varEA5659DA512DECF23E6D37EE8060D074_1916253256;
            }
        } //End block
        // ---------- Original Method ----------
        //while (true) {
            //V x = get();
            //if (compareAndSet(x, newValue))
                //return x;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.172 -0400", hash_original_method = "2EE45E1B1B1F9797465CA7143D35DB76", hash_generated_method = "A221A525F191C665DA323E2E2AFAD55A")
    public String toString() {
String varCD8D3C26BD1C8483FC8C87F7BCDC2A28_1688227349 =         String.valueOf(get());
        varCD8D3C26BD1C8483FC8C87F7BCDC2A28_1688227349.addTaint(taint);
        return varCD8D3C26BD1C8483FC8C87F7BCDC2A28_1688227349;
        // ---------- Original Method ----------
        //return String.valueOf(get());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.172 -0400", hash_original_field = "098D80BB574EE518B06DE1E615096325", hash_generated_field = "F377B552F3A51EC0DBE8D7F8863A64C0")

    private static final long serialVersionUID = -1848883965231344442L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.172 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.172 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicReference.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

