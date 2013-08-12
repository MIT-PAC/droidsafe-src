package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECFieldElement;






public class X9FieldElement extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.378 -0400", hash_original_field = "8FA14CDD754F91CC6554C9E71929CCE7", hash_generated_field = "1EE4837A63C4E97D7CC0E7C760C4222B")

    protected ECFieldElement f;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.379 -0400", hash_original_method = "F44590D2DC1CB9A850DEED8AA932C508", hash_generated_method = "B40DD49217D53D4CC78C975F7729E462")
    public  X9FieldElement(ECFieldElement f) {
        this.f = f;
        // ---------- Original Method ----------
        //this.f = f;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.379 -0400", hash_original_method = "240BB5C1A9BD0B3E7BEC7A408B7EBED1", hash_generated_method = "DE42B6501323C05C92F64D9F048BCB56")
    public  X9FieldElement(BigInteger p, ASN1OctetString s) {
        this(new ECFieldElement.Fp(p, new BigInteger(1, s.getOctets())));
        addTaint(s.getTaint());
        addTaint(p.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.380 -0400", hash_original_method = "03C4454F48591BAC871371AEF932BD75", hash_generated_method = "6A607DB1359C9C2827C06AC0E1704631")
    public  X9FieldElement(int m, int k1, int k2, int k3, ASN1OctetString s) {
        this(new ECFieldElement.F2m(m, k1, k2, k3, new BigInteger(1, s.getOctets())));
        addTaint(s.getTaint());
        addTaint(k3);
        addTaint(k2);
        addTaint(k1);
        addTaint(m);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.380 -0400", hash_original_method = "8A2CB601358E90D44574A6BC9E09C2FF", hash_generated_method = "7FAC6757F0237F3AB2D021F455673D4E")
    public ECFieldElement getValue() {
ECFieldElement varABE3CFB53FE4A79F34CB25BC80BFD6E2_1430448696 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_1430448696.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1430448696;
        // ---------- Original Method ----------
        //return f;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.381 -0400", hash_original_method = "C3D6716565C168642D40E95793D0D07C", hash_generated_method = "B0567881FF8A55E589977A536E00B793")
    public DERObject toASN1Object() {
        int byteCount = converter.getByteLength(f);
        byte[] paddedBigInteger = converter.integerToBytes(f.toBigInteger(), byteCount);
DERObject var9AD43AE54838BC9671AB5E61A9BEAF35_952379365 =         new DEROctetString(paddedBigInteger);
        var9AD43AE54838BC9671AB5E61A9BEAF35_952379365.addTaint(taint);
        return var9AD43AE54838BC9671AB5E61A9BEAF35_952379365;
        // ---------- Original Method ----------
        //int byteCount = converter.getByteLength(f);
        //byte[] paddedBigInteger = converter.integerToBytes(f.toBigInteger(), byteCount);
        //return new DEROctetString(paddedBigInteger);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.381 -0400", hash_original_field = "61707B662C0781EC16F82DBF410266B9", hash_generated_field = "F6B8D48C5F5A761E5DB11D930C790FFE")

    private static X9IntegerConverter converter = new X9IntegerConverter();
}

