package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.EncryptionScheme;
import org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import org.bouncycastle.asn1.pkcs.PBEParameter;
import org.bouncycastle.asn1.pkcs.PBES2Parameters;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.sec.ECPrivateKeyStructure;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.RSAPublicKeyStructure;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.PKCS10CertificationRequest;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.io.pem.PemHeader;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectParser;
import org.bouncycastle.util.io.pem.PemReader;
import org.bouncycastle.x509.X509V2AttributeCertificate;

public class PEMReader extends PemReader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.062 -0400", hash_original_field = "DFAA5B65B87CDDE1589034B535B31A0A", hash_generated_field = "1B324848B9CCB600B6F9F412146CB5D6")

    private final Map parsers = new HashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.063 -0400", hash_original_field = "5CD9C2E7D64B912B29078A3E35C28F5E", hash_generated_field = "7A318D1FC589B8A927004A5BBE837049")

    private PasswordFinder pFinder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.063 -0400", hash_original_method = "2732903E834E35077990228D3EC5372C", hash_generated_method = "9D0E243820E7950FE695D0C348CB2B9F")
    public  PEMReader(
        Reader reader) {
        this(reader, null, "BC");
        addTaint(reader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.063 -0400", hash_original_method = "264D7373D1280C46B7B3C63F3DA0F057", hash_generated_method = "E82DDE8B8FBC0FA2C8B53EE60861C8EA")
    public  PEMReader(
        Reader reader,
        PasswordFinder pFinder) {
        this(reader, pFinder, "BC");
        addTaint(reader.getTaint());
        addTaint(pFinder.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.063 -0400", hash_original_method = "F26FB5757482F756B15ADBECFFA22920", hash_generated_method = "6914A8068DB5A94A184F1A9B36CC1C6E")
    public  PEMReader(
        Reader reader,
        PasswordFinder pFinder,
        String provider) {
        this(reader, pFinder, provider, provider);
        addTaint(reader.getTaint());
        addTaint(pFinder.getTaint());
        addTaint(provider.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.064 -0400", hash_original_method = "CEFEBB919AD354EB1A0A7FBF2E2E3ECF", hash_generated_method = "7F9A324318B2C333A98601393A049374")
    public  PEMReader(
        Reader reader,
        PasswordFinder pFinder,
        String symProvider,
        String asymProvider) {
        super(reader);
        this.pFinder = pFinder;
        parsers.put("CERTIFICATE REQUEST", new PKCS10CertificationRequestParser());
        parsers.put("NEW CERTIFICATE REQUEST", new PKCS10CertificationRequestParser());
        parsers.put("CERTIFICATE", new X509CertificateParser(asymProvider));
        parsers.put("X509 CERTIFICATE", new X509CertificateParser(asymProvider));
        parsers.put("X509 CRL", new X509CRLParser(asymProvider));
        parsers.put("PKCS7", new PKCS7Parser());
        parsers.put("ATTRIBUTE CERTIFICATE", new X509AttributeCertificateParser());
        parsers.put("EC PARAMETERS", new ECNamedCurveSpecParser());
        parsers.put("PUBLIC KEY", new PublicKeyParser(asymProvider));
        parsers.put("RSA PUBLIC KEY", new RSAPublicKeyParser(asymProvider));
        parsers.put("RSA PRIVATE KEY", new RSAKeyPairParser(asymProvider));
        parsers.put("DSA PRIVATE KEY", new DSAKeyPairParser(asymProvider));
        parsers.put("EC PRIVATE KEY", new ECDSAKeyPairParser(asymProvider));
        parsers.put("ENCRYPTED PRIVATE KEY", new EncryptedPrivateKeyParser(symProvider, asymProvider));
        parsers.put("PRIVATE KEY", new PrivateKeyParser(asymProvider));
        addTaint(reader.getTaint());
        addTaint(symProvider.getTaint());
        addTaint(asymProvider.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.064 -0400", hash_original_method = "127E22226D67F5F9289AA2863D2E5AFD", hash_generated_method = "ADB3C7827D57DF8EF7CE30572995E533")
    public Object readObject() throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_6521527 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_88404812 = null; //Variable for return #2
        PemObject obj = readPemObject();
        {
            String type = obj.getType();
            {
                boolean var87E27464E41E941C9C7240C5968580EF_72038818 = (parsers.containsKey(type));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_6521527 = ((PemObjectParser)parsers.get(type)).parseObject(obj);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("unrecognised object: " + type);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_88404812 = null;
        Object varA7E53CE21691AB073D9660D615818899_1829026007; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1829026007 = varB4EAC82CA7396A68D541C85D26508E83_6521527;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1829026007 = varB4EAC82CA7396A68D541C85D26508E83_88404812;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1829026007.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1829026007;
        // ---------- Original Method ----------
        //PemObject obj = readPemObject();
        //if (obj != null)
        //{
            //String type = obj.getType();
            //if (parsers.containsKey(type))
            //{
                //return ((PemObjectParser)parsers.get(type)).parseObject(obj);
            //}
            //else
            //{
                //throw new IOException("unrecognised object: " + type);
            //}
        //}
        //return null;
    }

    
    private abstract class KeyPairParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.064 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "AFDE0FC943DF429CC56BE81349BC4014")

        protected String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.065 -0400", hash_original_method = "D97A7462FC5E95C470F1E84C9A4F9D7B", hash_generated_method = "AEB043DD3F85D4A6336E5753ECB334C0")
        public  KeyPairParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.066 -0400", hash_original_method = "D2B938CFC8BBB876E5EB510A00C9CCB3", hash_generated_method = "5A7FFE15CF91B3F29F4B941007201C4E")
        protected ASN1Sequence readKeyPair(
            PemObject obj) throws IOException {
            ASN1Sequence varB4EAC82CA7396A68D541C85D26508E83_1010301472 = null; //Variable for return #1
            boolean isEncrypted = false;
            String dekInfo = null;
            List headers = obj.getHeaders();
            {
                Iterator it = headers.iterator();
                boolean varB2FF4435B274CC4BE01D264DEA08F957_688050640 = (it.hasNext());
                {
                    PemHeader hdr = (PemHeader)it.next();
                    {
                        boolean var86ACFFF1836D840380FA787C9114D4A2_481331941 = (hdr.getName().equals("Proc-Type") && hdr.getValue().equals("4,ENCRYPTED"));
                        {
                            isEncrypted = true;
                        } //End block
                        {
                            boolean var59A09AB2DBA00C2F4171F36590630DA4_1671261989 = (hdr.getName().equals("DEK-Info"));
                            {
                                dekInfo = hdr.getValue();
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            byte[] keyBytes = obj.getContent();
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new PasswordException("No password finder specified, but a password is required");
                } //End block
                char[] password = pFinder.getPassword();
                {
                    if (DroidSafeAndroidRuntime.control) throw new PasswordException("Password is null, but a password is required");
                } //End block
                StringTokenizer tknz = new StringTokenizer(dekInfo, ",");
                String dekAlgName = tknz.nextToken();
                byte[] iv = Hex.decode(tknz.nextToken());
                keyBytes = PEMUtilities.crypt(false, provider, keyBytes, password, dekAlgName, iv);
            } //End block
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1010301472 = (ASN1Sequence)ASN1Object.fromByteArray(keyBytes);
            } //End block
            catch (IOException e)
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new PEMException("exception decoding - please check password and data.", e);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new PEMException(e.getMessage(), e);
                } //End block
            } //End block
            catch (ClassCastException e)
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new PEMException("exception decoding - please check password and data.", e);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new PEMException(e.getMessage(), e);
                } //End block
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1010301472.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1010301472;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.067 -0400", hash_original_method = "ADBD617F929757840A0FD32FA3C710F1", hash_generated_method = "98E9B2A9DBB6C5434EE239E1D433E12C")
        public  DSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.068 -0400", hash_original_method = "ADE2E96FAD316F0BCF76F4FEB2795A67", hash_generated_method = "033F1261826D7A19E5F735ED7EEF7652")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1272722341 = null; //Variable for return #1
            try 
            {
                ASN1Sequence seq = readKeyPair(obj);
                {
                    boolean var974D70D1387D69381D57EF0F9749B5DB_1943143927 = (seq.size() != 6);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new PEMException("malformed sequence in DSA private key");
                    } //End block
                } //End collapsed parenthetic
                DERInteger p = (DERInteger)seq.getObjectAt(1);
                DERInteger q = (DERInteger)seq.getObjectAt(2);
                DERInteger g = (DERInteger)seq.getObjectAt(3);
                DERInteger y = (DERInteger)seq.getObjectAt(4);
                DERInteger x = (DERInteger)seq.getObjectAt(5);
                DSAPrivateKeySpec privSpec = new DSAPrivateKeySpec(
                    x.getValue(), p.getValue(),
                    q.getValue(), g.getValue());
                DSAPublicKeySpec pubSpec = new DSAPublicKeySpec(
                    y.getValue(), p.getValue(),
                    q.getValue(), g.getValue());
                KeyFactory fact = KeyFactory.getInstance("DSA", provider);
                varB4EAC82CA7396A68D541C85D26508E83_1272722341 = new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
            } //End block
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException(
                    "problem creating DSA private key: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1272722341.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1272722341;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class ECDSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.069 -0400", hash_original_method = "3D5918BC33C2E8750A0F79CF102B6DFC", hash_generated_method = "9454600B5FFF7DD0CC1E82DDDFCBAB29")
        public  ECDSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.070 -0400", hash_original_method = "C19C67ADBE6E6117AD29F18C950B281B", hash_generated_method = "92312CB2CD13C3C3DDE737C37D9D492F")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_790830667 = null; //Variable for return #1
            try 
            {
                ASN1Sequence seq = readKeyPair(obj);
                ECPrivateKeyStructure pKey = new ECPrivateKeyStructure(seq);
                AlgorithmIdentifier algId = new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, pKey.getParameters());
                PrivateKeyInfo privInfo = new PrivateKeyInfo(algId, pKey.getDERObject());
                SubjectPublicKeyInfo pubInfo = new SubjectPublicKeyInfo(algId, pKey.getPublicKey().getBytes());
                PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(privInfo.getEncoded());
                X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubInfo.getEncoded());
                KeyFactory fact = KeyFactory.getInstance("ECDSA", provider);
                varB4EAC82CA7396A68D541C85D26508E83_790830667 = new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
            } //End block
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException(
                    "problem creating EC private key: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_790830667.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_790830667;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class RSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.070 -0400", hash_original_method = "77B6A791758EAFC47A0B2DE5F4E18FED", hash_generated_method = "DDA6623EB3D7AC273FEBB7D9CBACF755")
        public  RSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.072 -0400", hash_original_method = "C48B53F279450A4E2A5829BDF7A98326", hash_generated_method = "324FDD69CD4FB17E710F373D239CC3F3")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1617156873 = null; //Variable for return #1
            try 
            {
                ASN1Sequence seq = readKeyPair(obj);
                {
                    boolean varBFAA44BD93226625B654775E46AB9BF6_1125984366 = (seq.size() != 9);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new PEMException("malformed sequence in RSA private key");
                    } //End block
                } //End collapsed parenthetic
                DERInteger mod = (DERInteger)seq.getObjectAt(1);
                DERInteger pubExp = (DERInteger)seq.getObjectAt(2);
                DERInteger privExp = (DERInteger)seq.getObjectAt(3);
                DERInteger p1 = (DERInteger)seq.getObjectAt(4);
                DERInteger p2 = (DERInteger)seq.getObjectAt(5);
                DERInteger exp1 = (DERInteger)seq.getObjectAt(6);
                DERInteger exp2 = (DERInteger)seq.getObjectAt(7);
                DERInteger crtCoef = (DERInteger)seq.getObjectAt(8);
                RSAPublicKeySpec pubSpec = new RSAPublicKeySpec(
                    mod.getValue(), pubExp.getValue());
                RSAPrivateCrtKeySpec privSpec = new RSAPrivateCrtKeySpec(
                    mod.getValue(), pubExp.getValue(), privExp.getValue(),
                    p1.getValue(), p2.getValue(),
                    exp1.getValue(), exp2.getValue(),
                    crtCoef.getValue());
                KeyFactory fact = KeyFactory.getInstance("RSA", provider);
                varB4EAC82CA7396A68D541C85D26508E83_1617156873 = new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
            } //End block
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException(
                    "problem creating RSA private key: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1617156873.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1617156873;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class PublicKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.072 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.072 -0400", hash_original_method = "0B170982AEB3AA2304D2A6B36AB698F1", hash_generated_method = "6FEA18513C00881A82B8B19C6587D7C1")
        public  PublicKeyParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.073 -0400", hash_original_method = "5FFFDE03CF0C93B31D80B463283D2455", hash_generated_method = "771D7E3846D073732A5CBFF4A1F5B238")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1242852414 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_1339038099 = null; //Variable for return #2
            KeySpec keySpec = new X509EncodedKeySpec(obj.getContent());
            String[] algorithms = {"DSA", "RSA"};
            {
                int i = 0;
                {
                    try 
                    {
                        KeyFactory keyFact = KeyFactory.getInstance(algorithms[i], provider);
                        PublicKey pubKey = keyFact.generatePublic(keySpec);
                        varB4EAC82CA7396A68D541C85D26508E83_1242852414 = pubKey;
                    } //End block
                    catch (NoSuchAlgorithmException e)
                    { }
                    catch (InvalidKeySpecException e)
                    { }
                    catch (NoSuchProviderException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("can't find provider " + provider);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1339038099 = null;
            addTaint(obj.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_658478729; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_658478729 = varB4EAC82CA7396A68D541C85D26508E83_1242852414;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_658478729 = varB4EAC82CA7396A68D541C85D26508E83_1339038099;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_658478729.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_658478729;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class RSAPublicKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.073 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.074 -0400", hash_original_method = "43B57D7EBB5BEFFE4B105714BFD44A53", hash_generated_method = "84CF85625A64D3F5A7330BBE15B0C603")
        public  RSAPublicKeyParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.076 -0400", hash_original_method = "2B7340E6F342A11B50254F4EBFCAD61E", hash_generated_method = "0B4D4CE1F747980CF0E7215B483BCA59")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1681019899 = null; //Variable for return #1
            try 
            {
                ASN1InputStream ais = new ASN1InputStream(obj.getContent());
                Object asnObject = ais.readObject();
                ASN1Sequence sequence = (ASN1Sequence)asnObject;
                RSAPublicKeyStructure rsaPubStructure = new RSAPublicKeyStructure(sequence);
                RSAPublicKeySpec keySpec = new RSAPublicKeySpec(
                    rsaPubStructure.getModulus(),
                    rsaPubStructure.getPublicExponent());
                KeyFactory keyFact = KeyFactory.getInstance("RSA", provider);
                varB4EAC82CA7396A68D541C85D26508E83_1681019899 = keyFact.generatePublic(keySpec);
            } //End block
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
            catch (NoSuchProviderException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("can't find provider " + provider);
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem extracting key: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1681019899.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1681019899;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class X509CertificateParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.076 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.077 -0400", hash_original_method = "A94C5E4D766266E16A102DAB21BC091D", hash_generated_method = "568E9262F1819DF68669D1C2DA0166D3")
        public  X509CertificateParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.081 -0400", hash_original_method = "E970ED81058B7D7B34834ED92B99A71B", hash_generated_method = "46C338540CCE37179F6D4911748883DB")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_216499039 = null; //Variable for return #1
            ByteArrayInputStream bIn = new ByteArrayInputStream(obj.getContent());
            try 
            {
                CertificateFactory certFact = CertificateFactory.getInstance("X.509", provider);
                varB4EAC82CA7396A68D541C85D26508E83_216499039 = certFact.generateCertificate(bIn);
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem parsing cert: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_216499039.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_216499039;
            // ---------- Original Method ----------
            //ByteArrayInputStream bIn = new ByteArrayInputStream(obj.getContent());
            //try
            //{
                //CertificateFactory certFact
                    //= CertificateFactory.getInstance("X.509", provider);
                //return certFact.generateCertificate(bIn);
            //}
            //catch (Exception e)
            //{
                //throw new PEMException("problem parsing cert: " + e.toString(), e);
            //}
        }

        
    }


    
    private class X509CRLParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.081 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.082 -0400", hash_original_method = "E353A700BDAAD44A8DB485E4FB446A3F", hash_generated_method = "0CF046E0608AEC29C4EF1AD8599D11E1")
        public  X509CRLParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.084 -0400", hash_original_method = "FC6031BD5FB1B476FDF70740E2B2704D", hash_generated_method = "EA5B7B6FB76D63E08A7FB1B847EE170E")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1283299918 = null; //Variable for return #1
            ByteArrayInputStream bIn = new ByteArrayInputStream(obj.getContent());
            try 
            {
                CertificateFactory certFact = CertificateFactory.getInstance("X.509", provider);
                varB4EAC82CA7396A68D541C85D26508E83_1283299918 = certFact.generateCRL(bIn);
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem parsing cert: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1283299918.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1283299918;
            // ---------- Original Method ----------
            //ByteArrayInputStream bIn = new ByteArrayInputStream(obj.getContent());
            //try
            //{
                //CertificateFactory certFact
                    //= CertificateFactory.getInstance("X.509", provider);
                //return certFact.generateCRL(bIn);
            //}
            //catch (Exception e)
            //{
                //throw new PEMException("problem parsing cert: " + e.toString(), e);
            //}
        }

        
    }


    
    private class PKCS10CertificationRequestParser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.084 -0400", hash_original_method = "33AF8B880E8127EFE5F17F2D4C65D4F3", hash_generated_method = "33AF8B880E8127EFE5F17F2D4C65D4F3")
        public PKCS10CertificationRequestParser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.085 -0400", hash_original_method = "CDCCA4D777F3AF625C0928D23D03AC75", hash_generated_method = "00991BF74BD42A47F94B614C91C7D34F")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_175373785 = null; //Variable for return #1
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_175373785 = new PKCS10CertificationRequest(obj.getContent());
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem parsing certrequest: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_175373785.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_175373785;
            // ---------- Original Method ----------
            //try
            //{
                //return new PKCS10CertificationRequest(obj.getContent());
            //}
            //catch (Exception e)
            //{
                //throw new PEMException("problem parsing certrequest: " + e.toString(), e);
            //}
        }

        
    }


    
    private class PKCS7Parser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.085 -0400", hash_original_method = "7BCD24730CEC01AC7ECF6E6CD774D6E0", hash_generated_method = "7BCD24730CEC01AC7ECF6E6CD774D6E0")
        public PKCS7Parser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.086 -0400", hash_original_method = "349205E9CFEFFD40FE2D93E7DAF8E867", hash_generated_method = "63BEF2ECFF2DE41205BC71EACAE2B262")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1363689559 = null; //Variable for return #1
            try 
            {
                ASN1InputStream aIn = new ASN1InputStream(obj.getContent());
                varB4EAC82CA7396A68D541C85D26508E83_1363689559 = ContentInfo.getInstance(aIn.readObject());
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem parsing PKCS7 object: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1363689559.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1363689559;
            // ---------- Original Method ----------
            //try
            //{
                //ASN1InputStream aIn = new ASN1InputStream(obj.getContent());
                //return ContentInfo.getInstance(aIn.readObject());
            //}
            //catch (Exception e)
            //{
                //throw new PEMException("problem parsing PKCS7 object: " + e.toString(), e);
            //}
        }

        
    }


    
    private class X509AttributeCertificateParser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.086 -0400", hash_original_method = "45D9D0D62A34F27B8FC81044406762B2", hash_generated_method = "45D9D0D62A34F27B8FC81044406762B2")
        public X509AttributeCertificateParser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.087 -0400", hash_original_method = "C751E950E815D18D55C97B4D94E88025", hash_generated_method = "4DE47E3D0408C80C84704B1E0474596B")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1571140891 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1571140891 = new X509V2AttributeCertificate(obj.getContent());
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1571140891.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1571140891;
            // ---------- Original Method ----------
            //return new X509V2AttributeCertificate(obj.getContent());
        }

        
    }


    
    private class ECNamedCurveSpecParser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.087 -0400", hash_original_method = "6EE69FC59FA5D4825234247899DC0928", hash_generated_method = "6EE69FC59FA5D4825234247899DC0928")
        public ECNamedCurveSpecParser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.088 -0400", hash_original_method = "76529322BBA013222CE8C144A2985A3B", hash_generated_method = "7AFC11BB8E48E5A9A9E690C85BB58053")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_183836843 = null; //Variable for return #1
            try 
            {
                DERObjectIdentifier oid = (DERObjectIdentifier)ASN1Object.fromByteArray(obj.getContent());
                Object params = ECNamedCurveTable.getParameterSpec(oid.getId());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("object ID not found in EC curve table");
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_183836843 = params;
            } //End block
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("exception extracting EC named curve: " + e.toString());
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_183836843.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_183836843;
            // ---------- Original Method ----------
            //try
            //{
                //DERObjectIdentifier oid = (DERObjectIdentifier)ASN1Object.fromByteArray(obj.getContent());
                //Object params = ECNamedCurveTable.getParameterSpec(oid.getId());
                //if (params == null)
                //{
                    //throw new IOException("object ID not found in EC curve table");
                //}
                //return params;
            //}
            //catch (IOException e)
            //{
                //throw e;
            //}
            //catch (Exception e)
            //{
                //throw new PEMException("exception extracting EC named curve: " + e.toString());
            //}
        }

        
    }


    
    private class EncryptedPrivateKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.088 -0400", hash_original_field = "4EACA8834A05AB66E18F6DFB559CED3E", hash_generated_field = "7250E15B2C636F0751D5B7C0DD47B256")

        private String symProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.088 -0400", hash_original_field = "CCA8F5193CBB2A08D508AA8F4F55F412", hash_generated_field = "0F549A2B688E81487E68FB3369A216E4")

        private String asymProvider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.089 -0400", hash_original_method = "E8D8629FC61D2C1E41CC63DCCA2261A4", hash_generated_method = "9E67816548B159C198D0387C48F7FAEF")
        public  EncryptedPrivateKeyParser(String symProvider, String asymProvider) {
            this.symProvider = symProvider;
            this.asymProvider = asymProvider;
            // ---------- Original Method ----------
            //this.symProvider = symProvider;
            //this.asymProvider = asymProvider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.092 -0400", hash_original_method = "B158B358DBE9E580DC539CC61ABD0BEA", hash_generated_method = "F353ED48291607671D052B96EC3D7337")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1611160630 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_374882436 = null; //Variable for return #2
            Object varB4EAC82CA7396A68D541C85D26508E83_1945503998 = null; //Variable for return #3
            try 
            {
                EncryptedPrivateKeyInfo info = EncryptedPrivateKeyInfo.getInstance(ASN1Object.fromByteArray(obj.getContent()));
                AlgorithmIdentifier algId = info.getEncryptionAlgorithm();
                {
                    if (DroidSafeAndroidRuntime.control) throw new PEMException("no PasswordFinder specified");
                } //End block
                {
                    boolean var47DB76E816F9ADD991AEA437B8D7991D_1350157117 = (PEMUtilities.isPKCS5Scheme2(algId.getAlgorithm()));
                    {
                        PBES2Parameters params = PBES2Parameters.getInstance(algId.getParameters());
                        KeyDerivationFunc func = params.getKeyDerivationFunc();
                        EncryptionScheme scheme = params.getEncryptionScheme();
                        PBKDF2Params defParams = (PBKDF2Params)func.getParameters();
                        int iterationCount = defParams.getIterationCount().intValue();
                        byte[] salt = defParams.getSalt();
                        String algorithm = scheme.getAlgorithm().getId();
                        SecretKey key = PEMUtilities.generateSecretKeyForPKCS5Scheme2(algorithm, pFinder.getPassword(), salt, iterationCount);
                        Cipher cipher = Cipher.getInstance(algorithm, symProvider);
                        AlgorithmParameters algParams = AlgorithmParameters.getInstance(algorithm, symProvider);
                        algParams.init(scheme.getParameters().getDERObject().getEncoded());
                        cipher.init(Cipher.DECRYPT_MODE, key, algParams);
                        PrivateKeyInfo pInfo = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(cipher.doFinal(info.getEncryptedData())));
                        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pInfo.getEncoded());
                        KeyFactory keyFact = KeyFactory.getInstance(pInfo.getAlgorithmId().getAlgorithm().getId(), asymProvider);
                        varB4EAC82CA7396A68D541C85D26508E83_1611160630 = keyFact.generatePrivate(keySpec);
                    } //End block
                    {
                        boolean var2B57198D6FD24854351D5A053B297FA7_1906223906 = (PEMUtilities.isPKCS12(algId.getAlgorithm()));
                        {
                            PKCS12PBEParams params = PKCS12PBEParams.getInstance(algId.getParameters());
                            String algorithm = algId.getAlgorithm().getId();
                            PBEKeySpec pbeSpec = new PBEKeySpec(pFinder.getPassword());
                            SecretKeyFactory secKeyFact = SecretKeyFactory.getInstance(algorithm, symProvider);
                            PBEParameterSpec defParams = new PBEParameterSpec(params.getIV(), params.getIterations().intValue());
                            Cipher cipher = Cipher.getInstance(algorithm, symProvider);
                            cipher.init(Cipher.DECRYPT_MODE, secKeyFact.generateSecret(pbeSpec), defParams);
                            PrivateKeyInfo pInfo = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(cipher.doFinal(info.getEncryptedData())));
                            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pInfo.getEncoded());
                            KeyFactory keyFact = KeyFactory.getInstance(pInfo.getAlgorithmId().getAlgorithm().getId(), asymProvider);
                            varB4EAC82CA7396A68D541C85D26508E83_374882436 = keyFact.generatePrivate(keySpec);
                        } //End block
                        {
                            boolean var3EC9697B1D1A3E0BA2C48E715FFC8440_1444289194 = (PEMUtilities.isPKCS5Scheme1(algId.getAlgorithm()));
                            {
                                PBEParameter params = PBEParameter.getInstance(algId.getParameters());
                                String algorithm = algId.getAlgorithm().getId();
                                PBEKeySpec pbeSpec = new PBEKeySpec(pFinder.getPassword());
                                SecretKeyFactory secKeyFact = SecretKeyFactory.getInstance(algorithm, symProvider);
                                PBEParameterSpec defParams = new PBEParameterSpec(params.getSalt(), params.getIterationCount().intValue());
                                Cipher cipher = Cipher.getInstance(algorithm, symProvider);
                                cipher.init(Cipher.DECRYPT_MODE, secKeyFact.generateSecret(pbeSpec), defParams);
                                PrivateKeyInfo pInfo = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(cipher.doFinal(info.getEncryptedData())));
                                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pInfo.getEncoded());
                                KeyFactory keyFact = KeyFactory.getInstance(pInfo.getAlgorithmId().getAlgorithm().getId(), asymProvider);
                                varB4EAC82CA7396A68D541C85D26508E83_1945503998 = keyFact.generatePrivate(keySpec);
                            } //End block
                            {
                                if (DroidSafeAndroidRuntime.control) throw new PEMException("Unknown algorithm: " + algId.getAlgorithm());
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem parsing ENCRYPTED PRIVATE KEY: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_45452704; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_45452704 = varB4EAC82CA7396A68D541C85D26508E83_1611160630;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_45452704 = varB4EAC82CA7396A68D541C85D26508E83_374882436;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_45452704 = varB4EAC82CA7396A68D541C85D26508E83_1945503998;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_45452704.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_45452704;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class PrivateKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.092 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.093 -0400", hash_original_method = "0877761703B26434F32E47C53A29AE74", hash_generated_method = "15BF9532DC3933BF57B695673E62B835")
        public  PrivateKeyParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.094 -0400", hash_original_method = "2553B1C8B63939D2139C3EAA36C566E7", hash_generated_method = "6987ED9912260452F2F5EAAE9C17CF3A")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_431486266 = null; //Variable for return #1
            try 
            {
                PrivateKeyInfo info = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(obj.getContent()));
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(obj.getContent());
                KeyFactory keyFact = KeyFactory.getInstance(info.getAlgorithmId().getAlgorithm().getId(), provider);
                varB4EAC82CA7396A68D541C85D26508E83_431486266 = keyFact.generatePrivate(keySpec);
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem parsing PRIVATE KEY: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_431486266.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_431486266;
            // ---------- Original Method ----------
            //try
            //{
                //PrivateKeyInfo info = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(obj.getContent()));
                //PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(obj.getContent());
                //KeyFactory keyFact = KeyFactory.getInstance(info.getAlgorithmId().getAlgorithm().getId(), provider);
                //return keyFact.generatePrivate(keySpec);
            //}
            //catch (Exception e)
            //{
                //throw new PEMException("problem parsing PRIVATE KEY: " + e.toString(), e);
            //}
        }

        
    }


    
}

