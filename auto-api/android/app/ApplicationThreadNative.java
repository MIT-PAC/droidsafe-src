package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.600 -0400", hash_original_method = "94F554AA12869316A649B35CDD2C48B7", hash_generated_method = "7133F8D8ECAF77EA1D7A82265BA8BB74")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.845 -0400", hash_original_method = "B17DF3ED953946DC6FB6C3E82DF1C3B7", hash_generated_method = "BAF92FB3144B9355F4D2E7A6DC700FD7")
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //Begin case SCHEDULE_PAUSE_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            boolean finished;
            finished = data.readInt() != 0;
            boolean userLeaving;
            userLeaving = data.readInt() != 0;
            int configChanges;
            configChanges = data.readInt();
            schedulePauseActivity(b, finished, userLeaving, configChanges);
        } //End block
        //End case SCHEDULE_PAUSE_ACTIVITY_TRANSACTION 
        //Begin case SCHEDULE_STOP_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            boolean show;
            show = data.readInt() != 0;
            int configChanges;
            configChanges = data.readInt();
            scheduleStopActivity(b, show, configChanges);
        } //End block
        //End case SCHEDULE_STOP_ACTIVITY_TRANSACTION 
        //Begin case SCHEDULE_WINDOW_VISIBILITY_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            boolean show;
            show = data.readInt() != 0;
            scheduleWindowVisibility(b, show);
        } //End block
        //End case SCHEDULE_WINDOW_VISIBILITY_TRANSACTION 
        //Begin case SCHEDULE_SLEEPING_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            boolean sleeping;
            sleeping = data.readInt() != 0;
            scheduleSleeping(b, sleeping);
        } //End block
        //End case SCHEDULE_SLEEPING_TRANSACTION 
        //Begin case SCHEDULE_RESUME_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            boolean isForward;
            isForward = data.readInt() != 0;
            scheduleResumeActivity(b, isForward);
        } //End block
        //End case SCHEDULE_RESUME_ACTIVITY_TRANSACTION 
        //Begin case SCHEDULE_SEND_RESULT_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            List<ResultInfo> ri;
            ri = data.createTypedArrayList(ResultInfo.CREATOR);
            scheduleSendResult(b, ri);
        } //End block
        //End case SCHEDULE_SEND_RESULT_TRANSACTION 
        //Begin case SCHEDULE_LAUNCH_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            IBinder b;
            b = data.readStrongBinder();
            int ident;
            ident = data.readInt();
            ActivityInfo info;
            info = ActivityInfo.CREATOR.createFromParcel(data);
            Configuration curConfig;
            curConfig = Configuration.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo;
            compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            Bundle state;
            state = data.readBundle();
            List<ResultInfo> ri;
            ri = data.createTypedArrayList(ResultInfo.CREATOR);
            List<Intent> pi;
            pi = data.createTypedArrayList(Intent.CREATOR);
            boolean notResumed;
            notResumed = data.readInt() != 0;
            boolean isForward;
            isForward = data.readInt() != 0;
            String profileName;
            profileName = data.readString();
            ParcelFileDescriptor profileFd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_275832611 = (data.readInt() != 0);
            profileFd = data.readFileDescriptor();
            profileFd = null;
            boolean autoStopProfiler;
            autoStopProfiler = data.readInt() != 0;
            scheduleLaunchActivity(intent, b, ident, info, curConfig, compatInfo, state, ri, pi,
                    notResumed, isForward, profileName, profileFd, autoStopProfiler);
        } //End block
        //End case SCHEDULE_LAUNCH_ACTIVITY_TRANSACTION 
        //Begin case SCHEDULE_RELAUNCH_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            List<ResultInfo> ri;
            ri = data.createTypedArrayList(ResultInfo.CREATOR);
            List<Intent> pi;
            pi = data.createTypedArrayList(Intent.CREATOR);
            int configChanges;
            configChanges = data.readInt();
            boolean notResumed;
            notResumed = data.readInt() != 0;
            Configuration config;
            config = null;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_411672859 = (data.readInt() != 0);
                {
                    config = Configuration.CREATOR.createFromParcel(data);
                } //End block
            } //End collapsed parenthetic
            scheduleRelaunchActivity(b, ri, pi, configChanges, notResumed, config);
        } //End block
        //End case SCHEDULE_RELAUNCH_ACTIVITY_TRANSACTION 
        //Begin case SCHEDULE_NEW_INTENT_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            List<Intent> pi;
            pi = data.createTypedArrayList(Intent.CREATOR);
            IBinder b;
            b = data.readStrongBinder();
            scheduleNewIntent(pi, b);
        } //End block
        //End case SCHEDULE_NEW_INTENT_TRANSACTION 
        //Begin case SCHEDULE_FINISH_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            boolean finishing;
            finishing = data.readInt() != 0;
            int configChanges;
            configChanges = data.readInt();
            scheduleDestroyActivity(b, finishing, configChanges);
        } //End block
        //End case SCHEDULE_FINISH_ACTIVITY_TRANSACTION 
        //Begin case SCHEDULE_RECEIVER_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            ActivityInfo info;
            info = ActivityInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo;
            compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            int resultCode;
            resultCode = data.readInt();
            String resultData;
            resultData = data.readString();
            Bundle resultExtras;
            resultExtras = data.readBundle();
            boolean sync;
            sync = data.readInt() != 0;
            scheduleReceiver(intent, info, compatInfo, resultCode, resultData,
                    resultExtras, sync);
        } //End block
        //End case SCHEDULE_RECEIVER_TRANSACTION 
        //Begin case SCHEDULE_CREATE_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            ServiceInfo info;
            info = ServiceInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo;
            compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            scheduleCreateService(token, info, compatInfo);
        } //End block
        //End case SCHEDULE_CREATE_SERVICE_TRANSACTION 
        //Begin case SCHEDULE_BIND_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            boolean rebind;
            rebind = data.readInt() != 0;
            scheduleBindService(token, intent, rebind);
        } //End block
        //End case SCHEDULE_BIND_SERVICE_TRANSACTION 
        //Begin case SCHEDULE_UNBIND_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            scheduleUnbindService(token, intent);
        } //End block
        //End case SCHEDULE_UNBIND_SERVICE_TRANSACTION 
        //Begin case SCHEDULE_SERVICE_ARGS_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            boolean taskRemoved;
            taskRemoved = data.readInt() != 0;
            int startId;
            startId = data.readInt();
            int fl;
            fl = data.readInt();
            Intent args;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_99887194 = (data.readInt() != 0);
                {
                    args = Intent.CREATOR.createFromParcel(data);
                } //End block
                {
                    args = null;
                } //End block
            } //End collapsed parenthetic
            scheduleServiceArgs(token, taskRemoved, startId, fl, args);
        } //End block
        //End case SCHEDULE_SERVICE_ARGS_TRANSACTION 
        //Begin case SCHEDULE_STOP_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token;
            token = data.readStrongBinder();
            scheduleStopService(token);
        } //End block
        //End case SCHEDULE_STOP_SERVICE_TRANSACTION 
        //Begin case BIND_APPLICATION_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String packageName;
            packageName = data.readString();
            ApplicationInfo info;
            info = ApplicationInfo.CREATOR.createFromParcel(data);
            List<ProviderInfo> providers;
            providers = data.createTypedArrayList(ProviderInfo.CREATOR);
            ComponentName testName;
            boolean varEC80EFD4DF567B9D250862B3673CD334_685164070 = ((data.readInt() != 0));
            testName = new ComponentName(data);
            testName = null;
            String profileName;
            profileName = data.readString();
            ParcelFileDescriptor profileFd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1491977841 = (data.readInt() != 0);
            profileFd = data.readFileDescriptor();
            profileFd = null;
            boolean autoStopProfiler;
            autoStopProfiler = data.readInt() != 0;
            Bundle testArgs;
            testArgs = data.readBundle();
            IBinder binder;
            binder = data.readStrongBinder();
            IInstrumentationWatcher testWatcher;
            testWatcher = IInstrumentationWatcher.Stub.asInterface(binder);
            int testMode;
            testMode = data.readInt();
            boolean restrictedBackupMode;
            restrictedBackupMode = (data.readInt() != 0);
            boolean persistent;
            persistent = (data.readInt() != 0);
            Configuration config;
            config = Configuration.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo;
            compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            HashMap<String, IBinder> services;
            services = data.readHashMap(null);
            Bundle coreSettings;
            coreSettings = data.readBundle();
            bindApplication(packageName, info,
                            providers, testName, profileName, profileFd, autoStopProfiler,
                            testArgs, testWatcher, testMode, restrictedBackupMode, persistent,
                            config, compatInfo, services, coreSettings);
        } //End block
        //End case BIND_APPLICATION_TRANSACTION 
        //Begin case SCHEDULE_EXIT_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            scheduleExit();
        } //End block
        //End case SCHEDULE_EXIT_TRANSACTION 
        //Begin case SCHEDULE_SUICIDE_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            scheduleSuicide();
        } //End block
        //End case SCHEDULE_SUICIDE_TRANSACTION 
        //Begin case REQUEST_THUMBNAIL_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            requestThumbnail(b);
        } //End block
        //End case REQUEST_THUMBNAIL_TRANSACTION 
        //Begin case SCHEDULE_CONFIGURATION_CHANGED_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Configuration config;
            config = Configuration.CREATOR.createFromParcel(data);
            scheduleConfigurationChanged(config);
        } //End block
        //End case SCHEDULE_CONFIGURATION_CHANGED_TRANSACTION 
        //Begin case UPDATE_TIME_ZONE_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            updateTimeZone();
        } //End block
        //End case UPDATE_TIME_ZONE_TRANSACTION 
        //Begin case CLEAR_DNS_CACHE_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            clearDnsCache();
        } //End block
        //End case CLEAR_DNS_CACHE_TRANSACTION 
        //Begin case SET_HTTP_PROXY_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String proxy;
            proxy = data.readString();
            String port;
            port = data.readString();
            String exclList;
            exclList = data.readString();
            setHttpProxy(proxy, port, exclList);
        } //End block
        //End case SET_HTTP_PROXY_TRANSACTION 
        //Begin case PROCESS_IN_BACKGROUND_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            processInBackground();
        } //End block
        //End case PROCESS_IN_BACKGROUND_TRANSACTION 
        //Begin case DUMP_SERVICE_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd;
            fd = data.readFileDescriptor();
            IBinder service;
            service = data.readStrongBinder();
            String[] args;
            args = data.readStringArray();
            {
                dumpService(fd.getFileDescriptor(), service, args);
                try 
                {
                    fd.close();
                } //End block
                catch (IOException e)
                { }
            } //End block
        } //End block
        //End case DUMP_SERVICE_TRANSACTION 
        //Begin case SCHEDULE_REGISTERED_RECEIVER_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IIntentReceiver receiver;
            receiver = IIntentReceiver.Stub.asInterface(
                    data.readStrongBinder());
            Intent intent;
            intent = Intent.CREATOR.createFromParcel(data);
            int resultCode;
            resultCode = data.readInt();
            String dataStr;
            dataStr = data.readString();
            Bundle extras;
            extras = data.readBundle();
            boolean ordered;
            ordered = data.readInt() != 0;
            boolean sticky;
            sticky = data.readInt() != 0;
            scheduleRegisteredReceiver(receiver, intent,
                    resultCode, dataStr, extras, ordered, sticky);
        } //End block
        //End case SCHEDULE_REGISTERED_RECEIVER_TRANSACTION 
        //Begin case SCHEDULE_LOW_MEMORY_TRANSACTION 
        {
            scheduleLowMemory();
        } //End block
        //End case SCHEDULE_LOW_MEMORY_TRANSACTION 
        //Begin case SCHEDULE_ACTIVITY_CONFIGURATION_CHANGED_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b;
            b = data.readStrongBinder();
            scheduleActivityConfigurationChanged(b);
        } //End block
        //End case SCHEDULE_ACTIVITY_CONFIGURATION_CHANGED_TRANSACTION 
        //Begin case PROFILER_CONTROL_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            boolean start;
            start = data.readInt() != 0;
            int profileType;
            profileType = data.readInt();
            String path;
            path = data.readString();
            ParcelFileDescriptor fd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1201758358 = (data.readInt() != 0);
            fd = data.readFileDescriptor();
            fd = null;
            profilerControl(start, path, fd, profileType);
        } //End block
        //End case PROFILER_CONTROL_TRANSACTION 
        //Begin case SET_SCHEDULING_GROUP_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            int group;
            group = data.readInt();
            setSchedulingGroup(group);
        } //End block
        //End case SET_SCHEDULING_GROUP_TRANSACTION 
        //Begin case SCHEDULE_CREATE_BACKUP_AGENT_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ApplicationInfo appInfo;
            appInfo = ApplicationInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo;
            compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            int backupMode;
            backupMode = data.readInt();
            scheduleCreateBackupAgent(appInfo, compatInfo, backupMode);
        } //End block
        //End case SCHEDULE_CREATE_BACKUP_AGENT_TRANSACTION 
        //Begin case SCHEDULE_DESTROY_BACKUP_AGENT_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ApplicationInfo appInfo;
            appInfo = ApplicationInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo;
            compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            scheduleDestroyBackupAgent(appInfo, compatInfo);
        } //End block
        //End case SCHEDULE_DESTROY_BACKUP_AGENT_TRANSACTION 
        //Begin case GET_MEMORY_INFO_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Debug.MemoryInfo mi;
            mi = new Debug.MemoryInfo();
            getMemoryInfo(mi);
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
        } //End block
        //End case GET_MEMORY_INFO_TRANSACTION 
        //Begin case DISPATCH_PACKAGE_BROADCAST_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            int cmd;
            cmd = data.readInt();
            String[] packages;
            packages = data.readStringArray();
            dispatchPackageBroadcast(cmd, packages);
        } //End block
        //End case DISPATCH_PACKAGE_BROADCAST_TRANSACTION 
        //Begin case SCHEDULE_CRASH_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String msg;
            msg = data.readString();
            scheduleCrash(msg);
        } //End block
        //End case SCHEDULE_CRASH_TRANSACTION 
        //Begin case DUMP_HEAP_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            boolean managed;
            managed = data.readInt() != 0;
            String path;
            path = data.readString();
            ParcelFileDescriptor fd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_2033562452 = (data.readInt() != 0);
            fd = data.readFileDescriptor();
            fd = null;
            dumpHeap(managed, path, fd);
        } //End block
        //End case DUMP_HEAP_TRANSACTION 
        //Begin case DUMP_ACTIVITY_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd;
            fd = data.readFileDescriptor();
            IBinder activity;
            activity = data.readStrongBinder();
            String prefix;
            prefix = data.readString();
            String[] args;
            args = data.readStringArray();
            {
                dumpActivity(fd.getFileDescriptor(), activity, prefix, args);
                try 
                {
                    fd.close();
                } //End block
                catch (IOException e)
                { }
            } //End block
        } //End block
        //End case DUMP_ACTIVITY_TRANSACTION 
        //Begin case SET_CORE_SETTINGS_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Bundle settings;
            settings = data.readBundle();
            setCoreSettings(settings);
        } //End block
        //End case SET_CORE_SETTINGS_TRANSACTION 
        //Begin case UPDATE_PACKAGE_COMPATIBILITY_INFO_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String pkg;
            pkg = data.readString();
            CompatibilityInfo compat;
            compat = CompatibilityInfo.CREATOR.createFromParcel(data);
            updatePackageCompatibilityInfo(pkg, compat);
        } //End block
        //End case UPDATE_PACKAGE_COMPATIBILITY_INFO_TRANSACTION 
        //Begin case SCHEDULE_TRIM_MEMORY_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            int level;
            level = data.readInt();
            scheduleTrimMemory(level);
        } //End block
        //End case SCHEDULE_TRIM_MEMORY_TRANSACTION 
        //Begin case DUMP_MEM_INFO_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd;
            fd = data.readFileDescriptor();
            boolean checkin;
            checkin = data.readInt() != 0;
            boolean all;
            all = data.readInt() != 0;
            String[] args;
            args = data.readStringArray();
            Debug.MemoryInfo mi;
            mi = null;
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
                    { }
                } //End block
            } //End block
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
        } //End block
        //End case DUMP_MEM_INFO_TRANSACTION 
        //Begin case DUMP_GFX_INFO_TRANSACTION 
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd;
            fd = data.readFileDescriptor();
            String[] args;
            args = data.readStringArray();
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
                    { }
                } //End block
            } //End block
            reply.writeNoException();
        } //End block
        //End case DUMP_GFX_INFO_TRANSACTION 
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_2099186125 = (super.onTransact(code, data, reply, flags));
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_86004818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_86004818;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.869 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "25E43FE9FDF16BEC8E5E6357C5645797")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_678143825 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_678143825 = this;
        varB4EAC82CA7396A68D541C85D26508E83_678143825.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_678143825;
        // ---------- Original Method ----------
        //return this;
    }

    
}

class ApplicationThreadProxy implements IApplicationThread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.870 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.896 -0400", hash_original_method = "08B50EC8A0FF95C7A679215C14C2E347", hash_generated_method = "07C34BD386C4B1EE3B5CAAFB7C484EE0")
    public  ApplicationThreadProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.911 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "7B35D8B4683C6D1F99BB1D34D84BBC44")
    public final IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_81233764 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_81233764 = mRemote;
        varB4EAC82CA7396A68D541C85D26508E83_81233764.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_81233764;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.914 -0400", hash_original_method = "F385294CE3D6AC21F25405F7E688DF1E", hash_generated_method = "D44EE9D6144EEFA8C714A1EBD5A8A7A2")
    public final void schedulePauseActivity(IBinder token, boolean finished,
            boolean userLeaving, int configChanges) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(finished ? 1 : 0);
        data.writeInt(userLeaving ? 1 :0);
        data.writeInt(configChanges);
        mRemote.transact(SCHEDULE_PAUSE_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(finished);
        addTaint(userLeaving);
        addTaint(configChanges);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.933 -0400", hash_original_method = "8D9A120B7A56CEA8B7726147C17D07B9", hash_generated_method = "A9044F82EF7FF3B5532217D2525A3847")
    public final void scheduleStopActivity(IBinder token, boolean showWindow,
            int configChanges) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(showWindow ? 1 : 0);
        data.writeInt(configChanges);
        mRemote.transact(SCHEDULE_STOP_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(showWindow);
        addTaint(configChanges);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.964 -0400", hash_original_method = "5CD7B361184ED9060554C6A3DFD958DC", hash_generated_method = "2B4F75EF44BE298F361CEB24906294D2")
    public final void scheduleWindowVisibility(IBinder token,
            boolean showWindow) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(showWindow ? 1 : 0);
        mRemote.transact(SCHEDULE_WINDOW_VISIBILITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(showWindow);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(showWindow ? 1 : 0);
        //mRemote.transact(SCHEDULE_WINDOW_VISIBILITY_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.973 -0400", hash_original_method = "037CA20E3B4BFBAB7FFA0954AEB6461B", hash_generated_method = "E5D2C7139C5C7AAFBED265BBA6320EBD")
    public final void scheduleSleeping(IBinder token,
            boolean sleeping) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(sleeping ? 1 : 0);
        mRemote.transact(SCHEDULE_SLEEPING_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(sleeping);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(sleeping ? 1 : 0);
        //mRemote.transact(SCHEDULE_SLEEPING_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.990 -0400", hash_original_method = "3B8EDF2F01C1C03EA4B1D6DE44BA40A1", hash_generated_method = "DAD321F368A095A0F1CB01313C8E610F")
    public final void scheduleResumeActivity(IBinder token, boolean isForward) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(isForward ? 1 : 0);
        mRemote.transact(SCHEDULE_RESUME_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(isForward);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeInt(isForward ? 1 : 0);
        //mRemote.transact(SCHEDULE_RESUME_ACTIVITY_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.024 -0400", hash_original_method = "DF66BA9A5FFE4BEC7C06F9E22C0B5667", hash_generated_method = "8BBB8779E42D26EA53FE602F1393F0CD")
    public final void scheduleSendResult(IBinder token, List<ResultInfo> results) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeTypedList(results);
        mRemote.transact(SCHEDULE_SEND_RESULT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(results.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //data.writeTypedList(results);
        //mRemote.transact(SCHEDULE_SEND_RESULT_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.046 -0400", hash_original_method = "F26C51AD11E848270AE4A9EC525A0958", hash_generated_method = "82FF1BE2DDAB1F4F16A40C231E3848DF")
    public final void scheduleLaunchActivity(Intent intent, IBinder token, int ident,
            ActivityInfo info, Configuration curConfig, CompatibilityInfo compatInfo,
            Bundle state, List<ResultInfo> pendingResults,
    		List<Intent> pendingNewIntents, boolean notResumed, boolean isForward,
    		String profileName, ParcelFileDescriptor profileFd, boolean autoStopProfiler) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
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
        {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        {
            data.writeInt(0);
        } //End block
        data.writeInt(autoStopProfiler ? 1 : 0);
        mRemote.transact(SCHEDULE_LAUNCH_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(intent.getTaint());
        addTaint(token.getTaint());
        addTaint(ident);
        addTaint(info.getTaint());
        addTaint(curConfig.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(state.getTaint());
        addTaint(pendingResults.getTaint());
        addTaint(pendingNewIntents.getTaint());
        addTaint(notResumed);
        addTaint(isForward);
        addTaint(profileName.getTaint());
        addTaint(profileFd.getTaint());
        addTaint(autoStopProfiler);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.062 -0400", hash_original_method = "D28E37482E7B0F4E96EA5389499C167D", hash_generated_method = "98320557E5014792EC532F82C3D38286")
    public final void scheduleRelaunchActivity(IBinder token,
            List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
            int configChanges, boolean notResumed, Configuration config) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeTypedList(pendingResults);
        data.writeTypedList(pendingNewIntents);
        data.writeInt(configChanges);
        data.writeInt(notResumed ? 1 : 0);
        {
            data.writeInt(1);
            config.writeToParcel(data, 0);
        } //End block
        {
            data.writeInt(0);
        } //End block
        mRemote.transact(SCHEDULE_RELAUNCH_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(pendingResults.getTaint());
        addTaint(pendingNewIntents.getTaint());
        addTaint(configChanges);
        addTaint(notResumed);
        addTaint(config.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.087 -0400", hash_original_method = "C9991D806FA54B06B2907086AD0FF677", hash_generated_method = "8D23D00BFAA447DFFFEE8647736C92EA")
    public void scheduleNewIntent(List<Intent> intents, IBinder token) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeTypedList(intents);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_NEW_INTENT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(intents.getTaint());
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeTypedList(intents);
        //data.writeStrongBinder(token);
        //mRemote.transact(SCHEDULE_NEW_INTENT_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.103 -0400", hash_original_method = "30A44B425A4D374BA87F220BE9EBE9B7", hash_generated_method = "BDF31A31978335799A6C1A8B5ABD158D")
    public final void scheduleDestroyActivity(IBinder token, boolean finishing,
            int configChanges) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(finishing ? 1 : 0);
        data.writeInt(configChanges);
        mRemote.transact(SCHEDULE_FINISH_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(finishing);
        addTaint(configChanges);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.122 -0400", hash_original_method = "C42B70805B0C7922B26FF1FB8A47345A", hash_generated_method = "78BE190C20BCAD2BCADEE6237FBD2DE3")
    public final void scheduleReceiver(Intent intent, ActivityInfo info,
            CompatibilityInfo compatInfo, int resultCode, String resultData,
            Bundle map, boolean sync) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
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
        addTaint(intent.getTaint());
        addTaint(info.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(resultCode);
        addTaint(resultData.getTaint());
        addTaint(map.getTaint());
        addTaint(sync);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.134 -0400", hash_original_method = "FBCEE90A351EFB6AE922D66BDA990D49", hash_generated_method = "DAF71D31853A723E6D37AB24FE7C3FF0")
    public final void scheduleCreateBackupAgent(ApplicationInfo app,
            CompatibilityInfo compatInfo, int backupMode) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        app.writeToParcel(data, 0);
        compatInfo.writeToParcel(data, 0);
        data.writeInt(backupMode);
        mRemote.transact(SCHEDULE_CREATE_BACKUP_AGENT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(app.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(backupMode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.149 -0400", hash_original_method = "213DB620D8FBF1A9C8341DE04CE19BA9", hash_generated_method = "7B6591C3CA7D7381E9136000F23D36C4")
    public final void scheduleDestroyBackupAgent(ApplicationInfo app,
            CompatibilityInfo compatInfo) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        app.writeToParcel(data, 0);
        compatInfo.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_DESTROY_BACKUP_AGENT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(app.getTaint());
        addTaint(compatInfo.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //app.writeToParcel(data, 0);
        //compatInfo.writeToParcel(data, 0);
        //mRemote.transact(SCHEDULE_DESTROY_BACKUP_AGENT_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.164 -0400", hash_original_method = "6404222A540CAF1DD9DE4C2FFFFCFFEA", hash_generated_method = "EB4CCE670329286889E398ACEF7B3AE5")
    public final void scheduleCreateService(IBinder token, ServiceInfo info,
            CompatibilityInfo compatInfo) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        info.writeToParcel(data, 0);
        compatInfo.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_CREATE_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(info.getTaint());
        addTaint(compatInfo.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.189 -0400", hash_original_method = "B7457DD503BA4FDF2022DE2BEF8A4AE7", hash_generated_method = "BFF5D66BBF0F3154F0B6EC861292D218")
    public final void scheduleBindService(IBinder token, Intent intent, boolean rebind) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        intent.writeToParcel(data, 0);
        data.writeInt(rebind ? 1 : 0);
        mRemote.transact(SCHEDULE_BIND_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(intent.getTaint());
        addTaint(rebind);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.199 -0400", hash_original_method = "015A697DF0B7313A5A91440BE749BA70", hash_generated_method = "3C7DE532EEE4E516E0770595DA6A5ED9")
    public final void scheduleUnbindService(IBinder token, Intent intent) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        intent.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_UNBIND_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //intent.writeToParcel(data, 0);
        //mRemote.transact(SCHEDULE_UNBIND_SERVICE_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.284 -0400", hash_original_method = "9440CDA1B00A67ECA4131E9DDBFF94BE", hash_generated_method = "A57722F6EED6E248AEBD70BE52D32A3A")
    public final void scheduleServiceArgs(IBinder token, boolean taskRemoved, int startId,
	    int flags, Intent args) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(taskRemoved ? 1 : 0);
        data.writeInt(startId);
        data.writeInt(flags);
        {
            data.writeInt(1);
            args.writeToParcel(data, 0);
        } //End block
        {
            data.writeInt(0);
        } //End block
        mRemote.transact(SCHEDULE_SERVICE_ARGS_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(taskRemoved);
        addTaint(startId);
        addTaint(flags);
        addTaint(args.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.298 -0400", hash_original_method = "C0CB5C15E3301223B23F08D2A5944F63", hash_generated_method = "AEEF4B4407626FABB62DEF17C9F50E22")
    public final void scheduleStopService(IBinder token) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_STOP_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(SCHEDULE_STOP_SERVICE_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.364 -0400", hash_original_method = "4BEF103D5873B276CD3FCACF31B60747", hash_generated_method = "3A796D185C0F711B3D218AC53B1AD55B")
    public final void bindApplication(String packageName, ApplicationInfo info,
            List<ProviderInfo> providers, ComponentName testName, String profileName,
            ParcelFileDescriptor profileFd, boolean autoStopProfiler, Bundle testArgs,
            IInstrumentationWatcher testWatcher, int debugMode, boolean restrictedBackupMode,
            boolean persistent, Configuration config, CompatibilityInfo compatInfo,
            Map<String, IBinder> services, Bundle coreSettings) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(packageName);
        info.writeToParcel(data, 0);
        data.writeTypedList(providers);
        {
            data.writeInt(0);
        } //End block
        {
            data.writeInt(1);
            testName.writeToParcel(data, 0);
        } //End block
        data.writeString(profileName);
        {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
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
        addTaint(packageName.getTaint());
        addTaint(info.getTaint());
        addTaint(providers.getTaint());
        addTaint(testName.getTaint());
        addTaint(profileName.getTaint());
        addTaint(profileFd.getTaint());
        addTaint(autoStopProfiler);
        addTaint(testArgs.getTaint());
        addTaint(testWatcher.getTaint());
        addTaint(debugMode);
        addTaint(restrictedBackupMode);
        addTaint(persistent);
        addTaint(config.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(services.getTaint());
        addTaint(coreSettings.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.368 -0400", hash_original_method = "D9B97B2B196869DD6997DE8F0F3DB6A8", hash_generated_method = "3069EAE3488EC6B0F0DC7701D240A0DD")
    public final void scheduleExit() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.370 -0400", hash_original_method = "54C10BB1160F71CB1C13A86830E02D00", hash_generated_method = "CC8A74317DC5E1E5321A4037CD5C6720")
    public final void scheduleSuicide() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.386 -0400", hash_original_method = "D665A0E549B16E7CA815762264938E1F", hash_generated_method = "F87B8E073D90B5BABCC797DD1489804A")
    public final void requestThumbnail(IBinder token) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(REQUEST_THUMBNAIL_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(REQUEST_THUMBNAIL_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.388 -0400", hash_original_method = "2C1AC44E23EDB2D99649E68F5C228686", hash_generated_method = "4F6DFBD9C291F38076C6C68C32CFADE1")
    public final void scheduleConfigurationChanged(Configuration config) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        config.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(config.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //config.writeToParcel(data, 0);
        //mRemote.transact(SCHEDULE_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.403 -0400", hash_original_method = "0B9C0FCD5E0F49B1C57B4B2960062787", hash_generated_method = "384C253EEF05A262784ED17AD5066B57")
    public void updateTimeZone() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.405 -0400", hash_original_method = "2659A1DE78848CD92C8786506E83B52E", hash_generated_method = "DA4BDED71A3E2A79C17A0A5011B4FE45")
    public void clearDnsCache() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.427 -0400", hash_original_method = "B79CFB3A109E11AF1583EBEB0497855B", hash_generated_method = "592C291B6DBC9FBD6D4877285FA2870D")
    public void setHttpProxy(String proxy, String port, String exclList) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(proxy);
        data.writeString(port);
        data.writeString(exclList);
        mRemote.transact(SET_HTTP_PROXY_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(proxy.getTaint());
        addTaint(port.getTaint());
        addTaint(exclList.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeString(proxy);
        //data.writeString(port);
        //data.writeString(exclList);
        //mRemote.transact(SET_HTTP_PROXY_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.452 -0400", hash_original_method = "3372F7AC9E7DAF2A573613018E648B58", hash_generated_method = "5DC4EFD08626DBC5E06CAFB30682D23B")
    public void processInBackground() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.458 -0400", hash_original_method = "E161C2DD10689877C1DFEA4F44C5B49B", hash_generated_method = "87312FE3852E7C57546B1E449F70107B")
    public void dumpService(FileDescriptor fd, IBinder token, String[] args) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeStrongBinder(token);
        data.writeStringArray(args);
        mRemote.transact(DUMP_SERVICE_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(fd.getTaint());
        addTaint(token.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeFileDescriptor(fd);
        //data.writeStrongBinder(token);
        //data.writeStringArray(args);
        //mRemote.transact(DUMP_SERVICE_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.470 -0400", hash_original_method = "D0D9D13B7AFC8143680190DFDB1E27B8", hash_generated_method = "66310C565AC58697398B06BFA527DEA5")
    public void scheduleRegisteredReceiver(IIntentReceiver receiver, Intent intent,
            int resultCode, String dataStr, Bundle extras, boolean ordered, boolean sticky) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
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
        addTaint(receiver.getTaint());
        addTaint(intent.getTaint());
        addTaint(resultCode);
        addTaint(dataStr.getTaint());
        addTaint(extras.getTaint());
        addTaint(ordered);
        addTaint(sticky);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.486 -0400", hash_original_method = "9B139EEAA8537BD0FDDE5F0ABD5B2BE9", hash_generated_method = "A6DD7BF9D65F73640FB1F621F809CC3D")
    public final void scheduleLowMemory() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.507 -0400", hash_original_method = "17DBD33C1569C467FA5E9849A4B7DAA5", hash_generated_method = "3E206DDB36470F9249EBC02D9E9985E3")
    public final void scheduleActivityConfigurationChanged(
            IBinder token) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_ACTIVITY_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeStrongBinder(token);
        //mRemote.transact(SCHEDULE_ACTIVITY_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.520 -0400", hash_original_method = "727EEF540008C4D098D698BFCF8CD3C2", hash_generated_method = "BBE18D058B80F51E86B52042FC641D5B")
    public void profilerControl(boolean start, String path,
            ParcelFileDescriptor fd, int profileType) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
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
        mRemote.transact(PROFILER_CONTROL_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(start);
        addTaint(path.getTaint());
        addTaint(fd.getTaint());
        addTaint(profileType);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.535 -0400", hash_original_method = "732323D2FE13A948B7BB2E76176A6F90", hash_generated_method = "B0FB359727CF9BBE85D6DBB9CCAAE015")
    public void setSchedulingGroup(int group) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(group);
        mRemote.transact(SET_SCHEDULING_GROUP_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(group);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeInt(group);
        //mRemote.transact(SET_SCHEDULING_GROUP_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.566 -0400", hash_original_method = "307083C9D45C8404399A6967BFC677B1", hash_generated_method = "7FBCF37006A676C04995367CD2885978")
    public void getMemoryInfo(Debug.MemoryInfo outInfo) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(GET_MEMORY_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        outInfo.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        addTaint(outInfo.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.588 -0400", hash_original_method = "ACFC9FA9BBB19958DCB9CD2CDA3432BC", hash_generated_method = "F8F0F73B6F27EC79D8633BDCA1A3C61A")
    public void dispatchPackageBroadcast(int cmd, String[] packages) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(cmd);
        data.writeStringArray(packages);
        mRemote.transact(DISPATCH_PACKAGE_BROADCAST_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(cmd);
        addTaint(packages[0].getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeInt(cmd);
        //data.writeStringArray(packages);
        //mRemote.transact(DISPATCH_PACKAGE_BROADCAST_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.594 -0400", hash_original_method = "0DA34150FDE2C37709AA14FDDE4D7856", hash_generated_method = "FD7BC5FA0EE58E370F500F134EC2A1CD")
    public void scheduleCrash(String msg) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(msg);
        mRemote.transact(SCHEDULE_CRASH_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeString(msg);
        //mRemote.transact(SCHEDULE_CRASH_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.622 -0400", hash_original_method = "14C0866A00E3EF07677471FCFBE5006D", hash_generated_method = "1CCB497152E7684A5DBF8FE2C863B376")
    public void dumpHeap(boolean managed, String path,
            ParcelFileDescriptor fd) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(managed ? 1 : 0);
        data.writeString(path);
        {
            data.writeInt(1);
            fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } //End block
        {
            data.writeInt(0);
        } //End block
        mRemote.transact(DUMP_HEAP_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(managed);
        addTaint(path.getTaint());
        addTaint(fd.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.643 -0400", hash_original_method = "7214E8ED977AF65264275D69BD7546BC", hash_generated_method = "1176893C9E1C20AA384B89BFB233C7BE")
    public void dumpActivity(FileDescriptor fd, IBinder token, String prefix, String[] args) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeStrongBinder(token);
        data.writeString(prefix);
        data.writeStringArray(args);
        mRemote.transact(DUMP_ACTIVITY_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(fd.getTaint());
        addTaint(token.getTaint());
        addTaint(prefix.getTaint());
        addTaint(args[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.658 -0400", hash_original_method = "A6BD18E7AC0ECE0599305450F757BFCE", hash_generated_method = "BF5C83AC1F821091997B31CDCCDBF391")
    public void setCoreSettings(Bundle coreSettings) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeBundle(coreSettings);
        mRemote.transact(SET_CORE_SETTINGS_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        addTaint(coreSettings.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeBundle(coreSettings);
        //mRemote.transact(SET_CORE_SETTINGS_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.670 -0400", hash_original_method = "D2FA44681587FB29A159697C062E818E", hash_generated_method = "F68B287965187407A6EA3AD7364BA35C")
    public void updatePackageCompatibilityInfo(String pkg, CompatibilityInfo info) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(pkg);
        info.writeToParcel(data, 0);
        mRemote.transact(UPDATE_PACKAGE_COMPATIBILITY_INFO_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        addTaint(pkg.getTaint());
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeString(pkg);
        //info.writeToParcel(data, 0);
        //mRemote.transact(UPDATE_PACKAGE_COMPATIBILITY_INFO_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.686 -0400", hash_original_method = "2D27841853A53E2CEBF025C44DD03509", hash_generated_method = "171A75ACF12F32AAA750C597C162C77D")
    public void scheduleTrimMemory(int level) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(level);
        mRemote.transact(SCHEDULE_TRIM_MEMORY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        addTaint(level);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeInt(level);
        //mRemote.transact(SCHEDULE_TRIM_MEMORY_TRANSACTION, data, null,
                //IBinder.FLAG_ONEWAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.691 -0400", hash_original_method = "2FCBBED71EEEC4941D4B92155F73ADA0", hash_generated_method = "F9597DE426C75F8CCD24311F19337E29")
    public Debug.MemoryInfo dumpMemInfo(FileDescriptor fd, boolean checkin, boolean all,
            String[] args) throws RemoteException {
        Debug.MemoryInfo varB4EAC82CA7396A68D541C85D26508E83_1991029363 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeInt(checkin ? 1 : 0);
        data.writeInt(all ? 1 : 0);
        data.writeStringArray(args);
        mRemote.transact(DUMP_MEM_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        Debug.MemoryInfo info;
        info = new Debug.MemoryInfo();
        info.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1991029363 = info;
        addTaint(fd.getTaint());
        addTaint(checkin);
        addTaint(all);
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1991029363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1991029363;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.710 -0400", hash_original_method = "A649B6B1FE51F3F8AC43A3FCCC575DB3", hash_generated_method = "0B6A0E236EEEC3330291524DA7A41BF0")
    public void dumpGfxInfo(FileDescriptor fd, String[] args) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeStringArray(args);
        mRemote.transact(DUMP_GFX_INFO_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(fd.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeFileDescriptor(fd);
        //data.writeStringArray(args);
        //mRemote.transact(DUMP_GFX_INFO_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        //data.recycle();
    }

    
}

