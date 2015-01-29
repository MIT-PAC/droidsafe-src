package org.bouncycastle.jce;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.CertificationRequest;
import org.bouncycastle.asn1.pkcs.CertificationRequestInfo;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Strings;

public class PKCS10CertificationRequest extends CertificationRequest {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.223 -0500", hash_original_method = "25B2A761D6FCD88D1F6D5EF8095097C3", hash_generated_method = "BBC0B09FA1E82C1739E7BED70CD2D30F")
    
private static RSASSAPSSparams creatPSSParams(AlgorithmIdentifier hashAlgId, int saltSize)
    {
        return new RSASSAPSSparams(
            hashAlgId,
            new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, hashAlgId),
            new DERInteger(saltSize),
            new DERInteger(1));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.225 -0500", hash_original_method = "B7B42C128A250CD690CFAC82FBCAFAD6", hash_generated_method = "49F9951902F74AC0AD87EAA49D146595")
    
private static ASN1Sequence toDERSequence(
        byte[]  bytes)
    {
        try
        {
            ASN1InputStream         dIn = new ASN1InputStream(bytes);

            return (ASN1Sequence)dIn.readObject();
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("badly encoded request");
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.237 -0500", hash_original_method = "1712D37D77918FC140E45AF86BEEDC9E", hash_generated_method = "AEAD122CB780C3B8C0E5BB640A83C181")
    
private static X509Name convertName(
        X500Principal    name)
    {
        try
        {
            return new X509Principal(name.getEncoded());
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("can't convert name");
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.267 -0500", hash_original_method = "9038DA3F1958107AA4433A375AF2AA35", hash_generated_method = "9A4696D6131CE918E35B6EA2D2873C98")
    
static String getSignatureName(
        AlgorithmIdentifier sigAlgId)
    {
        DEREncodable params = sigAlgId.getParameters();

        if (params != null && !DERNull.INSTANCE.equals(params))
        {
            if (sigAlgId.getObjectId().equals(PKCSObjectIdentifiers.id_RSASSA_PSS))
            {
                RSASSAPSSparams rsaParams = RSASSAPSSparams.getInstance(params);
                return getDigestAlgName(rsaParams.getHashAlgorithm().getObjectId()) + "withRSAandMGF1";
            }
        }

        return sigAlgId.getObjectId().getId();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.270 -0500", hash_original_method = "E4BEEAE8AEEE7829CDFFCFF7B53EF391", hash_generated_method = "96DEB51CD8B19C25BE874E5A654ABB40")
    
private static String getDigestAlgName(
        DERObjectIdentifier digestAlgOID)
    {
        if (PKCSObjectIdentifiers.md5.equals(digestAlgOID))
        {
            return "MD5";
        }
        else if (OIWObjectIdentifiers.idSHA1.equals(digestAlgOID))
        {
            return "SHA1";
        }
        // BEGIN android-removed
        // else if (NISTObjectIdentifiers.id_sha224.equals(digestAlgOID))
        // {
        //     return "SHA224";
        // }
        // END android-removed
        else if (NISTObjectIdentifiers.id_sha256.equals(digestAlgOID))
        {
            return "SHA256";
        }
        else if (NISTObjectIdentifiers.id_sha384.equals(digestAlgOID))
        {
            return "SHA384";
        }
        else if (NISTObjectIdentifiers.id_sha512.equals(digestAlgOID))
        {
            return "SHA512";
        }
        // BEGIN android-removed
        // else if (TeleTrusTObjectIdentifiers.ripemd128.equals(digestAlgOID))
        // {
        //     return "RIPEMD128";
        // }
        // else if (TeleTrusTObjectIdentifiers.ripemd160.equals(digestAlgOID))
        // {
        //     return "RIPEMD160";
        // }
        // else if (TeleTrusTObjectIdentifiers.ripemd256.equals(digestAlgOID))
        // {
        //     return "RIPEMD256";
        // }
        // else if (CryptoProObjectIdentifiers.gostR3411.equals(digestAlgOID))
        // {
        //     return "GOST3411";
        // }
        // END android-removed
        else
        {
            return digestAlgOID.getId();            
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.209 -0500", hash_original_field = "A8B38EFEBE1FD690B18E15CE341717C3", hash_generated_field = "2A7E0957EAD856B3315504481686A7DE")

    private static Hashtable            algorithms = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.212 -0500", hash_original_field = "9F226D98C1CB8D80E9F82A4DB61E3C25", hash_generated_field = "3580C2237188FBF88703AFC814D06B98")

    private static Hashtable            params = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.214 -0500", hash_original_field = "9983F7ECB8274F6EDC057E020591B9F9", hash_generated_field = "C8FBF8B644E3B7297D2EC131F85F7B39")

    private static Hashtable            keyAlgorithms = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.217 -0500", hash_original_field = "321B66DBE27FCDCC20E9094F46ED8726", hash_generated_field = "6D958D15EBDB3005FA7CB66D7A014B22")

    private static Hashtable            oids = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.219 -0500", hash_original_field = "3251BB4B6326B92285C39B28EEE8EF19", hash_generated_field = "E222E546E7C245483C60E7B45F19B3A8")

    private static Set                  noParams = new HashSet();

    /**
     * construct a PKCS10 certification request from a DER encoded
     * byte stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.228 -0500", hash_original_method = "3A41672F51C7647865E5A6F21420932E", hash_generated_method = "7CC931B79D0F2CBE4F800519728D8281")
    
public PKCS10CertificationRequest(
        byte[]  bytes)
    {
        super(toDERSequence(bytes));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.230 -0500", hash_original_method = "E80E9113023CB84AD6D915B7A5F597A7", hash_generated_method = "CE7605C128F64B8FA557EA677E644E8A")
    
public PKCS10CertificationRequest(
        ASN1Sequence  sequence)
    {
        super(sequence);
    }

    /**
     * create a PKCS10 certfication request using the BC provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.233 -0500", hash_original_method = "DCC234DC4AA32AD53B9F45C5CD92E5AA", hash_generated_method = "E6AC43C33B37640BFAB5E9FD0FD9D86B")
    
public PKCS10CertificationRequest(
        String              signatureAlgorithm,
        X509Name            subject,
        PublicKey           key,
        ASN1Set             attributes,
        PrivateKey          signingKey)
        throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException
    {
        this(signatureAlgorithm, subject, key, attributes, signingKey, BouncyCastleProvider.PROVIDER_NAME);
    }
    
    /**
     * create a PKCS10 certfication request using the BC provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.239 -0500", hash_original_method = "8331D41600BE6136ABFAAFB9EC7881F5", hash_generated_method = "324750FBBE8C80F17D896F967175A5D6")
    
public PKCS10CertificationRequest(
        String              signatureAlgorithm,
        X500Principal       subject,
        PublicKey           key,
        ASN1Set             attributes,
        PrivateKey          signingKey)
        throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException
    {
        this(signatureAlgorithm, convertName(subject), key, attributes, signingKey, BouncyCastleProvider.PROVIDER_NAME);
    }
    
    /**
     * create a PKCS10 certfication request using the named provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.242 -0500", hash_original_method = "47F27C3C5B072C1921CEA8CD2618865D", hash_generated_method = "9D8CFACFF8E35C4B4371E245059063AE")
    
public PKCS10CertificationRequest(
        String              signatureAlgorithm,
        X500Principal       subject,
        PublicKey           key,
        ASN1Set             attributes,
        PrivateKey          signingKey,
        String              provider)
        throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException
    {
        this(signatureAlgorithm, convertName(subject), key, attributes, signingKey, provider);
    }
    
    /**
     * create a PKCS10 certfication request using the named provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.246 -0500", hash_original_method = "9B8C4723941705C4AF87CD12244595BD", hash_generated_method = "DD7F4EF291BE4E4AF536E68B0F4C8912")
    
public PKCS10CertificationRequest(
        String              signatureAlgorithm,
        X509Name            subject,
        PublicKey           key,
        ASN1Set             attributes,
        PrivateKey          signingKey,
        String              provider)
        throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException
    {
        String algorithmName = Strings.toUpperCase(signatureAlgorithm);
        DERObjectIdentifier sigOID = (DERObjectIdentifier)algorithms.get(algorithmName);

        if (sigOID == null)
        {
            try
            {
                sigOID = new DERObjectIdentifier(algorithmName);
            }
            catch (Exception e)
            {
                throw new IllegalArgumentException("Unknown signature type requested");
            }
        }

        if (subject == null)
        {
            throw new IllegalArgumentException("subject must not be null");
        }

        if (key == null)
        {
            throw new IllegalArgumentException("public key must not be null");
        }

        if (noParams.contains(sigOID))
        {
            this.sigAlgId = new AlgorithmIdentifier(sigOID);
        }
        else if (params.containsKey(algorithmName))
        {
            this.sigAlgId = new AlgorithmIdentifier(sigOID, (DEREncodable)params.get(algorithmName));
        }
        else
        {
            this.sigAlgId = new AlgorithmIdentifier(sigOID, DERNull.INSTANCE);
        }

        try
        {
            ASN1Sequence seq = (ASN1Sequence)ASN1Object.fromByteArray(key.getEncoded());
            this.reqInfo = new CertificationRequestInfo(subject, new SubjectPublicKeyInfo(seq), attributes);
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("can't encode public key");
        }

        Signature sig;
        if (provider == null)
        {
            sig = Signature.getInstance(signatureAlgorithm);
        }
        else
        {
            sig = Signature.getInstance(signatureAlgorithm, provider);
        }

        sig.initSign(signingKey);

        try
        {
            sig.update(reqInfo.getEncoded(ASN1Encodable.DER));
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("exception encoding TBS cert request - " + e);
        }

        this.sigBits = new DERBitString(sig.sign());
    }

    /**
     * return the public key associated with the certification request -
     * the public key is created using the BC provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.248 -0500", hash_original_method = "43324B511CA49EBF5AC84C5892E16660", hash_generated_method = "9C8E7A5652AD54B82F68169E31DFCC08")
    
public PublicKey getPublicKey()
        throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException
    {
        return getPublicKey(BouncyCastleProvider.PROVIDER_NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.251 -0500", hash_original_method = "B8875DFEFA5CEF760F6C887EECDEC741", hash_generated_method = "A2EA45DB0FBA486491FFB3ECA56DB54B")
    
public PublicKey getPublicKey(
        String  provider)
        throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException
    {
        SubjectPublicKeyInfo    subjectPKInfo = reqInfo.getSubjectPublicKeyInfo();
        X509EncodedKeySpec      xspec = new X509EncodedKeySpec(new DERBitString(subjectPKInfo).getBytes());
        AlgorithmIdentifier     keyAlg = subjectPKInfo.getAlgorithmId();
        
        try
        {
            try
            {
                if (provider == null)
                {
                    return KeyFactory.getInstance(keyAlg.getObjectId().getId()).generatePublic(xspec);
                }
                else
                {
                    return KeyFactory.getInstance(keyAlg.getObjectId().getId(), provider).generatePublic(xspec);
                }
            }
            catch (NoSuchAlgorithmException e)
            {
                //
                // try an alternate
                //
                if (keyAlgorithms.get(keyAlg.getObjectId()) != null)
                {
                    String  keyAlgorithm = (String)keyAlgorithms.get(keyAlg.getObjectId());
                    
                    if (provider == null)
                    {
                        return KeyFactory.getInstance(keyAlgorithm).generatePublic(xspec);
                    }
                    else
                    {
                        return KeyFactory.getInstance(keyAlgorithm, provider).generatePublic(xspec);
                    }
                }
                
                throw e;
            }
        }
        catch (InvalidKeySpecException e)
        {
            throw new InvalidKeyException("error decoding public key");
        }
    }

    /**
     * verify the request using the BC provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.253 -0500", hash_original_method = "76B4A35CDD087589FE1D86D8EB63F14C", hash_generated_method = "0E8AE9B05A74B6F7DE6780CF3FACE534")
    
public boolean verify()
        throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException
    {
        return verify(BouncyCastleProvider.PROVIDER_NAME);
    }

    /**
     * verify the request using the passed in provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.255 -0500", hash_original_method = "EEEA1D6F83C84A4A1EBDD2FD7850BFFE", hash_generated_method = "6A266B715AEA1EC82B0D2051E5253859")
    
public boolean verify(
        String provider)
        throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException
    {
        return verify(this.getPublicKey(provider), provider);
    }

    /**
     * verify the request using the passed in public key and the provider..
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.258 -0500", hash_original_method = "23EDAE0C7E13C4B3F88052C2DB8B64F6", hash_generated_method = "42E7C75D85E2C3704A1ADD32430A0AF4")
    
public boolean verify(
        PublicKey pubKey,
        String provider)
        throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException
    {
        Signature   sig;

        try
        {
            if (provider == null)
            {
                sig = Signature.getInstance(getSignatureName(sigAlgId));
            }
            else
            {
                sig = Signature.getInstance(getSignatureName(sigAlgId), provider);
            }
        }
        catch (NoSuchAlgorithmException e)
        {
            //
            // try an alternate
            //
            if (oids.get(sigAlgId.getObjectId()) != null)
            {
                String  signatureAlgorithm = (String)oids.get(sigAlgId.getObjectId());

                if (provider == null)
                {
                    sig = Signature.getInstance(signatureAlgorithm);
                }
                else
                {
                    sig = Signature.getInstance(signatureAlgorithm, provider);
                }
            }
            else
            {
                throw e;
            }
        }

        setSignatureParameters(sig, sigAlgId.getParameters());
        
        sig.initVerify(pubKey);

        try
        {
            sig.update(reqInfo.getEncoded(ASN1Encodable.DER));
        }
        catch (Exception e)
        {
            throw new SignatureException("exception encoding TBS cert request - " + e);
        }

        return sig.verify(sigBits.getBytes());
    }

    /**
     * return a DER encoded byte array representing this object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.261 -0500", hash_original_method = "FFCAA10D74329AA15B8FE83335744F82", hash_generated_method = "DCCE93F4D0141431F9D725745B73FBC0")
    
public byte[] getEncoded()
    {
        try
        {
            return this.getEncoded(ASN1Encodable.DER);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.265 -0500", hash_original_method = "572BCE240DBAD7E2FCA6B5178E7F9E48", hash_generated_method = "BAD94E6087F1945FE1FF43E265DD50AD")
    
private void setSignatureParameters(
        Signature signature,
        DEREncodable params)
        throws NoSuchAlgorithmException, SignatureException, InvalidKeyException
    {
        if (params != null && !DERNull.INSTANCE.equals(params))
        {
            AlgorithmParameters sigParams = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());

            try
            {
                sigParams.init(params.getDERObject().getDEREncoded());
            }
            catch (IOException e)
            {
                throw new SignatureException("IOException decoding parameters: " + e.getMessage());
            }

            if (signature.getAlgorithm().endsWith("MGF1"))
            {
                try
                {
                    signature.setParameter(sigParams.getParameterSpec(PSSParameterSpec.class));
                }
                catch (GeneralSecurityException e)
                {
                    throw new SignatureException("Exception extracting parameters: " + e.getMessage());
                }
            }
        }
    }
    static {
        algorithms.put("MD5WITHRSAENCRYPTION", new DERObjectIdentifier("1.2.840.113549.1.1.4"));
        algorithms.put("MD5WITHRSA", new DERObjectIdentifier("1.2.840.113549.1.1.4"));
        algorithms.put("RSAWITHMD5", new DERObjectIdentifier("1.2.840.113549.1.1.4"));
        algorithms.put("SHA1WITHRSAENCRYPTION", new DERObjectIdentifier("1.2.840.113549.1.1.5"));
        algorithms.put("SHA1WITHRSA", new DERObjectIdentifier("1.2.840.113549.1.1.5"));
        algorithms.put("SHA256WITHRSAENCRYPTION", PKCSObjectIdentifiers.sha256WithRSAEncryption);
        algorithms.put("SHA256WITHRSA", PKCSObjectIdentifiers.sha256WithRSAEncryption);
        algorithms.put("SHA384WITHRSAENCRYPTION", PKCSObjectIdentifiers.sha384WithRSAEncryption);
        algorithms.put("SHA384WITHRSA", PKCSObjectIdentifiers.sha384WithRSAEncryption);
        algorithms.put("SHA512WITHRSAENCRYPTION", PKCSObjectIdentifiers.sha512WithRSAEncryption);
        algorithms.put("SHA512WITHRSA", PKCSObjectIdentifiers.sha512WithRSAEncryption);
        algorithms.put("SHA1WITHRSAANDMGF1", PKCSObjectIdentifiers.id_RSASSA_PSS);
        algorithms.put("SHA256WITHRSAANDMGF1", PKCSObjectIdentifiers.id_RSASSA_PSS);
        algorithms.put("SHA384WITHRSAANDMGF1", PKCSObjectIdentifiers.id_RSASSA_PSS);
        algorithms.put("SHA512WITHRSAANDMGF1", PKCSObjectIdentifiers.id_RSASSA_PSS);
        algorithms.put("RSAWITHSHA1", new DERObjectIdentifier("1.2.840.113549.1.1.5"));
        algorithms.put("SHA1WITHDSA", new DERObjectIdentifier("1.2.840.10040.4.3"));
        algorithms.put("DSAWITHSHA1", new DERObjectIdentifier("1.2.840.10040.4.3"));
        algorithms.put("SHA256WITHDSA", NISTObjectIdentifiers.dsa_with_sha256);
        algorithms.put("SHA384WITHDSA", NISTObjectIdentifiers.dsa_with_sha384);
        algorithms.put("SHA512WITHDSA", NISTObjectIdentifiers.dsa_with_sha512);
        algorithms.put("SHA1WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA1);
        algorithms.put("SHA256WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA256);
        algorithms.put("SHA384WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA384);
        algorithms.put("SHA512WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA512);
        algorithms.put("ECDSAWITHSHA1", X9ObjectIdentifiers.ecdsa_with_SHA1);
        oids.put(new DERObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        oids.put(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WITHRSA");
        oids.put(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WITHRSA");
        oids.put(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WITHRSA");
        oids.put(new DERObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        oids.put(new DERObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
        oids.put(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1WITHECDSA");
        oids.put(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256WITHECDSA");
        oids.put(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384WITHECDSA");
        oids.put(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512WITHECDSA");
        oids.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        oids.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1WITHDSA");
        oids.put(NISTObjectIdentifiers.dsa_with_sha256, "SHA256WITHDSA");
        keyAlgorithms.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        keyAlgorithms.put(X9ObjectIdentifiers.id_dsa, "DSA");
        noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA1);
        noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA256);
        noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA384);
        noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA512);
        noParams.add(X9ObjectIdentifiers.id_dsa_with_sha1);
        noParams.add(NISTObjectIdentifiers.dsa_with_sha256);
        AlgorithmIdentifier sha1AlgId = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
        params.put("SHA1WITHRSAANDMGF1", creatPSSParams(sha1AlgId, 20));
        AlgorithmIdentifier sha256AlgId = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, DERNull.INSTANCE);
        params.put("SHA256WITHRSAANDMGF1", creatPSSParams(sha256AlgId, 32));
        AlgorithmIdentifier sha384AlgId = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, DERNull.INSTANCE);
        params.put("SHA384WITHRSAANDMGF1", creatPSSParams(sha384AlgId, 48));
        AlgorithmIdentifier sha512AlgId = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, DERNull.INSTANCE);
        params.put("SHA512WITHRSAANDMGF1", creatPSSParams(sha512AlgId, 64));
    }
    
}

