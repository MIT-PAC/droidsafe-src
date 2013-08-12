package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;






public class EncryptedPrivateKeyInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.921 -0400", hash_original_field = "7E017AD6DBE390CDE33A4543127F45F7", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier algId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.921 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "E7847206107AFED7061FA6DEEE6B4715")

    private ASN1OctetString data;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.922 -0400", hash_original_method = "D7780F085E4F69D75EAD7364F689A92D", hash_generated_method = "DE44E6FDE373BEF984D943993C27E632")
    public  EncryptedPrivateKeyInfo(
        ASN1Sequence  seq) {
        addTaint(seq.getTaint());
        Enumeration e = seq.getObjects();
        algId = AlgorithmIdentifier.getInstance(e.nextElement());
        data = (ASN1OctetString)e.nextElement();
        // ---------- Original Method ----------
        //Enumeration e = seq.getObjects();
        //algId = AlgorithmIdentifier.getInstance(e.nextElement());
        //data = (ASN1OctetString)e.nextElement();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.923 -0400", hash_original_method = "05A2146A24A4B777EF99E759E6105DB4", hash_generated_method = "1D8FF643A8B8E69B31AC57D85BE6BD5D")
    public  EncryptedPrivateKeyInfo(
        AlgorithmIdentifier algId,
        byte[]              encoding) {
        this.algId = algId;
        this.data = new DEROctetString(encoding);
        // ---------- Original Method ----------
        //this.algId = algId;
        //this.data = new DEROctetString(encoding);
    }

    
    @DSModeled(DSC.SAFE)
    public static EncryptedPrivateKeyInfo getInstance(
        Object  obj) {
        if (obj instanceof EncryptedPrivateKeyInfo)
        {
            return (EncryptedPrivateKeyInfo)obj;
        }
        else if (obj instanceof ASN1Sequence)
        { 
            return new EncryptedPrivateKeyInfo((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.923 -0400", hash_original_method = "742117C3F9E40BA83B51D9D3C5056A2D", hash_generated_method = "B66988507BB21F39D8A44F93BE4AB319")
    public AlgorithmIdentifier getEncryptionAlgorithm() {
AlgorithmIdentifier varA285EDCEC70BDAD72C7F53B57CB6849B_604131589 =         algId;
        varA285EDCEC70BDAD72C7F53B57CB6849B_604131589.addTaint(taint);
        return varA285EDCEC70BDAD72C7F53B57CB6849B_604131589;
        // ---------- Original Method ----------
        //return algId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.924 -0400", hash_original_method = "BBC4FA06F2A86F1789EA116FAB590C10", hash_generated_method = "E63C4CD7924E1BE55618C465CACE056A")
    public byte[] getEncryptedData() {
        byte[] var5EE6B65A36B3C65F89881A2A71E8AF96_1026067775 = (data.getOctets());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1712231635 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1712231635;
        // ---------- Original Method ----------
        //return data.getOctets();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.924 -0400", hash_original_method = "1A83B7862624E8339D74A705608FC69D", hash_generated_method = "E6748229D61D9D38B633EF15B4B3FB64")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(algId);
        v.add(data);
DERObject var0B338F106E3279986C87B595B0F4A439_1315309061 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_1315309061.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_1315309061;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(algId);
        //v.add(data);
        //return new DERSequence(v);
    }

    
}

