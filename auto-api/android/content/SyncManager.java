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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.445 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.446 -0400", hash_original_field = "C217519E7D6AA72743CEC5E5FD7C02F1", hash_generated_field = "F3BBCBF609328E3671F4870EF2739BA1")

    private volatile Account[] mAccounts = INITIAL_ACCOUNTS_ARRAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.446 -0400", hash_original_field = "3607537A4ABC9C2B0FDA6CD04E7BA4CF", hash_generated_field = "EA882B4EDA8036D1634A0912AFD18614")

    volatile private PowerManager.WakeLock mHandleAlarmWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.446 -0400", hash_original_field = "B8A7E3B6F94CE3A0F567CD61AFB97855", hash_generated_field = "8C143BC8231548B929C0E876431327F2")

    volatile private PowerManager.WakeLock mSyncManagerWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.446 -0400", hash_original_field = "4728A84AF4B8DF029806A2097B575A3A", hash_generated_field = "17D5CCC25BF0F59A9B8C5AD2751D5254")

    volatile private boolean mDataConnectionIsConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.447 -0400", hash_original_field = "B81CB3C0F8BD276814C574302F581993", hash_generated_field = "466B67045A4516E83F397111D3AB9D8F")

    volatile private boolean mStorageIsLow = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.447 -0400", hash_original_field = "1D89DACDF96236F3858ECCE33A51EFED", hash_generated_field = "E3BFB96D82A2106A16337E9442023DA0")

    private NotificationManager mNotificationMgr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.447 -0400", hash_original_field = "917992EEA0C7F4BC7CC5D5B270F6017F", hash_generated_field = "A708A7397CF3CD2AD62512A76A16AA9A")

    private AlarmManager mAlarmService = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.447 -0400", hash_original_field = "45147E3AEB1E4ADCE06A13083E577526", hash_generated_field = "C4D1F4553F2DAB654514F44F7C643ACD")

    private SyncStorageEngine mSyncStorageEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.447 -0400", hash_original_field = "C9FDEBC8B43E8CF10A847D8E78A297F9", hash_generated_field = "9C22406DD21183D6092ABB0219CA18DB")

    public SyncQueue mSyncQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.447 -0400", hash_original_field = "969116B6B37E354467E9B2E8F3E55C0D", hash_generated_field = "829FAAE4B7F55725AC25661F8B19BBBF")

    protected ArrayList<ActiveSyncContext> mActiveSyncContexts = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.447 -0400", hash_original_field = "1EA8C7643DB05CB27275C01529A3B68D", hash_generated_field = "2C170DA4C09FF899D129001B1ECCF61D")

    private boolean mNeedSyncActiveNotification = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.457 -0400", hash_original_field = "903D42B85DB5FCC64341BB05BCAF3314", hash_generated_field = "FF2D77AC785FF38C8AC4F17DE204C25B")

    private PendingIntent mSyncAlarmIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.458 -0400", hash_original_field = "CAF97C3C9F7900E8B91A0310501882F5", hash_generated_field = "4F3FBD8A907B6E0F5B4504A10DCCE878")

    private ConnectivityManager mConnManagerDoNotUseDirectly;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.458 -0400", hash_original_field = "5BACDC96B768A3E26C7617A22F60CBBA", hash_generated_field = "E33ECCC9C6F1F57E962D4A8990DDF83C")

    protected SyncAdaptersCache mSyncAdapters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.471 -0400", hash_original_field = "BC6CA2320CEE3F5B1EE825BA50C5DBFE", hash_generated_field = "3891C29C59C3BB672768BCE088362139")

    private BroadcastReceiver mStorageIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.470 -0400", hash_original_method = "BC3DE36BD414D1E0AC1A290F3F999B72", hash_generated_method = "E92A4DA9AB1DCF307467105CAE557C0B")
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            String action;
            action = intent.getAction();
            {
                boolean var494408089C6C69852C6FEB8DA3256EBE_1137061174 = (Intent.ACTION_DEVICE_STORAGE_LOW.equals(action));
                {
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_249495094 = (Log.isLoggable(TAG, Log.VERBOSE));
                    } //End collapsed parenthetic
                    mStorageIsLow = true;
                    cancelActiveSync(null , null );
                } //End block
                {
                    boolean varDA8C0F6155EB4E90A0DAEBEA890A0A28_1839534441 = (Intent.ACTION_DEVICE_STORAGE_OK.equals(action));
                    {
                        {
                            boolean var0C9C1F857EF1208EE3C75B6103EF6F6E_202454606 = (Log.isLoggable(TAG, Log.VERBOSE));
                        } //End collapsed parenthetic
                        mStorageIsLow = false;
                        sendCheckAlarmsMessage();
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
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

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.484 -0400", hash_original_field = "762F4D83742CECA3BECA29EC7B3D6902", hash_generated_field = "29F8368CFC868EB7B8C7B4C03450F292")

    private BroadcastReceiver mBootCompletedReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.483 -0400", hash_original_method = "48002FD0F3001594E3DAE34911FFCE18", hash_generated_method = "4B23DC7E7458A7DE52CE4CB804B826DF")
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mSyncHandler.onBootCompleted();
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //mSyncHandler.onBootCompleted();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.486 -0400", hash_original_field = "3348FFF7144827BFF9601B956A07D2A8", hash_generated_field = "7A78202F64AD8A2477D8808DA4F7025A")

    private BroadcastReceiver mBackgroundDataSettingChanged = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.486 -0400", hash_original_method = "8D0265854014D0DAAECDD8BFDBAC7B99", hash_generated_method = "A4BC018BECBD5A05207A161D597B152C")
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varC0E64E7A82D55EFFFB410CFD8BF972ED_1771805479 = (getConnectivityManager().getBackgroundDataSetting());
                {
                    scheduleSync(null , null , new Bundle(), 0 ,
                        false );
                } //End block
            } //End collapsed parenthetic
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //if (getConnectivityManager().getBackgroundDataSetting()) {
                //scheduleSync(null , null , new Bundle(), 0 ,
                        //false );
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.486 -0400", hash_original_field = "914EF4BB3FD2989BEA197B83DB980E43", hash_generated_field = "C0ABFDE975E218E90A8E9AECD9B1F45A")

    private PowerManager mPowerManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.501 -0400", hash_original_field = "AC08B54B30FB8D73D889BBE2EA8215E3", hash_generated_field = "5257D9A92C8963F1403712A6CFBA1825")

    private BroadcastReceiver mConnectivityIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.501 -0400", hash_original_method = "252074B4EB0924016B2ADBE10E34C1F3", hash_generated_method = "A1CD507EAC9996E878779C9BFACA60CA")
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean wasConnected;
            wasConnected = mDataConnectionIsConnected;
            mDataConnectionIsConnected = readDataConnectionState();
            {
                {
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_2011077267 = (Log.isLoggable(TAG, Log.VERBOSE));
                    } //End collapsed parenthetic
                    mSyncStorageEngine.clearAllBackoffs(mSyncQueue);
                } //End block
                sendCheckAlarmsMessage();
            } //End block
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
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

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.502 -0400", hash_original_field = "4F7A3BC34E44876836A051C01D24E148", hash_generated_field = "E3DC27DF3352B0847FD0063EDBE273F4")

    private BroadcastReceiver mShutdownIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.502 -0400", hash_original_method = "C2982D871DFCE85BA68BED52BCB115FD", hash_generated_method = "4E850BAD6B340846E6D2CD9FCE56EC3A")
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            getSyncStorageEngine().writeAllState();
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //Log.w(TAG, "Writing sync state before shutdown...");
            //getSyncStorageEngine().writeAllState();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.502 -0400", hash_original_field = "2BFA50A6F682F32C5E74B6BF1DA5F561", hash_generated_field = "48C1F195FC8EA9F865537B3EB1F3D277")

    private SyncHandler mSyncHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.502 -0400", hash_original_field = "07ED8299DCE5FFC54346DB7582134B71", hash_generated_field = "36D62901B5F66AD7425C1042CCC68DC2")

    private Handler mMainHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.502 -0400", hash_original_field = "3C0D61A464F7DDB2D139F30472309ADC", hash_generated_field = "575B378AD4BFE1F61DDDF06CA57D041D")

    private volatile boolean mBootCompleted = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.658 -0400", hash_original_method = "03EC3B1422C9597488B0C8A9401C488F", hash_generated_method = "21BCB09CD1A68D069B022250611D02FB")
    public  SyncManager(Context context, boolean factoryTest) {
        mContext = context;
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.540 -0400", hash_original_method = "156EF77A103E5C10F6AA28A0B09EC843", hash_generated_method = "4ECDDC5E5A7426C563A7386848DEB420")
            public void onServiceChanged(SyncAdapterType type, boolean removed) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    scheduleSync(null, type.authority, null, 0 ,
                            false );
                } //End block
                addTaint(type.getTaint());
                addTaint(removed);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.562 -0400", hash_original_method = "E2E5241731BE29D01E4993B391B00B92", hash_generated_method = "E877FE14261D351EFC08FE17A893B854")
            public void onStatusChanged(int which) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                sendCheckAlarmsMessage();
                addTaint(which);
                // ---------- Original Method ----------
                //sendCheckAlarmsMessage();
            }
});
        {
            AccountManager.get(mContext).addOnAccountsUpdatedListener(SyncManager.this,
                mSyncHandler, false );
            onAccountsUpdated(AccountManager.get(mContext).getAccounts());
        } //End block
        addTaint(factoryTest);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.802 -0400", hash_original_method = "F68E26CE46C5E71DC7131B4E8982A697", hash_generated_method = "09B426EADB5A9B12C9CC7D8D62D050FC")
    public void onAccountsUpdated(Account[] accounts) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean justBootedUp;
        justBootedUp = mAccounts == INITIAL_ACCOUNTS_ARRAY;
        mAccounts = accounts;
        {
            Iterator<ActiveSyncContext> varB42644AE74A51E951ED6AB5DD20DA8CE_1616148202 = (mActiveSyncContexts).iterator();
            varB42644AE74A51E951ED6AB5DD20DA8CE_1616148202.hasNext();
            ActiveSyncContext currentSyncContext = varB42644AE74A51E951ED6AB5DD20DA8CE_1616148202.next();
            {
                {
                    boolean var98DBBB9384A6D900D1DF555C10C402D5_1778738701 = (!ArrayUtils.contains(accounts, currentSyncContext.mSyncOperation.account));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.813 -0400", hash_original_method = "90A2C58DEF02026C184592212F85FF18", hash_generated_method = "8087A2B1AD4CE33F2B776111512335E0")
    private boolean readDataConnectionState() {
        NetworkInfo networkInfo;
        networkInfo = getConnectivityManager().getActiveNetworkInfo();
        boolean var53496D7038EE5B94BB35F9D43FD53DF1_710256278 = ((networkInfo != null) && networkInfo.isConnected());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335050329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335050329;
        // ---------- Original Method ----------
        //NetworkInfo networkInfo = getConnectivityManager().getActiveNetworkInfo();
        //return (networkInfo != null) && networkInfo.isConnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.815 -0400", hash_original_method = "85835365DA8D3F37E74A4C98C5566C52", hash_generated_method = "65AA113BA3A90C376CC442D3BF0C1C6C")
    private ConnectivityManager getConnectivityManager() {
        ConnectivityManager varB4EAC82CA7396A68D541C85D26508E83_297079119 = null; //Variable for return #1
        {
            {
                mConnManagerDoNotUseDirectly = (ConnectivityManager)mContext.getSystemService(
                        Context.CONNECTIVITY_SERVICE);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_297079119 = mConnManagerDoNotUseDirectly;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_297079119.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_297079119;
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mConnManagerDoNotUseDirectly == null) {
                //mConnManagerDoNotUseDirectly = (ConnectivityManager)mContext.getSystemService(
                        //Context.CONNECTIVITY_SERVICE);
            //}
            //return mConnManagerDoNotUseDirectly;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.823 -0400", hash_original_method = "2C829A46E677D5FF63843A6B74A54E87", hash_generated_method = "650BBC2372408F4956BB65E96653723C")
    private long jitterize(long minValue, long maxValue) {
        Random random;
        random = new Random(SystemClock.elapsedRealtime());
        long spread;
        spread = maxValue - minValue;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the difference between the maxValue and the "
                    + "minValue must be less than " + Integer.MAX_VALUE);
        } //End block
        long varD1004F69028D356D16619D81D55BEACE_8030579 = (minValue + random.nextInt((int)spread));
        addTaint(minValue);
        addTaint(maxValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_998152535 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_998152535;
        // ---------- Original Method ----------
        //Random random = new Random(SystemClock.elapsedRealtime());
        //long spread = maxValue - minValue;
        //if (spread > Integer.MAX_VALUE) {
            //throw new IllegalArgumentException("the difference between the maxValue and the "
                    //+ "minValue must be less than " + Integer.MAX_VALUE);
        //}
        //return minValue + random.nextInt((int)spread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.825 -0400", hash_original_method = "BC7A6B22ABBE0EBF148B37C3B72645F0", hash_generated_method = "F4C771562695C610CE355CEBEB6DFFD9")
    public SyncStorageEngine getSyncStorageEngine() {
        SyncStorageEngine varB4EAC82CA7396A68D541C85D26508E83_813481594 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_813481594 = mSyncStorageEngine;
        varB4EAC82CA7396A68D541C85D26508E83_813481594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_813481594;
        // ---------- Original Method ----------
        //return mSyncStorageEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.851 -0400", hash_original_method = "51F169FF6EC2BB253880B74521EEDA04", hash_generated_method = "35DF559DA3A5DA237B231F2EE75E3A9C")
    private void ensureAlarmService() {
        {
            mAlarmService = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
        } //End block
        // ---------- Original Method ----------
        //if (mAlarmService == null) {
            //mAlarmService = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.854 -0400", hash_original_method = "3B1126FA248635D8E240EE322F732C4B", hash_generated_method = "8BF9930F405F2098C700272CDB074DAF")
    private void initializeSyncAdapter(Account account, String authority) {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_87843378 = (Log.isLoggable(TAG, Log.VERBOSE));
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
            boolean var1A3A6E55EBFBD5A3E4EB18A5AAADC18B_1132996745 = (!mContext.bindService(intent,
                new InitializerServiceConnection(account, authority, mContext, mMainHandler),
                Context.BIND_AUTO_CREATE | Context.BIND_NOT_FOREGROUND
                | Context.BIND_ALLOW_OOM_MANAGEMENT));
        } //End collapsed parenthetic
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.329 -0400", hash_original_method = "B73E52BAF4D022DC2D77FE197F842436", hash_generated_method = "1AA71DC56DB582D332CACACB31AC7B12")
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
            Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> varA460451BE61974D4E85B931D5CE391A8_448107530 = (mSyncAdapters.getAllServices()).iterator();
            varA460451BE61974D4E85B931D5CE391A8_448107530.hasNext();
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapter = varA460451BE61974D4E85B931D5CE391A8_448107530.next();
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
            Iterator<String> varA26FDBFC8911931337CEF509AC3DFFCA_2072012400 = (syncableAuthorities).iterator();
            varA26FDBFC8911931337CEF509AC3DFFCA_2072012400.hasNext();
            String authority = varA26FDBFC8911931337CEF509AC3DFFCA_2072012400.next();
            {
                {
                    Iterator<Account> varE8B5D7DA038A66181BE57D2439F0940A_1257360591 = (accounts).iterator();
                    varE8B5D7DA038A66181BE57D2439F0940A_1257360591.hasNext();
                    Account account = varE8B5D7DA038A66181BE57D2439F0940A_1257360591.next();
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
                            boolean varE5FC1CEDA70C1C0494947FABB12B6E86_916737969 = (!syncAdapterInfo.type.supportsUploading() && uploadOnly);
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
        addTaint(requestedAccount.getTaint());
        addTaint(requestedAuthority.getTaint());
        addTaint(extras.getTaint());
        addTaint(delay);
        addTaint(onlyThoseWithUnkownSyncableState);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.330 -0400", hash_original_method = "9A217D026FB5B08090F4BAFAA08C0DF7", hash_generated_method = "C8C3D4CA5E5D7AFE855D00B23FB510A0")
    public void scheduleLocalSync(Account account, String authority) {
        Bundle extras;
        extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        scheduleSync(account, authority, extras, LOCAL_SYNC_DELAY,
                false );
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        // ---------- Original Method ----------
        //final Bundle extras = new Bundle();
        //extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        //scheduleSync(account, authority, extras, LOCAL_SYNC_DELAY,
                //false );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.429 -0400", hash_original_method = "0A2ACD1B7EA84D8FDEC2211873578368", hash_generated_method = "066BED6236830C6547A9AB2F68E2DED1")
    public SyncAdapterType[] getSyncAdapterTypes() {
        SyncAdapterType[] varB4EAC82CA7396A68D541C85D26508E83_1025686243 = null; //Variable for return #1
        Collection<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> serviceInfos;
        serviceInfos = mSyncAdapters.getAllServices();
        SyncAdapterType[] types;
        types = new SyncAdapterType[serviceInfos.size()];
        int i;
        i = 0;
        {
            Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> var7AE0F59F3247E05923E8DDBDBBF91C7C_1457596766 = (serviceInfos).iterator();
            var7AE0F59F3247E05923E8DDBDBBF91C7C_1457596766.hasNext();
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> serviceInfo = var7AE0F59F3247E05923E8DDBDBBF91C7C_1457596766.next();
            {
                types[i] = serviceInfo.type;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1025686243 = types;
        varB4EAC82CA7396A68D541C85D26508E83_1025686243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1025686243;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.430 -0400", hash_original_method = "14A3D8C2E4B2E28E7EAE9416931B0D4D", hash_generated_method = "C773C7EBB1423864C29FA12E1DD808B3")
    private void sendSyncAlarmMessage() {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_335418418 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_SYNC_ALARM);
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_SYNC_ALARM");
        //mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_SYNC_ALARM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.454 -0400", hash_original_method = "48CD41A4FC7AAC6DBD3D417BDFF3952E", hash_generated_method = "CC0AD8B8D32F1569C062A87AB9C7FDF1")
    private void sendCheckAlarmsMessage() {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_1092205208 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_CHECK_ALARMS);
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_CHECK_ALARMS");
        //mSyncHandler.sendEmptyMessage(SyncHandler.MESSAGE_CHECK_ALARMS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.456 -0400", hash_original_method = "A4D4C528BED9CEDB160AF5BFC279888F", hash_generated_method = "1698AFDDE6B37963D553FBCBE92F6650")
    private void sendSyncFinishedOrCanceledMessage(ActiveSyncContext syncContext,
            SyncResult syncResult) {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_1494987466 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        Message msg;
        msg = mSyncHandler.obtainMessage();
        msg.what = SyncHandler.MESSAGE_SYNC_FINISHED;
        msg.obj = new SyncHandlerMessagePayload(syncContext, syncResult);
        mSyncHandler.sendMessage(msg);
        addTaint(syncContext.getTaint());
        addTaint(syncResult.getTaint());
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_SYNC_FINISHED");
        //Message msg = mSyncHandler.obtainMessage();
        //msg.what = SyncHandler.MESSAGE_SYNC_FINISHED;
        //msg.obj = new SyncHandlerMessagePayload(syncContext, syncResult);
        //mSyncHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.479 -0400", hash_original_method = "162904FEAED4FE3BDD09493527BC709D", hash_generated_method = "B3D9D2FE67324C2055BB62C5CED28622")
    private void sendCancelSyncsMessage(final Account account, final String authority) {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_1937805217 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        Message msg;
        msg = mSyncHandler.obtainMessage();
        msg.what = SyncHandler.MESSAGE_CANCEL;
        msg.obj = Pair.create(account, authority);
        mSyncHandler.sendMessage(msg);
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "sending MESSAGE_CANCEL");
        //Message msg = mSyncHandler.obtainMessage();
        //msg.what = SyncHandler.MESSAGE_CANCEL;
        //msg.obj = Pair.create(account, authority);
        //mSyncHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.480 -0400", hash_original_method = "1BD5650AC2366081E95971C40228D13F", hash_generated_method = "EE91EA44BF4DDE4D26866584ABAA7BA9")
    private void clearBackoffSetting(SyncOperation op) {
        mSyncStorageEngine.setBackoff(op.account, op.authority,
                SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
        {
            mSyncQueue.onBackoffChanged(op.account, op.authority, 0);
        } //End block
        addTaint(op.getTaint());
        // ---------- Original Method ----------
        //mSyncStorageEngine.setBackoff(op.account, op.authority,
                //SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
        //synchronized (mSyncQueue) {
            //mSyncQueue.onBackoffChanged(op.account, op.authority, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.500 -0400", hash_original_method = "42DD92B3EE29EAC346CC626BA6B5C78C", hash_generated_method = "E395D61CA4C63CF856B4D6A2E661118D")
    private void increaseBackoffSetting(SyncOperation op) {
        long now;
        now = SystemClock.elapsedRealtime();
        Pair<Long, Long> previousSettings;
        previousSettings = mSyncStorageEngine.getBackoff(op.account, op.authority);
        long newDelayInMs;
        newDelayInMs = -1;
        {
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_942423691 = (Log.isLoggable(TAG, Log.VERBOSE));
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
        addTaint(op.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.508 -0400", hash_original_method = "D0F8BD8389FAB953FA57BE172373CE33", hash_generated_method = "6640C16E04046E9B82CC7C1310547A29")
    private void setDelayUntilTime(SyncOperation op, long delayUntilSeconds) {
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
        addTaint(op.getTaint());
        addTaint(delayUntilSeconds);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.509 -0400", hash_original_method = "CC013A9497DA672D61638E0368F0173C", hash_generated_method = "694105C2C8F4F12B6E371ED5F65EA3D0")
    public void cancelActiveSync(Account account, String authority) {
        sendCancelSyncsMessage(account, authority);
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        // ---------- Original Method ----------
        //sendCancelSyncsMessage(account, authority);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.526 -0400", hash_original_method = "B18DC4486E3B23A71F43236C6D4E20D9", hash_generated_method = "5EE582F3466F405D6EF853B4C82E4220")
    public void scheduleSyncOperation(SyncOperation syncOperation) {
        boolean queueChanged;
        {
            queueChanged = mSyncQueue.add(syncOperation);
        } //End block
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_443817837 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            sendCheckAlarmsMessage();
        } //End block
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1322089867 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
        } //End block
        addTaint(syncOperation.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.527 -0400", hash_original_method = "A2720167EE002D05FE5DA0F6211150BE", hash_generated_method = "51CE72BEF915FEA979D106F602A7F3F3")
    public void clearScheduledSyncOperations(Account account, String authority) {
        {
            mSyncQueue.remove(account, authority);
        } //End block
        mSyncStorageEngine.setBackoff(account, authority,
                SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        // ---------- Original Method ----------
        //synchronized (mSyncQueue) {
            //mSyncQueue.remove(account, authority);
        //}
        //mSyncStorageEngine.setBackoff(account, authority,
                //SyncStorageEngine.NOT_IN_BACKOFF_MODE, SyncStorageEngine.NOT_IN_BACKOFF_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.562 -0400", hash_original_method = "7F8B5486825DA8802A08F87FCECDEB6D", hash_generated_method = "1343E53B3C94E5501BAA7C7B5DF8D9E7")
     void maybeRescheduleSync(SyncResult syncResult, SyncOperation operation) {
        boolean isLoggable;
        isLoggable = Log.isLoggable(TAG, Log.DEBUG);
        {
            Log.d(TAG, "encountered error(s) during the sync: " + syncResult + ", " + operation);
        } //End block
        operation = new SyncOperation(operation);
        {
            boolean var136962CEFF8E97B7711EEA42390818DD_1361831879 = (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, false));
            {
                operation.extras.remove(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8F222CBFA0E1CEE9747F369F4C66D983_1267350541 = (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_DO_NOT_RETRY, false));
            {
                Log.d(TAG, "not retrying sync operation because SYNC_EXTRAS_DO_NOT_RETRY was specified "
                    + operation);
            } //End block
            {
                boolean varCF7FCB45BDB21B5C6B94F23C48AB3F03_1997232481 = (operation.extras.getBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, false)
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
                    boolean varAEB5246C7BAA2573F81B4D1F785CB99B_1281817823 = (syncResult.madeSomeProgress());
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
                        boolean var2BF6670105BBC4F9CBE78135A10D2C2F_489691270 = (syncResult.hasSoftError());
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
        addTaint(syncResult.getTaint());
        addTaint(operation.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.690 -0400", hash_original_method = "E59AB1EB4C672AE41E3C994B41A259B0", hash_generated_method = "7536DA1AF5C986DCD9B860A70BC9657A")
    protected void dump(FileDescriptor fd, PrintWriter pw) {
        dumpSyncState(pw);
        dumpSyncHistory(pw);
        pw.println();
        pw.println("SyncAdapters:");
        {
            Iterator<RegisteredServicesCache.ServiceInfo> var66FF787B46917F4C470825A4AACF9C4B_24057213 = (mSyncAdapters.getAllServices()).iterator();
            var66FF787B46917F4C470825A4AACF9C4B_24057213.hasNext();
            RegisteredServicesCache.ServiceInfo info = var66FF787B46917F4C470825A4AACF9C4B_24057213.next();
            {
                pw.println("  " + info);
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(pw.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.332 -0400", hash_original_method = "A56698FB2481C281E3929C7135D64B8A", hash_generated_method = "E43E345B8200781A70B6EA5131E8BBD7")
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
            Iterator<SyncManager.ActiveSyncContext> var410A1C2D24679042EA90D422992CD225_977198160 = (mActiveSyncContexts).iterator();
            var410A1C2D24679042EA90D422992CD225_977198160.hasNext();
            SyncManager.ActiveSyncContext activeSyncContext = var410A1C2D24679042EA90D422992CD225_977198160.next();
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
            Iterator<Account> varE8B5D7DA038A66181BE57D2439F0940A_510955766 = (accounts).iterator();
            varE8B5D7DA038A66181BE57D2439F0940A_510955766.hasNext();
            Account account = varE8B5D7DA038A66181BE57D2439F0940A_510955766.next();
            {
                pw.print("  Account ");
                pw.print(account.name);
                pw.print(" ");
                pw.print(account.type);
                pw.println(":");
                {
                    Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> varB8408EC3A61191DA03920260AEC144C1_593996131 = (mSyncAdapters.getAllServices()).iterator();
                    varB8408EC3A61191DA03920260AEC144C1_593996131.hasNext();
                    RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterType = varB8408EC3A61191DA03920260AEC144C1_593996131.next();
                    {
                        {
                            boolean varBFF66230831B803F3BB6FD65657B65E4_951782031 = (!syncAdapterType.type.accountType.equals(account.type));
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
                            boolean var234026F2237427D2FEAC3EFBEEDD19EA_1619013289 = (periodicIndex < settings.periodicSyncs.size());
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
        addTaint(pw.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.343 -0400", hash_original_method = "C2F823D43F1684BB9B7871B7A13E4AFA", hash_generated_method = "457A3C22D7E2D464DB0113C11C1EB276")
    private String getLastFailureMessage(int code) {
        String varB4EAC82CA7396A68D541C85D26508E83_371895829 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_230136695 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_833310328 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_808257741 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1476219809 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_322825855 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_1310394888 = null; //Variable for return #7
        String varB4EAC82CA7396A68D541C85D26508E83_1127170491 = null; //Variable for return #8
        String varB4EAC82CA7396A68D541C85D26508E83_1215421075 = null; //Variable for return #9
        //Begin case ContentResolver.SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS 
        varB4EAC82CA7396A68D541C85D26508E83_371895829 = "sync already in progress";
        //End case ContentResolver.SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS 
        //Begin case ContentResolver.SYNC_ERROR_AUTHENTICATION 
        varB4EAC82CA7396A68D541C85D26508E83_230136695 = "authentication error";
        //End case ContentResolver.SYNC_ERROR_AUTHENTICATION 
        //Begin case ContentResolver.SYNC_ERROR_IO 
        varB4EAC82CA7396A68D541C85D26508E83_833310328 = "I/O error";
        //End case ContentResolver.SYNC_ERROR_IO 
        //Begin case ContentResolver.SYNC_ERROR_PARSE 
        varB4EAC82CA7396A68D541C85D26508E83_808257741 = "parse error";
        //End case ContentResolver.SYNC_ERROR_PARSE 
        //Begin case ContentResolver.SYNC_ERROR_CONFLICT 
        varB4EAC82CA7396A68D541C85D26508E83_1476219809 = "conflict error";
        //End case ContentResolver.SYNC_ERROR_CONFLICT 
        //Begin case ContentResolver.SYNC_ERROR_TOO_MANY_DELETIONS 
        varB4EAC82CA7396A68D541C85D26508E83_322825855 = "too many deletions error";
        //End case ContentResolver.SYNC_ERROR_TOO_MANY_DELETIONS 
        //Begin case ContentResolver.SYNC_ERROR_TOO_MANY_RETRIES 
        varB4EAC82CA7396A68D541C85D26508E83_1310394888 = "too many retries error";
        //End case ContentResolver.SYNC_ERROR_TOO_MANY_RETRIES 
        //Begin case ContentResolver.SYNC_ERROR_INTERNAL 
        varB4EAC82CA7396A68D541C85D26508E83_1127170491 = "internal error";
        //End case ContentResolver.SYNC_ERROR_INTERNAL 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_1215421075 = "unknown";
        //End case default 
        addTaint(code);
        String varA7E53CE21691AB073D9660D615818899_1995249601; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1995249601 = varB4EAC82CA7396A68D541C85D26508E83_371895829;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1995249601 = varB4EAC82CA7396A68D541C85D26508E83_230136695;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1995249601 = varB4EAC82CA7396A68D541C85D26508E83_833310328;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1995249601 = varB4EAC82CA7396A68D541C85D26508E83_808257741;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1995249601 = varB4EAC82CA7396A68D541C85D26508E83_1476219809;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1995249601 = varB4EAC82CA7396A68D541C85D26508E83_322825855;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1995249601 = varB4EAC82CA7396A68D541C85D26508E83_1310394888;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1995249601 = varB4EAC82CA7396A68D541C85D26508E83_1127170491;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1995249601 = varB4EAC82CA7396A68D541C85D26508E83_1215421075;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1995249601.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1995249601;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.357 -0400", hash_original_method = "2E5C9A0C484B8BFAAD4FF120631D1FEC", hash_generated_method = "305BB8B34B8D9F46875ED7D3916192AB")
    private void dumpTimeSec(PrintWriter pw, long time) {
        pw.print(time/1000);
        pw.print('.');
        pw.print((time/100)%10);
        pw.print('s');
        addTaint(pw.getTaint());
        addTaint(time);
        // ---------- Original Method ----------
        //pw.print(time/1000);
        //pw.print('.');
        //pw.print((time/100)%10);
        //pw.print('s');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.361 -0400", hash_original_method = "05C5ECB94ECE9FA6501463D9FF0137FC", hash_generated_method = "0079E1EA045616D2CD87E06DEDCA3328")
    private void dumpDayStatistic(PrintWriter pw, SyncStorageEngine.DayStats ds) {
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
        addTaint(pw.getTaint());
        addTaint(ds.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.377 -0400", hash_original_method = "47B1A67BEBB64EEFEE0789183294D0B7", hash_generated_method = "88DE272937D193BBA7929CAACDB2E481")
    protected void dumpSyncHistory(PrintWriter pw) {
        dumpRecentHistory(pw);
        dumpDayStatistics(pw);
        addTaint(pw.getTaint());
        // ---------- Original Method ----------
        //dumpRecentHistory(pw);
        //dumpDayStatistics(pw);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.517 -0400", hash_original_method = "C137DBDBD7D2B9AF348453A35EDAB8EF", hash_generated_method = "58F1208A0490C9424AF58C13AD3ECCA1")
    private void dumpRecentHistory(PrintWriter pw) {
        ArrayList<SyncStorageEngine.SyncHistoryItem> items;
        items = mSyncStorageEngine.getSyncHistory();
        {
            boolean varDBDD00862D2499954D5577669FA506EB_132788904 = (items != null && items.size() > 0);
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
                    Iterator<SyncStorageEngine.SyncHistoryItem> var0608C6D9DE28EB12D6BAF098F71C2655_1870647750 = (items).iterator();
                    var0608C6D9DE28EB12D6BAF098F71C2655_1870647750.hasNext();
                    SyncStorageEngine.SyncHistoryItem item = var0608C6D9DE28EB12D6BAF098F71C2655_1870647750.next();
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
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.448 -0400", hash_original_method = "88424CA43B1F65943C36D332DC119ECC", hash_generated_method = "EF28B006AA5AD595D5302F000151CF59")
                    @Override
                    public int compare(AuthoritySyncStats lhs, AuthoritySyncStats rhs) {
                        int compare;
                        compare = Integer.compare(rhs.times, lhs.times);
                        {
                            compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                        } //End block
                        addTaint(lhs.getTaint());
                        addTaint(rhs.getTaint());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1880255224 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1880255224;
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
                    Iterator<AuthoritySyncStats> var02EEAE14D9E55F5E0A8CF4B94919F1FF_286160923 = (sortedAuthorities).iterator();
                    var02EEAE14D9E55F5E0A8CF4B94919F1FF_286160923.hasNext();
                    AuthoritySyncStats authoritySyncStats = var02EEAE14D9E55F5E0A8CF4B94919F1FF_286160923.next();
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
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.470 -0400", hash_original_method = "CABE0C69E80F76B9C185615742665411", hash_generated_method = "6DD8EEB7A8032487B95F3434D3EA9E2F")
                            @Override
                            public int compare(AccountSyncStats lhs, AccountSyncStats rhs) {
                                int compare;
                                compare = Integer.compare(rhs.times, lhs.times);
                                {
                                    compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                                } //End block
                                addTaint(lhs.getTaint());
                                addTaint(rhs.getTaint());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181283560 = getTaintInt();
                                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181283560;
                                // ---------- Original Method ----------
                                //int compare = Integer.compare(rhs.times, lhs.times);
                                //if (compare == 0) {
                            //compare = Long.compare(rhs.elapsedTime, lhs.elapsedTime);
                        //}
                                //return compare;
                            }
});
                        {
                            Iterator<AccountSyncStats> var5409EB09DA7B117C8E0493FB2F1F1ED9_1684619506 = (sortedAccounts).iterator();
                            var5409EB09DA7B117C8E0493FB2F1F1ED9_1684619506.hasNext();
                            AccountSyncStats stats = var5409EB09DA7B117C8E0493FB2F1F1ED9_1684619506.next();
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
                            boolean varFC5F873EDD9BB5AB47B6562574DA62BF_1526423195 = (item.mesg != null
                        && !SyncStorageEngine.MESG_SUCCESS.equals(item.mesg));
                            {
                                pw.printf("    mesg=%s\n", item.mesg);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(pw.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.623 -0400", hash_original_method = "9349911975C50CB78B5A389074CC1BDC", hash_generated_method = "F917B87EA1ABF91443AE33D60267C75C")
    private void dumpDayStatistics(PrintWriter pw) {
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
        addTaint(pw.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.724 -0400", hash_original_method = "3A4E555675ED758A699E30DB2B6A1D6C", hash_generated_method = "7DE124B609F789DBA17703B36E29A06D")
    private boolean isSyncStillActive(ActiveSyncContext activeSyncContext) {
        {
            Iterator<ActiveSyncContext> var38A241656A664BE053973521A7ED258D_1316273928 = (mActiveSyncContexts).iterator();
            var38A241656A664BE053973521A7ED258D_1316273928.hasNext();
            ActiveSyncContext sync = var38A241656A664BE053973521A7ED258D_1316273928.next();
        } //End collapsed parenthetic
        addTaint(activeSyncContext.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556703726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556703726;
        // ---------- Original Method ----------
        //for (ActiveSyncContext sync : mActiveSyncContexts) {
            //if (sync == activeSyncContext) {
                //return true;
            //}
        //}
        //return false;
    }

    
    private static class InitializerServiceConnection implements ServiceConnection {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.724 -0400", hash_original_field = "591F77A70FEF1AA3112C01B360A63E9C", hash_generated_field = "3B055C3859C53A8ACDFC59C6C8440DF8")

        private Account mAccount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.724 -0400", hash_original_field = "2325EF4ABFCA50C092A123BB59FD3F59", hash_generated_field = "5E9A5C7D075BBF710B4D594B2F64B868")

        private String mAuthority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.724 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.725 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "D774CCF7C32F86EE269A0C9F9D84415A")

        private volatile Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.725 -0400", hash_original_field = "57006E58594DC862E67D1855FDF16FEE", hash_generated_field = "C96DBD94ABC21BAB3CFD91A494AEBFFE")

        private volatile boolean mInitialized;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.726 -0400", hash_original_method = "24302E8CE101646513826470385452C3", hash_generated_method = "4EBBC72C54610FED0E83FDA081E5EF8C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.750 -0400", hash_original_method = "9C4A98A4ADBC598450E25E4EB304536B", hash_generated_method = "080AB95F7430CB8F3B67AD13B918C323")
        public void onServiceConnected(ComponentName name, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            try 
            {
                {
                    mInitialized = true;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1355996779 = (Log.isLoggable(TAG, Log.VERBOSE));
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
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.750 -0400", hash_original_method = "64817B3D0D58B18C7C47E60B6E5CD293", hash_generated_method = "155839339AFB4ADEC68B1ADFF3B61F2E")
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
            addTaint(name.getTaint());
            addTaint(service.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.755 -0400", hash_original_method = "7C8777D718751E565C82B5C1458835CE", hash_generated_method = "956FEBD81C7AB60A87B4B273B50F4D63")
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mContext.unbindService(InitializerServiceConnection.this);
                mContext = null;
            } //End block
            addTaint(name.getTaint());
            // ---------- Original Method ----------
            //if (mContext != null) {
                //mContext.unbindService(InitializerServiceConnection.this);
                //mContext = null;
            //}
        }

        
    }


    
    class SyncHandlerMessagePayload {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.756 -0400", hash_original_field = "BF45069C4338DFDA77BE2DADD5129FF8", hash_generated_field = "A63DF1A530DF0116354A195B2D61C988")

        public ActiveSyncContext activeSyncContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.756 -0400", hash_original_field = "B59C15B72BC0053AC689D16452610B86", hash_generated_field = "1E280B614C5836CFB973E2780B056065")

        public SyncResult syncResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.771 -0400", hash_original_method = "56E2C68849F116EE41FAA5D226ECBDA3", hash_generated_method = "EB9BF74C5D5609245088D697B7671A62")
          SyncHandlerMessagePayload(ActiveSyncContext syncContext, SyncResult syncResult) {
            this.activeSyncContext = syncContext;
            this.syncResult = syncResult;
            // ---------- Original Method ----------
            //this.activeSyncContext = syncContext;
            //this.syncResult = syncResult;
        }

        
    }


    
    class SyncAlarmIntentReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.771 -0400", hash_original_method = "8972A0265D0AE4113C769D505643787E", hash_generated_method = "8972A0265D0AE4113C769D505643787E")
        public SyncAlarmIntentReceiver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.772 -0400", hash_original_method = "B17BCAD698B90432E3978D14A6575096", hash_generated_method = "5BD8AF817AB4808B9D575FFF16CD1C8F")
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mHandleAlarmWakeLock.acquire();
            sendSyncAlarmMessage();
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //mHandleAlarmWakeLock.acquire();
            //sendSyncAlarmMessage();
        }

        
    }


    
    class ActiveSyncContext extends ISyncContext.Stub implements ServiceConnection, IBinder.DeathRecipient {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.782 -0400", hash_original_field = "3A845A40EB36D8DA4C1C6E7F00D65842", hash_generated_field = "CAEB8FA396F504839F82FDA41F0B6FEA")

        SyncOperation mSyncOperation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.782 -0400", hash_original_field = "FA98B28302F6B5B27D4997F9053E2A6F", hash_generated_field = "506D1AD61A010C0C1665DFBD26F66F91")

        long mHistoryRowId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.783 -0400", hash_original_field = "232767BB513340895CA27CD6CD498671", hash_generated_field = "57DE2857F3D6D189DF99142B1CBC936B")

        ISyncAdapter mSyncAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.783 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")

        long mStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.783 -0400", hash_original_field = "D3BAFEE7AF350B3FE85578E9B0C95F28", hash_generated_field = "2DA32C9B0D6927F8ADE9B98444FE7E93")

        long mTimeoutStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.783 -0400", hash_original_field = "DFE2EB06A7E314F96252E3BC41F2C2EE", hash_generated_field = "E78E5DB82E19559DD5BEFC2040680967")

        boolean mBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.783 -0400", hash_original_field = "B4284F499642B7038AEABE600507F363", hash_generated_field = "40DA6E2B4575B8523B863BAC87FE141E")

        PowerManager.WakeLock mSyncWakeLock;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.783 -0400", hash_original_field = "1A19E5DBB7DA8A675E5D447716B9C520", hash_generated_field = "2C18D3EE7F9C970AA993762D01A316E3")

        int mSyncAdapterUid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.783 -0400", hash_original_field = "B4DD88CF987D9FC7C9A0015AB85FA859", hash_generated_field = "D364355005B405C007FFCAD9043FC337")

        SyncInfo mSyncInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.783 -0400", hash_original_field = "FC2DEDF201972A37F09CA72F6C2310F6", hash_generated_field = "468C40F467A1821737E93795346B1787")

        boolean mIsLinkedToDeath = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.798 -0400", hash_original_method = "FBEF152C2B412533A606ADB2B9DA9D2A", hash_generated_method = "950920857408DB20FD03968FDF4D12D7")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.799 -0400", hash_original_method = "7456DA1EA096E82DD762DA299B1797D3", hash_generated_method = "540CBBFBA53CA8CE698C636F326A356D")
        public void sendHeartbeat() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.822 -0400", hash_original_method = "2741CA480AE203CDFD1BCCBB420C487D", hash_generated_method = "6F27C1845FCD46DAD7D4D5E68A25BF65")
        public void onFinished(SyncResult result) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1682091197 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            sendSyncFinishedOrCanceledMessage(this, result);
            addTaint(result.getTaint());
            // ---------- Original Method ----------
            //if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "onFinished: " + this);
            //sendSyncFinishedOrCanceledMessage(this, result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.827 -0400", hash_original_method = "EB9B131EDBEF0858B3038B79ABC0948E", hash_generated_method = "5C20A4350B214EDF4FCD147F5BBB3851")
        public void toString(StringBuilder sb) {
            sb.append("startTime ").append(mStartTime)
                    .append(", mTimeoutStartTime ").append(mTimeoutStartTime)
                    .append(", mHistoryRowId ").append(mHistoryRowId)
                    .append(", syncOperation ").append(mSyncOperation);
            addTaint(sb.getTaint());
            // ---------- Original Method ----------
            //sb.append("startTime ").append(mStartTime)
                    //.append(", mTimeoutStartTime ").append(mTimeoutStartTime)
                    //.append(", mHistoryRowId ").append(mHistoryRowId)
                    //.append(", syncOperation ").append(mSyncOperation);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.846 -0400", hash_original_method = "CBDE36ABE821F23EF1CFAFB665E67134", hash_generated_method = "AA51D5DD6325D3F1C52FE80E9DB9C7EE")
        public void onServiceConnected(ComponentName name, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Message msg;
            msg = mSyncHandler.obtainMessage();
            msg.what = SyncHandler.MESSAGE_SERVICE_CONNECTED;
            msg.obj = new ServiceConnectionData(this, ISyncAdapter.Stub.asInterface(service));
            mSyncHandler.sendMessage(msg);
            addTaint(name.getTaint());
            addTaint(service.getTaint());
            // ---------- Original Method ----------
            //Message msg = mSyncHandler.obtainMessage();
            //msg.what = SyncHandler.MESSAGE_SERVICE_CONNECTED;
            //msg.obj = new ServiceConnectionData(this, ISyncAdapter.Stub.asInterface(service));
            //mSyncHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.848 -0400", hash_original_method = "E604348BDB0F3F95B7C0274B0D40964D", hash_generated_method = "A3AA4603DDC4855FD48C87FA973F3DF1")
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Message msg;
            msg = mSyncHandler.obtainMessage();
            msg.what = SyncHandler.MESSAGE_SERVICE_DISCONNECTED;
            msg.obj = new ServiceConnectionData(this, null);
            mSyncHandler.sendMessage(msg);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
            //Message msg = mSyncHandler.obtainMessage();
            //msg.what = SyncHandler.MESSAGE_SERVICE_DISCONNECTED;
            //msg.obj = new ServiceConnectionData(this, null);
            //mSyncHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.868 -0400", hash_original_method = "79606510FDB8502633B50F75722531BD", hash_generated_method = "C2BFB855685B108D490D1DA4C7922AAA")
         boolean bindToSyncAdapter(RegisteredServicesCache.ServiceInfo info) {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_507677460 = (Log.isLoggable(TAG, Log.VERBOSE));
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
            addTaint(info.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_168192964 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_168192964;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.885 -0400", hash_original_method = "BCACA708B6725C3BB29ED8DCC5E23FC1", hash_generated_method = "5B256DA91B793F90BF7893CCF029EFFE")
        protected void close() {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_370461208 = (Log.isLoggable(TAG, Log.VERBOSE));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.895 -0400", hash_original_method = "C99E9A460C6F28DBA730EF38203534A2", hash_generated_method = "9176BB9A6D08B20CFE7CBAFED6BE5B7A")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_709776703 = null; //Variable for return #1
            StringBuilder sb;
            sb = new StringBuilder();
            toString(sb);
            varB4EAC82CA7396A68D541C85D26508E83_709776703 = sb.toString();
            varB4EAC82CA7396A68D541C85D26508E83_709776703.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_709776703;
            // ---------- Original Method ----------
            //StringBuilder sb = new StringBuilder();
            //toString(sb);
            //return sb.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.896 -0400", hash_original_method = "A39B4ABAEA9F27E501EB3B3EC7A37B2F", hash_generated_method = "A3A778C314C37C4C18C58B6CB51701C4")
        @Override
        public void binderDied() {
            sendSyncFinishedOrCanceledMessage(this, null);
            // ---------- Original Method ----------
            //sendSyncFinishedOrCanceledMessage(this, null);
        }

        
    }


    
    private static class AuthoritySyncStats {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.918 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.918 -0400", hash_original_field = "DAD566B38C7C4C71D805927E9FFF2732", hash_generated_field = "019980784258B693231C7932844AF0BC")

        long elapsedTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.918 -0400", hash_original_field = "F2B798F672D4B42C0359CED11D4F10CD", hash_generated_field = "3A95A04ECEF69E80207E92842B01313D")

        int times;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.918 -0400", hash_original_field = "8824EC82F0C16A8A1279E45AA6570F81", hash_generated_field = "F30C35077CC725990FFE0E1D8AA05301")

        Map<String, AccountSyncStats> accountMap = Maps.newHashMap();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.920 -0400", hash_original_method = "BA2AD08D9B4BF110732C8291C5F36CF8", hash_generated_method = "8FA9C8631A53370375CA7123AE4AF077")
        private  AuthoritySyncStats(String name) {
            this.name = name;
            // ---------- Original Method ----------
            //this.name = name;
        }

        
    }


    
    private static class AccountSyncStats {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.920 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.920 -0400", hash_original_field = "DAD566B38C7C4C71D805927E9FFF2732", hash_generated_field = "019980784258B693231C7932844AF0BC")

        long elapsedTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.920 -0400", hash_original_field = "F2B798F672D4B42C0359CED11D4F10CD", hash_generated_field = "3A95A04ECEF69E80207E92842B01313D")

        int times;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.921 -0400", hash_original_method = "1D94286E4C9E35DF248CEA39D6389F91", hash_generated_method = "F1AB1770EB048E4049FC1577D48B72D8")
        private  AccountSyncStats(String name) {
            this.name = name;
            // ---------- Original Method ----------
            //this.name = name;
        }

        
    }


    
    private class SyncTimeTracker {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.921 -0400", hash_original_field = "81F2D2CA0AD2344A53D31A86CCF4832E", hash_generated_field = "462785F9BDC050A0984AB02796F85FBF")

        boolean mLastWasSyncing = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.921 -0400", hash_original_field = "C843120669F045C7E7FE9574A72CDFD6", hash_generated_field = "42BA20EF7800084DF8B05592B8E3E7BE")

        long mWhenSyncStarted = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.921 -0400", hash_original_field = "0D9C24F156A3536C5438C75FBA0A7760", hash_generated_field = "2B002605222CEDCD3A05F1765E34CF80")

        private long mTimeSpentSyncing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.921 -0400", hash_original_method = "5641FE5F8977FB94C61AEE76E9EBD2B2", hash_generated_method = "5641FE5F8977FB94C61AEE76E9EBD2B2")
        public SyncTimeTracker ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.943 -0400", hash_original_method = "3978D6C321E5167908096EFEB475874E", hash_generated_method = "B1D5C336F10F4819A0EF24658B8C18DF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.945 -0400", hash_original_method = "73972E33AC37B98D757DD1126931E451", hash_generated_method = "BD3DA477DEFB2AF2A923C463F792ED62")
        public synchronized long timeSpentSyncing() {
            long now;
            now = SystemClock.elapsedRealtime();
            long var0F5264038205EDFB1AC05FBB0E8C5E94_352445723 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_352445723;
            // ---------- Original Method ----------
            //if (!mLastWasSyncing) return mTimeSpentSyncing;
            //final long now = SystemClock.elapsedRealtime();
            //return mTimeSpentSyncing + (now - mWhenSyncStarted);
        }

        
    }


    
    class ServiceConnectionData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.945 -0400", hash_original_field = "BF45069C4338DFDA77BE2DADD5129FF8", hash_generated_field = "A63DF1A530DF0116354A195B2D61C988")

        public ActiveSyncContext activeSyncContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.945 -0400", hash_original_field = "77C3125B03213AA40E0DE7116B3CF093", hash_generated_field = "C583279FC3521EE740A066A3F5FFA86D")

        public ISyncAdapter syncAdapter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.956 -0400", hash_original_method = "CF4E9A067E77243E4BB7B7FFBE17CC6D", hash_generated_method = "2A0BDD0F3B16155915070F3871A6CD3F")
          ServiceConnectionData(ActiveSyncContext activeSyncContext, ISyncAdapter syncAdapter) {
            this.activeSyncContext = activeSyncContext;
            this.syncAdapter = syncAdapter;
            // ---------- Original Method ----------
            //this.activeSyncContext = activeSyncContext;
            //this.syncAdapter = syncAdapter;
        }

        
    }


    
    class SyncHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.957 -0400", hash_original_field = "3EB3C1A4116A4EB53B758AE0763418BF", hash_generated_field = "93166E1F7AB57FEAE3A008DD7B7E8514")

        public SyncNotificationInfo mSyncNotificationInfo = new SyncNotificationInfo();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.957 -0400", hash_original_field = "F4AC20FF2B0D9B9001095C466DD1B77E", hash_generated_field = "0C75AEF43A0C9FFA242F4986360329AE")

        private Long mAlarmScheduleTime = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.957 -0400", hash_original_field = "D303E2362A0CCEFF2175ABCFFA7F631D", hash_generated_field = "EE16F7F23F2B678069D113811C810C15")

        public SyncTimeTracker mSyncTimeTracker = new SyncTimeTracker();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.957 -0400", hash_original_field = "AAD4F16B34370A021E0CB4C912ACE611", hash_generated_field = "85DC56AC24A9E95A3C6592A93E61E870")

        private HashMap<Pair<Account, String>, PowerManager.WakeLock> mWakeLocks = Maps.newHashMap();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.957 -0400", hash_original_field = "DDAD6CB2080EECA658633769B438411A", hash_generated_field = "28D2205C6B63956ABF9398C7BB3353C2")

        private volatile CountDownLatch mReadyToRunLatch = new CountDownLatch(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.969 -0400", hash_original_method = "483F6356A2D06E95B4EBFBB05049FAB5", hash_generated_method = "2554A8ECD9A719B3BF2C53204C68C88D")
        public  SyncHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.974 -0400", hash_original_method = "A4C54FCCA01900F2BC7EC8A1E7F40380", hash_generated_method = "F8871811763F0C577983C96491676F31")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.991 -0400", hash_original_method = "F60450395CB7370B81745EFD5F3059FF", hash_generated_method = "60CEC8043EAA55232F79CFE365367A1A")
        private PowerManager.WakeLock getSyncWakeLock(Account account, String authority) {
            PowerManager.WakeLock varB4EAC82CA7396A68D541C85D26508E83_1546907833 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1546907833 = wakeLock;
            addTaint(account.getTaint());
            addTaint(authority.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1546907833.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1546907833;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:04.995 -0400", hash_original_method = "CE8AE663CA89CC7DD7AABF796BC60E1D", hash_generated_method = "FE088508F84EEC22AF3E88C53DB24353")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:05.043 -0400", hash_original_method = "AC98BBE28F5005D2D34EEDF919BF395C", hash_generated_method = "22D79DC9199DD31B129F1C0ADC712C33")
        public void handleMessage(Message msg) {
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
                        boolean var583468BD93EF069D3E21BBFA72DDD538_539944762 = (Log.isLoggable(TAG, Log.VERBOSE));
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
                    boolean var5FC87F7ECAA44100B96543687E8D1157_926658400 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
                //End case SyncHandler.MESSAGE_SYNC_FINISHED 
                //Begin case SyncHandler.MESSAGE_SYNC_FINISHED 
                SyncHandlerMessagePayload payload;
                payload = (SyncHandlerMessagePayload)msg.obj;
                //End case SyncHandler.MESSAGE_SYNC_FINISHED 
                //Begin case SyncHandler.MESSAGE_SYNC_FINISHED 
                {
                    boolean varBA2B30809006AC87B4F9ED60448095E9_1246054221 = (!isSyncStillActive(payload.activeSyncContext));
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
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1389888940 = (Log.isLoggable(TAG, Log.VERBOSE));
                        {
                            Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_CONNECTED: "
                                    + msgData.activeSyncContext);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varC7FD95DDD2260EADDB8E624A9C0825F6_534347534 = (isSyncStillActive(msgData.activeSyncContext));
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
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1764226985 = (Log.isLoggable(TAG, Log.VERBOSE));
                        {
                            Log.d(TAG, "handleSyncHandlerMessage: MESSAGE_SERVICE_DISCONNECTED: "
                                    + currentSyncContext);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var8ABF090AC2884C22D7C7551D49051447_207840056 = (isSyncStillActive(currentSyncContext));
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
                    boolean var5FC87F7ECAA44100B96543687E8D1157_2036671451 = (Log.isLoggable(TAG, Log.VERBOSE));
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
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:05.461 -0400", hash_original_method = "5F18B995A8D5126079C876CBB8B37FF8", hash_generated_method = "EB9443D3F73CE9E8D15807988B6C1C0B")
        private long scheduleReadyPeriodicSyncs() {
            boolean backgroundDataUsageAllowed;
            backgroundDataUsageAllowed = getConnectivityManager().getBackgroundDataSetting();
            long earliestFuturePollTime;
            earliestFuturePollTime = Long.MAX_VALUE;
            {
                boolean varC4F9DD6A708570A0C749B94E2E7FDF0F_2078568435 = (!backgroundDataUsageAllowed || !mSyncStorageEngine.getMasterSyncAutomatically());
            } //End collapsed parenthetic
            long nowAbsolute;
            nowAbsolute = System.currentTimeMillis();
            ArrayList<SyncStorageEngine.AuthorityInfo> infos;
            infos = mSyncStorageEngine.getAuthorities();
            {
                Iterator<SyncStorageEngine.AuthorityInfo> varC4FCEB1607AD0D2D215FDDD8362DAF36_2125807388 = (infos).iterator();
                varC4FCEB1607AD0D2D215FDDD8362DAF36_2125807388.hasNext();
                SyncStorageEngine.AuthorityInfo info = varC4FCEB1607AD0D2D215FDDD8362DAF36_2125807388.next();
                {
                    {
                        boolean var4F72312E8BC45601DFFBAD51C30C06F1_2026839072 = (!ArrayUtils.contains(mAccounts, info.account));
                    } //End collapsed parenthetic
                    {
                        boolean var41663A909D23D063D4B5AFBCA7A8A368_773212252 = (!mSyncStorageEngine.getSyncAutomatically(info.account, info.authority));
                    } //End collapsed parenthetic
                    {
                        boolean varBF1A825481B58DFD24124DB4EE59FE57_1367120393 = (mSyncStorageEngine.getIsSyncable(info.account, info.authority) == 0);
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
            long var377A5C4AB2ECC9D2ABC9EC45C6319817_1731251205 = (SystemClock.elapsedRealtime()
                    + ((earliestFuturePollTime < nowAbsolute)
                      ? 0
                      : (earliestFuturePollTime - nowAbsolute))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            long var0F5264038205EDFB1AC05FBB0E8C5E94_909002078 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_909002078;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:07.375 -0400", hash_original_method = "8B5418D48FBDFB608CDA80C6788E1356", hash_generated_method = "E2040D0F86C8D9445A916DAB1FCFB21E")
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
                    boolean var340C1D4D9E1D2C91EE6FE9A98B7CEC0B_1425225450 = (operationIterator.hasNext());
                    {
                        SyncOperation op;
                        op = operationIterator.next();
                        {
                            boolean var9DF7D9069DE48617930394A60905575E_951544396 = (!ArrayUtils.contains(mAccounts, op.account));
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
                            boolean var5A423FA495D65808CF647D9D5D5D33E5_1096110409 = (!op.extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS, false)
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
                        Iterator<ActiveSyncContext> var20645BE964392164F6E4174B19EE47A5_1829983280 = (mActiveSyncContexts).iterator();
                        var20645BE964392164F6E4174B19EE47A5_1829983280.hasNext();
                        ActiveSyncContext activeSyncContext = var20645BE964392164F6E4174B19EE47A5_1829983280.next();
                        {
                            SyncOperation activeOp;
                            activeOp = activeSyncContext.mSyncOperation;
                            {
                                boolean var88156E87F289A86AB7CC4C7CE0A7364C_493400133 = (activeOp.isInitialization());
                            } //End collapsed parenthetic
                            {
                                boolean var3BD76041BE9F72E30B119A23228D3264_75263624 = (activeOp.account.type.equals(candidate.account.type)
                            && activeOp.authority.equals(candidate.authority)
                            && (!activeOp.allowParallelSyncs
                                || activeOp.account.name.equals(candidate.account.name)));
                                {
                                    conflict = activeSyncContext;
                                } //End block
                                {
                                    {
                                        boolean var79DB07D9BA6372A590E984F48C84F69B_120314043 = (candidateIsInitialization == activeOp.isInitialization()
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
                            boolean varD6CAC9C6C357DD6052AAB1ED368A7093_167453818 = (candidateIsInitialization && !conflict.mSyncOperation.isInitialization()
                            && numInit < MAX_SIMULTANEOUS_INITIALIZATION_SYNCS);
                            {
                                toReschedule = conflict;
                                {
                                    boolean varB886653DBE5AD63346733F0FC6D36E19_755801811 = (Log.isLoggable(TAG, Log.VERBOSE));
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean varEBD4A65C44B5C00E1C33A1C6DE2B79F3_474193990 = (candidate.expedited && !conflict.mSyncOperation.expedited
                            && (candidateIsInitialization
                                == conflict.mSyncOperation.isInitialization()));
                                {
                                    toReschedule = conflict;
                                    {
                                        boolean varCF8461C47EF234EA3373DC7BC06410EC_1298937139 = (Log.isLoggable(TAG, Log.VERBOSE));
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
                            boolean var2AB44D382A887D969D31457896E79E6B_1337716888 = (longRunning != null
                            && (candidateIsInitialization
                                == longRunning.mSyncOperation.isInitialization()));
                            {
                                toReschedule = longRunning;
                                {
                                    boolean varB886653DBE5AD63346733F0FC6D36E19_961473481 = (Log.isLoggable(TAG, Log.VERBOSE));
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
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1393464750 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1393464750;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:07.564 -0400", hash_original_method = "40340E62514BC19DB7E9216642814F86", hash_generated_method = "D8F98BC85727D9EF418F3DB099AAE9D1")
        private boolean dispatchSyncOperation(SyncOperation op) {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_553651613 = (Log.isLoggable(TAG, Log.VERBOSE));
                {
                    {
                        Iterator<ActiveSyncContext> varBCD99CACB997EB3D1458946CDF6FE790_9284290 = (mActiveSyncContexts).iterator();
                        varBCD99CACB997EB3D1458946CDF6FE790_9284290.hasNext();
                        ActiveSyncContext syncContext = varBCD99CACB997EB3D1458946CDF6FE790_9284290.next();
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
                boolean var9C0394913D1D3E76433CD87690A4731B_1384219047 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            {
                boolean var689CF975CE88D03CB21DEFF3F17DC74D_1468987499 = (!activeSyncContext.bindToSyncAdapter(syncAdapterInfo));
                {
                    closeActiveSyncContext(activeSyncContext);
                } //End block
            } //End collapsed parenthetic
            addTaint(op.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_925152794 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_925152794;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:07.585 -0400", hash_original_method = "61AEAAC860377C6ACC1D13743DAD80A2", hash_generated_method = "D57DA9FBEEB6FDE6B294D50800AA4082")
        private void runBoundToSyncAdapter(final ActiveSyncContext activeSyncContext,
              ISyncAdapter syncAdapter) {
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
            addTaint(activeSyncContext.getTaint());
            addTaint(syncAdapter.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:07.653 -0400", hash_original_method = "7B28CEC882EFEBA05BFBBAFD319121EA", hash_generated_method = "716F1F48B6D0F2F4BFE93B9C63FBC245")
        private void cancelActiveSyncLocked(Account account, String authority) {
            ArrayList<ActiveSyncContext> activeSyncs;
            activeSyncs = new ArrayList<ActiveSyncContext>(mActiveSyncContexts);
            {
                Iterator<ActiveSyncContext> varAAAC086D3900935D623B1369638ED0DB_791017305 = (activeSyncs).iterator();
                varAAAC086D3900935D623B1369638ED0DB_791017305.hasNext();
                ActiveSyncContext activeSyncContext = varAAAC086D3900935D623B1369638ED0DB_791017305.next();
                {
                    {
                        {
                            {
                                boolean var8037C8DE9F4E8AA58BB79ADB5D51F3E6_2105283998 = (!account.equals(activeSyncContext.mSyncOperation.account));
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                boolean varF9430EBD0568960E5EAFBC08F8B701A4_557286416 = (!authority.equals(activeSyncContext.mSyncOperation.authority));
                            } //End collapsed parenthetic
                        } //End block
                        runSyncFinishedOrCanceledLocked(null ,
                            activeSyncContext);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            addTaint(account.getTaint());
            addTaint(authority.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:07.681 -0400", hash_original_method = "8D8637124BC010FEF841826099E3536E", hash_generated_method = "ADB71C19CF87BDD9AF5554333973DCAC")
        private void runSyncFinishedOrCanceledLocked(SyncResult syncResult,
                ActiveSyncContext activeSyncContext) {
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
                    boolean var3966D9B0F8863425CFD3A0BE46FDBEF6_1492072570 = (!syncResult.hasError());
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
            addTaint(syncResult.getTaint());
            addTaint(activeSyncContext.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:07.690 -0400", hash_original_method = "1880B76D7799B7E884F5DD7B88555973", hash_generated_method = "B192F76D3A39266E07FFB036D962CED8")
        private void closeActiveSyncContext(ActiveSyncContext activeSyncContext) {
            activeSyncContext.close();
            mActiveSyncContexts.remove(activeSyncContext);
            mSyncStorageEngine.removeActiveSync(activeSyncContext.mSyncInfo);
            addTaint(activeSyncContext.getTaint());
            // ---------- Original Method ----------
            //activeSyncContext.close();
            //mActiveSyncContexts.remove(activeSyncContext);
            //mSyncStorageEngine.removeActiveSync(activeSyncContext.mSyncInfo);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:07.696 -0400", hash_original_method = "F73ADCF1F7F7E573F488FB12A7E0DEC9", hash_generated_method = "AB0E444F69158D7BC4BB7C9FAE22970E")
        private int syncResultToErrorNumber(SyncResult syncResult) {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("we are not in an error state, " + syncResult);
            addTaint(syncResult.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823381506 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823381506;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.033 -0400", hash_original_method = "D7164ED4506DE94304BF76B0FBC03583", hash_generated_method = "15AE3B315E0855FCDC5A1D4BF2886BA1")
        private void manageSyncNotificationLocked() {
            boolean shouldCancel;
            boolean shouldInstall;
            {
                boolean var81ED16291C5BDEEB678C6A2565F01300_179167223 = (mActiveSyncContexts.isEmpty());
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
                                Iterator<ActiveSyncContext> var20645BE964392164F6E4174B19EE47A5_562103984 = (mActiveSyncContexts).iterator();
                                var20645BE964392164F6E4174B19EE47A5_562103984.hasNext();
                                ActiveSyncContext activeSyncContext = var20645BE964392164F6E4174B19EE47A5_562103984.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.707 -0400", hash_original_method = "E1B88EC7C887370D571018E17194D40D", hash_generated_method = "9FB05BA0E2D2C00EB25F33A6085D05F2")
        private void manageSyncAlarmLocked(long nextPeriodicEventElapsedTime,
                long nextPendingEventElapsedTime) {
            long notificationTime;
            notificationTime = mSyncHandler.mSyncNotificationInfo.startTime + SYNC_NOTIFICATION_DELAY;
            notificationTime = Long.MAX_VALUE;
            long earliestTimeoutTime;
            earliestTimeoutTime = Long.MAX_VALUE;
            {
                Iterator<ActiveSyncContext> varB42644AE74A51E951ED6AB5DD20DA8CE_1611528200 = (mActiveSyncContexts).iterator();
                varB42644AE74A51E951ED6AB5DD20DA8CE_1611528200.hasNext();
                ActiveSyncContext currentSyncContext = varB42644AE74A51E951ED6AB5DD20DA8CE_1611528200.next();
                {
                    long currentSyncTimeoutTime;
                    currentSyncTimeoutTime = currentSyncContext.mTimeoutStartTime + MAX_TIME_PER_SYNC;
                    {
                        boolean var583468BD93EF069D3E21BBFA72DDD538_1480565888 = (Log.isLoggable(TAG, Log.VERBOSE));
                    } //End collapsed parenthetic
                    {
                        earliestTimeoutTime = currentSyncTimeoutTime;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1371805894 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1384414912 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1106863794 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1028353800 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            long alarmTime;
            alarmTime = Math.min(notificationTime, earliestTimeoutTime);
            alarmTime = Math.min(alarmTime, nextPeriodicEventElapsedTime);
            alarmTime = Math.min(alarmTime, nextPendingEventElapsedTime);
            long now;
            now = SystemClock.elapsedRealtime();
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_190716814 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
                alarmTime = now + SYNC_ALARM_TIMEOUT_MIN;
            } //End block
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1072084749 = (Log.isLoggable(TAG, Log.VERBOSE));
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
                    boolean var5FC87F7ECAA44100B96543687E8D1157_312466007 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
                mAlarmScheduleTime = alarmTime;
                mAlarmService.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, alarmTime,
                        mSyncAlarmIntent);
            } //End block
            {
                mAlarmScheduleTime = null;
                mAlarmService.cancel(mSyncAlarmIntent);
            } //End block
            addTaint(nextPeriodicEventElapsedTime);
            addTaint(nextPendingEventElapsedTime);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.709 -0400", hash_original_method = "A9010BB637A8EEC323C58050189C44ED", hash_generated_method = "B44B2E041947CAC83E07E81F7AF1EC3B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.719 -0400", hash_original_method = "87A468A0891FD210AAD2B0099F053FF2", hash_generated_method = "724ADF58886CE6AA7926F18CCE35D19D")
        private void installHandleTooManyDeletesNotification(Account account, String authority,
                long numDeletes) {
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
                boolean varF70BDA0CA489003C43C444F0D1E24D31_163028894 = (!isActivityAvailable(clickIntent));
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
            addTaint(account.getTaint());
            addTaint(authority.getTaint());
            addTaint(numDeletes);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.741 -0400", hash_original_method = "ABB616725C31652C20F8F96BBDEFC6AA", hash_generated_method = "8BC75CFC2E96D9016648106E913BBDD1")
        private boolean isActivityAvailable(Intent intent) {
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
            addTaint(intent.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1538330090 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1538330090;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.742 -0400", hash_original_method = "6B3E86A8BC94835376C1AE5FBE72A92C", hash_generated_method = "EBE76F7E62BD89001F93A67C3ADC3D72")
        public long insertStartSyncEvent(SyncOperation syncOperation) {
            int source;
            source = syncOperation.syncSource;
            long now;
            now = System.currentTimeMillis();
            EventLog.writeEvent(2720, syncOperation.authority,
                                SyncStorageEngine.EVENT_START, source,
                                syncOperation.account.name.hashCode());
            long var4469B750121AA371E44777A358FA181D_956598858 = (mSyncStorageEngine.insertStartSyncEvent(
                    syncOperation.account, syncOperation.authority, now, source));
            addTaint(syncOperation.getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1644046138 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1644046138;
            // ---------- Original Method ----------
            //final int source = syncOperation.syncSource;
            //final long now = System.currentTimeMillis();
            //EventLog.writeEvent(2720, syncOperation.authority,
                                //SyncStorageEngine.EVENT_START, source,
                                //syncOperation.account.name.hashCode());
            //return mSyncStorageEngine.insertStartSyncEvent(
                    //syncOperation.account, syncOperation.authority, now, source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.754 -0400", hash_original_method = "7B2BF6D83EFC49C83F4A75250B3225F9", hash_generated_method = "C1B1C2A16D93AA9057B766ABC0B159C8")
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
            // ---------- Original Method ----------
            //EventLog.writeEvent(2720, syncOperation.authority,
                                //SyncStorageEngine.EVENT_STOP, syncOperation.syncSource,
                                //syncOperation.account.name.hashCode());
            //mSyncStorageEngine.stopSyncEvent(rowId, elapsedTime,
                    //resultMessage, downstreamActivity, upstreamActivity);
        }

        
        class SyncNotificationInfo {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.754 -0400", hash_original_field = "7899BB2CC98E6AA80AEA065C2FB1FCD8", hash_generated_field = "1F020E689776523E90BE0EA7B3F2C831")

            public boolean isActive = false;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.754 -0400", hash_original_field = "5C942F641C110ED5DBCFAC50E6B9ACF7", hash_generated_field = "C38616C84435C3AAF7A5C7D2D3DE9890")

            public Long startTime = null;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.754 -0400", hash_original_method = "4A2C88DB351F685B767C50ED28D568B0", hash_generated_method = "4A2C88DB351F685B767C50ED28D568B0")
            public SyncNotificationInfo ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.764 -0400", hash_original_method = "4796BE9F4C6BFE28E8FE17808C5D7635", hash_generated_method = "5C8B2071F9A36A8B6B849B516A74B4EC")
            public void toString(StringBuilder sb) {
                sb.append("isActive ").append(isActive).append(", startTime ").append(startTime);
                addTaint(sb.getTaint());
                // ---------- Original Method ----------
                //sb.append("isActive ").append(isActive).append(", startTime ").append(startTime);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.765 -0400", hash_original_method = "C99E9A460C6F28DBA730EF38203534A2", hash_generated_method = "4AC3F7111DCE5633925D178DCD0E1BEB")
            @Override
            public String toString() {
                String varB4EAC82CA7396A68D541C85D26508E83_713427708 = null; //Variable for return #1
                StringBuilder sb;
                sb = new StringBuilder();
                toString(sb);
                varB4EAC82CA7396A68D541C85D26508E83_713427708 = sb.toString();
                varB4EAC82CA7396A68D541C85D26508E83_713427708.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_713427708;
                // ---------- Original Method ----------
                //StringBuilder sb = new StringBuilder();
                //toString(sb);
                //return sb.toString();
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.765 -0400", hash_original_field = "04E66466C1F093B8709FCD3B200847DE", hash_generated_field = "F03D76E24B5BAEEEC5E781E9842C4EB9")

        private static int MESSAGE_SYNC_FINISHED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.765 -0400", hash_original_field = "E8072A633FC65A35E7F3B406DE8746BA", hash_generated_field = "BDB782007E5D68167F6B06EB2CA7D48A")

        private static int MESSAGE_SYNC_ALARM = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.765 -0400", hash_original_field = "58210B9DA4E39CD1A4BAC72BC3D1B4F6", hash_generated_field = "7364E5491E895C2B98EB095F0B8835C8")

        private static int MESSAGE_CHECK_ALARMS = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.766 -0400", hash_original_field = "2B6D236658EBB17D35BFDF5A5759BF4F", hash_generated_field = "5C4626A1E2FFC85FE88989D99FB13AD1")

        private static int MESSAGE_SERVICE_CONNECTED = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.766 -0400", hash_original_field = "EBB171FB6C106E6744E6D70DA20EEF7D", hash_generated_field = "9731C7183B81379CA2B0325FF943A098")

        private static int MESSAGE_SERVICE_DISCONNECTED = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.766 -0400", hash_original_field = "B56FD915F9E3BA514D2DA1F9DBF0F24B", hash_generated_field = "0105AF109819D8B5DE1BE5345785186D")

        private static int MESSAGE_CANCEL = 6;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.766 -0400", hash_original_field = "0439F4DA6A334C5ECD9FAAB83A40EC1E", hash_generated_field = "CAAD11AC43D5339C465E3446FFFD23C9")

    private static String TAG = "SyncManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.767 -0400", hash_original_field = "771C7532EFD39D46D9339548BBB003DC", hash_generated_field = "4208D47E32C101BD1011FA8D9E027183")

    private static long LOCAL_SYNC_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.767 -0400", hash_original_field = "3E2805F816BDAD7B0E27638D25F6D269", hash_generated_field = "63AD8E40CBA9E89F2FEE5FAFC18666A5")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.767 -0400", hash_original_field = "1CEBD7C64FE2AC04D4AE482388A5976D", hash_generated_field = "3AAF491FDBA16F2F889370991CA097D0")

    private static long SYNC_NOTIFICATION_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.767 -0400", hash_original_field = "8A34DCE73DB332FD0A4FF63A9C446008", hash_generated_field = "738A64AE1BCDB6D45B8E9446442A5D9D")

    private static long INITIAL_SYNC_RETRY_TIME_IN_MS = 30 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.767 -0400", hash_original_field = "79DEDA6259DEAD6C126CF86621DA2B8D", hash_generated_field = "36785B42573E48B52EC05DD22FA4CADD")

    private static long DEFAULT_MAX_SYNC_RETRY_TIME_IN_SECONDS = 60 * 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.767 -0400", hash_original_field = "BEDF93B108551F114E8741DFEC9794F3", hash_generated_field = "FEB1A6CFFF63292E299BC766075EA1EB")

    private static int DELAY_RETRY_SYNC_IN_PROGRESS_IN_SECONDS = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.767 -0400", hash_original_field = "958F3D750E64AC9BC6242F30C61536C4", hash_generated_field = "2ABBBCEA003E968CABA21C21F8E19EAF")

    private static int INITIALIZATION_UNBIND_DELAY_MS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.768 -0400", hash_original_field = "F895C5D283689380E1BDDC0B7499335D", hash_generated_field = "F0F564D63DC515226C3DB6C6381621F7")

    private static String SYNC_WAKE_LOCK_PREFIX = "*sync*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.768 -0400", hash_original_field = "C0E30578C8EE9D3B561C121F18E4A9AD", hash_generated_field = "5B9AC49224084BC188F63D33A5C70336")

    private static String HANDLE_SYNC_ALARM_WAKE_LOCK = "SyncManagerHandleSyncAlarm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.768 -0400", hash_original_field = "001DF2B72F4A5E3029F7CCA97081B70A", hash_generated_field = "FAFC51944D1C22396908865A002142F6")

    private static String SYNC_LOOP_WAKE_LOCK = "SyncLoopWakeLock";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.768 -0400", hash_original_field = "21F59C952591D05458A974B04A5B1713", hash_generated_field = "DC304F1B2F6CD9046C54D34DCF49FB2F")

    private static int MAX_SIMULTANEOUS_REGULAR_SYNCS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.768 -0400", hash_original_field = "10B69AAB2B5C562523E268773A0D00E7", hash_generated_field = "8E80CF6DF9009EC95BD99B5E32172ABF")

    private static int MAX_SIMULTANEOUS_INITIALIZATION_SYNCS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.768 -0400", hash_original_field = "1A4663330AD445B983CE39BD12E9AD75", hash_generated_field = "47EFE00C0C7B77E295CF242822F764B6")

    private static Account[] INITIAL_ACCOUNTS_ARRAY = new Account[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.792 -0400", hash_original_field = "5BC49BB889CB3FAFB9C3D3A1F33F6081", hash_generated_field = "1332F5A6173CE9C71B6FBF180C80799D")

    private static long SYNC_ALARM_TIMEOUT_MIN = 30 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.793 -0400", hash_original_field = "06AAABB61EB2A5F0EA12B8589056A2BF", hash_generated_field = "AB35B359DB2CEF2E1E74EFA6F9496151")

    private static long SYNC_ALARM_TIMEOUT_MAX = 2 * 60 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.793 -0400", hash_original_field = "227D4DFA41347C0DE3EB12E8255A744E", hash_generated_field = "EE00E46E51CCB88A104EB708B09CE0BA")

    private static String ACTION_SYNC_ALARM = "android.content.syncmanager.SYNC_ALARM";
}

