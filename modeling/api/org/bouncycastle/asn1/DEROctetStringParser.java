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
import java.io.InputStream;

public class DEROctetStringParser implements ASN1OctetStringParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.977 -0500", hash_original_field = "6E873ACD10B938593CC8F8D39D558B83", hash_generated_field = "B52609448A7FFECE6579BC5E2EF825EF")

    private DefiniteLengthInputStream stream;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.980 -0500", hash_original_method = "18F90E7C8910F20983A0E830634FAC28", hash_generated_method = "18F90E7C8910F20983A0E830634FAC28")
    
DEROctetStringParser(
        DefiniteLengthInputStream stream)
    {
        this.stream = stream;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.982 -0500", hash_original_method = "18DABC7937263BD98D8856E466803052", hash_generated_method = "20CB6BC79A377AB9E4DA23283D861E30")
    
public InputStream getOctetStream()
    {
        return stream;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.984 -0500", hash_original_method = "61774CD0E60B254BC7D8FDAA497BBCE4", hash_generated_method = "47AE8BF86965397B7E6A20A00A672C20")
    
public DERObject getLoadedObject()
        throws IOException
    {
        return new DEROctetString(stream.toByteArray());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.987 -0500", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "9790CD21B734F9781C0411A119675869")
    
public DERObject getDERObject()
    {
        try
        {
            return getLoadedObject();
        }
        catch (IOException e)
        {
            throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }
    
}

