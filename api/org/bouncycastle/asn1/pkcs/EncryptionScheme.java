package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

import droidsafe.annotations.DSGenerator;

public class EncryptionScheme extends AlgorithmIdentifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.939 -0400", hash_original_method = "695FECBCB14F5A1D31F0B55CAC6B7944", hash_generated_method = "0A1DC08A5A4BD42CB02E58A56EFDCACA")
    public  EncryptionScheme(
        DERObjectIdentifier objectId,
        DEREncodable parameters) {
        super(objectId, parameters);
        addTaint(parameters.getTaint());
        addTaint(objectId.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.939 -0400", hash_original_method = "14492AE8746901ADA4AAC49DFFF4DA42", hash_generated_method = "63F156A8427EDB302FF631234B0B5640")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.940 -0400", hash_original_method = "20A4F3D13CF17139753D47801A517EAE", hash_generated_method = "FD37AED40359A9E754838F4364B1CA32")
    public DERObject getObject() {
DERObject var8EAAA76A40D56861CC2E6AC09D91BF62_1907843077 =         (DERObject)getParameters();
        var8EAAA76A40D56861CC2E6AC09D91BF62_1907843077.addTaint(taint);
        return var8EAAA76A40D56861CC2E6AC09D91BF62_1907843077;
        // ---------- Original Method ----------
        //return (DERObject)getParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.940 -0400", hash_original_method = "0A2A11415EF4AC8722D540FA9324533D", hash_generated_method = "FBF46036C458BED8F69372AB35AA38EC")
    public DERObject getDERObject() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(getObjectId());
        v.add(getParameters());
DERObject var0B338F106E3279986C87B595B0F4A439_1529125370 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_1529125370.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_1529125370;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(getObjectId());
        //v.add(getParameters());
        //return new DERSequence(v);
    }

    
}

