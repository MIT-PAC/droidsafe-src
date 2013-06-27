package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptionScheme extends AlgorithmIdentifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.478 -0400", hash_original_method = "695FECBCB14F5A1D31F0B55CAC6B7944", hash_generated_method = "19740A460C9182BF7FFEF075CF1263CB")
    public  EncryptionScheme(
        DERObjectIdentifier objectId,
        DEREncodable parameters) {
        super(objectId, parameters);
        addTaint(objectId.getTaint());
        addTaint(parameters.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.479 -0400", hash_original_method = "14492AE8746901ADA4AAC49DFFF4DA42", hash_generated_method = "63F156A8427EDB302FF631234B0B5640")
      EncryptionScheme(
        ASN1Sequence  seq) {
        this((DERObjectIdentifier)seq.getObjectAt(0), seq.getObjectAt(1));
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
        public static final AlgorithmIdentifier getInstance(Object obj) {
        if (obj instanceof EncryptionScheme)
        {
            return (EncryptionScheme)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new EncryptionScheme((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.481 -0400", hash_original_method = "20A4F3D13CF17139753D47801A517EAE", hash_generated_method = "5C5D48E61D768E0D427C1C0898A96782")
    public DERObject getObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1824658210 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1824658210 = (DERObject)getParameters();
        varB4EAC82CA7396A68D541C85D26508E83_1824658210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1824658210;
        // ---------- Original Method ----------
        //return (DERObject)getParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.494 -0400", hash_original_method = "0A2A11415EF4AC8722D540FA9324533D", hash_generated_method = "A17E397231E558002CF77390D8CADF78")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1509935397 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(getObjectId());
        v.add(getParameters());
        varB4EAC82CA7396A68D541C85D26508E83_1509935397 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1509935397.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1509935397;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(getObjectId());
        //v.add(getParameters());
        //return new DERSequence(v);
    }

    
}

