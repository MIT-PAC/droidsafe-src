package android.content;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.595 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "E4E58773DF3C0920C12AA38B8FC403A5")

    private IIntentSender mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.595 -0400", hash_original_method = "BB3BE3704C38C3CFAEE93A10A1B40CE3", hash_generated_method = "2663241EBD81A494CAEAE58B33F2DC66")
    public  IntentSender(IIntentSender target) {
        mTarget = target;
        // ---------- Original Method ----------
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.596 -0400", hash_original_method = "34B28E745C82742C6DB129EED6A7ACD1", hash_generated_method = "14968660335B1B1B82B8A923154417D9")
    public  IntentSender(IBinder target) {
        mTarget = IIntentSender.Stub.asInterface(target);
        // ---------- Original Method ----------
        //mTarget = IIntentSender.Stub.asInterface(target);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.597 -0400", hash_original_method = "D1640EC79CDF4472CD1CED043D9B375E", hash_generated_method = "8E2EA0208115788DCDA81893B480133E")
    public void sendIntent(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler) throws SendIntentException {
        addTaint(handler.getTaint());
        addTaint(onFinished.getTaint());
        addTaint(intent.getTaint());
        addTaint(code);
        addTaint(context.getTaint());
        sendIntent(context, code, intent, onFinished, handler, null);
        // ---------- Original Method ----------
        //sendIntent(context, code, intent, onFinished, handler, null);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.598 -0400", hash_original_method = "5984C2C3625490063272E3C39EF4CC1F", hash_generated_method = "323EC09188EA2753E9AE05AF5A57CC65")
    public void sendIntent(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler, String requiredPermission) throws SendIntentException {
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
                SendIntentException var47738BD7CC9B6F6E46954421DCBA63CA_1694769926 = new SendIntentException();
                var47738BD7CC9B6F6E46954421DCBA63CA_1694769926.addTaint(taint);
                throw var47738BD7CC9B6F6E46954421DCBA63CA_1694769926;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            SendIntentException var47738BD7CC9B6F6E46954421DCBA63CA_1970943122 = new SendIntentException();
            var47738BD7CC9B6F6E46954421DCBA63CA_1970943122.addTaint(taint);
            throw var47738BD7CC9B6F6E46954421DCBA63CA_1970943122;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.599 -0400", hash_original_method = "1AE048A4984F76615C0EAE5393ABDA6D", hash_generated_method = "74448ABFC02FDCA64E7FD6A3EFD2FA9E")
    public String getTargetPackage() {
        try 
        {
String var76B90BADD59476CF2DB16FEF7C56445A_843488388 =             ActivityManagerNative.getDefault()
                .getPackageForIntentSender(mTarget);
            var76B90BADD59476CF2DB16FEF7C56445A_843488388.addTaint(taint);
            return var76B90BADD59476CF2DB16FEF7C56445A_843488388;
        } //End block
        catch (RemoteException e)
        {
String var540C13E9E156B687226421B24F2DF178_350355222 =             null;
            var540C13E9E156B687226421B24F2DF178_350355222.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_350355222;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getPackageForIntentSender(mTarget);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.600 -0400", hash_original_method = "B8F30F83DBAD000A3D0EE0DBD675E1EE", hash_generated_method = "FB136DB9FD2F892B4366755DF2DF7DD5")
    @Override
    public boolean equals(Object otherObj) {
        addTaint(otherObj.getTaint());
        if(otherObj instanceof IntentSender)        
        {
            boolean varA291F5BD2AA45F3A6F560D9F0F44FC9A_1973333384 = (mTarget.asBinder().equals(((IntentSender)otherObj)
                    .mTarget.asBinder()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_326297219 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_326297219;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1486402158 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595993179 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_595993179;
        // ---------- Original Method ----------
        //if (otherObj instanceof IntentSender) {
            //return mTarget.asBinder().equals(((IntentSender)otherObj)
                    //.mTarget.asBinder());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.601 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "3C6A2517611ACB5EB77303347C2110B6")
    @Override
    public int hashCode() {
        int var015DBE14D40CCC902461F5EB4537F2D8_2141140669 = (mTarget.asBinder().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_205477089 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_205477089;
        // ---------- Original Method ----------
        //return mTarget.asBinder().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.602 -0400", hash_original_method = "E43F03B5A25195808BB96BD150CAE514", hash_generated_method = "D4A19F101BBBF6B85F396649D96FADDC")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("IntentSender{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(": ");
        sb.append(mTarget != null ? mTarget.asBinder() : null);
        sb.append('}');
String var2460B846747F8B22185AD8BE722266A5_12312207 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_12312207.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_12312207;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("IntentSender{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(": ");
        //sb.append(mTarget != null ? mTarget.asBinder() : null);
        //sb.append('}');
        //return sb.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.603 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FDA857E1C0CDB1CCA97E59EE0F94BC41")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2145577988 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1253788758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1253788758;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.605 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "C7A202EDEDAAFB23E59B79A7FE9B7381")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.608 -0400", hash_original_method = "5A73019C5B7699A011E114A766F68ECD", hash_generated_method = "892B0ED62F32C981AACCB4A6B8240BFA")
    public IIntentSender getTarget() {
IIntentSender var1FC339B2A7C7BA226929CA8B7CC3A063_1416135643 =         mTarget;
        var1FC339B2A7C7BA226929CA8B7CC3A063_1416135643.addTaint(taint);
        return var1FC339B2A7C7BA226929CA8B7CC3A063_1416135643;
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    public static class SendIntentException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.609 -0400", hash_original_method = "3CCB3E3C6E6C65C0BEBBCAEF78CD6FBE", hash_generated_method = "CB8141C05BC43408A5593044AF4551A8")
        public  SendIntentException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.609 -0400", hash_original_method = "2F0F888808ED374E72461686A526DBD5", hash_generated_method = "3D65C4B9722C2C702E36855D4994E789")
        public  SendIntentException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.609 -0400", hash_original_method = "124D84CE7C7EE822BF41BDFAD538F007", hash_generated_method = "F92E006546D061799119E44C8681B178")
        public  SendIntentException(Exception cause) {
            super(cause);
            addTaint(cause.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.610 -0400", hash_original_field = "61ADD1865F3B86CD9BF213685358F4E1", hash_generated_field = "84BD9A0534D27174DCB55615309E820B")

        private IntentSender mIntentSender;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.610 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "3E0837F5746BF0F0EA46630CD994FC89")

        private OnFinished mWho;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.610 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.610 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.611 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "77069BAE5867220B0011AB47341F29C2")

        private int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.611 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "C1E52350501391E7118DB73479974476")

        private String mResultData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.611 -0400", hash_original_field = "15A7BDFA2595DFC979A8B0D8A65ABE14", hash_generated_field = "109BE0C611CD1E4823349D5DAFA222D0")

        private Bundle mResultExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.612 -0400", hash_original_method = "758C8818FE8D792B6839EA2D78825DC2", hash_generated_method = "5C21FDD7EDE5604E0F4AD647B421C7AE")
          FinishedDispatcher(IntentSender pi, OnFinished who, Handler handler) {
            mIntentSender = pi;
            mWho = who;
            mHandler = handler;
            // ---------- Original Method ----------
            //mIntentSender = pi;
            //mWho = who;
            //mHandler = handler;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.614 -0400", hash_original_method = "B0E285A2D8AA1A0003201E2D8F6F7169", hash_generated_method = "E6DB147736FD6A8CF56D8AA16E4190C8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.614 -0400", hash_original_method = "81E3A612882F37B7E9D205FA2DF9669A", hash_generated_method = "D912AA0A868C0CF106FF3B723FFC47F3")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.615 -0400", hash_original_field = "65DC812B4255A97B0E3B4F361B82E6A8", hash_generated_field = "4F4C19488EB89DC17DFA975D7E159256")

    public static final Parcelable.Creator<IntentSender> CREATOR
            = new Parcelable.Creator<IntentSender>() {
        public IntentSender createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new IntentSender(target) : null;
        }

        @DSModeled(DSC.SAFE)
        public IntentSender[] newArray(int size) {
            return new IntentSender[size];
        }
    };
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

