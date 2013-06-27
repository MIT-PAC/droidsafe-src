package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class PBES2Parameters extends ASN1Encodable implements PKCSObjectIdentifiers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.588 -0400", hash_original_field = "7DF4935F4A5A2865191EF74F64DF8754", hash_generated_field = "A48877E800AAA8ADC77D525D7959F19C")

    private KeyDerivationFunc func;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.588 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "46DE4B11FD863AFD50DE990D444E6098")

    private EncryptionScheme scheme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.588 -0400", hash_original_method = "CA68BEDA74AC2397C06F19E0885D4A85", hash_generated_method = "75A9AA9E5966504A0B2D9EA1FB0B0168")
    public  PBES2Parameters(
        ASN1Sequence  obj) {
        Enumeration e;
        e = obj.getObjects();
        ASN1Sequence funcSeq;
        funcSeq = ASN1Sequence.getInstance(((DEREncodable)e.nextElement()).getDERObject());
        {
            boolean varA792FD017A352E961DB7DCD6D1BF50FD_1281804818 = (funcSeq.getObjectAt(0).equals(id_PBKDF2));
            {
                func = new KeyDerivationFunc(id_PBKDF2, PBKDF2Params.getInstance(funcSeq.getObjectAt(1)));
            } //End block
            {
                func = new KeyDerivationFunc(funcSeq);
            } //End block
        } //End collapsed parenthetic
        scheme = (EncryptionScheme)EncryptionScheme.getInstance(e.nextElement());
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Enumeration e = obj.getObjects();
        //ASN1Sequence  funcSeq = ASN1Sequence.getInstance(((DEREncodable)e.nextElement()).getDERObject());
        //if (funcSeq.getObjectAt(0).equals(id_PBKDF2))
        //{
            //func = new KeyDerivationFunc(id_PBKDF2, PBKDF2Params.getInstance(funcSeq.getObjectAt(1)));
        //}
        //else
        //{
            //func = new KeyDerivationFunc(funcSeq);
        //}
        //scheme = (EncryptionScheme)EncryptionScheme.getInstance(e.nextElement());
    }

    
        public static PBES2Parameters getInstance(
        Object  obj) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.589 -0400", hash_original_method = "EA8CB9021471F89DCA3D4DA5F755F4FC", hash_generated_method = "F8DEAB6EB2A8986601AD3BBF393C1F21")
    public KeyDerivationFunc getKeyDerivationFunc() {
        KeyDerivationFunc varB4EAC82CA7396A68D541C85D26508E83_675627000 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_675627000 = func;
        varB4EAC82CA7396A68D541C85D26508E83_675627000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_675627000;
        // ---------- Original Method ----------
        //return func;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.590 -0400", hash_original_method = "9053FDAC6FE0628F4B096189E8DDF584", hash_generated_method = "495498E0FE689892100E136FB8694A83")
    public EncryptionScheme getEncryptionScheme() {
        EncryptionScheme varB4EAC82CA7396A68D541C85D26508E83_268679483 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_268679483 = scheme;
        varB4EAC82CA7396A68D541C85D26508E83_268679483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_268679483;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.607 -0400", hash_original_method = "489B41034DC44CEDA69ABA933292B2BB", hash_generated_method = "229488823E75D5B0543147C30A541DB1")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_851628792 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(func);
        v.add(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_851628792 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_851628792.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_851628792;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(func);
        //v.add(scheme);
        //return new DERSequence(v);
    }

    
}

