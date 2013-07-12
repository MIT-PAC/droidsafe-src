package android.accounts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.os.Parcel;
import android.text.TextUtils;

public class Account implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.125 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.127 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7BA709B14E744AD5C81755E81EB9D05D")

    public String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.134 -0400", hash_original_method = "92321A38B636724882B81077847DFFEE", hash_generated_method = "02364E2820942279EF72CC1B583CD935")
    public  Account(String name, String type) {
    if(TextUtils.isEmpty(name))        
        {
            IllegalArgumentException var6C8A93341707787C8F70B85C82F20B22_1529590629 = new IllegalArgumentException("the name must not be empty: " + name);
            var6C8A93341707787C8F70B85C82F20B22_1529590629.addTaint(taint);
            throw var6C8A93341707787C8F70B85C82F20B22_1529590629;
        } 
    if(TextUtils.isEmpty(type))        
        {
            IllegalArgumentException var40EC9147D99C18302F989138A88ED599_2065224195 = new IllegalArgumentException("the type must not be empty: " + type);
            var40EC9147D99C18302F989138A88ED599_2065224195.addTaint(taint);
            throw var40EC9147D99C18302F989138A88ED599_2065224195;
        } 
        this.name = name;
        this.type = type;
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.139 -0400", hash_original_method = "634539653E1462125AEF6C008057544F", hash_generated_method = "AB670C373627CC667B25B3C5CC45E291")
    public  Account(Parcel in) {
        this.name = in.readString();
        this.type = in.readString();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.143 -0400", hash_original_method = "8952178E80D6EF68D44FC6803A31AC53", hash_generated_method = "57354EA46B3BB69C0611FC58A6E6CA26")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1397493297 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166893955 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166893955;
        }
    if(!(o instanceof Account))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1028558520 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710627957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_710627957;
        }
        final Account other = (Account)o;
        boolean var75B77C281F1EB419B1DD564900207EE6_184764674 = (name.equals(other.name) && type.equals(other.type));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1017754857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1017754857;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.148 -0400", hash_original_method = "2D8E3835F41EEE5A0134485B603913A1", hash_generated_method = "57022B31714A7043649734EC6BB6C2B1")
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        int varB4A88417B3D0170D754C647C30B7216A_1327755862 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368815369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368815369;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.152 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "84E4EC676B9CDAC54EF17868080C2AA3")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1169370924 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510048195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510048195;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.154 -0400", hash_original_method = "5E35BE18734E956B072A3A591EB1639E", hash_generated_method = "9553A42F573EBC29D5C802031B61C868")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(name);
        dest.writeString(type);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.156 -0400", hash_original_method = "E40D22A387A231E7FC5FB70BCBB60906", hash_generated_method = "1397F1AC812005463D89EDC05CA072B4")
    public String toString() {
String var88C3A4BDB947BCD23BACD4E0029C901F_1000356310 =         "Account {name=" + name + ", type=" + type + "}";
        var88C3A4BDB947BCD23BACD4E0029C901F_1000356310.addTaint(taint);
        return var88C3A4BDB947BCD23BACD4E0029C901F_1000356310;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:31.159 -0400", hash_original_field = "DE2599644EF9112EA03F6AEF302C05E0", hash_generated_field = "E8FF743E340A29709E9F49FE249853DC")

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

