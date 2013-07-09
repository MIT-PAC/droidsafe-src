package android.accounts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import android.text.TextUtils;

public class Account implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.489 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.490 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7BA709B14E744AD5C81755E81EB9D05D")

    public String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.495 -0400", hash_original_method = "92321A38B636724882B81077847DFFEE", hash_generated_method = "1436C6EE64C39F41AC213CD8C4B4DD8C")
    public  Account(String name, String type) {
        {
            boolean var20958AB9F43FCE73F57B67FEC400CD27_2053296140 = (TextUtils.isEmpty(name));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the name must not be empty: " + name);
            } 
        } 
        {
            boolean varB05F7C75ECFE46FC60698365AAC00CA6_1531146736 = (TextUtils.isEmpty(type));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the type must not be empty: " + type);
            } 
        } 
        this.name = name;
        this.type = type;
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.498 -0400", hash_original_method = "634539653E1462125AEF6C008057544F", hash_generated_method = "AB670C373627CC667B25B3C5CC45E291")
    public  Account(Parcel in) {
        this.name = in.readString();
        this.type = in.readString();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.500 -0400", hash_original_method = "8952178E80D6EF68D44FC6803A31AC53", hash_generated_method = "913BF5B7F1740E802E47D82D7614E889")
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1829317292 = (o == this);
        } 
        final Account other = (Account)o;
        boolean varA627E7149C202EA55E7DC204D03D4078_2031403587 = (name.equals(other.name) && type.equals(other.type));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695045207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695045207;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.502 -0400", hash_original_method = "2D8E3835F41EEE5A0134485B603913A1", hash_generated_method = "6969A16F28CCC4E79A0E7EF3D6DF5E29")
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505919523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505919523;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.504 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B922ABEBC8A087ED72678DFB9CEE1ADB")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_640455830 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_640455830;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.507 -0400", hash_original_method = "5E35BE18734E956B072A3A591EB1639E", hash_generated_method = "E24DB261C0D94B6DA031A4CC560D320B")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.511 -0400", hash_original_method = "E40D22A387A231E7FC5FB70BCBB60906", hash_generated_method = "3DF465C7E2D2FADB55007A4D795B72A2")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_410468294 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_410468294 = "Account {name=" + name + ", type=" + type + "}";
        varB4EAC82CA7396A68D541C85D26508E83_410468294.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_410468294;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.511 -0400", hash_original_field = "DE2599644EF9112EA03F6AEF302C05E0", hash_generated_field = "E8FF743E340A29709E9F49FE249853DC")

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        public Account createFromParcel(Parcel source) {
            return new Account(source);
        }

        public Account[] newArray(int size) {
            return new Account[size];
        }
    };
    
    public Account createFromParcel(Parcel source) {
            return new Account(source);
        }
    
    
    public Account[] newArray(int size) {
            return new Account[size];
        }
    
}

