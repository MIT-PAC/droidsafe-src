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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.283 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "E4E58773DF3C0920C12AA38B8FC403A5")

    private IIntentSender mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.299 -0400", hash_original_method = "3ACE5727953950B87626FD6380A23370", hash_generated_method = "2DB84B772119314499B70FB507774FD6")
      PendingIntent(IIntentSender target) {
        mTarget = target;
        // ---------- Original Method ----------
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.310 -0400", hash_original_method = "53C8CE2812EC9BCF2C9E54818A5B8D0D", hash_generated_method = "F144EEFBA4AF7E7804AAA97C0CEB107D")
      PendingIntent(IBinder target) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.350 -0400", hash_original_method = "D9A9ECA0CF76712CB3C35292E7994C6B", hash_generated_method = "67DAEC046940A44A75E3F1D18A7396C3")
    public IntentSender getIntentSender() {
        IntentSender varB4EAC82CA7396A68D541C85D26508E83_162727106 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_162727106 = new IntentSender(mTarget);
        varB4EAC82CA7396A68D541C85D26508E83_162727106.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_162727106;
        // ---------- Original Method ----------
        //return new IntentSender(mTarget);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.369 -0400", hash_original_method = "7E47A257CCD629A0D7E43A8ADD34CCE8", hash_generated_method = "36E702858E5E8BAB7DF9CDFCC833C4CC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.389 -0400", hash_original_method = "27B2516FC620720BFD785BFD1E716C8B", hash_generated_method = "F7F550965E6EFD08806178788FE1473C")
    public void send() throws CanceledException {
        send(null, 0, null, null, null, null);
        // ---------- Original Method ----------
        //send(null, 0, null, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.410 -0400", hash_original_method = "46F134C18EE926B408E7E9C21011E590", hash_generated_method = "74D362AD0FEB864A4C17D82BAB66E553")
    public void send(int code) throws CanceledException {
        send(null, code, null, null, null, null);
        addTaint(code);
        // ---------- Original Method ----------
        //send(null, code, null, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.411 -0400", hash_original_method = "43E1DC288109C397E82F23215BE8AF8A", hash_generated_method = "96BF866CF267060392A8C342BFDBE8ED")
    public void send(Context context, int code, Intent intent) throws CanceledException {
        send(context, code, intent, null, null, null);
        addTaint(context.getTaint());
        addTaint(code);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //send(context, code, intent, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.413 -0400", hash_original_method = "10F50483791A59D1BF380CE4A4A7460C", hash_generated_method = "DE7642A20897EED44AF280F4BADC0143")
    public void send(int code, OnFinished onFinished, Handler handler) throws CanceledException {
        send(null, code, null, onFinished, handler, null);
        addTaint(code);
        addTaint(onFinished.getTaint());
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
        //send(null, code, null, onFinished, handler, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.421 -0400", hash_original_method = "CFAA4D7DA67BDF756999EA8ECE28296B", hash_generated_method = "C0AAA8512D2F01C3A133D8BC7B82C282")
    public void send(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler) throws CanceledException {
        send(context, code, intent, onFinished, handler, null);
        addTaint(context.getTaint());
        addTaint(code);
        addTaint(intent.getTaint());
        addTaint(onFinished.getTaint());
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
        //send(context, code, intent, onFinished, handler, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.441 -0400", hash_original_method = "A238DB61CDFFE1A49966C7738AE7C6E1", hash_generated_method = "059A077F3D4EA86D50693A167B735D85")
    public void send(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler, String requiredPermission) throws CanceledException {
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
                //throw new CanceledException();
            //}
        //} catch (RemoteException e) {
            //throw new CanceledException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.458 -0400", hash_original_method = "1AE048A4984F76615C0EAE5393ABDA6D", hash_generated_method = "1FACC872B1678C529D94C72C39D972AE")
    public String getTargetPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_525319197 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_863214728 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_525319197 = ActivityManagerNative.getDefault()
                .getPackageForIntentSender(mTarget);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_863214728 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_381183835; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_381183835 = varB4EAC82CA7396A68D541C85D26508E83_525319197;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_381183835 = varB4EAC82CA7396A68D541C85D26508E83_863214728;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_381183835.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_381183835;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getPackageForIntentSender(mTarget);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.476 -0400", hash_original_method = "6D06AB3EE4D5DE54AFE0CC755257630C", hash_generated_method = "3F7188B8FD3812F4F2C8A0834C075238")
    public boolean isTargetedToPackage() {
        try 
        {
            boolean var9F243160ADB67F012956364C597C6237_1887685495 = (ActivityManagerNative.getDefault()
                .isIntentSenderTargetedToPackage(mTarget));
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1027942262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1027942262;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.isIntentSenderTargetedToPackage(mTarget);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.487 -0400", hash_original_method = "29E3C1E256E903CF301460F6770B7518", hash_generated_method = "B277283803CC0005DE5AAC990299B4DA")
    @Override
    public boolean equals(Object otherObj) {
        {
            boolean varE0256D3CD4A5623A7BFB562FA1FCFE51_825815463 = (mTarget.asBinder().equals(((PendingIntent)otherObj)
                    .mTarget.asBinder()));
        } //End block
        addTaint(otherObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_678531937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_678531937;
        // ---------- Original Method ----------
        //if (otherObj instanceof PendingIntent) {
            //return mTarget.asBinder().equals(((PendingIntent)otherObj)
                    //.mTarget.asBinder());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.489 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "ED03011B7FCC2B8331D5543C5063C290")
    @Override
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_1399363365 = (mTarget.asBinder().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918298925 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918298925;
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.507 -0400", hash_original_method = "A24ED44DCFDBAE1CB5B942522723AC1A", hash_generated_method = "15BB73A308FBB0F7AD42E32CB9564748")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_251561305 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("PendingIntent{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(": ");
        sb.append(mTarget != null ? mTarget.asBinder() : null);
        sb.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_251561305 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_251561305.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_251561305;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("PendingIntent{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(": ");
        //sb.append(mTarget != null ? mTarget.asBinder() : null);
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.520 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FBF199E6CC263B1EEF7296B14CAB4769")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664854170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664854170;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.532 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "CB2D00ECBC9E35AA709F7B9DC3B570B9")
    public void writeToParcel(Parcel out, int flags) {
        out.writeStrongBinder(mTarget.asBinder());
        addTaint(out.getTaint());
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.549 -0400", hash_original_method = "5A73019C5B7699A011E114A766F68ECD", hash_generated_method = "5672823B370215D80B3E4297BC522034")
    public IIntentSender getTarget() {
        IIntentSender varB4EAC82CA7396A68D541C85D26508E83_1442983658 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1442983658 = mTarget;
        varB4EAC82CA7396A68D541C85D26508E83_1442983658.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1442983658;
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    public static class CanceledException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.550 -0400", hash_original_method = "6C791280BC05C3F7B11A7004B8EB7BE8", hash_generated_method = "409DFD8DE802DB94A3DE2ED481AAA231")
        public  CanceledException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.574 -0400", hash_original_method = "C3CBF66373C770C27B2BC8A07C4853B3", hash_generated_method = "FB687C3A6881AD9D7AC449BFED9CD2FF")
        public  CanceledException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.580 -0400", hash_original_method = "3AC8DEA112912D7509E7C6631865B3D3", hash_generated_method = "548138D68ED71FAD6BC31F6988F7ECCB")
        public  CanceledException(Exception cause) {
            super(cause);
            addTaint(cause.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.582 -0400", hash_original_field = "9CB01E7CF93300AA9D8B869CEC16B638", hash_generated_field = "094D5D79D03F65D4515938385B22FFF9")

        private PendingIntent mPendingIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.583 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "3E0837F5746BF0F0EA46630CD994FC89")

        private OnFinished mWho;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.583 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.598 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.599 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "77069BAE5867220B0011AB47341F29C2")

        private int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.599 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "C1E52350501391E7118DB73479974476")

        private String mResultData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.599 -0400", hash_original_field = "15A7BDFA2595DFC979A8B0D8A65ABE14", hash_generated_field = "109BE0C611CD1E4823349D5DAFA222D0")

        private Bundle mResultExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.610 -0400", hash_original_method = "D38CFD5EE08A135F8705E392DA5A871B", hash_generated_method = "5BD628A6CC6E57E5C519CCCA582902F2")
          FinishedDispatcher(PendingIntent pi, OnFinished who, Handler handler) {
            mPendingIntent = pi;
            mWho = who;
            mHandler = handler;
            // ---------- Original Method ----------
            //mPendingIntent = pi;
            //mWho = who;
            //mHandler = handler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.641 -0400", hash_original_method = "B0E285A2D8AA1A0003201E2D8F6F7169", hash_generated_method = "0538DA2A05217B942D752ECF6F421D27")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.655 -0400", hash_original_method = "323DC1202D6F14888580320FDC435E03", hash_generated_method = "2355F846014903A2C762811B7CD0A491")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.656 -0400", hash_original_field = "A93B3284193C91C9E82A6BA87DF875DD", hash_generated_field = "5E771266274AD1856355F7F2644C40F0")

    public static final int FLAG_ONE_SHOT = 1<<30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.657 -0400", hash_original_field = "CA3A775851C97E85BEEC9EA34452E343", hash_generated_field = "6ECB010344DA3BF2E28DD81C26A1E226")

    public static final int FLAG_NO_CREATE = 1<<29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.658 -0400", hash_original_field = "291EDC39E20E1D3D5F54560A6C3341EC", hash_generated_field = "50E1B18733D9B9E6FAC056955439D1C7")

    public static final int FLAG_CANCEL_CURRENT = 1<<28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.659 -0400", hash_original_field = "F9CCB35F913F8CB0083E0CE8FC8382C4", hash_generated_field = "07161ED3853628F4CC6ED18374F570F7")

    public static final int FLAG_UPDATE_CURRENT = 1<<27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.676 -0400", hash_original_field = "68AC0C0209638127AE110D7481B6BF8A", hash_generated_field = "A03CAD3B827B3F879722CD11378FA14A")

    public static final Parcelable.Creator<PendingIntent> CREATOR
            = new Parcelable.Creator<PendingIntent>() {
        public PendingIntent createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new PendingIntent(target) : null;
        }

        public PendingIntent[] newArray(int size) {
            return new PendingIntent[size];
        }
    };
}

