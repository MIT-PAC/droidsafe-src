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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.279 -0400", hash_original_method = "444DC66B3432907DFEA55328E5B69649", hash_generated_method = "FF0B4D083A157B879D7CD5A2215454A9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.214 -0400", hash_original_method = "796B52B1E8846F7CCEC22CD4B5B906A8", hash_generated_method = "1970CE2E1C7868EED003E271A65F87C6")
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //Begin case START_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType;
            resolvedType = data.readString();
            Uri[] grantedUriPermissions;
            grantedUriPermissions = data.createTypedArray(Uri.CREATOR);
            int grantedMode;
            grantedMode = data.readInt();
            IBinder resultTo;
            resultTo = data.readStrongBinder();
            String resultWho;
            resultWho = data.readString();
            int requestCode;
            requestCode = data.readInt();
            boolean onlyIfNeeded;
            onlyIfNeeded = data.readInt() != 0;
            boolean debug;
            debug = data.readInt() != 0;
            String profileFile;
            profileFile = data.readString();
            ParcelFileDescriptor profileFd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1331013391 = (data.readInt() != 0);
            profileFd = data.readFileDescriptor();
            profileFd = null;
            boolean autoStopProfiler;
            autoStopProfiler = data.readInt() != 0;
            int result;
            result = startActivity(app, intent, resolvedType,
                    grantedUriPermissions, grantedMode, resultTo, resultWho,
                    requestCode, onlyIfNeeded, debug, profileFile, profileFd, autoStopProfiler);
            reply.writeNoException();
            reply.writeInt(result);
        } //End block
        //End case START_ACTIVITY_TRANSACTION 
        //Begin case START_ACTIVITY_AND_WAIT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType;
            resolvedType = data.readString();
            Uri[] grantedUriPermissions;
            grantedUriPermissions = data.createTypedArray(Uri.CREATOR);
            int grantedMode;
            grantedMode = data.readInt();
            IBinder resultTo;
            resultTo = data.readStrongBinder();
            String resultWho;
            resultWho = data.readString();
            int requestCode;
            requestCode = data.readInt();
            boolean onlyIfNeeded;
            onlyIfNeeded = data.readInt() != 0;
            boolean debug;
            debug = data.readInt() != 0;
            String profileFile;
            profileFile = data.readString();
            ParcelFileDescriptor profileFd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1447759379 = (data.readInt() != 0);
            profileFd = data.readFileDescriptor();
            profileFd = null;
            boolean autoStopProfiler;
            autoStopProfiler = data.readInt() != 0;
            WaitResult result;
            result = startActivityAndWait(app, intent, resolvedType,
                    grantedUriPermissions, grantedMode, resultTo, resultWho,
                    requestCode, onlyIfNeeded, debug, profileFile, profileFd, autoStopProfiler);
            reply.writeNoException();
            result.writeToParcel(reply, 0);
        } //End block
        //End case START_ACTIVITY_AND_WAIT_TRANSACTION 
        //Begin case START_ACTIVITY_WITH_CONFIG_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType;
            resolvedType = data.readString();
            Uri[] grantedUriPermissions;
            grantedUriPermissions = data.createTypedArray(Uri.CREATOR);
            int grantedMode;
            grantedMode = data.readInt();
            IBinder resultTo;
            resultTo = data.readStrongBinder();
            String resultWho;
            resultWho = data.readString();
            int requestCode;
            requestCode = data.readInt();
            boolean onlyIfNeeded;
            onlyIfNeeded = data.readInt() != 0;
            boolean debug;
            debug = data.readInt() != 0;
            Configuration config;
            config = Configuration.CREATOR.createFromParcel(data);
            int result;
            result = startActivityWithConfig(app, intent, resolvedType,
                    grantedUriPermissions, grantedMode, resultTo, resultWho,
                    requestCode, onlyIfNeeded, debug, config);
            reply.writeNoException();
            reply.writeInt(result);
        } //End block
        //End case START_ACTIVITY_WITH_CONFIG_TRANSACTION 
        //Begin case START_ACTIVITY_INTENT_SENDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            IntentSender intent;
            intent = IntentSender.CREATOR.createFromParcel(data);
            Intent fillInIntent;
            fillInIntent = null;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_118701836 = (data.readInt() != 0);
                {
                    fillInIntent = Intent.CREATOR.createFromParcel(data);
                } //End block
            } //End collapsed parenthetic
            String resolvedType;
            resolvedType = data.readString();
            IBinder resultTo;
            resultTo = data.readStrongBinder();
            String resultWho;
            resultWho = data.readString();
            int requestCode;
            requestCode = data.readInt();
            int flagsMask;
            flagsMask = data.readInt();
            int flagsValues;
            flagsValues = data.readInt();
            int result;
            result = startActivityIntentSender(app, intent,
                    fillInIntent, resolvedType, resultTo, resultWho,
                    requestCode, flagsMask, flagsValues);
            reply.writeNoException();
            reply.writeInt(result);
        } //End block
        //End case START_ACTIVITY_INTENT_SENDER_TRANSACTION 
        //Begin case START_NEXT_MATCHING_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder callingActivity;
            callingActivity = data.readStrongBinder();
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            boolean result;
            result = startNextMatchingActivity(callingActivity, intent);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
        } //End block
        //End case START_NEXT_MATCHING_ACTIVITY_TRANSACTION 
        //Begin case FINISH_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            Intent resultData;
            resultData = null;
            int resultCode;
            resultCode = data.readInt();
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_1073740100 = (data.readInt() != 0);
                {
                    resultData = Intent.CREATOR.createFromParcel(data);
                } //End block
            } //End collapsed parenthetic
            boolean res;
            res = finishActivity(token, resultCode, resultData);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case FINISH_ACTIVITY_TRANSACTION 
        //Begin case FINISH_SUB_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            String resultWho;
            resultWho = data.readString();
            int requestCode;
            requestCode = data.readInt();
            finishSubActivity(token, resultWho, requestCode);
            reply.writeNoException();
        } //End block
        //End case FINISH_SUB_ACTIVITY_TRANSACTION 
        //Begin case WILL_ACTIVITY_BE_VISIBLE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            boolean res;
            res = willActivityBeVisible(token);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case WILL_ACTIVITY_BE_VISIBLE_TRANSACTION 
        //Begin case REGISTER_RECEIVER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            app = null;
            String packageName;
            packageName = data.readString();
            b = data.readStrongBinder();
            IIntentReceiver rec;
            rec = IIntentReceiver.Stub.asInterface(b);
            rec = null;
            IntentFilter filter;
            filter = IntentFilter.CREATOR.createFromParcel(data);
            String perm;
            perm = data.readString();
            Intent intent;
            intent = registerReceiver(app, packageName, rec, filter, perm);
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
            IBinder b;
            b = data.readStrongBinder();
            IIntentReceiver rec;
            rec = IIntentReceiver.Stub.asInterface(b);
            unregisterReceiver(rec);
            reply.writeNoException();
        } //End block
        //End case UNREGISTER_RECEIVER_TRANSACTION 
        //Begin case BROADCAST_INTENT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            app = null;
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType;
            resolvedType = data.readString();
            b = data.readStrongBinder();
            IIntentReceiver resultTo;
            resultTo = IIntentReceiver.Stub.asInterface(b);
            resultTo = null;
            int resultCode;
            resultCode = data.readInt();
            String resultData;
            resultData = data.readString();
            Bundle resultExtras;
            resultExtras = data.readBundle();
            String perm;
            perm = data.readString();
            boolean serialized;
            serialized = data.readInt() != 0;
            boolean sticky;
            sticky = data.readInt() != 0;
            int res;
            res = broadcastIntent(app, intent, resolvedType, resultTo,
                    resultCode, resultData, resultExtras, perm,
                    serialized, sticky);
            reply.writeNoException();
            reply.writeInt(res);
        } //End block
        //End case BROADCAST_INTENT_TRANSACTION 
        //Begin case UNBROADCAST_INTENT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            app = null;
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            unbroadcastIntent(app, intent);
            reply.writeNoException();
        } //End block
        //End case UNBROADCAST_INTENT_TRANSACTION 
        //Begin case FINISH_RECEIVER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder who;
            who = data.readStrongBinder();
            int resultCode;
            resultCode = data.readInt();
            String resultData;
            resultData = data.readString();
            Bundle resultExtras;
            resultExtras = data.readBundle();
            boolean resultAbort;
            resultAbort = data.readInt() != 0;
            {
                finishReceiver(who, resultCode, resultData, resultExtras, resultAbort);
            } //End block
            reply.writeNoException();
        } //End block
        //End case FINISH_RECEIVER_TRANSACTION 
        //Begin case ATTACH_APPLICATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(
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
            IBinder token;
            token = data.readStrongBinder();
            Configuration config;
            config = null;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_906665125 = (data.readInt() != 0);
                {
                    config = Configuration.CREATOR.createFromParcel(data);
                } //End block
            } //End collapsed parenthetic
            boolean stopProfiling;
            stopProfiling = data.readInt() != 0;
            {
                activityIdle(token, config, stopProfiling);
            } //End block
            reply.writeNoException();
        } //End block
        //End case ACTIVITY_IDLE_TRANSACTION 
        //Begin case ACTIVITY_PAUSED_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            activityPaused(token);
            reply.writeNoException();
        } //End block
        //End case ACTIVITY_PAUSED_TRANSACTION 
        //Begin case ACTIVITY_STOPPED_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            Bundle map;
            map = data.readBundle();
            Bitmap thumbnail;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1749362642 = (data.readInt() != 0);
            thumbnail = Bitmap.CREATOR.createFromParcel(data);
            thumbnail = null;
            CharSequence description;
            description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            activityStopped(token, map, thumbnail, description);
            reply.writeNoException();
        } //End block
        //End case ACTIVITY_STOPPED_TRANSACTION 
        //Begin case ACTIVITY_SLEPT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            activitySlept(token);
            reply.writeNoException();
        } //End block
        //End case ACTIVITY_SLEPT_TRANSACTION 
        //Begin case ACTIVITY_DESTROYED_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            activityDestroyed(token);
            reply.writeNoException();
        } //End block
        //End case ACTIVITY_DESTROYED_TRANSACTION 
        //Begin case GET_CALLING_PACKAGE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
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
            IBinder token;
            token = data.readStrongBinder();
            ComponentName cn;
            cn = getCallingActivity(token);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
        } //End block
        //End case GET_CALLING_ACTIVITY_TRANSACTION 
        //Begin case GET_TASKS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int maxNum;
            maxNum = data.readInt();
            int fl;
            fl = data.readInt();
            IBinder receiverBinder;
            receiverBinder = data.readStrongBinder();
            IThumbnailReceiver receiver;
            receiver = IThumbnailReceiver.Stub.asInterface(receiverBinder);
            receiver = null;
            List list;
            list = getTasks(maxNum, fl, receiver);
            reply.writeNoException();
            int N;
            N = list.size();
            N = -1;
            reply.writeInt(N);
            int i;
            {
                i=0;
                {
                    ActivityManager.RunningTaskInfo info;
                    info = (ActivityManager.RunningTaskInfo)list.get(i);
                    info.writeToParcel(reply, 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case GET_TASKS_TRANSACTION 
        //Begin case GET_RECENT_TASKS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int maxNum;
            maxNum = data.readInt();
            int fl;
            fl = data.readInt();
            List<ActivityManager.RecentTaskInfo> list;
            list = getRecentTasks(maxNum,
                    fl);
            reply.writeNoException();
            reply.writeTypedList(list);
        } //End block
        //End case GET_RECENT_TASKS_TRANSACTION 
        //Begin case GET_TASK_THUMBNAILS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int id;
            id = data.readInt();
            ActivityManager.TaskThumbnails bm;
            bm = getTaskThumbnails(id);
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
            int maxNum;
            maxNum = data.readInt();
            int fl;
            fl = data.readInt();
            List list;
            list = getServices(maxNum, fl);
            reply.writeNoException();
            int N;
            N = list.size();
            N = -1;
            reply.writeInt(N);
            int i;
            {
                i=0;
                {
                    ActivityManager.RunningServiceInfo info;
                    info = (ActivityManager.RunningServiceInfo)list.get(i);
                    info.writeToParcel(reply, 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case GET_SERVICES_TRANSACTION 
        //Begin case GET_PROCESSES_IN_ERROR_STATE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ActivityManager.ProcessErrorStateInfo> list;
            list = getProcessesInErrorState();
            reply.writeNoException();
            reply.writeTypedList(list);
        } //End block
        //End case GET_PROCESSES_IN_ERROR_STATE_TRANSACTION 
        //Begin case GET_RUNNING_APP_PROCESSES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ActivityManager.RunningAppProcessInfo> list;
            list = getRunningAppProcesses();
            reply.writeNoException();
            reply.writeTypedList(list);
        } //End block
        //End case GET_RUNNING_APP_PROCESSES_TRANSACTION 
        //Begin case GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ApplicationInfo> list;
            list = getRunningExternalApplications();
            reply.writeNoException();
            reply.writeTypedList(list);
        } //End block
        //End case GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION 
        //Begin case MOVE_TASK_TO_FRONT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task;
            task = data.readInt();
            int fl;
            fl = data.readInt();
            moveTaskToFront(task, fl);
            reply.writeNoException();
        } //End block
        //End case MOVE_TASK_TO_FRONT_TRANSACTION 
        //Begin case MOVE_TASK_TO_BACK_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task;
            task = data.readInt();
            moveTaskToBack(task);
            reply.writeNoException();
        } //End block
        //End case MOVE_TASK_TO_BACK_TRANSACTION 
        //Begin case MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            boolean nonRoot;
            nonRoot = data.readInt() != 0;
            boolean res;
            res = moveActivityTaskToBack(token, nonRoot);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION 
        //Begin case MOVE_TASK_BACKWARDS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task;
            task = data.readInt();
            moveTaskBackwards(task);
            reply.writeNoException();
        } //End block
        //End case MOVE_TASK_BACKWARDS_TRANSACTION 
        //Begin case GET_TASK_FOR_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            boolean onlyRoot;
            onlyRoot = data.readInt() != 0;
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
            IBinder token;
            token = data.readStrongBinder();
            ComponentName className;
            className = ComponentName.readFromParcel(data);
            finishOtherInstances(token, className);
            reply.writeNoException();
        } //End block
        //End case FINISH_OTHER_INSTANCES_TRANSACTION 
        //Begin case REPORT_THUMBNAIL_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            Bitmap thumbnail;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_784147 = (data.readInt() != 0);
            thumbnail = Bitmap.CREATOR.createFromParcel(data);
            thumbnail = null;
            CharSequence description;
            description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            reportThumbnail(token, thumbnail, description);
            reply.writeNoException();
        } //End block
        //End case REPORT_THUMBNAIL_TRANSACTION 
        //Begin case GET_CONTENT_PROVIDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            String name;
            name = data.readString();
            ContentProviderHolder cph;
            cph = getContentProvider(app, name);
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
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            ArrayList<ContentProviderHolder> providers;
            providers = data.createTypedArrayList(ContentProviderHolder.CREATOR);
            publishContentProviders(app, providers);
            reply.writeNoException();
        } //End block
        //End case PUBLISH_CONTENT_PROVIDERS_TRANSACTION 
        //Begin case REMOVE_CONTENT_PROVIDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            String name;
            name = data.readString();
            removeContentProvider(app, name);
            reply.writeNoException();
        } //End block
        //End case REMOVE_CONTENT_PROVIDER_TRANSACTION 
        //Begin case GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName comp;
            comp = ComponentName.CREATOR.createFromParcel(data);
            PendingIntent pi;
            pi = getRunningServiceControlPanel(comp);
            reply.writeNoException();
            PendingIntent.writePendingIntentOrNullToParcel(pi, reply);
        } //End block
        //End case GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION 
        //Begin case START_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            Intent service;
            service = Intent.CREATOR.createFromParcel(data);
            String resolvedType;
            resolvedType = data.readString();
            ComponentName cn;
            cn = startService(app, service, resolvedType);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
        } //End block
        //End case START_SERVICE_TRANSACTION 
        //Begin case STOP_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            Intent service;
            service = Intent.CREATOR.createFromParcel(data);
            String resolvedType;
            resolvedType = data.readString();
            int res;
            res = stopService(app, service, resolvedType);
            reply.writeNoException();
            reply.writeInt(res);
        } //End block
        //End case STOP_SERVICE_TRANSACTION 
        //Begin case STOP_SERVICE_TOKEN_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName className;
            className = ComponentName.readFromParcel(data);
            IBinder token;
            token = data.readStrongBinder();
            int startId;
            startId = data.readInt();
            boolean res;
            res = stopServiceToken(className, token, startId);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case STOP_SERVICE_TOKEN_TRANSACTION 
        //Begin case SET_SERVICE_FOREGROUND_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName className;
            className = ComponentName.readFromParcel(data);
            IBinder token;
            token = data.readStrongBinder();
            int id;
            id = data.readInt();
            Notification notification;
            notification = null;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_1056902682 = (data.readInt() != 0);
                {
                    notification = Notification.CREATOR.createFromParcel(data);
                } //End block
            } //End collapsed parenthetic
            boolean removeNotification;
            removeNotification = data.readInt() != 0;
            setServiceForeground(className, token, id, notification, removeNotification);
            reply.writeNoException();
        } //End block
        //End case SET_SERVICE_FOREGROUND_TRANSACTION 
        //Begin case BIND_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            IBinder token;
            token = data.readStrongBinder();
            Intent service;
            service = Intent.CREATOR.createFromParcel(data);
            String resolvedType;
            resolvedType = data.readString();
            b = data.readStrongBinder();
            int fl;
            fl = data.readInt();
            IServiceConnection conn;
            conn = IServiceConnection.Stub.asInterface(b);
            int res;
            res = bindService(app, token, service, resolvedType, conn, fl);
            reply.writeNoException();
            reply.writeInt(res);
        } //End block
        //End case BIND_SERVICE_TRANSACTION 
        //Begin case UNBIND_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IServiceConnection conn;
            conn = IServiceConnection.Stub.asInterface(b);
            boolean res;
            res = unbindService(conn);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case UNBIND_SERVICE_TRANSACTION 
        //Begin case PUBLISH_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            IBinder service;
            service = data.readStrongBinder();
            publishService(token, intent, service);
            reply.writeNoException();
        } //End block
        //End case PUBLISH_SERVICE_TRANSACTION 
        //Begin case UNBIND_FINISHED_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            boolean doRebind;
            doRebind = data.readInt() != 0;
            unbindFinished(token, intent, doRebind);
            reply.writeNoException();
        } //End block
        //End case UNBIND_FINISHED_TRANSACTION 
        //Begin case SERVICE_DONE_EXECUTING_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            int type;
            type = data.readInt();
            int startId;
            startId = data.readInt();
            int res;
            res = data.readInt();
            serviceDoneExecuting(token, type, startId, res);
            reply.writeNoException();
        } //End block
        //End case SERVICE_DONE_EXECUTING_TRANSACTION 
        //Begin case START_INSTRUMENTATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName className;
            className = ComponentName.readFromParcel(data);
            String profileFile;
            profileFile = data.readString();
            int fl;
            fl = data.readInt();
            Bundle arguments;
            arguments = data.readBundle();
            IBinder b;
            b = data.readStrongBinder();
            IInstrumentationWatcher w;
            w = IInstrumentationWatcher.Stub.asInterface(b);
            boolean res;
            res = startInstrumentation(className, profileFile, fl, arguments, w);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case START_INSTRUMENTATION_TRANSACTION 
        //Begin case FINISH_INSTRUMENTATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            int resultCode;
            resultCode = data.readInt();
            Bundle results;
            results = data.readBundle();
            finishInstrumentation(app, resultCode, results);
            reply.writeNoException();
        } //End block
        //End case FINISH_INSTRUMENTATION_TRANSACTION 
        //Begin case GET_CONFIGURATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config;
            config = getConfiguration();
            reply.writeNoException();
            config.writeToParcel(reply, 0);
        } //End block
        //End case GET_CONFIGURATION_TRANSACTION 
        //Begin case UPDATE_CONFIGURATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config;
            config = Configuration.CREATOR.createFromParcel(data);
            updateConfiguration(config);
            reply.writeNoException();
        } //End block
        //End case UPDATE_CONFIGURATION_TRANSACTION 
        //Begin case SET_REQUESTED_ORIENTATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            int requestedOrientation;
            requestedOrientation = data.readInt();
            setRequestedOrientation(token, requestedOrientation);
            reply.writeNoException();
        } //End block
        //End case SET_REQUESTED_ORIENTATION_TRANSACTION 
        //Begin case GET_REQUESTED_ORIENTATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            int req;
            req = getRequestedOrientation(token);
            reply.writeNoException();
            reply.writeInt(req);
        } //End block
        //End case GET_REQUESTED_ORIENTATION_TRANSACTION 
        //Begin case GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            ComponentName cn;
            cn = getActivityClassForToken(token);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
        } //End block
        //End case GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION 
        //Begin case GET_PACKAGE_FOR_TOKEN_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            reply.writeNoException();
            reply.writeString(getPackageForToken(token));
        } //End block
        //End case GET_PACKAGE_FOR_TOKEN_TRANSACTION 
        //Begin case GET_INTENT_SENDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int type;
            type = data.readInt();
            String packageName;
            packageName = data.readString();
            IBinder token;
            token = data.readStrongBinder();
            String resultWho;
            resultWho = data.readString();
            int requestCode;
            requestCode = data.readInt();
            Intent[] requestIntents;
            String[] requestResolvedTypes;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_1164406372 = (data.readInt() != 0);
                {
                    requestIntents = data.createTypedArray(Intent.CREATOR);
                    requestResolvedTypes = data.createStringArray();
                } //End block
                {
                    requestIntents = null;
                    requestResolvedTypes = null;
                } //End block
            } //End collapsed parenthetic
            int fl;
            fl = data.readInt();
            IIntentSender res;
            res = getIntentSender(type, packageName, token,
                    resultWho, requestCode, requestIntents,
                    requestResolvedTypes, fl);
            reply.writeNoException();
            reply.writeStrongBinder(res != null ? res.asBinder() : null);
        } //End block
        //End case GET_INTENT_SENDER_TRANSACTION 
        //Begin case CANCEL_INTENT_SENDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r;
            r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            cancelIntentSender(r);
            reply.writeNoException();
        } //End block
        //End case CANCEL_INTENT_SENDER_TRANSACTION 
        //Begin case GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r;
            r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            String res;
            res = getPackageForIntentSender(r);
            reply.writeNoException();
            reply.writeString(res);
        } //End block
        //End case GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION 
        //Begin case SET_PROCESS_LIMIT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int max;
            max = data.readInt();
            setProcessLimit(max);
            reply.writeNoException();
        } //End block
        //End case SET_PROCESS_LIMIT_TRANSACTION 
        //Begin case GET_PROCESS_LIMIT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int limit;
            limit = getProcessLimit();
            reply.writeNoException();
            reply.writeInt(limit);
        } //End block
        //End case GET_PROCESS_LIMIT_TRANSACTION 
        //Begin case SET_PROCESS_FOREGROUND_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            int pid;
            pid = data.readInt();
            boolean isForeground;
            isForeground = data.readInt() != 0;
            setProcessForeground(token, pid, isForeground);
            reply.writeNoException();
        } //End block
        //End case SET_PROCESS_FOREGROUND_TRANSACTION 
        //Begin case CHECK_PERMISSION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String perm;
            perm = data.readString();
            int pid;
            pid = data.readInt();
            int uid;
            uid = data.readInt();
            int res;
            res = checkPermission(perm, pid, uid);
            reply.writeNoException();
            reply.writeInt(res);
        } //End block
        //End case CHECK_PERMISSION_TRANSACTION 
        //Begin case CHECK_URI_PERMISSION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri;
            uri = Uri.CREATOR.createFromParcel(data);
            int pid;
            pid = data.readInt();
            int uid;
            uid = data.readInt();
            int mode;
            mode = data.readInt();
            int res;
            res = checkUriPermission(uri, pid, uid, mode);
            reply.writeNoException();
            reply.writeInt(res);
        } //End block
        //End case CHECK_URI_PERMISSION_TRANSACTION 
        //Begin case CLEAR_APP_DATA_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName;
            packageName = data.readString();
            IPackageDataObserver observer;
            observer = IPackageDataObserver.Stub.asInterface(
                    data.readStrongBinder());
            boolean res;
            res = clearApplicationUserData(packageName, observer);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case CLEAR_APP_DATA_TRANSACTION 
        //Begin case GRANT_URI_PERMISSION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            String targetPkg;
            targetPkg = data.readString();
            Uri uri;
            uri = Uri.CREATOR.createFromParcel(data);
            int mode;
            mode = data.readInt();
            grantUriPermission(app, targetPkg, uri, mode);
            reply.writeNoException();
        } //End block
        //End case GRANT_URI_PERMISSION_TRANSACTION 
        //Begin case REVOKE_URI_PERMISSION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            Uri uri;
            uri = Uri.CREATOR.createFromParcel(data);
            int mode;
            mode = data.readInt();
            revokeUriPermission(app, uri, mode);
            reply.writeNoException();
        } //End block
        //End case REVOKE_URI_PERMISSION_TRANSACTION 
        //Begin case SHOW_WAITING_FOR_DEBUGGER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            boolean waiting;
            waiting = data.readInt() != 0;
            showWaitingForDebugger(app, waiting);
            reply.writeNoException();
        } //End block
        //End case SHOW_WAITING_FOR_DEBUGGER_TRANSACTION 
        //Begin case GET_MEMORY_INFO_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ActivityManager.MemoryInfo mi;
            mi = new ActivityManager.MemoryInfo();
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
            Uri uri;
            uri = Uri.parse(data.readString());
            ParcelFileDescriptor pfd;
            pfd = openContentUri(uri);
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
            String pn;
            pn = data.readString();
            boolean wfd;
            wfd = data.readInt() != 0;
            boolean per;
            per = data.readInt() != 0;
            setDebugApp(pn, wfd, per);
            reply.writeNoException();
        } //End block
        //End case SET_DEBUG_APP_TRANSACTION 
        //Begin case SET_ALWAYS_FINISH_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean enabled;
            enabled = data.readInt() != 0;
            setAlwaysFinish(enabled);
            reply.writeNoException();
        } //End block
        //End case SET_ALWAYS_FINISH_TRANSACTION 
        //Begin case SET_ACTIVITY_CONTROLLER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityController watcher;
            watcher = IActivityController.Stub.asInterface(
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
            IIntentSender is;
            is = IIntentSender.Stub.asInterface(
                    data.readStrongBinder());
            noteWakeupAlarm(is);
            reply.writeNoException();
        } //End block
        //End case NOTE_WAKEUP_ALARM_TRANSACTION 
        //Begin case KILL_PIDS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids;
            pids = data.createIntArray();
            String reason;
            reason = data.readString();
            boolean secure;
            secure = data.readInt() != 0;
            boolean res;
            res = killPids(pids, reason, secure);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case KILL_PIDS_TRANSACTION 
        //Begin case START_RUNNING_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg;
            pkg = data.readString();
            String cls;
            cls = data.readString();
            String action;
            action = data.readString();
            String indata;
            indata = data.readString();
            startRunning(pkg, cls, action, indata);
            reply.writeNoException();
        } //End block
        //End case START_RUNNING_TRANSACTION 
        //Begin case HANDLE_APPLICATION_CRASH_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app;
            app = data.readStrongBinder();
            ApplicationErrorReport.CrashInfo ci;
            ci = new ApplicationErrorReport.CrashInfo(data);
            handleApplicationCrash(app, ci);
            reply.writeNoException();
        } //End block
        //End case HANDLE_APPLICATION_CRASH_TRANSACTION 
        //Begin case HANDLE_APPLICATION_WTF_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app;
            app = data.readStrongBinder();
            String tag;
            tag = data.readString();
            ApplicationErrorReport.CrashInfo ci;
            ci = new ApplicationErrorReport.CrashInfo(data);
            boolean res;
            res = handleApplicationWtf(app, tag, ci);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case HANDLE_APPLICATION_WTF_TRANSACTION 
        //Begin case HANDLE_APPLICATION_STRICT_MODE_VIOLATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app;
            app = data.readStrongBinder();
            int violationMask;
            violationMask = data.readInt();
            StrictMode.ViolationInfo info;
            info = new StrictMode.ViolationInfo(data);
            handleApplicationStrictModeViolation(app, violationMask, info);
            reply.writeNoException();
        } //End block
        //End case HANDLE_APPLICATION_STRICT_MODE_VIOLATION_TRANSACTION 
        //Begin case SIGNAL_PERSISTENT_PROCESSES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int sig;
            sig = data.readInt();
            signalPersistentProcesses(sig);
            reply.writeNoException();
        } //End block
        //End case SIGNAL_PERSISTENT_PROCESSES_TRANSACTION 
        //Begin case KILL_BACKGROUND_PROCESSES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName;
            packageName = data.readString();
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
            String packageName;
            packageName = data.readString();
            forceStopPackage(packageName);
            reply.writeNoException();
        } //End block
        //End case FORCE_STOP_PACKAGE_TRANSACTION 
        //Begin case GET_DEVICE_CONFIGURATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ConfigurationInfo config;
            config = getDeviceConfigurationInfo();
            reply.writeNoException();
            config.writeToParcel(reply, 0);
        } //End block
        //End case GET_DEVICE_CONFIGURATION_TRANSACTION 
        //Begin case PROFILE_CONTROL_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String process;
            process = data.readString();
            boolean start;
            start = data.readInt() != 0;
            int profileType;
            profileType = data.readInt();
            String path;
            path = data.readString();
            ParcelFileDescriptor fd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1097006587 = (data.readInt() != 0);
            fd = data.readFileDescriptor();
            fd = null;
            boolean res;
            res = profileControl(process, start, path, fd, profileType);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case PROFILE_CONTROL_TRANSACTION 
        //Begin case SHUTDOWN_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean res;
            res = shutdown(data.readInt());
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
            Intent service;
            service = Intent.CREATOR.createFromParcel(data);
            String resolvedType;
            resolvedType = data.readString();
            IBinder binder;
            binder = peekService(service, resolvedType);
            reply.writeNoException();
            reply.writeStrongBinder(binder);
        } //End block
        //End case PEEK_SERVICE_TRANSACTION 
        //Begin case START_BACKUP_AGENT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ApplicationInfo info;
            info = ApplicationInfo.CREATOR.createFromParcel(data);
            int backupRestoreMode;
            backupRestoreMode = data.readInt();
            boolean success;
            success = bindBackupAgent(info, backupRestoreMode);
            reply.writeNoException();
            reply.writeInt(success ? 1 : 0);
        } //End block
        //End case START_BACKUP_AGENT_TRANSACTION 
        //Begin case BACKUP_AGENT_CREATED_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName;
            packageName = data.readString();
            IBinder agent;
            agent = data.readStrongBinder();
            backupAgentCreated(packageName, agent);
            reply.writeNoException();
        } //End block
        //End case BACKUP_AGENT_CREATED_TRANSACTION 
        //Begin case UNBIND_BACKUP_AGENT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            ApplicationInfo info;
            info = ApplicationInfo.CREATOR.createFromParcel(data);
            unbindBackupAgent(info);
            reply.writeNoException();
        } //End block
        //End case UNBIND_BACKUP_AGENT_TRANSACTION 
        //Begin case REGISTER_ACTIVITY_WATCHER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityWatcher watcher;
            watcher = IActivityWatcher.Stub.asInterface(
                    data.readStrongBinder());
            registerActivityWatcher(watcher);
        } //End block
        //End case REGISTER_ACTIVITY_WATCHER_TRANSACTION 
        //Begin case UNREGISTER_ACTIVITY_WATCHER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityWatcher watcher;
            watcher = IActivityWatcher.Stub.asInterface(
                    data.readStrongBinder());
            unregisterActivityWatcher(watcher);
        } //End block
        //End case UNREGISTER_ACTIVITY_WATCHER_TRANSACTION 
        //Begin case START_ACTIVITY_IN_PACKAGE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int uid;
            uid = data.readInt();
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType;
            resolvedType = data.readString();
            IBinder resultTo;
            resultTo = data.readStrongBinder();
            String resultWho;
            resultWho = data.readString();
            int requestCode;
            requestCode = data.readInt();
            boolean onlyIfNeeded;
            onlyIfNeeded = data.readInt() != 0;
            int result;
            result = startActivityInPackage(uid, intent, resolvedType,
                    resultTo, resultWho, requestCode, onlyIfNeeded);
            reply.writeNoException();
            reply.writeInt(result);
        } //End block
        //End case START_ACTIVITY_IN_PACKAGE_TRANSACTION 
        //Begin case KILL_APPLICATION_WITH_UID_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg;
            pkg = data.readString();
            int uid;
            uid = data.readInt();
            killApplicationWithUid(pkg, uid);
            reply.writeNoException();
        } //End block
        //End case KILL_APPLICATION_WITH_UID_TRANSACTION 
        //Begin case CLOSE_SYSTEM_DIALOGS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String reason;
            reason = data.readString();
            closeSystemDialogs(reason);
            reply.writeNoException();
        } //End block
        //End case CLOSE_SYSTEM_DIALOGS_TRANSACTION 
        //Begin case GET_PROCESS_MEMORY_INFO_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids;
            pids = data.createIntArray();
            Debug.MemoryInfo[] res;
            res = getProcessMemoryInfo(pids);
            reply.writeNoException();
            reply.writeTypedArray(res, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        //End case GET_PROCESS_MEMORY_INFO_TRANSACTION 
        //Begin case KILL_APPLICATION_PROCESS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String processName;
            processName = data.readString();
            int uid;
            uid = data.readInt();
            killApplicationProcess(processName, uid);
            reply.writeNoException();
        } //End block
        //End case KILL_APPLICATION_PROCESS_TRANSACTION 
        //Begin case OVERRIDE_PENDING_TRANSITION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            String packageName;
            packageName = data.readString();
            int enterAnim;
            enterAnim = data.readInt();
            int exitAnim;
            exitAnim = data.readInt();
            overridePendingTransition(token, packageName, enterAnim, exitAnim);
            reply.writeNoException();
        } //End block
        //End case OVERRIDE_PENDING_TRANSITION_TRANSACTION 
        //Begin case IS_USER_A_MONKEY_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean areThey;
            areThey = isUserAMonkey();
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
            IBinder token;
            token = data.readStrongBinder();
            boolean isit;
            isit = isImmersive(token);
            reply.writeNoException();
            reply.writeInt(isit ? 1 : 0);
        } //End block
        //End case IS_IMMERSIVE_TRANSACTION 
        //Begin case SET_IMMERSIVE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            boolean imm;
            imm = data.readInt() == 1;
            setImmersive(token, imm);
            reply.writeNoException();
        } //End block
        //End case SET_IMMERSIVE_TRANSACTION 
        //Begin case IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean isit;
            isit = isTopActivityImmersive();
            reply.writeNoException();
            reply.writeInt(isit ? 1 : 0);
        } //End block
        //End case IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION 
        //Begin case CRASH_APPLICATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int uid;
            uid = data.readInt();
            int initialPid;
            initialPid = data.readInt();
            String packageName;
            packageName = data.readString();
            String message;
            message = data.readString();
            crashApplication(uid, initialPid, packageName, message);
            reply.writeNoException();
        } //End block
        //End case CRASH_APPLICATION_TRANSACTION 
        //Begin case GET_PROVIDER_MIME_TYPE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri;
            uri = Uri.CREATOR.createFromParcel(data);
            String type;
            type = getProviderMimeType(uri);
            reply.writeNoException();
            reply.writeString(type);
        } //End block
        //End case GET_PROVIDER_MIME_TYPE_TRANSACTION 
        //Begin case NEW_URI_PERMISSION_OWNER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String name;
            name = data.readString();
            IBinder perm;
            perm = newUriPermissionOwner(name);
            reply.writeNoException();
            reply.writeStrongBinder(perm);
        } //End block
        //End case NEW_URI_PERMISSION_OWNER_TRANSACTION 
        //Begin case GRANT_URI_PERMISSION_FROM_OWNER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder owner;
            owner = data.readStrongBinder();
            int fromUid;
            fromUid = data.readInt();
            String targetPkg;
            targetPkg = data.readString();
            Uri uri;
            uri = Uri.CREATOR.createFromParcel(data);
            int mode;
            mode = data.readInt();
            grantUriPermissionFromOwner(owner, fromUid, targetPkg, uri, mode);
            reply.writeNoException();
        } //End block
        //End case GRANT_URI_PERMISSION_FROM_OWNER_TRANSACTION 
        //Begin case REVOKE_URI_PERMISSION_FROM_OWNER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder owner;
            owner = data.readStrongBinder();
            Uri uri;
            uri = null;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_1214276065 = (data.readInt() != 0);
                {
                    Uri.CREATOR.createFromParcel(data);
                } //End block
            } //End collapsed parenthetic
            int mode;
            mode = data.readInt();
            revokeUriPermissionFromOwner(owner, uri, mode);
            reply.writeNoException();
        } //End block
        //End case REVOKE_URI_PERMISSION_FROM_OWNER_TRANSACTION 
        //Begin case CHECK_GRANT_URI_PERMISSION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int callingUid;
            callingUid = data.readInt();
            String targetPkg;
            targetPkg = data.readString();
            Uri uri;
            uri = Uri.CREATOR.createFromParcel(data);
            int modeFlags;
            modeFlags = data.readInt();
            int res;
            res = checkGrantUriPermission(callingUid, targetPkg, uri, modeFlags);
            reply.writeNoException();
            reply.writeInt(res);
        } //End block
        //End case CHECK_GRANT_URI_PERMISSION_TRANSACTION 
        //Begin case DUMP_HEAP_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String process;
            process = data.readString();
            boolean managed;
            managed = data.readInt() != 0;
            String path;
            path = data.readString();
            ParcelFileDescriptor fd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1670799725 = (data.readInt() != 0);
            fd = data.readFileDescriptor();
            fd = null;
            boolean res;
            res = dumpHeap(process, managed, path, fd);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case DUMP_HEAP_TRANSACTION 
        //Begin case START_ACTIVITIES_IN_PACKAGE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int uid;
            uid = data.readInt();
            Intent[] intents;
            intents = data.createTypedArray(Intent.CREATOR);
            String[] resolvedTypes;
            resolvedTypes = data.createStringArray();
            IBinder resultTo;
            resultTo = data.readStrongBinder();
            int result;
            result = startActivitiesInPackage(uid, intents, resolvedTypes, resultTo);
            reply.writeNoException();
            reply.writeInt(result);
        } //End block
        //End case START_ACTIVITIES_IN_PACKAGE_TRANSACTION 
        //Begin case START_ACTIVITIES_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            IApplicationThread app;
            app = ApplicationThreadNative.asInterface(b);
            Intent[] intents;
            intents = data.createTypedArray(Intent.CREATOR);
            String[] resolvedTypes;
            resolvedTypes = data.createStringArray();
            IBinder resultTo;
            resultTo = data.readStrongBinder();
            int result;
            result = startActivities(app, intents, resolvedTypes, resultTo);
            reply.writeNoException();
            reply.writeInt(result);
        } //End block
        //End case START_ACTIVITIES_TRANSACTION 
        //Begin case GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int mode;
            mode = getFrontActivityScreenCompatMode();
            reply.writeNoException();
            reply.writeInt(mode);
        } //End block
        //End case GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION 
        //Begin case SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int mode;
            mode = data.readInt();
            setFrontActivityScreenCompatMode(mode);
            reply.writeNoException();
            reply.writeInt(mode);
        } //End block
        //End case SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION 
        //Begin case GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg;
            pkg = data.readString();
            int mode;
            mode = getPackageScreenCompatMode(pkg);
            reply.writeNoException();
            reply.writeInt(mode);
        } //End block
        //End case GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION 
        //Begin case SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg;
            pkg = data.readString();
            int mode;
            mode = data.readInt();
            setPackageScreenCompatMode(pkg, mode);
            reply.writeNoException();
        } //End block
        //End case SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION 
        //Begin case SWITCH_USER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int userid;
            userid = data.readInt();
            boolean result;
            result = switchUser(userid);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
        } //End block
        //End case SWITCH_USER_TRANSACTION 
        //Begin case REMOVE_SUB_TASK_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int taskId;
            taskId = data.readInt();
            int subTaskIndex;
            subTaskIndex = data.readInt();
            boolean result;
            result = removeSubTask(taskId, subTaskIndex);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
        } //End block
        //End case REMOVE_SUB_TASK_TRANSACTION 
        //Begin case REMOVE_TASK_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int taskId;
            taskId = data.readInt();
            int fl;
            fl = data.readInt();
            boolean result;
            result = removeTask(taskId, fl);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
        } //End block
        //End case REMOVE_TASK_TRANSACTION 
        //Begin case REGISTER_PROCESS_OBSERVER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IProcessObserver observer;
            observer = IProcessObserver.Stub.asInterface(
                    data.readStrongBinder());
            registerProcessObserver(observer);
        } //End block
        //End case REGISTER_PROCESS_OBSERVER_TRANSACTION 
        //Begin case UNREGISTER_PROCESS_OBSERVER_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IProcessObserver observer;
            observer = IProcessObserver.Stub.asInterface(
                    data.readStrongBinder());
            unregisterProcessObserver(observer);
        } //End block
        //End case UNREGISTER_PROCESS_OBSERVER_TRANSACTION 
        //Begin case GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg;
            pkg = data.readString();
            boolean ask;
            ask = getPackageAskScreenCompat(pkg);
            reply.writeNoException();
            reply.writeInt(ask ? 1 : 0);
        } //End block
        //End case GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION 
        //Begin case SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg;
            pkg = data.readString();
            boolean ask;
            ask = data.readInt() != 0;
            setPackageAskScreenCompat(pkg, ask);
            reply.writeNoException();
        } //End block
        //End case SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION 
        //Begin case IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r;
            r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            boolean res;
            res = isIntentSenderTargetedToPackage(r);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
        } //End block
        //End case IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION 
        //Begin case UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config;
            config = Configuration.CREATOR.createFromParcel(data);
            updatePersistentConfiguration(config);
            reply.writeNoException();
        } //End block
        //End case UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION 
        //Begin case GET_PROCESS_PSS_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids;
            pids = data.createIntArray();
            long[] pss;
            pss = getProcessPss(pids);
            reply.writeNoException();
            reply.writeLongArray(pss);
        } //End block
        //End case GET_PROCESS_PSS_TRANSACTION 
        //Begin case SHOW_BOOT_MESSAGE_TRANSACTION 
        {
            data.enforceInterface(IActivityManager.descriptor);
            CharSequence msg;
            msg = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            boolean always;
            always = data.readInt() != 0;
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
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_1942433189 = (super.onTransact(code, data, reply, flags));
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1559041017 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1559041017;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.333 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "36957A76F55E9C54E8FA8D46BAA3648F")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_2142657745 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2142657745 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2142657745.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2142657745;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.334 -0400", hash_original_field = "7E28963ADB1F0EB3A0EF33BADF10C8B6", hash_generated_field = "94B5404A722EA8FD9D4D6FFD2B91074A")

    static boolean sSystemReady = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.363 -0400", hash_original_field = "1DDB5338697F4F4D1F4EBEBCBCA04F09", hash_generated_field = "84D57A3AD03D07938F8E864DEFF8E135")

    private static Singleton<IActivityManager> gDefault = new Singleton<IActivityManager>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.362 -0400", hash_original_method = "DB2B8F5A0363FA0CE3E5AA87CCE94A22", hash_generated_method = "B9CA44F48BAEA7948923E7E0134F6F21")
        protected IActivityManager create() {
            IActivityManager varB4EAC82CA7396A68D541C85D26508E83_1344038205 = null; //Variable for return #1
            IBinder b;
            b = ServiceManager.getService("activity");
            IActivityManager am;
            am = asInterface(b);
            varB4EAC82CA7396A68D541C85D26508E83_1344038205 = am;
            varB4EAC82CA7396A68D541C85D26508E83_1344038205.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1344038205;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.378 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.385 -0400", hash_original_method = "3287CA7C2EB4AADDF2EFFF2704D2BE9E", hash_generated_method = "45B8F41C62FE771FA42BECD8E8563D23")
    public  ActivityManagerProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.402 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "D9C798EC3606CC00CD32F7336A377784")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1733642630 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1733642630 = mRemote;
        varB4EAC82CA7396A68D541C85D26508E83_1733642630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1733642630;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.429 -0400", hash_original_method = "ECBE4259B26F016D18C1CACD48E02238", hash_generated_method = "A07680DEC93908A9607A8D51726328E2")
    public int startActivity(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, String profileFile, ParcelFileDescriptor profileFd,
            boolean autoStopProfiler) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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
        int result;
        result = reply.readInt();
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434209942 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434209942;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.468 -0400", hash_original_method = "BF42E410BABF1DD283EC1102C9637003", hash_generated_method = "DCA6CBEDFF087BC8218744579760AB1F")
    public WaitResult startActivityAndWait(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, String profileFile, ParcelFileDescriptor profileFd,
            boolean autoStopProfiler) throws RemoteException {
        WaitResult varB4EAC82CA7396A68D541C85D26508E83_920976751 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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
        WaitResult result;
        result = WaitResult.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_920976751 = result;
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
        varB4EAC82CA7396A68D541C85D26508E83_920976751.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_920976751;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.507 -0400", hash_original_method = "47F7B475943E725D61EF4FCECF2C263D", hash_generated_method = "3631083ECB7FE36D9D500DBD4EA172DA")
    public int startActivityWithConfig(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, Configuration config) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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
        int result;
        result = reply.readInt();
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230838715 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230838715;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.539 -0400", hash_original_method = "FD56EAF7591CCE02A2449EB3C30AEF02", hash_generated_method = "3DB2ED113DC82ECB360ED9B224A5B984")
    public int startActivityIntentSender(IApplicationThread caller,
            IntentSender intent, Intent fillInIntent, String resolvedType,
            IBinder resultTo, String resultWho, int requestCode,
            int flagsMask, int flagsValues) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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
        int result;
        result = reply.readInt();
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801321511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801321511;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.559 -0400", hash_original_method = "A532370FCCB6C359BF27FA22D92F73F5", hash_generated_method = "B57E484757D5B53242F62ED78A05410D")
    public boolean startNextMatchingActivity(IBinder callingActivity,
            Intent intent) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(callingActivity);
        intent.writeToParcel(data, 0);
        mRemote.transact(START_NEXT_MATCHING_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        int result;
        result = reply.readInt();
        reply.recycle();
        data.recycle();
        addTaint(callingActivity.getTaint());
        addTaint(intent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368065393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368065393;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.583 -0400", hash_original_method = "91E82D39E0DA0BAF3D9668B58FD8BE2D", hash_generated_method = "7B43646596B84FA21B14E621714F9FE5")
    public boolean finishActivity(IBinder token, int resultCode, Intent resultData) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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
        boolean res;
        res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        addTaint(resultCode);
        addTaint(resultData.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776657694 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776657694;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.604 -0400", hash_original_method = "352728C633440E8BBFDE1A24B12C26C6", hash_generated_method = "DC186F718591A27CF77DA477048F86FB")
    public void finishSubActivity(IBinder token, String resultWho, int requestCode) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.624 -0400", hash_original_method = "03769BB85CE515FA0FB5B3DCD0709D8A", hash_generated_method = "54CD8A52901D18800C89F410F517EA9E")
    public boolean willActivityBeVisible(IBinder token) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(WILL_ACTIVITY_BE_VISIBLE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226378734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226378734;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.651 -0400", hash_original_method = "D0EC9750E66DC0864B7AF9A5D43ED043", hash_generated_method = "8D77CD39A54E9821951ABC49B01BA045")
    public Intent registerReceiver(IApplicationThread caller, String packageName,
            IIntentReceiver receiver,
            IntentFilter filter, String perm) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_1494625085 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeString(packageName);
        data.writeStrongBinder(receiver != null ? receiver.asBinder() : null);
        filter.writeToParcel(data, 0);
        data.writeString(perm);
        mRemote.transact(REGISTER_RECEIVER_TRANSACTION, data, reply, 0);
        reply.readException();
        Intent intent;
        intent = null;
        int haveIntent;
        haveIntent = reply.readInt();
        {
            intent = Intent.CREATOR.createFromParcel(reply);
        } //End block
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1494625085 = intent;
        addTaint(caller.getTaint());
        addTaint(packageName.getTaint());
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(perm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1494625085.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1494625085;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.663 -0400", hash_original_method = "CF62E9563222E9365AE1815E546E05AA", hash_generated_method = "E98E195683A35A2770F891718106A316")
    public void unregisterReceiver(IIntentReceiver receiver) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.691 -0400", hash_original_method = "189D2A1B1A14BF35BFCC0BB8AD6C1CE5", hash_generated_method = "BA84FB6407B0384B5D117C079C853EA6")
    public int broadcastIntent(IApplicationThread caller,
            Intent intent, String resolvedType,  IIntentReceiver resultTo,
            int resultCode, String resultData, Bundle map,
            String requiredPermission, boolean serialized,
            boolean sticky) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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
        int res;
        res = reply.readInt();
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_321402882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_321402882;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.707 -0400", hash_original_method = "84F4ECE33F63E245917246490F7877AA", hash_generated_method = "B89A1F05E2C96085AEFBAC63E7BB8CF3")
    public void unbroadcastIntent(IApplicationThread caller, Intent intent) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.310 -0400", hash_original_method = "8BFF18A0F9A8EDDD76A319C280B21CDC", hash_generated_method = "AE98E87FAB593A72813EE352D2156665")
    public void finishReceiver(IBinder who, int resultCode, String resultData, Bundle map, boolean abortBroadcast) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.323 -0400", hash_original_method = "1E67E239E5F2A2540F1E032AB272605E", hash_generated_method = "A29CAA94EF8064DA8BDAD6656C5B78A8")
    public void attachApplication(IApplicationThread app) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.361 -0400", hash_original_method = "BC9E49082B5DC06C707641FC7F3E31F5", hash_generated_method = "36CBC767D27F71910C56C4A4F7A15C17")
    public void activityIdle(IBinder token, Configuration config, boolean stopProfiling) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.387 -0400", hash_original_method = "4914FFC78B966DEBED0BDBFF9D70FB17", hash_generated_method = "26D4F3F62C20925DCE06F707B1843529")
    public void activityPaused(IBinder token) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.404 -0400", hash_original_method = "F5DE3AC45B6CCF74477AF45EB0878099", hash_generated_method = "9A38013C22A33FEC657F60E46A302686")
    public void activityStopped(IBinder token, Bundle state,
            Bitmap thumbnail, CharSequence description) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.419 -0400", hash_original_method = "CA8224B1DA5730B462FB3F604509C1DB", hash_generated_method = "6B84B89B02604FFF439C18CAC15E5C63")
    public void activitySlept(IBinder token) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.443 -0400", hash_original_method = "9A100D49A0D535BB686DAA00CAC541FF", hash_generated_method = "D6150C2D6E218DCAF9DAC4EA052D142F")
    public void activityDestroyed(IBinder token) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.451 -0400", hash_original_method = "7637EF2082F6942F953796EFCEAA3730", hash_generated_method = "9717C70BE2A593BC32B621F71BDB4F28")
    public String getCallingPackage(IBinder token) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_605944950 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_CALLING_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        String res;
        res = reply.readString();
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_605944950 = res;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_605944950.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_605944950;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.486 -0400", hash_original_method = "0E9D91A20FCD3BCFB3517DB475147FAB", hash_generated_method = "6EC69A8D3BF41334F8E22F00D6339AF1")
    public ComponentName getCallingActivity(IBinder token) throws RemoteException {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1333373773 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_CALLING_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        ComponentName res;
        res = ComponentName.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1333373773 = res;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1333373773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1333373773;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.518 -0400", hash_original_method = "FAA1C4AE039868246AED533CDCA15CD7", hash_generated_method = "31E0C8554F9E357AFE907C3868E5B057")
    public List getTasks(int maxNum, int flags,
            IThumbnailReceiver receiver) throws RemoteException {
        List varB4EAC82CA7396A68D541C85D26508E83_308807835 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(maxNum);
        data.writeInt(flags);
        data.writeStrongBinder(receiver != null ? receiver.asBinder() : null);
        mRemote.transact(GET_TASKS_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList list;
        list = null;
        int N;
        N = reply.readInt();
        {
            list = new ArrayList();
            {
                ActivityManager.RunningTaskInfo info;
                info = ActivityManager.RunningTaskInfo.CREATOR
                        .createFromParcel(reply);
                list.add(info);
            } //End block
        } //End block
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_308807835 = list;
        addTaint(maxNum);
        addTaint(flags);
        addTaint(receiver.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_308807835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_308807835;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.529 -0400", hash_original_method = "9D3E8FF17F102376D7C7BE9D34CE4F93", hash_generated_method = "C7DFF46CE61DCBCE5A9E074C25EBC0E7")
    public List<ActivityManager.RecentTaskInfo> getRecentTasks(int maxNum,
            int flags) throws RemoteException {
        List<ActivityManager.RecentTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_35601096 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(maxNum);
        data.writeInt(flags);
        mRemote.transact(GET_RECENT_TASKS_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.RecentTaskInfo> list;
        list = reply.createTypedArrayList(ActivityManager.RecentTaskInfo.CREATOR);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_35601096 = list;
        addTaint(maxNum);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_35601096.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_35601096;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.555 -0400", hash_original_method = "10D095A12B52FE928E4AEC7C3F42A832", hash_generated_method = "4B0863E06C6C2EC461A79571A8CF595C")
    public ActivityManager.TaskThumbnails getTaskThumbnails(int id) throws RemoteException {
        ActivityManager.TaskThumbnails varB4EAC82CA7396A68D541C85D26508E83_259618314 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(id);
        mRemote.transact(GET_TASK_THUMBNAILS_TRANSACTION, data, reply, 0);
        reply.readException();
        ActivityManager.TaskThumbnails bm;
        bm = null;
        {
            boolean varB04A284F06B56929F38634A7F4C6A0D7_711026725 = (reply.readInt() != 0);
            {
                bm = ActivityManager.TaskThumbnails.CREATOR.createFromParcel(reply);
            } //End block
        } //End collapsed parenthetic
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_259618314 = bm;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_259618314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_259618314;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.586 -0400", hash_original_method = "7671DD1471581027B2C414BE0E3CE4A6", hash_generated_method = "E4771F1554055A1C54BC89FA675D29B6")
    public List getServices(int maxNum, int flags) throws RemoteException {
        List varB4EAC82CA7396A68D541C85D26508E83_1984671836 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(maxNum);
        data.writeInt(flags);
        mRemote.transact(GET_SERVICES_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList list;
        list = null;
        int N;
        N = reply.readInt();
        {
            list = new ArrayList();
            {
                ActivityManager.RunningServiceInfo info;
                info = ActivityManager.RunningServiceInfo.CREATOR
                        .createFromParcel(reply);
                list.add(info);
            } //End block
        } //End block
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1984671836 = list;
        addTaint(maxNum);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1984671836.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1984671836;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.600 -0400", hash_original_method = "2AE453A6460D5AF368C9AC4C4862314B", hash_generated_method = "D1990356708BFDC852A4CA1918203376")
    public List<ActivityManager.ProcessErrorStateInfo> getProcessesInErrorState() throws RemoteException {
        List<ActivityManager.ProcessErrorStateInfo> varB4EAC82CA7396A68D541C85D26508E83_258450669 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_PROCESSES_IN_ERROR_STATE_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.ProcessErrorStateInfo> list;
        list = reply.createTypedArrayList(ActivityManager.ProcessErrorStateInfo.CREATOR);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_258450669 = list;
        varB4EAC82CA7396A68D541C85D26508E83_258450669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_258450669;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.621 -0400", hash_original_method = "8E45CD57BE18A4B76C3A3E0DA22BC8B7", hash_generated_method = "2E6BF6B59D69BF06B7CB067C900198D8")
    public List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() throws RemoteException {
        List<ActivityManager.RunningAppProcessInfo> varB4EAC82CA7396A68D541C85D26508E83_806227525 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_RUNNING_APP_PROCESSES_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.RunningAppProcessInfo> list;
        list = reply.createTypedArrayList(ActivityManager.RunningAppProcessInfo.CREATOR);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_806227525 = list;
        varB4EAC82CA7396A68D541C85D26508E83_806227525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_806227525;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.664 -0400", hash_original_method = "2FAC851B003A84469F94E88A81DA29C3", hash_generated_method = "4D21BC6E2FDA53555945298F31169AC9")
    public List<ApplicationInfo> getRunningExternalApplications() throws RemoteException {
        List<ApplicationInfo> varB4EAC82CA7396A68D541C85D26508E83_1480521325 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ApplicationInfo> list;
        list = reply.createTypedArrayList(ApplicationInfo.CREATOR);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1480521325 = list;
        varB4EAC82CA7396A68D541C85D26508E83_1480521325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1480521325;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.670 -0400", hash_original_method = "DABF13B8F45F6A065880490CD0DBD1A0", hash_generated_method = "1308F25D2EC1E1029F73A95A69F3EF0D")
    public void moveTaskToFront(int task, int flags) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.684 -0400", hash_original_method = "7FFB6E49EA553237E0A3F53A2CDFD87F", hash_generated_method = "690206BAD2C5DB13B975AC8F68880244")
    public void moveTaskToBack(int task) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.700 -0400", hash_original_method = "7F4F39C4D7AB58BCB5DB152705A9F80A", hash_generated_method = "4F8B81971DCD30690075AE3C198D7013")
    public boolean moveActivityTaskToBack(IBinder token, boolean nonRoot) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(nonRoot ? 1 : 0);
        mRemote.transact(MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        addTaint(nonRoot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1800294148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1800294148;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.722 -0400", hash_original_method = "48BD6DC2300FE39DD3A4B34C3DD91993", hash_generated_method = "62E8CAD6942321207F0D032894737215")
    public void moveTaskBackwards(int task) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.732 -0400", hash_original_method = "3FABC29A3C68690EBF6B4F44EE4A5D23", hash_generated_method = "8CA04390B38D0F4B20E25EF3941F190D")
    public int getTaskForActivity(IBinder token, boolean onlyRoot) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(onlyRoot ? 1 : 0);
        mRemote.transact(GET_TASK_FOR_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        int res;
        res = reply.readInt();
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        addTaint(onlyRoot);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745728626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745728626;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.754 -0400", hash_original_method = "AF696C3AA9BD79AC1F2D6780E820F3FA", hash_generated_method = "69BBEF6C785F31F0779854A2C19CDB8A")
    public void finishOtherInstances(IBinder token, ComponentName className) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.777 -0400", hash_original_method = "4B3E31ABB8C007E1B3828F729DFD9393", hash_generated_method = "91291A78C733BA9F5D9320F1EB1BFD81")
    public void reportThumbnail(IBinder token,
                                Bitmap thumbnail, CharSequence description) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.814 -0400", hash_original_method = "EC6CF87E25124312A62325C5F062E996", hash_generated_method = "1A5079B748907BE3E7EED1A02BCAA464")
    public ContentProviderHolder getContentProvider(IApplicationThread caller,
                                                    String name) throws RemoteException {
        ContentProviderHolder varB4EAC82CA7396A68D541C85D26508E83_1594357373 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeString(name);
        mRemote.transact(GET_CONTENT_PROVIDER_TRANSACTION, data, reply, 0);
        reply.readException();
        int res;
        res = reply.readInt();
        ContentProviderHolder cph;
        cph = null;
        {
            cph = ContentProviderHolder.CREATOR.createFromParcel(reply);
        } //End block
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1594357373 = cph;
        addTaint(caller.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1594357373.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1594357373;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.818 -0400", hash_original_method = "9C5D73DEFA4B6B21F8A4E01DC5E46521", hash_generated_method = "DCCE44D9AD901F32E1112C227A1F2648")
    public void publishContentProviders(IApplicationThread caller,
                                        List<ContentProviderHolder> providers) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.841 -0400", hash_original_method = "6E983079D2A10BB8E3DF4E66B032EE6D", hash_generated_method = "35E8832CBE918D9E7E6B0449FE061B05")
    public void removeContentProvider(IApplicationThread caller,
            String name) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.866 -0400", hash_original_method = "E5355EA6A0F8270964E816C69524096C", hash_generated_method = "D5B347F80615ED962037D7429D443764")
    public PendingIntent getRunningServiceControlPanel(ComponentName service) throws RemoteException {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_1650784766 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        service.writeToParcel(data, 0);
        mRemote.transact(GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION, data, reply, 0);
        reply.readException();
        PendingIntent res;
        res = PendingIntent.readPendingIntentOrNullFromParcel(reply);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1650784766 = res;
        addTaint(service.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1650784766.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1650784766;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.951 -0400", hash_original_method = "A683CF3BA039B3B97AA6ADC23E6FBDCC", hash_generated_method = "9B8B5D52176D5E243757434668730160")
    public ComponentName startService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_263066503 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        service.writeToParcel(data, 0);
        data.writeString(resolvedType);
        mRemote.transact(START_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        ComponentName res;
        res = ComponentName.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_263066503 = res;
        addTaint(caller.getTaint());
        addTaint(service.getTaint());
        addTaint(resolvedType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_263066503.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_263066503;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.958 -0400", hash_original_method = "B5D9E3A4F6ABA893303F2F02B64751B8", hash_generated_method = "87D697558E10D6C25D51F23E2C2A5373")
    public int stopService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        service.writeToParcel(data, 0);
        data.writeString(resolvedType);
        mRemote.transact(STOP_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        int res;
        res = reply.readInt();
        reply.recycle();
        data.recycle();
        addTaint(caller.getTaint());
        addTaint(service.getTaint());
        addTaint(resolvedType.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_468763787 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_468763787;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.964 -0400", hash_original_method = "DB1BCCF2CB5E2532E24072B1F607F963", hash_generated_method = "D0A56F4E8367427CB17A16CD56086E73")
    public boolean stopServiceToken(ComponentName className, IBinder token,
            int startId) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        ComponentName.writeToParcel(className, data);
        data.writeStrongBinder(token);
        data.writeInt(startId);
        mRemote.transact(STOP_SERVICE_TOKEN_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        addTaint(className.getTaint());
        addTaint(token.getTaint());
        addTaint(startId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1906210544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1906210544;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.010 -0400", hash_original_method = "9DE0D26C134349F3DA011E11517F3FF5", hash_generated_method = "98B52F4F622888376A78AB9FF18FAC2A")
    public void setServiceForeground(ComponentName className, IBinder token,
            int id, Notification notification, boolean removeNotification) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.035 -0400", hash_original_method = "A1E6D6F237E88697017FA79FBE451840", hash_generated_method = "326CBCC5701CFF3435C241994E424061")
    public int bindService(IApplicationThread caller, IBinder token,
            Intent service, String resolvedType, IServiceConnection connection,
            int flags) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeStrongBinder(token);
        service.writeToParcel(data, 0);
        data.writeString(resolvedType);
        data.writeStrongBinder(connection.asBinder());
        data.writeInt(flags);
        mRemote.transact(BIND_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        int res;
        res = reply.readInt();
        data.recycle();
        reply.recycle();
        addTaint(caller.getTaint());
        addTaint(token.getTaint());
        addTaint(service.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(connection.getTaint());
        addTaint(flags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412772078 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412772078;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.057 -0400", hash_original_method = "E0BD37EB96539E724DE863D335954DC9", hash_generated_method = "FF0F0CE064E74A89470BAFE77A9A26B0")
    public boolean unbindService(IServiceConnection connection) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(connection.asBinder());
        mRemote.transact(UNBIND_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        addTaint(connection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745826150 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745826150;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.077 -0400", hash_original_method = "87A207496B270585D5EEA34C1AF57170", hash_generated_method = "3936150EE4A7A38A2F119D7AC5140F6B")
    public void publishService(IBinder token,
            Intent intent, IBinder service) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.095 -0400", hash_original_method = "3796516624A8D493E471933ECF7A3CD3", hash_generated_method = "4B6AF98EC654ECDE92C9EF335E201535")
    public void unbindFinished(IBinder token, Intent intent, boolean doRebind) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.114 -0400", hash_original_method = "1CB80C62A00C622E35F1B57A132292E9", hash_generated_method = "F66EE5470C2C28C913C96D5F9977AD5C")
    public void serviceDoneExecuting(IBinder token, int type, int startId,
            int res) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.130 -0400", hash_original_method = "BEF476EE5F43517187661CDC39F2A448", hash_generated_method = "3E2A2923B6EA7F9EC3DF7BE9E1238BB6")
    public IBinder peekService(Intent service, String resolvedType) throws RemoteException {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_789591187 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        service.writeToParcel(data, 0);
        data.writeString(resolvedType);
        mRemote.transact(PEEK_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        IBinder binder;
        binder = reply.readStrongBinder();
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_789591187 = binder;
        addTaint(service.getTaint());
        addTaint(resolvedType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_789591187.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_789591187;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.162 -0400", hash_original_method = "7AACC08C389BEE0061373162626F356D", hash_generated_method = "FED5DF22ADED74E00C39702F727A7B1B")
    public boolean bindBackupAgent(ApplicationInfo app, int backupRestoreMode) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        app.writeToParcel(data, 0);
        data.writeInt(backupRestoreMode);
        mRemote.transact(START_BACKUP_AGENT_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean success;
        success = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(app.getTaint());
        addTaint(backupRestoreMode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1087949522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1087949522;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.165 -0400", hash_original_method = "ADE4561AB0FC3828104C329F05A9B88C", hash_generated_method = "FA2848705191825AE13EE5BD0B8D2FE9")
    public void backupAgentCreated(String packageName, IBinder agent) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.195 -0400", hash_original_method = "80BB0DB939AA2A14DC79CE879293739F", hash_generated_method = "709BBA6DB738230C144424C42B6B3FED")
    public void unbindBackupAgent(ApplicationInfo app) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.221 -0400", hash_original_method = "7977DF3866173BBD9227641CB70C5B9A", hash_generated_method = "382F8F5233E88E005CDBF3CFABC65DE7")
    public boolean startInstrumentation(ComponentName className, String profileFile,
            int flags, Bundle arguments, IInstrumentationWatcher watcher) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        ComponentName.writeToParcel(className, data);
        data.writeString(profileFile);
        data.writeInt(flags);
        data.writeBundle(arguments);
        data.writeStrongBinder(watcher != null ? watcher.asBinder() : null);
        mRemote.transact(START_INSTRUMENTATION_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(className.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(flags);
        addTaint(arguments.getTaint());
        addTaint(watcher.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544755057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544755057;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.238 -0400", hash_original_method = "D76B5F1B397FC7028B59F12CA3604783", hash_generated_method = "986B562748300B55D057F8EE880E8F20")
    public void finishInstrumentation(IApplicationThread target,
            int resultCode, Bundle results) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.250 -0400", hash_original_method = "E824FA9DB2D76671E24682EC782F4756", hash_generated_method = "F0742B92377D4834D8B969A8360370A3")
    public Configuration getConfiguration() throws RemoteException {
        Configuration varB4EAC82CA7396A68D541C85D26508E83_1714211917 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        Configuration res;
        res = Configuration.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1714211917 = res;
        varB4EAC82CA7396A68D541C85D26508E83_1714211917.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1714211917;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.275 -0400", hash_original_method = "76911A2717FEEEC7D6B4E93DC7F2427C", hash_generated_method = "99357AABD4C70E4E206484A40B6C6E2E")
    public void updateConfiguration(Configuration values) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.286 -0400", hash_original_method = "65FC5D17EF9FF3BF1BFFDA9CCA9A4BE1", hash_generated_method = "2793F3B1D44F43DD0DD8C5C3F4E955B3")
    public void setRequestedOrientation(IBinder token, int requestedOrientation) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.309 -0400", hash_original_method = "505D3FD7966F547E2BAA16E1C1C5F05B", hash_generated_method = "C0843E31FCE5095E4A5BFB4416397AF9")
    public int getRequestedOrientation(IBinder token) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_REQUESTED_ORIENTATION_TRANSACTION, data, reply, 0);
        reply.readException();
        int res;
        res = reply.readInt();
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824446850 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824446850;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.324 -0400", hash_original_method = "BCB55F79D75B3B83E49A75043EE249A9", hash_generated_method = "4C292560C82CA4E9E9FB791E6D817F50")
    public ComponentName getActivityClassForToken(IBinder token) throws RemoteException {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_880704088 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION, data, reply, 0);
        reply.readException();
        ComponentName res;
        res = ComponentName.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_880704088 = res;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_880704088.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_880704088;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.339 -0400", hash_original_method = "9BAE752D062408101ED2F689CF20DDD1", hash_generated_method = "9706976D8CD1080D4863F1E5C79A88C7")
    public String getPackageForToken(IBinder token) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_781037326 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_PACKAGE_FOR_TOKEN_TRANSACTION, data, reply, 0);
        reply.readException();
        String res;
        res = reply.readString();
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_781037326 = res;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_781037326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_781037326;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.437 -0400", hash_original_method = "AE56AE3D6914251F9FFFA7E33C698EB6", hash_generated_method = "EF6AC749D99BA4E2CA556444A765FE9F")
    public IIntentSender getIntentSender(int type,
            String packageName, IBinder token, String resultWho,
            int requestCode, Intent[] intents, String[] resolvedTypes, int flags) throws RemoteException {
        IIntentSender varB4EAC82CA7396A68D541C85D26508E83_1014977823 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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
        IIntentSender res;
        res = IIntentSender.Stub.asInterface(
            reply.readStrongBinder());
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1014977823 = res;
        addTaint(type);
        addTaint(packageName.getTaint());
        addTaint(token.getTaint());
        addTaint(resultWho.getTaint());
        addTaint(requestCode);
        addTaint(intents[0].getTaint());
        addTaint(resolvedTypes[0].getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1014977823.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1014977823;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.447 -0400", hash_original_method = "D459AA1ADAE84FC2B7BB3BA73C047FDB", hash_generated_method = "E9E33F8D9ECC6CBBC7BE852B2F3FD742")
    public void cancelIntentSender(IIntentSender sender) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.480 -0400", hash_original_method = "1993496C4F183452017D412A9B9C5C29", hash_generated_method = "437CB7CF3C2BF08C55CA4EA2EC7E7C7A")
    public String getPackageForIntentSender(IIntentSender sender) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_681492370 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(sender.asBinder());
        mRemote.transact(GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION, data, reply, 0);
        reply.readException();
        String res;
        res = reply.readString();
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_681492370 = res;
        addTaint(sender.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_681492370.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_681492370;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.494 -0400", hash_original_method = "92B622DC0CB7ED23BB116E8953A0A90A", hash_generated_method = "865D4C2AF3764B5797D07610237969C4")
    public void setProcessLimit(int max) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.518 -0400", hash_original_method = "4FA932EFF1C9BAC6AA973FE979D6B75F", hash_generated_method = "35A653D56841A23E73F1EA21075C6567")
    public int getProcessLimit() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_PROCESS_LIMIT_TRANSACTION, data, reply, 0);
        reply.readException();
        int res;
        res = reply.readInt();
        data.recycle();
        reply.recycle();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858439385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858439385;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.562 -0400", hash_original_method = "16F5E36D0F576E8CD2EC3F6B33B5169D", hash_generated_method = "AF506ACBCF45B123483DA50C4843A0EF")
    public void setProcessForeground(IBinder token, int pid,
            boolean isForeground) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.586 -0400", hash_original_method = "A50C503DC3495EB643680A38372DD1F5", hash_generated_method = "0B43A4B519F5AB8DC4059005EBA59443")
    public int checkPermission(String permission, int pid, int uid) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(permission);
        data.writeInt(pid);
        data.writeInt(uid);
        mRemote.transact(CHECK_PERMISSION_TRANSACTION, data, reply, 0);
        reply.readException();
        int res;
        res = reply.readInt();
        data.recycle();
        reply.recycle();
        addTaint(permission.getTaint());
        addTaint(pid);
        addTaint(uid);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1131662487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1131662487;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.608 -0400", hash_original_method = "BE5C38AE92A5EE5CE45944FF93295090", hash_generated_method = "AB9DB8962E138C2FF9FE760377A67E48")
    public boolean clearApplicationUserData(final String packageName,
            final IPackageDataObserver observer) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        data.writeStrongBinder(observer.asBinder());
        mRemote.transact(CLEAR_APP_DATA_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1996263697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1996263697;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.623 -0400", hash_original_method = "FEF4F93E5B02F55707A11B36638BBB59", hash_generated_method = "611A4236EFF804A79583D1261153B845")
    public int checkUriPermission(Uri uri, int pid, int uid, int mode) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        uri.writeToParcel(data, 0);
        data.writeInt(pid);
        data.writeInt(uid);
        data.writeInt(mode);
        mRemote.transact(CHECK_URI_PERMISSION_TRANSACTION, data, reply, 0);
        reply.readException();
        int res;
        res = reply.readInt();
        data.recycle();
        reply.recycle();
        addTaint(uri.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(mode);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050928278 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050928278;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.645 -0400", hash_original_method = "2CEB2CA82A36297F49BF5DB3286E579B", hash_generated_method = "4B1737E14A45B8AC55330D1A6CDD9727")
    public void grantUriPermission(IApplicationThread caller, String targetPkg,
            Uri uri, int mode) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.679 -0400", hash_original_method = "84D534ABCBC85608735C63399D2C9E1E", hash_generated_method = "1854FBCDC1D4D7E2E26FA873062F30DD")
    public void revokeUriPermission(IApplicationThread caller, Uri uri,
            int mode) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.692 -0400", hash_original_method = "7FC96553233904C2463E3D793E528211", hash_generated_method = "908E6D663AF0402C0BD81A08809A43B0")
    public void showWaitingForDebugger(IApplicationThread who, boolean waiting) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.707 -0400", hash_original_method = "40DDB58D1BE7B54E85772ACF1AA60D8F", hash_generated_method = "5F8B3E01427FB7E436ABA4E18D0A778F")
    public void getMemoryInfo(ActivityManager.MemoryInfo outInfo) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.738 -0400", hash_original_method = "805F881D84830966D1AD0B083D69DA9A", hash_generated_method = "42784F3026C0A0D25A2A024B2E27B1F2")
    public void unhandledBack() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.764 -0400", hash_original_method = "1E46E6C9628834765008140B25990D23", hash_generated_method = "B557E8E1D501DB8C62E66E00E8F9CE71")
    public ParcelFileDescriptor openContentUri(Uri uri) throws RemoteException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1388891552 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(OPEN_CONTENT_URI_TRANSACTION, data, reply, 0);
        reply.readException();
        ParcelFileDescriptor pfd;
        pfd = null;
        {
            boolean varB04A284F06B56929F38634A7F4C6A0D7_1664118284 = (reply.readInt() != 0);
            {
                pfd = ParcelFileDescriptor.CREATOR.createFromParcel(reply);
            } //End block
        } //End collapsed parenthetic
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1388891552 = pfd;
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1388891552.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1388891552;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.770 -0400", hash_original_method = "E3BC510BF36E68FD23494212AB6E7B33", hash_generated_method = "FFBC3DEB08C7FC6E579AF592A878016E")
    public void goingToSleep() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.775 -0400", hash_original_method = "CAFF51A84FC631E180A23D0F5290B43F", hash_generated_method = "BE931B7C3EDD7251D16E613C4E055624")
    public void wakingUp() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.789 -0400", hash_original_method = "482C4468B37AD6CEF12EA376A273F16E", hash_generated_method = "C0BBA73E0D4BC960DDD7A61D76C878F8")
    public void setDebugApp(
        String packageName, boolean waitForDebugger, boolean persistent) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.805 -0400", hash_original_method = "DE27B8A416D8E1FF87F079AFA1567A6E", hash_generated_method = "73A26E2D14467452EDA2896A6135F410")
    public void setAlwaysFinish(boolean enabled) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.820 -0400", hash_original_method = "D7DBDAD7386DC1F45D7A9AB12513A49B", hash_generated_method = "324E2A5F86DE0E4E0298F8308BF30FCF")
    public void setActivityController(IActivityController watcher) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.838 -0400", hash_original_method = "FF7EEF7728CACAD7286D113A3CF07513", hash_generated_method = "8BE9FBF4A7C7869BD53D6F6EF7FEFE7F")
    public void enterSafeMode() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(ENTER_SAFE_MODE_TRANSACTION, data, null, 0);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(ENTER_SAFE_MODE_TRANSACTION, data, null, 0);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.841 -0400", hash_original_method = "72F87C80970F6885E4DCD6DA1B2F19E8", hash_generated_method = "BA4E0026FC6E5035A8132BA614803548")
    public void noteWakeupAlarm(IIntentSender sender) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.862 -0400", hash_original_method = "DB2721BD1E4C8F1064AA0461CF2A490B", hash_generated_method = "6422C29A32C3A14FCB642C60410D1737")
    public boolean killPids(int[] pids, String reason, boolean secure) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeIntArray(pids);
        data.writeString(reason);
        data.writeInt(secure ? 1 : 0);
        mRemote.transact(KILL_PIDS_TRANSACTION, data, reply, 0);
        boolean res;
        res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        addTaint(pids[0]);
        addTaint(reason.getTaint());
        addTaint(secure);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_991611932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_991611932;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.881 -0400", hash_original_method = "9964526F9DDC53538E50ED934A9D4009", hash_generated_method = "A179E825BAFF00AE23F48AFC8F2CB048")
    public void startRunning(String pkg, String cls, String action,
            String indata) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.883 -0400", hash_original_method = "6C8B2FE75A3BFFE16EADA916F678A09D", hash_generated_method = "514DC7159F8F4453871FB3CD183F2B41")
    public boolean testIsSystemReady() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1212309216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1212309216;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.903 -0400", hash_original_method = "523AF9597115E332AF2A1F534C49483C", hash_generated_method = "03E39016F4AF7EA4EC110C5FB9C70EEC")
    public void handleApplicationCrash(IBinder app,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.922 -0400", hash_original_method = "84EFC78EC4B379D270C222A7BC31C5F7", hash_generated_method = "1F0803105A3486A87F23EDCF22251537")
    public boolean handleApplicationWtf(IBinder app, String tag,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(app);
        data.writeString(tag);
        crashInfo.writeToParcel(data, 0);
        mRemote.transact(HANDLE_APPLICATION_WTF_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(app.getTaint());
        addTaint(tag.getTaint());
        addTaint(crashInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92950233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92950233;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.926 -0400", hash_original_method = "7AC27E481709B1F0B25AE2BA23B3BECF", hash_generated_method = "9434924E5877F309CEFD9C0917429026")
    public void handleApplicationStrictModeViolation(IBinder app,
            int violationMask,
            StrictMode.ViolationInfo info) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.949 -0400", hash_original_method = "22BD8EFAE7A36DA76D8B0F7F297E970D", hash_generated_method = "EE4986E3D039729E27F951E745884BBA")
    public void signalPersistentProcesses(int sig) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.951 -0400", hash_original_method = "3D80332C8A0FCAFBCE220FADA30302CB", hash_generated_method = "E8AA13A81F7A721BD0E6610F5EA8768C")
    public void killBackgroundProcesses(String packageName) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.969 -0400", hash_original_method = "C7F5D3EA775AD04DD438191F0B4D22C4", hash_generated_method = "FD2D18652BBA0B48AEE79B10FADB04B0")
    public void killAllBackgroundProcesses() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.983 -0400", hash_original_method = "CB4D9E734B2DC6A00C763BA9D15D84CC", hash_generated_method = "5A0972D8545C59E170208753632E0035")
    public void forceStopPackage(String packageName) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.008 -0400", hash_original_method = "9F4AADDAC8F1648FD8C80C6B88BBF25F", hash_generated_method = "7E544104357539C8F832681F6509F88A")
    public ConfigurationInfo getDeviceConfigurationInfo() throws RemoteException {
        ConfigurationInfo varB4EAC82CA7396A68D541C85D26508E83_1921488802 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_DEVICE_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        ConfigurationInfo res;
        res = ConfigurationInfo.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1921488802 = res;
        varB4EAC82CA7396A68D541C85D26508E83_1921488802.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1921488802;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.038 -0400", hash_original_method = "10D7A082C97EAFB331405B7841F1651D", hash_generated_method = "48758EAD56275E9D1FE94CFECD879E01")
    public boolean profileControl(String process, boolean start,
            String path, ParcelFileDescriptor fd, int profileType) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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
        boolean res;
        res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(process.getTaint());
        addTaint(start);
        addTaint(path.getTaint());
        addTaint(fd.getTaint());
        addTaint(profileType);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1956590341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1956590341;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.058 -0400", hash_original_method = "52F9DB0BA2A0AB8C52093D208807035C", hash_generated_method = "4F890A59CA428FD2A5616EDAA3E10F52")
    public boolean shutdown(int timeout) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(timeout);
        mRemote.transact(SHUTDOWN_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_172964847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_172964847;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.065 -0400", hash_original_method = "BE7DD92CBAD030A60DB7090E3408574C", hash_generated_method = "6EFAFF2991D8E27886C5EB3C2C0F7776")
    public void stopAppSwitches() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.086 -0400", hash_original_method = "0EC9793095E20007EC76AB5DDDE4E54A", hash_generated_method = "4D88D03CA17C616451D2F78971E5DDDE")
    public void resumeAppSwitches() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.110 -0400", hash_original_method = "7B78E2FEC61CC471A8E07C6C34C74BD6", hash_generated_method = "69165E19D84013C1FB3D2B1DBF34B0E9")
    public void registerActivityWatcher(IActivityWatcher watcher) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.133 -0400", hash_original_method = "8E5D6F085FE02A1442C5A617ADA012EC", hash_generated_method = "6CDED59E27F9E0F9E6BDBDAFC83D57D2")
    public void unregisterActivityWatcher(IActivityWatcher watcher) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.142 -0400", hash_original_method = "C65F778BCD540838D47FE4E4412CD25E", hash_generated_method = "10F705C720E9D8A7EF9B600167B201EB")
    public int startActivityInPackage(int uid,
            Intent intent, String resolvedType, IBinder resultTo,
            String resultWho, int requestCode, boolean onlyIfNeeded) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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
        int result;
        result = reply.readInt();
        reply.recycle();
        data.recycle();
        addTaint(uid);
        addTaint(intent.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resultWho.getTaint());
        addTaint(requestCode);
        addTaint(onlyIfNeeded);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365635032 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365635032;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.158 -0400", hash_original_method = "9BA7CBE5CC5118373D7AAA1497A47635", hash_generated_method = "3A1D8153CAB5C44FDCF377448C0005BE")
    public void killApplicationWithUid(String pkg, int uid) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.174 -0400", hash_original_method = "2A680A4513BB1B95074F3F876F148BA8", hash_generated_method = "8C207F3BA8E791B3D6EC8389C97D6C24")
    public void closeSystemDialogs(String reason) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.190 -0400", hash_original_method = "BD88F62F5112FCE1DE930509EBB83FD2", hash_generated_method = "72D48B2C0E5E75D9E93ED9648EFB33CA")
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) throws RemoteException {
        Debug.MemoryInfo[] varB4EAC82CA7396A68D541C85D26508E83_1978170006 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeIntArray(pids);
        mRemote.transact(GET_PROCESS_MEMORY_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        Debug.MemoryInfo[] res;
        res = reply.createTypedArray(Debug.MemoryInfo.CREATOR);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1978170006 = res;
        addTaint(pids[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1978170006.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1978170006;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.276 -0400", hash_original_method = "0F16B6E02208618C1D3EE91B8DD80482", hash_generated_method = "D33844A934DA57FB5B9683596CD3654C")
    public void killApplicationProcess(String processName, int uid) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.281 -0400", hash_original_method = "00D6B54E331AC7AA3DC1F40B928FA3FD", hash_generated_method = "BCA04B8E2D888C7BD84D5D63A5CEE9AC")
    public void overridePendingTransition(IBinder token, String packageName,
            int enterAnim, int exitAnim) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.297 -0400", hash_original_method = "0F906B538EF84DE09E15BAB8CDAE69C4", hash_generated_method = "CDE14D2FE0B79F80FDDCFD2755D33C6D")
    public boolean isUserAMonkey() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(IS_USER_A_MONKEY_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_696674116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_696674116;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.314 -0400", hash_original_method = "CE9EE2ABB9C16E19ED0FB5ECED80A2D8", hash_generated_method = "CFAA5D9A843B28C86BB6ABBF49358560")
    public void finishHeavyWeightApp() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.328 -0400", hash_original_method = "468B67BFEE008B6CDEC37F42802988FA", hash_generated_method = "E98619D40D2D499F666511A719DF629B")
    public void setImmersive(IBinder token, boolean immersive) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.351 -0400", hash_original_method = "12E814937BEB239BDABA8A5EE4F6D00D", hash_generated_method = "98EC6EBC7E0AE6E59C2CF294A62220EB")
    public boolean isImmersive(IBinder token) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(IS_IMMERSIVE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() == 1;
        data.recycle();
        reply.recycle();
        addTaint(token.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2105447651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2105447651;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.363 -0400", hash_original_method = "0342E1772D9E2D527D167E41870AA176", hash_generated_method = "E4A535C8198CCFAC07AFC5D393DC8F92")
    public boolean isTopActivityImmersive() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() == 1;
        data.recycle();
        reply.recycle();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1784360121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1784360121;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.388 -0400", hash_original_method = "574D561A4B99545A454A313F9DD764D8", hash_generated_method = "1A18134CF85C44FF5E75CE5C2A337E58")
    public void crashApplication(int uid, int initialPid, String packageName,
            String message) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.418 -0400", hash_original_method = "CF06029063749F4266D5EFBB16694E04", hash_generated_method = "0A4AD23E77079DFA8FF003CCFDE88356")
    public String getProviderMimeType(Uri uri) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_356117432 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        uri.writeToParcel(data, 0);
        mRemote.transact(GET_PROVIDER_MIME_TYPE_TRANSACTION, data, reply, 0);
        reply.readException();
        String res;
        res = reply.readString();
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_356117432 = res;
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_356117432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_356117432;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.439 -0400", hash_original_method = "A975CD5E1392FBC42C40F56501282DDB", hash_generated_method = "935E0C8591E9D86DF2988B5DAAD6C20F")
    public IBinder newUriPermissionOwner(String name) throws RemoteException {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_552060809 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(name);
        mRemote.transact(NEW_URI_PERMISSION_OWNER_TRANSACTION, data, reply, 0);
        reply.readException();
        IBinder res;
        res = reply.readStrongBinder();
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_552060809 = res;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_552060809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_552060809;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.463 -0400", hash_original_method = "1C35FE424D422C73471D9ECEE35C4093", hash_generated_method = "1388088E948CC1715CC2C230F63ABE85")
    public void grantUriPermissionFromOwner(IBinder owner, int fromUid, String targetPkg,
            Uri uri, int mode) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.491 -0400", hash_original_method = "D07898A73558FBA66858F774589B082E", hash_generated_method = "D1ED27413F9B2595180EA3EF5EFDF614")
    public void revokeUriPermissionFromOwner(IBinder owner, Uri uri,
            int mode) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.498 -0400", hash_original_method = "3DAB9C9F42020370AD19E1FE0AC1BDCE", hash_generated_method = "1073CD866AA65097D041D8474C60711D")
    public int checkGrantUriPermission(int callingUid, String targetPkg,
            Uri uri, int modeFlags) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(callingUid);
        data.writeString(targetPkg);
        uri.writeToParcel(data, 0);
        data.writeInt(modeFlags);
        mRemote.transact(CHECK_GRANT_URI_PERMISSION_TRANSACTION, data, reply, 0);
        reply.readException();
        int res;
        res = reply.readInt();
        data.recycle();
        reply.recycle();
        addTaint(callingUid);
        addTaint(targetPkg.getTaint());
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739365455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739365455;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.513 -0400", hash_original_method = "2510375C73B367DE6AAF634BB948BB50", hash_generated_method = "19F2CAE9672B23174C862CEA2E9589EA")
    public boolean dumpHeap(String process, boolean managed,
            String path, ParcelFileDescriptor fd) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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
        boolean res;
        res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(process.getTaint());
        addTaint(managed);
        addTaint(path.getTaint());
        addTaint(fd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476103253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476103253;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.551 -0400", hash_original_method = "D5FED7EEA920B3F53E1885BDA832FF44", hash_generated_method = "0F30D9BF0BFFA3BC37070A2F314B3474")
    public int startActivities(IApplicationThread caller,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeTypedArray(intents, 0);
        data.writeStringArray(resolvedTypes);
        data.writeStrongBinder(resultTo);
        mRemote.transact(START_ACTIVITIES_TRANSACTION, data, reply, 0);
        reply.readException();
        int result;
        result = reply.readInt();
        reply.recycle();
        data.recycle();
        addTaint(caller.getTaint());
        addTaint(intents[0].getTaint());
        addTaint(resolvedTypes[0].getTaint());
        addTaint(resultTo.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408345009 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408345009;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.567 -0400", hash_original_method = "7A44848B4F4A570D7B280FD97AA3F11F", hash_generated_method = "A57C284ADAAD50229D14FB3378F1A812")
    public int startActivitiesInPackage(int uid,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(uid);
        data.writeTypedArray(intents, 0);
        data.writeStringArray(resolvedTypes);
        data.writeStrongBinder(resultTo);
        mRemote.transact(START_ACTIVITIES_IN_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        int result;
        result = reply.readInt();
        reply.recycle();
        data.recycle();
        addTaint(uid);
        addTaint(intents[0].getTaint());
        addTaint(resolvedTypes[0].getTaint());
        addTaint(resultTo.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901103297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901103297;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.586 -0400", hash_original_method = "11A1C93F201BB77459CE48D94392036A", hash_generated_method = "76B8B6ABC1AC2CB784DFE1BB46F689B0")
    public int getFrontActivityScreenCompatMode() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        int mode;
        mode = reply.readInt();
        reply.recycle();
        data.recycle();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578186494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578186494;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.607 -0400", hash_original_method = "984BA2CED473A0F45E8080D25CCDF41F", hash_generated_method = "0D1A4C0DB03F76602FCE70AFDE8CC9FA")
    public void setFrontActivityScreenCompatMode(int mode) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.635 -0400", hash_original_method = "AFAFCB6FF2EC7CDD310E0CDC4C512BE7", hash_generated_method = "DBC67CF2E9538DFE56AF8E336B179515")
    public int getPackageScreenCompatMode(String packageName) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        mRemote.transact(GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        int mode;
        mode = reply.readInt();
        reply.recycle();
        data.recycle();
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1421953796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1421953796;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.655 -0400", hash_original_method = "5B0C9EEE90D8463E1DCC15B68E3829E8", hash_generated_method = "7E5BF32B9870AD6493F1C7DBF0EEBC57")
    public void setPackageScreenCompatMode(String packageName, int mode) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.665 -0400", hash_original_method = "7AFCEC9BC7A2DAB54F3EFFA101044309", hash_generated_method = "23BC2C665392A1833FEEB3C63D1E1CC5")
    public boolean getPackageAskScreenCompat(String packageName) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        mRemote.transact(GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean ask;
        ask = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(packageName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_139691295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_139691295;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.682 -0400", hash_original_method = "8C9BAA94A3976358AA466F180A11AE45", hash_generated_method = "B3FD549D09048C0ED3F3FA9AE3C4A2ED")
    public void setPackageAskScreenCompat(String packageName, boolean ask) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.702 -0400", hash_original_method = "0A8E6FD2F20689E2107BCC0911A72467", hash_generated_method = "706F73B521F2947E7F93E07FD2702AC5")
    public boolean switchUser(int userid) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(userid);
        mRemote.transact(SWITCH_USER_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean result;
        result = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(userid);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_611671945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_611671945;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.715 -0400", hash_original_method = "4161F4F4B6F51E7616ED3E0F5DA99E10", hash_generated_method = "54BD020DB07D4F41CBE9B466BE266F69")
    public boolean removeSubTask(int taskId, int subTaskIndex) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(taskId);
        data.writeInt(subTaskIndex);
        mRemote.transact(REMOVE_SUB_TASK_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean result;
        result = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(taskId);
        addTaint(subTaskIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1705413333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1705413333;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.730 -0400", hash_original_method = "D75556E86E98C9E69E5D8B6835FF1B1D", hash_generated_method = "9E5A4FAE15BF11BE94397E07D47BE013")
    public boolean removeTask(int taskId, int flags) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(taskId);
        data.writeInt(flags);
        mRemote.transact(REMOVE_TASK_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean result;
        result = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        addTaint(taskId);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_330439393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_330439393;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.742 -0400", hash_original_method = "AD040AF08607A87C88C9CB9BE1E3C408", hash_generated_method = "7CAFB41C167A663BC09772F5F8A693D0")
    public void registerProcessObserver(IProcessObserver observer) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.762 -0400", hash_original_method = "6FB2BE2D02A98F343D51290C94466533", hash_generated_method = "A716EA3DB382139F818CB7FDE9D2EE47")
    public void unregisterProcessObserver(IProcessObserver observer) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.774 -0400", hash_original_method = "A45994938B7DA24AED12FFC5B3B3DD69", hash_generated_method = "FCF587F91EC61A9FC957C1867717B4BD")
    public boolean isIntentSenderTargetedToPackage(IIntentSender sender) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(sender.asBinder());
        mRemote.transact(IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res;
        res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        addTaint(sender.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741059893 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741059893;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.797 -0400", hash_original_method = "ACD180EA48DE1CCAABBA4B90AA3470B8", hash_generated_method = "F604E4E05496423E4C3F7DA89AA74652")
    public void updatePersistentConfiguration(Configuration values) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.804 -0400", hash_original_method = "0E9D1ED4F0E7DC85612AA1E9A3EC65BE", hash_generated_method = "2AEF11E789E61B095320DF6F8C3F3939")
    public long[] getProcessPss(int[] pids) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeIntArray(pids);
        mRemote.transact(GET_PROCESS_PSS_TRANSACTION, data, reply, 0);
        reply.readException();
        long[] res;
        res = reply.createLongArray();
        data.recycle();
        reply.recycle();
        addTaint(pids[0]);
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_361053431 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_361053431;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.825 -0400", hash_original_method = "F6DDBF719DC0D2BCB3D721A826004A98", hash_generated_method = "91975FC0B59055012679ED744E22031A")
    public void showBootMessage(CharSequence msg, boolean always) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.840 -0400", hash_original_method = "C6C48FDB33104FCE337F1D8C3A233E89", hash_generated_method = "8A31AF607B349BB8BE78B082564FEFB1")
    public void dismissKeyguardOnNextActivity() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
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

