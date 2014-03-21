package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.accounts.Account;
import android.os.Bundle;
import android.os.SystemClock;

public class SyncOperation implements Comparable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.585 -0500", hash_original_method = "C438A0900176804C7624F53E8C780F9C", hash_generated_method = "301CA5FDC40B5374F36562F17AAD18CF")
    
public static void extrasToStringBuilder(Bundle bundle, StringBuilder sb) {
        sb.append("[");
        for (String key : bundle.keySet()) {
            sb.append(key).append("=").append(bundle.get(key)).append(" ");
        }
        sb.append("]");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.539 -0500", hash_original_field = "9D630FBF90643CC60961CCF48FECCA0B", hash_generated_field = "48DCC252B03FBCBEDBDE2E34968668DF")

    public  Account account;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.541 -0500", hash_original_field = "ADDF5490BF1C10ABAFE6E2B2AE40316C", hash_generated_field = "C83A11803715B792413E3838747138A5")

    public int syncSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.543 -0500", hash_original_field = "246C0F9F2C0270494BEB2E9C6833888B", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public String authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.546 -0500", hash_original_field = "45DFE1195B1606D7F5BD6BE7998F9A8A", hash_generated_field = "2A4062D07AF43598570DB28FDD410734")

    public  boolean allowParallelSyncs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.548 -0500", hash_original_field = "6F80A5414A80FF69E92A0BD3C0E073DC", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

    public Bundle extras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.550 -0500", hash_original_field = "FFE7EE17DFA37A68070A0F0495753B29", hash_generated_field = "9594FABAACFBD659AE1FC0B0C9AAFC8C")

    public  String key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.552 -0500", hash_original_field = "EC6B54BF18520D797602F1BBDE1650C0", hash_generated_field = "68164F2B36FE066E3756D3D9D1292331")

    public long earliestRunTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.555 -0500", hash_original_field = "D7DC8099D62435877828BDBBACCABD83", hash_generated_field = "510B55928F79538B5EE0DF2AD1627823")

    public boolean expedited;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.556 -0500", hash_original_field = "2383B59275171DE50F798A0F6AAD89FE", hash_generated_field = "042CEA90778ADF37345A881ED9FBF28F")

    public SyncStorageEngine.PendingOperation pendingOperation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.559 -0500", hash_original_field = "8E727FACC240B4CBB28D4C5185DD5652", hash_generated_field = "350EB491BFFA87FD3A84E6B5B95316CD")

    public Long backoff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.560 -0500", hash_original_field = "FF2672CE15194FA4F169DAC34CF8A869", hash_generated_field = "34D6FB90E0771C5EFE225745790D4357")

    public long delayUntil;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.563 -0500", hash_original_field = "FA86B3EE4952CB34D5C90B407D5F63C9", hash_generated_field = "1A551681C0C70DD5BB10AF927DDA36A6")

    public long effectiveRunTime;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.566 -0500", hash_original_method = "B06968042D7BA4644F7F8CC6E7EA9B45", hash_generated_method = "1B0ADA8A7235506A9E49741D1120B79A")
    
public SyncOperation(Account account, int source, String authority, Bundle extras,
            long delayInMs, long backoff, long delayUntil, boolean allowParallelSyncs) {
        this.account = account;
        this.syncSource = source;
        this.authority = authority;
        this.allowParallelSyncs = allowParallelSyncs;
        this.extras = new Bundle(extras);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_UPLOAD);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_MANUAL);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_DO_NOT_RETRY);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_EXPEDITED);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS);
        this.delayUntil = delayUntil;
        this.backoff = backoff;
        final long now = SystemClock.elapsedRealtime();
        if (delayInMs < 0) {
            this.expedited = true;
            this.earliestRunTime = now;
        } else {
            this.expedited = false;
            this.earliestRunTime = now + delayInMs;
        }
        updateEffectiveRunTime();
        this.key = toKey();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.571 -0500", hash_original_method = "BE085BAA1CD2B4B4487382D0022F31D7", hash_generated_method = "BE085BAA1CD2B4B4487382D0022F31D7")
    
SyncOperation(SyncOperation other) {
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
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.568 -0500", hash_original_method = "432EE1A094EFB9968E7A50DA8ACAC133", hash_generated_method = "F87A90D4C88D1B1D1102E8073C29E9DC")
    
private void removeFalseExtra(String extraName) {
        if (!extras.getBoolean(extraName, false)) {
            extras.remove(extraName);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.573 -0500", hash_original_method = "DD55706005FD16094E01DF90CF28D99E", hash_generated_method = "3A3FC0526555367470556D8852FC15EF")
    
public String toString() {
        return dump(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.576 -0500", hash_original_method = "47737E917226B122B7AA0C5B23AFE223", hash_generated_method = "0983571DE6410CA45A5CFBD0D824EC7C")
    
public String dump(boolean useOneLine) {
        StringBuilder sb = new StringBuilder();
        sb.append(account.name);
        sb.append(" (" + account.type + ")");
        sb.append(", " + authority);
        sb.append(", ");
        sb.append(SyncStorageEngine.SOURCES[syncSource]);
        sb.append(", earliestRunTime " + earliestRunTime);
        if (expedited) {
            sb.append(", EXPEDITED");
        }
        if (!useOneLine && !extras.keySet().isEmpty()) {
            sb.append("\n    ");
            extrasToStringBuilder(extras, sb);
        }
        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.578 -0500", hash_original_method = "0CBE4B28609593623A1CB97001F0DBD2", hash_generated_method = "DB68EE8C93B19D8DCAD3E5B9D73CDED6")
    
public boolean isInitialization() {
        return extras.getBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.580 -0500", hash_original_method = "A202EE0B500962365FD241C616148E63", hash_generated_method = "84B4ADDC6C50A31067BD66C77EEEFB16")
    
public boolean ignoreBackoff() {
        return extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, false);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.582 -0500", hash_original_method = "557BF419234DEC0AF5F90553488D23D9", hash_generated_method = "E8A08269EBFFB46529DD6D581C186DAF")
    
private String toKey() {
        StringBuilder sb = new StringBuilder();
        sb.append("authority: ").append(authority);
        sb.append(" account {name=" + account.name + ", type=" + account.type + "}");
        sb.append(" extras: ");
        extrasToStringBuilder(extras, sb);
        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.587 -0500", hash_original_method = "0B30B519DCD273F2706D3A8819933F53", hash_generated_method = "F2F8CC66C2F8285A165000B90139F95B")
    
public void updateEffectiveRunTime() {
        effectiveRunTime = ignoreBackoff()
                ? earliestRunTime
                : Math.max(
                    Math.max(earliestRunTime, delayUntil),
                    backoff);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.589 -0500", hash_original_method = "94E2F05BFAF6BA397C21B12E8FAD132F", hash_generated_method = "D42289A8E926FA909CB715771550D0FA")
    
public int compareTo(Object o) {
        SyncOperation other = (SyncOperation)o;

        if (expedited != other.expedited) {
            return expedited ? -1 : 1;
        }

        if (effectiveRunTime == other.effectiveRunTime) {
            return 0;
        }

        //return effectiveRunTime < other.effectiveRunTime ? -1 : 1;
        return (int)(effectiveRunTime + other.effectiveRunTime + getTaintInt() + o.getTaintInt()); 
    }
    
}

