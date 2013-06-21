package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public class NetworkConfig {
    public String name;
    public int type;
    public int radio;
    public int priority;
    public boolean dependencyMet;
    public int restoreTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.040 -0400", hash_original_method = "93F95FF083791513BC80A25A69B4AF8A", hash_generated_method = "F916C918A4743B13ABA9B70B13EBE5ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkConfig(String init) {
        dsTaint.addTaint(init);
        String fragments[];
        fragments = init.split(",");
        name = fragments[0].trim().toLowerCase();
        type = Integer.parseInt(fragments[1]);
        radio = Integer.parseInt(fragments[2]);
        priority = Integer.parseInt(fragments[3]);
        restoreTime = Integer.parseInt(fragments[4]);
        dependencyMet = Boolean.parseBoolean(fragments[5]);
        // ---------- Original Method ----------
        //String fragments[] = init.split(",");
        //name = fragments[0].trim().toLowerCase();
        //type = Integer.parseInt(fragments[1]);
        //radio = Integer.parseInt(fragments[2]);
        //priority = Integer.parseInt(fragments[3]);
        //restoreTime = Integer.parseInt(fragments[4]);
        //dependencyMet = Boolean.parseBoolean(fragments[5]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.041 -0400", hash_original_method = "474B729266EEB37673AA204F699AE5C3", hash_generated_method = "66A1FF9EFA5B23CAE63BB8E65315CFA0")
    @DSModeled(DSC.SAFE)
    public boolean isDefault() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (type == radio);
    }

    
}

