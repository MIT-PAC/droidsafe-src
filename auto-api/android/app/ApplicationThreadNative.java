package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.752 -0400", hash_original_method = "94F554AA12869316A649B35CDD2C48B7", hash_generated_method = "7133F8D8ECAF77EA1D7A82265BA8BB74")
    public  ApplicationThreadNative() {
        attachInterface(this, descriptor);
        
        
    }

    
    @DSModeled(DSC.SAFE)
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.760 -0400", hash_original_method = "B17DF3ED953946DC6FB6C3E82DF1C3B7", hash_generated_method = "B4019B509C59ACC2298BC61107EF4649")
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean finished = data.readInt() != 0;
            boolean userLeaving = data.readInt() != 0;
            int configChanges = data.readInt();
            schedulePauseActivity(b, finished, userLeaving, configChanges);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean show = data.readInt() != 0;
            int configChanges = data.readInt();
            scheduleStopActivity(b, show, configChanges);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean show = data.readInt() != 0;
            scheduleWindowVisibility(b, show);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean sleeping = data.readInt() != 0;
            scheduleSleeping(b, sleeping);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean isForward = data.readInt() != 0;
            scheduleResumeActivity(b, isForward);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            List<ResultInfo> ri = data.createTypedArrayList(ResultInfo.CREATOR);
            scheduleSendResult(b, ri);
        } 
        
        
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
            ParcelFileDescriptor profileFd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1184957203 = (data.readInt() != 0);
            profileFd = data.readFileDescriptor();
            profileFd = null;
            boolean autoStopProfiler = data.readInt() != 0;
            scheduleLaunchActivity(intent, b, ident, info, curConfig, compatInfo, state, ri, pi,
                    notResumed, isForward, profileName, profileFd, autoStopProfiler);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            List<ResultInfo> ri = data.createTypedArrayList(ResultInfo.CREATOR);
            List<Intent> pi = data.createTypedArrayList(Intent.CREATOR);
            int configChanges = data.readInt();
            boolean notResumed = data.readInt() != 0;
            Configuration config = null;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_116318221 = (data.readInt() != 0);
                {
                    config = Configuration.CREATOR.createFromParcel(data);
                } 
            } 
            scheduleRelaunchActivity(b, ri, pi, configChanges, notResumed, config);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            List<Intent> pi = data.createTypedArrayList(Intent.CREATOR);
            IBinder b = data.readStrongBinder();
            scheduleNewIntent(pi, b);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean finishing = data.readInt() != 0;
            int configChanges = data.readInt();
            scheduleDestroyActivity(b, finishing, configChanges);
        } 
        
        
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
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            ServiceInfo info = ServiceInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            scheduleCreateService(token, info, compatInfo);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            boolean rebind = data.readInt() != 0;
            scheduleBindService(token, intent, rebind);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            scheduleUnbindService(token, intent);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            boolean taskRemoved = data.readInt() != 0;
            int startId = data.readInt();
            int fl = data.readInt();
            Intent args;
            {
                boolean varE6AB5F2F920478433EF302793CCFF01F_402947325 = (data.readInt() != 0);
                {
                    args = Intent.CREATOR.createFromParcel(data);
                } 
                {
                    args = null;
                } 
            } 
            scheduleServiceArgs(token, taskRemoved, startId, fl, args);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            scheduleStopService(token);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String packageName = data.readString();
            ApplicationInfo info = ApplicationInfo.CREATOR.createFromParcel(data);
            List<ProviderInfo> providers = data.createTypedArrayList(ProviderInfo.CREATOR);
            ComponentName testName;
            boolean varEC80EFD4DF567B9D250862B3673CD334_106885963 = ((data.readInt() != 0));
            testName = new ComponentName(data);
            testName = null;
            String profileName = data.readString();
            ParcelFileDescriptor profileFd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_316683973 = (data.readInt() != 0);
            profileFd = data.readFileDescriptor();
            profileFd = null;
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
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            scheduleExit();
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            scheduleSuicide();
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            requestThumbnail(b);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            scheduleConfigurationChanged(config);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            updateTimeZone();
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            clearDnsCache();
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            final String proxy = data.readString();
            final String port = data.readString();
            final String exclList = data.readString();
            setHttpProxy(proxy, port, exclList);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            processInBackground();
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            final IBinder service = data.readStrongBinder();
            final String[] args = data.readStringArray();
            {
                dumpService(fd.getFileDescriptor(), service, args);
                try 
                {
                    fd.close();
                } 
                catch (IOException e)
                { }
            } 
        } 
        
        
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
        } 
        
        
        {
            scheduleLowMemory();
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            scheduleActivityConfigurationChanged(b);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            boolean start = data.readInt() != 0;
            int profileType = data.readInt();
            String path = data.readString();
            ParcelFileDescriptor fd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_587451741 = (data.readInt() != 0);
            fd = data.readFileDescriptor();
            fd = null;
            profilerControl(start, path, fd, profileType);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            int group = data.readInt();
            setSchedulingGroup(group);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ApplicationInfo appInfo = ApplicationInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            int backupMode = data.readInt();
            scheduleCreateBackupAgent(appInfo, compatInfo, backupMode);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ApplicationInfo appInfo = ApplicationInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            scheduleDestroyBackupAgent(appInfo, compatInfo);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Debug.MemoryInfo mi = new Debug.MemoryInfo();
            getMemoryInfo(mi);
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            int cmd = data.readInt();
            String[] packages = data.readStringArray();
            dispatchPackageBroadcast(cmd, packages);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String msg = data.readString();
            scheduleCrash(msg);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            boolean managed = data.readInt() != 0;
            String path = data.readString();
            ParcelFileDescriptor fd;
            boolean varC24E3AE203992FDEC0DEADDC729AF4C8_1185861272 = (data.readInt() != 0);
            fd = data.readFileDescriptor();
            fd = null;
            dumpHeap(managed, path, fd);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            final IBinder activity = data.readStrongBinder();
            final String prefix = data.readString();
            final String[] args = data.readStringArray();
            {
                dumpActivity(fd.getFileDescriptor(), activity, prefix, args);
                try 
                {
                    fd.close();
                } 
                catch (IOException e)
                { }
            } 
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Bundle settings = data.readBundle();
            setCoreSettings(settings);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String pkg = data.readString();
            CompatibilityInfo compat = CompatibilityInfo.CREATOR.createFromParcel(data);
            updatePackageCompatibilityInfo(pkg, compat);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            int level = data.readInt();
            scheduleTrimMemory(level);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            boolean checkin = data.readInt() != 0;
            boolean all = data.readInt() != 0;
            String[] args = data.readStringArray();
            Debug.MemoryInfo mi = null;
            {
                try 
                {
                    mi = dumpMemInfo(fd.getFileDescriptor(), checkin, all, args);
                } 
                finally 
                {
                    try 
                    {
                        fd.close();
                    } 
                    catch (IOException e)
                    { }
                } 
            } 
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
        } 
        
        
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            String[] args = data.readStringArray();
            {
                try 
                {
                    dumpGfxInfo(fd.getFileDescriptor(), args);
                } 
                finally 
                {
                    try 
                    {
                        fd.close();
                    } 
                    catch (IOException e)
                    { }
                } 
            } 
            reply.writeNoException();
        } 
        
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_1103183037 = (super.onTransact(code, data, reply, flags));
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1615930134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1615930134;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.762 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "069E73B4A3A930A0DFC2B45765E420F5")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1644475366 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1644475366 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1644475366.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1644475366;
        
        
    }

    
}

class ApplicationThreadProxy implements IApplicationThread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.762 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.763 -0400", hash_original_method = "08B50EC8A0FF95C7A679215C14C2E347", hash_generated_method = "07C34BD386C4B1EE3B5CAAFB7C484EE0")
    public  ApplicationThreadProxy(IBinder remote) {
        mRemote = remote;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.763 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "1B5AD51A7F27E710411A432EC4B7F735")
    public final IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_179649588 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_179649588 = mRemote;
        varB4EAC82CA7396A68D541C85D26508E83_179649588.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_179649588;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.764 -0400", hash_original_method = "F385294CE3D6AC21F25405F7E688DF1E", hash_generated_method = "B2F4F0E154A1BEE2F3425C3AC514D75F")
    public final void schedulePauseActivity(IBinder token, boolean finished,
            boolean userLeaving, int configChanges) throws RemoteException {
        Parcel data = Parcel.obtain();
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
        
        
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.765 -0400", hash_original_method = "8D9A120B7A56CEA8B7726147C17D07B9", hash_generated_method = "F82204BE19454696F7FD0492292110DE")
    public final void scheduleStopActivity(IBinder token, boolean showWindow,
            int configChanges) throws RemoteException {
        Parcel data = Parcel.obtain();
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
        
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.766 -0400", hash_original_method = "5CD7B361184ED9060554C6A3DFD958DC", hash_generated_method = "EEBDFF07D62BB83525E749A6BE953A1A")
    public final void scheduleWindowVisibility(IBinder token,
            boolean showWindow) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(showWindow ? 1 : 0);
        mRemote.transact(SCHEDULE_WINDOW_VISIBILITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(showWindow);
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.767 -0400", hash_original_method = "037CA20E3B4BFBAB7FFA0954AEB6461B", hash_generated_method = "204FAD00584AE74CCB663E33B24F13F2")
    public final void scheduleSleeping(IBinder token,
            boolean sleeping) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(sleeping ? 1 : 0);
        mRemote.transact(SCHEDULE_SLEEPING_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(sleeping);
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.768 -0400", hash_original_method = "3B8EDF2F01C1C03EA4B1D6DE44BA40A1", hash_generated_method = "4BCACC2E1973C7E0E18AFF005D9E9F1B")
    public final void scheduleResumeActivity(IBinder token, boolean isForward) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(isForward ? 1 : 0);
        mRemote.transact(SCHEDULE_RESUME_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(isForward);
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.769 -0400", hash_original_method = "DF66BA9A5FFE4BEC7C06F9E22C0B5667", hash_generated_method = "861C97207ACE35D095752FE165120511")
    public final void scheduleSendResult(IBinder token, List<ResultInfo> results) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeTypedList(results);
        mRemote.transact(SCHEDULE_SEND_RESULT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(results.getTaint());
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.770 -0400", hash_original_method = "F26C51AD11E848270AE4A9EC525A0958", hash_generated_method = "4F37766B98F9E6363FFDEE46EA282D64")
    public final void scheduleLaunchActivity(Intent intent, IBinder token, int ident,
            ActivityInfo info, Configuration curConfig, CompatibilityInfo compatInfo,
            Bundle state, List<ResultInfo> pendingResults,
    		List<Intent> pendingNewIntents, boolean notResumed, boolean isForward,
    		String profileName, ParcelFileDescriptor profileFd, boolean autoStopProfiler) throws RemoteException {
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
        {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } 
        {
            data.writeInt(0);
        } 
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
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.771 -0400", hash_original_method = "D28E37482E7B0F4E96EA5389499C167D", hash_generated_method = "AAF070B1C44ED8D1CD20727DA8C68782")
    public final void scheduleRelaunchActivity(IBinder token,
            List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
            int configChanges, boolean notResumed, Configuration config) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeTypedList(pendingResults);
        data.writeTypedList(pendingNewIntents);
        data.writeInt(configChanges);
        data.writeInt(notResumed ? 1 : 0);
        {
            data.writeInt(1);
            config.writeToParcel(data, 0);
        } 
        {
            data.writeInt(0);
        } 
        mRemote.transact(SCHEDULE_RELAUNCH_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(pendingResults.getTaint());
        addTaint(pendingNewIntents.getTaint());
        addTaint(configChanges);
        addTaint(notResumed);
        addTaint(config.getTaint());
        
        
        
        
        
        
        
        
        
            
            
        
            
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.772 -0400", hash_original_method = "C9991D806FA54B06B2907086AD0FF677", hash_generated_method = "EE8412561DA4E5F45E665D5AA27F0B57")
    public void scheduleNewIntent(List<Intent> intents, IBinder token) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeTypedList(intents);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_NEW_INTENT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(intents.getTaint());
        addTaint(token.getTaint());
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.772 -0400", hash_original_method = "30A44B425A4D374BA87F220BE9EBE9B7", hash_generated_method = "6DA440D5D4F4FBA445090AA30F58FF2B")
    public final void scheduleDestroyActivity(IBinder token, boolean finishing,
            int configChanges) throws RemoteException {
        Parcel data = Parcel.obtain();
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
        
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.773 -0400", hash_original_method = "C42B70805B0C7922B26FF1FB8A47345A", hash_generated_method = "3D2D6611EB88C4866CF9E04667B580A7")
    public final void scheduleReceiver(Intent intent, ActivityInfo info,
            CompatibilityInfo compatInfo, int resultCode, String resultData,
            Bundle map, boolean sync) throws RemoteException {
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
        addTaint(intent.getTaint());
        addTaint(info.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(resultCode);
        addTaint(resultData.getTaint());
        addTaint(map.getTaint());
        addTaint(sync);
        
        
        
        
        
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.774 -0400", hash_original_method = "FBCEE90A351EFB6AE922D66BDA990D49", hash_generated_method = "E517FA6FE709AAB3971BE39600607B3C")
    public final void scheduleCreateBackupAgent(ApplicationInfo app,
            CompatibilityInfo compatInfo, int backupMode) throws RemoteException {
        Parcel data = Parcel.obtain();
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
        
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.775 -0400", hash_original_method = "213DB620D8FBF1A9C8341DE04CE19BA9", hash_generated_method = "11A8BE22407B26C597EBD86FFDF07CB5")
    public final void scheduleDestroyBackupAgent(ApplicationInfo app,
            CompatibilityInfo compatInfo) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        app.writeToParcel(data, 0);
        compatInfo.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_DESTROY_BACKUP_AGENT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(app.getTaint());
        addTaint(compatInfo.getTaint());
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.777 -0400", hash_original_method = "6404222A540CAF1DD9DE4C2FFFFCFFEA", hash_generated_method = "64407F2D9CEB7B4317170B4289A9ECFA")
    public final void scheduleCreateService(IBinder token, ServiceInfo info,
            CompatibilityInfo compatInfo) throws RemoteException {
        Parcel data = Parcel.obtain();
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
        
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.778 -0400", hash_original_method = "B7457DD503BA4FDF2022DE2BEF8A4AE7", hash_generated_method = "819509129148F06358770DD2D0B3C6A2")
    public final void scheduleBindService(IBinder token, Intent intent, boolean rebind) throws RemoteException {
        Parcel data = Parcel.obtain();
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
        
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.780 -0400", hash_original_method = "015A697DF0B7313A5A91440BE749BA70", hash_generated_method = "52B50F7F61C1F8F5479ED49AF78B226D")
    public final void scheduleUnbindService(IBinder token, Intent intent) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        intent.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_UNBIND_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(intent.getTaint());
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.781 -0400", hash_original_method = "9440CDA1B00A67ECA4131E9DDBFF94BE", hash_generated_method = "1B739BDE52D1CFE498EF2583BE15C0BB")
    public final void scheduleServiceArgs(IBinder token, boolean taskRemoved, int startId,
	    int flags, Intent args) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(taskRemoved ? 1 : 0);
        data.writeInt(startId);
        data.writeInt(flags);
        {
            data.writeInt(1);
            args.writeToParcel(data, 0);
        } 
        {
            data.writeInt(0);
        } 
        mRemote.transact(SCHEDULE_SERVICE_ARGS_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        addTaint(taskRemoved);
        addTaint(startId);
        addTaint(flags);
        addTaint(args.getTaint());
        
        
        
        
        
        
        
        
            
            
        
            
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.782 -0400", hash_original_method = "C0CB5C15E3301223B23F08D2A5944F63", hash_generated_method = "F82AE8BF6FD7C25DD616CEDCAF66A258")
    public final void scheduleStopService(IBinder token) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_STOP_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.783 -0400", hash_original_method = "4BEF103D5873B276CD3FCACF31B60747", hash_generated_method = "4C1A2313F37B2BF2003CEDEC509A0A30")
    public final void bindApplication(String packageName, ApplicationInfo info,
            List<ProviderInfo> providers, ComponentName testName, String profileName,
            ParcelFileDescriptor profileFd, boolean autoStopProfiler, Bundle testArgs,
            IInstrumentationWatcher testWatcher, int debugMode, boolean restrictedBackupMode,
            boolean persistent, Configuration config, CompatibilityInfo compatInfo,
            Map<String, IBinder> services, Bundle coreSettings) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(packageName);
        info.writeToParcel(data, 0);
        data.writeTypedList(providers);
        {
            data.writeInt(0);
        } 
        {
            data.writeInt(1);
            testName.writeToParcel(data, 0);
        } 
        data.writeString(profileName);
        {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } 
        {
            data.writeInt(0);
        } 
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
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.784 -0400", hash_original_method = "D9B97B2B196869DD6997DE8F0F3DB6A8", hash_generated_method = "D3CA0846FF06D3C9E5630604634D4BA2")
    public final void scheduleExit() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(SCHEDULE_EXIT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.784 -0400", hash_original_method = "54C10BB1160F71CB1C13A86830E02D00", hash_generated_method = "ED81A5C888EDD342E66C9265348D4DAE")
    public final void scheduleSuicide() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(SCHEDULE_SUICIDE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.786 -0400", hash_original_method = "D665A0E549B16E7CA815762264938E1F", hash_generated_method = "D8F30CA7367A0BD974A8A16E8DFC50C0")
    public final void requestThumbnail(IBinder token) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(REQUEST_THUMBNAIL_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.788 -0400", hash_original_method = "2C1AC44E23EDB2D99649E68F5C228686", hash_generated_method = "F724ABC177FFDCD0B491D6C7E0CC9A66")
    public final void scheduleConfigurationChanged(Configuration config) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        config.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(config.getTaint());
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.789 -0400", hash_original_method = "0B9C0FCD5E0F49B1C57B4B2960062787", hash_generated_method = "6B4EB282B8034AF6B04F5C786CE621E6")
    public void updateTimeZone() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(UPDATE_TIME_ZONE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.790 -0400", hash_original_method = "2659A1DE78848CD92C8786506E83B52E", hash_generated_method = "AD8A78BD18783AC3E3C75CF71B2022A5")
    public void clearDnsCache() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(CLEAR_DNS_CACHE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.791 -0400", hash_original_method = "B79CFB3A109E11AF1583EBEB0497855B", hash_generated_method = "9FE673409FC4B198911E62546D21E1C7")
    public void setHttpProxy(String proxy, String port, String exclList) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(proxy);
        data.writeString(port);
        data.writeString(exclList);
        mRemote.transact(SET_HTTP_PROXY_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(proxy.getTaint());
        addTaint(port.getTaint());
        addTaint(exclList.getTaint());
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.792 -0400", hash_original_method = "3372F7AC9E7DAF2A573613018E648B58", hash_generated_method = "AD3B0C88626F3F67EB69C259E2505999")
    public void processInBackground() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(PROCESS_IN_BACKGROUND_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.793 -0400", hash_original_method = "E161C2DD10689877C1DFEA4F44C5B49B", hash_generated_method = "7B092769461EA37C9EFCB237238DC5E7")
    public void dumpService(FileDescriptor fd, IBinder token, String[] args) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeStrongBinder(token);
        data.writeStringArray(args);
        mRemote.transact(DUMP_SERVICE_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(fd.getTaint());
        addTaint(token.getTaint());
        addTaint(args[0].getTaint());
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.793 -0400", hash_original_method = "D0D9D13B7AFC8143680190DFDB1E27B8", hash_generated_method = "5271FC8C1B6C7866F3684082FB8E5315")
    public void scheduleRegisteredReceiver(IIntentReceiver receiver, Intent intent,
            int resultCode, String dataStr, Bundle extras, boolean ordered, boolean sticky) throws RemoteException {
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
        addTaint(receiver.getTaint());
        addTaint(intent.getTaint());
        addTaint(resultCode);
        addTaint(dataStr.getTaint());
        addTaint(extras.getTaint());
        addTaint(ordered);
        addTaint(sticky);
        
        
        
        
        
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.794 -0400", hash_original_method = "9B139EEAA8537BD0FDDE5F0ABD5B2BE9", hash_generated_method = "29EF77959C49CF075B7080F4F56A9E01")
    public final void scheduleLowMemory() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(SCHEDULE_LOW_MEMORY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.794 -0400", hash_original_method = "17DBD33C1569C467FA5E9849A4B7DAA5", hash_generated_method = "5B71C9EB512B9EFD6D1B4AEE56881AF7")
    public final void scheduleActivityConfigurationChanged(
            IBinder token) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_ACTIVITY_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(token.getTaint());
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.795 -0400", hash_original_method = "727EEF540008C4D098D698BFCF8CD3C2", hash_generated_method = "C07A2B2CCDB5F184B250F59918020071")
    public void profilerControl(boolean start, String path,
            ParcelFileDescriptor fd, int profileType) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(start ? 1 : 0);
        data.writeInt(profileType);
        data.writeString(path);
        {
            data.writeInt(1);
            fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } 
        {
            data.writeInt(0);
        } 
        mRemote.transact(PROFILER_CONTROL_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(start);
        addTaint(path.getTaint());
        addTaint(fd.getTaint());
        addTaint(profileType);
        
        
        
        
        
        
        
            
            
        
            
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.796 -0400", hash_original_method = "732323D2FE13A948B7BB2E76176A6F90", hash_generated_method = "8028DA9537E3B2A4614AED69287AE226")
    public void setSchedulingGroup(int group) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(group);
        mRemote.transact(SET_SCHEDULING_GROUP_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(group);
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.797 -0400", hash_original_method = "307083C9D45C8404399A6967BFC677B1", hash_generated_method = "FC9CCA302C062F736268F33C762ADD1F")
    public void getMemoryInfo(Debug.MemoryInfo outInfo) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(GET_MEMORY_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        outInfo.readFromParcel(reply);
        data.recycle();
        reply.recycle();
        addTaint(outInfo.getTaint());
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.798 -0400", hash_original_method = "ACFC9FA9BBB19958DCB9CD2CDA3432BC", hash_generated_method = "1FB1A184B4C3EA8EFA7114C3FAC11C6B")
    public void dispatchPackageBroadcast(int cmd, String[] packages) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(cmd);
        data.writeStringArray(packages);
        mRemote.transact(DISPATCH_PACKAGE_BROADCAST_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(cmd);
        addTaint(packages[0].getTaint());
        
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.800 -0400", hash_original_method = "0DA34150FDE2C37709AA14FDDE4D7856", hash_generated_method = "31D45A3FB826AF56D3C044715F9A2664")
    public void scheduleCrash(String msg) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(msg);
        mRemote.transact(SCHEDULE_CRASH_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(msg.getTaint());
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.802 -0400", hash_original_method = "14C0866A00E3EF07677471FCFBE5006D", hash_generated_method = "8BEC3FD143A3BA9B6C8CE7228C2AC7C6")
    public void dumpHeap(boolean managed, String path,
            ParcelFileDescriptor fd) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(managed ? 1 : 0);
        data.writeString(path);
        {
            data.writeInt(1);
            fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } 
        {
            data.writeInt(0);
        } 
        mRemote.transact(DUMP_HEAP_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(managed);
        addTaint(path.getTaint());
        addTaint(fd.getTaint());
        
        
        
        
        
        
            
            
        
            
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.802 -0400", hash_original_method = "7214E8ED977AF65264275D69BD7546BC", hash_generated_method = "976987F32F736C080E9988FA3D21F0BA")
    public void dumpActivity(FileDescriptor fd, IBinder token, String prefix, String[] args) throws RemoteException {
        Parcel data = Parcel.obtain();
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
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.803 -0400", hash_original_method = "A6BD18E7AC0ECE0599305450F757BFCE", hash_generated_method = "2B65180338B161359E80CA68098BF9A8")
    public void setCoreSettings(Bundle coreSettings) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeBundle(coreSettings);
        mRemote.transact(SET_CORE_SETTINGS_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        addTaint(coreSettings.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.804 -0400", hash_original_method = "D2FA44681587FB29A159697C062E818E", hash_generated_method = "EC315C8C8D10ABC7BDB5BB64D5BA91DA")
    public void updatePackageCompatibilityInfo(String pkg, CompatibilityInfo info) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(pkg);
        info.writeToParcel(data, 0);
        mRemote.transact(UPDATE_PACKAGE_COMPATIBILITY_INFO_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        addTaint(pkg.getTaint());
        addTaint(info.getTaint());
        
        
        
        
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.804 -0400", hash_original_method = "2D27841853A53E2CEBF025C44DD03509", hash_generated_method = "92564B7879036DEA01F45CC5A39E5565")
    public void scheduleTrimMemory(int level) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(level);
        mRemote.transact(SCHEDULE_TRIM_MEMORY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        addTaint(level);
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.805 -0400", hash_original_method = "2FCBBED71EEEC4941D4B92155F73ADA0", hash_generated_method = "D19EF2C4CF7D7F1F85AE89C7C994B3DD")
    public Debug.MemoryInfo dumpMemInfo(FileDescriptor fd, boolean checkin, boolean all,
            String[] args) throws RemoteException {
        Debug.MemoryInfo varB4EAC82CA7396A68D541C85D26508E83_749266962 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_749266962 = info;
        addTaint(fd.getTaint());
        addTaint(checkin);
        addTaint(all);
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_749266962.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_749266962;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.806 -0400", hash_original_method = "A649B6B1FE51F3F8AC43A3FCCC575DB3", hash_generated_method = "02992B79B01F6B08E498AAE9DB042DE6")
    public void dumpGfxInfo(FileDescriptor fd, String[] args) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeStringArray(args);
        mRemote.transact(DUMP_GFX_INFO_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
        addTaint(fd.getTaint());
        addTaint(args[0].getTaint());
        
        
        
        
        
        
        
    }

    
}

