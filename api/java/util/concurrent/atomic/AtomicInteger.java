package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import sun.misc.Unsafe;

public class AtomicInteger extends Number implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.667 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "AACF1191CE0421BEFC63226B2561E15D")

    private volatile int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.667 -0400", hash_original_method = "A3EEEE607FBEBD432F4111F47BB23345", hash_generated_method = "C1B1444E172E49708F3A7562ABBF445D")
    public  AtomicInteger(int initialValue) {
        value = initialValue;
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.667 -0400", hash_original_method = "3B74ED36698F9901BA50127D104C26DE", hash_generated_method = "3FC2676712951E4C0961989AC4A65B09")
    public  AtomicInteger() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.668 -0400", hash_original_method = "2C5A1089E8025181868581E48D922F38", hash_generated_method = "FD9AD5BE142AB14F46F7CC1D9973FE53")
    public final int get() {
        int var2063C1608D6E0BAF80249C42E2BE5804_1304699371 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468199399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468199399;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.668 -0400", hash_original_method = "E51FD8A91C159D9D3ED3BF52073569AD", hash_generated_method = "046E83718895B73384C8E1C3323B55FE")
    public final void set(int newValue) {
        value = newValue;
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.669 -0400", hash_original_method = "77EB9E59BE67AA43485FF3A0F0492CB7", hash_generated_method = "46BA68458653DC90C264E06F353E734F")
    public final void lazySet(int newValue) {
        addTaint(newValue);
        unsafe.putOrderedInt(this, valueOffset, newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedInt(this, valueOffset, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.669 -0400", hash_original_method = "EFF79965BA8CD7578F2A5616273687C7", hash_generated_method = "3F2D0C7C008FC60BC544AC6A2478B6B4")
    public final int getAndSet(int newValue) {
        addTaint(newValue);
for(;;)
        {
            int current = get();
    if(compareAndSet(current, newValue))            
            {
            int var43B5C9175984C071F30B873FDCE0A000_770069823 = (current);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401501915 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401501915;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //if (compareAndSet(current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.669 -0400", hash_original_method = "3CF6D7A3DD4EDBE8D1648E756B160F53", hash_generated_method = "B88FD55B6541A4DF52D199BE337FD78E")
    public final boolean compareAndSet(int expect, int update) {
        addTaint(update);
        addTaint(expect);
        boolean var9ECD13C81C2E348618ED34F20B495F3C_1345037290 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235988320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235988320;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.670 -0400", hash_original_method = "22EC2300FEC70C46ECF009D542FC9430", hash_generated_method = "AC831729262B5A83943DB222E5A83B5E")
    public final boolean weakCompareAndSet(int expect, int update) {
        addTaint(update);
        addTaint(expect);
        boolean var9ECD13C81C2E348618ED34F20B495F3C_1484301770 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1514964233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1514964233;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.670 -0400", hash_original_method = "621C33BC86CD3122044A53600F895B29", hash_generated_method = "47AD1592E2A3E05DFD084EBD07E26937")
    public final int getAndIncrement() {
for(;;)
        {
            int current = get();
            int next = current + 1;
    if(compareAndSet(current, next))            
            {
            int var43B5C9175984C071F30B873FDCE0A000_1007418182 = (current);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979657390 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979657390;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.671 -0400", hash_original_method = "D5257E8A410056D1BB1DB7447390EAE5", hash_generated_method = "881053DA7BA29922C125503DB71A3853")
    public final int getAndDecrement() {
for(;;)
        {
            int current = get();
            int next = current - 1;
    if(compareAndSet(current, next))            
            {
            int var43B5C9175984C071F30B873FDCE0A000_2049150006 = (current);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701587918 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701587918;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current - 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.671 -0400", hash_original_method = "4B803B85C89B0C062A735FA86D4518AE", hash_generated_method = "ADEA7C1858ABD2FAE31364F5B8C35C76")
    public final int getAndAdd(int delta) {
        addTaint(delta);
for(;;)
        {
            int current = get();
            int next = current + delta;
    if(compareAndSet(current, next))            
            {
            int var43B5C9175984C071F30B873FDCE0A000_523878847 = (current);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665762482 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665762482;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + delta;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.671 -0400", hash_original_method = "6DC45C427ABFB1C3B7D74803EAAF22FF", hash_generated_method = "3A455F9A43DE23A85B352F1E943822A5")
    public final int incrementAndGet() {
for(;;)
        {
            int current = get();
            int next = current + 1;
    if(compareAndSet(current, next))            
            {
            int varD0CAB90D8D20D57E2F2B9BE52F7DD25D_1141673098 = (next);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247075838 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247075838;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.672 -0400", hash_original_method = "4357F9DD6725F5F393683EE2EA89C677", hash_generated_method = "9DB22DE9E2D7CFEC1F3C73A9D97365F4")
    public final int decrementAndGet() {
for(;;)
        {
            int current = get();
            int next = current - 1;
    if(compareAndSet(current, next))            
            {
            int varD0CAB90D8D20D57E2F2B9BE52F7DD25D_1007530259 = (next);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156988771 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156988771;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current - 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.672 -0400", hash_original_method = "5280B98EAB69F2A556138E3D06C4D0D3", hash_generated_method = "A1B38703633D8DC765BAF24A06C3182E")
    public final int addAndGet(int delta) {
        addTaint(delta);
for(;;)
        {
            int current = get();
            int next = current + delta;
    if(compareAndSet(current, next))            
            {
            int varD0CAB90D8D20D57E2F2B9BE52F7DD25D_200961830 = (next);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11479181 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11479181;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + delta;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.673 -0400", hash_original_method = "0CBFF056CB46F189F8DC45AFB469D5F9", hash_generated_method = "52F7C3656875F2F1D825245BDCF5A258")
    public String toString() {
String var4E885050482FEFC0B8A7BD9BDC7A8B32_1774817785 =         Integer.toString(get());
        var4E885050482FEFC0B8A7BD9BDC7A8B32_1774817785.addTaint(taint);
        return var4E885050482FEFC0B8A7BD9BDC7A8B32_1774817785;
        // ---------- Original Method ----------
        //return Integer.toString(get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.673 -0400", hash_original_method = "B90EC926C8275C97256DF1E0AD9FC076", hash_generated_method = "76CD00BBCEABA9E662EBF1BD1E31FED8")
    public int intValue() {
        int var712109514C51D8578A1A5952B71603F1_989662081 = (get());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241403641 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241403641;
        // ---------- Original Method ----------
        //return get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.673 -0400", hash_original_method = "41D936CCD9A9D16949AE3FD60738B8AD", hash_generated_method = "C0D6DA988002ADFE51D4CFE7BF79DC51")
    public long longValue() {
        long varEF8EBDCB13F038D7FE9358CB4031A910_1679481521 = ((long)get());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1592756169 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1592756169;
        // ---------- Original Method ----------
        //return (long)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.674 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "335B54511E9CD4E357B63E7A8088189A")
    public float floatValue() {
        float varD2E2C7D4AF1D6700F4955F8F274EC437_1867034678 = ((float)get());
                float var546ADE640B6EDFBC8A086EF31347E768_1788347547 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1788347547;
        // ---------- Original Method ----------
        //return (float)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.674 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "22AC321DAE0BEB1E5E7FB26F35A49FB5")
    public double doubleValue() {
        double varCE9198F98D4461AFF8CDC2D1ABAB9B8A_995666189 = ((double)get());
                double varE8CD7DA078A86726031AD64F35F5A6C0_2138453346 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2138453346;
        // ---------- Original Method ----------
        //return (double)get();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.674 -0400", hash_original_field = "B183F0A1B10C2484948F6B1EC8551E73", hash_generated_field = "BC575BADA52C64A5C5C6ADD1B81BACA0")

    private static final long serialVersionUID = 6214790243416807050L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.674 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.674 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicInteger.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

