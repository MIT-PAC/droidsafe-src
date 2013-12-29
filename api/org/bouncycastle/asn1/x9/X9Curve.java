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
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECCurve;






public class X9Curve extends ASN1Encodable implements X9ObjectIdentifiers {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.551 -0500", hash_original_field = "704A3581F062D90BBFC67E94998B89B2", hash_generated_field = "D4FD3D236F6822F3201F264EA949068E")

    private ECCurve     curve;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.552 -0500", hash_original_field = "9ECAAC80561D5FC0A0D63F92F7BF0E17", hash_generated_field = "84A0CB03E1AA0B2A11E3988D98BBE452")

    private byte[]      seed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.553 -0500", hash_original_field = "921019B75C942EA736D86AA890F2468F", hash_generated_field = "E3338F0376BEF793D592DF0C27082DD0")

    private DERObjectIdentifier fieldIdentifier = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.554 -0500", hash_original_method = "D6C787E2A4803225F35FA6BCE1822130", hash_generated_method = "4EE33B73CEB8470EDC603273774C100A")
    public X9Curve(
        ECCurve     curve)
    {
        this.curve = curve;
        this.seed = null;
        setFieldIdentifier();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.555 -0500", hash_original_method = "3B7C14B5F62450195FF0D6E781874500", hash_generated_method = "4E26A5EA630A27861CDB62E08A3AB9F1")
    public X9Curve(
        ECCurve     curve,
        byte[]      seed)
    {
        this.curve = curve;
        this.seed = seed;
        setFieldIdentifier();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.556 -0500", hash_original_method = "7B136525ED7EAC50EDEE818CB871C643", hash_generated_method = "78EFFBC1D8155E74BAC3A02998EBC66F")
    public X9Curve(
        X9FieldID     fieldID,
        ASN1Sequence  seq)
    {
        fieldIdentifier = fieldID.getIdentifier();
        if (fieldIdentifier.equals(prime_field))
        {
            BigInteger      p = ((DERInteger)fieldID.getParameters()).getValue();
            X9FieldElement  x9A = new X9FieldElement(p, (ASN1OctetString)seq.getObjectAt(0));
            X9FieldElement  x9B = new X9FieldElement(p, (ASN1OctetString)seq.getObjectAt(1));
            curve = new ECCurve.Fp(p, x9A.getValue().toBigInteger(), x9B.getValue().toBigInteger());
        }
        else
        {
            if (fieldIdentifier.equals(characteristic_two_field)) 
            {
                // Characteristic two field
                DERSequence parameters = (DERSequence)fieldID.getParameters();
                int m = ((DERInteger)parameters.getObjectAt(0)).getValue().
                    intValue();
                DERObjectIdentifier representation
                    = (DERObjectIdentifier)parameters.getObjectAt(1);

                int k1 = 0;
                int k2 = 0;
                int k3 = 0;
                if (representation.equals(tpBasis)) 
                {
                    // Trinomial basis representation
                    k1 = ((DERInteger)parameters.getObjectAt(2)).getValue().
                        intValue();
                }
                else 
                {
                    // Pentanomial basis representation
                    DERSequence pentanomial
                        = (DERSequence)parameters.getObjectAt(2);
                    k1 = ((DERInteger)pentanomial.getObjectAt(0)).getValue().
                        intValue();
                    k2 = ((DERInteger)pentanomial.getObjectAt(1)).getValue().
                        intValue();
                    k3 = ((DERInteger)pentanomial.getObjectAt(2)).getValue().
                        intValue();
                }
                X9FieldElement x9A = new X9FieldElement(m, k1, k2, k3, (ASN1OctetString)seq.getObjectAt(0));
                X9FieldElement x9B = new X9FieldElement(m, k1, k2, k3, (ASN1OctetString)seq.getObjectAt(1));
                // TODO Is it possible to get the order (n) and cofactor(h) too?
                curve = new ECCurve.F2m(m, k1, k2, k3, x9A.getValue().toBigInteger(), x9B.getValue().toBigInteger());
            }
        }

        if (seq.size() == 3)
        {
            seed = ((DERBitString)seq.getObjectAt(2)).getBytes();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.557 -0500", hash_original_method = "D736F484B6800931FE72576618335766", hash_generated_method = "1A32C094D829DEFAC0CC93FF64E4A180")
    private void setFieldIdentifier()
    {
        if (curve instanceof ECCurve.Fp)
        {
            fieldIdentifier = prime_field;
        }
        else if (curve instanceof ECCurve.F2m)
        {
            fieldIdentifier = characteristic_two_field;
        }
        else
        {
            throw new IllegalArgumentException("This type of ECCurve is not "
                    + "implemented");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.558 -0500", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "B9031E139E03D127788DF39899FDE161")
    public ECCurve  getCurve()
    {
        return curve;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.559 -0500", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "B9121A38AE643366EC4B8CEEAF78AD62")
    public byte[]   getSeed()
    {
        return seed;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *  Curve ::= SEQUENCE {
     *      a               FieldElement,
     *      b               FieldElement,
     *      seed            BIT STRING      OPTIONAL
     *  }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.560 -0500", hash_original_method = "FE4C71C21A5F26496E8390DAB2BE9299", hash_generated_method = "C749B70E46B2ED2C31DF1B401E654B16")
    public DERObject toASN1Object()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        if (fieldIdentifier.equals(prime_field)) 
        { 
            v.add(new X9FieldElement(curve.getA()).getDERObject());
            v.add(new X9FieldElement(curve.getB()).getDERObject());
        } 
        else if (fieldIdentifier.equals(characteristic_two_field)) 
        {
            v.add(new X9FieldElement(curve.getA()).getDERObject());
            v.add(new X9FieldElement(curve.getB()).getDERObject());
        }

        if (seed != null)
        {
            v.add(new DERBitString(seed));
        }

        return new DERSequence(v);
    }

    
}

