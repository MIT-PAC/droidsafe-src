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
import java.io.IOException;

public class DEROctetString extends ASN1OctetString {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.166 -0500", hash_original_method = "350FB83D68A1171ABC71A16DF9581EB3", hash_generated_method = "15E0F1074B721C64CAEB116E41439E89")
    
static void encode(
        DEROutputStream derOut,
        byte[]          bytes)
        throws IOException
    {
        derOut.writeEncoded(DERTags.OCTET_STRING, bytes);
    }
    /**
     * @param string the octets making up the octet string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.159 -0500", hash_original_method = "3336CFEFF4BF2C133797CC5732C4278D", hash_generated_method = "4D36C4A1D9E980E82AB3D65CB73BB2F1")
    
public DEROctetString(
        byte[]  string)
    {
        super(string);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.162 -0500", hash_original_method = "233295F4410DDA4CBE3EEAAA15D96B59", hash_generated_method = "5A32336E7D7C381E6E78AF92AA7FF936")
    
public DEROctetString(
        DEREncodable  obj)
    {
        super(obj);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.164 -0500", hash_original_method = "88699FAFA7E37B1C694783679D50E3CD", hash_generated_method = "88699FAFA7E37B1C694783679D50E3CD")
    
void encode(
        DEROutputStream out)
        throws IOException
    {
        out.writeEncoded(OCTET_STRING, string);
    }
    
}

