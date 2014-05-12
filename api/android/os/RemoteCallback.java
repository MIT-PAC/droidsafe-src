package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class RemoteCallback implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.482 -0400", hash_original_field = "342F5DC731DC7D0C10BC6BF67EBBAD67", hash_generated_field = "0FA4B7A723E7C659BF3C80CC594308CD")

    public static final Parcelable.Creator<RemoteCallback> CREATOR
            = new Parcelable.Creator<RemoteCallback>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.354 -0500", hash_original_method = "D7C71538FF6AF5BB1E831523DD5751DF", hash_generated_method = "8AF557AB7FDF4F12DA5130C605057CC2")
        
public RemoteCallback createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new RemoteCallbackProxy(
                    IRemoteCallback.Stub.asInterface(target)) : null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.356 -0500", hash_original_method = "0600D833FECA72598EBC0FD684B8E4BB", hash_generated_method = "C8A9EAD6F40E10493937D70A85659E8B")
        
public RemoteCallback[] newArray(int size) {
            return new RemoteCallback[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.309 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")

     Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.311 -0500", hash_original_field = "2AB83AA43D542094128EC2A15E8F4E08", hash_generated_field = "2AB83AA43D542094128EC2A15E8F4E08")

     IRemoteCallback mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.333 -0500", hash_original_method = "50DD48E58CB649CEFAA75AE1D62E7A3D", hash_generated_method = "E3308F390518A90E71AC8A2FA9367BF5")
    
public RemoteCallback(Handler handler) {
        mHandler = handler;
        mTarget = new LocalCallback();
    }
    
     @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.337 -0500", hash_original_method = "0B794F9104639CB6919FB2A3A2B6E7D4", hash_generated_method = "0B794F9104639CB6919FB2A3A2B6E7D4")
    
RemoteCallback(IRemoteCallback target) {
        mHandler = null;
        mTarget = target;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.339 -0500", hash_original_method = "AAFA6B317F34ECAA46BF4F3A7ADBE4F2", hash_generated_method = "4C30EB20716F13BBAC725C6C51144497")
    
public void sendResult(Bundle bundle) throws RemoteException {
        mTarget.sendResult(bundle);
    }
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.342 -0500", hash_original_method = "DDBE4F03B4F4F42CB3E14CAE57B6594B", hash_generated_method = "DD6CD927127F6B9BC8B5C25B8638BF91")
    
protected abstract void onResult(Bundle bundle);
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.344 -0500", hash_original_method = "EF8232A158BD658260B74FAB493C1DB9", hash_generated_method = "1BE7A3362E5A3DC4CF5D0052AA7716EB")
    
public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        }
        try {
            return mTarget.asBinder().equals(((RemoteCallback)otherObj)
                    .mTarget.asBinder());
        } catch (ClassCastException e) {
        }
        return false;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.346 -0500", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "D3CD0FF680AAF7AE0414AB6B38BC2F04")
    
public int hashCode() {
        return mTarget.asBinder().hashCode();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.348 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    
    class DeliverResult implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.314 -0500", hash_original_field = "2517D973108B732BC287D585B503B92F", hash_generated_field = "2517D973108B732BC287D585B503B92F")

         Bundle mResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.317 -0500", hash_original_method = "8836597D628A377AAE6A26C90BCE24D7", hash_generated_method = "8836597D628A377AAE6A26C90BCE24D7")
        
DeliverResult(Bundle result) {
            mResult = result;
        }
        
        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.319 -0500", hash_original_method = "603C18F53B6556C1CA52545158AE7A51", hash_generated_method = "E4A96AD2F241C1E6AFF6E991B848CC36")
        
public void run() {
            onResult(mResult);
        }
        
    }
    
    class LocalCallback extends IRemoteCallback.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.480 -0400", hash_original_method = "BFAA87962CCB587EAFEDF8FD650DFE0B", hash_generated_method = "BFAA87962CCB587EAFEDF8FD650DFE0B")
        public LocalCallback ()
        {
            //Synthesized constructor
        }
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.323 -0500", hash_original_method = "FF1279923A180340D1364807D3537EE5", hash_generated_method = "9AC77E0AF70A947EE512BC888F0D69F2")
        
public void sendResult(Bundle bundle) {
            mHandler.post(new DeliverResult(bundle));
        }
        
    }
    
    static class RemoteCallbackProxy extends RemoteCallback {
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.328 -0500", hash_original_method = "883FA11D61E159E4AB8658B2E38FCD52", hash_generated_method = "883FA11D61E159E4AB8658B2E38FCD52")
        
RemoteCallbackProxy(IRemoteCallback target) {
            super(target);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.330 -0500", hash_original_method = "C1383866A4D5D22E2E944ECBE9D44118", hash_generated_method = "CC177A00BFCFC3DABA61BBCC9D5B5374")
        
protected void onResult(Bundle bundle) {
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.351 -0500", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "5FB48EDF3036D823DDA10D61F6FC459B")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeStrongBinder(mTarget.asBinder());
    }
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

