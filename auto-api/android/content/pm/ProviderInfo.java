package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @Deprecated public boolean isSyncable = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.744 -0400", hash_original_method = "D2CF667D6D9DF94B5D6BB6106BFAE873", hash_generated_method = "B4804D482B030CB842C9B23FD5E0D5C4")
    @DSModeled(DSC.SAFE)
    public ProviderInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.745 -0400", hash_original_method = "DA84A5BF345E5B845C3AEBDD1FA39C20", hash_generated_method = "834B3F102AB29CDB92FAD947A4A5F5A3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.745 -0400", hash_original_method = "CB7E407C3FF25BE7AFF90A1406ACF604", hash_generated_method = "37FCCCB5BF9E67F506A4FE2CD195A1C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.745 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.746 -0400", hash_original_method = "45D9E31DA8DC0720E2897CA268CD8E20", hash_generated_method = "4F3C30464D453C9B96AC9586BCB2D117")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.746 -0400", hash_original_method = "A325E506B6C78D4488CEDF60427F48B5", hash_generated_method = "2188B34DEBFCFE8E9A0D711EDA7F21A9")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ContentProviderInfo{name=" + authority + " className=" + name
            //+ " isSyncable=" + (isSyncable ? "true" : "false") + "}";
    }

    
    public static final Parcelable.Creator<ProviderInfo> CREATOR = new Parcelable.Creator<ProviderInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.746 -0400", hash_original_method = "C62C06CA4B676C4392CBE3A91D8CB99D", hash_generated_method = "63F78BC6AF7C79003D608B456653847B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ProviderInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            ProviderInfo var18E1FA2580DDCACCC938EBF7E746A65E_1279737384 = (new ProviderInfo(in));
            return (ProviderInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ProviderInfo(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.747 -0400", hash_original_method = "65FE25EE19B08643F769A1C6FE95936E", hash_generated_method = "095CF1DEE3E9335A4F50DACB1307EEB4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ProviderInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            ProviderInfo[] var7EEB4E4D188B2CE95D7024B302F95274_1530299015 = (new ProviderInfo[size]);
            return (ProviderInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ProviderInfo[size];
        }

        
}; //Transformed anonymous class
}

