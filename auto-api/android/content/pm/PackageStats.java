package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class PackageStats implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.750 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.750 -0400", hash_original_field = "FDDBAC858FC125F4E038B27D37CD7A2C", hash_generated_field = "E6811C32EB75021FA2066A7A7AE09049")

    public long codeSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.750 -0400", hash_original_field = "7E995300D17ABA58ED95A1629BB54EDB", hash_generated_field = "CAB5629D1F11B53423EC5FCB5C1D669D")

    public long dataSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.750 -0400", hash_original_field = "19D1BFCB72927341EE1477132D6A7A61", hash_generated_field = "D1E85F4A68406DD93BF7A7DE69058E48")

    public long cacheSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.750 -0400", hash_original_field = "0570FBEECCBD86DCB953A91C46942C97", hash_generated_field = "76D935D0199025D61B1D43C9D67B628A")

    public long externalCodeSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.750 -0400", hash_original_field = "05038F43F0B025CCA3AE02BC81085A44", hash_generated_field = "9C3D8099C7EEA5EA0BA971FF9309D780")

    public long externalDataSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.750 -0400", hash_original_field = "9CB7EBAD9C757E71BA4651B760C3E223", hash_generated_field = "A4D90C1F453C7379BCC9D382078BADB2")

    public long externalCacheSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.750 -0400", hash_original_field = "4EB494C02B776A7EE898D6C749967538", hash_generated_field = "624C60B15E7F6C768FC4AF607A77058B")

    public long externalMediaSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.750 -0400", hash_original_field = "A960EAD06F03BFE92B039823D78FA6BE", hash_generated_field = "9B5306353F42E6AFA094865EF37D4EFE")

    public long externalObbSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.751 -0400", hash_original_method = "737D88E00D7006B4B823AA249FAC1157", hash_generated_method = "5E53E1C258E36EC9592C568752FD2612")
    public  PackageStats(String pkgName) {
        packageName = pkgName;
        // ---------- Original Method ----------
        //packageName = pkgName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.751 -0400", hash_original_method = "E1B7B8528643A3D2F3F6DEB0DC0DE82B", hash_generated_method = "38D8E83C4AF186DD5BE43222486DE014")
    public  PackageStats(Parcel source) {
        packageName = source.readString();
        codeSize = source.readLong();
        dataSize = source.readLong();
        cacheSize = source.readLong();
        externalCodeSize = source.readLong();
        externalDataSize = source.readLong();
        externalCacheSize = source.readLong();
        externalMediaSize = source.readLong();
        externalObbSize = source.readLong();
        // ---------- Original Method ----------
        //packageName = source.readString();
        //codeSize = source.readLong();
        //dataSize = source.readLong();
        //cacheSize = source.readLong();
        //externalCodeSize = source.readLong();
        //externalDataSize = source.readLong();
        //externalCacheSize = source.readLong();
        //externalMediaSize = source.readLong();
        //externalObbSize = source.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.752 -0400", hash_original_method = "76B9ED0D503382CF56099B23CB24204B", hash_generated_method = "15A36E5CA7C5CF35D892A2F78CABCCD6")
    public  PackageStats(PackageStats pStats) {
        packageName = pStats.packageName;
        codeSize = pStats.codeSize;
        dataSize = pStats.dataSize;
        cacheSize = pStats.cacheSize;
        externalCodeSize = pStats.externalCodeSize;
        externalDataSize = pStats.externalDataSize;
        externalCacheSize = pStats.externalCacheSize;
        externalMediaSize = pStats.externalMediaSize;
        externalObbSize = pStats.externalObbSize;
        // ---------- Original Method ----------
        //packageName = pStats.packageName;
        //codeSize = pStats.codeSize;
        //dataSize = pStats.dataSize;
        //cacheSize = pStats.cacheSize;
        //externalCodeSize = pStats.externalCodeSize;
        //externalDataSize = pStats.externalDataSize;
        //externalCacheSize = pStats.externalCacheSize;
        //externalMediaSize = pStats.externalMediaSize;
        //externalObbSize = pStats.externalObbSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.754 -0400", hash_original_method = "3FE5C26F51751E2E83526086B9D94747", hash_generated_method = "98FAD9BEC91292DEF74C4DDE0472F8A5")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_651445284 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_651445284 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_651445284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_651445284;
        // ---------- Original Method ----------
        //final StringBuilder sb = new StringBuilder("PackageStats{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(" packageName=");
        //sb.append(packageName);
        //sb.append(",codeSize=");
        //sb.append(codeSize);
        //sb.append(",dataSize=");
        //sb.append(dataSize);
        //sb.append(",cacheSize=");
        //sb.append(cacheSize);
        //sb.append(",externalCodeSize=");
        //sb.append(externalCodeSize);
        //sb.append(",externalDataSize=");
        //sb.append(externalDataSize);
        //sb.append(",externalCacheSize=");
        //sb.append(externalCacheSize);
        //sb.append(",externalMediaSize=");
        //sb.append(externalMediaSize);
        //sb.append(",externalObbSize=");
        //sb.append(externalObbSize);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.755 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0B2BE319D9C26F556EB1CB2753E5DBF8")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1226267390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1226267390;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.755 -0400", hash_original_method = "458D37590174ACFE991A170204705742", hash_generated_method = "1293D525D489E831069FA484E3A82732")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeString(packageName);
        dest.writeLong(codeSize);
        dest.writeLong(dataSize);
        dest.writeLong(cacheSize);
        dest.writeLong(externalCodeSize);
        dest.writeLong(externalDataSize);
        dest.writeLong(externalCacheSize);
        dest.writeLong(externalMediaSize);
        dest.writeLong(externalObbSize);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        //dest.writeString(packageName);
        //dest.writeLong(codeSize);
        //dest.writeLong(dataSize);
        //dest.writeLong(cacheSize);
        //dest.writeLong(externalCodeSize);
        //dest.writeLong(externalDataSize);
        //dest.writeLong(externalCacheSize);
        //dest.writeLong(externalMediaSize);
        //dest.writeLong(externalObbSize);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.756 -0400", hash_original_field = "A51559A5F0F1A83FF690A9B06BA373A2", hash_generated_field = "F7104BE96BB04B81156FA1552CDC726B")

    public static final Parcelable.Creator<PackageStats> CREATOR
            = new Parcelable.Creator<PackageStats>() {
        public PackageStats createFromParcel(Parcel in) {
            return new PackageStats(in);
        }

        public PackageStats[] newArray(int size) {
            return new PackageStats[size];
        }
    };
    // orphaned legacy method
    public PackageStats createFromParcel(Parcel in) {
            return new PackageStats(in);
        }
    
    // orphaned legacy method
    public PackageStats[] newArray(int size) {
            return new PackageStats[size];
        }
    
}

