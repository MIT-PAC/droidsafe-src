package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class ConfigurationInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.796 -0400", hash_original_field = "4449CF444AEAA6383AE8DA4CB52EEA57", hash_generated_field = "520175E5479B41A42F01692389B0DBB8")

    public int reqTouchScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.796 -0400", hash_original_field = "1AAF5FB9624D5AB6148C330F7682C05E", hash_generated_field = "B7B56BFCE46D9BEDEE60FABBDC0BB54D")

    public int reqKeyboardType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.796 -0400", hash_original_field = "A7D4810F59D1ED656E662A0B11CAF6D5", hash_generated_field = "AEA9ADF73BD257E98D85F51F5C11417B")

    public int reqNavigation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.796 -0400", hash_original_field = "BA0BA8295E0220CFD42AB41AB5776604", hash_generated_field = "EF985035373431B1AD5A3E161E098B88")

    public int reqInputFeatures = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.796 -0400", hash_original_field = "25C79D11416B49B4C9D823C1A9BE9381", hash_generated_field = "D9CA7B199E4287467AAA0CAF1003E688")

    public int reqGlEsVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.812 -0400", hash_original_method = "6A0CBEBA9367A4C86820E8B74F6CB393", hash_generated_method = "B5597B37ECC63222BC2CA4C8AB58CBCE")
    public  ConfigurationInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.823 -0400", hash_original_method = "7048090D37568420C37729B6120A9155", hash_generated_method = "23E9B3D362F9DC14870C9B21A8D1CEBF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.834 -0400", hash_original_method = "7C700DBE05496C6AB562D5FCB315B327", hash_generated_method = "24FB33A5C8E819FEE98EE805C719068E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.961 -0400", hash_original_method = "DF17C53C5839729CA11877C3DC3AE571", hash_generated_method = "E57F4C134F8E1EC039014F26AFC186D5")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_523752814 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_523752814 = "ConfigurationInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " touchscreen = " + reqTouchScreen
            + " inputMethod = " + reqKeyboardType
            + " navigation = " + reqNavigation
            + " reqInputFeatures = " + reqInputFeatures
            + " reqGlEsVersion = " + reqGlEsVersion + "}";
        varB4EAC82CA7396A68D541C85D26508E83_523752814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_523752814;
        // ---------- Original Method ----------
        //return "ConfigurationInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " touchscreen = " + reqTouchScreen
            //+ " inputMethod = " + reqKeyboardType
            //+ " navigation = " + reqNavigation
            //+ " reqInputFeatures = " + reqInputFeatures
            //+ " reqGlEsVersion = " + reqGlEsVersion + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.961 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7E8217BC8175B21191999F1CB5FE00D4")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695699667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695699667;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.962 -0400", hash_original_method = "93E63A9EAD498422955671B9C038ABAF", hash_generated_method = "116625107A8D9CC87069917E451983DE")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeInt(reqTouchScreen);
        dest.writeInt(reqKeyboardType);
        dest.writeInt(reqNavigation);
        dest.writeInt(reqInputFeatures);
        dest.writeInt(reqGlEsVersion);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        //dest.writeInt(reqTouchScreen);
        //dest.writeInt(reqKeyboardType);
        //dest.writeInt(reqNavigation);
        //dest.writeInt(reqInputFeatures);
        //dest.writeInt(reqGlEsVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.973 -0400", hash_original_method = "6B16AB9E297007D3C91B331171401C71", hash_generated_method = "2CA6F7DC7F1402EEAF5BC84E667D32BF")
    public String getGlEsVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_204967557 = null; //Variable for return #1
        int major;
        major = ((reqGlEsVersion & 0xffff0000) >> 16);
        int minor;
        minor = reqGlEsVersion & 0x0000ffff;
        varB4EAC82CA7396A68D541C85D26508E83_204967557 = String.valueOf(major)+"."+String.valueOf(minor);
        varB4EAC82CA7396A68D541C85D26508E83_204967557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_204967557;
        // ---------- Original Method ----------
        //int major = ((reqGlEsVersion & 0xffff0000) >> 16);
        //int minor = reqGlEsVersion & 0x0000ffff;
        //return String.valueOf(major)+"."+String.valueOf(minor);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.973 -0400", hash_original_field = "B00FC1CB2FCE08EBF05799CFE2C6BEBA", hash_generated_field = "C64F87CC0E25666997582EEC8768F819")

    public static final int INPUT_FEATURE_HARD_KEYBOARD = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.973 -0400", hash_original_field = "19FCAB32FCEEB3FA25437B186B9CAFA9", hash_generated_field = "5BEB66D3756A889C64CBD093D7DAFCC1")

    public static final int INPUT_FEATURE_FIVE_WAY_NAV = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.973 -0400", hash_original_field = "5F3DA35A2CF223A14FA4283DD701279B", hash_generated_field = "783C36C8508F1DD83B69876DC88244AC")

    public static final int GL_ES_VERSION_UNDEFINED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.973 -0400", hash_original_field = "858991FA57C439B05BBDC3DCF5C48F1C", hash_generated_field = "B0DCE505E982797116EDED118468DA14")

    public static final Creator<ConfigurationInfo> CREATOR =
        new Creator<ConfigurationInfo>() {
        public ConfigurationInfo createFromParcel(Parcel source) {
            return new ConfigurationInfo(source);
        }
        public ConfigurationInfo[] newArray(int size) {
            return new ConfigurationInfo[size];
        }
    };
}

