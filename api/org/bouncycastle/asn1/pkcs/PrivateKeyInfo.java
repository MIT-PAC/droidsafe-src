package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.462 -0400", hash_original_field = "4AA2361BEE79AADD8595859693612743", hash_generated_field = "151696813A1AC2209490E3CAFBAEDC24")

    private DERObject privKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.462 -0400", hash_original_field = "7E017AD6DBE390CDE33A4543127F45F7", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier algId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.462 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "621E004207975514450E4D4926271721")

    private ASN1Set attributes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.463 -0400", hash_original_method = "A30E81EA2AB5EF2B8533B5735A047E38", hash_generated_method = "130BAFFC48619BCECD919E3970DB98A3")
    public  PrivateKeyInfo(
        AlgorithmIdentifier algId,
        DERObject           privateKey) {
        this(algId, privateKey, null);
        addTaint(privateKey.getTaint());
        addTaint(algId.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.463 -0400", hash_original_method = "94CFD25F02D1F3C4AA4CA24B118947E8", hash_generated_method = "7AC5230DB1193E73BD6862587521CB91")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.464 -0400", hash_original_method = "97D7CEF7A57CDA757D069637093B5F4D", hash_generated_method = "72007DD53C9636068C7043B5EB9BA62B")
    public  PrivateKeyInfo(
        ASN1Sequence  seq) {
        addTaint(seq.getTaint());
        Enumeration e = seq.getObjects();
        BigInteger version = ((DERInteger)e.nextElement()).getValue();
    if(version.intValue() != 0)        
        {
            IllegalArgumentException var70C7C455449CB0AB4D5244C666B7BACA_1536400662 = new IllegalArgumentException("wrong version for private key info");
            var70C7C455449CB0AB4D5244C666B7BACA_1536400662.addTaint(taint);
            throw var70C7C455449CB0AB4D5244C666B7BACA_1536400662;
        } //End block
        algId = new AlgorithmIdentifier((ASN1Sequence)e.nextElement());
        try 
        {
            ASN1InputStream aIn = new ASN1InputStream(((ASN1OctetString)e.nextElement()).getOctets());
            privKey = aIn.readObject();
        } //End block
        catch (IOException ex)
        {
            IllegalArgumentException varBD191BF22F9622BABE1BE9F9902F9818_317553026 = new IllegalArgumentException("Error recoverying private key from sequence");
            varBD191BF22F9622BABE1BE9F9902F9818_317553026.addTaint(taint);
            throw varBD191BF22F9622BABE1BE9F9902F9818_317553026;
        } //End block
    if(e.hasMoreElements())        
        {
            attributes = ASN1Set.getInstance((ASN1TaggedObject)e.nextElement(), false);
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.465 -0400", hash_original_method = "47532F5520D2937711F415E7F39EF8B8", hash_generated_method = "1EDB44030DE36A14B659337C3AE39F81")
    public AlgorithmIdentifier getAlgorithmId() {
AlgorithmIdentifier varA285EDCEC70BDAD72C7F53B57CB6849B_807708050 =         algId;
        varA285EDCEC70BDAD72C7F53B57CB6849B_807708050.addTaint(taint);
        return varA285EDCEC70BDAD72C7F53B57CB6849B_807708050;
        // ---------- Original Method ----------
        //return algId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.465 -0400", hash_original_method = "3451C7D0A2D2ACAC16D97B5B3003A0C1", hash_generated_method = "61FDB448B0F2A8A7F51C95947B26BAAE")
    public DERObject getPrivateKey() {
DERObject var0803189ABA1B5DBB2B13E1F6390C1990_1302151569 =         privKey;
        var0803189ABA1B5DBB2B13E1F6390C1990_1302151569.addTaint(taint);
        return var0803189ABA1B5DBB2B13E1F6390C1990_1302151569;
        // ---------- Original Method ----------
        //return privKey;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.466 -0400", hash_original_method = "2B5879FE48F35BA3284D87B378AFE5E1", hash_generated_method = "3D5EA738697574F7F344EE033278EB87")
    public ASN1Set getAttributes() {
ASN1Set var4BBC8979DB64A9C3E2328AA1E06CDBB3_1795296598 =         attributes;
        var4BBC8979DB64A9C3E2328AA1E06CDBB3_1795296598.addTaint(taint);
        return var4BBC8979DB64A9C3E2328AA1E06CDBB3_1795296598;
        // ---------- Original Method ----------
        //return attributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.466 -0400", hash_original_method = "7CF8276E9977E7549D144BD3BA353868", hash_generated_method = "2E0783EE4F26AF091DACD0D2F541D8F9")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(new DERInteger(0));
        v.add(algId);
        v.add(new DEROctetString(privKey));
    if(attributes != null)        
        {
            v.add(new DERTaggedObject(false, 0, attributes));
        } //End block
DERObject var0B338F106E3279986C87B595B0F4A439_535121073 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_535121073.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_535121073;
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

