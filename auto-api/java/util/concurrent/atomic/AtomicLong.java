package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicLong extends Number implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.854 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "272863A964896393C50056118F48F189")

    private volatile long value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.855 -0400", hash_original_method = "6ECA774993D880ABD38A420DC693E35F", hash_generated_method = "E46494BE6F9671647D71141C197C734C")
    public  AtomicLong(long initialValue) {
        value = initialValue;
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.862 -0400", hash_original_method = "E5BCC7DD3ADE986582FDD04FB62FAAFA", hash_generated_method = "F7B97E703BF9873CEAC0A4C7BFF9C409")
    public  AtomicLong() {
        // ---------- Original Method ----------
    }

    
        private static boolean VMSupportsCS8() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.862 -0400", hash_original_method = "558225EAA1BF82052D6B969C16747B7A", hash_generated_method = "E80A72A0755EA20869DDFC0247D273DC")
    public final long get() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1047392216 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1047392216;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.862 -0400", hash_original_method = "CA4706358CD81A962EB6E91A1521FBCA", hash_generated_method = "759FAB5F7283596918C96BEC499CB5B0")
    public final void set(long newValue) {
        value = newValue;
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.862 -0400", hash_original_method = "5F840B47C39798AC1AA2E3C6DCFC9B43", hash_generated_method = "0276306F535534052A951DB04D2DA7B0")
    public final void lazySet(long newValue) {
        unsafe.putOrderedLong(this, valueOffset, newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedLong(this, valueOffset, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.863 -0400", hash_original_method = "390AAB13B16AF188378473BA59BB98BA", hash_generated_method = "9EF8AE265C3B831EA0EADC824E037414")
    public final long getAndSet(long newValue) {
        {
            long current;
            current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_866241197 = (compareAndSet(current, newValue));
            } //End collapsed parenthetic
        } //End block
        addTaint(newValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1440962197 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1440962197;
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //if (compareAndSet(current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.863 -0400", hash_original_method = "9AFEEC1B0401F372D8D224EE7A6E78FB", hash_generated_method = "B126B970C65DA3A5FB0A2B32B303477F")
    public final boolean compareAndSet(long expect, long update) {
        boolean varF496D4F81A10D81B002043A1EF78AFD4_475515214 = (unsafe.compareAndSwapLong(this, valueOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1934691272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1934691272;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.871 -0400", hash_original_method = "CF5E29839097193C76F9677539F6A8BA", hash_generated_method = "D0FEBC19F964CDDB6FAE8D3D521D4780")
    public final boolean weakCompareAndSet(long expect, long update) {
        boolean varF496D4F81A10D81B002043A1EF78AFD4_837954278 = (unsafe.compareAndSwapLong(this, valueOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449877899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_449877899;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.871 -0400", hash_original_method = "0FB09453B9C7F7E3674DED4A168E8FE2", hash_generated_method = "98A23800148E4AAEEB9672352FC65D36")
    public final long getAndIncrement() {
        {
            long current;
            current = get();
            long next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_188821224 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1204106756 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1204106756;
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //long next = current + 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.872 -0400", hash_original_method = "B338EF04AC352C769CAB7069B279216B", hash_generated_method = "73D69421C28B1DD52BBFC970A0DFA122")
    public final long getAndDecrement() {
        {
            long current;
            current = get();
            long next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1536945832 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_898854648 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_898854648;
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //long next = current - 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.878 -0400", hash_original_method = "F13F3FE7BE5ED16E2943CEEE9739382A", hash_generated_method = "1FFBBA8E2AF019757C3C6F837677EEBE")
    public final long getAndAdd(long delta) {
        {
            long current;
            current = get();
            long next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_2046442453 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1671708764 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1671708764;
        // ---------- Original Method ----------
        //while (true) {
            //long current = get();
            //long next = current + delta;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.879 -0400", hash_original_method = "0B4DA3D002D9BEE66893798DFD4DBDF7", hash_generated_method = "D49B2C8D56FD39778A8B84EE4BAE84E7")
    public final long incrementAndGet() {
        {
            long current;
            current = get();
            long next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1913753202 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1224933504 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1224933504;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get();
            //long next = current + 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.895 -0400", hash_original_method = "BC527AFE730427BE036B66CE7C20403C", hash_generated_method = "C290D87438C68B1170FE1E30FFC62850")
    public final long decrementAndGet() {
        {
            long current;
            current = get();
            long next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1103935516 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2066118240 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2066118240;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get();
            //long next = current - 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.895 -0400", hash_original_method = "9F7FB16A58B977A4E2DB5A0F397D878E", hash_generated_method = "4F0FBE996B128A25CB45D38D551E6161")
    public final long addAndGet(long delta) {
        {
            long current;
            current = get();
            long next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_699550592 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_691876434 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_691876434;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get();
            //long next = current + delta;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.896 -0400", hash_original_method = "87FB115D4E2C883D105781A1EF69130B", hash_generated_method = "5DBA40FC7CB5982FC9EBB73FA9993465")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_330076044 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_330076044 = Long.toString(get());
        varB4EAC82CA7396A68D541C85D26508E83_330076044.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_330076044;
        // ---------- Original Method ----------
        //return Long.toString(get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.896 -0400", hash_original_method = "84EB409D8DAC6A9532DB1B14F662CA95", hash_generated_method = "554AFAAD62A4EC1FA8741D2E289E15D6")
    public int intValue() {
        int var44B0419F833AC6EE0D1EEA4F82C029A7_731865256 = ((int)get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475532608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475532608;
        // ---------- Original Method ----------
        //return (int)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.897 -0400", hash_original_method = "8D0E58021498DD6F55D0437545A61BE8", hash_generated_method = "7DF7095FC741FCAC71519279786999F0")
    public long longValue() {
        long varA3899375788C01929C876C11142E44FF_1385581338 = (get());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2087233608 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2087233608;
        // ---------- Original Method ----------
        //return get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.898 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "AEFEDEFF66DD243D85848439733B4818")
    public float floatValue() {
        float varACA887607DBB4E1678238A769AA68C60_953388921 = ((float)get());
        float var546ADE640B6EDFBC8A086EF31347E768_1717016961 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1717016961;
        // ---------- Original Method ----------
        //return (float)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.921 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "014E0181F6C50169A2721AC8D2C29E3D")
    public double doubleValue() {
        double var1116C2BD9A20FF0A436A87C6D78A46AB_66269250 = ((double)get());
        double varE8CD7DA078A86726031AD64F35F5A6C0_893906630 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_893906630;
        // ---------- Original Method ----------
        //return (double)get();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.921 -0400", hash_original_field = "A728B10F96D7F4ED4992FCBBB5E85178", hash_generated_field = "94608409BBFB03FAAE871019E16E6D26")

    private static long serialVersionUID = 1927816293512124184L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.922 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

    private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.922 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.922 -0400", hash_original_field = "788B3E7EED350A570FBB205F360C85C4", hash_generated_field = "89ADEE6D8B9D22130A713AA2323D9533")

    static boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicLong.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

