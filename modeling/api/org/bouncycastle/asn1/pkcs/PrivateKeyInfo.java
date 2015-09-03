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


package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;






public class PrivateKeyInfo extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.173 -0500", hash_original_method = "C36D894A3F980F01CC8C9491B9C90C90", hash_generated_method = "996BC3280A59E209F1374536166549E3")
    
public static PrivateKeyInfo getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.175 -0500", hash_original_method = "AED8981A47421FC91BB6DCF469B47F98", hash_generated_method = "968C633AAB38619EA420F943C2C5B086")
    
public static PrivateKeyInfo getInstance(
        Object  obj)
    {
        if (obj instanceof PrivateKeyInfo)
        {
            return (PrivateKeyInfo)obj;
        }
        else if (obj != null)
        {
            return new PrivateKeyInfo(ASN1Sequence.getInstance(obj));
        }

        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.165 -0500", hash_original_field = "7886967E3CDDAACA3A448BA910CF08E7", hash_generated_field = "151696813A1AC2209490E3CAFBAEDC24")

    private DERObject               privKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.168 -0500", hash_original_field = "77AE1AC968895C7830B8ADE3B24ECA2A", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier     algId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.170 -0500", hash_original_field = "97283BA48C6E286545AA32C15A18B0EE", hash_generated_field = "621E004207975514450E4D4926271721")

    private ASN1Set                 attributes;
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.178 -0500", hash_original_method = "A30E81EA2AB5EF2B8533B5735A047E38", hash_generated_method = "ED5706101FCFCE43965C16AB012CDD63")
    
public PrivateKeyInfo(
        AlgorithmIdentifier algId,
        DERObject           privateKey)
    {
        this(algId, privateKey, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.181 -0500", hash_original_method = "94CFD25F02D1F3C4AA4CA24B118947E8", hash_generated_method = "C63E2DD58825223CB13AF72B2FB7FF46")
    
public PrivateKeyInfo(
        AlgorithmIdentifier algId,
        DERObject           privateKey,
        ASN1Set             attributes)
    {
        this.privKey = privateKey;
        this.algId = algId;
        this.attributes = attributes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.185 -0500", hash_original_method = "97D7CEF7A57CDA757D069637093B5F4D", hash_generated_method = "796E6A9E43C338321360018BBAB21F39")
    
public PrivateKeyInfo(
        ASN1Sequence  seq)
    {
        Enumeration e = seq.getObjects();

        BigInteger  version = ((DERInteger)e.nextElement()).getValue();
        if (version.intValue() != 0)
        {
            throw new IllegalArgumentException("wrong version for private key info");
        }

        algId = new AlgorithmIdentifier((ASN1Sequence)e.nextElement());

        try
        {
            ASN1InputStream         aIn = new ASN1InputStream(((ASN1OctetString)e.nextElement()).getOctets());

            privKey = aIn.readObject();
        }
        catch (IOException ex)
        {
            throw new IllegalArgumentException("Error recoverying private key from sequence");
        }
        
        if (e.hasMoreElements())
        {
           attributes = ASN1Set.getInstance((ASN1TaggedObject)e.nextElement(), false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.187 -0500", hash_original_method = "47532F5520D2937711F415E7F39EF8B8", hash_generated_method = "BCED03BC4375EE48DC08B032712FE68B")
    
public AlgorithmIdentifier getAlgorithmId()
    {
        return algId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.189 -0500", hash_original_method = "3451C7D0A2D2ACAC16D97B5B3003A0C1", hash_generated_method = "3359531016BE736608725C9B964BCA8D")
    
public DERObject getPrivateKey()
    {
        return privKey;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.191 -0500", hash_original_method = "2B5879FE48F35BA3284D87B378AFE5E1", hash_generated_method = "88749F298E39DB3FA6191BA8C9C90717")
    
public ASN1Set getAttributes()
    {
        return attributes;
    }

    /**
     * write out an RSA private key with its associated information
     * as described in PKCS8.
     * <pre>
     *      PrivateKeyInfo ::= SEQUENCE {
     *                              version Version,
     *                              privateKeyAlgorithm AlgorithmIdentifier {{PrivateKeyAlgorithms}},
     *                              privateKey PrivateKey,
     *                              attributes [0] IMPLICIT Attributes OPTIONAL 
     *                          }
     *      Version ::= INTEGER {v1(0)} (v1,...)
     *
     *      PrivateKey ::= OCTET STRING
     *
     *      Attributes ::= SET OF Attribute
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.194 -0500", hash_original_method = "7CF8276E9977E7549D144BD3BA353868", hash_generated_method = "2C034EF88286D3727AB0ED955C350EE1")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(new DERInteger(0));
        v.add(algId);
        v.add(new DEROctetString(privKey));

        if (attributes != null)
        {
            v.add(new DERTaggedObject(false, 0, attributes));
        }
        
        return new DERSequence(v);
    }

    
}

