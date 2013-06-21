package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.SystemClock;

public class Interpolator {
    private int mValueCount;
    private int mFrameCount;
    private int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.236 -0400", hash_original_method = "19122541958F7FA844B795B7542E8DCA", hash_generated_method = "03145337720CA2FE702265CCBCFF97C1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.236 -0400", hash_original_method = "39AB5A4645DDA75ACBCA394AE8D72CCA", hash_generated_method = "DA80FCBC114D8086F58EF0EAE4CF311C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.237 -0400", hash_original_method = "DF63005BC1AE5B0B1E3F7DD90D14732F", hash_generated_method = "A21B7B69D329A1D5AF1D2F30F2822BC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reset(int valueCount) {
        dsTaint.addTaint(valueCount);
        reset(valueCount, 2);
        // ---------- Original Method ----------
        //reset(valueCount, 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.237 -0400", hash_original_method = "C5023085042082F0979BC336BA173BAC", hash_generated_method = "A6D11B492E299F108AD9B49FC5BE784E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reset(int valueCount, int frameCount) {
        dsTaint.addTaint(frameCount);
        dsTaint.addTaint(valueCount);
        nativeReset(native_instance, valueCount, frameCount);
        // ---------- Original Method ----------
        //mValueCount = valueCount;
        //mFrameCount = frameCount;
        //nativeReset(native_instance, valueCount, frameCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.237 -0400", hash_original_method = "89BB77AE086853608E25F99A94348DC0", hash_generated_method = "DA0CAFC34E8F8CFB49F3649D331BB845")
    @DSModeled(DSC.SAFE)
    public final int getKeyFrameCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFrameCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.237 -0400", hash_original_method = "776BE84F4731B9CD4E842330007BED2A", hash_generated_method = "C665FC538EE17E974D11055DD09F5C06")
    @DSModeled(DSC.SAFE)
    public final int getValueCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mValueCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.237 -0400", hash_original_method = "8B845648DDEC7EC4E813052052B8A4ED", hash_generated_method = "AF3D38CEEDA7A7956C3FBED3398B7CF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setKeyFrame(int index, int msec, float[] values) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(values[0]);
        dsTaint.addTaint(msec);
        setKeyFrame(index, msec, values, null);
        // ---------- Original Method ----------
        //setKeyFrame(index, msec, values, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.238 -0400", hash_original_method = "0A4BD1EDAE26740EE7CE301C3AD23A04", hash_generated_method = "7C6B19FC6F7C06EE9F285309B6DDB8BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setKeyFrame(int index, int msec, float[] values, float[] blend) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(values[0]);
        dsTaint.addTaint(blend[0]);
        dsTaint.addTaint(msec);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayStoreException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayStoreException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.238 -0400", hash_original_method = "951FAF18C8FD28DC8D0B362372C0DCF6", hash_generated_method = "59E2331EC63C2A1E21BADE00DBA77A80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.238 -0400", hash_original_method = "BDADB3549C258921F869033B8AFE985D", hash_generated_method = "956A9925BD21BC747A41A65B9F4179B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Result timeToValues(float[] values) {
        dsTaint.addTaint(values[0]);
        Result var09A9FD87BC849A417E3E49B1CB9278E0_1875879927 = (timeToValues((int)SystemClock.uptimeMillis(), values));
        return (Result)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return timeToValues((int)SystemClock.uptimeMillis(), values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.239 -0400", hash_original_method = "B04849E47B71B5E874F7B8DA72F507BD", hash_generated_method = "FCBE881E9470A204C953913AC053F11B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Result timeToValues(int msec, float[] values) {
        dsTaint.addTaint(values[0]);
        dsTaint.addTaint(msec);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayStoreException();
        } //End block
        {
            Object varA4BFD4D2F53298C85D9D8D1E371BC48A_82166993 = (nativeTimeToValues(native_instance, msec, values));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.240 -0400", hash_original_method = "CA9745465B207BED8177C430188A7C4B", hash_generated_method = "731B1C9A23DC747F95D123894CD0AB39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        nativeDestructor(native_instance);
        // ---------- Original Method ----------
        //nativeDestructor(native_instance);
    }

    
        private static int nativeConstructor(int valueCount, int frameCount) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeDestructor(int native_instance) {
    }

    
        private static void nativeReset(int native_instance, int valueCount, int frameCount) {
    }

    
        private static void nativeSetKeyFrame(int native_instance, int index, int msec, float[] values, float[] blend) {
    }

    
        private static void nativeSetRepeatMirror(int native_instance, float repeatCount, boolean mirror) {
    }

    
        private static int nativeTimeToValues(int native_instance, int msec, float[] values) {
        return DSUtils.UNKNOWN_INT;
    }

    
    public enum Result {
        NORMAL,
        FREEZE_START,
        FREEZE_END
    }

    
}

