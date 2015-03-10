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
 * Copyright (C) 2010 The Android Open Source Project
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

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.accounts.Account;
import android.content.pm.RegisteredServicesCache;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.util.Pair;

import com.google.android.collect.Maps;






public class SyncQueue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.770 -0500", hash_original_field = "264AE0F69A379AF82B30661B10A7553C", hash_generated_field = "AF31108A14FC5488BDB972C9330ED310")

    private static final String TAG = "SyncManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.773 -0500", hash_original_field = "9E2BCBFE661FFE13826B6A4F1567CFD7", hash_generated_field = "C4D1F4553F2DAB654514F44F7C643ACD")

    private SyncStorageEngine mSyncStorageEngine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.775 -0500", hash_original_field = "EB939E69447A1299752F5DF2A1F663E8", hash_generated_field = "90D0C2285E17BA8FB9339E70A3FE25AE")

    // quick lookup of an enqueued SyncOperation.
    public final HashMap<String, SyncOperation> mOperationsMap = Maps.newHashMap();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.778 -0500", hash_original_method = "4B46EA3F8AD8CFC1D0053E5D8D79C64A", hash_generated_method = "808EF47803507425EF627D76BC00306B")
    
public SyncQueue(SyncStorageEngine syncStorageEngine, final SyncAdaptersCache syncAdapters) {
        mSyncStorageEngine = syncStorageEngine;
        ArrayList<SyncStorageEngine.PendingOperation> ops
                = mSyncStorageEngine.getPendingOperations();
        final int N = ops.size();
        for (int i=0; i<N; i++) {
            SyncStorageEngine.PendingOperation op = ops.get(i);
            final Pair<Long, Long> backoff = syncStorageEngine.getBackoff(op.account, op.authority);
            final RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo =
                    syncAdapters.getServiceInfo(
                            SyncAdapterType.newKey(op.authority, op.account.type));
            if (syncAdapterInfo == null) {
                continue;
            }
            SyncOperation syncOperation = new SyncOperation(
                    op.account, op.syncSource, op.authority, op.extras, 0 /* delay */,
                    backoff != null ? backoff.first : 0,
                    syncStorageEngine.getDelayUntilTime(op.account, op.authority),
                    syncAdapterInfo.type.allowParallelSyncs());
            syncOperation.expedited = op.expedited;
            syncOperation.pendingOperation = op;
            add(syncOperation, op);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.780 -0500", hash_original_method = "D3ED8DB5FFE6F89C719EB4A464B29556", hash_generated_method = "DB4929F648D068978A05F9CA0BEF79F4")
    
public boolean add(SyncOperation operation) {
        return add(operation, null /* this is not coming from the database */);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.784 -0500", hash_original_method = "DE2F99F3641547A1BC9E364A4B2B8E2B", hash_generated_method = "2C485D0EEAB51F56F61BB82DC30D7AA4")
    
private boolean add(SyncOperation operation,
            SyncStorageEngine.PendingOperation pop) {
        // - if an operation with the same key exists and this one should run earlier,
        //   update the earliestRunTime of the existing to the new time
        // - if an operation with the same key exists and if this one should run
        //   later, ignore it
        // - if no operation exists then add the new one
        final String operationKey = operation.key;
        final SyncOperation existingOperation = mOperationsMap.get(operationKey);

        if (existingOperation != null) {
            boolean changed = false;
            if (existingOperation.expedited == operation.expedited) {
                final long newRunTime =
                        Math.min(existingOperation.earliestRunTime, operation.earliestRunTime);
                if (existingOperation.earliestRunTime != newRunTime) {
                    existingOperation.earliestRunTime = newRunTime;
                    changed = true;
                }
            } else {
                if (operation.expedited) {
                    existingOperation.expedited = true;
                    changed = true;
                }
            }
            return changed;
        }

        operation.pendingOperation = pop;
        if (operation.pendingOperation == null) {
            pop = new SyncStorageEngine.PendingOperation(
                            operation.account, operation.syncSource,
                            operation.authority, operation.extras, operation.expedited);
            pop = mSyncStorageEngine.insertIntoPending(pop);
            if (pop == null) {
                throw new IllegalStateException("error adding pending sync operation "
                        + operation);
            }
            operation.pendingOperation = pop;
        }

        mOperationsMap.put(operationKey, operation);
        return true;
    }

    /**
     * Remove the specified operation if it is in the queue.
     * @param operation the operation to remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.786 -0500", hash_original_method = "6EA1C69DAD85A65D52720F29F3DAA89B", hash_generated_method = "76A9BFB939A8C52D6ECCB08F02CF8469")
    
public void remove(SyncOperation operation) {
        SyncOperation operationToRemove = mOperationsMap.remove(operation.key);
        if (operationToRemove == null) {
            return;
        }
        if (!mSyncStorageEngine.deleteFromPending(operationToRemove.pendingOperation)) {
            final String errorMessage = "unable to find pending row for " + operationToRemove;
            Log.e(TAG, errorMessage, new IllegalStateException(errorMessage));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.788 -0500", hash_original_method = "B31E7F9449B862015CEE60B6F703FDEF", hash_generated_method = "410AD485B6FF52FB3AEEF788E71FDD16")
    
public void onBackoffChanged(Account account, String providerName, long backoff) {
        // for each op that matches the account and provider update its
        // backoff and effectiveStartTime
        for (SyncOperation op : mOperationsMap.values()) {
            if (op.account.equals(account) && op.authority.equals(providerName)) {
                op.backoff = backoff;
                op.updateEffectiveRunTime();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.790 -0500", hash_original_method = "B5F16B587E82C75B14DBD47F35BFF547", hash_generated_method = "185F7032FBE2B8CD3C368FD414996A08")
    
public void onDelayUntilTimeChanged(Account account, String providerName, long delayUntil) {
        // for each op that matches the account and provider update its
        // delayUntilTime and effectiveStartTime
        for (SyncOperation op : mOperationsMap.values()) {
            if (op.account.equals(account) && op.authority.equals(providerName)) {
                op.delayUntil = delayUntil;
                op.updateEffectiveRunTime();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.793 -0500", hash_original_method = "3BDDACB884C02271E516EA5014748603", hash_generated_method = "1337D088937DDF19C87D9F5358311ADC")
    
public void remove(Account account, String authority) {
        Iterator<Map.Entry<String, SyncOperation>> entries = mOperationsMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, SyncOperation> entry = entries.next();
            SyncOperation syncOperation = entry.getValue();
            if (account != null && !syncOperation.account.equals(account)) {
                continue;
            }
            if (authority != null && !syncOperation.authority.equals(authority)) {
                continue;
            }
            entries.remove();
            if (!mSyncStorageEngine.deleteFromPending(syncOperation.pendingOperation)) {
                final String errorMessage = "unable to find pending row for " + syncOperation;
                Log.e(TAG, errorMessage, new IllegalStateException(errorMessage));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.795 -0500", hash_original_method = "DE0C3912E55B433E68B0CDCDD70A3B83", hash_generated_method = "6407CE3BEA75DBD2F2B7EEF57CD7D4E0")
    
public void dump(StringBuilder sb) {
        final long now = SystemClock.elapsedRealtime();
        sb.append("SyncQueue: ").append(mOperationsMap.size()).append(" operation(s)\n");
        for (SyncOperation operation : mOperationsMap.values()) {
            sb.append("  ");
            if (operation.effectiveRunTime <= now) {
                sb.append("READY");
            } else {
                sb.append(DateUtils.formatElapsedTime((operation.effectiveRunTime - now) / 1000));
            }
            sb.append(" - ");
            sb.append(operation.dump(false)).append("\n");
        }
    }
}

