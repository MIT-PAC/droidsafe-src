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
 * Copyright (C) 2009 The Android Open Source Project
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


package android.content;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * An abstract implementation of a SyncAdapter that spawns a thread to invoke a sync operation.
 * If a sync operation is already in progress when a startSync() request is received then an error
 * will be returned to the new request and the existing request will be allowed to continue.
 * When a startSync() is received and there is no sync operation in progress then a thread
 * will be started to run the operation and {@link #onPerformSync} will be invoked on that thread.
 * If a cancelSync() is received that matches an existing sync operation then the thread
 * that is running that sync operation will be interrupted, which will indicate to the thread
 * that the sync has been canceled.
 * <p>
 * In order to be a sync adapter one must extend this class, provide implementations for the
 * abstract methods and write a service that returns the result of {@link #getSyncAdapterBinder()}
 * in the service's {@link android.app.Service#onBind(android.content.Intent)} when invoked
 * with an intent with action <code>android.content.SyncAdapter</code>. This service
 * must specify the following intent filter and metadata tags in its AndroidManifest.xml file
 * <pre>
 *   &lt;intent-filter&gt;
 *     &lt;action android:name="android.content.SyncAdapter" /&gt;
 *   &lt;/intent-filter&gt;
 *   &lt;meta-data android:name="android.content.SyncAdapter"
 *             android:resource="@xml/syncadapter" /&gt;
 * </pre>
 * The <code>android:resource</code> attribute must point to a resource that looks like:
 * <pre>
 * &lt;sync-adapter xmlns:android="http://schemas.android.com/apk/res/android"
 *    android:contentAuthority="authority"
 *    android:accountType="accountType"
 *    android:userVisible="true|false"
 *    android:supportsUploading="true|false"
 *    android:allowParallelSyncs="true|false"
 *    android:isAlwaysSyncable="true|false"
 *    android:syncAdapterSettingsAction="ACTION_OF_SETTINGS_ACTIVITY"
 * /&gt;
 * </pre>
 * <ul>
 * <li>The <code>android:contentAuthority</code> and <code>android:accountType</code> attributes
 * indicate which content authority and for which account types this sync adapter serves.
 * <li><code>android:userVisible</code> defaults to true and controls whether or not this sync
 * adapter shows up in the Sync Settings screen.
 * <li><code>android:supportsUploading</code> defaults
 * to true and if true an upload-only sync will be requested for all syncadapters associated
 * with an authority whenever that authority's content provider does a
 * {@link ContentResolver#notifyChange(android.net.Uri, android.database.ContentObserver, boolean)}
 * with syncToNetwork set to true.
 * <li><code>android:allowParallelSyncs</code> defaults to false and if true indicates that
 * the sync adapter can handle syncs for multiple accounts at the same time. Otherwise
 * the SyncManager will wait until the sync adapter is not in use before requesting that
 * it sync an account's data.
 * <li><code>android:isAlwaysSyncable</code> defaults to false and if true tells the SyncManager
 * to intialize the isSyncable state to 1 for that sync adapter for each account that is added.
 * <li><code>android:syncAdapterSettingsAction</code> defaults to null and if supplied it
 * specifies an Intent action of an activity that can be used to adjust the sync adapter's
 * sync settings. The activity must live in the same package as the sync adapter.
 * </ul>
 */
public abstract class AbstractThreadedSyncAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:24.922 -0500", hash_original_field = "786A2F05C0B1145DF1C5ECC56EE3B61B", hash_generated_field = "66B61517DC41E89C039BAA85B5D7F970")

    @Deprecated
    public static final int LOG_SYNC_DETAILS = 2743;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:24.930 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:24.937 -0500", hash_original_field = "B5E26A376DDD6AEE960E73FA0C1CC33B", hash_generated_field = "E469CB20573479E19F7B525A34AEE3F2")

    private  AtomicInteger mNumSyncStarts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:24.944 -0500", hash_original_field = "865EDB3C59D7E78F958C9295A951BB76", hash_generated_field = "6FEE57D1816AB33D5B2193626892DD23")

    private  ISyncAdapterImpl mISyncAdapterImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:24.951 -0500", hash_original_field = "8C5F6784AD58C4EC3B2FD8F2F7D6F004", hash_generated_field = "10B7297A67678299CA81296D51E1CDD8")

    private final HashMap<Account, SyncThread> mSyncThreads = new HashMap<Account, SyncThread>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:24.969 -0500", hash_original_field = "D0C585D1A36D9B3D744CCD87538727C1", hash_generated_field = "75CE356D43F16C1371A07169D4BD11BA")

    private final Object mSyncThreadLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:24.975 -0500", hash_original_field = "7E1C76C6C239F4DED0509B47BB84C766", hash_generated_field = "9FFD2424694212F6CF4E275A6CF0DB9A")

    private  boolean mAutoInitialize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:24.980 -0500", hash_original_field = "01C9D2CC407C127F4BD877E2814FF997", hash_generated_field = "118BCFBDD128360CF08E0A9CC5608B42")

    private boolean mAllowParallelSyncs;

    /**
     * Creates an {@link AbstractThreadedSyncAdapter}.
     * @param context the {@link android.content.Context} that this is running within.
     * @param autoInitialize if true then sync requests that have
     * {@link ContentResolver#SYNC_EXTRAS_INITIALIZE} set will be internally handled by
     * {@link AbstractThreadedSyncAdapter} by calling
     * {@link ContentResolver#setIsSyncable(android.accounts.Account, String, int)} with 1 if it
     * is currently set to <0.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:24.988 -0500", hash_original_method = "B865BB2D1334DC45D9907C5CC59DE93A", hash_generated_method = "6F60CC8F6C97ECA45EF4C65835D19D25")
    @DSComment("Constructor: inaction")
    @DSSafe(DSCat.SAFE_OTHERS)

public AbstractThreadedSyncAdapter(Context context, boolean autoInitialize) {
        this(context, autoInitialize, false /* allowParallelSyncs */);
    }

    /**
     * Creates an {@link AbstractThreadedSyncAdapter}.
     * @param context the {@link android.content.Context} that this is running within.
     * @param autoInitialize if true then sync requests that have
     * {@link ContentResolver#SYNC_EXTRAS_INITIALIZE} set will be internally handled by
     * {@link AbstractThreadedSyncAdapter} by calling
     * {@link ContentResolver#setIsSyncable(android.accounts.Account, String, int)} with 1 if it
     * is currently set to <0.
     * @param allowParallelSyncs if true then allow syncs for different accounts to run
     * at the same time, each in their own thread. This must be consistent with the setting
     * in the SyncAdapter's configuration file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:24.998 -0500", hash_original_method = "5CA02CE85005DB7A14B35230E54E7132", hash_generated_method = "F58FA8B7A3144C23EE0DCDD403E6D704")
    @DSComment("Constructor: inaction")
    @DSSafe(DSCat.SAFE_OTHERS)

public AbstractThreadedSyncAdapter(Context context,
            boolean autoInitialize, boolean allowParallelSyncs) {
        mContext = context;
        mISyncAdapterImpl = new ISyncAdapterImpl();
        mNumSyncStarts = new AtomicInteger(0);
        mAutoInitialize = autoInitialize;
        mAllowParallelSyncs = allowParallelSyncs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.003 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BA026F6873AF9B17E96AB49AFB6CEE03")
    
public Context getContext() {
        return mContext;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.010 -0500", hash_original_method = "790F4AB6D952C2DA3921D17668FD582E", hash_generated_method = "46A5FCCF36424A0E610B95C516BA24B0")
    
private Account toSyncKey(Account account) {
        if (mAllowParallelSyncs) {
            return account;
        } else {
            return null;
        }
    }

    private class ISyncAdapterImpl extends ISyncAdapter.Stub {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.030 -0500", hash_original_method = "38845D382FD352E7E7131C94C60DC4DC", hash_generated_method = "449DEE24A30BB79525F246A6DFBEF423")
        
public void startSync(ISyncContext syncContext, String authority, Account account,
                Bundle extras) {
            final SyncContext syncContextClient = new SyncContext(syncContext);

            boolean alreadyInProgress;
            // synchronize to make sure that mSyncThreads doesn't change between when we
            // check it and when we use it
            final Account threadsKey = toSyncKey(account);
            synchronized (mSyncThreadLock) {
                if (!mSyncThreads.containsKey(threadsKey)) {
                    if (mAutoInitialize
                            && extras != null
                            && extras.getBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, false)) {
                        if (ContentResolver.getIsSyncable(account, authority) < 0) {
                            ContentResolver.setIsSyncable(account, authority, 1);
                        }
                        syncContextClient.onFinished(new SyncResult());
                        return;
                    }
                    SyncThread syncThread = new SyncThread(
                            "SyncAdapterThread-" + mNumSyncStarts.incrementAndGet(),
                            syncContextClient, authority, account, extras);
                    mSyncThreads.put(threadsKey, syncThread);
                    syncThread.start();
                    alreadyInProgress = false;
                } else {
                    alreadyInProgress = true;
                }
            }

            // do this outside since we don't want to call back into the syncContext while
            // holding the synchronization lock
            if (alreadyInProgress) {
                syncContextClient.onFinished(SyncResult.ALREADY_IN_PROGRESS);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.042 -0500", hash_original_method = "D8E22288236DCBDF1105EA85EC77E122", hash_generated_method = "ED668307EF586483FD8AE348577B8192")
        
public void cancelSync(ISyncContext syncContext) {
            // synchronize to make sure that mSyncThreads doesn't change between when we
            // check it and when we use it
            SyncThread info = null;
            synchronized (mSyncThreadLock) {
                for (SyncThread current : mSyncThreads.values()) {
                    if (current.mSyncContext.getSyncContextBinder() == syncContext.asBinder()) {
                        info = current;
                        break;
                    }
                }
            }
            if (info != null) {
                if (mAllowParallelSyncs) {
                    onSyncCanceled(info);
                } else {
                    onSyncCanceled();
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.049 -0500", hash_original_method = "2FD2C581F125A3E58387BAD4F7701DFE", hash_generated_method = "3B22073679A2D50B8E46D51FCF3CA303")
        
public void initialize(Account account, String authority) throws RemoteException {
            Bundle extras = new Bundle();
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, true);
            startSync(null, authority, account, extras);
        }
    }

    /**
     * The thread that invokes {@link AbstractThreadedSyncAdapter#onPerformSync}. It also acquires
     * the provider for this sync before calling onPerformSync and releases it afterwards. Cancel
     * this thread in order to cancel the sync.
     */
    private class SyncThread extends Thread {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.081 -0500", hash_original_field = "9390F95E99DE4862A1E51CE40DD18585", hash_generated_field = "9FE436C2A63CF88151D65A6766ECF9E9")

        private  SyncContext mSyncContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.088 -0500", hash_original_field = "BC4522E788A053F96319766AEE95ACCB", hash_generated_field = "5E9A5C7D075BBF710B4D594B2F64B868")

        private  String mAuthority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.094 -0500", hash_original_field = "77E70EE964F6B49E35EDB9210610AC8E", hash_generated_field = "3B055C3859C53A8ACDFC59C6C8440DF8")

        private  Account mAccount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.099 -0500", hash_original_field = "8E33C9E28D87B1286C4160446ABF7B5C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

        private  Bundle mExtras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.105 -0500", hash_original_field = "0DE6774E9E1C8122EC14CD78E02E6364", hash_generated_field = "547D73961C6CD85EA6E1D18A34D39621")

        private  Account mThreadsKey;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.112 -0500", hash_original_method = "EF8D05995E0E8B5EB798D0CE2C473FF0", hash_generated_method = "2BB57A876C02C4807E65EB806C42F7E0")
        
private SyncThread(String name, SyncContext syncContext, String authority,
                Account account, Bundle extras) {
            super(name);
            mSyncContext = syncContext;
            mAuthority = authority;
            mAccount = account;
            mExtras = extras;
            mThreadsKey = toSyncKey(account);
        }

        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.121 -0500", hash_original_method = "4CA3DD716A0BD73ED7F0FD0D54F60C44", hash_generated_method = "E0C19E641EC755313CC934E5918D600A")
        
public void run() {
            Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);

            SyncResult syncResult = new SyncResult();
            ContentProviderClient provider = null;
            try {
                if (isCanceled()) {
                    return;
                }
                provider = mContext.getContentResolver().acquireContentProviderClient(mAuthority);
                if (provider != null) {
                    AbstractThreadedSyncAdapter.this.onPerformSync(mAccount, mExtras,
                            mAuthority, provider, syncResult);
                } else {
                    syncResult.databaseError = true;
                }
            } finally {
                if (provider != null) {
                    provider.release();
                }
                if (!isCanceled()) {
                    mSyncContext.onFinished(syncResult);
                }
                // synchronize so that the assignment will be seen by other threads
                // that also synchronize accesses to mSyncThreads
                synchronized (mSyncThreadLock) {
                    mSyncThreads.remove(mThreadsKey);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.127 -0500", hash_original_method = "AF64882FDB439923A57610742F2CCD01", hash_generated_method = "BC335EFF00542F24521D10DCA5B9D6EF")
        
private boolean isCanceled() {
            return Thread.currentThread().isInterrupted();
        }
    }

    /**
     * @return a reference to the IBinder of the SyncAdapter service.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.141 -0500", hash_original_method = "5D55B4CBFD94291B023C63B64529CB8E", hash_generated_method = "2DBACE41204B13F24358CC892DC3D0BC")
    
public final IBinder getSyncAdapterBinder() {
        return mISyncAdapterImpl.asBinder();
    }

    /**
     * Perform a sync for this account. SyncAdapter-specific parameters may
     * be specified in extras, which is guaranteed to not be null. Invocations
     * of this method are guaranteed to be serialized.
     *
     * @param account the account that should be synced
     * @param extras SyncAdapter-specific parameters
     * @param authority the authority of this sync request
     * @param provider a ContentProviderClient that points to the ContentProvider for this
     *   authority
     * @param syncResult SyncAdapter-specific parameters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.148 -0500", hash_original_method = "757225976F8CE1227042109AE28B592A", hash_generated_method = "949747B12B417E9ECCAC2E5AF5CB5036")
    
public abstract void onPerformSync(Account account, Bundle extras,
            String authority, ContentProviderClient provider, SyncResult syncResult);

    /**
     * Indicates that a sync operation has been canceled. This will be invoked on a separate
     * thread than the sync thread and so you must consider the multi-threaded implications
     * of the work that you do in this method.
     * <p>
     * This will only be invoked when the SyncAdapter indicates that it doesn't support
     * parallel syncs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.153 -0500", hash_original_method = "CA8346F7EC31770030C73D95257F81B4", hash_generated_method = "A9B55FAA993DFD4237F4442042F31147")
    
public void onSyncCanceled() {
        final SyncThread syncThread;
        synchronized (mSyncThreadLock) {
            syncThread = mSyncThreads.get(null);
        }
        if (syncThread != null) {
            syncThread.interrupt();
        }
    }

    /**
     * Indicates that a sync operation has been canceled. This will be invoked on a separate
     * thread than the sync thread and so you must consider the multi-threaded implications
     * of the work that you do in this method.
     * <p>
     * This will only be invoked when the SyncAdapter indicates that it does support
     * parallel syncs.
     * @param thread the Thread of the sync that is to be canceled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:03:25.159 -0500", hash_original_method = "D4CC1D7F3C7640D9798CBF10AC94C467", hash_generated_method = "0ACB9C23537DAD1C20E80A07EF3A6DB4")
    
public void onSyncCanceled(Thread thread) {
        thread.interrupt();
    }
}
