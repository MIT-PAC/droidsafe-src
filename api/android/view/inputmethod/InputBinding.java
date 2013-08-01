package android.view.inputmethod;

// Droidsafe Imports
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class InputBinding implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.536 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "2ADAF77D280D81634A6B9C6C8844B2F4")

    InputConnection mConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.536 -0400", hash_original_field = "1C078C46426DFC94F11559A532DA4CD3", hash_generated_field = "B2BFF8CA20E4B3DF5621D621C1E63B81")

    IBinder mConnectionToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.536 -0400", hash_original_field = "0F9DC7C71DB77614469844545D29C442", hash_generated_field = "2E17F34ACFF64BF5EF5CA45BD0D39C5B")

    int mUid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.536 -0400", hash_original_field = "EB19E663452CF9AA298FCD2DEEC8990E", hash_generated_field = "939E63817634DEADBC21ADAC3D446EE9")

    int mPid;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.537 -0400", hash_original_method = "04B1C2D6CDEDB76C9AA67954E8673411", hash_generated_method = "D3802D48C6F6CB4BD9FD00E716993C08")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.537 -0400", hash_original_method = "DBB90F0F9CF3F4CFB7D310D0A734D117", hash_generated_method = "3E95BFDDB5E690A8BB7107EEEE54DDE0")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.538 -0400", hash_original_method = "60D4493C413075577DFF548F6D5D71C3", hash_generated_method = "BAE142ABCBE2B21ACC9C810D04C9F914")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.538 -0400", hash_original_method = "EE079552217D9D3D337BCB42A3B90EF3", hash_generated_method = "F397FD2103652FA8051DB6A978C2F7DC")
    public InputConnection getConnection() {
InputConnection var9818CDD0C0587BB48621EEA73B53E24D_477513756 =         mConnection;
        var9818CDD0C0587BB48621EEA73B53E24D_477513756.addTaint(taint);
        return var9818CDD0C0587BB48621EEA73B53E24D_477513756;
        // ---------- Original Method ----------
        //return mConnection;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.538 -0400", hash_original_method = "A8756053877C567C0ECF2796084552D6", hash_generated_method = "66ADC6A8E2326E0584E1F987C3ABCE10")
    public IBinder getConnectionToken() {
IBinder varBF6D921CD5EA7DCACE4FD636A14DA721_588803973 =         mConnectionToken;
        varBF6D921CD5EA7DCACE4FD636A14DA721_588803973.addTaint(taint);
        return varBF6D921CD5EA7DCACE4FD636A14DA721_588803973;
        // ---------- Original Method ----------
        //return mConnectionToken;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.538 -0400", hash_original_method = "96C0ECA451126B748CCA2D62D6264E79", hash_generated_method = "FCFBC15FEF46BCC00DC2668E1A8B7826")
    public int getUid() {
        int var0F9DC7C71DB77614469844545D29C442_499696848 = (mUid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278333567 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278333567;
        // ---------- Original Method ----------
        //return mUid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.538 -0400", hash_original_method = "30E9EE034B82B89E2430B9CA08B3CDF3", hash_generated_method = "3471AA7DB3DB24E5C127400DE5EB0B1E")
    public int getPid() {
        int varEB19E663452CF9AA298FCD2DEEC8990E_901606689 = (mPid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869072525 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869072525;
        // ---------- Original Method ----------
        //return mPid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.539 -0400", hash_original_method = "30B5CA44D3BF64A2B8A74435F40F5258", hash_generated_method = "956ECA279B67CB853C4055632118281A")
    @Override
    public String toString() {
String var97082D0AA9ABA58D7744A7D0780CB658_1013244048 =         "InputBinding{" + mConnectionToken
                + " / uid " + mUid + " / pid " + mPid + "}";
        var97082D0AA9ABA58D7744A7D0780CB658_1013244048.addTaint(taint);
        return var97082D0AA9ABA58D7744A7D0780CB658_1013244048;
        // ---------- Original Method ----------
        //return "InputBinding{" + mConnectionToken
                //+ " / uid " + mUid + " / pid " + mPid + "}";
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.539 -0400", hash_original_method = "CF6195886A2216F7801132B22F3EB428", hash_generated_method = "E44AF1DA8D5AD9DC12644062224F677F")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeStrongBinder(mConnectionToken);
        dest.writeInt(mUid);
        dest.writeInt(mPid);
        // ---------- Original Method ----------
        //dest.writeStrongBinder(mConnectionToken);
        //dest.writeInt(mUid);
        //dest.writeInt(mPid);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.539 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3D6B3E8585AC7E0F62222B7FCB403A20")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_746077969 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724654585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724654585;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.539 -0400", hash_original_field = "9A3917942797B052B5B14BA9A627C560", hash_generated_field = "DF35411D6228553D984D7F58714BB9BE")

    static final String TAG = "InputBinding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.539 -0400", hash_original_field = "91288E34B1866A3C65DC557B5773CCC7", hash_generated_field = "3934220B5C8F93AC893AC17F9265BD44")

    public static final Parcelable.Creator<InputBinding> CREATOR = new Parcelable.Creator<InputBinding>() {
        public InputBinding createFromParcel(Parcel source) {
            return new InputBinding(source);
        }

        public InputBinding[] newArray(int size) {
            return new InputBinding[size];
        }
    };
    // orphaned legacy method
    public InputBinding createFromParcel(Parcel source) {
            return new InputBinding(source);
        }
    
    // orphaned legacy method
    public InputBinding[] newArray(int size) {
            return new InputBinding[size];
        }
    
}

