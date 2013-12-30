package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;





public final class InputBinding implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.553 -0500", hash_original_field = "10E7E5AF6C6AF740D1052F1C07849A7D", hash_generated_field = "DF35411D6228553D984D7F58714BB9BE")

    static final String TAG = "InputBinding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.539 -0400", hash_original_field = "91288E34B1866A3C65DC557B5773CCC7", hash_generated_field = "3934220B5C8F93AC893AC17F9265BD44")

    public static final Parcelable.Creator<InputBinding> CREATOR = new Parcelable.Creator<InputBinding>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.588 -0500", hash_original_method = "7261E03D1E139EDC41F5C316E4402594", hash_generated_method = "4D1496639AF317661D64864BDE786515")
        
public InputBinding createFromParcel(Parcel source) {
            return new InputBinding(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.591 -0500", hash_original_method = "4D25205B6B348333C45EA07A6E27FEA5", hash_generated_method = "2F362E869DE85A64D23C27A48A1D4EEC")
        
public InputBinding[] newArray(int size) {
            return new InputBinding[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.555 -0500", hash_original_field = "2ADAF77D280D81634A6B9C6C8844B2F4", hash_generated_field = "2ADAF77D280D81634A6B9C6C8844B2F4")

     InputConnection mConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.557 -0500", hash_original_field = "B2BFF8CA20E4B3DF5621D621C1E63B81", hash_generated_field = "B2BFF8CA20E4B3DF5621D621C1E63B81")

     IBinder mConnectionToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.559 -0500", hash_original_field = "2E17F34ACFF64BF5EF5CA45BD0D39C5B", hash_generated_field = "2E17F34ACFF64BF5EF5CA45BD0D39C5B")

     int mUid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.562 -0500", hash_original_field = "939E63817634DEADBC21ADAC3D446EE9", hash_generated_field = "939E63817634DEADBC21ADAC3D446EE9")

     int mPid;
    
    /**
     * Constructor.
     * 
     * @param conn The interface for communicating back with the application.
     * @param connToken A remoteable token for communicating across processes.
     * @param uid The user id of the client of this binding.
     * @param pid The process id of where the binding came from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.565 -0500", hash_original_method = "04B1C2D6CDEDB76C9AA67954E8673411", hash_generated_method = "4E8C4CB8548156D23D2C59EDC1AF01FB")
    
public InputBinding(InputConnection conn, IBinder connToken,
            int uid, int pid) {
        mConnection = conn;
        mConnectionToken = connToken;
        mUid = uid;
        mPid = pid;
    }

    /**
     * Constructor from an existing InputBinding taking a new local input
     * connection interface.
     * 
     * @param conn The new connection interface.
     * @param binding Existing binding to copy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.567 -0500", hash_original_method = "DBB90F0F9CF3F4CFB7D310D0A734D117", hash_generated_method = "C6B4679FF99C1021CAB20045179D0593")
    
public InputBinding(InputConnection conn, InputBinding binding) {
        mConnection = conn;
        mConnectionToken = binding.getConnectionToken();
        mUid = binding.getUid();
        mPid = binding.getPid();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.570 -0500", hash_original_method = "60D4493C413075577DFF548F6D5D71C3", hash_generated_method = "60D4493C413075577DFF548F6D5D71C3")
    
InputBinding(Parcel source) {
        mConnection = null;
        mConnectionToken = source.readStrongBinder();
        mUid = source.readInt();
        mPid = source.readInt();
    }
    
    /**
     * Return the connection for interacting back with the application.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.572 -0500", hash_original_method = "EE079552217D9D3D337BCB42A3B90EF3", hash_generated_method = "603B560A64FA3C4E896B6DF055986DB0")
    
public InputConnection getConnection() {
        return mConnection;
    }
    
    /**
     * Return the token for the connection back to the application.  You can
     * not use this directly, it must be converted to a {@link InputConnection}
     * for you.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.575 -0500", hash_original_method = "A8756053877C567C0ECF2796084552D6", hash_generated_method = "DFB937A89F30E37D74F138397648DB60")
    
public IBinder getConnectionToken() {
        return mConnectionToken;
    }
    
    /**
     * Return the user id of the client associated with this binding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.577 -0500", hash_original_method = "96C0ECA451126B748CCA2D62D6264E79", hash_generated_method = "D9609F2B40F50FBC7A5ECB5FB52ADD98")
    
public int getUid() {
        return mUid;
    }
    
    /**
     * Return the process id where this binding came from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.579 -0500", hash_original_method = "30E9EE034B82B89E2430B9CA08B3CDF3", hash_generated_method = "5F3F7EBF84C647ECA8CD37811F6AB2C1")
    
public int getPid() {
        return mPid;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.581 -0500", hash_original_method = "30B5CA44D3BF64A2B8A74435F40F5258", hash_generated_method = "731A7A43B83D2D6EDCDD291E1468B6DA")
    
@Override
    public String toString() {
        return "InputBinding{" + mConnectionToken
                + " / uid " + mUid + " / pid " + mPid + "}";
    }

    /**
     * Used to package this object into a {@link Parcel}.
     * 
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.584 -0500", hash_original_method = "CF6195886A2216F7801132B22F3EB428", hash_generated_method = "FD7B8C1098A92D2E26605F6BF01E8C32")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(mConnectionToken);
        dest.writeInt(mUid);
        dest.writeInt(mPid);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.595 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    // orphaned legacy method
    public InputBinding createFromParcel(Parcel source) {
            return new InputBinding(source);
        }
    
    // orphaned legacy method
    public InputBinding[] newArray(int size) {
            return new InputBinding[size];
        }
    
}

