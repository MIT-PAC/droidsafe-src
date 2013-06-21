package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class PermissionGroupInfo extends PackageItemInfo implements Parcelable {
    public int descriptionRes;
    public CharSequence nonLocalizedDescription;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.723 -0400", hash_original_method = "82344B3D2D2745586AE3E2C39F67E56D", hash_generated_method = "C344FD7EBA0ACA0405579BE9BC8FB4E5")
    @DSModeled(DSC.SAFE)
    public PermissionGroupInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.723 -0400", hash_original_method = "86BDB0F775205D222755746395606069", hash_generated_method = "A7C3C3782EFD92FB3BEB478BA67709BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PermissionGroupInfo(PermissionGroupInfo orig) {
        super(orig);
        dsTaint.addTaint(orig.dsTaint);
        descriptionRes = orig.descriptionRes;
        nonLocalizedDescription = orig.nonLocalizedDescription;
        // ---------- Original Method ----------
        //descriptionRes = orig.descriptionRes;
        //nonLocalizedDescription = orig.nonLocalizedDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.723 -0400", hash_original_method = "251C6C67446670431867B6BD14427B23", hash_generated_method = "53AF4D8DCFD78624E2E2AD7081BE834F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private PermissionGroupInfo(Parcel source) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
        descriptionRes = source.readInt();
        nonLocalizedDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        // ---------- Original Method ----------
        //descriptionRes = source.readInt();
        //nonLocalizedDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.724 -0400", hash_original_method = "EA6AC5CC522A2884BAFD1D1CC4525D81", hash_generated_method = "3CAADC11D089FD537440DDDB84E66E99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence loadDescription(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        {
            CharSequence label;
            label = pm.getText(packageName, descriptionRes, null);
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.724 -0400", hash_original_method = "712313A7FB39E8068296CCC509012BB3", hash_generated_method = "CC95222E46DC7D23EB81FBC5913C7A9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var8AC2E9E0E8A492DB25B79D9659A141B7_132867885 = ("PermissionGroupInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "PermissionGroupInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + name + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.724 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.724 -0400", hash_original_method = "48DC2E300D4B0399A780C6669617C26B", hash_generated_method = "475A68EDC93C2FB562394D996DBDA120")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        super.writeToParcel(dest, parcelableFlags);
        dest.writeInt(descriptionRes);
        TextUtils.writeToParcel(nonLocalizedDescription, dest, parcelableFlags);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //dest.writeInt(descriptionRes);
        //TextUtils.writeToParcel(nonLocalizedDescription, dest, parcelableFlags);
    }

    
    public static final Creator<PermissionGroupInfo> CREATOR = new Creator<PermissionGroupInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.725 -0400", hash_original_method = "187B40B88C67C0925A9FFCFB53E91019", hash_generated_method = "6E6F7D9B8A16DE743B70C4F108138E74")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PermissionGroupInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            PermissionGroupInfo var6527F6BC5300B9194A9B1B5D5C34E68D_1431361630 = (new PermissionGroupInfo(source));
            return (PermissionGroupInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PermissionGroupInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.725 -0400", hash_original_method = "E8CF26CD838EA459740518D5D22D5674", hash_generated_method = "05D83CA6F6038DA831396B8A3D5AEB58")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PermissionGroupInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            PermissionGroupInfo[] var606601EF81C1D862DFBBEA6F93B6413D_1233978608 = (new PermissionGroupInfo[size]);
            return (PermissionGroupInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PermissionGroupInfo[size];
        }

        
}; //Transformed anonymous class
}

