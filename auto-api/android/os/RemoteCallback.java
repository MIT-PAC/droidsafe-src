package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class RemoteCallback implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.110 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.110 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "2AB83AA43D542094128EC2A15E8F4E08")

    IRemoteCallback mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.115 -0400", hash_original_method = "50DD48E58CB649CEFAA75AE1D62E7A3D", hash_generated_method = "106DDBD9A30F2F286547618F0B5D5A39")
    public  RemoteCallback(Handler handler) {
        mHandler = handler;
        mTarget = new LocalCallback();
        // ---------- Original Method ----------
        //mHandler = handler;
        //mTarget = new LocalCallback();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.115 -0400", hash_original_method = "0B794F9104639CB6919FB2A3A2B6E7D4", hash_generated_method = "D4A0AC52F8E4448E204454433D057D67")
      RemoteCallback(IRemoteCallback target) {
        mHandler = null;
        mTarget = target;
        // ---------- Original Method ----------
        //mHandler = null;
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.116 -0400", hash_original_method = "AAFA6B317F34ECAA46BF4F3A7ADBE4F2", hash_generated_method = "79399030FB60A878BB4D2CE67B46F431")
    public void sendResult(Bundle bundle) throws RemoteException {
        mTarget.sendResult(bundle);
        addTaint(bundle.getTaint());
        // ---------- Original Method ----------
        //mTarget.sendResult(bundle);
    }

    
    protected abstract void onResult(Bundle bundle);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.117 -0400", hash_original_method = "EF8232A158BD658260B74FAB493C1DB9", hash_generated_method = "7F3FEE4361B1D5C9FDAAE8C3C784141E")
    public boolean equals(Object otherObj) {
        try 
        {
            boolean var2384DA1F47F660BFC2C6AFB1911BBAAC_1065848075 = (mTarget.asBinder().equals(((RemoteCallback)otherObj)
                    .mTarget.asBinder()));
        } //End block
        catch (ClassCastException e)
        { }
        addTaint(otherObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_795631146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_795631146;
        // ---------- Original Method ----------
        //if (otherObj == null) {
            //return false;
        //}
        //try {
            //return mTarget.asBinder().equals(((RemoteCallback)otherObj)
                    //.mTarget.asBinder());
        //} catch (ClassCastException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.121 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "BFD599D2F803E12536AD102FD6BC0273")
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_1120283130 = (mTarget.asBinder().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122001529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122001529;
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.129 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5085ED9CDEB8CB76319B92B8EA509EA5")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396804889 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396804889;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.136 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "CB2D00ECBC9E35AA709F7B9DC3B570B9")
    public void writeToParcel(Parcel out, int flags) {
        out.writeStrongBinder(mTarget.asBinder());
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //out.writeStrongBinder(mTarget.asBinder());
    }

    
    class DeliverResult implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.136 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "2517D973108B732BC287D585B503B92F")

        Bundle mResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.137 -0400", hash_original_method = "8836597D628A377AAE6A26C90BCE24D7", hash_generated_method = "A82DFEA894E0637039F25C70A44639EF")
          DeliverResult(Bundle result) {
            mResult = result;
            // ---------- Original Method ----------
            //mResult = result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.137 -0400", hash_original_method = "603C18F53B6556C1CA52545158AE7A51", hash_generated_method = "9E0214968917459FE5CC8F87C4155B4C")
        public void run() {
            onResult(mResult);
            // ---------- Original Method ----------
            //onResult(mResult);
        }

        
    }


    
    class LocalCallback extends IRemoteCallback.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.137 -0400", hash_original_method = "BFAA87962CCB587EAFEDF8FD650DFE0B", hash_generated_method = "BFAA87962CCB587EAFEDF8FD650DFE0B")
        public LocalCallback ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.141 -0400", hash_original_method = "FF1279923A180340D1364807D3537EE5", hash_generated_method = "CF1C051D176A2577708EFFD72AD9E8B8")
        public void sendResult(Bundle bundle) {
            mHandler.post(new DeliverResult(bundle));
            addTaint(bundle.getTaint());
            // ---------- Original Method ----------
            //mHandler.post(new DeliverResult(bundle));
        }

        
    }


    
    static class RemoteCallbackProxy extends RemoteCallback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.142 -0400", hash_original_method = "883FA11D61E159E4AB8658B2E38FCD52", hash_generated_method = "412D9FFD9DFA23DCA348E77AE57F3443")
          RemoteCallbackProxy(IRemoteCallback target) {
            super(target);
            addTaint(target.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.154 -0400", hash_original_method = "C1383866A4D5D22E2E944ECBE9D44118", hash_generated_method = "53C9A15F32E108D2F7A58D17A06027A8")
        protected void onResult(Bundle bundle) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(bundle.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.154 -0400", hash_original_field = "342F5DC731DC7D0C10BC6BF67EBBAD67", hash_generated_field = "0FA4B7A723E7C659BF3C80CC594308CD")

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
}

