package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

import android.content.ComponentName;
import android.content.ContentProviderNative;
import android.content.IContentProvider;
import android.content.IIntentReceiver;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.IPackageDataObserver;
import android.content.pm.ProviderInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.StrictMode;

public interface IActivityManager extends IInterface {
    
    public static final int START_SWITCHES_CANCELED = 4;
    
    public static final int START_DELIVERED_TO_TOP = 3;
    
    public static final int START_TASK_TO_FRONT = 2;
    
    public static final int START_RETURN_INTENT_TO_CALLER = 1;
    
    public static final int START_SUCCESS = 0;
    public static final int START_INTENT_NOT_RESOLVED = -1;
    public static final int START_CLASS_NOT_FOUND = -2;
    public static final int START_FORWARD_AND_REQUEST_CONFLICT = -3;
    public static final int START_PERMISSION_DENIED = -4;
    public static final int START_NOT_ACTIVITY = -5;
    public static final int START_CANCELED = -6;
    public int startActivity(IApplicationThread caller,
            Intent intent, String resolvedType, Uri[] grantedUriPermissions,
            int grantedMode, IBinder resultTo, String resultWho, int requestCode,
            boolean onlyIfNeeded, boolean debug, String profileFile,
            ParcelFileDescriptor profileFd, boolean autoStopProfiler) throws RemoteException;
    public WaitResult startActivityAndWait(IApplicationThread caller,
            Intent intent, String resolvedType, Uri[] grantedUriPermissions,
            int grantedMode, IBinder resultTo, String resultWho, int requestCode,
            boolean onlyIfNeeded, boolean debug, String profileFile,
            ParcelFileDescriptor profileFd, boolean autoStopProfiler) throws RemoteException;
    public int startActivityWithConfig(IApplicationThread caller,
            Intent intent, String resolvedType, Uri[] grantedUriPermissions,
            int grantedMode, IBinder resultTo, String resultWho, int requestCode,
            boolean onlyIfNeeded, boolean debug, Configuration newConfig) throws RemoteException;
    public int startActivityIntentSender(IApplicationThread caller,
            IntentSender intent, Intent fillInIntent, String resolvedType,
            IBinder resultTo, String resultWho, int requestCode,
            int flagsMask, int flagsValues) throws RemoteException;
    public boolean startNextMatchingActivity(IBinder callingActivity,
            Intent intent) throws RemoteException;
    public boolean finishActivity(IBinder token, int code, Intent data)
            throws RemoteException;
    public void finishSubActivity(IBinder token, String resultWho, int requestCode) throws RemoteException;
    public boolean willActivityBeVisible(IBinder token) throws RemoteException;
    public Intent registerReceiver(IApplicationThread caller, String callerPackage,
            IIntentReceiver receiver, IntentFilter filter,
            String requiredPermission) throws RemoteException;
    public void unregisterReceiver(IIntentReceiver receiver) throws RemoteException;
    public static final int BROADCAST_SUCCESS = 0;
    public static final int BROADCAST_STICKY_CANT_HAVE_PERMISSION = -1;
    public int broadcastIntent(IApplicationThread caller, Intent intent,
            String resolvedType, IIntentReceiver resultTo, int resultCode,
            String resultData, Bundle map, String requiredPermission,
            boolean serialized, boolean sticky) throws RemoteException;
    public void unbroadcastIntent(IApplicationThread caller, Intent intent) throws RemoteException;
    
    public void finishReceiver(IBinder who, int resultCode, String resultData, Bundle map, boolean abortBroadcast) throws RemoteException;
    public void attachApplication(IApplicationThread app) throws RemoteException;
    
    public void activityIdle(IBinder token, Configuration config,
            boolean stopProfiling) throws RemoteException;
    public void activityPaused(IBinder token) throws RemoteException;
    
    public void activityStopped(IBinder token, Bundle state,
            Bitmap thumbnail, CharSequence description) throws RemoteException;
    
    public void activitySlept(IBinder token) throws RemoteException;
    
    public void activityDestroyed(IBinder token) throws RemoteException;
    public String getCallingPackage(IBinder token) throws RemoteException;
    public ComponentName getCallingActivity(IBinder token) throws RemoteException;
    public List getTasks(int maxNum, int flags,
                         IThumbnailReceiver receiver) throws RemoteException;
    public List<ActivityManager.RecentTaskInfo> getRecentTasks(int maxNum,
            int flags) throws RemoteException;
    public ActivityManager.TaskThumbnails getTaskThumbnails(int taskId) throws RemoteException;
    public List getServices(int maxNum, int flags) throws RemoteException;
    public List<ActivityManager.ProcessErrorStateInfo> getProcessesInErrorState()
            throws RemoteException;
    public void moveTaskToFront(int task, int flags) throws RemoteException;
    public void moveTaskToBack(int task) throws RemoteException;
    public boolean moveActivityTaskToBack(IBinder token, boolean nonRoot) throws RemoteException;
    public void moveTaskBackwards(int task) throws RemoteException;
    public int getTaskForActivity(IBinder token, boolean onlyRoot) throws RemoteException;
    public void finishOtherInstances(IBinder token, ComponentName className) throws RemoteException;
    
    public void reportThumbnail(IBinder token,
            Bitmap thumbnail, CharSequence description) throws RemoteException;
    public ContentProviderHolder getContentProvider(IApplicationThread caller,
            String name) throws RemoteException;
    public void removeContentProvider(IApplicationThread caller,
            String name) throws RemoteException;
    public void publishContentProviders(IApplicationThread caller,
            List<ContentProviderHolder> providers) throws RemoteException;
    public PendingIntent getRunningServiceControlPanel(ComponentName service)
            throws RemoteException;
    public ComponentName startService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException;
    public int stopService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException;
    public boolean stopServiceToken(ComponentName className, IBinder token,
            int startId) throws RemoteException;
    public void setServiceForeground(ComponentName className, IBinder token,
            int id, Notification notification, boolean keepNotification) throws RemoteException;
    public int bindService(IApplicationThread caller, IBinder token,
            Intent service, String resolvedType,
            IServiceConnection connection, int flags) throws RemoteException;
    public boolean unbindService(IServiceConnection connection) throws RemoteException;
    public void publishService(IBinder token,
            Intent intent, IBinder service) throws RemoteException;
    public void unbindFinished(IBinder token, Intent service,
            boolean doRebind) throws RemoteException;
    
    public void serviceDoneExecuting(IBinder token, int type, int startId,
            int res) throws RemoteException;
    public IBinder peekService(Intent service, String resolvedType) throws RemoteException;
    
    public boolean bindBackupAgent(ApplicationInfo appInfo, int backupRestoreMode)
            throws RemoteException;
    public void backupAgentCreated(String packageName, IBinder agent) throws RemoteException;
    public void unbindBackupAgent(ApplicationInfo appInfo) throws RemoteException;
    public void killApplicationProcess(String processName, int uid) throws RemoteException;
    
    public boolean startInstrumentation(ComponentName className, String profileFile,
            int flags, Bundle arguments, IInstrumentationWatcher watcher)
            throws RemoteException;
    public void finishInstrumentation(IApplicationThread target,
            int resultCode, Bundle results) throws RemoteException;

    public Configuration getConfiguration() throws RemoteException;
    public void updateConfiguration(Configuration values) throws RemoteException;
    public void setRequestedOrientation(IBinder token,
            int requestedOrientation) throws RemoteException;
    public int getRequestedOrientation(IBinder token) throws RemoteException;
    
    public ComponentName getActivityClassForToken(IBinder token) throws RemoteException;
    public String getPackageForToken(IBinder token) throws RemoteException;

    public static final int INTENT_SENDER_BROADCAST = 1;
    public static final int INTENT_SENDER_ACTIVITY = 2;
    public static final int INTENT_SENDER_ACTIVITY_RESULT = 3;
    public static final int INTENT_SENDER_SERVICE = 4;
    public IIntentSender getIntentSender(int type,
            String packageName, IBinder token, String resultWho,
            int requestCode, Intent[] intents, String[] resolvedTypes,
            int flags) throws RemoteException;
    public void cancelIntentSender(IIntentSender sender) throws RemoteException;
    public boolean clearApplicationUserData(final String packageName,
            final IPackageDataObserver observer) throws RemoteException;
    public String getPackageForIntentSender(IIntentSender sender) throws RemoteException;
    
    public void setProcessLimit(int max) throws RemoteException;
    public int getProcessLimit() throws RemoteException;
    
    public void setProcessForeground(IBinder token, int pid,
            boolean isForeground) throws RemoteException;
    
    public int checkPermission(String permission, int pid, int uid)
            throws RemoteException;

    public int checkUriPermission(Uri uri, int pid, int uid, int mode)
            throws RemoteException;
    public void grantUriPermission(IApplicationThread caller, String targetPkg,
            Uri uri, int mode) throws RemoteException;
    public void revokeUriPermission(IApplicationThread caller, Uri uri,
            int mode) throws RemoteException;
    
    public void showWaitingForDebugger(IApplicationThread who, boolean waiting)
            throws RemoteException;
    
    public void getMemoryInfo(ActivityManager.MemoryInfo outInfo) throws RemoteException;
    
    public void killBackgroundProcesses(final String packageName) throws RemoteException;
    public void killAllBackgroundProcesses() throws RemoteException;
    public void forceStopPackage(final String packageName) throws RemoteException;
    
    public void goingToSleep() throws RemoteException;
    public void wakingUp() throws RemoteException;
    
    public void unhandledBack() throws RemoteException;
    public ParcelFileDescriptor openContentUri(Uri uri) throws RemoteException;
    public void setDebugApp(
        String packageName, boolean waitForDebugger, boolean persistent)
        throws RemoteException;
    public void setAlwaysFinish(boolean enabled) throws RemoteException;
    public void setActivityController(IActivityController watcher)
        throws RemoteException;

    public void enterSafeMode() throws RemoteException;
    
    public void noteWakeupAlarm(IIntentSender sender) throws RemoteException;
    
    public boolean killPids(int[] pids, String reason, boolean secure) throws RemoteException;
    
    public void startRunning(String pkg, String cls, String action,
            String data) throws RemoteException;
    public void handleApplicationCrash(IBinder app,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException;
    public boolean handleApplicationWtf(IBinder app, String tag,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException;
    
    public void handleApplicationStrictModeViolation(IBinder app, int violationMask,
            StrictMode.ViolationInfo crashInfo) throws RemoteException;
    
    public void signalPersistentProcesses(int signal) throws RemoteException;
    
    public List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses()
            throws RemoteException;
 
    public List<ApplicationInfo> getRunningExternalApplications()
            throws RemoteException;
    
    public ConfigurationInfo getDeviceConfigurationInfo() throws RemoteException;
    
    public boolean profileControl(String process, boolean start,
            String path, ParcelFileDescriptor fd, int profileType) throws RemoteException;
    
    public boolean shutdown(int timeout) throws RemoteException;
    
    public void stopAppSwitches() throws RemoteException;
    public void resumeAppSwitches() throws RemoteException;
    
    public void registerActivityWatcher(IActivityWatcher watcher)
            throws RemoteException;
    public void unregisterActivityWatcher(IActivityWatcher watcher)
            throws RemoteException;

    public int startActivityInPackage(int uid,
            Intent intent, String resolvedType, IBinder resultTo,
            String resultWho, int requestCode, boolean onlyIfNeeded)
            throws RemoteException;

    public void killApplicationWithUid(String pkg, int uid) throws RemoteException;
    
    public void closeSystemDialogs(String reason) throws RemoteException;
    
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids)
            throws RemoteException;
    
    public void overridePendingTransition(IBinder token, String packageName,
            int enterAnim, int exitAnim) throws RemoteException;
    
    public boolean isUserAMonkey() throws RemoteException;
    
    public void finishHeavyWeightApp() throws RemoteException;

    public void setImmersive(IBinder token, boolean immersive) throws RemoteException;
    public boolean isImmersive(IBinder token) throws RemoteException;
    public boolean isTopActivityImmersive() throws RemoteException;
    
    public void crashApplication(int uid, int initialPid, String packageName,
            String message) throws RemoteException;

    public String getProviderMimeType(Uri uri) throws RemoteException;
    
    public IBinder newUriPermissionOwner(String name) throws RemoteException;
    public void grantUriPermissionFromOwner(IBinder owner, int fromUid, String targetPkg,
            Uri uri, int mode) throws RemoteException;
    public void revokeUriPermissionFromOwner(IBinder owner, Uri uri,
            int mode) throws RemoteException;

    public int checkGrantUriPermission(int callingUid, String targetPkg,
            Uri uri, int modeFlags) throws RemoteException;
    
    public boolean dumpHeap(String process, boolean managed, String path,
        ParcelFileDescriptor fd) throws RemoteException;

    public int startActivities(IApplicationThread caller,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException;
    public int startActivitiesInPackage(int uid,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException;

    public int getFrontActivityScreenCompatMode() throws RemoteException;
    public void setFrontActivityScreenCompatMode(int mode) throws RemoteException;
    public int getPackageScreenCompatMode(String packageName) throws RemoteException;
    public void setPackageScreenCompatMode(String packageName, int mode)
            throws RemoteException;
    public boolean getPackageAskScreenCompat(String packageName) throws RemoteException;
    public void setPackageAskScreenCompat(String packageName, boolean ask)
            throws RemoteException;
    
    public boolean switchUser(int userid) throws RemoteException;
    
    public boolean removeSubTask(int taskId, int subTaskIndex) throws RemoteException;

    public boolean removeTask(int taskId, int flags) throws RemoteException;

    public void registerProcessObserver(IProcessObserver observer) throws RemoteException;
    public void unregisterProcessObserver(IProcessObserver observer) throws RemoteException;

    public boolean isIntentSenderTargetedToPackage(IIntentSender sender) throws RemoteException;

    public void updatePersistentConfiguration(Configuration values) throws RemoteException;

    public long[] getProcessPss(int[] pids) throws RemoteException;

    public void showBootMessage(CharSequence msg, boolean always) throws RemoteException;

    public void dismissKeyguardOnNextActivity() throws RemoteException;
    
     boolean testIsSystemReady();
    
    public static class ContentProviderHolder implements Parcelable {

        public static final Parcelable.Creator<ContentProviderHolder> CREATOR
                = new Parcelable.Creator<ContentProviderHolder>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.774 -0500", hash_original_method = "7B438CD16C21D53CFB945704DA961322", hash_generated_method = "7A0CFFF317A891F2F12E1C6ED753DCFF")
            
public ContentProviderHolder createFromParcel(Parcel source) {
                return new ContentProviderHolder(source);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.776 -0500", hash_original_method = "04C99A8C30494BEDF960ED7C159321BD", hash_generated_method = "A487B8CA651502ADDEABF5FCE422216B")
            
public ContentProviderHolder[] newArray(int size) {
                return new ContentProviderHolder[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.758 -0500", hash_original_field = "5CDA2FBF2554178EE653F2BC5EB08EC7", hash_generated_field = "BF776B364C73D31E6B3B31185D6DF955")

        public  ProviderInfo info;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.760 -0500", hash_original_field = "D5DCCD8B4C676366ACECEBB76481C371", hash_generated_field = "C730DD69C93F6644B226FED7D6567496")

        public IContentProvider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.762 -0500", hash_original_field = "E32B00087CF60143581345FE49DA2D82", hash_generated_field = "B2A5CB4DC49A221CCDDDA6FC23BB36ED")

        public boolean noReleaseNeeded;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.765 -0500", hash_original_method = "F5938A2BCBFD23A0DD108791F4C585A4", hash_generated_method = "96782B3634F91CEBE3FF9748BECECB01")
        
public ContentProviderHolder(ProviderInfo _info) {
            info = _info;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.782 -0500", hash_original_method = "DE66B2AAADEB005E6177C82649ADED33", hash_generated_method = "04794E4865E5B5E19D9358C6E4FF1C9C")
        
private ContentProviderHolder(Parcel source) {
            info = ProviderInfo.CREATOR.createFromParcel(source);
            provider = ContentProviderNative.asInterface(
                source.readStrongBinder());
            noReleaseNeeded = source.readInt() != 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.767 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.770 -0500", hash_original_method = "055D811374FBB4701F1DF02FE6919DFE", hash_generated_method = "E9AA09AA7C5B9119AB2904A18446C7D3")
        
public void writeToParcel(Parcel dest, int flags) {
            info.writeToParcel(dest, 0);
            if (provider != null) {
                dest.writeStrongBinder(provider.asBinder());
            } else {
                dest.writeStrongBinder(null);
            }
            dest.writeInt(noReleaseNeeded ? 1:0);
        }
    };
    
    public static class WaitResult implements Parcelable {

        public static final Parcelable.Creator<WaitResult> CREATOR
                = new Parcelable.Creator<WaitResult>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.804 -0500", hash_original_method = "3791D8DCE3F9483BA1FB831A79748235", hash_generated_method = "E99C5DE349F9FA358314270B7C013CCD")
            
public WaitResult createFromParcel(Parcel source) {
                return new WaitResult(source);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.806 -0500", hash_original_method = "9975751ADB34BF2689797DB91A56FFF8", hash_generated_method = "A378AED0501FF1DD812C1CB868992929")
            
public WaitResult[] newArray(int size) {
                return new WaitResult[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.784 -0500", hash_original_field = "E9D38E2A3EEFF7911169FBB093D12F3A", hash_generated_field = "B9125D4ED8E66B0A5D0623BA280F0CE7")

        public int result;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.787 -0500", hash_original_field = "A5132F630FF6BF15BC2FBFE1DACCC85C", hash_generated_field = "F35A7A719F41EAB8F03A95F6324562CD")

        public boolean timeout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.789 -0500", hash_original_field = "EF253B65B43741136160C6D8FA69DAEC", hash_generated_field = "34F69357015AF9E37B71518212033D55")

        public ComponentName who;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.791 -0500", hash_original_field = "18677B7CB052383E8FC94DCA82BB8A44", hash_generated_field = "089B393DE7C7F08169929A5DB0EE1529")

        public long thisTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.793 -0500", hash_original_field = "0CD8C11C9ED123934179CDC4B03E8D05", hash_generated_field = "5C07FCDAD586DD12989107906EED34BC")

        public long totalTime;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.795 -0500", hash_original_method = "0256A6E035D799D49434166180403C08", hash_generated_method = "575CB7D449B562FE7AF359F5ABF3EE99")
        
public WaitResult() {
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.811 -0500", hash_original_method = "18012A8A4C21626C6284E5F43299A78B", hash_generated_method = "1E1C7D5A3A2869E5CA31188CCC5E8F56")
        
private WaitResult(Parcel source) {
            result = source.readInt();
            timeout = source.readInt() != 0;
            who = ComponentName.readFromParcel(source);
            thisTime = source.readLong();
            totalTime = source.readLong();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.797 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:54.800 -0500", hash_original_method = "059F0DB3E5849A4C215FC265F792E051", hash_generated_method = "02A382C8D808C11880F61CB350332938")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(result);
            dest.writeInt(timeout ? 1 : 0);
            ComponentName.writeToParcel(who, dest);
            dest.writeLong(thisTime);
            dest.writeLong(totalTime);
        }
    };

    String descriptor = "android.app.IActivityManager";
    
    int START_RUNNING_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION;
    int HANDLE_APPLICATION_CRASH_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+1;
    int START_ACTIVITY_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+2;
    int UNHANDLED_BACK_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+3;
    int OPEN_CONTENT_URI_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+4;
    
    int FINISH_ACTIVITY_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+10;
    int REGISTER_RECEIVER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+11;
    int UNREGISTER_RECEIVER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+12;
    int BROADCAST_INTENT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+13;
    int UNBROADCAST_INTENT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+14;
    int FINISH_RECEIVER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+15;
    int ATTACH_APPLICATION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+16;
    int ACTIVITY_IDLE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+17;
    int ACTIVITY_PAUSED_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+18;
    int ACTIVITY_STOPPED_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+19;
    int GET_CALLING_PACKAGE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+20;
    int GET_CALLING_ACTIVITY_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+21;
    int GET_TASKS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+22;
    int MOVE_TASK_TO_FRONT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+23;
    int MOVE_TASK_TO_BACK_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+24;
    int MOVE_TASK_BACKWARDS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+25;
    int GET_TASK_FOR_ACTIVITY_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+26;
    int REPORT_THUMBNAIL_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+27;
    int GET_CONTENT_PROVIDER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+28;
    int PUBLISH_CONTENT_PROVIDERS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+29;
    
    int FINISH_SUB_ACTIVITY_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+31;
    int GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+32;
    int START_SERVICE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+33;
    int STOP_SERVICE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+34;
    int BIND_SERVICE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+35;
    int UNBIND_SERVICE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+36;
    int PUBLISH_SERVICE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+37;
    int FINISH_OTHER_INSTANCES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+38;
    int GOING_TO_SLEEP_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+39;
    int WAKING_UP_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+40;
    int SET_DEBUG_APP_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+41;
    int SET_ALWAYS_FINISH_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+42;
    int START_INSTRUMENTATION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+43;
    int FINISH_INSTRUMENTATION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+44;
    int GET_CONFIGURATION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+45;
    int UPDATE_CONFIGURATION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+46;
    int STOP_SERVICE_TOKEN_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+47;
    int GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+48;
    int GET_PACKAGE_FOR_TOKEN_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+49;
    int SET_PROCESS_LIMIT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+50;
    int GET_PROCESS_LIMIT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+51;
    int CHECK_PERMISSION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+52;
    int CHECK_URI_PERMISSION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+53;
    int GRANT_URI_PERMISSION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+54;
    int REVOKE_URI_PERMISSION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+55;
    int SET_ACTIVITY_CONTROLLER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+56;
    int SHOW_WAITING_FOR_DEBUGGER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+57;
    int SIGNAL_PERSISTENT_PROCESSES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+58;
    int GET_RECENT_TASKS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+59;
    int SERVICE_DONE_EXECUTING_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+60;
    int ACTIVITY_DESTROYED_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+61;
    int GET_INTENT_SENDER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+62;
    int CANCEL_INTENT_SENDER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+63;
    int GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+64;
    int ENTER_SAFE_MODE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+65;
    int START_NEXT_MATCHING_ACTIVITY_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+66;
    int NOTE_WAKEUP_ALARM_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+67;
    int REMOVE_CONTENT_PROVIDER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+68;
    int SET_REQUESTED_ORIENTATION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+69;
    int GET_REQUESTED_ORIENTATION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+70;
    int UNBIND_FINISHED_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+71;
    int SET_PROCESS_FOREGROUND_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+72;
    int SET_SERVICE_FOREGROUND_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+73;
    int MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+74;
    int GET_MEMORY_INFO_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+75;
    int GET_PROCESSES_IN_ERROR_STATE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+76;
    int CLEAR_APP_DATA_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+77;
    int FORCE_STOP_PACKAGE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+78;
    int KILL_PIDS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+79;
    int GET_SERVICES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+80;
    int GET_TASK_THUMBNAILS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+81;
    int GET_RUNNING_APP_PROCESSES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+82;
    int GET_DEVICE_CONFIGURATION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+83;
    int PEEK_SERVICE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+84;
    int PROFILE_CONTROL_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+85;
    int SHUTDOWN_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+86;
    int STOP_APP_SWITCHES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+87;
    int RESUME_APP_SWITCHES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+88;
    int START_BACKUP_AGENT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+89;
    int BACKUP_AGENT_CREATED_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+90;
    int UNBIND_BACKUP_AGENT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+91;
    int REGISTER_ACTIVITY_WATCHER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+92;
    int UNREGISTER_ACTIVITY_WATCHER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+93;
    int START_ACTIVITY_IN_PACKAGE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+94;
    int KILL_APPLICATION_WITH_UID_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+95;
    int CLOSE_SYSTEM_DIALOGS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+96;
    int GET_PROCESS_MEMORY_INFO_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+97;
    int KILL_APPLICATION_PROCESS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+98;
    int START_ACTIVITY_INTENT_SENDER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+99;
    int OVERRIDE_PENDING_TRANSITION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+100;
    int HANDLE_APPLICATION_WTF_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+101;
    int KILL_BACKGROUND_PROCESSES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+102;
    int IS_USER_A_MONKEY_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+103;
    int START_ACTIVITY_AND_WAIT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+104;
    int WILL_ACTIVITY_BE_VISIBLE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+105;
    int START_ACTIVITY_WITH_CONFIG_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+106;
    int GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+107;
    int FINISH_HEAVY_WEIGHT_APP_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+108;
    int HANDLE_APPLICATION_STRICT_MODE_VIOLATION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+109;
    int IS_IMMERSIVE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+110;
    int SET_IMMERSIVE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+111;
    int IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+112;
    int CRASH_APPLICATION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+113;
    int GET_PROVIDER_MIME_TYPE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+114;
    int NEW_URI_PERMISSION_OWNER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+115;
    int GRANT_URI_PERMISSION_FROM_OWNER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+116;
    int REVOKE_URI_PERMISSION_FROM_OWNER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+117;
    int CHECK_GRANT_URI_PERMISSION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+118;
    int DUMP_HEAP_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+119;
    int START_ACTIVITIES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+120;
    int START_ACTIVITIES_IN_PACKAGE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+121;
    int ACTIVITY_SLEPT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+122;
    int GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+123;
    int SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+124;
    int GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+125;
    int SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+126;
    int GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+127;
    int SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+128;
    int SWITCH_USER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+129;
    int REMOVE_SUB_TASK_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+130;
    int REMOVE_TASK_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+131;
    int REGISTER_PROCESS_OBSERVER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+132;
    int UNREGISTER_PROCESS_OBSERVER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+133;
    int IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+134;
    int UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+135;
    int GET_PROCESS_PSS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+136;
    int SHOW_BOOT_MESSAGE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+137;
    int DISMISS_KEYGUARD_ON_NEXT_ACTIVITY_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+138;
    int KILL_ALL_BACKGROUND_PROCESSES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+139;
}
