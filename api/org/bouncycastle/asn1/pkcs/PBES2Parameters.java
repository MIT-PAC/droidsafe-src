package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;






public class PBES2Parameters extends ASN1Encodable implements PKCSObjectIdentifiers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.978 -0400", hash_original_field = "7DF4935F4A5A2865191EF74F64DF8754", hash_generated_field = "A48877E800AAA8ADC77D525D7959F19C")

    private KeyDerivationFunc func;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.978 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "46DE4B11FD863AFD50DE990D444E6098")

    private EncryptionScheme scheme;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.979 -0400", hash_original_method = "CA68BEDA74AC2397C06F19E0885D4A85", hash_generated_method = "10660CE61E8D14983DE31523BE450E9A")
    public  PBES2Parameters(
        ASN1Sequence  obj) {
        addTaint(obj.getTaint());
        Enumeration e = obj.getObjects();
        ASN1Sequence funcSeq = ASN1Sequence.getInstance(((DEREncodable)e.nextElement()).getDERObject());
        if(funcSeq.getObjectAt(0).equals(id_PBKDF2))        
        {
            func = new KeyDerivationFunc(id_PBKDF2, PBKDF2Params.getInstance(funcSeq.getObjectAt(1)));
        } //End block
        else
        {
            func = new KeyDerivationFunc(funcSeq);
        } //End block
        scheme = (EncryptionScheme)EncryptionScheme.getInstance(e.nextElement());
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

    
    @DSModeled(DSC.SAFE)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.981 -0400", hash_original_method = "EA8CB9021471F89DCA3D4DA5F755F4FC", hash_generated_method = "9D2D3374C893793F73A11DD629254410")
    public KeyDerivationFunc getKeyDerivationFunc() {
KeyDerivationFunc varC9940A7354FB2A62A9E534A0DDC131A7_895110013 =         func;
        varC9940A7354FB2A62A9E534A0DDC131A7_895110013.addTaint(taint);
        return varC9940A7354FB2A62A9E534A0DDC131A7_895110013;
        // ---------- Original Method ----------
        //return func;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.981 -0400", hash_original_method = "9053FDAC6FE0628F4B096189E8DDF584", hash_generated_method = "BFD606CC12EA044C5E4D8529EA5BEABF")
    public EncryptionScheme getEncryptionScheme() {
EncryptionScheme varFD3305CF8340E40F0AC0AB554909AEBC_1227690705 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_1227690705.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_1227690705;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.981 -0400", hash_original_method = "489B41034DC44CEDA69ABA933292B2BB", hash_generated_method = "34E1C07BBC174AE9C0AC5E1F09D9B499")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(func);
        v.add(scheme);
DERObject var0B338F106E3279986C87B595B0F4A439_504936112 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_504936112.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_504936112;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(func);
        //v.add(scheme);
        //return new DERSequence(v);
    }

    
}

