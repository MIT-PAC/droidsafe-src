package sun.misc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import dalvik.system.VMStack;

import droidsafe.helpers.DSUtils;

public final class Unsafe {

    /**
     * Gets the unique instance of this class. This is only allowed in
     * very limited situations.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.644 -0500", hash_original_method = "74628BAB8E81DC2A00A81F4FA9A646FA", hash_generated_method = "30A6F9D65DD593CFCEB395F60D4C296F")
    
public static Unsafe getUnsafe() {
        /*
         * Only code on the bootclasspath is allowed to get at the
         * Unsafe instance.
         */
        ClassLoader calling = VMStack.getCallingClassLoader();
        if ((calling != null) && (calling != Unsafe.class.getClassLoader())) {
            throw new SecurityException("Unsafe access denied");
        }

        return THE_ONE;
    }
    
    private static long objectFieldOffset0(Field field) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1351189090 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1351189090;
    }
    
    private static int arrayBaseOffset0(Class clazz) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809733368 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809733368;
    }
    
    private static int arrayIndexScale0(Class clazz) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_714713006 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_714713006;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.639 -0500", hash_original_field = "3083DF6B0AC55CB3E662F95128363160", hash_generated_field = "0E67CDB95370A302579A19EADA2AF913")

    private static final Unsafe THE_ONE = new Unsafe();

    /**
     * This class is only privately instantiable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.641 -0500", hash_original_method = "50D30E2F10A8434CB2B5A99A7DA391C8", hash_generated_method = "2F1337A71CFB2F9405F3B53E4913683F")
    
private Unsafe() {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.181 -0400", hash_original_method = "826DF3AF2C82C95E7B53BC94C24540AA", hash_generated_method = "37509F27C578466D3CFFA3A1C5C8873A")
	
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

    /**
     * Gets the offset from the start of an array object's memory to
     * the memory used to store its initial (zeroeth) element.
     *
     * @param clazz non-null; class in question; must be an array class
     * @return the offset to the initial element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.653 -0500", hash_original_method = "10321221A26E92770863061AD8298BFF", hash_generated_method = "21FF5C484FE100BB69779AEC51F0555A")
    
public int arrayBaseOffset(Class clazz) {
        if (! clazz.isArray()) {
            throw new IllegalArgumentException(
                    "valid for array classes only");
        }

        return arrayBaseOffset0(clazz);
    }

    /**
     * Gets the size of each element of the given array class.
     *
     * @param clazz non-null; class in question; must be an array class
     * @return &gt; 0; the size of each element of the array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.660 -0500", hash_original_method = "756FA93315C90771D6287C6D6A8351D6", hash_generated_method = "CDE772B6CFD8340682662727579B3186")
    
public int arrayIndexScale(Class clazz) {
        if (! clazz.isArray()) {
            throw new IllegalArgumentException(
                    "valid for array classes only");
        }

        return arrayIndexScale0(clazz);
    }

    /**
     * Performs a compare-and-set operation on an <code>int</code>
     * field within the given object.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @param expectedValue expected value of the field
     * @param newValue new value to store in the field if the contents are
     * as expected
     * @return <code>true</code> if the new value was in fact stored, and
     * <code>false</code> if not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.668 -0500", hash_original_method = "21E4F9CF99012374BBDA74248C46C8FD", hash_generated_method = "F52D965F6E1100A7ECA10658FD304EEB")
    
    public boolean compareAndSwapInt(Object obj, long offset,
                int expectedValue, int newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(expectedValue);
    	addTaint(newValue);
    	return getTaintBoolean();
    }

    /**
     * Performs a compare-and-set operation on a <code>long</code>
     * field within the given object.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @param expectedValue expected value of the field
     * @param newValue new value to store in the field if the contents are
     * as expected
     * @return <code>true</code> if the new value was in fact stored, and
     * <code>false</code> if not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.671 -0500", hash_original_method = "B07F728E6C3379FC842B1FF2090A16B1", hash_generated_method = "7EF789BE4059D8CBDBA2172C20567316")
    
    public boolean compareAndSwapLong(Object obj, long offset,
                long expectedValue, long newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(expectedValue);
    	addTaint(newValue);
    	return getTaintBoolean();
    }

    /**
     * Performs a compare-and-set operation on an <code>Object</code>
     * field (that is, a reference field) within the given object.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @param expectedValue expected value of the field
     * @param newValue new value to store in the field if the contents are
     * as expected
     * @return <code>true</code> if the new value was in fact stored, and
     * <code>false</code> if not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.676 -0500", hash_original_method = "65A652B3AC9F111924C01101653C4D66", hash_generated_method = "0EE7ED6404FE8D24CA7413689180FCE4")
    
    public boolean compareAndSwapObject(Object obj, long offset,
                Object expectedValue, Object newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(expectedValue.getTaint());
    	addTaint(newValue.getTaint());
    	return getTaintBoolean();
    }

    /**
     * Gets an <code>int</code> field from the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @return the retrieved value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.680 -0500", hash_original_method = "8D5B44DDE927FC459CE77FA18575E830", hash_generated_method = "05B53DF9AC4A3FB25D739D70D4562DD6")
    
    public int getIntVolatile(Object obj, long offset){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	return getTaintInt();
    }

    /**
     * Stores an <code>int</code> field into the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.685 -0500", hash_original_method = "2D478903B4854FFA78FE99D55B867EDA", hash_generated_method = "EA603BC6523DC48076D975D7E331D47A")
    
    public void putIntVolatile(Object obj, long offset, int newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(newValue);
    }

    /**
     * Gets a <code>long</code> field from the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @return the retrieved value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.689 -0500", hash_original_method = "5D356F9FCB64558B37245C6E5D455D6F", hash_generated_method = "DD9AAAA6A6901D3B1BF7169A69B450CE")
    
    public long getLongVolatile(Object obj, long offset){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	return getTaintLong();
    }

    /**
     * Stores a <code>long</code> field into the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.692 -0500", hash_original_method = "5AB3D5DDF9043F3DC91C224AABAA6528", hash_generated_method = "B84E80F32CA5E1A40C69811D219D6F0B")
    
    public void putLongVolatile(Object obj, long offset, long newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(newValue);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.175 -0400", hash_original_method = "7F65AB78F7829D174777BA98D685A0A2", hash_generated_method = "8389F48CA8228ADA469FDA17F26377FB")
    public Object getObjectVolatile(Object obj, long offset) {
    	Object ret = new Object();
    	ret.addTaint(obj.taint);
    	ret.addTaint(offset);
    	return ret;
    }

    /**
     * Stores an <code>Object</code> field into the given object,
     * using <code>volatile</code> semantics.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.700 -0500", hash_original_method = "F4C73687B1C91E2A955A746EFDA19758", hash_generated_method = "227E65840F13ECA3AF63A799DD3D7DAE")
    
    public void putObjectVolatile(Object obj, long offset,
                Object newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(newValue.getTaint());
    }

    /**
     * Gets an <code>int</code> field from the given object.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @return the retrieved value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.704 -0500", hash_original_method = "F04350E1B41BC327004009309A9820C4", hash_generated_method = "3C5697B91BCA081D687B296EC98D9526")
    
    public int getInt(Object obj, long offset){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	return getTaintInt();
    }

    /**
     * Stores an <code>int</code> field into the given object.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.708 -0500", hash_original_method = "CE446F803EECC7090C6DE85B5F9727FB", hash_generated_method = "AF21A17310CA7F1044EE1D1E67407DAF")
    
    public void putInt(Object obj, long offset, int newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(newValue);
    }

    /**
     * Lazy set an int field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.712 -0500", hash_original_method = "0F4EEADE82300C8A6D47BB66B25081FB", hash_generated_method = "8BD20D20C111F116C74FE2BEC9C70CE7")
    
    public void putOrderedInt(Object obj, long offset, int newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(newValue);
    }

    /**
     * Gets a <code>long</code> field from the given object.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @return the retrieved value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.716 -0500", hash_original_method = "A62D16CF4622F3468767ED41FD0C48D8", hash_generated_method = "88B06931B1F78A34FF38BF6A52765A14")
    
    public long getLong(Object obj, long offset){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	return getTaintLong();
    }

    /**
     * Stores a <code>long</code> field into the given object.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.720 -0500", hash_original_method = "031A6C224714E986F8A4D8A9D45D73DD", hash_generated_method = "09C2D1DA5C1DB7B38217D202F2266334")
    
    public void putLong(Object obj, long offset, long newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(newValue);
    }

    /**
     * Lazy set a long field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.724 -0500", hash_original_method = "30A8F8DBA968E18C841B02CD11CE8C50", hash_generated_method = "71EB813BACFDC83CCEBD8930717855F8")
    
    public void putOrderedLong(Object obj, long offset, long newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(newValue);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.178 -0400", hash_original_method = "F008619F8920F7BD7FA02EADD68A4977", hash_generated_method = "67D30353ADFDF0D1EFF7C8039039B89C")
    public Object getObject(Object obj, long offset) {
    	Object ret = new Object();
    	ret.addTaint(obj.taint);
    	ret.addTaint(offset);
    	return ret;
    }

    /**
     * Stores an <code>Object</code> field into the given object.
     *
     * @param obj non-null; object containing the field
     * @param offset offset to the field within <code>obj</code>
     * @param newValue the value to store
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.733 -0500", hash_original_method = "C5B0C5B313647A39681E22F983DB9828", hash_generated_method = "58757AFE6786E8A6C71221B8B7FF1FBC")
    
    public void putObject(Object obj, long offset, Object newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(newValue.getTaint());
    }

    /**
     * Lazy set an object field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.737 -0500", hash_original_method = "330A73F0EAD671011DED9E5367E246F7", hash_generated_method = "08442279C7929933560AB28665CE4C86")
    
    public void putOrderedObject(Object obj, long offset,
                Object newValue){
    	//Formerly a native method
    	addTaint(obj.getTaint());
    	addTaint(offset);
    	addTaint(newValue.getTaint());
    }

    /**
     * Parks the calling thread for the specified amount of time,
     * unless the "permit" for the thread is already available (due to
     * a previous call to {@link #unpark}. This method may also return
     * spuriously (that is, without the thread being told to unpark
     * and without the indicated amount of time elapsing).
     *
     * <p>See {@link java.util.concurrent.locks.LockSupport} for more
     * in-depth information of the behavior of this method.</p>
     *
     * @param absolute whether the given time value is absolute
     * milliseconds-since-the-epoch (<code>true</code>) or relative
     * nanoseconds-from-now (<code>false</code>)
     * @param time the (absolute millis or relative nanos) time value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.739 -0500", hash_original_method = "A0416E5885795BAB8716EF22A6E96095", hash_generated_method = "BCC6DA0B677C50C73234B16C2E03374C")
    
public void park(boolean absolute, long time) {
        if (absolute) {
            Thread.currentThread().parkUntil(time);
        } else {
            Thread.currentThread().parkFor(time);
        }
    }

    /**
     * Unparks the given object, which must be a {@link Thread}.
     *
     * <p>See {@link java.util.concurrent.locks.LockSupport} for more
     * in-depth information of the behavior of this method.</p>
     *
     * @param obj non-null; the object to unpark
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.741 -0500", hash_original_method = "D722FA56AE20F33E2A3A13A64FA43CE8", hash_generated_method = "8157480CBC445615D2CEC44C5420F670")
    
public void unpark(Object obj) {
        if (obj instanceof Thread) {
            ((Thread) obj).unpark();
        } else {
            throw new IllegalArgumentException("valid for Threads only");
        }
    }
}

