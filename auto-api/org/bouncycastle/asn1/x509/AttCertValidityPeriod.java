package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class AttCertValidityPeriod extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.646 -0400", hash_original_field = "2919902F9A6E0F5FCF60B41418F11D15", hash_generated_field = "47DE96B4FD02A134DD50DFF525BEE2DC")

    DERGeneralizedTime notBeforeTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.646 -0400", hash_original_field = "F6D45B6FEDB08A0673FA9C388F80AC1F", hash_generated_field = "F8DBABB88A466E46C9DA55A579BE1BBD")

    DERGeneralizedTime notAfterTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.646 -0400", hash_original_method = "4935F5EA06A87E5EB822F7F5CCD2C830", hash_generated_method = "982D9653FB061CA9FB80BEB54EF1ABFE")
    public  AttCertValidityPeriod(
        ASN1Sequence    seq) {
        {
            boolean var97DBDEEC2A320E15512526B0CE06A30A_1620410759 = (seq.size() != 2);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
            } 
        } 
        notBeforeTime = DERGeneralizedTime.getInstance(seq.getObjectAt(0));
        notAfterTime = DERGeneralizedTime.getInstance(seq.getObjectAt(1));
        
        
        
            
                    
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.647 -0400", hash_original_method = "EE3E4821B31B071C83A5954362B6FCF9", hash_generated_method = "78645F960C6BB66568007E45DEE436B1")
    public  AttCertValidityPeriod(
        DERGeneralizedTime notBeforeTime,
        DERGeneralizedTime notAfterTime) {
        this.notBeforeTime = notBeforeTime;
        this.notAfterTime = notAfterTime;
        
        
        
    }

    
    public static AttCertValidityPeriod getInstance(
            Object  obj) {
        if (obj instanceof AttCertValidityPeriod)
        {
            return (AttCertValidityPeriod)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new AttCertValidityPeriod((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.647 -0400", hash_original_method = "61005B71BB5E250DAD749F45259F34BB", hash_generated_method = "C9E72CDA82855C30655BEEF8E27E9814")
    public DERGeneralizedTime getNotBeforeTime() {
        DERGeneralizedTime varB4EAC82CA7396A68D541C85D26508E83_2259886 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2259886 = notBeforeTime;
        varB4EAC82CA7396A68D541C85D26508E83_2259886.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2259886;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.648 -0400", hash_original_method = "3C0941D5D83A6A464C361337736D354A", hash_generated_method = "24964F91D9124B9AB4666B5C4C382086")
    public DERGeneralizedTime getNotAfterTime() {
        DERGeneralizedTime varB4EAC82CA7396A68D541C85D26508E83_785852405 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_785852405 = notAfterTime;
        varB4EAC82CA7396A68D541C85D26508E83_785852405.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_785852405;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.649 -0400", hash_original_method = "F304C055A3AB57005A726D651B674F2F", hash_generated_method = "AF792CBFDE3DC170A3515F1974F21C49")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1722129827 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(notBeforeTime);
        v.add(notAfterTime);
        varB4EAC82CA7396A68D541C85D26508E83_1722129827 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1722129827.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1722129827;
        
        
        
        
        
    }

    
}

