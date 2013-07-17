package sun.misc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.VMStack;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class Unsafe {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.587 -0400", hash_original_method = "50D30E2F10A8434CB2B5A99A7DA391C8", hash_generated_method = "9AEC98E2560FBA06F6783E528E234F06")
    private  Unsafe() {
        // ---------- Original Method ----------
    }

    	@DSModeled(DSC.BAN)
        public static Unsafe getUnsafe() {
        ClassLoader calling = VMStack.getCallingClassLoader();
        if ((calling != null) && (calling != Unsafe.class.getClassLoader())) {
            throw new SecurityException("Unsafe access denied");
        }
        return THE_ONE;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.181 -0400", hash_original_method = "826DF3AF2C82C95E7B53BC94C24540AA", hash_generated_method = "37509F27C578466D3CFFA3A1C5C8873A")
	@DSModeled(DSC.BAN)
    public long objectFieldOffset(Field field) {
        addTaint(field.getTaint());
        if(Modifier.isStatic(field.getModifiers()))        
        {
            IllegalArgumentException var9647A65078523FC9A06312AFCF421504_59239873 = new IllegalArgumentException(
                    "valid for instance fields only");
            var9647A65078523FC9A06312AFCF421504_59239873.addTaint(taint);
            throw var9647A65078523FC9A06312AFCF421504_59239873;
        } //End block
        long var45155EBB460CF1A21C43208975B41A88_966943115 = (objectFieldOffset0(field));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_995281280 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_995281280;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.588 -0400", hash_original_method = "10321221A26E92770863061AD8298BFF", hash_generated_method = "849220CE57217FFE590A860A22135545")
    public int arrayBaseOffset(Class clazz) {
        addTaint(clazz.getTaint());
        if(! clazz.isArray())        
        {
            IllegalArgumentException var278D5518DEF9BA52DD0FD9A2E1081376_1478380312 = new IllegalArgumentException(
                    "valid for array classes only");
            var278D5518DEF9BA52DD0FD9A2E1081376_1478380312.addTaint(taint);
            throw var278D5518DEF9BA52DD0FD9A2E1081376_1478380312;
        } //End block
        int var7C5976EF3F0F633CB85C258B287BA249_1555856359 = (arrayBaseOffset0(clazz));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_781500563 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_781500563;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.589 -0400", hash_original_method = "756FA93315C90771D6287C6D6A8351D6", hash_generated_method = "F2FB41A0D615664D34B4AFB21A32AA4C")
    public int arrayIndexScale(Class clazz) {
        addTaint(clazz.getTaint());
        if(! clazz.isArray())        
        {
            IllegalArgumentException var278D5518DEF9BA52DD0FD9A2E1081376_1818655283 = new IllegalArgumentException(
                    "valid for array classes only");
            var278D5518DEF9BA52DD0FD9A2E1081376_1818655283.addTaint(taint);
            throw var278D5518DEF9BA52DD0FD9A2E1081376_1818655283;
        } //End block
        int var5EE94361AC68F81834EA41B3943D5754_1131993574 = (arrayIndexScale0(clazz));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175039633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175039633;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.590 -0400", hash_original_method = "21E4F9CF99012374BBDA74248C46C8FD", hash_generated_method = "CED7206554AB9DDA468A21B61E8A70F2")
    public boolean compareAndSwapInt(Object obj, long offset,
            int expectedValue, int newValue) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_594170875 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_594170875;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.590 -0400", hash_original_method = "B07F728E6C3379FC842B1FF2090A16B1", hash_generated_method = "D19331BC9AF6CCBF5B54557FBA2735F8")
    public boolean compareAndSwapLong(Object obj, long offset,
            long expectedValue, long newValue) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_76542481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_76542481;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.591 -0400", hash_original_method = "65A652B3AC9F111924C01101653C4D66", hash_generated_method = "605AC2BADBBAF8F4727F5FA3ABD7A687")
    public boolean compareAndSwapObject(Object obj, long offset,
            Object expectedValue, Object newValue) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1649963822 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1649963822;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.591 -0400", hash_original_method = "8D5B44DDE927FC459CE77FA18575E830", hash_generated_method = "D03838F10795B56B1242BD4CF58B7FAC")
    public int getIntVolatile(Object obj, long offset) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62952539 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62952539;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.591 -0400", hash_original_method = "2D478903B4854FFA78FE99D55B867EDA", hash_generated_method = "5A5E24E1D36AF1AB6E4BBDC6B10717DF")
    public void putIntVolatile(Object obj, long offset, int newValue) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.592 -0400", hash_original_method = "5D356F9FCB64558B37245C6E5D455D6F", hash_generated_method = "00FF1D23CDF7FABEBFBF7E8FDCB2E726")
    public long getLongVolatile(Object obj, long offset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_778223786 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_778223786;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.592 -0400", hash_original_method = "5AB3D5DDF9043F3DC91C224AABAA6528", hash_generated_method = "F779406BA272DE63DFCD9F9456703DC2")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.593 -0400", hash_original_method = "F4C73687B1C91E2A955A746EFDA19758", hash_generated_method = "5A0B5DBAE41FE072547CFB28260C499A")
    public void putObjectVolatile(Object obj, long offset,
            Object newValue) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.593 -0400", hash_original_method = "F04350E1B41BC327004009309A9820C4", hash_generated_method = "B1091452AE461605242E450A35001F94")
    public int getInt(Object obj, long offset) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_649367505 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_649367505;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.593 -0400", hash_original_method = "CE446F803EECC7090C6DE85B5F9727FB", hash_generated_method = "D6A2F62C2C1BEFFAF33584D8AF4A96C3")
    public void putInt(Object obj, long offset, int newValue) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.593 -0400", hash_original_method = "0F4EEADE82300C8A6D47BB66B25081FB", hash_generated_method = "1206522AD3C7C4CB5DC01B9D266A77C9")
    public void putOrderedInt(Object obj, long offset, int newValue) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.593 -0400", hash_original_method = "A62D16CF4622F3468767ED41FD0C48D8", hash_generated_method = "233FADAB6FB076DE23B8118AAD5F6612")
    public long getLong(Object obj, long offset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1167916645 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1167916645;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.593 -0400", hash_original_method = "031A6C224714E986F8A4D8A9D45D73DD", hash_generated_method = "AD33BF0F17190F26448FE3ED4C4CF324")
    public void putLong(Object obj, long offset, long newValue) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.593 -0400", hash_original_method = "30A8F8DBA968E18C841B02CD11CE8C50", hash_generated_method = "91EABAB09EB9D3ADBE0B5D1A6698F365")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.594 -0400", hash_original_method = "C5B0C5B313647A39681E22F983DB9828", hash_generated_method = "0A515CB915F09C93D4FF711A1C549C7D")
    public void putObject(Object obj, long offset, Object newValue) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.594 -0400", hash_original_method = "330A73F0EAD671011DED9E5367E246F7", hash_generated_method = "2BB6AD037CDF25725E1A0D170E7F2C39")
    public void putOrderedObject(Object obj, long offset,
            Object newValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.594 -0400", hash_original_method = "A0416E5885795BAB8716EF22A6E96095", hash_generated_method = "49C10995BAFC92B667347C7E071D4DD9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.595 -0400", hash_original_method = "D722FA56AE20F33E2A3A13A64FA43CE8", hash_generated_method = "8C6CB1263E59FCF4B7A4E28F1DE0B03C")
    public void unpark(Object obj) {
        addTaint(obj.getTaint());
        if(obj instanceof Thread)        
        {
            ((Thread) obj).unpark();
        } //End block
        else
        {
            IllegalArgumentException varDADAC6841369B4979C3407B75F50C492_176851680 = new IllegalArgumentException("valid for Threads only");
            varDADAC6841369B4979C3407B75F50C492_176851680.addTaint(taint);
            throw varDADAC6841369B4979C3407B75F50C492_176851680;
        } //End block
        // ---------- Original Method ----------
        //if (obj instanceof Thread) {
            //((Thread) obj).unpark();
        //} else {
            //throw new IllegalArgumentException("valid for Threads only");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.595 -0400", hash_original_field = "8375C19453A8245980AC5B9E389C5C81", hash_generated_field = "0E67CDB95370A302579A19EADA2AF913")

    private static final Unsafe THE_ONE = new Unsafe();
}

