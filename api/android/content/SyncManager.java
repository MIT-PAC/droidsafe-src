package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.RegisteredServicesCache;
import android.content.pm.RegisteredServicesCacheListener;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.WorkSource;
import android.provider.Settings;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;

import com.android.internal.R;
import com.android.internal.util.ArrayUtils;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;






public class SyncManager implements OnAccountsUpdateListener {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.339 -0500", hash_original_method = "868C4665098C5E1E551E069914A3869C", hash_generated_method = "962E00FF9753425DE0943B5B1EB5482A")
    static String formatTime(long time) {
        Time tobj = new Time();
        tobj.set(time);
        return tobj.format("%Y-%m-%d %H:%M:%S");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.241 -0500", hash_original_field = "264AE0F69A379AF82B30661B10A7553C", hash_generated_field = "AF31108A14FC5488BDB972C9330ED310")

    private static final String TAG = "SyncManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.241 -0500", hash_original_field = "F3430E3F09D68E40B45C15F013F1890D", hash_generated_field = "4208D47E32C101BD1011FA8D9E027183")

    private static  long LOCAL_SYNC_DELAY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.242 -0500", hash_original_field = "9B64AF0DF31B556F43213B53FF72FC3E", hash_generated_field = "63AD8E40CBA9E89F2FEE5FAFC18666A5")

    private static  long MAX_TIME_PER_SYNC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.243 -0500", hash_original_field = "152CFB1F4746092B0CF238EC2F0B64D8", hash_generated_field = "3AAF491FDBA16F2F889370991CA097D0")


    private static  long SYNC_NOTIFICATION_DELAY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.244 -0500", hash_original_field = "5C58C2EAABEF0EEB6C1B28E5353F2F7E", hash_generated_field = "83F3A378A2D13840721B0279CB462023")

    private static final long INITIAL_SYNC_RETRY_TIME_IN_MS = 30 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:42.192 -0500", hash_original_field = "EFD7058D08EE824519CCE863156AAFBA", hash_generated_field = "D9F9309F2A7D6BB06145CE9D49037E6C")


    /**
     * Default the max sync retry time to this value.
     */
    private static final long DEFAULT_MAX_SYNC_RETRY_TIME_IN_SECONDS = 60 * 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:42.193 -0500", hash_original_field = "11865CCD8959EA8A59F1BC8A9E425767", hash_generated_field = "5D2D36F41977B33D0EE5A8ABDE6B0790")


    /**
     * How long to wait before retrying a sync that failed due to one already being in progress.
     */
    private static final int DELAY_RETRY_SYNC_IN_PROGRESS_IN_SECONDS = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.247 -0500", hash_original_field = "4089BAF2DA7C23D4D0032BA7DEE5B8BE", hash_generated_field = "B0D1B128A9CF950755F3C1F260FD40B6")


    private static final int INITIALIZATION_UNBIND_DELAY_MS = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.248 -0500", hash_original_field = "32DF7CC059FEC0B043C029D28FB3AB32", hash_generated_field = "7F3CEE103BD418D549113FC97263D665")


    private static final String SYNC_WAKE_LOCK_PREFIX = "*sync*";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.249 -0500", hash_original_field = "8C1EAC0F2EE23B45E6D497677A97B0E5", hash_generated_field = "B085210333D6AE1E4EF229385F1B25F4")

    private static final String HANDLE_SYNC_ALARM_WAKE_LOCK = "SyncManagerHandleSyncAlarm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.250 -0500", hash_original_field = "F5BC5EA9499B1BE6601ECC7F384434DD", hash_generated_field = "791AF54DB72DF3C3FD2BE8EA99DCAD10")

    private static final String SYNC_LOOP_WAKE_LOCK = "SyncLoopWakeLock";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.251 -0500", hash_original_field = "C691AAC99D25250E9C7880580F75FB2A", hash_generated_field = "DC304F1B2F6CD9046C54D34DCF49FB2F")


    private static  int MAX_SIMULTANEOUS_REGULAR_SYNCS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.252 -0500", hash_original_field = "0BB5BAC0FB974F12BEDA9756A34D42B0", hash_generated_field = "8E80CF6DF9009EC95BD99B5E32172ABF")

    private static  int MAX_SIMULTANEOUS_INITIALIZATION_SYNCS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.270 -0500", hash_original_field = "C75D21172DC2853A9E452D6E66F9EAC4", hash_generated_field = "AC3DDB789130E3521D0C40EF27CE7201")


    private static final Account[] INITIAL_ACCOUNTS_ARRAY = new Account[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.272 -0500", hash_original_field = "75209FF05AFDA4AAAF88D8E26E589C21", hash_generated_field = "756530F66B344934D47CAC2FCBB3C754")


    private static final long SYNC_ALARM_TIMEOUT_MIN = 30 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.273 -0500", hash_original_field = "96B8EE59D89501E1B2D339F7302B2CF4", hash_generated_field = "7B838AAC8E827495E078DC2F638D031A")

    private static final long SYNC_ALARM_TIMEOUT_MAX = 2 * 60 * 60 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.280 -0500", hash_original_field = "9E4F8647B48053CF4FC225728CAEE0BA", hash_generated_field = "4F82340A6F1A976788D789CF812DC25C")


    private static final String ACTION_SYNC_ALARM = "android.content.syncmanager.SYNC_ALARM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.252 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.253 -0500", hash_original_field = "845A5A580213CBFD668C110606A2504F", hash_generated_field = "F3BBCBF609328E3671F4870EF2739BA1")


    private volatile Account[] mAccounts = INITIAL_ACCOUNTS_ARRAY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.254 -0500", hash_original_field = "8603C0242557F71A2994E4C3B773BB6F", hash_generated_field = "EA882B4EDA8036D1634A0912AFD18614")


    volatile private PowerManager.WakeLock mHandleAlarmWakeLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.255 -0500", hash_original_field = "B141A1644D25834F78CDC4DB249BE50D", hash_generated_field = "8C143BC8231548B929C0E876431327F2")

    volatile private PowerManager.WakeLock mSyncManagerWakeLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.256 -0500", hash_original_field = "A30B0D635DF10D910443C7132B050CB6", hash_generated_field = "17D5CCC25BF0F59A9B8C5AD2751D5254")

    volatile private boolean mDataConnectionIsConnected = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.256 -0500", hash_original_field = "02B459BD30A80E22BD7CF3AE0B3058F3", hash_generated_field = "466B67045A4516E83F397111D3AB9D8F")

    volatile private boolean mStorageIsLow = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.257 -0500", hash_original_field = "6A2B8A09D5C240CBD7AD74CDA4562CDB", hash_generated_field = "E3BFB96D82A2106A16337E9442023DA0")


    private  NotificationManager mNotificationMgr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.258 -0500", hash_original_field = "6D98CBFF94066488E311378512F8B5B0", hash_generated_field = "A708A7397CF3CD2AD62512A76A16AA9A")

    private AlarmManager mAlarmService = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.259 -0500", hash_original_field = "9E2BCBFE661FFE13826B6A4F1567CFD7", hash_generated_field = "C4D1F4553F2DAB654514F44F7C643ACD")


    private SyncStorageEngine mSyncStorageEngine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.260 -0500", hash_original_field = "D8967589B8332EBDEC8A18EE276DECC4", hash_generated_field = "9C22406DD21183D6092ABB0219CA18DB")

    public SyncQueue mSyncQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.260 -0500", hash_original_field = "2EB8B5E1EA4DFA355B7AADB92DD6C88F", hash_generated_field = "36C4E8795C18DEB3F2B34C61084BC4F5")


    protected final ArrayList<ActiveSyncContext> mActiveSyncContexts = Lists.newArrayList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.261 -0500", hash_original_field = "0016E9E72DBE1D94A821E3553BFFFD05", hash_generated_field = "2C170DA4C09FF899D129001B1ECCF61D")

    private boolean mNeedSyncActiveNotification = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.262 -0500", hash_original_field = "3A3E8F23738038ED964C67ADC77054D7", hash_generated_field = "FF2D77AC785FF38C8AC4F17DE204C25B")


    private  PendingIntent mSyncAlarmIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:42.210 -0500", hash_original_field = "FA8A1D4424A6623358333969B018DAD0", hash_generated_field = "39562B56F400454A44E271504F72B34B")

    // its accessor, getConnManager().
    private ConnectivityManager mConnManagerDoNotUseDirectly;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.264 -0500", hash_original_field = "28674E2BF490B530F6ABE61C2901A829", hash_generated_field = "E33ECCC9C6F1F57E962D4A8990DDF83C")


    protected SyncAdaptersCache mSyncAdapters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.955 -0400", hash_original_field = "BC6CA2320CEE3F5B1EE825BA50C5DBFE", hash_generated_field = "F3C421D42F701067D82ECB839BBBBFFC")

    private BroadcastReceiver mStorageIntentReceiver = new BroadcastReceiver() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.955 -0400", hash_original_method = "BC3DE36BD414D1E0AC1A290F3F999B72", hash_generated_method = "616D5C14DDD1CB50F92E18BD4160FC5A")
        public void onReceive(Context context, Intent intent) {
            
            String action = intent.getAction();
            {
                boolean var494408089C6C69852C6FEB8DA3256EBE_1424334157 = (Intent.ACTION_DEVICE_STORAGE_LOW.equals(action));
                {
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_347870742 = (Log.isLoggable(TAG, Log.VERBOSE));
                    } 
                    mStorageIsLow = true;
                    cancelActiveSync(null , null );
                } 
                {
                    boolean varDA8C0F6155EB4E90A0DAEBEA890A0A28_1441786012 = (Intent.ACTION_DEVICE_STORAGE_OK.equals(action));
                    {
                        {
                            boolean var0C9C1F857EF1208EE3C75B6103EF6F6E_562227873 = (Log.isLoggable(TAG, Log.VERBOSE));
                        } 
                        mStorageIsLow = false;
                        sendCheckAlarmsMessage();
                    } 
                } 
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
            
                        
                            
                        
                        
                        
                    
                        
                            
                        
                        
                        
                    
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.955 -0400", hash_original_field = "762F4D83742CECA3BECA29EC7B3D6902", hash_generated_field = "A2DFA1AE374B8819F333CB3258CB34F7")

    private BroadcastReceiver mBootCompletedReceiver = new BroadcastReceiver() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.955 -0400", hash_original_method = "48002FD0F3001594E3DAE34911FFCE18", hash_generated_method = "4B23DC7E7458A7DE52CE4CB804B826DF")
        public void onReceive(Context context, Intent intent) {
            
            mSyncHandler.onBootCompleted();
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.956 -0400", hash_original_field = "3348FFF7144827BFF9601B956A07D2A8", hash_generated_field = "C2A7D0DEE55BB4951D3B8B5FC801E1CF")

    private BroadcastReceiver mBackgroundDataSettingChanged = new BroadcastReceiver() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.956 -0400", hash_original_method = "8D0265854014D0DAAECDD8BFDBAC7B99", hash_generated_method = "91E3B3E5AC55482EA87CB637D007CF4E")
        public void onReceive(Context context, Intent intent) {
            
            {
                boolean varC0E64E7A82D55EFFFB410CFD8BF972ED_1378566581 = (getConnectivityManager().getBackgroundDataSetting());
                {
                    scheduleSync(null , null , new Bundle(), 0 ,
                        false );
                } 
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
                
                        
            
        }

        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.271 -0500", hash_original_field = "AE9C7C49DB568DF15B12F481B3602630", hash_generated_field = "C0ABFDE975E218E90A8E9AECD9B1F45A")


    private  PowerManager mPowerManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.957 -0400", hash_original_field = "AC08B54B30FB8D73D889BBE2EA8215E3", hash_generated_field = "B2960293B47A62F0FF9FAFC3CCB37638")

    private BroadcastReceiver mConnectivityIntentReceiver = new BroadcastReceiver() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.957 -0400", hash_original_method = "252074B4EB0924016B2ADBE10E34C1F3", hash_generated_method = "5BF35A17A472123D83FE2028E7EC7098")
        public void onReceive(Context context, Intent intent) {
            
            final boolean wasConnected = mDataConnectionIsConnected;
            mDataConnectionIsConnected = readDataConnectionState();
            {
                {
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1439842099 = (Log.isLoggable(TAG, Log.VERBOSE));
                    } 
                    mSyncStorageEngine.clearAllBackoffs(mSyncQueue);
                } 
                sendCheckAlarmsMessage();
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
            
            
                
                    
                        
                    
                    
                
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.958 -0400", hash_original_field = "4F7A3BC34E44876836A051C01D24E148", hash_generated_field = "5C19689F925230FE4696D22A8D7D74C2")

    private BroadcastReceiver mShutdownIntentReceiver = new BroadcastReceiver() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.958 -0400", hash_original_method = "C2982D871DFCE85BA68BED52BCB115FD", hash_generated_method = "4E850BAD6B340846E6D2CD9FCE56EC3A")
        public void onReceive(Context context, Intent intent) {
            
            getSyncStorageEngine().writeAllState();
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
            
        }

        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.280 -0500", hash_original_field = "30F3865DA6BDC3299D22E35C93783E71", hash_generated_field = "48C1F195FC8EA9F865537B3EB1F3D277")

    private  SyncHandler mSyncHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.281 -0500", hash_original_field = "028D008EEBDEF4402B8F64158F6B8728", hash_generated_field = "36D62901B5F66AD7425C1042CCC68DC2")

    private  Handler mMainHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.282 -0500", hash_original_field = "CB95B15DD6DB754D638B2E9E1BDFC8C5", hash_generated_field = "575B378AD4BFE1F61DDDF06CA57D041D")


    private volatile boolean mBootCompleted = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.286 -0500", hash_original_method = "03EC3B1422C9597488B0C8A9401C488F", hash_generated_method = "8CEFDAE76290DB2247BC9DDD5083EE30")
    public SyncManager(Context context, boolean factoryTest) {
        // Initialize the SyncStorageEngine first, before registering observers
        // and creating threads and so on; it may fail if the disk is full.
        mContext = context;
        SyncStorageEngine.init(context);
        mSyncStorageEngine = SyncStorageEngine.getSingleton();
        mSyncAdapters = new SyncAdaptersCache(mContext);
        mSyncQueue = new SyncQueue(mSyncStorageEngine, mSyncAdapters);

        HandlerThread syncThread = new HandlerThread("SyncHandlerThread",
                Process.THREAD_PRIORITY_BACKGROUND);
        syncThread.start();
        mSyncHandler = new SyncHandler(syncThread.getLooper());
        mMainHandler = new Handler(mContext.getMainLooper());

        mSyncAdapters.setListener(new RegisteredServicesCacheListener<SyncAdapterType>() {
            public void onServiceChanged(SyncAdapterType type, boolean removed) {
                if (!removed) {
                    scheduleSync(null, type.authority, null, 0 /* no delay */,
                            false /* onlyThoseWithUnkownSyncableState */);
                }
            }
        }, mSyncHandler);

        mSyncAlarmIntent = PendingIntent.getBroadcast(
                mContext, 0 /* ignored */, new Intent(ACTION_SYNC_ALARM), 0);

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(mConnectivityIntentReceiver, intentFilter);

        if (!factoryTest) {
            intentFilter = new IntentFilter(Intent.ACTION_BOOT_COMPLETED);
            context.registerReceiver(mBootCompletedReceiver, intentFilter);
        }

        intentFilter = new IntentFilter(ConnectivityManager.ACTION_BACKGROUND_DATA_SETTING_CHANGED);
        context.registerReceiver(mBackgroundDataSettingChanged, intentFilter);

        intentFilter = new IntentFilter(Intent.ACTION_DEVICE_STORAGE_LOW);
        intentFilter.addAction(Intent.ACTION_DEVICE_STORAGE_OK);
        context.registerReceiver(mStorageIntentReceiver, intentFilter);

        intentFilter = new IntentFilter(Intent.ACTION_SHUTDOWN);
        intentFilter.setPriority(100);
        context.registerReceiver(mShutdownIntentReceiver, intentFilter);

        if (!factoryTest) {
            mNotificationMgr = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
            context.registerReceiver(new SyncAlarmIntentReceiver(),
                    new IntentFilter(ACTION_SYNC_ALARM));
        } else {
            mNotificationMgr = null;
        }
        mPowerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);

        // This WakeLock is used to ensure that we stay awake between the time that we receive
        // a sync alarm notification and when we finish processing it. We need to do this
        // because we don't do the work in the alarm handler, rather we do it in a message
        // handler.
        mHandleAlarmWakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                HANDLE_SYNC_ALARM_WAKE_LOCK);
        mHandleAlarmWakeLock.setReferenceCounted(false);

        // This WakeLock is used to ensure that we stay awake while running the sync loop
        // message handler. Normally we will hold a sync adapter wake lock while it is being
        // synced but during the execution of the sync loop it might finish a sync for
        // one sync adapter before starting the sync for the other sync adapter and we
        // don't want the device to go to sleep during that window.
        mSyncManagerWakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                SYNC_LOOP_WAKE_LOCK);
        mSyncManagerWakeLock.setReferenceCounted(false);

        mSyncStorageEngine.addStatusChangeListener(
                ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS, new ISyncStatusObserver.Stub() {
            public void onStatusChanged(int which) {
                // force the sync loop to run if the settings change
                sendCheckAlarmsMessage();
            }
        });

        if (!factoryTest) {
            AccountManager.get(mContext).addOnAccountsUpdatedListener(SyncManager.this,
                mSyncHandler, false /* updateImmediately */);
            // do this synchronously to ensure we have the accounts before this call returns
            onAccountsUpdated(AccountManager.get(mContext).getAccounts());
        }
    } // two hours

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.274 -0500", hash_original_method = "F68E26CE46C5E71DC7131B4E8982A697", hash_generated_method = "C784E064F631A17307967154D2A286CA")
    public void onAccountsUpdated(Account[] accounts) {
        // remember if this was the first time this was called after an update
        final boolean justBootedUp = mAccounts == INITIAL_ACCOUNTS_ARRAY;
        mAccounts = accounts;

        // if a sync is in progress yet it is no longer in the accounts list,
        // cancel it
        for (ActiveSyncContext currentSyncContext : mActiveSyncContexts) {
            if (!ArrayUtils.contains(accounts, currentSyncContext.mSyncOperation.account)) {
                Log.d(TAG, "canceling sync since the account has been removed");
                sendSyncFinishedOrCanceledMessage(currentSyncContext,
                        null /* no result since this is a cancel */);
            }
        }

        // we must do this since we don't bother scheduling alarms when
        // the accounts are not set yet
        sendCheckAlarmsMessage();

        if (mBootCompleted) {
            mSyncStorageEngine.doDatabaseCleanup(accounts);
        }

        if (accounts.length > 0) {
            // If this is the first time this was called after a bootup then
            // the accounts haven't really changed, instead they were just loaded
            // from the AccountManager. Otherwise at least one of the accounts
            // has a change.
            //
            // If there was a real account change then force a sync of all accounts.
            // This is a bit of overkill, but at least it will end up retrying syncs
            // that failed due to an authentication failure and thus will recover if the
            // account change was a password update.
            //
            // If this was the bootup case then don't sync everything, instead only
            // sync those that have an unknown syncable state, which will give them
            // a chance to set their syncable state.

            boolean onlyThoseWithUnkownSyncableState = justBootedUp;
            scheduleSync(null, null, null, 0 /* no delay */, onlyThoseWithUnkownSyncableState);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.277 -0500", hash_original_method = "90A2C58DEF02026C184592212F85FF18", hash_generated_method = "3C8E66097B7278B4A38CF252A1DDA6B2")
    private boolean readDataConnectionState() {
        NetworkInfo networkInfo = getConnectivityManager().getActiveNetworkInfo();
        return (networkInfo != null) && networkInfo.isConnected();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.283 -0500", hash_original_method = "85835365DA8D3F37E74A4C98C5566C52", hash_generated_method = "E1D1CC1280EDED6866BFEFA3085B9698")
    private ConnectivityManager getConnectivityManager() {
        synchronized (this) {
            if (mConnManagerDoNotUseDirectly == null) {
                mConnManagerDoNotUseDirectly = (ConnectivityManager)mContext.getSystemService(
                        Context.CONNECTIVITY_SERVICE);
            }
            return mConnManagerDoNotUseDirectly;
        }
    }

    /**
     * Return a random value v that satisfies minValue <= v < maxValue. The difference between
     * maxValue and minValue must be less than Integer.MAX_VALUE.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.287 -0500", hash_original_method = "2C829A46E677D5FF63843A6B74A54E87", hash_generated_method = "E70428BC7F81D405D012426240F6C46E")
    private long jitterize(long minValue, long maxValue) {
        Random random = new Random(SystemClock.elapsedRealtime());
        long spread = maxValue - minValue;
        if (spread > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("the difference between the maxValue and the "
                    + "minValue must be less than " + Integer.MAX_VALUE);
        }
        return minValue + random.nextInt((int)spread);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.288 -0500", hash_original_method = "BC7A6B22ABBE0EBF148B37C3B72645F0", hash_generated_method = "8A53332D37684B50F04247CD91A254AD")
    public SyncStorageEngine getSyncStorageEngine() {
        return mSyncStorageEngine;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.289 -0500", hash_original_method = "51F169FF6EC2BB253880B74521EEDA04", hash_generated_method = "55AD7DE6237D442382C27E98D0DB8A89")
    private void ensureAlarmService() {
        if (mAlarmService == null) {
            mAlarmService = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.290 -0500", hash_original_method = "3B1126FA248635D8E240EE322F732C4B", hash_generated_method = "D22B2591A35228D21531770D339CC8DA")
    private void initializeSyncAdapter(Account account, String authority) {
        if (Log.isLoggable(TAG, Log.VERBOSE)) {
            Log.v(TAG, "initializeSyncAdapter: " + account + ", authority " + authority);
        }
        SyncAdapterType syncAdapterType = SyncAdapterType.newKey(authority, account.type);
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo =
                mSyncAdapters.getServiceInfo(syncAdapterType);
        if (syncAdapterInfo == null) {
            Log.w(TAG, "can't find a sync adapter for " + syncAdapterType + ", removing");
            mSyncStorageEngine.removeAuthority(account, authority);
            return;
        }

        Intent intent = new Intent();
        intent.setAction("android.content.SyncAdapter");
        intent.setComponent(syncAdapterInfo.componentName);
        if (!mContext.bindService(intent,
                new InitializerServiceConnection(account, authority, mContext, mMainHandler),
                Context.BIND_AUTO_CREATE | Context.BIND_NOT_FOREGROUND
                | Context.BIND_ALLOW_OOM_MANAGEMENT)) {
            Log.w(TAG, "initializeSyncAdapter: failed to bind to " + intent);
        }
    }

    /**
     * Initiate a sync. This can start a sync for all providers
     * (pass null to url, set onlyTicklable to false), only those
     * providers that are marked as ticklable (pass null to url,
     * set onlyTicklable to true), or a specific provider (set url
     * to the content url of the provider).
     *
     * <p>If the ContentResolver.SYNC_EXTRAS_UPLOAD boolean in extras is
     * true then initiate a sync that just checks for local changes to send
     * to the server, otherwise initiate a sync that first gets any
     * changes from the server before sending local changes back to
     * the server.
     *
     * <p>If a specific provider is being synced (the url is non-null)
     * then the extras can contain SyncAdapter-specific information
     * to control what gets synced (e.g. which specific feed to sync).
     *
     * <p>You'll start getting callbacks after this.
     *
     * @param requestedAccount the account to sync, may be null to signify all accounts
     * @param requestedAuthority the authority to sync, may be null to indicate all authorities
     * @param extras a Map of SyncAdapter-specific information to control
     *          syncs of a specific provider. Can be null. Is ignored
     *          if the url is null.
     * @param delay how many milliseconds in the future to wait before performing this
     * @param onlyThoseWithUnkownSyncableState
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.301 -0500", hash_original_method = "B73E52BAF4D022DC2D77FE197F842436", hash_generated_method = "68811D59D85B0B3BC00DE3DBDD6E8117")
    public void scheduleSync(Account requestedAccount, String requestedAuthority,
            Bundle extras, long delay, boolean onlyThoseWithUnkownSyncableState) {
        boolean isLoggable = Log.isLoggable(TAG, Log.VERBOSE);

        final boolean backgroundDataUsageAllowed = !mBootCompleted ||
                getConnectivityManager().getBackgroundDataSetting();

        if (extras == null) extras = new Bundle();

        Boolean expedited = extras.getBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, false);
        if (expedited) {
            delay = -1; // this means schedule at the front of the queue
        }

        Account[] accounts;
        if (requestedAccount != null) {
            accounts = new Account[]{requestedAccount};
        } else {
            // if the accounts aren't configured yet then we can't support an account-less
            // sync request
            accounts = mAccounts;
            if (accounts.length == 0) {
                if (isLoggable) {
                    Log.v(TAG, "scheduleSync: no accounts configured, dropping");
                }
                return;
            }
        }

        final boolean uploadOnly = extras.getBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, false);
        final boolean manualSync = extras.getBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, false);
        if (manualSync) {
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, true);
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, true);
        }
        final boolean ignoreSettings =
                extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, false);

        int source;
        if (uploadOnly) {
            source = SyncStorageEngine.SOURCE_LOCAL;
        } else if (manualSync) {
            source = SyncStorageEngine.SOURCE_USER;
        } else if (requestedAuthority == null) {
            source = SyncStorageEngine.SOURCE_POLL;
        } else {
            // this isn't strictly server, since arbitrary callers can (and do) request
            // a non-forced two-way sync on a specific url
            source = SyncStorageEngine.SOURCE_SERVER;
        }

        // Compile a list of authorities that have sync adapters.
        // For each authority sync each account that matches a sync adapter.
        final HashSet<String> syncableAuthorities = new HashSet<String>();
        for (RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapter :
                mSyncAdapters.getAllServices()) {
            syncableAuthorities.add(syncAdapter.type.authority);
        }

        // if the url was specified then replace the list of authorities with just this authority
        // or clear it if this authority isn't syncable
        if (requestedAuthority != null) {
            final boolean hasSyncAdapter = syncableAuthorities.contains(requestedAuthority);
            syncableAuthorities.clear();
            if (hasSyncAdapter) syncableAuthorities.add(requestedAuthority);
        }

        final boolean masterSyncAutomatically = mSyncStorageEngine.getMasterSyncAutomatically();

        for (String authority : syncableAuthorities) {
            for (Account account : accounts) {
                int isSyncable = mSyncStorageEngine.getIsSyncable(account, authority);
                if (isSyncable == 0) {
                    continue;
                }
                final RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo =
                        mSyncAdapters.getServiceInfo(
                                SyncAdapterType.newKey(authority, account.type));
                if (syncAdapterInfo == null) {
                    continue;
                }
                final boolean allowParallelSyncs = syncAdapterInfo.type.allowParallelSyncs();
                final boolean isAlwaysSyncable = syncAdapterInfo.type.isAlwaysSyncable();
                if (isSyncable < 0 && isAlwaysSyncable) {
                    mSyncStorageEngine.setIsSyncable(account, authority, 1);
                    isSyncable = 1;
                }
                if (onlyThoseWithUnkownSyncableState && isSyncable >= 0) {
                    continue;
                }
                if (!syncAdapterInfo.type.supportsUploading() && uploadOnly) {
                    continue;
                }

                // always allow if the isSyncable state is unknown
                boolean syncAllowed =
                        (isSyncable < 0)
                        || ignoreSettings
                        || (backgroundDataUsageAllowed && masterSyncAutomatically
                            && mSyncStorageEngine.getSyncAutomatically(account, authority));
                if (!syncAllowed) {
                    if (isLoggable) {
                        Log.d(TAG, "scheduleSync: sync of " + account + ", " + authority
                                + " is not allowed, dropping request");
                    }
                    continue;
                }

                Pair<Long, Long> backoff = mSyncStorageEngine.getBackoff(account, authority);
                long delayUntil = mSyncStorageEngine.getDelayUntilTime(account, authority);
                final long backoffTime = backoff != null ? backoff.first : 0;
                if (isSyncable < 0) {
                    Bundle newExtras = new Bundle();
                    newExtras.putBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, true);
                    if (isLoggable) {
                        Log.v(TAG, "scheduleSync:"
                                + " delay " + delay
                                + ", source " + source
                                + ", account " + account
                                + ", authority " + authority
                                + ", extras " + newExtras);
                    }
                    scheduleSyncOperation(
                            new SyncOperation(account, source, authority, newExtras, 0,
                                    backoffTime, delayUntil,
                                    allowParallelSyncs));
                }
                if (!onlyThoseWithUnkownSyncableState) {
                    if (isLoggable) {
                        Log.v(TAG, "scheduleSync:"
                                + " delay " + delay
                                + ", source " + source
                                + ", account " + account
                                + ", authority " + authority
                                + ", extras " + extras);
                    }
                    scheduleSyncOperation(
                            new SyncOperation(account, source, authority, extras, delay,
                                    backoffTime, delayUntil,
                                    allowParallelSyncs));
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.302 -0500", hash_original_method = "9A217D026FB5B08090F4BAFAA08C0DF7", hash_generated_method = "66C51F8AC2AF9A632DB25E5265E06FE1")
    public void scheduleLocalSync(Account account, String authority) {
        final Bundle extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        scheduleSync(account, authority, extras, LOCAL_SYNC_DELAY,
                false /* onlyThoseWithUnkownSyncableState */);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.303 -0500", hash_original_method = "0A2ACD1B7EA84D8FDEC2211873578368", hash_generated_method = "7291730C9E70766674342FB3BE517F48")
    public SyncAdapterType[] getSyncAdapterTypes() {
        final Collection<RegisteredServicesCache.ServiceInfo<SyncAdapterType>>
                serviceInfos =
                mSyncAdapters.getAllServices();
        SyncAdapterType[] types = new SyncAdapterType[serviceInfos.size()];
        int i = 0;
        for (RegisteredServicesCache.ServiceInfo<SyncAdapterType> serviceInfo : serviceInfos) {
            types[i] = serviceInfo.type;
            ++i;
        }
        return types;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.304 -0500", hash_original_method = "14A3D8C2E4B2E28E7EAE9416931B0D4D", hash_generated_method = "A72EF30B52851AC54AB4CF72BF451788")
    private void sendSyncAlarmMessage() {
        if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_SYNC_ALARM");
        mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_SYNC_ALARM);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.305 -0500", hash_original_method = "48CD41A4FC7AAC6DBD3D417BDFF3952E", hash_generated_method = "896E5067C0E45899884FF34849A6BB4B")
    private void sendCheckAlarmsMessage() {
        if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_CHECK_ALARMS");
        mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_CHECK_ALARMS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.306 -0500", hash_original_method = "A4D4C528BED9CEDB160AF5BFC279888F", hash_generated_method = "F6ACDAC7DAB6FF05F70F3EEBB9AEC06E")
    private void sendSyncFinishedOrCanceledMessage(ActiveSyncContext syncContext,
            SyncResult syncResult) {
        if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_SYNC_FINISHED");
        Message msg = mSyncHandler.obtainMessage();
        msg.what = SyncHandler.MESSAGE_SYNC_FINISHED;
        msg.obj = new SyncHandlerMessagePayload(syncContext, syncResult);
        mSyncHandler.sendMessage(msg);
    }

    
    private static class InitializerServiceConnection implements ServiceConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.291 -0500", hash_original_field = "77E70EE964F6B49E35EDB9210610AC8E", hash_generated_field = "3B055C3859C53A8ACDFC59C6C8440DF8")

        private  Account mAccount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.292 -0500", hash_original_field = "BC4522E788A053F96319766AEE95ACCB", hash_generated_field = "5E9A5C7D075BBF710B4D594B2F64B868")

        private  String mAuthority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.293 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private  Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.294 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "D774CCF7C32F86EE269A0C9F9D84415A")

        private volatile Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.295 -0500", hash_original_field = "C9E05499054E8056F0A4805D1295DEC9", hash_generated_field = "C96DBD94ABC21BAB3CFD91A494AEBFFE")

        private volatile boolean mInitialized;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.296 -0500", hash_original_method = "24302E8CE101646513826470385452C3", hash_generated_method = "44D4A03B7B5E2A3740EF0BCFA346F811")
        public InitializerServiceConnection(Account account, String authority, Context context,
                Handler handler) {
            mAccount = account;
            mAuthority = authority;
            mContext = context;
            mHandler = handler;
            mInitialized = false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.298 -0500", hash_original_method = "9C4A98A4ADBC598450E25E4EB304536B", hash_generated_method = "4FE20BCD4E939DEC9ED1EFC87B5C0ABF")
        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                if (!mInitialized) {
                    mInitialized = true;
                    if (Log.isLoggable(TAG, Log.VERBOSE)) {
                        Log.v(TAG, "calling initialize: " + mAccount + ", authority " + mAuthority);
                    }
                    ISyncAdapter.Stub.asInterface(service).initialize(mAccount, mAuthority);
                }
            } catch (RemoteException e) {
                // doesn't matter, we will retry again later
                Log.d(TAG, "error while initializing: " + mAccount + ", authority " + mAuthority,
                        e);
            } finally {
                // give the sync adapter time to initialize before unbinding from it
                // TODO: change this API to not rely on this timing, http://b/2500805
                mHandler.postDelayed(new Runnable() {
                    public void run() {
                        if (mContext != null) {
                            mContext.unbindService(InitializerServiceConnection.this);
                            mContext = null;
                        }
                    }
                }, INITIALIZATION_UNBIND_DELAY_MS);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.299 -0500", hash_original_method = "7C8777D718751E565C82B5C1458835CE", hash_generated_method = "8819CC5446606228F6A395524AAECE84")
        public void onServiceDisconnected(ComponentName name) {
            if (mContext != null) {
                mContext.unbindService(InitializerServiceConnection.this);
                mContext = null;
            }
        }

        
    }


    
    class SyncHandlerMessagePayload {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.308 -0500", hash_original_field = "C625860717E5838B98EA7B19EB8B27A2", hash_generated_field = "A63DF1A530DF0116354A195B2D61C988")

        public  ActiveSyncContext activeSyncContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.308 -0500", hash_original_field = "30CCDFB05BB78D935437109E44F615B5", hash_generated_field = "1E280B614C5836CFB973E2780B056065")

        public  SyncResult syncResult;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.309 -0500", hash_original_method = "56E2C68849F116EE41FAA5D226ECBDA3", hash_generated_method = "56E2C68849F116EE41FAA5D226ECBDA3")
        SyncHandlerMessagePayload(ActiveSyncContext syncContext, SyncResult syncResult) {
            this.activeSyncContext = syncContext;
            this.syncResult = syncResult;
        }

        
    }


    
    class SyncAlarmIntentReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.417 -0400", hash_original_method = "8972A0265D0AE4113C769D505643787E", hash_generated_method = "8972A0265D0AE4113C769D505643787E")
        public SyncAlarmIntentReceiver ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.311 -0500", hash_original_method = "B17BCAD698B90432E3978D14A6575096", hash_generated_method = "AC05120E515B5E624DA5B4792F2B76AD")
        public void onReceive(Context context, Intent intent) {
            mHandleAlarmWakeLock.acquire();
            sendSyncAlarmMessage();
        }

        
    }


    
    class ActiveSyncContext extends ISyncContext.Stub implements ServiceConnection, IBinder.DeathRecipient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.320 -0500", hash_original_field = "CAEB8FA396F504839F82FDA41F0B6FEA", hash_generated_field = "CAEB8FA396F504839F82FDA41F0B6FEA")

         SyncOperation mSyncOperation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.321 -0500", hash_original_field = "506D1AD61A010C0C1665DFBD26F66F91", hash_generated_field = "506D1AD61A010C0C1665DFBD26F66F91")

         long mHistoryRowId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.321 -0500", hash_original_field = "57DE2857F3D6D189DF99142B1CBC936B", hash_generated_field = "57DE2857F3D6D189DF99142B1CBC936B")

        ISyncAdapter mSyncAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.322 -0500", hash_original_field = "3C3A30DDD94D9D47CBB52C3848791CE7", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")

         long mStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.323 -0500", hash_original_field = "2DA32C9B0D6927F8ADE9B98444FE7E93", hash_generated_field = "2DA32C9B0D6927F8ADE9B98444FE7E93")

        long mTimeoutStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.324 -0500", hash_original_field = "E78E5DB82E19559DD5BEFC2040680967", hash_generated_field = "E78E5DB82E19559DD5BEFC2040680967")

        boolean mBound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.324 -0500", hash_original_field = "40DA6E2B4575B8523B863BAC87FE141E", hash_generated_field = "40DA6E2B4575B8523B863BAC87FE141E")

         PowerManager.WakeLock mSyncWakeLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.325 -0500", hash_original_field = "2C18D3EE7F9C970AA993762D01A316E3", hash_generated_field = "2C18D3EE7F9C970AA993762D01A316E3")

         int mSyncAdapterUid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.326 -0500", hash_original_field = "D364355005B405C007FFCAD9043FC337", hash_generated_field = "D364355005B405C007FFCAD9043FC337")

        SyncInfo mSyncInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.327 -0500", hash_original_field = "468C40F467A1821737E93795346B1787", hash_generated_field = "468C40F467A1821737E93795346B1787")

        boolean mIsLinkedToDeath = false;

        /**
         * Create an ActiveSyncContext for an impending sync and grab the wakelock for that
         * sync adapter. Since this grabs the wakelock you need to be sure to call
         * close() when you are done with this ActiveSyncContext, whether the sync succeeded
         * or not.
         * @param syncOperation the SyncOperation we are about to sync
         * @param historyRowId the row in which to record the history info for this sync
         * @param syncAdapterUid the UID of the application that contains the sync adapter
         * for this sync. This is used to attribute the wakelock hold to that application.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.328 -0500", hash_original_method = "FBEF152C2B412533A606ADB2B9DA9D2A", hash_generated_method = "934ED55826BA80564998FB18A725B8F7")
        public ActiveSyncContext(SyncOperation syncOperation, long historyRowId,
                int syncAdapterUid) {
            super();
            mSyncAdapterUid = syncAdapterUid;
            mSyncOperation = syncOperation;
            mHistoryRowId = historyRowId;
            mSyncAdapter = null;
            mStartTime = SystemClock.elapsedRealtime();
            mTimeoutStartTime = mStartTime;
            mSyncWakeLock = mSyncHandler.getSyncWakeLock(
                    mSyncOperation.account, mSyncOperation.authority);
            mSyncWakeLock.setWorkSource(new WorkSource(syncAdapterUid));
            mSyncWakeLock.acquire();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.328 -0500", hash_original_method = "7456DA1EA096E82DD762DA299B1797D3", hash_generated_method = "E0C9C354D05D8480CC9CFF615B9EE283")
        public void sendHeartbeat() {
            // heartbeats are no longer used
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.329 -0500", hash_original_method = "2741CA480AE203CDFD1BCCBB420C487D", hash_generated_method = "F812194F2D270B808A095FEBE3FA2336")
        public void onFinished(SyncResult result) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "onFinished: " + this);
            // include "this" in the message so that the handler can ignore it if this
            // ActiveSyncContext is no longer the mActiveSyncContext at message handling
            // time
            sendSyncFinishedOrCanceledMessage(this, result);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.330 -0500", hash_original_method = "EB9B131EDBEF0858B3038B79ABC0948E", hash_generated_method = "65BC9C6CBDCC89E2ACB2A1A5A760883B")
        public void toString(StringBuilder sb) {
            sb.append("startTime ").append(mStartTime)
                    .append(", mTimeoutStartTime ").append(mTimeoutStartTime)
                    .append(", mHistoryRowId ").append(mHistoryRowId)
                    .append(", syncOperation ").append(mSyncOperation);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.331 -0500", hash_original_method = "CBDE36ABE821F23EF1CFAFB665E67134", hash_generated_method = "6DDC1D2CCCB7A9F82CC7F0BA854617A5")
        public void onServiceConnected(ComponentName name, IBinder service) {
            Message msg = mSyncHandler.obtainMessage();
            msg.what = SyncHandler.MESSAGE_SERVICE_CONNECTED;
            msg.obj = new ServiceConnectionData(this, ISyncAdapter.Stub.asInterface(service));
            mSyncHandler.sendMessage(msg);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.332 -0500", hash_original_method = "E604348BDB0F3F95B7C0274B0D40964D", hash_generated_method = "4E6A01E67BD78CA904AEC2026A373A50")
        public void onServiceDisconnected(ComponentName name) {
            Message msg = mSyncHandler.obtainMessage();
            msg.what = SyncHandler.MESSAGE_SERVICE_DISCONNECTED;
            msg.obj = new ServiceConnectionData(this, null);
            mSyncHandler.sendMessage(msg);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.333 -0500", hash_original_method = "79606510FDB8502633B50F75722531BD", hash_generated_method = "79606510FDB8502633B50F75722531BD")
        boolean bindToSyncAdapter(RegisteredServicesCache.ServiceInfo info) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.d(TAG, "bindToSyncAdapter: " + info.componentName + ", connection " + this);
            }
            Intent intent = new Intent();
            intent.setAction("android.content.SyncAdapter");
            intent.setComponent(info.componentName);
            intent.putExtra(Intent.EXTRA_CLIENT_LABEL,
                    com.android.internal.R.string.sync_binding_label);
            intent.putExtra(Intent.EXTRA_CLIENT_INTENT, PendingIntent.getActivity(
                    mContext, 0, new Intent(Settings.ACTION_SYNC_SETTINGS), 0));
            mBound = true;
            final boolean bindResult = mContext.bindService(intent, this,
                    Context.BIND_AUTO_CREATE | Context.BIND_NOT_FOREGROUND
                    | Context.BIND_ALLOW_OOM_MANAGEMENT);
            if (!bindResult) {
                mBound = false;
            }
            return bindResult;
        }

        /**
         * Performs the required cleanup, which is the releasing of the wakelock and
         * unbinding from the sync adapter (if actually bound).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.334 -0500", hash_original_method = "BCACA708B6725C3BB29ED8DCC5E23FC1", hash_generated_method = "F5EDD96EE5977E159E75809E65120ECE")
        protected void close() {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.d(TAG, "unBindFromSyncAdapter: connection " + this);
            }
            if (mBound) {
                mBound = false;
                mContext.unbindService(this);
            }
            mSyncWakeLock.release();
            mSyncWakeLock.setWorkSource(null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.336 -0500", hash_original_method = "C99E9A460C6F28DBA730EF38203534A2", hash_generated_method = "3BECD9234F2F7FB11B03C135B5C86054")
        @Override
public String toString() {
            StringBuilder sb = new StringBuilder();
            toString(sb);
            return sb.toString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.337 -0500", hash_original_method = "A39B4ABAEA9F27E501EB3B3EC7A37B2F", hash_generated_method = "8438E77660EB602E7F8D8EBD7973AD2C")
        @Override
public void binderDied() {
            sendSyncFinishedOrCanceledMessage(this, null);
        }

        
    }


    
    private static class AuthoritySyncStats {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.352 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.353 -0500", hash_original_field = "019980784258B693231C7932844AF0BC", hash_generated_field = "019980784258B693231C7932844AF0BC")

        long elapsedTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.354 -0500", hash_original_field = "3A95A04ECEF69E80207E92842B01313D", hash_generated_field = "3A95A04ECEF69E80207E92842B01313D")

        int times;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.354 -0500", hash_original_field = "F30C35077CC725990FFE0E1D8AA05301", hash_generated_field = "F30C35077CC725990FFE0E1D8AA05301")

        Map<String, AccountSyncStats> accountMap = Maps.newHashMap();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.355 -0500", hash_original_method = "BA2AD08D9B4BF110732C8291C5F36CF8", hash_generated_method = "C569DAF1A529089ABB34870F514F3E04")
        private AuthoritySyncStats(String name) {
            this.name = name;
        }

        
    }


    
    private static class AccountSyncStats {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.357 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.358 -0500", hash_original_field = "019980784258B693231C7932844AF0BC", hash_generated_field = "019980784258B693231C7932844AF0BC")

        long elapsedTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.358 -0500", hash_original_field = "3A95A04ECEF69E80207E92842B01313D", hash_generated_field = "3A95A04ECEF69E80207E92842B01313D")

        int times;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.359 -0500", hash_original_method = "1D94286E4C9E35DF248CEA39D6389F91", hash_generated_method = "198934C6E675C2EDFBF5D8E667F470B3")
        private AccountSyncStats(String name) {
            this.name = name;
        }

        
    }


    
    private class SyncTimeTracker {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.361 -0500", hash_original_field = "462785F9BDC050A0984AB02796F85FBF", hash_generated_field = "462785F9BDC050A0984AB02796F85FBF")

        boolean mLastWasSyncing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.361 -0500", hash_original_field = "42BA20EF7800084DF8B05592B8E3E7BE", hash_generated_field = "42BA20EF7800084DF8B05592B8E3E7BE")

        long mWhenSyncStarted = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.362 -0500", hash_original_field = "34A093039C5B6C1239AC051BD507CA99", hash_generated_field = "2B002605222CEDCD3A05F1765E34CF80")

        private long mTimeSpentSyncing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.437 -0400", hash_original_method = "5641FE5F8977FB94C61AEE76E9EBD2B2", hash_generated_method = "5641FE5F8977FB94C61AEE76E9EBD2B2")
        public SyncTimeTracker ()
        {
            //Synthesized constructor
        }

        /** Call to let the tracker know that the sync state may have changed */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.363 -0500", hash_original_method = "3978D6C321E5167908096EFEB475874E", hash_generated_method = "E97DA93FBE369BF9AEF002CD7047468D")
        public synchronized void update() {
            final boolean isSyncInProgress = !mActiveSyncContexts.isEmpty();
            if (isSyncInProgress == mLastWasSyncing) return;
            final long now = SystemClock.elapsedRealtime();
            if (isSyncInProgress) {
                mWhenSyncStarted = now;
            } else {
                mTimeSpentSyncing += now - mWhenSyncStarted;
            }
            mLastWasSyncing = isSyncInProgress;
        }

        /** Get how long we have been syncing, in ms */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.364 -0500", hash_original_method = "73972E33AC37B98D757DD1126931E451", hash_generated_method = "E8E050816EDB154EDCCBEF0FC7375BCD")
        public synchronized long timeSpentSyncing() {
            if (!mLastWasSyncing) return mTimeSpentSyncing;

            final long now = SystemClock.elapsedRealtime();
            return mTimeSpentSyncing + (now - mWhenSyncStarted);
        }

        
    }


    
    class ServiceConnectionData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.366 -0500", hash_original_field = "C625860717E5838B98EA7B19EB8B27A2", hash_generated_field = "A63DF1A530DF0116354A195B2D61C988")

        public  ActiveSyncContext activeSyncContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.367 -0500", hash_original_field = "D05D481BB346CBD6D76DDBB0CD15D44F", hash_generated_field = "C583279FC3521EE740A066A3F5FFA86D")

        public  ISyncAdapter syncAdapter;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.368 -0500", hash_original_method = "CF4E9A067E77243E4BB7B7FFBE17CC6D", hash_generated_method = "CF4E9A067E77243E4BB7B7FFBE17CC6D")
        ServiceConnectionData(ActiveSyncContext activeSyncContext, ISyncAdapter syncAdapter) {
            this.activeSyncContext = activeSyncContext;
            this.syncAdapter = syncAdapter;
        }

        
    }


    
    class SyncHandler extends Handler {


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.269 -0400", hash_original_field = "04E66466C1F093B8709FCD3B200847DE", hash_generated_field = "F03D76E24B5BAEEEC5E781E9842C4EB9")

        private static final int MESSAGE_SYNC_FINISHED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.269 -0400", hash_original_field = "E8072A633FC65A35E7F3B406DE8746BA", hash_generated_field = "BDB782007E5D68167F6B06EB2CA7D48A")

        private static final int MESSAGE_SYNC_ALARM = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.269 -0400", hash_original_field = "58210B9DA4E39CD1A4BAC72BC3D1B4F6", hash_generated_field = "7364E5491E895C2B98EB095F0B8835C8")

        private static final int MESSAGE_CHECK_ALARMS = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.269 -0400", hash_original_field = "2B6D236658EBB17D35BFDF5A5759BF4F", hash_generated_field = "5C4626A1E2FFC85FE88989D99FB13AD1")

        private static final int MESSAGE_SERVICE_CONNECTED = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.269 -0400", hash_original_field = "EBB171FB6C106E6744E6D70DA20EEF7D", hash_generated_field = "9731C7183B81379CA2B0325FF943A098")

        private static final int MESSAGE_SERVICE_DISCONNECTED = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.269 -0400", hash_original_field = "B56FD915F9E3BA514D2DA1F9DBF0F24B", hash_generated_field = "0105AF109819D8B5DE1BE5345785186D")

        private static final int MESSAGE_CANCEL = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.375 -0500", hash_original_field = "E7D27FD73C3DE2A4069890D49E2CBA56", hash_generated_field = "1599D96A237A164A880FFE88C1C3EE7C")


        public final SyncNotificationInfo mSyncNotificationInfo = new SyncNotificationInfo();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.376 -0500", hash_original_field = "E719A734088D76E0B26FCEE2377AA569", hash_generated_field = "0C75AEF43A0C9FFA242F4986360329AE")

        private Long mAlarmScheduleTime = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.377 -0500", hash_original_field = "DA46E151A794E1264C4901CA787D59F2", hash_generated_field = "D1BE6D0FAF2F6FBF2B9D20FDC62CD03D")

        public final SyncTimeTracker mSyncTimeTracker = new SyncTimeTracker();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.378 -0500", hash_original_field = "ACEF0671EBACBC511E4CAAD0E209A1F0", hash_generated_field = "2F89F9D45AD779522DB295A0D1595A30")

        private final HashMap<Pair<Account, String>, PowerManager.WakeLock> mWakeLocks =
                Maps.newHashMap();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.379 -0500", hash_original_field = "402C81A743EC1C9B61A1A0FF7AB5045F", hash_generated_field = "28D2205C6B63956ABF9398C7BB3353C2")


        private volatile CountDownLatch mReadyToRunLatch = new CountDownLatch(1);

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.387 -0500", hash_original_method = "483F6356A2D06E95B4EBFBB05049FAB5", hash_generated_method = "865822B62B723F7CECB8506694F29152")
        public SyncHandler(Looper looper) {
            super(looper);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.379 -0500", hash_original_method = "A4C54FCCA01900F2BC7EC8A1E7F40380", hash_generated_method = "0D6AAEF0C98EE5CB1E845D2247E6BA30")
        public void onBootCompleted() {
            mBootCompleted = true;
            mSyncStorageEngine.doDatabaseCleanup(AccountManager.get(mContext).getAccounts());
            if (mReadyToRunLatch != null) {
                mReadyToRunLatch.countDown();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.380 -0500", hash_original_method = "F60450395CB7370B81745EFD5F3059FF", hash_generated_method = "49D7D01AE0147CC86F869261D70F331F")
        private PowerManager.WakeLock getSyncWakeLock(Account account, String authority) {
            final Pair<Account, String> wakeLockKey = Pair.create(account, authority);
            PowerManager.WakeLock wakeLock = mWakeLocks.get(wakeLockKey);
            if (wakeLock == null) {
                final String name = SYNC_WAKE_LOCK_PREFIX + "_" + authority + "_" + account;
                wakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, name);
                wakeLock.setReferenceCounted(false);
                mWakeLocks.put(wakeLockKey, wakeLock);
            }
            return wakeLock;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.381 -0500", hash_original_method = "CE8AE663CA89CC7DD7AABF796BC60E1D", hash_generated_method = "CE75B7F04697F3D0F3F1788B03D2E59A")
        private void waitUntilReadyToRun() {
            CountDownLatch latch = mReadyToRunLatch;
            if (latch != null) {
                while (true) {
                    try {
                        latch.await();
                        mReadyToRunLatch = null;
                        return;
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.389 -0500", hash_original_method = "AC98BBE28F5005D2D34EEDF919BF395C", hash_generated_method = "D5B3D37F5FF9529134AA97A3439A9C83")
        public void handleMessage(Message msg) {
            long earliestFuturePollTime = Long.MAX_VALUE;
            long nextPendingSyncTime = Long.MAX_VALUE;

            // Setting the value here instead of a method because we want the dumpsys logs
            // to have the most recent value used.
            try {
                waitUntilReadyToRun();
                mDataConnectionIsConnected = readDataConnectionState();
                mSyncManagerWakeLock.acquire();
                // Always do this first so that we be sure that any periodic syncs that
                // are ready to run have been converted into pending syncs. This allows the
                // logic that considers the next steps to take based on the set of pending syncs
                // to also take into account the periodic syncs.
                earliestFuturePollTime = scheduleReadyPeriodicSyncs();
                switch (msg.what) {
                    case SyncHandler.MESSAGE_CANCEL: {
                        Pair<Account, String> payload = (Pair<Account, String>)msg.obj;
                        if (Log.isLoggable(TAG, Log.VERBOSE)) {
                            Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_CANCEL: "
                                    + payload.first + ", " + payload.second);
                        }
                        cancelActiveSyncLocked(payload.first, payload.second);
                        nextPendingSyncTime = maybeStartNextSyncLocked();
                        break;
                    }

                    case SyncHandler.MESSAGE_SYNC_FINISHED:
                        if (Log.isLoggable(TAG, Log.VERBOSE)) {
                            Log.v(TAG, "handleSyncHandlerMessage: MESSAGE_SYNC_FINISHED");
                        }
                        SyncHandlerMessagePayload payload = (SyncHandlerMessagePayload)msg.obj;
                        if (!isSyncStillActive(payload.activeSyncContext)) {
                            Log.d(TAG, "handleSyncHandlerMessage: dropping since the "
                                    + "sync is no longer active: "
                                    + payload.activeSyncContext);
                            break;
                        }
                        runSyncFinishedOrCanceledLocked(payload.syncResult, payload.activeSyncContext);

                        // since a sync just finished check if it is time to start a new sync
                        nextPendingSyncTime = maybeStartNextSyncLocked();
                        break;

                    case SyncHandler.MESSAGE_SERVICE_CONNECTED: {
                        ServiceConnectionData msgData = (ServiceConnectionData)msg.obj;
                        if (Log.isLoggable(TAG, Log.VERBOSE)) {
                            Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_CONNECTED: "
                                    + msgData.activeSyncContext);
                        }
                        // check that this isn't an old message
                        if (isSyncStillActive(msgData.activeSyncContext)) {
                            runBoundToSyncAdapter(msgData.activeSyncContext, msgData.syncAdapter);
                        }
                        break;
                    }

                    case SyncHandler.MESSAGE_SERVICE_DISCONNECTED: {
                        final ActiveSyncContext currentSyncContext =
                                ((ServiceConnectionData)msg.obj).activeSyncContext;
                        if (Log.isLoggable(TAG, Log.VERBOSE)) {
                            Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_DISCONNECTED: "
                                    + currentSyncContext);
                        }
                        // check that this isn't an old message
                        if (isSyncStillActive(currentSyncContext)) {
                            // cancel the sync if we have a syncadapter, which means one is
                            // outstanding
                            if (currentSyncContext.mSyncAdapter != null) {
                                try {
                                    currentSyncContext.mSyncAdapter.cancelSync(currentSyncContext);
                                } catch (RemoteException e) {
                                    // we don't need to retry this in this case
                                }
                            }

                            // pretend that the sync failed with an IOException,
                            // which is a soft error
                            SyncResult syncResult = new SyncResult();
                            syncResult.stats.numIoExceptions++;
                            runSyncFinishedOrCanceledLocked(syncResult, currentSyncContext);

                            // since a sync just finished check if it is time to start a new sync
                            nextPendingSyncTime = maybeStartNextSyncLocked();
                        }

                        break;
                    }

                    case SyncHandler.MESSAGE_SYNC_ALARM: {
                        boolean isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
                        if (isLoggable) {
                            Log.v(TAG, "handleSyncHandlerMessage: MESSAGE_SYNC_ALARM");
                        }
                        mAlarmScheduleTime = null;
                        try {
                            nextPendingSyncTime = maybeStartNextSyncLocked();
                        } finally {
                            mHandleAlarmWakeLock.release();
                        }
                        break;
                    }

                    case SyncHandler.MESSAGE_CHECK_ALARMS:
                        if (Log.isLoggable(TAG, Log.VERBOSE)) {
                            Log.v(TAG, "handleSyncHandlerMessage: MESSAGE_CHECK_ALARMS");
                        }
                        nextPendingSyncTime = maybeStartNextSyncLocked();
                        break;
                }
            } finally {
                manageSyncNotificationLocked();
                manageSyncAlarmLocked(earliestFuturePollTime, nextPendingSyncTime);
                mSyncTimeTracker.update();
                mSyncManagerWakeLock.release();
            }
        }

        /**
         * Turn any periodic sync operations that are ready to run into pending sync operations.
         * @return the desired start time of the earliest future  periodic sync operation,
         * in milliseconds since boot
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.390 -0500", hash_original_method = "5F18B995A8D5126079C876CBB8B37FF8", hash_generated_method = "9B939A32BB270F981CC6D393026C6794")
        private long scheduleReadyPeriodicSyncs() {
            final boolean backgroundDataUsageAllowed =
                    getConnectivityManager().getBackgroundDataSetting();
            long earliestFuturePollTime = Long.MAX_VALUE;
            if (!backgroundDataUsageAllowed || !mSyncStorageEngine.getMasterSyncAutomatically()) {
                return earliestFuturePollTime;
            }
            final long nowAbsolute = System.currentTimeMillis();
            ArrayList<SyncStorageEngine.AuthorityInfo> infos = mSyncStorageEngine.getAuthorities();
            for (SyncStorageEngine.AuthorityInfo info : infos) {
                // skip the sync if the account of this operation no longer exists
                if (!ArrayUtils.contains(mAccounts, info.account)) {
                    continue;
                }

                if (!mSyncStorageEngine.getSyncAutomatically(info.account, info.authority)) {
                    continue;
                }

                if (mSyncStorageEngine.getIsSyncable(info.account, info.authority) == 0) {
                    continue;
                }

                SyncStatusInfo status = mSyncStorageEngine.getOrCreateSyncStatus(info);
                for (int i = 0, N = info.periodicSyncs.size(); i < N; i++) {
                    final Bundle extras = info.periodicSyncs.get(i).first;
                    final Long periodInSeconds = info.periodicSyncs.get(i).second;
                    // find when this periodic sync was last scheduled to run
                    final long lastPollTimeAbsolute = status.getPeriodicSyncTime(i);
                    // compute when this periodic sync should next run - this can be in the future
                    // for example if the user changed the time, synced and changed back.
                    final long nextPollTimeAbsolute = lastPollTimeAbsolute > nowAbsolute
                            ? nowAbsolute
                            : lastPollTimeAbsolute + periodInSeconds * 1000;
                    // if it is ready to run then schedule it and mark it as having been scheduled
                    if (nextPollTimeAbsolute <= nowAbsolute) {
                        final Pair<Long, Long> backoff =
                                mSyncStorageEngine.getBackoff(info.account, info.authority);
                        final RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo =
                                mSyncAdapters.getServiceInfo(
                                        SyncAdapterType.newKey(info.authority, info.account.type));
                        if (syncAdapterInfo == null) {
                            continue;
                        }
                        scheduleSyncOperation(
                                new SyncOperation(info.account, SyncStorageEngine.SOURCE_PERIODIC,
                                        info.authority, extras, 0 /* delay */,
                                        backoff != null ? backoff.first : 0,
                                        mSyncStorageEngine.getDelayUntilTime(
                                                info.account, info.authority),
                                        syncAdapterInfo.type.allowParallelSyncs()));
                        status.setPeriodicSyncTime(i, nowAbsolute);
                    } else {
                        // it isn't ready to run, remember this time if it is earlier than
                        // earliestFuturePollTime
                        if (nextPollTimeAbsolute < earliestFuturePollTime) {
                            earliestFuturePollTime = nextPollTimeAbsolute;
                        }
                    }
                }
            }

            if (earliestFuturePollTime == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }

            // convert absolute time to elapsed time
            return SystemClock.elapsedRealtime()
                    + ((earliestFuturePollTime < nowAbsolute)
                      ? 0
                      : (earliestFuturePollTime - nowAbsolute));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.393 -0500", hash_original_method = "8B5418D48FBDFB608CDA80C6788E1356", hash_generated_method = "9EF590F36DF09506A1AC184374DC8D93")
        private long maybeStartNextSyncLocked() {
            final boolean isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
            if (isLoggable) Log.v(TAG, "maybeStartNextSync");

            // If we aren't ready to run (e.g. the data connection is down), get out.
            if (!mDataConnectionIsConnected) {
                if (isLoggable) {
                    Log.v(TAG, "maybeStartNextSync: no data connection, skipping");
                }
                return Long.MAX_VALUE;
            }

            if (mStorageIsLow) {
                if (isLoggable) {
                    Log.v(TAG, "maybeStartNextSync: memory low, skipping");
                }
                return Long.MAX_VALUE;
            }

            // If the accounts aren't known yet then we aren't ready to run. We will be kicked
            // when the account lookup request does complete.
            Account[] accounts = mAccounts;
            if (accounts == INITIAL_ACCOUNTS_ARRAY) {
                if (isLoggable) {
                    Log.v(TAG, "maybeStartNextSync: accounts not known, skipping");
                }
                return Long.MAX_VALUE;
            }

            // Otherwise consume SyncOperations from the head of the SyncQueue until one is
            // found that is runnable (not disabled, etc). If that one is ready to run then
            // start it, otherwise just get out.
            final boolean backgroundDataUsageAllowed =
                    getConnectivityManager().getBackgroundDataSetting();
            final boolean masterSyncAutomatically = mSyncStorageEngine.getMasterSyncAutomatically();

            final long now = SystemClock.elapsedRealtime();

            // will be set to the next time that a sync should be considered for running
            long nextReadyToRunTime = Long.MAX_VALUE;

            // order the sync queue, dropping syncs that are not allowed
            ArrayList<SyncOperation> operations = new ArrayList<SyncOperation>();
            synchronized (mSyncQueue) {
                if (isLoggable) {
                    Log.v(TAG, "build the operation array, syncQueue size is "
                        + mSyncQueue.mOperationsMap.size());
                }
                Iterator<SyncOperation> operationIterator =
                        mSyncQueue.mOperationsMap.values().iterator();
                while (operationIterator.hasNext()) {
                    final SyncOperation op = operationIterator.next();

                    // drop the sync if the account of this operation no longer exists
                    if (!ArrayUtils.contains(mAccounts, op.account)) {
                        operationIterator.remove();
                        mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                        continue;
                    }

                    // drop this sync request if it isn't syncable
                    int syncableState = mSyncStorageEngine.getIsSyncable(op.account, op.authority);
                    if (syncableState == 0) {
                        operationIterator.remove();
                        mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                        continue;
                    }

                    // if the next run time is in the future, meaning there are no syncs ready
                    // to run, return the time
                    if (op.effectiveRunTime > now) {
                        if (nextReadyToRunTime > op.effectiveRunTime) {
                            nextReadyToRunTime = op.effectiveRunTime;
                        }
                        continue;
                    }

                    final RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo;
                    syncAdapterInfo = mSyncAdapters.getServiceInfo(
                            SyncAdapterType.newKey(op.authority, op.account.type));

                    // only proceed if network is connected for requesting UID
                    final boolean uidNetworkConnected;
                    if (syncAdapterInfo != null) {
                        final NetworkInfo networkInfo = getConnectivityManager()
                                .getActiveNetworkInfoForUid(syncAdapterInfo.uid);
                        uidNetworkConnected = networkInfo != null && networkInfo.isConnected();
                    } else {
                        uidNetworkConnected = false;
                    }

                    // skip the sync if it isn't manual, and auto sync or
                    // background data usage is disabled or network is
                    // disconnected for the target UID.
                    if (!op.extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, false)
                            && (syncableState > 0)
                            && (!masterSyncAutomatically
                                || !backgroundDataUsageAllowed
                                || !uidNetworkConnected
                                || !mSyncStorageEngine.getSyncAutomatically(
                                       op.account, op.authority))) {
                        operationIterator.remove();
                        mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                        continue;
                    }

                    operations.add(op);
                }
            }

            // find the next operation to dispatch, if one is ready
            // iterate from the top, keep issuing (while potentially cancelling existing syncs)
            // until the quotas are filled.
            // once the quotas are filled iterate once more to find when the next one would be
            // (also considering pre-emption reasons).
            if (isLoggable) Log.v(TAG, "sort the candidate operations, size " + operations.size());
            Collections.sort(operations);
            if (isLoggable) Log.v(TAG, "dispatch all ready sync operations");
            for (int i = 0, N = operations.size(); i < N; i++) {
                final SyncOperation candidate = operations.get(i);
                final boolean candidateIsInitialization = candidate.isInitialization();

                int numInit = 0;
                int numRegular = 0;
                ActiveSyncContext conflict = null;
                ActiveSyncContext longRunning = null;
                ActiveSyncContext toReschedule = null;

                for (ActiveSyncContext activeSyncContext : mActiveSyncContexts) {
                    final SyncOperation activeOp = activeSyncContext.mSyncOperation;
                    if (activeOp.isInitialization()) {
                        numInit++;
                    } else {
                        numRegular++;
                    }
                    if (activeOp.account.type.equals(candidate.account.type)
                            && activeOp.authority.equals(candidate.authority)
                            && (!activeOp.allowParallelSyncs
                                || activeOp.account.name.equals(candidate.account.name))) {
                        conflict = activeSyncContext;
                        // don't break out since we want to do a full count of the varieties
                    } else {
                        if (candidateIsInitialization == activeOp.isInitialization()
                                && activeSyncContext.mStartTime + MAX_TIME_PER_SYNC < now) {
                            longRunning = activeSyncContext;
                            // don't break out since we want to do a full count of the varieties
                        }
                    }
                }

                if (isLoggable) {
                    Log.v(TAG, "candidate " + (i + 1) + " of " + N + ": " + candidate);
                    Log.v(TAG, "  numActiveInit=" + numInit + ", numActiveRegular=" + numRegular);
                    Log.v(TAG, "  longRunning: " + longRunning);
                    Log.v(TAG, "  conflict: " + conflict);
                }

                if (conflict != null) {
                    if (candidateIsInitialization && !conflict.mSyncOperation.isInitialization()
                            && numInit < MAX_SIMULTANEOUS_INITIALIZATION_SYNCS) {
                        toReschedule = conflict;
                        if (Log.isLoggable(TAG, Log.VERBOSE)) {
                            Log.v(TAG, "canceling and rescheduling sync since an initialization "
                                    + "takes higher priority, " + conflict);
                        }
                    } else if (candidate.expedited && !conflict.mSyncOperation.expedited
                            && (candidateIsInitialization
                                == conflict.mSyncOperation.isInitialization())) {
                        toReschedule = conflict;
                        if (Log.isLoggable(TAG, Log.VERBOSE)) {
                            Log.v(TAG, "canceling and rescheduling sync since an expedited "
                                    + "takes higher priority, " + conflict);
                        }
                    } else {
                        continue;
                    }
                } else {
                    final boolean roomAvailable = candidateIsInitialization
                            ? numInit < MAX_SIMULTANEOUS_INITIALIZATION_SYNCS
                            : numRegular < MAX_SIMULTANEOUS_REGULAR_SYNCS;
                    if (roomAvailable) {
                        // dispatch candidate
                    } else if (longRunning != null
                            && (candidateIsInitialization
                                == longRunning.mSyncOperation.isInitialization())) {
                        toReschedule = longRunning;
                        if (Log.isLoggable(TAG, Log.VERBOSE)) {
                            Log.v(TAG, "canceling and rescheduling sync since it ran roo long, "
                                    + longRunning);
                        }
                    } else {
                        continue;
                    }
                }

                if (toReschedule != null) {
                    runSyncFinishedOrCanceledLocked(null, toReschedule);
                    scheduleSyncOperation(toReschedule.mSyncOperation);
                }
                synchronized (mSyncQueue){
                    mSyncQueue.remove(candidate);
                }
                dispatchSyncOperation(candidate);
            }

            return nextReadyToRunTime;
     }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.394 -0500", hash_original_method = "40340E62514BC19DB7E9216642814F86", hash_generated_method = "4410C918ADE32E42EF62ED2308700FFA")
        private boolean dispatchSyncOperation(SyncOperation op) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "dispatchSyncOperation: we are going to sync " + op);
                Log.v(TAG, "num active syncs: " + mActiveSyncContexts.size());
                for (ActiveSyncContext syncContext : mActiveSyncContexts) {
                    Log.v(TAG, syncContext.toString());
                }
            }

            // connect to the sync adapter
            SyncAdapterType syncAdapterType = SyncAdapterType.newKey(op.authority, op.account.type);
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo =
                    mSyncAdapters.getServiceInfo(syncAdapterType);
            if (syncAdapterInfo == null) {
                Log.d(TAG, "can't find a sync adapter for " + syncAdapterType
                        + ", removing settings for it");
                mSyncStorageEngine.removeAuthority(op.account, op.authority);
                return false;
            }

            ActiveSyncContext activeSyncContext =
                    new ActiveSyncContext(op, insertStartSyncEvent(op), syncAdapterInfo.uid);
            activeSyncContext.mSyncInfo = mSyncStorageEngine.addActiveSync(activeSyncContext);
            mActiveSyncContexts.add(activeSyncContext);
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "dispatchSyncOperation: starting " + activeSyncContext);
            }
            if (!activeSyncContext.bindToSyncAdapter(syncAdapterInfo)) {
                Log.e(TAG, "Bind attempt failed to " + syncAdapterInfo);
                closeActiveSyncContext(activeSyncContext);
                return false;
            }

            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.396 -0500", hash_original_method = "61AEAAC860377C6ACC1D13743DAD80A2", hash_generated_method = "4D6A132B2B0DF401011414CE015CFFC5")
        private void runBoundToSyncAdapter(final ActiveSyncContext activeSyncContext,
              ISyncAdapter syncAdapter) {
            activeSyncContext.mSyncAdapter = syncAdapter;
            final SyncOperation syncOperation = activeSyncContext.mSyncOperation;
            try {
                activeSyncContext.mIsLinkedToDeath = true;
                syncAdapter.asBinder().linkToDeath(activeSyncContext, 0);

                syncAdapter.startSync(activeSyncContext, syncOperation.authority,
                        syncOperation.account, syncOperation.extras);
            } catch (RemoteException remoteExc) {
                Log.d(TAG, "maybeStartNextSync: caught a RemoteException, rescheduling", remoteExc);
                closeActiveSyncContext(activeSyncContext);
                increaseBackoffSetting(syncOperation);
                scheduleSyncOperation(new SyncOperation(syncOperation));
            } catch (RuntimeException exc) {
                closeActiveSyncContext(activeSyncContext);
                Log.e(TAG, "Caught RuntimeException while starting the sync " + syncOperation, exc);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.396 -0500", hash_original_method = "7B28CEC882EFEBA05BFBBAFD319121EA", hash_generated_method = "6002EB5E6C65A2B33FC8BAEA7C86B03D")
        private void cancelActiveSyncLocked(Account account, String authority) {
            ArrayList<ActiveSyncContext> activeSyncs =
                    new ArrayList<ActiveSyncContext>(mActiveSyncContexts);
            for (ActiveSyncContext activeSyncContext : activeSyncs) {
                if (activeSyncContext != null) {
                    // if an authority was specified then only cancel the sync if it matches
                    if (account != null) {
                        if (!account.equals(activeSyncContext.mSyncOperation.account)) {
                            return;
                        }
                    }
                    // if an account was specified then only cancel the sync if it matches
                    if (authority != null) {
                        if (!authority.equals(activeSyncContext.mSyncOperation.authority)) {
                            return;
                        }
                    }
                    runSyncFinishedOrCanceledLocked(null /* no result since this is a cancel */,
                            activeSyncContext);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.398 -0500", hash_original_method = "8D8637124BC010FEF841826099E3536E", hash_generated_method = "373C7535CE5F1721869B327DABC3F312")
        private void runSyncFinishedOrCanceledLocked(SyncResult syncResult,
                ActiveSyncContext activeSyncContext) {
            boolean isLoggable = Log.isLoggable(TAG, Log.VERBOSE);

            if (activeSyncContext.mIsLinkedToDeath) {
                activeSyncContext.mSyncAdapter.asBinder().unlinkToDeath(activeSyncContext, 0);
                activeSyncContext.mIsLinkedToDeath = false;
            }
            closeActiveSyncContext(activeSyncContext);

            final SyncOperation syncOperation = activeSyncContext.mSyncOperation;

            final long elapsedTime = SystemClock.elapsedRealtime() - activeSyncContext.mStartTime;

            String historyMessage;
            int downstreamActivity;
            int upstreamActivity;
            if (syncResult != null) {
                if (isLoggable) {
                    Log.v(TAG, "runSyncFinishedOrCanceled [finished]: "
                            + syncOperation + ", result " + syncResult);
                }

                if (!syncResult.hasError()) {
                    historyMessage = SyncStorageEngine.MESG_SUCCESS;
                    // TODO: set these correctly when the SyncResult is extended to include it
                    downstreamActivity = 0;
                    upstreamActivity = 0;
                    clearBackoffSetting(syncOperation);
                } else {
                    Log.d(TAG, "failed sync operation " + syncOperation + ", " + syncResult);
                    // the operation failed so increase the backoff time
                    if (!syncResult.syncAlreadyInProgress) {
                        increaseBackoffSetting(syncOperation);
                    }
                    // reschedule the sync if so indicated by the syncResult
                    maybeRescheduleSync(syncResult, syncOperation);
                    historyMessage = Integer.toString(syncResultToErrorNumber(syncResult));
                    // TODO: set these correctly when the SyncResult is extended to include it
                    downstreamActivity = 0;
                    upstreamActivity = 0;
                }

                setDelayUntilTime(syncOperation, syncResult.delayUntil);
            } else {
                if (isLoggable) {
                    Log.v(TAG, "runSyncFinishedOrCanceled [canceled]: " + syncOperation);
                }
                if (activeSyncContext.mSyncAdapter != null) {
                    try {
                        activeSyncContext.mSyncAdapter.cancelSync(activeSyncContext);
                    } catch (RemoteException e) {
                        // we don't need to retry this in this case
                    }
                }
                historyMessage = SyncStorageEngine.MESG_CANCELED;
                downstreamActivity = 0;
                upstreamActivity = 0;
            }

            stopSyncEvent(activeSyncContext.mHistoryRowId, syncOperation, historyMessage,
                    upstreamActivity, downstreamActivity, elapsedTime);

            if (syncResult != null && syncResult.tooManyDeletions) {
                installHandleTooManyDeletesNotification(syncOperation.account,
                        syncOperation.authority, syncResult.stats.numDeletes);
            } else {
                mNotificationMgr.cancel(
                        syncOperation.account.hashCode() ^ syncOperation.authority.hashCode());
            }

            if (syncResult != null && syncResult.fullSyncRequested) {
                scheduleSyncOperation(new SyncOperation(syncOperation.account,
                        syncOperation.syncSource, syncOperation.authority, new Bundle(), 0,
                        syncOperation.backoff, syncOperation.delayUntil,
                        syncOperation.allowParallelSyncs));
            }
            // no need to schedule an alarm, as that will be done by our caller.
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.399 -0500", hash_original_method = "1880B76D7799B7E884F5DD7B88555973", hash_generated_method = "6A5809665A3C23B907E63F0C6051E243")
        private void closeActiveSyncContext(ActiveSyncContext activeSyncContext) {
            activeSyncContext.close();
            mActiveSyncContexts.remove(activeSyncContext);
            mSyncStorageEngine.removeActiveSync(activeSyncContext.mSyncInfo);
        }

        /**
         * Convert the error-containing SyncResult into the Sync.History error number. Since
         * the SyncResult may indicate multiple errors at once, this method just returns the
         * most "serious" error.
         * @param syncResult the SyncResult from which to read
         * @return the most "serious" error set in the SyncResult
         * @throws IllegalStateException if the SyncResult does not indicate any errors.
         *   If SyncResult.error() is true then it is safe to call this.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.400 -0500", hash_original_method = "F73ADCF1F7F7E573F488FB12A7E0DEC9", hash_generated_method = "709D340BF59F35234DFF46D5CEACA330")
        private int syncResultToErrorNumber(SyncResult syncResult) {
            if (syncResult.syncAlreadyInProgress)
                return ContentResolver.SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS;
            if (syncResult.stats.numAuthExceptions > 0)
                return ContentResolver.SYNC_ERROR_AUTHENTICATION;
            if (syncResult.stats.numIoExceptions > 0)
                return ContentResolver.SYNC_ERROR_IO;
            if (syncResult.stats.numParseExceptions > 0)
                return ContentResolver.SYNC_ERROR_PARSE;
            if (syncResult.stats.numConflictDetectedExceptions > 0)
                return ContentResolver.SYNC_ERROR_CONFLICT;
            if (syncResult.tooManyDeletions)
                return ContentResolver.SYNC_ERROR_TOO_MANY_DELETIONS;
            if (syncResult.tooManyRetries)
                return ContentResolver.SYNC_ERROR_TOO_MANY_RETRIES;
            if (syncResult.databaseError)
                return ContentResolver.SYNC_ERROR_INTERNAL;
            throw new IllegalStateException("we are not in an error state, " + syncResult);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.401 -0500", hash_original_method = "D7164ED4506DE94304BF76B0FBC03583", hash_generated_method = "0CCF20B02793E636D9E379B97E5897FE")
        private void manageSyncNotificationLocked() {
            boolean shouldCancel;
            boolean shouldInstall;

            if (mActiveSyncContexts.isEmpty()) {
                mSyncNotificationInfo.startTime = null;

                // we aren't syncing. if the notification is active then remember that we need
                // to cancel it and then clear out the info
                shouldCancel = mSyncNotificationInfo.isActive;
                shouldInstall = false;
            } else {
                // we are syncing
                final long now = SystemClock.elapsedRealtime();
                if (mSyncNotificationInfo.startTime == null) {
                    mSyncNotificationInfo.startTime = now;
                }

                // there are three cases:
                // - the notification is up: do nothing
                // - the notification is not up but it isn't time yet: don't install
                // - the notification is not up and it is time: need to install

                if (mSyncNotificationInfo.isActive) {
                    shouldInstall = shouldCancel = false;
                } else {
                    // it isn't currently up, so there is nothing to cancel
                    shouldCancel = false;

                    final boolean timeToShowNotification =
                            now > mSyncNotificationInfo.startTime + SYNC_NOTIFICATION_DELAY;
                    if (timeToShowNotification) {
                        shouldInstall = true;
                    } else {
                        // show the notification immediately if this is a manual sync
                        shouldInstall = false;
                        for (ActiveSyncContext activeSyncContext : mActiveSyncContexts) {
                            final boolean manualSync = activeSyncContext.mSyncOperation.extras
                                    .getBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, false);
                            if (manualSync) {
                                shouldInstall = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (shouldCancel && !shouldInstall) {
                mNeedSyncActiveNotification = false;
                sendSyncStateIntent();
                mSyncNotificationInfo.isActive = false;
            }

            if (shouldInstall) {
                mNeedSyncActiveNotification = true;
                sendSyncStateIntent();
                mSyncNotificationInfo.isActive = true;
            }
        }

        
        class SyncNotificationInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.382 -0500", hash_original_field = "D668059AD9B14841DD4D4E946150A758", hash_generated_field = "1F020E689776523E90BE0EA7B3F2C831")

            public boolean isActive = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:42.329 -0500", hash_original_field = "7BADA940BA70D425D56166E1FB80EF9A", hash_generated_field = "6EBA5780AD5C0D6A11CC8B40A0837D46")

            // the opposite transition.
            public Long startTime = null;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.513 -0400", hash_original_method = "4A2C88DB351F685B767C50ED28D568B0", hash_generated_method = "4A2C88DB351F685B767C50ED28D568B0")
            public SyncNotificationInfo ()
            {
                //Synthesized constructor
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.384 -0500", hash_original_method = "4796BE9F4C6BFE28E8FE17808C5D7635", hash_generated_method = "654787112CD4506BF0CBA4DC96EF8199")
            public void toString(StringBuilder sb) {
                sb.append("isActive ").append(isActive).append(", startTime ").append(startTime);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.385 -0500", hash_original_method = "C99E9A460C6F28DBA730EF38203534A2", hash_generated_method = "3BECD9234F2F7FB11B03C135B5C86054")
            @Override
public String toString() {
                StringBuilder sb = new StringBuilder();
                toString(sb);
                return sb.toString();
            }

            
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.403 -0500", hash_original_method = "E1B88EC7C887370D571018E17194D40D", hash_generated_method = "A5495618E7F5B03D4EF3599CA03BB6F8")
        private void manageSyncAlarmLocked(long nextPeriodicEventElapsedTime,
                long nextPendingEventElapsedTime) {
            // in each of these cases the sync loop will be kicked, which will cause this
            // method to be called again
            if (!mDataConnectionIsConnected) return;
            if (mStorageIsLow) return;

            // When the status bar notification should be raised
            final long notificationTime =
                    (!mSyncHandler.mSyncNotificationInfo.isActive
                            && mSyncHandler.mSyncNotificationInfo.startTime != null)
                            ? mSyncHandler.mSyncNotificationInfo.startTime + SYNC_NOTIFICATION_DELAY
                            : Long.MAX_VALUE;

            // When we should consider canceling an active sync
            long earliestTimeoutTime = Long.MAX_VALUE;
            for (ActiveSyncContext currentSyncContext : mActiveSyncContexts) {
                final long currentSyncTimeoutTime =
                        currentSyncContext.mTimeoutStartTime + MAX_TIME_PER_SYNC;
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    Log.v(TAG, "manageSyncAlarm: active sync, mTimeoutStartTime + MAX is "
                            + currentSyncTimeoutTime);
                }
                if (earliestTimeoutTime > currentSyncTimeoutTime) {
                    earliestTimeoutTime = currentSyncTimeoutTime;
                }
            }

            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "manageSyncAlarm: notificationTime is " + notificationTime);
            }

            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "manageSyncAlarm: earliestTimeoutTime is " + earliestTimeoutTime);
            }

            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "manageSyncAlarm: nextPeriodicEventElapsedTime is "
                        + nextPeriodicEventElapsedTime);
            }
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "manageSyncAlarm: nextPendingEventElapsedTime is "
                        + nextPendingEventElapsedTime);
            }

            long alarmTime = Math.min(notificationTime, earliestTimeoutTime);
            alarmTime = Math.min(alarmTime, nextPeriodicEventElapsedTime);
            alarmTime = Math.min(alarmTime, nextPendingEventElapsedTime);

            // Bound the alarm time.
            final long now = SystemClock.elapsedRealtime();
            if (alarmTime < now + SYNC_ALARM_TIMEOUT_MIN) {
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    Log.v(TAG, "manageSyncAlarm: the alarmTime is too small, "
                            + alarmTime + ", setting to " + (now + SYNC_ALARM_TIMEOUT_MIN));
                }
                alarmTime = now + SYNC_ALARM_TIMEOUT_MIN;
            } else if (alarmTime > now + SYNC_ALARM_TIMEOUT_MAX) {
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    Log.v(TAG, "manageSyncAlarm: the alarmTime is too large, "
                            + alarmTime + ", setting to " + (now + SYNC_ALARM_TIMEOUT_MIN));
                }
                alarmTime = now + SYNC_ALARM_TIMEOUT_MAX;
            }

            // determine if we need to set or cancel the alarm
            boolean shouldSet = false;
            boolean shouldCancel = false;
            final boolean alarmIsActive = mAlarmScheduleTime != null;
            final boolean needAlarm = alarmTime != Long.MAX_VALUE;
            if (needAlarm) {
                if (!alarmIsActive || alarmTime < mAlarmScheduleTime) {
                    shouldSet = true;
                }
            } else {
                shouldCancel = alarmIsActive;
            }

            // set or cancel the alarm as directed
            ensureAlarmService();
            if (shouldSet) {
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    Log.v(TAG, "requesting that the alarm manager wake us up at elapsed time "
                            + alarmTime + ", now is " + now + ", " + ((alarmTime - now) / 1000)
                            + " secs from now");
                }
                mAlarmScheduleTime = alarmTime;
                mAlarmService.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, alarmTime,
                        mSyncAlarmIntent);
            } else if (shouldCancel) {
                mAlarmScheduleTime = null;
                mAlarmService.cancel(mSyncAlarmIntent);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.404 -0500", hash_original_method = "A9010BB637A8EEC323C58050189C44ED", hash_generated_method = "F7900B66055B8D9623EC4F5AF202BA43")
        private void sendSyncStateIntent() {
            Intent syncStateIntent = new Intent(Intent.ACTION_SYNC_STATE_CHANGED);
            syncStateIntent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
            syncStateIntent.putExtra("active", mNeedSyncActiveNotification);
            syncStateIntent.putExtra("failing", false);
            mContext.sendBroadcast(syncStateIntent);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.405 -0500", hash_original_method = "87A468A0891FD210AAD2B0099F053FF2", hash_generated_method = "2D42FA9A0E80E359623681030C7CAEBB")
        private void installHandleTooManyDeletesNotification(Account account, String authority,
                long numDeletes) {
            if (mNotificationMgr == null) return;

            final ProviderInfo providerInfo = mContext.getPackageManager().resolveContentProvider(
                    authority, 0 /* flags */);
            if (providerInfo == null) {
                return;
            }
            CharSequence authorityName = providerInfo.loadLabel(mContext.getPackageManager());

            Intent clickIntent = new Intent(mContext, SyncActivityTooManyDeletes.class);
            clickIntent.putExtra("account", account);
            clickIntent.putExtra("authority", authority);
            clickIntent.putExtra("provider", authorityName.toString());
            clickIntent.putExtra("numDeletes", numDeletes);

            if (!isActivityAvailable(clickIntent)) {
                Log.w(TAG, "No activity found to handle too many deletes.");
                return;
            }

            final PendingIntent pendingIntent = PendingIntent
                    .getActivity(mContext, 0, clickIntent, PendingIntent.FLAG_CANCEL_CURRENT);

            CharSequence tooManyDeletesDescFormat = mContext.getResources().getText(
                    R.string.contentServiceTooManyDeletesNotificationDesc);

            Notification notification =
                new Notification(R.drawable.stat_notify_sync_error,
                        mContext.getString(R.string.contentServiceSync),
                        System.currentTimeMillis());
            notification.setLatestEventInfo(mContext,
                    mContext.getString(R.string.contentServiceSyncNotificationTitle),
                    String.format(tooManyDeletesDescFormat.toString(), authorityName),
                    pendingIntent);
            notification.flags |= Notification.FLAG_ONGOING_EVENT;
            mNotificationMgr.notify(account.hashCode() ^ authority.hashCode(), notification);
        }

        /**
         * Checks whether an activity exists on the system image for the given intent.
         *
         * @param intent The intent for an activity.
         * @return Whether or not an activity exists.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.406 -0500", hash_original_method = "ABB616725C31652C20F8F96BBDEFC6AA", hash_generated_method = "E03276DC332DEF5DB0A396B708CD9689")
        private boolean isActivityAvailable(Intent intent) {
            PackageManager pm = mContext.getPackageManager();
            List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
            int listSize = list.size();
            for (int i = 0; i < listSize; i++) {
                ResolveInfo resolveInfo = list.get(i);
                if ((resolveInfo.activityInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)
                        != 0) {
                    return true;
                }
            }

            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.407 -0500", hash_original_method = "6B3E86A8BC94835376C1AE5FBE72A92C", hash_generated_method = "C1956268552AD9DF1E4D5C766FEA0AD9")
        public long insertStartSyncEvent(SyncOperation syncOperation) {
            final int source = syncOperation.syncSource;
            final long now = System.currentTimeMillis();

            EventLog.writeEvent(2720, syncOperation.authority,
                                SyncStorageEngine.EVENT_START, source,
                                syncOperation.account.name.hashCode());

            return mSyncStorageEngine.insertStartSyncEvent(
                    syncOperation.account, syncOperation.authority, now, source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.408 -0500", hash_original_method = "7B2BF6D83EFC49C83F4A75250B3225F9", hash_generated_method = "89168F8BB14EFB60826199CA4E095EA8")
        public void stopSyncEvent(long rowId, SyncOperation syncOperation, String resultMessage,
                int upstreamActivity, int downstreamActivity, long elapsedTime) {
            EventLog.writeEvent(2720, syncOperation.authority,
                                SyncStorageEngine.EVENT_STOP, syncOperation.syncSource,
                                syncOperation.account.name.hashCode());

            mSyncStorageEngine.stopSyncEvent(rowId, elapsedTime,
                    resultMessage, downstreamActivity, upstreamActivity);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.307 -0500", hash_original_method = "162904FEAED4FE3BDD09493527BC709D", hash_generated_method = "30CD802BAD29DEC0BE30AADE1851260E")
    private void sendCancelSyncsMessage(final Account account, final String authority) {
        if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_CANCEL");
        Message msg = mSyncHandler.obtainMessage();
        msg.what = SyncHandler.MESSAGE_CANCEL;
        msg.obj = Pair.create(account, authority);
        mSyncHandler.sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.313 -0500", hash_original_method = "1BD5650AC2366081E95971C40228D13F", hash_generated_method = "F3B41AFF9A9C64B8CA72412AD848C9F6")
    private void clearBackoffSetting(SyncOperation op) {
        mSyncStorageEngine.setBackoff(op.account, op.authority,
                SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
        synchronized (mSyncQueue) {
            mSyncQueue.onBackoffChanged(op.account, op.authority, 0);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.314 -0500", hash_original_method = "42DD92B3EE29EAC346CC626BA6B5C78C", hash_generated_method = "54DF0E7641EE320AAB4AFE76F6EFC4A6")
    private void increaseBackoffSetting(SyncOperation op) {
        final long now = SystemClock.elapsedRealtime();

        final Pair<Long, Long> previousSettings =
                mSyncStorageEngine.getBackoff(op.account, op.authority);
        long newDelayInMs = -1;
        if (previousSettings != null) {
            // don't increase backoff before current backoff is expired. This will happen for op's
            // with ignoreBackoff set.
            if (now < previousSettings.first) {
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    Log.v(TAG, "Still in backoff, do not increase it. "
                        + "Remaining: " + ((previousSettings.first - now) / 1000) + " seconds.");
                }
                return;
            }
            // Subsequent delays are the double of the previous delay
            newDelayInMs = previousSettings.second * 2;
        }
        if (newDelayInMs <= 0) {
            // The initial delay is the jitterized INITIAL_SYNC_RETRY_TIME_IN_MS
            newDelayInMs = jitterize(INITIAL_SYNC_RETRY_TIME_IN_MS,
                    (long)(INITIAL_SYNC_RETRY_TIME_IN_MS * 1.1));
        }

        // Cap the delay
        long maxSyncRetryTimeInSeconds = Settings.Secure.getLong(mContext.getContentResolver(),
                Settings.Secure.SYNC_MAX_RETRY_DELAY_IN_SECONDS,
                DEFAULT_MAX_SYNC_RETRY_TIME_IN_SECONDS);
        if (newDelayInMs > maxSyncRetryTimeInSeconds * 1000) {
            newDelayInMs = maxSyncRetryTimeInSeconds * 1000;
        }

        final long backoff = now + newDelayInMs;

        mSyncStorageEngine.setBackoff(op.account, op.authority,
                backoff, newDelayInMs);

        op.backoff = backoff;
        op.updateEffectiveRunTime();

        synchronized (mSyncQueue) {
            mSyncQueue.onBackoffChanged(op.account, op.authority, backoff);
        }
    }
    static {
        final boolean isLargeRAM = ActivityManager.isLargeRAM();
        int defaultMaxInitSyncs = isLargeRAM ? 5 : 2;
        int defaultMaxRegularSyncs = isLargeRAM ? 2 : 1;
        MAX_SIMULTANEOUS_INITIALIZATION_SYNCS =
                SystemProperties.getInt("sync.max_init_syncs", defaultMaxInitSyncs);
        MAX_SIMULTANEOUS_REGULAR_SYNCS =
                SystemProperties.getInt("sync.max_regular_syncs", defaultMaxRegularSyncs);
        LOCAL_SYNC_DELAY =
                SystemProperties.getLong("sync.local_sync_delay", 30 * 1000 );
        MAX_TIME_PER_SYNC =
                SystemProperties.getLong("sync.max_time_per_sync", 5 * 60 * 1000 );
        SYNC_NOTIFICATION_DELAY =
                SystemProperties.getLong("sync.notification_delay", 30 * 1000 );
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.315 -0500", hash_original_method = "D0F8BD8389FAB953FA57BE172373CE33", hash_generated_method = "57D05F7ACE35CF49BA068F3A674B5331")
    private void setDelayUntilTime(SyncOperation op, long delayUntilSeconds) {
        final long delayUntil = delayUntilSeconds * 1000;
        final long absoluteNow = System.currentTimeMillis();
        long newDelayUntilTime;
        if (delayUntil > absoluteNow) {
            newDelayUntilTime = SystemClock.elapsedRealtime() + (delayUntil - absoluteNow);
        } else {
            newDelayUntilTime = 0;
        }
        mSyncStorageEngine.setDelayUntilTime(op.account, op.authority, newDelayUntilTime);
        synchronized (mSyncQueue) {
            mSyncQueue.onDelayUntilTimeChanged(op.account, op.authority, newDelayUntilTime);
        }
    }

    /**
     * Cancel the active sync if it matches the authority and account.
     * @param account limit the cancelations to syncs with this account, if non-null
     * @param authority limit the cancelations to syncs with this authority, if non-null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.316 -0500", hash_original_method = "CC013A9497DA672D61638E0368F0173C", hash_generated_method = "8815B0416208F1B491A58BB0505028B6")
    public void cancelActiveSync(Account account, String authority) {
        sendCancelSyncsMessage(account, authority);
    }

    /**
     * Create and schedule a SyncOperation.
     *
     * @param syncOperation the SyncOperation to schedule
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.316 -0500", hash_original_method = "B18DC4486E3B23A71F43236C6D4E20D9", hash_generated_method = "A3602EF00600F3986C8AAF7BA25206BA")
    public void scheduleSyncOperation(SyncOperation syncOperation) {
        boolean queueChanged;
        synchronized (mSyncQueue) {
            queueChanged = mSyncQueue.add(syncOperation);
        }

        if (queueChanged) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "scheduleSyncOperation: enqueued " + syncOperation);
            }
            sendCheckAlarmsMessage();
        } else {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "scheduleSyncOperation: dropping duplicate sync operation "
                        + syncOperation);
            }
        }
    }

    /**
     * Remove scheduled sync operations.
     * @param account limit the removals to operations with this account, if non-null
     * @param authority limit the removals to operations with this authority, if non-null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.317 -0500", hash_original_method = "A2720167EE002D05FE5DA0F6211150BE", hash_generated_method = "475387FBACEF2F5CBCF9DA6389D77F70")
    public void clearScheduledSyncOperations(Account account, String authority) {
        synchronized (mSyncQueue) {
            mSyncQueue.remove(account, authority);
        }
        mSyncStorageEngine.setBackoff(account, authority,
                SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.319 -0500", hash_original_method = "7F8B5486825DA8802A08F87FCECDEB6D", hash_generated_method = "D43EC31920600BF9E5E0B1F3669384C5")
    void maybeRescheduleSync(SyncResult syncResult, SyncOperation operation) {
        boolean isLoggable = Log.isLoggable(TAG, Log.DEBUG);
        if (isLoggable) {
            Log.d(TAG, "encountered error(s) during the sync: " + syncResult + ", " + operation);
        }

        operation = new SyncOperation(operation);

        // The SYNC_EXTRAS_IGNORE_BACKOFF only applies to the first attempt to sync a given
        // request. Retries of the request will always honor the backoff, so clear the
        // flag in case we retry this request.
        if (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, false)) {
            operation.extras.remove(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF);
        }

        // If this sync aborted because the internal sync loop retried too many times then
        //   don't reschedule. Otherwise we risk getting into a retry loop.
        // If the operation succeeded to some extent then retry immediately.
        // If this was a two-way sync then retry soft errors with an exponential backoff.
        // If this was an upward sync then schedule a two-way sync immediately.
        // Otherwise do not reschedule.
        if (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_DO_NOT_RETRY, false)) {
            Log.d(TAG, "not retrying sync operation because SYNC_EXTRAS_DO_NOT_RETRY was specified "
                    + operation);
        } else if (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, false)
                && !syncResult.syncAlreadyInProgress) {
            operation.extras.remove(ContentResolver.SYNC_EXTRAS_UPLOAD);
            Log.d(TAG, "retrying sync operation as a two-way sync because an upload-only sync "
                    + "encountered an error: " + operation);
            scheduleSyncOperation(operation);
        } else if (syncResult.tooManyRetries) {
            Log.d(TAG, "not retrying sync operation because it retried too many times: "
                    + operation);
        } else if (syncResult.madeSomeProgress()) {
            if (isLoggable) {
                Log.d(TAG, "retrying sync operation because even though it had an error "
                        + "it achieved some success");
            }
            scheduleSyncOperation(operation);
        } else if (syncResult.syncAlreadyInProgress) {
            if (isLoggable) {
                Log.d(TAG, "retrying sync operation that failed because there was already a "
                        + "sync in progress: " + operation);
            }
            scheduleSyncOperation(new SyncOperation(operation.account, operation.syncSource,
                    operation.authority, operation.extras,
                    DELAY_RETRY_SYNC_IN_PROGRESS_IN_SECONDS * 1000,
                    operation.backoff, operation.delayUntil, operation.allowParallelSyncs));
        } else if (syncResult.hasSoftError()) {
            if (isLoggable) {
                Log.d(TAG, "retrying sync operation because it encountered a soft error: "
                        + operation);
            }
            scheduleSyncOperation(operation);
        } else {
            Log.d(TAG, "not retrying sync operation because the error is a hard error: "
                    + operation);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.338 -0500", hash_original_method = "E59AB1EB4C672AE41E3C994B41A259B0", hash_generated_method = "460F19F4401C3E3FB1BFC2014B5B1EA3")
    protected void dump(FileDescriptor fd, PrintWriter pw) {
        dumpSyncState(pw);
        dumpSyncHistory(pw);

        pw.println();
        pw.println("SyncAdapters:");
        for (RegisteredServicesCache.ServiceInfo info : mSyncAdapters.getAllServices()) {
            pw.println("  " + info);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.341 -0500", hash_original_method = "A56698FB2481C281E3929C7135D64B8A", hash_generated_method = "E5C4EEF1BE5D0F7704B3D7B1C6A63106")
    protected void dumpSyncState(PrintWriter pw) {
        pw.print("data connected: "); pw.println(mDataConnectionIsConnected);
        pw.print("memory low: "); pw.println(mStorageIsLow);

        final Account[] accounts = mAccounts;
        pw.print("accounts: ");
        if (accounts != INITIAL_ACCOUNTS_ARRAY) {
            pw.println(accounts.length);
        } else {
            pw.println("not known yet");
        }
        final long now = SystemClock.elapsedRealtime();
        pw.print("now: "); pw.print(now);
        pw.println(" (" + formatTime(System.currentTimeMillis()) + ")");
        pw.print("uptime: "); pw.print(DateUtils.formatElapsedTime(now/1000));
                pw.println(" (HH:MM:SS)");
        pw.print("time spent syncing: ");
                pw.print(DateUtils.formatElapsedTime(
                        mSyncHandler.mSyncTimeTracker.timeSpentSyncing() / 1000));
                pw.print(" (HH:MM:SS), sync ");
                pw.print(mSyncHandler.mSyncTimeTracker.mLastWasSyncing ? "" : "not ");
                pw.println("in progress");
        if (mSyncHandler.mAlarmScheduleTime != null) {
            pw.print("next alarm time: "); pw.print(mSyncHandler.mAlarmScheduleTime);
                    pw.print(" (");
                    pw.print(DateUtils.formatElapsedTime((mSyncHandler.mAlarmScheduleTime-now)/1000));
                    pw.println(" (HH:MM:SS) from now)");
        } else {
            pw.println("no alarm is scheduled (there had better not be any pending syncs)");
        }

        pw.print("notification info: ");
        final StringBuilder sb = new StringBuilder();
        mSyncHandler.mSyncNotificationInfo.toString(sb);
        pw.println(sb.toString());

        pw.println();
        pw.println("Active Syncs: " + mActiveSyncContexts.size());
        for (SyncManager.ActiveSyncContext activeSyncContext : mActiveSyncContexts) {
            final long durationInSeconds = (now - activeSyncContext.mStartTime) / 1000;
            pw.print("  ");
            pw.print(DateUtils.formatElapsedTime(durationInSeconds));
            pw.print(" - ");
            pw.print(activeSyncContext.mSyncOperation.dump(false));
            pw.println();
        }

        synchronized (mSyncQueue) {
            sb.setLength(0);
            mSyncQueue.dump(sb);
        }
        pw.println();
        pw.print(sb.toString());

        // join the installed sync adapter with the accounts list and emit for everything
        pw.println();
        pw.println("Sync Status");
        for (Account account : accounts) {
            pw.print("  Account "); pw.print(account.name);
                    pw.print(" "); pw.print(account.type);
                    pw.println(":");
            for (RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterType :
                    mSyncAdapters.getAllServices()) {
                if (!syncAdapterType.type.accountType.equals(account.type)) {
                    continue;
                }

                SyncStorageEngine.AuthorityInfo settings = mSyncStorageEngine.getOrCreateAuthority(
                        account, syncAdapterType.type.authority);
                SyncStatusInfo status = mSyncStorageEngine.getOrCreateSyncStatus(settings);
                pw.print("    "); pw.print(settings.authority);
                pw.println(":");
                pw.print("      settings:");
                pw.print(" " + (settings.syncable > 0
                        ? "syncable"
                        : (settings.syncable == 0 ? "not syncable" : "not initialized")));
                pw.print(", " + (settings.enabled ? "enabled" : "disabled"));
                if (settings.delayUntil > now) {
                    pw.print(", delay for "
                            + ((settings.delayUntil - now) / 1000) + " sec");
                }
                if (settings.backoffTime > now) {
                    pw.print(", backoff for "
                            + ((settings.backoffTime - now) / 1000) + " sec");
                }
                if (settings.backoffDelay > 0) {
                    pw.print(", the backoff increment is " + settings.backoffDelay / 1000
                                + " sec");
                }
                pw.println();
                for (int periodicIndex = 0;
                        periodicIndex < settings.periodicSyncs.size();
                        periodicIndex++) {
                    Pair<Bundle, Long> info = settings.periodicSyncs.get(periodicIndex);
                    long lastPeriodicTime = status.getPeriodicSyncTime(periodicIndex);
                    long nextPeriodicTime = lastPeriodicTime + info.second * 1000;
                    pw.println("      periodic period=" + info.second
                            + ", extras=" + info.first
                            + ", next=" + formatTime(nextPeriodicTime));
                }
                pw.print("      count: local="); pw.print(status.numSourceLocal);
                pw.print(" poll="); pw.print(status.numSourcePoll);
                pw.print(" periodic="); pw.print(status.numSourcePeriodic);
                pw.print(" server="); pw.print(status.numSourceServer);
                pw.print(" user="); pw.print(status.numSourceUser);
                pw.print(" total="); pw.print(status.numSyncs);
                pw.println();
                pw.print("      total duration: ");
                pw.println(DateUtils.formatElapsedTime(status.totalElapsedTime/1000));
                if (status.lastSuccessTime != 0) {
                    pw.print("      SUCCESS: source=");
                    pw.print(SyncStorageEngine.SOURCES[status.lastSuccessSource]);
                    pw.print(" time=");
                    pw.println(formatTime(status.lastSuccessTime));
                }
                if (status.lastFailureTime != 0) {
                    pw.print("      FAILURE: source=");
                    pw.print(SyncStorageEngine.SOURCES[
                            status.lastFailureSource]);
                    pw.print(" initialTime=");
                    pw.print(formatTime(status.initialFailureTime));
                    pw.print(" lastTime=");
                    pw.println(formatTime(status.lastFailureTime));
                    int errCode = status.getLastFailureMesgAsInt(0);
                    pw.print("      message: "); pw.println(
                            getLastFailureMessage(errCode) + " (" + errCode + ")");
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.342 -0500", hash_original_method = "C2F823D43F1684BB9B7871B7A13E4AFA", hash_generated_method = "23B08CDB7D07BA4557A1E5F722A09891")
    private String getLastFailureMessage(int code) {
        switch (code) {
            case ContentResolver.SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS:
                return "sync already in progress";

            case ContentResolver.SYNC_ERROR_AUTHENTICATION:
                return "authentication error";

            case ContentResolver.SYNC_ERROR_IO:
                return "I/O error";

            case ContentResolver.SYNC_ERROR_PARSE:
                return "parse error";

            case ContentResolver.SYNC_ERROR_CONFLICT:
                return "conflict error";

            case ContentResolver.SYNC_ERROR_TOO_MANY_DELETIONS:
                return "too many deletions error";

            case ContentResolver.SYNC_ERROR_TOO_MANY_RETRIES:
                return "too many retries error";

            case ContentResolver.SYNC_ERROR_INTERNAL:
                return "internal error";

            default:
                return "unknown";
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.343 -0500", hash_original_method = "2E5C9A0C484B8BFAAD4FF120631D1FEC", hash_generated_method = "3D756EAC90092A2839B2F0D4075EE9BB")
    private void dumpTimeSec(PrintWriter pw, long time) {
        pw.print(time/1000); pw.print('.'); pw.print((time/100)%10);
        pw.print('s');
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.344 -0500", hash_original_method = "05C5ECB94ECE9FA6501463D9FF0137FC", hash_generated_method = "0C9CEBB4993925DBC053174806B4AA30")
    private void dumpDayStatistic(PrintWriter pw, SyncStorageEngine.DayStats ds) {
        pw.print("Success ("); pw.print(ds.successCount);
        if (ds.successCount > 0) {
            pw.print(" for "); dumpTimeSec(pw, ds.successTime);
            pw.print(" avg="); dumpTimeSec(pw, ds.successTime/ds.successCount);
        }
        pw.print(") Failure ("); pw.print(ds.failureCount);
        if (ds.failureCount > 0) {
            pw.print(" for "); dumpTimeSec(pw, ds.failureTime);
            pw.print(" avg="); dumpTimeSec(pw, ds.failureTime/ds.failureCount);
        }
        pw.println(")");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.345 -0500", hash_original_method = "47B1A67BEBB64EEFEE0789183294D0B7", hash_generated_method = "3DB271269F52E76FC8904419210514A5")
    protected void dumpSyncHistory(PrintWriter pw) {
        dumpRecentHistory(pw);
        dumpDayStatistics(pw);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.350 -0500", hash_original_method = "C137DBDBD7D2B9AF348453A35EDAB8EF", hash_generated_method = "B5D29A48771E7CDB25D49ACFA8EAAE7A")
    private void dumpRecentHistory(PrintWriter pw) {
        final ArrayList<SyncStorageEngine.SyncHistoryItem> items
                = mSyncStorageEngine.getSyncHistory();
        if (items != null && items.size() > 0) {
            final Map<String, AuthoritySyncStats> authorityMap = Maps.newHashMap();
            long totalElapsedTime = 0;
            long totalTimes = 0;
            final int N = items.size();

            int maxAuthority = 0;
            int maxAccount = 0;
            for (SyncStorageEngine.SyncHistoryItem item : items) {
                SyncStorageEngine.AuthorityInfo authority
                        = mSyncStorageEngine.getAuthority(item.authorityId);
                final String authorityName;
                final String accountKey;
                if (authority != null) {
                    authorityName = authority.authority;
                    accountKey = authority.account.name + "/" + authority.account.type;
                } else {
                    authorityName = "Unknown";
                    accountKey = "Unknown";
                }

                int length = authorityName.length();
                if (length > maxAuthority) {
                    maxAuthority = length;
                }
                length = accountKey.length();
                if (length > maxAccount) {
                    maxAccount = length;
                }

                final long elapsedTime = item.elapsedTime;
                totalElapsedTime += elapsedTime;
                totalTimes++;
                AuthoritySyncStats authoritySyncStats = authorityMap.get(authorityName);
                if (authoritySyncStats == null) {
                    authoritySyncStats = new AuthoritySyncStats(authorityName);
                    authorityMap.put(authorityName, authoritySyncStats);
                }
                authoritySyncStats.elapsedTime += elapsedTime;
                authoritySyncStats.times++;
                final Map<String, AccountSyncStats> accountMap = authoritySyncStats.accountMap;
                AccountSyncStats accountSyncStats = accountMap.get(accountKey);
                if (accountSyncStats == null) {
                    accountSyncStats = new AccountSyncStats(accountKey);
                    accountMap.put(accountKey, accountSyncStats);
                }
                accountSyncStats.elapsedTime += elapsedTime;
                accountSyncStats.times++;

            }

            pw.println();
            pw.printf("Detailed Statistics (Recent history):  %d (# of times) %ds (sync time)\n",
                    totalTimes, totalElapsedTime / 1000);

            final List<AuthoritySyncStats> sortedAuthorities =
                    new ArrayList<AuthoritySyncStats>(authorityMap.values());
            Collections.sort(sortedAuthorities, new Comparator<AuthoritySyncStats>() {
                @Override
                public int compare(AuthoritySyncStats lhs, AuthoritySyncStats rhs) {
                    // reverse order
                    int compare = Integer.compare(rhs.times, lhs.times);
                    if (compare == 0) {
                        compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                    }
                    return compare;
                }
            });

            final int maxLength = Math.max(maxAuthority, maxAccount + 3);
            final int padLength = 2 + 2 + maxLength + 2 + 10 + 11;
            final char chars[] = new char[padLength];
            Arrays.fill(chars, '-');
            final String separator = new String(chars);

            final String authorityFormat = String.format("  %%-%ds: %%-9s  %%-11s\n", maxLength + 2);
            final String accountFormat = String.format("    %%-%ds:   %%-9s  %%-11s\n", maxLength);

            pw.println(separator);
            for (AuthoritySyncStats authoritySyncStats : sortedAuthorities) {
                String name = authoritySyncStats.name;
                long elapsedTime;
                int times;
                String timeStr;
                String timesStr;

                elapsedTime = authoritySyncStats.elapsedTime;
                times = authoritySyncStats.times;
                timeStr = String.format("%ds/%d%%",
                        elapsedTime / 1000,
                        elapsedTime * 100 / totalElapsedTime);
                timesStr = String.format("%d/%d%%",
                        times,
                        times * 100 / totalTimes);
                pw.printf(authorityFormat, name, timesStr, timeStr);

                final List<AccountSyncStats> sortedAccounts =
                        new ArrayList<AccountSyncStats>(
                                authoritySyncStats.accountMap.values());
                Collections.sort(sortedAccounts, new Comparator<AccountSyncStats>() {
                    @Override
                    public int compare(AccountSyncStats lhs, AccountSyncStats rhs) {
                        // reverse order
                        int compare = Integer.compare(rhs.times, lhs.times);
                        if (compare == 0) {
                            compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                        }
                        return compare;
                    }
                });
                for (AccountSyncStats stats: sortedAccounts) {
                    elapsedTime = stats.elapsedTime;
                    times = stats.times;
                    timeStr = String.format("%ds/%d%%",
                            elapsedTime / 1000,
                            elapsedTime * 100 / totalElapsedTime);
                    timesStr = String.format("%d/%d%%",
                            times,
                            times * 100 / totalTimes);
                    pw.printf(accountFormat, stats.name, timesStr, timeStr);
                }
                pw.println(separator);
            }

            pw.println();
            pw.println("Recent Sync History");
            final String format = "  %-" + maxAccount + "s  %s\n";
            final Map<String, Long> lastTimeMap = Maps.newHashMap();

            for (int i = 0; i < N; i++) {
                SyncStorageEngine.SyncHistoryItem item = items.get(i);
                SyncStorageEngine.AuthorityInfo authority
                        = mSyncStorageEngine.getAuthority(item.authorityId);
                final String authorityName;
                final String accountKey;
                if (authority != null) {
                    authorityName = authority.authority;
                    accountKey = authority.account.name + "/" + authority.account.type;
                } else {
                    authorityName = "Unknown";
                    accountKey = "Unknown";
                }
                final long elapsedTime = item.elapsedTime;
                final Time time = new Time();
                final long eventTime = item.eventTime;
                time.set(eventTime);

                final String key = authorityName + "/" + accountKey;
                final Long lastEventTime = lastTimeMap.get(key);
                final String diffString;
                if (lastEventTime == null) {
                    diffString = "";
                } else {
                    final long diff = (lastEventTime - eventTime) / 1000;
                    if (diff < 60) {
                        diffString = String.valueOf(diff);
                    } else if (diff < 3600) {
                        diffString = String.format("%02d:%02d", diff / 60, diff % 60);
                    } else {
                        final long sec = diff % 3600;
                        diffString = String.format("%02d:%02d:%02d",
                                diff / 3600, sec / 60, sec % 60);
                    }
                }
                lastTimeMap.put(key, eventTime);

                pw.printf("  #%-3d: %s %8s  %5.1fs  %8s",
                        i + 1,
                        formatTime(eventTime),
                        SyncStorageEngine.SOURCES[item.source],
                        ((float) elapsedTime) / 1000,
                        diffString);
                pw.printf(format, accountKey, authorityName);

                if (item.event != SyncStorageEngine.EVENT_STOP
                        || item.upstreamActivity != 0
                        || item.downstreamActivity != 0) {
                    pw.printf("    event=%d upstreamActivity=%d downstreamActivity=%d\n",
                            item.event,
                            item.upstreamActivity,
                            item.downstreamActivity);
                }
                if (item.mesg != null
                        && !SyncStorageEngine.MESG_SUCCESS.equals(item.mesg)) {
                    pw.printf("    mesg=%s\n", item.mesg);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.351 -0500", hash_original_method = "9349911975C50CB78B5A389074CC1BDC", hash_generated_method = "B523465746AD0B4CBF27FDA0B4AEFE7A")
    private void dumpDayStatistics(PrintWriter pw) {
        SyncStorageEngine.DayStats dses[] = mSyncStorageEngine.getDayStatistics();
        if (dses != null && dses[0] != null) {
            pw.println();
            pw.println("Sync Statistics");
            pw.print("  Today:  "); dumpDayStatistic(pw, dses[0]);
            int today = dses[0].day;
            int i;
            SyncStorageEngine.DayStats ds;

            // Print each day in the current week.
            for (i=1; i<=6 && i < dses.length; i++) {
                ds = dses[i];
                if (ds == null) break;
                int delta = today-ds.day;
                if (delta > 6) break;

                pw.print("  Day-"); pw.print(delta); pw.print(":  ");
                dumpDayStatistic(pw, ds);
            }

            // Aggregate all following days into weeks and print totals.
            int weekDay = today;
            while (i < dses.length) {
                SyncStorageEngine.DayStats aggr = null;
                weekDay -= 7;
                while (i < dses.length) {
                    ds = dses[i];
                    if (ds == null) {
                        i = dses.length;
                        break;
                    }
                    int delta = weekDay-ds.day;
                    if (delta > 6) break;
                    i++;

                    if (aggr == null) {
                        aggr = new SyncStorageEngine.DayStats(weekDay);
                    }
                    aggr.successCount += ds.successCount;
                    aggr.successTime += ds.successTime;
                    aggr.failureCount += ds.failureCount;
                    aggr.failureTime += ds.failureTime;
                }
                if (aggr != null) {
                    pw.print("  Week-"); pw.print((today-weekDay)/7); pw.print(": ");
                    dumpDayStatistic(pw, aggr);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:59.415 -0500", hash_original_method = "3A4E555675ED758A699E30DB2B6A1D6C", hash_generated_method = "4A5C59DABE1CF9534BA25DD4234612A8")
    private boolean isSyncStillActive(ActiveSyncContext activeSyncContext) {
        for (ActiveSyncContext sync : mActiveSyncContexts) {
            if (sync == activeSyncContext) {
                return true;
            }
        }
        return false;
    }
}

