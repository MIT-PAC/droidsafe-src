package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;

public class ConfigurationInfo implements Parcelable {
    public int reqTouchScreen;
    public int reqKeyboardType;
    public int reqNavigation;
    public static final int INPUT_FEATURE_HARD_KEYBOARD = 0x00000001;
    public static final int INPUT_FEATURE_FIVE_WAY_NAV = 0x00000002;
    public int reqInputFeatures = 0;
    public static final int GL_ES_VERSION_UNDEFINED = 0;
    public int reqGlEsVersion;
    public static final Creator<ConfigurationInfo> CREATOR = new Creator<ConfigurationInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.858 -0400", hash_original_method = "55BBC101BB2A26593D4442BBB1A17284", hash_generated_method = "1966A823665641499CC8F8AECBA7E46D")
        @DSModeled(DSC.SAFE)
        public ConfigurationInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (ConfigurationInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ConfigurationInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.858 -0400", hash_original_method = "0326D89C816AA8DD712BD61E197104C9", hash_generated_method = "693AE1C46D3A8E6DBA401C5B072929C6")
        @DSModeled(DSC.SAFE)
        public ConfigurationInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ConfigurationInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ConfigurationInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.858 -0400", hash_original_method = "6A0CBEBA9367A4C86820E8B74F6CB393", hash_generated_method = "E2B3AF1B7D15A58FB5FA1F17D9111F9F")
    @DSModeled(DSC.SAFE)
    public ConfigurationInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.858 -0400", hash_original_method = "7048090D37568420C37729B6120A9155", hash_generated_method = "A60FF481D59FAF93221E064AA72211B6")
    @DSModeled(DSC.SAFE)
    public ConfigurationInfo(ConfigurationInfo orig) {
        dsTaint.addTaint(orig.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.859 -0400", hash_original_method = "7C700DBE05496C6AB562D5FCB315B327", hash_generated_method = "40B8A7D6F63199F233FD38BE2386F379")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ConfigurationInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.859 -0400", hash_original_method = "DF17C53C5839729CA11877C3DC3AE571", hash_generated_method = "6F28FB9ACF0A9CFD53170D4308F2DFD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varF5F0ADE7B932AB2F99CA832423A2F397_1115246336 = ("ConfigurationInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " touchscreen = " + reqTouchScreen
            + " inputMethod = " + reqKeyboardType
            + " navigation = " + reqNavigation
            + " reqInputFeatures = " + reqInputFeatures
            + " reqGlEsVersion = " + reqGlEsVersion + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ConfigurationInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " touchscreen = " + reqTouchScreen
            //+ " inputMethod = " + reqKeyboardType
            //+ " navigation = " + reqNavigation
            //+ " reqInputFeatures = " + reqInputFeatures
            //+ " reqGlEsVersion = " + reqGlEsVersion + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.859 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.860 -0400", hash_original_method = "93E63A9EAD498422955671B9C038ABAF", hash_generated_method = "5B5DC2CEA2FA9CBB49835677777E35C4")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.860 -0400", hash_original_method = "6B16AB9E297007D3C91B331171401C71", hash_generated_method = "CD8D7392ECF0A6B84F5232737884335C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getGlEsVersion() {
        int major;
        major = ((reqGlEsVersion & 0xffff0000) >> 16);
        int minor;
        minor = reqGlEsVersion & 0x0000ffff;
        String var3CDB58B0CDECF20616EF79109A7E8415_310303501 = (String.valueOf(major)+"."+String.valueOf(minor));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int major = ((reqGlEsVersion & 0xffff0000) >> 16);
        //int minor = reqGlEsVersion & 0x0000ffff;
        //return String.valueOf(major)+"."+String.valueOf(minor);
    }

    
}


