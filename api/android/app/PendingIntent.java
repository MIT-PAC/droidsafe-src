package android.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.content.IIntentReceiver;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AndroidException;





public final class PendingIntent implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.376 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "E4E58773DF3C0920C12AA38B8FC403A5")

    private IIntentSender mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.377 -0400", hash_original_method = "3ACE5727953950B87626FD6380A23370", hash_generated_method = "2DB84B772119314499B70FB507774FD6")
      PendingIntent(IIntentSender target) {
        mTarget = target;
        // ---------- Original Method ----------
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.377 -0400", hash_original_method = "53C8CE2812EC9BCF2C9E54818A5B8D0D", hash_generated_method = "F144EEFBA4AF7E7804AAA97C0CEB107D")
      PendingIntent(IBinder target) {
        mTarget = IIntentSender.Stub.asInterface(target);
        // ---------- Original Method ----------
        //mTarget = IIntentSender.Stub.asInterface(target);
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.380 -0400", hash_original_method = "D9A9ECA0CF76712CB3C35292E7994C6B", hash_generated_method = "D8FB116C20953E0ACE776F552898FF49")
    public IntentSender getIntentSender() {
IntentSender varA16DB4ABA05FBBC681DB88D59107EC54_317099010 =         new IntentSender(mTarget);
        varA16DB4ABA05FBBC681DB88D59107EC54_317099010.addTaint(taint);
        return varA16DB4ABA05FBBC681DB88D59107EC54_317099010;
        // ---------- Original Method ----------
        //return new IntentSender(mTarget);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.380 -0400", hash_original_method = "7E47A257CCD629A0D7E43A8ADD34CCE8", hash_generated_method = "9959F8EFC13EB2DA470AD3CBEDD29362")
    public void cancel() {
        try 
        {
            ActivityManagerNative.getDefault().cancelIntentSender(mTarget);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().cancelIntentSender(mTarget);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.380 -0400", hash_original_method = "27B2516FC620720BFD785BFD1E716C8B", hash_generated_method = "F7F550965E6EFD08806178788FE1473C")
    public void send() throws CanceledException {
        send(null, 0, null, null, null, null);
        // ---------- Original Method ----------
        //send(null, 0, null, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.381 -0400", hash_original_method = "46F134C18EE926B408E7E9C21011E590", hash_generated_method = "FC95C098CD3581D6FC879DC40608B6DE")
    public void send(int code) throws CanceledException {
        addTaint(code);
        send(null, code, null, null, null, null);
        // ---------- Original Method ----------
        //send(null, code, null, null, null, null);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.382 -0400", hash_original_method = "43E1DC288109C397E82F23215BE8AF8A", hash_generated_method = "1AF36FB5B0DEE56CF4026DF6133644B3")
    public void send(Context context, int code, Intent intent) throws CanceledException {
        addTaint(intent.getTaint());
        addTaint(code);
        addTaint(context.getTaint());
        send(context, code, intent, null, null, null);
        // ---------- Original Method ----------
        //send(context, code, intent, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.382 -0400", hash_original_method = "10F50483791A59D1BF380CE4A4A7460C", hash_generated_method = "670756514B26B2D05C26EC07B405085D")
    public void send(int code, OnFinished onFinished, Handler handler) throws CanceledException {
        addTaint(handler.getTaint());
        addTaint(onFinished.getTaint());
        addTaint(code);
        send(null, code, null, onFinished, handler, null);
        // ---------- Original Method ----------
        //send(null, code, null, onFinished, handler, null);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.383 -0400", hash_original_method = "CFAA4D7DA67BDF756999EA8ECE28296B", hash_generated_method = "AF3436A528196FD07F0CC3F44480AAEF")
    public void send(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler) throws CanceledException {
        addTaint(handler.getTaint());
        addTaint(onFinished.getTaint());
        addTaint(intent.getTaint());
        addTaint(code);
        addTaint(context.getTaint());
        send(context, code, intent, onFinished, handler, null);
        // ---------- Original Method ----------
        //send(context, code, intent, onFinished, handler, null);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.384 -0400", hash_original_method = "A238DB61CDFFE1A49966C7738AE7C6E1", hash_generated_method = "5098F1B96436FD643805065D6B8B7F19")
    public void send(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler, String requiredPermission) throws CanceledException {
        addTaint(requiredPermission.getTaint());
        addTaint(handler.getTaint());
        addTaint(onFinished.getTaint());
        addTaint(intent.getTaint());
        addTaint(code);
        addTaint(context.getTaint());
        try 
        {
            String resolvedType = intent != null ?
                    intent.resolveTypeIfNeeded(context.getContentResolver())
                    : null;
            int res = mTarget.send(code, intent, resolvedType,
                    onFinished != null
                            ? new FinishedDispatcher(this, onFinished, handler)
                            : null,
                    requiredPermission);
            if(res < 0)            
            {
                CanceledException var9C91EE244731E853B4D1F8E4C86B0F65_1285684402 = new CanceledException();
                var9C91EE244731E853B4D1F8E4C86B0F65_1285684402.addTaint(taint);
                throw var9C91EE244731E853B4D1F8E4C86B0F65_1285684402;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            CanceledException varECCE4670C07EF4EF70E13B9181AEE2B2_137300899 = new CanceledException(e);
            varECCE4670C07EF4EF70E13B9181AEE2B2_137300899.addTaint(taint);
            throw varECCE4670C07EF4EF70E13B9181AEE2B2_137300899;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.384 -0400", hash_original_method = "1AE048A4984F76615C0EAE5393ABDA6D", hash_generated_method = "6D3AE507B9D5838926B631CBDFBE4F54")
    public String getTargetPackage() {
        try 
        {
String var76B90BADD59476CF2DB16FEF7C56445A_1977191874 =             ActivityManagerNative.getDefault()
                .getPackageForIntentSender(mTarget);
            var76B90BADD59476CF2DB16FEF7C56445A_1977191874.addTaint(taint);
            return var76B90BADD59476CF2DB16FEF7C56445A_1977191874;
        } //End block
        catch (RemoteException e)
        {
String var540C13E9E156B687226421B24F2DF178_530974602 =             null;
            var540C13E9E156B687226421B24F2DF178_530974602.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_530974602;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getPackageForIntentSender(mTarget);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.385 -0400", hash_original_method = "6D06AB3EE4D5DE54AFE0CC755257630C", hash_generated_method = "5A78B492420EDED15455875B4AC9DC6B")
    public boolean isTargetedToPackage() {
        try 
        {
            boolean varB4EDAD7585617461D78FCDBD92044049_1953270457 = (ActivityManagerNative.getDefault()
                .isIntentSenderTargetedToPackage(mTarget));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1244789657 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1244789657;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1364862317 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202139087 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_202139087;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.isIntentSenderTargetedToPackage(mTarget);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.386 -0400", hash_original_method = "29E3C1E256E903CF301460F6770B7518", hash_generated_method = "84FA45D32A51001D92770C3DE337935D")
    @Override
    public boolean equals(Object otherObj) {
        addTaint(otherObj.getTaint());
        if(otherObj instanceof PendingIntent)        
        {
            boolean varFDEEC2840D306A766689F8F8761A7824_136786060 = (mTarget.asBinder().equals(((PendingIntent)otherObj)
                    .mTarget.asBinder()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1871092208 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1871092208;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_613473953 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1647438242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1647438242;
        // ---------- Original Method ----------
        //if (otherObj instanceof PendingIntent) {
            //return mTarget.asBinder().equals(((PendingIntent)otherObj)
                    //.mTarget.asBinder());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.386 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "EAEEAEA9A3018D1C559F9BA6F665E677")
    @Override
    public int hashCode() {
        int var015DBE14D40CCC902461F5EB4537F2D8_660101969 = (mTarget.asBinder().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_601776006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_601776006;
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.387 -0400", hash_original_method = "A24ED44DCFDBAE1CB5B942522723AC1A", hash_generated_method = "4FDCDFDE25F6C3CEA39B5F741D0EEE98")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("PendingIntent{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(": ");
        sb.append(mTarget != null ? mTarget.asBinder() : null);
        sb.append('}');
String var2460B846747F8B22185AD8BE722266A5_636124134 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_636124134.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_636124134;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("PendingIntent{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(": ");
        //sb.append(mTarget != null ? mTarget.asBinder() : null);
        //sb.append('}');
        //return sb.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.387 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "220450C09950F7B382913B9BA710B956")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2098354981 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_7931791 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_7931791;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.388 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "C7A202EDEDAAFB23E59B79A7FE9B7381")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.389 -0400", hash_original_method = "5A73019C5B7699A011E114A766F68ECD", hash_generated_method = "163372191EF7E04A2219DE68AD41B2EF")
    public IIntentSender getTarget() {
IIntentSender var1FC339B2A7C7BA226929CA8B7CC3A063_1222167777 =         mTarget;
        var1FC339B2A7C7BA226929CA8B7CC3A063_1222167777.addTaint(taint);
        return var1FC339B2A7C7BA226929CA8B7CC3A063_1222167777;
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    public static class CanceledException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.389 -0400", hash_original_method = "6C791280BC05C3F7B11A7004B8EB7BE8", hash_generated_method = "409DFD8DE802DB94A3DE2ED481AAA231")
        public  CanceledException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.390 -0400", hash_original_method = "C3CBF66373C770C27B2BC8A07C4853B3", hash_generated_method = "FB687C3A6881AD9D7AC449BFED9CD2FF")
        public  CanceledException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.390 -0400", hash_original_method = "3AC8DEA112912D7509E7C6631865B3D3", hash_generated_method = "548138D68ED71FAD6BC31F6988F7ECCB")
        public  CanceledException(Exception cause) {
            super(cause);
            addTaint(cause.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.391 -0400", hash_original_field = "9CB01E7CF93300AA9D8B869CEC16B638", hash_generated_field = "094D5D79D03F65D4515938385B22FFF9")

        private PendingIntent mPendingIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.391 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "3E0837F5746BF0F0EA46630CD994FC89")

        private OnFinished mWho;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.391 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.391 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.391 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "77069BAE5867220B0011AB47341F29C2")

        private int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.391 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "C1E52350501391E7118DB73479974476")

        private String mResultData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.391 -0400", hash_original_field = "15A7BDFA2595DFC979A8B0D8A65ABE14", hash_generated_field = "109BE0C611CD1E4823349D5DAFA222D0")

        private Bundle mResultExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.392 -0400", hash_original_method = "D38CFD5EE08A135F8705E392DA5A871B", hash_generated_method = "5BD628A6CC6E57E5C519CCCA582902F2")
          FinishedDispatcher(PendingIntent pi, OnFinished who, Handler handler) {
            mPendingIntent = pi;
            mWho = who;
            mHandler = handler;
            // ---------- Original Method ----------
            //mPendingIntent = pi;
            //mWho = who;
            //mHandler = handler;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.394 -0400", hash_original_method = "B0E285A2D8AA1A0003201E2D8F6F7169", hash_generated_method = "E6DB147736FD6A8CF56D8AA16E4190C8")
        public void performReceive(Intent intent, int resultCode,
                String data, Bundle extras, boolean serialized, boolean sticky) {
            addTaint(sticky);
            addTaint(serialized);
            mIntent = intent;
            mResultCode = resultCode;
            mResultData = data;
            mResultExtras = extras;
            if(mHandler == null)            
            {
                run();
            } //End block
            else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.395 -0400", hash_original_method = "323DC1202D6F14888580320FDC435E03", hash_generated_method = "2355F846014903A2C762811B7CD0A491")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.395 -0400", hash_original_field = "A93B3284193C91C9E82A6BA87DF875DD", hash_generated_field = "5E771266274AD1856355F7F2644C40F0")

    public static final int FLAG_ONE_SHOT = 1<<30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.395 -0400", hash_original_field = "CA3A775851C97E85BEEC9EA34452E343", hash_generated_field = "6ECB010344DA3BF2E28DD81C26A1E226")

    public static final int FLAG_NO_CREATE = 1<<29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.396 -0400", hash_original_field = "291EDC39E20E1D3D5F54560A6C3341EC", hash_generated_field = "50E1B18733D9B9E6FAC056955439D1C7")

    public static final int FLAG_CANCEL_CURRENT = 1<<28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.396 -0400", hash_original_field = "F9CCB35F913F8CB0083E0CE8FC8382C4", hash_generated_field = "07161ED3853628F4CC6ED18374F570F7")

    public static final int FLAG_UPDATE_CURRENT = 1<<27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.396 -0400", hash_original_field = "68AC0C0209638127AE110D7481B6BF8A", hash_generated_field = "A03CAD3B827B3F879722CD11378FA14A")

    public static final Parcelable.Creator<PendingIntent> CREATOR
            = new Parcelable.Creator<PendingIntent>() {
        public PendingIntent createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new PendingIntent(target) : null;
        }

        @DSModeled(DSC.SAFE)
        public PendingIntent[] newArray(int size) {
            return new PendingIntent[size];
        }
    };
    // orphaned legacy method
    public PendingIntent createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new PendingIntent(target) : null;
        }
    
    // orphaned legacy method
    public PendingIntent[] newArray(int size) {
            return new PendingIntent[size];
        }
    
}

