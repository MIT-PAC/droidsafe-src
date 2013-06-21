package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class RemoteCallback implements Parcelable {
    Handler mHandler;
    IRemoteCallback mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.143 -0400", hash_original_method = "50DD48E58CB649CEFAA75AE1D62E7A3D", hash_generated_method = "D068F3227B96FBABA6EED2C6B8B4EF9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RemoteCallback(Handler handler) {
        dsTaint.addTaint(handler.dsTaint);
        mTarget = new LocalCallback();
        // ---------- Original Method ----------
        //mHandler = handler;
        //mTarget = new LocalCallback();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.143 -0400", hash_original_method = "0B794F9104639CB6919FB2A3A2B6E7D4", hash_generated_method = "7B2D61BFE6E5274BCE8DFCD11B2639ED")
    @DSModeled(DSC.SAFE)
     RemoteCallback(IRemoteCallback target) {
        dsTaint.addTaint(target.dsTaint);
        mHandler = null;
        // ---------- Original Method ----------
        //mHandler = null;
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.144 -0400", hash_original_method = "AAFA6B317F34ECAA46BF4F3A7ADBE4F2", hash_generated_method = "9A5056411A2B44B1E3F5929536D13D89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendResult(Bundle bundle) throws RemoteException {
        dsTaint.addTaint(bundle.dsTaint);
        mTarget.sendResult(bundle);
        // ---------- Original Method ----------
        //mTarget.sendResult(bundle);
    }

    
    protected abstract void onResult(Bundle bundle);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.144 -0400", hash_original_method = "EF8232A158BD658260B74FAB493C1DB9", hash_generated_method = "C112E6E9923ABF42813262328D67DEB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object otherObj) {
        dsTaint.addTaint(otherObj.dsTaint);
        try 
        {
            boolean var2384DA1F47F660BFC2C6AFB1911BBAAC_1867126614 = (mTarget.asBinder().equals(((RemoteCallback)otherObj)
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
            //return mTarget.asBinder().equals(((RemoteCallback)otherObj)
                    //.mTarget.asBinder());
        //} catch (ClassCastException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.144 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "C98CC2AFAA303EEE28C5A442FFD99E9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_916614755 = (mTarget.asBinder().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.145 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.145 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "82E673ADF87F6A34F82CD67D6313EA4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeStrongBinder(mTarget.asBinder());
        // ---------- Original Method ----------
        //out.writeStrongBinder(mTarget.asBinder());
    }

    
    class DeliverResult implements Runnable {
        Bundle mResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.146 -0400", hash_original_method = "8836597D628A377AAE6A26C90BCE24D7", hash_generated_method = "DB5B651C14224F9551D0330D32E0973E")
        @DSModeled(DSC.SAFE)
         DeliverResult(Bundle result) {
            dsTaint.addTaint(result.dsTaint);
            // ---------- Original Method ----------
            //mResult = result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.148 -0400", hash_original_method = "603C18F53B6556C1CA52545158AE7A51", hash_generated_method = "9E0214968917459FE5CC8F87C4155B4C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            onResult(mResult);
            // ---------- Original Method ----------
            //onResult(mResult);
        }

        
    }


    
    class LocalCallback extends IRemoteCallback.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.148 -0400", hash_original_method = "DD98529ECA4A385CB3D145296ACB07CE", hash_generated_method = "DD98529ECA4A385CB3D145296ACB07CE")
                public LocalCallback ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.148 -0400", hash_original_method = "FF1279923A180340D1364807D3537EE5", hash_generated_method = "0FABAC7580FFB49E62993E28FAE89FCA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void sendResult(Bundle bundle) {
            dsTaint.addTaint(bundle.dsTaint);
            mHandler.post(new DeliverResult(bundle));
            // ---------- Original Method ----------
            //mHandler.post(new DeliverResult(bundle));
        }

        
    }


    
    static class RemoteCallbackProxy extends RemoteCallback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.149 -0400", hash_original_method = "883FA11D61E159E4AB8658B2E38FCD52", hash_generated_method = "1A991096FA34030DF2741BEE71B3DCEF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         RemoteCallbackProxy(IRemoteCallback target) {
            super(target);
            dsTaint.addTaint(target.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.149 -0400", hash_original_method = "C1383866A4D5D22E2E944ECBE9D44118", hash_generated_method = "0FF03DD0DEED6574C52452B2EBD5833F")
        @DSModeled(DSC.SAFE)
        protected void onResult(Bundle bundle) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(bundle.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    public static final Parcelable.Creator<RemoteCallback> CREATOR = new Parcelable.Creator<RemoteCallback>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.149 -0400", hash_original_method = "D7C71538FF6AF5BB1E831523DD5751DF", hash_generated_method = "4BDD01C911747FF184B933C040D5B3EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RemoteCallback createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            IBinder target;
            target = in.readStrongBinder();
            {
                Object var38F358EE1A9B71B7DD0E4AE59B61AB0D_443328517 = (new RemoteCallbackProxy(
                    IRemoteCallback.Stub.asInterface(target)));
            } //End flattened ternary
            return (RemoteCallback)dsTaint.getTaint();
            // ---------- Original Method ----------
            //IBinder target = in.readStrongBinder();
            //return target != null ? new RemoteCallbackProxy(
                    //IRemoteCallback.Stub.asInterface(target)) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.150 -0400", hash_original_method = "0600D833FECA72598EBC0FD684B8E4BB", hash_generated_method = "8B0A9DB2688C6821ACC81E2FCB4075D6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RemoteCallback[] newArray(int size) {
            dsTaint.addTaint(size);
            RemoteCallback[] var599DA5CAC35DDE8E509E81568D8DAA5A_246601815 = (new RemoteCallback[size]);
            return (RemoteCallback[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new RemoteCallback[size];
        }

        
}; //Transformed anonymous class
}

