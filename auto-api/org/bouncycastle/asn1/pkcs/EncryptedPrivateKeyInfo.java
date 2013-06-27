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
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedPrivateKeyInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.450 -0400", hash_original_field = "7E017AD6DBE390CDE33A4543127F45F7", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier algId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.450 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "E7847206107AFED7061FA6DEEE6B4715")

    private ASN1OctetString data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.451 -0400", hash_original_method = "D7780F085E4F69D75EAD7364F689A92D", hash_generated_method = "28592473F5409C7ACB8AE878F2428B1D")
    public  EncryptedPrivateKeyInfo(
        ASN1Sequence  seq) {
        Enumeration e;
        e = seq.getObjects();
        algId = AlgorithmIdentifier.getInstance(e.nextElement());
        data = (ASN1OctetString)e.nextElement();
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
        //Enumeration e = seq.getObjects();
        //algId = AlgorithmIdentifier.getInstance(e.nextElement());
        //data = (ASN1OctetString)e.nextElement();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.457 -0400", hash_original_method = "05A2146A24A4B777EF99E759E6105DB4", hash_generated_method = "1D8FF643A8B8E69B31AC57D85BE6BD5D")
    public  EncryptedPrivateKeyInfo(
        AlgorithmIdentifier algId,
        byte[]              encoding) {
        this.algId = algId;
        this.data = new DEROctetString(encoding);
        // ---------- Original Method ----------
        //this.algId = algId;
        //this.data = new DEROctetString(encoding);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.458 -0400", hash_original_method = "742117C3F9E40BA83B51D9D3C5056A2D", hash_generated_method = "0BC0EC44E51070F0BBFDAF1BFD92C59F")
    public AlgorithmIdentifier getEncryptionAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1692075223 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1692075223 = algId;
        varB4EAC82CA7396A68D541C85D26508E83_1692075223.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1692075223;
        // ---------- Original Method ----------
        //return algId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.458 -0400", hash_original_method = "BBC4FA06F2A86F1789EA116FAB590C10", hash_generated_method = "B66FD598A69486508628CCBA133FCBC9")
    public byte[] getEncryptedData() {
        byte[] var061EFA52EC8FE48598A94BA0B5869281_1788535481 = (data.getOctets());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1095472073 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1095472073;
        // ---------- Original Method ----------
        //return data.getOctets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.472 -0400", hash_original_method = "1A83B7862624E8339D74A705608FC69D", hash_generated_method = "4E2036CAAAD824BFC05E7563E0BC4C39")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2016554509 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(algId);
        v.add(data);
        varB4EAC82CA7396A68D541C85D26508E83_2016554509 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_2016554509.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2016554509;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(algId);
        //v.add(data);
        //return new DERSequence(v);
    }

    
}

