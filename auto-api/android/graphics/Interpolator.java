package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.SystemClock;

public class Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.566 -0400", hash_original_field = "9DD1709B968485B920C9BE604E78F1F8", hash_generated_field = "68C3E9DC71F308640D17475B37A6DDEF")

    private int mValueCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.566 -0400", hash_original_field = "EDB3186346B1612B7704D58A9CAAE15F", hash_generated_field = "539D32ACC3FFB5021AAD2744A6F8CCC3")

    private int mFrameCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.566 -0400", hash_original_field = "7E2E7BFEC42581BDE25254C4BB512478", hash_generated_field = "7F8F576E4626C874BE9FCD8FF3DA7FA2")

    private int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.568 -0400", hash_original_method = "19122541958F7FA844B795B7542E8DCA", hash_generated_method = "8508DD55D9C551232014E9D4DB09C860")
    public  Interpolator(int valueCount) {
        mValueCount = valueCount;
        mFrameCount = 2;
        native_instance = nativeConstructor(valueCount, 2);
        // ---------- Original Method ----------
        //mValueCount = valueCount;
        //mFrameCount = 2;
        //native_instance = nativeConstructor(valueCount, 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.569 -0400", hash_original_method = "39AB5A4645DDA75ACBCA394AE8D72CCA", hash_generated_method = "8340695937F416EFEBA414C444356F88")
    public  Interpolator(int valueCount, int frameCount) {
        mValueCount = valueCount;
        mFrameCount = frameCount;
        native_instance = nativeConstructor(valueCount, frameCount);
        // ---------- Original Method ----------
        //mValueCount = valueCount;
        //mFrameCount = frameCount;
        //native_instance = nativeConstructor(valueCount, frameCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.569 -0400", hash_original_method = "DF63005BC1AE5B0B1E3F7DD90D14732F", hash_generated_method = "CEBB31E0694E3E19422878D0EFB512C6")
    public void reset(int valueCount) {
        reset(valueCount, 2);
        addTaint(valueCount);
        // ---------- Original Method ----------
        //reset(valueCount, 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.593 -0400", hash_original_method = "C5023085042082F0979BC336BA173BAC", hash_generated_method = "B929C65A068EE7C8CD773E3398DF04E7")
    public void reset(int valueCount, int frameCount) {
        mValueCount = valueCount;
        mFrameCount = frameCount;
        nativeReset(native_instance, valueCount, frameCount);
        // ---------- Original Method ----------
        //mValueCount = valueCount;
        //mFrameCount = frameCount;
        //nativeReset(native_instance, valueCount, frameCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.593 -0400", hash_original_method = "89BB77AE086853608E25F99A94348DC0", hash_generated_method = "F67F49B5263487099B3013EC5CEE6C42")
    public final int getKeyFrameCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1957382913 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1957382913;
        // ---------- Original Method ----------
        //return mFrameCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.594 -0400", hash_original_method = "776BE84F4731B9CD4E842330007BED2A", hash_generated_method = "8E71916E418A9506437998875F2F313F")
    public final int getValueCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188731440 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188731440;
        // ---------- Original Method ----------
        //return mValueCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.595 -0400", hash_original_method = "8B845648DDEC7EC4E813052052B8A4ED", hash_generated_method = "9C0C4790234CE6DD1CAA49F0E24E3363")
    public void setKeyFrame(int index, int msec, float[] values) {
        setKeyFrame(index, msec, values, null);
        addTaint(index);
        addTaint(msec);
        addTaint(values[0]);
        // ---------- Original Method ----------
        //setKeyFrame(index, msec, values, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.618 -0400", hash_original_method = "0A4BD1EDAE26740EE7CE301C3AD23A04", hash_generated_method = "EF1752766CEF24DCB1761845F63C0463")
    public void setKeyFrame(int index, int msec, float[] values, float[] blend) {
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
        addTaint(index);
        addTaint(msec);
        addTaint(values[0]);
        addTaint(blend[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.640 -0400", hash_original_method = "951FAF18C8FD28DC8D0B362372C0DCF6", hash_generated_method = "CB94D50392CF570BE35B952FC045CF4D")
    public void setRepeatMirror(float repeatCount, boolean mirror) {
        {
            nativeSetRepeatMirror(native_instance, repeatCount, mirror);
        } //End block
        addTaint(repeatCount);
        addTaint(mirror);
        // ---------- Original Method ----------
        //if (repeatCount >= 0) {
            //nativeSetRepeatMirror(native_instance, repeatCount, mirror);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.641 -0400", hash_original_method = "BDADB3549C258921F869033B8AFE985D", hash_generated_method = "20BB55B14E003D105437C78CF328CB7A")
    public Result timeToValues(float[] values) {
        Result varB4EAC82CA7396A68D541C85D26508E83_1182065800 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1182065800 = timeToValues((int)SystemClock.uptimeMillis(), values);
        addTaint(values[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1182065800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1182065800;
        // ---------- Original Method ----------
        //return timeToValues((int)SystemClock.uptimeMillis(), values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.670 -0400", hash_original_method = "B04849E47B71B5E874F7B8DA72F507BD", hash_generated_method = "43D1E8E178B9F507FA4D11759572ABD5")
    public Result timeToValues(int msec, float[] values) {
        Result varB4EAC82CA7396A68D541C85D26508E83_1357649541 = null; //Variable for return #1
        Result varB4EAC82CA7396A68D541C85D26508E83_2144745996 = null; //Variable for return #2
        Result varB4EAC82CA7396A68D541C85D26508E83_1619320968 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayStoreException();
        } //End block
        {
            Object varA4BFD4D2F53298C85D9D8D1E371BC48A_705282496 = (nativeTimeToValues(native_instance, msec, values));
            //Begin case 0 
            varB4EAC82CA7396A68D541C85D26508E83_1357649541 = Result.NORMAL;
            //End case 0 
            //Begin case 1 
            varB4EAC82CA7396A68D541C85D26508E83_2144745996 = Result.FREEZE_START;
            //End case 1 
            //Begin case default 
            varB4EAC82CA7396A68D541C85D26508E83_1619320968 = Result.FREEZE_END;
            //End case default 
        } //End collapsed parenthetic
        addTaint(msec);
        addTaint(values[0]);
        Result varA7E53CE21691AB073D9660D615818899_116343672; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_116343672 = varB4EAC82CA7396A68D541C85D26508E83_1357649541;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_116343672 = varB4EAC82CA7396A68D541C85D26508E83_2144745996;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_116343672 = varB4EAC82CA7396A68D541C85D26508E83_1619320968;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_116343672.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_116343672;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.670 -0400", hash_original_method = "CA9745465B207BED8177C430188A7C4B", hash_generated_method = "731B1C9A23DC747F95D123894CD0AB39")
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

