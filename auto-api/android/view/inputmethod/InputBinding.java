package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class InputBinding implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.002 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "2ADAF77D280D81634A6B9C6C8844B2F4")

    InputConnection mConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.002 -0400", hash_original_field = "1C078C46426DFC94F11559A532DA4CD3", hash_generated_field = "B2BFF8CA20E4B3DF5621D621C1E63B81")

    IBinder mConnectionToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.002 -0400", hash_original_field = "0F9DC7C71DB77614469844545D29C442", hash_generated_field = "2E17F34ACFF64BF5EF5CA45BD0D39C5B")

    int mUid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.002 -0400", hash_original_field = "EB19E663452CF9AA298FCD2DEEC8990E", hash_generated_field = "939E63817634DEADBC21ADAC3D446EE9")

    int mPid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.010 -0400", hash_original_method = "04B1C2D6CDEDB76C9AA67954E8673411", hash_generated_method = "D3802D48C6F6CB4BD9FD00E716993C08")
    public  InputBinding(InputConnection conn, IBinder connToken,
            int uid, int pid) {
        mConnection = conn;
        mConnectionToken = connToken;
        mUid = uid;
        mPid = pid;
        // ---------- Original Method ----------
        //mConnection = conn;
        //mConnectionToken = connToken;
        //mUid = uid;
        //mPid = pid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.027 -0400", hash_original_method = "DBB90F0F9CF3F4CFB7D310D0A734D117", hash_generated_method = "3E95BFDDB5E690A8BB7107EEEE54DDE0")
    public  InputBinding(InputConnection conn, InputBinding binding) {
        mConnection = conn;
        mConnectionToken = binding.getConnectionToken();
        mUid = binding.getUid();
        mPid = binding.getPid();
        // ---------- Original Method ----------
        //mConnection = conn;
        //mConnectionToken = binding.getConnectionToken();
        //mUid = binding.getUid();
        //mPid = binding.getPid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.028 -0400", hash_original_method = "60D4493C413075577DFF548F6D5D71C3", hash_generated_method = "BAE142ABCBE2B21ACC9C810D04C9F914")
      InputBinding(Parcel source) {
        mConnection = null;
        mConnectionToken = source.readStrongBinder();
        mUid = source.readInt();
        mPid = source.readInt();
        // ---------- Original Method ----------
        //mConnection = null;
        //mConnectionToken = source.readStrongBinder();
        //mUid = source.readInt();
        //mPid = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.029 -0400", hash_original_method = "EE079552217D9D3D337BCB42A3B90EF3", hash_generated_method = "29FDD6E0361813A9DA9315B4B00ECF8B")
    public InputConnection getConnection() {
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_177485380 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_177485380 = mConnection;
        varB4EAC82CA7396A68D541C85D26508E83_177485380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_177485380;
        // ---------- Original Method ----------
        //return mConnection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.030 -0400", hash_original_method = "A8756053877C567C0ECF2796084552D6", hash_generated_method = "5B2BF993DACC82AF37EA117F8593D2D7")
    public IBinder getConnectionToken() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_362916284 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_362916284 = mConnectionToken;
        varB4EAC82CA7396A68D541C85D26508E83_362916284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_362916284;
        // ---------- Original Method ----------
        //return mConnectionToken;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.030 -0400", hash_original_method = "96C0ECA451126B748CCA2D62D6264E79", hash_generated_method = "67620AFCDB1215FA5D5EA18D6D58369F")
    public int getUid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26664236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26664236;
        // ---------- Original Method ----------
        //return mUid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.030 -0400", hash_original_method = "30E9EE034B82B89E2430B9CA08B3CDF3", hash_generated_method = "FF18ECC22EBB8886C453B00B4CEFBEFA")
    public int getPid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599809601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599809601;
        // ---------- Original Method ----------
        //return mPid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.040 -0400", hash_original_method = "30B5CA44D3BF64A2B8A74435F40F5258", hash_generated_method = "1F341E94F9F1C2D989D4F50182F503A9")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_871899967 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_871899967 = "InputBinding{" + mConnectionToken
                + " / uid " + mUid + " / pid " + mPid + "}";
        varB4EAC82CA7396A68D541C85D26508E83_871899967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_871899967;
        // ---------- Original Method ----------
        //return "InputBinding{" + mConnectionToken
                //+ " / uid " + mUid + " / pid " + mPid + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.041 -0400", hash_original_method = "CF6195886A2216F7801132B22F3EB428", hash_generated_method = "4ADD8AA231D7444C2F9164CD47718CDE")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(mConnectionToken);
        dest.writeInt(mUid);
        dest.writeInt(mPid);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeStrongBinder(mConnectionToken);
        //dest.writeInt(mUid);
        //dest.writeInt(mPid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.041 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "95A2FA729DBDACE71045BCEA75FD3229")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064338390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064338390;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.041 -0400", hash_original_field = "9A3917942797B052B5B14BA9A627C560", hash_generated_field = "7A50D9D95A6284C138B3FA9145F5F435")

    static String TAG = "InputBinding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.041 -0400", hash_original_field = "91288E34B1866A3C65DC557B5773CCC7", hash_generated_field = "3934220B5C8F93AC893AC17F9265BD44")

    public static final Parcelable.Creator<InputBinding> CREATOR = new Parcelable.Creator<InputBinding>() {
        public InputBinding createFromParcel(Parcel source) {
            return new InputBinding(source);
        }

        public InputBinding[] newArray(int size) {
            return new InputBinding[size];
        }
    };
}

