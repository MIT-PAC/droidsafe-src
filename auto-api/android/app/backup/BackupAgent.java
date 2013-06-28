package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.373 -0400", hash_original_field = "6812121D3014FEFEE7A1118C07DF58B2", hash_generated_field = "7FA1510B7C47FB23A1BC45219C359763")

    private final IBinder mBinder = new BackupServiceBinder().asBinder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.374 -0400", hash_original_method = "B5A8D7758CDB468D197C4191C97B62B7", hash_generated_method = "10BCF02BE8187F1DDF7130F69F515B81")
    public  BackupAgent() {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.375 -0400", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "7564C9BAB223A8E7FAC043FBCC648B76")
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.376 -0400", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "E5C4FFF396F837C85A1D40A9B232BFA0")
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    public abstract void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
             ParcelFileDescriptor newState) throws IOException;

    
    public abstract void onRestore(BackupDataInput data, int appVersionCode,
            ParcelFileDescriptor newState)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.378 -0400", hash_original_method = "9C0AD80B0DC65359576BE56D304BF72D", hash_generated_method = "21421B0C047B779F30D07ADBEF9740B5")
    public void onFullBackup(FullBackupDataOutput data) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ApplicationInfo appInfo = getApplicationInfo();
        String rootDir = new File(appInfo.dataDir).getCanonicalPath();
        String filesDir = getFilesDir().getCanonicalPath();
        String databaseDir = getDatabasePath("foo").getParentFile().getCanonicalPath();
        String sharedPrefsDir = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
        String cacheDir = getCacheDir().getCanonicalPath();
        String libDir;
        libDir = new File(appInfo.nativeLibraryDir).getCanonicalPath();
        libDir = null;
        HashSet<String> filterSet = new HashSet<String>();
        String packageName = getPackageName();
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
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.725 -0400", hash_original_method = "824AF36171DE5120222691B25F755417", hash_generated_method = "8947A379E1D96C39617FFFBCB230E34C")
    public final void fullBackupFile(File file, FullBackupDataOutput output) {
        String mainDir = null;
        String filesDir = null;
        String dbDir = null;
        String spDir = null;
        String cacheDir = null;
        String libDir = null;
        String filePath = null;
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
            boolean varBD6F6DE747F803B57B68982209430261_404494007 = (filePath.startsWith(cacheDir) || filePath.startsWith(libDir));
        } //End collapsed parenthetic
        String domain;
        String rootpath;
        rootpath = null;
        {
            boolean var3B1A8B6A12F3116B32BB1EBDD00580C4_1340681869 = (filePath.startsWith(dbDir));
            {
                domain = FullBackup.DATABASE_TREE_TOKEN;
                rootpath = dbDir;
            } //End block
            {
                boolean var4BEF1FB233465CD510818A97C638953D_304762306 = (filePath.startsWith(spDir));
                {
                    domain = FullBackup.SHAREDPREFS_TREE_TOKEN;
                    rootpath = spDir;
                } //End block
                {
                    boolean varD8D5A722ECFB876EA777B5FEC20C95CC_407516142 = (filePath.startsWith(filesDir));
                    {
                        domain = FullBackup.DATA_TREE_TOKEN;
                        rootpath = filesDir;
                    } //End block
                    {
                        boolean varE7BF2A32BFAA505AE91D87C1A697A056_77567745 = (filePath.startsWith(mainDir));
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
        addTaint(file.getTaint());
        addTaint(output.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.979 -0400", hash_original_method = "1DCDC7EEAECB17F3E82FC9B9A809AA59", hash_generated_method = "2F9629A3CB7EE5533516B5D50C133740")
    protected final void fullBackupFileTree(String packageName, String domain, String rootPath,
            HashSet<String> excludes, FullBackupDataOutput output) {
        File rootFile;
        rootFile = new File(rootPath);
        {
            boolean var34F7C2D1458DCEC4DEADCFD9E5B36F27_313252173 = (rootFile.exists());
            {
                LinkedList<File> scanQueue;
                scanQueue = new LinkedList<File>();
                scanQueue.add(rootFile);
                {
                    boolean var6A12FCE58C7360BB8E517FF6D268229C_698562631 = (scanQueue.size() > 0);
                    {
                        File file;
                        file = scanQueue.remove(0);
                        String filePath = null;
                        try 
                        {
                            filePath = file.getCanonicalPath();
                            {
                                boolean varAABDC1858412327408CF3D0A7AB39E8B_1186037411 = (excludes != null && excludes.contains(filePath));
                            } //End collapsed parenthetic
                            StructStat stat;
                            stat = Libcore.os.lstat(filePath);
                            {
                                boolean var596EEC4064A46B6DA43C788A4D3CA111_256348442 = (OsConstants.S_ISLNK(stat.st_mode));
                                {
                                    boolean var16235F9D7B3ACC1A3CAB788FA0D8512F_999083562 = (OsConstants.S_ISDIR(stat.st_mode));
                                    {
                                        File[] contents;
                                        contents = file.listFiles();
                                        {
                                            {
                                                File entry = contents[0];
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
        addTaint(packageName.getTaint());
        addTaint(domain.getTaint());
        addTaint(rootPath.getTaint());
        addTaint(excludes.getTaint());
        addTaint(output.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.379 -0400", hash_original_method = "20621F323ECDCB060A13554E50206415", hash_generated_method = "D5D6ACE741202B3511DADB0490CAF103")
    public void onRestoreFile(ParcelFileDescriptor data, long size,
            File destination, int type, long mode, long mtime) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        FullBackup.restoreFile(data, size, type, mode, mtime, destination);
        addTaint(data.getTaint());
        addTaint(size);
        addTaint(destination.getTaint());
        addTaint(type);
        addTaint(mode);
        addTaint(mtime);
        // ---------- Original Method ----------
        //FullBackup.restoreFile(data, size, type, mode, mtime, destination);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.381 -0400", hash_original_method = "588B4C1C50D0665AE90099672BE15A28", hash_generated_method = "04AD828CF657D8CFDE8873423E073835")
    protected void onRestoreFile(ParcelFileDescriptor data, long size,
            int type, String domain, String path, long mode, long mtime) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        String basePath = null;
        Log.d(TAG, "onRestoreFile() size=" + size + " type=" + type
                + " domain=" + domain + " relpath=" + path + " mode=" + mode
                + " mtime=" + mtime);
        {
            boolean varD7197C93E997EEB150AD23286621871F_1206413783 = (domain.equals(FullBackup.DATA_TREE_TOKEN));
            {
                basePath = getFilesDir().getCanonicalPath();
            } //End block
            {
                boolean var1AD61ECB8D54CA38554F0AAB79619C63_90210064 = (domain.equals(FullBackup.DATABASE_TREE_TOKEN));
                {
                    basePath = getDatabasePath("foo").getParentFile().getCanonicalPath();
                } //End block
                {
                    boolean var2EF4ECA397FB561BFA1F5074C6EB7D8C_158137673 = (domain.equals(FullBackup.ROOT_TREE_TOKEN));
                    {
                        basePath = new File(getApplicationInfo().dataDir).getCanonicalPath();
                    } //End block
                    {
                        boolean varB2998DC520701FB7BB32EF948C988D7D_667422686 = (domain.equals(FullBackup.SHAREDPREFS_TREE_TOKEN));
                        {
                            basePath = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
                        } //End block
                        {
                            boolean var52B9EBBE19DC1BB5B33A8CFB0A7E4D2E_2079602288 = (domain.equals(FullBackup.CACHE_TREE_TOKEN));
                            {
                                basePath = getCacheDir().getCanonicalPath();
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            File outFile = new File(basePath, path);
            onRestoreFile(data, size, outFile, type, mode, mtime);
        } //End block
        {
            FullBackup.restoreFile(data, size, type, mode, mtime, null);
        } //End block
        addTaint(data.getTaint());
        addTaint(size);
        addTaint(type);
        addTaint(domain.getTaint());
        addTaint(path.getTaint());
        addTaint(mode);
        addTaint(mtime);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.382 -0400", hash_original_method = "2EA8D194620A11CB2853C240391D2146", hash_generated_method = "0CA0EF9343CA3754278107422723D876")
    public final IBinder onBind() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1137276722 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1137276722 = mBinder;
        varB4EAC82CA7396A68D541C85D26508E83_1137276722.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1137276722;
        // ---------- Original Method ----------
        //return mBinder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.382 -0400", hash_original_method = "20906B0697539AB9D636DC69F7DBB057", hash_generated_method = "4A717DF2B2372B2D8E2471BB6D393064")
    public void attach(Context context) {
        attachBaseContext(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //attachBaseContext(context);
    }

    
    private class BackupServiceBinder extends IBackupAgent.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.383 -0400", hash_original_method = "981BC5161F50D30EEB7E3364AFC1A4E5", hash_generated_method = "981BC5161F50D30EEB7E3364AFC1A4E5")
        public BackupServiceBinder ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.384 -0400", hash_original_method = "8358D1CE671AA075D592B0F9339AC6D7", hash_generated_method = "6D10D99B20C19EDDD0B18795097E28DD")
        @Override
        public void doBackup(ParcelFileDescriptor oldState,
                ParcelFileDescriptor data,
                ParcelFileDescriptor newState,
                int token, IBackupManager callbackBinder) throws RemoteException {
            long ident = Binder.clearCallingIdentity();
            BackupDataOutput output = new BackupDataOutput(data.getFileDescriptor());
            try 
            {
                BackupAgent.this.onBackup(oldState, output, newState);
            } //End block
            catch (IOException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } //End block
            catch (RuntimeException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                if (DroidSafeAndroidRuntime.control) throw ex;
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
            addTaint(oldState.getTaint());
            addTaint(data.getTaint());
            addTaint(newState.getTaint());
            addTaint(token);
            addTaint(callbackBinder.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.385 -0400", hash_original_method = "7939DBF706CB3F6F728A24EEBE8A617D", hash_generated_method = "9B09D70E522A5F7D52C405E1CB9101E7")
        @Override
        public void doRestore(ParcelFileDescriptor data, int appVersionCode,
                ParcelFileDescriptor newState,
                int token, IBackupManager callbackBinder) throws RemoteException {
            long ident = Binder.clearCallingIdentity();
            BackupDataInput input = new BackupDataInput(data.getFileDescriptor());
            try 
            {
                BackupAgent.this.onRestore(input, appVersionCode, newState);
            } //End block
            catch (IOException ex)
            {
                Log.d(TAG, "onRestore (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } //End block
            catch (RuntimeException ex)
            {
                Log.d(TAG, "onRestore (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                if (DroidSafeAndroidRuntime.control) throw ex;
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
            addTaint(data.getTaint());
            addTaint(appVersionCode);
            addTaint(newState.getTaint());
            addTaint(token);
            addTaint(callbackBinder.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.386 -0400", hash_original_method = "D1AF436E8077A77141AB12CE24B7EAC7", hash_generated_method = "4E8CEEF865435C029DBBE62FA0AACCE9")
        @Override
        public void doFullBackup(ParcelFileDescriptor data,
                int token, IBackupManager callbackBinder) {
            long ident = Binder.clearCallingIdentity();
            try 
            {
                BackupAgent.this.onFullBackup(new FullBackupDataOutput(data));
            } //End block
            catch (IOException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } //End block
            catch (RuntimeException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                if (DroidSafeAndroidRuntime.control) throw ex;
            } //End block
            finally 
            {
                try 
                {
                    FileOutputStream out = new FileOutputStream(data.getFileDescriptor());
                    byte[] buf = new byte[4];
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
            addTaint(data.getTaint());
            addTaint(token);
            addTaint(callbackBinder.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.386 -0400", hash_original_method = "4CE4E3F6BFE9C329E5A1E18658253486", hash_generated_method = "944BFF3C1137487C65BEBB8D1B68DDB6")
        @Override
        public void doRestoreFile(ParcelFileDescriptor data, long size,
                int type, String domain, String path, long mode, long mtime,
                int token, IBackupManager callbackBinder) throws RemoteException {
            long ident = Binder.clearCallingIdentity();
            try 
            {
                BackupAgent.this.onRestoreFile(data, size, type, domain, path, mode, mtime);
            } //End block
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
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
            addTaint(data.getTaint());
            addTaint(size);
            addTaint(type);
            addTaint(domain.getTaint());
            addTaint(path.getTaint());
            addTaint(mode);
            addTaint(mtime);
            addTaint(token);
            addTaint(callbackBinder.getTaint());
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.107 -0400", hash_original_field = "4ADF9F269EDB752D9DAF2619A642F40E", hash_generated_field = "435867AAB7879E1905C087AA981414A1")

        private static final String TAG = "BackupServiceBinder";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.387 -0400", hash_original_field = "6D9EC25AF8582467BD59C12585E6F30B", hash_generated_field = "CC20CEBA20D1053D2133B7442D01B53F")

    private static final String TAG = "BackupAgent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.387 -0400", hash_original_field = "BC4FF4C62A62F66D6D2E0A35B84DD24A", hash_generated_field = "0DA17BC1AEF6DBF011A4A750F5A71D57")

    private static final boolean DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.387 -0400", hash_original_field = "3666587197EBF77320BA02340DBC75CC", hash_generated_field = "F411480428FF7BC88B285D624F0C1A18")

    public static final int TYPE_EOF = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.387 -0400", hash_original_field = "55C152A29A415C810B769C5A83FC118A", hash_generated_field = "151A491EED5B718681A96914789F4FA2")

    public static final int TYPE_FILE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.387 -0400", hash_original_field = "9B2351E51FCF0A36CABA15A71892E592", hash_generated_field = "91BB5D30A9ED5809D5F8123C625B8485")

    public static final int TYPE_DIRECTORY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.387 -0400", hash_original_field = "40F859C22CEBA02A95CC3738DDF03481", hash_generated_field = "5EF3A28FA8E5E382E3C6BB7DC99660C3")

    public static final int TYPE_SYMLINK = 3;
}

