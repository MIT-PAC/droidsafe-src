package java.util.concurrent.atomic;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import sun.misc.Unsafe;

public class AtomicLong extends Number implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.683 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "272863A964896393C50056118F48F189")

    private volatile long value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.684 -0400", hash_original_method = "6ECA774993D880ABD38A420DC693E35F", hash_generated_method = "E46494BE6F9671647D71141C197C734C")
    public  AtomicLong(long initialValue) {
        value = initialValue;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.684 -0400", hash_original_method = "E5BCC7DD3ADE986582FDD04FB62FAAFA", hash_generated_method = "F7B97E703BF9873CEAC0A4C7BFF9C409")
    public  AtomicLong() {
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean VMSupportsCS8() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.685 -0400", hash_original_method = "558225EAA1BF82052D6B969C16747B7A", hash_generated_method = "33F76A75AC4058B3A3938A792A0D4A52")
    public final long get() {
        long var2063C1608D6E0BAF80249C42E2BE5804_1936044815 = (value);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_972876117 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_972876117;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.685 -0400", hash_original_method = "CA4706358CD81A962EB6E91A1521FBCA", hash_generated_method = "759FAB5F7283596918C96BEC499CB5B0")
    public final void set(long newValue) {
        value = newValue;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.685 -0400", hash_original_method = "5F840B47C39798AC1AA2E3C6DCFC9B43", hash_generated_method = "8E61D805C48F4AD27B61462F745A01AF")
    public final void lazySet(long newValue) {
        addTaint(newValue);
        unsafe.putOrderedLong(this, valueOffset, newValue);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.686 -0400", hash_original_method = "390AAB13B16AF188378473BA59BB98BA", hash_generated_method = "1137B8822EAE5685206A81EF09203201")
    public final long getAndSet(long newValue) {
        addTaint(newValue);
        while
(true)        
        {
            long current = get();
    if(compareAndSet(current, newValue))            
            {
            long var43B5C9175984C071F30B873FDCE0A000_2095282405 = (current);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1769490194 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1769490194;
            }
        } 
        
        
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.686 -0400", hash_original_method = "9AFEEC1B0401F372D8D224EE7A6E78FB", hash_generated_method = "E9D8E09A6B6486A91A257C3CBF7F3117")
    public final boolean compareAndSet(long expect, long update) {
        addTaint(update);
        addTaint(expect);
        boolean var92B53B847C742576E01DDEDEB9AF27B7_1173986037 = (unsafe.compareAndSwapLong(this, valueOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_299424697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_299424697;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.687 -0400", hash_original_method = "CF5E29839097193C76F9677539F6A8BA", hash_generated_method = "B802CDCD6C51504F107BC4D414BE1CC6")
    public final boolean weakCompareAndSet(long expect, long update) {
        addTaint(update);
        addTaint(expect);
        boolean var92B53B847C742576E01DDEDEB9AF27B7_386116245 = (unsafe.compareAndSwapLong(this, valueOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368430913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368430913;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.687 -0400", hash_original_method = "0FB09453B9C7F7E3674DED4A168E8FE2", hash_generated_method = "C14B73C7113118F39A8776498C9211D5")
    public final long getAndIncrement() {
        while
(true)        
        {
            long current = get();
            long next = current + 1;
    if(compareAndSet(current, next))            
            {
            long var43B5C9175984C071F30B873FDCE0A000_1603553118 = (current);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1293777924 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1293777924;
            }
        } 
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.687 -0400", hash_original_method = "B338EF04AC352C769CAB7069B279216B", hash_generated_method = "19F03C38119C8017089549DE50BF8ECD")
    public final long getAndDecrement() {
        while
(true)        
        {
            long current = get();
            long next = current - 1;
    if(compareAndSet(current, next))            
            {
            long var43B5C9175984C071F30B873FDCE0A000_1056205849 = (current);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_548020760 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_548020760;
            }
        } 
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.688 -0400", hash_original_method = "F13F3FE7BE5ED16E2943CEEE9739382A", hash_generated_method = "76D9D6E567DB247CE248E49DCBB02699")
    public final long getAndAdd(long delta) {
        addTaint(delta);
        while
(true)        
        {
            long current = get();
            long next = current + delta;
    if(compareAndSet(current, next))            
            {
            long var43B5C9175984C071F30B873FDCE0A000_1586621566 = (current);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1741993675 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1741993675;
            }
        } 
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.688 -0400", hash_original_method = "0B4DA3D002D9BEE66893798DFD4DBDF7", hash_generated_method = "E021CAA83C7B01F774900D150D96A426")
    public final long incrementAndGet() {
for(;;)
        {
            long current = get();
            long next = current + 1;
    if(compareAndSet(current, next))            
            {
            long varD0CAB90D8D20D57E2F2B9BE52F7DD25D_1599480350 = (next);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1062765478 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1062765478;
            }
        } 
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.689 -0400", hash_original_method = "BC527AFE730427BE036B66CE7C20403C", hash_generated_method = "0CF9C59764ACCD1FA015F085A31742F0")
    public final long decrementAndGet() {
for(;;)
        {
            long current = get();
            long next = current - 1;
    if(compareAndSet(current, next))            
            {
            long varD0CAB90D8D20D57E2F2B9BE52F7DD25D_741300744 = (next);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1699335373 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1699335373;
            }
        } 
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.689 -0400", hash_original_method = "9F7FB16A58B977A4E2DB5A0F397D878E", hash_generated_method = "23A24DD477629C11909F51E64EC157C2")
    public final long addAndGet(long delta) {
        addTaint(delta);
for(;;)
        {
            long current = get();
            long next = current + delta;
    if(compareAndSet(current, next))            
            {
            long varD0CAB90D8D20D57E2F2B9BE52F7DD25D_2054395620 = (next);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1647470650 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1647470650;
            }
        } 
        
        
            
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.690 -0400", hash_original_method = "87FB115D4E2C883D105781A1EF69130B", hash_generated_method = "93668B91E7AF51544E8B367D91C20850")
    public String toString() {
String var8D83B147215B7C98D629429D69E90CAA_1045639196 =         Long.toString(get());
        var8D83B147215B7C98D629429D69E90CAA_1045639196.addTaint(taint);
        return var8D83B147215B7C98D629429D69E90CAA_1045639196;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.690 -0400", hash_original_method = "84EB409D8DAC6A9532DB1B14F662CA95", hash_generated_method = "24066D2585752BE8991C47A485C31E61")
    public int intValue() {
        int var83C554532A3C780DBF6F4ED851BD9F1F_1030793758 = ((int)get());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041730430 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041730430;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.690 -0400", hash_original_method = "8D0E58021498DD6F55D0437545A61BE8", hash_generated_method = "2D90254742DE074A9A9DEA7DD40ED3C1")
    public long longValue() {
        long var712109514C51D8578A1A5952B71603F1_441463605 = (get());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2062529244 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2062529244;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.690 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "523F0D7BA35BBDB964A11D957FCF0DF2")
    public float floatValue() {
        float varD2E2C7D4AF1D6700F4955F8F274EC437_1245436266 = ((float)get());
                float var546ADE640B6EDFBC8A086EF31347E768_231269125 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_231269125;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.691 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "E0B92F4F12785F26CC3458453DE58A32")
    public double doubleValue() {
        double varCE9198F98D4461AFF8CDC2D1ABAB9B8A_1556503670 = ((double)get());
                double varE8CD7DA078A86726031AD64F35F5A6C0_1915954785 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1915954785;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.691 -0400", hash_original_field = "A728B10F96D7F4ED4992FCBBB5E85178", hash_generated_field = "0B880760F282B6C2D9B088CA9DBA6E27")

    private static final long serialVersionUID = 1927816293512124184L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.691 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.691 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.691 -0400", hash_original_field = "788B3E7EED350A570FBB205F360C85C4", hash_generated_field = "FB29CA34A363CAEEC18A2DF988EF15B6")

    static final boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicLong.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

