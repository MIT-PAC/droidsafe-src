package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



class WTauNafPreCompInfo implements PreCompInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.739 -0500", hash_original_field = "BE8D77B49EC519BEE0E5C07DB7A56D8B", hash_generated_field = "0B1D7C097FC49C575EEE3BE315994E63")

    private ECPoint.F2m[] preComp = null;

    /**
     * Constructor for <code>WTauNafPreCompInfo</code>
     * @param preComp Array holding the precomputed <code>ECPoint.F2m</code>s
     * used for the WTNAF multiplication in <code>
     * {@link org.bouncycastle.math.ec.multiplier.WTauNafMultiplier.multiply()
     * WTauNafMultiplier.multiply()}</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.740 -0500", hash_original_method = "8D247B0F1F1EEAB774C9DD19688CF835", hash_generated_method = "8D247B0F1F1EEAB774C9DD19688CF835")
    WTauNafPreCompInfo(ECPoint.F2m[] preComp)
    {
        this.preComp = preComp;
    }

    /**
     * @return the array holding the precomputed <code>ECPoint.F2m</code>s
     * used for the WTNAF multiplication in <code>
     * {@link org.bouncycastle.math.ec.multiplier.WTauNafMultiplier.multiply()
     * WTauNafMultiplier.multiply()}</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.741 -0500", hash_original_method = "F3FA619DF98A2689238B8A15B3158B11", hash_generated_method = "9AFA02D3EA6B63853FE9C31B4F7AB260")
    protected ECPoint.F2m[] getPreComp()
    {
        return preComp;
    }

    
}

