package android.view.inputmethod;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class InputBinding implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.001 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "2ADAF77D280D81634A6B9C6C8844B2F4")

    InputConnection mConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.001 -0400", hash_original_field = "1C078C46426DFC94F11559A532DA4CD3", hash_generated_field = "B2BFF8CA20E4B3DF5621D621C1E63B81")

    IBinder mConnectionToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.001 -0400", hash_original_field = "0F9DC7C71DB77614469844545D29C442", hash_generated_field = "2E17F34ACFF64BF5EF5CA45BD0D39C5B")

    int mUid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.001 -0400", hash_original_field = "EB19E663452CF9AA298FCD2DEEC8990E", hash_generated_field = "939E63817634DEADBC21ADAC3D446EE9")

    int mPid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.002 -0400", hash_original_method = "04B1C2D6CDEDB76C9AA67954E8673411", hash_generated_method = "D3802D48C6F6CB4BD9FD00E716993C08")
    public  InputBinding(InputConnection conn, IBinder connToken,
            int uid, int pid) {
        mConnection = conn;
        mConnectionToken = connToken;
        mUid = uid;
        mPid = pid;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.002 -0400", hash_original_method = "DBB90F0F9CF3F4CFB7D310D0A734D117", hash_generated_method = "3E95BFDDB5E690A8BB7107EEEE54DDE0")
    public  InputBinding(InputConnection conn, InputBinding binding) {
        mConnection = conn;
        mConnectionToken = binding.getConnectionToken();
        mUid = binding.getUid();
        mPid = binding.getPid();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.002 -0400", hash_original_method = "60D4493C413075577DFF548F6D5D71C3", hash_generated_method = "BAE142ABCBE2B21ACC9C810D04C9F914")
      InputBinding(Parcel source) {
        mConnection = null;
        mConnectionToken = source.readStrongBinder();
        mUid = source.readInt();
        mPid = source.readInt();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.003 -0400", hash_original_method = "EE079552217D9D3D337BCB42A3B90EF3", hash_generated_method = "4D96E8059571E06CFE7EABF12A8A6ECC")
    public InputConnection getConnection() {
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_5983923 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_5983923 = mConnection;
        varB4EAC82CA7396A68D541C85D26508E83_5983923.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_5983923;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.003 -0400", hash_original_method = "A8756053877C567C0ECF2796084552D6", hash_generated_method = "9A3DF771CD71C38C0590A858CF4E37DA")
    public IBinder getConnectionToken() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_557431727 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_557431727 = mConnectionToken;
        varB4EAC82CA7396A68D541C85D26508E83_557431727.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_557431727;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.003 -0400", hash_original_method = "96C0ECA451126B748CCA2D62D6264E79", hash_generated_method = "459CBE60F45B9EB57C9FA7D36281AB06")
    public int getUid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979212226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979212226;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.004 -0400", hash_original_method = "30E9EE034B82B89E2430B9CA08B3CDF3", hash_generated_method = "4DB85FE53512C78AD6A52B7E944F1477")
    public int getPid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603031006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603031006;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.004 -0400", hash_original_method = "30B5CA44D3BF64A2B8A74435F40F5258", hash_generated_method = "7BF422D0898A9CC92C2A8419268C2472")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1469664631 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1469664631 = "InputBinding{" + mConnectionToken
                + " / uid " + mUid + " / pid " + mPid + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1469664631.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1469664631;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.005 -0400", hash_original_method = "CF6195886A2216F7801132B22F3EB428", hash_generated_method = "4ADD8AA231D7444C2F9164CD47718CDE")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(mConnectionToken);
        dest.writeInt(mUid);
        dest.writeInt(mPid);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.005 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A31AE22337948CE86278B404AEC9DC0D")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776231122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776231122;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.005 -0400", hash_original_field = "9A3917942797B052B5B14BA9A627C560", hash_generated_field = "DF35411D6228553D984D7F58714BB9BE")

    static final String TAG = "InputBinding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.005 -0400", hash_original_field = "91288E34B1866A3C65DC557B5773CCC7", hash_generated_field = "3934220B5C8F93AC893AC17F9265BD44")

    public static final Parcelable.Creator<InputBinding> CREATOR = new Parcelable.Creator<InputBinding>() {
        public InputBinding createFromParcel(Parcel source) {
            return new InputBinding(source);
        }

        public InputBinding[] newArray(int size) {
            return new InputBinding[size];
        }
    };
    
    public InputBinding createFromParcel(Parcel source) {
            return new InputBinding(source);
        }
    
    
    public InputBinding[] newArray(int size) {
            return new InputBinding[size];
        }
    
}

