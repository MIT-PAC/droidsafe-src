package android.hardware;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Sensor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.045 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.045 -0400", hash_original_field = "A6120724376181F9DEDC1C4155DBD03B", hash_generated_field = "0133A398651F27CFDE818C1535BC6F1F")

    private String mVendor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.045 -0400", hash_original_field = "31DABD0EACF4143CCA942BDEEA018E36", hash_generated_field = "258EA1EF04C9F2D0E2CF5DF5339FDA4C")

    private int mVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.045 -0400", hash_original_field = "D82B253C7CDC2B84A5A684E7A5D691F6", hash_generated_field = "24C6DFC54244C0ECB3E13AC2BDE66375")

    private int mHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.049 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.049 -0400", hash_original_field = "AF38C3CCCA5A208245654FB91AC8B651", hash_generated_field = "2B7C6D48323D7D323725705B6BF1993F")

    private float mMaxRange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.049 -0400", hash_original_field = "E1F778822B1B6241D006690EBC32D3DE", hash_generated_field = "A44A5E8A99CA4D0485669217E20BDFE4")

    private float mResolution;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.049 -0400", hash_original_field = "09635C6D09B7F8278A9B0BA37C4F718C", hash_generated_field = "FF89E9A1C5CDACC17C0D103288EF1D02")

    private float mPower;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.049 -0400", hash_original_field = "9962EBCF5A72A852286E654DD4D92CED", hash_generated_field = "4D425740A46B7FA7F38D81ED634037EC")

    private int mMinDelay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.049 -0400", hash_original_field = "169076DE5D2BAB1237B250894BADAE98", hash_generated_field = "4DB15B10E5F4E25BCBCE0DEA4932D80B")

    private int mLegacyType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.050 -0400", hash_original_method = "80AB5568838CD06B7C5D0D01375BC87D", hash_generated_method = "85A61CCE8B57CD17B4BC62899E7E3FBC")
      Sensor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.050 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "42B7D10A8DC86545DC11F9A2371D88B7")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1309352895 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1309352895 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_1309352895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1309352895;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.063 -0400", hash_original_method = "F6DBA9B895A9F6BE7E05CE87ECD019F4", hash_generated_method = "FCD32E81F6793B7BA3D58347C0DC914E")
    public String getVendor() {
        String varB4EAC82CA7396A68D541C85D26508E83_953349878 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_953349878 = mVendor;
        varB4EAC82CA7396A68D541C85D26508E83_953349878.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_953349878;
        // ---------- Original Method ----------
        //return mVendor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.063 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "8993474375F85CC315B87321BDC9696E")
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60311779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60311779;
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.069 -0400", hash_original_method = "FFB84CD4E6F908DBB49F8BB0926B46F5", hash_generated_method = "D647C4C3AC3F341C6E0F79EEFC08CAC0")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945351957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945351957;
        // ---------- Original Method ----------
        //return mVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.070 -0400", hash_original_method = "6198FEF981E7D8A1688F54FA00E65E8C", hash_generated_method = "B2696B12726063C2CC0612896241F6F0")
    public float getMaximumRange() {
        float var546ADE640B6EDFBC8A086EF31347E768_2123592277 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2123592277;
        // ---------- Original Method ----------
        //return mMaxRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.070 -0400", hash_original_method = "1725287A095026A35800C8C63E2384B5", hash_generated_method = "DB01C4800D2836B10166846CF8971EB1")
    public float getResolution() {
        float var546ADE640B6EDFBC8A086EF31347E768_628111530 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_628111530;
        // ---------- Original Method ----------
        //return mResolution;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.071 -0400", hash_original_method = "B0474A1BCCE237F866EBC98A98505E0E", hash_generated_method = "51091CAC359E9C41AD055F1ADC9F553F")
    public float getPower() {
        float var546ADE640B6EDFBC8A086EF31347E768_1650999672 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1650999672;
        // ---------- Original Method ----------
        //return mPower;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.083 -0400", hash_original_method = "4A9FEF4C412DF9B7A3BC77180D9B6BAD", hash_generated_method = "073A04CBBF3B9DEF501C24889FA98154")
    public int getMinDelay() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34561555 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34561555;
        // ---------- Original Method ----------
        //return mMinDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.083 -0400", hash_original_method = "D36DE5C675AF98C788AA35665F02D96A", hash_generated_method = "7F6FFC9F0462250FDD5E5E74FE473811")
     int getHandle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814976409 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814976409;
        // ---------- Original Method ----------
        //return mHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.084 -0400", hash_original_method = "79FDA84CCAB5F11B9228B733B07E659A", hash_generated_method = "55F8A4578DDB548AF38C7C2E7259452F")
     void setRange(float max, float res) {
        mMaxRange = max;
        mResolution = res;
        // ---------- Original Method ----------
        //mMaxRange = max;
        //mResolution = res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.084 -0400", hash_original_method = "16ED5C2A25AA97BC63C7DA19CC8F6BA9", hash_generated_method = "2395A4BE1A50167E3283C7DDD34B5E2E")
     void setLegacyType(int legacyType) {
        mLegacyType = legacyType;
        // ---------- Original Method ----------
        //mLegacyType = legacyType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.084 -0400", hash_original_method = "D8F34D64979AA05FA819D64B70FA9A46", hash_generated_method = "58DF56858E93BD77E894B0507E479CBD")
     int getLegacyType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_549796654 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_549796654;
        // ---------- Original Method ----------
        //return mLegacyType;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.085 -0400", hash_original_field = "44715E2D950DD063573580CF96515099", hash_generated_field = "B6DA5A1745BAAD9EA2E434AF197F49AC")

    public static final int TYPE_ACCELEROMETER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.085 -0400", hash_original_field = "8C91C36EFB86A870BFE4D8C0EF65791E", hash_generated_field = "E9264D35E5D796E834D4892CE8414B86")

    public static final int TYPE_MAGNETIC_FIELD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.085 -0400", hash_original_field = "CE0B2D66A511B32E983EA5AA7FA63D8C", hash_generated_field = "BB4FF7BA219854BD09903AD46734F631")

    @Deprecated
    public static final int TYPE_ORIENTATION = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.085 -0400", hash_original_field = "C2E628930098E115C273A77D8B485C91", hash_generated_field = "5D76797F1C7AEEAB0090823C58033FD2")

    public static final int TYPE_GYROSCOPE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.085 -0400", hash_original_field = "9D474F505EC9773AB74FA8C951B77FEF", hash_generated_field = "8FBF6F4E126FEA8930F268A6299DE440")

    public static final int TYPE_LIGHT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.085 -0400", hash_original_field = "4B7602ED9512460A94FCFC3A99BC26C9", hash_generated_field = "F914CE030FD942F8FE0FCBFECC7A6DC8")

    public static final int TYPE_PRESSURE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.085 -0400", hash_original_field = "027E99B3D27099732FA91AE1CFFABE0B", hash_generated_field = "CC025C4C8D0DB73368D882AAEC9BA303")

    @Deprecated
    public static final int TYPE_TEMPERATURE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.085 -0400", hash_original_field = "98EAF265A71C1461FF69E496EC1E2E3A", hash_generated_field = "19CB56C40558E597544F32F2B4F6730E")

    public static final int TYPE_PROXIMITY = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.085 -0400", hash_original_field = "FF9E9E1C6BDB623CFC9E1C96FA03975B", hash_generated_field = "97A37B2B52FEA5FA5F75F13C13D418B4")

    public static final int TYPE_GRAVITY = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.085 -0400", hash_original_field = "B15BD85AD662D836F72A912E01C56BA3", hash_generated_field = "9E9421A8F1B62DA0F470EE59BE03BD30")

    public static final int TYPE_LINEAR_ACCELERATION = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.086 -0400", hash_original_field = "0555E34FFD354CAAB8057D7EC9F5B32A", hash_generated_field = "55A0CC8EB5304BE87D54DD49F82CF240")

    public static final int TYPE_ROTATION_VECTOR = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.086 -0400", hash_original_field = "12E8E8BE2E26570BB1075EF90410ADA7", hash_generated_field = "7A1D69A6BE0FD967674BA5BD1F8E34DE")

    public static final int TYPE_RELATIVE_HUMIDITY = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.086 -0400", hash_original_field = "6F4738D5AE16C365E0C368B010548798", hash_generated_field = "4E3EE9B725B865DC45AD36038B4332AC")

    public static final int TYPE_AMBIENT_TEMPERATURE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.086 -0400", hash_original_field = "9ACBE1251AFEB992CC61C1517B944E44", hash_generated_field = "4B698C51FE1A6E2A3732C8AED171E530")

    public static final int TYPE_ALL = -1;
}

