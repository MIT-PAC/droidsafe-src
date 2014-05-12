package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.ActivityManagerNative;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AndroidException;

public class IntentSender implements Parcelable {

    /**
     * Convenience function for writing either a IntentSender or null pointer to
     * a Parcel.  You must use this with {@link #readIntentSenderOrNullFromParcel}
     * for later reading it.
     *
     * @param sender The IntentSender to write, or null.
     * @param out Where to write the IntentSender.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.942 -0500", hash_original_method = "6C963751BCEA889F1738E724FB60F335", hash_generated_method = "271504758360ECB23D4E9B8D700F4D5D")
    
public static void writeIntentSenderOrNullToParcel(IntentSender sender,
            Parcel out) {
        out.writeStrongBinder(sender != null ? sender.mTarget.asBinder()
                : null);
    }

    /**
     * Convenience function for reading either a Messenger or null pointer from
     * a Parcel.  You must have previously written the Messenger with
     * {@link #writeIntentSenderOrNullToParcel}.
     *
     * @param in The Parcel containing the written Messenger.
     *
     * @return Returns the Messenger read from the Parcel, or null if null had
     * been written.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.945 -0500", hash_original_method = "B55674084F8D58A84815EA2889B6899B", hash_generated_method = "E778A764403FA108DBB174868BBC631F")
    
public static IntentSender readIntentSenderOrNullFromParcel(Parcel in) {
        IBinder b = in.readStrongBinder();
        return b != null ? new IntentSender(b) : null;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.615 -0400", hash_original_field = "65DC812B4255A97B0E3B4F361B82E6A8", hash_generated_field = "4F4C19488EB89DC17DFA975D7E159256")

    public static final Parcelable.Creator<IntentSender> CREATOR
            = new Parcelable.Creator<IntentSender>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.935 -0500", hash_original_method = "9EBED1E4C9B1116F65CFE56A6D80D60B", hash_generated_method = "88ABDB7AAC9BACBFD6A52657F0A6A102")
        
public IntentSender createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new IntentSender(target) : null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.937 -0500", hash_original_method = "84580E1B5D89D11FC23483F45AAA5446", hash_generated_method = "D35BBD423285BC5BE2B9A412D3C39958")
        
public IntentSender[] newArray(int size) {
            return new IntentSender[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.877 -0500", hash_original_field = "1D491A99AD04D3B16F7131B168BB0724", hash_generated_field = "E4E58773DF3C0920C12AA38B8FC403A5")

    private  IIntentSender mTarget;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.949 -0500", hash_original_method = "BB3BE3704C38C3CFAEE93A10A1B40CE3", hash_generated_method = "021520829DAFF578FDAFCBEC6E09EBB3")
    
public IntentSender(IIntentSender target) {
        mTarget = target;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.952 -0500", hash_original_method = "34B28E745C82742C6DB129EED6A7ACD1", hash_generated_method = "D8A6C55E23B3D418AE1EC3965469E26C")
    
public IntentSender(IBinder target) {
        mTarget = IIntentSender.Stub.asInterface(target);
    }

    /**
     * Perform the operation associated with this IntentSender, allowing the
     * caller to specify information about the Intent to use and be notified
     * when the send has completed.
     *
     * @param context The Context of the caller.  This may be null if
     * <var>intent</var> is also null.
     * @param code Result code to supply back to the IntentSender's target.
     * @param intent Additional Intent data.  See {@link Intent#fillIn
     * Intent.fillIn()} for information on how this is applied to the
     * original Intent.  Use null to not modify the original Intent.
     * @param onFinished The object to call back on when the send has
     * completed, or null for no callback.
     * @param handler Handler identifying the thread on which the callback
     * should happen.  If null, the callback will happen from the thread
     * pool of the process.
     *
     *
     * @throws SendIntentException Throws CanceledIntentException if the IntentSender
     * is no longer allowing more intents to be sent through it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.916 -0500", hash_original_method = "D1640EC79CDF4472CD1CED043D9B375E", hash_generated_method = "079929191D4B2BC1FB9DE8D408F62E38")
    
public void sendIntent(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler) throws SendIntentException {
        sendIntent(context, code, intent, onFinished, handler, null);
    }

    /**
     * Perform the operation associated with this IntentSender, allowing the
     * caller to specify information about the Intent to use and be notified
     * when the send has completed.
     *
     * @param context The Context of the caller.  This may be null if
     * <var>intent</var> is also null.
     * @param code Result code to supply back to the IntentSender's target.
     * @param intent Additional Intent data.  See {@link Intent#fillIn
     * Intent.fillIn()} for information on how this is applied to the
     * original Intent.  Use null to not modify the original Intent.
     * @param onFinished The object to call back on when the send has
     * completed, or null for no callback.
     * @param handler Handler identifying the thread on which the callback
     * should happen.  If null, the callback will happen from the thread
     * pool of the process.
     * @param requiredPermission Name of permission that a recipient of the PendingIntent
     * is required to hold.  This is only valid for broadcast intents, and
     * corresponds to the permission argument in
     * {@link Context#sendBroadcast(Intent, String) Context.sendOrderedBroadcast(Intent, String)}.
     * If null, no permission is required.
     *
     *
     * @throws SendIntentException Throws CanceledIntentException if the IntentSender
     * is no longer allowing more intents to be sent through it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.918 -0500", hash_original_method = "5984C2C3625490063272E3C39EF4CC1F", hash_generated_method = "12DC20371BDEB6568EC2C247E4B2AFF5")
    
public void sendIntent(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler, String requiredPermission)
            throws SendIntentException {
        try {
            String resolvedType = intent != null ?
                    intent.resolveTypeIfNeeded(context.getContentResolver())
                    : null;
            int res = mTarget.send(code, intent, resolvedType,
                    onFinished != null
                            ? new FinishedDispatcher(this, onFinished, handler)
                            : null,
                    requiredPermission);
            if (res < 0) {
                throw new SendIntentException();
            }
        } catch (RemoteException e) {
            throw new SendIntentException();
        }
    }

    /**
     * Return the package name of the application that created this
     * IntentSender, that is the identity under which you will actually be
     * sending the Intent.  The returned string is supplied by the system, so
     * that an application can not spoof its package.
     *
     * @return The package name of the PendingIntent, or null if there is
     * none associated with it.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.921 -0500", hash_original_method = "1AE048A4984F76615C0EAE5393ABDA6D", hash_generated_method = "D3A6F32790B99E339D9B68926FE71FFC")
    
public String getTargetPackage() {
        try {
            return ActivityManagerNative.getDefault()
                .getPackageForIntentSender(mTarget);
        } catch (RemoteException e) {
            // Should never happen.
            return null;
        }
    }

    /**
     * Comparison operator on two IntentSender objects, such that true
     * is returned then they both represent the same operation from the
     * same package.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.924 -0500", hash_original_method = "B8F30F83DBAD000A3D0EE0DBD675E1EE", hash_generated_method = "6AF4814ABD5B5863B20866BB9631C60E")
    
@Override
    public boolean equals(Object otherObj) {
        if (otherObj instanceof IntentSender) {
            return mTarget.asBinder().equals(((IntentSender)otherObj)
                    .mTarget.asBinder());
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.926 -0500", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "E62183137C3FCEB0B112CE7C5C0D4444")
    
@Override
    public int hashCode() {
        return mTarget.asBinder().hashCode();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.928 -0500", hash_original_method = "E43F03B5A25195808BB96BD150CAE514", hash_generated_method = "0B752AB7B9E0152B84FED9524E5B4711")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("IntentSender{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(": ");
        sb.append(mTarget != null ? mTarget.asBinder() : null);
        sb.append('}');
        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.930 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.932 -0500", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "5FB48EDF3036D823DDA10D61F6FC459B")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeStrongBinder(mTarget.asBinder());
    }
    
    public static class SendIntentException extends AndroidException {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.880 -0500", hash_original_method = "3CCB3E3C6E6C65C0BEBBCAEF78CD6FBE", hash_generated_method = "77AA74C5FFB490F5242AC52254BDA8F7")
        
public SendIntentException() {
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.882 -0500", hash_original_method = "2F0F888808ED374E72461686A526DBD5", hash_generated_method = "FC1B19C1AA015538A5FA8B17571F2263")
        
public SendIntentException(String name) {
            super(name);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.885 -0500", hash_original_method = "124D84CE7C7EE822BF41BDFAD538F007", hash_generated_method = "04DA53A03084AFA188049DF6AF2603E5")
        
public SendIntentException(Exception cause) {
            super(cause);
        }
        
    }
    
    private static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.891 -0500", hash_original_field = "C2EA9A43743358A3C998801FA614EA9F", hash_generated_field = "84BD9A0534D27174DCB55615309E820B")

        private  IntentSender mIntentSender;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.893 -0500", hash_original_field = "064BC46820F6CAC18F4A40662540577B", hash_generated_field = "3E0837F5746BF0F0EA46630CD994FC89")

        private  OnFinished mWho;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.896 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private  Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.898 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.900 -0500", hash_original_field = "457E6BFD9A88F809DF3F4A88B9B7B893", hash_generated_field = "77069BAE5867220B0011AB47341F29C2")

        private int mResultCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.903 -0500", hash_original_field = "9297DC4168CE0E61BD9D0F02E127B543", hash_generated_field = "C1E52350501391E7118DB73479974476")

        private String mResultData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.905 -0500", hash_original_field = "F5C1D34888409EAA7782FD08EA76AE47", hash_generated_field = "109BE0C611CD1E4823349D5DAFA222D0")

        private Bundle mResultExtras;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.907 -0500", hash_original_method = "758C8818FE8D792B6839EA2D78825DC2", hash_generated_method = "758C8818FE8D792B6839EA2D78825DC2")
        
FinishedDispatcher(IntentSender pi, OnFinished who, Handler handler) {
            mIntentSender = pi;
            mWho = who;
            mHandler = handler;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.910 -0500", hash_original_method = "B0E285A2D8AA1A0003201E2D8F6F7169", hash_generated_method = "28B5F41CEB7ECE4D1A59129F3C7D959D")
        
public void performReceive(Intent intent, int resultCode,
                String data, Bundle extras, boolean serialized, boolean sticky) {
            mIntent = intent;
            mResultCode = resultCode;
            mResultData = data;
            mResultExtras = extras;
            if (mHandler == null) {
                run();
            } else {
                mHandler.post(this);
            }
        }
        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.912 -0500", hash_original_method = "81E3A612882F37B7E9D205FA2DF9669A", hash_generated_method = "153E5A398429A1B9066DEDCBADE789D0")
        
public void run() {
            mWho.onSendFinished(mIntentSender, mIntent, mResultCode,
                    mResultData, mResultExtras);
        }
        
    }
    
    public interface OnFinished {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onSendFinished(IntentSender IntentSender, Intent intent,
                int resultCode, String resultData, Bundle resultExtras);
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.947 -0500", hash_original_method = "5A73019C5B7699A011E114A766F68ECD", hash_generated_method = "147FBD3908885E3E49DD8E1224C6EDEA")
    
public IIntentSender getTarget() {
        return mTarget;
    }
    // orphaned legacy method
    public IntentSender createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new IntentSender(target) : null;
        }
    
    // orphaned legacy method
    public IntentSender[] newArray(int size) {
            return new IntentSender[size];
        }
    
}

