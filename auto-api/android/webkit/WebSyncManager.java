package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;

abstract class WebSyncManager implements Runnable {
    private Thread mSyncThread;
    private String mThreadName;
    protected Handler mHandler;
    protected WebViewDatabase mDataBase;
    private int mStartSyncRefCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.139 -0400", hash_original_method = "09DE2C11BB900513668F7B71351233D1", hash_generated_method = "5EA4658CD5C2100B556DBE6DB9418B2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected WebSyncManager(Context context, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(context.dsTaint);
        {
            mDataBase = WebViewDatabase.getInstance(context);
            mSyncThread = new Thread(this);
            mSyncThread.setName(mThreadName);
            mSyncThread.start();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "WebSyncManager can't be created without context");
        } //End block
        // ---------- Original Method ----------
        //mThreadName = name;
        //if (context != null) {
            //mDataBase = WebViewDatabase.getInstance(context);
            //mSyncThread = new Thread(this);
            //mSyncThread.setName(mThreadName);
            //mSyncThread.start();
        //} else {
            //throw new IllegalStateException(
                    //"WebSyncManager can't be created without context");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.139 -0400", hash_original_method = "192983167FE22E48CC26A3CAFDDD8D6B", hash_generated_method = "5CC070BE034CF82B9F1557AD1EF2C83D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Object clone() throws CloneNotSupportedException {
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException("doesn't implement Cloneable");
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.139 -0400", hash_original_method = "8834F89660AF74637C8D229EF4878BE6", hash_generated_method = "9CE7D1E984A796EABC0B5B107A906110")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        Looper.prepare();
        mHandler = new SyncHandler();
        onSyncInit();
        Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
        Message msg;
        msg = mHandler.obtainMessage(SYNC_MESSAGE);
        mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);
        Looper.loop();
        // ---------- Original Method ----------
        //Looper.prepare();
        //mHandler = new SyncHandler();
        //onSyncInit();
        //Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
        //Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
        //mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);
        //Looper.loop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.139 -0400", hash_original_method = "51D4EC34A270685406E251162F5D8313", hash_generated_method = "6A22569637A162F3A3411598D377CC36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sync() {
        mHandler.removeMessages(SYNC_MESSAGE);
        Message msg;
        msg = mHandler.obtainMessage(SYNC_MESSAGE);
        mHandler.sendMessageDelayed(msg, SYNC_NOW_INTERVAL);
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_SYNC_MANAGER) {
            //Log.v(LOGTAG, "*** WebSyncManager sync ***");
        //}
        //if (mHandler == null) {
            //return;
        //}
        //mHandler.removeMessages(SYNC_MESSAGE);
        //Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
        //mHandler.sendMessageDelayed(msg, SYNC_NOW_INTERVAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.140 -0400", hash_original_method = "84BE51CDF1BC4F6FA0DB81680F35DEC3", hash_generated_method = "70C8A13897EBE94452832600E10A27FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void resetSync() {
        mHandler.removeMessages(SYNC_MESSAGE);
        Message msg;
        msg = mHandler.obtainMessage(SYNC_MESSAGE);
        mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_SYNC_MANAGER) {
            //Log.v(LOGTAG, "*** WebSyncManager resetSync ***");
        //}
        //if (mHandler == null) {
            //return;
        //}
        //mHandler.removeMessages(SYNC_MESSAGE);
        //Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
        //mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.140 -0400", hash_original_method = "2AEDBC8F7C27D5B102C45AFA67E1CB2E", hash_generated_method = "068E1E85CA4907157F370695783B58E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startSync() {
        {
            Message msg;
            msg = mHandler.obtainMessage(SYNC_MESSAGE);
            mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_SYNC_MANAGER) {
            //Log.v(LOGTAG, "***  WebSyncManager startSync ***, Ref count:" + 
                    //mStartSyncRefCount);
        //}
        //if (mHandler == null) {
            //return;
        //}
        //if (++mStartSyncRefCount == 1) {
            //Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
            //mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.140 -0400", hash_original_method = "884F3EA0F4676AB73E893C1BBE34114E", hash_generated_method = "3BFD5379371D4F387D1F4760CB0D417F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopSync() {
        {
            mHandler.removeMessages(SYNC_MESSAGE);
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_SYNC_MANAGER) {
            //Log.v(LOGTAG, "*** WebSyncManager stopSync ***, Ref count:" + 
                    //mStartSyncRefCount);
        //}
        //if (mHandler == null) {
            //return;
        //}
        //if (--mStartSyncRefCount == 0) {
            //mHandler.removeMessages(SYNC_MESSAGE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.140 -0400", hash_original_method = "E2DCC4A23007ACC5EB483532AA9CED02", hash_generated_method = "39287E7B275BD495C704BF01DE9A8034")
    @DSModeled(DSC.SAFE)
    protected void onSyncInit() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    abstract void syncFromRamToFlash();

    
    private class SyncHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.141 -0400", hash_original_method = "C79529732E29CBEF9C80F3D4C78379DE", hash_generated_method = "C79529732E29CBEF9C80F3D4C78379DE")
                public SyncHandler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.141 -0400", hash_original_method = "DDFB485EC354F258C2B8352C9BF41A44", hash_generated_method = "CDA4DBB3C82DABAD870F3074E45F6D38")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            {
                syncFromRamToFlash();
                Message newmsg;
                newmsg = obtainMessage(SYNC_MESSAGE);
                sendMessageDelayed(newmsg, SYNC_LATER_INTERVAL);
            } //End block
            // ---------- Original Method ----------
            //if (msg.what == SYNC_MESSAGE) {
                //if (DebugFlags.WEB_SYNC_MANAGER) {
                    //Log.v(LOGTAG, "*** WebSyncManager sync ***");
                //}
                //syncFromRamToFlash();
                //Message newmsg = obtainMessage(SYNC_MESSAGE);
                //sendMessageDelayed(newmsg, SYNC_LATER_INTERVAL);
            //}
        }

        
    }


    
    private static final int SYNC_MESSAGE = 101;
    private static int SYNC_NOW_INTERVAL = 100;
    private static int SYNC_LATER_INTERVAL = 5 * 60 * 1000;
    protected static final String LOGTAG = "websync";
}

