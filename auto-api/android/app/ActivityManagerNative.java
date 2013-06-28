package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IIntentSender;
import android.content.IIntentReceiver;
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
import android.os.Parcelable;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.util.Singleton;
import java.util.ArrayList;
import java.util.List;

public abstract class ActivityManagerNative extends Binder implements IActivityManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.691 -0400", hash_original_method = "444DC66B3432907DFEA55328E5B69649", hash_generated_method = "FF0B4D083A157B879D7CD5A2215454A9")
    public  ActivityManagerNative() {
        attachInterface(this, descriptor);
        // ---------- Original Method ----------
        //attachInterface(this, descriptor);
    }

    
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

    
    static public IActivityManager getDefault() {
        return gDefault.get();
    }

    
    static public boolean isSystemReady() {
        if (!sSystemReady) {
            sSystemReady = getDefault().testIsSystemReady();
        }
        return sSystemReady;
    }

    
    static public void broadcastStickyIntent(Intent intent, String permission) {
        try {
            getDefault().broadcastIntent(
                null, intent, null, null, Activity.RESULT_OK, null, null,
                null , false, true);
        } catch (RemoteException ex) {
        }
    }

    
    static public void noteWakeupAlarm(PendingIntent ps) {
        try {
            getDefault().noteWakeupAlarm(ps.getTarget());
        } catch (RemoteException ex) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.710 -0400", hash_original_method = "796B52B1E8846F7CCEC22CD4B5B906A8", hash_generated_method = "6992CE4234D71120297219DB3E5835ED")
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //Begin case START_ACTIVITY_TRANSACTION 
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
            ParcelFileDescriptor profileFd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1000724586 = (data.readInt() != 0);
            profileFd = data.readFileDescriptor();
            profileFd = null;
            boolean autoStopProfiler = data.readInt() != 0;
            int result = startActivity(app, intent, resolvedType,
                    grantedUriPermissions, grantedMode, resultTo, resultWho,
                    requestCode, onlyIfNeeded, debug, profileFile, profileFd, autoStopProfiler);
            reply.writeNoException();
            reply.writeInt(result);
        } //End block
        //End case START_ACTIVITY_TRANSACTION 
        //Begin case START_ACTIVITY_AND_WAIT_TRANSACTION 
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
            ParcelFileDescriptor profileFd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_603438727 = (data.readInt() != 0);
            profileFd = data.readFileDescriptor();
            profileFd = null;
            boolean autoStopProfiler = data.readInt() != 0;
            WaitResult result = startActivityAndWait(app, intent, resolvedType,
                    grantedUriPermissions, grantedMode, resultTo, resultWho,
                    requestCode, onlyIfNeeded, debug, profileFile, profileFd, autoStopProfiler);
            reply.writeNoException();
            result.writeToParcel(reply, 0);
        } //End block
        //End case START_ACTIVITY_AND_WAIT_TRANSACTION 
        //Begin case START_ACTIVITY_WITH_CONFIG_TRANSACTION 
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
        } //End block
        //End case START_ACTIVITY_WITH_CONFIG_TRANSACTION 
        //Begin case START_ACTIVITY_INTENT_SENDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            IntentSender intent = IntentSender.CREATOR.createFromParcel(data);
            Intent fillInIntent = null;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_616919107 = (data.readInt() != 0);
                {
                    fillInIntent = Intent.CREATOR.createFromParcel(data);
                } //End block
            } //End collapsed parenthetic
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
        } //End block
        //End case START_ACTIVITY_INTENT_SENDER_TRANSACTION 
        //Begin case START_NEXT_MATCHING_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder callingActivity = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            boolean result = startNextMatchingActivity(callingActivity, intent);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
        } //End block
        //End case START_NEXT_MATCHING_ACTIVITY_TRANSACTION 
        //Begin case FINISH_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Intent resultData = null;
            int resultCode = data.readInt();
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_179623920 = (data.readInt() != 0);
                {
                    resultData = Intent.CREATOR.createFromParcel(data);
                } //End block
            } //End collapsed parenthetic
            boolean res = finishActivity(token, resultCode, resultData);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case FINISH_ACTIVITY_TRANSACTION 
        //Begin case FINISH_SUB_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            String resultWho = data.readString();
            int requestCode = data.readInt();
            finishSubActivity(token, resultWho, requestCode);
            reply.writeNoException();
        } //End block
        //End case FINISH_SUB_ACTIVITY_TRANSACTION 
        //Begin case WILL_ACTIVITY_BE_VISIBLE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean res = willActivityBeVisible(token);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case WILL_ACTIVITY_BE_VISIBLE_TRANSACTION 
        //Begin case REGISTER_RECEIVER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            app = null;
            String packageName = data.readString();
            b = data.readStrongBinder();
            IIntentReceiver rec;
            rec = IIntentReceiver.Stub.asInterface(b);
            rec = null;
            IntentFilter filter = IntentFilter.CREATOR.createFromParcel(data);
            String perm = data.readString();
            Intent intent = registerReceiver(app, packageName, rec, filter, perm);
            reply.writeNoException();
            {
                reply.writeInt(1);
                intent.writeToParcel(reply, 0);
            } //End block
            {
                reply.writeInt(0);
            } //End block
        } //End block
        //End case REGISTER_RECEIVER_TRANSACTION 
        //Begin case UNREGISTER_RECEIVER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IIntentReceiver rec = IIntentReceiver.Stub.asInterface(b);
            unregisterReceiver(rec);
            reply.writeNoException();
        } //End block
        //End case UNREGISTER_RECEIVER_TRANSACTION 
        //Begin case BROADCAST_INTENT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            app = null;
            Intent intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            b = data.readStrongBinder();
            IIntentReceiver resultTo;
            resultTo = IIntentReceiver.Stub.asInterface(b);
            resultTo = null;
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
        } //End block
        //End case BROADCAST_INTENT_TRANSACTION 
        //Begin case UNBROADCAST_INTENT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            app = null;
            Intent intent = Intent.CREATOR.createFromParcel(data);
            unbroadcastIntent(app, intent);
            reply.writeNoException();
        } //End block
        //End case UNBROADCAST_INTENT_TRANSACTION 
        //Begin case FINISH_RECEIVER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder who = data.readStrongBinder();
            int resultCode = data.readInt();
            String resultData = data.readString();
            Bundle resultExtras = data.readBundle();
            boolean resultAbort = data.readInt() != 0;
            {
                finishReceiver(who, resultCode, resultData, resultExtras, resultAbort);
            } //End block
            reply.writeNoException();
        } //End block
        //End case FINISH_RECEIVER_TRANSACTION 
        //Begin case ATTACH_APPLICATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IApplicationThread app = ApplicationThreadNative.asInterface(
                    data.readStrongBinder());
            {
                attachApplication(app);
            } //End block
            reply.writeNoException();
        } //End block
        //End case ATTACH_APPLICATION_TRANSACTION 
        //Begin case ACTIVITY_IDLE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Configuration config = null;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_1994728249 = (data.readInt() != 0);
                {
                    config = Configuration.CREATOR.createFromParcel(data);
                } //End block
            } //End collapsed parenthetic
            boolean stopProfiling = data.readInt() != 0;
            {
                activityIdle(token, config, stopProfiling);
            } //End block
            reply.writeNoException();
        } //End block
        //End case ACTIVITY_IDLE_TRANSACTION 
        //Begin case ACTIVITY_PAUSED_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activityPaused(token);
            reply.writeNoException();
        } //End block
        //End case ACTIVITY_PAUSED_TRANSACTION 
        //Begin case ACTIVITY_STOPPED_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Bundle map = data.readBundle();
            Bitmap thumbnail;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_459041360 = (data.readInt() != 0);
            thumbnail = Bitmap.CREATOR.createFromParcel(data);
            thumbnail = null;
            CharSequence description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            activityStopped(token, map, thumbnail, description);
            reply.writeNoException();
        } //End block
        //End case ACTIVITY_STOPPED_TRANSACTION 
        //Begin case ACTIVITY_SLEPT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activitySlept(token);
            reply.writeNoException();
        } //End block
        //End case ACTIVITY_SLEPT_TRANSACTION 
        //Begin case ACTIVITY_DESTROYED_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activityDestroyed(token);
            reply.writeNoException();
        } //End block
        //End case ACTIVITY_DESTROYED_TRANSACTION 
        //Begin case GET_CALLING_PACKAGE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            String res;
            res = getCallingPackage(token);
            res = null;
            reply.writeNoException();
            reply.writeString(res);
        } //End block
        //End case GET_CALLING_PACKAGE_TRANSACTION 
        //Begin case GET_CALLING_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName cn = getCallingActivity(token);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
        } //End block
        //End case GET_CALLING_ACTIVITY_TRANSACTION 
        //Begin case GET_TASKS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int maxNum = data.readInt();
            int fl = data.readInt();
            IBinder receiverBinder = data.readStrongBinder();
            IThumbnailReceiver receiver;
            receiver = IThumbnailReceiver.Stub.asInterface(receiverBinder);
            receiver = null;
            List list = getTasks(maxNum, fl, receiver);
            reply.writeNoException();
            int N;
            N = list.size();
            N = -1;
            reply.writeInt(N);
            int i;
            {
                i=0;
                {
                    ActivityManager.RunningTaskInfo info = (ActivityManager.RunningTaskInfo)list.get(i);
                    info.writeToParcel(reply, 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case GET_TASKS_TRANSACTION 
        //Begin case GET_RECENT_TASKS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int maxNum = data.readInt();
            int fl = data.readInt();
            List<ActivityManager.RecentTaskInfo> list = getRecentTasks(maxNum,
                    fl);
            reply.writeNoException();
            reply.writeTypedList(list);
        } //End block
        //End case GET_RECENT_TASKS_TRANSACTION 
        //Begin case GET_TASK_THUMBNAILS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int id = data.readInt();
            ActivityManager.TaskThumbnails bm = getTaskThumbnails(id);
            reply.writeNoException();
            {
                reply.writeInt(1);
                bm.writeToParcel(reply, 0);
            } //End block
            {
                reply.writeInt(0);
            } //End block
        } //End block
        //End case GET_TASK_THUMBNAILS_TRANSACTION 
        //Begin case GET_SERVICES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int maxNum = data.readInt();
            int fl = data.readInt();
            List list = getServices(maxNum, fl);
            reply.writeNoException();
            int N;
            N = list.size();
            N = -1;
            reply.writeInt(N);
            int i;
            {
                i=0;
                {
                    ActivityManager.RunningServiceInfo info = (ActivityManager.RunningServiceInfo)list.get(i);
                    info.writeToParcel(reply, 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case GET_SERVICES_TRANSACTION 
        //Begin case GET_PROCESSES_IN_ERROR_STATE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ActivityManager.ProcessErrorStateInfo> list = getProcessesInErrorState();
            reply.writeNoException();
            reply.writeTypedList(list);
        } //End block
        //End case GET_PROCESSES_IN_ERROR_STATE_TRANSACTION 
        //Begin case GET_RUNNING_APP_PROCESSES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ActivityManager.RunningAppProcessInfo> list = getRunningAppProcesses();
            reply.writeNoException();
            reply.writeTypedList(list);
        } //End block
        //End case GET_RUNNING_APP_PROCESSES_TRANSACTION 
        //Begin case GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ApplicationInfo> list = getRunningExternalApplications();
            reply.writeNoException();
            reply.writeTypedList(list);
        } //End block
        //End case GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION 
        //Begin case MOVE_TASK_TO_FRONT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            int fl = data.readInt();
            moveTaskToFront(task, fl);
            reply.writeNoException();
        } //End block
        //End case MOVE_TASK_TO_FRONT_TRANSACTION 
        //Begin case MOVE_TASK_TO_BACK_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            moveTaskToBack(task);
            reply.writeNoException();
        } //End block
        //End case MOVE_TASK_TO_BACK_TRANSACTION 
        //Begin case MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean nonRoot = data.readInt() != 0;
            boolean res = moveActivityTaskToBack(token, nonRoot);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION 
        //Begin case MOVE_TASK_BACKWARDS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            moveTaskBackwards(task);
            reply.writeNoException();
        } //End block
        //End case MOVE_TASK_BACKWARDS_TRANSACTION 
        //Begin case GET_TASK_FOR_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean onlyRoot = data.readInt() != 0;
            int res;
            res = getTaskForActivity(token, onlyRoot);
            res = -1;
            reply.writeNoException();
            reply.writeInt(res);
        } //End block
        //End case GET_TASK_FOR_ACTIVITY_TRANSACTION 
        //Begin case FINISH_OTHER_INSTANCES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName className = ComponentName.readFromParcel(data);
            finishOtherInstances(token, className);
            reply.writeNoException();
        } //End block
        //End case FINISH_OTHER_INSTANCES_TRANSACTION 
        //Begin case REPORT_THUMBNAIL_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Bitmap thumbnail;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1950364876 = (data.readInt() != 0);
            thumbnail = Bitmap.CREATOR.createFromParcel(data);
            thumbnail = null;
            CharSequence description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            reportThumbnail(token, thumbnail, description);
            reply.writeNoException();
        } //End block
        //End case REPORT_THUMBNAIL_TRANSACTION 
        //Begin case GET_CONTENT_PROVIDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            String name = data.readString();
            ContentProviderHolder cph = getContentProvider(app, name);
            reply.writeNoException();
            {
                reply.writeInt(1);
                cph.writeToParcel(reply, 0);
            } //End block
            {
                reply.writeInt(0);
            } //End block
        } //End block
        //End case GET_CONTENT_PROVIDER_TRANSACTION 
        //Begin case PUBLISH_CONTENT_PROVIDERS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            ArrayList<ContentProviderHolder> providers = data.createTypedArrayList(ContentProviderHolder.CREATOR);
            publishContentProviders(app, providers);
            reply.writeNoException();
        } //End block
        //End case PUBLISH_CONTENT_PROVIDERS_TRANSACTION 
        //Begin case REMOVE_CONTENT_PROVIDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            String name = data.readString();
            removeContentProvider(app, name);
            reply.writeNoException();
        } //End block
        //End case REMOVE_CONTENT_PROVIDER_TRANSACTION 
        //Begin case GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName comp = ComponentName.CREATOR.createFromParcel(data);
            PendingIntent pi = getRunningServiceControlPanel(comp);
            reply.writeNoException();
            PendingIntent.writePendingIntentOrNullToParcel(pi, reply);
        } //End block
        //End case GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION 
        //Begin case START_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Intent service = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            ComponentName cn = startService(app, service, resolvedType);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
        } //End block
        //End case START_SERVICE_TRANSACTION 
        //Begin case STOP_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Intent service = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            int res = stopService(app, service, resolvedType);
            reply.writeNoException();
            reply.writeInt(res);
        } //End block
        //End case STOP_SERVICE_TRANSACTION 
        //Begin case STOP_SERVICE_TOKEN_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName className = ComponentName.readFromParcel(data);
            IBinder token = data.readStrongBinder();
            int startId = data.readInt();
            boolean res = stopServiceToken(className, token, startId);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case STOP_SERVICE_TOKEN_TRANSACTION 
        //Begin case SET_SERVICE_FOREGROUND_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName className = ComponentName.readFromParcel(data);
            IBinder token = data.readStrongBinder();
            int id = data.readInt();
            Notification notification = null;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_1378532934 = (data.readInt() != 0);
                {
                    notification = Notification.CREATOR.createFromParcel(data);
                } //End block
            } //End collapsed parenthetic
            boolean removeNotification = data.readInt() != 0;
            setServiceForeground(className, token, id, notification, removeNotification);
            reply.writeNoException();
        } //End block
        //End case SET_SERVICE_FOREGROUND_TRANSACTION 
        //Begin case BIND_SERVICE_TRANSACTION 
        {
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
        } //End block
        //End case BIND_SERVICE_TRANSACTION 
        //Begin case UNBIND_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IServiceConnection conn = IServiceConnection.Stub.asInterface(b);
            boolean res = unbindService(conn);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case UNBIND_SERVICE_TRANSACTION 
        //Begin case PUBLISH_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            IBinder service = data.readStrongBinder();
            publishService(token, intent, service);
            reply.writeNoException();
        } //End block
        //End case PUBLISH_SERVICE_TRANSACTION 
        //Begin case UNBIND_FINISHED_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            boolean doRebind = data.readInt() != 0;
            unbindFinished(token, intent, doRebind);
            reply.writeNoException();
        } //End block
        //End case UNBIND_FINISHED_TRANSACTION 
        //Begin case SERVICE_DONE_EXECUTING_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int type = data.readInt();
            int startId = data.readInt();
            int res = data.readInt();
            serviceDoneExecuting(token, type, startId, res);
            reply.writeNoException();
        } //End block
        //End case SERVICE_DONE_EXECUTING_TRANSACTION 
        //Begin case START_INSTRUMENTATION_TRANSACTION 
        {
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
        } //End block
        //End case START_INSTRUMENTATION_TRANSACTION 
        //Begin case FINISH_INSTRUMENTATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            int resultCode = data.readInt();
            Bundle results = data.readBundle();
            finishInstrumentation(app, resultCode, results);
            reply.writeNoException();
        } //End block
        //End case FINISH_INSTRUMENTATION_TRANSACTION 
        //Begin case GET_CONFIGURATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = getConfiguration();
            reply.writeNoException();
            config.writeToParcel(reply, 0);
        } //End block
        //End case GET_CONFIGURATION_TRANSACTION 
        //Begin case UPDATE_CONFIGURATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            updateConfiguration(config);
            reply.writeNoException();
        } //End block
        //End case UPDATE_CONFIGURATION_TRANSACTION 
        //Begin case SET_REQUESTED_ORIENTATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int requestedOrientation = data.readInt();
            setRequestedOrientation(token, requestedOrientation);
            reply.writeNoException();
        } //End block
        //End case SET_REQUESTED_ORIENTATION_TRANSACTION 
        //Begin case GET_REQUESTED_ORIENTATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int req = getRequestedOrientation(token);
            reply.writeNoException();
            reply.writeInt(req);
        } //End block
        //End case GET_REQUESTED_ORIENTATION_TRANSACTION 
        //Begin case GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName cn = getActivityClassForToken(token);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
        } //End block
        //End case GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION 
        //Begin case GET_PACKAGE_FOR_TOKEN_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            reply.writeNoException();
            reply.writeString(getPackageForToken(token));
        } //End block
        //End case GET_PACKAGE_FOR_TOKEN_TRANSACTION 
        //Begin case GET_INTENT_SENDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int type = data.readInt();
            String packageName = data.readString();
            IBinder token = data.readStrongBinder();
            String resultWho = data.readString();
            int requestCode = data.readInt();
            Intent[] requestIntents;
            String[] requestResolvedTypes;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_1659243633 = (data.readInt() != 0);
                {
                    requestIntents = data.createTypedArray(Intent.CREATOR);
                    requestResolvedTypes = data.createStringArray();
                } //End block
                {
                    requestIntents = null;
                    requestResolvedTypes = null;
                } //End block
            } //End collapsed parenthetic
            int fl = data.readInt();
            IIntentSender res = getIntentSender(type, packageName, token,
                    resultWho, requestCode, requestIntents,
                    requestResolvedTypes, fl);
            reply.writeNoException();
            reply.writeStrongBinder(res != null ? res.asBinder() : null);
        } //End block
        //End case GET_INTENT_SENDER_TRANSACTION 
        //Begin case CANCEL_INTENT_SENDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            cancelIntentSender(r);
            reply.writeNoException();
        } //End block
        //End case CANCEL_INTENT_SENDER_TRANSACTION 
        //Begin case GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            String res = getPackageForIntentSender(r);
            reply.writeNoException();
            reply.writeString(res);
        } //End block
        //End case GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION 
        //Begin case SET_PROCESS_LIMIT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int max = data.readInt();
            setProcessLimit(max);
            reply.writeNoException();
        } //End block
        //End case SET_PROCESS_LIMIT_TRANSACTION 
        //Begin case GET_PROCESS_LIMIT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int limit = getProcessLimit();
            reply.writeNoException();
            reply.writeInt(limit);
        } //End block
        //End case GET_PROCESS_LIMIT_TRANSACTION 
        //Begin case SET_PROCESS_FOREGROUND_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int pid = data.readInt();
            boolean isForeground = data.readInt() != 0;
            setProcessForeground(token, pid, isForeground);
            reply.writeNoException();
        } //End block
        //End case SET_PROCESS_FOREGROUND_TRANSACTION 
        //Begin case CHECK_PERMISSION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String perm = data.readString();
            int pid = data.readInt();
            int uid = data.readInt();
            int res = checkPermission(perm, pid, uid);
            reply.writeNoException();
            reply.writeInt(res);
        } //End block
        //End case CHECK_PERMISSION_TRANSACTION 
        //Begin case CHECK_URI_PERMISSION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int pid = data.readInt();
            int uid = data.readInt();
            int mode = data.readInt();
            int res = checkUriPermission(uri, pid, uid, mode);
            reply.writeNoException();
            reply.writeInt(res);
        } //End block
        //End case CHECK_URI_PERMISSION_TRANSACTION 
        //Begin case CLEAR_APP_DATA_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            IPackageDataObserver observer = IPackageDataObserver.Stub.asInterface(
                    data.readStrongBinder());
            boolean res = clearApplicationUserData(packageName, observer);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case CLEAR_APP_DATA_TRANSACTION 
        //Begin case GRANT_URI_PERMISSION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            String targetPkg = data.readString();
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int mode = data.readInt();
            grantUriPermission(app, targetPkg, uri, mode);
            reply.writeNoException();
        } //End block
        //End case GRANT_URI_PERMISSION_TRANSACTION 
        //Begin case REVOKE_URI_PERMISSION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int mode = data.readInt();
            revokeUriPermission(app, uri, mode);
            reply.writeNoException();
        } //End block
        //End case REVOKE_URI_PERMISSION_TRANSACTION 
        //Begin case SHOW_WAITING_FOR_DEBUGGER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            boolean waiting = data.readInt() != 0;
            showWaitingForDebugger(app, waiting);
            reply.writeNoException();
        } //End block
        //End case SHOW_WAITING_FOR_DEBUGGER_TRANSACTION 
        //Begin case GET_MEMORY_INFO_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
            getMemoryInfo(mi);
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
        } //End block
        //End case GET_MEMORY_INFO_TRANSACTION 
        //Begin case UNHANDLED_BACK_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            unhandledBack();
            reply.writeNoException();
        } //End block
        //End case UNHANDLED_BACK_TRANSACTION 
        //Begin case OPEN_CONTENT_URI_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri = Uri.parse(data.readString());
            ParcelFileDescriptor pfd = openContentUri(uri);
            reply.writeNoException();
            {
                reply.writeInt(1);
                pfd.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            } //End block
            {
                reply.writeInt(0);
            } //End block
        } //End block
        //End case OPEN_CONTENT_URI_TRANSACTION 
        //Begin case GOING_TO_SLEEP_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            goingToSleep();
            reply.writeNoException();
        } //End block
        //End case GOING_TO_SLEEP_TRANSACTION 
        //Begin case WAKING_UP_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            wakingUp();
            reply.writeNoException();
        } //End block
        //End case WAKING_UP_TRANSACTION 
        //Begin case SET_DEBUG_APP_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pn = data.readString();
            boolean wfd = data.readInt() != 0;
            boolean per = data.readInt() != 0;
            setDebugApp(pn, wfd, per);
            reply.writeNoException();
        } //End block
        //End case SET_DEBUG_APP_TRANSACTION 
        //Begin case SET_ALWAYS_FINISH_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean enabled = data.readInt() != 0;
            setAlwaysFinish(enabled);
            reply.writeNoException();
        } //End block
        //End case SET_ALWAYS_FINISH_TRANSACTION 
        //Begin case SET_ACTIVITY_CONTROLLER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityController watcher = IActivityController.Stub.asInterface(
                    data.readStrongBinder());
            setActivityController(watcher);
        } //End block
        //End case SET_ACTIVITY_CONTROLLER_TRANSACTION 
        //Begin case ENTER_SAFE_MODE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            enterSafeMode();
            reply.writeNoException();
        } //End block
        //End case ENTER_SAFE_MODE_TRANSACTION 
        //Begin case NOTE_WAKEUP_ALARM_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender is = IIntentSender.Stub.asInterface(
                    data.readStrongBinder());
            noteWakeupAlarm(is);
            reply.writeNoException();
        } //End block
        //End case NOTE_WAKEUP_ALARM_TRANSACTION 
        //Begin case KILL_PIDS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids = data.createIntArray();
            String reason = data.readString();
            boolean secure = data.readInt() != 0;
            boolean res = killPids(pids, reason, secure);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case KILL_PIDS_TRANSACTION 
        //Begin case START_RUNNING_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            String cls = data.readString();
            String action = data.readString();
            String indata = data.readString();
            startRunning(pkg, cls, action, indata);
            reply.writeNoException();
        } //End block
        //End case START_RUNNING_TRANSACTION 
        //Begin case HANDLE_APPLICATION_CRASH_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app = data.readStrongBinder();
            ApplicationErrorReport.CrashInfo ci = new ApplicationErrorReport.CrashInfo(data);
            handleApplicationCrash(app, ci);
            reply.writeNoException();
        } //End block
        //End case HANDLE_APPLICATION_CRASH_TRANSACTION 
        //Begin case HANDLE_APPLICATION_WTF_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app = data.readStrongBinder();
            String tag = data.readString();
            ApplicationErrorReport.CrashInfo ci = new ApplicationErrorReport.CrashInfo(data);
            boolean res = handleApplicationWtf(app, tag, ci);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case HANDLE_APPLICATION_WTF_TRANSACTION 
        //Begin case HANDLE_APPLICATION_STRICT_MODE_VIOLATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app = data.readStrongBinder();
            int violationMask = data.readInt();
            StrictMode.ViolationInfo info = new StrictMode.ViolationInfo(data);
            handleApplicationStrictModeViolation(app, violationMask, info);
            reply.writeNoException();
        } //End block
        //End case HANDLE_APPLICATION_STRICT_MODE_VIOLATION_TRANSACTION 
        //Begin case SIGNAL_PERSISTENT_PROCESSES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int sig = data.readInt();
            signalPersistentProcesses(sig);
            reply.writeNoException();
        } //End block
        //End case SIGNAL_PERSISTENT_PROCESSES_TRANSACTION 
        //Begin case KILL_BACKGROUND_PROCESSES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            killBackgroundProcesses(packageName);
            reply.writeNoException();
        } //End block
        //End case KILL_BACKGROUND_PROCESSES_TRANSACTION 
        //Begin case KILL_ALL_BACKGROUND_PROCESSES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            killAllBackgroundProcesses();
            reply.writeNoException();
        } //End block
        //End case KILL_ALL_BACKGROUND_PROCESSES_TRANSACTION 
        //Begin case FORCE_STOP_PACKAGE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            forceStopPackage(packageName);
            reply.writeNoException();
        } //End block
        //End case FORCE_STOP_PACKAGE_TRANSACTION 
        //Begin case GET_DEVICE_CONFIGURATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ConfigurationInfo config = getDeviceConfigurationInfo();
            reply.writeNoException();
            config.writeToParcel(reply, 0);
        } //End block
        //End case GET_DEVICE_CONFIGURATION_TRANSACTION 
        //Begin case PROFILE_CONTROL_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String process = data.readString();
            boolean start = data.readInt() != 0;
            int profileType = data.readInt();
            String path = data.readString();
            ParcelFileDescriptor fd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1818103882 = (data.readInt() != 0);
            fd = data.readFileDescriptor();
            fd = null;
            boolean res = profileControl(process, start, path, fd, profileType);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case PROFILE_CONTROL_TRANSACTION 
        //Begin case SHUTDOWN_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean res = shutdown(data.readInt());
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case SHUTDOWN_TRANSACTION 
        //Begin case STOP_APP_SWITCHES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            stopAppSwitches();
            reply.writeNoException();
        } //End block
        //End case STOP_APP_SWITCHES_TRANSACTION 
        //Begin case RESUME_APP_SWITCHES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            resumeAppSwitches();
            reply.writeNoException();
        } //End block
        //End case RESUME_APP_SWITCHES_TRANSACTION 
        //Begin case PEEK_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Intent service = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            IBinder binder = peekService(service, resolvedType);
            reply.writeNoException();
            reply.writeStrongBinder(binder);
        } //End block
        //End case PEEK_SERVICE_TRANSACTION 
        //Begin case START_BACKUP_AGENT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ApplicationInfo info = ApplicationInfo.CREATOR.createFromParcel(data);
            int backupRestoreMode = data.readInt();
            boolean success = bindBackupAgent(info, backupRestoreMode);
            reply.writeNoException();
            reply.writeInt(success ? 1 : 0);
        } //End block
        //End case START_BACKUP_AGENT_TRANSACTION 
        //Begin case BACKUP_AGENT_CREATED_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            IBinder agent = data.readStrongBinder();
            backupAgentCreated(packageName, agent);
            reply.writeNoException();
        } //End block
        //End case BACKUP_AGENT_CREATED_TRANSACTION 
        //Begin case UNBIND_BACKUP_AGENT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ApplicationInfo info = ApplicationInfo.CREATOR.createFromParcel(data);
            unbindBackupAgent(info);
            reply.writeNoException();
        } //End block
        //End case UNBIND_BACKUP_AGENT_TRANSACTION 
        //Begin case REGISTER_ACTIVITY_WATCHER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityWatcher watcher = IActivityWatcher.Stub.asInterface(
                    data.readStrongBinder());
            registerActivityWatcher(watcher);
        } //End block
        //End case REGISTER_ACTIVITY_WATCHER_TRANSACTION 
        //Begin case UNREGISTER_ACTIVITY_WATCHER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityWatcher watcher = IActivityWatcher.Stub.asInterface(
                    data.readStrongBinder());
            unregisterActivityWatcher(watcher);
        } //End block
        //End case UNREGISTER_ACTIVITY_WATCHER_TRANSACTION 
        //Begin case START_ACTIVITY_IN_PACKAGE_TRANSACTION 
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
        } //End block
        //End case START_ACTIVITY_IN_PACKAGE_TRANSACTION 
        //Begin case KILL_APPLICATION_WITH_UID_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int uid = data.readInt();
            killApplicationWithUid(pkg, uid);
            reply.writeNoException();
        } //End block
        //End case KILL_APPLICATION_WITH_UID_TRANSACTION 
        //Begin case CLOSE_SYSTEM_DIALOGS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String reason = data.readString();
            closeSystemDialogs(reason);
            reply.writeNoException();
        } //End block
        //End case CLOSE_SYSTEM_DIALOGS_TRANSACTION 
        //Begin case GET_PROCESS_MEMORY_INFO_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids = data.createIntArray();
            Debug.MemoryInfo[] res = getProcessMemoryInfo(pids);
            reply.writeNoException();
            reply.writeTypedArray(res, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        //End case GET_PROCESS_MEMORY_INFO_TRANSACTION 
        //Begin case KILL_APPLICATION_PROCESS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String processName = data.readString();
            int uid = data.readInt();
            killApplicationProcess(processName, uid);
            reply.writeNoException();
        } //End block
        //End case KILL_APPLICATION_PROCESS_TRANSACTION 
        //Begin case OVERRIDE_PENDING_TRANSITION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            String packageName = data.readString();
            int enterAnim = data.readInt();
            int exitAnim = data.readInt();
            overridePendingTransition(token, packageName, enterAnim, exitAnim);
            reply.writeNoException();
        } //End block
        //End case OVERRIDE_PENDING_TRANSITION_TRANSACTION 
        //Begin case IS_USER_A_MONKEY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean areThey = isUserAMonkey();
            reply.writeNoException();
            reply.writeInt(areThey ? 1 : 0);
        } //End block
        //End case IS_USER_A_MONKEY_TRANSACTION 
        //Begin case FINISH_HEAVY_WEIGHT_APP_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            finishHeavyWeightApp();
            reply.writeNoException();
        } //End block
        //End case FINISH_HEAVY_WEIGHT_APP_TRANSACTION 
        //Begin case IS_IMMERSIVE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean isit = isImmersive(token);
            reply.writeNoException();
            reply.writeInt(isit ? 1 : 0);
        } //End block
        //End case IS_IMMERSIVE_TRANSACTION 
        //Begin case SET_IMMERSIVE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean imm = data.readInt() == 1;
            setImmersive(token, imm);
            reply.writeNoException();
        } //End block
        //End case SET_IMMERSIVE_TRANSACTION 
        //Begin case IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean isit = isTopActivityImmersive();
            reply.writeNoException();
            reply.writeInt(isit ? 1 : 0);
        } //End block
        //End case IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION 
        //Begin case CRASH_APPLICATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int uid = data.readInt();
            int initialPid = data.readInt();
            String packageName = data.readString();
            String message = data.readString();
            crashApplication(uid, initialPid, packageName, message);
            reply.writeNoException();
        } //End block
        //End case CRASH_APPLICATION_TRANSACTION 
        //Begin case GET_PROVIDER_MIME_TYPE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri = Uri.CREATOR.createFromParcel(data);
            String type = getProviderMimeType(uri);
            reply.writeNoException();
            reply.writeString(type);
        } //End block
        //End case GET_PROVIDER_MIME_TYPE_TRANSACTION 
        //Begin case NEW_URI_PERMISSION_OWNER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String name = data.readString();
            IBinder perm = newUriPermissionOwner(name);
            reply.writeNoException();
            reply.writeStrongBinder(perm);
        } //End block
        //End case NEW_URI_PERMISSION_OWNER_TRANSACTION 
        //Begin case GRANT_URI_PERMISSION_FROM_OWNER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder owner = data.readStrongBinder();
            int fromUid = data.readInt();
            String targetPkg = data.readString();
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int mode = data.readInt();
            grantUriPermissionFromOwner(owner, fromUid, targetPkg, uri, mode);
            reply.writeNoException();
        } //End block
        //End case GRANT_URI_PERMISSION_FROM_OWNER_TRANSACTION 
        //Begin case REVOKE_URI_PERMISSION_FROM_OWNER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder owner = data.readStrongBinder();
            Uri uri = null;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_1422718106 = (data.readInt() != 0);
                {
                    Uri.CREATOR.createFromParcel(data);
                } //End block
            } //End collapsed parenthetic
            int mode = data.readInt();
            revokeUriPermissionFromOwner(owner, uri, mode);
            reply.writeNoException();
        } //End block
        //End case REVOKE_URI_PERMISSION_FROM_OWNER_TRANSACTION 
        //Begin case CHECK_GRANT_URI_PERMISSION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int callingUid = data.readInt();
            String targetPkg = data.readString();
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int modeFlags = data.readInt();
            int res = checkGrantUriPermission(callingUid, targetPkg, uri, modeFlags);
            reply.writeNoException();
            reply.writeInt(res);
        } //End block
        //End case CHECK_GRANT_URI_PERMISSION_TRANSACTION 
        //Begin case DUMP_HEAP_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String process = data.readString();
            boolean managed = data.readInt() != 0;
            String path = data.readString();
            ParcelFileDescriptor fd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1041437092 = (data.readInt() != 0);
            fd = data.readFileDescriptor();
            fd = null;
            boolean res = dumpHeap(process, managed, path, fd);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case DUMP_HEAP_TRANSACTION 
        //Begin case START_ACTIVITIES_IN_PACKAGE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int uid = data.readInt();
            Intent[] intents = data.createTypedArray(Intent.CREATOR);
            String[] resolvedTypes = data.createStringArray();
            IBinder resultTo = data.readStrongBinder();
            int result = startActivitiesInPackage(uid, intents, resolvedTypes, resultTo);
            reply.writeNoException();
            reply.writeInt(result);
        } //End block
        //End case START_ACTIVITIES_IN_PACKAGE_TRANSACTION 
        //Begin case START_ACTIVITIES_TRANSACTION 
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
        } //End block
        //End case START_ACTIVITIES_TRANSACTION 
        //Begin case GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int mode = getFrontActivityScreenCompatMode();
            reply.writeNoException();
            reply.writeInt(mode);
        } //End block
        //End case GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION 
        //Begin case SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int mode = data.readInt();
            setFrontActivityScreenCompatMode(mode);
            reply.writeNoException();
            reply.writeInt(mode);
        } //End block
        //End case SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION 
        //Begin case GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int mode = getPackageScreenCompatMode(pkg);
            reply.writeNoException();
            reply.writeInt(mode);
        } //End block
        //End case GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION 
        //Begin case SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int mode = data.readInt();
            setPackageScreenCompatMode(pkg, mode);
            reply.writeNoException();
        } //End block
        //End case SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION 
        //Begin case SWITCH_USER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int userid = data.readInt();
            boolean result = switchUser(userid);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
        } //End block
        //End case SWITCH_USER_TRANSACTION 
        //Begin case REMOVE_SUB_TASK_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int taskId = data.readInt();
            int subTaskIndex = data.readInt();
            boolean result = removeSubTask(taskId, subTaskIndex);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
        } //End block
        //End case REMOVE_SUB_TASK_TRANSACTION 
        //Begin case REMOVE_TASK_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int taskId = data.readInt();
            int fl = data.readInt();
            boolean result = removeTask(taskId, fl);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
        } //End block
        //End case REMOVE_TASK_TRANSACTION 
        //Begin case REGISTER_PROCESS_OBSERVER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IProcessObserver observer = IProcessObserver.Stub.asInterface(
                    data.readStrongBinder());
            registerProcessObserver(observer);
        } //End block
        //End case REGISTER_PROCESS_OBSERVER_TRANSACTION 
        //Begin case UNREGISTER_PROCESS_OBSERVER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IProcessObserver observer = IProcessObserver.Stub.asInterface(
                    data.readStrongBinder());
            unregisterProcessObserver(observer);
        } //End block
        //End case UNREGISTER_PROCESS_OBSERVER_TRANSACTION 
        //Begin case GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            boolean ask = getPackageAskScreenCompat(pkg);
            reply.writeNoException();
            reply.writeInt(ask ? 1 : 0);
        } //End block
        //End case GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION 
        //Begin case SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            boolean ask = data.readInt() != 0;
            setPackageAskScreenCompat(pkg, ask);
            reply.writeNoException();
        } //End block
        //End case SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION 
        //Begin case IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            boolean res = isIntentSenderTargetedToPackage(r);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION 
        //Begin case UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            updatePersistentConfiguration(config);
            reply.writeNoException();
        } //End block
        //End case UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION 
        //Begin case GET_PROCESS_PSS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids = data.createIntArray();
            long[] pss = getProcessPss(pids);
            reply.writeNoException();
            reply.writeLongArray(pss);
        } //End block
        //End case GET_PROCESS_PSS_TRANSACTION 
        //Begin case SHOW_BOOT_MESSAGE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            CharSequence msg = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            boolean always = data.readInt() != 0;
            showBootMessage(msg, always);
            reply.writeNoException();
        } //End block
        //End case SHOW_BOOT_MESSAGE_TRANSACTION 
        //Begin case DISMISS_KEYGUARD_ON_NEXT_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            dismissKeyguardOnNextActivity();
            reply.writeNoException();
        } //End block
        //End case DISMISS_KEYGUARD_ON_NEXT_ACTIVITY_TRANSACTION 
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_120907868 = (super.onTransact(code, data, reply, flags));
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606991720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606991720;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.713 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "E0D2808812E9BCDEA036007062F416F1")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1452716243 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1452716243 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1452716243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1452716243;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.713 -0400", hash_original_field = "7E28963ADB1F0EB3A0EF33BADF10C8B6", hash_generated_field = "94B5404A722EA8FD9D4D6FFD2B91074A")

    static boolean sSystemReady = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.715 -0400", hash_original_field = "1DDB5338697F4F4D1F4EBEBCBCA04F09", hash_generated_field = "C4820EDCAE5178FFFBC23811D56B7F74")

    private static final Singleton<IActivityManager> gDefault = new Singleton<IActivityManager>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.715 -0400", hash_original_method = "DB2B8F5A0363FA0CE3E5AA87CCE94A22", hash_generated_method = "C2B8BA082758343987D3AD39EBC6D0DC")
        protected IActivityManager create() {
            IActivityManager varB4EAC82CA7396A68D541C85D26508E83_1441821956 = null; //Variable for return #1
            IBinder b = ServiceManager.getService("activity");
            IActivityManager am = asInterface(b);
            varB4EAC82CA7396A68D541C85D26508E83_1441821956 = am;
            varB4EAC82CA7396A68D541C85D26508E83_1441821956.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1441821956;
            // ---------- Original Method ----------
            //IBinder b = ServiceManager.getService("activity");
            //if (false) {
                //Log.v("ActivityManager", "default service binder = " + b);
            //}
            //IActivityManager am = asInterface(b);
            //if (false) {
                //Log.v("ActivityManager", "default service = " + am);
            //}
            //return am;
        }

        
};
}

class ActivityManagerProxy implements IActivityManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.716 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.717 -0400", hash_original_method = "3287CA7C2EB4AADDF2EFFF2704D2BE9E", hash_generated_method = "45B8F41C62FE771FA42BECD8E8563D23")
    public  ActivityManagerProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.718 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "131DB90B148ED0416D3B26B2D72204FA")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_26581125 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_26581125 = mRemote;
        varB4EAC82CA7396A68D541C85D26508E83_26581125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_26581125;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.719 -0400", hash_original_method = "ECBE4259B26F016D18C1CACD48E02238", hash_generated_method = "541451587BB409B47BAC287560662465")
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
        {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        {
            data.writeInt(0);
        } //End block
        data.writeInt(autoStopProfiler ? 1 : 0);
        mRemote.transact(START_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        int result = reply.readInt();
        reply.recycle();
        data.recycle();
        addTaint(caller.getTaint());
        addTaint(intent.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(grantedUriPermissions[0].getTaint());
        addTaint(grantedMode);
        addTaint(resultTo.getTaint());
        addTaint(resultWho.getTaint());
        addTaint(requestCode);
        addTaint(onlyIfNeeded);
        addTaint(debug);
        addTaint(profileFile.getTaint());
        addTaint(profileFd.getTaint());
        addTaint(autoStopProfiler);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838263420 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838263420;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.721 -0400", hash_original_method = "BF42E410BABF1DD283EC1102C9637003", hash_generated_method = "2E9FD1D56F2109DC0C936576769DBF7E")
    public WaitResult startActivityAndWait(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, String profileFile, ParcelFileDescriptor profileFd,
            boolean autoStopProfiler) throws RemoteException {
        WaitResult varB4EAC82CA7396A68D541C85D26508E83_2065317512 = null; //Variable for return #1
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
        {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        {
            data.writeInt(0);
        } //End block
        data.writeInt(autoStopProfiler ? 1 : 0);
        mRemote.transact(START_ACTIVITY_AND_WAIT_TRANSACTION, data, reply, 0);
        reply.readException();
        WaitResult result = WaitResult.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_2065317512 = result;
        addTaint(caller.getTaint());
        addTaint(intent.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(grantedUriPermissions[0].getTaint());
        addTaint(grantedMode);
        addTaint(resultTo.getTaint());
        addTaint(resultWho.getTaint());
        addTaint(requestCode);
        addTaint(onlyIfNeeded);
        addTaint(debug);
        addTaint(profileFile.getTaint());
        addTaint(profileFd.getTaint());
        addTaint(autoStopProfiler);
        varB4EAC82CA7396A68D541C85D26508E83_2065317512.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2065317512;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.723 -0400", hash_original_method = "47F7B475943E725D61EF4FCECF2C263D", hash_generated_method = "860365563A57A9A717E7AEC35F2CA285")
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
        addTaint(caller.getTaint());
        addTaint(intent.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(grantedUriPermissions[0].getTaint());
        addTaint(grantedMode);
        addTaint(resultTo.getTaint());
        addTaint(resultWho.getTaint());
        addTaint(requestCode);
        addTaint(onlyIfNeeded);
        addTaint(debug);
        addTaint(config.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40903423 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40903423;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        //intent.writeToParcel(data, 0);
        //data.writeString(resolvedType);
        //data.writeTypedArray(grantedUriPermissions, 0);
        //data.writeInt(grantedMode);
        //data.writeStrongBinder(resultTo);
        //data.writeString(resultWho);
        //data.writeInt(requestCode);
        //data.writeInt(onlyIfNeeded ? 1 : 0);
        //data.writeInt(debug ? 1 : 0);
        //config.writeToParcel(data, 0);
        //mRemote.transact(START_ACTIVITY_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int result = reply.readInt();
        //reply.recycle();
        //data.recycle();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.725 -0400", hash_original_method = "FD56EAF7591CCE02A2449EB3C30AEF02", hash_generated_method = "892043C62F99A56DE1CA2F8913A3E285")
    public int startActivityIntentSender(IApplicationThread caller,
            IntentSender intent, Intent fillInIntent, String resolvedType,
            IBinder resultTo, String resultWho, int requestCode,
            int flagsMask, int flagsValues) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        intent.writeToParcel(data, 0);
        {
            data.writeInt(1);
            fillInIntent.writeToParcel(data, 0);
        } //End block
        {
            data.writeInt(0);
        } //End block
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
        addTaint(caller.getTaint());
        addTaint(intent.getTaint());
        addTaint(fillInIntent.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resultWho.getTaint());
        addTaint(requestCode);
        addTaint(flagsMask);
        addTaint(flagsValues);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666531587 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666531587;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.727 -0400", hash_original_method = "A532370FCCB6C359BF27FA22D92F73F5", hash_generated_method = "E7D0C5B873D5927DBB0446F66AF418AB")
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
        addTaint(callingActivity.getTaint());
        addTaint(intent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282382524 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282382524;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(callingActivity);
        //intent.writeToParcel(data, 0);
        //mRemote.transact(START_NEXT_MATCHING_ACTIVITY_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int result = reply.readInt();
        //reply.recycle();
        //data.recycle();
        //return result != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.728 -0400", hash_original_method = "91E82D39E0DA0BAF3D9668B58FD8BE2D", hash_generated_method = "3E0DD3A3F6DAC5EB50953AF264E7260B")
    public boolean finishActivity(IBinder token, int resultCode, Intent resultData) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(resultCode);
        {
            data.writeInt(1);
            resultData.writeToParcel(data, 0);
        } //End block
        {
            data.writeInt(0);
        } //End block
        mRemote.transact(FINISH_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        addTaint(resultCode);
        addTaint(resultData.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639452978 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639452978;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(resultCode);
        //if (resultData != null) {
            //data.writeInt(1);
            //resultData.writeToParcel(data, 0);
        //} else {
            //data.writeInt(0);
        //}
        //mRemote.transact(FINISH_ACTIVITY_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.728 -0400", hash_original_method = "352728C633440E8BBFDE1A24B12C26C6", hash_generated_method = "26755995D5642DAAEBF9B2D49328DB57")
    public void finishSubActivity(IBinder token, String resultWho, int requestCode) throws RemoteException {
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
        addTaint(token.getTaint());
        addTaint(resultWho.getTaint());
        addTaint(requestCode);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //data.writeString(resultWho);
        //data.writeInt(requestCode);
        //mRemote.transact(FINISH_SUB_ACTIVITY_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.729 -0400", hash_original_method = "03769BB85CE515FA0FB5B3DCD0709D8A", hash_generated_method = "B2E4B13B1005B9BE42CFA0C2BB7C5E27")
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
        addTaint(token.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1994084082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1994084082;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(WILL_ACTIVITY_BE_VISIBLE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.731 -0400", hash_original_method = "D0EC9750E66DC0864B7AF9A5D43ED043", hash_generated_method = "CFC9E057595F36DE3F559E1E58F40EAC")
    public Intent registerReceiver(IApplicationThread caller, String packageName,
            IIntentReceiver receiver,
            IntentFilter filter, String perm) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_1493710577 = null; //Variable for return #1
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
        {
            intent = Intent.CREATOR.createFromParcel(reply);
        } //End block
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1493710577 = intent;
        addTaint(caller.getTaint());
        addTaint(packageName.getTaint());
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(perm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1493710577.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1493710577;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        //data.writeString(packageName);
        //data.writeStrongBinder(receiver != null ? receiver.asBinder() : null);
        //filter.writeToParcel(data, 0);
        //data.writeString(perm);
        //mRemote.transact(REGISTER_RECEIVER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //Intent intent = null;
        //int haveIntent = reply.readInt();
        //if (haveIntent != 0) {
            //intent = Intent.CREATOR.createFromParcel(reply);
        //}
        //reply.recycle();
        //data.recycle();
        //return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.732 -0400", hash_original_method = "CF62E9563222E9365AE1815E546E05AA", hash_generated_method = "431656D6875F25D79F7B6B62A13F282D")
    public void unregisterReceiver(IIntentReceiver receiver) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(receiver.asBinder());
        mRemote.transact(UNREGISTER_RECEIVER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(receiver.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(receiver.asBinder());
        //mRemote.transact(UNREGISTER_RECEIVER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.733 -0400", hash_original_method = "189D2A1B1A14BF35BFCC0BB8AD6C1CE5", hash_generated_method = "A7544DD71064409CAC2F5F828086DA82")
    public int broadcastIntent(IApplicationThread caller,
            Intent intent, String resolvedType,  IIntentReceiver resultTo,
            int resultCode, String resultData, Bundle map,
            String requiredPermission, boolean serialized,
            boolean sticky) throws RemoteException {
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
        addTaint(caller.getTaint());
        addTaint(intent.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resultCode);
        addTaint(resultData.getTaint());
        addTaint(map.getTaint());
        addTaint(requiredPermission.getTaint());
        addTaint(serialized);
        addTaint(sticky);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_948310597 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_948310597;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        //intent.writeToParcel(data, 0);
        //data.writeString(resolvedType);
        //data.writeStrongBinder(resultTo != null ? resultTo.asBinder() : null);
        //data.writeInt(resultCode);
        //data.writeString(resultData);
        //data.writeBundle(map);
        //data.writeString(requiredPermission);
        //data.writeInt(serialized ? 1 : 0);
        //data.writeInt(sticky ? 1 : 0);
        //mRemote.transact(BROADCAST_INTENT_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int res = reply.readInt();
        //reply.recycle();
        //data.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.734 -0400", hash_original_method = "84F4ECE33F63E245917246490F7877AA", hash_generated_method = "C97679BE9143C8BC694A6F655043BCC4")
    public void unbroadcastIntent(IApplicationThread caller, Intent intent) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        intent.writeToParcel(data, 0);
        mRemote.transact(UNBROADCAST_INTENT_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(caller.getTaint());
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        //intent.writeToParcel(data, 0);
        //mRemote.transact(UNBROADCAST_INTENT_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.736 -0400", hash_original_method = "8BFF18A0F9A8EDDD76A319C280B21CDC", hash_generated_method = "B9218B72010DE15D526B3D9CAC041EC1")
    public void finishReceiver(IBinder who, int resultCode, String resultData, Bundle map, boolean abortBroadcast) throws RemoteException {
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
        addTaint(who.getTaint());
        addTaint(resultCode);
        addTaint(resultData.getTaint());
        addTaint(map.getTaint());
        addTaint(abortBroadcast);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(who);
        //data.writeInt(resultCode);
        //data.writeString(resultData);
        //data.writeBundle(map);
        //data.writeInt(abortBroadcast ? 1 : 0);
        //mRemote.transact(FINISH_RECEIVER_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.737 -0400", hash_original_method = "1E67E239E5F2A2540F1E032AB272605E", hash_generated_method = "2B107D558A31234A522545FFC88DEC14")
    public void attachApplication(IApplicationThread app) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(app.asBinder());
        mRemote.transact(ATTACH_APPLICATION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(app.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(app.asBinder());
        //mRemote.transact(ATTACH_APPLICATION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.738 -0400", hash_original_method = "BC9E49082B5DC06C707641FC7F3E31F5", hash_generated_method = "9044A7C07BC84C7A9C30F8F8FACC13D9")
    public void activityIdle(IBinder token, Configuration config, boolean stopProfiling) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        {
            data.writeInt(1);
            config.writeToParcel(data, 0);
        } //End block
        {
            data.writeInt(0);
        } //End block
        data.writeInt(stopProfiling ? 1 : 0);
        mRemote.transact(ACTIVITY_IDLE_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        addTaint(config.getTaint());
        addTaint(stopProfiling);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //if (config != null) {
            //data.writeInt(1);
            //config.writeToParcel(data, 0);
        //} else {
            //data.writeInt(0);
        //}
        //data.writeInt(stopProfiling ? 1 : 0);
        //mRemote.transact(ACTIVITY_IDLE_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.739 -0400", hash_original_method = "4914FFC78B966DEBED0BDBFF9D70FB17", hash_generated_method = "403EDF12F50C1C78A594466FAFE00193")
    public void activityPaused(IBinder token) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(ACTIVITY_PAUSED_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(ACTIVITY_PAUSED_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.740 -0400", hash_original_method = "F5DE3AC45B6CCF74477AF45EB0878099", hash_generated_method = "076942F287B777AD68F8FAA3E0EE8AFB")
    public void activityStopped(IBinder token, Bundle state,
            Bitmap thumbnail, CharSequence description) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeBundle(state);
        {
            data.writeInt(1);
            thumbnail.writeToParcel(data, 0);
        } //End block
        {
            data.writeInt(0);
        } //End block
        TextUtils.writeToParcel(description, data, 0);
        mRemote.transact(ACTIVITY_STOPPED_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        addTaint(state.getTaint());
        addTaint(thumbnail.getTaint());
        addTaint(description.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //data.writeBundle(state);
        //if (thumbnail != null) {
            //data.writeInt(1);
            //thumbnail.writeToParcel(data, 0);
        //} else {
            //data.writeInt(0);
        //}
        //TextUtils.writeToParcel(description, data, 0);
        //mRemote.transact(ACTIVITY_STOPPED_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.741 -0400", hash_original_method = "CA8224B1DA5730B462FB3F604509C1DB", hash_generated_method = "9A0DBFBC21EAEAD1072408B3C9A2B40C")
    public void activitySlept(IBinder token) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(ACTIVITY_SLEPT_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(ACTIVITY_SLEPT_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.742 -0400", hash_original_method = "9A100D49A0D535BB686DAA00CAC541FF", hash_generated_method = "84EFC1D50016BF5FC27B3BE76A469E60")
    public void activityDestroyed(IBinder token) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(ACTIVITY_DESTROYED_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(ACTIVITY_DESTROYED_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.743 -0400", hash_original_method = "7637EF2082F6942F953796EFCEAA3730", hash_generated_method = "5F90804AD13F343E685350D51C508776")
    public String getCallingPackage(IBinder token) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_451072992 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_CALLING_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_451072992 = res;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_451072992.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_451072992;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(GET_CALLING_PACKAGE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //String res = reply.readString();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.745 -0400", hash_original_method = "0E9D91A20FCD3BCFB3517DB475147FAB", hash_generated_method = "0E73AFA60D83B2088470B04FBCEBAB3B")
    public ComponentName getCallingActivity(IBinder token) throws RemoteException {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1009300427 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_CALLING_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        ComponentName res = ComponentName.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1009300427 = res;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1009300427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1009300427;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(GET_CALLING_ACTIVITY_TRANSACTION, data, reply, 0);
        //reply.readException();
        //ComponentName res = ComponentName.readFromParcel(reply);
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.748 -0400", hash_original_method = "FAA1C4AE039868246AED533CDCA15CD7", hash_generated_method = "74D12A5995295BF6FCC25EF8B6A6F607")
    public List getTasks(int maxNum, int flags,
            IThumbnailReceiver receiver) throws RemoteException {
        List varB4EAC82CA7396A68D541C85D26508E83_659949972 = null; //Variable for return #1
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
        {
            list = new ArrayList();
            {
                ActivityManager.RunningTaskInfo info = ActivityManager.RunningTaskInfo.CREATOR
                        .createFromParcel(reply);
                list.add(info);
            } //End block
        } //End block
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_659949972 = list;
        addTaint(maxNum);
        addTaint(flags);
        addTaint(receiver.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_659949972.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_659949972;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.750 -0400", hash_original_method = "9D3E8FF17F102376D7C7BE9D34CE4F93", hash_generated_method = "FF19DAE6F375953D206B53D06354FD04")
    public List<ActivityManager.RecentTaskInfo> getRecentTasks(int maxNum,
            int flags) throws RemoteException {
        List<ActivityManager.RecentTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_287318358 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(maxNum);
        data.writeInt(flags);
        mRemote.transact(GET_RECENT_TASKS_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.RecentTaskInfo> list = reply.createTypedArrayList(ActivityManager.RecentTaskInfo.CREATOR);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_287318358 = list;
        addTaint(maxNum);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_287318358.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_287318358;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(maxNum);
        //data.writeInt(flags);
        //mRemote.transact(GET_RECENT_TASKS_TRANSACTION, data, reply, 0);
        //reply.readException();
        //ArrayList<ActivityManager.RecentTaskInfo> list
            //= reply.createTypedArrayList(ActivityManager.RecentTaskInfo.CREATOR);
        //data.recycle();
        //reply.recycle();
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.752 -0400", hash_original_method = "10D095A12B52FE928E4AEC7C3F42A832", hash_generated_method = "2A5EC76EB314F02EE0CB98D28828B441")
    public ActivityManager.TaskThumbnails getTaskThumbnails(int id) throws RemoteException {
        ActivityManager.TaskThumbnails varB4EAC82CA7396A68D541C85D26508E83_297028150 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(id);
        mRemote.transact(GET_TASK_THUMBNAILS_TRANSACTION, data, reply, 0);
        reply.readException();
        ActivityManager.TaskThumbnails bm = null;
        {
            boolean varB04A284F06B56929F38634A7F4C6A0D7_1989094099 = (reply.readInt() != 0);
            {
                bm = ActivityManager.TaskThumbnails.CREATOR.createFromParcel(reply);
            } //End block
        } //End collapsed parenthetic
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_297028150 = bm;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_297028150.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_297028150;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(id);
        //mRemote.transact(GET_TASK_THUMBNAILS_TRANSACTION, data, reply, 0);
        //reply.readException();
        //ActivityManager.TaskThumbnails bm = null;
        //if (reply.readInt() != 0) {
            //bm = ActivityManager.TaskThumbnails.CREATOR.createFromParcel(reply);
        //}
        //data.recycle();
        //reply.recycle();
        //return bm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.753 -0400", hash_original_method = "7671DD1471581027B2C414BE0E3CE4A6", hash_generated_method = "CC6C9390DC5F061B69265D9AA00637D2")
    public List getServices(int maxNum, int flags) throws RemoteException {
        List varB4EAC82CA7396A68D541C85D26508E83_1687984597 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(maxNum);
        data.writeInt(flags);
        mRemote.transact(GET_SERVICES_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList list = null;
        int N = reply.readInt();
        {
            list = new ArrayList();
            {
                ActivityManager.RunningServiceInfo info = ActivityManager.RunningServiceInfo.CREATOR
                        .createFromParcel(reply);
                list.add(info);
            } //End block
        } //End block
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1687984597 = list;
        addTaint(maxNum);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1687984597.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1687984597;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(maxNum);
        //data.writeInt(flags);
        //mRemote.transact(GET_SERVICES_TRANSACTION, data, reply, 0);
        //reply.readException();
        //ArrayList list = null;
        //int N = reply.readInt();
        //if (N >= 0) {
            //list = new ArrayList();
            //while (N > 0) {
                //ActivityManager.RunningServiceInfo info =
                        //ActivityManager.RunningServiceInfo.CREATOR
                        //.createFromParcel(reply);
                //list.add(info);
                //N--;
            //}
        //}
        //data.recycle();
        //reply.recycle();
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.755 -0400", hash_original_method = "2AE453A6460D5AF368C9AC4C4862314B", hash_generated_method = "DEA064E0471E20763C6374562F35DF8F")
    public List<ActivityManager.ProcessErrorStateInfo> getProcessesInErrorState() throws RemoteException {
        List<ActivityManager.ProcessErrorStateInfo> varB4EAC82CA7396A68D541C85D26508E83_1863689852 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_PROCESSES_IN_ERROR_STATE_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.ProcessErrorStateInfo> list = reply.createTypedArrayList(ActivityManager.ProcessErrorStateInfo.CREATOR);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1863689852 = list;
        varB4EAC82CA7396A68D541C85D26508E83_1863689852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1863689852;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(GET_PROCESSES_IN_ERROR_STATE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //ArrayList<ActivityManager.ProcessErrorStateInfo> list
            //= reply.createTypedArrayList(ActivityManager.ProcessErrorStateInfo.CREATOR);
        //data.recycle();
        //reply.recycle();
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.758 -0400", hash_original_method = "8E45CD57BE18A4B76C3A3E0DA22BC8B7", hash_generated_method = "1C32A18A1AA8E4A816FB10FD575BED8C")
    public List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() throws RemoteException {
        List<ActivityManager.RunningAppProcessInfo> varB4EAC82CA7396A68D541C85D26508E83_728844872 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_RUNNING_APP_PROCESSES_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.RunningAppProcessInfo> list = reply.createTypedArrayList(ActivityManager.RunningAppProcessInfo.CREATOR);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_728844872 = list;
        varB4EAC82CA7396A68D541C85D26508E83_728844872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_728844872;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(GET_RUNNING_APP_PROCESSES_TRANSACTION, data, reply, 0);
        //reply.readException();
        //ArrayList<ActivityManager.RunningAppProcessInfo> list
        //= reply.createTypedArrayList(ActivityManager.RunningAppProcessInfo.CREATOR);
        //data.recycle();
        //reply.recycle();
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.760 -0400", hash_original_method = "2FAC851B003A84469F94E88A81DA29C3", hash_generated_method = "E9A7FE0A26E22CD31EF00F65ABBE6FE3")
    public List<ApplicationInfo> getRunningExternalApplications() throws RemoteException {
        List<ApplicationInfo> varB4EAC82CA7396A68D541C85D26508E83_1714574234 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ApplicationInfo> list = reply.createTypedArrayList(ApplicationInfo.CREATOR);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1714574234 = list;
        varB4EAC82CA7396A68D541C85D26508E83_1714574234.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1714574234;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION, data, reply, 0);
        //reply.readException();
        //ArrayList<ApplicationInfo> list
        //= reply.createTypedArrayList(ApplicationInfo.CREATOR);
        //data.recycle();
        //reply.recycle();
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.761 -0400", hash_original_method = "DABF13B8F45F6A065880490CD0DBD1A0", hash_generated_method = "9344B34F8FA29BC1D8FCBECB5854FEF2")
    public void moveTaskToFront(int task, int flags) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(task);
        data.writeInt(flags);
        mRemote.transact(MOVE_TASK_TO_FRONT_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(task);
        addTaint(flags);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(task);
        //data.writeInt(flags);
        //mRemote.transact(MOVE_TASK_TO_FRONT_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.762 -0400", hash_original_method = "7FFB6E49EA553237E0A3F53A2CDFD87F", hash_generated_method = "AA642DA2ACB279D0F48A18A24514ABC1")
    public void moveTaskToBack(int task) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(task);
        mRemote.transact(MOVE_TASK_TO_BACK_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(task);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(task);
        //mRemote.transact(MOVE_TASK_TO_BACK_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.762 -0400", hash_original_method = "7F4F39C4D7AB58BCB5DB152705A9F80A", hash_generated_method = "F6B75A94FE6D00160FE6D49F081C8F46")
    public boolean moveActivityTaskToBack(IBinder token, boolean nonRoot) throws RemoteException {
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
        addTaint(token.getTaint());
        addTaint(nonRoot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_652829748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_652829748;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(nonRoot ? 1 : 0);
        //mRemote.transact(MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.763 -0400", hash_original_method = "48BD6DC2300FE39DD3A4B34C3DD91993", hash_generated_method = "7A5DF0CA5E3A65BCF4CE681D4776C101")
    public void moveTaskBackwards(int task) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(task);
        mRemote.transact(MOVE_TASK_BACKWARDS_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(task);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(task);
        //mRemote.transact(MOVE_TASK_BACKWARDS_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.764 -0400", hash_original_method = "3FABC29A3C68690EBF6B4F44EE4A5D23", hash_generated_method = "F8E6C6F6E884F4D7C238CDC0B163FB6D")
    public int getTaskForActivity(IBinder token, boolean onlyRoot) throws RemoteException {
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
        addTaint(token.getTaint());
        addTaint(onlyRoot);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966583667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966583667;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(onlyRoot ? 1 : 0);
        //mRemote.transact(GET_TASK_FOR_ACTIVITY_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int res = reply.readInt();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.765 -0400", hash_original_method = "AF696C3AA9BD79AC1F2D6780E820F3FA", hash_generated_method = "D22A661DBE977F5C7E29448EBC97EB6F")
    public void finishOtherInstances(IBinder token, ComponentName className) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        ComponentName.writeToParcel(className, data);
        mRemote.transact(FINISH_OTHER_INSTANCES_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        addTaint(className.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //ComponentName.writeToParcel(className, data);
        //mRemote.transact(FINISH_OTHER_INSTANCES_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.766 -0400", hash_original_method = "4B3E31ABB8C007E1B3828F729DFD9393", hash_generated_method = "FBEF55531A7E85697237AD4A58936BF8")
    public void reportThumbnail(IBinder token,
                                Bitmap thumbnail, CharSequence description) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        {
            data.writeInt(1);
            thumbnail.writeToParcel(data, 0);
        } //End block
        {
            data.writeInt(0);
        } //End block
        TextUtils.writeToParcel(description, data, 0);
        mRemote.transact(REPORT_THUMBNAIL_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        addTaint(thumbnail.getTaint());
        addTaint(description.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //if (thumbnail != null) {
            //data.writeInt(1);
            //thumbnail.writeToParcel(data, 0);
        //} else {
            //data.writeInt(0);
        //}
        //TextUtils.writeToParcel(description, data, 0);
        //mRemote.transact(REPORT_THUMBNAIL_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.768 -0400", hash_original_method = "EC6CF87E25124312A62325C5F062E996", hash_generated_method = "E43332DA14128337B26CF183B6CCBAD9")
    public ContentProviderHolder getContentProvider(IApplicationThread caller,
                                                    String name) throws RemoteException {
        ContentProviderHolder varB4EAC82CA7396A68D541C85D26508E83_1467686584 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeString(name);
        mRemote.transact(GET_CONTENT_PROVIDER_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        ContentProviderHolder cph = null;
        {
            cph = ContentProviderHolder.CREATOR.createFromParcel(reply);
        } //End block
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1467686584 = cph;
        addTaint(caller.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1467686584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1467686584;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        //data.writeString(name);
        //mRemote.transact(GET_CONTENT_PROVIDER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int res = reply.readInt();
        //ContentProviderHolder cph = null;
        //if (res != 0) {
            //cph = ContentProviderHolder.CREATOR.createFromParcel(reply);
        //}
        //data.recycle();
        //reply.recycle();
        //return cph;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.769 -0400", hash_original_method = "9C5D73DEFA4B6B21F8A4E01DC5E46521", hash_generated_method = "A43383A3871D0AAA4C56EAC7B1814266")
    public void publishContentProviders(IApplicationThread caller,
                                        List<ContentProviderHolder> providers) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeTypedList(providers);
        mRemote.transact(PUBLISH_CONTENT_PROVIDERS_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(caller.getTaint());
        addTaint(providers.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        //data.writeTypedList(providers);
        //mRemote.transact(PUBLISH_CONTENT_PROVIDERS_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.770 -0400", hash_original_method = "6E983079D2A10BB8E3DF4E66B032EE6D", hash_generated_method = "6D17459DCA9D8504413A2330F9FBE399")
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
        addTaint(caller.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        //data.writeString(name);
        //mRemote.transact(REMOVE_CONTENT_PROVIDER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.772 -0400", hash_original_method = "E5355EA6A0F8270964E816C69524096C", hash_generated_method = "1BA7DADDEB0C48F963C8B112A972C677")
    public PendingIntent getRunningServiceControlPanel(ComponentName service) throws RemoteException {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_1638122282 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        service.writeToParcel(data, 0);
        mRemote.transact(GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION, data, reply, 0);
        reply.readException();
        PendingIntent res = PendingIntent.readPendingIntentOrNullFromParcel(reply);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1638122282 = res;
        addTaint(service.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1638122282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1638122282;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //service.writeToParcel(data, 0);
        //mRemote.transact(GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION, data, reply, 0);
        //reply.readException();
        //PendingIntent res = PendingIntent.readPendingIntentOrNullFromParcel(reply);
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.773 -0400", hash_original_method = "A683CF3BA039B3B97AA6ADC23E6FBDCC", hash_generated_method = "ABF70C2CFEB58B0F967832EE82F5B2B1")
    public ComponentName startService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_892126586 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_892126586 = res;
        addTaint(caller.getTaint());
        addTaint(service.getTaint());
        addTaint(resolvedType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_892126586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_892126586;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        //service.writeToParcel(data, 0);
        //data.writeString(resolvedType);
        //mRemote.transact(START_SERVICE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //ComponentName res = ComponentName.readFromParcel(reply);
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.774 -0400", hash_original_method = "B5D9E3A4F6ABA893303F2F02B64751B8", hash_generated_method = "6945C90B60A09442A712A97A9D4016DF")
    public int stopService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException {
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
        addTaint(caller.getTaint());
        addTaint(service.getTaint());
        addTaint(resolvedType.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427928658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427928658;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        //service.writeToParcel(data, 0);
        //data.writeString(resolvedType);
        //mRemote.transact(STOP_SERVICE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int res = reply.readInt();
        //reply.recycle();
        //data.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.775 -0400", hash_original_method = "DB1BCCF2CB5E2532E24072B1F607F963", hash_generated_method = "B47A26DC0A372D8C04FB19A007FACA38")
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
        addTaint(className.getTaint());
        addTaint(token.getTaint());
        addTaint(startId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1936393453 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1936393453;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //ComponentName.writeToParcel(className, data);
        //data.writeStrongBinder(token);
        //data.writeInt(startId);
        //mRemote.transact(STOP_SERVICE_TOKEN_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.776 -0400", hash_original_method = "9DE0D26C134349F3DA011E11517F3FF5", hash_generated_method = "9046E6FC7E09AD809DCD44EDDF896E1F")
    public void setServiceForeground(ComponentName className, IBinder token,
            int id, Notification notification, boolean removeNotification) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        ComponentName.writeToParcel(className, data);
        data.writeStrongBinder(token);
        data.writeInt(id);
        {
            data.writeInt(1);
            notification.writeToParcel(data, 0);
        } //End block
        {
            data.writeInt(0);
        } //End block
        data.writeInt(removeNotification ? 1 : 0);
        mRemote.transact(SET_SERVICE_FOREGROUND_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(className.getTaint());
        addTaint(token.getTaint());
        addTaint(id);
        addTaint(notification.getTaint());
        addTaint(removeNotification);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //ComponentName.writeToParcel(className, data);
        //data.writeStrongBinder(token);
        //data.writeInt(id);
        //if (notification != null) {
            //data.writeInt(1);
            //notification.writeToParcel(data, 0);
        //} else {
            //data.writeInt(0);
        //}
        //data.writeInt(removeNotification ? 1 : 0);
        //mRemote.transact(SET_SERVICE_FOREGROUND_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.778 -0400", hash_original_method = "A1E6D6F237E88697017FA79FBE451840", hash_generated_method = "44483827CE605D905485BDA7B5ADADDB")
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
        addTaint(caller.getTaint());
        addTaint(token.getTaint());
        addTaint(service.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(connection.getTaint());
        addTaint(flags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187649660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187649660;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        //data.writeStrongBinder(token);
        //service.writeToParcel(data, 0);
        //data.writeString(resolvedType);
        //data.writeStrongBinder(connection.asBinder());
        //data.writeInt(flags);
        //mRemote.transact(BIND_SERVICE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int res = reply.readInt();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.779 -0400", hash_original_method = "E0BD37EB96539E724DE863D335954DC9", hash_generated_method = "390976D168AE605F4886D841470865C1")
    public boolean unbindService(IServiceConnection connection) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(connection.asBinder());
        mRemote.transact(UNBIND_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        addTaint(connection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127088330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127088330;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(connection.asBinder());
        //mRemote.transact(UNBIND_SERVICE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.780 -0400", hash_original_method = "87A207496B270585D5EEA34C1AF57170", hash_generated_method = "30AF06877D6BC7326710CBA6D98DC13A")
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
        addTaint(token.getTaint());
        addTaint(intent.getTaint());
        addTaint(service.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //intent.writeToParcel(data, 0);
        //data.writeStrongBinder(service);
        //mRemote.transact(PUBLISH_SERVICE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.781 -0400", hash_original_method = "3796516624A8D493E471933ECF7A3CD3", hash_generated_method = "AC3214644F45436391463545376ECCAE")
    public void unbindFinished(IBinder token, Intent intent, boolean doRebind) throws RemoteException {
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
        addTaint(token.getTaint());
        addTaint(intent.getTaint());
        addTaint(doRebind);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //intent.writeToParcel(data, 0);
        //data.writeInt(doRebind ? 1 : 0);
        //mRemote.transact(UNBIND_FINISHED_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.782 -0400", hash_original_method = "1CB80C62A00C622E35F1B57A132292E9", hash_generated_method = "23ABECF0D91102C6FDE5AC07476B62EF")
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
        addTaint(token.getTaint());
        addTaint(type);
        addTaint(startId);
        addTaint(res);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(type);
        //data.writeInt(startId);
        //data.writeInt(res);
        //mRemote.transact(SERVICE_DONE_EXECUTING_TRANSACTION, data, reply, IBinder.FLAG_ONEWAY);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.783 -0400", hash_original_method = "BEF476EE5F43517187661CDC39F2A448", hash_generated_method = "B40A5E7DAAA7F2FD7A4C334D8E367510")
    public IBinder peekService(Intent service, String resolvedType) throws RemoteException {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1839642893 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1839642893 = binder;
        addTaint(service.getTaint());
        addTaint(resolvedType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1839642893.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1839642893;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //service.writeToParcel(data, 0);
        //data.writeString(resolvedType);
        //mRemote.transact(PEEK_SERVICE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //IBinder binder = reply.readStrongBinder();
        //reply.recycle();
        //data.recycle();
        //return binder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.784 -0400", hash_original_method = "7AACC08C389BEE0061373162626F356D", hash_generated_method = "311EEF787C669E3C26273F820F621BFE")
    public boolean bindBackupAgent(ApplicationInfo app, int backupRestoreMode) throws RemoteException {
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
        addTaint(app.getTaint());
        addTaint(backupRestoreMode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345437227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_345437227;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //app.writeToParcel(data, 0);
        //data.writeInt(backupRestoreMode);
        //mRemote.transact(START_BACKUP_AGENT_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean success = reply.readInt() != 0;
        //reply.recycle();
        //data.recycle();
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.784 -0400", hash_original_method = "ADE4561AB0FC3828104C329F05A9B88C", hash_generated_method = "A6369D22143145B4CCF1517365493351")
    public void backupAgentCreated(String packageName, IBinder agent) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        data.writeStrongBinder(agent);
        mRemote.transact(BACKUP_AGENT_CREATED_TRANSACTION, data, reply, 0);
        reply.recycle();
        data.recycle();
        addTaint(packageName.getTaint());
        addTaint(agent.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(packageName);
        //data.writeStrongBinder(agent);
        //mRemote.transact(BACKUP_AGENT_CREATED_TRANSACTION, data, reply, 0);
        //reply.recycle();
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.785 -0400", hash_original_method = "80BB0DB939AA2A14DC79CE879293739F", hash_generated_method = "092661CB35A283FA6F73AFFA33A39EBB")
    public void unbindBackupAgent(ApplicationInfo app) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        app.writeToParcel(data, 0);
        mRemote.transact(UNBIND_BACKUP_AGENT_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
        addTaint(app.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //app.writeToParcel(data, 0);
        //mRemote.transact(UNBIND_BACKUP_AGENT_TRANSACTION, data, reply, 0);
        //reply.readException();
        //reply.recycle();
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.786 -0400", hash_original_method = "7977DF3866173BBD9227641CB70C5B9A", hash_generated_method = "CE5D8E73903F922C4AF81F53BB816623")
    public boolean startInstrumentation(ComponentName className, String profileFile,
            int flags, Bundle arguments, IInstrumentationWatcher watcher) throws RemoteException {
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
        addTaint(className.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(flags);
        addTaint(arguments.getTaint());
        addTaint(watcher.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717251629 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_717251629;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //ComponentName.writeToParcel(className, data);
        //data.writeString(profileFile);
        //data.writeInt(flags);
        //data.writeBundle(arguments);
        //data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        //mRemote.transact(START_INSTRUMENTATION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //reply.recycle();
        //data.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.788 -0400", hash_original_method = "D76B5F1B397FC7028B59F12CA3604783", hash_generated_method = "20FDA8D052D609029D4EA4BEDE2CA28C")
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
        addTaint(target.getTaint());
        addTaint(resultCode);
        addTaint(results.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(target != null ? target.asBinder() : null);
        //data.writeInt(resultCode);
        //data.writeBundle(results);
        //mRemote.transact(FINISH_INSTRUMENTATION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.789 -0400", hash_original_method = "E824FA9DB2D76671E24682EC782F4756", hash_generated_method = "6B06EDB01D84B125CEEFE0C01863C1D3")
    public Configuration getConfiguration() throws RemoteException {
        Configuration varB4EAC82CA7396A68D541C85D26508E83_1210563334 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        Configuration res = Configuration.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1210563334 = res;
        varB4EAC82CA7396A68D541C85D26508E83_1210563334.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1210563334;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(GET_CONFIGURATION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //Configuration res = Configuration.CREATOR.createFromParcel(reply);
        //reply.recycle();
        //data.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.790 -0400", hash_original_method = "76911A2717FEEEC7D6B4E93DC7F2427C", hash_generated_method = "C340780315CEC13D8335D7FFDF5EFDB8")
    public void updateConfiguration(Configuration values) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        values.writeToParcel(data, 0);
        mRemote.transact(UPDATE_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(values.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //values.writeToParcel(data, 0);
        //mRemote.transact(UPDATE_CONFIGURATION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.791 -0400", hash_original_method = "65FC5D17EF9FF3BF1BFFDA9CCA9A4BE1", hash_generated_method = "46FBA6E52BE66E6786F117EB2F68DD21")
    public void setRequestedOrientation(IBinder token, int requestedOrientation) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(requestedOrientation);
        mRemote.transact(SET_REQUESTED_ORIENTATION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        addTaint(requestedOrientation);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(requestedOrientation);
        //mRemote.transact(SET_REQUESTED_ORIENTATION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.792 -0400", hash_original_method = "505D3FD7966F547E2BAA16E1C1C5F05B", hash_generated_method = "749D283742F087C97A0FC186C43B3A88")
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
        addTaint(token.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_570024670 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_570024670;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(GET_REQUESTED_ORIENTATION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int res = reply.readInt();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.793 -0400", hash_original_method = "BCB55F79D75B3B83E49A75043EE249A9", hash_generated_method = "C7B2620A9396003402CA0FA41306C4CB")
    public ComponentName getActivityClassForToken(IBinder token) throws RemoteException {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_329468260 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION, data, reply, 0);
        reply.readException();
        ComponentName res = ComponentName.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_329468260 = res;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_329468260.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_329468260;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION, data, reply, 0);
        //reply.readException();
        //ComponentName res = ComponentName.readFromParcel(reply);
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.794 -0400", hash_original_method = "9BAE752D062408101ED2F689CF20DDD1", hash_generated_method = "6CB507AD794427A80DEAE4FA4C55EA36")
    public String getPackageForToken(IBinder token) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_1847056241 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_PACKAGE_FOR_TOKEN_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1847056241 = res;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1847056241.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1847056241;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(GET_PACKAGE_FOR_TOKEN_TRANSACTION, data, reply, 0);
        //reply.readException();
        //String res = reply.readString();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.796 -0400", hash_original_method = "AE56AE3D6914251F9FFFA7E33C698EB6", hash_generated_method = "6A16F488097E7F0DF6AF7C9407700EE6")
    public IIntentSender getIntentSender(int type,
            String packageName, IBinder token, String resultWho,
            int requestCode, Intent[] intents, String[] resolvedTypes, int flags) throws RemoteException {
        IIntentSender varB4EAC82CA7396A68D541C85D26508E83_1757152878 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(type);
        data.writeString(packageName);
        data.writeStrongBinder(token);
        data.writeString(resultWho);
        data.writeInt(requestCode);
        {
            data.writeInt(1);
            data.writeTypedArray(intents, 0);
            data.writeStringArray(resolvedTypes);
        } //End block
        {
            data.writeInt(0);
        } //End block
        data.writeInt(flags);
        mRemote.transact(GET_INTENT_SENDER_TRANSACTION, data, reply, 0);
        reply.readException();
        IIntentSender res = IIntentSender.Stub.asInterface(
            reply.readStrongBinder());
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1757152878 = res;
        addTaint(type);
        addTaint(packageName.getTaint());
        addTaint(token.getTaint());
        addTaint(resultWho.getTaint());
        addTaint(requestCode);
        addTaint(intents[0].getTaint());
        addTaint(resolvedTypes[0].getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1757152878.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1757152878;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(type);
        //data.writeString(packageName);
        //data.writeStrongBinder(token);
        //data.writeString(resultWho);
        //data.writeInt(requestCode);
        //if (intents != null) {
            //data.writeInt(1);
            //data.writeTypedArray(intents, 0);
            //data.writeStringArray(resolvedTypes);
        //} else {
            //data.writeInt(0);
        //}
        //data.writeInt(flags);
        //mRemote.transact(GET_INTENT_SENDER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //IIntentSender res = IIntentSender.Stub.asInterface(
            //reply.readStrongBinder());
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.797 -0400", hash_original_method = "D459AA1ADAE84FC2B7BB3BA73C047FDB", hash_generated_method = "90E2C3EEE6DBD415E194FCB2CF5646C8")
    public void cancelIntentSender(IIntentSender sender) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(sender.asBinder());
        mRemote.transact(CANCEL_INTENT_SENDER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(sender.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(sender.asBinder());
        //mRemote.transact(CANCEL_INTENT_SENDER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.799 -0400", hash_original_method = "1993496C4F183452017D412A9B9C5C29", hash_generated_method = "FFEBB6E50586B14DF6006105348234AB")
    public String getPackageForIntentSender(IIntentSender sender) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_1973306119 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(sender.asBinder());
        mRemote.transact(GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1973306119 = res;
        addTaint(sender.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1973306119.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1973306119;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(sender.asBinder());
        //mRemote.transact(GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //String res = reply.readString();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.800 -0400", hash_original_method = "92B622DC0CB7ED23BB116E8953A0A90A", hash_generated_method = "7FCCC0FAFBBE7B8EE66A1F1D53597BD6")
    public void setProcessLimit(int max) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(max);
        mRemote.transact(SET_PROCESS_LIMIT_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(max);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(max);
        //mRemote.transact(SET_PROCESS_LIMIT_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.801 -0400", hash_original_method = "4FA932EFF1C9BAC6AA973FE979D6B75F", hash_generated_method = "FD3009BD626C5AACE60E5C8A9D781234")
    public int getProcessLimit() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_PROCESS_LIMIT_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        data.recycle();
        reply.recycle();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231022030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231022030;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(GET_PROCESS_LIMIT_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int res = reply.readInt();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.802 -0400", hash_original_method = "16F5E36D0F576E8CD2EC3F6B33B5169D", hash_generated_method = "7B5F2C59EFE617DB6CC3E8AAEAC16AAA")
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
        addTaint(token.getTaint());
        addTaint(pid);
        addTaint(isForeground);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(pid);
        //data.writeInt(isForeground ? 1 : 0);
        //mRemote.transact(SET_PROCESS_FOREGROUND_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.805 -0400", hash_original_method = "A50C503DC3495EB643680A38372DD1F5", hash_generated_method = "24969CC51082E73FFA458D9A47A755D6")
    public int checkPermission(String permission, int pid, int uid) throws RemoteException {
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
        addTaint(permission.getTaint());
        addTaint(pid);
        addTaint(uid);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216994233 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216994233;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(permission);
        //data.writeInt(pid);
        //data.writeInt(uid);
        //mRemote.transact(CHECK_PERMISSION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int res = reply.readInt();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.806 -0400", hash_original_method = "BE5C38AE92A5EE5CE45944FF93295090", hash_generated_method = "52205335183B3E4CE5114E3470D8C51C")
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
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_398115023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_398115023;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(packageName);
        //data.writeStrongBinder(observer.asBinder());
        //mRemote.transact(CLEAR_APP_DATA_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.807 -0400", hash_original_method = "FEF4F93E5B02F55707A11B36638BBB59", hash_generated_method = "0CFCD7C644D52C867ECCDFB5D57E7F3D")
    public int checkUriPermission(Uri uri, int pid, int uid, int mode) throws RemoteException {
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
        addTaint(uri.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(mode);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751948049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751948049;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //uri.writeToParcel(data, 0);
        //data.writeInt(pid);
        //data.writeInt(uid);
        //data.writeInt(mode);
        //mRemote.transact(CHECK_URI_PERMISSION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int res = reply.readInt();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.808 -0400", hash_original_method = "2CEB2CA82A36297F49BF5DB3286E579B", hash_generated_method = "E0B0443AF34F8976F423832A18B17035")
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
        addTaint(caller.getTaint());
        addTaint(targetPkg.getTaint());
        addTaint(uri.getTaint());
        addTaint(mode);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller.asBinder());
        //data.writeString(targetPkg);
        //uri.writeToParcel(data, 0);
        //data.writeInt(mode);
        //mRemote.transact(GRANT_URI_PERMISSION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.809 -0400", hash_original_method = "84D534ABCBC85608735C63399D2C9E1E", hash_generated_method = "DCF3C8CC898EAF268FB92CEBF2A31A9A")
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
        addTaint(caller.getTaint());
        addTaint(uri.getTaint());
        addTaint(mode);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller.asBinder());
        //uri.writeToParcel(data, 0);
        //data.writeInt(mode);
        //mRemote.transact(REVOKE_URI_PERMISSION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.810 -0400", hash_original_method = "7FC96553233904C2463E3D793E528211", hash_generated_method = "4BCBC65B410CCE9BBF3ED00B28C6D8AC")
    public void showWaitingForDebugger(IApplicationThread who, boolean waiting) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(who.asBinder());
        data.writeInt(waiting ? 1 : 0);
        mRemote.transact(SHOW_WAITING_FOR_DEBUGGER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(who.getTaint());
        addTaint(waiting);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(who.asBinder());
        //data.writeInt(waiting ? 1 : 0);
        //mRemote.transact(SHOW_WAITING_FOR_DEBUGGER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.811 -0400", hash_original_method = "40DDB58D1BE7B54E85772ACF1AA60D8F", hash_generated_method = "1397C27E60940F652F98D8B963AF60A6")
    public void getMemoryInfo(ActivityManager.MemoryInfo outInfo) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_MEMORY_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        outInfo.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        addTaint(outInfo.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(GET_MEMORY_INFO_TRANSACTION, data, reply, 0);
        //reply.readException();
        //outInfo.readFromParcel(reply);
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.812 -0400", hash_original_method = "805F881D84830966D1AD0B083D69DA9A", hash_generated_method = "35908FEA5D27261ECFCDD707C4543E2A")
    public void unhandledBack() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(UNHANDLED_BACK_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(UNHANDLED_BACK_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.816 -0400", hash_original_method = "1E46E6C9628834765008140B25990D23", hash_generated_method = "0A29B8CF5AC4171D2B21A011F520A106")
    public ParcelFileDescriptor openContentUri(Uri uri) throws RemoteException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_947562326 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(OPEN_CONTENT_URI_TRANSACTION, data, reply, 0);
        reply.readException();
        ParcelFileDescriptor pfd = null;
        {
            boolean varB04A284F06B56929F38634A7F4C6A0D7_1526761710 = (reply.readInt() != 0);
            {
                pfd = ParcelFileDescriptor.CREATOR.createFromParcel(reply);
            } //End block
        } //End collapsed parenthetic
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_947562326 = pfd;
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_947562326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_947562326;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(OPEN_CONTENT_URI_TRANSACTION, data, reply, 0);
        //reply.readException();
        //ParcelFileDescriptor pfd = null;
        //if (reply.readInt() != 0) {
            //pfd = ParcelFileDescriptor.CREATOR.createFromParcel(reply);
        //}
        //data.recycle();
        //reply.recycle();
        //return pfd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.817 -0400", hash_original_method = "E3BC510BF36E68FD23494212AB6E7B33", hash_generated_method = "6FA7FC22CC4827A9155BA6D48B3496C5")
    public void goingToSleep() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GOING_TO_SLEEP_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(GOING_TO_SLEEP_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.818 -0400", hash_original_method = "CAFF51A84FC631E180A23D0F5290B43F", hash_generated_method = "DC06BAFA4F4E0DC663C4ACFECCEA0503")
    public void wakingUp() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(WAKING_UP_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(WAKING_UP_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.819 -0400", hash_original_method = "482C4468B37AD6CEF12EA376A273F16E", hash_generated_method = "E851EFCD85ABE4AA2D3EE141CCB323B0")
    public void setDebugApp(
        String packageName, boolean waitForDebugger, boolean persistent) throws RemoteException {
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
        addTaint(packageName.getTaint());
        addTaint(waitForDebugger);
        addTaint(persistent);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(packageName);
        //data.writeInt(waitForDebugger ? 1 : 0);
        //data.writeInt(persistent ? 1 : 0);
        //mRemote.transact(SET_DEBUG_APP_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.820 -0400", hash_original_method = "DE27B8A416D8E1FF87F079AFA1567A6E", hash_generated_method = "2471FCF0359E57DD146204FA1DB6D3A8")
    public void setAlwaysFinish(boolean enabled) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(enabled ? 1 : 0);
        mRemote.transact(SET_ALWAYS_FINISH_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(enabled);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(enabled ? 1 : 0);
        //mRemote.transact(SET_ALWAYS_FINISH_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.821 -0400", hash_original_method = "D7DBDAD7386DC1F45D7A9AB12513A49B", hash_generated_method = "4267CFA26C799F9BB7A9DC28B3E29C91")
    public void setActivityController(IActivityController watcher) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        mRemote.transact(SET_ACTIVITY_CONTROLLER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(watcher.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        //mRemote.transact(SET_ACTIVITY_CONTROLLER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.822 -0400", hash_original_method = "FF7EEF7728CACAD7286D113A3CF07513", hash_generated_method = "989FB5B63F9FFE72C2D1A765411C7755")
    public void enterSafeMode() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(ENTER_SAFE_MODE_TRANSACTION, data, null, 0);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(ENTER_SAFE_MODE_TRANSACTION, data, null, 0);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.824 -0400", hash_original_method = "72F87C80970F6885E4DCD6DA1B2F19E8", hash_generated_method = "485D199E022242CB4F9031772D4F82D5")
    public void noteWakeupAlarm(IIntentSender sender) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeStrongBinder(sender.asBinder());
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(NOTE_WAKEUP_ALARM_TRANSACTION, data, null, 0);
        data.recycle();
        addTaint(sender.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeStrongBinder(sender.asBinder());
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(NOTE_WAKEUP_ALARM_TRANSACTION, data, null, 0);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.827 -0400", hash_original_method = "DB2721BD1E4C8F1064AA0461CF2A490B", hash_generated_method = "096BE61F101926AC3F4BB2F499E72CF5")
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
        addTaint(pids[0]);
        addTaint(reason.getTaint());
        addTaint(secure);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497903731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_497903731;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeIntArray(pids);
        //data.writeString(reason);
        //data.writeInt(secure ? 1 : 0);
        //mRemote.transact(KILL_PIDS_TRANSACTION, data, reply, 0);
        //boolean res = reply.readInt() != 0;
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.828 -0400", hash_original_method = "9964526F9DDC53538E50ED934A9D4009", hash_generated_method = "333EB8177F2D30F84AD8A0DCA54185F6")
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
        addTaint(pkg.getTaint());
        addTaint(cls.getTaint());
        addTaint(action.getTaint());
        addTaint(indata.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(pkg);
        //data.writeString(cls);
        //data.writeString(action);
        //data.writeString(indata);
        //mRemote.transact(START_RUNNING_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.829 -0400", hash_original_method = "6C8B2FE75A3BFFE16EADA916F678A09D", hash_generated_method = "A333E7F4DF1D67C523E65A1CFB8010EA")
    public boolean testIsSystemReady() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1180145843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1180145843;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.830 -0400", hash_original_method = "523AF9597115E332AF2A1F534C49483C", hash_generated_method = "109DDD27C74923BEC97E04B0C9ACD9FD")
    public void handleApplicationCrash(IBinder app,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(app);
        crashInfo.writeToParcel(data, 0);
        mRemote.transact(HANDLE_APPLICATION_CRASH_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
        addTaint(app.getTaint());
        addTaint(crashInfo.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(app);
        //crashInfo.writeToParcel(data, 0);
        //mRemote.transact(HANDLE_APPLICATION_CRASH_TRANSACTION, data, reply, 0);
        //reply.readException();
        //reply.recycle();
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.831 -0400", hash_original_method = "84EFC78EC4B379D270C222A7BC31C5F7", hash_generated_method = "BC23DC35313BD65BDCE4BC4D5BBD5F87")
    public boolean handleApplicationWtf(IBinder app, String tag,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
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
        addTaint(app.getTaint());
        addTaint(tag.getTaint());
        addTaint(crashInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_463188951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_463188951;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(app);
        //data.writeString(tag);
        //crashInfo.writeToParcel(data, 0);
        //mRemote.transact(HANDLE_APPLICATION_WTF_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //reply.recycle();
        //data.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.832 -0400", hash_original_method = "7AC27E481709B1F0B25AE2BA23B3BECF", hash_generated_method = "16577D5DFF7A4F3F1CCB108933EA773B")
    public void handleApplicationStrictModeViolation(IBinder app,
            int violationMask,
            StrictMode.ViolationInfo info) throws RemoteException {
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
        addTaint(app.getTaint());
        addTaint(violationMask);
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(app);
        //data.writeInt(violationMask);
        //info.writeToParcel(data, 0);
        //mRemote.transact(HANDLE_APPLICATION_STRICT_MODE_VIOLATION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //reply.recycle();
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.834 -0400", hash_original_method = "22BD8EFAE7A36DA76D8B0F7F297E970D", hash_generated_method = "B5EDB738452DB3CB819B5276620EBE8C")
    public void signalPersistentProcesses(int sig) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(sig);
        mRemote.transact(SIGNAL_PERSISTENT_PROCESSES_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(sig);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(sig);
        //mRemote.transact(SIGNAL_PERSISTENT_PROCESSES_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.836 -0400", hash_original_method = "3D80332C8A0FCAFBCE220FADA30302CB", hash_generated_method = "38F0DE759324100AC0383DD9D6A2B37B")
    public void killBackgroundProcesses(String packageName) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        mRemote.transact(KILL_BACKGROUND_PROCESSES_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(packageName);
        //mRemote.transact(KILL_BACKGROUND_PROCESSES_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.838 -0400", hash_original_method = "C7F5D3EA775AD04DD438191F0B4D22C4", hash_generated_method = "3A4D09A3259986E047E1536B505B4986")
    public void killAllBackgroundProcesses() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(KILL_ALL_BACKGROUND_PROCESSES_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(KILL_ALL_BACKGROUND_PROCESSES_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.839 -0400", hash_original_method = "CB4D9E734B2DC6A00C763BA9D15D84CC", hash_generated_method = "A0DA92A7B9A52A5DD954BED570991E1E")
    public void forceStopPackage(String packageName) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        mRemote.transact(FORCE_STOP_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(packageName);
        //mRemote.transact(FORCE_STOP_PACKAGE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.840 -0400", hash_original_method = "9F4AADDAC8F1648FD8C80C6B88BBF25F", hash_generated_method = "B4838BB2CC3E8A3AB96752E00C556C2F")
    public ConfigurationInfo getDeviceConfigurationInfo() throws RemoteException {
        ConfigurationInfo varB4EAC82CA7396A68D541C85D26508E83_362239849 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_DEVICE_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        ConfigurationInfo res = ConfigurationInfo.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_362239849 = res;
        varB4EAC82CA7396A68D541C85D26508E83_362239849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_362239849;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(GET_DEVICE_CONFIGURATION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //ConfigurationInfo res = ConfigurationInfo.CREATOR.createFromParcel(reply);
        //reply.recycle();
        //data.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.842 -0400", hash_original_method = "10D7A082C97EAFB331405B7841F1651D", hash_generated_method = "F58C7CEB5D16D8EB42D90FF7594D76AE")
    public boolean profileControl(String process, boolean start,
            String path, ParcelFileDescriptor fd, int profileType) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(process);
        data.writeInt(start ? 1 : 0);
        data.writeInt(profileType);
        data.writeString(path);
        {
            data.writeInt(1);
            fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        {
            data.writeInt(0);
        } //End block
        mRemote.transact(PROFILE_CONTROL_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(process.getTaint());
        addTaint(start);
        addTaint(path.getTaint());
        addTaint(fd.getTaint());
        addTaint(profileType);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1486710867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1486710867;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(process);
        //data.writeInt(start ? 1 : 0);
        //data.writeInt(profileType);
        //data.writeString(path);
        //if (fd != null) {
            //data.writeInt(1);
            //fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        //} else {
            //data.writeInt(0);
        //}
        //mRemote.transact(PROFILE_CONTROL_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //reply.recycle();
        //data.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.844 -0400", hash_original_method = "52F9DB0BA2A0AB8C52093D208807035C", hash_generated_method = "E7E1E0F573A04B6DFB1C9A06BF2B54DE")
    public boolean shutdown(int timeout) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(timeout);
        mRemote.transact(SHUTDOWN_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1868099562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1868099562;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(timeout);
        //mRemote.transact(SHUTDOWN_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //reply.recycle();
        //data.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.847 -0400", hash_original_method = "BE7DD92CBAD030A60DB7090E3408574C", hash_generated_method = "13EA54D36EF6A74A6B8F116EB09B864A")
    public void stopAppSwitches() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(STOP_APP_SWITCHES_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(STOP_APP_SWITCHES_TRANSACTION, data, reply, 0);
        //reply.readException();
        //reply.recycle();
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.848 -0400", hash_original_method = "0EC9793095E20007EC76AB5DDDE4E54A", hash_generated_method = "6608F43B59121217A1614CC63240E42A")
    public void resumeAppSwitches() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(RESUME_APP_SWITCHES_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(RESUME_APP_SWITCHES_TRANSACTION, data, reply, 0);
        //reply.readException();
        //reply.recycle();
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.849 -0400", hash_original_method = "7B78E2FEC61CC471A8E07C6C34C74BD6", hash_generated_method = "BCBC58F9201C592A064ABBB1FF514113")
    public void registerActivityWatcher(IActivityWatcher watcher) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        mRemote.transact(REGISTER_ACTIVITY_WATCHER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(watcher.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        //mRemote.transact(REGISTER_ACTIVITY_WATCHER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.850 -0400", hash_original_method = "8E5D6F085FE02A1442C5A617ADA012EC", hash_generated_method = "AECBCBF9FEE4EC32AD3BEF890C046BCC")
    public void unregisterActivityWatcher(IActivityWatcher watcher) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        mRemote.transact(UNREGISTER_ACTIVITY_WATCHER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(watcher.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        //mRemote.transact(UNREGISTER_ACTIVITY_WATCHER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.852 -0400", hash_original_method = "C65F778BCD540838D47FE4E4412CD25E", hash_generated_method = "A5FA4DEF60F70306B165438398E98B81")
    public int startActivityInPackage(int uid,
            Intent intent, String resolvedType, IBinder resultTo,
            String resultWho, int requestCode, boolean onlyIfNeeded) throws RemoteException {
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
        addTaint(uid);
        addTaint(intent.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resultWho.getTaint());
        addTaint(requestCode);
        addTaint(onlyIfNeeded);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83106242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83106242;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(uid);
        //intent.writeToParcel(data, 0);
        //data.writeString(resolvedType);
        //data.writeStrongBinder(resultTo);
        //data.writeString(resultWho);
        //data.writeInt(requestCode);
        //data.writeInt(onlyIfNeeded ? 1 : 0);
        //mRemote.transact(START_ACTIVITY_IN_PACKAGE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int result = reply.readInt();
        //reply.recycle();
        //data.recycle();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.853 -0400", hash_original_method = "9BA7CBE5CC5118373D7AAA1497A47635", hash_generated_method = "7C11AA980CF7C24DC1287E7513CDCD88")
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
        addTaint(pkg.getTaint());
        addTaint(uid);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(pkg);
        //data.writeInt(uid);
        //mRemote.transact(KILL_APPLICATION_WITH_UID_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.855 -0400", hash_original_method = "2A680A4513BB1B95074F3F876F148BA8", hash_generated_method = "E94C8E88BF06EB94A16275D7C62E200D")
    public void closeSystemDialogs(String reason) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(reason);
        mRemote.transact(CLOSE_SYSTEM_DIALOGS_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(reason);
        //mRemote.transact(CLOSE_SYSTEM_DIALOGS_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.858 -0400", hash_original_method = "BD88F62F5112FCE1DE930509EBB83FD2", hash_generated_method = "CB4707414AAC148E6FB7716F923013B3")
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) throws RemoteException {
        Debug.MemoryInfo[] varB4EAC82CA7396A68D541C85D26508E83_141311141 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeIntArray(pids);
        mRemote.transact(GET_PROCESS_MEMORY_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        Debug.MemoryInfo[] res = reply.createTypedArray(Debug.MemoryInfo.CREATOR);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_141311141 = res;
        addTaint(pids[0]);
        varB4EAC82CA7396A68D541C85D26508E83_141311141.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_141311141;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeIntArray(pids);
        //mRemote.transact(GET_PROCESS_MEMORY_INFO_TRANSACTION, data, reply, 0);
        //reply.readException();
        //Debug.MemoryInfo[] res = reply.createTypedArray(Debug.MemoryInfo.CREATOR);
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.859 -0400", hash_original_method = "0F16B6E02208618C1D3EE91B8DD80482", hash_generated_method = "18CDF1ACB60C1761E18FE1755B023B55")
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
        addTaint(processName.getTaint());
        addTaint(uid);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(processName);
        //data.writeInt(uid);
        //mRemote.transact(KILL_APPLICATION_PROCESS_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.860 -0400", hash_original_method = "00D6B54E331AC7AA3DC1F40B928FA3FD", hash_generated_method = "6E936C407F22230263CABF02DBE12CB6")
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
        addTaint(token.getTaint());
        addTaint(packageName.getTaint());
        addTaint(enterAnim);
        addTaint(exitAnim);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //data.writeString(packageName);
        //data.writeInt(enterAnim);
        //data.writeInt(exitAnim);
        //mRemote.transact(OVERRIDE_PENDING_TRANSITION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.862 -0400", hash_original_method = "0F906B538EF84DE09E15BAB8CDAE69C4", hash_generated_method = "0F05E87EC18A0B4A20B1D89507E2C251")
    public boolean isUserAMonkey() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(IS_USER_A_MONKEY_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1364354311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1364354311;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(IS_USER_A_MONKEY_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.863 -0400", hash_original_method = "CE9EE2ABB9C16E19ED0FB5ECED80A2D8", hash_generated_method = "EB822339041D216CF933014C954FB685")
    public void finishHeavyWeightApp() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(FINISH_HEAVY_WEIGHT_APP_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(FINISH_HEAVY_WEIGHT_APP_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.866 -0400", hash_original_method = "468B67BFEE008B6CDEC37F42802988FA", hash_generated_method = "2BFA424FBD14EF8D802E97586D641253")
    public void setImmersive(IBinder token, boolean immersive) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(immersive ? 1 : 0);
        mRemote.transact(SET_IMMERSIVE_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        addTaint(immersive);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(immersive ? 1 : 0);
        //mRemote.transact(SET_IMMERSIVE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.868 -0400", hash_original_method = "12E814937BEB239BDABA8A5EE4F6D00D", hash_generated_method = "3D8A6AC1585C7E39857068F3D37BEFE2")
    public boolean isImmersive(IBinder token) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(IS_IMMERSIVE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() == 1;
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887731918 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887731918;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(IS_IMMERSIVE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() == 1;
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.869 -0400", hash_original_method = "0342E1772D9E2D527D167E41870AA176", hash_generated_method = "C35805DD5555D270C6565142D6608367")
    public boolean isTopActivityImmersive() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() == 1;
        data.recycle();
        reply.recycle();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106280610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_106280610;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() == 1;
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.870 -0400", hash_original_method = "574D561A4B99545A454A313F9DD764D8", hash_generated_method = "CCFC2939A31CD0D4F154161977D18122")
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
        addTaint(uid);
        addTaint(initialPid);
        addTaint(packageName.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(uid);
        //data.writeInt(initialPid);
        //data.writeString(packageName);
        //data.writeString(message);
        //mRemote.transact(CRASH_APPLICATION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.872 -0400", hash_original_method = "CF06029063749F4266D5EFBB16694E04", hash_generated_method = "DC6DD31D9DD6938C340473AD242AABDB")
    public String getProviderMimeType(Uri uri) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_1057168529 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        uri.writeToParcel(data, 0);
        mRemote.transact(GET_PROVIDER_MIME_TYPE_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1057168529 = res;
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1057168529.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1057168529;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //uri.writeToParcel(data, 0);
        //mRemote.transact(GET_PROVIDER_MIME_TYPE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //String res = reply.readString();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.876 -0400", hash_original_method = "A975CD5E1392FBC42C40F56501282DDB", hash_generated_method = "559B88921C7F414267ADA83D5EEA3385")
    public IBinder newUriPermissionOwner(String name) throws RemoteException {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1226297715 = null; //Variable for return #1
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(name);
        mRemote.transact(NEW_URI_PERMISSION_OWNER_TRANSACTION, data, reply, 0);
        reply.readException();
        IBinder res = reply.readStrongBinder();
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1226297715 = res;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1226297715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226297715;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(name);
        //mRemote.transact(NEW_URI_PERMISSION_OWNER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //IBinder res = reply.readStrongBinder();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.879 -0400", hash_original_method = "1C35FE424D422C73471D9ECEE35C4093", hash_generated_method = "01A79DC53A326F359C3BB92C5DF194B4")
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
        addTaint(owner.getTaint());
        addTaint(fromUid);
        addTaint(targetPkg.getTaint());
        addTaint(uri.getTaint());
        addTaint(mode);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(owner);
        //data.writeInt(fromUid);
        //data.writeString(targetPkg);
        //uri.writeToParcel(data, 0);
        //data.writeInt(mode);
        //mRemote.transact(GRANT_URI_PERMISSION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.881 -0400", hash_original_method = "D07898A73558FBA66858F774589B082E", hash_generated_method = "04C4B416116EA48200E0ACDDC6113B19")
    public void revokeUriPermissionFromOwner(IBinder owner, Uri uri,
            int mode) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(owner);
        {
            data.writeInt(1);
            uri.writeToParcel(data, 0);
        } //End block
        {
            data.writeInt(0);
        } //End block
        data.writeInt(mode);
        mRemote.transact(REVOKE_URI_PERMISSION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(owner.getTaint());
        addTaint(uri.getTaint());
        addTaint(mode);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(owner);
        //if (uri != null) {
            //data.writeInt(1);
            //uri.writeToParcel(data, 0);
        //} else {
            //data.writeInt(0);
        //}
        //data.writeInt(mode);
        //mRemote.transact(REVOKE_URI_PERMISSION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.882 -0400", hash_original_method = "3DAB9C9F42020370AD19E1FE0AC1BDCE", hash_generated_method = "9C62F6C894FC8ECECDE4D0C7A2D1C6BC")
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
        addTaint(callingUid);
        addTaint(targetPkg.getTaint());
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_757493265 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_757493265;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(callingUid);
        //data.writeString(targetPkg);
        //uri.writeToParcel(data, 0);
        //data.writeInt(modeFlags);
        //mRemote.transact(CHECK_GRANT_URI_PERMISSION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int res = reply.readInt();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.884 -0400", hash_original_method = "2510375C73B367DE6AAF634BB948BB50", hash_generated_method = "25BC35D7615655CAA5017CC6586783A3")
    public boolean dumpHeap(String process, boolean managed,
            String path, ParcelFileDescriptor fd) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(process);
        data.writeInt(managed ? 1 : 0);
        data.writeString(path);
        {
            data.writeInt(1);
            fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        {
            data.writeInt(0);
        } //End block
        mRemote.transact(DUMP_HEAP_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(process.getTaint());
        addTaint(managed);
        addTaint(path.getTaint());
        addTaint(fd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_293317698 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_293317698;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(process);
        //data.writeInt(managed ? 1 : 0);
        //data.writeString(path);
        //if (fd != null) {
            //data.writeInt(1);
            //fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        //} else {
            //data.writeInt(0);
        //}
        //mRemote.transact(DUMP_HEAP_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //reply.recycle();
        //data.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.887 -0400", hash_original_method = "D5FED7EEA920B3F53E1885BDA832FF44", hash_generated_method = "8E1736ABE4D172DCA03818EF6C97D6D1")
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
        addTaint(caller.getTaint());
        addTaint(intents[0].getTaint());
        addTaint(resolvedTypes[0].getTaint());
        addTaint(resultTo.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692189803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692189803;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        //data.writeTypedArray(intents, 0);
        //data.writeStringArray(resolvedTypes);
        //data.writeStrongBinder(resultTo);
        //mRemote.transact(START_ACTIVITIES_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int result = reply.readInt();
        //reply.recycle();
        //data.recycle();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.889 -0400", hash_original_method = "7A44848B4F4A570D7B280FD97AA3F11F", hash_generated_method = "D5B9590D2D93D69DEF9D5421DAFC4C67")
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
        addTaint(uid);
        addTaint(intents[0].getTaint());
        addTaint(resolvedTypes[0].getTaint());
        addTaint(resultTo.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393761712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393761712;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(uid);
        //data.writeTypedArray(intents, 0);
        //data.writeStringArray(resolvedTypes);
        //data.writeStrongBinder(resultTo);
        //mRemote.transact(START_ACTIVITIES_IN_PACKAGE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int result = reply.readInt();
        //reply.recycle();
        //data.recycle();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.890 -0400", hash_original_method = "11A1C93F201BB77459CE48D94392036A", hash_generated_method = "1949A878F1F95D0750A289EC0CF8195F")
    public int getFrontActivityScreenCompatMode() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        int mode = reply.readInt();
        reply.recycle();
        data.recycle();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057729383 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057729383;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int mode = reply.readInt();
        //reply.recycle();
        //data.recycle();
        //return mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.891 -0400", hash_original_method = "984BA2CED473A0F45E8080D25CCDF41F", hash_generated_method = "E8000A6DA77849FA0D512F80B943CA5B")
    public void setFrontActivityScreenCompatMode(int mode) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(mode);
        mRemote.transact(SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
        addTaint(mode);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(mode);
        //mRemote.transact(SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //reply.recycle();
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.892 -0400", hash_original_method = "AFAFCB6FF2EC7CDD310E0CDC4C512BE7", hash_generated_method = "6D447C4347293F8DAC47E55DF301BA0B")
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
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380367338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380367338;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(packageName);
        //mRemote.transact(GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //int mode = reply.readInt();
        //reply.recycle();
        //data.recycle();
        //return mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.893 -0400", hash_original_method = "5B0C9EEE90D8463E1DCC15B68E3829E8", hash_generated_method = "A77EB2EE3FD670B05FEAFE0EA99CD382")
    public void setPackageScreenCompatMode(String packageName, int mode) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        data.writeInt(mode);
        mRemote.transact(SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
        addTaint(packageName.getTaint());
        addTaint(mode);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(packageName);
        //data.writeInt(mode);
        //mRemote.transact(SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //reply.recycle();
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.894 -0400", hash_original_method = "7AFCEC9BC7A2DAB54F3EFFA101044309", hash_generated_method = "9384C64DA5767B1072F7EE981CBA7BD6")
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
        addTaint(packageName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_937519829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_937519829;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(packageName);
        //mRemote.transact(GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean ask = reply.readInt() != 0;
        //reply.recycle();
        //data.recycle();
        //return ask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.895 -0400", hash_original_method = "8C9BAA94A3976358AA466F180A11AE45", hash_generated_method = "06401D9A49EA4B7699291F34750A1B87")
    public void setPackageAskScreenCompat(String packageName, boolean ask) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        data.writeInt(ask ? 1 : 0);
        mRemote.transact(SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION, data, reply, 0);
        reply.readException();
        reply.recycle();
        data.recycle();
        addTaint(packageName.getTaint());
        addTaint(ask);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeString(packageName);
        //data.writeInt(ask ? 1 : 0);
        //mRemote.transact(SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION, data, reply, 0);
        //reply.readException();
        //reply.recycle();
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.897 -0400", hash_original_method = "0A8E6FD2F20689E2107BCC0911A72467", hash_generated_method = "E8C42F3678A95FA3F3995DB5F9A5E9A7")
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
        addTaint(userid);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971167746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_971167746;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(userid);
        //mRemote.transact(SWITCH_USER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean result = reply.readInt() != 0;
        //reply.recycle();
        //data.recycle();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.898 -0400", hash_original_method = "4161F4F4B6F51E7616ED3E0F5DA99E10", hash_generated_method = "A1F5E90B7E82AE19B0DC79932CF125CB")
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
        addTaint(taskId);
        addTaint(subTaskIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1610458618 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1610458618;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(taskId);
        //data.writeInt(subTaskIndex);
        //mRemote.transact(REMOVE_SUB_TASK_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean result = reply.readInt() != 0;
        //reply.recycle();
        //data.recycle();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.899 -0400", hash_original_method = "D75556E86E98C9E69E5D8B6835FF1B1D", hash_generated_method = "B3C0E7A96FEB66996454CE966CB24A57")
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
        addTaint(taskId);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1838465563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1838465563;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeInt(taskId);
        //data.writeInt(flags);
        //mRemote.transact(REMOVE_TASK_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean result = reply.readInt() != 0;
        //reply.recycle();
        //data.recycle();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.900 -0400", hash_original_method = "AD040AF08607A87C88C9CB9BE1E3C408", hash_generated_method = "07C57DB345F12C504D19DAB7B4BC6BF3")
    public void registerProcessObserver(IProcessObserver observer) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(observer != null ? observer.asBinder() : null);
        mRemote.transact(REGISTER_PROCESS_OBSERVER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(observer != null ? observer.asBinder() : null);
        //mRemote.transact(REGISTER_PROCESS_OBSERVER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.901 -0400", hash_original_method = "6FB2BE2D02A98F343D51290C94466533", hash_generated_method = "EF29804F3A434EBFF02D527C33CBA9F5")
    public void unregisterProcessObserver(IProcessObserver observer) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(observer != null ? observer.asBinder() : null);
        mRemote.transact(UNREGISTER_PROCESS_OBSERVER_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(observer != null ? observer.asBinder() : null);
        //mRemote.transact(UNREGISTER_PROCESS_OBSERVER_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.901 -0400", hash_original_method = "A45994938B7DA24AED12FFC5B3B3DD69", hash_generated_method = "EBD78A1873265EB53386660CABE70C33")
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
        addTaint(sender.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_688509292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_688509292;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeStrongBinder(sender.asBinder());
        //mRemote.transact(IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //boolean res = reply.readInt() != 0;
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.902 -0400", hash_original_method = "ACD180EA48DE1CCAABBA4B90AA3470B8", hash_generated_method = "9DC22E7BE51F590AA81A9BAFD9D21AFB")
    public void updatePersistentConfiguration(Configuration values) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        values.writeToParcel(data, 0);
        mRemote.transact(UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        addTaint(values.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //values.writeToParcel(data, 0);
        //mRemote.transact(UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.903 -0400", hash_original_method = "0E9D1ED4F0E7DC85612AA1E9A3EC65BE", hash_generated_method = "DA393496F7314F0074FE5CC1633308F4")
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
        addTaint(pids[0]);
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1170016484 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1170016484;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //data.writeIntArray(pids);
        //mRemote.transact(GET_PROCESS_PSS_TRANSACTION, data, reply, 0);
        //reply.readException();
        //long[] res = reply.createLongArray();
        //data.recycle();
        //reply.recycle();
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.904 -0400", hash_original_method = "F6DDBF719DC0D2BCB3D721A826004A98", hash_generated_method = "ECC62DD7569D2F7F2E669A701F7FB535")
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
        addTaint(msg.getTaint());
        addTaint(always);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //TextUtils.writeToParcel(msg, data, 0);
        //data.writeInt(always ? 1 : 0);
        //mRemote.transact(SHOW_BOOT_MESSAGE_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.906 -0400", hash_original_method = "C6C48FDB33104FCE337F1D8C3A233E89", hash_generated_method = "8F5505827E88689D1F08B162EE225802")
    public void dismissKeyguardOnNextActivity() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(DISMISS_KEYGUARD_ON_NEXT_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        data.recycle();
        reply.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(DISMISS_KEYGUARD_ON_NEXT_ACTIVITY_TRANSACTION, data, reply, 0);
        //reply.readException();
        //data.recycle();
        //reply.recycle();
    }

    
}

