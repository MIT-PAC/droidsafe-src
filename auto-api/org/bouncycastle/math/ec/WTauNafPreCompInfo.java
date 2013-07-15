package org.bouncycastle.math.ec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

class WTauNafPreCompInfo implements PreCompInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.943 -0400", hash_original_field = "D6A1A1B6C8FBFB169D1DB96C4390357A", hash_generated_field = "0B1D7C097FC49C575EEE3BE315994E63")

    private ECPoint.F2m[] preComp = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.943 -0400", hash_original_method = "8D247B0F1F1EEAB774C9DD19688CF835", hash_generated_method = "B1359D434B9010FCCDA6440C95D74DBB")
      WTauNafPreCompInfo(ECPoint.F2m[] preComp) {
        this.preComp = preComp;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.944 -0400", hash_original_method = "F3FA619DF98A2689238B8A15B3158B11", hash_generated_method = "B8FABF6635073D480C628CEC0BD1FAED")
    protected ECPoint.F2m[] getPreComp() {
        ECPoint.F2m[] varB4EAC82CA7396A68D541C85D26508E83_377357652 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_377357652 = preComp;
        varB4EAC82CA7396A68D541C85D26508E83_377357652.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_377357652;
        
        
    }

    
}

