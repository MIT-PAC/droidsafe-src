package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class Messenger implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.564 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "F9905056B1A64DB2AA90D47CBD792D5B")

    private IMessenger mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.564 -0400", hash_original_method = "A65C5BAC2E4407473A9171FA89173DDE", hash_generated_method = "FE170725623D07B355C9E7DAE666B43B")
    public  Messenger(Handler target) {
        mTarget = target.getIMessenger();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.564 -0400", hash_original_method = "291BB446453057D831D652E8D2879500", hash_generated_method = "AFA2AAA6346518D1637CF6B13F768E08")
    public  Messenger(IBinder target) {
        mTarget = IMessenger.Stub.asInterface(target);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.565 -0400", hash_original_method = "87BB77B45562A993DA127AF8A28A35EF", hash_generated_method = "70F76CCE45194DBAD2847FFBBF7ECBF2")
    public void send(Message message) throws RemoteException {
        mTarget.send(message);
        addTaint(message.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.565 -0400", hash_original_method = "4371CC0F380F9E28159928FBC65693A0", hash_generated_method = "6E3A852D0A36FA427AB07406DC8E2FD4")
    public IBinder getBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1533248322 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1533248322 = mTarget.asBinder();
        varB4EAC82CA7396A68D541C85D26508E83_1533248322.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1533248322;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.566 -0400", hash_original_method = "C149400C0C5347CE34188C78467CE5CF", hash_generated_method = "7A00C81106C7857F5BB6A5C655B46CC3")
    public boolean equals(Object otherObj) {
        try 
        {
            boolean varA46265C4594AEBA2B5864671A2E4F79F_1758640204 = (mTarget.asBinder().equals(((Messenger)otherObj)
                    .mTarget.asBinder()));
        } 
        catch (ClassCastException e)
        { }
        addTaint(otherObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_4692495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_4692495;
        
        
            
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.566 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "1E96CC58AA47DFD9DF7324CCF9D8AAD6")
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_433480565 = (mTarget.asBinder().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934866063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934866063;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.567 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C1EA216BE6800A3D27FA85E209B5FE72")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221217848 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221217848;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.567 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "CB2D00ECBC9E35AA709F7B9DC3B570B9")
    public void writeToParcel(Parcel out, int flags) {
        out.writeStrongBinder(mTarget.asBinder());
        addTaint(out.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void writeMessengerOrNullToParcel(Messenger messenger,
            Parcel out) {
        out.writeStrongBinder(messenger != null ? messenger.mTarget.asBinder()
                : null);
    }

    
    @DSModeled(DSC.SAFE)
    public static Messenger readMessengerOrNullFromParcel(Parcel in) {
        IBinder b = in.readStrongBinder();
        return b != null ? new Messenger(b) : null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.568 -0400", hash_original_field = "3A3E522D95E5D82B4A0F95B0B050AA96", hash_generated_field = "55308DA772781DF1B60352726A54D36C")

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
    
    public Messenger createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new Messenger(target) : null;
        }
    
    
    public Messenger[] newArray(int size) {
            return new Messenger[size];
        }
    
}

