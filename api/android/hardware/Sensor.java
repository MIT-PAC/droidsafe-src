package android.hardware;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Sensor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.780 -0500", hash_original_field = "59C273EE9EF12822F89229E5B959B4AF", hash_generated_field = "B6DA5A1745BAAD9EA2E434AF197F49AC")

    public static final int TYPE_ACCELEROMETER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.783 -0500", hash_original_field = "158D7DBA3ABB368DDB8B145D0276745C", hash_generated_field = "E9264D35E5D796E834D4892CE8414B86")

    public static final int TYPE_MAGNETIC_FIELD = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.786 -0500", hash_original_field = "7605341EDC2DAC6F33CAF66E71E70D43", hash_generated_field = "BB4FF7BA219854BD09903AD46734F631")

    @Deprecated
    public static final int TYPE_ORIENTATION = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.789 -0500", hash_original_field = "3A71850D5E492B20F14E6087C8134053", hash_generated_field = "5D76797F1C7AEEAB0090823C58033FD2")

    public static final int TYPE_GYROSCOPE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.791 -0500", hash_original_field = "B8E1F0611CD3A8E71EAE3CCDBE308C37", hash_generated_field = "8FBF6F4E126FEA8930F268A6299DE440")

    public static final int TYPE_LIGHT = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.794 -0500", hash_original_field = "78399D456244D983CA2184713C8CA7C3", hash_generated_field = "F914CE030FD942F8FE0FCBFECC7A6DC8")

    public static final int TYPE_PRESSURE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.797 -0500", hash_original_field = "86B62F99DF325D1B352F43919A6302DE", hash_generated_field = "CC025C4C8D0DB73368D882AAEC9BA303")

    @Deprecated
    public static final int TYPE_TEMPERATURE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.800 -0500", hash_original_field = "08327B055E47307CE9114C000B9026CF", hash_generated_field = "19CB56C40558E597544F32F2B4F6730E")

    public static final int TYPE_PROXIMITY = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.803 -0500", hash_original_field = "CCCC07137C37E0884DDD4BE3CCBAE9DB", hash_generated_field = "97A37B2B52FEA5FA5F75F13C13D418B4")

    public static final int TYPE_GRAVITY = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.805 -0500", hash_original_field = "FEB2454A54B10606F0F404ADB3F4558D", hash_generated_field = "9E9421A8F1B62DA0F470EE59BE03BD30")

    public static final int TYPE_LINEAR_ACCELERATION = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.808 -0500", hash_original_field = "123A753A3E640BE6CAC08855F1A11781", hash_generated_field = "55A0CC8EB5304BE87D54DD49F82CF240")

    public static final int TYPE_ROTATION_VECTOR = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.811 -0500", hash_original_field = "5D558A6A42488066E46806E93F1F101C", hash_generated_field = "7A1D69A6BE0FD967674BA5BD1F8E34DE")

    public static final int TYPE_RELATIVE_HUMIDITY = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.814 -0500", hash_original_field = "51E0F0F183F8D12BAD6C70FFFEE87ACB", hash_generated_field = "4E3EE9B725B865DC45AD36038B4332AC")

    public static final int TYPE_AMBIENT_TEMPERATURE = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.816 -0500", hash_original_field = "B8F9A2BCDE99C26021CB706B5AAB2DBD", hash_generated_field = "4B698C51FE1A6E2A3732C8AED171E530")

    public static final int TYPE_ALL = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.819 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String  mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.822 -0500", hash_original_field = "067EEA15CC6DC3D962E835CB725ED483", hash_generated_field = "0133A398651F27CFDE818C1535BC6F1F")

    private String  mVendor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.824 -0500", hash_original_field = "1556AC3B452ACD6BDF7A7A84E3CFA4B9", hash_generated_field = "258EA1EF04C9F2D0E2CF5DF5339FDA4C")

    private int     mVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.826 -0500", hash_original_field = "BE4FBA339B8964B0ABF1E6F625B8029F", hash_generated_field = "24C6DFC54244C0ECB3E13AC2BDE66375")

    private int     mHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.829 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int     mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.831 -0500", hash_original_field = "F66C33E3B8A529104CDD541EC9CE4207", hash_generated_field = "2B7C6D48323D7D323725705B6BF1993F")

    private float   mMaxRange;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.834 -0500", hash_original_field = "CDC9F4CD35ECD430ACFA9D8CFB69565A", hash_generated_field = "A44A5E8A99CA4D0485669217E20BDFE4")

    private float   mResolution;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.836 -0500", hash_original_field = "052D33E21683320D5CF6715DB2E5C11B", hash_generated_field = "FF89E9A1C5CDACC17C0D103288EF1D02")

    private float   mPower;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.839 -0500", hash_original_field = "B660469110014BAF65764D38533978AC", hash_generated_field = "4D425740A46B7FA7F38D81ED634037EC")

    private int     mMinDelay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.841 -0500", hash_original_field = "52844FC24EFD0853E3084C9D29EBA426", hash_generated_field = "4DB15B10E5F4E25BCBCE0DEA4932D80B")

    private int     mLegacyType;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:57.844 -0500", hash_original_method = "80AB5568838CD06B7C5D0D01375BC87D", hash_generated_method = "80AB5568838CD06B7C5D0D01375BC87D")
    
Sensor() {
    }
    // orphaned legacy method
    
    public Sensor(int type) {
    	addTaint(type);
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getName() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
        //return mName;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getVendor() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
        //return mVendor;
    }
    
    @DSComment("Harvesting information")
    @DSSpec(DSCat.SECURITY)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getType() {
    	return getTaintInt();
        //return mType;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getVersion() {
    	return getTaintInt();
        //return mVersion;
    }
    
    @DSComment("Harvesting information")
    @DSSpec(DSCat.SECURITY)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getMaximumRange() {
    	return getTaintFloat();
        //return mMaxRange;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getResolution() {
    	return getTaintInt();
        //return mResolution;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getPower() {
    	return getTaintFloat();
        //return mPower;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getMinDelay() {
    	return getTaintInt();
        //return mMinDelay;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    int getHandle() {
    	return getTaintInt();
        //return mHandle;
    }
    
    void setRange(float max, float res) {
    	addTaint(max);
    	addTaint(res);
    }
    
    void setLegacyType(int legacyType) {
    	addTaint(legacyType);
    }
    
    int getLegacyType() {
    	return getTaintInt();
        //return mLegacyType;
    }
    
}

