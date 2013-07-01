package org.bouncycastle.jce;

// Droidsafe Imports
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

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// needed for enhanced for control translations

public class PKCS10CertificationRequest extends CertificationRequest {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.180 -0400", hash_original_method = "3A41672F51C7647865E5A6F21420932E", hash_generated_method = "FF24829872F3AA31786B4DCB8CC254E0")
    public  PKCS10CertificationRequest(
        byte[]  bytes) {
        super(toDERSequence(bytes));
        addTaint(bytes[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.180 -0400", hash_original_method = "E80E9113023CB84AD6D915B7A5F597A7", hash_generated_method = "4ABCE1760383597C1301750287ADF3F7")
    public  PKCS10CertificationRequest(
        ASN1Sequence  sequence) {
        super(sequence);
        addTaint(sequence.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.180 -0400", hash_original_method = "DCC234DC4AA32AD53B9F45C5CD92E5AA", hash_generated_method = "AE53A31855CD9BBA949A92B259CCC902")
    public  PKCS10CertificationRequest(
        String              signatureAlgorithm,
        X509Name            subject,
        PublicKey           key,
        ASN1Set             attributes,
        PrivateKey          signingKey) throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException {
        this(signatureAlgorithm, subject, key, attributes, signingKey, BouncyCastleProvider.PROVIDER_NAME);
        addTaint(signatureAlgorithm.getTaint());
        addTaint(subject.getTaint());
        addTaint(key.getTaint());
        addTaint(attributes.getTaint());
        addTaint(signingKey.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.180 -0400", hash_original_method = "8331D41600BE6136ABFAAFB9EC7881F5", hash_generated_method = "1D5500E13704FB13C5892001043D5470")
    public  PKCS10CertificationRequest(
        String              signatureAlgorithm,
        X500Principal       subject,
        PublicKey           key,
        ASN1Set             attributes,
        PrivateKey          signingKey) throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException {
        this(signatureAlgorithm, convertName(subject), key, attributes, signingKey, BouncyCastleProvider.PROVIDER_NAME);
        addTaint(signatureAlgorithm.getTaint());
        addTaint(subject.getTaint());
        addTaint(key.getTaint());
        addTaint(attributes.getTaint());
        addTaint(signingKey.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.181 -0400", hash_original_method = "47F27C3C5B072C1921CEA8CD2618865D", hash_generated_method = "271E18C2D0AE6A0C5459868637A91871")
    public  PKCS10CertificationRequest(
        String              signatureAlgorithm,
        X500Principal       subject,
        PublicKey           key,
        ASN1Set             attributes,
        PrivateKey          signingKey,
        String              provider) throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException {
        this(signatureAlgorithm, convertName(subject), key, attributes, signingKey, provider);
        addTaint(signatureAlgorithm.getTaint());
        addTaint(subject.getTaint());
        addTaint(key.getTaint());
        addTaint(attributes.getTaint());
        addTaint(signingKey.getTaint());
        addTaint(provider.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.182 -0400", hash_original_method = "9B8C4723941705C4AF87CD12244595BD", hash_generated_method = "69AFFF1101EF0D86DDC5D9A48B5C9D7A")
    public  PKCS10CertificationRequest(
        String              signatureAlgorithm,
        X509Name            subject,
        PublicKey           key,
        ASN1Set             attributes,
        PrivateKey          signingKey,
        String              provider) throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException {
        String algorithmName = Strings.toUpperCase(signatureAlgorithm);
        DERObjectIdentifier sigOID = (DERObjectIdentifier)algorithms.get(algorithmName);
        {
            try 
            {
                sigOID = new DERObjectIdentifier(algorithmName);
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown signature type requested");
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("subject must not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("public key must not be null");
        } //End block
        {
            boolean varA28C1CB3B01DBB9A9C719BFC6B8E784C_636167118 = (noParams.contains(sigOID));
            {
                this.sigAlgId = new AlgorithmIdentifier(sigOID);
            } //End block
            {
                boolean var8B78123363DC47A262C8A044FF82B2D9_1745115382 = (params.containsKey(algorithmName));
                {
                    this.sigAlgId = new AlgorithmIdentifier(sigOID, (DEREncodable)params.get(algorithmName));
                } //End block
                {
                    this.sigAlgId = new AlgorithmIdentifier(sigOID, DERNull.INSTANCE);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        try 
        {
            ASN1Sequence seq = (ASN1Sequence)ASN1Object.fromByteArray(key.getEncoded());
            this.reqInfo = new CertificationRequestInfo(subject, new SubjectPublicKeyInfo(seq), attributes);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("can't encode public key");
        } //End block
        Signature sig;
        {
            sig = Signature.getInstance(signatureAlgorithm);
        } //End block
        {
            sig = Signature.getInstance(signatureAlgorithm, provider);
        } //End block
        sig.initSign(signingKey);
        try 
        {
            sig.update(reqInfo.getEncoded(ASN1Encodable.DER));
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("exception encoding TBS cert request - " + e);
        } //End block
        this.sigBits = new DERBitString(sig.sign());
        addTaint(signatureAlgorithm.getTaint());
        addTaint(subject.getTaint());
        addTaint(key.getTaint());
        addTaint(attributes.getTaint());
        addTaint(signingKey.getTaint());
        addTaint(provider.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static RSASSAPSSparams creatPSSParams(AlgorithmIdentifier hashAlgId, int saltSize) {
        return new RSASSAPSSparams(
            hashAlgId,
            new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, hashAlgId),
            new DERInteger(saltSize),
            new DERInteger(1));
    }

    
    private static ASN1Sequence toDERSequence(
        byte[]  bytes) {
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

    
    private static X509Name convertName(
        X500Principal    name) {
        try
        {
            return new X509Principal(name.getEncoded());
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("can't convert name");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.183 -0400", hash_original_method = "43324B511CA49EBF5AC84C5892E16660", hash_generated_method = "7FCC971105324C540EBEF026422056A5")
    public PublicKey getPublicKey() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_132513249 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_132513249 = getPublicKey(BouncyCastleProvider.PROVIDER_NAME);
        varB4EAC82CA7396A68D541C85D26508E83_132513249.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_132513249;
        // ---------- Original Method ----------
        //return getPublicKey(BouncyCastleProvider.PROVIDER_NAME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.185 -0400", hash_original_method = "B8875DFEFA5CEF760F6C887EECDEC741", hash_generated_method = "811310D8AB68DAD21469AF8E225CC627")
    public PublicKey getPublicKey(
        String  provider) throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException {
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_760774053 = null; //Variable for return #1
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_401729524 = null; //Variable for return #2
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_1815009069 = null; //Variable for return #3
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_1252848750 = null; //Variable for return #4
        SubjectPublicKeyInfo subjectPKInfo = reqInfo.getSubjectPublicKeyInfo();
        X509EncodedKeySpec xspec = new X509EncodedKeySpec(new DERBitString(subjectPKInfo).getBytes());
        AlgorithmIdentifier keyAlg = subjectPKInfo.getAlgorithmId();
        try 
        {
            try 
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_760774053 = KeyFactory.getInstance(keyAlg.getObjectId().getId()).generatePublic(xspec);
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_401729524 = KeyFactory.getInstance(keyAlg.getObjectId().getId(), provider).generatePublic(xspec);
                } //End block
            } //End block
            catch (NoSuchAlgorithmException e)
            {
                {
                    boolean varF13192E73622F69196A2A5B84CA0A3EF_705993668 = (keyAlgorithms.get(keyAlg.getObjectId()) != null);
                    {
                        String keyAlgorithm = (String)keyAlgorithms.get(keyAlg.getObjectId());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1815009069 = KeyFactory.getInstance(keyAlgorithm).generatePublic(xspec);
                        } //End block
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1252848750 = KeyFactory.getInstance(keyAlgorithm, provider).generatePublic(xspec);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
        } //End block
        catch (InvalidKeySpecException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException("error decoding public key");
        } //End block
        addTaint(provider.getTaint());
        PublicKey varA7E53CE21691AB073D9660D615818899_62321368; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_62321368 = varB4EAC82CA7396A68D541C85D26508E83_760774053;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_62321368 = varB4EAC82CA7396A68D541C85D26508E83_401729524;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_62321368 = varB4EAC82CA7396A68D541C85D26508E83_1815009069;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_62321368 = varB4EAC82CA7396A68D541C85D26508E83_1252848750;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_62321368.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_62321368;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.185 -0400", hash_original_method = "76B4A35CDD087589FE1D86D8EB63F14C", hash_generated_method = "4352E378AC18B6631F6D11A01E3DF064")
    public boolean verify() throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException {
        boolean varBBC1526DC53D6870A81DAC4F4EB06FE8_223325220 = (verify(BouncyCastleProvider.PROVIDER_NAME));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_336778649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_336778649;
        // ---------- Original Method ----------
        //return verify(BouncyCastleProvider.PROVIDER_NAME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.186 -0400", hash_original_method = "EEEA1D6F83C84A4A1EBDD2FD7850BFFE", hash_generated_method = "61C176A0EABCFF0EA0A66E9D2A268A64")
    public boolean verify(
        String provider) throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException {
        boolean varC3F2617EA9FD66C2C9E37A8F926AFFB2_111958133 = (verify(this.getPublicKey(provider), provider));
        addTaint(provider.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_292764231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_292764231;
        // ---------- Original Method ----------
        //return verify(this.getPublicKey(provider), provider);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.186 -0400", hash_original_method = "23EDAE0C7E13C4B3F88052C2DB8B64F6", hash_generated_method = "1305AE8152E4FAE47EB15D58C8B16655")
    public boolean verify(
        PublicKey pubKey,
        String provider) throws NoSuchAlgorithmException, NoSuchProviderException,
                InvalidKeyException, SignatureException {
        Signature sig;
        try 
        {
            {
                sig = Signature.getInstance(getSignatureName(sigAlgId));
            } //End block
            {
                sig = Signature.getInstance(getSignatureName(sigAlgId), provider);
            } //End block
        } //End block
        catch (NoSuchAlgorithmException e)
        {
            {
                boolean var2FBBF84408608E08007E6EAD7710062C_1577594071 = (oids.get(sigAlgId.getObjectId()) != null);
                {
                    String signatureAlgorithm = (String)oids.get(sigAlgId.getObjectId());
                    {
                        sig = Signature.getInstance(signatureAlgorithm);
                    } //End block
                    {
                        sig = Signature.getInstance(signatureAlgorithm, provider);
                    } //End block
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
            } //End collapsed parenthetic
        } //End block
        setSignatureParameters(sig, sigAlgId.getParameters());
        sig.initVerify(pubKey);
        try 
        {
            sig.update(reqInfo.getEncoded(ASN1Encodable.DER));
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("exception encoding TBS cert request - " + e);
        } //End block
        boolean varBE1162AA5A476A71DD01CEAC62181655_297071227 = (sig.verify(sigBits.getBytes()));
        addTaint(pubKey.getTaint());
        addTaint(provider.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108636905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108636905;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.187 -0400", hash_original_method = "FFCAA10D74329AA15B8FE83335744F82", hash_generated_method = "FED4CAC1BEB07BFAF736E3AFF8EBF1B7")
    public byte[] getEncoded() {
        try 
        {
            byte[] var29AE989CF6B7F50AE5155A143357E72F_1885555404 = (this.getEncoded(ASN1Encodable.DER));
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e.toString());
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1321716258 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1321716258;
        // ---------- Original Method ----------
        //try
        //{
            //return this.getEncoded(ASN1Encodable.DER);
        //}
        //catch (IOException e)
        //{
            //throw new RuntimeException(e.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.187 -0400", hash_original_method = "572BCE240DBAD7E2FCA6B5178E7F9E48", hash_generated_method = "E2D9FF3C7D0CBC32965E41DADC411716")
    private void setSignatureParameters(
        Signature signature,
        DEREncodable params) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        {
            boolean varE8057AF7C7F228EF7CA126281F5DED17_850994078 = (params != null && !DERNull.INSTANCE.equals(params));
            {
                AlgorithmParameters sigParams = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
                try 
                {
                    sigParams.init(params.getDERObject().getDEREncoded());
                } //End block
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new SignatureException("IOException decoding parameters: " + e.getMessage());
                } //End block
                {
                    boolean var5EE6B1BAB6A4EE2F23E1C61F3C4D4977_179236431 = (signature.getAlgorithm().endsWith("MGF1"));
                    {
                        try 
                        {
                            signature.setParameter(sigParams.getParameterSpec(PSSParameterSpec.class));
                        } //End block
                        catch (GeneralSecurityException e)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Exception extracting parameters: " + e.getMessage());
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(signature.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static String getSignatureName(
        AlgorithmIdentifier sigAlgId) {
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

    
    private static String getDigestAlgName(
        DERObjectIdentifier digestAlgOID) {
        if (PKCSObjectIdentifiers.md5.equals(digestAlgOID))
        {
            return "MD5";
        }
        else if (OIWObjectIdentifiers.idSHA1.equals(digestAlgOID))
        {
            return "SHA1";
        }
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
        else
        {
            return digestAlgOID.getId();            
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.188 -0400", hash_original_field = "B39C3BE7546FA73A752B6C68B346E2B1", hash_generated_field = "2A7E0957EAD856B3315504481686A7DE")

    private static Hashtable algorithms = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.188 -0400", hash_original_field = "0D433ED6AA05239AA7FFA603AE52EAF9", hash_generated_field = "3580C2237188FBF88703AFC814D06B98")

    private static Hashtable params = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.188 -0400", hash_original_field = "A13D3CE5CEDBFFEA1E23C07F3E99C13F", hash_generated_field = "C8FBF8B644E3B7297D2EC131F85F7B39")

    private static Hashtable keyAlgorithms = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.188 -0400", hash_original_field = "E4322C1573762E02D6AC3A68C442E016", hash_generated_field = "6D958D15EBDB3005FA7CB66D7A014B22")

    private static Hashtable oids = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.188 -0400", hash_original_field = "9599D5E70EEA113DAC00F7EA2B8AD147", hash_generated_field = "E222E546E7C245483C60E7B45F19B3A8")

    private static Set noParams = new HashSet();
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

