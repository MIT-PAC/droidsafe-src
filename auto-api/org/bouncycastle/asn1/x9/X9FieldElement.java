package org.bouncycastle.asn1.x9;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECFieldElement;

public class X9FieldElement extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.463 -0400", hash_original_field = "8FA14CDD754F91CC6554C9E71929CCE7", hash_generated_field = "1EE4837A63C4E97D7CC0E7C760C4222B")

    protected ECFieldElement f;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.463 -0400", hash_original_method = "F44590D2DC1CB9A850DEED8AA932C508", hash_generated_method = "B40DD49217D53D4CC78C975F7729E462")
    public  X9FieldElement(ECFieldElement f) {
        this.f = f;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.464 -0400", hash_original_method = "240BB5C1A9BD0B3E7BEC7A408B7EBED1", hash_generated_method = "8AAC6924210D46FE819D1FF43551DC9A")
    public  X9FieldElement(BigInteger p, ASN1OctetString s) {
        this(new ECFieldElement.Fp(p, new BigInteger(1, s.getOctets())));
        addTaint(p.getTaint());
        addTaint(s.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.464 -0400", hash_original_method = "03C4454F48591BAC871371AEF932BD75", hash_generated_method = "841980AA21EBC639A35462D1A2F991BB")
    public  X9FieldElement(int m, int k1, int k2, int k3, ASN1OctetString s) {
        this(new ECFieldElement.F2m(m, k1, k2, k3, new BigInteger(1, s.getOctets())));
        addTaint(m);
        addTaint(k1);
        addTaint(k2);
        addTaint(k3);
        addTaint(s.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.464 -0400", hash_original_method = "8A2CB601358E90D44574A6BC9E09C2FF", hash_generated_method = "4330531918E511A422068D9F5CE18F79")
    public ECFieldElement getValue() {
        ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1039484323 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1039484323 = f;
        varB4EAC82CA7396A68D541C85D26508E83_1039484323.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1039484323;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.464 -0400", hash_original_method = "C3D6716565C168642D40E95793D0D07C", hash_generated_method = "7BFA29D64AD2030113E6CB2FE2D927A3")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_882981143 = null; 
        int byteCount = converter.getByteLength(f);
        byte[] paddedBigInteger = converter.integerToBytes(f.toBigInteger(), byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_882981143 = new DEROctetString(paddedBigInteger);
        varB4EAC82CA7396A68D541C85D26508E83_882981143.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_882981143;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.465 -0400", hash_original_field = "61707B662C0781EC16F82DBF410266B9", hash_generated_field = "F6B8D48C5F5A761E5DB11D930C790FFE")

    private static X9IntegerConverter converter = new X9IntegerConverter();
}

