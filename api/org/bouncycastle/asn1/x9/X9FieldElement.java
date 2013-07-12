package org.bouncycastle.asn1.x9;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECFieldElement;

public class X9FieldElement extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.521 -0400", hash_original_field = "8FA14CDD754F91CC6554C9E71929CCE7", hash_generated_field = "1EE4837A63C4E97D7CC0E7C760C4222B")

    protected ECFieldElement f;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.521 -0400", hash_original_method = "F44590D2DC1CB9A850DEED8AA932C508", hash_generated_method = "B40DD49217D53D4CC78C975F7729E462")
    public  X9FieldElement(ECFieldElement f) {
        this.f = f;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.522 -0400", hash_original_method = "240BB5C1A9BD0B3E7BEC7A408B7EBED1", hash_generated_method = "DE42B6501323C05C92F64D9F048BCB56")
    public  X9FieldElement(BigInteger p, ASN1OctetString s) {
        this(new ECFieldElement.Fp(p, new BigInteger(1, s.getOctets())));
        addTaint(s.getTaint());
        addTaint(p.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.522 -0400", hash_original_method = "03C4454F48591BAC871371AEF932BD75", hash_generated_method = "6A607DB1359C9C2827C06AC0E1704631")
    public  X9FieldElement(int m, int k1, int k2, int k3, ASN1OctetString s) {
        this(new ECFieldElement.F2m(m, k1, k2, k3, new BigInteger(1, s.getOctets())));
        addTaint(s.getTaint());
        addTaint(k3);
        addTaint(k2);
        addTaint(k1);
        addTaint(m);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.523 -0400", hash_original_method = "8A2CB601358E90D44574A6BC9E09C2FF", hash_generated_method = "C36D55C074F17EED2DB904D4810C1BAC")
    public ECFieldElement getValue() {
ECFieldElement varABE3CFB53FE4A79F34CB25BC80BFD6E2_908103644 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_908103644.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_908103644;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.523 -0400", hash_original_method = "C3D6716565C168642D40E95793D0D07C", hash_generated_method = "AC01EBEC1F7E7E2796A549B372878032")
    public DERObject toASN1Object() {
        int byteCount = converter.getByteLength(f);
        byte[] paddedBigInteger = converter.integerToBytes(f.toBigInteger(), byteCount);
DERObject var9AD43AE54838BC9671AB5E61A9BEAF35_615690386 =         new DEROctetString(paddedBigInteger);
        var9AD43AE54838BC9671AB5E61A9BEAF35_615690386.addTaint(taint);
        return var9AD43AE54838BC9671AB5E61A9BEAF35_615690386;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.523 -0400", hash_original_field = "61707B662C0781EC16F82DBF410266B9", hash_generated_field = "F6B8D48C5F5A761E5DB11D930C790FFE")

    private static X9IntegerConverter converter = new X9IntegerConverter();
}

