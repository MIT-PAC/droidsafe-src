package org.bouncycastle.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.x509.Attribute;

public class X509Attribute extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.502 -0400", hash_original_field = "815BE97DF65D6C4B510CD07189C5347A", hash_generated_field = "078373DB546E20C4F10604687E295777")

    Attribute attr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.503 -0400", hash_original_method = "CE4AB458669C1421E9AF493051F17B5E", hash_generated_method = "F73CAD490F69AAFEDE5EE4A251B0330E")
      X509Attribute(
        ASN1Encodable   at) {
        this.attr = Attribute.getInstance(at);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.503 -0400", hash_original_method = "F2072CEA8EE053AA2B225A50B1411CAE", hash_generated_method = "CFBE33AD64AB7DD77DF0E28D00C8CD6A")
    public  X509Attribute(
        String          oid,
        ASN1Encodable   value) {
        this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.504 -0400", hash_original_method = "7A2D44AF2F579D4A5E25B4BDA18E068A", hash_generated_method = "29EC53AB3807C9520CBADE09246B0D7B")
    public  X509Attribute(
        String              oid,
        ASN1EncodableVector value) {
        this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.506 -0400", hash_original_method = "EBAE76CB59DDB3FF6797DC91E3573A47", hash_generated_method = "C1CB6FD77F26CA704D8DD00E512F70A4")
    public String getOID() {
        String varB4EAC82CA7396A68D541C85D26508E83_984341669 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_984341669 = attr.getAttrType().getId();
        varB4EAC82CA7396A68D541C85D26508E83_984341669.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_984341669;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.507 -0400", hash_original_method = "BC207D0C6A8D635D2F61723C6B9C7E5D", hash_generated_method = "86BBA666C86ADD3D6CACEE86F02EED5E")
    public ASN1Encodable[] getValues() {
        ASN1Encodable[] varB4EAC82CA7396A68D541C85D26508E83_1590555071 = null; 
        ASN1Set s = attr.getAttrValues();
        ASN1Encodable[] values = new ASN1Encodable[s.size()];
        {
            int i = 0;
            boolean var49BF39439B4D2A68F10DF03D535E07DA_1791996574 = (i != s.size());
            {
                values[i] = (ASN1Encodable)s.getObjectAt(i);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1590555071 = values;
        varB4EAC82CA7396A68D541C85D26508E83_1590555071.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1590555071;
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.508 -0400", hash_original_method = "B86A9DDF1DB3AD0B2C8F07C01CCF4C19", hash_generated_method = "9A91D188317FEBE1AA3205CA8D9E1620")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1194663999 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1194663999 = attr.toASN1Object();
        varB4EAC82CA7396A68D541C85D26508E83_1194663999.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1194663999;
        
        
    }

    
}

