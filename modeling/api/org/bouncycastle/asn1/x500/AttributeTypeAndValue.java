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


package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class AttributeTypeAndValue extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.564 -0500", hash_original_method = "04CC9AF5779AF8FA3BF3914EFE87D41E", hash_generated_method = "A5BBB0999D58A21C7EEB0C2D3A128202")
    
public static AttributeTypeAndValue getInstance(Object o)
    {
        if (o instanceof AttributeTypeAndValue)
        {
            return (AttributeTypeAndValue)o;
        }
        else if (o != null)
        {
            return new AttributeTypeAndValue(ASN1Sequence.getInstance(o));
        }

        throw new IllegalArgumentException("null value in getInstance()");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.556 -0500", hash_original_field = "9DF19847900DF870B7403A593B4DD57A", hash_generated_field = "E22429FEAB7082A9C22F35F915934F74")

    private ASN1ObjectIdentifier type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.559 -0500", hash_original_field = "E7E9D5AACDA7B74D4DC8FE1188D3BCCE", hash_generated_field = "65616B4EF69DB0ADA11533A065E6A511")

    private ASN1Encodable       value;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.562 -0500", hash_original_method = "15E850D5749E9732B50BB178D64D47F4", hash_generated_method = "9CB7F2B44F1AFAC6F0F8D1058779E2A2")
    
private AttributeTypeAndValue(ASN1Sequence seq)
    {
        type = (ASN1ObjectIdentifier)seq.getObjectAt(0);
        value = (ASN1Encodable)seq.getObjectAt(1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.567 -0500", hash_original_method = "455B7405955E1E537DECB7E0764A59EF", hash_generated_method = "EACD825B5E9E2AF2FC8458BC09C22744")
    
public AttributeTypeAndValue(
        ASN1ObjectIdentifier type,
        ASN1Encodable value)
    {
        this.type = type;
        this.value = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.569 -0500", hash_original_method = "55F928B5E605E2163AD3D5D479C3E067", hash_generated_method = "2B8E364443EA5B5737B2EAE6F188D4EB")
    
public ASN1ObjectIdentifier getType()
    {
        return type;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.571 -0500", hash_original_method = "C951B7A7C5D7EABF1F828E9D0FE876A9", hash_generated_method = "72F9E6E1327BC9585F507E0F48FABC28")
    
public ASN1Encodable getValue()
    {
        return value;
    }

    /**
     * <pre>
     * AttributeTypeAndValue ::= SEQUENCE {
     *           type         OBJECT IDENTIFIER,
     *           value        ANY DEFINED BY type }
     * </pre>
     * @return a basic ASN.1 object representation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.573 -0500", hash_original_method = "5081032FA8CA5E98B22B4FF57246FC38", hash_generated_method = "3489D220516747251940791B6C462AEA")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(type);
        v.add(value);

        return new DERSequence(v);
    }
    
}

