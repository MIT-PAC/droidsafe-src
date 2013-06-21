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
    public String packageName;
    public long codeSize;
    public long dataSize;
    public long cacheSize;
    public long externalCodeSize;
    public long externalDataSize;
    public long externalCacheSize;
    public long externalMediaSize;
    public long externalObbSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.686 -0400", hash_original_method = "737D88E00D7006B4B823AA249FAC1157", hash_generated_method = "BE4FF2363C75ED8CF2A2F1E7B1078740")
    @DSModeled(DSC.SAFE)
    public PackageStats(String pkgName) {
        dsTaint.addTaint(pkgName);
        // ---------- Original Method ----------
        //packageName = pkgName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.687 -0400", hash_original_method = "E1B7B8528643A3D2F3F6DEB0DC0DE82B", hash_generated_method = "CC4C44AEE6D7916FE249F76D89F5ED6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PackageStats(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.688 -0400", hash_original_method = "76B9ED0D503382CF56099B23CB24204B", hash_generated_method = "216AC3D594559C943B8F56B155312BA1")
    @DSModeled(DSC.SAFE)
    public PackageStats(PackageStats pStats) {
        dsTaint.addTaint(pStats.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.688 -0400", hash_original_method = "3FE5C26F51751E2E83526086B9D94747", hash_generated_method = "02503FE48A2A58ABAAA84C9D821598BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder("PackageStats{");
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
        String var806458D832AB974D230FEE4CBBDBD390_2053781540 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.689 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.690 -0400", hash_original_method = "458D37590174ACFE991A170204705742", hash_generated_method = "F98652F9BA33E6E749D88CF882A9DC2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(packageName);
        dest.writeLong(codeSize);
        dest.writeLong(dataSize);
        dest.writeLong(cacheSize);
        dest.writeLong(externalCodeSize);
        dest.writeLong(externalDataSize);
        dest.writeLong(externalCacheSize);
        dest.writeLong(externalMediaSize);
        dest.writeLong(externalObbSize);
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

    
    public static final Parcelable.Creator<PackageStats> CREATOR = new Parcelable.Creator<PackageStats>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.690 -0400", hash_original_method = "58C55B3A1DD51A94C15BFC575DA60AB7", hash_generated_method = "599620342E58D8E5C3C8773156A5E298")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PackageStats createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            PackageStats varC14CC22A647F83076929ECFC4E6094D2_1913983982 = (new PackageStats(in));
            return (PackageStats)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PackageStats(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.690 -0400", hash_original_method = "FE2D27470FD9E0515CB0D65ED612B641", hash_generated_method = "B22F4D94B59EA378EC881B2B76940A1E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PackageStats[] newArray(int size) {
            dsTaint.addTaint(size);
            PackageStats[] var6C330A91BC66BA43FB46155E3D7A606B_1177038423 = (new PackageStats[size]);
            return (PackageStats[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PackageStats[size];
        }

        
}; //Transformed anonymous class
}

