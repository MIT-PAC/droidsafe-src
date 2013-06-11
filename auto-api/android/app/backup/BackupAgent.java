package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.app.IBackupAgent;
import android.app.backup.IBackupManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import libcore.io.OsConstants;
import libcore.io.StructStat;

public abstract class BackupAgent extends ContextWrapper {
    private static final String TAG = "BackupAgent";
    private static final boolean DEBUG = true;
    public static final int TYPE_EOF = 0;
    public static final int TYPE_FILE = 1;
    public static final int TYPE_DIRECTORY = 2;
    public static final int TYPE_SYMLINK = 3;
    private final IBinder mBinder = new BackupServiceBinder().asBinder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.786 -0400", hash_original_method = "B5A8D7758CDB468D197C4191C97B62B7", hash_generated_method = "877621E6C78C5C5B64B9858AD52FA9FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BackupAgent() {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.787 -0400", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "B382920F64FDE934FF92CA84351F4952")
    @DSModeled(DSC.SAFE)
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.787 -0400", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "7FB40FD0A46FF2A8D044515CA84F4C99")
    @DSModeled(DSC.SAFE)
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    public abstract void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
             ParcelFileDescriptor newState) throws IOException;

    
    public abstract void onRestore(BackupDataInput data, int appVersionCode,
            ParcelFileDescriptor newState)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.788 -0400", hash_original_method = "9C0AD80B0DC65359576BE56D304BF72D", hash_generated_method = "198DF9AE15ECC0132A015FEE50E3FF6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onFullBackup(FullBackupDataOutput data) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(data.dsTaint);
        ApplicationInfo appInfo;
        appInfo = getApplicationInfo();
        String rootDir;
        rootDir = new File(appInfo.dataDir).getCanonicalPath();
        String filesDir;
        filesDir = getFilesDir().getCanonicalPath();
        String databaseDir;
        databaseDir = getDatabasePath("foo").getParentFile().getCanonicalPath();
        String sharedPrefsDir;
        sharedPrefsDir = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
        String cacheDir;
        cacheDir = getCacheDir().getCanonicalPath();
        String libDir;
        libDir = new File(appInfo.nativeLibraryDir).getCanonicalPath();
        libDir = null;
        HashSet<String> filterSet;
        filterSet = new HashSet<String>();
        String packageName;
        packageName = getPackageName();
        {
            filterSet.add(libDir);
        } //End block
        filterSet.add(cacheDir);
        filterSet.add(databaseDir);
        filterSet.add(sharedPrefsDir);
        filterSet.add(filesDir);
        fullBackupFileTree(packageName, FullBackup.ROOT_TREE_TOKEN, rootDir, filterSet, data);
        filterSet.add(rootDir);
        filterSet.remove(filesDir);
        fullBackupFileTree(packageName, FullBackup.DATA_TREE_TOKEN, filesDir, filterSet, data);
        filterSet.add(filesDir);
        filterSet.remove(databaseDir);
        fullBackupFileTree(packageName, FullBackup.DATABASE_TREE_TOKEN, databaseDir, filterSet, data);
        filterSet.add(databaseDir);
        filterSet.remove(sharedPrefsDir);
        fullBackupFileTree(packageName, FullBackup.SHAREDPREFS_TREE_TOKEN, sharedPrefsDir, filterSet, data);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.789 -0400", hash_original_method = "824AF36171DE5120222691B25F755417", hash_generated_method = "6662F028EF6E5AB297DA0FD5E6BCDF08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void fullBackupFile(File file, FullBackupDataOutput output) {
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(output.dsTaint);
        String mainDir;
        String filesDir;
        String dbDir;
        String spDir;
        String cacheDir;
        String libDir;
        String filePath;
        ApplicationInfo appInfo;
        appInfo = getApplicationInfo();
        try 
        {
            mainDir = new File(appInfo.dataDir).getCanonicalPath();
            filesDir = getFilesDir().getCanonicalPath();
            dbDir = getDatabasePath("foo").getParentFile().getCanonicalPath();
            spDir = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
            cacheDir = getCacheDir().getCanonicalPath();
            libDir = (appInfo.nativeLibraryDir == null)
                    ? null
                    : new File(appInfo.nativeLibraryDir).getCanonicalPath();
            filePath = file.getCanonicalPath();
        } //End block
        catch (IOException e)
        { }
        {
            boolean varBD6F6DE747F803B57B68982209430261_274415258 = (filePath.startsWith(cacheDir) || filePath.startsWith(libDir));
        } //End collapsed parenthetic
        final String domain;
        String rootpath;
        rootpath = null;
        {
            boolean var3B1A8B6A12F3116B32BB1EBDD00580C4_2063495349 = (filePath.startsWith(dbDir));
            {
                domain = FullBackup.DATABASE_TREE_TOKEN;
                rootpath = dbDir;
            } //End block
            {
                boolean var4BEF1FB233465CD510818A97C638953D_816519696 = (filePath.startsWith(spDir));
                {
                    domain = FullBackup.SHAREDPREFS_TREE_TOKEN;
                    rootpath = spDir;
                } //End block
                {
                    boolean varD8D5A722ECFB876EA777B5FEC20C95CC_596969710 = (filePath.startsWith(filesDir));
                    {
                        domain = FullBackup.DATA_TREE_TOKEN;
                        rootpath = filesDir;
                    } //End block
                    {
                        boolean varE7BF2A32BFAA505AE91D87C1A697A056_435937899 = (filePath.startsWith(mainDir));
                        {
                            domain = FullBackup.ROOT_TREE_TOKEN;
                            rootpath = mainDir;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        FullBackup.backupToTar(getPackageName(), domain, null, rootpath, filePath,
                output.getData());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.790 -0400", hash_original_method = "1DCDC7EEAECB17F3E82FC9B9A809AA59", hash_generated_method = "9664C9BDE192ED361F1A4B260967A2F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void fullBackupFileTree(String packageName, String domain, String rootPath,
            HashSet<String> excludes, FullBackupDataOutput output) {
        dsTaint.addTaint(rootPath);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(excludes.dsTaint);
        dsTaint.addTaint(domain);
        dsTaint.addTaint(output.dsTaint);
        File rootFile;
        rootFile = new File(rootPath);
        {
            boolean var34F7C2D1458DCEC4DEADCFD9E5B36F27_310638267 = (rootFile.exists());
            {
                LinkedList<File> scanQueue;
                scanQueue = new LinkedList<File>();
                scanQueue.add(rootFile);
                {
                    boolean var6A12FCE58C7360BB8E517FF6D268229C_571583654 = (scanQueue.size() > 0);
                    {
                        File file;
                        file = scanQueue.remove(0);
                        String filePath;
                        try 
                        {
                            filePath = file.getCanonicalPath();
                            {
                                boolean varAABDC1858412327408CF3D0A7AB39E8B_1201173408 = (excludes != null && excludes.contains(filePath));
                            } //End collapsed parenthetic
                            StructStat stat;
                            stat = Libcore.os.lstat(filePath);
                            {
                                boolean var596EEC4064A46B6DA43C788A4D3CA111_549500980 = (OsConstants.S_ISLNK(stat.st_mode));
                                {
                                    boolean var16235F9D7B3ACC1A3CAB788FA0D8512F_1113321692 = (OsConstants.S_ISDIR(stat.st_mode));
                                    {
                                        File[] contents;
                                        contents = file.listFiles();
                                        {
                                            {
                                                Iterator<File> seatecAstronomy42 = contents.iterator();
                                                seatecAstronomy42.hasNext();
                                                File entry = seatecAstronomy42.next();
                                                {
                                                    scanQueue.add(0, entry);
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                        catch (IOException e)
                        { }
                        catch (ErrnoException e)
                        { }
                        FullBackup.backupToTar(packageName, domain, null, rootPath, filePath,
                        output.getData());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.790 -0400", hash_original_method = "20621F323ECDCB060A13554E50206415", hash_generated_method = "80D8D0C00812BAF1AD4092E217A4058B")
    @DSModeled(DSC.SAFE)
    public void onRestoreFile(ParcelFileDescriptor data, long size,
            File destination, int type, long mode, long mtime) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(mtime);
        dsTaint.addTaint(type);
        dsTaint.addTaint(size);
        dsTaint.addTaint(destination.dsTaint);
        dsTaint.addTaint(mode);
        FullBackup.restoreFile(data, size, type, mode, mtime, destination);
        // ---------- Original Method ----------
        //FullBackup.restoreFile(data, size, type, mode, mtime, destination);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.791 -0400", hash_original_method = "588B4C1C50D0665AE90099672BE15A28", hash_generated_method = "7BE5A25C3C45EC5524705C7DC49A7438")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onRestoreFile(ParcelFileDescriptor data, long size,
            int type, String domain, String path, long mode, long mtime) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(domain);
        dsTaint.addTaint(path);
        dsTaint.addTaint(mtime);
        dsTaint.addTaint(type);
        dsTaint.addTaint(size);
        dsTaint.addTaint(mode);
        String basePath;
        basePath = null;
        Log.d(TAG, "onRestoreFile() size=" + size + " type=" + type
                + " domain=" + domain + " relpath=" + path + " mode=" + mode
                + " mtime=" + mtime);
        {
            boolean varD7197C93E997EEB150AD23286621871F_1330155708 = (domain.equals(FullBackup.DATA_TREE_TOKEN));
            {
                basePath = getFilesDir().getCanonicalPath();
            } //End block
            {
                boolean var1AD61ECB8D54CA38554F0AAB79619C63_1304807207 = (domain.equals(FullBackup.DATABASE_TREE_TOKEN));
                {
                    basePath = getDatabasePath("foo").getParentFile().getCanonicalPath();
                } //End block
                {
                    boolean var2EF4ECA397FB561BFA1F5074C6EB7D8C_2023008334 = (domain.equals(FullBackup.ROOT_TREE_TOKEN));
                    {
                        basePath = new File(getApplicationInfo().dataDir).getCanonicalPath();
                    } //End block
                    {
                        boolean varB2998DC520701FB7BB32EF948C988D7D_1653784347 = (domain.equals(FullBackup.SHAREDPREFS_TREE_TOKEN));
                        {
                            basePath = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
                        } //End block
                        {
                            boolean var52B9EBBE19DC1BB5B33A8CFB0A7E4D2E_999031656 = (domain.equals(FullBackup.CACHE_TREE_TOKEN));
                            {
                                basePath = getCacheDir().getCanonicalPath();
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            File outFile;
            outFile = new File(basePath, path);
            onRestoreFile(data, size, outFile, type, mode, mtime);
        } //End block
        {
            FullBackup.restoreFile(data, size, type, mode, mtime, null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.792 -0400", hash_original_method = "2EA8D194620A11CB2853C240391D2146", hash_generated_method = "0329252D18FCC0E4A491BB83843B1E65")
    @DSModeled(DSC.SAFE)
    public final IBinder onBind() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBinder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.792 -0400", hash_original_method = "20906B0697539AB9D636DC69F7DBB057", hash_generated_method = "8C76D002959021C3724C49CA814220AD")
    @DSModeled(DSC.SAFE)
    public void attach(Context context) {
        dsTaint.addTaint(context.dsTaint);
        attachBaseContext(context);
        // ---------- Original Method ----------
        //attachBaseContext(context);
    }

    
    private class BackupServiceBinder extends IBackupAgent.Stub {
        private static final String TAG = "BackupServiceBinder";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.792 -0400", hash_original_method = "8358D1CE671AA075D592B0F9339AC6D7", hash_generated_method = "B5F814E5B55E3AA60E0BA019E5E211B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void doBackup(ParcelFileDescriptor oldState,
                ParcelFileDescriptor data,
                ParcelFileDescriptor newState,
                int token, IBackupManager callbackBinder) throws RemoteException {
            dsTaint.addTaint(oldState.dsTaint);
            dsTaint.addTaint(token);
            dsTaint.addTaint(data.dsTaint);
            dsTaint.addTaint(callbackBinder.dsTaint);
            dsTaint.addTaint(newState.dsTaint);
            long ident;
            ident = Binder.clearCallingIdentity();
            BackupDataOutput output;
            output = new BackupDataOutput(data.getFileDescriptor());
            try 
            {
                BackupAgent.this.onBackup(oldState, output, newState);
            } //End block
            catch (IOException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw new RuntimeException(ex);
            } //End block
            catch (RuntimeException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw ex;
            } //End block
            finally 
            {
                Binder.restoreCallingIdentity(ident);
                try 
                {
                    callbackBinder.opComplete(token);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.793 -0400", hash_original_method = "7939DBF706CB3F6F728A24EEBE8A617D", hash_generated_method = "F0B0AE606AAA294772E32C1EA8922A04")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void doRestore(ParcelFileDescriptor data, int appVersionCode,
                ParcelFileDescriptor newState,
                int token, IBackupManager callbackBinder) throws RemoteException {
            dsTaint.addTaint(token);
            dsTaint.addTaint(appVersionCode);
            dsTaint.addTaint(data.dsTaint);
            dsTaint.addTaint(callbackBinder.dsTaint);
            dsTaint.addTaint(newState.dsTaint);
            long ident;
            ident = Binder.clearCallingIdentity();
            BackupDataInput input;
            input = new BackupDataInput(data.getFileDescriptor());
            try 
            {
                BackupAgent.this.onRestore(input, appVersionCode, newState);
            } //End block
            catch (IOException ex)
            {
                Log.d(TAG, "onRestore (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw new RuntimeException(ex);
            } //End block
            catch (RuntimeException ex)
            {
                Log.d(TAG, "onRestore (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw ex;
            } //End block
            finally 
            {
                Binder.restoreCallingIdentity(ident);
                try 
                {
                    callbackBinder.opComplete(token);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.793 -0400", hash_original_method = "D1AF436E8077A77141AB12CE24B7EAC7", hash_generated_method = "70E34E153C9E2DCC0D519639A182308F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void doFullBackup(ParcelFileDescriptor data,
                int token, IBackupManager callbackBinder) {
            dsTaint.addTaint(token);
            dsTaint.addTaint(data.dsTaint);
            dsTaint.addTaint(callbackBinder.dsTaint);
            long ident;
            ident = Binder.clearCallingIdentity();
            try 
            {
                BackupAgent.this.onFullBackup(new FullBackupDataOutput(data));
            } //End block
            catch (IOException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw new RuntimeException(ex);
            } //End block
            catch (RuntimeException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                throw ex;
            } //End block
            finally 
            {
                try 
                {
                    FileOutputStream out;
                    out = new FileOutputStream(data.getFileDescriptor());
                    byte[] buf;
                    buf = new byte[4];
                    out.write(buf);
                } //End block
                catch (IOException e)
                { }
                Binder.restoreCallingIdentity(ident);
                try 
                {
                    callbackBinder.opComplete(token);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.794 -0400", hash_original_method = "4CE4E3F6BFE9C329E5A1E18658253486", hash_generated_method = "7A6D32F9BF5CB3F4A29915A59AB45A83")
        @DSModeled(DSC.SAFE)
        @Override
        public void doRestoreFile(ParcelFileDescriptor data, long size,
                int type, String domain, String path, long mode, long mtime,
                int token, IBackupManager callbackBinder) throws RemoteException {
            dsTaint.addTaint(token);
            dsTaint.addTaint(data.dsTaint);
            dsTaint.addTaint(domain);
            dsTaint.addTaint(path);
            dsTaint.addTaint(mtime);
            dsTaint.addTaint(callbackBinder.dsTaint);
            dsTaint.addTaint(type);
            dsTaint.addTaint(size);
            dsTaint.addTaint(mode);
            long ident;
            ident = Binder.clearCallingIdentity();
            try 
            {
                BackupAgent.this.onRestoreFile(data, size, type, domain, path, mode, mtime);
            } //End block
            catch (IOException e)
            {
                throw new RuntimeException(e);
            } //End block
            finally 
            {
                Binder.restoreCallingIdentity(ident);
                try 
                {
                    callbackBinder.opComplete(token);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            // ---------- Original Method ----------
            //long ident = Binder.clearCallingIdentity();
            //try {
                //BackupAgent.this.onRestoreFile(data, size, type, domain, path, mode, mtime);
            //} catch (IOException e) {
                //throw new RuntimeException(e);
            //} finally {
                //Binder.restoreCallingIdentity(ident);
                //try {
                    //callbackBinder.opComplete(token);
                //} catch (RemoteException e) {
                //}
            //}
        }

        
    }


    
}


