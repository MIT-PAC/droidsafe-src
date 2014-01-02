package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;






public class X9ECPoint extends ASN1Encodable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.246 -0500", hash_original_field = "970C33153824C1D915DACA6A7A433B9D", hash_generated_field = "970C33153824C1D915DACA6A7A433B9D")

    ECPoint p;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.249 -0500", hash_original_method = "D8A9B6BC21A3F338658632EA320E8353", hash_generated_method = "1BADEB8CD39235E7B2904B61CD9CA866")
    
public X9ECPoint(
        ECPoint p)
    {
        this.p = p;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.252 -0500", hash_original_method = "62B905AD7CA2E17ED0AA9C97BE811516", hash_generated_method = "C63AEE615A61AD1C007E6858E2488FFC")
    
public X9ECPoint(
        ECCurve          c,
        ASN1OctetString  s)
    {
        this.p = c.decodePoint(s.getOctets());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.254 -0500", hash_original_method = "D52AE13C55E681838944F7D6A70D7ED5", hash_generated_method = "ADBA43D3127D38044480CB2B5E588BE8")
    
public ECPoint getPoint()
    {
        return p;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *  ECPoint ::= OCTET STRING
     * </pre>
     * <p>
     * Octet string produced using ECPoint.getEncoded().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.257 -0500", hash_original_method = "C505CC97F230C74832134C935460DD57", hash_generated_method = "A1C6DF96697BF5254A9DFC895BD0DE15")
    
public DERObject toASN1Object()
    {
        return new DEROctetString(p.getEncoded());
    }

    
}

