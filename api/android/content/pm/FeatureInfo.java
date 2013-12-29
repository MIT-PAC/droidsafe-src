package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class FeatureInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.736 -0500", hash_original_field = "F48EAB296ADF6CE662F7CDF5F130714D", hash_generated_field = "783C36C8508F1DD83B69876DC88244AC")

    public static final int GL_ES_VERSION_UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.738 -0500", hash_original_field = "AE554CEB8DD34B427A2B238D1F113970", hash_generated_field = "8372D183E011A9DBCF8D97F3AB5A3E78")

    public static final int FLAG_REQUIRED = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.470 -0400", hash_original_field = "95A1EF5D9EC2F517FC7C5B12B1988350", hash_generated_field = "38F34883BED9DBE78BA7458130C48695")

    public static final Creator<FeatureInfo> CREATOR =
        new Creator<FeatureInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.744 -0500", hash_original_method = "795598BB85F5A7B4341D7421A827595B", hash_generated_method = "E99008DA333C88F3533E77F99FD4B80B")
        public FeatureInfo createFromParcel(Parcel source) {
            return new FeatureInfo(source);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.745 -0500", hash_original_method = "CE8FBC12368E74E2CE1E47198E761C2C", hash_generated_method = "74C19CD152F78E01A84AA6A800620E37")
        public FeatureInfo[] newArray(int size) {
            return new FeatureInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.735 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.737 -0500", hash_original_field = "6AF15FFF05CBAB25A3FF6D68BA3FAAE6", hash_generated_field = "D9CA7B199E4287467AAA0CAF1003E688")

    public int reqGlEsVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.739 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.740 -0500", hash_original_method = "41B0CF3D831DF05554CAE06DC339C2C3", hash_generated_method = "C2DE53BB65835B07F932FDCB9F54E0DE")
    public FeatureInfo() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.741 -0500", hash_original_method = "72E19FF88F50F4C463F65FF457EE5FBC", hash_generated_method = "16C2D34A9EB6B1CF428397663F153125")
    public FeatureInfo(FeatureInfo orig) {
        name = orig.name;
        reqGlEsVersion = orig.reqGlEsVersion;
        flags = orig.flags;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.747 -0500", hash_original_method = "759BB7759C525D4DCDEBEE87E6E15A1A", hash_generated_method = "36755041B3FD8D6648A607C942A99643")
    private FeatureInfo(Parcel source) {
        name = source.readString();
        reqGlEsVersion = source.readInt();
        flags = source.readInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.742 -0500", hash_original_method = "CEFF2831199A05D6B9B0449BE07C0CC4", hash_generated_method = "1AA302D0E82FFBA1C766C5B6FC26E4C6")
    public String toString() {
        if (name != null) {
            return "FeatureInfo{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " " + name + " fl=0x" + Integer.toHexString(flags) + "}";
        } else {
            return "FeatureInfo{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " glEsVers=" + getGlEsVersion()
                    + " fl=0x" + Integer.toHexString(flags) + "}";
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.742 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.743 -0500", hash_original_method = "2C0CF9F313C5756E6D4A273445A14FD5", hash_generated_method = "39A9B55BA41EBE2C856B82047913DF25")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeString(name);
        dest.writeInt(reqGlEsVersion);
        dest.writeInt(flags);
    }

    /**
     * This method extracts the major and minor version of reqGLEsVersion attribute
     * and returns it as a string. Say reqGlEsVersion value of 0x00010002 is returned
     * as 1.2
     * @return String representation of the reqGlEsVersion attribute
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.748 -0500", hash_original_method = "6B16AB9E297007D3C91B331171401C71", hash_generated_method = "303984A3946A6AB415F5805F75FB0A51")
    public String getGlEsVersion() {
        int major = ((reqGlEsVersion & 0xffff0000) >> 16);
        int minor = reqGlEsVersion & 0x0000ffff;
        return String.valueOf(major)+"."+String.valueOf(minor);
    }
    // orphaned legacy method
    public FeatureInfo createFromParcel(Parcel source) {
            return new FeatureInfo(source);
        }
    
    // orphaned legacy method
    public FeatureInfo[] newArray(int size) {
            return new FeatureInfo[size];
        }
    
}

