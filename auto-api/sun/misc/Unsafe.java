package sun.misc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.VMStack;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class Unsafe {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.463 -0400", hash_original_method = "50D30E2F10A8434CB2B5A99A7DA391C8", hash_generated_method = "9AEC98E2560FBA06F6783E528E234F06")
    private  Unsafe() {
        // ---------- Original Method ----------
    }

    
        public static Unsafe getUnsafe() {
        ClassLoader calling = VMStack.getCallingClassLoader();
        if ((calling != null) && (calling != Unsafe.class.getClassLoader())) {
            throw new SecurityException("Unsafe access denied");
        }
        return THE_ONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.471 -0400", hash_original_method = "826DF3AF2C82C95E7B53BC94C24540AA", hash_generated_method = "962A0690B42DD79F37A2BBCEF7A307CF")
    public long objectFieldOffset(Field field) {
        {
            boolean var6D6410B32A8AF2AF719495B13A816AFF_732879253 = (Modifier.isStatic(field.getModifiers()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "valid for instance fields only");
            } //End block
        } //End collapsed parenthetic
        long varF618A6581E5B73EC310714FA10048689_2066890992 = (objectFieldOffset0(field));
        addTaint(field.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1404906401 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1404906401;
        // ---------- Original Method ----------
        //if (Modifier.isStatic(field.getModifiers())) {
            //throw new IllegalArgumentException(
                    //"valid for instance fields only");
        //}
        //return objectFieldOffset0(field);
    }

    
        private static long objectFieldOffset0(Field field) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.472 -0400", hash_original_method = "10321221A26E92770863061AD8298BFF", hash_generated_method = "818289B917FC2AFC0564864D2320D8C4")
    public int arrayBaseOffset(Class clazz) {
        {
            boolean var3D1789193661122A2444349AE4A18255_1871787481 = (! clazz.isArray());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "valid for array classes only");
            } //End block
        } //End collapsed parenthetic
        int var51BA33DDEF15B63037397AC859BD0CAF_672134211 = (arrayBaseOffset0(clazz));
        addTaint(clazz.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241896254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241896254;
        // ---------- Original Method ----------
        //if (! clazz.isArray()) {
            //throw new IllegalArgumentException(
                    //"valid for array classes only");
        //}
        //return arrayBaseOffset0(clazz);
    }

    
        private static int arrayBaseOffset0(Class clazz) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.473 -0400", hash_original_method = "756FA93315C90771D6287C6D6A8351D6", hash_generated_method = "64F5E5C18A1295A6C4F3455D4C0FB1D5")
    public int arrayIndexScale(Class clazz) {
        {
            boolean var3D1789193661122A2444349AE4A18255_1928640714 = (! clazz.isArray());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "valid for array classes only");
            } //End block
        } //End collapsed parenthetic
        int varEFFA4979ED3F7A2DCA88FBA7982BACDE_1657925119 = (arrayIndexScale0(clazz));
        addTaint(clazz.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489464681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489464681;
        // ---------- Original Method ----------
        //if (! clazz.isArray()) {
            //throw new IllegalArgumentException(
                    //"valid for array classes only");
        //}
        //return arrayIndexScale0(clazz);
    }

    
        private static int arrayIndexScale0(Class clazz) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.480 -0400", hash_original_method = "21E4F9CF99012374BBDA74248C46C8FD", hash_generated_method = "357DBE8175AD6CEAE4664181643D64E6")
    public boolean compareAndSwapInt(Object obj, long offset,
            int expectedValue, int newValue) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1001582326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1001582326;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.480 -0400", hash_original_method = "B07F728E6C3379FC842B1FF2090A16B1", hash_generated_method = "316C071782892A490B018BDD57972396")
    public boolean compareAndSwapLong(Object obj, long offset,
            long expectedValue, long newValue) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775727068 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775727068;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.481 -0400", hash_original_method = "65A652B3AC9F111924C01101653C4D66", hash_generated_method = "13C97E8422229CBAD05B058FEC0FC704")
    public boolean compareAndSwapObject(Object obj, long offset,
            Object expectedValue, Object newValue) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1142989351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1142989351;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.481 -0400", hash_original_method = "8D5B44DDE927FC459CE77FA18575E830", hash_generated_method = "C267E9DE6D15FCED365DEEE166D99618")
    public int getIntVolatile(Object obj, long offset) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879703264 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879703264;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.482 -0400", hash_original_method = "2D478903B4854FFA78FE99D55B867EDA", hash_generated_method = "5A5E24E1D36AF1AB6E4BBDC6B10717DF")
    public void putIntVolatile(Object obj, long offset, int newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.482 -0400", hash_original_method = "5D356F9FCB64558B37245C6E5D455D6F", hash_generated_method = "0CFC8A3C97886AB9189F5FD8E2604E43")
    public long getLongVolatile(Object obj, long offset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_436809821 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_436809821;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.482 -0400", hash_original_method = "5AB3D5DDF9043F3DC91C224AABAA6528", hash_generated_method = "F779406BA272DE63DFCD9F9456703DC2")
    public void putLongVolatile(Object obj, long offset, long newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.482 -0400", hash_original_method = "7F65AB78F7829D174777BA98D685A0A2", hash_generated_method = "8389F48CA8228ADA469FDA17F26377FB")
    public Object getObjectVolatile(Object obj, long offset) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.487 -0400", hash_original_method = "F4C73687B1C91E2A955A746EFDA19758", hash_generated_method = "5A0B5DBAE41FE072547CFB28260C499A")
    public void putObjectVolatile(Object obj, long offset,
            Object newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.487 -0400", hash_original_method = "F04350E1B41BC327004009309A9820C4", hash_generated_method = "FB4A19E77063831B46BCC85BF5C6F41A")
    public int getInt(Object obj, long offset) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1160342602 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1160342602;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.487 -0400", hash_original_method = "CE446F803EECC7090C6DE85B5F9727FB", hash_generated_method = "D6A2F62C2C1BEFFAF33584D8AF4A96C3")
    public void putInt(Object obj, long offset, int newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.487 -0400", hash_original_method = "0F4EEADE82300C8A6D47BB66B25081FB", hash_generated_method = "1206522AD3C7C4CB5DC01B9D266A77C9")
    public void putOrderedInt(Object obj, long offset, int newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.492 -0400", hash_original_method = "A62D16CF4622F3468767ED41FD0C48D8", hash_generated_method = "5EBEDFB9B95A0E3FC0A5330693163B04")
    public long getLong(Object obj, long offset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1089731809 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1089731809;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.492 -0400", hash_original_method = "031A6C224714E986F8A4D8A9D45D73DD", hash_generated_method = "AD33BF0F17190F26448FE3ED4C4CF324")
    public void putLong(Object obj, long offset, long newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.497 -0400", hash_original_method = "30A8F8DBA968E18C841B02CD11CE8C50", hash_generated_method = "91EABAB09EB9D3ADBE0B5D1A6698F365")
    public void putOrderedLong(Object obj, long offset, long newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.497 -0400", hash_original_method = "F008619F8920F7BD7FA02EADD68A4977", hash_generated_method = "67D30353ADFDF0D1EFF7C8039039B89C")
    public Object getObject(Object obj, long offset) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.498 -0400", hash_original_method = "C5B0C5B313647A39681E22F983DB9828", hash_generated_method = "0A515CB915F09C93D4FF711A1C549C7D")
    public void putObject(Object obj, long offset, Object newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.498 -0400", hash_original_method = "330A73F0EAD671011DED9E5367E246F7", hash_generated_method = "2BB6AD037CDF25725E1A0D170E7F2C39")
    public void putOrderedObject(Object obj, long offset,
            Object newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.498 -0400", hash_original_method = "A0416E5885795BAB8716EF22A6E96095", hash_generated_method = "42CCC832139642815196D834F4D20DB0")
    public void park(boolean absolute, long time) {
        {
            Thread.currentThread().parkUntil(time);
        } //End block
        {
            Thread.currentThread().parkFor(time);
        } //End block
        addTaint(absolute);
        addTaint(time);
        // ---------- Original Method ----------
        //if (absolute) {
            //Thread.currentThread().parkUntil(time);
        //} else {
            //Thread.currentThread().parkFor(time);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.499 -0400", hash_original_method = "D722FA56AE20F33E2A3A13A64FA43CE8", hash_generated_method = "0FF76099A02E726D0A4450BE6EFB56C8")
    public void unpark(Object obj) {
        {
            ((Thread) obj).unpark();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("valid for Threads only");
        } //End block
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //if (obj instanceof Thread) {
            //((Thread) obj).unpark();
        //} else {
            //throw new IllegalArgumentException("valid for Threads only");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.499 -0400", hash_original_field = "8375C19453A8245980AC5B9E389C5C81", hash_generated_field = "3933BF50FCBB476CD735F84B0CF7CA7F")

    private static Unsafe THE_ONE = new Unsafe();
}

