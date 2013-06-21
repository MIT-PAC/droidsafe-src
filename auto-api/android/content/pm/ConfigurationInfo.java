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
    public int reqTouchScreen;
    public int reqKeyboardType;
    public int reqNavigation;
    public int reqInputFeatures = 0;
    public int reqGlEsVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.713 -0400", hash_original_method = "6A0CBEBA9367A4C86820E8B74F6CB393", hash_generated_method = "B5597B37ECC63222BC2CA4C8AB58CBCE")
    @DSModeled(DSC.SAFE)
    public ConfigurationInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.714 -0400", hash_original_method = "7048090D37568420C37729B6120A9155", hash_generated_method = "BF50E54A50F14D2D69371BA3D38CA411")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.714 -0400", hash_original_method = "7C700DBE05496C6AB562D5FCB315B327", hash_generated_method = "DA1A60150CC8ED9F3788799EF52DAB9F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.715 -0400", hash_original_method = "DF17C53C5839729CA11877C3DC3AE571", hash_generated_method = "BBEBBB95D83C2C1AD6C131BC352B12FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varF5F0ADE7B932AB2F99CA832423A2F397_1594577330 = ("ConfigurationInfo{"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.715 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.715 -0400", hash_original_method = "93E63A9EAD498422955671B9C038ABAF", hash_generated_method = "68EB61C40150C15D097F2F4B0243B72B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.716 -0400", hash_original_method = "6B16AB9E297007D3C91B331171401C71", hash_generated_method = "8486D95CC0DF29503BEF73C59664A75E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getGlEsVersion() {
        int major;
        major = ((reqGlEsVersion & 0xffff0000) >> 16);
        int minor;
        minor = reqGlEsVersion & 0x0000ffff;
        String var3CDB58B0CDECF20616EF79109A7E8415_276441817 = (String.valueOf(major)+"."+String.valueOf(minor));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int major = ((reqGlEsVersion & 0xffff0000) >> 16);
        //int minor = reqGlEsVersion & 0x0000ffff;
        //return String.valueOf(major)+"."+String.valueOf(minor);
    }

    
    public static final int INPUT_FEATURE_HARD_KEYBOARD = 0x00000001;
    public static final int INPUT_FEATURE_FIVE_WAY_NAV = 0x00000002;
    public static final int GL_ES_VERSION_UNDEFINED = 0;
    public static final Creator<ConfigurationInfo> CREATOR = new Creator<ConfigurationInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.716 -0400", hash_original_method = "55BBC101BB2A26593D4442BBB1A17284", hash_generated_method = "DE019FC1B3F7BC46CD936C19A0D3B6E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ConfigurationInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            ConfigurationInfo var130E0AF9A898EF48E8283EEB2A9FDD59_1619205887 = (new ConfigurationInfo(source));
            return (ConfigurationInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ConfigurationInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.717 -0400", hash_original_method = "0326D89C816AA8DD712BD61E197104C9", hash_generated_method = "4BA83A8A90A51F4B439703DEE4D5A5A9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ConfigurationInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            ConfigurationInfo[] varAAE4F7ED43782898E7CB994E2E806603_583159622 = (new ConfigurationInfo[size]);
            return (ConfigurationInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ConfigurationInfo[size];
        }

        
}; //Transformed anonymous class
}

