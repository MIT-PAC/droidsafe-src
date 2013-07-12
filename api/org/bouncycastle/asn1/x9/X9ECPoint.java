package org.bouncycastle.asn1.x9;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class X9ECPoint extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.508 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "970C33153824C1D915DACA6A7A433B9D")

    ECPoint p;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.509 -0400", hash_original_method = "D8A9B6BC21A3F338658632EA320E8353", hash_generated_method = "761FFCAF52EF07DD44194D08623A70BE")
    public  X9ECPoint(
        ECPoint p) {
        this.p = p;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.509 -0400", hash_original_method = "62B905AD7CA2E17ED0AA9C97BE811516", hash_generated_method = "45B652F09751CF767E280B805C2FC864")
    public  X9ECPoint(
        ECCurve          c,
        ASN1OctetString  s) {
        this.p = c.decodePoint(s.getOctets());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.509 -0400", hash_original_method = "D52AE13C55E681838944F7D6A70D7ED5", hash_generated_method = "814E53367321ACA0E0D1E16DA8B27DAB")
    public ECPoint getPoint() {
ECPoint var74E4690D9F2A026504928C017944E149_972929217 =         p;
        var74E4690D9F2A026504928C017944E149_972929217.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_972929217;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.510 -0400", hash_original_method = "C505CC97F230C74832134C935460DD57", hash_generated_method = "69723B7F0E18A351775215BD1ADA0577")
    public DERObject toASN1Object() {
DERObject var7350EF93798DCB7AA7CB91F6A5DC0F71_81592231 =         new DEROctetString(p.getEncoded());
        var7350EF93798DCB7AA7CB91F6A5DC0F71_81592231.addTaint(taint);
        return var7350EF93798DCB7AA7CB91F6A5DC0F71_81592231;
        
        
    }

    
}

