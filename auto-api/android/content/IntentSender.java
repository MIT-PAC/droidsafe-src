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
    private IIntentSender mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.004 -0400", hash_original_method = "BB3BE3704C38C3CFAEE93A10A1B40CE3", hash_generated_method = "56C692479BA314CFACEE4C3360053498")
    @DSModeled(DSC.SAFE)
    public IntentSender(IIntentSender target) {
        dsTaint.addTaint(target.dsTaint);
        // ---------- Original Method ----------
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.004 -0400", hash_original_method = "34B28E745C82742C6DB129EED6A7ACD1", hash_generated_method = "41D0658C8FCDB2F5DBB38719C9C3BD94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntentSender(IBinder target) {
        dsTaint.addTaint(target.dsTaint);
        mTarget = IIntentSender.Stub.asInterface(target);
        // ---------- Original Method ----------
        //mTarget = IIntentSender.Stub.asInterface(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.004 -0400", hash_original_method = "D1640EC79CDF4472CD1CED043D9B375E", hash_generated_method = "61779D64333A0B2A60579597106DD196")
    @DSModeled(DSC.SPEC)
    public void sendIntent(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler) throws SendIntentException {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(code);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(onFinished.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        sendIntent(context, code, intent, onFinished, handler, null);
        // ---------- Original Method ----------
        //sendIntent(context, code, intent, onFinished, handler, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.005 -0400", hash_original_method = "5984C2C3625490063272E3C39EF4CC1F", hash_generated_method = "FD5AF0F3DB80ED5D554AA036B2E34B36")
    @DSModeled(DSC.SPEC)
    public void sendIntent(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler, String requiredPermission) throws SendIntentException {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(code);
        dsTaint.addTaint(requiredPermission);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(onFinished.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.005 -0400", hash_original_method = "1AE048A4984F76615C0EAE5393ABDA6D", hash_generated_method = "EC700991DB6098E4BAB3330D0FE5DDD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTargetPackage() {
        try 
        {
            String var8CF6AA73CA43B222C8C44A06E8A761AA_1133232316 = (ActivityManagerNative.getDefault()
                .getPackageForIntentSender(mTarget));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getPackageForIntentSender(mTarget);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.005 -0400", hash_original_method = "B8F30F83DBAD000A3D0EE0DBD675E1EE", hash_generated_method = "6F59B4E82921FC9928483F961AD6AC57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object otherObj) {
        dsTaint.addTaint(otherObj.dsTaint);
        {
            boolean var6AAA5F34DD06D56119CF1CEA2623D5C0_564714466 = (mTarget.asBinder().equals(((IntentSender)otherObj)
                    .mTarget.asBinder()));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (otherObj instanceof IntentSender) {
            //return mTarget.asBinder().equals(((IntentSender)otherObj)
                    //.mTarget.asBinder());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.006 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "6BB76D4CBA994B2A05B561511465F370")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_1902186431 = (mTarget.asBinder().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.006 -0400", hash_original_method = "E43F03B5A25195808BB96BD150CAE514", hash_generated_method = "B08E03FA1EB87D246B110DEAA1EFD40D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("IntentSender{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(": ");
        sb.append(mTarget != null ? mTarget.asBinder() : null);
        sb.append('}');
        String var806458D832AB974D230FEE4CBBDBD390_412554629 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("IntentSender{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(": ");
        //sb.append(mTarget != null ? mTarget.asBinder() : null);
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.006 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.007 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "82E673ADF87F6A34F82CD67D6313EA4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeStrongBinder(mTarget.asBinder());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.007 -0400", hash_original_method = "5A73019C5B7699A011E114A766F68ECD", hash_generated_method = "51AE302E39803C6CD97E2EC428B2D4CE")
    @DSModeled(DSC.SAFE)
    public IIntentSender getTarget() {
        return (IIntentSender)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    public static class SendIntentException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.007 -0400", hash_original_method = "3CCB3E3C6E6C65C0BEBBCAEF78CD6FBE", hash_generated_method = "CB8141C05BC43408A5593044AF4551A8")
        @DSModeled(DSC.SAFE)
        public SendIntentException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.008 -0400", hash_original_method = "2F0F888808ED374E72461686A526DBD5", hash_generated_method = "965D6A5E657B3099C58093DF913AB408")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SendIntentException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.008 -0400", hash_original_method = "124D84CE7C7EE822BF41BDFAD538F007", hash_generated_method = "9B7C2B4418CF3D9DDB0DE9F548074706")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SendIntentException(Exception cause) {
            super(cause);
            dsTaint.addTaint(cause.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
        private IntentSender mIntentSender;
        private OnFinished mWho;
        private Handler mHandler;
        private Intent mIntent;
        private int mResultCode;
        private String mResultData;
        private Bundle mResultExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.008 -0400", hash_original_method = "758C8818FE8D792B6839EA2D78825DC2", hash_generated_method = "E193F68BE8451AB20A991B0143B30409")
        @DSModeled(DSC.SAFE)
         FinishedDispatcher(IntentSender pi, OnFinished who, Handler handler) {
            dsTaint.addTaint(pi.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            dsTaint.addTaint(who.dsTaint);
            // ---------- Original Method ----------
            //mIntentSender = pi;
            //mWho = who;
            //mHandler = handler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.018 -0400", hash_original_method = "B0E285A2D8AA1A0003201E2D8F6F7169", hash_generated_method = "65EE97C27361D2FBB9514482476A6398")
        @DSModeled(DSC.SPEC)
        public void performReceive(Intent intent, int resultCode,
                String data, Bundle extras, boolean serialized, boolean sticky) {
            dsTaint.addTaint(sticky);
            dsTaint.addTaint(serialized);
            dsTaint.addTaint(data);
            dsTaint.addTaint(resultCode);
            dsTaint.addTaint(intent.dsTaint);
            dsTaint.addTaint(extras.dsTaint);
            {
                run();
            } //End block
            {
                mHandler.post(this);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.018 -0400", hash_original_method = "81E3A612882F37B7E9D205FA2DF9669A", hash_generated_method = "D912AA0A868C0CF106FF3B723FFC47F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
    
    public static final Parcelable.Creator<IntentSender> CREATOR = new Parcelable.Creator<IntentSender>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.030 -0400", hash_original_method = "9EBED1E4C9B1116F65CFE56A6D80D60B", hash_generated_method = "4CB0A2ADF4195106D250DD1D5796CC4C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public IntentSender createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            IBinder target;
            target = in.readStrongBinder();
            {
                Object varDFC8C68EDE568EE4E4076B5617500F02_663578176 = (new IntentSender(target));
            } //End flattened ternary
            return (IntentSender)dsTaint.getTaint();
            // ---------- Original Method ----------
            //IBinder target = in.readStrongBinder();
            //return target != null ? new IntentSender(target) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.030 -0400", hash_original_method = "84580E1B5D89D11FC23483F45AAA5446", hash_generated_method = "0C15D6671D1478AD0EFDC36D224F9120")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public IntentSender[] newArray(int size) {
            dsTaint.addTaint(size);
            IntentSender[] varB51B49FA4E80F8DE565B68D28190E95A_563008801 = (new IntentSender[size]);
            return (IntentSender[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new IntentSender[size];
        }

        
}; //Transformed anonymous class
}

