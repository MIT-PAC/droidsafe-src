package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicInteger extends Number implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.761 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "AACF1191CE0421BEFC63226B2561E15D")

    private volatile int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.767 -0400", hash_original_method = "A3EEEE607FBEBD432F4111F47BB23345", hash_generated_method = "C1B1444E172E49708F3A7562ABBF445D")
    public  AtomicInteger(int initialValue) {
        value = initialValue;
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.767 -0400", hash_original_method = "3B74ED36698F9901BA50127D104C26DE", hash_generated_method = "3FC2676712951E4C0961989AC4A65B09")
    public  AtomicInteger() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.770 -0400", hash_original_method = "2C5A1089E8025181868581E48D922F38", hash_generated_method = "574BAE8008919019D38CB97589806481")
    public final int get() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824246991 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824246991;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.770 -0400", hash_original_method = "E51FD8A91C159D9D3ED3BF52073569AD", hash_generated_method = "046E83718895B73384C8E1C3323B55FE")
    public final void set(int newValue) {
        value = newValue;
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.770 -0400", hash_original_method = "77EB9E59BE67AA43485FF3A0F0492CB7", hash_generated_method = "953B5CAC3CE05682D98FD3CDB8C68AF2")
    public final void lazySet(int newValue) {
        unsafe.putOrderedInt(this, valueOffset, newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedInt(this, valueOffset, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.771 -0400", hash_original_method = "EFF79965BA8CD7578F2A5616273687C7", hash_generated_method = "FBFBE6AA300EE89DB7EE61C1E76EC4FE")
    public final int getAndSet(int newValue) {
        {
            int current;
            current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_365031373 = (compareAndSet(current, newValue));
            } //End collapsed parenthetic
        } //End block
        addTaint(newValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092416065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092416065;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //if (compareAndSet(current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.771 -0400", hash_original_method = "3CF6D7A3DD4EDBE8D1648E756B160F53", hash_generated_method = "3C5AA69EC67503CC60404022D91E7992")
    public final boolean compareAndSet(int expect, int update) {
        boolean varA219EEBEFD3FA4DCBF9D61615A3EEAA5_970851733 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1330242118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1330242118;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.771 -0400", hash_original_method = "22EC2300FEC70C46ECF009D542FC9430", hash_generated_method = "3503BC03B4721BA7682387CADD886BA7")
    public final boolean weakCompareAndSet(int expect, int update) {
        boolean varA219EEBEFD3FA4DCBF9D61615A3EEAA5_1331195040 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312745462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312745462;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.794 -0400", hash_original_method = "621C33BC86CD3122044A53600F895B29", hash_generated_method = "E8B72FDD3B733E41A28E776D5924CF40")
    public final int getAndIncrement() {
        {
            int current;
            current = get();
            int next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1000851803 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983246086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983246086;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.794 -0400", hash_original_method = "D5257E8A410056D1BB1DB7447390EAE5", hash_generated_method = "6092A076700A90A4DC05FB3E1875B82A")
    public final int getAndDecrement() {
        {
            int current;
            current = get();
            int next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1451721969 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52316962 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52316962;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current - 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.794 -0400", hash_original_method = "4B803B85C89B0C062A735FA86D4518AE", hash_generated_method = "9548F8F5122E621D962D5D37A9D9D66C")
    public final int getAndAdd(int delta) {
        {
            int current;
            current = get();
            int next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_836785802 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(delta);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1551017446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1551017446;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + delta;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.795 -0400", hash_original_method = "6DC45C427ABFB1C3B7D74803EAAF22FF", hash_generated_method = "4ECD96D188C49FD8FFBC916E36B28579")
    public final int incrementAndGet() {
        {
            int current;
            current = get();
            int next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1220400898 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69982850 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69982850;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.795 -0400", hash_original_method = "4357F9DD6725F5F393683EE2EA89C677", hash_generated_method = "A01AA60F6E9578B3871A0ED8B00D70E4")
    public final int decrementAndGet() {
        {
            int current;
            current = get();
            int next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1935451762 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509508288 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509508288;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current - 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.799 -0400", hash_original_method = "5280B98EAB69F2A556138E3D06C4D0D3", hash_generated_method = "97850C73B37FB41031467ACA31E67676")
    public final int addAndGet(int delta) {
        {
            int current;
            current = get();
            int next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_185174417 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(delta);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41770128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41770128;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + delta;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.800 -0400", hash_original_method = "0CBFF056CB46F189F8DC45AFB469D5F9", hash_generated_method = "BE051B4755BD342F87DC125898A5829D")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_970576877 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_970576877 = Integer.toString(get());
        varB4EAC82CA7396A68D541C85D26508E83_970576877.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_970576877;
        // ---------- Original Method ----------
        //return Integer.toString(get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.800 -0400", hash_original_method = "B90EC926C8275C97256DF1E0AD9FC076", hash_generated_method = "2E4D3A3B2E296B2741864D3092707D48")
    public int intValue() {
        int varA3899375788C01929C876C11142E44FF_216387028 = (get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565555749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565555749;
        // ---------- Original Method ----------
        //return get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.801 -0400", hash_original_method = "41D936CCD9A9D16949AE3FD60738B8AD", hash_generated_method = "574C335C7F76757E0797FFA23500CB7F")
    public long longValue() {
        long var3647B297BC29A3BA088BCA1543A8629B_1211398890 = ((long)get());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1785334979 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1785334979;
        // ---------- Original Method ----------
        //return (long)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.801 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "D4D4CD913D91599F911C22B8E72730E3")
    public float floatValue() {
        float varACA887607DBB4E1678238A769AA68C60_922278577 = ((float)get());
        float var546ADE640B6EDFBC8A086EF31347E768_1537607995 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1537607995;
        // ---------- Original Method ----------
        //return (float)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.801 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "DB99184BB2D36620DBDD94DF1BD8D744")
    public double doubleValue() {
        double var1116C2BD9A20FF0A436A87C6D78A46AB_2068764068 = ((double)get());
        double varE8CD7DA078A86726031AD64F35F5A6C0_139230255 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_139230255;
        // ---------- Original Method ----------
        //return (double)get();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.801 -0400", hash_original_field = "B183F0A1B10C2484948F6B1EC8551E73", hash_generated_field = "03C5D5FE0DAF2C3219EF42FCAD949BBD")

    private static long serialVersionUID = 6214790243416807050L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.801 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

    private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.801 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicInteger.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

