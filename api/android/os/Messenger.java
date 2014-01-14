package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class Messenger implements Parcelable {

    /**
     * Convenience function for writing either a Messenger or null pointer to
     * a Parcel.  You must use this with {@link #readMessengerOrNullFromParcel}
     * for later reading it.
     * 
     * @param messenger The Messenger to write, or null.
     * @param out Where to write the Messenger.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.426 -0500", hash_original_method = "7C769D0B94813ACF4E3098A48F898F66", hash_generated_method = "4E5092E07E492479F3E51A72D368FAE5")
    
public static void writeMessengerOrNullToParcel(Messenger messenger,
            Parcel out) {
        out.writeStrongBinder(messenger != null ? messenger.mTarget.asBinder()
                : null);
    }
    
    /**
     * Convenience function for reading either a Messenger or null pointer from
     * a Parcel.  You must have previously written the Messenger with
     * {@link #writeMessengerOrNullToParcel}.
     * 
     * @param in The Parcel containing the written Messenger.
     * 
     * @return Returns the Messenger read from the Parcel, or null if null had
     * been written.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.429 -0500", hash_original_method = "8F665F93AE5872E3C9D6C82BD46E5841", hash_generated_method = "03126B1938C7C6517C3532D868601491")
    
public static Messenger readMessengerOrNullFromParcel(Parcel in) {
        IBinder b = in.readStrongBinder();
        return b != null ? new Messenger(b) : null;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.668 -0400", hash_original_field = "3A3E522D95E5D82B4A0F95B0B050AA96", hash_generated_field = "55308DA772781DF1B60352726A54D36C")

    public static final Parcelable.Creator<Messenger> CREATOR
            = new Parcelable.Creator<Messenger>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.419 -0500", hash_original_method = "9CB182A89C6CC0D581283770DD971374", hash_generated_method = "91BD7DF507EE4BBC8B6197B69AFA5AF8")
        
public Messenger createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new Messenger(target) : null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.421 -0500", hash_original_method = "C17D90CCDCF71AAAA610D955331D85E9", hash_generated_method = "F3A41D438035624F02A63EB8010D322C")
        
public Messenger[] newArray(int size) {
            return new Messenger[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.400 -0500", hash_original_field = "ED133AFC551B364C3AF2BBDA21A22AA7", hash_generated_field = "F9905056B1A64DB2AA90D47CBD792D5B")

    private  IMessenger mTarget;

    /**
     * Create a new Messenger pointing to the given Handler.  Any Message
     * objects sent through this Messenger will appear in the Handler as if
     * {@link Handler#sendMessage(Message) Handler.sendMessage(Message)} had
     * been called directly.
     * 
     * @param target The Handler that will receive sent messages.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.403 -0500", hash_original_method = "A65C5BAC2E4407473A9171FA89173DDE", hash_generated_method = "F9EADB68E50F41D4F02A92288796FDE3")
    
public Messenger(Handler target) {
        mTarget = target.getIMessenger();
    }
    
    /**
     * Create a Messenger from a raw IBinder, which had previously been
     * retrieved with {@link #getBinder}.
     * 
     * @param target The IBinder this Messenger should communicate with.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.431 -0500", hash_original_method = "291BB446453057D831D652E8D2879500", hash_generated_method = "21FAEE86AF040679487C6933431AE666")
    
public Messenger(IBinder target) {
        mTarget = IMessenger.Stub.asInterface(target);
    }
    
    /**
     * Send a Message to this Messenger's Handler.
     * 
     * @param message The Message to send.  Usually retrieved through
     * {@link Message#obtain() Message.obtain()}.
     * 
     * @throws RemoteException Throws DeadObjectException if the target
     * Handler no longer exists.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.405 -0500", hash_original_method = "87BB77B45562A993DA127AF8A28A35EF", hash_generated_method = "14BEC707A4A52F5122FCA56614674178")
    
public void send(Message message) throws RemoteException {
        mTarget.send(message);
    }
    
    /**
     * Retrieve the IBinder that this Messenger is using to communicate with
     * its associated Handler.
     * 
     * @return Returns the IBinder backing this Messenger.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.407 -0500", hash_original_method = "4371CC0F380F9E28159928FBC65693A0", hash_generated_method = "CF424504EFFD31AD8ED006BBB939C76F")
    
public IBinder getBinder() {
        return mTarget.asBinder();
    }
    
    /**
     * Comparison operator on two Messenger objects, such that true
     * is returned then they both point to the same Handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.409 -0500", hash_original_method = "C149400C0C5347CE34188C78467CE5CF", hash_generated_method = "8409B099537599632B5684367D8F59C3")
    
public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        }
        try {
            return mTarget.asBinder().equals(((Messenger)otherObj)
                    .mTarget.asBinder());
        } catch (ClassCastException e) {
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.412 -0500", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "D3CD0FF680AAF7AE0414AB6B38BC2F04")
    
public int hashCode() {
        return mTarget.asBinder().hashCode();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.414 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.416 -0500", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "5FB48EDF3036D823DDA10D61F6FC459B")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeStrongBinder(mTarget.asBinder());
    }
    // orphaned legacy method
    public Messenger createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new Messenger(target) : null;
        }
    
    // orphaned legacy method
    public Messenger[] newArray(int size) {
            return new Messenger[size];
        }
    
}

