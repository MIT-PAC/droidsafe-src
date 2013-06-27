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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.901 -0400", hash_original_field = "1EF64C012A52F50C55650F0FE7546D9A", hash_generated_field = "4851D4166E5BF16AA64E550E5ECE0B30")

    private DERObjectIdentifier attrType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.901 -0400", hash_original_field = "EFD717FE854DB7E7EF6210D033ABA119", hash_generated_field = "240506915FE52EB5683D0C9895D89C66")

    private ASN1Set attrValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.907 -0400", hash_original_method = "F858B1E12EC141756BCF51707692EAE3", hash_generated_method = "CB84450B03B44A18CC559B83E759272B")
    public  Attribute(
        ASN1Sequence seq) {
        {
            boolean var97DBDEEC2A320E15512526B0CE06A30A_64562355 = (seq.size() != 2);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.908 -0400", hash_original_method = "38B63F7591289E34615CCB148E077DFB", hash_generated_method = "C56BC70F4D19D384749367E1C1179BC3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.919 -0400", hash_original_method = "C61254DD25EA79572F2B43B889534711", hash_generated_method = "4F4D0BE8A302DAE79FAE2F71518B8E5D")
    public ASN1ObjectIdentifier getAttrType() {
        ASN1ObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_164087789 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_164087789 = new ASN1ObjectIdentifier(attrType.getId());
        varB4EAC82CA7396A68D541C85D26508E83_164087789.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_164087789;
        // ---------- Original Method ----------
        //return new ASN1ObjectIdentifier(attrType.getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.920 -0400", hash_original_method = "3714D5AC97801D67C3C70862DB57F642", hash_generated_method = "54B37285F6D86FF7EDF782A41814911B")
    public ASN1Encodable[] getAttributeValues() {
        ASN1Encodable[] varB4EAC82CA7396A68D541C85D26508E83_338859230 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_338859230 = attrValues.toArray();
        varB4EAC82CA7396A68D541C85D26508E83_338859230.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_338859230;
        // ---------- Original Method ----------
        //return attrValues.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.920 -0400", hash_original_method = "0C9FA4513BA0CB1318C076F6A4C1BAA0", hash_generated_method = "E75D0707F60512308FA5B70C4208CA8F")
    public ASN1Set getAttrValues() {
        ASN1Set varB4EAC82CA7396A68D541C85D26508E83_689098842 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_689098842 = attrValues;
        varB4EAC82CA7396A68D541C85D26508E83_689098842.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_689098842;
        // ---------- Original Method ----------
        //return attrValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.925 -0400", hash_original_method = "7FF9F3775D261945F5C8461E1521856A", hash_generated_method = "CCF314312B669C1A5CB6130BBD0CECF3")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2069410130 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(attrType);
        v.add(attrValues);
        varB4EAC82CA7396A68D541C85D26508E83_2069410130 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_2069410130.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2069410130;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(attrType);
        //v.add(attrValues);
        //return new DERSequence(v);
    }

    
}

