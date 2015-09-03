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


package org.bouncycastle.jce.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.spec.KeySpec;






public class ECKeySpec implements KeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.823 -0500", hash_original_field = "A7A02EC26949D55D933B940037565E9D", hash_generated_field = "82AE92EF7773AA5ED9F82BE71242C394")

    private ECParameterSpec     spec;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.826 -0500", hash_original_method = "26671DF5D8347FB8E2181E6D1CD58161", hash_generated_method = "27E9FDE7237BD507ABAD0F67C34E5F24")
    
protected ECKeySpec(
        ECParameterSpec spec)
    {
        this.spec = spec;
    }

    /**
     * return the domain parameters for the curve
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.828 -0500", hash_original_method = "CAD2937E5922AD2A7FB69B4EF0F6DA5F", hash_generated_method = "24E307A7A6EB43935894FA56E34FA2C4")
    
public ECParameterSpec getParams()
    {
        return spec;
    }

    
}

