package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptionScheme extends AlgorithmIdentifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.344 -0400", hash_original_method = "695FECBCB14F5A1D31F0B55CAC6B7944", hash_generated_method = "0A1DC08A5A4BD42CB02E58A56EFDCACA")
    public  EncryptionScheme(
        DERObjectIdentifier objectId,
        DEREncodable parameters) {
        super(objectId, parameters);
        addTaint(parameters.getTaint());
        addTaint(objectId.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.345 -0400", hash_original_method = "14492AE8746901ADA4AAC49DFFF4DA42", hash_generated_method = "63F156A8427EDB302FF631234B0B5640")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.346 -0400", hash_original_method = "20A4F3D13CF17139753D47801A517EAE", hash_generated_method = "D129296BC61DA23E955FDE0BB3CCA3D9")
    public DERObject getObject() {
DERObject var8EAAA76A40D56861CC2E6AC09D91BF62_524478215 =         (DERObject)getParameters();
        var8EAAA76A40D56861CC2E6AC09D91BF62_524478215.addTaint(taint);
        return var8EAAA76A40D56861CC2E6AC09D91BF62_524478215;
        // ---------- Original Method ----------
        //return (DERObject)getParameters();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.346 -0400", hash_original_method = "0A2A11415EF4AC8722D540FA9324533D", hash_generated_method = "1E6452FEC058B16937A39F608691604F")
    public DERObject getDERObject() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(getObjectId());
        v.add(getParameters());
DERObject var0B338F106E3279986C87B595B0F4A439_2143381029 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_2143381029.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_2143381029;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(getObjectId());
        //v.add(getParameters());
        //return new DERSequence(v);
    }

    
}

