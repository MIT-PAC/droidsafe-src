package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IIntentReceiver;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.Debug;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ApplicationThreadNative extends Binder implements IApplicationThread {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.741 -0400", hash_original_method = "94F554AA12869316A649B35CDD2C48B7", hash_generated_method = "7133F8D8ECAF77EA1D7A82265BA8BB74")
    public  ApplicationThreadNative() {
        attachInterface(this, descriptor);
        // ---------- Original Method ----------
        //attachInterface(this, descriptor);
    }

    
    static public IApplicationThread asInterface(IBinder obj) {
        if (obj == null) {
            return null;
        }
        IApplicationThread in =
            (IApplicationThread)obj.queryLocalInterface(descriptor);
        if (in != null) {
            return in;
        }
        return new ApplicationThreadProxy(obj);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.754 -0400", hash_original_method = "B17DF3ED953946DC6FB6C3E82DF1C3B7", hash_generated_method = "9D01222C3F4FF1949B4F57900166ED54")
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(flags);
        addTaint(reply.getTaint());
        addTaint(data.getTaint());
        addTaint(code);
switch(code){
        case SCHEDULE_PAUSE_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean finished = data.readInt() != 0;
            boolean userLeaving = data.readInt() != 0;
            int configChanges = data.readInt();
            schedulePauseActivity(b, finished, userLeaving, configChanges);
            boolean varB326B5062B2F0E69046810717534CB09_2123717364 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1017628204 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1017628204;
        } //End block
        case SCHEDULE_STOP_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean show = data.readInt() != 0;
            int configChanges = data.readInt();
            scheduleStopActivity(b, show, configChanges);
            boolean varB326B5062B2F0E69046810717534CB09_201268706 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826726827 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_826726827;
        } //End block
        case SCHEDULE_WINDOW_VISIBILITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean show = data.readInt() != 0;
            scheduleWindowVisibility(b, show);
            boolean varB326B5062B2F0E69046810717534CB09_171223911 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_934222773 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_934222773;
        } //End block
        case SCHEDULE_SLEEPING_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean sleeping = data.readInt() != 0;
            scheduleSleeping(b, sleeping);
            boolean varB326B5062B2F0E69046810717534CB09_344895790 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1864916665 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1864916665;
        } //End block
        case SCHEDULE_RESUME_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean isForward = data.readInt() != 0;
            scheduleResumeActivity(b, isForward);
            boolean varB326B5062B2F0E69046810717534CB09_398367552 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_473582066 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_473582066;
        } //End block
        case SCHEDULE_SEND_RESULT_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            List<ResultInfo> ri = data.createTypedArrayList(ResultInfo.CREATOR);
            scheduleSendResult(b, ri);
            boolean varB326B5062B2F0E69046810717534CB09_40652567 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1034070860 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1034070860;
        } //End block
        case SCHEDULE_LAUNCH_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Intent intent = Intent.CREATOR.createFromParcel(data);
            IBinder b = data.readStrongBinder();
            int ident = data.readInt();
            ActivityInfo info = ActivityInfo.CREATOR.createFromParcel(data);
            Configuration curConfig = Configuration.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            Bundle state = data.readBundle();
            List<ResultInfo> ri = data.createTypedArrayList(ResultInfo.CREATOR);
            List<Intent> pi = data.createTypedArrayList(Intent.CREATOR);
            boolean notResumed = data.readInt() != 0;
            boolean isForward = data.readInt() != 0;
            String profileName = data.readString();
            ParcelFileDescriptor profileFd = data.readInt() != 0
                    ? data.readFileDescriptor() : null;
            boolean autoStopProfiler = data.readInt() != 0;
            scheduleLaunchActivity(intent, b, ident, info, curConfig, compatInfo, state, ri, pi,
                    notResumed, isForward, profileName, profileFd, autoStopProfiler);
            boolean varB326B5062B2F0E69046810717534CB09_1053346122 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522341432 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_522341432;
        } //End block
        case SCHEDULE_RELAUNCH_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            List<ResultInfo> ri = data.createTypedArrayList(ResultInfo.CREATOR);
            List<Intent> pi = data.createTypedArrayList(Intent.CREATOR);
            int configChanges = data.readInt();
            boolean notResumed = data.readInt() != 0;
            Configuration config = null;
            if(data.readInt() != 0)            
            {
                config = Configuration.CREATOR.createFromParcel(data);
            } //End block
            scheduleRelaunchActivity(b, ri, pi, configChanges, notResumed, config);
            boolean varB326B5062B2F0E69046810717534CB09_605394117 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2127690925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2127690925;
        } //End block
        case SCHEDULE_NEW_INTENT_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            List<Intent> pi = data.createTypedArrayList(Intent.CREATOR);
            IBinder b = data.readStrongBinder();
            scheduleNewIntent(pi, b);
            boolean varB326B5062B2F0E69046810717534CB09_62897445 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1681129360 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1681129360;
        } //End block
        case SCHEDULE_FINISH_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean finishing = data.readInt() != 0;
            int configChanges = data.readInt();
            scheduleDestroyActivity(b, finishing, configChanges);
            boolean varB326B5062B2F0E69046810717534CB09_249583045 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_205599014 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_205599014;
        } //End block
        case SCHEDULE_RECEIVER_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Intent intent = Intent.CREATOR.createFromParcel(data);
            ActivityInfo info = ActivityInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            int resultCode = data.readInt();
            String resultData = data.readString();
            Bundle resultExtras = data.readBundle();
            boolean sync = data.readInt() != 0;
            scheduleReceiver(intent, info, compatInfo, resultCode, resultData,
                    resultExtras, sync);
            boolean varB326B5062B2F0E69046810717534CB09_1273033734 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1912104746 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1912104746;
        } //End block
        case SCHEDULE_CREATE_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            ServiceInfo info = ServiceInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            scheduleCreateService(token, info, compatInfo);
            boolean varB326B5062B2F0E69046810717534CB09_2122106783 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_947749377 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_947749377;
        } //End block
        case SCHEDULE_BIND_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            boolean rebind = data.readInt() != 0;
            scheduleBindService(token, intent, rebind);
            boolean varB326B5062B2F0E69046810717534CB09_985054897 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1203524379 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1203524379;
        } //End block
        case SCHEDULE_UNBIND_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            scheduleUnbindService(token, intent);
            boolean varB326B5062B2F0E69046810717534CB09_1740605962 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_632065375 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_632065375;
        } //End block
        case SCHEDULE_SERVICE_ARGS_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            boolean taskRemoved = data.readInt() != 0;
            int startId = data.readInt();
            int fl = data.readInt();
            Intent args;
            if(data.readInt() != 0)            
            {
                args = Intent.CREATOR.createFromParcel(data);
            } //End block
            else
            {
                args = null;
            } //End block
            scheduleServiceArgs(token, taskRemoved, startId, fl, args);
            boolean varB326B5062B2F0E69046810717534CB09_1949125577 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090034127 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090034127;
        } //End block
        case SCHEDULE_STOP_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            scheduleStopService(token);
            boolean varB326B5062B2F0E69046810717534CB09_260480321 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_994557656 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_994557656;
        } //End block
        case BIND_APPLICATION_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String packageName = data.readString();
            ApplicationInfo info = ApplicationInfo.CREATOR.createFromParcel(data);
            List<ProviderInfo> providers = data.createTypedArrayList(ProviderInfo.CREATOR);
            ComponentName testName = (data.readInt() != 0)
                ? new ComponentName(data) : null;
            String profileName = data.readString();
            ParcelFileDescriptor profileFd = data.readInt() != 0
                    ? data.readFileDescriptor() : null;
            boolean autoStopProfiler = data.readInt() != 0;
            Bundle testArgs = data.readBundle();
            IBinder binder = data.readStrongBinder();
            IInstrumentationWatcher testWatcher = IInstrumentationWatcher.Stub.asInterface(binder);
            int testMode = data.readInt();
            boolean restrictedBackupMode = (data.readInt() != 0);
            boolean persistent = (data.readInt() != 0);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            HashMap<String, IBinder> services = data.readHashMap(null);
            Bundle coreSettings = data.readBundle();
            bindApplication(packageName, info,
                            providers, testName, profileName, profileFd, autoStopProfiler,
                            testArgs, testWatcher, testMode, restrictedBackupMode, persistent,
                            config, compatInfo, services, coreSettings);
            boolean varB326B5062B2F0E69046810717534CB09_1369256688 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1061135883 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1061135883;
        } //End block
        case SCHEDULE_EXIT_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            scheduleExit();
            boolean varB326B5062B2F0E69046810717534CB09_2052940910 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1221406022 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1221406022;
        } //End block
        case SCHEDULE_SUICIDE_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            scheduleSuicide();
            boolean varB326B5062B2F0E69046810717534CB09_246778568 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1445708383 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1445708383;
        } //End block
        case REQUEST_THUMBNAIL_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            requestThumbnail(b);
            boolean varB326B5062B2F0E69046810717534CB09_1958056977 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_574620126 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_574620126;
        } //End block
        case SCHEDULE_CONFIGURATION_CHANGED_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            scheduleConfigurationChanged(config);
            boolean varB326B5062B2F0E69046810717534CB09_987580951 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_657838006 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_657838006;
        } //End block
        case UPDATE_TIME_ZONE_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            updateTimeZone();
            boolean varB326B5062B2F0E69046810717534CB09_1628624763 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1369457537 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1369457537;
        } //End block
        case CLEAR_DNS_CACHE_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            clearDnsCache();
            boolean varB326B5062B2F0E69046810717534CB09_1842962277 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166140164 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166140164;
        } //End block
        case SET_HTTP_PROXY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            final String proxy = data.readString();
            final String port = data.readString();
            final String exclList = data.readString();
            setHttpProxy(proxy, port, exclList);
            boolean varB326B5062B2F0E69046810717534CB09_68883671 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_622782798 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_622782798;
        } //End block
        case PROCESS_IN_BACKGROUND_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            processInBackground();
            boolean varB326B5062B2F0E69046810717534CB09_1947137634 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_749304171 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_749304171;
        } //End block
        case DUMP_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            final IBinder service = data.readStrongBinder();
            final String[] args = data.readStringArray();
            if(fd != null)            
            {
                dumpService(fd.getFileDescriptor(), service, args);
                try 
                {
                    fd.close();
                } //End block
                catch (IOException e)
                {
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1765246523 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146559362 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146559362;
        } //End block
        case SCHEDULE_REGISTERED_RECEIVER_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IIntentReceiver receiver = IIntentReceiver.Stub.asInterface(
                    data.readStrongBinder());
            Intent intent = Intent.CREATOR.createFromParcel(data);
            int resultCode = data.readInt();
            String dataStr = data.readString();
            Bundle extras = data.readBundle();
            boolean ordered = data.readInt() != 0;
            boolean sticky = data.readInt() != 0;
            scheduleRegisteredReceiver(receiver, intent,
                    resultCode, dataStr, extras, ordered, sticky);
            boolean varB326B5062B2F0E69046810717534CB09_491432372 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776669904 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_776669904;
        } //End block
        case SCHEDULE_LOW_MEMORY_TRANSACTION:
        {
            scheduleLowMemory();
            boolean varB326B5062B2F0E69046810717534CB09_1067900146 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1111572860 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1111572860;
        } //End block
        case SCHEDULE_ACTIVITY_CONFIGURATION_CHANGED_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            scheduleActivityConfigurationChanged(b);
            boolean varB326B5062B2F0E69046810717534CB09_1259054705 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1187094757 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1187094757;
        } //End block
        case PROFILER_CONTROL_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            boolean start = data.readInt() != 0;
            int profileType = data.readInt();
            String path = data.readString();
            ParcelFileDescriptor fd = data.readInt() != 0
                    ? data.readFileDescriptor() : null;
            profilerControl(start, path, fd, profileType);
            boolean varB326B5062B2F0E69046810717534CB09_1226749606 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310107162 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310107162;
        } //End block
        case SET_SCHEDULING_GROUP_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            int group = data.readInt();
            setSchedulingGroup(group);
            boolean varB326B5062B2F0E69046810717534CB09_1215826189 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_229335299 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_229335299;
        } //End block
        case SCHEDULE_CREATE_BACKUP_AGENT_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ApplicationInfo appInfo = ApplicationInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            int backupMode = data.readInt();
            scheduleCreateBackupAgent(appInfo, compatInfo, backupMode);
            boolean varB326B5062B2F0E69046810717534CB09_1654694925 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_548418379 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_548418379;
        } //End block
        case SCHEDULE_DESTROY_BACKUP_AGENT_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ApplicationInfo appInfo = ApplicationInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            scheduleDestroyBackupAgent(appInfo, compatInfo);
            boolean varB326B5062B2F0E69046810717534CB09_233279947 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510985364 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_510985364;
        } //End block
        case GET_MEMORY_INFO_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Debug.MemoryInfo mi = new Debug.MemoryInfo();
            getMemoryInfo(mi);
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
            boolean varB326B5062B2F0E69046810717534CB09_1258846473 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297874970 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_297874970;
        } //End block
        case DISPATCH_PACKAGE_BROADCAST_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            int cmd = data.readInt();
            String[] packages = data.readStringArray();
            dispatchPackageBroadcast(cmd, packages);
            boolean varB326B5062B2F0E69046810717534CB09_1761925135 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1053987628 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1053987628;
        } //End block
        case SCHEDULE_CRASH_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String msg = data.readString();
            scheduleCrash(msg);
            boolean varB326B5062B2F0E69046810717534CB09_1537839150 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137996617 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137996617;
        } //End block
        case DUMP_HEAP_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            boolean managed = data.readInt() != 0;
            String path = data.readString();
            ParcelFileDescriptor fd = data.readInt() != 0
                    ? data.readFileDescriptor() : null;
            dumpHeap(managed, path, fd);
            boolean varB326B5062B2F0E69046810717534CB09_282537847 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_147454439 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_147454439;
        } //End block
        case DUMP_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            final IBinder activity = data.readStrongBinder();
            final String prefix = data.readString();
            final String[] args = data.readStringArray();
            if(fd != null)            
            {
                dumpActivity(fd.getFileDescriptor(), activity, prefix, args);
                try 
                {
                    fd.close();
                } //End block
                catch (IOException e)
                {
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_2120882359 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1007021275 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1007021275;
        } //End block
        case SET_CORE_SETTINGS_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Bundle settings = data.readBundle();
            setCoreSettings(settings);
            boolean varB326B5062B2F0E69046810717534CB09_440779805 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1840127783 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1840127783;
        } //End block
        case UPDATE_PACKAGE_COMPATIBILITY_INFO_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String pkg = data.readString();
            CompatibilityInfo compat = CompatibilityInfo.CREATOR.createFromParcel(data);
            updatePackageCompatibilityInfo(pkg, compat);
            boolean varB326B5062B2F0E69046810717534CB09_1818442957 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1047225011 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1047225011;
        } //End block
        case SCHEDULE_TRIM_MEMORY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            int level = data.readInt();
            scheduleTrimMemory(level);
            boolean varB326B5062B2F0E69046810717534CB09_1547820413 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421321012 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421321012;
        } //End block
        case DUMP_MEM_INFO_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            boolean checkin = data.readInt() != 0;
            boolean all = data.readInt() != 0;
            String[] args = data.readStringArray();
            Debug.MemoryInfo mi = null;
            if(fd != null)            
            {
                try 
                {
                    mi = dumpMemInfo(fd.getFileDescriptor(), checkin, all, args);
                } //End block
                finally 
                {
                    try 
                    {
                        fd.close();
                    } //End block
                    catch (IOException e)
                    {
                    } //End block
                } //End block
            } //End block
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
            boolean varB326B5062B2F0E69046810717534CB09_1382101112 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190292928 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_190292928;
        } //End block
        case DUMP_GFX_INFO_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            String[] args = data.readStringArray();
            if(fd != null)            
            {
                try 
                {
                    dumpGfxInfo(fd.getFileDescriptor(), args);
                } //End block
                finally 
                {
                    try 
                    {
                        fd.close();
                    } //End block
                    catch (IOException e)
                    {
                    } //End block
                } //End block
            } //End block
            reply.writeNoException();
            boolean varB326B5062B2F0E69046810717534CB09_319548890 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324686378 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324686378;
        } //End block
}        boolean var3B3A841664B2F7D5B8C0C4B7B8E31E3B_1860142272 = (super.onTransact(code, data, reply, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606010706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606010706;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.760 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "7B20D4AB0ACCBF3697537E4F27639500")
    public IBinder asBinder() {
IBinder var72A74007B2BE62B849F475C7BDA4658B_754923137 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_754923137.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_754923137;
        // ---------- Original Method ----------
        //return this;
    }

    
}

class ApplicationThreadProxy implements IApplicationThread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.761 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.762 -0400", hash_original_method = "08B50EC8A0FF95C7A679215C14C2E347", hash_generated_method = "07C34BD386C4B1EE3B5CAAFB7C484EE0")
    public  ApplicationThreadProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.763 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "192977129AC0581890F6722883BFE5C6")
    public final IBinder asBinder() {
IBinder varF4936CA84F7841A48B466C9D273BE2EB_1188390858 =         mRemote;
        varF4936CA84F7841A48B466C9D273BE2EB_1188390858.addTaint(taint);
        return varF4936CA84F7841A48B466C9D273BE2EB_1188390858;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.764 -0400", hash_original_method = "F385294CE3D6AC21F25405F7E688DF1E", hash_generated_method = "0FF507F26107E8EC50E1B67A67A0898C")
    public final void schedulePauseActivity(IBinder token, boolean finished,
            boolean userLeaving, int configChanges) throws RemoteException {
        addTaint(configChanges);
        addTaint(userLeaving);
        addTaint(finished);
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(finished ? 1 : 0);
        data.writeInt(userLeaving ? 1 :0);
        data.writeInt(configChanges);
        mRemote.transact(SCHEDULE_PAUSE_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(finished ? 1 : 0);
        //data.writeInt(userLeaving ? 1 :0);
        //data.writeInt(configChanges);
        //mRemote.transact(SCHEDULE_PAUSE_ACTIVITY_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.767 -0400", hash_original_method = "8D9A120B7A56CEA8B7726147C17D07B9", hash_generated_method = "070D7BC20FB4162220C5438CA9B59977")
    public final void scheduleStopActivity(IBinder token, boolean showWindow,
            int configChanges) throws RemoteException {
        addTaint(configChanges);
        addTaint(showWindow);
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(showWindow ? 1 : 0);
        data.writeInt(configChanges);
        mRemote.transact(SCHEDULE_STOP_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(showWindow ? 1 : 0);
        //data.writeInt(configChanges);
        //mRemote.transact(SCHEDULE_STOP_ACTIVITY_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.768 -0400", hash_original_method = "5CD7B361184ED9060554C6A3DFD958DC", hash_generated_method = "26449A75313169FADD8AF47DD248EC8F")
    public final void scheduleWindowVisibility(IBinder token,
            boolean showWindow) throws RemoteException {
        addTaint(showWindow);
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(showWindow ? 1 : 0);
        mRemote.transact(SCHEDULE_WINDOW_VISIBILITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(showWindow ? 1 : 0);
        //mRemote.transact(SCHEDULE_WINDOW_VISIBILITY_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.770 -0400", hash_original_method = "037CA20E3B4BFBAB7FFA0954AEB6461B", hash_generated_method = "BD5067B18A3E5B302232517B11109BF7")
    public final void scheduleSleeping(IBinder token,
            boolean sleeping) throws RemoteException {
        addTaint(sleeping);
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(sleeping ? 1 : 0);
        mRemote.transact(SCHEDULE_SLEEPING_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(sleeping ? 1 : 0);
        //mRemote.transact(SCHEDULE_SLEEPING_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.771 -0400", hash_original_method = "3B8EDF2F01C1C03EA4B1D6DE44BA40A1", hash_generated_method = "65ACAA7EC15DA543F735F26382A56956")
    public final void scheduleResumeActivity(IBinder token, boolean isForward) throws RemoteException {
        addTaint(isForward);
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(isForward ? 1 : 0);
        mRemote.transact(SCHEDULE_RESUME_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(isForward ? 1 : 0);
        //mRemote.transact(SCHEDULE_RESUME_ACTIVITY_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.773 -0400", hash_original_method = "DF66BA9A5FFE4BEC7C06F9E22C0B5667", hash_generated_method = "6156B27802A084E9FF70A5784B982D84")
    public final void scheduleSendResult(IBinder token, List<ResultInfo> results) throws RemoteException {
        addTaint(results.getTaint());
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeTypedList(results);
        mRemote.transact(SCHEDULE_SEND_RESULT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeTypedList(results);
        //mRemote.transact(SCHEDULE_SEND_RESULT_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.776 -0400", hash_original_method = "F26C51AD11E848270AE4A9EC525A0958", hash_generated_method = "DCA71A66112BB2FB5C3801788B809AA4")
    public final void scheduleLaunchActivity(Intent intent, IBinder token, int ident,
            ActivityInfo info, Configuration curConfig, CompatibilityInfo compatInfo,
            Bundle state, List<ResultInfo> pendingResults,
    		List<Intent> pendingNewIntents, boolean notResumed, boolean isForward,
    		String profileName, ParcelFileDescriptor profileFd, boolean autoStopProfiler) throws RemoteException {
        addTaint(autoStopProfiler);
        addTaint(profileFd.getTaint());
        addTaint(profileName.getTaint());
        addTaint(isForward);
        addTaint(notResumed);
        addTaint(pendingNewIntents.getTaint());
        addTaint(pendingResults.getTaint());
        addTaint(state.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(curConfig.getTaint());
        addTaint(info.getTaint());
        addTaint(ident);
        addTaint(token.getTaint());
        addTaint(intent.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        intent.writeToParcel(data, 0);
        data.writeStrongBinder(token);
        data.writeInt(ident);
        info.writeToParcel(data, 0);
        curConfig.writeToParcel(data, 0);
        compatInfo.writeToParcel(data, 0);
        data.writeBundle(state);
        data.writeTypedList(pendingResults);
        data.writeTypedList(pendingNewIntents);
        data.writeInt(notResumed ? 1 : 0);
        data.writeInt(isForward ? 1 : 0);
        data.writeString(profileName);
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
        mRemote.transact(SCHEDULE_LAUNCH_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.780 -0400", hash_original_method = "D28E37482E7B0F4E96EA5389499C167D", hash_generated_method = "5F2F9BF2A01F5E5BDB611513FA7B7DDB")
    public final void scheduleRelaunchActivity(IBinder token,
            List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
            int configChanges, boolean notResumed, Configuration config) throws RemoteException {
        addTaint(config.getTaint());
        addTaint(notResumed);
        addTaint(configChanges);
        addTaint(pendingNewIntents.getTaint());
        addTaint(pendingResults.getTaint());
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeTypedList(pendingResults);
        data.writeTypedList(pendingNewIntents);
        data.writeInt(configChanges);
        data.writeInt(notResumed ? 1 : 0);
        if(config != null)        
        {
            data.writeInt(1);
            config.writeToParcel(data, 0);
        } //End block
        else
        {
            data.writeInt(0);
        } //End block
        mRemote.transact(SCHEDULE_RELAUNCH_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeTypedList(pendingResults);
        //data.writeTypedList(pendingNewIntents);
        //data.writeInt(configChanges);
        //data.writeInt(notResumed ? 1 : 0);
        //if (config != null) {
            //data.writeInt(1);
            //config.writeToParcel(data, 0);
        //} else {
            //data.writeInt(0);
        //}
        //mRemote.transact(SCHEDULE_RELAUNCH_ACTIVITY_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.782 -0400", hash_original_method = "C9991D806FA54B06B2907086AD0FF677", hash_generated_method = "CDDC3C991DAB569BC27FF332D26952FD")
    public void scheduleNewIntent(List<Intent> intents, IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        addTaint(intents.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeTypedList(intents);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_NEW_INTENT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeTypedList(intents);
        //data.writeStrongBinder(token);
        //mRemote.transact(SCHEDULE_NEW_INTENT_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.784 -0400", hash_original_method = "30A44B425A4D374BA87F220BE9EBE9B7", hash_generated_method = "057B1F1CCECF5B92908D098EE4164695")
    public final void scheduleDestroyActivity(IBinder token, boolean finishing,
            int configChanges) throws RemoteException {
        addTaint(configChanges);
        addTaint(finishing);
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(finishing ? 1 : 0);
        data.writeInt(configChanges);
        mRemote.transact(SCHEDULE_FINISH_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(finishing ? 1 : 0);
        //data.writeInt(configChanges);
        //mRemote.transact(SCHEDULE_FINISH_ACTIVITY_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.786 -0400", hash_original_method = "C42B70805B0C7922B26FF1FB8A47345A", hash_generated_method = "F30DC71D7756D99B9D48C6471893769E")
    public final void scheduleReceiver(Intent intent, ActivityInfo info,
            CompatibilityInfo compatInfo, int resultCode, String resultData,
            Bundle map, boolean sync) throws RemoteException {
        addTaint(sync);
        addTaint(map.getTaint());
        addTaint(resultData.getTaint());
        addTaint(resultCode);
        addTaint(compatInfo.getTaint());
        addTaint(info.getTaint());
        addTaint(intent.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        intent.writeToParcel(data, 0);
        info.writeToParcel(data, 0);
        compatInfo.writeToParcel(data, 0);
        data.writeInt(resultCode);
        data.writeString(resultData);
        data.writeBundle(map);
        data.writeInt(sync ? 1 : 0);
        mRemote.transact(SCHEDULE_RECEIVER_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //intent.writeToParcel(data, 0);
        //info.writeToParcel(data, 0);
        //compatInfo.writeToParcel(data, 0);
        //data.writeInt(resultCode);
        //data.writeString(resultData);
        //data.writeBundle(map);
        //data.writeInt(sync ? 1 : 0);
        //mRemote.transact(SCHEDULE_RECEIVER_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.788 -0400", hash_original_method = "FBCEE90A351EFB6AE922D66BDA990D49", hash_generated_method = "F48844FD049370BC65891E96A0594593")
    public final void scheduleCreateBackupAgent(ApplicationInfo app,
            CompatibilityInfo compatInfo, int backupMode) throws RemoteException {
        addTaint(backupMode);
        addTaint(compatInfo.getTaint());
        addTaint(app.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        app.writeToParcel(data, 0);
        compatInfo.writeToParcel(data, 0);
        data.writeInt(backupMode);
        mRemote.transact(SCHEDULE_CREATE_BACKUP_AGENT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //app.writeToParcel(data, 0);
        //compatInfo.writeToParcel(data, 0);
        //data.writeInt(backupMode);
        //mRemote.transact(SCHEDULE_CREATE_BACKUP_AGENT_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.790 -0400", hash_original_method = "213DB620D8FBF1A9C8341DE04CE19BA9", hash_generated_method = "EDF3DE78C966470A8304CE47C87001F8")
    public final void scheduleDestroyBackupAgent(ApplicationInfo app,
            CompatibilityInfo compatInfo) throws RemoteException {
        addTaint(compatInfo.getTaint());
        addTaint(app.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        app.writeToParcel(data, 0);
        compatInfo.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_DESTROY_BACKUP_AGENT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //app.writeToParcel(data, 0);
        //compatInfo.writeToParcel(data, 0);
        //mRemote.transact(SCHEDULE_DESTROY_BACKUP_AGENT_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.792 -0400", hash_original_method = "6404222A540CAF1DD9DE4C2FFFFCFFEA", hash_generated_method = "6C8BBEA21BC678545A7D12BE26ABEF18")
    public final void scheduleCreateService(IBinder token, ServiceInfo info,
            CompatibilityInfo compatInfo) throws RemoteException {
        addTaint(compatInfo.getTaint());
        addTaint(info.getTaint());
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        info.writeToParcel(data, 0);
        compatInfo.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_CREATE_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //info.writeToParcel(data, 0);
        //compatInfo.writeToParcel(data, 0);
        //mRemote.transact(SCHEDULE_CREATE_SERVICE_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.794 -0400", hash_original_method = "B7457DD503BA4FDF2022DE2BEF8A4AE7", hash_generated_method = "576EE22BFA91FEDD5BF306917FB1FF59")
    public final void scheduleBindService(IBinder token, Intent intent, boolean rebind) throws RemoteException {
        addTaint(rebind);
        addTaint(intent.getTaint());
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        intent.writeToParcel(data, 0);
        data.writeInt(rebind ? 1 : 0);
        mRemote.transact(SCHEDULE_BIND_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //intent.writeToParcel(data, 0);
        //data.writeInt(rebind ? 1 : 0);
        //mRemote.transact(SCHEDULE_BIND_SERVICE_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.795 -0400", hash_original_method = "015A697DF0B7313A5A91440BE749BA70", hash_generated_method = "0E63B78B52A632B97472F345D8485633")
    public final void scheduleUnbindService(IBinder token, Intent intent) throws RemoteException {
        addTaint(intent.getTaint());
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        intent.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_UNBIND_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //intent.writeToParcel(data, 0);
        //mRemote.transact(SCHEDULE_UNBIND_SERVICE_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.796 -0400", hash_original_method = "9440CDA1B00A67ECA4131E9DDBFF94BE", hash_generated_method = "06DCB7E4117107E85AC6F73AD01E9BFD")
    public final void scheduleServiceArgs(IBinder token, boolean taskRemoved, int startId,
	    int flags, Intent args) throws RemoteException {
        addTaint(args.getTaint());
        addTaint(flags);
        addTaint(startId);
        addTaint(taskRemoved);
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(taskRemoved ? 1 : 0);
        data.writeInt(startId);
        data.writeInt(flags);
        if(args != null)        
        {
            data.writeInt(1);
            args.writeToParcel(data, 0);
        } //End block
        else
        {
            data.writeInt(0);
        } //End block
        mRemote.transact(SCHEDULE_SERVICE_ARGS_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(taskRemoved ? 1 : 0);
        //data.writeInt(startId);
        //data.writeInt(flags);
        //if (args != null) {
            //data.writeInt(1);
            //args.writeToParcel(data, 0);
        //} else {
            //data.writeInt(0);
        //}
        //mRemote.transact(SCHEDULE_SERVICE_ARGS_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.797 -0400", hash_original_method = "C0CB5C15E3301223B23F08D2A5944F63", hash_generated_method = "83B606C53EE10864B540DA454DA40E5D")
    public final void scheduleStopService(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_STOP_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(SCHEDULE_STOP_SERVICE_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.801 -0400", hash_original_method = "4BEF103D5873B276CD3FCACF31B60747", hash_generated_method = "7DA660BFBAF026D0143B3E7F85052EF9")
    public final void bindApplication(String packageName, ApplicationInfo info,
            List<ProviderInfo> providers, ComponentName testName, String profileName,
            ParcelFileDescriptor profileFd, boolean autoStopProfiler, Bundle testArgs,
            IInstrumentationWatcher testWatcher, int debugMode, boolean restrictedBackupMode,
            boolean persistent, Configuration config, CompatibilityInfo compatInfo,
            Map<String, IBinder> services, Bundle coreSettings) throws RemoteException {
        addTaint(coreSettings.getTaint());
        addTaint(services.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(config.getTaint());
        addTaint(persistent);
        addTaint(restrictedBackupMode);
        addTaint(debugMode);
        addTaint(testWatcher.getTaint());
        addTaint(testArgs.getTaint());
        addTaint(autoStopProfiler);
        addTaint(profileFd.getTaint());
        addTaint(profileName.getTaint());
        addTaint(testName.getTaint());
        addTaint(providers.getTaint());
        addTaint(info.getTaint());
        addTaint(packageName.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(packageName);
        info.writeToParcel(data, 0);
        data.writeTypedList(providers);
        if(testName == null)        
        {
            data.writeInt(0);
        } //End block
        else
        {
            data.writeInt(1);
            testName.writeToParcel(data, 0);
        } //End block
        data.writeString(profileName);
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
        data.writeBundle(testArgs);
        data.writeStrongInterface(testWatcher);
        data.writeInt(debugMode);
        data.writeInt(restrictedBackupMode ? 1 : 0);
        data.writeInt(persistent ? 1 : 0);
        config.writeToParcel(data, 0);
        compatInfo.writeToParcel(data, 0);
        data.writeMap(services);
        data.writeBundle(coreSettings);
        mRemote.transact(BIND_APPLICATION_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.803 -0400", hash_original_method = "D9B97B2B196869DD6997DE8F0F3DB6A8", hash_generated_method = "D3CA0846FF06D3C9E5630604634D4BA2")
    public final void scheduleExit() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(SCHEDULE_EXIT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //mRemote.transact(SCHEDULE_EXIT_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.805 -0400", hash_original_method = "54C10BB1160F71CB1C13A86830E02D00", hash_generated_method = "ED81A5C888EDD342E66C9265348D4DAE")
    public final void scheduleSuicide() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(SCHEDULE_SUICIDE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //mRemote.transact(SCHEDULE_SUICIDE_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.807 -0400", hash_original_method = "D665A0E549B16E7CA815762264938E1F", hash_generated_method = "4D1B84982C08864D005750B934A0D095")
    public final void requestThumbnail(IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(REQUEST_THUMBNAIL_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(REQUEST_THUMBNAIL_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.808 -0400", hash_original_method = "2C1AC44E23EDB2D99649E68F5C228686", hash_generated_method = "66E3689AC30D669B7B5CF6DF89375758")
    public final void scheduleConfigurationChanged(Configuration config) throws RemoteException {
        addTaint(config.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        config.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //config.writeToParcel(data, 0);
        //mRemote.transact(SCHEDULE_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.809 -0400", hash_original_method = "0B9C0FCD5E0F49B1C57B4B2960062787", hash_generated_method = "6B4EB282B8034AF6B04F5C786CE621E6")
    public void updateTimeZone() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(UPDATE_TIME_ZONE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //mRemote.transact(UPDATE_TIME_ZONE_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.809 -0400", hash_original_method = "2659A1DE78848CD92C8786506E83B52E", hash_generated_method = "AD8A78BD18783AC3E3C75CF71B2022A5")
    public void clearDnsCache() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(CLEAR_DNS_CACHE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //mRemote.transact(CLEAR_DNS_CACHE_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.810 -0400", hash_original_method = "B79CFB3A109E11AF1583EBEB0497855B", hash_generated_method = "F9148AEE1E033D2B1E944CB252D1ABC7")
    public void setHttpProxy(String proxy, String port, String exclList) throws RemoteException {
        addTaint(exclList.getTaint());
        addTaint(port.getTaint());
        addTaint(proxy.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(proxy);
        data.writeString(port);
        data.writeString(exclList);
        mRemote.transact(SET_HTTP_PROXY_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeString(proxy);
        //data.writeString(port);
        //data.writeString(exclList);
        //mRemote.transact(SET_HTTP_PROXY_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.811 -0400", hash_original_method = "3372F7AC9E7DAF2A573613018E648B58", hash_generated_method = "AD3B0C88626F3F67EB69C259E2505999")
    public void processInBackground() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(PROCESS_IN_BACKGROUND_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //mRemote.transact(PROCESS_IN_BACKGROUND_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.813 -0400", hash_original_method = "E161C2DD10689877C1DFEA4F44C5B49B", hash_generated_method = "59BEC63F319B26C7384046F6C7245D72")
    public void dumpService(FileDescriptor fd, IBinder token, String[] args) throws RemoteException {
        addTaint(args[0].getTaint());
        addTaint(token.getTaint());
        addTaint(fd.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeStrongBinder(token);
        data.writeStringArray(args);
        mRemote.transact(DUMP_SERVICE_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeFileDescriptor(fd);
        //data.writeStrongBinder(token);
        //data.writeStringArray(args);
        //mRemote.transact(DUMP_SERVICE_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.815 -0400", hash_original_method = "D0D9D13B7AFC8143680190DFDB1E27B8", hash_generated_method = "2D22A40D153506A0338036F565216D19")
    public void scheduleRegisteredReceiver(IIntentReceiver receiver, Intent intent,
            int resultCode, String dataStr, Bundle extras, boolean ordered, boolean sticky) throws RemoteException {
        addTaint(sticky);
        addTaint(ordered);
        addTaint(extras.getTaint());
        addTaint(dataStr.getTaint());
        addTaint(resultCode);
        addTaint(intent.getTaint());
        addTaint(receiver.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(receiver.asBinder());
        intent.writeToParcel(data, 0);
        data.writeInt(resultCode);
        data.writeString(dataStr);
        data.writeBundle(extras);
        data.writeInt(ordered ? 1 : 0);
        data.writeInt(sticky ? 1 : 0);
        mRemote.transact(SCHEDULE_REGISTERED_RECEIVER_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(receiver.asBinder());
        //intent.writeToParcel(data, 0);
        //data.writeInt(resultCode);
        //data.writeString(dataStr);
        //data.writeBundle(extras);
        //data.writeInt(ordered ? 1 : 0);
        //data.writeInt(sticky ? 1 : 0);
        //mRemote.transact(SCHEDULE_REGISTERED_RECEIVER_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.816 -0400", hash_original_method = "9B139EEAA8537BD0FDDE5F0ABD5B2BE9", hash_generated_method = "29EF77959C49CF075B7080F4F56A9E01")
    public final void scheduleLowMemory() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(SCHEDULE_LOW_MEMORY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //mRemote.transact(SCHEDULE_LOW_MEMORY_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.817 -0400", hash_original_method = "17DBD33C1569C467FA5E9849A4B7DAA5", hash_generated_method = "F7F4AF9C39C7ADDB4F5E397335B2BAAA")
    public final void scheduleActivityConfigurationChanged(
            IBinder token) throws RemoteException {
        addTaint(token.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_ACTIVITY_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(SCHEDULE_ACTIVITY_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.818 -0400", hash_original_method = "727EEF540008C4D098D698BFCF8CD3C2", hash_generated_method = "A354385E0655044DC8F6A9B279BA163B")
    public void profilerControl(boolean start, String path,
            ParcelFileDescriptor fd, int profileType) throws RemoteException {
        addTaint(profileType);
        addTaint(fd.getTaint());
        addTaint(path.getTaint());
        addTaint(start);
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
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
        mRemote.transact(PROFILER_CONTROL_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeInt(start ? 1 : 0);
        //data.writeInt(profileType);
        //data.writeString(path);
        //if (fd != null) {
            //data.writeInt(1);
            //fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        //} else {
            //data.writeInt(0);
        //}
        //mRemote.transact(PROFILER_CONTROL_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.825 -0400", hash_original_method = "732323D2FE13A948B7BB2E76176A6F90", hash_generated_method = "F4CEC45A9988EAC4A66FF3A8C483DE9E")
    public void setSchedulingGroup(int group) throws RemoteException {
        addTaint(group);
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(group);
        mRemote.transact(SET_SCHEDULING_GROUP_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeInt(group);
        //mRemote.transact(SET_SCHEDULING_GROUP_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.828 -0400", hash_original_method = "307083C9D45C8404399A6967BFC677B1", hash_generated_method = "9F34CC8A67B079A7D955D484A8EC95CD")
    public void getMemoryInfo(Debug.MemoryInfo outInfo) throws RemoteException {
        addTaint(outInfo.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(GET_MEMORY_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        outInfo.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //mRemote.transact(GET_MEMORY_INFO_TRANSACTION, data, reply, 0);
        //reply.readException();
        //outInfo.readFromParcel(reply);
        //data.recycle();
        //reply.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.831 -0400", hash_original_method = "ACFC9FA9BBB19958DCB9CD2CDA3432BC", hash_generated_method = "0DB75DD89C31264EF86496D0D7C9CF84")
    public void dispatchPackageBroadcast(int cmd, String[] packages) throws RemoteException {
        addTaint(packages[0].getTaint());
        addTaint(cmd);
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(cmd);
        data.writeStringArray(packages);
        mRemote.transact(DISPATCH_PACKAGE_BROADCAST_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeInt(cmd);
        //data.writeStringArray(packages);
        //mRemote.transact(DISPATCH_PACKAGE_BROADCAST_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.833 -0400", hash_original_method = "0DA34150FDE2C37709AA14FDDE4D7856", hash_generated_method = "0B52A5AD0E8B100DB3EEFE2D3FE17C4F")
    public void scheduleCrash(String msg) throws RemoteException {
        addTaint(msg.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(msg);
        mRemote.transact(SCHEDULE_CRASH_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeString(msg);
        //mRemote.transact(SCHEDULE_CRASH_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.836 -0400", hash_original_method = "14C0866A00E3EF07677471FCFBE5006D", hash_generated_method = "75D795C09AF1EA7CD19A854E8015605C")
    public void dumpHeap(boolean managed, String path,
            ParcelFileDescriptor fd) throws RemoteException {
        addTaint(fd.getTaint());
        addTaint(path.getTaint());
        addTaint(managed);
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
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
        mRemote.transact(DUMP_HEAP_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeInt(managed ? 1 : 0);
        //data.writeString(path);
        //if (fd != null) {
            //data.writeInt(1);
            //fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        //} else {
            //data.writeInt(0);
        //}
        //mRemote.transact(DUMP_HEAP_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.838 -0400", hash_original_method = "7214E8ED977AF65264275D69BD7546BC", hash_generated_method = "CFA19AF2C50705D0CA471E3D57136C34")
    public void dumpActivity(FileDescriptor fd, IBinder token, String prefix, String[] args) throws RemoteException {
        addTaint(args[0].getTaint());
        addTaint(prefix.getTaint());
        addTaint(token.getTaint());
        addTaint(fd.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeStrongBinder(token);
        data.writeString(prefix);
        data.writeStringArray(args);
        mRemote.transact(DUMP_ACTIVITY_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeFileDescriptor(fd);
        //data.writeStrongBinder(token);
        //data.writeString(prefix);
        //data.writeStringArray(args);
        //mRemote.transact(DUMP_ACTIVITY_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.840 -0400", hash_original_method = "A6BD18E7AC0ECE0599305450F757BFCE", hash_generated_method = "9B7E48B8D0238A39B95E280429ECACBD")
    public void setCoreSettings(Bundle coreSettings) throws RemoteException {
        addTaint(coreSettings.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeBundle(coreSettings);
        mRemote.transact(SET_CORE_SETTINGS_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeBundle(coreSettings);
        //mRemote.transact(SET_CORE_SETTINGS_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.842 -0400", hash_original_method = "D2FA44681587FB29A159697C062E818E", hash_generated_method = "197FCB7786AD953CD52FA99C818A3B9A")
    public void updatePackageCompatibilityInfo(String pkg, CompatibilityInfo info) throws RemoteException {
        addTaint(info.getTaint());
        addTaint(pkg.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(pkg);
        info.writeToParcel(data, 0);
        mRemote.transact(UPDATE_PACKAGE_COMPATIBILITY_INFO_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeString(pkg);
        //info.writeToParcel(data, 0);
        //mRemote.transact(UPDATE_PACKAGE_COMPATIBILITY_INFO_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.844 -0400", hash_original_method = "2D27841853A53E2CEBF025C44DD03509", hash_generated_method = "CC98A9EF80ACE6E25A95F97BCF6C110F")
    public void scheduleTrimMemory(int level) throws RemoteException {
        addTaint(level);
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(level);
        mRemote.transact(SCHEDULE_TRIM_MEMORY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeInt(level);
        //mRemote.transact(SCHEDULE_TRIM_MEMORY_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.846 -0400", hash_original_method = "2FCBBED71EEEC4941D4B92155F73ADA0", hash_generated_method = "9C92F94985D63DEB68958EC16D3A217E")
    public Debug.MemoryInfo dumpMemInfo(FileDescriptor fd, boolean checkin, boolean all,
            String[] args) throws RemoteException {
        addTaint(args[0].getTaint());
        addTaint(all);
        addTaint(checkin);
        addTaint(fd.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeInt(checkin ? 1 : 0);
        data.writeInt(all ? 1 : 0);
        data.writeStringArray(args);
        mRemote.transact(DUMP_MEM_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        Debug.MemoryInfo info = new Debug.MemoryInfo();
        info.readFromParcel(reply);
        data.recycle();
        reply.recycle();
Debug.MemoryInfo var43CF3338FDBA93597A9562D3166E9DC4_2113590576 =         info;
        var43CF3338FDBA93597A9562D3166E9DC4_2113590576.addTaint(taint);
        return var43CF3338FDBA93597A9562D3166E9DC4_2113590576;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeFileDescriptor(fd);
        //data.writeInt(checkin ? 1 : 0);
        //data.writeInt(all ? 1 : 0);
        //data.writeStringArray(args);
        //mRemote.transact(DUMP_MEM_INFO_TRANSACTION, data, reply, 0);
        //reply.readException();
        //Debug.MemoryInfo info = new Debug.MemoryInfo();
        //info.readFromParcel(reply);
        //data.recycle();
        //reply.recycle();
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.847 -0400", hash_original_method = "A649B6B1FE51F3F8AC43A3FCCC575DB3", hash_generated_method = "35A9A2A47361FE54E34562726152D166")
    public void dumpGfxInfo(FileDescriptor fd, String[] args) throws RemoteException {
        addTaint(args[0].getTaint());
        addTaint(fd.getTaint());
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeStringArray(args);
        mRemote.transact(DUMP_GFX_INFO_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeFileDescriptor(fd);
        //data.writeStringArray(args);
        //mRemote.transact(DUMP_GFX_INFO_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
}

