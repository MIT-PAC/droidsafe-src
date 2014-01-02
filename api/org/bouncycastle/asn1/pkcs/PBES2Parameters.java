package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;






public class PBES2Parameters extends ASN1Encodable implements PKCSObjectIdentifiers {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.932 -0500", hash_original_method = "0D02E2BE561AC80A137AD9A2760F10AB", hash_generated_method = "7D1250A83C6D321CAFDD12616A2E1C0E")
    
public static PBES2Parameters getInstance(
        Object  obj)
    {
        if (obj== null || obj instanceof PBES2Parameters)
        {
            return (PBES2Parameters)obj;
        }

        if (obj instanceof ASN1Sequence)
        {
            return new PBES2Parameters((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.926 -0500", hash_original_field = "0FE84E3CA35975C0A539AD668B9935FB", hash_generated_field = "A48877E800AAA8ADC77D525D7959F19C")

    private KeyDerivationFunc   func;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.929 -0500", hash_original_field = "8E76607AB0E631ACC9291E304316C084", hash_generated_field = "46DE4B11FD863AFD50DE990D444E6098")

    private EncryptionScheme    scheme;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.935 -0500", hash_original_method = "CA68BEDA74AC2397C06F19E0885D4A85", hash_generated_method = "21CB8A4025B5BBC36E63DF240B3FB1BE")
    
public PBES2Parameters(
        ASN1Sequence  obj)
    {
        Enumeration e = obj.getObjects();
        ASN1Sequence  funcSeq = ASN1Sequence.getInstance(((DEREncodable)e.nextElement()).getDERObject());

        if (funcSeq.getObjectAt(0).equals(id_PBKDF2))
        {
            func = new KeyDerivationFunc(id_PBKDF2, PBKDF2Params.getInstance(funcSeq.getObjectAt(1)));
        }
        else
        {
            func = new KeyDerivationFunc(funcSeq);
        }

        scheme = (EncryptionScheme)EncryptionScheme.getInstance(e.nextElement());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.937 -0500", hash_original_method = "EA8CB9021471F89DCA3D4DA5F755F4FC", hash_generated_method = "0C39902290F218294AD2ED718166DB10")
    
public KeyDerivationFunc getKeyDerivationFunc()
    {
        return func;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.939 -0500", hash_original_method = "9053FDAC6FE0628F4B096189E8DDF584", hash_generated_method = "0D9774060F4752D1B0134356ED32EDA1")
    
public EncryptionScheme getEncryptionScheme()
    {
        return scheme;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.942 -0500", hash_original_method = "489B41034DC44CEDA69ABA933292B2BB", hash_generated_method = "148725131F0B193B8440BE9971F393D8")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(func);
        v.add(scheme);

        return new DERSequence(v);
    }

    
}

