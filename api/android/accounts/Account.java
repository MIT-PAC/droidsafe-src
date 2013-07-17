package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.os.Parcel;
import android.text.TextUtils;

public class Account implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.329 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.330 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7BA709B14E744AD5C81755E81EB9D05D")

    public String type;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.334 -0400", hash_original_method = "92321A38B636724882B81077847DFFEE", hash_generated_method = "0EDD8D4E71E0B9CE1C145E3919BC6444")
    public  Account(String name, String type) {
        if(TextUtils.isEmpty(name))        
        {
            IllegalArgumentException var6C8A93341707787C8F70B85C82F20B22_749809429 = new IllegalArgumentException("the name must not be empty: " + name);
            var6C8A93341707787C8F70B85C82F20B22_749809429.addTaint(taint);
            throw var6C8A93341707787C8F70B85C82F20B22_749809429;
        } //End block
        if(TextUtils.isEmpty(type))        
        {
            IllegalArgumentException var40EC9147D99C18302F989138A88ED599_1961999576 = new IllegalArgumentException("the type must not be empty: " + type);
            var40EC9147D99C18302F989138A88ED599_1961999576.addTaint(taint);
            throw var40EC9147D99C18302F989138A88ED599_1961999576;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.337 -0400", hash_original_method = "634539653E1462125AEF6C008057544F", hash_generated_method = "AB670C373627CC667B25B3C5CC45E291")
    public  Account(Parcel in) {
        this.name = in.readString();
        this.type = in.readString();
        // ---------- Original Method ----------
        //this.name = in.readString();
        //this.type = in.readString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.342 -0400", hash_original_method = "8952178E80D6EF68D44FC6803A31AC53", hash_generated_method = "DC962DC452FF3BCB2633E350380A84A5")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1763751567 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583746027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_583746027;
        }
        if(!(o instanceof Account))        
        {
        boolean var68934A3E9455FA72420237EB05902327_968245707 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1202975391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1202975391;
        }
        final Account other = (Account)o;
        boolean var75B77C281F1EB419B1DD564900207EE6_853707540 = (name.equals(other.name) && type.equals(other.type));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2076782301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2076782301;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof Account)) return false;
        //final Account other = (Account)o;
        //return name.equals(other.name) && type.equals(other.type);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.346 -0400", hash_original_method = "2D8E3835F41EEE5A0134485B603913A1", hash_generated_method = "A713C5665E531E66B13A9AD5AA5EAB9A")
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        int varB4A88417B3D0170D754C647C30B7216A_907929847 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072573537 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072573537;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + name.hashCode();
        //result = 31 * result + type.hashCode();
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.349 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0A278AFE3E01326422F91DE7A42DC8AC")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1344128278 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309384824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309384824;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.352 -0400", hash_original_method = "5E35BE18734E956B072A3A591EB1639E", hash_generated_method = "9553A42F573EBC29D5C802031B61C868")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(name);
        dest.writeString(type);
        // ---------- Original Method ----------
        //dest.writeString(name);
        //dest.writeString(type);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.357 -0400", hash_original_method = "E40D22A387A231E7FC5FB70BCBB60906", hash_generated_method = "7C71BBFA2FD8F4757C2B78E817DB9A29")
    public String toString() {
String var88C3A4BDB947BCD23BACD4E0029C901F_782468687 =         "Account {name=" + name + ", type=" + type + "}";
        var88C3A4BDB947BCD23BACD4E0029C901F_782468687.addTaint(taint);
        return var88C3A4BDB947BCD23BACD4E0029C901F_782468687;
        // ---------- Original Method ----------
        //return "Account {name=" + name + ", type=" + type + "}";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.359 -0400", hash_original_field = "DE2599644EF9112EA03F6AEF302C05E0", hash_generated_field = "E8FF743E340A29709E9F49FE249853DC")

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        public Account createFromParcel(Parcel source) {
            return new Account(source);
        }

        public Account[] newArray(int size) {
            return new Account[size];
        }
    };
    // orphaned legacy method
    public Account createFromParcel(Parcel source) {
            return new Account(source);
        }
    
    // orphaned legacy method
    public Account[] newArray(int size) {
            return new Account[size];
        }
    
}

