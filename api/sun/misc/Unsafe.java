package sun.misc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.VMStack;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class Unsafe {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.179 -0400", hash_original_method = "50D30E2F10A8434CB2B5A99A7DA391C8", hash_generated_method = "9AEC98E2560FBA06F6783E528E234F06")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.181 -0400", hash_original_method = "826DF3AF2C82C95E7B53BC94C24540AA", hash_generated_method = "37509F27C578466D3CFFA3A1C5C8873A")
    public long objectFieldOffset(Field field) {
        addTaint(field.getTaint());
    if(Modifier.isStatic(field.getModifiers()))        
        {
            IllegalArgumentException var9647A65078523FC9A06312AFCF421504_303715825 = new IllegalArgumentException(
                    "valid for instance fields only");
            var9647A65078523FC9A06312AFCF421504_303715825.addTaint(taint);
            throw var9647A65078523FC9A06312AFCF421504_303715825;
        } //End block
        long var45155EBB460CF1A21C43208975B41A88_1937978599 = (objectFieldOffset0(field));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1705333896 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1705333896;
        // ---------- Original Method ----------
        //if (Modifier.isStatic(field.getModifiers())) {
            //throw new IllegalArgumentException(
                    //"valid for instance fields only");
        //}
        //return objectFieldOffset0(field);
    }

    
    @DSModeled(DSC.SAFE)
    private static long objectFieldOffset0(Field field) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1351189090 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1351189090;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.183 -0400", hash_original_method = "10321221A26E92770863061AD8298BFF", hash_generated_method = "8240821A16CB48479E2F26C926D201D9")
    public int arrayBaseOffset(Class clazz) {
        addTaint(clazz.getTaint());
    if(! clazz.isArray())        
        {
            IllegalArgumentException var278D5518DEF9BA52DD0FD9A2E1081376_1133080243 = new IllegalArgumentException(
                    "valid for array classes only");
            var278D5518DEF9BA52DD0FD9A2E1081376_1133080243.addTaint(taint);
            throw var278D5518DEF9BA52DD0FD9A2E1081376_1133080243;
        } //End block
        int var7C5976EF3F0F633CB85C258B287BA249_1210809856 = (arrayBaseOffset0(clazz));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1551865008 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1551865008;
        // ---------- Original Method ----------
        //if (! clazz.isArray()) {
            //throw new IllegalArgumentException(
                    //"valid for array classes only");
        //}
        //return arrayBaseOffset0(clazz);
    }

    
    @DSModeled(DSC.SAFE)
    private static int arrayBaseOffset0(Class clazz) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809733368 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809733368;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.183 -0400", hash_original_method = "756FA93315C90771D6287C6D6A8351D6", hash_generated_method = "378B29CB2F2E701BF128F66129108119")
    public int arrayIndexScale(Class clazz) {
        addTaint(clazz.getTaint());
    if(! clazz.isArray())        
        {
            IllegalArgumentException var278D5518DEF9BA52DD0FD9A2E1081376_1549054430 = new IllegalArgumentException(
                    "valid for array classes only");
            var278D5518DEF9BA52DD0FD9A2E1081376_1549054430.addTaint(taint);
            throw var278D5518DEF9BA52DD0FD9A2E1081376_1549054430;
        } //End block
        int var5EE94361AC68F81834EA41B3943D5754_101739419 = (arrayIndexScale0(clazz));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_555242951 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_555242951;
        // ---------- Original Method ----------
        //if (! clazz.isArray()) {
            //throw new IllegalArgumentException(
                    //"valid for array classes only");
        //}
        //return arrayIndexScale0(clazz);
    }

    
    @DSModeled(DSC.SAFE)
    private static int arrayIndexScale0(Class clazz) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_714713006 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_714713006;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.184 -0400", hash_original_method = "21E4F9CF99012374BBDA74248C46C8FD", hash_generated_method = "861E8D81E32552449BACBD1DC2DC5566")
    public boolean compareAndSwapInt(Object obj, long offset,
            int expectedValue, int newValue) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_831725381 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_831725381;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.184 -0400", hash_original_method = "B07F728E6C3379FC842B1FF2090A16B1", hash_generated_method = "21B1DB3192A6B8B9EBF277CB675C6446")
    public boolean compareAndSwapLong(Object obj, long offset,
            long expectedValue, long newValue) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_674175540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_674175540;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.185 -0400", hash_original_method = "65A652B3AC9F111924C01101653C4D66", hash_generated_method = "0084339C9CBA8216BF037DA4548353C8")
    public boolean compareAndSwapObject(Object obj, long offset,
            Object expectedValue, Object newValue) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497770063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_497770063;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.185 -0400", hash_original_method = "8D5B44DDE927FC459CE77FA18575E830", hash_generated_method = "1000B02C32D87B63B15CF5D8C20991F0")
    public int getIntVolatile(Object obj, long offset) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848537927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848537927;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.185 -0400", hash_original_method = "2D478903B4854FFA78FE99D55B867EDA", hash_generated_method = "5A5E24E1D36AF1AB6E4BBDC6B10717DF")
    public void putIntVolatile(Object obj, long offset, int newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.185 -0400", hash_original_method = "5D356F9FCB64558B37245C6E5D455D6F", hash_generated_method = "52E79CA71CA7F8BCC377F19D85187A6E")
    public long getLongVolatile(Object obj, long offset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1391947139 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1391947139;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.186 -0400", hash_original_method = "5AB3D5DDF9043F3DC91C224AABAA6528", hash_generated_method = "F779406BA272DE63DFCD9F9456703DC2")
    public void putLongVolatile(Object obj, long offset, long newValue) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.175 -0400", hash_original_method = "7F65AB78F7829D174777BA98D685A0A2", hash_generated_method = "8389F48CA8228ADA469FDA17F26377FB")
    public Object getObjectVolatile(Object obj, long offset) {
    	Object ret = new Object();
    	ret.addTaint(obj.taint);
    	ret.addTaint(offset);
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.186 -0400", hash_original_method = "F4C73687B1C91E2A955A746EFDA19758", hash_generated_method = "5A0B5DBAE41FE072547CFB28260C499A")
    public void putObjectVolatile(Object obj, long offset,
            Object newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.186 -0400", hash_original_method = "F04350E1B41BC327004009309A9820C4", hash_generated_method = "059C89F9D982B114A635430C993C11BE")
    public int getInt(Object obj, long offset) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627444349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627444349;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.187 -0400", hash_original_method = "CE446F803EECC7090C6DE85B5F9727FB", hash_generated_method = "D6A2F62C2C1BEFFAF33584D8AF4A96C3")
    public void putInt(Object obj, long offset, int newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.187 -0400", hash_original_method = "0F4EEADE82300C8A6D47BB66B25081FB", hash_generated_method = "1206522AD3C7C4CB5DC01B9D266A77C9")
    public void putOrderedInt(Object obj, long offset, int newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.203 -0400", hash_original_method = "A62D16CF4622F3468767ED41FD0C48D8", hash_generated_method = "20A4150E675E42C8C6318F77CE964FE7")
    public long getLong(Object obj, long offset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1987256066 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1987256066;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.203 -0400", hash_original_method = "031A6C224714E986F8A4D8A9D45D73DD", hash_generated_method = "AD33BF0F17190F26448FE3ED4C4CF324")
    public void putLong(Object obj, long offset, long newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.204 -0400", hash_original_method = "30A8F8DBA968E18C841B02CD11CE8C50", hash_generated_method = "91EABAB09EB9D3ADBE0B5D1A6698F365")
    public void putOrderedLong(Object obj, long offset, long newValue) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.178 -0400", hash_original_method = "F008619F8920F7BD7FA02EADD68A4977", hash_generated_method = "67D30353ADFDF0D1EFF7C8039039B89C")
    public Object getObject(Object obj, long offset) {
    	Object ret = new Object();
    	ret.addTaint(obj.taint);
    	ret.addTaint(offset);
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.204 -0400", hash_original_method = "C5B0C5B313647A39681E22F983DB9828", hash_generated_method = "0A515CB915F09C93D4FF711A1C549C7D")
    public void putObject(Object obj, long offset, Object newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.205 -0400", hash_original_method = "330A73F0EAD671011DED9E5367E246F7", hash_generated_method = "2BB6AD037CDF25725E1A0D170E7F2C39")
    public void putOrderedObject(Object obj, long offset,
            Object newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.205 -0400", hash_original_method = "A0416E5885795BAB8716EF22A6E96095", hash_generated_method = "49C10995BAFC92B667347C7E071D4DD9")
    public void park(boolean absolute, long time) {
        addTaint(time);
        addTaint(absolute);
    if(absolute)        
        {
            Thread.currentThread().parkUntil(time);
        } //End block
        else
        {
            Thread.currentThread().parkFor(time);
        } //End block
        // ---------- Original Method ----------
        //if (absolute) {
            //Thread.currentThread().parkUntil(time);
        //} else {
            //Thread.currentThread().parkFor(time);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.205 -0400", hash_original_method = "D722FA56AE20F33E2A3A13A64FA43CE8", hash_generated_method = "61FF84DC5CB43AE1B48E000BF1C68DAA")
    public void unpark(Object obj) {
        addTaint(obj.getTaint());
    if(obj instanceof Thread)        
        {
            ((Thread) obj).unpark();
        } //End block
        else
        {
            IllegalArgumentException varDADAC6841369B4979C3407B75F50C492_883352435 = new IllegalArgumentException("valid for Threads only");
            varDADAC6841369B4979C3407B75F50C492_883352435.addTaint(taint);
            throw varDADAC6841369B4979C3407B75F50C492_883352435;
        } //End block
        // ---------- Original Method ----------
        //if (obj instanceof Thread) {
            //((Thread) obj).unpark();
        //} else {
            //throw new IllegalArgumentException("valid for Threads only");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.205 -0400", hash_original_field = "8375C19453A8245980AC5B9E389C5C81", hash_generated_field = "0E67CDB95370A302579A19EADA2AF913")

    private static final Unsafe THE_ONE = new Unsafe();
}

