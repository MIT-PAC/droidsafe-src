package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Slog;





abstract public class AsyncService extends Service {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.417 -0500", hash_original_field = "9994E9646940FD614A51DE0FA27C1D07", hash_generated_field = "5B5C7021874431C98C58C6AADA02BFF7")

    private static final String TAG = "AsyncService";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.420 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")


    protected static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.422 -0500", hash_original_field = "13C4037422CBEFFA478513C14E27E11F", hash_generated_field = "5FA30C16C799029D741F47D3EB9013C0")

    public static final int CMD_ASYNC_SERVICE_ON_START_INTENT = IBinder.LAST_CALL_TRANSACTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.425 -0500", hash_original_field = "01392CB3BCC9C98F1AC03E1D4AF3E4F7", hash_generated_field = "F74ECDA53837C00A8C968AEB044DAA22")

    public static final int CMD_ASYNC_SERVICE_DESTROY = IBinder.LAST_CALL_TRANSACTION + 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.427 -0500", hash_original_field = "8B6DF3488BAD8021770FD91E0323D045", hash_generated_field = "CFBB34CA870432E8D673742E9448B620")

    protected Messenger mMessenger;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.430 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.438 -0500", hash_original_field = "A7D79D621CC3D20A47995C9B9F25283E", hash_generated_field = "A7D79D621CC3D20A47995C9B9F25283E")


    AsyncServiceInfo mAsyncServiceInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.610 -0400", hash_original_method = "CDBBAD55BFC0A5CC84037EA07FE5935A", hash_generated_method = "CDBBAD55BFC0A5CC84037EA07FE5935A")
    public AsyncService ()
    {
        //Synthesized constructor
    }

    /**
     * Create the service's handler returning AsyncServiceInfo.
     *
     * @return AsyncServiceInfo
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.441 -0500", hash_original_method = "2A02510FC6CB36825E78E188F675AFA0", hash_generated_method = "07865F3EF27DFCFB02CD34AAD704B0C0")
    
abstract public AsyncServiceInfo createHandler();

    /**
     * Get the handler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.443 -0500", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "5553470799CBD6C40F98FB733AE4E7EA")
    
public Handler getHandler() {
        return mHandler;
    }

    
    public static final class AsyncServiceInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.433 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "6DF93AB74F06096C50D0F8467E97684D")

        public Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.435 -0500", hash_original_field = "6BE549B6E4F24D18EBDBC5C0E8F02F83", hash_generated_field = "3893B7E05DD534868F5110AAD6A84303")

        public int mRestartFlags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.612 -0400", hash_original_method = "57A0F445E2B528F3F0EFA1B7467553A2", hash_generated_method = "57A0F445E2B528F3F0EFA1B7467553A2")
        public AsyncServiceInfo ()
        {
            //Synthesized constructor
        }


    }

    /**
     * onCreate
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.446 -0500", hash_original_method = "3B5584E888A7B561A64B27D36B3A98B1", hash_generated_method = "2F0209148425403C4D0AEA4F12E9C065")
    
@Override
    public void onCreate() {
        super.onCreate();
        mAsyncServiceInfo = createHandler();
        mHandler = mAsyncServiceInfo.mHandler;
        mMessenger = new Messenger(mHandler);
    }

    /**
     * Sends the CMD_ASYNC_SERVICE_ON_START_INTENT message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.448 -0500", hash_original_method = "1BF64941FDCF96E405385BCB202DC026", hash_generated_method = "5F356562D9B8975212675028653F640C")
    
@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (DBG) Slog.d(TAG, "onStartCommand");

        Message msg = mHandler.obtainMessage();
        msg.what = CMD_ASYNC_SERVICE_ON_START_INTENT;
        msg.arg1 = flags;
        msg.arg2 = startId;
        msg.obj = intent;
        mHandler.sendMessage(msg);

        return mAsyncServiceInfo.mRestartFlags;
    }

    /**
     * Called when service is destroyed. After returning the
     * service is dead an no more processing should be expected
     * to occur.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.451 -0500", hash_original_method = "A27858FAC62CCDCA7FEFFF51708F3684", hash_generated_method = "4DCB9AA654E9FA02454C3E7C7170D0DD")
    
@Override
    public void onDestroy() {
        if (DBG) Slog.d(TAG, "onDestroy");

        Message msg = mHandler.obtainMessage();
        msg.what = CMD_ASYNC_SERVICE_DESTROY;
        mHandler.sendMessage(msg);
    }

    /**
     * Returns the Messenger's binder.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:48.453 -0500", hash_original_method = "A7446927BF81E8D364D2A886C10F0DCF", hash_generated_method = "05AD0B8BF7AC4BEA201F7C9708E17E2E")
    
@Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }
}

