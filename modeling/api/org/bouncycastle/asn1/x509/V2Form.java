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


package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;






public class V2Form extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.951 -0500", hash_original_method = "6DBDB515804569573AB2ECBAC9118042", hash_generated_method = "53B112B0F7DB4B32EF17AD058F32911A")
    
public static V2Form getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.954 -0500", hash_original_method = "1A08FF8042785676B1B34224334725BF", hash_generated_method = "198913CF6287F1F259F87A7A5CE07218")
    
public static V2Form getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof V2Form)
        {
            return (V2Form)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new V2Form((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.945 -0500", hash_original_field = "27D5E6F2AF34AE0B03A90D9446FD0637", hash_generated_field = "27D5E6F2AF34AE0B03A90D9446FD0637")

    GeneralNames        issuerName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.947 -0500", hash_original_field = "BFE641AC9AE66327CCBC4859503216E4", hash_generated_field = "BFE641AC9AE66327CCBC4859503216E4")

    IssuerSerial        baseCertificateID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.949 -0500", hash_original_field = "0DFE757401959316759693C6B709966B", hash_generated_field = "0DFE757401959316759693C6B709966B")

    ObjectDigestInfo    objectDigestInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.956 -0500", hash_original_method = "58484080C9CD52E375DC7B3D30D61BD6", hash_generated_method = "4450E8808224929D1C8A5A04DD1E9086")
    
public V2Form(
        GeneralNames    issuerName)
    {
        this.issuerName = issuerName;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.959 -0500", hash_original_method = "A1182A2D0637CA133E8A6FD666F8BDBF", hash_generated_method = "A1C048D36149A1C39812FB35104C50AA")
    
public V2Form(
        ASN1Sequence seq)
    {
        if (seq.size() > 3)
        {
            throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        }
        
        int    index = 0;

        if (!(seq.getObjectAt(0) instanceof ASN1TaggedObject))
        {
            index++;
            this.issuerName = GeneralNames.getInstance(seq.getObjectAt(0));
        }

        for (int i = index; i != seq.size(); i++)
        {
            ASN1TaggedObject o = ASN1TaggedObject.getInstance(seq.getObjectAt(i));
            if (o.getTagNo() == 0)
            {
                baseCertificateID = IssuerSerial.getInstance(o, false);
            }
            else if (o.getTagNo() == 1)
            {
                objectDigestInfo = ObjectDigestInfo.getInstance(o, false);
            }
            else 
            {
                throw new IllegalArgumentException("Bad tag number: "
                        + o.getTagNo());
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.963 -0500", hash_original_method = "55884F30CB8A32C82BBC3BF8E06EF566", hash_generated_method = "120DEAF0D7BC263AE54138C020E30C18")
    
public GeneralNames getIssuerName()
    {
        return issuerName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.965 -0500", hash_original_method = "0056368CFDBAD05E126455DF61F0B2E7", hash_generated_method = "462CAEFE3157CC593122F67181A49FAD")
    
public IssuerSerial getBaseCertificateID()
    {
        return baseCertificateID;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.967 -0500", hash_original_method = "BF432F04B889EC14E618C49342356E7A", hash_generated_method = "03B6AC409A1C670BCF9E6988AD64A7E6")
    
public ObjectDigestInfo getObjectDigestInfo()
    {
        return objectDigestInfo;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *  V2Form ::= SEQUENCE {
     *       issuerName            GeneralNames  OPTIONAL,
     *       baseCertificateID     [0] IssuerSerial  OPTIONAL,
     *       objectDigestInfo      [1] ObjectDigestInfo  OPTIONAL
     *         -- issuerName MUST be present in this profile
     *         -- baseCertificateID and objectDigestInfo MUST NOT
     *         -- be present in this profile
     *  }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.970 -0500", hash_original_method = "136E61B408FA241B2CCB57655BDD036B", hash_generated_method = "67DDC8F412CC3F1BF337AE2306991C8D")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        if (issuerName != null)
        {
            v.add(issuerName);
        }

        if (baseCertificateID != null)
        {
            v.add(new DERTaggedObject(false, 0, baseCertificateID));
        }

        if (objectDigestInfo != null)
        {
            v.add(new DERTaggedObject(false, 1, objectDigestInfo));
        }

        return new DERSequence(v);
    }

    
}

