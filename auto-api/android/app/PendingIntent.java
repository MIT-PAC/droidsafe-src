package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final IIntentSender mTarget;
    public static final int FLAG_ONE_SHOT = 1<<30;
    public static final int FLAG_NO_CREATE = 1<<29;
    public static final int FLAG_CANCEL_CURRENT = 1<<28;
    public static final int FLAG_UPDATE_CURRENT = 1<<27;
    public static final Parcelable.Creator<PendingIntent> CREATOR = new Parcelable.Creator<PendingIntent>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.995 -0400", hash_original_method = "002B3842CB6C032442901D240F958E6F", hash_generated_method = "3799066C15AB4161D39398C44406BD34")
        @DSModeled(DSC.SAFE)
        public PendingIntent createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            IBinder target;
            target = in.readStrongBinder();
            return (PendingIntent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //IBinder target = in.readStrongBinder();
            //return target != null ? new PendingIntent(target) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.995 -0400", hash_original_method = "54375C4346ED3346E211F06AD01508EB", hash_generated_method = "8EEF080365AEB44B55B28F34B8BF9516")
        @DSModeled(DSC.SAFE)
        public PendingIntent[] newArray(int size) {
            dsTaint.addTaint(size);
            return (PendingIntent[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PendingIntent[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.996 -0400", hash_original_method = "3ACE5727953950B87626FD6380A23370", hash_generated_method = "00056E53D63318C3D72BC2654B87D01E")
    @DSModeled(DSC.SAFE)
     PendingIntent(IIntentSender target) {
        dsTaint.addTaint(target.dsTaint);
        mTarget = target;
        // ---------- Original Method ----------
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.996 -0400", hash_original_method = "53C8CE2812EC9BCF2C9E54818A5B8D0D", hash_generated_method = "20B2D7455D03CDCD2E0ABC41A18DC0A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     PendingIntent(IBinder target) {
        dsTaint.addTaint(target.dsTaint);
        mTarget = IIntentSender.Stub.asInterface(target);
        // ---------- Original Method ----------
        //mTarget = IIntentSender.Stub.asInterface(target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.996 -0400", hash_original_method = "69D22A82CA352429278AB66C9EC4D269", hash_generated_method = "95BB43864FAB78706EBCD8B6F60963D4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.997 -0400", hash_original_method = "54CC706903E6C235969DAB2CC8228B77", hash_generated_method = "BE46BD134F3641199D92CC24DA371D50")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.997 -0400", hash_original_method = "7ECBF28DE75BC4F2B5047057DCC1075B", hash_generated_method = "41701B886985ED16AB2AB3DED8138C7A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.997 -0400", hash_original_method = "ABFD2E080CD8663BF6E26BE6876274AD", hash_generated_method = "D979B054426B7D588BDD63C2E93DE780")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.997 -0400", hash_original_method = "D9A9ECA0CF76712CB3C35292E7994C6B", hash_generated_method = "024F13BBD4F20699F710DEC878D854B7")
    @DSModeled(DSC.SAFE)
    public IntentSender getIntentSender() {
        return (IntentSender)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new IntentSender(mTarget);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.998 -0400", hash_original_method = "7E47A257CCD629A0D7E43A8ADD34CCE8", hash_generated_method = "FAC64D8D910980F90627445270CBA5DA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.998 -0400", hash_original_method = "27B2516FC620720BFD785BFD1E716C8B", hash_generated_method = "59BBCE778CD59D578F81139ADF89BDFE")
    @DSModeled(DSC.SAFE)
    public void send() throws CanceledException {
        send(null, 0, null, null, null, null);
        // ---------- Original Method ----------
        //send(null, 0, null, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.998 -0400", hash_original_method = "46F134C18EE926B408E7E9C21011E590", hash_generated_method = "84B6CE6E7E1D538194FE3349C2817FB4")
    @DSModeled(DSC.SAFE)
    public void send(int code) throws CanceledException {
        dsTaint.addTaint(code);
        send(null, code, null, null, null, null);
        // ---------- Original Method ----------
        //send(null, code, null, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.998 -0400", hash_original_method = "43E1DC288109C397E82F23215BE8AF8A", hash_generated_method = "C8C1E4FBEF2B2A370080D607D2794C98")
    @DSModeled(DSC.SPEC)
    public void send(Context context, int code, Intent intent) throws CanceledException {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(code);
        dsTaint.addTaint(intent.dsTaint);
        send(context, code, intent, null, null, null);
        // ---------- Original Method ----------
        //send(context, code, intent, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.999 -0400", hash_original_method = "10F50483791A59D1BF380CE4A4A7460C", hash_generated_method = "B11FCD43BDE2103A89AB5AD91183F3C3")
    @DSModeled(DSC.SAFE)
    public void send(int code, OnFinished onFinished, Handler handler) throws CanceledException {
        dsTaint.addTaint(code);
        dsTaint.addTaint(onFinished.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        send(null, code, null, onFinished, handler, null);
        // ---------- Original Method ----------
        //send(null, code, null, onFinished, handler, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.999 -0400", hash_original_method = "CFAA4D7DA67BDF756999EA8ECE28296B", hash_generated_method = "DFA70779F8F55DBE82076DE9DF9EB72B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.999 -0400", hash_original_method = "A238DB61CDFFE1A49966C7738AE7C6E1", hash_generated_method = "2060D44B35F60C2BFB033A5B98483523")
    @DSModeled(DSC.SPEC)
    public void send(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler, String requiredPermission) throws CanceledException {
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
                throw new CanceledException();
            } //End block
        } //End block
        catch (RemoteException e)
        {
            throw new CanceledException(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.000 -0400", hash_original_method = "1AE048A4984F76615C0EAE5393ABDA6D", hash_generated_method = "F450F7C9D56C12332D33329D6E5CDADE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTargetPackage() {
        try 
        {
            String var8CF6AA73CA43B222C8C44A06E8A761AA_568755374 = (ActivityManagerNative.getDefault()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.000 -0400", hash_original_method = "6D06AB3EE4D5DE54AFE0CC755257630C", hash_generated_method = "A1352ECD7E13225A8D366B9C59C78C6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isTargetedToPackage() {
        try 
        {
            boolean var9F243160ADB67F012956364C597C6237_1002927603 = (ActivityManagerNative.getDefault()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.000 -0400", hash_original_method = "29E3C1E256E903CF301460F6770B7518", hash_generated_method = "EF1FB34BB22C831854445F2504CB6F34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object otherObj) {
        dsTaint.addTaint(otherObj.dsTaint);
        {
            boolean varE0256D3CD4A5623A7BFB562FA1FCFE51_1676649646 = (mTarget.asBinder().equals(((PendingIntent)otherObj)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.001 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "067A4387CB84FAF70A6D39A010705B88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_180491876 = (mTarget.asBinder().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.001 -0400", hash_original_method = "A24ED44DCFDBAE1CB5B942522723AC1A", hash_generated_method = "453D158F39A540BDDF1A697B2B5FB007")
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
        String var806458D832AB974D230FEE4CBBDBD390_503807649 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.001 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.002 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "4DBC8FF64D1607D57C2D13908DAFE7EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeStrongBinder(mTarget.asBinder());
        // ---------- Original Method ----------
        //out.writeStrongBinder(mTarget.asBinder());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.002 -0400", hash_original_method = "22B62015BE969BA5F8FF4277748534BD", hash_generated_method = "9C4F52F75D02CD3BE3C38AA5172500C5")
    public static void writePendingIntentOrNullToParcel(PendingIntent sender,
            Parcel out) {
        out.writeStrongBinder(sender != null ? sender.mTarget.asBinder()
                : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.002 -0400", hash_original_method = "87F4B01ECCD12AE599F0E972E34C07E9", hash_generated_method = "8B33B39B0338061CA43B39E3CB933B33")
    public static PendingIntent readPendingIntentOrNullFromParcel(Parcel in) {
        IBinder b = in.readStrongBinder();
        return b != null ? new PendingIntent(b) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.002 -0400", hash_original_method = "5A73019C5B7699A011E114A766F68ECD", hash_generated_method = "48BD5E2370ADA60485AFECBD65DFFEB3")
    @DSModeled(DSC.SAFE)
    public IIntentSender getTarget() {
        return (IIntentSender)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    public static class CanceledException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.003 -0400", hash_original_method = "6C791280BC05C3F7B11A7004B8EB7BE8", hash_generated_method = "FEC8361528F372243C4DA1C82F3B9FB4")
        @DSModeled(DSC.SAFE)
        public CanceledException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.003 -0400", hash_original_method = "C3CBF66373C770C27B2BC8A07C4853B3", hash_generated_method = "F5718D05C76A90627910353FF0F04892")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CanceledException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.003 -0400", hash_original_method = "3AC8DEA112912D7509E7C6631865B3D3", hash_generated_method = "56F7CADCF0D5C418D23607C496B18671")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CanceledException(Exception cause) {
            super(cause);
            dsTaint.addTaint(cause.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
        private final PendingIntent mPendingIntent;
        private final OnFinished mWho;
        private final Handler mHandler;
        private Intent mIntent;
        private int mResultCode;
        private String mResultData;
        private Bundle mResultExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.003 -0400", hash_original_method = "D38CFD5EE08A135F8705E392DA5A871B", hash_generated_method = "EFA2993851A93E937451663880E2F4E7")
        @DSModeled(DSC.SAFE)
         FinishedDispatcher(PendingIntent pi, OnFinished who, Handler handler) {
            dsTaint.addTaint(pi.dsTaint);
            dsTaint.addTaint(who.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            mWho = who;
            mPendingIntent = pi;
            mHandler = handler;
            // ---------- Original Method ----------
            //mPendingIntent = pi;
            //mWho = who;
            //mHandler = handler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.004 -0400", hash_original_method = "B0E285A2D8AA1A0003201E2D8F6F7169", hash_generated_method = "5333CC724ADDEEECE69A3E90AF422276")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.004 -0400", hash_original_method = "323DC1202D6F14888580320FDC435E03", hash_generated_method = "661A27A4C10F39A62F3C6B47D186A338")
        @DSModeled(DSC.SAFE)
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
    
}


