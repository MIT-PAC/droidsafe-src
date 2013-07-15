package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class Attribute extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.660 -0400", hash_original_field = "1EF64C012A52F50C55650F0FE7546D9A", hash_generated_field = "4851D4166E5BF16AA64E550E5ECE0B30")

    private DERObjectIdentifier attrType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.660 -0400", hash_original_field = "EFD717FE854DB7E7EF6210D033ABA119", hash_generated_field = "240506915FE52EB5683D0C9895D89C66")

    private ASN1Set attrValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.660 -0400", hash_original_method = "F858B1E12EC141756BCF51707692EAE3", hash_generated_method = "37D9AAE5EEF50D0CF77993FAF18F3BBB")
    public  Attribute(
        ASN1Sequence seq) {
        {
            boolean var97DBDEEC2A320E15512526B0CE06A30A_297617893 = (seq.size() != 2);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } 
        } 
        attrType = DERObjectIdentifier.getInstance(seq.getObjectAt(0));
        attrValues = ASN1Set.getInstance(seq.getObjectAt(1));
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.661 -0400", hash_original_method = "38B63F7591289E34615CCB148E077DFB", hash_generated_method = "C56BC70F4D19D384749367E1C1179BC3")
    public  Attribute(
        DERObjectIdentifier attrType,
        ASN1Set             attrValues) {
        this.attrType = attrType;
        this.attrValues = attrValues;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Attribute getInstance(
        Object o) {
        if (o == null || o instanceof Attribute)
        {
            return (Attribute)o;
        }
        if (o instanceof ASN1Sequence)
        {
            return new Attribute((ASN1Sequence)o);
        }
        throw new IllegalArgumentException("unknown object in factory: " + o.getClass().getName());
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.662 -0400", hash_original_method = "C61254DD25EA79572F2B43B889534711", hash_generated_method = "5FECE512C2BF4187C69E3E3B5246FC7E")
    public ASN1ObjectIdentifier getAttrType() {
        ASN1ObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_1758506606 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1758506606 = new ASN1ObjectIdentifier(attrType.getId());
        varB4EAC82CA7396A68D541C85D26508E83_1758506606.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1758506606;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.663 -0400", hash_original_method = "3714D5AC97801D67C3C70862DB57F642", hash_generated_method = "CD6A2515D0474D3BE39F8F91BBE7C5F7")
    public ASN1Encodable[] getAttributeValues() {
        ASN1Encodable[] varB4EAC82CA7396A68D541C85D26508E83_1109758695 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1109758695 = attrValues.toArray();
        varB4EAC82CA7396A68D541C85D26508E83_1109758695.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1109758695;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.663 -0400", hash_original_method = "0C9FA4513BA0CB1318C076F6A4C1BAA0", hash_generated_method = "794B1A0BA01576F312C5807231EA1E43")
    public ASN1Set getAttrValues() {
        ASN1Set varB4EAC82CA7396A68D541C85D26508E83_546774320 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_546774320 = attrValues;
        varB4EAC82CA7396A68D541C85D26508E83_546774320.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_546774320;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.664 -0400", hash_original_method = "7FF9F3775D261945F5C8461E1521856A", hash_generated_method = "A7906CE4BFA1907ABAE385FFF06840C2")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_851853941 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(attrType);
        v.add(attrValues);
        varB4EAC82CA7396A68D541C85D26508E83_851853941 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_851853941.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_851853941;
        
        
        
        
        
    }

    
}

