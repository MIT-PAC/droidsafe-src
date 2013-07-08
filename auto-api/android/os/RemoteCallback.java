package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class RemoteCallback implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.061 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.061 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "2AB83AA43D542094128EC2A15E8F4E08")

    IRemoteCallback mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.061 -0400", hash_original_method = "50DD48E58CB649CEFAA75AE1D62E7A3D", hash_generated_method = "106DDBD9A30F2F286547618F0B5D5A39")
    public  RemoteCallback(Handler handler) {
        mHandler = handler;
        mTarget = new LocalCallback();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.062 -0400", hash_original_method = "0B794F9104639CB6919FB2A3A2B6E7D4", hash_generated_method = "D4A0AC52F8E4448E204454433D057D67")
      RemoteCallback(IRemoteCallback target) {
        mHandler = null;
        mTarget = target;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.062 -0400", hash_original_method = "AAFA6B317F34ECAA46BF4F3A7ADBE4F2", hash_generated_method = "79399030FB60A878BB4D2CE67B46F431")
    public void sendResult(Bundle bundle) throws RemoteException {
        mTarget.sendResult(bundle);
        addTaint(bundle.getTaint());
        
        
    }

    
    protected abstract void onResult(Bundle bundle);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.063 -0400", hash_original_method = "EF8232A158BD658260B74FAB493C1DB9", hash_generated_method = "5D1F40EBDB8B286DA0842A2BD6CB64E3")
    public boolean equals(Object otherObj) {
        try 
        {
            boolean var2384DA1F47F660BFC2C6AFB1911BBAAC_1943773014 = (mTarget.asBinder().equals(((RemoteCallback)otherObj)
                    .mTarget.asBinder()));
        } 
        catch (ClassCastException e)
        { }
        addTaint(otherObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858412905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858412905;
        
        
            
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.064 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "9E55957B1EEC2395F35D85E2F44A4BF7")
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_1772111108 = (mTarget.asBinder().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485189071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485189071;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.065 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "52D561001375BC11E60ADF8F25673437")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837362407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837362407;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.065 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "CB2D00ECBC9E35AA709F7B9DC3B570B9")
    public void writeToParcel(Parcel out, int flags) {
        out.writeStrongBinder(mTarget.asBinder());
        addTaint(out.getTaint());
        addTaint(flags);
        
        
    }

    
    class DeliverResult implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.065 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "2517D973108B732BC287D585B503B92F")

        Bundle mResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.066 -0400", hash_original_method = "8836597D628A377AAE6A26C90BCE24D7", hash_generated_method = "A82DFEA894E0637039F25C70A44639EF")
          DeliverResult(Bundle result) {
            mResult = result;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.066 -0400", hash_original_method = "603C18F53B6556C1CA52545158AE7A51", hash_generated_method = "9E0214968917459FE5CC8F87C4155B4C")
        public void run() {
            onResult(mResult);
            
            
        }

        
    }


    
    class LocalCallback extends IRemoteCallback.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.066 -0400", hash_original_method = "BFAA87962CCB587EAFEDF8FD650DFE0B", hash_generated_method = "BFAA87962CCB587EAFEDF8FD650DFE0B")
        public LocalCallback ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.067 -0400", hash_original_method = "FF1279923A180340D1364807D3537EE5", hash_generated_method = "CF1C051D176A2577708EFFD72AD9E8B8")
        public void sendResult(Bundle bundle) {
            mHandler.post(new DeliverResult(bundle));
            addTaint(bundle.getTaint());
            
            
        }

        
    }


    
    static class RemoteCallbackProxy extends RemoteCallback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.067 -0400", hash_original_method = "883FA11D61E159E4AB8658B2E38FCD52", hash_generated_method = "412D9FFD9DFA23DCA348E77AE57F3443")
          RemoteCallbackProxy(IRemoteCallback target) {
            super(target);
            addTaint(target.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.067 -0400", hash_original_method = "C1383866A4D5D22E2E944ECBE9D44118", hash_generated_method = "53C9A15F32E108D2F7A58D17A06027A8")
        protected void onResult(Bundle bundle) {
            
            addTaint(bundle.getTaint());
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.068 -0400", hash_original_field = "342F5DC731DC7D0C10BC6BF67EBBAD67", hash_generated_field = "0FA4B7A723E7C659BF3C80CC594308CD")

    public static final Parcelable.Creator<RemoteCallback> CREATOR
            = new Parcelable.Creator<RemoteCallback>() {
        public RemoteCallback createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new RemoteCallbackProxy(
                    IRemoteCallback.Stub.asInterface(target)) : null;
        }

        public RemoteCallback[] newArray(int size) {
            return new RemoteCallback[size];
        }
    };
    
    public RemoteCallback createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new RemoteCallbackProxy(
                    IRemoteCallback.Stub.asInterface(target)) : null;
        }
    
    
    public RemoteCallback[] newArray(int size) {
            return new RemoteCallback[size];
        }
    
}

