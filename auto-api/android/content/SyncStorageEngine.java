package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private SparseArray<AuthorityInfo> mAuthorities =
            new SparseArray<AuthorityInfo>();
    private HashMap<Account, AccountInfo> mAccounts =
        new HashMap<Account, AccountInfo>();
    private ArrayList<PendingOperation> mPendingOperations =
            new ArrayList<PendingOperation>();
    private ArrayList<SyncInfo> mCurrentSyncs = new ArrayList<SyncInfo>();
    private SparseArray<SyncStatusInfo> mSyncStatus =
            new SparseArray<SyncStatusInfo>();
    private ArrayList<SyncHistoryItem> mSyncHistory =
            new ArrayList<SyncHistoryItem>();
    private RemoteCallbackList<ISyncStatusObserver> mChangeListeners
            = new RemoteCallbackList<ISyncStatusObserver>();
    private int mNextAuthorityId = 0;
    private DayStats[] mDayStats = new DayStats[7*4];
    private Calendar mCal;
    private int mYear;
    private int mYearInDays;
    private Context mContext;
    private AtomicFile mAccountInfoFile;
    private AtomicFile mStatusFile;
    private AtomicFile mStatisticsFile;
    private AtomicFile mPendingFile;
    private int mNumPendingFinished = 0;
    private int mNextHistoryId = 0;
    private boolean mMasterSyncAutomatically = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.264 -0400", hash_original_method = "A6EFE710C6881152489583C4A465D2CD", hash_generated_method = "6FEDD97B4D3E63E02A249A425ACE008A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SyncStorageEngine(Context context, File dataDir) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(dataDir.dsTaint);
        sSyncStorageEngine = this;
        mCal = Calendar.getInstance(TimeZone.getTimeZone("GMT+0"));
        File systemDir;
        systemDir = new File(dataDir, "system");
        File syncDir;
        syncDir = new File(systemDir, "sync");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.265 -0400", hash_original_method = "4DFC4B128F767AF6A0DE11433A3D7DB7", hash_generated_method = "C4CB4AE2D5D69671A4D17055789A765F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            {
                writeStatusLocked();
            } //End block
        } //End block
        {
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.265 -0400", hash_original_method = "52497A49330565A574CE17BDC87E49EE", hash_generated_method = "ECC18002E9F024FD43CC13323047887C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addStatusChangeListener(int mask, ISyncStatusObserver callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(mask);
        {
            mChangeListeners.register(callback, mask);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //mChangeListeners.register(callback, mask);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.265 -0400", hash_original_method = "6F129CA4CBCD6FCA8FC01A242206CA3D", hash_generated_method = "08EB6D79BCD1CB8503D6D39D2A2B8944")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeStatusChangeListener(ISyncStatusObserver callback) {
        dsTaint.addTaint(callback.dsTaint);
        {
            mChangeListeners.unregister(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //mChangeListeners.unregister(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.266 -0400", hash_original_method = "08D269D186E562E9C4A4640195EC72C3", hash_generated_method = "580C49C707F215907D4F6713FFD2661F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void reportChange(int which) {
        dsTaint.addTaint(which);
        ArrayList<ISyncStatusObserver> reports;
        reports = null;
        {
            int i;
            i = mChangeListeners.beginBroadcast();
            {
                Integer mask;
                mask = (Integer)mChangeListeners.getBroadcastCookie(i);
                {
                    boolean varE554679AEFB26BBFE81E55728FC56571_689515542 = ((which & mask.intValue()) == 0);
                } //End collapsed parenthetic
                {
                    reports = new ArrayList<ISyncStatusObserver>(i);
                } //End block
                reports.add(mChangeListeners.getBroadcastItem(i));
            } //End block
            mChangeListeners.finishBroadcast();
        } //End block
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_475345317 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        {
            int i;
            i = reports.size();
            {
                try 
                {
                    reports.get(i).onStatusChanged(which);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.266 -0400", hash_original_method = "1E3EB54BE416021CC2FC55EA818E4E21", hash_generated_method = "3431B81C34EE22A2DD6097B28F498581")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getSyncAutomatically(Account account, String providerName) {
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        {
            {
                AuthorityInfo authority;
                authority = getAuthorityLocked(account, providerName,
                        "getSyncAutomatically");
            } //End block
            int i;
            i = mAuthorities.size();
            {
                AuthorityInfo authority;
                authority = mAuthorities.valueAt(i);
                {
                    boolean var33EA43D11F897A66D89A3322392338FC_1445500678 = (authority.authority.equals(providerName)
                        && authority.enabled);
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.267 -0400", hash_original_method = "581987DB149A8DCAC958F242477B1863", hash_generated_method = "B615DAD9DBB64629F5678A0B5D5438F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSyncAutomatically(Account account, String providerName, boolean sync) {
        dsTaint.addTaint(sync);
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        Log.d(TAG, "setSyncAutomatically: " +  ", provider " + providerName
                + " -> " + sync);
        {
            AuthorityInfo authority;
            authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
            {
                Log.d(TAG, "setSyncAutomatically: already set to " + sync + ", doing nothing");
            } //End block
            authority.enabled = sync;
            writeAccountInfoLocked();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.267 -0400", hash_original_method = "669A99F5C38004FBAED3A18D6E12F4E4", hash_generated_method = "5EF2DB8146E5C5041D06D0CF92D42402")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIsSyncable(Account account, String providerName) {
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        {
            {
                AuthorityInfo authority;
                authority = getAuthorityLocked(account, providerName,
                        "getIsSyncable");
            } //End block
            int i;
            i = mAuthorities.size();
            {
                AuthorityInfo authority;
                authority = mAuthorities.valueAt(i);
                {
                    boolean varEF28C7BAAADDB173897911934E03D1CA_1845047062 = (authority.authority.equals(providerName));
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.268 -0400", hash_original_method = "F95D35FA2526F2113282D0AA6609AE27", hash_generated_method = "19977026E0BCD00F9292CE2856F92EBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIsSyncable(Account account, String providerName, int syncable) {
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(syncable);
        {
            syncable = 1;
        } //End block
        {
            syncable = -1;
        } //End block
        Log.d(TAG, "setIsSyncable: " + account + ", provider " + providerName + " -> " + syncable);
        {
            AuthorityInfo authority;
            authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
            {
                Log.d(TAG, "setIsSyncable: already set to " + syncable + ", doing nothing");
            } //End block
            authority.syncable = syncable;
            writeAccountInfoLocked();
        } //End block
        {
            ContentResolver.requestSync(account, providerName, new Bundle());
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.268 -0400", hash_original_method = "8DC1822E61630B36C083348F9F85FD1C", hash_generated_method = "BDB05E0D1CEBD57287616DF286CEA35A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Pair<Long, Long> getBackoff(Account account, String providerName) {
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        {
            AuthorityInfo authority;
            authority = getAuthorityLocked(account, providerName, "getBackoff");
            Pair<Long, Long> var0505E03E875FA0731C2FC60D8519A066_582956729 = (Pair.create(authority.backoffTime, authority.backoffDelay));
        } //End block
        return (Pair<Long, Long>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //AuthorityInfo authority = getAuthorityLocked(account, providerName, "getBackoff");
            //if (authority == null || authority.backoffTime < 0) {
                //return null;
            //}
            //return Pair.create(authority.backoffTime, authority.backoffDelay);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.296 -0400", hash_original_method = "470D6F06A561962AAC0558CECDD66F24", hash_generated_method = "11AC2FA93A068D5A95F27930D3BF9BA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBackoff(Account account, String providerName,
            long nextSyncTime, long nextDelay) {
        dsTaint.addTaint(nextSyncTime);
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(nextDelay);
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_1236339816 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        boolean changed;
        changed = false;
        {
            {
                {
                    Iterator<AccountInfo> varE1E200902F2EC8CF97AC01C00096CA75_146113601 = (mAccounts.values()).iterator();
                    varE1E200902F2EC8CF97AC01C00096CA75_146113601.hasNext();
                    AccountInfo accountInfo = varE1E200902F2EC8CF97AC01C00096CA75_146113601.next();
                    {
                        {
                            boolean varFD1A97EAEF8E1FEECFE35676892986DC_647075804 = (account != null && !account.equals(accountInfo.account));
                        } //End collapsed parenthetic
                        {
                            Iterator<AuthorityInfo> var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_426652082 = (accountInfo.authorities.values()).iterator();
                            var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_426652082.hasNext();
                            AuthorityInfo authorityInfo = var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_426652082.next();
                            {
                                {
                                    boolean varB5086EA8B155D6133B13AFC701A614BF_993559769 = (providerName != null && !providerName.equals(authorityInfo.authority));
                                } //End collapsed parenthetic
                                {
                                    authorityInfo.backoffTime = nextSyncTime;
                                    authorityInfo.backoffDelay = nextDelay;
                                    changed = true;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                AuthorityInfo authority;
                authority = getOrCreateAuthorityLocked(account, providerName, -1 , true);
                authority.backoffTime = nextSyncTime;
                authority.backoffDelay = nextDelay;
                changed = true;
            } //End block
        } //End block
        {
            reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.330 -0400", hash_original_method = "AFA2215C700770E680F9E8F54668F915", hash_generated_method = "79BDA8FA5797488374C52383069D0EE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearAllBackoffs(SyncQueue syncQueue) {
        dsTaint.addTaint(syncQueue.dsTaint);
        boolean changed;
        changed = false;
        {
            {
                Iterator<AccountInfo> varE1E200902F2EC8CF97AC01C00096CA75_620337725 = (mAccounts.values()).iterator();
                varE1E200902F2EC8CF97AC01C00096CA75_620337725.hasNext();
                AccountInfo accountInfo = varE1E200902F2EC8CF97AC01C00096CA75_620337725.next();
                {
                    {
                        Iterator<AuthorityInfo> var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_307315566 = (accountInfo.authorities.values()).iterator();
                        var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_307315566.hasNext();
                        AuthorityInfo authorityInfo = var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_307315566.next();
                        {
                            {
                                {
                                    boolean varB886653DBE5AD63346733F0FC6D36E19_962118750 = (Log.isLoggable(TAG, Log.VERBOSE));
                                } //End collapsed parenthetic
                                authorityInfo.backoffTime = NOT_IN_BACKOFF_MODE;
                                authorityInfo.backoffDelay = NOT_IN_BACKOFF_MODE;
                                syncQueue.onBackoffChanged(accountInfo.account, authorityInfo.authority, 0);
                                changed = true;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.335 -0400", hash_original_method = "4C9FEA1518FBFDF4D1B5258B0B2AE78D", hash_generated_method = "6E2C4DAF9C4263EA6D3CBA578721FD29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDelayUntilTime(Account account, String providerName, long delayUntil) {
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(delayUntil);
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_1069007655 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        {
            AuthorityInfo authority;
            authority = getOrCreateAuthorityLocked(
                    account, providerName, -1 , true);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.335 -0400", hash_original_method = "DA0E26DF9B57177D554F116843CE820C", hash_generated_method = "DAB750315E2538506CDDE633E9CC152C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getDelayUntilTime(Account account, String providerName) {
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        {
            AuthorityInfo authority;
            authority = getAuthorityLocked(account, providerName, "getDelayUntil");
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //AuthorityInfo authority = getAuthorityLocked(account, providerName, "getDelayUntil");
            //if (authority == null) {
                //return 0;
            //}
            //return authority.delayUntil;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.336 -0400", hash_original_method = "DA5487F77FC92CA93809E84A1EE05946", hash_generated_method = "E0B10B65572CEF6478A416193AF9DEC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateOrRemovePeriodicSync(Account account, String providerName, Bundle extras,
            long period, boolean add) {
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(add);
        dsTaint.addTaint(period);
        dsTaint.addTaint(extras.dsTaint);
        {
            period = 0;
        } //End block
        {
            extras = new Bundle();
        } //End block
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_1944886132 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        {
            try 
            {
                AuthorityInfo authority;
                authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
                {
                    boolean alreadyPresent;
                    alreadyPresent = false;
                    {
                        int i, N;
                        i = 0;
                        N = authority.periodicSyncs.size();
                        {
                            Pair<Bundle, Long> syncInfo;
                            syncInfo = authority.periodicSyncs.get(i);
                            Bundle existingExtras;
                            existingExtras = syncInfo.first;
                            {
                                boolean var88751FFF2C3301F2D44B054F25A9F46F_2039039318 = (equals(existingExtras, extras));
                                {
                                    authority.periodicSyncs.set(i, Pair.create(extras, period));
                                    alreadyPresent = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    {
                        authority.periodicSyncs.add(Pair.create(extras, period));
                        SyncStatusInfo status;
                        status = getOrCreateSyncStatusLocked(authority.ident);
                        status.setPeriodicSyncTime(authority.periodicSyncs.size() - 1, 0);
                    } //End block
                } //End block
                {
                    SyncStatusInfo status;
                    status = mSyncStatus.get(authority.ident);
                    boolean changed;
                    changed = false;
                    Iterator<Pair<Bundle, Long>> iterator;
                    iterator = authority.periodicSyncs.iterator();
                    int i;
                    i = 0;
                    {
                        boolean var084ACAAA0951413540CCF629674B7133_1801075746 = (iterator.hasNext());
                        {
                            Pair<Bundle, Long> syncInfo;
                            syncInfo = iterator.next();
                            {
                                boolean var084DF2CEBB751D662F5E921D7F197876_291903622 = (equals(syncInfo.first, extras));
                                {
                                    iterator.remove();
                                    changed = true;
                                    {
                                        status.removePeriodicSyncTime(i);
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.336 -0400", hash_original_method = "403A8311B76EBF44C870FFCE456B63FB", hash_generated_method = "08B16C9BE75ECB357E9163429516B434")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addPeriodicSync(Account account, String providerName, Bundle extras,
            long pollFrequency) {
        dsTaint.addTaint(pollFrequency);
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(extras.dsTaint);
        updateOrRemovePeriodicSync(account, providerName, extras, pollFrequency, true );
        // ---------- Original Method ----------
        //updateOrRemovePeriodicSync(account, providerName, extras, pollFrequency, true );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.337 -0400", hash_original_method = "A5551A39E3E716437015AA42AB9CA434", hash_generated_method = "9E691A862202CD40A60FC21AC3FA8E8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePeriodicSync(Account account, String providerName, Bundle extras) {
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(extras.dsTaint);
        updateOrRemovePeriodicSync(account, providerName, extras, 0 ,
                false );
        // ---------- Original Method ----------
        //updateOrRemovePeriodicSync(account, providerName, extras, 0 ,
                //false );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.350 -0400", hash_original_method = "43BA96B870E40929E429A78D83FB8F24", hash_generated_method = "13BF0B7D38A4519BF8C97E41FF29F07B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<PeriodicSync> getPeriodicSyncs(Account account, String providerName) {
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        ArrayList<PeriodicSync> syncs;
        syncs = new ArrayList<PeriodicSync>();
        {
            AuthorityInfo authority;
            authority = getAuthorityLocked(account, providerName, "getPeriodicSyncs");
            {
                {
                    Iterator<Pair<Bundle, Long>> var98C61C5D42FC8213C1C6755E1467E764_21171075 = (authority.periodicSyncs).iterator();
                    var98C61C5D42FC8213C1C6755E1467E764_21171075.hasNext();
                    Pair<Bundle, Long> item = var98C61C5D42FC8213C1C6755E1467E764_21171075.next();
                    {
                        syncs.add(new PeriodicSync(account, providerName, item.first, item.second));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (List<PeriodicSync>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.350 -0400", hash_original_method = "AF0CE82B663D00FD098AAFE2F6E1B437", hash_generated_method = "8BCD32C67DF11DC4FB033EAD084A8356")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMasterSyncAutomatically(boolean flag) {
        dsTaint.addTaint(flag);
        {
            writeAccountInfoLocked();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.351 -0400", hash_original_method = "6DBCD9157A2DF54805879831F88D4B77", hash_generated_method = "86EB1FBE6A1C4FD4929BD2CE8B606E2A")
    @DSModeled(DSC.SAFE)
    public boolean getMasterSyncAutomatically() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return mMasterSyncAutomatically;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.351 -0400", hash_original_method = "AC4455129C3CF5603625E4A23A44D091", hash_generated_method = "7452B4D0F1113F782B9D8E31BE3E822E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthorityInfo getOrCreateAuthority(Account account, String authority) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        {
            AuthorityInfo var4C7B58C6E68BF0917B20F6AA73C8BFE8_416696258 = (getOrCreateAuthorityLocked(account, authority,
                    -1 ,
                    true ));
        } //End block
        return (AuthorityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return getOrCreateAuthorityLocked(account, authority,
                    //-1 ,
                    //true );
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.351 -0400", hash_original_method = "BAFC16DAE21D996A746903C6AB7A1E8C", hash_generated_method = "951F8830672F49514D7ED69736C0F410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAuthority(Account account, String authority) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        {
            removeAuthorityLocked(account, authority, true );
        } //End block
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //removeAuthorityLocked(account, authority, true );
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.371 -0400", hash_original_method = "B031DD2BDA31C86F4257F62895ABA1B2", hash_generated_method = "EBAE4A91EDD87B1DF0DEAB3B27B94BFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthorityInfo getAuthority(int authorityId) {
        dsTaint.addTaint(authorityId);
        {
            AuthorityInfo var801D317470FD05BA9E882DBE2D7F032B_771451142 = (mAuthorities.get(authorityId));
        } //End block
        return (AuthorityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return mAuthorities.get(authorityId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.394 -0400", hash_original_method = "F75815D4B05E7C78CBDEC7A3CDAC25FD", hash_generated_method = "818FACECF83D2AD1CD24B75D8F33B15B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSyncActive(Account account, String authority) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        {
            {
                Iterator<SyncInfo> varBF2E0DA70AF79DE7F1E948E32EFE3860_874583615 = (mCurrentSyncs).iterator();
                varBF2E0DA70AF79DE7F1E948E32EFE3860_874583615.hasNext();
                SyncInfo syncInfo = varBF2E0DA70AF79DE7F1E948E32EFE3860_874583615.next();
                {
                    AuthorityInfo ainfo;
                    ainfo = getAuthority(syncInfo.authorityId);
                    {
                        boolean varAFEDDCA0914F4E52FA37E7A05672B6CB_703926885 = (ainfo != null && ainfo.account.equals(account)
                        && ainfo.authority.equals(authority));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.397 -0400", hash_original_method = "42358B0BF27AF155FB408124FA39D63B", hash_generated_method = "E8AB2D579E9A1B4C14F626D716CA6008")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PendingOperation insertIntoPending(PendingOperation op) {
        dsTaint.addTaint(op.dsTaint);
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1944314679 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            AuthorityInfo authority;
            authority = getOrCreateAuthorityLocked(op.account,
                    op.authority,
                    -1 ,
                    true );
            op = new PendingOperation(op);
            op.authorityId = authority.ident;
            mPendingOperations.add(op);
            appendPendingOperationLocked(op);
            SyncStatusInfo status;
            status = getOrCreateSyncStatusLocked(authority.ident);
            status.pending = true;
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        return (PendingOperation)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.398 -0400", hash_original_method = "50B189E2AFDD83FCD044E18708DDFA85", hash_generated_method = "898E9C6774990D583AECF11035ACE3DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean deleteFromPending(PendingOperation op) {
        dsTaint.addTaint(op.dsTaint);
        boolean res;
        res = false;
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1726275719 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            {
                boolean var22C92094F802A5404DB595143B36E95B_500789621 = (mPendingOperations.remove(op));
                {
                    {
                        boolean var7A59FA2783DD5BD85E73BCF800C5CD5B_512470318 = (mPendingOperations.size() == 0
                        || mNumPendingFinished >= PENDING_FINISH_TO_WRITE);
                        {
                            writePendingOperationsLocked();
                            mNumPendingFinished = 0;
                        } //End block
                    } //End collapsed parenthetic
                    AuthorityInfo authority;
                    authority = getAuthorityLocked(op.account, op.authority,
                        "deleteFromPending");
                    {
                        {
                            boolean var0C9C1F857EF1208EE3C75B6103EF6F6E_473278932 = (Log.isLoggable(TAG, Log.VERBOSE));
                        } //End collapsed parenthetic
                        int N;
                        N = mPendingOperations.size();
                        boolean morePending;
                        morePending = false;
                        {
                            int i;
                            i = 0;
                            {
                                PendingOperation cur;
                                cur = mPendingOperations.get(i);
                                {
                                    boolean var3ADCD3264C59E0B1EE17FF97FBF35418_1244109646 = (cur.account.equals(op.account)
                                && cur.authority.equals(op.authority));
                                    {
                                        morePending = true;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        {
                            {
                                boolean var406C81657E6030DC2B5474942FB17755_935915236 = (Log.isLoggable(TAG, Log.VERBOSE));
                            } //End collapsed parenthetic
                            SyncStatusInfo status;
                            status = getOrCreateSyncStatusLocked(authority.ident);
                            status.pending = false;
                        } //End block
                    } //End block
                    res = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.399 -0400", hash_original_method = "B0FBF76821996DB4DA7D3758DC73EE90", hash_generated_method = "DF1E19D2DF8AAB415ED94A275A2A77C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int clearPending() {
        int num;
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_134497412 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            num = mPendingOperations.size();
            mPendingOperations.clear();
            int N;
            N = mSyncStatus.size();
            {
                int i;
                i = 0;
                {
                    mSyncStatus.valueAt(i).pending = false;
                } //End block
            } //End collapsed parenthetic
            writePendingOperationsLocked();
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.401 -0400", hash_original_method = "C927FD207EDF022EE536945570AA8499", hash_generated_method = "88D5B6A298A04F09BB568FEEA61C8794")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<PendingOperation> getPendingOperations() {
        {
            ArrayList<PendingOperation> var3F64269FB39A63637697A417F148F60F_1698339429 = (new ArrayList<PendingOperation>(mPendingOperations));
        } //End block
        return (ArrayList<PendingOperation>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return new ArrayList<PendingOperation>(mPendingOperations);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.402 -0400", hash_original_method = "CC9059641F127440F6B10F04341F5D1E", hash_generated_method = "43DAB09223B63CF185A4D52184E2E6A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPendingOperationCount() {
        {
            int var3B05F492CC93917538A1DEB47026045B_1001313123 = (mPendingOperations.size());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return mPendingOperations.size();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.440 -0400", hash_original_method = "38BC76D95CA0A954EB857B91A285A324", hash_generated_method = "01352F024283AA6C8AF6336FC1520069")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void doDatabaseCleanup(Account[] accounts) {
        dsTaint.addTaint(accounts[0].dsTaint);
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1359135981 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            SparseArray<AuthorityInfo> removing;
            removing = new SparseArray<AuthorityInfo>();
            Iterator<AccountInfo> accIt;
            accIt = mAccounts.values().iterator();
            {
                boolean var3FA577D82B1515639659819C370D49CE_342309343 = (accIt.hasNext());
                {
                    AccountInfo acc;
                    acc = accIt.next();
                    {
                        boolean var5492D678E806FAA9F7E79AD749A0A01E_355005456 = (!ArrayUtils.contains(accounts, acc.account));
                        {
                            {
                                boolean var406C81657E6030DC2B5474942FB17755_23976256 = (Log.isLoggable(TAG, Log.VERBOSE));
                            } //End collapsed parenthetic
                            {
                                Iterator<AuthorityInfo> var2DC806D12532DF6A8D484D851F207D3C_2118996083 = (acc.authorities.values()).iterator();
                                var2DC806D12532DF6A8D484D851F207D3C_2118996083.hasNext();
                                AuthorityInfo auth = var2DC806D12532DF6A8D484D851F207D3C_2118996083.next();
                                {
                                    removing.put(auth.ident, auth);
                                } //End block
                            } //End collapsed parenthetic
                            accIt.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            int i;
            i = removing.size();
            {
                {
                    int ident;
                    ident = removing.keyAt(i);
                    mAuthorities.remove(ident);
                    int j;
                    j = mSyncStatus.size();
                    {
                        {
                            boolean var98923AE1F6B1C2B259359E9FCA67D383_353707852 = (mSyncStatus.keyAt(j) == ident);
                            {
                                mSyncStatus.remove(mSyncStatus.keyAt(j));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    j = mSyncHistory.size();
                    {
                        {
                            boolean var18C8FAB6AF23CF51357B479AA00E94CE_1611388578 = (mSyncHistory.get(j).authorityId == ident);
                            {
                                mSyncHistory.remove(j);
                            } //End block
                        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.441 -0400", hash_original_method = "1CDF6C9A1F9F2098201F4D7433D51EE7", hash_generated_method = "6166286F26C79154F3C806AC36BC7C15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncInfo addActiveSync(SyncManager.ActiveSyncContext activeSyncContext) {
        dsTaint.addTaint(activeSyncContext.dsTaint);
        SyncInfo syncInfo;
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_818040527 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            AuthorityInfo authority;
            authority = getOrCreateAuthorityLocked(
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
        return (SyncInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.441 -0400", hash_original_method = "2B31DF94CF8024B200C12FFD3895E8BE", hash_generated_method = "09765716D921479543364456C593621E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeActiveSync(SyncInfo syncInfo) {
        dsTaint.addTaint(syncInfo.dsTaint);
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1788759463 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.441 -0400", hash_original_method = "5624025FD66E34CEC2F994FDB502F76B", hash_generated_method = "4CF4CD5E23AE17353DE22949D91BFDC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reportActiveChange() {
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_ACTIVE);
        // ---------- Original Method ----------
        //reportChange(ContentResolver.SYNC_OBSERVER_TYPE_ACTIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.442 -0400", hash_original_method = "7B7D2D5D3E7E0D062624D3006A76AABE", hash_generated_method = "4FA1061AE44E24A0DDFF91A63DC2AD5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long insertStartSyncEvent(Account accountName, String authorityName,
            long now, int source) {
        dsTaint.addTaint(accountName.dsTaint);
        dsTaint.addTaint(source);
        dsTaint.addTaint(now);
        dsTaint.addTaint(authorityName);
        long id;
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_371522083 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            AuthorityInfo authority;
            authority = getAuthorityLocked(accountName, authorityName,
                    "insertStartSyncEvent");
            SyncHistoryItem item;
            item = new SyncHistoryItem();
            item.authorityId = authority.ident;
            item.historyId = mNextHistoryId++;
            mNextHistoryId = 0;
            item.eventTime = now;
            item.source = source;
            item.event = EVENT_START;
            mSyncHistory.add(0, item);
            {
                boolean varF9A71BA7FA547CA258F7C7A61A733FEC_365345648 = (mSyncHistory.size() > MAX_HISTORY);
                {
                    mSyncHistory.remove(mSyncHistory.size()-1);
                } //End block
            } //End collapsed parenthetic
            id = item.historyId;
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_886183950 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_STATUS);
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.443 -0400", hash_original_method = "50B7DBCE95202763C50A27A5F5D2A2F4", hash_generated_method = "37BBA9A21ADFB6437BED3C1CAD012BF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopSyncEvent(long historyId, long elapsedTime, String resultMessage,
            long downstreamActivity, long upstreamActivity) {
        dsTaint.addTaint(upstreamActivity);
        dsTaint.addTaint(historyId);
        dsTaint.addTaint(downstreamActivity);
        dsTaint.addTaint(resultMessage);
        dsTaint.addTaint(elapsedTime);
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1292827897 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            SyncHistoryItem item;
            item = null;
            int i;
            i = mSyncHistory.size();
            {
                item = mSyncHistory.get(i);
                item = null;
            } //End block
            item.elapsedTime = elapsedTime;
            item.event = EVENT_STOP;
            item.mesg = resultMessage;
            item.downstreamActivity = downstreamActivity;
            item.upstreamActivity = upstreamActivity;
            SyncStatusInfo status;
            status = getOrCreateSyncStatusLocked(item.authorityId);
            status.totalElapsedTime += elapsedTime;
            boolean writeStatisticsNow;
            writeStatisticsNow = false;
            int day;
            day = getCurrentDayLocked();
            {
                mDayStats[0] = new DayStats(day);
            } //End block
            {
                System.arraycopy(mDayStats, 0, mDayStats, 1, mDayStats.length-1);
                mDayStats[0] = new DayStats(day);
                writeStatisticsNow = true;
            } //End block
            DayStats ds;
            ds = mDayStats[0];
            long lastSyncTime;
            lastSyncTime = (item.eventTime + elapsedTime);
            boolean writeStatusNow;
            writeStatusNow = false;
            {
                boolean var95BFB9B6109F7C0D5A26D3BAE919F8FF_841670820 = (MESG_SUCCESS.equals(resultMessage));
                {
                    {
                        writeStatusNow = true;
                    } //End block
                    status.lastSuccessTime = lastSyncTime;
                    status.lastSuccessSource = item.source;
                    status.lastFailureTime = 0;
                    status.lastFailureSource = -1;
                    status.lastFailureMesg = null;
                    status.initialFailureTime = 0;
                    ds.successTime += elapsedTime;
                } //End block
                {
                    boolean var7C71A300047F108AC3033C50DC0486FF_1219905036 = (!MESG_CANCELED.equals(resultMessage));
                    {
                        {
                            writeStatusNow = true;
                        } //End block
                        status.lastFailureTime = lastSyncTime;
                        status.lastFailureSource = item.source;
                        status.lastFailureMesg = resultMessage;
                        {
                            status.initialFailureTime = lastSyncTime;
                        } //End block
                        ds.failureTime += elapsedTime;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                writeStatusLocked();
            } //End block
            {
                boolean var2B91D1FCA73FC02C02D1162978B1932A_1607210949 = (!hasMessages(MSG_WRITE_STATUS));
                {
                    sendMessageDelayed(obtainMessage(MSG_WRITE_STATUS),
                        WRITE_STATUS_DELAY);
                } //End block
            } //End collapsed parenthetic
            {
                writeStatisticsLocked();
            } //End block
            {
                boolean varEAC7F4D3EF7F30FF5707B3481FC22C4A_1068140892 = (!hasMessages(MSG_WRITE_STATISTICS));
                {
                    sendMessageDelayed(obtainMessage(MSG_WRITE_STATISTICS),
                        WRITE_STATISTICS_DELAY);
                } //End block
            } //End collapsed parenthetic
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_STATUS);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.444 -0400", hash_original_method = "F85BE50FB140D59BBA80C586F09539D3", hash_generated_method = "AB2389AA46066A97CA1B7EC2AC7DD3B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<SyncInfo> getCurrentSyncs() {
        {
            List<SyncInfo> var9276FCD3E9236C3A5314311F323A3B2C_208689000 = (new ArrayList<SyncInfo>(mCurrentSyncs));
        } //End block
        return (List<SyncInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return new ArrayList<SyncInfo>(mCurrentSyncs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.444 -0400", hash_original_method = "337F005F5350F3BD5177B0B27AD2E944", hash_generated_method = "EF395FDE1D10E0AEBD0DDECAA6CE85E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<SyncStatusInfo> getSyncStatus() {
        {
            int N;
            N = mSyncStatus.size();
            ArrayList<SyncStatusInfo> ops;
            ops = new ArrayList<SyncStatusInfo>(N);
            {
                int i;
                i = 0;
                {
                    ops.add(mSyncStatus.valueAt(i));
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ArrayList<SyncStatusInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.445 -0400", hash_original_method = "AEA28BD7AFFA3D47C607E69E1C170D48", hash_generated_method = "7DE9F63D57985520B63E88DF98A8B396")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<AuthorityInfo> getAuthorities() {
        {
            int N;
            N = mAuthorities.size();
            ArrayList<AuthorityInfo> infos;
            infos = new ArrayList<AuthorityInfo>(N);
            {
                int i;
                i = 0;
                {
                    infos.add(mAuthorities.valueAt(i));
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ArrayList<AuthorityInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.445 -0400", hash_original_method = "0CFE1C56DFD3FFD9F777D7B0D6FDA886", hash_generated_method = "9C9AC5FA195E4E9D937064CB9B6B8CD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncStatusInfo getStatusByAccountAndAuthority(Account account, String authority) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            int N;
            N = mSyncStatus.size();
            {
                int i;
                i = 0;
                {
                    SyncStatusInfo cur;
                    cur = mSyncStatus.valueAt(i);
                    AuthorityInfo ainfo;
                    ainfo = mAuthorities.get(cur.authorityId);
                    {
                        boolean var862D844832D3CF22D3C92B9C4A23CE0F_1563635098 = (ainfo != null && ainfo.authority.equals(authority) &&
                    account.equals(ainfo.account));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (SyncStatusInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.445 -0400", hash_original_method = "11629709D08EF9D9A0440D25565E7A8F", hash_generated_method = "174511611D7A20CB3A14C47E05D02891")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSyncPending(Account account, String authority) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        {
            int N;
            N = mSyncStatus.size();
            {
                int i;
                i = 0;
                {
                    SyncStatusInfo cur;
                    cur = mSyncStatus.valueAt(i);
                    AuthorityInfo ainfo;
                    ainfo = mAuthorities.get(cur.authorityId);
                    {
                        boolean var0FFE9F6E75A8D1A1C72EB5282DFC0008_352918742 = (account != null && !ainfo.account.equals(account));
                    } //End collapsed parenthetic
                    {
                        boolean var7CBBC873E3E6AD1B3ACD68783E9A1B98_1238224603 = (ainfo.authority.equals(authority) && cur.pending);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.446 -0400", hash_original_method = "B27CDDFFB9BAFF7BFEA0365E872FDD46", hash_generated_method = "336940D3FB5A626B64DAD966E4913E7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<SyncHistoryItem> getSyncHistory() {
        {
            int N;
            N = mSyncHistory.size();
            ArrayList<SyncHistoryItem> items;
            items = new ArrayList<SyncHistoryItem>(N);
            {
                int i;
                i = 0;
                {
                    items.add(mSyncHistory.get(i));
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ArrayList<SyncHistoryItem>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.446 -0400", hash_original_method = "3EC13B6BE37070366668DCFEFC381135", hash_generated_method = "54D7A648B78E09F9FBFEF5445C4E9C2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DayStats[] getDayStatistics() {
        {
            DayStats[] ds;
            ds = new DayStats[mDayStats.length];
            System.arraycopy(mDayStats, 0, ds, 0, ds.length);
        } //End block
        return (DayStats[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //DayStats[] ds = new DayStats[mDayStats.length];
            //System.arraycopy(mDayStats, 0, ds, 0, ds.length);
            //return ds;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.447 -0400", hash_original_method = "CFA8C7FA80DDF752958B19CD5427CAD8", hash_generated_method = "7DC6C3F24B6F3DD10ED58EADAD341B53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getInitialSyncFailureTime() {
        {
            long oldest;
            oldest = 0;
            int i;
            i = mSyncStatus.size();
            {
                SyncStatusInfo stats;
                stats = mSyncStatus.valueAt(i);
                AuthorityInfo authority;
                authority = mAuthorities.get(stats.authorityId);
                {
                    {
                        oldest = stats.initialFailureTime;
                    } //End block
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.447 -0400", hash_original_method = "C1CC7B80E3CCED2D49B24E4AC052D091", hash_generated_method = "F71B6850055356E47F17C8C9D0104DEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getCurrentDayLocked() {
        mCal.setTimeInMillis(System.currentTimeMillis());
        int dayOfYear;
        dayOfYear = mCal.get(Calendar.DAY_OF_YEAR);
        {
            boolean varF5AE9792675ABE63903C843879FC5273_2097138197 = (mYear != mCal.get(Calendar.YEAR));
            {
                mYear = mCal.get(Calendar.YEAR);
                mCal.clear();
                mCal.set(Calendar.YEAR, mYear);
                mYearInDays = (int)(mCal.getTimeInMillis()/86400000);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.448 -0400", hash_original_method = "6C953B58E1758760E6819A681B8F6E8F", hash_generated_method = "2F98B7E4AB5C400DF6D41EC16C75D0F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AuthorityInfo getAuthorityLocked(Account accountName, String authorityName,
            String tag) {
        dsTaint.addTaint(accountName.dsTaint);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(authorityName);
        AccountInfo account;
        account = mAccounts.get(accountName);
        {
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_369379486 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
            } //End block
        } //End block
        AuthorityInfo authority;
        authority = account.authorities.get(authorityName);
        {
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1473008033 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (AuthorityInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.456 -0400", hash_original_method = "8765A57952C80F1A5760550FE9E929E6", hash_generated_method = "D39EEF179B34FF0346803D0AD09F7228")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AuthorityInfo getOrCreateAuthorityLocked(Account accountName,
            String authorityName, int ident, boolean doWrite) {
        dsTaint.addTaint(doWrite);
        dsTaint.addTaint(accountName.dsTaint);
        dsTaint.addTaint(ident);
        dsTaint.addTaint(authorityName);
        AccountInfo account;
        account = mAccounts.get(accountName);
        {
            account = new AccountInfo(accountName);
            mAccounts.put(accountName, account);
        } //End block
        AuthorityInfo authority;
        authority = account.authorities.get(authorityName);
        {
            {
                ident = mNextAuthorityId;
                doWrite = true;
            } //End block
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_2110578778 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            authority = new AuthorityInfo(accountName, authorityName, ident);
            account.authorities.put(authorityName, authority);
            mAuthorities.put(ident, authority);
            {
                writeAccountInfoLocked();
            } //End block
        } //End block
        return (AuthorityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.459 -0400", hash_original_method = "654490315D677BE62FC7AFF81C0D5F85", hash_generated_method = "B745C387C4514E01EC1E2E65A0102EC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeAuthorityLocked(Account account, String authorityName, boolean doWrite) {
        dsTaint.addTaint(doWrite);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(authorityName);
        AccountInfo accountInfo;
        accountInfo = mAccounts.get(account);
        {
            AuthorityInfo authorityInfo;
            authorityInfo = accountInfo.authorities.remove(authorityName);
            {
                mAuthorities.remove(authorityInfo.ident);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.459 -0400", hash_original_method = "8F9F327D2E93831D0CA3DA1F9594BFF4", hash_generated_method = "1C79CA470052E7DDF56D6053A6D83ECE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncStatusInfo getOrCreateSyncStatus(AuthorityInfo authority) {
        dsTaint.addTaint(authority.dsTaint);
        {
            SyncStatusInfo var1F7334380F7FE369D45481391D16B536_1432039531 = (getOrCreateSyncStatusLocked(authority.ident));
        } //End block
        return (SyncStatusInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return getOrCreateSyncStatusLocked(authority.ident);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.460 -0400", hash_original_method = "1C22F2C698CD79AA856218BCBCBEF0F7", hash_generated_method = "A644ADB758873F035E71BFAA0E717710")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SyncStatusInfo getOrCreateSyncStatusLocked(int authorityId) {
        dsTaint.addTaint(authorityId);
        SyncStatusInfo status;
        status = mSyncStatus.get(authorityId);
        {
            status = new SyncStatusInfo(authorityId);
            mSyncStatus.put(authorityId, status);
        } //End block
        return (SyncStatusInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SyncStatusInfo status = mSyncStatus.get(authorityId);
        //if (status == null) {
            //status = new SyncStatusInfo(authorityId);
            //mSyncStatus.put(authorityId, status);
        //}
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.460 -0400", hash_original_method = "EC72A1F81B7D887353DF2FA5F052A597", hash_generated_method = "86F12DB138C5A51C581689801B2E7042")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeAllState() {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.461 -0400", hash_original_method = "E278B7FDC712595C2D25226C12B41BCD", hash_generated_method = "3B18257F5F9A6BBCDF5F4100DB64A581")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearAndReadState() {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.464 -0400", hash_original_method = "9E90C2E17AAFB2A4F084659253144E64", hash_generated_method = "2C13B73E6BAEF385CA988B6594249D88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readAccountInfoLocked() {
        int highestAuthorityId;
        highestAuthorityId = -1;
        FileInputStream fis;
        fis = null;
        try 
        {
            fis = mAccountInfoFile.openRead();
            XmlPullParser parser;
            parser = Xml.newPullParser();
            parser.setInput(fis, null);
            int eventType;
            eventType = parser.getEventType();
            {
                eventType = parser.next();
            } //End block
            String tagName;
            tagName = parser.getName();
            {
                boolean varEA9134381FE53D35BC8E6FDC6023FD4E_2136724138 = ("accounts".equals(tagName));
                {
                    String listen;
                    listen = parser.getAttributeValue(
                        null, "listen-for-tickles");
                    String versionString;
                    versionString = parser.getAttributeValue(null, "version");
                    int version;
                    try 
                    {
                        version = (versionString == null) ? 0 : Integer.parseInt(versionString);
                    } //End block
                    catch (NumberFormatException e)
                    {
                        version = 0;
                    } //End block
                    String nextIdString;
                    nextIdString = parser.getAttributeValue(null, "nextAuthorityId");
                    try 
                    {
                        int id;
                        id = 0;
                        id = Integer.parseInt(nextIdString);
                        mNextAuthorityId = Math.max(mNextAuthorityId, id);
                    } //End block
                    catch (NumberFormatException e)
                    { }
                    mMasterSyncAutomatically = listen == null || Boolean.parseBoolean(listen);
                    eventType = parser.next();
                    AuthorityInfo authority;
                    authority = null;
                    Pair<Bundle, Long> periodicSync;
                    periodicSync = null;
                    {
                        {
                            tagName = parser.getName();
                            {
                                boolean var5533CC5BF096B074D5377EFABC3239D4_1965945308 = (parser.getDepth() == 2);
                                {
                                    {
                                        boolean varC338281B9AB8666CC99D2E81E043881E_1319239355 = ("authority".equals(tagName));
                                        {
                                            authority = parseAuthority(parser, version);
                                            periodicSync = null;
                                            {
                                                highestAuthorityId = authority.ident;
                                            } //End block
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean var72C0C0241F04C0E1079A48495349FFF8_505241223 = (parser.getDepth() == 3);
                                    {
                                        {
                                            boolean var46DF390825B8F1ABB8FC0E3A4246521B_1525010348 = ("periodicSync".equals(tagName) && authority != null);
                                            {
                                                periodicSync = parsePeriodicSync(parser, authority);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        boolean var2DA16D744ECD2010DC4A4EF0E453A4B1_1571056750 = (parser.getDepth() == 4 && periodicSync != null);
                                        {
                                            {
                                                boolean var81C030BF887EEF545F20C4A1E1AD0D03_715911604 = ("extra".equals(tagName));
                                                {
                                                    parseExtra(parser, periodicSync);
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                        eventType = parser.next();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (XmlPullParserException e)
        { }
        catch (java.io.IOException e)
        { }
        finally 
        {
            mNextAuthorityId = Math.max(highestAuthorityId + 1, mNextAuthorityId);
            {
                try 
                {
                    fis.close();
                } //End block
                catch (java.io.IOException e1)
                { }
            } //End block
        } //End block
        maybeMigrateSettingsForRenamedAuthorities();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.497 -0400", hash_original_method = "1F0CD4338AAE9E719690DF5E0BB493ED", hash_generated_method = "B21B121D1A46F31AD941506FE34D84E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean maybeMigrateSettingsForRenamedAuthorities() {
        boolean writeNeeded;
        writeNeeded = false;
        ArrayList<AuthorityInfo> authoritiesToRemove;
        authoritiesToRemove = new ArrayList<AuthorityInfo>();
        int N;
        N = mAuthorities.size();
        {
            int i;
            i = 0;
            {
                AuthorityInfo authority;
                authority = mAuthorities.valueAt(i);
                String newAuthorityName;
                newAuthorityName = sAuthorityRenames.get(authority.authority);
                authoritiesToRemove.add(authority);
                {
                    boolean var698AA62F742F1C5C9850F3579DB53BD9_1481788718 = (getAuthorityLocked(authority.account, newAuthorityName, "cleanup") != null);
                } //End collapsed parenthetic
                AuthorityInfo newAuthority;
                newAuthority = getOrCreateAuthorityLocked(authority.account,
                    newAuthorityName, -1 , false );
                newAuthority.enabled = true;
                writeNeeded = true;
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<AuthorityInfo> varD7DAEFE4E3289DAC94FBF4EAEE25A485_2111054096 = (authoritiesToRemove).iterator();
            varD7DAEFE4E3289DAC94FBF4EAEE25A485_2111054096.hasNext();
            AuthorityInfo authorityInfo = varD7DAEFE4E3289DAC94FBF4EAEE25A485_2111054096.next();
            {
                removeAuthorityLocked(authorityInfo.account, authorityInfo.authority,
                    false );
                writeNeeded = true;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.501 -0400", hash_original_method = "39CA1CD415012CC0A4B70AAED3727A93", hash_generated_method = "341105660C990FAA8BEE0E42F7B3279A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AuthorityInfo parseAuthority(XmlPullParser parser, int version) {
        dsTaint.addTaint(parser.dsTaint);
        dsTaint.addTaint(version);
        AuthorityInfo authority;
        authority = null;
        int id;
        id = -1;
        try 
        {
            id = Integer.parseInt(parser.getAttributeValue(
                    null, "id"));
        } //End block
        catch (NumberFormatException e)
        { }
        catch (NullPointerException e)
        { }
        {
            String authorityName;
            authorityName = parser.getAttributeValue(null, "authority");
            String enabled;
            enabled = parser.getAttributeValue(null, "enabled");
            String syncable;
            syncable = parser.getAttributeValue(null, "syncable");
            String accountName;
            accountName = parser.getAttributeValue(null, "account");
            String accountType;
            accountType = parser.getAttributeValue(null, "type");
            {
                accountType = "com.google";
                syncable = "unknown";
            } //End block
            authority = mAuthorities.get(id);
            {
                authority = getOrCreateAuthorityLocked(
                        new Account(accountName, accountType), authorityName, id, false);
                {
                    authority.periodicSyncs.clear();
                } //End block
            } //End block
            {
                authority.enabled = enabled == null || Boolean.parseBoolean(enabled);
                {
                    boolean var027FB36D6559BE640F92C42FB7594DF3_748636819 = ("unknown".equals(syncable));
                    {
                        authority.syncable = -1;
                    } //End block
                    {
                        authority.syncable =
                            (syncable == null || Boolean.parseBoolean(syncable)) ? 1 : 0;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (AuthorityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.502 -0400", hash_original_method = "5B7C41C6008D60C9ED6FB4C92797A204", hash_generated_method = "136B602DE69E1969EF4B3FC301B78696")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Pair<Bundle, Long> parsePeriodicSync(XmlPullParser parser, AuthorityInfo authority) {
        dsTaint.addTaint(authority.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        Bundle extras;
        extras = new Bundle();
        String periodValue;
        periodValue = parser.getAttributeValue(null, "period");
        long period;
        try 
        {
            period = Long.parseLong(periodValue);
        } //End block
        catch (NumberFormatException e)
        { }
        catch (NullPointerException e)
        { }
        Pair<Bundle, Long> periodicSync;
        periodicSync = Pair.create(extras, period);
        authority.periodicSyncs.add(periodicSync);
        return (Pair<Bundle, Long>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.503 -0400", hash_original_method = "63A9A531A6D6EE37322509C7D60C0471", hash_generated_method = "6C76A9C8E6C99DA3A6FA00367E3F3365")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseExtra(XmlPullParser parser, Pair<Bundle, Long> periodicSync) {
        dsTaint.addTaint(periodicSync.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        Bundle extras;
        extras = periodicSync.first;
        String name;
        name = parser.getAttributeValue(null, "name");
        String type;
        type = parser.getAttributeValue(null, "type");
        String value1;
        value1 = parser.getAttributeValue(null, "value1");
        String value2;
        value2 = parser.getAttributeValue(null, "value2");
        try 
        {
            {
                boolean varDD72CE6C923B2C5C27D9875CF4A69477_1512912350 = ("long".equals(type));
                {
                    extras.putLong(name, Long.parseLong(value1));
                } //End block
                {
                    boolean var92E69FEE619C318BEAB02B74B850DC0B_763583659 = ("integer".equals(type));
                    {
                        extras.putInt(name, Integer.parseInt(value1));
                    } //End block
                    {
                        boolean varC6FD6E09CB45BCC6DA80980705939B8F_1186377064 = ("double".equals(type));
                        {
                            extras.putDouble(name, Double.parseDouble(value1));
                        } //End block
                        {
                            boolean varE4C0E91817A60C38997ADE7700F8DE59_810422044 = ("float".equals(type));
                            {
                                extras.putFloat(name, Float.parseFloat(value1));
                            } //End block
                            {
                                boolean var5FBDFDF4488B4DEBB40B64CB4E65062D_760429670 = ("boolean".equals(type));
                                {
                                    extras.putBoolean(name, Boolean.parseBoolean(value1));
                                } //End block
                                {
                                    boolean var65AB3E0236299C8A696297D0A7F44196_1145848686 = ("string".equals(type));
                                    {
                                        extras.putString(name, value1);
                                    } //End block
                                    {
                                        boolean varF44E655240B90E6EC37D2E6505C82828_972966648 = ("account".equals(type));
                                        {
                                            extras.putParcelable(name, new Account(value1, value2));
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        catch (NumberFormatException e)
        { }
        catch (NullPointerException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.581 -0400", hash_original_method = "D0303AA7EB859F30BDBC9813BB120707", hash_generated_method = "CA4D1941C2962632140A320C829CEB65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeAccountInfoLocked() {
        FileOutputStream fos;
        fos = null;
        try 
        {
            fos = mAccountInfoFile.startWrite();
            XmlSerializer out;
            out = new FastXmlSerializer();
            out.setOutput(fos, "utf-8");
            out.startDocument(null, true);
            out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            out.startTag(null, "accounts");
            out.attribute(null, "version", Integer.toString(ACCOUNTS_VERSION));
            out.attribute(null, "nextAuthorityId", Integer.toString(mNextAuthorityId));
            {
                out.attribute(null, "listen-for-tickles", "false");
            } //End block
            int N;
            N = mAuthorities.size();
            {
                int i;
                i = 0;
                {
                    AuthorityInfo authority;
                    authority = mAuthorities.valueAt(i);
                    out.startTag(null, "authority");
                    out.attribute(null, "id", Integer.toString(authority.ident));
                    out.attribute(null, "account", authority.account.name);
                    out.attribute(null, "type", authority.account.type);
                    out.attribute(null, "authority", authority.authority);
                    out.attribute(null, "enabled", Boolean.toString(authority.enabled));
                    {
                        out.attribute(null, "syncable", "unknown");
                    } //End block
                    {
                        out.attribute(null, "syncable", Boolean.toString(authority.syncable != 0));
                    } //End block
                    {
                        Iterator<Pair<Bundle, Long>> var725959591153CF92A3D3E1B2B1738C17_1606520684 = (authority.periodicSyncs).iterator();
                        var725959591153CF92A3D3E1B2B1738C17_1606520684.hasNext();
                        Pair<Bundle, Long> periodicSync = var725959591153CF92A3D3E1B2B1738C17_1606520684.next();
                        {
                            out.startTag(null, "periodicSync");
                            out.attribute(null, "period", Long.toString(periodicSync.second));
                            Bundle extras;
                            extras = periodicSync.first;
                            {
                                Iterator<String> var1C78A364843D411FE3AA79BFC80E36AA_33704008 = (extras.keySet()).iterator();
                                var1C78A364843D411FE3AA79BFC80E36AA_33704008.hasNext();
                                String key = var1C78A364843D411FE3AA79BFC80E36AA_33704008.next();
                                {
                                    out.startTag(null, "extra");
                                    out.attribute(null, "name", key);
                                    Object value;
                                    value = extras.get(key);
                                    {
                                        out.attribute(null, "type", "long");
                                        out.attribute(null, "value1", value.toString());
                                    } //End block
                                    {
                                        out.attribute(null, "type", "integer");
                                        out.attribute(null, "value1", value.toString());
                                    } //End block
                                    {
                                        out.attribute(null, "type", "boolean");
                                        out.attribute(null, "value1", value.toString());
                                    } //End block
                                    {
                                        out.attribute(null, "type", "float");
                                        out.attribute(null, "value1", value.toString());
                                    } //End block
                                    {
                                        out.attribute(null, "type", "double");
                                        out.attribute(null, "value1", value.toString());
                                    } //End block
                                    {
                                        out.attribute(null, "type", "string");
                                        out.attribute(null, "value1", value.toString());
                                    } //End block
                                    {
                                        out.attribute(null, "type", "account");
                                        out.attribute(null, "value1", ((Account)value).name);
                                        out.attribute(null, "value2", ((Account)value).type);
                                    } //End block
                                    out.endTag(null, "extra");
                                } //End block
                            } //End collapsed parenthetic
                            out.endTag(null, "periodicSync");
                        } //End block
                    } //End collapsed parenthetic
                    out.endTag(null, "authority");
                } //End block
            } //End collapsed parenthetic
            out.endTag(null, "accounts");
            out.endDocument();
            mAccountInfoFile.finishWrite(fos);
        } //End block
        catch (java.io.IOException e1)
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.584 -0400", hash_original_method = "96B84444EEB95F8262A1F514B70427CB", hash_generated_method = "17289971AD3413EE5B5C90541DA25E55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readAndDeleteLegacyAccountInfoLocked() {
        File file;
        file = mContext.getDatabasePath("syncmanager.db");
        {
            boolean varE02387E0421DAF07E6582975BDA6A5F5_466316010 = (!file.exists());
        } //End collapsed parenthetic
        String path;
        path = file.getPath();
        SQLiteDatabase db;
        db = null;
        try 
        {
            db = SQLiteDatabase.openDatabase(path, null,
                    SQLiteDatabase.OPEN_READONLY);
        } //End block
        catch (SQLiteException e)
        { }
        {
            boolean hasType;
            hasType = db.getVersion() >= 11;
            SQLiteQueryBuilder qb;
            qb = new SQLiteQueryBuilder();
            qb.setTables("stats, status");
            HashMap<String,String> map;
            map = new HashMap<String,String>();
            map.put("_id", "status._id as _id");
            map.put("account", "stats.account as account");
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
            Cursor c;
            c = qb.query(db, null, null, null, null, null, null);
            {
                boolean var4D86B3BFFD03EEDEB3FCD4358BA0EB15_1462719586 = (c.moveToNext());
                {
                    String accountName;
                    accountName = c.getString(c.getColumnIndex("account"));
                    String accountType;
                    accountType = c.getString(c.getColumnIndex("account_type"));
                    accountType = null;
                    {
                        accountType = "com.google";
                    } //End block
                    String authorityName;
                    authorityName = c.getString(c.getColumnIndex("authority"));
                    AuthorityInfo authority;
                    authority = this.getOrCreateAuthorityLocked(
                        new Account(accountName, accountType),
                        authorityName, -1, false);
                    {
                        int i;
                        i = mSyncStatus.size();
                        boolean found;
                        found = false;
                        SyncStatusInfo st;
                        st = null;
                        {
                            st = mSyncStatus.valueAt(i);
                            {
                                found = true;
                            } //End block
                        } //End block
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
            } //End collapsed parenthetic
            c.close();
            qb = new SQLiteQueryBuilder();
            qb.setTables("settings");
            c = qb.query(db, null, null, null, null, null, null);
            {
                boolean var4D86B3BFFD03EEDEB3FCD4358BA0EB15_1071315306 = (c.moveToNext());
                {
                    String name;
                    name = c.getString(c.getColumnIndex("name"));
                    String value;
                    value = c.getString(c.getColumnIndex("value"));
                    {
                        boolean varE7D17AC8C521E3212FFC5FCB3ACDBEA6_27193754 = (name.equals("listen_for_tickles"));
                        {
                            setMasterSyncAutomatically(value == null || Boolean.parseBoolean(value));
                        } //End block
                        {
                            boolean var2D5B49D8F7F94D0F096FA4A79CB462D9_462050439 = (name.startsWith("sync_provider_"));
                            {
                                String provider;
                                provider = name.substring("sync_provider_".length(),
                            name.length());
                                int i;
                                i = mAuthorities.size();
                                {
                                    AuthorityInfo authority;
                                    authority = mAuthorities.valueAt(i);
                                    {
                                        boolean var9128AE8AE03D18D596BA8FDC14FB9F77_1730760735 = (authority.authority.equals(provider));
                                        {
                                            authority.enabled = value == null || Boolean.parseBoolean(value);
                                            authority.syncable = 1;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            c.close();
            db.close();
            (new File(path)).delete();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.585 -0400", hash_original_method = "8A0C770C89ACE123AD07688E6EE32DB8", hash_generated_method = "05853A54B3AB6173217CBD861B7E4C82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readStatusLocked() {
        try 
        {
            byte[] data;
            data = mStatusFile.readFully();
            Parcel in;
            in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            int token;
            {
                boolean var20DE3378D869FED209202FBBB28E4D26_1355273063 = ((token=in.readInt()) != STATUS_FILE_END);
                {
                    {
                        SyncStatusInfo status;
                        status = new SyncStatusInfo(in);
                        {
                            boolean varCE4B6671B92DDEA8B8BD9E923335E747_1986784862 = (mAuthorities.indexOfKey(status.authorityId) >= 0);
                            {
                                status.pending = false;
                                mSyncStatus.put(status.authorityId, status);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (java.io.IOException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.586 -0400", hash_original_method = "74BDFC1296AA332718133078DAF25C56", hash_generated_method = "D86B35BA5472464187075441B26A4A75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeStatusLocked() {
        removeMessages(MSG_WRITE_STATUS);
        FileOutputStream fos;
        fos = null;
        try 
        {
            fos = mStatusFile.startWrite();
            Parcel out;
            out = Parcel.obtain();
            int N;
            N = mSyncStatus.size();
            {
                int i;
                i = 0;
                {
                    SyncStatusInfo status;
                    status = mSyncStatus.valueAt(i);
                    out.writeInt(STATUS_FILE_ITEM);
                    status.writeToParcel(out, 0);
                } //End block
            } //End collapsed parenthetic
            out.writeInt(STATUS_FILE_END);
            fos.write(out.marshall());
            out.recycle();
            mStatusFile.finishWrite(fos);
        } //End block
        catch (java.io.IOException e1)
        {
            {
                mStatusFile.failWrite(fos);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.588 -0400", hash_original_method = "1231AB171DBB37761A49B7E20056B86A", hash_generated_method = "8282FDEA2EA6F4E6E31CBB8E893F6DD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readPendingOperationsLocked() {
        try 
        {
            byte[] data;
            data = mPendingFile.readFully();
            Parcel in;
            in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            int SIZE;
            SIZE = in.dataSize();
            {
                boolean var2DA2E27409709F023B8B17940C59F476_1521296931 = (in.dataPosition() < SIZE);
                {
                    int version;
                    version = in.readInt();
                    int authorityId;
                    authorityId = in.readInt();
                    int syncSource;
                    syncSource = in.readInt();
                    byte[] flatExtras;
                    flatExtras = in.createByteArray();
                    boolean expedited;
                    {
                        expedited = in.readInt() != 0;
                    } //End block
                    {
                        expedited = false;
                    } //End block
                    AuthorityInfo authority;
                    authority = mAuthorities.get(authorityId);
                    {
                        Bundle extras;
                        {
                            extras = unflattenBundle(flatExtras);
                        } //End block
                        {
                            extras = new Bundle();
                        } //End block
                        PendingOperation op;
                        op = new PendingOperation(
                            authority.account, syncSource,
                            authority.authority, extras, expedited);
                        op.authorityId = authorityId;
                        op.flatExtras = flatExtras;
                        mPendingOperations.add(op);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (java.io.IOException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.588 -0400", hash_original_method = "0152B02FFEBFCD8F723BAE9C7F6EE92A", hash_generated_method = "E354D8612D51C166E9D92ED580F00414")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writePendingOperationLocked(PendingOperation op, Parcel out) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(out.dsTaint);
        out.writeInt(PENDING_OPERATION_VERSION);
        out.writeInt(op.authorityId);
        out.writeInt(op.syncSource);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.589 -0400", hash_original_method = "B08FC5F8DD5CA36D6F4DD131B7753109", hash_generated_method = "97A2EA752510E38E87C757DCD51855A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writePendingOperationsLocked() {
        int N;
        N = mPendingOperations.size();
        FileOutputStream fos;
        fos = null;
        try 
        {
            {
                mPendingFile.truncate();
            } //End block
            fos = mPendingFile.startWrite();
            Parcel out;
            out = Parcel.obtain();
            {
                int i;
                i = 0;
                {
                    PendingOperation op;
                    op = mPendingOperations.get(i);
                    writePendingOperationLocked(op, out);
                } //End block
            } //End collapsed parenthetic
            fos.write(out.marshall());
            out.recycle();
            mPendingFile.finishWrite(fos);
        } //End block
        catch (java.io.IOException e1)
        {
            {
                mPendingFile.failWrite(fos);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.589 -0400", hash_original_method = "3B9D2CCD4E7B33665C76FD82482A168C", hash_generated_method = "FEACABB20A278D7FA226210B13A39B37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendPendingOperationLocked(PendingOperation op) {
        dsTaint.addTaint(op.dsTaint);
        FileOutputStream fos;
        fos = null;
        try 
        {
            fos = mPendingFile.openAppend();
        } //End block
        catch (java.io.IOException e)
        {
            writePendingOperationsLocked();
        } //End block
        try 
        {
            Parcel out;
            out = Parcel.obtain();
            writePendingOperationLocked(op, out);
            fos.write(out.marshall());
            out.recycle();
        } //End block
        catch (java.io.IOException e1)
        { }
        finally 
        {
            try 
            {
                fos.close();
            } //End block
            catch (java.io.IOException e2)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.590 -0400", hash_original_method = "EF23341A4D9A5255D7511F96FA9CF980", hash_generated_method = "FE1AB8E6B041B182FF01B9982B4C1FF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readStatisticsLocked() {
        try 
        {
            byte[] data;
            data = mStatisticsFile.readFully();
            Parcel in;
            in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            int token;
            int index;
            index = 0;
            {
                boolean var8ECFD84E493B489FCB77966C40A1A2F0_52558079 = ((token=in.readInt()) != STATISTICS_FILE_END);
                {
                    {
                        int day;
                        day = in.readInt();
                        {
                            day = day - 2009 + 14245;
                        } //End block
                        DayStats ds;
                        ds = new DayStats(day);
                        ds.successCount = in.readInt();
                        ds.successTime = in.readLong();
                        ds.failureCount = in.readInt();
                        ds.failureTime = in.readLong();
                        {
                            mDayStats[index] = ds;
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (java.io.IOException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.591 -0400", hash_original_method = "FBD3A634F75EF390904BDDFD24CE73C8", hash_generated_method = "123DB35E513046FB91ACCFABB98C42C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeStatisticsLocked() {
        removeMessages(MSG_WRITE_STATISTICS);
        FileOutputStream fos;
        fos = null;
        try 
        {
            fos = mStatisticsFile.startWrite();
            Parcel out;
            out = Parcel.obtain();
            int N;
            N = mDayStats.length;
            {
                int i;
                i = 0;
                {
                    DayStats ds;
                    ds = mDayStats[i];
                    out.writeInt(STATISTICS_FILE_ITEM);
                    out.writeInt(ds.day);
                    out.writeInt(ds.successCount);
                    out.writeLong(ds.successTime);
                    out.writeInt(ds.failureCount);
                    out.writeLong(ds.failureTime);
                } //End block
            } //End collapsed parenthetic
            out.writeInt(STATISTICS_FILE_END);
            fos.write(out.marshall());
            out.recycle();
            mStatisticsFile.finishWrite(fos);
        } //End block
        catch (java.io.IOException e1)
        {
            {
                mStatisticsFile.failWrite(fos);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class PendingOperation {
        Account account;
        int syncSource;
        String authority;
        Bundle extras;
        boolean expedited;
        int authorityId;
        byte[] flatExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.592 -0400", hash_original_method = "EF059F8E3294963F1E848A9313768B5B", hash_generated_method = "D99E70EBEC40637EB84A433836ADF385")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PendingOperation(Account account, int source,
                String authority, Bundle extras, boolean expedited) {
            dsTaint.addTaint(authority);
            dsTaint.addTaint(source);
            dsTaint.addTaint(account.dsTaint);
            dsTaint.addTaint(expedited);
            dsTaint.addTaint(extras.dsTaint);
            this.extras = extras != null ? new Bundle(extras) : extras;
            this.authorityId = -1;
            // ---------- Original Method ----------
            //this.account = account;
            //this.syncSource = source;
            //this.authority = authority;
            //this.extras = extras != null ? new Bundle(extras) : extras;
            //this.expedited = expedited;
            //this.authorityId = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.592 -0400", hash_original_method = "1B5DBB8810EC174C356BDFB975D9E53C", hash_generated_method = "12683492BACBF2C850B5A9FE9101AB2C")
        @DSModeled(DSC.SAFE)
         PendingOperation(PendingOperation other) {
            dsTaint.addTaint(other.dsTaint);
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
        Account account;
        HashMap<String, AuthorityInfo> authorities =
                new HashMap<String, AuthorityInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.594 -0400", hash_original_method = "0A42050331BE326DBD226E8BF4C55827", hash_generated_method = "1EE369603CA2F02DD094B7FA4801308B")
        @DSModeled(DSC.SAFE)
         AccountInfo(Account account) {
            dsTaint.addTaint(account.dsTaint);
            // ---------- Original Method ----------
            //this.account = account;
        }

        
    }


    
    public static class AuthorityInfo {
        Account account;
        String authority;
        int ident;
        boolean enabled;
        int syncable;
        long backoffTime;
        long backoffDelay;
        long delayUntil;
        ArrayList<Pair<Bundle, Long>> periodicSyncs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.594 -0400", hash_original_method = "F1AF0EF8567860728BE1920368DC5483", hash_generated_method = "C30480969D20ADCCBB5F6FDE9F49BDCC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AuthorityInfo(Account account, String authority, int ident) {
            dsTaint.addTaint(authority);
            dsTaint.addTaint(ident);
            dsTaint.addTaint(account.dsTaint);
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
        int authorityId;
        int historyId;
        long eventTime;
        long elapsedTime;
        int source;
        int event;
        long upstreamActivity;
        long downstreamActivity;
        String mesg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.594 -0400", hash_original_method = "693C2E258156E36EC333F31418F3CAF9", hash_generated_method = "693C2E258156E36EC333F31418F3CAF9")
                public SyncHistoryItem ()
        {
        }


    }


    
    public static class DayStats {
        public int day;
        public int successCount;
        public long successTime;
        public int failureCount;
        public long failureTime;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.595 -0400", hash_original_method = "59D9CE47C9B58BC0ECFC5F57173A8EB8", hash_generated_method = "3D3D25E026264AE7BEDF293D6E6F4932")
        @DSModeled(DSC.SAFE)
        public DayStats(int day) {
            dsTaint.addTaint(day);
            // ---------- Original Method ----------
            //this.day = day;
        }

        
    }


    
    private static final String TAG = "SyncManager";
    private static final boolean DEBUG_FILE = false;
    private static final long DEFAULT_POLL_FREQUENCY_SECONDS = 60 * 60 * 24;
    static final long MILLIS_IN_4WEEKS = 1000L * 60 * 60 * 24 * 7 * 4;
    public static final int EVENT_START = 0;
    public static final int EVENT_STOP = 1;
    public static final String[] EVENTS = { "START", "STOP" };
    public static final int SOURCE_SERVER = 0;
    public static final int SOURCE_LOCAL = 1;
    public static final int SOURCE_POLL = 2;
    public static final int SOURCE_USER = 3;
    public static final int SOURCE_PERIODIC = 4;
    public static final long NOT_IN_BACKOFF_MODE = -1;
    public static final Intent SYNC_CONNECTION_SETTING_CHANGED_INTENT =
            new Intent("com.android.sync.SYNC_CONN_STATUS_CHANGED");
    public static final String[] SOURCES = { "SERVER",
                                             "LOCAL",
                                             "POLL",
                                             "USER",
                                             "PERIODIC" };
    public static final String MESG_SUCCESS = "success";
    public static final String MESG_CANCELED = "canceled";
    public static final int MAX_HISTORY = 100;
    private static final int MSG_WRITE_STATUS = 1;
    private static final long WRITE_STATUS_DELAY = 1000*60*10;
    private static final int MSG_WRITE_STATISTICS = 2;
    private static final long WRITE_STATISTICS_DELAY = 1000*60*30;
    private static final boolean SYNC_ENABLED_DEFAULT = false;
    private static final int ACCOUNTS_VERSION = 2;
    private static HashMap<String, String> sAuthorityRenames;
    static {
        sAuthorityRenames = new HashMap<String, String>();
        sAuthorityRenames.put("contacts", "com.android.contacts");
        sAuthorityRenames.put("calendar", "com.android.calendar");
    }
    
    private static volatile SyncStorageEngine sSyncStorageEngine = null;
    private static final int PENDING_FINISH_TO_WRITE = 4;
    public static final int STATUS_FILE_END = 0;
    public static final int STATUS_FILE_ITEM = 100;
    public static final int PENDING_OPERATION_VERSION = 2;
    public static final int STATISTICS_FILE_END = 0;
    public static final int STATISTICS_FILE_ITEM_OLD = 100;
    public static final int STATISTICS_FILE_ITEM = 101;
}

