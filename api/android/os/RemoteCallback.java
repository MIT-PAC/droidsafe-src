package android.os;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class RemoteCallback implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.470 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.470 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "2AB83AA43D542094128EC2A15E8F4E08")

    IRemoteCallback mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.472 -0400", hash_original_method = "50DD48E58CB649CEFAA75AE1D62E7A3D", hash_generated_method = "106DDBD9A30F2F286547618F0B5D5A39")
    public  RemoteCallback(Handler handler) {
        mHandler = handler;
        mTarget = new LocalCallback();
        // ---------- Original Method ----------
        //mHandler = handler;
        //mTarget = new LocalCallback();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.473 -0400", hash_original_method = "0B794F9104639CB6919FB2A3A2B6E7D4", hash_generated_method = "D4A0AC52F8E4448E204454433D057D67")
      RemoteCallback(IRemoteCallback target) {
        mHandler = null;
        mTarget = target;
        // ---------- Original Method ----------
        //mHandler = null;
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.473 -0400", hash_original_method = "AAFA6B317F34ECAA46BF4F3A7ADBE4F2", hash_generated_method = "6F2A3ACF45D152C14FEC853D111C982E")
    public void sendResult(Bundle bundle) throws RemoteException {
        addTaint(bundle.getTaint());
        mTarget.sendResult(bundle);
        // ---------- Original Method ----------
        //mTarget.sendResult(bundle);
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void onResult(Bundle bundle);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.475 -0400", hash_original_method = "EF8232A158BD658260B74FAB493C1DB9", hash_generated_method = "18BE7B8A1F6C083E5F8014856123A4CD")
    public boolean equals(Object otherObj) {
        addTaint(otherObj.getTaint());
        if(otherObj == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_388040828 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745762062 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_745762062;
        } //End block
        try 
        {
            boolean varD1389714F0F009155EA48014426114F1_1899768105 = (mTarget.asBinder().equals(((RemoteCallback)otherObj)
                    .mTarget.asBinder()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_310341981 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_310341981;
        } //End block
        catch (ClassCastException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1516075275 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1795577741 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1795577741;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.476 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "B8D80A4924A0BDC275184CFE9BBF7798")
    public int hashCode() {
        int var015DBE14D40CCC902461F5EB4537F2D8_1269724626 = (mTarget.asBinder().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917490237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917490237;
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.477 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E48C441F096521902EC69D8FD4C8E6EF")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_480167389 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921920453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921920453;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.478 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "C7A202EDEDAAFB23E59B79A7FE9B7381")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeStrongBinder(mTarget.asBinder());
        // ---------- Original Method ----------
        //out.writeStrongBinder(mTarget.asBinder());
    }

    
    class DeliverResult implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.479 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "2517D973108B732BC287D585B503B92F")

        Bundle mResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.479 -0400", hash_original_method = "8836597D628A377AAE6A26C90BCE24D7", hash_generated_method = "A82DFEA894E0637039F25C70A44639EF")
          DeliverResult(Bundle result) {
            mResult = result;
            // ---------- Original Method ----------
            //mResult = result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.480 -0400", hash_original_method = "603C18F53B6556C1CA52545158AE7A51", hash_generated_method = "9E0214968917459FE5CC8F87C4155B4C")
        public void run() {
            onResult(mResult);
            // ---------- Original Method ----------
            //onResult(mResult);
        }

        
    }


    
    class LocalCallback extends IRemoteCallback.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.480 -0400", hash_original_method = "BFAA87962CCB587EAFEDF8FD650DFE0B", hash_generated_method = "BFAA87962CCB587EAFEDF8FD650DFE0B")
        public LocalCallback ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.481 -0400", hash_original_method = "FF1279923A180340D1364807D3537EE5", hash_generated_method = "8F8150F0775E4B1C33482C77E3C9CDF2")
        public void sendResult(Bundle bundle) {
            addTaint(bundle.getTaint());
            mHandler.post(new DeliverResult(bundle));
            // ---------- Original Method ----------
            //mHandler.post(new DeliverResult(bundle));
        }

        
    }


    
    static class RemoteCallbackProxy extends RemoteCallback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.482 -0400", hash_original_method = "883FA11D61E159E4AB8658B2E38FCD52", hash_generated_method = "412D9FFD9DFA23DCA348E77AE57F3443")
          RemoteCallbackProxy(IRemoteCallback target) {
            super(target);
            addTaint(target.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.482 -0400", hash_original_method = "C1383866A4D5D22E2E944ECBE9D44118", hash_generated_method = "53C9A15F32E108D2F7A58D17A06027A8")
        protected void onResult(Bundle bundle) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(bundle.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.482 -0400", hash_original_field = "342F5DC731DC7D0C10BC6BF67EBBAD67", hash_generated_field = "0FA4B7A723E7C659BF3C80CC594308CD")

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
    // orphaned legacy method
    public RemoteCallback createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new RemoteCallbackProxy(
                    IRemoteCallback.Stub.asInterface(target)) : null;
        }
    
    // orphaned legacy method
    public RemoteCallback[] newArray(int size) {
            return new RemoteCallback[size];
        }
    
}

