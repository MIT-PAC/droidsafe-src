package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class Messenger implements Parcelable {
    private final IMessenger mTarget;
    public static final Parcelable.Creator<Messenger> CREATOR = new Parcelable.Creator<Messenger>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.699 -0400", hash_original_method = "9CB182A89C6CC0D581283770DD971374", hash_generated_method = "FF752DE05D9BA2E21D0639B07FDE297C")
        @DSModeled(DSC.SAFE)
        public Messenger createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            IBinder target;
            target = in.readStrongBinder();
            return (Messenger)dsTaint.getTaint();
            // ---------- Original Method ----------
            //IBinder target = in.readStrongBinder();
            //return target != null ? new Messenger(target) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.699 -0400", hash_original_method = "C17D90CCDCF71AAAA610D955331D85E9", hash_generated_method = "03E97A3B33CF58F48EFA604E0D06A540")
        @DSModeled(DSC.SAFE)
        public Messenger[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Messenger[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Messenger[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.699 -0400", hash_original_method = "A65C5BAC2E4407473A9171FA89173DDE", hash_generated_method = "3DB5304DBD04F139550DEF3D50351D16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Messenger(Handler target) {
        dsTaint.addTaint(target.dsTaint);
        mTarget = target.getIMessenger();
        // ---------- Original Method ----------
        //mTarget = target.getIMessenger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.699 -0400", hash_original_method = "291BB446453057D831D652E8D2879500", hash_generated_method = "2485A5BA53FE3CF7EAD700485748C366")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Messenger(IBinder target) {
        dsTaint.addTaint(target.dsTaint);
        mTarget = IMessenger.Stub.asInterface(target);
        // ---------- Original Method ----------
        //mTarget = IMessenger.Stub.asInterface(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.699 -0400", hash_original_method = "87BB77B45562A993DA127AF8A28A35EF", hash_generated_method = "1B09746A458AEA45F55804A71765EFCC")
    @DSModeled(DSC.SAFE)
    public void send(Message message) throws RemoteException {
        dsTaint.addTaint(message.dsTaint);
        mTarget.send(message);
        // ---------- Original Method ----------
        //mTarget.send(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.699 -0400", hash_original_method = "4371CC0F380F9E28159928FBC65693A0", hash_generated_method = "48DD043BDF2047C6FFAB8F52F34CEA2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IBinder getBinder() {
        IBinder var9F96EEDD6D88CDCD88F18F43C30585FB_578737479 = (mTarget.asBinder());
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTarget.asBinder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.699 -0400", hash_original_method = "C149400C0C5347CE34188C78467CE5CF", hash_generated_method = "BB8A047CB3BAB778D62591F01FE3F859")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object otherObj) {
        dsTaint.addTaint(otherObj.dsTaint);
        try 
        {
            boolean varA46265C4594AEBA2B5864671A2E4F79F_1273921033 = (mTarget.asBinder().equals(((Messenger)otherObj)
                    .mTarget.asBinder()));
        } //End block
        catch (ClassCastException e)
        { }
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.700 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "5DBF534E365C5C98C659BC1887AA33AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_253249323 = (mTarget.asBinder().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.700 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.700 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "4DBC8FF64D1607D57C2D13908DAFE7EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeStrongBinder(mTarget.asBinder());
        // ---------- Original Method ----------
        //out.writeStrongBinder(mTarget.asBinder());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.700 -0400", hash_original_method = "7C769D0B94813ACF4E3098A48F898F66", hash_generated_method = "4E5092E07E492479F3E51A72D368FAE5")
    public static void writeMessengerOrNullToParcel(Messenger messenger,
            Parcel out) {
        out.writeStrongBinder(messenger != null ? messenger.mTarget.asBinder()
                : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.700 -0400", hash_original_method = "8F665F93AE5872E3C9D6C82BD46E5841", hash_generated_method = "03126B1938C7C6517C3532D868601491")
    public static Messenger readMessengerOrNullFromParcel(Parcel in) {
        IBinder b = in.readStrongBinder();
        return b != null ? new Messenger(b) : null;
    }

    
}


