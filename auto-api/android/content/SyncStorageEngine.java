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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "ADB03CF0C832D5859AE5ED806F964C77", hash_generated_field = "DCD9F929FBF293182CD7E5CC415D1656")

    private final SparseArray<AuthorityInfo> mAuthorities = new SparseArray<AuthorityInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "6F418588A388F83463153149CC4DFD2D", hash_generated_field = "4B36B4FEA0D3DAD8CB7109B7DAFD4F0B")

    private final HashMap<Account, AccountInfo> mAccounts = new HashMap<Account, AccountInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "18B6C8007607AB89FE5846E3CCD3D634", hash_generated_field = "9061F8B36C87BD05CB7B61BC05EEA80D")

    private final ArrayList<PendingOperation> mPendingOperations = new ArrayList<PendingOperation>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "42932EF0A1E3F7A4D563C5857A83A6DC", hash_generated_field = "17DF250BDACB991A8443A6BC974E4CEF")

    private final ArrayList<SyncInfo> mCurrentSyncs = new ArrayList<SyncInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "BA03FCA3B2DAC61378D307CC61745CC1", hash_generated_field = "BB2BD481DA5E1951BA328BC00E9DDD6F")

    private final SparseArray<SyncStatusInfo> mSyncStatus = new SparseArray<SyncStatusInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "39E6D04F8E50FBD9E462DB47F9370F10", hash_generated_field = "6703D3447B5F81BE530922662FF9E2F7")

    private final ArrayList<SyncHistoryItem> mSyncHistory = new ArrayList<SyncHistoryItem>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "142C9D318C79A6D06C86E91880369682", hash_generated_field = "A61DFE30C0F235AC0390EF8C97D18E24")

    private final RemoteCallbackList<ISyncStatusObserver> mChangeListeners = new RemoteCallbackList<ISyncStatusObserver>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "52D842D195FB9682477C5FF881B743BC", hash_generated_field = "2AE16416F500BFCB1C37E3AB89C8BDC4")

    private int mNextAuthorityId = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "C2685A226EA5E2F07642AFF82B25E12A", hash_generated_field = "02779B60A3F80DE35E35BF0C5E0C43DC")

    private final DayStats[] mDayStats = new DayStats[7*4];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "8B91D41DBF7940D3997855F383F055BC", hash_generated_field = "EC9191FB914117C63C6512ED98BDDA48")

    private Calendar mCal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "11D990E1A246B4FE4069EE207D869D9B", hash_generated_field = "0FB397B5159C15D66CFFB31661F31030")

    private int mYear;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "F2671D7F7646AB869D7AD2D7ECDF3004", hash_generated_field = "254F77756F02336521F67E6CA24B1E30")

    private int mYearInDays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "BC6D4641305DCB897A44E04BF204E566", hash_generated_field = "5D75657BE40E89D85D7C2D95C6C03670")

    private AtomicFile mAccountInfoFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "0D0C7FE26E394EF5D9ADF7B5612C8E5E", hash_generated_field = "BFFE61A45AAFF20D720253FB7EAF94E2")

    private AtomicFile mStatusFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.651 -0400", hash_original_field = "C3BB0594E53D1E317FBB3F2CBD55F6B6", hash_generated_field = "B21C478C853D31055421796340DF7AB7")

    private AtomicFile mStatisticsFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.652 -0400", hash_original_field = "16486C7724FFC2223BF73F2E2F294953", hash_generated_field = "3E80DAA8531C0F48AE799261DF00CB4E")

    private AtomicFile mPendingFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.652 -0400", hash_original_field = "56DBA3F4696B0CF5DBF626A8CADC263A", hash_generated_field = "8ECC4C420766F27F9F3D44633E206229")

    private int mNumPendingFinished = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.652 -0400", hash_original_field = "56FD212A9532273FAE1D547FB3CF9D7F", hash_generated_field = "F7ED6F40F4F31B59A250911223633F4B")

    private int mNextHistoryId = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.652 -0400", hash_original_field = "EB99626AD7B7425DAEE7A7B65005D931", hash_generated_field = "EBA144569AB4B50BF3932F380E591D51")

    private boolean mMasterSyncAutomatically = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.653 -0400", hash_original_method = "A6EFE710C6881152489583C4A465D2CD", hash_generated_method = "ADA56579C518A107013890A945E79D02")
    private  SyncStorageEngine(Context context, File dataDir) {
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
        addTaint(dataDir.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.654 -0400", hash_original_method = "4DFC4B128F767AF6A0DE11433A3D7DB7", hash_generated_method = "B88421C78CEAFB22F3635936C216FD06")
    @Override
    public void handleMessage(Message msg) {
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
        addTaint(msg.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.655 -0400", hash_original_method = "52497A49330565A574CE17BDC87E49EE", hash_generated_method = "D6F0FCCDB32B98438C438DA7AD9D32B7")
    public void addStatusChangeListener(int mask, ISyncStatusObserver callback) {
        {
            mChangeListeners.register(callback, mask);
        } //End block
        addTaint(mask);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //mChangeListeners.register(callback, mask);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.656 -0400", hash_original_method = "6F129CA4CBCD6FCA8FC01A242206CA3D", hash_generated_method = "B06800946810D992A24298D18D6C8549")
    public void removeStatusChangeListener(ISyncStatusObserver callback) {
        {
            mChangeListeners.unregister(callback);
        } //End block
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //mChangeListeners.unregister(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.657 -0400", hash_original_method = "08D269D186E562E9C4A4640195EC72C3", hash_generated_method = "67D74892B6791B8E31E7EEC782E8C548")
    private void reportChange(int which) {
        ArrayList<ISyncStatusObserver> reports = null;
        {
            int i = mChangeListeners.beginBroadcast();
            {
                Integer mask = (Integer)mChangeListeners.getBroadcastCookie(i);
                {
                    boolean varE554679AEFB26BBFE81E55728FC56571_1509993059 = ((which & mask.intValue()) == 0);
                } //End collapsed parenthetic
                {
                    reports = new ArrayList<ISyncStatusObserver>(i);
                } //End block
                reports.add(mChangeListeners.getBroadcastItem(i));
            } //End block
            mChangeListeners.finishBroadcast();
        } //End block
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_2137404277 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        {
            int i = reports.size();
            {
                try 
                {
                    reports.get(i).onStatusChanged(which);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End block
        addTaint(which);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.657 -0400", hash_original_method = "1E3EB54BE416021CC2FC55EA818E4E21", hash_generated_method = "8AF377B723CB1D2225571265BC2E61D8")
    public boolean getSyncAutomatically(Account account, String providerName) {
        {
            {
                AuthorityInfo authority = getAuthorityLocked(account, providerName,
                        "getSyncAutomatically");
            } //End block
            int i = mAuthorities.size();
            {
                AuthorityInfo authority = mAuthorities.valueAt(i);
                {
                    boolean var33EA43D11F897A66D89A3322392338FC_1068997807 = (authority.authority.equals(providerName)
                        && authority.enabled);
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1952406267 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1952406267;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.658 -0400", hash_original_method = "581987DB149A8DCAC958F242477B1863", hash_generated_method = "54A99874E76BF77A620C84BC00BA449E")
    public void setSyncAutomatically(Account account, String providerName, boolean sync) {
        Log.d(TAG, "setSyncAutomatically: " +  ", provider " + providerName
                + " -> " + sync);
        {
            AuthorityInfo authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
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
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        addTaint(sync);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.658 -0400", hash_original_method = "669A99F5C38004FBAED3A18D6E12F4E4", hash_generated_method = "A9A49971E5BF2FFAF31D7253A3000FDE")
    public int getIsSyncable(Account account, String providerName) {
        {
            {
                AuthorityInfo authority = getAuthorityLocked(account, providerName,
                        "getIsSyncable");
            } //End block
            int i = mAuthorities.size();
            {
                AuthorityInfo authority = mAuthorities.valueAt(i);
                {
                    boolean varEF28C7BAAADDB173897911934E03D1CA_1764573798 = (authority.authority.equals(providerName));
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907919642 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907919642;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.659 -0400", hash_original_method = "F95D35FA2526F2113282D0AA6609AE27", hash_generated_method = "9F58086518ABE3DA7EAB1A2B9E06FFBB")
    public void setIsSyncable(Account account, String providerName, int syncable) {
        {
            syncable = 1;
        } //End block
        {
            syncable = -1;
        } //End block
        Log.d(TAG, "setIsSyncable: " + account + ", provider " + providerName + " -> " + syncable);
        {
            AuthorityInfo authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
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
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        addTaint(syncable);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.660 -0400", hash_original_method = "8DC1822E61630B36C083348F9F85FD1C", hash_generated_method = "A3A37B4DB8D28CCA07123E3B12148AE3")
    public Pair<Long, Long> getBackoff(Account account, String providerName) {
        Pair<Long, Long> varB4EAC82CA7396A68D541C85D26508E83_931694943 = null; //Variable for return #1
        Pair<Long, Long> varB4EAC82CA7396A68D541C85D26508E83_719437318 = null; //Variable for return #2
        {
            AuthorityInfo authority = getAuthorityLocked(account, providerName, "getBackoff");
            {
                varB4EAC82CA7396A68D541C85D26508E83_931694943 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_719437318 = Pair.create(authority.backoffTime, authority.backoffDelay);
        } //End block
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        Pair<Long, Long> varA7E53CE21691AB073D9660D615818899_95635031; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_95635031 = varB4EAC82CA7396A68D541C85D26508E83_931694943;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_95635031 = varB4EAC82CA7396A68D541C85D26508E83_719437318;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_95635031.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_95635031;
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //AuthorityInfo authority = getAuthorityLocked(account, providerName, "getBackoff");
            //if (authority == null || authority.backoffTime < 0) {
                //return null;
            //}
            //return Pair.create(authority.backoffTime, authority.backoffDelay);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.686 -0400", hash_original_method = "470D6F06A561962AAC0558CECDD66F24", hash_generated_method = "8CB3B79C85D4DFBE6532BBC37756E547")
    public void setBackoff(Account account, String providerName,
            long nextSyncTime, long nextDelay) {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_1522037256 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        boolean changed = false;
        {
            {
                {
                    Iterator<AccountInfo> varE1E200902F2EC8CF97AC01C00096CA75_1859737553 = (mAccounts.values()).iterator();
                    varE1E200902F2EC8CF97AC01C00096CA75_1859737553.hasNext();
                    AccountInfo accountInfo = varE1E200902F2EC8CF97AC01C00096CA75_1859737553.next();
                    {
                        {
                            boolean varFD1A97EAEF8E1FEECFE35676892986DC_910267007 = (account != null && !account.equals(accountInfo.account));
                        } //End collapsed parenthetic
                        {
                            Iterator<AuthorityInfo> var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_1677788276 = (accountInfo.authorities.values()).iterator();
                            var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_1677788276.hasNext();
                            AuthorityInfo authorityInfo = var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_1677788276.next();
                            {
                                {
                                    boolean varB5086EA8B155D6133B13AFC701A614BF_528197561 = (providerName != null && !providerName.equals(authorityInfo.authority));
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
                AuthorityInfo authority = getOrCreateAuthorityLocked(account, providerName, -1 , true);
                authority.backoffTime = nextSyncTime;
                authority.backoffDelay = nextDelay;
                changed = true;
            } //End block
        } //End block
        {
            reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        } //End block
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        addTaint(nextSyncTime);
        addTaint(nextDelay);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.708 -0400", hash_original_method = "AFA2215C700770E680F9E8F54668F915", hash_generated_method = "BC7126B9B28AEC72793038B9BB6983DA")
    public void clearAllBackoffs(SyncQueue syncQueue) {
        boolean changed = false;
        {
            {
                Iterator<AccountInfo> varE1E200902F2EC8CF97AC01C00096CA75_305417464 = (mAccounts.values()).iterator();
                varE1E200902F2EC8CF97AC01C00096CA75_305417464.hasNext();
                AccountInfo accountInfo = varE1E200902F2EC8CF97AC01C00096CA75_305417464.next();
                {
                    {
                        Iterator<AuthorityInfo> var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_164851182 = (accountInfo.authorities.values()).iterator();
                        var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_164851182.hasNext();
                        AuthorityInfo authorityInfo = var1EAC2D0EB2F9A2E4E1C8E9AB99E99E78_164851182.next();
                        {
                            {
                                {
                                    boolean varB886653DBE5AD63346733F0FC6D36E19_503794716 = (Log.isLoggable(TAG, Log.VERBOSE));
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
        addTaint(syncQueue.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.709 -0400", hash_original_method = "4C9FEA1518FBFDF4D1B5258B0B2AE78D", hash_generated_method = "69D043889593872943FEF604828B0F89")
    public void setDelayUntilTime(Account account, String providerName, long delayUntil) {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_332658652 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        {
            AuthorityInfo authority = getOrCreateAuthorityLocked(
                    account, providerName, -1 , true);
            authority.delayUntil = delayUntil;
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        addTaint(delayUntil);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.710 -0400", hash_original_method = "DA0E26DF9B57177D554F116843CE820C", hash_generated_method = "64560DF476FD93EBF0AAA8F47004B9B5")
    public long getDelayUntilTime(Account account, String providerName) {
        {
            AuthorityInfo authority = getAuthorityLocked(account, providerName, "getDelayUntil");
        } //End block
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_617228641 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_617228641;
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //AuthorityInfo authority = getAuthorityLocked(account, providerName, "getDelayUntil");
            //if (authority == null) {
                //return 0;
            //}
            //return authority.delayUntil;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.711 -0400", hash_original_method = "DA5487F77FC92CA93809E84A1EE05946", hash_generated_method = "6EEA8B5E451491DB5B8706EF0796CC16")
    private void updateOrRemovePeriodicSync(Account account, String providerName, Bundle extras,
            long period, boolean add) {
        {
            period = 0;
        } //End block
        {
            extras = new Bundle();
        } //End block
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_1661971330 = (Log.isLoggable(TAG, Log.VERBOSE));
        } //End collapsed parenthetic
        {
            try 
            {
                AuthorityInfo authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
                {
                    boolean alreadyPresent = false;
                    {
                        int i = 0;
                        int N = authority.periodicSyncs.size();
                        {
                            Pair<Bundle, Long> syncInfo = authority.periodicSyncs.get(i);
                            final Bundle existingExtras = syncInfo.first;
                            {
                                boolean var88751FFF2C3301F2D44B054F25A9F46F_1882019217 = (equals(existingExtras, extras));
                                {
                                    authority.periodicSyncs.set(i, Pair.create(extras, period));
                                    alreadyPresent = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    {
                        authority.periodicSyncs.add(Pair.create(extras, period));
                        SyncStatusInfo status = getOrCreateSyncStatusLocked(authority.ident);
                        status.setPeriodicSyncTime(authority.periodicSyncs.size() - 1, 0);
                    } //End block
                } //End block
                {
                    SyncStatusInfo status = mSyncStatus.get(authority.ident);
                    boolean changed = false;
                    Iterator<Pair<Bundle, Long>> iterator = authority.periodicSyncs.iterator();
                    int i = 0;
                    {
                        boolean var084ACAAA0951413540CCF629674B7133_1832233864 = (iterator.hasNext());
                        {
                            Pair<Bundle, Long> syncInfo = iterator.next();
                            {
                                boolean var084DF2CEBB751D662F5E921D7F197876_1138742231 = (equals(syncInfo.first, extras));
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
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        addTaint(extras.getTaint());
        addTaint(period);
        addTaint(add);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.711 -0400", hash_original_method = "403A8311B76EBF44C870FFCE456B63FB", hash_generated_method = "B78D3616F1EC18CD9989FD8B8A0BFD9A")
    public void addPeriodicSync(Account account, String providerName, Bundle extras,
            long pollFrequency) {
        updateOrRemovePeriodicSync(account, providerName, extras, pollFrequency, true );
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        addTaint(extras.getTaint());
        addTaint(pollFrequency);
        // ---------- Original Method ----------
        //updateOrRemovePeriodicSync(account, providerName, extras, pollFrequency, true );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.712 -0400", hash_original_method = "A5551A39E3E716437015AA42AB9CA434", hash_generated_method = "C925FDD30635E761164C67C464A44111")
    public void removePeriodicSync(Account account, String providerName, Bundle extras) {
        updateOrRemovePeriodicSync(account, providerName, extras, 0 ,
                false );
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        addTaint(extras.getTaint());
        // ---------- Original Method ----------
        //updateOrRemovePeriodicSync(account, providerName, extras, 0 ,
                //false );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.719 -0400", hash_original_method = "43BA96B870E40929E429A78D83FB8F24", hash_generated_method = "D6E202A3331B849B3CCE409C1F5FCDD6")
    public List<PeriodicSync> getPeriodicSyncs(Account account, String providerName) {
        List<PeriodicSync> varB4EAC82CA7396A68D541C85D26508E83_1670649514 = null; //Variable for return #1
        ArrayList<PeriodicSync> syncs = new ArrayList<PeriodicSync>();
        {
            AuthorityInfo authority = getAuthorityLocked(account, providerName, "getPeriodicSyncs");
            {
                {
                    Iterator<Pair<Bundle, Long>> var98C61C5D42FC8213C1C6755E1467E764_586421158 = (authority.periodicSyncs).iterator();
                    var98C61C5D42FC8213C1C6755E1467E764_586421158.hasNext();
                    Pair<Bundle, Long> item = var98C61C5D42FC8213C1C6755E1467E764_586421158.next();
                    {
                        syncs.add(new PeriodicSync(account, providerName, item.first, item.second));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1670649514 = syncs;
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1670649514.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1670649514;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.721 -0400", hash_original_method = "AF0CE82B663D00FD098AAFE2F6E1B437", hash_generated_method = "6C2E914C3BF91920037F599B4ED60F02")
    public void setMasterSyncAutomatically(boolean flag) {
        {
            mMasterSyncAutomatically = flag;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.722 -0400", hash_original_method = "6DBCD9157A2DF54805879831F88D4B77", hash_generated_method = "55F49F79ADD3C5F46B2EC3E7C2756700")
    public boolean getMasterSyncAutomatically() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1026515873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1026515873;
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return mMasterSyncAutomatically;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.723 -0400", hash_original_method = "AC4455129C3CF5603625E4A23A44D091", hash_generated_method = "2C54C8B8D15B225E8D4E4D42E38E7A9B")
    public AuthorityInfo getOrCreateAuthority(Account account, String authority) {
        AuthorityInfo varB4EAC82CA7396A68D541C85D26508E83_1661173031 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1661173031 = getOrCreateAuthorityLocked(account, authority,
                    -1 ,
                    true );
        } //End block
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1661173031.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1661173031;
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return getOrCreateAuthorityLocked(account, authority,
                    //-1 ,
                    //true );
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.723 -0400", hash_original_method = "BAFC16DAE21D996A746903C6AB7A1E8C", hash_generated_method = "BF78FB383A10E889CC7B0681678B15EB")
    public void removeAuthority(Account account, String authority) {
        {
            removeAuthorityLocked(account, authority, true );
        } //End block
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //removeAuthorityLocked(account, authority, true );
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.725 -0400", hash_original_method = "B031DD2BDA31C86F4257F62895ABA1B2", hash_generated_method = "CBAAF4A3236BC06A3CA7AEE1FDC3A976")
    public AuthorityInfo getAuthority(int authorityId) {
        AuthorityInfo varB4EAC82CA7396A68D541C85D26508E83_808864917 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_808864917 = mAuthorities.get(authorityId);
        } //End block
        addTaint(authorityId);
        varB4EAC82CA7396A68D541C85D26508E83_808864917.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_808864917;
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return mAuthorities.get(authorityId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.742 -0400", hash_original_method = "F75815D4B05E7C78CBDEC7A3CDAC25FD", hash_generated_method = "7A8948C2F3463A077E2CDBC59FBD4141")
    public boolean isSyncActive(Account account, String authority) {
        {
            {
                Iterator<SyncInfo> varBF2E0DA70AF79DE7F1E948E32EFE3860_1501274980 = (mCurrentSyncs).iterator();
                varBF2E0DA70AF79DE7F1E948E32EFE3860_1501274980.hasNext();
                SyncInfo syncInfo = varBF2E0DA70AF79DE7F1E948E32EFE3860_1501274980.next();
                {
                    AuthorityInfo ainfo = getAuthority(syncInfo.authorityId);
                    {
                        boolean varAFEDDCA0914F4E52FA37E7A05672B6CB_1328013440 = (ainfo != null && ainfo.account.equals(account)
                        && ainfo.authority.equals(authority));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159098180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159098180;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.744 -0400", hash_original_method = "42358B0BF27AF155FB408124FA39D63B", hash_generated_method = "F15EDC054CED3C0A0588B0CD8DDB5EDC")
    public PendingOperation insertIntoPending(PendingOperation op) {
        PendingOperation varB4EAC82CA7396A68D541C85D26508E83_1198300569 = null; //Variable for return #1
        PendingOperation varB4EAC82CA7396A68D541C85D26508E83_1987970492 = null; //Variable for return #2
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_2076477906 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            AuthorityInfo authority = getOrCreateAuthorityLocked(op.account,
                    op.authority,
                    -1 ,
                    true );
            {
                varB4EAC82CA7396A68D541C85D26508E83_1198300569 = null;
            } //End block
            op = new PendingOperation(op);
            op.authorityId = authority.ident;
            mPendingOperations.add(op);
            appendPendingOperationLocked(op);
            SyncStatusInfo status = getOrCreateSyncStatusLocked(authority.ident);
            status.pending = true;
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        varB4EAC82CA7396A68D541C85D26508E83_1987970492 = op;
        addTaint(op.getTaint());
        PendingOperation varA7E53CE21691AB073D9660D615818899_33823072; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_33823072 = varB4EAC82CA7396A68D541C85D26508E83_1198300569;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_33823072 = varB4EAC82CA7396A68D541C85D26508E83_1987970492;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_33823072.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_33823072;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.746 -0400", hash_original_method = "50B189E2AFDD83FCD044E18708DDFA85", hash_generated_method = "C2B4AB45D02C54493D2E566202314AEA")
    public boolean deleteFromPending(PendingOperation op) {
        boolean res = false;
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_446605840 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            {
                boolean var22C92094F802A5404DB595143B36E95B_2082365635 = (mPendingOperations.remove(op));
                {
                    {
                        boolean var7A59FA2783DD5BD85E73BCF800C5CD5B_755609536 = (mPendingOperations.size() == 0
                        || mNumPendingFinished >= PENDING_FINISH_TO_WRITE);
                        {
                            writePendingOperationsLocked();
                            mNumPendingFinished = 0;
                        } //End block
                    } //End collapsed parenthetic
                    AuthorityInfo authority = getAuthorityLocked(op.account, op.authority,
                        "deleteFromPending");
                    {
                        {
                            boolean var0C9C1F857EF1208EE3C75B6103EF6F6E_332289516 = (Log.isLoggable(TAG, Log.VERBOSE));
                        } //End collapsed parenthetic
                        final int N = mPendingOperations.size();
                        boolean morePending = false;
                        {
                            int i = 0;
                            {
                                PendingOperation cur = mPendingOperations.get(i);
                                {
                                    boolean var3ADCD3264C59E0B1EE17FF97FBF35418_882371705 = (cur.account.equals(op.account)
                                && cur.authority.equals(op.authority));
                                    {
                                        morePending = true;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        {
                            {
                                boolean var406C81657E6030DC2B5474942FB17755_1664509425 = (Log.isLoggable(TAG, Log.VERBOSE));
                            } //End collapsed parenthetic
                            SyncStatusInfo status = getOrCreateSyncStatusLocked(authority.ident);
                            status.pending = false;
                        } //End block
                    } //End block
                    res = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_210863696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_210863696;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.747 -0400", hash_original_method = "B0FBF76821996DB4DA7D3758DC73EE90", hash_generated_method = "4173FA0DAA235598651CAD51F652822B")
    public int clearPending() {
        int num;
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1412274568 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            num = mPendingOperations.size();
            mPendingOperations.clear();
            final int N = mSyncStatus.size();
            {
                int i = 0;
                {
                    mSyncStatus.valueAt(i).pending = false;
                } //End block
            } //End collapsed parenthetic
            writePendingOperationsLocked();
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202872132 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202872132;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.748 -0400", hash_original_method = "C927FD207EDF022EE536945570AA8499", hash_generated_method = "50C0849EEE67F13FA52A1B3F5AE21661")
    public ArrayList<PendingOperation> getPendingOperations() {
        ArrayList<PendingOperation> varB4EAC82CA7396A68D541C85D26508E83_1665990727 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1665990727 = new ArrayList<PendingOperation>(mPendingOperations);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1665990727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1665990727;
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return new ArrayList<PendingOperation>(mPendingOperations);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.749 -0400", hash_original_method = "CC9059641F127440F6B10F04341F5D1E", hash_generated_method = "9CAF493A73A68F5D2D135C3CFDF86312")
    public int getPendingOperationCount() {
        {
            int var3B05F492CC93917538A1DEB47026045B_1805131254 = (mPendingOperations.size());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37469321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37469321;
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return mPendingOperations.size();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.782 -0400", hash_original_method = "38BC76D95CA0A954EB857B91A285A324", hash_generated_method = "1C8D5CC9DE9F8BC22D6FE3B8B52C26D1")
    public void doDatabaseCleanup(Account[] accounts) {
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1010267435 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            SparseArray<AuthorityInfo> removing = new SparseArray<AuthorityInfo>();
            Iterator<AccountInfo> accIt = mAccounts.values().iterator();
            {
                boolean var3FA577D82B1515639659819C370D49CE_1091822574 = (accIt.hasNext());
                {
                    AccountInfo acc = accIt.next();
                    {
                        boolean var5492D678E806FAA9F7E79AD749A0A01E_622017314 = (!ArrayUtils.contains(accounts, acc.account));
                        {
                            {
                                boolean var406C81657E6030DC2B5474942FB17755_1167719343 = (Log.isLoggable(TAG, Log.VERBOSE));
                            } //End collapsed parenthetic
                            {
                                Iterator<AuthorityInfo> var2DC806D12532DF6A8D484D851F207D3C_542176854 = (acc.authorities.values()).iterator();
                                var2DC806D12532DF6A8D484D851F207D3C_542176854.hasNext();
                                AuthorityInfo auth = var2DC806D12532DF6A8D484D851F207D3C_542176854.next();
                                {
                                    removing.put(auth.ident, auth);
                                } //End block
                            } //End collapsed parenthetic
                            accIt.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            int i = removing.size();
            {
                {
                    int ident = removing.keyAt(i);
                    mAuthorities.remove(ident);
                    int j = mSyncStatus.size();
                    {
                        {
                            boolean var98923AE1F6B1C2B259359E9FCA67D383_726918681 = (mSyncStatus.keyAt(j) == ident);
                            {
                                mSyncStatus.remove(mSyncStatus.keyAt(j));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    j = mSyncHistory.size();
                    {
                        {
                            boolean var18C8FAB6AF23CF51357B479AA00E94CE_1438439867 = (mSyncHistory.get(j).authorityId == ident);
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
        addTaint(accounts[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.783 -0400", hash_original_method = "1CDF6C9A1F9F2098201F4D7433D51EE7", hash_generated_method = "968D95423E752D3D92B539C5E7CD0417")
    public SyncInfo addActiveSync(SyncManager.ActiveSyncContext activeSyncContext) {
        SyncInfo varB4EAC82CA7396A68D541C85D26508E83_703821609 = null; //Variable for return #1
        SyncInfo syncInfo;
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1668553297 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
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
        varB4EAC82CA7396A68D541C85D26508E83_703821609 = syncInfo;
        addTaint(activeSyncContext.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_703821609.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_703821609;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.784 -0400", hash_original_method = "2B31DF94CF8024B200C12FFD3895E8BE", hash_generated_method = "615161FF69942ABD399EB2DAA3432B83")
    public void removeActiveSync(SyncInfo syncInfo) {
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_821159429 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            mCurrentSyncs.remove(syncInfo);
        } //End block
        reportActiveChange();
        addTaint(syncInfo.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.784 -0400", hash_original_method = "5624025FD66E34CEC2F994FDB502F76B", hash_generated_method = "4CF4CD5E23AE17353DE22949D91BFDC6")
    public void reportActiveChange() {
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_ACTIVE);
        // ---------- Original Method ----------
        //reportChange(ContentResolver.SYNC_OBSERVER_TYPE_ACTIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.786 -0400", hash_original_method = "7B7D2D5D3E7E0D062624D3006A76AABE", hash_generated_method = "3AD77278ED7A1B59E88E25A2B1FCD733")
    public long insertStartSyncEvent(Account accountName, String authorityName,
            long now, int source) {
        long id;
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1294047653 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            AuthorityInfo authority = getAuthorityLocked(accountName, authorityName,
                    "insertStartSyncEvent");
            SyncHistoryItem item = new SyncHistoryItem();
            item.authorityId = authority.ident;
            item.historyId = mNextHistoryId++;
            mNextHistoryId = 0;
            item.eventTime = now;
            item.source = source;
            item.event = EVENT_START;
            mSyncHistory.add(0, item);
            {
                boolean varF9A71BA7FA547CA258F7C7A61A733FEC_197606109 = (mSyncHistory.size() > MAX_HISTORY);
                {
                    mSyncHistory.remove(mSyncHistory.size()-1);
                } //End block
            } //End collapsed parenthetic
            id = item.historyId;
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_121677424 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_STATUS);
        addTaint(accountName.getTaint());
        addTaint(authorityName.getTaint());
        addTaint(now);
        addTaint(source);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1058970374 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1058970374;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.789 -0400", hash_original_method = "50B7DBCE95202763C50A27A5F5D2A2F4", hash_generated_method = "6A8CDA44759485298C52855E580DB7B3")
    public void stopSyncEvent(long historyId, long elapsedTime, String resultMessage,
            long downstreamActivity, long upstreamActivity) {
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1415809287 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            SyncHistoryItem item = null;
            int i = mSyncHistory.size();
            {
                item = mSyncHistory.get(i);
                item = null;
            } //End block
            item.elapsedTime = elapsedTime;
            item.event = EVENT_STOP;
            item.mesg = resultMessage;
            item.downstreamActivity = downstreamActivity;
            item.upstreamActivity = upstreamActivity;
            SyncStatusInfo status = getOrCreateSyncStatusLocked(item.authorityId);
            status.totalElapsedTime += elapsedTime;
            boolean writeStatisticsNow = false;
            int day = getCurrentDayLocked();
            {
                mDayStats[0] = new DayStats(day);
            } //End block
            {
                System.arraycopy(mDayStats, 0, mDayStats, 1, mDayStats.length-1);
                mDayStats[0] = new DayStats(day);
                writeStatisticsNow = true;
            } //End block
            final DayStats ds = mDayStats[0];
            final long lastSyncTime = (item.eventTime + elapsedTime);
            boolean writeStatusNow = false;
            {
                boolean var95BFB9B6109F7C0D5A26D3BAE919F8FF_925302683 = (MESG_SUCCESS.equals(resultMessage));
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
                    boolean var7C71A300047F108AC3033C50DC0486FF_875953197 = (!MESG_CANCELED.equals(resultMessage));
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
                boolean var2B91D1FCA73FC02C02D1162978B1932A_1907865587 = (!hasMessages(MSG_WRITE_STATUS));
                {
                    sendMessageDelayed(obtainMessage(MSG_WRITE_STATUS),
                        WRITE_STATUS_DELAY);
                } //End block
            } //End collapsed parenthetic
            {
                writeStatisticsLocked();
            } //End block
            {
                boolean varEAC7F4D3EF7F30FF5707B3481FC22C4A_1909942705 = (!hasMessages(MSG_WRITE_STATISTICS));
                {
                    sendMessageDelayed(obtainMessage(MSG_WRITE_STATISTICS),
                        WRITE_STATISTICS_DELAY);
                } //End block
            } //End collapsed parenthetic
        } //End block
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_STATUS);
        addTaint(historyId);
        addTaint(elapsedTime);
        addTaint(resultMessage.getTaint());
        addTaint(downstreamActivity);
        addTaint(upstreamActivity);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.790 -0400", hash_original_method = "F85BE50FB140D59BBA80C586F09539D3", hash_generated_method = "30A0B27A0626E57EFEE68B0E50A5B816")
    public List<SyncInfo> getCurrentSyncs() {
        List<SyncInfo> varB4EAC82CA7396A68D541C85D26508E83_346648853 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_346648853 = new ArrayList<SyncInfo>(mCurrentSyncs);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_346648853.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_346648853;
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return new ArrayList<SyncInfo>(mCurrentSyncs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.791 -0400", hash_original_method = "337F005F5350F3BD5177B0B27AD2E944", hash_generated_method = "1948C931EE147CFC7DCD9B0745ABF1C7")
    public ArrayList<SyncStatusInfo> getSyncStatus() {
        ArrayList<SyncStatusInfo> varB4EAC82CA7396A68D541C85D26508E83_648634950 = null; //Variable for return #1
        {
            final int N = mSyncStatus.size();
            ArrayList<SyncStatusInfo> ops = new ArrayList<SyncStatusInfo>(N);
            {
                int i = 0;
                {
                    ops.add(mSyncStatus.valueAt(i));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_648634950 = ops;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_648634950.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_648634950;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.793 -0400", hash_original_method = "AEA28BD7AFFA3D47C607E69E1C170D48", hash_generated_method = "1BD3F34CDDD21BE5F5333873FFC70C2E")
    public ArrayList<AuthorityInfo> getAuthorities() {
        ArrayList<AuthorityInfo> varB4EAC82CA7396A68D541C85D26508E83_1816274029 = null; //Variable for return #1
        {
            final int N = mAuthorities.size();
            ArrayList<AuthorityInfo> infos = new ArrayList<AuthorityInfo>(N);
            {
                int i = 0;
                {
                    infos.add(mAuthorities.valueAt(i));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1816274029 = infos;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1816274029.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1816274029;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.795 -0400", hash_original_method = "0CFE1C56DFD3FFD9F777D7B0D6FDA886", hash_generated_method = "4AB565A28ACBD4125C8C8F11AA038160")
    public SyncStatusInfo getStatusByAccountAndAuthority(Account account, String authority) {
        SyncStatusInfo varB4EAC82CA7396A68D541C85D26508E83_285641174 = null; //Variable for return #1
        SyncStatusInfo varB4EAC82CA7396A68D541C85D26508E83_479751959 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            final int N = mSyncStatus.size();
            {
                int i = 0;
                {
                    SyncStatusInfo cur = mSyncStatus.valueAt(i);
                    AuthorityInfo ainfo = mAuthorities.get(cur.authorityId);
                    {
                        boolean var862D844832D3CF22D3C92B9C4A23CE0F_877298523 = (ainfo != null && ainfo.authority.equals(authority) &&
                    account.equals(ainfo.account));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_285641174 = cur;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_479751959 = null;
        } //End block
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        SyncStatusInfo varA7E53CE21691AB073D9660D615818899_534119787; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_534119787 = varB4EAC82CA7396A68D541C85D26508E83_285641174;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_534119787 = varB4EAC82CA7396A68D541C85D26508E83_479751959;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_534119787.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_534119787;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.796 -0400", hash_original_method = "11629709D08EF9D9A0440D25565E7A8F", hash_generated_method = "E9E180AA8B5F6922165A81C60B7BDEBE")
    public boolean isSyncPending(Account account, String authority) {
        {
            final int N = mSyncStatus.size();
            {
                int i = 0;
                {
                    SyncStatusInfo cur = mSyncStatus.valueAt(i);
                    AuthorityInfo ainfo = mAuthorities.get(cur.authorityId);
                    {
                        boolean var0FFE9F6E75A8D1A1C72EB5282DFC0008_1191535473 = (account != null && !ainfo.account.equals(account));
                    } //End collapsed parenthetic
                    {
                        boolean var7CBBC873E3E6AD1B3ACD68783E9A1B98_983762347 = (ainfo.authority.equals(authority) && cur.pending);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353165418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353165418;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.799 -0400", hash_original_method = "B27CDDFFB9BAFF7BFEA0365E872FDD46", hash_generated_method = "DEB990F3DEDF177B97A417F69EA800A4")
    public ArrayList<SyncHistoryItem> getSyncHistory() {
        ArrayList<SyncHistoryItem> varB4EAC82CA7396A68D541C85D26508E83_1265341575 = null; //Variable for return #1
        {
            final int N = mSyncHistory.size();
            ArrayList<SyncHistoryItem> items = new ArrayList<SyncHistoryItem>(N);
            {
                int i = 0;
                {
                    items.add(mSyncHistory.get(i));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1265341575 = items;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1265341575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1265341575;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.800 -0400", hash_original_method = "3EC13B6BE37070366668DCFEFC381135", hash_generated_method = "598F301180E0D3B80A226CE9402F44CC")
    public DayStats[] getDayStatistics() {
        DayStats[] varB4EAC82CA7396A68D541C85D26508E83_330526675 = null; //Variable for return #1
        {
            DayStats[] ds = new DayStats[mDayStats.length];
            System.arraycopy(mDayStats, 0, ds, 0, ds.length);
            varB4EAC82CA7396A68D541C85D26508E83_330526675 = ds;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_330526675.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_330526675;
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //DayStats[] ds = new DayStats[mDayStats.length];
            //System.arraycopy(mDayStats, 0, ds, 0, ds.length);
            //return ds;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.801 -0400", hash_original_method = "CFA8C7FA80DDF752958B19CD5427CAD8", hash_generated_method = "606B9ACFE417443CE1E75AA6F5F688EA")
    public long getInitialSyncFailureTime() {
        {
            long oldest = 0;
            int i = mSyncStatus.size();
            {
                SyncStatusInfo stats = mSyncStatus.valueAt(i);
                AuthorityInfo authority = mAuthorities.get(stats.authorityId);
                {
                    {
                        oldest = stats.initialFailureTime;
                    } //End block
                } //End block
            } //End block
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1117003173 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1117003173;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.802 -0400", hash_original_method = "C1CC7B80E3CCED2D49B24E4AC052D091", hash_generated_method = "9127E5F0305BCB28CA2C2BCABEFA81C6")
    private int getCurrentDayLocked() {
        mCal.setTimeInMillis(System.currentTimeMillis());
        final int dayOfYear = mCal.get(Calendar.DAY_OF_YEAR);
        {
            boolean varF5AE9792675ABE63903C843879FC5273_377882840 = (mYear != mCal.get(Calendar.YEAR));
            {
                mYear = mCal.get(Calendar.YEAR);
                mCal.clear();
                mCal.set(Calendar.YEAR, mYear);
                mYearInDays = (int)(mCal.getTimeInMillis()/86400000);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811146893 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811146893;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.803 -0400", hash_original_method = "6C953B58E1758760E6819A681B8F6E8F", hash_generated_method = "5EBA12FEB1B27F5DD91422BDA2137D20")
    private AuthorityInfo getAuthorityLocked(Account accountName, String authorityName,
            String tag) {
        AuthorityInfo varB4EAC82CA7396A68D541C85D26508E83_1769260859 = null; //Variable for return #1
        AuthorityInfo varB4EAC82CA7396A68D541C85D26508E83_212071855 = null; //Variable for return #2
        AuthorityInfo varB4EAC82CA7396A68D541C85D26508E83_162125156 = null; //Variable for return #3
        AccountInfo account = mAccounts.get(accountName);
        {
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1311164250 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1769260859 = null;
        } //End block
        AuthorityInfo authority = account.authorities.get(authorityName);
        {
            {
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_553613451 = (Log.isLoggable(TAG, Log.VERBOSE));
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_212071855 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_162125156 = authority;
        addTaint(accountName.getTaint());
        addTaint(authorityName.getTaint());
        addTaint(tag.getTaint());
        AuthorityInfo varA7E53CE21691AB073D9660D615818899_397240295; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_397240295 = varB4EAC82CA7396A68D541C85D26508E83_1769260859;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_397240295 = varB4EAC82CA7396A68D541C85D26508E83_212071855;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_397240295 = varB4EAC82CA7396A68D541C85D26508E83_162125156;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_397240295.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_397240295;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.804 -0400", hash_original_method = "8765A57952C80F1A5760550FE9E929E6", hash_generated_method = "0813EA720783611D0DFE5EB23A57FA15")
    private AuthorityInfo getOrCreateAuthorityLocked(Account accountName,
            String authorityName, int ident, boolean doWrite) {
        AuthorityInfo varB4EAC82CA7396A68D541C85D26508E83_2045761793 = null; //Variable for return #1
        AccountInfo account = mAccounts.get(accountName);
        {
            account = new AccountInfo(accountName);
            mAccounts.put(accountName, account);
        } //End block
        AuthorityInfo authority = account.authorities.get(authorityName);
        {
            {
                ident = mNextAuthorityId;
                doWrite = true;
            } //End block
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1588744593 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            authority = new AuthorityInfo(accountName, authorityName, ident);
            account.authorities.put(authorityName, authority);
            mAuthorities.put(ident, authority);
            {
                writeAccountInfoLocked();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2045761793 = authority;
        addTaint(accountName.getTaint());
        addTaint(authorityName.getTaint());
        addTaint(ident);
        addTaint(doWrite);
        varB4EAC82CA7396A68D541C85D26508E83_2045761793.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2045761793;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.805 -0400", hash_original_method = "654490315D677BE62FC7AFF81C0D5F85", hash_generated_method = "F0E93D2DD83FC04357C6F89DD626D3DF")
    private void removeAuthorityLocked(Account account, String authorityName, boolean doWrite) {
        AccountInfo accountInfo = mAccounts.get(account);
        {
            final AuthorityInfo authorityInfo = accountInfo.authorities.remove(authorityName);
            {
                mAuthorities.remove(authorityInfo.ident);
                {
                    writeAccountInfoLocked();
                } //End block
            } //End block
        } //End block
        addTaint(account.getTaint());
        addTaint(authorityName.getTaint());
        addTaint(doWrite);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.807 -0400", hash_original_method = "8F9F327D2E93831D0CA3DA1F9594BFF4", hash_generated_method = "D770707EBDF5BFB7118DCEDE7EDD364D")
    public SyncStatusInfo getOrCreateSyncStatus(AuthorityInfo authority) {
        SyncStatusInfo varB4EAC82CA7396A68D541C85D26508E83_1709981755 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1709981755 = getOrCreateSyncStatusLocked(authority.ident);
        } //End block
        addTaint(authority.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1709981755.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1709981755;
        // ---------- Original Method ----------
        //synchronized (mAuthorities) {
            //return getOrCreateSyncStatusLocked(authority.ident);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.809 -0400", hash_original_method = "1C22F2C698CD79AA856218BCBCBEF0F7", hash_generated_method = "FE448690EBB489941E6B883FD892E40F")
    private SyncStatusInfo getOrCreateSyncStatusLocked(int authorityId) {
        SyncStatusInfo varB4EAC82CA7396A68D541C85D26508E83_1905091043 = null; //Variable for return #1
        SyncStatusInfo status = mSyncStatus.get(authorityId);
        {
            status = new SyncStatusInfo(authorityId);
            mSyncStatus.put(authorityId, status);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1905091043 = status;
        addTaint(authorityId);
        varB4EAC82CA7396A68D541C85D26508E83_1905091043.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1905091043;
        // ---------- Original Method ----------
        //SyncStatusInfo status = mSyncStatus.get(authorityId);
        //if (status == null) {
            //status = new SyncStatusInfo(authorityId);
            //mSyncStatus.put(authorityId, status);
        //}
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.809 -0400", hash_original_method = "EC72A1F81B7D887353DF2FA5F052A597", hash_generated_method = "86F12DB138C5A51C581689801B2E7042")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.810 -0400", hash_original_method = "E278B7FDC712595C2D25226C12B41BCD", hash_generated_method = "3B18257F5F9A6BBCDF5F4100DB64A581")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.812 -0400", hash_original_method = "9E90C2E17AAFB2A4F084659253144E64", hash_generated_method = "32FC92FFA2212264FA4FF8ABEF68759F")
    private void readAccountInfoLocked() {
        int highestAuthorityId = -1;
        FileInputStream fis = null;
        try 
        {
            fis = mAccountInfoFile.openRead();
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(fis, null);
            int eventType = parser.getEventType();
            {
                eventType = parser.next();
            } //End block
            String tagName = parser.getName();
            {
                boolean varEA9134381FE53D35BC8E6FDC6023FD4E_43751842 = ("accounts".equals(tagName));
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
                        int id;
                        id = 0;
                        id = Integer.parseInt(nextIdString);
                        mNextAuthorityId = Math.max(mNextAuthorityId, id);
                    } //End block
                    catch (NumberFormatException e)
                    { }
                    mMasterSyncAutomatically = listen == null || Boolean.parseBoolean(listen);
                    eventType = parser.next();
                    AuthorityInfo authority = null;
                    Pair<Bundle, Long> periodicSync = null;
                    {
                        {
                            tagName = parser.getName();
                            {
                                boolean var5533CC5BF096B074D5377EFABC3239D4_411652151 = (parser.getDepth() == 2);
                                {
                                    {
                                        boolean varC338281B9AB8666CC99D2E81E043881E_1767053768 = ("authority".equals(tagName));
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
                                    boolean var72C0C0241F04C0E1079A48495349FFF8_1932870741 = (parser.getDepth() == 3);
                                    {
                                        {
                                            boolean var46DF390825B8F1ABB8FC0E3A4246521B_634365893 = ("periodicSync".equals(tagName) && authority != null);
                                            {
                                                periodicSync = parsePeriodicSync(parser, authority);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        boolean var2DA16D744ECD2010DC4A4EF0E453A4B1_1620430824 = (parser.getDepth() == 4 && periodicSync != null);
                                        {
                                            {
                                                boolean var81C030BF887EEF545F20C4A1E1AD0D03_748341933 = ("extra".equals(tagName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.824 -0400", hash_original_method = "1F0CD4338AAE9E719690DF5E0BB493ED", hash_generated_method = "BA556F7B05B35C558605DAB85323C414")
    private boolean maybeMigrateSettingsForRenamedAuthorities() {
        boolean writeNeeded = false;
        ArrayList<AuthorityInfo> authoritiesToRemove = new ArrayList<AuthorityInfo>();
        final int N = mAuthorities.size();
        {
            int i = 0;
            {
                AuthorityInfo authority = mAuthorities.valueAt(i);
                final String newAuthorityName = sAuthorityRenames.get(authority.authority);
                authoritiesToRemove.add(authority);
                {
                    boolean var698AA62F742F1C5C9850F3579DB53BD9_2132921383 = (getAuthorityLocked(authority.account, newAuthorityName, "cleanup") != null);
                } //End collapsed parenthetic
                AuthorityInfo newAuthority = getOrCreateAuthorityLocked(authority.account,
                    newAuthorityName, -1 , false );
                newAuthority.enabled = true;
                writeNeeded = true;
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<AuthorityInfo> varD7DAEFE4E3289DAC94FBF4EAEE25A485_501770811 = (authoritiesToRemove).iterator();
            varD7DAEFE4E3289DAC94FBF4EAEE25A485_501770811.hasNext();
            AuthorityInfo authorityInfo = varD7DAEFE4E3289DAC94FBF4EAEE25A485_501770811.next();
            {
                removeAuthorityLocked(authorityInfo.account, authorityInfo.authority,
                    false );
                writeNeeded = true;
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222140219 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222140219;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.825 -0400", hash_original_method = "39CA1CD415012CC0A4B70AAED3727A93", hash_generated_method = "6E8F9D83B58C89DD465C2E0D6974B399")
    private AuthorityInfo parseAuthority(XmlPullParser parser, int version) {
        AuthorityInfo varB4EAC82CA7396A68D541C85D26508E83_450301539 = null; //Variable for return #1
        AuthorityInfo authority = null;
        int id = -1;
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
            String authorityName = parser.getAttributeValue(null, "authority");
            String enabled = parser.getAttributeValue(null, "enabled");
            String syncable = parser.getAttributeValue(null, "syncable");
            String accountName = parser.getAttributeValue(null, "account");
            String accountType = parser.getAttributeValue(null, "type");
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
                    boolean var027FB36D6559BE640F92C42FB7594DF3_281168011 = ("unknown".equals(syncable));
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
        varB4EAC82CA7396A68D541C85D26508E83_450301539 = authority;
        addTaint(parser.getTaint());
        addTaint(version);
        varB4EAC82CA7396A68D541C85D26508E83_450301539.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_450301539;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:04.895 -0400", hash_original_method = "5B7C41C6008D60C9ED6FB4C92797A204", hash_generated_method = "049160C46F9B7C193E5B567D48952257")
    private Pair<Bundle, Long> parsePeriodicSync(XmlPullParser parser, AuthorityInfo authority) {
        Pair<Bundle, Long> varB4EAC82CA7396A68D541C85D26508E83_1907363610 = null; //Variable for return #1
        Pair<Bundle, Long> varB4EAC82CA7396A68D541C85D26508E83_2056683155 = null; //Variable for return #2
        Pair<Bundle, Long> varB4EAC82CA7396A68D541C85D26508E83_198282795 = null; //Variable for return #3
        Bundle extras;
        extras = new Bundle();
        String periodValue;
        periodValue = parser.getAttributeValue(null, "period");
        long period = 0;
        try 
        {
            period = Long.parseLong(periodValue);
        } //End block
        catch (NumberFormatException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1907363610 = null;
        } //End block
        catch (NullPointerException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2056683155 = null;
        } //End block
        Pair<Bundle, Long> periodicSync;
        periodicSync = Pair.create(extras, period);
        authority.periodicSyncs.add(periodicSync);
        varB4EAC82CA7396A68D541C85D26508E83_198282795 = periodicSync;
        addTaint(parser.getTaint());
        addTaint(authority.getTaint());
        Pair<Bundle, Long> varA7E53CE21691AB073D9660D615818899_1684438920; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1684438920 = varB4EAC82CA7396A68D541C85D26508E83_1907363610;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1684438920 = varB4EAC82CA7396A68D541C85D26508E83_2056683155;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1684438920 = varB4EAC82CA7396A68D541C85D26508E83_198282795;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1684438920.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1684438920;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.827 -0400", hash_original_method = "63A9A531A6D6EE37322509C7D60C0471", hash_generated_method = "6F35E80380F7A56A85FD04687E123682")
    private void parseExtra(XmlPullParser parser, Pair<Bundle, Long> periodicSync) {
        final Bundle extras = periodicSync.first;
        String name = parser.getAttributeValue(null, "name");
        String type = parser.getAttributeValue(null, "type");
        String value1 = parser.getAttributeValue(null, "value1");
        String value2 = parser.getAttributeValue(null, "value2");
        try 
        {
            {
                boolean varDD72CE6C923B2C5C27D9875CF4A69477_91442970 = ("long".equals(type));
                {
                    extras.putLong(name, Long.parseLong(value1));
                } //End block
                {
                    boolean var92E69FEE619C318BEAB02B74B850DC0B_1588661220 = ("integer".equals(type));
                    {
                        extras.putInt(name, Integer.parseInt(value1));
                    } //End block
                    {
                        boolean varC6FD6E09CB45BCC6DA80980705939B8F_1589202701 = ("double".equals(type));
                        {
                            extras.putDouble(name, Double.parseDouble(value1));
                        } //End block
                        {
                            boolean varE4C0E91817A60C38997ADE7700F8DE59_574351536 = ("float".equals(type));
                            {
                                extras.putFloat(name, Float.parseFloat(value1));
                            } //End block
                            {
                                boolean var5FBDFDF4488B4DEBB40B64CB4E65062D_69112147 = ("boolean".equals(type));
                                {
                                    extras.putBoolean(name, Boolean.parseBoolean(value1));
                                } //End block
                                {
                                    boolean var65AB3E0236299C8A696297D0A7F44196_96741072 = ("string".equals(type));
                                    {
                                        extras.putString(name, value1);
                                    } //End block
                                    {
                                        boolean varF44E655240B90E6EC37D2E6505C82828_17975849 = ("account".equals(type));
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
        addTaint(parser.getTaint());
        addTaint(periodicSync.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.872 -0400", hash_original_method = "D0303AA7EB859F30BDBC9813BB120707", hash_generated_method = "0ADF938C640179DB2938BD74FCA49DB1")
    private void writeAccountInfoLocked() {
        FileOutputStream fos = null;
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
            {
                out.attribute(null, "listen-for-tickles", "false");
            } //End block
            final int N = mAuthorities.size();
            {
                int i = 0;
                {
                    AuthorityInfo authority = mAuthorities.valueAt(i);
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
                        Iterator<Pair<Bundle, Long>> var725959591153CF92A3D3E1B2B1738C17_2032877117 = (authority.periodicSyncs).iterator();
                        var725959591153CF92A3D3E1B2B1738C17_2032877117.hasNext();
                        Pair<Bundle, Long> periodicSync = var725959591153CF92A3D3E1B2B1738C17_2032877117.next();
                        {
                            out.startTag(null, "periodicSync");
                            out.attribute(null, "period", Long.toString(periodicSync.second));
                            final Bundle extras = periodicSync.first;
                            {
                                Iterator<String> var1C78A364843D411FE3AA79BFC80E36AA_1636894622 = (extras.keySet()).iterator();
                                var1C78A364843D411FE3AA79BFC80E36AA_1636894622.hasNext();
                                String key = var1C78A364843D411FE3AA79BFC80E36AA_1636894622.next();
                                {
                                    out.startTag(null, "extra");
                                    out.attribute(null, "name", key);
                                    final Object value = extras.get(key);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.875 -0400", hash_original_method = "96B84444EEB95F8262A1F514B70427CB", hash_generated_method = "5CD037A7546E334BDFABE57AF68591F6")
    private void readAndDeleteLegacyAccountInfoLocked() {
        File file = mContext.getDatabasePath("syncmanager.db");
        {
            boolean varE02387E0421DAF07E6582975BDA6A5F5_1314994663 = (!file.exists());
        } //End collapsed parenthetic
        String path = file.getPath();
        SQLiteDatabase db = null;
        try 
        {
            db = SQLiteDatabase.openDatabase(path, null,
                    SQLiteDatabase.OPEN_READONLY);
        } //End block
        catch (SQLiteException e)
        { }
        {
            final boolean hasType = db.getVersion() >= 11;
            SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
            qb.setTables("stats, status");
            HashMap<String,String> map = new HashMap<String,String>();
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
            Cursor c = qb.query(db, null, null, null, null, null, null);
            {
                boolean var4D86B3BFFD03EEDEB3FCD4358BA0EB15_1638469498 = (c.moveToNext());
                {
                    String accountName = c.getString(c.getColumnIndex("account"));
                    String accountType;
                    accountType = c.getString(c.getColumnIndex("account_type"));
                    accountType = null;
                    {
                        accountType = "com.google";
                    } //End block
                    String authorityName = c.getString(c.getColumnIndex("authority"));
                    AuthorityInfo authority = this.getOrCreateAuthorityLocked(
                        new Account(accountName, accountType),
                        authorityName, -1, false);
                    {
                        int i = mSyncStatus.size();
                        boolean found = false;
                        SyncStatusInfo st = null;
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
                boolean var4D86B3BFFD03EEDEB3FCD4358BA0EB15_1317928581 = (c.moveToNext());
                {
                    String name = c.getString(c.getColumnIndex("name"));
                    String value = c.getString(c.getColumnIndex("value"));
                    {
                        boolean varE7D17AC8C521E3212FFC5FCB3ACDBEA6_1583952101 = (name.equals("listen_for_tickles"));
                        {
                            setMasterSyncAutomatically(value == null || Boolean.parseBoolean(value));
                        } //End block
                        {
                            boolean var2D5B49D8F7F94D0F096FA4A79CB462D9_1434528043 = (name.startsWith("sync_provider_"));
                            {
                                String provider = name.substring("sync_provider_".length(),
                            name.length());
                                int i = mAuthorities.size();
                                {
                                    AuthorityInfo authority = mAuthorities.valueAt(i);
                                    {
                                        boolean var9128AE8AE03D18D596BA8FDC14FB9F77_1979817951 = (authority.authority.equals(provider));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.876 -0400", hash_original_method = "8A0C770C89ACE123AD07688E6EE32DB8", hash_generated_method = "AB63FF807A1ECC3C345583421DD150DC")
    private void readStatusLocked() {
        try 
        {
            byte[] data = mStatusFile.readFully();
            Parcel in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            int token;
            {
                boolean var20DE3378D869FED209202FBBB28E4D26_1546472024 = ((token=in.readInt()) != STATUS_FILE_END);
                {
                    {
                        SyncStatusInfo status = new SyncStatusInfo(in);
                        {
                            boolean varCE4B6671B92DDEA8B8BD9E923335E747_1566443770 = (mAuthorities.indexOfKey(status.authorityId) >= 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.877 -0400", hash_original_method = "74BDFC1296AA332718133078DAF25C56", hash_generated_method = "6A964F10360A4722BC8E4BB5E0B06033")
    private void writeStatusLocked() {
        removeMessages(MSG_WRITE_STATUS);
        FileOutputStream fos = null;
        try 
        {
            fos = mStatusFile.startWrite();
            Parcel out = Parcel.obtain();
            final int N = mSyncStatus.size();
            {
                int i = 0;
                {
                    SyncStatusInfo status = mSyncStatus.valueAt(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.878 -0400", hash_original_method = "1231AB171DBB37761A49B7E20056B86A", hash_generated_method = "9E51BC1EA10D9C5DE17736C6E36584E4")
    private void readPendingOperationsLocked() {
        try 
        {
            byte[] data = mPendingFile.readFully();
            Parcel in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            final int SIZE = in.dataSize();
            {
                boolean var2DA2E27409709F023B8B17940C59F476_1233731012 = (in.dataPosition() < SIZE);
                {
                    int version = in.readInt();
                    int authorityId = in.readInt();
                    int syncSource = in.readInt();
                    byte[] flatExtras = in.createByteArray();
                    boolean expedited;
                    {
                        expedited = in.readInt() != 0;
                    } //End block
                    {
                        expedited = false;
                    } //End block
                    AuthorityInfo authority = mAuthorities.get(authorityId);
                    {
                        Bundle extras;
                        {
                            extras = unflattenBundle(flatExtras);
                        } //End block
                        {
                            extras = new Bundle();
                        } //End block
                        PendingOperation op = new PendingOperation(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.878 -0400", hash_original_method = "0152B02FFEBFCD8F723BAE9C7F6EE92A", hash_generated_method = "C536F7F9367F6E986755732B4DAAFC25")
    private void writePendingOperationLocked(PendingOperation op, Parcel out) {
        out.writeInt(PENDING_OPERATION_VERSION);
        out.writeInt(op.authorityId);
        out.writeInt(op.syncSource);
        {
            op.flatExtras = flattenBundle(op.extras);
        } //End block
        out.writeByteArray(op.flatExtras);
        out.writeInt(op.expedited ? 1 : 0);
        addTaint(op.getTaint());
        addTaint(out.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.879 -0400", hash_original_method = "B08FC5F8DD5CA36D6F4DD131B7753109", hash_generated_method = "D17789383D3878F1D457E65CD7676EFF")
    private void writePendingOperationsLocked() {
        final int N = mPendingOperations.size();
        FileOutputStream fos = null;
        try 
        {
            {
                mPendingFile.truncate();
            } //End block
            fos = mPendingFile.startWrite();
            Parcel out = Parcel.obtain();
            {
                int i = 0;
                {
                    PendingOperation op = mPendingOperations.get(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.880 -0400", hash_original_method = "3B9D2CCD4E7B33665C76FD82482A168C", hash_generated_method = "C28A7C2566E783A9FF8D46551F8BC4AF")
    private void appendPendingOperationLocked(PendingOperation op) {
        FileOutputStream fos = null;
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
            Parcel out = Parcel.obtain();
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
        addTaint(op.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.881 -0400", hash_original_method = "EF23341A4D9A5255D7511F96FA9CF980", hash_generated_method = "10B48D8F606358F0B43334360DC9ACE3")
    private void readStatisticsLocked() {
        try 
        {
            byte[] data = mStatisticsFile.readFully();
            Parcel in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            int token;
            int index = 0;
            {
                boolean var8ECFD84E493B489FCB77966C40A1A2F0_690917494 = ((token=in.readInt()) != STATISTICS_FILE_END);
                {
                    {
                        int day = in.readInt();
                        {
                            day = day - 2009 + 14245;
                        } //End block
                        DayStats ds = new DayStats(day);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.882 -0400", hash_original_method = "FBD3A634F75EF390904BDDFD24CE73C8", hash_generated_method = "55E91E96EDA9150A497C46CD76768FA9")
    private void writeStatisticsLocked() {
        removeMessages(MSG_WRITE_STATISTICS);
        FileOutputStream fos = null;
        try 
        {
            fos = mStatisticsFile.startWrite();
            Parcel out = Parcel.obtain();
            final int N = mDayStats.length;
            {
                int i = 0;
                {
                    DayStats ds = mDayStats[i];
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.882 -0400", hash_original_field = "E268443E43D93DAB7EBEF303BBE9642F", hash_generated_field = "9D630FBF90643CC60961CCF48FECCA0B")

        Account account;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.882 -0400", hash_original_field = "C4B6C45B08DE8968EEA91097B03482FE", hash_generated_field = "ADDF5490BF1C10ABAFE6E2B2AE40316C")

        int syncSource;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.882 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "246C0F9F2C0270494BEB2E9C6833888B")

        String authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.882 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "6F80A5414A80FF69E92A0BD3C0E073DC")

        Bundle extras;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.882 -0400", hash_original_field = "7959CC84448D1E4ADCF2D189917AB5F5", hash_generated_field = "D7DC8099D62435877828BDBBACCABD83")

        boolean expedited;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.882 -0400", hash_original_field = "A6E80D6465C4F39AC517335BD9346D44", hash_generated_field = "B11D0145EE299937169261FF5464F8E6")

        int authorityId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.882 -0400", hash_original_field = "F78F2C2DC8FF5FBD97589211764EDC09", hash_generated_field = "CCB24DDC55B05A8A59BF27C8C026E7C2")

        byte[] flatExtras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.883 -0400", hash_original_method = "EF059F8E3294963F1E848A9313768B5B", hash_generated_method = "ECE8E5E0F4B60B404F31D36C12807A31")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.883 -0400", hash_original_method = "1B5DBB8810EC174C356BDFB975D9E53C", hash_generated_method = "3B16B7399A2D0DA02220BB5FA54FDA88")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.883 -0400", hash_original_field = "E268443E43D93DAB7EBEF303BBE9642F", hash_generated_field = "9D630FBF90643CC60961CCF48FECCA0B")

        Account account;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.883 -0400", hash_original_field = "B372FF30BD0B7AD61246E45A8DAF39AC", hash_generated_field = "582FF2E1ECE36BD91B7F484171C698A4")

        final HashMap<String, AuthorityInfo> authorities = new HashMap<String, AuthorityInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.884 -0400", hash_original_method = "0A42050331BE326DBD226E8BF4C55827", hash_generated_method = "B735F73451A3ACA4DAAEEE69356C87D1")
          AccountInfo(Account account) {
            this.account = account;
            // ---------- Original Method ----------
            //this.account = account;
        }

        
    }


    
    public static class AuthorityInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.884 -0400", hash_original_field = "E268443E43D93DAB7EBEF303BBE9642F", hash_generated_field = "9D630FBF90643CC60961CCF48FECCA0B")

        Account account;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.884 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "246C0F9F2C0270494BEB2E9C6833888B")

        String authority;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.884 -0400", hash_original_field = "67217D8B401CF5E72BBF5103D60F3E97", hash_generated_field = "D6522CF0EB0B8A28ECDAD3A7DBFFD747")

        int ident;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.884 -0400", hash_original_field = "A10311459433ADF322F2590A4987C423", hash_generated_field = "D42E676CEDD1F98F54276A59532354DC")

        boolean enabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.884 -0400", hash_original_field = "BB5ED03A2B1CAD35E912B9A1FBB4B102", hash_generated_field = "79AAA92E0C1E2414AE9E421D3715FFA7")

        int syncable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.884 -0400", hash_original_field = "D214D1D366AE39DDEA5B3C19A2409ED7", hash_generated_field = "F9BE9859B6F90DC841CE99B8A7F51A4E")

        long backoffTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.884 -0400", hash_original_field = "683C96AA9C76BDA519E55ECC77ECE69E", hash_generated_field = "3E91C22FA3C3A3339E22C765EEF95ECF")

        long backoffDelay;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.884 -0400", hash_original_field = "77D196B208370F23D20E064B8B1B5DA0", hash_generated_field = "FF2672CE15194FA4F169DAC34CF8A869")

        long delayUntil;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.884 -0400", hash_original_field = "E93649099886D3DD4A3FC7823E345038", hash_generated_field = "9A4BDF3CAA0D13530C1392D88D3B28FD")

        ArrayList<Pair<Bundle, Long>> periodicSyncs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.885 -0400", hash_original_method = "F1AF0EF8567860728BE1920368DC5483", hash_generated_method = "01670732909F0C8780290ABAEC12ABEF")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.885 -0400", hash_original_field = "A6E80D6465C4F39AC517335BD9346D44", hash_generated_field = "B11D0145EE299937169261FF5464F8E6")

        int authorityId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.885 -0400", hash_original_field = "73D2E67EADBB14AC95E57F9F6F454182", hash_generated_field = "EFC3D33E7164A099395EA11FA008631A")

        int historyId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.885 -0400", hash_original_field = "FA84691E935429CDFDEE629C6C506CFE", hash_generated_field = "8BDF38DD5485D11C65E41598A447EC76")

        long eventTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.885 -0400", hash_original_field = "DAD566B38C7C4C71D805927E9FFF2732", hash_generated_field = "019980784258B693231C7932844AF0BC")

        long elapsedTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.885 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "926255832D3A4770F722E618872D36FC")

        int source;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.885 -0400", hash_original_field = "4119639092E62C55EA8BE348E4D9260D", hash_generated_field = "0AA9440F5EB6CF7AA5F6EE77723B4674")

        int event;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.885 -0400", hash_original_field = "25B28D4C6E9FCB008B24DBBED0391F83", hash_generated_field = "7BAE41919A19B3117C8C028B40BE197B")

        long upstreamActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.885 -0400", hash_original_field = "CB3F4AAEEC4327337C5AD425BD3C5EBA", hash_generated_field = "B78B031020001048916FB9B95358FFD7")

        long downstreamActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.885 -0400", hash_original_field = "E0130BF5B411FDCD683C1A359E5B6B92", hash_generated_field = "4661373404204B119E74D3CE353ABACF")

        String mesg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.886 -0400", hash_original_method = "2A1719F3DDEE538E4071CFCF49D97D66", hash_generated_method = "2A1719F3DDEE538E4071CFCF49D97D66")
        public SyncHistoryItem ()
        {
            //Synthesized constructor
        }


    }


    
    public static class DayStats {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.886 -0400", hash_original_field = "628B7DB04235F228D40ADC671413A8C8", hash_generated_field = "0E9628A682BEC1AED9AC9EDA1BF2C9CB")

        public int day;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.886 -0400", hash_original_field = "0D8F2499CF2528C030CD58F737E27388", hash_generated_field = "E32AF39AAA65273577552E6199614DFB")

        public int successCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.886 -0400", hash_original_field = "6539AA85D7508334E237E478CCFBED11", hash_generated_field = "E8A8B28F4FBBA8ADC8F6EA4E5EA3DF18")

        public long successTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.886 -0400", hash_original_field = "B17DD7F123FFCBD6D4D8909114BC2C7E", hash_generated_field = "4E23062AC4D24AC50DF56E8B405F9CA1")

        public int failureCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.886 -0400", hash_original_field = "0BE8CF852CEC555F19B50AB7F3FC597C", hash_generated_field = "D11480323C3691B82CABDCBFB47DADC3")

        public long failureTime;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.886 -0400", hash_original_method = "59D9CE47C9B58BC0ECFC5F57173A8EB8", hash_generated_method = "1997158732D9C97E768763E2795DF4D3")
        public  DayStats(int day) {
            this.day = day;
            // ---------- Original Method ----------
            //this.day = day;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.886 -0400", hash_original_field = "0439F4DA6A334C5ECD9FAAB83A40EC1E", hash_generated_field = "AF31108A14FC5488BDB972C9330ED310")

    private static final String TAG = "SyncManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "970B94CF21F1AAD9D1BB8284F27B5EB0", hash_generated_field = "EF3259EDC7B0E8CE678372C0DF872FC5")

    private static final boolean DEBUG_FILE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "3A26C05C2491AEFDB49DE3A3EC440F83", hash_generated_field = "38BF0EF4E89A3CF4939612B4A041EE55")

    private static final long DEFAULT_POLL_FREQUENCY_SECONDS = 60 * 60 * 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "74AD2A25867DA158CF5A8AAB433620F4", hash_generated_field = "5D728F78E04A905CA547FF7334FD502E")

    static final long MILLIS_IN_4WEEKS = 1000L * 60 * 60 * 24 * 7 * 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "22655829AA7E35AB1FADAE4804A583CD", hash_generated_field = "DBB1C0FAA50ADCA191193FD382FF1DB3")

    public static final int EVENT_START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "7CDCD962175DB6B2B0E3C586AB20CD5F", hash_generated_field = "3BEF4367DEF9BD87D4115EACD7240966")

    public static final int EVENT_STOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "C969FB97AA2B7E63903BD9A4A4EF9F5D", hash_generated_field = "AA12DDBD9F33486333D35FA892003881")

    public static final String[] EVENTS = { "START", "STOP" };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "1FC10DD0C353C96AE8D07D259BBED97D", hash_generated_field = "CA7ACB3F234AF725615689B170392D03")

    public static final int SOURCE_SERVER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "5F38B0C5E376D19EEFF40921D1D76404", hash_generated_field = "1B9C52B079F74B366A44C348D67DD20B")

    public static final int SOURCE_LOCAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "7F80857A96FDFBFED8B6D914448691FC", hash_generated_field = "6873D2C4A74ED23B6139DD518C56FB9D")

    public static final int SOURCE_POLL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "06E78232CDBD4A204F47E519FE6B095A", hash_generated_field = "18826EB2F690F30A736E4BA73E385233")

    public static final int SOURCE_USER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "393BFDF1EA39606B389647152D55799B", hash_generated_field = "7CEF055DDF11DD9167E38771846C2A7D")

    public static final int SOURCE_PERIODIC = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "52881790F8B54A043B2B3370B347D92B", hash_generated_field = "42B3B227F06616C376E0F38E8CD1D857")

    public static final long NOT_IN_BACKOFF_MODE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "2E548AD0866A41A8462FDBEFF894C3DA", hash_generated_field = "CA0D4D8E029CF4F0FC382E8F90A0D776")

    public static final Intent SYNC_CONNECTION_SETTING_CHANGED_INTENT =
            new Intent("com.android.sync.SYNC_CONN_STATUS_CHANGED");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.887 -0400", hash_original_field = "BBAD7B5FF4955E7C2016A5820A2C29F8", hash_generated_field = "B0B58A11324B8509E8BBA4B102D854A1")

    public static final String[] SOURCES = { "SERVER",
                                             "LOCAL",
                                             "POLL",
                                             "USER",
                                             "PERIODIC" };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "8CE25EA47DDF9E224F399AD74651DA27", hash_generated_field = "4DEC43F2868661A1BA0EBF5BF703C47A")

    public static final String MESG_SUCCESS = "success";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "C13412EEB1EBAAF9443F8005E2B42548", hash_generated_field = "17FC59A1C84A7DA7A5A17548CAD57255")

    public static final String MESG_CANCELED = "canceled";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "AC1C801337E0FA17C49784E11E472C83", hash_generated_field = "1B46D2BF183174FBED706FF3C2DF798D")

    public static final int MAX_HISTORY = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "8292273D83C80ACC23F03C7A22E3E9D8", hash_generated_field = "2655E18C83B5F3B5454E37E1D43F3E2C")

    private static final int MSG_WRITE_STATUS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "9A6863C0BE0EB0D3E212DBEFE5C52EFD", hash_generated_field = "4EA8DDD188FF4C168E89C66E59773587")

    private static final long WRITE_STATUS_DELAY = 1000*60*10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "B9FD698A11D73A4FB992F113C9C1E839", hash_generated_field = "D7E2178F8C402B9173FFA3D315D94038")

    private static final int MSG_WRITE_STATISTICS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "7E76782C1DE68E6A89AD8C5591C6DA5F", hash_generated_field = "20B3D5C604D6B06F3D714BB832758FDC")

    private static final long WRITE_STATISTICS_DELAY = 1000*60*30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "304FE4881B03F72E8FA9E4F79FDDE6E2", hash_generated_field = "D424F9AD9A99C5564E56756A063DF4E4")

    private static final boolean SYNC_ENABLED_DEFAULT = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "F8427D6D8240ADB9E62BBE69DD599A1C", hash_generated_field = "BCB1DEDD10667E8F9144B92B5AF4FB3C")

    private static final int ACCOUNTS_VERSION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "BB5C11BC8C430568A81202837B7BEC1A", hash_generated_field = "E829F19290AD6F16651117D8A72DC792")

    private static HashMap<String, String> sAuthorityRenames;
    static {
        sAuthorityRenames = new HashMap<String, String>();
        sAuthorityRenames.put("contacts", "com.android.contacts");
        sAuthorityRenames.put("calendar", "com.android.calendar");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "FABD1FAC0379965DCE7F305C980B3B2D", hash_generated_field = "30DA75A8F03960BB79F751A463A3C81A")

    private static volatile SyncStorageEngine sSyncStorageEngine = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "357DE3A306F14B284317E7704E3A6715", hash_generated_field = "1AA6B4A5916CCA9E00BCD79C3BA829B9")

    private static final int PENDING_FINISH_TO_WRITE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "F877DBDB2A4A16FBE595987860E3D7B5", hash_generated_field = "29DD7B46231A8851E3979ED054714BB2")

    public static final int STATUS_FILE_END = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.888 -0400", hash_original_field = "DC404CE91F2D6B5F6D5B3AE012169248", hash_generated_field = "3AD83470903C387E8F900C23B2FF2EA8")

    public static final int STATUS_FILE_ITEM = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.889 -0400", hash_original_field = "9A33CD3A58DF951E6307F9FC3DDBAE03", hash_generated_field = "197263DC5593D605C8462C10EBA64119")

    public static final int PENDING_OPERATION_VERSION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.889 -0400", hash_original_field = "CFC7CF91052789EE5627E73804D78C83", hash_generated_field = "C17775889B02E738EED29EAE10B23BE8")

    public static final int STATISTICS_FILE_END = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.889 -0400", hash_original_field = "2C083004C286A80CF8E2A301A6DFDFF3", hash_generated_field = "0293436725092F127B986477871B7112")

    public static final int STATISTICS_FILE_ITEM_OLD = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.889 -0400", hash_original_field = "64BEFA2E71E30F411A466C0746F12EA2", hash_generated_field = "74988DD095757B31CB2FB87FD58F31AD")

    public static final int STATISTICS_FILE_ITEM = 101;
}

