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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.851 -0400", hash_original_field = "CE9AFA79AB3BED4D3F782109816DD7DF", hash_generated_field = "2A2EDBD898ACE1E88CC70BC46F6934B8")

    private Thread mSyncThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.851 -0400", hash_original_field = "DA7E7543AFA97E51EB91A3653B190F22", hash_generated_field = "255E38D50E331062F1EEB5D547E791DF")

    private String mThreadName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.851 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "32E2735BA7568F02BAA8C871F1451CB8")

    protected Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.851 -0400", hash_original_field = "C1A3099D37A59968718DB374307A0212", hash_generated_field = "FB041B1B4E7FD92B29065E290A0CA855")

    protected WebViewDatabase mDataBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.851 -0400", hash_original_field = "D84F8601A4E8321A67CE49FB1752DB51", hash_generated_field = "A9EC540100CABD12488EDBCF86572E46")

    private int mStartSyncRefCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.852 -0400", hash_original_method = "09DE2C11BB900513668F7B71351233D1", hash_generated_method = "803B4FBFCDE53FD55DBA2D62541697D0")
    protected  WebSyncManager(Context context, String name) {
        mThreadName = name;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.855 -0400", hash_original_method = "192983167FE22E48CC26A3CAFDDD8D6B", hash_generated_method = "485516C5E5A309F67F3624B095CDFF25")
    protected Object clone() throws CloneNotSupportedException {
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException("doesn't implement Cloneable");
        // ---------- Original Method ----------
        //throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.855 -0400", hash_original_method = "8834F89660AF74637C8D229EF4878BE6", hash_generated_method = "9CE7D1E984A796EABC0B5B107A906110")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.864 -0400", hash_original_method = "51D4EC34A270685406E251162F5D8313", hash_generated_method = "6A22569637A162F3A3411598D377CC36")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.865 -0400", hash_original_method = "84BE51CDF1BC4F6FA0DB81680F35DEC3", hash_generated_method = "70C8A13897EBE94452832600E10A27FF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.866 -0400", hash_original_method = "2AEDBC8F7C27D5B102C45AFA67E1CB2E", hash_generated_method = "068E1E85CA4907157F370695783B58E1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.873 -0400", hash_original_method = "884F3EA0F4676AB73E893C1BBE34114E", hash_generated_method = "3BFD5379371D4F387D1F4760CB0D417F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.874 -0400", hash_original_method = "E2DCC4A23007ACC5EB483532AA9CED02", hash_generated_method = "39287E7B275BD495C704BF01DE9A8034")
    protected void onSyncInit() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    abstract void syncFromRamToFlash();

    
    private class SyncHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.874 -0400", hash_original_method = "A501FFC6AE70F7E6319A21E151433B3A", hash_generated_method = "A501FFC6AE70F7E6319A21E151433B3A")
        public SyncHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.874 -0400", hash_original_method = "DDFB485EC354F258C2B8352C9BF41A44", hash_generated_method = "163E77FAE8B5A447D229BA39F8D1F5D3")
        @Override
        public void handleMessage(Message msg) {
            {
                syncFromRamToFlash();
                Message newmsg;
                newmsg = obtainMessage(SYNC_MESSAGE);
                sendMessageDelayed(newmsg, SYNC_LATER_INTERVAL);
            } //End block
            addTaint(msg.getTaint());
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.874 -0400", hash_original_field = "7A820AFD619F40E3210DF0587394AA8C", hash_generated_field = "DF8A32DD2E8C1E85F689883BEF4E3301")

    private static int SYNC_MESSAGE = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.874 -0400", hash_original_field = "A0E5DB44A053BC0D0B9A4A3AEDF23F05", hash_generated_field = "82F905345288726295999FD00CFCF6AF")

    private static int SYNC_NOW_INTERVAL = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.875 -0400", hash_original_field = "182B4929FB8F56E74505FD1E05A011B8", hash_generated_field = "1B09A54CCDEA4EB901AB6D4A7D3B1F2C")

    private static int SYNC_LATER_INTERVAL = 5 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.875 -0400", hash_original_field = "46A2CE1F0148ADA96D937CEAB54B8C82", hash_generated_field = "917BE6AC8B314390F2A69D40E603E15D")

    protected static String LOGTAG = "websync";
}

