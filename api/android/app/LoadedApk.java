package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.util.ArrayUtils;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AndroidRuntimeException;
import android.util.Slog;
import android.view.CompatibilityInfoHolder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

final class IntentReceiverLeaked extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.862 -0400", hash_original_method = "2DDF58935C7979F8233E5799714A3344", hash_generated_method = "2D90666CDB904595A088613D73CD4BDC")
    public  IntentReceiverLeaked(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
}

final class ServiceConnectionLeaked extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.862 -0400", hash_original_method = "3AC977BF0FF33C844B89CE3E7B08E19C", hash_generated_method = "65E305FF59472EE68A50A3CDAE68EFDA")
    public  ServiceConnectionLeaked(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
}

public final class LoadedApk {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.863 -0400", hash_original_field = "7EF90D5DA2994166B5492D71C1F03D41", hash_generated_field = "421BA2E15FA30D31BA5B63CB3A7B5B13")

    private ActivityThread mActivityThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.863 -0400", hash_original_field = "FD5C5E6825DA9870EAF09E3E93BBC5CA", hash_generated_field = "03043EB7A9D0FD1622717AEEB39E2C26")

    private ApplicationInfo mApplicationInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.863 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "7A5990DF4A54BF373C395B6501E20B02")

    String mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.864 -0400", hash_original_field = "4430148E41DA41FA63D06B1F2F0DF4E3", hash_generated_field = "E0A59288CBEC7FD799E8A337FACE1F5E")

    private String mAppDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.864 -0400", hash_original_field = "E6DEC81428C06CF3161B8FA0C4811101", hash_generated_field = "16A785049F12D1DFDF4F72387E1D9EFB")

    private String mResDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.864 -0400", hash_original_field = "C117FBB6B79E7E776A4691698BA58C54", hash_generated_field = "8FC8150480070F32937BA43631A0368E")

    private String[] mSharedLibraries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.864 -0400", hash_original_field = "7EDD3603F4A49D77EFA6EF705BD18DF5", hash_generated_field = "DA139898E558B5B558E8C0728494F629")

    private String mDataDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.864 -0400", hash_original_field = "EEC20EB7601ED7059BDD67D9CE6A5B06", hash_generated_field = "3DFB074D570DEA75E2F80D915A677796")

    private String mLibDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.864 -0400", hash_original_field = "E45B97D91F5B155EB8E33E2A4C73F43D", hash_generated_field = "6E40F983F9A90BA373BA4515E458568D")

    private File mDataDirFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.864 -0400", hash_original_field = "73686947E3EA370F12F24CB3BF845356", hash_generated_field = "DED5F167DA7D663ADC06A3550A4D7EA7")

    private ClassLoader mBaseClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.864 -0400", hash_original_field = "8CEAB0F22F050DB955C3D34D83B18CF2", hash_generated_field = "CCA7497D7EA5CC4EF77C1D70975F7273")

    private boolean mSecurityViolation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.864 -0400", hash_original_field = "0AE379AEE58DD7E01F47632047310B41", hash_generated_field = "35E5468E0019AD697E9AE711BEDB4638")

    private boolean mIncludeCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.865 -0400", hash_original_field = "F2B407E6A674EC5D91ECDEF6913CCBF8", hash_generated_field = "EDE7B5DFCD04834664F3F3E07C36CD7D")

    public final CompatibilityInfoHolder mCompatibilityInfo = new CompatibilityInfoHolder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.865 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8C221FB485568FEFC5ABDDF092AD743A")

    Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.865 -0400", hash_original_field = "334890635C1887AB66991B9374637EE6", hash_generated_field = "ABE17DFC947454E8F85FE66E61741F7A")

    private ClassLoader mClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.865 -0400", hash_original_field = "6B35E9B21496C1A77A324DB1577A6395", hash_generated_field = "53FA3553B85F7414D1C5F2C302FDEBF9")

    private Application mApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.865 -0400", hash_original_field = "32343F2FD91BBD33319B51ECF48DE3D1", hash_generated_field = "DA02F0E61096FE1235CD218F7663F0B5")

    private final HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>> mReceivers = new HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.865 -0400", hash_original_field = "D4D722C0A6B3FAC031635D0675FC8349", hash_generated_field = "351CD2B4585AE8D79380314A857D1433")

    private final HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>> mUnregisteredReceivers = new HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.865 -0400", hash_original_field = "EB07C26EFE0C2DDE3B9FFEE930D390FA", hash_generated_field = "1A0B5F333B7A8966A134CAF8AFAB489A")

    private final HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>> mServices = new HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.865 -0400", hash_original_field = "4C666CC89FDEF6BB184BFAB3DAEFC4F2", hash_generated_field = "86703A535EA1DE3F2DA9098AD90EB1AC")

    private final HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>> mUnboundServices = new HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.865 -0400", hash_original_field = "60D2FD238F0B065CED80605287080AEE", hash_generated_field = "5AEC4BBC7EEA13395C3D634E331479A9")

    int mClientCount = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.869 -0400", hash_original_method = "B0521F2A8F8912484DABAF70EB52FE24", hash_generated_method = "47ED539A6A4A48DDDFAF9A0FD9D1728C")
    public  LoadedApk(ActivityThread activityThread, ApplicationInfo aInfo,
            CompatibilityInfo compatInfo,
            ActivityThread mainThread, ClassLoader baseLoader,
            boolean securityViolation, boolean includeCode) {
        addTaint(mainThread.getTaint());
        addTaint(compatInfo.getTaint());
        mActivityThread = activityThread;
        mApplicationInfo = aInfo;
        mPackageName = aInfo.packageName;
        mAppDir = aInfo.sourceDir;
        mResDir = aInfo.uid == Process.myUid() ? aInfo.sourceDir
                : aInfo.publicSourceDir;
        mSharedLibraries = aInfo.sharedLibraryFiles;
        mDataDir = aInfo.dataDir;
        mDataDirFile = mDataDir != null ? new File(mDataDir) : null;
        mLibDir = aInfo.nativeLibraryDir;
        mBaseClassLoader = baseLoader;
        mSecurityViolation = securityViolation;
        mIncludeCode = includeCode;
        mCompatibilityInfo.set(compatInfo);
    if(mAppDir == null)        
        {
    if(ActivityThread.mSystemContext == null)            
            {
                ActivityThread.mSystemContext =
                    ContextImpl.createSystemContext(mainThread);
                ActivityThread.mSystemContext.getResources().updateConfiguration(
                         mainThread.getConfiguration(),
                         mainThread.getDisplayMetricsLocked(compatInfo, false),
                         compatInfo);
            } 
            mClassLoader = ActivityThread.mSystemContext.getClassLoader();
            mResources = ActivityThread.mSystemContext.getResources();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.872 -0400", hash_original_method = "208133E4566B7220D9D6A07C20B811D8", hash_generated_method = "FA4A7D8F84ED65767BD55F52D0D099F5")
    public  LoadedApk(ActivityThread activityThread, String name,
            Context systemContext, ApplicationInfo info, CompatibilityInfo compatInfo) {
        addTaint(compatInfo.getTaint());
        mActivityThread = activityThread;
        mApplicationInfo = info != null ? info : new ApplicationInfo();
        mApplicationInfo.packageName = name;
        mPackageName = name;
        mAppDir = null;
        mResDir = null;
        mSharedLibraries = null;
        mDataDir = null;
        mDataDirFile = null;
        mLibDir = null;
        mBaseClassLoader = null;
        mSecurityViolation = false;
        mIncludeCode = true;
        mClassLoader = systemContext.getClassLoader();
        mResources = systemContext.getResources();
        mCompatibilityInfo.set(compatInfo);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.872 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "1672FCC1042A26F0C2EA44781CA9BC8D")
     Application getApplication() {
Application varF254F0ADF054F0318B65674CA3670A5E_116889036 =         mApplication;
        varF254F0ADF054F0318B65674CA3670A5E_116889036.addTaint(taint);
        return varF254F0ADF054F0318B65674CA3670A5E_116889036;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.873 -0400", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "03D5D85FC397F0EC5FD0C937DD5F8CDE")
    public String getPackageName() {
String var5601F77C1E784C31FA233AB799182FA6_303505447 =         mPackageName;
        var5601F77C1E784C31FA233AB799182FA6_303505447.addTaint(taint);
        return var5601F77C1E784C31FA233AB799182FA6_303505447;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.873 -0400", hash_original_method = "69D4795DAE5563DBA773DE992713BBC9", hash_generated_method = "8A0160EB6119B97A8A72B3832CF7D339")
    public ApplicationInfo getApplicationInfo() {
ApplicationInfo var7A6C13D6B64BE4CFA903FB80708E9465_1550338644 =         mApplicationInfo;
        var7A6C13D6B64BE4CFA903FB80708E9465_1550338644.addTaint(taint);
        return var7A6C13D6B64BE4CFA903FB80708E9465_1550338644;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.873 -0400", hash_original_method = "1023CFFB5794A83B41C0A52D163AA3AF", hash_generated_method = "2BCC727DCFA42BCD1C0E5C0D8ED0114B")
    public boolean isSecurityViolation() {
        boolean var8CEAB0F22F050DB955C3D34D83B18CF2_1704102029 = (mSecurityViolation);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_438951301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_438951301;
        
        
    }

    
        private static String[] getLibrariesFor(String packageName) {
        ApplicationInfo ai = null;
        try {
            ai = ActivityThread.getPackageManager().getApplicationInfo(packageName,
                    PackageManager.GET_SHARED_LIBRARY_FILES);
        } catch (RemoteException e) {
            throw new AssertionError(e);
        }
        if (ai == null) {
            return null;
        }
        return ai.sharedLibraryFiles;
    }

    
        private static String combineLibs(String[] list1, String[] list2) {
        StringBuilder result = new StringBuilder(300);
        boolean first = true;
        if (list1 != null) {
            for (String s : list1) {
                if (first) {
                    first = false;
                } else {
                    result.append(':');
                }
                result.append(s);
            }
        }
        boolean dupCheck = !first;
        if (list2 != null) {
            for (String s : list2) {
                if (dupCheck && ArrayUtils.contains(list1, s)) {
                    continue;
                }
                if (first) {
                    first = false;
                } else {
                    result.append(':');
                }
                result.append(s);
            }
        }
        return result.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.876 -0400", hash_original_method = "98BA13F46ABDF03C557DAF40D6E3FC88", hash_generated_method = "D35D5AEAE35B54B8EDE16F78651470BF")
    public ClassLoader getClassLoader() {
        synchronized
(this)        {
    if(mClassLoader != null)            
            {
ClassLoader var03260047576FFCA5A37C413ABA8D1CD1_1001328110 =                 mClassLoader;
                var03260047576FFCA5A37C413ABA8D1CD1_1001328110.addTaint(taint);
                return var03260047576FFCA5A37C413ABA8D1CD1_1001328110;
            } 
    if(mIncludeCode && !mPackageName.equals("android"))            
            {
                String zip = mAppDir;
                String instrumentationAppDir = mActivityThread.mInstrumentationAppDir;
                String instrumentationAppPackage = mActivityThread.mInstrumentationAppPackage;
                String instrumentedAppDir = mActivityThread.mInstrumentedAppDir;
                String[] instrumentationLibs = null;
    if(mAppDir.equals(instrumentationAppDir)
                        || mAppDir.equals(instrumentedAppDir))                
                {
                    zip = instrumentationAppDir + ":" + instrumentedAppDir;
    if(! instrumentedAppDir.equals(instrumentationAppDir))                    
                    {
                        instrumentationLibs =
                            getLibrariesFor(instrumentationAppPackage);
                    } 
                } 
    if((mSharedLibraries != null) ||
                        (instrumentationLibs != null))                
                {
                    zip =
                        combineLibs(mSharedLibraries, instrumentationLibs)
                        + ':' + zip;
                } 
    if(ActivityThread.localLOGV){ }                StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
                mClassLoader =
                    ApplicationLoaders.getDefault().getClassLoader(
                        zip, mLibDir, mBaseClassLoader);
                initializeJavaContextClassLoader();
                StrictMode.setThreadPolicy(oldPolicy);
            } 
            else
            {
    if(mBaseClassLoader == null)                
                {
                    mClassLoader = ClassLoader.getSystemClassLoader();
                } 
                else
                {
                    mClassLoader = mBaseClassLoader;
                } 
            } 
ClassLoader var03260047576FFCA5A37C413ABA8D1CD1_1513152019 =             mClassLoader;
            var03260047576FFCA5A37C413ABA8D1CD1_1513152019.addTaint(taint);
            return var03260047576FFCA5A37C413ABA8D1CD1_1513152019;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.876 -0400", hash_original_method = "56AE7DDBC8B1739A2C59C89AA12BEB96", hash_generated_method = "8648D797D8A856BA5EB3B7C372CFF1A6")
    private void initializeJavaContextClassLoader() {
        IPackageManager pm = ActivityThread.getPackageManager();
        android.content.pm.PackageInfo pi;
        try 
        {
            pi = pm.getPackageInfo(mPackageName, 0);
        } 
        catch (RemoteException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_279210219 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_279210219.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_279210219;
        } 
        boolean sharedUserIdSet = (pi.sharedUserId != null);
        boolean processNameNotDefault = (pi.applicationInfo != null &&
             !mPackageName.equals(pi.applicationInfo.processName));
        boolean sharable = (sharedUserIdSet || processNameNotDefault);
        ClassLoader contextClassLoader = (sharable)
            ? new WarningContextClassLoader()
            : mClassLoader;
        Thread.currentThread().setContextClassLoader(contextClassLoader);
        
        
        
        
            
        
            
        
        
        
            
             
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.876 -0400", hash_original_method = "DDE558C6C52D26591497F8CCA19E2D11", hash_generated_method = "00654093BD681516A99A9F4CEC785A9F")
    public String getAppDir() {
String var181BC6EF4E240BFA6FBED8BF1ADFB867_1477973049 =         mAppDir;
        var181BC6EF4E240BFA6FBED8BF1ADFB867_1477973049.addTaint(taint);
        return var181BC6EF4E240BFA6FBED8BF1ADFB867_1477973049;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.877 -0400", hash_original_method = "1158BD50BBC4E4D9C9B8EC24E43A83EF", hash_generated_method = "F3A4CD1375CA64FC463F1D28A6B3985A")
    public String getResDir() {
String var679D8BF02D40F53F6FB1455151813483_1290403418 =         mResDir;
        var679D8BF02D40F53F6FB1455151813483_1290403418.addTaint(taint);
        return var679D8BF02D40F53F6FB1455151813483_1290403418;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.877 -0400", hash_original_method = "5486D8CB07A0A494A33FE28373C3B14E", hash_generated_method = "DC79F1C177B4B9E3BD1CCC83EBD7D568")
    public String getDataDir() {
String varF2DB52033E7B675C5416BA563C248BCF_124313556 =         mDataDir;
        varF2DB52033E7B675C5416BA563C248BCF_124313556.addTaint(taint);
        return varF2DB52033E7B675C5416BA563C248BCF_124313556;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.877 -0400", hash_original_method = "6FB19B7083E51C6FD4891C3DDE1600A5", hash_generated_method = "6786028A3795CB3CB163ED9F6E2BE212")
    public File getDataDirFile() {
File var0F0E3AAC4D6C65AF3E62DA78DF7E2DFD_1196656567 =         mDataDirFile;
        var0F0E3AAC4D6C65AF3E62DA78DF7E2DFD_1196656567.addTaint(taint);
        return var0F0E3AAC4D6C65AF3E62DA78DF7E2DFD_1196656567;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.878 -0400", hash_original_method = "57B8CB1A3B484849D2245AC420407E2C", hash_generated_method = "7F0921BE557C870FF0AA4F6072A15E33")
    public AssetManager getAssets(ActivityThread mainThread) {
        addTaint(mainThread.getTaint());
AssetManager varA9B93526AA04C0D8699A4F14705F1CA1_988820978 =         getResources(mainThread).getAssets();
        varA9B93526AA04C0D8699A4F14705F1CA1_988820978.addTaint(taint);
        return varA9B93526AA04C0D8699A4F14705F1CA1_988820978;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.878 -0400", hash_original_method = "5E7B55611C44695241E7EB924E051C95", hash_generated_method = "2FA3108467BBCD43E6CE65EA7E24F235")
    public Resources getResources(ActivityThread mainThread) {
    if(mResources == null)        
        {
            mResources = mainThread.getTopLevelResources(mResDir, this);
        } 
Resources var346B953D96D762F7FED561E83C1656CA_1700485059 =         mResources;
        var346B953D96D762F7FED561E83C1656CA_1700485059.addTaint(taint);
        return var346B953D96D762F7FED561E83C1656CA_1700485059;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.880 -0400", hash_original_method = "F09CA6154241A46EB02B7FA7F64D8F80", hash_generated_method = "40A3EFF117B6C12202F81938B80D7D6C")
    public Application makeApplication(boolean forceDefaultAppClass,
            Instrumentation instrumentation) {
        addTaint(instrumentation.getTaint());
        addTaint(forceDefaultAppClass);
    if(mApplication != null)        
        {
Application varF254F0ADF054F0318B65674CA3670A5E_750396751 =             mApplication;
            varF254F0ADF054F0318B65674CA3670A5E_750396751.addTaint(taint);
            return varF254F0ADF054F0318B65674CA3670A5E_750396751;
        } 
        Application app = null;
        String appClass = mApplicationInfo.className;
    if(forceDefaultAppClass || (appClass == null))        
        {
            appClass = "android.app.Application";
        } 
        try 
        {
            java.lang.ClassLoader cl = getClassLoader();
            ContextImpl appContext = new ContextImpl();
            appContext.init(this, null, mActivityThread);
            app = mActivityThread.mInstrumentation.newApplication(
                    cl, appClass, appContext);
            appContext.setOuterContext(app);
        } 
        catch (Exception e)
        {
    if(!mActivityThread.mInstrumentation.onException(app, e))            
            {
                RuntimeException var3B25207813A80E689E99D3B3114B341F_1399376963 = new RuntimeException(
                    "Unable to instantiate application " + appClass
                    + ": " + e.toString(), e);
                var3B25207813A80E689E99D3B3114B341F_1399376963.addTaint(taint);
                throw var3B25207813A80E689E99D3B3114B341F_1399376963;
            } 
        } 
        mActivityThread.mAllApplications.add(app);
        mApplication = app;
    if(instrumentation != null)        
        {
            try 
            {
                instrumentation.callApplicationOnCreate(app);
            } 
            catch (Exception e)
            {
    if(!instrumentation.onException(app, e))                
                {
                    RuntimeException varADC9641D2DD7F467934A79889D69CEE2_1463493643 = new RuntimeException(
                        "Unable to create application " + app.getClass().getName()
                        + ": " + e.toString(), e);
                    varADC9641D2DD7F467934A79889D69CEE2_1463493643.addTaint(taint);
                    throw varADC9641D2DD7F467934A79889D69CEE2_1463493643;
                } 
            } 
        } 
Application varBE0936E6D817E83D57F0B07BD06C3D1F_483165870 =         app;
        varBE0936E6D817E83D57F0B07BD06C3D1F_483165870.addTaint(taint);
        return varBE0936E6D817E83D57F0B07BD06C3D1F_483165870;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.882 -0400", hash_original_method = "B6291AD2FF4D11DEB13067F1AF687A9F", hash_generated_method = "F6249D7408069BA46AAB3A4261515B76")
    public void removeContextRegistrations(Context context,
            String who, String what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        addTaint(context.getTaint());
        HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> rmap = mReceivers.remove(context);
    if(rmap != null)        
        {
            Iterator<LoadedApk.ReceiverDispatcher> it = rmap.values().iterator();
            while
(it.hasNext())            
            {
                LoadedApk.ReceiverDispatcher rd = it.next();
                IntentReceiverLeaked leak = new IntentReceiverLeaked(
                        what + " " + who + " has leaked IntentReceiver "
                        + rd.getIntentReceiver() + " that was " +
                        "originally registered here. Are you missing a " +
                        "call to unregisterReceiver()?");
                leak.setStackTrace(rd.getLocation().getStackTrace());
                try 
                {
                    ActivityManagerNative.getDefault().unregisterReceiver(
                            rd.getIIntentReceiver());
                } 
                catch (RemoteException e)
                {
                } 
            } 
        } 
        mUnregisteredReceivers.remove(context);
        HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> smap = mServices.remove(context);
    if(smap != null)        
        {
            Iterator<LoadedApk.ServiceDispatcher> it = smap.values().iterator();
            while
(it.hasNext())            
            {
                LoadedApk.ServiceDispatcher sd = it.next();
                ServiceConnectionLeaked leak = new ServiceConnectionLeaked(
                        what + " " + who + " has leaked ServiceConnection "
                        + sd.getServiceConnection() + " that was originally bound here");
                leak.setStackTrace(sd.getLocation().getStackTrace());
                try 
                {
                    ActivityManagerNative.getDefault().unbindService(
                            sd.getIServiceConnection());
                } 
                catch (RemoteException e)
                {
                } 
                sd.doForget();
            } 
        } 
        mUnboundServices.remove(context);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.885 -0400", hash_original_method = "5954CD85EE6D69CD6AA4DB5D230A9DEB", hash_generated_method = "E41852B9207D06C75FB374DB8B0B7B12")
    public IIntentReceiver getReceiverDispatcher(BroadcastReceiver r,
            Context context, Handler handler,
            Instrumentation instrumentation, boolean registered) {
        addTaint(registered);
        addTaint(instrumentation.getTaint());
        addTaint(handler.getTaint());
        addTaint(context.getTaint());
        addTaint(r.getTaint());
        synchronized
(mReceivers)        {
            LoadedApk.ReceiverDispatcher rd = null;
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> map = null;
    if(registered)            
            {
                map = mReceivers.get(context);
    if(map != null)                
                {
                    rd = map.get(r);
                } 
            } 
    if(rd == null)            
            {
                rd = new ReceiverDispatcher(r, context, handler,
                        instrumentation, registered);
    if(registered)                
                {
    if(map == null)                    
                    {
                        map = new HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>();
                        mReceivers.put(context, map);
                    } 
                    map.put(r, rd);
                } 
            } 
            else
            {
                rd.validate(context, handler);
            } 
            rd.mForgotten = false;
IIntentReceiver varD5A94533AA11F9BD3389DB2AEB2B6E0A_1195128432 =             rd.getIIntentReceiver();
            varD5A94533AA11F9BD3389DB2AEB2B6E0A_1195128432.addTaint(taint);
            return varD5A94533AA11F9BD3389DB2AEB2B6E0A_1195128432;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.887 -0400", hash_original_method = "56318BD0308680C3BFA3A8E4B0CE4CF3", hash_generated_method = "DAAE9E4FC228705C1D71216B7428BA08")
    public IIntentReceiver forgetReceiverDispatcher(Context context,
            BroadcastReceiver r) {
        addTaint(r.getTaint());
        addTaint(context.getTaint());
        synchronized
(mReceivers)        {
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> map = mReceivers.get(context);
            LoadedApk.ReceiverDispatcher rd = null;
    if(map != null)            
            {
                rd = map.get(r);
    if(rd != null)                
                {
                    map.remove(r);
    if(map.size() == 0)                    
                    {
                        mReceivers.remove(context);
                    } 
    if(r.getDebugUnregister())                    
                    {
                        HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> holder = mUnregisteredReceivers.get(context);
    if(holder == null)                        
                        {
                            holder = new HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>();
                            mUnregisteredReceivers.put(context, holder);
                        } 
                        RuntimeException ex = new IllegalArgumentException(
                                "Originally unregistered here:");
                        ex.fillInStackTrace();
                        rd.setUnregisterLocation(ex);
                        holder.put(r, rd);
                    } 
                    rd.mForgotten = true;
IIntentReceiver varD5A94533AA11F9BD3389DB2AEB2B6E0A_1269952794 =                     rd.getIIntentReceiver();
                    varD5A94533AA11F9BD3389DB2AEB2B6E0A_1269952794.addTaint(taint);
                    return varD5A94533AA11F9BD3389DB2AEB2B6E0A_1269952794;
                } 
            } 
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> holder = mUnregisteredReceivers.get(context);
    if(holder != null)            
            {
                rd = holder.get(r);
    if(rd != null)                
                {
                    RuntimeException ex = rd.getUnregisterLocation();
                    IllegalArgumentException var7F263DB8ACB8D48568B9331E4102F6E0_1830401506 = new IllegalArgumentException(
                            "Unregistering Receiver " + r
                            + " that was already unregistered", ex);
                    var7F263DB8ACB8D48568B9331E4102F6E0_1830401506.addTaint(taint);
                    throw var7F263DB8ACB8D48568B9331E4102F6E0_1830401506;
                } 
            } 
    if(context == null)            
            {
                IllegalStateException var00474B2F5EE84BF0384A7D2E5B32DA01_311373010 = new IllegalStateException("Unbinding Receiver " + r
                        + " from Context that is no longer in use: " + context);
                var00474B2F5EE84BF0384A7D2E5B32DA01_311373010.addTaint(taint);
                throw var00474B2F5EE84BF0384A7D2E5B32DA01_311373010;
            } 
            else
            {
                IllegalArgumentException var5DD34F77F9C0CFCA73718DD9B6E31DC2_897558657 = new IllegalArgumentException("Receiver not registered: " + r);
                var5DD34F77F9C0CFCA73718DD9B6E31DC2_897558657.addTaint(taint);
                throw var5DD34F77F9C0CFCA73718DD9B6E31DC2_897558657;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.888 -0400", hash_original_method = "D12EDE6D51B318B0614D5C86220B1198", hash_generated_method = "CAF6F23D21835C76E7B49EA49BD25123")
    public final IServiceConnection getServiceDispatcher(ServiceConnection c,
            Context context, Handler handler, int flags) {
        addTaint(flags);
        addTaint(handler.getTaint());
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        synchronized
(mServices)        {
            LoadedApk.ServiceDispatcher sd = null;
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> map = mServices.get(context);
    if(map != null)            
            {
                sd = map.get(c);
            } 
    if(sd == null)            
            {
                sd = new ServiceDispatcher(c, context, handler, flags);
    if(map == null)                
                {
                    map = new HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>();
                    mServices.put(context, map);
                } 
                map.put(c, sd);
            } 
            else
            {
                sd.validate(context, handler);
            } 
IServiceConnection varB5403F53D6FFC730CE6C14DD2D80D567_1738526623 =             sd.getIServiceConnection();
            varB5403F53D6FFC730CE6C14DD2D80D567_1738526623.addTaint(taint);
            return varB5403F53D6FFC730CE6C14DD2D80D567_1738526623;
        } 
        
        
            
            
            
                
            
            
                
                
                    
                    
                
                
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.890 -0400", hash_original_method = "6B7C147E189191AFA124ECB6DFD3C546", hash_generated_method = "5BF0002CE5291C57BE28D8BFB829565B")
    public final IServiceConnection forgetServiceDispatcher(Context context,
            ServiceConnection c) {
        addTaint(c.getTaint());
        addTaint(context.getTaint());
        synchronized
(mServices)        {
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> map = mServices.get(context);
            LoadedApk.ServiceDispatcher sd = null;
    if(map != null)            
            {
                sd = map.get(c);
    if(sd != null)                
                {
                    map.remove(c);
                    sd.doForget();
    if(map.size() == 0)                    
                    {
                        mServices.remove(context);
                    } 
    if((sd.getFlags()&Context.BIND_DEBUG_UNBIND) != 0)                    
                    {
                        HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> holder = mUnboundServices.get(context);
    if(holder == null)                        
                        {
                            holder = new HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>();
                            mUnboundServices.put(context, holder);
                        } 
                        RuntimeException ex = new IllegalArgumentException(
                                "Originally unbound here:");
                        ex.fillInStackTrace();
                        sd.setUnbindLocation(ex);
                        holder.put(c, sd);
                    } 
IServiceConnection varB5403F53D6FFC730CE6C14DD2D80D567_889321662 =                     sd.getIServiceConnection();
                    varB5403F53D6FFC730CE6C14DD2D80D567_889321662.addTaint(taint);
                    return varB5403F53D6FFC730CE6C14DD2D80D567_889321662;
                } 
            } 
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> holder = mUnboundServices.get(context);
    if(holder != null)            
            {
                sd = holder.get(c);
    if(sd != null)                
                {
                    RuntimeException ex = sd.getUnbindLocation();
                    IllegalArgumentException varFD28B592AF25E583DB19536717B514F4_2017173609 = new IllegalArgumentException(
                            "Unbinding Service " + c
                            + " that was already unbound", ex);
                    varFD28B592AF25E583DB19536717B514F4_2017173609.addTaint(taint);
                    throw varFD28B592AF25E583DB19536717B514F4_2017173609;
                } 
            } 
    if(context == null)            
            {
                IllegalStateException varEB5791341B77439E3C586168DCDCCFC7_606046464 = new IllegalStateException("Unbinding Service " + c
                        + " from Context that is no longer in use: " + context);
                varEB5791341B77439E3C586168DCDCCFC7_606046464.addTaint(taint);
                throw varEB5791341B77439E3C586168DCDCCFC7_606046464;
            } 
            else
            {
                IllegalArgumentException varBD67BB9700C15C1E46112D3D9496A6F5_190596352 = new IllegalArgumentException("Service not registered: " + c);
                varBD67BB9700C15C1E46112D3D9496A6F5_190596352.addTaint(taint);
                throw varBD67BB9700C15C1E46112D3D9496A6F5_190596352;
            } 
        } 
        
        
    }

    
    private static class WarningContextClassLoader extends ClassLoader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.891 -0400", hash_original_method = "97527CB182747C5C8FA8F44BB3951504", hash_generated_method = "97527CB182747C5C8FA8F44BB3951504")
        public WarningContextClassLoader ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.891 -0400", hash_original_method = "2B0FE526CC8E82A351FDFDA472FB968C", hash_generated_method = "D7CBB0B4652590BFB751FDDE95A2F09D")
        private void warn(String methodName) {
            addTaint(methodName.getTaint());
    if(warned)            
            {
                return;
            } 
            warned = true;
            Thread.currentThread().setContextClassLoader(getParent());
            
            
                
            
            
            
            
                  
                  
                  
                  
                  
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.897 -0400", hash_original_method = "55A2C8B568742F6DD554B2AE8E06F675", hash_generated_method = "D2D91B8BC6C18DAE66B8B1977533AB8A")
        @Override
        public URL getResource(String resName) {
            addTaint(resName.getTaint());
            warn("getResource");
URL var7C3D7459C5F00959470A40AD7397BE62_1688534516 =             getParent().getResource(resName);
            var7C3D7459C5F00959470A40AD7397BE62_1688534516.addTaint(taint);
            return var7C3D7459C5F00959470A40AD7397BE62_1688534516;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.897 -0400", hash_original_method = "7DF26E5478EB621EA7136B5331588545", hash_generated_method = "B517F5BE13B912CA2BD6AB66D3E96BFE")
        @Override
        public Enumeration<URL> getResources(String resName) throws IOException {
            addTaint(resName.getTaint());
            warn("getResources");
Enumeration<URL> var04542047AB0555D7921DE8D0AE440C17_827687344 =             getParent().getResources(resName);
            var04542047AB0555D7921DE8D0AE440C17_827687344.addTaint(taint);
            return var04542047AB0555D7921DE8D0AE440C17_827687344;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.898 -0400", hash_original_method = "43C39FB9AB0F69E37F9176951B93B129", hash_generated_method = "1C2471F49B9259A435ADAD64FB659722")
        @Override
        public InputStream getResourceAsStream(String resName) {
            addTaint(resName.getTaint());
            warn("getResourceAsStream");
InputStream var5B5DB975D90794344CA62AD4DB7340CB_1062705782 =             getParent().getResourceAsStream(resName);
            var5B5DB975D90794344CA62AD4DB7340CB_1062705782.addTaint(taint);
            return var5B5DB975D90794344CA62AD4DB7340CB_1062705782;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.898 -0400", hash_original_method = "8B4C21AC14EA436FB72A6381E557B850", hash_generated_method = "0FA28897CF92A9AE05E1309C4E7DCC38")
        @Override
        public Class<?> loadClass(String className) throws ClassNotFoundException {
            addTaint(className.getTaint());
            warn("loadClass");
Class<?> varE1970970BC5A81C617EE2028559098DF_1753225623 =             getParent().loadClass(className);
            varE1970970BC5A81C617EE2028559098DF_1753225623.addTaint(taint);
            return varE1970970BC5A81C617EE2028559098DF_1753225623;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.899 -0400", hash_original_method = "01BE45A57A3128BFD9BA3AF8CD4C6252", hash_generated_method = "62BAEB7AA08B45584831CD6722B33E78")
        @Override
        public void setClassAssertionStatus(String cname, boolean enable) {
            addTaint(enable);
            addTaint(cname.getTaint());
            warn("setClassAssertionStatus");
            getParent().setClassAssertionStatus(cname, enable);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.900 -0400", hash_original_method = "249CA030F95BF8C81AAAFF1521D1BE6E", hash_generated_method = "F82CD1B656135F392782FCC9763591E4")
        @Override
        public void setPackageAssertionStatus(String pname, boolean enable) {
            addTaint(enable);
            addTaint(pname.getTaint());
            warn("setPackageAssertionStatus");
            getParent().setPackageAssertionStatus(pname, enable);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.901 -0400", hash_original_method = "AC5504AD86A01EA0D58ADDE41ADE6649", hash_generated_method = "DF959CC50A3E8C43B385FE34A7BCC843")
        @Override
        public void setDefaultAssertionStatus(boolean enable) {
            addTaint(enable);
            warn("setDefaultAssertionStatus");
            getParent().setDefaultAssertionStatus(enable);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.901 -0400", hash_original_method = "DA3A923351AC4881D1A9879A5FDE3ACD", hash_generated_method = "08B0AD50933BEFAE2DAF57BAEB1B35D3")
        @Override
        public void clearAssertionStatus() {
            warn("clearAssertionStatus");
            getParent().clearAssertionStatus();
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.901 -0400", hash_original_field = "6340A1EB1D0D27EB26246DD0BCBC1D70", hash_generated_field = "18C8FDAD6849519506E4721838FB6A98")

        private static boolean warned = false;
    }


    
    static final class ReceiverDispatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.902 -0400", hash_original_field = "375144EC501E9DE6ABE0F6F7FC970CE2", hash_generated_field = "0D585D8E93CD584D754FB90606C97421")

        IIntentReceiver.Stub mIIntentReceiver;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.902 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "82183838DCCDFF42E01D0AB1ACA812C8")

        BroadcastReceiver mReceiver;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.902 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

        Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.902 -0400", hash_original_field = "7EF90D5DA2994166B5492D71C1F03D41", hash_generated_field = "12988E1FACD6824BE75454D0A2A06532")

        Handler mActivityThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.902 -0400", hash_original_field = "E062CE48CD3AFCDDC19DD9FCF2E119D4", hash_generated_field = "5CBE0F2EE224A7AD181F35AE16EC5D56")

        Instrumentation mInstrumentation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.902 -0400", hash_original_field = "BC0EC8B371AA46EEB12C4238B39133F3", hash_generated_field = "27276507FEAABA21DEE60596F4D3812E")

        boolean mRegistered;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.903 -0400", hash_original_field = "36AEE7DB2B3FEF907E8DF98C14332655", hash_generated_field = "C98CBB12EA09B3E51E00663E4E7ECBEF")

        IntentReceiverLeaked mLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.903 -0400", hash_original_field = "D9D14B33233CE76B9791B018F330780B", hash_generated_field = "080C297D2B34319904E59C288FE1CB54")

        RuntimeException mUnregisterLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.903 -0400", hash_original_field = "D983A9678CCC6771D873FE89E2CF0554", hash_generated_field = "8A69ACD90223C7C20F66A3AFE6F53D2F")

        boolean mForgotten;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.905 -0400", hash_original_method = "F99499486D66341875A2B920435493FE", hash_generated_method = "CC67A155791276815E7C69ABE16CD71F")
          ReceiverDispatcher(BroadcastReceiver receiver, Context context,
                Handler activityThread, Instrumentation instrumentation,
                boolean registered) {
    if(activityThread == null)            
            {
                NullPointerException var580B0D915E76BB18F6F50F1F0693C835_829705655 = new NullPointerException("Handler must not be null");
                var580B0D915E76BB18F6F50F1F0693C835_829705655.addTaint(taint);
                throw var580B0D915E76BB18F6F50F1F0693C835_829705655;
            } 
            mIIntentReceiver = new InnerReceiver(this, !registered);
            mReceiver = receiver;
            mContext = context;
            mActivityThread = activityThread;
            mInstrumentation = instrumentation;
            mRegistered = registered;
            mLocation = new IntentReceiverLeaked(null);
            mLocation.fillInStackTrace();
            
            
                
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.905 -0400", hash_original_method = "83596DB1DD81575005BC364432EA62BE", hash_generated_method = "33503BCECB43AF1F43659AE564D36236")
         void validate(Context context, Handler activityThread) {
            addTaint(activityThread.getTaint());
            addTaint(context.getTaint());
    if(mContext != context)            
            {
                IllegalStateException var21B0AA15F3A8AF335352978F9B838A9C_581569381 = new IllegalStateException(
                    "Receiver " + mReceiver +
                    " registered with differing Context (was " +
                    mContext + " now " + context + ")");
                var21B0AA15F3A8AF335352978F9B838A9C_581569381.addTaint(taint);
                throw var21B0AA15F3A8AF335352978F9B838A9C_581569381;
            } 
    if(mActivityThread != activityThread)            
            {
                IllegalStateException varD24A68864D0C00AFFBD915DB91E71BAC_739875579 = new IllegalStateException(
                    "Receiver " + mReceiver +
                    " registered with differing handler (was " +
                    mActivityThread + " now " + activityThread + ")");
                varD24A68864D0C00AFFBD915DB91E71BAC_739875579.addTaint(taint);
                throw varD24A68864D0C00AFFBD915DB91E71BAC_739875579;
            } 
            
            
                
                    
                    
                    
            
            
                
                    
                    
                    
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.906 -0400", hash_original_method = "7C4E5EC981022D2A84B36FB6D93F7965", hash_generated_method = "831BE094501874ABECF3D7EA4A31CCF3")
         IntentReceiverLeaked getLocation() {
IntentReceiverLeaked varC67D9EAB8F8C7974312627C3F915A447_1247550087 =             mLocation;
            varC67D9EAB8F8C7974312627C3F915A447_1247550087.addTaint(taint);
            return varC67D9EAB8F8C7974312627C3F915A447_1247550087;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.907 -0400", hash_original_method = "3C5B1FBD8D9CF893CD5AE57A3692C218", hash_generated_method = "D7FD4B4E3921AE89E5E59B23B11622CE")
         BroadcastReceiver getIntentReceiver() {
BroadcastReceiver var92BB1EAD1A7B04A11F11D488BE72928A_302872101 =             mReceiver;
            var92BB1EAD1A7B04A11F11D488BE72928A_302872101.addTaint(taint);
            return var92BB1EAD1A7B04A11F11D488BE72928A_302872101;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.908 -0400", hash_original_method = "03FF6A1CE859C16292BB870D48D4B619", hash_generated_method = "3E02FAB6663D5DF3CCBBC2E0E7011AE0")
         IIntentReceiver getIIntentReceiver() {
IIntentReceiver varA4B5D78F6F5CECCAA4D376A15BDA6253_1258353201 =             mIIntentReceiver;
            varA4B5D78F6F5CECCAA4D376A15BDA6253_1258353201.addTaint(taint);
            return varA4B5D78F6F5CECCAA4D376A15BDA6253_1258353201;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.909 -0400", hash_original_method = "10021177327079B574AB9A39568AB468", hash_generated_method = "EA685C5A5E8161DEED20B24280A81655")
         void setUnregisterLocation(RuntimeException ex) {
            mUnregisterLocation = ex;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.910 -0400", hash_original_method = "BEFB4AE86DE2CF8202227FDF4968A841", hash_generated_method = "329F1694920F8707A2E64FF0C168FBAC")
         RuntimeException getUnregisterLocation() {
RuntimeException var8A7CFC5E9175831B838BE224FA4022CA_1733376891 =             mUnregisterLocation;
            var8A7CFC5E9175831B838BE224FA4022CA_1733376891.addTaint(taint);
            return var8A7CFC5E9175831B838BE224FA4022CA_1733376891;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.911 -0400", hash_original_method = "39181D7F66A331F86FA5BEB0B1E79AC8", hash_generated_method = "5DCD273F0DD250F5935B073F8B6ED6FD")
        public void performReceive(Intent intent, int resultCode,
                String data, Bundle extras, boolean ordered, boolean sticky) {
            addTaint(sticky);
            addTaint(ordered);
            addTaint(extras.getTaint());
            addTaint(data.getTaint());
            addTaint(resultCode);
            addTaint(intent.getTaint());
    if(ActivityThread.DEBUG_BROADCAST)            
            {
                int seq = intent.getIntExtra("seq", -1);
            } 
            Args args = new Args(intent, resultCode, data, extras, ordered, sticky);
    if(!mActivityThread.post(args))            
            {
    if(mRegistered && ordered)                
                {
                    IActivityManager mgr = ActivityManagerNative.getDefault();
    if(ActivityThread.DEBUG_BROADCAST){ }                    args.sendFinished(mgr);
                } 
            } 
            
            
                
                
                        
            
            
            
                
                    
                    
                            
                    
                
            
        }

        
        final static class InnerReceiver extends IIntentReceiver.Stub {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.912 -0400", hash_original_field = "DBF05840F0B51F776B05018389E7959D", hash_generated_field = "721B40B341053DEDB330105D58454B08")

            WeakReference<LoadedApk.ReceiverDispatcher> mDispatcher;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.912 -0400", hash_original_field = "2F27BEAF9488F9111F7C68708453D2B0", hash_generated_field = "5A84F37BFD4FD2D8A7EC9111592CA64F")

            LoadedApk.ReceiverDispatcher mStrongRef;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.913 -0400", hash_original_method = "B5760C826128DD25E067AA5DC31216BE", hash_generated_method = "7ED6A19D2E31C049D4D81B46D7DDE02C")
              InnerReceiver(LoadedApk.ReceiverDispatcher rd, boolean strong) {
                mDispatcher = new WeakReference<LoadedApk.ReceiverDispatcher>(rd);
                mStrongRef = strong ? rd : null;
                
                
                
            }

            
            @DSModeled(DSC.SPEC)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.914 -0400", hash_original_method = "79B1DBA6D83AA95E8B5316A9BF3831EB", hash_generated_method = "8742A5F5BC5AD1D45EDE259357C3CF5F")
            public void performReceive(Intent intent, int resultCode,
                    String data, Bundle extras, boolean ordered, boolean sticky) {
                addTaint(sticky);
                addTaint(ordered);
                addTaint(extras.getTaint());
                addTaint(data.getTaint());
                addTaint(resultCode);
                addTaint(intent.getTaint());
                LoadedApk.ReceiverDispatcher rd = mDispatcher.get();
    if(ActivityThread.DEBUG_BROADCAST)                
                {
                    int seq = intent.getIntExtra("seq", -1);
                } 
    if(rd != null)                
                {
                    rd.performReceive(intent, resultCode, data, extras,
                            ordered, sticky);
                } 
                else
                {
    if(ActivityThread.DEBUG_BROADCAST){ }                    IActivityManager mgr = ActivityManagerNative.getDefault();
                    try 
                    {
    if(extras != null)                        
                        {
                            extras.setAllowFds(false);
                        } 
                        mgr.finishReceiver(this, resultCode, data, extras, false);
                    } 
                    catch (RemoteException e)
                    {
                    } 
                } 
                
                
            }

            
        }


        
        final class Args extends BroadcastReceiver.PendingResult implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.916 -0400", hash_original_field = "2B94A57B5324972078C949A0C39A6ED1", hash_generated_field = "BA12ECC45F316CCCFC0A85600BB7100C")

            private Intent mCurIntent;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.916 -0400", hash_original_field = "4A2BD4F8717C8C9A9172830E61B3F302", hash_generated_field = "345046B368470FC7DDE0CE76ADA9E345")

            private boolean mOrdered;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.918 -0400", hash_original_method = "6D86F310027103A2EE811DA0AC3AEAF2", hash_generated_method = "A5CC09E5EF80631E588BAE9283E2A5F5")
            public  Args(Intent intent, int resultCode, String resultData, Bundle resultExtras,
                    boolean ordered, boolean sticky) {
                super(resultCode, resultData, resultExtras,
                        mRegistered ? TYPE_REGISTERED : TYPE_UNREGISTERED,
                        ordered, sticky, mIIntentReceiver.asBinder());
                addTaint(sticky);
                addTaint(resultExtras.getTaint());
                addTaint(resultData.getTaint());
                addTaint(resultCode);
                mCurIntent = intent;
                mOrdered = ordered;
                
                
                
            }

            
            @DSModeled(DSC.SPEC)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.918 -0400", hash_original_method = "55098A9F5CE8E783F44DA889D3A217EF", hash_generated_method = "2C9FA8C56752641601962521BB7C79EB")
            public void run() {
                final BroadcastReceiver receiver = mReceiver;
                final boolean ordered = mOrdered;
    if(ActivityThread.DEBUG_BROADCAST)                
                {
                    int seq = mCurIntent.getIntExtra("seq", -1);
                } 
                final IActivityManager mgr = ActivityManagerNative.getDefault();
                final Intent intent = mCurIntent;
                mCurIntent = null;
    if(receiver == null || mForgotten)                
                {
    if(mRegistered && ordered)                    
                    {
    if(ActivityThread.DEBUG_BROADCAST){ }                        sendFinished(mgr);
                    } 
                    return;
                } 
                try 
                {
                    ClassLoader cl = mReceiver.getClass().getClassLoader();
                    intent.setExtrasClassLoader(cl);
                    setExtrasClassLoader(cl);
                    receiver.setPendingResult(this);
                    receiver.onReceive(mContext, intent);
                } 
                catch (Exception e)
                {
    if(mRegistered && ordered)                    
                    {
    if(ActivityThread.DEBUG_BROADCAST){ }                        sendFinished(mgr);
                    } 
    if(mInstrumentation == null ||
                            !mInstrumentation.onException(mReceiver, e))                    
                    {
                        RuntimeException var40F7CA19E2F234608DC910E20086B799_763775682 = new RuntimeException(
                            "Error receiving broadcast " + intent
                            + " in " + mReceiver, e);
                        var40F7CA19E2F234608DC910E20086B799_763775682.addTaint(taint);
                        throw var40F7CA19E2F234608DC910E20086B799_763775682;
                    } 
                } 
    if(receiver.getPendingResult() != null)                
                {
                    finish();
                } 
                
                
            }

            
        }


        
    }


    
    static final class ServiceDispatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.919 -0400", hash_original_field = "35D1631BD5F54C58228B58CF9B2B9567", hash_generated_field = "6D6E935A66D24BF635EDCC1459563037")

        private ServiceDispatcher.InnerConnection mIServiceConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.919 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "8C1B7663112C8AB9CDFE3F970E8AC317")

        private ServiceConnection mConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.919 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.920 -0400", hash_original_field = "7EF90D5DA2994166B5492D71C1F03D41", hash_generated_field = "2AAC1DA9D0E4EE70937D612B5EF41A87")

        private Handler mActivityThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.920 -0400", hash_original_field = "36AEE7DB2B3FEF907E8DF98C14332655", hash_generated_field = "1364060D7B0CFDC7C7DE9BA3A9936610")

        private ServiceConnectionLeaked mLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.920 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

        private int mFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.920 -0400", hash_original_field = "B5483ADD630F45F3141FE19CCC5266F0", hash_generated_field = "2749116703DB7B9FDA806F989CF22E90")

        private RuntimeException mUnbindLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.920 -0400", hash_original_field = "6F0CC9619210C67027AB8589E234E033", hash_generated_field = "E7960A883D3F26E3E35C03E35CAA56E5")

        private boolean mDied;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.920 -0400", hash_original_field = "D983A9678CCC6771D873FE89E2CF0554", hash_generated_field = "5DE8D58700C695344224A4434DF9E91B")

        private boolean mForgotten;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.920 -0400", hash_original_field = "E0E57A26C882F5B2A0756F3AEB48708B", hash_generated_field = "B2C433E68D38D7E4C3190DDDA91A488A")

        private final HashMap<ComponentName, ServiceDispatcher.ConnectionInfo> mActiveConnections = new HashMap<ComponentName, ServiceDispatcher.ConnectionInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.922 -0400", hash_original_method = "920453595DB1CAB2C546FB2B164C7405", hash_generated_method = "073F78DAF9C3E122B7B73EC693F89DCE")
          ServiceDispatcher(ServiceConnection conn,
                Context context, Handler activityThread, int flags) {
            mIServiceConnection = new InnerConnection(this);
            mConnection = conn;
            mContext = context;
            mActivityThread = activityThread;
            mLocation = new ServiceConnectionLeaked(null);
            mLocation.fillInStackTrace();
            mFlags = flags;
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.923 -0400", hash_original_method = "3A0AF1B483605B7B0302CA5F15EB7149", hash_generated_method = "BE49BFCCC51158E5ABF74AB2FC230167")
         void validate(Context context, Handler activityThread) {
            addTaint(activityThread.getTaint());
            addTaint(context.getTaint());
    if(mContext != context)            
            {
                RuntimeException var276D5A680801B49D75643F3C371581E3_236532895 = new RuntimeException(
                    "ServiceConnection " + mConnection +
                    " registered with differing Context (was " +
                    mContext + " now " + context + ")");
                var276D5A680801B49D75643F3C371581E3_236532895.addTaint(taint);
                throw var276D5A680801B49D75643F3C371581E3_236532895;
            } 
    if(mActivityThread != activityThread)            
            {
                RuntimeException var0772E178203849F775014B0FEE0977AA_668959049 = new RuntimeException(
                    "ServiceConnection " + mConnection +
                    " registered with differing handler (was " +
                    mActivityThread + " now " + activityThread + ")");
                var0772E178203849F775014B0FEE0977AA_668959049.addTaint(taint);
                throw var0772E178203849F775014B0FEE0977AA_668959049;
            } 
            
            
                
                    
                    
                    
            
            
                
                    
                    
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.924 -0400", hash_original_method = "B423F38D9F2547626F9540342BA8FA08", hash_generated_method = "9248FAF4F67E1C2E8EF27D3CB97355F9")
         void doForget() {
            synchronized
(this)            {
                Iterator<ServiceDispatcher.ConnectionInfo> it = mActiveConnections.values().iterator();
                while
(it.hasNext())                
                {
                    ServiceDispatcher.ConnectionInfo ci = it.next();
                    ci.binder.unlinkToDeath(ci.deathMonitor, 0);
                } 
                mActiveConnections.clear();
                mForgotten = true;
            } 
            
            
                
                
                    
                    
                
                
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.925 -0400", hash_original_method = "DB6C3DBDD9CEB1EED1EE508C536B0201", hash_generated_method = "3C6E0FB35882B8812DFD5FF0098AA47B")
         ServiceConnectionLeaked getLocation() {
ServiceConnectionLeaked varC67D9EAB8F8C7974312627C3F915A447_221339080 =             mLocation;
            varC67D9EAB8F8C7974312627C3F915A447_221339080.addTaint(taint);
            return varC67D9EAB8F8C7974312627C3F915A447_221339080;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.926 -0400", hash_original_method = "14318317B55D028C50F4E970D5AD5F89", hash_generated_method = "A38698BD346E291D4AFB28D89EF27DC4")
         ServiceConnection getServiceConnection() {
ServiceConnection var9818CDD0C0587BB48621EEA73B53E24D_933931451 =             mConnection;
            var9818CDD0C0587BB48621EEA73B53E24D_933931451.addTaint(taint);
            return var9818CDD0C0587BB48621EEA73B53E24D_933931451;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.927 -0400", hash_original_method = "A871391E91E358F0260A3C41C2649BF6", hash_generated_method = "868C7304AC2BD6DE4C20ADE9025DA73E")
         IServiceConnection getIServiceConnection() {
IServiceConnection var27A75AB4543CE8282280D637CBE787FC_1337268148 =             mIServiceConnection;
            var27A75AB4543CE8282280D637CBE787FC_1337268148.addTaint(taint);
            return var27A75AB4543CE8282280D637CBE787FC_1337268148;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.927 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "4960267141068C5436284014E82AE4F5")
         int getFlags() {
            int var9C3CD7D37D3E1E66BE9B3B005FC98B3A_1902116215 = (mFlags);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767846363 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767846363;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.927 -0400", hash_original_method = "CDEAAE2662154511545AF7B43E43329E", hash_generated_method = "460ACB65161A9381766EBD8AD8F65A14")
         void setUnbindLocation(RuntimeException ex) {
            mUnbindLocation = ex;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.928 -0400", hash_original_method = "8CFC5DB6BE83E965DCFCD58443A1D896", hash_generated_method = "4E2E53634E1D59CDA504565138205075")
         RuntimeException getUnbindLocation() {
RuntimeException varA5DF9D25C5162A5017A33E2D2101D98E_155344902 =             mUnbindLocation;
            varA5DF9D25C5162A5017A33E2D2101D98E_155344902.addTaint(taint);
            return varA5DF9D25C5162A5017A33E2D2101D98E_155344902;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.928 -0400", hash_original_method = "F55B5D35A31C0C5BF103A9C597E0E30E", hash_generated_method = "DE39DBB4795232DF588BC41FDF3C368C")
        public void connected(ComponentName name, IBinder service) {
            addTaint(service.getTaint());
            addTaint(name.getTaint());
    if(mActivityThread != null)            
            {
                mActivityThread.post(new RunConnection(name, service, 0));
            } 
            else
            {
                doConnected(name, service);
            } 
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.929 -0400", hash_original_method = "E6D57B0CCB9624E753F55A65AD088D17", hash_generated_method = "F642323C8769BF95CA0F3B66ED6A007F")
        public void death(ComponentName name, IBinder service) {
            addTaint(service.getTaint());
            addTaint(name.getTaint());
            ServiceDispatcher.ConnectionInfo old;
            synchronized
(this)            {
                mDied = true;
                old = mActiveConnections.remove(name);
    if(old == null || old.binder != service)                
                {
                    return;
                } 
                old.binder.unlinkToDeath(old.deathMonitor, 0);
            } 
    if(mActivityThread != null)            
            {
                mActivityThread.post(new RunConnection(name, service, 1));
            } 
            else
            {
                doDeath(name, service);
            } 
            
            
            
                
                
                
                    
                
                
            
            
                
            
                
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.931 -0400", hash_original_method = "4206BCB9948653D91B6930DF31631CB7", hash_generated_method = "1E32E7AA10D9916241BA02E8B6266A64")
        public void doConnected(ComponentName name, IBinder service) {
            addTaint(service.getTaint());
            addTaint(name.getTaint());
            ServiceDispatcher.ConnectionInfo old;
            ServiceDispatcher.ConnectionInfo info;
            synchronized
(this)            {
    if(mForgotten)                
                {
                    return;
                } 
                old = mActiveConnections.get(name);
    if(old != null && old.binder == service)                
                {
                    return;
                } 
    if(service != null)                
                {
                    mDied = false;
                    info = new ConnectionInfo();
                    info.binder = service;
                    info.deathMonitor = new DeathMonitor(name, service);
                    try 
                    {
                        service.linkToDeath(info.deathMonitor, 0);
                        mActiveConnections.put(name, info);
                    } 
                    catch (RemoteException e)
                    {
                        mActiveConnections.remove(name);
                        return;
                    } 
                } 
                else
                {
                    mActiveConnections.remove(name);
                } 
    if(old != null)                
                {
                    old.binder.unlinkToDeath(old.deathMonitor, 0);
                } 
            } 
    if(old != null)            
            {
                mConnection.onServiceDisconnected(name);
            } 
    if(service != null)            
            {
                mConnection.onServiceConnected(name, service);
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.933 -0400", hash_original_method = "71D95F8AA3DCAD1A788199BEC1658674", hash_generated_method = "B5AE943358CB2013FA301FCB5E6467F5")
        public void doDeath(ComponentName name, IBinder service) {
            addTaint(service.getTaint());
            addTaint(name.getTaint());
            mConnection.onServiceDisconnected(name);
            
            
        }

        
        private static class ConnectionInfo {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.934 -0400", hash_original_field = "5AE3422F7941E37EEB6D23CEF243C8CD", hash_generated_field = "FC5BAA062604D7264D40DD8AC68154EA")

            IBinder binder;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.935 -0400", hash_original_field = "D0A02B102A993DD010BC745EDCDCE48F", hash_generated_field = "256075ADF444DAFFF45701201F9B1B54")

            IBinder.DeathRecipient deathMonitor;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.935 -0400", hash_original_method = "1536CD23A1F6D2B518F8B5E1999BC949", hash_generated_method = "1536CD23A1F6D2B518F8B5E1999BC949")
            public ConnectionInfo ()
            {
                
            }


        }


        
        private static class InnerConnection extends IServiceConnection.Stub {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.936 -0400", hash_original_field = "DBF05840F0B51F776B05018389E7959D", hash_generated_field = "1DB9DDA8F9F99F15ABD03B8E39D3C3BD")

            WeakReference<LoadedApk.ServiceDispatcher> mDispatcher;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.937 -0400", hash_original_method = "A6B1961EAEFDBCFE8AB6AA462A76FB1E", hash_generated_method = "18D7336D44D6BB53573B2D2262A5B4C9")
              InnerConnection(LoadedApk.ServiceDispatcher sd) {
                mDispatcher = new WeakReference<LoadedApk.ServiceDispatcher>(sd);
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.939 -0400", hash_original_method = "A0C37377E0B0F4C4DBC15B0A2DE60194", hash_generated_method = "5C1D602208BF79CFAD5AE1177649A159")
            public void connected(ComponentName name, IBinder service) throws RemoteException {
                addTaint(service.getTaint());
                addTaint(name.getTaint());
                LoadedApk.ServiceDispatcher sd = mDispatcher.get();
    if(sd != null)                
                {
                    sd.connected(name, service);
                } 
                
                
                
                    
                
            }

            
        }


        
        private final class RunConnection implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.939 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "A464C2842626F7EA212C2BFED22D6A29")

            ComponentName mName;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.939 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "CC72E7E45ED0871AEF8710E69E6BA621")

            IBinder mService;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.939 -0400", hash_original_field = "FFAC4B84C06F5C4992FFE77A4652384C", hash_generated_field = "2F175E88AE074D5006E1484402CDDE3D")

            int mCommand;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.940 -0400", hash_original_method = "D3073AFB5412B3DFB84E25D578A5A4E5", hash_generated_method = "7FB46199D601DFACEA45FD3E711142BF")
              RunConnection(ComponentName name, IBinder service, int command) {
                mName = name;
                mService = service;
                mCommand = command;
                
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.941 -0400", hash_original_method = "52DC970C8C1C8CA46B980F1341D6E54B", hash_generated_method = "BCC0664C96955B7C0406304A662C11A9")
            public void run() {
    if(mCommand == 0)                
                {
                    doConnected(mName, mService);
                } 
                else
    if(mCommand == 1)                
                {
                    doDeath(mName, mService);
                } 
                
                
                    
                
                    
                
            }

            
        }


        
        private final class DeathMonitor implements IBinder.DeathRecipient {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.941 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "A464C2842626F7EA212C2BFED22D6A29")

            ComponentName mName;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.941 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "CC72E7E45ED0871AEF8710E69E6BA621")

            IBinder mService;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.942 -0400", hash_original_method = "A53A82D1432A704C0ADCA8B12394294F", hash_generated_method = "F85D671C0C9B41C59CEF43BEC6BE417D")
              DeathMonitor(ComponentName name, IBinder service) {
                mName = name;
                mService = service;
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.942 -0400", hash_original_method = "C3027F39FC9400E0CBA13CC2A85E99EF", hash_generated_method = "D2777A8801A10D11246301F62E6436C0")
            public void binderDied() {
                death(mName, mService);
                
                
            }

            
        }


        
    }


    
}

