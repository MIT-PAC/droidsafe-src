package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Slog;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.640 -0500", hash_original_method = "2DDF58935C7979F8233E5799714A3344", hash_generated_method = "69F237C15F5180743A61E16A9E689C19")
    
public IntentReceiverLeaked(String msg) {
        super(msg);
    }

    
}

final class ServiceConnectionLeaked extends AndroidRuntimeException {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.643 -0500", hash_original_method = "3AC977BF0FF33C844B89CE3E7B08E19C", hash_generated_method = "7480F101B640E4CBA8BD4C5E5C2D21BB")
    
public ServiceConnectionLeaked(String msg) {
        super(msg);
    }

    
}

public final class LoadedApk {

    /**
     * Gets the array of shared libraries that are listed as
     * used by the given package.
     *
     * @param packageName the name of the package (note: not its
     * file name)
     * @return null-ok; the array of shared libraries, each one
     * a fully-qualified path
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.710 -0500", hash_original_method = "9F0CDC49493CE48F4A52B91899A3A2A5", hash_generated_method = "A01F573F8646E53D4ABA5D753F28CB86")
    
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

    /**
     * Combines two arrays (of library names) such that they are
     * concatenated in order but are devoid of duplicates. The
     * result is a single string with the names of the libraries
     * separated by colons, or <code>null</code> if both lists
     * were <code>null</code> or empty.
     *
     * @param list1 null-ok; the first list
     * @param list2 null-ok; the second list
     * @return null-ok; the combination
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.713 -0500", hash_original_method = "7BE73C32984884B73E2CBD0093BD938F", hash_generated_method = "CAA74B85F92E70EE9F2DCD9983DD7A3A")
    
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

        // Only need to check for duplicates if list1 was non-empty.
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.647 -0500", hash_original_field = "B78253FB0F6A8AE9C3434DD384D8A838", hash_generated_field = "421BA2E15FA30D31BA5B63CB3A7B5B13")


    private  ActivityThread mActivityThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.649 -0500", hash_original_field = "53E7F236534820E587C70C7DF0584A56", hash_generated_field = "03043EB7A9D0FD1622717AEEB39E2C26")

    private  ApplicationInfo mApplicationInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.651 -0500", hash_original_field = "7A5990DF4A54BF373C395B6501E20B02", hash_generated_field = "7A5990DF4A54BF373C395B6501E20B02")

     String mPackageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.654 -0500", hash_original_field = "E9AD84533527D7FD430E1F190495F6E6", hash_generated_field = "E0A59288CBEC7FD799E8A337FACE1F5E")

    private  String mAppDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.656 -0500", hash_original_field = "9CBFFC74B2E8DB2A6DFAD2C0D7303627", hash_generated_field = "16A785049F12D1DFDF4F72387E1D9EFB")

    private  String mResDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.658 -0500", hash_original_field = "626D2483F586145F713AFA2CBB39BB96", hash_generated_field = "8FC8150480070F32937BA43631A0368E")

    private  String[] mSharedLibraries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.660 -0500", hash_original_field = "1A52EBC261342BE85F56648EA294E5B7", hash_generated_field = "DA139898E558B5B558E8C0728494F629")

    private  String mDataDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.662 -0500", hash_original_field = "006DAB376FB39ABD36881D1D03065757", hash_generated_field = "3DFB074D570DEA75E2F80D915A677796")

    private  String mLibDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.665 -0500", hash_original_field = "6D3E583E72C01E992FD56CAC2B6F9E4D", hash_generated_field = "6E40F983F9A90BA373BA4515E458568D")

    private  File mDataDirFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.667 -0500", hash_original_field = "75CD811EBF69DCE1AD7023238C9FA1E2", hash_generated_field = "DED5F167DA7D663ADC06A3550A4D7EA7")

    private  ClassLoader mBaseClassLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.669 -0500", hash_original_field = "4ADEF56061E7EF52D4572A3897109F55", hash_generated_field = "CCA7497D7EA5CC4EF77C1D70975F7273")

    private  boolean mSecurityViolation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.672 -0500", hash_original_field = "B8D848333B749D8850D002BA386E101F", hash_generated_field = "35E5468E0019AD697E9AE711BEDB4638")

    private  boolean mIncludeCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.674 -0500", hash_original_field = "E80A772D8D3EA2E573DDAF7EB1FFC20A", hash_generated_field = "EDE7B5DFCD04834664F3F3E07C36CD7D")

    public final CompatibilityInfoHolder mCompatibilityInfo = new CompatibilityInfoHolder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.676 -0500", hash_original_field = "8C221FB485568FEFC5ABDDF092AD743A", hash_generated_field = "8C221FB485568FEFC5ABDDF092AD743A")

    Resources mResources;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.678 -0500", hash_original_field = "C796B6EA08214602D7AD9664511F1AF7", hash_generated_field = "ABE17DFC947454E8F85FE66E61741F7A")

    private ClassLoader mClassLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.680 -0500", hash_original_field = "218A10E2C368F2E85F83EE2065C292CD", hash_generated_field = "53FA3553B85F7414D1C5F2C302FDEBF9")

    private Application mApplication;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.683 -0500", hash_original_field = "0A4432238F976FB7ACD5B70737D9960E", hash_generated_field = "DA02F0E61096FE1235CD218F7663F0B5")


    private final HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>> mReceivers
        = new HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.685 -0500", hash_original_field = "2555A38A50AD7E8596EDF6F296664ECA", hash_generated_field = "351CD2B4585AE8D79380314A857D1433")

    private final HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>> mUnregisteredReceivers
    = new HashMap<Context, HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.688 -0500", hash_original_field = "37E0667D24F10AD03E35B400DD2659F6", hash_generated_field = "1A0B5F333B7A8966A134CAF8AFAB489A")

    private final HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>> mServices
        = new HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.691 -0500", hash_original_field = "E8225082EF622A13DA9AA8FD3CDD454D", hash_generated_field = "86703A535EA1DE3F2DA9098AD90EB1AC")

    private final HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>> mUnboundServices
        = new HashMap<Context, HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.693 -0500", hash_original_field = "5AEC4BBC7EEA13395C3D634E331479A9", hash_generated_field = "5AEC4BBC7EEA13395C3D634E331479A9")


    int mClientCount = 0;

    /**
     * Create information about a new .apk
     *
     * NOTE: This constructor is called with ActivityThread's lock held,
     * so MUST NOT call back out to the activity manager.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.698 -0500", hash_original_method = "B0521F2A8F8912484DABAF70EB52FE24", hash_generated_method = "1EB73AD5CB555B51F15FFEB75A506F16")
    
public LoadedApk(ActivityThread activityThread, ApplicationInfo aInfo,
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

        if (mAppDir == null) {
            if (ActivityThread.mSystemContext == null) {
                ActivityThread.mSystemContext =
                    ContextImpl.createSystemContext(mainThread);
                ActivityThread.mSystemContext.getResources().updateConfiguration(
                         mainThread.getConfiguration(),
                         mainThread.getDisplayMetricsLocked(compatInfo, false),
                         compatInfo);
                //Slog.i(TAG, "Created system resources "
                //        + mSystemContext.getResources() + ": "
                //        + mSystemContext.getResources().getConfiguration());
            }
            mClassLoader = ActivityThread.mSystemContext.getClassLoader();
            mResources = ActivityThread.mSystemContext.getResources();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.702 -0500", hash_original_method = "208133E4566B7220D9D6A07C20B811D8", hash_generated_method = "54378CE651701DB6583F2EF6E36E883A")
    
public LoadedApk(ActivityThread activityThread, String name,
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.695 -0500", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "510D23D8CF054FDAE1D1426C6A1A1500")
    
Application getApplication() {
        return mApplication;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.704 -0500", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "BFA44CE53EBFEE02C805A4272C4E472E")
    
public String getPackageName() {
        return mPackageName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.706 -0500", hash_original_method = "69D4795DAE5563DBA773DE992713BBC9", hash_generated_method = "7F0398A41DC9BAAB9529D5DB0AEA6153")
    
public ApplicationInfo getApplicationInfo() {
        return mApplicationInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.708 -0500", hash_original_method = "1023CFFB5794A83B41C0A52D163AA3AF", hash_generated_method = "91C8D0159296FDDBDE1E7D5D494A84B0")
    
public boolean isSecurityViolation() {
        return mSecurityViolation;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.717 -0500", hash_original_method = "98BA13F46ABDF03C557DAF40D6E3FC88", hash_generated_method = "953337A0E00E54193CF6B112FED05300")
    
public ClassLoader getClassLoader() {
        synchronized (this) {
            if (mClassLoader != null) {
                return mClassLoader;
            }

            if (mIncludeCode && !mPackageName.equals("android")) {
                String zip = mAppDir;

                /*
                 * The following is a bit of a hack to inject
                 * instrumentation into the system: If the app
                 * being started matches one of the instrumentation names,
                 * then we combine both the "instrumentation" and
                 * "instrumented" app into the path, along with the
                 * concatenation of both apps' shared library lists.
                 */

                String instrumentationAppDir =
                        mActivityThread.mInstrumentationAppDir;
                String instrumentationAppPackage =
                        mActivityThread.mInstrumentationAppPackage;
                String instrumentedAppDir =
                        mActivityThread.mInstrumentedAppDir;
                String[] instrumentationLibs = null;

                if (mAppDir.equals(instrumentationAppDir)
                        || mAppDir.equals(instrumentedAppDir)) {
                    zip = instrumentationAppDir + ":" + instrumentedAppDir;
                    if (! instrumentedAppDir.equals(instrumentationAppDir)) {
                        instrumentationLibs =
                            getLibrariesFor(instrumentationAppPackage);
                    }
                }

                if ((mSharedLibraries != null) ||
                        (instrumentationLibs != null)) {
                    zip =
                        combineLibs(mSharedLibraries, instrumentationLibs)
                        + ':' + zip;
                }

                /*
                 * With all the combination done (if necessary, actually
                 * create the class loader.
                 */

                if (ActivityThread.localLOGV)
                    Slog.v(ActivityThread.TAG, "Class path: " + zip + ", JNI path: " + mLibDir);

                // Temporarily disable logging of disk reads on the Looper thread
                // as this is early and necessary.
                StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();

                mClassLoader =
                    ApplicationLoaders.getDefault().getClassLoader(
                        zip, mLibDir, mBaseClassLoader);
                initializeJavaContextClassLoader();

                StrictMode.setThreadPolicy(oldPolicy);
            } else {
                if (mBaseClassLoader == null) {
                    mClassLoader = ClassLoader.getSystemClassLoader();
                } else {
                    mClassLoader = mBaseClassLoader;
                }
            }
            return mClassLoader;
        }
    }

    /**
     * Setup value for Thread.getContextClassLoader(). If the
     * package will not run in in a VM with other packages, we set
     * the Java context ClassLoader to the
     * PackageInfo.getClassLoader value. However, if this VM can
     * contain multiple packages, we intead set the Java context
     * ClassLoader to a proxy that will warn about the use of Java
     * context ClassLoaders and then fall through to use the
     * system ClassLoader.
     *
     * <p> Note that this is similar to but not the same as the
     * android.content.Context.getClassLoader(). While both
     * context class loaders are typically set to the
     * PathClassLoader used to load the package archive in the
     * single application per VM case, a single Android process
     * may contain several Contexts executing on one thread with
     * their own logical ClassLoaders while the Java context
     * ClassLoader is a thread local. This is why in the case when
     * we have multiple packages per VM we do not set the Java
     * context ClassLoader to an arbitrary but instead warn the
     * user to set their own if we detect that they are using a
     * Java library that expects it to be set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.720 -0500", hash_original_method = "56AE7DDBC8B1739A2C59C89AA12BEB96", hash_generated_method = "C733DAA15C5D25B4291552423F457C43")
    
private void initializeJavaContextClassLoader() {
        IPackageManager pm = ActivityThread.getPackageManager();
        android.content.pm.PackageInfo pi;
        try {
            pi = pm.getPackageInfo(mPackageName, 0);
        } catch (RemoteException e) {
            throw new AssertionError(e);
        }
        /*
         * Two possible indications that this package could be
         * sharing its virtual machine with other packages:
         *
         * 1.) the sharedUserId attribute is set in the manifest,
         *     indicating a request to share a VM with other
         *     packages with the same sharedUserId.
         *
         * 2.) the application element of the manifest has an
         *     attribute specifying a non-default process name,
         *     indicating the desire to run in another packages VM.
         */
        boolean sharedUserIdSet = (pi.sharedUserId != null);
        boolean processNameNotDefault =
            (pi.applicationInfo != null &&
             !mPackageName.equals(pi.applicationInfo.processName));
        boolean sharable = (sharedUserIdSet || processNameNotDefault);
        ClassLoader contextClassLoader =
            (sharable)
            ? new WarningContextClassLoader()
            : mClassLoader;
        Thread.currentThread().setContextClassLoader(contextClassLoader);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.750 -0500", hash_original_method = "DDE558C6C52D26591497F8CCA19E2D11", hash_generated_method = "B0B211893A72839AF9558CA2B7715BD2")
    
public String getAppDir() {
        return mAppDir;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.752 -0500", hash_original_method = "1158BD50BBC4E4D9C9B8EC24E43A83EF", hash_generated_method = "B2B372D7F52067CDFAB5B42374E9F643")
    
public String getResDir() {
        return mResDir;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.755 -0500", hash_original_method = "5486D8CB07A0A494A33FE28373C3B14E", hash_generated_method = "4566CD0F3629082CC0B8982A9C307F5C")
    
public String getDataDir() {
        return mDataDir;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.757 -0500", hash_original_method = "6FB19B7083E51C6FD4891C3DDE1600A5", hash_generated_method = "FC31E829E2B3954A92ADCBEDEC1CFD01")
    
public File getDataDirFile() {
        return mDataDirFile;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.759 -0500", hash_original_method = "57B8CB1A3B484849D2245AC420407E2C", hash_generated_method = "BD4F7C1FC798493386F7E0FAB4CBE79C")
    
public AssetManager getAssets(ActivityThread mainThread) {
        return getResources(mainThread).getAssets();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.762 -0500", hash_original_method = "5E7B55611C44695241E7EB924E051C95", hash_generated_method = "746F76282F50386A6927C163B3946BB7")
    
public Resources getResources(ActivityThread mainThread) {
        if (mResources == null) {
            mResources = mainThread.getTopLevelResources(mResDir, this);
        }
        return mResources;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.765 -0500", hash_original_method = "F09CA6154241A46EB02B7FA7F64D8F80", hash_generated_method = "F8AE6697E63ABA2D01A60B3DFB64634A")
    
public Application makeApplication(boolean forceDefaultAppClass,
            Instrumentation instrumentation) {
        if (mApplication != null) {
            return mApplication;
        }

        Application app = null;

        String appClass = mApplicationInfo.className;
        if (forceDefaultAppClass || (appClass == null)) {
            appClass = "android.app.Application";
        }

        try {
            java.lang.ClassLoader cl = getClassLoader();
            ContextImpl appContext = new ContextImpl();
            appContext.init(this, null, mActivityThread);
            app = mActivityThread.mInstrumentation.newApplication(
                    cl, appClass, appContext);
            appContext.setOuterContext(app);
        } catch (Exception e) {
            if (!mActivityThread.mInstrumentation.onException(app, e)) {
                throw new RuntimeException(
                    "Unable to instantiate application " + appClass
                    + ": " + e.toString(), e);
            }
        }
        mActivityThread.mAllApplications.add(app);
        mApplication = app;

        if (instrumentation != null) {
            try {
                instrumentation.callApplicationOnCreate(app);
            } catch (Exception e) {
                if (!instrumentation.onException(app, e)) {
                    throw new RuntimeException(
                        "Unable to create application " + app.getClass().getName()
                        + ": " + e.toString(), e);
                }
            }
        }
        
        return app;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.768 -0500", hash_original_method = "B6291AD2FF4D11DEB13067F1AF687A9F", hash_generated_method = "57CA402E9B60F370F9887138E4A566B9")
    
public void removeContextRegistrations(Context context,
            String who, String what) {
        HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> rmap =
            mReceivers.remove(context);
        if (rmap != null) {
            Iterator<LoadedApk.ReceiverDispatcher> it = rmap.values().iterator();
            while (it.hasNext()) {
                LoadedApk.ReceiverDispatcher rd = it.next();
                IntentReceiverLeaked leak = new IntentReceiverLeaked(
                        what + " " + who + " has leaked IntentReceiver "
                        + rd.getIntentReceiver() + " that was " +
                        "originally registered here. Are you missing a " +
                        "call to unregisterReceiver()?");
                leak.setStackTrace(rd.getLocation().getStackTrace());
                Slog.e(ActivityThread.TAG, leak.getMessage(), leak);
                try {
                    ActivityManagerNative.getDefault().unregisterReceiver(
                            rd.getIIntentReceiver());
                } catch (RemoteException e) {
                    // system crashed, nothing we can do
                }
            }
        }
        mUnregisteredReceivers.remove(context);
        //Slog.i(TAG, "Receiver registrations: " + mReceivers);
        HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> smap =
            mServices.remove(context);
        if (smap != null) {
            Iterator<LoadedApk.ServiceDispatcher> it = smap.values().iterator();
            while (it.hasNext()) {
                LoadedApk.ServiceDispatcher sd = it.next();
                ServiceConnectionLeaked leak = new ServiceConnectionLeaked(
                        what + " " + who + " has leaked ServiceConnection "
                        + sd.getServiceConnection() + " that was originally bound here");
                leak.setStackTrace(sd.getLocation().getStackTrace());
                Slog.e(ActivityThread.TAG, leak.getMessage(), leak);
                try {
                    ActivityManagerNative.getDefault().unbindService(
                            sd.getIServiceConnection());
                } catch (RemoteException e) {
                    // system crashed, nothing we can do
                }
                sd.doForget();
            }
        }
        mUnboundServices.remove(context);
        //Slog.i(TAG, "Service registrations: " + mServices);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.771 -0500", hash_original_method = "5954CD85EE6D69CD6AA4DB5D230A9DEB", hash_generated_method = "120226E1518DDD1EFEE5A31829FD13CF")
    
public IIntentReceiver getReceiverDispatcher(BroadcastReceiver r,
            Context context, Handler handler,
            Instrumentation instrumentation, boolean registered) {
        synchronized (mReceivers) {
            LoadedApk.ReceiverDispatcher rd = null;
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> map = null;
            if (registered) {
                map = mReceivers.get(context);
                if (map != null) {
                    rd = map.get(r);
                }
            }
            if (rd == null) {
                rd = new ReceiverDispatcher(r, context, handler,
                        instrumentation, registered);
                if (registered) {
                    if (map == null) {
                        map = new HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher>();
                        mReceivers.put(context, map);
                    }
                    map.put(r, rd);
                }
            } else {
                rd.validate(context, handler);
            }
            rd.mForgotten = false;
            return rd.getIIntentReceiver();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.774 -0500", hash_original_method = "56318BD0308680C3BFA3A8E4B0CE4CF3", hash_generated_method = "0EE4789D0AC3A8E5A849759422D00C6F")
    
public IIntentReceiver forgetReceiverDispatcher(Context context,
            BroadcastReceiver r) {
        synchronized (mReceivers) {
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> map = mReceivers.get(context);
            LoadedApk.ReceiverDispatcher rd = null;
            if (map != null) {
                rd = map.get(r);
                if (rd != null) {
                    map.remove(r);
                    if (map.size() == 0) {
                        mReceivers.remove(context);
                    }
                    if (r.getDebugUnregister()) {
                        HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> holder
                                = mUnregisteredReceivers.get(context);
                        if (holder == null) {
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
                    return rd.getIIntentReceiver();
                }
            }
            HashMap<BroadcastReceiver, LoadedApk.ReceiverDispatcher> holder
                    = mUnregisteredReceivers.get(context);
            if (holder != null) {
                rd = holder.get(r);
                if (rd != null) {
                    RuntimeException ex = rd.getUnregisterLocation();
                    throw new IllegalArgumentException(
                            "Unregistering Receiver " + r
                            + " that was already unregistered", ex);
                }
            }
            if (context == null) {
                throw new IllegalStateException("Unbinding Receiver " + r
                        + " from Context that is no longer in use: " + context);
            } else {
                throw new IllegalArgumentException("Receiver not registered: " + r);
            }

        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.851 -0500", hash_original_method = "D12EDE6D51B318B0614D5C86220B1198", hash_generated_method = "758E1E806A8730AD611C0EC6EEFF3937")
    
public final IServiceConnection getServiceDispatcher(ServiceConnection c,
            Context context, Handler handler, int flags) {
        synchronized (mServices) {
            LoadedApk.ServiceDispatcher sd = null;
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> map = mServices.get(context);
            if (map != null) {
                sd = map.get(c);
            }
            if (sd == null) {
                sd = new ServiceDispatcher(c, context, handler, flags);
                if (map == null) {
                    map = new HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>();
                    mServices.put(context, map);
                }
                map.put(c, sd);
            } else {
                sd.validate(context, handler);
            }
            return sd.getIServiceConnection();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.855 -0500", hash_original_method = "6B7C147E189191AFA124ECB6DFD3C546", hash_generated_method = "016E4F7006C87B536F1D18D98EF600E1")
    
public final IServiceConnection forgetServiceDispatcher(Context context,
            ServiceConnection c) {
        synchronized (mServices) {
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> map
                    = mServices.get(context);
            LoadedApk.ServiceDispatcher sd = null;
            if (map != null) {
                sd = map.get(c);
                if (sd != null) {
                    map.remove(c);
                    sd.doForget();
                    if (map.size() == 0) {
                        mServices.remove(context);
                    }
                    if ((sd.getFlags()&Context.BIND_DEBUG_UNBIND) != 0) {
                        HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> holder
                                = mUnboundServices.get(context);
                        if (holder == null) {
                            holder = new HashMap<ServiceConnection, LoadedApk.ServiceDispatcher>();
                            mUnboundServices.put(context, holder);
                        }
                        RuntimeException ex = new IllegalArgumentException(
                                "Originally unbound here:");
                        ex.fillInStackTrace();
                        sd.setUnbindLocation(ex);
                        holder.put(c, sd);
                    }
                    return sd.getIServiceConnection();
                }
            }
            HashMap<ServiceConnection, LoadedApk.ServiceDispatcher> holder
                    = mUnboundServices.get(context);
            if (holder != null) {
                sd = holder.get(c);
                if (sd != null) {
                    RuntimeException ex = sd.getUnbindLocation();
                    throw new IllegalArgumentException(
                            "Unbinding Service " + c
                            + " that was already unbound", ex);
                }
            }
            if (context == null) {
                throw new IllegalStateException("Unbinding Service " + c
                        + " from Context that is no longer in use: " + context);
            } else {
                throw new IllegalArgumentException("Service not registered: " + c);
            }
        }
    }

    
    private static class WarningContextClassLoader extends ClassLoader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.723 -0500", hash_original_field = "420BA71627E89190BAB1B4A156A5B266", hash_generated_field = "18C8FDAD6849519506E4721838FB6A98")


        private static boolean warned = false;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.778 -0400", hash_original_method = "97527CB182747C5C8FA8F44BB3951504", hash_generated_method = "97527CB182747C5C8FA8F44BB3951504")
        public WarningContextClassLoader ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.725 -0500", hash_original_method = "2B0FE526CC8E82A351FDFDA472FB968C", hash_generated_method = "9BFEC9B66B809D428A26ED4455607820")
        
private void warn(String methodName) {
            if (warned) {
                return;
            }
            warned = true;
            Thread.currentThread().setContextClassLoader(getParent());
            Slog.w(ActivityThread.TAG, "ClassLoader." + methodName + ": " +
                  "The class loader returned by " +
                  "Thread.getContextClassLoader() may fail for processes " +
                  "that host multiple applications. You should explicitly " +
                  "specify a context class loader. For example: " +
                  "Thread.setContextClassLoader(getClass().getClassLoader());");
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.727 -0500", hash_original_method = "55A2C8B568742F6DD554B2AE8E06F675", hash_generated_method = "8BDA593388D375AFBD51C9221A43EB03")
        
@Override public URL getResource(String resName) {
            warn("getResource");
            return getParent().getResource(resName);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.730 -0500", hash_original_method = "7DF26E5478EB621EA7136B5331588545", hash_generated_method = "53EAE112CC13812D1E1211C5DE531D2B")
        
@Override public Enumeration<URL> getResources(String resName) throws IOException {
            warn("getResources");
            return getParent().getResources(resName);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.732 -0500", hash_original_method = "43C39FB9AB0F69E37F9176951B93B129", hash_generated_method = "1288CA50B3EDCE616E702D0DA3B2CBB0")
        
@Override public InputStream getResourceAsStream(String resName) {
            warn("getResourceAsStream");
            return getParent().getResourceAsStream(resName);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.736 -0500", hash_original_method = "8B4C21AC14EA436FB72A6381E557B850", hash_generated_method = "91FCE81986E2A452AC10D1CF8743BE2C")
        
@Override public Class<?> loadClass(String className) throws ClassNotFoundException {
            warn("loadClass");
            return getParent().loadClass(className);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.738 -0500", hash_original_method = "01BE45A57A3128BFD9BA3AF8CD4C6252", hash_generated_method = "BF415C3CF9ECFB7B137B6897F9134DD0")
        
@Override public void setClassAssertionStatus(String cname, boolean enable) {
            warn("setClassAssertionStatus");
            getParent().setClassAssertionStatus(cname, enable);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.741 -0500", hash_original_method = "249CA030F95BF8C81AAAFF1521D1BE6E", hash_generated_method = "F79FC83ADB0E60FAC5CB5CC924399EF7")
        
@Override public void setPackageAssertionStatus(String pname, boolean enable) {
            warn("setPackageAssertionStatus");
            getParent().setPackageAssertionStatus(pname, enable);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.743 -0500", hash_original_method = "AC5504AD86A01EA0D58ADDE41ADE6649", hash_generated_method = "E667FA2AC5E0EE291EEE09CD7C14D092")
        
@Override public void setDefaultAssertionStatus(boolean enable) {
            warn("setDefaultAssertionStatus");
            getParent().setDefaultAssertionStatus(enable);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.746 -0500", hash_original_method = "DA3A923351AC4881D1A9879A5FDE3ACD", hash_generated_method = "57D726E532ACB890426D4A90ED61FEFE")
        
@Override public void clearAssertionStatus() {
            warn("clearAssertionStatus");
            getParent().clearAssertionStatus();
        }
    }


    
    static final class ReceiverDispatcher {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.791 -0500", hash_original_field = "0D585D8E93CD584D754FB90606C97421", hash_generated_field = "0D585D8E93CD584D754FB90606C97421")


         IIntentReceiver.Stub mIIntentReceiver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.793 -0500", hash_original_field = "82183838DCCDFF42E01D0AB1ACA812C8", hash_generated_field = "82183838DCCDFF42E01D0AB1ACA812C8")

         BroadcastReceiver mReceiver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.796 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

         Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.798 -0500", hash_original_field = "12988E1FACD6824BE75454D0A2A06532", hash_generated_field = "12988E1FACD6824BE75454D0A2A06532")

         Handler mActivityThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.801 -0500", hash_original_field = "5CBE0F2EE224A7AD181F35AE16EC5D56", hash_generated_field = "5CBE0F2EE224A7AD181F35AE16EC5D56")

         Instrumentation mInstrumentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.803 -0500", hash_original_field = "27276507FEAABA21DEE60596F4D3812E", hash_generated_field = "27276507FEAABA21DEE60596F4D3812E")

         boolean mRegistered;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.805 -0500", hash_original_field = "C98CBB12EA09B3E51E00663E4E7ECBEF", hash_generated_field = "C98CBB12EA09B3E51E00663E4E7ECBEF")

         IntentReceiverLeaked mLocation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.808 -0500", hash_original_field = "080C297D2B34319904E59C288FE1CB54", hash_generated_field = "080C297D2B34319904E59C288FE1CB54")

        RuntimeException mUnregisterLocation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.810 -0500", hash_original_field = "8A69ACD90223C7C20F66A3AFE6F53D2F", hash_generated_field = "8A69ACD90223C7C20F66A3AFE6F53D2F")

        boolean mForgotten;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.828 -0500", hash_original_method = "F99499486D66341875A2B920435493FE", hash_generated_method = "F99499486D66341875A2B920435493FE")
        
ReceiverDispatcher(BroadcastReceiver receiver, Context context,
                Handler activityThread, Instrumentation instrumentation,
                boolean registered) {
            if (activityThread == null) {
                throw new NullPointerException("Handler must not be null");
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.831 -0500", hash_original_method = "83596DB1DD81575005BC364432EA62BE", hash_generated_method = "83596DB1DD81575005BC364432EA62BE")
        
void validate(Context context, Handler activityThread) {
            if (mContext != context) {
                throw new IllegalStateException(
                    "Receiver " + mReceiver +
                    " registered with differing Context (was " +
                    mContext + " now " + context + ")");
            }
            if (mActivityThread != activityThread) {
                throw new IllegalStateException(
                    "Receiver " + mReceiver +
                    " registered with differing handler (was " +
                    mActivityThread + " now " + activityThread + ")");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.833 -0500", hash_original_method = "7C4E5EC981022D2A84B36FB6D93F7965", hash_generated_method = "7C4E5EC981022D2A84B36FB6D93F7965")
        
IntentReceiverLeaked getLocation() {
            return mLocation;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.835 -0500", hash_original_method = "3C5B1FBD8D9CF893CD5AE57A3692C218", hash_generated_method = "3C5B1FBD8D9CF893CD5AE57A3692C218")
        
BroadcastReceiver getIntentReceiver() {
            return mReceiver;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.837 -0500", hash_original_method = "03FF6A1CE859C16292BB870D48D4B619", hash_generated_method = "03FF6A1CE859C16292BB870D48D4B619")
        
IIntentReceiver getIIntentReceiver() {
            return mIIntentReceiver;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.839 -0500", hash_original_method = "10021177327079B574AB9A39568AB468", hash_generated_method = "10021177327079B574AB9A39568AB468")
        
void setUnregisterLocation(RuntimeException ex) {
            mUnregisterLocation = ex;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.841 -0500", hash_original_method = "BEFB4AE86DE2CF8202227FDF4968A841", hash_generated_method = "BEFB4AE86DE2CF8202227FDF4968A841")
        
RuntimeException getUnregisterLocation() {
            return mUnregisterLocation;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.844 -0500", hash_original_method = "39181D7F66A331F86FA5BEB0B1E79AC8", hash_generated_method = "00D00294D6488836A87F417A73BC9D8B")
        
public void performReceive(Intent intent, int resultCode,
                String data, Bundle extras, boolean ordered, boolean sticky) {
            if (ActivityThread.DEBUG_BROADCAST) {
                int seq = intent.getIntExtra("seq", -1);
                Slog.i(ActivityThread.TAG, "Enqueueing broadcast " + intent.getAction() + " seq=" + seq
                        + " to " + mReceiver);
            }
            Args args = new Args(intent, resultCode, data, extras, ordered, sticky);
            if (!mActivityThread.post(args)) {
                if (mRegistered && ordered) {
                    IActivityManager mgr = ActivityManagerNative.getDefault();
                    if (ActivityThread.DEBUG_BROADCAST) Slog.i(ActivityThread.TAG,
                            "Finishing sync broadcast to " + mReceiver);
                    args.sendFinished(mgr);
                }
            }
        }

        
        final static class InnerReceiver extends IIntentReceiver.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.778 -0500", hash_original_field = "721B40B341053DEDB330105D58454B08", hash_generated_field = "721B40B341053DEDB330105D58454B08")

             WeakReference<LoadedApk.ReceiverDispatcher> mDispatcher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.780 -0500", hash_original_field = "5A84F37BFD4FD2D8A7EC9111592CA64F", hash_generated_field = "5A84F37BFD4FD2D8A7EC9111592CA64F")

             LoadedApk.ReceiverDispatcher mStrongRef;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.783 -0500", hash_original_method = "B5760C826128DD25E067AA5DC31216BE", hash_generated_method = "B5760C826128DD25E067AA5DC31216BE")
            
InnerReceiver(LoadedApk.ReceiverDispatcher rd, boolean strong) {
                mDispatcher = new WeakReference<LoadedApk.ReceiverDispatcher>(rd);
                mStrongRef = strong ? rd : null;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.787 -0500", hash_original_method = "79B1DBA6D83AA95E8B5316A9BF3831EB", hash_generated_method = "BD8303E593F3530D7D69BDE46ED707C0")
            
public void performReceive(Intent intent, int resultCode,
                    String data, Bundle extras, boolean ordered, boolean sticky) {
                LoadedApk.ReceiverDispatcher rd = mDispatcher.get();
                if (ActivityThread.DEBUG_BROADCAST) {
                    int seq = intent.getIntExtra("seq", -1);
                    Slog.i(ActivityThread.TAG, "Receiving broadcast " + intent.getAction() + " seq=" + seq
                            + " to " + (rd != null ? rd.mReceiver : null));
                }
                if (rd != null) {
                    rd.performReceive(intent, resultCode, data, extras,
                            ordered, sticky);
                } else {
                    // The activity manager dispatched a broadcast to a registered
                    // receiver in this process, but before it could be delivered the
                    // receiver was unregistered.  Acknowledge the broadcast on its
                    // behalf so that the system's broadcast sequence can continue.
                    if (ActivityThread.DEBUG_BROADCAST) Slog.i(ActivityThread.TAG,
                            "Finishing broadcast to unregistered receiver");
                    IActivityManager mgr = ActivityManagerNative.getDefault();
                    try {
                        if (extras != null) {
                            extras.setAllowFds(false);
                        }
                        mgr.finishReceiver(this, resultCode, data, extras, false);
                    } catch (RemoteException e) {
                        Slog.w(ActivityThread.TAG, "Couldn't finish broadcast to unregistered receiver");
                    }
                }
            }

            
        }


        
        final class Args extends BroadcastReceiver.PendingResult implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.813 -0500", hash_original_field = "5953D762DB3CEE40DA100DC8C3CCA6C2", hash_generated_field = "BA12ECC45F316CCCFC0A85600BB7100C")

            private Intent mCurIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.816 -0500", hash_original_field = "1E05D84D00C29A181D9976938669521A", hash_generated_field = "345046B368470FC7DDE0CE76ADA9E345")

            private  boolean mOrdered;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.819 -0500", hash_original_method = "6D86F310027103A2EE811DA0AC3AEAF2", hash_generated_method = "7BD0A710C29C808E75CD318D3C3F6671")
            
public Args(Intent intent, int resultCode, String resultData, Bundle resultExtras,
                    boolean ordered, boolean sticky) {
                super(resultCode, resultData, resultExtras,
                        mRegistered ? TYPE_REGISTERED : TYPE_UNREGISTERED,
                        ordered, sticky, mIIntentReceiver.asBinder());
                mCurIntent = intent;
                mOrdered = ordered;
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.823 -0500", hash_original_method = "55098A9F5CE8E783F44DA889D3A217EF", hash_generated_method = "BBDF4C0C1503961E0426939D642043D3")
            
public void run() {
                final BroadcastReceiver receiver = mReceiver;
                final boolean ordered = mOrdered;
                
                if (ActivityThread.DEBUG_BROADCAST) {
                    int seq = mCurIntent.getIntExtra("seq", -1);
                    Slog.i(ActivityThread.TAG, "Dispatching broadcast " + mCurIntent.getAction()
                            + " seq=" + seq + " to " + mReceiver);
                    Slog.i(ActivityThread.TAG, "  mRegistered=" + mRegistered
                            + " mOrderedHint=" + ordered);
                }
                
                final IActivityManager mgr = ActivityManagerNative.getDefault();
                final Intent intent = mCurIntent;
                mCurIntent = null;
                
                if (receiver == null || mForgotten) {
                    if (mRegistered && ordered) {
                        if (ActivityThread.DEBUG_BROADCAST) Slog.i(ActivityThread.TAG,
                                "Finishing null broadcast to " + mReceiver);
                        sendFinished(mgr);
                    }
                    return;
                }

                try {
                    ClassLoader cl =  mReceiver.getClass().getClassLoader();
                    intent.setExtrasClassLoader(cl);
                    setExtrasClassLoader(cl);
                    receiver.setPendingResult(this);
                    receiver.onReceive(mContext, intent);
                } catch (Exception e) {
                    if (mRegistered && ordered) {
                        if (ActivityThread.DEBUG_BROADCAST) Slog.i(ActivityThread.TAG,
                                "Finishing failed broadcast to " + mReceiver);
                        sendFinished(mgr);
                    }
                    if (mInstrumentation == null ||
                            !mInstrumentation.onException(mReceiver, e)) {
                        throw new RuntimeException(
                            "Error receiving broadcast " + intent
                            + " in " + mReceiver, e);
                    }
                }
                
                if (receiver.getPendingResult() != null) {
                    finish();
                }
            }

            
        }


        
    }


    
    static final class ServiceDispatcher {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.858 -0500", hash_original_field = "09DC230EE2E3FD51D6C702827F48BC00", hash_generated_field = "6D6E935A66D24BF635EDCC1459563037")

        private  ServiceDispatcher.InnerConnection mIServiceConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.861 -0500", hash_original_field = "02A55F67B24018B031982BB9DFE46165", hash_generated_field = "8C1B7663112C8AB9CDFE3F970E8AC317")

        private  ServiceConnection mConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.863 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.866 -0500", hash_original_field = "12988E1FACD6824BE75454D0A2A06532", hash_generated_field = "2AAC1DA9D0E4EE70937D612B5EF41A87")

        private  Handler mActivityThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.868 -0500", hash_original_field = "22356E1B25E63E55D5B2B8508CD8575E", hash_generated_field = "1364060D7B0CFDC7C7DE9BA3A9936610")

        private  ServiceConnectionLeaked mLocation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.871 -0500", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "43F71E9173849705E01112D0229448B4")

        private  int mFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.873 -0500", hash_original_field = "58544628E5BE550D471A74AD3D2D8C34", hash_generated_field = "2749116703DB7B9FDA806F989CF22E90")


        private RuntimeException mUnbindLocation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.875 -0500", hash_original_field = "8A82EAE34C3EC2568E1222500C2DD0B8", hash_generated_field = "E7960A883D3F26E3E35C03E35CAA56E5")


        private boolean mDied;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.877 -0500", hash_original_field = "8A69ACD90223C7C20F66A3AFE6F53D2F", hash_generated_field = "5DE8D58700C695344224A4434DF9E91B")

        private boolean mForgotten;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.898 -0500", hash_original_field = "F97A7ACEB6AC09F8A8B14FA27F8455D1", hash_generated_field = "B2C433E68D38D7E4C3190DDDA91A488A")


        private final HashMap<ComponentName, ServiceDispatcher.ConnectionInfo> mActiveConnections
            = new HashMap<ComponentName, ServiceDispatcher.ConnectionInfo>();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.901 -0500", hash_original_method = "920453595DB1CAB2C546FB2B164C7405", hash_generated_method = "920453595DB1CAB2C546FB2B164C7405")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.904 -0500", hash_original_method = "3A0AF1B483605B7B0302CA5F15EB7149", hash_generated_method = "3A0AF1B483605B7B0302CA5F15EB7149")
        
void validate(Context context, Handler activityThread) {
            if (mContext != context) {
                throw new RuntimeException(
                    "ServiceConnection " + mConnection +
                    " registered with differing Context (was " +
                    mContext + " now " + context + ")");
            }
            if (mActivityThread != activityThread) {
                throw new RuntimeException(
                    "ServiceConnection " + mConnection +
                    " registered with differing handler (was " +
                    mActivityThread + " now " + activityThread + ")");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.906 -0500", hash_original_method = "B423F38D9F2547626F9540342BA8FA08", hash_generated_method = "B423F38D9F2547626F9540342BA8FA08")
        
void doForget() {
            synchronized(this) {
                Iterator<ServiceDispatcher.ConnectionInfo> it = mActiveConnections.values().iterator();
                while (it.hasNext()) {
                    ServiceDispatcher.ConnectionInfo ci = it.next();
                    ci.binder.unlinkToDeath(ci.deathMonitor, 0);
                }
                mActiveConnections.clear();
                mForgotten = true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.908 -0500", hash_original_method = "DB6C3DBDD9CEB1EED1EE508C536B0201", hash_generated_method = "DB6C3DBDD9CEB1EED1EE508C536B0201")
        
ServiceConnectionLeaked getLocation() {
            return mLocation;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.911 -0500", hash_original_method = "14318317B55D028C50F4E970D5AD5F89", hash_generated_method = "14318317B55D028C50F4E970D5AD5F89")
        
ServiceConnection getServiceConnection() {
            return mConnection;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.913 -0500", hash_original_method = "A871391E91E358F0260A3C41C2649BF6", hash_generated_method = "A871391E91E358F0260A3C41C2649BF6")
        
IServiceConnection getIServiceConnection() {
            return mIServiceConnection;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.915 -0500", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "CE8F8E5E4A30C515D6BD9049A49703B9")
        
int getFlags() {
            return mFlags;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.917 -0500", hash_original_method = "CDEAAE2662154511545AF7B43E43329E", hash_generated_method = "CDEAAE2662154511545AF7B43E43329E")
        
void setUnbindLocation(RuntimeException ex) {
            mUnbindLocation = ex;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.919 -0500", hash_original_method = "8CFC5DB6BE83E965DCFCD58443A1D896", hash_generated_method = "8CFC5DB6BE83E965DCFCD58443A1D896")
        
RuntimeException getUnbindLocation() {
            return mUnbindLocation;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.921 -0500", hash_original_method = "F55B5D35A31C0C5BF103A9C597E0E30E", hash_generated_method = "6700443AC5C8B95D2EBE6D9C9E33C124")
        
public void connected(ComponentName name, IBinder service) {
            if (mActivityThread != null) {
                mActivityThread.post(new RunConnection(name, service, 0));
            } else {
                doConnected(name, service);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.923 -0500", hash_original_method = "E6D57B0CCB9624E753F55A65AD088D17", hash_generated_method = "07289385519BF1BEC104BDB90A9A5247")
        
public void death(ComponentName name, IBinder service) {
            ServiceDispatcher.ConnectionInfo old;

            synchronized (this) {
                mDied = true;
                old = mActiveConnections.remove(name);
                if (old == null || old.binder != service) {
                    // Death for someone different than who we last
                    // reported...  just ignore it.
                    return;
                }
                old.binder.unlinkToDeath(old.deathMonitor, 0);
            }

            if (mActivityThread != null) {
                mActivityThread.post(new RunConnection(name, service, 1));
            } else {
                doDeath(name, service);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.927 -0500", hash_original_method = "4206BCB9948653D91B6930DF31631CB7", hash_generated_method = "B5193B19AB349ACAC84E4791E4C4FC98")
        
public void doConnected(ComponentName name, IBinder service) {
            ServiceDispatcher.ConnectionInfo old;
            ServiceDispatcher.ConnectionInfo info;

            synchronized (this) {
                if (mForgotten) {
                    // We unbound before receiving the connection; ignore
                    // any connection received.
                    return;
                }
                old = mActiveConnections.get(name);
                if (old != null && old.binder == service) {
                    // Huh, already have this one.  Oh well!
                    return;
                }

                if (service != null) {
                    // A new service is being connected... set it all up.
                    mDied = false;
                    info = new ConnectionInfo();
                    info.binder = service;
                    info.deathMonitor = new DeathMonitor(name, service);
                    try {
                        service.linkToDeath(info.deathMonitor, 0);
                        mActiveConnections.put(name, info);
                    } catch (RemoteException e) {
                        // This service was dead before we got it...  just
                        // don't do anything with it.
                        mActiveConnections.remove(name);
                        return;
                    }

                } else {
                    // The named service is being disconnected... clean up.
                    mActiveConnections.remove(name);
                }

                if (old != null) {
                    old.binder.unlinkToDeath(old.deathMonitor, 0);
                }
            }

            // If there was an old service, it is not disconnected.
            if (old != null) {
                mConnection.onServiceDisconnected(name);
            }
            // If there is a new service, it is now connected.
            if (service != null) {
                mConnection.onServiceConnected(name, service);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.929 -0500", hash_original_method = "71D95F8AA3DCAD1A788199BEC1658674", hash_generated_method = "B23E7C993F9156E36594DC73E22BE507")
        
public void doDeath(ComponentName name, IBinder service) {
            mConnection.onServiceDisconnected(name);
        }

        
        private static class ConnectionInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.881 -0500", hash_original_field = "FC5BAA062604D7264D40DD8AC68154EA", hash_generated_field = "FC5BAA062604D7264D40DD8AC68154EA")

            IBinder binder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.883 -0500", hash_original_field = "256075ADF444DAFFF45701201F9B1B54", hash_generated_field = "256075ADF444DAFFF45701201F9B1B54")

            IBinder.DeathRecipient deathMonitor;
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.808 -0400", hash_original_method = "1536CD23A1F6D2B518F8B5E1999BC949", hash_generated_method = "1536CD23A1F6D2B518F8B5E1999BC949")
            public ConnectionInfo ()
            {
                //Synthesized constructor
            }


        }


        
        private static class InnerConnection extends IServiceConnection.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.888 -0500", hash_original_field = "1DB9DDA8F9F99F15ABD03B8E39D3C3BD", hash_generated_field = "1DB9DDA8F9F99F15ABD03B8E39D3C3BD")

             WeakReference<LoadedApk.ServiceDispatcher> mDispatcher;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.891 -0500", hash_original_method = "A6B1961EAEFDBCFE8AB6AA462A76FB1E", hash_generated_method = "A6B1961EAEFDBCFE8AB6AA462A76FB1E")
            
InnerConnection(LoadedApk.ServiceDispatcher sd) {
                mDispatcher = new WeakReference<LoadedApk.ServiceDispatcher>(sd);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.894 -0500", hash_original_method = "A0C37377E0B0F4C4DBC15B0A2DE60194", hash_generated_method = "2E8BBD2F60FD0A6781EC99B3E22BF725")
            
public void connected(ComponentName name, IBinder service) throws RemoteException {
                LoadedApk.ServiceDispatcher sd = mDispatcher.get();
                if (sd != null) {
                    sd.connected(name, service);
                }
            }

            
        }


        
        private final class RunConnection implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.943 -0500", hash_original_field = "A464C2842626F7EA212C2BFED22D6A29", hash_generated_field = "A464C2842626F7EA212C2BFED22D6A29")


             ComponentName mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.945 -0500", hash_original_field = "CC72E7E45ED0871AEF8710E69E6BA621", hash_generated_field = "CC72E7E45ED0871AEF8710E69E6BA621")

             IBinder mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.948 -0500", hash_original_field = "2F175E88AE074D5006E1484402CDDE3D", hash_generated_field = "2F175E88AE074D5006E1484402CDDE3D")

             int mCommand;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.934 -0500", hash_original_method = "D3073AFB5412B3DFB84E25D578A5A4E5", hash_generated_method = "D3073AFB5412B3DFB84E25D578A5A4E5")
            
RunConnection(ComponentName name, IBinder service, int command) {
                mName = name;
                mService = service;
                mCommand = command;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.940 -0500", hash_original_method = "52DC970C8C1C8CA46B980F1341D6E54B", hash_generated_method = "E07D212A989D7BD66C5C2C3829FACD48")
            
public void run() {
                if (mCommand == 0) {
                    doConnected(mName, mService);
                } else if (mCommand == 1) {
                    doDeath(mName, mService);
                }
            }

            
        }


        
        private final class DeathMonitor implements IBinder.DeathRecipient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.958 -0500", hash_original_field = "A464C2842626F7EA212C2BFED22D6A29", hash_generated_field = "A464C2842626F7EA212C2BFED22D6A29")


             ComponentName mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.960 -0500", hash_original_field = "CC72E7E45ED0871AEF8710E69E6BA621", hash_generated_field = "CC72E7E45ED0871AEF8710E69E6BA621")

             IBinder mService;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.953 -0500", hash_original_method = "A53A82D1432A704C0ADCA8B12394294F", hash_generated_method = "A53A82D1432A704C0ADCA8B12394294F")
            
DeathMonitor(ComponentName name, IBinder service) {
                mName = name;
                mService = service;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.955 -0500", hash_original_method = "C3027F39FC9400E0CBA13CC2A85E99EF", hash_generated_method = "BB63608AB7131D5FF92F92664B07A73C")
            
public void binderDied() {
                death(mName, mService);
            }

            
        }


        
    }


    
}

