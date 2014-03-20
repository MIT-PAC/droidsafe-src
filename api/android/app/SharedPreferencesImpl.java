package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

import org.xmlpull.v1.XmlPullParserException;

import android.content.SharedPreferences;
import android.os.FileUtils;
import android.os.FileUtils.FileStatus;
import android.os.Looper;
import android.util.Log;

import com.android.internal.util.XmlUtils;
import com.google.android.collect.Maps;

import dalvik.system.BlockGuard;

final class SharedPreferencesImpl implements SharedPreferences {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.838 -0500", hash_original_method = "C980122577ED5655D64E7B6AE9CD1D79", hash_generated_method = "7553570DC3BCA4BBFAE080EB7AEA124E")
    
private static File makeBackupFile(File prefsFile) {
        return new File(prefsFile.getPath() + ".bak");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.944 -0500", hash_original_method = "8706A5F2BF3C277E766BE1BA5825DD17", hash_generated_method = "97918F44CAE3B5E098E992A15594609C")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.798 -0500", hash_original_field = "71BCBA8ABD70A192E1A98E242CC3F798", hash_generated_field = "FD6664AF36DA0DBF0E6B2E44D4BD8BF3")

    private static final String TAG = "SharedPreferencesImpl";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.801 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.824 -0500", hash_original_field = "7AD718A190B0156C9FB03334E50FE133", hash_generated_field = "7CDB17D961908C044A3FCB6E47815B53")

    private static final Object mContent = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.803 -0500", hash_original_field = "03021E7FD9BC2DCB6A1E411C8B6DAF4A", hash_generated_field = "D9014A2BF2B58413645D820DAB699FAA")

    //  - acquire SharedPreferencesImpl.this before EditorImpl.this
    //  - acquire mWritingToDiskLock before EditorImpl.this

    private  File mFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.805 -0500", hash_original_field = "E463A6CBBBF2408E2FDC1C6C56FAD435", hash_generated_field = "7006A03D2BDB683A38E82C1F26A37BBC")

    private  File mBackupFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.808 -0500", hash_original_field = "556F09336B3BD1BEFE7C8BF0B32BAF35", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private  int mMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.810 -0500", hash_original_field = "B60D788EBD863DB6EE8FD847584FBB7F", hash_generated_field = "9D9685A7435D44306A90CB052DCBD9B4")

    private Map<String, Object> mMap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.812 -0500", hash_original_field = "2CA12ECDBDC660DDAEB2B0A2C01D06B2", hash_generated_field = "218913F8CAD5DFBC796CF278F1F6F361")

    private int mDiskWritesInFlight = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.814 -0500", hash_original_field = "BBA89BDCD0EA5051D39E066101AD7A44", hash_generated_field = "E678253CB2423592337E0A1DE6C3016E")

    private boolean mLoaded = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.816 -0500", hash_original_field = "E2A6AB9F7B999BA732956CB11F221693", hash_generated_field = "D6415D56649386C512A0DE29962BED58")

    private long mStatTimestamp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.819 -0500", hash_original_field = "11415DC24E3C27E01B55D2ACE2D8FCCB", hash_generated_field = "233A577B65E241EDEA724E56888AD815")

    private long mStatSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.821 -0500", hash_original_field = "C4804E1990444728DCF9EED976F9CF6C", hash_generated_field = "D1F20D8D55C67F61CAC77B996641DBA2")

    private final Object mWritingToDiskLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.826 -0500", hash_original_field = "44072DA2DA212B55C99058EB01B866C3", hash_generated_field = "34D518B65819EB832F27E3847E67CF23")

    private final WeakHashMap<OnSharedPreferenceChangeListener, Object> mListeners =
            new WeakHashMap<OnSharedPreferenceChangeListener, Object>();

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.828 -0500", hash_original_method = "4EED344672F91D55C3B3E75973F50190", hash_generated_method = "4EED344672F91D55C3B3E75973F50190")
    
SharedPreferencesImpl(File file, int mode) {
        mFile = file;
        mBackupFile = makeBackupFile(file);
        mMode = mode;
        mLoaded = false;
        mMap = null;
        startLoadFromDisk();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.833 -0500", hash_original_method = "F1282AA19C3183BEA34E2A247A149BD2", hash_generated_method = "3C4E7D4F67AD4CD39A3D8C609F5F4AA3")
    
private void startLoadFromDisk() {
        synchronized (this) {
            mLoaded = false;
        }
        new Thread("SharedPreferencesImpl-load") {
            public void run() {
                synchronized (SharedPreferencesImpl.this) {
                    loadFromDiskLocked();
                }
            }
        }.start();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.836 -0500", hash_original_method = "E285F048C64F263B62F1F06EEC72F6E0", hash_generated_method = "286A9FCE00B287BC77ADA41DCAFB3450")
    
private void loadFromDiskLocked() {
        if (mLoaded) {
            return;
        }
        if (mBackupFile.exists()) {
            mFile.delete();
            mBackupFile.renameTo(mFile);
        }

        // Debugging
        if (mFile.exists() && !mFile.canRead()) {
            Log.w(TAG, "Attempt to read preferences file " + mFile + " without permission");
        }

        Map map = null;
        FileStatus stat = new FileStatus();
        if (FileUtils.getFileStatus(mFile.getPath(), stat) && mFile.canRead()) {
            try {
                BufferedInputStream str = new BufferedInputStream(
                        new FileInputStream(mFile), 16*1024);
                map = XmlUtils.readMapXml(str);
                str.close();
            } catch (XmlPullParserException e) {
                Log.w(TAG, "getSharedPreferences", e);
            } catch (FileNotFoundException e) {
                Log.w(TAG, "getSharedPreferences", e);
            } catch (IOException e) {
                Log.w(TAG, "getSharedPreferences", e);
            }
        }
        mLoaded = true;
        if (map != null) {
            mMap = map;
            mStatTimestamp = stat.mtime;
            mStatSize = stat.size;
        } else {
            mMap = new HashMap<String, Object>();
        }
        notifyAll();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.841 -0500", hash_original_method = "B476681732C380F10709E29F69091336", hash_generated_method = "3AE03A5DA98444272151C6B9C663CB79")
    
void startReloadIfChangedUnexpectedly() {
        synchronized (this) {
            // TODO: wait for any pending writes to disk?
            if (!hasFileChangedUnexpectedly()) {
                return;
            }
            startLoadFromDisk();
        }
    }

    // Has the file changed out from under us?  i.e. writes that
    // we didn't instigate.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.843 -0500", hash_original_method = "A66A0F368E0CD54CE4119FA6EA4CE2B9", hash_generated_method = "8970C3B650D4084AA68EA84D9FEB0A16")
    
private boolean hasFileChangedUnexpectedly() {
        synchronized (this) {
            if (mDiskWritesInFlight > 0) {
                // If we know we caused it, it's not unexpected.
                if (DEBUG) Log.d(TAG, "disk write in flight, not unexpected.");
                return false;
            }
        }
        FileStatus stat = new FileStatus();
        if (!FileUtils.getFileStatus(mFile.getPath(), stat)) {
            return true;
        }
        synchronized (this) {
            return toTaintBoolean(mStatTimestamp + stat.mtime +  mStatSize + stat.size);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.845 -0500", hash_original_method = "CD8081B759B90CE7833F86EB66B232F5", hash_generated_method = "25137C4588A9B38A2C8984B7C53137C9")
    
public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        synchronized(this) {
            mListeners.put(listener, mContent);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.847 -0500", hash_original_method = "F9E846583CAAA911470841F2FE3AC3FA", hash_generated_method = "065E5C32D3ADC024F466CAE3FC98E632")
    
public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        synchronized(this) {
            mListeners.remove(listener);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.849 -0500", hash_original_method = "4E41B5524ECBD1AD902DE6B06A01DA71", hash_generated_method = "0F58067B65B73DD44D97312B510CDE4F")
    
private void awaitLoadedLocked() {
        if (!mLoaded) {
            // Raise an explicit StrictMode onReadFromDisk for this
            // thread, since the real read will be in a different
            // thread and otherwise ignored by StrictMode.
            BlockGuard.getThreadPolicy().onReadFromDisk();
        }
        while (!mLoaded) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.851 -0500", hash_original_method = "BA8526BB1455076706AECC9BAC06F7D3", hash_generated_method = "ECB33FC46975FA69CE8C28BBBA3C60BB")
    
public Map<String, ?> getAll() {
        synchronized (this) {
            awaitLoadedLocked();
            //noinspection unchecked
            return new HashMap<String, Object>(mMap);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.853 -0500", hash_original_method = "4363C372EF13513A221D5D74A24EBA33", hash_generated_method = "17A5DE3268095F5141810B524316C349")
    
public String getString(String key, String defValue) {
        synchronized (this) {
            awaitLoadedLocked();
            String v = (String)mMap.get(key);
            return v != null ? v : defValue;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.856 -0500", hash_original_method = "66BFB743F0303E06F65F01D81F24C82B", hash_generated_method = "3257449D6FCC49EACC659EEDC81B8928")
    
public Set<String> getStringSet(String key, Set<String> defValues) {
        synchronized (this) {
            awaitLoadedLocked();
            Set<String> v = (Set<String>) mMap.get(key);
            return v != null ? v : defValues;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.858 -0500", hash_original_method = "ACC29E9B287DA38F520685100499E9BD", hash_generated_method = "793DD6153732330EE594C05370693AC7")
    
public int getInt(String key, int defValue) {
        synchronized (this) {
            awaitLoadedLocked();
            Integer v = (Integer)mMap.get(key);
            return v != null ? v : defValue;
        }
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.860 -0500", hash_original_method = "44BE6AE8D3AB2ABE731A78B854B12E07", hash_generated_method = "16DF23A599684AF0C176C7762E0FC2B2")
    
public long getLong(String key, long defValue) {
        synchronized (this) {
            awaitLoadedLocked();
            Long v = (Long)mMap.get(key);
            return v != null ? v : defValue;
        }
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.862 -0500", hash_original_method = "E216C3CDDFA2EB08E1EA436EA866244B", hash_generated_method = "DC658E8543868358F6E8FDF0101D67FC")
    
public float getFloat(String key, float defValue) {
        synchronized (this) {
            awaitLoadedLocked();
            Float v = (Float)mMap.get(key);
            return v != null ? v : defValue;
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.864 -0500", hash_original_method = "726255BCC2D6177085677A1712342F0B", hash_generated_method = "A70269ED9C7B03CAF7C4A7C147E793A7")
    
public boolean getBoolean(String key, boolean defValue) {
        synchronized (this) {
            awaitLoadedLocked();
            Boolean v = (Boolean)mMap.get(key);
            return v != null ? v : defValue;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.867 -0500", hash_original_method = "62FFF74487B278708D1160DE5B5FB2C0", hash_generated_method = "C3297CD856EE628EA97B8A540FC5A1BF")
    
public boolean contains(String key) {
        synchronized (this) {
            awaitLoadedLocked();
            return mMap.containsKey(key);
        }
    }
    
    private static class MemoryCommitResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.872 -0500", hash_original_field = "425E2198510032AC48F945A666365579", hash_generated_field = "847375890450F151D556659ED58991B9")

        public boolean changesMade;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.875 -0500", hash_original_field = "3F18BA58B3F5D597B3F33DF3948605CC", hash_generated_field = "2EE2DFA90D3D2D3F9516D4CD5FDE4122")

        public List<String> keysModified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.877 -0500", hash_original_field = "158B55D99494201C2ED06EAF0BC23D09", hash_generated_field = "D2E9E84BD48FF6DFF6D2BC37523716C3")

        public Set<OnSharedPreferenceChangeListener> listeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.879 -0500", hash_original_field = "603C0DF5F146B829B60B0460DD341C66", hash_generated_field = "143E2DEB766BC6AA285B54EE395A1A59")

        public Map<?, ?> mapToWriteToDisk;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.881 -0500", hash_original_field = "2103657A5F8A7D2F4D716352F0A55C51", hash_generated_field = "61E1E794F9CE659EAE912D429A24AAF8")

        public final CountDownLatch writtenToDiskLatch = new CountDownLatch(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.883 -0500", hash_original_field = "21E27E4B38F3622E7FF4749F8A1250FC", hash_generated_field = "94D38FC27B034675B74D4377E55C9971")

        public volatile boolean writeToDiskResult = false;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.256 -0400", hash_original_method = "1F3E23CA54BAEE886A8B49EA267FA6D4", hash_generated_method = "1F3E23CA54BAEE886A8B49EA267FA6D4")
        public MemoryCommitResult ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.886 -0500", hash_original_method = "152989348B1D3907F6F06DB9CE213C64", hash_generated_method = "46258347A05DB79FF01662D619C455CC")
        
public void setDiskWriteResult(boolean result) {
            writeToDiskResult = result;
            writtenToDiskLatch.countDown();
        }
        
    }
    
    public final class EditorImpl implements Editor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.890 -0500", hash_original_field = "3FC71DF7D3FFEA41D867531704814F5E", hash_generated_field = "EAED15AFA724D9B204324BD6499C436E")

        private final Map<String, Object> mModified = Maps.newHashMap();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.893 -0500", hash_original_field = "922D569D1FD307D3C7570C9400254C0D", hash_generated_field = "67418A00EF4F0B8868F3E7D11AB465BE")

        private boolean mClear = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.257 -0400", hash_original_method = "068A863F3588C3FB3F228BFE7DE0FB01", hash_generated_method = "068A863F3588C3FB3F228BFE7DE0FB01")
        public EditorImpl ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.895 -0500", hash_original_method = "EFFD7B235C5590A6C15EA464602A0862", hash_generated_method = "82DA87CBC74279FC655F72E59DBC7466")
        
public Editor putString(String key, String value) {
            synchronized (this) {
                mModified.put(key, value);
                return this;
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.897 -0500", hash_original_method = "799426C68EE59A97CAF3D6E033ED6AED", hash_generated_method = "C08C5E45E5163C9F3F90DC1E87096FB1")
        
public Editor putStringSet(String key, Set<String> values) {
            synchronized (this) {
                mModified.put(key, values);
                return this;
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.899 -0500", hash_original_method = "B5181352BC82403801755A11BC05DCE9", hash_generated_method = "FEB23B5D5239BE73E48028E4AC67807F")
        
public Editor putInt(String key, int value) {
            synchronized (this) {
                mModified.put(key, value);
                return this;
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.902 -0500", hash_original_method = "2390F394A779B486378B9C93DB0AC773", hash_generated_method = "68A433FCEF6F5F18A8F0EFF50B293F1B")
        
public Editor putLong(String key, long value) {
            synchronized (this) {
                mModified.put(key, value);
                return this;
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.904 -0500", hash_original_method = "913478FEA634AAED5778EE46C57EEF5E", hash_generated_method = "03AECB3FD8A8FAF9650462CE132AC966")
        
public Editor putFloat(String key, float value) {
            synchronized (this) {
                mModified.put(key, value);
                return this;
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.906 -0500", hash_original_method = "FBC14C4FFFA5A0EBC88C6D503172C819", hash_generated_method = "B4DD0EC9BE234E95F84C4A4A58B7AEFA")
        
public Editor putBoolean(String key, boolean value) {
            synchronized (this) {
                mModified.put(key, value);
                return this;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.908 -0500", hash_original_method = "7C60C1DCB4FF55A3B2BA6A50F523FE33", hash_generated_method = "EFA50E21F7BCB42D7FD80A28DF3C2018")
        
public Editor remove(String key) {
            synchronized (this) {
                mModified.put(key, this);
                return this;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.911 -0500", hash_original_method = "59F9BBF7AADFDAE77F62CA904307DAB9", hash_generated_method = "8E006F8E896C5083155211611DD21E2F")
        
public Editor clear() {
            synchronized (this) {
                mClear = true;
                return this;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.920 -0500", hash_original_method = "874FED7345E8B1C9E07FEF0510B9D798", hash_generated_method = "E4726B52DDF73D2F25CDDB0B64663818")
        
public void apply() {
            final MemoryCommitResult mcr = commitToMemory();
            final Runnable awaitCommit = new Runnable() {
                    public void run() {
                        try {
                            mcr.writtenToDiskLatch.await();
                        } catch (InterruptedException ignored) {
                        }
                    }
                };

            QueuedWork.add(awaitCommit);

            Runnable postWriteRunnable = new Runnable() {
                    public void run() {
                        awaitCommit.run();
                        QueuedWork.remove(awaitCommit);
                    }
                };

            SharedPreferencesImpl.this.enqueueDiskWrite(mcr, postWriteRunnable);

            // Okay to notify the listeners before it's hit disk
            // because the listeners should always get the same
            // SharedPreferences instance back, which has the
            // changes reflected in memory.
            notifyListeners(mcr);
        }

        // Returns true if any changes were made
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.923 -0500", hash_original_method = "686A9AF4CEF5EAEBEB20BB8BD072C7B7", hash_generated_method = "9BA2189DE8CEA93CF33B821EC45821DA")
        
private MemoryCommitResult commitToMemory() {
            MemoryCommitResult mcr = new MemoryCommitResult();
            synchronized (SharedPreferencesImpl.this) {
                // We optimistically don't make a deep copy until
                // a memory commit comes in when we're already
                // writing to disk.
                if (mDiskWritesInFlight > 0) {
                    // We can't modify our mMap as a currently
                    // in-flight write owns it.  Clone it before
                    // modifying it.
                    // noinspection unchecked
                    mMap = new HashMap<String, Object>(mMap);
                }
                mcr.mapToWriteToDisk = mMap;
                mDiskWritesInFlight++;

                boolean hasListeners = mListeners.size() > 0;
                if (hasListeners) {
                    mcr.keysModified = new ArrayList<String>();
                    mcr.listeners =
                            new HashSet<OnSharedPreferenceChangeListener>(mListeners.keySet());
                }

                synchronized (this) {
                    if (mClear) {
                        if (!mMap.isEmpty()) {
                            mcr.changesMade = true;
                            mMap.clear();
                        }
                        mClear = false;
                    }

                    for (Map.Entry<String, Object> e : mModified.entrySet()) {
                        String k = e.getKey();
                        Object v = e.getValue();
                        if (v == this) {  // magic value for a removal mutation
                            if (!mMap.containsKey(k)) {
                                continue;
                            }
                            mMap.remove(k);
                        } else {
                            boolean isSame = false;
                            if (mMap.containsKey(k)) {
                                Object existingValue = mMap.get(k);
                                if (existingValue != null && existingValue.equals(v)) {
                                    continue;
                                }
                            }
                            mMap.put(k, v);
                        }

                        mcr.changesMade = true;
                        if (hasListeners) {
                            mcr.keysModified.add(k);
                        }
                    }

                    mModified.clear();
                }
            }
            return mcr;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.925 -0500", hash_original_method = "23D73852609E646C4CF9B990F4BA7C23", hash_generated_method = "B941E20570A0708A8A4C7429464090D9")
        
public boolean commit() {
            MemoryCommitResult mcr = commitToMemory();
            SharedPreferencesImpl.this.enqueueDiskWrite(
                mcr, null /* sync write on this thread okay */);
            try {
                mcr.writtenToDiskLatch.await();
            } catch (InterruptedException e) {
                return false;
            }
            notifyListeners(mcr);
            return mcr.writeToDiskResult;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.932 -0500", hash_original_method = "9C764C33950FD36589194E2D3CE4E56B", hash_generated_method = "E7A44895AE6A994C9DEED51B844FC3ED")
        
private void notifyListeners(final MemoryCommitResult mcr) {
            if (mcr.listeners == null || mcr.keysModified == null ||
                mcr.keysModified.size() == 0) {
                return;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                for (int i = mcr.keysModified.size() - 1; i >= 0; i--) {
                    final String key = mcr.keysModified.get(i);
                    for (OnSharedPreferenceChangeListener listener : mcr.listeners) {
                        if (listener != null) {
                            listener.onSharedPreferenceChanged(SharedPreferencesImpl.this, key);
                        }
                    }
                }
            } else {
                // Run this function on the main thread.
                ActivityThread.sMainThreadHandler.post(new Runnable() {
                        public void run() {
                            notifyListeners(mcr);
                        }
                    });
            }
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.869 -0500", hash_original_method = "4D22F9B98CC44B257DB4ED7BF7E423CC", hash_generated_method = "4C61589964CC4BF4AD38A4925858E7BC")
    
public Editor edit() {
        // TODO: remove the need to call awaitLoadedLocked() when
        // requesting an editor.  will require some work on the
        // Editor, but then we should be able to do:
        //
        //      context.getSharedPreferences(..).edit().putString(..).apply()
        //
        // ... all without blocking.
        synchronized (this) {
            awaitLoadedLocked();
        }

        return new EditorImpl();
    }

    /**
     * Enqueue an already-committed-to-memory result to be written
     * to disk.
     *
     * They will be written to disk one-at-a-time in the order
     * that they're enqueued.
     *
     * @param postWriteRunnable if non-null, we're being called
     *   from apply() and this is the runnable to run after
     *   the write proceeds.  if null (from a regular commit()),
     *   then we're allowed to do this disk write on the main
     *   thread (which in addition to reducing allocations and
     *   creating a background thread, this has the advantage that
     *   we catch them in userdebug StrictMode reports to convert
     *   them where possible to apply() ...)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.941 -0500", hash_original_method = "4AFBAD62741BB9BDCEF60806B476332B", hash_generated_method = "55E219AFF5D1BA280697DD4CECB13754")
    
private void enqueueDiskWrite(final MemoryCommitResult mcr,
                                  final Runnable postWriteRunnable) {
        final Runnable writeToDiskRunnable = new Runnable() {
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

        final boolean isFromSyncCommit = (postWriteRunnable == null);

        // Typical #commit() path with fewer allocations, doing a write on
        // the current thread.
        if (isFromSyncCommit) {
            boolean wasEmpty = false;
            synchronized (SharedPreferencesImpl.this) {
                wasEmpty = mDiskWritesInFlight == 1;
            }
            if (wasEmpty) {
                writeToDiskRunnable.run();
                return;
            }
        }

        QueuedWork.singleThreadExecutor().execute(writeToDiskRunnable);
    }

    // Note: must hold mWritingToDiskLock
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.948 -0500", hash_original_method = "2845FAF740EE3AE38D64734030124734", hash_generated_method = "33C02F22B6D01BCA645F03D0B47618B7")
    
private void writeToFile(MemoryCommitResult mcr) {
        // Rename the current file so it may be used as a backup during the next read
        if (mFile.exists()) {
            if (!mcr.changesMade) {
                // If the file already exists, but no changes were
                // made to the underlying map, it's wasteful to
                // re-write the file.  Return as if we wrote it
                // out.
                mcr.setDiskWriteResult(true);
                return;
            }
            if (!mBackupFile.exists()) {
                if (!mFile.renameTo(mBackupFile)) {
                    Log.e(TAG, "Couldn't rename file " + mFile
                          + " to backup file " + mBackupFile);
                    mcr.setDiskWriteResult(false);
                    return;
                }
            } else {
                mFile.delete();
            }
        }

        // Attempt to write the file, delete the backup and return true as atomically as
        // possible.  If any exception occurs, delete the new file; next time we will restore
        // from the backup.
        try {
            FileOutputStream str = createFileOutputStream(mFile);
            if (str == null) {
                mcr.setDiskWriteResult(false);
                return;
            }
            XmlUtils.writeMapXml(mcr.mapToWriteToDisk, str);
            FileUtils.sync(str);
            str.close();
            ContextImpl.setFilePermissionsFromMode(mFile.getPath(), mMode, 0);
            FileStatus stat = new FileStatus();
            if (FileUtils.getFileStatus(mFile.getPath(), stat)) {
                synchronized (this) {
                    mStatTimestamp = stat.mtime;
                    mStatSize = stat.size;
                }
            }
            // Writing was successful, delete the backup file if there is one.
            mBackupFile.delete();
            mcr.setDiskWriteResult(true);
            return;
        } catch (XmlPullParserException e) {
            Log.w(TAG, "writeToFile: Got exception:", e);
        } catch (IOException e) {
            Log.w(TAG, "writeToFile: Got exception:", e);
        }
        // Clean up an unsuccessfully written file
        if (mFile.exists()) {
            if (!mFile.delete()) {
                Log.e(TAG, "Couldn't clean up partially-written file " + mFile);
            }
        }
        mcr.setDiskWriteResult(false);
    }
}

