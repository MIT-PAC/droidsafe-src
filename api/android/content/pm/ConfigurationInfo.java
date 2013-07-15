package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class ConfigurationInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.189 -0400", hash_original_field = "4449CF444AEAA6383AE8DA4CB52EEA57", hash_generated_field = "520175E5479B41A42F01692389B0DBB8")

    public int reqTouchScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.189 -0400", hash_original_field = "1AAF5FB9624D5AB6148C330F7682C05E", hash_generated_field = "B7B56BFCE46D9BEDEE60FABBDC0BB54D")

    public int reqKeyboardType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.189 -0400", hash_original_field = "A7D4810F59D1ED656E662A0B11CAF6D5", hash_generated_field = "AEA9ADF73BD257E98D85F51F5C11417B")

    public int reqNavigation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.190 -0400", hash_original_field = "BA0BA8295E0220CFD42AB41AB5776604", hash_generated_field = "EF985035373431B1AD5A3E161E098B88")

    public int reqInputFeatures = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.190 -0400", hash_original_field = "25C79D11416B49B4C9D823C1A9BE9381", hash_generated_field = "D9CA7B199E4287467AAA0CAF1003E688")

    public int reqGlEsVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.190 -0400", hash_original_method = "6A0CBEBA9367A4C86820E8B74F6CB393", hash_generated_method = "B5597B37ECC63222BC2CA4C8AB58CBCE")
    public  ConfigurationInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.191 -0400", hash_original_method = "7048090D37568420C37729B6120A9155", hash_generated_method = "23E9B3D362F9DC14870C9B21A8D1CEBF")
    public  ConfigurationInfo(ConfigurationInfo orig) {
        reqTouchScreen = orig.reqTouchScreen;
        reqKeyboardType = orig.reqKeyboardType;
        reqNavigation = orig.reqNavigation;
        reqInputFeatures = orig.reqInputFeatures;
        reqGlEsVersion = orig.reqGlEsVersion;
        // ---------- Original Method ----------
        //reqTouchScreen = orig.reqTouchScreen;
        //reqKeyboardType = orig.reqKeyboardType;
        //reqNavigation = orig.reqNavigation;
        //reqInputFeatures = orig.reqInputFeatures;
        //reqGlEsVersion = orig.reqGlEsVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.192 -0400", hash_original_method = "7C700DBE05496C6AB562D5FCB315B327", hash_generated_method = "24FB33A5C8E819FEE98EE805C719068E")
    private  ConfigurationInfo(Parcel source) {
        reqTouchScreen = source.readInt();
        reqKeyboardType = source.readInt();
        reqNavigation = source.readInt();
        reqInputFeatures = source.readInt();
        reqGlEsVersion = source.readInt();
        // ---------- Original Method ----------
        //reqTouchScreen = source.readInt();
        //reqKeyboardType = source.readInt();
        //reqNavigation = source.readInt();
        //reqInputFeatures = source.readInt();
        //reqGlEsVersion = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.193 -0400", hash_original_method = "DF17C53C5839729CA11877C3DC3AE571", hash_generated_method = "E85751B4E6D978A2CD0DA8CD87ED35EE")
    public String toString() {
String var57D8B201F347B4113B2F1E3F7D401190_925952806 =         "ConfigurationInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " touchscreen = " + reqTouchScreen
            + " inputMethod = " + reqKeyboardType
            + " navigation = " + reqNavigation
            + " reqInputFeatures = " + reqInputFeatures
            + " reqGlEsVersion = " + reqGlEsVersion + "}";
        var57D8B201F347B4113B2F1E3F7D401190_925952806.addTaint(taint);
        return var57D8B201F347B4113B2F1E3F7D401190_925952806;
        // ---------- Original Method ----------
        //return "ConfigurationInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " touchscreen = " + reqTouchScreen
            //+ " inputMethod = " + reqKeyboardType
            //+ " navigation = " + reqNavigation
            //+ " reqInputFeatures = " + reqInputFeatures
            //+ " reqGlEsVersion = " + reqGlEsVersion + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.194 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FEFE9A6CABA43D2F46D83485FDD061F5")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_233370703 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017636306 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017636306;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.195 -0400", hash_original_method = "93E63A9EAD498422955671B9C038ABAF", hash_generated_method = "ADF36519BBC705F7D5C0AF3A76B935FB")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
        dest.writeInt(reqTouchScreen);
        dest.writeInt(reqKeyboardType);
        dest.writeInt(reqNavigation);
        dest.writeInt(reqInputFeatures);
        dest.writeInt(reqGlEsVersion);
        // ---------- Original Method ----------
        //dest.writeInt(reqTouchScreen);
        //dest.writeInt(reqKeyboardType);
        //dest.writeInt(reqNavigation);
        //dest.writeInt(reqInputFeatures);
        //dest.writeInt(reqGlEsVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.195 -0400", hash_original_method = "6B16AB9E297007D3C91B331171401C71", hash_generated_method = "1D222CD5102DDCD77BCEDC1B657C0CE2")
    public String getGlEsVersion() {
        int major = ((reqGlEsVersion & 0xffff0000) >> 16);
        int minor = reqGlEsVersion & 0x0000ffff;
String var53423E0996054EE339CEF146F3A9158D_17115817 =         String.valueOf(major)+"."+String.valueOf(minor);
        var53423E0996054EE339CEF146F3A9158D_17115817.addTaint(taint);
        return var53423E0996054EE339CEF146F3A9158D_17115817;
        // ---------- Original Method ----------
        //int major = ((reqGlEsVersion & 0xffff0000) >> 16);
        //int minor = reqGlEsVersion & 0x0000ffff;
        //return String.valueOf(major)+"."+String.valueOf(minor);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.195 -0400", hash_original_field = "B00FC1CB2FCE08EBF05799CFE2C6BEBA", hash_generated_field = "C64F87CC0E25666997582EEC8768F819")

    public static final int INPUT_FEATURE_HARD_KEYBOARD = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.195 -0400", hash_original_field = "19FCAB32FCEEB3FA25437B186B9CAFA9", hash_generated_field = "5BEB66D3756A889C64CBD093D7DAFCC1")

    public static final int INPUT_FEATURE_FIVE_WAY_NAV = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.196 -0400", hash_original_field = "5F3DA35A2CF223A14FA4283DD701279B", hash_generated_field = "783C36C8508F1DD83B69876DC88244AC")

    public static final int GL_ES_VERSION_UNDEFINED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.196 -0400", hash_original_field = "858991FA57C439B05BBDC3DCF5C48F1C", hash_generated_field = "B0DCE505E982797116EDED118468DA14")

    public static final Creator<ConfigurationInfo> CREATOR =
        new Creator<ConfigurationInfo>() {
        public ConfigurationInfo createFromParcel(Parcel source) {
            return new ConfigurationInfo(source);
        }
        public ConfigurationInfo[] newArray(int size) {
            return new ConfigurationInfo[size];
        }
    };
    // orphaned legacy method
    public ConfigurationInfo createFromParcel(Parcel source) {
            return new ConfigurationInfo(source);
        }
    
    // orphaned legacy method
    public ConfigurationInfo[] newArray(int size) {
            return new ConfigurationInfo[size];
        }
    
}

