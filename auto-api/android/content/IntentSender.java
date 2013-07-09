package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.375 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "E4E58773DF3C0920C12AA38B8FC403A5")

    private IIntentSender mTarget;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.375 -0400", hash_original_method = "BB3BE3704C38C3CFAEE93A10A1B40CE3", hash_generated_method = "2663241EBD81A494CAEAE58B33F2DC66")
    public  IntentSender(IIntentSender target) {
        mTarget = target;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.376 -0400", hash_original_method = "34B28E745C82742C6DB129EED6A7ACD1", hash_generated_method = "14968660335B1B1B82B8A923154417D9")
    public  IntentSender(IBinder target) {
        mTarget = IIntentSender.Stub.asInterface(target);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.377 -0400", hash_original_method = "D1640EC79CDF4472CD1CED043D9B375E", hash_generated_method = "9D655C93143908F72EFA0BD754768A5B")
    public void sendIntent(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler) throws SendIntentException {
        sendIntent(context, code, intent, onFinished, handler, null);
        addTaint(context.getTaint());
        addTaint(code);
        addTaint(intent.getTaint());
        addTaint(onFinished.getTaint());
        addTaint(handler.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.378 -0400", hash_original_method = "5984C2C3625490063272E3C39EF4CC1F", hash_generated_method = "016796477E7BBB647D8D5B85C82FE32B")
    public void sendIntent(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler, String requiredPermission) throws SendIntentException {
        try 
        {
            String resolvedType;
            resolvedType = intent.resolveTypeIfNeeded(context.getContentResolver());
            resolvedType = null;
            int res = mTarget.send(code, intent, resolvedType,
                    onFinished != null
                            ? new FinishedDispatcher(this, onFinished, handler)
                            : null,
                    requiredPermission);
            {
                if (DroidSafeAndroidRuntime.control) throw new SendIntentException();
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SendIntentException();
        } 
        addTaint(context.getTaint());
        addTaint(code);
        addTaint(intent.getTaint());
        addTaint(onFinished.getTaint());
        addTaint(handler.getTaint());
        addTaint(requiredPermission.getTaint());
        
        
            
                    
                    
            
                    
                            
                            
                    
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.380 -0400", hash_original_method = "1AE048A4984F76615C0EAE5393ABDA6D", hash_generated_method = "15AA7956730632C623BFAC8F397B01E0")
    public String getTargetPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1694468510 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2125778562 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1694468510 = ActivityManagerNative.getDefault()
                .getPackageForIntentSender(mTarget);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2125778562 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_164054496; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_164054496 = varB4EAC82CA7396A68D541C85D26508E83_1694468510;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_164054496 = varB4EAC82CA7396A68D541C85D26508E83_2125778562;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_164054496.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_164054496;
        
        
            
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.380 -0400", hash_original_method = "B8F30F83DBAD000A3D0EE0DBD675E1EE", hash_generated_method = "29C98193FA6E2F9571DE75530177520B")
    @Override
    public boolean equals(Object otherObj) {
        {
            boolean var6AAA5F34DD06D56119CF1CEA2623D5C0_1961562982 = (mTarget.asBinder().equals(((IntentSender)otherObj)
                    .mTarget.asBinder()));
        } 
        addTaint(otherObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88855558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_88855558;
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.381 -0400", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "5D0E51581D5D2F82F5922C4FD325767C")
    @Override
    public int hashCode() {
        int varE5FBB4A5F6456F5D2CFFCAD33E59F123_195030033 = (mTarget.asBinder().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158808444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158808444;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.382 -0400", hash_original_method = "E43F03B5A25195808BB96BD150CAE514", hash_generated_method = "A67E23AEC8D8CFAEEB61754782EA4D51")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1357038239 = null; 
        StringBuilder sb = new StringBuilder(128);
        sb.append("IntentSender{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(": ");
        sb.append(mTarget != null ? mTarget.asBinder() : null);
        sb.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_1357038239 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1357038239.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1357038239;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.383 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2141A65B8B7E6FF7EA04F4C91E6DC8C3")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892253677 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892253677;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.384 -0400", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "CB2D00ECBC9E35AA709F7B9DC3B570B9")
    public void writeToParcel(Parcel out, int flags) {
        out.writeStrongBinder(mTarget.asBinder());
        addTaint(out.getTaint());
        addTaint(flags);
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.385 -0400", hash_original_method = "5A73019C5B7699A011E114A766F68ECD", hash_generated_method = "AF4ABAD0086807C7E7337EA7E269386F")
    public IIntentSender getTarget() {
        IIntentSender varB4EAC82CA7396A68D541C85D26508E83_1179850807 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1179850807 = mTarget;
        varB4EAC82CA7396A68D541C85D26508E83_1179850807.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1179850807;
        
        
    }

    
    public static class SendIntentException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.386 -0400", hash_original_method = "3CCB3E3C6E6C65C0BEBBCAEF78CD6FBE", hash_generated_method = "CB8141C05BC43408A5593044AF4551A8")
        public  SendIntentException() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.387 -0400", hash_original_method = "2F0F888808ED374E72461686A526DBD5", hash_generated_method = "3D65C4B9722C2C702E36855D4994E789")
        public  SendIntentException(String name) {
            super(name);
            addTaint(name.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.387 -0400", hash_original_method = "124D84CE7C7EE822BF41BDFAD538F007", hash_generated_method = "F92E006546D061799119E44C8681B178")
        public  SendIntentException(Exception cause) {
            super(cause);
            addTaint(cause.getTaint());
            
        }

        
    }


    
    private static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.387 -0400", hash_original_field = "61ADD1865F3B86CD9BF213685358F4E1", hash_generated_field = "84BD9A0534D27174DCB55615309E820B")

        private IntentSender mIntentSender;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.388 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "3E0837F5746BF0F0EA46630CD994FC89")

        private OnFinished mWho;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.388 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.388 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.388 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "77069BAE5867220B0011AB47341F29C2")

        private int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.388 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "C1E52350501391E7118DB73479974476")

        private String mResultData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.388 -0400", hash_original_field = "15A7BDFA2595DFC979A8B0D8A65ABE14", hash_generated_field = "109BE0C611CD1E4823349D5DAFA222D0")

        private Bundle mResultExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.389 -0400", hash_original_method = "758C8818FE8D792B6839EA2D78825DC2", hash_generated_method = "5C21FDD7EDE5604E0F4AD647B421C7AE")
          FinishedDispatcher(IntentSender pi, OnFinished who, Handler handler) {
            mIntentSender = pi;
            mWho = who;
            mHandler = handler;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.391 -0400", hash_original_method = "B0E285A2D8AA1A0003201E2D8F6F7169", hash_generated_method = "0538DA2A05217B942D752ECF6F421D27")
        public void performReceive(Intent intent, int resultCode,
                String data, Bundle extras, boolean serialized, boolean sticky) {
            mIntent = intent;
            mResultCode = resultCode;
            mResultData = data;
            mResultExtras = extras;
            {
                run();
            } 
            {
                mHandler.post(this);
            } 
            addTaint(serialized);
            addTaint(sticky);
            
            
            
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.392 -0400", hash_original_method = "81E3A612882F37B7E9D205FA2DF9669A", hash_generated_method = "D912AA0A868C0CF106FF3B723FFC47F3")
        public void run() {
            mWho.onSendFinished(mIntentSender, mIntent, mResultCode,
                    mResultData, mResultExtras);
            
            
                    
        }

        
    }


    
    public interface OnFinished {
        
        void onSendFinished(IntentSender IntentSender, Intent intent,
                int resultCode, String resultData, Bundle resultExtras);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.392 -0400", hash_original_field = "65DC812B4255A97B0E3B4F361B82E6A8", hash_generated_field = "4F4C19488EB89DC17DFA975D7E159256")

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
    
    public IntentSender createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new IntentSender(target) : null;
        }
    
    
    public IntentSender[] newArray(int size) {
            return new IntentSender[size];
        }
    
}

