package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.825 -0400", hash_original_field = "1EF64C012A52F50C55650F0FE7546D9A", hash_generated_field = "4851D4166E5BF16AA64E550E5ECE0B30")

    private DERObjectIdentifier attrType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.826 -0400", hash_original_field = "EFD717FE854DB7E7EF6210D033ABA119", hash_generated_field = "240506915FE52EB5683D0C9895D89C66")

    private ASN1Set attrValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.833 -0400", hash_original_method = "F858B1E12EC141756BCF51707692EAE3", hash_generated_method = "100C219A8D2527E5D863391CA5179321")
    public  Attribute(
        ASN1Sequence seq) {
        {
            boolean var97DBDEEC2A320E15512526B0CE06A30A_1728221355 = (seq.size() != 2);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } //End block
        } //End collapsed parenthetic
        attrType = DERObjectIdentifier.getInstance(seq.getObjectAt(0));
        attrValues = ASN1Set.getInstance(seq.getObjectAt(1));
        // ---------- Original Method ----------
        //if (seq.size() != 2)
        //{
            //throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        //}
        //attrType = DERObjectIdentifier.getInstance(seq.getObjectAt(0));
        //attrValues = ASN1Set.getInstance(seq.getObjectAt(1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.835 -0400", hash_original_method = "38B63F7591289E34615CCB148E077DFB", hash_generated_method = "C56BC70F4D19D384749367E1C1179BC3")
    public  Attribute(
        DERObjectIdentifier attrType,
        ASN1Set             attrValues) {
        this.attrType = attrType;
        this.attrValues = attrValues;
        // ---------- Original Method ----------
        //this.attrType = attrType;
        //this.attrValues = attrValues;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.845 -0400", hash_original_method = "C61254DD25EA79572F2B43B889534711", hash_generated_method = "FF20C45F2299F07D5F500F0B3EF5BD39")
    public ASN1ObjectIdentifier getAttrType() {
        ASN1ObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_391187687 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_391187687 = new ASN1ObjectIdentifier(attrType.getId());
        varB4EAC82CA7396A68D541C85D26508E83_391187687.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_391187687;
        // ---------- Original Method ----------
        //return new ASN1ObjectIdentifier(attrType.getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.846 -0400", hash_original_method = "3714D5AC97801D67C3C70862DB57F642", hash_generated_method = "0562BEF893DA3C1DF2CA0217E0F786A6")
    public ASN1Encodable[] getAttributeValues() {
        ASN1Encodable[] varB4EAC82CA7396A68D541C85D26508E83_532190261 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_532190261 = attrValues.toArray();
        varB4EAC82CA7396A68D541C85D26508E83_532190261.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_532190261;
        // ---------- Original Method ----------
        //return attrValues.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.846 -0400", hash_original_method = "0C9FA4513BA0CB1318C076F6A4C1BAA0", hash_generated_method = "C3A4018B7DCA81A593CCBE5B7EF2A64F")
    public ASN1Set getAttrValues() {
        ASN1Set varB4EAC82CA7396A68D541C85D26508E83_1978914232 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1978914232 = attrValues;
        varB4EAC82CA7396A68D541C85D26508E83_1978914232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1978914232;
        // ---------- Original Method ----------
        //return attrValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.847 -0400", hash_original_method = "7FF9F3775D261945F5C8461E1521856A", hash_generated_method = "0F5D4689B9E2BDF57BC27D8CB15D64F0")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1314595138 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(attrType);
        v.add(attrValues);
        varB4EAC82CA7396A68D541C85D26508E83_1314595138 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1314595138.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1314595138;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(attrType);
        //v.add(attrValues);
        //return new DERSequence(v);
    }

    
}

