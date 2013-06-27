package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class PrivateKeyInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.544 -0400", hash_original_field = "4AA2361BEE79AADD8595859693612743", hash_generated_field = "151696813A1AC2209490E3CAFBAEDC24")

    private DERObject privKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.544 -0400", hash_original_field = "7E017AD6DBE390CDE33A4543127F45F7", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier algId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.544 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "621E004207975514450E4D4926271721")

    private ASN1Set attributes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.547 -0400", hash_original_method = "A30E81EA2AB5EF2B8533B5735A047E38", hash_generated_method = "E37C82076DD23B267FE6965FC0DE39CC")
    public  PrivateKeyInfo(
        AlgorithmIdentifier algId,
        DERObject           privateKey) {
        this(algId, privateKey, null);
        addTaint(algId.getTaint());
        addTaint(privateKey.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.557 -0400", hash_original_method = "94CFD25F02D1F3C4AA4CA24B118947E8", hash_generated_method = "7AC5230DB1193E73BD6862587521CB91")
    public  PrivateKeyInfo(
        AlgorithmIdentifier algId,
        DERObject           privateKey,
        ASN1Set             attributes) {
        this.privKey = privateKey;
        this.algId = algId;
        this.attributes = attributes;
        // ---------- Original Method ----------
        //this.privKey = privateKey;
        //this.algId = algId;
        //this.attributes = attributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.563 -0400", hash_original_method = "97D7CEF7A57CDA757D069637093B5F4D", hash_generated_method = "C14BD7535D62D5F818340F7E2F2739B0")
    public  PrivateKeyInfo(
        ASN1Sequence  seq) {
        Enumeration e;
        e = seq.getObjects();
        BigInteger version;
        version = ((DERInteger)e.nextElement()).getValue();
        {
            boolean varC76388C06CB0E8FC309CF4CE20E6D9F0_92381257 = (version.intValue() != 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("wrong version for private key info");
            } //End block
        } //End collapsed parenthetic
        algId = new AlgorithmIdentifier((ASN1Sequence)e.nextElement());
        try 
        {
            ASN1InputStream aIn;
            aIn = new ASN1InputStream(((ASN1OctetString)e.nextElement()).getOctets());
            privKey = aIn.readObject();
        } //End block
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Error recoverying private key from sequence");
        } //End block
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_852025989 = (e.hasMoreElements());
            {
                attributes = ASN1Set.getInstance((ASN1TaggedObject)e.nextElement(), false);
            } //End block
        } //End collapsed parenthetic
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
        //Enumeration e = seq.getObjects();
        //BigInteger  version = ((DERInteger)e.nextElement()).getValue();
        //if (version.intValue() != 0)
        //{
            //throw new IllegalArgumentException("wrong version for private key info");
        //}
        //algId = new AlgorithmIdentifier((ASN1Sequence)e.nextElement());
        //try
        //{
            //ASN1InputStream         aIn = new ASN1InputStream(((ASN1OctetString)e.nextElement()).getOctets());
            //privKey = aIn.readObject();
        //}
        //catch (IOException ex)
        //{
            //throw new IllegalArgumentException("Error recoverying private key from sequence");
        //}
        //if (e.hasMoreElements())
        //{
           //attributes = ASN1Set.getInstance((ASN1TaggedObject)e.nextElement(), false);
        //}
    }

    
        public static PrivateKeyInfo getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        public static PrivateKeyInfo getInstance(
        Object  obj) {
        if (obj instanceof PrivateKeyInfo)
        {
            return (PrivateKeyInfo)obj;
        }
        else if (obj != null)
        {
            return new PrivateKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.581 -0400", hash_original_method = "47532F5520D2937711F415E7F39EF8B8", hash_generated_method = "0D54876104E82A15AD777114842D93CE")
    public AlgorithmIdentifier getAlgorithmId() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_56182372 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_56182372 = algId;
        varB4EAC82CA7396A68D541C85D26508E83_56182372.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_56182372;
        // ---------- Original Method ----------
        //return algId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.582 -0400", hash_original_method = "3451C7D0A2D2ACAC16D97B5B3003A0C1", hash_generated_method = "E8FD433AC04A57EF23323575EECDE9F8")
    public DERObject getPrivateKey() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1383308704 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1383308704 = privKey;
        varB4EAC82CA7396A68D541C85D26508E83_1383308704.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1383308704;
        // ---------- Original Method ----------
        //return privKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.583 -0400", hash_original_method = "2B5879FE48F35BA3284D87B378AFE5E1", hash_generated_method = "5ECEEDB4507982B7FB50544BDE5D5383")
    public ASN1Set getAttributes() {
        ASN1Set varB4EAC82CA7396A68D541C85D26508E83_1303983966 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1303983966 = attributes;
        varB4EAC82CA7396A68D541C85D26508E83_1303983966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1303983966;
        // ---------- Original Method ----------
        //return attributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.595 -0400", hash_original_method = "7CF8276E9977E7549D144BD3BA353868", hash_generated_method = "2B369016608E6535293D02EFEABB4AC9")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2022529087 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(new DERInteger(0));
        v.add(algId);
        v.add(new DEROctetString(privKey));
        {
            v.add(new DERTaggedObject(false, 0, attributes));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2022529087 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_2022529087.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2022529087;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(new DERInteger(0));
        //v.add(algId);
        //v.add(new DEROctetString(privKey));
        //if (attributes != null)
        //{
            //v.add(new DERTaggedObject(false, 0, attributes));
        //}
        //return new DERSequence(v);
    }

    
}

