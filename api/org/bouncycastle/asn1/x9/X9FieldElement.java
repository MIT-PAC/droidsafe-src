package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECFieldElement;






public class X9FieldElement extends ASN1Encodable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.844 -0500", hash_original_field = "F357BA3E591BD4D6DB34B6CC355FDE3B", hash_generated_field = "F6B8D48C5F5A761E5DB11D930C790FFE")

    
    private static X9IntegerConverter converter = new X9IntegerConverter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.843 -0500", hash_original_field = "E32ABFFA52B3CEB5DEFAB625FB80F6D9", hash_generated_field = "1EE4837A63C4E97D7CC0E7C760C4222B")

    protected ECFieldElement  f;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.845 -0500", hash_original_method = "F44590D2DC1CB9A850DEED8AA932C508", hash_generated_method = "1B8ABD702F01928C33B65D37AE7C319E")
    public X9FieldElement(ECFieldElement f)
    {
        this.f = f;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.846 -0500", hash_original_method = "240BB5C1A9BD0B3E7BEC7A408B7EBED1", hash_generated_method = "F53736E300314E2C1B481957178C425D")
    public X9FieldElement(BigInteger p, ASN1OctetString s)
    {
        this(new ECFieldElement.Fp(p, new BigInteger(1, s.getOctets())));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.846 -0500", hash_original_method = "03C4454F48591BAC871371AEF932BD75", hash_generated_method = "C58226834553DF91E192688477F1B4EC")
    public X9FieldElement(int m, int k1, int k2, int k3, ASN1OctetString s)
    {
        this(new ECFieldElement.F2m(m, k1, k2, k3, new BigInteger(1, s.getOctets())));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.847 -0500", hash_original_method = "8A2CB601358E90D44574A6BC9E09C2FF", hash_generated_method = "01259B3FA872A21626B1EE9BD0576C14")
    public ECFieldElement getValue()
    {
        return f;
    }
    
    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *  FieldElement ::= OCTET STRING
     * </pre>
     * <p>
     * <ol>
     * <li> if <i>q</i> is an odd prime then the field element is
     * processed as an Integer and converted to an octet string
     * according to x 9.62 4.3.1.</li>
     * <li> if <i>q</i> is 2<sup>m</sup> then the bit string
     * contained in the field element is converted into an octet
     * string with the same ordering padded at the front if necessary.
     * </li>
     * </ol>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.848 -0500", hash_original_method = "C3D6716565C168642D40E95793D0D07C", hash_generated_method = "30F442A94A51D057E3B05A9BEFEC1282")
    public DERObject toASN1Object()
    {
        int byteCount = converter.getByteLength(f);
        byte[] paddedBigInteger = converter.integerToBytes(f.toBigInteger(), byteCount);

        return new DEROctetString(paddedBigInteger);
    }
}

