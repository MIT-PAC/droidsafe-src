package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.PatternMatcher;

public final class ProviderInfo extends ComponentInfo implements Parcelable {
    public String authority = null;
    public String readPermission = null;
    public String writePermission = null;
    public boolean grantUriPermissions = false;
    public PatternMatcher[] uriPermissionPatterns = null;
    public PathPermission[] pathPermissions = null;
    public boolean multiprocess = false;
    public int initOrder = 0;
    @Deprecated
    public boolean isSyncable = false;
    public static final Parcelable.Creator<ProviderInfo> CREATOR = new Parcelable.Creator<ProviderInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.140 -0400", hash_original_method = "C62C06CA4B676C4392CBE3A91D8CB99D", hash_generated_method = "C78A1D567EB50D4028FFF355D591A6E6")
        @DSModeled(DSC.SAFE)
        public ProviderInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            return (ProviderInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ProviderInfo(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.140 -0400", hash_original_method = "65FE25EE19B08643F769A1C6FE95936E", hash_generated_method = "B4233D783D63DBDCAA003B78400DA9E5")
        @DSModeled(DSC.SAFE)
        public ProviderInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ProviderInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ProviderInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.140 -0400", hash_original_method = "D2CF667D6D9DF94B5D6BB6106BFAE873", hash_generated_method = "03BF0A64186FE664C4CBA47331CC63E3")
    @DSModeled(DSC.SAFE)
    public ProviderInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.140 -0400", hash_original_method = "DA84A5BF345E5B845C3AEBDD1FA39C20", hash_generated_method = "FDB4D6B545B8FA8A6FB58D621FD5BEA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProviderInfo(ProviderInfo orig) {
        super(orig);
        dsTaint.addTaint(orig.dsTaint);
        authority = orig.authority;
        readPermission = orig.readPermission;
        writePermission = orig.writePermission;
        grantUriPermissions = orig.grantUriPermissions;
        uriPermissionPatterns = orig.uriPermissionPatterns;
        pathPermissions = orig.pathPermissions;
        multiprocess = orig.multiprocess;
        initOrder = orig.initOrder;
        isSyncable = orig.isSyncable;
        // ---------- Original Method ----------
        //authority = orig.authority;
        //readPermission = orig.readPermission;
        //writePermission = orig.writePermission;
        //grantUriPermissions = orig.grantUriPermissions;
        //uriPermissionPatterns = orig.uriPermissionPatterns;
        //pathPermissions = orig.pathPermissions;
        //multiprocess = orig.multiprocess;
        //initOrder = orig.initOrder;
        //isSyncable = orig.isSyncable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.141 -0400", hash_original_method = "CB7E407C3FF25BE7AFF90A1406ACF604", hash_generated_method = "D1130B30E0C91CF3A8077F49C3EDF09A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ProviderInfo(Parcel in) {
        super(in);
        dsTaint.addTaint(in.dsTaint);
        authority = in.readString();
        readPermission = in.readString();
        writePermission = in.readString();
        grantUriPermissions = in.readInt() != 0;
        uriPermissionPatterns = in.createTypedArray(PatternMatcher.CREATOR);
        pathPermissions = in.createTypedArray(PathPermission.CREATOR);
        multiprocess = in.readInt() != 0;
        initOrder = in.readInt();
        isSyncable = in.readInt() != 0;
        // ---------- Original Method ----------
        //authority = in.readString();
        //readPermission = in.readString();
        //writePermission = in.readString();
        //grantUriPermissions = in.readInt() != 0;
        //uriPermissionPatterns = in.createTypedArray(PatternMatcher.CREATOR);
        //pathPermissions = in.createTypedArray(PathPermission.CREATOR);
        //multiprocess = in.readInt() != 0;
        //initOrder = in.readInt();
        //isSyncable = in.readInt() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.141 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.142 -0400", hash_original_method = "45D9E31DA8DC0720E2897CA268CD8E20", hash_generated_method = "E789DD146240308B7B2793F58678D669")
    @DSModeled(DSC.SAFE)
    @Override
    public void writeToParcel(Parcel out, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(out.dsTaint);
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
        // ---------- Original Method ----------
        //super.writeToParcel(out, parcelableFlags);
        //out.writeString(authority);
        //out.writeString(readPermission);
        //out.writeString(writePermission);
        //out.writeInt(grantUriPermissions ? 1 : 0);
        //out.writeTypedArray(uriPermissionPatterns, parcelableFlags);
        //out.writeTypedArray(pathPermissions, parcelableFlags);
        //out.writeInt(multiprocess ? 1 : 0);
        //out.writeInt(initOrder);
        //out.writeInt(isSyncable ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.142 -0400", hash_original_method = "A325E506B6C78D4488CEDF60427F48B5", hash_generated_method = "9F4D0D374161E8D4E84DDA5D2A845791")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ContentProviderInfo{name=" + authority + " className=" + name
            //+ " isSyncable=" + (isSyncable ? "true" : "false") + "}";
    }

    
}


