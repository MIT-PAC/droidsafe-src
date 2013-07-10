package java.util.concurrent.atomic;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicLong extends Number implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.419 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "272863A964896393C50056118F48F189")

    private volatile long value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.419 -0400", hash_original_method = "6ECA774993D880ABD38A420DC693E35F", hash_generated_method = "E46494BE6F9671647D71141C197C734C")
    public  AtomicLong(long initialValue) {
        value = initialValue;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.420 -0400", hash_original_method = "E5BCC7DD3ADE986582FDD04FB62FAAFA", hash_generated_method = "F7B97E703BF9873CEAC0A4C7BFF9C409")
    public  AtomicLong() {
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean VMSupportsCS8() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.420 -0400", hash_original_method = "558225EAA1BF82052D6B969C16747B7A", hash_generated_method = "A9EF5C06FC8A1379380B777A112A7F57")
    public final long get() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1950967834 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1950967834;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.421 -0400", hash_original_method = "CA4706358CD81A962EB6E91A1521FBCA", hash_generated_method = "759FAB5F7283596918C96BEC499CB5B0")
    public final void set(long newValue) {
        value = newValue;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.421 -0400", hash_original_method = "5F840B47C39798AC1AA2E3C6DCFC9B43", hash_generated_method = "0276306F535534052A951DB04D2DA7B0")
    public final void lazySet(long newValue) {
        unsafe.putOrderedLong(this, valueOffset, newValue);
        addTaint(newValue);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.422 -0400", hash_original_method = "390AAB13B16AF188378473BA59BB98BA", hash_generated_method = "4E25A7E9581FBCF43FFD31F54B30EEC4")
    public final long getAndSet(long newValue) {
        {
            long current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_457425159 = (compareAndSet(current, newValue));
            } 
        } 
        addTaint(newValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1111780740 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1111780740;
        
        
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.422 -0400", hash_original_method = "9AFEEC1B0401F372D8D224EE7A6E78FB", hash_generated_method = "B9700ACC27AE152CCE92F305BEFDB9C0")
    public final boolean compareAndSet(long expect, long update) {
        boolean varF496D4F81A10D81B002043A1EF78AFD4_1022916461 = (unsafe.compareAndSwapLong(this, valueOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295807803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_295807803;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.423 -0400", hash_original_method = "CF5E29839097193C76F9677539F6A8BA", hash_generated_method = "F2B0B5D713712C88225182CF1F2A5337")
    public final boolean weakCompareAndSet(long expect, long update) {
        boolean varF496D4F81A10D81B002043A1EF78AFD4_11236689 = (unsafe.compareAndSwapLong(this, valueOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396377115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396377115;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.423 -0400", hash_original_method = "0FB09453B9C7F7E3674DED4A168E8FE2", hash_generated_method = "65217010FD141E06476E3321AC88FE23")
    public final long getAndIncrement() {
        {
            long current = get();
            long next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1197635102 = (compareAndSet(current, next));
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_559062045 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_559062045;
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.426 -0400", hash_original_method = "B338EF04AC352C769CAB7069B279216B", hash_generated_method = "14AB12221EEB6A83B509DE4B2AA0A4C3")
    public final long getAndDecrement() {
        {
            long current = get();
            long next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_376775699 = (compareAndSet(current, next));
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_822147941 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_822147941;
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.427 -0400", hash_original_method = "F13F3FE7BE5ED16E2943CEEE9739382A", hash_generated_method = "FEA96807377B7FC629ECA03A1A5E3A69")
    public final long getAndAdd(long delta) {
        {
            long current = get();
            long next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1082590963 = (compareAndSet(current, next));
            } 
        } 
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1520571252 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1520571252;
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.428 -0400", hash_original_method = "0B4DA3D002D9BEE66893798DFD4DBDF7", hash_generated_method = "7F602BD20C3AB1ACADDE29F8CF630844")
    public final long incrementAndGet() {
        {
            long current = get();
            long next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_654129770 = (compareAndSet(current, next));
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_585333443 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_585333443;
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.429 -0400", hash_original_method = "BC527AFE730427BE036B66CE7C20403C", hash_generated_method = "D10D488D9D716F593EF1CA53AAB7008D")
    public final long decrementAndGet() {
        {
            long current = get();
            long next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1343734459 = (compareAndSet(current, next));
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1357052209 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1357052209;
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.430 -0400", hash_original_method = "9F7FB16A58B977A4E2DB5A0F397D878E", hash_generated_method = "C8D31720D95F8016E21BC974CE3E5C1F")
    public final long addAndGet(long delta) {
        {
            long current = get();
            long next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_575756404 = (compareAndSet(current, next));
            } 
        } 
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1931828311 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1931828311;
        
        
            
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.430 -0400", hash_original_method = "87FB115D4E2C883D105781A1EF69130B", hash_generated_method = "0901ED7B710587CF6FE0ADDA079D5995")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1330378305 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1330378305 = Long.toString(get());
        varB4EAC82CA7396A68D541C85D26508E83_1330378305.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1330378305;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.431 -0400", hash_original_method = "84EB409D8DAC6A9532DB1B14F662CA95", hash_generated_method = "7037ED82369D1E1A7727BCA6C62550AC")
    public int intValue() {
        int var44B0419F833AC6EE0D1EEA4F82C029A7_517568794 = ((int)get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022838355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022838355;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.431 -0400", hash_original_method = "8D0E58021498DD6F55D0437545A61BE8", hash_generated_method = "3DB4186A47A8244854D12F28ECA6BE02")
    public long longValue() {
        long varA3899375788C01929C876C11142E44FF_1872792026 = (get());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_457238760 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_457238760;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.431 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "CB62744E73C29A7099EE0C2904AED776")
    public float floatValue() {
        float varACA887607DBB4E1678238A769AA68C60_428251102 = ((float)get());
        float var546ADE640B6EDFBC8A086EF31347E768_1482583565 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1482583565;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.431 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "94677841CE0BC7F9D22A4D97FF655A82")
    public double doubleValue() {
        double var1116C2BD9A20FF0A436A87C6D78A46AB_1944731543 = ((double)get());
        double varE8CD7DA078A86726031AD64F35F5A6C0_1909145980 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1909145980;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.431 -0400", hash_original_field = "A728B10F96D7F4ED4992FCBBB5E85178", hash_generated_field = "0B880760F282B6C2D9B088CA9DBA6E27")

    private static final long serialVersionUID = 1927816293512124184L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.432 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.432 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.432 -0400", hash_original_field = "788B3E7EED350A570FBB205F360C85C4", hash_generated_field = "FB29CA34A363CAEEC18A2DF988EF15B6")

    static final boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicLong.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

