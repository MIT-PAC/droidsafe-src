package org.bouncycastle.asn1.pkcs;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class PBES2Parameters extends ASN1Encodable implements PKCSObjectIdentifiers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.078 -0400", hash_original_field = "7DF4935F4A5A2865191EF74F64DF8754", hash_generated_field = "A48877E800AAA8ADC77D525D7959F19C")

    private KeyDerivationFunc func;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.078 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "46DE4B11FD863AFD50DE990D444E6098")

    private EncryptionScheme scheme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.078 -0400", hash_original_method = "CA68BEDA74AC2397C06F19E0885D4A85", hash_generated_method = "538BA614129AD39622AB17E35405DE5F")
    public  PBES2Parameters(
        ASN1Sequence  obj) {
        Enumeration e = obj.getObjects();
        ASN1Sequence funcSeq = ASN1Sequence.getInstance(((DEREncodable)e.nextElement()).getDERObject());
        {
            boolean varA792FD017A352E961DB7DCD6D1BF50FD_1369137357 = (funcSeq.getObjectAt(0).equals(id_PBKDF2));
            {
                func = new KeyDerivationFunc(id_PBKDF2, PBKDF2Params.getInstance(funcSeq.getObjectAt(1)));
            } 
            {
                func = new KeyDerivationFunc(funcSeq);
            } 
        } 
        scheme = (EncryptionScheme)EncryptionScheme.getInstance(e.nextElement());
        addTaint(obj.getTaint());
        
        
        
        
        
            
        
        
        
            
        
        
    }

    
    public static PBES2Parameters getInstance(
        Object  obj) {
        if (obj== null || obj instanceof PBES2Parameters)
        {
            return (PBES2Parameters)obj;
        }
        if (obj instanceof ASN1Sequence)
        {
            return new PBES2Parameters((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.079 -0400", hash_original_method = "EA8CB9021471F89DCA3D4DA5F755F4FC", hash_generated_method = "BC3E93C0E257E918D262EEDB6FDAC512")
    public KeyDerivationFunc getKeyDerivationFunc() {
        KeyDerivationFunc varB4EAC82CA7396A68D541C85D26508E83_211277582 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_211277582 = func;
        varB4EAC82CA7396A68D541C85D26508E83_211277582.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_211277582;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.079 -0400", hash_original_method = "9053FDAC6FE0628F4B096189E8DDF584", hash_generated_method = "6E515C5818E3560A039FEE028201DD26")
    public EncryptionScheme getEncryptionScheme() {
        EncryptionScheme varB4EAC82CA7396A68D541C85D26508E83_572772758 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_572772758 = scheme;
        varB4EAC82CA7396A68D541C85D26508E83_572772758.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_572772758;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.080 -0400", hash_original_method = "489B41034DC44CEDA69ABA933292B2BB", hash_generated_method = "7334E8FD313DACFCC5DEB950F3177115")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1126040103 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(func);
        v.add(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_1126040103 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1126040103.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1126040103;
        
        
        
        
        
    }

    
}

