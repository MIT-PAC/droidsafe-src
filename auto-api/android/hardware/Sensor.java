package android.hardware;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class Sensor {
    public static final int TYPE_ACCELEROMETER = 1;
    public static final int TYPE_MAGNETIC_FIELD = 2;
    @Deprecated
    public static final int TYPE_ORIENTATION = 3;
    public static final int TYPE_GYROSCOPE = 4;
    public static final int TYPE_LIGHT = 5;
    public static final int TYPE_PRESSURE = 6;
    @Deprecated
    public static final int TYPE_TEMPERATURE = 7;
    public static final int TYPE_PROXIMITY = 8;
    public static final int TYPE_GRAVITY = 9;
    public static final int TYPE_LINEAR_ACCELERATION = 10;
    public static final int TYPE_ROTATION_VECTOR = 11;
    public static final int TYPE_RELATIVE_HUMIDITY = 12;
    public static final int TYPE_AMBIENT_TEMPERATURE = 13;
    public static final int TYPE_ALL = -1;
    private String  mName;
    private String  mVendor;
    private int     mVersion;
    private int     mHandle;
    private int     mType;
    private float   mMaxRange;
    private float   mResolution;
    private float   mPower;
    private int     mMinDelay;
    private int     mLegacyType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.478 -0400", hash_original_method = "80AB5568838CD06B7C5D0D01375BC87D", hash_generated_method = "1B73609D82734689A962C5BA9E7C2A79")
    @DSModeled(DSC.SAFE)
     Sensor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.478 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "5B64F8F5AC7FE997D96CC003BA212E34")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.478 -0400", hash_original_method = "F6DBA9B895A9F6BE7E05CE87ECD019F4", hash_generated_method = "03CE99C8C76D2FBB3A8EF71D9A414381")
    @DSModeled(DSC.SAFE)
    public String getVendor() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mVendor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.478 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "E6C0F4DA24DEB386955E797B464A5714")
    @DSModeled(DSC.SAFE)
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.478 -0400", hash_original_method = "FFB84CD4E6F908DBB49F8BB0926B46F5", hash_generated_method = "6BBC7001E5B7078800EAF4E594162E1D")
    @DSModeled(DSC.SAFE)
    public int getVersion() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.478 -0400", hash_original_method = "6198FEF981E7D8A1688F54FA00E65E8C", hash_generated_method = "3981E374E6CBBA2DC09DFBAC98C06B96")
    @DSModeled(DSC.SAFE)
    public float getMaximumRange() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mMaxRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.479 -0400", hash_original_method = "1725287A095026A35800C8C63E2384B5", hash_generated_method = "4FF8497C7159D145BF5EABFDC91E4598")
    @DSModeled(DSC.SAFE)
    public float getResolution() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mResolution;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.479 -0400", hash_original_method = "B0474A1BCCE237F866EBC98A98505E0E", hash_generated_method = "3C96883559EB41A47442E676E421AD85")
    @DSModeled(DSC.SAFE)
    public float getPower() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mPower;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.479 -0400", hash_original_method = "4A9FEF4C412DF9B7A3BC77180D9B6BAD", hash_generated_method = "5031BE5164DB54B2003151E8280E4C07")
    @DSModeled(DSC.SAFE)
    public int getMinDelay() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMinDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.479 -0400", hash_original_method = "D36DE5C675AF98C788AA35665F02D96A", hash_generated_method = "417BAB74DD7DF15880BE14056C9A39A7")
    @DSModeled(DSC.SAFE)
     int getHandle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.479 -0400", hash_original_method = "79FDA84CCAB5F11B9228B733B07E659A", hash_generated_method = "2BE92FA2D96589509BFFE6E6EAA0BDA4")
    @DSModeled(DSC.SAFE)
     void setRange(float max, float res) {
        dsTaint.addTaint(res);
        dsTaint.addTaint(max);
        // ---------- Original Method ----------
        //mMaxRange = max;
        //mResolution = res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.479 -0400", hash_original_method = "16ED5C2A25AA97BC63C7DA19CC8F6BA9", hash_generated_method = "2BF0F9C4928C2BB5C0FE38A56D99E1CC")
    @DSModeled(DSC.SAFE)
     void setLegacyType(int legacyType) {
        dsTaint.addTaint(legacyType);
        // ---------- Original Method ----------
        //mLegacyType = legacyType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.479 -0400", hash_original_method = "D8F34D64979AA05FA819D64B70FA9A46", hash_generated_method = "239E2065098B743BAEC1B90A5178725D")
    @DSModeled(DSC.SAFE)
     int getLegacyType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLegacyType;
    }

    
}


