package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.accounts.Account;
import android.os.Bundle;
import android.os.SystemClock;

public class SyncOperation implements Comparable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.176 -0400", hash_original_field = "E268443E43D93DAB7EBEF303BBE9642F", hash_generated_field = "48DCC252B03FBCBEDBDE2E34968668DF")

    public Account account;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.176 -0400", hash_original_field = "C4B6C45B08DE8968EEA91097B03482FE", hash_generated_field = "C83A11803715B792413E3838747138A5")

    public int syncSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.176 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.176 -0400", hash_original_field = "577E05B3572C976DAF60C9783F6204CF", hash_generated_field = "2A4062D07AF43598570DB28FDD410734")

    public boolean allowParallelSyncs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.176 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

    public Bundle extras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.176 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "9594FABAACFBD659AE1FC0B0C9AAFC8C")

    public String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.176 -0400", hash_original_field = "6F9D6D4E401653CC26112A3D37E00CC7", hash_generated_field = "68164F2B36FE066E3756D3D9D1292331")

    public long earliestRunTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.176 -0400", hash_original_field = "7959CC84448D1E4ADCF2D189917AB5F5", hash_generated_field = "510B55928F79538B5EE0DF2AD1627823")

    public boolean expedited;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.177 -0400", hash_original_field = "3E906CFD221D909B8CD8FFA1F5E84248", hash_generated_field = "042CEA90778ADF37345A881ED9FBF28F")

    public SyncStorageEngine.PendingOperation pendingOperation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.177 -0400", hash_original_field = "F22B97418C1435B3B24500AEB4A7110D", hash_generated_field = "350EB491BFFA87FD3A84E6B5B95316CD")

    public Long backoff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.177 -0400", hash_original_field = "77D196B208370F23D20E064B8B1B5DA0", hash_generated_field = "34D6FB90E0771C5EFE225745790D4357")

    public long delayUntil;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.177 -0400", hash_original_field = "CC867130D90FEF804B3067067C71AD2C", hash_generated_field = "1A551681C0C70DD5BB10AF927DDA36A6")

    public long effectiveRunTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.178 -0400", hash_original_method = "B06968042D7BA4644F7F8CC6E7EA9B45", hash_generated_method = "A4B1619EC049CA574D41847DEB89341C")
    public  SyncOperation(Account account, int source, String authority, Bundle extras,
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
        {
            this.expedited = true;
            this.earliestRunTime = now;
        } 
        {
            this.expedited = false;
            this.earliestRunTime = now + delayInMs;
        } 
        updateEffectiveRunTime();
        this.key = toKey();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.179 -0400", hash_original_method = "BE085BAA1CD2B4B4487382D0022F31D7", hash_generated_method = "44AF7038BB0152FE7BD44E3BDEC3C97C")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.179 -0400", hash_original_method = "432EE1A094EFB9968E7A50DA8ACAC133", hash_generated_method = "0768A711E4EAEFB2C8222666F3ED311B")
    private void removeFalseExtra(String extraName) {
        {
            boolean varA63D76AF566EBA015E3C2D765EABECE6_1498031799 = (!extras.getBoolean(extraName, false));
            {
                extras.remove(extraName);
            } 
        } 
        addTaint(extraName.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.181 -0400", hash_original_method = "DD55706005FD16094E01DF90CF28D99E", hash_generated_method = "B36B585DB197331967AE453EC718A43B")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_834039017 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_834039017 = dump(true);
        varB4EAC82CA7396A68D541C85D26508E83_834039017.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_834039017;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.182 -0400", hash_original_method = "47737E917226B122B7AA0C5B23AFE223", hash_generated_method = "959910AEF6E7B2855B51214264078361")
    public String dump(boolean useOneLine) {
        String varB4EAC82CA7396A68D541C85D26508E83_1751659187 = null; 
        StringBuilder sb = new StringBuilder();
        sb.append(account.name);
        sb.append(" (" + account.type + ")");
        sb.append(", " + authority);
        sb.append(", ");
        sb.append(SyncStorageEngine.SOURCES[syncSource]);
        sb.append(", earliestRunTime " + earliestRunTime);
        {
            sb.append(", EXPEDITED");
        } 
        {
            boolean var40EB6F6CF4ABE63E4CA23EACF2DEA578_253015977 = (!useOneLine && !extras.keySet().isEmpty());
            {
                sb.append("\n    ");
                extrasToStringBuilder(extras, sb);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1751659187 = sb.toString();
        addTaint(useOneLine);
        varB4EAC82CA7396A68D541C85D26508E83_1751659187.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1751659187;
        
        
        
        
        
        
        
        
        
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.183 -0400", hash_original_method = "0CBE4B28609593623A1CB97001F0DBD2", hash_generated_method = "ABE34CF23007676C8A9742C92E7BE2B7")
    public boolean isInitialization() {
        boolean var15675A814E24816554E062EC589D1FA0_2104404529 = (extras.getBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, false));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1093966519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1093966519;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.183 -0400", hash_original_method = "A202EE0B500962365FD241C616148E63", hash_generated_method = "817EA989F2DE07F1FD318F53F112A2C8")
    public boolean ignoreBackoff() {
        boolean var11F18930ED342CB5DB82C8732826050E_544320061 = (extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, false));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112218985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112218985;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.184 -0400", hash_original_method = "557BF419234DEC0AF5F90553488D23D9", hash_generated_method = "621EFE28A224BA470791A711E9E54897")
    private String toKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1207688815 = null; 
        StringBuilder sb = new StringBuilder();
        sb.append("authority: ").append(authority);
        sb.append(" account {name=" + account.name + ", type=" + account.type + "}");
        sb.append(" extras: ");
        extrasToStringBuilder(extras, sb);
        varB4EAC82CA7396A68D541C85D26508E83_1207688815 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1207688815.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1207688815;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void extrasToStringBuilder(Bundle bundle, StringBuilder sb) {
        sb.append("[");
        for (String key : bundle.keySet()) {
            sb.append(key).append("=").append(bundle.get(key)).append(" ");
        }
        sb.append("]");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.185 -0400", hash_original_method = "0B30B519DCD273F2706D3A8819933F53", hash_generated_method = "3470C2C3EB73D929C84713285D0EFEAE")
    public void updateEffectiveRunTime() {
        effectiveRunTime = ignoreBackoff()
                ? earliestRunTime
                : Math.max(
                    Math.max(earliestRunTime, delayUntil),
                    backoff);
        
        
                
                
                    
                    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.185 -0400", hash_original_method = "94E2F05BFAF6BA397C21B12E8FAD132F", hash_generated_method = "2DE758E30EB4AFD5230C3D5DACA5C027")
    public int compareTo(Object o) {
        SyncOperation other = (SyncOperation)o;
        addTaint(o.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586089013 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586089013;
        
        
        
            
        
        
            
        
        
    }

    
}

