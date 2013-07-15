package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import com.android.internal.util.ArrayUtils;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
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

public class SyncManager implements OnAccountsUpdateListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.839 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.839 -0400", hash_original_field = "C217519E7D6AA72743CEC5E5FD7C02F1", hash_generated_field = "F3BBCBF609328E3671F4870EF2739BA1")

    private volatile Account[] mAccounts = INITIAL_ACCOUNTS_ARRAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.839 -0400", hash_original_field = "3607537A4ABC9C2B0FDA6CD04E7BA4CF", hash_generated_field = "EA882B4EDA8036D1634A0912AFD18614")

    volatile private PowerManager.WakeLock mHandleAlarmWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.839 -0400", hash_original_field = "B8A7E3B6F94CE3A0F567CD61AFB97855", hash_generated_field = "8C143BC8231548B929C0E876431327F2")

    volatile private PowerManager.WakeLock mSyncManagerWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.839 -0400", hash_original_field = "4728A84AF4B8DF029806A2097B575A3A", hash_generated_field = "17D5CCC25BF0F59A9B8C5AD2751D5254")

    volatile private boolean mDataConnectionIsConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.839 -0400", hash_original_field = "B81CB3C0F8BD276814C574302F581993", hash_generated_field = "466B67045A4516E83F397111D3AB9D8F")

    volatile private boolean mStorageIsLow = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.840 -0400", hash_original_field = "1D89DACDF96236F3858ECCE33A51EFED", hash_generated_field = "E3BFB96D82A2106A16337E9442023DA0")

    private NotificationManager mNotificationMgr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.840 -0400", hash_original_field = "917992EEA0C7F4BC7CC5D5B270F6017F", hash_generated_field = "A708A7397CF3CD2AD62512A76A16AA9A")

    private AlarmManager mAlarmService = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.840 -0400", hash_original_field = "45147E3AEB1E4ADCE06A13083E577526", hash_generated_field = "C4D1F4553F2DAB654514F44F7C643ACD")

    private SyncStorageEngine mSyncStorageEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.840 -0400", hash_original_field = "C9FDEBC8B43E8CF10A847D8E78A297F9", hash_generated_field = "9C22406DD21183D6092ABB0219CA18DB")

    public SyncQueue mSyncQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.840 -0400", hash_original_field = "969116B6B37E354467E9B2E8F3E55C0D", hash_generated_field = "36C4E8795C18DEB3F2B34C61084BC4F5")

    protected final ArrayList<ActiveSyncContext> mActiveSyncContexts = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.840 -0400", hash_original_field = "1EA8C7643DB05CB27275C01529A3B68D", hash_generated_field = "2C170DA4C09FF899D129001B1ECCF61D")

    private boolean mNeedSyncActiveNotification = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.840 -0400", hash_original_field = "903D42B85DB5FCC64341BB05BCAF3314", hash_generated_field = "FF2D77AC785FF38C8AC4F17DE204C25B")

    private PendingIntent mSyncAlarmIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.840 -0400", hash_original_field = "CAF97C3C9F7900E8B91A0310501882F5", hash_generated_field = "4F3FBD8A907B6E0F5B4504A10DCCE878")

    private ConnectivityManager mConnManagerDoNotUseDirectly;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.840 -0400", hash_original_field = "5BACDC96B768A3E26C7617A22F60CBBA", hash_generated_field = "E33ECCC9C6F1F57E962D4A8990DDF83C")

    protected SyncAdaptersCache mSyncAdapters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.955 -0400", hash_original_field = "BC6CA2320CEE3F5B1EE825BA50C5DBFE", hash_generated_field = "F3C421D42F701067D82ECB839BBBBFFC")

    private BroadcastReceiver mStorageIntentReceiver = new BroadcastReceiver() {        
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.955 -0400", hash_original_method = "48002FD0F3001594E3DAE34911FFCE18", hash_generated_method = "4B23DC7E7458A7DE52CE4CB804B826DF")
        public void onReceive(Context context, Intent intent) {
            
            mSyncHandler.onBootCompleted();
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.956 -0400", hash_original_field = "3348FFF7144827BFF9601B956A07D2A8", hash_generated_field = "C2A7D0DEE55BB4951D3B8B5FC801E1CF")

    private BroadcastReceiver mBackgroundDataSettingChanged = new BroadcastReceiver() {        
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.841 -0400", hash_original_field = "914EF4BB3FD2989BEA197B83DB980E43", hash_generated_field = "C0ABFDE975E218E90A8E9AECD9B1F45A")

    private PowerManager mPowerManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.957 -0400", hash_original_field = "AC08B54B30FB8D73D889BBE2EA8215E3", hash_generated_field = "B2960293B47A62F0FF9FAFC3CCB37638")

    private BroadcastReceiver mConnectivityIntentReceiver = new BroadcastReceiver() {        
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.958 -0400", hash_original_method = "C2982D871DFCE85BA68BED52BCB115FD", hash_generated_method = "4E850BAD6B340846E6D2CD9FCE56EC3A")
        public void onReceive(Context context, Intent intent) {
            
            getSyncStorageEngine().writeAllState();
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.841 -0400", hash_original_field = "2BFA50A6F682F32C5E74B6BF1DA5F561", hash_generated_field = "48C1F195FC8EA9F865537B3EB1F3D277")

    private SyncHandler mSyncHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.841 -0400", hash_original_field = "07ED8299DCE5FFC54346DB7582134B71", hash_generated_field = "36D62901B5F66AD7425C1042CCC68DC2")

    private Handler mMainHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.841 -0400", hash_original_field = "3C0D61A464F7DDB2D139F30472309ADC", hash_generated_field = "575B378AD4BFE1F61DDDF06CA57D041D")

    private volatile boolean mBootCompleted = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.846 -0400", hash_original_method = "03EC3B1422C9597488B0C8A9401C488F", hash_generated_method = "6F43D410039C0737F12660010CD0F8BF")
    public  SyncManager(Context context, boolean factoryTest) {
        addTaint(factoryTest);
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.843 -0400", hash_original_method = "156EF77A103E5C10F6AA28A0B09EC843", hash_generated_method = "2800DF38A4BCE847DAA45DA847EA5B89")
        public void onServiceChanged(SyncAdapterType type, boolean removed) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(removed);
            addTaint(type.getTaint());
    if(!removed)            
            {
                scheduleSync(null, type.authority, null, 0 ,
                            false );
            } //End block
            // ---------- Original Method ----------
            //if (!removed) {
                    //scheduleSync(null, type.authority, null, 0 ,
                            //false );
                //}
        }
}, mSyncHandler);
        mSyncAlarmIntent = PendingIntent.getBroadcast(
                mContext, 0 , new Intent(ACTION_SYNC_ALARM), 0);
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(mConnectivityIntentReceiver, intentFilter);
    if(!factoryTest)        
        {
            intentFilter = new IntentFilter(Intent.ACTION_BOOT_COMPLETED);
            context.registerReceiver(mBootCompletedReceiver, intentFilter);
        } //End block
        intentFilter = new IntentFilter(ConnectivityManager.ACTION_BACKGROUND_DATA_SETTING_CHANGED);
        context.registerReceiver(mBackgroundDataSettingChanged, intentFilter);
        intentFilter = new IntentFilter(Intent.ACTION_DEVICE_STORAGE_LOW);
        intentFilter.addAction(Intent.ACTION_DEVICE_STORAGE_OK);
        context.registerReceiver(mStorageIntentReceiver, intentFilter);
        intentFilter = new IntentFilter(Intent.ACTION_SHUTDOWN);
        intentFilter.setPriority(100);
        context.registerReceiver(mShutdownIntentReceiver, intentFilter);
    if(!factoryTest)        
        {
            mNotificationMgr = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
            context.registerReceiver(new SyncAlarmIntentReceiver(),
                    new IntentFilter(ACTION_SYNC_ALARM));
        } //End block
        else
        {
            mNotificationMgr = null;
        } //End block
        mPowerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mHandleAlarmWakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                HANDLE_SYNC_ALARM_WAKE_LOCK);
        mHandleAlarmWakeLock.setReferenceCounted(false);
        mSyncManagerWakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                SYNC_LOOP_WAKE_LOCK);
        mSyncManagerWakeLock.setReferenceCounted(false);
        mSyncStorageEngine.addStatusChangeListener(
                ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS, new ISyncStatusObserver.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.846 -0400", hash_original_method = "E2E5241731BE29D01E4993B391B00B92", hash_generated_method = "3E7A864B4EA619AD9FB664764750E699")
        public void onStatusChanged(int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            sendCheckAlarmsMessage();
            // ---------- Original Method ----------
            //sendCheckAlarmsMessage();
        }
});
    if(!factoryTest)        
        {
            AccountManager.get(mContext).addOnAccountsUpdatedListener(SyncManager.this,
                mSyncHandler, false );
            onAccountsUpdated(AccountManager.get(mContext).getAccounts());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.847 -0400", hash_original_method = "F68E26CE46C5E71DC7131B4E8982A697", hash_generated_method = "3BE28E22B10A123DA00E91024363E01C")
    public void onAccountsUpdated(Account[] accounts) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final boolean justBootedUp = mAccounts == INITIAL_ACCOUNTS_ARRAY;
        mAccounts = accounts;
for(ActiveSyncContext currentSyncContext : mActiveSyncContexts)
        {
    if(!ArrayUtils.contains(accounts, currentSyncContext.mSyncOperation.account))            
            {
                Log.d(TAG, "canceling sync since the account has been removed");
                sendSyncFinishedOrCanceledMessage(currentSyncContext,
                        null );
            } //End block
        } //End block
        sendCheckAlarmsMessage();
    if(mBootCompleted)        
        {
            mSyncStorageEngine.doDatabaseCleanup(accounts);
        } //End block
    if(accounts.length > 0)        
        {
            boolean onlyThoseWithUnkownSyncableState = justBootedUp;
            scheduleSync(null, null, null, 0 , onlyThoseWithUnkownSyncableState);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.848 -0400", hash_original_method = "90A2C58DEF02026C184592212F85FF18", hash_generated_method = "464F87F0CEC8248AD4E0B7392FD9F2B9")
    private boolean readDataConnectionState() {
        NetworkInfo networkInfo = getConnectivityManager().getActiveNetworkInfo();
        boolean varD45DC317F0405F74E4F52AAD898D0500_1099528053 = ((networkInfo != null) && networkInfo.isConnected());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043372168 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043372168;
        // ---------- Original Method ----------
        //NetworkInfo networkInfo = getConnectivityManager().getActiveNetworkInfo();
        //return (networkInfo != null) && networkInfo.isConnected();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.848 -0400", hash_original_method = "85835365DA8D3F37E74A4C98C5566C52", hash_generated_method = "39D4FA4AD89FE963D3A4ACF29C575868")
    private ConnectivityManager getConnectivityManager() {
        synchronized
(this)        {
    if(mConnManagerDoNotUseDirectly == null)            
            {
                mConnManagerDoNotUseDirectly = (ConnectivityManager)mContext.getSystemService(
                        Context.CONNECTIVITY_SERVICE);
            } //End block
ConnectivityManager var5EB585CB0BDAFBBDEDEDA30BC8CAC69E_1308011096 =             mConnManagerDoNotUseDirectly;
            var5EB585CB0BDAFBBDEDEDA30BC8CAC69E_1308011096.addTaint(taint);
            return var5EB585CB0BDAFBBDEDEDA30BC8CAC69E_1308011096;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mConnManagerDoNotUseDirectly == null) {
                //mConnManagerDoNotUseDirectly = (ConnectivityManager)mContext.getSystemService(
                        //Context.CONNECTIVITY_SERVICE);
            //}
            //return mConnManagerDoNotUseDirectly;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.849 -0400", hash_original_method = "2C829A46E677D5FF63843A6B74A54E87", hash_generated_method = "38DAE73D7027FF3CFB28B96A15BDAB6D")
    private long jitterize(long minValue, long maxValue) {
        addTaint(maxValue);
        addTaint(minValue);
        Random random = new Random(SystemClock.elapsedRealtime());
        long spread = maxValue - minValue;
    if(spread > Integer.MAX_VALUE)        
        {
            IllegalArgumentException var721595686CB59DC0D7C36F00D44C7956_1787715505 = new IllegalArgumentException("the difference between the maxValue and the "
                    + "minValue must be less than " + Integer.MAX_VALUE);
            var721595686CB59DC0D7C36F00D44C7956_1787715505.addTaint(taint);
            throw var721595686CB59DC0D7C36F00D44C7956_1787715505;
        } //End block
        long var3373876A1AE63094CA60E77EE1F693F2_1222851923 = (minValue + random.nextInt((int)spread));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1363238391 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1363238391;
        // ---------- Original Method ----------
        //Random random = new Random(SystemClock.elapsedRealtime());
        //long spread = maxValue - minValue;
        //if (spread > Integer.MAX_VALUE) {
            //throw new IllegalArgumentException("the difference between the maxValue and the "
                    //+ "minValue must be less than " + Integer.MAX_VALUE);
        //}
        //return minValue + random.nextInt((int)spread);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.849 -0400", hash_original_method = "BC7A6B22ABBE0EBF148B37C3B72645F0", hash_generated_method = "CF447C117E81C511134C813569093963")
    public SyncStorageEngine getSyncStorageEngine() {
SyncStorageEngine var4722D7F414B2A192FA01BF2ECD4D9E81_1811505408 =         mSyncStorageEngine;
        var4722D7F414B2A192FA01BF2ECD4D9E81_1811505408.addTaint(taint);
        return var4722D7F414B2A192FA01BF2ECD4D9E81_1811505408;
        // ---------- Original Method ----------
        //return mSyncStorageEngine;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.850 -0400", hash_original_method = "51F169FF6EC2BB253880B74521EEDA04", hash_generated_method = "8B30EAF493130ACE802AC42E75E800F4")
    private void ensureAlarmService() {
    if(mAlarmService == null)        
        {
            mAlarmService = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
        } //End block
        // ---------- Original Method ----------
        //if (mAlarmService == null) {
            //mAlarmService = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.859 -0400", hash_original_method = "3B1126FA248635D8E240EE322F732C4B", hash_generated_method = "4E4140B807C48598F704DFA9C95EE071")
    private void initializeSyncAdapter(Account account, String authority) {
        addTaint(authority.getTaint());
        addTaint(account.getTaint());
    if(Log.isLoggable(TAG, Log.VERBOSE))        
        {
        } //End block
        SyncAdapterType syncAdapterType = SyncAdapterType.newKey(authority, account.type);
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = mSyncAdapters.getServiceInfo(syncAdapterType);
    if(syncAdapterInfo == null)        
        {
            mSyncStorageEngine.removeAuthority(account, authority);
            return;
        } //End block
        Intent intent = new Intent();
        intent.setAction("android.content.SyncAdapter");
        intent.setComponent(syncAdapterInfo.componentName);
    if(!mContext.bindService(intent,
                new InitializerServiceConnection(account, authority, mContext, mMainHandler),
                Context.BIND_AUTO_CREATE | Context.BIND_NOT_FOREGROUND
                | Context.BIND_ALLOW_OOM_MANAGEMENT))        
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.875 -0400", hash_original_method = "B73E52BAF4D022DC2D77FE197F842436", hash_generated_method = "660738C2211A74295E299922CC73B484")
    public void scheduleSync(Account requestedAccount, String requestedAuthority,
            Bundle extras, long delay, boolean onlyThoseWithUnkownSyncableState) {
        addTaint(onlyThoseWithUnkownSyncableState);
        addTaint(delay);
        addTaint(extras.getTaint());
        addTaint(requestedAuthority.getTaint());
        addTaint(requestedAccount.getTaint());
        boolean isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
        final boolean backgroundDataUsageAllowed = !mBootCompleted ||
                getConnectivityManager().getBackgroundDataSetting();
    if(extras == null)        
        extras = new Bundle();
        Boolean expedited = extras.getBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, false);
    if(expedited)        
        {
            delay = -1;
        } //End block
        Account[] accounts;
    if(requestedAccount != null)        
        {
            accounts = new Account[]{requestedAccount};
        } //End block
        else
        {
            accounts = mAccounts;
    if(accounts.length == 0)            
            {
    if(isLoggable)                
                {
                } //End block
                return;
            } //End block
        } //End block
        final boolean uploadOnly = extras.getBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, false);
        final boolean manualSync = extras.getBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, false);
    if(manualSync)        
        {
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, true);
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, true);
        } //End block
        final boolean ignoreSettings = extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, false);
        int source;
    if(uploadOnly)        
        {
            source = SyncStorageEngine.SOURCE_LOCAL;
        } //End block
        else
    if(manualSync)        
        {
            source = SyncStorageEngine.SOURCE_USER;
        } //End block
        else
    if(requestedAuthority == null)        
        {
            source = SyncStorageEngine.SOURCE_POLL;
        } //End block
        else
        {
            source = SyncStorageEngine.SOURCE_SERVER;
        } //End block
        final HashSet<String> syncableAuthorities = new HashSet<String>();
for(RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapter : mSyncAdapters.getAllServices())
        {
            syncableAuthorities.add(syncAdapter.type.authority);
        } //End block
    if(requestedAuthority != null)        
        {
            final boolean hasSyncAdapter = syncableAuthorities.contains(requestedAuthority);
            syncableAuthorities.clear();
    if(hasSyncAdapter)            
            syncableAuthorities.add(requestedAuthority);
        } //End block
        final boolean masterSyncAutomatically = mSyncStorageEngine.getMasterSyncAutomatically();
for(String authority : syncableAuthorities)
        {
for(Account account : accounts)
            {
                int isSyncable = mSyncStorageEngine.getIsSyncable(account, authority);
    if(isSyncable == 0)                
                {
                    continue;
                } //End block
                final RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = mSyncAdapters.getServiceInfo(
                                SyncAdapterType.newKey(authority, account.type));
    if(syncAdapterInfo == null)                
                {
                    continue;
                } //End block
                final boolean allowParallelSyncs = syncAdapterInfo.type.allowParallelSyncs();
                final boolean isAlwaysSyncable = syncAdapterInfo.type.isAlwaysSyncable();
    if(isSyncable < 0 && isAlwaysSyncable)                
                {
                    mSyncStorageEngine.setIsSyncable(account, authority, 1);
                    isSyncable = 1;
                } //End block
    if(onlyThoseWithUnkownSyncableState && isSyncable >= 0)                
                {
                    continue;
                } //End block
    if(!syncAdapterInfo.type.supportsUploading() && uploadOnly)                
                {
                    continue;
                } //End block
                boolean syncAllowed = (isSyncable < 0)
                        || ignoreSettings
                        || (backgroundDataUsageAllowed && masterSyncAutomatically
                            && mSyncStorageEngine.getSyncAutomatically(account, authority));
    if(!syncAllowed)                
                {
    if(isLoggable)                    
                    {
                        Log.d(TAG, "scheduleSync: sync of " + account + ", " + authority
                                + " is not allowed, dropping request");
                    } //End block
                    continue;
                } //End block
                Pair<Long, Long> backoff = mSyncStorageEngine.getBackoff(account, authority);
                long delayUntil = mSyncStorageEngine.getDelayUntilTime(account, authority);
                final long backoffTime = backoff != null ? backoff.first : 0;
    if(isSyncable < 0)                
                {
                    Bundle newExtras = new Bundle();
                    newExtras.putBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, true);
    if(isLoggable)                    
                    {
                    } //End block
                    scheduleSyncOperation(
                            new SyncOperation(account, source, authority, newExtras, 0,
                                    backoffTime, delayUntil,
                                    allowParallelSyncs));
                } //End block
    if(!onlyThoseWithUnkownSyncableState)                
                {
    if(isLoggable)                    
                    {
                    } //End block
                    scheduleSyncOperation(
                            new SyncOperation(account, source, authority, extras, delay,
                                    backoffTime, delayUntil,
                                    allowParallelSyncs));
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.879 -0400", hash_original_method = "9A217D026FB5B08090F4BAFAA08C0DF7", hash_generated_method = "E3C0172BB0C4C5886EA1EA9C6DFA16F9")
    public void scheduleLocalSync(Account account, String authority) {
        addTaint(authority.getTaint());
        addTaint(account.getTaint());
        final Bundle extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        scheduleSync(account, authority, extras, LOCAL_SYNC_DELAY,
                false );
        // ---------- Original Method ----------
        //final Bundle extras = new Bundle();
        //extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        //scheduleSync(account, authority, extras, LOCAL_SYNC_DELAY,
                //false );
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.880 -0400", hash_original_method = "0A2ACD1B7EA84D8FDEC2211873578368", hash_generated_method = "B9246D33BDA5076AE3E28C978023FFAE")
    public SyncAdapterType[] getSyncAdapterTypes() {
        final Collection<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> serviceInfos = mSyncAdapters.getAllServices();
        SyncAdapterType[] types = new SyncAdapterType[serviceInfos.size()];
        int i = 0;
for(RegisteredServicesCache.ServiceInfo<SyncAdapterType> serviceInfo : serviceInfos)
        {
            types[i] = serviceInfo.type;
            ++i;
        } //End block
SyncAdapterType[] var3594B614C10CC2B651EA0D169ACAF4A6_452387235 =         types;
        var3594B614C10CC2B651EA0D169ACAF4A6_452387235.addTaint(taint);
        return var3594B614C10CC2B651EA0D169ACAF4A6_452387235;
        // ---------- Original Method ----------
        //final Collection<RegisteredServicesCache.ServiceInfo<SyncAdapterType>>
                //serviceInfos =
                //mSyncAdapters.getAllServices();
        //SyncAdapterType[] types = new SyncAdapterType[serviceInfos.size()];
        //int i = 0;
        //for (RegisteredServicesCache.ServiceInfo<SyncAdapterType> serviceInfo : serviceInfos) {
            //types[i] = serviceInfo.type;
            //++i;
        //}
        //return types;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.881 -0400", hash_original_method = "14A3D8C2E4B2E28E7EAE9416931B0D4D", hash_generated_method = "421AE6228B516F8E828963C4D8A348A5")
    private void sendSyncAlarmMessage() {
    if(Log.isLoggable(TAG, Log.VERBOSE)){ }        mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_SYNC_ALARM);
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_SYNC_ALARM");
        //mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_SYNC_ALARM);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.881 -0400", hash_original_method = "48CD41A4FC7AAC6DBD3D417BDFF3952E", hash_generated_method = "9DE8B96D20D0A200600C79537CD20B0A")
    private void sendCheckAlarmsMessage() {
    if(Log.isLoggable(TAG, Log.VERBOSE)){ }        mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_CHECK_ALARMS);
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_CHECK_ALARMS");
        //mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_CHECK_ALARMS);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.882 -0400", hash_original_method = "A4D4C528BED9CEDB160AF5BFC279888F", hash_generated_method = "8387201C0FCFCFCB1305D94A72D834FC")
    private void sendSyncFinishedOrCanceledMessage(ActiveSyncContext syncContext,
            SyncResult syncResult) {
        addTaint(syncResult.getTaint());
        addTaint(syncContext.getTaint());
    if(Log.isLoggable(TAG, Log.VERBOSE)){ }        Message msg = mSyncHandler.obtainMessage();
        msg.what = SyncHandler.MESSAGE_SYNC_FINISHED;
        msg.obj = new SyncHandlerMessagePayload(syncContext, syncResult);
        mSyncHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_SYNC_FINISHED");
        //Message msg = mSyncHandler.obtainMessage();
        //msg.what = SyncHandler.MESSAGE_SYNC_FINISHED;
        //msg.obj = new SyncHandlerMessagePayload(syncContext, syncResult);
        //mSyncHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.883 -0400", hash_original_method = "162904FEAED4FE3BDD09493527BC709D", hash_generated_method = "1CCADD49CFACED77857DE6EC3AA0C2AB")
    private void sendCancelSyncsMessage(final Account account, final String authority) {
        addTaint(authority.getTaint());
        addTaint(account.getTaint());
    if(Log.isLoggable(TAG, Log.VERBOSE)){ }        Message msg = mSyncHandler.obtainMessage();
        msg.what = SyncHandler.MESSAGE_CANCEL;
        msg.obj = Pair.create(account, authority);
        mSyncHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_CANCEL");
        //Message msg = mSyncHandler.obtainMessage();
        //msg.what = SyncHandler.MESSAGE_CANCEL;
        //msg.obj = Pair.create(account, authority);
        //mSyncHandler.sendMessage(msg);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.885 -0400", hash_original_method = "1BD5650AC2366081E95971C40228D13F", hash_generated_method = "15EE1A4F32579AFF196F9A5F30500C6A")
    private void clearBackoffSetting(SyncOperation op) {
        addTaint(op.getTaint());
        mSyncStorageEngine.setBackoff(op.account, op.authority,
                SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
        synchronized
(mSyncQueue)        {
            mSyncQueue.onBackoffChanged(op.account, op.authority, 0);
        } //End block
        // ---------- Original Method ----------
        //mSyncStorageEngine.setBackoff(op.account, op.authority,
                //SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
        //synchronized (mSyncQueue) {
            //mSyncQueue.onBackoffChanged(op.account, op.authority, 0);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.887 -0400", hash_original_method = "42DD92B3EE29EAC346CC626BA6B5C78C", hash_generated_method = "D9EC31DF165B1A90013220079985DC1A")
    private void increaseBackoffSetting(SyncOperation op) {
        addTaint(op.getTaint());
        final long now = SystemClock.elapsedRealtime();
        final Pair<Long, Long> previousSettings = mSyncStorageEngine.getBackoff(op.account, op.authority);
        long newDelayInMs = -1;
    if(previousSettings != null)        
        {
    if(now < previousSettings.first)            
            {
    if(Log.isLoggable(TAG, Log.VERBOSE))                
                {
                } //End block
                return;
            } //End block
            newDelayInMs = previousSettings.second * 2;
        } //End block
    if(newDelayInMs <= 0)        
        {
            newDelayInMs = jitterize(INITIAL_SYNC_RETRY_TIME_IN_MS,
                    (long)(INITIAL_SYNC_RETRY_TIME_IN_MS * 1.1));
        } //End block
        long maxSyncRetryTimeInSeconds = Settings.Secure.getLong(mContext.getContentResolver(),
                Settings.Secure.SYNC_MAX_RETRY_DELAY_IN_SECONDS,
                DEFAULT_MAX_SYNC_RETRY_TIME_IN_SECONDS);
    if(newDelayInMs > maxSyncRetryTimeInSeconds * 1000)        
        {
            newDelayInMs = maxSyncRetryTimeInSeconds * 1000;
        } //End block
        final long backoff = now + newDelayInMs;
        mSyncStorageEngine.setBackoff(op.account, op.authority,
                backoff, newDelayInMs);
        op.backoff = backoff;
        op.updateEffectiveRunTime();
        synchronized
(mSyncQueue)        {
            mSyncQueue.onBackoffChanged(op.account, op.authority, backoff);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.889 -0400", hash_original_method = "D0F8BD8389FAB953FA57BE172373CE33", hash_generated_method = "D248EB52A685C6C1C6C104A4E3817DE5")
    private void setDelayUntilTime(SyncOperation op, long delayUntilSeconds) {
        addTaint(delayUntilSeconds);
        addTaint(op.getTaint());
        final long delayUntil = delayUntilSeconds * 1000;
        final long absoluteNow = System.currentTimeMillis();
        long newDelayUntilTime;
    if(delayUntil > absoluteNow)        
        {
            newDelayUntilTime = SystemClock.elapsedRealtime() + (delayUntil - absoluteNow);
        } //End block
        else
        {
            newDelayUntilTime = 0;
        } //End block
        mSyncStorageEngine.setDelayUntilTime(op.account, op.authority, newDelayUntilTime);
        synchronized
(mSyncQueue)        {
            mSyncQueue.onDelayUntilTimeChanged(op.account, op.authority, newDelayUntilTime);
        } //End block
        // ---------- Original Method ----------
        //final long delayUntil = delayUntilSeconds * 1000;
        //final long absoluteNow = System.currentTimeMillis();
        //long newDelayUntilTime;
        //if (delayUntil > absoluteNow) {
            //newDelayUntilTime = SystemClock.elapsedRealtime() + (delayUntil - absoluteNow);
        //} else {
            //newDelayUntilTime = 0;
        //}
        //mSyncStorageEngine.setDelayUntilTime(op.account, op.authority, newDelayUntilTime);
        //synchronized (mSyncQueue) {
            //mSyncQueue.onDelayUntilTimeChanged(op.account, op.authority, newDelayUntilTime);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.889 -0400", hash_original_method = "CC013A9497DA672D61638E0368F0173C", hash_generated_method = "CBC78987C8155ED6F6E4C494FAB73949")
    public void cancelActiveSync(Account account, String authority) {
        addTaint(authority.getTaint());
        addTaint(account.getTaint());
        sendCancelSyncsMessage(account, authority);
        // ---------- Original Method ----------
        //sendCancelSyncsMessage(account, authority);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.891 -0400", hash_original_method = "B18DC4486E3B23A71F43236C6D4E20D9", hash_generated_method = "DED5F55B3148070F8D2C8250052703D6")
    public void scheduleSyncOperation(SyncOperation syncOperation) {
        addTaint(syncOperation.getTaint());
        boolean queueChanged;
        synchronized
(mSyncQueue)        {
            queueChanged = mSyncQueue.add(syncOperation);
        } //End block
    if(queueChanged)        
        {
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
            sendCheckAlarmsMessage();
        } //End block
        else
        {
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //boolean queueChanged;
        //synchronized (mSyncQueue) {
            //queueChanged = mSyncQueue.add(syncOperation);
        //}
        //if (queueChanged) {
            //if (Log.isLoggable(TAG, Log.VERBOSE)) {
                //Log.v(TAG, "scheduleSyncOperation: enqueued " + syncOperation);
            //}
            //sendCheckAlarmsMessage();
        //} else {
            //if (Log.isLoggable(TAG, Log.VERBOSE)) {
                //Log.v(TAG, "scheduleSyncOperation: dropping duplicate sync operation "
                        //+ syncOperation);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.892 -0400", hash_original_method = "A2720167EE002D05FE5DA0F6211150BE", hash_generated_method = "C8AF5D57BE701B75CA206DB3129155AF")
    public void clearScheduledSyncOperations(Account account, String authority) {
        addTaint(authority.getTaint());
        addTaint(account.getTaint());
        synchronized
(mSyncQueue)        {
            mSyncQueue.remove(account, authority);
        } //End block
        mSyncStorageEngine.setBackoff(account, authority,
                SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
        // ---------- Original Method ----------
        //synchronized (mSyncQueue) {
            //mSyncQueue.remove(account, authority);
        //}
        //mSyncStorageEngine.setBackoff(account, authority,
                //SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.905 -0400", hash_original_method = "7F8B5486825DA8802A08F87FCECDEB6D", hash_generated_method = "DC0BC898D261E9AFD16190912C1E9A5F")
     void maybeRescheduleSync(SyncResult syncResult, SyncOperation operation) {
        addTaint(operation.getTaint());
        addTaint(syncResult.getTaint());
        boolean isLoggable = Log.isLoggable(TAG, Log.DEBUG);
    if(isLoggable)        
        {
            Log.d(TAG, "encountered error(s) during the sync: " + syncResult + ", " + operation);
        } //End block
        operation = new SyncOperation(operation);
    if(operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, false))        
        {
            operation.extras.remove(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF);
        } //End block
    if(operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_DO_NOT_RETRY, false))        
        {
            Log.d(TAG, "not retrying sync operation because SYNC_EXTRAS_DO_NOT_RETRY was specified "
                    + operation);
        } //End block
        else
    if(operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, false)
                && !syncResult.syncAlreadyInProgress)        
        {
            operation.extras.remove(ContentResolver.SYNC_EXTRAS_UPLOAD);
            Log.d(TAG, "retrying sync operation as a two-way sync because an upload-only sync "
                    + "encountered an error: " + operation);
            scheduleSyncOperation(operation);
        } //End block
        else
    if(syncResult.tooManyRetries)        
        {
            Log.d(TAG, "not retrying sync operation because it retried too many times: "
                    + operation);
        } //End block
        else
    if(syncResult.madeSomeProgress())        
        {
    if(isLoggable)            
            {
                Log.d(TAG, "retrying sync operation because even though it had an error "
                        + "it achieved some success");
            } //End block
            scheduleSyncOperation(operation);
        } //End block
        else
    if(syncResult.syncAlreadyInProgress)        
        {
    if(isLoggable)            
            {
                Log.d(TAG, "retrying sync operation that failed because there was already a "
                        + "sync in progress: " + operation);
            } //End block
            scheduleSyncOperation(new SyncOperation(operation.account, operation.syncSource,
                    operation.authority, operation.extras,
                    DELAY_RETRY_SYNC_IN_PROGRESS_IN_SECONDS * 1000,
                    operation.backoff, operation.delayUntil, operation.allowParallelSyncs));
        } //End block
        else
    if(syncResult.hasSoftError())        
        {
    if(isLoggable)            
            {
                Log.d(TAG, "retrying sync operation because it encountered a soft error: "
                        + operation);
            } //End block
            scheduleSyncOperation(operation);
        } //End block
        else
        {
            Log.d(TAG, "not retrying sync operation because the error is a hard error: "
                    + operation);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.907 -0400", hash_original_method = "E59AB1EB4C672AE41E3C994B41A259B0", hash_generated_method = "1B9C07A8C72B5233BAB4E3458D0ADC44")
    protected void dump(FileDescriptor fd, PrintWriter pw) {
        addTaint(pw.getTaint());
        addTaint(fd.getTaint());
        dumpSyncState(pw);
        dumpSyncHistory(pw);
        pw.println();
        pw.println("SyncAdapters:");
for(RegisteredServicesCache.ServiceInfo info : mSyncAdapters.getAllServices())
        {
            pw.println("  " + info);
        } //End block
        // ---------- Original Method ----------
        //dumpSyncState(pw);
        //dumpSyncHistory(pw);
        //pw.println();
        //pw.println("SyncAdapters:");
        //for (RegisteredServicesCache.ServiceInfo info : mSyncAdapters.getAllServices()) {
            //pw.println("  " + info);
        //}
    }

    
        @DSModeled(DSC.BAN)
    static String formatTime(long time) {
        Time tobj = new Time();
        tobj.set(time);
        return tobj.format("%Y-%m-%d %H:%M:%S");
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.915 -0400", hash_original_method = "A56698FB2481C281E3929C7135D64B8A", hash_generated_method = "51BF87661BEBA6975F937ED2303CE451")
    protected void dumpSyncState(PrintWriter pw) {
        addTaint(pw.getTaint());
        pw.print("data connected: ");
        pw.println(mDataConnectionIsConnected);
        pw.print("memory low: ");
        pw.println(mStorageIsLow);
        final Account[] accounts = mAccounts;
        pw.print("accounts: ");
    if(accounts != INITIAL_ACCOUNTS_ARRAY)        
        {
            pw.println(accounts.length);
        } //End block
        else
        {
            pw.println("not known yet");
        } //End block
        final long now = SystemClock.elapsedRealtime();
        pw.print("now: ");
        pw.print(now);
        pw.println(" (" + formatTime(System.currentTimeMillis()) + ")");
        pw.print("uptime: ");
        pw.print(DateUtils.formatElapsedTime(now/1000));
        pw.println(" (HH:MM:SS)");
        pw.print("time spent syncing: ");
        pw.print(DateUtils.formatElapsedTime(
                        mSyncHandler.mSyncTimeTracker.timeSpentSyncing() / 1000));
        pw.print(" (HH:MM:SS), sync ");
        pw.print(mSyncHandler.mSyncTimeTracker.mLastWasSyncing ? "" : "not ");
        pw.println("in progress");
    if(mSyncHandler.mAlarmScheduleTime != null)        
        {
            pw.print("next alarm time: ");
            pw.print(mSyncHandler.mAlarmScheduleTime);
            pw.print(" (");
            pw.print(DateUtils.formatElapsedTime((mSyncHandler.mAlarmScheduleTime-now)/1000));
            pw.println(" (HH:MM:SS) from now)");
        } //End block
        else
        {
            pw.println("no alarm is scheduled (there had better not be any pending syncs)");
        } //End block
        pw.print("notification info: ");
        final StringBuilder sb = new StringBuilder();
        mSyncHandler.mSyncNotificationInfo.toString(sb);
        pw.println(sb.toString());
        pw.println();
        pw.println("Active Syncs: " + mActiveSyncContexts.size());
for(SyncManager.ActiveSyncContext activeSyncContext : mActiveSyncContexts)
        {
            final long durationInSeconds = (now - activeSyncContext.mStartTime) / 1000;
            pw.print("  ");
            pw.print(DateUtils.formatElapsedTime(durationInSeconds));
            pw.print(" - ");
            pw.print(activeSyncContext.mSyncOperation.dump(false));
            pw.println();
        } //End block
        synchronized
(mSyncQueue)        {
            sb.setLength(0);
            mSyncQueue.dump(sb);
        } //End block
        pw.println();
        pw.print(sb.toString());
        pw.println();
        pw.println("Sync Status");
for(Account account : accounts)
        {
            pw.print("  Account ");
            pw.print(account.name);
            pw.print(" ");
            pw.print(account.type);
            pw.println(":");
for(RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterType : mSyncAdapters.getAllServices())
            {
    if(!syncAdapterType.type.accountType.equals(account.type))                
                {
                    continue;
                } //End block
                SyncStorageEngine.AuthorityInfo settings = mSyncStorageEngine.getOrCreateAuthority(
                        account, syncAdapterType.type.authority);
                SyncStatusInfo status = mSyncStorageEngine.getOrCreateSyncStatus(settings);
                pw.print("    ");
                pw.print(settings.authority);
                pw.println(":");
                pw.print("      settings:");
                pw.print(" " + (settings.syncable > 0
                        ? "syncable"
                        : (settings.syncable == 0 ? "not syncable" : "not initialized")));
                pw.print(", " + (settings.enabled ? "enabled" : "disabled"));
    if(settings.delayUntil > now)                
                {
                    pw.print(", delay for "
                            + ((settings.delayUntil - now) / 1000) + " sec");
                } //End block
    if(settings.backoffTime > now)                
                {
                    pw.print(", backoff for "
                            + ((settings.backoffTime - now) / 1000) + " sec");
                } //End block
    if(settings.backoffDelay > 0)                
                {
                    pw.print(", the backoff increment is " + settings.backoffDelay / 1000
                                + " sec");
                } //End block
                pw.println();
for(int periodicIndex = 0;periodicIndex < settings.periodicSyncs.size();periodicIndex++)
                {
                    Pair<Bundle, Long> info = settings.periodicSyncs.get(periodicIndex);
                    long lastPeriodicTime = status.getPeriodicSyncTime(periodicIndex);
                    long nextPeriodicTime = lastPeriodicTime + info.second * 1000;
                    pw.println("      periodic period=" + info.second
                            + ", extras=" + info.first
                            + ", next=" + formatTime(nextPeriodicTime));
                } //End block
                pw.print("      count: local=");
                pw.print(status.numSourceLocal);
                pw.print(" poll=");
                pw.print(status.numSourcePoll);
                pw.print(" periodic=");
                pw.print(status.numSourcePeriodic);
                pw.print(" server=");
                pw.print(status.numSourceServer);
                pw.print(" user=");
                pw.print(status.numSourceUser);
                pw.print(" total=");
                pw.print(status.numSyncs);
                pw.println();
                pw.print("      total duration: ");
                pw.println(DateUtils.formatElapsedTime(status.totalElapsedTime/1000));
    if(status.lastSuccessTime != 0)                
                {
                    pw.print("      SUCCESS: source=");
                    pw.print(SyncStorageEngine.SOURCES[status.lastSuccessSource]);
                    pw.print(" time=");
                    pw.println(formatTime(status.lastSuccessTime));
                } //End block
    if(status.lastFailureTime != 0)                
                {
                    pw.print("      FAILURE: source=");
                    pw.print(SyncStorageEngine.SOURCES[
                            status.lastFailureSource]);
                    pw.print(" initialTime=");
                    pw.print(formatTime(status.initialFailureTime));
                    pw.print(" lastTime=");
                    pw.println(formatTime(status.lastFailureTime));
                    int errCode = status.getLastFailureMesgAsInt(0);
                    pw.print("      message: ");
                    pw.println(
                            getLastFailureMessage(errCode) + " (" + errCode + ")");
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.921 -0400", hash_original_method = "C2F823D43F1684BB9B7871B7A13E4AFA", hash_generated_method = "F1415B9004E512585925086328F5ED32")
    private String getLastFailureMessage(int code) {
        addTaint(code);
switch(code){
        case ContentResolver.SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS:
String var0A2037351F0CF3DB1491179E6441CA17_524478127 =         "sync already in progress";
        var0A2037351F0CF3DB1491179E6441CA17_524478127.addTaint(taint);
        return var0A2037351F0CF3DB1491179E6441CA17_524478127;
        case ContentResolver.SYNC_ERROR_AUTHENTICATION:
String var8D5AA21CCE82480265E0B72C0909E7A2_1953976333 =         "authentication error";
        var8D5AA21CCE82480265E0B72C0909E7A2_1953976333.addTaint(taint);
        return var8D5AA21CCE82480265E0B72C0909E7A2_1953976333;
        case ContentResolver.SYNC_ERROR_IO:
String var5FB22909C6067E3A9ED784A0C43D285A_48487699 =         "I/O error";
        var5FB22909C6067E3A9ED784A0C43D285A_48487699.addTaint(taint);
        return var5FB22909C6067E3A9ED784A0C43D285A_48487699;
        case ContentResolver.SYNC_ERROR_PARSE:
String var1DDC8E814FAF7013914E1F666A461728_315747943 =         "parse error";
        var1DDC8E814FAF7013914E1F666A461728_315747943.addTaint(taint);
        return var1DDC8E814FAF7013914E1F666A461728_315747943;
        case ContentResolver.SYNC_ERROR_CONFLICT:
String var8C3B7A0A6F5ECA9A278672EB4771B8BC_776637742 =         "conflict error";
        var8C3B7A0A6F5ECA9A278672EB4771B8BC_776637742.addTaint(taint);
        return var8C3B7A0A6F5ECA9A278672EB4771B8BC_776637742;
        case ContentResolver.SYNC_ERROR_TOO_MANY_DELETIONS:
String var33A73AFC0E5D8E745D7A840F62059A55_375844075 =         "too many deletions error";
        var33A73AFC0E5D8E745D7A840F62059A55_375844075.addTaint(taint);
        return var33A73AFC0E5D8E745D7A840F62059A55_375844075;
        case ContentResolver.SYNC_ERROR_TOO_MANY_RETRIES:
String var28347EC0619FA4CD6E3F8E286F903AB8_1008529223 =         "too many retries error";
        var28347EC0619FA4CD6E3F8E286F903AB8_1008529223.addTaint(taint);
        return var28347EC0619FA4CD6E3F8E286F903AB8_1008529223;
        case ContentResolver.SYNC_ERROR_INTERNAL:
String var745438B88E618FD1B9C21DBD16FEE785_1347838524 =         "internal error";
        var745438B88E618FD1B9C21DBD16FEE785_1347838524.addTaint(taint);
        return var745438B88E618FD1B9C21DBD16FEE785_1347838524;
        default:
String varE4030F39D22FF867D1E81773D1A12B97_1226921855 =         "unknown";
        varE4030F39D22FF867D1E81773D1A12B97_1226921855.addTaint(taint);
        return varE4030F39D22FF867D1E81773D1A12B97_1226921855;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.922 -0400", hash_original_method = "2E5C9A0C484B8BFAAD4FF120631D1FEC", hash_generated_method = "579ADC52AD628AB270EC3096CC4BFC1F")
    private void dumpTimeSec(PrintWriter pw, long time) {
        addTaint(time);
        addTaint(pw.getTaint());
        pw.print(time/1000);
        pw.print('.');
        pw.print((time/100)%10);
        pw.print('s');
        // ---------- Original Method ----------
        //pw.print(time/1000);
        //pw.print('.');
        //pw.print((time/100)%10);
        //pw.print('s');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.925 -0400", hash_original_method = "05C5ECB94ECE9FA6501463D9FF0137FC", hash_generated_method = "AB9F56A732D72C09414858F7F7DAEFB7")
    private void dumpDayStatistic(PrintWriter pw, SyncStorageEngine.DayStats ds) {
        addTaint(ds.getTaint());
        addTaint(pw.getTaint());
        pw.print("Success (");
        pw.print(ds.successCount);
    if(ds.successCount > 0)        
        {
            pw.print(" for ");
            dumpTimeSec(pw, ds.successTime);
            pw.print(" avg=");
            dumpTimeSec(pw, ds.successTime/ds.successCount);
        } //End block
        pw.print(") Failure (");
        pw.print(ds.failureCount);
    if(ds.failureCount > 0)        
        {
            pw.print(" for ");
            dumpTimeSec(pw, ds.failureTime);
            pw.print(" avg=");
            dumpTimeSec(pw, ds.failureTime/ds.failureCount);
        } //End block
        pw.println(")");
        // ---------- Original Method ----------
        //pw.print("Success (");
        //pw.print(ds.successCount);
        //if (ds.successCount > 0) {
            //pw.print(" for "); dumpTimeSec(pw, ds.successTime);
            //pw.print(" avg="); dumpTimeSec(pw, ds.successTime/ds.successCount);
        //}
        //pw.print(") Failure (");
        //pw.print(ds.failureCount);
        //if (ds.failureCount > 0) {
            //pw.print(" for "); dumpTimeSec(pw, ds.failureTime);
            //pw.print(" avg="); dumpTimeSec(pw, ds.failureTime/ds.failureCount);
        //}
        //pw.println(")");
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.927 -0400", hash_original_method = "47B1A67BEBB64EEFEE0789183294D0B7", hash_generated_method = "45F14E0F062232678BA18CD3B38A1511")
    protected void dumpSyncHistory(PrintWriter pw) {
        addTaint(pw.getTaint());
        dumpRecentHistory(pw);
        dumpDayStatistics(pw);
        // ---------- Original Method ----------
        //dumpRecentHistory(pw);
        //dumpDayStatistics(pw);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.948 -0400", hash_original_method = "C137DBDBD7D2B9AF348453A35EDAB8EF", hash_generated_method = "286956AF157FBBD6AF3744BEE186311E")
    private void dumpRecentHistory(PrintWriter pw) {
        addTaint(pw.getTaint());
        final ArrayList<SyncStorageEngine.SyncHistoryItem> items = mSyncStorageEngine.getSyncHistory();
    if(items != null && items.size() > 0)        
        {
            final Map<String, AuthoritySyncStats> authorityMap = Maps.newHashMap();
            long totalElapsedTime = 0;
            long totalTimes = 0;
            final int N = items.size();
            int maxAuthority = 0;
            int maxAccount = 0;
for(SyncStorageEngine.SyncHistoryItem item : items)
            {
                SyncStorageEngine.AuthorityInfo authority = mSyncStorageEngine.getAuthority(item.authorityId);
                String authorityName;
                String accountKey;
    if(authority != null)                
                {
                    authorityName = authority.authority;
                    accountKey = authority.account.name + "/" + authority.account.type;
                } //End block
                else
                {
                    authorityName = "Unknown";
                    accountKey = "Unknown";
                } //End block
                int length = authorityName.length();
    if(length > maxAuthority)                
                {
                    maxAuthority = length;
                } //End block
                length = accountKey.length();
    if(length > maxAccount)                
                {
                    maxAccount = length;
                } //End block
                final long elapsedTime = item.elapsedTime;
                totalElapsedTime += elapsedTime;
                totalTimes++;
                AuthoritySyncStats authoritySyncStats = authorityMap.get(authorityName);
    if(authoritySyncStats == null)                
                {
                    authoritySyncStats = new AuthoritySyncStats(authorityName);
                    authorityMap.put(authorityName, authoritySyncStats);
                } //End block
                authoritySyncStats.elapsedTime += elapsedTime;
                authoritySyncStats.times++;
                final Map<String, AccountSyncStats> accountMap = authoritySyncStats.accountMap;
                AccountSyncStats accountSyncStats = accountMap.get(accountKey);
    if(accountSyncStats == null)                
                {
                    accountSyncStats = new AccountSyncStats(accountKey);
                    accountMap.put(accountKey, accountSyncStats);
                } //End block
                accountSyncStats.elapsedTime += elapsedTime;
                accountSyncStats.times++;
            } //End block
            pw.println();
            pw.printf("Detailed Statistics (Recent history):  %d (# of times) %ds (sync time)\n",
                    totalTimes, totalElapsedTime / 1000);
            final List<AuthoritySyncStats> sortedAuthorities = new ArrayList<AuthoritySyncStats>(authorityMap.values());
            Collections.sort(sortedAuthorities, new Comparator<AuthoritySyncStats>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.935 -0400", hash_original_method = "88424CA43B1F65943C36D332DC119ECC", hash_generated_method = "3EA28EAD1880527AF2846ED851D1FE38")
        @Override
        public int compare(AuthoritySyncStats lhs, AuthoritySyncStats rhs) {
            addTaint(rhs.getTaint());
            addTaint(lhs.getTaint());
            int compare = Integer.compare(rhs.times, lhs.times);
    if(compare == 0)            
            {
                compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
            } //End block
            int var1F83AF4E41052F8EB52DEC322580A88D_1866611962 = (compare);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193544081 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193544081;
            // ---------- Original Method ----------
            //int compare = Integer.compare(rhs.times, lhs.times);
            //if (compare == 0) {
                        //compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                    //}
            //return compare;
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
for(AuthoritySyncStats authoritySyncStats : sortedAuthorities)
            {
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
                final List<AccountSyncStats> sortedAccounts = new ArrayList<AccountSyncStats>(
                                authoritySyncStats.accountMap.values());
                Collections.sort(sortedAccounts, new Comparator<AccountSyncStats>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.939 -0400", hash_original_method = "CABE0C69E80F76B9C185615742665411", hash_generated_method = "B90A6AB6EC90238EC207EB7585FCEAA6")
        @Override
        public int compare(AccountSyncStats lhs, AccountSyncStats rhs) {
            addTaint(rhs.getTaint());
            addTaint(lhs.getTaint());
            int compare = Integer.compare(rhs.times, lhs.times);
    if(compare == 0)            
            {
                compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
            } //End block
            int var1F83AF4E41052F8EB52DEC322580A88D_1982594376 = (compare);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2072911128 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2072911128;
            // ---------- Original Method ----------
            //int compare = Integer.compare(rhs.times, lhs.times);
            //if (compare == 0) {
                            //compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                        //}
            //return compare;
        }
});
for(AccountSyncStats stats : sortedAccounts)
                {
                    elapsedTime = stats.elapsedTime;
                    times = stats.times;
                    timeStr = String.format("%ds/%d%%",
                            elapsedTime / 1000,
                            elapsedTime * 100 / totalElapsedTime);
                    timesStr = String.format("%d/%d%%",
                            times,
                            times * 100 / totalTimes);
                    pw.printf(accountFormat, stats.name, timesStr, timeStr);
                } //End block
                pw.println(separator);
            } //End block
            pw.println();
            pw.println("Recent Sync History");
            final String format = "  %-" + maxAccount + "s  %s\n";
            final Map<String, Long> lastTimeMap = Maps.newHashMap();
for(int i = 0;i < N;i++)
            {
                SyncStorageEngine.SyncHistoryItem item = items.get(i);
                SyncStorageEngine.AuthorityInfo authority = mSyncStorageEngine.getAuthority(item.authorityId);
                String authorityName;
                String accountKey;
    if(authority != null)                
                {
                    authorityName = authority.authority;
                    accountKey = authority.account.name + "/" + authority.account.type;
                } //End block
                else
                {
                    authorityName = "Unknown";
                    accountKey = "Unknown";
                } //End block
                final long elapsedTime = item.elapsedTime;
                final Time time = new Time();
                final long eventTime = item.eventTime;
                time.set(eventTime);
                final String key = authorityName + "/" + accountKey;
                final Long lastEventTime = lastTimeMap.get(key);
                String diffString;
    if(lastEventTime == null)                
                {
                    diffString = "";
                } //End block
                else
                {
                    final long diff = (lastEventTime - eventTime) / 1000;
    if(diff < 60)                    
                    {
                        diffString = String.valueOf(diff);
                    } //End block
                    else
    if(diff < 3600)                    
                    {
                        diffString = String.format("%02d:%02d", diff / 60, diff % 60);
                    } //End block
                    else
                    {
                        final long sec = diff % 3600;
                        diffString = String.format("%02d:%02d:%02d",
                                diff / 3600, sec / 60, sec % 60);
                    } //End block
                } //End block
                lastTimeMap.put(key, eventTime);
                pw.printf("  #%-3d: %s %8s  %5.1fs  %8s",
                        i + 1,
                        formatTime(eventTime),
                        SyncStorageEngine.SOURCES[item.source],
                        ((float) elapsedTime) / 1000,
                        diffString);
                pw.printf(format, accountKey, authorityName);
    if(item.event != SyncStorageEngine.EVENT_STOP
                        || item.upstreamActivity != 0
                        || item.downstreamActivity != 0)                
                {
                    pw.printf("    event=%d upstreamActivity=%d downstreamActivity=%d\n",
                            item.event,
                            item.upstreamActivity,
                            item.downstreamActivity);
                } //End block
    if(item.mesg != null
                        && !SyncStorageEngine.MESG_SUCCESS.equals(item.mesg))                
                {
                    pw.printf("    mesg=%s\n", item.mesg);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.958 -0400", hash_original_method = "9349911975C50CB78B5A389074CC1BDC", hash_generated_method = "9F4E09AA809F70E8C0CEC2D35C052C49")
    private void dumpDayStatistics(PrintWriter pw) {
        addTaint(pw.getTaint());
        SyncStorageEngine.DayStats dses[] = mSyncStorageEngine.getDayStatistics();
    if(dses != null && dses[0] != null)        
        {
            pw.println();
            pw.println("Sync Statistics");
            pw.print("  Today:  ");
            dumpDayStatistic(pw, dses[0]);
            int today = dses[0].day;
            int i;
            SyncStorageEngine.DayStats ds;
for(i=1;i<=6 && i < dses.length;i++)
            {
                ds = dses[i];
    if(ds == null)                
                break;
                int delta = today-ds.day;
    if(delta > 6)                
                break;
                pw.print("  Day-");
                pw.print(delta);
                pw.print(":  ");
                dumpDayStatistic(pw, ds);
            } //End block
            int weekDay = today;
            while
(i < dses.length)            
            {
                SyncStorageEngine.DayStats aggr = null;
                weekDay -= 7;
                while
(i < dses.length)                
                {
                    ds = dses[i];
    if(ds == null)                    
                    {
                        i = dses.length;
                        break;
                    } //End block
                    int delta = weekDay-ds.day;
    if(delta > 6)                    
                    break;
                    i++;
    if(aggr == null)                    
                    {
                        aggr = new SyncStorageEngine.DayStats(weekDay);
                    } //End block
                    aggr.successCount += ds.successCount;
                    aggr.successTime += ds.successTime;
                    aggr.failureCount += ds.failureCount;
                    aggr.failureTime += ds.failureTime;
                } //End block
    if(aggr != null)                
                {
                    pw.print("  Week-");
                    pw.print((today-weekDay)/7);
                    pw.print(": ");
                    dumpDayStatistic(pw, aggr);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.960 -0400", hash_original_method = "3A4E555675ED758A699E30DB2B6A1D6C", hash_generated_method = "77453CF67046640225B44D91BA966030")
    private boolean isSyncStillActive(ActiveSyncContext activeSyncContext) {
        addTaint(activeSyncContext.getTaint());
for(ActiveSyncContext sync : mActiveSyncContexts)
        {
    if(sync == activeSyncContext)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_370989735 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637292078 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637292078;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1106760204 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_795929143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_795929143;
        // ---------- Original Method ----------
        //for (ActiveSyncContext sync : mActiveSyncContexts) {
            //if (sync == activeSyncContext) {
                //return true;
            //}
        //}
        //return false;
    }

    
    private static class InitializerServiceConnection implements ServiceConnection {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.960 -0400", hash_original_field = "591F77A70FEF1AA3112C01B360A63E9C", hash_generated_field = "3B055C3859C53A8ACDFC59C6C8440DF8")

        private Account mAccount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.961 -0400", hash_original_field = "2325EF4ABFCA50C092A123BB59FD3F59", hash_generated_field = "5E9A5C7D075BBF710B4D594B2F64B868")

        private String mAuthority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.961 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.961 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "D774CCF7C32F86EE269A0C9F9D84415A")

        private volatile Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.961 -0400", hash_original_field = "57006E58594DC862E67D1855FDF16FEE", hash_generated_field = "C96DBD94ABC21BAB3CFD91A494AEBFFE")

        private volatile boolean mInitialized;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.963 -0400", hash_original_method = "24302E8CE101646513826470385452C3", hash_generated_method = "4EBBC72C54610FED0E83FDA081E5EF8C")
        public  InitializerServiceConnection(Account account, String authority, Context context,
                Handler handler) {
            mAccount = account;
            mAuthority = authority;
            mContext = context;
            mHandler = handler;
            mInitialized = false;
            // ---------- Original Method ----------
            //mAccount = account;
            //mAuthority = authority;
            //mContext = context;
            //mHandler = handler;
            //mInitialized = false;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.967 -0400", hash_original_method = "9C4A98A4ADBC598450E25E4EB304536B", hash_generated_method = "C850AA3CF5BEF75EFC9FEA51E239ED7F")
        public void onServiceConnected(ComponentName name, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(service.getTaint());
            addTaint(name.getTaint());
            try 
            {
    if(!mInitialized)                
                {
                    mInitialized = true;
    if(Log.isLoggable(TAG, Log.VERBOSE))                    
                    {
                    } //End block
                    ISyncAdapter.Stub.asInterface(service).initialize(mAccount, mAuthority);
                } //End block
            } //End block
            catch (RemoteException e)
            {
                Log.d(TAG, "error while initializing: " + mAccount + ", authority " + mAuthority,
                        e);
            } //End block
            finally 
            {
                mHandler.postDelayed(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.966 -0400", hash_original_method = "64817B3D0D58B18C7C47E60B6E5CD293", hash_generated_method = "54F989C074C45E656C5D046C8CB7334F")
            public void run() {
    if(mContext != null)                
                {
                    mContext.unbindService(InitializerServiceConnection.this);
                    mContext = null;
                } //End block
                // ---------- Original Method ----------
                //if (mContext != null) {
                            //mContext.unbindService(InitializerServiceConnection.this);
                            //mContext = null;
                        //}
            }
}, INITIALIZATION_UNBIND_DELAY_MS);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.970 -0400", hash_original_method = "7C8777D718751E565C82B5C1458835CE", hash_generated_method = "DE67176115DB0BAF3F94220E9EA544CE")
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(name.getTaint());
    if(mContext != null)            
            {
                mContext.unbindService(InitializerServiceConnection.this);
                mContext = null;
            } //End block
            // ---------- Original Method ----------
            //if (mContext != null) {
                //mContext.unbindService(InitializerServiceConnection.this);
                //mContext = null;
            //}
        }

        
    }


    
    class SyncHandlerMessagePayload {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.971 -0400", hash_original_field = "BF45069C4338DFDA77BE2DADD5129FF8", hash_generated_field = "A63DF1A530DF0116354A195B2D61C988")

        public ActiveSyncContext activeSyncContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.971 -0400", hash_original_field = "B59C15B72BC0053AC689D16452610B86", hash_generated_field = "1E280B614C5836CFB973E2780B056065")

        public SyncResult syncResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.972 -0400", hash_original_method = "56E2C68849F116EE41FAA5D226ECBDA3", hash_generated_method = "EB9BF74C5D5609245088D697B7671A62")
          SyncHandlerMessagePayload(ActiveSyncContext syncContext, SyncResult syncResult) {
            this.activeSyncContext = syncContext;
            this.syncResult = syncResult;
            // ---------- Original Method ----------
            //this.activeSyncContext = syncContext;
            //this.syncResult = syncResult;
        }

        
    }


    
    class SyncAlarmIntentReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.973 -0400", hash_original_method = "8972A0265D0AE4113C769D505643787E", hash_generated_method = "8972A0265D0AE4113C769D505643787E")
        public SyncAlarmIntentReceiver ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.973 -0400", hash_original_method = "B17BCAD698B90432E3978D14A6575096", hash_generated_method = "4BA0CA1A22602AB78A2E00A105623DD4")
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
            mHandleAlarmWakeLock.acquire();
            sendSyncAlarmMessage();
            // ---------- Original Method ----------
            //mHandleAlarmWakeLock.acquire();
            //sendSyncAlarmMessage();
        }

        
    }


    
    class ActiveSyncContext extends ISyncContext.Stub implements ServiceConnection, IBinder.DeathRecipient {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.974 -0400", hash_original_field = "3A845A40EB36D8DA4C1C6E7F00D65842", hash_generated_field = "CAEB8FA396F504839F82FDA41F0B6FEA")

        SyncOperation mSyncOperation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.974 -0400", hash_original_field = "FA98B28302F6B5B27D4997F9053E2A6F", hash_generated_field = "506D1AD61A010C0C1665DFBD26F66F91")

        long mHistoryRowId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.974 -0400", hash_original_field = "232767BB513340895CA27CD6CD498671", hash_generated_field = "57DE2857F3D6D189DF99142B1CBC936B")

        ISyncAdapter mSyncAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.974 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")

        long mStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.974 -0400", hash_original_field = "D3BAFEE7AF350B3FE85578E9B0C95F28", hash_generated_field = "2DA32C9B0D6927F8ADE9B98444FE7E93")

        long mTimeoutStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.974 -0400", hash_original_field = "DFE2EB06A7E314F96252E3BC41F2C2EE", hash_generated_field = "E78E5DB82E19559DD5BEFC2040680967")

        boolean mBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.974 -0400", hash_original_field = "B4284F499642B7038AEABE600507F363", hash_generated_field = "40DA6E2B4575B8523B863BAC87FE141E")

        PowerManager.WakeLock mSyncWakeLock;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.974 -0400", hash_original_field = "1A19E5DBB7DA8A675E5D447716B9C520", hash_generated_field = "2C18D3EE7F9C970AA993762D01A316E3")

        int mSyncAdapterUid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.975 -0400", hash_original_field = "B4DD88CF987D9FC7C9A0015AB85FA859", hash_generated_field = "D364355005B405C007FFCAD9043FC337")

        SyncInfo mSyncInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.975 -0400", hash_original_field = "FC2DEDF201972A37F09CA72F6C2310F6", hash_generated_field = "468C40F467A1821737E93795346B1787")

        boolean mIsLinkedToDeath = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.978 -0400", hash_original_method = "FBEF152C2B412533A606ADB2B9DA9D2A", hash_generated_method = "950920857408DB20FD03968FDF4D12D7")
        public  ActiveSyncContext(SyncOperation syncOperation, long historyRowId,
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
            // ---------- Original Method ----------
            //mSyncAdapterUid = syncAdapterUid;
            //mSyncOperation = syncOperation;
            //mHistoryRowId = historyRowId;
            //mSyncAdapter = null;
            //mStartTime = SystemClock.elapsedRealtime();
            //mTimeoutStartTime = mStartTime;
            //mSyncWakeLock = mSyncHandler.getSyncWakeLock(
                    //mSyncOperation.account, mSyncOperation.authority);
            //mSyncWakeLock.setWorkSource(new WorkSource(syncAdapterUid));
            //mSyncWakeLock.acquire();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.978 -0400", hash_original_method = "7456DA1EA096E82DD762DA299B1797D3", hash_generated_method = "540CBBFBA53CA8CE698C636F326A356D")
        public void sendHeartbeat() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.979 -0400", hash_original_method = "2741CA480AE203CDFD1BCCBB420C487D", hash_generated_method = "C36588C586056EB1D783D6F8D715E929")
        public void onFinished(SyncResult result) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(result.getTaint());
    if(Log.isLoggable(TAG, Log.VERBOSE)){ }            sendSyncFinishedOrCanceledMessage(this, result);
            // ---------- Original Method ----------
            //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "onFinished: " + this);
            //sendSyncFinishedOrCanceledMessage(this, result);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.980 -0400", hash_original_method = "EB9B131EDBEF0858B3038B79ABC0948E", hash_generated_method = "6495771F70406E5FC610209423F42C3A")
        public void toString(StringBuilder sb) {
            addTaint(sb.getTaint());
            sb.append("startTime ").append(mStartTime)
                    .append(", mTimeoutStartTime ").append(mTimeoutStartTime)
                    .append(", mHistoryRowId ").append(mHistoryRowId)
                    .append(", syncOperation ").append(mSyncOperation);
            // ---------- Original Method ----------
            //sb.append("startTime ").append(mStartTime)
                    //.append(", mTimeoutStartTime ").append(mTimeoutStartTime)
                    //.append(", mHistoryRowId ").append(mHistoryRowId)
                    //.append(", syncOperation ").append(mSyncOperation);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.982 -0400", hash_original_method = "CBDE36ABE821F23EF1CFAFB665E67134", hash_generated_method = "B79692FB3E8053894FEDF69947F9A161")
        public void onServiceConnected(ComponentName name, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(service.getTaint());
            addTaint(name.getTaint());
            Message msg = mSyncHandler.obtainMessage();
            msg.what = SyncHandler.MESSAGE_SERVICE_CONNECTED;
            msg.obj = new ServiceConnectionData(this, ISyncAdapter.Stub.asInterface(service));
            mSyncHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //Message msg = mSyncHandler.obtainMessage();
            //msg.what = SyncHandler.MESSAGE_SERVICE_CONNECTED;
            //msg.obj = new ServiceConnectionData(this, ISyncAdapter.Stub.asInterface(service));
            //mSyncHandler.sendMessage(msg);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.983 -0400", hash_original_method = "E604348BDB0F3F95B7C0274B0D40964D", hash_generated_method = "7580A9A8179317B4FE0B5D46574C004C")
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(name.getTaint());
            Message msg = mSyncHandler.obtainMessage();
            msg.what = SyncHandler.MESSAGE_SERVICE_DISCONNECTED;
            msg.obj = new ServiceConnectionData(this, null);
            mSyncHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //Message msg = mSyncHandler.obtainMessage();
            //msg.what = SyncHandler.MESSAGE_SERVICE_DISCONNECTED;
            //msg.obj = new ServiceConnectionData(this, null);
            //mSyncHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.985 -0400", hash_original_method = "79606510FDB8502633B50F75722531BD", hash_generated_method = "9F5BA3B7AA84ADAC2646476F66095499")
         boolean bindToSyncAdapter(RegisteredServicesCache.ServiceInfo info) {
            addTaint(info.getTaint());
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
                Log.d(TAG, "bindToSyncAdapter: " + info.componentName + ", connection " + this);
            } //End block
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
    if(!bindResult)            
            {
                mBound = false;
            } //End block
            boolean var34E89DB5A534F209D496EA7CBE185420_843437554 = (bindResult);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057299252 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057299252;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.987 -0400", hash_original_method = "BCACA708B6725C3BB29ED8DCC5E23FC1", hash_generated_method = "62BE8ED790CA50AF24F711C7B11E5732")
        protected void close() {
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
                Log.d(TAG, "unBindFromSyncAdapter: connection " + this);
            } //End block
    if(mBound)            
            {
                mBound = false;
                mContext.unbindService(this);
            } //End block
            mSyncWakeLock.release();
            mSyncWakeLock.setWorkSource(null);
            // ---------- Original Method ----------
            //if (Log.isLoggable(TAG, Log.VERBOSE)) {
                //Log.d(TAG, "unBindFromSyncAdapter: connection " + this);
            //}
            //if (mBound) {
                //mBound = false;
                //mContext.unbindService(this);
            //}
            //mSyncWakeLock.release();
            //mSyncWakeLock.setWorkSource(null);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.988 -0400", hash_original_method = "C99E9A460C6F28DBA730EF38203534A2", hash_generated_method = "8FF2F0C4BE9DC5A5C5D67A50C0159FDD")
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            toString(sb);
String var2460B846747F8B22185AD8BE722266A5_925905062 =             sb.toString();
            var2460B846747F8B22185AD8BE722266A5_925905062.addTaint(taint);
            return var2460B846747F8B22185AD8BE722266A5_925905062;
            // ---------- Original Method ----------
            //StringBuilder sb = new StringBuilder();
            //toString(sb);
            //return sb.toString();
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.989 -0400", hash_original_method = "A39B4ABAEA9F27E501EB3B3EC7A37B2F", hash_generated_method = "A3A778C314C37C4C18C58B6CB51701C4")
        @Override
        public void binderDied() {
            sendSyncFinishedOrCanceledMessage(this, null);
            // ---------- Original Method ----------
            //sendSyncFinishedOrCanceledMessage(this, null);
        }

        
    }


    
    private static class AuthoritySyncStats {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.989 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.989 -0400", hash_original_field = "DAD566B38C7C4C71D805927E9FFF2732", hash_generated_field = "019980784258B693231C7932844AF0BC")

        long elapsedTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.990 -0400", hash_original_field = "F2B798F672D4B42C0359CED11D4F10CD", hash_generated_field = "3A95A04ECEF69E80207E92842B01313D")

        int times;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.990 -0400", hash_original_field = "8824EC82F0C16A8A1279E45AA6570F81", hash_generated_field = "F30C35077CC725990FFE0E1D8AA05301")

        Map<String, AccountSyncStats> accountMap = Maps.newHashMap();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.990 -0400", hash_original_method = "BA2AD08D9B4BF110732C8291C5F36CF8", hash_generated_method = "8FA9C8631A53370375CA7123AE4AF077")
        private  AuthoritySyncStats(String name) {
            this.name = name;
            // ---------- Original Method ----------
            //this.name = name;
        }

        
    }


    
    private static class AccountSyncStats {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.991 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.991 -0400", hash_original_field = "DAD566B38C7C4C71D805927E9FFF2732", hash_generated_field = "019980784258B693231C7932844AF0BC")

        long elapsedTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.992 -0400", hash_original_field = "F2B798F672D4B42C0359CED11D4F10CD", hash_generated_field = "3A95A04ECEF69E80207E92842B01313D")

        int times;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.992 -0400", hash_original_method = "1D94286E4C9E35DF248CEA39D6389F91", hash_generated_method = "F1AB1770EB048E4049FC1577D48B72D8")
        private  AccountSyncStats(String name) {
            this.name = name;
            // ---------- Original Method ----------
            //this.name = name;
        }

        
    }


    
    private class SyncTimeTracker {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.993 -0400", hash_original_field = "81F2D2CA0AD2344A53D31A86CCF4832E", hash_generated_field = "462785F9BDC050A0984AB02796F85FBF")

        boolean mLastWasSyncing = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.993 -0400", hash_original_field = "C843120669F045C7E7FE9574A72CDFD6", hash_generated_field = "42BA20EF7800084DF8B05592B8E3E7BE")

        long mWhenSyncStarted = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.994 -0400", hash_original_field = "0D9C24F156A3536C5438C75FBA0A7760", hash_generated_field = "2B002605222CEDCD3A05F1765E34CF80")

        private long mTimeSpentSyncing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.994 -0400", hash_original_method = "5641FE5F8977FB94C61AEE76E9EBD2B2", hash_generated_method = "5641FE5F8977FB94C61AEE76E9EBD2B2")
        public SyncTimeTracker ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.996 -0400", hash_original_method = "3978D6C321E5167908096EFEB475874E", hash_generated_method = "C39E14B120B2709246B7685EEC2BFCFF")
        public synchronized void update() {
            final boolean isSyncInProgress = !mActiveSyncContexts.isEmpty();
    if(isSyncInProgress == mLastWasSyncing)            
            return;
            final long now = SystemClock.elapsedRealtime();
    if(isSyncInProgress)            
            {
                mWhenSyncStarted = now;
            } //End block
            else
            {
                mTimeSpentSyncing += now - mWhenSyncStarted;
            } //End block
            mLastWasSyncing = isSyncInProgress;
            // ---------- Original Method ----------
            //final boolean isSyncInProgress = !mActiveSyncContexts.isEmpty();
            //if (isSyncInProgress == mLastWasSyncing) return;
            //final long now = SystemClock.elapsedRealtime();
            //if (isSyncInProgress) {
                //mWhenSyncStarted = now;
            //} else {
                //mTimeSpentSyncing += now - mWhenSyncStarted;
            //}
            //mLastWasSyncing = isSyncInProgress;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.998 -0400", hash_original_method = "73972E33AC37B98D757DD1126931E451", hash_generated_method = "89F2280F71657BA851AA695ED0F91476")
        public synchronized long timeSpentSyncing() {
    if(!mLastWasSyncing)            
            {
            long var0D9C24F156A3536C5438C75FBA0A7760_1217850300 = (mTimeSpentSyncing);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1304478901 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1304478901;
            }
            final long now = SystemClock.elapsedRealtime();
            long var4D5C0CE1204AB61272060AABEE4A4DFF_214661025 = (mTimeSpentSyncing + (now - mWhenSyncStarted));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2069656246 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2069656246;
            // ---------- Original Method ----------
            //if (!mLastWasSyncing) return mTimeSpentSyncing;
            //final long now = SystemClock.elapsedRealtime();
            //return mTimeSpentSyncing + (now - mWhenSyncStarted);
        }

        
    }


    
    class ServiceConnectionData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.999 -0400", hash_original_field = "BF45069C4338DFDA77BE2DADD5129FF8", hash_generated_field = "A63DF1A530DF0116354A195B2D61C988")

        public ActiveSyncContext activeSyncContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.999 -0400", hash_original_field = "77C3125B03213AA40E0DE7116B3CF093", hash_generated_field = "C583279FC3521EE740A066A3F5FFA86D")

        public ISyncAdapter syncAdapter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.001 -0400", hash_original_method = "CF4E9A067E77243E4BB7B7FFBE17CC6D", hash_generated_method = "2A0BDD0F3B16155915070F3871A6CD3F")
          ServiceConnectionData(ActiveSyncContext activeSyncContext, ISyncAdapter syncAdapter) {
            this.activeSyncContext = activeSyncContext;
            this.syncAdapter = syncAdapter;
            // ---------- Original Method ----------
            //this.activeSyncContext = activeSyncContext;
            //this.syncAdapter = syncAdapter;
        }

        
    }


    
    class SyncHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.002 -0400", hash_original_field = "3EB3C1A4116A4EB53B758AE0763418BF", hash_generated_field = "1599D96A237A164A880FFE88C1C3EE7C")

        public final SyncNotificationInfo mSyncNotificationInfo = new SyncNotificationInfo();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.002 -0400", hash_original_field = "F4AC20FF2B0D9B9001095C466DD1B77E", hash_generated_field = "0C75AEF43A0C9FFA242F4986360329AE")

        private Long mAlarmScheduleTime = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.002 -0400", hash_original_field = "D303E2362A0CCEFF2175ABCFFA7F631D", hash_generated_field = "D1BE6D0FAF2F6FBF2B9D20FDC62CD03D")

        public final SyncTimeTracker mSyncTimeTracker = new SyncTimeTracker();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.003 -0400", hash_original_field = "AAD4F16B34370A021E0CB4C912ACE611", hash_generated_field = "2F89F9D45AD779522DB295A0D1595A30")

        private final HashMap<Pair<Account, String>, PowerManager.WakeLock> mWakeLocks = Maps.newHashMap();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.003 -0400", hash_original_field = "DDAD6CB2080EECA658633769B438411A", hash_generated_field = "28D2205C6B63956ABF9398C7BB3353C2")

        private volatile CountDownLatch mReadyToRunLatch = new CountDownLatch(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.003 -0400", hash_original_method = "483F6356A2D06E95B4EBFBB05049FAB5", hash_generated_method = "2554A8ECD9A719B3BF2C53204C68C88D")
        public  SyncHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.004 -0400", hash_original_method = "A4C54FCCA01900F2BC7EC8A1E7F40380", hash_generated_method = "892BCA4CA52D79FA5ACC24C88B5BF220")
        public void onBootCompleted() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mBootCompleted = true;
            mSyncStorageEngine.doDatabaseCleanup(AccountManager.get(mContext).getAccounts());
    if(mReadyToRunLatch != null)            
            {
                mReadyToRunLatch.countDown();
            } //End block
            // ---------- Original Method ----------
            //mBootCompleted = true;
            //mSyncStorageEngine.doDatabaseCleanup(AccountManager.get(mContext).getAccounts());
            //if (mReadyToRunLatch != null) {
                //mReadyToRunLatch.countDown();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.005 -0400", hash_original_method = "F60450395CB7370B81745EFD5F3059FF", hash_generated_method = "8B8D808F2A0B236995CE5B2E530480BC")
        private PowerManager.WakeLock getSyncWakeLock(Account account, String authority) {
            addTaint(authority.getTaint());
            addTaint(account.getTaint());
            final Pair<Account, String> wakeLockKey = Pair.create(account, authority);
            PowerManager.WakeLock wakeLock = mWakeLocks.get(wakeLockKey);
    if(wakeLock == null)            
            {
                final String name = SYNC_WAKE_LOCK_PREFIX + "_" + authority + "_" + account;
                wakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, name);
                wakeLock.setReferenceCounted(false);
                mWakeLocks.put(wakeLockKey, wakeLock);
            } //End block
PowerManager.WakeLock var8F15A8B728F6BF9E50EE9B41DDD67A81_412578093 =             wakeLock;
            var8F15A8B728F6BF9E50EE9B41DDD67A81_412578093.addTaint(taint);
            return var8F15A8B728F6BF9E50EE9B41DDD67A81_412578093;
            // ---------- Original Method ----------
            //final Pair<Account, String> wakeLockKey = Pair.create(account, authority);
            //PowerManager.WakeLock wakeLock = mWakeLocks.get(wakeLockKey);
            //if (wakeLock == null) {
                //final String name = SYNC_WAKE_LOCK_PREFIX + "_" + authority + "_" + account;
                //wakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, name);
                //wakeLock.setReferenceCounted(false);
                //mWakeLocks.put(wakeLockKey, wakeLock);
            //}
            //return wakeLock;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.006 -0400", hash_original_method = "CE8AE663CA89CC7DD7AABF796BC60E1D", hash_generated_method = "B00436E1B8463D1E6931745E40AFDDD4")
        private void waitUntilReadyToRun() {
            CountDownLatch latch = mReadyToRunLatch;
    if(latch != null)            
            {
                while
(true)                
                {
                    try 
                    {
                        latch.await();
                        mReadyToRunLatch = null;
                        return;
                    } //End block
                    catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //CountDownLatch latch = mReadyToRunLatch;
            //if (latch != null) {
                //while (true) {
                    //try {
                        //latch.await();
                        //mReadyToRunLatch = null;
                        //return;
                    //} catch (InterruptedException e) {
                        //Thread.currentThread().interrupt();
                    //}
                //}
            //}
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.010 -0400", hash_original_method = "AC98BBE28F5005D2D34EEDF919BF395C", hash_generated_method = "8340B6E3036932FA9B81E296C283CF83")
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            long earliestFuturePollTime = Long.MAX_VALUE;
            long nextPendingSyncTime = Long.MAX_VALUE;
            try 
            {
                waitUntilReadyToRun();
                mDataConnectionIsConnected = readDataConnectionState();
                mSyncManagerWakeLock.acquire();
                earliestFuturePollTime = scheduleReadyPeriodicSyncs();
switch(msg.what){
                case SyncHandler.MESSAGE_CANCEL:
                {
                    Pair<Account, String> payload = (Pair<Account, String>)msg.obj;
    if(Log.isLoggable(TAG, Log.VERBOSE))                    
                    {
                        Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_CANCEL: "
                                    + payload.first + ", " + payload.second);
                    } //End block
                    cancelActiveSyncLocked(payload.first, payload.second);
                    nextPendingSyncTime = maybeStartNextSyncLocked();
                    break;
                } //End block
                case SyncHandler.MESSAGE_SYNC_FINISHED:
    if(Log.isLoggable(TAG, Log.VERBOSE))                
                {
                } //End block
                SyncHandlerMessagePayload payload = (SyncHandlerMessagePayload)msg.obj;
    if(!isSyncStillActive(payload.activeSyncContext))                
                {
                    Log.d(TAG, "handleSyncHandlerMessage: dropping since the "
                                    + "sync is no longer active: "
                                    + payload.activeSyncContext);
                    break;
                } //End block
                runSyncFinishedOrCanceledLocked(payload.syncResult, payload.activeSyncContext);
                nextPendingSyncTime = maybeStartNextSyncLocked();
                break;
                case SyncHandler.MESSAGE_SERVICE_CONNECTED:
                {
                    ServiceConnectionData msgData = (ServiceConnectionData)msg.obj;
    if(Log.isLoggable(TAG, Log.VERBOSE))                    
                    {
                        Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_CONNECTED: "
                                    + msgData.activeSyncContext);
                    } //End block
    if(isSyncStillActive(msgData.activeSyncContext))                    
                    {
                        runBoundToSyncAdapter(msgData.activeSyncContext, msgData.syncAdapter);
                    } //End block
                    break;
                } //End block
                case SyncHandler.MESSAGE_SERVICE_DISCONNECTED:
                {
                    final ActiveSyncContext currentSyncContext = ((ServiceConnectionData)msg.obj).activeSyncContext;
    if(Log.isLoggable(TAG, Log.VERBOSE))                    
                    {
                        Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_DISCONNECTED: "
                                    + currentSyncContext);
                    } //End block
    if(isSyncStillActive(currentSyncContext))                    
                    {
    if(currentSyncContext.mSyncAdapter != null)                        
                        {
                            try 
                            {
                                currentSyncContext.mSyncAdapter.cancelSync(currentSyncContext);
                            } //End block
                            catch (RemoteException e)
                            {
                            } //End block
                        } //End block
                        SyncResult syncResult = new SyncResult();
                        syncResult.stats.numIoExceptions++;
                        runSyncFinishedOrCanceledLocked(syncResult, currentSyncContext);
                        nextPendingSyncTime = maybeStartNextSyncLocked();
                    } //End block
                    break;
                } //End block
                case SyncHandler.MESSAGE_SYNC_ALARM:
                {
                    boolean isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
    if(isLoggable)                    
                    {
                    } //End block
                    mAlarmScheduleTime = null;
                    try 
                    {
                        nextPendingSyncTime = maybeStartNextSyncLocked();
                    } //End block
                    finally 
                    {
                        mHandleAlarmWakeLock.release();
                    } //End block
                    break;
                } //End block
                case SyncHandler.MESSAGE_CHECK_ALARMS:
    if(Log.isLoggable(TAG, Log.VERBOSE))                
                {
                } //End block
                nextPendingSyncTime = maybeStartNextSyncLocked();
                break;
}
            } //End block
            finally 
            {
                manageSyncNotificationLocked();
                manageSyncAlarmLocked(earliestFuturePollTime, nextPendingSyncTime);
                mSyncTimeTracker.update();
                mSyncManagerWakeLock.release();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.012 -0400", hash_original_method = "5F18B995A8D5126079C876CBB8B37FF8", hash_generated_method = "75253C06ABF6D8783B1F66165EA740E8")
        private long scheduleReadyPeriodicSyncs() {
            final boolean backgroundDataUsageAllowed = getConnectivityManager().getBackgroundDataSetting();
            long earliestFuturePollTime = Long.MAX_VALUE;
    if(!backgroundDataUsageAllowed || !mSyncStorageEngine.getMasterSyncAutomatically())            
            {
                long var019D68894FAACD3AA4E1F874C2180DC4_1567361973 = (earliestFuturePollTime);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_279754348 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_279754348;
            } //End block
            final long nowAbsolute = System.currentTimeMillis();
            ArrayList<SyncStorageEngine.AuthorityInfo> infos = mSyncStorageEngine.getAuthorities();
for(SyncStorageEngine.AuthorityInfo info : infos)
            {
    if(!ArrayUtils.contains(mAccounts, info.account))                
                {
                    continue;
                } //End block
    if(!mSyncStorageEngine.getSyncAutomatically(info.account, info.authority))                
                {
                    continue;
                } //End block
    if(mSyncStorageEngine.getIsSyncable(info.account, info.authority) == 0)                
                {
                    continue;
                } //End block
                SyncStatusInfo status = mSyncStorageEngine.getOrCreateSyncStatus(info);
for(int i = 0, N = info.periodicSyncs.size();i < N;i++)
                {
                    final Bundle extras = info.periodicSyncs.get(i).first;
                    final Long periodInSeconds = info.periodicSyncs.get(i).second;
                    final long lastPollTimeAbsolute = status.getPeriodicSyncTime(i);
                    final long nextPollTimeAbsolute = lastPollTimeAbsolute > nowAbsolute
                            ? nowAbsolute
                            : lastPollTimeAbsolute + periodInSeconds * 1000;
    if(nextPollTimeAbsolute <= nowAbsolute)                    
                    {
                        final Pair<Long, Long> backoff = mSyncStorageEngine.getBackoff(info.account, info.authority);
                        final RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = mSyncAdapters.getServiceInfo(
                                        SyncAdapterType.newKey(info.authority, info.account.type));
    if(syncAdapterInfo == null)                        
                        {
                            continue;
                        } //End block
                        scheduleSyncOperation(
                                new SyncOperation(info.account, SyncStorageEngine.SOURCE_PERIODIC,
                                        info.authority, extras, 0 ,
                                        backoff != null ? backoff.first : 0,
                                        mSyncStorageEngine.getDelayUntilTime(
                                                info.account, info.authority),
                                        syncAdapterInfo.type.allowParallelSyncs()));
                        status.setPeriodicSyncTime(i, nowAbsolute);
                    } //End block
                    else
                    {
    if(nextPollTimeAbsolute < earliestFuturePollTime)                        
                        {
                            earliestFuturePollTime = nextPollTimeAbsolute;
                        } //End block
                    } //End block
                } //End block
            } //End block
    if(earliestFuturePollTime == Long.MAX_VALUE)            
            {
                long var85712C72209F40438E81734FCEEB0717_411189056 = (Long.MAX_VALUE);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1937274346 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1937274346;
            } //End block
            long var3990E5944773918E9B81E6A676387A49_1565053845 = (SystemClock.elapsedRealtime()
                    + ((earliestFuturePollTime < nowAbsolute)
                      ? 0
                      : (earliestFuturePollTime - nowAbsolute)));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1450317448 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1450317448;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.017 -0400", hash_original_method = "8B5418D48FBDFB608CDA80C6788E1356", hash_generated_method = "D73E9DD496093F392EDBA5E3A7D9FCFF")
        private long maybeStartNextSyncLocked() {
            final boolean isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
    if(isLoggable){ }    if(!mDataConnectionIsConnected)            
            {
    if(isLoggable)                
                {
                } //End block
                long var85712C72209F40438E81734FCEEB0717_1908007540 = (Long.MAX_VALUE);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1501886602 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1501886602;
            } //End block
    if(mStorageIsLow)            
            {
    if(isLoggable)                
                {
                } //End block
                long var85712C72209F40438E81734FCEEB0717_2102615153 = (Long.MAX_VALUE);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_948686342 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_948686342;
            } //End block
            Account[] accounts = mAccounts;
    if(accounts == INITIAL_ACCOUNTS_ARRAY)            
            {
    if(isLoggable)                
                {
                } //End block
                long var85712C72209F40438E81734FCEEB0717_254643008 = (Long.MAX_VALUE);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1044426604 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1044426604;
            } //End block
            final boolean backgroundDataUsageAllowed = getConnectivityManager().getBackgroundDataSetting();
            final boolean masterSyncAutomatically = mSyncStorageEngine.getMasterSyncAutomatically();
            final long now = SystemClock.elapsedRealtime();
            long nextReadyToRunTime = Long.MAX_VALUE;
            ArrayList<SyncOperation> operations = new ArrayList<SyncOperation>();
            synchronized
(mSyncQueue)            {
    if(isLoggable)                
                {
                } //End block
                Iterator<SyncOperation> operationIterator = mSyncQueue.mOperationsMap.values().iterator();
                while
(operationIterator.hasNext())                
                {
                    final SyncOperation op = operationIterator.next();
    if(!ArrayUtils.contains(mAccounts, op.account))                    
                    {
                        operationIterator.remove();
                        mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                        continue;
                    } //End block
                    int syncableState = mSyncStorageEngine.getIsSyncable(op.account, op.authority);
    if(syncableState == 0)                    
                    {
                        operationIterator.remove();
                        mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                        continue;
                    } //End block
    if(op.effectiveRunTime > now)                    
                    {
    if(nextReadyToRunTime > op.effectiveRunTime)                        
                        {
                            nextReadyToRunTime = op.effectiveRunTime;
                        } //End block
                        continue;
                    } //End block
                    RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo;
                    syncAdapterInfo = mSyncAdapters.getServiceInfo(
                            SyncAdapterType.newKey(op.authority, op.account.type));
                    boolean uidNetworkConnected;
    if(syncAdapterInfo != null)                    
                    {
                        final NetworkInfo networkInfo = getConnectivityManager()
                                .getActiveNetworkInfoForUid(syncAdapterInfo.uid);
                        uidNetworkConnected = networkInfo != null && networkInfo.isConnected();
                    } //End block
                    else
                    {
                        uidNetworkConnected = false;
                    } //End block
    if(!op.extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, false)
                            && (syncableState > 0)
                            && (!masterSyncAutomatically
                                || !backgroundDataUsageAllowed
                                || !uidNetworkConnected
                                || !mSyncStorageEngine.getSyncAutomatically(
                                       op.account, op.authority)))                    
                    {
                        operationIterator.remove();
                        mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                        continue;
                    } //End block
                    operations.add(op);
                } //End block
            } //End block
    if(isLoggable){ }            Collections.sort(operations);
    if(isLoggable){ }for(int i = 0, N = operations.size();i < N;i++)
            {
                final SyncOperation candidate = operations.get(i);
                final boolean candidateIsInitialization = candidate.isInitialization();
                int numInit = 0;
                int numRegular = 0;
                ActiveSyncContext conflict = null;
                ActiveSyncContext longRunning = null;
                ActiveSyncContext toReschedule = null;
for(ActiveSyncContext activeSyncContext : mActiveSyncContexts)
                {
                    final SyncOperation activeOp = activeSyncContext.mSyncOperation;
    if(activeOp.isInitialization())                    
                    {
                        numInit++;
                    } //End block
                    else
                    {
                        numRegular++;
                    } //End block
    if(activeOp.account.type.equals(candidate.account.type)
                            && activeOp.authority.equals(candidate.authority)
                            && (!activeOp.allowParallelSyncs
                                || activeOp.account.name.equals(candidate.account.name)))                    
                    {
                        conflict = activeSyncContext;
                    } //End block
                    else
                    {
    if(candidateIsInitialization == activeOp.isInitialization()
                                && activeSyncContext.mStartTime + MAX_TIME_PER_SYNC < now)                        
                        {
                            longRunning = activeSyncContext;
                        } //End block
                    } //End block
                } //End block
    if(isLoggable)                
                {
                } //End block
    if(conflict != null)                
                {
    if(candidateIsInitialization && !conflict.mSyncOperation.isInitialization()
                            && numInit < MAX_SIMULTANEOUS_INITIALIZATION_SYNCS)                    
                    {
                        toReschedule = conflict;
    if(Log.isLoggable(TAG, Log.VERBOSE))                        
                        {
                        } //End block
                    } //End block
                    else
    if(candidate.expedited && !conflict.mSyncOperation.expedited
                            && (candidateIsInitialization
                                == conflict.mSyncOperation.isInitialization()))                    
                    {
                        toReschedule = conflict;
    if(Log.isLoggable(TAG, Log.VERBOSE))                        
                        {
                        } //End block
                    } //End block
                    else
                    {
                        continue;
                    } //End block
                } //End block
                else
                {
                    final boolean roomAvailable = candidateIsInitialization
                            ? numInit < MAX_SIMULTANEOUS_INITIALIZATION_SYNCS
                            : numRegular < MAX_SIMULTANEOUS_REGULAR_SYNCS;
    if(roomAvailable)                    
                    {
                    } //End block
                    else
    if(longRunning != null
                            && (candidateIsInitialization
                                == longRunning.mSyncOperation.isInitialization()))                    
                    {
                        toReschedule = longRunning;
    if(Log.isLoggable(TAG, Log.VERBOSE))                        
                        {
                        } //End block
                    } //End block
                    else
                    {
                        continue;
                    } //End block
                } //End block
    if(toReschedule != null)                
                {
                    runSyncFinishedOrCanceledLocked(null, toReschedule);
                    scheduleSyncOperation(toReschedule.mSyncOperation);
                } //End block
                synchronized
(mSyncQueue)                {
                    mSyncQueue.remove(candidate);
                } //End block
                dispatchSyncOperation(candidate);
            } //End block
            long var42FE83D8484C0E21802DF28253B7746E_885021591 = (nextReadyToRunTime);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2096397635 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2096397635;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.022 -0400", hash_original_method = "40340E62514BC19DB7E9216642814F86", hash_generated_method = "F90ABC9288889CBC15484703E97C91B2")
        private boolean dispatchSyncOperation(SyncOperation op) {
            addTaint(op.getTaint());
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
for(ActiveSyncContext syncContext : mActiveSyncContexts)
                {
                } //End block
            } //End block
            SyncAdapterType syncAdapterType = SyncAdapterType.newKey(op.authority, op.account.type);
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = mSyncAdapters.getServiceInfo(syncAdapterType);
    if(syncAdapterInfo == null)            
            {
                Log.d(TAG, "can't find a sync adapter for " + syncAdapterType
                        + ", removing settings for it");
                mSyncStorageEngine.removeAuthority(op.account, op.authority);
                boolean var68934A3E9455FA72420237EB05902327_1967042390 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121920138 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_121920138;
            } //End block
            ActiveSyncContext activeSyncContext = new ActiveSyncContext(op, insertStartSyncEvent(op), syncAdapterInfo.uid);
            activeSyncContext.mSyncInfo = mSyncStorageEngine.addActiveSync(activeSyncContext);
            mActiveSyncContexts.add(activeSyncContext);
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
    if(!activeSyncContext.bindToSyncAdapter(syncAdapterInfo))            
            {
                closeActiveSyncContext(activeSyncContext);
                boolean var68934A3E9455FA72420237EB05902327_1425621801 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354497792 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354497792;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_2040474435 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345597579 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_345597579;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.025 -0400", hash_original_method = "61AEAAC860377C6ACC1D13743DAD80A2", hash_generated_method = "43A919F29A8BE8607C5EC65FEB8A7F6F")
        private void runBoundToSyncAdapter(final ActiveSyncContext activeSyncContext,
              ISyncAdapter syncAdapter) {
            addTaint(syncAdapter.getTaint());
            addTaint(activeSyncContext.getTaint());
            activeSyncContext.mSyncAdapter = syncAdapter;
            final SyncOperation syncOperation = activeSyncContext.mSyncOperation;
            try 
            {
                activeSyncContext.mIsLinkedToDeath = true;
                syncAdapter.asBinder().linkToDeath(activeSyncContext, 0);
                syncAdapter.startSync(activeSyncContext, syncOperation.authority,
                        syncOperation.account, syncOperation.extras);
            } //End block
            catch (RemoteException remoteExc)
            {
                Log.d(TAG, "maybeStartNextSync: caught a RemoteException, rescheduling", remoteExc);
                closeActiveSyncContext(activeSyncContext);
                increaseBackoffSetting(syncOperation);
                scheduleSyncOperation(new SyncOperation(syncOperation));
            } //End block
            catch (RuntimeException exc)
            {
                closeActiveSyncContext(activeSyncContext);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.025 -0400", hash_original_method = "7B28CEC882EFEBA05BFBBAFD319121EA", hash_generated_method = "4E353D2AA2F9E6C87A93A71D1E1AB750")
        private void cancelActiveSyncLocked(Account account, String authority) {
            addTaint(authority.getTaint());
            addTaint(account.getTaint());
            ArrayList<ActiveSyncContext> activeSyncs = new ArrayList<ActiveSyncContext>(mActiveSyncContexts);
for(ActiveSyncContext activeSyncContext : activeSyncs)
            {
    if(activeSyncContext != null)                
                {
    if(account != null)                    
                    {
    if(!account.equals(activeSyncContext.mSyncOperation.account))                        
                        {
                            return;
                        } //End block
                    } //End block
    if(authority != null)                    
                    {
    if(!authority.equals(activeSyncContext.mSyncOperation.authority))                        
                        {
                            return;
                        } //End block
                    } //End block
                    runSyncFinishedOrCanceledLocked(null ,
                            activeSyncContext);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.035 -0400", hash_original_method = "8D8637124BC010FEF841826099E3536E", hash_generated_method = "88C9DEACC2D068C2CE79D61B21A48FC9")
        private void runSyncFinishedOrCanceledLocked(SyncResult syncResult,
                ActiveSyncContext activeSyncContext) {
            addTaint(activeSyncContext.getTaint());
            addTaint(syncResult.getTaint());
            boolean isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
    if(activeSyncContext.mIsLinkedToDeath)            
            {
                activeSyncContext.mSyncAdapter.asBinder().unlinkToDeath(activeSyncContext, 0);
                activeSyncContext.mIsLinkedToDeath = false;
            } //End block
            closeActiveSyncContext(activeSyncContext);
            final SyncOperation syncOperation = activeSyncContext.mSyncOperation;
            final long elapsedTime = SystemClock.elapsedRealtime() - activeSyncContext.mStartTime;
            String historyMessage;
            int downstreamActivity;
            int upstreamActivity;
    if(syncResult != null)            
            {
    if(isLoggable)                
                {
                } //End block
    if(!syncResult.hasError())                
                {
                    historyMessage = SyncStorageEngine.MESG_SUCCESS;
                    downstreamActivity = 0;
                    upstreamActivity = 0;
                    clearBackoffSetting(syncOperation);
                } //End block
                else
                {
                    Log.d(TAG, "failed sync operation " + syncOperation + ", " + syncResult);
    if(!syncResult.syncAlreadyInProgress)                    
                    {
                        increaseBackoffSetting(syncOperation);
                    } //End block
                    maybeRescheduleSync(syncResult, syncOperation);
                    historyMessage = Integer.toString(syncResultToErrorNumber(syncResult));
                    downstreamActivity = 0;
                    upstreamActivity = 0;
                } //End block
                setDelayUntilTime(syncOperation, syncResult.delayUntil);
            } //End block
            else
            {
    if(isLoggable)                
                {
                } //End block
    if(activeSyncContext.mSyncAdapter != null)                
                {
                    try 
                    {
                        activeSyncContext.mSyncAdapter.cancelSync(activeSyncContext);
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                } //End block
                historyMessage = SyncStorageEngine.MESG_CANCELED;
                downstreamActivity = 0;
                upstreamActivity = 0;
            } //End block
            stopSyncEvent(activeSyncContext.mHistoryRowId, syncOperation, historyMessage,
                    upstreamActivity, downstreamActivity, elapsedTime);
    if(syncResult != null && syncResult.tooManyDeletions)            
            {
                installHandleTooManyDeletesNotification(syncOperation.account,
                        syncOperation.authority, syncResult.stats.numDeletes);
            } //End block
            else
            {
                mNotificationMgr.cancel(
                        syncOperation.account.hashCode() ^ syncOperation.authority.hashCode());
            } //End block
    if(syncResult != null && syncResult.fullSyncRequested)            
            {
                scheduleSyncOperation(new SyncOperation(syncOperation.account,
                        syncOperation.syncSource, syncOperation.authority, new Bundle(), 0,
                        syncOperation.backoff, syncOperation.delayUntil,
                        syncOperation.allowParallelSyncs));
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.036 -0400", hash_original_method = "1880B76D7799B7E884F5DD7B88555973", hash_generated_method = "F3F94E00990B014C60A0FF215FF64071")
        private void closeActiveSyncContext(ActiveSyncContext activeSyncContext) {
            addTaint(activeSyncContext.getTaint());
            activeSyncContext.close();
            mActiveSyncContexts.remove(activeSyncContext);
            mSyncStorageEngine.removeActiveSync(activeSyncContext.mSyncInfo);
            // ---------- Original Method ----------
            //activeSyncContext.close();
            //mActiveSyncContexts.remove(activeSyncContext);
            //mSyncStorageEngine.removeActiveSync(activeSyncContext.mSyncInfo);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.038 -0400", hash_original_method = "F73ADCF1F7F7E573F488FB12A7E0DEC9", hash_generated_method = "5D933CFC03F432CD6EB0BFB742CAC200")
        private int syncResultToErrorNumber(SyncResult syncResult) {
            addTaint(syncResult.getTaint());
    if(syncResult.syncAlreadyInProgress)            
            {
            int var186E822CA3306298D3DE1344599D3464_764489244 = (ContentResolver.SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636047970 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636047970;
            }
    if(syncResult.stats.numAuthExceptions > 0)            
            {
            int varF3C25CFED434773E9664FDA5586C5EF5_46726592 = (ContentResolver.SYNC_ERROR_AUTHENTICATION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643626953 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643626953;
            }
    if(syncResult.stats.numIoExceptions > 0)            
            {
            int var1641BE2E8A4059B7DAD0533CE75C4088_1075152495 = (ContentResolver.SYNC_ERROR_IO);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41180783 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41180783;
            }
    if(syncResult.stats.numParseExceptions > 0)            
            {
            int var6221F67759F61C034B758F2992476D20_576109112 = (ContentResolver.SYNC_ERROR_PARSE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602052487 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602052487;
            }
    if(syncResult.stats.numConflictDetectedExceptions > 0)            
            {
            int var78A1AE603B971BD3B64A74878D547A14_1142212416 = (ContentResolver.SYNC_ERROR_CONFLICT);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17954798 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17954798;
            }
    if(syncResult.tooManyDeletions)            
            {
            int varE8B1661B09B93F8BBA8F56C7EB13380C_1314619114 = (ContentResolver.SYNC_ERROR_TOO_MANY_DELETIONS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778122478 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778122478;
            }
    if(syncResult.tooManyRetries)            
            {
            int varD6E083088E9899A9DD0ABAA9D69EBF6C_1081484360 = (ContentResolver.SYNC_ERROR_TOO_MANY_RETRIES);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350601957 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350601957;
            }
    if(syncResult.databaseError)            
            {
            int var525F52066FEFC4EBDE0E69D7DD39BC02_1043223200 = (ContentResolver.SYNC_ERROR_INTERNAL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504123359 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504123359;
            }
            IllegalStateException var6E803C17322F490BE50850547CF24484_632019113 = new IllegalStateException("we are not in an error state, " + syncResult);
            var6E803C17322F490BE50850547CF24484_632019113.addTaint(taint);
            throw var6E803C17322F490BE50850547CF24484_632019113;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.042 -0400", hash_original_method = "D7164ED4506DE94304BF76B0FBC03583", hash_generated_method = "DA29C4122ADB310FE8E3B7950981D617")
        private void manageSyncNotificationLocked() {
            boolean shouldCancel;
            boolean shouldInstall;
    if(mActiveSyncContexts.isEmpty())            
            {
                mSyncNotificationInfo.startTime = null;
                shouldCancel = mSyncNotificationInfo.isActive;
                shouldInstall = false;
            } //End block
            else
            {
                final long now = SystemClock.elapsedRealtime();
    if(mSyncNotificationInfo.startTime == null)                
                {
                    mSyncNotificationInfo.startTime = now;
                } //End block
    if(mSyncNotificationInfo.isActive)                
                {
                    shouldInstall = shouldCancel = false;
                } //End block
                else
                {
                    shouldCancel = false;
                    final boolean timeToShowNotification = now > mSyncNotificationInfo.startTime + SYNC_NOTIFICATION_DELAY;
    if(timeToShowNotification)                    
                    {
                        shouldInstall = true;
                    } //End block
                    else
                    {
                        shouldInstall = false;
for(ActiveSyncContext activeSyncContext : mActiveSyncContexts)
                        {
                            final boolean manualSync = activeSyncContext.mSyncOperation.extras
                                    .getBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, false);
    if(manualSync)                            
                            {
                                shouldInstall = true;
                                break;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
    if(shouldCancel && !shouldInstall)            
            {
                mNeedSyncActiveNotification = false;
                sendSyncStateIntent();
                mSyncNotificationInfo.isActive = false;
            } //End block
    if(shouldInstall)            
            {
                mNeedSyncActiveNotification = true;
                sendSyncStateIntent();
                mSyncNotificationInfo.isActive = true;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.049 -0400", hash_original_method = "E1B88EC7C887370D571018E17194D40D", hash_generated_method = "5E60D19BCC30D3FEE02BC0E27A6F0E8D")
        private void manageSyncAlarmLocked(long nextPeriodicEventElapsedTime,
                long nextPendingEventElapsedTime) {
            addTaint(nextPendingEventElapsedTime);
            addTaint(nextPeriodicEventElapsedTime);
    if(!mDataConnectionIsConnected)            
            return;
    if(mStorageIsLow)            
            return;
            final long notificationTime = (!mSyncHandler.mSyncNotificationInfo.isActive
                            && mSyncHandler.mSyncNotificationInfo.startTime != null)
                            ? mSyncHandler.mSyncNotificationInfo.startTime + SYNC_NOTIFICATION_DELAY
                            : Long.MAX_VALUE;
            long earliestTimeoutTime = Long.MAX_VALUE;
for(ActiveSyncContext currentSyncContext : mActiveSyncContexts)
            {
                final long currentSyncTimeoutTime = currentSyncContext.mTimeoutStartTime + MAX_TIME_PER_SYNC;
    if(Log.isLoggable(TAG, Log.VERBOSE))                
                {
                } //End block
    if(earliestTimeoutTime > currentSyncTimeoutTime)                
                {
                    earliestTimeoutTime = currentSyncTimeoutTime;
                } //End block
            } //End block
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
            long alarmTime = Math.min(notificationTime, earliestTimeoutTime);
            alarmTime = Math.min(alarmTime, nextPeriodicEventElapsedTime);
            alarmTime = Math.min(alarmTime, nextPendingEventElapsedTime);
            final long now = SystemClock.elapsedRealtime();
    if(alarmTime < now + SYNC_ALARM_TIMEOUT_MIN)            
            {
    if(Log.isLoggable(TAG, Log.VERBOSE))                
                {
                } //End block
                alarmTime = now + SYNC_ALARM_TIMEOUT_MIN;
            } //End block
            else
    if(alarmTime > now + SYNC_ALARM_TIMEOUT_MAX)            
            {
    if(Log.isLoggable(TAG, Log.VERBOSE))                
                {
                } //End block
                alarmTime = now + SYNC_ALARM_TIMEOUT_MAX;
            } //End block
            boolean shouldSet = false;
            boolean shouldCancel = false;
            final boolean alarmIsActive = mAlarmScheduleTime != null;
            final boolean needAlarm = alarmTime != Long.MAX_VALUE;
    if(needAlarm)            
            {
    if(!alarmIsActive || alarmTime < mAlarmScheduleTime)                
                {
                    shouldSet = true;
                } //End block
            } //End block
            else
            {
                shouldCancel = alarmIsActive;
            } //End block
            ensureAlarmService();
    if(shouldSet)            
            {
    if(Log.isLoggable(TAG, Log.VERBOSE))                
                {
                } //End block
                mAlarmScheduleTime = alarmTime;
                mAlarmService.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, alarmTime,
                        mSyncAlarmIntent);
            } //End block
            else
    if(shouldCancel)            
            {
                mAlarmScheduleTime = null;
                mAlarmService.cancel(mSyncAlarmIntent);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.051 -0400", hash_original_method = "A9010BB637A8EEC323C58050189C44ED", hash_generated_method = "E4B378507F7F1DE7914B0D2A99A5CE5A")
        private void sendSyncStateIntent() {
            Intent syncStateIntent = new Intent(Intent.ACTION_SYNC_STATE_CHANGED);
            syncStateIntent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
            syncStateIntent.putExtra("active", mNeedSyncActiveNotification);
            syncStateIntent.putExtra("failing", false);
            mContext.sendBroadcast(syncStateIntent);
            // ---------- Original Method ----------
            //Intent syncStateIntent = new Intent(Intent.ACTION_SYNC_STATE_CHANGED);
            //syncStateIntent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
            //syncStateIntent.putExtra("active", mNeedSyncActiveNotification);
            //syncStateIntent.putExtra("failing", false);
            //mContext.sendBroadcast(syncStateIntent);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.052 -0400", hash_original_method = "87A468A0891FD210AAD2B0099F053FF2", hash_generated_method = "7D60212F949EAA9F44E5CA0369FBE39B")
        private void installHandleTooManyDeletesNotification(Account account, String authority,
                long numDeletes) {
            addTaint(numDeletes);
            addTaint(authority.getTaint());
            addTaint(account.getTaint());
    if(mNotificationMgr == null)            
            return;
            final ProviderInfo providerInfo = mContext.getPackageManager().resolveContentProvider(
                    authority, 0 );
    if(providerInfo == null)            
            {
                return;
            } //End block
            CharSequence authorityName = providerInfo.loadLabel(mContext.getPackageManager());
            Intent clickIntent = new Intent(mContext, SyncActivityTooManyDeletes.class);
            clickIntent.putExtra("account", account);
            clickIntent.putExtra("authority", authority);
            clickIntent.putExtra("provider", authorityName.toString());
            clickIntent.putExtra("numDeletes", numDeletes);
    if(!isActivityAvailable(clickIntent))            
            {
                return;
            } //End block
            final PendingIntent pendingIntent = PendingIntent
                    .getActivity(mContext, 0, clickIntent, PendingIntent.FLAG_CANCEL_CURRENT);
            CharSequence tooManyDeletesDescFormat = mContext.getResources().getText(
                    R.string.contentServiceTooManyDeletesNotificationDesc);
            Notification notification = new Notification(R.drawable.stat_notify_sync_error,
                        mContext.getString(R.string.contentServiceSync),
                        System.currentTimeMillis());
            notification.setLatestEventInfo(mContext,
                    mContext.getString(R.string.contentServiceSyncNotificationTitle),
                    String.format(tooManyDeletesDescFormat.toString(), authorityName),
                    pendingIntent);
            notification.flags |= Notification.FLAG_ONGOING_EVENT;
            mNotificationMgr.notify(account.hashCode() ^ authority.hashCode(), notification);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.053 -0400", hash_original_method = "ABB616725C31652C20F8F96BBDEFC6AA", hash_generated_method = "EDD0F0BB3C2391EA44D248A3AE779E6B")
        private boolean isActivityAvailable(Intent intent) {
            addTaint(intent.getTaint());
            PackageManager pm = mContext.getPackageManager();
            List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
            int listSize = list.size();
for(int i = 0;i < listSize;i++)
            {
                ResolveInfo resolveInfo = list.get(i);
    if((resolveInfo.activityInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)
                        != 0)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1911273566 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_506808481 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_506808481;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1135042590 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_168508195 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_168508195;
            // ---------- Original Method ----------
            //PackageManager pm = mContext.getPackageManager();
            //List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
            //int listSize = list.size();
            //for (int i = 0; i < listSize; i++) {
                //ResolveInfo resolveInfo = list.get(i);
                //if ((resolveInfo.activityInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)
                        //!= 0) {
                    //return true;
                //}
            //}
            //return false;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.054 -0400", hash_original_method = "6B3E86A8BC94835376C1AE5FBE72A92C", hash_generated_method = "9665ABD73E2DEC7778BC386AFC49EF6C")
        public long insertStartSyncEvent(SyncOperation syncOperation) {
            addTaint(syncOperation.getTaint());
            final int source = syncOperation.syncSource;
            final long now = System.currentTimeMillis();
            EventLog.writeEvent(2720, syncOperation.authority,
                                SyncStorageEngine.EVENT_START, source,
                                syncOperation.account.name.hashCode());
            long var6EC8F9F3BCDED296793EAEFD7C3389D4_1020388803 = (mSyncStorageEngine.insertStartSyncEvent(
                    syncOperation.account, syncOperation.authority, now, source));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1178304592 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1178304592;
            // ---------- Original Method ----------
            //final int source = syncOperation.syncSource;
            //final long now = System.currentTimeMillis();
            //EventLog.writeEvent(2720, syncOperation.authority,
                                //SyncStorageEngine.EVENT_START, source,
                                //syncOperation.account.name.hashCode());
            //return mSyncStorageEngine.insertStartSyncEvent(
                    //syncOperation.account, syncOperation.authority, now, source);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.055 -0400", hash_original_method = "7B2BF6D83EFC49C83F4A75250B3225F9", hash_generated_method = "086CC84610E5BAC0A3ACFABCFFAEF3C1")
        public void stopSyncEvent(long rowId, SyncOperation syncOperation, String resultMessage,
                int upstreamActivity, int downstreamActivity, long elapsedTime) {
            addTaint(elapsedTime);
            addTaint(downstreamActivity);
            addTaint(upstreamActivity);
            addTaint(resultMessage.getTaint());
            addTaint(syncOperation.getTaint());
            addTaint(rowId);
            EventLog.writeEvent(2720, syncOperation.authority,
                                SyncStorageEngine.EVENT_STOP, syncOperation.syncSource,
                                syncOperation.account.name.hashCode());
            mSyncStorageEngine.stopSyncEvent(rowId, elapsedTime,
                    resultMessage, downstreamActivity, upstreamActivity);
            // ---------- Original Method ----------
            //EventLog.writeEvent(2720, syncOperation.authority,
                                //SyncStorageEngine.EVENT_STOP, syncOperation.syncSource,
                                //syncOperation.account.name.hashCode());
            //mSyncStorageEngine.stopSyncEvent(rowId, elapsedTime,
                    //resultMessage, downstreamActivity, upstreamActivity);
        }

        
        class SyncNotificationInfo {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.056 -0400", hash_original_field = "7899BB2CC98E6AA80AEA065C2FB1FCD8", hash_generated_field = "1F020E689776523E90BE0EA7B3F2C831")

            public boolean isActive = false;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.056 -0400", hash_original_field = "5C942F641C110ED5DBCFAC50E6B9ACF7", hash_generated_field = "C38616C84435C3AAF7A5C7D2D3DE9890")

            public Long startTime = null;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.056 -0400", hash_original_method = "4A2C88DB351F685B767C50ED28D568B0", hash_generated_method = "4A2C88DB351F685B767C50ED28D568B0")
            public SyncNotificationInfo ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.056 -0400", hash_original_method = "4796BE9F4C6BFE28E8FE17808C5D7635", hash_generated_method = "B4D263B5B10F67599B0A2E50DCB3BD98")
            public void toString(StringBuilder sb) {
                addTaint(sb.getTaint());
                sb.append("isActive ").append(isActive).append(", startTime ").append(startTime);
                // ---------- Original Method ----------
                //sb.append("isActive ").append(isActive).append(", startTime ").append(startTime);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.057 -0400", hash_original_method = "C99E9A460C6F28DBA730EF38203534A2", hash_generated_method = "780736AF5596D7B5E0E0615CC744DBDF")
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                toString(sb);
String var2460B846747F8B22185AD8BE722266A5_1234058476 =                 sb.toString();
                var2460B846747F8B22185AD8BE722266A5_1234058476.addTaint(taint);
                return var2460B846747F8B22185AD8BE722266A5_1234058476;
                // ---------- Original Method ----------
                //StringBuilder sb = new StringBuilder();
                //toString(sb);
                //return sb.toString();
            }

            
        }


        
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
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.058 -0400", hash_original_field = "0439F4DA6A334C5ECD9FAAB83A40EC1E", hash_generated_field = "AF31108A14FC5488BDB972C9330ED310")

    private static final String TAG = "SyncManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.058 -0400", hash_original_field = "771C7532EFD39D46D9339548BBB003DC", hash_generated_field = "4208D47E32C101BD1011FA8D9E027183")

    private static long LOCAL_SYNC_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.058 -0400", hash_original_field = "3E2805F816BDAD7B0E27638D25F6D269", hash_generated_field = "63AD8E40CBA9E89F2FEE5FAFC18666A5")

    private static long MAX_TIME_PER_SYNC;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.058 -0400", hash_original_field = "1CEBD7C64FE2AC04D4AE482388A5976D", hash_generated_field = "3AAF491FDBA16F2F889370991CA097D0")

    private static long SYNC_NOTIFICATION_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.059 -0400", hash_original_field = "8A34DCE73DB332FD0A4FF63A9C446008", hash_generated_field = "83F3A378A2D13840721B0279CB462023")

    private static final long INITIAL_SYNC_RETRY_TIME_IN_MS = 30 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.059 -0400", hash_original_field = "79DEDA6259DEAD6C126CF86621DA2B8D", hash_generated_field = "B4DA134C6F2983E394C39C327898075F")

    private static final long DEFAULT_MAX_SYNC_RETRY_TIME_IN_SECONDS = 60 * 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.059 -0400", hash_original_field = "BEDF93B108551F114E8741DFEC9794F3", hash_generated_field = "FF351B5F49B49CCEBD14D33F1242A542")

    private static final int DELAY_RETRY_SYNC_IN_PROGRESS_IN_SECONDS = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.059 -0400", hash_original_field = "958F3D750E64AC9BC6242F30C61536C4", hash_generated_field = "B0D1B128A9CF950755F3C1F260FD40B6")

    private static final int INITIALIZATION_UNBIND_DELAY_MS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.059 -0400", hash_original_field = "F895C5D283689380E1BDDC0B7499335D", hash_generated_field = "7F3CEE103BD418D549113FC97263D665")

    private static final String SYNC_WAKE_LOCK_PREFIX = "*sync*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.060 -0400", hash_original_field = "C0E30578C8EE9D3B561C121F18E4A9AD", hash_generated_field = "B085210333D6AE1E4EF229385F1B25F4")

    private static final String HANDLE_SYNC_ALARM_WAKE_LOCK = "SyncManagerHandleSyncAlarm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.060 -0400", hash_original_field = "001DF2B72F4A5E3029F7CCA97081B70A", hash_generated_field = "791AF54DB72DF3C3FD2BE8EA99DCAD10")

    private static final String SYNC_LOOP_WAKE_LOCK = "SyncLoopWakeLock";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.060 -0400", hash_original_field = "21F59C952591D05458A974B04A5B1713", hash_generated_field = "DC304F1B2F6CD9046C54D34DCF49FB2F")

    private static int MAX_SIMULTANEOUS_REGULAR_SYNCS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.060 -0400", hash_original_field = "10B69AAB2B5C562523E268773A0D00E7", hash_generated_field = "8E80CF6DF9009EC95BD99B5E32172ABF")

    private static int MAX_SIMULTANEOUS_INITIALIZATION_SYNCS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.060 -0400", hash_original_field = "1A4663330AD445B983CE39BD12E9AD75", hash_generated_field = "AC3DDB789130E3521D0C40EF27CE7201")

    private static final Account[] INITIAL_ACCOUNTS_ARRAY = new Account[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.060 -0400", hash_original_field = "5BC49BB889CB3FAFB9C3D3A1F33F6081", hash_generated_field = "756530F66B344934D47CAC2FCBB3C754")

    private static final long SYNC_ALARM_TIMEOUT_MIN = 30 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.060 -0400", hash_original_field = "06AAABB61EB2A5F0EA12B8589056A2BF", hash_generated_field = "7B838AAC8E827495E078DC2F638D031A")

    private static final long SYNC_ALARM_TIMEOUT_MAX = 2 * 60 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.061 -0400", hash_original_field = "227D4DFA41347C0DE3EB12E8255A744E", hash_generated_field = "4F82340A6F1A976788D789CF812DC25C")

    private static final String ACTION_SYNC_ALARM = "android.content.syncmanager.SYNC_ALARM";
}

