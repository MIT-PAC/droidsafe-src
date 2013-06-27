package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FeatureInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.717 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.727 -0400", hash_original_field = "25C79D11416B49B4C9D823C1A9BE9381", hash_generated_field = "D9CA7B199E4287467AAA0CAF1003E688")

    public int reqGlEsVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.727 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.732 -0400", hash_original_method = "41B0CF3D831DF05554CAE06DC339C2C3", hash_generated_method = "28CCD5FE48E24B28094FDFB6399BB826")
    public  FeatureInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.755 -0400", hash_original_method = "72E19FF88F50F4C463F65FF457EE5FBC", hash_generated_method = "39FC86B33CA984BD49B1ABCF202820B4")
    public  FeatureInfo(FeatureInfo orig) {
        name = orig.name;
        reqGlEsVersion = orig.reqGlEsVersion;
        flags = orig.flags;
        // ---------- Original Method ----------
        //name = orig.name;
        //reqGlEsVersion = orig.reqGlEsVersion;
        //flags = orig.flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.756 -0400", hash_original_method = "759BB7759C525D4DCDEBEE87E6E15A1A", hash_generated_method = "56ABA0EEF53305BE40084530A2DE504A")
    private  FeatureInfo(Parcel source) {
        name = source.readString();
        reqGlEsVersion = source.readInt();
        flags = source.readInt();
        // ---------- Original Method ----------
        //name = source.readString();
        //reqGlEsVersion = source.readInt();
        //flags = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.767 -0400", hash_original_method = "CEFF2831199A05D6B9B0449BE07C0CC4", hash_generated_method = "520F5EFBB41A8291E177128D379E1BA1")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_942569734 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_205179566 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_942569734 = "FeatureInfo{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " " + name + " fl=0x" + Integer.toHexString(flags) + "}";
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_205179566 = "FeatureInfo{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " glEsVers=" + getGlEsVersion()
                    + " fl=0x" + Integer.toHexString(flags) + "}";
        } //End block
        String varA7E53CE21691AB073D9660D615818899_729256366; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_729256366 = varB4EAC82CA7396A68D541C85D26508E83_942569734;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_729256366 = varB4EAC82CA7396A68D541C85D26508E83_205179566;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_729256366.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_729256366;
        // ---------- Original Method ----------
        //if (name != null) {
            //return "FeatureInfo{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " " + name + " fl=0x" + Integer.toHexString(flags) + "}";
        //} else {
            //return "FeatureInfo{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " glEsVers=" + getGlEsVersion()
                    //+ " fl=0x" + Integer.toHexString(flags) + "}";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.782 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F8E47379B3BC10E187712A77DD509F91")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_775037539 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_775037539;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.784 -0400", hash_original_method = "2C0CF9F313C5756E6D4A273445A14FD5", hash_generated_method = "CAA4B46B6AD3BF78590A5EED174B10E6")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeString(name);
        dest.writeInt(reqGlEsVersion);
        dest.writeInt(flags);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        //dest.writeString(name);
        //dest.writeInt(reqGlEsVersion);
        //dest.writeInt(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.805 -0400", hash_original_method = "6B16AB9E297007D3C91B331171401C71", hash_generated_method = "5E45DCAD2E112D992F633D429C971541")
    public String getGlEsVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_564245957 = null; //Variable for return #1
        int major;
        major = ((reqGlEsVersion & 0xffff0000) >> 16);
        int minor;
        minor = reqGlEsVersion & 0x0000ffff;
        varB4EAC82CA7396A68D541C85D26508E83_564245957 = String.valueOf(major)+"."+String.valueOf(minor);
        varB4EAC82CA7396A68D541C85D26508E83_564245957.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_564245957;
        // ---------- Original Method ----------
        //int major = ((reqGlEsVersion & 0xffff0000) >> 16);
        //int minor = reqGlEsVersion & 0x0000ffff;
        //return String.valueOf(major)+"."+String.valueOf(minor);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.805 -0400", hash_original_field = "5F3DA35A2CF223A14FA4283DD701279B", hash_generated_field = "783C36C8508F1DD83B69876DC88244AC")

    public static final int GL_ES_VERSION_UNDEFINED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.805 -0400", hash_original_field = "63AE3BDDDC2A4A70865F736A9BEF81BA", hash_generated_field = "8372D183E011A9DBCF8D97F3AB5A3E78")

    public static final int FLAG_REQUIRED = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.805 -0400", hash_original_field = "95A1EF5D9EC2F517FC7C5B12B1988350", hash_generated_field = "38F34883BED9DBE78BA7458130C48695")

    public static final Creator<FeatureInfo> CREATOR =
        new Creator<FeatureInfo>() {
        public FeatureInfo createFromParcel(Parcel source) {
            return new FeatureInfo(source);
        }
        public FeatureInfo[] newArray(int size) {
            return new FeatureInfo[size];
        }
    };
}

