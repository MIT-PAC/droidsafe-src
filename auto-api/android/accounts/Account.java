package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import android.text.TextUtils;

public class Account implements Parcelable {
    public String name;
    public String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:18.886 -0400", hash_original_method = "92321A38B636724882B81077847DFFEE", hash_generated_method = "D59B23D41497A2A3AD3729913D33E81B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Account(String name, String type) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(type);
        {
            boolean var20958AB9F43FCE73F57B67FEC400CD27_1426520970 = (TextUtils.isEmpty(name));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the name must not be empty: " + name);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB05F7C75ECFE46FC60698365AAC00CA6_119007259 = (TextUtils.isEmpty(type));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the type must not be empty: " + type);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(name)) {
            //throw new IllegalArgumentException("the name must not be empty: " + name);
        //}
        //if (TextUtils.isEmpty(type)) {
            //throw new IllegalArgumentException("the type must not be empty: " + type);
        //}
        //this.name = name;
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:18.898 -0400", hash_original_method = "634539653E1462125AEF6C008057544F", hash_generated_method = "19C33CF0DB24520D910A952A8C9382AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Account(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        this.name = in.readString();
        this.type = in.readString();
        // ---------- Original Method ----------
        //this.name = in.readString();
        //this.type = in.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:18.902 -0400", hash_original_method = "8952178E80D6EF68D44FC6803A31AC53", hash_generated_method = "40D31DD242FEF20E951954EC57F8E5AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_695625019 = (o == this);
        } //End collapsed parenthetic
        Account other;
        other = (Account)o;
        boolean varA627E7149C202EA55E7DC204D03D4078_624145482 = (name.equals(other.name) && type.equals(other.type));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof Account)) return false;
        //final Account other = (Account)o;
        //return name.equals(other.name) && type.equals(other.type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:18.904 -0400", hash_original_method = "2D8E3835F41EEE5A0134485B603913A1", hash_generated_method = "FFC121C1710EA0364086712288E31BEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + name.hashCode();
        //result = 31 * result + type.hashCode();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:18.905 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:18.906 -0400", hash_original_method = "5E35BE18734E956B072A3A591EB1639E", hash_generated_method = "424646F4EB112F7D5CF87F8A46840407")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(name);
        dest.writeString(type);
        // ---------- Original Method ----------
        //dest.writeString(name);
        //dest.writeString(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:18.922 -0400", hash_original_method = "E40D22A387A231E7FC5FB70BCBB60906", hash_generated_method = "ED5FD5880150F2E204F4E39252679F66")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Account {name=" + name + ", type=" + type + "}";
    }

    
    public static final Creator<Account> CREATOR = new Creator<Account>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:18.924 -0400", hash_original_method = "71E28F2FAFB9F3EEB2F3FA6DF61F882A", hash_generated_method = "A02BC790421E01782106CFBE60DF8CA5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Account createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            Account var18FF73798169BB6FBA92EA163B8002C8_945975422 = (new Account(source));
            return (Account)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Account(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:18.925 -0400", hash_original_method = "0C51DAE4A68DBFF5A186B7DE414E81B4", hash_generated_method = "1C32AFDC7CF591294AA65B58D721F978")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Account[] newArray(int size) {
            dsTaint.addTaint(size);
            Account[] varC0C5F88D82E8E7C51F3EE88EECD81F02_1474596814 = (new Account[size]);
            return (Account[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Account[size];
        }

        
}; //Transformed anonymous class
}

