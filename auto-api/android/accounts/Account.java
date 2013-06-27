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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:42.869 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:43.020 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7BA709B14E744AD5C81755E81EB9D05D")

    public String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:43.075 -0400", hash_original_method = "92321A38B636724882B81077847DFFEE", hash_generated_method = "5E9DB0EE1550B969F421B6010EE57883")
    public  Account(String name, String type) {
        {
            boolean var20958AB9F43FCE73F57B67FEC400CD27_1552436298 = (TextUtils.isEmpty(name));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the name must not be empty: " + name);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB05F7C75ECFE46FC60698365AAC00CA6_1637861214 = (TextUtils.isEmpty(type));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the type must not be empty: " + type);
            } //End block
        } //End collapsed parenthetic
        this.name = name;
        this.type = type;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:43.132 -0400", hash_original_method = "634539653E1462125AEF6C008057544F", hash_generated_method = "AB670C373627CC667B25B3C5CC45E291")
    public  Account(Parcel in) {
        this.name = in.readString();
        this.type = in.readString();
        // ---------- Original Method ----------
        //this.name = in.readString();
        //this.type = in.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:43.289 -0400", hash_original_method = "8952178E80D6EF68D44FC6803A31AC53", hash_generated_method = "1E28643F947CDF664525F098982AEBB7")
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_341782559 = (o == this);
        } //End collapsed parenthetic
        Account other;
        other = (Account)o;
        boolean varA627E7149C202EA55E7DC204D03D4078_929357930 = (name.equals(other.name) && type.equals(other.type));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779835271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779835271;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof Account)) return false;
        //final Account other = (Account)o;
        //return name.equals(other.name) && type.equals(other.type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:43.382 -0400", hash_original_method = "2D8E3835F41EEE5A0134485B603913A1", hash_generated_method = "070A34F634558882FC12AAA817654180")
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73559902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73559902;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + name.hashCode();
        //result = 31 * result + type.hashCode();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:43.445 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "79F1B7DA8532A1AF8DF9BA22E810B6F6")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521262518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521262518;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:43.479 -0400", hash_original_method = "5E35BE18734E956B072A3A591EB1639E", hash_generated_method = "E24DB261C0D94B6DA031A4CC560D320B")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeString(name);
        //dest.writeString(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:43.524 -0400", hash_original_method = "E40D22A387A231E7FC5FB70BCBB60906", hash_generated_method = "1B8C4A8D6C77A68838131B757C2A69FC")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_277132511 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_277132511 = "Account {name=" + name + ", type=" + type + "}";
        varB4EAC82CA7396A68D541C85D26508E83_277132511.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_277132511;
        // ---------- Original Method ----------
        //return "Account {name=" + name + ", type=" + type + "}";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:43.536 -0400", hash_original_field = "DE2599644EF9112EA03F6AEF302C05E0", hash_generated_field = "E8FF743E340A29709E9F49FE249853DC")

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        public Account createFromParcel(Parcel source) {
            return new Account(source);
        }

        public Account[] newArray(int size) {
            return new Account[size];
        }
    };
}

