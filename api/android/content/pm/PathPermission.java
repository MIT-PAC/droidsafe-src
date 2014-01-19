package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PatternMatcher;

public class PathPermission extends PatternMatcher {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.340 -0400", hash_original_field = "BF769DDFB95FE3C86E626C9171120430", hash_generated_field = "B147657571B9F640821DBBF9A7AC44F7")

    public static final Parcelable.Creator<PathPermission> CREATOR
            = new Parcelable.Creator<PathPermission>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.997 -0500", hash_original_method = "FB68BFC6586F43B368BF10107C1ED83E", hash_generated_method = "1AFC65BC869A1C74AF5325F225D8D2A3")
        
public PathPermission createFromParcel(Parcel source) {
            return new PathPermission(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:45.001 -0500", hash_original_method = "53F8BB5AC790624D851E4D5B8884399B", hash_generated_method = "9966AF1B24F7E0D45142EB8EC280426F")
        
public PathPermission[] newArray(int size) {
            return new PathPermission[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.981 -0500", hash_original_field = "0B7B2AB1443DB02C5890E2A60E4ADF39", hash_generated_field = "F91CBC541AE5EA168107190D1A494CD8")

    private  String mReadPermission;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.983 -0500", hash_original_field = "0AE0E3A6ECCA53A0F777E2FEEBA3D79B", hash_generated_field = "02101D3B9ECFAAEB0689EF2DAEF4A808")

    private  String mWritePermission;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.986 -0500", hash_original_method = "79E6B4567C92E932C6F7E4E0D19FFE51", hash_generated_method = "6CE757ADE8AA5E946B49EDCD194587C1")
    
public PathPermission(String pattern, int type, String readPermission,
            String writePermission) {
        super(pattern, type);
        mReadPermission = readPermission;
        mWritePermission = writePermission;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.994 -0500", hash_original_method = "385FCFD08A13461BC5260866E3C7CF08", hash_generated_method = "2ECA0C618A6CCE7D0BBA9855CAC9E069")
    
public PathPermission(Parcel src) {
        super(src);
        mReadPermission = src.readString();
        mWritePermission = src.readString();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.988 -0500", hash_original_method = "5C94FD95ADD3C0054247C1BF6F500E4F", hash_generated_method = "51517C7BA362FC46CE56AE764CAB5F71")
    
public String getReadPermission() {
        return mReadPermission;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.990 -0500", hash_original_method = "7A0A16A9FA1EB10AD9D087C65A3EFFB1", hash_generated_method = "CC80FDFE5D30AF8A14D1012901637902")
    
public String getWritePermission() {
        return mWritePermission;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.992 -0500", hash_original_method = "A803A7F07F4B7A6BE15492168684C07E", hash_generated_method = "397179D0EDBE16AA1688D152E8124F9C")
    
public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(mReadPermission);
        dest.writeString(mWritePermission);
    }
    // orphaned legacy method
    public PathPermission createFromParcel(Parcel source) {
            return new PathPermission(source);
        }
    
    // orphaned legacy method
    public PathPermission[] newArray(int size) {
            return new PathPermission[size];
        }
    
}

