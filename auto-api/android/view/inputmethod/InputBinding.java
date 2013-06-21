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
    InputConnection mConnection;
    IBinder mConnectionToken;
    int mUid;
    int mPid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.309 -0400", hash_original_method = "04B1C2D6CDEDB76C9AA67954E8673411", hash_generated_method = "CBCB5F5BE33FF95B2C48C7731394B67E")
    @DSModeled(DSC.SAFE)
    public InputBinding(InputConnection conn, IBinder connToken,
            int uid, int pid) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(conn.dsTaint);
        dsTaint.addTaint(connToken.dsTaint);
        dsTaint.addTaint(pid);
        // ---------- Original Method ----------
        //mConnection = conn;
        //mConnectionToken = connToken;
        //mUid = uid;
        //mPid = pid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.310 -0400", hash_original_method = "DBB90F0F9CF3F4CFB7D310D0A734D117", hash_generated_method = "8AFE60A82B28FFE95F8AA879F34F441F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputBinding(InputConnection conn, InputBinding binding) {
        dsTaint.addTaint(conn.dsTaint);
        dsTaint.addTaint(binding.dsTaint);
        mConnectionToken = binding.getConnectionToken();
        mUid = binding.getUid();
        mPid = binding.getPid();
        // ---------- Original Method ----------
        //mConnection = conn;
        //mConnectionToken = binding.getConnectionToken();
        //mUid = binding.getUid();
        //mPid = binding.getPid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.310 -0400", hash_original_method = "60D4493C413075577DFF548F6D5D71C3", hash_generated_method = "3E277909394F3E5799992F0837877AE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InputBinding(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.310 -0400", hash_original_method = "EE079552217D9D3D337BCB42A3B90EF3", hash_generated_method = "39763C1A42DBFA5D0089CAE83AB9D48F")
    @DSModeled(DSC.SAFE)
    public InputConnection getConnection() {
        return (InputConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mConnection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.310 -0400", hash_original_method = "A8756053877C567C0ECF2796084552D6", hash_generated_method = "78E0D1FD319711C0609C704C82262553")
    @DSModeled(DSC.SAFE)
    public IBinder getConnectionToken() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mConnectionToken;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.310 -0400", hash_original_method = "96C0ECA451126B748CCA2D62D6264E79", hash_generated_method = "F4428EA252D5651166BA2AB167306F81")
    @DSModeled(DSC.SAFE)
    public int getUid() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mUid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.311 -0400", hash_original_method = "30E9EE034B82B89E2430B9CA08B3CDF3", hash_generated_method = "74A1E1B02366A6AA3444FF8EAB922974")
    @DSModeled(DSC.SAFE)
    public int getPid() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.311 -0400", hash_original_method = "30B5CA44D3BF64A2B8A74435F40F5258", hash_generated_method = "3E4EA58BEE566D1CCC8E0A1A30D4B014")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "InputBinding{" + mConnectionToken
                //+ " / uid " + mUid + " / pid " + mPid + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.311 -0400", hash_original_method = "CF6195886A2216F7801132B22F3EB428", hash_generated_method = "91759DEF9F6A409A3F5DA8489ADD3AAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeStrongBinder(mConnectionToken);
        dest.writeInt(mUid);
        dest.writeInt(mPid);
        // ---------- Original Method ----------
        //dest.writeStrongBinder(mConnectionToken);
        //dest.writeInt(mUid);
        //dest.writeInt(mPid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.311 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    static final String TAG = "InputBinding";
    public static final Parcelable.Creator<InputBinding> CREATOR = new Parcelable.Creator<InputBinding>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.311 -0400", hash_original_method = "7261E03D1E139EDC41F5C316E4402594", hash_generated_method = "38C3F1EA26F4D319A5B533F42A6CC3E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputBinding createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            InputBinding var7395936B671D8DAAD0276D9B5E02278E_828257544 = (new InputBinding(source));
            return (InputBinding)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputBinding(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.311 -0400", hash_original_method = "4D25205B6B348333C45EA07A6E27FEA5", hash_generated_method = "40BA19CF2C039349F1730C48DE442712")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputBinding[] newArray(int size) {
            dsTaint.addTaint(size);
            InputBinding[] varCE7A8DE8717C28E38E05B50CD30F96FB_350017482 = (new InputBinding[size]);
            return (InputBinding[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputBinding[size];
        }

        
}; //Transformed anonymous class
}

