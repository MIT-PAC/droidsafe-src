package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.SystemClock;

public class Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.219 -0400", hash_original_field = "9DD1709B968485B920C9BE604E78F1F8", hash_generated_field = "68C3E9DC71F308640D17475B37A6DDEF")

    private int mValueCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.220 -0400", hash_original_field = "EDB3186346B1612B7704D58A9CAAE15F", hash_generated_field = "539D32ACC3FFB5021AAD2744A6F8CCC3")

    private int mFrameCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.220 -0400", hash_original_field = "7E2E7BFEC42581BDE25254C4BB512478", hash_generated_field = "7F8F576E4626C874BE9FCD8FF3DA7FA2")

    private int native_instance;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.220 -0400", hash_original_method = "19122541958F7FA844B795B7542E8DCA", hash_generated_method = "8508DD55D9C551232014E9D4DB09C860")
    public  Interpolator(int valueCount) {
        mValueCount = valueCount;
        mFrameCount = 2;
        native_instance = nativeConstructor(valueCount, 2);
        // ---------- Original Method ----------
        //mValueCount = valueCount;
        //mFrameCount = 2;
        //native_instance = nativeConstructor(valueCount, 2);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.221 -0400", hash_original_method = "39AB5A4645DDA75ACBCA394AE8D72CCA", hash_generated_method = "8340695937F416EFEBA414C444356F88")
    public  Interpolator(int valueCount, int frameCount) {
        mValueCount = valueCount;
        mFrameCount = frameCount;
        native_instance = nativeConstructor(valueCount, frameCount);
        // ---------- Original Method ----------
        //mValueCount = valueCount;
        //mFrameCount = frameCount;
        //native_instance = nativeConstructor(valueCount, frameCount);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.222 -0400", hash_original_method = "DF63005BC1AE5B0B1E3F7DD90D14732F", hash_generated_method = "1D754612D6D29CDE39BA9598FA69A8C0")
    public void reset(int valueCount) {
        addTaint(valueCount);
        reset(valueCount, 2);
        // ---------- Original Method ----------
        //reset(valueCount, 2);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.223 -0400", hash_original_method = "C5023085042082F0979BC336BA173BAC", hash_generated_method = "B929C65A068EE7C8CD773E3398DF04E7")
    public void reset(int valueCount, int frameCount) {
        mValueCount = valueCount;
        mFrameCount = frameCount;
        nativeReset(native_instance, valueCount, frameCount);
        // ---------- Original Method ----------
        //mValueCount = valueCount;
        //mFrameCount = frameCount;
        //nativeReset(native_instance, valueCount, frameCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.223 -0400", hash_original_method = "89BB77AE086853608E25F99A94348DC0", hash_generated_method = "08F9B6933EBC8525504645E04D829003")
    public final int getKeyFrameCount() {
        int varEDB3186346B1612B7704D58A9CAAE15F_462752270 = (mFrameCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_834186130 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_834186130;
        // ---------- Original Method ----------
        //return mFrameCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.223 -0400", hash_original_method = "776BE84F4731B9CD4E842330007BED2A", hash_generated_method = "3B9547BF51C46D08AD2B9C70DA3BF2AA")
    public final int getValueCount() {
        int var9DD1709B968485B920C9BE604E78F1F8_725202617 = (mValueCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141915796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141915796;
        // ---------- Original Method ----------
        //return mValueCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.224 -0400", hash_original_method = "8B845648DDEC7EC4E813052052B8A4ED", hash_generated_method = "803B934524809F06FDEC2A9CD457E0F9")
    public void setKeyFrame(int index, int msec, float[] values) {
        addTaint(values[0]);
        addTaint(msec);
        addTaint(index);
        setKeyFrame(index, msec, values, null);
        // ---------- Original Method ----------
        //setKeyFrame(index, msec, values, null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.225 -0400", hash_original_method = "0A4BD1EDAE26740EE7CE301C3AD23A04", hash_generated_method = "0E6E8833A884382C74BDC98C44B30D56")
    public void setKeyFrame(int index, int msec, float[] values, float[] blend) {
        addTaint(blend[0]);
        addTaint(values[0]);
        addTaint(msec);
        addTaint(index);
        if(index < 0 || index >= mFrameCount)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1384041290 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1384041290.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1384041290;
        } //End block
        if(values.length < mValueCount)        
        {
            ArrayStoreException varE8756FD45921680EB1843325B7426A76_1416838248 = new ArrayStoreException();
            varE8756FD45921680EB1843325B7426A76_1416838248.addTaint(taint);
            throw varE8756FD45921680EB1843325B7426A76_1416838248;
        } //End block
        if(blend != null && blend.length < 4)        
        {
            ArrayStoreException varE8756FD45921680EB1843325B7426A76_1678063888 = new ArrayStoreException();
            varE8756FD45921680EB1843325B7426A76_1678063888.addTaint(taint);
            throw varE8756FD45921680EB1843325B7426A76_1678063888;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.226 -0400", hash_original_method = "951FAF18C8FD28DC8D0B362372C0DCF6", hash_generated_method = "A79EA8DACC83F54C101FC7ABE9771D08")
    public void setRepeatMirror(float repeatCount, boolean mirror) {
        addTaint(mirror);
        addTaint(repeatCount);
        if(repeatCount >= 0)        
        {
            nativeSetRepeatMirror(native_instance, repeatCount, mirror);
        } //End block
        // ---------- Original Method ----------
        //if (repeatCount >= 0) {
            //nativeSetRepeatMirror(native_instance, repeatCount, mirror);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.226 -0400", hash_original_method = "BDADB3549C258921F869033B8AFE985D", hash_generated_method = "72ED3AEA02FE2689296D0D2AB4DEF5E6")
    public Result timeToValues(float[] values) {
        addTaint(values[0]);
Result var83E6FAA72EB76B38707B749FFF307395_940678812 =         timeToValues((int)SystemClock.uptimeMillis(), values);
        var83E6FAA72EB76B38707B749FFF307395_940678812.addTaint(taint);
        return var83E6FAA72EB76B38707B749FFF307395_940678812;
        // ---------- Original Method ----------
        //return timeToValues((int)SystemClock.uptimeMillis(), values);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.227 -0400", hash_original_method = "B04849E47B71B5E874F7B8DA72F507BD", hash_generated_method = "EC02E03A2E0C8BA94AA62F94D45313EB")
    public Result timeToValues(int msec, float[] values) {
        addTaint(values[0]);
        addTaint(msec);
        if(values != null && values.length < mValueCount)        
        {
            ArrayStoreException varE8756FD45921680EB1843325B7426A76_1646076724 = new ArrayStoreException();
            varE8756FD45921680EB1843325B7426A76_1646076724.addTaint(taint);
            throw varE8756FD45921680EB1843325B7426A76_1646076724;
        } //End block
switch(nativeTimeToValues(native_instance, msec, values)){
        case 0:
Result var352E9F15CFD4F929A4D24CF4640F1117_241652557 =         Result.NORMAL;
        var352E9F15CFD4F929A4D24CF4640F1117_241652557.addTaint(taint);
        return var352E9F15CFD4F929A4D24CF4640F1117_241652557;
        case 1:
Result var2B7F6A7BF9DB4E852852A77A10A7711E_1542562358 =         Result.FREEZE_START;
        var2B7F6A7BF9DB4E852852A77A10A7711E_1542562358.addTaint(taint);
        return var2B7F6A7BF9DB4E852852A77A10A7711E_1542562358;
        default:
Result var607877E62AB94E691FECF4B996EA77B1_220359022 =         Result.FREEZE_END;
        var607877E62AB94E691FECF4B996EA77B1_220359022.addTaint(taint);
        return var607877E62AB94E691FECF4B996EA77B1_220359022;
}
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.228 -0400", hash_original_method = "CA9745465B207BED8177C430188A7C4B", hash_generated_method = "731B1C9A23DC747F95D123894CD0AB39")
    @Override
    protected void finalize() throws Throwable {
        nativeDestructor(native_instance);
        // ---------- Original Method ----------
        //nativeDestructor(native_instance);
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeConstructor(int valueCount, int frameCount) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDestructor(int native_instance) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeReset(int native_instance, int valueCount, int frameCount) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetKeyFrame(int native_instance, int index, int msec, float[] values, float[] blend) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetRepeatMirror(int native_instance, float repeatCount, boolean mirror) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeTimeToValues(int native_instance, int msec, float[] values) {
        return DSUtils.UNKNOWN_INT;
    }

    
    public enum Result {
        NORMAL,
        FREEZE_START,
        FREEZE_END
    }

    
}

