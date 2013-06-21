package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Messenger implements Parcelable {
    private IMessenger mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.875 -0400", hash_original_method = "A65C5BAC2E4407473A9171FA89173DDE", hash_generated_method = "72654B9ED0398571BEC541EB36A4F0BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Messenger(Handler target) {
        dsTaint.addTaint(target.dsTaint);
        mTarget = target.getIMessenger();
        // ---------- Original Method ----------
        //mTarget = target.getIMessenger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.875 -0400", hash_original_method = "291BB446453057D831D652E8D2879500", hash_generated_method = "5C338002943A610961B0035998BE31C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Messenger(IBinder target) {
        dsTaint.addTaint(target.dsTaint);
        mTarget = IMessenger.Stub.asInterface(target);
        // ---------- Original Method ----------
        //mTarget = IMessenger.Stub.asInterface(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.875 -0400", hash_original_method = "87BB77B45562A993DA127AF8A28A35EF", hash_generated_method = "B5045DF5732C8353DA5999DF5C6D9627")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void send(Message message) throws RemoteException {
        dsTaint.addTaint(message.dsTaint);
        mTarget.send(message);
        // ---------- Original Method ----------
        //mTarget.send(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.876 -0400", hash_original_method = "4371CC0F380F9E28159928FBC65693A0", hash_generated_method = "4097DFB6CE22BB645DABD6C921827F49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IBinder getBinder() {
        IBinder var9F96EEDD6D88CDCD88F18F43C30585FB_564667122 = (mTarget.asBinder());
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTarget.asBinder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.876 -0400", hash_original_method = "C149400C0C5347CE34188C78467CE5CF", hash_generated_method = "0630D11BBC23CEE05B16C18025CFD920")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object otherObj) {
        dsTaint.addTaint(otherObj.dsTaint);
        try 
        {
            boolean varA46265C4594AEBA2B5864671A2E4F79F_222603046 = (mTarget.asBinder().equals(((Messenger)otherObj)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.876 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "FAAD2E8641F022AD0F8319296044E9A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_658956851 = (mTarget.asBinder().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.877 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.878 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "82E673ADF87F6A34F82CD67D6313EA4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeStrongBinder(mTarget.asBinder());
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

    
    public static final Parcelable.Creator<Messenger> CREATOR = new Parcelable.Creator<Messenger>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.878 -0400", hash_original_method = "9CB182A89C6CC0D581283770DD971374", hash_generated_method = "D0D93FDE2B9EA4615BE4F226A4F33651")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Messenger createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            IBinder target;
            target = in.readStrongBinder();
            {
                Object varF64E152F01256F52583EB5696192F110_1783837735 = (new Messenger(target));
            } //End flattened ternary
            return (Messenger)dsTaint.getTaint();
            // ---------- Original Method ----------
            //IBinder target = in.readStrongBinder();
            //return target != null ? new Messenger(target) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.879 -0400", hash_original_method = "C17D90CCDCF71AAAA610D955331D85E9", hash_generated_method = "B13F56E6F40CEAE8F666ABEA5DF31CF5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Messenger[] newArray(int size) {
            dsTaint.addTaint(size);
            Messenger[] varDB3C5CD1584A296ABFD264D480ADB6D7_771348801 = (new Messenger[size]);
            return (Messenger[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Messenger[size];
        }

        
}; //Transformed anonymous class
}

