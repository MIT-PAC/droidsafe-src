package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AttributeTypeAndValue extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.287 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E22429FEAB7082A9C22F35F915934F74")

    private ASN1ObjectIdentifier type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.287 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "65616B4EF69DB0ADA11533A065E6A511")

    private ASN1Encodable value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.288 -0400", hash_original_method = "15E850D5749E9732B50BB178D64D47F4", hash_generated_method = "BE576E64C27CB2D4D46CA97900EFABC5")
    private  AttributeTypeAndValue(ASN1Sequence seq) {
        type = (ASN1ObjectIdentifier)seq.getObjectAt(0);
        value = (ASN1Encodable)seq.getObjectAt(1);
        // ---------- Original Method ----------
        //type = (ASN1ObjectIdentifier)seq.getObjectAt(0);
        //value = (ASN1Encodable)seq.getObjectAt(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.289 -0400", hash_original_method = "455B7405955E1E537DECB7E0764A59EF", hash_generated_method = "E84A2F5BBB1F65ED45E2832DE9ADFE01")
    public  AttributeTypeAndValue(
        ASN1ObjectIdentifier type,
        ASN1Encodable value) {
        this.type = type;
        this.value = value;
        // ---------- Original Method ----------
        //this.type = type;
        //this.value = value;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.291 -0400", hash_original_method = "55F928B5E605E2163AD3D5D479C3E067", hash_generated_method = "94216C3B09872CA935B3857A700EFEBD")
    public ASN1ObjectIdentifier getType() {
ASN1ObjectIdentifier varC5B9F25B4EEAD3E8E2C33F9429204397_697468781 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_697468781.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_697468781;
        // ---------- Original Method ----------
        //return type;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.291 -0400", hash_original_method = "C951B7A7C5D7EABF1F828E9D0FE876A9", hash_generated_method = "ED4308DC8DBC1B1A75FD0E6D3558F08F")
    public ASN1Encodable getValue() {
ASN1Encodable varAF280DA2BC37D8BE783D8499160168DE_1445026763 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1445026763.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1445026763;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.292 -0400", hash_original_method = "5081032FA8CA5E98B22B4FF57246FC38", hash_generated_method = "7F9411B575A07BA830E42C65253D1A04")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(type);
        v.add(value);
DERObject var0B338F106E3279986C87B595B0F4A439_538132413 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_538132413.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_538132413;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(type);
        //v.add(value);
        //return new DERSequence(v);
    }

    
}

