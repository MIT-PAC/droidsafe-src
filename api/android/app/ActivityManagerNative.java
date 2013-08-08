package android.app;

// Droidsafe Imports
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
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.868 -0400", hash_original_method = "444DC66B3432907DFEA55328E5B69649", hash_generated_method = "FF0B4D083A157B879D7CD5A2215454A9")
    public  ActivityManagerNative() {
        attachInterface(this, descriptor);
        // ---------- Original Method ----------
        //attachInterface(this, descriptor);
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    static public IActivityManager getDefault() {
        return gDefault.get();
    }

    
    @DSModeled(DSC.BAN)
    static public boolean isSystemReady() {
        if (!sSystemReady) {
            sSystemReady = getDefault().testIsSystemReady();
        }
        return sSystemReady;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.917 -0400", hash_original_method = "796B52B1E8846F7CCEC22CD4B5B906A8", hash_generated_method = "4DFCE4B7A3473BD7F930CA415A79587F")
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
            boolean varB326B5062B2F0E69046810717534CB09_1998635402 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1540079983 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1540079983;
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
            boolean varB326B5062B2F0E69046810717534CB09_1546998678 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308285845 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308285845;
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
            boolean varB326B5062B2F0E69046810717534CB09_1038158626 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_327270778 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_327270778;
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
            boolean varB326B5062B2F0E69046810717534CB09_353733824 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_941090415 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_941090415;
        } //End block
        case START_NEXT_MATCHING_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder callingActivity = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            boolean result = startNextMatchingActivity(callingActivity, intent);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1136982979 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895330394 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895330394;
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
            boolean varB326B5062B2F0E69046810717534CB09_1543099117 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806350780 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_806350780;
        } //End block
        case FINISH_SUB_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            String resultWho = data.readString();
            int requestCode = data.readInt();
            finishSubActivity(token, resultWho, requestCode);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_532667419 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_791329842 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_791329842;
        } //End block
        case WILL_ACTIVITY_BE_VISIBLE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean res = willActivityBeVisible(token);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1672909928 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1514798853 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1514798853;
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
            boolean varB326B5062B2F0E69046810717534CB09_1869346993 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226610766 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226610766;
        } //End block
        case UNREGISTER_RECEIVER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            if(b == null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_43391757 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399974926 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399974926;
            } //End block
            IIntentReceiver rec = IIntentReceiver.Stub.asInterface(b);
            unregisterReceiver(rec);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1875363398 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2107736850 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2107736850;
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
            boolean varB326B5062B2F0E69046810717534CB09_75667388 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1230723803 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1230723803;
        } //End block
        case UNBROADCAST_INTENT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = b != null ? ApplicationThreadNative.asInterface(b) : null;
            Intent intent = Intent.CREATOR.createFromParcel(data);
            unbroadcastIntent(app, intent);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_82837142 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_409595353 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_409595353;
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
            boolean varB326B5062B2F0E69046810717534CB09_1031884239 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493303414 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493303414;
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
            boolean varB326B5062B2F0E69046810717534CB09_247190489 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_635621643 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_635621643;
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
            boolean varB326B5062B2F0E69046810717534CB09_120161921 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_262598380 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_262598380;
        } //End block
        case ACTIVITY_PAUSED_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activityPaused(token);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_678780298 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_976555769 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_976555769;
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
            boolean varB326B5062B2F0E69046810717534CB09_1242492253 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8389451 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_8389451;
        } //End block
        case ACTIVITY_SLEPT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activitySlept(token);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_22872564 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245661068 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245661068;
        } //End block
        case ACTIVITY_DESTROYED_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            activityDestroyed(token);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_992894345 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_54041454 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_54041454;
        } //End block
        case GET_CALLING_PACKAGE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            String res = token != null ? getCallingPackage(token) : null;
            reply.writeNoException();
            reply.writeString(res);
            boolean varB326B5062B2F0E69046810717534CB09_1172756693 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544224242 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544224242;
        } //End block
        case GET_CALLING_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName cn = getCallingActivity(token);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
            boolean varB326B5062B2F0E69046810717534CB09_670747383 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588044960 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588044960;
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
            boolean varB326B5062B2F0E69046810717534CB09_1406414824 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609449880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609449880;
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
            boolean varB326B5062B2F0E69046810717534CB09_506240554 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1205665651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1205665651;
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
            boolean varB326B5062B2F0E69046810717534CB09_1881785596 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1475433039 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1475433039;
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
            boolean varB326B5062B2F0E69046810717534CB09_1062769431 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2007004461 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2007004461;
        } //End block
        case GET_PROCESSES_IN_ERROR_STATE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ActivityManager.ProcessErrorStateInfo> list = getProcessesInErrorState();
            reply.writeNoException();
            reply.writeTypedList(list);
            boolean varB326B5062B2F0E69046810717534CB09_1300137394 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1586523400 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1586523400;
        } //End block
        case GET_RUNNING_APP_PROCESSES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ActivityManager.RunningAppProcessInfo> list = getRunningAppProcesses();
            reply.writeNoException();
            reply.writeTypedList(list);
            boolean varB326B5062B2F0E69046810717534CB09_745550794 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1251614349 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1251614349;
        } //End block
        case GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            List<ApplicationInfo> list = getRunningExternalApplications();
            reply.writeNoException();
            reply.writeTypedList(list);
            boolean varB326B5062B2F0E69046810717534CB09_274736467 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953122709 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_953122709;
        } //End block
        case MOVE_TASK_TO_FRONT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            int fl = data.readInt();
            moveTaskToFront(task, fl);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1303290890 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1164667092 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1164667092;
        } //End block
        case MOVE_TASK_TO_BACK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            moveTaskToBack(task);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_926030611 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_601797274 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_601797274;
        } //End block
        case MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean nonRoot = data.readInt() != 0;
            boolean res = moveActivityTaskToBack(token, nonRoot);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_2100605131 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112124663 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112124663;
        } //End block
        case MOVE_TASK_BACKWARDS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int task = data.readInt();
            moveTaskBackwards(task);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1930387273 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1014281226 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1014281226;
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
            boolean varB326B5062B2F0E69046810717534CB09_422928795 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756786194 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_756786194;
        } //End block
        case FINISH_OTHER_INSTANCES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName className = ComponentName.readFromParcel(data);
            finishOtherInstances(token, className);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1783563332 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_991003888 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_991003888;
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
            boolean varB326B5062B2F0E69046810717534CB09_893523827 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1900392574 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1900392574;
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
            boolean varB326B5062B2F0E69046810717534CB09_204552 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1123807875 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1123807875;
        } //End block
        case PUBLISH_CONTENT_PROVIDERS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            ArrayList<ContentProviderHolder> providers = data.createTypedArrayList(ContentProviderHolder.CREATOR);
            publishContentProviders(app, providers);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1139877685 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382218729 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_382218729;
        } //End block
        case REMOVE_CONTENT_PROVIDER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            String name = data.readString();
            removeContentProvider(app, name);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_726758270 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2022933742 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2022933742;
        } //End block
        case GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ComponentName comp = ComponentName.CREATOR.createFromParcel(data);
            PendingIntent pi = getRunningServiceControlPanel(comp);
            reply.writeNoException();
            PendingIntent.writePendingIntentOrNullToParcel(pi, reply);
            boolean varB326B5062B2F0E69046810717534CB09_1148299319 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866293306 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866293306;
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
            boolean varB326B5062B2F0E69046810717534CB09_824476324 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296827404 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296827404;
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
            boolean varB326B5062B2F0E69046810717534CB09_1234325557 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025271202 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025271202;
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
            boolean varB326B5062B2F0E69046810717534CB09_491219887 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833476087 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_833476087;
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
            boolean varB326B5062B2F0E69046810717534CB09_1635875682 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1757816344 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1757816344;
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
            boolean varB326B5062B2F0E69046810717534CB09_1307882778 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_23147667 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_23147667;
        } //End block
        case UNBIND_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IServiceConnection conn = IServiceConnection.Stub.asInterface(b);
            boolean res = unbindService(conn);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1966496929 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1125108986 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1125108986;
        } //End block
        case PUBLISH_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            IBinder service = data.readStrongBinder();
            publishService(token, intent, service);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1699831044 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1267184704 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1267184704;
        } //End block
        case UNBIND_FINISHED_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            boolean doRebind = data.readInt() != 0;
            unbindFinished(token, intent, doRebind);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_532118911 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_518075281 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_518075281;
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
            boolean varB326B5062B2F0E69046810717534CB09_1821112800 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823491812 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823491812;
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
            boolean varB326B5062B2F0E69046810717534CB09_1184992196 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88936118 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_88936118;
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
            boolean varB326B5062B2F0E69046810717534CB09_909915449 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340442098 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_340442098;
        } //End block
        case GET_CONFIGURATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = getConfiguration();
            reply.writeNoException();
            config.writeToParcel(reply, 0);
            boolean varB326B5062B2F0E69046810717534CB09_678162508 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_408169461 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_408169461;
        } //End block
        case UPDATE_CONFIGURATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            updateConfiguration(config);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1958720946 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161121640 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161121640;
        } //End block
        case SET_REQUESTED_ORIENTATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int requestedOrientation = data.readInt();
            setRequestedOrientation(token, requestedOrientation);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1855189847 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1106607968 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1106607968;
        } //End block
        case GET_REQUESTED_ORIENTATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int req = getRequestedOrientation(token);
            reply.writeNoException();
            reply.writeInt(req);
            boolean varB326B5062B2F0E69046810717534CB09_1460132237 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_516770215 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_516770215;
        } //End block
        case GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            ComponentName cn = getActivityClassForToken(token);
            reply.writeNoException();
            ComponentName.writeToParcel(cn, reply);
            boolean varB326B5062B2F0E69046810717534CB09_150843944 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1924823789 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1924823789;
        } //End block
        case GET_PACKAGE_FOR_TOKEN_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            reply.writeNoException();
            reply.writeString(getPackageForToken(token));
            boolean varB326B5062B2F0E69046810717534CB09_1867340921 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1723111183 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1723111183;
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
            boolean varB326B5062B2F0E69046810717534CB09_270266353 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1704640945 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1704640945;
        } //End block
        case CANCEL_INTENT_SENDER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            cancelIntentSender(r);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_162089625 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338247669 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_338247669;
        } //End block
        case GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            String res = getPackageForIntentSender(r);
            reply.writeNoException();
            reply.writeString(res);
            boolean varB326B5062B2F0E69046810717534CB09_52389468 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_588730462 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_588730462;
        } //End block
        case SET_PROCESS_LIMIT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int max = data.readInt();
            setProcessLimit(max);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1143498647 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_521766325 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_521766325;
        } //End block
        case GET_PROCESS_LIMIT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int limit = getProcessLimit();
            reply.writeNoException();
            reply.writeInt(limit);
            boolean varB326B5062B2F0E69046810717534CB09_877454262 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1428384078 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1428384078;
        } //End block
        case SET_PROCESS_FOREGROUND_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            int pid = data.readInt();
            boolean isForeground = data.readInt() != 0;
            setProcessForeground(token, pid, isForeground);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_976846344 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1486878458 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1486878458;
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
            boolean varB326B5062B2F0E69046810717534CB09_1325910531 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1572497048 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1572497048;
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
            boolean varB326B5062B2F0E69046810717534CB09_2043470491 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1110392156 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1110392156;
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
            boolean varB326B5062B2F0E69046810717534CB09_2139751337 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_713310426 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_713310426;
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
            boolean varB326B5062B2F0E69046810717534CB09_1744989180 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1328950925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1328950925;
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
            boolean varB326B5062B2F0E69046810717534CB09_135635556 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898549083 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_898549083;
        } //End block
        case SHOW_WAITING_FOR_DEBUGGER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder b = data.readStrongBinder();
            IApplicationThread app = ApplicationThreadNative.asInterface(b);
            boolean waiting = data.readInt() != 0;
            showWaitingForDebugger(app, waiting);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_31181185 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2040102071 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2040102071;
        } //End block
        case GET_MEMORY_INFO_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
            getMemoryInfo(mi);
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
            boolean varB326B5062B2F0E69046810717534CB09_881395878 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1038809291 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1038809291;
        } //End block
        case UNHANDLED_BACK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            unhandledBack();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1025670432 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_182078880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_182078880;
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
            boolean varB326B5062B2F0E69046810717534CB09_906467436 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1562643894 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1562643894;
        } //End block
        case GOING_TO_SLEEP_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            goingToSleep();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_309980933 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_959555363 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_959555363;
        } //End block
        case WAKING_UP_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            wakingUp();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_867440946 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101196857 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_101196857;
        } //End block
        case SET_DEBUG_APP_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pn = data.readString();
            boolean wfd = data.readInt() != 0;
            boolean per = data.readInt() != 0;
            setDebugApp(pn, wfd, per);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_858893312 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159762184 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159762184;
        } //End block
        case SET_ALWAYS_FINISH_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean enabled = data.readInt() != 0;
            setAlwaysFinish(enabled);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_97118937 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888190860 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888190860;
        } //End block
        case SET_ACTIVITY_CONTROLLER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityController watcher = IActivityController.Stub.asInterface(
                    data.readStrongBinder());
            setActivityController(watcher);
            boolean varB326B5062B2F0E69046810717534CB09_866626278 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182980660 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182980660;
        } //End block
        case ENTER_SAFE_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            enterSafeMode();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_447637217 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763724349 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763724349;
        } //End block
        case NOTE_WAKEUP_ALARM_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender is = IIntentSender.Stub.asInterface(
                    data.readStrongBinder());
            noteWakeupAlarm(is);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1438816864 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030227956 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030227956;
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
            boolean varB326B5062B2F0E69046810717534CB09_316396735 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112228805 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112228805;
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
            boolean varB326B5062B2F0E69046810717534CB09_2082274418 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008674020 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008674020;
        } //End block
        case HANDLE_APPLICATION_CRASH_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app = data.readStrongBinder();
            ApplicationErrorReport.CrashInfo ci = new ApplicationErrorReport.CrashInfo(data);
            handleApplicationCrash(app, ci);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_945372421 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1440279660 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1440279660;
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
            boolean varB326B5062B2F0E69046810717534CB09_2042481738 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008181398 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008181398;
        } //End block
        case HANDLE_APPLICATION_STRICT_MODE_VIOLATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder app = data.readStrongBinder();
            int violationMask = data.readInt();
            StrictMode.ViolationInfo info = new StrictMode.ViolationInfo(data);
            handleApplicationStrictModeViolation(app, violationMask, info);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_680215559 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1821083576 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1821083576;
        } //End block
        case SIGNAL_PERSISTENT_PROCESSES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int sig = data.readInt();
            signalPersistentProcesses(sig);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1607842611 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1242595480 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1242595480;
        } //End block
        case KILL_BACKGROUND_PROCESSES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            killBackgroundProcesses(packageName);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1307616547 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2102555149 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2102555149;
        } //End block
        case KILL_ALL_BACKGROUND_PROCESSES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            killAllBackgroundProcesses();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_306692180 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_14278212 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_14278212;
        } //End block
        case FORCE_STOP_PACKAGE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            forceStopPackage(packageName);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_562094059 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483797541 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_483797541;
        } //End block
        case GET_DEVICE_CONFIGURATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ConfigurationInfo config = getDeviceConfigurationInfo();
            reply.writeNoException();
            config.writeToParcel(reply, 0);
            boolean varB326B5062B2F0E69046810717534CB09_1341080183 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1160119551 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1160119551;
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
            boolean varB326B5062B2F0E69046810717534CB09_384763155 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259574158 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_259574158;
        } //End block
        case SHUTDOWN_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean res = shutdown(data.readInt());
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_514321571 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_73245960 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_73245960;
        } //End block
        case STOP_APP_SWITCHES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            stopAppSwitches();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_559308668 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2136531223 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2136531223;
        } //End block
        case RESUME_APP_SWITCHES_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            resumeAppSwitches();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1306346438 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302777914 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_302777914;
        } //End block
        case PEEK_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Intent service = Intent.CREATOR.createFromParcel(data);
            String resolvedType = data.readString();
            IBinder binder = peekService(service, resolvedType);
            reply.writeNoException();
            reply.writeStrongBinder(binder);
            boolean varB326B5062B2F0E69046810717534CB09_1690617661 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_819566068 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_819566068;
        } //End block
        case START_BACKUP_AGENT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ApplicationInfo info = ApplicationInfo.CREATOR.createFromParcel(data);
            int backupRestoreMode = data.readInt();
            boolean success = bindBackupAgent(info, backupRestoreMode);
            reply.writeNoException();
            reply.writeInt(success ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_288089557 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50320367 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_50320367;
        } //End block
        case BACKUP_AGENT_CREATED_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String packageName = data.readString();
            IBinder agent = data.readStrongBinder();
            backupAgentCreated(packageName, agent);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1630613532 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372442320 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_372442320;
        } //End block
        case UNBIND_BACKUP_AGENT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            ApplicationInfo info = ApplicationInfo.CREATOR.createFromParcel(data);
            unbindBackupAgent(info);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1585936738 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648328955 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648328955;
        } //End block
        case REGISTER_ACTIVITY_WATCHER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityWatcher watcher = IActivityWatcher.Stub.asInterface(
                    data.readStrongBinder());
            registerActivityWatcher(watcher);
            boolean varB326B5062B2F0E69046810717534CB09_268638882 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_237788133 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_237788133;
        } //End block
        case UNREGISTER_ACTIVITY_WATCHER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IActivityWatcher watcher = IActivityWatcher.Stub.asInterface(
                    data.readStrongBinder());
            unregisterActivityWatcher(watcher);
            boolean varB326B5062B2F0E69046810717534CB09_1455999884 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_315896784 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_315896784;
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
            boolean varB326B5062B2F0E69046810717534CB09_765160452 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968545175 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968545175;
        } //End block
        case KILL_APPLICATION_WITH_UID_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int uid = data.readInt();
            killApplicationWithUid(pkg, uid);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1883628049 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325057332 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325057332;
        } //End block
        case CLOSE_SYSTEM_DIALOGS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String reason = data.readString();
            closeSystemDialogs(reason);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_650214756 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1180847456 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1180847456;
        } //End block
        case GET_PROCESS_MEMORY_INFO_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids = data.createIntArray();
            Debug.MemoryInfo[] res = getProcessMemoryInfo(pids);
            reply.writeNoException();
            reply.writeTypedArray(res, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            boolean varB326B5062B2F0E69046810717534CB09_1389335999 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979770276 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979770276;
        } //End block
        case KILL_APPLICATION_PROCESS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String processName = data.readString();
            int uid = data.readInt();
            killApplicationProcess(processName, uid);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_2129321793 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_915928378 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_915928378;
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
            boolean varB326B5062B2F0E69046810717534CB09_414779187 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382233855 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_382233855;
        } //End block
        case IS_USER_A_MONKEY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean areThey = isUserAMonkey();
            reply.writeNoException();
            reply.writeInt(areThey ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_970237782 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1943524245 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1943524245;
        } //End block
        case FINISH_HEAVY_WEIGHT_APP_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            finishHeavyWeightApp();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1570691192 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1872574418 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1872574418;
        } //End block
        case IS_IMMERSIVE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean isit = isImmersive(token);
            reply.writeNoException();
            reply.writeInt(isit ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_602413651 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817025471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_817025471;
        } //End block
        case SET_IMMERSIVE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IBinder token = data.readStrongBinder();
            boolean imm = data.readInt() == 1;
            setImmersive(token, imm);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_900698125 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584030842 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_584030842;
        } //End block
        case IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            boolean isit = isTopActivityImmersive();
            reply.writeNoException();
            reply.writeInt(isit ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_819237515 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1311821041 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1311821041;
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
            boolean varB326B5062B2F0E69046810717534CB09_977513581 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1170936934 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1170936934;
        } //End block
        case GET_PROVIDER_MIME_TYPE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Uri uri = Uri.CREATOR.createFromParcel(data);
            String type = getProviderMimeType(uri);
            reply.writeNoException();
            reply.writeString(type);
            boolean varB326B5062B2F0E69046810717534CB09_1735998847 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42475377 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_42475377;
        } //End block
        case NEW_URI_PERMISSION_OWNER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String name = data.readString();
            IBinder perm = newUriPermissionOwner(name);
            reply.writeNoException();
            reply.writeStrongBinder(perm);
            boolean varB326B5062B2F0E69046810717534CB09_1204212927 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1953723718 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1953723718;
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
            boolean varB326B5062B2F0E69046810717534CB09_1469255801 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715715673 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_715715673;
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
            boolean varB326B5062B2F0E69046810717534CB09_1761990999 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_125383836 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_125383836;
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
            boolean varB326B5062B2F0E69046810717534CB09_71014972 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_89186485 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_89186485;
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
            boolean varB326B5062B2F0E69046810717534CB09_1026795714 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1037188771 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1037188771;
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
            boolean varB326B5062B2F0E69046810717534CB09_979424852 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_980853093 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_980853093;
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
            boolean varB326B5062B2F0E69046810717534CB09_163894011 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_767416239 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_767416239;
        } //End block
        case GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int mode = getFrontActivityScreenCompatMode();
            reply.writeNoException();
            reply.writeInt(mode);
            boolean varB326B5062B2F0E69046810717534CB09_1209423024 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1248706443 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1248706443;
        } //End block
        case SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int mode = data.readInt();
            setFrontActivityScreenCompatMode(mode);
            reply.writeNoException();
            reply.writeInt(mode);
            boolean varB326B5062B2F0E69046810717534CB09_107295379 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387409307 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_387409307;
        } //End block
        case GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int mode = getPackageScreenCompatMode(pkg);
            reply.writeNoException();
            reply.writeInt(mode);
            boolean varB326B5062B2F0E69046810717534CB09_1455938288 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1587532504 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1587532504;
        } //End block
        case SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            int mode = data.readInt();
            setPackageScreenCompatMode(pkg, mode);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1776671578 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_226583154 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_226583154;
        } //End block
        case SWITCH_USER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int userid = data.readInt();
            boolean result = switchUser(userid);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1641444053 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_925730645 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_925730645;
        } //End block
        case REMOVE_SUB_TASK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int taskId = data.readInt();
            int subTaskIndex = data.readInt();
            boolean result = removeSubTask(taskId, subTaskIndex);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1444422137 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059508167 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059508167;
        } //End block
        case REMOVE_TASK_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int taskId = data.readInt();
            int fl = data.readInt();
            boolean result = removeTask(taskId, fl);
            reply.writeNoException();
            reply.writeInt(result ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_1213631069 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835268901 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835268901;
        } //End block
        case REGISTER_PROCESS_OBSERVER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IProcessObserver observer = IProcessObserver.Stub.asInterface(
                    data.readStrongBinder());
            registerProcessObserver(observer);
            boolean varB326B5062B2F0E69046810717534CB09_867684542 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020637702 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020637702;
        } //End block
        case UNREGISTER_PROCESS_OBSERVER_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IProcessObserver observer = IProcessObserver.Stub.asInterface(
                    data.readStrongBinder());
            unregisterProcessObserver(observer);
            boolean varB326B5062B2F0E69046810717534CB09_1625897385 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1473886880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1473886880;
        } //End block
        case GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            boolean ask = getPackageAskScreenCompat(pkg);
            reply.writeNoException();
            reply.writeInt(ask ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_87352756 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741012271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741012271;
        } //End block
        case SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            String pkg = data.readString();
            boolean ask = data.readInt() != 0;
            setPackageAskScreenCompat(pkg, ask);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_665929072 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1646567569 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1646567569;
        } //End block
        case IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            IIntentSender r = IIntentSender.Stub.asInterface(
                data.readStrongBinder());
            boolean res = isIntentSenderTargetedToPackage(r);
            reply.writeNoException();
            reply.writeInt(res ? 1 : 0);
            boolean varB326B5062B2F0E69046810717534CB09_825945140 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1649638343 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1649638343;
        } //End block
        case UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            updatePersistentConfiguration(config);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_1943425198 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1254895130 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1254895130;
        } //End block
        case GET_PROCESS_PSS_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            int[] pids = data.createIntArray();
            long[] pss = getProcessPss(pids);
            reply.writeNoException();
            reply.writeLongArray(pss);
            boolean varB326B5062B2F0E69046810717534CB09_70648046 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_810041284 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_810041284;
        } //End block
        case SHOW_BOOT_MESSAGE_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            CharSequence msg = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
            boolean always = data.readInt() != 0;
            showBootMessage(msg, always);
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_93566917 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1002311082 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1002311082;
        } //End block
        case DISMISS_KEYGUARD_ON_NEXT_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IActivityManager.descriptor);
            dismissKeyguardOnNextActivity();
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_2073301982 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_984853318 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_984853318;
        } //End block
}        boolean var3B3A841664B2F7D5B8C0C4B7B8E31E3B_643572740 = (super.onTransact(code, data, reply, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_892781702 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_892781702;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.926 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "1F77402C0260D1857E0C5753991CA409")
    public IBinder asBinder() {
IBinder var72A74007B2BE62B849F475C7BDA4658B_589252078 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_589252078.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_589252078;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.926 -0400", hash_original_field = "7E28963ADB1F0EB3A0EF33BADF10C8B6", hash_generated_field = "94B5404A722EA8FD9D4D6FFD2B91074A")

    static boolean sSystemReady = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.715 -0400", hash_original_field = "1DDB5338697F4F4D1F4EBEBCBCA04F09", hash_generated_field = "C4820EDCAE5178FFFBC23811D56B7F74")

    private static final Singleton<IActivityManager> gDefault = new Singleton<IActivityManager>() {  
    	@DSModeled(DSC.BAN)
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.927 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.927 -0400", hash_original_method = "3287CA7C2EB4AADDF2EFFF2704D2BE9E", hash_generated_method = "45B8F41C62FE771FA42BECD8E8563D23")
    public  ActivityManagerProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.928 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "1A95A0E8B4CF9506B356CA956D80F29B")
    public IBinder asBinder() {
IBinder varF4936CA84F7841A48B466C9D273BE2EB_1039012170 =         mRemote;
        varF4936CA84F7841A48B466C9D273BE2EB_1039012170.addTaint(taint);
        return varF4936CA84F7841A48B466C9D273BE2EB_1039012170;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.929 -0400", hash_original_method = "ECBE4259B26F016D18C1CACD48E02238", hash_generated_method = "4E2EF815E12ECF23ECF6AC643B8044B3")
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
        int varB4A88417B3D0170D754C647C30B7216A_333988 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907609972 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907609972;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.932 -0400", hash_original_method = "BF42E410BABF1DD283EC1102C9637003", hash_generated_method = "CAFC0351938BC6749EA62122453E5ACC")
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
WaitResult varDC838461EE2FA0CA4C9BBB70A15456B0_753495465 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_753495465.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_753495465;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.937 -0400", hash_original_method = "47F7B475943E725D61EF4FCECF2C263D", hash_generated_method = "A15D742D51106F8DFBF4044C54922D6D")
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
        int varB4A88417B3D0170D754C647C30B7216A_4087333 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563897765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563897765;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.939 -0400", hash_original_method = "FD56EAF7591CCE02A2449EB3C30AEF02", hash_generated_method = "8A27A7234D6BAA4546CB11B8B70DEDBD")
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
        int varB4A88417B3D0170D754C647C30B7216A_264343309 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612861903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612861903;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.941 -0400", hash_original_method = "A532370FCCB6C359BF27FA22D92F73F5", hash_generated_method = "F1D979CACF4DC3ACD05D80C1E8747290")
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
        boolean var48B2BB9B3785EB1DD7973635DF866605_2033585883 = (result != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_537008163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_537008163;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.942 -0400", hash_original_method = "91E82D39E0DA0BAF3D9668B58FD8BE2D", hash_generated_method = "BA8902D0C50C03CCBA1849774C264835")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1837369632 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645957077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645957077;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.944 -0400", hash_original_method = "352728C633440E8BBFDE1A24B12C26C6", hash_generated_method = "BCCFD641BCE3194BDEB63F342D1C5DF5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.944 -0400", hash_original_method = "03769BB85CE515FA0FB5B3DCD0709D8A", hash_generated_method = "78E61E67B12DF6BB67010F52BA7B84F1")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_2065326550 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_655411717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_655411717;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.947 -0400", hash_original_method = "D0EC9750E66DC0864B7AF9A5D43ED043", hash_generated_method = "76487CFA375576F810E4D6FA79FCDE00")
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
Intent var095937E5B36214360A2644916BF0E8DF_151231403 =         intent;
        var095937E5B36214360A2644916BF0E8DF_151231403.addTaint(taint);
        return var095937E5B36214360A2644916BF0E8DF_151231403;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.950 -0400", hash_original_method = "CF62E9563222E9365AE1815E546E05AA", hash_generated_method = "EBFF195F8AF8C5235A7DAE7F680DB895")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.952 -0400", hash_original_method = "189D2A1B1A14BF35BFCC0BB8AD6C1CE5", hash_generated_method = "E39450039ACB9D3A1BD353FBA1270531")
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
        int var9B207167E5381C47682C6B4F58A623FB_274349389 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879666762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879666762;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.953 -0400", hash_original_method = "84F4ECE33F63E245917246490F7877AA", hash_generated_method = "0090436865129974CDDE7C46CB4631DE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.954 -0400", hash_original_method = "8BFF18A0F9A8EDDD76A319C280B21CDC", hash_generated_method = "6CD1CB45073E30492BF451AC94ECBC30")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.955 -0400", hash_original_method = "1E67E239E5F2A2540F1E032AB272605E", hash_generated_method = "15A8A0A0066C6B9F437753E72C9A2336")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.957 -0400", hash_original_method = "BC9E49082B5DC06C707641FC7F3E31F5", hash_generated_method = "C6FC598DE4C327BF9954BF041BA1590D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.959 -0400", hash_original_method = "4914FFC78B966DEBED0BDBFF9D70FB17", hash_generated_method = "BC84E109F6194C7A2380D96175286DC0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.961 -0400", hash_original_method = "F5DE3AC45B6CCF74477AF45EB0878099", hash_generated_method = "024E58D40F71E0502D7FE4C548CCFBE5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.962 -0400", hash_original_method = "CA8224B1DA5730B462FB3F604509C1DB", hash_generated_method = "7D2E7A6051B2162A2227C5D0A6CBF920")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.963 -0400", hash_original_method = "9A100D49A0D535BB686DAA00CAC541FF", hash_generated_method = "BCD8E575A6F8119829A3359C4DF722F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.965 -0400", hash_original_method = "7637EF2082F6942F953796EFCEAA3730", hash_generated_method = "20CC684D0BFDF1FD6D1633CA8F7D37D8")
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
String varB5053E025797B3BF768F5C37934C244D_326530904 =         res;
        varB5053E025797B3BF768F5C37934C244D_326530904.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_326530904;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.966 -0400", hash_original_method = "0E9D91A20FCD3BCFB3517DB475147FAB", hash_generated_method = "678084DD0228F2AFB493DFEFF069B134")
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
ComponentName varB5053E025797B3BF768F5C37934C244D_1209381037 =         res;
        varB5053E025797B3BF768F5C37934C244D_1209381037.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1209381037;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.968 -0400", hash_original_method = "FAA1C4AE039868246AED533CDCA15CD7", hash_generated_method = "358CACE9CA0EE29144A7051A89725362")
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
List varED12C351C2E8CA4F85F097DDC7E77B4D_1868199764 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1868199764.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1868199764;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.969 -0400", hash_original_method = "9D3E8FF17F102376D7C7BE9D34CE4F93", hash_generated_method = "0EA4B2BB2355B3C0D225F7526C78D406")
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
List<ActivityManager.RecentTaskInfo> varED12C351C2E8CA4F85F097DDC7E77B4D_1319941816 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1319941816.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1319941816;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.970 -0400", hash_original_method = "10D095A12B52FE928E4AEC7C3F42A832", hash_generated_method = "5F92F8095C9CB1151345862E4E2B0D28")
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
ActivityManager.TaskThumbnails varB8E43D5ABE5A56CEFCFBA2D810F6046C_1148002346 =         bm;
        varB8E43D5ABE5A56CEFCFBA2D810F6046C_1148002346.addTaint(taint);
        return varB8E43D5ABE5A56CEFCFBA2D810F6046C_1148002346;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.971 -0400", hash_original_method = "7671DD1471581027B2C414BE0E3CE4A6", hash_generated_method = "A645193D59A706200BC2D52965144F59")
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
List varED12C351C2E8CA4F85F097DDC7E77B4D_1555478205 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1555478205.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1555478205;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.972 -0400", hash_original_method = "2AE453A6460D5AF368C9AC4C4862314B", hash_generated_method = "442C638B4CB72640CCE60B688A4CBE02")
    public List<ActivityManager.ProcessErrorStateInfo> getProcessesInErrorState() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_PROCESSES_IN_ERROR_STATE_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.ProcessErrorStateInfo> list = reply.createTypedArrayList(ActivityManager.ProcessErrorStateInfo.CREATOR);
        data.recycle();
        reply.recycle();
List<ActivityManager.ProcessErrorStateInfo> varED12C351C2E8CA4F85F097DDC7E77B4D_507129795 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_507129795.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_507129795;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.974 -0400", hash_original_method = "8E45CD57BE18A4B76C3A3E0DA22BC8B7", hash_generated_method = "F0577824DA0019418F90609EC8203375")
    public List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_RUNNING_APP_PROCESSES_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ActivityManager.RunningAppProcessInfo> list = reply.createTypedArrayList(ActivityManager.RunningAppProcessInfo.CREATOR);
        data.recycle();
        reply.recycle();
List<ActivityManager.RunningAppProcessInfo> varED12C351C2E8CA4F85F097DDC7E77B4D_693764743 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_693764743.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_693764743;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.975 -0400", hash_original_method = "2FAC851B003A84469F94E88A81DA29C3", hash_generated_method = "75AA55035C7F98391915495785876CE6")
    public List<ApplicationInfo> getRunningExternalApplications() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION, data, reply, 0);
        reply.readException();
        ArrayList<ApplicationInfo> list = reply.createTypedArrayList(ApplicationInfo.CREATOR);
        data.recycle();
        reply.recycle();
List<ApplicationInfo> varED12C351C2E8CA4F85F097DDC7E77B4D_489988146 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_489988146.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_489988146;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.976 -0400", hash_original_method = "DABF13B8F45F6A065880490CD0DBD1A0", hash_generated_method = "734BFBD8A5C3F2F3DAA3C0960663CBA1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.978 -0400", hash_original_method = "7FFB6E49EA553237E0A3F53A2CDFD87F", hash_generated_method = "59229381DD744ED2A5D25EE994A9FA5D")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.980 -0400", hash_original_method = "7F4F39C4D7AB58BCB5DB152705A9F80A", hash_generated_method = "6AF0CC609795447A596EB66B3773BCC3")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_837107817 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1444724802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1444724802;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.983 -0400", hash_original_method = "48BD6DC2300FE39DD3A4B34C3DD91993", hash_generated_method = "9400D1D2535BF4E8627FCCA304C9037F")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.986 -0400", hash_original_method = "3FABC29A3C68690EBF6B4F44EE4A5D23", hash_generated_method = "4F93D6C5A69BFBF14BFB9558FC51D3C1")
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
        int var9B207167E5381C47682C6B4F58A623FB_430617047 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256081083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256081083;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.989 -0400", hash_original_method = "AF696C3AA9BD79AC1F2D6780E820F3FA", hash_generated_method = "30AE1666DC6580ADD9919D385442063E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.991 -0400", hash_original_method = "4B3E31ABB8C007E1B3828F729DFD9393", hash_generated_method = "DBD559CF5398EC35E3B87AF28E7394C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:41.999 -0400", hash_original_method = "EC6CF87E25124312A62325C5F062E996", hash_generated_method = "81E955C114EAC5E929D919B0049277BF")
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
ContentProviderHolder var714D5B899646D8F8DB57A5F82D1906E2_2010697699 =         cph;
        var714D5B899646D8F8DB57A5F82D1906E2_2010697699.addTaint(taint);
        return var714D5B899646D8F8DB57A5F82D1906E2_2010697699;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.000 -0400", hash_original_method = "9C5D73DEFA4B6B21F8A4E01DC5E46521", hash_generated_method = "7FC35AF6CCBDF33AAAFA78B80E3F000D")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.001 -0400", hash_original_method = "6E983079D2A10BB8E3DF4E66B032EE6D", hash_generated_method = "AD8CFC769B5F6390C3D458BDAA4E0D9F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.002 -0400", hash_original_method = "E5355EA6A0F8270964E816C69524096C", hash_generated_method = "2B13316D2F545E6E59CD19005BFB1E39")
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
PendingIntent varB5053E025797B3BF768F5C37934C244D_593907356 =         res;
        varB5053E025797B3BF768F5C37934C244D_593907356.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_593907356;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.004 -0400", hash_original_method = "A683CF3BA039B3B97AA6ADC23E6FBDCC", hash_generated_method = "BE18478EC4C2BA11445855CBB220A56F")
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
ComponentName varB5053E025797B3BF768F5C37934C244D_679620228 =         res;
        varB5053E025797B3BF768F5C37934C244D_679620228.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_679620228;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.005 -0400", hash_original_method = "B5D9E3A4F6ABA893303F2F02B64751B8", hash_generated_method = "2882B566C6C1483BD8949BF246DBD29C")
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
        int var9B207167E5381C47682C6B4F58A623FB_1441429337 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1539260577 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1539260577;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.007 -0400", hash_original_method = "DB1BCCF2CB5E2532E24072B1F607F963", hash_generated_method = "80084E914467ABCFF7E28F9E732409A3")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1089431887 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2143070094 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2143070094;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.010 -0400", hash_original_method = "9DE0D26C134349F3DA011E11517F3FF5", hash_generated_method = "AFAF01A9AA644F780ECC963EDB04241B")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.014 -0400", hash_original_method = "A1E6D6F237E88697017FA79FBE451840", hash_generated_method = "A542A910BEB7A719F079CFABC2D420FB")
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
        int var9B207167E5381C47682C6B4F58A623FB_2005834663 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260848097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260848097;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.015 -0400", hash_original_method = "E0BD37EB96539E724DE863D335954DC9", hash_generated_method = "D9F59D572A79028D4AA23844E59A2830")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1795388658 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75844083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_75844083;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.019 -0400", hash_original_method = "87A207496B270585D5EEA34C1AF57170", hash_generated_method = "62E2A5AA0BDE8905001277D60B27A6B4")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.021 -0400", hash_original_method = "3796516624A8D493E471933ECF7A3CD3", hash_generated_method = "20021A6F0FB54C6E552B5DF0C700D785")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.023 -0400", hash_original_method = "1CB80C62A00C622E35F1B57A132292E9", hash_generated_method = "DA548906881EA8B8FCB68EFC46E515A8")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.026 -0400", hash_original_method = "BEF476EE5F43517187661CDC39F2A448", hash_generated_method = "27E96F146A4A006856EB9D2A118F4993")
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
IBinder varE3C074C8A98249A08331B334269AEB91_1145419835 =         binder;
        varE3C074C8A98249A08331B334269AEB91_1145419835.addTaint(taint);
        return varE3C074C8A98249A08331B334269AEB91_1145419835;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.028 -0400", hash_original_method = "7AACC08C389BEE0061373162626F356D", hash_generated_method = "23F7DEEC3EBD7E04D2F91F85FA016093")
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
        boolean var260CA9DD8A4577FC00B7BD5810298076_281395622 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1585300224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1585300224;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.029 -0400", hash_original_method = "ADE4561AB0FC3828104C329F05A9B88C", hash_generated_method = "28B27CE28821C9BE325F9E54983CBC5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.030 -0400", hash_original_method = "80BB0DB939AA2A14DC79CE879293739F", hash_generated_method = "6259747324FCC6BC0D43428698D9A383")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.033 -0400", hash_original_method = "7977DF3866173BBD9227641CB70C5B9A", hash_generated_method = "3ABF9D6427817878762F7AB278FDFAAE")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1948301569 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1747734541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1747734541;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.035 -0400", hash_original_method = "D76B5F1B397FC7028B59F12CA3604783", hash_generated_method = "388F99FCA832E7896CFA4581DBE67CA7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.038 -0400", hash_original_method = "E824FA9DB2D76671E24682EC782F4756", hash_generated_method = "7B24A81F2E5FC157C5800F0C74B25B59")
    public Configuration getConfiguration() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        Configuration res = Configuration.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
Configuration varB5053E025797B3BF768F5C37934C244D_1000692217 =         res;
        varB5053E025797B3BF768F5C37934C244D_1000692217.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1000692217;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.039 -0400", hash_original_method = "76911A2717FEEEC7D6B4E93DC7F2427C", hash_generated_method = "A598E35947212C0A29FDA1ADF3B69BE3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.040 -0400", hash_original_method = "65FC5D17EF9FF3BF1BFFDA9CCA9A4BE1", hash_generated_method = "D5E678FBC0803C8AC161830850951BE7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.041 -0400", hash_original_method = "505D3FD7966F547E2BAA16E1C1C5F05B", hash_generated_method = "2D8267ADD70F5A0783153EDCF5205DC8")
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
        int var9B207167E5381C47682C6B4F58A623FB_1209645722 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904651805 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904651805;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.042 -0400", hash_original_method = "BCB55F79D75B3B83E49A75043EE249A9", hash_generated_method = "66D33E2F43F561315525AC16368EC490")
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
ComponentName varB5053E025797B3BF768F5C37934C244D_978254516 =         res;
        varB5053E025797B3BF768F5C37934C244D_978254516.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_978254516;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.043 -0400", hash_original_method = "9BAE752D062408101ED2F689CF20DDD1", hash_generated_method = "4FA16217EF454805766C0E949A370BAE")
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
String varB5053E025797B3BF768F5C37934C244D_1903430807 =         res;
        varB5053E025797B3BF768F5C37934C244D_1903430807.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1903430807;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.045 -0400", hash_original_method = "AE56AE3D6914251F9FFFA7E33C698EB6", hash_generated_method = "ACE06B0B04ACD242EB7C64A1D67FEEE2")
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
IIntentSender varB5053E025797B3BF768F5C37934C244D_1443047630 =         res;
        varB5053E025797B3BF768F5C37934C244D_1443047630.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1443047630;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.047 -0400", hash_original_method = "D459AA1ADAE84FC2B7BB3BA73C047FDB", hash_generated_method = "B45FF815986B72C5F09946F78F6D45BD")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.049 -0400", hash_original_method = "1993496C4F183452017D412A9B9C5C29", hash_generated_method = "2ACB4EB25516F2A658243011F0AE83B1")
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
String varB5053E025797B3BF768F5C37934C244D_673200407 =         res;
        varB5053E025797B3BF768F5C37934C244D_673200407.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_673200407;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.051 -0400", hash_original_method = "92B622DC0CB7ED23BB116E8953A0A90A", hash_generated_method = "58FF39628A8FA2BB2BB9BDECE62DEAA4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.052 -0400", hash_original_method = "4FA932EFF1C9BAC6AA973FE979D6B75F", hash_generated_method = "08FD519D6AF03DB3276F3E77E6D4A77A")
    public int getProcessLimit() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_PROCESS_LIMIT_TRANSACTION, data, reply, 0);
        reply.readException();
        int res = reply.readInt();
        data.recycle();
        reply.recycle();
        int var9B207167E5381C47682C6B4F58A623FB_6986656 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918199828 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918199828;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.054 -0400", hash_original_method = "16F5E36D0F576E8CD2EC3F6B33B5169D", hash_generated_method = "66038015AF35C62348B8B8B985F29AEC")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.057 -0400", hash_original_method = "A50C503DC3495EB643680A38372DD1F5", hash_generated_method = "B1AF56CA2B276A5DBE5916889AC11126")
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
        int var9B207167E5381C47682C6B4F58A623FB_850923433 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827233266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827233266;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.061 -0400", hash_original_method = "BE5C38AE92A5EE5CE45944FF93295090", hash_generated_method = "D665481180F226ADCEB40ADD6B865E77")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1440089976 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639760424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639760424;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.064 -0400", hash_original_method = "FEF4F93E5B02F55707A11B36638BBB59", hash_generated_method = "45A647AF8E4F555B9F43BE5651503587")
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
        int var9B207167E5381C47682C6B4F58A623FB_1040649215 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_615473825 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_615473825;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.067 -0400", hash_original_method = "2CEB2CA82A36297F49BF5DB3286E579B", hash_generated_method = "CF51A08F5792E5A4520861FF10ADBEEE")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.070 -0400", hash_original_method = "84D534ABCBC85608735C63399D2C9E1E", hash_generated_method = "E901FFEA3C64B01E4CCC51D33D232D97")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.072 -0400", hash_original_method = "7FC96553233904C2463E3D793E528211", hash_generated_method = "C7712E98882E9319805DA3509ACD5F02")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.074 -0400", hash_original_method = "40DDB58D1BE7B54E85772ACF1AA60D8F", hash_generated_method = "8507240D01A2B14EF9DC1090F1FC52D6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.075 -0400", hash_original_method = "805F881D84830966D1AD0B083D69DA9A", hash_generated_method = "35908FEA5D27261ECFCDD707C4543E2A")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.078 -0400", hash_original_method = "1E46E6C9628834765008140B25990D23", hash_generated_method = "401B9814BA66E13F474B277CC88DB1E8")
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
ParcelFileDescriptor varC93E3EE3359509D81434E9F216020655_1425599109 =         pfd;
        varC93E3EE3359509D81434E9F216020655_1425599109.addTaint(taint);
        return varC93E3EE3359509D81434E9F216020655_1425599109;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.079 -0400", hash_original_method = "E3BC510BF36E68FD23494212AB6E7B33", hash_generated_method = "6FA7FC22CC4827A9155BA6D48B3496C5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.081 -0400", hash_original_method = "CAFF51A84FC631E180A23D0F5290B43F", hash_generated_method = "DC06BAFA4F4E0DC663C4ACFECCEA0503")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.083 -0400", hash_original_method = "482C4468B37AD6CEF12EA376A273F16E", hash_generated_method = "CFB2704B034ABD0A4652BB6A1DF03397")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.084 -0400", hash_original_method = "DE27B8A416D8E1FF87F079AFA1567A6E", hash_generated_method = "BC152414091454321D52597CA23D4EB9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.086 -0400", hash_original_method = "D7DBDAD7386DC1F45D7A9AB12513A49B", hash_generated_method = "C59DB7B888B59E3300BD09B3F29EB2A4")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.086 -0400", hash_original_method = "FF7EEF7728CACAD7286D113A3CF07513", hash_generated_method = "989FB5B63F9FFE72C2D1A765411C7755")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.088 -0400", hash_original_method = "72F87C80970F6885E4DCD6DA1B2F19E8", hash_generated_method = "4ED05EDABD114762A9EC5452337A5CD6")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.089 -0400", hash_original_method = "DB2721BD1E4C8F1064AA0461CF2A490B", hash_generated_method = "637275F86558E65761DBBE8D85B3D4B4")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1016993446 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1295849994 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1295849994;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.091 -0400", hash_original_method = "9964526F9DDC53538E50ED934A9D4009", hash_generated_method = "E8702DF9E30424744B53A3AC0BEFF968")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.092 -0400", hash_original_method = "6C8B2FE75A3BFFE16EADA916F678A09D", hash_generated_method = "21E2D9D3C1ACEF576AAA0C7478965A14")
    public boolean testIsSystemReady() {
        boolean varB326B5062B2F0E69046810717534CB09_1189222338 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1181983223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1181983223;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.093 -0400", hash_original_method = "523AF9597115E332AF2A1F534C49483C", hash_generated_method = "FD1A66F38E90C4A17E41A176F0A17D5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.095 -0400", hash_original_method = "84EFC78EC4B379D270C222A7BC31C5F7", hash_generated_method = "2F0771AE5792ECCA5AC6B2783635E449")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1577170537 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32398045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_32398045;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.096 -0400", hash_original_method = "7AC27E481709B1F0B25AE2BA23B3BECF", hash_generated_method = "2037FE079886D4FF19B4C0E773537EB4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.097 -0400", hash_original_method = "22BD8EFAE7A36DA76D8B0F7F297E970D", hash_generated_method = "66974AC6886E099865AE2C53DE8E176A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.097 -0400", hash_original_method = "3D80332C8A0FCAFBCE220FADA30302CB", hash_generated_method = "A143D8EF9FE7A708D18E0CBF07DCD600")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.098 -0400", hash_original_method = "C7F5D3EA775AD04DD438191F0B4D22C4", hash_generated_method = "3A4D09A3259986E047E1536B505B4986")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.100 -0400", hash_original_method = "CB4D9E734B2DC6A00C763BA9D15D84CC", hash_generated_method = "8E556AE5FF2BC400F94C02FB03918977")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.101 -0400", hash_original_method = "9F4AADDAC8F1648FD8C80C6B88BBF25F", hash_generated_method = "7EE773FE41403903179C45EAB5710C7D")
    public ConfigurationInfo getDeviceConfigurationInfo() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_DEVICE_CONFIGURATION_TRANSACTION, data, reply, 0);
        reply.readException();
        ConfigurationInfo res = ConfigurationInfo.CREATOR.createFromParcel(reply);
        reply.recycle();
        data.recycle();
ConfigurationInfo varB5053E025797B3BF768F5C37934C244D_1977613374 =         res;
        varB5053E025797B3BF768F5C37934C244D_1977613374.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1977613374;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.103 -0400", hash_original_method = "10D7A082C97EAFB331405B7841F1651D", hash_generated_method = "38FF786C235A48A78C4B87D92753CAEE")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1244284450 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488255335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488255335;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.106 -0400", hash_original_method = "52F9DB0BA2A0AB8C52093D208807035C", hash_generated_method = "22B818FE09D56E2472198542B84A47EF")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_2098913940 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_801760777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_801760777;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.110 -0400", hash_original_method = "BE7DD92CBAD030A60DB7090E3408574C", hash_generated_method = "13EA54D36EF6A74A6B8F116EB09B864A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.112 -0400", hash_original_method = "0EC9793095E20007EC76AB5DDDE4E54A", hash_generated_method = "6608F43B59121217A1614CC63240E42A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.115 -0400", hash_original_method = "7B78E2FEC61CC471A8E07C6C34C74BD6", hash_generated_method = "3817B8C1148D03480BC754EDE7A8783D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.117 -0400", hash_original_method = "8E5D6F085FE02A1442C5A617ADA012EC", hash_generated_method = "422F700E252479C0B5F466D7DC0E4DE8")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.120 -0400", hash_original_method = "C65F778BCD540838D47FE4E4412CD25E", hash_generated_method = "7AB2083B868B4796AE71B378E89E07F9")
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
        int varB4A88417B3D0170D754C647C30B7216A_476169942 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1110193205 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1110193205;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.121 -0400", hash_original_method = "9BA7CBE5CC5118373D7AAA1497A47635", hash_generated_method = "56C3E1DE667BB3576E49BAFE5D963B30")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.123 -0400", hash_original_method = "2A680A4513BB1B95074F3F876F148BA8", hash_generated_method = "CCD69A33D5C91B5C3FDC0289CB9A6D5F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.125 -0400", hash_original_method = "BD88F62F5112FCE1DE930509EBB83FD2", hash_generated_method = "6CDD747183F9590A83CEA72A0293B243")
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
Debug.MemoryInfo[] varB5053E025797B3BF768F5C37934C244D_1948102553 =         res;
        varB5053E025797B3BF768F5C37934C244D_1948102553.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1948102553;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.127 -0400", hash_original_method = "0F16B6E02208618C1D3EE91B8DD80482", hash_generated_method = "1B738F24D07087FD02B2D59E509B713F")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.129 -0400", hash_original_method = "00D6B54E331AC7AA3DC1F40B928FA3FD", hash_generated_method = "8E486799830066FC292A7C7FC3D309FA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.131 -0400", hash_original_method = "0F906B538EF84DE09E15BAB8CDAE69C4", hash_generated_method = "67837361FADD9903F13F9E681C8C1539")
    public boolean isUserAMonkey() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(IS_USER_A_MONKEY_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() != 0;
        data.recycle();
        reply.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_1277278340 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472362633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_472362633;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.132 -0400", hash_original_method = "CE9EE2ABB9C16E19ED0FB5ECED80A2D8", hash_generated_method = "EB822339041D216CF933014C954FB685")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.134 -0400", hash_original_method = "468B67BFEE008B6CDEC37F42802988FA", hash_generated_method = "D6FA49ACB785B0E7C25A90613825F575")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.136 -0400", hash_original_method = "12E814937BEB239BDABA8A5EE4F6D00D", hash_generated_method = "480BB108CAB0B60715D01822EC4562AA")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1606389712 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_379231574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_379231574;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.137 -0400", hash_original_method = "0342E1772D9E2D527D167E41870AA176", hash_generated_method = "A52DB99E74065C8E62D0352F628E3BF0")
    public boolean isTopActivityImmersive() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION, data, reply, 0);
        reply.readException();
        boolean res = reply.readInt() == 1;
        data.recycle();
        reply.recycle();
        boolean var9B207167E5381C47682C6B4F58A623FB_578580944 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761917538 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761917538;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.139 -0400", hash_original_method = "574D561A4B99545A454A313F9DD764D8", hash_generated_method = "212787E8DECFA699AF9375978DC419FB")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.140 -0400", hash_original_method = "CF06029063749F4266D5EFBB16694E04", hash_generated_method = "5357E26828481918C36C6ACBC71C9EB1")
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
String varB5053E025797B3BF768F5C37934C244D_1951104103 =         res;
        varB5053E025797B3BF768F5C37934C244D_1951104103.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1951104103;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.142 -0400", hash_original_method = "A975CD5E1392FBC42C40F56501282DDB", hash_generated_method = "BC971671BD12BC11E6A266E1C3780C5B")
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
IBinder varB5053E025797B3BF768F5C37934C244D_184234250 =         res;
        varB5053E025797B3BF768F5C37934C244D_184234250.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_184234250;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.146 -0400", hash_original_method = "1C35FE424D422C73471D9ECEE35C4093", hash_generated_method = "0FBD6A1EE34CA0659502DAE0423D0CDB")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.148 -0400", hash_original_method = "D07898A73558FBA66858F774589B082E", hash_generated_method = "7A2746B9C5AA4E0478034865BF9597FA")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.152 -0400", hash_original_method = "3DAB9C9F42020370AD19E1FE0AC1BDCE", hash_generated_method = "F59CAC730EE70E770F6699A4BB1CD176")
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
        int var9B207167E5381C47682C6B4F58A623FB_84458707 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93299079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93299079;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.156 -0400", hash_original_method = "2510375C73B367DE6AAF634BB948BB50", hash_generated_method = "F7C6D2AF9503CB3461B5D939595C4EAB")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_1138125729 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645686499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645686499;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.159 -0400", hash_original_method = "D5FED7EEA920B3F53E1885BDA832FF44", hash_generated_method = "287FDFF7900FCE7B2B4CF6D2020E54BA")
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
        int varB4A88417B3D0170D754C647C30B7216A_238821206 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664233974 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664233974;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.162 -0400", hash_original_method = "7A44848B4F4A570D7B280FD97AA3F11F", hash_generated_method = "977709A89153B59B9899BA2503DE26F2")
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
        int varB4A88417B3D0170D754C647C30B7216A_1324630233 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088817429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088817429;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.165 -0400", hash_original_method = "11A1C93F201BB77459CE48D94392036A", hash_generated_method = "05568F2CEF0BF117AE53E06852CC9BF1")
    public int getFrontActivityScreenCompatMode() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IActivityManager.descriptor);
        mRemote.transact(GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION, data, reply, 0);
        reply.readException();
        int mode = reply.readInt();
        reply.recycle();
        data.recycle();
        int var15D61712450A686A7F365ADF4FEF581F_1594975759 = (mode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771993868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771993868;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.167 -0400", hash_original_method = "984BA2CED473A0F45E8080D25CCDF41F", hash_generated_method = "5371A5E89FE691053FE96BE0157388A3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.170 -0400", hash_original_method = "AFAFCB6FF2EC7CDD310E0CDC4C512BE7", hash_generated_method = "68678B8040F147413CFE627B4320AF71")
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
        int var15D61712450A686A7F365ADF4FEF581F_1110027102 = (mode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400713554 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400713554;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.172 -0400", hash_original_method = "5B0C9EEE90D8463E1DCC15B68E3829E8", hash_generated_method = "0611C88E6D8749AEE8F419C10EED9175")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.175 -0400", hash_original_method = "7AFCEC9BC7A2DAB54F3EFFA101044309", hash_generated_method = "D0ABF25AE079BB7F8A1DC9B942DAEF96")
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
        boolean var5ED33F7008771C9D49E3716AEAECA581_1603091588 = (ask);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349265562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349265562;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.177 -0400", hash_original_method = "8C9BAA94A3976358AA466F180A11AE45", hash_generated_method = "3300641A7DAB48661114DCE5161A692F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.183 -0400", hash_original_method = "0A8E6FD2F20689E2107BCC0911A72467", hash_generated_method = "CF358140BD4CA13114AE0669D9FC9F88")
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
        boolean varB4A88417B3D0170D754C647C30B7216A_807409266 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_605438973 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_605438973;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.186 -0400", hash_original_method = "4161F4F4B6F51E7616ED3E0F5DA99E10", hash_generated_method = "5784471B7E70EFCDBCAFD1474CA5FE72")
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
        boolean varB4A88417B3D0170D754C647C30B7216A_959666360 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1006955213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1006955213;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.188 -0400", hash_original_method = "D75556E86E98C9E69E5D8B6835FF1B1D", hash_generated_method = "EB21EE56234EDD8B65DB03DAEE2FB25A")
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
        boolean varB4A88417B3D0170D754C647C30B7216A_88846643 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2119855983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2119855983;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.191 -0400", hash_original_method = "AD040AF08607A87C88C9CB9BE1E3C408", hash_generated_method = "F79D0782D7ADBF945089C278A2C3F53F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.194 -0400", hash_original_method = "6FB2BE2D02A98F343D51290C94466533", hash_generated_method = "BA2307A78A229CAF14012903983D4FE7")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.196 -0400", hash_original_method = "A45994938B7DA24AED12FFC5B3B3DD69", hash_generated_method = "FD47F0D3FF1D553E6BFC8DE26AD4AD7B")
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
        boolean var9B207167E5381C47682C6B4F58A623FB_714315174 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2007179322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2007179322;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.197 -0400", hash_original_method = "ACD180EA48DE1CCAABBA4B90AA3470B8", hash_generated_method = "8B2FC9725333FEE6D7F1989697BCAA6C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.199 -0400", hash_original_method = "0E9D1ED4F0E7DC85612AA1E9A3EC65BE", hash_generated_method = "B0628295AF7FAC1BDC1B74A94843D608")
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
        long[] var9B207167E5381C47682C6B4F58A623FB_1281299819 = (res);
                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_253603279 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_253603279;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.200 -0400", hash_original_method = "F6DDBF719DC0D2BCB3D721A826004A98", hash_generated_method = "D052AF57D70CC86B23BEFAD4AC2C5DB9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:42.201 -0400", hash_original_method = "C6C48FDB33104FCE337F1D8C3A233E89", hash_generated_method = "8F5505827E88689D1F08B162EE225802")
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

