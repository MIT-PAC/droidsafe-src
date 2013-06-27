package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.x509.Attribute;

public class X509Attribute extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.027 -0400", hash_original_field = "815BE97DF65D6C4B510CD07189C5347A", hash_generated_field = "078373DB546E20C4F10604687E295777")

    Attribute attr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.028 -0400", hash_original_method = "CE4AB458669C1421E9AF493051F17B5E", hash_generated_method = "F73CAD490F69AAFEDE5EE4A251B0330E")
      X509Attribute(
        ASN1Encodable   at) {
        this.attr = Attribute.getInstance(at);
        // ---------- Original Method ----------
        //this.attr = Attribute.getInstance(at);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.028 -0400", hash_original_method = "F2072CEA8EE053AA2B225A50B1411CAE", hash_generated_method = "CFBE33AD64AB7DD77DF0E28D00C8CD6A")
    public  X509Attribute(
        String          oid,
        ASN1Encodable   value) {
        this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
        // ---------- Original Method ----------
        //this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.028 -0400", hash_original_method = "7A2D44AF2F579D4A5E25B4BDA18E068A", hash_generated_method = "29EC53AB3807C9520CBADE09246B0D7B")
    public  X509Attribute(
        String              oid,
        ASN1EncodableVector value) {
        this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
        // ---------- Original Method ----------
        //this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.028 -0400", hash_original_method = "EBAE76CB59DDB3FF6797DC91E3573A47", hash_generated_method = "AFE303C800949C524687FD1971B79F4D")
    public String getOID() {
        String varB4EAC82CA7396A68D541C85D26508E83_2054734265 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2054734265 = attr.getAttrType().getId();
        varB4EAC82CA7396A68D541C85D26508E83_2054734265.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2054734265;
        // ---------- Original Method ----------
        //return attr.getAttrType().getId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.029 -0400", hash_original_method = "BC207D0C6A8D635D2F61723C6B9C7E5D", hash_generated_method = "1FE905288FBADA90E918FA6F15A8F6BC")
    public ASN1Encodable[] getValues() {
        ASN1Encodable[] varB4EAC82CA7396A68D541C85D26508E83_1489345863 = null; //Variable for return #1
        ASN1Set s;
        s = attr.getAttrValues();
        ASN1Encodable[] values;
        values = new ASN1Encodable[s.size()];
        {
            int i;
            i = 0;
            boolean var49BF39439B4D2A68F10DF03D535E07DA_866997759 = (i != s.size());
            {
                values[i] = (ASN1Encodable)s.getObjectAt(i);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1489345863 = values;
        varB4EAC82CA7396A68D541C85D26508E83_1489345863.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1489345863;
        // ---------- Original Method ----------
        //ASN1Set         s = attr.getAttrValues();
        //ASN1Encodable[] values = new ASN1Encodable[s.size()];
        //for (int i = 0; i != s.size(); i++)
        //{
            //values[i] = (ASN1Encodable)s.getObjectAt(i);
        //}
        //return values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.030 -0400", hash_original_method = "B86A9DDF1DB3AD0B2C8F07C01CCF4C19", hash_generated_method = "2F6C512EA86FED08935EB92F4B75904C")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_553493083 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_553493083 = attr.toASN1Object();
        varB4EAC82CA7396A68D541C85D26508E83_553493083.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_553493083;
        // ---------- Original Method ----------
        //return attr.toASN1Object();
    }

    
}

