package org.bouncycastle.asn1.pkcs;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class PKCS12PBEParams extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.102 -0400", hash_original_field = "471DACEA75A62298F21BD08196E91EF6", hash_generated_field = "78F9CF53C7E0D6433DD6CC8969049302")

    DERInteger iterations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.102 -0400", hash_original_field = "F0B53B2DA041FCA49EF0B9839060B345", hash_generated_field = "B25868518F07845AA04DDD7C4143C484")

    ASN1OctetString iv;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.102 -0400", hash_original_method = "386E04A4D9F1D93ADFE74A748112E74F", hash_generated_method = "236C997E4CCCD6DA28CBD027E375EF3D")
    public  PKCS12PBEParams(
        byte[]      salt,
        int         iterations) {
        this.iv = new DEROctetString(salt);
        this.iterations = new DERInteger(iterations);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.102 -0400", hash_original_method = "9796F53576903CCA620F278DD161E921", hash_generated_method = "80A99104574C0F2DF3F2C510241123DF")
    public  PKCS12PBEParams(
        ASN1Sequence  seq) {
        iv = (ASN1OctetString)seq.getObjectAt(0);
        iterations = (DERInteger)seq.getObjectAt(1);
        
        
        
    }

    
    public static PKCS12PBEParams getInstance(
        Object  obj) {
        if (obj instanceof PKCS12PBEParams)
        {
            return (PKCS12PBEParams)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new PKCS12PBEParams((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.103 -0400", hash_original_method = "DD1CD350639FBEA94B58D8C0FBFF69DE", hash_generated_method = "2E5082748CB1A9B2C074670E8F67BB63")
    public BigInteger getIterations() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_744378290 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_744378290 = iterations.getValue();
        varB4EAC82CA7396A68D541C85D26508E83_744378290.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_744378290;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.103 -0400", hash_original_method = "ABC6C1F7D45D0FDDF94BEAE70F71F0ED", hash_generated_method = "E382034547F8F68493BF737CD03EA4EA")
    public byte[] getIV() {
        byte[] var99F91666C947D91F2AA8D5C330016710_1395466601 = (iv.getOctets());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1405111741 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1405111741;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.103 -0400", hash_original_method = "08D9069F477C4E4688BE524F0F9F7EEF", hash_generated_method = "4B45F2C313633F3823CA7A225563E66C")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_928928562 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(iv);
        v.add(iterations);
        varB4EAC82CA7396A68D541C85D26508E83_928928562 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_928928562.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_928928562;
        
        
        
        
        
    }

    
}

