package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class WTauNafPreCompInfo implements PreCompInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.504 -0400", hash_original_field = "D6A1A1B6C8FBFB169D1DB96C4390357A", hash_generated_field = "0B1D7C097FC49C575EEE3BE315994E63")

    private ECPoint.F2m[] preComp = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.505 -0400", hash_original_method = "8D247B0F1F1EEAB774C9DD19688CF835", hash_generated_method = "B1359D434B9010FCCDA6440C95D74DBB")
      WTauNafPreCompInfo(ECPoint.F2m[] preComp) {
        this.preComp = preComp;
        // ---------- Original Method ----------
        //this.preComp = preComp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.507 -0400", hash_original_method = "F3FA619DF98A2689238B8A15B3158B11", hash_generated_method = "ABFAA56221556F7E7AEB41C586DCCB99")
    protected ECPoint.F2m[] getPreComp() {
        ECPoint.F2m[] varB4EAC82CA7396A68D541C85D26508E83_1360265081 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1360265081 = preComp;
        varB4EAC82CA7396A68D541C85D26508E83_1360265081.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1360265081;
        // ---------- Original Method ----------
        //return preComp;
    }

    
}

