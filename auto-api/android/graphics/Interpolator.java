package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.SystemClock;

public class Interpolator {
    private int mValueCount;
    private int mFrameCount;
    private final int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.190 -0400", hash_original_method = "19122541958F7FA844B795B7542E8DCA", hash_generated_method = "8430E1B946375CE50C59B1C7CA539022")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Interpolator(int valueCount) {
        dsTaint.addTaint(valueCount);
        mFrameCount = 2;
        native_instance = nativeConstructor(valueCount, 2);
        // ---------- Original Method ----------
        //mValueCount = valueCount;
        //mFrameCount = 2;
        //native_instance = nativeConstructor(valueCount, 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.190 -0400", hash_original_method = "39AB5A4645DDA75ACBCA394AE8D72CCA", hash_generated_method = "207D3B4555D157B355EF94151DB5B278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Interpolator(int valueCount, int frameCount) {
        dsTaint.addTaint(frameCount);
        dsTaint.addTaint(valueCount);
        native_instance = nativeConstructor(valueCount, frameCount);
        // ---------- Original Method ----------
        //mValueCount = valueCount;
        //mFrameCount = frameCount;
        //native_instance = nativeConstructor(valueCount, frameCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.190 -0400", hash_original_method = "DF63005BC1AE5B0B1E3F7DD90D14732F", hash_generated_method = "FB8D20FF1D793E2083E2EEC315695F8F")
    @DSModeled(DSC.SAFE)
    public void reset(int valueCount) {
        dsTaint.addTaint(valueCount);
        reset(valueCount, 2);
        // ---------- Original Method ----------
        //reset(valueCount, 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.190 -0400", hash_original_method = "C5023085042082F0979BC336BA173BAC", hash_generated_method = "7A0B538D2C5E5441254B31371B90AD13")
    @DSModeled(DSC.SAFE)
    public void reset(int valueCount, int frameCount) {
        dsTaint.addTaint(frameCount);
        dsTaint.addTaint(valueCount);
        nativeReset(native_instance, valueCount, frameCount);
        // ---------- Original Method ----------
        //mValueCount = valueCount;
        //mFrameCount = frameCount;
        //nativeReset(native_instance, valueCount, frameCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.190 -0400", hash_original_method = "89BB77AE086853608E25F99A94348DC0", hash_generated_method = "193B5BCACA0913F2908F5DB7853DC04F")
    @DSModeled(DSC.SAFE)
    public final int getKeyFrameCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFrameCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.190 -0400", hash_original_method = "776BE84F4731B9CD4E842330007BED2A", hash_generated_method = "711931E0091B09E273E74AA9AC4394F2")
    @DSModeled(DSC.SAFE)
    public final int getValueCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mValueCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.190 -0400", hash_original_method = "8B845648DDEC7EC4E813052052B8A4ED", hash_generated_method = "57A4DED19BFE7C7345DA6D1C20EC3E0E")
    @DSModeled(DSC.SAFE)
    public void setKeyFrame(int index, int msec, float[] values) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(values);
        dsTaint.addTaint(msec);
        setKeyFrame(index, msec, values, null);
        // ---------- Original Method ----------
        //setKeyFrame(index, msec, values, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.191 -0400", hash_original_method = "0A4BD1EDAE26740EE7CE301C3AD23A04", hash_generated_method = "B5EFC5836D4EF6B432FA9B3A0786A963")
    @DSModeled(DSC.SAFE)
    public void setKeyFrame(int index, int msec, float[] values, float[] blend) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(values);
        dsTaint.addTaint(blend);
        dsTaint.addTaint(msec);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IndexOutOfBoundsException();
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new ArrayStoreException();
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new ArrayStoreException();
        } //End block
        nativeSetKeyFrame(native_instance, index, msec, values, blend);
        // ---------- Original Method ----------
        //if (index < 0 || index >= mFrameCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (values.length < mValueCount) {
            //throw new ArrayStoreException();
        //}
        //if (blend != null && blend.length < 4) {
            //throw new ArrayStoreException();
        //}
        //nativeSetKeyFrame(native_instance, index, msec, values, blend);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.191 -0400", hash_original_method = "951FAF18C8FD28DC8D0B362372C0DCF6", hash_generated_method = "58F8F2E1C8F120AA60359DDD130DC46A")
    @DSModeled(DSC.SAFE)
    public void setRepeatMirror(float repeatCount, boolean mirror) {
        dsTaint.addTaint(mirror);
        dsTaint.addTaint(repeatCount);
        {
            nativeSetRepeatMirror(native_instance, repeatCount, mirror);
        } //End block
        // ---------- Original Method ----------
        //if (repeatCount >= 0) {
            //nativeSetRepeatMirror(native_instance, repeatCount, mirror);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.191 -0400", hash_original_method = "BDADB3549C258921F869033B8AFE985D", hash_generated_method = "B81C8A0228B05CDC7CF97CB47C3DA62D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Result timeToValues(float[] values) {
        dsTaint.addTaint(values);
        Result var09A9FD87BC849A417E3E49B1CB9278E0_297813606 = (timeToValues((int)SystemClock.uptimeMillis(), values));
        return (Result)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return timeToValues((int)SystemClock.uptimeMillis(), values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.191 -0400", hash_original_method = "B04849E47B71B5E874F7B8DA72F507BD", hash_generated_method = "CC5DF978B1333FCB3263861EC36D23CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Result timeToValues(int msec, float[] values) {
        dsTaint.addTaint(values);
        dsTaint.addTaint(msec);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new ArrayStoreException();
        } //End block
        {
            Object varA4BFD4D2F53298C85D9D8D1E371BC48A_1657080054 = (nativeTimeToValues(native_instance, msec, values));
        } //End collapsed parenthetic
        return (Result)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (values != null && values.length < mValueCount) {
            //throw new ArrayStoreException();
        //}
        //switch (nativeTimeToValues(native_instance, msec, values)) {
            //case 0: return Result.NORMAL;
            //case 1: return Result.FREEZE_START;
            //default: return Result.FREEZE_END;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.191 -0400", hash_original_method = "CA9745465B207BED8177C430188A7C4B", hash_generated_method = "AA08156505D59E4FDE1F74F9FD20EE72")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        nativeDestructor(native_instance);
        // ---------- Original Method ----------
        //nativeDestructor(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.191 -0400", hash_original_method = "7CDA6FD84ADEB317B6530F3CCCE8BED8", hash_generated_method = "792E3F0159A9DD460ACA64943C9B406D")
    private static int nativeConstructor(int valueCount, int frameCount) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.191 -0400", hash_original_method = "78511D3304E1B85C7734E8F36B99BAA5", hash_generated_method = "BEA0AE0F624D343F2D1280C68A16B7C7")
    private static void nativeDestructor(int native_instance) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.191 -0400", hash_original_method = "C005F39B0904104523423AD0D7832C20", hash_generated_method = "1B770DC959B5FCD4B08FE3EF4D4B70E3")
    private static void nativeReset(int native_instance, int valueCount, int frameCount) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.191 -0400", hash_original_method = "B02F5FF4C3A80DE68ED7D8D71ED91441", hash_generated_method = "F20571199C404240A21E4A26079024FD")
    private static void nativeSetKeyFrame(int native_instance, int index, int msec, float[] values, float[] blend) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.192 -0400", hash_original_method = "8EAEBC453C0D15654C45F393481C33C4", hash_generated_method = "104E56A69ED70E007B4599BBEB45A00C")
    private static void nativeSetRepeatMirror(int native_instance, float repeatCount, boolean mirror) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.192 -0400", hash_original_method = "D7645B233D78E4E965B97FC9AD4CD61A", hash_generated_method = "45632BBC5F21D3D2C4E79796E827C967")
    private static int nativeTimeToValues(int native_instance, int msec, float[] values) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    public enum Result {
        NORMAL,
        FREEZE_START,
        FREEZE_END
    }

    
}


