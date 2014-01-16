package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.accounts.Account;
import android.app.ActivityManagerNative;
import android.app.AppGlobals;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.CrossProcessCursorWrapper;
import android.database.Cursor;
import android.database.IContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import dalvik.system.CloseGuard;

import droidsafe.concrete.DSCursor;

public abstract class ContentResolver {

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.184 -0500", hash_original_method = "C9CAD5745326A7C59519E3986DE53435", hash_generated_method = "C193278971C1C20DD790672BC1B44B6E")
    
static public int modeToMode(Uri uri, String mode) throws FileNotFoundException {
        int modeBits;
        if ("r".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_READ_ONLY;
        } else if ("w".equals(mode) || "wt".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_WRITE_ONLY
                    | ParcelFileDescriptor.MODE_CREATE
                    | ParcelFileDescriptor.MODE_TRUNCATE;
        } else if ("wa".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_WRITE_ONLY
                    | ParcelFileDescriptor.MODE_CREATE
                    | ParcelFileDescriptor.MODE_APPEND;
        } else if ("rw".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_READ_WRITE
                    | ParcelFileDescriptor.MODE_CREATE;
        } else if ("rwt".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_READ_WRITE
                    | ParcelFileDescriptor.MODE_CREATE
                    | ParcelFileDescriptor.MODE_TRUNCATE;
        } else {
            throw new FileNotFoundException("Bad mode for " + uri + ": "
                    + mode);
        }
        return modeBits;
    }

    /**
     * Start an asynchronous sync operation. If you want to monitor the progress
     * of the sync you may register a SyncObserver. Only values of the following
     * types may be used in the extras bundle:
     * <ul>
     * <li>Integer</li>
     * <li>Long</li>
     * <li>Boolean</li>
     * <li>Float</li>
     * <li>Double</li>
     * <li>String</li>
     * </ul>
     *
     * @param account which account should be synced
     * @param authority which authority should be synced
     * @param extras any extras to pass to the SyncAdapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.226 -0500", hash_original_method = "74F2F1DFCCDCB635DED0436014565E52", hash_generated_method = "17A4C14C86165C9B307A200F3CDA3720")
    
public static void requestSync(Account account, String authority, Bundle extras) {
        validateSyncExtrasBundle(extras);
        try {
            getContentService().requestSync(account, authority, extras);
        } catch (RemoteException e) {
        }
    }

    /**
     * Check that only values of the following types are in the Bundle:
     * <ul>
     * <li>Integer</li>
     * <li>Long</li>
     * <li>Boolean</li>
     * <li>Float</li>
     * <li>Double</li>
     * <li>String</li>
     * <li>Account</li>
     * <li>null</li>
     * </ul>
     * @param extras the Bundle to check
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.229 -0500", hash_original_method = "2E7D47AE074C06003B60058041EBE60E", hash_generated_method = "4B84445C19C9931C53E98DD70508C5A2")
    
public static void validateSyncExtrasBundle(Bundle extras) {
        try {
            for (String key : extras.keySet()) {
                Object value = extras.get(key);
                if (value == null) continue;
                if (value instanceof Long) continue;
                if (value instanceof Integer) continue;
                if (value instanceof Boolean) continue;
                if (value instanceof Float) continue;
                if (value instanceof Double) continue;
                if (value instanceof String) continue;
                if (value instanceof Account) continue;
                throw new IllegalArgumentException("unexpected value type: "
                        + value.getClass().getName());
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (RuntimeException exc) {
            throw new IllegalArgumentException("error unparceling Bundle", exc);
        }
    }

    /**
     * Cancel any active or pending syncs that match account and authority. The account and
     * authority can each independently be set to null, which means that syncs with any account
     * or authority, respectively, will match.
     *
     * @param account filters the syncs that match by this account
     * @param authority filters the syncs that match by this authority
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.233 -0500", hash_original_method = "0579E98D269BB76E67DB1EF7482221ED", hash_generated_method = "46FB2260AB9BF26025F8E4F6CF9AA8A2")
    
public static void cancelSync(Account account, String authority) {
        try {
            getContentService().cancelSync(account, authority);
        } catch (RemoteException e) {
        }
    }

    /**
     * Get information about the SyncAdapters that are known to the system.
     * @return an array of SyncAdapters that have registered with the system
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.236 -0500", hash_original_method = "73E621DB5CBC41567953829AD086C09E", hash_generated_method = "6CB02123789FCFB0C1AA6EADC4A389C1")
    
public static SyncAdapterType[] getSyncAdapterTypes() {
        try {
            return getContentService().getSyncAdapterTypes();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * Check if the provider should be synced when a network tickle is received
     *
     * @param account the account whose setting we are querying
     * @param authority the provider whose setting we are querying
     * @return true if the provider should be synced when a network tickle is received
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.238 -0500", hash_original_method = "40F680882F51B8DF93B91B007EA34DFA", hash_generated_method = "6D4A4B5F83D81A6EAACA1A139F403C60")
    
public static boolean getSyncAutomatically(Account account, String authority) {
        try {
            return getContentService().getSyncAutomatically(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * Set whether or not the provider is synced when it receives a network tickle.
     *
     * @param account the account whose setting we are querying
     * @param authority the provider whose behavior is being controlled
     * @param sync true if the provider should be synced when tickles are received for it
     */
    @DSSink({DSSinkKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.240 -0500", hash_original_method = "C45393365DF55DBBF34D87F9DFB07A0E", hash_generated_method = "4064BAE8FA6519AFCF28B0D7EC6499F5")
    
public static void setSyncAutomatically(Account account, String authority, boolean sync) {
        try {
            getContentService().setSyncAutomatically(account, authority, sync);
        } catch (RemoteException e) {
            // exception ignored; if this is thrown then it means the runtime is in the midst of
            // being restarted
        }
    }

    /**
     * Specifies that a sync should be requested with the specified the account, authority,
     * and extras at the given frequency. If there is already another periodic sync scheduled
     * with the account, authority and extras then a new periodic sync won't be added, instead
     * the frequency of the previous one will be updated.
     * <p>
     * These periodic syncs honor the "syncAutomatically" and "masterSyncAutomatically" settings.
     * Although these sync are scheduled at the specified frequency, it may take longer for it to
     * actually be started if other syncs are ahead of it in the sync operation queue. This means
     * that the actual start time may drift.
     * <p>
     * Periodic syncs are not allowed to have any of {@link #SYNC_EXTRAS_DO_NOT_RETRY},
     * {@link #SYNC_EXTRAS_IGNORE_BACKOFF}, {@link #SYNC_EXTRAS_IGNORE_SETTINGS},
     * {@link #SYNC_EXTRAS_INITIALIZE}, {@link #SYNC_EXTRAS_FORCE},
     * {@link #SYNC_EXTRAS_EXPEDITED}, {@link #SYNC_EXTRAS_MANUAL} set to true.
     * If any are supplied then an {@link IllegalArgumentException} will be thrown.
     *
     * @param account the account to specify in the sync
     * @param authority the provider to specify in the sync request
     * @param extras extra parameters to go along with the sync request
     * @param pollFrequency how frequently the sync should be performed, in seconds.
     * @throws IllegalArgumentException if an illegal extra was set or if any of the parameters
     * are null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.244 -0500", hash_original_method = "8992802F92BFCE1FEFF92FC805CEE29B", hash_generated_method = "915AB377DA9F65048783D3851F618E6B")
    
public static void addPeriodicSync(Account account, String authority, Bundle extras,
            long pollFrequency) {
        validateSyncExtrasBundle(extras);
        if (account == null) {
            throw new IllegalArgumentException("account must not be null");
        }
        if (authority == null) {
            throw new IllegalArgumentException("authority must not be null");
        }
        if (extras.getBoolean(SYNC_EXTRAS_MANUAL, false)
                || extras.getBoolean(SYNC_EXTRAS_DO_NOT_RETRY, false)
                || extras.getBoolean(SYNC_EXTRAS_IGNORE_BACKOFF, false)
                || extras.getBoolean(SYNC_EXTRAS_IGNORE_SETTINGS, false)
                || extras.getBoolean(SYNC_EXTRAS_INITIALIZE, false)
                || extras.getBoolean(SYNC_EXTRAS_FORCE, false)
                || extras.getBoolean(SYNC_EXTRAS_EXPEDITED, false)) {
            throw new IllegalArgumentException("illegal extras were set");
        }
        try {
            getContentService().addPeriodicSync(account, authority, extras, pollFrequency);
        } catch (RemoteException e) {
            // exception ignored; if this is thrown then it means the runtime is in the midst of
            // being restarted
        }
    }

    /**
     * Remove a periodic sync. Has no affect if account, authority and extras don't match
     * an existing periodic sync.
     *
     * @param account the account of the periodic sync to remove
     * @param authority the provider of the periodic sync to remove
     * @param extras the extras of the periodic sync to remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.246 -0500", hash_original_method = "91ED788510ACA5C1DC9947F69B90FEB9", hash_generated_method = "E37E2ABEB6775B23AC7C9C49CCCE6956")
    
public static void removePeriodicSync(Account account, String authority, Bundle extras) {
        validateSyncExtrasBundle(extras);
        if (account == null) {
            throw new IllegalArgumentException("account must not be null");
        }
        if (authority == null) {
            throw new IllegalArgumentException("authority must not be null");
        }
        try {
            getContentService().removePeriodicSync(account, authority, extras);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * Get the list of information about the periodic syncs for the given account and authority.
     *
     * @param account the account whose periodic syncs we are querying
     * @param authority the provider whose periodic syncs we are querying
     * @return a list of PeriodicSync objects. This list may be empty but will never be null.
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.249 -0500", hash_original_method = "342780EDBB61BA70D8F5407D611A17AB", hash_generated_method = "4ED998824EC22AEC37082CE05FFB7907")
    
public static List<PeriodicSync> getPeriodicSyncs(Account account, String authority) {
        if (account == null) {
            throw new IllegalArgumentException("account must not be null");
        }
        if (authority == null) {
            throw new IllegalArgumentException("authority must not be null");
        }
        try {
            return getContentService().getPeriodicSyncs(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * Check if this account/provider is syncable.
     * @return >0 if it is syncable, 0 if not, and <0 if the state isn't known yet.
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.251 -0500", hash_original_method = "12469DB36272456EC96DBBF2A0C7F6DB", hash_generated_method = "0F2DD104B1307481A16FF088FB86B16E")
    
public static int getIsSyncable(Account account, String authority) {
        try {
            return getContentService().getIsSyncable(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * Set whether this account/provider is syncable.
     * @param syncable >0 denotes syncable, 0 means not syncable, <0 means unknown
     */
    @DSSink({DSSinkKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.253 -0500", hash_original_method = "0A00860601B883D5D57C7B4B58CC648B", hash_generated_method = "C164D7E46A59E1610414F7A95B602BAA")
    
public static void setIsSyncable(Account account, String authority, int syncable) {
        try {
            getContentService().setIsSyncable(account, authority, syncable);
        } catch (RemoteException e) {
            // exception ignored; if this is thrown then it means the runtime is in the midst of
            // being restarted
        }
    }

    /**
     * Gets the master auto-sync setting that applies to all the providers and accounts.
     * If this is false then the per-provider auto-sync setting is ignored.
     *
     * @return the master auto-sync setting that applies to all the providers and accounts
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.255 -0500", hash_original_method = "F5DC6077E8ABFBA26E9E893D6D658007", hash_generated_method = "F300E4A610B638EB61AB4C30D7029CC2")
    
public static boolean getMasterSyncAutomatically() {
        try {
            return getContentService().getMasterSyncAutomatically();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * Sets the master auto-sync setting that applies to all the providers and accounts.
     * If this is false then the per-provider auto-sync setting is ignored.
     *
     * @param sync the master auto-sync setting that applies to all the providers and accounts
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.258 -0500", hash_original_method = "E617C3DAEABAF8BF63961F3B5075EF6F", hash_generated_method = "C3DC3ACE84430525740C7E9A7B451143")
    
public static void setMasterSyncAutomatically(boolean sync) {
        try {
            getContentService().setMasterSyncAutomatically(sync);
        } catch (RemoteException e) {
            // exception ignored; if this is thrown then it means the runtime is in the midst of
            // being restarted
        }
    }

    /**
     * Returns true if there is currently a sync operation for the given
     * account or authority in the pending list, or actively being processed.
     * @param account the account whose setting we are querying
     * @param authority the provider whose behavior is being queried
     * @return true if a sync is active for the given account or authority.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.260 -0500", hash_original_method = "14DB6E1B33F5033B88DD561A119ACEE1", hash_generated_method = "ECC24B419A569ED6BC69E4161E2272B0")
    
public static boolean isSyncActive(Account account, String authority) {
        try {
            return getContentService().isSyncActive(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * If a sync is active returns the information about it, otherwise returns null.
     * <p>
     * @return the SyncInfo for the currently active sync or null if one is not active.
     * @deprecated
     * Since multiple concurrent syncs are now supported you should use
     * {@link #getCurrentSyncs()} to get the accurate list of current syncs.
     * This method returns the first item from the list of current syncs
     * or null if there are none.
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.263 -0500", hash_original_method = "F46B20DF4060F21E0B5F9B4A6CDDD1B7", hash_generated_method = "438C07BD1AB0B1A7E7F9DA735814947B")
    
@Deprecated
    public static SyncInfo getCurrentSync() {
        try {
            final List<SyncInfo> syncs = getContentService().getCurrentSyncs();
            if (syncs.isEmpty()) {
                return null;
            }
            return syncs.get(0);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * Returns a list with information about all the active syncs. This list will be empty
     * if there are no active syncs.
     * @return a List of SyncInfo objects for the currently active syncs.
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.265 -0500", hash_original_method = "B8247507BA2F9E261470E53F362E3C80", hash_generated_method = "91FE7808D34F770BA2D170DA428F9642")
    
public static List<SyncInfo> getCurrentSyncs() {
        try {
            return getContentService().getCurrentSyncs();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * Returns the status that matches the authority.
     * @param account the account whose setting we are querying
     * @param authority the provider whose behavior is being queried
     * @return the SyncStatusInfo for the authority, or null if none exists
     * @hide
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.267 -0500", hash_original_method = "3CA3ACEA0F64C037745D2946B86898D9", hash_generated_method = "29F098BA53F2425AC9A06059ABC44C85")
    
public static SyncStatusInfo getSyncStatus(Account account, String authority) {
        try {
            return getContentService().getSyncStatus(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * Return true if the pending status is true of any matching authorities.
     * @param account the account whose setting we are querying
     * @param authority the provider whose behavior is being queried
     * @return true if there is a pending sync with the matching account and authority
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.270 -0500", hash_original_method = "6E26412AE39B82DA0658026BDB46955D", hash_generated_method = "37FC511BBA30F02A2A6F58726D81C6C1")
    
public static boolean isSyncPending(Account account, String authority) {
        try {
            return getContentService().isSyncPending(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * Request notifications when the different aspects of the SyncManager change. The
     * different items that can be requested are:
     * <ul>
     * <li> {@link #SYNC_OBSERVER_TYPE_PENDING}
     * <li> {@link #SYNC_OBSERVER_TYPE_ACTIVE}
     * <li> {@link #SYNC_OBSERVER_TYPE_SETTINGS}
     * </ul>
     * The caller can set one or more of the status types in the mask for any
     * given listener registration.
     * @param mask the status change types that will cause the callback to be invoked
     * @param callback observer to be invoked when the status changes
     * @return a handle that can be used to remove the listener at a later time
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.275 -0500", hash_original_method = "7A0C1068417A87F6CA2637AD64924867", hash_generated_method = "F5B4553A7A3FFEB7B00DC4021ABA9157")
    
public static Object addStatusChangeListener(int mask, final SyncStatusObserver callback) {
        if (callback == null) {
            throw new IllegalArgumentException("you passed in a null callback");
        }
        try {
            ISyncStatusObserver.Stub observer = new ISyncStatusObserver.Stub() {
                public void onStatusChanged(int which) throws RemoteException {
                    callback.onStatusChanged(which);
                }
            };
            getContentService().addStatusChangeListener(mask, observer);
            return observer;
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    /**
     * Remove a previously registered status change listener.
     * @param handle the handle that was returned by {@link #addStatusChangeListener}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.277 -0500", hash_original_method = "282C0904E19B2398B08E4044AA689CFC", hash_generated_method = "D8D1B1F28C28D055FCBAD7F0D2C0D0AA")
    
public static void removeStatusChangeListener(Object handle) {
        if (handle == null) {
            throw new IllegalArgumentException("you passed in a null handle");
        }
        try {
            getContentService().removeStatusChangeListener((ISyncStatusObserver.Stub) handle);
        } catch (RemoteException e) {
            // exception ignored; if this is thrown then it means the runtime is in the midst of
            // being restarted
        }
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.326 -0500", hash_original_method = "B848004A8469BC74A9D0115209F67BC2", hash_generated_method = "94DF7311AC3C0B57DE0F1EDB7F4E1C27")
    
public static IContentService getContentService() {
        if (sContentService != null) {
            return sContentService;
        }
        IBinder b = ServiceManager.getService(CONTENT_SERVICE_NAME);
        if (false) Log.v("ContentService", "default service binder = " + b);
        sContentService = IContentService.Stub.asInterface(b);
        if (false) Log.v("ContentService", "default service = " + sContentService);
        return sContentService;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.068 -0500", hash_original_field = "A41968FC00D339A21C48D575F770A7C0", hash_generated_field = "87B095273B7680C6E8D776FD7BED0443")

    @Deprecated
    public static final String SYNC_EXTRAS_ACCOUNT = "account";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.070 -0500", hash_original_field = "CF09F57A791BA3311E57194A6697C1F4", hash_generated_field = "8B7D39A0706705FDAF94593ED0FACFEA")

    public static final String SYNC_EXTRAS_EXPEDITED = "expedited";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.073 -0500", hash_original_field = "C26DD7ED8C5498C0ABEAC2AE59F756C6", hash_generated_field = "52C4CBE6F8AFC4D6C338F6272437F588")

    @Deprecated
    public static final String SYNC_EXTRAS_FORCE = "force";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.075 -0500", hash_original_field = "542D5F0DD66BC1FCF7A1A3C0BF5BBB61", hash_generated_field = "9CB83B5127CA25B88446759FC78BB810")

    public static final String SYNC_EXTRAS_IGNORE_SETTINGS = "ignore_settings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.078 -0500", hash_original_field = "F09CE8DC302A94D4500CE84902AB749F", hash_generated_field = "2460C39D3F3C8C8E9A6CA2DB50888065")

    public static final String SYNC_EXTRAS_IGNORE_BACKOFF = "ignore_backoff";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.080 -0500", hash_original_field = "C4BC51F939F3C1D362D580D6AEC161EE", hash_generated_field = "FB3D46B8F0404EBA4D41256EFCE69610")

    public static final String SYNC_EXTRAS_DO_NOT_RETRY = "do_not_retry";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.082 -0500", hash_original_field = "AEE5DE0AA2CE6BC6CF73B57D95CD70E6", hash_generated_field = "2CB777FABA87110DA15F0AAAA5216B13")

    public static final String SYNC_EXTRAS_MANUAL = "force";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.085 -0500", hash_original_field = "95E12551FD1813A3B4B131256742EF18", hash_generated_field = "C66AD9A9054789246D88C3CEF49E0FE1")

    public static final String SYNC_EXTRAS_UPLOAD = "upload";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.087 -0500", hash_original_field = "3BDAFF08B8B5D1FD247D54C93DBB602E", hash_generated_field = "085DFE00F23ABC519407289B800B9330")

    public static final String SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS = "deletions_override";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.089 -0500", hash_original_field = "9B04C3483128B9656C9D5AB3C89FCFF2", hash_generated_field = "A3280C9121A39AB92BFE4613E22A9F10")

    public static final String SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS = "discard_deletions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.092 -0500", hash_original_field = "8491F038D128DE460B8A25B1387E02FC", hash_generated_field = "9A51FA040B5EE450933873F1925571E2")

    public static final String SYNC_EXTRAS_INITIALIZE = "initialize";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.095 -0500", hash_original_field = "23CF7C1D7F7D34A52AE3013FCBEF7C56", hash_generated_field = "2A050A80E7005A896641161E25801F35")

    public static final String SCHEME_CONTENT = "content";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.097 -0500", hash_original_field = "661B0EEDBA4AA93209BB617B6341969F", hash_generated_field = "7BECC35C4D527BA52EC58C833FB0BB34")

    public static final String SCHEME_ANDROID_RESOURCE = "android.resource";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.099 -0500", hash_original_field = "E936C094499803E39E72484587CAF2CF", hash_generated_field = "D24B6CC01AD3F5B91B2CFC56B92A6E03")

    public static final String SCHEME_FILE = "file";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.102 -0500", hash_original_field = "2EAD75AB04113527403B51DCBB72747F", hash_generated_field = "A41DFC918AF8E5D466EE8DAB0BF274F3")

    public static final String CURSOR_ITEM_BASE_TYPE = "vnd.android.cursor.item";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.104 -0500", hash_original_field = "17F5CEE47CFF3494CBFFE56D772704E4", hash_generated_field = "2D7AE2632599144DAA81BD08B4C8870E")

    public static final String CURSOR_DIR_BASE_TYPE = "vnd.android.cursor.dir";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.106 -0500", hash_original_field = "FB3E57275E335E821108BE3B548603CC", hash_generated_field = "F78FAC8C90BCAD8994706D8A7F584B12")

    public static final int SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.109 -0500", hash_original_field = "C9B845FA7D67E780F5953AF428886192", hash_generated_field = "70645C1513ABFE107B9AF0BCB3F68340")

    public static final int SYNC_ERROR_AUTHENTICATION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.111 -0500", hash_original_field = "168F47458D5593C664B73B611FBF1FBD", hash_generated_field = "2B1BA46E87D9EA52416FF82A7E9FC949")

    public static final int SYNC_ERROR_IO = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.113 -0500", hash_original_field = "24CE6F46852C2F2734919325128F5A87", hash_generated_field = "7D02506C7CBA10BD97CA79FB59DD9D15")

    public static final int SYNC_ERROR_PARSE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.116 -0500", hash_original_field = "64054BF2C8929C7540D8641E54ACEE7C", hash_generated_field = "A315DAC0C98347D6DCFC6C6B32DA70BD")

    public static final int SYNC_ERROR_CONFLICT = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.118 -0500", hash_original_field = "CE336147B63150E06A0D5600AE8AFE50", hash_generated_field = "76FE33D22783EC3D4779B2B73BE75DE9")

    public static final int SYNC_ERROR_TOO_MANY_DELETIONS = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.120 -0500", hash_original_field = "33192654320AF69EF8125541E86B39F6", hash_generated_field = "6E9809F790E5D29754E07F710C703033")

    public static final int SYNC_ERROR_TOO_MANY_RETRIES = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.123 -0500", hash_original_field = "9AB680181A558C0E025232E5BF9A137B", hash_generated_field = "9EF2EEC53560FF1A3EC43F81D719B306")

    public static final int SYNC_ERROR_INTERNAL = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.125 -0500", hash_original_field = "3E7F77D8E6790DAE61B7FE9FBA555837", hash_generated_field = "EC6D4E9079B435808FB02F42CC269B78")

    public static final int SYNC_OBSERVER_TYPE_SETTINGS = 1<<0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.127 -0500", hash_original_field = "DFB06C7A2FBD2E5B04F1A08AA7980F13", hash_generated_field = "1F0C3937881F3FCFBF4E76673AB2169B")

    public static final int SYNC_OBSERVER_TYPE_PENDING = 1<<1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.130 -0500", hash_original_field = "9DBF60E4893D43D3EB277DF291B0D533", hash_generated_field = "0BBCE1310F4889E0CE3EBE1A843B06EC")

    public static final int SYNC_OBSERVER_TYPE_ACTIVE = 1<<2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.132 -0500", hash_original_field = "37193297878EB44A5A9FCE8EA35E4BCB", hash_generated_field = "F118FAF287C6D65262857F494C71AFCE")

    public static final int SYNC_OBSERVER_TYPE_STATUS = 1<<3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.134 -0500", hash_original_field = "A0C65633D27C02CCADCD775564711705", hash_generated_field = "4285FF406FEA88E6536E37E5D6191611")

    public static final int SYNC_OBSERVER_TYPE_ALL = 0x7fffffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.136 -0500", hash_original_field = "7080BEDBCDB1EF5A7F6AB6A07CEA366D", hash_generated_field = "52408C3F11A31C41464BB34D799E1590")

    // sampled accordingly.
    private static final int SLOW_THRESHOLD_MILLIS = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.323 -0500", hash_original_field = "A131A401ED0DA8DF09F09A820C9F3B73", hash_generated_field = "061BD03196A426FD4F175A19E9881E10")

    public static final String CONTENT_SERVICE_NAME = "content";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.328 -0500", hash_original_field = "FF075AB4CC757752C1C7F0A3C1F082AC", hash_generated_field = "EBBA89635D26FA830DBE060ABCA948AD")

    private static IContentService sContentService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.332 -0500", hash_original_field = "A6791527B14473DE7C470C42780930DC", hash_generated_field = "2E4D905723B5A2539B6E57BF8A2185DE")

    private static final String TAG = "ContentResolver";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.139 -0500", hash_original_field = "AAF1AFBF965F32CB2933765EF7007549", hash_generated_field = "E26D41E197237C24B0E74C0394AEDF83")

    private final Random mRandom = new Random();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.330 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;  // guarded by itself

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.141 -0500", hash_original_method = "8EB5ACCD206353DB8493F8AB9F861C85", hash_generated_method = "6A5A95FB8CC21CE7E1BA437DFE89FE79")
    
public ContentResolver(Context context) {
        mContext = context;
    }
    
    public class OpenResourceIdResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.175 -0500", hash_original_field = "DEA1ED7828F798697E4EA5B9016D799C", hash_generated_field = "3D94ED8234243D4DE3F50EF6E646D0E3")

        public Resources r;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.178 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.636 -0400", hash_original_method = "EC7BB03A160C6C88DBB9DFBF62B48748", hash_generated_method = "EC7BB03A160C6C88DBB9DFBF62B48748")
        public OpenResourceIdResult ()
        {
            //Synthesized constructor
        }

    }
    
    private final class CursorWrapperInner extends CrossProcessCursorWrapper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.290 -0500", hash_original_field = "AE288B6FA0FFB660720033CA9B71BF21", hash_generated_field = "EACA88E7B01FC8694B38FD93BBF3A6CA")

        public static final String TAG="CursorWrapperInner";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.288 -0500", hash_original_field = "07B30FADFA6E4AFA7D12BE53D83FAFCA", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

        private  IContentProvider mContentProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.292 -0500", hash_original_field = "6ADAA7D7C1C7D2FB7CE0E7D55A51778B", hash_generated_field = "91705AACD6DDE42AEA628776AF2A3DC6")

        private final CloseGuard mCloseGuard = CloseGuard.get();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.295 -0500", hash_original_field = "9CE7EF6F7F99E6E2E3761F5545AECF33", hash_generated_field = "FF245C536DEFD57B2DCDAA00E8BC192F")

        private boolean mProviderReleased;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.297 -0500", hash_original_method = "33833BC2FFA324FE6B3A882C16B09B24", hash_generated_method = "33833BC2FFA324FE6B3A882C16B09B24")
        
CursorWrapperInner(Cursor cursor, IContentProvider icp) {
            super(cursor);
            mContentProvider = icp;
            mCloseGuard.open("close");
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.300 -0500", hash_original_method = "CB76115716387DD39854EA1927F29C52", hash_generated_method = "7F65D1A29AE0504F5BE5938803E17F7A")
        
@Override
        public void close() {
            super.close();
            ContentResolver.this.releaseProvider(mContentProvider);
            mProviderReleased = true;

            if (mCloseGuard != null) {
                mCloseGuard.close();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.303 -0500", hash_original_method = "C6F30BD2AC97CE59E2F19D89687C7506", hash_generated_method = "3B61F6AE1F83736F44CD6E2B0F93B49E")
        
@Override
        protected void finalize() throws Throwable {
            try {
                if (mCloseGuard != null) {
                    mCloseGuard.warnIfOpen();
                }

                if (!mProviderReleased && mContentProvider != null) {
                    // Even though we are using CloseGuard, log this anyway so that
                    // application developers always see the message in the log.
                    Log.w(TAG, "Cursor finalized without prior close()");
                    ContentResolver.this.releaseProvider(mContentProvider);
                }
            } finally {
                super.finalize();
            }
        }
    }
    
    private final class ParcelFileDescriptorInner extends ParcelFileDescriptor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.310 -0500", hash_original_field = "EFBABC770A9D88F847529F4A7BC11412", hash_generated_field = "853BAF17ACDDF73D9A8E686A803B9543")

        public static final String TAG="ParcelFileDescriptorInner";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.308 -0500", hash_original_field = "07B30FADFA6E4AFA7D12BE53D83FAFCA", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

        private  IContentProvider mContentProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.313 -0500", hash_original_field = "CE03DB42A5D45548645D3DAE17C09BD9", hash_generated_field = "DCC2C4F00C9417AA6FB57200F6F6249D")

        private boolean mReleaseProviderFlag = false;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.315 -0500", hash_original_method = "84882D259A9B741E8CCE8DBD7345B8D5", hash_generated_method = "84882D259A9B741E8CCE8DBD7345B8D5")
        
ParcelFileDescriptorInner(ParcelFileDescriptor pfd, IContentProvider icp) {
            super(pfd);
            mContentProvider = icp;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.317 -0500", hash_original_method = "88C4FC226DB7C9E08A0225C4D4C037C0", hash_generated_method = "02D4C98809D4FD6525E42B472A32313E")
        
@Override
        public void close() throws IOException {
            if(!mReleaseProviderFlag) {
                super.close();
                ContentResolver.this.releaseProvider(mContentProvider);
                mReleaseProviderFlag = true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.319 -0500", hash_original_method = "E5C83F24E1B33F16225B47651FBE1E16", hash_generated_method = "11D45D835431FC51E9300998701C1155")
        
@Override
        protected void finalize() throws Throwable {
            if (!mReleaseProviderFlag) {
                close();
            }
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.143 -0500", hash_original_method = "E12362426E2275C617AE20C6C7FEA7C8", hash_generated_method = "CFEA63A8306FA2384868F10EC08571CD")
    
protected abstract IContentProvider acquireProvider(Context c, String name);
    /** Providing a default implementation of this, to avoid having to change
     * a lot of other things, but implementations of ContentResolver should
     * implement it. @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.146 -0500", hash_original_method = "4AF2A0465BC3B713C9C8E0417552AB76", hash_generated_method = "B46372EB146110E7FBF4F78FF4A12DF1")
    
protected IContentProvider acquireExistingProvider(Context c, String name) {
        return acquireProvider(c, name);
    }
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.148 -0500", hash_original_method = "72D1BF5F06ECC1999DE964627DE0A7C9", hash_generated_method = "39732D82E8BDAE9C259BDABDB3D5EEB1")
    
public abstract boolean releaseProvider(IContentProvider icp);

    /**
     * Return the MIME type of the given content URL.
     *
     * @param url A Uri identifying content (either a list or specific type),
     * using the content:// scheme.
     * @return A MIME type for the content, or null if the URL is invalid or the type is unknown
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.151 -0500", hash_original_method = "045596B6E0367AC7BED26FC054AD1E2B", hash_generated_method = "DF9E0D2B16441944892EBA418FBCD08C")
    
public final String getType(Uri url) {
        IContentProvider provider = acquireExistingProvider(url);
        if (provider != null) {
            try {
                return provider.getType(url);
            } catch (RemoteException e) {
                return null;
            } catch (java.lang.Exception e) {
                Log.w(TAG, "Failed to get type for: " + url + " (" + e.getMessage() + ")");
                return null;
            } finally {
                releaseProvider(provider);
            }
        }

        if (!SCHEME_CONTENT.equals(url.getScheme())) {
            return null;
        }

        try {
            String type = ActivityManagerNative.getDefault().getProviderMimeType(url);
            return type;
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return null;
        } catch (java.lang.Exception e) {
            Log.w(TAG, "Failed to get type for: " + url + " (" + e.getMessage() + ")");
            return null;
        }
    }

    /**
     * Query for the possible MIME types for the representations the given
     * content URL can be returned when opened as as stream with
     * {@link #openTypedAssetFileDescriptor}.  Note that the types here are
     * not necessarily a superset of the type returned by {@link #getType} --
     * many content providers can not return a raw stream for the structured
     * data that they contain.
     *
     * @param url A Uri identifying content (either a list or specific type),
     * using the content:// scheme.
     * @param mimeTypeFilter The desired MIME type.  This may be a pattern,
     * such as *\/*, to query for all available MIME types that match the
     * pattern.
     * @return Returns an array of MIME type strings for all availablle
     * data streams that match the given mimeTypeFilter.  If there are none,
     * null is returned.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.154 -0500", hash_original_method = "BFD7301BBEDEF32538E97E3FEFB31C63", hash_generated_method = "E74D022B8DC4284C8D15C672FCE79E03")
    
public String[] getStreamTypes(Uri url, String mimeTypeFilter) {
        IContentProvider provider = acquireProvider(url);
        if (provider == null) {
            return null;
        }

        try {
            return provider.getStreamTypes(url, mimeTypeFilter);
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return null;
        } finally {
            releaseProvider(provider);
        }
    }
    
   /**
    * On this query call, we want the information flow taint to flow from the
    * query call to the underlying cursor.  So just create a cursor and return it.
    * The DSCursor will take care of propagating the information flow.
    */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    public final Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder) {
       Cursor dsCursor = new DSCursor(uri, projection, selection, selectionArgs, sortOrder);
       return dsCursor;
    }

    /**
     * Open a stream on to the content associated with a content URI.  If there
     * is no data associated with the URI, FileNotFoundException is thrown.
     *
     * <h5>Accepts the following URI schemes:</h5>
     * <ul>
     * <li>content ({@link #SCHEME_CONTENT})</li>
     * <li>android.resource ({@link #SCHEME_ANDROID_RESOURCE})</li>
     * <li>file ({@link #SCHEME_FILE})</li>
     * </ul>
     *
     * <p>See {@link #openAssetFileDescriptor(Uri, String)} for more information
     * on these schemes.
     *
     * @param uri The desired URI.
     * @return InputStream
     * @throws FileNotFoundException if the provided URI could not be opened.
     * @see #openAssetFileDescriptor(Uri, String)
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.159 -0500", hash_original_method = "741F25E5E9079F60798D64718B03495A", hash_generated_method = "FF40C3A8319AD1636D47F56A713B2AB4")
    
public final InputStream openInputStream(Uri uri)
            throws FileNotFoundException {
        String scheme = uri.getScheme();
        if (SCHEME_ANDROID_RESOURCE.equals(scheme)) {
            // Note: left here to avoid breaking compatibility.  May be removed
            // with sufficient testing.
            OpenResourceIdResult r = getResourceId(uri);
            try {
                InputStream stream = r.r.openRawResource(r.id);
                return stream;
            } catch (Resources.NotFoundException ex) {
                throw new FileNotFoundException("Resource does not exist: " + uri);
            }
        } else if (SCHEME_FILE.equals(scheme)) {
            // Note: left here to avoid breaking compatibility.  May be removed
            // with sufficient testing.
            return new FileInputStream(uri.getPath());
        } else {
            AssetFileDescriptor fd = openAssetFileDescriptor(uri, "r");
            try {
                return fd != null ? fd.createInputStream() : null;
            } catch (IOException e) {
                throw new FileNotFoundException("Unable to create stream");
            }
        }
    }

    /**
     * Synonym for {@link #openOutputStream(Uri, String)
     * openOutputStream(uri, "w")}.
     * @throws FileNotFoundException if the provided URI could not be opened.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.161 -0500", hash_original_method = "11A517824302FF0E2A744E48D03F81F2", hash_generated_method = "EC8A4522D6689AF7AC2DC74A68F30469")
    
public final OutputStream openOutputStream(Uri uri)
            throws FileNotFoundException {
        return openOutputStream(uri, "w");
    }

    /**
     * Open a stream on to the content associated with a content URI.  If there
     * is no data associated with the URI, FileNotFoundException is thrown.
     *
     * <h5>Accepts the following URI schemes:</h5>
     * <ul>
     * <li>content ({@link #SCHEME_CONTENT})</li>
     * <li>file ({@link #SCHEME_FILE})</li>
     * </ul>
     *
     * <p>See {@link #openAssetFileDescriptor(Uri, String)} for more information
     * on these schemes.
     *
     * @param uri The desired URI.
     * @param mode May be "w", "wa", "rw", or "rwt".
     * @return OutputStream
     * @throws FileNotFoundException if the provided URI could not be opened.
     * @see #openAssetFileDescriptor(Uri, String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.164 -0500", hash_original_method = "99597D87D82436F243497E22352BC980", hash_generated_method = "8F2E08C0EC957DE4DCAAEA83F2EB3AAB")
    
public final OutputStream openOutputStream(Uri uri, String mode)
            throws FileNotFoundException {
        AssetFileDescriptor fd = openAssetFileDescriptor(uri, mode);
        try {
            return fd != null ? fd.createOutputStream() : null;
        } catch (IOException e) {
            throw new FileNotFoundException("Unable to create stream");
        }
    }

    /**
     * Open a raw file descriptor to access data under a URI.  This
     * is like {@link #openAssetFileDescriptor(Uri, String)}, but uses the
     * underlying {@link ContentProvider#openFile}
     * ContentProvider.openFile()} method, so will <em>not</em> work with
     * providers that return sub-sections of files.  If at all possible,
     * you should use {@link #openAssetFileDescriptor(Uri, String)}.  You
     * will receive a FileNotFoundException exception if the provider returns a
     * sub-section of a file.
     *
     * <h5>Accepts the following URI schemes:</h5>
     * <ul>
     * <li>content ({@link #SCHEME_CONTENT})</li>
     * <li>file ({@link #SCHEME_FILE})</li>
     * </ul>
     *
     * <p>See {@link #openAssetFileDescriptor(Uri, String)} for more information
     * on these schemes.
     *
     * @param uri The desired URI to open.
     * @param mode The file mode to use, as per {@link ContentProvider#openFile
     * ContentProvider.openFile}.
     * @return Returns a new ParcelFileDescriptor pointing to the file.  You
     * own this descriptor and are responsible for closing it when done.
     * @throws FileNotFoundException Throws FileNotFoundException of no
     * file exists under the URI or the mode is invalid.
     * @see #openAssetFileDescriptor(Uri, String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.166 -0500", hash_original_method = "8C4F5C0648F37279A7BD3F73F68574C8", hash_generated_method = "3820D1B39518AEC63C8262E5A5649BE1")
    
public final ParcelFileDescriptor openFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        AssetFileDescriptor afd = openAssetFileDescriptor(uri, mode);
        if (afd == null) {
            return null;
        }

        if (afd.getDeclaredLength() < 0) {
            // This is a full file!
            return afd.getParcelFileDescriptor();
        }

        // Client can't handle a sub-section of a file, so close what
        // we got and bail with an exception.
        try {
            afd.close();
        } catch (IOException e) {
        }

        throw new FileNotFoundException("Not a whole file");
    }

    /**
     * Open a raw file descriptor to access data under a URI.  This
     * interacts with the underlying {@link ContentProvider#openAssetFile}
     * method of the provider associated with the given URI, to retrieve any file stored there.
     *
     * <h5>Accepts the following URI schemes:</h5>
     * <ul>
     * <li>content ({@link #SCHEME_CONTENT})</li>
     * <li>android.resource ({@link #SCHEME_ANDROID_RESOURCE})</li>
     * <li>file ({@link #SCHEME_FILE})</li>
     * </ul>
     * <h5>The android.resource ({@link #SCHEME_ANDROID_RESOURCE}) Scheme</h5>
     * <p>
     * A Uri object can be used to reference a resource in an APK file.  The
     * Uri should be one of the following formats:
     * <ul>
     * <li><code>android.resource://package_name/id_number</code><br/>
     * <code>package_name</code> is your package name as listed in your AndroidManifest.xml.
     * For example <code>com.example.myapp</code><br/>
     * <code>id_number</code> is the int form of the ID.<br/>
     * The easiest way to construct this form is
     * <pre>Uri uri = Uri.parse("android.resource://com.example.myapp/" + R.raw.my_resource");</pre>
     * </li>
     * <li><code>android.resource://package_name/type/name</code><br/>
     * <code>package_name</code> is your package name as listed in your AndroidManifest.xml.
     * For example <code>com.example.myapp</code><br/>
     * <code>type</code> is the string form of the resource type.  For example, <code>raw</code>
     * or <code>drawable</code>.
     * <code>name</code> is the string form of the resource name.  That is, whatever the file
     * name was in your res directory, without the type extension.
     * The easiest way to construct this form is
     * <pre>Uri uri = Uri.parse("android.resource://com.example.myapp/raw/my_resource");</pre>
     * </li>
     * </ul>
     *
     * <p>Note that if this function is called for read-only input (mode is "r")
     * on a content: URI, it will instead call {@link #openTypedAssetFileDescriptor}
     * for you with a MIME type of "*\/*".  This allows such callers to benefit
     * from any built-in data conversion that a provider implements.
     *
     * @param uri The desired URI to open.
     * @param mode The file mode to use, as per {@link ContentProvider#openAssetFile
     * ContentProvider.openAssetFile}.
     * @return Returns a new ParcelFileDescriptor pointing to the file.  You
     * own this descriptor and are responsible for closing it when done.
     * @throws FileNotFoundException Throws FileNotFoundException of no
     * file exists under the URI or the mode is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.170 -0500", hash_original_method = "6D0B2664AB85671E5A18996AE47F9088", hash_generated_method = "BFCD5A6BA321AAF132FE3C66C4C8DF05")
    
public final AssetFileDescriptor openAssetFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        String scheme = uri.getScheme();
        if (SCHEME_ANDROID_RESOURCE.equals(scheme)) {
            if (!"r".equals(mode)) {
                throw new FileNotFoundException("Can't write resources: " + uri);
            }
            OpenResourceIdResult r = getResourceId(uri);
            try {
                return r.r.openRawResourceFd(r.id);
            } catch (Resources.NotFoundException ex) {
                throw new FileNotFoundException("Resource does not exist: " + uri);
            }
        } else if (SCHEME_FILE.equals(scheme)) {
            ParcelFileDescriptor pfd = ParcelFileDescriptor.open(
                    new File(uri.getPath()), modeToMode(uri, mode));
            return new AssetFileDescriptor(pfd, 0, -1);
        } else {
            if ("r".equals(mode)) {
                return openTypedAssetFileDescriptor(uri, "*/*", null);
            } else {
                IContentProvider provider = acquireProvider(uri);
                if (provider == null) {
                    throw new FileNotFoundException("No content provider: " + uri);
                }
                try {
                    AssetFileDescriptor fd = provider.openAssetFile(uri, mode);
                    if(fd == null) {
                        // The provider will be released by the finally{} clause
                        return null;
                    }
                    ParcelFileDescriptor pfd = new ParcelFileDescriptorInner(
                            fd.getParcelFileDescriptor(), provider);

                    // Success!  Don't release the provider when exiting, let
                    // ParcelFileDescriptorInner do that when it is closed.
                    provider = null;

                    return new AssetFileDescriptor(pfd, fd.getStartOffset(),
                            fd.getDeclaredLength());
                } catch (RemoteException e) {
                    // Somewhat pointless, as Activity Manager will kill this
                    // process shortly anyway if the depdendent ContentProvider dies.
                    throw new FileNotFoundException("Dead content provider: " + uri);
                } catch (FileNotFoundException e) {
                    throw e;
                } finally {
                    if (provider != null) {
                        releaseProvider(provider);
                    }
                }
            }
        }
    }

    /**
     * Open a raw file descriptor to access (potentially type transformed)
     * data from a "content:" URI.  This interacts with the underlying
     * {@link ContentProvider#openTypedAssetFile} method of the provider
     * associated with the given URI, to retrieve retrieve any appropriate
     * data stream for the data stored there.
     *
     * <p>Unlike {@link #openAssetFileDescriptor}, this function only works
     * with "content:" URIs, because content providers are the only facility
     * with an associated MIME type to ensure that the returned data stream
     * is of the desired type.
     *
     * <p>All text/* streams are encoded in UTF-8.
     *
     * @param uri The desired URI to open.
     * @param mimeType The desired MIME type of the returned data.  This can
     * be a pattern such as *\/*, which will allow the content provider to
     * select a type, though there is no way for you to determine what type
     * it is returning.
     * @param opts Additional provider-dependent options.
     * @return Returns a new ParcelFileDescriptor from which you can read the
     * data stream from the provider.  Note that this may be a pipe, meaning
     * you can't seek in it.  The only seek you should do is if the
     * AssetFileDescriptor contains an offset, to move to that offset before
     * reading.  You own this descriptor and are responsible for closing it when done.
     * @throws FileNotFoundException Throws FileNotFoundException of no
     * data of the desired type exists under the URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.173 -0500", hash_original_method = "6625A014E29DF928853C1F0BC5B9E856", hash_generated_method = "A64565705DE09307A3069692DD740984")
    
public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws FileNotFoundException {
        IContentProvider provider = acquireProvider(uri);
        if (provider == null) {
            throw new FileNotFoundException("No content provider: " + uri);
        }
        try {
            AssetFileDescriptor fd = provider.openTypedAssetFile(uri, mimeType, opts);
            if (fd == null) {
                // The provider will be released by the finally{} clause
                return null;
            }
            ParcelFileDescriptor pfd = new ParcelFileDescriptorInner(
                    fd.getParcelFileDescriptor(), provider);

            // Success!  Don't release the provider when exiting, let
            // ParcelFileDescriptorInner do that when it is closed.
            provider = null;

            return new AssetFileDescriptor(pfd, fd.getStartOffset(),
                    fd.getDeclaredLength());
        } catch (RemoteException e) {
            throw new FileNotFoundException("Dead content provider: " + uri);
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (provider != null) {
                releaseProvider(provider);
            }
        }
    }

    /**
     * Resolves an android.resource URI to a {@link Resources} and a resource id.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.182 -0500", hash_original_method = "39DD117C1A4502740FE90592CCDD92D2", hash_generated_method = "6ADD1ADE06D4525FCF9CA6CA8A1432D0")
    
public OpenResourceIdResult getResourceId(Uri uri) throws FileNotFoundException {
        String authority = uri.getAuthority();
        Resources r;
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        } else {
            try {
                r = mContext.getPackageManager().getResourcesForApplication(authority);
            } catch (NameNotFoundException ex) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        List<String> path = uri.getPathSegments();
        if (path == null) {
            throw new FileNotFoundException("No path: " + uri);
        }
        int len = path.size();
        int id;
        if (len == 1) {
            try {
                id = Integer.parseInt(path.get(0));
            } catch (NumberFormatException e) {
                throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
            }
        } else if (len == 2) {
            id = r.getIdentifier(path.get(1), path.get(0), authority);
        } else {
            throw new FileNotFoundException("More than two path segments: " + uri);
        }
        if (id == 0) {
            throw new FileNotFoundException("No resource found for: " + uri);
        }
        OpenResourceIdResult res = new OpenResourceIdResult();
        res.r = r;
        res.id = id;
        return res;
    }

    /**
     * Inserts a row into a table at the given URL.
     *
     * If the content provider supports transactions the insertion will be atomic.
     *
     * @param url The URL of the table to insert into.
     * @param values The initial values for the newly inserted row. The key is the column name for
     *               the field. Passing an empty ContentValues will create an empty row.
     * @return the URL of the newly created row.
     */
    @DSComment("Content model/data manipulation")
    @DSSpec(DSCat.CONTENT)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.187 -0500", hash_original_method = "21049B5CF31214AC69662F00A8291DA2", hash_generated_method = "30E6A8AA7791982EDB0C2593C57C1825")
    
public final Uri insert(Uri url, ContentValues values)
    {
        IContentProvider provider = acquireProvider(url);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown URL " + url);
        }
        try {
            long startTime = SystemClock.uptimeMillis();
            Uri createdRow = provider.insert(url, values);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "insert", null /* where */);
            return createdRow;
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return null;
        } finally {
            releaseProvider(provider);
        }
    }

    /**
     * Applies each of the {@link ContentProviderOperation} objects and returns an array
     * of their results. Passes through OperationApplicationException, which may be thrown
     * by the call to {@link ContentProviderOperation#apply}.
     * If all the applications succeed then a {@link ContentProviderResult} array with the
     * same number of elements as the operations will be returned. It is implementation-specific
     * how many, if any, operations will have been successfully applied if a call to
     * apply results in a {@link OperationApplicationException}.
     * @param authority the authority of the ContentProvider to which this batch should be applied
     * @param operations the operations to apply
     * @return the results of the applications
     * @throws OperationApplicationException thrown if an application fails.
     * See {@link ContentProviderOperation#apply} for more information.
     * @throws RemoteException thrown if a RemoteException is encountered while attempting
     *   to communicate with a remote provider.
     */
    @DSComment("Content model/data manipulation")
    @DSSpec(DSCat.CONTENT)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.189 -0500", hash_original_method = "35DA1841C97E840C3B5123B65D72A2FC", hash_generated_method = "74C8F16C7BE8369387E13E410A7C819D")
    
public ContentProviderResult[] applyBatch(String authority,
            ArrayList<ContentProviderOperation> operations)
            throws RemoteException, OperationApplicationException {
        ContentProviderClient provider = acquireContentProviderClient(authority);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown authority " + authority);
        }
        try {
            return provider.applyBatch(operations);
        } finally {
            provider.release();
        }
    }

    /**
     * Inserts multiple rows into a table at the given URL.
     *
     * This function make no guarantees about the atomicity of the insertions.
     *
     * @param url The URL of the table to insert into.
     * @param values The initial values for the newly inserted rows. The key is the column name for
     *               the field. Passing null will create an empty row.
     * @return the number of newly created rows.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.192 -0500", hash_original_method = "B00B6610FA17409048836C33B1F1B82B", hash_generated_method = "2AD28F6E6FE0929324667278137BC1B1")
    
public final int bulkInsert(Uri url, ContentValues[] values)
    {
        IContentProvider provider = acquireProvider(url);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown URL " + url);
        }
        try {
            long startTime = SystemClock.uptimeMillis();
            int rowsCreated = provider.bulkInsert(url, values);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "bulkinsert", null /* where */);
            return rowsCreated;
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return 0;
        } finally {
            releaseProvider(provider);
        }
    }

    /**
     * Deletes row(s) specified by a content URI.
     *
     * If the content provider supports transactions, the deletion will be atomic.
     *
     * @param url The URL of the row to delete.
     * @param where A filter to apply to rows before deleting, formatted as an SQL WHERE clause
                    (excluding the WHERE itself).
     * @return The number of rows deleted.
     */
    @DSComment("Content model/data manipulation")
    @DSSpec(DSCat.CONTENT)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.195 -0500", hash_original_method = "5F64E7642550035A4284C543DD08EBF1", hash_generated_method = "F77B1FA45188219F6988A6B6B681E82D")
    
public final int delete(Uri url, String where, String[] selectionArgs)
    {
        IContentProvider provider = acquireProvider(url);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown URL " + url);
        }
        try {
            long startTime = SystemClock.uptimeMillis();
            int rowsDeleted = provider.delete(url, where, selectionArgs);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "delete", where);
            return rowsDeleted;
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return -1;
        } finally {
            releaseProvider(provider);
        }
    }

    /**
     * Update row(s) in a content URI.
     *
     * If the content provider supports transactions the update will be atomic.
     *
     * @param uri The URI to modify.
     * @param values The new field values. The key is the column name for the field.
                     A null value will remove an existing field value.
     * @param where A filter to apply to rows before updating, formatted as an SQL WHERE clause
                    (excluding the WHERE itself).
     * @return the number of rows updated.
     * @throws NullPointerException if uri or values are null
     */
    @DSComment("Content model/data manipulation")
    @DSSpec(DSCat.CONTENT)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.197 -0500", hash_original_method = "93173B163A2993B2278E9CE2CA5F5268", hash_generated_method = "BFDFE97E646A1E83E92C8A9712FB4DAA")
    
public final int update(Uri uri, ContentValues values, String where,
            String[] selectionArgs) {
        IContentProvider provider = acquireProvider(uri);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        try {
            long startTime = SystemClock.uptimeMillis();
            int rowsUpdated = provider.update(uri, values, where, selectionArgs);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, uri, "update", where);
            return rowsUpdated;
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return -1;
        } finally {
            releaseProvider(provider);
        }
    }

    /**
     * Call an provider-defined method.  This can be used to implement
     * read or write interfaces which are cheaper than using a Cursor and/or
     * do not fit into the traditional table model.
     *
     * @param method provider-defined method name to call.  Opaque to
     *   framework, but must be non-null.
     * @param arg provider-defined String argument.  May be null.
     * @param extras provider-defined Bundle argument.  May be null.
     * @return a result Bundle, possibly null.  Will be null if the ContentProvider
     *   does not implement call.
     * @throws NullPointerException if uri or method is null
     * @throws IllegalArgumentException if uri is not known
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.201 -0500", hash_original_method = "7B97BF1D704BA5CFE2C56D2F21EF49E5", hash_generated_method = "75489650A20C25CB2C47805C67362FCF")
    
public final Bundle call(Uri uri, String method, String arg, Bundle extras) {
        if (uri == null) {
            throw new NullPointerException("uri == null");
        }
        if (method == null) {
            throw new NullPointerException("method == null");
        }
        IContentProvider provider = acquireProvider(uri);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        try {
            return provider.call(method, arg, extras);
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return null;
        } finally {
            releaseProvider(provider);
        }
    }

    /**
     * Returns the content provider for the given content URI.
     *
     * @param uri The URI to a content provider
     * @return The ContentProvider for the given URI, or null if no content provider is found.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.203 -0500", hash_original_method = "337E4492D27C715A525AA87619808C6B", hash_generated_method = "D3E5A9E03B3D395306466B5F9C7636EE")
    
public final IContentProvider acquireProvider(Uri uri) {
        if (!SCHEME_CONTENT.equals(uri.getScheme())) {
            return null;
        }
        String auth = uri.getAuthority();
        if (auth != null) {
            return acquireProvider(mContext, uri.getAuthority());
        }
        return null;
    }

    /**
     * Returns the content provider for the given content URI if the process
     * already has a reference on it.
     *
     * @param uri The URI to a content provider
     * @return The ContentProvider for the given URI, or null if no content provider is found.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.205 -0500", hash_original_method = "C657A24801BE240D39C6FCA466A49DFE", hash_generated_method = "EA85C9BEC125392527480C288C88B6E5")
    
public final IContentProvider acquireExistingProvider(Uri uri) {
        if (!SCHEME_CONTENT.equals(uri.getScheme())) {
            return null;
        }
        String auth = uri.getAuthority();
        if (auth != null) {
            return acquireExistingProvider(mContext, uri.getAuthority());
        }
        return null;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.208 -0500", hash_original_method = "1419B9D62800705D7AC72C916BD8939A", hash_generated_method = "78A6FB57CB599D6FBE4C0595594928C5")
    
public final IContentProvider acquireProvider(String name) {
        if (name == null) {
            return null;
        }
        return acquireProvider(mContext, name);
    }

    /**
     * Returns a {@link ContentProviderClient} that is associated with the {@link ContentProvider}
     * that services the content at uri, starting the provider if necessary. Returns
     * null if there is no provider associated wih the uri. The caller must indicate that they are
     * done with the provider by calling {@link ContentProviderClient#release} which will allow
     * the system to release the provider it it determines that there is no other reason for
     * keeping it active.
     * @param uri specifies which provider should be acquired
     * @return a {@link ContentProviderClient} that is associated with the {@link ContentProvider}
     * that services the content at uri or null if there isn't one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.210 -0500", hash_original_method = "5741247DD17162DA82750F730CE6B9A7", hash_generated_method = "9577100C500571EC3C43DE6060C2AB32")
    
public final ContentProviderClient acquireContentProviderClient(Uri uri) {
        IContentProvider provider = acquireProvider(uri);
        if (provider != null) {
            return new ContentProviderClient(this, provider);
        }

        return null;
    }

    /**
     * Returns a {@link ContentProviderClient} that is associated with the {@link ContentProvider}
     * with the authority of name, starting the provider if necessary. Returns
     * null if there is no provider associated wih the uri. The caller must indicate that they are
     * done with the provider by calling {@link ContentProviderClient#release} which will allow
     * the system to release the provider it it determines that there is no other reason for
     * keeping it active.
     * @param name specifies which provider should be acquired
     * @return a {@link ContentProviderClient} that is associated with the {@link ContentProvider}
     * with the authority of name or null if there isn't one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.212 -0500", hash_original_method = "01901AA9613048A3AC98A39C9DD35CAC", hash_generated_method = "01463757A9845EE63957222C67A0AA75")
    
public final ContentProviderClient acquireContentProviderClient(String name) {
        IContentProvider provider = acquireProvider(name);
        if (provider != null) {
            return new ContentProviderClient(this, provider);
        }

        return null;
    }
    
    /** 
     * This registers the specified ContentObserver to be called when the URI 
     * changes.  For example, the URI could be content://sms and the onChange()
     * functions will get called whenever an SMS message is received
     */
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public final void registerContentObserver(Uri uri, boolean notifyForDescendents,
            ContentObserver observer)
    {
      // Model the calls to onChange
      observer.onChange(false);
      // observer.onChange(false, uri); (not in API 15)

        try {
            getContentService().registerContentObserver(uri, notifyForDescendents,
                    observer.getContentObserver());
        } catch (RemoteException e) {
        }
    }

    /**
     * Unregisters a change observer.
     *
     * @param observer The previously registered observer that is no longer needed.
     * @see #registerContentObserver
     */
    @DSComment("Content model/data manipulation")
    @DSSpec(DSCat.CONTENT)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.217 -0500", hash_original_method = "A19276E2B38D6FC8E7769343C0EFAA57", hash_generated_method = "5D9FB3944E47D05E123BB023EFCB7F6C")
    
public final void unregisterContentObserver(ContentObserver observer) {
        try {
            IContentObserver contentObserver = observer.releaseContentObserver();
            if (contentObserver != null) {
                getContentService().unregisterContentObserver(
                        contentObserver);
            }
        } catch (RemoteException e) {
        }
    }

    /**
     * Notify registered observers that a row was updated.
     * To register, call {@link #registerContentObserver(android.net.Uri , boolean, android.database.ContentObserver) registerContentObserver()}.
     * By default, CursorAdapter objects will get this notification.
     *
     * @param uri
     * @param observer The observer that originated the change, may be <code>null</null>
     */
    @DSComment("Content model/data manipulation")
    @DSSpec(DSCat.CONTENT)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.219 -0500", hash_original_method = "E76834C8ABF23847CEBC5965503FC8D5", hash_generated_method = "3A5872C192B574229FFFA2AFF9004DE8")
    
public void notifyChange(Uri uri, ContentObserver observer) {
        notifyChange(uri, observer, true /* sync to network */);
    }

    /**
     * Notify registered observers that a row was updated.
     * To register, call {@link #registerContentObserver(android.net.Uri , boolean, android.database.ContentObserver) registerContentObserver()}.
     * By default, CursorAdapter objects will get this notification.
     *
     * @param uri
     * @param observer The observer that originated the change, may be <code>null</null>
     * @param syncToNetwork If true, attempt to sync the change to the network.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.222 -0500", hash_original_method = "F301FE1DDD6CC7648C7F98CD4F863542", hash_generated_method = "D4B7A5BA283E58792D86DBEA8A8D8DD8")
    
public void notifyChange(Uri uri, ContentObserver observer, boolean syncToNetwork) {
        try {
            getContentService().notifyChange(
                    uri, observer == null ? null : observer.getContentObserver(),
                    observer != null && observer.deliverSelfNotifications(), syncToNetwork);
        } catch (RemoteException e) {
        }
    }

    /**
     * Start an asynchronous sync operation. If you want to monitor the progress
     * of the sync you may register a SyncObserver. Only values of the following
     * types may be used in the extras bundle:
     * <ul>
     * <li>Integer</li>
     * <li>Long</li>
     * <li>Boolean</li>
     * <li>Float</li>
     * <li>Double</li>
     * <li>String</li>
     * </ul>
     *
     * @param uri the uri of the provider to sync or null to sync all providers.
     * @param extras any extras to pass to the SyncAdapter.
     * @deprecated instead use
     * {@link #requestSync(android.accounts.Account, String, android.os.Bundle)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.224 -0500", hash_original_method = "2D6405030D787F1D91AFA94E2D425989", hash_generated_method = "2BC23CCC23ED26D3FC49968347D88D06")
    
@Deprecated
    public void startSync(Uri uri, Bundle extras) {
        Account account = null;
        if (extras != null) {
            String accountName = extras.getString(SYNC_EXTRAS_ACCOUNT);
            if (!TextUtils.isEmpty(accountName)) {
                account = new Account(accountName, "com.google");
            }
            extras.remove(SYNC_EXTRAS_ACCOUNT);
        }
        requestSync(account, uri != null ? uri.getAuthority() : null, extras);
    }

    /**
     * Cancel any active or pending syncs that match the Uri. If the uri is null then
     * all syncs will be canceled.
     *
     * @param uri the uri of the provider to sync or null to sync all providers.
     * @deprecated instead use {@link #cancelSync(android.accounts.Account, String)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.231 -0500", hash_original_method = "B4949CE6FC68B3756629FF654EA4F622", hash_generated_method = "5B173F1CAADBA0D845AA88D09F8D97E7")
    
@Deprecated
    public void cancelSync(Uri uri) {
        cancelSync(null /* all accounts */, uri != null ? uri.getAuthority() : null);
    }

    /**
     * Returns sampling percentage for a given duration.
     *
     * Always returns at least 1%.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.279 -0500", hash_original_method = "5964C3B3CD446EC6DF12ED3CA7F7D861", hash_generated_method = "0921997DBC9424DEEBA9FFBFAEF6655B")
    
private int samplePercentForDuration(long durationMillis) {
        if (durationMillis >= SLOW_THRESHOLD_MILLIS) {
            return 100;
        }
        return (int) (100 * durationMillis / SLOW_THRESHOLD_MILLIS) + 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.282 -0500", hash_original_method = "339BAFB8AA6EDB4FDC193A187E8B0067", hash_generated_method = "99B2A5D5BBD81D5B67303C398B4F97C9")
    
private void maybeLogQueryToEventLog(long durationMillis,
                                         Uri uri, String[] projection,
                                         String selection, String sortOrder) {
        int samplePercent = samplePercentForDuration(durationMillis);
        if (samplePercent < 100) {
            synchronized (mRandom) {
                if (mRandom.nextInt(100) >= samplePercent) {
                    return;
                }
            }
        }

        StringBuilder projectionBuffer = new StringBuilder(100);
        if (projection != null) {
            for (int i = 0; i < projection.length; ++i) {
                // Note: not using a comma delimiter here, as the
                // multiple arguments to EventLog.writeEvent later
                // stringify with a comma delimiter, which would make
                // parsing uglier later.
                if (i != 0) projectionBuffer.append('/');
                projectionBuffer.append(projection[i]);
            }
        }

        // ActivityThread.currentPackageName() only returns non-null if the
        // current thread is an application main thread.  This parameter tells
        // us whether an event loop is blocked, and if so, which app it is.
        String blockingPackage = AppGlobals.getInitialPackage();

        EventLog.writeEvent(
            EventLogTags.CONTENT_QUERY_SAMPLE,
            uri.toString(),
            projectionBuffer.toString(),
            selection != null ? selection : "",
            sortOrder != null ? sortOrder : "",
            durationMillis,
            blockingPackage != null ? blockingPackage : "",
            samplePercent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:31.285 -0500", hash_original_method = "8C4CA0C0E96B47F9D6365343066B43C9", hash_generated_method = "5556939211C50A350B1A7BA3EEF921A3")
    
private void maybeLogUpdateToEventLog(
        long durationMillis, Uri uri, String operation, String selection) {
        int samplePercent = samplePercentForDuration(durationMillis);
        if (samplePercent < 100) {
            synchronized (mRandom) {
                if (mRandom.nextInt(100) >= samplePercent) {
                    return;
                }
            }
        }
        String blockingPackage = AppGlobals.getInitialPackage();
        EventLog.writeEvent(
            EventLogTags.CONTENT_UPDATE_SAMPLE,
            uri.toString(),
            operation,
            selection != null ? selection : "",
            durationMillis,
            blockingPackage != null ? blockingPackage : "",
            samplePercent);
    }
}

