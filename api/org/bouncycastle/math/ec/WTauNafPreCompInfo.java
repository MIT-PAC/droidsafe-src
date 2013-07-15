package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

class WTauNafPreCompInfo implements PreCompInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.691 -0400", hash_original_field = "D6A1A1B6C8FBFB169D1DB96C4390357A", hash_generated_field = "0B1D7C097FC49C575EEE3BE315994E63")

    private ECPoint.F2m[] preComp = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.692 -0400", hash_original_method = "8D247B0F1F1EEAB774C9DD19688CF835", hash_generated_method = "B1359D434B9010FCCDA6440C95D74DBB")
      WTauNafPreCompInfo(ECPoint.F2m[] preComp) {
        this.preComp = preComp;
        // ---------- Original Method ----------
        //this.preComp = preComp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.692 -0400", hash_original_method = "F3FA619DF98A2689238B8A15B3158B11", hash_generated_method = "801A2302487536086A80E6F3C7C54658")
    protected ECPoint.F2m[] getPreComp() {
ECPoint.F2m[] var859A8A67374BCAAC598F1E4AD75AF98D_154401367 =         preComp;
        var859A8A67374BCAAC598F1E4AD75AF98D_154401367.addTaint(taint);
        return var859A8A67374BCAAC598F1E4AD75AF98D_154401367;
        // ---------- Original Method ----------
        //return preComp;
    }

    
}

