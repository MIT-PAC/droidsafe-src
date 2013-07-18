package android.content;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SyncQueue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.629 -0400", hash_original_field = "45147E3AEB1E4ADCE06A13083E577526", hash_generated_field = "C4D1F4553F2DAB654514F44F7C643ACD")

    private SyncStorageEngine mSyncStorageEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.629 -0400", hash_original_field = "33E73F7C0E48552B1038F6EFECEC7CF1", hash_generated_field = "3EE45AA38027E40BC3F5CD43429C606C")

    public final HashMap<String, SyncOperation> mOperationsMap = Maps.newHashMap();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.630 -0400", hash_original_method = "4B46EA3F8AD8CFC1D0053E5D8D79C64A", hash_generated_method = "C4C0547698F0B4A817D4C1F60667CAFF")
    public  SyncQueue(SyncStorageEngine syncStorageEngine, final SyncAdaptersCache syncAdapters) {
        addTaint(syncAdapters.getTaint());
        mSyncStorageEngine = syncStorageEngine;
        ArrayList<SyncStorageEngine.PendingOperation> ops = mSyncStorageEngine.getPendingOperations();
        final int N = ops.size();
for(int i=0;i<N;i++)
        {
            SyncStorageEngine.PendingOperation op = ops.get(i);
            final Pair<Long, Long> backoff = syncStorageEngine.getBackoff(op.account, op.authority);
            final RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = syncAdapters.getServiceInfo(
                            SyncAdapterType.newKey(op.authority, op.account.type));
            if(syncAdapterInfo == null)            
            {
                continue;
            } //End block
            SyncOperation syncOperation = new SyncOperation(
                    op.account, op.syncSource, op.authority, op.extras, 0 ,
                    backoff != null ? backoff.first : 0,
                    syncStorageEngine.getDelayUntilTime(op.account, op.authority),
                    syncAdapterInfo.type.allowParallelSyncs());
            syncOperation.expedited = op.expedited;
            syncOperation.pendingOperation = op;
            add(syncOperation, op);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.631 -0400", hash_original_method = "D3ED8DB5FFE6F89C719EB4A464B29556", hash_generated_method = "5C1BB77A8A1B9A14A00B14DCB6CA8479")
    public boolean add(SyncOperation operation) {
        addTaint(operation.getTaint());
        boolean varFB6EE1A151E02B1C11EEEE2877F018BF_156322097 = (add(operation, null ));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482622868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482622868;
        // ---------- Original Method ----------
        //return add(operation, null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.633 -0400", hash_original_method = "DE2F99F3641547A1BC9E364A4B2B8E2B", hash_generated_method = "5BBEB41B7FFD16908ADA28AC749F0B59")
    private boolean add(SyncOperation operation,
            SyncStorageEngine.PendingOperation pop) {
        addTaint(pop.getTaint());
        addTaint(operation.getTaint());
        final String operationKey = operation.key;
        final SyncOperation existingOperation = mOperationsMap.get(operationKey);
        if(existingOperation != null)        
        {
            boolean changed = false;
            if(existingOperation.expedited == operation.expedited)            
            {
                final long newRunTime = Math.min(existingOperation.earliestRunTime, operation.earliestRunTime);
                if(existingOperation.earliestRunTime != newRunTime)                
                {
                    existingOperation.earliestRunTime = newRunTime;
                    changed = true;
                } //End block
            } //End block
            else
            {
                if(operation.expedited)                
                {
                    existingOperation.expedited = true;
                    changed = true;
                } //End block
            } //End block
            boolean var8977DFAC2F8E04CB96E66882235F5ABA_886131636 = (changed);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1621963419 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1621963419;
        } //End block
        operation.pendingOperation = pop;
        if(operation.pendingOperation == null)        
        {
            pop = new SyncStorageEngine.PendingOperation(
                            operation.account, operation.syncSource,
                            operation.authority, operation.extras, operation.expedited);
            pop = mSyncStorageEngine.insertIntoPending(pop);
            if(pop == null)            
            {
                IllegalStateException varD66D786C7717C91FDE59B1DD7234185B_654088083 = new IllegalStateException("error adding pending sync operation "
                        + operation);
                varD66D786C7717C91FDE59B1DD7234185B_654088083.addTaint(taint);
                throw varD66D786C7717C91FDE59B1DD7234185B_654088083;
            } //End block
            operation.pendingOperation = pop;
        } //End block
        mOperationsMap.put(operationKey, operation);
        boolean varB326B5062B2F0E69046810717534CB09_364535095 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1753803386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1753803386;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.635 -0400", hash_original_method = "6EA1C69DAD85A65D52720F29F3DAA89B", hash_generated_method = "43227B16A981F05D22D6413B5FEC2A9A")
    public void remove(SyncOperation operation) {
        addTaint(operation.getTaint());
        SyncOperation operationToRemove = mOperationsMap.remove(operation.key);
        if(operationToRemove == null)        
        {
            return;
        } //End block
        if(!mSyncStorageEngine.deleteFromPending(operationToRemove.pendingOperation))        
        {
            final String errorMessage = "unable to find pending row for " + operationToRemove;
        } //End block
        // ---------- Original Method ----------
        //SyncOperation operationToRemove = mOperationsMap.remove(operation.key);
        //if (operationToRemove == null) {
            //return;
        //}
        //if (!mSyncStorageEngine.deleteFromPending(operationToRemove.pendingOperation)) {
            //final String errorMessage = "unable to find pending row for " + operationToRemove;
            //Log.e(TAG, errorMessage, new IllegalStateException(errorMessage));
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.635 -0400", hash_original_method = "B31E7F9449B862015CEE60B6F703FDEF", hash_generated_method = "5D21943CC08F55C3F4F9C2EEE2A953CF")
    public void onBackoffChanged(Account account, String providerName, long backoff) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(backoff);
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
for(SyncOperation op : mOperationsMap.values())
        {
            if(op.account.equals(account) && op.authority.equals(providerName))            
            {
                op.backoff = backoff;
                op.updateEffectiveRunTime();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (SyncOperation op : mOperationsMap.values()) {
            //if (op.account.equals(account) && op.authority.equals(providerName)) {
                //op.backoff = backoff;
                //op.updateEffectiveRunTime();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.637 -0400", hash_original_method = "B5F16B587E82C75B14DBD47F35BFF547", hash_generated_method = "44E99ECA27160FAF896105BD87F9BFBA")
    public void onDelayUntilTimeChanged(Account account, String providerName, long delayUntil) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(delayUntil);
        addTaint(providerName.getTaint());
        addTaint(account.getTaint());
for(SyncOperation op : mOperationsMap.values())
        {
            if(op.account.equals(account) && op.authority.equals(providerName))            
            {
                op.delayUntil = delayUntil;
                op.updateEffectiveRunTime();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (SyncOperation op : mOperationsMap.values()) {
            //if (op.account.equals(account) && op.authority.equals(providerName)) {
                //op.delayUntil = delayUntil;
                //op.updateEffectiveRunTime();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.638 -0400", hash_original_method = "3BDDACB884C02271E516EA5014748603", hash_generated_method = "4F29F8567A5CB52968263D7789AB7A03")
    public void remove(Account account, String authority) {
        addTaint(authority.getTaint());
        addTaint(account.getTaint());
        Iterator<Map.Entry<String, SyncOperation>> entries = mOperationsMap.entrySet().iterator();
        while
(entries.hasNext())        
        {
            Map.Entry<String, SyncOperation> entry = entries.next();
            SyncOperation syncOperation = entry.getValue();
            if(account != null && !syncOperation.account.equals(account))            
            {
                continue;
            } //End block
            if(authority != null && !syncOperation.authority.equals(authority))            
            {
                continue;
            } //End block
            entries.remove();
            if(!mSyncStorageEngine.deleteFromPending(syncOperation.pendingOperation))            
            {
                final String errorMessage = "unable to find pending row for " + syncOperation;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.640 -0400", hash_original_method = "DE0C3912E55B433E68B0CDCDD70A3B83", hash_generated_method = "0C491C4A1C5E3B35BBB0CBFCB601C7B1")
    public void dump(StringBuilder sb) {
        addTaint(sb.getTaint());
        final long now = SystemClock.elapsedRealtime();
        sb.append("SyncQueue: ").append(mOperationsMap.size()).append(" operation(s)\n");
for(SyncOperation operation : mOperationsMap.values())
        {
            sb.append("  ");
            if(operation.effectiveRunTime <= now)            
            {
                sb.append("READY");
            } //End block
            else
            {
                sb.append(DateUtils.formatElapsedTime((operation.effectiveRunTime - now) / 1000));
            } //End block
            sb.append(" - ");
            sb.append(operation.dump(false)).append("\n");
        } //End block
        // ---------- Original Method ----------
        //final long now = SystemClock.elapsedRealtime();
        //sb.append("SyncQueue: ").append(mOperationsMap.size()).append(" operation(s)\n");
        //for (SyncOperation operation : mOperationsMap.values()) {
            //sb.append("  ");
            //if (operation.effectiveRunTime <= now) {
                //sb.append("READY");
            //} else {
                //sb.append(DateUtils.formatElapsedTime((operation.effectiveRunTime - now) / 1000));
            //}
            //sb.append(" - ");
            //sb.append(operation.dump(false)).append("\n");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.641 -0400", hash_original_field = "0439F4DA6A334C5ECD9FAAB83A40EC1E", hash_generated_field = "AF31108A14FC5488BDB972C9330ED310")

    private static final String TAG = "SyncManager";
}

