package android.content.pm;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;





public class PermissionGroupInfo extends PackageItemInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.361 -0400", hash_original_field = "392A6E47A749448B7E51283719BBB183", hash_generated_field = "7C42762252277BD13653A4A0CE44470E")

    public int descriptionRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.361 -0400", hash_original_field = "F132344C9D3F23D988965BDF2FE9E96E", hash_generated_field = "DC8641D3F3115BD1A7EE01A008EB7DE8")

    public CharSequence nonLocalizedDescription;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.362 -0400", hash_original_method = "82344B3D2D2745586AE3E2C39F67E56D", hash_generated_method = "C344FD7EBA0ACA0405579BE9BC8FB4E5")
    public  PermissionGroupInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.362 -0400", hash_original_method = "86BDB0F775205D222755746395606069", hash_generated_method = "9E42539179CB72B7DF3C7D104B792B22")
    public  PermissionGroupInfo(PermissionGroupInfo orig) {
        super(orig);
        descriptionRes = orig.descriptionRes;
        nonLocalizedDescription = orig.nonLocalizedDescription;
        // ---------- Original Method ----------
        //descriptionRes = orig.descriptionRes;
        //nonLocalizedDescription = orig.nonLocalizedDescription;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.363 -0400", hash_original_method = "251C6C67446670431867B6BD14427B23", hash_generated_method = "C80CEF62BF9EA33C58DF216289241944")
    private  PermissionGroupInfo(Parcel source) {
        super(source);
        descriptionRes = source.readInt();
        nonLocalizedDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        // ---------- Original Method ----------
        //descriptionRes = source.readInt();
        //nonLocalizedDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.363 -0400", hash_original_method = "EA6AC5CC522A2884BAFD1D1CC4525D81", hash_generated_method = "35469AB60993437E3B6B258C79050CB5")
    public CharSequence loadDescription(PackageManager pm) {
        addTaint(pm.getTaint());
        if(nonLocalizedDescription != null)        
        {
CharSequence var755997E6D6993799464A90913EEFCB50_989682862 =             nonLocalizedDescription;
            var755997E6D6993799464A90913EEFCB50_989682862.addTaint(taint);
            return var755997E6D6993799464A90913EEFCB50_989682862;
        } //End block
        if(descriptionRes != 0)        
        {
            CharSequence label = pm.getText(packageName, descriptionRes, null);
            if(label != null)            
            {
CharSequence var057F26F90053C562EFC08298AB91C2B1_352718872 =                 label;
                var057F26F90053C562EFC08298AB91C2B1_352718872.addTaint(taint);
                return var057F26F90053C562EFC08298AB91C2B1_352718872;
            } //End block
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_559675577 =         null;
        var540C13E9E156B687226421B24F2DF178_559675577.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_559675577;
        // ---------- Original Method ----------
        //if (nonLocalizedDescription != null) {
            //return nonLocalizedDescription;
        //}
        //if (descriptionRes != 0) {
            //CharSequence label = pm.getText(packageName, descriptionRes, null);
            //if (label != null) {
                //return label;
            //}
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.364 -0400", hash_original_method = "712313A7FB39E8068296CCC509012BB3", hash_generated_method = "6D3575E6BA0D1D85C6C2C09E72C62F74")
    public String toString() {
String var72C53EB254ECB0D5467E66B7861D8A47_42115256 =         "PermissionGroupInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
        var72C53EB254ECB0D5467E66B7861D8A47_42115256.addTaint(taint);
        return var72C53EB254ECB0D5467E66B7861D8A47_42115256;
        // ---------- Original Method ----------
        //return "PermissionGroupInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + name + "}";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.365 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DFF939DCCC09F0651E19D889008BE857")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1505710774 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479329115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479329115;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.366 -0400", hash_original_method = "48DC2E300D4B0399A780C6669617C26B", hash_generated_method = "25532DCD1CD2ABDC6ADF32E8EDBE867D")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
        super.writeToParcel(dest, parcelableFlags);
        dest.writeInt(descriptionRes);
        TextUtils.writeToParcel(nonLocalizedDescription, dest, parcelableFlags);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //dest.writeInt(descriptionRes);
        //TextUtils.writeToParcel(nonLocalizedDescription, dest, parcelableFlags);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.367 -0400", hash_original_field = "C5F42F5EC446394F1B5E3897D28E68B6", hash_generated_field = "157E7C3FA4773BF05F9A4ED13A8D2703")

    public static final Creator<PermissionGroupInfo> CREATOR =
            new Creator<PermissionGroupInfo>() {
        public PermissionGroupInfo createFromParcel(Parcel source) {
            return new PermissionGroupInfo(source);
        }
        @DSModeled(DSC.SAFE)
        public PermissionGroupInfo[] newArray(int size) {
            return new PermissionGroupInfo[size];
        }
    };
    // orphaned legacy method
    public PermissionGroupInfo createFromParcel(Parcel source) {
            return new PermissionGroupInfo(source);
        }
    
    // orphaned legacy method
    public PermissionGroupInfo[] newArray(int size) {
            return new PermissionGroupInfo[size];
        }
    
}

