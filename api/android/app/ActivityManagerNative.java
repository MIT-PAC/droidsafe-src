package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.103 -0400", hash_original_method = "444DC66B3432907DFEA55328E5B69649", hash_generated_method = "FF0B4D083A157B879D7CD5A2215454A9")
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

    
        @DSModeled(DSC.SPEC)
    static public void broadcastStickyIntent(Intent intent, String permission) {
        try {
            getDefault().broadcastIntent(
                null, intent, null, null, Activity.RESULT_OK, null, null,
                null , false, true);
        } catch (RemoteException ex) {
        }
    }

    
        @DSModeled(DSC.BAN)
    static public void noteWakeupAlarm(PendingIntent ps) {
        try {
            getDefault().noteWakeupAlarm(ps.getTarget());
        } catch (RemoteException ex) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.151 -0400", hash_original_method = "796B52B1E8846F7CCEC22CD4B5B906A8", hash_generated_method = "10A0EFF57C035419FA86DE954940F1D1")
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(flags);
        addTaint(reply.getTaint());
        addTaint(data.getTaint());
        addTaint(code);
switch(code){
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
            boolean varB326B5062B2F0E69046810717534CB09_576421403 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_729849800 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_729849800;
        } //End block
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
            boolean varB326B5062B2F0E69046810717534CB09_73474230 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1397847459 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1397847459;
        } //End block
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
            boolean varB326B5062B2F0E69046810717534CB09_451893038 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295584197 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_295584197;
        } //End block
        case START_ACTIVITY_INTENT_SENDER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            IntentSender intent = IntentSender.CREATOR.createFromParcel(data);
            Intent fillInIntent = null;
    if(data.readInt() != 0)            
            {
                fillInIntent = Intent.CREATOR.createFromParcel(data);
            } //End block
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
            boolean varB326B5062B2F0E69046810717534CB09_1373170179 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695642434 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_695642434;
        } //End block
        case START_NEXT_MATCHING_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder callingActivity = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            boolean result = startNextMatchingActivity(callingActivity, intent);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1884017513 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_132204306 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_132204306;
        } //End block
        case FINISH_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Intent resultData = null;
            int resultCode = data.readInt();
    if(data.readInt() != 0)            
            {
                resultData = Intent.CREATOR.createFromParcel(data);
            } //End block
            boolean res = finishActivity(token, resultCode, resultData);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_756409053 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_728325357 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_728325357;
        } //End block
        case FINISH_SUB_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            String resultWho = data.readString();
            int requestCode = data.readInt();
            finishSubActivity(token, resultWho, requestCode);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_753875157 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824143774 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_824143774;
        } //End block
        case WILL_ACTIVITY_BE_VISIBLE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean res = willActivityBeVisible(token);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_15694179 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1834013492 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1834013492;
        } //End block
        case REGISTER_RECEIVER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = b != null ? ApplicationThreadNative.asInterface(b) : null;
            String packageName = data.readString();
            b = data.readStrongBinder();
            IIntentReceiver rec = b != null ? IIntentReceiver.Stub.asInterface(b) : null;
            IntentFilter filter = IntentFilter.CREATOR.createFromParcel(data);
            String perm = data.readString();
            Intent intent = registerReceiver(app, packageName, rec, filter, perm);
            reply.writeNoException();
    if(intent != null)            
            {
                reply.writeInt(1);
                intent.writeToParcel(reply, 0);
            } //End block
            else
            {
                reply.writeInt(0);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_567243937 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2097549622 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2097549622;
        } //End block
        case UNREGISTER_RECEIVER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
    if(b == null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_464001498 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435471164 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_435471164;
            } //End block
            IIntentReceiver rec = IIntentReceiver.Stub.asInterface(b);
            unregisterReceiver(rec);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_959204347 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_767051419 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_767051419;
        } //End block
        case BROADCAST_INTENT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = b != null ? ApplicationThreadNative.asInterface(b) : null;
            Intent intent = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            b = data.readStrongBinder();
            IIntentReceiver resultTo = b != null ? IIntentReceiver.Stub.asInterface(b) : null;
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
            boolean varB326B5062B2F0E69046810717534CB09_1025344819 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_134995448 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_134995448;
        } //End block
        case UNBROADCAST_INTENT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = b != null ? ApplicationThreadNative.asInterface(b) : null;
            Intent intent = Intent.CREATOR.createFromParcel(data);
            unbroadcastIntent(app, intent);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1860244494 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_391895967 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_391895967;
        } //End block
        case FINISH_RECEIVER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder who = data.readStrongBinder();
            int resultCode = data.readInt();
            String resultData = data.readString();
            Bundle resultExtras = data.readBundle();
            boolean resultAbort = data.readInt() != 0;
    if(who != null)            
            {
                finishReceiver(who, resultCode, resultData, resultExtras, resultAbort);
            } //End block
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_630413850 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_892814343 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_892814343;
        } //End block
        case ATTACH_APPLICATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IApplicationThread app = ApplicationThreadNative.asInterface(
                    data.readStrongBinder());
    if(app != null)            
            {
                attachApplication(app);
            } //End block
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1793778655 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_108779545 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_108779545;
        } //End block
        case ACTIVITY_IDLE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Configuration config = null;
    if(data.readInt() != 0)            
            {
                config = Configuration.CREATOR.createFromParcel(data);
            } //End block
            boolean stopProfiling = data.readInt() != 0;
    if(token != null)            
            {
                activityIdle(token, config, stopProfiling);
            } //End block
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1643097924 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659791209 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_659791209;
        } //End block
        case ACTIVITY_PAUSED_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activityPaused(token);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1591369391 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803490738 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803490738;
        } //End block
        case ACTIVITY_STOPPED_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Bundle map = data.readBundle();
            Bitmap thumbnail = data.readInt() != 0
                ? Bitmap.CREATOR.createFromParcel(data) : null;
            CharSequence description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            activityStopped(token, map, thumbnail, description);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_344555766 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_730025327 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_730025327;
        } //End block
        case ACTIVITY_SLEPT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activitySlept(token);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1512144852 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1831040796 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1831040796;
        } //End block
        case ACTIVITY_DESTROYED_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activityDestroyed(token);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1718110149 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_788089342 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_788089342;
        } //End block
        case GET_CALLING_PACKAGE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            String res = token != null ? getCallingPackage(token) : null;
            reply.writeNoException();
            reply.writeString(res);
            boolean varB326B5062B2F0E69046810717534CB09_157744195 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972075565 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_972075565;
        } //End block
        case GET_CALLING_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName cn = getCallingActivity(token);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
            boolean varB326B5062B2F0E69046810717534CB09_1723004883 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101456139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_101456139;
        } //End block
        case GET_TASKS_TRANSACTION:
        {
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
for(i=0;i<N;i++)
            {
                ActivityManager.RunningTaskInfo info = (ActivityManager.RunningTaskInfo)list.get(i);
                info.writeToParcel(reply, 0);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1519375229 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236285240 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236285240;
        } //End block
        case GET_RECENT_TASKS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int maxNum = data.readInt();
            int fl = data.readInt();
            List<ActivityManager.RecentTaskInfo> list = getRecentTasks(maxNum,
                    fl);
            reply.writeNoException();
            reply.writeTypedList(list);
            boolean varB326B5062B2F0E69046810717534CB09_801223189 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708763605 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708763605;
        } //End block
        case GET_TASK_THUMBNAILS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int id = data.readInt();
            ActivityManager.TaskThumbnails bm = getTaskThumbnails(id);
            reply.writeNoException();
    if(bm != null)            
            {
                reply.writeInt(1);
                bm.writeToParcel(reply, 0);
            } //End block
            else
            {
                reply.writeInt(0);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_609607361 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190486332 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_190486332;
        } //End block
        case GET_SERVICES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int maxNum = data.readInt();
            int fl = data.readInt();
            List list = getServices(maxNum, fl);
            reply.writeNoException();
            int N = list != null ? list.size() : -1;
            reply.writeInt(N);
            int i;
for(i=0;i<N;i++)
            {
                ActivityManager.RunningServiceInfo info = (ActivityManager.RunningServiceInfo)list.get(i);
                info.writeToParcel(reply, 0);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_19921000 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146040347 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146040347;
        } //End block
        case GET_PROCESSES_IN_ERROR_STATE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ActivityManager.ProcessErrorStateInfo> list = getProcessesInErrorState();
            reply.writeNoException();
            reply.writeTypedList(list);
            boolean varB326B5062B2F0E69046810717534CB09_10050107 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497771753 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_497771753;
        } //End block
        case GET_RUNNING_APP_PROCESSES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ActivityManager.RunningAppProcessInfo> list = getRunningAppProcesses();
            reply.writeNoException();
            reply.writeTypedList(list);
            boolean varB326B5062B2F0E69046810717534CB09_1501210975 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631414841 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631414841;
        } //End block
        case GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ApplicationInfo> list = getRunningExternalApplications();
            reply.writeNoException();
            reply.writeTypedList(list);
            boolean varB326B5062B2F0E69046810717534CB09_922935285 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1878893784 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1878893784;
        } //End block
        case MOVE_TASK_TO_FRONT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            int fl = data.readInt();
            moveTaskToFront(task, fl);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_527015819 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1305774715 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1305774715;
        } //End block
        case MOVE_TASK_TO_BACK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            moveTaskToBack(task);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1193074786 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030683028 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030683028;
        } //End block
        case MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean nonRoot = data.readInt() != 0;
            boolean res = moveActivityTaskToBack(token, nonRoot);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1320922627 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_362539800 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_362539800;
        } //End block
        case MOVE_TASK_BACKWARDS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            moveTaskBackwards(task);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1903053948 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1172683356 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1172683356;
        } //End block
        case GET_TASK_FOR_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean onlyRoot = data.readInt() != 0;
            int res = token != null
                ? getTaskForActivity(token, onlyRoot) : -1;
            reply.writeNoException();
            reply.writeInt(res);
            boolean varB326B5062B2F0E69046810717534CB09_57780864 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1772871826 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1772871826;
        } //End block
        case FINISH_OTHER_INSTANCES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName className = ComponentName.readFromParcel(data);
            finishOtherInstances(token, className);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1089786377 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_199799836 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_199799836;
        } //End block
        case REPORT_THUMBNAIL_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Bitmap thumbnail = data.readInt() != 0
                ? Bitmap.CREATOR.createFromParcel(data) : null;
            CharSequence description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            reportThumbnail(token, thumbnail, description);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1376582349 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057396727 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057396727;
        } //End block
        case GET_CONTENT_PROVIDER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            String name = data.readString();
            ContentProviderHolder cph = getContentProvider(app, name);
            reply.writeNoException();
    if(cph != null)            
            {
                reply.writeInt(1);
                cph.writeToParcel(reply, 0);
            } //End block
            else
            {
                reply.writeInt(0);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_2082675066 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1124558781 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1124558781;
        } //End block
        case PUBLISH_CONTENT_PROVIDERS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            ArrayList<ContentProviderHolder> providers = data.createTypedArrayList(ContentProviderHolder.CREATOR);
            publishContentProviders(app, providers);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_900360077 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26432670 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_26432670;
        } //End block
        case REMOVE_CONTENT_PROVIDER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            String name = data.readString();
            removeContentProvider(app, name);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1442887370 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650194426 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650194426;
        } //End block
        case GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName comp = ComponentName.CREATOR.createFromParcel(data);
            PendingIntent pi = getRunningServiceControlPanel(comp);
            reply.writeNoException();
            PendingIntent.writePendingIntentOrNullToParcel(pi, reply);
            boolean varB326B5062B2F0E69046810717534CB09_1232811132 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001205960 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001205960;
        } //End block
        case START_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Intent service = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            ComponentName cn = startService(app, service, resolvedType);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
            boolean varB326B5062B2F0E69046810717534CB09_1497367245 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136617213 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136617213;
        } //End block
        case STOP_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Intent service = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            int res = stopService(app, service, resolvedType);
            reply.writeNoException();
            reply.writeInt(res);
            boolean varB326B5062B2F0E69046810717534CB09_1004241920 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056991504 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056991504;
        } //End block
        case STOP_SERVICE_TOKEN_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName className = ComponentName.readFromParcel(data);
            IBinder token = data.readStrongBinder();
            int startId = data.readInt();
            boolean res = stopServiceToken(className, token, startId);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_363628813 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_412540371 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_412540371;
        } //End block
        case SET_SERVICE_FOREGROUND_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName className = ComponentName.readFromParcel(data);
            IBinder token = data.readStrongBinder();
            int id = data.readInt();
            Notification notification = null;
    if(data.readInt() != 0)            
            {
                notification = Notification.CREATOR.createFromParcel(data);
            } //End block
            boolean removeNotification = data.readInt() != 0;
            setServiceForeground(className, token, id, notification, removeNotification);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_591672829 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1311603907 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1311603907;
        } //End block
        case BIND_SERVICE_TRANSACTION:
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
            boolean varB326B5062B2F0E69046810717534CB09_1106719206 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2030632785 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2030632785;
        } //End block
        case UNBIND_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IServiceConnection conn = IServiceConnection.Stub.asInterface(b);
            boolean res = unbindService(conn);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_827161773 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_627231035 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_627231035;
        } //End block
        case PUBLISH_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            IBinder service = data.readStrongBinder();
            publishService(token, intent, service);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_284395618 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1751975639 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1751975639;
        } //End block
        case UNBIND_FINISHED_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            boolean doRebind = data.readInt() != 0;
            unbindFinished(token, intent, doRebind);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1384713259 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398967011 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398967011;
        } //End block
        case SERVICE_DONE_EXECUTING_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int type = data.readInt();
            int startId = data.readInt();
            int res = data.readInt();
            serviceDoneExecuting(token, type, startId, res);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1525759297 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763907689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763907689;
        } //End block
        case START_INSTRUMENTATION_TRANSACTION:
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
            boolean varB326B5062B2F0E69046810717534CB09_1782773651 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_51194258 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_51194258;
        } //End block
        case FINISH_INSTRUMENTATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            int resultCode = data.readInt();
            Bundle results = data.readBundle();
            finishInstrumentation(app, resultCode, results);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_930514113 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711232987 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711232987;
        } //End block
        case GET_CONFIGURATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = getConfiguration();
            reply.writeNoException();
            config.writeToParcel(reply, 0);
            boolean varB326B5062B2F0E69046810717534CB09_1484720051 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1037814375 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1037814375;
        } //End block
        case UPDATE_CONFIGURATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            updateConfiguration(config);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1480634852 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1718180315 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1718180315;
        } //End block
        case SET_REQUESTED_ORIENTATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int requestedOrientation = data.readInt();
            setRequestedOrientation(token, requestedOrientation);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_954119452 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_89091587 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_89091587;
        } //End block
        case GET_REQUESTED_ORIENTATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int req = getRequestedOrientation(token);
            reply.writeNoException();
            reply.writeInt(req);
            boolean varB326B5062B2F0E69046810717534CB09_519337857 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1765470625 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1765470625;
        } //End block
        case GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName cn = getActivityClassForToken(token);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
            boolean varB326B5062B2F0E69046810717534CB09_915472639 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396417197 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396417197;
        } //End block
        case GET_PACKAGE_FOR_TOKEN_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            reply.writeNoException();
            reply.writeString(getPackageForToken(token));
            boolean varB326B5062B2F0E69046810717534CB09_1886607844 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_515020285 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_515020285;
        } //End block
        case GET_INTENT_SENDER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int type = data.readInt();
            String packageName = data.readString();
            IBinder token = data.readStrongBinder();
            String resultWho = data.readString();
            int requestCode = data.readInt();
            Intent[] requestIntents;
            String[] requestResolvedTypes;
    if(data.readInt() != 0)            
            {
                requestIntents = data.createTypedArray(Intent.CREATOR);
                requestResolvedTypes = data.createStringArray();
            } //End block
            else
            {
                requestIntents = null;
                requestResolvedTypes = null;
            } //End block
            int fl = data.readInt();
            IIntentSender res = getIntentSender(type, packageName, token,
                    resultWho, requestCode, requestIntents,
                    requestResolvedTypes, fl);
            reply.writeNoException();
            reply.writeStrongBinder(res != null ? res.asBinder() : null);
            boolean varB326B5062B2F0E69046810717534CB09_395718137 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331109509 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_331109509;
        } //End block
        case CANCEL_INTENT_SENDER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            cancelIntentSender(r);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1528763800 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1851623314 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1851623314;
        } //End block
        case GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            String res = getPackageForIntentSender(r);
            reply.writeNoException();
            reply.writeString(res);
            boolean varB326B5062B2F0E69046810717534CB09_55064400 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_903923988 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_903923988;
        } //End block
        case SET_PROCESS_LIMIT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int max = data.readInt();
            setProcessLimit(max);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1062325943 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1653889157 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1653889157;
        } //End block
        case GET_PROCESS_LIMIT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int limit = getProcessLimit();
            reply.writeNoException();
            reply.writeInt(limit);
            boolean varB326B5062B2F0E69046810717534CB09_1432442524 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789471393 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789471393;
        } //End block
        case SET_PROCESS_FOREGROUND_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int pid = data.readInt();
            boolean isForeground = data.readInt() != 0;
            setProcessForeground(token, pid, isForeground);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_2104976386 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615314335 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_615314335;
        } //End block
        case CHECK_PERMISSION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String perm = data.readString();
            int pid = data.readInt();
            int uid = data.readInt();
            int res = checkPermission(perm, pid, uid);
            reply.writeNoException();
            reply.writeInt(res);
            boolean varB326B5062B2F0E69046810717534CB09_1943161820 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_730759232 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_730759232;
        } //End block
        case CHECK_URI_PERMISSION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int pid = data.readInt();
            int uid = data.readInt();
            int mode = data.readInt();
            int res = checkUriPermission(uri, pid, uid, mode);
            reply.writeNoException();
            reply.writeInt(res);
            boolean varB326B5062B2F0E69046810717534CB09_874631024 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2037557485 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2037557485;
        } //End block
        case CLEAR_APP_DATA_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            IPackageDataObserver observer = IPackageDataObserver.Stub.asInterface(
                    data.readStrongBinder());
            boolean res = clearApplicationUserData(packageName, observer);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1151700524 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1237291282 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1237291282;
        } //End block
        case GRANT_URI_PERMISSION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            String targetPkg = data.readString();
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int mode = data.readInt();
            grantUriPermission(app, targetPkg, uri, mode);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_2097568600 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084024856 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084024856;
        } //End block
        case REVOKE_URI_PERMISSION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int mode = data.readInt();
            revokeUriPermission(app, uri, mode);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_713858830 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1443689316 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1443689316;
        } //End block
        case SHOW_WAITING_FOR_DEBUGGER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            boolean waiting = data.readInt() != 0;
            showWaitingForDebugger(app, waiting);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_230168791 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_961952638 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_961952638;
        } //End block
        case GET_MEMORY_INFO_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
            getMemoryInfo(mi);
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
            boolean varB326B5062B2F0E69046810717534CB09_165154842 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1163134604 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1163134604;
        } //End block
        case UNHANDLED_BACK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            unhandledBack();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_35399040 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70721316 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_70721316;
        } //End block
        case OPEN_CONTENT_URI_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri = Uri.parse(data.readString());
            ParcelFileDescriptor pfd = openContentUri(uri);
            reply.writeNoException();
    if(pfd != null)            
            {
                reply.writeInt(1);
                pfd.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            } //End block
            else
            {
                reply.writeInt(0);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1370985466 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1932141037 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1932141037;
        } //End block
        case GOING_TO_SLEEP_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            goingToSleep();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_528488966 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598493226 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598493226;
        } //End block
        case WAKING_UP_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            wakingUp();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1372403819 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324068257 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324068257;
        } //End block
        case SET_DEBUG_APP_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pn = data.readString();
            boolean wfd = data.readInt() != 0;
            boolean per = data.readInt() != 0;
            setDebugApp(pn, wfd, per);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1223167739 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_410387893 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_410387893;
        } //End block
        case SET_ALWAYS_FINISH_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean enabled = data.readInt() != 0;
            setAlwaysFinish(enabled);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1388017632 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389214206 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389214206;
        } //End block
        case SET_ACTIVITY_CONTROLLER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityController watcher = IActivityController.Stub.asInterface(
                    data.readStrongBinder());
            setActivityController(watcher);
            boolean varB326B5062B2F0E69046810717534CB09_202766810 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814889450 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_814889450;
        } //End block
        case ENTER_SAFE_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            enterSafeMode();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_339509817 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115387434 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_115387434;
        } //End block
        case NOTE_WAKEUP_ALARM_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender is = IIntentSender.Stub.asInterface(
                    data.readStrongBinder());
            noteWakeupAlarm(is);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1893319766 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1854172690 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1854172690;
        } //End block
        case KILL_PIDS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids = data.createIntArray();
            String reason = data.readString();
            boolean secure = data.readInt() != 0;
            boolean res = killPids(pids, reason, secure);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1309467732 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1806512777 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1806512777;
        } //End block
        case START_RUNNING_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            String cls = data.readString();
            String action = data.readString();
            String indata = data.readString();
            startRunning(pkg, cls, action, indata);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_326972951 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47295585 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_47295585;
        } //End block
        case HANDLE_APPLICATION_CRASH_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app = data.readStrongBinder();
            ApplicationErrorReport.CrashInfo ci = new ApplicationErrorReport.CrashInfo(data);
            handleApplicationCrash(app, ci);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_363473358 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1188001576 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1188001576;
        } //End block
        case HANDLE_APPLICATION_WTF_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app = data.readStrongBinder();
            String tag = data.readString();
            ApplicationErrorReport.CrashInfo ci = new ApplicationErrorReport.CrashInfo(data);
            boolean res = handleApplicationWtf(app, tag, ci);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1818215195 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1088473909 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1088473909;
        } //End block
        case HANDLE_APPLICATION_STRICT_MODE_VIOLATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app = data.readStrongBinder();
            int violationMask = data.readInt();
            StrictMode.ViolationInfo info = new StrictMode.ViolationInfo(data);
            handleApplicationStrictModeViolation(app, violationMask, info);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_392159881 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88972836 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_88972836;
        } //End block
        case SIGNAL_PERSISTENT_PROCESSES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int sig = data.readInt();
            signalPersistentProcesses(sig);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1039847153 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_95905204 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_95905204;
        } //End block
        case KILL_BACKGROUND_PROCESSES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            killBackgroundProcesses(packageName);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_868079337 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1347094312 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1347094312;
        } //End block
        case KILL_ALL_BACKGROUND_PROCESSES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            killAllBackgroundProcesses();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_335407201 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_493574012 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_493574012;
        } //End block
        case FORCE_STOP_PACKAGE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            forceStopPackage(packageName);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1452204550 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_152346962 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_152346962;
        } //End block
        case GET_DEVICE_CONFIGURATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ConfigurationInfo config = getDeviceConfigurationInfo();
            reply.writeNoException();
            config.writeToParcel(reply, 0);
            boolean varB326B5062B2F0E69046810717534CB09_1738916892 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975985667 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_975985667;
        } //End block
        case PROFILE_CONTROL_TRANSACTION:
        {
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
            boolean varB326B5062B2F0E69046810717534CB09_911644098 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1810102540 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1810102540;
        } //End block
        case SHUTDOWN_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean res = shutdown(data.readInt());
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1425532 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1995305975 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1995305975;
        } //End block
        case STOP_APP_SWITCHES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            stopAppSwitches();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_810533304 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2117702848 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2117702848;
        } //End block
        case RESUME_APP_SWITCHES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            resumeAppSwitches();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1556175682 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955299592 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_955299592;
        } //End block
        case PEEK_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Intent service = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            IBinder binder = peekService(service, resolvedType);
            reply.writeNoException();
            reply.writeStrongBinder(binder);
            boolean varB326B5062B2F0E69046810717534CB09_90717679 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291054636 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_291054636;
        } //End block
        case START_BACKUP_AGENT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ApplicationInfo info = ApplicationInfo.CREATOR.createFromParcel(data);
            int backupRestoreMode = data.readInt();
            boolean success = bindBackupAgent(info, backupRestoreMode);
            reply.writeNoException();
            reply.writeInt(success ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_445937866 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_321038067 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_321038067;
        } //End block
        case BACKUP_AGENT_CREATED_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            IBinder agent = data.readStrongBinder();
            backupAgentCreated(packageName, agent);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1286525147 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043070256 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043070256;
        } //End block
        case UNBIND_BACKUP_AGENT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ApplicationInfo info = ApplicationInfo.CREATOR.createFromParcel(data);
            unbindBackupAgent(info);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_117205631 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1208025283 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1208025283;
        } //End block
        case REGISTER_ACTIVITY_WATCHER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityWatcher watcher = IActivityWatcher.Stub.asInterface(
                    data.readStrongBinder());
            registerActivityWatcher(watcher);
            boolean varB326B5062B2F0E69046810717534CB09_2002526349 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_870188789 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_870188789;
        } //End block
        case UNREGISTER_ACTIVITY_WATCHER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityWatcher watcher = IActivityWatcher.Stub.asInterface(
                    data.readStrongBinder());
            unregisterActivityWatcher(watcher);
            boolean varB326B5062B2F0E69046810717534CB09_992581488 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084451309 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084451309;
        } //End block
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
            boolean varB326B5062B2F0E69046810717534CB09_532280442 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745214321 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_745214321;
        } //End block
        case KILL_APPLICATION_WITH_UID_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int uid = data.readInt();
            killApplicationWithUid(pkg, uid);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_698387741 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_794041084 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_794041084;
        } //End block
        case CLOSE_SYSTEM_DIALOGS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String reason = data.readString();
            closeSystemDialogs(reason);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1623581756 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_586359639 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_586359639;
        } //End block
        case GET_PROCESS_MEMORY_INFO_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids = data.createIntArray();
            Debug.MemoryInfo[] res = getProcessMemoryInfo(pids);
            reply.writeNoException();
            reply.writeTypedArray(res, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            boolean varB326B5062B2F0E69046810717534CB09_1619840329 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025934240 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025934240;
        } //End block
        case KILL_APPLICATION_PROCESS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String processName = data.readString();
            int uid = data.readInt();
            killApplicationProcess(processName, uid);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1172368574 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682135383 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_682135383;
        } //End block
        case OVERRIDE_PENDING_TRANSITION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            String packageName = data.readString();
            int enterAnim = data.readInt();
            int exitAnim = data.readInt();
            overridePendingTransition(token, packageName, enterAnim, exitAnim);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_2129890035 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1978752511 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1978752511;
        } //End block
        case IS_USER_A_MONKEY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean areThey = isUserAMonkey();
            reply.writeNoException();
            reply.writeInt(areThey ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1460215387 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400448397 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_400448397;
        } //End block
        case FINISH_HEAVY_WEIGHT_APP_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            finishHeavyWeightApp();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1495737051 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1772719757 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1772719757;
        } //End block
        case IS_IMMERSIVE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean isit = isImmersive(token);
            reply.writeNoException();
            reply.writeInt(isit ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_684091683 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457189882 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457189882;
        } //End block
        case SET_IMMERSIVE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean imm = data.readInt() == 1;
            setImmersive(token, imm);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_2070681897 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_311408856 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_311408856;
        } //End block
        case IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean isit = isTopActivityImmersive();
            reply.writeNoException();
            reply.writeInt(isit ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_840623629 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_242520426 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_242520426;
        } //End block
        case CRASH_APPLICATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int uid = data.readInt();
            int initialPid = data.readInt();
            String packageName = data.readString();
            String message = data.readString();
            crashApplication(uid, initialPid, packageName, message);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_540628603 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_521229836 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_521229836;
        } //End block
        case GET_PROVIDER_MIME_TYPE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri = Uri.CREATOR.createFromParcel(data);
            String type = getProviderMimeType(uri);
            reply.writeNoException();
            reply.writeString(type);
            boolean varB326B5062B2F0E69046810717534CB09_1512471294 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658080403 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658080403;
        } //End block
        case NEW_URI_PERMISSION_OWNER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String name = data.readString();
            IBinder perm = newUriPermissionOwner(name);
            reply.writeNoException();
            reply.writeStrongBinder(perm);
            boolean varB326B5062B2F0E69046810717534CB09_1000513937 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1601772023 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1601772023;
        } //End block
        case GRANT_URI_PERMISSION_FROM_OWNER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder owner = data.readStrongBinder();
            int fromUid = data.readInt();
            String targetPkg = data.readString();
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int mode = data.readInt();
            grantUriPermissionFromOwner(owner, fromUid, targetPkg, uri, mode);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1459400154 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1052037133 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1052037133;
        } //End block
        case REVOKE_URI_PERMISSION_FROM_OWNER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder owner = data.readStrongBinder();
            Uri uri = null;
    if(data.readInt() != 0)            
            {
                Uri.CREATOR.createFromParcel(data);
            } //End block
            int mode = data.readInt();
            revokeUriPermissionFromOwner(owner, uri, mode);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1739468415 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592004469 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592004469;
        } //End block
        case CHECK_GRANT_URI_PERMISSION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int callingUid = data.readInt();
            String targetPkg = data.readString();
            Uri uri = Uri.CREATOR.createFromParcel(data);
            int modeFlags = data.readInt();
            int res = checkGrantUriPermission(callingUid, targetPkg, uri, modeFlags);
            reply.writeNoException();
            reply.writeInt(res);
            boolean varB326B5062B2F0E69046810717534CB09_2068636205 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1957976414 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1957976414;
        } //End block
        case DUMP_HEAP_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String process = data.readString();
            boolean managed = data.readInt() != 0;
            String path = data.readString();
            ParcelFileDescriptor fd = data.readInt() != 0
                    ? data.readFileDescriptor() : null;
            boolean res = dumpHeap(process, managed, path, fd);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_758525784 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2051298826 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2051298826;
        } //End block
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
            boolean varB326B5062B2F0E69046810717534CB09_1692696056 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1971148344 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1971148344;
        } //End block
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
            boolean varB326B5062B2F0E69046810717534CB09_1348338786 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888456841 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888456841;
        } //End block
        case GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int mode = getFrontActivityScreenCompatMode();
            reply.writeNoException();
            reply.writeInt(mode);
            boolean varB326B5062B2F0E69046810717534CB09_932930490 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2138788970 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2138788970;
        } //End block
        case SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int mode = data.readInt();
            setFrontActivityScreenCompatMode(mode);
            reply.writeNoException();
            reply.writeInt(mode);
            boolean varB326B5062B2F0E69046810717534CB09_1410352424 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_201563798 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_201563798;
        } //End block
        case GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int mode = getPackageScreenCompatMode(pkg);
            reply.writeNoException();
            reply.writeInt(mode);
            boolean varB326B5062B2F0E69046810717534CB09_1490699178 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_257032722 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_257032722;
        } //End block
        case SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int mode = data.readInt();
            setPackageScreenCompatMode(pkg, mode);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1655876568 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645316603 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_645316603;
        } //End block
        case SWITCH_USER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int userid = data.readInt();
            boolean result = switchUser(userid);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_592903417 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1550630541 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1550630541;
        } //End block
        case REMOVE_SUB_TASK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int taskId = data.readInt();
            int subTaskIndex = data.readInt();
            boolean result = removeSubTask(taskId, subTaskIndex);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_326833354 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_927985167 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_927985167;
        } //End block
        case REMOVE_TASK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int taskId = data.readInt();
            int fl = data.readInt();
            boolean result = removeTask(taskId, fl);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1583075859 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947855526 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947855526;
        } //End block
        case REGISTER_PROCESS_OBSERVER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IProcessObserver observer = IProcessObserver.Stub.asInterface(
                    data.readStrongBinder());
            registerProcessObserver(observer);
            boolean varB326B5062B2F0E69046810717534CB09_1763596292 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_752369252 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_752369252;
        } //End block
        case UNREGISTER_PROCESS_OBSERVER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IProcessObserver observer = IProcessObserver.Stub.asInterface(
                    data.readStrongBinder());
            unregisterProcessObserver(observer);
            boolean varB326B5062B2F0E69046810717534CB09_1024196024 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670293752 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670293752;
        } //End block
        case GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            boolean ask = getPackageAskScreenCompat(pkg);
            reply.writeNoException();
            reply.writeInt(ask ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_88020625 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394006794 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_394006794;
        } //End block
        case SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            boolean ask = data.readInt() != 0;
            setPackageAskScreenCompat(pkg, ask);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1229790236 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222547689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_222547689;
        } //End block
        case IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            boolean res = isIntentSenderTargetedToPackage(r);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1228676831 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1273558692 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1273558692;
        } //End block
        case UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            updatePersistentConfiguration(config);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_575288565 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_548278089 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_548278089;
        } //End block
        case GET_PROCESS_PSS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids = data.createIntArray();
            long[] pss = getProcessPss(pids);
            reply.writeNoException();
            reply.writeLongArray(pss);
            boolean varB326B5062B2F0E69046810717534CB09_387589656 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1897498899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1897498899;
        } //End block
        case SHOW_BOOT_MESSAGE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            CharSequence msg = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            boolean always = data.readInt() != 0;
            showBootMessage(msg, always);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1176696372 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211948027 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211948027;
        } //End block
        case DISMISS_KEYGUARD_ON_NEXT_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            dismissKeyguardOnNextActivity();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1667887570 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496812334 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496812334;
        } //End block
}        boolean var3B3A841664B2F7D5B8C0C4B7B8E31E3B_1274258065 = (super.onTransact(code, data, reply, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_644505812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_644505812;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.160 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "9E669AF9EC43561F589295F7CE82C151")
    public IBinder asBinder() {
IBinder var72A74007B2BE62B849F475C7BDA4658B_1652912481 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1652912481.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1652912481;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.161 -0400", hash_original_field = "7E28963ADB1F0EB3A0EF33BADF10C8B6", hash_generated_field = "94B5404A722EA8FD9D4D6FFD2B91074A")

    static boolean sSystemReady = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.715 -0400", hash_original_field = "1DDB5338697F4F4D1F4EBEBCBCA04F09", hash_generated_field = "C4820EDCAE5178FFFBC23811D56B7F74")

    private static final Singleton<IActivityManager> gDefault = new Singleton<IActivityManager>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.715 -0400", hash_original_method = "DB2B8F5A0363FA0CE3E5AA87CCE94A22", hash_generated_method = "C2B8BA082758343987D3AD39EBC6D0DC")
        protected IActivityManager create() {
            IActivityManager varB4EAC82CA7396A68D541C85D26508E83_1441821956 = null; 
            IBinder b = ServiceManager.getService("activity");
            IActivityManager am = asInterface(b);
            varB4EAC82CA7396A68D541C85D26508E83_1441821956 = am;
            varB4EAC82CA7396A68D541C85D26508E83_1441821956.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1441821956;
            
            
            
                
            
            
            
                
            
            
        }

        
};
}

class ActivityManagerProxy implements IActivityManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.163 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.163 -0400", hash_original_method = "3287CA7C2EB4AADDF2EFFF2704D2BE9E", hash_generated_method = "45B8F41C62FE771FA42BECD8E8563D23")
    public  ActivityManagerProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.164 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "C6DB3CAA8F66992B18FF656299E23D1A")
    public IBinder asBinder() {
IBinder varF4936CA84F7841A48B466C9D273BE2EB_1747796033 =         mRemote;
        varF4936CA84F7841A48B466C9D273BE2EB_1747796033.addTaint(taint);
        return varF4936CA84F7841A48B466C9D273BE2EB_1747796033;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.167 -0400", hash_original_method = "ECBE4259B26F016D18C1CACD48E02238", hash_generated_method = "7BCB6BB2666F9D2CE3F8756F89256D3B")
    public int startActivity(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, String profileFile, ParcelFileDescriptor profileFd,
            boolean autoStopProfiler) throws RemoteException {
        addTaint(autoStopProfiler);
        addTaint(profileFd.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(debug);
        addTaint(onlyIfNeeded);
        addTaint(requestCode);
        addTaint(resultWho.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(grantedMode);
        addTaint(grantedUriPermissions[0].getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(intent.getTaint());
        addTaint(caller.getTaint());
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
    if(profileFd != null)        
        {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        else
        {
            data.writeInt(0);
        } //End block
        data.writeInt(autoStopProfiler ? 1 : 0);
        mRemote.transact(START_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        int result = reply.readInt();
        reply.recycle();
        data.recycle();
        int varB4A88417B3D0170D754C647C30B7216A_2020891921 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911419658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911419658;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.171 -0400", hash_original_method = "BF42E410BABF1DD283EC1102C9637003", hash_generated_method = "49BEF0C69DAB3B2A2EDEEC15A92E77C2")
    public WaitResult startActivityAndWait(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, String profileFile, ParcelFileDescriptor profileFd,
            boolean autoStopProfiler) throws RemoteException {
        addTaint(autoStopProfiler);
        addTaint(profileFd.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(debug);
        addTaint(onlyIfNeeded);
        addTaint(requestCode);
        addTaint(resultWho.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(grantedMode);
        addTaint(grantedUriPermissions[0].getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(intent.getTaint());
        addTaint(caller.getTaint());
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
    if(profileFd != null)        
        {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        else
        {
            data.writeInt(0);
        } //End block
        data.writeInt(autoStopProfiler ? 1 : 0);
        mRemote.transact(START_ACTIVITY_AND_WAIT_TRANSACTION, data, reply, 0);
        reply.readException();
        WaitResult result = WaitResult.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
WaitResult varDC838461EE2FA0CA4C9BBB70A15456B0_93002068 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_93002068.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_93002068;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.173 -0400", hash_original_method = "47F7B475943E725D61EF4FCECF2C263D", hash_generated_method = "AD4D0D5A2BEFC3348B8CBF3CE585606A")
    public int startActivityWithConfig(IApplicationThread caller, Intent intent,
            String resolvedType, Uri[] grantedUriPermissions, int grantedMode,
            IBinder resultTo, String resultWho,
            int requestCode, boolean onlyIfNeeded,
            boolean debug, Configuration config) throws RemoteException {
        addTaint(config.getTaint());
        addTaint(debug);
        addTaint(onlyIfNeeded);
        addTaint(requestCode);
        addTaint(resultWho.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(grantedMode);
        addTaint(grantedUriPermissions[0].getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(intent.getTaint());
        addTaint(caller.getTaint());
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
        int varB4A88417B3D0170D754C647C30B7216A_1503405480 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619429235 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619429235;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.175 -0400", hash_original_method = "FD56EAF7591CCE02A2449EB3C30AEF02", hash_generated_method = "F0447C227C8C059F2270CEF8E9ECA574")
    public int startActivityIntentSender(IApplicationThread caller,
            IntentSender intent, Intent fillInIntent, String resolvedType,
            IBinder resultTo, String resultWho, int requestCode,
            int flagsMask, int flagsValues) throws RemoteException {
        addTaint(flagsValues);
        addTaint(flagsMask);
        addTaint(requestCode);
        addTaint(resultWho.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(fillInIntent.getTaint());
        addTaint(intent.getTaint());
        addTaint(caller.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        intent.writeToParcel(data, 0);
    if(fillInIntent != null)        
        {
            data.writeInt(1);
            fillInIntent.writeToParcel(data, 0);
        } //End block
        else
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
        int varB4A88417B3D0170D754C647C30B7216A_396330229 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464369901 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464369901;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.176 -0400", hash_original_method = "A532370FCCB6C359BF27FA22D92F73F5", hash_generated_method = "A6AC0E8D9655422D0FBCB693AA932939")
    public boolean startNextMatchingActivity(IBinder callingActivity,
            Intent intent) throws RemoteException {
        addTaint(intent.getTaint());
        addTaint(callingActivity.getTaint());
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
        boolean var48B2BB9B3785EB1DD7973635DF866605_1285399243 = (result != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1317503474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1317503474;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.178 -0400", hash_original_method = "91E82D39E0DA0BAF3D9668B58FD8BE2D", hash_generated_method = "251A2A90E21C81B0825E020FEB03EB28")
    public boolean finishActivity(IBinder token, int resultCode, Intent resultData) throws RemoteException {
        addTaint(resultData.getTaint());
        addTaint(resultCode);
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(resultCode);
    if(resultData != null)        
        {
            data.writeInt(1);
            resultData.writeToParcel(data, 0);
        } //End block
        else
        {
            data.writeInt(0);
        } //End block
        mRemote.transact(FINISH_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_2029343293 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020261264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020261264;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.182 -0400", hash_original_method = "352728C633440E8BBFDE1A24B12C26C6", hash_generated_method = "BCCFD641BCE3194BDEB63F342D1C5DF5")
    public void finishSubActivity(IBinder token, String resultWho, int requestCode) throws RemoteException {
        addTaint(requestCode);
        addTaint(resultWho.getTaint());
        addTaint(token.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.185 -0400", hash_original_method = "03769BB85CE515FA0FB5B3DCD0709D8A", hash_generated_method = "3FA5219B2F908F582CF5ED2E9B49095E")
    public boolean willActivityBeVisible(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(WILL_ACTIVITY_BE_VISIBLE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_1803204860 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_728345751 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_728345751;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.187 -0400", hash_original_method = "D0EC9750E66DC0864B7AF9A5D43ED043", hash_generated_method = "C8D66FC61232C0917C25CF93F1BE6337")
    public Intent registerReceiver(IApplicationThread caller, String packageName,
            IIntentReceiver receiver,
            IntentFilter filter, String perm) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(perm.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
        addTaint(packageName.getTaint());
        addTaint(caller.getTaint());
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
    if(haveIntent != 0)        
        {
            intent = Intent.CREATOR.createFromParcel(reply);
        } //End block
        reply.recycle();
        data.recycle();
Intent var095937E5B36214360A2644916BF0E8DF_516582007 =         intent;
        var095937E5B36214360A2644916BF0E8DF_516582007.addTaint(taint);
        return var095937E5B36214360A2644916BF0E8DF_516582007;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.188 -0400", hash_original_method = "CF62E9563222E9365AE1815E546E05AA", hash_generated_method = "EBFF195F8AF8C5235A7DAE7F680DB895")
    public void unregisterReceiver(IIntentReceiver receiver) throws RemoteException {
        addTaint(receiver.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.190 -0400", hash_original_method = "189D2A1B1A14BF35BFCC0BB8AD6C1CE5", hash_generated_method = "63960C28C2857B716600915B70019072")
    public int broadcastIntent(IApplicationThread caller,
            Intent intent, String resolvedType,  IIntentReceiver resultTo,
            int resultCode, String resultData, Bundle map,
            String requiredPermission, boolean serialized,
            boolean sticky) throws RemoteException {
        addTaint(sticky);
        addTaint(serialized);
        addTaint(requiredPermission.getTaint());
        addTaint(map.getTaint());
        addTaint(resultData.getTaint());
        addTaint(resultCode);
        addTaint(resultTo.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(intent.getTaint());
        addTaint(caller.getTaint());
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
        int var9B207167E5381C47682C6B4F58A623FB_1633154165 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895797995 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895797995;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.192 -0400", hash_original_method = "84F4ECE33F63E245917246490F7877AA", hash_generated_method = "0090436865129974CDDE7C46CB4631DE")
    public void unbroadcastIntent(IApplicationThread caller, Intent intent) throws RemoteException {
        addTaint(intent.getTaint());
        addTaint(caller.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.194 -0400", hash_original_method = "8BFF18A0F9A8EDDD76A319C280B21CDC", hash_generated_method = "6CD1CB45073E30492BF451AC94ECBC30")
    public void finishReceiver(IBinder who, int resultCode, String resultData, Bundle map, boolean abortBroadcast) throws RemoteException {
        addTaint(abortBroadcast);
        addTaint(map.getTaint());
        addTaint(resultData.getTaint());
        addTaint(resultCode);
        addTaint(who.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.195 -0400", hash_original_method = "1E67E239E5F2A2540F1E032AB272605E", hash_generated_method = "15A8A0A0066C6B9F437753E72C9A2336")
    public void attachApplication(IApplicationThread app) throws RemoteException {
        addTaint(app.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.196 -0400", hash_original_method = "BC9E49082B5DC06C707641FC7F3E31F5", hash_generated_method = "C6FC598DE4C327BF9954BF041BA1590D")
    public void activityIdle(IBinder token, Configuration config, boolean stopProfiling) throws RemoteException {
        addTaint(stopProfiling);
        addTaint(config.getTaint());
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
    if(config != null)        
        {
            data.writeInt(1);
            config.writeToParcel(data, 0);
        } //End block
        else
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.197 -0400", hash_original_method = "4914FFC78B966DEBED0BDBFF9D70FB17", hash_generated_method = "BC84E109F6194C7A2380D96175286DC0")
    public void activityPaused(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.198 -0400", hash_original_method = "F5DE3AC45B6CCF74477AF45EB0878099", hash_generated_method = "024E58D40F71E0502D7FE4C548CCFBE5")
    public void activityStopped(IBinder token, Bundle state,
            Bitmap thumbnail, CharSequence description) throws RemoteException {
        addTaint(description.getTaint());
        addTaint(thumbnail.getTaint());
        addTaint(state.getTaint());
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        data.writeBundle(state);
    if(thumbnail != null)        
        {
            data.writeInt(1);
            thumbnail.writeToParcel(data, 0);
        } //End block
        else
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.199 -0400", hash_original_method = "CA8224B1DA5730B462FB3F604509C1DB", hash_generated_method = "7D2E7A6051B2162A2227C5D0A6CBF920")
    public void activitySlept(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.200 -0400", hash_original_method = "9A100D49A0D535BB686DAA00CAC541FF", hash_generated_method = "BCD8E575A6F8119829A3359C4DF722F3")
    public void activityDestroyed(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.201 -0400", hash_original_method = "7637EF2082F6942F953796EFCEAA3730", hash_generated_method = "CEC4F343C86E90E54298D10752873C28")
    public String getCallingPackage(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_CALLING_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
String varB5053E025797B3BF768F5C37934C244D_1614224721 =         res;
        varB5053E025797B3BF768F5C37934C244D_1614224721.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1614224721;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.203 -0400", hash_original_method = "0E9D91A20FCD3BCFB3517DB475147FAB", hash_generated_method = "59ED95499AF4E0B95F49556A1F788F40")
    public ComponentName getCallingActivity(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_CALLING_ACTIVITY_TRANSACTION, data, reply, 0);
        reply.readException();
        ComponentName res = ComponentName.readFromParcel(reply);
        data.recycle();
        reply.recycle();
ComponentName varB5053E025797B3BF768F5C37934C244D_267455921 =         res;
        varB5053E025797B3BF768F5C37934C244D_267455921.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_267455921;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.206 -0400", hash_original_method = "FAA1C4AE039868246AED533CDCA15CD7", hash_generated_method = "3084D8316889464C0AD117D0AFCD3B2A")
    public List getTasks(int maxNum, int flags,
            IThumbnailReceiver receiver) throws RemoteException {
        addTaint(receiver.getTaint());
        addTaint(flags);
        addTaint(maxNum);
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
    if(N >= 0)        
        {
            list = new ArrayList();
            while
(N > 0)            
            {
                ActivityManager.RunningTaskInfo info = ActivityManager.RunningTaskInfo.CREATOR
                        .createFromParcel(reply);
                list.add(info);
                N--;
            } //End block
        } //End block
        data.recycle();
        reply.recycle();
List varED12C351C2E8CA4F85F097DDC7E77B4D_950643667 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_950643667.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_950643667;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.209 -0400", hash_original_method = "9D3E8FF17F102376D7C7BE9D34CE4F93", hash_generated_method = "315C5801CD6020F8C97D7F54EBED4A3B")
    public List<ActivityManager.RecentTaskInfo> getRecentTasks(int maxNum,
            int flags) throws RemoteException {
        addTaint(flags);
        addTaint(maxNum);
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
List<ActivityManager.RecentTaskInfo> varED12C351C2E8CA4F85F097DDC7E77B4D_406087783 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_406087783.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_406087783;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.211 -0400", hash_original_method = "10D095A12B52FE928E4AEC7C3F42A832", hash_generated_method = "63F13C9337B0A5720D969214BF6FEFE9")
    public ActivityManager.TaskThumbnails getTaskThumbnails(int id) throws RemoteException {
        addTaint(id);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(id);
        mRemote.transact(GET_TASK_THUMBNAILS_TRANSACTION, data, reply, 0);
        reply.readException();
        ActivityManager.TaskThumbnails bm = null;
    if(reply.readInt() != 0)        
        {
            bm = ActivityManager.TaskThumbnails.CREATOR.createFromParcel(reply);
        } //End block
        data.recycle();
        reply.recycle();
ActivityManager.TaskThumbnails varB8E43D5ABE5A56CEFCFBA2D810F6046C_853385851 =         bm;
        varB8E43D5ABE5A56CEFCFBA2D810F6046C_853385851.addTaint(taint);
        return varB8E43D5ABE5A56CEFCFBA2D810F6046C_853385851;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.215 -0400", hash_original_method = "7671DD1471581027B2C414BE0E3CE4A6", hash_generated_method = "68ADB8ED73174862AA1B302271C81003")
    public List getServices(int maxNum, int flags) throws RemoteException {
        addTaint(flags);
        addTaint(maxNum);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(maxNum);
        data.writeInt(flags);
        mRemote.transact(GET_SERVICES_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList list = null;
        int N = reply.readInt();
    if(N >= 0)        
        {
            list = new ArrayList();
            while
(N > 0)            
            {
                ActivityManager.RunningServiceInfo info = ActivityManager.RunningServiceInfo.CREATOR
                        .createFromParcel(reply);
                list.add(info);
                N--;
            } //End block
        } //End block
        data.recycle();
        reply.recycle();
List varED12C351C2E8CA4F85F097DDC7E77B4D_2034041592 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_2034041592.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_2034041592;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.217 -0400", hash_original_method = "2AE453A6460D5AF368C9AC4C4862314B", hash_generated_method = "65598E81F816493AD9B62EE1B80E7C22")
    public List<ActivityManager.ProcessErrorStateInfo> getProcessesInErrorState() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_PROCESSES_IN_ERROR_STATE_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.ProcessErrorStateInfo> list = reply.createTypedArrayList(ActivityManager.ProcessErrorStateInfo.CREATOR);
        data.recycle();
        reply.recycle();
List<ActivityManager.ProcessErrorStateInfo> varED12C351C2E8CA4F85F097DDC7E77B4D_1539404875 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1539404875.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1539404875;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.219 -0400", hash_original_method = "8E45CD57BE18A4B76C3A3E0DA22BC8B7", hash_generated_method = "E1AFD2290565FDBCD5CEFC18D11D3F72")
    public List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_RUNNING_APP_PROCESSES_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.RunningAppProcessInfo> list = reply.createTypedArrayList(ActivityManager.RunningAppProcessInfo.CREATOR);
        data.recycle();
        reply.recycle();
List<ActivityManager.RunningAppProcessInfo> varED12C351C2E8CA4F85F097DDC7E77B4D_48577251 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_48577251.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_48577251;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.220 -0400", hash_original_method = "2FAC851B003A84469F94E88A81DA29C3", hash_generated_method = "3AB1FAA4FC9620E736B413730D803684")
    public List<ApplicationInfo> getRunningExternalApplications() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ApplicationInfo> list = reply.createTypedArrayList(ApplicationInfo.CREATOR);
        data.recycle();
        reply.recycle();
List<ApplicationInfo> varED12C351C2E8CA4F85F097DDC7E77B4D_1177187574 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1177187574.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1177187574;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.222 -0400", hash_original_method = "DABF13B8F45F6A065880490CD0DBD1A0", hash_generated_method = "734BFBD8A5C3F2F3DAA3C0960663CBA1")
    public void moveTaskToFront(int task, int flags) throws RemoteException {
        addTaint(flags);
        addTaint(task);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.225 -0400", hash_original_method = "7FFB6E49EA553237E0A3F53A2CDFD87F", hash_generated_method = "59229381DD744ED2A5D25EE994A9FA5D")
    public void moveTaskToBack(int task) throws RemoteException {
        addTaint(task);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.227 -0400", hash_original_method = "7F4F39C4D7AB58BCB5DB152705A9F80A", hash_generated_method = "4573FEBAD796D51B2AB479C7AB6AB09D")
    public boolean moveActivityTaskToBack(IBinder token, boolean nonRoot) throws RemoteException {
        addTaint(nonRoot);
        addTaint(token.getTaint());
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
        boolean var9B207167E5381C47682C6B4F58A623FB_594768652 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_961139262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_961139262;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.228 -0400", hash_original_method = "48BD6DC2300FE39DD3A4B34C3DD91993", hash_generated_method = "9400D1D2535BF4E8627FCCA304C9037F")
    public void moveTaskBackwards(int task) throws RemoteException {
        addTaint(task);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.230 -0400", hash_original_method = "3FABC29A3C68690EBF6B4F44EE4A5D23", hash_generated_method = "AF21E161A7412F9C9F0CD0C7729CA100")
    public int getTaskForActivity(IBinder token, boolean onlyRoot) throws RemoteException {
        addTaint(onlyRoot);
        addTaint(token.getTaint());
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
        int var9B207167E5381C47682C6B4F58A623FB_197362823 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1532186404 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1532186404;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.234 -0400", hash_original_method = "AF696C3AA9BD79AC1F2D6780E820F3FA", hash_generated_method = "30AE1666DC6580ADD9919D385442063E")
    public void finishOtherInstances(IBinder token, ComponentName className) throws RemoteException {
        addTaint(className.getTaint());
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.238 -0400", hash_original_method = "4B3E31ABB8C007E1B3828F729DFD9393", hash_generated_method = "DBD559CF5398EC35E3B87AF28E7394C3")
    public void reportThumbnail(IBinder token,
                                Bitmap thumbnail, CharSequence description) throws RemoteException {
        addTaint(description.getTaint());
        addTaint(thumbnail.getTaint());
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
    if(thumbnail != null)        
        {
            data.writeInt(1);
            thumbnail.writeToParcel(data, 0);
        } //End block
        else
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.241 -0400", hash_original_method = "EC6CF87E25124312A62325C5F062E996", hash_generated_method = "1027775AB592E5B1224F0A1D884CD746")
    public ContentProviderHolder getContentProvider(IApplicationThread caller,
                                                    String name) throws RemoteException {
        addTaint(name.getTaint());
        addTaint(caller.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(caller != null ? caller.asBinder() : null);
        data.writeString(name);
        mRemote.transact(GET_CONTENT_PROVIDER_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        ContentProviderHolder cph = null;
    if(res != 0)        
        {
            cph = ContentProviderHolder.CREATOR.createFromParcel(reply);
        } //End block
        data.recycle();
        reply.recycle();
ContentProviderHolder var714D5B899646D8F8DB57A5F82D1906E2_1267144485 =         cph;
        var714D5B899646D8F8DB57A5F82D1906E2_1267144485.addTaint(taint);
        return var714D5B899646D8F8DB57A5F82D1906E2_1267144485;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.242 -0400", hash_original_method = "9C5D73DEFA4B6B21F8A4E01DC5E46521", hash_generated_method = "7FC35AF6CCBDF33AAAFA78B80E3F000D")
    public void publishContentProviders(IApplicationThread caller,
                                        List<ContentProviderHolder> providers) throws RemoteException {
        addTaint(providers.getTaint());
        addTaint(caller.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.244 -0400", hash_original_method = "6E983079D2A10BB8E3DF4E66B032EE6D", hash_generated_method = "AD8CFC769B5F6390C3D458BDAA4E0D9F")
    public void removeContentProvider(IApplicationThread caller,
            String name) throws RemoteException {
        addTaint(name.getTaint());
        addTaint(caller.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.246 -0400", hash_original_method = "E5355EA6A0F8270964E816C69524096C", hash_generated_method = "9A1D79DFC455FED0B173BC61C38003D4")
    public PendingIntent getRunningServiceControlPanel(ComponentName service) throws RemoteException {
        addTaint(service.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        service.writeToParcel(data, 0);
        mRemote.transact(GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION, data, reply, 0);
        reply.readException();
        PendingIntent res = PendingIntent.readPendingIntentOrNullFromParcel(reply);
        data.recycle();
        reply.recycle();
PendingIntent varB5053E025797B3BF768F5C37934C244D_2047410759 =         res;
        varB5053E025797B3BF768F5C37934C244D_2047410759.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_2047410759;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.248 -0400", hash_original_method = "A683CF3BA039B3B97AA6ADC23E6FBDCC", hash_generated_method = "8FC5574F2888D9773E8D618AF929F5A7")
    public ComponentName startService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException {
        addTaint(resolvedType.getTaint());
        addTaint(service.getTaint());
        addTaint(caller.getTaint());
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
ComponentName varB5053E025797B3BF768F5C37934C244D_1058210168 =         res;
        varB5053E025797B3BF768F5C37934C244D_1058210168.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1058210168;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.249 -0400", hash_original_method = "B5D9E3A4F6ABA893303F2F02B64751B8", hash_generated_method = "26C84687D5D987FB3B2DFD0EEE7CA262")
    public int stopService(IApplicationThread caller, Intent service,
            String resolvedType) throws RemoteException {
        addTaint(resolvedType.getTaint());
        addTaint(service.getTaint());
        addTaint(caller.getTaint());
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
        int var9B207167E5381C47682C6B4F58A623FB_569540986 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677215379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677215379;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.250 -0400", hash_original_method = "DB1BCCF2CB5E2532E24072B1F607F963", hash_generated_method = "1A3E4DB6E34595762344D9935EA36DCC")
    public boolean stopServiceToken(ComponentName className, IBinder token,
            int startId) throws RemoteException {
        addTaint(startId);
        addTaint(token.getTaint());
        addTaint(className.getTaint());
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
        boolean var9B207167E5381C47682C6B4F58A623FB_615446054 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1987611517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1987611517;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.252 -0400", hash_original_method = "9DE0D26C134349F3DA011E11517F3FF5", hash_generated_method = "AFAF01A9AA644F780ECC963EDB04241B")
    public void setServiceForeground(ComponentName className, IBinder token,
            int id, Notification notification, boolean removeNotification) throws RemoteException {
        addTaint(removeNotification);
        addTaint(notification.getTaint());
        addTaint(id);
        addTaint(token.getTaint());
        addTaint(className.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        ComponentName.writeToParcel(className, data);
        data.writeStrongBinder(token);
        data.writeInt(id);
    if(notification != null)        
        {
            data.writeInt(1);
            notification.writeToParcel(data, 0);
        } //End block
        else
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.255 -0400", hash_original_method = "A1E6D6F237E88697017FA79FBE451840", hash_generated_method = "BC7623570DA1218731CE4208C7CD00E0")
    public int bindService(IApplicationThread caller, IBinder token,
            Intent service, String resolvedType, IServiceConnection connection,
            int flags) throws RemoteException {
        addTaint(flags);
        addTaint(connection.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(service.getTaint());
        addTaint(token.getTaint());
        addTaint(caller.getTaint());
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
        int var9B207167E5381C47682C6B4F58A623FB_551258701 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1850356679 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1850356679;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.263 -0400", hash_original_method = "E0BD37EB96539E724DE863D335954DC9", hash_generated_method = "EE6CABEE94D1825A5AB119ACBE155ECA")
    public boolean unbindService(IServiceConnection connection) throws RemoteException {
        addTaint(connection.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(connection.asBinder());
        mRemote.transact(UNBIND_SERVICE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_495554970 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_605687600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_605687600;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.266 -0400", hash_original_method = "87A207496B270585D5EEA34C1AF57170", hash_generated_method = "62E2A5AA0BDE8905001277D60B27A6B4")
    public void publishService(IBinder token,
            Intent intent, IBinder service) throws RemoteException {
        addTaint(service.getTaint());
        addTaint(intent.getTaint());
        addTaint(token.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.268 -0400", hash_original_method = "3796516624A8D493E471933ECF7A3CD3", hash_generated_method = "20021A6F0FB54C6E552B5DF0C700D785")
    public void unbindFinished(IBinder token, Intent intent, boolean doRebind) throws RemoteException {
        addTaint(doRebind);
        addTaint(intent.getTaint());
        addTaint(token.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.269 -0400", hash_original_method = "1CB80C62A00C622E35F1B57A132292E9", hash_generated_method = "DA548906881EA8B8FCB68EFC46E515A8")
    public void serviceDoneExecuting(IBinder token, int type, int startId,
            int res) throws RemoteException {
        addTaint(res);
        addTaint(startId);
        addTaint(type);
        addTaint(token.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.270 -0400", hash_original_method = "BEF476EE5F43517187661CDC39F2A448", hash_generated_method = "6AC174832CC92DADA3F67F207985075A")
    public IBinder peekService(Intent service, String resolvedType) throws RemoteException {
        addTaint(resolvedType.getTaint());
        addTaint(service.getTaint());
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
IBinder varE3C074C8A98249A08331B334269AEB91_1437660643 =         binder;
        varE3C074C8A98249A08331B334269AEB91_1437660643.addTaint(taint);
        return varE3C074C8A98249A08331B334269AEB91_1437660643;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.272 -0400", hash_original_method = "7AACC08C389BEE0061373162626F356D", hash_generated_method = "99E66AB325DCCE51D9AB264D0A9F94F3")
    public boolean bindBackupAgent(ApplicationInfo app, int backupRestoreMode) throws RemoteException {
        addTaint(backupRestoreMode);
        addTaint(app.getTaint());
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
        boolean var260CA9DD8A4577FC00B7BD5810298076_1313219475 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1494787346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1494787346;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.273 -0400", hash_original_method = "ADE4561AB0FC3828104C329F05A9B88C", hash_generated_method = "28B27CE28821C9BE325F9E54983CBC5D")
    public void backupAgentCreated(String packageName, IBinder agent) throws RemoteException {
        addTaint(agent.getTaint());
        addTaint(packageName.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.273 -0400", hash_original_method = "80BB0DB939AA2A14DC79CE879293739F", hash_generated_method = "6259747324FCC6BC0D43428698D9A383")
    public void unbindBackupAgent(ApplicationInfo app) throws RemoteException {
        addTaint(app.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.275 -0400", hash_original_method = "7977DF3866173BBD9227641CB70C5B9A", hash_generated_method = "C28F8DA9E0A90D67B624BEF0F8BA142D")
    public boolean startInstrumentation(ComponentName className, String profileFile,
            int flags, Bundle arguments, IInstrumentationWatcher watcher) throws RemoteException {
        addTaint(watcher.getTaint());
        addTaint(arguments.getTaint());
        addTaint(flags);
        addTaint(profileFile.getTaint());
        addTaint(className.getTaint());
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
        boolean var9B207167E5381C47682C6B4F58A623FB_40994061 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93933772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_93933772;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.276 -0400", hash_original_method = "D76B5F1B397FC7028B59F12CA3604783", hash_generated_method = "388F99FCA832E7896CFA4581DBE67CA7")
    public void finishInstrumentation(IApplicationThread target,
            int resultCode, Bundle results) throws RemoteException {
        addTaint(results.getTaint());
        addTaint(resultCode);
        addTaint(target.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.277 -0400", hash_original_method = "E824FA9DB2D76671E24682EC782F4756", hash_generated_method = "799AC2DBF3A8481A52F1D14EBF863D0C")
    public Configuration getConfiguration() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        Configuration res = Configuration.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
Configuration varB5053E025797B3BF768F5C37934C244D_122135256 =         res;
        varB5053E025797B3BF768F5C37934C244D_122135256.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_122135256;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.278 -0400", hash_original_method = "76911A2717FEEEC7D6B4E93DC7F2427C", hash_generated_method = "A598E35947212C0A29FDA1ADF3B69BE3")
    public void updateConfiguration(Configuration values) throws RemoteException {
        addTaint(values.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.279 -0400", hash_original_method = "65FC5D17EF9FF3BF1BFFDA9CCA9A4BE1", hash_generated_method = "D5E678FBC0803C8AC161830850951BE7")
    public void setRequestedOrientation(IBinder token, int requestedOrientation) throws RemoteException {
        addTaint(requestedOrientation);
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.286 -0400", hash_original_method = "505D3FD7966F547E2BAA16E1C1C5F05B", hash_generated_method = "763FE5103A509910EA8A16BDDCC0007E")
    public int getRequestedOrientation(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_REQUESTED_ORIENTATION_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        data.recycle();
        reply.recycle();
        int var9B207167E5381C47682C6B4F58A623FB_1378866681 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508235243 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508235243;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.289 -0400", hash_original_method = "BCB55F79D75B3B83E49A75043EE249A9", hash_generated_method = "F8DD6A126A94C2CD238E35356DFE6773")
    public ComponentName getActivityClassForToken(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION, data, reply, 0);
        reply.readException();
        ComponentName res = ComponentName.readFromParcel(reply);
        data.recycle();
        reply.recycle();
ComponentName varB5053E025797B3BF768F5C37934C244D_1853091695 =         res;
        varB5053E025797B3BF768F5C37934C244D_1853091695.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1853091695;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.293 -0400", hash_original_method = "9BAE752D062408101ED2F689CF20DDD1", hash_generated_method = "A9BA96D337B6028783B9E5DF10546608")
    public String getPackageForToken(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(GET_PACKAGE_FOR_TOKEN_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
String varB5053E025797B3BF768F5C37934C244D_1486803703 =         res;
        varB5053E025797B3BF768F5C37934C244D_1486803703.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1486803703;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.297 -0400", hash_original_method = "AE56AE3D6914251F9FFFA7E33C698EB6", hash_generated_method = "320A6E45B5D7F88F9D4792AE9006B840")
    public IIntentSender getIntentSender(int type,
            String packageName, IBinder token, String resultWho,
            int requestCode, Intent[] intents, String[] resolvedTypes, int flags) throws RemoteException {
        addTaint(flags);
        addTaint(resolvedTypes[0].getTaint());
        addTaint(intents[0].getTaint());
        addTaint(requestCode);
        addTaint(resultWho.getTaint());
        addTaint(token.getTaint());
        addTaint(packageName.getTaint());
        addTaint(type);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(type);
        data.writeString(packageName);
        data.writeStrongBinder(token);
        data.writeString(resultWho);
        data.writeInt(requestCode);
    if(intents != null)        
        {
            data.writeInt(1);
            data.writeTypedArray(intents, 0);
            data.writeStringArray(resolvedTypes);
        } //End block
        else
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
IIntentSender varB5053E025797B3BF768F5C37934C244D_586971258 =         res;
        varB5053E025797B3BF768F5C37934C244D_586971258.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_586971258;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.300 -0400", hash_original_method = "D459AA1ADAE84FC2B7BB3BA73C047FDB", hash_generated_method = "B45FF815986B72C5F09946F78F6D45BD")
    public void cancelIntentSender(IIntentSender sender) throws RemoteException {
        addTaint(sender.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.301 -0400", hash_original_method = "1993496C4F183452017D412A9B9C5C29", hash_generated_method = "7DAEF3B917A713C4ED5B790D1A74CCFB")
    public String getPackageForIntentSender(IIntentSender sender) throws RemoteException {
        addTaint(sender.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(sender.asBinder());
        mRemote.transact(GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
String varB5053E025797B3BF768F5C37934C244D_2100799964 =         res;
        varB5053E025797B3BF768F5C37934C244D_2100799964.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_2100799964;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.302 -0400", hash_original_method = "92B622DC0CB7ED23BB116E8953A0A90A", hash_generated_method = "58FF39628A8FA2BB2BB9BDECE62DEAA4")
    public void setProcessLimit(int max) throws RemoteException {
        addTaint(max);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.303 -0400", hash_original_method = "4FA932EFF1C9BAC6AA973FE979D6B75F", hash_generated_method = "5F1767AEFA4648754BADFC828906D4AA")
    public int getProcessLimit() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_PROCESS_LIMIT_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        data.recycle();
        reply.recycle();
        int var9B207167E5381C47682C6B4F58A623FB_177000474 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602276179 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602276179;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.305 -0400", hash_original_method = "16F5E36D0F576E8CD2EC3F6B33B5169D", hash_generated_method = "66038015AF35C62348B8B8B985F29AEC")
    public void setProcessForeground(IBinder token, int pid,
            boolean isForeground) throws RemoteException {
        addTaint(isForeground);
        addTaint(pid);
        addTaint(token.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.307 -0400", hash_original_method = "A50C503DC3495EB643680A38372DD1F5", hash_generated_method = "922E44701A2F24FAA78C489FEDC5ED15")
    public int checkPermission(String permission, int pid, int uid) throws RemoteException {
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
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
        int var9B207167E5381C47682C6B4F58A623FB_936802681 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533893613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533893613;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.312 -0400", hash_original_method = "BE5C38AE92A5EE5CE45944FF93295090", hash_generated_method = "10DCC8CEDFF3877523304C72138D665F")
    public boolean clearApplicationUserData(final String packageName,
            final IPackageDataObserver observer) throws RemoteException {
        addTaint(observer.getTaint());
        addTaint(packageName.getTaint());
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
        boolean var9B207167E5381C47682C6B4F58A623FB_545351312 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1048448319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1048448319;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.313 -0400", hash_original_method = "FEF4F93E5B02F55707A11B36638BBB59", hash_generated_method = "68F31481F44BBB29BCB77B18190F9073")
    public int checkUriPermission(Uri uri, int pid, int uid, int mode) throws RemoteException {
        addTaint(mode);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
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
        int var9B207167E5381C47682C6B4F58A623FB_117408858 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394567565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394567565;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.315 -0400", hash_original_method = "2CEB2CA82A36297F49BF5DB3286E579B", hash_generated_method = "CF51A08F5792E5A4520861FF10ADBEEE")
    public void grantUriPermission(IApplicationThread caller, String targetPkg,
            Uri uri, int mode) throws RemoteException {
        addTaint(mode);
        addTaint(uri.getTaint());
        addTaint(targetPkg.getTaint());
        addTaint(caller.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.317 -0400", hash_original_method = "84D534ABCBC85608735C63399D2C9E1E", hash_generated_method = "E901FFEA3C64B01E4CCC51D33D232D97")
    public void revokeUriPermission(IApplicationThread caller, Uri uri,
            int mode) throws RemoteException {
        addTaint(mode);
        addTaint(uri.getTaint());
        addTaint(caller.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.318 -0400", hash_original_method = "7FC96553233904C2463E3D793E528211", hash_generated_method = "C7712E98882E9319805DA3509ACD5F02")
    public void showWaitingForDebugger(IApplicationThread who, boolean waiting) throws RemoteException {
        addTaint(waiting);
        addTaint(who.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.321 -0400", hash_original_method = "40DDB58D1BE7B54E85772ACF1AA60D8F", hash_generated_method = "8507240D01A2B14EF9DC1090F1FC52D6")
    public void getMemoryInfo(ActivityManager.MemoryInfo outInfo) throws RemoteException {
        addTaint(outInfo.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.322 -0400", hash_original_method = "805F881D84830966D1AD0B083D69DA9A", hash_generated_method = "35908FEA5D27261ECFCDD707C4543E2A")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.323 -0400", hash_original_method = "1E46E6C9628834765008140B25990D23", hash_generated_method = "046E62ABCD8283F831657152AA43BD74")
    public ParcelFileDescriptor openContentUri(Uri uri) throws RemoteException {
        addTaint(uri.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(OPEN_CONTENT_URI_TRANSACTION, data, reply, 0);
        reply.readException();
        ParcelFileDescriptor pfd = null;
    if(reply.readInt() != 0)        
        {
            pfd = ParcelFileDescriptor.CREATOR.createFromParcel(reply);
        } //End block
        data.recycle();
        reply.recycle();
ParcelFileDescriptor varC93E3EE3359509D81434E9F216020655_2036154931 =         pfd;
        varC93E3EE3359509D81434E9F216020655_2036154931.addTaint(taint);
        return varC93E3EE3359509D81434E9F216020655_2036154931;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.324 -0400", hash_original_method = "E3BC510BF36E68FD23494212AB6E7B33", hash_generated_method = "6FA7FC22CC4827A9155BA6D48B3496C5")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.325 -0400", hash_original_method = "CAFF51A84FC631E180A23D0F5290B43F", hash_generated_method = "DC06BAFA4F4E0DC663C4ACFECCEA0503")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.326 -0400", hash_original_method = "482C4468B37AD6CEF12EA376A273F16E", hash_generated_method = "CFB2704B034ABD0A4652BB6A1DF03397")
    public void setDebugApp(
        String packageName, boolean waitForDebugger, boolean persistent) throws RemoteException {
        addTaint(persistent);
        addTaint(waitForDebugger);
        addTaint(packageName.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.327 -0400", hash_original_method = "DE27B8A416D8E1FF87F079AFA1567A6E", hash_generated_method = "BC152414091454321D52597CA23D4EB9")
    public void setAlwaysFinish(boolean enabled) throws RemoteException {
        addTaint(enabled);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.328 -0400", hash_original_method = "D7DBDAD7386DC1F45D7A9AB12513A49B", hash_generated_method = "C59DB7B888B59E3300BD09B3F29EB2A4")
    public void setActivityController(IActivityController watcher) throws RemoteException {
        addTaint(watcher.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.330 -0400", hash_original_method = "FF7EEF7728CACAD7286D113A3CF07513", hash_generated_method = "989FB5B63F9FFE72C2D1A765411C7755")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.333 -0400", hash_original_method = "72F87C80970F6885E4DCD6DA1B2F19E8", hash_generated_method = "4ED05EDABD114762A9EC5452337A5CD6")
    public void noteWakeupAlarm(IIntentSender sender) throws RemoteException {
        addTaint(sender.getTaint());
        Parcel data = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.336 -0400", hash_original_method = "DB2721BD1E4C8F1064AA0461CF2A490B", hash_generated_method = "22BE5FFF00B9D9E45D801B2A0A3E9408")
    public boolean killPids(int[] pids, String reason, boolean secure) throws RemoteException {
        addTaint(secure);
        addTaint(reason.getTaint());
        addTaint(pids[0]);
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1191058232 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312334207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312334207;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.338 -0400", hash_original_method = "9964526F9DDC53538E50ED934A9D4009", hash_generated_method = "E8702DF9E30424744B53A3AC0BEFF968")
    public void startRunning(String pkg, String cls, String action,
            String indata) throws RemoteException {
        addTaint(indata.getTaint());
        addTaint(action.getTaint());
        addTaint(cls.getTaint());
        addTaint(pkg.getTaint());
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.341 -0400", hash_original_method = "6C8B2FE75A3BFFE16EADA916F678A09D", hash_generated_method = "4AED8114D048C2258F0DAEA9ADA42C5C")
    public boolean testIsSystemReady() {
        boolean varB326B5062B2F0E69046810717534CB09_2075278513 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_831347660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_831347660;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.342 -0400", hash_original_method = "523AF9597115E332AF2A1F534C49483C", hash_generated_method = "FD1A66F38E90C4A17E41A176F0A17D5D")
    public void handleApplicationCrash(IBinder app,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
        addTaint(crashInfo.getTaint());
        addTaint(app.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.343 -0400", hash_original_method = "84EFC78EC4B379D270C222A7BC31C5F7", hash_generated_method = "E69BA27A1E884AFEDBEF28AA71B4DDCC")
    public boolean handleApplicationWtf(IBinder app, String tag,
            ApplicationErrorReport.CrashInfo crashInfo) throws RemoteException {
        addTaint(crashInfo.getTaint());
        addTaint(tag.getTaint());
        addTaint(app.getTaint());
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
        boolean var9B207167E5381C47682C6B4F58A623FB_2044970981 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_13428442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_13428442;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.344 -0400", hash_original_method = "7AC27E481709B1F0B25AE2BA23B3BECF", hash_generated_method = "2037FE079886D4FF19B4C0E773537EB4")
    public void handleApplicationStrictModeViolation(IBinder app,
            int violationMask,
            StrictMode.ViolationInfo info) throws RemoteException {
        addTaint(info.getTaint());
        addTaint(violationMask);
        addTaint(app.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.345 -0400", hash_original_method = "22BD8EFAE7A36DA76D8B0F7F297E970D", hash_generated_method = "66974AC6886E099865AE2C53DE8E176A")
    public void signalPersistentProcesses(int sig) throws RemoteException {
        addTaint(sig);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.346 -0400", hash_original_method = "3D80332C8A0FCAFBCE220FADA30302CB", hash_generated_method = "A143D8EF9FE7A708D18E0CBF07DCD600")
    public void killBackgroundProcesses(String packageName) throws RemoteException {
        addTaint(packageName.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.347 -0400", hash_original_method = "C7F5D3EA775AD04DD438191F0B4D22C4", hash_generated_method = "3A4D09A3259986E047E1536B505B4986")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.348 -0400", hash_original_method = "CB4D9E734B2DC6A00C763BA9D15D84CC", hash_generated_method = "8E556AE5FF2BC400F94C02FB03918977")
    public void forceStopPackage(String packageName) throws RemoteException {
        addTaint(packageName.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.349 -0400", hash_original_method = "9F4AADDAC8F1648FD8C80C6B88BBF25F", hash_generated_method = "3EA6412EE87F455A560D1C48C3AF4D91")
    public ConfigurationInfo getDeviceConfigurationInfo() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_DEVICE_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        ConfigurationInfo res = ConfigurationInfo.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
ConfigurationInfo varB5053E025797B3BF768F5C37934C244D_1036836205 =         res;
        varB5053E025797B3BF768F5C37934C244D_1036836205.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1036836205;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.351 -0400", hash_original_method = "10D7A082C97EAFB331405B7841F1651D", hash_generated_method = "ED32DC41F6FC244426C18E88103C9792")
    public boolean profileControl(String process, boolean start,
            String path, ParcelFileDescriptor fd, int profileType) throws RemoteException {
        addTaint(profileType);
        addTaint(fd.getTaint());
        addTaint(path.getTaint());
        addTaint(start);
        addTaint(process.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(process);
        data.writeInt(start ? 1 : 0);
        data.writeInt(profileType);
        data.writeString(path);
    if(fd != null)        
        {
            data.writeInt(1);
            fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        else
        {
            data.writeInt(0);
        } //End block
        mRemote.transact(PROFILE_CONTROL_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_823170849 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1021970225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1021970225;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.352 -0400", hash_original_method = "52F9DB0BA2A0AB8C52093D208807035C", hash_generated_method = "424FA38BE0E81DC259B2FCEFB8DA850B")
    public boolean shutdown(int timeout) throws RemoteException {
        addTaint(timeout);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(timeout);
        mRemote.transact(SHUTDOWN_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_1485132504 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1873377131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1873377131;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.353 -0400", hash_original_method = "BE7DD92CBAD030A60DB7090E3408574C", hash_generated_method = "13EA54D36EF6A74A6B8F116EB09B864A")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.354 -0400", hash_original_method = "0EC9793095E20007EC76AB5DDDE4E54A", hash_generated_method = "6608F43B59121217A1614CC63240E42A")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.355 -0400", hash_original_method = "7B78E2FEC61CC471A8E07C6C34C74BD6", hash_generated_method = "3817B8C1148D03480BC754EDE7A8783D")
    public void registerActivityWatcher(IActivityWatcher watcher) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(watcher.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.357 -0400", hash_original_method = "8E5D6F085FE02A1442C5A617ADA012EC", hash_generated_method = "422F700E252479C0B5F466D7DC0E4DE8")
    public void unregisterActivityWatcher(IActivityWatcher watcher) throws RemoteException {
        addTaint(watcher.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.360 -0400", hash_original_method = "C65F778BCD540838D47FE4E4412CD25E", hash_generated_method = "D90BE9BB9FB67A080236B2358463483D")
    public int startActivityInPackage(int uid,
            Intent intent, String resolvedType, IBinder resultTo,
            String resultWho, int requestCode, boolean onlyIfNeeded) throws RemoteException {
        addTaint(onlyIfNeeded);
        addTaint(requestCode);
        addTaint(resultWho.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resolvedType.getTaint());
        addTaint(intent.getTaint());
        addTaint(uid);
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
        int varB4A88417B3D0170D754C647C30B7216A_1409197700 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977067296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977067296;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.363 -0400", hash_original_method = "9BA7CBE5CC5118373D7AAA1497A47635", hash_generated_method = "56C3E1DE667BB3576E49BAFE5D963B30")
    public void killApplicationWithUid(String pkg, int uid) throws RemoteException {
        addTaint(uid);
        addTaint(pkg.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.365 -0400", hash_original_method = "2A680A4513BB1B95074F3F876F148BA8", hash_generated_method = "CCD69A33D5C91B5C3FDC0289CB9A6D5F")
    public void closeSystemDialogs(String reason) throws RemoteException {
        addTaint(reason.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.367 -0400", hash_original_method = "BD88F62F5112FCE1DE930509EBB83FD2", hash_generated_method = "A05DBC738BA6358480D9DF69485A772F")
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) throws RemoteException {
        addTaint(pids[0]);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeIntArray(pids);
        mRemote.transact(GET_PROCESS_MEMORY_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        Debug.MemoryInfo[] res = reply.createTypedArray(Debug.MemoryInfo.CREATOR);
        data.recycle();
        reply.recycle();
Debug.MemoryInfo[] varB5053E025797B3BF768F5C37934C244D_2126301097 =         res;
        varB5053E025797B3BF768F5C37934C244D_2126301097.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_2126301097;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.367 -0400", hash_original_method = "0F16B6E02208618C1D3EE91B8DD80482", hash_generated_method = "1B738F24D07087FD02B2D59E509B713F")
    public void killApplicationProcess(String processName, int uid) throws RemoteException {
        addTaint(uid);
        addTaint(processName.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.369 -0400", hash_original_method = "00D6B54E331AC7AA3DC1F40B928FA3FD", hash_generated_method = "8E486799830066FC292A7C7FC3D309FA")
    public void overridePendingTransition(IBinder token, String packageName,
            int enterAnim, int exitAnim) throws RemoteException {
        addTaint(exitAnim);
        addTaint(enterAnim);
        addTaint(packageName.getTaint());
        addTaint(token.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.370 -0400", hash_original_method = "0F906B538EF84DE09E15BAB8CDAE69C4", hash_generated_method = "0652D1029BAC73439E8561C6597BFF2E")
    public boolean isUserAMonkey() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(IS_USER_A_MONKEY_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_1984689862 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1435356970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1435356970;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.372 -0400", hash_original_method = "CE9EE2ABB9C16E19ED0FB5ECED80A2D8", hash_generated_method = "EB822339041D216CF933014C954FB685")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.374 -0400", hash_original_method = "468B67BFEE008B6CDEC37F42802988FA", hash_generated_method = "D6FA49ACB785B0E7C25A90613825F575")
    public void setImmersive(IBinder token, boolean immersive) throws RemoteException {
        addTaint(immersive);
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.375 -0400", hash_original_method = "12E814937BEB239BDABA8A5EE4F6D00D", hash_generated_method = "87FA552703960E1437851F089D5943C7")
    public boolean isImmersive(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(IS_IMMERSIVE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() == 1;
        data.recycle();
        reply.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_958084765 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_236268885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_236268885;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.376 -0400", hash_original_method = "0342E1772D9E2D527D167E41870AA176", hash_generated_method = "F37F9AA25AF2E53A1C50C09C2998F747")
    public boolean isTopActivityImmersive() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() == 1;
        data.recycle();
        reply.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_218435837 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_275955955 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_275955955;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.377 -0400", hash_original_method = "574D561A4B99545A454A313F9DD764D8", hash_generated_method = "212787E8DECFA699AF9375978DC419FB")
    public void crashApplication(int uid, int initialPid, String packageName,
            String message) throws RemoteException {
        addTaint(message.getTaint());
        addTaint(packageName.getTaint());
        addTaint(initialPid);
        addTaint(uid);
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.378 -0400", hash_original_method = "CF06029063749F4266D5EFBB16694E04", hash_generated_method = "C82E88D074E3C75D29BF201799C35DE4")
    public String getProviderMimeType(Uri uri) throws RemoteException {
        addTaint(uri.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        uri.writeToParcel(data, 0);
        mRemote.transact(GET_PROVIDER_MIME_TYPE_TRANSACTION, data, reply, 0);
        reply.readException();
        String res = reply.readString();
        data.recycle();
        reply.recycle();
String varB5053E025797B3BF768F5C37934C244D_2028046883 =         res;
        varB5053E025797B3BF768F5C37934C244D_2028046883.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_2028046883;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.380 -0400", hash_original_method = "A975CD5E1392FBC42C40F56501282DDB", hash_generated_method = "C2447BAFE990B102691485F9CEA7B2B2")
    public IBinder newUriPermissionOwner(String name) throws RemoteException {
        addTaint(name.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(name);
        mRemote.transact(NEW_URI_PERMISSION_OWNER_TRANSACTION, data, reply, 0);
        reply.readException();
        IBinder res = reply.readStrongBinder();
        data.recycle();
        reply.recycle();
IBinder varB5053E025797B3BF768F5C37934C244D_1368296163 =         res;
        varB5053E025797B3BF768F5C37934C244D_1368296163.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1368296163;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.385 -0400", hash_original_method = "1C35FE424D422C73471D9ECEE35C4093", hash_generated_method = "0FBD6A1EE34CA0659502DAE0423D0CDB")
    public void grantUriPermissionFromOwner(IBinder owner, int fromUid, String targetPkg,
            Uri uri, int mode) throws RemoteException {
        addTaint(mode);
        addTaint(uri.getTaint());
        addTaint(targetPkg.getTaint());
        addTaint(fromUid);
        addTaint(owner.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.387 -0400", hash_original_method = "D07898A73558FBA66858F774589B082E", hash_generated_method = "7A2746B9C5AA4E0478034865BF9597FA")
    public void revokeUriPermissionFromOwner(IBinder owner, Uri uri,
            int mode) throws RemoteException {
        addTaint(mode);
        addTaint(uri.getTaint());
        addTaint(owner.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(owner);
    if(uri != null)        
        {
            data.writeInt(1);
            uri.writeToParcel(data, 0);
        } //End block
        else
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.389 -0400", hash_original_method = "3DAB9C9F42020370AD19E1FE0AC1BDCE", hash_generated_method = "E3EC32944079D307ECA83E0EBF757466")
    public int checkGrantUriPermission(int callingUid, String targetPkg,
            Uri uri, int modeFlags) throws RemoteException {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        addTaint(targetPkg.getTaint());
        addTaint(callingUid);
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
        int var9B207167E5381C47682C6B4F58A623FB_166280438 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248136883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248136883;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.392 -0400", hash_original_method = "2510375C73B367DE6AAF634BB948BB50", hash_generated_method = "E1B355EEA0555AD6560D8711F870D785")
    public boolean dumpHeap(String process, boolean managed,
            String path, ParcelFileDescriptor fd) throws RemoteException {
        addTaint(fd.getTaint());
        addTaint(path.getTaint());
        addTaint(managed);
        addTaint(process.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(process);
        data.writeInt(managed ? 1 : 0);
        data.writeString(path);
    if(fd != null)        
        {
            data.writeInt(1);
            fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        else
        {
            data.writeInt(0);
        } //End block
        mRemote.transact(DUMP_HEAP_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_500162274 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544861465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544861465;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.396 -0400", hash_original_method = "D5FED7EEA920B3F53E1885BDA832FF44", hash_generated_method = "A5CAAE05213A3FEB97B5FD9086A86472")
    public int startActivities(IApplicationThread caller,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException {
        addTaint(resultTo.getTaint());
        addTaint(resolvedTypes[0].getTaint());
        addTaint(intents[0].getTaint());
        addTaint(caller.getTaint());
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
        int varB4A88417B3D0170D754C647C30B7216A_544304314 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824693982 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824693982;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.397 -0400", hash_original_method = "7A44848B4F4A570D7B280FD97AA3F11F", hash_generated_method = "DB1B08FBF0D19D66D3C2DDF8761CA9F1")
    public int startActivitiesInPackage(int uid,
            Intent[] intents, String[] resolvedTypes, IBinder resultTo) throws RemoteException {
        addTaint(resultTo.getTaint());
        addTaint(resolvedTypes[0].getTaint());
        addTaint(intents[0].getTaint());
        addTaint(uid);
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
        int varB4A88417B3D0170D754C647C30B7216A_1811505892 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617163714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617163714;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.398 -0400", hash_original_method = "11A1C93F201BB77459CE48D94392036A", hash_generated_method = "E18F94130C94BE1EB0E778AB180A4CD2")
    public int getFrontActivityScreenCompatMode() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        int mode = reply.readInt();
        reply.recycle();
        data.recycle();
        int var15D61712450A686A7F365ADF4FEF581F_447798071 = (mode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961169875 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961169875;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.399 -0400", hash_original_method = "984BA2CED473A0F45E8080D25CCDF41F", hash_generated_method = "5371A5E89FE691053FE96BE0157388A3")
    public void setFrontActivityScreenCompatMode(int mode) throws RemoteException {
        addTaint(mode);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.401 -0400", hash_original_method = "AFAFCB6FF2EC7CDD310E0CDC4C512BE7", hash_generated_method = "54C3109FA0840AC02F46582FDF94F926")
    public int getPackageScreenCompatMode(String packageName) throws RemoteException {
        addTaint(packageName.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        mRemote.transact(GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        int mode = reply.readInt();
        reply.recycle();
        data.recycle();
        int var15D61712450A686A7F365ADF4FEF581F_921309411 = (mode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928161607 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928161607;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.403 -0400", hash_original_method = "5B0C9EEE90D8463E1DCC15B68E3829E8", hash_generated_method = "0611C88E6D8749AEE8F419C10EED9175")
    public void setPackageScreenCompatMode(String packageName, int mode) throws RemoteException {
        addTaint(mode);
        addTaint(packageName.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.404 -0400", hash_original_method = "7AFCEC9BC7A2DAB54F3EFFA101044309", hash_generated_method = "218A009B4606FCB9D1A6409A57E38839")
    public boolean getPackageAskScreenCompat(String packageName) throws RemoteException {
        addTaint(packageName.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeString(packageName);
        mRemote.transact(GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean ask = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        boolean var5ED33F7008771C9D49E3716AEAECA581_1008801689 = (ask);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1442130671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1442130671;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.409 -0400", hash_original_method = "8C9BAA94A3976358AA466F180A11AE45", hash_generated_method = "3300641A7DAB48661114DCE5161A692F")
    public void setPackageAskScreenCompat(String packageName, boolean ask) throws RemoteException {
        addTaint(ask);
        addTaint(packageName.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.412 -0400", hash_original_method = "0A8E6FD2F20689E2107BCC0911A72467", hash_generated_method = "D9B8D56507F29391EF8726CDAE615E14")
    public boolean switchUser(int userid) throws RemoteException {
        addTaint(userid);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeInt(userid);
        mRemote.transact(SWITCH_USER_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean result = reply.readInt() != 0;
        reply.recycle();
        data.recycle();
        boolean varB4A88417B3D0170D754C647C30B7216A_868139464 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1431872812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1431872812;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.415 -0400", hash_original_method = "4161F4F4B6F51E7616ED3E0F5DA99E10", hash_generated_method = "CA5063DB130AEB03EF39AAE94F97D9E5")
    public boolean removeSubTask(int taskId, int subTaskIndex) throws RemoteException {
        addTaint(subTaskIndex);
        addTaint(taskId);
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
        boolean varB4A88417B3D0170D754C647C30B7216A_863324641 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013160154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013160154;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.418 -0400", hash_original_method = "D75556E86E98C9E69E5D8B6835FF1B1D", hash_generated_method = "FA220803B058E72521DCA7267F7D345C")
    public boolean removeTask(int taskId, int flags) throws RemoteException {
        addTaint(flags);
        addTaint(taskId);
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
        boolean varB4A88417B3D0170D754C647C30B7216A_497812357 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1249725935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1249725935;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.419 -0400", hash_original_method = "AD040AF08607A87C88C9CB9BE1E3C408", hash_generated_method = "F79D0782D7ADBF945089C278A2C3F53F")
    public void registerProcessObserver(IProcessObserver observer) throws RemoteException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.420 -0400", hash_original_method = "6FB2BE2D02A98F343D51290C94466533", hash_generated_method = "BA2307A78A229CAF14012903983D4FE7")
    public void unregisterProcessObserver(IProcessObserver observer) throws RemoteException {
        addTaint(observer.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.421 -0400", hash_original_method = "A45994938B7DA24AED12FFC5B3B3DD69", hash_generated_method = "868FC91218900EBFDFFB0AB85025B5B4")
    public boolean isIntentSenderTargetedToPackage(IIntentSender sender) throws RemoteException {
        addTaint(sender.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeStrongBinder(sender.asBinder());
        mRemote.transact(IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_1089315724 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541336384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_541336384;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.422 -0400", hash_original_method = "ACD180EA48DE1CCAABBA4B90AA3470B8", hash_generated_method = "8B2FC9725333FEE6D7F1989697BCAA6C")
    public void updatePersistentConfiguration(Configuration values) throws RemoteException {
        addTaint(values.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.423 -0400", hash_original_method = "0E9D1ED4F0E7DC85612AA1E9A3EC65BE", hash_generated_method = "F880A8F8281F47DFE5F22510345F86EB")
    public long[] getProcessPss(int[] pids) throws RemoteException {
        addTaint(pids[0]);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        data.writeIntArray(pids);
        mRemote.transact(GET_PROCESS_PSS_TRANSACTION, data, reply, 0);
        reply.readException();
        long[] res = reply.createLongArray();
        data.recycle();
        reply.recycle();
        long[] var9B207167E5381C47682C6B4F58A623FB_702977956 = (res);
                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1596726584 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1596726584;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.424 -0400", hash_original_method = "F6DDBF719DC0D2BCB3D721A826004A98", hash_generated_method = "D052AF57D70CC86B23BEFAD4AC2C5DB9")
    public void showBootMessage(CharSequence msg, boolean always) throws RemoteException {
        addTaint(always);
        addTaint(msg.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:58.425 -0400", hash_original_method = "C6C48FDB33104FCE337F1D8C3A233E89", hash_generated_method = "8F5505827E88689D1F08B162EE225802")
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

