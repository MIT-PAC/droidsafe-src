package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.953 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.953 -0400", hash_original_field = "C217519E7D6AA72743CEC5E5FD7C02F1", hash_generated_field = "F3BBCBF609328E3671F4870EF2739BA1")

    private volatile Account[] mAccounts = INITIAL_ACCOUNTS_ARRAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.953 -0400", hash_original_field = "3607537A4ABC9C2B0FDA6CD04E7BA4CF", hash_generated_field = "EA882B4EDA8036D1634A0912AFD18614")

    volatile private PowerManager.WakeLock mHandleAlarmWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.953 -0400", hash_original_field = "B8A7E3B6F94CE3A0F567CD61AFB97855", hash_generated_field = "8C143BC8231548B929C0E876431327F2")

    volatile private PowerManager.WakeLock mSyncManagerWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.953 -0400", hash_original_field = "4728A84AF4B8DF029806A2097B575A3A", hash_generated_field = "17D5CCC25BF0F59A9B8C5AD2751D5254")

    volatile private boolean mDataConnectionIsConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.953 -0400", hash_original_field = "B81CB3C0F8BD276814C574302F581993", hash_generated_field = "466B67045A4516E83F397111D3AB9D8F")

    volatile private boolean mStorageIsLow = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.953 -0400", hash_original_field = "1D89DACDF96236F3858ECCE33A51EFED", hash_generated_field = "E3BFB96D82A2106A16337E9442023DA0")

    private NotificationManager mNotificationMgr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.953 -0400", hash_original_field = "917992EEA0C7F4BC7CC5D5B270F6017F", hash_generated_field = "A708A7397CF3CD2AD62512A76A16AA9A")

    private AlarmManager mAlarmService = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.953 -0400", hash_original_field = "45147E3AEB1E4ADCE06A13083E577526", hash_generated_field = "C4D1F4553F2DAB654514F44F7C643ACD")

    private SyncStorageEngine mSyncStorageEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.953 -0400", hash_original_field = "C9FDEBC8B43E8CF10A847D8E78A297F9", hash_generated_field = "9C22406DD21183D6092ABB0219CA18DB")

    public SyncQueue mSyncQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.954 -0400", hash_original_field = "969116B6B37E354467E9B2E8F3E55C0D", hash_generated_field = "36C4E8795C18DEB3F2B34C61084BC4F5")

    protected final ArrayList<ActiveSyncContext> mActiveSyncContexts = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.954 -0400", hash_original_field = "1EA8C7643DB05CB27275C01529A3B68D", hash_generated_field = "2C170DA4C09FF899D129001B1ECCF61D")

    private boolean mNeedSyncActiveNotification = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.954 -0400", hash_original_field = "903D42B85DB5FCC64341BB05BCAF3314", hash_generated_field = "FF2D77AC785FF38C8AC4F17DE204C25B")

    private PendingIntent mSyncAlarmIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.954 -0400", hash_original_field = "CAF97C3C9F7900E8B91A0310501882F5", hash_generated_field = "4F3FBD8A907B6E0F5B4504A10DCCE878")

    private ConnectivityManager mConnManagerDoNotUseDirectly;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.954 -0400", hash_original_field = "5BACDC96B768A3E26C7617A22F60CBBA", hash_generated_field = "E33ECCC9C6F1F57E962D4A8990DDF83C")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.956 -0400", hash_original_field = "914EF4BB3FD2989BEA197B83DB980E43", hash_generated_field = "C0ABFDE975E218E90A8E9AECD9B1F45A")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.958 -0400", hash_original_field = "2BFA50A6F682F32C5E74B6BF1DA5F561", hash_generated_field = "48C1F195FC8EA9F865537B3EB1F3D277")

    private SyncHandler mSyncHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.958 -0400", hash_original_field = "07ED8299DCE5FFC54346DB7582134B71", hash_generated_field = "36D62901B5F66AD7425C1042CCC68DC2")

    private Handler mMainHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.958 -0400", hash_original_field = "3C0D61A464F7DDB2D139F30472309ADC", hash_generated_field = "575B378AD4BFE1F61DDDF06CA57D041D")

    private volatile boolean mBootCompleted = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.961 -0400", hash_original_method = "03EC3B1422C9597488B0C8A9401C488F", hash_generated_method = "24A867A85C1525D7DD5DA8A68CD5E160")
    public  SyncManager(Context context, boolean factoryTest) {
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.960 -0400", hash_original_method = "156EF77A103E5C10F6AA28A0B09EC843", hash_generated_method = "4ECDDC5E5A7426C563A7386848DEB420")
            public void onServiceChanged(SyncAdapterType type, boolean removed) {
                
                {
                    scheduleSync(null, type.authority, null, 0 ,
                            false );
                } 
                addTaint(type.getTaint());
                addTaint(removed);
                
                
                    
                            
                
            }
}, mSyncHandler);
        mSyncAlarmIntent = PendingIntent.getBroadcast(
                mContext, 0 , new Intent(ACTION_SYNC_ALARM), 0);
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(mConnectivityIntentReceiver, intentFilter);
        {
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
        {
            mNotificationMgr = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
            context.registerReceiver(new SyncAlarmIntentReceiver(),
                    new IntentFilter(ACTION_SYNC_ALARM));
        } 
        {
            mNotificationMgr = null;
        } 
        mPowerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mHandleAlarmWakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                HANDLE_SYNC_ALARM_WAKE_LOCK);
        mHandleAlarmWakeLock.setReferenceCounted(false);
        mSyncManagerWakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                SYNC_LOOP_WAKE_LOCK);
        mSyncManagerWakeLock.setReferenceCounted(false);
        mSyncStorageEngine.addStatusChangeListener(
                ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS, new ISyncStatusObserver.Stub() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.961 -0400", hash_original_method = "E2E5241731BE29D01E4993B391B00B92", hash_generated_method = "E877FE14261D351EFC08FE17A893B854")
            public void onStatusChanged(int which) {
                
                sendCheckAlarmsMessage();
                addTaint(which);
                
                
            }
});
        {
            AccountManager.get(mContext).addOnAccountsUpdatedListener(SyncManager.this,
                mSyncHandler, false );
            onAccountsUpdated(AccountManager.get(mContext).getAccounts());
        } 
        addTaint(factoryTest);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.968 -0400", hash_original_method = "F68E26CE46C5E71DC7131B4E8982A697", hash_generated_method = "2AC0C9ADA463E003574AE86BEB096EA4")
    public void onAccountsUpdated(Account[] accounts) {
        
        final boolean justBootedUp = mAccounts == INITIAL_ACCOUNTS_ARRAY;
        mAccounts = accounts;
        {
            Iterator<ActiveSyncContext> varB42644AE74A51E951ED6AB5DD20DA8CE_1395992770 = (mActiveSyncContexts).iterator();
            varB42644AE74A51E951ED6AB5DD20DA8CE_1395992770.hasNext();
            ActiveSyncContext currentSyncContext = varB42644AE74A51E951ED6AB5DD20DA8CE_1395992770.next();
            {
                {
                    boolean var98DBBB9384A6D900D1DF555C10C402D5_1704609447 = (!ArrayUtils.contains(accounts, currentSyncContext.mSyncOperation.account));
                    {
                        Log.d(TAG, "canceling sync since the account has been removed");
                        sendSyncFinishedOrCanceledMessage(currentSyncContext,
                        null );
                    } 
                } 
            } 
        } 
        sendCheckAlarmsMessage();
        {
            mSyncStorageEngine.doDatabaseCleanup(accounts);
        } 
        {
            boolean onlyThoseWithUnkownSyncableState = justBootedUp;
            scheduleSync(null, null, null, 0 , onlyThoseWithUnkownSyncableState);
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.969 -0400", hash_original_method = "90A2C58DEF02026C184592212F85FF18", hash_generated_method = "3DCB114F1FD95C58A67FDAF80A44DEDD")
    private boolean readDataConnectionState() {
        NetworkInfo networkInfo = getConnectivityManager().getActiveNetworkInfo();
        boolean var53496D7038EE5B94BB35F9D43FD53DF1_42556499 = ((networkInfo != null) && networkInfo.isConnected());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013935699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013935699;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.971 -0400", hash_original_method = "85835365DA8D3F37E74A4C98C5566C52", hash_generated_method = "31EFE1514B59B46AA32E935D32AAD1E1")
    private ConnectivityManager getConnectivityManager() {
        ConnectivityManager varB4EAC82CA7396A68D541C85D26508E83_1710970775 = null; 
        {
            {
                mConnManagerDoNotUseDirectly = (ConnectivityManager)mContext.getSystemService(
                        Context.CONNECTIVITY_SERVICE);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1710970775 = mConnManagerDoNotUseDirectly;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1710970775.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1710970775;
        
        
            
                
                        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.972 -0400", hash_original_method = "2C829A46E677D5FF63843A6B74A54E87", hash_generated_method = "CE1EB3943406869C358F723542C29A54")
    private long jitterize(long minValue, long maxValue) {
        Random random = new Random(SystemClock.elapsedRealtime());
        long spread = maxValue - minValue;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the difference between the maxValue and the "
                    + "minValue must be less than " + Integer.MAX_VALUE);
        } 
        long varD1004F69028D356D16619D81D55BEACE_1637300328 = (minValue + random.nextInt((int)spread));
        addTaint(minValue);
        addTaint(maxValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2111755127 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2111755127;
        
        
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.974 -0400", hash_original_method = "BC7A6B22ABBE0EBF148B37C3B72645F0", hash_generated_method = "C01B1CDB8E12CD80591068BFEB712391")
    public SyncStorageEngine getSyncStorageEngine() {
        SyncStorageEngine varB4EAC82CA7396A68D541C85D26508E83_1233003677 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1233003677 = mSyncStorageEngine;
        varB4EAC82CA7396A68D541C85D26508E83_1233003677.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1233003677;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.974 -0400", hash_original_method = "51F169FF6EC2BB253880B74521EEDA04", hash_generated_method = "35DF559DA3A5DA237B231F2EE75E3A9C")
    private void ensureAlarmService() {
        {
            mAlarmService = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.975 -0400", hash_original_method = "3B1126FA248635D8E240EE322F732C4B", hash_generated_method = "E9CAB79F42C75CAC8642D573BF1E596C")
    private void initializeSyncAdapter(Account account, String authority) {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_570487506 = (Log.isLoggable(TAG, Log.VERBOSE));
        } 
        SyncAdapterType syncAdapterType = SyncAdapterType.newKey(authority, account.type);
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = mSyncAdapters.getServiceInfo(syncAdapterType);
        {
            mSyncStorageEngine.removeAuthority(account, authority);
        } 
        Intent intent = new Intent();
        intent.setAction("android.content.SyncAdapter");
        intent.setComponent(syncAdapterInfo.componentName);
        {
            boolean var1A3A6E55EBFBD5A3E4EB18A5AAADC18B_1640400088 = (!mContext.bindService(intent,
                new InitializerServiceConnection(account, authority, mContext, mMainHandler),
                Context.BIND_AUTO_CREATE | Context.BIND_NOT_FOREGROUND
                | Context.BIND_ALLOW_OOM_MANAGEMENT));
        } 
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:03.658 -0400", hash_original_method = "B73E52BAF4D022DC2D77FE197F842436", hash_generated_method = "F70D8EA371BFA624ED15340FF4A3FDF3")
    public void scheduleSync(Account requestedAccount, String requestedAuthority,
            Bundle extras, long delay, boolean onlyThoseWithUnkownSyncableState) {
        boolean isLoggable;
        isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
        boolean backgroundDataUsageAllowed;
        backgroundDataUsageAllowed = !mBootCompleted ||
                getConnectivityManager().getBackgroundDataSetting();
        extras = new Bundle();
        Boolean expedited;
        expedited = extras.getBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, false);
        {
            delay = -1;
        } 
        Account[] accounts;
        {
            accounts = new Account[]{requestedAccount};
        } 
        {
            accounts = mAccounts;
        } 
        boolean uploadOnly;
        uploadOnly = extras.getBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, false);
        boolean manualSync;
        manualSync = extras.getBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, false);
        {
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, true);
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, true);
        } 
        boolean ignoreSettings;
        ignoreSettings = extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, false);
        int source;
        {
            source = SyncStorageEngine.SOURCE_LOCAL;
        } 
        {
            source = SyncStorageEngine.SOURCE_USER;
        } 
        {
            source = SyncStorageEngine.SOURCE_POLL;
        } 
        {
            source = SyncStorageEngine.SOURCE_SERVER;
        } 
        HashSet<String> syncableAuthorities;
        syncableAuthorities = new HashSet<String>();
        {
            Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> varA460451BE61974D4E85B931D5CE391A8_2047117187 = (mSyncAdapters.getAllServices()).iterator();
            varA460451BE61974D4E85B931D5CE391A8_2047117187.hasNext();
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapter = varA460451BE61974D4E85B931D5CE391A8_2047117187.next();
            {
                syncableAuthorities.add(syncAdapter.type.authority);
            } 
        } 
        {
            boolean hasSyncAdapter;
            hasSyncAdapter = syncableAuthorities.contains(requestedAuthority);
            syncableAuthorities.clear();
            syncableAuthorities.add(requestedAuthority);
        } 
        boolean masterSyncAutomatically;
        masterSyncAutomatically = mSyncStorageEngine.getMasterSyncAutomatically();
        {
            Iterator<String> varA26FDBFC8911931337CEF509AC3DFFCA_1563564863 = (syncableAuthorities).iterator();
            varA26FDBFC8911931337CEF509AC3DFFCA_1563564863.hasNext();
            String authority = varA26FDBFC8911931337CEF509AC3DFFCA_1563564863.next();
            {
                {
                    Account account = accounts[0];
                    {
                        int isSyncable;
                        isSyncable = mSyncStorageEngine.getIsSyncable(account, authority);
                        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo;
                        syncAdapterInfo = mSyncAdapters.getServiceInfo(
                                SyncAdapterType.newKey(authority, account.type));
                        boolean allowParallelSyncs;
                        allowParallelSyncs = syncAdapterInfo.type.allowParallelSyncs();
                        boolean isAlwaysSyncable;
                        isAlwaysSyncable = syncAdapterInfo.type.isAlwaysSyncable();
                        {
                            mSyncStorageEngine.setIsSyncable(account, authority, 1);
                            isSyncable = 1;
                        } 
                        {
                            boolean varE5FC1CEDA70C1C0494947FABB12B6E86_1515505099 = (!syncAdapterInfo.type.supportsUploading() && uploadOnly);
                        } 
                        boolean syncAllowed;
                        syncAllowed = (isSyncable < 0)
                        || ignoreSettings
                        || (backgroundDataUsageAllowed && masterSyncAutomatically
                            && mSyncStorageEngine.getSyncAutomatically(account, authority));
                        {
                            {
                                Log.d(TAG, "scheduleSync: sync of " + account + ", " + authority
                                + " is not allowed, dropping request");
                            } 
                        } 
                        Pair<Long, Long> backoff;
                        backoff = mSyncStorageEngine.getBackoff(account, authority);
                        long delayUntil;
                        delayUntil = mSyncStorageEngine.getDelayUntilTime(account, authority);
                        long backoffTime;
                        backoffTime = backoff.first;
                        backoffTime = 0;
                        {
                            Bundle newExtras;
                            newExtras = new Bundle();
                            newExtras.putBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, true);
                            scheduleSyncOperation(
                            new SyncOperation(account, source, authority, newExtras, 0,
                                    backoffTime, delayUntil,
                                    allowParallelSyncs));
                        } 
                        {
                            scheduleSyncOperation(
                            new SyncOperation(account, source, authority, extras, delay,
                                    backoffTime, delayUntil,
                                    allowParallelSyncs));
                        } 
                    } 
                } 
            } 
        } 
        addTaint(requestedAccount.getTaint());
        addTaint(requestedAuthority.getTaint());
        addTaint(extras.getTaint());
        addTaint(delay);
        addTaint(onlyThoseWithUnkownSyncableState);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.976 -0400", hash_original_method = "9A217D026FB5B08090F4BAFAA08C0DF7", hash_generated_method = "6449DABDB90B4BB5CCB5A2A2DFFBA1A7")
    public void scheduleLocalSync(Account account, String authority) {
        final Bundle extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        scheduleSync(account, authority, extras, LOCAL_SYNC_DELAY,
                false );
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        
        
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.985 -0400", hash_original_method = "0A2ACD1B7EA84D8FDEC2211873578368", hash_generated_method = "78D378485229C5114EC751A9166C9123")
    public SyncAdapterType[] getSyncAdapterTypes() {
        SyncAdapterType[] varB4EAC82CA7396A68D541C85D26508E83_782813829 = null; 
        final Collection<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> serviceInfos = mSyncAdapters.getAllServices();
        SyncAdapterType[] types = new SyncAdapterType[serviceInfos.size()];
        int i = 0;
        {
            Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> var7AE0F59F3247E05923E8DDBDBBF91C7C_1953492282 = (serviceInfos).iterator();
            var7AE0F59F3247E05923E8DDBDBBF91C7C_1953492282.hasNext();
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> serviceInfo = var7AE0F59F3247E05923E8DDBDBBF91C7C_1953492282.next();
            {
                types[i] = serviceInfo.type;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_782813829 = types;
        varB4EAC82CA7396A68D541C85D26508E83_782813829.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_782813829;
        
        
                
                
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.986 -0400", hash_original_method = "14A3D8C2E4B2E28E7EAE9416931B0D4D", hash_generated_method = "EE56F118AA0AFAE95F4F5D9CC047418A")
    private void sendSyncAlarmMessage() {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_972474904 = (Log.isLoggable(TAG, Log.VERBOSE));
        } 
        mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_SYNC_ALARM);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.986 -0400", hash_original_method = "48CD41A4FC7AAC6DBD3D417BDFF3952E", hash_generated_method = "61CCFC0A50948330711D920BD63F8F23")
    private void sendCheckAlarmsMessage() {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_907542677 = (Log.isLoggable(TAG, Log.VERBOSE));
        } 
        mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_CHECK_ALARMS);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.987 -0400", hash_original_method = "A4D4C528BED9CEDB160AF5BFC279888F", hash_generated_method = "A88D88D9D7B97CAFC7D4C70B1F3AC209")
    private void sendSyncFinishedOrCanceledMessage(ActiveSyncContext syncContext,
            SyncResult syncResult) {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_61784483 = (Log.isLoggable(TAG, Log.VERBOSE));
        } 
        Message msg = mSyncHandler.obtainMessage();
        msg.what = SyncHandler.MESSAGE_SYNC_FINISHED;
        msg.obj = new SyncHandlerMessagePayload(syncContext, syncResult);
        mSyncHandler.sendMessage(msg);
        addTaint(syncContext.getTaint());
        addTaint(syncResult.getTaint());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.987 -0400", hash_original_method = "162904FEAED4FE3BDD09493527BC709D", hash_generated_method = "B37EC8C8B87B520A8B32ECE0922BC859")
    private void sendCancelSyncsMessage(final Account account, final String authority) {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_1759352340 = (Log.isLoggable(TAG, Log.VERBOSE));
        } 
        Message msg = mSyncHandler.obtainMessage();
        msg.what = SyncHandler.MESSAGE_CANCEL;
        msg.obj = Pair.create(account, authority);
        mSyncHandler.sendMessage(msg);
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.988 -0400", hash_original_method = "1BD5650AC2366081E95971C40228D13F", hash_generated_method = "EE91EA44BF4DDE4D26866584ABAA7BA9")
    private void clearBackoffSetting(SyncOperation op) {
        mSyncStorageEngine.setBackoff(op.account, op.authority,
                SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
        {
            mSyncQueue.onBackoffChanged(op.account, op.authority, 0);
        } 
        addTaint(op.getTaint());
        
        
                
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.990 -0400", hash_original_method = "42DD92B3EE29EAC346CC626BA6B5C78C", hash_generated_method = "5939E3148FE14550E0B45EBDD3B8343C")
    private void increaseBackoffSetting(SyncOperation op) {
        final long now = SystemClock.elapsedRealtime();
        final Pair<Long, Long> previousSettings = mSyncStorageEngine.getBackoff(op.account, op.authority);
        long newDelayInMs = -1;
        {
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1234938894 = (Log.isLoggable(TAG, Log.VERBOSE));
                } 
            } 
            newDelayInMs = previousSettings.second * 2;
        } 
        {
            newDelayInMs = jitterize(INITIAL_SYNC_RETRY_TIME_IN_MS,
                    (long)(INITIAL_SYNC_RETRY_TIME_IN_MS * 1.1));
        } 
        long maxSyncRetryTimeInSeconds = Settings.Secure.getLong(mContext.getContentResolver(),
                Settings.Secure.SYNC_MAX_RETRY_DELAY_IN_SECONDS,
                DEFAULT_MAX_SYNC_RETRY_TIME_IN_SECONDS);
        {
            newDelayInMs = maxSyncRetryTimeInSeconds * 1000;
        } 
        final long backoff = now + newDelayInMs;
        mSyncStorageEngine.setBackoff(op.account, op.authority,
                backoff, newDelayInMs);
        op.backoff = backoff;
        op.updateEffectiveRunTime();
        {
            mSyncQueue.onBackoffChanged(op.account, op.authority, backoff);
        } 
        addTaint(op.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.991 -0400", hash_original_method = "D0F8BD8389FAB953FA57BE172373CE33", hash_generated_method = "E42D36A48FCF3E10D0A676850606AD04")
    private void setDelayUntilTime(SyncOperation op, long delayUntilSeconds) {
        final long delayUntil = delayUntilSeconds * 1000;
        final long absoluteNow = System.currentTimeMillis();
        long newDelayUntilTime;
        {
            newDelayUntilTime = SystemClock.elapsedRealtime() + (delayUntil - absoluteNow);
        } 
        {
            newDelayUntilTime = 0;
        } 
        mSyncStorageEngine.setDelayUntilTime(op.account, op.authority, newDelayUntilTime);
        {
            mSyncQueue.onDelayUntilTimeChanged(op.account, op.authority, newDelayUntilTime);
        } 
        addTaint(op.getTaint());
        addTaint(delayUntilSeconds);
        
        
        
        
        
            
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.993 -0400", hash_original_method = "CC013A9497DA672D61638E0368F0173C", hash_generated_method = "694105C2C8F4F12B6E371ED5F65EA3D0")
    public void cancelActiveSync(Account account, String authority) {
        sendCancelSyncsMessage(account, authority);
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.994 -0400", hash_original_method = "B18DC4486E3B23A71F43236C6D4E20D9", hash_generated_method = "23BE2127D49C7647FC656CD00579A406")
    public void scheduleSyncOperation(SyncOperation syncOperation) {
        boolean queueChanged;
        {
            queueChanged = mSyncQueue.add(syncOperation);
        } 
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1681761020 = (Log.isLoggable(TAG, Log.VERBOSE));
            } 
            sendCheckAlarmsMessage();
        } 
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_695046897 = (Log.isLoggable(TAG, Log.VERBOSE));
            } 
        } 
        addTaint(syncOperation.getTaint());
        
        
        
            
        
        
            
                
            
            
        
            
                
                        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.994 -0400", hash_original_method = "A2720167EE002D05FE5DA0F6211150BE", hash_generated_method = "51CE72BEF915FEA979D106F602A7F3F3")
    public void clearScheduledSyncOperations(Account account, String authority) {
        {
            mSyncQueue.remove(account, authority);
        } 
        mSyncStorageEngine.setBackoff(account, authority,
                SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.996 -0400", hash_original_method = "7F8B5486825DA8802A08F87FCECDEB6D", hash_generated_method = "0E72F9B22090E9DDA03C074833BDBFED")
     void maybeRescheduleSync(SyncResult syncResult, SyncOperation operation) {
        boolean isLoggable = Log.isLoggable(TAG, Log.DEBUG);
        {
            Log.d(TAG, "encountered error(s) during the sync: " + syncResult + ", " + operation);
        } 
        operation = new SyncOperation(operation);
        {
            boolean var136962CEFF8E97B7711EEA42390818DD_224763514 = (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, false));
            {
                operation.extras.remove(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF);
            } 
        } 
        {
            boolean var8F222CBFA0E1CEE9747F369F4C66D983_1294859417 = (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_DO_NOT_RETRY, false));
            {
                Log.d(TAG, "not retrying sync operation because SYNC_EXTRAS_DO_NOT_RETRY was specified "
                    + operation);
            } 
            {
                boolean varCF7FCB45BDB21B5C6B94F23C48AB3F03_1817066722 = (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, false)
                && !syncResult.syncAlreadyInProgress);
                {
                    operation.extras.remove(ContentResolver.SYNC_EXTRAS_UPLOAD);
                    Log.d(TAG, "retrying sync operation as a two-way sync because an upload-only sync "
                    + "encountered an error: " + operation);
                    scheduleSyncOperation(operation);
                } 
                {
                    Log.d(TAG, "not retrying sync operation because it retried too many times: "
                    + operation);
                } 
                {
                    boolean varAEB5246C7BAA2573F81B4D1F785CB99B_1533871442 = (syncResult.madeSomeProgress());
                    {
                        {
                            Log.d(TAG, "retrying sync operation because even though it had an error "
                        + "it achieved some success");
                        } 
                        scheduleSyncOperation(operation);
                    } 
                    {
                        {
                            Log.d(TAG, "retrying sync operation that failed because there was already a "
                        + "sync in progress: " + operation);
                        } 
                        scheduleSyncOperation(new SyncOperation(operation.account, operation.syncSource,
                    operation.authority, operation.extras,
                    DELAY_RETRY_SYNC_IN_PROGRESS_IN_SECONDS * 1000,
                    operation.backoff, operation.delayUntil, operation.allowParallelSyncs));
                    } 
                    {
                        boolean var2BF6670105BBC4F9CBE78135A10D2C2F_802618428 = (syncResult.hasSoftError());
                        {
                            {
                                Log.d(TAG, "retrying sync operation because it encountered a soft error: "
                        + operation);
                            } 
                            scheduleSyncOperation(operation);
                        } 
                        {
                            Log.d(TAG, "not retrying sync operation because the error is a hard error: "
                    + operation);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(syncResult.getTaint());
        addTaint(operation.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:03.989 -0400", hash_original_method = "E59AB1EB4C672AE41E3C994B41A259B0", hash_generated_method = "1655E46725C471D36D54FD677CB9BD1A")
    protected void dump(FileDescriptor fd, PrintWriter pw) {
        dumpSyncState(pw);
        dumpSyncHistory(pw);
        pw.println();
        pw.println("SyncAdapters:");
        {
            Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> var66FF787B46917F4C470825A4AACF9C4B_1213736860 = (mSyncAdapters.getAllServices()).iterator();
            var66FF787B46917F4C470825A4AACF9C4B_1213736860.hasNext();
            RegisteredServicesCache.ServiceInfo info = var66FF787B46917F4C470825A4AACF9C4B_1213736860.next();
            {
                pw.println("  " + info);
            } 
        } 
        addTaint(fd.getTaint());
        addTaint(pw.getTaint());
        
        
        
        
        
        
            
        
    }

    
        @DSModeled(DSC.SPEC)
    static String formatTime(long time) {
        Time tobj = new Time();
        tobj.set(time);
        return tobj.format("%Y-%m-%d %H:%M:%S");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:05.423 -0400", hash_original_method = "A56698FB2481C281E3929C7135D64B8A", hash_generated_method = "71E2A0E32DE653593C542154F825573A")
    protected void dumpSyncState(PrintWriter pw) {
        pw.print("data connected: ");
        pw.println(mDataConnectionIsConnected);
        pw.print("memory low: ");
        pw.println(mStorageIsLow);
        Account[] accounts;
        accounts = mAccounts;
        pw.print("accounts: ");
        {
            pw.println(accounts.length);
        } 
        {
            pw.println("not known yet");
        } 
        long now;
        now = SystemClock.elapsedRealtime();
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
        {
            pw.print("next alarm time: ");
            pw.print(mSyncHandler.mAlarmScheduleTime);
            pw.print(" (");
            pw.print(DateUtils.formatElapsedTime((mSyncHandler.mAlarmScheduleTime-now)/1000));
            pw.println(" (HH:MM:SS) from now)");
        } 
        {
            pw.println("no alarm is scheduled (there had better not be any pending syncs)");
        } 
        pw.print("notification info: ");
        StringBuilder sb;
        sb = new StringBuilder();
        mSyncHandler.mSyncNotificationInfo.toString(sb);
        pw.println(sb.toString());
        pw.println();
        pw.println("Active Syncs: " + mActiveSyncContexts.size());
        {
            Iterator<SyncManager.ActiveSyncContext> var410A1C2D24679042EA90D422992CD225_465588219 = (mActiveSyncContexts).iterator();
            var410A1C2D24679042EA90D422992CD225_465588219.hasNext();
            SyncManager.ActiveSyncContext activeSyncContext = var410A1C2D24679042EA90D422992CD225_465588219.next();
            {
                long durationInSeconds;
                durationInSeconds = (now - activeSyncContext.mStartTime) / 1000;
                pw.print("  ");
                pw.print(DateUtils.formatElapsedTime(durationInSeconds));
                pw.print(" - ");
                pw.print(activeSyncContext.mSyncOperation.dump(false));
                pw.println();
            } 
        } 
        {
            sb.setLength(0);
            mSyncQueue.dump(sb);
        } 
        pw.println();
        pw.print(sb.toString());
        pw.println();
        pw.println("Sync Status");
        {
            Account account = accounts[0];
            {
                pw.print("  Account ");
                pw.print(account.name);
                pw.print(" ");
                pw.print(account.type);
                pw.println(":");
                {
                    Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> varB8408EC3A61191DA03920260AEC144C1_1264824476 = (mSyncAdapters.getAllServices()).iterator();
                    varB8408EC3A61191DA03920260AEC144C1_1264824476.hasNext();
                    RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterType = varB8408EC3A61191DA03920260AEC144C1_1264824476.next();
                    {
                        {
                            boolean varBFF66230831B803F3BB6FD65657B65E4_82873085 = (!syncAdapterType.type.accountType.equals(account.type));
                        } 
                        SyncStorageEngine.AuthorityInfo settings;
                        settings = mSyncStorageEngine.getOrCreateAuthority(
                        account, syncAdapterType.type.authority);
                        SyncStatusInfo status;
                        status = mSyncStorageEngine.getOrCreateSyncStatus(settings);
                        pw.print("    ");
                        pw.print(settings.authority);
                        pw.println(":");
                        pw.print("      settings:");
                        pw.print(" " + (settings.syncable > 0
                        ? "syncable"
                        : (settings.syncable == 0 ? "not syncable" : "not initialized")));
                        pw.print(", " + (settings.enabled ? "enabled" : "disabled"));
                        {
                            pw.print(", delay for "
                            + ((settings.delayUntil - now) / 1000) + " sec");
                        } 
                        {
                            pw.print(", backoff for "
                            + ((settings.backoffTime - now) / 1000) + " sec");
                        } 
                        {
                            pw.print(", the backoff increment is " + settings.backoffDelay / 1000
                                + " sec");
                        } 
                        pw.println();
                        {
                            int periodicIndex;
                            periodicIndex = 0;
                            boolean var234026F2237427D2FEAC3EFBEEDD19EA_1709094588 = (periodicIndex < settings.periodicSyncs.size());
                            {
                                Pair<Bundle, Long> info;
                                info = settings.periodicSyncs.get(periodicIndex);
                                long lastPeriodicTime;
                                lastPeriodicTime = status.getPeriodicSyncTime(periodicIndex);
                                long nextPeriodicTime;
                                nextPeriodicTime = lastPeriodicTime + info.second * 1000;
                                pw.println("      periodic period=" + info.second
                            + ", extras=" + info.first
                            + ", next=" + formatTime(nextPeriodicTime));
                            } 
                        } 
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
                        {
                            pw.print("      SUCCESS: source=");
                            pw.print(SyncStorageEngine.SOURCES[status.lastSuccessSource]);
                            pw.print(" time=");
                            pw.println(formatTime(status.lastSuccessTime));
                        } 
                        {
                            pw.print("      FAILURE: source=");
                            pw.print(SyncStorageEngine.SOURCES[
                            status.lastFailureSource]);
                            pw.print(" initialTime=");
                            pw.print(formatTime(status.initialFailureTime));
                            pw.print(" lastTime=");
                            pw.println(formatTime(status.lastFailureTime));
                            int errCode;
                            errCode = status.getLastFailureMesgAsInt(0);
                            pw.print("      message: ");
                            pw.println(
                            getLastFailureMessage(errCode) + " (" + errCode + ")");
                        } 
                    } 
                } 
            } 
        } 
        addTaint(pw.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.999 -0400", hash_original_method = "C2F823D43F1684BB9B7871B7A13E4AFA", hash_generated_method = "DCE9069535DCD31724F56B174010582E")
    private String getLastFailureMessage(int code) {
        String varB4EAC82CA7396A68D541C85D26508E83_1244034384 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_626172663 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_820955074 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1862387688 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_552882737 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1346586683 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2059497797 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1738924227 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_712047243 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_1244034384 = "sync already in progress";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_626172663 = "authentication error";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_820955074 = "I/O error";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1862387688 = "parse error";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_552882737 = "conflict error";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1346586683 = "too many deletions error";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_2059497797 = "too many retries error";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1738924227 = "internal error";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_712047243 = "unknown";
        
        addTaint(code);
        String varA7E53CE21691AB073D9660D615818899_283079761; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_283079761 = varB4EAC82CA7396A68D541C85D26508E83_1244034384;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_283079761 = varB4EAC82CA7396A68D541C85D26508E83_626172663;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_283079761 = varB4EAC82CA7396A68D541C85D26508E83_820955074;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_283079761 = varB4EAC82CA7396A68D541C85D26508E83_1862387688;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_283079761 = varB4EAC82CA7396A68D541C85D26508E83_552882737;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_283079761 = varB4EAC82CA7396A68D541C85D26508E83_1346586683;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_283079761 = varB4EAC82CA7396A68D541C85D26508E83_2059497797;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_283079761 = varB4EAC82CA7396A68D541C85D26508E83_1738924227;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_283079761 = varB4EAC82CA7396A68D541C85D26508E83_712047243;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_283079761.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_283079761;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.999 -0400", hash_original_method = "2E5C9A0C484B8BFAAD4FF120631D1FEC", hash_generated_method = "305BB8B34B8D9F46875ED7D3916192AB")
    private void dumpTimeSec(PrintWriter pw, long time) {
        pw.print(time/1000);
        pw.print('.');
        pw.print((time/100)%10);
        pw.print('s');
        addTaint(pw.getTaint());
        addTaint(time);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.000 -0400", hash_original_method = "05C5ECB94ECE9FA6501463D9FF0137FC", hash_generated_method = "0079E1EA045616D2CD87E06DEDCA3328")
    private void dumpDayStatistic(PrintWriter pw, SyncStorageEngine.DayStats ds) {
        pw.print("Success (");
        pw.print(ds.successCount);
        {
            pw.print(" for ");
            dumpTimeSec(pw, ds.successTime);
            pw.print(" avg=");
            dumpTimeSec(pw, ds.successTime/ds.successCount);
        } 
        pw.print(") Failure (");
        pw.print(ds.failureCount);
        {
            pw.print(" for ");
            dumpTimeSec(pw, ds.failureTime);
            pw.print(" avg=");
            dumpTimeSec(pw, ds.failureTime/ds.failureCount);
        } 
        pw.println(")");
        addTaint(pw.getTaint());
        addTaint(ds.getTaint());
        
        
        
        
            
            
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.001 -0400", hash_original_method = "47B1A67BEBB64EEFEE0789183294D0B7", hash_generated_method = "88DE272937D193BBA7929CAACDB2E481")
    protected void dumpSyncHistory(PrintWriter pw) {
        dumpRecentHistory(pw);
        dumpDayStatistics(pw);
        addTaint(pw.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.069 -0400", hash_original_method = "C137DBDBD7D2B9AF348453A35EDAB8EF", hash_generated_method = "C90676E5362D3878136E88697C11EB14")
    private void dumpRecentHistory(PrintWriter pw) {
        final ArrayList<SyncStorageEngine.SyncHistoryItem> items = mSyncStorageEngine.getSyncHistory();
        {
            boolean varDBDD00862D2499954D5577669FA506EB_1765134340 = (items != null && items.size() > 0);
            {
                final Map<String, AuthoritySyncStats> authorityMap = Maps.newHashMap();
                long totalElapsedTime = 0;
                long totalTimes = 0;
                final int N = items.size();
                int maxAuthority = 0;
                int maxAccount = 0;
                {
                    Iterator<SyncStorageEngine.SyncHistoryItem> var0608C6D9DE28EB12D6BAF098F71C2655_831557865 = (items).iterator();
                    var0608C6D9DE28EB12D6BAF098F71C2655_831557865.hasNext();
                    SyncStorageEngine.SyncHistoryItem item = var0608C6D9DE28EB12D6BAF098F71C2655_831557865.next();
                    {
                        SyncStorageEngine.AuthorityInfo authority = mSyncStorageEngine.getAuthority(item.authorityId);
                        String authorityName;
                        String accountKey;
                        {
                            authorityName = authority.authority;
                            accountKey = authority.account.name + "/" + authority.account.type;
                        } 
                        {
                            authorityName = "Unknown";
                            accountKey = "Unknown";
                        } 
                        int length = authorityName.length();
                        {
                            maxAuthority = length;
                        } 
                        length = accountKey.length();
                        {
                            maxAccount = length;
                        } 
                        final long elapsedTime = item.elapsedTime;
                        totalElapsedTime += elapsedTime;
                        AuthoritySyncStats authoritySyncStats = authorityMap.get(authorityName);
                        {
                            authoritySyncStats = new AuthoritySyncStats(authorityName);
                            authorityMap.put(authorityName, authoritySyncStats);
                        } 
                        authoritySyncStats.elapsedTime += elapsedTime;
                        final Map<String, AccountSyncStats> accountMap = authoritySyncStats.accountMap;
                        AccountSyncStats accountSyncStats = accountMap.get(accountKey);
                        {
                            accountSyncStats = new AccountSyncStats(accountKey);
                            accountMap.put(accountKey, accountSyncStats);
                        } 
                        accountSyncStats.elapsedTime += elapsedTime;
                    } 
                } 
                pw.println();
                pw.printf("Detailed Statistics (Recent history):  %d (# of times) %ds (sync time)\n",
                    totalTimes, totalElapsedTime / 1000);
                final List<AuthoritySyncStats> sortedAuthorities = new ArrayList<AuthoritySyncStats>(authorityMap.values());
                Collections.sort(sortedAuthorities, new Comparator<AuthoritySyncStats>() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.066 -0400", hash_original_method = "88424CA43B1F65943C36D332DC119ECC", hash_generated_method = "2DBFC73246CF957E95BAB689E2D2F5D6")
                    @Override
                    public int compare(AuthoritySyncStats lhs, AuthoritySyncStats rhs) {
                        int compare = Integer.compare(rhs.times, lhs.times);
                        {
                            compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                        } 
                        addTaint(lhs.getTaint());
                        addTaint(rhs.getTaint());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342777898 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342777898;
                        
                        
                        
                        
                    
                        
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
                {
                    Iterator<AuthoritySyncStats> var02EEAE14D9E55F5E0A8CF4B94919F1FF_425045328 = (sortedAuthorities).iterator();
                    var02EEAE14D9E55F5E0A8CF4B94919F1FF_425045328.hasNext();
                    AuthoritySyncStats authoritySyncStats = var02EEAE14D9E55F5E0A8CF4B94919F1FF_425045328.next();
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
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.068 -0400", hash_original_method = "CABE0C69E80F76B9C185615742665411", hash_generated_method = "B998E130AEA36A676BF1A50EB1C63D97")
                            @Override
                            public int compare(AccountSyncStats lhs, AccountSyncStats rhs) {
                                int compare = Integer.compare(rhs.times, lhs.times);
                                {
                                    compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                                } 
                                addTaint(lhs.getTaint());
                                addTaint(rhs.getTaint());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327545022 = getTaintInt();
                                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327545022;
                                
                                
                                
                            
                        
                                
                            }
});
                        {
                            Iterator<AccountSyncStats> var5409EB09DA7B117C8E0493FB2F1F1ED9_142161511 = (sortedAccounts).iterator();
                            var5409EB09DA7B117C8E0493FB2F1F1ED9_142161511.hasNext();
                            AccountSyncStats stats = var5409EB09DA7B117C8E0493FB2F1F1ED9_142161511.next();
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
                            } 
                        } 
                        pw.println(separator);
                    } 
                } 
                pw.println();
                pw.println("Recent Sync History");
                final String format = "  %-" + maxAccount + "s  %s\n";
                final Map<String, Long> lastTimeMap = Maps.newHashMap();
                {
                    int i = 0;
                    {
                        SyncStorageEngine.SyncHistoryItem item = items.get(i);
                        SyncStorageEngine.AuthorityInfo authority = mSyncStorageEngine.getAuthority(item.authorityId);
                        String authorityName;
                        String accountKey;
                        {
                            authorityName = authority.authority;
                            accountKey = authority.account.name + "/" + authority.account.type;
                        } 
                        {
                            authorityName = "Unknown";
                            accountKey = "Unknown";
                        } 
                        final long elapsedTime = item.elapsedTime;
                        final Time time = new Time();
                        final long eventTime = item.eventTime;
                        time.set(eventTime);
                        final String key = authorityName + "/" + accountKey;
                        final Long lastEventTime = lastTimeMap.get(key);
                        String diffString;
                        {
                            diffString = "";
                        } 
                        {
                            final long diff = (lastEventTime - eventTime) / 1000;
                            {
                                diffString = String.valueOf(diff);
                            } 
                            {
                                diffString = String.format("%02d:%02d", diff / 60, diff % 60);
                            } 
                            {
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
                        {
                            pw.printf("    event=%d upstreamActivity=%d downstreamActivity=%d\n",
                            item.event,
                            item.upstreamActivity,
                            item.downstreamActivity);
                        } 
                        {
                            boolean varFC5F873EDD9BB5AB47B6562574DA62BF_1155720669 = (item.mesg != null
                        && !SyncStorageEngine.MESG_SUCCESS.equals(item.mesg));
                            {
                                pw.printf("    mesg=%s\n", item.mesg);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(pw.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.070 -0400", hash_original_method = "9349911975C50CB78B5A389074CC1BDC", hash_generated_method = "E1CC200BE7DF6E22310FE16D845BF23E")
    private void dumpDayStatistics(PrintWriter pw) {
        SyncStorageEngine.DayStats dses[] = mSyncStorageEngine.getDayStatistics();
        {
            pw.println();
            pw.println("Sync Statistics");
            pw.print("  Today:  ");
            dumpDayStatistic(pw, dses[0]);
            int today = dses[0].day;
            int i;
            SyncStorageEngine.DayStats ds;
            {
                i=1;
                {
                    ds = dses[i];
                    int delta = today-ds.day;
                    pw.print("  Day-");
                    pw.print(delta);
                    pw.print(":  ");
                    dumpDayStatistic(pw, ds);
                } 
            } 
            int weekDay = today;
            {
                SyncStorageEngine.DayStats aggr = null;
                weekDay -= 7;
                {
                    ds = dses[i];
                    {
                        i = dses.length;
                    } 
                    int delta = weekDay-ds.day;
                    {
                        aggr = new SyncStorageEngine.DayStats(weekDay);
                    } 
                    aggr.successCount += ds.successCount;
                    aggr.successTime += ds.successTime;
                    aggr.failureCount += ds.failureCount;
                    aggr.failureTime += ds.failureTime;
                } 
                {
                    pw.print("  Week-");
                    pw.print((today-weekDay)/7);
                    pw.print(": ");
                    dumpDayStatistic(pw, aggr);
                } 
            } 
        } 
        addTaint(pw.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.075 -0400", hash_original_method = "3A4E555675ED758A699E30DB2B6A1D6C", hash_generated_method = "7BF63828CB5094D72A562DCC5FFD1DAE")
    private boolean isSyncStillActive(ActiveSyncContext activeSyncContext) {
        {
            Iterator<ActiveSyncContext> var38A241656A664BE053973521A7ED258D_1428266560 = (mActiveSyncContexts).iterator();
            var38A241656A664BE053973521A7ED258D_1428266560.hasNext();
            ActiveSyncContext sync = var38A241656A664BE053973521A7ED258D_1428266560.next();
        } 
        addTaint(activeSyncContext.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116593544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116593544;
        
        
            
                
            
        
        
    }

    
    private static class InitializerServiceConnection implements ServiceConnection {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.075 -0400", hash_original_field = "591F77A70FEF1AA3112C01B360A63E9C", hash_generated_field = "3B055C3859C53A8ACDFC59C6C8440DF8")

        private Account mAccount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.075 -0400", hash_original_field = "2325EF4ABFCA50C092A123BB59FD3F59", hash_generated_field = "5E9A5C7D075BBF710B4D594B2F64B868")

        private String mAuthority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.076 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.076 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "D774CCF7C32F86EE269A0C9F9D84415A")

        private volatile Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.076 -0400", hash_original_field = "57006E58594DC862E67D1855FDF16FEE", hash_generated_field = "C96DBD94ABC21BAB3CFD91A494AEBFFE")

        private volatile boolean mInitialized;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.076 -0400", hash_original_method = "24302E8CE101646513826470385452C3", hash_generated_method = "4EBBC72C54610FED0E83FDA081E5EF8C")
        public  InitializerServiceConnection(Account account, String authority, Context context,
                Handler handler) {
            mAccount = account;
            mAuthority = authority;
            mContext = context;
            mHandler = handler;
            mInitialized = false;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.078 -0400", hash_original_method = "9C4A98A4ADBC598450E25E4EB304536B", hash_generated_method = "F9570B3E1B80C03E81B9C0CA1492B7FB")
        public void onServiceConnected(ComponentName name, IBinder service) {
            
            try 
            {
                {
                    mInitialized = true;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1430808347 = (Log.isLoggable(TAG, Log.VERBOSE));
                    } 
                    ISyncAdapter.Stub.asInterface(service).initialize(mAccount, mAuthority);
                } 
            } 
            catch (RemoteException e)
            {
                Log.d(TAG, "error while initializing: " + mAccount + ", authority " + mAuthority,
                        e);
            } 
            finally 
            {
                mHandler.postDelayed(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.077 -0400", hash_original_method = "64817B3D0D58B18C7C47E60B6E5CD293", hash_generated_method = "155839339AFB4ADEC68B1ADFF3B61F2E")
                    public void run() {
                        {
                            mContext.unbindService(InitializerServiceConnection.this);
                            mContext = null;
                        } 
                        
                        
                            
                            
                        
                    }
}, INITIALIZATION_UNBIND_DELAY_MS);
            } 
            addTaint(name.getTaint());
            addTaint(service.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.079 -0400", hash_original_method = "7C8777D718751E565C82B5C1458835CE", hash_generated_method = "956FEBD81C7AB60A87B4B273B50F4D63")
        public void onServiceDisconnected(ComponentName name) {
            
            {
                mContext.unbindService(InitializerServiceConnection.this);
                mContext = null;
            } 
            addTaint(name.getTaint());
            
            
                
                
            
        }

        
    }


    
    class SyncHandlerMessagePayload {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.079 -0400", hash_original_field = "BF45069C4338DFDA77BE2DADD5129FF8", hash_generated_field = "A63DF1A530DF0116354A195B2D61C988")

        public ActiveSyncContext activeSyncContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.079 -0400", hash_original_field = "B59C15B72BC0053AC689D16452610B86", hash_generated_field = "1E280B614C5836CFB973E2780B056065")

        public SyncResult syncResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.080 -0400", hash_original_method = "56E2C68849F116EE41FAA5D226ECBDA3", hash_generated_method = "EB9BF74C5D5609245088D697B7671A62")
          SyncHandlerMessagePayload(ActiveSyncContext syncContext, SyncResult syncResult) {
            this.activeSyncContext = syncContext;
            this.syncResult = syncResult;
            
            
            
        }

        
    }


    
    class SyncAlarmIntentReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.080 -0400", hash_original_method = "8972A0265D0AE4113C769D505643787E", hash_generated_method = "8972A0265D0AE4113C769D505643787E")
        public SyncAlarmIntentReceiver ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.082 -0400", hash_original_method = "B17BCAD698B90432E3978D14A6575096", hash_generated_method = "5BD8AF817AB4808B9D575FFF16CD1C8F")
        public void onReceive(Context context, Intent intent) {
            
            mHandleAlarmWakeLock.acquire();
            sendSyncAlarmMessage();
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
            
        }

        
    }


    
    class ActiveSyncContext extends ISyncContext.Stub implements ServiceConnection, IBinder.DeathRecipient {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.083 -0400", hash_original_field = "3A845A40EB36D8DA4C1C6E7F00D65842", hash_generated_field = "CAEB8FA396F504839F82FDA41F0B6FEA")

        SyncOperation mSyncOperation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.083 -0400", hash_original_field = "FA98B28302F6B5B27D4997F9053E2A6F", hash_generated_field = "506D1AD61A010C0C1665DFBD26F66F91")

        long mHistoryRowId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.083 -0400", hash_original_field = "232767BB513340895CA27CD6CD498671", hash_generated_field = "57DE2857F3D6D189DF99142B1CBC936B")

        ISyncAdapter mSyncAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.083 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")

        long mStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.083 -0400", hash_original_field = "D3BAFEE7AF350B3FE85578E9B0C95F28", hash_generated_field = "2DA32C9B0D6927F8ADE9B98444FE7E93")

        long mTimeoutStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.083 -0400", hash_original_field = "DFE2EB06A7E314F96252E3BC41F2C2EE", hash_generated_field = "E78E5DB82E19559DD5BEFC2040680967")

        boolean mBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.083 -0400", hash_original_field = "B4284F499642B7038AEABE600507F363", hash_generated_field = "40DA6E2B4575B8523B863BAC87FE141E")

        PowerManager.WakeLock mSyncWakeLock;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.083 -0400", hash_original_field = "1A19E5DBB7DA8A675E5D447716B9C520", hash_generated_field = "2C18D3EE7F9C970AA993762D01A316E3")

        int mSyncAdapterUid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.083 -0400", hash_original_field = "B4DD88CF987D9FC7C9A0015AB85FA859", hash_generated_field = "D364355005B405C007FFCAD9043FC337")

        SyncInfo mSyncInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.083 -0400", hash_original_field = "FC2DEDF201972A37F09CA72F6C2310F6", hash_generated_field = "468C40F467A1821737E93795346B1787")

        boolean mIsLinkedToDeath = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.084 -0400", hash_original_method = "FBEF152C2B412533A606ADB2B9DA9D2A", hash_generated_method = "950920857408DB20FD03968FDF4D12D7")
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
            
            
            
            
            
            
            
            
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.084 -0400", hash_original_method = "7456DA1EA096E82DD762DA299B1797D3", hash_generated_method = "540CBBFBA53CA8CE698C636F326A356D")
        public void sendHeartbeat() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.085 -0400", hash_original_method = "2741CA480AE203CDFD1BCCBB420C487D", hash_generated_method = "DC9C4DBF7DABB67996D2F707E0092881")
        public void onFinished(SyncResult result) {
            
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1917597865 = (Log.isLoggable(TAG, Log.VERBOSE));
            } 
            sendSyncFinishedOrCanceledMessage(this, result);
            addTaint(result.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.087 -0400", hash_original_method = "EB9B131EDBEF0858B3038B79ABC0948E", hash_generated_method = "5C20A4350B214EDF4FCD147F5BBB3851")
        public void toString(StringBuilder sb) {
            sb.append("startTime ").append(mStartTime)
                    .append(", mTimeoutStartTime ").append(mTimeoutStartTime)
                    .append(", mHistoryRowId ").append(mHistoryRowId)
                    .append(", syncOperation ").append(mSyncOperation);
            addTaint(sb.getTaint());
            
            
                    
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.087 -0400", hash_original_method = "CBDE36ABE821F23EF1CFAFB665E67134", hash_generated_method = "71CD2C8E4137441F5B70F914040D11B0")
        public void onServiceConnected(ComponentName name, IBinder service) {
            
            Message msg = mSyncHandler.obtainMessage();
            msg.what = SyncHandler.MESSAGE_SERVICE_CONNECTED;
            msg.obj = new ServiceConnectionData(this, ISyncAdapter.Stub.asInterface(service));
            mSyncHandler.sendMessage(msg);
            addTaint(name.getTaint());
            addTaint(service.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.088 -0400", hash_original_method = "E604348BDB0F3F95B7C0274B0D40964D", hash_generated_method = "8A2C13413E867BDEC53650A9338C542B")
        public void onServiceDisconnected(ComponentName name) {
            
            Message msg = mSyncHandler.obtainMessage();
            msg.what = SyncHandler.MESSAGE_SERVICE_DISCONNECTED;
            msg.obj = new ServiceConnectionData(this, null);
            mSyncHandler.sendMessage(msg);
            addTaint(name.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.089 -0400", hash_original_method = "79606510FDB8502633B50F75722531BD", hash_generated_method = "34D6E5CBA01FFCFF100AC85B45861836")
         boolean bindToSyncAdapter(RegisteredServicesCache.ServiceInfo info) {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1639981126 = (Log.isLoggable(TAG, Log.VERBOSE));
                {
                    Log.d(TAG, "bindToSyncAdapter: " + info.componentName + ", connection " + this);
                } 
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
            {
                mBound = false;
            } 
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1603574288 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1603574288;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.090 -0400", hash_original_method = "BCACA708B6725C3BB29ED8DCC5E23FC1", hash_generated_method = "A9ED89F0E27852AC1FC7A305E9624E16")
        protected void close() {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1529155468 = (Log.isLoggable(TAG, Log.VERBOSE));
                {
                    Log.d(TAG, "unBindFromSyncAdapter: connection " + this);
                } 
            } 
            {
                mBound = false;
                mContext.unbindService(this);
            } 
            mSyncWakeLock.release();
            mSyncWakeLock.setWorkSource(null);
            
            
                
            
            
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.093 -0400", hash_original_method = "C99E9A460C6F28DBA730EF38203534A2", hash_generated_method = "2F5A354818CAB6A02ECE34C11512BC4F")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1457668370 = null; 
            StringBuilder sb = new StringBuilder();
            toString(sb);
            varB4EAC82CA7396A68D541C85D26508E83_1457668370 = sb.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1457668370.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1457668370;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.094 -0400", hash_original_method = "A39B4ABAEA9F27E501EB3B3EC7A37B2F", hash_generated_method = "A3A778C314C37C4C18C58B6CB51701C4")
        @Override
        public void binderDied() {
            sendSyncFinishedOrCanceledMessage(this, null);
            
            
        }

        
    }


    
    private static class AuthoritySyncStats {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.094 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.094 -0400", hash_original_field = "DAD566B38C7C4C71D805927E9FFF2732", hash_generated_field = "019980784258B693231C7932844AF0BC")

        long elapsedTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.094 -0400", hash_original_field = "F2B798F672D4B42C0359CED11D4F10CD", hash_generated_field = "3A95A04ECEF69E80207E92842B01313D")

        int times;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.095 -0400", hash_original_field = "8824EC82F0C16A8A1279E45AA6570F81", hash_generated_field = "F30C35077CC725990FFE0E1D8AA05301")

        Map<String, AccountSyncStats> accountMap = Maps.newHashMap();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.095 -0400", hash_original_method = "BA2AD08D9B4BF110732C8291C5F36CF8", hash_generated_method = "8FA9C8631A53370375CA7123AE4AF077")
        private  AuthoritySyncStats(String name) {
            this.name = name;
            
            
        }

        
    }


    
    private static class AccountSyncStats {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.095 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.096 -0400", hash_original_field = "DAD566B38C7C4C71D805927E9FFF2732", hash_generated_field = "019980784258B693231C7932844AF0BC")

        long elapsedTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.096 -0400", hash_original_field = "F2B798F672D4B42C0359CED11D4F10CD", hash_generated_field = "3A95A04ECEF69E80207E92842B01313D")

        int times;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.096 -0400", hash_original_method = "1D94286E4C9E35DF248CEA39D6389F91", hash_generated_method = "F1AB1770EB048E4049FC1577D48B72D8")
        private  AccountSyncStats(String name) {
            this.name = name;
            
            
        }

        
    }


    
    private class SyncTimeTracker {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.096 -0400", hash_original_field = "81F2D2CA0AD2344A53D31A86CCF4832E", hash_generated_field = "462785F9BDC050A0984AB02796F85FBF")

        boolean mLastWasSyncing = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.097 -0400", hash_original_field = "C843120669F045C7E7FE9574A72CDFD6", hash_generated_field = "42BA20EF7800084DF8B05592B8E3E7BE")

        long mWhenSyncStarted = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.097 -0400", hash_original_field = "0D9C24F156A3536C5438C75FBA0A7760", hash_generated_field = "2B002605222CEDCD3A05F1765E34CF80")

        private long mTimeSpentSyncing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.097 -0400", hash_original_method = "5641FE5F8977FB94C61AEE76E9EBD2B2", hash_generated_method = "5641FE5F8977FB94C61AEE76E9EBD2B2")
        public SyncTimeTracker ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.097 -0400", hash_original_method = "3978D6C321E5167908096EFEB475874E", hash_generated_method = "738669C95F74F8EEABC71F0B1FCBCF06")
        public synchronized void update() {
            final boolean isSyncInProgress = !mActiveSyncContexts.isEmpty();
            final long now = SystemClock.elapsedRealtime();
            {
                mWhenSyncStarted = now;
            } 
            {
                mTimeSpentSyncing += now - mWhenSyncStarted;
            } 
            mLastWasSyncing = isSyncInProgress;
            
            
            
            
            
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.098 -0400", hash_original_method = "73972E33AC37B98D757DD1126931E451", hash_generated_method = "A0E575E7D6795043EDF4A3364BF1EF91")
        public synchronized long timeSpentSyncing() {
            final long now = SystemClock.elapsedRealtime();
            long var0F5264038205EDFB1AC05FBB0E8C5E94_985720952 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_985720952;
            
            
            
            
        }

        
    }


    
    class ServiceConnectionData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.098 -0400", hash_original_field = "BF45069C4338DFDA77BE2DADD5129FF8", hash_generated_field = "A63DF1A530DF0116354A195B2D61C988")

        public ActiveSyncContext activeSyncContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.098 -0400", hash_original_field = "77C3125B03213AA40E0DE7116B3CF093", hash_generated_field = "C583279FC3521EE740A066A3F5FFA86D")

        public ISyncAdapter syncAdapter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.099 -0400", hash_original_method = "CF4E9A067E77243E4BB7B7FFBE17CC6D", hash_generated_method = "2A0BDD0F3B16155915070F3871A6CD3F")
          ServiceConnectionData(ActiveSyncContext activeSyncContext, ISyncAdapter syncAdapter) {
            this.activeSyncContext = activeSyncContext;
            this.syncAdapter = syncAdapter;
            
            
            
        }

        
    }


    
    class SyncHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.100 -0400", hash_original_field = "3EB3C1A4116A4EB53B758AE0763418BF", hash_generated_field = "1599D96A237A164A880FFE88C1C3EE7C")

        public final SyncNotificationInfo mSyncNotificationInfo = new SyncNotificationInfo();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.100 -0400", hash_original_field = "F4AC20FF2B0D9B9001095C466DD1B77E", hash_generated_field = "0C75AEF43A0C9FFA242F4986360329AE")

        private Long mAlarmScheduleTime = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.100 -0400", hash_original_field = "D303E2362A0CCEFF2175ABCFFA7F631D", hash_generated_field = "D1BE6D0FAF2F6FBF2B9D20FDC62CD03D")

        public final SyncTimeTracker mSyncTimeTracker = new SyncTimeTracker();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.100 -0400", hash_original_field = "AAD4F16B34370A021E0CB4C912ACE611", hash_generated_field = "2F89F9D45AD779522DB295A0D1595A30")

        private final HashMap<Pair<Account, String>, PowerManager.WakeLock> mWakeLocks = Maps.newHashMap();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.100 -0400", hash_original_field = "DDAD6CB2080EECA658633769B438411A", hash_generated_field = "28D2205C6B63956ABF9398C7BB3353C2")

        private volatile CountDownLatch mReadyToRunLatch = new CountDownLatch(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.102 -0400", hash_original_method = "483F6356A2D06E95B4EBFBB05049FAB5", hash_generated_method = "2554A8ECD9A719B3BF2C53204C68C88D")
        public  SyncHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.103 -0400", hash_original_method = "A4C54FCCA01900F2BC7EC8A1E7F40380", hash_generated_method = "F8871811763F0C577983C96491676F31")
        public void onBootCompleted() {
            
            mBootCompleted = true;
            mSyncStorageEngine.doDatabaseCleanup(AccountManager.get(mContext).getAccounts());
            {
                mReadyToRunLatch.countDown();
            } 
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.105 -0400", hash_original_method = "F60450395CB7370B81745EFD5F3059FF", hash_generated_method = "0E0B1C6B806454F5AA15B8F2DAB6C147")
        private PowerManager.WakeLock getSyncWakeLock(Account account, String authority) {
            PowerManager.WakeLock varB4EAC82CA7396A68D541C85D26508E83_623760980 = null; 
            final Pair<Account, String> wakeLockKey = Pair.create(account, authority);
            PowerManager.WakeLock wakeLock = mWakeLocks.get(wakeLockKey);
            {
                final String name = SYNC_WAKE_LOCK_PREFIX + "_" + authority + "_" + account;
                wakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, name);
                wakeLock.setReferenceCounted(false);
                mWakeLocks.put(wakeLockKey, wakeLock);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_623760980 = wakeLock;
            addTaint(account.getTaint());
            addTaint(authority.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_623760980.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_623760980;
            
            
            
            
                
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.106 -0400", hash_original_method = "CE8AE663CA89CC7DD7AABF796BC60E1D", hash_generated_method = "4381DBE9748CC8ED2083F37D611060D0")
        private void waitUntilReadyToRun() {
            CountDownLatch latch = mReadyToRunLatch;
            {
                {
                    try 
                    {
                        latch.await();
                        mReadyToRunLatch = null;
                    } 
                    catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    } 
                } 
            } 
            
            
            
                
                    
                        
                        
                        
                    
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.108 -0400", hash_original_method = "AC98BBE28F5005D2D34EEDF919BF395C", hash_generated_method = "DA00B71E528041238B05464041229EF3")
        public void handleMessage(Message msg) {
            long earliestFuturePollTime = Long.MAX_VALUE;
            long nextPendingSyncTime = Long.MAX_VALUE;
            try 
            {
                waitUntilReadyToRun();
                mDataConnectionIsConnected = readDataConnectionState();
                mSyncManagerWakeLock.acquire();
                earliestFuturePollTime = scheduleReadyPeriodicSyncs();
                
                {
                    Pair<Account, String> payload = (Pair<Account, String>)msg.obj;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_409700692 = (Log.isLoggable(TAG, Log.VERBOSE));
                        {
                            Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_CANCEL: "
                                    + payload.first + ", " + payload.second);
                        } 
                    } 
                    cancelActiveSyncLocked(payload.first, payload.second);
                    nextPendingSyncTime = maybeStartNextSyncLocked();
                } 
                
                
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1063891008 = (Log.isLoggable(TAG, Log.VERBOSE));
                } 
                
                
                SyncHandlerMessagePayload payload = (SyncHandlerMessagePayload)msg.obj;
                
                
                {
                    boolean varBA2B30809006AC87B4F9ED60448095E9_1235335478 = (!isSyncStillActive(payload.activeSyncContext));
                    {
                        Log.d(TAG, "handleSyncHandlerMessage: dropping since the "
                                    + "sync is no longer active: "
                                    + payload.activeSyncContext);
                    } 
                } 
                
                
                runSyncFinishedOrCanceledLocked(payload.syncResult, payload.activeSyncContext);
                
                
                nextPendingSyncTime = maybeStartNextSyncLocked();
                
                
                {
                    ServiceConnectionData msgData = (ServiceConnectionData)msg.obj;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_82906859 = (Log.isLoggable(TAG, Log.VERBOSE));
                        {
                            Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_CONNECTED: "
                                    + msgData.activeSyncContext);
                        } 
                    } 
                    {
                        boolean varC7FD95DDD2260EADDB8E624A9C0825F6_1341033206 = (isSyncStillActive(msgData.activeSyncContext));
                        {
                            runBoundToSyncAdapter(msgData.activeSyncContext, msgData.syncAdapter);
                        } 
                    } 
                } 
                
                
                {
                    final ActiveSyncContext currentSyncContext = ((ServiceConnectionData)msg.obj).activeSyncContext;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1513835375 = (Log.isLoggable(TAG, Log.VERBOSE));
                        {
                            Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_DISCONNECTED: "
                                    + currentSyncContext);
                        } 
                    } 
                    {
                        boolean var8ABF090AC2884C22D7C7551D49051447_1029986470 = (isSyncStillActive(currentSyncContext));
                        {
                            {
                                try 
                                {
                                    currentSyncContext.mSyncAdapter.cancelSync(currentSyncContext);
                                } 
                                catch (RemoteException e)
                                { }
                            } 
                            SyncResult syncResult = new SyncResult();
                            runSyncFinishedOrCanceledLocked(syncResult, currentSyncContext);
                            nextPendingSyncTime = maybeStartNextSyncLocked();
                        } 
                    } 
                } 
                
                
                {
                    boolean isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
                    mAlarmScheduleTime = null;
                    try 
                    {
                        nextPendingSyncTime = maybeStartNextSyncLocked();
                    } 
                    finally 
                    {
                        mHandleAlarmWakeLock.release();
                    } 
                } 
                
                
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_98033802 = (Log.isLoggable(TAG, Log.VERBOSE));
                } 
                
                
                nextPendingSyncTime = maybeStartNextSyncLocked();
                
            } 
            finally 
            {
                manageSyncNotificationLocked();
                manageSyncAlarmLocked(earliestFuturePollTime, nextPendingSyncTime);
                mSyncTimeTracker.update();
                mSyncManagerWakeLock.release();
            } 
            addTaint(msg.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.112 -0400", hash_original_method = "5F18B995A8D5126079C876CBB8B37FF8", hash_generated_method = "1D7413F564239CDAEB826AF553EF4CAC")
        private long scheduleReadyPeriodicSyncs() {
            final boolean backgroundDataUsageAllowed = getConnectivityManager().getBackgroundDataSetting();
            long earliestFuturePollTime = Long.MAX_VALUE;
            {
                boolean varC4F9DD6A708570A0C749B94E2E7FDF0F_120528911 = (!backgroundDataUsageAllowed || !mSyncStorageEngine.getMasterSyncAutomatically());
            } 
            final long nowAbsolute = System.currentTimeMillis();
            ArrayList<SyncStorageEngine.AuthorityInfo> infos = mSyncStorageEngine.getAuthorities();
            {
                Iterator<SyncStorageEngine.AuthorityInfo> varC4FCEB1607AD0D2D215FDDD8362DAF36_1164681720 = (infos).iterator();
                varC4FCEB1607AD0D2D215FDDD8362DAF36_1164681720.hasNext();
                SyncStorageEngine.AuthorityInfo info = varC4FCEB1607AD0D2D215FDDD8362DAF36_1164681720.next();
                {
                    {
                        boolean var4F72312E8BC45601DFFBAD51C30C06F1_199425709 = (!ArrayUtils.contains(mAccounts, info.account));
                    } 
                    {
                        boolean var41663A909D23D063D4B5AFBCA7A8A368_1501379313 = (!mSyncStorageEngine.getSyncAutomatically(info.account, info.authority));
                    } 
                    {
                        boolean varBF1A825481B58DFD24124DB4EE59FE57_1774184902 = (mSyncStorageEngine.getIsSyncable(info.account, info.authority) == 0);
                    } 
                    SyncStatusInfo status = mSyncStorageEngine.getOrCreateSyncStatus(info);
                    {
                        int i = 0;
                        int N = info.periodicSyncs.size();
                        {
                            final Bundle extras = info.periodicSyncs.get(i).first;
                            final Long periodInSeconds = info.periodicSyncs.get(i).second;
                            final long lastPollTimeAbsolute = status.getPeriodicSyncTime(i);
                            long nextPollTimeAbsolute;
                            nextPollTimeAbsolute = nowAbsolute;
                            nextPollTimeAbsolute = lastPollTimeAbsolute + periodInSeconds * 1000;
                            {
                                final Pair<Long, Long> backoff = mSyncStorageEngine.getBackoff(info.account, info.authority);
                                final RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = mSyncAdapters.getServiceInfo(
                                        SyncAdapterType.newKey(info.authority, info.account.type));
                                scheduleSyncOperation(
                                new SyncOperation(info.account, SyncStorageEngine.SOURCE_PERIODIC,
                                        info.authority, extras, 0 ,
                                        backoff != null ? backoff.first : 0,
                                        mSyncStorageEngine.getDelayUntilTime(
                                                info.account, info.authority),
                                        syncAdapterInfo.type.allowParallelSyncs()));
                                status.setPeriodicSyncTime(i, nowAbsolute);
                            } 
                            {
                                {
                                    earliestFuturePollTime = nextPollTimeAbsolute;
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            long var377A5C4AB2ECC9D2ABC9EC45C6319817_69152077 = (SystemClock.elapsedRealtime()
                    + ((earliestFuturePollTime < nowAbsolute)
                      ? 0
                      : (earliestFuturePollTime - nowAbsolute))); 
            long var0F5264038205EDFB1AC05FBB0E8C5E94_2124183964 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2124183964;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.118 -0400", hash_original_method = "8B5418D48FBDFB608CDA80C6788E1356", hash_generated_method = "81EAE5C89C978BDC2D7548C8F0285B34")
        private long maybeStartNextSyncLocked() {
            final boolean isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
            Account[] accounts = mAccounts;
            final boolean backgroundDataUsageAllowed = getConnectivityManager().getBackgroundDataSetting();
            final boolean masterSyncAutomatically = mSyncStorageEngine.getMasterSyncAutomatically();
            final long now = SystemClock.elapsedRealtime();
            long nextReadyToRunTime = Long.MAX_VALUE;
            ArrayList<SyncOperation> operations = new ArrayList<SyncOperation>();
            {
                Iterator<SyncOperation> operationIterator = mSyncQueue.mOperationsMap.values().iterator();
                {
                    boolean var340C1D4D9E1D2C91EE6FE9A98B7CEC0B_1151378593 = (operationIterator.hasNext());
                    {
                        final SyncOperation op = operationIterator.next();
                        {
                            boolean var9DF7D9069DE48617930394A60905575E_2036850193 = (!ArrayUtils.contains(mAccounts, op.account));
                            {
                                operationIterator.remove();
                                mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                            } 
                        } 
                        int syncableState = mSyncStorageEngine.getIsSyncable(op.account, op.authority);
                        {
                            operationIterator.remove();
                            mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                        } 
                        {
                            {
                                nextReadyToRunTime = op.effectiveRunTime;
                            } 
                        } 
                        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo;
                        syncAdapterInfo = mSyncAdapters.getServiceInfo(
                            SyncAdapterType.newKey(op.authority, op.account.type));
                        boolean uidNetworkConnected;
                        {
                            final NetworkInfo networkInfo = getConnectivityManager()
                                .getActiveNetworkInfoForUid(syncAdapterInfo.uid);
                            uidNetworkConnected = networkInfo != null && networkInfo.isConnected();
                        } 
                        {
                            uidNetworkConnected = false;
                        } 
                        {
                            boolean var5A423FA495D65808CF647D9D5D5D33E5_1476024175 = (!op.extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, false)
                            && (syncableState > 0)
                            && (!masterSyncAutomatically
                                || !backgroundDataUsageAllowed
                                || !uidNetworkConnected
                                || !mSyncStorageEngine.getSyncAutomatically(
                                       op.account, op.authority)));
                            {
                                operationIterator.remove();
                                mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                            } 
                        } 
                        operations.add(op);
                    } 
                } 
            } 
            Collections.sort(operations);
            {
                int i = 0;
                int N = operations.size();
                {
                    final SyncOperation candidate = operations.get(i);
                    final boolean candidateIsInitialization = candidate.isInitialization();
                    int numInit = 0;
                    int numRegular = 0;
                    ActiveSyncContext conflict = null;
                    ActiveSyncContext longRunning = null;
                    ActiveSyncContext toReschedule = null;
                    {
                        Iterator<ActiveSyncContext> var20645BE964392164F6E4174B19EE47A5_1975631915 = (mActiveSyncContexts).iterator();
                        var20645BE964392164F6E4174B19EE47A5_1975631915.hasNext();
                        ActiveSyncContext activeSyncContext = var20645BE964392164F6E4174B19EE47A5_1975631915.next();
                        {
                            final SyncOperation activeOp = activeSyncContext.mSyncOperation;
                            {
                                boolean var88156E87F289A86AB7CC4C7CE0A7364C_1045137318 = (activeOp.isInitialization());
                            } 
                            {
                                boolean var3BD76041BE9F72E30B119A23228D3264_2117448197 = (activeOp.account.type.equals(candidate.account.type)
                            && activeOp.authority.equals(candidate.authority)
                            && (!activeOp.allowParallelSyncs
                                || activeOp.account.name.equals(candidate.account.name)));
                                {
                                    conflict = activeSyncContext;
                                } 
                                {
                                    {
                                        boolean var79DB07D9BA6372A590E984F48C84F69B_740985286 = (candidateIsInitialization == activeOp.isInitialization()
                                && activeSyncContext.mStartTime + MAX_TIME_PER_SYNC < now);
                                        {
                                            longRunning = activeSyncContext;
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                    {
                        {
                            boolean varD6CAC9C6C357DD6052AAB1ED368A7093_1415209512 = (candidateIsInitialization && !conflict.mSyncOperation.isInitialization()
                            && numInit < MAX_SIMULTANEOUS_INITIALIZATION_SYNCS);
                            {
                                toReschedule = conflict;
                                {
                                    boolean varB886653DBE5AD63346733F0FC6D36E19_499782583 = (Log.isLoggable(TAG, Log.VERBOSE));
                                } 
                            } 
                            {
                                boolean varEBD4A65C44B5C00E1C33A1C6DE2B79F3_1964847736 = (candidate.expedited && !conflict.mSyncOperation.expedited
                            && (candidateIsInitialization
                                == conflict.mSyncOperation.isInitialization()));
                                {
                                    toReschedule = conflict;
                                    {
                                        boolean varCF8461C47EF234EA3373DC7BC06410EC_1100954872 = (Log.isLoggable(TAG, Log.VERBOSE));
                                    } 
                                } 
                            } 
                        } 
                    } 
                    {
                        boolean roomAvailable;
                        roomAvailable = numInit < MAX_SIMULTANEOUS_INITIALIZATION_SYNCS;
                        roomAvailable = numRegular < MAX_SIMULTANEOUS_REGULAR_SYNCS;
                        {
                            boolean var2AB44D382A887D969D31457896E79E6B_1091420324 = (longRunning != null
                            && (candidateIsInitialization
                                == longRunning.mSyncOperation.isInitialization()));
                            {
                                toReschedule = longRunning;
                                {
                                    boolean varB886653DBE5AD63346733F0FC6D36E19_1983725297 = (Log.isLoggable(TAG, Log.VERBOSE));
                                } 
                            } 
                        } 
                    } 
                    {
                        runSyncFinishedOrCanceledLocked(null, toReschedule);
                        scheduleSyncOperation(toReschedule.mSyncOperation);
                    } 
                    {
                        mSyncQueue.remove(candidate);
                    } 
                    dispatchSyncOperation(candidate);
                } 
            } 
            long var0F5264038205EDFB1AC05FBB0E8C5E94_136199213 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_136199213;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.121 -0400", hash_original_method = "40340E62514BC19DB7E9216642814F86", hash_generated_method = "3C00D5D7760B3535820D9F7C94C77ADC")
        private boolean dispatchSyncOperation(SyncOperation op) {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_545768643 = (Log.isLoggable(TAG, Log.VERBOSE));
                {
                    {
                        Iterator<ActiveSyncContext> varBCD99CACB997EB3D1458946CDF6FE790_865756513 = (mActiveSyncContexts).iterator();
                        varBCD99CACB997EB3D1458946CDF6FE790_865756513.hasNext();
                        ActiveSyncContext syncContext = varBCD99CACB997EB3D1458946CDF6FE790_865756513.next();
                    } 
                } 
            } 
            SyncAdapterType syncAdapterType = SyncAdapterType.newKey(op.authority, op.account.type);
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = mSyncAdapters.getServiceInfo(syncAdapterType);
            {
                Log.d(TAG, "can't find a sync adapter for " + syncAdapterType
                        + ", removing settings for it");
                mSyncStorageEngine.removeAuthority(op.account, op.authority);
            } 
            ActiveSyncContext activeSyncContext = new ActiveSyncContext(op, insertStartSyncEvent(op), syncAdapterInfo.uid);
            activeSyncContext.mSyncInfo = mSyncStorageEngine.addActiveSync(activeSyncContext);
            mActiveSyncContexts.add(activeSyncContext);
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1483680569 = (Log.isLoggable(TAG, Log.VERBOSE));
            } 
            {
                boolean var689CF975CE88D03CB21DEFF3F17DC74D_156925275 = (!activeSyncContext.bindToSyncAdapter(syncAdapterInfo));
                {
                    closeActiveSyncContext(activeSyncContext);
                } 
            } 
            addTaint(op.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821603222 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_821603222;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.122 -0400", hash_original_method = "61AEAAC860377C6ACC1D13743DAD80A2", hash_generated_method = "55335F5379BE3BBF4DC04500B1A217D4")
        private void runBoundToSyncAdapter(final ActiveSyncContext activeSyncContext,
              ISyncAdapter syncAdapter) {
            activeSyncContext.mSyncAdapter = syncAdapter;
            final SyncOperation syncOperation = activeSyncContext.mSyncOperation;
            try 
            {
                activeSyncContext.mIsLinkedToDeath = true;
                syncAdapter.asBinder().linkToDeath(activeSyncContext, 0);
                syncAdapter.startSync(activeSyncContext, syncOperation.authority,
                        syncOperation.account, syncOperation.extras);
            } 
            catch (RemoteException remoteExc)
            {
                Log.d(TAG, "maybeStartNextSync: caught a RemoteException, rescheduling", remoteExc);
                closeActiveSyncContext(activeSyncContext);
                increaseBackoffSetting(syncOperation);
                scheduleSyncOperation(new SyncOperation(syncOperation));
            } 
            catch (RuntimeException exc)
            {
                closeActiveSyncContext(activeSyncContext);
            } 
            addTaint(activeSyncContext.getTaint());
            addTaint(syncAdapter.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.127 -0400", hash_original_method = "7B28CEC882EFEBA05BFBBAFD319121EA", hash_generated_method = "AA0DE2354D2AC4F912EBA66BCDF1097F")
        private void cancelActiveSyncLocked(Account account, String authority) {
            ArrayList<ActiveSyncContext> activeSyncs = new ArrayList<ActiveSyncContext>(mActiveSyncContexts);
            {
                Iterator<ActiveSyncContext> varAAAC086D3900935D623B1369638ED0DB_2006961918 = (activeSyncs).iterator();
                varAAAC086D3900935D623B1369638ED0DB_2006961918.hasNext();
                ActiveSyncContext activeSyncContext = varAAAC086D3900935D623B1369638ED0DB_2006961918.next();
                {
                    {
                        {
                            {
                                boolean var8037C8DE9F4E8AA58BB79ADB5D51F3E6_407850081 = (!account.equals(activeSyncContext.mSyncOperation.account));
                            } 
                        } 
                        {
                            {
                                boolean varF9430EBD0568960E5EAFBC08F8B701A4_919217660 = (!authority.equals(activeSyncContext.mSyncOperation.authority));
                            } 
                        } 
                        runSyncFinishedOrCanceledLocked(null ,
                            activeSyncContext);
                    } 
                } 
            } 
            addTaint(account.getTaint());
            addTaint(authority.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.128 -0400", hash_original_method = "8D8637124BC010FEF841826099E3536E", hash_generated_method = "F8B16AF3F21914CBAC56D254C17450EF")
        private void runSyncFinishedOrCanceledLocked(SyncResult syncResult,
                ActiveSyncContext activeSyncContext) {
            boolean isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
            {
                activeSyncContext.mSyncAdapter.asBinder().unlinkToDeath(activeSyncContext, 0);
                activeSyncContext.mIsLinkedToDeath = false;
            } 
            closeActiveSyncContext(activeSyncContext);
            final SyncOperation syncOperation = activeSyncContext.mSyncOperation;
            final long elapsedTime = SystemClock.elapsedRealtime() - activeSyncContext.mStartTime;
            String historyMessage;
            int downstreamActivity;
            int upstreamActivity;
            {
                {
                    boolean var3966D9B0F8863425CFD3A0BE46FDBEF6_725494253 = (!syncResult.hasError());
                    {
                        historyMessage = SyncStorageEngine.MESG_SUCCESS;
                        downstreamActivity = 0;
                        upstreamActivity = 0;
                        clearBackoffSetting(syncOperation);
                    } 
                    {
                        Log.d(TAG, "failed sync operation " + syncOperation + ", " + syncResult);
                        {
                            increaseBackoffSetting(syncOperation);
                        } 
                        maybeRescheduleSync(syncResult, syncOperation);
                        historyMessage = Integer.toString(syncResultToErrorNumber(syncResult));
                        downstreamActivity = 0;
                        upstreamActivity = 0;
                    } 
                } 
                setDelayUntilTime(syncOperation, syncResult.delayUntil);
            } 
            {
                {
                    try 
                    {
                        activeSyncContext.mSyncAdapter.cancelSync(activeSyncContext);
                    } 
                    catch (RemoteException e)
                    { }
                } 
                historyMessage = SyncStorageEngine.MESG_CANCELED;
                downstreamActivity = 0;
                upstreamActivity = 0;
            } 
            stopSyncEvent(activeSyncContext.mHistoryRowId, syncOperation, historyMessage,
                    upstreamActivity, downstreamActivity, elapsedTime);
            {
                installHandleTooManyDeletesNotification(syncOperation.account,
                        syncOperation.authority, syncResult.stats.numDeletes);
            } 
            {
                mNotificationMgr.cancel(
                        syncOperation.account.hashCode() ^ syncOperation.authority.hashCode());
            } 
            {
                scheduleSyncOperation(new SyncOperation(syncOperation.account,
                        syncOperation.syncSource, syncOperation.authority, new Bundle(), 0,
                        syncOperation.backoff, syncOperation.delayUntil,
                        syncOperation.allowParallelSyncs));
            } 
            addTaint(syncResult.getTaint());
            addTaint(activeSyncContext.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.129 -0400", hash_original_method = "1880B76D7799B7E884F5DD7B88555973", hash_generated_method = "B192F76D3A39266E07FFB036D962CED8")
        private void closeActiveSyncContext(ActiveSyncContext activeSyncContext) {
            activeSyncContext.close();
            mActiveSyncContexts.remove(activeSyncContext);
            mSyncStorageEngine.removeActiveSync(activeSyncContext.mSyncInfo);
            addTaint(activeSyncContext.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.130 -0400", hash_original_method = "F73ADCF1F7F7E573F488FB12A7E0DEC9", hash_generated_method = "C6E040D99389650019341294D1F490DB")
        private int syncResultToErrorNumber(SyncResult syncResult) {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("we are not in an error state, " + syncResult);
            addTaint(syncResult.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294898223 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294898223;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.133 -0400", hash_original_method = "D7164ED4506DE94304BF76B0FBC03583", hash_generated_method = "E99BCFE1BCC50B20358946A5340E8E15")
        private void manageSyncNotificationLocked() {
            boolean shouldCancel;
            boolean shouldInstall;
            {
                boolean var81ED16291C5BDEEB678C6A2565F01300_598105597 = (mActiveSyncContexts.isEmpty());
                {
                    mSyncNotificationInfo.startTime = null;
                    shouldCancel = mSyncNotificationInfo.isActive;
                    shouldInstall = false;
                } 
                {
                    final long now = SystemClock.elapsedRealtime();
                    {
                        mSyncNotificationInfo.startTime = now;
                    } 
                    {
                        shouldInstall = shouldCancel = false;
                    } 
                    {
                        shouldCancel = false;
                        final boolean timeToShowNotification = now > mSyncNotificationInfo.startTime + SYNC_NOTIFICATION_DELAY;
                        {
                            shouldInstall = true;
                        } 
                        {
                            shouldInstall = false;
                            {
                                Iterator<ActiveSyncContext> var20645BE964392164F6E4174B19EE47A5_682758132 = (mActiveSyncContexts).iterator();
                                var20645BE964392164F6E4174B19EE47A5_682758132.hasNext();
                                ActiveSyncContext activeSyncContext = var20645BE964392164F6E4174B19EE47A5_682758132.next();
                                {
                                    final boolean manualSync = activeSyncContext.mSyncOperation.extras
                                    .getBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, false);
                                    {
                                        shouldInstall = true;
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                mNeedSyncActiveNotification = false;
                sendSyncStateIntent();
                mSyncNotificationInfo.isActive = false;
            } 
            {
                mNeedSyncActiveNotification = true;
                sendSyncStateIntent();
                mSyncNotificationInfo.isActive = true;
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.138 -0400", hash_original_method = "E1B88EC7C887370D571018E17194D40D", hash_generated_method = "429298C19A4D607BE0F687175DAA2482")
        private void manageSyncAlarmLocked(long nextPeriodicEventElapsedTime,
                long nextPendingEventElapsedTime) {
            long notificationTime;
            notificationTime = mSyncHandler.mSyncNotificationInfo.startTime + SYNC_NOTIFICATION_DELAY;
            notificationTime = Long.MAX_VALUE;
            long earliestTimeoutTime = Long.MAX_VALUE;
            {
                Iterator<ActiveSyncContext> varB42644AE74A51E951ED6AB5DD20DA8CE_2059721985 = (mActiveSyncContexts).iterator();
                varB42644AE74A51E951ED6AB5DD20DA8CE_2059721985.hasNext();
                ActiveSyncContext currentSyncContext = varB42644AE74A51E951ED6AB5DD20DA8CE_2059721985.next();
                {
                    final long currentSyncTimeoutTime = currentSyncContext.mTimeoutStartTime + MAX_TIME_PER_SYNC;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1809316512 = (Log.isLoggable(TAG, Log.VERBOSE));
                    } 
                    {
                        earliestTimeoutTime = currentSyncTimeoutTime;
                    } 
                } 
            } 
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1717831200 = (Log.isLoggable(TAG, Log.VERBOSE));
            } 
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_904364866 = (Log.isLoggable(TAG, Log.VERBOSE));
            } 
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_330595515 = (Log.isLoggable(TAG, Log.VERBOSE));
            } 
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1600164422 = (Log.isLoggable(TAG, Log.VERBOSE));
            } 
            long alarmTime = Math.min(notificationTime, earliestTimeoutTime);
            alarmTime = Math.min(alarmTime, nextPeriodicEventElapsedTime);
            alarmTime = Math.min(alarmTime, nextPendingEventElapsedTime);
            final long now = SystemClock.elapsedRealtime();
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1861918100 = (Log.isLoggable(TAG, Log.VERBOSE));
                } 
                alarmTime = now + SYNC_ALARM_TIMEOUT_MIN;
            } 
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1727143220 = (Log.isLoggable(TAG, Log.VERBOSE));
                } 
                alarmTime = now + SYNC_ALARM_TIMEOUT_MAX;
            } 
            boolean shouldSet = false;
            boolean shouldCancel = false;
            final boolean alarmIsActive = mAlarmScheduleTime != null;
            final boolean needAlarm = alarmTime != Long.MAX_VALUE;
            {
                {
                    shouldSet = true;
                } 
            } 
            {
                shouldCancel = alarmIsActive;
            } 
            ensureAlarmService();
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_112690300 = (Log.isLoggable(TAG, Log.VERBOSE));
                } 
                mAlarmScheduleTime = alarmTime;
                mAlarmService.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, alarmTime,
                        mSyncAlarmIntent);
            } 
            {
                mAlarmScheduleTime = null;
                mAlarmService.cancel(mSyncAlarmIntent);
            } 
            addTaint(nextPeriodicEventElapsedTime);
            addTaint(nextPendingEventElapsedTime);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.138 -0400", hash_original_method = "A9010BB637A8EEC323C58050189C44ED", hash_generated_method = "E4B378507F7F1DE7914B0D2A99A5CE5A")
        private void sendSyncStateIntent() {
            Intent syncStateIntent = new Intent(Intent.ACTION_SYNC_STATE_CHANGED);
            syncStateIntent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
            syncStateIntent.putExtra("active", mNeedSyncActiveNotification);
            syncStateIntent.putExtra("failing", false);
            mContext.sendBroadcast(syncStateIntent);
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.139 -0400", hash_original_method = "87A468A0891FD210AAD2B0099F053FF2", hash_generated_method = "C1721F8108F2277D2ED1BE890A21DDB2")
        private void installHandleTooManyDeletesNotification(Account account, String authority,
                long numDeletes) {
            final ProviderInfo providerInfo = mContext.getPackageManager().resolveContentProvider(
                    authority, 0 );
            CharSequence authorityName = providerInfo.loadLabel(mContext.getPackageManager());
            Intent clickIntent = new Intent(mContext, SyncActivityTooManyDeletes.class);
            clickIntent.putExtra("account", account);
            clickIntent.putExtra("authority", authority);
            clickIntent.putExtra("provider", authorityName.toString());
            clickIntent.putExtra("numDeletes", numDeletes);
            {
                boolean varF70BDA0CA489003C43C444F0D1E24D31_2077959728 = (!isActivityAvailable(clickIntent));
            } 
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
            addTaint(account.getTaint());
            addTaint(authority.getTaint());
            addTaint(numDeletes);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.140 -0400", hash_original_method = "ABB616725C31652C20F8F96BBDEFC6AA", hash_generated_method = "578B6C1885D1AA152E738646795BE342")
        private boolean isActivityAvailable(Intent intent) {
            PackageManager pm = mContext.getPackageManager();
            List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
            int listSize = list.size();
            {
                int i = 0;
                {
                    ResolveInfo resolveInfo = list.get(i);
                } 
            } 
            addTaint(intent.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387329992 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_387329992;
            
            
            
            
            
                
                
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.141 -0400", hash_original_method = "6B3E86A8BC94835376C1AE5FBE72A92C", hash_generated_method = "7FF3B3BD543880F237C551198C68FA05")
        public long insertStartSyncEvent(SyncOperation syncOperation) {
            final int source = syncOperation.syncSource;
            final long now = System.currentTimeMillis();
            EventLog.writeEvent(2720, syncOperation.authority,
                                SyncStorageEngine.EVENT_START, source,
                                syncOperation.account.name.hashCode());
            long var4469B750121AA371E44777A358FA181D_688814163 = (mSyncStorageEngine.insertStartSyncEvent(
                    syncOperation.account, syncOperation.authority, now, source));
            addTaint(syncOperation.getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_2016845229 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2016845229;
            
            
            
            
                                
                                
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.141 -0400", hash_original_method = "7B2BF6D83EFC49C83F4A75250B3225F9", hash_generated_method = "C1B1C2A16D93AA9057B766ABC0B159C8")
        public void stopSyncEvent(long rowId, SyncOperation syncOperation, String resultMessage,
                int upstreamActivity, int downstreamActivity, long elapsedTime) {
            EventLog.writeEvent(2720, syncOperation.authority,
                                SyncStorageEngine.EVENT_STOP, syncOperation.syncSource,
                                syncOperation.account.name.hashCode());
            mSyncStorageEngine.stopSyncEvent(rowId, elapsedTime,
                    resultMessage, downstreamActivity, upstreamActivity);
            addTaint(rowId);
            addTaint(syncOperation.getTaint());
            addTaint(resultMessage.getTaint());
            addTaint(upstreamActivity);
            addTaint(downstreamActivity);
            addTaint(elapsedTime);
            
            
                                
                                
            
                    
        }

        
        class SyncNotificationInfo {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.142 -0400", hash_original_field = "7899BB2CC98E6AA80AEA065C2FB1FCD8", hash_generated_field = "1F020E689776523E90BE0EA7B3F2C831")

            public boolean isActive = false;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.142 -0400", hash_original_field = "5C942F641C110ED5DBCFAC50E6B9ACF7", hash_generated_field = "C38616C84435C3AAF7A5C7D2D3DE9890")

            public Long startTime = null;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.142 -0400", hash_original_method = "4A2C88DB351F685B767C50ED28D568B0", hash_generated_method = "4A2C88DB351F685B767C50ED28D568B0")
            public SyncNotificationInfo ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.143 -0400", hash_original_method = "4796BE9F4C6BFE28E8FE17808C5D7635", hash_generated_method = "5C8B2071F9A36A8B6B849B516A74B4EC")
            public void toString(StringBuilder sb) {
                sb.append("isActive ").append(isActive).append(", startTime ").append(startTime);
                addTaint(sb.getTaint());
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.145 -0400", hash_original_method = "C99E9A460C6F28DBA730EF38203534A2", hash_generated_method = "2CC4561B7C6D5E2B6B7ED1454F952D3D")
            @Override
            public String toString() {
                String varB4EAC82CA7396A68D541C85D26508E83_839621816 = null; 
                StringBuilder sb = new StringBuilder();
                toString(sb);
                varB4EAC82CA7396A68D541C85D26508E83_839621816 = sb.toString();
                varB4EAC82CA7396A68D541C85D26508E83_839621816.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_839621816;
                
                
                
                
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "0439F4DA6A334C5ECD9FAAB83A40EC1E", hash_generated_field = "AF31108A14FC5488BDB972C9330ED310")

    private static final String TAG = "SyncManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "771C7532EFD39D46D9339548BBB003DC", hash_generated_field = "4208D47E32C101BD1011FA8D9E027183")

    private static long LOCAL_SYNC_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "3E2805F816BDAD7B0E27638D25F6D269", hash_generated_field = "63AD8E40CBA9E89F2FEE5FAFC18666A5")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "1CEBD7C64FE2AC04D4AE482388A5976D", hash_generated_field = "3AAF491FDBA16F2F889370991CA097D0")

    private static long SYNC_NOTIFICATION_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "8A34DCE73DB332FD0A4FF63A9C446008", hash_generated_field = "83F3A378A2D13840721B0279CB462023")

    private static final long INITIAL_SYNC_RETRY_TIME_IN_MS = 30 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "79DEDA6259DEAD6C126CF86621DA2B8D", hash_generated_field = "B4DA134C6F2983E394C39C327898075F")

    private static final long DEFAULT_MAX_SYNC_RETRY_TIME_IN_SECONDS = 60 * 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "BEDF93B108551F114E8741DFEC9794F3", hash_generated_field = "FF351B5F49B49CCEBD14D33F1242A542")

    private static final int DELAY_RETRY_SYNC_IN_PROGRESS_IN_SECONDS = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "958F3D750E64AC9BC6242F30C61536C4", hash_generated_field = "B0D1B128A9CF950755F3C1F260FD40B6")

    private static final int INITIALIZATION_UNBIND_DELAY_MS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "F895C5D283689380E1BDDC0B7499335D", hash_generated_field = "7F3CEE103BD418D549113FC97263D665")

    private static final String SYNC_WAKE_LOCK_PREFIX = "*sync*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "C0E30578C8EE9D3B561C121F18E4A9AD", hash_generated_field = "B085210333D6AE1E4EF229385F1B25F4")

    private static final String HANDLE_SYNC_ALARM_WAKE_LOCK = "SyncManagerHandleSyncAlarm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "001DF2B72F4A5E3029F7CCA97081B70A", hash_generated_field = "791AF54DB72DF3C3FD2BE8EA99DCAD10")

    private static final String SYNC_LOOP_WAKE_LOCK = "SyncLoopWakeLock";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.146 -0400", hash_original_field = "21F59C952591D05458A974B04A5B1713", hash_generated_field = "DC304F1B2F6CD9046C54D34DCF49FB2F")

    private static int MAX_SIMULTANEOUS_REGULAR_SYNCS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.147 -0400", hash_original_field = "10B69AAB2B5C562523E268773A0D00E7", hash_generated_field = "8E80CF6DF9009EC95BD99B5E32172ABF")

    private static int MAX_SIMULTANEOUS_INITIALIZATION_SYNCS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.147 -0400", hash_original_field = "1A4663330AD445B983CE39BD12E9AD75", hash_generated_field = "AC3DDB789130E3521D0C40EF27CE7201")

    private static final Account[] INITIAL_ACCOUNTS_ARRAY = new Account[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.147 -0400", hash_original_field = "5BC49BB889CB3FAFB9C3D3A1F33F6081", hash_generated_field = "756530F66B344934D47CAC2FCBB3C754")

    private static final long SYNC_ALARM_TIMEOUT_MIN = 30 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.147 -0400", hash_original_field = "06AAABB61EB2A5F0EA12B8589056A2BF", hash_generated_field = "7B838AAC8E827495E078DC2F638D031A")

    private static final long SYNC_ALARM_TIMEOUT_MAX = 2 * 60 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.147 -0400", hash_original_field = "227D4DFA41347C0DE3EB12E8255A744E", hash_generated_field = "4F82340A6F1A976788D789CF812DC25C")

    private static final String ACTION_SYNC_ALARM = "android.content.syncmanager.SYNC_ALARM";
}

