/*
 * Copyright (C) 2008 The Android Open Source Project
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

package android.content;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.IBinder;

public class SyncContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:05:18.413 -0500", hash_original_field = "AECA8ED24E0B0BFA017222DB60F5A166", hash_generated_field = "6A469193CD6FEBDF48145EAB352C1D8D")


    private static final long HEARTBEAT_SEND_INTERVAL_IN_MS = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:05:18.396 -0500", hash_original_field = "5B63866F0B2F97993391696F6B5E6818", hash_generated_field = "2AAFA6A797C2624DA184E8D80CCC2E04")

    private ISyncContext mSyncContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:05:18.406 -0500", hash_original_field = "A29DED308F42FBF86130D36438857927", hash_generated_field = "ED2E8F4F22D43E47FC96D97422C9E873")

    private long mLastHeartbeatSendTime;

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:05:18.422 -0500", hash_original_method = "C8234137AE4F62C9E5FBE5454D2BDE81", hash_generated_method = "18F7D5AC68DD27F0CAC457C2A96A7143")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public SyncContext(ISyncContext syncContextInterface) {
        mSyncContext = syncContextInterface;
        mLastHeartbeatSendTime = 0;
    }

    /**
     * Call to update the status text for this sync. This internally invokes
     * {@link #updateHeartbeat}, so it also takes the place of a call to that.
     *
     * @param message the current status message for this sync
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:05:18.427 -0500", hash_original_method = "1B4BA6E4B7DDAF02AC7BEEF22473D582", hash_generated_method = "F2ACDA4D4194522CB8D61BA7813B4757")
    @DSVerified("Heartbeat sent through IPC")
    @DSSpec(DSCat.SPEC_OTHERS)
public void setStatusText(String message) {
        updateHeartbeat();
    }

    /**
     * Call to indicate that the SyncAdapter is making progress. E.g., if this SyncAdapter
     * downloads or sends records to/from the server, this may be called after each record
     * is downloaded or uploaded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:05:18.437 -0500", hash_original_method = "F7A45991E1ECACD98052095A0CF35DFD", hash_generated_method = "B9708DDEA54191B576AFA9E10646C1E7")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private void updateHeartbeat() {
        final long now = SystemClock.elapsedRealtime();
        if (now < mLastHeartbeatSendTime + HEARTBEAT_SEND_INTERVAL_IN_MS) return;
        try {
            mLastHeartbeatSendTime = now;
            if (mSyncContext != null) {
                mSyncContext.sendHeartbeat();
            }
        } catch (RemoteException e) {
            // this should never happen
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:05:18.457 -0500", hash_original_method = "42005A80A083C17FADFB054A837E4CF2", hash_generated_method = "7698D5DF61B96275D970F52E3C757EE9")
    
public void onFinished(SyncResult result) {
        try {
            if (mSyncContext != null) {
                mSyncContext.onFinished(result);
            }
        } catch (RemoteException e) {
            // this should never happen
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 11:05:18.464 -0500", hash_original_method = "2A61FB95949D9704C5805F8B85B936A5", hash_generated_method = "7A325B49827CE7E6CDA4214D24A265A1")
    
public IBinder getSyncContextBinder() {
        return (mSyncContext == null) ? null : mSyncContext.asBinder();
    }
}
