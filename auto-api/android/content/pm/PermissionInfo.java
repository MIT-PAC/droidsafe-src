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

public class PermissionInfo extends PackageItemInfo implements Parcelable {
    public String group;
    public int descriptionRes;
    public CharSequence nonLocalizedDescription;
    public int protectionLevel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.731 -0400", hash_original_method = "4363F86D103EC845B9204173BA7C251E", hash_generated_method = "919AEC380A87E0C9D5318078288ABD70")
    @DSModeled(DSC.SAFE)
    public PermissionInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.732 -0400", hash_original_method = "64C8DADAA6D1A83E089E968A1FA0F105", hash_generated_method = "F960661948E9837590537E44A9885C94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PermissionInfo(PermissionInfo orig) {
        super(orig);
        dsTaint.addTaint(orig.dsTaint);
        group = orig.group;
        descriptionRes = orig.descriptionRes;
        protectionLevel = orig.protectionLevel;
        nonLocalizedDescription = orig.nonLocalizedDescription;
        // ---------- Original Method ----------
        //group = orig.group;
        //descriptionRes = orig.descriptionRes;
        //protectionLevel = orig.protectionLevel;
        //nonLocalizedDescription = orig.nonLocalizedDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.732 -0400", hash_original_method = "B4E7B82E4C24C37709BA1B06DE1A7578", hash_generated_method = "67DE5E0A4F08B36029D905D4787603FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private PermissionInfo(Parcel source) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
        group = source.readString();
        descriptionRes = source.readInt();
        protectionLevel = source.readInt();
        nonLocalizedDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        // ---------- Original Method ----------
        //group = source.readString();
        //descriptionRes = source.readInt();
        //protectionLevel = source.readInt();
        //nonLocalizedDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.733 -0400", hash_original_method = "EA6AC5CC522A2884BAFD1D1CC4525D81", hash_generated_method = "3CAADC11D089FD537440DDDB84E66E99")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.733 -0400", hash_original_method = "07D30C0CB33D6CDA9C3B1D51B29A13B5", hash_generated_method = "5AF57CE756571D0AF965BB8A565E6EF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varF915F0B80CDD6B91AE810422947D26F1_1625747104 = ("PermissionInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "PermissionInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + name + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.733 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.734 -0400", hash_original_method = "1534C59E913BA20826F4978690F40C01", hash_generated_method = "415D5E2E3E01ECA94A1B6EF6AD053094")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(group);
        dest.writeInt(descriptionRes);
        dest.writeInt(protectionLevel);
        TextUtils.writeToParcel(nonLocalizedDescription, dest, parcelableFlags);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //dest.writeString(group);
        //dest.writeInt(descriptionRes);
        //dest.writeInt(protectionLevel);
        //TextUtils.writeToParcel(nonLocalizedDescription, dest, parcelableFlags);
    }

    
    public static final int PROTECTION_NORMAL = 0;
    public static final int PROTECTION_DANGEROUS = 1;
    public static final int PROTECTION_SIGNATURE = 2;
    public static final int PROTECTION_SIGNATURE_OR_SYSTEM = 3;
    public static final Creator<PermissionInfo> CREATOR = new Creator<PermissionInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.734 -0400", hash_original_method = "CE272AA0F393607C7BD51E233995C9B9", hash_generated_method = "CA014855B2AD8CBA274DEF828F25E387")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PermissionInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            PermissionInfo varC713CE50F727F3400ADF124595C6B0E3_820016265 = (new PermissionInfo(source));
            return (PermissionInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PermissionInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.734 -0400", hash_original_method = "F50F017196AA55C30F890E5CC032DF70", hash_generated_method = "13397F7AAC18B4C402400C42ADA40A20")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PermissionInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            PermissionInfo[] varF491FCA83F5AD6516492ECEF0EB789B4_1109731114 = (new PermissionInfo[size]);
            return (PermissionInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PermissionInfo[size];
        }

        
}; //Transformed anonymous class
}

