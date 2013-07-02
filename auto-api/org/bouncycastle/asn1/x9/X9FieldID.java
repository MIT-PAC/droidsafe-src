package org.bouncycastle.asn1.x9;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class X9FieldID extends ASN1Encodable implements X9ObjectIdentifiers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.471 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "C9026F3AA6576B332E83AF850E791F56")

    private DERObjectIdentifier id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.471 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "1557C13CB9AB38DEB6A065C70AD2F74E")

    private DERObject parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.471 -0400", hash_original_method = "947D632CD3BB9C70FFB74606AF4AA65C", hash_generated_method = "336E537F452F8D6FB7E3AC232B57761F")
    public  X9FieldID(BigInteger primeP) {
        this.id = prime_field;
        this.parameters = new DERInteger(primeP);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.471 -0400", hash_original_method = "E68F2B5FEB9AA2D283212DC970B04168", hash_generated_method = "FBA694B20E6CA74A1D129F7BBC32E605")
    public  X9FieldID(int m, int k1, int k2, int k3) {
        this.id = characteristic_two_field;
        ASN1EncodableVector fieldIdParams = new ASN1EncodableVector();
        fieldIdParams.add(new DERInteger(m));
        {
            fieldIdParams.add(tpBasis);
            fieldIdParams.add(new DERInteger(k1));
        } 
        {
            fieldIdParams.add(ppBasis);
            ASN1EncodableVector pentanomialParams = new ASN1EncodableVector();
            pentanomialParams.add(new DERInteger(k1));
            pentanomialParams.add(new DERInteger(k2));
            pentanomialParams.add(new DERInteger(k3));
            fieldIdParams.add(new DERSequence(pentanomialParams));
        } 
        this.parameters = new DERSequence(fieldIdParams);
        addTaint(m);
        addTaint(k1);
        addTaint(k2);
        addTaint(k3);
        
        
        
        
        
        
            
            
        
        
        
            
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.472 -0400", hash_original_method = "DE0F1786B89D9192DA26A23CD26B072E", hash_generated_method = "EC736FBE556FC79705AF65DDF77AD0A8")
    public  X9FieldID(
        ASN1Sequence  seq) {
        this.id = (DERObjectIdentifier)seq.getObjectAt(0);
        this.parameters = (DERObject)seq.getObjectAt(1);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.472 -0400", hash_original_method = "A03C04E1D63CA4FFA1D88D7678177C2A", hash_generated_method = "656A93224BA85030569699000E6F6538")
    public DERObjectIdentifier getIdentifier() {
        DERObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_1029093829 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1029093829 = id;
        varB4EAC82CA7396A68D541C85D26508E83_1029093829.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1029093829;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.472 -0400", hash_original_method = "1898F00B5F10CC32C939404F88AE77E4", hash_generated_method = "80BF440BB7CA86AF2D8E2D53D00A1C3E")
    public DERObject getParameters() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1447304803 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1447304803 = parameters;
        varB4EAC82CA7396A68D541C85D26508E83_1447304803.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1447304803;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.473 -0400", hash_original_method = "F64CE532B89E0DF8480CF348DC73F510", hash_generated_method = "E839CBD2299C7AD131F9F164492356EE")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1763369408 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(this.id);
        v.add(this.parameters);
        varB4EAC82CA7396A68D541C85D26508E83_1763369408 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1763369408.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1763369408;
        
        
        
        
        
    }

    
}

