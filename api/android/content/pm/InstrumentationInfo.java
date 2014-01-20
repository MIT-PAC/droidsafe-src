package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class InstrumentationInfo extends PackageItemInfo implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.109 -0400", hash_original_field = "BA8A63A897F5E025416B15F18812752C", hash_generated_field = "A55C73249AB0FB01F9CA1AED98F25E65")

    public static final Parcelable.Creator<InstrumentationInfo> CREATOR
            = new Parcelable.Creator<InstrumentationInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.726 -0500", hash_original_method = "616D094A5F6275D1C36A99C64CA287B0", hash_generated_method = "2283F092B3D81B193DEC876D255C19CD")
        
public InstrumentationInfo createFromParcel(Parcel source) {
            return new InstrumentationInfo(source);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.728 -0500", hash_original_method = "869873A5A987B871AAF44C10B123D622", hash_generated_method = "45513C84316DABC0C813AF2D3AF86221")
        
public InstrumentationInfo[] newArray(int size) {
            return new InstrumentationInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.697 -0500", hash_original_field = "6243CBF371DEEA8EFD77F26B9AC9C2C5", hash_generated_field = "9C75B713060FA6BE08EF6725E9B4E7D0")

    public String targetPackage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.699 -0500", hash_original_field = "A8389DF99A9675FDA1974874284E7B15", hash_generated_field = "0B4DFCC25C52DF28B36617C8AC8E4427")

    public String sourceDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.702 -0500", hash_original_field = "8945F799C01F09B53280EFF9A71F39C5", hash_generated_field = "72C784EC94EBBBC972EFE50E9D71D5EE")

    public String publicSourceDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.704 -0500", hash_original_field = "7F6CF3A9271EE00B41A116BE001193FA", hash_generated_field = "052BC408B8ED9FFD83EAA19D8E7278C2")

    public String dataDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.706 -0500", hash_original_field = "C996DE29DA44618ECCF72C2550AC8EF8", hash_generated_field = "0DA308DB0A30EC1E1D8EA3A5BBA153E4")

    public String nativeLibraryDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.708 -0500", hash_original_field = "DC3B2CC4D4A4007118BB171852551AD4", hash_generated_field = "C185AE02F38DA84178A242CF2731DD2E")

    public boolean handleProfiling;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.711 -0500", hash_original_field = "9FCBBD4DE5157EF247A356F40AA14A81", hash_generated_field = "BB79529C955BCF773AA8708113671616")

    public boolean functionalTest;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.713 -0500", hash_original_method = "34F974A68EBB10BE10D867312E044FDF", hash_generated_method = "531DD31DFE59E5552883C2D1CC120AB9")
    
public InstrumentationInfo() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.716 -0500", hash_original_method = "33EE44CD2D02810ECD9B8B62FE0C07D7", hash_generated_method = "D4095F4D5BE0B72D6E643FC0C9743D42")
    
public InstrumentationInfo(InstrumentationInfo orig) {
        super(orig);
        targetPackage = orig.targetPackage;
        sourceDir = orig.sourceDir;
        publicSourceDir = orig.publicSourceDir;
        dataDir = orig.dataDir;
        nativeLibraryDir = orig.nativeLibraryDir;
        handleProfiling = orig.handleProfiling;
        functionalTest = orig.functionalTest;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.733 -0500", hash_original_method = "2F2A6843358187D56B8BE4AE48B0B4F7", hash_generated_method = "F987D266C0CADF67CC14FDE251190E03")
    
private InstrumentationInfo(Parcel source) {
        super(source);
        targetPackage = source.readString();
        sourceDir = source.readString();
        publicSourceDir = source.readString();
        dataDir = source.readString();
        nativeLibraryDir = source.readString();
        handleProfiling = source.readInt() != 0;
        functionalTest = source.readInt() != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.718 -0500", hash_original_method = "B5CF3592446C27C5B1615F6776EEEE26", hash_generated_method = "B0AB00AD3796A73D7959BFA53043C91D")
    
public String toString() {
        return "InstrumentationInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + packageName + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.720 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.722 -0500", hash_original_method = "6CE0B2B52F0EF507C684C63B39230F74", hash_generated_method = "21B8B9CE675722DA5FD8EE4F1CE170A3")
    
public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(targetPackage);
        dest.writeString(sourceDir);
        dest.writeString(publicSourceDir);
        dest.writeString(dataDir);
        dest.writeString(nativeLibraryDir);
        dest.writeInt((handleProfiling == false) ? 0 : 1);
        dest.writeInt((functionalTest == false) ? 0 : 1);
    }
    // orphaned legacy method
    public InstrumentationInfo createFromParcel(Parcel source) {
            return new InstrumentationInfo(source);
        }
    
    // orphaned legacy method
    public InstrumentationInfo[] newArray(int size) {
            return new InstrumentationInfo[size];
        }
    
}

