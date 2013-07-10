package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;

abstract class WebSyncManager implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.050 -0400", hash_original_field = "CE9AFA79AB3BED4D3F782109816DD7DF", hash_generated_field = "2A2EDBD898ACE1E88CC70BC46F6934B8")

    private Thread mSyncThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.050 -0400", hash_original_field = "DA7E7543AFA97E51EB91A3653B190F22", hash_generated_field = "255E38D50E331062F1EEB5D547E791DF")

    private String mThreadName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.050 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "32E2735BA7568F02BAA8C871F1451CB8")

    protected Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.050 -0400", hash_original_field = "C1A3099D37A59968718DB374307A0212", hash_generated_field = "FB041B1B4E7FD92B29065E290A0CA855")

    protected WebViewDatabase mDataBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.050 -0400", hash_original_field = "D84F8601A4E8321A67CE49FB1752DB51", hash_generated_field = "A9EC540100CABD12488EDBCF86572E46")

    private int mStartSyncRefCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.051 -0400", hash_original_method = "09DE2C11BB900513668F7B71351233D1", hash_generated_method = "803B4FBFCDE53FD55DBA2D62541697D0")
    protected  WebSyncManager(Context context, String name) {
        mThreadName = name;
        {
            mDataBase = WebViewDatabase.getInstance(context);
            mSyncThread = new Thread(this);
            mSyncThread.setName(mThreadName);
            mSyncThread.start();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "WebSyncManager can't be created without context");
        } 
        
        
        
            
            
            
            
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.051 -0400", hash_original_method = "192983167FE22E48CC26A3CAFDDD8D6B", hash_generated_method = "485516C5E5A309F67F3624B095CDFF25")
    protected Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException("doesn't implement Cloneable");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.052 -0400", hash_original_method = "8834F89660AF74637C8D229EF4878BE6", hash_generated_method = "73546D478E9530AF20B6B6090EA19E86")
    public void run() {
        Looper.prepare();
        mHandler = new SyncHandler();
        onSyncInit();
        Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
        Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
        mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);
        Looper.loop();
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.053 -0400", hash_original_method = "51D4EC34A270685406E251162F5D8313", hash_generated_method = "FFDF0367E84A9B471942E36965BA3EBE")
    public void sync() {
        mHandler.removeMessages(SYNC_MESSAGE);
        Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
        mHandler.sendMessageDelayed(msg, SYNC_NOW_INTERVAL);
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.053 -0400", hash_original_method = "84BE51CDF1BC4F6FA0DB81680F35DEC3", hash_generated_method = "1503914F9B1F0CAF52216AB89E06F99C")
    public void resetSync() {
        mHandler.removeMessages(SYNC_MESSAGE);
        Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
        mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.053 -0400", hash_original_method = "2AEDBC8F7C27D5B102C45AFA67E1CB2E", hash_generated_method = "60268EC4135DD9EB3E7C80A716374E63")
    public void startSync() {
        {
            Message msg = mHandler.obtainMessage(SYNC_MESSAGE);
            mHandler.sendMessageDelayed(msg, SYNC_LATER_INTERVAL);
        } 
        
        
            
                    
        
        
            
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.054 -0400", hash_original_method = "884F3EA0F4676AB73E893C1BBE34114E", hash_generated_method = "3BFD5379371D4F387D1F4760CB0D417F")
    public void stopSync() {
        {
            mHandler.removeMessages(SYNC_MESSAGE);
        } 
        
        
            
                    
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.054 -0400", hash_original_method = "E2DCC4A23007ACC5EB483532AA9CED02", hash_generated_method = "39287E7B275BD495C704BF01DE9A8034")
    protected void onSyncInit() {
        
        
    }

    
    abstract void syncFromRamToFlash();

    
    private class SyncHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.055 -0400", hash_original_method = "A501FFC6AE70F7E6319A21E151433B3A", hash_generated_method = "A501FFC6AE70F7E6319A21E151433B3A")
        public SyncHandler ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.055 -0400", hash_original_method = "DDFB485EC354F258C2B8352C9BF41A44", hash_generated_method = "A1A652135B31AF7B50155777C64140DB")
        @Override
        public void handleMessage(Message msg) {
            {
                syncFromRamToFlash();
                Message newmsg = obtainMessage(SYNC_MESSAGE);
                sendMessageDelayed(newmsg, SYNC_LATER_INTERVAL);
            } 
            addTaint(msg.getTaint());
            
            
                
                    
                
                
                
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.055 -0400", hash_original_field = "7A820AFD619F40E3210DF0587394AA8C", hash_generated_field = "E4D765345E06BE3C2527370BFAB10263")

    private static final int SYNC_MESSAGE = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.055 -0400", hash_original_field = "A0E5DB44A053BC0D0B9A4A3AEDF23F05", hash_generated_field = "82F905345288726295999FD00CFCF6AF")

    private static int SYNC_NOW_INTERVAL = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.055 -0400", hash_original_field = "182B4929FB8F56E74505FD1E05A011B8", hash_generated_field = "1B09A54CCDEA4EB901AB6D4A7D3B1F2C")

    private static int SYNC_LATER_INTERVAL = 5 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.055 -0400", hash_original_field = "46A2CE1F0148ADA96D937CEAB54B8C82", hash_generated_field = "2F0A3E5EAD0D0334CC20865767D1BA08")

    protected static final String LOGTAG = "websync";
}

