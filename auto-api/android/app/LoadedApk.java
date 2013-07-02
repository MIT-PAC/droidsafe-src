package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.237 -0400", hash_original_method = "2DDF58935C7979F8233E5799714A3344", hash_generated_method = "2D90666CDB904595A088613D73CD4BDC")
    public  IntentReceiverLeaked(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
}

final class ServiceConnectionLeaked extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.237 -0400", hash_original_method = "3AC977BF0FF33C844B89CE3E7B08E19C", hash_generated_method = "65E305FF59472EE68A50A3CDAE68EFDA")
    public  ServiceConnectionLeaked(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
}

public final class LoadedApk {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.237 -0400", hash_original_field = "7EF90D5DA2994166B5492D71C1F03D41", hash_generated_field = "421BA2E15FA30D31BA5B63CB3A7B5B13")

    private ActivityThread mActivityThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.237 -0400", hash_original_field = "FD5C5E6825DA9870EAF09E3E93BBC5CA", hash_generated_field = "03043EB7A9D0FD1622717AEEB39E2C26")

    private ApplicationInfo mApplicationInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.237 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "7A5990DF4A54BF373C395B6501E20B02")

    String mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.238 -0400", hash_original_field = "4430148E41DA41FA63D06B1F2F0DF4E3", hash_generated_field = "E0A59288CBEC7FD799E8A337FACE1F5E")

    private String mAppDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.238 -0400", hash_original_field = "E6DEC81428C06CF3161B8FA0C4811101", hash_generated_field = "16A785049F12D1DFDF4F72387E1D9EFB")

    private String mResDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "C117FBB6B79E7E776A4691698BA58C54", hash_generated_field = "8FC8150480070F32937BA43631A0368E")

    private String[] mSharedLibraries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "7EDD3603F4A49D77EFA6EF705BD18DF5", hash_generated_field = "DA139898E558B5B558E8C0728494F629")

    private String mDataDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "EEC20EB7601ED7059BDD67D9CE6A5B06", hash_generated_field = "3DFB074D570DEA75E2F80D915A677796")

    private String mLibDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "E45B97D91F5B155EB8E33E2A4C73F43D", hash_generated_field = "6E40F983F9A90BA373BA4515E458568D")

    private File mDataDirFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "73686947E3EA370F12F24CB3BF845356", hash_generated_field = "DED5F167DA7D663ADC06A3550A4D7EA7")

    private ClassLoader mBaseClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "8CEAB0F22F050DB955C3D34D83B18CF2", hash_generated_field = "CCA7497D7EA5CC4EF77C1D70975F7273")

    private boolean mSecurityViolation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "0AE379AEE58DD7E01F47632047310B41", hash_generated_field = "35E5468E0019AD697E9AE711BEDB4638")

    private boolean mIncludeCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "F2B407E6A674EC5D91ECDEF6913CCBF8", hash_generated_field = "EDE7B5DFCD04834664F3F3E07C36CD7D")

    public final CompatibilityInfoHolder mCompatibilityInfo = new CompatibilityInfoHolder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8C221FB485568FEFC5ABDDF092AD743A")

    Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "334890635C1887AB66991B9374637EE6", hash_generated_field = "ABE17DFC947454E8F85FE66E61741F7A")

    private ClassLoader mClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "6B35E9B21496C1A77A324DB1577A6395", hash_generated_field = "53FA3553B85F7414D1C5F2C302FDEBF9")

    private Application mApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "32343F2FD91BBD33319B51ECF48DE3D1", hash_generated_field = "DA02F0E61096FE1235CD218F7663F0B5")

    private final HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>> mReceivers = new HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.240 -0400", hash_original_field = "D4D722C0A6B3FAC031635D0675FC8349", hash_generated_field = "351CD2B4585AE8D79380314A857D1433")

    private final HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>> mUnregisteredReceivers = new HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.241 -0400", hash_original_field = "EB07C26EFE0C2DDE3B9FFEE930D390FA", hash_generated_field = "1A0B5F333B7A8966A134CAF8AFAB489A")

    private final HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>> mServices = new HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.241 -0400", hash_original_field = "4C666CC89FDEF6BB184BFAB3DAEFC4F2", hash_generated_field = "86703A535EA1DE3F2DA9098AD90EB1AC")

    private final HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>> mUnboundServices = new HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.241 -0400", hash_original_field = "60D2FD238F0B065CED80605287080AEE", hash_generated_field = "5AEC4BBC7EEA13395C3D634E331479A9")

    int mClientCount = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.242 -0400", hash_original_method = "B0521F2A8F8912484DABAF70EB52FE24", hash_generated_method = "9544D8F77FC0F3376FB37CB2C8564025")
    public  LoadedApk(ActivityThread activityThread, ApplicationInfo aInfo,
            CompatibilityInfo compatInfo,
            ActivityThread mainThread, ClassLoader baseLoader,
            boolean securityViolation, boolean includeCode) {
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
        {
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
        addTaint(compatInfo.getTaint());
        addTaint(mainThread.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.243 -0400", hash_original_method = "208133E4566B7220D9D6A07C20B811D8", hash_generated_method = "084485E58807B9FFBE0B3C825D1C8CDF")
    public  LoadedApk(ActivityThread activityThread, String name,
            Context systemContext, ApplicationInfo info, CompatibilityInfo compatInfo) {
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
        addTaint(compatInfo.getTaint());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.243 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "1C75351472D06FD2D3A957BA5BFD2C2A")
     Application getApplication() {
        Application varB4EAC82CA7396A68D541C85D26508E83_1209050606 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1209050606 = mApplication;
        varB4EAC82CA7396A68D541C85D26508E83_1209050606.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1209050606;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.245 -0400", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "3922CF01D131ABD1F15B9B2C8FD1AD1F")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1346707764 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1346707764 = mPackageName;
        varB4EAC82CA7396A68D541C85D26508E83_1346707764.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1346707764;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.245 -0400", hash_original_method = "69D4795DAE5563DBA773DE992713BBC9", hash_generated_method = "7EFCE06F3B338DFDAE07A1E4AD5E1926")
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_1856727724 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1856727724 = mApplicationInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1856727724.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1856727724;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.246 -0400", hash_original_method = "1023CFFB5794A83B41C0A52D163AA3AF", hash_generated_method = "B5C14DB39B53EBC51462B833BAD35867")
    public boolean isSecurityViolation() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1862550088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1862550088;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.248 -0400", hash_original_method = "98BA13F46ABDF03C557DAF40D6E3FC88", hash_generated_method = "E994287469F9B943ECFDD9A370D7D34D")
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1649068289 = null; 
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_555312385 = null; 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1649068289 = mClassLoader;
            } 
            {
                boolean var296F17ADADF287FF92E97433DB7DF634_690511920 = (mIncludeCode && !mPackageName.equals("android"));
                {
                    String zip = mAppDir;
                    String instrumentationAppDir = mActivityThread.mInstrumentationAppDir;
                    String instrumentationAppPackage = mActivityThread.mInstrumentationAppPackage;
                    String instrumentedAppDir = mActivityThread.mInstrumentedAppDir;
                    String[] instrumentationLibs = null;
                    {
                        boolean var95281928A3723210196F3728BDFC5516_120880980 = (mAppDir.equals(instrumentationAppDir)
                        || mAppDir.equals(instrumentedAppDir));
                        {
                            zip = instrumentationAppDir + ":" + instrumentedAppDir;
                            {
                                boolean var38985C1C9A2B1CF58DF6A930664D4D62_1112332044 = (! instrumentedAppDir.equals(instrumentationAppDir));
                                {
                                    instrumentationLibs =
                            getLibrariesFor(instrumentationAppPackage);
                                } 
                            } 
                        } 
                    } 
                    {
                        zip =
                        combineLibs(mSharedLibraries, instrumentationLibs)
                        + ':' + zip;
                    } 
                    StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
                    mClassLoader =
                    ApplicationLoaders.getDefault().getClassLoader(
                        zip, mLibDir, mBaseClassLoader);
                    initializeJavaContextClassLoader();
                    StrictMode.setThreadPolicy(oldPolicy);
                } 
                {
                    {
                        mClassLoader = ClassLoader.getSystemClassLoader();
                    } 
                    {
                        mClassLoader = mBaseClassLoader;
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_555312385 = mClassLoader;
        } 
        ClassLoader varA7E53CE21691AB073D9660D615818899_907198720; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_907198720 = varB4EAC82CA7396A68D541C85D26508E83_1649068289;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_907198720 = varB4EAC82CA7396A68D541C85D26508E83_555312385;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_907198720.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_907198720;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.463 -0400", hash_original_method = "56AE7DDBC8B1739A2C59C89AA12BEB96", hash_generated_method = "4FA25BCD10D37ADCB3BC7441D0518273")
    private void initializeJavaContextClassLoader() {
        IPackageManager pm;
        pm = ActivityThread.getPackageManager();
        android.content.pm.PackageInfo pi;
        try 
        {
            pi = pm.getPackageInfo(mPackageName, 0);
        } 
        catch (RemoteException e)
        {
        	throw new AssertionError(e);
        } 
        boolean sharedUserIdSet;
        sharedUserIdSet = (pi.sharedUserId != null);
        boolean processNameNotDefault;
        processNameNotDefault = (pi.applicationInfo != null &&
             !mPackageName.equals(pi.applicationInfo.processName));
        boolean sharable;
        sharable = (sharedUserIdSet || processNameNotDefault);
        ClassLoader contextClassLoader;
        contextClassLoader = new WarningContextClassLoader();
        contextClassLoader = mClassLoader;
        Thread.currentThread().setContextClassLoader(contextClassLoader);
        
        
        
        
            
        
            
        
        
        
            
             
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.250 -0400", hash_original_method = "DDE558C6C52D26591497F8CCA19E2D11", hash_generated_method = "719E717183EB4CEA394F18ED4D0F53F1")
    public String getAppDir() {
        String varB4EAC82CA7396A68D541C85D26508E83_1277895520 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1277895520 = mAppDir;
        varB4EAC82CA7396A68D541C85D26508E83_1277895520.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1277895520;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.252 -0400", hash_original_method = "1158BD50BBC4E4D9C9B8EC24E43A83EF", hash_generated_method = "FEC9A1A53CE932A0A215ECF26FE097FE")
    public String getResDir() {
        String varB4EAC82CA7396A68D541C85D26508E83_1798899831 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1798899831 = mResDir;
        varB4EAC82CA7396A68D541C85D26508E83_1798899831.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1798899831;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.254 -0400", hash_original_method = "5486D8CB07A0A494A33FE28373C3B14E", hash_generated_method = "C1D42C5BE7E8C86F9FA6BD084E3632DB")
    public String getDataDir() {
        String varB4EAC82CA7396A68D541C85D26508E83_899661439 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_899661439 = mDataDir;
        varB4EAC82CA7396A68D541C85D26508E83_899661439.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_899661439;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.255 -0400", hash_original_method = "6FB19B7083E51C6FD4891C3DDE1600A5", hash_generated_method = "7B2BEE0626EAAC8B4F5D47CFE9D83E20")
    public File getDataDirFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_1158039098 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1158039098 = mDataDirFile;
        varB4EAC82CA7396A68D541C85D26508E83_1158039098.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1158039098;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.257 -0400", hash_original_method = "57B8CB1A3B484849D2245AC420407E2C", hash_generated_method = "6A4247E70046532F3E53AF2716EF0A7E")
    public AssetManager getAssets(ActivityThread mainThread) {
        AssetManager varB4EAC82CA7396A68D541C85D26508E83_15371365 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_15371365 = getResources(mainThread).getAssets();
        addTaint(mainThread.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_15371365.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_15371365;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.258 -0400", hash_original_method = "5E7B55611C44695241E7EB924E051C95", hash_generated_method = "0A21833127C537D73713DC44C2618897")
    public Resources getResources(ActivityThread mainThread) {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1755284709 = null; 
        {
            mResources = mainThread.getTopLevelResources(mResDir, this);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1755284709 = mResources;
        varB4EAC82CA7396A68D541C85D26508E83_1755284709.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1755284709;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.260 -0400", hash_original_method = "F09CA6154241A46EB02B7FA7F64D8F80", hash_generated_method = "66206786261E8991EDF0094EB1D11421")
    public Application makeApplication(boolean forceDefaultAppClass,
            Instrumentation instrumentation) {
        Application varB4EAC82CA7396A68D541C85D26508E83_34024971 = null; 
        Application varB4EAC82CA7396A68D541C85D26508E83_2076628872 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_34024971 = mApplication;
        } 
        Application app = null;
        String appClass = mApplicationInfo.className;
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
            {
                boolean var24338D5CA779D0D7608B19EED1172801_1620209394 = (!mActivityThread.mInstrumentation.onException(app, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to instantiate application " + appClass
                    + ": " + e.toString(), e);
                } 
            } 
        } 
        mActivityThread.mAllApplications.add(app);
        mApplication = app;
        {
            try 
            {
                instrumentation.callApplicationOnCreate(app);
            } 
            catch (Exception e)
            {
                {
                    boolean var4760B70FFAA788D24683ECFC8EF0BBEF_219769343 = (!instrumentation.onException(app, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to create application " + app.getClass().getName()
                        + ": " + e.toString(), e);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2076628872 = app;
        addTaint(forceDefaultAppClass);
        addTaint(instrumentation.getTaint());
        Application varA7E53CE21691AB073D9660D615818899_49866187; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_49866187 = varB4EAC82CA7396A68D541C85D26508E83_34024971;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_49866187 = varB4EAC82CA7396A68D541C85D26508E83_2076628872;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_49866187.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_49866187;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.263 -0400", hash_original_method = "B6291AD2FF4D11DEB13067F1AF687A9F", hash_generated_method = "086524DB37A28D0AA35225CF705ABAE1")
    public void removeContextRegistrations(Context context,
            String who, String what) {
        HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> rmap = mReceivers.remove(context);
        {
            Iterator<LoadedApk.ReceiverDispatcher> it = rmap.values().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1004657458 = (it.hasNext());
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
                    { }
                } 
            } 
        } 
        mUnregisteredReceivers.remove(context);
        HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> smap = mServices.remove(context);
        {
            Iterator<LoadedApk.ServiceDispatcher> it = smap.values().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1098394937 = (it.hasNext());
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
                    { }
                    sd.doForget();
                } 
            } 
        } 
        mUnboundServices.remove(context);
        addTaint(context.getTaint());
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.265 -0400", hash_original_method = "5954CD85EE6D69CD6AA4DB5D230A9DEB", hash_generated_method = "43B1A9137EF765AFF323E0371684D149")
    public IIntentReceiver getReceiverDispatcher(BroadcastReceiver r,
            Context context, Handler handler,
            Instrumentation instrumentation, boolean registered) {
        IIntentReceiver varB4EAC82CA7396A68D541C85D26508E83_927082617 = null; 
        {
            LoadedApk.ReceiverDispatcher rd = null;
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> map = null;
            {
                map = mReceivers.get(context);
                {
                    rd = map.get(r);
                } 
            } 
            {
                rd = new ReceiverDispatcher(r, context, handler,
                        instrumentation, registered);
                {
                    {
                        map = new HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>();
                        mReceivers.put(context, map);
                    } 
                    map.put(r, rd);
                } 
            } 
            {
                rd.validate(context, handler);
            } 
            rd.mForgotten = false;
            varB4EAC82CA7396A68D541C85D26508E83_927082617 = rd.getIIntentReceiver();
        } 
        addTaint(r.getTaint());
        addTaint(context.getTaint());
        addTaint(handler.getTaint());
        addTaint(instrumentation.getTaint());
        addTaint(registered);
        varB4EAC82CA7396A68D541C85D26508E83_927082617.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_927082617;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.266 -0400", hash_original_method = "56318BD0308680C3BFA3A8E4B0CE4CF3", hash_generated_method = "BA80244A8D5A284010FE96F7C117300B")
    public IIntentReceiver forgetReceiverDispatcher(Context context,
            BroadcastReceiver r) {
        IIntentReceiver varB4EAC82CA7396A68D541C85D26508E83_1781242874 = null; 
        {
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> map = mReceivers.get(context);
            LoadedApk.ReceiverDispatcher rd = null;
            {
                rd = map.get(r);
                {
                    map.remove(r);
                    {
                        boolean varF8AAF8C97EFC31F920EA8522BEF55B94_193413734 = (map.size() == 0);
                        {
                            mReceivers.remove(context);
                        } 
                    } 
                    {
                        boolean var3D8D85BD23AAFEAEB048FA5B5CD89650_516923250 = (r.getDebugUnregister());
                        {
                            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> holder = mUnregisteredReceivers.get(context);
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
                    } 
                    rd.mForgotten = true;
                    varB4EAC82CA7396A68D541C85D26508E83_1781242874 = rd.getIIntentReceiver();
                } 
            } 
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> holder = mUnregisteredReceivers.get(context);
            {
                rd = holder.get(r);
                {
                    RuntimeException ex = rd.getUnregisterLocation();
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                            "Unregistering Receiver " + r
                            + " that was already unregistered", ex);
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unbinding Receiver " + r
                        + " from Context that is no longer in use: " + context);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Receiver not registered: " + r);
            } 
        } 
        addTaint(context.getTaint());
        addTaint(r.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1781242874.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1781242874;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.268 -0400", hash_original_method = "D12EDE6D51B318B0614D5C86220B1198", hash_generated_method = "0DBEEBBEE12038F402C1601569D21ABD")
    public final IServiceConnection getServiceDispatcher(ServiceConnection c,
            Context context, Handler handler, int flags) {
        IServiceConnection varB4EAC82CA7396A68D541C85D26508E83_1959900485 = null; 
        {
            LoadedApk.ServiceDispatcher sd = null;
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> map = mServices.get(context);
            {
                sd = map.get(c);
            } 
            {
                sd = new ServiceDispatcher(c, context, handler, flags);
                {
                    map = new HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>();
                    mServices.put(context, map);
                } 
                map.put(c, sd);
            } 
            {
                sd.validate(context, handler);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1959900485 = sd.getIServiceConnection();
        } 
        addTaint(c.getTaint());
        addTaint(context.getTaint());
        addTaint(handler.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1959900485.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1959900485;
        
        
            
            
            
                
            
            
                
                
                    
                    
                
                
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.285 -0400", hash_original_method = "6B7C147E189191AFA124ECB6DFD3C546", hash_generated_method = "77E71D50DEECC386E540BF9CB3F70518")
    public final IServiceConnection forgetServiceDispatcher(Context context,
            ServiceConnection c) {
        IServiceConnection varB4EAC82CA7396A68D541C85D26508E83_345857160 = null; 
        {
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> map = mServices.get(context);
            LoadedApk.ServiceDispatcher sd = null;
            {
                sd = map.get(c);
                {
                    map.remove(c);
                    sd.doForget();
                    {
                        boolean varF8AAF8C97EFC31F920EA8522BEF55B94_1773050523 = (map.size() == 0);
                        {
                            mServices.remove(context);
                        } 
                    } 
                    {
                        boolean var07CAAA82623DD8F9BB6F63C5327EC905_1931754487 = ((sd.getFlags()&Context.BIND_DEBUG_UNBIND) != 0);
                        {
                            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> holder = mUnboundServices.get(context);
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
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_345857160 = sd.getIServiceConnection();
                } 
            } 
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> holder = mUnboundServices.get(context);
            {
                sd = holder.get(c);
                {
                    RuntimeException ex = sd.getUnbindLocation();
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                            "Unbinding Service " + c
                            + " that was already unbound", ex);
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unbinding Service " + c
                        + " from Context that is no longer in use: " + context);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Service not registered: " + c);
            } 
        } 
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_345857160.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_345857160;
        
        
    }

    
    private static class WarningContextClassLoader extends ClassLoader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.286 -0400", hash_original_method = "97527CB182747C5C8FA8F44BB3951504", hash_generated_method = "97527CB182747C5C8FA8F44BB3951504")
        public WarningContextClassLoader ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.287 -0400", hash_original_method = "2B0FE526CC8E82A351FDFDA472FB968C", hash_generated_method = "8592539A4E3930A8C374BBD149E05549")
        private void warn(String methodName) {
            warned = true;
            Thread.currentThread().setContextClassLoader(getParent());
            addTaint(methodName.getTaint());
            
            
                
            
            
            
            
                  
                  
                  
                  
                  
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.288 -0400", hash_original_method = "55A2C8B568742F6DD554B2AE8E06F675", hash_generated_method = "B15CB909B82A8053ED5B4B475FD4053B")
        @Override
        public URL getResource(String resName) {
            URL varB4EAC82CA7396A68D541C85D26508E83_52416317 = null; 
            warn("getResource");
            varB4EAC82CA7396A68D541C85D26508E83_52416317 = getParent().getResource(resName);
            addTaint(resName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_52416317.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_52416317;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.289 -0400", hash_original_method = "7DF26E5478EB621EA7136B5331588545", hash_generated_method = "0E7682212C394A5605387BA57900B0B8")
        @Override
        public Enumeration<URL> getResources(String resName) throws IOException {
            Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_116654595 = null; 
            warn("getResources");
            varB4EAC82CA7396A68D541C85D26508E83_116654595 = getParent().getResources(resName);
            addTaint(resName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_116654595.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_116654595;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.290 -0400", hash_original_method = "43C39FB9AB0F69E37F9176951B93B129", hash_generated_method = "5554CFB6A8C55C4B7EE6550CDA4CD2FF")
        @Override
        public InputStream getResourceAsStream(String resName) {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_345655898 = null; 
            warn("getResourceAsStream");
            varB4EAC82CA7396A68D541C85D26508E83_345655898 = getParent().getResourceAsStream(resName);
            addTaint(resName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_345655898.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_345655898;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.290 -0400", hash_original_method = "8B4C21AC14EA436FB72A6381E557B850", hash_generated_method = "7D8FD21BAA6BC128D0EED93378E7895B")
        @Override
        public Class<?> loadClass(String className) throws ClassNotFoundException {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_322557524 = null; 
            warn("loadClass");
            varB4EAC82CA7396A68D541C85D26508E83_322557524 = getParent().loadClass(className);
            addTaint(className.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_322557524.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_322557524;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.291 -0400", hash_original_method = "01BE45A57A3128BFD9BA3AF8CD4C6252", hash_generated_method = "650BBB4985901490EAA15ED468B1A469")
        @Override
        public void setClassAssertionStatus(String cname, boolean enable) {
            warn("setClassAssertionStatus");
            getParent().setClassAssertionStatus(cname, enable);
            addTaint(cname.getTaint());
            addTaint(enable);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.291 -0400", hash_original_method = "249CA030F95BF8C81AAAFF1521D1BE6E", hash_generated_method = "06843F2DF9453B571231D9019574BB5D")
        @Override
        public void setPackageAssertionStatus(String pname, boolean enable) {
            warn("setPackageAssertionStatus");
            getParent().setPackageAssertionStatus(pname, enable);
            addTaint(pname.getTaint());
            addTaint(enable);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.292 -0400", hash_original_method = "AC5504AD86A01EA0D58ADDE41ADE6649", hash_generated_method = "511F557FA08F4457C6ED356C8B016150")
        @Override
        public void setDefaultAssertionStatus(boolean enable) {
            warn("setDefaultAssertionStatus");
            getParent().setDefaultAssertionStatus(enable);
            addTaint(enable);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.292 -0400", hash_original_method = "DA3A923351AC4881D1A9879A5FDE3ACD", hash_generated_method = "08B0AD50933BEFAE2DAF57BAEB1B35D3")
        @Override
        public void clearAssertionStatus() {
            warn("clearAssertionStatus");
            getParent().clearAssertionStatus();
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.292 -0400", hash_original_field = "6340A1EB1D0D27EB26246DD0BCBC1D70", hash_generated_field = "18C8FDAD6849519506E4721838FB6A98")

        private static boolean warned = false;
    }


    
    static final class ReceiverDispatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.292 -0400", hash_original_field = "375144EC501E9DE6ABE0F6F7FC970CE2", hash_generated_field = "0D585D8E93CD584D754FB90606C97421")

        IIntentReceiver.Stub mIIntentReceiver;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.293 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "82183838DCCDFF42E01D0AB1ACA812C8")

        BroadcastReceiver mReceiver;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.293 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

        Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.293 -0400", hash_original_field = "7EF90D5DA2994166B5492D71C1F03D41", hash_generated_field = "12988E1FACD6824BE75454D0A2A06532")

        Handler mActivityThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.293 -0400", hash_original_field = "E062CE48CD3AFCDDC19DD9FCF2E119D4", hash_generated_field = "5CBE0F2EE224A7AD181F35AE16EC5D56")

        Instrumentation mInstrumentation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.293 -0400", hash_original_field = "BC0EC8B371AA46EEB12C4238B39133F3", hash_generated_field = "27276507FEAABA21DEE60596F4D3812E")

        boolean mRegistered;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.293 -0400", hash_original_field = "36AEE7DB2B3FEF907E8DF98C14332655", hash_generated_field = "C98CBB12EA09B3E51E00663E4E7ECBEF")

        IntentReceiverLeaked mLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.293 -0400", hash_original_field = "D9D14B33233CE76B9791B018F330780B", hash_generated_field = "080C297D2B34319904E59C288FE1CB54")

        RuntimeException mUnregisterLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.293 -0400", hash_original_field = "D983A9678CCC6771D873FE89E2CF0554", hash_generated_field = "8A69ACD90223C7C20F66A3AFE6F53D2F")

        boolean mForgotten;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.294 -0400", hash_original_method = "F99499486D66341875A2B920435493FE", hash_generated_method = "011A6CCA14814DF536ABE43E4B5DB69B")
          ReceiverDispatcher(BroadcastReceiver receiver, Context context,
                Handler activityThread, Instrumentation instrumentation,
                boolean registered) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Handler must not be null");
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.294 -0400", hash_original_method = "83596DB1DD81575005BC364432EA62BE", hash_generated_method = "C8EF7C70CF7665269A805E260B160E33")
         void validate(Context context, Handler activityThread) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Receiver " + mReceiver +
                    " registered with differing Context (was " +
                    mContext + " now " + context + ")");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Receiver " + mReceiver +
                    " registered with differing handler (was " +
                    mActivityThread + " now " + activityThread + ")");
            } 
            addTaint(context.getTaint());
            addTaint(activityThread.getTaint());
            
            
                
                    
                    
                    
            
            
                
                    
                    
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.295 -0400", hash_original_method = "7C4E5EC981022D2A84B36FB6D93F7965", hash_generated_method = "1C0247503C5FF7B63D3D487A9DA4DD91")
         IntentReceiverLeaked getLocation() {
            IntentReceiverLeaked varB4EAC82CA7396A68D541C85D26508E83_192238615 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_192238615 = mLocation;
            varB4EAC82CA7396A68D541C85D26508E83_192238615.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_192238615;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.296 -0400", hash_original_method = "3C5B1FBD8D9CF893CD5AE57A3692C218", hash_generated_method = "6D3014B91AFAB02974D28FF3B08A70DF")
         BroadcastReceiver getIntentReceiver() {
            BroadcastReceiver varB4EAC82CA7396A68D541C85D26508E83_2043926043 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2043926043 = mReceiver;
            varB4EAC82CA7396A68D541C85D26508E83_2043926043.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2043926043;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.296 -0400", hash_original_method = "03FF6A1CE859C16292BB870D48D4B619", hash_generated_method = "1CD5242C49560C036486CA1D88DCA835")
         IIntentReceiver getIIntentReceiver() {
            IIntentReceiver varB4EAC82CA7396A68D541C85D26508E83_957357723 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_957357723 = mIIntentReceiver;
            varB4EAC82CA7396A68D541C85D26508E83_957357723.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_957357723;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.297 -0400", hash_original_method = "10021177327079B574AB9A39568AB468", hash_generated_method = "EA685C5A5E8161DEED20B24280A81655")
         void setUnregisterLocation(RuntimeException ex) {
            mUnregisterLocation = ex;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.300 -0400", hash_original_method = "BEFB4AE86DE2CF8202227FDF4968A841", hash_generated_method = "FA69F76097107F55A987E79468983DD7")
         RuntimeException getUnregisterLocation() {
            RuntimeException varB4EAC82CA7396A68D541C85D26508E83_2135346931 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2135346931 = mUnregisterLocation;
            varB4EAC82CA7396A68D541C85D26508E83_2135346931.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2135346931;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.300 -0400", hash_original_method = "39181D7F66A331F86FA5BEB0B1E79AC8", hash_generated_method = "3BA21637E81A3CDDF9F13C53B4A322DD")
        public void performReceive(Intent intent, int resultCode,
                String data, Bundle extras, boolean ordered, boolean sticky) {
            {
                int seq = intent.getIntExtra("seq", -1);
            } 
            Args args = new Args(intent, resultCode, data, extras, ordered, sticky);
            {
                boolean var136D2EEA834070DC62C9F4EB9B7F3CE1_1747445720 = (!mActivityThread.post(args));
                {
                    {
                        IActivityManager mgr = ActivityManagerNative.getDefault();
                        args.sendFinished(mgr);
                    } 
                } 
            } 
            addTaint(intent.getTaint());
            addTaint(resultCode);
            addTaint(data.getTaint());
            addTaint(extras.getTaint());
            addTaint(ordered);
            addTaint(sticky);
            
            
                
                
                        
            
            
            
                
                    
                    
                            
                    
                
            
        }

        
        final static class InnerReceiver extends IIntentReceiver.Stub {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.301 -0400", hash_original_field = "DBF05840F0B51F776B05018389E7959D", hash_generated_field = "721B40B341053DEDB330105D58454B08")

            WeakReference<LoadedApk.ReceiverDispatcher> mDispatcher;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.301 -0400", hash_original_field = "2F27BEAF9488F9111F7C68708453D2B0", hash_generated_field = "5A84F37BFD4FD2D8A7EC9111592CA64F")

            LoadedApk.ReceiverDispatcher mStrongRef;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.301 -0400", hash_original_method = "B5760C826128DD25E067AA5DC31216BE", hash_generated_method = "7ED6A19D2E31C049D4D81B46D7DDE02C")
              InnerReceiver(LoadedApk.ReceiverDispatcher rd, boolean strong) {
                mDispatcher = new WeakReference<LoadedApk.ReceiverDispatcher>(rd);
                mStrongRef = strong ? rd : null;
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.302 -0400", hash_original_method = "79B1DBA6D83AA95E8B5316A9BF3831EB", hash_generated_method = "E8739E942059D585B8BFE719BDB08E62")
            public void performReceive(Intent intent, int resultCode,
                    String data, Bundle extras, boolean ordered, boolean sticky) {
                LoadedApk.ReceiverDispatcher rd = mDispatcher.get();
                {
                    int seq = intent.getIntExtra("seq", -1);
                } 
                {
                    rd.performReceive(intent, resultCode, data, extras,
                            ordered, sticky);
                } 
                {
                    IActivityManager mgr = ActivityManagerNative.getDefault();
                    try 
                    {
                        {
                            extras.setAllowFds(false);
                        } 
                        mgr.finishReceiver(this, resultCode, data, extras, false);
                    } 
                    catch (RemoteException e)
                    { }
                } 
                addTaint(intent.getTaint());
                addTaint(resultCode);
                addTaint(data.getTaint());
                addTaint(extras.getTaint());
                addTaint(ordered);
                addTaint(sticky);
                
                
            }

            
        }


        
        final class Args extends BroadcastReceiver.PendingResult implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.302 -0400", hash_original_field = "2B94A57B5324972078C949A0C39A6ED1", hash_generated_field = "BA12ECC45F316CCCFC0A85600BB7100C")

            private Intent mCurIntent;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.302 -0400", hash_original_field = "4A2BD4F8717C8C9A9172830E61B3F302", hash_generated_field = "345046B368470FC7DDE0CE76ADA9E345")

            private boolean mOrdered;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.303 -0400", hash_original_method = "6D86F310027103A2EE811DA0AC3AEAF2", hash_generated_method = "7F7D7B85B0EC1522526F46D610FCB72B")
            public  Args(Intent intent, int resultCode, String resultData, Bundle resultExtras,
                    boolean ordered, boolean sticky) {
                super(resultCode, resultData, resultExtras,
                        mRegistered ? TYPE_REGISTERED : TYPE_UNREGISTERED,
                        ordered, sticky, mIIntentReceiver.asBinder());
                mCurIntent = intent;
                mOrdered = ordered;
                addTaint(resultCode);
                addTaint(resultData.getTaint());
                addTaint(resultExtras.getTaint());
                addTaint(sticky);
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.303 -0400", hash_original_method = "55098A9F5CE8E783F44DA889D3A217EF", hash_generated_method = "C18B0F9143C2509620EC1AC32AAD71D8")
            public void run() {
                final BroadcastReceiver receiver = mReceiver;
                final boolean ordered = mOrdered;
                {
                    int seq = mCurIntent.getIntExtra("seq", -1);
                } 
                final IActivityManager mgr = ActivityManagerNative.getDefault();
                final Intent intent = mCurIntent;
                mCurIntent = null;
                {
                    {
                        sendFinished(mgr);
                    } 
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
                    {
                        sendFinished(mgr);
                    } 
                    {
                        boolean varC6CBB185D8FC33400F94A19454A84101_1392239371 = (mInstrumentation == null ||
                            !mInstrumentation.onException(mReceiver, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Error receiving broadcast " + intent
                            + " in " + mReceiver, e);
                        } 
                    } 
                } 
                {
                    boolean var35461069F001822CDD45AC759932345D_968548278 = (receiver.getPendingResult() != null);
                    {
                        finish();
                    } 
                } 
                
                
            }

            
        }


        
    }


    
    static final class ServiceDispatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.304 -0400", hash_original_field = "35D1631BD5F54C58228B58CF9B2B9567", hash_generated_field = "6D6E935A66D24BF635EDCC1459563037")

        private ServiceDispatcher.InnerConnection mIServiceConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.304 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "8C1B7663112C8AB9CDFE3F970E8AC317")

        private ServiceConnection mConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.304 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.304 -0400", hash_original_field = "7EF90D5DA2994166B5492D71C1F03D41", hash_generated_field = "2AAC1DA9D0E4EE70937D612B5EF41A87")

        private Handler mActivityThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.304 -0400", hash_original_field = "36AEE7DB2B3FEF907E8DF98C14332655", hash_generated_field = "1364060D7B0CFDC7C7DE9BA3A9936610")

        private ServiceConnectionLeaked mLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.304 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

        private int mFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.304 -0400", hash_original_field = "B5483ADD630F45F3141FE19CCC5266F0", hash_generated_field = "2749116703DB7B9FDA806F989CF22E90")

        private RuntimeException mUnbindLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.304 -0400", hash_original_field = "6F0CC9619210C67027AB8589E234E033", hash_generated_field = "E7960A883D3F26E3E35C03E35CAA56E5")

        private boolean mDied;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.304 -0400", hash_original_field = "D983A9678CCC6771D873FE89E2CF0554", hash_generated_field = "5DE8D58700C695344224A4434DF9E91B")

        private boolean mForgotten;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.304 -0400", hash_original_field = "E0E57A26C882F5B2A0756F3AEB48708B", hash_generated_field = "B2C433E68D38D7E4C3190DDDA91A488A")

        private final HashMap<ComponentName, ServiceDispatcher.ConnectionInfo> mActiveConnections = new HashMap<ComponentName, ServiceDispatcher.ConnectionInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.305 -0400", hash_original_method = "920453595DB1CAB2C546FB2B164C7405", hash_generated_method = "073F78DAF9C3E122B7B73EC693F89DCE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.305 -0400", hash_original_method = "3A0AF1B483605B7B0302CA5F15EB7149", hash_generated_method = "267E18F76B366E5C954B3C1AF0BA6352")
         void validate(Context context, Handler activityThread) {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "ServiceConnection " + mConnection +
                    " registered with differing Context (was " +
                    mContext + " now " + context + ")");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "ServiceConnection " + mConnection +
                    " registered with differing handler (was " +
                    mActivityThread + " now " + activityThread + ")");
            } 
            addTaint(context.getTaint());
            addTaint(activityThread.getTaint());
            
            
                
                    
                    
                    
            
            
                
                    
                    
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.306 -0400", hash_original_method = "B423F38D9F2547626F9540342BA8FA08", hash_generated_method = "FF3B9D26D51A251960895C23A7530424")
         void doForget() {
            {
                Iterator<ServiceDispatcher.ConnectionInfo> it = mActiveConnections.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1375796543 = (it.hasNext());
                    {
                        ServiceDispatcher.ConnectionInfo ci = it.next();
                        ci.binder.unlinkToDeath(ci.deathMonitor, 0);
                    } 
                } 
                mActiveConnections.clear();
                mForgotten = true;
            } 
            
            
                
                
                    
                    
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.307 -0400", hash_original_method = "DB6C3DBDD9CEB1EED1EE508C536B0201", hash_generated_method = "2C26613CA5A0F2C99BC250C2EABAD520")
         ServiceConnectionLeaked getLocation() {
            ServiceConnectionLeaked varB4EAC82CA7396A68D541C85D26508E83_1827368043 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1827368043 = mLocation;
            varB4EAC82CA7396A68D541C85D26508E83_1827368043.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1827368043;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.307 -0400", hash_original_method = "14318317B55D028C50F4E970D5AD5F89", hash_generated_method = "FDC793FDE52875EB9BB5554F01A4C036")
         ServiceConnection getServiceConnection() {
            ServiceConnection varB4EAC82CA7396A68D541C85D26508E83_1354155969 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1354155969 = mConnection;
            varB4EAC82CA7396A68D541C85D26508E83_1354155969.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1354155969;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.309 -0400", hash_original_method = "A871391E91E358F0260A3C41C2649BF6", hash_generated_method = "C0AF1886301B9E80E997890C073EF90F")
         IServiceConnection getIServiceConnection() {
            IServiceConnection varB4EAC82CA7396A68D541C85D26508E83_1440705643 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1440705643 = mIServiceConnection;
            varB4EAC82CA7396A68D541C85D26508E83_1440705643.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1440705643;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.309 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "60DA68A4A3D5C175D3050A9B2D15AD9B")
         int getFlags() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494894955 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494894955;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.310 -0400", hash_original_method = "CDEAAE2662154511545AF7B43E43329E", hash_generated_method = "460ACB65161A9381766EBD8AD8F65A14")
         void setUnbindLocation(RuntimeException ex) {
            mUnbindLocation = ex;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.311 -0400", hash_original_method = "8CFC5DB6BE83E965DCFCD58443A1D896", hash_generated_method = "1E98B30901D018DA056CB0FF59C4E531")
         RuntimeException getUnbindLocation() {
            RuntimeException varB4EAC82CA7396A68D541C85D26508E83_1351348805 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1351348805 = mUnbindLocation;
            varB4EAC82CA7396A68D541C85D26508E83_1351348805.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1351348805;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.311 -0400", hash_original_method = "F55B5D35A31C0C5BF103A9C597E0E30E", hash_generated_method = "AA8905B1B1F6EDB6F6A38A4430FD6583")
        public void connected(ComponentName name, IBinder service) {
            {
                mActivityThread.post(new RunConnection(name, service, 0));
            } 
            {
                doConnected(name, service);
            } 
            addTaint(name.getTaint());
            addTaint(service.getTaint());
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.312 -0400", hash_original_method = "E6D57B0CCB9624E753F55A65AD088D17", hash_generated_method = "8173CA944F3C28ED105C16D683EF2777")
        public void death(ComponentName name, IBinder service) {
            ServiceDispatcher.ConnectionInfo old;
            {
                mDied = true;
                old = mActiveConnections.remove(name);
                old.binder.unlinkToDeath(old.deathMonitor, 0);
            } 
            {
                mActivityThread.post(new RunConnection(name, service, 1));
            } 
            {
                doDeath(name, service);
            } 
            addTaint(name.getTaint());
            addTaint(service.getTaint());
            
            
            
                
                
                
                    
                
                
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.313 -0400", hash_original_method = "4206BCB9948653D91B6930DF31631CB7", hash_generated_method = "BD9942678D4A0E9A84C3A2169C402F31")
        public void doConnected(ComponentName name, IBinder service) {
            ServiceDispatcher.ConnectionInfo old;
            ServiceDispatcher.ConnectionInfo info;
            {
                old = mActiveConnections.get(name);
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
                    } 
                } 
                {
                    mActiveConnections.remove(name);
                } 
                {
                    old.binder.unlinkToDeath(old.deathMonitor, 0);
                } 
            } 
            {
                mConnection.onServiceDisconnected(name);
            } 
            {
                mConnection.onServiceConnected(name, service);
            } 
            addTaint(name.getTaint());
            addTaint(service.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.313 -0400", hash_original_method = "71D95F8AA3DCAD1A788199BEC1658674", hash_generated_method = "780060BABF9780CC65D0B14B5D747248")
        public void doDeath(ComponentName name, IBinder service) {
            mConnection.onServiceDisconnected(name);
            addTaint(name.getTaint());
            addTaint(service.getTaint());
            
            
        }

        
        private static class ConnectionInfo {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.313 -0400", hash_original_field = "5AE3422F7941E37EEB6D23CEF243C8CD", hash_generated_field = "FC5BAA062604D7264D40DD8AC68154EA")

            IBinder binder;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.313 -0400", hash_original_field = "D0A02B102A993DD010BC745EDCDCE48F", hash_generated_field = "256075ADF444DAFFF45701201F9B1B54")

            IBinder.DeathRecipient deathMonitor;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.313 -0400", hash_original_method = "1536CD23A1F6D2B518F8B5E1999BC949", hash_generated_method = "1536CD23A1F6D2B518F8B5E1999BC949")
            public ConnectionInfo ()
            {
                
            }


        }


        
        private static class InnerConnection extends IServiceConnection.Stub {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.313 -0400", hash_original_field = "DBF05840F0B51F776B05018389E7959D", hash_generated_field = "1DB9DDA8F9F99F15ABD03B8E39D3C3BD")

            WeakReference<LoadedApk.ServiceDispatcher> mDispatcher;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.314 -0400", hash_original_method = "A6B1961EAEFDBCFE8AB6AA462A76FB1E", hash_generated_method = "18D7336D44D6BB53573B2D2262A5B4C9")
              InnerConnection(LoadedApk.ServiceDispatcher sd) {
                mDispatcher = new WeakReference<LoadedApk.ServiceDispatcher>(sd);
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.314 -0400", hash_original_method = "A0C37377E0B0F4C4DBC15B0A2DE60194", hash_generated_method = "9760B5FDF8D7145C1CF6A5EAF405AB1A")
            public void connected(ComponentName name, IBinder service) throws RemoteException {
                LoadedApk.ServiceDispatcher sd = mDispatcher.get();
                {
                    sd.connected(name, service);
                } 
                addTaint(name.getTaint());
                addTaint(service.getTaint());
                
                
                
                    
                
            }

            
        }


        
        private final class RunConnection implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.314 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "A464C2842626F7EA212C2BFED22D6A29")

            ComponentName mName;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.314 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "CC72E7E45ED0871AEF8710E69E6BA621")

            IBinder mService;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.314 -0400", hash_original_field = "FFAC4B84C06F5C4992FFE77A4652384C", hash_generated_field = "2F175E88AE074D5006E1484402CDDE3D")

            int mCommand;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.315 -0400", hash_original_method = "D3073AFB5412B3DFB84E25D578A5A4E5", hash_generated_method = "7FB46199D601DFACEA45FD3E711142BF")
              RunConnection(ComponentName name, IBinder service, int command) {
                mName = name;
                mService = service;
                mCommand = command;
                
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.315 -0400", hash_original_method = "52DC970C8C1C8CA46B980F1341D6E54B", hash_generated_method = "0FA2FB8F700D4E7E5628BF9F17EC1A0B")
            public void run() {
                {
                    doConnected(mName, mService);
                } 
                {
                    doDeath(mName, mService);
                } 
                
                
                    
                
                    
                
            }

            
        }


        
        private final class DeathMonitor implements IBinder.DeathRecipient {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.315 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "A464C2842626F7EA212C2BFED22D6A29")

            ComponentName mName;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.315 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "CC72E7E45ED0871AEF8710E69E6BA621")

            IBinder mService;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.316 -0400", hash_original_method = "A53A82D1432A704C0ADCA8B12394294F", hash_generated_method = "F85D671C0C9B41C59CEF43BEC6BE417D")
              DeathMonitor(ComponentName name, IBinder service) {
                mName = name;
                mService = service;
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.316 -0400", hash_original_method = "C3027F39FC9400E0CBA13CC2A85E99EF", hash_generated_method = "D2777A8801A10D11246301F62E6436C0")
            public void binderDied() {
                death(mName, mService);
                
                
            }

            
        }


        
    }


    
}

