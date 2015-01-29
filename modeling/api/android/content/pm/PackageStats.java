package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class PackageStats implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.281 -0400", hash_original_field = "A51559A5F0F1A83FF690A9B06BA373A2", hash_generated_field = "F7104BE96BB04B81156FA1552CDC726B")

    public static final Parcelable.Creator<PackageStats> CREATOR
            = new Parcelable.Creator<PackageStats>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.124 -0500", hash_original_method = "58C55B3A1DD51A94C15BFC575DA60AB7", hash_generated_method = "F038BAA6457C2DF4F3237166A110B9D7")
        
public PackageStats createFromParcel(Parcel in) {
            return new PackageStats(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.126 -0500", hash_original_method = "FE2D27470FD9E0515CB0D65ED612B641", hash_generated_method = "292FA5F41431718A8D4AEB6E827ECE1E")
        
public PackageStats[] newArray(int size) {
            return new PackageStats[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.103 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.105 -0500", hash_original_field = "931E65CF046CC767867DC49EF9F42849", hash_generated_field = "E6811C32EB75021FA2066A7A7AE09049")

    public long codeSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.107 -0500", hash_original_field = "72EDD847100D202BC9D1A20F72057C3F", hash_generated_field = "CAB5629D1F11B53423EC5FCB5C1D669D")

    public long dataSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.109 -0500", hash_original_field = "24FA73B039262A58DC3BAE7A6B03D323", hash_generated_field = "D1E85F4A68406DD93BF7A7DE69058E48")

    public long cacheSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.112 -0500", hash_original_field = "FA203576163EF5EC4C108D83F4078550", hash_generated_field = "76D935D0199025D61B1D43C9D67B628A")

    public long externalCodeSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.114 -0500", hash_original_field = "9B9EE0FC7784F83011CDAA546BDFCC22", hash_generated_field = "9C3D8099C7EEA5EA0BA971FF9309D780")

    public long externalDataSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.116 -0500", hash_original_field = "B76D090FA8AC54B3F790198D182E42CB", hash_generated_field = "A4D90C1F453C7379BCC9D382078BADB2")

    public long externalCacheSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.118 -0500", hash_original_field = "7D01E0AE9BAB837A2DC7CF623D8C3401", hash_generated_field = "624C60B15E7F6C768FC4AF607A77058B")

    public long externalMediaSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.120 -0500", hash_original_field = "8AC77348D14E343418536C97C9232689", hash_generated_field = "9B5306353F42E6AFA094865EF37D4EFE")

    public long externalObbSize;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.133 -0500", hash_original_method = "737D88E00D7006B4B823AA249FAC1157", hash_generated_method = "027116E25D41B7DE17425795348322FB")
    
public PackageStats(String pkgName) {
        packageName = pkgName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.136 -0500", hash_original_method = "E1B7B8528643A3D2F3F6DEB0DC0DE82B", hash_generated_method = "CACC9179B36F4BEB878011C59ABCFDA6")
    
public PackageStats(Parcel source) {
        packageName = source.readString();
        codeSize = source.readLong();
        dataSize = source.readLong();
        cacheSize = source.readLong();
        externalCodeSize = source.readLong();
        externalDataSize = source.readLong();
        externalCacheSize = source.readLong();
        externalMediaSize = source.readLong();
        externalObbSize = source.readLong();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.139 -0500", hash_original_method = "76B9ED0D503382CF56099B23CB24204B", hash_generated_method = "1DCC19A7EDA0A6E0DEF680D57992A086")
    
public PackageStats(PackageStats pStats) {
        packageName = pStats.packageName;
        codeSize = pStats.codeSize;
        dataSize = pStats.dataSize;
        cacheSize = pStats.cacheSize;
        externalCodeSize = pStats.externalCodeSize;
        externalDataSize = pStats.externalDataSize;
        externalCacheSize = pStats.externalCacheSize;
        externalMediaSize = pStats.externalMediaSize;
        externalObbSize = pStats.externalObbSize;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.131 -0500", hash_original_method = "3FE5C26F51751E2E83526086B9D94747", hash_generated_method = "BAA011B7B2529C8B0D4B10A4CDCA5F26")
    
public String toString() {
        final StringBuilder sb = new StringBuilder("PackageStats{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" packageName=");
        sb.append(packageName);
        sb.append(",codeSize=");
        sb.append(codeSize);
        sb.append(",dataSize=");
        sb.append(dataSize);
        sb.append(",cacheSize=");
        sb.append(cacheSize);
        sb.append(",externalCodeSize=");
        sb.append(externalCodeSize);
        sb.append(",externalDataSize=");
        sb.append(externalDataSize);
        sb.append(",externalCacheSize=");
        sb.append(externalCacheSize);
        sb.append(",externalMediaSize=");
        sb.append(externalMediaSize);
        sb.append(",externalObbSize=");
        sb.append(externalObbSize);
        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.141 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.143 -0500", hash_original_method = "458D37590174ACFE991A170204705742", hash_generated_method = "B64AB717BC3A2F13D1354A1C7DE4FDD9")
    
public void writeToParcel(Parcel dest, int parcelableFlags){
        dest.writeString(packageName);
        dest.writeLong(codeSize);
        dest.writeLong(dataSize);
        dest.writeLong(cacheSize);
        dest.writeLong(externalCodeSize);
        dest.writeLong(externalDataSize);
        dest.writeLong(externalCacheSize);
        dest.writeLong(externalMediaSize);
        dest.writeLong(externalObbSize);
    }
    // orphaned legacy method
    public PackageStats createFromParcel(Parcel in) {
            return new PackageStats(in);
        }
    
    // orphaned legacy method
    public PackageStats[] newArray(int size) {
            return new PackageStats[size];
        }
    
}

