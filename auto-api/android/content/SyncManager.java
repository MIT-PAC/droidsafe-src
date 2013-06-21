package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private Context mContext;
    private volatile Account[] mAccounts = INITIAL_ACCOUNTS_ARRAY;
    volatile private PowerManager.WakeLock mHandleAlarmWakeLock;
    volatile private PowerManager.WakeLock mSyncManagerWakeLock;
    volatile private boolean mDataConnectionIsConnected = false;
    volatile private boolean mStorageIsLow = false;
    private NotificationManager mNotificationMgr;
    private AlarmManager mAlarmService = null;
    private SyncStorageEngine mSyncStorageEngine;
    public SyncQueue mSyncQueue;
    protected ArrayList<ActiveSyncContext> mActiveSyncContexts = Lists.newArrayList();
    private boolean mNeedSyncActiveNotification = false;
    private PendingIntent mSyncAlarmIntent;
    private ConnectivityManager mConnManagerDoNotUseDirectly;
    protected SyncAdaptersCache mSyncAdapters;
    private BroadcastReceiver mStorageIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.318 -0400", hash_original_method = "BC3DE36BD414D1E0AC1A290F3F999B72", hash_generated_method = "4A93BD83AF25516228D5A93BFBA02A0B")
        @DSModeled(DSC.SPEC)
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            String action;
            action = intent.getAction();
            {
                boolean var494408089C6C69852C6FEB8DA3256EBE_1441144070 = (Intent.ACTION_DEVICE_STORAGE_LOW.equals(action));
                {
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1806357993 = (Log.isLoggable(TAG, Log.VERBOSE));
                    } //End collapsed parenthetic
                    mStorageIsLow = true;
                    cancelActiveSync(null , null );
                } //End block
                {
                    boolean varDA8C0F6155EB4E90A0DAEBEA890A0A28_1285032517 = (Intent.ACTION_DEVICE_STORAGE_OK.equals(action));
                    {
                        {
                            boolean var0C9C1F857EF1208EE3C75B6103EF6F6E_1569817232 = (Log.isLoggable(TAG, Log.VERBOSE));
                        } //End collapsed parenthetic
                        mStorageIsLow = false;
                        sendCheckAlarmsMessage();
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //String action = intent.getAction();
            //if (Intent.ACTION_DEVICE_STORAGE_LOW.equals(action)) {
                        //if (Log.isLoggable(TAG, Log.VERBOSE)) {
                            //Log.v(TAG, "Internal storage is low.");
                        //}
                        //mStorageIsLow = true;
                        //cancelActiveSync(null , null );
                    //} else if (Intent.ACTION_DEVICE_STORAGE_OK.equals(action)) {
                        //if (Log.isLoggable(TAG, Log.VERBOSE)) {
                            //Log.v(TAG, "Internal storage is ok.");
                        //}
                        //mStorageIsLow = false;
                        //sendCheckAlarmsMessage();
                    //}
        }

        
}; //Transformed anonymous class
    private BroadcastReceiver mBootCompletedReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.318 -0400", hash_original_method = "48002FD0F3001594E3DAE34911FFCE18", hash_generated_method = "6F64B7A4447F31BE44C213F9B1331E9F")
        @DSModeled(DSC.SPEC)
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            mSyncHandler.onBootCompleted();
            // ---------- Original Method ----------
            //mSyncHandler.onBootCompleted();
        }

        
}; //Transformed anonymous class
    private BroadcastReceiver mBackgroundDataSettingChanged = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.318 -0400", hash_original_method = "8D0265854014D0DAAECDD8BFDBAC7B99", hash_generated_method = "07987537482F9C92A246053F7C138C57")
        @DSModeled(DSC.SPEC)
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            {
                boolean varC0E64E7A82D55EFFFB410CFD8BF972ED_1365681553 = (getConnectivityManager().getBackgroundDataSetting());
                {
                    scheduleSync(null , null , new Bundle(), 0 ,
                        false );
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (getConnectivityManager().getBackgroundDataSetting()) {
                //scheduleSync(null , null , new Bundle(), 0 ,
                        //false );
            //}
        }

        
}; //Transformed anonymous class
    private PowerManager mPowerManager;
    private BroadcastReceiver mConnectivityIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.319 -0400", hash_original_method = "252074B4EB0924016B2ADBE10E34C1F3", hash_generated_method = "F5FABF8761A597ED31C4233EA9EFFB3F")
        @DSModeled(DSC.SPEC)
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            boolean wasConnected;
            wasConnected = mDataConnectionIsConnected;
            mDataConnectionIsConnected = readDataConnectionState();
            {
                {
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1644421794 = (Log.isLoggable(TAG, Log.VERBOSE));
                    } //End collapsed parenthetic
                    mSyncStorageEngine.clearAllBackoffs(mSyncQueue);
                } //End block
                sendCheckAlarmsMessage();
            } //End block
            // ---------- Original Method ----------
            //final boolean wasConnected = mDataConnectionIsConnected;
            //mDataConnectionIsConnected = readDataConnectionState();
            //if (mDataConnectionIsConnected) {
                //if (!wasConnected) {
                    //if (Log.isLoggable(TAG, Log.VERBOSE)) {
                        //Log.v(TAG, "Reconnection detected: clearing all backoffs");
                    //}
                    //mSyncStorageEngine.clearAllBackoffs(mSyncQueue);
                //}
                //sendCheckAlarmsMessage();
            //}
        }

        
}; //Transformed anonymous class
    private BroadcastReceiver mShutdownIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.319 -0400", hash_original_method = "C2982D871DFCE85BA68BED52BCB115FD", hash_generated_method = "3A7D02FE5DB9AF4D23C3A7B662E1078E")
        @DSModeled(DSC.SPEC)
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            getSyncStorageEngine().writeAllState();
            // ---------- Original Method ----------
            //Log.w(TAG, "Writing sync state before shutdown...");
            //getSyncStorageEngine().writeAllState();
        }

        
}; //Transformed anonymous class
    private SyncHandler mSyncHandler;
    private Handler mMainHandler;
    private volatile boolean mBootCompleted = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.321 -0400", hash_original_method = "03EC3B1422C9597488B0C8A9401C488F", hash_generated_method = "EBA0F032D197D7804216265EF4D73539")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncManager(Context context, boolean factoryTest) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(factoryTest);
        SyncStorageEngine.init(context);
        mSyncStorageEngine = SyncStorageEngine.getSingleton();
        mSyncAdapters = new SyncAdaptersCache(mContext);
        mSyncQueue = new SyncQueue(mSyncStorageEngine, mSyncAdapters);
        HandlerThread syncThread;
        syncThread = new HandlerThread("SyncHandlerThread",
                Process.THREAD_PRIORITY_BACKGROUND);
        syncThread.start();
        mSyncHandler = new SyncHandler(syncThread.getLooper());
        mMainHandler = new Handler(mContext.getMainLooper());
        mSyncAdapters.setListener(new RegisteredServicesCacheListener<SyncAdapterType>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.320 -0400", hash_original_method = "156EF77A103E5C10F6AA28A0B09EC843", hash_generated_method = "DF89411B52F6B64A4DB04FEFADDE707D")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onServiceChanged(SyncAdapterType type, boolean removed) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(removed);
                dsTaint.addTaint(type.dsTaint);
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
        IntentFilter intentFilter;
        intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(mConnectivityIntentReceiver, intentFilter);
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
        {
            mNotificationMgr = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
            context.registerReceiver(new SyncAlarmIntentReceiver(),
                    new IntentFilter(ACTION_SYNC_ALARM));
        } //End block
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.321 -0400", hash_original_method = "E2E5241731BE29D01E4993B391B00B92", hash_generated_method = "193E438A734F80D68543E67C8A94B4C6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onStatusChanged(int which) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(which);
                sendCheckAlarmsMessage();
                // ---------- Original Method ----------
                //sendCheckAlarmsMessage();
            }
});
        {
            AccountManager.get(mContext).addOnAccountsUpdatedListener(SyncManager.this,
                mSyncHandler, false );
            onAccountsUpdated(AccountManager.get(mContext).getAccounts());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.328 -0400", hash_original_method = "F68E26CE46C5E71DC7131B4E8982A697", hash_generated_method = "2066DCA963C9EE4F03B18ACE3AD2EFDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onAccountsUpdated(Account[] accounts) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(accounts[0].dsTaint);
        boolean justBootedUp;
        justBootedUp = mAccounts == INITIAL_ACCOUNTS_ARRAY;
        {
            Iterator<ActiveSyncContext> varB42644AE74A51E951ED6AB5DD20DA8CE_1983696508 = (mActiveSyncContexts).iterator();
            varB42644AE74A51E951ED6AB5DD20DA8CE_1983696508.hasNext();
            ActiveSyncContext currentSyncContext = varB42644AE74A51E951ED6AB5DD20DA8CE_1983696508.next();
            {
                {
                    boolean var98DBBB9384A6D900D1DF555C10C402D5_1638346089 = (!ArrayUtils.contains(accounts, currentSyncContext.mSyncOperation.account));
                    {
                        Log.d(TAG, "canceling sync since the account has been removed");
                        sendSyncFinishedOrCanceledMessage(currentSyncContext,
                        null );
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        sendCheckAlarmsMessage();
        {
            mSyncStorageEngine.doDatabaseCleanup(accounts);
        } //End block
        {
            boolean onlyThoseWithUnkownSyncableState;
            onlyThoseWithUnkownSyncableState = justBootedUp;
            scheduleSync(null, null, null, 0 , onlyThoseWithUnkownSyncableState);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.328 -0400", hash_original_method = "90A2C58DEF02026C184592212F85FF18", hash_generated_method = "32A01E90864AD020380AD565332B479D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean readDataConnectionState() {
        NetworkInfo networkInfo;
        networkInfo = getConnectivityManager().getActiveNetworkInfo();
        boolean var53496D7038EE5B94BB35F9D43FD53DF1_922614019 = ((networkInfo != null) && networkInfo.isConnected());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //NetworkInfo networkInfo = getConnectivityManager().getActiveNetworkInfo();
        //return (networkInfo != null) && networkInfo.isConnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.328 -0400", hash_original_method = "85835365DA8D3F37E74A4C98C5566C52", hash_generated_method = "7364ACE2AE529949B3A9DC365057C83A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ConnectivityManager getConnectivityManager() {
        {
            {
                mConnManagerDoNotUseDirectly = (ConnectivityManager)mContext.getSystemService(
                        Context.CONNECTIVITY_SERVICE);
            } //End block
        } //End block
        return (ConnectivityManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mConnManagerDoNotUseDirectly == null) {
                //mConnManagerDoNotUseDirectly = (ConnectivityManager)mContext.getSystemService(
                        //Context.CONNECTIVITY_SERVICE);
            //}
            //return mConnManagerDoNotUseDirectly;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.329 -0400", hash_original_method = "2C829A46E677D5FF63843A6B74A54E87", hash_generated_method = "9D2075FE8E97C06B6F167B8C20DAEB69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long jitterize(long minValue, long maxValue) {
        dsTaint.addTaint(minValue);
        dsTaint.addTaint(maxValue);
        Random random;
        random = new Random(SystemClock.elapsedRealtime());
        long spread;
        spread = maxValue - minValue;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the difference between the maxValue and the "
                    + "minValue must be less than " + Integer.MAX_VALUE);
        } //End block
        long varD1004F69028D356D16619D81D55BEACE_499617287 = (minValue + random.nextInt((int)spread));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //Random random = new Random(SystemClock.elapsedRealtime());
        //long spread = maxValue - minValue;
        //if (spread > Integer.MAX_VALUE) {
            //throw new IllegalArgumentException("the difference between the maxValue and the "
                    //+ "minValue must be less than " + Integer.MAX_VALUE);
        //}
        //return minValue + random.nextInt((int)spread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.329 -0400", hash_original_method = "BC7A6B22ABBE0EBF148B37C3B72645F0", hash_generated_method = "DAD2FCB6F3C592E0155DB073004541F4")
    @DSModeled(DSC.SAFE)
    public SyncStorageEngine getSyncStorageEngine() {
        return (SyncStorageEngine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSyncStorageEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.329 -0400", hash_original_method = "51F169FF6EC2BB253880B74521EEDA04", hash_generated_method = "35DF559DA3A5DA237B231F2EE75E3A9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureAlarmService() {
        {
            mAlarmService = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
        } //End block
        // ---------- Original Method ----------
        //if (mAlarmService == null) {
            //mAlarmService = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.330 -0400", hash_original_method = "3B1126FA248635D8E240EE322F732C4B", hash_generated_method = "A9412EBFEA8AA431F5BBAE740ED02601")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initializeSyncAdapter(Account account, String authority) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_714207740 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        SyncAdapterType syncAdapterType;
        syncAdapterType = SyncAdapterType.newKey(authority, account.type);
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo;
        syncAdapterInfo = mSyncAdapters.getServiceInfo(syncAdapterType);
        {
            mSyncStorageEngine.removeAuthority(account, authority);
        } //End block
        Intent intent;
        intent = new Intent();
        intent.setAction("android.content.SyncAdapter");
        intent.setComponent(syncAdapterInfo.componentName);
        {
            boolean var1A3A6E55EBFBD5A3E4EB18A5AAADC18B_300973555 = (!mContext.bindService(intent,
                new InitializerServiceConnection(account, authority, mContext, mMainHandler),
                Context.BIND_AUTO_CREATE | Context.BIND_NOT_FOREGROUND
                | Context.BIND_ALLOW_OOM_MANAGEMENT));
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.392 -0400", hash_original_method = "B73E52BAF4D022DC2D77FE197F842436", hash_generated_method = "6178BCB6712EF50C6575BB6A23CF9D38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleSync(Account requestedAccount, String requestedAuthority,
            Bundle extras, long delay, boolean onlyThoseWithUnkownSyncableState) {
        dsTaint.addTaint(requestedAuthority);
        dsTaint.addTaint(delay);
        dsTaint.addTaint(onlyThoseWithUnkownSyncableState);
        dsTaint.addTaint(requestedAccount.dsTaint);
        dsTaint.addTaint(extras.dsTaint);
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
        } //End block
        Account[] accounts;
        {
            accounts = new Account[]{requestedAccount};
        } //End block
        {
            accounts = mAccounts;
        } //End block
        boolean uploadOnly;
        uploadOnly = extras.getBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, false);
        boolean manualSync;
        manualSync = extras.getBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, false);
        {
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, true);
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, true);
        } //End block
        boolean ignoreSettings;
        ignoreSettings = extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, false);
        int source;
        {
            source = SyncStorageEngine.SOURCE_LOCAL;
        } //End block
        {
            source = SyncStorageEngine.SOURCE_USER;
        } //End block
        {
            source = SyncStorageEngine.SOURCE_POLL;
        } //End block
        {
            source = SyncStorageEngine.SOURCE_SERVER;
        } //End block
        HashSet<String> syncableAuthorities;
        syncableAuthorities = new HashSet<String>();
        {
            Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> varA460451BE61974D4E85B931D5CE391A8_1434511645 = (mSyncAdapters.getAllServices()).iterator();
            varA460451BE61974D4E85B931D5CE391A8_1434511645.hasNext();
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapter = varA460451BE61974D4E85B931D5CE391A8_1434511645.next();
            {
                syncableAuthorities.add(syncAdapter.type.authority);
            } //End block
        } //End collapsed parenthetic
        {
            boolean hasSyncAdapter;
            hasSyncAdapter = syncableAuthorities.contains(requestedAuthority);
            syncableAuthorities.clear();
            syncableAuthorities.add(requestedAuthority);
        } //End block
        boolean masterSyncAutomatically;
        masterSyncAutomatically = mSyncStorageEngine.getMasterSyncAutomatically();
        {
            Iterator<String> varA26FDBFC8911931337CEF509AC3DFFCA_1641031264 = (syncableAuthorities).iterator();
            varA26FDBFC8911931337CEF509AC3DFFCA_1641031264.hasNext();
            String authority = varA26FDBFC8911931337CEF509AC3DFFCA_1641031264.next();
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
                        } //End block
                        {
                            boolean varE5FC1CEDA70C1C0494947FABB12B6E86_1789919531 = (!syncAdapterInfo.type.supportsUploading() && uploadOnly);
                        } //End collapsed parenthetic
                        boolean syncAllowed;
                        syncAllowed = (isSyncable < 0)
                        || ignoreSettings
                        || (backgroundDataUsageAllowed && masterSyncAutomatically
                            && mSyncStorageEngine.getSyncAutomatically(account, authority));
                        {
                            {
                                Log.d(TAG, "scheduleSync: sync of " + account + ", " + authority
                                + " is not allowed, dropping request");
                            } //End block
                        } //End block
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
                        } //End block
                        {
                            scheduleSyncOperation(
                            new SyncOperation(account, source, authority, extras, delay,
                                    backoffTime, delayUntil,
                                    allowParallelSyncs));
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.393 -0400", hash_original_method = "9A217D026FB5B08090F4BAFAA08C0DF7", hash_generated_method = "959CEC23BF0DA774F85F8A8DBED55B94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleLocalSync(Account account, String authority) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        Bundle extras;
        extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        scheduleSync(account, authority, extras, LOCAL_SYNC_DELAY,
                false );
        // ---------- Original Method ----------
        //final Bundle extras = new Bundle();
        //extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        //scheduleSync(account, authority, extras, LOCAL_SYNC_DELAY,
                //false );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.405 -0400", hash_original_method = "0A2ACD1B7EA84D8FDEC2211873578368", hash_generated_method = "1E79F0CE83BC282E29B078EB43404AEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncAdapterType[] getSyncAdapterTypes() {
        Collection<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> serviceInfos;
        serviceInfos = mSyncAdapters.getAllServices();
        SyncAdapterType[] types;
        types = new SyncAdapterType[serviceInfos.size()];
        int i;
        i = 0;
        {
            Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> var7AE0F59F3247E05923E8DDBDBBF91C7C_1730289845 = (serviceInfos).iterator();
            var7AE0F59F3247E05923E8DDBDBBF91C7C_1730289845.hasNext();
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> serviceInfo = var7AE0F59F3247E05923E8DDBDBBF91C7C_1730289845.next();
            {
                types[i] = serviceInfo.type;
            } //End block
        } //End collapsed parenthetic
        return (SyncAdapterType[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.406 -0400", hash_original_method = "14A3D8C2E4B2E28E7EAE9416931B0D4D", hash_generated_method = "318308309CB068427613EB1BF9805B68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendSyncAlarmMessage() {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_1478883657 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_SYNC_ALARM);
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_SYNC_ALARM");
        //mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_SYNC_ALARM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.407 -0400", hash_original_method = "48CD41A4FC7AAC6DBD3D417BDFF3952E", hash_generated_method = "64F68BF21B633A7166857C418D5B35C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendCheckAlarmsMessage() {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_295949611 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_CHECK_ALARMS);
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_CHECK_ALARMS");
        //mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_CHECK_ALARMS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.408 -0400", hash_original_method = "A4D4C528BED9CEDB160AF5BFC279888F", hash_generated_method = "AB55ABDE6ED51A08B3D59AE8D8C923DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendSyncFinishedOrCanceledMessage(ActiveSyncContext syncContext,
            SyncResult syncResult) {
        dsTaint.addTaint(syncContext.dsTaint);
        dsTaint.addTaint(syncResult.dsTaint);
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_862171932 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        Message msg;
        msg = mSyncHandler.obtainMessage();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.408 -0400", hash_original_method = "162904FEAED4FE3BDD09493527BC709D", hash_generated_method = "20A90FC3A55C899A56FA3437C34B8F26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendCancelSyncsMessage(final Account account, final String authority) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_808475304 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        Message msg;
        msg = mSyncHandler.obtainMessage();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.409 -0400", hash_original_method = "1BD5650AC2366081E95971C40228D13F", hash_generated_method = "AB641560ADEC9623FF87A33F6AE7B4C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void clearBackoffSetting(SyncOperation op) {
        dsTaint.addTaint(op.dsTaint);
        mSyncStorageEngine.setBackoff(op.account, op.authority,
                SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
        {
            mSyncQueue.onBackoffChanged(op.account, op.authority, 0);
        } //End block
        // ---------- Original Method ----------
        //mSyncStorageEngine.setBackoff(op.account, op.authority,
                //SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
        //synchronized (mSyncQueue) {
            //mSyncQueue.onBackoffChanged(op.account, op.authority, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.409 -0400", hash_original_method = "42DD92B3EE29EAC346CC626BA6B5C78C", hash_generated_method = "256D9DCD806B488544FCC4B75A993C30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void increaseBackoffSetting(SyncOperation op) {
        dsTaint.addTaint(op.dsTaint);
        long now;
        now = SystemClock.elapsedRealtime();
        Pair<Long, Long> previousSettings;
        previousSettings = mSyncStorageEngine.getBackoff(op.account, op.authority);
        long newDelayInMs;
        newDelayInMs = -1;
        {
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1701077141 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
            } //End block
            newDelayInMs = previousSettings.second * 2;
        } //End block
        {
            newDelayInMs = jitterize(INITIAL_SYNC_RETRY_TIME_IN_MS,
                    (long)(INITIAL_SYNC_RETRY_TIME_IN_MS * 1.1));
        } //End block
        long maxSyncRetryTimeInSeconds;
        maxSyncRetryTimeInSeconds = Settings.Secure.getLong(mContext.getContentResolver(),
                Settings.Secure.SYNC_MAX_RETRY_DELAY_IN_SECONDS,
                DEFAULT_MAX_SYNC_RETRY_TIME_IN_SECONDS);
        {
            newDelayInMs = maxSyncRetryTimeInSeconds * 1000;
        } //End block
        long backoff;
        backoff = now + newDelayInMs;
        mSyncStorageEngine.setBackoff(op.account, op.authority,
                backoff, newDelayInMs);
        op.backoff = backoff;
        op.updateEffectiveRunTime();
        {
            mSyncQueue.onBackoffChanged(op.account, op.authority, backoff);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.410 -0400", hash_original_method = "D0F8BD8389FAB953FA57BE172373CE33", hash_generated_method = "EBBA9D5CABB5FF54A7BB24C9F2E2E538")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setDelayUntilTime(SyncOperation op, long delayUntilSeconds) {
        dsTaint.addTaint(delayUntilSeconds);
        dsTaint.addTaint(op.dsTaint);
        long delayUntil;
        delayUntil = delayUntilSeconds * 1000;
        long absoluteNow;
        absoluteNow = System.currentTimeMillis();
        long newDelayUntilTime;
        {
            newDelayUntilTime = SystemClock.elapsedRealtime() + (delayUntil - absoluteNow);
        } //End block
        {
            newDelayUntilTime = 0;
        } //End block
        mSyncStorageEngine.setDelayUntilTime(op.account, op.authority, newDelayUntilTime);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.410 -0400", hash_original_method = "CC013A9497DA672D61638E0368F0173C", hash_generated_method = "50ACC81182B1180042C88F51B9F2737A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancelActiveSync(Account account, String authority) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        sendCancelSyncsMessage(account, authority);
        // ---------- Original Method ----------
        //sendCancelSyncsMessage(account, authority);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.411 -0400", hash_original_method = "B18DC4486E3B23A71F43236C6D4E20D9", hash_generated_method = "48570264877DB71812B136D96F6E8B48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleSyncOperation(SyncOperation syncOperation) {
        dsTaint.addTaint(syncOperation.dsTaint);
        boolean queueChanged;
        {
            queueChanged = mSyncQueue.add(syncOperation);
        } //End block
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_472254748 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            sendCheckAlarmsMessage();
        } //End block
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1665949044 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.411 -0400", hash_original_method = "A2720167EE002D05FE5DA0F6211150BE", hash_generated_method = "4134DAF5388A719550D9CA7D8DD23D9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearScheduledSyncOperations(Account account, String authority) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.412 -0400", hash_original_method = "7F8B5486825DA8802A08F87FCECDEB6D", hash_generated_method = "01033539440269D95F9F1DDA2A6C6576")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void maybeRescheduleSync(SyncResult syncResult, SyncOperation operation) {
        dsTaint.addTaint(operation.dsTaint);
        dsTaint.addTaint(syncResult.dsTaint);
        boolean isLoggable;
        isLoggable = Log.isLoggable(TAG, Log.DEBUG);
        {
            Log.d(TAG, "encountered error(s) during the sync: " + syncResult + ", " + operation);
        } //End block
        operation = new SyncOperation(operation);
        {
            boolean var136962CEFF8E97B7711EEA42390818DD_933351447 = (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, false));
            {
                operation.extras.remove(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8F222CBFA0E1CEE9747F369F4C66D983_304581029 = (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_DO_NOT_RETRY, false));
            {
                Log.d(TAG, "not retrying sync operation because SYNC_EXTRAS_DO_NOT_RETRY was specified "
                    + operation);
            } //End block
            {
                boolean varCF7FCB45BDB21B5C6B94F23C48AB3F03_1764317168 = (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, false)
                && !syncResult.syncAlreadyInProgress);
                {
                    operation.extras.remove(ContentResolver.SYNC_EXTRAS_UPLOAD);
                    Log.d(TAG, "retrying sync operation as a two-way sync because an upload-only sync "
                    + "encountered an error: " + operation);
                    scheduleSyncOperation(operation);
                } //End block
                {
                    Log.d(TAG, "not retrying sync operation because it retried too many times: "
                    + operation);
                } //End block
                {
                    boolean varAEB5246C7BAA2573F81B4D1F785CB99B_1210590291 = (syncResult.madeSomeProgress());
                    {
                        {
                            Log.d(TAG, "retrying sync operation because even though it had an error "
                        + "it achieved some success");
                        } //End block
                        scheduleSyncOperation(operation);
                    } //End block
                    {
                        {
                            Log.d(TAG, "retrying sync operation that failed because there was already a "
                        + "sync in progress: " + operation);
                        } //End block
                        scheduleSyncOperation(new SyncOperation(operation.account, operation.syncSource,
                    operation.authority, operation.extras,
                    DELAY_RETRY_SYNC_IN_PROGRESS_IN_SECONDS * 1000,
                    operation.backoff, operation.delayUntil, operation.allowParallelSyncs));
                    } //End block
                    {
                        boolean var2BF6670105BBC4F9CBE78135A10D2C2F_1965602326 = (syncResult.hasSoftError());
                        {
                            {
                                Log.d(TAG, "retrying sync operation because it encountered a soft error: "
                        + operation);
                            } //End block
                            scheduleSyncOperation(operation);
                        } //End block
                        {
                            Log.d(TAG, "not retrying sync operation because the error is a hard error: "
                    + operation);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.429 -0400", hash_original_method = "E59AB1EB4C672AE41E3C994B41A259B0", hash_generated_method = "8BA3BBACDDF038F12F30606C1234F796")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dump(FileDescriptor fd, PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        dumpSyncState(pw);
        dumpSyncHistory(pw);
        pw.println();
        pw.println("SyncAdapters:");
        {
            Iterator<RegisteredServicesCache.ServiceInfo> var66FF787B46917F4C470825A4AACF9C4B_1844875159 = (mSyncAdapters.getAllServices()).iterator();
            var66FF787B46917F4C470825A4AACF9C4B_1844875159.hasNext();
            RegisteredServicesCache.ServiceInfo info = var66FF787B46917F4C470825A4AACF9C4B_1844875159.next();
            {
                pw.println("  " + info);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //dumpSyncState(pw);
        //dumpSyncHistory(pw);
        //pw.println();
        //pw.println("SyncAdapters:");
        //for (RegisteredServicesCache.ServiceInfo info : mSyncAdapters.getAllServices()) {
            //pw.println("  " + info);
        //}
    }

    
        static String formatTime(long time) {
        Time tobj = new Time();
        tobj.set(time);
        return tobj.format("%Y-%m-%d %H:%M:%S");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.511 -0400", hash_original_method = "A56698FB2481C281E3929C7135D64B8A", hash_generated_method = "F58BAC4F05CFCBECFBE654EA08E90FE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dumpSyncState(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
        pw.print("data connected: ");
        pw.println(mDataConnectionIsConnected);
        pw.print("memory low: ");
        pw.println(mStorageIsLow);
        Account[] accounts;
        accounts = mAccounts;
        pw.print("accounts: ");
        {
            pw.println(accounts.length);
        } //End block
        {
            pw.println("not known yet");
        } //End block
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
        } //End block
        {
            pw.println("no alarm is scheduled (there had better not be any pending syncs)");
        } //End block
        pw.print("notification info: ");
        StringBuilder sb;
        sb = new StringBuilder();
        mSyncHandler.mSyncNotificationInfo.toString(sb);
        pw.println(sb.toString());
        pw.println();
        pw.println("Active Syncs: " + mActiveSyncContexts.size());
        {
            Iterator<SyncManager.ActiveSyncContext> var410A1C2D24679042EA90D422992CD225_1234681359 = (mActiveSyncContexts).iterator();
            var410A1C2D24679042EA90D422992CD225_1234681359.hasNext();
            SyncManager.ActiveSyncContext activeSyncContext = var410A1C2D24679042EA90D422992CD225_1234681359.next();
            {
                long durationInSeconds;
                durationInSeconds = (now - activeSyncContext.mStartTime) / 1000;
                pw.print("  ");
                pw.print(DateUtils.formatElapsedTime(durationInSeconds));
                pw.print(" - ");
                pw.print(activeSyncContext.mSyncOperation.dump(false));
                pw.println();
            } //End block
        } //End collapsed parenthetic
        {
            sb.setLength(0);
            mSyncQueue.dump(sb);
        } //End block
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
                    Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> varB8408EC3A61191DA03920260AEC144C1_2111715526 = (mSyncAdapters.getAllServices()).iterator();
                    varB8408EC3A61191DA03920260AEC144C1_2111715526.hasNext();
                    RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterType = varB8408EC3A61191DA03920260AEC144C1_2111715526.next();
                    {
                        {
                            boolean varBFF66230831B803F3BB6FD65657B65E4_261966094 = (!syncAdapterType.type.accountType.equals(account.type));
                        } //End collapsed parenthetic
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
                        } //End block
                        {
                            pw.print(", backoff for "
                            + ((settings.backoffTime - now) / 1000) + " sec");
                        } //End block
                        {
                            pw.print(", the backoff increment is " + settings.backoffDelay / 1000
                                + " sec");
                        } //End block
                        pw.println();
                        {
                            int periodicIndex;
                            periodicIndex = 0;
                            boolean var234026F2237427D2FEAC3EFBEEDD19EA_38066251 = (periodicIndex < settings.periodicSyncs.size());
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
                            } //End block
                        } //End collapsed parenthetic
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
                        } //End block
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
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.512 -0400", hash_original_method = "C2F823D43F1684BB9B7871B7A13E4AFA", hash_generated_method = "5B4AA22E0E9174B6E9A16BF31B9E1488")
    @DSModeled(DSC.SAFE)
    private String getLastFailureMessage(int code) {
        dsTaint.addTaint(code);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.512 -0400", hash_original_method = "2E5C9A0C484B8BFAAD4FF120631D1FEC", hash_generated_method = "6C2361F6838DEDF3DA3C589E1508F2EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dumpTimeSec(PrintWriter pw, long time) {
        dsTaint.addTaint(time);
        dsTaint.addTaint(pw.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.513 -0400", hash_original_method = "05C5ECB94ECE9FA6501463D9FF0137FC", hash_generated_method = "BE7DA483FA29815215ED9AB1071C3DD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dumpDayStatistic(PrintWriter pw, SyncStorageEngine.DayStats ds) {
        dsTaint.addTaint(pw.dsTaint);
        dsTaint.addTaint(ds.dsTaint);
        pw.print("Success (");
        pw.print(ds.successCount);
        {
            pw.print(" for ");
            dumpTimeSec(pw, ds.successTime);
            pw.print(" avg=");
            dumpTimeSec(pw, ds.successTime/ds.successCount);
        } //End block
        pw.print(") Failure (");
        pw.print(ds.failureCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.513 -0400", hash_original_method = "47B1A67BEBB64EEFEE0789183294D0B7", hash_generated_method = "36495D7D71C0CBE6DE64271DCB7806D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dumpSyncHistory(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
        dumpRecentHistory(pw);
        dumpDayStatistics(pw);
        // ---------- Original Method ----------
        //dumpRecentHistory(pw);
        //dumpDayStatistics(pw);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.594 -0400", hash_original_method = "C137DBDBD7D2B9AF348453A35EDAB8EF", hash_generated_method = "D5AECB9E6BACD45BC434E5FFA33DA403")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dumpRecentHistory(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
        ArrayList<SyncStorageEngine.SyncHistoryItem> items;
        items = mSyncStorageEngine.getSyncHistory();
        {
            boolean varDBDD00862D2499954D5577669FA506EB_1978818560 = (items != null && items.size() > 0);
            {
                Map<String, AuthoritySyncStats> authorityMap;
                authorityMap = Maps.newHashMap();
                long totalElapsedTime;
                totalElapsedTime = 0;
                long totalTimes;
                totalTimes = 0;
                int N;
                N = items.size();
                int maxAuthority;
                maxAuthority = 0;
                int maxAccount;
                maxAccount = 0;
                {
                    Iterator<SyncStorageEngine.SyncHistoryItem> var0608C6D9DE28EB12D6BAF098F71C2655_1152066656 = (items).iterator();
                    var0608C6D9DE28EB12D6BAF098F71C2655_1152066656.hasNext();
                    SyncStorageEngine.SyncHistoryItem item = var0608C6D9DE28EB12D6BAF098F71C2655_1152066656.next();
                    {
                        SyncStorageEngine.AuthorityInfo authority;
                        authority = mSyncStorageEngine.getAuthority(item.authorityId);
                        String authorityName;
                        String accountKey;
                        {
                            authorityName = authority.authority;
                            accountKey = authority.account.name + "/" + authority.account.type;
                        } //End block
                        {
                            authorityName = "Unknown";
                            accountKey = "Unknown";
                        } //End block
                        int length;
                        length = authorityName.length();
                        {
                            maxAuthority = length;
                        } //End block
                        length = accountKey.length();
                        {
                            maxAccount = length;
                        } //End block
                        long elapsedTime;
                        elapsedTime = item.elapsedTime;
                        totalElapsedTime += elapsedTime;
                        AuthoritySyncStats authoritySyncStats;
                        authoritySyncStats = authorityMap.get(authorityName);
                        {
                            authoritySyncStats = new AuthoritySyncStats(authorityName);
                            authorityMap.put(authorityName, authoritySyncStats);
                        } //End block
                        authoritySyncStats.elapsedTime += elapsedTime;
                        Map<String, AccountSyncStats> accountMap;
                        accountMap = authoritySyncStats.accountMap;
                        AccountSyncStats accountSyncStats;
                        accountSyncStats = accountMap.get(accountKey);
                        {
                            accountSyncStats = new AccountSyncStats(accountKey);
                            accountMap.put(accountKey, accountSyncStats);
                        } //End block
                        accountSyncStats.elapsedTime += elapsedTime;
                    } //End block
                } //End collapsed parenthetic
                pw.println();
                pw.printf("Detailed Statistics (Recent history):  %d (# of times) %ds (sync time)\n",
                    totalTimes, totalElapsedTime / 1000);
                List<AuthoritySyncStats> sortedAuthorities;
                sortedAuthorities = new ArrayList<AuthoritySyncStats>(authorityMap.values());
                Collections.sort(sortedAuthorities, new Comparator<AuthoritySyncStats>() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.592 -0400", hash_original_method = "88424CA43B1F65943C36D332DC119ECC", hash_generated_method = "22AA8A6658612C54FB4717306E95A4B1")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public int compare(AuthoritySyncStats lhs, AuthoritySyncStats rhs) {
                        dsTaint.addTaint(rhs.dsTaint);
                        dsTaint.addTaint(lhs.dsTaint);
                        int compare;
                        compare = Integer.compare(rhs.times, lhs.times);
                        {
                            compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                        } //End block
                        return dsTaint.getTaintInt();
                        // ---------- Original Method ----------
                        //int compare = Integer.compare(rhs.times, lhs.times);
                        //if (compare == 0) {
                        //compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                    //}
                        //return compare;
                    }
});
                int maxLength;
                maxLength = Math.max(maxAuthority, maxAccount + 3);
                int padLength;
                padLength = 2 + 2 + maxLength + 2 + 10 + 11;
                char chars[];
                chars = new char[padLength];
                Arrays.fill(chars, '-');
                String separator;
                separator = new String(chars);
                String authorityFormat;
                authorityFormat = String.format("  %%-%ds: %%-9s  %%-11s\n", maxLength + 2);
                String accountFormat;
                accountFormat = String.format("    %%-%ds:   %%-9s  %%-11s\n", maxLength);
                pw.println(separator);
                {
                    Iterator<AuthoritySyncStats> var02EEAE14D9E55F5E0A8CF4B94919F1FF_455194656 = (sortedAuthorities).iterator();
                    var02EEAE14D9E55F5E0A8CF4B94919F1FF_455194656.hasNext();
                    AuthoritySyncStats authoritySyncStats = var02EEAE14D9E55F5E0A8CF4B94919F1FF_455194656.next();
                    {
                        String name;
                        name = authoritySyncStats.name;
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
                        List<AccountSyncStats> sortedAccounts;
                        sortedAccounts = new ArrayList<AccountSyncStats>(
                                authoritySyncStats.accountMap.values());
                        Collections.sort(sortedAccounts, new Comparator<AccountSyncStats>() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.593 -0400", hash_original_method = "CABE0C69E80F76B9C185615742665411", hash_generated_method = "0EAAE10681F7971B73EA104F0D740733")
                            //DSFIXME:  CODE0002: Requires DSC value to be set
                            @Override
                            public int compare(AccountSyncStats lhs, AccountSyncStats rhs) {
                                dsTaint.addTaint(rhs.dsTaint);
                                dsTaint.addTaint(lhs.dsTaint);
                                int compare;
                                compare = Integer.compare(rhs.times, lhs.times);
                                {
                                    compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                                } //End block
                                return dsTaint.getTaintInt();
                                // ---------- Original Method ----------
                                //int compare = Integer.compare(rhs.times, lhs.times);
                                //if (compare == 0) {
                            //compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                        //}
                                //return compare;
                            }
});
                        {
                            Iterator<AccountSyncStats> var5409EB09DA7B117C8E0493FB2F1F1ED9_1981569624 = (sortedAccounts).iterator();
                            var5409EB09DA7B117C8E0493FB2F1F1ED9_1981569624.hasNext();
                            AccountSyncStats stats = var5409EB09DA7B117C8E0493FB2F1F1ED9_1981569624.next();
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
                        } //End collapsed parenthetic
                        pw.println(separator);
                    } //End block
                } //End collapsed parenthetic
                pw.println();
                pw.println("Recent Sync History");
                String format;
                format = "  %-" + maxAccount + "s  %s\n";
                Map<String, Long> lastTimeMap;
                lastTimeMap = Maps.newHashMap();
                {
                    int i;
                    i = 0;
                    {
                        SyncStorageEngine.SyncHistoryItem item;
                        item = items.get(i);
                        SyncStorageEngine.AuthorityInfo authority;
                        authority = mSyncStorageEngine.getAuthority(item.authorityId);
                        String authorityName;
                        String accountKey;
                        {
                            authorityName = authority.authority;
                            accountKey = authority.account.name + "/" + authority.account.type;
                        } //End block
                        {
                            authorityName = "Unknown";
                            accountKey = "Unknown";
                        } //End block
                        long elapsedTime;
                        elapsedTime = item.elapsedTime;
                        Time time;
                        time = new Time();
                        long eventTime;
                        eventTime = item.eventTime;
                        time.set(eventTime);
                        String key;
                        key = authorityName + "/" + accountKey;
                        Long lastEventTime;
                        lastEventTime = lastTimeMap.get(key);
                        String diffString;
                        {
                            diffString = "";
                        } //End block
                        {
                            long diff;
                            diff = (lastEventTime - eventTime) / 1000;
                            {
                                diffString = String.valueOf(diff);
                            } //End block
                            {
                                diffString = String.format("%02d:%02d", diff / 60, diff % 60);
                            } //End block
                            {
                                long sec;
                                sec = diff % 3600;
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
                        {
                            pw.printf("    event=%d upstreamActivity=%d downstreamActivity=%d\n",
                            item.event,
                            item.upstreamActivity,
                            item.downstreamActivity);
                        } //End block
                        {
                            boolean varFC5F873EDD9BB5AB47B6562574DA62BF_701170130 = (item.mesg != null
                        && !SyncStorageEngine.MESG_SUCCESS.equals(item.mesg));
                            {
                                pw.printf("    mesg=%s\n", item.mesg);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.595 -0400", hash_original_method = "9349911975C50CB78B5A389074CC1BDC", hash_generated_method = "EFE6DF101648E5341387DF2D16F159E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dumpDayStatistics(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
        SyncStorageEngine.DayStats dses[];
        dses = mSyncStorageEngine.getDayStatistics();
        {
            pw.println();
            pw.println("Sync Statistics");
            pw.print("  Today:  ");
            dumpDayStatistic(pw, dses[0]);
            int today;
            today = dses[0].day;
            int i;
            SyncStorageEngine.DayStats ds;
            {
                i=1;
                {
                    ds = dses[i];
                    int delta;
                    delta = today-ds.day;
                    pw.print("  Day-");
                    pw.print(delta);
                    pw.print(":  ");
                    dumpDayStatistic(pw, ds);
                } //End block
            } //End collapsed parenthetic
            int weekDay;
            weekDay = today;
            {
                SyncStorageEngine.DayStats aggr;
                aggr = null;
                weekDay -= 7;
                {
                    ds = dses[i];
                    {
                        i = dses.length;
                    } //End block
                    int delta;
                    delta = weekDay-ds.day;
                    {
                        aggr = new SyncStorageEngine.DayStats(weekDay);
                    } //End block
                    aggr.successCount += ds.successCount;
                    aggr.successTime += ds.successTime;
                    aggr.failureCount += ds.failureCount;
                    aggr.failureTime += ds.failureTime;
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.601 -0400", hash_original_method = "3A4E555675ED758A699E30DB2B6A1D6C", hash_generated_method = "262D8295762AA1AE82AB9ECB07DEF49E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isSyncStillActive(ActiveSyncContext activeSyncContext) {
        dsTaint.addTaint(activeSyncContext.dsTaint);
        {
            Iterator<ActiveSyncContext> var38A241656A664BE053973521A7ED258D_1213170287 = (mActiveSyncContexts).iterator();
            var38A241656A664BE053973521A7ED258D_1213170287.hasNext();
            ActiveSyncContext sync = var38A241656A664BE053973521A7ED258D_1213170287.next();
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (ActiveSyncContext sync : mActiveSyncContexts) {
            //if (sync == activeSyncContext) {
                //return true;
            //}
        //}
        //return false;
    }

    
    private static class InitializerServiceConnection implements ServiceConnection {
        private Account mAccount;
        private String mAuthority;
        private Handler mHandler;
        private volatile Context mContext;
        private volatile boolean mInitialized;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.601 -0400", hash_original_method = "24302E8CE101646513826470385452C3", hash_generated_method = "DD496123FEDEEFF9F391316659580322")
        @DSModeled(DSC.SAFE)
        public InitializerServiceConnection(Account account, String authority, Context context,
                Handler handler) {
            dsTaint.addTaint(authority);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(account.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            mInitialized = false;
            // ---------- Original Method ----------
            //mAccount = account;
            //mAuthority = authority;
            //mContext = context;
            //mHandler = handler;
            //mInitialized = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.602 -0400", hash_original_method = "9C4A98A4ADBC598450E25E4EB304536B", hash_generated_method = "6B116135C83C26243E3CDEA3645CC302")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceConnected(ComponentName name, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(name.dsTaint);
            dsTaint.addTaint(service.dsTaint);
            try 
            {
                {
                    mInitialized = true;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_618730973 = (Log.isLoggable(TAG, Log.VERBOSE));
                    } //End collapsed parenthetic
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
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.602 -0400", hash_original_method = "64817B3D0D58B18C7C47E60B6E5CD293", hash_generated_method = "155839339AFB4ADEC68B1ADFF3B61F2E")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public void run() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.604 -0400", hash_original_method = "7C8777D718751E565C82B5C1458835CE", hash_generated_method = "62D86C8B711FBB36810783D4826BF191")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(name.dsTaint);
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
        public ActiveSyncContext activeSyncContext;
        public SyncResult syncResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.604 -0400", hash_original_method = "56E2C68849F116EE41FAA5D226ECBDA3", hash_generated_method = "2A7BA570E0177F82B12C44455D060B9C")
        @DSModeled(DSC.SAFE)
         SyncHandlerMessagePayload(ActiveSyncContext syncContext, SyncResult syncResult) {
            dsTaint.addTaint(syncContext.dsTaint);
            dsTaint.addTaint(syncResult.dsTaint);
            // ---------- Original Method ----------
            //this.activeSyncContext = syncContext;
            //this.syncResult = syncResult;
        }

        
    }


    
    class SyncAlarmIntentReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.604 -0400", hash_original_method = "15A691D38C5742F3CD9FD0866F019033", hash_generated_method = "15A691D38C5742F3CD9FD0866F019033")
                public SyncAlarmIntentReceiver ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.606 -0400", hash_original_method = "B17BCAD698B90432E3978D14A6575096", hash_generated_method = "298355B7AE5BA83C11986DD42F23FAED")
        @DSModeled(DSC.SPEC)
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            mHandleAlarmWakeLock.acquire();
            sendSyncAlarmMessage();
            // ---------- Original Method ----------
            //mHandleAlarmWakeLock.acquire();
            //sendSyncAlarmMessage();
        }

        
    }


    
    class ActiveSyncContext extends ISyncContext.Stub implements ServiceConnection, IBinder.DeathRecipient {
        SyncOperation mSyncOperation;
        long mHistoryRowId;
        ISyncAdapter mSyncAdapter;
        long mStartTime;
        long mTimeoutStartTime;
        boolean mBound;
        PowerManager.WakeLock mSyncWakeLock;
        int mSyncAdapterUid;
        SyncInfo mSyncInfo;
        boolean mIsLinkedToDeath = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.607 -0400", hash_original_method = "FBEF152C2B412533A606ADB2B9DA9D2A", hash_generated_method = "C923FE0D6BFC971380D080300D55E4FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ActiveSyncContext(SyncOperation syncOperation, long historyRowId,
                int syncAdapterUid) {
            super();
            dsTaint.addTaint(historyRowId);
            dsTaint.addTaint(syncAdapterUid);
            dsTaint.addTaint(syncOperation.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.608 -0400", hash_original_method = "7456DA1EA096E82DD762DA299B1797D3", hash_generated_method = "540CBBFBA53CA8CE698C636F326A356D")
        @DSModeled(DSC.SAFE)
        public void sendHeartbeat() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.609 -0400", hash_original_method = "2741CA480AE203CDFD1BCCBB420C487D", hash_generated_method = "B5227307C9904B99F79000D20A95AE22")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onFinished(SyncResult result) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(result.dsTaint);
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1390327442 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            sendSyncFinishedOrCanceledMessage(this, result);
            // ---------- Original Method ----------
            //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "onFinished: " + this);
            //sendSyncFinishedOrCanceledMessage(this, result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.610 -0400", hash_original_method = "EB9B131EDBEF0858B3038B79ABC0948E", hash_generated_method = "80E409FF4E2C95F956C06694EF7913AA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void toString(StringBuilder sb) {
            dsTaint.addTaint(sb.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.610 -0400", hash_original_method = "CBDE36ABE821F23EF1CFAFB665E67134", hash_generated_method = "7CF8D1D321913F7B273C0C849E3C712E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceConnected(ComponentName name, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(name.dsTaint);
            dsTaint.addTaint(service.dsTaint);
            Message msg;
            msg = mSyncHandler.obtainMessage();
            msg.what = SyncHandler.MESSAGE_SERVICE_CONNECTED;
            msg.obj = new ServiceConnectionData(this, ISyncAdapter.Stub.asInterface(service));
            mSyncHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //Message msg = mSyncHandler.obtainMessage();
            //msg.what = SyncHandler.MESSAGE_SERVICE_CONNECTED;
            //msg.obj = new ServiceConnectionData(this, ISyncAdapter.Stub.asInterface(service));
            //mSyncHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.611 -0400", hash_original_method = "E604348BDB0F3F95B7C0274B0D40964D", hash_generated_method = "113DA60C20365566A0EDBF88F3FDCE81")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(name.dsTaint);
            Message msg;
            msg = mSyncHandler.obtainMessage();
            msg.what = SyncHandler.MESSAGE_SERVICE_DISCONNECTED;
            msg.obj = new ServiceConnectionData(this, null);
            mSyncHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //Message msg = mSyncHandler.obtainMessage();
            //msg.what = SyncHandler.MESSAGE_SERVICE_DISCONNECTED;
            //msg.obj = new ServiceConnectionData(this, null);
            //mSyncHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.611 -0400", hash_original_method = "79606510FDB8502633B50F75722531BD", hash_generated_method = "80A4750A47DE44967F07E6AF4616A0BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean bindToSyncAdapter(RegisteredServicesCache.ServiceInfo info) {
            dsTaint.addTaint(info.dsTaint);
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1702485377 = (Log.isLoggable(TAG, Log.VERBOSE));
                {
                    Log.d(TAG, "bindToSyncAdapter: " + info.componentName + ", connection " + this);
                } //End block
            } //End collapsed parenthetic
            Intent intent;
            intent = new Intent();
            intent.setAction("android.content.SyncAdapter");
            intent.setComponent(info.componentName);
            intent.putExtra(Intent.EXTRA_CLIENT_LABEL,
                    com.android.internal.R.string.sync_binding_label);
            intent.putExtra(Intent.EXTRA_CLIENT_INTENT, PendingIntent.getActivity(
                    mContext, 0, new Intent(Settings.ACTION_SYNC_SETTINGS), 0));
            mBound = true;
            boolean bindResult;
            bindResult = mContext.bindService(intent, this,
                    Context.BIND_AUTO_CREATE | Context.BIND_NOT_FOREGROUND
                    | Context.BIND_ALLOW_OOM_MANAGEMENT);
            {
                mBound = false;
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.612 -0400", hash_original_method = "BCACA708B6725C3BB29ED8DCC5E23FC1", hash_generated_method = "8ACA69CF29BC443C585159EABF87E53F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void close() {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_836016241 = (Log.isLoggable(TAG, Log.VERBOSE));
                {
                    Log.d(TAG, "unBindFromSyncAdapter: connection " + this);
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.612 -0400", hash_original_method = "C99E9A460C6F28DBA730EF38203534A2", hash_generated_method = "AF554DA6A829EEF00860AD7871B252A7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            StringBuilder sb;
            sb = new StringBuilder();
            toString(sb);
            String var01ED4A9DFA1C94365291AB096B854A7B_1154147399 = (sb.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder sb = new StringBuilder();
            //toString(sb);
            //return sb.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.613 -0400", hash_original_method = "A39B4ABAEA9F27E501EB3B3EC7A37B2F", hash_generated_method = "A3A778C314C37C4C18C58B6CB51701C4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void binderDied() {
            sendSyncFinishedOrCanceledMessage(this, null);
            // ---------- Original Method ----------
            //sendSyncFinishedOrCanceledMessage(this, null);
        }

        
    }


    
    private static class AuthoritySyncStats {
        String name;
        long elapsedTime;
        int times;
        Map<String, AccountSyncStats> accountMap = Maps.newHashMap();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.613 -0400", hash_original_method = "BA2AD08D9B4BF110732C8291C5F36CF8", hash_generated_method = "DFEF6317A5BC79F2A41C8FCA7D371435")
        @DSModeled(DSC.SAFE)
        private AuthoritySyncStats(String name) {
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
            //this.name = name;
        }

        
    }


    
    private static class AccountSyncStats {
        String name;
        long elapsedTime;
        int times;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.613 -0400", hash_original_method = "1D94286E4C9E35DF248CEA39D6389F91", hash_generated_method = "ED8B16F3B0DFC64BC50A527D72FFF8B9")
        @DSModeled(DSC.SAFE)
        private AccountSyncStats(String name) {
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
            //this.name = name;
        }

        
    }


    
    private class SyncTimeTracker {
        boolean mLastWasSyncing = false;
        long mWhenSyncStarted = 0;
        private long mTimeSpentSyncing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.614 -0400", hash_original_method = "68E11B16C894EA776E18493F1FAE58FB", hash_generated_method = "68E11B16C894EA776E18493F1FAE58FB")
                public SyncTimeTracker ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.614 -0400", hash_original_method = "3978D6C321E5167908096EFEB475874E", hash_generated_method = "B1D5C336F10F4819A0EF24658B8C18DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void update() {
            boolean isSyncInProgress;
            isSyncInProgress = !mActiveSyncContexts.isEmpty();
            long now;
            now = SystemClock.elapsedRealtime();
            {
                mWhenSyncStarted = now;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.615 -0400", hash_original_method = "73972E33AC37B98D757DD1126931E451", hash_generated_method = "74028A941854DC36BF5D5628B36AF9AE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized long timeSpentSyncing() {
            long now;
            now = SystemClock.elapsedRealtime();
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //if (!mLastWasSyncing) return mTimeSpentSyncing;
            //final long now = SystemClock.elapsedRealtime();
            //return mTimeSpentSyncing + (now - mWhenSyncStarted);
        }

        
    }


    
    class ServiceConnectionData {
        public ActiveSyncContext activeSyncContext;
        public ISyncAdapter syncAdapter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.615 -0400", hash_original_method = "CF4E9A067E77243E4BB7B7FFBE17CC6D", hash_generated_method = "99BB47D70CD91338C5FFDE578E760278")
        @DSModeled(DSC.SAFE)
         ServiceConnectionData(ActiveSyncContext activeSyncContext, ISyncAdapter syncAdapter) {
            dsTaint.addTaint(activeSyncContext.dsTaint);
            dsTaint.addTaint(syncAdapter.dsTaint);
            // ---------- Original Method ----------
            //this.activeSyncContext = activeSyncContext;
            //this.syncAdapter = syncAdapter;
        }

        
    }


    
    class SyncHandler extends Handler {
        public SyncNotificationInfo mSyncNotificationInfo = new SyncNotificationInfo();
        private Long mAlarmScheduleTime = null;
        public SyncTimeTracker mSyncTimeTracker = new SyncTimeTracker();
        private HashMap<Pair<Account, String>, PowerManager.WakeLock> mWakeLocks =
                Maps.newHashMap();
        private volatile CountDownLatch mReadyToRunLatch = new CountDownLatch(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.615 -0400", hash_original_method = "483F6356A2D06E95B4EBFBB05049FAB5", hash_generated_method = "A229C8AF29C06D8E3046401769D77B23")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncHandler(Looper looper) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.616 -0400", hash_original_method = "A4C54FCCA01900F2BC7EC8A1E7F40380", hash_generated_method = "F8871811763F0C577983C96491676F31")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onBootCompleted() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mBootCompleted = true;
            mSyncStorageEngine.doDatabaseCleanup(AccountManager.get(mContext).getAccounts());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.616 -0400", hash_original_method = "F60450395CB7370B81745EFD5F3059FF", hash_generated_method = "D128A06AE323CAB4ED9E4A3374CF2A37")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private PowerManager.WakeLock getSyncWakeLock(Account account, String authority) {
            dsTaint.addTaint(authority);
            dsTaint.addTaint(account.dsTaint);
            Pair<Account, String> wakeLockKey;
            wakeLockKey = Pair.create(account, authority);
            PowerManager.WakeLock wakeLock;
            wakeLock = mWakeLocks.get(wakeLockKey);
            {
                String name;
                name = SYNC_WAKE_LOCK_PREFIX + "_" + authority + "_" + account;
                wakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, name);
                wakeLock.setReferenceCounted(false);
                mWakeLocks.put(wakeLockKey, wakeLock);
            } //End block
            return (PowerManager.WakeLock)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.617 -0400", hash_original_method = "CE8AE663CA89CC7DD7AABF796BC60E1D", hash_generated_method = "FE088508F84EEC22AF3E88C53DB24353")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void waitUntilReadyToRun() {
            CountDownLatch latch;
            latch = mReadyToRunLatch;
            {
                {
                    try 
                    {
                        latch.await();
                        mReadyToRunLatch = null;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.618 -0400", hash_original_method = "AC98BBE28F5005D2D34EEDF919BF395C", hash_generated_method = "58A5F4C0D259EB493574406B5FECC335")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            long earliestFuturePollTime;
            earliestFuturePollTime = Long.MAX_VALUE;
            long nextPendingSyncTime;
            nextPendingSyncTime = Long.MAX_VALUE;
            try 
            {
                waitUntilReadyToRun();
                mDataConnectionIsConnected = readDataConnectionState();
                mSyncManagerWakeLock.acquire();
                earliestFuturePollTime = scheduleReadyPeriodicSyncs();
                //Begin case SyncHandler.MESSAGE_CANCEL 
                {
                    Pair<Account, String> payload;
                    payload = (Pair<Account, String>)msg.obj;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_417979378 = (Log.isLoggable(TAG, Log.VERBOSE));
                        {
                            Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_CANCEL: "
                                    + payload.first + ", " + payload.second);
                        } //End block
                    } //End collapsed parenthetic
                    cancelActiveSyncLocked(payload.first, payload.second);
                    nextPendingSyncTime = maybeStartNextSyncLocked();
                } //End block
                //End case SyncHandler.MESSAGE_CANCEL 
                //Begin case SyncHandler.MESSAGE_SYNC_FINISHED 
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_78927470 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
                //End case SyncHandler.MESSAGE_SYNC_FINISHED 
                //Begin case SyncHandler.MESSAGE_SYNC_FINISHED 
                SyncHandlerMessagePayload payload;
                payload = (SyncHandlerMessagePayload)msg.obj;
                //End case SyncHandler.MESSAGE_SYNC_FINISHED 
                //Begin case SyncHandler.MESSAGE_SYNC_FINISHED 
                {
                    boolean varBA2B30809006AC87B4F9ED60448095E9_1780318662 = (!isSyncStillActive(payload.activeSyncContext));
                    {
                        Log.d(TAG, "handleSyncHandlerMessage: dropping since the "
                                    + "sync is no longer active: "
                                    + payload.activeSyncContext);
                    } //End block
                } //End collapsed parenthetic
                //End case SyncHandler.MESSAGE_SYNC_FINISHED 
                //Begin case SyncHandler.MESSAGE_SYNC_FINISHED 
                runSyncFinishedOrCanceledLocked(payload.syncResult, payload.activeSyncContext);
                //End case SyncHandler.MESSAGE_SYNC_FINISHED 
                //Begin case SyncHandler.MESSAGE_SYNC_FINISHED 
                nextPendingSyncTime = maybeStartNextSyncLocked();
                //End case SyncHandler.MESSAGE_SYNC_FINISHED 
                //Begin case SyncHandler.MESSAGE_SERVICE_CONNECTED 
                {
                    ServiceConnectionData msgData;
                    msgData = (ServiceConnectionData)msg.obj;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_200132296 = (Log.isLoggable(TAG, Log.VERBOSE));
                        {
                            Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_CONNECTED: "
                                    + msgData.activeSyncContext);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varC7FD95DDD2260EADDB8E624A9C0825F6_1619104663 = (isSyncStillActive(msgData.activeSyncContext));
                        {
                            runBoundToSyncAdapter(msgData.activeSyncContext, msgData.syncAdapter);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                //End case SyncHandler.MESSAGE_SERVICE_CONNECTED 
                //Begin case SyncHandler.MESSAGE_SERVICE_DISCONNECTED 
                {
                    ActiveSyncContext currentSyncContext;
                    currentSyncContext = ((ServiceConnectionData)msg.obj).activeSyncContext;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1265881907 = (Log.isLoggable(TAG, Log.VERBOSE));
                        {
                            Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_DISCONNECTED: "
                                    + currentSyncContext);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var8ABF090AC2884C22D7C7551D49051447_330490534 = (isSyncStillActive(currentSyncContext));
                        {
                            {
                                try 
                                {
                                    currentSyncContext.mSyncAdapter.cancelSync(currentSyncContext);
                                } //End block
                                catch (RemoteException e)
                                { }
                            } //End block
                            SyncResult syncResult;
                            syncResult = new SyncResult();
                            runSyncFinishedOrCanceledLocked(syncResult, currentSyncContext);
                            nextPendingSyncTime = maybeStartNextSyncLocked();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                //End case SyncHandler.MESSAGE_SERVICE_DISCONNECTED 
                //Begin case SyncHandler.MESSAGE_SYNC_ALARM 
                {
                    boolean isLoggable;
                    isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
                    mAlarmScheduleTime = null;
                    try 
                    {
                        nextPendingSyncTime = maybeStartNextSyncLocked();
                    } //End block
                    finally 
                    {
                        mHandleAlarmWakeLock.release();
                    } //End block
                } //End block
                //End case SyncHandler.MESSAGE_SYNC_ALARM 
                //Begin case SyncHandler.MESSAGE_CHECK_ALARMS 
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_231863206 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
                //End case SyncHandler.MESSAGE_CHECK_ALARMS 
                //Begin case SyncHandler.MESSAGE_CHECK_ALARMS 
                nextPendingSyncTime = maybeStartNextSyncLocked();
                //End case SyncHandler.MESSAGE_CHECK_ALARMS 
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.664 -0400", hash_original_method = "5F18B995A8D5126079C876CBB8B37FF8", hash_generated_method = "BAB72AA2FF2AF9947135CCACD49E0799")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private long scheduleReadyPeriodicSyncs() {
            boolean backgroundDataUsageAllowed;
            backgroundDataUsageAllowed = getConnectivityManager().getBackgroundDataSetting();
            long earliestFuturePollTime;
            earliestFuturePollTime = Long.MAX_VALUE;
            {
                boolean varC4F9DD6A708570A0C749B94E2E7FDF0F_1894349527 = (!backgroundDataUsageAllowed || !mSyncStorageEngine.getMasterSyncAutomatically());
            } //End collapsed parenthetic
            long nowAbsolute;
            nowAbsolute = System.currentTimeMillis();
            ArrayList<SyncStorageEngine.AuthorityInfo> infos;
            infos = mSyncStorageEngine.getAuthorities();
            {
                Iterator<SyncStorageEngine.AuthorityInfo> varC4FCEB1607AD0D2D215FDDD8362DAF36_140716860 = (infos).iterator();
                varC4FCEB1607AD0D2D215FDDD8362DAF36_140716860.hasNext();
                SyncStorageEngine.AuthorityInfo info = varC4FCEB1607AD0D2D215FDDD8362DAF36_140716860.next();
                {
                    {
                        boolean var4F72312E8BC45601DFFBAD51C30C06F1_1721914964 = (!ArrayUtils.contains(mAccounts, info.account));
                    } //End collapsed parenthetic
                    {
                        boolean var41663A909D23D063D4B5AFBCA7A8A368_229943100 = (!mSyncStorageEngine.getSyncAutomatically(info.account, info.authority));
                    } //End collapsed parenthetic
                    {
                        boolean varBF1A825481B58DFD24124DB4EE59FE57_913678261 = (mSyncStorageEngine.getIsSyncable(info.account, info.authority) == 0);
                    } //End collapsed parenthetic
                    SyncStatusInfo status;
                    status = mSyncStorageEngine.getOrCreateSyncStatus(info);
                    {
                        int i, N;
                        i = 0;
                        N = info.periodicSyncs.size();
                        {
                            Bundle extras;
                            extras = info.periodicSyncs.get(i).first;
                            Long periodInSeconds;
                            periodInSeconds = info.periodicSyncs.get(i).second;
                            long lastPollTimeAbsolute;
                            lastPollTimeAbsolute = status.getPeriodicSyncTime(i);
                            long nextPollTimeAbsolute;
                            nextPollTimeAbsolute = nowAbsolute;
                            nextPollTimeAbsolute = lastPollTimeAbsolute + periodInSeconds * 1000;
                            {
                                Pair<Long, Long> backoff;
                                backoff = mSyncStorageEngine.getBackoff(info.account, info.authority);
                                RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo;
                                syncAdapterInfo = mSyncAdapters.getServiceInfo(
                                        SyncAdapterType.newKey(info.authority, info.account.type));
                                scheduleSyncOperation(
                                new SyncOperation(info.account, SyncStorageEngine.SOURCE_PERIODIC,
                                        info.authority, extras, 0 ,
                                        backoff != null ? backoff.first : 0,
                                        mSyncStorageEngine.getDelayUntilTime(
                                                info.account, info.authority),
                                        syncAdapterInfo.type.allowParallelSyncs()));
                                status.setPeriodicSyncTime(i, nowAbsolute);
                            } //End block
                            {
                                {
                                    earliestFuturePollTime = nextPollTimeAbsolute;
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            long var377A5C4AB2ECC9D2ABC9EC45C6319817_1706495848 = (SystemClock.elapsedRealtime()
                    + ((earliestFuturePollTime < nowAbsolute)
                      ? 0
                      : (earliestFuturePollTime - nowAbsolute))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.770 -0400", hash_original_method = "8B5418D48FBDFB608CDA80C6788E1356", hash_generated_method = "441FEC9D26689F637C1AE4156A09C6CB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private long maybeStartNextSyncLocked() {
            boolean isLoggable;
            isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
            Account[] accounts;
            accounts = mAccounts;
            boolean backgroundDataUsageAllowed;
            backgroundDataUsageAllowed = getConnectivityManager().getBackgroundDataSetting();
            boolean masterSyncAutomatically;
            masterSyncAutomatically = mSyncStorageEngine.getMasterSyncAutomatically();
            long now;
            now = SystemClock.elapsedRealtime();
            long nextReadyToRunTime;
            nextReadyToRunTime = Long.MAX_VALUE;
            ArrayList<SyncOperation> operations;
            operations = new ArrayList<SyncOperation>();
            {
                Iterator<SyncOperation> operationIterator;
                operationIterator = mSyncQueue.mOperationsMap.values().iterator();
                {
                    boolean var340C1D4D9E1D2C91EE6FE9A98B7CEC0B_785773421 = (operationIterator.hasNext());
                    {
                        SyncOperation op;
                        op = operationIterator.next();
                        {
                            boolean var9DF7D9069DE48617930394A60905575E_947673590 = (!ArrayUtils.contains(mAccounts, op.account));
                            {
                                operationIterator.remove();
                                mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                            } //End block
                        } //End collapsed parenthetic
                        int syncableState;
                        syncableState = mSyncStorageEngine.getIsSyncable(op.account, op.authority);
                        {
                            operationIterator.remove();
                            mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                        } //End block
                        {
                            {
                                nextReadyToRunTime = op.effectiveRunTime;
                            } //End block
                        } //End block
                        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo;
                        syncAdapterInfo = mSyncAdapters.getServiceInfo(
                            SyncAdapterType.newKey(op.authority, op.account.type));
                        boolean uidNetworkConnected;
                        {
                            NetworkInfo networkInfo;
                            networkInfo = getConnectivityManager()
                                .getActiveNetworkInfoForUid(syncAdapterInfo.uid);
                            uidNetworkConnected = networkInfo != null && networkInfo.isConnected();
                        } //End block
                        {
                            uidNetworkConnected = false;
                        } //End block
                        {
                            boolean var5A423FA495D65808CF647D9D5D5D33E5_842986301 = (!op.extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, false)
                            && (syncableState > 0)
                            && (!masterSyncAutomatically
                                || !backgroundDataUsageAllowed
                                || !uidNetworkConnected
                                || !mSyncStorageEngine.getSyncAutomatically(
                                       op.account, op.authority)));
                            {
                                operationIterator.remove();
                                mSyncStorageEngine.deleteFromPending(op.pendingOperation);
                            } //End block
                        } //End collapsed parenthetic
                        operations.add(op);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            Collections.sort(operations);
            {
                int i, N;
                i = 0;
                N = operations.size();
                {
                    SyncOperation candidate;
                    candidate = operations.get(i);
                    boolean candidateIsInitialization;
                    candidateIsInitialization = candidate.isInitialization();
                    int numInit;
                    numInit = 0;
                    int numRegular;
                    numRegular = 0;
                    ActiveSyncContext conflict;
                    conflict = null;
                    ActiveSyncContext longRunning;
                    longRunning = null;
                    ActiveSyncContext toReschedule;
                    toReschedule = null;
                    {
                        Iterator<ActiveSyncContext> var20645BE964392164F6E4174B19EE47A5_255677436 = (mActiveSyncContexts).iterator();
                        var20645BE964392164F6E4174B19EE47A5_255677436.hasNext();
                        ActiveSyncContext activeSyncContext = var20645BE964392164F6E4174B19EE47A5_255677436.next();
                        {
                            SyncOperation activeOp;
                            activeOp = activeSyncContext.mSyncOperation;
                            {
                                boolean var88156E87F289A86AB7CC4C7CE0A7364C_830715303 = (activeOp.isInitialization());
                            } //End collapsed parenthetic
                            {
                                boolean var3BD76041BE9F72E30B119A23228D3264_952959105 = (activeOp.account.type.equals(candidate.account.type)
                            && activeOp.authority.equals(candidate.authority)
                            && (!activeOp.allowParallelSyncs
                                || activeOp.account.name.equals(candidate.account.name)));
                                {
                                    conflict = activeSyncContext;
                                } //End block
                                {
                                    {
                                        boolean var79DB07D9BA6372A590E984F48C84F69B_1208653179 = (candidateIsInitialization == activeOp.isInitialization()
                                && activeSyncContext.mStartTime + MAX_TIME_PER_SYNC < now);
                                        {
                                            longRunning = activeSyncContext;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    {
                        {
                            boolean varD6CAC9C6C357DD6052AAB1ED368A7093_447879561 = (candidateIsInitialization && !conflict.mSyncOperation.isInitialization()
                            && numInit < MAX_SIMULTANEOUS_INITIALIZATION_SYNCS);
                            {
                                toReschedule = conflict;
                                {
                                    boolean varB886653DBE5AD63346733F0FC6D36E19_2123513406 = (Log.isLoggable(TAG, Log.VERBOSE));
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean varEBD4A65C44B5C00E1C33A1C6DE2B79F3_1158033846 = (candidate.expedited && !conflict.mSyncOperation.expedited
                            && (candidateIsInitialization
                                == conflict.mSyncOperation.isInitialization()));
                                {
                                    toReschedule = conflict;
                                    {
                                        boolean varCF8461C47EF234EA3373DC7BC06410EC_1233843822 = (Log.isLoggable(TAG, Log.VERBOSE));
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean roomAvailable;
                        roomAvailable = numInit < MAX_SIMULTANEOUS_INITIALIZATION_SYNCS;
                        roomAvailable = numRegular < MAX_SIMULTANEOUS_REGULAR_SYNCS;
                        {
                            boolean var2AB44D382A887D969D31457896E79E6B_897562285 = (longRunning != null
                            && (candidateIsInitialization
                                == longRunning.mSyncOperation.isInitialization()));
                            {
                                toReschedule = longRunning;
                                {
                                    boolean varB886653DBE5AD63346733F0FC6D36E19_916256071 = (Log.isLoggable(TAG, Log.VERBOSE));
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        runSyncFinishedOrCanceledLocked(null, toReschedule);
                        scheduleSyncOperation(toReschedule.mSyncOperation);
                    } //End block
                    {
                        mSyncQueue.remove(candidate);
                    } //End block
                    dispatchSyncOperation(candidate);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.781 -0400", hash_original_method = "40340E62514BC19DB7E9216642814F86", hash_generated_method = "43401D893D8F7487DDEF78953524D453")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean dispatchSyncOperation(SyncOperation op) {
            dsTaint.addTaint(op.dsTaint);
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_2093790606 = (Log.isLoggable(TAG, Log.VERBOSE));
                {
                    {
                        Iterator<ActiveSyncContext> varBCD99CACB997EB3D1458946CDF6FE790_964703382 = (mActiveSyncContexts).iterator();
                        varBCD99CACB997EB3D1458946CDF6FE790_964703382.hasNext();
                        ActiveSyncContext syncContext = varBCD99CACB997EB3D1458946CDF6FE790_964703382.next();
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            SyncAdapterType syncAdapterType;
            syncAdapterType = SyncAdapterType.newKey(op.authority, op.account.type);
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo;
            syncAdapterInfo = mSyncAdapters.getServiceInfo(syncAdapterType);
            {
                Log.d(TAG, "can't find a sync adapter for " + syncAdapterType
                        + ", removing settings for it");
                mSyncStorageEngine.removeAuthority(op.account, op.authority);
            } //End block
            ActiveSyncContext activeSyncContext;
            activeSyncContext = new ActiveSyncContext(op, insertStartSyncEvent(op), syncAdapterInfo.uid);
            activeSyncContext.mSyncInfo = mSyncStorageEngine.addActiveSync(activeSyncContext);
            mActiveSyncContexts.add(activeSyncContext);
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_35599524 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            {
                boolean var689CF975CE88D03CB21DEFF3F17DC74D_540009937 = (!activeSyncContext.bindToSyncAdapter(syncAdapterInfo));
                {
                    closeActiveSyncContext(activeSyncContext);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.783 -0400", hash_original_method = "61AEAAC860377C6ACC1D13743DAD80A2", hash_generated_method = "6DF122A218E47BE6D8FB816684DC501E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void runBoundToSyncAdapter(final ActiveSyncContext activeSyncContext,
              ISyncAdapter syncAdapter) {
            dsTaint.addTaint(activeSyncContext.dsTaint);
            dsTaint.addTaint(syncAdapter.dsTaint);
            activeSyncContext.mSyncAdapter = syncAdapter;
            SyncOperation syncOperation;
            syncOperation = activeSyncContext.mSyncOperation;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.791 -0400", hash_original_method = "7B28CEC882EFEBA05BFBBAFD319121EA", hash_generated_method = "4B7B651193CA9C72B17BFABC6F012C6E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void cancelActiveSyncLocked(Account account, String authority) {
            dsTaint.addTaint(authority);
            dsTaint.addTaint(account.dsTaint);
            ArrayList<ActiveSyncContext> activeSyncs;
            activeSyncs = new ArrayList<ActiveSyncContext>(mActiveSyncContexts);
            {
                Iterator<ActiveSyncContext> varAAAC086D3900935D623B1369638ED0DB_1037721006 = (activeSyncs).iterator();
                varAAAC086D3900935D623B1369638ED0DB_1037721006.hasNext();
                ActiveSyncContext activeSyncContext = varAAAC086D3900935D623B1369638ED0DB_1037721006.next();
                {
                    {
                        {
                            {
                                boolean var8037C8DE9F4E8AA58BB79ADB5D51F3E6_1604663622 = (!account.equals(activeSyncContext.mSyncOperation.account));
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                boolean varF9430EBD0568960E5EAFBC08F8B701A4_422816537 = (!authority.equals(activeSyncContext.mSyncOperation.authority));
                            } //End collapsed parenthetic
                        } //End block
                        runSyncFinishedOrCanceledLocked(null ,
                            activeSyncContext);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.792 -0400", hash_original_method = "8D8637124BC010FEF841826099E3536E", hash_generated_method = "A6F92FC66BBD26FE05FB53792B70585B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void runSyncFinishedOrCanceledLocked(SyncResult syncResult,
                ActiveSyncContext activeSyncContext) {
            dsTaint.addTaint(activeSyncContext.dsTaint);
            dsTaint.addTaint(syncResult.dsTaint);
            boolean isLoggable;
            isLoggable = Log.isLoggable(TAG, Log.VERBOSE);
            {
                activeSyncContext.mSyncAdapter.asBinder().unlinkToDeath(activeSyncContext, 0);
                activeSyncContext.mIsLinkedToDeath = false;
            } //End block
            closeActiveSyncContext(activeSyncContext);
            SyncOperation syncOperation;
            syncOperation = activeSyncContext.mSyncOperation;
            long elapsedTime;
            elapsedTime = SystemClock.elapsedRealtime() - activeSyncContext.mStartTime;
            String historyMessage;
            int downstreamActivity;
            int upstreamActivity;
            {
                {
                    boolean var3966D9B0F8863425CFD3A0BE46FDBEF6_198562235 = (!syncResult.hasError());
                    {
                        historyMessage = SyncStorageEngine.MESG_SUCCESS;
                        downstreamActivity = 0;
                        upstreamActivity = 0;
                        clearBackoffSetting(syncOperation);
                    } //End block
                    {
                        Log.d(TAG, "failed sync operation " + syncOperation + ", " + syncResult);
                        {
                            increaseBackoffSetting(syncOperation);
                        } //End block
                        maybeRescheduleSync(syncResult, syncOperation);
                        historyMessage = Integer.toString(syncResultToErrorNumber(syncResult));
                        downstreamActivity = 0;
                        upstreamActivity = 0;
                    } //End block
                } //End collapsed parenthetic
                setDelayUntilTime(syncOperation, syncResult.delayUntil);
            } //End block
            {
                {
                    try 
                    {
                        activeSyncContext.mSyncAdapter.cancelSync(activeSyncContext);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
                historyMessage = SyncStorageEngine.MESG_CANCELED;
                downstreamActivity = 0;
                upstreamActivity = 0;
            } //End block
            stopSyncEvent(activeSyncContext.mHistoryRowId, syncOperation, historyMessage,
                    upstreamActivity, downstreamActivity, elapsedTime);
            {
                installHandleTooManyDeletesNotification(syncOperation.account,
                        syncOperation.authority, syncResult.stats.numDeletes);
            } //End block
            {
                mNotificationMgr.cancel(
                        syncOperation.account.hashCode() ^ syncOperation.authority.hashCode());
            } //End block
            {
                scheduleSyncOperation(new SyncOperation(syncOperation.account,
                        syncOperation.syncSource, syncOperation.authority, new Bundle(), 0,
                        syncOperation.backoff, syncOperation.delayUntil,
                        syncOperation.allowParallelSyncs));
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.793 -0400", hash_original_method = "1880B76D7799B7E884F5DD7B88555973", hash_generated_method = "335B135D7D66F09A6CF2B029DDD25876")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void closeActiveSyncContext(ActiveSyncContext activeSyncContext) {
            dsTaint.addTaint(activeSyncContext.dsTaint);
            activeSyncContext.close();
            mActiveSyncContexts.remove(activeSyncContext);
            mSyncStorageEngine.removeActiveSync(activeSyncContext.mSyncInfo);
            // ---------- Original Method ----------
            //activeSyncContext.close();
            //mActiveSyncContexts.remove(activeSyncContext);
            //mSyncStorageEngine.removeActiveSync(activeSyncContext.mSyncInfo);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.793 -0400", hash_original_method = "F73ADCF1F7F7E573F488FB12A7E0DEC9", hash_generated_method = "D395CFF5FC71C225E0B5E409FBF59A4F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int syncResultToErrorNumber(SyncResult syncResult) {
            dsTaint.addTaint(syncResult.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("we are not in an error state, " + syncResult);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.817 -0400", hash_original_method = "D7164ED4506DE94304BF76B0FBC03583", hash_generated_method = "FC8CFD47B45646D9452379C1A17B87DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void manageSyncNotificationLocked() {
            boolean shouldCancel;
            boolean shouldInstall;
            {
                boolean var81ED16291C5BDEEB678C6A2565F01300_183548132 = (mActiveSyncContexts.isEmpty());
                {
                    mSyncNotificationInfo.startTime = null;
                    shouldCancel = mSyncNotificationInfo.isActive;
                    shouldInstall = false;
                } //End block
                {
                    long now;
                    now = SystemClock.elapsedRealtime();
                    {
                        mSyncNotificationInfo.startTime = now;
                    } //End block
                    {
                        shouldInstall = shouldCancel = false;
                    } //End block
                    {
                        shouldCancel = false;
                        boolean timeToShowNotification;
                        timeToShowNotification = now > mSyncNotificationInfo.startTime + SYNC_NOTIFICATION_DELAY;
                        {
                            shouldInstall = true;
                        } //End block
                        {
                            shouldInstall = false;
                            {
                                Iterator<ActiveSyncContext> var20645BE964392164F6E4174B19EE47A5_2100116689 = (mActiveSyncContexts).iterator();
                                var20645BE964392164F6E4174B19EE47A5_2100116689.hasNext();
                                ActiveSyncContext activeSyncContext = var20645BE964392164F6E4174B19EE47A5_2100116689.next();
                                {
                                    boolean manualSync;
                                    manualSync = activeSyncContext.mSyncOperation.extras
                                    .getBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, false);
                                    {
                                        shouldInstall = true;
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                mNeedSyncActiveNotification = false;
                sendSyncStateIntent();
                mSyncNotificationInfo.isActive = false;
            } //End block
            {
                mNeedSyncActiveNotification = true;
                sendSyncStateIntent();
                mSyncNotificationInfo.isActive = true;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.859 -0400", hash_original_method = "E1B88EC7C887370D571018E17194D40D", hash_generated_method = "09168946291D0FB034EF55C400EA8167")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void manageSyncAlarmLocked(long nextPeriodicEventElapsedTime,
                long nextPendingEventElapsedTime) {
            dsTaint.addTaint(nextPeriodicEventElapsedTime);
            dsTaint.addTaint(nextPendingEventElapsedTime);
            long notificationTime;
            notificationTime = mSyncHandler.mSyncNotificationInfo.startTime + SYNC_NOTIFICATION_DELAY;
            notificationTime = Long.MAX_VALUE;
            long earliestTimeoutTime;
            earliestTimeoutTime = Long.MAX_VALUE;
            {
                Iterator<ActiveSyncContext> varB42644AE74A51E951ED6AB5DD20DA8CE_65105899 = (mActiveSyncContexts).iterator();
                varB42644AE74A51E951ED6AB5DD20DA8CE_65105899.hasNext();
                ActiveSyncContext currentSyncContext = varB42644AE74A51E951ED6AB5DD20DA8CE_65105899.next();
                {
                    long currentSyncTimeoutTime;
                    currentSyncTimeoutTime = currentSyncContext.mTimeoutStartTime + MAX_TIME_PER_SYNC;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1840198858 = (Log.isLoggable(TAG, Log.VERBOSE));
                    } //End collapsed parenthetic
                    {
                        earliestTimeoutTime = currentSyncTimeoutTime;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1485634010 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_65416519 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_958148264 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1751462227 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            long alarmTime;
            alarmTime = Math.min(notificationTime, earliestTimeoutTime);
            alarmTime = Math.min(alarmTime, nextPeriodicEventElapsedTime);
            alarmTime = Math.min(alarmTime, nextPendingEventElapsedTime);
            long now;
            now = SystemClock.elapsedRealtime();
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_29502594 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
                alarmTime = now + SYNC_ALARM_TIMEOUT_MIN;
            } //End block
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1665389258 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
                alarmTime = now + SYNC_ALARM_TIMEOUT_MAX;
            } //End block
            boolean shouldSet;
            shouldSet = false;
            boolean shouldCancel;
            shouldCancel = false;
            boolean alarmIsActive;
            alarmIsActive = mAlarmScheduleTime != null;
            boolean needAlarm;
            needAlarm = alarmTime != Long.MAX_VALUE;
            {
                {
                    shouldSet = true;
                } //End block
            } //End block
            {
                shouldCancel = alarmIsActive;
            } //End block
            ensureAlarmService();
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1747092534 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
                mAlarmScheduleTime = alarmTime;
                mAlarmService.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, alarmTime,
                        mSyncAlarmIntent);
            } //End block
            {
                mAlarmScheduleTime = null;
                mAlarmService.cancel(mSyncAlarmIntent);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.859 -0400", hash_original_method = "A9010BB637A8EEC323C58050189C44ED", hash_generated_method = "B44B2E041947CAC83E07E81F7AF1EC3B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void sendSyncStateIntent() {
            Intent syncStateIntent;
            syncStateIntent = new Intent(Intent.ACTION_SYNC_STATE_CHANGED);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.860 -0400", hash_original_method = "87A468A0891FD210AAD2B0099F053FF2", hash_generated_method = "2783FE4DDD79D6133D1D1EE0063B57F8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void installHandleTooManyDeletesNotification(Account account, String authority,
                long numDeletes) {
            dsTaint.addTaint(authority);
            dsTaint.addTaint(account.dsTaint);
            dsTaint.addTaint(numDeletes);
            ProviderInfo providerInfo;
            providerInfo = mContext.getPackageManager().resolveContentProvider(
                    authority, 0 );
            CharSequence authorityName;
            authorityName = providerInfo.loadLabel(mContext.getPackageManager());
            Intent clickIntent;
            clickIntent = new Intent(mContext, SyncActivityTooManyDeletes.class);
            clickIntent.putExtra("account", account);
            clickIntent.putExtra("authority", authority);
            clickIntent.putExtra("provider", authorityName.toString());
            clickIntent.putExtra("numDeletes", numDeletes);
            {
                boolean varF70BDA0CA489003C43C444F0D1E24D31_965452281 = (!isActivityAvailable(clickIntent));
            } //End collapsed parenthetic
            PendingIntent pendingIntent;
            pendingIntent = PendingIntent
                    .getActivity(mContext, 0, clickIntent, PendingIntent.FLAG_CANCEL_CURRENT);
            CharSequence tooManyDeletesDescFormat;
            tooManyDeletesDescFormat = mContext.getResources().getText(
                    R.string.contentServiceTooManyDeletesNotificationDesc);
            Notification notification;
            notification = new Notification(R.drawable.stat_notify_sync_error,
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.869 -0400", hash_original_method = "ABB616725C31652C20F8F96BBDEFC6AA", hash_generated_method = "05796A1B197B7E0B491FAA8F8286EE2E")
        @DSModeled(DSC.SPEC)
        private boolean isActivityAvailable(Intent intent) {
            dsTaint.addTaint(intent.dsTaint);
            PackageManager pm;
            pm = mContext.getPackageManager();
            List<ResolveInfo> list;
            list = pm.queryIntentActivities(intent, 0);
            int listSize;
            listSize = list.size();
            {
                int i;
                i = 0;
                {
                    ResolveInfo resolveInfo;
                    resolveInfo = list.get(i);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.872 -0400", hash_original_method = "6B3E86A8BC94835376C1AE5FBE72A92C", hash_generated_method = "7164698F586D9C511798A324BC800211")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long insertStartSyncEvent(SyncOperation syncOperation) {
            dsTaint.addTaint(syncOperation.dsTaint);
            int source;
            source = syncOperation.syncSource;
            long now;
            now = System.currentTimeMillis();
            EventLog.writeEvent(2720, syncOperation.authority,
                                SyncStorageEngine.EVENT_START, source,
                                syncOperation.account.name.hashCode());
            long var4469B750121AA371E44777A358FA181D_1345614410 = (mSyncStorageEngine.insertStartSyncEvent(
                    syncOperation.account, syncOperation.authority, now, source));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //final int source = syncOperation.syncSource;
            //final long now = System.currentTimeMillis();
            //EventLog.writeEvent(2720, syncOperation.authority,
                                //SyncStorageEngine.EVENT_START, source,
                                //syncOperation.account.name.hashCode());
            //return mSyncStorageEngine.insertStartSyncEvent(
                    //syncOperation.account, syncOperation.authority, now, source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.873 -0400", hash_original_method = "7B2BF6D83EFC49C83F4A75250B3225F9", hash_generated_method = "4E8C2411636E570EC4574F84B844FA0F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void stopSyncEvent(long rowId, SyncOperation syncOperation, String resultMessage,
                int upstreamActivity, int downstreamActivity, long elapsedTime) {
            dsTaint.addTaint(upstreamActivity);
            dsTaint.addTaint(downstreamActivity);
            dsTaint.addTaint(syncOperation.dsTaint);
            dsTaint.addTaint(rowId);
            dsTaint.addTaint(resultMessage);
            dsTaint.addTaint(elapsedTime);
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
            public boolean isActive = false;
            public Long startTime = null;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.873 -0400", hash_original_method = "3A47F234F22BCF79597B22B926A6F0E5", hash_generated_method = "3A47F234F22BCF79597B22B926A6F0E5")
                        public SyncNotificationInfo ()
            {
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.874 -0400", hash_original_method = "4796BE9F4C6BFE28E8FE17808C5D7635", hash_generated_method = "A6766942277BA5FAAC27AF259EA64DC6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void toString(StringBuilder sb) {
                dsTaint.addTaint(sb.dsTaint);
                sb.append("isActive ").append(isActive).append(", startTime ").append(startTime);
                // ---------- Original Method ----------
                //sb.append("isActive ").append(isActive).append(", startTime ").append(startTime);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.875 -0400", hash_original_method = "C99E9A460C6F28DBA730EF38203534A2", hash_generated_method = "1EB56373FDBC951C8D7262761A106307")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public String toString() {
                StringBuilder sb;
                sb = new StringBuilder();
                toString(sb);
                String var799543C9B831513751222BDCB0ED87E8_41686453 = (sb.toString());
                return dsTaint.getTaintString();
                // ---------- Original Method ----------
                //StringBuilder sb = new StringBuilder();
                //toString(sb);
                //return sb.toString();
            }

            
        }


        
        private static final int MESSAGE_SYNC_FINISHED = 1;
        private static final int MESSAGE_SYNC_ALARM = 2;
        private static final int MESSAGE_CHECK_ALARMS = 3;
        private static final int MESSAGE_SERVICE_CONNECTED = 4;
        private static final int MESSAGE_SERVICE_DISCONNECTED = 5;
        private static final int MESSAGE_CANCEL = 6;
    }


    
    private static final String TAG = "SyncManager";
    private static final long LOCAL_SYNC_DELAY;
    private static final long MAX_TIME_PER_SYNC;
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
    
    private static final long SYNC_NOTIFICATION_DELAY;
    private static final long INITIAL_SYNC_RETRY_TIME_IN_MS = 30 * 1000;
    private static final long DEFAULT_MAX_SYNC_RETRY_TIME_IN_SECONDS = 60 * 60;
    private static final int DELAY_RETRY_SYNC_IN_PROGRESS_IN_SECONDS = 10;
    private static final int INITIALIZATION_UNBIND_DELAY_MS = 5000;
    private static final String SYNC_WAKE_LOCK_PREFIX = "*sync*";
    private static final String HANDLE_SYNC_ALARM_WAKE_LOCK = "SyncManagerHandleSyncAlarm";
    private static final String SYNC_LOOP_WAKE_LOCK = "SyncLoopWakeLock";
    private static final int MAX_SIMULTANEOUS_REGULAR_SYNCS;
    private static final int MAX_SIMULTANEOUS_INITIALIZATION_SYNCS;
    private static final Account[] INITIAL_ACCOUNTS_ARRAY = new Account[0];
    private static final long SYNC_ALARM_TIMEOUT_MIN = 30 * 1000;
    private static final long SYNC_ALARM_TIMEOUT_MAX = 2 * 60 * 60 * 1000;
    private static final String ACTION_SYNC_ALARM = "android.content.syncmanager.SYNC_ALARM";
}

