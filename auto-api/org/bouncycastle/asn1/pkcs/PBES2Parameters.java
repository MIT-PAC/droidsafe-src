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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.510 -0400", hash_original_field = "7DF4935F4A5A2865191EF74F64DF8754", hash_generated_field = "A48877E800AAA8ADC77D525D7959F19C")

    private KeyDerivationFunc func;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.510 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "46DE4B11FD863AFD50DE990D444E6098")

    private EncryptionScheme scheme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.511 -0400", hash_original_method = "CA68BEDA74AC2397C06F19E0885D4A85", hash_generated_method = "C42B6B9AE175C62076C9632BF4E7B708")
    public  PBES2Parameters(
        ASN1Sequence  obj) {
        Enumeration e;
        e = obj.getObjects();
        ASN1Sequence funcSeq;
        funcSeq = ASN1Sequence.getInstance(((DEREncodable)e.nextElement()).getDERObject());
        {
            boolean varA792FD017A352E961DB7DCD6D1BF50FD_1416865340 = (funcSeq.getObjectAt(0).equals(id_PBKDF2));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.512 -0400", hash_original_method = "EA8CB9021471F89DCA3D4DA5F755F4FC", hash_generated_method = "FF12D9C578D1C1C6BA93B0E05F7C51CE")
    public KeyDerivationFunc getKeyDerivationFunc() {
        KeyDerivationFunc varB4EAC82CA7396A68D541C85D26508E83_1207426537 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1207426537 = func;
        varB4EAC82CA7396A68D541C85D26508E83_1207426537.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1207426537;
        // ---------- Original Method ----------
        //return func;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.513 -0400", hash_original_method = "9053FDAC6FE0628F4B096189E8DDF584", hash_generated_method = "658401B111048D2D091BC312C97E1022")
    public EncryptionScheme getEncryptionScheme() {
        EncryptionScheme varB4EAC82CA7396A68D541C85D26508E83_739342851 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_739342851 = scheme;
        varB4EAC82CA7396A68D541C85D26508E83_739342851.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_739342851;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.513 -0400", hash_original_method = "489B41034DC44CEDA69ABA933292B2BB", hash_generated_method = "69468525AE4B733E3B9724E8A4107225")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1769386129 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(func);
        v.add(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_1769386129 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1769386129.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1769386129;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(func);
        //v.add(scheme);
        //return new DERSequence(v);
    }

    
}

