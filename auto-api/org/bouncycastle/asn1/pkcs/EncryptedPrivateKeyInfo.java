package org.bouncycastle.asn1.pkcs;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedPrivateKeyInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.015 -0400", hash_original_field = "7E017AD6DBE390CDE33A4543127F45F7", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier algId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.015 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "E7847206107AFED7061FA6DEEE6B4715")

    private ASN1OctetString data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.016 -0400", hash_original_method = "D7780F085E4F69D75EAD7364F689A92D", hash_generated_method = "705C0E5E1436DE4326CE6B39F1672A9B")
    public  EncryptedPrivateKeyInfo(
        ASN1Sequence  seq) {
        Enumeration e = seq.getObjects();
        algId = AlgorithmIdentifier.getInstance(e.nextElement());
        data = (ASN1OctetString)e.nextElement();
        addTaint(seq.getTaint());
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.017 -0400", hash_original_method = "05A2146A24A4B777EF99E759E6105DB4", hash_generated_method = "1D8FF643A8B8E69B31AC57D85BE6BD5D")
    public  EncryptedPrivateKeyInfo(
        AlgorithmIdentifier algId,
        byte[]              encoding) {
        this.algId = algId;
        this.data = new DEROctetString(encoding);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static EncryptedPrivateKeyInfo getInstance(
        Object  obj) {
        if (obj instanceof EncryptedPrivateKeyInfo)
        {
            return (EncryptedPrivateKeyInfo)obj;
        }
        else if (obj instanceof ASN1Sequence)
        { 
            return new EncryptedPrivateKeyInfo((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.018 -0400", hash_original_method = "742117C3F9E40BA83B51D9D3C5056A2D", hash_generated_method = "5C80102CBB1E2BFABE428F40ADEC6377")
    public AlgorithmIdentifier getEncryptionAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_246731451 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_246731451 = algId;
        varB4EAC82CA7396A68D541C85D26508E83_246731451.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_246731451;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.018 -0400", hash_original_method = "BBC4FA06F2A86F1789EA116FAB590C10", hash_generated_method = "18B8E6C00D034D9A5314E68E46FAB2BE")
    public byte[] getEncryptedData() {
        byte[] var061EFA52EC8FE48598A94BA0B5869281_1209262357 = (data.getOctets());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2130710469 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2130710469;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.019 -0400", hash_original_method = "1A83B7862624E8339D74A705608FC69D", hash_generated_method = "D307168BE2DEF0722BFBA199F41AFE95")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_935124188 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(algId);
        v.add(data);
        varB4EAC82CA7396A68D541C85D26508E83_935124188 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_935124188.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_935124188;
        
        
        
        
        
    }

    
}

