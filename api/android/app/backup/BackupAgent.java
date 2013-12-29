package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

import libcore.io.ErrnoException;
import libcore.io.Libcore;
import libcore.io.OsConstants;
import libcore.io.StructStat;
import android.app.IBackupAgent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;





public abstract class BackupAgent extends ContextWrapper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.007 -0500", hash_original_field = "17EC5248C38043386AF5B4C9AEFBAA14", hash_generated_field = "CC20CEBA20D1053D2133B7442D01B53F")

    private static final String TAG = "BackupAgent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.007 -0500", hash_original_field = "9C97D618612CFF386E7AF19655372855", hash_generated_field = "0DA17BC1AEF6DBF011A4A750F5A71D57")

    private static final boolean DEBUG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.008 -0500", hash_original_field = "35BD8835CABA81F20B5E3DE3204829A8", hash_generated_field = "F411480428FF7BC88B285D624F0C1A18")

    public static final int TYPE_EOF = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.009 -0500", hash_original_field = "7A4CC01BC7B4608D2848CF60D4009E85", hash_generated_field = "151A491EED5B718681A96914789F4FA2")

    public static final int TYPE_FILE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.010 -0500", hash_original_field = "3D7389F2C8427982AF1E427255C263C1", hash_generated_field = "91BB5D30A9ED5809D5F8123C625B8485")

    public static final int TYPE_DIRECTORY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.011 -0500", hash_original_field = "18B461BEB9AE6B0537CF09C303196907", hash_generated_field = "5EF3A28FA8E5E382E3C6BB7DC99660C3")

    public static final int TYPE_SYMLINK = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.023 -0500", hash_original_field = "535CEF62923245CC8675751DE8FB8649", hash_generated_field = "7FA1510B7C47FB23A1BC45219C359763")


    private final IBinder mBinder = new BackupServiceBinder().asBinder();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.012 -0500", hash_original_method = "B5A8D7758CDB468D197C4191C97B62B7", hash_generated_method = "932AAC6CD3B64AB519D5E4125D4E72AF")
    public BackupAgent() {
        super(null);
    }

    /**
     * Provided as a convenience for agent implementations that need an opportunity
     * to do one-time initialization before the actual backup or restore operation
     * is begun.
     * <p>
     * Agents do not need to override this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.013 -0500", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "9687CB6D9F1B2A9EE9EE5E6EB201E78C")
    public void onCreate() {
    }

    /**
     * Provided as a convenience for agent implementations that need to do some
     * sort of shutdown process after backup or restore is completed.
     * <p>
     * Agents do not need to override this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.014 -0500", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "B543AE4E1838FF864DE64776FEE21A06")
    public void onDestroy() {
    }

    /**
     * The application is being asked to write any data changed since the last
     * time it performed a backup operation. The state data recorded during the
     * last backup pass is provided in the <code>oldState</code> file
     * descriptor. If <code>oldState</code> is <code>null</code>, no old state
     * is available and the application should perform a full backup. In both
     * cases, a representation of the final backup state after this pass should
     * be written to the file pointed to by the file descriptor wrapped in
     * <code>newState</code>.
     * <p>
     * Each entity written to the {@link android.app.backup.BackupDataOutput}
     * <code>data</code> stream will be transmitted
     * over the current backup transport and stored in the remote data set under
     * the key supplied as part of the entity.  Writing an entity with a negative
     * data size instructs the transport to delete whatever entity currently exists
     * under that key from the remote data set.
     * 
     * @param oldState An open, read-only ParcelFileDescriptor pointing to the
     *            last backup state provided by the application. May be
     *            <code>null</code>, in which case no prior state is being
     *            provided and the application should perform a full backup.
     * @param data A structured wrapper around an open, read/write
     *            file descriptor pointing to the backup data destination.
     *            Typically the application will use backup helper classes to
     *            write to this file.
     * @param newState An open, read/write ParcelFileDescriptor pointing to an
     *            empty file. The application should record the final backup
     *            state here after writing the requested data to the <code>data</code>
     *            output stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.014 -0500", hash_original_method = "3EE7A0CC9D81AA95F5F10419C2075716", hash_generated_method = "E87C91B51BA9F67DC3EBA84B883745BA")
    public abstract void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
             ParcelFileDescriptor newState) throws IOException;

    /**
     * The application is being restored from backup and should replace any
     * existing data with the contents of the backup. The backup data is
     * provided through the <code>data</code> parameter. Once
     * the restore is finished, the application should write a representation of
     * the final state to the <code>newState</code> file descriptor.
     * <p>
     * The application is responsible for properly erasing its old data and
     * replacing it with the data supplied to this method. No "clear user data"
     * operation will be performed automatically by the operating system. The
     * exception to this is in the case of a failed restore attempt: if
     * onRestore() throws an exception, the OS will assume that the
     * application's data may now be in an incoherent state, and will clear it
     * before proceeding.
     * 
     * @param data A structured wrapper around an open, read-only
     *            file descriptor pointing to a full snapshot of the
     *            application's data.  The application should consume every
     *            entity represented in this data stream.
     * @param appVersionCode The value of the <a
     * href="{@docRoot}guide/topics/manifest/manifest-element.html#vcode">{@code
     *            android:versionCode}</a> manifest attribute,
     *            from the application that backed up this particular data set. This
     *            makes it possible for an application's agent to distinguish among any
     *            possible older data versions when asked to perform the restore
     *            operation.
     * @param newState An open, read/write ParcelFileDescriptor pointing to an
     *            empty file. The application should record the final backup
     *            state here after restoring its data from the <code>data</code> stream.
     *            When a full-backup dataset is being restored, this will be <code>null</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.015 -0500", hash_original_method = "6AA44BE7189E208A2B9808783324262B", hash_generated_method = "D030D1219085DBE9123CB3AD08785434")
    public abstract void onRestore(BackupDataInput data, int appVersionCode,
            ParcelFileDescriptor newState)
            throws IOException;

    /**
     * The default implementation backs up the entirety of the application's "owned"
     * file system trees to the output.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.016 -0500", hash_original_method = "9C0AD80B0DC65359576BE56D304BF72D", hash_generated_method = "921A495D21A39B96F35048DE3259CC4E")
    public void onFullBackup(FullBackupDataOutput data) throws IOException {
        ApplicationInfo appInfo = getApplicationInfo();

        String rootDir = new File(appInfo.dataDir).getCanonicalPath();
        String filesDir = getFilesDir().getCanonicalPath();
        String databaseDir = getDatabasePath("foo").getParentFile().getCanonicalPath();
        String sharedPrefsDir = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
        String cacheDir = getCacheDir().getCanonicalPath();
        String libDir = (appInfo.nativeLibraryDir != null)
                ? new File(appInfo.nativeLibraryDir).getCanonicalPath()
                : null;

        // Filters, the scan queue, and the set of resulting entities
        HashSet<String> filterSet = new HashSet<String>();
        String packageName = getPackageName();

        // Okay, start with the app's root tree, but exclude all of the canonical subdirs
        if (libDir != null) {
            filterSet.add(libDir);
        }
        filterSet.add(cacheDir);
        filterSet.add(databaseDir);
        filterSet.add(sharedPrefsDir);
        filterSet.add(filesDir);
        fullBackupFileTree(packageName, FullBackup.ROOT_TREE_TOKEN, rootDir, filterSet, data);

        // Now do the same for the files dir, db dir, and shared prefs dir
        filterSet.add(rootDir);
        filterSet.remove(filesDir);
        fullBackupFileTree(packageName, FullBackup.DATA_TREE_TOKEN, filesDir, filterSet, data);

        filterSet.add(filesDir);
        filterSet.remove(databaseDir);
        fullBackupFileTree(packageName, FullBackup.DATABASE_TREE_TOKEN, databaseDir, filterSet, data);

        filterSet.add(databaseDir);
        filterSet.remove(sharedPrefsDir);
        fullBackupFileTree(packageName, FullBackup.SHAREDPREFS_TREE_TOKEN, sharedPrefsDir, filterSet, data);
    }

    
    private class BackupServiceBinder extends IBackupAgent.Stub {

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.107 -0400", hash_original_field = "4ADF9F269EDB752D9DAF2619A642F40E", hash_generated_field = "435867AAB7879E1905C087AA981414A1")

        private static final String TAG = "BackupServiceBinder";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.121 -0400", hash_original_method = "981BC5161F50D30EEB7E3364AFC1A4E5", hash_generated_method = "981BC5161F50D30EEB7E3364AFC1A4E5")
        public BackupServiceBinder ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.026 -0500", hash_original_method = "8358D1CE671AA075D592B0F9339AC6D7", hash_generated_method = "CC4CBE5F0C43522774AB6F9A02983D46")
        @Override
public void doBackup(ParcelFileDescriptor oldState,
                ParcelFileDescriptor data,
                ParcelFileDescriptor newState,
                int token, IBackupManager callbackBinder) throws RemoteException {
            // Ensure that we're running with the app's normal permission level
            long ident = Binder.clearCallingIdentity();

            if (DEBUG) Log.v(TAG, "doBackup() invoked");
            BackupDataOutput output = new BackupDataOutput(data.getFileDescriptor());

            try {
                BackupAgent.this.onBackup(oldState, output, newState);
            } catch (IOException ex) {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw new RuntimeException(ex);
            } catch (RuntimeException ex) {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw ex;
            } finally {
                Binder.restoreCallingIdentity(ident);
                try {
                    callbackBinder.opComplete(token);
                } catch (RemoteException e) {
                    // we'll time out anyway, so we're safe
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.027 -0500", hash_original_method = "7939DBF706CB3F6F728A24EEBE8A617D", hash_generated_method = "BE6CC23D2C314AFED0F15BA5954D5696")
        @Override
public void doRestore(ParcelFileDescriptor data, int appVersionCode,
                ParcelFileDescriptor newState,
                int token, IBackupManager callbackBinder) throws RemoteException {
            // Ensure that we're running with the app's normal permission level
            long ident = Binder.clearCallingIdentity();

            if (DEBUG) Log.v(TAG, "doRestore() invoked");
            BackupDataInput input = new BackupDataInput(data.getFileDescriptor());
            try {
                BackupAgent.this.onRestore(input, appVersionCode, newState);
            } catch (IOException ex) {
                Log.d(TAG, "onRestore (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw new RuntimeException(ex);
            } catch (RuntimeException ex) {
                Log.d(TAG, "onRestore (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw ex;
            } finally {
                Binder.restoreCallingIdentity(ident);
                try {
                    callbackBinder.opComplete(token);
                } catch (RemoteException e) {
                    // we'll time out anyway, so we're safe
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.028 -0500", hash_original_method = "D1AF436E8077A77141AB12CE24B7EAC7", hash_generated_method = "140EB103B01BB9E13F007ABA0796AF25")
        @Override
public void doFullBackup(ParcelFileDescriptor data,
                int token, IBackupManager callbackBinder) {
            // Ensure that we're running with the app's normal permission level
            long ident = Binder.clearCallingIdentity();

            if (DEBUG) Log.v(TAG, "doFullBackup() invoked");

            try {
                BackupAgent.this.onFullBackup(new FullBackupDataOutput(data));
            } catch (IOException ex) {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw new RuntimeException(ex);
            } catch (RuntimeException ex) {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw ex;
            } finally {
                // Send the EOD marker indicating that there is no more data
                // forthcoming from this agent.
                try {
                    FileOutputStream out = new FileOutputStream(data.getFileDescriptor());
                    byte[] buf = new byte[4];
                    out.write(buf);
                } catch (IOException e) {
                    Log.e(TAG, "Unable to finalize backup stream!");
                }

                Binder.restoreCallingIdentity(ident);
                try {
                    callbackBinder.opComplete(token);
                } catch (RemoteException e) {
                    // we'll time out anyway, so we're safe
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.029 -0500", hash_original_method = "4CE4E3F6BFE9C329E5A1E18658253486", hash_generated_method = "8F29C33AC134EEEC223352ED63FD5F68")
        @Override
public void doRestoreFile(ParcelFileDescriptor data, long size,
                int type, String domain, String path, long mode, long mtime,
                int token, IBackupManager callbackBinder) throws RemoteException {
            long ident = Binder.clearCallingIdentity();
            try {
                BackupAgent.this.onRestoreFile(data, size, type, domain, path, mode, mtime);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                Binder.restoreCallingIdentity(ident);
                try {
                    callbackBinder.opComplete(token);
                } catch (RemoteException e) {
                    // we'll time out anyway, so we're safe
                }
            }
        }
    }

    /**
     * Write an entire file as part of a full-backup operation.  The file's contents
     * will be delivered to the backup destination along with the metadata necessary
     * to place it with the proper location and permissions on the device where the
     * data is restored.
     *
     * @param file The file to be backed up.  The file must exist and be readable by
     *     the caller.
     * @param output The destination to which the backed-up file data will be sent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.018 -0500", hash_original_method = "824AF36171DE5120222691B25F755417", hash_generated_method = "7F1A9B0B6154F0FBB22D3533ABFEF41C")
    public final void fullBackupFile(File file, FullBackupDataOutput output) {
        // Look up where all of our various well-defined dir trees live on this device
        String mainDir;
        String filesDir;
        String dbDir;
        String spDir;
        String cacheDir;
        String libDir;
        String filePath;

        ApplicationInfo appInfo = getApplicationInfo();

        try {
            mainDir = new File(appInfo.dataDir).getCanonicalPath();
            filesDir = getFilesDir().getCanonicalPath();
            dbDir = getDatabasePath("foo").getParentFile().getCanonicalPath();
            spDir = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
            cacheDir = getCacheDir().getCanonicalPath();
            libDir = (appInfo.nativeLibraryDir == null)
                    ? null
                    : new File(appInfo.nativeLibraryDir).getCanonicalPath();

            // Now figure out which well-defined tree the file is placed in, working from
            // most to least specific.  We also specifically exclude the lib and cache dirs.
            filePath = file.getCanonicalPath();
        } catch (IOException e) {
            Log.w(TAG, "Unable to obtain canonical paths");
            return;
        }

        if (filePath.startsWith(cacheDir) || filePath.startsWith(libDir)) {
            Log.w(TAG, "lib and cache files are not backed up");
            return;
        }

        final String domain;
        String rootpath = null;
        if (filePath.startsWith(dbDir)) {
            domain = FullBackup.DATABASE_TREE_TOKEN;
            rootpath = dbDir;
        } else if (filePath.startsWith(spDir)) {
            domain = FullBackup.SHAREDPREFS_TREE_TOKEN;
            rootpath = spDir;
        } else if (filePath.startsWith(filesDir)) {
            domain = FullBackup.DATA_TREE_TOKEN;
            rootpath = filesDir;
        } else if (filePath.startsWith(mainDir)) {
            domain = FullBackup.ROOT_TREE_TOKEN;
            rootpath = mainDir;
        } else {
            Log.w(TAG, "File " + filePath + " is in an unsupported location; skipping");
            return;
        }

        // And now that we know where it lives, semantically, back it up appropriately
        Log.i(TAG, "backupFile() of " + filePath + " => domain=" + domain
                + " rootpath=" + rootpath);
        FullBackup.backupToTar(getPackageName(), domain, null, rootpath, filePath,
                output.getData());
    }

    /**
     * Scan the dir tree (if it actually exists) and process each entry we find.  If the
     * 'excludes' parameter is non-null, it is consulted each time a new file system entity
     * is visited to see whether that entity (and its subtree, if appropriate) should be
     * omitted from the backup process.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.019 -0500", hash_original_method = "1DCDC7EEAECB17F3E82FC9B9A809AA59", hash_generated_method = "34E360DC77C031E89856D4EDAF765553")
    protected final void fullBackupFileTree(String packageName, String domain, String rootPath,
            HashSet<String> excludes, FullBackupDataOutput output) {
        File rootFile = new File(rootPath);
        if (rootFile.exists()) {
            LinkedList<File> scanQueue = new LinkedList<File>();
            scanQueue.add(rootFile);

            while (scanQueue.size() > 0) {
                File file = scanQueue.remove(0);
                String filePath;
                try {
                    filePath = file.getCanonicalPath();

                    // prune this subtree?
                    if (excludes != null && excludes.contains(filePath)) {
                        continue;
                    }

                    // If it's a directory, enqueue its contents for scanning.
                    StructStat stat = Libcore.os.lstat(filePath);
                    if (OsConstants.S_ISLNK(stat.st_mode)) {
                        if (DEBUG) Log.i(TAG, "Symlink (skipping)!: " + file);
                        continue;
                    } else if (OsConstants.S_ISDIR(stat.st_mode)) {
                        File[] contents = file.listFiles();
                        if (contents != null) {
                            for (File entry : contents) {
                                scanQueue.add(0, entry);
                            }
                        }
                    }
                } catch (IOException e) {
                    if (DEBUG) Log.w(TAG, "Error canonicalizing path of " + file);
                    continue;
                } catch (ErrnoException e) {
                    if (DEBUG) Log.w(TAG, "Error scanning file " + file + " : " + e);
                    continue;
                }

                // Finally, back this file up before proceeding
                FullBackup.backupToTar(packageName, domain, null, rootPath, filePath,
                        output.getData());
            }
        }
    }

    /**
     * Handle the data delivered via the given file descriptor during a full restore
     * operation.  The agent is given the path to the file's original location as well
     * as its size and metadata.
     * <p>
     * The file descriptor can only be read for {@code size} bytes; attempting to read
     * more data has undefined behavior.
     * <p>
     * The default implementation creates the destination file/directory and populates it
     * with the data from the file descriptor, then sets the file's access mode and
     * modification time to match the restore arguments.
     *
     * @param data A read-only file descriptor from which the agent can read {@code size}
     *     bytes of file data.
     * @param size The number of bytes of file content to be restored to the given
     *     destination.  If the file system object being restored is a directory, {@code size}
     *     will be zero.
     * @param destination The File on disk to be restored with the given data.
     * @param type The kind of file system object being restored.  This will be either
     *     {@link BackupAgent#TYPE_FILE} or {@link BackupAgent#TYPE_DIRECTORY}.
     * @param mode The access mode to be assigned to the destination after its data is
     *     written.  This is in the standard format used by {@code chmod()}.
     * @param mtime The modification time of the file when it was backed up, suitable to
     *     be assigned to the file after its data is written.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.020 -0500", hash_original_method = "20621F323ECDCB060A13554E50206415", hash_generated_method = "A0FDC0D9DC2D0608C7F9287E646578E2")
    public void onRestoreFile(ParcelFileDescriptor data, long size,
            File destination, int type, long mode, long mtime)
            throws IOException {
        FullBackup.restoreFile(data, size, type, mode, mtime, destination);
    }

    /**
     * Only specialized platform agents should overload this entry point to support
     * restores to crazy non-app locations.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.022 -0500", hash_original_method = "588B4C1C50D0665AE90099672BE15A28", hash_generated_method = "D0E713E98BCCCEDBECADDD3DF4D2913B")
    protected void onRestoreFile(ParcelFileDescriptor data, long size,
            int type, String domain, String path, long mode, long mtime)
            throws IOException {
        String basePath = null;

        if (DEBUG) Log.d(TAG, "onRestoreFile() size=" + size + " type=" + type
                + " domain=" + domain + " relpath=" + path + " mode=" + mode
                + " mtime=" + mtime);

        // Parse out the semantic domains into the correct physical location
        if (domain.equals(FullBackup.DATA_TREE_TOKEN)) {
            basePath = getFilesDir().getCanonicalPath();
        } else if (domain.equals(FullBackup.DATABASE_TREE_TOKEN)) {
            basePath = getDatabasePath("foo").getParentFile().getCanonicalPath();
        } else if (domain.equals(FullBackup.ROOT_TREE_TOKEN)) {
            basePath = new File(getApplicationInfo().dataDir).getCanonicalPath();
        } else if (domain.equals(FullBackup.SHAREDPREFS_TREE_TOKEN)) {
            basePath = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
        } else if (domain.equals(FullBackup.CACHE_TREE_TOKEN)) {
            basePath = getCacheDir().getCanonicalPath();
        } else {
            // Not a supported location
            Log.i(TAG, "Data restored from non-app domain " + domain + ", ignoring");
        }

        // Now that we've figured out where the data goes, send it on its way
        if (basePath != null) {
            File outFile = new File(basePath, path);
            if (DEBUG) Log.i(TAG, "[" + domain + " : " + path + "] mapped to " + outFile.getPath());
            onRestoreFile(data, size, outFile, type, mode, mtime);
        } else {
            // Not a supported output location?  We need to consume the data
            // anyway, so just use the default "copy the data out" implementation
            // with a null destination.
            if (DEBUG) Log.i(TAG, "[ skipping data from unsupported domain " + domain + "]");
            FullBackup.restoreFile(data, size, type, mode, mtime, null);
        }
    }

    // ----- Core implementation -----

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.022 -0500", hash_original_method = "2EA8D194620A11CB2853C240391D2146", hash_generated_method = "2322775DBA6D1BBD8A29F3CB4D39A778")
    public final IBinder onBind() {
        return mBinder;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:23.024 -0500", hash_original_method = "20906B0697539AB9D636DC69F7DBB057", hash_generated_method = "B1E5722DDCD620B449849F032EB52676")
    public void attach(Context context) {
        attachBaseContext(context);
    }
}

