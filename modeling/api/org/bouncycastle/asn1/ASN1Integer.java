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


package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

public class ASN1Integer extends DERInteger {
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.921 -0500", hash_original_method = "613C01CE307AF3B490E97733AD3FE791", hash_generated_method = "613C01CE307AF3B490E97733AD3FE791")
    
ASN1Integer(byte[] bytes)
    {
        super(bytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.924 -0500", hash_original_method = "CB189D129CFECCC017D2178A0D362A4E", hash_generated_method = "A54C808ECDFD51FFF97BE5F456F6474F")
    
public ASN1Integer(BigInteger value)
    {
        super(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.926 -0500", hash_original_method = "DB40B6D8EC54F98D809A693D20FD592A", hash_generated_method = "489794C0EF5847BA66B577BA4FF57A1F")
    
public ASN1Integer(int value)
    {
        super(value);
    }
    
}

