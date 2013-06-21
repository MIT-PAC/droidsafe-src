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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.702 -0400", hash_original_method = "444DC66B3432907DFEA55328E5B69649", hash_generated_method = "FF0B4D083A157B879D7CD5A2215454A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActivityManagerNative() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.730 -0400", hash_original_method = "796B52B1E8846F7CCEC22CD4B5B906A8", hash_generated_method = "46CA0508563A5F250E3816C4345CF709")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(flags);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(reply.dsTaint);
        dsTaint.addTaint(code);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1044515712 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_4023179 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_1635863834 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_1194911282 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_611955592 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1737483190 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_957929502 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_1747146396 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_865379532 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1671285845 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_889671811 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_2130464006 = (data.readInt() != 0);
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
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_439545789 = (super.onTransact(code, data, reply, flags));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.734 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "1992535F0C7EB8757F965477F5292EC0")
    @DSModeled(DSC.SAFE)
    public IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    static boolean sSystemReady = false;
    private static final Singleton<IActivityManager> gDefault = new Singleton<IActivityManager>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.734 -0400", hash_original_method = "DB2B8F5A0363FA0CE3E5AA87CCE94A22", hash_generated_method = "32FD73111A46EEF3C09661B8912ECC56")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected IActivityManager create() {
            IBinder b;
            b = ServiceManager.getService("activity");
            IActivityManager am;
            am = asInterface(b);
            return (IActivityManager)dsTaint.getTaint();
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

        
}; //Transformed anonymous class
}

class ActivityManagerProxy implements IActivityManager {
    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.736 -0400", hash_original_method = "3287CA7C2EB4AADDF2EFFF2704D2BE9E", hash_generated_method = "5A4E575C39FA9C6FCC76D9C9D27DF084")
    @DSModeled(DSC.SAFE)
    public ActivityManagerProxy(IBinder remote) {
        dsTaint.addTaint(remote.dsTaint);
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.736 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "DD6FDB77557F0A5920AFCE061E8D4085")
    @DSModeled(DSC.SAFE)
    public IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.737 -0400", hash_original_method = "ECBE4259B26F016D18C1CACD48E02238", hash_generated_method = "E882E700741BF1076C6C13990556E93F")
    @DSModeled(DSC.SPEC)
    public int startActivity(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, String profileFile, ParcelFileDescriptor profileFd,
            boolean autoStopProfiler) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(onlyIfNeeded);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(grantedUriPermissions[0].dsTaint);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(autoStopProfiler);
        dsTaint.addTaint(profileFd.dsTaint);
        dsTaint.addTaint(profileFile);
        dsTaint.addTaint(debug);
        dsTaint.addTaint(resultWho);
        dsTaint.addTaint(grantedMode);
        dsTaint.addTaint(resolvedType);
        dsTaint.addTaint(intent.dsTaint);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.739 -0400", hash_original_method = "BF42E410BABF1DD283EC1102C9637003", hash_generated_method = "C1D40167EDF9946D9ACEE4CF70943F05")
    @DSModeled(DSC.SPEC)
    public WaitResult startActivityAndWait(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, String profileFile, ParcelFileDescriptor profileFd,
            boolean autoStopProfiler) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(onlyIfNeeded);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(grantedUriPermissions[0].dsTaint);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(autoStopProfiler);
        dsTaint.addTaint(profileFd.dsTaint);
        dsTaint.addTaint(profileFile);
        dsTaint.addTaint(debug);
        dsTaint.addTaint(resultWho);
        dsTaint.addTaint(grantedMode);
        dsTaint.addTaint(resolvedType);
        dsTaint.addTaint(intent.dsTaint);
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
        return (WaitResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.740 -0400", hash_original_method = "47F7B475943E725D61EF4FCECF2C263D", hash_generated_method = "0DD10315EAB092E6CB1F8D10EDD5CCB4")
    @DSModeled(DSC.SPEC)
    public int startActivityWithConfig(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, Configuration config) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(onlyIfNeeded);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(grantedUriPermissions[0].dsTaint);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(debug);
        dsTaint.addTaint(resultWho);
        dsTaint.addTaint(grantedMode);
        dsTaint.addTaint(resolvedType);
        dsTaint.addTaint(intent.dsTaint);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.741 -0400", hash_original_method = "FD56EAF7591CCE02A2449EB3C30AEF02", hash_generated_method = "ED439F38C468AC7FFC3881EE9CF1E2E5")
    @DSModeled(DSC.SPEC)
    public int startActivityIntentSender(IApplicationThread caller,
            IntentSender intent, Intent fillInIntent, String resolvedType,
            IBinder resultTo, String resultWho, int requestCode,
            int flagsMask, int flagsValues) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(flagsMask);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(flagsValues);
        dsTaint.addTaint(resultWho);
        dsTaint.addTaint(resolvedType);
        dsTaint.addTaint(fillInIntent.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.742 -0400", hash_original_method = "A532370FCCB6C359BF27FA22D92F73F5", hash_generated_method = "C9C4DEE4AAD0951DE1A71FF1827BB116")
    @DSModeled(DSC.SPEC)
    public boolean startNextMatchingActivity(IBinder callingActivity,
            Intent intent) throws RemoteException {
        dsTaint.addTaint(callingActivity.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.744 -0400", hash_original_method = "91E82D39E0DA0BAF3D9668B58FD8BE2D", hash_generated_method = "9DF9A47E2CB05B388C195F70FC5DF574")
    @DSModeled(DSC.SPEC)
    public boolean finishActivity(IBinder token, int resultCode, Intent resultData) throws RemoteException {
        dsTaint.addTaint(resultData.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(resultCode);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.745 -0400", hash_original_method = "352728C633440E8BBFDE1A24B12C26C6", hash_generated_method = "BA6728E40BDC3DC94D74C8C36833858A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishSubActivity(IBinder token, String resultWho, int requestCode) throws RemoteException {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(resultWho);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.746 -0400", hash_original_method = "03769BB85CE515FA0FB5B3DCD0709D8A", hash_generated_method = "12EF168DE47A96C59F0E735648680D15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean willActivityBeVisible(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.746 -0400", hash_original_method = "D0EC9750E66DC0864B7AF9A5D43ED043", hash_generated_method = "11D83DE7DB61C830B05AF621F0A294B0")
    @DSModeled(DSC.SPEC)
    public Intent registerReceiver(IApplicationThread caller, String packageName,
            IIntentReceiver receiver,
            IntentFilter filter, String perm) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(perm);
        dsTaint.addTaint(filter.dsTaint);
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
        return (Intent)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.747 -0400", hash_original_method = "CF62E9563222E9365AE1815E546E05AA", hash_generated_method = "1191E34AF227EC7704F73B39AAA1D578")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterReceiver(IIntentReceiver receiver) throws RemoteException {
        dsTaint.addTaint(receiver.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.748 -0400", hash_original_method = "189D2A1B1A14BF35BFCC0BB8AD6C1CE5", hash_generated_method = "8BE66A25C9B1C954A5877E1A727C87E1")
    @DSModeled(DSC.SPEC)
    public int broadcastIntent(IApplicationThread caller,
            Intent intent, String resolvedType,  IIntentReceiver resultTo,
            int resultCode, String resultData, Bundle map,
            String requiredPermission, boolean serialized,
            boolean sticky) throws RemoteException {
        dsTaint.addTaint(resultData);
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(sticky);
        dsTaint.addTaint(serialized);
        dsTaint.addTaint(map.dsTaint);
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(resolvedType);
        dsTaint.addTaint(requiredPermission);
        dsTaint.addTaint(intent.dsTaint);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.749 -0400", hash_original_method = "84F4ECE33F63E245917246490F7877AA", hash_generated_method = "9D5CAA8E2B8AC9E8861D15788F659A19")
    @DSModeled(DSC.SPEC)
    public void unbroadcastIntent(IApplicationThread caller, Intent intent) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.750 -0400", hash_original_method = "8BFF18A0F9A8EDDD76A319C280B21CDC", hash_generated_method = "FB158A0E7730707C02B7C28AF7F47D8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishReceiver(IBinder who, int resultCode, String resultData, Bundle map, boolean abortBroadcast) throws RemoteException {
        dsTaint.addTaint(resultData);
        dsTaint.addTaint(abortBroadcast);
        dsTaint.addTaint(map.dsTaint);
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(who.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.750 -0400", hash_original_method = "1E67E239E5F2A2540F1E032AB272605E", hash_generated_method = "AD9F9664D0C23196C8E08D6ADBC5040A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void attachApplication(IApplicationThread app) throws RemoteException {
        dsTaint.addTaint(app.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.751 -0400", hash_original_method = "BC9E49082B5DC06C707641FC7F3E31F5", hash_generated_method = "54D172787950CCDBA25E9D91FAA6D8FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void activityIdle(IBinder token, Configuration config, boolean stopProfiling) throws RemoteException {
        dsTaint.addTaint(stopProfiling);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(config.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.752 -0400", hash_original_method = "4914FFC78B966DEBED0BDBFF9D70FB17", hash_generated_method = "0E05C9CF82B895F565894CB12D96976F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void activityPaused(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.754 -0400", hash_original_method = "F5DE3AC45B6CCF74477AF45EB0878099", hash_generated_method = "778945DDAEC878C1C29DF4CE2EF6EA1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void activityStopped(IBinder token, Bundle state,
            Bitmap thumbnail, CharSequence description) throws RemoteException {
        dsTaint.addTaint(thumbnail.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(description);
        dsTaint.addTaint(state.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.754 -0400", hash_original_method = "CA8224B1DA5730B462FB3F604509C1DB", hash_generated_method = "3C2A1B245C86D9E85214090EF5DF5C5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void activitySlept(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.755 -0400", hash_original_method = "9A100D49A0D535BB686DAA00CAC541FF", hash_generated_method = "6384DB46C4366D09FAD7D034B77FDC3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void activityDestroyed(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.756 -0400", hash_original_method = "7637EF2082F6942F953796EFCEAA3730", hash_generated_method = "B898DD01A71FE7D39D9CA3EE65A2A933")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCallingPackage(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.756 -0400", hash_original_method = "0E9D91A20FCD3BCFB3517DB475147FAB", hash_generated_method = "B715688E20FB0253D77477191718F162")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName getCallingActivity(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
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
        return (ComponentName)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.757 -0400", hash_original_method = "FAA1C4AE039868246AED533CDCA15CD7", hash_generated_method = "C4FE69A667446AC6790C14FB5BDC013C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List getTasks(int maxNum, int flags,
            IThumbnailReceiver receiver) throws RemoteException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(maxNum);
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
        return (List)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.758 -0400", hash_original_method = "9D3E8FF17F102376D7C7BE9D34CE4F93", hash_generated_method = "D1B710F7B2D20A62AF23D1C1697516DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ActivityManager.RecentTaskInfo> getRecentTasks(int maxNum,
            int flags) throws RemoteException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(maxNum);
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
        return (List<ActivityManager.RecentTaskInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.759 -0400", hash_original_method = "10D095A12B52FE928E4AEC7C3F42A832", hash_generated_method = "10F7E3391FD5E3406A8CE5D9F169C5BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActivityManager.TaskThumbnails getTaskThumbnails(int id) throws RemoteException {
        dsTaint.addTaint(id);
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
            boolean varB04A284F06B56929F38634A7F4C6A0D7_1954819183 = (reply.readInt() != 0);
            {
                bm = ActivityManager.TaskThumbnails.CREATOR.createFromParcel(reply);
            } //End block
        } //End collapsed parenthetic
        data.recycle();
        reply.recycle();
        return (ActivityManager.TaskThumbnails)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.759 -0400", hash_original_method = "7671DD1471581027B2C414BE0E3CE4A6", hash_generated_method = "BBC5B45D799A90BC82599E954F21DA04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List getServices(int maxNum, int flags) throws RemoteException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(maxNum);
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
        return (List)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.760 -0400", hash_original_method = "2AE453A6460D5AF368C9AC4C4862314B", hash_generated_method = "91CA7351E8D8AB491E1BBB2DF65A305A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ActivityManager.ProcessErrorStateInfo> getProcessesInErrorState() throws RemoteException {
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
        return (List<ActivityManager.ProcessErrorStateInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.761 -0400", hash_original_method = "8E45CD57BE18A4B76C3A3E0DA22BC8B7", hash_generated_method = "2EDF991D285FB0F46841FFAE3814B60F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() throws RemoteException {
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
        return (List<ActivityManager.RunningAppProcessInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.844 -0400", hash_original_method = "2FAC851B003A84469F94E88A81DA29C3", hash_generated_method = "EA9AE24906CCAD3B3A7C7C7299BB5FFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ApplicationInfo> getRunningExternalApplications() throws RemoteException {
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
        return (List<ApplicationInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.845 -0400", hash_original_method = "DABF13B8F45F6A065880490CD0DBD1A0", hash_generated_method = "1E7ADA48D66919D8D2C5CFBB15B3470B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void moveTaskToFront(int task, int flags) throws RemoteException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(task);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.845 -0400", hash_original_method = "7FFB6E49EA553237E0A3F53A2CDFD87F", hash_generated_method = "524A8575C0FF0FC9DB7771602AC3E385")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void moveTaskToBack(int task) throws RemoteException {
        dsTaint.addTaint(task);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.846 -0400", hash_original_method = "7F4F39C4D7AB58BCB5DB152705A9F80A", hash_generated_method = "F6B1CE69B8C848387692B1B6D90A99B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveActivityTaskToBack(IBinder token, boolean nonRoot) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(nonRoot);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.847 -0400", hash_original_method = "48BD6DC2300FE39DD3A4B34C3DD91993", hash_generated_method = "129748059E00D05B7C3428EAD3D1B16D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void moveTaskBackwards(int task) throws RemoteException {
        dsTaint.addTaint(task);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.848 -0400", hash_original_method = "3FABC29A3C68690EBF6B4F44EE4A5D23", hash_generated_method = "10AB9922091C3B48A20A6CC6D5B306E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTaskForActivity(IBinder token, boolean onlyRoot) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(onlyRoot);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.849 -0400", hash_original_method = "AF696C3AA9BD79AC1F2D6780E820F3FA", hash_generated_method = "26140FB49CC725BB17A1E250652B6F77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishOtherInstances(IBinder token, ComponentName className) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(className.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.849 -0400", hash_original_method = "4B3E31ABB8C007E1B3828F729DFD9393", hash_generated_method = "1AF3BE8A99D3941EF3E3FA1165D2CE6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reportThumbnail(IBinder token,
                                Bitmap thumbnail, CharSequence description) throws RemoteException {
        dsTaint.addTaint(thumbnail.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(description);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.850 -0400", hash_original_method = "EC6CF87E25124312A62325C5F062E996", hash_generated_method = "E81E1ECBAA02ECFD1D5A3381975B8B53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentProviderHolder getContentProvider(IApplicationThread caller,
                                                    String name) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(name);
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
        return (ContentProviderHolder)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.851 -0400", hash_original_method = "9C5D73DEFA4B6B21F8A4E01DC5E46521", hash_generated_method = "B97795E3FC6E703EB7792CAD2ADD8D7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void publishContentProviders(IApplicationThread caller,
                                        List<ContentProviderHolder> providers) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(providers.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.852 -0400", hash_original_method = "6E983079D2A10BB8E3DF4E66B032EE6D", hash_generated_method = "B737EBA14FC21D662EA548FBCF231622")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeContentProvider(IApplicationThread caller,
            String name) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.854 -0400", hash_original_method = "E5355EA6A0F8270964E816C69524096C", hash_generated_method = "4B3D8EB6EAB9BB050D25CC95B3E9F2D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PendingIntent getRunningServiceControlPanel(ComponentName service) throws RemoteException {
        dsTaint.addTaint(service.dsTaint);
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
        return (PendingIntent)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.856 -0400", hash_original_method = "A683CF3BA039B3B97AA6ADC23E6FBDCC", hash_generated_method = "33C0D41E0D285222ACB0968AF980E569")
    @DSModeled(DSC.SPEC)
    public ComponentName startService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(resolvedType);
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
        return (ComponentName)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.858 -0400", hash_original_method = "B5D9E3A4F6ABA893303F2F02B64751B8", hash_generated_method = "88C8219AF98AE0F911581434E74CC702")
    @DSModeled(DSC.SPEC)
    public int stopService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(resolvedType);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.858 -0400", hash_original_method = "DB1BCCF2CB5E2532E24072B1F607F963", hash_generated_method = "413471B5F3C4CD71CAC37D7A714A01F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean stopServiceToken(ComponentName className, IBinder token,
            int startId) throws RemoteException {
        dsTaint.addTaint(startId);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(className.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.859 -0400", hash_original_method = "9DE0D26C134349F3DA011E11517F3FF5", hash_generated_method = "144C950787211370FA7E0A4221BDB1BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setServiceForeground(ComponentName className, IBinder token,
            int id, Notification notification, boolean removeNotification) throws RemoteException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(removeNotification);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(notification.dsTaint);
        dsTaint.addTaint(className.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.861 -0400", hash_original_method = "A1E6D6F237E88697017FA79FBE451840", hash_generated_method = "7792CD2A4D13BD00C617CAA8E70D9B5C")
    @DSModeled(DSC.SPEC)
    public int bindService(IApplicationThread caller, IBinder token,
            Intent service, String resolvedType, IServiceConnection connection,
            int flags) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(connection.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(resolvedType);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.862 -0400", hash_original_method = "E0BD37EB96539E724DE863D335954DC9", hash_generated_method = "362B28546B4DF2E09AF0F78D4923836A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean unbindService(IServiceConnection connection) throws RemoteException {
        dsTaint.addTaint(connection.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.863 -0400", hash_original_method = "87A207496B270585D5EEA34C1AF57170", hash_generated_method = "F87CFF3D875B097736E2C4666F5C6007")
    @DSModeled(DSC.SPEC)
    public void publishService(IBinder token,
            Intent intent, IBinder service) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.863 -0400", hash_original_method = "3796516624A8D493E471933ECF7A3CD3", hash_generated_method = "75602478168C005A74908A00AD0FE0DD")
    @DSModeled(DSC.SPEC)
    public void unbindFinished(IBinder token, Intent intent, boolean doRebind) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(doRebind);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.864 -0400", hash_original_method = "1CB80C62A00C622E35F1B57A132292E9", hash_generated_method = "F2D81E1DEAB02D0453F072387B15F45E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void serviceDoneExecuting(IBinder token, int type, int startId,
            int res) throws RemoteException {
        dsTaint.addTaint(res);
        dsTaint.addTaint(startId);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(type);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.865 -0400", hash_original_method = "BEF476EE5F43517187661CDC39F2A448", hash_generated_method = "FEE9313C356ECAECD1D572654D896920")
    @DSModeled(DSC.SPEC)
    public IBinder peekService(Intent service, String resolvedType) throws RemoteException {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(resolvedType);
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
        return (IBinder)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.865 -0400", hash_original_method = "7AACC08C389BEE0061373162626F356D", hash_generated_method = "699554264B126CF9E6DF2146CBBFF2E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean bindBackupAgent(ApplicationInfo app, int backupRestoreMode) throws RemoteException {
        dsTaint.addTaint(app.dsTaint);
        dsTaint.addTaint(backupRestoreMode);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.866 -0400", hash_original_method = "ADE4561AB0FC3828104C329F05A9B88C", hash_generated_method = "9DE87FA74B00E30A21AE91260BD3E928")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void backupAgentCreated(String packageName, IBinder agent) throws RemoteException {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(agent.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.867 -0400", hash_original_method = "80BB0DB939AA2A14DC79CE879293739F", hash_generated_method = "4B421914749EB031298FB707FE7F55BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unbindBackupAgent(ApplicationInfo app) throws RemoteException {
        dsTaint.addTaint(app.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.867 -0400", hash_original_method = "7977DF3866173BBD9227641CB70C5B9A", hash_generated_method = "A5B981BF492A59584482CE7900B066C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startInstrumentation(ComponentName className, String profileFile,
            int flags, Bundle arguments, IInstrumentationWatcher watcher) throws RemoteException {
        dsTaint.addTaint(arguments.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(className.dsTaint);
        dsTaint.addTaint(profileFile);
        dsTaint.addTaint(watcher.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.868 -0400", hash_original_method = "D76B5F1B397FC7028B59F12CA3604783", hash_generated_method = "AADB0C9978DE97C4B0F452FB493A3DDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishInstrumentation(IApplicationThread target,
            int resultCode, Bundle results) throws RemoteException {
        dsTaint.addTaint(results.dsTaint);
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(target.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.869 -0400", hash_original_method = "E824FA9DB2D76671E24682EC782F4756", hash_generated_method = "7A2E0DABD3E1F4C83145E223390BC3D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Configuration getConfiguration() throws RemoteException {
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
        return (Configuration)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.869 -0400", hash_original_method = "76911A2717FEEEC7D6B4E93DC7F2427C", hash_generated_method = "998CB5FEDFA5C1A1467D186C13856BCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateConfiguration(Configuration values) throws RemoteException {
        dsTaint.addTaint(values.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.870 -0400", hash_original_method = "65FC5D17EF9FF3BF1BFFDA9CCA9A4BE1", hash_generated_method = "8B14598D16DA7DD1B2E3C32894EFD50C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRequestedOrientation(IBinder token, int requestedOrientation) throws RemoteException {
        dsTaint.addTaint(requestedOrientation);
        dsTaint.addTaint(token.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.871 -0400", hash_original_method = "505D3FD7966F547E2BAA16E1C1C5F05B", hash_generated_method = "276297112ED725E879D1631273BBF75C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRequestedOrientation(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.871 -0400", hash_original_method = "BCB55F79D75B3B83E49A75043EE249A9", hash_generated_method = "70D56B92B36957672DFB961B99478132")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName getActivityClassForToken(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
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
        return (ComponentName)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.872 -0400", hash_original_method = "9BAE752D062408101ED2F689CF20DDD1", hash_generated_method = "E4CF5C61B0B4FA85F9988AB7AE5C0119")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPackageForToken(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.873 -0400", hash_original_method = "AE56AE3D6914251F9FFFA7E33C698EB6", hash_generated_method = "FC64389942B9028D5357C04A34BE4295")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IIntentSender getIntentSender(int type,
            String packageName, IBinder token, String resultWho,
            int requestCode, Intent[] intents, String[] resolvedTypes, int flags) throws RemoteException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(intents[0].dsTaint);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(resolvedTypes[0]);
        dsTaint.addTaint(resultWho);
        dsTaint.addTaint(type);
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
        return (IIntentSender)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.873 -0400", hash_original_method = "D459AA1ADAE84FC2B7BB3BA73C047FDB", hash_generated_method = "1520714943AD3A7FA08DCA0922F5016B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancelIntentSender(IIntentSender sender) throws RemoteException {
        dsTaint.addTaint(sender.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.874 -0400", hash_original_method = "1993496C4F183452017D412A9B9C5C29", hash_generated_method = "73E15D2ABAB0375B7E532F2450453811")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPackageForIntentSender(IIntentSender sender) throws RemoteException {
        dsTaint.addTaint(sender.dsTaint);
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.875 -0400", hash_original_method = "92B622DC0CB7ED23BB116E8953A0A90A", hash_generated_method = "EF4FE26D5FA8672CA2DAFA59568D15EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProcessLimit(int max) throws RemoteException {
        dsTaint.addTaint(max);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.875 -0400", hash_original_method = "4FA932EFF1C9BAC6AA973FE979D6B75F", hash_generated_method = "E6664579BB7564E9D10E5D13536C2D53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.876 -0400", hash_original_method = "16F5E36D0F576E8CD2EC3F6B33B5169D", hash_generated_method = "273A557B5B278CDEC97A89519EF91DAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProcessForeground(IBinder token, int pid,
            boolean isForeground) throws RemoteException {
        dsTaint.addTaint(isForeground);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(pid);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.877 -0400", hash_original_method = "A50C503DC3495EB643680A38372DD1F5", hash_generated_method = "C5B5FC1BFAADA762B1EB21AE23FA39F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int checkPermission(String permission, int pid, int uid) throws RemoteException {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(permission);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.877 -0400", hash_original_method = "BE5C38AE92A5EE5CE45944FF93295090", hash_generated_method = "1CBD4D4AB74702153CF786DED6DFC795")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clearApplicationUserData(final String packageName,
            final IPackageDataObserver observer) throws RemoteException {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(observer.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.878 -0400", hash_original_method = "FEF4F93E5B02F55707A11B36638BBB59", hash_generated_method = "45332C78B7FA8121B126C7B7CB934EC7")
    @DSModeled(DSC.SPEC)
    public int checkUriPermission(Uri uri, int pid, int uid, int mode) throws RemoteException {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.879 -0400", hash_original_method = "2CEB2CA82A36297F49BF5DB3286E579B", hash_generated_method = "485848987272A1B3DAA13119D643BE82")
    @DSModeled(DSC.SPEC)
    public void grantUriPermission(IApplicationThread caller, String targetPkg,
            Uri uri, int mode) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(targetPkg);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.881 -0400", hash_original_method = "84D534ABCBC85608735C63399D2C9E1E", hash_generated_method = "EFD455D57A0118692B172296ADA42E9A")
    @DSModeled(DSC.SPEC)
    public void revokeUriPermission(IApplicationThread caller, Uri uri,
            int mode) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.882 -0400", hash_original_method = "7FC96553233904C2463E3D793E528211", hash_generated_method = "F90430D97DDD5002E6394A359837D5E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showWaitingForDebugger(IApplicationThread who, boolean waiting) throws RemoteException {
        dsTaint.addTaint(waiting);
        dsTaint.addTaint(who.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.883 -0400", hash_original_method = "40DDB58D1BE7B54E85772ACF1AA60D8F", hash_generated_method = "91AE7A81FA97ECA52ABDFE3A9B0257C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getMemoryInfo(ActivityManager.MemoryInfo outInfo) throws RemoteException {
        dsTaint.addTaint(outInfo.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.884 -0400", hash_original_method = "805F881D84830966D1AD0B083D69DA9A", hash_generated_method = "42784F3026C0A0D25A2A024B2E27B1F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.885 -0400", hash_original_method = "1E46E6C9628834765008140B25990D23", hash_generated_method = "026029A3DF68336AC7EDC5705648E3F9")
    @DSModeled(DSC.SPEC)
    public ParcelFileDescriptor openContentUri(Uri uri) throws RemoteException {
        dsTaint.addTaint(uri.dsTaint);
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
            boolean varB04A284F06B56929F38634A7F4C6A0D7_2070967451 = (reply.readInt() != 0);
            {
                pfd = ParcelFileDescriptor.CREATOR.createFromParcel(reply);
            } //End block
        } //End collapsed parenthetic
        data.recycle();
        reply.recycle();
        return (ParcelFileDescriptor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.886 -0400", hash_original_method = "E3BC510BF36E68FD23494212AB6E7B33", hash_generated_method = "FFBC3DEB08C7FC6E579AF592A878016E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.888 -0400", hash_original_method = "CAFF51A84FC631E180A23D0F5290B43F", hash_generated_method = "BE931B7C3EDD7251D16E613C4E055624")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.892 -0400", hash_original_method = "482C4468B37AD6CEF12EA376A273F16E", hash_generated_method = "23CEADF52CF89293EC9A3652F4687FC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDebugApp(
        String packageName, boolean waitForDebugger, boolean persistent) throws RemoteException {
        dsTaint.addTaint(persistent);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(waitForDebugger);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.893 -0400", hash_original_method = "DE27B8A416D8E1FF87F079AFA1567A6E", hash_generated_method = "D8193F6FE058B6BD615D5ADEF53A6203")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlwaysFinish(boolean enabled) throws RemoteException {
        dsTaint.addTaint(enabled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.893 -0400", hash_original_method = "D7DBDAD7386DC1F45D7A9AB12513A49B", hash_generated_method = "A66C16F541053FC177F54B99DF14749B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setActivityController(IActivityController watcher) throws RemoteException {
        dsTaint.addTaint(watcher.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.894 -0400", hash_original_method = "FF7EEF7728CACAD7286D113A3CF07513", hash_generated_method = "8BE9FBF4A7C7869BD53D6F6EF7FEFE7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.894 -0400", hash_original_method = "72F87C80970F6885E4DCD6DA1B2F19E8", hash_generated_method = "3E6417CC44EA069B60A9C056CC8CEF85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void noteWakeupAlarm(IIntentSender sender) throws RemoteException {
        dsTaint.addTaint(sender.dsTaint);
        Parcel data;
        data = Parcel.obtain();
        data.writeStrongBinder(sender.asBinder());
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(NOTE_WAKEUP_ALARM_TRANSACTION, data, null, 0);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeStrongBinder(sender.asBinder());
        //data.writeInterfaceToken(IActivityManager.descriptor);
        //mRemote.transact(NOTE_WAKEUP_ALARM_TRANSACTION, data, null, 0);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.895 -0400", hash_original_method = "DB2721BD1E4C8F1064AA0461CF2A490B", hash_generated_method = "C85005A1D96F19B3966A50CA4A2E4125")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean killPids(int[] pids, String reason, boolean secure) throws RemoteException {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(pids[0]);
        dsTaint.addTaint(secure);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.896 -0400", hash_original_method = "9964526F9DDC53538E50ED934A9D4009", hash_generated_method = "637F89B3D3E47DE599A150B92D4B0C8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startRunning(String pkg, String cls, String action,
            String indata) throws RemoteException {
        dsTaint.addTaint(cls);
        dsTaint.addTaint(action);
        dsTaint.addTaint(pkg);
        dsTaint.addTaint(indata);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.896 -0400", hash_original_method = "6C8B2FE75A3BFFE16EADA916F678A09D", hash_generated_method = "03B0F501F3E778B0A344ED28A7B26878")
    @DSModeled(DSC.SAFE)
    public boolean testIsSystemReady() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.897 -0400", hash_original_method = "523AF9597115E332AF2A1F534C49483C", hash_generated_method = "2F82F8F832A56A6994B87E7BC023503A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleApplicationCrash(IBinder app,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
        dsTaint.addTaint(app.dsTaint);
        dsTaint.addTaint(crashInfo.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.898 -0400", hash_original_method = "84EFC78EC4B379D270C222A7BC31C5F7", hash_generated_method = "E31B0A68D58584589A927CC2BEDA780F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handleApplicationWtf(IBinder app, String tag,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
        dsTaint.addTaint(app.dsTaint);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(crashInfo.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.898 -0400", hash_original_method = "7AC27E481709B1F0B25AE2BA23B3BECF", hash_generated_method = "9E5A60AAA908153B3860702C9DD2535E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleApplicationStrictModeViolation(IBinder app,
            int violationMask,
            StrictMode.ViolationInfo info) throws RemoteException {
        dsTaint.addTaint(app.dsTaint);
        dsTaint.addTaint(info.dsTaint);
        dsTaint.addTaint(violationMask);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.899 -0400", hash_original_method = "22BD8EFAE7A36DA76D8B0F7F297E970D", hash_generated_method = "9E388D3CF96771780A977A16D003A26B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void signalPersistentProcesses(int sig) throws RemoteException {
        dsTaint.addTaint(sig);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.900 -0400", hash_original_method = "3D80332C8A0FCAFBCE220FADA30302CB", hash_generated_method = "AB391C3E2A42CDB9426D9722F3F8A16C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void killBackgroundProcesses(String packageName) throws RemoteException {
        dsTaint.addTaint(packageName);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.900 -0400", hash_original_method = "C7F5D3EA775AD04DD438191F0B4D22C4", hash_generated_method = "FD2D18652BBA0B48AEE79B10FADB04B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.901 -0400", hash_original_method = "CB4D9E734B2DC6A00C763BA9D15D84CC", hash_generated_method = "72AB7140B7FE11BEDB448A42523E6E6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void forceStopPackage(String packageName) throws RemoteException {
        dsTaint.addTaint(packageName);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.902 -0400", hash_original_method = "9F4AADDAC8F1648FD8C80C6B88BBF25F", hash_generated_method = "DCDD536A2AC015737ECCB944F189885D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConfigurationInfo getDeviceConfigurationInfo() throws RemoteException {
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
        return (ConfigurationInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.902 -0400", hash_original_method = "10D7A082C97EAFB331405B7841F1651D", hash_generated_method = "6D7B5F96086AEDE28D1B3049DADC6167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean profileControl(String process, boolean start,
            String path, ParcelFileDescriptor fd, int profileType) throws RemoteException {
        dsTaint.addTaint(process);
        dsTaint.addTaint(profileType);
        dsTaint.addTaint(start);
        dsTaint.addTaint(path);
        dsTaint.addTaint(fd.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.903 -0400", hash_original_method = "52F9DB0BA2A0AB8C52093D208807035C", hash_generated_method = "B12CF0839310F1D1CB1908A15314B7ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean shutdown(int timeout) throws RemoteException {
        dsTaint.addTaint(timeout);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.904 -0400", hash_original_method = "BE7DD92CBAD030A60DB7090E3408574C", hash_generated_method = "6EFAFF2991D8E27886C5EB3C2C0F7776")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.904 -0400", hash_original_method = "0EC9793095E20007EC76AB5DDDE4E54A", hash_generated_method = "4D88D03CA17C616451D2F78971E5DDDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.905 -0400", hash_original_method = "7B78E2FEC61CC471A8E07C6C34C74BD6", hash_generated_method = "2BC679AB7D162BC06DABD7D91A9EF986")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerActivityWatcher(IActivityWatcher watcher) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(watcher.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.905 -0400", hash_original_method = "8E5D6F085FE02A1442C5A617ADA012EC", hash_generated_method = "C8F3F7B1CF006535EC9337D23DF918A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterActivityWatcher(IActivityWatcher watcher) throws RemoteException {
        dsTaint.addTaint(watcher.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.906 -0400", hash_original_method = "C65F778BCD540838D47FE4E4412CD25E", hash_generated_method = "5286DB005B8D8E7770FC82FC426117FD")
    @DSModeled(DSC.SPEC)
    public int startActivityInPackage(int uid,
            Intent intent, String resolvedType, IBinder resultTo,
            String resultWho, int requestCode, boolean onlyIfNeeded) throws RemoteException {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(onlyIfNeeded);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(resultWho);
        dsTaint.addTaint(resolvedType);
        dsTaint.addTaint(intent.dsTaint);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.907 -0400", hash_original_method = "9BA7CBE5CC5118373D7AAA1497A47635", hash_generated_method = "20FFD8C1634C8E875203E24F5D5B9B9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void killApplicationWithUid(String pkg, int uid) throws RemoteException {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(pkg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.907 -0400", hash_original_method = "2A680A4513BB1B95074F3F876F148BA8", hash_generated_method = "B399EA975BCCA5EF74E7FC8F91016636")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void closeSystemDialogs(String reason) throws RemoteException {
        dsTaint.addTaint(reason);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.908 -0400", hash_original_method = "BD88F62F5112FCE1DE930509EBB83FD2", hash_generated_method = "76F393E6E227EF149BC31AA24A843CE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) throws RemoteException {
        dsTaint.addTaint(pids[0]);
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
        return (Debug.MemoryInfo[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.909 -0400", hash_original_method = "0F16B6E02208618C1D3EE91B8DD80482", hash_generated_method = "5242A5524720E7909AB5BD7AF9C2D58B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void killApplicationProcess(String processName, int uid) throws RemoteException {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(processName);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.909 -0400", hash_original_method = "00D6B54E331AC7AA3DC1F40B928FA3FD", hash_generated_method = "6706D9C157131DDE74DE593F59E0E609")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void overridePendingTransition(IBinder token, String packageName,
            int enterAnim, int exitAnim) throws RemoteException {
        dsTaint.addTaint(exitAnim);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(enterAnim);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.910 -0400", hash_original_method = "0F906B538EF84DE09E15BAB8CDAE69C4", hash_generated_method = "6AD24C497BCC3DB24B0530E7BC504585")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.911 -0400", hash_original_method = "CE9EE2ABB9C16E19ED0FB5ECED80A2D8", hash_generated_method = "CFAA5D9A843B28C86BB6ABBF49358560")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.911 -0400", hash_original_method = "468B67BFEE008B6CDEC37F42802988FA", hash_generated_method = "F390A391E735E6452CD64D89630A15DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setImmersive(IBinder token, boolean immersive) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(immersive);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.912 -0400", hash_original_method = "12E814937BEB239BDABA8A5EE4F6D00D", hash_generated_method = "F7F27B20D2826434A216857200653E32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isImmersive(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.912 -0400", hash_original_method = "0342E1772D9E2D527D167E41870AA176", hash_generated_method = "21A46AC917409F7B5C525A447D9BE90F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.913 -0400", hash_original_method = "574D561A4B99545A454A313F9DD764D8", hash_generated_method = "5C747CAC33CE8A61FA9F841EC0F1A807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void crashApplication(int uid, int initialPid, String packageName,
            String message) throws RemoteException {
        dsTaint.addTaint(message);
        dsTaint.addTaint(uid);
        dsTaint.addTaint(initialPid);
        dsTaint.addTaint(packageName);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.914 -0400", hash_original_method = "CF06029063749F4266D5EFBB16694E04", hash_generated_method = "CEDE213CB8771755DD7EF3F1EA317ADD")
    @DSModeled(DSC.SPEC)
    public String getProviderMimeType(Uri uri) throws RemoteException {
        dsTaint.addTaint(uri.dsTaint);
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.914 -0400", hash_original_method = "A975CD5E1392FBC42C40F56501282DDB", hash_generated_method = "F2C017FE7219E490DD9F6B8936BDE175")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IBinder newUriPermissionOwner(String name) throws RemoteException {
        dsTaint.addTaint(name);
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
        return (IBinder)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.915 -0400", hash_original_method = "1C35FE424D422C73471D9ECEE35C4093", hash_generated_method = "8F71D96908F954953E1C354ECBC268AA")
    @DSModeled(DSC.SPEC)
    public void grantUriPermissionFromOwner(IBinder owner, int fromUid, String targetPkg,
            Uri uri, int mode) throws RemoteException {
        dsTaint.addTaint(fromUid);
        dsTaint.addTaint(targetPkg);
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.916 -0400", hash_original_method = "D07898A73558FBA66858F774589B082E", hash_generated_method = "18075F30F5042EA0A8331452ED6E2B25")
    @DSModeled(DSC.SPEC)
    public void revokeUriPermissionFromOwner(IBinder owner, Uri uri,
            int mode) throws RemoteException {
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.917 -0400", hash_original_method = "3DAB9C9F42020370AD19E1FE0AC1BDCE", hash_generated_method = "9D91DE7C6DECBDC4B1F1008C7E33B19B")
    @DSModeled(DSC.SPEC)
    public int checkGrantUriPermission(int callingUid, String targetPkg,
            Uri uri, int modeFlags) throws RemoteException {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(targetPkg);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(callingUid);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.917 -0400", hash_original_method = "2510375C73B367DE6AAF634BB948BB50", hash_generated_method = "12E21D3F21EFE394547527CB71585E27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dumpHeap(String process, boolean managed,
            String path, ParcelFileDescriptor fd) throws RemoteException {
        dsTaint.addTaint(process);
        dsTaint.addTaint(managed);
        dsTaint.addTaint(path);
        dsTaint.addTaint(fd.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.918 -0400", hash_original_method = "D5FED7EEA920B3F53E1885BDA832FF44", hash_generated_method = "C2B3AD0DCD3FB4B58FF30CE9C2890A2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int startActivities(IApplicationThread caller,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(intents[0].dsTaint);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(resolvedTypes[0]);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.920 -0400", hash_original_method = "7A44848B4F4A570D7B280FD97AA3F11F", hash_generated_method = "816C2F5471F2A59E267D6688BB60BA14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int startActivitiesInPackage(int uid,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(intents[0].dsTaint);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(resolvedTypes[0]);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.922 -0400", hash_original_method = "11A1C93F201BB77459CE48D94392036A", hash_generated_method = "D934C5AAC8CD5B603B5051858B4E5B0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.923 -0400", hash_original_method = "984BA2CED473A0F45E8080D25CCDF41F", hash_generated_method = "0754638C837ABC79A18B604B032A55F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFrontActivityScreenCompatMode(int mode) throws RemoteException {
        dsTaint.addTaint(mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.924 -0400", hash_original_method = "AFAFCB6FF2EC7CDD310E0CDC4C512BE7", hash_generated_method = "6FA557D5056073DB5D210AB7CC0BF48B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPackageScreenCompatMode(String packageName) throws RemoteException {
        dsTaint.addTaint(packageName);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.925 -0400", hash_original_method = "5B0C9EEE90D8463E1DCC15B68E3829E8", hash_generated_method = "57F4C2CE5CDB534CD9DA47AEA6A68089")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPackageScreenCompatMode(String packageName, int mode) throws RemoteException {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.925 -0400", hash_original_method = "7AFCEC9BC7A2DAB54F3EFFA101044309", hash_generated_method = "C2CD44B7662F4641450EB03FF9E53AC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getPackageAskScreenCompat(String packageName) throws RemoteException {
        dsTaint.addTaint(packageName);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.926 -0400", hash_original_method = "8C9BAA94A3976358AA466F180A11AE45", hash_generated_method = "EA78E62D840160A38BF2730F91BF6230")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPackageAskScreenCompat(String packageName, boolean ask) throws RemoteException {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(ask);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.928 -0400", hash_original_method = "0A8E6FD2F20689E2107BCC0911A72467", hash_generated_method = "2BDD4287D540FC631E2462FA893A80A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean switchUser(int userid) throws RemoteException {
        dsTaint.addTaint(userid);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.929 -0400", hash_original_method = "4161F4F4B6F51E7616ED3E0F5DA99E10", hash_generated_method = "5317C103DD26EF971BAC00D66C58ABDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeSubTask(int taskId, int subTaskIndex) throws RemoteException {
        dsTaint.addTaint(subTaskIndex);
        dsTaint.addTaint(taskId);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.930 -0400", hash_original_method = "D75556E86E98C9E69E5D8B6835FF1B1D", hash_generated_method = "75E51F97D1469B301BEA2389F50D6D6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeTask(int taskId, int flags) throws RemoteException {
        dsTaint.addTaint(taskId);
        dsTaint.addTaint(flags);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.931 -0400", hash_original_method = "AD040AF08607A87C88C9CB9BE1E3C408", hash_generated_method = "265D7622E3F06C2456CF2891D5CB5D3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerProcessObserver(IProcessObserver observer) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.931 -0400", hash_original_method = "6FB2BE2D02A98F343D51290C94466533", hash_generated_method = "527A54D2B43C91093781954807313867")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterProcessObserver(IProcessObserver observer) throws RemoteException {
        dsTaint.addTaint(observer.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.932 -0400", hash_original_method = "A45994938B7DA24AED12FFC5B3B3DD69", hash_generated_method = "C36727F6F1AFE8EC0BB6F930B95FC5A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIntentSenderTargetedToPackage(IIntentSender sender) throws RemoteException {
        dsTaint.addTaint(sender.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.933 -0400", hash_original_method = "ACD180EA48DE1CCAABBA4B90AA3470B8", hash_generated_method = "29F870555D5948292693CCEBFCBB571F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updatePersistentConfiguration(Configuration values) throws RemoteException {
        dsTaint.addTaint(values.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.933 -0400", hash_original_method = "0E9D1ED4F0E7DC85612AA1E9A3EC65BE", hash_generated_method = "10B6A34C89E9E0CA3E3E987112E79D93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long[] getProcessPss(int[] pids) throws RemoteException {
        dsTaint.addTaint(pids[0]);
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
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.934 -0400", hash_original_method = "F6DDBF719DC0D2BCB3D721A826004A98", hash_generated_method = "5600B76EA515D86B981F7C7495987C06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showBootMessage(CharSequence msg, boolean always) throws RemoteException {
        dsTaint.addTaint(always);
        dsTaint.addTaint(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.934 -0400", hash_original_method = "C6C48FDB33104FCE337F1D8C3A233E89", hash_generated_method = "8A31AF607B349BB8BE78B082564FEFB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

