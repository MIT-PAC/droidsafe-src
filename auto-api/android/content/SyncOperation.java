package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.accounts.Account;
import android.os.Bundle;
import android.os.SystemClock;

public class SyncOperation implements Comparable {
    public Account account;
    public int syncSource;
    public String authority;
    public boolean allowParallelSyncs;
    public Bundle extras;
    public String key;
    public long earliestRunTime;
    public boolean expedited;
    public SyncStorageEngine.PendingOperation pendingOperation;
    public Long backoff;
    public long delayUntil;
    public long effectiveRunTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.908 -0400", hash_original_method = "B06968042D7BA4644F7F8CC6E7EA9B45", hash_generated_method = "13A3683E5D1EC567CF8D36CE21389058")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncOperation(Account account, int source, String authority, Bundle extras,
            long delayInMs, long backoff, long delayUntil, boolean allowParallelSyncs) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(source);
        dsTaint.addTaint(delayInMs);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(backoff);
        dsTaint.addTaint(allowParallelSyncs);
        dsTaint.addTaint(delayUntil);
        dsTaint.addTaint(extras.dsTaint);
        this.extras = new Bundle(extras);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_UPLOAD);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_MANUAL);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_DO_NOT_RETRY);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_EXPEDITED);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS);
        long now;
        now = SystemClock.elapsedRealtime();
        {
            this.expedited = true;
            this.earliestRunTime = now;
        } //End block
        {
            this.expedited = false;
            this.earliestRunTime = now + delayInMs;
        } //End block
        updateEffectiveRunTime();
        this.key = toKey();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.909 -0400", hash_original_method = "BE085BAA1CD2B4B4487382D0022F31D7", hash_generated_method = "1556B77C886899C97DC7188886745882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SyncOperation(SyncOperation other) {
        dsTaint.addTaint(other.dsTaint);
        this.account = other.account;
        this.syncSource = other.syncSource;
        this.authority = other.authority;
        this.extras = new Bundle(other.extras);
        this.expedited = other.expedited;
        this.earliestRunTime = SystemClock.elapsedRealtime();
        this.backoff = other.backoff;
        this.delayUntil = other.delayUntil;
        this.allowParallelSyncs = other.allowParallelSyncs;
        this.updateEffectiveRunTime();
        this.key = toKey();
        // ---------- Original Method ----------
        //this.account = other.account;
        //this.syncSource = other.syncSource;
        //this.authority = other.authority;
        //this.extras = new Bundle(other.extras);
        //this.expedited = other.expedited;
        //this.earliestRunTime = SystemClock.elapsedRealtime();
        //this.backoff = other.backoff;
        //this.delayUntil = other.delayUntil;
        //this.allowParallelSyncs = other.allowParallelSyncs;
        //this.updateEffectiveRunTime();
        //this.key = toKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.909 -0400", hash_original_method = "432EE1A094EFB9968E7A50DA8ACAC133", hash_generated_method = "8381C2B08D26B814743536DB790648C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeFalseExtra(String extraName) {
        dsTaint.addTaint(extraName);
        {
            boolean varA63D76AF566EBA015E3C2D765EABECE6_138944589 = (!extras.getBoolean(extraName, false));
            {
                extras.remove(extraName);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!extras.getBoolean(extraName, false)) {
            //extras.remove(extraName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.910 -0400", hash_original_method = "DD55706005FD16094E01DF90CF28D99E", hash_generated_method = "B0983FB205896F13449B41E409417FEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var4A71B7AB7E33B18CF3305A25F9B80A16_1152992398 = (dump(true));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dump(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.910 -0400", hash_original_method = "47737E917226B122B7AA0C5B23AFE223", hash_generated_method = "95E469422F562AD78E29745A82E2B7D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String dump(boolean useOneLine) {
        dsTaint.addTaint(useOneLine);
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(account.name);
        sb.append(" (" + account.type + ")");
        sb.append(", " + authority);
        sb.append(", ");
        sb.append(SyncStorageEngine.SOURCES[syncSource]);
        sb.append(", earliestRunTime " + earliestRunTime);
        {
            sb.append(", EXPEDITED");
        } //End block
        {
            boolean var40EB6F6CF4ABE63E4CA23EACF2DEA578_53667258 = (!useOneLine && !extras.keySet().isEmpty());
            {
                sb.append("\n    ");
                extrasToStringBuilder(extras, sb);
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_948682687 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append(account.name);
        //sb.append(" (" + account.type + ")");
        //sb.append(", " + authority);
        //sb.append(", ");
        //sb.append(SyncStorageEngine.SOURCES[syncSource]);
        //sb.append(", earliestRunTime " + earliestRunTime);
        //if (expedited) {
            //sb.append(", EXPEDITED");
        //}
        //if (!useOneLine && !extras.keySet().isEmpty()) {
            //sb.append("\n    ");
            //extrasToStringBuilder(extras, sb);
        //}
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.911 -0400", hash_original_method = "0CBE4B28609593623A1CB97001F0DBD2", hash_generated_method = "BDF4E4F6369BD23FF24BB31B270F6AF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInitialization() {
        boolean var15675A814E24816554E062EC589D1FA0_1526601066 = (extras.getBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return extras.getBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.911 -0400", hash_original_method = "A202EE0B500962365FD241C616148E63", hash_generated_method = "93A1423ED11D90E9BF0D634A4EEF2F74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean ignoreBackoff() {
        boolean var11F18930ED342CB5DB82C8732826050E_1502715411 = (extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.912 -0400", hash_original_method = "557BF419234DEC0AF5F90553488D23D9", hash_generated_method = "CACA7DD723F9D0EFFC847052586DD7AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String toKey() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("authority: ").append(authority);
        sb.append(" account {name=" + account.name + ", type=" + account.type + "}");
        sb.append(" extras: ");
        extrasToStringBuilder(extras, sb);
        String var806458D832AB974D230FEE4CBBDBD390_577029595 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("authority: ").append(authority);
        //sb.append(" account {name=" + account.name + ", type=" + account.type + "}");
        //sb.append(" extras: ");
        //extrasToStringBuilder(extras, sb);
        //return sb.toString();
    }

    
        public static void extrasToStringBuilder(Bundle bundle, StringBuilder sb) {
        sb.append("[");
        for (String key : bundle.keySet()) {
            sb.append(key).append("=").append(bundle.get(key)).append(" ");
        }
        sb.append("]");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.912 -0400", hash_original_method = "0B30B519DCD273F2706D3A8819933F53", hash_generated_method = "3470C2C3EB73D929C84713285D0EFEAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateEffectiveRunTime() {
        effectiveRunTime = ignoreBackoff()
                ? earliestRunTime
                : Math.max(
                    Math.max(earliestRunTime, delayUntil),
                    backoff);
        // ---------- Original Method ----------
        //effectiveRunTime = ignoreBackoff()
                //? earliestRunTime
                //: Math.max(
                    //Math.max(earliestRunTime, delayUntil),
                    //backoff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.913 -0400", hash_original_method = "94E2F05BFAF6BA397C21B12E8FAD132F", hash_generated_method = "C77742D309E0FD3A898CC647F1D143ED")
    @DSModeled(DSC.SAFE)
    public int compareTo(Object o) {
        dsTaint.addTaint(o.dsTaint);
        SyncOperation other;
        other = (SyncOperation)o;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //SyncOperation other = (SyncOperation)o;
        //if (expedited != other.expedited) {
            //return expedited ? -1 : 1;
        //}
        //if (effectiveRunTime == other.effectiveRunTime) {
            //return 0;
        //}
        //return effectiveRunTime < other.effectiveRunTime ? -1 : 1;
    }

    
}

