package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.SharedPreferences;
import android.os.FileUtils.FileStatus;
import android.os.FileUtils;
import android.os.Looper;
import android.util.Log;
import com.google.android.collect.Maps;
import com.android.internal.util.XmlUtils;
import dalvik.system.BlockGuard;
import org.xmlpull.v1.XmlPullParserException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

final class SharedPreferencesImpl implements SharedPreferences {
    private File mFile;
    private File mBackupFile;
    private int mMode;
    private Map<String, Object> mMap;
    private int mDiskWritesInFlight = 0;
    private boolean mLoaded = false;
    private long mStatTimestamp;
    private long mStatSize;
    private Object mWritingToDiskLock = new Object();
    private WeakHashMap<OnSharedPreferenceChangeListener, Object> mListeners =
            new WeakHashMap<OnSharedPreferenceChangeListener, Object>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.918 -0400", hash_original_method = "4EED344672F91D55C3B3E75973F50190", hash_generated_method = "2E8100A8751F3925A2F24A8E0E8D1435")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SharedPreferencesImpl(File file, int mode) {
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(mode);
        mBackupFile = makeBackupFile(file);
        mLoaded = false;
        mMap = null;
        startLoadFromDisk();
        // ---------- Original Method ----------
        //mFile = file;
        //mBackupFile = makeBackupFile(file);
        //mMode = mode;
        //mLoaded = false;
        //mMap = null;
        //startLoadFromDisk();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.919 -0400", hash_original_method = "F1282AA19C3183BEA34E2A247A149BD2", hash_generated_method = "E2C249F5119A2613D7836E121BA53CED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startLoadFromDisk() {
        {
            mLoaded = false;
        } //End block
        new Thread("SharedPreferencesImpl-load") {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.919 -0400", hash_original_method = "6D08A306D4AFABC44535E176A1E8BC52", hash_generated_method = "30EE833735BE81BDC8BBE4F109BB8679")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                {
                    Object varEEB7B748507846A2C83D03D5993A3A41_356249930 = (SharedPreferencesImpl.this);
                    {
                        loadFromDiskLocked();
                    } //End block
                } //End collapsed parenthetic
                // ---------- Original Method ----------
                //synchronized (SharedPreferencesImpl.this) {
                    //loadFromDiskLocked();
                //}
            }
}.start();
        // ---------- Original Method ----------
        //synchronized (this) {
            //mLoaded = false;
        //}
        //new Thread("SharedPreferencesImpl-load") {
            //public void run() {
                //synchronized (SharedPreferencesImpl.this) {
                    //loadFromDiskLocked();
                //}
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.920 -0400", hash_original_method = "E285F048C64F263B62F1F06EEC72F6E0", hash_generated_method = "FDA59E6F22AB5D8B65A76FF8142F553F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void loadFromDiskLocked() {
        {
            boolean var99DE0DB14FFB66602F09FEFBD7F17565_2078378276 = (mBackupFile.exists());
            {
                mFile.delete();
                mBackupFile.renameTo(mFile);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD47DECAE2FF36587B1AAA379A993E7CF_1439222537 = (mFile.exists() && !mFile.canRead());
        } //End collapsed parenthetic
        Map map;
        map = null;
        FileStatus stat;
        stat = new FileStatus();
        {
            boolean varC462C115997B1889F4CA41126EC911E2_2002482790 = (FileUtils.getFileStatus(mFile.getPath(), stat) && mFile.canRead());
            {
                try 
                {
                    BufferedInputStream str;
                    str = new BufferedInputStream(
                        new FileInputStream(mFile), 16*1024);
                    map = XmlUtils.readMapXml(str);
                    str.close();
                } //End block
                catch (XmlPullParserException e)
                { }
                catch (FileNotFoundException e)
                { }
                catch (IOException e)
                { }
            } //End block
        } //End collapsed parenthetic
        mLoaded = true;
        {
            mMap = map;
            mStatTimestamp = stat.mtime;
            mStatSize = stat.size;
        } //End block
        {
            mMap = new HashMap<String, Object>();
        } //End block
        notifyAll();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static File makeBackupFile(File prefsFile) {
        return new File(prefsFile.getPath() + ".bak");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.921 -0400", hash_original_method = "B476681732C380F10709E29F69091336", hash_generated_method = "5D1CD5FD8E2C78550406332F3C22CF86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void startReloadIfChangedUnexpectedly() {
        {
            {
                boolean varB6158C0E75648F64F85FE11BFA0EEA58_2007194954 = (!hasFileChangedUnexpectedly());
            } //End collapsed parenthetic
            startLoadFromDisk();
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (!hasFileChangedUnexpectedly()) {
                //return;
            //}
            //startLoadFromDisk();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.921 -0400", hash_original_method = "A66A0F368E0CD54CE4119FA6EA4CE2B9", hash_generated_method = "00E16322C398D969AA4D21493B43A32B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hasFileChangedUnexpectedly() {
        {
            {
                Log.d(TAG, "disk write in flight, not unexpected.");
            } //End block
        } //End block
        FileStatus stat;
        stat = new FileStatus();
        {
            boolean varA005498AA56B05798F31373B591C38F2_1077168557 = (!FileUtils.getFileStatus(mFile.getPath(), stat));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mDiskWritesInFlight > 0) {
                //if (DEBUG) Log.d(TAG, "disk write in flight, not unexpected.");
                //return false;
            //}
        //}
        //FileStatus stat = new FileStatus();
        //if (!FileUtils.getFileStatus(mFile.getPath(), stat)) {
            //return true;
        //}
        //synchronized (this) {
            //return mStatTimestamp != stat.mtime || mStatSize != stat.size;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.922 -0400", hash_original_method = "CD8081B759B90CE7833F86EB66B232F5", hash_generated_method = "9E7FB3F9BC6D037CF813E293F16FF589")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        {
            mListeners.put(listener, mContent);
        } //End block
        // ---------- Original Method ----------
        //synchronized(this) {
            //mListeners.put(listener, mContent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.922 -0400", hash_original_method = "F9E846583CAAA911470841F2FE3AC3FA", hash_generated_method = "767CDFB790E84DAC05DFBB8EBB13FD72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            mListeners.remove(listener);
        } //End block
        // ---------- Original Method ----------
        //synchronized(this) {
            //mListeners.remove(listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.922 -0400", hash_original_method = "4E41B5524ECBD1AD902DE6B06A01DA71", hash_generated_method = "7DE227DA1D900EAA31405CC92B33A633")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void awaitLoadedLocked() {
        {
            BlockGuard.getThreadPolicy().onReadFromDisk();
        } //End block
        {
            try 
            {
                wait();
            } //End block
            catch (InterruptedException unused)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (!mLoaded) {
            //BlockGuard.getThreadPolicy().onReadFromDisk();
        //}
        //while (!mLoaded) {
            //try {
                //wait();
            //} catch (InterruptedException unused) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.923 -0400", hash_original_method = "BA8526BB1455076706AECC9BAC06F7D3", hash_generated_method = "45D44888BD2792DEB208645BF67B0683")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Map<String, ?> getAll() {
        {
            awaitLoadedLocked();
            Map<String, ?> varC885C89F2A839A784BD73D46CC8B1350_1334901049 = (new HashMap<String, Object>(mMap));
        } //End block
        return (Map<String, ?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //return new HashMap<String, Object>(mMap);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.923 -0400", hash_original_method = "4363C372EF13513A221D5D74A24EBA33", hash_generated_method = "F5A18ADB1F0F75638FA312444794FCD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(String key, String defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(key);
        {
            awaitLoadedLocked();
            String v;
            v = (String)mMap.get(key);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //String v = (String)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.924 -0400", hash_original_method = "66BFB743F0303E06F65F01D81F24C82B", hash_generated_method = "2155CB33DF634CA9D3774945DF29E1E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> getStringSet(String key, Set<String> defValues) {
        dsTaint.addTaint(defValues.dsTaint);
        dsTaint.addTaint(key);
        {
            awaitLoadedLocked();
            Set<String> v;
            v = (Set<String>) mMap.get(key);
        } //End block
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Set<String> v = (Set<String>) mMap.get(key);
            //return v != null ? v : defValues;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.924 -0400", hash_original_method = "ACC29E9B287DA38F520685100499E9BD", hash_generated_method = "9FF9A5AF0186F9DF2F913B10026196B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(String key, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(key);
        {
            awaitLoadedLocked();
            Integer v;
            v = (Integer)mMap.get(key);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Integer v = (Integer)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.924 -0400", hash_original_method = "44BE6AE8D3AB2ABE731A78B854B12E07", hash_generated_method = "BC4E3D217B289B24FA41D62593B88469")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(String key, long defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(key);
        {
            awaitLoadedLocked();
            Long v;
            v = (Long)mMap.get(key);
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Long v = (Long)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.925 -0400", hash_original_method = "E216C3CDDFA2EB08E1EA436EA866244B", hash_generated_method = "84C2367E06137E8F436E8D9180B16376")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(String key, float defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(key);
        {
            awaitLoadedLocked();
            Float v;
            v = (Float)mMap.get(key);
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Float v = (Float)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.925 -0400", hash_original_method = "726255BCC2D6177085677A1712342F0B", hash_generated_method = "C1B1AA8FDCA4CAE176D282795696BA3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(String key, boolean defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(key);
        {
            awaitLoadedLocked();
            Boolean v;
            v = (Boolean)mMap.get(key);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Boolean v = (Boolean)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.926 -0400", hash_original_method = "62FFF74487B278708D1160DE5B5FB2C0", hash_generated_method = "122D2B118FDCE81F053E359032448260")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(String key) {
        dsTaint.addTaint(key);
        {
            awaitLoadedLocked();
            boolean varBC7DFBFAB8E0EAD217132FDF3CCDDF3E_287905178 = (mMap.containsKey(key));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //return mMap.containsKey(key);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.926 -0400", hash_original_method = "4D22F9B98CC44B257DB4ED7BF7E423CC", hash_generated_method = "7B65BF444E39B682B32D7E0EAE632CBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Editor edit() {
        {
            awaitLoadedLocked();
        } //End block
        Editor varD145784F7D0722CD3578B3E3ADB21A55_27378177 = (new EditorImpl());
        return (Editor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
        //}
        //return new EditorImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.927 -0400", hash_original_method = "4AFBAD62741BB9BDCEF60806B476332B", hash_generated_method = "3A60ED0BD8F981992A39DAB2FF4A43A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void enqueueDiskWrite(final MemoryCommitResult mcr,
                                  final Runnable postWriteRunnable) {
        dsTaint.addTaint(postWriteRunnable.dsTaint);
        dsTaint.addTaint(mcr.dsTaint);
        Runnable writeToDiskRunnable;
        writeToDiskRunnable = new Runnable() {
                public void run() {
                    synchronized (mWritingToDiskLock) {
                        writeToFile(mcr);
                    }
                    synchronized (SharedPreferencesImpl.this) {
                        mDiskWritesInFlight--;
                    }
                    if (postWriteRunnable != null) {
                        postWriteRunnable.run();
                    }
                }
            };
        boolean isFromSyncCommit;
        isFromSyncCommit = (postWriteRunnable == null);
        {
            boolean wasEmpty;
            wasEmpty = false;
            {
                Object var232E05A46CB4C244745CD03ED44CEBDA_1055149746 = (SharedPreferencesImpl.this);
                {
                    wasEmpty = mDiskWritesInFlight == 1;
                } //End block
            } //End collapsed parenthetic
            {
                writeToDiskRunnable.run();
            } //End block
        } //End block
        QueuedWork.singleThreadExecutor().execute(writeToDiskRunnable);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static FileOutputStream createFileOutputStream(File file) {
        FileOutputStream str = null;
        try {
            str = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            File parent = file.getParentFile();
            if (!parent.mkdir()) {
                Log.e(TAG, "Couldn't create directory for SharedPreferences file " + file);
                return null;
            }
            FileUtils.setPermissions(
                parent.getPath(),
                FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                -1, -1);
            try {
                str = new FileOutputStream(file);
            } catch (FileNotFoundException e2) {
                Log.e(TAG, "Couldn't create SharedPreferences file " + file, e2);
            }
        }
        return str;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.929 -0400", hash_original_method = "2845FAF740EE3AE38D64734030124734", hash_generated_method = "097834865BC3B5B39094C18D379C3930")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeToFile(MemoryCommitResult mcr) {
        dsTaint.addTaint(mcr.dsTaint);
        {
            boolean var41D133D77C4B3BDDC7C7FBBBF4C95E6E_452555884 = (mFile.exists());
            {
                {
                    mcr.setDiskWriteResult(true);
                } //End block
                {
                    boolean var8752700CBD0D95D9BA93EA4EAF6E4584_1031401302 = (!mBackupFile.exists());
                    {
                        {
                            boolean var97E99B42A4C3EF9AD06C1BE92A8A0125_1937112369 = (!mFile.renameTo(mBackupFile));
                            {
                                mcr.setDiskWriteResult(false);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        mFile.delete();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        try 
        {
            FileOutputStream str;
            str = createFileOutputStream(mFile);
            {
                mcr.setDiskWriteResult(false);
            } //End block
            XmlUtils.writeMapXml(mcr.mapToWriteToDisk, str);
            FileUtils.sync(str);
            str.close();
            ContextImpl.setFilePermissionsFromMode(mFile.getPath(), mMode, 0);
            FileStatus stat;
            stat = new FileStatus();
            {
                boolean varFC8A9325D409852FB2BC7AA91339B9F1_208590650 = (FileUtils.getFileStatus(mFile.getPath(), stat));
                {
                    {
                        mStatTimestamp = stat.mtime;
                        mStatSize = stat.size;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mBackupFile.delete();
            mcr.setDiskWriteResult(true);
        } //End block
        catch (XmlPullParserException e)
        { }
        catch (IOException e)
        { }
        {
            boolean var41D133D77C4B3BDDC7C7FBBBF4C95E6E_1657237731 = (mFile.exists());
            {
                {
                    boolean var8D9FAE26A4E65BB2FC5E55BBC862BDCF_141677706 = (!mFile.delete());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mcr.setDiskWriteResult(false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class MemoryCommitResult {
        public boolean changesMade;
        public List<String> keysModified;
        public Set<OnSharedPreferenceChangeListener> listeners;
        public Map<?, ?> mapToWriteToDisk;
        public CountDownLatch writtenToDiskLatch = new CountDownLatch(1);
        public volatile boolean writeToDiskResult = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.930 -0400", hash_original_method = "05BE12B03B22485ED0B0F132C19B91ED", hash_generated_method = "05BE12B03B22485ED0B0F132C19B91ED")
                public MemoryCommitResult ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.930 -0400", hash_original_method = "152989348B1D3907F6F06DB9CE213C64", hash_generated_method = "AF2EE1069A20F645188D27A86421F4BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setDiskWriteResult(boolean result) {
            dsTaint.addTaint(result);
            writtenToDiskLatch.countDown();
            // ---------- Original Method ----------
            //writeToDiskResult = result;
            //writtenToDiskLatch.countDown();
        }

        
    }


    
    public final class EditorImpl implements Editor {
        private Map<String, Object> mModified = Maps.newHashMap();
        private boolean mClear = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.930 -0400", hash_original_method = "66AD310F1A85CDDB26D7F3EA7ED18F8E", hash_generated_method = "66AD310F1A85CDDB26D7F3EA7ED18F8E")
                public EditorImpl ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.931 -0400", hash_original_method = "EFFD7B235C5590A6C15EA464602A0862", hash_generated_method = "65117A31514A5BB7AC4281FB81EFB070")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Editor putString(String key, String value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(key);
            {
                mModified.put(key, value);
            } //End block
            return (Editor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.931 -0400", hash_original_method = "799426C68EE59A97CAF3D6E033ED6AED", hash_generated_method = "B913CD55656BC1E81A4DDB526DAA1068")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Editor putStringSet(String key, Set<String> values) {
            dsTaint.addTaint(values.dsTaint);
            dsTaint.addTaint(key);
            {
                mModified.put(key, values);
            } //End block
            return (Editor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, values);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.931 -0400", hash_original_method = "B5181352BC82403801755A11BC05DCE9", hash_generated_method = "DAF5041847EE7B6E8B399A1355C61EA5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Editor putInt(String key, int value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(key);
            {
                mModified.put(key, value);
            } //End block
            return (Editor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.932 -0400", hash_original_method = "2390F394A779B486378B9C93DB0AC773", hash_generated_method = "35B30869FEBB7F3623E581AA2C828EC0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Editor putLong(String key, long value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(key);
            {
                mModified.put(key, value);
            } //End block
            return (Editor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.933 -0400", hash_original_method = "913478FEA634AAED5778EE46C57EEF5E", hash_generated_method = "AE250C6284E59E5877380A7CAD8C275E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Editor putFloat(String key, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(key);
            {
                mModified.put(key, value);
            } //End block
            return (Editor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.934 -0400", hash_original_method = "FBC14C4FFFA5A0EBC88C6D503172C819", hash_generated_method = "6C2B0E776B9E611C7027577EE6216DFD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Editor putBoolean(String key, boolean value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(key);
            {
                mModified.put(key, value);
            } //End block
            return (Editor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.935 -0400", hash_original_method = "7C60C1DCB4FF55A3B2BA6A50F523FE33", hash_generated_method = "69F91BB0060C8CD891315F8D54EE6486")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Editor remove(String key) {
            dsTaint.addTaint(key);
            {
                mModified.put(key, this);
            } //End block
            return (Editor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, this);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.935 -0400", hash_original_method = "59F9BBF7AADFDAE77F62CA904307DAB9", hash_generated_method = "D80FB4AEC31E1E0A84961CC63C955A10")
        @DSModeled(DSC.SAFE)
        public Editor clear() {
            {
                mClear = true;
            } //End block
            return (Editor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (this) {
                //mClear = true;
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.936 -0400", hash_original_method = "874FED7345E8B1C9E07FEF0510B9D798", hash_generated_method = "BFCA20DC6902321268BE1A072C0F913B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void apply() {
            MemoryCommitResult mcr;
            mcr = commitToMemory();
            Runnable awaitCommit;
            awaitCommit = new Runnable() {
                    public void run() {
                        try {
                            mcr.writtenToDiskLatch.await();
                        } catch (InterruptedException ignored) {
                        }
                    }
                };
            QueuedWork.add(awaitCommit);
            Runnable postWriteRunnable;
            postWriteRunnable = new Runnable() {
                    public void run() {
                        awaitCommit.run();
                        QueuedWork.remove(awaitCommit);
                    }
                };
            SharedPreferencesImpl.this.enqueueDiskWrite(mcr, postWriteRunnable);
            notifyListeners(mcr);
            // ---------- Original Method ----------
            //final MemoryCommitResult mcr = commitToMemory();
            //final Runnable awaitCommit = new Runnable() {
                    //public void run() {
                        //try {
                            //mcr.writtenToDiskLatch.await();
                        //} catch (InterruptedException ignored) {
                        //}
                    //}
                //};
            //QueuedWork.add(awaitCommit);
            //Runnable postWriteRunnable = new Runnable() {
                    //public void run() {
                        //awaitCommit.run();
                        //QueuedWork.remove(awaitCommit);
                    //}
                //};
            //SharedPreferencesImpl.this.enqueueDiskWrite(mcr, postWriteRunnable);
            //notifyListeners(mcr);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.025 -0400", hash_original_method = "686A9AF4CEF5EAEBEB20BB8BD072C7B7", hash_generated_method = "FB1D4AE05B4BD11DABBE1B36947464E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private MemoryCommitResult commitToMemory() {
            MemoryCommitResult mcr;
            mcr = new MemoryCommitResult();
            {
                Object var232E05A46CB4C244745CD03ED44CEBDA_1146798195 = (SharedPreferencesImpl.this);
                {
                    {
                        mMap = new HashMap<String, Object>(mMap);
                    } //End block
                    mcr.mapToWriteToDisk = mMap;
                    boolean hasListeners;
                    hasListeners = mListeners.size() > 0;
                    {
                        mcr.keysModified = new ArrayList<String>();
                        mcr.listeners =
                            new HashSet<OnSharedPreferenceChangeListener>(mListeners.keySet());
                    } //End block
                    {
                        {
                            {
                                boolean var8C6FF294AFEFAD057AE1B35F44B10299_1477804706 = (!mMap.isEmpty());
                                {
                                    mcr.changesMade = true;
                                    mMap.clear();
                                } //End block
                            } //End collapsed parenthetic
                            mClear = false;
                        } //End block
                        {
                            Iterator<Map.Entry<String, Object>> varF82C588A08B6DF5CE4ADFA834C909247_1293212754 = (mModified.entrySet()).iterator();
                            varF82C588A08B6DF5CE4ADFA834C909247_1293212754.hasNext();
                            Map.Entry<String, Object> e = varF82C588A08B6DF5CE4ADFA834C909247_1293212754.next();
                            {
                                String k;
                                k = e.getKey();
                                Object v;
                                v = e.getValue();
                                {
                                    boolean var7481F5BED4B812C399339F0465352930_1475368777 = (v == this);
                                    {
                                        {
                                            boolean varCB62A03BC7382484A4D8527AC1D5B67C_1890048423 = (!mMap.containsKey(k));
                                        } //End collapsed parenthetic
                                        mMap.remove(k);
                                    } //End block
                                    {
                                        boolean isSame;
                                        isSame = false;
                                        {
                                            boolean var1476C62562F740B1204AB200EEE2D273_1321884772 = (mMap.containsKey(k));
                                            {
                                                Object existingValue;
                                                existingValue = mMap.get(k);
                                                {
                                                    boolean var3F40C0122B4BFCB85951F0CA9C389424_206285016 = (existingValue != null && existingValue.equals(v));
                                                } //End collapsed parenthetic
                                            } //End block
                                        } //End collapsed parenthetic
                                        mMap.put(k, v);
                                    } //End block
                                } //End collapsed parenthetic
                                mcr.changesMade = true;
                                {
                                    mcr.keysModified.add(k);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        mModified.clear();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return (MemoryCommitResult)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.026 -0400", hash_original_method = "23D73852609E646C4CF9B990F4BA7C23", hash_generated_method = "454BA8F6A4903AB3C818546F0FFD84C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean commit() {
            MemoryCommitResult mcr;
            mcr = commitToMemory();
            SharedPreferencesImpl.this.enqueueDiskWrite(
                mcr, null );
            try 
            {
                mcr.writtenToDiskLatch.await();
            } //End block
            catch (InterruptedException e)
            { }
            notifyListeners(mcr);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //MemoryCommitResult mcr = commitToMemory();
            //SharedPreferencesImpl.this.enqueueDiskWrite(
                //mcr, null );
            //try {
                //mcr.writtenToDiskLatch.await();
            //} catch (InterruptedException e) {
                //return false;
            //}
            //notifyListeners(mcr);
            //return mcr.writeToDiskResult;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.038 -0400", hash_original_method = "9C764C33950FD36589194E2D3CE4E56B", hash_generated_method = "9587C4FBA533C4FE5FE1EFC96AD3221A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void notifyListeners(final MemoryCommitResult mcr) {
            dsTaint.addTaint(mcr.dsTaint);
            {
                boolean var98EE468E1F91A5EC4E053BA5E9799A53_1962842215 = (mcr.listeners == null || mcr.keysModified == null ||
                mcr.keysModified.size() == 0);
            } //End collapsed parenthetic
            {
                boolean var748E4843A4DFD33AE33247B092F762F7_606709149 = (Looper.myLooper() == Looper.getMainLooper());
                {
                    {
                        int i;
                        i = mcr.keysModified.size() - 1;
                        {
                            String key;
                            key = mcr.keysModified.get(i);
                            {
                                Iterator<OnSharedPreferenceChangeListener> var66C8E5D21325C7C68FB016F2A231877B_856057155 = (mcr.listeners).iterator();
                                var66C8E5D21325C7C68FB016F2A231877B_856057155.hasNext();
                                OnSharedPreferenceChangeListener listener = var66C8E5D21325C7C68FB016F2A231877B_856057155.next();
                                {
                                    {
                                        listener.onSharedPreferenceChanged(SharedPreferencesImpl.this, key);
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    ActivityThread.sMainThreadHandler.post(new Runnable() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.038 -0400", hash_original_method = "ADA4A7900A87A83172528D6D189EF104", hash_generated_method = "0CB8C5BDC799C735934697841D29C178")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void run() {
                            notifyListeners(mcr);
                            // ---------- Original Method ----------
                            //notifyListeners(mcr);
                        }
});
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static final String TAG = "SharedPreferencesImpl";
    private static final boolean DEBUG = false;
    private static final Object mContent = new Object();
}

