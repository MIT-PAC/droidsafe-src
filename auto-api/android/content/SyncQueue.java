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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.238 -0400", hash_original_field = "45147E3AEB1E4ADCE06A13083E577526", hash_generated_field = "C4D1F4553F2DAB654514F44F7C643ACD")

    private SyncStorageEngine mSyncStorageEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.238 -0400", hash_original_field = "33E73F7C0E48552B1038F6EFECEC7CF1", hash_generated_field = "3EE45AA38027E40BC3F5CD43429C606C")

    public final HashMap<String, SyncOperation> mOperationsMap = Maps.newHashMap();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.239 -0400", hash_original_method = "4B46EA3F8AD8CFC1D0053E5D8D79C64A", hash_generated_method = "E61BFE891F6FADA151379EAF091D2C78")
    public  SyncQueue(SyncStorageEngine syncStorageEngine, final SyncAdaptersCache syncAdapters) {
        mSyncStorageEngine = syncStorageEngine;
        ArrayList<SyncStorageEngine.PendingOperation> ops = mSyncStorageEngine.getPendingOperations();
        final int N = ops.size();
        {
            int i = 0;
            {
                SyncStorageEngine.PendingOperation op = ops.get(i);
                final Pair<Long, Long> backoff = syncStorageEngine.getBackoff(op.account, op.authority);
                final RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = syncAdapters.getServiceInfo(
                            SyncAdapterType.newKey(op.authority, op.account.type));
                SyncOperation syncOperation = new SyncOperation(
                    op.account, op.syncSource, op.authority, op.extras, 0 ,
                    backoff != null ? backoff.first : 0,
                    syncStorageEngine.getDelayUntilTime(op.account, op.authority),
                    syncAdapterInfo.type.allowParallelSyncs());//DSFIXME:  CODE0008: Nested ternary operator in expression
                syncOperation.expedited = op.expedited;
                syncOperation.pendingOperation = op;
                add(syncOperation, op);
            } //End block
        } //End collapsed parenthetic
        addTaint(syncAdapters.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.239 -0400", hash_original_method = "D3ED8DB5FFE6F89C719EB4A464B29556", hash_generated_method = "6B56C4E24B0FE9B2E6BB17EC72494BD4")
    public boolean add(SyncOperation operation) {
        boolean varD2EE4195B2D87223E270EB3EB0A6E3F5_575166164 = (add(operation, null ));
        addTaint(operation.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496631316 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496631316;
        // ---------- Original Method ----------
        //return add(operation, null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.240 -0400", hash_original_method = "DE2F99F3641547A1BC9E364A4B2B8E2B", hash_generated_method = "2A0B05B9D406F4E099F0AB66B644DFE4")
    private boolean add(SyncOperation operation,
            SyncStorageEngine.PendingOperation pop) {
        final String operationKey = operation.key;
        final SyncOperation existingOperation = mOperationsMap.get(operationKey);
        {
            boolean changed = false;
            {
                final long newRunTime = Math.min(existingOperation.earliestRunTime, operation.earliestRunTime);
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
        addTaint(operation.getTaint());
        addTaint(pop.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_934889646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_934889646;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.241 -0400", hash_original_method = "6EA1C69DAD85A65D52720F29F3DAA89B", hash_generated_method = "0692B0D4B5231CA86F8532452B4C8083")
    public void remove(SyncOperation operation) {
        SyncOperation operationToRemove = mOperationsMap.remove(operation.key);
        {
            boolean var540EE0083C66CFF9188CAA00F2AD132F_329846997 = (!mSyncStorageEngine.deleteFromPending(operationToRemove.pendingOperation));
            {
                final String errorMessage = "unable to find pending row for " + operationToRemove;
            } //End block
        } //End collapsed parenthetic
        addTaint(operation.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.258 -0400", hash_original_method = "B31E7F9449B862015CEE60B6F703FDEF", hash_generated_method = "FCA993FEA1C2B78DCA7CD35A360A1704")
    public void onBackoffChanged(Account account, String providerName, long backoff) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Iterator<SyncOperation> varA6A62C13A555831201947A0BCBA5252D_488103838 = (mOperationsMap.values()).iterator();
            varA6A62C13A555831201947A0BCBA5252D_488103838.hasNext();
            SyncOperation op = varA6A62C13A555831201947A0BCBA5252D_488103838.next();
            {
                {
                    boolean var2EC9E5AA01CD20C09DEE410F9D14A917_641043324 = (op.account.equals(account) && op.authority.equals(providerName));
                    {
                        op.backoff = backoff;
                        op.updateEffectiveRunTime();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        addTaint(backoff);
        // ---------- Original Method ----------
        //for (SyncOperation op : mOperationsMap.values()) {
            //if (op.account.equals(account) && op.authority.equals(providerName)) {
                //op.backoff = backoff;
                //op.updateEffectiveRunTime();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.262 -0400", hash_original_method = "B5F16B587E82C75B14DBD47F35BFF547", hash_generated_method = "F0372302E8D0191D64AE379E4691F913")
    public void onDelayUntilTimeChanged(Account account, String providerName, long delayUntil) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Iterator<SyncOperation> varA6A62C13A555831201947A0BCBA5252D_1907219748 = (mOperationsMap.values()).iterator();
            varA6A62C13A555831201947A0BCBA5252D_1907219748.hasNext();
            SyncOperation op = varA6A62C13A555831201947A0BCBA5252D_1907219748.next();
            {
                {
                    boolean var2EC9E5AA01CD20C09DEE410F9D14A917_193421618 = (op.account.equals(account) && op.authority.equals(providerName));
                    {
                        op.delayUntil = delayUntil;
                        op.updateEffectiveRunTime();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(account.getTaint());
        addTaint(providerName.getTaint());
        addTaint(delayUntil);
        // ---------- Original Method ----------
        //for (SyncOperation op : mOperationsMap.values()) {
            //if (op.account.equals(account) && op.authority.equals(providerName)) {
                //op.delayUntil = delayUntil;
                //op.updateEffectiveRunTime();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.263 -0400", hash_original_method = "3BDDACB884C02271E516EA5014748603", hash_generated_method = "0D63BE3AC92F72E1FFA9296AE6BB571F")
    public void remove(Account account, String authority) {
        Iterator<Map.Entry<String, SyncOperation>> entries = mOperationsMap.entrySet().iterator();
        {
            boolean var09A288798F3AA3CC86DC1D8BA5087B32_622828949 = (entries.hasNext());
            {
                Map.Entry<String, SyncOperation> entry = entries.next();
                SyncOperation syncOperation = entry.getValue();
                {
                    boolean varA133932521E0D15B2D2CEE7F49E0763A_546544828 = (account != null && !syncOperation.account.equals(account));
                } //End collapsed parenthetic
                {
                    boolean varD5CA21567F2713BC95D1F8BB6C616C44_228057872 = (authority != null && !syncOperation.authority.equals(authority));
                } //End collapsed parenthetic
                entries.remove();
                {
                    boolean varCA42267505FA64ABBFD771EF48B24F63_1275670892 = (!mSyncStorageEngine.deleteFromPending(syncOperation.pendingOperation));
                    {
                        final String errorMessage = "unable to find pending row for " + syncOperation;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.271 -0400", hash_original_method = "DE0C3912E55B433E68B0CDCDD70A3B83", hash_generated_method = "EC21DB5EA3FA1D6645F96F8852A69B56")
    public void dump(StringBuilder sb) {
        final long now = SystemClock.elapsedRealtime();
        sb.append("SyncQueue: ").append(mOperationsMap.size()).append(" operation(s)\n");
        {
            Iterator<SyncOperation> varBD7A91BE9015B18580A8E9F432406095_59313650 = (mOperationsMap.values()).iterator();
            varBD7A91BE9015B18580A8E9F432406095_59313650.hasNext();
            SyncOperation operation = varBD7A91BE9015B18580A8E9F432406095_59313650.next();
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
        addTaint(sb.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.272 -0400", hash_original_field = "0439F4DA6A334C5ECD9FAAB83A40EC1E", hash_generated_field = "AF31108A14FC5488BDB972C9330ED310")

    private static final String TAG = "SyncManager";
}

