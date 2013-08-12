package android.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

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
import android.view.CompatibilityInfoHolder;

import com.android.internal.util.ArrayUtils;






final class IntentReceiverLeaked extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.742 -0400", hash_original_method = "2DDF58935C7979F8233E5799714A3344", hash_generated_method = "2D90666CDB904595A088613D73CD4BDC")
    public  IntentReceiverLeaked(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

final class ServiceConnectionLeaked extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.743 -0400", hash_original_method = "3AC977BF0FF33C844B89CE3E7B08E19C", hash_generated_method = "65E305FF59472EE68A50A3CDAE68EFDA")
    public  ServiceConnectionLeaked(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

public final class LoadedApk {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.744 -0400", hash_original_field = "7EF90D5DA2994166B5492D71C1F03D41", hash_generated_field = "421BA2E15FA30D31BA5B63CB3A7B5B13")

    private ActivityThread mActivityThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.744 -0400", hash_original_field = "FD5C5E6825DA9870EAF09E3E93BBC5CA", hash_generated_field = "03043EB7A9D0FD1622717AEEB39E2C26")

    private ApplicationInfo mApplicationInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.744 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "7A5990DF4A54BF373C395B6501E20B02")

    String mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.744 -0400", hash_original_field = "4430148E41DA41FA63D06B1F2F0DF4E3", hash_generated_field = "E0A59288CBEC7FD799E8A337FACE1F5E")

    private String mAppDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.744 -0400", hash_original_field = "E6DEC81428C06CF3161B8FA0C4811101", hash_generated_field = "16A785049F12D1DFDF4F72387E1D9EFB")

    private String mResDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.744 -0400", hash_original_field = "C117FBB6B79E7E776A4691698BA58C54", hash_generated_field = "8FC8150480070F32937BA43631A0368E")

    private String[] mSharedLibraries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.744 -0400", hash_original_field = "7EDD3603F4A49D77EFA6EF705BD18DF5", hash_generated_field = "DA139898E558B5B558E8C0728494F629")

    private String mDataDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.745 -0400", hash_original_field = "EEC20EB7601ED7059BDD67D9CE6A5B06", hash_generated_field = "3DFB074D570DEA75E2F80D915A677796")

    private String mLibDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.745 -0400", hash_original_field = "E45B97D91F5B155EB8E33E2A4C73F43D", hash_generated_field = "6E40F983F9A90BA373BA4515E458568D")

    private File mDataDirFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.745 -0400", hash_original_field = "73686947E3EA370F12F24CB3BF845356", hash_generated_field = "DED5F167DA7D663ADC06A3550A4D7EA7")

    private ClassLoader mBaseClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.745 -0400", hash_original_field = "8CEAB0F22F050DB955C3D34D83B18CF2", hash_generated_field = "CCA7497D7EA5CC4EF77C1D70975F7273")

    private boolean mSecurityViolation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.745 -0400", hash_original_field = "0AE379AEE58DD7E01F47632047310B41", hash_generated_field = "35E5468E0019AD697E9AE711BEDB4638")

    private boolean mIncludeCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.745 -0400", hash_original_field = "F2B407E6A674EC5D91ECDEF6913CCBF8", hash_generated_field = "EDE7B5DFCD04834664F3F3E07C36CD7D")

    public final CompatibilityInfoHolder mCompatibilityInfo = new CompatibilityInfoHolder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.745 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8C221FB485568FEFC5ABDDF092AD743A")

    Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.745 -0400", hash_original_field = "334890635C1887AB66991B9374637EE6", hash_generated_field = "ABE17DFC947454E8F85FE66E61741F7A")

    private ClassLoader mClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.745 -0400", hash_original_field = "6B35E9B21496C1A77A324DB1577A6395", hash_generated_field = "53FA3553B85F7414D1C5F2C302FDEBF9")

    private Application mApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.746 -0400", hash_original_field = "32343F2FD91BBD33319B51ECF48DE3D1", hash_generated_field = "DA02F0E61096FE1235CD218F7663F0B5")

    private final HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>> mReceivers = new HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.746 -0400", hash_original_field = "D4D722C0A6B3FAC031635D0675FC8349", hash_generated_field = "351CD2B4585AE8D79380314A857D1433")

    private final HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>> mUnregisteredReceivers = new HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.746 -0400", hash_original_field = "EB07C26EFE0C2DDE3B9FFEE930D390FA", hash_generated_field = "1A0B5F333B7A8966A134CAF8AFAB489A")

    private final HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>> mServices = new HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.746 -0400", hash_original_field = "4C666CC89FDEF6BB184BFAB3DAEFC4F2", hash_generated_field = "86703A535EA1DE3F2DA9098AD90EB1AC")

    private final HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>> mUnboundServices = new HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.746 -0400", hash_original_field = "60D2FD238F0B065CED80605287080AEE", hash_generated_field = "5AEC4BBC7EEA13395C3D634E331479A9")

    int mClientCount = 0;
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.750 -0400", hash_original_method = "B0521F2A8F8912484DABAF70EB52FE24", hash_generated_method = "47ED539A6A4A48DDDFAF9A0FD9D1728C")
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
            } //End block
            mClassLoader = ActivityThread.mSystemContext.getClassLoader();
            mResources = ActivityThread.mSystemContext.getResources();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.753 -0400", hash_original_method = "208133E4566B7220D9D6A07C20B811D8", hash_generated_method = "FA4A7D8F84ED65767BD55F52D0D099F5")
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
        // ---------- Original Method ----------
        //mActivityThread = activityThread;
        //mApplicationInfo = info != null ? info : new ApplicationInfo();
        //mApplicationInfo.packageName = name;
        //mPackageName = name;
        //mAppDir = null;
        //mResDir = null;
        //mSharedLibraries = null;
        //mDataDir = null;
        //mDataDirFile = null;
        //mLibDir = null;
        //mBaseClassLoader = null;
        //mSecurityViolation = false;
        //mIncludeCode = true;
        //mClassLoader = systemContext.getClassLoader();
        //mResources = systemContext.getResources();
        //mCompatibilityInfo.set(compatInfo);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.753 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "AEF50A2DD27361CA042D45F08AC2985F")
     Application getApplication() {
Application varF254F0ADF054F0318B65674CA3670A5E_711478776 =         mApplication;
        varF254F0ADF054F0318B65674CA3670A5E_711478776.addTaint(taint);
        return varF254F0ADF054F0318B65674CA3670A5E_711478776;
        // ---------- Original Method ----------
        //return mApplication;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.754 -0400", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "8AEDE4B6B54198E70B6CB0590619F68B")
    public String getPackageName() {
String var5601F77C1E784C31FA233AB799182FA6_97498033 =         mPackageName;
        var5601F77C1E784C31FA233AB799182FA6_97498033.addTaint(taint);
        return var5601F77C1E784C31FA233AB799182FA6_97498033;
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.754 -0400", hash_original_method = "69D4795DAE5563DBA773DE992713BBC9", hash_generated_method = "C8BFC2B1D909B3FE8D197A763A6FE75B")
    public ApplicationInfo getApplicationInfo() {
ApplicationInfo var7A6C13D6B64BE4CFA903FB80708E9465_2146398386 =         mApplicationInfo;
        var7A6C13D6B64BE4CFA903FB80708E9465_2146398386.addTaint(taint);
        return var7A6C13D6B64BE4CFA903FB80708E9465_2146398386;
        // ---------- Original Method ----------
        //return mApplicationInfo;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.755 -0400", hash_original_method = "1023CFFB5794A83B41C0A52D163AA3AF", hash_generated_method = "14523C5616A915D60205CC93B4479417")
    public boolean isSecurityViolation() {
        boolean var8CEAB0F22F050DB955C3D34D83B18CF2_1680439036 = (mSecurityViolation);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1774136356 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1774136356;
        // ---------- Original Method ----------
        //return mSecurityViolation;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.757 -0400", hash_original_method = "98BA13F46ABDF03C557DAF40D6E3FC88", hash_generated_method = "47195257AF681E7D672A2989846728FB")
    public ClassLoader getClassLoader() {
        synchronized
(this)        {
            if(mClassLoader != null)            
            {
ClassLoader var03260047576FFCA5A37C413ABA8D1CD1_241291652 =                 mClassLoader;
                var03260047576FFCA5A37C413ABA8D1CD1_241291652.addTaint(taint);
                return var03260047576FFCA5A37C413ABA8D1CD1_241291652;
            } //End block
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
                    } //End block
                } //End block
                if((mSharedLibraries != null) ||
                        (instrumentationLibs != null))                
                {
                    zip =
                        combineLibs(mSharedLibraries, instrumentationLibs)
                        + ':' + zip;
                } //End block
                if(ActivityThread.localLOGV){ }                StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
                mClassLoader =
                    ApplicationLoaders.getDefault().getClassLoader(
                        zip, mLibDir, mBaseClassLoader);
                initializeJavaContextClassLoader();
                StrictMode.setThreadPolicy(oldPolicy);
            } //End block
            else
            {
                if(mBaseClassLoader == null)                
                {
                    mClassLoader = ClassLoader.getSystemClassLoader();
                } //End block
                else
                {
                    mClassLoader = mBaseClassLoader;
                } //End block
            } //End block
ClassLoader var03260047576FFCA5A37C413ABA8D1CD1_649048055 =             mClassLoader;
            var03260047576FFCA5A37C413ABA8D1CD1_649048055.addTaint(taint);
            return var03260047576FFCA5A37C413ABA8D1CD1_649048055;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.758 -0400", hash_original_method = "56AE7DDBC8B1739A2C59C89AA12BEB96", hash_generated_method = "C8B5899E9D7882624052CD0ECD13E972")
    private void initializeJavaContextClassLoader() {
        IPackageManager pm = ActivityThread.getPackageManager();
        android.content.pm.PackageInfo pi;
        try 
        {
            pi = pm.getPackageInfo(mPackageName, 0);
        } //End block
        catch (RemoteException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1522824331 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1522824331.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1522824331;
        } //End block
        boolean sharedUserIdSet = (pi.sharedUserId != null);
        boolean processNameNotDefault = (pi.applicationInfo != null &&
             !mPackageName.equals(pi.applicationInfo.processName));
        boolean sharable = (sharedUserIdSet || processNameNotDefault);
        ClassLoader contextClassLoader = (sharable)
            ? new WarningContextClassLoader()
            : mClassLoader;
        Thread.currentThread().setContextClassLoader(contextClassLoader);
        // ---------- Original Method ----------
        //IPackageManager pm = ActivityThread.getPackageManager();
        //android.content.pm.PackageInfo pi;
        //try {
            //pi = pm.getPackageInfo(mPackageName, 0);
        //} catch (RemoteException e) {
            //throw new AssertionError(e);
        //}
        //boolean sharedUserIdSet = (pi.sharedUserId != null);
        //boolean processNameNotDefault =
            //(pi.applicationInfo != null &&
             //!mPackageName.equals(pi.applicationInfo.processName));
        //boolean sharable = (sharedUserIdSet || processNameNotDefault);
        //ClassLoader contextClassLoader =
            //(sharable)
            //? new WarningContextClassLoader()
            //: mClassLoader;
        //Thread.currentThread().setContextClassLoader(contextClassLoader);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.759 -0400", hash_original_method = "DDE558C6C52D26591497F8CCA19E2D11", hash_generated_method = "ECFBA95351B4319ED61DD9C1C2E9C683")
    public String getAppDir() {
String var181BC6EF4E240BFA6FBED8BF1ADFB867_1260501670 =         mAppDir;
        var181BC6EF4E240BFA6FBED8BF1ADFB867_1260501670.addTaint(taint);
        return var181BC6EF4E240BFA6FBED8BF1ADFB867_1260501670;
        // ---------- Original Method ----------
        //return mAppDir;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.759 -0400", hash_original_method = "1158BD50BBC4E4D9C9B8EC24E43A83EF", hash_generated_method = "F3CFF076682848C770C097422CD0AC78")
    public String getResDir() {
String var679D8BF02D40F53F6FB1455151813483_1927703774 =         mResDir;
        var679D8BF02D40F53F6FB1455151813483_1927703774.addTaint(taint);
        return var679D8BF02D40F53F6FB1455151813483_1927703774;
        // ---------- Original Method ----------
        //return mResDir;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.760 -0400", hash_original_method = "5486D8CB07A0A494A33FE28373C3B14E", hash_generated_method = "CBE3755BA4F8E752B7189E804CD8D0AB")
    public String getDataDir() {
String varF2DB52033E7B675C5416BA563C248BCF_1202169807 =         mDataDir;
        varF2DB52033E7B675C5416BA563C248BCF_1202169807.addTaint(taint);
        return varF2DB52033E7B675C5416BA563C248BCF_1202169807;
        // ---------- Original Method ----------
        //return mDataDir;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.760 -0400", hash_original_method = "6FB19B7083E51C6FD4891C3DDE1600A5", hash_generated_method = "7A64297FADC57AFDDFCB85334D733EBE")
    public File getDataDirFile() {
File var0F0E3AAC4D6C65AF3E62DA78DF7E2DFD_531128659 =         mDataDirFile;
        var0F0E3AAC4D6C65AF3E62DA78DF7E2DFD_531128659.addTaint(taint);
        return var0F0E3AAC4D6C65AF3E62DA78DF7E2DFD_531128659;
        // ---------- Original Method ----------
        //return mDataDirFile;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.760 -0400", hash_original_method = "57B8CB1A3B484849D2245AC420407E2C", hash_generated_method = "4D77C60BB99175D9216E9816F7A423A6")
    public AssetManager getAssets(ActivityThread mainThread) {
        addTaint(mainThread.getTaint());
AssetManager varA9B93526AA04C0D8699A4F14705F1CA1_55130872 =         getResources(mainThread).getAssets();
        varA9B93526AA04C0D8699A4F14705F1CA1_55130872.addTaint(taint);
        return varA9B93526AA04C0D8699A4F14705F1CA1_55130872;
        // ---------- Original Method ----------
        //return getResources(mainThread).getAssets();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.761 -0400", hash_original_method = "5E7B55611C44695241E7EB924E051C95", hash_generated_method = "8BA08D2930AC028454B497A64E29CDE8")
    public Resources getResources(ActivityThread mainThread) {
        if(mResources == null)        
        {
            mResources = mainThread.getTopLevelResources(mResDir, this);
        } //End block
Resources var346B953D96D762F7FED561E83C1656CA_22741555 =         mResources;
        var346B953D96D762F7FED561E83C1656CA_22741555.addTaint(taint);
        return var346B953D96D762F7FED561E83C1656CA_22741555;
        // ---------- Original Method ----------
        //if (mResources == null) {
            //mResources = mainThread.getTopLevelResources(mResDir, this);
        //}
        //return mResources;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.762 -0400", hash_original_method = "F09CA6154241A46EB02B7FA7F64D8F80", hash_generated_method = "855511AB540DF3087FE497C28BBF7222")
    public Application makeApplication(boolean forceDefaultAppClass,
            Instrumentation instrumentation) {
        addTaint(instrumentation.getTaint());
        addTaint(forceDefaultAppClass);
        if(mApplication != null)        
        {
Application varF254F0ADF054F0318B65674CA3670A5E_1146083218 =             mApplication;
            varF254F0ADF054F0318B65674CA3670A5E_1146083218.addTaint(taint);
            return varF254F0ADF054F0318B65674CA3670A5E_1146083218;
        } //End block
        Application app = null;
        String appClass = mApplicationInfo.className;
        if(forceDefaultAppClass || (appClass == null))        
        {
            appClass = "android.app.Application";
        } //End block
        try 
        {
            java.lang.ClassLoader cl = getClassLoader();
            ContextImpl appContext = new ContextImpl();
            appContext.init(this, null, mActivityThread);
            app = mActivityThread.mInstrumentation.newApplication(
                    cl, appClass, appContext);
            appContext.setOuterContext(app);
        } //End block
        catch (Exception e)
        {
            if(!mActivityThread.mInstrumentation.onException(app, e))            
            {
                RuntimeException var3B25207813A80E689E99D3B3114B341F_734547080 = new RuntimeException(
                    "Unable to instantiate application " + appClass
                    + ": " + e.toString(), e);
                var3B25207813A80E689E99D3B3114B341F_734547080.addTaint(taint);
                throw var3B25207813A80E689E99D3B3114B341F_734547080;
            } //End block
        } //End block
        mActivityThread.mAllApplications.add(app);
        mApplication = app;
        if(instrumentation != null)        
        {
            try 
            {
                instrumentation.callApplicationOnCreate(app);
            } //End block
            catch (Exception e)
            {
                if(!instrumentation.onException(app, e))                
                {
                    RuntimeException varADC9641D2DD7F467934A79889D69CEE2_681910310 = new RuntimeException(
                        "Unable to create application " + app.getClass().getName()
                        + ": " + e.toString(), e);
                    varADC9641D2DD7F467934A79889D69CEE2_681910310.addTaint(taint);
                    throw varADC9641D2DD7F467934A79889D69CEE2_681910310;
                } //End block
            } //End block
        } //End block
Application varBE0936E6D817E83D57F0B07BD06C3D1F_1717226957 =         app;
        varBE0936E6D817E83D57F0B07BD06C3D1F_1717226957.addTaint(taint);
        return varBE0936E6D817E83D57F0B07BD06C3D1F_1717226957;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.764 -0400", hash_original_method = "B6291AD2FF4D11DEB13067F1AF687A9F", hash_generated_method = "F6249D7408069BA46AAB3A4261515B76")
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
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
        } //End block
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
                } //End block
                catch (RemoteException e)
                {
                } //End block
                sd.doForget();
            } //End block
        } //End block
        mUnboundServices.remove(context);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.765 -0400", hash_original_method = "5954CD85EE6D69CD6AA4DB5D230A9DEB", hash_generated_method = "0CF975DACC0C39A75D90331555687A4E")
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
                } //End block
            } //End block
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
                    } //End block
                    map.put(r, rd);
                } //End block
            } //End block
            else
            {
                rd.validate(context, handler);
            } //End block
            rd.mForgotten = false;
IIntentReceiver varD5A94533AA11F9BD3389DB2AEB2B6E0A_1986966309 =             rd.getIIntentReceiver();
            varD5A94533AA11F9BD3389DB2AEB2B6E0A_1986966309.addTaint(taint);
            return varD5A94533AA11F9BD3389DB2AEB2B6E0A_1986966309;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.771 -0400", hash_original_method = "56318BD0308680C3BFA3A8E4B0CE4CF3", hash_generated_method = "62D0D4AE4A23074EB8DB3B254374BFB9")
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
                    } //End block
                    if(r.getDebugUnregister())                    
                    {
                        HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> holder = mUnregisteredReceivers.get(context);
                        if(holder == null)                        
                        {
                            holder = new HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>();
                            mUnregisteredReceivers.put(context, holder);
                        } //End block
                        RuntimeException ex = new IllegalArgumentException(
                                "Originally unregistered here:");
                        ex.fillInStackTrace();
                        rd.setUnregisterLocation(ex);
                        holder.put(r, rd);
                    } //End block
                    rd.mForgotten = true;
IIntentReceiver varD5A94533AA11F9BD3389DB2AEB2B6E0A_1893566189 =                     rd.getIIntentReceiver();
                    varD5A94533AA11F9BD3389DB2AEB2B6E0A_1893566189.addTaint(taint);
                    return varD5A94533AA11F9BD3389DB2AEB2B6E0A_1893566189;
                } //End block
            } //End block
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> holder = mUnregisteredReceivers.get(context);
            if(holder != null)            
            {
                rd = holder.get(r);
                if(rd != null)                
                {
                    RuntimeException ex = rd.getUnregisterLocation();
                    IllegalArgumentException var7F263DB8ACB8D48568B9331E4102F6E0_120382643 = new IllegalArgumentException(
                            "Unregistering Receiver " + r
                            + " that was already unregistered", ex);
                    var7F263DB8ACB8D48568B9331E4102F6E0_120382643.addTaint(taint);
                    throw var7F263DB8ACB8D48568B9331E4102F6E0_120382643;
                } //End block
            } //End block
            if(context == null)            
            {
                IllegalStateException var00474B2F5EE84BF0384A7D2E5B32DA01_60862122 = new IllegalStateException("Unbinding Receiver " + r
                        + " from Context that is no longer in use: " + context);
                var00474B2F5EE84BF0384A7D2E5B32DA01_60862122.addTaint(taint);
                throw var00474B2F5EE84BF0384A7D2E5B32DA01_60862122;
            } //End block
            else
            {
                IllegalArgumentException var5DD34F77F9C0CFCA73718DD9B6E31DC2_1949047835 = new IllegalArgumentException("Receiver not registered: " + r);
                var5DD34F77F9C0CFCA73718DD9B6E31DC2_1949047835.addTaint(taint);
                throw var5DD34F77F9C0CFCA73718DD9B6E31DC2_1949047835;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.773 -0400", hash_original_method = "D12EDE6D51B318B0614D5C86220B1198", hash_generated_method = "4CB618B6DD816C15FF308F724F0F1402")
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
            } //End block
            if(sd == null)            
            {
                sd = new ServiceDispatcher(c, context, handler, flags);
                if(map == null)                
                {
                    map = new HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>();
                    mServices.put(context, map);
                } //End block
                map.put(c, sd);
            } //End block
            else
            {
                sd.validate(context, handler);
            } //End block
IServiceConnection varB5403F53D6FFC730CE6C14DD2D80D567_538020351 =             sd.getIServiceConnection();
            varB5403F53D6FFC730CE6C14DD2D80D567_538020351.addTaint(taint);
            return varB5403F53D6FFC730CE6C14DD2D80D567_538020351;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mServices) {
            //LoadedApk.ServiceDispatcher sd = null;
            //HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> map = mServices.get(context);
            //if (map != null) {
                //sd = map.get(c);
            //}
            //if (sd == null) {
                //sd = new ServiceDispatcher(c, context, handler, flags);
                //if (map == null) {
                    //map = new HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>();
                    //mServices.put(context, map);
                //}
                //map.put(c, sd);
            //} else {
                //sd.validate(context, handler);
            //}
            //return sd.getIServiceConnection();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.776 -0400", hash_original_method = "6B7C147E189191AFA124ECB6DFD3C546", hash_generated_method = "0321EB806A10B24CDE95DE831DB114BA")
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
                    } //End block
                    if((sd.getFlags()&Context.BIND_DEBUG_UNBIND) != 0)                    
                    {
                        HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> holder = mUnboundServices.get(context);
                        if(holder == null)                        
                        {
                            holder = new HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>();
                            mUnboundServices.put(context, holder);
                        } //End block
                        RuntimeException ex = new IllegalArgumentException(
                                "Originally unbound here:");
                        ex.fillInStackTrace();
                        sd.setUnbindLocation(ex);
                        holder.put(c, sd);
                    } //End block
IServiceConnection varB5403F53D6FFC730CE6C14DD2D80D567_2008890479 =                     sd.getIServiceConnection();
                    varB5403F53D6FFC730CE6C14DD2D80D567_2008890479.addTaint(taint);
                    return varB5403F53D6FFC730CE6C14DD2D80D567_2008890479;
                } //End block
            } //End block
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> holder = mUnboundServices.get(context);
            if(holder != null)            
            {
                sd = holder.get(c);
                if(sd != null)                
                {
                    RuntimeException ex = sd.getUnbindLocation();
                    IllegalArgumentException varFD28B592AF25E583DB19536717B514F4_1598150648 = new IllegalArgumentException(
                            "Unbinding Service " + c
                            + " that was already unbound", ex);
                    varFD28B592AF25E583DB19536717B514F4_1598150648.addTaint(taint);
                    throw varFD28B592AF25E583DB19536717B514F4_1598150648;
                } //End block
            } //End block
            if(context == null)            
            {
                IllegalStateException varEB5791341B77439E3C586168DCDCCFC7_788079019 = new IllegalStateException("Unbinding Service " + c
                        + " from Context that is no longer in use: " + context);
                varEB5791341B77439E3C586168DCDCCFC7_788079019.addTaint(taint);
                throw varEB5791341B77439E3C586168DCDCCFC7_788079019;
            } //End block
            else
            {
                IllegalArgumentException varBD67BB9700C15C1E46112D3D9496A6F5_162161198 = new IllegalArgumentException("Service not registered: " + c);
                varBD67BB9700C15C1E46112D3D9496A6F5_162161198.addTaint(taint);
                throw varBD67BB9700C15C1E46112D3D9496A6F5_162161198;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class WarningContextClassLoader extends ClassLoader {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.778 -0400", hash_original_method = "97527CB182747C5C8FA8F44BB3951504", hash_generated_method = "97527CB182747C5C8FA8F44BB3951504")
        public WarningContextClassLoader ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.779 -0400", hash_original_method = "2B0FE526CC8E82A351FDFDA472FB968C", hash_generated_method = "D7CBB0B4652590BFB751FDDE95A2F09D")
        private void warn(String methodName) {
            addTaint(methodName.getTaint());
            if(warned)            
            {
                return;
            } //End block
            warned = true;
            Thread.currentThread().setContextClassLoader(getParent());
            // ---------- Original Method ----------
            //if (warned) {
                //return;
            //}
            //warned = true;
            //Thread.currentThread().setContextClassLoader(getParent());
            //Slog.w(ActivityThread.TAG, "ClassLoader." + methodName + ": " +
                  //"The class loader returned by " +
                  //"Thread.getContextClassLoader() may fail for processes " +
                  //"that host multiple applications. You should explicitly " +
                  //"specify a context class loader. For example: " +
                  //"Thread.setContextClassLoader(getClass().getClassLoader());");
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.779 -0400", hash_original_method = "55A2C8B568742F6DD554B2AE8E06F675", hash_generated_method = "E573594845A6D16947FC1CEE7E88F014")
        @Override
        public URL getResource(String resName) {
            addTaint(resName.getTaint());
            warn("getResource");
URL var7C3D7459C5F00959470A40AD7397BE62_936424720 =             getParent().getResource(resName);
            var7C3D7459C5F00959470A40AD7397BE62_936424720.addTaint(taint);
            return var7C3D7459C5F00959470A40AD7397BE62_936424720;
            // ---------- Original Method ----------
            //warn("getResource");
            //return getParent().getResource(resName);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.779 -0400", hash_original_method = "7DF26E5478EB621EA7136B5331588545", hash_generated_method = "4D81A8042483635C4FB2C2CE7B0B3831")
        @Override
        public Enumeration<URL> getResources(String resName) throws IOException {
            addTaint(resName.getTaint());
            warn("getResources");
Enumeration<URL> var04542047AB0555D7921DE8D0AE440C17_200203924 =             getParent().getResources(resName);
            var04542047AB0555D7921DE8D0AE440C17_200203924.addTaint(taint);
            return var04542047AB0555D7921DE8D0AE440C17_200203924;
            // ---------- Original Method ----------
            //warn("getResources");
            //return getParent().getResources(resName);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.780 -0400", hash_original_method = "43C39FB9AB0F69E37F9176951B93B129", hash_generated_method = "4CA887AF48FAA5BEBFFE2AEFA75E9969")
        @Override
        public InputStream getResourceAsStream(String resName) {
            addTaint(resName.getTaint());
            warn("getResourceAsStream");
InputStream var5B5DB975D90794344CA62AD4DB7340CB_496054625 =             getParent().getResourceAsStream(resName);
            var5B5DB975D90794344CA62AD4DB7340CB_496054625.addTaint(taint);
            return var5B5DB975D90794344CA62AD4DB7340CB_496054625;
            // ---------- Original Method ----------
            //warn("getResourceAsStream");
            //return getParent().getResourceAsStream(resName);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.781 -0400", hash_original_method = "8B4C21AC14EA436FB72A6381E557B850", hash_generated_method = "263E0EACE2674F501CA03006A07D28C9")
        @Override
        public Class<?> loadClass(String className) throws ClassNotFoundException {
            addTaint(className.getTaint());
            warn("loadClass");
Class<?> varE1970970BC5A81C617EE2028559098DF_1354177723 =             getParent().loadClass(className);
            varE1970970BC5A81C617EE2028559098DF_1354177723.addTaint(taint);
            return varE1970970BC5A81C617EE2028559098DF_1354177723;
            // ---------- Original Method ----------
            //warn("loadClass");
            //return getParent().loadClass(className);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.781 -0400", hash_original_method = "01BE45A57A3128BFD9BA3AF8CD4C6252", hash_generated_method = "62BAEB7AA08B45584831CD6722B33E78")
        @Override
        public void setClassAssertionStatus(String cname, boolean enable) {
            addTaint(enable);
            addTaint(cname.getTaint());
            warn("setClassAssertionStatus");
            getParent().setClassAssertionStatus(cname, enable);
            // ---------- Original Method ----------
            //warn("setClassAssertionStatus");
            //getParent().setClassAssertionStatus(cname, enable);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.782 -0400", hash_original_method = "249CA030F95BF8C81AAAFF1521D1BE6E", hash_generated_method = "F82CD1B656135F392782FCC9763591E4")
        @Override
        public void setPackageAssertionStatus(String pname, boolean enable) {
            addTaint(enable);
            addTaint(pname.getTaint());
            warn("setPackageAssertionStatus");
            getParent().setPackageAssertionStatus(pname, enable);
            // ---------- Original Method ----------
            //warn("setPackageAssertionStatus");
            //getParent().setPackageAssertionStatus(pname, enable);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.782 -0400", hash_original_method = "AC5504AD86A01EA0D58ADDE41ADE6649", hash_generated_method = "DF959CC50A3E8C43B385FE34A7BCC843")
        @Override
        public void setDefaultAssertionStatus(boolean enable) {
            addTaint(enable);
            warn("setDefaultAssertionStatus");
            getParent().setDefaultAssertionStatus(enable);
            // ---------- Original Method ----------
            //warn("setDefaultAssertionStatus");
            //getParent().setDefaultAssertionStatus(enable);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.783 -0400", hash_original_method = "DA3A923351AC4881D1A9879A5FDE3ACD", hash_generated_method = "08B0AD50933BEFAE2DAF57BAEB1B35D3")
        @Override
        public void clearAssertionStatus() {
            warn("clearAssertionStatus");
            getParent().clearAssertionStatus();
            // ---------- Original Method ----------
            //warn("clearAssertionStatus");
            //getParent().clearAssertionStatus();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.783 -0400", hash_original_field = "6340A1EB1D0D27EB26246DD0BCBC1D70", hash_generated_field = "18C8FDAD6849519506E4721838FB6A98")

        private static boolean warned = false;
    }


    
    static final class ReceiverDispatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.783 -0400", hash_original_field = "375144EC501E9DE6ABE0F6F7FC970CE2", hash_generated_field = "0D585D8E93CD584D754FB90606C97421")

        IIntentReceiver.Stub mIIntentReceiver;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.783 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "82183838DCCDFF42E01D0AB1ACA812C8")

        BroadcastReceiver mReceiver;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.783 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

        Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.784 -0400", hash_original_field = "7EF90D5DA2994166B5492D71C1F03D41", hash_generated_field = "12988E1FACD6824BE75454D0A2A06532")

        Handler mActivityThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.784 -0400", hash_original_field = "E062CE48CD3AFCDDC19DD9FCF2E119D4", hash_generated_field = "5CBE0F2EE224A7AD181F35AE16EC5D56")

        Instrumentation mInstrumentation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.784 -0400", hash_original_field = "BC0EC8B371AA46EEB12C4238B39133F3", hash_generated_field = "27276507FEAABA21DEE60596F4D3812E")

        boolean mRegistered;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.784 -0400", hash_original_field = "36AEE7DB2B3FEF907E8DF98C14332655", hash_generated_field = "C98CBB12EA09B3E51E00663E4E7ECBEF")

        IntentReceiverLeaked mLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.784 -0400", hash_original_field = "D9D14B33233CE76B9791B018F330780B", hash_generated_field = "080C297D2B34319904E59C288FE1CB54")

        RuntimeException mUnregisterLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.784 -0400", hash_original_field = "D983A9678CCC6771D873FE89E2CF0554", hash_generated_field = "8A69ACD90223C7C20F66A3AFE6F53D2F")

        boolean mForgotten;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.786 -0400", hash_original_method = "F99499486D66341875A2B920435493FE", hash_generated_method = "6CC4EB7C930E781317E09A552F9544D1")
          ReceiverDispatcher(BroadcastReceiver receiver, Context context,
                Handler activityThread, Instrumentation instrumentation,
                boolean registered) {
            if(activityThread == null)            
            {
                NullPointerException var580B0D915E76BB18F6F50F1F0693C835_42780249 = new NullPointerException("Handler must not be null");
                var580B0D915E76BB18F6F50F1F0693C835_42780249.addTaint(taint);
                throw var580B0D915E76BB18F6F50F1F0693C835_42780249;
            } //End block
            mIIntentReceiver = new InnerReceiver(this, !registered);
            mReceiver = receiver;
            mContext = context;
            mActivityThread = activityThread;
            mInstrumentation = instrumentation;
            mRegistered = registered;
            mLocation = new IntentReceiverLeaked(null);
            mLocation.fillInStackTrace();
            // ---------- Original Method ----------
            //if (activityThread == null) {
                //throw new NullPointerException("Handler must not be null");
            //}
            //mIIntentReceiver = new InnerReceiver(this, !registered);
            //mReceiver = receiver;
            //mContext = context;
            //mActivityThread = activityThread;
            //mInstrumentation = instrumentation;
            //mRegistered = registered;
            //mLocation = new IntentReceiverLeaked(null);
            //mLocation.fillInStackTrace();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.786 -0400", hash_original_method = "83596DB1DD81575005BC364432EA62BE", hash_generated_method = "09BE9AD825DB70B54238D5869F727225")
         void validate(Context context, Handler activityThread) {
            addTaint(activityThread.getTaint());
            addTaint(context.getTaint());
            if(mContext != context)            
            {
                IllegalStateException var21B0AA15F3A8AF335352978F9B838A9C_1310769508 = new IllegalStateException(
                    "Receiver " + mReceiver +
                    " registered with differing Context (was " +
                    mContext + " now " + context + ")");
                var21B0AA15F3A8AF335352978F9B838A9C_1310769508.addTaint(taint);
                throw var21B0AA15F3A8AF335352978F9B838A9C_1310769508;
            } //End block
            if(mActivityThread != activityThread)            
            {
                IllegalStateException varD24A68864D0C00AFFBD915DB91E71BAC_966443864 = new IllegalStateException(
                    "Receiver " + mReceiver +
                    " registered with differing handler (was " +
                    mActivityThread + " now " + activityThread + ")");
                varD24A68864D0C00AFFBD915DB91E71BAC_966443864.addTaint(taint);
                throw varD24A68864D0C00AFFBD915DB91E71BAC_966443864;
            } //End block
            // ---------- Original Method ----------
            //if (mContext != context) {
                //throw new IllegalStateException(
                    //"Receiver " + mReceiver +
                    //" registered with differing Context (was " +
                    //mContext + " now " + context + ")");
            //}
            //if (mActivityThread != activityThread) {
                //throw new IllegalStateException(
                    //"Receiver " + mReceiver +
                    //" registered with differing handler (was " +
                    //mActivityThread + " now " + activityThread + ")");
            //}
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.787 -0400", hash_original_method = "7C4E5EC981022D2A84B36FB6D93F7965", hash_generated_method = "45DED25E7D6415CE6834D2465ADF9164")
         IntentReceiverLeaked getLocation() {
IntentReceiverLeaked varC67D9EAB8F8C7974312627C3F915A447_247968394 =             mLocation;
            varC67D9EAB8F8C7974312627C3F915A447_247968394.addTaint(taint);
            return varC67D9EAB8F8C7974312627C3F915A447_247968394;
            // ---------- Original Method ----------
            //return mLocation;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.787 -0400", hash_original_method = "3C5B1FBD8D9CF893CD5AE57A3692C218", hash_generated_method = "9DD3EFCD0100ED33676F0D6DE9FA7D63")
         BroadcastReceiver getIntentReceiver() {
BroadcastReceiver var92BB1EAD1A7B04A11F11D488BE72928A_1781710728 =             mReceiver;
            var92BB1EAD1A7B04A11F11D488BE72928A_1781710728.addTaint(taint);
            return var92BB1EAD1A7B04A11F11D488BE72928A_1781710728;
            // ---------- Original Method ----------
            //return mReceiver;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.787 -0400", hash_original_method = "03FF6A1CE859C16292BB870D48D4B619", hash_generated_method = "895770F67F7325BBADD4312D4003665B")
         IIntentReceiver getIIntentReceiver() {
IIntentReceiver varA4B5D78F6F5CECCAA4D376A15BDA6253_457795698 =             mIIntentReceiver;
            varA4B5D78F6F5CECCAA4D376A15BDA6253_457795698.addTaint(taint);
            return varA4B5D78F6F5CECCAA4D376A15BDA6253_457795698;
            // ---------- Original Method ----------
            //return mIIntentReceiver;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.788 -0400", hash_original_method = "10021177327079B574AB9A39568AB468", hash_generated_method = "EA685C5A5E8161DEED20B24280A81655")
         void setUnregisterLocation(RuntimeException ex) {
            mUnregisterLocation = ex;
            // ---------- Original Method ----------
            //mUnregisterLocation = ex;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.788 -0400", hash_original_method = "BEFB4AE86DE2CF8202227FDF4968A841", hash_generated_method = "643621202B95BB787C68EC7EADA12877")
         RuntimeException getUnregisterLocation() {
RuntimeException var8A7CFC5E9175831B838BE224FA4022CA_2099969833 =             mUnregisterLocation;
            var8A7CFC5E9175831B838BE224FA4022CA_2099969833.addTaint(taint);
            return var8A7CFC5E9175831B838BE224FA4022CA_2099969833;
            // ---------- Original Method ----------
            //return mUnregisterLocation;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.789 -0400", hash_original_method = "39181D7F66A331F86FA5BEB0B1E79AC8", hash_generated_method = "5DCD273F0DD250F5935B073F8B6ED6FD")
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
            } //End block
            Args args = new Args(intent, resultCode, data, extras, ordered, sticky);
            if(!mActivityThread.post(args))            
            {
                if(mRegistered && ordered)                
                {
                    IActivityManager mgr = ActivityManagerNative.getDefault();
                    if(ActivityThread.DEBUG_BROADCAST){ }                    args.sendFinished(mgr);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (ActivityThread.DEBUG_BROADCAST) {
                //int seq = intent.getIntExtra("seq", -1);
                //Slog.i(ActivityThread.TAG, "Enqueueing broadcast " + intent.getAction() + " seq=" + seq
                        //+ " to " + mReceiver);
            //}
            //Args args = new Args(intent, resultCode, data, extras, ordered, sticky);
            //if (!mActivityThread.post(args)) {
                //if (mRegistered && ordered) {
                    //IActivityManager mgr = ActivityManagerNative.getDefault();
                    //if (ActivityThread.DEBUG_BROADCAST) Slog.i(ActivityThread.TAG,
                            //"Finishing sync broadcast to " + mReceiver);
                    //args.sendFinished(mgr);
                //}
            //}
        }

        
        final static class InnerReceiver extends IIntentReceiver.Stub {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.790 -0400", hash_original_field = "DBF05840F0B51F776B05018389E7959D", hash_generated_field = "721B40B341053DEDB330105D58454B08")

            WeakReference<LoadedApk.ReceiverDispatcher> mDispatcher;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.790 -0400", hash_original_field = "2F27BEAF9488F9111F7C68708453D2B0", hash_generated_field = "5A84F37BFD4FD2D8A7EC9111592CA64F")

            LoadedApk.ReceiverDispatcher mStrongRef;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.791 -0400", hash_original_method = "B5760C826128DD25E067AA5DC31216BE", hash_generated_method = "7ED6A19D2E31C049D4D81B46D7DDE02C")
              InnerReceiver(LoadedApk.ReceiverDispatcher rd, boolean strong) {
                mDispatcher = new WeakReference<LoadedApk.ReceiverDispatcher>(rd);
                mStrongRef = strong ? rd : null;
                // ---------- Original Method ----------
                //mDispatcher = new WeakReference<LoadedApk.ReceiverDispatcher>(rd);
                //mStrongRef = strong ? rd : null;
            }

            
                        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.792 -0400", hash_original_method = "79B1DBA6D83AA95E8B5316A9BF3831EB", hash_generated_method = "8742A5F5BC5AD1D45EDE259357C3CF5F")
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
                } //End block
                if(rd != null)                
                {
                    rd.performReceive(intent, resultCode, data, extras,
                            ordered, sticky);
                } //End block
                else
                {
                    if(ActivityThread.DEBUG_BROADCAST){ }                    IActivityManager mgr = ActivityManagerNative.getDefault();
                    try 
                    {
                        if(extras != null)                        
                        {
                            extras.setAllowFds(false);
                        } //End block
                        mgr.finishReceiver(this, resultCode, data, extras, false);
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                } //End block
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
        final class Args extends BroadcastReceiver.PendingResult implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.793 -0400", hash_original_field = "2B94A57B5324972078C949A0C39A6ED1", hash_generated_field = "BA12ECC45F316CCCFC0A85600BB7100C")

            private Intent mCurIntent;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.793 -0400", hash_original_field = "4A2BD4F8717C8C9A9172830E61B3F302", hash_generated_field = "345046B368470FC7DDE0CE76ADA9E345")

            private boolean mOrdered;
            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.794 -0400", hash_original_method = "6D86F310027103A2EE811DA0AC3AEAF2", hash_generated_method = "A5CC09E5EF80631E588BAE9283E2A5F5")
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
                // ---------- Original Method ----------
                //mCurIntent = intent;
                //mOrdered = ordered;
            }

            
                        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.795 -0400", hash_original_method = "55098A9F5CE8E783F44DA889D3A217EF", hash_generated_method = "0A26EEC2CFAAB5BB8298A543BB851A82")
            public void run() {
                final BroadcastReceiver receiver = mReceiver;
                final boolean ordered = mOrdered;
                if(ActivityThread.DEBUG_BROADCAST)                
                {
                    int seq = mCurIntent.getIntExtra("seq", -1);
                } //End block
                final IActivityManager mgr = ActivityManagerNative.getDefault();
                final Intent intent = mCurIntent;
                mCurIntent = null;
                if(receiver == null || mForgotten)                
                {
                    if(mRegistered && ordered)                    
                    {
                        if(ActivityThread.DEBUG_BROADCAST){ }                        sendFinished(mgr);
                    } //End block
                    return;
                } //End block
                try 
                {
                    ClassLoader cl = mReceiver.getClass().getClassLoader();
                    intent.setExtrasClassLoader(cl);
                    setExtrasClassLoader(cl);
                    receiver.setPendingResult(this);
                    receiver.onReceive(mContext, intent);
                } //End block
                catch (Exception e)
                {
                    if(mRegistered && ordered)                    
                    {
                        if(ActivityThread.DEBUG_BROADCAST){ }                        sendFinished(mgr);
                    } //End block
                    if(mInstrumentation == null ||
                            !mInstrumentation.onException(mReceiver, e))                    
                    {
                        RuntimeException var40F7CA19E2F234608DC910E20086B799_1029685640 = new RuntimeException(
                            "Error receiving broadcast " + intent
                            + " in " + mReceiver, e);
                        var40F7CA19E2F234608DC910E20086B799_1029685640.addTaint(taint);
                        throw var40F7CA19E2F234608DC910E20086B799_1029685640;
                    } //End block
                } //End block
                if(receiver.getPendingResult() != null)                
                {
                    finish();
                } //End block
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
    }


    
    static final class ServiceDispatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.797 -0400", hash_original_field = "35D1631BD5F54C58228B58CF9B2B9567", hash_generated_field = "6D6E935A66D24BF635EDCC1459563037")

        private ServiceDispatcher.InnerConnection mIServiceConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.797 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "8C1B7663112C8AB9CDFE3F970E8AC317")

        private ServiceConnection mConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.797 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.797 -0400", hash_original_field = "7EF90D5DA2994166B5492D71C1F03D41", hash_generated_field = "2AAC1DA9D0E4EE70937D612B5EF41A87")

        private Handler mActivityThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.797 -0400", hash_original_field = "36AEE7DB2B3FEF907E8DF98C14332655", hash_generated_field = "1364060D7B0CFDC7C7DE9BA3A9936610")

        private ServiceConnectionLeaked mLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.798 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

        private int mFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.798 -0400", hash_original_field = "B5483ADD630F45F3141FE19CCC5266F0", hash_generated_field = "2749116703DB7B9FDA806F989CF22E90")

        private RuntimeException mUnbindLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.798 -0400", hash_original_field = "6F0CC9619210C67027AB8589E234E033", hash_generated_field = "E7960A883D3F26E3E35C03E35CAA56E5")

        private boolean mDied;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.798 -0400", hash_original_field = "D983A9678CCC6771D873FE89E2CF0554", hash_generated_field = "5DE8D58700C695344224A4434DF9E91B")

        private boolean mForgotten;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.798 -0400", hash_original_field = "E0E57A26C882F5B2A0756F3AEB48708B", hash_generated_field = "B2C433E68D38D7E4C3190DDDA91A488A")

        private final HashMap<ComponentName, ServiceDispatcher.ConnectionInfo> mActiveConnections = new HashMap<ComponentName, ServiceDispatcher.ConnectionInfo>();
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.800 -0400", hash_original_method = "920453595DB1CAB2C546FB2B164C7405", hash_generated_method = "073F78DAF9C3E122B7B73EC693F89DCE")
          ServiceDispatcher(ServiceConnection conn,
                Context context, Handler activityThread, int flags) {
            mIServiceConnection = new InnerConnection(this);
            mConnection = conn;
            mContext = context;
            mActivityThread = activityThread;
            mLocation = new ServiceConnectionLeaked(null);
            mLocation.fillInStackTrace();
            mFlags = flags;
            // ---------- Original Method ----------
            //mIServiceConnection = new InnerConnection(this);
            //mConnection = conn;
            //mContext = context;
            //mActivityThread = activityThread;
            //mLocation = new ServiceConnectionLeaked(null);
            //mLocation.fillInStackTrace();
            //mFlags = flags;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.801 -0400", hash_original_method = "3A0AF1B483605B7B0302CA5F15EB7149", hash_generated_method = "C9A19B7083B7BDC8808374B75904FFCF")
         void validate(Context context, Handler activityThread) {
            addTaint(activityThread.getTaint());
            addTaint(context.getTaint());
            if(mContext != context)            
            {
                RuntimeException var276D5A680801B49D75643F3C371581E3_1156727633 = new RuntimeException(
                    "ServiceConnection " + mConnection +
                    " registered with differing Context (was " +
                    mContext + " now " + context + ")");
                var276D5A680801B49D75643F3C371581E3_1156727633.addTaint(taint);
                throw var276D5A680801B49D75643F3C371581E3_1156727633;
            } //End block
            if(mActivityThread != activityThread)            
            {
                RuntimeException var0772E178203849F775014B0FEE0977AA_895248757 = new RuntimeException(
                    "ServiceConnection " + mConnection +
                    " registered with differing handler (was " +
                    mActivityThread + " now " + activityThread + ")");
                var0772E178203849F775014B0FEE0977AA_895248757.addTaint(taint);
                throw var0772E178203849F775014B0FEE0977AA_895248757;
            } //End block
            // ---------- Original Method ----------
            //if (mContext != context) {
                //throw new RuntimeException(
                    //"ServiceConnection " + mConnection +
                    //" registered with differing Context (was " +
                    //mContext + " now " + context + ")");
            //}
            //if (mActivityThread != activityThread) {
                //throw new RuntimeException(
                    //"ServiceConnection " + mConnection +
                    //" registered with differing handler (was " +
                    //mActivityThread + " now " + activityThread + ")");
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.801 -0400", hash_original_method = "B423F38D9F2547626F9540342BA8FA08", hash_generated_method = "9248FAF4F67E1C2E8EF27D3CB97355F9")
         void doForget() {
            synchronized
(this)            {
                Iterator<ServiceDispatcher.ConnectionInfo> it = mActiveConnections.values().iterator();
                while
(it.hasNext())                
                {
                    ServiceDispatcher.ConnectionInfo ci = it.next();
                    ci.binder.unlinkToDeath(ci.deathMonitor, 0);
                } //End block
                mActiveConnections.clear();
                mForgotten = true;
            } //End block
            // ---------- Original Method ----------
            //synchronized(this) {
                //Iterator<ServiceDispatcher.ConnectionInfo> it = mActiveConnections.values().iterator();
                //while (it.hasNext()) {
                    //ServiceDispatcher.ConnectionInfo ci = it.next();
                    //ci.binder.unlinkToDeath(ci.deathMonitor, 0);
                //}
                //mActiveConnections.clear();
                //mForgotten = true;
            //}
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.802 -0400", hash_original_method = "DB6C3DBDD9CEB1EED1EE508C536B0201", hash_generated_method = "14C507DAAD5ACA819AABAA095C925FDC")
         ServiceConnectionLeaked getLocation() {
ServiceConnectionLeaked varC67D9EAB8F8C7974312627C3F915A447_360945086 =             mLocation;
            varC67D9EAB8F8C7974312627C3F915A447_360945086.addTaint(taint);
            return varC67D9EAB8F8C7974312627C3F915A447_360945086;
            // ---------- Original Method ----------
            //return mLocation;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.802 -0400", hash_original_method = "14318317B55D028C50F4E970D5AD5F89", hash_generated_method = "E3B94EF6CCFB8C035E0D6A92355BF6E4")
         ServiceConnection getServiceConnection() {
ServiceConnection var9818CDD0C0587BB48621EEA73B53E24D_199146307 =             mConnection;
            var9818CDD0C0587BB48621EEA73B53E24D_199146307.addTaint(taint);
            return var9818CDD0C0587BB48621EEA73B53E24D_199146307;
            // ---------- Original Method ----------
            //return mConnection;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.802 -0400", hash_original_method = "A871391E91E358F0260A3C41C2649BF6", hash_generated_method = "B7497D4290FEE24CA60436BCC4E6FD31")
         IServiceConnection getIServiceConnection() {
IServiceConnection var27A75AB4543CE8282280D637CBE787FC_401011767 =             mIServiceConnection;
            var27A75AB4543CE8282280D637CBE787FC_401011767.addTaint(taint);
            return var27A75AB4543CE8282280D637CBE787FC_401011767;
            // ---------- Original Method ----------
            //return mIServiceConnection;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.803 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "D02E8DD450240807EC294BEEB1A799B6")
         int getFlags() {
            int var9C3CD7D37D3E1E66BE9B3B005FC98B3A_950829255 = (mFlags);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562110398 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562110398;
            // ---------- Original Method ----------
            //return mFlags;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.803 -0400", hash_original_method = "CDEAAE2662154511545AF7B43E43329E", hash_generated_method = "460ACB65161A9381766EBD8AD8F65A14")
         void setUnbindLocation(RuntimeException ex) {
            mUnbindLocation = ex;
            // ---------- Original Method ----------
            //mUnbindLocation = ex;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.803 -0400", hash_original_method = "8CFC5DB6BE83E965DCFCD58443A1D896", hash_generated_method = "93759EEC6A54E5185D1C663DD372EFE0")
         RuntimeException getUnbindLocation() {
RuntimeException varA5DF9D25C5162A5017A33E2D2101D98E_1354732820 =             mUnbindLocation;
            varA5DF9D25C5162A5017A33E2D2101D98E_1354732820.addTaint(taint);
            return varA5DF9D25C5162A5017A33E2D2101D98E_1354732820;
            // ---------- Original Method ----------
            //return mUnbindLocation;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.803 -0400", hash_original_method = "F55B5D35A31C0C5BF103A9C597E0E30E", hash_generated_method = "DE39DBB4795232DF588BC41FDF3C368C")
        public void connected(ComponentName name, IBinder service) {
            addTaint(service.getTaint());
            addTaint(name.getTaint());
            if(mActivityThread != null)            
            {
                mActivityThread.post(new RunConnection(name, service, 0));
            } //End block
            else
            {
                doConnected(name, service);
            } //End block
            // ---------- Original Method ----------
            //if (mActivityThread != null) {
                //mActivityThread.post(new RunConnection(name, service, 0));
            //} else {
                //doConnected(name, service);
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.804 -0400", hash_original_method = "E6D57B0CCB9624E753F55A65AD088D17", hash_generated_method = "F642323C8769BF95CA0F3B66ED6A007F")
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
                } //End block
                old.binder.unlinkToDeath(old.deathMonitor, 0);
            } //End block
            if(mActivityThread != null)            
            {
                mActivityThread.post(new RunConnection(name, service, 1));
            } //End block
            else
            {
                doDeath(name, service);
            } //End block
            // ---------- Original Method ----------
            //ServiceDispatcher.ConnectionInfo old;
            //synchronized (this) {
                //mDied = true;
                //old = mActiveConnections.remove(name);
                //if (old == null || old.binder != service) {
                    //return;
                //}
                //old.binder.unlinkToDeath(old.deathMonitor, 0);
            //}
            //if (mActivityThread != null) {
                //mActivityThread.post(new RunConnection(name, service, 1));
            //} else {
                //doDeath(name, service);
            //}
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.806 -0400", hash_original_method = "4206BCB9948653D91B6930DF31631CB7", hash_generated_method = "1E32E7AA10D9916241BA02E8B6266A64")
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
                } //End block
                old = mActiveConnections.get(name);
                if(old != null && old.binder == service)                
                {
                    return;
                } //End block
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
                    } //End block
                    catch (RemoteException e)
                    {
                        mActiveConnections.remove(name);
                        return;
                    } //End block
                } //End block
                else
                {
                    mActiveConnections.remove(name);
                } //End block
                if(old != null)                
                {
                    old.binder.unlinkToDeath(old.deathMonitor, 0);
                } //End block
            } //End block
            if(old != null)            
            {
                mConnection.onServiceDisconnected(name);
            } //End block
            if(service != null)            
            {
                mConnection.onServiceConnected(name, service);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.807 -0400", hash_original_method = "71D95F8AA3DCAD1A788199BEC1658674", hash_generated_method = "B5AE943358CB2013FA301FCB5E6467F5")
        public void doDeath(ComponentName name, IBinder service) {
            addTaint(service.getTaint());
            addTaint(name.getTaint());
            mConnection.onServiceDisconnected(name);
            // ---------- Original Method ----------
            //mConnection.onServiceDisconnected(name);
        }

        
        private static class ConnectionInfo {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.808 -0400", hash_original_field = "5AE3422F7941E37EEB6D23CEF243C8CD", hash_generated_field = "FC5BAA062604D7264D40DD8AC68154EA")

            IBinder binder;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.808 -0400", hash_original_field = "D0A02B102A993DD010BC745EDCDCE48F", hash_generated_field = "256075ADF444DAFFF45701201F9B1B54")

            IBinder.DeathRecipient deathMonitor;
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.808 -0400", hash_original_method = "1536CD23A1F6D2B518F8B5E1999BC949", hash_generated_method = "1536CD23A1F6D2B518F8B5E1999BC949")
            public ConnectionInfo ()
            {
                //Synthesized constructor
            }


        }


        
        private static class InnerConnection extends IServiceConnection.Stub {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.808 -0400", hash_original_field = "DBF05840F0B51F776B05018389E7959D", hash_generated_field = "1DB9DDA8F9F99F15ABD03B8E39D3C3BD")

            WeakReference<LoadedApk.ServiceDispatcher> mDispatcher;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.808 -0400", hash_original_method = "A6B1961EAEFDBCFE8AB6AA462A76FB1E", hash_generated_method = "18D7336D44D6BB53573B2D2262A5B4C9")
              InnerConnection(LoadedApk.ServiceDispatcher sd) {
                mDispatcher = new WeakReference<LoadedApk.ServiceDispatcher>(sd);
                // ---------- Original Method ----------
                //mDispatcher = new WeakReference<LoadedApk.ServiceDispatcher>(sd);
            }

            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.809 -0400", hash_original_method = "A0C37377E0B0F4C4DBC15B0A2DE60194", hash_generated_method = "5C1D602208BF79CFAD5AE1177649A159")
            public void connected(ComponentName name, IBinder service) throws RemoteException {
                addTaint(service.getTaint());
                addTaint(name.getTaint());
                LoadedApk.ServiceDispatcher sd = mDispatcher.get();
                if(sd != null)                
                {
                    sd.connected(name, service);
                } //End block
                // ---------- Original Method ----------
                //LoadedApk.ServiceDispatcher sd = mDispatcher.get();
                //if (sd != null) {
                    //sd.connected(name, service);
                //}
            }

            
        }


        
        private final class RunConnection implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.809 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "A464C2842626F7EA212C2BFED22D6A29")

            ComponentName mName;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.809 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "CC72E7E45ED0871AEF8710E69E6BA621")

            IBinder mService;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.809 -0400", hash_original_field = "FFAC4B84C06F5C4992FFE77A4652384C", hash_generated_field = "2F175E88AE074D5006E1484402CDDE3D")

            int mCommand;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.810 -0400", hash_original_method = "D3073AFB5412B3DFB84E25D578A5A4E5", hash_generated_method = "7FB46199D601DFACEA45FD3E711142BF")
              RunConnection(ComponentName name, IBinder service, int command) {
                mName = name;
                mService = service;
                mCommand = command;
                // ---------- Original Method ----------
                //mName = name;
                //mService = service;
                //mCommand = command;
            }

            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.811 -0400", hash_original_method = "52DC970C8C1C8CA46B980F1341D6E54B", hash_generated_method = "BCC0664C96955B7C0406304A662C11A9")
            public void run() {
                if(mCommand == 0)                
                {
                    doConnected(mName, mService);
                } //End block
                else
                if(mCommand == 1)                
                {
                    doDeath(mName, mService);
                } //End block
                // ---------- Original Method ----------
                //if (mCommand == 0) {
                    //doConnected(mName, mService);
                //} else if (mCommand == 1) {
                    //doDeath(mName, mService);
                //}
            }

            
        }


        
        private final class DeathMonitor implements IBinder.DeathRecipient {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.811 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "A464C2842626F7EA212C2BFED22D6A29")

            ComponentName mName;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.811 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "CC72E7E45ED0871AEF8710E69E6BA621")

            IBinder mService;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.812 -0400", hash_original_method = "A53A82D1432A704C0ADCA8B12394294F", hash_generated_method = "F85D671C0C9B41C59CEF43BEC6BE417D")
              DeathMonitor(ComponentName name, IBinder service) {
                mName = name;
                mService = service;
                // ---------- Original Method ----------
                //mName = name;
                //mService = service;
            }

            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.812 -0400", hash_original_method = "C3027F39FC9400E0CBA13CC2A85E99EF", hash_generated_method = "D2777A8801A10D11246301F62E6436C0")
            public void binderDied() {
                death(mName, mService);
                // ---------- Original Method ----------
                //death(mName, mService);
            }

            
        }


        
    }


    
}

