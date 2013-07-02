package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.480 -0400", hash_original_field = "E5808F908EB29E322B1768E76474CE1A", hash_generated_field = "183611C0D8A74A7CE3F1C64EE45173DC")

    private File mFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.481 -0400", hash_original_field = "0A263079383F856884EA291D72524709", hash_generated_field = "7006A03D2BDB683A38E82C1F26A37BBC")

    private File mBackupFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.481 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.481 -0400", hash_original_field = "47CB5CD11AAE7A0AB09FB37CAC0E4D7D", hash_generated_field = "9D9685A7435D44306A90CB052DCBD9B4")

    private Map<String, Object> mMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.481 -0400", hash_original_field = "5EC3B01F32E52F458882437DB44990B0", hash_generated_field = "218913F8CAD5DFBC796CF278F1F6F361")

    private int mDiskWritesInFlight = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.481 -0400", hash_original_field = "F9858423033ADDAF927382FE14C29268", hash_generated_field = "E678253CB2423592337E0A1DE6C3016E")

    private boolean mLoaded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.481 -0400", hash_original_field = "38B6A70426F0DA6F22186F8D94FC0483", hash_generated_field = "D6415D56649386C512A0DE29962BED58")

    private long mStatTimestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.481 -0400", hash_original_field = "A73B790C6436C519DD1A505D631741B2", hash_generated_field = "233A577B65E241EDEA724E56888AD815")

    private long mStatSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.481 -0400", hash_original_field = "7E9DD87C9BB99BC747C950C13F9235C5", hash_generated_field = "D1F20D8D55C67F61CAC77B996641DBA2")

    private final Object mWritingToDiskLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.481 -0400", hash_original_field = "503C94D9DD1FDDA737114094FA5AB14C", hash_generated_field = "34D518B65819EB832F27E3847E67CF23")

    private final WeakHashMap<OnSharedPreferenceChangeListener, Object> mListeners = new WeakHashMap<OnSharedPreferenceChangeListener, Object>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.482 -0400", hash_original_method = "4EED344672F91D55C3B3E75973F50190", hash_generated_method = "AB0E91D1F1D686F65B061AF8458F6A61")
      SharedPreferencesImpl(File file, int mode) {
        mFile = file;
        mBackupFile = makeBackupFile(file);
        mMode = mode;
        mLoaded = false;
        mMap = null;
        startLoadFromDisk();
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.484 -0400", hash_original_method = "F1282AA19C3183BEA34E2A247A149BD2", hash_generated_method = "1981DE0C235889B77CBAF5E3BCFC4137")
    private void startLoadFromDisk() {
        {
            mLoaded = false;
        } 
        new Thread("SharedPreferencesImpl-load") {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.484 -0400", hash_original_method = "6D08A306D4AFABC44535E176A1E8BC52", hash_generated_method = "C3556A9CDF1B966BA8163613C05E53EF")
            public void run() {
                {
                    Object varEEB7B748507846A2C83D03D5993A3A41_1054063937 = (SharedPreferencesImpl.this);
                    {
                        loadFromDiskLocked();
                    } 
                } 
                
                
                    
                
            }
}.start();
        
        
            
        
        
            
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.485 -0400", hash_original_method = "E285F048C64F263B62F1F06EEC72F6E0", hash_generated_method = "7F5BE1AF3C0D8B62552175FE687C9AA1")
    private void loadFromDiskLocked() {
        {
            boolean var99DE0DB14FFB66602F09FEFBD7F17565_1302856815 = (mBackupFile.exists());
            {
                mFile.delete();
                mBackupFile.renameTo(mFile);
            } 
        } 
        {
            boolean varD47DECAE2FF36587B1AAA379A993E7CF_2136162774 = (mFile.exists() && !mFile.canRead());
        } 
        Map map = null;
        FileStatus stat = new FileStatus();
        {
            boolean varC462C115997B1889F4CA41126EC911E2_1197685311 = (FileUtils.getFileStatus(mFile.getPath(), stat) && mFile.canRead());
            {
                try 
                {
                    BufferedInputStream str = new BufferedInputStream(
                        new FileInputStream(mFile), 16*1024);
                    map = XmlUtils.readMapXml(str);
                    str.close();
                } 
                catch (XmlPullParserException e)
                { }
                catch (FileNotFoundException e)
                { }
                catch (IOException e)
                { }
            } 
        } 
        mLoaded = true;
        {
            mMap = map;
            mStatTimestamp = stat.mtime;
            mStatSize = stat.size;
        } 
        {
            mMap = new HashMap<String, Object>();
        } 
        notifyAll();
        
        
    }

    
        private static File makeBackupFile(File prefsFile) {
        return new File(prefsFile.getPath() + ".bak");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.486 -0400", hash_original_method = "B476681732C380F10709E29F69091336", hash_generated_method = "25B6FD729C450F0EAAFB5D2444D6280C")
     void startReloadIfChangedUnexpectedly() {
        {
            {
                boolean varB6158C0E75648F64F85FE11BFA0EEA58_1256336291 = (!hasFileChangedUnexpectedly());
            } 
            startLoadFromDisk();
        } 
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.486 -0400", hash_original_method = "A66A0F368E0CD54CE4119FA6EA4CE2B9", hash_generated_method = "1465E7EFD9FCAB48BB6ADD50F063402C")
    private boolean hasFileChangedUnexpectedly() {
        {
            {
                Log.d(TAG, "disk write in flight, not unexpected.");
            } 
        } 
        FileStatus stat = new FileStatus();
        {
            boolean varA005498AA56B05798F31373B591C38F2_620249599 = (!FileUtils.getFileStatus(mFile.getPath(), stat));
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_660091489 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_660091489;
        
        
            
                
                
            
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.487 -0400", hash_original_method = "CD8081B759B90CE7833F86EB66B232F5", hash_generated_method = "CEC7D0ED2AE4F64E535B55F2C4201329")
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        
        {
            mListeners.put(listener, mContent);
        } 
        addTaint(listener.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.488 -0400", hash_original_method = "F9E846583CAAA911470841F2FE3AC3FA", hash_generated_method = "7C1E1732C686E572E83F992E2802B970")
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        {
            mListeners.remove(listener);
        } 
        addTaint(listener.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.488 -0400", hash_original_method = "4E41B5524ECBD1AD902DE6B06A01DA71", hash_generated_method = "7DE227DA1D900EAA31405CC92B33A633")
    private void awaitLoadedLocked() {
        {
            BlockGuard.getThreadPolicy().onReadFromDisk();
        } 
        {
            try 
            {
                wait();
            } 
            catch (InterruptedException unused)
            { }
        } 
        
        
            
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.491 -0400", hash_original_method = "BA8526BB1455076706AECC9BAC06F7D3", hash_generated_method = "5A0EFA124DCAE63CD325307267C926E5")
    public Map<String, ?> getAll() {
        Map<String, ?> varB4EAC82CA7396A68D541C85D26508E83_1923204164 = null; 
        {
            awaitLoadedLocked();
            varB4EAC82CA7396A68D541C85D26508E83_1923204164 = new HashMap<String, Object>(mMap);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1923204164.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1923204164;
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.492 -0400", hash_original_method = "4363C372EF13513A221D5D74A24EBA33", hash_generated_method = "4C87EB891E9837CD5A51ED72F45209B1")
    public String getString(String key, String defValue) {
        String varB4EAC82CA7396A68D541C85D26508E83_585088121 = null; 
        {
            awaitLoadedLocked();
            String v = (String)mMap.get(key);
            varB4EAC82CA7396A68D541C85D26508E83_585088121 = v != null ? v : defValue;
        } 
        addTaint(key.getTaint());
        addTaint(defValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_585088121.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_585088121;
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.494 -0400", hash_original_method = "66BFB743F0303E06F65F01D81F24C82B", hash_generated_method = "835BCB9307CC317BBC82E785F7344D8A")
    public Set<String> getStringSet(String key, Set<String> defValues) {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1007064122 = null; 
        {
            awaitLoadedLocked();
            Set<String> v = (Set<String>) mMap.get(key);
            varB4EAC82CA7396A68D541C85D26508E83_1007064122 = v != null ? v : defValues;
        } 
        addTaint(key.getTaint());
        addTaint(defValues.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1007064122.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1007064122;
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.495 -0400", hash_original_method = "ACC29E9B287DA38F520685100499E9BD", hash_generated_method = "AA7696A205897F381F532A719AF5B83C")
    public int getInt(String key, int defValue) {
        {
            awaitLoadedLocked();
            Integer v = (Integer)mMap.get(key);
        } 
        addTaint(key.getTaint());
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371628121 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371628121;
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.498 -0400", hash_original_method = "44BE6AE8D3AB2ABE731A78B854B12E07", hash_generated_method = "02F1AD8BA8D91FC822369BD248FDA408")
    public long getLong(String key, long defValue) {
        {
            awaitLoadedLocked();
            Long v = (Long)mMap.get(key);
        } 
        addTaint(key.getTaint());
        addTaint(defValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_977757087 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_977757087;
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.499 -0400", hash_original_method = "E216C3CDDFA2EB08E1EA436EA866244B", hash_generated_method = "BCEEE8AE8A96B6A3A479E69A1E43F9E4")
    public float getFloat(String key, float defValue) {
        {
            awaitLoadedLocked();
            Float v = (Float)mMap.get(key);
        } 
        addTaint(key.getTaint());
        addTaint(defValue);
        float var546ADE640B6EDFBC8A086EF31347E768_247087762 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_247087762;
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.499 -0400", hash_original_method = "726255BCC2D6177085677A1712342F0B", hash_generated_method = "8A32A71F9FC6BA65EEE13D4AFE07CD09")
    public boolean getBoolean(String key, boolean defValue) {
        {
            awaitLoadedLocked();
            Boolean v = (Boolean)mMap.get(key);
        } 
        addTaint(key.getTaint());
        addTaint(defValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_323761290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_323761290;
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.500 -0400", hash_original_method = "62FFF74487B278708D1160DE5B5FB2C0", hash_generated_method = "B5EAB642902421BAF22589EB8EA95BF3")
    public boolean contains(String key) {
        {
            awaitLoadedLocked();
            boolean varBC7DFBFAB8E0EAD217132FDF3CCDDF3E_225568808 = (mMap.containsKey(key));
        } 
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806022749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_806022749;
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.501 -0400", hash_original_method = "4D22F9B98CC44B257DB4ED7BF7E423CC", hash_generated_method = "875B0C724A7027AC96541D7A37F11C73")
    public Editor edit() {
        Editor varB4EAC82CA7396A68D541C85D26508E83_1688770651 = null; 
        {
            awaitLoadedLocked();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1688770651 = new EditorImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1688770651.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1688770651;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.502 -0400", hash_original_method = "4AFBAD62741BB9BDCEF60806B476332B", hash_generated_method = "F65FD8039619DE912159789F942A356B")
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
        {
            boolean wasEmpty = false;
            {
                Object var232E05A46CB4C244745CD03ED44CEBDA_445930101 = (SharedPreferencesImpl.this);
                {
                    wasEmpty = mDiskWritesInFlight == 1;
                } 
            } 
            {
                writeToDiskRunnable.run();
            } 
        } 
        QueuedWork.singleThreadExecutor().execute(writeToDiskRunnable);
        addTaint(mcr.getTaint());
        addTaint(postWriteRunnable.getTaint());
        
        
    }

    
        @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.504 -0400", hash_original_method = "2845FAF740EE3AE38D64734030124734", hash_generated_method = "D80E710C2F1AD201DC6E49644E1886C3")
    private void writeToFile(MemoryCommitResult mcr) {
        {
            boolean var41D133D77C4B3BDDC7C7FBBBF4C95E6E_1947204895 = (mFile.exists());
            {
                {
                    mcr.setDiskWriteResult(true);
                } 
                {
                    boolean var8752700CBD0D95D9BA93EA4EAF6E4584_1079995390 = (!mBackupFile.exists());
                    {
                        {
                            boolean var97E99B42A4C3EF9AD06C1BE92A8A0125_2024436519 = (!mFile.renameTo(mBackupFile));
                            {
                                mcr.setDiskWriteResult(false);
                            } 
                        } 
                    } 
                    {
                        mFile.delete();
                    } 
                } 
            } 
        } 
        try 
        {
            FileOutputStream str = createFileOutputStream(mFile);
            {
                mcr.setDiskWriteResult(false);
            } 
            XmlUtils.writeMapXml(mcr.mapToWriteToDisk, str);
            FileUtils.sync(str);
            str.close();
            ContextImpl.setFilePermissionsFromMode(mFile.getPath(), mMode, 0);
            FileStatus stat = new FileStatus();
            {
                boolean varFC8A9325D409852FB2BC7AA91339B9F1_1994631203 = (FileUtils.getFileStatus(mFile.getPath(), stat));
                {
                    {
                        mStatTimestamp = stat.mtime;
                        mStatSize = stat.size;
                    } 
                } 
            } 
            mBackupFile.delete();
            mcr.setDiskWriteResult(true);
        } 
        catch (XmlPullParserException e)
        { }
        catch (IOException e)
        { }
        {
            boolean var41D133D77C4B3BDDC7C7FBBBF4C95E6E_425232174 = (mFile.exists());
            {
                {
                    boolean var8D9FAE26A4E65BB2FC5E55BBC862BDCF_1425802606 = (!mFile.delete());
                } 
            } 
        } 
        mcr.setDiskWriteResult(false);
        addTaint(mcr.getTaint());
        
        
    }

    
    private static class MemoryCommitResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.505 -0400", hash_original_field = "D95BD0518BB4F43B535228C63C0E9529", hash_generated_field = "847375890450F151D556659ED58991B9")

        public boolean changesMade;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.505 -0400", hash_original_field = "E057A2283FA415AE4F5DE3F903192B58", hash_generated_field = "2EE2DFA90D3D2D3F9516D4CD5FDE4122")

        public List<String> keysModified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.505 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "D2E9E84BD48FF6DFF6D2BC37523716C3")

        public Set<OnSharedPreferenceChangeListener> listeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.505 -0400", hash_original_field = "63B9355E30BB36B123935E6270708B82", hash_generated_field = "143E2DEB766BC6AA285B54EE395A1A59")

        public Map<?, ?> mapToWriteToDisk;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.505 -0400", hash_original_field = "3C622B5F3AE156A00C4DA8B3E89B016C", hash_generated_field = "61E1E794F9CE659EAE912D429A24AAF8")

        public final CountDownLatch writtenToDiskLatch = new CountDownLatch(1);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.505 -0400", hash_original_field = "69DAF4DA3C593998196593AA2703C4E5", hash_generated_field = "94D38FC27B034675B74D4377E55C9971")

        public volatile boolean writeToDiskResult = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.505 -0400", hash_original_method = "1F3E23CA54BAEE886A8B49EA267FA6D4", hash_generated_method = "1F3E23CA54BAEE886A8B49EA267FA6D4")
        public MemoryCommitResult ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.507 -0400", hash_original_method = "152989348B1D3907F6F06DB9CE213C64", hash_generated_method = "42EC6758C9478DCC3AFC3B660B4B2855")
        public void setDiskWriteResult(boolean result) {
            writeToDiskResult = result;
            writtenToDiskLatch.countDown();
            
            
            
        }

        
    }


    
    public final class EditorImpl implements Editor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.507 -0400", hash_original_field = "A130CB8A78801D9647C2A4F78DD86FAE", hash_generated_field = "EAED15AFA724D9B204324BD6499C436E")

        private final Map<String, Object> mModified = Maps.newHashMap();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.507 -0400", hash_original_field = "8FC1E08A5AA0AC830CDEAE8C011940A3", hash_generated_field = "67418A00EF4F0B8868F3E7D11AB465BE")

        private boolean mClear = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.507 -0400", hash_original_method = "068A863F3588C3FB3F228BFE7DE0FB01", hash_generated_method = "068A863F3588C3FB3F228BFE7DE0FB01")
        public EditorImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.508 -0400", hash_original_method = "EFFD7B235C5590A6C15EA464602A0862", hash_generated_method = "CA55D8B17E134530991968AA7E928234")
        public Editor putString(String key, String value) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_196410739 = null; 
            {
                mModified.put(key, value);
                varB4EAC82CA7396A68D541C85D26508E83_196410739 = this;
            } 
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_196410739.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_196410739;
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.510 -0400", hash_original_method = "799426C68EE59A97CAF3D6E033ED6AED", hash_generated_method = "E5F0DBB66ECBB2902F4E95EC76728BD0")
        public Editor putStringSet(String key, Set<String> values) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_233445183 = null; 
            {
                mModified.put(key, values);
                varB4EAC82CA7396A68D541C85D26508E83_233445183 = this;
            } 
            addTaint(key.getTaint());
            addTaint(values.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_233445183.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_233445183;
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.511 -0400", hash_original_method = "B5181352BC82403801755A11BC05DCE9", hash_generated_method = "A3FF1CF2A7750992051F89FDD4B8B961")
        public Editor putInt(String key, int value) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_1090673620 = null; 
            {
                mModified.put(key, value);
                varB4EAC82CA7396A68D541C85D26508E83_1090673620 = this;
            } 
            addTaint(key.getTaint());
            addTaint(value);
            varB4EAC82CA7396A68D541C85D26508E83_1090673620.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1090673620;
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.512 -0400", hash_original_method = "2390F394A779B486378B9C93DB0AC773", hash_generated_method = "965B961DB1EBDB778DA452354C3822C2")
        public Editor putLong(String key, long value) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_715082413 = null; 
            {
                mModified.put(key, value);
                varB4EAC82CA7396A68D541C85D26508E83_715082413 = this;
            } 
            addTaint(key.getTaint());
            addTaint(value);
            varB4EAC82CA7396A68D541C85D26508E83_715082413.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_715082413;
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.513 -0400", hash_original_method = "913478FEA634AAED5778EE46C57EEF5E", hash_generated_method = "4A8E478ED422B1209ADE519967FED5B6")
        public Editor putFloat(String key, float value) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_674076844 = null; 
            {
                mModified.put(key, value);
                varB4EAC82CA7396A68D541C85D26508E83_674076844 = this;
            } 
            addTaint(key.getTaint());
            addTaint(value);
            varB4EAC82CA7396A68D541C85D26508E83_674076844.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_674076844;
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.514 -0400", hash_original_method = "FBC14C4FFFA5A0EBC88C6D503172C819", hash_generated_method = "75B41F10815A7FA4562AC91E9A7D2ACF")
        public Editor putBoolean(String key, boolean value) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_766505592 = null; 
            {
                mModified.put(key, value);
                varB4EAC82CA7396A68D541C85D26508E83_766505592 = this;
            } 
            addTaint(key.getTaint());
            addTaint(value);
            varB4EAC82CA7396A68D541C85D26508E83_766505592.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_766505592;
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.516 -0400", hash_original_method = "7C60C1DCB4FF55A3B2BA6A50F523FE33", hash_generated_method = "D71601405B5DDD45510CFC7EE25700A8")
        public Editor remove(String key) {
            Editor varB4EAC82CA7396A68D541C85D26508E83_1442835064 = null; 
            {
                mModified.put(key, this);
                varB4EAC82CA7396A68D541C85D26508E83_1442835064 = this;
            } 
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1442835064.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1442835064;
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.518 -0400", hash_original_method = "59F9BBF7AADFDAE77F62CA904307DAB9", hash_generated_method = "3539C733C5515581CB81DCA4AF612E7D")
        public Editor clear() {
            Editor varB4EAC82CA7396A68D541C85D26508E83_1968146096 = null; 
            {
                mClear = true;
                varB4EAC82CA7396A68D541C85D26508E83_1968146096 = this;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1968146096.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1968146096;
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.905 -0400", hash_original_method = "874FED7345E8B1C9E07FEF0510B9D798", hash_generated_method = "BFCA20DC6902321268BE1A072C0F913B")
        public void apply() {
            final MemoryCommitResult mcr;
            mcr = commitToMemory();
            final Runnable awaitCommit;
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
            
            
            
                    
                        
                            
                        
                        
                    
                
            
            
                    
                        
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.523 -0400", hash_original_method = "686A9AF4CEF5EAEBEB20BB8BD072C7B7", hash_generated_method = "175B925E15942B4845A8684A6AA90C55")
        private MemoryCommitResult commitToMemory() {
            MemoryCommitResult varB4EAC82CA7396A68D541C85D26508E83_46161598 = null; 
            MemoryCommitResult mcr = new MemoryCommitResult();
            {
                Object var232E05A46CB4C244745CD03ED44CEBDA_195102297 = (SharedPreferencesImpl.this);
                {
                    {
                        mMap = new HashMap<String, Object>(mMap);
                    } 
                    mcr.mapToWriteToDisk = mMap;
                    boolean hasListeners = mListeners.size() > 0;
                    {
                        mcr.keysModified = new ArrayList<String>();
                        mcr.listeners =
                            new HashSet<OnSharedPreferenceChangeListener>(mListeners.keySet());
                    } 
                    {
                        {
                            {
                                boolean var8C6FF294AFEFAD057AE1B35F44B10299_1609501391 = (!mMap.isEmpty());
                                {
                                    mcr.changesMade = true;
                                    mMap.clear();
                                } 
                            } 
                            mClear = false;
                        } 
                        {
                            Iterator<Map.Entry<String, Object>> varF82C588A08B6DF5CE4ADFA834C909247_1910057467 = (mModified.entrySet()).iterator();
                            varF82C588A08B6DF5CE4ADFA834C909247_1910057467.hasNext();
                            Map.Entry<String, Object> e = varF82C588A08B6DF5CE4ADFA834C909247_1910057467.next();
                            {
                                String k = e.getKey();
                                Object v = e.getValue();
                                {
                                    boolean var7481F5BED4B812C399339F0465352930_1049061941 = (v == this);
                                    {
                                        {
                                            boolean varCB62A03BC7382484A4D8527AC1D5B67C_843951285 = (!mMap.containsKey(k));
                                        } 
                                        mMap.remove(k);
                                    } 
                                    {
                                        boolean isSame = false;
                                        {
                                            boolean var1476C62562F740B1204AB200EEE2D273_1577767108 = (mMap.containsKey(k));
                                            {
                                                Object existingValue = mMap.get(k);
                                                {
                                                    boolean var3F40C0122B4BFCB85951F0CA9C389424_485153183 = (existingValue != null && existingValue.equals(v));
                                                } 
                                            } 
                                        } 
                                        mMap.put(k, v);
                                    } 
                                } 
                                mcr.changesMade = true;
                                {
                                    mcr.keysModified.add(k);
                                } 
                            } 
                        } 
                        mModified.clear();
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_46161598 = mcr;
            varB4EAC82CA7396A68D541C85D26508E83_46161598.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_46161598;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.523 -0400", hash_original_method = "23D73852609E646C4CF9B990F4BA7C23", hash_generated_method = "408EDAAFF7B7262A481E25CD6F2BD9EA")
        public boolean commit() {
            MemoryCommitResult mcr = commitToMemory();
            SharedPreferencesImpl.this.enqueueDiskWrite(
                mcr, null );
            try 
            {
                mcr.writtenToDiskLatch.await();
            } 
            catch (InterruptedException e)
            { }
            notifyListeners(mcr);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535896765 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535896765;
            
            
            
                
            
                
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.529 -0400", hash_original_method = "9C764C33950FD36589194E2D3CE4E56B", hash_generated_method = "343BBEC293E769A7D6EC210AD91A867E")
        private void notifyListeners(final MemoryCommitResult mcr) {
            {
                boolean var98EE468E1F91A5EC4E053BA5E9799A53_113903210 = (mcr.listeners == null || mcr.keysModified == null ||
                mcr.keysModified.size() == 0);
            } 
            {
                boolean var748E4843A4DFD33AE33247B092F762F7_1658833822 = (Looper.myLooper() == Looper.getMainLooper());
                {
                    {
                        int i = mcr.keysModified.size() - 1;
                        {
                            final String key = mcr.keysModified.get(i);
                            {
                                Iterator<OnSharedPreferenceChangeListener> var66C8E5D21325C7C68FB016F2A231877B_1940239756 = (mcr.listeners).iterator();
                                var66C8E5D21325C7C68FB016F2A231877B_1940239756.hasNext();
                                OnSharedPreferenceChangeListener listener = var66C8E5D21325C7C68FB016F2A231877B_1940239756.next();
                                {
                                    {
                                        listener.onSharedPreferenceChanged(SharedPreferencesImpl.this, key);
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    ActivityThread.sMainThreadHandler.post(new Runnable() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.529 -0400", hash_original_method = "ADA4A7900A87A83172528D6D189EF104", hash_generated_method = "0CB8C5BDC799C735934697841D29C178")
                        public void run() {
                            notifyListeners(mcr);
                            
                            
                        }
});
                } 
            } 
            addTaint(mcr.getTaint());
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.529 -0400", hash_original_field = "E76DDC92A085F8DE2EE56A6A1496F8A9", hash_generated_field = "FD6664AF36DA0DBF0E6B2E44D4BD8BF3")

    private static final String TAG = "SharedPreferencesImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.529 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.529 -0400", hash_original_field = "03EAB6F64D45D96F1A944CA041405FE8", hash_generated_field = "7CDB17D961908C044A3FCB6E47815B53")

    private static final Object mContent = new Object();
}

