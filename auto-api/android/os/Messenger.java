package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Messenger implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.545 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "F9905056B1A64DB2AA90D47CBD792D5B")

    private IMessenger mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.546 -0400", hash_original_method = "A65C5BAC2E4407473A9171FA89173DDE", hash_generated_method = "FE170725623D07B355C9E7DAE666B43B")
    public  Messenger(Handler target) {
        mTarget = target.getIMessenger();
        // ---------- Original Method ----------
        //mTarget = target.getIMessenger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.546 -0400", hash_original_method = "291BB446453057D831D652E8D2879500", hash_generated_method = "AFA2AAA6346518D1637CF6B13F768E08")
    public  Messenger(IBinder target) {
        mTarget = IMessenger.Stub.asInterface(target);
        // ---------- Original Method ----------
        //mTarget = IMessenger.Stub.asInterface(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.547 -0400", hash_original_method = "87BB77B45562A993DA127AF8A28A35EF", hash_generated_method = "70F76CCE45194DBAD2847FFBBF7ECBF2")
    public void send(Message message) throws RemoteException {
        mTarget.send(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mTarget.send(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.547 -0400", hash_original_method = "4371CC0F380F9E28159928FBC65693A0", hash_generated_method = "B675F51286B05CCC85CE8C70CA809BD5")
    public IBinder getBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1876893153 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1876893153 = mTarget.asBinder();
        varB4EAC82CA7396A68D541C85D26508E83_1876893153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1876893153;
        // ---------- Original Method ----------
        //return mTarget.asBinder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.548 -0400", hash_original_method = "C149400C0C5347CE34188C78467CE5CF", hash_generated_method = "49E0EBC92BBCC35CF3C71216081AC1C8")
    public boolean equals(Object otherObj) {
        try 
        {
            boolean varA46265C4594AEBA2B5864671A2E4F79F_1646617962 = (mTarget.asBinder().equals(((Messenger)otherObj)
                    .mTarget.asBinder()));
        } //End block
        catch (ClassCastException e)
        { }
        addTaint(otherObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135884673 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135884673;
        // ---------- Original Method ----------
        //if (otherObj == null) {
            //return false;
        //}
        //try {
            //return mTarget.asBinder().equals(((Messenger)otherObj)
                    //.mTarget.asBinder());
        //} catch (ClassCastException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.548 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "29AE19F3F0B6BEDCFA2116608E384469")
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_774762864 = (mTarget.asBinder().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155303198 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155303198;
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.555 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3FEC25521F22CCE732696AFACF6F5B32")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221572356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221572356;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.563 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "CB2D00ECBC9E35AA709F7B9DC3B570B9")
    public void writeToParcel(Parcel out, int flags) {
        out.writeStrongBinder(mTarget.asBinder());
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //out.writeStrongBinder(mTarget.asBinder());
    }

    
        public static void writeMessengerOrNullToParcel(Messenger messenger,
            Parcel out) {
        out.writeStrongBinder(messenger != null ? messenger.mTarget.asBinder()
                : null);
    }

    
        public static Messenger readMessengerOrNullFromParcel(Parcel in) {
        IBinder b = in.readStrongBinder();
        return b != null ? new Messenger(b) : null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.564 -0400", hash_original_field = "3A3E522D95E5D82B4A0F95B0B050AA96", hash_generated_field = "55308DA772781DF1B60352726A54D36C")

    public static final Parcelable.Creator<Messenger> CREATOR
            = new Parcelable.Creator<Messenger>() {
        public Messenger createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new Messenger(target) : null;
        }

        public Messenger[] newArray(int size) {
            return new Messenger[size];
        }
    };
}

