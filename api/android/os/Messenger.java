package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class Messenger implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.776 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "F9905056B1A64DB2AA90D47CBD792D5B")

    private IMessenger mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.777 -0400", hash_original_method = "A65C5BAC2E4407473A9171FA89173DDE", hash_generated_method = "FE170725623D07B355C9E7DAE666B43B")
    public  Messenger(Handler target) {
        mTarget = target.getIMessenger();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.778 -0400", hash_original_method = "291BB446453057D831D652E8D2879500", hash_generated_method = "AFA2AAA6346518D1637CF6B13F768E08")
    public  Messenger(IBinder target) {
        mTarget = IMessenger.Stub.asInterface(target);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.778 -0400", hash_original_method = "87BB77B45562A993DA127AF8A28A35EF", hash_generated_method = "13312566E5F36E79E7EE149190CA590C")
    public void send(Message message) throws RemoteException {
        addTaint(message.getTaint());
        mTarget.send(message);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.778 -0400", hash_original_method = "4371CC0F380F9E28159928FBC65693A0", hash_generated_method = "B13AEFE150954F83F3FEF3E24550B65D")
    public IBinder getBinder() {
IBinder varE29672B36B312FCEF89F2650279B2AD2_859636602 =         mTarget.asBinder();
        varE29672B36B312FCEF89F2650279B2AD2_859636602.addTaint(taint);
        return varE29672B36B312FCEF89F2650279B2AD2_859636602;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.778 -0400", hash_original_method = "C149400C0C5347CE34188C78467CE5CF", hash_generated_method = "300E8F6623306A46B733E4435F30F350")
    public boolean equals(Object otherObj) {
        addTaint(otherObj.getTaint());
    if(otherObj == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_348953759 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_552772302 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_552772302;
        } 
        try 
        {
            boolean varFE5D75279899A800402F90775B0685A2_1744611341 = (mTarget.asBinder().equals(((Messenger)otherObj)
                    .mTarget.asBinder()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1491280791 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1491280791;
        } 
        catch (ClassCastException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_1753487892 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_498414376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_498414376;
        
        
            
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.779 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "269CC93B8DF520FBB164AC5781FF77C0")
    public int hashCode() {
        int var015DBE14D40CCC902461F5EB4537F2D8_1837492687 = (mTarget.asBinder().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_873501817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_873501817;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.779 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E94E93C93C5E1FD40318F88CAC900718")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1497595263 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1243258807 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1243258807;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.780 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "C7A202EDEDAAFB23E59B79A7FE9B7381")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeStrongBinder(mTarget.asBinder());
        
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.780 -0400", hash_original_field = "3A3E522D95E5D82B4A0F95B0B050AA96", hash_generated_field = "55308DA772781DF1B60352726A54D36C")

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

