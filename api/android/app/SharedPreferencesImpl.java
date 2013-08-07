package android.app;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.229 -0400", hash_original_field = "E5808F908EB29E322B1768E76474CE1A", hash_generated_field = "183611C0D8A74A7CE3F1C64EE45173DC")

    private File mFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.229 -0400", hash_original_field = "0A263079383F856884EA291D72524709", hash_generated_field = "7006A03D2BDB683A38E82C1F26A37BBC")

    private File mBackupFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.229 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.229 -0400", hash_original_field = "47CB5CD11AAE7A0AB09FB37CAC0E4D7D", hash_generated_field = "9D9685A7435D44306A90CB052DCBD9B4")

    private Map<String, Object> mMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.229 -0400", hash_original_field = "5EC3B01F32E52F458882437DB44990B0", hash_generated_field = "218913F8CAD5DFBC796CF278F1F6F361")

    private int mDiskWritesInFlight = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.229 -0400", hash_original_field = "F9858423033ADDAF927382FE14C29268", hash_generated_field = "E678253CB2423592337E0A1DE6C3016E")

    private boolean mLoaded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.229 -0400", hash_original_field = "38B6A70426F0DA6F22186F8D94FC0483", hash_generated_field = "D6415D56649386C512A0DE29962BED58")

    private long mStatTimestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.229 -0400", hash_original_field = "A73B790C6436C519DD1A505D631741B2", hash_generated_field = "233A577B65E241EDEA724E56888AD815")

    private long mStatSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.229 -0400", hash_original_field = "7E9DD87C9BB99BC747C950C13F9235C5", hash_generated_field = "D1F20D8D55C67F61CAC77B996641DBA2")

    private final Object mWritingToDiskLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.230 -0400", hash_original_field = "503C94D9DD1FDDA737114094FA5AB14C", hash_generated_field = "34D518B65819EB832F27E3847E67CF23")

    private final WeakHashMap<OnSharedPreferenceChangeListener, Object> mListeners = new WeakHashMap<OnSharedPreferenceChangeListener, Object>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.231 -0400", hash_original_method = "4EED344672F91D55C3B3E75973F50190", hash_generated_method = "AB0E91D1F1D686F65B061AF8458F6A61")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.233 -0400", hash_original_method = "F1282AA19C3183BEA34E2A247A149BD2", hash_generated_method = "E48C7078411FE40CA01BD8CB4F54AF62")
    private void startLoadFromDisk() {
        synchronized
(this)        {
            mLoaded = false;
        } //End block
        new Thread("SharedPreferencesImpl-load") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.232 -0400", hash_original_method = "6D08A306D4AFABC44535E176A1E8BC52", hash_generated_method = "691244ABBA990826D6B9CF4F923A29D4")
        public void run() {
            synchronized
(SharedPreferencesImpl.this)            {
                loadFromDiskLocked();
            } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.235 -0400", hash_original_method = "E285F048C64F263B62F1F06EEC72F6E0", hash_generated_method = "3DED542562CB06FB73016C7AD30E6A8D")
    private void loadFromDiskLocked() {
        if(mLoaded)        
        {
            return;
        } //End block
        if(mBackupFile.exists())        
        {
            mFile.delete();
            mBackupFile.renameTo(mFile);
        } //End block
        if(mFile.exists() && !mFile.canRead())        
        {
        } //End block
        Map map = null;
        FileStatus stat = new FileStatus();
        if(FileUtils.getFileStatus(mFile.getPath(), stat) && mFile.canRead())        
        {
            try 
            {
                BufferedInputStream str = new BufferedInputStream(
                        new FileInputStream(mFile), 16*1024);
                map = XmlUtils.readMapXml(str);
                str.close();
            } //End block
            catch (XmlPullParserException e)
            {
            } //End block
            catch (FileNotFoundException e)
            {
            } //End block
            catch (IOException e)
            {
            } //End block
        } //End block
        mLoaded = true;
        if(map != null)        
        {
            mMap = map;
            mStatTimestamp = stat.mtime;
            mStatSize = stat.size;
        } //End block
        else
        {
            mMap = new HashMap<String, Object>();
        } //End block
        notifyAll();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    private static File makeBackupFile(File prefsFile) {
        return new File(prefsFile.getPath() + ".bak");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.236 -0400", hash_original_method = "B476681732C380F10709E29F69091336", hash_generated_method = "B7340558F9D1C5C947F265CE7D670007")
     void startReloadIfChangedUnexpectedly() {
        synchronized
(this)        {
            if(!hasFileChangedUnexpectedly())            
            {
                return;
            } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.237 -0400", hash_original_method = "A66A0F368E0CD54CE4119FA6EA4CE2B9", hash_generated_method = "55FD5FA65D6CB57AB370F322D06BA347")
    private boolean hasFileChangedUnexpectedly() {
        synchronized
(this)        {
            if(mDiskWritesInFlight > 0)            
            {
                if(DEBUG)                
                Log.d(TAG, "disk write in flight, not unexpected.");
                boolean var68934A3E9455FA72420237EB05902327_1425260014 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_315287479 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_315287479;
            } //End block
        } //End block
        FileStatus stat = new FileStatus();
        if(!FileUtils.getFileStatus(mFile.getPath(), stat))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_13488437 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806826748 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_806826748;
        } //End block
        synchronized
(this)        {
            boolean var839CD051CA7A0736713E15DC58F062DD_217507742 = (mStatTimestamp != stat.mtime || mStatSize != stat.size);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411981006 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411981006;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.237 -0400", hash_original_method = "CD8081B759B90CE7833F86EB66B232F5", hash_generated_method = "7242DABCF1140FEF7030451403C108CC")
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(listener.getTaint());
        synchronized
(this)        {
            mListeners.put(listener, mContent);
        } //End block
        // ---------- Original Method ----------
        //synchronized(this) {
            //mListeners.put(listener, mContent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.238 -0400", hash_original_method = "F9E846583CAAA911470841F2FE3AC3FA", hash_generated_method = "70DBE2F44D832760282A1EE45DF0F52C")
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        addTaint(listener.getTaint());
        synchronized
(this)        {
            mListeners.remove(listener);
        } //End block
        // ---------- Original Method ----------
        //synchronized(this) {
            //mListeners.remove(listener);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.238 -0400", hash_original_method = "4E41B5524ECBD1AD902DE6B06A01DA71", hash_generated_method = "8C3BC3A151840941EF4D6E130D26CB97")
    private void awaitLoadedLocked() {
        if(!mLoaded)        
        {
            BlockGuard.getThreadPolicy().onReadFromDisk();
        } //End block
        while
(!mLoaded)        
        {
            try 
            {
                wait();
            } //End block
            catch (InterruptedException unused)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.239 -0400", hash_original_method = "BA8526BB1455076706AECC9BAC06F7D3", hash_generated_method = "EEEF17D74A45FA575A5D380C8A81EE0B")
    public Map<String, ?> getAll() {
        synchronized
(this)        {
            awaitLoadedLocked();
Map<String, ?> var22AE380C67FD9F407F6378E04671F630_878953639 =             new HashMap<String, Object>(mMap);
            var22AE380C67FD9F407F6378E04671F630_878953639.addTaint(taint);
            return var22AE380C67FD9F407F6378E04671F630_878953639;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //return new HashMap<String, Object>(mMap);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.240 -0400", hash_original_method = "4363C372EF13513A221D5D74A24EBA33", hash_generated_method = "87467C2B93D956B797224840B91A0FA7")
    public String getString(String key, String defValue) {
        addTaint(defValue.getTaint());
        addTaint(key.getTaint());
        synchronized
(this)        {
            awaitLoadedLocked();
            String v = (String)mMap.get(key);
String varDC36D6273750D8A228089F7A132C2536_1665326309 =             v != null ? v : defValue;
            varDC36D6273750D8A228089F7A132C2536_1665326309.addTaint(taint);
            return varDC36D6273750D8A228089F7A132C2536_1665326309;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //String v = (String)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.240 -0400", hash_original_method = "66BFB743F0303E06F65F01D81F24C82B", hash_generated_method = "44C3B017FB269ABE054E4E8AE6AD813F")
    public Set<String> getStringSet(String key, Set<String> defValues) {
        addTaint(defValues.getTaint());
        addTaint(key.getTaint());
        synchronized
(this)        {
            awaitLoadedLocked();
            Set<String> v = (Set<String>) mMap.get(key);
Set<String> var5334BDD95C76337E8A1BD5389ACA5D48_818564119 =             v != null ? v : defValues;
            var5334BDD95C76337E8A1BD5389ACA5D48_818564119.addTaint(taint);
            return var5334BDD95C76337E8A1BD5389ACA5D48_818564119;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Set<String> v = (Set<String>) mMap.get(key);
            //return v != null ? v : defValues;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.241 -0400", hash_original_method = "ACC29E9B287DA38F520685100499E9BD", hash_generated_method = "1421B084C917B202821517FD210B1B7E")
    public int getInt(String key, int defValue) {
        addTaint(defValue);
        addTaint(key.getTaint());
        synchronized
(this)        {
            awaitLoadedLocked();
            Integer v = (Integer)mMap.get(key);
            int var42F569DB06B1E00581ED4DD024F0170F_1450681842 = (v != null ? v : defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655553520 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655553520;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Integer v = (Integer)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.242 -0400", hash_original_method = "44BE6AE8D3AB2ABE731A78B854B12E07", hash_generated_method = "116EDA5B23D81455DFD06232C18ABA2A")
    public long getLong(String key, long defValue) {
        addTaint(defValue);
        addTaint(key.getTaint());
        synchronized
(this)        {
            awaitLoadedLocked();
            Long v = (Long)mMap.get(key);
            long var42F569DB06B1E00581ED4DD024F0170F_459533721 = (v != null ? v : defValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1715669646 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1715669646;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Long v = (Long)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.243 -0400", hash_original_method = "E216C3CDDFA2EB08E1EA436EA866244B", hash_generated_method = "BE6183EAD4FADFC0FF9FF680C1742B67")
    public float getFloat(String key, float defValue) {
        addTaint(defValue);
        addTaint(key.getTaint());
        synchronized
(this)        {
            awaitLoadedLocked();
            Float v = (Float)mMap.get(key);
            float var42F569DB06B1E00581ED4DD024F0170F_71500158 = (v != null ? v : defValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_418526093 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_418526093;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Float v = (Float)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.244 -0400", hash_original_method = "726255BCC2D6177085677A1712342F0B", hash_generated_method = "03869DC53E45C6509A39B7D8ACB533D7")
    public boolean getBoolean(String key, boolean defValue) {
        addTaint(defValue);
        addTaint(key.getTaint());
        synchronized
(this)        {
            awaitLoadedLocked();
            Boolean v = (Boolean)mMap.get(key);
            boolean var42F569DB06B1E00581ED4DD024F0170F_1682650096 = (v != null ? v : defValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1516469922 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1516469922;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //Boolean v = (Boolean)mMap.get(key);
            //return v != null ? v : defValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.245 -0400", hash_original_method = "62FFF74487B278708D1160DE5B5FB2C0", hash_generated_method = "507142058497167CDD0945CC755A4A8F")
    public boolean contains(String key) {
        addTaint(key.getTaint());
        synchronized
(this)        {
            awaitLoadedLocked();
            boolean var5BEEF4E2131DD3C69603DDE982CF106F_1393868866 = (mMap.containsKey(key));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2094367101 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2094367101;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
            //return mMap.containsKey(key);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.246 -0400", hash_original_method = "4D22F9B98CC44B257DB4ED7BF7E423CC", hash_generated_method = "BCD947EA23F8C393F3E6CB6012EDB49D")
    public Editor edit() {
        synchronized
(this)        {
            awaitLoadedLocked();
        } //End block
Editor varA40BB66FCF28A9654F109FB5063563BE_1473235632 =         new EditorImpl();
        varA40BB66FCF28A9654F109FB5063563BE_1473235632.addTaint(taint);
        return varA40BB66FCF28A9654F109FB5063563BE_1473235632;
        // ---------- Original Method ----------
        //synchronized (this) {
            //awaitLoadedLocked();
        //}
        //return new EditorImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.247 -0400", hash_original_method = "4AFBAD62741BB9BDCEF60806B476332B", hash_generated_method = "ADE8CB6728E4E8A6058F8BFBCD4C8BD0")
    private void enqueueDiskWrite(final MemoryCommitResult mcr,
                                  final Runnable postWriteRunnable) {
        addTaint(postWriteRunnable.getTaint());
        addTaint(mcr.getTaint());
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
        if(isFromSyncCommit)        
        {
            boolean wasEmpty = false;
            synchronized
(SharedPreferencesImpl.this)            {
                wasEmpty = mDiskWritesInFlight == 1;
            } //End block
            if(wasEmpty)            
            {
                writeToDiskRunnable.run();
                return;
            } //End block
        } //End block
        QueuedWork.singleThreadExecutor().execute(writeToDiskRunnable);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.252 -0400", hash_original_method = "2845FAF740EE3AE38D64734030124734", hash_generated_method = "0B2DC468A044C0061DB30CFADF783EE5")
    private void writeToFile(MemoryCommitResult mcr) {
        addTaint(mcr.getTaint());
        if(mFile.exists())        
        {
            if(!mcr.changesMade)            
            {
                mcr.setDiskWriteResult(true);
                return;
            } //End block
            if(!mBackupFile.exists())            
            {
                if(!mFile.renameTo(mBackupFile))                
                {
                    mcr.setDiskWriteResult(false);
                    return;
                } //End block
            } //End block
            else
            {
                mFile.delete();
            } //End block
        } //End block
        try 
        {
            FileOutputStream str = createFileOutputStream(mFile);
            if(str == null)            
            {
                mcr.setDiskWriteResult(false);
                return;
            } //End block
            XmlUtils.writeMapXml(mcr.mapToWriteToDisk, str);
            FileUtils.sync(str);
            str.close();
            ContextImpl.setFilePermissionsFromMode(mFile.getPath(), mMode, 0);
            FileStatus stat = new FileStatus();
            if(FileUtils.getFileStatus(mFile.getPath(), stat))            
            {
                synchronized
(this)                {
                    mStatTimestamp = stat.mtime;
                    mStatSize = stat.size;
                } //End block
            } //End block
            mBackupFile.delete();
            mcr.setDiskWriteResult(true);
            return;
        } //End block
        catch (XmlPullParserException e)
        {
        } //End block
        catch (IOException e)
        {
        } //End block
        if(mFile.exists())        
        {
            if(!mFile.delete())            
            {
            } //End block
        } //End block
        mcr.setDiskWriteResult(false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class MemoryCommitResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.255 -0400", hash_original_field = "D95BD0518BB4F43B535228C63C0E9529", hash_generated_field = "847375890450F151D556659ED58991B9")

        public boolean changesMade;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.255 -0400", hash_original_field = "E057A2283FA415AE4F5DE3F903192B58", hash_generated_field = "2EE2DFA90D3D2D3F9516D4CD5FDE4122")

        public List<String> keysModified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.255 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "D2E9E84BD48FF6DFF6D2BC37523716C3")

        public Set<OnSharedPreferenceChangeListener> listeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.255 -0400", hash_original_field = "63B9355E30BB36B123935E6270708B82", hash_generated_field = "143E2DEB766BC6AA285B54EE395A1A59")

        public Map<?, ?> mapToWriteToDisk;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.255 -0400", hash_original_field = "3C622B5F3AE156A00C4DA8B3E89B016C", hash_generated_field = "61E1E794F9CE659EAE912D429A24AAF8")

        public final CountDownLatch writtenToDiskLatch = new CountDownLatch(1);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.256 -0400", hash_original_field = "69DAF4DA3C593998196593AA2703C4E5", hash_generated_field = "94D38FC27B034675B74D4377E55C9971")

        public volatile boolean writeToDiskResult = false;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.256 -0400", hash_original_method = "1F3E23CA54BAEE886A8B49EA267FA6D4", hash_generated_method = "1F3E23CA54BAEE886A8B49EA267FA6D4")
        public MemoryCommitResult ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.256 -0400", hash_original_method = "152989348B1D3907F6F06DB9CE213C64", hash_generated_method = "42EC6758C9478DCC3AFC3B660B4B2855")
        public void setDiskWriteResult(boolean result) {
            writeToDiskResult = result;
            writtenToDiskLatch.countDown();
            // ---------- Original Method ----------
            //writeToDiskResult = result;
            //writtenToDiskLatch.countDown();
        }

        
    }


    
    public final class EditorImpl implements Editor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.257 -0400", hash_original_field = "A130CB8A78801D9647C2A4F78DD86FAE", hash_generated_field = "EAED15AFA724D9B204324BD6499C436E")

        private final Map<String, Object> mModified = Maps.newHashMap();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.257 -0400", hash_original_field = "8FC1E08A5AA0AC830CDEAE8C011940A3", hash_generated_field = "67418A00EF4F0B8868F3E7D11AB465BE")

        private boolean mClear = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.257 -0400", hash_original_method = "068A863F3588C3FB3F228BFE7DE0FB01", hash_generated_method = "068A863F3588C3FB3F228BFE7DE0FB01")
        public EditorImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.258 -0400", hash_original_method = "EFFD7B235C5590A6C15EA464602A0862", hash_generated_method = "38A6E999ECEF68C9FD7FEE8304983842")
        public Editor putString(String key, String value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            synchronized
(this)            {
                mModified.put(key, value);
Editor var72A74007B2BE62B849F475C7BDA4658B_1172870890 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1172870890.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1172870890;
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.259 -0400", hash_original_method = "799426C68EE59A97CAF3D6E033ED6AED", hash_generated_method = "1C409891C79D6130F0FEC18CED6372C3")
        public Editor putStringSet(String key, Set<String> values) {
            addTaint(values.getTaint());
            addTaint(key.getTaint());
            synchronized
(this)            {
                mModified.put(key, values);
Editor var72A74007B2BE62B849F475C7BDA4658B_1824336509 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1824336509.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1824336509;
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, values);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.259 -0400", hash_original_method = "B5181352BC82403801755A11BC05DCE9", hash_generated_method = "7FE198799311C68666C55BC58CAC9C64")
        public Editor putInt(String key, int value) {
            addTaint(value);
            addTaint(key.getTaint());
            synchronized
(this)            {
                mModified.put(key, value);
Editor var72A74007B2BE62B849F475C7BDA4658B_1371212232 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1371212232.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1371212232;
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.260 -0400", hash_original_method = "2390F394A779B486378B9C93DB0AC773", hash_generated_method = "DBD54063FE6C1D258813963723AB5BE6")
        public Editor putLong(String key, long value) {
            addTaint(value);
            addTaint(key.getTaint());
            synchronized
(this)            {
                mModified.put(key, value);
Editor var72A74007B2BE62B849F475C7BDA4658B_1516801441 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1516801441.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1516801441;
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.261 -0400", hash_original_method = "913478FEA634AAED5778EE46C57EEF5E", hash_generated_method = "17916080B855A2F2C9F7BE76BE9CD404")
        public Editor putFloat(String key, float value) {
            addTaint(value);
            addTaint(key.getTaint());
            synchronized
(this)            {
                mModified.put(key, value);
Editor var72A74007B2BE62B849F475C7BDA4658B_1078314449 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1078314449.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1078314449;
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.261 -0400", hash_original_method = "FBC14C4FFFA5A0EBC88C6D503172C819", hash_generated_method = "23828A7773B978701F64580B4EFCECD4")
        public Editor putBoolean(String key, boolean value) {
            addTaint(value);
            addTaint(key.getTaint());
            synchronized
(this)            {
                mModified.put(key, value);
Editor var72A74007B2BE62B849F475C7BDA4658B_289522305 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_289522305.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_289522305;
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, value);
                //return this;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.262 -0400", hash_original_method = "7C60C1DCB4FF55A3B2BA6A50F523FE33", hash_generated_method = "5C9F298E7FB655076BE85D3B4D2698E1")
        public Editor remove(String key) {
            addTaint(key.getTaint());
            synchronized
(this)            {
                mModified.put(key, this);
Editor var72A74007B2BE62B849F475C7BDA4658B_1569512309 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1569512309.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1569512309;
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //mModified.put(key, this);
                //return this;
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.263 -0400", hash_original_method = "59F9BBF7AADFDAE77F62CA904307DAB9", hash_generated_method = "3E159052BFCCBD4740A325F00940797E")
        public Editor clear() {
            synchronized
(this)            {
                mClear = true;
Editor var72A74007B2BE62B849F475C7BDA4658B_976969928 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_976969928.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_976969928;
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //mClear = true;
                //return this;
            //}
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.264 -0400", hash_original_method = "874FED7345E8B1C9E07FEF0510B9D798", hash_generated_method = "5CC8AAF5E6D5D6AB37DD5611809EB508")
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

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.266 -0400", hash_original_method = "686A9AF4CEF5EAEBEB20BB8BD072C7B7", hash_generated_method = "BECCAB2CE57AF091CCE825049DDCE5F6")
        private MemoryCommitResult commitToMemory() {
            MemoryCommitResult mcr = new MemoryCommitResult();
            synchronized
(SharedPreferencesImpl.this)            {
                if(mDiskWritesInFlight > 0)                
                {
                    mMap = new HashMap<String, Object>(mMap);
                } //End block
                mcr.mapToWriteToDisk = mMap;
                mDiskWritesInFlight++;
                boolean hasListeners = mListeners.size() > 0;
                if(hasListeners)                
                {
                    mcr.keysModified = new ArrayList<String>();
                    mcr.listeners =
                            new HashSet<OnSharedPreferenceChangeListener>(mListeners.keySet());
                } //End block
                synchronized
(this)                {
                    if(mClear)                    
                    {
                        if(!mMap.isEmpty())                        
                        {
                            mcr.changesMade = true;
                            mMap.clear();
                        } //End block
                        mClear = false;
                    } //End block
for(Map.Entry<String, Object> e : mModified.entrySet())
                    {
                        String k = e.getKey();
                        Object v = e.getValue();
                        if(v == this)                        
                        {
                            if(!mMap.containsKey(k))                            
                            {
                                continue;
                            } //End block
                            mMap.remove(k);
                        } //End block
                        else
                        {
                            boolean isSame = false;
                            if(mMap.containsKey(k))                            
                            {
                                Object existingValue = mMap.get(k);
                                if(existingValue != null && existingValue.equals(v))                                
                                {
                                    continue;
                                } //End block
                            } //End block
                            mMap.put(k, v);
                        } //End block
                        mcr.changesMade = true;
                        if(hasListeners)                        
                        {
                            mcr.keysModified.add(k);
                        } //End block
                    } //End block
                    mModified.clear();
                } //End block
            } //End block
MemoryCommitResult var154B51BCE99D10E07062079308329222_607911735 =             mcr;
            var154B51BCE99D10E07062079308329222_607911735.addTaint(taint);
            return var154B51BCE99D10E07062079308329222_607911735;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.268 -0400", hash_original_method = "23D73852609E646C4CF9B990F4BA7C23", hash_generated_method = "5EEF3D6974A1B7E78D3D519CA00560B0")
        public boolean commit() {
            MemoryCommitResult mcr = commitToMemory();
            SharedPreferencesImpl.this.enqueueDiskWrite(
                mcr, null );
            try 
            {
                mcr.writtenToDiskLatch.await();
            } //End block
            catch (InterruptedException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_241128553 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467629569 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467629569;
            } //End block
            notifyListeners(mcr);
            boolean var50DEAD4D96E6F3FCD6B4F4A2FDBDB5B0_344684073 = (mcr.writeToDiskResult);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1920048272 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1920048272;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.271 -0400", hash_original_method = "9C764C33950FD36589194E2D3CE4E56B", hash_generated_method = "B8C889EEBF3EC674E28753342BE7CAA9")
        private void notifyListeners(final MemoryCommitResult mcr) {
            addTaint(mcr.getTaint());
            if(mcr.listeners == null || mcr.keysModified == null ||
                mcr.keysModified.size() == 0)            
            {
                return;
            } //End block
            if(Looper.myLooper() == Looper.getMainLooper())            
            {
for(int i = mcr.keysModified.size() - 1;i >= 0;i--)
                {
                    final String key = mcr.keysModified.get(i);
for(OnSharedPreferenceChangeListener listener : mcr.listeners)
                    {
                        if(listener != null)                        
                        {
                            listener.onSharedPreferenceChanged(SharedPreferencesImpl.this, key);
                        } //End block
                    } //End block
                } //End block
            } //End block
            else
            {
                ActivityThread.sMainThreadHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.270 -0400", hash_original_method = "ADA4A7900A87A83172528D6D189EF104", hash_generated_method = "0CB8C5BDC799C735934697841D29C178")
            public void run() {
                notifyListeners(mcr);
                // ---------- Original Method ----------
                //notifyListeners(mcr);
            }
});
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.272 -0400", hash_original_field = "E76DDC92A085F8DE2EE56A6A1496F8A9", hash_generated_field = "FD6664AF36DA0DBF0E6B2E44D4BD8BF3")

    private static final String TAG = "SharedPreferencesImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.273 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.273 -0400", hash_original_field = "03EAB6F64D45D96F1A944CA041405FE8", hash_generated_field = "7CDB17D961908C044A3FCB6E47815B53")

    private static final Object mContent = new Object();
}

