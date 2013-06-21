package android.hardware;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Sensor {
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.733 -0400", hash_original_method = "80AB5568838CD06B7C5D0D01375BC87D", hash_generated_method = "85A61CCE8B57CD17B4BC62899E7E3FBC")
    @DSModeled(DSC.SAFE)
     Sensor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.733 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "1698AF415E3250D582962C1A88D4A564")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.733 -0400", hash_original_method = "F6DBA9B895A9F6BE7E05CE87ECD019F4", hash_generated_method = "C98BC8F919B0CAD2DB0E77111773AAA4")
    @DSModeled(DSC.SAFE)
    public String getVendor() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mVendor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.733 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "66DFEA4B0062EB4492784966BCFD516E")
    @DSModeled(DSC.SAFE)
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.734 -0400", hash_original_method = "FFB84CD4E6F908DBB49F8BB0926B46F5", hash_generated_method = "5F21F40DE80ACEEF39D1DEC7188D55C1")
    @DSModeled(DSC.SAFE)
    public int getVersion() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.734 -0400", hash_original_method = "6198FEF981E7D8A1688F54FA00E65E8C", hash_generated_method = "1F4172DF2E0BD4111100F079B01BDD69")
    @DSModeled(DSC.SAFE)
    public float getMaximumRange() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mMaxRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.734 -0400", hash_original_method = "1725287A095026A35800C8C63E2384B5", hash_generated_method = "6350F515ADFA60A13D75D3091E8979DD")
    @DSModeled(DSC.SAFE)
    public float getResolution() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mResolution;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.735 -0400", hash_original_method = "B0474A1BCCE237F866EBC98A98505E0E", hash_generated_method = "84076A1851A9B2C893E1D81E1639D98E")
    @DSModeled(DSC.SAFE)
    public float getPower() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mPower;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.735 -0400", hash_original_method = "4A9FEF4C412DF9B7A3BC77180D9B6BAD", hash_generated_method = "BD0BC961948112F3F02EACCAC8351FA5")
    @DSModeled(DSC.SAFE)
    public int getMinDelay() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMinDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.735 -0400", hash_original_method = "D36DE5C675AF98C788AA35665F02D96A", hash_generated_method = "4512533524E90D3AD66EBC1D34677EA1")
    @DSModeled(DSC.SAFE)
     int getHandle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.735 -0400", hash_original_method = "79FDA84CCAB5F11B9228B733B07E659A", hash_generated_method = "B9E962FF175760CD92E16F4DCEB9BA69")
    @DSModeled(DSC.SAFE)
     void setRange(float max, float res) {
        dsTaint.addTaint(res);
        dsTaint.addTaint(max);
        // ---------- Original Method ----------
        //mMaxRange = max;
        //mResolution = res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.736 -0400", hash_original_method = "16ED5C2A25AA97BC63C7DA19CC8F6BA9", hash_generated_method = "E522374E9D73369F54622F8BF336D4D6")
    @DSModeled(DSC.SAFE)
     void setLegacyType(int legacyType) {
        dsTaint.addTaint(legacyType);
        // ---------- Original Method ----------
        //mLegacyType = legacyType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.736 -0400", hash_original_method = "D8F34D64979AA05FA819D64B70FA9A46", hash_generated_method = "0D398E9EA95CEA4684B479D05C1007D7")
    @DSModeled(DSC.SAFE)
     int getLegacyType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLegacyType;
    }

    
    public static final int TYPE_ACCELEROMETER = 1;
    public static final int TYPE_MAGNETIC_FIELD = 2;
    @Deprecated public static final int TYPE_ORIENTATION = 3;
    public static final int TYPE_GYROSCOPE = 4;
    public static final int TYPE_LIGHT = 5;
    public static final int TYPE_PRESSURE = 6;
    @Deprecated public static final int TYPE_TEMPERATURE = 7;
    public static final int TYPE_PROXIMITY = 8;
    public static final int TYPE_GRAVITY = 9;
    public static final int TYPE_LINEAR_ACCELERATION = 10;
    public static final int TYPE_ROTATION_VECTOR = 11;
    public static final int TYPE_RELATIVE_HUMIDITY = 12;
    public static final int TYPE_AMBIENT_TEMPERATURE = 13;
    public static final int TYPE_ALL = -1;
}

