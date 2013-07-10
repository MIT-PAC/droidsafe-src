package org.bouncycastle.asn1.x9;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class X9ECPoint extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.449 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "970C33153824C1D915DACA6A7A433B9D")

    ECPoint p;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.450 -0400", hash_original_method = "D8A9B6BC21A3F338658632EA320E8353", hash_generated_method = "761FFCAF52EF07DD44194D08623A70BE")
    public  X9ECPoint(
        ECPoint p) {
        this.p = p;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.450 -0400", hash_original_method = "62B905AD7CA2E17ED0AA9C97BE811516", hash_generated_method = "45B652F09751CF767E280B805C2FC864")
    public  X9ECPoint(
        ECCurve          c,
        ASN1OctetString  s) {
        this.p = c.decodePoint(s.getOctets());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.451 -0400", hash_original_method = "D52AE13C55E681838944F7D6A70D7ED5", hash_generated_method = "16BA955F3670ADCC1B4F53F345049465")
    public ECPoint getPoint() {
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_2088691219 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2088691219 = p;
        varB4EAC82CA7396A68D541C85D26508E83_2088691219.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2088691219;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.451 -0400", hash_original_method = "C505CC97F230C74832134C935460DD57", hash_generated_method = "5F755713839C3B7623E67FF2EA70507C")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1447420540 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1447420540 = new DEROctetString(p.getEncoded());
        varB4EAC82CA7396A68D541C85D26508E83_1447420540.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1447420540;
        
        
    }

    
}

