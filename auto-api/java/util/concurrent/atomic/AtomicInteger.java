package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicInteger extends Number implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.855 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "AACF1191CE0421BEFC63226B2561E15D")

    private volatile int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.856 -0400", hash_original_method = "A3EEEE607FBEBD432F4111F47BB23345", hash_generated_method = "C1B1444E172E49708F3A7562ABBF445D")
    public  AtomicInteger(int initialValue) {
        value = initialValue;
        // ---------- Original Method ----------
        //value = initialValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.856 -0400", hash_original_method = "3B74ED36698F9901BA50127D104C26DE", hash_generated_method = "3FC2676712951E4C0961989AC4A65B09")
    public  AtomicInteger() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.856 -0400", hash_original_method = "2C5A1089E8025181868581E48D922F38", hash_generated_method = "73AA797CB5789124C08A74DD9E5C68BA")
    public final int get() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632994934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632994934;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.856 -0400", hash_original_method = "E51FD8A91C159D9D3ED3BF52073569AD", hash_generated_method = "046E83718895B73384C8E1C3323B55FE")
    public final void set(int newValue) {
        value = newValue;
        // ---------- Original Method ----------
        //value = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.857 -0400", hash_original_method = "77EB9E59BE67AA43485FF3A0F0492CB7", hash_generated_method = "953B5CAC3CE05682D98FD3CDB8C68AF2")
    public final void lazySet(int newValue) {
        unsafe.putOrderedInt(this, valueOffset, newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedInt(this, valueOffset, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.857 -0400", hash_original_method = "EFF79965BA8CD7578F2A5616273687C7", hash_generated_method = "A6DB273A5654F84E39CCF545FFA89969")
    public final int getAndSet(int newValue) {
        {
            int current;
            current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_1993883603 = (compareAndSet(current, newValue));
            } //End collapsed parenthetic
        } //End block
        addTaint(newValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191915511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191915511;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //if (compareAndSet(current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.863 -0400", hash_original_method = "3CF6D7A3DD4EDBE8D1648E756B160F53", hash_generated_method = "8C88818FE60406626D72FFF6C1750C36")
    public final boolean compareAndSet(int expect, int update) {
        boolean varA219EEBEFD3FA4DCBF9D61615A3EEAA5_1262366423 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1508197606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1508197606;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.864 -0400", hash_original_method = "22EC2300FEC70C46ECF009D542FC9430", hash_generated_method = "F19219EBDE1B09805D42D9F0185593B2")
    public final boolean weakCompareAndSet(int expect, int update) {
        boolean varA219EEBEFD3FA4DCBF9D61615A3EEAA5_489793039 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_539464000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_539464000;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.864 -0400", hash_original_method = "621C33BC86CD3122044A53600F895B29", hash_generated_method = "F372143A89E4492AA7ED245073BB94E3")
    public final int getAndIncrement() {
        {
            int current;
            current = get();
            int next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_810423750 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2126953275 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2126953275;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.874 -0400", hash_original_method = "D5257E8A410056D1BB1DB7447390EAE5", hash_generated_method = "9279C615133C1AB3245A51E529022146")
    public final int getAndDecrement() {
        {
            int current;
            current = get();
            int next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_184549483 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434715876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434715876;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current - 1;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.874 -0400", hash_original_method = "4B803B85C89B0C062A735FA86D4518AE", hash_generated_method = "A5ACF773651FAD6005F170E27F66AFE9")
    public final int getAndAdd(int delta) {
        {
            int current;
            current = get();
            int next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_730177814 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(delta);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889253891 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889253891;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + delta;
            //if (compareAndSet(current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.875 -0400", hash_original_method = "6DC45C427ABFB1C3B7D74803EAAF22FF", hash_generated_method = "EC9860F8204781494F961355509B332C")
    public final int incrementAndGet() {
        {
            int current;
            current = get();
            int next;
            next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_953116093 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934609261 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934609261;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.875 -0400", hash_original_method = "4357F9DD6725F5F393683EE2EA89C677", hash_generated_method = "72A525F1E217A293E8E6CED84E4AB747")
    public final int decrementAndGet() {
        {
            int current;
            current = get();
            int next;
            next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1300256493 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420503546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420503546;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current - 1;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.884 -0400", hash_original_method = "5280B98EAB69F2A556138E3D06C4D0D3", hash_generated_method = "A197312913D230E727D4C4CD708424E0")
    public final int addAndGet(int delta) {
        {
            int current;
            current = get();
            int next;
            next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1070671148 = (compareAndSet(current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(delta);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_624816397 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_624816397;
        // ---------- Original Method ----------
        //for (;;) {
            //int current = get();
            //int next = current + delta;
            //if (compareAndSet(current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.884 -0400", hash_original_method = "0CBFF056CB46F189F8DC45AFB469D5F9", hash_generated_method = "4E16BF3C7EDDF7F3A4ECF8C7201F981E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2090472392 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2090472392 = Integer.toString(get());
        varB4EAC82CA7396A68D541C85D26508E83_2090472392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2090472392;
        // ---------- Original Method ----------
        //return Integer.toString(get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.884 -0400", hash_original_method = "B90EC926C8275C97256DF1E0AD9FC076", hash_generated_method = "B4C21A4C4CDCC6E8E36B75200B2D2A02")
    public int intValue() {
        int varA3899375788C01929C876C11142E44FF_1067869949 = (get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256440747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256440747;
        // ---------- Original Method ----------
        //return get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.885 -0400", hash_original_method = "41D936CCD9A9D16949AE3FD60738B8AD", hash_generated_method = "5C77E79B5A859078F58BE5B49AD5F90A")
    public long longValue() {
        long var3647B297BC29A3BA088BCA1543A8629B_1813385009 = ((long)get());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1091673256 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1091673256;
        // ---------- Original Method ----------
        //return (long)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.885 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "A7143798A9DC43E4D8949C0A83AC2DE3")
    public float floatValue() {
        float varACA887607DBB4E1678238A769AA68C60_1677324038 = ((float)get());
        float var546ADE640B6EDFBC8A086EF31347E768_1533219983 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1533219983;
        // ---------- Original Method ----------
        //return (float)get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.885 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "584584CA85BE247409C7D5D0605481A7")
    public double doubleValue() {
        double var1116C2BD9A20FF0A436A87C6D78A46AB_792889262 = ((double)get());
        double varE8CD7DA078A86726031AD64F35F5A6C0_1033260926 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1033260926;
        // ---------- Original Method ----------
        //return (double)get();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.885 -0400", hash_original_field = "B183F0A1B10C2484948F6B1EC8551E73", hash_generated_field = "03C5D5FE0DAF2C3219EF42FCAD949BBD")

    private static long serialVersionUID = 6214790243416807050L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.885 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

    private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.885 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicInteger.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

