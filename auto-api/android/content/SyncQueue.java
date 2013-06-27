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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.474 -0400", hash_original_field = "45147E3AEB1E4ADCE06A13083E577526", hash_generated_field = "C4D1F4553F2DAB654514F44F7C643ACD")

    private SyncStorageEngine mSyncStorageEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.474 -0400", hash_original_field = "33E73F7C0E48552B1038F6EFECEC7CF1", hash_generated_field = "B834195A5D324E25C247F1018772491C")

    public HashMap<String, SyncOperation> mOperationsMap = Maps.newHashMap();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.489 -0400", hash_original_method = "4B46EA3F8AD8CFC1D0053E5D8D79C64A", hash_generated_method = "0439CAD8A1CFAC01065A0E5ADD0CE543")
    public  SyncQueue(SyncStorageEngine syncStorageEngine, final SyncAdaptersCache syncAdapters) {
        mSyncStorageEngine = syncStorageEngine;
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
        addTaint(syncAdapters.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.490 -0400", hash_original_method = "D3ED8DB5FFE6F89C719EB4A464B29556", hash_generated_method = "E9173C02310D21197B112C1CEE69174B")
    public boolean add(SyncOperation operation) {
        boolean varD2EE4195B2D87223E270EB3EB0A6E3F5_69750590 = (add(operation, null ));
        addTaint(operation.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867015388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_867015388;
        // ---------- Original Method ----------
        //return add(operation, null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.506 -0400", hash_original_method = "DE2F99F3641547A1BC9E364A4B2B8E2B", hash_generated_method = "CB6B2DD5EF9DEC729D8706F3BD802160")
    private boolean add(SyncOperation operation,
            SyncStorageEngine.PendingOperation pop) {
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
        addTaint(operation.getTaint());
        addTaint(pop.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_642363939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_642363939;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.507 -0400", hash_original_method = "6EA1C69DAD85A65D52720F29F3DAA89B", hash_generated_method = "8683DC5C44A73F83AC4F247B12176554")
    public void remove(SyncOperation operation) {
        SyncOperation operationToRemove;
        operationToRemove = mOperationsMap.remove(operation.key);
        {
            boolean var540EE0083C66CFF9188CAA00F2AD132F_1964769247 = (!mSyncStorageEngine.deleteFromPending(operationToRemove.pendingOperation));
            {
                String errorMessage;
                errorMessage = "unable to find pending row for " + operationToRemove;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.593 -0400", hash_original_method = "B31E7F9449B862015CEE60B6F703FDEF", hash_generated_method = "01CCBF0EFF56C62BBBD39C06F25DDD87")
    public void onBackoffChanged(Account account, String providerName, long backoff) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Iterator<SyncOperation> varA6A62C13A555831201947A0BCBA5252D_1968115581 = (mOperationsMap.values()).iterator();
            varA6A62C13A555831201947A0BCBA5252D_1968115581.hasNext();
            SyncOperation op = varA6A62C13A555831201947A0BCBA5252D_1968115581.next();
            {
                {
                    boolean var2EC9E5AA01CD20C09DEE410F9D14A917_754265009 = (op.account.equals(account) && op.authority.equals(providerName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.698 -0400", hash_original_method = "B5F16B587E82C75B14DBD47F35BFF547", hash_generated_method = "E40300D7890F4E866490F673EDFE6630")
    public void onDelayUntilTimeChanged(Account account, String providerName, long delayUntil) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Iterator<SyncOperation> varA6A62C13A555831201947A0BCBA5252D_1529689990 = (mOperationsMap.values()).iterator();
            varA6A62C13A555831201947A0BCBA5252D_1529689990.hasNext();
            SyncOperation op = varA6A62C13A555831201947A0BCBA5252D_1529689990.next();
            {
                {
                    boolean var2EC9E5AA01CD20C09DEE410F9D14A917_1463973816 = (op.account.equals(account) && op.authority.equals(providerName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.707 -0400", hash_original_method = "3BDDACB884C02271E516EA5014748603", hash_generated_method = "56BD87FF31A39A048A13206A6F03B819")
    public void remove(Account account, String authority) {
        Iterator<Map.Entry<String, SyncOperation>> entries;
        entries = mOperationsMap.entrySet().iterator();
        {
            boolean var09A288798F3AA3CC86DC1D8BA5087B32_1631666740 = (entries.hasNext());
            {
                Map.Entry<String, SyncOperation> entry;
                entry = entries.next();
                SyncOperation syncOperation;
                syncOperation = entry.getValue();
                {
                    boolean varA133932521E0D15B2D2CEE7F49E0763A_1273641044 = (account != null && !syncOperation.account.equals(account));
                } //End collapsed parenthetic
                {
                    boolean varD5CA21567F2713BC95D1F8BB6C616C44_1907621188 = (authority != null && !syncOperation.authority.equals(authority));
                } //End collapsed parenthetic
                entries.remove();
                {
                    boolean varCA42267505FA64ABBFD771EF48B24F63_235243964 = (!mSyncStorageEngine.deleteFromPending(syncOperation.pendingOperation));
                    {
                        String errorMessage;
                        errorMessage = "unable to find pending row for " + syncOperation;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(account.getTaint());
        addTaint(authority.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.869 -0400", hash_original_method = "DE0C3912E55B433E68B0CDCDD70A3B83", hash_generated_method = "B626BF68E99B9805516880793390B191")
    public void dump(StringBuilder sb) {
        long now;
        now = SystemClock.elapsedRealtime();
        sb.append("SyncQueue: ").append(mOperationsMap.size()).append(" operation(s)\n");
        {
            Iterator<SyncOperation> varBD7A91BE9015B18580A8E9F432406095_1634119167 = (mOperationsMap.values()).iterator();
            varBD7A91BE9015B18580A8E9F432406095_1634119167.hasNext();
            SyncOperation operation = varBD7A91BE9015B18580A8E9F432406095_1634119167.next();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.869 -0400", hash_original_field = "0439F4DA6A334C5ECD9FAAB83A40EC1E", hash_generated_field = "CAAD11AC43D5339C465E3446FFFD23C9")

    private static String TAG = "SyncManager";
}

