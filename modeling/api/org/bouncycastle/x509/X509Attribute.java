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


package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.x509.Attribute;

public class X509Attribute extends ASN1Encodable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.311 -0500", hash_original_field = "078373DB546E20C4F10604687E295777", hash_generated_field = "078373DB546E20C4F10604687E295777")

    Attribute    attr;
    
    /**
     * @param at an object representing an attribute.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.313 -0500", hash_original_method = "CE4AB458669C1421E9AF493051F17B5E", hash_generated_method = "CE4AB458669C1421E9AF493051F17B5E")
    
X509Attribute(
        ASN1Encodable   at)
    {
        this.attr = Attribute.getInstance(at);
    }

    /**
     * Create an X.509 Attribute with the type given by the passed in oid and
     * the value represented by an ASN.1 Set containing value.
     * 
     * @param oid type of the attribute
     * @param value value object to go into the atribute's value set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.316 -0500", hash_original_method = "F2072CEA8EE053AA2B225A50B1411CAE", hash_generated_method = "BE8E78E609316D86F08C60BBCC6156DE")
    
public X509Attribute(
        String          oid,
        ASN1Encodable   value)
    {
        this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
    }
    
    /**
     * Create an X.59 Attribute with the type given by the passed in oid and the
     * value represented by an ASN.1 Set containing the objects in value.
     * 
     * @param oid type of the attribute
     * @param value vector of values to go in the attribute's value set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.318 -0500", hash_original_method = "7A2D44AF2F579D4A5E25B4BDA18E068A", hash_generated_method = "EF6AF958553B22C2771FC739F823DDA7")
    
public X509Attribute(
        String              oid,
        ASN1EncodableVector value)
    {
        this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.320 -0500", hash_original_method = "EBAE76CB59DDB3FF6797DC91E3573A47", hash_generated_method = "A836F73DB026760A33E357FEB21C8738")
    
public String getOID()
    {
        return attr.getAttrType().getId();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.323 -0500", hash_original_method = "BC207D0C6A8D635D2F61723C6B9C7E5D", hash_generated_method = "8F8E33275E42F7AEF50520C14FE0FA3E")
    
public ASN1Encodable[] getValues()
    {
        ASN1Set         s = attr.getAttrValues();
        ASN1Encodable[] values = new ASN1Encodable[s.size()];
        
        for (int i = 0; i != s.size(); i++)
        {
            values[i] = (ASN1Encodable)s.getObjectAt(i);
        }
        
        return values;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.325 -0500", hash_original_method = "B86A9DDF1DB3AD0B2C8F07C01CCF4C19", hash_generated_method = "B8C1ED4AD5AE4BD497F6B481A16077FA")
    
public DERObject toASN1Object()
    {
        return attr.toASN1Object();
    }
    
}

