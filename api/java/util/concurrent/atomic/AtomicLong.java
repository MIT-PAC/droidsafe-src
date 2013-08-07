package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.annotations.*;
import sun.misc.Unsafe;




import droidsafe.helpers.DSUtils;

public class AtomicLong extends Number implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.149 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "272863A964896393C50056118F48F189")

    private volatile long value;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.150 -0400", hash_original_method = "6ECA774993D880ABD38A420DC693E35F", hash_generated_method = "E46494BE6F9671647D71141C197C734C")
    public  AtomicLong(long initialValue) {
        value = initialValue;
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.150 -0400", hash_original_method = "E5BCC7DD3ADE986582FDD04FB62FAAFA", hash_generated_method = "F7B97E703BF9873CEAC0A4C7BFF9C409")
    public  AtomicLong() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean VMSupportsCS8() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.151 -0400", hash_original_method = "558225EAA1BF82052D6B969C16747B7A", hash_generated_method = "7691B160691EBF176116BB239D042275")
    public final long get() {
        long var2063C1608D6E0BAF80249C42E2BE5804_1992226917 = (value);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_493715244 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_493715244;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.151 -0400", hash_original_method = "CA4706358CD81A962EB6E91A1521FBCA", hash_generated_method = "759FAB5F7283596918C96BEC499CB5B0")
    public final void set(long newValue) {
        value = newValue;
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.151 -0400", hash_original_method = "5F840B47C39798AC1AA2E3C6DCFC9B43", hash_generated_method = "8E61D805C48F4AD27B61462F745A01AF")
    public final void lazySet(long newValue) {
        addTaint(newValue);
        unsafe.putOrderedLong(this, valueOffset, newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedLong(this, valueOffset, newValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.152 -0400", hash_original_method = "390AAB13B16AF188378473BA59BB98BA", hash_generated_method = "B12862808A6B65A6635D3435647A8072")
    public final long getAndSet(long newValue) {
        addTaint(newValue);
        while
(true)        
        {
            long current = get();
            if(compareAndSet(current, newValue))            
            {
            long var43B5C9175984C071F30B873FDCE0A000_647940691 = (current);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_933431762 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_933431762;
            }
        } //End block
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //if (compareAndSet(current, newValue))
                //return current;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.152 -0400", hash_original_method = "9AFEEC1B0401F372D8D224EE7A6E78FB", hash_generated_method = "845EF79D05EE2098C7B474843ABF542F")
    public final boolean compareAndSet(long expect, long update) {
        addTaint(update);
        addTaint(expect);
        boolean var92B53B847C742576E01DDEDEB9AF27B7_926699083 = (unsafe.compareAndSwapLong(this, valueOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1696922570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1696922570;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.152 -0400", hash_original_method = "CF5E29839097193C76F9677539F6A8BA", hash_generated_method = "8FA0F15B803B164C6EFE75BA2128DD19")
    public final boolean weakCompareAndSet(long expect, long update) {
        addTaint(update);
        addTaint(expect);
        boolean var92B53B847C742576E01DDEDEB9AF27B7_26858864 = (unsafe.compareAndSwapLong(this, valueOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1149757185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1149757185;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.153 -0400", hash_original_method = "0FB09453B9C7F7E3674DED4A168E8FE2", hash_generated_method = "F8553460340ADDE503F993160588CEB1")
    public final long getAndIncrement() {
        while
(true)        
        {
            long current = get();
            long next = current + 1;
            if(compareAndSet(current, next))            
            {
            long var43B5C9175984C071F30B873FDCE0A000_2109140494 = (current);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1563791864 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1563791864;
            }
        } //End block
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //long next = current + 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.153 -0400", hash_original_method = "B338EF04AC352C769CAB7069B279216B", hash_generated_method = "AB137C2934D81B6EA074F4B3B39F886F")
    public final long getAndDecrement() {
        while
(true)        
        {
            long current = get();
            long next = current - 1;
            if(compareAndSet(current, next))            
            {
            long var43B5C9175984C071F30B873FDCE0A000_311846411 = (current);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_638763183 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_638763183;
            }
        } //End block
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //long next = current - 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.154 -0400", hash_original_method = "F13F3FE7BE5ED16E2943CEEE9739382A", hash_generated_method = "58472CE16715B9086823607D21E40D15")
    public final long getAndAdd(long delta) {
        addTaint(delta);
        while
(true)        
        {
            long current = get();
            long next = current + delta;
            if(compareAndSet(current, next))            
            {
            long var43B5C9175984C071F30B873FDCE0A000_577344026 = (current);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_460271406 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_460271406;
            }
        } //End block
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //long next = current + delta;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.154 -0400", hash_original_method = "0B4DA3D002D9BEE66893798DFD4DBDF7", hash_generated_method = "99CC6070889ADE68072E3046D6C91A03")
    public final long incrementAndGet() {
for(;;)
        {
            long current = get();
            long next = current + 1;
            if(compareAndSet(current, next))            
            {
            long varD0CAB90D8D20D57E2F2B9BE52F7DD25D_1444193637 = (next);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_384551854 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_384551854;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get();
            //long next = current + 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.155 -0400", hash_original_method = "BC527AFE730427BE036B66CE7C20403C", hash_generated_method = "7CAF46F59B61D3776F9A30292DCF2E04")
    public final long decrementAndGet() {
for(;;)
        {
            long current = get();
            long next = current - 1;
            if(compareAndSet(current, next))            
            {
            long varD0CAB90D8D20D57E2F2B9BE52F7DD25D_2101293454 = (next);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_348179613 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_348179613;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get();
            //long next = current - 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.156 -0400", hash_original_method = "9F7FB16A58B977A4E2DB5A0F397D878E", hash_generated_method = "6FD694BD8894E8F97A4A784A91853B3E")
    public final long addAndGet(long delta) {
        addTaint(delta);
for(;;)
        {
            long current = get();
            long next = current + delta;
            if(compareAndSet(current, next))            
            {
            long varD0CAB90D8D20D57E2F2B9BE52F7DD25D_1965773522 = (next);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1916590225 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1916590225;
            }
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get();
            //long next = current + delta;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.156 -0400", hash_original_method = "87FB115D4E2C883D105781A1EF69130B", hash_generated_method = "2A4972F5E7F183C7FD73163335A9581E")
    public String toString() {
String var8D83B147215B7C98D629429D69E90CAA_1072124094 =         Long.toString(get());
        var8D83B147215B7C98D629429D69E90CAA_1072124094.addTaint(taint);
        return var8D83B147215B7C98D629429D69E90CAA_1072124094;
        // ---------- Original Method ----------
        //return Long.toString(get());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.157 -0400", hash_original_method = "84EB409D8DAC6A9532DB1B14F662CA95", hash_generated_method = "680E7177E438E5170EC40E8909BAE8AA")
    public int intValue() {
        int var83C554532A3C780DBF6F4ED851BD9F1F_1080759101 = ((int)get());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656846374 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656846374;
        // ---------- Original Method ----------
        //return (int)get();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.157 -0400", hash_original_method = "8D0E58021498DD6F55D0437545A61BE8", hash_generated_method = "CE379BD0F28F73357C1DB69CBAE1C052")
    public long longValue() {
        long var712109514C51D8578A1A5952B71603F1_1026656208 = (get());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1039141621 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1039141621;
        // ---------- Original Method ----------
        //return get();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.158 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "C96C625F7B023F3039546AEDCF173EBC")
    public float floatValue() {
        float varD2E2C7D4AF1D6700F4955F8F274EC437_1193777961 = ((float)get());
                float var546ADE640B6EDFBC8A086EF31347E768_1979205369 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1979205369;
        // ---------- Original Method ----------
        //return (float)get();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.158 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "6719E9EF7B12C64AB7D4D96D051A210E")
    public double doubleValue() {
        double varCE9198F98D4461AFF8CDC2D1ABAB9B8A_473355418 = ((double)get());
                double varE8CD7DA078A86726031AD64F35F5A6C0_1313145027 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1313145027;
        // ---------- Original Method ----------
        //return (double)get();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.158 -0400", hash_original_field = "A728B10F96D7F4ED4992FCBBB5E85178", hash_generated_field = "0B880760F282B6C2D9B088CA9DBA6E27")

    private static final long serialVersionUID = 1927816293512124184L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.158 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.158 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.158 -0400", hash_original_field = "788B3E7EED350A570FBB205F360C85C4", hash_generated_field = "FB29CA34A363CAEEC18A2DF988EF15B6")

    static final boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicLong.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

