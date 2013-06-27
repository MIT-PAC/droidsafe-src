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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.367 -0400", hash_original_field = "E5808F908EB29E322B1768E76474CE1A", hash_generated_field = "183611C0D8A74A7CE3F1C64EE45173DC")

    private File mFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.376 -0400", hash_original_field = "0A263079383F856884EA291D72524709", hash_generated_field = "7006A03D2BDB683A38E82C1F26A37BBC")

    private File mBackupFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.377 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.378 -0400", hash_original_field = "47CB5CD11AAE7A0AB09FB37CAC0E4D7D", hash_generated_field = "9D9685A7435D44306A90CB052DCBD9B4")

    private Map<String, Object> mMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.378 -0400", hash_original_field = "5EC3B01F32E52F458882437DB44990B0", hash_generated_field = "218913F8CAD5DFBC796CF278F1F6F361")

    private int mDiskWritesInFlight = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.393 -0400", hash_original_field = "F9858423033ADDAF927382FE14C29268", hash_generated_field = "E678253CB2423592337E0A1DE6C3016E")

    private boolean mLoaded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.394 -0400", hash_original_field = "38B6A70426F0DA6F22186F8D94FC0483", hash_generated_field = "D6415D56649386C512A0DE29962BED58")

    private long mStatTimestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.395 -0400", hash_original_field = "A73B790C6436C519DD1A505D631741B2", hash_generated_field = "233A577B65E241EDEA724E56888AD815")

    private long mStatSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.395 -0400", hash_original_field = "7E9DD87C9BB99BC747C950C13F9235C5", hash_generated_field = "8012F47459E6425926F5773C08FC4D8E")

    private Object mWritingToDiskLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.412 -0400", hash_original_field = "503C94D9DD1FDDA737114094FA5AB14C", hash_generated_field = "5320C079E7CCBD76336963ED012D1568")

    private WeakHashMap<OnSharedPreferenceChangeListener, Object> mListeners = new WeakHashMap<OnSharedPreferenceChangeListener, Object>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.427 -0400", hash_original_method = "4EED344672F91D55C3B3E75973F50190", hash_generated_method = "AB0E91D1F1D686F65B061AF8458F6A61")
      SharedPreferencesImpl(File file, int mode) {
        mFile = file;
        mBackupFile = makeBackupFile(file);
        mMode = mode;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.441 -0400", hash_original_method = "F1282AA19C3183BEA34E2A247A149BD2", hash_generated_method = "93D1A782B595D343CC1177C63B71D328")
    private void startLoadFromDisk() {
        {
            mLoaded = false;
        } //End block
        new Thread("SharedPreferencesImpl-load") {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.430 -0400", hash_original_method = "6D08A306D4AFABC44535E176A1E8BC52", hash_generated_method = "1D9F8BD1A23642C38F2C994EDD07964C")
            public void run() {
                {
                    Object varEEB7B748507846A2C83D03D5993A3A41_670502272 = (SharedPreferencesImpl.this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.458 -0400", hash_original_method = "E285F048C64F263B62F1F06EEC72F6E0", hash_generated_method = "3E2762F227ED29C522EC458AA7AC5F66")
    private void loadFromDiskLocked() {
        {
            boolean var99DE0DB14FFB66602F09FEFBD7F17565_77484941 = (mBackupFile.exists());
            {
                mFile.delete();
                mBackupFile.renameTo(mFile);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD47DECAE2FF36587B1AAA379A993E7CF_1182700252 = (mFile.exists() && !mFile.canRead());
        } //End collapsed parenthetic
        Map map;
        map = null;
        FileStatus stat;
        stat = new FileStatus();
        {
            boolean varC462C115997B1889F4CA41126EC911E2_2072904145 = (FileUtils.getFileStatus(mFile.getPath(), stat) && mFile.canRead());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.477 -0400", hash_original_method = "B476681732C380F10709E29F69091336", hash_generated_method = "B1EB59D21732C0761D2563C5EC04735C")
     void startReloadIfChangedUnexpectedly() {
        {
            {
                boolean varB6158C0E75648F64F85FE11BFA0EEA58_1424735679 = (!hasFileChangedUnexpectedly());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.485 -0400", hash_original_method = "A66A0F368E0CD54CE4119FA6EA4CE2B9", hash_generated_method = "5E7121EF2D17230987543371A2637113")
    private boolean hasFileChangedUnexpectedly() {
        {
            {
                Log.d(TAG, "disk write in flight, not unexpected.");
            } //End block
        } //End block
        FileStatus stat;
        stat = new FileStatus();
        {
            boolean varA005498AA56B05798F31373B591C38F2_1158850383 = (!FileUtils.getFileStatus(mFile.getPath(), stat));
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_644530801 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_644530801;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.513 -0400", hash_original_method = "CD8081B759B90CE7833F86EB66B232F5", hash_generated_method = "CEC7D0ED2AE4F64E535B55F2C4201329")
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            mListeners.put(listener, mContent);
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //synchronized(this) {
            //mListeners.put(listener, mContent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.519 -0400", hash_original_method = "F9E846583CAAA911470841F2FE3AC3FA", hash_generated_method = "7C1E1732C686E572E83F992E2802B970")
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        {
            mListeners.remove(listener);
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //synchronized(this) {
            //mListeners.remove(listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.520 -0400", hash_original_method = "4E41B5524ECBD1AD902DE6B06A01DA71", hash_generated_method = "7DE227DA1D900EAA31405CC92B33A633")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.540 -0400", hash_original_method = "BA8526BB1455076706AECC9BAC06F7D3", hash_generated_method = "A2BBB06F1D91BA4452F61F2FF4D4016B")
    public Map<String, ?> getAll() {
        Map<String, ?> varB4EAC82CA7396A68D541C85D26508E83_1489394785 = null; //Variable for return #1
        {
            awaitLoadedLocked();
            varB4EAC82CA7396A68D541C85D26508E83_1489394785 = new HashMap<String, Object>(mMap);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1489394785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1489394785;
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //return new HashMap<String, Object>(mMap);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.564 -0400", hash_original_method = "4363C372EF13513A221D5D74A24EBA33", hash_generated_method = "84E85B051CAF04496FFEF9B496038926")
    public String getString(String key, String defValue) {
        String varB4EAC82CA7396A68D541C85D26508E83_828667379 = null; //Variable for return #1
        {
            awaitLoadedLocked();
            String v;
            v = (String)mMap.get(key);
            varB4EAC82CA7396A68D541C85D26508E83_828667379 = v != null ? v : defValue;
        } //End block
        addTaint(key.getTaint());
        addTaint(defValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_828667379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_828667379;
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //String v = (String)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.577 -0400", hash_original_method = "66BFB743F0303E06F65F01D81F24C82B", hash_generated_method = "6939D0CFABFBD85466D193D6E13B8588")
    public Set<String> getStringSet(String key, Set<String> defValues) {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1217950457 = null; //Variable for return #1
        {
            awaitLoadedLocked();
            Set<String> v;
            v = (Set<String>) mMap.get(key);
            varB4EAC82CA7396A68D541C85D26508E83_1217950457 = v != null ? v : defValues;
        } //End block
        addTaint(key.getTaint());
        addTaint(defValues.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1217950457.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1217950457;
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Set<String> v = (Set<String>) mMap.get(key);
            //return v != null ? v : defValues;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.591 -0400", hash_original_method = "ACC29E9B287DA38F520685100499E9BD", hash_generated_method = "BDCA8394FE3D4442F9F414302FDF1C6A")
    public int getInt(String key, int defValue) {
        {
            awaitLoadedLocked();
            Integer v;
            v = (Integer)mMap.get(key);
        } //End block
        addTaint(key.getTaint());
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319064855 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319064855;
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Integer v = (Integer)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.593 -0400", hash_original_method = "44BE6AE8D3AB2ABE731A78B854B12E07", hash_generated_method = "97C891F1CF3947C2B2986DB0B68ADAE0")
    public long getLong(String key, long defValue) {
        {
            awaitLoadedLocked();
            Long v;
            v = (Long)mMap.get(key);
        } //End block
        addTaint(key.getTaint());
        addTaint(defValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_415394281 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_415394281;
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Long v = (Long)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.616 -0400", hash_original_method = "E216C3CDDFA2EB08E1EA436EA866244B", hash_generated_method = "4DA5F5EF2F0FBB04CE794E1E288ECC76")
    public float getFloat(String key, float defValue) {
        {
            awaitLoadedLocked();
            Float v;
            v = (Float)mMap.get(key);
        } //End block
        addTaint(key.getTaint());
        addTaint(defValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1111997362 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1111997362;
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Float v = (Float)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.618 -0400", hash_original_method = "726255BCC2D6177085677A1712342F0B", hash_generated_method = "49FF72B6816C8C0942E7AC7E304E0447")
    public boolean getBoolean(String key, boolean defValue) {
        {
            awaitLoadedLocked();
            Boolean v;
            v = (Boolean)mMap.get(key);
        } //End block
        addTaint(key.getTaint());
        addTaint(defValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1251215219 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1251215219;
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Boolean v = (Boolean)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.634 -0400", hash_original_method = "62FFF74487B278708D1160DE5B5FB2C0", hash_generated_method = "ABFFD40A90B4F52A19863EB86DC9A56C")
    public boolean contains(String key) {
        {
            awaitLoadedLocked();
            boolean varBC7DFBFAB8E0EAD217132FDF3CCDDF3E_1817339486 = (mMap.containsKey(key));
        } //End block
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1110268800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1110268800;
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //return mMap.containsKey(key);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.656 -0400", hash_original_method = "4D22F9B98CC44B257DB4ED7BF7E423CC", hash_generated_method = "EB163B1F148ECD2CD2726FF379A378BF")
    public Editor edit() {
        Editor varB4EAC82CA7396A68D541C85D26508E83_45725857 = null; //Variable for return #1
        {
            awaitLoadedLocked();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_45725857 = new EditorImpl();
        varB4EAC82CA7396A68D541C85D26508E83_45725857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_45725857;
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
        //}
        //return new EditorImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.659 -0400", hash_original_method = "4AFBAD62741BB9BDCEF60806B476332B", hash_generated_method = "74CC2871D12ECE2A1EE5177FB0AD9D93")
    private void enqueueDiskWrite(final MemoryCommitResult mcr,
                                  final Runnable postWriteRunnable) {
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
                Object var232E05A46CB4C244745CD03ED44CEBDA_1485405033 = (SharedPreferencesImpl.this);
                {
                    wasEmpty = mDiskWritesInFlight == 1;
                } //End block
            } //End collapsed parenthetic
            {
                writeToDiskRunnable.run();
            } //End block
        } //End block
        QueuedWork.singleThreadExecutor().execute(writeToDiskRunnable);
        addTaint(mcr.getTaint());
        addTaint(postWriteRunnable.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.767 -0400", hash_original_method = "2845FAF740EE3AE38D64734030124734", hash_generated_method = "160F71696A21D8E90D10EF60BE3E0E5A")
    private void writeToFile(MemoryCommitResult mcr) {
        {
            boolean var41D133D77C4B3BDDC7C7FBBBF4C95E6E_723129630 = (mFile.exists());
            {
                {
                    mcr.setDiskWriteResult(true);
                } //End block
                {
                    boolean var8752700CBD0D95D9BA93EA4EAF6E4584_2092709303 = (!mBackupFile.exists());
                    {
                        {
                            boolean var97E99B42A4C3EF9AD06C1BE92A8A0125_2028446331 = (!mFile.renameTo(mBackupFile));
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
                boolean varFC8A9325D409852FB2BC7AA91339B9F1_1595301816 = (FileUtils.getFileStatus(mFile.getPath(), stat));
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
            boolean var41D133D77C4B3BDDC7C7FBBBF4C95E6E_631360257 = (mFile.exists());
            {
                {
                    boolean var8D9FAE26A4E65BB2FC5E55BBC862BDCF_488439746 = (!mFile.delete());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mcr.setDiskWriteResult(false);
        addTaint(mcr.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class MemoryCommitResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.768 -0400", hash_original_field = "D95BD0518BB4F43B535228C63C0E9529", hash_generated_field = "847375890450F151D556659ED58991B9")

        public boolean changesMade;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.769 -0400", hash_original_field = "E057A2283FA415AE4F5DE3F903192B58", hash_generated_field = "2EE2DFA90D3D2D3F9516D4CD5FDE4122")

        public List<String> keysModified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.769 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "D2E9E84BD48FF6DFF6D2BC37523716C3")

        public Set<OnSharedPreferenceChangeListener> listeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.769 -0400", hash_original_field = "63B9355E30BB36B123935E6270708B82", hash_generated_field = "143E2DEB766BC6AA285B54EE395A1A59")

        public Map<?, ?> mapToWriteToDisk;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.775 -0400", hash_original_field = "3C622B5F3AE156A00C4DA8B3E89B016C", hash_generated_field = "A8FB0D276D7FC61E0DFB07E94D1408E9")

        public CountDownLatch writtenToDiskLatch = new CountDownLatch(1);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.775 -0400", hash_original_field = "69DAF4DA3C593998196593AA2703C4E5", hash_generated_field = "94D38FC27B034675B74D4377E55C9971")

        public volatile boolean writeToDiskResult = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.776 -0400", hash_original_method = "1F3E23CA54BAEE886A8B49EA267FA6D4", hash_generated_method = "1F3E23CA54BAEE886A8B49EA267FA6D4")
        public MemoryCommitResult ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.778 -0400", hash_original_method = "152989348B1D3907F6F06DB9CE213C64", hash_generated_method = "42EC6758C9478DCC3AFC3B660B4B2855")
        public void setDiskWriteResult(boolean result) {
            writeToDiskResult = result;
            writtenToDiskLatch.countDown();
            // ---------- Original Method ----------
            //writeToDiskResult = result;
            //writtenToDiskLatch.countDown();
        }

        
    }


    
    public final class EditorImpl implements Editor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.795 -0400", hash_original_field = "A130CB8A78801D9647C2A4F78DD86FAE", hash_generated_field = "917BD86E7C0223F8B2A572E9FF686152")

        private Map<String, Object> mModified = Maps.newHashMap();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.795 -0400", hash_original_field = "8FC1E08A5AA0AC830CDEAE8C011940A3", hash_generated_field = "67418A00EF4F0B8868F3E7D11AB465BE")

        private boolean mClear = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.796 -0400", hash_original_method = "068A863F3588C3FB3F228BFE7DE0FB01", hash_generated_method = "068A863F3588C3FB3F228BFE7DE0FB01")
        public EditorImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.802 -0400", hash_original_method = "EFFD7B235C5590A6C15EA464602A0862", hash_generated_method = "6F0F549AA8F946ED27BE3098BDA8394A")
        public Editor putString(String key, String value) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_787157910 = null; //Variable for return #1
            {
                mModified.put(key, value);
                varB4EAC82CA7396A68D541C85D26508E83_787157910 = this;
            } //End block
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_787157910.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_787157910;
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.819 -0400", hash_original_method = "799426C68EE59A97CAF3D6E033ED6AED", hash_generated_method = "F6945B645009FD1EAC9016428F06DB45")
        public Editor putStringSet(String key, Set<String> values) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_51825217 = null; //Variable for return #1
            {
                mModified.put(key, values);
                varB4EAC82CA7396A68D541C85D26508E83_51825217 = this;
            } //End block
            addTaint(key.getTaint());
            addTaint(values.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_51825217.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_51825217;
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, values);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.834 -0400", hash_original_method = "B5181352BC82403801755A11BC05DCE9", hash_generated_method = "790ADABEBC22A21F2E64AD92A35C79A6")
        public Editor putInt(String key, int value) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_531859918 = null; //Variable for return #1
            {
                mModified.put(key, value);
                varB4EAC82CA7396A68D541C85D26508E83_531859918 = this;
            } //End block
            addTaint(key.getTaint());
            addTaint(value);
            varB4EAC82CA7396A68D541C85D26508E83_531859918.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_531859918;
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.836 -0400", hash_original_method = "2390F394A779B486378B9C93DB0AC773", hash_generated_method = "8A67B1728887E4A7318D6B420F1F3246")
        public Editor putLong(String key, long value) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_223910167 = null; //Variable for return #1
            {
                mModified.put(key, value);
                varB4EAC82CA7396A68D541C85D26508E83_223910167 = this;
            } //End block
            addTaint(key.getTaint());
            addTaint(value);
            varB4EAC82CA7396A68D541C85D26508E83_223910167.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_223910167;
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.853 -0400", hash_original_method = "913478FEA634AAED5778EE46C57EEF5E", hash_generated_method = "C5018A7CA5DDE37108793A24C5E959E2")
        public Editor putFloat(String key, float value) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_1276631281 = null; //Variable for return #1
            {
                mModified.put(key, value);
                varB4EAC82CA7396A68D541C85D26508E83_1276631281 = this;
            } //End block
            addTaint(key.getTaint());
            addTaint(value);
            varB4EAC82CA7396A68D541C85D26508E83_1276631281.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1276631281;
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.868 -0400", hash_original_method = "FBC14C4FFFA5A0EBC88C6D503172C819", hash_generated_method = "3BEF409F851197E20D7B88D6DB9823B5")
        public Editor putBoolean(String key, boolean value) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_1951587615 = null; //Variable for return #1
            {
                mModified.put(key, value);
                varB4EAC82CA7396A68D541C85D26508E83_1951587615 = this;
            } //End block
            addTaint(key.getTaint());
            addTaint(value);
            varB4EAC82CA7396A68D541C85D26508E83_1951587615.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1951587615;
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.883 -0400", hash_original_method = "7C60C1DCB4FF55A3B2BA6A50F523FE33", hash_generated_method = "8A9536DE94AC98FD519BA4284D4BB5FA")
        public Editor remove(String key) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_715897280 = null; //Variable for return #1
            {
                mModified.put(key, this);
                varB4EAC82CA7396A68D541C85D26508E83_715897280 = this;
            } //End block
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_715897280.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_715897280;
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, this);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.899 -0400", hash_original_method = "59F9BBF7AADFDAE77F62CA904307DAB9", hash_generated_method = "3E209AF3CA7D7340A5394FBE04645CE6")
        public Editor clear() {
            Editor varB4EAC82CA7396A68D541C85D26508E83_1451802196 = null; //Variable for return #1
            {
                mClear = true;
                varB4EAC82CA7396A68D541C85D26508E83_1451802196 = this;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1451802196.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1451802196;
            // ---------- Original Method ----------
            //synchronized (this) {
                //mClear = true;
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.905 -0400", hash_original_method = "874FED7345E8B1C9E07FEF0510B9D798", hash_generated_method = "BFCA20DC6902321268BE1A072C0F913B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.394 -0400", hash_original_method = "686A9AF4CEF5EAEBEB20BB8BD072C7B7", hash_generated_method = "92B7E835B0A7FFF966C345B82022C816")
        private MemoryCommitResult commitToMemory() {
            MemoryCommitResult varB4EAC82CA7396A68D541C85D26508E83_1541402790 = null; //Variable for return #1
            MemoryCommitResult mcr;
            mcr = new MemoryCommitResult();
            {
                Object var232E05A46CB4C244745CD03ED44CEBDA_148414570 = (SharedPreferencesImpl.this);
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
                                boolean var8C6FF294AFEFAD057AE1B35F44B10299_2131320639 = (!mMap.isEmpty());
                                {
                                    mcr.changesMade = true;
                                    mMap.clear();
                                } //End block
                            } //End collapsed parenthetic
                            mClear = false;
                        } //End block
                        {
                            Iterator<Map.Entry<String, Object>> varF82C588A08B6DF5CE4ADFA834C909247_1754913386 = (mModified.entrySet()).iterator();
                            varF82C588A08B6DF5CE4ADFA834C909247_1754913386.hasNext();
                            Map.Entry<String, Object> e = varF82C588A08B6DF5CE4ADFA834C909247_1754913386.next();
                            {
                                String k;
                                k = e.getKey();
                                Object v;
                                v = e.getValue();
                                {
                                    boolean var7481F5BED4B812C399339F0465352930_1230311708 = (v == this);
                                    {
                                        {
                                            boolean varCB62A03BC7382484A4D8527AC1D5B67C_272645370 = (!mMap.containsKey(k));
                                        } //End collapsed parenthetic
                                        mMap.remove(k);
                                    } //End block
                                    {
                                        boolean isSame;
                                        isSame = false;
                                        {
                                            boolean var1476C62562F740B1204AB200EEE2D273_1012601580 = (mMap.containsKey(k));
                                            {
                                                Object existingValue;
                                                existingValue = mMap.get(k);
                                                {
                                                    boolean var3F40C0122B4BFCB85951F0CA9C389424_537368218 = (existingValue != null && existingValue.equals(v));
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
            varB4EAC82CA7396A68D541C85D26508E83_1541402790 = mcr;
            varB4EAC82CA7396A68D541C85D26508E83_1541402790.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1541402790;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.404 -0400", hash_original_method = "23D73852609E646C4CF9B990F4BA7C23", hash_generated_method = "5371189AB217F0767202F0D9FAF756CE")
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1297575442 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1297575442;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.680 -0400", hash_original_method = "9C764C33950FD36589194E2D3CE4E56B", hash_generated_method = "B0BB182F220EA3988BD9F6B8F618904A")
        private void notifyListeners(final MemoryCommitResult mcr) {
            {
                boolean var98EE468E1F91A5EC4E053BA5E9799A53_680370174 = (mcr.listeners == null || mcr.keysModified == null ||
                mcr.keysModified.size() == 0);
            } //End collapsed parenthetic
            {
                boolean var748E4843A4DFD33AE33247B092F762F7_216954136 = (Looper.myLooper() == Looper.getMainLooper());
                {
                    {
                        int i;
                        i = mcr.keysModified.size() - 1;
                        {
                            String key;
                            key = mcr.keysModified.get(i);
                            {
                                Iterator<OnSharedPreferenceChangeListener> var66C8E5D21325C7C68FB016F2A231877B_1699551879 = (mcr.listeners).iterator();
                                var66C8E5D21325C7C68FB016F2A231877B_1699551879.hasNext();
                                OnSharedPreferenceChangeListener listener = var66C8E5D21325C7C68FB016F2A231877B_1699551879.next();
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.679 -0400", hash_original_method = "ADA4A7900A87A83172528D6D189EF104", hash_generated_method = "0CB8C5BDC799C735934697841D29C178")
                        public void run() {
                            notifyListeners(mcr);
                            // ---------- Original Method ----------
                            //notifyListeners(mcr);
                        }
});
                } //End block
            } //End collapsed parenthetic
            addTaint(mcr.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.685 -0400", hash_original_field = "E76DDC92A085F8DE2EE56A6A1496F8A9", hash_generated_field = "F724E6683ED056D938357D7363FB576B")

    private static String TAG = "SharedPreferencesImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.685 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.685 -0400", hash_original_field = "03EAB6F64D45D96F1A944CA041405FE8", hash_generated_field = "8770520265F25050E6D4BA20B20851D6")

    private static Object mContent = new Object();
}

