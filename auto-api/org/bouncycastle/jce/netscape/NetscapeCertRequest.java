package org.bouncycastle.jce.netscape;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class NetscapeCertRequest extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.237 -0400", hash_original_field = "8710B712D6001BE6B1DFD7058DD60BA8", hash_generated_field = "EE2A131D5158CEBBA9141A6C94018250")

    AlgorithmIdentifier sigAlg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.237 -0400", hash_original_field = "C1DFA50174835A6BC19B08413D162AF0", hash_generated_field = "F8E5474138E75785580EBCE50F8F784A")

    AlgorithmIdentifier keyAlg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.237 -0400", hash_original_field = "25E4726A06FDFB58BDAB77A972B4E29E", hash_generated_field = "121838C7870C129075D9A1E92F7A9839")

    byte sigBits[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.237 -0400", hash_original_field = "B04EC0ADE3D49B4A079F0E207D5E2821", hash_generated_field = "250DD14315DBA25631465B27752AA1F4")

    String challenge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.237 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "A2F3DA20BD1CF27986C84C664A50FCF1")

    DERBitString content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.237 -0400", hash_original_field = "41CE59683FBBDF3F03B9D3AEF66BC3C9", hash_generated_field = "EC14682B5D712C02F4760CDD94DCE324")

    PublicKey pubkey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.238 -0400", hash_original_method = "E784D2D6D9424F9738F1550A3283A21D", hash_generated_method = "578731D7077838229C848DAEA84ED2C9")
    public  NetscapeCertRequest(
        byte[]  req) throws IOException {
        this(getReq(req));
        addTaint(req[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.238 -0400", hash_original_method = "F4E8ED02C3015EE5D86AD4E86AD94BA5", hash_generated_method = "CA6DB6B3A193679F22A2CFF8CF7B8DDA")
    public  NetscapeCertRequest(ASN1Sequence spkac) {
        try 
        {
            {
                boolean var1CDA8CBF2E504670ED75EA8A5D5754A4_378712989 = (spkac.size() != 3);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("invalid SPKAC (size):"
                        + spkac.size());
                } 
            } 
            sigAlg = new AlgorithmIdentifier((ASN1Sequence)spkac
                    .getObjectAt(1));
            sigBits = ((DERBitString)spkac.getObjectAt(2)).getBytes();
            ASN1Sequence pkac = (ASN1Sequence)spkac.getObjectAt(0);
            {
                boolean var87DA6BB260ECF90892240758CD8FBFF6_2022043342 = (pkac.size() != 2);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("invalid PKAC (len): "
                        + pkac.size());
                } 
            } 
            challenge = ((DERIA5String)pkac.getObjectAt(1)).getString();
            content = new DERBitString(pkac);
            SubjectPublicKeyInfo pubkeyinfo = new SubjectPublicKeyInfo(
                    (ASN1Sequence)pkac.getObjectAt(0));
            X509EncodedKeySpec xspec = new X509EncodedKeySpec(new DERBitString(
                    pubkeyinfo).getBytes());
            keyAlg = pubkeyinfo.getAlgorithmId();
            pubkey = KeyFactory.getInstance(keyAlg.getObjectId().getId(), "BC")
                    .generatePublic(xspec);
        } 
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(e.toString());
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.239 -0400", hash_original_method = "1A82B1619517E26DD541E9FF2CF124F1", hash_generated_method = "DEE91FCADDA2612A8DF8A00CEF4A8771")
    public  NetscapeCertRequest(
        String challenge,
        AlgorithmIdentifier signing_alg,
        PublicKey pub_key) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchProviderException {
        this.challenge = challenge;
        sigAlg = signing_alg;
        pubkey = pub_key;
        ASN1EncodableVector content_der = new ASN1EncodableVector();
        content_der.add(getKeySpec());
        content_der.add(new DERIA5String(challenge));
        content = new DERBitString(new DERSequence(content_der));
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static ASN1Sequence getReq(
        byte[]  r) throws IOException {
        ASN1InputStream aIn = new ASN1InputStream(new ByteArrayInputStream(r));
        return ASN1Sequence.getInstance(aIn.readObject());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.239 -0400", hash_original_method = "ED4D5D58119D3F853ED82C63E0533A7D", hash_generated_method = "F23B40E94EAC5CD7FF3A7C76B5D29AD1")
    public String getChallenge() {
        String varB4EAC82CA7396A68D541C85D26508E83_828940168 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_828940168 = challenge;
        varB4EAC82CA7396A68D541C85D26508E83_828940168.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_828940168;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.240 -0400", hash_original_method = "301D77BA94E757D10A3FA603DC1F3204", hash_generated_method = "ED44293D30BFB95C03F13A1DC78A5455")
    public void setChallenge(String value) {
        challenge = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.240 -0400", hash_original_method = "DEA71583AADCBA6F6FCA4AF03E02FF7E", hash_generated_method = "8941894CF24608738B7B86B69F0ED40C")
    public AlgorithmIdentifier getSigningAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1619768650 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1619768650 = sigAlg;
        varB4EAC82CA7396A68D541C85D26508E83_1619768650.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1619768650;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.240 -0400", hash_original_method = "8DECC6DE401A18CABE51772A2768CD3E", hash_generated_method = "4234E9F4B9918E8F387A0E2A48DC8A2C")
    public void setSigningAlgorithm(AlgorithmIdentifier value) {
        sigAlg = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.241 -0400", hash_original_method = "FE7B6AD2AAFCEFF19EF5259C1AEF0E0B", hash_generated_method = "214EC3D206DA8AF096F660AB641946F3")
    public AlgorithmIdentifier getKeyAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_976882324 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_976882324 = keyAlg;
        varB4EAC82CA7396A68D541C85D26508E83_976882324.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_976882324;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.241 -0400", hash_original_method = "A707B494F7BE2B273065A846BD08233F", hash_generated_method = "3EAE43A81A989F21379DEDADCC255BDB")
    public void setKeyAlgorithm(AlgorithmIdentifier value) {
        keyAlg = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.241 -0400", hash_original_method = "B14D7737A8CCC155007C211714C134B9", hash_generated_method = "FE11604D382D10902A9430C3E766CADA")
    public PublicKey getPublicKey() {
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_410208591 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_410208591 = pubkey;
        varB4EAC82CA7396A68D541C85D26508E83_410208591.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_410208591;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.241 -0400", hash_original_method = "524BDADC1CE3625FA3734945CD591C94", hash_generated_method = "2D5D732B22E00431248C23383E075117")
    public void setPublicKey(PublicKey value) {
        pubkey = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.242 -0400", hash_original_method = "E3E7D887F34AE4BB0FD59D717AA1E296", hash_generated_method = "5A56D5FFBF3BA88F46A029D4416CF9B0")
    public boolean verify(String challenge) throws NoSuchAlgorithmException,
            InvalidKeyException, SignatureException, NoSuchProviderException {
        {
            boolean var0D496AECFCCD894E7DA774FAA5294373_931340069 = (!challenge.equals(this.challenge));
        } 
        Signature sig = Signature.getInstance(sigAlg.getObjectId().getId(),
                "BC");
        sig.initVerify(pubkey);
        sig.update(content.getBytes());
        boolean var5CE50919DB3CB98BA87EB1808E72D4B8_1674592187 = (sig.verify(sigBits));
        addTaint(challenge.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639098159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639098159;
        
        
        
            
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.243 -0400", hash_original_method = "69BFD65CBC2833C297505F1023C7598F", hash_generated_method = "680E4547090D38BE5A6BE9E550A2193D")
    public void sign(PrivateKey priv_key) throws NoSuchAlgorithmException,
            InvalidKeyException, SignatureException, NoSuchProviderException,
            InvalidKeySpecException {
        sign(priv_key, null);
        addTaint(priv_key.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.243 -0400", hash_original_method = "D4E72A005612CE8E458CA009F1575A62", hash_generated_method = "BF340AED05935D0DD39C93EC799435FE")
    public void sign(PrivateKey priv_key, SecureRandom rand) throws NoSuchAlgorithmException, InvalidKeyException,
            SignatureException, NoSuchProviderException,
            InvalidKeySpecException {
        Signature sig = Signature.getInstance(sigAlg.getObjectId().getId(),
                "BC");
        {
            sig.initSign(priv_key, rand);
        } 
        {
            sig.initSign(priv_key);
        } 
        ASN1EncodableVector pkac = new ASN1EncodableVector();
        pkac.add(getKeySpec());
        pkac.add(new DERIA5String(challenge));
        try 
        {
            sig.update(new DERSequence(pkac).getEncoded(ASN1Encodable.DER));
        } 
        catch (IOException ioe)
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException(ioe.getMessage());
        } 
        sigBits = sig.sign();
        addTaint(priv_key.getTaint());
        addTaint(rand.getTaint());
        
        
                
        
        
            
        
        
        
            
        
        
        
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.245 -0400", hash_original_method = "500EEF6D5B4EBED065BB69A7AF04B4E9", hash_generated_method = "3AF25D505EC1B1C31A5CA26CD928A00F")
    private DERObject getKeySpec() throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchProviderException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1456829273 = null; 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DERObject obj = null;
        try 
        {
            baos.write(pubkey.getEncoded());
            baos.close();
            ASN1InputStream derin = new ASN1InputStream(
                    new ByteArrayInputStream(baos.toByteArray()));
            obj = derin.readObject();
        } 
        catch (IOException ioe)
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidKeySpecException(ioe.getMessage());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1456829273 = obj;
        varB4EAC82CA7396A68D541C85D26508E83_1456829273.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1456829273;
        
        
        
        
        
            
            
            
                    
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.247 -0400", hash_original_method = "B0EE724D7F7552AF427D32E04334786D", hash_generated_method = "4831B2AC6EECA5C686D0CCBF5E430D55")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1927065434 = null; 
        ASN1EncodableVector spkac = new ASN1EncodableVector();
        ASN1EncodableVector pkac = new ASN1EncodableVector();
        try 
        {
            pkac.add(getKeySpec());
        } 
        catch (Exception e)
        { }
        pkac.add(new DERIA5String(challenge));
        spkac.add(new DERSequence(pkac));
        spkac.add(sigAlg);
        spkac.add(new DERBitString(sigBits));
        varB4EAC82CA7396A68D541C85D26508E83_1927065434 = new DERSequence(spkac);
        varB4EAC82CA7396A68D541C85D26508E83_1927065434.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1927065434;
        
        
        
        
        
            
        
        
        
        
        
        
        
        
        
    }

    
}

