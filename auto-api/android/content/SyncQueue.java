package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.google.android.collect.Maps;
import android.content.pm.RegisteredServicesCache;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.util.Pair;
import android.util.Log;
import android.accounts.Account;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SyncQueue {
    private SyncStorageEngine mSyncStorageEngine;
    public HashMap<String, SyncOperation> mOperationsMap = Maps.newHashMap();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.959 -0400", hash_original_method = "4B46EA3F8AD8CFC1D0053E5D8D79C64A", hash_generated_method = "146F9F839AF9145A23A57AF00689080C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncQueue(SyncStorageEngine syncStorageEngine, final SyncAdaptersCache syncAdapters) {
        dsTaint.addTaint(syncStorageEngine.dsTaint);
        dsTaint.addTaint(syncAdapters.dsTaint);
        ArrayList<SyncStorageEngine.PendingOperation> ops;
        ops = mSyncStorageEngine.getPendingOperations();
        int N;
        N = ops.size();
        {
            int i;
            i = 0;
            {
                SyncStorageEngine.PendingOperation op;
                op = ops.get(i);
                Pair<Long, Long> backoff;
                backoff = syncStorageEngine.getBackoff(op.account, op.authority);
                RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo;
                syncAdapterInfo = syncAdapters.getServiceInfo(
                            SyncAdapterType.newKey(op.authority, op.account.type));
                SyncOperation syncOperation;
                syncOperation = new SyncOperation(
                    op.account, op.syncSource, op.authority, op.extras, 0 ,
                    backoff != null ? backoff.first : 0,
                    syncStorageEngine.getDelayUntilTime(op.account, op.authority),
                    syncAdapterInfo.type.allowParallelSyncs());//DSFIXME:  CODE0008: Nested ternary operator in expression
                syncOperation.expedited = op.expedited;
                syncOperation.pendingOperation = op;
                add(syncOperation, op);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.959 -0400", hash_original_method = "D3ED8DB5FFE6F89C719EB4A464B29556", hash_generated_method = "102C2341B7029D5188FADAA743BA1C33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(SyncOperation operation) {
        dsTaint.addTaint(operation.dsTaint);
        boolean varD2EE4195B2D87223E270EB3EB0A6E3F5_673166998 = (add(operation, null ));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return add(operation, null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.960 -0400", hash_original_method = "DE2F99F3641547A1BC9E364A4B2B8E2B", hash_generated_method = "9460F221837CB59BA300F74B36BEBE74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean add(SyncOperation operation,
            SyncStorageEngine.PendingOperation pop) {
        dsTaint.addTaint(operation.dsTaint);
        dsTaint.addTaint(pop.dsTaint);
        String operationKey;
        operationKey = operation.key;
        SyncOperation existingOperation;
        existingOperation = mOperationsMap.get(operationKey);
        {
            boolean changed;
            changed = false;
            {
                long newRunTime;
                newRunTime = Math.min(existingOperation.earliestRunTime, operation.earliestRunTime);
                {
                    existingOperation.earliestRunTime = newRunTime;
                    changed = true;
                } //End block
            } //End block
            {
                {
                    existingOperation.expedited = true;
                    changed = true;
                } //End block
            } //End block
        } //End block
        operation.pendingOperation = pop;
        {
            pop = new SyncStorageEngine.PendingOperation(
                            operation.account, operation.syncSource,
                            operation.authority, operation.extras, operation.expedited);
            pop = mSyncStorageEngine.insertIntoPending(pop);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("error adding pending sync operation "
                        + operation);
            } //End block
            operation.pendingOperation = pop;
        } //End block
        mOperationsMap.put(operationKey, operation);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.960 -0400", hash_original_method = "6EA1C69DAD85A65D52720F29F3DAA89B", hash_generated_method = "DC222E6F891C8135CA43AA93274527C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void remove(SyncOperation operation) {
        dsTaint.addTaint(operation.dsTaint);
        SyncOperation operationToRemove;
        operationToRemove = mOperationsMap.remove(operation.key);
        {
            boolean var540EE0083C66CFF9188CAA00F2AD132F_657133 = (!mSyncStorageEngine.deleteFromPending(operationToRemove.pendingOperation));
            {
                String errorMessage;
                errorMessage = "unable to find pending row for " + operationToRemove;
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.964 -0400", hash_original_method = "B31E7F9449B862015CEE60B6F703FDEF", hash_generated_method = "EB75C46D4ACA37AB2CA3D34DEE8211CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onBackoffChanged(Account account, String providerName, long backoff) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(backoff);
        {
            Iterator<SyncOperation> varA6A62C13A555831201947A0BCBA5252D_1349907754 = (mOperationsMap.values()).iterator();
            varA6A62C13A555831201947A0BCBA5252D_1349907754.hasNext();
            SyncOperation op = varA6A62C13A555831201947A0BCBA5252D_1349907754.next();
            {
                {
                    boolean var2EC9E5AA01CD20C09DEE410F9D14A917_1591864289 = (op.account.equals(account) && op.authority.equals(providerName));
                    {
                        op.backoff = backoff;
                        op.updateEffectiveRunTime();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (SyncOperation op : mOperationsMap.values()) {
            //if (op.account.equals(account) && op.authority.equals(providerName)) {
                //op.backoff = backoff;
                //op.updateEffectiveRunTime();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.977 -0400", hash_original_method = "B5F16B587E82C75B14DBD47F35BFF547", hash_generated_method = "2D6954B9BA97B841924A421944D506BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onDelayUntilTimeChanged(Account account, String providerName, long delayUntil) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(delayUntil);
        {
            Iterator<SyncOperation> varA6A62C13A555831201947A0BCBA5252D_1649122654 = (mOperationsMap.values()).iterator();
            varA6A62C13A555831201947A0BCBA5252D_1649122654.hasNext();
            SyncOperation op = varA6A62C13A555831201947A0BCBA5252D_1649122654.next();
            {
                {
                    boolean var2EC9E5AA01CD20C09DEE410F9D14A917_218784304 = (op.account.equals(account) && op.authority.equals(providerName));
                    {
                        op.delayUntil = delayUntil;
                        op.updateEffectiveRunTime();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (SyncOperation op : mOperationsMap.values()) {
            //if (op.account.equals(account) && op.authority.equals(providerName)) {
                //op.delayUntil = delayUntil;
                //op.updateEffectiveRunTime();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.981 -0400", hash_original_method = "3BDDACB884C02271E516EA5014748603", hash_generated_method = "FFCDA29CDF208AA31CC994DD25764CD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void remove(Account account, String authority) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        Iterator<Map.Entry<String, SyncOperation>> entries;
        entries = mOperationsMap.entrySet().iterator();
        {
            boolean var09A288798F3AA3CC86DC1D8BA5087B32_417391642 = (entries.hasNext());
            {
                Map.Entry<String, SyncOperation> entry;
                entry = entries.next();
                SyncOperation syncOperation;
                syncOperation = entry.getValue();
                {
                    boolean varA133932521E0D15B2D2CEE7F49E0763A_1681496205 = (account != null && !syncOperation.account.equals(account));
                } //End collapsed parenthetic
                {
                    boolean varD5CA21567F2713BC95D1F8BB6C616C44_2083376072 = (authority != null && !syncOperation.authority.equals(authority));
                } //End collapsed parenthetic
                entries.remove();
                {
                    boolean varCA42267505FA64ABBFD771EF48B24F63_429464166 = (!mSyncStorageEngine.deleteFromPending(syncOperation.pendingOperation));
                    {
                        String errorMessage;
                        errorMessage = "unable to find pending row for " + syncOperation;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.005 -0400", hash_original_method = "DE0C3912E55B433E68B0CDCDD70A3B83", hash_generated_method = "474C5F86D0FC111BD7999222553BDC11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(StringBuilder sb) {
        dsTaint.addTaint(sb.dsTaint);
        long now;
        now = SystemClock.elapsedRealtime();
        sb.append("SyncQueue: ").append(mOperationsMap.size()).append(" operation(s)\n");
        {
            Iterator<SyncOperation> varBD7A91BE9015B18580A8E9F432406095_11759481 = (mOperationsMap.values()).iterator();
            varBD7A91BE9015B18580A8E9F432406095_11759481.hasNext();
            SyncOperation operation = varBD7A91BE9015B18580A8E9F432406095_11759481.next();
            {
                sb.append("  ");
                {
                    sb.append("READY");
                } //End block
                {
                    sb.append(DateUtils.formatElapsedTime((operation.effectiveRunTime - now) / 1000));
                } //End block
                sb.append(" - ");
                sb.append(operation.dump(false)).append("\n");
            } //End block
        } //End collapsed parenthetic
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

    
    private static final String TAG = "SyncManager";
}

