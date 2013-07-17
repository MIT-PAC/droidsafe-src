package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.108 -0400", hash_original_field = "6812121D3014FEFEE7A1118C07DF58B2", hash_generated_field = "7FA1510B7C47FB23A1BC45219C359763")

    private final IBinder mBinder = new BackupServiceBinder().asBinder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.108 -0400", hash_original_method = "B5A8D7758CDB468D197C4191C97B62B7", hash_generated_method = "10BCF02BE8187F1DDF7130F69F515B81")
    public  BackupAgent() {
        super(null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.108 -0400", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "7564C9BAB223A8E7FAC043FBCC648B76")
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.109 -0400", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "E5C4FFF396F837C85A1D40A9B232BFA0")
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    public abstract void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
             ParcelFileDescriptor newState) throws IOException;

    
    public abstract void onRestore(BackupDataInput data, int appVersionCode,
            ParcelFileDescriptor newState)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.110 -0400", hash_original_method = "9C0AD80B0DC65359576BE56D304BF72D", hash_generated_method = "F69E378ECAF785A1D57CE651CF87F204")
    public void onFullBackup(FullBackupDataOutput data) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(data.getTaint());
        ApplicationInfo appInfo = getApplicationInfo();
        String rootDir = new File(appInfo.dataDir).getCanonicalPath();
        String filesDir = getFilesDir().getCanonicalPath();
        String databaseDir = getDatabasePath("foo").getParentFile().getCanonicalPath();
        String sharedPrefsDir = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
        String cacheDir = getCacheDir().getCanonicalPath();
        String libDir = (appInfo.nativeLibraryDir != null)
                ? new File(appInfo.nativeLibraryDir).getCanonicalPath()
                : null;
        HashSet<String> filterSet = new HashSet<String>();
        String packageName = getPackageName();
        if(libDir != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.114 -0400", hash_original_method = "824AF36171DE5120222691B25F755417", hash_generated_method = "663D70BBFF8C8EF49BF86F33D0A0D31F")
    public final void fullBackupFile(File file, FullBackupDataOutput output) {
        addTaint(output.getTaint());
        addTaint(file.getTaint());
        String mainDir;
        String filesDir;
        String dbDir;
        String spDir;
        String cacheDir;
        String libDir;
        String filePath;
        ApplicationInfo appInfo = getApplicationInfo();
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
        {
            return;
        } //End block
        if(filePath.startsWith(cacheDir) || filePath.startsWith(libDir))        
        {
            return;
        } //End block
        String domain;
        String rootpath = null;
        if(filePath.startsWith(dbDir))        
        {
            domain = FullBackup.DATABASE_TREE_TOKEN;
            rootpath = dbDir;
        } //End block
        else
        if(filePath.startsWith(spDir))        
        {
            domain = FullBackup.SHAREDPREFS_TREE_TOKEN;
            rootpath = spDir;
        } //End block
        else
        if(filePath.startsWith(filesDir))        
        {
            domain = FullBackup.DATA_TREE_TOKEN;
            rootpath = filesDir;
        } //End block
        else
        if(filePath.startsWith(mainDir))        
        {
            domain = FullBackup.ROOT_TREE_TOKEN;
            rootpath = mainDir;
        } //End block
        else
        {
            return;
        } //End block
        FullBackup.backupToTar(getPackageName(), domain, null, rootpath, filePath,
                output.getData());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.116 -0400", hash_original_method = "1DCDC7EEAECB17F3E82FC9B9A809AA59", hash_generated_method = "583E02CD8F6031CA56C5B29F0FFAF814")
    protected final void fullBackupFileTree(String packageName, String domain, String rootPath,
            HashSet<String> excludes, FullBackupDataOutput output) {
        addTaint(output.getTaint());
        addTaint(excludes.getTaint());
        addTaint(rootPath.getTaint());
        addTaint(domain.getTaint());
        addTaint(packageName.getTaint());
        File rootFile = new File(rootPath);
        if(rootFile.exists())        
        {
            LinkedList<File> scanQueue = new LinkedList<File>();
            scanQueue.add(rootFile);
            while
(scanQueue.size() > 0)            
            {
                File file = scanQueue.remove(0);
                String filePath;
                try 
                {
                    filePath = file.getCanonicalPath();
                    if(excludes != null && excludes.contains(filePath))                    
                    {
                        continue;
                    } //End block
                    StructStat stat = Libcore.os.lstat(filePath);
                    if(OsConstants.S_ISLNK(stat.st_mode))                    
                    {
                        if(DEBUG){ }                        continue;
                    } //End block
                    else
                    if(OsConstants.S_ISDIR(stat.st_mode))                    
                    {
                        File[] contents = file.listFiles();
                        if(contents != null)                        
                        {
for(File entry : contents)
                            {
                                scanQueue.add(0, entry);
                            } //End block
                        } //End block
                    } //End block
                } //End block
                catch (IOException e)
                {
                    if(DEBUG){ }                    continue;
                } //End block
                catch (ErrnoException e)
                {
                    if(DEBUG){ }                    continue;
                } //End block
                FullBackup.backupToTar(packageName, domain, null, rootPath, filePath,
                        output.getData());
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.117 -0400", hash_original_method = "20621F323ECDCB060A13554E50206415", hash_generated_method = "EBD8889E36CAEF03FD32589A3131E682")
    public void onRestoreFile(ParcelFileDescriptor data, long size,
            File destination, int type, long mode, long mtime) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mtime);
        addTaint(mode);
        addTaint(type);
        addTaint(destination.getTaint());
        addTaint(size);
        addTaint(data.getTaint());
        FullBackup.restoreFile(data, size, type, mode, mtime, destination);
        // ---------- Original Method ----------
        //FullBackup.restoreFile(data, size, type, mode, mtime, destination);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.119 -0400", hash_original_method = "588B4C1C50D0665AE90099672BE15A28", hash_generated_method = "B32995C9B26B6C2B65EB71094E1CF1C1")
    protected void onRestoreFile(ParcelFileDescriptor data, long size,
            int type, String domain, String path, long mode, long mtime) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mtime);
        addTaint(mode);
        addTaint(path.getTaint());
        addTaint(domain.getTaint());
        addTaint(type);
        addTaint(size);
        addTaint(data.getTaint());
        String basePath = null;
        if(DEBUG)        
        Log.d(TAG, "onRestoreFile() size=" + size + " type=" + type
                + " domain=" + domain + " relpath=" + path + " mode=" + mode
                + " mtime=" + mtime);
        if(domain.equals(FullBackup.DATA_TREE_TOKEN))        
        {
            basePath = getFilesDir().getCanonicalPath();
        } //End block
        else
        if(domain.equals(FullBackup.DATABASE_TREE_TOKEN))        
        {
            basePath = getDatabasePath("foo").getParentFile().getCanonicalPath();
        } //End block
        else
        if(domain.equals(FullBackup.ROOT_TREE_TOKEN))        
        {
            basePath = new File(getApplicationInfo().dataDir).getCanonicalPath();
        } //End block
        else
        if(domain.equals(FullBackup.SHAREDPREFS_TREE_TOKEN))        
        {
            basePath = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
        } //End block
        else
        if(domain.equals(FullBackup.CACHE_TREE_TOKEN))        
        {
            basePath = getCacheDir().getCanonicalPath();
        } //End block
        else
        {
        } //End block
        if(basePath != null)        
        {
            File outFile = new File(basePath, path);
            if(DEBUG){ }            onRestoreFile(data, size, outFile, type, mode, mtime);
        } //End block
        else
        {
            if(DEBUG){ }            FullBackup.restoreFile(data, size, type, mode, mtime, null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.120 -0400", hash_original_method = "2EA8D194620A11CB2853C240391D2146", hash_generated_method = "83C3BCE04B8450717179DF3FCC972CB4")
    public final IBinder onBind() {
        //DSFIXME:  CODE0009: Possible callback target function detected
IBinder varA9FF01A383A9C8C5D4DA9D8985A671A5_993426132 =         mBinder;
        varA9FF01A383A9C8C5D4DA9D8985A671A5_993426132.addTaint(taint);
        return varA9FF01A383A9C8C5D4DA9D8985A671A5_993426132;
        // ---------- Original Method ----------
        //return mBinder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.121 -0400", hash_original_method = "20906B0697539AB9D636DC69F7DBB057", hash_generated_method = "CD5B8FBF2D0E90B46E81A657F9152257")
    public void attach(Context context) {
        addTaint(context.getTaint());
        attachBaseContext(context);
        // ---------- Original Method ----------
        //attachBaseContext(context);
    }

    
    private class BackupServiceBinder extends IBackupAgent.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.121 -0400", hash_original_method = "981BC5161F50D30EEB7E3364AFC1A4E5", hash_generated_method = "981BC5161F50D30EEB7E3364AFC1A4E5")
        public BackupServiceBinder ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.122 -0400", hash_original_method = "8358D1CE671AA075D592B0F9339AC6D7", hash_generated_method = "D0DBB7FDEE1F348838971C22B0CA84BC")
        @Override
        public void doBackup(ParcelFileDescriptor oldState,
                ParcelFileDescriptor data,
                ParcelFileDescriptor newState,
                int token, IBackupManager callbackBinder) throws RemoteException {
            addTaint(callbackBinder.getTaint());
            addTaint(token);
            addTaint(newState.getTaint());
            addTaint(data.getTaint());
            addTaint(oldState.getTaint());
            long ident = Binder.clearCallingIdentity();
            if(DEBUG){ }            BackupDataOutput output = new BackupDataOutput(data.getFileDescriptor());
            try 
            {
                BackupAgent.this.onBackup(oldState, output, newState);
            } //End block
            catch (IOException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_1522902885 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_1522902885.addTaint(taint);
                throw varF35D3C95F99DACEE8C542CF38D772C50_1522902885;
            } //End block
            catch (RuntimeException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                ex.addTaint(taint);
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
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.123 -0400", hash_original_method = "7939DBF706CB3F6F728A24EEBE8A617D", hash_generated_method = "E0F969275D6E3D2B3065299D3E902CA9")
        @Override
        public void doRestore(ParcelFileDescriptor data, int appVersionCode,
                ParcelFileDescriptor newState,
                int token, IBackupManager callbackBinder) throws RemoteException {
            addTaint(callbackBinder.getTaint());
            addTaint(token);
            addTaint(newState.getTaint());
            addTaint(appVersionCode);
            addTaint(data.getTaint());
            long ident = Binder.clearCallingIdentity();
            if(DEBUG){ }            BackupDataInput input = new BackupDataInput(data.getFileDescriptor());
            try 
            {
                BackupAgent.this.onRestore(input, appVersionCode, newState);
            } //End block
            catch (IOException ex)
            {
                Log.d(TAG, "onRestore (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_246219903 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_246219903.addTaint(taint);
                throw varF35D3C95F99DACEE8C542CF38D772C50_246219903;
            } //End block
            catch (RuntimeException ex)
            {
                Log.d(TAG, "onRestore (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                ex.addTaint(taint);
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
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.124 -0400", hash_original_method = "D1AF436E8077A77141AB12CE24B7EAC7", hash_generated_method = "1355659D1F2C79B2B7C75B86634880D6")
        @Override
        public void doFullBackup(ParcelFileDescriptor data,
                int token, IBackupManager callbackBinder) {
            addTaint(callbackBinder.getTaint());
            addTaint(token);
            addTaint(data.getTaint());
            long ident = Binder.clearCallingIdentity();
            if(DEBUG){ }            try 
            {
                BackupAgent.this.onFullBackup(new FullBackupDataOutput(data));
            } //End block
            catch (IOException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_545275343 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_545275343.addTaint(taint);
                throw varF35D3C95F99DACEE8C542CF38D772C50_545275343;
            } //End block
            catch (RuntimeException ex)
            {
                Log.d(TAG, "onBackup (" + BackupAgent.this.getClass().getName() + ") threw", ex);
                ex.addTaint(taint);
                throw ex;
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
                {
                } //End block
                Binder.restoreCallingIdentity(ident);
                try 
                {
                    callbackBinder.opComplete(token);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.126 -0400", hash_original_method = "4CE4E3F6BFE9C329E5A1E18658253486", hash_generated_method = "76B91381C52A19AE0C77BAEA56AC6AAC")
        @Override
        public void doRestoreFile(ParcelFileDescriptor data, long size,
                int type, String domain, String path, long mode, long mtime,
                int token, IBackupManager callbackBinder) throws RemoteException {
            addTaint(callbackBinder.getTaint());
            addTaint(token);
            addTaint(mtime);
            addTaint(mode);
            addTaint(path.getTaint());
            addTaint(domain.getTaint());
            addTaint(type);
            addTaint(size);
            addTaint(data.getTaint());
            long ident = Binder.clearCallingIdentity();
            try 
            {
                BackupAgent.this.onRestoreFile(data, size, type, domain, path, mode, mtime);
            } //End block
            catch (IOException e)
            {
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_95919287 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_95919287.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_95919287;
            } //End block
            finally 
            {
                Binder.restoreCallingIdentity(ident);
                try 
                {
                    callbackBinder.opComplete(token);
                } //End block
                catch (RemoteException e)
                {
                } //End block
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.107 -0400", hash_original_field = "4ADF9F269EDB752D9DAF2619A642F40E", hash_generated_field = "435867AAB7879E1905C087AA981414A1")

        private static final String TAG = "BackupServiceBinder";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.127 -0400", hash_original_field = "6D9EC25AF8582467BD59C12585E6F30B", hash_generated_field = "CC20CEBA20D1053D2133B7442D01B53F")

    private static final String TAG = "BackupAgent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.127 -0400", hash_original_field = "BC4FF4C62A62F66D6D2E0A35B84DD24A", hash_generated_field = "0DA17BC1AEF6DBF011A4A750F5A71D57")

    private static final boolean DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.127 -0400", hash_original_field = "3666587197EBF77320BA02340DBC75CC", hash_generated_field = "F411480428FF7BC88B285D624F0C1A18")

    public static final int TYPE_EOF = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.127 -0400", hash_original_field = "55C152A29A415C810B769C5A83FC118A", hash_generated_field = "151A491EED5B718681A96914789F4FA2")

    public static final int TYPE_FILE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.128 -0400", hash_original_field = "9B2351E51FCF0A36CABA15A71892E592", hash_generated_field = "91BB5D30A9ED5809D5F8123C625B8485")

    public static final int TYPE_DIRECTORY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.128 -0400", hash_original_field = "40F859C22CEBA02A95CC3738DDF03481", hash_generated_field = "5EF3A28FA8E5E382E3C6BB7DC99660C3")

    public static final int TYPE_SYMLINK = 3;
}

