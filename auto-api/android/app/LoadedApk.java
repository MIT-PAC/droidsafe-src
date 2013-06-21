package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.235 -0400", hash_original_method = "2DDF58935C7979F8233E5799714A3344", hash_generated_method = "90E299E6B0DD4681B0ED2FD913A4B35B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntentReceiverLeaked(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
}

final class ServiceConnectionLeaked extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.236 -0400", hash_original_method = "3AC977BF0FF33C844B89CE3E7B08E19C", hash_generated_method = "08626EBC20FBCC3613CC69A1929EBC1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceConnectionLeaked(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
}

public final class LoadedApk {
    private ActivityThread mActivityThread;
    private ApplicationInfo mApplicationInfo;
    String mPackageName;
    private String mAppDir;
    private String mResDir;
    private String[] mSharedLibraries;
    private String mDataDir;
    private String mLibDir;
    private File mDataDirFile;
    private ClassLoader mBaseClassLoader;
    private boolean mSecurityViolation;
    private boolean mIncludeCode;
    public CompatibilityInfoHolder mCompatibilityInfo = new CompatibilityInfoHolder();
    Resources mResources;
    private ClassLoader mClassLoader;
    private Application mApplication;
    private HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>> mReceivers
        = new HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>>();
    private HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>> mUnregisteredReceivers
    = new HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>>();
    private HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>> mServices
        = new HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>>();
    private HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>> mUnboundServices
        = new HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>>();
    int mClientCount = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.237 -0400", hash_original_method = "B0521F2A8F8912484DABAF70EB52FE24", hash_generated_method = "478F203AF3555306E8C6EEEEDA168450")
    @DSModeled(DSC.BAN)
    public LoadedApk(ActivityThread activityThread, ApplicationInfo aInfo,
            CompatibilityInfo compatInfo,
            ActivityThread mainThread, ClassLoader baseLoader,
            boolean securityViolation, boolean includeCode) {
        dsTaint.addTaint(securityViolation);
        dsTaint.addTaint(compatInfo.dsTaint);
        dsTaint.addTaint(includeCode);
        dsTaint.addTaint(mainThread.dsTaint);
        dsTaint.addTaint(aInfo.dsTaint);
        dsTaint.addTaint(baseLoader.dsTaint);
        dsTaint.addTaint(activityThread.dsTaint);
        mPackageName = aInfo.packageName;
        mAppDir = aInfo.sourceDir;
        mResDir = aInfo.uid == Process.myUid() ? aInfo.sourceDir
                : aInfo.publicSourceDir;
        mSharedLibraries = aInfo.sharedLibraryFiles;
        mDataDir = aInfo.dataDir;
        mDataDirFile = mDataDir != null ? new File(mDataDir) : null;
        mLibDir = aInfo.nativeLibraryDir;
        mCompatibilityInfo.set(compatInfo);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.237 -0400", hash_original_method = "208133E4566B7220D9D6A07C20B811D8", hash_generated_method = "5D36D52F3B83683ED79DFA40C611C418")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LoadedApk(ActivityThread activityThread, String name,
            Context systemContext, ApplicationInfo info, CompatibilityInfo compatInfo) {
        dsTaint.addTaint(systemContext.dsTaint);
        dsTaint.addTaint(compatInfo.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(info.dsTaint);
        dsTaint.addTaint(activityThread.dsTaint);
        mApplicationInfo = info != null ? info : new ApplicationInfo();
        mApplicationInfo.packageName = name;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.238 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "1E139B31C3EBB02F986E477E329136DD")
    @DSModeled(DSC.SAFE)
     Application getApplication() {
        return (Application)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mApplication;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.238 -0400", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "D4FBDE0F15761B9068941DC1F12E1D62")
    @DSModeled(DSC.SAFE)
    public String getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.239 -0400", hash_original_method = "69D4795DAE5563DBA773DE992713BBC9", hash_generated_method = "021ACD05778FD2F8CC52A1752FDE2371")
    @DSModeled(DSC.SAFE)
    public ApplicationInfo getApplicationInfo() {
        return (ApplicationInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mApplicationInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.239 -0400", hash_original_method = "1023CFFB5794A83B41C0A52D163AA3AF", hash_generated_method = "9206760BA8DDA923FB26722E5C46F323")
    @DSModeled(DSC.SAFE)
    public boolean isSecurityViolation() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSecurityViolation;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.240 -0400", hash_original_method = "98BA13F46ABDF03C557DAF40D6E3FC88", hash_generated_method = "63576A3859DBFF6E3BDEB3B73CF18BDE")
    @DSModeled(DSC.BAN)
    public ClassLoader getClassLoader() {
        {
            {
                boolean var296F17ADADF287FF92E97433DB7DF634_522337526 = (mIncludeCode && !mPackageName.equals("android"));
                {
                    String zip;
                    zip = mAppDir;
                    String instrumentationAppDir;
                    instrumentationAppDir = mActivityThread.mInstrumentationAppDir;
                    String instrumentationAppPackage;
                    instrumentationAppPackage = mActivityThread.mInstrumentationAppPackage;
                    String instrumentedAppDir;
                    instrumentedAppDir = mActivityThread.mInstrumentedAppDir;
                    String[] instrumentationLibs;
                    instrumentationLibs = null;
                    {
                        boolean var95281928A3723210196F3728BDFC5516_916857730 = (mAppDir.equals(instrumentationAppDir)
                        || mAppDir.equals(instrumentedAppDir));
                        {
                            zip = instrumentationAppDir + ":" + instrumentedAppDir;
                            {
                                boolean var38985C1C9A2B1CF58DF6A930664D4D62_1248560931 = (! instrumentedAppDir.equals(instrumentationAppDir));
                                {
                                    instrumentationLibs =
                            getLibrariesFor(instrumentationAppPackage);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    {
                        zip =
                        combineLibs(mSharedLibraries, instrumentationLibs)
                        + ':' + zip;
                    } //End block
                    StrictMode.ThreadPolicy oldPolicy;
                    oldPolicy = StrictMode.allowThreadDiskReads();
                    mClassLoader =
                    ApplicationLoaders.getDefault().getClassLoader(
                        zip, mLibDir, mBaseClassLoader);
                    initializeJavaContextClassLoader();
                    StrictMode.setThreadPolicy(oldPolicy);
                } //End block
                {
                    {
                        mClassLoader = ClassLoader.getSystemClassLoader();
                    } //End block
                    {
                        mClassLoader = mBaseClassLoader;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ClassLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.241 -0400", hash_original_method = "56AE7DDBC8B1739A2C59C89AA12BEB96", hash_generated_method = "4FA25BCD10D37ADCB3BC7441D0518273")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initializeJavaContextClassLoader() {
        IPackageManager pm;
        pm = ActivityThread.getPackageManager();
        android.content.pm.PackageInfo pi;
        try 
        {
            pi = pm.getPackageInfo(mPackageName, 0);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.241 -0400", hash_original_method = "DDE558C6C52D26591497F8CCA19E2D11", hash_generated_method = "26ECC91DE1D5E2DA6F3627420851C913")
    @DSModeled(DSC.SAFE)
    public String getAppDir() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mAppDir;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.242 -0400", hash_original_method = "1158BD50BBC4E4D9C9B8EC24E43A83EF", hash_generated_method = "3F70FBAE24DC9879A005B8A7924329A1")
    @DSModeled(DSC.SAFE)
    public String getResDir() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mResDir;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.242 -0400", hash_original_method = "5486D8CB07A0A494A33FE28373C3B14E", hash_generated_method = "94BAEFEAC3E3497C6959DBA84B4CF9B5")
    @DSModeled(DSC.SAFE)
    public String getDataDir() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDataDir;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.242 -0400", hash_original_method = "6FB19B7083E51C6FD4891C3DDE1600A5", hash_generated_method = "E1C966A5ABCDE1A80675F485D8C53F0E")
    @DSModeled(DSC.SAFE)
    public File getDataDirFile() {
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataDirFile;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.243 -0400", hash_original_method = "57B8CB1A3B484849D2245AC420407E2C", hash_generated_method = "3EB58D98CF5F4AB9EA91656ED78B87F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssetManager getAssets(ActivityThread mainThread) {
        dsTaint.addTaint(mainThread.dsTaint);
        AssetManager var4ECBE08AA1E9AB8FDCAB7758EF241B87_199431838 = (getResources(mainThread).getAssets());
        return (AssetManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getResources(mainThread).getAssets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.243 -0400", hash_original_method = "5E7B55611C44695241E7EB924E051C95", hash_generated_method = "6B981662FEA817CD29D127F3204DC4D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Resources getResources(ActivityThread mainThread) {
        dsTaint.addTaint(mainThread.dsTaint);
        {
            mResources = mainThread.getTopLevelResources(mResDir, this);
        } //End block
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mResources == null) {
            //mResources = mainThread.getTopLevelResources(mResDir, this);
        //}
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.244 -0400", hash_original_method = "F09CA6154241A46EB02B7FA7F64D8F80", hash_generated_method = "9B8C28466C7330D7F25EC5E2253AA636")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Application makeApplication(boolean forceDefaultAppClass,
            Instrumentation instrumentation) {
        dsTaint.addTaint(forceDefaultAppClass);
        dsTaint.addTaint(instrumentation.dsTaint);
        Application app;
        app = null;
        String appClass;
        appClass = mApplicationInfo.className;
        {
            appClass = "android.app.Application";
        } //End block
        try 
        {
            java.lang.ClassLoader cl;
            cl = getClassLoader();
            ContextImpl appContext;
            appContext = new ContextImpl();
            appContext.init(this, null, mActivityThread);
            app = mActivityThread.mInstrumentation.newApplication(
                    cl, appClass, appContext);
            appContext.setOuterContext(app);
        } //End block
        catch (Exception e)
        {
            {
                boolean var24338D5CA779D0D7608B19EED1172801_992661299 = (!mActivityThread.mInstrumentation.onException(app, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to instantiate application " + appClass
                    + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
        } //End block
        mActivityThread.mAllApplications.add(app);
        mApplication = app;
        {
            try 
            {
                instrumentation.callApplicationOnCreate(app);
            } //End block
            catch (Exception e)
            {
                {
                    boolean var4760B70FFAA788D24683ECFC8EF0BBEF_1488891822 = (!instrumentation.onException(app, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to create application " + app.getClass().getName()
                        + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (Application)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.245 -0400", hash_original_method = "B6291AD2FF4D11DEB13067F1AF687A9F", hash_generated_method = "D8971EE54F8A2DB0951186733A31BE9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeContextRegistrations(Context context,
            String who, String what) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(who);
        HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> rmap;
        rmap = mReceivers.remove(context);
        {
            Iterator<LoadedApk.ReceiverDispatcher> it;
            it = rmap.values().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1259350678 = (it.hasNext());
                {
                    LoadedApk.ReceiverDispatcher rd;
                    rd = it.next();
                    IntentReceiverLeaked leak;
                    leak = new IntentReceiverLeaked(
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
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        mUnregisteredReceivers.remove(context);
        HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> smap;
        smap = mServices.remove(context);
        {
            Iterator<LoadedApk.ServiceDispatcher> it;
            it = smap.values().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1209369606 = (it.hasNext());
                {
                    LoadedApk.ServiceDispatcher sd;
                    sd = it.next();
                    ServiceConnectionLeaked leak;
                    leak = new ServiceConnectionLeaked(
                        what + " " + who + " has leaked ServiceConnection "
                        + sd.getServiceConnection() + " that was originally bound here");
                    leak.setStackTrace(sd.getLocation().getStackTrace());
                    try 
                    {
                        ActivityManagerNative.getDefault().unbindService(
                            sd.getIServiceConnection());
                    } //End block
                    catch (RemoteException e)
                    { }
                    sd.doForget();
                } //End block
            } //End collapsed parenthetic
        } //End block
        mUnboundServices.remove(context);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.247 -0400", hash_original_method = "5954CD85EE6D69CD6AA4DB5D230A9DEB", hash_generated_method = "4BC4B1A968DC76B560630A37B934512B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IIntentReceiver getReceiverDispatcher(BroadcastReceiver r,
            Context context, Handler handler,
            Instrumentation instrumentation, boolean registered) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(registered);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(instrumentation.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        {
            LoadedApk.ReceiverDispatcher rd;
            rd = null;
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> map;
            map = null;
            {
                map = mReceivers.get(context);
                {
                    rd = map.get(r);
                } //End block
            } //End block
            {
                rd = new ReceiverDispatcher(r, context, handler,
                        instrumentation, registered);
                {
                    {
                        map = new HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>();
                        mReceivers.put(context, map);
                    } //End block
                    map.put(r, rd);
                } //End block
            } //End block
            {
                rd.validate(context, handler);
            } //End block
            rd.mForgotten = false;
            IIntentReceiver var0EB24BDC48AE24EAF3DE8F0372A00A7D_277013956 = (rd.getIIntentReceiver());
        } //End block
        return (IIntentReceiver)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.248 -0400", hash_original_method = "56318BD0308680C3BFA3A8E4B0CE4CF3", hash_generated_method = "54D58D6F0452C127A47F642E35B50264")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IIntentReceiver forgetReceiverDispatcher(Context context,
            BroadcastReceiver r) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        {
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> map;
            map = mReceivers.get(context);
            LoadedApk.ReceiverDispatcher rd;
            rd = null;
            {
                rd = map.get(r);
                {
                    map.remove(r);
                    {
                        boolean varF8AAF8C97EFC31F920EA8522BEF55B94_1850455696 = (map.size() == 0);
                        {
                            mReceivers.remove(context);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var3D8D85BD23AAFEAEB048FA5B5CD89650_1986770433 = (r.getDebugUnregister());
                        {
                            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> holder;
                            holder = mUnregisteredReceivers.get(context);
                            {
                                holder = new HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>();
                                mUnregisteredReceivers.put(context, holder);
                            } //End block
                            RuntimeException ex;
                            ex = new IllegalArgumentException(
                                "Originally unregistered here:");
                            ex.fillInStackTrace();
                            rd.setUnregisterLocation(ex);
                            holder.put(r, rd);
                        } //End block
                    } //End collapsed parenthetic
                    rd.mForgotten = true;
                    IIntentReceiver var81DED7DC144650B66D86B7777589DA6B_936156360 = (rd.getIIntentReceiver());
                } //End block
            } //End block
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> holder;
            holder = mUnregisteredReceivers.get(context);
            {
                rd = holder.get(r);
                {
                    RuntimeException ex;
                    ex = rd.getUnregisterLocation();
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                            "Unregistering Receiver " + r
                            + " that was already unregistered", ex);
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unbinding Receiver " + r
                        + " from Context that is no longer in use: " + context);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Receiver not registered: " + r);
            } //End block
        } //End block
        return (IIntentReceiver)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.249 -0400", hash_original_method = "D12EDE6D51B318B0614D5C86220B1198", hash_generated_method = "2465DB430037A0DB2F4B12B9C240D03F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IServiceConnection getServiceDispatcher(ServiceConnection c,
            Context context, Handler handler, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        {
            LoadedApk.ServiceDispatcher sd;
            sd = null;
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> map;
            map = mServices.get(context);
            {
                sd = map.get(c);
            } //End block
            {
                sd = new ServiceDispatcher(c, context, handler, flags);
                {
                    map = new HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>();
                    mServices.put(context, map);
                } //End block
                map.put(c, sd);
            } //End block
            {
                sd.validate(context, handler);
            } //End block
            IServiceConnection var5CDE9025C63C458A8E521F2AD31EDFD0_108548884 = (sd.getIServiceConnection());
        } //End block
        return (IServiceConnection)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.250 -0400", hash_original_method = "6B7C147E189191AFA124ECB6DFD3C546", hash_generated_method = "A712098EFD6AF5E08EAF1156EF08C437")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IServiceConnection forgetServiceDispatcher(Context context,
            ServiceConnection c) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        {
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> map;
            map = mServices.get(context);
            LoadedApk.ServiceDispatcher sd;
            sd = null;
            {
                sd = map.get(c);
                {
                    map.remove(c);
                    sd.doForget();
                    {
                        boolean varF8AAF8C97EFC31F920EA8522BEF55B94_990785834 = (map.size() == 0);
                        {
                            mServices.remove(context);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var07CAAA82623DD8F9BB6F63C5327EC905_1160114345 = ((sd.getFlags()&Context.BIND_DEBUG_UNBIND) != 0);
                        {
                            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> holder;
                            holder = mUnboundServices.get(context);
                            {
                                holder = new HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>();
                                mUnboundServices.put(context, holder);
                            } //End block
                            RuntimeException ex;
                            ex = new IllegalArgumentException(
                                "Originally unbound here:");
                            ex.fillInStackTrace();
                            sd.setUnbindLocation(ex);
                            holder.put(c, sd);
                        } //End block
                    } //End collapsed parenthetic
                    IServiceConnection var1FF1C66CBD6C4C5BC6611EF90FCF96B9_151672721 = (sd.getIServiceConnection());
                } //End block
            } //End block
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> holder;
            holder = mUnboundServices.get(context);
            {
                sd = holder.get(c);
                {
                    RuntimeException ex;
                    ex = sd.getUnbindLocation();
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                            "Unbinding Service " + c
                            + " that was already unbound", ex);
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unbinding Service " + c
                        + " from Context that is no longer in use: " + context);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Service not registered: " + c);
            } //End block
        } //End block
        return (IServiceConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class WarningContextClassLoader extends ClassLoader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.250 -0400", hash_original_method = "7FE79FF57622229536A1D9769E87D24A", hash_generated_method = "7FE79FF57622229536A1D9769E87D24A")
                public WarningContextClassLoader ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.251 -0400", hash_original_method = "2B0FE526CC8E82A351FDFDA472FB968C", hash_generated_method = "344189EB9C5722B44C2AC369E620E732")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void warn(String methodName) {
            dsTaint.addTaint(methodName);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.251 -0400", hash_original_method = "55A2C8B568742F6DD554B2AE8E06F675", hash_generated_method = "837D652F6AB68E650FA67547528244B5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public URL getResource(String resName) {
            dsTaint.addTaint(resName);
            warn("getResource");
            URL varB23BE85CF55405562AEE3F5C9801A778_1908870613 = (getParent().getResource(resName));
            return (URL)dsTaint.getTaint();
            // ---------- Original Method ----------
            //warn("getResource");
            //return getParent().getResource(resName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.253 -0400", hash_original_method = "7DF26E5478EB621EA7136B5331588545", hash_generated_method = "0F6F43B3F003DB41E80D05EACED342FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Enumeration<URL> getResources(String resName) throws IOException {
            dsTaint.addTaint(resName);
            warn("getResources");
            Enumeration<URL> var46A6CEF6AF28B38E5ECEC09FCDAD1330_1743135156 = (getParent().getResources(resName));
            return (Enumeration<URL>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //warn("getResources");
            //return getParent().getResources(resName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.255 -0400", hash_original_method = "43C39FB9AB0F69E37F9176951B93B129", hash_generated_method = "E837C14D4B779D69E451270556496CB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public InputStream getResourceAsStream(String resName) {
            dsTaint.addTaint(resName);
            warn("getResourceAsStream");
            InputStream var7E80D59C52F67E87BCE97A0BA60966EB_1748829929 = (getParent().getResourceAsStream(resName));
            return (InputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //warn("getResourceAsStream");
            //return getParent().getResourceAsStream(resName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.256 -0400", hash_original_method = "8B4C21AC14EA436FB72A6381E557B850", hash_generated_method = "A8384A34946FACFA663C26BFE1F42AFA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Class<?> loadClass(String className) throws ClassNotFoundException {
            dsTaint.addTaint(className);
            warn("loadClass");
            Class<?> varC619DB39E354F7ECD69FCD25F7D18B65_1737254005 = (getParent().loadClass(className));
            return (Class<?>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //warn("loadClass");
            //return getParent().loadClass(className);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.256 -0400", hash_original_method = "01BE45A57A3128BFD9BA3AF8CD4C6252", hash_generated_method = "F4EA3983324DD558AA1D559BB0CBF5E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setClassAssertionStatus(String cname, boolean enable) {
            dsTaint.addTaint(enable);
            dsTaint.addTaint(cname);
            warn("setClassAssertionStatus");
            getParent().setClassAssertionStatus(cname, enable);
            // ---------- Original Method ----------
            //warn("setClassAssertionStatus");
            //getParent().setClassAssertionStatus(cname, enable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.257 -0400", hash_original_method = "249CA030F95BF8C81AAAFF1521D1BE6E", hash_generated_method = "35209E09AA92AE46809E8EF00C92923D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setPackageAssertionStatus(String pname, boolean enable) {
            dsTaint.addTaint(enable);
            dsTaint.addTaint(pname);
            warn("setPackageAssertionStatus");
            getParent().setPackageAssertionStatus(pname, enable);
            // ---------- Original Method ----------
            //warn("setPackageAssertionStatus");
            //getParent().setPackageAssertionStatus(pname, enable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.257 -0400", hash_original_method = "AC5504AD86A01EA0D58ADDE41ADE6649", hash_generated_method = "2B8977E6A9EBCDBF3ECC7C9162AFD47A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setDefaultAssertionStatus(boolean enable) {
            dsTaint.addTaint(enable);
            warn("setDefaultAssertionStatus");
            getParent().setDefaultAssertionStatus(enable);
            // ---------- Original Method ----------
            //warn("setDefaultAssertionStatus");
            //getParent().setDefaultAssertionStatus(enable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.258 -0400", hash_original_method = "DA3A923351AC4881D1A9879A5FDE3ACD", hash_generated_method = "08B0AD50933BEFAE2DAF57BAEB1B35D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clearAssertionStatus() {
            warn("clearAssertionStatus");
            getParent().clearAssertionStatus();
            // ---------- Original Method ----------
            //warn("clearAssertionStatus");
            //getParent().clearAssertionStatus();
        }

        
        private static boolean warned = false;
    }


    
    static final class ReceiverDispatcher {
        IIntentReceiver.Stub mIIntentReceiver;
        BroadcastReceiver mReceiver;
        Context mContext;
        Handler mActivityThread;
        Instrumentation mInstrumentation;
        boolean mRegistered;
        IntentReceiverLeaked mLocation;
        RuntimeException mUnregisterLocation;
        boolean mForgotten;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.258 -0400", hash_original_method = "F99499486D66341875A2B920435493FE", hash_generated_method = "3C8A68DF25CD59275B99084E82B41D03")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ReceiverDispatcher(BroadcastReceiver receiver, Context context,
                Handler activityThread, Instrumentation instrumentation,
                boolean registered) {
            dsTaint.addTaint(receiver.dsTaint);
            dsTaint.addTaint(registered);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(instrumentation.dsTaint);
            dsTaint.addTaint(activityThread.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Handler must not be null");
            } //End block
            mIIntentReceiver = new InnerReceiver(this, !registered);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.259 -0400", hash_original_method = "83596DB1DD81575005BC364432EA62BE", hash_generated_method = "58E51C93769F81CD441B7BB653E6E545")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void validate(Context context, Handler activityThread) {
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(activityThread.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Receiver " + mReceiver +
                    " registered with differing Context (was " +
                    mContext + " now " + context + ")");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Receiver " + mReceiver +
                    " registered with differing handler (was " +
                    mActivityThread + " now " + activityThread + ")");
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.259 -0400", hash_original_method = "7C4E5EC981022D2A84B36FB6D93F7965", hash_generated_method = "3244790204C30BF391A30C09CEFC4980")
        @DSModeled(DSC.SAFE)
         IntentReceiverLeaked getLocation() {
            return (IntentReceiverLeaked)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mLocation;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.259 -0400", hash_original_method = "3C5B1FBD8D9CF893CD5AE57A3692C218", hash_generated_method = "6D397886407E7313CE46EBC3B2FA9B1B")
        @DSModeled(DSC.SAFE)
         BroadcastReceiver getIntentReceiver() {
            return (BroadcastReceiver)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mReceiver;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.260 -0400", hash_original_method = "03FF6A1CE859C16292BB870D48D4B619", hash_generated_method = "E839439419D6BB14F717F1BB0E7BB197")
        @DSModeled(DSC.SAFE)
         IIntentReceiver getIIntentReceiver() {
            return (IIntentReceiver)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mIIntentReceiver;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.260 -0400", hash_original_method = "10021177327079B574AB9A39568AB468", hash_generated_method = "DC66D7D0D4D247C2017EEBED1E6E86C3")
        @DSModeled(DSC.SAFE)
         void setUnregisterLocation(RuntimeException ex) {
            dsTaint.addTaint(ex.dsTaint);
            // ---------- Original Method ----------
            //mUnregisterLocation = ex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.262 -0400", hash_original_method = "BEFB4AE86DE2CF8202227FDF4968A841", hash_generated_method = "A1ACB68CFE9C5D1F4E152A2CF6B39895")
        @DSModeled(DSC.SAFE)
         RuntimeException getUnregisterLocation() {
            return (RuntimeException)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mUnregisterLocation;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.263 -0400", hash_original_method = "39181D7F66A331F86FA5BEB0B1E79AC8", hash_generated_method = "6895552E1AC2DC2BCD078208B9B013C0")
        @DSModeled(DSC.SPEC)
        public void performReceive(Intent intent, int resultCode,
                String data, Bundle extras, boolean ordered, boolean sticky) {
            dsTaint.addTaint(sticky);
            dsTaint.addTaint(ordered);
            dsTaint.addTaint(data);
            dsTaint.addTaint(resultCode);
            dsTaint.addTaint(intent.dsTaint);
            dsTaint.addTaint(extras.dsTaint);
            {
                int seq;
                seq = intent.getIntExtra("seq", -1);
            } //End block
            Args args;
            args = new Args(intent, resultCode, data, extras, ordered, sticky);
            {
                boolean var136D2EEA834070DC62C9F4EB9B7F3CE1_405845780 = (!mActivityThread.post(args));
                {
                    {
                        IActivityManager mgr;
                        mgr = ActivityManagerNative.getDefault();
                        args.sendFinished(mgr);
                    } //End block
                } //End block
            } //End collapsed parenthetic
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
            WeakReference<LoadedApk.ReceiverDispatcher> mDispatcher;
            LoadedApk.ReceiverDispatcher mStrongRef;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.263 -0400", hash_original_method = "B5760C826128DD25E067AA5DC31216BE", hash_generated_method = "28EA78561906DA37526460BDB6320D72")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             InnerReceiver(LoadedApk.ReceiverDispatcher rd, boolean strong) {
                dsTaint.addTaint(strong);
                dsTaint.addTaint(rd.dsTaint);
                mDispatcher = new WeakReference<LoadedApk.ReceiverDispatcher>(rd);
                mStrongRef = strong ? rd : null;
                // ---------- Original Method ----------
                //mDispatcher = new WeakReference<LoadedApk.ReceiverDispatcher>(rd);
                //mStrongRef = strong ? rd : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.264 -0400", hash_original_method = "79B1DBA6D83AA95E8B5316A9BF3831EB", hash_generated_method = "321A8308866B58516EA06AC74E061CD3")
            @DSModeled(DSC.SPEC)
            public void performReceive(Intent intent, int resultCode,
                    String data, Bundle extras, boolean ordered, boolean sticky) {
                dsTaint.addTaint(sticky);
                dsTaint.addTaint(ordered);
                dsTaint.addTaint(data);
                dsTaint.addTaint(resultCode);
                dsTaint.addTaint(intent.dsTaint);
                dsTaint.addTaint(extras.dsTaint);
                LoadedApk.ReceiverDispatcher rd;
                rd = mDispatcher.get();
                {
                    int seq;
                    seq = intent.getIntExtra("seq", -1);
                } //End block
                {
                    rd.performReceive(intent, resultCode, data, extras,
                            ordered, sticky);
                } //End block
                {
                    IActivityManager mgr;
                    mgr = ActivityManagerNative.getDefault();
                    try 
                    {
                        {
                            extras.setAllowFds(false);
                        } //End block
                        mgr.finishReceiver(this, resultCode, data, extras, false);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
        final class Args extends BroadcastReceiver.PendingResult implements Runnable {
            private Intent mCurIntent;
            private boolean mOrdered;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.264 -0400", hash_original_method = "6D86F310027103A2EE811DA0AC3AEAF2", hash_generated_method = "3E62B9A1FD20950E67660A6BC4E64DB2")
            @DSModeled(DSC.SPEC)
            public Args(Intent intent, int resultCode, String resultData, Bundle resultExtras,
                    boolean ordered, boolean sticky) {
                super(resultCode, resultData, resultExtras,
                        mRegistered ? TYPE_REGISTERED : TYPE_UNREGISTERED,
                        ordered, sticky, mIIntentReceiver.asBinder());
                dsTaint.addTaint(resultData);
                dsTaint.addTaint(sticky);
                dsTaint.addTaint(resultExtras.dsTaint);
                dsTaint.addTaint(ordered);
                dsTaint.addTaint(resultCode);
                dsTaint.addTaint(intent.dsTaint);
                // ---------- Original Method ----------
                //mCurIntent = intent;
                //mOrdered = ordered;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.265 -0400", hash_original_method = "55098A9F5CE8E783F44DA889D3A217EF", hash_generated_method = "11A3E60B97D7C20007EF5248257B97AE")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                BroadcastReceiver receiver;
                receiver = mReceiver;
                boolean ordered;
                ordered = mOrdered;
                {
                    int seq;
                    seq = mCurIntent.getIntExtra("seq", -1);
                } //End block
                IActivityManager mgr;
                mgr = ActivityManagerNative.getDefault();
                Intent intent;
                intent = mCurIntent;
                mCurIntent = null;
                {
                    {
                        sendFinished(mgr);
                    } //End block
                } //End block
                try 
                {
                    ClassLoader cl;
                    cl = mReceiver.getClass().getClassLoader();
                    intent.setExtrasClassLoader(cl);
                    setExtrasClassLoader(cl);
                    receiver.setPendingResult(this);
                    receiver.onReceive(mContext, intent);
                } //End block
                catch (Exception e)
                {
                    {
                        sendFinished(mgr);
                    } //End block
                    {
                        boolean varC6CBB185D8FC33400F94A19454A84101_1054039848 = (mInstrumentation == null ||
                            !mInstrumentation.onException(mReceiver, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Error receiving broadcast " + intent
                            + " in " + mReceiver, e);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var35461069F001822CDD45AC759932345D_238732387 = (receiver.getPendingResult() != null);
                    {
                        finish();
                    } //End block
                } //End collapsed parenthetic
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
    }


    
    static final class ServiceDispatcher {
        private ServiceDispatcher.InnerConnection mIServiceConnection;
        private ServiceConnection mConnection;
        private Context mContext;
        private Handler mActivityThread;
        private ServiceConnectionLeaked mLocation;
        private int mFlags;
        private RuntimeException mUnbindLocation;
        private boolean mDied;
        private boolean mForgotten;
        private HashMap<ComponentName, ServiceDispatcher.ConnectionInfo> mActiveConnections
            = new HashMap<ComponentName, ServiceDispatcher.ConnectionInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.266 -0400", hash_original_method = "920453595DB1CAB2C546FB2B164C7405", hash_generated_method = "5504E0CF07FA7FB08ADDBE3C03D84B39")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ServiceDispatcher(ServiceConnection conn,
                Context context, Handler activityThread, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(conn.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(activityThread.dsTaint);
            mIServiceConnection = new InnerConnection(this);
            mLocation = new ServiceConnectionLeaked(null);
            mLocation.fillInStackTrace();
            // ---------- Original Method ----------
            //mIServiceConnection = new InnerConnection(this);
            //mConnection = conn;
            //mContext = context;
            //mActivityThread = activityThread;
            //mLocation = new ServiceConnectionLeaked(null);
            //mLocation.fillInStackTrace();
            //mFlags = flags;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.266 -0400", hash_original_method = "3A0AF1B483605B7B0302CA5F15EB7149", hash_generated_method = "BB5AB010DEFDD3FC626400EE953057CD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void validate(Context context, Handler activityThread) {
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(activityThread.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "ServiceConnection " + mConnection +
                    " registered with differing Context (was " +
                    mContext + " now " + context + ")");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "ServiceConnection " + mConnection +
                    " registered with differing handler (was " +
                    mActivityThread + " now " + activityThread + ")");
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.267 -0400", hash_original_method = "B423F38D9F2547626F9540342BA8FA08", hash_generated_method = "8EEE56F131546FD9572988B8EA1E175A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void doForget() {
            {
                Iterator<ServiceDispatcher.ConnectionInfo> it;
                it = mActiveConnections.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1007987811 = (it.hasNext());
                    {
                        ServiceDispatcher.ConnectionInfo ci;
                        ci = it.next();
                        ci.binder.unlinkToDeath(ci.deathMonitor, 0);
                    } //End block
                } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.267 -0400", hash_original_method = "DB6C3DBDD9CEB1EED1EE508C536B0201", hash_generated_method = "9FDE03D672C5B5EB5E9FE0398660D403")
        @DSModeled(DSC.SAFE)
         ServiceConnectionLeaked getLocation() {
            return (ServiceConnectionLeaked)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mLocation;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.268 -0400", hash_original_method = "14318317B55D028C50F4E970D5AD5F89", hash_generated_method = "66947400D480BF763F4213A1E1BC4185")
        @DSModeled(DSC.SAFE)
         ServiceConnection getServiceConnection() {
            return (ServiceConnection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mConnection;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.268 -0400", hash_original_method = "A871391E91E358F0260A3C41C2649BF6", hash_generated_method = "A63BB188E2419367EB625FB96A06AF97")
        @DSModeled(DSC.SAFE)
         IServiceConnection getIServiceConnection() {
            return (IServiceConnection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mIServiceConnection;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.269 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "3BD7F4F74738C8E3A3CEDA0A64D0D451")
        @DSModeled(DSC.SAFE)
         int getFlags() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mFlags;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.269 -0400", hash_original_method = "CDEAAE2662154511545AF7B43E43329E", hash_generated_method = "D85B4C4545D98CDF4237200E57A5C20F")
        @DSModeled(DSC.SAFE)
         void setUnbindLocation(RuntimeException ex) {
            dsTaint.addTaint(ex.dsTaint);
            // ---------- Original Method ----------
            //mUnbindLocation = ex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.270 -0400", hash_original_method = "8CFC5DB6BE83E965DCFCD58443A1D896", hash_generated_method = "AE110E0D26573945382254BB29E0EE94")
        @DSModeled(DSC.SAFE)
         RuntimeException getUnbindLocation() {
            return (RuntimeException)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mUnbindLocation;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.270 -0400", hash_original_method = "F55B5D35A31C0C5BF103A9C597E0E30E", hash_generated_method = "93FFDA85CF675806172A72C5BB836149")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void connected(ComponentName name, IBinder service) {
            dsTaint.addTaint(name.dsTaint);
            dsTaint.addTaint(service.dsTaint);
            {
                mActivityThread.post(new RunConnection(name, service, 0));
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.271 -0400", hash_original_method = "E6D57B0CCB9624E753F55A65AD088D17", hash_generated_method = "058FD207CC477C1ECE343CD7D7AED7BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void death(ComponentName name, IBinder service) {
            dsTaint.addTaint(name.dsTaint);
            dsTaint.addTaint(service.dsTaint);
            ServiceDispatcher.ConnectionInfo old;
            {
                mDied = true;
                old = mActiveConnections.remove(name);
                old.binder.unlinkToDeath(old.deathMonitor, 0);
            } //End block
            {
                mActivityThread.post(new RunConnection(name, service, 1));
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.272 -0400", hash_original_method = "4206BCB9948653D91B6930DF31631CB7", hash_generated_method = "DD0229CB2F78E57115FDAD16DAA64293")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void doConnected(ComponentName name, IBinder service) {
            dsTaint.addTaint(name.dsTaint);
            dsTaint.addTaint(service.dsTaint);
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
                    } //End block
                    catch (RemoteException e)
                    {
                        mActiveConnections.remove(name);
                    } //End block
                } //End block
                {
                    mActiveConnections.remove(name);
                } //End block
                {
                    old.binder.unlinkToDeath(old.deathMonitor, 0);
                } //End block
            } //End block
            {
                mConnection.onServiceDisconnected(name);
            } //End block
            {
                mConnection.onServiceConnected(name, service);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.272 -0400", hash_original_method = "71D95F8AA3DCAD1A788199BEC1658674", hash_generated_method = "BEAFDD78F89F8EEAA5F58F2D68CF6362")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void doDeath(ComponentName name, IBinder service) {
            dsTaint.addTaint(name.dsTaint);
            dsTaint.addTaint(service.dsTaint);
            mConnection.onServiceDisconnected(name);
            // ---------- Original Method ----------
            //mConnection.onServiceDisconnected(name);
        }

        
        private static class ConnectionInfo {
            IBinder binder;
            IBinder.DeathRecipient deathMonitor;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.272 -0400", hash_original_method = "452163C3C275FE6A001C178C90B2B0D0", hash_generated_method = "452163C3C275FE6A001C178C90B2B0D0")
                        public ConnectionInfo ()
            {
            }


        }


        
        private static class InnerConnection extends IServiceConnection.Stub {
            WeakReference<LoadedApk.ServiceDispatcher> mDispatcher;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.273 -0400", hash_original_method = "A6B1961EAEFDBCFE8AB6AA462A76FB1E", hash_generated_method = "6D07F2FEC3B6AF8732448450EC4D1348")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             InnerConnection(LoadedApk.ServiceDispatcher sd) {
                dsTaint.addTaint(sd.dsTaint);
                mDispatcher = new WeakReference<LoadedApk.ServiceDispatcher>(sd);
                // ---------- Original Method ----------
                //mDispatcher = new WeakReference<LoadedApk.ServiceDispatcher>(sd);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.273 -0400", hash_original_method = "A0C37377E0B0F4C4DBC15B0A2DE60194", hash_generated_method = "3D951770E4D5D287D0402D2943A7E629")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void connected(ComponentName name, IBinder service) throws RemoteException {
                dsTaint.addTaint(name.dsTaint);
                dsTaint.addTaint(service.dsTaint);
                LoadedApk.ServiceDispatcher sd;
                sd = mDispatcher.get();
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
            ComponentName mName;
            IBinder mService;
            int mCommand;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.274 -0400", hash_original_method = "D3073AFB5412B3DFB84E25D578A5A4E5", hash_generated_method = "403C6D3B777C351F63E439C61287956C")
            @DSModeled(DSC.SAFE)
             RunConnection(ComponentName name, IBinder service, int command) {
                dsTaint.addTaint(name.dsTaint);
                dsTaint.addTaint(command);
                dsTaint.addTaint(service.dsTaint);
                // ---------- Original Method ----------
                //mName = name;
                //mService = service;
                //mCommand = command;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.275 -0400", hash_original_method = "52DC970C8C1C8CA46B980F1341D6E54B", hash_generated_method = "0FA2FB8F700D4E7E5628BF9F17EC1A0B")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                {
                    doConnected(mName, mService);
                } //End block
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
            ComponentName mName;
            IBinder mService;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.276 -0400", hash_original_method = "A53A82D1432A704C0ADCA8B12394294F", hash_generated_method = "96FE195FB39B8ED651753F02ECB8C939")
            @DSModeled(DSC.SAFE)
             DeathMonitor(ComponentName name, IBinder service) {
                dsTaint.addTaint(name.dsTaint);
                dsTaint.addTaint(service.dsTaint);
                // ---------- Original Method ----------
                //mName = name;
                //mService = service;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.277 -0400", hash_original_method = "C3027F39FC9400E0CBA13CC2A85E99EF", hash_generated_method = "D2777A8801A10D11246301F62E6436C0")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void binderDied() {
                death(mName, mService);
                // ---------- Original Method ----------
                //death(mName, mService);
            }

            
        }


        
    }


    
}

