package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public class BackupManager {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.071 -0500", hash_original_method = "BC0D552591769CED3EC0FA61A524F186", hash_generated_method = "2015B4D91CD8E20A9296C83B2EBCE38E")
    
private static void checkServiceBinder() {
        if (sService == null) {
            sService = IBackupManager.Stub.asInterface(
                    ServiceManager.getService(Context.BACKUP_SERVICE));
        }
    }

    /**
     * Convenience method for callers who need to indicate that some other package
     * needs a backup pass.  This can be useful in the case of groups of packages
     * that share a uid.
     * <p>
     * This method requires that the application hold the "android.permission.BACKUP"
     * permission if the package named in the argument does not run under the same uid
     * as the caller.
     *
     * @param packageName The package name identifying the application to back up.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.079 -0500", hash_original_method = "E185CA33D450CA66833DFDB97B746452", hash_generated_method = "EE09CEB717C5A8328067564E6B457ED5")
    
public static void dataChanged(String packageName) {
        checkServiceBinder();
        if (sService != null) {
            try {
                sService.dataChanged(packageName);
            } catch (RemoteException e) {
                Log.d(TAG, "dataChanged(pkg) couldn't connect");
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.064 -0500", hash_original_field = "E34B48711840A988E73B949944521997", hash_generated_field = "46BC9109135FC2CB00B0B600F09C9710")

    private static final String TAG = "BackupManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.068 -0500", hash_original_field = "34E00A576BAA32509DB5DBD95E7AD9F9", hash_generated_field = "A0386DA53DF2919548B4DED4A07BF9FC")

    private static IBackupManager sService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.066 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;

    /**
     * Constructs a BackupManager object through which the application can
     * communicate with the Android backup system.
     *
     * @param context The {@link android.content.Context} that was provided when
     *                one of your application's {@link android.app.Activity Activities}
     *                was created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.074 -0500", hash_original_method = "85561994F0AAB46E3AEAAB82C9107690", hash_generated_method = "6E365403833B142A6AA999CAEB020FAC")
    
public BackupManager(Context context) {
        mContext = context;
    }

    /**
     * Notifies the Android backup system that your application wishes to back up
     * new changes to its data.  A backup operation using your application's
     * {@link android.app.backup.BackupAgent} subclass will be scheduled when you
     * call this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.076 -0500", hash_original_method = "ADE0596EF26D37CE11FFEC5E571C37D4", hash_generated_method = "BF4AC2D842D44FB6ABE35CE29B125D9F")
    
public void dataChanged() {
        checkServiceBinder();
        if (sService != null) {
            try {
                sService.dataChanged(mContext.getPackageName());
            } catch (RemoteException e) {
                Log.d(TAG, "dataChanged() couldn't connect");
            }
        }
    }

    /**
     * Restore the calling application from backup.  The data will be restored from the
     * current backup dataset if the application has stored data there, or from
     * the dataset used during the last full device setup operation if the current
     * backup dataset has no matching data.  If no backup data exists for this application
     * in either source, a nonzero value will be returned.
     *
     * <p>If this method returns zero (meaning success), the OS will attempt to retrieve
     * a backed-up dataset from the remote transport, instantiate the application's
     * backup agent, and pass the dataset to the agent's
     * {@link android.app.backup.BackupAgent#onRestore(BackupDataInput, int, android.os.ParcelFileDescriptor) onRestore()}
     * method.
     *
     * @param observer The {@link RestoreObserver} to receive callbacks during the restore
     * operation. This must not be null.
     *
     * @return Zero on success; nonzero on error.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.081 -0500", hash_original_method = "0F46E379860B99708825D89131970D97", hash_generated_method = "4F9C77C32BC694F410AB977B57EE9DF9")
    
public int requestRestore(RestoreObserver observer) {
        int result = -1;
        checkServiceBinder();
        if (sService != null) {
            RestoreSession session = null;
            try {
                IRestoreSession binder = sService.beginRestoreSession(mContext.getPackageName(),
                        null);
                session = new RestoreSession(mContext, binder);
                result = session.restorePackage(mContext.getPackageName(), observer);
            } catch (RemoteException e) {
                Log.w(TAG, "restoreSelf() unable to contact service");
            } finally {
                if (session != null) {
                    session.endRestoreSession();
                }
            }
        }
        return result;
    }

    /**
     * Begin the process of restoring data from backup.  See the
     * {@link android.app.backup.RestoreSession} class for documentation on that process.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.083 -0500", hash_original_method = "4E9AC35DE965C4DA64E27C8C094DFEC3", hash_generated_method = "43192FDADA33ECB0B0000D4A4C95DF09")
    
public RestoreSession beginRestoreSession() {
        RestoreSession session = null;
        checkServiceBinder();
        if (sService != null) {
            try {
                // All packages, current transport
                IRestoreSession binder = sService.beginRestoreSession(null, null);
                session = new RestoreSession(mContext, binder);
            } catch (RemoteException e) {
                Log.w(TAG, "beginRestoreSession() couldn't connect");
            }
        }
        return session;
    }
}

