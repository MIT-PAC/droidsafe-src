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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.801 -0400", hash_original_method = "94F554AA12869316A649B35CDD2C48B7", hash_generated_method = "7133F8D8ECAF77EA1D7A82265BA8BB74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ApplicationThreadNative() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.808 -0400", hash_original_method = "B17DF3ED953946DC6FB6C3E82DF1C3B7", hash_generated_method = "04E14BBF27B385263BBFAE577AC32937")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(flags);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(reply.dsTaint);
        dsTaint.addTaint(code);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_599278006 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_2122237573 = (data.readInt() != 0);
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
                boolean varE6AB5F2F920478433EF302793CCFF01F_308495876 = (data.readInt() != 0);
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
            boolean varEC80EFD4DF567B9D250862B3673CD334_1369424483 = ((data.readInt() != 0));
            testName = new ComponentName(data);
            testName = null;
            String profileName;
            profileName = data.readString();
            ParcelFileDescriptor profileFd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_987506148 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_429078200 = (data.readInt() != 0);
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
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1723368063 = (data.readInt() != 0);
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
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_18210639 = (super.onTransact(code, data, reply, flags));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.810 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "1992535F0C7EB8757F965477F5292EC0")
    @DSModeled(DSC.SAFE)
    public IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
}

class ApplicationThreadProxy implements IApplicationThread {
    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.810 -0400", hash_original_method = "08B50EC8A0FF95C7A679215C14C2E347", hash_generated_method = "E837CC355437C8BA2643DCCDF24EA539")
    @DSModeled(DSC.SAFE)
    public ApplicationThreadProxy(IBinder remote) {
        dsTaint.addTaint(remote.dsTaint);
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.811 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "25ECE4C55933283AC17DBE78468103BD")
    @DSModeled(DSC.SAFE)
    public final IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.811 -0400", hash_original_method = "F385294CE3D6AC21F25405F7E688DF1E", hash_generated_method = "3E37872AB83795C3DAFEDDFD9EDBF385")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void schedulePauseActivity(IBinder token, boolean finished,
            boolean userLeaving, int configChanges) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(configChanges);
        dsTaint.addTaint(userLeaving);
        dsTaint.addTaint(finished);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.812 -0400", hash_original_method = "8D9A120B7A56CEA8B7726147C17D07B9", hash_generated_method = "5756120AFE565D967AD52953A44261F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleStopActivity(IBinder token, boolean showWindow,
            int configChanges) throws RemoteException {
        dsTaint.addTaint(showWindow);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(configChanges);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.813 -0400", hash_original_method = "5CD7B361184ED9060554C6A3DFD958DC", hash_generated_method = "87F2286E225BAAF57A2555A28DE1B162")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleWindowVisibility(IBinder token,
            boolean showWindow) throws RemoteException {
        dsTaint.addTaint(showWindow);
        dsTaint.addTaint(token.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.813 -0400", hash_original_method = "037CA20E3B4BFBAB7FFA0954AEB6461B", hash_generated_method = "84EE20B145D8F569FE77789DDD6711FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleSleeping(IBinder token,
            boolean sleeping) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(sleeping);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.814 -0400", hash_original_method = "3B8EDF2F01C1C03EA4B1D6DE44BA40A1", hash_generated_method = "B72D4B55615AECC7C0AC7FC37ED76415")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleResumeActivity(IBinder token, boolean isForward) throws RemoteException {
        dsTaint.addTaint(isForward);
        dsTaint.addTaint(token.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.815 -0400", hash_original_method = "DF66BA9A5FFE4BEC7C06F9E22C0B5667", hash_generated_method = "AFBD273C773AF3BED98BDF3EF9420376")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleSendResult(IBinder token, List<ResultInfo> results) throws RemoteException {
        dsTaint.addTaint(results.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.816 -0400", hash_original_method = "F26C51AD11E848270AE4A9EC525A0958", hash_generated_method = "E433191BCE91EE171AD2B6E81D02477D")
    @DSModeled(DSC.SPEC)
    public final void scheduleLaunchActivity(Intent intent, IBinder token, int ident,
            ActivityInfo info, Configuration curConfig, CompatibilityInfo compatInfo,
            Bundle state, List<ResultInfo> pendingResults,
    		List<Intent> pendingNewIntents, boolean notResumed, boolean isForward,
    		String profileName, ParcelFileDescriptor profileFd, boolean autoStopProfiler) throws RemoteException {
        dsTaint.addTaint(notResumed);
        dsTaint.addTaint(curConfig.dsTaint);
        dsTaint.addTaint(compatInfo.dsTaint);
        dsTaint.addTaint(ident);
        dsTaint.addTaint(isForward);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(pendingResults.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        dsTaint.addTaint(autoStopProfiler);
        dsTaint.addTaint(profileFd.dsTaint);
        dsTaint.addTaint(profileName);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(pendingNewIntents.dsTaint);
        dsTaint.addTaint(info.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.817 -0400", hash_original_method = "D28E37482E7B0F4E96EA5389499C167D", hash_generated_method = "3CB96DD65B50D9C6F1FE06F18C44AAE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleRelaunchActivity(IBinder token,
            List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
            int configChanges, boolean notResumed, Configuration config) throws RemoteException {
        dsTaint.addTaint(notResumed);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(pendingResults.dsTaint);
        dsTaint.addTaint(configChanges);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(pendingNewIntents.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.817 -0400", hash_original_method = "C9991D806FA54B06B2907086AD0FF677", hash_generated_method = "E163F27146F9E1B394889C256EFC91E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleNewIntent(List<Intent> intents, IBinder token) throws RemoteException {
        dsTaint.addTaint(intents.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.818 -0400", hash_original_method = "30A44B425A4D374BA87F220BE9EBE9B7", hash_generated_method = "275EF86A9758E6476588B0475EF6F0B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleDestroyActivity(IBinder token, boolean finishing,
            int configChanges) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(configChanges);
        dsTaint.addTaint(finishing);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.819 -0400", hash_original_method = "C42B70805B0C7922B26FF1FB8A47345A", hash_generated_method = "6F02A3070F374973D7BACBE77B64BC2A")
    @DSModeled(DSC.SPEC)
    public final void scheduleReceiver(Intent intent, ActivityInfo info,
            CompatibilityInfo compatInfo, int resultCode, String resultData,
            Bundle map, boolean sync) throws RemoteException {
        dsTaint.addTaint(resultData);
        dsTaint.addTaint(compatInfo.dsTaint);
        dsTaint.addTaint(sync);
        dsTaint.addTaint(map.dsTaint);
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(info.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.822 -0400", hash_original_method = "FBCEE90A351EFB6AE922D66BDA990D49", hash_generated_method = "48F4FFA49BD8C81A9FCA6E7CD7DA01BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleCreateBackupAgent(ApplicationInfo app,
            CompatibilityInfo compatInfo, int backupMode) throws RemoteException {
        dsTaint.addTaint(backupMode);
        dsTaint.addTaint(app.dsTaint);
        dsTaint.addTaint(compatInfo.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.823 -0400", hash_original_method = "213DB620D8FBF1A9C8341DE04CE19BA9", hash_generated_method = "162719EB2FE66BD441817C68E43F6C4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleDestroyBackupAgent(ApplicationInfo app,
            CompatibilityInfo compatInfo) throws RemoteException {
        dsTaint.addTaint(app.dsTaint);
        dsTaint.addTaint(compatInfo.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.824 -0400", hash_original_method = "6404222A540CAF1DD9DE4C2FFFFCFFEA", hash_generated_method = "DB0762410FEAA00A578C5EEA70E44DCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleCreateService(IBinder token, ServiceInfo info,
            CompatibilityInfo compatInfo) throws RemoteException {
        dsTaint.addTaint(compatInfo.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(info.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.826 -0400", hash_original_method = "B7457DD503BA4FDF2022DE2BEF8A4AE7", hash_generated_method = "965003B8BE4E67D05A80074DC841CEBF")
    @DSModeled(DSC.SPEC)
    public final void scheduleBindService(IBinder token, Intent intent, boolean rebind) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(rebind);
        dsTaint.addTaint(intent.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.829 -0400", hash_original_method = "015A697DF0B7313A5A91440BE749BA70", hash_generated_method = "C68FF0FE3C7C51154EED155BD8949BC9")
    @DSModeled(DSC.SPEC)
    public final void scheduleUnbindService(IBinder token, Intent intent) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.829 -0400", hash_original_method = "9440CDA1B00A67ECA4131E9DDBFF94BE", hash_generated_method = "112B42BC7C9B4BF81C86F4A10947CDF1")
    @DSModeled(DSC.SPEC)
    public final void scheduleServiceArgs(IBinder token, boolean taskRemoved, int startId,
	    int flags, Intent args) throws RemoteException {
        dsTaint.addTaint(startId);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(taskRemoved);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.838 -0400", hash_original_method = "C0CB5C15E3301223B23F08D2A5944F63", hash_generated_method = "1FF7D6028BA0683D2D503B26E8567C63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleStopService(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.840 -0400", hash_original_method = "4BEF103D5873B276CD3FCACF31B60747", hash_generated_method = "43BCEBC41A86A29FB49FC085E9ECAD81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void bindApplication(String packageName, ApplicationInfo info,
            List<ProviderInfo> providers, ComponentName testName, String profileName,
            ParcelFileDescriptor profileFd, boolean autoStopProfiler, Bundle testArgs,
            IInstrumentationWatcher testWatcher, int debugMode, boolean restrictedBackupMode,
            boolean persistent, Configuration config, CompatibilityInfo compatInfo,
            Map<String, IBinder> services, Bundle coreSettings) throws RemoteException {
        dsTaint.addTaint(services.dsTaint);
        dsTaint.addTaint(debugMode);
        dsTaint.addTaint(testName.dsTaint);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(autoStopProfiler);
        dsTaint.addTaint(info.dsTaint);
        dsTaint.addTaint(coreSettings.dsTaint);
        dsTaint.addTaint(testArgs.dsTaint);
        dsTaint.addTaint(compatInfo.dsTaint);
        dsTaint.addTaint(providers.dsTaint);
        dsTaint.addTaint(persistent);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(profileFd.dsTaint);
        dsTaint.addTaint(restrictedBackupMode);
        dsTaint.addTaint(profileName);
        dsTaint.addTaint(testWatcher.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.840 -0400", hash_original_method = "D9B97B2B196869DD6997DE8F0F3DB6A8", hash_generated_method = "3069EAE3488EC6B0F0DC7701D240A0DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.841 -0400", hash_original_method = "54C10BB1160F71CB1C13A86830E02D00", hash_generated_method = "CC8A74317DC5E1E5321A4037CD5C6720")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.842 -0400", hash_original_method = "D665A0E549B16E7CA815762264938E1F", hash_generated_method = "D7CA1D7D716E24194B89535A5E388733")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void requestThumbnail(IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.843 -0400", hash_original_method = "2C1AC44E23EDB2D99649E68F5C228686", hash_generated_method = "7BE71C532B480C0F054BDDEFE94FE19B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleConfigurationChanged(Configuration config) throws RemoteException {
        dsTaint.addTaint(config.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.843 -0400", hash_original_method = "0B9C0FCD5E0F49B1C57B4B2960062787", hash_generated_method = "384C253EEF05A262784ED17AD5066B57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.844 -0400", hash_original_method = "2659A1DE78848CD92C8786506E83B52E", hash_generated_method = "DA4BDED71A3E2A79C17A0A5011B4FE45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.848 -0400", hash_original_method = "B79CFB3A109E11AF1583EBEB0497855B", hash_generated_method = "F721F6E94BCF7E8EE09C012429847D9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHttpProxy(String proxy, String port, String exclList) throws RemoteException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(exclList);
        dsTaint.addTaint(proxy);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.852 -0400", hash_original_method = "3372F7AC9E7DAF2A573613018E648B58", hash_generated_method = "5DC4EFD08626DBC5E06CAFB30682D23B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.853 -0400", hash_original_method = "E161C2DD10689877C1DFEA4F44C5B49B", hash_generated_method = "0511461034F956C338E12C00DE40E251")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpService(FileDescriptor fd, IBinder token, String[] args) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.853 -0400", hash_original_method = "D0D9D13B7AFC8143680190DFDB1E27B8", hash_generated_method = "B52755CE36D6662A9C951F51A8D5A2EE")
    @DSModeled(DSC.SPEC)
    public void scheduleRegisteredReceiver(IIntentReceiver receiver, Intent intent,
            int resultCode, String dataStr, Bundle extras, boolean ordered, boolean sticky) throws RemoteException {
        dsTaint.addTaint(sticky);
        dsTaint.addTaint(dataStr);
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(ordered);
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(extras.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.854 -0400", hash_original_method = "9B139EEAA8537BD0FDDE5F0ABD5B2BE9", hash_generated_method = "A6DD7BF9D65F73640FB1F621F809CC3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.854 -0400", hash_original_method = "17DBD33C1569C467FA5E9849A4B7DAA5", hash_generated_method = "8024FF7B2C77CF20B67EC4E1F9AE312A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scheduleActivityConfigurationChanged(
            IBinder token) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.855 -0400", hash_original_method = "727EEF540008C4D098D698BFCF8CD3C2", hash_generated_method = "A2CA9B5FB9AD78ECAF0B8F4AC26AFC61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void profilerControl(boolean start, String path,
            ParcelFileDescriptor fd, int profileType) throws RemoteException {
        dsTaint.addTaint(profileType);
        dsTaint.addTaint(start);
        dsTaint.addTaint(path);
        dsTaint.addTaint(fd.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.856 -0400", hash_original_method = "732323D2FE13A948B7BB2E76176A6F90", hash_generated_method = "272F6C5F13828120D130E7521E25EE1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSchedulingGroup(int group) throws RemoteException {
        dsTaint.addTaint(group);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.856 -0400", hash_original_method = "307083C9D45C8404399A6967BFC677B1", hash_generated_method = "0F2290334573065A4BF04F61AC2C025E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getMemoryInfo(Debug.MemoryInfo outInfo) throws RemoteException {
        dsTaint.addTaint(outInfo.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.857 -0400", hash_original_method = "ACFC9FA9BBB19958DCB9CD2CDA3432BC", hash_generated_method = "299D8D036854FD3C4329EDFD84F047B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchPackageBroadcast(int cmd, String[] packages) throws RemoteException {
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(packages[0]);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.857 -0400", hash_original_method = "0DA34150FDE2C37709AA14FDDE4D7856", hash_generated_method = "0E4A5067E5735EE4A760CC5472144FA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleCrash(String msg) throws RemoteException {
        dsTaint.addTaint(msg);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.858 -0400", hash_original_method = "14C0866A00E3EF07677471FCFBE5006D", hash_generated_method = "0FA32D92D594A5BFABD6D379AF4B214B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpHeap(boolean managed, String path,
            ParcelFileDescriptor fd) throws RemoteException {
        dsTaint.addTaint(managed);
        dsTaint.addTaint(path);
        dsTaint.addTaint(fd.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.859 -0400", hash_original_method = "7214E8ED977AF65264275D69BD7546BC", hash_generated_method = "11E450D3929D69764E0278C4FF62A819")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpActivity(FileDescriptor fd, IBinder token, String prefix, String[] args) throws RemoteException {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(fd.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.859 -0400", hash_original_method = "A6BD18E7AC0ECE0599305450F757BFCE", hash_generated_method = "FE0953E48001AD28A5338179AC58785B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCoreSettings(Bundle coreSettings) throws RemoteException {
        dsTaint.addTaint(coreSettings.dsTaint);
        Parcel data;
        data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeBundle(coreSettings);
        mRemote.transact(SET_CORE_SETTINGS_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //data.writeInterfaceToken(IApplicationThread.descriptor);
        //data.writeBundle(coreSettings);
        //mRemote.transact(SET_CORE_SETTINGS_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.860 -0400", hash_original_method = "D2FA44681587FB29A159697C062E818E", hash_generated_method = "015F6DCC71DF82069E4549534569FDCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updatePackageCompatibilityInfo(String pkg, CompatibilityInfo info) throws RemoteException {
        dsTaint.addTaint(pkg);
        dsTaint.addTaint(info.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.860 -0400", hash_original_method = "2D27841853A53E2CEBF025C44DD03509", hash_generated_method = "82DDFDBB153531B02AD3EB41CFC3653D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleTrimMemory(int level) throws RemoteException {
        dsTaint.addTaint(level);
        Parcel data;
        data = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.861 -0400", hash_original_method = "2FCBBED71EEEC4941D4B92155F73ADA0", hash_generated_method = "671A2729F35AB34362CE3C2987451CA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Debug.MemoryInfo dumpMemInfo(FileDescriptor fd, boolean checkin, boolean all,
            String[] args) throws RemoteException {
        dsTaint.addTaint(checkin);
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(all);
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
        return (Debug.MemoryInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.861 -0400", hash_original_method = "A649B6B1FE51F3F8AC43A3FCCC575DB3", hash_generated_method = "77D9C32583269FF68BF9404F138F1E74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpGfxInfo(FileDescriptor fd, String[] args) throws RemoteException {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        Parcel data;
        data = Parcel.obtain();
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

