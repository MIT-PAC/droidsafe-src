package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractThreadedSyncAdapter {
    @Deprecated public static int LOG_SYNC_DETAILS = 2743;
    private Context mContext;
    private AtomicInteger mNumSyncStarts;
    private ISyncAdapterImpl mISyncAdapterImpl;
    private HashMap<Account, SyncThread> mSyncThreads = new HashMap<Account, SyncThread>();
    private Object mSyncThreadLock = new Object();
    private boolean mAutoInitialize;
    private boolean mAllowParallelSyncs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.701 -0400", hash_original_method = "B865BB2D1334DC45D9907C5CC59DE93A", hash_generated_method = "1D4DF2DF3990E9993AFE618D2ACCF536")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbstractThreadedSyncAdapter(Context context, boolean autoInitialize) {
        this(context, autoInitialize, false );
        dsTaint.addTaint(autoInitialize);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.714 -0400", hash_original_method = "5CA02CE85005DB7A14B35230E54E7132", hash_generated_method = "35DD9483CFC4A9DF55D65E6521B77AFA")
    @DSModeled(DSC.SAFE)
    public AbstractThreadedSyncAdapter(Context context,
            boolean autoInitialize, boolean allowParallelSyncs) {
        dsTaint.addTaint(autoInitialize);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(allowParallelSyncs);
        mISyncAdapterImpl = new ISyncAdapterImpl();
        mNumSyncStarts = new AtomicInteger(0);
        // ---------- Original Method ----------
        //mContext = context;
        //mISyncAdapterImpl = new ISyncAdapterImpl();
        //mNumSyncStarts = new AtomicInteger(0);
        //mAutoInitialize = autoInitialize;
        //mAllowParallelSyncs = allowParallelSyncs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.724 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "9B65AC4EA6CCDDDA341BF99C9DD2713E")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.730 -0400", hash_original_method = "790F4AB6D952C2DA3921D17668FD582E", hash_generated_method = "27E3752F21F6573DDF1367A9E4196EEE")
    @DSModeled(DSC.SAFE)
    private Account toSyncKey(Account account) {
        dsTaint.addTaint(account.dsTaint);
        return (Account)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mAllowParallelSyncs) {
            //return account;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.737 -0400", hash_original_method = "5D55B4CBFD94291B023C63B64529CB8E", hash_generated_method = "3B5B3BE26ED997918EF7481B35180FD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IBinder getSyncAdapterBinder() {
        IBinder var470FDA67DDDBD8E0A141D83C123D1824_730250787 = (mISyncAdapterImpl.asBinder());
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mISyncAdapterImpl.asBinder();
    }

    
    public abstract void onPerformSync(Account account, Bundle extras,
            String authority, ContentProviderClient provider, SyncResult syncResult);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.757 -0400", hash_original_method = "CA8346F7EC31770030C73D95257F81B4", hash_generated_method = "6BE4CA70AEE91C752C8295C6B8DBB01A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onSyncCanceled() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        SyncThread syncThread;
        {
            syncThread = mSyncThreads.get(null);
        } //End block
        {
            syncThread.interrupt();
        } //End block
        // ---------- Original Method ----------
        //final SyncThread syncThread;
        //synchronized (mSyncThreadLock) {
            //syncThread = mSyncThreads.get(null);
        //}
        //if (syncThread != null) {
            //syncThread.interrupt();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.765 -0400", hash_original_method = "D4CC1D7F3C7640D9798CBF10AC94C467", hash_generated_method = "42B8B8AB43192DEFF9C6DB1CC22CCE6D")
    @DSModeled(DSC.SAFE)
    public void onSyncCanceled(Thread thread) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(thread.dsTaint);
        thread.interrupt();
        // ---------- Original Method ----------
        //thread.interrupt();
    }

    
    private class ISyncAdapterImpl extends ISyncAdapter.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.806 -0400", hash_original_method = "38845D382FD352E7E7131C94C60DC4DC", hash_generated_method = "5ED73371376B4256578563CC3781DFF2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void startSync(ISyncContext syncContext, String authority, Account account,
                Bundle extras) {
            dsTaint.addTaint(authority);
            dsTaint.addTaint(account.dsTaint);
            dsTaint.addTaint(syncContext.dsTaint);
            dsTaint.addTaint(extras.dsTaint);
            SyncContext syncContextClient;
            syncContextClient = new SyncContext(syncContext);
            boolean alreadyInProgress;
            Account threadsKey;
            threadsKey = toSyncKey(account);
            {
                {
                    boolean varE8BD75E8AD1C3E6E4AA347AD29E5D6F5_1207268181 = (!mSyncThreads.containsKey(threadsKey));
                    {
                        {
                            boolean varAEB5703E7C1B28E37379E7C7D5DB90D6_1644033131 = (mAutoInitialize
                            && extras != null
                            && extras.getBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, false));
                            {
                                {
                                    boolean var35834C5D82836ABDA1CF6C18D7BC0A21_504509608 = (ContentResolver.getIsSyncable(account, authority) < 0);
                                    {
                                        ContentResolver.setIsSyncable(account, authority, 1);
                                    } //End block
                                } //End collapsed parenthetic
                                syncContextClient.onFinished(new SyncResult());
                            } //End block
                        } //End collapsed parenthetic
                        SyncThread syncThread;
                        syncThread = new SyncThread(
                            "SyncAdapterThread-" + mNumSyncStarts.incrementAndGet(),
                            syncContextClient, authority, account, extras);
                        mSyncThreads.put(threadsKey, syncThread);
                        syncThread.start();
                        alreadyInProgress = false;
                    } //End block
                    {
                        alreadyInProgress = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                syncContextClient.onFinished(SyncResult.ALREADY_IN_PROGRESS);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.845 -0400", hash_original_method = "D8E22288236DCBDF1105EA85EC77E122", hash_generated_method = "9440025E32A3D057E323CE63C3C3BEE5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void cancelSync(ISyncContext syncContext) {
            dsTaint.addTaint(syncContext.dsTaint);
            SyncThread info;
            info = null;
            {
                {
                    Iterator<SyncThread> varF491ADACD6CCE77C5327C424765DD133_987401113 = mSyncThreads.values().iterator();
                    varF491ADACD6CCE77C5327C424765DD133_987401113.hasNext();
                    SyncThread current = varF491ADACD6CCE77C5327C424765DD133_987401113.next();
                    {
                        {
                            boolean varBFFFB7A9601E31FCB9900CB8951C10A8_1214961480 = (current.mSyncContext.getSyncContextBinder() == syncContext.asBinder());
                            {
                                info = current;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    onSyncCanceled(info);
                } //End block
                {
                    onSyncCanceled();
                } //End block
            } //End block
            // ---------- Original Method ----------
            //SyncThread info = null;
            //synchronized (mSyncThreadLock) {
                //for (SyncThread current : mSyncThreads.values()) {
                    //if (current.mSyncContext.getSyncContextBinder() == syncContext.asBinder()) {
                        //info = current;
                        //break;
                    //}
                //}
            //}
            //if (info != null) {
                //if (mAllowParallelSyncs) {
                    //onSyncCanceled(info);
                //} else {
                    //onSyncCanceled();
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.855 -0400", hash_original_method = "2FD2C581F125A3E58387BAD4F7701DFE", hash_generated_method = "4E59032490A96213BD7D1DBAAF87E1DF")
        @DSModeled(DSC.SAFE)
        public void initialize(Account account, String authority) throws RemoteException {
            dsTaint.addTaint(authority);
            dsTaint.addTaint(account.dsTaint);
            Bundle extras;
            extras = new Bundle();
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, true);
            startSync(null, authority, account, extras);
            // ---------- Original Method ----------
            //Bundle extras = new Bundle();
            //extras.putBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, true);
            //startSync(null, authority, account, extras);
        }

        
    }


    
    private class SyncThread extends Thread {
        private SyncContext mSyncContext;
        private String mAuthority;
        private Account mAccount;
        private Bundle mExtras;
        private Account mThreadsKey;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.868 -0400", hash_original_method = "EF8D05995E0E8B5EB798D0CE2C473FF0", hash_generated_method = "23B74F34699B1EE1B785CF845137520A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SyncThread(String name, SyncContext syncContext, String authority,
                Account account, Bundle extras) {
            super(name);
            dsTaint.addTaint(authority);
            dsTaint.addTaint(name);
            dsTaint.addTaint(account.dsTaint);
            dsTaint.addTaint(syncContext.dsTaint);
            dsTaint.addTaint(extras.dsTaint);
            mThreadsKey = toSyncKey(account);
            // ---------- Original Method ----------
            //mSyncContext = syncContext;
            //mAuthority = authority;
            //mAccount = account;
            //mExtras = extras;
            //mThreadsKey = toSyncKey(account);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.894 -0400", hash_original_method = "4CA3DD716A0BD73ED7F0FD0D54F60C44", hash_generated_method = "D62ED295C3321380F5F77501E8D4FB75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
            SyncResult syncResult;
            syncResult = new SyncResult();
            ContentProviderClient provider;
            provider = null;
            try 
            {
                {
                    boolean var5D000DAEE418007C8D10575DDD0B45B4_29735157 = (isCanceled());
                } //End collapsed parenthetic
                provider = mContext.getContentResolver().acquireContentProviderClient(mAuthority);
                {
                    AbstractThreadedSyncAdapter.this.onPerformSync(mAccount, mExtras,
                            mAuthority, provider, syncResult);
                } //End block
                {
                    syncResult.databaseError = true;
                } //End block
            } //End block
            finally 
            {
                {
                    provider.release();
                } //End block
                {
                    boolean varD93F6E0E3A45D7C4E49763E1FF312CD7_1654112644 = (!isCanceled());
                    {
                        mSyncContext.onFinished(syncResult);
                    } //End block
                } //End collapsed parenthetic
                {
                    mSyncThreads.remove(mThreadsKey);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:59:22.908 -0400", hash_original_method = "AF64882FDB439923A57610742F2CCD01", hash_generated_method = "81AA37BCD69F2FB2CC859C28DC62DF6B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean isCanceled() {
            boolean varDF71F4952A72B08F699422E8D275C98A_235350204 = (Thread.currentThread().isInterrupted());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return Thread.currentThread().isInterrupted();
        }

        
    }


    
}


