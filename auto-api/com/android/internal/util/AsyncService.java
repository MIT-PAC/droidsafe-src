package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Slog;

abstract public class AsyncService extends Service {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.599 -0400", hash_original_field = "83FE717B4B643B5D605C868F0E136C03", hash_generated_field = "CFBB34CA870432E8D673742E9448B620")

    protected Messenger mMessenger;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.599 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.599 -0400", hash_original_field = "0BB591D7727ECCD510E461DC1E2D2926", hash_generated_field = "A7D79D621CC3D20A47995C9B9F25283E")

    AsyncServiceInfo mAsyncServiceInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.599 -0400", hash_original_method = "CDBBAD55BFC0A5CC84037EA07FE5935A", hash_generated_method = "CDBBAD55BFC0A5CC84037EA07FE5935A")
    public AsyncService ()
    {
        //Synthesized constructor
    }


    abstract public AsyncServiceInfo createHandler();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.600 -0400", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "C751B1FEE9D4962A730ACB6939653019")
    public Handler getHandler() {
        Handler varB4EAC82CA7396A68D541C85D26508E83_353066168 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_353066168 = mHandler;
        varB4EAC82CA7396A68D541C85D26508E83_353066168.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_353066168;
        // ---------- Original Method ----------
        //return mHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.600 -0400", hash_original_method = "3B5584E888A7B561A64B27D36B3A98B1", hash_generated_method = "E16B41F02880778C39873A593DFBFF5C")
    @Override
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onCreate();
        mAsyncServiceInfo = createHandler();
        mHandler = mAsyncServiceInfo.mHandler;
        mMessenger = new Messenger(mHandler);
        // ---------- Original Method ----------
        //super.onCreate();
        //mAsyncServiceInfo = createHandler();
        //mHandler = mAsyncServiceInfo.mHandler;
        //mMessenger = new Messenger(mHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.601 -0400", hash_original_method = "1BF64941FDCF96E405385BCB202DC026", hash_generated_method = "E43657F7B727B7994E15C5F06922DEFE")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Slog.d(TAG, "onStartCommand");
        Message msg = mHandler.obtainMessage();
        msg.what = CMD_ASYNC_SERVICE_ON_START_INTENT;
        msg.arg1 = flags;
        msg.arg2 = startId;
        msg.obj = intent;
        mHandler.sendMessage(msg);
        addTaint(intent.getTaint());
        addTaint(flags);
        addTaint(startId);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139647896 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139647896;
        // ---------- Original Method ----------
        //if (DBG) Slog.d(TAG, "onStartCommand");
        //Message msg = mHandler.obtainMessage();
        //msg.what = CMD_ASYNC_SERVICE_ON_START_INTENT;
        //msg.arg1 = flags;
        //msg.arg2 = startId;
        //msg.obj = intent;
        //mHandler.sendMessage(msg);
        //return mAsyncServiceInfo.mRestartFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.601 -0400", hash_original_method = "A27858FAC62CCDCA7FEFFF51708F3684", hash_generated_method = "F8BBC8D91C4BCBAF62A20BDED3521E66")
    @Override
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Slog.d(TAG, "onDestroy");
        Message msg = mHandler.obtainMessage();
        msg.what = CMD_ASYNC_SERVICE_DESTROY;
        mHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //if (DBG) Slog.d(TAG, "onDestroy");
        //Message msg = mHandler.obtainMessage();
        //msg.what = CMD_ASYNC_SERVICE_DESTROY;
        //mHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.602 -0400", hash_original_method = "A7446927BF81E8D364D2A886C10F0DCF", hash_generated_method = "CE4B7B02ABC098C3F96125DF3B544FCB")
    @Override
    public IBinder onBind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        IBinder varB4EAC82CA7396A68D541C85D26508E83_197925791 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_197925791 = mMessenger.getBinder();
        addTaint(intent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_197925791.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_197925791;
        // ---------- Original Method ----------
        //return mMessenger.getBinder();
    }

    
    public static final class AsyncServiceInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.602 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "6DF93AB74F06096C50D0F8467E97684D")

        public Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.602 -0400", hash_original_field = "FDE24472860778547D9251492037B887", hash_generated_field = "3893B7E05DD534868F5110AAD6A84303")

        public int mRestartFlags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.602 -0400", hash_original_method = "57A0F445E2B528F3F0EFA1B7467553A2", hash_generated_method = "57A0F445E2B528F3F0EFA1B7467553A2")
        public AsyncServiceInfo ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.602 -0400", hash_original_field = "66C1F0E9E80149F680F33F2421BA9C23", hash_generated_field = "5B5C7021874431C98C58C6AADA02BFF7")

    private static final String TAG = "AsyncService";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.602 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.602 -0400", hash_original_field = "35D34785FE0DEC51A5450564B8D35D5E", hash_generated_field = "5FA30C16C799029D741F47D3EB9013C0")

    public static final int CMD_ASYNC_SERVICE_ON_START_INTENT = IBinder.LAST_CALL_TRANSACTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.602 -0400", hash_original_field = "124FAA69F6BC718E206D6F89C624E470", hash_generated_field = "F74ECDA53837C00A8C968AEB044DAA22")

    public static final int CMD_ASYNC_SERVICE_DESTROY = IBinder.LAST_CALL_TRANSACTION + 1;
}

