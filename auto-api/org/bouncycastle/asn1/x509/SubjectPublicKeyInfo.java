package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class SubjectPublicKeyInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.104 -0400", hash_original_field = "7E017AD6DBE390CDE33A4543127F45F7", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier algId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.104 -0400", hash_original_field = "FBE14519E78E13F41E1D21BCCBD58AF0", hash_generated_field = "B87CF10479B698EDA26B972A47E11904")

    private DERBitString keyData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.115 -0400", hash_original_method = "DAF161BC79C94F8473696EE08E829AE4", hash_generated_method = "4363098941C5E033671050691A8E48D2")
    public  SubjectPublicKeyInfo(
        AlgorithmIdentifier algId,
        DEREncodable        publicKey) {
        this.keyData = new DERBitString(publicKey);
        this.algId = algId;
        // ---------- Original Method ----------
        //this.keyData = new DERBitString(publicKey);
        //this.algId = algId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.115 -0400", hash_original_method = "01C45324BCF6F8FB0A087E5E236F4467", hash_generated_method = "DCA3B9BB1ABF80FCD998139CDB109A4E")
    public  SubjectPublicKeyInfo(
        AlgorithmIdentifier algId,
        byte[]              publicKey) {
        this.keyData = new DERBitString(publicKey);
        this.algId = algId;
        // ---------- Original Method ----------
        //this.keyData = new DERBitString(publicKey);
        //this.algId = algId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.116 -0400", hash_original_method = "6922DB35904CEC4F9CE097AEE1FB704C", hash_generated_method = "2F1F81195997F7588A2D5794B7828586")
    public  SubjectPublicKeyInfo(
        ASN1Sequence  seq) {
        {
            boolean var97DBDEEC2A320E15512526B0CE06A30A_589191112 = (seq.size() != 2);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
            } //End block
        } //End collapsed parenthetic
        Enumeration e;
        e = seq.getObjects();
        this.algId = AlgorithmIdentifier.getInstance(e.nextElement());
        this.keyData = DERBitString.getInstance(e.nextElement());
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
        //if (seq.size() != 2)
        //{
            //throw new IllegalArgumentException("Bad sequence size: "
                    //+ seq.size());
        //}
        //Enumeration         e = seq.getObjects();
        //this.algId = AlgorithmIdentifier.getInstance(e.nextElement());
        //this.keyData = DERBitString.getInstance(e.nextElement());
    }

    
        public static SubjectPublicKeyInfo getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        public static SubjectPublicKeyInfo getInstance(
        Object  obj) {
        if (obj instanceof SubjectPublicKeyInfo)
        {
            return (SubjectPublicKeyInfo)obj;
        }
        else if (obj != null)
        {
            return new SubjectPublicKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.126 -0400", hash_original_method = "47532F5520D2937711F415E7F39EF8B8", hash_generated_method = "06AFDF9C64694C64F2FD318841A1DCFB")
    public AlgorithmIdentifier getAlgorithmId() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1836799422 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1836799422 = algId;
        varB4EAC82CA7396A68D541C85D26508E83_1836799422.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1836799422;
        // ---------- Original Method ----------
        //return algId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.126 -0400", hash_original_method = "090BC4B735B0EF996158F2D4FCADB97F", hash_generated_method = "49E05428126053301985C40D9C8FE4CA")
    public DERObject getPublicKey() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_561311430 = null; //Variable for return #1
        ASN1InputStream aIn;
        aIn = new ASN1InputStream(keyData.getBytes());
        varB4EAC82CA7396A68D541C85D26508E83_561311430 = aIn.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_561311430.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_561311430;
        // ---------- Original Method ----------
        //ASN1InputStream         aIn = new ASN1InputStream(keyData.getBytes());
        //return aIn.readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.127 -0400", hash_original_method = "FD0FC1FA0D4AD47E47F52CC8C4964141", hash_generated_method = "8EDBE77366E5BC652D3D3C2F889ECAA2")
    public DERBitString getPublicKeyData() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1652777364 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1652777364 = keyData;
        varB4EAC82CA7396A68D541C85D26508E83_1652777364.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1652777364;
        // ---------- Original Method ----------
        //return keyData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.135 -0400", hash_original_method = "8E6747A0EE688E54DEDDDF71F404B9F7", hash_generated_method = "57CB2E7400EA256ED1C308C0CF6A89FF")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_907101755 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(algId);
        v.add(keyData);
        varB4EAC82CA7396A68D541C85D26508E83_907101755 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_907101755.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_907101755;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(algId);
        //v.add(keyData);
        //return new DERSequence(v);
    }

    
}

