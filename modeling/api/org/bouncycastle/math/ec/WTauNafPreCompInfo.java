/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



class WTauNafPreCompInfo implements PreCompInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.845 -0500", hash_original_field = "BE8D77B49EC519BEE0E5C07DB7A56D8B", hash_generated_field = "0B1D7C097FC49C575EEE3BE315994E63")

    private ECPoint.F2m[] preComp = null;

    /**
     * Constructor for <code>WTauNafPreCompInfo</code>
     * @param preComp Array holding the precomputed <code>ECPoint.F2m</code>s
     * used for the WTNAF multiplication in <code>
     * {@link org.bouncycastle.math.ec.multiplier.WTauNafMultiplier.multiply()
     * WTauNafMultiplier.multiply()}</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.848 -0500", hash_original_method = "8D247B0F1F1EEAB774C9DD19688CF835", hash_generated_method = "8D247B0F1F1EEAB774C9DD19688CF835")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.850 -0500", hash_original_method = "F3FA619DF98A2689238B8A15B3158B11", hash_generated_method = "9AFA02D3EA6B63853FE9C31B4F7AB260")
    
protected ECPoint.F2m[] getPreComp()
    {
        return preComp;
    }

    
}

