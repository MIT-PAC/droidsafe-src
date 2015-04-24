/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ComponentName;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.Debug;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;

public abstract class ApplicationThreadNative extends Binder implements IApplicationThread {
    /**
     * Cast a Binder object into an application thread interface, generating
     * a proxy if needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.927 -0500", hash_original_method = "17488503592C6659F091CE1A79A12BD0", hash_generated_method = "C72B4B66FE340E977D3EB25CDE7A551B")
    
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
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.930 -0500", hash_original_method = "94F554AA12869316A649B35CDD2C48B7", hash_generated_method = "9A0122931DF548A22EFD5BF8230ADA42")
    
public ApplicationThreadNative() {
        attachInterface(this, descriptor);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.942 -0500", hash_original_method = "B17DF3ED953946DC6FB6C3E82DF1C3B7", hash_generated_method = "6DCB879D2EBBA74EF430AE5BD6A63908")
    
@Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
            throws RemoteException {
        switch (code) {
        case SCHEDULE_PAUSE_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean finished = data.readInt() != 0;
            boolean userLeaving = data.readInt() != 0;
            int configChanges = data.readInt();
            schedulePauseActivity(b, finished, userLeaving, configChanges);
            return true;
        }

        case SCHEDULE_STOP_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean show = data.readInt() != 0;
            int configChanges = data.readInt();
            scheduleStopActivity(b, show, configChanges);
            return true;
        }
        
        case SCHEDULE_WINDOW_VISIBILITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean show = data.readInt() != 0;
            scheduleWindowVisibility(b, show);
            return true;
        }

        case SCHEDULE_SLEEPING_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean sleeping = data.readInt() != 0;
            scheduleSleeping(b, sleeping);
            return true;
        }

        case SCHEDULE_RESUME_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean isForward = data.readInt() != 0;
            scheduleResumeActivity(b, isForward);
            return true;
        }
        
        case SCHEDULE_SEND_RESULT_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            List<ResultInfo> ri = data.createTypedArrayList(ResultInfo.CREATOR);
            scheduleSendResult(b, ri);
            return true;
        }
        
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
            return true;
        }
        
        case SCHEDULE_RELAUNCH_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            List<ResultInfo> ri = data.createTypedArrayList(ResultInfo.CREATOR);
            List<Intent> pi = data.createTypedArrayList(Intent.CREATOR);
            int configChanges = data.readInt();
            boolean notResumed = data.readInt() != 0;
            Configuration config = null;
            if (data.readInt() != 0) {
                config = Configuration.CREATOR.createFromParcel(data);
            }
            scheduleRelaunchActivity(b, ri, pi, configChanges, notResumed, config);
            return true;
        }
        
        case SCHEDULE_NEW_INTENT_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            List<Intent> pi = data.createTypedArrayList(Intent.CREATOR);
            IBinder b = data.readStrongBinder();
            scheduleNewIntent(pi, b);
            return true;
        }

        case SCHEDULE_FINISH_ACTIVITY_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            boolean finishing = data.readInt() != 0;
            int configChanges = data.readInt();
            scheduleDestroyActivity(b, finishing, configChanges);
            return true;
        }
        
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
            return true;
        }

        case SCHEDULE_CREATE_SERVICE_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            ServiceInfo info = ServiceInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            scheduleCreateService(token, info, compatInfo);
            return true;
        }

        case SCHEDULE_BIND_SERVICE_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            boolean rebind = data.readInt() != 0;
            scheduleBindService(token, intent, rebind);
            return true;
        }

        case SCHEDULE_UNBIND_SERVICE_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            Intent intent = Intent.CREATOR.createFromParcel(data);
            scheduleUnbindService(token, intent);
            return true;
        }

        case SCHEDULE_SERVICE_ARGS_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            boolean taskRemoved = data.readInt() != 0;
            int startId = data.readInt();
            int fl = data.readInt();
            Intent args;
            if (data.readInt() != 0) {
                args = Intent.CREATOR.createFromParcel(data);
            } else {
                args = null;
            }
            scheduleServiceArgs(token, taskRemoved, startId, fl, args);
            return true;
        }

        case SCHEDULE_STOP_SERVICE_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder token = data.readStrongBinder();
            scheduleStopService(token);
            return true;
        }

        case BIND_APPLICATION_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String packageName = data.readString();
            ApplicationInfo info =
                ApplicationInfo.CREATOR.createFromParcel(data);
            List<ProviderInfo> providers =
                data.createTypedArrayList(ProviderInfo.CREATOR);
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
            return true;
        }
        
        case SCHEDULE_EXIT_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            scheduleExit();
            return true;
        }

        case SCHEDULE_SUICIDE_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            scheduleSuicide();
            return true;
        }

        case REQUEST_THUMBNAIL_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            requestThumbnail(b);
            return true;
        }

        case SCHEDULE_CONFIGURATION_CHANGED_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Configuration config = Configuration.CREATOR.createFromParcel(data);
            scheduleConfigurationChanged(config);
            return true;
        }

        case UPDATE_TIME_ZONE_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            updateTimeZone();
            return true;
        }

        case CLEAR_DNS_CACHE_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            clearDnsCache();
            return true;
        }

        case SET_HTTP_PROXY_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            final String proxy = data.readString();
            final String port = data.readString();
            final String exclList = data.readString();
            setHttpProxy(proxy, port, exclList);
            return true;
        }

        case PROCESS_IN_BACKGROUND_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            processInBackground();
            return true;
        }

        case DUMP_SERVICE_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            final IBinder service = data.readStrongBinder();
            final String[] args = data.readStringArray();
            if (fd != null) {
                dumpService(fd.getFileDescriptor(), service, args);
                try {
                    fd.close();
                } catch (IOException e) {
                }
            }
            return true;
        }
        
        case SCHEDULE_REGISTERED_RECEIVER_TRANSACTION: {
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
            return true;
        }

        case SCHEDULE_LOW_MEMORY_TRANSACTION:
        {
            scheduleLowMemory();
            return true;
        }
        
        case SCHEDULE_ACTIVITY_CONFIGURATION_CHANGED_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            IBinder b = data.readStrongBinder();
            scheduleActivityConfigurationChanged(b);
            return true;
        }
        
        case PROFILER_CONTROL_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            boolean start = data.readInt() != 0;
            int profileType = data.readInt();
            String path = data.readString();
            ParcelFileDescriptor fd = data.readInt() != 0
                    ? data.readFileDescriptor() : null;
            profilerControl(start, path, fd, profileType);
            return true;
        }
        
        case SET_SCHEDULING_GROUP_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            int group = data.readInt();
            setSchedulingGroup(group);
            return true;
        }

        case SCHEDULE_CREATE_BACKUP_AGENT_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ApplicationInfo appInfo = ApplicationInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            int backupMode = data.readInt();
            scheduleCreateBackupAgent(appInfo, compatInfo, backupMode);
            return true;
        }

        case SCHEDULE_DESTROY_BACKUP_AGENT_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ApplicationInfo appInfo = ApplicationInfo.CREATOR.createFromParcel(data);
            CompatibilityInfo compatInfo = CompatibilityInfo.CREATOR.createFromParcel(data);
            scheduleDestroyBackupAgent(appInfo, compatInfo);
            return true;
        }

        case GET_MEMORY_INFO_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            Debug.MemoryInfo mi = new Debug.MemoryInfo();
            getMemoryInfo(mi);
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
            return true;
        }

        case DISPATCH_PACKAGE_BROADCAST_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            int cmd = data.readInt();
            String[] packages = data.readStringArray();
            dispatchPackageBroadcast(cmd, packages);
            return true;
        }

        case SCHEDULE_CRASH_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            String msg = data.readString();
            scheduleCrash(msg);
            return true;
        }

        case DUMP_HEAP_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            boolean managed = data.readInt() != 0;
            String path = data.readString();
            ParcelFileDescriptor fd = data.readInt() != 0
                    ? data.readFileDescriptor() : null;
            dumpHeap(managed, path, fd);
            return true;
        }

        case DUMP_ACTIVITY_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            final IBinder activity = data.readStrongBinder();
            final String prefix = data.readString();
            final String[] args = data.readStringArray();
            if (fd != null) {
                dumpActivity(fd.getFileDescriptor(), activity, prefix, args);
                try {
                    fd.close();
                } catch (IOException e) {
                }
            }
            return true;
        }

        case SET_CORE_SETTINGS_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            Bundle settings = data.readBundle();
            setCoreSettings(settings);
            return true;
        }

        case UPDATE_PACKAGE_COMPATIBILITY_INFO_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            String pkg = data.readString();
            CompatibilityInfo compat = CompatibilityInfo.CREATOR.createFromParcel(data);
            updatePackageCompatibilityInfo(pkg, compat);
            return true;
        }

        case SCHEDULE_TRIM_MEMORY_TRANSACTION: {
            data.enforceInterface(IApplicationThread.descriptor);
            int level = data.readInt();
            scheduleTrimMemory(level);
            return true;
        }

        case DUMP_MEM_INFO_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            boolean checkin = data.readInt() != 0;
            boolean all = data.readInt() != 0;
            String[] args = data.readStringArray();
            Debug.MemoryInfo mi = null;
            if (fd != null) {
                try {
                    mi = dumpMemInfo(fd.getFileDescriptor(), checkin, all, args);
                } finally {
                    try {
                        fd.close();
                    } catch (IOException e) {
                        // swallowed, not propagated back to the caller
                    }
                }
            }
            reply.writeNoException();
            mi.writeToParcel(reply, 0);
            return true;
        }

        case DUMP_GFX_INFO_TRANSACTION:
        {
            data.enforceInterface(IApplicationThread.descriptor);
            ParcelFileDescriptor fd = data.readFileDescriptor();
            String[] args = data.readStringArray();
            if (fd != null) {
                try {
                    dumpGfxInfo(fd.getFileDescriptor(), args);
                } finally {
                    try {
                        fd.close();
                    } catch (IOException e) {
                        // swallowed, not propagated back to the caller
                    }
                }
            }
            reply.writeNoException();
            return true;
        }
        }

        return super.onTransact(code, data, reply, flags);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.945 -0500", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "5E3B69CCD103133228ACADBBDEF1CE7E")
    
public IBinder asBinder()
    {
        return this;
    }
    
}

class ApplicationThreadProxy implements IApplicationThread {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.948 -0500", hash_original_field = "5AE257E0853836D9B54E1EF6497B909F", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private  IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.950 -0500", hash_original_method = "08B50EC8A0FF95C7A679215C14C2E347", hash_generated_method = "3B68CF7B4A084058DEBCEE5707CF9550")
    
public ApplicationThreadProxy(IBinder remote) {
        mRemote = remote;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.952 -0500", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "1C034C9EF1188D622E292B288F350D1B")
    
public final IBinder asBinder() {
        return mRemote;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.954 -0500", hash_original_method = "F385294CE3D6AC21F25405F7E688DF1E", hash_generated_method = "CBF0A1AFB674AE5BA1CA1826E5AE2835")
    
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
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.957 -0500", hash_original_method = "8D9A120B7A56CEA8B7726147C17D07B9", hash_generated_method = "0A9533EA0293AAF82BB79426513B0A81")
    
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
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.959 -0500", hash_original_method = "5CD7B361184ED9060554C6A3DFD958DC", hash_generated_method = "B5DEEDBF6FA66341DEF01C3AF443B80A")
    
public final void scheduleWindowVisibility(IBinder token,
            boolean showWindow) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(showWindow ? 1 : 0);
        mRemote.transact(SCHEDULE_WINDOW_VISIBILITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.962 -0500", hash_original_method = "037CA20E3B4BFBAB7FFA0954AEB6461B", hash_generated_method = "DF373665954C0746BD82B703AF1D6917")
    
public final void scheduleSleeping(IBinder token,
            boolean sleeping) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(sleeping ? 1 : 0);
        mRemote.transact(SCHEDULE_SLEEPING_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.964 -0500", hash_original_method = "3B8EDF2F01C1C03EA4B1D6DE44BA40A1", hash_generated_method = "CD10572F94195DA5F8791AE33358E55F")
    
public final void scheduleResumeActivity(IBinder token, boolean isForward)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(isForward ? 1 : 0);
        mRemote.transact(SCHEDULE_RESUME_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.967 -0500", hash_original_method = "DF66BA9A5FFE4BEC7C06F9E22C0B5667", hash_generated_method = "33D4E89A4A541307DD512AE7B9D63EAE")
    
public final void scheduleSendResult(IBinder token, List<ResultInfo> results)
    		throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeTypedList(results);
        mRemote.transact(SCHEDULE_SEND_RESULT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.971 -0500", hash_original_method = "F26C51AD11E848270AE4A9EC525A0958", hash_generated_method = "EBE2EF8167D55CABDD7812FD682B2E45")
    
public final void scheduleLaunchActivity(Intent intent, IBinder token, int ident,
            ActivityInfo info, Configuration curConfig, CompatibilityInfo compatInfo,
            Bundle state, List<ResultInfo> pendingResults,
    		List<Intent> pendingNewIntents, boolean notResumed, boolean isForward,
    		String profileName, ParcelFileDescriptor profileFd, boolean autoStopProfiler)
    		throws RemoteException {
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
        if (profileFd != null) {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } else {
            data.writeInt(0);
        }
        data.writeInt(autoStopProfiler ? 1 : 0);
        mRemote.transact(SCHEDULE_LAUNCH_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.973 -0500", hash_original_method = "D28E37482E7B0F4E96EA5389499C167D", hash_generated_method = "8AF685184D06475E9309CB8D931EEBF9")
    
public final void scheduleRelaunchActivity(IBinder token,
            List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
            int configChanges, boolean notResumed, Configuration config)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeTypedList(pendingResults);
        data.writeTypedList(pendingNewIntents);
        data.writeInt(configChanges);
        data.writeInt(notResumed ? 1 : 0);
        if (config != null) {
            data.writeInt(1);
            config.writeToParcel(data, 0);
        } else {
            data.writeInt(0);
        }
        mRemote.transact(SCHEDULE_RELAUNCH_ACTIVITY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.976 -0500", hash_original_method = "C9991D806FA54B06B2907086AD0FF677", hash_generated_method = "3CCF467753F3966284C8520DFAC2C903")
    
public void scheduleNewIntent(List<Intent> intents, IBinder token)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeTypedList(intents);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_NEW_INTENT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.978 -0500", hash_original_method = "30A44B425A4D374BA87F220BE9EBE9B7", hash_generated_method = "7C10FF8E99432EB62A17B52FDB771AEE")
    
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
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.981 -0500", hash_original_method = "C42B70805B0C7922B26FF1FB8A47345A", hash_generated_method = "7228C0A8C4F23FAB9A04CD30CDF46BC8")
    
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
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.983 -0500", hash_original_method = "FBCEE90A351EFB6AE922D66BDA990D49", hash_generated_method = "645091E863567C7A8F794C896EC31910")
    
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.985 -0500", hash_original_method = "213DB620D8FBF1A9C8341DE04CE19BA9", hash_generated_method = "D2452E6BB27908AB4552791EAFEDCD19")
    
public final void scheduleDestroyBackupAgent(ApplicationInfo app,
            CompatibilityInfo compatInfo) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        app.writeToParcel(data, 0);
        compatInfo.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_DESTROY_BACKUP_AGENT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.988 -0500", hash_original_method = "6404222A540CAF1DD9DE4C2FFFFCFFEA", hash_generated_method = "04ABC0E9B46B2AD2BF42A8B660CBC355")
    
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
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.991 -0500", hash_original_method = "B7457DD503BA4FDF2022DE2BEF8A4AE7", hash_generated_method = "26BEC1CEA392937A526B3E1AD93184AD")
    
public final void scheduleBindService(IBinder token, Intent intent, boolean rebind)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        intent.writeToParcel(data, 0);
        data.writeInt(rebind ? 1 : 0);
        mRemote.transact(SCHEDULE_BIND_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.993 -0500", hash_original_method = "015A697DF0B7313A5A91440BE749BA70", hash_generated_method = "5C06BFA5B54D2BC16CF66E108F7A6091")
    
public final void scheduleUnbindService(IBinder token, Intent intent)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        intent.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_UNBIND_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.996 -0500", hash_original_method = "9440CDA1B00A67ECA4131E9DDBFF94BE", hash_generated_method = "C80BF5F302BC309D95DE0391EB3DEA3B")
    
public final void scheduleServiceArgs(IBinder token, boolean taskRemoved, int startId,
	    int flags, Intent args) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        data.writeInt(taskRemoved ? 1 : 0);
        data.writeInt(startId);
        data.writeInt(flags);
        if (args != null) {
            data.writeInt(1);
            args.writeToParcel(data, 0);
        } else {
            data.writeInt(0);
        }
        mRemote.transact(SCHEDULE_SERVICE_ARGS_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:32.998 -0500", hash_original_method = "C0CB5C15E3301223B23F08D2A5944F63", hash_generated_method = "FA8FFAA1903B1AAAD650ADB275F3799E")
    
public final void scheduleStopService(IBinder token)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_STOP_SERVICE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.001 -0500", hash_original_method = "4BEF103D5873B276CD3FCACF31B60747", hash_generated_method = "A6C5CECF298A4DE9F8C3B7E0DCC43BD7")
    
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
        if (testName == null) {
            data.writeInt(0);
        } else {
            data.writeInt(1);
            testName.writeToParcel(data, 0);
        }
        data.writeString(profileName);
        if (profileFd != null) {
            data.writeInt(1);
            profileFd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } else {
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
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.003 -0500", hash_original_method = "D9B97B2B196869DD6997DE8F0F3DB6A8", hash_generated_method = "BA150D214AD2FC6BC65969D419362297")
    
public final void scheduleExit() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(SCHEDULE_EXIT_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.006 -0500", hash_original_method = "54C10BB1160F71CB1C13A86830E02D00", hash_generated_method = "32AAABE0D2C206F38735E2EE723F4C70")
    
public final void scheduleSuicide() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(SCHEDULE_SUICIDE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.008 -0500", hash_original_method = "D665A0E549B16E7CA815762264938E1F", hash_generated_method = "0326CC7D3D96DEDBCD74512EA57668DF")
    
public final void requestThumbnail(IBinder token)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(REQUEST_THUMBNAIL_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.011 -0500", hash_original_method = "2C1AC44E23EDB2D99649E68F5C228686", hash_generated_method = "B23E0DAB23F0568D6B1C2A5ECD60C3AB")
    
public final void scheduleConfigurationChanged(Configuration config)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        config.writeToParcel(data, 0);
        mRemote.transact(SCHEDULE_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.013 -0500", hash_original_method = "0B9C0FCD5E0F49B1C57B4B2960062787", hash_generated_method = "7AB9CA5BD169FB933A3BF55C49697A91")
    
public void updateTimeZone() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(UPDATE_TIME_ZONE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.015 -0500", hash_original_method = "2659A1DE78848CD92C8786506E83B52E", hash_generated_method = "02C84CE53143317E1FEC0269D3AF811F")
    
public void clearDnsCache() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(CLEAR_DNS_CACHE_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.017 -0500", hash_original_method = "B79CFB3A109E11AF1583EBEB0497855B", hash_generated_method = "ACAE0709FAB9A7B1C4FA7A24E51F242B")
    
public void setHttpProxy(String proxy, String port, String exclList) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(proxy);
        data.writeString(port);
        data.writeString(exclList);
        mRemote.transact(SET_HTTP_PROXY_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.020 -0500", hash_original_method = "3372F7AC9E7DAF2A573613018E648B58", hash_generated_method = "B927F861243FE72931954624F5BC6E70")
    
public void processInBackground() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(PROCESS_IN_BACKGROUND_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.022 -0500", hash_original_method = "E161C2DD10689877C1DFEA4F44C5B49B", hash_generated_method = "874F1D2DCBFF80A10B2F0F45B0FF183F")
    
public void dumpService(FileDescriptor fd, IBinder token, String[] args)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeStrongBinder(token);
        data.writeStringArray(args);
        mRemote.transact(DUMP_SERVICE_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.024 -0500", hash_original_method = "D0D9D13B7AFC8143680190DFDB1E27B8", hash_generated_method = "7E21B40C2DF13A52F364085591CD1D28")
    
public void scheduleRegisteredReceiver(IIntentReceiver receiver, Intent intent,
            int resultCode, String dataStr, Bundle extras, boolean ordered, boolean sticky)
            throws RemoteException {
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.027 -0500", hash_original_method = "9B139EEAA8537BD0FDDE5F0ABD5B2BE9", hash_generated_method = "7A13411A4871013BADB2B3FBF83818BE")
    
public final void scheduleLowMemory() throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(SCHEDULE_LOW_MEMORY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.030 -0500", hash_original_method = "17DBD33C1569C467FA5E9849A4B7DAA5", hash_generated_method = "668A5DB86925B19AC1DE4B9A49D27346")
    
public final void scheduleActivityConfigurationChanged(
            IBinder token) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeStrongBinder(token);
        mRemote.transact(SCHEDULE_ACTIVITY_CONFIGURATION_CHANGED_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.032 -0500", hash_original_method = "727EEF540008C4D098D698BFCF8CD3C2", hash_generated_method = "047BC902781895D8A6398BFA6B3534BA")
    
public void profilerControl(boolean start, String path,
            ParcelFileDescriptor fd, int profileType) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(start ? 1 : 0);
        data.writeInt(profileType);
        data.writeString(path);
        if (fd != null) {
            data.writeInt(1);
            fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } else {
            data.writeInt(0);
        }
        mRemote.transact(PROFILER_CONTROL_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.034 -0500", hash_original_method = "732323D2FE13A948B7BB2E76176A6F90", hash_generated_method = "9BFFA9D36155A3CF53FFA3E8588A53F2")
    
public void setSchedulingGroup(int group) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(group);
        mRemote.transact(SET_SCHEDULING_GROUP_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.037 -0500", hash_original_method = "307083C9D45C8404399A6967BFC677B1", hash_generated_method = "41893BFE254FD4D1327E8390CDCF1E0C")
    
public void getMemoryInfo(Debug.MemoryInfo outInfo) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        mRemote.transact(GET_MEMORY_INFO_TRANSACTION, data, reply, 0);
        reply.readException();
        outInfo.readFromParcel(reply);
        data.recycle();
        reply.recycle();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.039 -0500", hash_original_method = "ACFC9FA9BBB19958DCB9CD2CDA3432BC", hash_generated_method = "9F13079B67E1B340A910C2841C5A58D9")
    
public void dispatchPackageBroadcast(int cmd, String[] packages) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(cmd);
        data.writeStringArray(packages);
        mRemote.transact(DISPATCH_PACKAGE_BROADCAST_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.041 -0500", hash_original_method = "0DA34150FDE2C37709AA14FDDE4D7856", hash_generated_method = "F1B656A08AFA9BD1E791AEB210967BBF")
    
public void scheduleCrash(String msg) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(msg);
        mRemote.transact(SCHEDULE_CRASH_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
        
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.043 -0500", hash_original_method = "14C0866A00E3EF07677471FCFBE5006D", hash_generated_method = "7C23DB5F40EDFC3138299924DC08C338")
    
public void dumpHeap(boolean managed, String path,
            ParcelFileDescriptor fd) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(managed ? 1 : 0);
        data.writeString(path);
        if (fd != null) {
            data.writeInt(1);
            fd.writeToParcel(data, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        } else {
            data.writeInt(0);
        }
        mRemote.transact(DUMP_HEAP_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.045 -0500", hash_original_method = "7214E8ED977AF65264275D69BD7546BC", hash_generated_method = "C1AE6E651A598938A33575C23A351361")
    
public void dumpActivity(FileDescriptor fd, IBinder token, String prefix, String[] args)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeStrongBinder(token);
        data.writeString(prefix);
        data.writeStringArray(args);
        mRemote.transact(DUMP_ACTIVITY_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.048 -0500", hash_original_method = "A6BD18E7AC0ECE0599305450F757BFCE", hash_generated_method = "3DE2C4A7538826C2FD90ABB22B8B6B1D")
    
public void setCoreSettings(Bundle coreSettings) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeBundle(coreSettings);
        mRemote.transact(SET_CORE_SETTINGS_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.050 -0500", hash_original_method = "D2FA44681587FB29A159697C062E818E", hash_generated_method = "0A1BF5EC6EA1F3BA65EE3CF9CDFBEEB7")
    
public void updatePackageCompatibilityInfo(String pkg, CompatibilityInfo info)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeString(pkg);
        info.writeToParcel(data, 0);
        mRemote.transact(UPDATE_PACKAGE_COMPATIBILITY_INFO_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.053 -0500", hash_original_method = "2D27841853A53E2CEBF025C44DD03509", hash_generated_method = "DFC13A93B430963CDA63C0FB28972FDC")
    
public void scheduleTrimMemory(int level) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeInt(level);
        mRemote.transact(SCHEDULE_TRIM_MEMORY_TRANSACTION, data, null,
                IBinder.FLAG_ONEWAY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.055 -0500", hash_original_method = "2FCBBED71EEEC4941D4B92155F73ADA0", hash_generated_method = "6D983E4C1BC7E0CC8BB8DB1DFDCCDC55")
    
public Debug.MemoryInfo dumpMemInfo(FileDescriptor fd, boolean checkin, boolean all,
            String[] args) throws RemoteException {
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
        return info;
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:33.057 -0500", hash_original_method = "A649B6B1FE51F3F8AC43A3FCCC575DB3", hash_generated_method = "FADE2085EA0A408B02D104A90E30C3BF")
    
public void dumpGfxInfo(FileDescriptor fd, String[] args) throws RemoteException {
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken(IApplicationThread.descriptor);
        data.writeFileDescriptor(fd);
        data.writeStringArray(args);
        mRemote.transact(DUMP_GFX_INFO_TRANSACTION, data, null, IBinder.FLAG_ONEWAY);
        data.recycle();
    }
    
}

