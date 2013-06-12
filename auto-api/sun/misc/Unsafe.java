package sun.misc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import dalvik.system.VMStack;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class Unsafe {
    private static final Unsafe THE_ONE = new Unsafe();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "50D30E2F10A8434CB2B5A99A7DA391C8", hash_generated_method = "5595564C7B9040FC660454C422738A34")
    @DSModeled(DSC.SAFE)
    private Unsafe() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "74628BAB8E81DC2A00A81F4FA9A646FA", hash_generated_method = "FDE7EE23629FF87F4F0B3A4412753110")
    public static Unsafe getUnsafe() {
        ClassLoader calling = VMStack.getCallingClassLoader();
        if ((calling != null) && (calling != Unsafe.class.getClassLoader())) {
            throw new SecurityException("Unsafe access denied");
        }
        return THE_ONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "826DF3AF2C82C95E7B53BC94C24540AA", hash_generated_method = "7C3D9742684D51C551C6E3D2E9C14C0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long objectFieldOffset(Field field) {
        dsTaint.addTaint(field.dsTaint);
        {
            boolean var6D6410B32A8AF2AF719495B13A816AFF_2047787966 = (Modifier.isStatic(field.getModifiers()));
            {
            	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "valid for instance fields only");
            } //End block
        } //End collapsed parenthetic
        long varF618A6581E5B73EC310714FA10048689_2052920734 = (objectFieldOffset0(field));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (Modifier.isStatic(field.getModifiers())) {
            //throw new IllegalArgumentException(
                    //"valid for instance fields only");
        //}
        //return objectFieldOffset0(field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "0B0EC3B0C998BC003C9368B59FE24631", hash_generated_method = "0D57A05E1FF56862A7FD2B75516174C1")
    private static long objectFieldOffset0(Field field) {
    	return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "10321221A26E92770863061AD8298BFF", hash_generated_method = "79D64518F80AAB9E82C45DB16878A59D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int arrayBaseOffset(Class clazz) {
        dsTaint.addTaint(clazz.dsTaint);
        {
            boolean var3D1789193661122A2444349AE4A18255_1106508762 = (! clazz.isArray());
            {
            	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "valid for array classes only");
            } //End block
        } //End collapsed parenthetic
        int var51BA33DDEF15B63037397AC859BD0CAF_961411430 = (arrayBaseOffset0(clazz));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (! clazz.isArray()) {
            //throw new IllegalArgumentException(
                    //"valid for array classes only");
        //}
        //return arrayBaseOffset0(clazz);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "55B49997B1676D657B6C8E6518D73AA0", hash_generated_method = "4327CC9876F3EE19568663EAA7A4AD5D")
    private static int arrayBaseOffset0(Class clazz) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "756FA93315C90771D6287C6D6A8351D6", hash_generated_method = "6A9938C3D41F11C9E8B8865B920F56FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int arrayIndexScale(Class clazz) {
        dsTaint.addTaint(clazz.dsTaint);
        {
            boolean var3D1789193661122A2444349AE4A18255_457809424 = (! clazz.isArray());
            {
            	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "valid for array classes only");
            } //End block
        } //End collapsed parenthetic
        int varEFFA4979ED3F7A2DCA88FBA7982BACDE_605793270 = (arrayIndexScale0(clazz));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (! clazz.isArray()) {
            //throw new IllegalArgumentException(
                    //"valid for array classes only");
        //}
        //return arrayIndexScale0(clazz);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "0837396E34F6D189794014013C105951", hash_generated_method = "E0F258589BA8DCC80056ECA469DDF8F5")
    private static int arrayIndexScale0(Class clazz) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "21E4F9CF99012374BBDA74248C46C8FD", hash_generated_method = "BC28B5E73153DBD6C6E279AD3533CFEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean compareAndSwapInt(Object obj, long offset,
            int expectedValue, int newValue) {
        dsTaint.addTaint(expectedValue);
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
        char[] retVal = {DSUtils.UNKNOWN_CHAR};
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "B07F728E6C3379FC842B1FF2090A16B1", hash_generated_method = "5CD8448518A34329E1D2FEA17F6A75E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean compareAndSwapLong(Object obj, long offset,
            long expectedValue, long newValue) {
        dsTaint.addTaint(expectedValue);
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "65A652B3AC9F111924C01101653C4D66", hash_generated_method = "7359B0C0AD1A27D856A8325C29AC6681")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean compareAndSwapObject(Object obj, long offset,
            Object expectedValue, Object newValue) {
        dsTaint.addTaint(expectedValue.dsTaint);
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "8D5B44DDE927FC459CE77FA18575E830", hash_generated_method = "5E9131D7258468DD98CFF2E83A790C22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIntVolatile(Object obj, long offset) {
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "2D478903B4854FFA78FE99D55B867EDA", hash_generated_method = "058EAA241B2CCA1272D80155517EECD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putIntVolatile(Object obj, long offset, int newValue) {
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "5D356F9FCB64558B37245C6E5D455D6F", hash_generated_method = "B61A6AC34871EE792B7DD8DBE5551278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLongVolatile(Object obj, long offset) {
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.170 -0400", hash_original_method = "5AB3D5DDF9043F3DC91C224AABAA6528", hash_generated_method = "EDC252A0E54039612721E19E838E6925")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putLongVolatile(Object obj, long offset, long newValue) {
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "7F65AB78F7829D174777BA98D685A0A2", hash_generated_method = "5653DDAB9CEFE39922E21A0C8B96536E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getObjectVolatile(Object obj, long offset) {
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
        return dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "F4C73687B1C91E2A955A746EFDA19758", hash_generated_method = "577E19DCD274D8D240270EB1817A26C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putObjectVolatile(Object obj, long offset,
            Object newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "F04350E1B41BC327004009309A9820C4", hash_generated_method = "63991A93B2CD94C9A63F8309AADCE52C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(Object obj, long offset) {
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "CE446F803EECC7090C6DE85B5F9727FB", hash_generated_method = "2526EA86546FC5DDAC0BE67F601A27C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putInt(Object obj, long offset, int newValue) {
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "0F4EEADE82300C8A6D47BB66B25081FB", hash_generated_method = "631F19086D1C786A2C95BD7C054F67FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putOrderedInt(Object obj, long offset, int newValue) {
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "A62D16CF4622F3468767ED41FD0C48D8", hash_generated_method = "4C03EC3EFEF9BB7A9F8A5B73C65550F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(Object obj, long offset) {
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "031A6C224714E986F8A4D8A9D45D73DD", hash_generated_method = "3BA508E06EA7977F5E565077C262508E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putLong(Object obj, long offset, long newValue) {
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "30A8F8DBA968E18C841B02CD11CE8C50", hash_generated_method = "6AF10BDF9C319372AF48799E7E8CEF26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putOrderedLong(Object obj, long offset, long newValue) {
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "F008619F8920F7BD7FA02EADD68A4977", hash_generated_method = "DAA568F66A3EDF90D651FC31DE4E391E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getObject(Object obj, long offset) {
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
        return dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "C5B0C5B313647A39681E22F983DB9828", hash_generated_method = "B356FA18336650FB5ACDA7C6D3A0F04F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putObject(Object obj, long offset, Object newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "330A73F0EAD671011DED9E5367E246F7", hash_generated_method = "1163CF524DB28013CFAF3D34994E814C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putOrderedObject(Object obj, long offset,
            Object newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "A0416E5885795BAB8716EF22A6E96095", hash_generated_method = "49EA580BB21CDB405074E110E9DFA152")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void park(boolean absolute, long time) {
        dsTaint.addTaint(absolute);
        dsTaint.addTaint(time);
        {
            Thread.currentThread().parkUntil(time);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.171 -0400", hash_original_method = "D722FA56AE20F33E2A3A13A64FA43CE8", hash_generated_method = "DB18E21B8624EC9FC8262978B69B8F53")
    @DSModeled(DSC.SAFE)
    public void unpark(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            ((Thread) obj).unpark();
        } //End block
        {
            throw new IllegalArgumentException("valid for Threads only");
        } //End block
        // ---------- Original Method ----------
        //if (obj instanceof Thread) {
            //((Thread) obj).unpark();
        //} else {
            //throw new IllegalArgumentException("valid for Threads only");
        //}
    }

    
}


