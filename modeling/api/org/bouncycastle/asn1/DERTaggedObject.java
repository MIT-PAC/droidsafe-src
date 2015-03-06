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

public class DERTaggedObject extends ASN1TaggedObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.509 -0500", hash_original_field = "1507DFE3BF5B3D43C3BD2E67A32D2AD2", hash_generated_field = "DC855D7D38FB2BD504042CC7CEABD828")

    private static final byte[] ZERO_BYTES = new byte[0];

    /**
     * @param tagNo the tag number for this object.
     * @param obj the tagged object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.512 -0500", hash_original_method = "B8C39F3F8493AE66929508E836F6CEF7", hash_generated_method = "8C0DB9200D2B6E91267DF068EF8481BD")
    
public DERTaggedObject(
        int             tagNo,
        DEREncodable    obj)
    {
        super(tagNo, obj);
    }

    /**
     * @param explicit true if an explicitly tagged object.
     * @param tagNo the tag number for this object.
     * @param obj the tagged object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.514 -0500", hash_original_method = "D15475FEA6616F6A5D6AAE500D0E135A", hash_generated_method = "58F57E5CBCA81E0A7F44F5BD3CA3B04A")
    
public DERTaggedObject(
        boolean         explicit,
        int             tagNo,
        DEREncodable    obj)
    {
        super(explicit, tagNo, obj);
    }

    /**
     * create an implicitly tagged object that contains a zero
     * length sequence.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.517 -0500", hash_original_method = "14B57626E7341DE57616D6DE76633AEC", hash_generated_method = "E7176FCA346CD988C0AA6C947270DFB3")
    
public DERTaggedObject(
        int             tagNo)
    {
        super(false, tagNo, new DERSequence());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.520 -0500", hash_original_method = "B5277AF27C85DE4A4669302802507303", hash_generated_method = "90565862AA4F3BE71662FB46ACA23367")
    
void encode(
        DEROutputStream  out)
        throws IOException
    {
        if (!empty)
        {
            byte[] bytes = obj.getDERObject().getEncoded(DER);

            if (explicit)
            {
                out.writeEncoded(CONSTRUCTED | TAGGED, tagNo, bytes);
            }
            else
            {
                //
                // need to mark constructed types...
                //
                int flags;
                if ((bytes[0] & CONSTRUCTED) != 0)
                {
                    flags = CONSTRUCTED | TAGGED;
                }
                else
                {
                    flags = TAGGED;
                }

                out.writeTag(flags, tagNo);
                out.write(bytes, 1, bytes.length - 1);
            }
        }
        else
        {
            out.writeEncoded(CONSTRUCTED | TAGGED, tagNo, ZERO_BYTES);
        }
    }
}

