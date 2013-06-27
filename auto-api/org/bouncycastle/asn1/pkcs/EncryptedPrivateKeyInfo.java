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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.558 -0400", hash_original_field = "7E017AD6DBE390CDE33A4543127F45F7", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier algId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.558 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "E7847206107AFED7061FA6DEEE6B4715")

    private ASN1OctetString data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.559 -0400", hash_original_method = "D7780F085E4F69D75EAD7364F689A92D", hash_generated_method = "28592473F5409C7ACB8AE878F2428B1D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.559 -0400", hash_original_method = "05A2146A24A4B777EF99E759E6105DB4", hash_generated_method = "1D8FF643A8B8E69B31AC57D85BE6BD5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.560 -0400", hash_original_method = "742117C3F9E40BA83B51D9D3C5056A2D", hash_generated_method = "DED6AD51F82E19D27D38B25ED65D5116")
    public AlgorithmIdentifier getEncryptionAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_938329225 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_938329225 = algId;
        varB4EAC82CA7396A68D541C85D26508E83_938329225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_938329225;
        // ---------- Original Method ----------
        //return algId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.560 -0400", hash_original_method = "BBC4FA06F2A86F1789EA116FAB590C10", hash_generated_method = "5F1EDDE6E380A24BD9C528E1A6F25F93")
    public byte[] getEncryptedData() {
        byte[] var061EFA52EC8FE48598A94BA0B5869281_561190137 = (data.getOctets());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1994317129 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1994317129;
        // ---------- Original Method ----------
        //return data.getOctets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.560 -0400", hash_original_method = "1A83B7862624E8339D74A705608FC69D", hash_generated_method = "68442E50AF78305C6ADED6556C0C2349")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1232925686 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(algId);
        v.add(data);
        varB4EAC82CA7396A68D541C85D26508E83_1232925686 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1232925686.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1232925686;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(algId);
        //v.add(data);
        //return new DERSequence(v);
    }

    
}

