package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PatternMatcher;

public final class ProviderInfo extends ComponentInfo implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.436 -0400", hash_original_field = "DD4D4FCA6B950B464A88C210AA1AB627", hash_generated_field = "1363713E47A8A9D4D7DB3FBE464E5623")

    public static final Parcelable.Creator<ProviderInfo> CREATOR
            = new Parcelable.Creator<ProviderInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.944 -0500", hash_original_method = "C62C06CA4B676C4392CBE3A91D8CB99D", hash_generated_method = "4BDCFD95CDE2CC4DED8022218C6A8AF6")
        
public ProviderInfo createFromParcel(Parcel in) {
            return new ProviderInfo(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.946 -0500", hash_original_method = "65FE25EE19B08643F769A1C6FE95936E", hash_generated_method = "D62D1833707359A31D443B02807AB7C4")
        
public ProviderInfo[] newArray(int size) {
            return new ProviderInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.914 -0500", hash_original_field = "5CB89DEFC0E06A783678A12F4D2A60D5", hash_generated_field = "3E8DB1403D91FD0BC10BCD6D25011DA7")

    public String authority = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.916 -0500", hash_original_field = "3470F7775696B625F043A8AC70270D1A", hash_generated_field = "9B89113FCF6DD9BBF615592F5D6A3B73")

    public String readPermission = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.919 -0500", hash_original_field = "16B2359BBE710BD4615CCB6E3C02C0F6", hash_generated_field = "A4D20C3E8A767EF2CA4C9C700A2F0207")

    public String writePermission = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.921 -0500", hash_original_field = "8B3B1CA898A6F45FCD9FFD6D9D4A2755", hash_generated_field = "CDABD162A8569AAE60DF4B0548E21087")

    public boolean grantUriPermissions = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.923 -0500", hash_original_field = "55CB269F16A5D5D15DC866A850DC9FEA", hash_generated_field = "668190D0BDFB4201C777E7488D9B60FB")

    public PatternMatcher[] uriPermissionPatterns = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.925 -0500", hash_original_field = "DDBE329D79686821D356BE75B3CE58CD", hash_generated_field = "6CB2C41C003C5C1EF2087EC1A83FE499")

    public PathPermission[] pathPermissions = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.927 -0500", hash_original_field = "E6F714570A3CB2CE350C22A4E1D802C7", hash_generated_field = "0415CF4582A07E809068F3B939A342D9")

    public boolean multiprocess = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.929 -0500", hash_original_field = "45BFE17EE81AE8C8399D3A8142BFA581", hash_generated_field = "DA766FF90FD83CA9F7F97BA699F1D548")

    public int initOrder = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.931 -0500", hash_original_field = "B51BF602CD2EAFB7366AD60062F5374C", hash_generated_field = "FCC5D6A5DC69BB5AD4BD4634F8A5A256")

    @Deprecated
    public boolean isSyncable = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.934 -0500", hash_original_method = "D2CF667D6D9DF94B5D6BB6106BFAE873", hash_generated_method = "0D59BDF800C0AC4F938F8BD4F941FEB2")
    
public ProviderInfo() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.937 -0500", hash_original_method = "DA84A5BF345E5B845C3AEBDD1FA39C20", hash_generated_method = "3F965C3CA2F938CF41B57103DC8404E6")
    
public ProviderInfo(ProviderInfo orig) {
        super(orig);
        authority = orig.authority;
        readPermission = orig.readPermission;
        writePermission = orig.writePermission;
        grantUriPermissions = orig.grantUriPermissions;
        uriPermissionPatterns = orig.uriPermissionPatterns;
        pathPermissions = orig.pathPermissions;
        multiprocess = orig.multiprocess;
        initOrder = orig.initOrder;
        isSyncable = orig.isSyncable;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.954 -0500", hash_original_method = "CB7E407C3FF25BE7AFF90A1406ACF604", hash_generated_method = "9D052A8D6EA726EACB4803C8DD714358")
    
private ProviderInfo(Parcel in) {
        super(in);
        authority = in.readString();
        readPermission = in.readString();
        writePermission = in.readString();
        grantUriPermissions = in.readInt() != 0;
        uriPermissionPatterns = in.createTypedArray(PatternMatcher.CREATOR);
        pathPermissions = in.createTypedArray(PathPermission.CREATOR);
        multiprocess = in.readInt() != 0;
        initOrder = in.readInt();
        isSyncable = in.readInt() != 0;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.939 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.941 -0500", hash_original_method = "45D9E31DA8DC0720E2897CA268CD8E20", hash_generated_method = "73D8B8C603E33D973013EB0774B0CFD7")
    
@Override public void writeToParcel(Parcel out, int parcelableFlags) {
        super.writeToParcel(out, parcelableFlags);
        out.writeString(authority);
        out.writeString(readPermission);
        out.writeString(writePermission);
        out.writeInt(grantUriPermissions ? 1 : 0);
        out.writeTypedArray(uriPermissionPatterns, parcelableFlags);
        out.writeTypedArray(pathPermissions, parcelableFlags);
        out.writeInt(multiprocess ? 1 : 0);
        out.writeInt(initOrder);
        out.writeInt(isSyncable ? 1 : 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:48.951 -0500", hash_original_method = "A325E506B6C78D4488CEDF60427F48B5", hash_generated_method = "C3352792F703A3848CD4FF8DC864D24F")
    
public String toString() {
        return "ContentProviderInfo{name=" + authority + " className=" + name
            + " isSyncable=" + (isSyncable ? "true" : "false") + "}";
    }
    // orphaned legacy method
    public ProviderInfo createFromParcel(Parcel in) {
            return new ProviderInfo(in);
        }
    
    // orphaned legacy method
    public ProviderInfo[] newArray(int size) {
            return new ProviderInfo[size];
        }
    
}

