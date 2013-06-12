package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final IIntentSender mTarget;
    public static final Parcelable.Creator<IntentSender> CREATOR = new Parcelable.Creator<IntentSender>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.790 -0400", hash_original_method = "9EBED1E4C9B1116F65CFE56A6D80D60B", hash_generated_method = "9A523FDCE8A4EE24460BDC4384C18365")
        @DSModeled(DSC.SAFE)
        public IntentSender createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            IBinder target;
            target = in.readStrongBinder();
            return (IntentSender)dsTaint.getTaint();
            // ---------- Original Method ----------
            //IBinder target = in.readStrongBinder();
            //return target != null ? new IntentSender(target) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.790 -0400", hash_original_method = "84580E1B5D89D11FC23483F45AAA5446", hash_generated_method = "131AC5986D7430AD951ECEC52DE67A33")
        @DSModeled(DSC.SAFE)
        public IntentSender[] newArray(int size) {
            dsTaint.addTaint(size);
            return (IntentSender[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new IntentSender[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.790 -0400", hash_original_method = "BB3BE3704C38C3CFAEE93A10A1B40CE3", hash_generated_method = "23283AD545FADD18EE5F4E7709A4B8EA")
    @DSModeled(DSC.SAFE)
    public IntentSender(IIntentSender target) {
        dsTaint.addTaint(target.dsTaint);
        mTarget = target;
        // ---------- Original Method ----------
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.791 -0400", hash_original_method = "34B28E745C82742C6DB129EED6A7ACD1", hash_generated_method = "D986C4C422753E0496B6F72876A1AE3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntentSender(IBinder target) {
        dsTaint.addTaint(target.dsTaint);
        mTarget = IIntentSender.Stub.asInterface(target);
        // ---------- Original Method ----------
        //mTarget = IIntentSender.Stub.asInterface(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.791 -0400", hash_original_method = "D1640EC79CDF4472CD1CED043D9B375E", hash_generated_method = "205FC46ABF8CC2BD706B3675ACC053A2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.791 -0400", hash_original_method = "5984C2C3625490063272E3C39EF4CC1F", hash_generated_method = "EFE89268CC750F93810541AA62063C21")
    @DSModeled(DSC.SPEC)
    public void sendIntent(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler, String requiredPermission) throws SendIntentException {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(code);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(requiredPermission);
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
                throw new SendIntentException();
            } //End block
        } //End block
        catch (RemoteException e)
        {
            throw new SendIntentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.791 -0400", hash_original_method = "1AE048A4984F76615C0EAE5393ABDA6D", hash_generated_method = "B70A7AA62C398347C945E8759E225E32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTargetPackage() {
        try 
        {
            String var8CF6AA73CA43B222C8C44A06E8A761AA_2066364087 = (ActivityManagerNative.getDefault()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.792 -0400", hash_original_method = "B8F30F83DBAD000A3D0EE0DBD675E1EE", hash_generated_method = "A6EE386DF25D3510BD969C300A3D26CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object otherObj) {
        dsTaint.addTaint(otherObj.dsTaint);
        {
            boolean var6AAA5F34DD06D56119CF1CEA2623D5C0_1704852310 = (mTarget.asBinder().equals(((IntentSender)otherObj)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.792 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "D5B4D3425B2EBECA0EBA4EC47BB15CF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_603286295 = (mTarget.asBinder().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.792 -0400", hash_original_method = "E43F03B5A25195808BB96BD150CAE514", hash_generated_method = "0D3E6DF07C539E2DC30631BE855ACC4D")
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
        String var806458D832AB974D230FEE4CBBDBD390_1520816994 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.792 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.793 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "4DBC8FF64D1607D57C2D13908DAFE7EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeStrongBinder(mTarget.asBinder());
        // ---------- Original Method ----------
        //out.writeStrongBinder(mTarget.asBinder());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.793 -0400", hash_original_method = "6C963751BCEA889F1738E724FB60F335", hash_generated_method = "271504758360ECB23D4E9B8D700F4D5D")
    public static void writeIntentSenderOrNullToParcel(IntentSender sender,
            Parcel out) {
        out.writeStrongBinder(sender != null ? sender.mTarget.asBinder()
                : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.793 -0400", hash_original_method = "B55674084F8D58A84815EA2889B6899B", hash_generated_method = "E778A764403FA108DBB174868BBC631F")
    public static IntentSender readIntentSenderOrNullFromParcel(Parcel in) {
        IBinder b = in.readStrongBinder();
        return b != null ? new IntentSender(b) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.793 -0400", hash_original_method = "5A73019C5B7699A011E114A766F68ECD", hash_generated_method = "48BD5E2370ADA60485AFECBD65DFFEB3")
    @DSModeled(DSC.SAFE)
    public IIntentSender getTarget() {
        return (IIntentSender)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    public static class SendIntentException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.793 -0400", hash_original_method = "3CCB3E3C6E6C65C0BEBBCAEF78CD6FBE", hash_generated_method = "2FDA0B64B60EC014C3466C0FD1E79A1B")
        @DSModeled(DSC.SAFE)
        public SendIntentException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.793 -0400", hash_original_method = "2F0F888808ED374E72461686A526DBD5", hash_generated_method = "127F4ED24EEC8A81A9A4CF55435779C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SendIntentException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.794 -0400", hash_original_method = "124D84CE7C7EE822BF41BDFAD538F007", hash_generated_method = "CCD5F23A253396D8B0941F1868538A36")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SendIntentException(Exception cause) {
            super(cause);
            dsTaint.addTaint(cause.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
        private final IntentSender mIntentSender;
        private final OnFinished mWho;
        private final Handler mHandler;
        private Intent mIntent;
        private int mResultCode;
        private String mResultData;
        private Bundle mResultExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.794 -0400", hash_original_method = "758C8818FE8D792B6839EA2D78825DC2", hash_generated_method = "805E09F733177944AE1044FAE7B546BD")
        @DSModeled(DSC.SAFE)
         FinishedDispatcher(IntentSender pi, OnFinished who, Handler handler) {
            dsTaint.addTaint(pi.dsTaint);
            dsTaint.addTaint(who.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            mIntentSender = pi;
            mWho = who;
            mHandler = handler;
            // ---------- Original Method ----------
            //mIntentSender = pi;
            //mWho = who;
            //mHandler = handler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.794 -0400", hash_original_method = "B0E285A2D8AA1A0003201E2D8F6F7169", hash_generated_method = "5333CC724ADDEEECE69A3E90AF422276")
        @DSModeled(DSC.SPEC)
        public void performReceive(Intent intent, int resultCode,
                String data, Bundle extras, boolean serialized, boolean sticky) {
            dsTaint.addTaint(serialized);
            dsTaint.addTaint(sticky);
            dsTaint.addTaint(resultCode);
            dsTaint.addTaint(data);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.794 -0400", hash_original_method = "81E3A612882F37B7E9D205FA2DF9669A", hash_generated_method = "8E2F0039FF557F0AF44F2175CB613142")
        @DSModeled(DSC.SAFE)
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
    
}


