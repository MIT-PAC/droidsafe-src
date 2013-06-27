package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.ActivityManagerNative;
import android.content.Context;
import android.content.Intent;
import android.content.IIntentSender;
import android.content.IIntentReceiver;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AndroidException;

public class IntentSender implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.146 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "E4E58773DF3C0920C12AA38B8FC403A5")

    private IIntentSender mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.147 -0400", hash_original_method = "BB3BE3704C38C3CFAEE93A10A1B40CE3", hash_generated_method = "2663241EBD81A494CAEAE58B33F2DC66")
    public  IntentSender(IIntentSender target) {
        mTarget = target;
        // ---------- Original Method ----------
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.148 -0400", hash_original_method = "34B28E745C82742C6DB129EED6A7ACD1", hash_generated_method = "14968660335B1B1B82B8A923154417D9")
    public  IntentSender(IBinder target) {
        mTarget = IIntentSender.Stub.asInterface(target);
        // ---------- Original Method ----------
        //mTarget = IIntentSender.Stub.asInterface(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.164 -0400", hash_original_method = "D1640EC79CDF4472CD1CED043D9B375E", hash_generated_method = "9D655C93143908F72EFA0BD754768A5B")
    public void sendIntent(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler) throws SendIntentException {
        sendIntent(context, code, intent, onFinished, handler, null);
        addTaint(context.getTaint());
        addTaint(code);
        addTaint(intent.getTaint());
        addTaint(onFinished.getTaint());
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
        //sendIntent(context, code, intent, onFinished, handler, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.166 -0400", hash_original_method = "5984C2C3625490063272E3C39EF4CC1F", hash_generated_method = "D7693A78E3FE9475A4C483B0E214046A")
    public void sendIntent(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler, String requiredPermission) throws SendIntentException {
        try 
        {
            String resolvedType;
            resolvedType = intent.resolveTypeIfNeeded(context.getContentResolver());
            resolvedType = null;
            int res;
            res = mTarget.send(code, intent, resolvedType,
                    onFinished != null
                            ? new FinishedDispatcher(this, onFinished, handler)
                            : null,
                    requiredPermission);//DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                if (DroidSafeAndroidRuntime.control) throw new SendIntentException();
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SendIntentException();
        } //End block
        addTaint(context.getTaint());
        addTaint(code);
        addTaint(intent.getTaint());
        addTaint(onFinished.getTaint());
        addTaint(handler.getTaint());
        addTaint(requiredPermission.getTaint());
        // ---------- Original Method ----------
        //try {
            //String resolvedType = intent != null ?
                    //intent.resolveTypeIfNeeded(context.getContentResolver())
                    //: null;
            //int res = mTarget.send(code, intent, resolvedType,
                    //onFinished != null
                            //? new FinishedDispatcher(this, onFinished, handler)
                            //: null,
                    //requiredPermission);
            //if (res < 0) {
                //throw new SendIntentException();
            //}
        //} catch (RemoteException e) {
            //throw new SendIntentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.240 -0400", hash_original_method = "1AE048A4984F76615C0EAE5393ABDA6D", hash_generated_method = "35595397D4A6CBEEFD512C47C376DFF0")
    public String getTargetPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1984190353 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2126559209 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1984190353 = ActivityManagerNative.getDefault()
                .getPackageForIntentSender(mTarget);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2126559209 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1840265300; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1840265300 = varB4EAC82CA7396A68D541C85D26508E83_1984190353;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1840265300 = varB4EAC82CA7396A68D541C85D26508E83_2126559209;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1840265300.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1840265300;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getPackageForIntentSender(mTarget);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.252 -0400", hash_original_method = "B8F30F83DBAD000A3D0EE0DBD675E1EE", hash_generated_method = "B463D1400AEF692BF34FC3A5FEE13E31")
    @Override
    public boolean equals(Object otherObj) {
        {
            boolean var6AAA5F34DD06D56119CF1CEA2623D5C0_1136494673 = (mTarget.asBinder().equals(((IntentSender)otherObj)
                    .mTarget.asBinder()));
        } //End block
        addTaint(otherObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1950155765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1950155765;
        // ---------- Original Method ----------
        //if (otherObj instanceof IntentSender) {
            //return mTarget.asBinder().equals(((IntentSender)otherObj)
                    //.mTarget.asBinder());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.253 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "F91F824223858872D549655DC388F1C0")
    @Override
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_1772503036 = (mTarget.asBinder().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1129320348 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1129320348;
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.254 -0400", hash_original_method = "E43F03B5A25195808BB96BD150CAE514", hash_generated_method = "E02D8D4758289DAD4FD158FFE1F61DAE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_727247498 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("IntentSender{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(": ");
        sb.append(mTarget != null ? mTarget.asBinder() : null);
        sb.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_727247498 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_727247498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_727247498;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("IntentSender{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(": ");
        //sb.append(mTarget != null ? mTarget.asBinder() : null);
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.255 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A5A8386DDCBB616CD69C672F4F2DAB5A")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959105329 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959105329;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.280 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "CB2D00ECBC9E35AA709F7B9DC3B570B9")
    public void writeToParcel(Parcel out, int flags) {
        out.writeStrongBinder(mTarget.asBinder());
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //out.writeStrongBinder(mTarget.asBinder());
    }

    
        public static void writeIntentSenderOrNullToParcel(IntentSender sender,
            Parcel out) {
        out.writeStrongBinder(sender != null ? sender.mTarget.asBinder()
                : null);
    }

    
        public static IntentSender readIntentSenderOrNullFromParcel(Parcel in) {
        IBinder b = in.readStrongBinder();
        return b != null ? new IntentSender(b) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.291 -0400", hash_original_method = "5A73019C5B7699A011E114A766F68ECD", hash_generated_method = "B61C3975B2E51D5E5768EE86CE07283F")
    public IIntentSender getTarget() {
        IIntentSender varB4EAC82CA7396A68D541C85D26508E83_635495676 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_635495676 = mTarget;
        varB4EAC82CA7396A68D541C85D26508E83_635495676.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_635495676;
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    public static class SendIntentException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.292 -0400", hash_original_method = "3CCB3E3C6E6C65C0BEBBCAEF78CD6FBE", hash_generated_method = "CB8141C05BC43408A5593044AF4551A8")
        public  SendIntentException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.302 -0400", hash_original_method = "2F0F888808ED374E72461686A526DBD5", hash_generated_method = "3D65C4B9722C2C702E36855D4994E789")
        public  SendIntentException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.303 -0400", hash_original_method = "124D84CE7C7EE822BF41BDFAD538F007", hash_generated_method = "F92E006546D061799119E44C8681B178")
        public  SendIntentException(Exception cause) {
            super(cause);
            addTaint(cause.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.303 -0400", hash_original_field = "61ADD1865F3B86CD9BF213685358F4E1", hash_generated_field = "84BD9A0534D27174DCB55615309E820B")

        private IntentSender mIntentSender;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.303 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "3E0837F5746BF0F0EA46630CD994FC89")

        private OnFinished mWho;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.303 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.303 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.304 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "77069BAE5867220B0011AB47341F29C2")

        private int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.304 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "C1E52350501391E7118DB73479974476")

        private String mResultData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.321 -0400", hash_original_field = "15A7BDFA2595DFC979A8B0D8A65ABE14", hash_generated_field = "109BE0C611CD1E4823349D5DAFA222D0")

        private Bundle mResultExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.322 -0400", hash_original_method = "758C8818FE8D792B6839EA2D78825DC2", hash_generated_method = "5C21FDD7EDE5604E0F4AD647B421C7AE")
          FinishedDispatcher(IntentSender pi, OnFinished who, Handler handler) {
            mIntentSender = pi;
            mWho = who;
            mHandler = handler;
            // ---------- Original Method ----------
            //mIntentSender = pi;
            //mWho = who;
            //mHandler = handler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.330 -0400", hash_original_method = "B0E285A2D8AA1A0003201E2D8F6F7169", hash_generated_method = "0538DA2A05217B942D752ECF6F421D27")
        public void performReceive(Intent intent, int resultCode,
                String data, Bundle extras, boolean serialized, boolean sticky) {
            mIntent = intent;
            mResultCode = resultCode;
            mResultData = data;
            mResultExtras = extras;
            {
                run();
            } //End block
            {
                mHandler.post(this);
            } //End block
            addTaint(serialized);
            addTaint(sticky);
            // ---------- Original Method ----------
            //mIntent = intent;
            //mResultCode = resultCode;
            //mResultData = data;
            //mResultExtras = extras;
            //if (mHandler == null) {
                //run();
            //} else {
                //mHandler.post(this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.347 -0400", hash_original_method = "81E3A612882F37B7E9D205FA2DF9669A", hash_generated_method = "D912AA0A868C0CF106FF3B723FFC47F3")
        public void run() {
            mWho.onSendFinished(mIntentSender, mIntent, mResultCode,
                    mResultData, mResultExtras);
            // ---------- Original Method ----------
            //mWho.onSendFinished(mIntentSender, mIntent, mResultCode,
                    //mResultData, mResultExtras);
        }

        
    }


    
    public interface OnFinished {
        
        void onSendFinished(IntentSender IntentSender, Intent intent,
                int resultCode, String resultData, Bundle resultExtras);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.347 -0400", hash_original_field = "65DC812B4255A97B0E3B4F361B82E6A8", hash_generated_field = "4F4C19488EB89DC17DFA975D7E159256")

    public static final Parcelable.Creator<IntentSender> CREATOR
            = new Parcelable.Creator<IntentSender>() {
        public IntentSender createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new IntentSender(target) : null;
        }

        public IntentSender[] newArray(int size) {
            return new IntentSender[size];
        }
    };
}

