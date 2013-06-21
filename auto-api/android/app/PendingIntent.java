package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.Intent;
import android.content.IIntentReceiver;
import android.content.IIntentSender;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AndroidException;

public final class PendingIntent implements Parcelable {
    private IIntentSender mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.515 -0400", hash_original_method = "3ACE5727953950B87626FD6380A23370", hash_generated_method = "4053841FAA1FEDA027458B73E7157C01")
    @DSModeled(DSC.SAFE)
     PendingIntent(IIntentSender target) {
        dsTaint.addTaint(target.dsTaint);
        // ---------- Original Method ----------
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.515 -0400", hash_original_method = "53C8CE2812EC9BCF2C9E54818A5B8D0D", hash_generated_method = "1D67B4CC867A57A5A476B670C96F47AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     PendingIntent(IBinder target) {
        dsTaint.addTaint(target.dsTaint);
        mTarget = IIntentSender.Stub.asInterface(target);
        // ---------- Original Method ----------
        //mTarget = IIntentSender.Stub.asInterface(target);
    }

    
        public static PendingIntent getActivity(Context context, int requestCode,
            Intent intent, int flags) {
        String packageName = context.getPackageName();
        String resolvedType = intent != null ? intent.resolveTypeIfNeeded(
                context.getContentResolver()) : null;
        try {
            intent.setAllowFds(false);
            IIntentSender target =
                ActivityManagerNative.getDefault().getIntentSender(
                    IActivityManager.INTENT_SENDER_ACTIVITY, packageName,
                    null, null, requestCode, new Intent[] { intent },
                    resolvedType != null ? new String[] { resolvedType } : null, flags);
            return target != null ? new PendingIntent(target) : null;
        } catch (RemoteException e) {
        }
        return null;
    }

    
        public static PendingIntent getActivities(Context context, int requestCode,
            Intent[] intents, int flags) {
        String packageName = context.getPackageName();
        String[] resolvedTypes = new String[intents.length];
        for (int i=0; i<intents.length; i++) {
            intents[i].setAllowFds(false);
            resolvedTypes[i] = intents[i].resolveTypeIfNeeded(context.getContentResolver());
        }
        try {
            IIntentSender target =
                ActivityManagerNative.getDefault().getIntentSender(
                    IActivityManager.INTENT_SENDER_ACTIVITY, packageName,
                    null, null, requestCode, intents, resolvedTypes, flags);
            return target != null ? new PendingIntent(target) : null;
        } catch (RemoteException e) {
        }
        return null;
    }

    
        public static PendingIntent getBroadcast(Context context, int requestCode,
            Intent intent, int flags) {
        String packageName = context.getPackageName();
        String resolvedType = intent != null ? intent.resolveTypeIfNeeded(
                context.getContentResolver()) : null;
        try {
            intent.setAllowFds(false);
            IIntentSender target =
                ActivityManagerNative.getDefault().getIntentSender(
                    IActivityManager.INTENT_SENDER_BROADCAST, packageName,
                    null, null, requestCode, new Intent[] { intent },
                    resolvedType != null ? new String[] { resolvedType } : null, flags);
            return target != null ? new PendingIntent(target) : null;
        } catch (RemoteException e) {
        }
        return null;
    }

    
        public static PendingIntent getService(Context context, int requestCode,
            Intent intent, int flags) {
        String packageName = context.getPackageName();
        String resolvedType = intent != null ? intent.resolveTypeIfNeeded(
                context.getContentResolver()) : null;
        try {
            intent.setAllowFds(false);
            IIntentSender target =
                ActivityManagerNative.getDefault().getIntentSender(
                    IActivityManager.INTENT_SENDER_SERVICE, packageName,
                    null, null, requestCode, new Intent[] { intent },
                    resolvedType != null ? new String[] { resolvedType } : null, flags);
            return target != null ? new PendingIntent(target) : null;
        } catch (RemoteException e) {
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.517 -0400", hash_original_method = "D9A9ECA0CF76712CB3C35292E7994C6B", hash_generated_method = "CADF1D22F55C2D96E60678D5D619E192")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntentSender getIntentSender() {
        IntentSender var3850B1EC4C2556F9EDD24509CEFC0995_831773114 = (new IntentSender(mTarget));
        return (IntentSender)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new IntentSender(mTarget);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.518 -0400", hash_original_method = "7E47A257CCD629A0D7E43A8ADD34CCE8", hash_generated_method = "36E702858E5E8BAB7DF9CDFCC833C4CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        try 
        {
            ActivityManagerNative.getDefault().cancelIntentSender(mTarget);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().cancelIntentSender(mTarget);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.518 -0400", hash_original_method = "27B2516FC620720BFD785BFD1E716C8B", hash_generated_method = "F7F550965E6EFD08806178788FE1473C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void send() throws CanceledException {
        send(null, 0, null, null, null, null);
        // ---------- Original Method ----------
        //send(null, 0, null, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.518 -0400", hash_original_method = "46F134C18EE926B408E7E9C21011E590", hash_generated_method = "755E827C03A98567DC1E20C3BCF8AFB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void send(int code) throws CanceledException {
        dsTaint.addTaint(code);
        send(null, code, null, null, null, null);
        // ---------- Original Method ----------
        //send(null, code, null, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.519 -0400", hash_original_method = "43E1DC288109C397E82F23215BE8AF8A", hash_generated_method = "6160796CADEC8DAC77173BFB78051DEF")
    @DSModeled(DSC.SPEC)
    public void send(Context context, int code, Intent intent) throws CanceledException {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(code);
        dsTaint.addTaint(intent.dsTaint);
        send(context, code, intent, null, null, null);
        // ---------- Original Method ----------
        //send(context, code, intent, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.521 -0400", hash_original_method = "10F50483791A59D1BF380CE4A4A7460C", hash_generated_method = "58078415B739D9EF19CF0947F738DCB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void send(int code, OnFinished onFinished, Handler handler) throws CanceledException {
        dsTaint.addTaint(code);
        dsTaint.addTaint(onFinished.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        send(null, code, null, onFinished, handler, null);
        // ---------- Original Method ----------
        //send(null, code, null, onFinished, handler, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.522 -0400", hash_original_method = "CFAA4D7DA67BDF756999EA8ECE28296B", hash_generated_method = "21633BD0659480CDD71666921DCB681A")
    @DSModeled(DSC.SPEC)
    public void send(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler) throws CanceledException {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(code);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(onFinished.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        send(context, code, intent, onFinished, handler, null);
        // ---------- Original Method ----------
        //send(context, code, intent, onFinished, handler, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.522 -0400", hash_original_method = "A238DB61CDFFE1A49966C7738AE7C6E1", hash_generated_method = "3C2DE7FBA39B1D582A9238C4381AFA6A")
    @DSModeled(DSC.SPEC)
    public void send(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler, String requiredPermission) throws CanceledException {
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
                if (DroidSafeAndroidRuntime.control) throw new CanceledException();
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CanceledException(e);
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
                //throw new CanceledException();
            //}
        //} catch (RemoteException e) {
            //throw new CanceledException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.523 -0400", hash_original_method = "1AE048A4984F76615C0EAE5393ABDA6D", hash_generated_method = "850EFD940B21BB1E967F762DEE2935BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTargetPackage() {
        try 
        {
            String var8CF6AA73CA43B222C8C44A06E8A761AA_1951954283 = (ActivityManagerNative.getDefault()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.523 -0400", hash_original_method = "6D06AB3EE4D5DE54AFE0CC755257630C", hash_generated_method = "7447EF9121F704D201D8615D125E6466")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isTargetedToPackage() {
        try 
        {
            boolean var9F243160ADB67F012956364C597C6237_360321740 = (ActivityManagerNative.getDefault()
                .isIntentSenderTargetedToPackage(mTarget));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.isIntentSenderTargetedToPackage(mTarget);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.525 -0400", hash_original_method = "29E3C1E256E903CF301460F6770B7518", hash_generated_method = "59961530AD54177BA8C07F33158105A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object otherObj) {
        dsTaint.addTaint(otherObj.dsTaint);
        {
            boolean varE0256D3CD4A5623A7BFB562FA1FCFE51_1383360827 = (mTarget.asBinder().equals(((PendingIntent)otherObj)
                    .mTarget.asBinder()));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (otherObj instanceof PendingIntent) {
            //return mTarget.asBinder().equals(((PendingIntent)otherObj)
                    //.mTarget.asBinder());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.525 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "ACEB27EBE298645223E48D6A2D2247DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_977777402 = (mTarget.asBinder().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.526 -0400", hash_original_method = "A24ED44DCFDBAE1CB5B942522723AC1A", hash_generated_method = "A44D054C34A2581D71043A5F385B4040")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("PendingIntent{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(": ");
        sb.append(mTarget != null ? mTarget.asBinder() : null);
        sb.append('}');
        String var806458D832AB974D230FEE4CBBDBD390_2023311569 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("PendingIntent{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(": ");
        //sb.append(mTarget != null ? mTarget.asBinder() : null);
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.526 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.526 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "82E673ADF87F6A34F82CD67D6313EA4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeStrongBinder(mTarget.asBinder());
        // ---------- Original Method ----------
        //out.writeStrongBinder(mTarget.asBinder());
    }

    
        public static void writePendingIntentOrNullToParcel(PendingIntent sender,
            Parcel out) {
        out.writeStrongBinder(sender != null ? sender.mTarget.asBinder()
                : null);
    }

    
        public static PendingIntent readPendingIntentOrNullFromParcel(Parcel in) {
        IBinder b = in.readStrongBinder();
        return b != null ? new PendingIntent(b) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.527 -0400", hash_original_method = "5A73019C5B7699A011E114A766F68ECD", hash_generated_method = "51AE302E39803C6CD97E2EC428B2D4CE")
    @DSModeled(DSC.SAFE)
    public IIntentSender getTarget() {
        return (IIntentSender)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    public static class CanceledException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.530 -0400", hash_original_method = "6C791280BC05C3F7B11A7004B8EB7BE8", hash_generated_method = "409DFD8DE802DB94A3DE2ED481AAA231")
        @DSModeled(DSC.SAFE)
        public CanceledException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.530 -0400", hash_original_method = "C3CBF66373C770C27B2BC8A07C4853B3", hash_generated_method = "B23346104977A7295C550EEF73D42959")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CanceledException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.531 -0400", hash_original_method = "3AC8DEA112912D7509E7C6631865B3D3", hash_generated_method = "77CD9FD2935239E5B3CDE70C1737D193")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CanceledException(Exception cause) {
            super(cause);
            dsTaint.addTaint(cause.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
        private PendingIntent mPendingIntent;
        private OnFinished mWho;
        private Handler mHandler;
        private Intent mIntent;
        private int mResultCode;
        private String mResultData;
        private Bundle mResultExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.531 -0400", hash_original_method = "D38CFD5EE08A135F8705E392DA5A871B", hash_generated_method = "7E94229E8EE23AE96A06D63A304CA711")
        @DSModeled(DSC.SAFE)
         FinishedDispatcher(PendingIntent pi, OnFinished who, Handler handler) {
            dsTaint.addTaint(pi.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            dsTaint.addTaint(who.dsTaint);
            // ---------- Original Method ----------
            //mPendingIntent = pi;
            //mWho = who;
            //mHandler = handler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.532 -0400", hash_original_method = "B0E285A2D8AA1A0003201E2D8F6F7169", hash_generated_method = "65EE97C27361D2FBB9514482476A6398")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.537 -0400", hash_original_method = "323DC1202D6F14888580320FDC435E03", hash_generated_method = "2355F846014903A2C762811B7CD0A491")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            mWho.onSendFinished(mPendingIntent, mIntent, mResultCode,
                    mResultData, mResultExtras);
            // ---------- Original Method ----------
            //mWho.onSendFinished(mPendingIntent, mIntent, mResultCode,
                    //mResultData, mResultExtras);
        }

        
    }


    
    public interface OnFinished {
        
        void onSendFinished(PendingIntent pendingIntent, Intent intent,
                int resultCode, String resultData, Bundle resultExtras);
    }
    
    public static final int FLAG_ONE_SHOT = 1<<30;
    public static final int FLAG_NO_CREATE = 1<<29;
    public static final int FLAG_CANCEL_CURRENT = 1<<28;
    public static final int FLAG_UPDATE_CURRENT = 1<<27;
    public static final Parcelable.Creator<PendingIntent> CREATOR = new Parcelable.Creator<PendingIntent>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.538 -0400", hash_original_method = "002B3842CB6C032442901D240F958E6F", hash_generated_method = "4EC8476A3D1533CA408778996534D877")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PendingIntent createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            IBinder target;
            target = in.readStrongBinder();
            {
                Object var8CAD94B0D4869430C0BBE63AB378AD58_139685506 = (new PendingIntent(target));
            } //End flattened ternary
            return (PendingIntent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //IBinder target = in.readStrongBinder();
            //return target != null ? new PendingIntent(target) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.539 -0400", hash_original_method = "54375C4346ED3346E211F06AD01508EB", hash_generated_method = "B7291CED0CA4C4CBF54B13C010DE9B80")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PendingIntent[] newArray(int size) {
            dsTaint.addTaint(size);
            PendingIntent[] var6AA3ADE8C096149BA871A13FAFF8D015_2124807561 = (new PendingIntent[size]);
            return (PendingIntent[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PendingIntent[size];
        }

        
}; //Transformed anonymous class
}

