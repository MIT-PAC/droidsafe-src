package org.bouncycastle.jce.netscape;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.286 -0500", hash_original_method = "F4C485F242993B0A9B7E8A2520F2B9A8", hash_generated_method = "7E3D935B8E8666F9D696A30CF2469AA6")
    private static ASN1Sequence getReq(
        byte[]  r)
        throws IOException
    {
        ASN1InputStream aIn = new ASN1InputStream(new ByteArrayInputStream(r));

        return ASN1Sequence.getInstance(aIn.readObject());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.281 -0500", hash_original_field = "EE2A131D5158CEBBA9141A6C94018250", hash_generated_field = "EE2A131D5158CEBBA9141A6C94018250")

    AlgorithmIdentifier    sigAlg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.282 -0500", hash_original_field = "F8E5474138E75785580EBCE50F8F784A", hash_generated_field = "F8E5474138E75785580EBCE50F8F784A")

    AlgorithmIdentifier    keyAlg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.283 -0500", hash_original_field = "121838C7870C129075D9A1E92F7A9839", hash_generated_field = "121838C7870C129075D9A1E92F7A9839")

    byte        sigBits [];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.283 -0500", hash_original_field = "250DD14315DBA25631465B27752AA1F4", hash_generated_field = "250DD14315DBA25631465B27752AA1F4")

    String challenge;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.284 -0500", hash_original_field = "A2F3DA20BD1CF27986C84C664A50FCF1", hash_generated_field = "A2F3DA20BD1CF27986C84C664A50FCF1")

    DERBitString content;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.285 -0500", hash_original_field = "EC14682B5D712C02F4760CDD94DCE324", hash_generated_field = "EC14682B5D712C02F4760CDD94DCE324")

    PublicKey pubkey ;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.287 -0500", hash_original_method = "E784D2D6D9424F9738F1550A3283A21D", hash_generated_method = "FF593CE99751CCE32F70F89F0D64F7AA")
    public NetscapeCertRequest(
        byte[]  req)
        throws IOException
    {
        this(getReq(req));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.288 -0500", hash_original_method = "F4E8ED02C3015EE5D86AD4E86AD94BA5", hash_generated_method = "EC3ACAF5ECD2436B3ED09387ADBA97F4")
    public NetscapeCertRequest (ASN1Sequence spkac)
    {
        try
        {

            //
            // SignedPublicKeyAndChallenge ::= SEQUENCE {
            //    publicKeyAndChallenge    PublicKeyAndChallenge,
            //    signatureAlgorithm    AlgorithmIdentifier,
            //    signature        BIT STRING
            // }
            //
            if (spkac.size() != 3)
            {
                throw new IllegalArgumentException("invalid SPKAC (size):"
                        + spkac.size());
            }

            sigAlg = new AlgorithmIdentifier((ASN1Sequence)spkac
                    .getObjectAt(1));
            sigBits = ((DERBitString)spkac.getObjectAt(2)).getBytes();

            //
            // PublicKeyAndChallenge ::= SEQUENCE {
            //    spki            SubjectPublicKeyInfo,
            //    challenge        IA5STRING
            // }
            //
            ASN1Sequence pkac = (ASN1Sequence)spkac.getObjectAt(0);

            if (pkac.size() != 2)
            {
                throw new IllegalArgumentException("invalid PKAC (len): "
                        + pkac.size());
            }

            challenge = ((DERIA5String)pkac.getObjectAt(1)).getString();

            //this could be dangerous, as ASN.1 decoding/encoding
            //could potentially alter the bytes
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
            throw new IllegalArgumentException(e.toString());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.289 -0500", hash_original_method = "1A82B1619517E26DD541E9FF2CF124F1", hash_generated_method = "3743179673D349E70674050FC7756778")
    public NetscapeCertRequest(
        String challenge,
        AlgorithmIdentifier signing_alg,
        PublicKey pub_key) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchProviderException
    {

        this.challenge = challenge;
        sigAlg = signing_alg;
        pubkey = pub_key;

        ASN1EncodableVector content_der = new ASN1EncodableVector();
        content_der.add(getKeySpec());
        //content_der.add(new SubjectPublicKeyInfo(sigAlg, new RSAPublicKeyStructure(pubkey.getModulus(), pubkey.getPublicExponent()).getDERObject()));
        content_der.add(new DERIA5String(challenge));

        content = new DERBitString(new DERSequence(content_der));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.290 -0500", hash_original_method = "ED4D5D58119D3F853ED82C63E0533A7D", hash_generated_method = "7DDC4530764A43F34C660F2A18F36702")
    public String getChallenge()
    {
        return challenge;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.291 -0500", hash_original_method = "301D77BA94E757D10A3FA603DC1F3204", hash_generated_method = "5F34BE559502B5F19AFBFB548104797A")
    public void setChallenge(String value)
    {
        challenge = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.291 -0500", hash_original_method = "DEA71583AADCBA6F6FCA4AF03E02FF7E", hash_generated_method = "52300D206B0D7E4D3AA5B82212BABDFB")
    public AlgorithmIdentifier getSigningAlgorithm()
    {
        return sigAlg;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.292 -0500", hash_original_method = "8DECC6DE401A18CABE51772A2768CD3E", hash_generated_method = "5A5B812AF33843F46C7392B7BADEF1B1")
    public void setSigningAlgorithm(AlgorithmIdentifier value)
    {
        sigAlg = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.293 -0500", hash_original_method = "FE7B6AD2AAFCEFF19EF5259C1AEF0E0B", hash_generated_method = "3E8612D772D74656DE404BBBD959AB47")
    public AlgorithmIdentifier getKeyAlgorithm()
    {
        return keyAlg;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.294 -0500", hash_original_method = "A707B494F7BE2B273065A846BD08233F", hash_generated_method = "489CA152BCF5F72B417049D1603B81ED")
    public void setKeyAlgorithm(AlgorithmIdentifier value)
    {
        keyAlg = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.294 -0500", hash_original_method = "B14D7737A8CCC155007C211714C134B9", hash_generated_method = "3B1242A41BDFDA35F41118270DDF0CF9")
    public PublicKey getPublicKey()
    {
        return pubkey;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.295 -0500", hash_original_method = "524BDADC1CE3625FA3734945CD591C94", hash_generated_method = "F85A73875ABA0712E47D466B814A75A4")
    public void setPublicKey(PublicKey value)
    {
        pubkey = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.296 -0500", hash_original_method = "E3E7D887F34AE4BB0FD59D717AA1E296", hash_generated_method = "C23FF54D3C7CA3D042A4A190B3488207")
    public boolean verify(String challenge) throws NoSuchAlgorithmException,
            InvalidKeyException, SignatureException, NoSuchProviderException
    {
        if (!challenge.equals(this.challenge))
        {
            return false;
        }

        //
        // Verify the signature .. shows the response was generated
        // by someone who knew the associated private key
        //
        Signature sig = Signature.getInstance(sigAlg.getObjectId().getId(),
                "BC");
        sig.initVerify(pubkey);
        sig.update(content.getBytes());

        return sig.verify(sigBits);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.297 -0500", hash_original_method = "69BFD65CBC2833C297505F1023C7598F", hash_generated_method = "44EFF9804BDDA03516DCDEAE6394D3E1")
    public void sign(PrivateKey priv_key) throws NoSuchAlgorithmException,
            InvalidKeyException, SignatureException, NoSuchProviderException,
            InvalidKeySpecException
    {
        sign(priv_key, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.298 -0500", hash_original_method = "D4E72A005612CE8E458CA009F1575A62", hash_generated_method = "BDA2FABC0AEBA25174D7A3C0D2833E5D")
    public void sign(PrivateKey priv_key, SecureRandom rand)
            throws NoSuchAlgorithmException, InvalidKeyException,
            SignatureException, NoSuchProviderException,
            InvalidKeySpecException
    {
        Signature sig = Signature.getInstance(sigAlg.getObjectId().getId(),
                "BC");

        if (rand != null)
        {
            sig.initSign(priv_key, rand);
        }
        else
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
            throw new SignatureException(ioe.getMessage());
        }

        sigBits = sig.sign();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.298 -0500", hash_original_method = "500EEF6D5B4EBED065BB69A7AF04B4E9", hash_generated_method = "C84528AB26EC58D6F0CCE1BFBF3749C4")
    private DERObject getKeySpec() throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchProviderException
    {
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
            throw new InvalidKeySpecException(ioe.getMessage());
        }
        return obj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.300 -0500", hash_original_method = "B0EE724D7F7552AF427D32E04334786D", hash_generated_method = "E28B05BEAF53850861AE69A799EF7B67")
    public DERObject toASN1Object()
    {
        ASN1EncodableVector spkac = new ASN1EncodableVector();
        ASN1EncodableVector pkac = new ASN1EncodableVector();

        try
        {
            pkac.add(getKeySpec());
        }
        catch (Exception e)
        {
            //ignore
        }

        pkac.add(new DERIA5String(challenge));

        spkac.add(new DERSequence(pkac));
        spkac.add(sigAlg);
        spkac.add(new DERBitString(sigBits));

        return new DERSequence(spkac);
    }

    
}

