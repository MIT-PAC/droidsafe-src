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
import java.math.BigInteger;




class ZTauElement {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.270 -0500", hash_original_field = "367BB64C89A765D82EC09429D3685246", hash_generated_field = "40CFD1A249FCA5B191A31B3219FCE18D")

    public  BigInteger u;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.272 -0500", hash_original_field = "9271870F0C533F0A6C4B245F62F66A8F", hash_generated_field = "4AF300B5ED0FE2C906C983063C9150AB")

    public  BigInteger v;

    /**
     * Constructor for an element <code>&lambda;</code> of
     * <code><b>Z</b>[&tau;]</code>.
     * @param u The &quot;real&quot; part of <code>&lambda;</code>.
     * @param v The &quot;<code>&tau;</code>-adic&quot; part of
     * <code>&lambda;</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.275 -0500", hash_original_method = "A3D4CB97AD018D8DBE3665C338C0704B", hash_generated_method = "C6C0F34D8B6AB33D3A486244B5BA3F19")
    
public ZTauElement(BigInteger u, BigInteger v)
    {
        this.u = u;
        this.v = v;
    }

    
}

