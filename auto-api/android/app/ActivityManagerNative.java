package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    static boolean sSystemReady = false;
    private static final Singleton<IActivityManager> gDefault = new Singleton<IActivityManager>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.112 -0400", hash_original_method = "DB2B8F5A0363FA0CE3E5AA87CCE94A22", hash_generated_method = "5F634EB5E7A91D65EEED9646F10827FF")
        @DSModeled(DSC.SAFE)
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.112 -0400", hash_original_method = "444DC66B3432907DFEA55328E5B69649", hash_generated_method = "30CD594F8BAA7A8B4311B57BDC55146C")
    @DSModeled(DSC.SAFE)
    public ActivityManagerNative() {
        attachInterface(this, descriptor);
        // ---------- Original Method ----------
        //attachInterface(this, descriptor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.113 -0400", hash_original_method = "2F0865077D68737A7D6F441D3CAC24D9", hash_generated_method = "C5B42A1DFCEB823A5136B429CF9AC9B1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.113 -0400", hash_original_method = "C581351462D87A5CA19EFFE73691D6B8", hash_generated_method = "8A940506F46A34A8E626D5A708A565C0")
    static public IActivityManager getDefault() {
        return gDefault.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.113 -0400", hash_original_method = "5FC4B6592318F4C948D38B5B79469552", hash_generated_method = "CE9217ADD286B0464C74DC335EE97C68")
    static public boolean isSystemReady() {
        if (!sSystemReady) {
            sSystemReady = getDefault().testIsSystemReady();
        }
        return sSystemReady;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.114 -0400", hash_original_method = "60868BAA36991408EA660689C2535FBD", hash_generated_method = "C6F9133322E85E6275008944D6F01C02")
    static public void broadcastStickyIntent(Intent intent, String permission) {
        try {
            getDefault().broadcastIntent(
                null, intent, null, null, Activity.RESULT_OK, null, null,
                null , false, true);
        } catch (RemoteException ex) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.114 -0400", hash_original_method = "966DD9810BB71B16CA7135B6EC37DFA9", hash_generated_method = "E166A6FE65574D56C7D063F976139987")
    static public void noteWakeupAlarm(PendingIntent ps) {
        try {
            getDefault().noteWakeupAlarm(ps.getTarget());
        } catch (RemoteException ex) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.135 -0400", hash_original_method = "796B52B1E8846F7CCEC22CD4B5B906A8", hash_generated_method = "C245D84D3CEAE6300820A3B2C400EDCC")
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_925494371 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1208993228 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_1917924451 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_93326975 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_859167292 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_900690897 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_573263410 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_1962001002 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_2060141108 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_184758331 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_678913429 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_205868448 = (data.readInt() != 0);
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
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_1129675894 = (super.onTransact(code, data, reply, flags));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.145 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "ACC1BEBA79475825CC8A93A9C0BD1CF3")
    @DSModeled(DSC.SAFE)
    public IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
}

class ActivityManagerProxy implements IActivityManager {
    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.146 -0400", hash_original_method = "3287CA7C2EB4AADDF2EFFF2704D2BE9E", hash_generated_method = "B93B19746CC1D1C185A3413052E62F35")
    @DSModeled(DSC.SAFE)
    public ActivityManagerProxy(IBinder remote) {
        dsTaint.addTaint(remote.dsTaint);
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.146 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "117DDE791BEA1B91BCA97AE8A36628B3")
    @DSModeled(DSC.SAFE)
    public IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.147 -0400", hash_original_method = "ECBE4259B26F016D18C1CACD48E02238", hash_generated_method = "CC68F77DB3BD6CAC7979465987DB411B")
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
        dsTaint.addTaint(autoStopProfiler);
        dsTaint.addTaint(profileFile);
        dsTaint.addTaint(debug);
        dsTaint.addTaint(resultWho);
        dsTaint.addTaint(grantedMode);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(grantedUriPermissions[0].dsTaint);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(profileFd.dsTaint);
        dsTaint.addTaint(resolvedType);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.148 -0400", hash_original_method = "BF42E410BABF1DD283EC1102C9637003", hash_generated_method = "E4E8110535E7C1A482E4ED69DF02A1F2")
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
        dsTaint.addTaint(autoStopProfiler);
        dsTaint.addTaint(profileFile);
        dsTaint.addTaint(debug);
        dsTaint.addTaint(resultWho);
        dsTaint.addTaint(grantedMode);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(grantedUriPermissions[0].dsTaint);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(profileFd.dsTaint);
        dsTaint.addTaint(resolvedType);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.149 -0400", hash_original_method = "47F7B475943E725D61EF4FCECF2C263D", hash_generated_method = "A4F94387626B06471AF157C4FC81BB6A")
    @DSModeled(DSC.SPEC)
    public int startActivityWithConfig(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, Configuration config) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(grantedUriPermissions[0].dsTaint);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(onlyIfNeeded);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(grantedMode);
        dsTaint.addTaint(resultWho);
        dsTaint.addTaint(debug);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.150 -0400", hash_original_method = "FD56EAF7591CCE02A2449EB3C30AEF02", hash_generated_method = "969A7408A455E1A62E2910E03E788532")
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
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(fillInIntent.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.151 -0400", hash_original_method = "A532370FCCB6C359BF27FA22D92F73F5", hash_generated_method = "EBBDFDC14C81800E57242F20E440C136")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.152 -0400", hash_original_method = "91E82D39E0DA0BAF3D9668B58FD8BE2D", hash_generated_method = "3B0F386B0E441F7D83ED3E28813D504D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.153 -0400", hash_original_method = "352728C633440E8BBFDE1A24B12C26C6", hash_generated_method = "236A56940993BF76E83E5C3B24EF321B")
    @DSModeled(DSC.SAFE)
    public void finishSubActivity(IBinder token, String resultWho, int requestCode) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(requestCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.154 -0400", hash_original_method = "03769BB85CE515FA0FB5B3DCD0709D8A", hash_generated_method = "C15A44C479519BEBD7740FBDEC9EC2BD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.155 -0400", hash_original_method = "D0EC9750E66DC0864B7AF9A5D43ED043", hash_generated_method = "9B7D740DA6370600207DC57C73D89A87")
    @DSModeled(DSC.SPEC)
    public Intent registerReceiver(IApplicationThread caller, String packageName,
            IIntentReceiver receiver,
            IntentFilter filter, String perm) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(receiver.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.155 -0400", hash_original_method = "CF62E9563222E9365AE1815E546E05AA", hash_generated_method = "2FB9F42755C2696ACE90777FDA78B2FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterReceiver(IIntentReceiver receiver) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.156 -0400", hash_original_method = "189D2A1B1A14BF35BFCC0BB8AD6C1CE5", hash_generated_method = "F590001B0D3C5021ED9E9A5737DE0457")
    @DSModeled(DSC.SPEC)
    public int broadcastIntent(IApplicationThread caller,
            Intent intent, String resolvedType,  IIntentReceiver resultTo,
            int resultCode, String resultData, Bundle map,
            String requiredPermission, boolean serialized,
            boolean sticky) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(resultData);
        dsTaint.addTaint(serialized);
        dsTaint.addTaint(sticky);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(map.dsTaint);
        dsTaint.addTaint(resolvedType);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(requiredPermission);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.157 -0400", hash_original_method = "84F4ECE33F63E245917246490F7877AA", hash_generated_method = "7C53B9C9E23DB1F651FD3CEC221A0740")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.158 -0400", hash_original_method = "8BFF18A0F9A8EDDD76A319C280B21CDC", hash_generated_method = "50F63A928BB397EF7C498FD03153BF9F")
    @DSModeled(DSC.SAFE)
    public void finishReceiver(IBinder who, int resultCode, String resultData, Bundle map, boolean abortBroadcast) throws RemoteException {
        dsTaint.addTaint(resultData);
        dsTaint.addTaint(abortBroadcast);
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(map.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.159 -0400", hash_original_method = "1E67E239E5F2A2540F1E032AB272605E", hash_generated_method = "0FE42CD215456332ADAB98F4C9896AA1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.159 -0400", hash_original_method = "BC9E49082B5DC06C707641FC7F3E31F5", hash_generated_method = "198929BBF27D65077DCEBFF8A489E956")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.159 -0400", hash_original_method = "4914FFC78B966DEBED0BDBFF9D70FB17", hash_generated_method = "F63B1F9C2B3410B9A4E631A71F9E4959")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.160 -0400", hash_original_method = "F5DE3AC45B6CCF74477AF45EB0878099", hash_generated_method = "C09E043F8A568EBDE872BBA0EC7062B9")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.160 -0400", hash_original_method = "CA8224B1DA5730B462FB3F604509C1DB", hash_generated_method = "BAEE1EF89DD345FAD107A9F73FF47627")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.161 -0400", hash_original_method = "9A100D49A0D535BB686DAA00CAC541FF", hash_generated_method = "25C1385D81FCECEF9ACB506AC6DD2500")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.161 -0400", hash_original_method = "7637EF2082F6942F953796EFCEAA3730", hash_generated_method = "70F6BFB85E0D129ABCD5FCDF6DC5E9A9")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.162 -0400", hash_original_method = "0E9D91A20FCD3BCFB3517DB475147FAB", hash_generated_method = "63C22BCA6623FF12D702F03864428BF3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.162 -0400", hash_original_method = "FAA1C4AE039868246AED533CDCA15CD7", hash_generated_method = "3B187183822A1E87ED7E3BDEA65ED93C")
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
                N--;
            } //End block
        } //End block
        data.recycle();
        reply.recycle();
        return (List)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.163 -0400", hash_original_method = "9D3E8FF17F102376D7C7BE9D34CE4F93", hash_generated_method = "C5A86ADACFBADC51E7BD9821CCD5D34D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.164 -0400", hash_original_method = "10D095A12B52FE928E4AEC7C3F42A832", hash_generated_method = "9E25804B64442FB791A1FAFA386881B8")
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
            boolean varB04A284F06B56929F38634A7F4C6A0D7_93687130 = (reply.readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.164 -0400", hash_original_method = "7671DD1471581027B2C414BE0E3CE4A6", hash_generated_method = "6B2028FA8A450F934A7ED87DE62EBDF5")
    @DSModeled(DSC.SAFE)
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
                N--;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.165 -0400", hash_original_method = "2AE453A6460D5AF368C9AC4C4862314B", hash_generated_method = "A87B6B5FAEEB28C9BCF46723743A2A63")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.165 -0400", hash_original_method = "8E45CD57BE18A4B76C3A3E0DA22BC8B7", hash_generated_method = "8DFD2579266E32B4C89F6598C6032E2D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.166 -0400", hash_original_method = "2FAC851B003A84469F94E88A81DA29C3", hash_generated_method = "107E507F53CB530A5CB915E75DF87132")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.166 -0400", hash_original_method = "DABF13B8F45F6A065880490CD0DBD1A0", hash_generated_method = "DDB9A26C6359E4263693328DA5FDBA1E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.166 -0400", hash_original_method = "7FFB6E49EA553237E0A3F53A2CDFD87F", hash_generated_method = "4C09F3794B3A07B65A1FB02304B537A3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.167 -0400", hash_original_method = "7F4F39C4D7AB58BCB5DB152705A9F80A", hash_generated_method = "98E3B8948CE58CA3B6E68549556CEC04")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.167 -0400", hash_original_method = "48BD6DC2300FE39DD3A4B34C3DD91993", hash_generated_method = "F2FA2FC59B103E0B192FEFE094FC5B73")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.168 -0400", hash_original_method = "3FABC29A3C68690EBF6B4F44EE4A5D23", hash_generated_method = "7658F650AC5E3C686775051AA41EA253")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.168 -0400", hash_original_method = "AF696C3AA9BD79AC1F2D6780E820F3FA", hash_generated_method = "9DA5E14544F18B1DF0BCDD2603351E83")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.169 -0400", hash_original_method = "4B3E31ABB8C007E1B3828F729DFD9393", hash_generated_method = "27A8D3EDA1550EA975044EC1087B6E9D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.169 -0400", hash_original_method = "EC6CF87E25124312A62325C5F062E996", hash_generated_method = "7EF95140A794E9F414D7C4A82009CA88")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.169 -0400", hash_original_method = "9C5D73DEFA4B6B21F8A4E01DC5E46521", hash_generated_method = "A9CBCDD3D5855B4DAD250988D9CC5EDC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.170 -0400", hash_original_method = "6E983079D2A10BB8E3DF4E66B032EE6D", hash_generated_method = "D5A149FC188C8B1540B87E0CF6B30F29")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.170 -0400", hash_original_method = "E5355EA6A0F8270964E816C69524096C", hash_generated_method = "FEFA23F808CA161FEE329D7D61F74E07")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.171 -0400", hash_original_method = "A683CF3BA039B3B97AA6ADC23E6FBDCC", hash_generated_method = "E3C3CC8061D6BC34BF5A49F83ED568E8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.171 -0400", hash_original_method = "B5D9E3A4F6ABA893303F2F02B64751B8", hash_generated_method = "C876434122A9F2A1B2AD3D8471CDFAB8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.172 -0400", hash_original_method = "DB1BCCF2CB5E2532E24072B1F607F963", hash_generated_method = "36763CC528CE16F661E8A50315DE426F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.172 -0400", hash_original_method = "9DE0D26C134349F3DA011E11517F3FF5", hash_generated_method = "8723E8FFE49C81C8A2808E1563B4C9F5")
    @DSModeled(DSC.SAFE)
    public void setServiceForeground(ComponentName className, IBinder token,
            int id, Notification notification, boolean removeNotification) throws RemoteException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(removeNotification);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.173 -0400", hash_original_method = "A1E6D6F237E88697017FA79FBE451840", hash_generated_method = "AA04AB472C7E63792E5D5796CFB23827")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.173 -0400", hash_original_method = "E0BD37EB96539E724DE863D335954DC9", hash_generated_method = "38D310A26338A32788898A6D93744942")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.174 -0400", hash_original_method = "87A207496B270585D5EEA34C1AF57170", hash_generated_method = "E9541155E5C5AA70A0827CA342ACD084")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.174 -0400", hash_original_method = "3796516624A8D493E471933ECF7A3CD3", hash_generated_method = "85F17004D8948AF3D8ECC2A43F6CE4D8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.175 -0400", hash_original_method = "1CB80C62A00C622E35F1B57A132292E9", hash_generated_method = "BF561A4323424DB78120561F0618F57C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.175 -0400", hash_original_method = "BEF476EE5F43517187661CDC39F2A448", hash_generated_method = "5280CB63B4C266213C940776879C16C6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.175 -0400", hash_original_method = "7AACC08C389BEE0061373162626F356D", hash_generated_method = "12FD4E600EB02CF703A8BF8F49CFDAD2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.176 -0400", hash_original_method = "ADE4561AB0FC3828104C329F05A9B88C", hash_generated_method = "13568CB7C69AD3BC61D4F79B4A9C563B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.176 -0400", hash_original_method = "80BB0DB939AA2A14DC79CE879293739F", hash_generated_method = "5E5975CEC10A9AFDB17FB1757DC01838")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.177 -0400", hash_original_method = "7977DF3866173BBD9227641CB70C5B9A", hash_generated_method = "8C3E25AC077581CD3E786F0C92A0D48D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startInstrumentation(ComponentName className, String profileFile,
            int flags, Bundle arguments, IInstrumentationWatcher watcher) throws RemoteException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(arguments.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.177 -0400", hash_original_method = "D76B5F1B397FC7028B59F12CA3604783", hash_generated_method = "492A497C09453E10378E9BACDEE0883F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishInstrumentation(IApplicationThread target,
            int resultCode, Bundle results) throws RemoteException {
        dsTaint.addTaint(results.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(resultCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.178 -0400", hash_original_method = "E824FA9DB2D76671E24682EC782F4756", hash_generated_method = "69C01CA385D3A75A3EE205D46926BF80")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.178 -0400", hash_original_method = "76911A2717FEEEC7D6B4E93DC7F2427C", hash_generated_method = "7CF2CA9D87215C9A34E95239456F9DAF")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.179 -0400", hash_original_method = "65FC5D17EF9FF3BF1BFFDA9CCA9A4BE1", hash_generated_method = "D2BAB516206DD395D0AAE62DA64D8EFD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.179 -0400", hash_original_method = "505D3FD7966F547E2BAA16E1C1C5F05B", hash_generated_method = "728548D7403AB3FC9DC370128096C32A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.179 -0400", hash_original_method = "BCB55F79D75B3B83E49A75043EE249A9", hash_generated_method = "623E3D1F39FB8B0C4FEFA4764FA47530")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.180 -0400", hash_original_method = "9BAE752D062408101ED2F689CF20DDD1", hash_generated_method = "0E1C609DF05FBAEC9455CD4117589328")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.180 -0400", hash_original_method = "AE56AE3D6914251F9FFFA7E33C698EB6", hash_generated_method = "1D2691C7F636DE8358F62A26DDD8AD7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IIntentSender getIntentSender(int type,
            String packageName, IBinder token, String resultWho,
            int requestCode, Intent[] intents, String[] resolvedTypes, int flags) throws RemoteException {
        dsTaint.addTaint(intents[0].dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(resultWho);
        dsTaint.addTaint(resolvedTypes);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.181 -0400", hash_original_method = "D459AA1ADAE84FC2B7BB3BA73C047FDB", hash_generated_method = "71978516D025D64CA1003C2C64E7F0C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.181 -0400", hash_original_method = "1993496C4F183452017D412A9B9C5C29", hash_generated_method = "A262C26261344A8F02710F2BEFD1204B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.182 -0400", hash_original_method = "92B622DC0CB7ED23BB116E8953A0A90A", hash_generated_method = "C1D4B8D65591A66D0B537DDEB9CBF9A7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.182 -0400", hash_original_method = "4FA932EFF1C9BAC6AA973FE979D6B75F", hash_generated_method = "FA06C5EC971362F5D91332A1B48FCBF2")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.182 -0400", hash_original_method = "16F5E36D0F576E8CD2EC3F6B33B5169D", hash_generated_method = "2A50D8B8B8E777455FD1085C3BE5E99D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.183 -0400", hash_original_method = "A50C503DC3495EB643680A38372DD1F5", hash_generated_method = "0B4558EE8E4905A3E6187C728BFA84D9")
    @DSModeled(DSC.SAFE)
    public int checkPermission(String permission, int pid, int uid) throws RemoteException {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(permission);
        dsTaint.addTaint(pid);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.183 -0400", hash_original_method = "BE5C38AE92A5EE5CE45944FF93295090", hash_generated_method = "E7AFA44D352A0D7DEB7C8B4E6B5B271E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clearApplicationUserData(final String packageName,
            final IPackageDataObserver observer) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.184 -0400", hash_original_method = "FEF4F93E5B02F55707A11B36638BBB59", hash_generated_method = "D1FCD611AC93EA346F263366BD08B23A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.184 -0400", hash_original_method = "2CEB2CA82A36297F49BF5DB3286E579B", hash_generated_method = "4DEB2F7FE83555248D4BCF923ADDC207")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.185 -0400", hash_original_method = "84D534ABCBC85608735C63399D2C9E1E", hash_generated_method = "DD8EF6395103B40CE801BEAF9E097887")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.185 -0400", hash_original_method = "7FC96553233904C2463E3D793E528211", hash_generated_method = "B22808D3FB2A1ED349DAC3CECA093F5A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.186 -0400", hash_original_method = "40DDB58D1BE7B54E85772ACF1AA60D8F", hash_generated_method = "A2AF7ACB7256FDFE2BAF8B26DBDB643D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.186 -0400", hash_original_method = "805F881D84830966D1AD0B083D69DA9A", hash_generated_method = "67E69D1FEE61F1F57A0A7F9030D04920")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.187 -0400", hash_original_method = "1E46E6C9628834765008140B25990D23", hash_generated_method = "66FEE9714124F096C85ADF5CE2F151F3")
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
            boolean varB04A284F06B56929F38634A7F4C6A0D7_1731953791 = (reply.readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.187 -0400", hash_original_method = "E3BC510BF36E68FD23494212AB6E7B33", hash_generated_method = "2A81B783B4C313B5650DE44BAB4430F5")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.187 -0400", hash_original_method = "CAFF51A84FC631E180A23D0F5290B43F", hash_generated_method = "2B6BE591B6182B82FADB6F72EA1A9541")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.188 -0400", hash_original_method = "482C4468B37AD6CEF12EA376A273F16E", hash_generated_method = "30FE926BC1241DBBB0D04453D5C07547")
    @DSModeled(DSC.SAFE)
    public void setDebugApp(
        String packageName, boolean waitForDebugger, boolean persistent) throws RemoteException {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(persistent);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.188 -0400", hash_original_method = "DE27B8A416D8E1FF87F079AFA1567A6E", hash_generated_method = "C67CB1C0418A38130483B4900B0C9E60")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.188 -0400", hash_original_method = "D7DBDAD7386DC1F45D7A9AB12513A49B", hash_generated_method = "966B23DB98A6A28162EF954D37F5B6F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.189 -0400", hash_original_method = "FF7EEF7728CACAD7286D113A3CF07513", hash_generated_method = "54ACAD2DB830A980853103620F39B865")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.189 -0400", hash_original_method = "72F87C80970F6885E4DCD6DA1B2F19E8", hash_generated_method = "E33958316F1E5F8D214976D541A68ABA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.190 -0400", hash_original_method = "DB2721BD1E4C8F1064AA0461CF2A490B", hash_generated_method = "7A6A64590408FBF7D919AC23E2A38404")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean killPids(int[] pids, String reason, boolean secure) throws RemoteException {
        dsTaint.addTaint(pids);
        dsTaint.addTaint(reason);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.190 -0400", hash_original_method = "9964526F9DDC53538E50ED934A9D4009", hash_generated_method = "C2EF8DF6EB90ABF5B16DA727A97672F1")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.190 -0400", hash_original_method = "6C8B2FE75A3BFFE16EADA916F678A09D", hash_generated_method = "784AB7847DEB4495A44921651C6BB7EB")
    @DSModeled(DSC.SAFE)
    public boolean testIsSystemReady() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.191 -0400", hash_original_method = "523AF9597115E332AF2A1F534C49483C", hash_generated_method = "B105E5039AF6BFAC09A0044BDE492B76")
    @DSModeled(DSC.SAFE)
    public void handleApplicationCrash(IBinder app,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.191 -0400", hash_original_method = "84EFC78EC4B379D270C222A7BC31C5F7", hash_generated_method = "249575D1FCA2A7FB146964943F6E6DE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handleApplicationWtf(IBinder app, String tag,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.192 -0400", hash_original_method = "7AC27E481709B1F0B25AE2BA23B3BECF", hash_generated_method = "F0977F95DE4C42BC35FA73739A2A9066")
    @DSModeled(DSC.SAFE)
    public void handleApplicationStrictModeViolation(IBinder app,
            int violationMask,
            StrictMode.ViolationInfo info) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(app.dsTaint);
        dsTaint.addTaint(violationMask);
        dsTaint.addTaint(info.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.192 -0400", hash_original_method = "22BD8EFAE7A36DA76D8B0F7F297E970D", hash_generated_method = "CAAFE057E6C47282227B2F1447CD17D1")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.192 -0400", hash_original_method = "3D80332C8A0FCAFBCE220FADA30302CB", hash_generated_method = "D24B167F43561ED4A19240D2924EAAB4")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.193 -0400", hash_original_method = "C7F5D3EA775AD04DD438191F0B4D22C4", hash_generated_method = "640E17E0A5937ECFE02F00E24D30F03C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.193 -0400", hash_original_method = "CB4D9E734B2DC6A00C763BA9D15D84CC", hash_generated_method = "18425EC1243D997DA6ECFBC70F0E6906")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.194 -0400", hash_original_method = "9F4AADDAC8F1648FD8C80C6B88BBF25F", hash_generated_method = "EE458C6B24B72B882C12BECE18EFC105")
    @DSModeled(DSC.SAFE)
    public ConfigurationInfo getDeviceConfigurationInfo() throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.194 -0400", hash_original_method = "10D7A082C97EAFB331405B7841F1651D", hash_generated_method = "9C719EFEFC0489F297DEAE06B730AF6B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.195 -0400", hash_original_method = "52F9DB0BA2A0AB8C52093D208807035C", hash_generated_method = "7EEB2225F0C35739E002A94828257952")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.195 -0400", hash_original_method = "BE7DD92CBAD030A60DB7090E3408574C", hash_generated_method = "E50E1E32B91F26749E07F8A0858BF1DC")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.195 -0400", hash_original_method = "0EC9793095E20007EC76AB5DDDE4E54A", hash_generated_method = "71553085449D6A29F93E1EE388313011")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.196 -0400", hash_original_method = "7B78E2FEC61CC471A8E07C6C34C74BD6", hash_generated_method = "13724491DA7B0266AFC8E048E1A4E231")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.196 -0400", hash_original_method = "8E5D6F085FE02A1442C5A617ADA012EC", hash_generated_method = "7A5D314E0F91307F72729A7AC91F8946")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterActivityWatcher(IActivityWatcher watcher) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.197 -0400", hash_original_method = "C65F778BCD540838D47FE4E4412CD25E", hash_generated_method = "D47A264E52CE11FD9B17C8C97ECD6B8E")
    @DSModeled(DSC.SPEC)
    public int startActivityInPackage(int uid,
            Intent intent, String resolvedType, IBinder resultTo,
            String resultWho, int requestCode, boolean onlyIfNeeded) throws RemoteException {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(onlyIfNeeded);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.197 -0400", hash_original_method = "9BA7CBE5CC5118373D7AAA1497A47635", hash_generated_method = "E05CEA6BC6234F36F894E0ABAFCCBD3A")
    @DSModeled(DSC.SAFE)
    public void killApplicationWithUid(String pkg, int uid) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.197 -0400", hash_original_method = "2A680A4513BB1B95074F3F876F148BA8", hash_generated_method = "A964DFB03F1E116B40B4A427D752FA4B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.198 -0400", hash_original_method = "BD88F62F5112FCE1DE930509EBB83FD2", hash_generated_method = "31ADCDB185FBAE47DD3C1345BEB2540E")
    @DSModeled(DSC.SAFE)
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) throws RemoteException {
        dsTaint.addTaint(pids);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.198 -0400", hash_original_method = "0F16B6E02208618C1D3EE91B8DD80482", hash_generated_method = "CC6D99FE47B640E04F95B233F508E4BC")
    @DSModeled(DSC.SAFE)
    public void killApplicationProcess(String processName, int uid) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.199 -0400", hash_original_method = "00D6B54E331AC7AA3DC1F40B928FA3FD", hash_generated_method = "0CAED4F3C948C5F0C7F20F19A96B3A0C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.199 -0400", hash_original_method = "0F906B538EF84DE09E15BAB8CDAE69C4", hash_generated_method = "208694F24402F9168CCB9511A0350DC4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.199 -0400", hash_original_method = "CE9EE2ABB9C16E19ED0FB5ECED80A2D8", hash_generated_method = "EC77879103AB2979510755CACEC0BEC9")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.200 -0400", hash_original_method = "468B67BFEE008B6CDEC37F42802988FA", hash_generated_method = "2FAAC77C035082A592C3CB5ACB228386")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.200 -0400", hash_original_method = "12E814937BEB239BDABA8A5EE4F6D00D", hash_generated_method = "A8F1E4758CEF05F6132414C373090703")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.201 -0400", hash_original_method = "0342E1772D9E2D527D167E41870AA176", hash_generated_method = "CAF2E87D6DCE386EF3E5824F34F02C94")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.201 -0400", hash_original_method = "574D561A4B99545A454A313F9DD764D8", hash_generated_method = "54CC419C1854B6059AD38F8059020462")
    @DSModeled(DSC.SAFE)
    public void crashApplication(int uid, int initialPid, String packageName,
            String message) throws RemoteException {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(message);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.201 -0400", hash_original_method = "CF06029063749F4266D5EFBB16694E04", hash_generated_method = "710E9B7BDE06825D63C8590377A0DB53")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.202 -0400", hash_original_method = "A975CD5E1392FBC42C40F56501282DDB", hash_generated_method = "241ECC7D8D1A22865717290C10804425")
    @DSModeled(DSC.SAFE)
    public IBinder newUriPermissionOwner(String name) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.202 -0400", hash_original_method = "1C35FE424D422C73471D9ECEE35C4093", hash_generated_method = "87F369FCF0E07B2AA7C2AF37D5DFDCD5")
    @DSModeled(DSC.SPEC)
    public void grantUriPermissionFromOwner(IBinder owner, int fromUid, String targetPkg,
            Uri uri, int mode) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.203 -0400", hash_original_method = "D07898A73558FBA66858F774589B082E", hash_generated_method = "1ABF942FE96175673468AF37ED280FA9")
    @DSModeled(DSC.SPEC)
    public void revokeUriPermissionFromOwner(IBinder owner, Uri uri,
            int mode) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.203 -0400", hash_original_method = "3DAB9C9F42020370AD19E1FE0AC1BDCE", hash_generated_method = "538123456B016536EECABC1FF609BA31")
    @DSModeled(DSC.SPEC)
    public int checkGrantUriPermission(int callingUid, String targetPkg,
            Uri uri, int modeFlags) throws RemoteException {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(targetPkg);
        dsTaint.addTaint(callingUid);
        dsTaint.addTaint(uri.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.204 -0400", hash_original_method = "2510375C73B367DE6AAF634BB948BB50", hash_generated_method = "6AFC1C91CF01098E65848FD4CB1D425C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.204 -0400", hash_original_method = "D5FED7EEA920B3F53E1885BDA832FF44", hash_generated_method = "A376B22B0404DDB3620B99E1CC6B2378")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int startActivities(IApplicationThread caller,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(intents[0].dsTaint);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(resolvedTypes);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.205 -0400", hash_original_method = "7A44848B4F4A570D7B280FD97AA3F11F", hash_generated_method = "A4814C7B044B0B13A19A06057EA4BBB0")
    @DSModeled(DSC.SAFE)
    public int startActivitiesInPackage(int uid,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(intents[0].dsTaint);
        dsTaint.addTaint(resultTo.dsTaint);
        dsTaint.addTaint(resolvedTypes);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.205 -0400", hash_original_method = "11A1C93F201BB77459CE48D94392036A", hash_generated_method = "EDDFA11B0855525DE8245684525B1C8A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.205 -0400", hash_original_method = "984BA2CED473A0F45E8080D25CCDF41F", hash_generated_method = "1C1D94F1DCDBD1A395EAF39537FF235C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.206 -0400", hash_original_method = "AFAFCB6FF2EC7CDD310E0CDC4C512BE7", hash_generated_method = "6FCE35F672EF7803BB1ABE6417C04ED4")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.206 -0400", hash_original_method = "5B0C9EEE90D8463E1DCC15B68E3829E8", hash_generated_method = "F9DB8BDB790C6A20DCCB2A75625C3228")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.207 -0400", hash_original_method = "7AFCEC9BC7A2DAB54F3EFFA101044309", hash_generated_method = "B9F322E75738320BFAEA86988148376E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.207 -0400", hash_original_method = "8C9BAA94A3976358AA466F180A11AE45", hash_generated_method = "7C03B2C1BD13AF9791F6E56CDEA43B49")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.207 -0400", hash_original_method = "0A8E6FD2F20689E2107BCC0911A72467", hash_generated_method = "19C96DB5EA930E0386D8D698A1C9AD82")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.208 -0400", hash_original_method = "4161F4F4B6F51E7616ED3E0F5DA99E10", hash_generated_method = "52FC5CD2E2EEF49E5DC58FF5CA0CE825")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeSubTask(int taskId, int subTaskIndex) throws RemoteException {
        dsTaint.addTaint(taskId);
        dsTaint.addTaint(subTaskIndex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.208 -0400", hash_original_method = "D75556E86E98C9E69E5D8B6835FF1B1D", hash_generated_method = "DBE95F600346C6541BF064D9AB19915B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.209 -0400", hash_original_method = "AD040AF08607A87C88C9CB9BE1E3C408", hash_generated_method = "216B005BBF418B91112A86F67527C850")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.209 -0400", hash_original_method = "6FB2BE2D02A98F343D51290C94466533", hash_generated_method = "2381AD93721DE6D0D00A5FDD3252A832")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterProcessObserver(IProcessObserver observer) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.210 -0400", hash_original_method = "A45994938B7DA24AED12FFC5B3B3DD69", hash_generated_method = "40657F16404DABA4A5F933DFE3A8BC50")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.210 -0400", hash_original_method = "ACD180EA48DE1CCAABBA4B90AA3470B8", hash_generated_method = "CAE054A6C0F003AB2C27B5975F083B77")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.210 -0400", hash_original_method = "0E9D1ED4F0E7DC85612AA1E9A3EC65BE", hash_generated_method = "164275A62A5A042327CDEF3D445DEF1C")
    @DSModeled(DSC.SAFE)
    public long[] getProcessPss(int[] pids) throws RemoteException {
        dsTaint.addTaint(pids);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.211 -0400", hash_original_method = "F6DDBF719DC0D2BCB3D721A826004A98", hash_generated_method = "777E088A18AF17C8E50E9FFD2EE6B723")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.211 -0400", hash_original_method = "C6C48FDB33104FCE337F1D8C3A233E89", hash_generated_method = "900A830BA78A161FBBC1C4E9C1664CD8")
    @DSModeled(DSC.SAFE)
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


