package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.annotations.*;
import sun.misc.Unsafe;





public class AtomicInteger extends Number implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.126 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "AACF1191CE0421BEFC63226B2561E15D")

    private volatile int value;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.127 -0400", hash_original_method = "A3EEEE607FBEBD432F4111F47BB23345", hash_generated_method = "C1B1444E172E49708F3A7562ABBF445D")
    public  AtomicInteger(int initialValue) {
        value = initialValue;
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.127 -0400", hash_original_method = "3B74ED36698F9901BA50127D104C26DE", hash_generated_method = "3FC2676712951E4C0961989AC4A65B09")
    public  AtomicInteger() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.128 -0400", hash_original_method = "2C5A1089E8025181868581E48D922F38", hash_generated_method = "FC93DDD2EF606E3BC107447448DECD9B")
    public final int get() {
        int var2063C1608D6E0BAF80249C42E2BE5804_1103157334 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547444058 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547444058;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.128 -0400", hash_original_method = "E51FD8A91C159D9D3ED3BF52073569AD", hash_generated_method = "046E83718895B73384C8E1C3323B55FE")
    public final void set(int newValue) {
        value = newValue;
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.128 -0400", hash_original_method = "77EB9E59BE67AA43485FF3A0F0492CB7", hash_generated_method = "46BA68458653DC90C264E06F353E734F")
    public final void lazySet(int newValue) {
        addTaint(newValue);
        unsafe.putOrderedInt(this, valueOffset, newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedInt(this, valueOffset, newValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.129 -0400", hash_original_method = "EFF79965BA8CD7578F2A5616273687C7", hash_generated_method = "6A25897A84C05D771F829B7D847D3314")
    public final int getAndSet(int newValue) {
        addTaint(newValue);
for(;;)
        {
            int current = get();
            if(compareAndSet(current, newValue))            
            {
            int var43B5C9175984C071F30B873FDCE0A000_1248666018 = (current);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320194289 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320194289;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //if (compareAndSet(current, newValue))
                //return current;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.129 -0400", hash_original_method = "3CF6D7A3DD4EDBE8D1648E756B160F53", hash_generated_method = "BC2AA5013E9CE8B494BEFE2AF7FCB471")
    public final boolean compareAndSet(int expect, int update) {
        addTaint(update);
        addTaint(expect);
        boolean var9ECD13C81C2E348618ED34F20B495F3C_1235616154 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985281654 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_985281654;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.130 -0400", hash_original_method = "22EC2300FEC70C46ECF009D542FC9430", hash_generated_method = "1685F1A3D906944F3BC127C9B4C5FC1F")
    public final boolean weakCompareAndSet(int expect, int update) {
        addTaint(update);
        addTaint(expect);
        boolean var9ECD13C81C2E348618ED34F20B495F3C_1188458269 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_147022525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_147022525;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.130 -0400", hash_original_method = "621C33BC86CD3122044A53600F895B29", hash_generated_method = "8FE5CDA8B7032B56B87370716CFC7CD8")
    public final int getAndIncrement() {
for(;;)
        {
            int current = get();
            int next = current + 1;
            if(compareAndSet(current, next))            
            {
            int var43B5C9175984C071F30B873FDCE0A000_1285762803 = (current);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637653944 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637653944;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.131 -0400", hash_original_method = "D5257E8A410056D1BB1DB7447390EAE5", hash_generated_method = "FF1DAD75F8A21F137F6E2FB36CE9F03D")
    public final int getAndDecrement() {
for(;;)
        {
            int current = get();
            int next = current - 1;
            if(compareAndSet(current, next))            
            {
            int var43B5C9175984C071F30B873FDCE0A000_690947081 = (current);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330147070 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330147070;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.131 -0400", hash_original_method = "4B803B85C89B0C062A735FA86D4518AE", hash_generated_method = "5DE91F1ACBDCD0991DA5AFAD77CB1BC1")
    public final int getAndAdd(int delta) {
        addTaint(delta);
for(;;)
        {
            int current = get();
            int next = current + delta;
            if(compareAndSet(current, next))            
            {
            int var43B5C9175984C071F30B873FDCE0A000_1938310952 = (current);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637583497 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637583497;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.132 -0400", hash_original_method = "6DC45C427ABFB1C3B7D74803EAAF22FF", hash_generated_method = "D606A4FF8FA927C00DC20CBE7A3E9140")
    public final int incrementAndGet() {
for(;;)
        {
            int current = get();
            int next = current + 1;
            if(compareAndSet(current, next))            
            {
            int varD0CAB90D8D20D57E2F2B9BE52F7DD25D_710466508 = (next);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041595157 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041595157;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.132 -0400", hash_original_method = "4357F9DD6725F5F393683EE2EA89C677", hash_generated_method = "5E2DCBDEFD1BE2C04405DC76B68012BD")
    public final int decrementAndGet() {
for(;;)
        {
            int current = get();
            int next = current - 1;
            if(compareAndSet(current, next))            
            {
            int varD0CAB90D8D20D57E2F2B9BE52F7DD25D_281164826 = (next);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000029142 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000029142;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.132 -0400", hash_original_method = "5280B98EAB69F2A556138E3D06C4D0D3", hash_generated_method = "0A82FF45A849CB7BFF8E8EE83E75438C")
    public final int addAndGet(int delta) {
        addTaint(delta);
for(;;)
        {
            int current = get();
            int next = current + delta;
            if(compareAndSet(current, next))            
            {
            int varD0CAB90D8D20D57E2F2B9BE52F7DD25D_51895320 = (next);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311391586 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311391586;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.133 -0400", hash_original_method = "0CBFF056CB46F189F8DC45AFB469D5F9", hash_generated_method = "EA14F286D274404A96CD82720F90CD70")
    public String toString() {
String var4E885050482FEFC0B8A7BD9BDC7A8B32_1173625499 =         Integer.toString(get());
        var4E885050482FEFC0B8A7BD9BDC7A8B32_1173625499.addTaint(taint);
        return var4E885050482FEFC0B8A7BD9BDC7A8B32_1173625499;
        // ---------- Original Method ----------
        //return Integer.toString(get());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.133 -0400", hash_original_method = "B90EC926C8275C97256DF1E0AD9FC076", hash_generated_method = "569858D4FDB1F779D0F36CCF874D2506")
    public int intValue() {
        int var712109514C51D8578A1A5952B71603F1_1616564076 = (get());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901620142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901620142;
        // ---------- Original Method ----------
        //return get();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.133 -0400", hash_original_method = "41D936CCD9A9D16949AE3FD60738B8AD", hash_generated_method = "2C54E0705B40EBD9F498B9A8BFA9F0F0")
    public long longValue() {
        long varEF8EBDCB13F038D7FE9358CB4031A910_1754920843 = ((long)get());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_70968931 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_70968931;
        // ---------- Original Method ----------
        //return (long)get();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.134 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "FC0EFEE5A78DE6EA124D0270C1958842")
    public float floatValue() {
        float varD2E2C7D4AF1D6700F4955F8F274EC437_195874520 = ((float)get());
                float var546ADE640B6EDFBC8A086EF31347E768_1245059104 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1245059104;
        // ---------- Original Method ----------
        //return (float)get();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.134 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "902BF136420EDCA66BC092B8B26B1E47")
    public double doubleValue() {
        double varCE9198F98D4461AFF8CDC2D1ABAB9B8A_678996808 = ((double)get());
                double varE8CD7DA078A86726031AD64F35F5A6C0_277865092 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_277865092;
        // ---------- Original Method ----------
        //return (double)get();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.134 -0400", hash_original_field = "B183F0A1B10C2484948F6B1EC8551E73", hash_generated_field = "BC575BADA52C64A5C5C6ADD1B81BACA0")

    private static final long serialVersionUID = 6214790243416807050L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.134 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.134 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicInteger.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

