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


package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;






public class X9ECParameters extends ASN1Encodable implements X9ObjectIdentifiers {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.097 -0500", hash_original_field = "8DD5DDCC4ACCF4574F580FF26B34E830", hash_generated_field = "A2EFE0CE5423F8076AF20D5B76F7D97A")

    private static final BigInteger   ONE = BigInteger.valueOf(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.100 -0500", hash_original_field = "541D95EB39FDD0674E273F2F406A3B8A", hash_generated_field = "161E0CD2A331703CED55991AA7670409")


    private X9FieldID           fieldID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.102 -0500", hash_original_field = "704A3581F062D90BBFC67E94998B89B2", hash_generated_field = "D4FD3D236F6822F3201F264EA949068E")

    private ECCurve             curve;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.104 -0500", hash_original_field = "B6F59EB5366D6E35184E3BC5DB947C8F", hash_generated_field = "1F461AF19CABD1B00959F9F3AD8297A2")

    private ECPoint             g;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.106 -0500", hash_original_field = "C5269AA669EF1E6636D1450EA530C9C5", hash_generated_field = "28997BC83DA18A620109895922F10617")

    private BigInteger          n;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.108 -0500", hash_original_field = "FF6F1CE798488519FE43D7992CD2DB11", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

    private BigInteger          h;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.111 -0500", hash_original_field = "9ECAAC80561D5FC0A0D63F92F7BF0E17", hash_generated_field = "84A0CB03E1AA0B2A11E3988D98BBE452")

    private byte[]              seed;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.114 -0500", hash_original_method = "38D6105F07283EB5F8B3605923A2D06B", hash_generated_method = "6789D865A6A09A044666E36225161EC6")
    
public X9ECParameters(
        ASN1Sequence  seq)
    {
        if (!(seq.getObjectAt(0) instanceof DERInteger)
           || !((DERInteger)seq.getObjectAt(0)).getValue().equals(ONE))
        {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }

        X9Curve     x9c = new X9Curve(
                        new X9FieldID((ASN1Sequence)seq.getObjectAt(1)),
                        (ASN1Sequence)seq.getObjectAt(2));

        this.curve = x9c.getCurve();
        this.g = new X9ECPoint(curve, (ASN1OctetString)seq.getObjectAt(3)).getPoint();
        this.n = ((DERInteger)seq.getObjectAt(4)).getValue();
        this.seed = x9c.getSeed();

        if (seq.size() == 6)
        {
            this.h = ((DERInteger)seq.getObjectAt(5)).getValue();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.117 -0500", hash_original_method = "739112175432B7FC1F3897612DAEA859", hash_generated_method = "952993F25B94400F05278552F686CF2C")
    
public X9ECParameters(
        ECCurve     curve,
        ECPoint     g,
        BigInteger  n)
    {
        this(curve, g, n, ONE, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.120 -0500", hash_original_method = "7F13F9D9B68D09FF2E2DEF2F93290D05", hash_generated_method = "10D639B694A17C9FBA354077B73315DC")
    
public X9ECParameters(
        ECCurve     curve,
        ECPoint     g,
        BigInteger  n,
        BigInteger  h)
    {
        this(curve, g, n, h, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.124 -0500", hash_original_method = "1843E539ACF8FE39D46257BC325E0DC6", hash_generated_method = "CC71A6608D971E8DC00AA2F26E223D31")
    
public X9ECParameters(
        ECCurve     curve,
        ECPoint     g,
        BigInteger  n,
        BigInteger  h,
        byte[]      seed)
    {
        this.curve = curve;
        this.g = g;
        this.n = n;
        this.h = h;
        this.seed = seed;

        if (curve instanceof ECCurve.Fp)
        {
            this.fieldID = new X9FieldID(((ECCurve.Fp)curve).getQ());
        }
        else
        {
            if (curve instanceof ECCurve.F2m)
            {
                ECCurve.F2m curveF2m = (ECCurve.F2m)curve;
                this.fieldID = new X9FieldID(curveF2m.getM(), curveF2m.getK1(),
                    curveF2m.getK2(), curveF2m.getK3());
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.126 -0500", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "B9031E139E03D127788DF39899FDE161")
    
public ECCurve getCurve()
    {
        return curve;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.128 -0500", hash_original_method = "F49644298FFD38F2CFD5B0D378F29102", hash_generated_method = "A94F4582DBDC30883F9BCB451B5811E0")
    
public ECPoint getG()
    {
        return g;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.131 -0500", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "02928BD4257B76FF9B6C6F96BB0BD425")
    
public BigInteger getN()
    {
        return n;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.133 -0500", hash_original_method = "9DE3987FDD4335D5C0BE76F667E07DA1", hash_generated_method = "8EA7E3C758099DAC5519AEBE164A7EB5")
    
public BigInteger getH()
    {
        if (h == null)
        {
            return ONE;        // TODO - this should be calculated, it will cause issues with custom curves.
        }

        return h;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.135 -0500", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "B9121A38AE643366EC4B8CEEAF78AD62")
    
public byte[] getSeed()
    {
        return seed;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *  ECParameters ::= SEQUENCE {
     *      version         INTEGER { ecpVer1(1) } (ecpVer1),
     *      fieldID         FieldID {{FieldTypes}},
     *      curve           X9Curve,
     *      base            X9ECPoint,
     *      order           INTEGER,
     *      cofactor        INTEGER OPTIONAL
     *  }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.138 -0500", hash_original_method = "8FEF0683FB02574D7DCECBAD72741893", hash_generated_method = "061056F69E114EE8F0C344EE9295051F")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(new DERInteger(1));
        v.add(fieldID);
        v.add(new X9Curve(curve, seed));
        v.add(new X9ECPoint(g));
        v.add(new DERInteger(n));

        if (h != null)
        {
            v.add(new DERInteger(h));
        }

        return new DERSequence(v);
    }
}

