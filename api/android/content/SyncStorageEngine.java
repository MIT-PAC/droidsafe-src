package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.os.AtomicFile;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FastXmlSerializer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import android.accounts.Account;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.List;

public class SyncStorageEngine extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.807 -0400", hash_original_field = "ADB03CF0C832D5859AE5ED806F964C77", hash_generated_field = "DCD9F929FBF293182CD7E5CC415D1656")

    private final SparseArray<AuthorityInfo> mAuthorities = new SparseArray<AuthorityInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.807 -0400", hash_original_field = "6F418588A388F83463153149CC4DFD2D", hash_generated_field = "4B36B4FEA0D3DAD8CB7109B7DAFD4F0B")

    private final HashMap<Account, AccountInfo> mAccounts = new HashMap<Account, AccountInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.807 -0400", hash_original_field = "18B6C8007607AB89FE5846E3CCD3D634", hash_generated_field = "9061F8B36C87BD05CB7B61BC05EEA80D")

    private final ArrayList<PendingOperation> mPendingOperations = new ArrayList<PendingOperation>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.807 -0400", hash_original_field = "42932EF0A1E3F7A4D563C5857A83A6DC", hash_generated_field = "17DF250BDACB991A8443A6BC974E4CEF")

    private final ArrayList<SyncInfo> mCurrentSyncs = new ArrayList<SyncInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.807 -0400", hash_original_field = "BA03FCA3B2DAC61378D307CC61745CC1", hash_generated_field = "BB2BD481DA5E1951BA328BC00E9DDD6F")

    private final SparseArray<SyncStatusInfo> mSyncStatus = new SparseArray<SyncStatusInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.807 -0400", hash_original_field = "39E6D04F8E50FBD9E462DB47F9370F10", hash_generated_field = "6703D3447B5F81BE530922662FF9E2F7")

    private final ArrayList<SyncHistoryItem> mSyncHistory = new ArrayList<SyncHistoryItem>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.807 -0400", hash_original_field = "142C9D318C79A6D06C86E91880369682", hash_generated_field = "A61DFE30C0F235AC0390EF8C97D18E24")

    private final RemoteCallbackList<ISyncStatusObserver> mChangeListeners = new RemoteCallbackList<ISyncStatusObserver>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.808 -0400", hash_original_field = "52D842D195FB9682477C5FF881B743BC", hash_generated_field = "2AE16416F500BFCB1C37E3AB89C8BDC4")

    private int mNextAuthorityId = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.808 -0400", hash_original_field = "C2685A226EA5E2F07642AFF82B25E12A", hash_generated_field = "02779B60A3F80DE35E35BF0C5E0C43DC")

    private final DayStats[] mDayStats = new DayStats[7*4];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.808 -0400", hash_original_field = "8B91D41DBF7940D3997855F383F055BC", hash_generated_field = "EC9191FB914117C63C6512ED98BDDA48")

    private Calendar mCal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.808 -0400", hash_original_field = "11D990E1A246B4FE4069EE207D869D9B", hash_generated_field = "0FB397B5159C15D66CFFB31661F31030")

    private int mYear;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.808 -0400", hash_original_field = "F2671D7F7646AB869D7AD2D7ECDF3004", hash_generated_field = "254F77756F02336521F67E6CA24B1E30")

    private int mYearInDays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.808 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.808 -0400", hash_original_field = "BC6D4641305DCB897A44E04BF204E566", hash_generated_field = "5D75657BE40E89D85D7C2D95C6C03670")

    private AtomicFile mAccountInfoFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.808 -0400", hash_original_field = "0D0C7FE26E394EF5D9ADF7B5612C8E5E", hash_generated_field = "BFFE61A45AAFF20D720253FB7EAF94E2")

    private AtomicFile mStatusFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.808 -0400", hash_original_field = "C3BB0594E53D1E317FBB3F2CBD55F6B6", hash_generated_field = "B21C478C853D31055421796340DF7AB7")

    private AtomicFile mStatisticsFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.808 -0400", hash_original_field = "16486C7724FFC2223BF73F2E2F294953", hash_generated_field = "3E80DAA8531C0F48AE799261DF00CB4E")

    private AtomicFile mPendingFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.808 -0400", hash_original_field = "56DBA3F4696B0CF5DBF626A8CADC263A", hash_generated_field = "8ECC4C420766F27F9F3D44633E206229")

    private int mNumPendingFinished = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.809 -0400", hash_original_field = "56FD212A9532273FAE1D547FB3CF9D7F", hash_generated_field = "F7ED6F40F4F31B59A250911223633F4B")

    private int mNextHistoryId = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.809 -0400", hash_original_field = "EB99626AD7B7425DAEE7A7B65005D931", hash_generated_field = "EBA144569AB4B50BF3932F380E591D51")

    private boolean mMasterSyncAutomatically = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.810 -0400", hash_original_method = "A6EFE710C6881152489583C4A465D2CD", hash_generated_method = "A17D5CE8054B2871FE235C5A70D9FADE")
    private  SyncStorageEngine(Context context, File dataDir) {
        addTaint(dataDir.getTaint());
        mContext = context;
        sSyncStorageEngine = this;
        mCal = Calendar.getInstance(TimeZone.getTimeZone("GMT+0"));
        File systemDir = new File(dataDir, "system");
        File syncDir = new File(systemDir, "sync");
        syncDir.mkdirs();
        mAccountInfoFile = new AtomicFile(new File(syncDir, "accounts.xml"));
        mStatusFile = new AtomicFile(new File(syncDir, "status.bin"));
        mPendingFile = new AtomicFile(new File(syncDir, "pending.bin"));
        mStatisticsFile = new AtomicFile(new File(syncDir, "stats.bin"));
        readAccountInfoLocked();
        readStatusLocked();
        readPendingOperationsLocked();
        readStatisticsLocked();
        readAndDeleteLegacyAccountInfoLocked();
        writeAccountInfoLocked();
        writeStatusLocked();
        writePendingOperationsLocked();
        writeStatisticsLocked();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static SyncStorageEngine newTestInstance(Context context) {
        return new SyncStorageEngine(context, context.getFilesDir());
    }

    
        public static void init(Context context) {
        if (sSyncStorageEngine != null) {
            return;
        }
        File dataDir = Environment.getSecureDataDirectory();
        sSyncStorageEngine = new SyncStorageEngine(context, dataDir);
    }

    
        public static SyncStorageEngine getSingleton() {
        if (sSyncStorageEngine == null) {
            throw new IllegalStateException("not initialized");
        }
        return sSyncStorageEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.811 -0400", hash_original_method = "4DFC4B128F767AF6A0DE11433A3D7DB7", hash_generated_method = "669236A9391295DBA274922E72966D46")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
    if(msg.what == MSG_WRITE_STATUS)        
        {
            synchronized
(mAuthorities)            {
                writeStatusLocked();
            } //End block
        } //End block
        else
    if(msg.what == MSG_WRITE_STATISTICS)        
        {
            synchronized
(mAuthorities)            {
                writeStatisticsLocked();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (msg.what == MSG_WRITE_STATUS) {
            //synchronized (mAuthorities) {
                //writeStatusLocked();
            //}
        //} else if (msg.what == MSG_WRITE_STATISTICS) {
            //synchronized (mAuthorities) {
                //writeStatisticsLocked();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.812 -0400", hash_original_method = "52497A49330565A574CE17BDC87E49EE", hash_generated_method = "2494473549C3B7090412C86528C5E2A3")
    public void addStatusChangeListener(int mask, ISyncStatusObserver callback) {
        addTaint(callback.getTaint());
        addTaint(mask);
        synchronized
(mAuthorities)        {
            mChangeListeners.register(callback, mask);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //mChangeListeners.register(callback, mask);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.812 -0400", hash_original_method = "6F129CA4CBCD6FCA8FC01A242206CA3D", hash_generated_method = "829163B010B5C5F5757CEE6FDB83D1CF")
    public void removeStatusChangeListener(ISyncStatusObserver callback) {
        addTaint(callback.getTaint());
        synchronized
(mAuthorities)        {
            mChangeListeners.unregister(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //mChangeListeners.unregister(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.813 -0400", hash_original_method = "08D269D186E562E9C4A4640195EC72C3", hash_generated_method = "B3666221FC7702FAE947B49AC7499C36")
    private void reportChange(int which) {
        addTaint(which);
        ArrayList<ISyncStatusObserver> reports = null;
        synchronized
(mAuthorities)        {
            int i = mChangeListeners.beginBroadcast();
            while
(i > 0)            
            {
                i--;
                Integer mask = (Integer)mChangeListeners.getBroadcastCookie(i);
    if((which & mask.intValue()) == 0)                
                {
                    continue;
                } //End block
    if(reports == null)                
                {
                    reports = new ArrayList<ISyncStatusObserver>(i);
                } //End block
                reports.add(mChangeListeners.getBroadcastItem(i));
            } //End block
            mChangeListeners.finishBroadcast();
        } //End block
    if(Log.isLoggable(TAG, Log.VERBOSE))        
        {
        } //End block
    if(reports != null)        
        {
            int i = reports.size();
            while
(i > 0)            
            {
                i--;
                try 
                {
                    reports.get(i).onStatusChanged(which);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.814 -0400", hash_original_method = "1E3EB54BE416021CC2FC55EA818E4E21", hash_generated_method = "A2FF77F7EF4D0EEF63DD534707503530")
    public boolean getSyncAutomatically(Account account, String providerName) {
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
        synchronized
(mAuthorities)        {
    if(account != null)            
            {
                AuthorityInfo authority = getAuthorityLocked(account, providerName,
                        "getSyncAutomatically");
                boolean var07CF0B243709FD85835D0A1EEDCB01EF_330478020 = (authority != null && authority.enabled);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1339940070 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1339940070;
            } //End block
            int i = mAuthorities.size();
            while
(i > 0)            
            {
                i--;
                AuthorityInfo authority = mAuthorities.valueAt(i);
    if(authority.authority.equals(providerName)
                        && authority.enabled)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1617860390 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_410341923 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_410341923;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_514710911 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432849858 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432849858;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //if (account != null) {
                //AuthorityInfo authority = getAuthorityLocked(account, providerName,
                        //"getSyncAutomatically");
                //return authority != null && authority.enabled;
            //}
            //int i = mAuthorities.size();
            //while (i > 0) {
                //i--;
                //AuthorityInfo authority = mAuthorities.valueAt(i);
                //if (authority.authority.equals(providerName)
                        //&& authority.enabled) {
                    //return true;
                //}
            //}
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.815 -0400", hash_original_method = "581987DB149A8DCAC958F242477B1863", hash_generated_method = "2E39C6FDCB34A7B5A95EBBB555E7079E")
    public void setSyncAutomatically(Account account, String providerName, boolean sync) {
        addTaint(sync);
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
        Log.d(TAG, "setSyncAutomatically: " +  ", provider " + providerName
                + " -> " + sync);
        synchronized
(mAuthorities)        {
            AuthorityInfo authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
    if(authority.enabled == sync)            
            {
                Log.d(TAG, "setSyncAutomatically: already set to " + sync + ", doing nothing");
                return;
            } //End block
            authority.enabled = sync;
            writeAccountInfoLocked();
        } //End block
    if(sync)        
        {
            ContentResolver.requestSync(account, providerName, new Bundle());
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        // ---------- Original Method ----------
        //Log.d(TAG, "setSyncAutomatically: " +  ", provider " + providerName
                //+ " -> " + sync);
        //synchronized (mAuthorities) {
            //AuthorityInfo authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
            //if (authority.enabled == sync) {
                //Log.d(TAG, "setSyncAutomatically: already set to " + sync + ", doing nothing");
                //return;
            //}
            //authority.enabled = sync;
            //writeAccountInfoLocked();
        //}
        //if (sync) {
            //ContentResolver.requestSync(account, providerName, new Bundle());
        //}
        //reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.816 -0400", hash_original_method = "669A99F5C38004FBAED3A18D6E12F4E4", hash_generated_method = "31329B348ADA444D6263EC1DBFA16A6D")
    public int getIsSyncable(Account account, String providerName) {
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
        synchronized
(mAuthorities)        {
    if(account != null)            
            {
                AuthorityInfo authority = getAuthorityLocked(account, providerName,
                        "getIsSyncable");
    if(authority == null)                
                {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_321951283 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517593705 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517593705;
                } //End block
                int var3F65FA62367C097CE3F1D04624DF972A_439972557 = (authority.syncable);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248220770 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248220770;
            } //End block
            int i = mAuthorities.size();
            while
(i > 0)            
            {
                i--;
                AuthorityInfo authority = mAuthorities.valueAt(i);
    if(authority.authority.equals(providerName))                
                {
                    int var3F65FA62367C097CE3F1D04624DF972A_1393602041 = (authority.syncable);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961516237 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961516237;
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1900095826 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37469011 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37469011;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //if (account != null) {
                //AuthorityInfo authority = getAuthorityLocked(account, providerName,
                        //"getIsSyncable");
                //if (authority == null) {
                    //return -1;
                //}
                //return authority.syncable;
            //}
            //int i = mAuthorities.size();
            //while (i > 0) {
                //i--;
                //AuthorityInfo authority = mAuthorities.valueAt(i);
                //if (authority.authority.equals(providerName)) {
                    //return authority.syncable;
                //}
            //}
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.818 -0400", hash_original_method = "F95D35FA2526F2113282D0AA6609AE27", hash_generated_method = "606DE907D6D61C23D5AD305858ADFABA")
    public void setIsSyncable(Account account, String providerName, int syncable) {
        addTaint(syncable);
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
    if(syncable > 1)        
        {
            syncable = 1;
        } //End block
        else
    if(syncable < -1)        
        {
            syncable = -1;
        } //End block
        Log.d(TAG, "setIsSyncable: " + account + ", provider " + providerName + " -> " + syncable);
        synchronized
(mAuthorities)        {
            AuthorityInfo authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
    if(authority.syncable == syncable)            
            {
                Log.d(TAG, "setIsSyncable: already set to " + syncable + ", doing nothing");
                return;
            } //End block
            authority.syncable = syncable;
            writeAccountInfoLocked();
        } //End block
    if(syncable > 0)        
        {
            ContentResolver.requestSync(account, providerName, new Bundle());
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.819 -0400", hash_original_method = "8DC1822E61630B36C083348F9F85FD1C", hash_generated_method = "9F37247F518FE9A2BCCE52A424ED4B40")
    public Pair<Long, Long> getBackoff(Account account, String providerName) {
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
        synchronized
(mAuthorities)        {
            AuthorityInfo authority = getAuthorityLocked(account, providerName, "getBackoff");
    if(authority == null || authority.backoffTime < 0)            
            {
Pair<Long, Long> var540C13E9E156B687226421B24F2DF178_1062457914 =                 null;
                var540C13E9E156B687226421B24F2DF178_1062457914.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1062457914;
            } //End block
Pair<Long, Long> var81AABFB7829C88CA23765C85C1608D34_1226501880 =             Pair.create(authority.backoffTime, authority.backoffDelay);
            var81AABFB7829C88CA23765C85C1608D34_1226501880.addTaint(taint);
            return var81AABFB7829C88CA23765C85C1608D34_1226501880;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //AuthorityInfo authority = getAuthorityLocked(account, providerName, "getBackoff");
            //if (authority == null || authority.backoffTime < 0) {
                //return null;
            //}
            //return Pair.create(authority.backoffTime, authority.backoffDelay);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.822 -0400", hash_original_method = "470D6F06A561962AAC0558CECDD66F24", hash_generated_method = "9976C17807783B943892E7A2E53596A9")
    public void setBackoff(Account account, String providerName,
            long nextSyncTime, long nextDelay) {
        addTaint(nextDelay);
        addTaint(nextSyncTime);
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
    if(Log.isLoggable(TAG, Log.VERBOSE))        
        {
        } //End block
        boolean changed = false;
        synchronized
(mAuthorities)        {
    if(account == null || providerName == null)            
            {
for(AccountInfo accountInfo : mAccounts.values())
                {
    if(account != null && !account.equals(accountInfo.account))                    
                    continue;
for(AuthorityInfo authorityInfo : accountInfo.authorities.values())
                    {
    if(providerName != null && !providerName.equals(authorityInfo.authority))                        
                        {
                            continue;
                        } //End block
    if(authorityInfo.backoffTime != nextSyncTime
                                || authorityInfo.backoffDelay != nextDelay)                        
                        {
                            authorityInfo.backoffTime = nextSyncTime;
                            authorityInfo.backoffDelay = nextDelay;
                            changed = true;
                        } //End block
                    } //End block
                } //End block
            } //End block
            else
            {
                AuthorityInfo authority = getOrCreateAuthorityLocked(account, providerName, -1 , true);
    if(authority.backoffTime == nextSyncTime && authority.backoffDelay == nextDelay)                
                {
                    return;
                } //End block
                authority.backoffTime = nextSyncTime;
                authority.backoffDelay = nextDelay;
                changed = true;
            } //End block
        } //End block
    if(changed)        
        {
            reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.825 -0400", hash_original_method = "AFA2215C700770E680F9E8F54668F915", hash_generated_method = "56A964F56C4C4C2E14ABE80E387ED86D")
    public void clearAllBackoffs(SyncQueue syncQueue) {
        addTaint(syncQueue.getTaint());
        boolean changed = false;
        synchronized
(mAuthorities)        {
for(AccountInfo accountInfo : mAccounts.values())
            {
for(AuthorityInfo authorityInfo : accountInfo.authorities.values())
                {
    if(authorityInfo.backoffTime != NOT_IN_BACKOFF_MODE
                            || authorityInfo.backoffDelay != NOT_IN_BACKOFF_MODE)                    
                    {
    if(Log.isLoggable(TAG, Log.VERBOSE))                        
                        {
                        } //End block
                        authorityInfo.backoffTime = NOT_IN_BACKOFF_MODE;
                        authorityInfo.backoffDelay = NOT_IN_BACKOFF_MODE;
                        syncQueue.onBackoffChanged(accountInfo.account, authorityInfo.authority, 0);
                        changed = true;
                    } //End block
                } //End block
            } //End block
        } //End block
    if(changed)        
        {
            reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.826 -0400", hash_original_method = "4C9FEA1518FBFDF4D1B5258B0B2AE78D", hash_generated_method = "E795D5945A10BF212FCA23A1068206EE")
    public void setDelayUntilTime(Account account, String providerName, long delayUntil) {
        addTaint(delayUntil);
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
    if(Log.isLoggable(TAG, Log.VERBOSE))        
        {
        } //End block
        synchronized
(mAuthorities)        {
            AuthorityInfo authority = getOrCreateAuthorityLocked(
                    account, providerName, -1 , true);
    if(authority.delayUntil == delayUntil)            
            {
                return;
            } //End block
            authority.delayUntil = delayUntil;
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) {
            //Log.v(TAG, "setDelayUntil: " + account + ", provider " + providerName
                    //+ " -> delayUntil " + delayUntil);
        //}
        //synchronized (mAuthorities) {
            //AuthorityInfo authority = getOrCreateAuthorityLocked(
                    //account, providerName, -1 , true);
            //if (authority.delayUntil == delayUntil) {
                //return;
            //}
            //authority.delayUntil = delayUntil;
        //}
        //reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.826 -0400", hash_original_method = "DA0E26DF9B57177D554F116843CE820C", hash_generated_method = "AF163FCEA1942BFCCBA8D6738036E4BF")
    public long getDelayUntilTime(Account account, String providerName) {
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
        synchronized
(mAuthorities)        {
            AuthorityInfo authority = getAuthorityLocked(account, providerName, "getDelayUntil");
    if(authority == null)            
            {
                long varCFCD208495D565EF66E7DFF9F98764DA_1894392693 = (0);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_690296701 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_690296701;
            } //End block
            long varC9E36F34542776C95626C30CAB1A4A2F_226047464 = (authority.delayUntil);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1141437544 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1141437544;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //AuthorityInfo authority = getAuthorityLocked(account, providerName, "getDelayUntil");
            //if (authority == null) {
                //return 0;
            //}
            //return authority.delayUntil;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.829 -0400", hash_original_method = "DA5487F77FC92CA93809E84A1EE05946", hash_generated_method = "EFE61AA99799A2004065324FA177EC07")
    private void updateOrRemovePeriodicSync(Account account, String providerName, Bundle extras,
            long period, boolean add) {
        addTaint(add);
        addTaint(period);
        addTaint(extras.getTaint());
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
    if(period <= 0)        
        {
            period = 0;
        } //End block
    if(extras == null)        
        {
            extras = new Bundle();
        } //End block
    if(Log.isLoggable(TAG, Log.VERBOSE))        
        {
        } //End block
        synchronized
(mAuthorities)        {
            try 
            {
                AuthorityInfo authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
    if(add)                
                {
                    boolean alreadyPresent = false;
for(int i = 0, N = authority.periodicSyncs.size();i < N;i++)
                    {
                        Pair<Bundle, Long> syncInfo = authority.periodicSyncs.get(i);
                        final Bundle existingExtras = syncInfo.first;
    if(equals(existingExtras, extras))                        
                        {
    if(syncInfo.second == period)                            
                            {
                                return;
                            } //End block
                            authority.periodicSyncs.set(i, Pair.create(extras, period));
                            alreadyPresent = true;
                            break;
                        } //End block
                    } //End block
    if(!alreadyPresent)                    
                    {
                        authority.periodicSyncs.add(Pair.create(extras, period));
                        SyncStatusInfo status = getOrCreateSyncStatusLocked(authority.ident);
                        status.setPeriodicSyncTime(authority.periodicSyncs.size() - 1, 0);
                    } //End block
                } //End block
                else
                {
                    SyncStatusInfo status = mSyncStatus.get(authority.ident);
                    boolean changed = false;
                    Iterator<Pair<Bundle, Long>> iterator = authority.periodicSyncs.iterator();
                    int i = 0;
                    while
(iterator.hasNext())                    
                    {
                        Pair<Bundle, Long> syncInfo = iterator.next();
    if(equals(syncInfo.first, extras))                        
                        {
                            iterator.remove();
                            changed = true;
    if(status != null)                            
                            {
                                status.removePeriodicSyncTime(i);
                            } //End block
                        } //End block
                        else
                        {
                            i++;
                        } //End block
                    } //End block
    if(!changed)                    
                    {
                        return;
                    } //End block
                } //End block
            } //End block
            finally 
            {
                writeAccountInfoLocked();
                writeStatusLocked();
            } //End block
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.830 -0400", hash_original_method = "403A8311B76EBF44C870FFCE456B63FB", hash_generated_method = "6062AF640FD196C757199FCDEFDE4915")
    public void addPeriodicSync(Account account, String providerName, Bundle extras,
            long pollFrequency) {
        addTaint(pollFrequency);
        addTaint(extras.getTaint());
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
        updateOrRemovePeriodicSync(account, providerName, extras, pollFrequency, true );
        // ---------- Original Method ----------
        //updateOrRemovePeriodicSync(account, providerName, extras, pollFrequency, true );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.830 -0400", hash_original_method = "A5551A39E3E716437015AA42AB9CA434", hash_generated_method = "CA4ACA4A82C301A6858BF5BC46511F5B")
    public void removePeriodicSync(Account account, String providerName, Bundle extras) {
        addTaint(extras.getTaint());
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
        updateOrRemovePeriodicSync(account, providerName, extras, 0 ,
                false );
        // ---------- Original Method ----------
        //updateOrRemovePeriodicSync(account, providerName, extras, 0 ,
                //false );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.831 -0400", hash_original_method = "43BA96B870E40929E429A78D83FB8F24", hash_generated_method = "3699C89F97ABF5AC422482C1C51C193B")
    public List<PeriodicSync> getPeriodicSyncs(Account account, String providerName) {
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
        ArrayList<PeriodicSync> syncs = new ArrayList<PeriodicSync>();
        synchronized
(mAuthorities)        {
            AuthorityInfo authority = getAuthorityLocked(account, providerName, "getPeriodicSyncs");
    if(authority != null)            
            {
for(Pair<Bundle, Long> item : authority.periodicSyncs)
                {
                    syncs.add(new PeriodicSync(account, providerName, item.first, item.second));
                } //End block
            } //End block
        } //End block
List<PeriodicSync> var05D370037654F0E0BD3414B0C5C352FF_569452902 =         syncs;
        var05D370037654F0E0BD3414B0C5C352FF_569452902.addTaint(taint);
        return var05D370037654F0E0BD3414B0C5C352FF_569452902;
        // ---------- Original Method ----------
        //ArrayList<PeriodicSync> syncs = new ArrayList<PeriodicSync>();
        //synchronized (mAuthorities) {
            //AuthorityInfo authority = getAuthorityLocked(account, providerName, "getPeriodicSyncs");
            //if (authority != null) {
                //for (Pair<Bundle, Long> item : authority.periodicSyncs) {
                    //syncs.add(new PeriodicSync(account, providerName, item.first, item.second));
                //}
            //}
        //}
        //return syncs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.831 -0400", hash_original_method = "AF0CE82B663D00FD098AAFE2F6E1B437", hash_generated_method = "1C66FE6157DE9D235C7DCC0ADEE0C846")
    public void setMasterSyncAutomatically(boolean flag) {
        synchronized
(mAuthorities)        {
    if(mMasterSyncAutomatically == flag)            
            {
                return;
            } //End block
            mMasterSyncAutomatically = flag;
            writeAccountInfoLocked();
        } //End block
    if(flag)        
        {
            ContentResolver.requestSync(null, null, new Bundle());
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        mContext.sendBroadcast(SYNC_CONNECTION_SETTING_CHANGED_INTENT);
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //if (mMasterSyncAutomatically == flag) {
                //return;
            //}
            //mMasterSyncAutomatically = flag;
            //writeAccountInfoLocked();
        //}
        //if (flag) {
            //ContentResolver.requestSync(null, null, new Bundle());
        //}
        //reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        //mContext.sendBroadcast(SYNC_CONNECTION_SETTING_CHANGED_INTENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.832 -0400", hash_original_method = "6DBCD9157A2DF54805879831F88D4B77", hash_generated_method = "41AFAEA68D763C1A8C23F38BA7AA8FD6")
    public boolean getMasterSyncAutomatically() {
        synchronized
(mAuthorities)        {
            boolean varA84C78D71D9229E12FED4EAC93495260_423816300 = (mMasterSyncAutomatically);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_77030869 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_77030869;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return mMasterSyncAutomatically;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.832 -0400", hash_original_method = "AC4455129C3CF5603625E4A23A44D091", hash_generated_method = "00142143FB9D0EBECC4835FD4A761E5A")
    public AuthorityInfo getOrCreateAuthority(Account account, String authority) {
        addTaint(authority.getTaint());
        addTaint(account.getTaint());
        synchronized
(mAuthorities)        {
AuthorityInfo var6AC3C52FCAEF4011F7C800AC6EF24E9E_1111535350 =             getOrCreateAuthorityLocked(account, authority,
                    -1 ,
                    true );
            var6AC3C52FCAEF4011F7C800AC6EF24E9E_1111535350.addTaint(taint);
            return var6AC3C52FCAEF4011F7C800AC6EF24E9E_1111535350;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return getOrCreateAuthorityLocked(account, authority,
                    //-1 ,
                    //true );
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.833 -0400", hash_original_method = "BAFC16DAE21D996A746903C6AB7A1E8C", hash_generated_method = "DFCD586F2EC20F65EA44B973A4B62647")
    public void removeAuthority(Account account, String authority) {
        addTaint(authority.getTaint());
        addTaint(account.getTaint());
        synchronized
(mAuthorities)        {
            removeAuthorityLocked(account, authority, true );
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //removeAuthorityLocked(account, authority, true );
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.833 -0400", hash_original_method = "B031DD2BDA31C86F4257F62895ABA1B2", hash_generated_method = "B09FC6AA344C75E07DD4CFAEEF748BA1")
    public AuthorityInfo getAuthority(int authorityId) {
        addTaint(authorityId);
        synchronized
(mAuthorities)        {
AuthorityInfo varF9481FD836E751268DF2A1BF46E4186D_1856676441 =             mAuthorities.get(authorityId);
            varF9481FD836E751268DF2A1BF46E4186D_1856676441.addTaint(taint);
            return varF9481FD836E751268DF2A1BF46E4186D_1856676441;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return mAuthorities.get(authorityId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.834 -0400", hash_original_method = "F75815D4B05E7C78CBDEC7A3CDAC25FD", hash_generated_method = "0F9346C167436BA951EE66B9E26D468C")
    public boolean isSyncActive(Account account, String authority) {
        addTaint(authority.getTaint());
        addTaint(account.getTaint());
        synchronized
(mAuthorities)        {
for(SyncInfo syncInfo : mCurrentSyncs)
            {
                AuthorityInfo ainfo = getAuthority(syncInfo.authorityId);
    if(ainfo != null && ainfo.account.equals(account)
                        && ainfo.authority.equals(authority))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1718502066 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_665146058 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_665146058;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1890717604 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_409021010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_409021010;
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //for (SyncInfo syncInfo : mCurrentSyncs) {
                //AuthorityInfo ainfo = getAuthority(syncInfo.authorityId);
                //if (ainfo != null && ainfo.account.equals(account)
                        //&& ainfo.authority.equals(authority)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.834 -0400", hash_original_method = "42358B0BF27AF155FB408124FA39D63B", hash_generated_method = "E2F100A444CAB38B2C4A466D6CA5BC6C")
    public PendingOperation insertIntoPending(PendingOperation op) {
        addTaint(op.getTaint());
        synchronized
(mAuthorities)        {
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
            AuthorityInfo authority = getOrCreateAuthorityLocked(op.account,
                    op.authority,
                    -1 ,
                    true );
    if(authority == null)            
            {
PendingOperation var540C13E9E156B687226421B24F2DF178_435777836 =                 null;
                var540C13E9E156B687226421B24F2DF178_435777836.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_435777836;
            } //End block
            op = new PendingOperation(op);
            op.authorityId = authority.ident;
            mPendingOperations.add(op);
            appendPendingOperationLocked(op);
            SyncStatusInfo status = getOrCreateSyncStatusLocked(authority.ident);
            status.pending = true;
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
PendingOperation var85CF662FCFA548E032A48B39B921372E_1750361327 =         op;
        var85CF662FCFA548E032A48B39B921372E_1750361327.addTaint(taint);
        return var85CF662FCFA548E032A48B39B921372E_1750361327;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.836 -0400", hash_original_method = "50B189E2AFDD83FCD044E18708DDFA85", hash_generated_method = "C3D38F0CC0072DFDEDEAF7EF68411496")
    public boolean deleteFromPending(PendingOperation op) {
        addTaint(op.getTaint());
        boolean res = false;
        synchronized
(mAuthorities)        {
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
    if(mPendingOperations.remove(op))            
            {
    if(mPendingOperations.size() == 0
                        || mNumPendingFinished >= PENDING_FINISH_TO_WRITE)                
                {
                    writePendingOperationsLocked();
                    mNumPendingFinished = 0;
                } //End block
                else
                {
                    mNumPendingFinished++;
                } //End block
                AuthorityInfo authority = getAuthorityLocked(op.account, op.authority,
                        "deleteFromPending");
    if(authority != null)                
                {
    if(Log.isLoggable(TAG, Log.VERBOSE)){ }                    final int N = mPendingOperations.size();
                    boolean morePending = false;
for(int i=0;i<N;i++)
                    {
                        PendingOperation cur = mPendingOperations.get(i);
    if(cur.account.equals(op.account)
                                && cur.authority.equals(op.authority))                        
                        {
                            morePending = true;
                            break;
                        } //End block
                    } //End block
    if(!morePending)                    
                    {
    if(Log.isLoggable(TAG, Log.VERBOSE)){ }                        SyncStatusInfo status = getOrCreateSyncStatusLocked(authority.ident);
                        status.pending = false;
                    } //End block
                } //End block
                res = true;
            } //End block
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        boolean var9B207167E5381C47682C6B4F58A623FB_568996669 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_627682594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_627682594;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.837 -0400", hash_original_method = "B0FBF76821996DB4DA7D3758DC73EE90", hash_generated_method = "7DBA4B06DD3B050317D3B6C86A7E3F95")
    public int clearPending() {
        int num;
        synchronized
(mAuthorities)        {
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
            num = mPendingOperations.size();
            mPendingOperations.clear();
            final int N = mSyncStatus.size();
for(int i=0;i<N;i++)
            {
                mSyncStatus.valueAt(i).pending = false;
            } //End block
            writePendingOperationsLocked();
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        int var0FC3CFBC27E91EA60A787DE13DAE3E3C_739712232 = (num);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457617509 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457617509;
        // ---------- Original Method ----------
        //int num;
        //synchronized (mAuthorities) {
            //if (Log.isLoggable(TAG, Log.VERBOSE)) {
                //Log.v(TAG, "clearPending");
            //}
            //num = mPendingOperations.size();
            //mPendingOperations.clear();
            //final int N = mSyncStatus.size();
            //for (int i=0; i<N; i++) {
                //mSyncStatus.valueAt(i).pending = false;
            //}
            //writePendingOperationsLocked();
        //}
        //reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        //return num;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.838 -0400", hash_original_method = "C927FD207EDF022EE536945570AA8499", hash_generated_method = "F8DD238B2B3C008C15C98612C377951D")
    public ArrayList<PendingOperation> getPendingOperations() {
        synchronized
(mAuthorities)        {
ArrayList<PendingOperation> varCE48EACD2EA0CB59C3F5D218B3C13801_331825039 =             new ArrayList<PendingOperation>(mPendingOperations);
            varCE48EACD2EA0CB59C3F5D218B3C13801_331825039.addTaint(taint);
            return varCE48EACD2EA0CB59C3F5D218B3C13801_331825039;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return new ArrayList<PendingOperation>(mPendingOperations);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.839 -0400", hash_original_method = "CC9059641F127440F6B10F04341F5D1E", hash_generated_method = "23925C92C941307A56C3638EC3526691")
    public int getPendingOperationCount() {
        synchronized
(mAuthorities)        {
            int var4086A8879090E1B21F883C89EB817BB5_1697205428 = (mPendingOperations.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172828406 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172828406;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return mPendingOperations.size();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.841 -0400", hash_original_method = "38BC76D95CA0A954EB857B91A285A324", hash_generated_method = "A9296E2E3FDDBC984FDE2741BB289BF9")
    public void doDatabaseCleanup(Account[] accounts) {
        addTaint(accounts[0].getTaint());
        synchronized
(mAuthorities)        {
    if(Log.isLoggable(TAG, Log.VERBOSE)){ }            SparseArray<AuthorityInfo> removing = new SparseArray<AuthorityInfo>();
            Iterator<AccountInfo> accIt = mAccounts.values().iterator();
            while
(accIt.hasNext())            
            {
                AccountInfo acc = accIt.next();
    if(!ArrayUtils.contains(accounts, acc.account))                
                {
    if(Log.isLoggable(TAG, Log.VERBOSE))                    
                    {
                    } //End block
for(AuthorityInfo auth : acc.authorities.values())
                    {
                        removing.put(auth.ident, auth);
                    } //End block
                    accIt.remove();
                } //End block
            } //End block
            int i = removing.size();
    if(i > 0)            
            {
                while
(i > 0)                
                {
                    i--;
                    int ident = removing.keyAt(i);
                    mAuthorities.remove(ident);
                    int j = mSyncStatus.size();
                    while
(j > 0)                    
                    {
                        j--;
    if(mSyncStatus.keyAt(j) == ident)                        
                        {
                            mSyncStatus.remove(mSyncStatus.keyAt(j));
                        } //End block
                    } //End block
                    j = mSyncHistory.size();
                    while
(j > 0)                    
                    {
                        j--;
    if(mSyncHistory.get(j).authorityId == ident)                        
                        {
                            mSyncHistory.remove(j);
                        } //End block
                    } //End block
                } //End block
                writeAccountInfoLocked();
                writeStatusLocked();
                writePendingOperationsLocked();
                writeStatisticsLocked();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.842 -0400", hash_original_method = "1CDF6C9A1F9F2098201F4D7433D51EE7", hash_generated_method = "5ED4301D0B3070B7E60E19A594A7B0E5")
    public SyncInfo addActiveSync(SyncManager.ActiveSyncContext activeSyncContext) {
        addTaint(activeSyncContext.getTaint());
        SyncInfo syncInfo;
        synchronized
(mAuthorities)        {
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
            AuthorityInfo authority = getOrCreateAuthorityLocked(
                    activeSyncContext.mSyncOperation.account,
                    activeSyncContext.mSyncOperation.authority,
                    -1 ,
                    true );
            syncInfo = new SyncInfo(authority.ident,
                    authority.account, authority.authority,
                    activeSyncContext.mStartTime);
            mCurrentSyncs.add(syncInfo);
        } //End block
        reportActiveChange();
SyncInfo var8178E3AEFCD8B7A2FBAA2724D00107FA_1437548399 =         syncInfo;
        var8178E3AEFCD8B7A2FBAA2724D00107FA_1437548399.addTaint(taint);
        return var8178E3AEFCD8B7A2FBAA2724D00107FA_1437548399;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.842 -0400", hash_original_method = "2B31DF94CF8024B200C12FFD3895E8BE", hash_generated_method = "F4BD4F5CED1C713C1F285467D2591CF6")
    public void removeActiveSync(SyncInfo syncInfo) {
        addTaint(syncInfo.getTaint());
        synchronized
(mAuthorities)        {
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
            mCurrentSyncs.remove(syncInfo);
        } //End block
        reportActiveChange();
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //if (Log.isLoggable(TAG, Log.VERBOSE)) {
                //Log.v(TAG, "removeActiveSync: account="
                        //+ syncInfo.account + " auth=" + syncInfo.authority);
            //}
            //mCurrentSyncs.remove(syncInfo);
        //}
        //reportActiveChange();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.843 -0400", hash_original_method = "5624025FD66E34CEC2F994FDB502F76B", hash_generated_method = "4CF4CD5E23AE17353DE22949D91BFDC6")
    public void reportActiveChange() {
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_ACTIVE);
        // ---------- Original Method ----------
        //reportChange(ContentResolver.SYNC_OBSERVER_TYPE_ACTIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.844 -0400", hash_original_method = "7B7D2D5D3E7E0D062624D3006A76AABE", hash_generated_method = "C98ADA677E9E5AF8582D6110D5C9BB28")
    public long insertStartSyncEvent(Account accountName, String authorityName,
            long now, int source) {
        addTaint(source);
        addTaint(now);
        addTaint(authorityName.getTaint());
        addTaint(accountName.getTaint());
        long id;
        synchronized
(mAuthorities)        {
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
            AuthorityInfo authority = getAuthorityLocked(accountName, authorityName,
                    "insertStartSyncEvent");
    if(authority == null)            
            {
                long var6BB61E3B7BCE0931DA574D19D1D82C88_1546724888 = (-1);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1369064981 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1369064981;
            } //End block
            SyncHistoryItem item = new SyncHistoryItem();
            item.authorityId = authority.ident;
            item.historyId = mNextHistoryId++;
    if(mNextHistoryId < 0)            
            mNextHistoryId = 0;
            item.eventTime = now;
            item.source = source;
            item.event = EVENT_START;
            mSyncHistory.add(0, item);
            while
(mSyncHistory.size() > MAX_HISTORY)            
            {
                mSyncHistory.remove(mSyncHistory.size()-1);
            } //End block
            id = item.historyId;
    if(Log.isLoggable(TAG, Log.VERBOSE)){ }
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_STATUS);
        long varB80BB7740288FDA1F201890375A60C8F_1571538650 = (id);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1448821410 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1448821410;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static boolean equals(Bundle b1, Bundle b2) {
        if (b1.size() != b2.size()) {
            return false;
        }
        if (b1.isEmpty()) {
            return true;
        }
        for (String key : b1.keySet()) {
            if (!b2.containsKey(key)) {
                return false;
            }
            if (!b1.get(key).equals(b2.get(key))) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.852 -0400", hash_original_method = "50B7DBCE95202763C50A27A5F5D2A2F4", hash_generated_method = "605CBE7D6F965F31EEBDD5C42C9307D5")
    public void stopSyncEvent(long historyId, long elapsedTime, String resultMessage,
            long downstreamActivity, long upstreamActivity) {
        addTaint(upstreamActivity);
        addTaint(downstreamActivity);
        addTaint(resultMessage.getTaint());
        addTaint(elapsedTime);
        addTaint(historyId);
        synchronized
(mAuthorities)        {
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
            SyncHistoryItem item = null;
            int i = mSyncHistory.size();
            while
(i > 0)            
            {
                i--;
                item = mSyncHistory.get(i);
    if(item.historyId == historyId)                
                {
                    break;
                } //End block
                item = null;
            } //End block
    if(item == null)            
            {
                return;
            } //End block
            item.elapsedTime = elapsedTime;
            item.event = EVENT_STOP;
            item.mesg = resultMessage;
            item.downstreamActivity = downstreamActivity;
            item.upstreamActivity = upstreamActivity;
            SyncStatusInfo status = getOrCreateSyncStatusLocked(item.authorityId);
            status.numSyncs++;
            status.totalElapsedTime += elapsedTime;
switch(item.source){
            case SOURCE_LOCAL:
            status.numSourceLocal++;
            break;
            case SOURCE_POLL:
            status.numSourcePoll++;
            break;
            case SOURCE_USER:
            status.numSourceUser++;
            break;
            case SOURCE_SERVER:
            status.numSourceServer++;
            break;
            case SOURCE_PERIODIC:
            status.numSourcePeriodic++;
            break;
}            boolean writeStatisticsNow = false;
            int day = getCurrentDayLocked();
    if(mDayStats[0] == null)            
            {
                mDayStats[0] = new DayStats(day);
            } //End block
            else
    if(day != mDayStats[0].day)            
            {
                System.arraycopy(mDayStats, 0, mDayStats, 1, mDayStats.length-1);
                mDayStats[0] = new DayStats(day);
                writeStatisticsNow = true;
            } //End block
            else
    if(mDayStats[0] == null)            
            {
            } //End block
            final DayStats ds = mDayStats[0];
            final long lastSyncTime = (item.eventTime + elapsedTime);
            boolean writeStatusNow = false;
    if(MESG_SUCCESS.equals(resultMessage))            
            {
    if(status.lastSuccessTime == 0 || status.lastFailureTime != 0)                
                {
                    writeStatusNow = true;
                } //End block
                status.lastSuccessTime = lastSyncTime;
                status.lastSuccessSource = item.source;
                status.lastFailureTime = 0;
                status.lastFailureSource = -1;
                status.lastFailureMesg = null;
                status.initialFailureTime = 0;
                ds.successCount++;
                ds.successTime += elapsedTime;
            } //End block
            else
    if(!MESG_CANCELED.equals(resultMessage))            
            {
    if(status.lastFailureTime == 0)                
                {
                    writeStatusNow = true;
                } //End block
                status.lastFailureTime = lastSyncTime;
                status.lastFailureSource = item.source;
                status.lastFailureMesg = resultMessage;
    if(status.initialFailureTime == 0)                
                {
                    status.initialFailureTime = lastSyncTime;
                } //End block
                ds.failureCount++;
                ds.failureTime += elapsedTime;
            } //End block
    if(writeStatusNow)            
            {
                writeStatusLocked();
            } //End block
            else
    if(!hasMessages(MSG_WRITE_STATUS))            
            {
                sendMessageDelayed(obtainMessage(MSG_WRITE_STATUS),
                        WRITE_STATUS_DELAY);
            } //End block
    if(writeStatisticsNow)            
            {
                writeStatisticsLocked();
            } //End block
            else
    if(!hasMessages(MSG_WRITE_STATISTICS))            
            {
                sendMessageDelayed(obtainMessage(MSG_WRITE_STATISTICS),
                        WRITE_STATISTICS_DELAY);
            } //End block
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_STATUS);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.854 -0400", hash_original_method = "F85BE50FB140D59BBA80C586F09539D3", hash_generated_method = "95FFE8FF46129ABAEF872226A3FEED4F")
    public List<SyncInfo> getCurrentSyncs() {
        synchronized
(mAuthorities)        {
List<SyncInfo> var98D9832D6E7726FBA7C65251F12F5321_1134166696 =             new ArrayList<SyncInfo>(mCurrentSyncs);
            var98D9832D6E7726FBA7C65251F12F5321_1134166696.addTaint(taint);
            return var98D9832D6E7726FBA7C65251F12F5321_1134166696;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return new ArrayList<SyncInfo>(mCurrentSyncs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.854 -0400", hash_original_method = "337F005F5350F3BD5177B0B27AD2E944", hash_generated_method = "762381CFA007455D9E072BA55A7C146D")
    public ArrayList<SyncStatusInfo> getSyncStatus() {
        synchronized
(mAuthorities)        {
            final int N = mSyncStatus.size();
            ArrayList<SyncStatusInfo> ops = new ArrayList<SyncStatusInfo>(N);
for(int i=0;i<N;i++)
            {
                ops.add(mSyncStatus.valueAt(i));
            } //End block
ArrayList<SyncStatusInfo> var730D3CE922A7317E5C5959581BA7A4E3_347595562 =             ops;
            var730D3CE922A7317E5C5959581BA7A4E3_347595562.addTaint(taint);
            return var730D3CE922A7317E5C5959581BA7A4E3_347595562;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //final int N = mSyncStatus.size();
            //ArrayList<SyncStatusInfo> ops = new ArrayList<SyncStatusInfo>(N);
            //for (int i=0; i<N; i++) {
                //ops.add(mSyncStatus.valueAt(i));
            //}
            //return ops;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.855 -0400", hash_original_method = "AEA28BD7AFFA3D47C607E69E1C170D48", hash_generated_method = "B7CBFB889BF1CCC12A6BE769F73A0356")
    public ArrayList<AuthorityInfo> getAuthorities() {
        synchronized
(mAuthorities)        {
            final int N = mAuthorities.size();
            ArrayList<AuthorityInfo> infos = new ArrayList<AuthorityInfo>(N);
for(int i=0;i<N;i++)
            {
                infos.add(mAuthorities.valueAt(i));
            } //End block
ArrayList<AuthorityInfo> var856335B33F20D10100490622F4E3620B_1270975077 =             infos;
            var856335B33F20D10100490622F4E3620B_1270975077.addTaint(taint);
            return var856335B33F20D10100490622F4E3620B_1270975077;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //final int N = mAuthorities.size();
            //ArrayList<AuthorityInfo> infos = new ArrayList<AuthorityInfo>(N);
            //for (int i=0; i<N; i++) {
                //infos.add(mAuthorities.valueAt(i));
            //}
            //return infos;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.855 -0400", hash_original_method = "0CFE1C56DFD3FFD9F777D7B0D6FDA886", hash_generated_method = "849AB79AAEB5817F6CBAB7AED5FE517D")
    public SyncStatusInfo getStatusByAccountAndAuthority(Account account, String authority) {
        addTaint(authority.getTaint());
        addTaint(account.getTaint());
    if(account == null || authority == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_826658041 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_826658041.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_826658041;
        } //End block
        synchronized
(mAuthorities)        {
            final int N = mSyncStatus.size();
for(int i=0;i<N;i++)
            {
                SyncStatusInfo cur = mSyncStatus.valueAt(i);
                AuthorityInfo ainfo = mAuthorities.get(cur.authorityId);
    if(ainfo != null && ainfo.authority.equals(authority) &&
                    account.equals(ainfo.account))                
                {
SyncStatusInfo var75E9B120741256879E03910410DF2A75_40469887 =                     cur;
                    var75E9B120741256879E03910410DF2A75_40469887.addTaint(taint);
                    return var75E9B120741256879E03910410DF2A75_40469887;
                } //End block
            } //End block
SyncStatusInfo var540C13E9E156B687226421B24F2DF178_1577666631 =             null;
            var540C13E9E156B687226421B24F2DF178_1577666631.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1577666631;
        } //End block
        // ---------- Original Method ----------
        //if (account == null || authority == null) {
          //throw new IllegalArgumentException();
        //}
        //synchronized (mAuthorities) {
            //final int N = mSyncStatus.size();
            //for (int i=0; i<N; i++) {
                //SyncStatusInfo cur = mSyncStatus.valueAt(i);
                //AuthorityInfo ainfo = mAuthorities.get(cur.authorityId);
                //if (ainfo != null && ainfo.authority.equals(authority) &&
                    //account.equals(ainfo.account)) {
                  //return cur;
                //}
            //}
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.856 -0400", hash_original_method = "11629709D08EF9D9A0440D25565E7A8F", hash_generated_method = "065DA1266BA673F34F4893CD528BC2FC")
    public boolean isSyncPending(Account account, String authority) {
        addTaint(authority.getTaint());
        addTaint(account.getTaint());
        synchronized
(mAuthorities)        {
            final int N = mSyncStatus.size();
for(int i=0;i<N;i++)
            {
                SyncStatusInfo cur = mSyncStatus.valueAt(i);
                AuthorityInfo ainfo = mAuthorities.get(cur.authorityId);
    if(ainfo == null)                
                {
                    continue;
                } //End block
    if(account != null && !ainfo.account.equals(account))                
                {
                    continue;
                } //End block
    if(ainfo.authority.equals(authority) && cur.pending)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_262634159 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_78063583 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_78063583;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_893829902 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1909266525 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1909266525;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //final int N = mSyncStatus.size();
            //for (int i=0; i<N; i++) {
                //SyncStatusInfo cur = mSyncStatus.valueAt(i);
                //AuthorityInfo ainfo = mAuthorities.get(cur.authorityId);
                //if (ainfo == null) {
                    //continue;
                //}
                //if (account != null && !ainfo.account.equals(account)) {
                    //continue;
                //}
                //if (ainfo.authority.equals(authority) && cur.pending) {
                    //return true;
                //}
            //}
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.857 -0400", hash_original_method = "B27CDDFFB9BAFF7BFEA0365E872FDD46", hash_generated_method = "D26417177786B5DE6958E3755580C819")
    public ArrayList<SyncHistoryItem> getSyncHistory() {
        synchronized
(mAuthorities)        {
            final int N = mSyncHistory.size();
            ArrayList<SyncHistoryItem> items = new ArrayList<SyncHistoryItem>(N);
for(int i=0;i<N;i++)
            {
                items.add(mSyncHistory.get(i));
            } //End block
ArrayList<SyncHistoryItem> varDD8CA3856F2D10CFF8B78751200A576D_865272109 =             items;
            varDD8CA3856F2D10CFF8B78751200A576D_865272109.addTaint(taint);
            return varDD8CA3856F2D10CFF8B78751200A576D_865272109;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //final int N = mSyncHistory.size();
            //ArrayList<SyncHistoryItem> items = new ArrayList<SyncHistoryItem>(N);
            //for (int i=0; i<N; i++) {
                //items.add(mSyncHistory.get(i));
            //}
            //return items;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.857 -0400", hash_original_method = "3EC13B6BE37070366668DCFEFC381135", hash_generated_method = "8B0AC479C28D169B5E7F1EACC86CD472")
    public DayStats[] getDayStatistics() {
        synchronized
(mAuthorities)        {
            DayStats[] ds = new DayStats[mDayStats.length];
            System.arraycopy(mDayStats, 0, ds, 0, ds.length);
DayStats[] var326AB3082797E11390DC7F191D96A430_1366036538 =             ds;
            var326AB3082797E11390DC7F191D96A430_1366036538.addTaint(taint);
            return var326AB3082797E11390DC7F191D96A430_1366036538;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //DayStats[] ds = new DayStats[mDayStats.length];
            //System.arraycopy(mDayStats, 0, ds, 0, ds.length);
            //return ds;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.858 -0400", hash_original_method = "CFA8C7FA80DDF752958B19CD5427CAD8", hash_generated_method = "8168050ABA5687ED9E31C20DF72DF843")
    public long getInitialSyncFailureTime() {
        synchronized
(mAuthorities)        {
    if(!mMasterSyncAutomatically)            
            {
                long varCFCD208495D565EF66E7DFF9F98764DA_85158469 = (0);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1706239775 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1706239775;
            } //End block
            long oldest = 0;
            int i = mSyncStatus.size();
            while
(i > 0)            
            {
                i--;
                SyncStatusInfo stats = mSyncStatus.valueAt(i);
                AuthorityInfo authority = mAuthorities.get(stats.authorityId);
    if(authority != null && authority.enabled)                
                {
    if(oldest == 0 || stats.initialFailureTime < oldest)                    
                    {
                        oldest = stats.initialFailureTime;
                    } //End block
                } //End block
            } //End block
            long varF14B514E6CA0A666CCBF8B7EC839DFB9_1098675603 = (oldest);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1374265524 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1374265524;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //if (!mMasterSyncAutomatically) {
                //return 0;
            //}
            //long oldest = 0;
            //int i = mSyncStatus.size();
            //while (i > 0) {
                //i--;
                //SyncStatusInfo stats = mSyncStatus.valueAt(i);
                //AuthorityInfo authority = mAuthorities.get(stats.authorityId);
                //if (authority != null && authority.enabled) {
                    //if (oldest == 0 || stats.initialFailureTime < oldest) {
                        //oldest = stats.initialFailureTime;
                    //}
                //}
            //}
            //return oldest;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.859 -0400", hash_original_method = "C1CC7B80E3CCED2D49B24E4AC052D091", hash_generated_method = "344902F5DF893D74ED718B40D2DBA475")
    private int getCurrentDayLocked() {
        mCal.setTimeInMillis(System.currentTimeMillis());
        final int dayOfYear = mCal.get(Calendar.DAY_OF_YEAR);
    if(mYear != mCal.get(Calendar.YEAR))        
        {
            mYear = mCal.get(Calendar.YEAR);
            mCal.clear();
            mCal.set(Calendar.YEAR, mYear);
            mYearInDays = (int)(mCal.getTimeInMillis()/86400000);
        } //End block
        int var8A768CFB2359892DD7633C574D0789D3_1176110298 = (dayOfYear + mYearInDays);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345317363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345317363;
        // ---------- Original Method ----------
        //mCal.setTimeInMillis(System.currentTimeMillis());
        //final int dayOfYear = mCal.get(Calendar.DAY_OF_YEAR);
        //if (mYear != mCal.get(Calendar.YEAR)) {
            //mYear = mCal.get(Calendar.YEAR);
            //mCal.clear();
            //mCal.set(Calendar.YEAR, mYear);
            //mYearInDays = (int)(mCal.getTimeInMillis()/86400000);
        //}
        //return dayOfYear + mYearInDays;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.860 -0400", hash_original_method = "6C953B58E1758760E6819A681B8F6E8F", hash_generated_method = "9ACEF783DBE2A81BBA572588269EC69E")
    private AuthorityInfo getAuthorityLocked(Account accountName, String authorityName,
            String tag) {
        addTaint(tag.getTaint());
        addTaint(authorityName.getTaint());
        addTaint(accountName.getTaint());
        AccountInfo account = mAccounts.get(accountName);
    if(account == null)        
        {
    if(tag != null)            
            {
    if(Log.isLoggable(TAG, Log.VERBOSE))                
                {
                } //End block
            } //End block
AuthorityInfo var540C13E9E156B687226421B24F2DF178_55063084 =             null;
            var540C13E9E156B687226421B24F2DF178_55063084.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_55063084;
        } //End block
        AuthorityInfo authority = account.authorities.get(authorityName);
    if(authority == null)        
        {
    if(tag != null)            
            {
    if(Log.isLoggable(TAG, Log.VERBOSE))                
                {
                } //End block
            } //End block
AuthorityInfo var540C13E9E156B687226421B24F2DF178_20396923 =             null;
            var540C13E9E156B687226421B24F2DF178_20396923.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_20396923;
        } //End block
AuthorityInfo var9A4A00E403B4898E9807F68E9EBE5A8B_1041158291 =         authority;
        var9A4A00E403B4898E9807F68E9EBE5A8B_1041158291.addTaint(taint);
        return var9A4A00E403B4898E9807F68E9EBE5A8B_1041158291;
        // ---------- Original Method ----------
        //AccountInfo account = mAccounts.get(accountName);
        //if (account == null) {
            //if (tag != null) {
                //if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    //Log.v(TAG, tag + ": unknown account " + accountName);
                //}
            //}
            //return null;
        //}
        //AuthorityInfo authority = account.authorities.get(authorityName);
        //if (authority == null) {
            //if (tag != null) {
                //if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    //Log.v(TAG, tag + ": unknown authority " + authorityName);
                //}
            //}
            //return null;
        //}
        //return authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.862 -0400", hash_original_method = "8765A57952C80F1A5760550FE9E929E6", hash_generated_method = "9CCE228E4CFD9FD18DBD7D449CE48A7B")
    private AuthorityInfo getOrCreateAuthorityLocked(Account accountName,
            String authorityName, int ident, boolean doWrite) {
        addTaint(doWrite);
        addTaint(ident);
        addTaint(authorityName.getTaint());
        addTaint(accountName.getTaint());
        AccountInfo account = mAccounts.get(accountName);
    if(account == null)        
        {
            account = new AccountInfo(accountName);
            mAccounts.put(accountName, account);
        } //End block
        AuthorityInfo authority = account.authorities.get(authorityName);
    if(authority == null)        
        {
    if(ident < 0)            
            {
                ident = mNextAuthorityId;
                mNextAuthorityId++;
                doWrite = true;
            } //End block
    if(Log.isLoggable(TAG, Log.VERBOSE))            
            {
            } //End block
            authority = new AuthorityInfo(accountName, authorityName, ident);
            account.authorities.put(authorityName, authority);
            mAuthorities.put(ident, authority);
    if(doWrite)            
            {
                writeAccountInfoLocked();
            } //End block
        } //End block
AuthorityInfo var9A4A00E403B4898E9807F68E9EBE5A8B_754549770 =         authority;
        var9A4A00E403B4898E9807F68E9EBE5A8B_754549770.addTaint(taint);
        return var9A4A00E403B4898E9807F68E9EBE5A8B_754549770;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.863 -0400", hash_original_method = "654490315D677BE62FC7AFF81C0D5F85", hash_generated_method = "D2D95D52FFD9737D710FAB6717B45968")
    private void removeAuthorityLocked(Account account, String authorityName, boolean doWrite) {
        addTaint(doWrite);
        addTaint(authorityName.getTaint());
        addTaint(account.getTaint());
        AccountInfo accountInfo = mAccounts.get(account);
    if(accountInfo != null)        
        {
            final AuthorityInfo authorityInfo = accountInfo.authorities.remove(authorityName);
    if(authorityInfo != null)            
            {
                mAuthorities.remove(authorityInfo.ident);
    if(doWrite)                
                {
                    writeAccountInfoLocked();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //AccountInfo accountInfo = mAccounts.get(account);
        //if (accountInfo != null) {
            //final AuthorityInfo authorityInfo = accountInfo.authorities.remove(authorityName);
            //if (authorityInfo != null) {
                //mAuthorities.remove(authorityInfo.ident);
                //if (doWrite) {
                    //writeAccountInfoLocked();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.864 -0400", hash_original_method = "8F9F327D2E93831D0CA3DA1F9594BFF4", hash_generated_method = "A007CA361807D5B605894E3CA626E59B")
    public SyncStatusInfo getOrCreateSyncStatus(AuthorityInfo authority) {
        addTaint(authority.getTaint());
        synchronized
(mAuthorities)        {
SyncStatusInfo varDAD8554A159528D7292177B77B4E7D71_269210088 =             getOrCreateSyncStatusLocked(authority.ident);
            varDAD8554A159528D7292177B77B4E7D71_269210088.addTaint(taint);
            return varDAD8554A159528D7292177B77B4E7D71_269210088;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return getOrCreateSyncStatusLocked(authority.ident);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.865 -0400", hash_original_method = "1C22F2C698CD79AA856218BCBCBEF0F7", hash_generated_method = "890CD67D3685ADB21D3571D2FC6D5A2B")
    private SyncStatusInfo getOrCreateSyncStatusLocked(int authorityId) {
        addTaint(authorityId);
        SyncStatusInfo status = mSyncStatus.get(authorityId);
    if(status == null)        
        {
            status = new SyncStatusInfo(authorityId);
            mSyncStatus.put(authorityId, status);
        } //End block
SyncStatusInfo var62D3D5D442782C1992154E821A40FA75_18394594 =         status;
        var62D3D5D442782C1992154E821A40FA75_18394594.addTaint(taint);
        return var62D3D5D442782C1992154E821A40FA75_18394594;
        // ---------- Original Method ----------
        //SyncStatusInfo status = mSyncStatus.get(authorityId);
        //if (status == null) {
            //status = new SyncStatusInfo(authorityId);
            //mSyncStatus.put(authorityId, status);
        //}
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.865 -0400", hash_original_method = "EC72A1F81B7D887353DF2FA5F052A597", hash_generated_method = "CECD7D768CEAD8027E15782B2EB4A810")
    public void writeAllState() {
        synchronized
(mAuthorities)        {
    if(mNumPendingFinished > 0)            
            {
                writePendingOperationsLocked();
            } //End block
            writeStatusLocked();
            writeStatisticsLocked();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //if (mNumPendingFinished > 0) {
                //writePendingOperationsLocked();
            //}
            //writeStatusLocked();
            //writeStatisticsLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.866 -0400", hash_original_method = "E278B7FDC712595C2D25226C12B41BCD", hash_generated_method = "1E6BFD699FAE548F7E57430D3002414F")
    public void clearAndReadState() {
        synchronized
(mAuthorities)        {
            mAuthorities.clear();
            mAccounts.clear();
            mPendingOperations.clear();
            mSyncStatus.clear();
            mSyncHistory.clear();
            readAccountInfoLocked();
            readStatusLocked();
            readPendingOperationsLocked();
            readStatisticsLocked();
            readAndDeleteLegacyAccountInfoLocked();
            writeAccountInfoLocked();
            writeStatusLocked();
            writePendingOperationsLocked();
            writeStatisticsLocked();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //mAuthorities.clear();
            //mAccounts.clear();
            //mPendingOperations.clear();
            //mSyncStatus.clear();
            //mSyncHistory.clear();
            //readAccountInfoLocked();
            //readStatusLocked();
            //readPendingOperationsLocked();
            //readStatisticsLocked();
            //readAndDeleteLegacyAccountInfoLocked();
            //writeAccountInfoLocked();
            //writeStatusLocked();
            //writePendingOperationsLocked();
            //writeStatisticsLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.876 -0400", hash_original_method = "9E90C2E17AAFB2A4F084659253144E64", hash_generated_method = "13ED21170003ECBFDB212434ECAF58ED")
    private void readAccountInfoLocked() {
        int highestAuthorityId = -1;
        FileInputStream fis = null;
        try 
        {
            fis = mAccountInfoFile.openRead();
    if(DEBUG_FILE){ }            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(fis, null);
            int eventType = parser.getEventType();
            while
(eventType != XmlPullParser.START_TAG)            
            {
                eventType = parser.next();
            } //End block
            String tagName = parser.getName();
    if("accounts".equals(tagName))            
            {
                String listen = parser.getAttributeValue(
                        null, "listen-for-tickles");
                String versionString = parser.getAttributeValue(null, "version");
                int version;
                try 
                {
                    version = (versionString == null) ? 0 : Integer.parseInt(versionString);
                } //End block
                catch (NumberFormatException e)
                {
                    version = 0;
                } //End block
                String nextIdString = parser.getAttributeValue(null, "nextAuthorityId");
                try 
                {
                    int id = (nextIdString == null) ? 0 : Integer.parseInt(nextIdString);
                    mNextAuthorityId = Math.max(mNextAuthorityId, id);
                } //End block
                catch (NumberFormatException e)
                {
                } //End block
                mMasterSyncAutomatically = listen == null || Boolean.parseBoolean(listen);
                eventType = parser.next();
                AuthorityInfo authority = null;
                Pair<Bundle, Long> periodicSync = null;
                do {
                    {
    if(eventType == XmlPullParser.START_TAG)                        
                        {
                            tagName = parser.getName();
    if(parser.getDepth() == 2)                            
                            {
    if("authority".equals(tagName))                                
                                {
                                    authority = parseAuthority(parser, version);
                                    periodicSync = null;
    if(authority.ident > highestAuthorityId)                                    
                                    {
                                        highestAuthorityId = authority.ident;
                                    } //End block
                                } //End block
                            } //End block
                            else
    if(parser.getDepth() == 3)                            
                            {
    if("periodicSync".equals(tagName) && authority != null)                                
                                {
                                    periodicSync = parsePeriodicSync(parser, authority);
                                } //End block
                            } //End block
                            else
    if(parser.getDepth() == 4 && periodicSync != null)                            
                            {
    if("extra".equals(tagName))                                
                                {
                                    parseExtra(parser, periodicSync);
                                } //End block
                            } //End block
                        } //End block
                        eventType = parser.next();
                    } //End block
} while (eventType != XmlPullParser.END_DOCUMENT);
            } //End block
        } //End block
        catch (XmlPullParserException e)
        {
            return;
        } //End block
        catch (java.io.IOException e)
        {
    if(fis == null){ }            return;
        } //End block
        finally 
        {
            mNextAuthorityId = Math.max(highestAuthorityId + 1, mNextAuthorityId);
    if(fis != null)            
            {
                try 
                {
                    fis.close();
                } //End block
                catch (java.io.IOException e1)
                {
                } //End block
            } //End block
        } //End block
        maybeMigrateSettingsForRenamedAuthorities();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.878 -0400", hash_original_method = "1F0CD4338AAE9E719690DF5E0BB493ED", hash_generated_method = "508E8C836A734818A12B33BB1339D9BE")
    private boolean maybeMigrateSettingsForRenamedAuthorities() {
        boolean writeNeeded = false;
        ArrayList<AuthorityInfo> authoritiesToRemove = new ArrayList<AuthorityInfo>();
        final int N = mAuthorities.size();
for(int i=0;i<N;i++)
        {
            AuthorityInfo authority = mAuthorities.valueAt(i);
            final String newAuthorityName = sAuthorityRenames.get(authority.authority);
    if(newAuthorityName == null)            
            {
                continue;
            } //End block
            authoritiesToRemove.add(authority);
    if(!authority.enabled)            
            {
                continue;
            } //End block
    if(getAuthorityLocked(authority.account, newAuthorityName, "cleanup") != null)            
            {
                continue;
            } //End block
            AuthorityInfo newAuthority = getOrCreateAuthorityLocked(authority.account,
                    newAuthorityName, -1 , false );
            newAuthority.enabled = true;
            writeNeeded = true;
        } //End block
for(AuthorityInfo authorityInfo : authoritiesToRemove)
        {
            removeAuthorityLocked(authorityInfo.account, authorityInfo.authority,
                    false );
            writeNeeded = true;
        } //End block
        boolean var3A7D6A5A8328B84FDE74EE614F30B047_837991309 = (writeNeeded);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_585774494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_585774494;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.880 -0400", hash_original_method = "39CA1CD415012CC0A4B70AAED3727A93", hash_generated_method = "4E92A5516D294B81A5C09FF61CE4CD55")
    private AuthorityInfo parseAuthority(XmlPullParser parser, int version) {
        addTaint(version);
        addTaint(parser.getTaint());
        AuthorityInfo authority = null;
        int id = -1;
        try 
        {
            id = Integer.parseInt(parser.getAttributeValue(
                    null, "id"));
        } //End block
        catch (NumberFormatException e)
        {
        } //End block
        catch (NullPointerException e)
        {
        } //End block
    if(id >= 0)        
        {
            String authorityName = parser.getAttributeValue(null, "authority");
            String enabled = parser.getAttributeValue(null, "enabled");
            String syncable = parser.getAttributeValue(null, "syncable");
            String accountName = parser.getAttributeValue(null, "account");
            String accountType = parser.getAttributeValue(null, "type");
    if(accountType == null)            
            {
                accountType = "com.google";
                syncable = "unknown";
            } //End block
            authority = mAuthorities.get(id);
    if(DEBUG_FILE){ }    if(authority == null)            
            {
    if(DEBUG_FILE){ }                authority = getOrCreateAuthorityLocked(
                        new Account(accountName, accountType), authorityName, id, false);
    if(version > 0)                
                {
                    authority.periodicSyncs.clear();
                } //End block
            } //End block
    if(authority != null)            
            {
                authority.enabled = enabled == null || Boolean.parseBoolean(enabled);
    if("unknown".equals(syncable))                
                {
                    authority.syncable = -1;
                } //End block
                else
                {
                    authority.syncable =
                            (syncable == null || Boolean.parseBoolean(syncable)) ? 1 : 0;
                } //End block
            } //End block
            else
            {
            } //End block
        } //End block
AuthorityInfo var9A4A00E403B4898E9807F68E9EBE5A8B_889274554 =         authority;
        var9A4A00E403B4898E9807F68E9EBE5A8B_889274554.addTaint(taint);
        return var9A4A00E403B4898E9807F68E9EBE5A8B_889274554;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.881 -0400", hash_original_method = "5B7C41C6008D60C9ED6FB4C92797A204", hash_generated_method = "9F21808D93E44D1686A43EB2179C9079")
    private Pair<Bundle, Long> parsePeriodicSync(XmlPullParser parser, AuthorityInfo authority) {
        addTaint(authority.getTaint());
        addTaint(parser.getTaint());
        Bundle extras = new Bundle();
        String periodValue = parser.getAttributeValue(null, "period");
        long period;
        try 
        {
            period = Long.parseLong(periodValue);
        } //End block
        catch (NumberFormatException e)
        {
Pair<Bundle, Long> var540C13E9E156B687226421B24F2DF178_2121208006 =             null;
            var540C13E9E156B687226421B24F2DF178_2121208006.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2121208006;
        } //End block
        catch (NullPointerException e)
        {
Pair<Bundle, Long> var540C13E9E156B687226421B24F2DF178_1422029441 =             null;
            var540C13E9E156B687226421B24F2DF178_1422029441.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1422029441;
        } //End block
        final Pair<Bundle, Long> periodicSync = Pair.create(extras, period);
        authority.periodicSyncs.add(periodicSync);
Pair<Bundle, Long> var4CB73F5A6FFDC0C3E371E5FE2FDE4D31_103591896 =         periodicSync;
        var4CB73F5A6FFDC0C3E371E5FE2FDE4D31_103591896.addTaint(taint);
        return var4CB73F5A6FFDC0C3E371E5FE2FDE4D31_103591896;
        // ---------- Original Method ----------
        //Bundle extras = new Bundle();
        //String periodValue = parser.getAttributeValue(null, "period");
        //final long period;
        //try {
            //period = Long.parseLong(periodValue);
        //} catch (NumberFormatException e) {
            //Log.e(TAG, "error parsing the period of a periodic sync", e);
            //return null;
        //} catch (NullPointerException e) {
            //Log.e(TAG, "the period of a periodic sync is null", e);
            //return null;
        //}
        //final Pair<Bundle, Long> periodicSync = Pair.create(extras, period);
        //authority.periodicSyncs.add(periodicSync);
        //return periodicSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.883 -0400", hash_original_method = "63A9A531A6D6EE37322509C7D60C0471", hash_generated_method = "BA224A972022F0FAEEEBB132B13CBA8C")
    private void parseExtra(XmlPullParser parser, Pair<Bundle, Long> periodicSync) {
        addTaint(periodicSync.getTaint());
        addTaint(parser.getTaint());
        final Bundle extras = periodicSync.first;
        String name = parser.getAttributeValue(null, "name");
        String type = parser.getAttributeValue(null, "type");
        String value1 = parser.getAttributeValue(null, "value1");
        String value2 = parser.getAttributeValue(null, "value2");
        try 
        {
    if("long".equals(type))            
            {
                extras.putLong(name, Long.parseLong(value1));
            } //End block
            else
    if("integer".equals(type))            
            {
                extras.putInt(name, Integer.parseInt(value1));
            } //End block
            else
    if("double".equals(type))            
            {
                extras.putDouble(name, Double.parseDouble(value1));
            } //End block
            else
    if("float".equals(type))            
            {
                extras.putFloat(name, Float.parseFloat(value1));
            } //End block
            else
    if("boolean".equals(type))            
            {
                extras.putBoolean(name, Boolean.parseBoolean(value1));
            } //End block
            else
    if("string".equals(type))            
            {
                extras.putString(name, value1);
            } //End block
            else
    if("account".equals(type))            
            {
                extras.putParcelable(name, new Account(value1, value2));
            } //End block
        } //End block
        catch (NumberFormatException e)
        {
        } //End block
        catch (NullPointerException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.885 -0400", hash_original_method = "D0303AA7EB859F30BDBC9813BB120707", hash_generated_method = "456AC6D44877321312D3DB7B70E74378")
    private void writeAccountInfoLocked() {
    if(DEBUG_FILE){ }        FileOutputStream fos = null;
        try 
        {
            fos = mAccountInfoFile.startWrite();
            XmlSerializer out = new FastXmlSerializer();
            out.setOutput(fos, "utf-8");
            out.startDocument(null, true);
            out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            out.startTag(null, "accounts");
            out.attribute(null, "version", Integer.toString(ACCOUNTS_VERSION));
            out.attribute(null, "nextAuthorityId", Integer.toString(mNextAuthorityId));
    if(!mMasterSyncAutomatically)            
            {
                out.attribute(null, "listen-for-tickles", "false");
            } //End block
            final int N = mAuthorities.size();
for(int i=0;i<N;i++)
            {
                AuthorityInfo authority = mAuthorities.valueAt(i);
                out.startTag(null, "authority");
                out.attribute(null, "id", Integer.toString(authority.ident));
                out.attribute(null, "account", authority.account.name);
                out.attribute(null, "type", authority.account.type);
                out.attribute(null, "authority", authority.authority);
                out.attribute(null, "enabled", Boolean.toString(authority.enabled));
    if(authority.syncable < 0)                
                {
                    out.attribute(null, "syncable", "unknown");
                } //End block
                else
                {
                    out.attribute(null, "syncable", Boolean.toString(authority.syncable != 0));
                } //End block
for(Pair<Bundle, Long> periodicSync : authority.periodicSyncs)
                {
                    out.startTag(null, "periodicSync");
                    out.attribute(null, "period", Long.toString(periodicSync.second));
                    final Bundle extras = periodicSync.first;
for(String key : extras.keySet())
                    {
                        out.startTag(null, "extra");
                        out.attribute(null, "name", key);
                        final Object value = extras.get(key);
    if(value instanceof Long)                        
                        {
                            out.attribute(null, "type", "long");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
    if(value instanceof Integer)                        
                        {
                            out.attribute(null, "type", "integer");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
    if(value instanceof Boolean)                        
                        {
                            out.attribute(null, "type", "boolean");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
    if(value instanceof Float)                        
                        {
                            out.attribute(null, "type", "float");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
    if(value instanceof Double)                        
                        {
                            out.attribute(null, "type", "double");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
    if(value instanceof String)                        
                        {
                            out.attribute(null, "type", "string");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
    if(value instanceof Account)                        
                        {
                            out.attribute(null, "type", "account");
                            out.attribute(null, "value1", ((Account)value).name);
                            out.attribute(null, "value2", ((Account)value).type);
                        } //End block
                        out.endTag(null, "extra");
                    } //End block
                    out.endTag(null, "periodicSync");
                } //End block
                out.endTag(null, "authority");
            } //End block
            out.endTag(null, "accounts");
            out.endDocument();
            mAccountInfoFile.finishWrite(fos);
        } //End block
        catch (java.io.IOException e1)
        {
    if(fos != null)            
            {
                mAccountInfoFile.failWrite(fos);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static int getIntColumn(Cursor c, String name) {
        return c.getInt(c.getColumnIndex(name));
    }

    
        static long getLongColumn(Cursor c, String name) {
        return c.getLong(c.getColumnIndex(name));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.894 -0400", hash_original_method = "96B84444EEB95F8262A1F514B70427CB", hash_generated_method = "B381CFC19804DF4B0F031BEB4EE1FB9A")
    private void readAndDeleteLegacyAccountInfoLocked() {
        File file = mContext.getDatabasePath("syncmanager.db");
    if(!file.exists())        
        {
            return;
        } //End block
        String path = file.getPath();
        SQLiteDatabase db = null;
        try 
        {
            db = SQLiteDatabase.openDatabase(path, null,
                    SQLiteDatabase.OPEN_READONLY);
        } //End block
        catch (SQLiteException e)
        {
        } //End block
    if(db != null)        
        {
            final boolean hasType = db.getVersion() >= 11;
    if(DEBUG_FILE){ }            SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
            qb.setTables("stats, status");
            HashMap<String,String> map = new HashMap<String,String>();
            map.put("_id", "status._id as _id");
            map.put("account", "stats.account as account");
    if(hasType)            
            {
                map.put("account_type", "stats.account_type as account_type");
            } //End block
            map.put("authority", "stats.authority as authority");
            map.put("totalElapsedTime", "totalElapsedTime");
            map.put("numSyncs", "numSyncs");
            map.put("numSourceLocal", "numSourceLocal");
            map.put("numSourcePoll", "numSourcePoll");
            map.put("numSourceServer", "numSourceServer");
            map.put("numSourceUser", "numSourceUser");
            map.put("lastSuccessSource", "lastSuccessSource");
            map.put("lastSuccessTime", "lastSuccessTime");
            map.put("lastFailureSource", "lastFailureSource");
            map.put("lastFailureTime", "lastFailureTime");
            map.put("lastFailureMesg", "lastFailureMesg");
            map.put("pending", "pending");
            qb.setProjectionMap(map);
            qb.appendWhere("stats._id = status.stats_id");
            Cursor c = qb.query(db, null, null, null, null, null, null);
            while
(c.moveToNext())            
            {
                String accountName = c.getString(c.getColumnIndex("account"));
                String accountType = hasType
                        ? c.getString(c.getColumnIndex("account_type")) : null;
    if(accountType == null)                
                {
                    accountType = "com.google";
                } //End block
                String authorityName = c.getString(c.getColumnIndex("authority"));
                AuthorityInfo authority = this.getOrCreateAuthorityLocked(
                        new Account(accountName, accountType),
                        authorityName, -1, false);
    if(authority != null)                
                {
                    int i = mSyncStatus.size();
                    boolean found = false;
                    SyncStatusInfo st = null;
                    while
(i > 0)                    
                    {
                        i--;
                        st = mSyncStatus.valueAt(i);
    if(st.authorityId == authority.ident)                        
                        {
                            found = true;
                            break;
                        } //End block
                    } //End block
    if(!found)                    
                    {
                        st = new SyncStatusInfo(authority.ident);
                        mSyncStatus.put(authority.ident, st);
                    } //End block
                    st.totalElapsedTime = getLongColumn(c, "totalElapsedTime");
                    st.numSyncs = getIntColumn(c, "numSyncs");
                    st.numSourceLocal = getIntColumn(c, "numSourceLocal");
                    st.numSourcePoll = getIntColumn(c, "numSourcePoll");
                    st.numSourceServer = getIntColumn(c, "numSourceServer");
                    st.numSourceUser = getIntColumn(c, "numSourceUser");
                    st.numSourcePeriodic = 0;
                    st.lastSuccessSource = getIntColumn(c, "lastSuccessSource");
                    st.lastSuccessTime = getLongColumn(c, "lastSuccessTime");
                    st.lastFailureSource = getIntColumn(c, "lastFailureSource");
                    st.lastFailureTime = getLongColumn(c, "lastFailureTime");
                    st.lastFailureMesg = c.getString(c.getColumnIndex("lastFailureMesg"));
                    st.pending = getIntColumn(c, "pending") != 0;
                } //End block
            } //End block
            c.close();
            qb = new SQLiteQueryBuilder();
            qb.setTables("settings");
            c = qb.query(db, null, null, null, null, null, null);
            while
(c.moveToNext())            
            {
                String name = c.getString(c.getColumnIndex("name"));
                String value = c.getString(c.getColumnIndex("value"));
    if(name == null)                
                continue;
    if(name.equals("listen_for_tickles"))                
                {
                    setMasterSyncAutomatically(value == null || Boolean.parseBoolean(value));
                } //End block
                else
    if(name.startsWith("sync_provider_"))                
                {
                    String provider = name.substring("sync_provider_".length(),
                            name.length());
                    int i = mAuthorities.size();
                    while
(i > 0)                    
                    {
                        i--;
                        AuthorityInfo authority = mAuthorities.valueAt(i);
    if(authority.authority.equals(provider))                        
                        {
                            authority.enabled = value == null || Boolean.parseBoolean(value);
                            authority.syncable = 1;
                        } //End block
                    } //End block
                } //End block
            } //End block
            c.close();
            db.close();
            (new File(path)).delete();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.898 -0400", hash_original_method = "8A0C770C89ACE123AD07688E6EE32DB8", hash_generated_method = "9C0F0CBD34C7DFA8B638EA55C2470ACB")
    private void readStatusLocked() {
    if(DEBUG_FILE){ }        try 
        {
            byte[] data = mStatusFile.readFully();
            Parcel in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            int token;
            while
((token=in.readInt()) != STATUS_FILE_END)            
            {
    if(token == STATUS_FILE_ITEM)                
                {
                    SyncStatusInfo status = new SyncStatusInfo(in);
    if(mAuthorities.indexOfKey(status.authorityId) >= 0)                    
                    {
                        status.pending = false;
    if(DEBUG_FILE){ }                        mSyncStatus.put(status.authorityId, status);
                    } //End block
                } //End block
                else
                {
                    break;
                } //End block
            } //End block
        } //End block
        catch (java.io.IOException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.900 -0400", hash_original_method = "74BDFC1296AA332718133078DAF25C56", hash_generated_method = "4E627493643D4DE2911489C6845CB6F2")
    private void writeStatusLocked() {
    if(DEBUG_FILE){ }        removeMessages(MSG_WRITE_STATUS);
        FileOutputStream fos = null;
        try 
        {
            fos = mStatusFile.startWrite();
            Parcel out = Parcel.obtain();
            final int N = mSyncStatus.size();
for(int i=0;i<N;i++)
            {
                SyncStatusInfo status = mSyncStatus.valueAt(i);
                out.writeInt(STATUS_FILE_ITEM);
                status.writeToParcel(out, 0);
            } //End block
            out.writeInt(STATUS_FILE_END);
            fos.write(out.marshall());
            out.recycle();
            mStatusFile.finishWrite(fos);
        } //End block
        catch (java.io.IOException e1)
        {
    if(fos != null)            
            {
                mStatusFile.failWrite(fos);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.902 -0400", hash_original_method = "1231AB171DBB37761A49B7E20056B86A", hash_generated_method = "2A91568769FC020D1AB274AA429F8E27")
    private void readPendingOperationsLocked() {
    if(DEBUG_FILE){ }        try 
        {
            byte[] data = mPendingFile.readFully();
            Parcel in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            final int SIZE = in.dataSize();
            while
(in.dataPosition() < SIZE)            
            {
                int version = in.readInt();
    if(version != PENDING_OPERATION_VERSION && version != 1)                
                {
                    break;
                } //End block
                int authorityId = in.readInt();
                int syncSource = in.readInt();
                byte[] flatExtras = in.createByteArray();
                boolean expedited;
    if(version == PENDING_OPERATION_VERSION)                
                {
                    expedited = in.readInt() != 0;
                } //End block
                else
                {
                    expedited = false;
                } //End block
                AuthorityInfo authority = mAuthorities.get(authorityId);
    if(authority != null)                
                {
                    Bundle extras;
    if(flatExtras != null)                    
                    {
                        extras = unflattenBundle(flatExtras);
                    } //End block
                    else
                    {
                        extras = new Bundle();
                    } //End block
                    PendingOperation op = new PendingOperation(
                            authority.account, syncSource,
                            authority.authority, extras, expedited);
                    op.authorityId = authorityId;
                    op.flatExtras = flatExtras;
    if(DEBUG_FILE){ }                    mPendingOperations.add(op);
                } //End block
            } //End block
        } //End block
        catch (java.io.IOException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.903 -0400", hash_original_method = "0152B02FFEBFCD8F723BAE9C7F6EE92A", hash_generated_method = "CF15AD6C10E21C514484D1D4B68DF105")
    private void writePendingOperationLocked(PendingOperation op, Parcel out) {
        addTaint(out.getTaint());
        addTaint(op.getTaint());
        out.writeInt(PENDING_OPERATION_VERSION);
        out.writeInt(op.authorityId);
        out.writeInt(op.syncSource);
    if(op.flatExtras == null && op.extras != null)        
        {
            op.flatExtras = flattenBundle(op.extras);
        } //End block
        out.writeByteArray(op.flatExtras);
        out.writeInt(op.expedited ? 1 : 0);
        // ---------- Original Method ----------
        //out.writeInt(PENDING_OPERATION_VERSION);
        //out.writeInt(op.authorityId);
        //out.writeInt(op.syncSource);
        //if (op.flatExtras == null && op.extras != null) {
            //op.flatExtras = flattenBundle(op.extras);
        //}
        //out.writeByteArray(op.flatExtras);
        //out.writeInt(op.expedited ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.904 -0400", hash_original_method = "B08FC5F8DD5CA36D6F4DD131B7753109", hash_generated_method = "5B56B74F233D88467F3FC6D024E3E710")
    private void writePendingOperationsLocked() {
        final int N = mPendingOperations.size();
        FileOutputStream fos = null;
        try 
        {
    if(N == 0)            
            {
    if(DEBUG_FILE){ }                mPendingFile.truncate();
                return;
            } //End block
    if(DEBUG_FILE){ }            fos = mPendingFile.startWrite();
            Parcel out = Parcel.obtain();
for(int i=0;i<N;i++)
            {
                PendingOperation op = mPendingOperations.get(i);
                writePendingOperationLocked(op, out);
            } //End block
            fos.write(out.marshall());
            out.recycle();
            mPendingFile.finishWrite(fos);
        } //End block
        catch (java.io.IOException e1)
        {
    if(fos != null)            
            {
                mPendingFile.failWrite(fos);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.905 -0400", hash_original_method = "3B9D2CCD4E7B33665C76FD82482A168C", hash_generated_method = "13A5EBAF6308EA20DC31307C05655DDB")
    private void appendPendingOperationLocked(PendingOperation op) {
        addTaint(op.getTaint());
    if(DEBUG_FILE){ }        FileOutputStream fos = null;
        try 
        {
            fos = mPendingFile.openAppend();
        } //End block
        catch (java.io.IOException e)
        {
    if(DEBUG_FILE){ }            writePendingOperationsLocked();
            return;
        } //End block
        try 
        {
            Parcel out = Parcel.obtain();
            writePendingOperationLocked(op, out);
            fos.write(out.marshall());
            out.recycle();
        } //End block
        catch (java.io.IOException e1)
        {
        } //End block
        finally 
        {
            try 
            {
                fos.close();
            } //End block
            catch (java.io.IOException e2)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG_FILE) Log.v(TAG, "Appending to " + mPendingFile.getBaseFile());
        //FileOutputStream fos = null;
        //try {
            //fos = mPendingFile.openAppend();
        //} catch (java.io.IOException e) {
            //if (DEBUG_FILE) Log.v(TAG, "Failed append; writing full file");
            //writePendingOperationsLocked();
            //return;
        //}
        //try {
            //Parcel out = Parcel.obtain();
            //writePendingOperationLocked(op, out);
            //fos.write(out.marshall());
            //out.recycle();
        //} catch (java.io.IOException e1) {
            //Log.w(TAG, "Error writing pending operations", e1);
        //} finally {
            //try {
                //fos.close();
            //} catch (java.io.IOException e2) {
            //}
        //}
    }

    
        static private byte[] flattenBundle(Bundle bundle) {
        byte[] flatData = null;
        Parcel parcel = Parcel.obtain();
        try {
            bundle.writeToParcel(parcel, 0);
            flatData = parcel.marshall();
        } finally {
            parcel.recycle();
        }
        return flatData;
    }

    
        static private Bundle unflattenBundle(byte[] flatData) {
        Bundle bundle;
        Parcel parcel = Parcel.obtain();
        try {
            parcel.unmarshall(flatData, 0, flatData.length);
            parcel.setDataPosition(0);
            bundle = parcel.readBundle();
        } catch (RuntimeException e) {
            bundle = new Bundle();
        } finally {
            parcel.recycle();
        }
        return bundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.907 -0400", hash_original_method = "EF23341A4D9A5255D7511F96FA9CF980", hash_generated_method = "E73FBDE22EE1E539FBBE23260432B7A2")
    private void readStatisticsLocked() {
        try 
        {
            byte[] data = mStatisticsFile.readFully();
            Parcel in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            int token;
            int index = 0;
            while
((token=in.readInt()) != STATISTICS_FILE_END)            
            {
    if(token == STATISTICS_FILE_ITEM
                        || token == STATISTICS_FILE_ITEM_OLD)                
                {
                    int day = in.readInt();
    if(token == STATISTICS_FILE_ITEM_OLD)                    
                    {
                        day = day - 2009 + 14245;
                    } //End block
                    DayStats ds = new DayStats(day);
                    ds.successCount = in.readInt();
                    ds.successTime = in.readLong();
                    ds.failureCount = in.readInt();
                    ds.failureTime = in.readLong();
    if(index < mDayStats.length)                    
                    {
                        mDayStats[index] = ds;
                        index++;
                    } //End block
                } //End block
                else
                {
                    break;
                } //End block
            } //End block
        } //End block
        catch (java.io.IOException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.908 -0400", hash_original_method = "FBD3A634F75EF390904BDDFD24CE73C8", hash_generated_method = "29B5B9C2D4DAF3ABDEE6D10D02BE5081")
    private void writeStatisticsLocked() {
    if(DEBUG_FILE){ }        removeMessages(MSG_WRITE_STATISTICS);
        FileOutputStream fos = null;
        try 
        {
            fos = mStatisticsFile.startWrite();
            Parcel out = Parcel.obtain();
            final int N = mDayStats.length;
for(int i=0;i<N;i++)
            {
                DayStats ds = mDayStats[i];
    if(ds == null)                
                {
                    break;
                } //End block
                out.writeInt(STATISTICS_FILE_ITEM);
                out.writeInt(ds.day);
                out.writeInt(ds.successCount);
                out.writeLong(ds.successTime);
                out.writeInt(ds.failureCount);
                out.writeLong(ds.failureTime);
            } //End block
            out.writeInt(STATISTICS_FILE_END);
            fos.write(out.marshall());
            out.recycle();
            mStatisticsFile.finishWrite(fos);
        } //End block
        catch (java.io.IOException e1)
        {
    if(fos != null)            
            {
                mStatisticsFile.failWrite(fos);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class PendingOperation {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.909 -0400", hash_original_field = "E268443E43D93DAB7EBEF303BBE9642F", hash_generated_field = "9D630FBF90643CC60961CCF48FECCA0B")

        Account account;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.909 -0400", hash_original_field = "C4B6C45B08DE8968EEA91097B03482FE", hash_generated_field = "ADDF5490BF1C10ABAFE6E2B2AE40316C")

        int syncSource;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.909 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "246C0F9F2C0270494BEB2E9C6833888B")

        String authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.909 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "6F80A5414A80FF69E92A0BD3C0E073DC")

        Bundle extras;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.909 -0400", hash_original_field = "7959CC84448D1E4ADCF2D189917AB5F5", hash_generated_field = "D7DC8099D62435877828BDBBACCABD83")

        boolean expedited;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.909 -0400", hash_original_field = "A6E80D6465C4F39AC517335BD9346D44", hash_generated_field = "B11D0145EE299937169261FF5464F8E6")

        int authorityId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.909 -0400", hash_original_field = "F78F2C2DC8FF5FBD97589211764EDC09", hash_generated_field = "CCB24DDC55B05A8A59BF27C8C026E7C2")

        byte[] flatExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.911 -0400", hash_original_method = "EF059F8E3294963F1E848A9313768B5B", hash_generated_method = "ECE8E5E0F4B60B404F31D36C12807A31")
          PendingOperation(Account account, int source,
                String authority, Bundle extras, boolean expedited) {
            this.account = account;
            this.syncSource = source;
            this.authority = authority;
            this.extras = extras != null ? new Bundle(extras) : extras;
            this.expedited = expedited;
            this.authorityId = -1;
            // ---------- Original Method ----------
            //this.account = account;
            //this.syncSource = source;
            //this.authority = authority;
            //this.extras = extras != null ? new Bundle(extras) : extras;
            //this.expedited = expedited;
            //this.authorityId = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.912 -0400", hash_original_method = "1B5DBB8810EC174C356BDFB975D9E53C", hash_generated_method = "3B16B7399A2D0DA02220BB5FA54FDA88")
          PendingOperation(PendingOperation other) {
            this.account = other.account;
            this.syncSource = other.syncSource;
            this.authority = other.authority;
            this.extras = other.extras;
            this.authorityId = other.authorityId;
            this.expedited = other.expedited;
            // ---------- Original Method ----------
            //this.account = other.account;
            //this.syncSource = other.syncSource;
            //this.authority = other.authority;
            //this.extras = other.extras;
            //this.authorityId = other.authorityId;
            //this.expedited = other.expedited;
        }

        
    }


    
    static class AccountInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.912 -0400", hash_original_field = "E268443E43D93DAB7EBEF303BBE9642F", hash_generated_field = "9D630FBF90643CC60961CCF48FECCA0B")

        Account account;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.913 -0400", hash_original_field = "B372FF30BD0B7AD61246E45A8DAF39AC", hash_generated_field = "582FF2E1ECE36BD91B7F484171C698A4")

        final HashMap<String, AuthorityInfo> authorities = new HashMap<String, AuthorityInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.913 -0400", hash_original_method = "0A42050331BE326DBD226E8BF4C55827", hash_generated_method = "B735F73451A3ACA4DAAEEE69356C87D1")
          AccountInfo(Account account) {
            this.account = account;
            // ---------- Original Method ----------
            //this.account = account;
        }

        
    }


    
    public static class AuthorityInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.914 -0400", hash_original_field = "E268443E43D93DAB7EBEF303BBE9642F", hash_generated_field = "9D630FBF90643CC60961CCF48FECCA0B")

        Account account;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.914 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "246C0F9F2C0270494BEB2E9C6833888B")

        String authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.914 -0400", hash_original_field = "67217D8B401CF5E72BBF5103D60F3E97", hash_generated_field = "D6522CF0EB0B8A28ECDAD3A7DBFFD747")

        int ident;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.914 -0400", hash_original_field = "A10311459433ADF322F2590A4987C423", hash_generated_field = "D42E676CEDD1F98F54276A59532354DC")

        boolean enabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.914 -0400", hash_original_field = "BB5ED03A2B1CAD35E912B9A1FBB4B102", hash_generated_field = "79AAA92E0C1E2414AE9E421D3715FFA7")

        int syncable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.914 -0400", hash_original_field = "D214D1D366AE39DDEA5B3C19A2409ED7", hash_generated_field = "F9BE9859B6F90DC841CE99B8A7F51A4E")

        long backoffTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.915 -0400", hash_original_field = "683C96AA9C76BDA519E55ECC77ECE69E", hash_generated_field = "3E91C22FA3C3A3339E22C765EEF95ECF")

        long backoffDelay;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.915 -0400", hash_original_field = "77D196B208370F23D20E064B8B1B5DA0", hash_generated_field = "FF2672CE15194FA4F169DAC34CF8A869")

        long delayUntil;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.915 -0400", hash_original_field = "E93649099886D3DD4A3FC7823E345038", hash_generated_field = "9A4BDF3CAA0D13530C1392D88D3B28FD")

        ArrayList<Pair<Bundle, Long>> periodicSyncs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.916 -0400", hash_original_method = "F1AF0EF8567860728BE1920368DC5483", hash_generated_method = "01670732909F0C8780290ABAEC12ABEF")
          AuthorityInfo(Account account, String authority, int ident) {
            this.account = account;
            this.authority = authority;
            this.ident = ident;
            enabled = SYNC_ENABLED_DEFAULT;
            syncable = -1;
            backoffTime = -1;
            backoffDelay = -1;
            periodicSyncs = new ArrayList<Pair<Bundle, Long>>();
            periodicSyncs.add(Pair.create(new Bundle(), DEFAULT_POLL_FREQUENCY_SECONDS));
            // ---------- Original Method ----------
            //this.account = account;
            //this.authority = authority;
            //this.ident = ident;
            //enabled = SYNC_ENABLED_DEFAULT;
            //syncable = -1;
            //backoffTime = -1;
            //backoffDelay = -1;
            //periodicSyncs = new ArrayList<Pair<Bundle, Long>>();
            //periodicSyncs.add(Pair.create(new Bundle(), DEFAULT_POLL_FREQUENCY_SECONDS));
        }

        
    }


    
    public static class SyncHistoryItem {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.917 -0400", hash_original_field = "A6E80D6465C4F39AC517335BD9346D44", hash_generated_field = "B11D0145EE299937169261FF5464F8E6")

        int authorityId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.917 -0400", hash_original_field = "73D2E67EADBB14AC95E57F9F6F454182", hash_generated_field = "EFC3D33E7164A099395EA11FA008631A")

        int historyId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.917 -0400", hash_original_field = "FA84691E935429CDFDEE629C6C506CFE", hash_generated_field = "8BDF38DD5485D11C65E41598A447EC76")

        long eventTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.917 -0400", hash_original_field = "DAD566B38C7C4C71D805927E9FFF2732", hash_generated_field = "019980784258B693231C7932844AF0BC")

        long elapsedTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.917 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "926255832D3A4770F722E618872D36FC")

        int source;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.917 -0400", hash_original_field = "4119639092E62C55EA8BE348E4D9260D", hash_generated_field = "0AA9440F5EB6CF7AA5F6EE77723B4674")

        int event;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.917 -0400", hash_original_field = "25B28D4C6E9FCB008B24DBBED0391F83", hash_generated_field = "7BAE41919A19B3117C8C028B40BE197B")

        long upstreamActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.917 -0400", hash_original_field = "CB3F4AAEEC4327337C5AD425BD3C5EBA", hash_generated_field = "B78B031020001048916FB9B95358FFD7")

        long downstreamActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.917 -0400", hash_original_field = "E0130BF5B411FDCD683C1A359E5B6B92", hash_generated_field = "4661373404204B119E74D3CE353ABACF")

        String mesg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.918 -0400", hash_original_method = "2A1719F3DDEE538E4071CFCF49D97D66", hash_generated_method = "2A1719F3DDEE538E4071CFCF49D97D66")
        public SyncHistoryItem ()
        {
            //Synthesized constructor
        }


    }


    
    public static class DayStats {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.918 -0400", hash_original_field = "628B7DB04235F228D40ADC671413A8C8", hash_generated_field = "0E9628A682BEC1AED9AC9EDA1BF2C9CB")

        public int day;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.918 -0400", hash_original_field = "0D8F2499CF2528C030CD58F737E27388", hash_generated_field = "E32AF39AAA65273577552E6199614DFB")

        public int successCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.918 -0400", hash_original_field = "6539AA85D7508334E237E478CCFBED11", hash_generated_field = "E8A8B28F4FBBA8ADC8F6EA4E5EA3DF18")

        public long successTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.918 -0400", hash_original_field = "B17DD7F123FFCBD6D4D8909114BC2C7E", hash_generated_field = "4E23062AC4D24AC50DF56E8B405F9CA1")

        public int failureCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.918 -0400", hash_original_field = "0BE8CF852CEC555F19B50AB7F3FC597C", hash_generated_field = "D11480323C3691B82CABDCBFB47DADC3")

        public long failureTime;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.919 -0400", hash_original_method = "59D9CE47C9B58BC0ECFC5F57173A8EB8", hash_generated_method = "1997158732D9C97E768763E2795DF4D3")
        public  DayStats(int day) {
            this.day = day;
            // ---------- Original Method ----------
            //this.day = day;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.919 -0400", hash_original_field = "0439F4DA6A334C5ECD9FAAB83A40EC1E", hash_generated_field = "AF31108A14FC5488BDB972C9330ED310")

    private static final String TAG = "SyncManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.919 -0400", hash_original_field = "970B94CF21F1AAD9D1BB8284F27B5EB0", hash_generated_field = "EF3259EDC7B0E8CE678372C0DF872FC5")

    private static final boolean DEBUG_FILE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.919 -0400", hash_original_field = "3A26C05C2491AEFDB49DE3A3EC440F83", hash_generated_field = "38BF0EF4E89A3CF4939612B4A041EE55")

    private static final long DEFAULT_POLL_FREQUENCY_SECONDS = 60 * 60 * 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.919 -0400", hash_original_field = "74AD2A25867DA158CF5A8AAB433620F4", hash_generated_field = "5D728F78E04A905CA547FF7334FD502E")

    static final long MILLIS_IN_4WEEKS = 1000L * 60 * 60 * 24 * 7 * 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.919 -0400", hash_original_field = "22655829AA7E35AB1FADAE4804A583CD", hash_generated_field = "DBB1C0FAA50ADCA191193FD382FF1DB3")

    public static final int EVENT_START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.919 -0400", hash_original_field = "7CDCD962175DB6B2B0E3C586AB20CD5F", hash_generated_field = "3BEF4367DEF9BD87D4115EACD7240966")

    public static final int EVENT_STOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.920 -0400", hash_original_field = "C969FB97AA2B7E63903BD9A4A4EF9F5D", hash_generated_field = "AA12DDBD9F33486333D35FA892003881")

    public static final String[] EVENTS = { "START", "STOP" };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.920 -0400", hash_original_field = "1FC10DD0C353C96AE8D07D259BBED97D", hash_generated_field = "CA7ACB3F234AF725615689B170392D03")

    public static final int SOURCE_SERVER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.920 -0400", hash_original_field = "5F38B0C5E376D19EEFF40921D1D76404", hash_generated_field = "1B9C52B079F74B366A44C348D67DD20B")

    public static final int SOURCE_LOCAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.920 -0400", hash_original_field = "7F80857A96FDFBFED8B6D914448691FC", hash_generated_field = "6873D2C4A74ED23B6139DD518C56FB9D")

    public static final int SOURCE_POLL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.920 -0400", hash_original_field = "06E78232CDBD4A204F47E519FE6B095A", hash_generated_field = "18826EB2F690F30A736E4BA73E385233")

    public static final int SOURCE_USER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.920 -0400", hash_original_field = "393BFDF1EA39606B389647152D55799B", hash_generated_field = "7CEF055DDF11DD9167E38771846C2A7D")

    public static final int SOURCE_PERIODIC = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.920 -0400", hash_original_field = "52881790F8B54A043B2B3370B347D92B", hash_generated_field = "42B3B227F06616C376E0F38E8CD1D857")

    public static final long NOT_IN_BACKOFF_MODE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.920 -0400", hash_original_field = "2E548AD0866A41A8462FDBEFF894C3DA", hash_generated_field = "CA0D4D8E029CF4F0FC382E8F90A0D776")

    public static final Intent SYNC_CONNECTION_SETTING_CHANGED_INTENT =
            new Intent("com.android.sync.SYNC_CONN_STATUS_CHANGED");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.921 -0400", hash_original_field = "BBAD7B5FF4955E7C2016A5820A2C29F8", hash_generated_field = "B0B58A11324B8509E8BBA4B102D854A1")

    public static final String[] SOURCES = { "SERVER",
                                             "LOCAL",
                                             "POLL",
                                             "USER",
                                             "PERIODIC" };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.921 -0400", hash_original_field = "8CE25EA47DDF9E224F399AD74651DA27", hash_generated_field = "4DEC43F2868661A1BA0EBF5BF703C47A")

    public static final String MESG_SUCCESS = "success";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.921 -0400", hash_original_field = "C13412EEB1EBAAF9443F8005E2B42548", hash_generated_field = "17FC59A1C84A7DA7A5A17548CAD57255")

    public static final String MESG_CANCELED = "canceled";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.921 -0400", hash_original_field = "AC1C801337E0FA17C49784E11E472C83", hash_generated_field = "1B46D2BF183174FBED706FF3C2DF798D")

    public static final int MAX_HISTORY = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.921 -0400", hash_original_field = "8292273D83C80ACC23F03C7A22E3E9D8", hash_generated_field = "2655E18C83B5F3B5454E37E1D43F3E2C")

    private static final int MSG_WRITE_STATUS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.921 -0400", hash_original_field = "9A6863C0BE0EB0D3E212DBEFE5C52EFD", hash_generated_field = "4EA8DDD188FF4C168E89C66E59773587")

    private static final long WRITE_STATUS_DELAY = 1000*60*10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.921 -0400", hash_original_field = "B9FD698A11D73A4FB992F113C9C1E839", hash_generated_field = "D7E2178F8C402B9173FFA3D315D94038")

    private static final int MSG_WRITE_STATISTICS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.922 -0400", hash_original_field = "7E76782C1DE68E6A89AD8C5591C6DA5F", hash_generated_field = "20B3D5C604D6B06F3D714BB832758FDC")

    private static final long WRITE_STATISTICS_DELAY = 1000*60*30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.922 -0400", hash_original_field = "304FE4881B03F72E8FA9E4F79FDDE6E2", hash_generated_field = "D424F9AD9A99C5564E56756A063DF4E4")

    private static final boolean SYNC_ENABLED_DEFAULT = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.922 -0400", hash_original_field = "F8427D6D8240ADB9E62BBE69DD599A1C", hash_generated_field = "BCB1DEDD10667E8F9144B92B5AF4FB3C")

    private static final int ACCOUNTS_VERSION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.922 -0400", hash_original_field = "BB5C11BC8C430568A81202837B7BEC1A", hash_generated_field = "E829F19290AD6F16651117D8A72DC792")

    private static HashMap<String, String> sAuthorityRenames;
    static {
        sAuthorityRenames = new HashMap<String, String>();
        sAuthorityRenames.put("contacts", "com.android.contacts");
        sAuthorityRenames.put("calendar", "com.android.calendar");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.922 -0400", hash_original_field = "FABD1FAC0379965DCE7F305C980B3B2D", hash_generated_field = "30DA75A8F03960BB79F751A463A3C81A")

    private static volatile SyncStorageEngine sSyncStorageEngine = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.922 -0400", hash_original_field = "357DE3A306F14B284317E7704E3A6715", hash_generated_field = "1AA6B4A5916CCA9E00BCD79C3BA829B9")

    private static final int PENDING_FINISH_TO_WRITE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.922 -0400", hash_original_field = "F877DBDB2A4A16FBE595987860E3D7B5", hash_generated_field = "29DD7B46231A8851E3979ED054714BB2")

    public static final int STATUS_FILE_END = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.923 -0400", hash_original_field = "DC404CE91F2D6B5F6D5B3AE012169248", hash_generated_field = "3AD83470903C387E8F900C23B2FF2EA8")

    public static final int STATUS_FILE_ITEM = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.923 -0400", hash_original_field = "9A33CD3A58DF951E6307F9FC3DDBAE03", hash_generated_field = "197263DC5593D605C8462C10EBA64119")

    public static final int PENDING_OPERATION_VERSION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.923 -0400", hash_original_field = "CFC7CF91052789EE5627E73804D78C83", hash_generated_field = "C17775889B02E738EED29EAE10B23BE8")

    public static final int STATISTICS_FILE_END = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.923 -0400", hash_original_field = "2C083004C286A80CF8E2A301A6DFDFF3", hash_generated_field = "0293436725092F127B986477871B7112")

    public static final int STATISTICS_FILE_ITEM_OLD = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:11.923 -0400", hash_original_field = "64BEFA2E71E30F411A466C0746F12EA2", hash_generated_field = "74988DD095757B31CB2FB87FD58F31AD")

    public static final int STATISTICS_FILE_ITEM = 101;
}

