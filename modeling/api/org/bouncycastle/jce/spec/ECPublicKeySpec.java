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
import org.bouncycastle.math.ec.ECPoint;






public class ECPublicKeySpec extends ECKeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.747 -0500", hash_original_field = "B639ECC6DF5B6C2001EEBC2714C3EDEB", hash_generated_field = "190FD5BD9908F6C1ABFEFC9764DEAE12")

    private ECPoint    q;

    /**
     * base constructor
     *
     * @param q the public point on the curve.
     * @param spec the domain parameters for the curve.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.750 -0500", hash_original_method = "1E18973C74B180C46739C7EAE31BBB7B", hash_generated_method = "3A2D71AEC332982B8B2221A1DEBB49C8")
    
public ECPublicKeySpec(
        ECPoint         q,
        ECParameterSpec spec)
    {
        super(spec);

        this.q = q;
    }

    /**
     * return the public point q
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.752 -0500", hash_original_method = "A7464FB9BEF133E2EB393CD87C3AFDA4", hash_generated_method = "125EC69B3651E626D0E73C8BE7124D18")
    
public ECPoint getQ()
    {
        return q;
    }

    
}

