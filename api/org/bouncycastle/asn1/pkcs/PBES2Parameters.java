package org.bouncycastle.asn1.pkcs;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class PBES2Parameters extends ASN1Encodable implements PKCSObjectIdentifiers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.390 -0400", hash_original_field = "7DF4935F4A5A2865191EF74F64DF8754", hash_generated_field = "A48877E800AAA8ADC77D525D7959F19C")

    private KeyDerivationFunc func;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.390 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "46DE4B11FD863AFD50DE990D444E6098")

    private EncryptionScheme scheme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.391 -0400", hash_original_method = "CA68BEDA74AC2397C06F19E0885D4A85", hash_generated_method = "10660CE61E8D14983DE31523BE450E9A")
    public  PBES2Parameters(
        ASN1Sequence  obj) {
        addTaint(obj.getTaint());
        Enumeration e = obj.getObjects();
        ASN1Sequence funcSeq = ASN1Sequence.getInstance(((DEREncodable)e.nextElement()).getDERObject());
    if(funcSeq.getObjectAt(0).equals(id_PBKDF2))        
        {
            func = new KeyDerivationFunc(id_PBKDF2, PBKDF2Params.getInstance(funcSeq.getObjectAt(1)));
        } 
        else
        {
            func = new KeyDerivationFunc(funcSeq);
        } 
        scheme = (EncryptionScheme)EncryptionScheme.getInstance(e.nextElement());
        
        
        
        
        
            
        
        
        
            
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.392 -0400", hash_original_method = "EA8CB9021471F89DCA3D4DA5F755F4FC", hash_generated_method = "6DBF150153F2CD4CBD54BF16FBA87EA4")
    public KeyDerivationFunc getKeyDerivationFunc() {
KeyDerivationFunc varC9940A7354FB2A62A9E534A0DDC131A7_821260431 =         func;
        varC9940A7354FB2A62A9E534A0DDC131A7_821260431.addTaint(taint);
        return varC9940A7354FB2A62A9E534A0DDC131A7_821260431;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.392 -0400", hash_original_method = "9053FDAC6FE0628F4B096189E8DDF584", hash_generated_method = "C5BBC4A99F5ABF4C8DC4FBD9651AAE31")
    public EncryptionScheme getEncryptionScheme() {
EncryptionScheme varFD3305CF8340E40F0AC0AB554909AEBC_1442337729 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_1442337729.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_1442337729;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.393 -0400", hash_original_method = "489B41034DC44CEDA69ABA933292B2BB", hash_generated_method = "A50F5D740A9CA0ABB7F8D0531CE3849C")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(func);
        v.add(scheme);
DERObject var0B338F106E3279986C87B595B0F4A439_919429608 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_919429608.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_919429608;
        
        
        
        
        
    }

    
}

