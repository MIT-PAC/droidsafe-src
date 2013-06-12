package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcelable;
import android.os.Parcel;
import android.text.TextUtils;

public class Account implements Parcelable {
    public final String name;
    public final String type;
    public static final Creator<Account> CREATOR = new Creator<Account>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.795 -0400", hash_original_method = "71E28F2FAFB9F3EEB2F3FA6DF61F882A", hash_generated_method = "EC95478B4169293101C90DC5A2BBF8EA")
        @DSModeled(DSC.SAFE)
        public Account createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (Account)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Account(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.795 -0400", hash_original_method = "0C51DAE4A68DBFF5A186B7DE414E81B4", hash_generated_method = "6F2FABDA0FD1C1E7A34D8A97E72F0B61")
        @DSModeled(DSC.SAFE)
        public Account[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Account[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Account[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.796 -0400", hash_original_method = "92321A38B636724882B81077847DFFEE", hash_generated_method = "7B82D30820456DEFF68ADBFD86572830")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Account(String name, String type) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(type);
        {
            boolean var20958AB9F43FCE73F57B67FEC400CD27_1500858032 = (TextUtils.isEmpty(name));
            {
                throw new IllegalArgumentException("the name must not be empty: " + name);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB05F7C75ECFE46FC60698365AAC00CA6_954121592 = (TextUtils.isEmpty(type));
            {
                throw new IllegalArgumentException("the type must not be empty: " + type);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.797 -0400", hash_original_method = "634539653E1462125AEF6C008057544F", hash_generated_method = "6C2984287DF268F00D9079A7A79C77B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Account(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        this.name = in.readString();
        this.type = in.readString();
        // ---------- Original Method ----------
        //this.name = in.readString();
        //this.type = in.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.798 -0400", hash_original_method = "8952178E80D6EF68D44FC6803A31AC53", hash_generated_method = "D44701E340941FDEA81D4114B4055C08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        final Account other;
        other = (Account)o;
        boolean varA627E7149C202EA55E7DC204D03D4078_2078100230 = (name.equals(other.name) && type.equals(other.type));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof Account)) return false;
        //final Account other = (Account)o;
        //return name.equals(other.name) && type.equals(other.type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.799 -0400", hash_original_method = "2D8E3835F41EEE5A0134485B603913A1", hash_generated_method = "AD1F345F6E7059DD4A1A52D011B1D4FE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.800 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.800 -0400", hash_original_method = "5E35BE18734E956B072A3A591EB1639E", hash_generated_method = "E471187051580C90E16386A60082D049")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeString(name);
        dest.writeString(type);
        // ---------- Original Method ----------
        //dest.writeString(name);
        //dest.writeString(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.801 -0400", hash_original_method = "E40D22A387A231E7FC5FB70BCBB60906", hash_generated_method = "AC4E3AC346927099EA8CC6465D1D0065")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Account {name=" + name + ", type=" + type + "}";
    }

    
}


