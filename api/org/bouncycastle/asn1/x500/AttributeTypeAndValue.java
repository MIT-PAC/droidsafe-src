package org.bouncycastle.asn1.x500;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class AttributeTypeAndValue extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.682 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E22429FEAB7082A9C22F35F915934F74")

    private ASN1ObjectIdentifier type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.682 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "65616B4EF69DB0ADA11533A065E6A511")

    private ASN1Encodable value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.682 -0400", hash_original_method = "15E850D5749E9732B50BB178D64D47F4", hash_generated_method = "BE576E64C27CB2D4D46CA97900EFABC5")
    private  AttributeTypeAndValue(ASN1Sequence seq) {
        type = (ASN1ObjectIdentifier)seq.getObjectAt(0);
        value = (ASN1Encodable)seq.getObjectAt(1);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.683 -0400", hash_original_method = "455B7405955E1E537DECB7E0764A59EF", hash_generated_method = "E84A2F5BBB1F65ED45E2832DE9ADFE01")
    public  AttributeTypeAndValue(
        ASN1ObjectIdentifier type,
        ASN1Encodable value) {
        this.type = type;
        this.value = value;
        
        
        
    }

    
        public static AttributeTypeAndValue getInstance(Object o) {
        if (o instanceof AttributeTypeAndValue)
        {
            return (AttributeTypeAndValue)o;
        }
        else if (o != null)
        {
            return new AttributeTypeAndValue(ASN1Sequence.getInstance(o));
        }
        throw new IllegalArgumentException("null value in getInstance()");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.684 -0400", hash_original_method = "55F928B5E605E2163AD3D5D479C3E067", hash_generated_method = "57995449174BC238582A75582A65FCFD")
    public ASN1ObjectIdentifier getType() {
ASN1ObjectIdentifier varC5B9F25B4EEAD3E8E2C33F9429204397_961979033 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_961979033.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_961979033;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.684 -0400", hash_original_method = "C951B7A7C5D7EABF1F828E9D0FE876A9", hash_generated_method = "59A1A420103AE3FE6AF92FAD410CAB18")
    public ASN1Encodable getValue() {
ASN1Encodable varAF280DA2BC37D8BE783D8499160168DE_1667650551 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1667650551.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1667650551;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.684 -0400", hash_original_method = "5081032FA8CA5E98B22B4FF57246FC38", hash_generated_method = "5DD0A024F71A0DA14CC0B1F0BE2F57AA")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(type);
        v.add(value);
DERObject var0B338F106E3279986C87B595B0F4A439_851658618 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_851658618.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_851658618;
        
        
        
        
        
    }

    
}

