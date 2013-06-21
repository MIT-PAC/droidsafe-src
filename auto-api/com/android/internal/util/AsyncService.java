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
    protected Messenger mMessenger;
    Handler mHandler;
    AsyncServiceInfo mAsyncServiceInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.611 -0400", hash_original_method = "17BBCD4F84F48B790F76E90488507449", hash_generated_method = "17BBCD4F84F48B790F76E90488507449")
        public AsyncService ()
    {
    }


    abstract public AsyncServiceInfo createHandler();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.611 -0400", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "8F54973AA943C2C00E08B8BBB03BB7F6")
    @DSModeled(DSC.SAFE)
    public Handler getHandler() {
        return (Handler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.612 -0400", hash_original_method = "3B5584E888A7B561A64B27D36B3A98B1", hash_generated_method = "E16B41F02880778C39873A593DFBFF5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.612 -0400", hash_original_method = "1BF64941FDCF96E405385BCB202DC026", hash_generated_method = "6BD221CE97484061BCBF8FE4AE720A22")
    @DSModeled(DSC.SPEC)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(startId);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(intent.dsTaint);
        Slog.d(TAG, "onStartCommand");
        Message msg;
        msg = mHandler.obtainMessage();
        msg.what = CMD_ASYNC_SERVICE_ON_START_INTENT;
        msg.arg1 = flags;
        msg.arg2 = startId;
        msg.obj = intent;
        mHandler.sendMessage(msg);
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.612 -0400", hash_original_method = "A27858FAC62CCDCA7FEFFF51708F3684", hash_generated_method = "109464FC99E164CD3484451F257CFB8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Slog.d(TAG, "onDestroy");
        Message msg;
        msg = mHandler.obtainMessage();
        msg.what = CMD_ASYNC_SERVICE_DESTROY;
        mHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //if (DBG) Slog.d(TAG, "onDestroy");
        //Message msg = mHandler.obtainMessage();
        //msg.what = CMD_ASYNC_SERVICE_DESTROY;
        //mHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.613 -0400", hash_original_method = "A7446927BF81E8D364D2A886C10F0DCF", hash_generated_method = "8664A50C091F9F453CB5BBB8E700EC8A")
    @DSModeled(DSC.SPEC)
    @Override
    public IBinder onBind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(intent.dsTaint);
        IBinder var5F722F43E33F9BA8CE0BFBAC7AE67CC1_857183339 = (mMessenger.getBinder());
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMessenger.getBinder();
    }

    
    public static final class AsyncServiceInfo {
        public Handler mHandler;
        public int mRestartFlags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.613 -0400", hash_original_method = "1925786E0AD2412F2CCFD510F1E49B0D", hash_generated_method = "1925786E0AD2412F2CCFD510F1E49B0D")
                public AsyncServiceInfo ()
        {
        }


    }


    
    private static final String TAG = "AsyncService";
    protected static final boolean DBG = true;
    public static final int CMD_ASYNC_SERVICE_ON_START_INTENT = IBinder.LAST_CALL_TRANSACTION;
    public static final int CMD_ASYNC_SERVICE_DESTROY = IBinder.LAST_CALL_TRANSACTION + 1;
}

