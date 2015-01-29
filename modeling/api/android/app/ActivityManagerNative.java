package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.content.ComponentName;
import android.content.IIntentReceiver;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.IPackageDataObserver;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Debug;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Singleton;

public abstract class ActivityManagerNative extends Binder implements IActivityManager {
    /**
     * Cast a Binder object into an activity manager interface, generating
     * a proxy if needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.073 -0500", hash_original_method = "2F0865077D68737A7D6F441D3CAC24D9", hash_generated_method = "C5B42A1DFCEB823A5136B429CF9AC9B1")
    
static public IActivityManager asInterface(IBinder obj) {
        if (obj == null) {
            return null;
        }
        IActivityManager in =
            (IActivityManager)obj.queryLocalInterface(descriptor);
        if (in != null) {
            return in;
        }

        return new ActivityManagerProxy(obj);
    }

    /**
     * Retrieve the system's default/global activity manager.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.075 -0500", hash_original_method = "C581351462D87A5CA19EFFE73691D6B8", hash_generated_method = "8A940506F46A34A8E626D5A708A565C0")
    
static public IActivityManager getDefault() {
        return gDefault.get();
    }

    /**
     * Convenience for checking whether the system is ready.  For internal use only.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.077 -0500", hash_original_method = "5FC4B6592318F4C948D38B5B79469552", hash_generated_method = "CE9217ADD286B0464C74DC335EE97C68")
    
static public boolean isSystemReady() {
        if (!sSystemReady) {
            sSystemReady = getDefault().testIsSystemReady();
        }
        return sSystemReady;
    }

    /**
     * Convenience for sending a sticky broadcast.  For internal use only.
     * If you don't care about permission, use null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.082 -0500", hash_original_method = "60868BAA36991408EA660689C2535FBD", hash_generated_method = "A8711EF68EBD906ABB8BD5ECE502F8AB")
    
static public void broadcastStickyIntent(Intent intent, String permission) {
        try {
            getDefault().broadcastIntent(
                null, intent, null, null, Activity.RESULT_OK, null, null,
                null /*permission*/, false, true);
        } catch (RemoteException ex) {
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.084 -0500", hash_original_method = "966DD9810BB71B16CA7135B6EC37DFA9", hash_generated_method = "E166A6FE65574D56C7D063F976139987")
    
static public void noteWakeupAlarm(PendingIntent ps) {
        try {
            getDefault().noteWakeupAlarm(ps.getTarget());
        } catch (RemoteException ex) {
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.079 -0500", hash_original_field = "A1239A54CF6D9FD00DE33B6184F6C23D", hash_generated_field = "94B5404A722EA8FD9D4D6FFD2B91074A")

    static boolean sSystemReady = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.715 -0400", hash_original_field = "1DDB5338697F4F4D1F4EBEBCBCA04F09", hash_generated_field = "C4820EDCAE5178FFFBC23811D56B7F74")

    private static final Singleton<IActivityManager> gDefault = new Singleton<IActivityManager>() {
    	
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.715 -0400", hash_original_method = "DB2B8F5A0363FA0CE3E5AA87CCE94A22", hash_generated_method = "C2B8BA082758343987D3AD39EBC6D0DC")
        protected IActivityManager create() {
            IActivityManager varB4EAC82CA7396A68D541C85D26508E83_1441821956 = null; 
            IBinder b = ServiceManager.getService("activity");
            IActivityManager am = asInterface(b);
            varB4EAC82CA7396A68D541C85D26508E83_1441821956 = am;
            //varB4EAC82CA7396A68D541C85D26508E83_1441821956.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1441821956;
            
        }
        
};

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.087 -0500", hash_original_method = "444DC66B3432907DFEA55328E5B69649", hash_generated_method = "CA241610C52E4659313FA08BF918B84A")
    
public ActivityManagerNative() {
        attachInterface(this, descriptor);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.117 -0500", hash_original_method = "796B52B1E8846F7CCEC22CD4B5B906A8", hash_generated_method = "3488280CD2BFAF139E54B711B498D7DC")
    
public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
            throws RemoteException {
        switch (code) {
        case START_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Intent intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            Uri[] grantedUriPermissions = data.createTypedArray(Uri.CREATOR);
            int grantedMode = data.readInt();
            IBinder resultTo = data.readStrongBinder();
            String resultWho = data.readString();    
            int requestCode = data.readInt();
            boolean onlyIfNeeded = data.readInt() != 0;
            boolean debug = data.readInt() != 0;
            String profileFile = data.readString();
            ParcelFileDescriptor profileFd = data.readInt() != 0
                    ? data.readFileDescriptor() : null;
            boolean autoStopProfiler = data.readInt() != 0;
            int result = startActivity(app, intent, resolvedType,
                    grantedUriPermissions, grantedMode, resultTo, resultWho,
                    requestCode, onlyIfNeeded, debug, profileFile, profileFd, autoStopProfiler);
            reply.writeNoException();
            reply.writeInt(result);
            return true;
        }

        case START_ACTIVITY_AND_WAIT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Intent intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            Uri[] grantedUriPermissions = data.createTypedArray(Uri.CREATOR);
            int grantedMode = data.readInt();
            IBinder resultTo = data.readStrongBinder();
            String resultWho = data.readString();    
            int requestCode = data.readInt();
            boolean onlyIfNeeded = data.readInt() != 0;
            boolean debug = data.readInt() != 0;
            String profileFile = data.readString();
            ParcelFileDescriptor profileFd = data.readInt() != 0
                    ? data.readFileDescriptor() : null;
            boolean autoStopProfiler = data.readInt() != 0;
            WaitResult result = startActivityAndWait(app, intent, resolvedType,
                    grantedUriPermissions, grantedMode, resultTo, resultWho,
                    requestCode, onlyIfNeeded, debug, profileFile, profileFd, autoStopProfiler);
            reply.writeNoException();
            result.writeToParcel(reply, 0);
            return true;
        }

        case START_ACTIVITY_WITH_CONFIG_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Intent intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            Uri[] grantedUriPermissions = data.createTypedArray(Uri.CREATOR);
            int grantedMode = data.readInt();
            IBinder resultTo = data.readStrongBinder();
            String resultWho = data.readString();    
            int requestCode = data.readInt();
            boolean onlyIfNeeded = data.readInt() != 0;
            boolean debug = data.readInt() != 0;
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            int result = startActivityWithConfig(app, intent, resolvedType,
                    grantedUriPermissions, grantedMode, resultTo, resultWho,
                    requestCode, onlyIfNeeded, debug, config);
            reply.writeNoException();
            reply.writeInt(result);
            return true;
        }

        case START_ACTIVITY_INTENT_SENDER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            IntentSender intent = IntentSender.CREATOR.createFromParcel(data);
            Intent fillInIntent = null;
            if (data.readInt() != 0) {
                fillInIntent = Intent.CREATOR.createFromParcel(data);
            }
            String resolvedType = data.readString();
            IBinder resultTo = data.readStrongBinder();
            String resultWho = data.readString();    
            int requestCode = data.readInt();
            int flagsMask = data.readInt();
            int flagsValues = data.readInt();
            int result = startActivityIntentSender(app, intent,
                    fillInIntent, resolvedType, resultTo, resultWho,
                    requestCode, flagsMask, flagsValues);
            reply.writeNoException();
            reply.writeInt(result);
            return true;
        }
        
        case START_NEXT_MATCHING_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder callingActivity = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            boolean result = startNextMatchingActivity(callingActivity, intent);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            return true;
        }
        
        case FINISH_ACTIVITY_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Intent resultData = null;
            int resultCode = data.readInt();
            if (data.readInt() != 0) {
                resultData = Intent.CREATOR.createFromParcel(data);
            }
            boolean res = finishActivity(token, resultCode, resultData);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }

        case FINISH_SUB_ACTIVITY_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            String resultWho = data.readString();    
            int requestCode = data.readInt();
            finishSubActivity(token, resultWho, requestCode);
            reply.writeNoException();
            return true;
        }

        case WILL_ACTIVITY_BE_VISIBLE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean res = willActivityBeVisible(token);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }

        case REGISTER_RECEIVER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app =
                b != null ? ApplicationThreadNative.asInterface(b) : null;
            String packageName = data.readString();
            b = data.readStrongBinder();
            IIntentReceiver rec
                = b != null ? IIntentReceiver.Stub.asInterface(b) : null;
            IntentFilter filter = IntentFilter.CREATOR.createFromParcel(data);
            String perm = data.readString();
            Intent intent = registerReceiver(app, packageName, rec, filter, perm);
            reply.writeNoException();
            if (intent != null) {
                reply.writeInt(1);
                intent.writeToParcel(reply, 0);
            } else {
                reply.writeInt(0);
            }
            return true;
        }

        case UNREGISTER_RECEIVER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            if (b == null) {
                return true;
            }
            IIntentReceiver rec = IIntentReceiver.Stub.asInterface(b);
            unregisterReceiver(rec);
            reply.writeNoException();
            return true;
        }

        case BROADCAST_INTENT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app =
                b != null ? ApplicationThreadNative.asInterface(b) : null;
            Intent intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            b = data.readStrongBinder();
            IIntentReceiver resultTo =
                b != null ? IIntentReceiver.Stub.asInterface(b) : null;
            int resultCode = data.readInt();
            String resultData = data.readString();
            Bundle resultExtras = data.readBundle();
            String perm = data.readString();
            boolean serialized = data.readInt() != 0;
            boolean sticky = data.readInt() != 0;
            int res = broadcastIntent(app, intent, resolvedType, resultTo,
                    resultCode, resultData, resultExtras, perm,
                    serialized, sticky);
            reply.writeNoException();
            reply.writeInt(res);
            return true;
        }

        case UNBROADCAST_INTENT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = b != null ? ApplicationThreadNative.asInterface(b) : null;
            Intent intent = Intent.CREATOR.createFromParcel(data);
            unbroadcastIntent(app, intent);
            reply.writeNoException();
            return true;
        }

        case FINISH_RECEIVER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder who = data.readStrongBinder();
            int resultCode = data.readInt();
            String resultData = data.readString();
            Bundle resultExtras = data.readBundle();
            boolean resultAbort = data.readInt() != 0;
            if (who != null) {
                finishReceiver(who, resultCode, resultData, resultExtras, resultAbort);
            }
            reply.writeNoException();
            return true;
        }

        case ATTACH_APPLICATION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IApplicationThread app = ApplicationThreadNative.asInterface(
                    data.readStrongBinder());
            if (app != null) {
                attachApplication(app);
            }
            reply.writeNoException();
            return true;
        }

        case ACTIVITY_IDLE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Configuration config = null;
            if (data.readInt() != 0) {
                config = Configuration.CREATOR.createFromParcel(data);
            }
            boolean stopProfiling = data.readInt() != 0;
            if (token != null) {
                activityIdle(token, config, stopProfiling);
            }
            reply.writeNoException();
            return true;
        }

        case ACTIVITY_PAUSED_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activityPaused(token);
            reply.writeNoException();
            return true;
        }

        case ACTIVITY_STOPPED_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Bundle map = data.readBundle();
            Bitmap thumbnail = data.readInt() != 0
                ? Bitmap.CREATOR.createFromParcel(data) : null;
            CharSequence description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            activityStopped(token, map, thumbnail, description);
            reply.writeNoException();
            return true;
        }

        case ACTIVITY_SLEPT_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activitySlept(token);
            reply.writeNoException();
            return true;
        }

        case ACTIVITY_DESTROYED_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activityDestroyed(token);
            reply.writeNoException();
            return true;
        }

        case GET_CALLING_PACKAGE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            String res = token != null ? getCallingPackage(token) : null;
            reply.writeNoException();
            reply.writeString(res);
            return true;
        }

        case GET_CALLING_ACTIVITY_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName cn = getCallingActivity(token);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
            return true;
        }

        case GET_TASKS_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int maxNum = data.readInt();
            int fl = data.readInt();
            IBinder receiverBinder = data.readStrongBinder();
            IThumbnailReceiver receiver = receiverBinder != null
                ? IThumbnailReceiver.Stub.asInterface(receiverBinder)
                : null;
            List list = getTasks(maxNum, fl, receiver);
            reply.writeNoException();
            int N = list != null ? list.size() : -1;
            reply.writeInt(N);
            int i;
            for (i=0; i<N; i++) {
                ActivityManager.RunningTaskInfo info =
                        (ActivityManager.RunningTaskInfo)list.get(i);
                info.writeToParcel(reply, 0);
            }
            return true;
        }

        case GET_RECENT_TASKS_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int maxNum = data.readInt();
            int fl = data.readInt();
            List<ActivityManager.RecentTaskInfo> list = getRecentTasks(maxNum,
                    fl);
            reply.writeNoException();
            reply.writeTypedList(list);
            return true;
        }
        
        case GET_TASK_THUMBNAILS_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int id = data.readInt();
            ActivityManager.TaskThumbnails bm = getTaskThumbnails(id);
            reply.writeNoException();
            if (bm != null) {
                reply.writeInt(1);
                bm.writeToParcel(reply, 0);
            } else {
                reply.writeInt(0);
            }
            return true;
        }
        
        case GET_SERVICES_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int maxNum = data.readInt();
            int fl = data.readInt();
            List list = getServices(maxNum, fl);
            reply.writeNoException();
            int N = list != null ? list.size() : -1;
            reply.writeInt(N);
            int i;
            for (i=0; i<N; i++) {
                ActivityManager.RunningServiceInfo info =
                        (ActivityManager.RunningServiceInfo)list.get(i);
                info.writeToParcel(reply, 0);
            }
            return true;
        }

        case GET_PROCESSES_IN_ERROR_STATE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            List<ActivityManager.ProcessErrorStateInfo> list = getProcessesInErrorState();
            reply.writeNoException();
            reply.writeTypedList(list);
            return true;
        }
        
        case GET_RUNNING_APP_PROCESSES_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            List<ActivityManager.RunningAppProcessInfo> list = getRunningAppProcesses();
            reply.writeNoException();
            reply.writeTypedList(list);
            return true;
        }

        case GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            List<ApplicationInfo> list = getRunningExternalApplications();
            reply.writeNoException();
            reply.writeTypedList(list);
            return true;
        }

        case MOVE_TASK_TO_FRONT_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            int fl = data.readInt();
            moveTaskToFront(task, fl);
            reply.writeNoException();
            return true;
        }

        case MOVE_TASK_TO_BACK_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            moveTaskToBack(task);
            reply.writeNoException();
            return true;
        }

        case MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean nonRoot = data.readInt() != 0;
            boolean res = moveActivityTaskToBack(token, nonRoot);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }

        case MOVE_TASK_BACKWARDS_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            moveTaskBackwards(task);
            reply.writeNoException();
            return true;
        }

        case GET_TASK_FOR_ACTIVITY_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean onlyRoot = data.readInt() != 0;
            int res = token != null
                ? getTaskForActivity(token, onlyRoot) : -1;
                reply.writeNoException();
            reply.writeInt(res);
            return true;
        }

        case FINISH_OTHER_INSTANCES_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName className = ComponentName.readFromParcel(data);
            finishOtherInstances(token, className);
            reply.writeNoException();
            return true;
        }

        case REPORT_THUMBNAIL_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Bitmap thumbnail = data.readInt() != 0
                ? Bitmap.CREATOR.createFromParcel(data) : null;
            CharSequence description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            reportThumbnail(token, thumbnail, description);
            reply.writeNoException();
            return true;
        }

        case GET_CONTENT_PROVIDER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            String name = data.readString();
            ContentProviderHolder cph = getContentProvider(app, name);
            reply.writeNoException();
            if (cph != null) {
                reply.writeInt(1);
                cph.writeToParcel(reply, 0);
            } else {
                reply.writeInt(0);
            }
            return true;
        }

        case PUBLISH_CONTENT_PROVIDERS_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            ArrayList<ContentProviderHolder> providers =
                data.createTypedArrayList(ContentProviderHolder.CREATOR);
            publishContentProviders(app, providers);
            reply.writeNoException();
            return true;
        }

        case REMOVE_CONTENT_PROVIDER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            String name = data.readString();
            removeContentProvider(app, name);
            reply.writeNoException();
            return true;
        }
        
        case GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName comp = ComponentName.CREATOR.createFromParcel(data);
            PendingIntent pi = getRunningServiceControlPanel(comp);
            reply.writeNoException();
            PendingIntent.writePendingIntentOrNullToParcel(pi, reply);
            return true;
        }

        case START_SERVICE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Intent service = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            ComponentName cn = startService(app, service, resolvedType);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
            return true;
        }

        case STOP_SERVICE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Intent service = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            int res = stopService(app, service, resolvedType);
            reply.writeNoException();
            reply.writeInt(res);
            return true;
        }

        case STOP_SERVICE_TOKEN_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName className = ComponentName.readFromParcel(data);
            IBinder token = data.readStrongBinder();
            int startId = data.readInt();
            boolean res = stopServiceToken(className, token, startId);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }

        case SET_SERVICE_FOREGROUND_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName className = ComponentName.readFromParcel(data);
            IBinder token = data.readStrongBinder();
            int id = data.readInt();
            Notification notification = null;
            if (data.readInt() != 0) {
                notification = Notification.CREATOR.createFromParcel(data);
            }
            boolean removeNotification = data.readInt() != 0;
            setServiceForeground(className, token, id, notification, removeNotification);
            reply.writeNoException();
            return true;
        }

        case BIND_SERVICE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            IBinder token = data.readStrongBinder();
            Intent service = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            b = data.readStrongBinder();
            int fl = data.readInt();
            IServiceConnection conn = IServiceConnection.Stub.asInterface(b);
            int res = bindService(app, token, service, resolvedType, conn, fl);
            reply.writeNoException();
            reply.writeInt(res);
            return true;
        }

        case UNBIND_SERVICE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IServiceConnection conn = IServiceConnection.Stub.asInterface(b);
            boolean res = unbindService(conn);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }

        case PUBLISH_SERVICE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            IBinder service = data.readStrongBinder();
            publishService(token, intent, service);
            reply.writeNoException();
            return true;
        }

        case UNBIND_FINISHED_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            boolean doRebind = data.readInt() != 0;
            unbindFinished(token, intent, doRebind);
            reply.writeNoException();
            return true;
        }

        case SERVICE_DONE_EXECUTING_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int type = data.readInt();
            int startId = data.readInt();
            int res = data.readInt();
            serviceDoneExecuting(token, type, startId, res);
            reply.writeNoException();
            return true;
        }

        case START_INSTRUMENTATION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName className = ComponentName.readFromParcel(data);
            String profileFile = data.readString();
            int fl = data.readInt();
            Bundle arguments = data.readBundle();
            IBinder b = data.readStrongBinder();
            IInstrumentationWatcher w = IInstrumentationWatcher.Stub.asInterface(b);
            boolean res = startInstrumentation(className, profileFile, fl, arguments, w);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }

        case FINISH_INSTRUMENTATION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            int resultCode = data.readInt();
            Bundle results = data.readBundle();
            finishInstrumentation(app, resultCode, results);
            reply.writeNoException();
            return true;
        }

        case GET_CONFIGURATION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = getConfiguration();
            reply.writeNoException();
            config.writeToParcel(reply, 0);
            return true;
        }

        case UPDATE_CONFIGURATION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            updateConfiguration(config);
            reply.writeNoException();
            return true;
        }

        case SET_REQUESTED_ORIENTATION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int requestedOrientation = data.readInt();
            setRequestedOrientation(token, requestedOrientation);
            reply.writeNoException();
            return true;
        }

        case GET_REQUESTED_ORIENTATION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int req = getRequestedOrientation(token);
            reply.writeNoException();
            reply.writeInt(req);
            return true;
        }

        case GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName cn = getActivityClassForToken(token);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
            return true;
        }

        case GET_PACKAGE_FOR_TOKEN_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            reply.writeNoException();
            reply.writeString(getPackageForToken(token));
            return true;
        }

        case GET_INTENT_SENDER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int type = data.readInt();
            String packageName = data.readString();
            IBinder token = data.readStrongBinder();
            String resultWho = data.readString();
            int requestCode = data.readInt();
            Intent[] requestIntents;
            String[] requestResolvedTypes;
            if (data.readInt() != 0) {
                requestIntents = data.createTypedArray(Intent.CREATOR);
                requestResolvedTypes = data.createStringArray();
            } else {
                requestIntents = null;
                requestResolvedTypes = null;
            }
            int fl = data.readInt();
            IIntentSender res = getIntentSender(type, packageName, token,
                    resultWho, requestCode, requestIntents,
                    requestResolvedTypes, fl);
            reply.writeNoException();
            reply.writeStrongBinder(res != null ? res.asBinder() : null);
            return true;
        }

        case CANCEL_INTENT_SENDER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            cancelIntentSender(r);
            reply.writeNoException();
            return true;
        }

        case GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            String res = getPackageForIntentSender(r);
            reply.writeNoException();
            reply.writeString(res);
            return true;
        }

        case SET_PROCESS_LIMIT_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int max = data.readInt();
            setProcessLimit(max);
            reply.writeNoException();
            return true;
        }

        case GET_PROCESS_LIMIT_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int limit = getProcessLimit();
            reply.writeNoException();
            reply.writeInt(limit);
            return true;
        }

        case SET_PROCESS_FOREGROUND_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int pid = data.readInt();
            boolean isForeground = data.readInt() != 0;
            setProcessForeground(token, pid, isForeground);
            reply.writeNoException();
            return true;
        }

        case CHECK_PERMISSION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String perm = data.readString();
            int pid = data.readInt();
            int uid = data.readInt();
            int res = checkPermission(perm, pid, uid);
            reply.writeNoException();
            reply.writeInt(res);
            return true;
        }

        case CHECK_URI_PERMISSION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int pid = data.readInt();
            int uid = data.readInt();
            int mode = data.readInt();
            int res = checkUriPermission(uri, pid, uid, mode);
            reply.writeNoException();
            reply.writeInt(res);
            return true;
        }
        
        case CLEAR_APP_DATA_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);            
            String packageName = data.readString();
            IPackageDataObserver observer = IPackageDataObserver.Stub.asInterface(
                    data.readStrongBinder());
            boolean res = clearApplicationUserData(packageName, observer);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }
        
        case GRANT_URI_PERMISSION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            String targetPkg = data.readString();
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int mode = data.readInt();
            grantUriPermission(app, targetPkg, uri, mode);
            reply.writeNoException();
            return true;
        }
        
        case REVOKE_URI_PERMISSION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int mode = data.readInt();
            revokeUriPermission(app, uri, mode);
            reply.writeNoException();
            return true;
        }
        
        case SHOW_WAITING_FOR_DEBUGGER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            boolean waiting = data.readInt() != 0;
            showWaitingForDebugger(app, waiting);
            reply.writeNoException();
            return true;
        }

        case GET_MEMORY_INFO_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
            getMemoryInfo(mi);
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
            return true;
        }

        case UNHANDLED_BACK_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            unhandledBack();
            reply.writeNoException();
            return true;
        }

        case OPEN_CONTENT_URI_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri = Uri.parse(data.readString());
            ParcelFileDescriptor pfd = openContentUri(uri);
            reply.writeNoException();
            if (pfd != null) {
                reply.writeInt(1);
                pfd.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            } else {
                reply.writeInt(0);
            }
            return true;
        }
        
        case GOING_TO_SLEEP_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            goingToSleep();
            reply.writeNoException();
            return true;
        }

        case WAKING_UP_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            wakingUp();
            reply.writeNoException();
            return true;
        }

        case SET_DEBUG_APP_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String pn = data.readString();
            boolean wfd = data.readInt() != 0;
            boolean per = data.readInt() != 0;
            setDebugApp(pn, wfd, per);
            reply.writeNoException();
            return true;
        }

        case SET_ALWAYS_FINISH_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            boolean enabled = data.readInt() != 0;
            setAlwaysFinish(enabled);
            reply.writeNoException();
            return true;
        }

        case SET_ACTIVITY_CONTROLLER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityController watcher = IActivityController.Stub.asInterface(
                    data.readStrongBinder());
            setActivityController(watcher);
            return true;
        }

        case ENTER_SAFE_MODE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            enterSafeMode();
            reply.writeNoException();
            return true;
        }

        case NOTE_WAKEUP_ALARM_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender is = IIntentSender.Stub.asInterface(
                    data.readStrongBinder());
            noteWakeupAlarm(is);
            reply.writeNoException();
            return true;
        }

        case KILL_PIDS_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids = data.createIntArray();
            String reason = data.readString();
            boolean secure = data.readInt() != 0;
            boolean res = killPids(pids, reason, secure);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }

        case START_RUNNING_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            String cls = data.readString();
            String action = data.readString();
            String indata = data.readString();
            startRunning(pkg, cls, action, indata);
            reply.writeNoException();
            return true;
        }

        case HANDLE_APPLICATION_CRASH_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app = data.readStrongBinder();
            ApplicationErrorReport.CrashInfo ci = new ApplicationErrorReport.CrashInfo(data);
            handleApplicationCrash(app, ci);
            reply.writeNoException();
            return true;
        }

        case HANDLE_APPLICATION_WTF_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app = data.readStrongBinder();
            String tag = data.readString();
            ApplicationErrorReport.CrashInfo ci = new ApplicationErrorReport.CrashInfo(data);
            boolean res = handleApplicationWtf(app, tag, ci);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }

        case HANDLE_APPLICATION_STRICT_MODE_VIOLATION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app = data.readStrongBinder();
            int violationMask = data.readInt();
            StrictMode.ViolationInfo info = new StrictMode.ViolationInfo(data);
            handleApplicationStrictModeViolation(app, violationMask, info);
            reply.writeNoException();
            return true;
        }

        case SIGNAL_PERSISTENT_PROCESSES_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int sig = data.readInt();
            signalPersistentProcesses(sig);
            reply.writeNoException();
            return true;
        }

        case KILL_BACKGROUND_PROCESSES_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            killBackgroundProcesses(packageName);
            reply.writeNoException();
            return true;
        }

        case KILL_ALL_BACKGROUND_PROCESSES_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            killAllBackgroundProcesses();
            reply.writeNoException();
            return true;
        }
        
        case FORCE_STOP_PACKAGE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            forceStopPackage(packageName);
            reply.writeNoException();
            return true;
        }
        
        case GET_DEVICE_CONFIGURATION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            ConfigurationInfo config = getDeviceConfigurationInfo();
            reply.writeNoException();
            config.writeToParcel(reply, 0);
            return true;
        }
        
        case PROFILE_CONTROL_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String process = data.readString();
            boolean start = data.readInt() != 0;
            int profileType = data.readInt();
            String path = data.readString();
            ParcelFileDescriptor fd = data.readInt() != 0
                    ? data.readFileDescriptor() : null;
            boolean res = profileControl(process, start, path, fd, profileType);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }
        
        case SHUTDOWN_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            boolean res = shutdown(data.readInt());
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }
        
        case STOP_APP_SWITCHES_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            stopAppSwitches();
            reply.writeNoException();
            return true;
        }
        
        case RESUME_APP_SWITCHES_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            resumeAppSwitches();
            reply.writeNoException();
            return true;
        }
        
        case PEEK_SERVICE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            Intent service = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            IBinder binder = peekService(service, resolvedType);
            reply.writeNoException();
            reply.writeStrongBinder(binder);
            return true;
        }
        
        case START_BACKUP_AGENT_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            ApplicationInfo info = ApplicationInfo.CREATOR.createFromParcel(data);
            int backupRestoreMode = data.readInt();
            boolean success = bindBackupAgent(info, backupRestoreMode);
            reply.writeNoException();
            reply.writeInt(success ? 1 : 0);
            return true;
        }

        case BACKUP_AGENT_CREATED_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            IBinder agent = data.readStrongBinder();
            backupAgentCreated(packageName, agent);
            reply.writeNoException();
            return true;
        }

        case UNBIND_BACKUP_AGENT_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            ApplicationInfo info = ApplicationInfo.CREATOR.createFromParcel(data);
            unbindBackupAgent(info);
            reply.writeNoException();
            return true;
        }
        
        case REGISTER_ACTIVITY_WATCHER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityWatcher watcher = IActivityWatcher.Stub.asInterface(
                    data.readStrongBinder());
            registerActivityWatcher(watcher);
            return true;
        }
        
        case UNREGISTER_ACTIVITY_WATCHER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityWatcher watcher = IActivityWatcher.Stub.asInterface(
                    data.readStrongBinder());
            unregisterActivityWatcher(watcher);
            return true;
        }
        
        case START_ACTIVITY_IN_PACKAGE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int uid = data.readInt();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            IBinder resultTo = data.readStrongBinder();
            String resultWho = data.readString();    
            int requestCode = data.readInt();
            boolean onlyIfNeeded = data.readInt() != 0;
            int result = startActivityInPackage(uid, intent, resolvedType,
                    resultTo, resultWho, requestCode, onlyIfNeeded);
            reply.writeNoException();
            reply.writeInt(result);
            return true;
        }
        
        case KILL_APPLICATION_WITH_UID_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int uid = data.readInt();
            killApplicationWithUid(pkg, uid);
            reply.writeNoException();
            return true;
        }
        
        case CLOSE_SYSTEM_DIALOGS_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String reason = data.readString();
            closeSystemDialogs(reason);
            reply.writeNoException();
            return true;
        }
        
        case GET_PROCESS_MEMORY_INFO_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids = data.createIntArray();
            Debug.MemoryInfo[] res =  getProcessMemoryInfo(pids);
            reply.writeNoException();
            reply.writeTypedArray(res, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            return true;
        }

        case KILL_APPLICATION_PROCESS_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String processName = data.readString();
            int uid = data.readInt();
            killApplicationProcess(processName, uid);
            reply.writeNoException();
            return true;
        }
        
        case OVERRIDE_PENDING_TRANSITION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            String packageName = data.readString();
            int enterAnim = data.readInt();
            int exitAnim = data.readInt();
            overridePendingTransition(token, packageName, enterAnim, exitAnim);
            reply.writeNoException();
            return true;
        }
        
        case IS_USER_A_MONKEY_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            boolean areThey = isUserAMonkey();
            reply.writeNoException();
            reply.writeInt(areThey ? 1 : 0);
            return true;
        }
        
        case FINISH_HEAVY_WEIGHT_APP_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            finishHeavyWeightApp();
            reply.writeNoException();
            return true;
        }

        case IS_IMMERSIVE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean isit = isImmersive(token);
            reply.writeNoException();
            reply.writeInt(isit ? 1 : 0);
            return true;
        }

        case SET_IMMERSIVE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean imm = data.readInt() == 1;
            setImmersive(token, imm);
            reply.writeNoException();
            return true;
        }
        
        case IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            boolean isit = isTopActivityImmersive();
            reply.writeNoException();
            reply.writeInt(isit ? 1 : 0);
            return true;
        }

        case CRASH_APPLICATION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int uid = data.readInt();
            int initialPid = data.readInt();
            String packageName = data.readString();
            String message = data.readString();
            crashApplication(uid, initialPid, packageName, message);
            reply.writeNoException();
            return true;
        }

        case GET_PROVIDER_MIME_TYPE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri = Uri.CREATOR.createFromParcel(data);
            String type = getProviderMimeType(uri);
            reply.writeNoException();
            reply.writeString(type);
            return true;
        }

        case NEW_URI_PERMISSION_OWNER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String name = data.readString();
            IBinder perm = newUriPermissionOwner(name);
            reply.writeNoException();
            reply.writeStrongBinder(perm);
            return true;
        }

        case GRANT_URI_PERMISSION_FROM_OWNER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder owner = data.readStrongBinder();
            int fromUid = data.readInt();
            String targetPkg = data.readString();
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int mode = data.readInt();
            grantUriPermissionFromOwner(owner, fromUid, targetPkg, uri, mode);
            reply.writeNoException();
            return true;
        }

        case REVOKE_URI_PERMISSION_FROM_OWNER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder owner = data.readStrongBinder();
            Uri uri = null;
            if (data.readInt() != 0) {
                Uri.CREATOR.createFromParcel(data);
            }
            int mode = data.readInt();
            revokeUriPermissionFromOwner(owner, uri, mode);
            reply.writeNoException();
            return true;
        }

        case CHECK_GRANT_URI_PERMISSION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int callingUid = data.readInt();
            String targetPkg = data.readString();
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int modeFlags = data.readInt();
            int res = checkGrantUriPermission(callingUid, targetPkg, uri, modeFlags);
            reply.writeNoException();
            reply.writeInt(res);
            return true;
        }

        case DUMP_HEAP_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            String process = data.readString();
            boolean managed = data.readInt() != 0;
            String path = data.readString();
            ParcelFileDescriptor fd = data.readInt() != 0
                    ? data.readFileDescriptor() : null;
            boolean res = dumpHeap(process, managed, path, fd);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }

        case START_ACTIVITIES_IN_PACKAGE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int uid = data.readInt();
            Intent[] intents = data.createTypedArray(Intent.CREATOR);
            String[] resolvedTypes = data.createStringArray();
            IBinder resultTo = data.readStrongBinder();
            int result = startActivitiesInPackage(uid, intents, resolvedTypes, resultTo);
            reply.writeNoException();
            reply.writeInt(result);
            return true;
        }

        case START_ACTIVITIES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Intent[] intents = data.createTypedArray(Intent.CREATOR);
            String[] resolvedTypes = data.createStringArray();
            IBinder resultTo = data.readStrongBinder();
            int result = startActivities(app, intents, resolvedTypes, resultTo);
            reply.writeNoException();
            reply.writeInt(result);
            return true;
        }

        case GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int mode = getFrontActivityScreenCompatMode();
            reply.writeNoException();
            reply.writeInt(mode);
            return true;
        }

        case SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int mode = data.readInt();
            setFrontActivityScreenCompatMode(mode);
            reply.writeNoException();
            reply.writeInt(mode);
            return true;
        }

        case GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int mode = getPackageScreenCompatMode(pkg);
            reply.writeNoException();
            reply.writeInt(mode);
            return true;
        }

        case SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int mode = data.readInt();
            setPackageScreenCompatMode(pkg, mode);
            reply.writeNoException();
            return true;
        }
        
        case SWITCH_USER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int userid = data.readInt();
            boolean result = switchUser(userid);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            return true;
        }
        
        case REMOVE_SUB_TASK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int taskId = data.readInt();
            int subTaskIndex = data.readInt();
            boolean result = removeSubTask(taskId, subTaskIndex);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            return true;
        }

        case REMOVE_TASK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int taskId = data.readInt();
            int fl = data.readInt();
            boolean result = removeTask(taskId, fl);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            return true;
        }

        case REGISTER_PROCESS_OBSERVER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IProcessObserver observer = IProcessObserver.Stub.asInterface(
                    data.readStrongBinder());
            registerProcessObserver(observer);
            return true;
        }

        case UNREGISTER_PROCESS_OBSERVER_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IProcessObserver observer = IProcessObserver.Stub.asInterface(
                    data.readStrongBinder());
            unregisterProcessObserver(observer);
            return true;
        }

        case GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            boolean ask = getPackageAskScreenCompat(pkg);
            reply.writeNoException();
            reply.writeInt(ask ? 1 : 0);
            return true;
        }

        case SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            boolean ask = data.readInt() != 0;
            setPackageAskScreenCompat(pkg, ask);
            reply.writeNoException();
            return true;
        }

        case IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            boolean res = isIntentSenderTargetedToPackage(r);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            return true;
        }

        case UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            updatePersistentConfiguration(config);
            reply.writeNoException();
            return true;
        }

        case GET_PROCESS_PSS_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids = data.createIntArray();
            long[] pss = getProcessPss(pids);
            reply.writeNoException();
            reply.writeLongArray(pss);
            return true;
        }

        case SHOW_BOOT_MESSAGE_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            CharSequence msg = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            boolean always = data.readInt() != 0;
            showBootMessage(msg, always);
            reply.writeNoException();
            return true;
        }

        case DISMISS_KEYGUARD_ON_NEXT_ACTIVITY_TRANSACTION: {
            data.enforceInterface(IActivityManager.descriptor);
            dismissKeyguardOnNextActivity();
            reply.writeNoException();
            return true;
        }

        }

        return super.onTransact(code, data, reply, flags);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.121 -0500", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "5E3B69CCD103133228ACADBBDEF1CE7E")
    
public IBinder asBinder() {
        return this;
    }
}

class ActivityManagerProxy implements IActivityManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.466 -0500", hash_original_field = "5AE257E0853836D9B54E1EF6497B909F", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.133 -0500", hash_original_method = "3287CA7C2EB4AADDF2EFFF2704D2BE9E", hash_generated_method = "2AFCACC011B87F16CE3E5DBD44A8D328")
    
public ActivityManagerProxy(IBinder remote)
    {
        mRemote = remote;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.135 -0500", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "4DCC3A1AD60EC3BEEFB87DCA83743448")
    
public IBinder asBinder()
    {
        return mRemote;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.138 -0500", hash_original_method = "ECBE4259B26F016D18C1CACD48E02238", hash_generated_method = "E90D5287DCC87AD0FA486F17657E915F")
    
public int startActivity(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, String profileFile, ParcelFileDescriptor profileFd,
            boolean autoStopProfiler) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        intent.writeToParcel(data, 0);
        data.writeString(resolvedType);
        data.writeTypedArray(grantedUriPermissions, 0);
        data.writeInt(grantedMode);
        data.writeStrongBinder(resultTo);
        data.writeString(resultWho);
        data.writeInt(requestCode);
        data.writeInt(onlyIfNeeded ? 1 : 0);
        data.writeInt(debug ? 1 : 0);
        data.writeString(profileFile);
        if (profileFd != null) {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } else {
            data.writeInt(0);
        }
        data.writeInt(autoStopProfiler ? 1 : 0);
        mRemote.transact(START_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        int result = reply.readInt();
        reply.recycle();
        data.recycle();
        return result;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.141 -0500", hash_original_method = "BF42E410BABF1DD283EC1102C9637003", hash_generated_method = "A17DB3C91B28B5EE1A0FF33E9705E231")
    
public WaitResult startActivityAndWait(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, String profileFile, ParcelFileDescriptor profileFd,
            boolean autoStopProfiler) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        intent.writeToParcel(data, 0);
        data.writeString(resolvedType);
        data.writeTypedArray(grantedUriPermissions, 0);
        data.writeInt(grantedMode);
        data.writeStrongBinder(resultTo);
        data.writeString(resultWho);
        data.writeInt(requestCode);
        data.writeInt(onlyIfNeeded ? 1 : 0);
        data.writeInt(debug ? 1 : 0);
        data.writeString(profileFile);
        if (profileFd != null) {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } else {
            data.writeInt(0);
        }
        data.writeInt(autoStopProfiler ? 1 : 0);
        mRemote.transact(START_ACTIVITY_AND_WAIT_TRANSACTION, data, reply, 0);
        reply.readException();
        WaitResult result = WaitResult.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
        return result;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.144 -0500", hash_original_method = "47F7B475943E725D61EF4FCECF2C263D", hash_generated_method = "ED1F66873171D2FE50671EE554F1D187")
    
public int startActivityWithConfig(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, Configuration config) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        intent.writeToParcel(data, 0);
        data.writeString(resolvedType);
        data.writeTypedArray(grantedUriPermissions, 0);
        data.writeInt(grantedMode);
        data.writeStrongBinder(resultTo);
        data.writeString(resultWho);
        data.writeInt(requestCode);
        data.writeInt(onlyIfNeeded ? 1 : 0);
        data.writeInt(debug ? 1 : 0);
        config.writeToParcel(data, 0);
        mRemote.transact(START_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        int result = reply.readInt();
        reply.recycle();
        data.recycle();
        return result;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.147 -0500", hash_original_method = "FD56EAF7591CCE02A2449EB3C30AEF02", hash_generated_method = "02F992F538BA8B05F0348D8BB046C3D8")
    
public int startActivityIntentSender(IApplicationThread caller,
            IntentSender intent, Intent fillInIntent, String resolvedType,
            IBinder resultTo, String resultWho, int requestCode,
            int flagsMask, int flagsValues) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        intent.writeToParcel(data, 0);
        if (fillInIntent != null) {
            data.writeInt(1);
            fillInIntent.writeToParcel(data, 0);
        } else {
            data.writeInt(0);
        }
        data.writeString(resolvedType);
        data.writeStrongBinder(resultTo);
        data.writeString(resultWho);
        data.writeInt(requestCode);
        data.writeInt(flagsMask);
        data.writeInt(flagsValues);
        mRemote.transact(START_ACTIVITY_INTENT_SENDER_TRANSACTION, data, reply, 0);
        reply.readException();
        int result = reply.readInt();
        reply.recycle();
        data.recycle();
        return result;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.149 -0500", hash_original_method = "A532370FCCB6C359BF27FA22D92F73F5", hash_generated_method = "26B1D9A2FC86774EE7FF60A5EDFF0062")
    
public boolean startNextMatchingActivity(IBinder callingActivity,
            Intent intent) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(callingActivity);
        intent.writeToParcel(data, 0);
        mRemote.transact(START_NEXT_MATCHING_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        int result = reply.readInt();
        reply.recycle();
        data.recycle();
        return ((result) == 1); 
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.152 -0500", hash_original_method = "91E82D39E0DA0BAF3D9668B58FD8BE2D", hash_generated_method = "51169BDC420B5824522C25A41C863501")
    
public boolean finishActivity(IBinder token, int resultCode, Intent resultData)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(resultCode);
        if (resultData != null) {
            data.writeInt(1);
            resultData.writeToParcel(data, 0);
        } else {
            data.writeInt(0);
        }
        mRemote.transact(FINISH_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.154 -0500", hash_original_method = "352728C633440E8BBFDE1A24B12C26C6", hash_generated_method = "B62F566EA6191E17DD5D58417ABC3A86")
    
public void finishSubActivity(IBinder token, String resultWho, int requestCode) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeString(resultWho);
        data.writeInt(requestCode);
        mRemote.transact(FINISH_SUB_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.156 -0500", hash_original_method = "03769BB85CE515FA0FB5B3DCD0709D8A", hash_generated_method = "EBD20C3CB3741A00E25B4BB52DD4C52B")
    
public boolean willActivityBeVisible(IBinder token) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(WILL_ACTIVITY_BE_VISIBLE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.159 -0500", hash_original_method = "D0EC9750E66DC0864B7AF9A5D43ED043", hash_generated_method = "19E2E9C7ACF4AD3E21E78D982988DA71")
    
public Intent registerReceiver(IApplicationThread caller, String packageName,
            IIntentReceiver receiver,
            IntentFilter filter, String perm) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeString(packageName);
        data.writeStrongBinder(receiver != null ? receiver.asBinder() : null);
        filter.writeToParcel(data, 0);
        data.writeString(perm);
        mRemote.transact(REGISTER_RECEIVER_TRANSACTION, data, reply, 0);
        reply.readException();
        Intent intent = null;
        int haveIntent = reply.readInt();
        if (haveIntent != 0) {
            intent = Intent.CREATOR.createFromParcel(reply);
        }
        reply.recycle();
        data.recycle();
        return intent;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.161 -0500", hash_original_method = "CF62E9563222E9365AE1815E546E05AA", hash_generated_method = "9D8132934C9E78A1FAB10E2D09166DA2")
    
public void unregisterReceiver(IIntentReceiver receiver) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(receiver.asBinder());
        mRemote.transact(UNREGISTER_RECEIVER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.164 -0500", hash_original_method = "189D2A1B1A14BF35BFCC0BB8AD6C1CE5", hash_generated_method = "888A11E06E78C3422A4A301FA0F9D3C6")
    
public int broadcastIntent(IApplicationThread caller,
            Intent intent, String resolvedType,  IIntentReceiver resultTo,
            int resultCode, String resultData, Bundle map,
            String requiredPermission, boolean serialized,
            boolean sticky) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        intent.writeToParcel(data, 0);
        data.writeString(resolvedType);
        data.writeStrongBinder(resultTo != null ? resultTo.asBinder() : null);
        data.writeInt(resultCode);
        data.writeString(resultData);
        data.writeBundle(map);
        data.writeString(requiredPermission);
        data.writeInt(serialized ? 1 : 0);
        data.writeInt(sticky ? 1 : 0);
        mRemote.transact(BROADCAST_INTENT_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        reply.recycle();
        data.recycle();
        return res;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.166 -0500", hash_original_method = "84F4ECE33F63E245917246490F7877AA", hash_generated_method = "34A1621DAE16DD88F0029BD0C69D5068")
    
public void unbroadcastIntent(IApplicationThread caller, Intent intent) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        intent.writeToParcel(data, 0);
        mRemote.transact(UNBROADCAST_INTENT_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.169 -0500", hash_original_method = "8BFF18A0F9A8EDDD76A319C280B21CDC", hash_generated_method = "71EA1218356A061D08BC661B923502E4")
    
public void finishReceiver(IBinder who, int resultCode, String resultData, Bundle map, boolean abortBroadcast) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(who);
        data.writeInt(resultCode);
        data.writeString(resultData);
        data.writeBundle(map);
        data.writeInt(abortBroadcast ? 1 : 0);
        mRemote.transact(FINISH_RECEIVER_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.171 -0500", hash_original_method = "1E67E239E5F2A2540F1E032AB272605E", hash_generated_method = "EA72555927E01EA898A939D9CBED2222")
    
public void attachApplication(IApplicationThread app) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(app.asBinder());
        mRemote.transact(ATTACH_APPLICATION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.173 -0500", hash_original_method = "BC9E49082B5DC06C707641FC7F3E31F5", hash_generated_method = "C4AF274E01F16C2E15FEE5C61403918D")
    
public void activityIdle(IBinder token, Configuration config, boolean stopProfiling)
            throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        if (config != null) {
            data.writeInt(1);
            config.writeToParcel(data, 0);
        } else {
            data.writeInt(0);
        }
        data.writeInt(stopProfiling ? 1 : 0);
        mRemote.transact(ACTIVITY_IDLE_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.176 -0500", hash_original_method = "4914FFC78B966DEBED0BDBFF9D70FB17", hash_generated_method = "9CD3224B1D071AAA439169947C7585BE")
    
public void activityPaused(IBinder token) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(ACTIVITY_PAUSED_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.179 -0500", hash_original_method = "F5DE3AC45B6CCF74477AF45EB0878099", hash_generated_method = "9DC8D0810D62F08BFEA35F170093AD8B")
    
public void activityStopped(IBinder token, Bundle state,
            Bitmap thumbnail, CharSequence description) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeBundle(state);
        if (thumbnail != null) {
            data.writeInt(1);
            thumbnail.writeToParcel(data, 0);
        } else {
            data.writeInt(0);
        }
        TextUtils.writeToParcel(description, data, 0);
        mRemote.transact(ACTIVITY_STOPPED_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.181 -0500", hash_original_method = "CA8224B1DA5730B462FB3F604509C1DB", hash_generated_method = "61236843B328B325FAE671DD927736EC")
    
public void activitySlept(IBinder token) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(ACTIVITY_SLEPT_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.183 -0500", hash_original_method = "9A100D49A0D535BB686DAA00CAC541FF", hash_generated_method = "B0BA2B4A67B7D2BDF7CAD1582569DB75")
    
public void activityDestroyed(IBinder token) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(ACTIVITY_DESTROYED_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.185 -0500", hash_original_method = "7637EF2082F6942F953796EFCEAA3730", hash_generated_method = "E7DD93FCECDCC75E479D760BCBD5BD9E")
    
public String getCallingPackage(IBinder token) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_CALLING_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.189 -0500", hash_original_method = "0E9D91A20FCD3BCFB3517DB475147FAB", hash_generated_method = "07D579D01F63305F46471F956EBF6C71")
    
public ComponentName getCallingActivity(IBinder token)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_CALLING_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        ComponentName res = ComponentName.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.191 -0500", hash_original_method = "FAA1C4AE039868246AED533CDCA15CD7", hash_generated_method = "33FEE68D40695BAB97A161BE7E2D9B42")
    
public List getTasks(int maxNum, int flags,
            IThumbnailReceiver receiver) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(maxNum);
        data.writeInt(flags);
        data.writeStrongBinder(receiver != null ? receiver.asBinder() : null);
        mRemote.transact(GET_TASKS_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList list = null;
        int N = reply.readInt();
        if (N >= 0) {
            list = new ArrayList();
            while (N > 0) {
                ActivityManager.RunningTaskInfo info =
                        ActivityManager.RunningTaskInfo.CREATOR
                        .createFromParcel(reply);
                list.add(info);
                N--;
            }
        }
        data.recycle();
        reply.recycle();
        return list;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.194 -0500", hash_original_method = "9D3E8FF17F102376D7C7BE9D34CE4F93", hash_generated_method = "9EA28E38984E76AFD4EA0C62738722B3")
    
public List<ActivityManager.RecentTaskInfo> getRecentTasks(int maxNum,
            int flags) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(maxNum);
        data.writeInt(flags);
        mRemote.transact(GET_RECENT_TASKS_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.RecentTaskInfo> list
            = reply.createTypedArrayList(ActivityManager.RecentTaskInfo.CREATOR);
        data.recycle();
        reply.recycle();
        return list;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.196 -0500", hash_original_method = "10D095A12B52FE928E4AEC7C3F42A832", hash_generated_method = "F459459F2B052E2CA97E3955E77132AD")
    
public ActivityManager.TaskThumbnails getTaskThumbnails(int id) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(id);
        mRemote.transact(GET_TASK_THUMBNAILS_TRANSACTION, data, reply, 0);
        reply.readException();
        ActivityManager.TaskThumbnails bm = null;
        if (reply.readInt() != 0) {
            bm = ActivityManager.TaskThumbnails.CREATOR.createFromParcel(reply);
        }
        data.recycle();
        reply.recycle();
        return bm;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.198 -0500", hash_original_method = "7671DD1471581027B2C414BE0E3CE4A6", hash_generated_method = "376D747FECE715D0D3E36318F8B06064")
    
public List getServices(int maxNum, int flags) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(maxNum);
        data.writeInt(flags);
        mRemote.transact(GET_SERVICES_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList list = null;
        int N = reply.readInt();
        if (N >= 0) {
            list = new ArrayList();
            while (N > 0) {
                ActivityManager.RunningServiceInfo info =
                        ActivityManager.RunningServiceInfo.CREATOR
                        .createFromParcel(reply);
                list.add(info);
                N--;
            }
        }
        data.recycle();
        reply.recycle();
        return list;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.201 -0500", hash_original_method = "2AE453A6460D5AF368C9AC4C4862314B", hash_generated_method = "FB1C94137333C6EB0EC2EF622F5A1CC2")
    
public List<ActivityManager.ProcessErrorStateInfo> getProcessesInErrorState()
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_PROCESSES_IN_ERROR_STATE_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.ProcessErrorStateInfo> list
            = reply.createTypedArrayList(ActivityManager.ProcessErrorStateInfo.CREATOR);
        data.recycle();
        reply.recycle();
        return list;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.203 -0500", hash_original_method = "8E45CD57BE18A4B76C3A3E0DA22BC8B7", hash_generated_method = "F9F111955936ACAA4A27F65E3D7BD6E7")
    
public List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses()
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_RUNNING_APP_PROCESSES_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.RunningAppProcessInfo> list
        = reply.createTypedArrayList(ActivityManager.RunningAppProcessInfo.CREATOR);
        data.recycle();
        reply.recycle();
        return list;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.206 -0500", hash_original_method = "2FAC851B003A84469F94E88A81DA29C3", hash_generated_method = "8009C1CF59D450A32EC4A3FCA71A848C")
    
public List<ApplicationInfo> getRunningExternalApplications()
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ApplicationInfo> list
        = reply.createTypedArrayList(ApplicationInfo.CREATOR);
        data.recycle();
        reply.recycle();
        return list;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.208 -0500", hash_original_method = "DABF13B8F45F6A065880490CD0DBD1A0", hash_generated_method = "86FEE5E1B0BD8596ADE092E16BA75A52")
    
public void moveTaskToFront(int task, int flags) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(task);
        data.writeInt(flags);
        mRemote.transact(MOVE_TASK_TO_FRONT_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.210 -0500", hash_original_method = "7FFB6E49EA553237E0A3F53A2CDFD87F", hash_generated_method = "47D437DB1433CBA7AA6FB6A58CAD958B")
    
public void moveTaskToBack(int task) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(task);
        mRemote.transact(MOVE_TASK_TO_BACK_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.213 -0500", hash_original_method = "7F4F39C4D7AB58BCB5DB152705A9F80A", hash_generated_method = "4F4514F7088AFAFA7BCCC487E00AFDAE")
    
public boolean moveActivityTaskToBack(IBinder token, boolean nonRoot)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(nonRoot ? 1 : 0);
        mRemote.transact(MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.215 -0500", hash_original_method = "48BD6DC2300FE39DD3A4B34C3DD91993", hash_generated_method = "3CE0B929E80B7D4E98E6181EB04B8C78")
    
public void moveTaskBackwards(int task) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(task);
        mRemote.transact(MOVE_TASK_BACKWARDS_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.217 -0500", hash_original_method = "3FABC29A3C68690EBF6B4F44EE4A5D23", hash_generated_method = "70118195AF9E436ACA1AEC3E49413BD7")
    
public int getTaskForActivity(IBinder token, boolean onlyRoot) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(onlyRoot ? 1 : 0);
        mRemote.transact(GET_TASK_FOR_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.220 -0500", hash_original_method = "AF696C3AA9BD79AC1F2D6780E820F3FA", hash_generated_method = "25412AEEA00285D39A07864F24770BDA")
    
public void finishOtherInstances(IBinder token, ComponentName className) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        ComponentName.writeToParcel(className, data);
        mRemote.transact(FINISH_OTHER_INSTANCES_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.222 -0500", hash_original_method = "4B3E31ABB8C007E1B3828F729DFD9393", hash_generated_method = "D6FCA294DB0614452B74E76AEC230237")
    
public void reportThumbnail(IBinder token,
                                Bitmap thumbnail, CharSequence description) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        if (thumbnail != null) {
            data.writeInt(1);
            thumbnail.writeToParcel(data, 0);
        } else {
            data.writeInt(0);
        }
        TextUtils.writeToParcel(description, data, 0);
        mRemote.transact(REPORT_THUMBNAIL_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.225 -0500", hash_original_method = "EC6CF87E25124312A62325C5F062E996", hash_generated_method = "23289B2C8A97A193C6A640C43C016729")
    
public ContentProviderHolder getContentProvider(IApplicationThread caller,
                                                    String name) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeString(name);
        mRemote.transact(GET_CONTENT_PROVIDER_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        ContentProviderHolder cph = null;
        if (res != 0) {
            cph = ContentProviderHolder.CREATOR.createFromParcel(reply);
        }
        data.recycle();
        reply.recycle();
        return cph;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.227 -0500", hash_original_method = "9C5D73DEFA4B6B21F8A4E01DC5E46521", hash_generated_method = "AB6A54884D76C8AFF4D66A6C2ECB16E9")
    
public void publishContentProviders(IApplicationThread caller,
                                        List<ContentProviderHolder> providers) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeTypedList(providers);
        mRemote.transact(PUBLISH_CONTENT_PROVIDERS_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.229 -0500", hash_original_method = "6E983079D2A10BB8E3DF4E66B032EE6D", hash_generated_method = "3ED434A13B032E0C048D43C1E99B78F4")
    
public void removeContentProvider(IApplicationThread caller,
            String name) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeString(name);
        mRemote.transact(REMOVE_CONTENT_PROVIDER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.233 -0500", hash_original_method = "E5355EA6A0F8270964E816C69524096C", hash_generated_method = "F267E26CC01122BD1644DC0D99ACCE18")
    
public PendingIntent getRunningServiceControlPanel(ComponentName service)
            throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        service.writeToParcel(data, 0);
        mRemote.transact(GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION, data, reply, 0);
        reply.readException();
        PendingIntent res = PendingIntent.readPendingIntentOrNullFromParcel(reply);
        data.recycle();
        reply.recycle();
        return res;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.235 -0500", hash_original_method = "A683CF3BA039B3B97AA6ADC23E6FBDCC", hash_generated_method = "4DFC3DFD59E9762AC83D5695EA3033C5")
    
public ComponentName startService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        service.writeToParcel(data, 0);
        data.writeString(resolvedType);
        mRemote.transact(START_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        ComponentName res = ComponentName.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.238 -0500", hash_original_method = "B5D9E3A4F6ABA893303F2F02B64751B8", hash_generated_method = "DDEAFB100267FEFD24C6BF3765AE871B")
    
public int stopService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        service.writeToParcel(data, 0);
        data.writeString(resolvedType);
        mRemote.transact(STOP_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        reply.recycle();
        data.recycle();
        return res;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.240 -0500", hash_original_method = "DB1BCCF2CB5E2532E24072B1F607F963", hash_generated_method = "184CE72473FFECB49C50B085FAAA5C0A")
    
public boolean stopServiceToken(ComponentName className, IBinder token,
            int startId) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        ComponentName.writeToParcel(className, data);
        data.writeStrongBinder(token);
        data.writeInt(startId);
        mRemote.transact(STOP_SERVICE_TOKEN_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.242 -0500", hash_original_method = "9DE0D26C134349F3DA011E11517F3FF5", hash_generated_method = "91C32DCC5A4085EAF8842C9D61455A8A")
    
public void setServiceForeground(ComponentName className, IBinder token,
            int id, Notification notification, boolean removeNotification) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        ComponentName.writeToParcel(className, data);
        data.writeStrongBinder(token);
        data.writeInt(id);
        if (notification != null) {
            data.writeInt(1);
            notification.writeToParcel(data, 0);
        } else {
            data.writeInt(0);
        }
        data.writeInt(removeNotification ? 1 : 0);
        mRemote.transact(SET_SERVICE_FOREGROUND_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.244 -0500", hash_original_method = "A1E6D6F237E88697017FA79FBE451840", hash_generated_method = "4FE4CB531D3D1E610FC3B8C8936D4387")
    
public int bindService(IApplicationThread caller, IBinder token,
            Intent service, String resolvedType, IServiceConnection connection,
            int flags) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeStrongBinder(token);
        service.writeToParcel(data, 0);
        data.writeString(resolvedType);
        data.writeStrongBinder(connection.asBinder());
        data.writeInt(flags);
        mRemote.transact(BIND_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.247 -0500", hash_original_method = "E0BD37EB96539E724DE863D335954DC9", hash_generated_method = "D84E20B65F38C3185763843309B74848")
    
public boolean unbindService(IServiceConnection connection) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(connection.asBinder());
        mRemote.transact(UNBIND_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        return res;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.249 -0500", hash_original_method = "87A207496B270585D5EEA34C1AF57170", hash_generated_method = "4462F656EA9D5EA3D6CEFD3671508A7F")
    
public void publishService(IBinder token,
            Intent intent, IBinder service) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        intent.writeToParcel(data, 0);
        data.writeStrongBinder(service);
        mRemote.transact(PUBLISH_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.252 -0500", hash_original_method = "3796516624A8D493E471933ECF7A3CD3", hash_generated_method = "9B7ADC703FC69B21C751F2AC53DC023D")
    
public void unbindFinished(IBinder token, Intent intent, boolean doRebind)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        intent.writeToParcel(data, 0);
        data.writeInt(doRebind ? 1 : 0);
        mRemote.transact(UNBIND_FINISHED_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.255 -0500", hash_original_method = "1CB80C62A00C622E35F1B57A132292E9", hash_generated_method = "C744915C87A8399243FE611DD2B06E2A")
    
public void serviceDoneExecuting(IBinder token, int type, int startId,
            int res) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(type);
        data.writeInt(startId);
        data.writeInt(res);
        mRemote.transact(SERVICE_DONE_EXECUTING_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.258 -0500", hash_original_method = "BEF476EE5F43517187661CDC39F2A448", hash_generated_method = "F04BC11BD4A3C58E2E735D8516BD4D8F")
    
public IBinder peekService(Intent service, String resolvedType) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        service.writeToParcel(data, 0);
        data.writeString(resolvedType);
        mRemote.transact(PEEK_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        IBinder binder = reply.readStrongBinder();
        reply.recycle();
        data.recycle();
        return binder;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.260 -0500", hash_original_method = "7AACC08C389BEE0061373162626F356D", hash_generated_method = "AA1E44AD81B9EBF1F713ABE3C50DF127")
    
public boolean bindBackupAgent(ApplicationInfo app, int backupRestoreMode)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        app.writeToParcel(data, 0);
        data.writeInt(backupRestoreMode);
        mRemote.transact(START_BACKUP_AGENT_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean success = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        return success;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.262 -0500", hash_original_method = "ADE4561AB0FC3828104C329F05A9B88C", hash_generated_method = "AE2CC0186AD5952626B2A21B93B551E0")
    
public void backupAgentCreated(String packageName, IBinder agent) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        data.writeStrongBinder(agent);
        mRemote.transact(BACKUP_AGENT_CREATED_TRANSACTION, data, reply, 0);
        reply.recycle();
        data.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.265 -0500", hash_original_method = "80BB0DB939AA2A14DC79CE879293739F", hash_generated_method = "10C56D43EEE57EA41B8C80737EC74D7E")
    
public void unbindBackupAgent(ApplicationInfo app) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        app.writeToParcel(data, 0);
        mRemote.transact(UNBIND_BACKUP_AGENT_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.267 -0500", hash_original_method = "7977DF3866173BBD9227641CB70C5B9A", hash_generated_method = "FFC84FBF4BC07DAEA44CAFA0569B6003")
    
public boolean startInstrumentation(ComponentName className, String profileFile,
            int flags, Bundle arguments, IInstrumentationWatcher watcher)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        ComponentName.writeToParcel(className, data);
        data.writeString(profileFile);
        data.writeInt(flags);
        data.writeBundle(arguments);
        data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        mRemote.transact(START_INSTRUMENTATION_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        return res;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.269 -0500", hash_original_method = "D76B5F1B397FC7028B59F12CA3604783", hash_generated_method = "831CB2DF12376D9F34A73FB6A38AD0FE")
    
public void finishInstrumentation(IApplicationThread target,
            int resultCode, Bundle results) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(target != null ? target.asBinder() : null);
        data.writeInt(resultCode);
        data.writeBundle(results);
        mRemote.transact(FINISH_INSTRUMENTATION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.272 -0500", hash_original_method = "E824FA9DB2D76671E24682EC782F4756", hash_generated_method = "C53BC202F00DE47F4553FC79728EB261")
    
public Configuration getConfiguration() throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        Configuration res = Configuration.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
        return res;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.274 -0500", hash_original_method = "76911A2717FEEEC7D6B4E93DC7F2427C", hash_generated_method = "7CE47ECB50CAA90CB9D4AD60928064FA")
    
public void updateConfiguration(Configuration values) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        values.writeToParcel(data, 0);
        mRemote.transact(UPDATE_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.276 -0500", hash_original_method = "65FC5D17EF9FF3BF1BFFDA9CCA9A4BE1", hash_generated_method = "F777881CD8012569022FA00276F08A4E")
    
public void setRequestedOrientation(IBinder token, int requestedOrientation)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(requestedOrientation);
        mRemote.transact(SET_REQUESTED_ORIENTATION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.279 -0500", hash_original_method = "505D3FD7966F547E2BAA16E1C1C5F05B", hash_generated_method = "51F0A649D506FE11F1921666DDC0C743")
    
public int getRequestedOrientation(IBinder token) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_REQUESTED_ORIENTATION_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.281 -0500", hash_original_method = "BCB55F79D75B3B83E49A75043EE249A9", hash_generated_method = "D465FE1761F65F48610E42731F8DE3FA")
    
public ComponentName getActivityClassForToken(IBinder token)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION, data, reply, 0);
        reply.readException();
        ComponentName res = ComponentName.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.283 -0500", hash_original_method = "9BAE752D062408101ED2F689CF20DDD1", hash_generated_method = "9AB00211F8DE16970BC75A6AE4D33FDA")
    
public String getPackageForToken(IBinder token) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_PACKAGE_FOR_TOKEN_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.286 -0500", hash_original_method = "AE56AE3D6914251F9FFFA7E33C698EB6", hash_generated_method = "E66CCE269AC73F81C8DC21D4E2D58FE6")
    
public IIntentSender getIntentSender(int type,
            String packageName, IBinder token, String resultWho,
            int requestCode, Intent[] intents, String[] resolvedTypes, int flags)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(type);
        data.writeString(packageName);
        data.writeStrongBinder(token);
        data.writeString(resultWho);
        data.writeInt(requestCode);
        if (intents != null) {
            data.writeInt(1);
            data.writeTypedArray(intents, 0);
            data.writeStringArray(resolvedTypes);
        } else {
            data.writeInt(0);
        }
        data.writeInt(flags);
        mRemote.transact(GET_INTENT_SENDER_TRANSACTION, data, reply, 0);
        reply.readException();
        IIntentSender res = IIntentSender.Stub.asInterface(
            reply.readStrongBinder());
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.288 -0500", hash_original_method = "D459AA1ADAE84FC2B7BB3BA73C047FDB", hash_generated_method = "D4375A674D36D0888038D901E0F93F83")
    
public void cancelIntentSender(IIntentSender sender) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(sender.asBinder());
        mRemote.transact(CANCEL_INTENT_SENDER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.291 -0500", hash_original_method = "1993496C4F183452017D412A9B9C5C29", hash_generated_method = "31E9ED2AC55D66C37B6ADA27E95A5895")
    
public String getPackageForIntentSender(IIntentSender sender) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(sender.asBinder());
        mRemote.transact(GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.293 -0500", hash_original_method = "92B622DC0CB7ED23BB116E8953A0A90A", hash_generated_method = "519649B759E35D60ABAB5D3BD66EE75E")
    
public void setProcessLimit(int max) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(max);
        mRemote.transact(SET_PROCESS_LIMIT_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.296 -0500", hash_original_method = "4FA932EFF1C9BAC6AA973FE979D6B75F", hash_generated_method = "4718294660A41020A8DF932AF6810FAA")
    
public int getProcessLimit() throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_PROCESS_LIMIT_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.299 -0500", hash_original_method = "16F5E36D0F576E8CD2EC3F6B33B5169D", hash_generated_method = "2CEDB496F05F3025442CAFEDCF4C7EBF")
    
public void setProcessForeground(IBinder token, int pid,
            boolean isForeground) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(pid);
        data.writeInt(isForeground ? 1 : 0);
        mRemote.transact(SET_PROCESS_FOREGROUND_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.301 -0500", hash_original_method = "A50C503DC3495EB643680A38372DD1F5", hash_generated_method = "988DE3AF9052C29E28A1CA79D79CBC53")
    
public int checkPermission(String permission, int pid, int uid)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(permission);
        data.writeInt(pid);
        data.writeInt(uid);
        mRemote.transact(CHECK_PERMISSION_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.303 -0500", hash_original_method = "BE5C38AE92A5EE5CE45944FF93295090", hash_generated_method = "2BE314E20E37F3EDA30DD077D4DCD826")
    
public boolean clearApplicationUserData(final String packageName,
            final IPackageDataObserver observer) throws RemoteException {        
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        data.writeStrongBinder(observer.asBinder());
        mRemote.transact(CLEAR_APP_DATA_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.306 -0500", hash_original_method = "FEF4F93E5B02F55707A11B36638BBB59", hash_generated_method = "73713CA47397E1F3173A71D4BDA2FD89")
    
public int checkUriPermission(Uri uri, int pid, int uid, int mode) 
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        uri.writeToParcel(data, 0);
        data.writeInt(pid);
        data.writeInt(uid);
        data.writeInt(mode);
        mRemote.transact(CHECK_URI_PERMISSION_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.308 -0500", hash_original_method = "2CEB2CA82A36297F49BF5DB3286E579B", hash_generated_method = "36238974C39DB220B8B87329B97ADE4C")
    
public void grantUriPermission(IApplicationThread caller, String targetPkg,
            Uri uri, int mode) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller.asBinder());
        data.writeString(targetPkg);
        uri.writeToParcel(data, 0);
        data.writeInt(mode);
        mRemote.transact(GRANT_URI_PERMISSION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.310 -0500", hash_original_method = "84D534ABCBC85608735C63399D2C9E1E", hash_generated_method = "DB906DBE7EAE1D6EA218A2FB35B8AC86")
    
public void revokeUriPermission(IApplicationThread caller, Uri uri,
            int mode) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller.asBinder());
        uri.writeToParcel(data, 0);
        data.writeInt(mode);
        mRemote.transact(REVOKE_URI_PERMISSION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.313 -0500", hash_original_method = "7FC96553233904C2463E3D793E528211", hash_generated_method = "5F7C42824C3701D02E2FF4F1809CFD34")
    
public void showWaitingForDebugger(IApplicationThread who, boolean waiting)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(who.asBinder());
        data.writeInt(waiting ? 1 : 0);
        mRemote.transact(SHOW_WAITING_FOR_DEBUGGER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.315 -0500", hash_original_method = "40DDB58D1BE7B54E85772ACF1AA60D8F", hash_generated_method = "29664D28F682726307E7F2B03D43A606")
    
public void getMemoryInfo(ActivityManager.MemoryInfo outInfo) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_MEMORY_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        outInfo.readFromParcel(reply);
        data.recycle();
        reply.recycle();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.317 -0500", hash_original_method = "805F881D84830966D1AD0B083D69DA9A", hash_generated_method = "E31F317B1797BB5DA95F9805AFADFC27")
    
public void unhandledBack() throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(UNHANDLED_BACK_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.320 -0500", hash_original_method = "1E46E6C9628834765008140B25990D23", hash_generated_method = "18D16E4E177B0B2067F6418CF3382C1B")
    
public ParcelFileDescriptor openContentUri(Uri uri) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(OPEN_CONTENT_URI_TRANSACTION, data, reply, 0);
        reply.readException();
        ParcelFileDescriptor pfd = null;
        if (reply.readInt() != 0) {
            pfd = ParcelFileDescriptor.CREATOR.createFromParcel(reply);
        }
        data.recycle();
        reply.recycle();
        return pfd;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.322 -0500", hash_original_method = "E3BC510BF36E68FD23494212AB6E7B33", hash_generated_method = "85A4C1E3630167905F48BD5A62C0E3B0")
    
public void goingToSleep() throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GOING_TO_SLEEP_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.324 -0500", hash_original_method = "CAFF51A84FC631E180A23D0F5290B43F", hash_generated_method = "2F9EB461D17B8326C7146EE3D7F7BC74")
    
public void wakingUp() throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(WAKING_UP_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.327 -0500", hash_original_method = "482C4468B37AD6CEF12EA376A273F16E", hash_generated_method = "2339FA172703955859E86D89ED8B6C72")
    
public void setDebugApp(
        String packageName, boolean waitForDebugger, boolean persistent)
        throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        data.writeInt(waitForDebugger ? 1 : 0);
        data.writeInt(persistent ? 1 : 0);
        mRemote.transact(SET_DEBUG_APP_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.329 -0500", hash_original_method = "DE27B8A416D8E1FF87F079AFA1567A6E", hash_generated_method = "3ACD59FF7B5B9EB7552F81C8703912D9")
    
public void setAlwaysFinish(boolean enabled) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(enabled ? 1 : 0);
        mRemote.transact(SET_ALWAYS_FINISH_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.332 -0500", hash_original_method = "D7DBDAD7386DC1F45D7A9AB12513A49B", hash_generated_method = "26BE99ACECD4E0EA0BCD87CF84C91C6D")
    
public void setActivityController(IActivityController watcher) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        mRemote.transact(SET_ACTIVITY_CONTROLLER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.334 -0500", hash_original_method = "FF7EEF7728CACAD7286D113A3CF07513", hash_generated_method = "C8D1CE528A9EBFB3017388E0B140CB1F")
    
public void enterSafeMode() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(ENTER_SAFE_MODE_TRANSACTION, data, null, 0);
        data.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.336 -0500", hash_original_method = "72F87C80970F6885E4DCD6DA1B2F19E8", hash_generated_method = "4EE13C1336CE30525D9BEA2ED8C05ACC")
    
public void noteWakeupAlarm(IIntentSender sender) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeStrongBinder(sender.asBinder());
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(NOTE_WAKEUP_ALARM_TRANSACTION, data, null, 0);
        data.recycle();
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.338 -0500", hash_original_method = "DB2721BD1E4C8F1064AA0461CF2A490B", hash_generated_method = "32F32BB96BD635CBBC396DC1C80B41AA")
    
public boolean killPids(int[] pids, String reason, boolean secure) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeIntArray(pids);
        data.writeString(reason);
        data.writeInt(secure ? 1 : 0);
        mRemote.transact(KILL_PIDS_TRANSACTION, data, reply, 0);
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        return res;
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.341 -0500", hash_original_method = "9964526F9DDC53538E50ED934A9D4009", hash_generated_method = "2D2C2E747C0CAEAED410BDEE29095078")
    
public void startRunning(String pkg, String cls, String action,
            String indata) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(pkg);
        data.writeString(cls);
        data.writeString(action);
        data.writeString(indata);
        mRemote.transact(START_RUNNING_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.343 -0500", hash_original_method = "6C8B2FE75A3BFFE16EADA916F678A09D", hash_generated_method = "324383541B609AC107CC237B509D3855")
    
public boolean testIsSystemReady()
    {
        /* this base class version is never called */
        return true;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.346 -0500", hash_original_method = "523AF9597115E332AF2A1F534C49483C", hash_generated_method = "0C4851A58F8B95E2D2D319BFE8D6F976")
    
public void handleApplicationCrash(IBinder app,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(app);
        crashInfo.writeToParcel(data, 0);
        mRemote.transact(HANDLE_APPLICATION_CRASH_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.348 -0500", hash_original_method = "84EFC78EC4B379D270C222A7BC31C5F7", hash_generated_method = "4470A7032BBD38D42CE2D70D5B9C625E")
    
public boolean handleApplicationWtf(IBinder app, String tag,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(app);
        data.writeString(tag);
        crashInfo.writeToParcel(data, 0);
        mRemote.transact(HANDLE_APPLICATION_WTF_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        return res;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.350 -0500", hash_original_method = "7AC27E481709B1F0B25AE2BA23B3BECF", hash_generated_method = "7A30BCA332EE387150F80371122D2EAD")
    
public void handleApplicationStrictModeViolation(IBinder app,
            int violationMask,
            StrictMode.ViolationInfo info) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(app);
        data.writeInt(violationMask);
        info.writeToParcel(data, 0);
        mRemote.transact(HANDLE_APPLICATION_STRICT_MODE_VIOLATION_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.353 -0500", hash_original_method = "22BD8EFAE7A36DA76D8B0F7F297E970D", hash_generated_method = "8F1FAF094EF56C247B9502141663C8AC")
    
public void signalPersistentProcesses(int sig) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(sig);
        mRemote.transact(SIGNAL_PERSISTENT_PROCESSES_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.355 -0500", hash_original_method = "3D80332C8A0FCAFBCE220FADA30302CB", hash_generated_method = "E5327BFA69BA95E2143005ABDA4FA49D")
    
public void killBackgroundProcesses(String packageName) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        mRemote.transact(KILL_BACKGROUND_PROCESSES_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.357 -0500", hash_original_method = "C7F5D3EA775AD04DD438191F0B4D22C4", hash_generated_method = "0AE40A2D99E4534169EF79490326CAC1")
    
public void killAllBackgroundProcesses() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(KILL_ALL_BACKGROUND_PROCESSES_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.360 -0500", hash_original_method = "CB4D9E734B2DC6A00C763BA9D15D84CC", hash_generated_method = "8D8C005E180F79F390C7D1DBE184D67E")
    
public void forceStopPackage(String packageName) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        mRemote.transact(FORCE_STOP_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.362 -0500", hash_original_method = "9F4AADDAC8F1648FD8C80C6B88BBF25F", hash_generated_method = "67AFF47CC06D6F34CDEA93F10A05684A")
    
public ConfigurationInfo getDeviceConfigurationInfo() throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_DEVICE_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        ConfigurationInfo res = ConfigurationInfo.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
        return res;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.365 -0500", hash_original_method = "10D7A082C97EAFB331405B7841F1651D", hash_generated_method = "7207AC50240DC667A2EB21AD828919E1")
    
public boolean profileControl(String process, boolean start,
            String path, ParcelFileDescriptor fd, int profileType) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(process);
        data.writeInt(start ? 1 : 0);
        data.writeInt(profileType);
        data.writeString(path);
        if (fd != null) {
            data.writeInt(1);
            fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } else {
            data.writeInt(0);
        }
        mRemote.transact(PROFILE_CONTROL_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        return res;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.368 -0500", hash_original_method = "52F9DB0BA2A0AB8C52093D208807035C", hash_generated_method = "10DB8ACB7C4E4FFF9532DEBD64C42060")
    
public boolean shutdown(int timeout) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(timeout);
        mRemote.transact(SHUTDOWN_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        return res;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.370 -0500", hash_original_method = "BE7DD92CBAD030A60DB7090E3408574C", hash_generated_method = "1EF1E31F4B361224EF39E8A6067153BF")
    
public void stopAppSwitches() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(STOP_APP_SWITCHES_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.372 -0500", hash_original_method = "0EC9793095E20007EC76AB5DDDE4E54A", hash_generated_method = "F4CBFBDBDD2F9C6125623D6011581C19")
    
public void resumeAppSwitches() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(RESUME_APP_SWITCHES_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.375 -0500", hash_original_method = "7B78E2FEC61CC471A8E07C6C34C74BD6", hash_generated_method = "426303997A321DC507A5244A93CA3019")
    
public void registerActivityWatcher(IActivityWatcher watcher)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        mRemote.transact(REGISTER_ACTIVITY_WATCHER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.377 -0500", hash_original_method = "8E5D6F085FE02A1442C5A617ADA012EC", hash_generated_method = "477964803FF5844DA340E06082DA104A")
    
public void unregisterActivityWatcher(IActivityWatcher watcher)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        mRemote.transact(UNREGISTER_ACTIVITY_WATCHER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.379 -0500", hash_original_method = "C65F778BCD540838D47FE4E4412CD25E", hash_generated_method = "C0A3DC4135D2ED4F6ED6236F86E6A5E0")
    
public int startActivityInPackage(int uid,
            Intent intent, String resolvedType, IBinder resultTo,
            String resultWho, int requestCode, boolean onlyIfNeeded)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(uid);
        intent.writeToParcel(data, 0);
        data.writeString(resolvedType);
        data.writeStrongBinder(resultTo);
        data.writeString(resultWho);
        data.writeInt(requestCode);
        data.writeInt(onlyIfNeeded ? 1 : 0);
        mRemote.transact(START_ACTIVITY_IN_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        int result = reply.readInt();
        reply.recycle();
        data.recycle();
        return result;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.381 -0500", hash_original_method = "9BA7CBE5CC5118373D7AAA1497A47635", hash_generated_method = "BA73A0FE2F936C7936AC2405466A48EA")
    
public void killApplicationWithUid(String pkg, int uid) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(pkg);
        data.writeInt(uid);
        mRemote.transact(KILL_APPLICATION_WITH_UID_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.383 -0500", hash_original_method = "2A680A4513BB1B95074F3F876F148BA8", hash_generated_method = "7725D7EB0DD775714BB319F1A4313CC7")
    
public void closeSystemDialogs(String reason) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(reason);
        mRemote.transact(CLOSE_SYSTEM_DIALOGS_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.386 -0500", hash_original_method = "BD88F62F5112FCE1DE930509EBB83FD2", hash_generated_method = "D2A1F40A0484054EB9084C139F4F2505")
    
public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeIntArray(pids);
        mRemote.transact(GET_PROCESS_MEMORY_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        Debug.MemoryInfo[] res = reply.createTypedArray(Debug.MemoryInfo.CREATOR);
        data.recycle();
        reply.recycle();
        return res;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.389 -0500", hash_original_method = "0F16B6E02208618C1D3EE91B8DD80482", hash_generated_method = "4E8A4E2393370FB729DD5C5CE187DB33")
    
public void killApplicationProcess(String processName, int uid) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(processName);
        data.writeInt(uid);
        mRemote.transact(KILL_APPLICATION_PROCESS_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
        
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.391 -0500", hash_original_method = "00D6B54E331AC7AA3DC1F40B928FA3FD", hash_generated_method = "4ABDA8315718740C30C9CA629C3F3EC0")
    
public void overridePendingTransition(IBinder token, String packageName,
            int enterAnim, int exitAnim) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeString(packageName);
        data.writeInt(enterAnim);
        data.writeInt(exitAnim);
        mRemote.transact(OVERRIDE_PENDING_TRANSITION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.393 -0500", hash_original_method = "0F906B538EF84DE09E15BAB8CDAE69C4", hash_generated_method = "9973D4B63350AEA6FC2F0F148933FC5F")
    
public boolean isUserAMonkey() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(IS_USER_A_MONKEY_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        return res;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.396 -0500", hash_original_method = "CE9EE2ABB9C16E19ED0FB5ECED80A2D8", hash_generated_method = "A905158D7CB4B3631FF61BBE5964DCFA")
    
public void finishHeavyWeightApp() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(FINISH_HEAVY_WEIGHT_APP_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.398 -0500", hash_original_method = "468B67BFEE008B6CDEC37F42802988FA", hash_generated_method = "27A6A19E407686D2F71BF3731645EEA7")
    
public void setImmersive(IBinder token, boolean immersive)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(immersive ? 1 : 0);
        mRemote.transact(SET_IMMERSIVE_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.400 -0500", hash_original_method = "12E814937BEB239BDABA8A5EE4F6D00D", hash_generated_method = "7BB0E7D7F06B43522E5214A4B7DBD2AF")
    
public boolean isImmersive(IBinder token)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(IS_IMMERSIVE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() == 1;
        data.recycle();
        reply.recycle();
        return res;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.403 -0500", hash_original_method = "0342E1772D9E2D527D167E41870AA176", hash_generated_method = "7806FD469F37748F98AA430BBA84743B")
    
public boolean isTopActivityImmersive()
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() == 1;
        data.recycle();
        reply.recycle();
        return res;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.406 -0500", hash_original_method = "574D561A4B99545A454A313F9DD764D8", hash_generated_method = "5B9F8105EF348C596A8C08C01E787F17")
    
public void crashApplication(int uid, int initialPid, String packageName,
            String message) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(uid);
        data.writeInt(initialPid);
        data.writeString(packageName);
        data.writeString(message);
        mRemote.transact(CRASH_APPLICATION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.408 -0500", hash_original_method = "CF06029063749F4266D5EFBB16694E04", hash_generated_method = "77FFC4A8988BBFC9121C359928074620")
    
public String getProviderMimeType(Uri uri)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        uri.writeToParcel(data, 0);
        mRemote.transact(GET_PROVIDER_MIME_TYPE_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
        return res;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.410 -0500", hash_original_method = "A975CD5E1392FBC42C40F56501282DDB", hash_generated_method = "097A924FDB841126D8DD662446A4DC90")
    
public IBinder newUriPermissionOwner(String name)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(name);
        mRemote.transact(NEW_URI_PERMISSION_OWNER_TRANSACTION, data, reply, 0);
        reply.readException();
        IBinder res = reply.readStrongBinder();
        data.recycle();
        reply.recycle();
        return res;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.413 -0500", hash_original_method = "1C35FE424D422C73471D9ECEE35C4093", hash_generated_method = "BE1E547CC5E992ECED67809927EF5C00")
    
public void grantUriPermissionFromOwner(IBinder owner, int fromUid, String targetPkg,
            Uri uri, int mode) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(owner);
        data.writeInt(fromUid);
        data.writeString(targetPkg);
        uri.writeToParcel(data, 0);
        data.writeInt(mode);
        mRemote.transact(GRANT_URI_PERMISSION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.415 -0500", hash_original_method = "D07898A73558FBA66858F774589B082E", hash_generated_method = "5D8004CCADEE367F381D4690A9CAF31F")
    
public void revokeUriPermissionFromOwner(IBinder owner, Uri uri,
            int mode) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(owner);
        if (uri != null) {
            data.writeInt(1);
            uri.writeToParcel(data, 0);
        } else {
            data.writeInt(0);
        }
        data.writeInt(mode);
        mRemote.transact(REVOKE_URI_PERMISSION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.418 -0500", hash_original_method = "3DAB9C9F42020370AD19E1FE0AC1BDCE", hash_generated_method = "C43930DD81EBDA1C763CA7A79D4CA4AB")
    
public int checkGrantUriPermission(int callingUid, String targetPkg,
            Uri uri, int modeFlags) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(callingUid);
        data.writeString(targetPkg);
        uri.writeToParcel(data, 0);
        data.writeInt(modeFlags);
        mRemote.transact(CHECK_GRANT_URI_PERMISSION_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        data.recycle();
        reply.recycle();
        return res;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.420 -0500", hash_original_method = "2510375C73B367DE6AAF634BB948BB50", hash_generated_method = "C3CA19D16C7404F8C768B899096E16AC")
    
public boolean dumpHeap(String process, boolean managed,
            String path, ParcelFileDescriptor fd) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(process);
        data.writeInt(managed ? 1 : 0);
        data.writeString(path);
        if (fd != null) {
            data.writeInt(1);
            fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } else {
            data.writeInt(0);
        }
        mRemote.transact(DUMP_HEAP_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        return res;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.422 -0500", hash_original_method = "D5FED7EEA920B3F53E1885BDA832FF44", hash_generated_method = "F21EBCE71E1BE808082913573666650A")
    
public int startActivities(IApplicationThread caller,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeTypedArray(intents, 0);
        data.writeStringArray(resolvedTypes);
        data.writeStrongBinder(resultTo);
        mRemote.transact(START_ACTIVITIES_TRANSACTION, data, reply, 0);
        reply.readException();
        int result = reply.readInt();
        reply.recycle();
        data.recycle();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.425 -0500", hash_original_method = "7A44848B4F4A570D7B280FD97AA3F11F", hash_generated_method = "2561A3E8CF3A2CC66789106411103DA2")
    
public int startActivitiesInPackage(int uid,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(uid);
        data.writeTypedArray(intents, 0);
        data.writeStringArray(resolvedTypes);
        data.writeStrongBinder(resultTo);
        mRemote.transact(START_ACTIVITIES_IN_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        int result = reply.readInt();
        reply.recycle();
        data.recycle();
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.427 -0500", hash_original_method = "11A1C93F201BB77459CE48D94392036A", hash_generated_method = "AF3CCC5F379C0F42CFFD00514CEF58BB")
    
public int getFrontActivityScreenCompatMode() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        int mode = reply.readInt();
        reply.recycle();
        data.recycle();
        return mode;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.429 -0500", hash_original_method = "984BA2CED473A0F45E8080D25CCDF41F", hash_generated_method = "C3296E0F77F40F6E6606318EDFF532A8")
    
public void setFrontActivityScreenCompatMode(int mode) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(mode);
        mRemote.transact(SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.432 -0500", hash_original_method = "AFAFCB6FF2EC7CDD310E0CDC4C512BE7", hash_generated_method = "1A144DBBEF769BF5D6411ED467009DEF")
    
public int getPackageScreenCompatMode(String packageName) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        mRemote.transact(GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        int mode = reply.readInt();
        reply.recycle();
        data.recycle();
        return mode;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.435 -0500", hash_original_method = "5B0C9EEE90D8463E1DCC15B68E3829E8", hash_generated_method = "90C3D86F347D02DF7BDAE406677D5E80")
    
public void setPackageScreenCompatMode(String packageName, int mode)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        data.writeInt(mode);
        mRemote.transact(SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.438 -0500", hash_original_method = "7AFCEC9BC7A2DAB54F3EFFA101044309", hash_generated_method = "6360384A022DFC80889E76D394FA0F78")
    
public boolean getPackageAskScreenCompat(String packageName) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        mRemote.transact(GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean ask = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        return ask;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.440 -0500", hash_original_method = "8C9BAA94A3976358AA466F180A11AE45", hash_generated_method = "91D000CD5FD9C648433EC0BBB21D6EA8")
    
public void setPackageAskScreenCompat(String packageName, boolean ask)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        data.writeInt(ask ? 1 : 0);
        mRemote.transact(SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.442 -0500", hash_original_method = "0A8E6FD2F20689E2107BCC0911A72467", hash_generated_method = "632B814E13FA08B8CC7A465855C4EC73")
    
public boolean switchUser(int userid) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(userid);
        mRemote.transact(SWITCH_USER_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean result = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        return result;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.445 -0500", hash_original_method = "4161F4F4B6F51E7616ED3E0F5DA99E10", hash_generated_method = "4EC4A1F7331DC312065289C1746843EF")
    
public boolean removeSubTask(int taskId, int subTaskIndex) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(taskId);
        data.writeInt(subTaskIndex);
        mRemote.transact(REMOVE_SUB_TASK_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean result = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        return result;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.447 -0500", hash_original_method = "D75556E86E98C9E69E5D8B6835FF1B1D", hash_generated_method = "BB34DC32D6BA2B37577D06D52C8F088B")
    
public boolean removeTask(int taskId, int flags) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(taskId);
        data.writeInt(flags);
        mRemote.transact(REMOVE_TASK_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean result = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        return result;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.449 -0500", hash_original_method = "AD040AF08607A87C88C9CB9BE1E3C408", hash_generated_method = "77109B1B8B5B93C0C959AE2857BA96C2")
    
public void registerProcessObserver(IProcessObserver observer) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(observer != null ? observer.asBinder() : null);
        mRemote.transact(REGISTER_PROCESS_OBSERVER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.452 -0500", hash_original_method = "6FB2BE2D02A98F343D51290C94466533", hash_generated_method = "492A312F489C680220001A12E2E88CA7")
    
public void unregisterProcessObserver(IProcessObserver observer) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(observer != null ? observer.asBinder() : null);
        mRemote.transact(UNREGISTER_PROCESS_OBSERVER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.454 -0500", hash_original_method = "A45994938B7DA24AED12FFC5B3B3DD69", hash_generated_method = "8B167344CF31D72C87999BEDEA48C93A")
    
public boolean isIntentSenderTargetedToPackage(IIntentSender sender) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(sender.asBinder());
        mRemote.transact(IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        return res;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.457 -0500", hash_original_method = "ACD180EA48DE1CCAABBA4B90AA3470B8", hash_generated_method = "BEE83C5B4C1FF2C1700669E2699E76AE")
    
public void updatePersistentConfiguration(Configuration values) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        values.writeToParcel(data, 0);
        mRemote.transact(UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.459 -0500", hash_original_method = "0E9D1ED4F0E7DC85612AA1E9A3EC65BE", hash_generated_method = "A8F1EB33A1B8095078FD616ADC2F6EAD")
    
public long[] getProcessPss(int[] pids) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeIntArray(pids);
        mRemote.transact(GET_PROCESS_PSS_TRANSACTION, data, reply, 0);
        reply.readException();
        long[] res = reply.createLongArray();
        data.recycle();
        reply.recycle();
        return res;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.462 -0500", hash_original_method = "F6DDBF719DC0D2BCB3D721A826004A98", hash_generated_method = "F73026469B435D41F1471CCDEA1B0E98")
    
public void showBootMessage(CharSequence msg, boolean always) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        TextUtils.writeToParcel(msg, data, 0);
        data.writeInt(always ? 1 : 0);
        mRemote.transact(SHOW_BOOT_MESSAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:13.464 -0500", hash_original_method = "C6C48FDB33104FCE337F1D8C3A233E89", hash_generated_method = "07A80C7ECD0A3B533905DC6752AAF458")
    
public void dismissKeyguardOnNextActivity() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(DISMISS_KEYGUARD_ON_NEXT_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
    }
    
}

