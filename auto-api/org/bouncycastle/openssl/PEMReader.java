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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.747 -0400", hash_original_field = "DFAA5B65B87CDDE1589034B535B31A0A", hash_generated_field = "88FEA4950F892522892C201B11DE6D28")

    private Map parsers = new HashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.747 -0400", hash_original_field = "5CD9C2E7D64B912B29078A3E35C28F5E", hash_generated_field = "7A318D1FC589B8A927004A5BBE837049")

    private PasswordFinder pFinder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.748 -0400", hash_original_method = "2732903E834E35077990228D3EC5372C", hash_generated_method = "9D0E243820E7950FE695D0C348CB2B9F")
    public  PEMReader(
        Reader reader) {
        this(reader, null, "BC");
        addTaint(reader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.748 -0400", hash_original_method = "264D7373D1280C46B7B3C63F3DA0F057", hash_generated_method = "E82DDE8B8FBC0FA2C8B53EE60861C8EA")
    public  PEMReader(
        Reader reader,
        PasswordFinder pFinder) {
        this(reader, pFinder, "BC");
        addTaint(reader.getTaint());
        addTaint(pFinder.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.748 -0400", hash_original_method = "F26FB5757482F756B15ADBECFFA22920", hash_generated_method = "6914A8068DB5A94A184F1A9B36CC1C6E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.765 -0400", hash_original_method = "CEFEBB919AD354EB1A0A7FBF2E2E3ECF", hash_generated_method = "7F9A324318B2C333A98601393A049374")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.766 -0400", hash_original_method = "127E22226D67F5F9289AA2863D2E5AFD", hash_generated_method = "5A3B84AECA41BB9DC4D21B285D5C5A50")
    public Object readObject() throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_490084602 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_851722610 = null; //Variable for return #2
        PemObject obj;
        obj = readPemObject();
        {
            String type;
            type = obj.getType();
            {
                boolean var87E27464E41E941C9C7240C5968580EF_2027501215 = (parsers.containsKey(type));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_490084602 = ((PemObjectParser)parsers.get(type)).parseObject(obj);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("unrecognised object: " + type);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_851722610 = null;
        Object varA7E53CE21691AB073D9660D615818899_1228347740; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1228347740 = varB4EAC82CA7396A68D541C85D26508E83_490084602;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1228347740 = varB4EAC82CA7396A68D541C85D26508E83_851722610;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1228347740.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1228347740;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.766 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "AFDE0FC943DF429CC56BE81349BC4014")

        protected String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.766 -0400", hash_original_method = "D97A7462FC5E95C470F1E84C9A4F9D7B", hash_generated_method = "AEB043DD3F85D4A6336E5753ECB334C0")
        public  KeyPairParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.785 -0400", hash_original_method = "D2B938CFC8BBB876E5EB510A00C9CCB3", hash_generated_method = "D3F4EE99BD361F0E0F06593112100F90")
        protected ASN1Sequence readKeyPair(
            PemObject obj) throws IOException {
            ASN1Sequence varB4EAC82CA7396A68D541C85D26508E83_395188507 = null; //Variable for return #1
            boolean isEncrypted;
            isEncrypted = false;
            String dekInfo;
            dekInfo = null;
            List headers;
            headers = obj.getHeaders();
            {
                Iterator it;
                it = headers.iterator();
                boolean varB2FF4435B274CC4BE01D264DEA08F957_902690974 = (it.hasNext());
                {
                    PemHeader hdr;
                    hdr = (PemHeader)it.next();
                    {
                        boolean var86ACFFF1836D840380FA787C9114D4A2_1863123028 = (hdr.getName().equals("Proc-Type") && hdr.getValue().equals("4,ENCRYPTED"));
                        {
                            isEncrypted = true;
                        } //End block
                        {
                            boolean var59A09AB2DBA00C2F4171F36590630DA4_1474556104 = (hdr.getName().equals("DEK-Info"));
                            {
                                dekInfo = hdr.getValue();
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            byte[] keyBytes;
            keyBytes = obj.getContent();
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new PasswordException("No password finder specified, but a password is required");
                } //End block
                char[] password;
                password = pFinder.getPassword();
                {
                    if (DroidSafeAndroidRuntime.control) throw new PasswordException("Password is null, but a password is required");
                } //End block
                StringTokenizer tknz;
                tknz = new StringTokenizer(dekInfo, ",");
                String dekAlgName;
                dekAlgName = tknz.nextToken();
                byte[] iv;
                iv = Hex.decode(tknz.nextToken());
                keyBytes = PEMUtilities.crypt(false, provider, keyBytes, password, dekAlgName, iv);
            } //End block
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_395188507 = (ASN1Sequence)ASN1Object.fromByteArray(keyBytes);
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
            varB4EAC82CA7396A68D541C85D26508E83_395188507.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_395188507;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.786 -0400", hash_original_method = "ADBD617F929757840A0FD32FA3C710F1", hash_generated_method = "98E9B2A9DBB6C5434EE239E1D433E12C")
        public  DSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.793 -0400", hash_original_method = "ADE2E96FAD316F0BCF76F4FEB2795A67", hash_generated_method = "C50C82D56FC5B71610EE63055124EFAB")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_275619339 = null; //Variable for return #1
            try 
            {
                ASN1Sequence seq;
                seq = readKeyPair(obj);
                {
                    boolean var974D70D1387D69381D57EF0F9749B5DB_916801566 = (seq.size() != 6);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new PEMException("malformed sequence in DSA private key");
                    } //End block
                } //End collapsed parenthetic
                DERInteger p;
                p = (DERInteger)seq.getObjectAt(1);
                DERInteger q;
                q = (DERInteger)seq.getObjectAt(2);
                DERInteger g;
                g = (DERInteger)seq.getObjectAt(3);
                DERInteger y;
                y = (DERInteger)seq.getObjectAt(4);
                DERInteger x;
                x = (DERInteger)seq.getObjectAt(5);
                DSAPrivateKeySpec privSpec;
                privSpec = new DSAPrivateKeySpec(
                    x.getValue(), p.getValue(),
                    q.getValue(), g.getValue());
                DSAPublicKeySpec pubSpec;
                pubSpec = new DSAPublicKeySpec(
                    y.getValue(), p.getValue(),
                    q.getValue(), g.getValue());
                KeyFactory fact;
                fact = KeyFactory.getInstance("DSA", provider);
                varB4EAC82CA7396A68D541C85D26508E83_275619339 = new KeyPair(
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
            varB4EAC82CA7396A68D541C85D26508E83_275619339.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_275619339;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class ECDSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.794 -0400", hash_original_method = "3D5918BC33C2E8750A0F79CF102B6DFC", hash_generated_method = "9454600B5FFF7DD0CC1E82DDDFCBAB29")
        public  ECDSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.795 -0400", hash_original_method = "C19C67ADBE6E6117AD29F18C950B281B", hash_generated_method = "D0FF7DB7FB4CBD6BB37C97AB73A85A8B")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1941817399 = null; //Variable for return #1
            try 
            {
                ASN1Sequence seq;
                seq = readKeyPair(obj);
                ECPrivateKeyStructure pKey;
                pKey = new ECPrivateKeyStructure(seq);
                AlgorithmIdentifier algId;
                algId = new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, pKey.getParameters());
                PrivateKeyInfo privInfo;
                privInfo = new PrivateKeyInfo(algId, pKey.getDERObject());
                SubjectPublicKeyInfo pubInfo;
                pubInfo = new SubjectPublicKeyInfo(algId, pKey.getPublicKey().getBytes());
                PKCS8EncodedKeySpec privSpec;
                privSpec = new PKCS8EncodedKeySpec(privInfo.getEncoded());
                X509EncodedKeySpec pubSpec;
                pubSpec = new X509EncodedKeySpec(pubInfo.getEncoded());
                KeyFactory fact;
                fact = KeyFactory.getInstance("ECDSA", provider);
                varB4EAC82CA7396A68D541C85D26508E83_1941817399 = new KeyPair(
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
            varB4EAC82CA7396A68D541C85D26508E83_1941817399.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1941817399;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class RSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.795 -0400", hash_original_method = "77B6A791758EAFC47A0B2DE5F4E18FED", hash_generated_method = "DDA6623EB3D7AC273FEBB7D9CBACF755")
        public  RSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.804 -0400", hash_original_method = "C48B53F279450A4E2A5829BDF7A98326", hash_generated_method = "574F8D813F07CA810A142E71413DD305")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_942798682 = null; //Variable for return #1
            try 
            {
                ASN1Sequence seq;
                seq = readKeyPair(obj);
                {
                    boolean varBFAA44BD93226625B654775E46AB9BF6_1451486707 = (seq.size() != 9);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new PEMException("malformed sequence in RSA private key");
                    } //End block
                } //End collapsed parenthetic
                DERInteger mod;
                mod = (DERInteger)seq.getObjectAt(1);
                DERInteger pubExp;
                pubExp = (DERInteger)seq.getObjectAt(2);
                DERInteger privExp;
                privExp = (DERInteger)seq.getObjectAt(3);
                DERInteger p1;
                p1 = (DERInteger)seq.getObjectAt(4);
                DERInteger p2;
                p2 = (DERInteger)seq.getObjectAt(5);
                DERInteger exp1;
                exp1 = (DERInteger)seq.getObjectAt(6);
                DERInteger exp2;
                exp2 = (DERInteger)seq.getObjectAt(7);
                DERInteger crtCoef;
                crtCoef = (DERInteger)seq.getObjectAt(8);
                RSAPublicKeySpec pubSpec;
                pubSpec = new RSAPublicKeySpec(
                    mod.getValue(), pubExp.getValue());
                RSAPrivateCrtKeySpec privSpec;
                privSpec = new RSAPrivateCrtKeySpec(
                    mod.getValue(), pubExp.getValue(), privExp.getValue(),
                    p1.getValue(), p2.getValue(),
                    exp1.getValue(), exp2.getValue(),
                    crtCoef.getValue());
                KeyFactory fact;
                fact = KeyFactory.getInstance("RSA", provider);
                varB4EAC82CA7396A68D541C85D26508E83_942798682 = new KeyPair(
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
            varB4EAC82CA7396A68D541C85D26508E83_942798682.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_942798682;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class PublicKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.805 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.805 -0400", hash_original_method = "0B170982AEB3AA2304D2A6B36AB698F1", hash_generated_method = "6FEA18513C00881A82B8B19C6587D7C1")
        public  PublicKeyParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.806 -0400", hash_original_method = "5FFFDE03CF0C93B31D80B463283D2455", hash_generated_method = "B12AD3F85B05731E94F965EE34061C41")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1070831982 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_1975087645 = null; //Variable for return #2
            KeySpec keySpec;
            keySpec = new X509EncodedKeySpec(obj.getContent());
            String[] algorithms;
            {
                int i;
                i = 0;
                {
                    try 
                    {
                        KeyFactory keyFact;
                        keyFact = KeyFactory.getInstance(algorithms[i], provider);
                        PublicKey pubKey;
                        pubKey = keyFact.generatePublic(keySpec);
                        varB4EAC82CA7396A68D541C85D26508E83_1070831982 = pubKey;
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
            varB4EAC82CA7396A68D541C85D26508E83_1975087645 = null;
            addTaint(obj.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_2137220108; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2137220108 = varB4EAC82CA7396A68D541C85D26508E83_1070831982;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2137220108 = varB4EAC82CA7396A68D541C85D26508E83_1975087645;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2137220108.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2137220108;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class RSAPublicKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.806 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.807 -0400", hash_original_method = "43B57D7EBB5BEFFE4B105714BFD44A53", hash_generated_method = "84CF85625A64D3F5A7330BBE15B0C603")
        public  RSAPublicKeyParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.807 -0400", hash_original_method = "2B7340E6F342A11B50254F4EBFCAD61E", hash_generated_method = "661D3E44AC2D37C2CF30034CED3C8393")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_706142991 = null; //Variable for return #1
            try 
            {
                ASN1InputStream ais;
                ais = new ASN1InputStream(obj.getContent());
                Object asnObject;
                asnObject = ais.readObject();
                ASN1Sequence sequence;
                sequence = (ASN1Sequence)asnObject;
                RSAPublicKeyStructure rsaPubStructure;
                rsaPubStructure = new RSAPublicKeyStructure(sequence);
                RSAPublicKeySpec keySpec;
                keySpec = new RSAPublicKeySpec(
                    rsaPubStructure.getModulus(),
                    rsaPubStructure.getPublicExponent());
                KeyFactory keyFact;
                keyFact = KeyFactory.getInstance("RSA", provider);
                varB4EAC82CA7396A68D541C85D26508E83_706142991 = keyFact.generatePublic(keySpec);
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
            varB4EAC82CA7396A68D541C85D26508E83_706142991.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_706142991;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class X509CertificateParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.820 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.821 -0400", hash_original_method = "A94C5E4D766266E16A102DAB21BC091D", hash_generated_method = "568E9262F1819DF68669D1C2DA0166D3")
        public  X509CertificateParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.821 -0400", hash_original_method = "E970ED81058B7D7B34834ED92B99A71B", hash_generated_method = "7D7F10F1B3E8C28F6BC6DDCD68F444D7")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_642800331 = null; //Variable for return #1
            ByteArrayInputStream bIn;
            bIn = new ByteArrayInputStream(obj.getContent());
            try 
            {
                CertificateFactory certFact;
                certFact = CertificateFactory.getInstance("X.509", provider);
                varB4EAC82CA7396A68D541C85D26508E83_642800331 = certFact.generateCertificate(bIn);
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem parsing cert: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_642800331.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_642800331;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.821 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.822 -0400", hash_original_method = "E353A700BDAAD44A8DB485E4FB446A3F", hash_generated_method = "0CF046E0608AEC29C4EF1AD8599D11E1")
        public  X509CRLParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.823 -0400", hash_original_method = "FC6031BD5FB1B476FDF70740E2B2704D", hash_generated_method = "8CBE35385144970414650378CEE8CC01")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1631245152 = null; //Variable for return #1
            ByteArrayInputStream bIn;
            bIn = new ByteArrayInputStream(obj.getContent());
            try 
            {
                CertificateFactory certFact;
                certFact = CertificateFactory.getInstance("X.509", provider);
                varB4EAC82CA7396A68D541C85D26508E83_1631245152 = certFact.generateCRL(bIn);
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem parsing cert: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1631245152.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1631245152;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.823 -0400", hash_original_method = "33AF8B880E8127EFE5F17F2D4C65D4F3", hash_generated_method = "33AF8B880E8127EFE5F17F2D4C65D4F3")
        public PKCS10CertificationRequestParser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.824 -0400", hash_original_method = "CDCCA4D777F3AF625C0928D23D03AC75", hash_generated_method = "3B6D4E10A5B749DFD2DF56533D681228")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1449472069 = null; //Variable for return #1
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1449472069 = new PKCS10CertificationRequest(obj.getContent());
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem parsing certrequest: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1449472069.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1449472069;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.824 -0400", hash_original_method = "7BCD24730CEC01AC7ECF6E6CD774D6E0", hash_generated_method = "7BCD24730CEC01AC7ECF6E6CD774D6E0")
        public PKCS7Parser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.835 -0400", hash_original_method = "349205E9CFEFFD40FE2D93E7DAF8E867", hash_generated_method = "2989C50853087B2194D29C60A2FA410D")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_278414592 = null; //Variable for return #1
            try 
            {
                ASN1InputStream aIn;
                aIn = new ASN1InputStream(obj.getContent());
                varB4EAC82CA7396A68D541C85D26508E83_278414592 = ContentInfo.getInstance(aIn.readObject());
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem parsing PKCS7 object: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_278414592.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_278414592;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.836 -0400", hash_original_method = "45D9D0D62A34F27B8FC81044406762B2", hash_generated_method = "45D9D0D62A34F27B8FC81044406762B2")
        public X509AttributeCertificateParser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.837 -0400", hash_original_method = "C751E950E815D18D55C97B4D94E88025", hash_generated_method = "E627002BDC4CE4204C6A8D4568E15117")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1736791327 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1736791327 = new X509V2AttributeCertificate(obj.getContent());
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1736791327.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1736791327;
            // ---------- Original Method ----------
            //return new X509V2AttributeCertificate(obj.getContent());
        }

        
    }


    
    private class ECNamedCurveSpecParser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.837 -0400", hash_original_method = "6EE69FC59FA5D4825234247899DC0928", hash_generated_method = "6EE69FC59FA5D4825234247899DC0928")
        public ECNamedCurveSpecParser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.838 -0400", hash_original_method = "76529322BBA013222CE8C144A2985A3B", hash_generated_method = "BFA66E133B304B00D5E2B7B5DD12D884")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_802536819 = null; //Variable for return #1
            try 
            {
                DERObjectIdentifier oid;
                oid = (DERObjectIdentifier)ASN1Object.fromByteArray(obj.getContent());
                Object params;
                params = ECNamedCurveTable.getParameterSpec(oid.getId());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("object ID not found in EC curve table");
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_802536819 = params;
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
            varB4EAC82CA7396A68D541C85D26508E83_802536819.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_802536819;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.838 -0400", hash_original_field = "4EACA8834A05AB66E18F6DFB559CED3E", hash_generated_field = "7250E15B2C636F0751D5B7C0DD47B256")

        private String symProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.838 -0400", hash_original_field = "CCA8F5193CBB2A08D508AA8F4F55F412", hash_generated_field = "0F549A2B688E81487E68FB3369A216E4")

        private String asymProvider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.838 -0400", hash_original_method = "E8D8629FC61D2C1E41CC63DCCA2261A4", hash_generated_method = "9E67816548B159C198D0387C48F7FAEF")
        public  EncryptedPrivateKeyParser(String symProvider, String asymProvider) {
            this.symProvider = symProvider;
            this.asymProvider = asymProvider;
            // ---------- Original Method ----------
            //this.symProvider = symProvider;
            //this.asymProvider = asymProvider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.850 -0400", hash_original_method = "B158B358DBE9E580DC539CC61ABD0BEA", hash_generated_method = "CE940E8CF77DA64F0E643BAFD9806551")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_665954182 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_400744928 = null; //Variable for return #2
            Object varB4EAC82CA7396A68D541C85D26508E83_1056847961 = null; //Variable for return #3
            try 
            {
                EncryptedPrivateKeyInfo info;
                info = EncryptedPrivateKeyInfo.getInstance(ASN1Object.fromByteArray(obj.getContent()));
                AlgorithmIdentifier algId;
                algId = info.getEncryptionAlgorithm();
                {
                    if (DroidSafeAndroidRuntime.control) throw new PEMException("no PasswordFinder specified");
                } //End block
                {
                    boolean var47DB76E816F9ADD991AEA437B8D7991D_719951688 = (PEMUtilities.isPKCS5Scheme2(algId.getAlgorithm()));
                    {
                        PBES2Parameters params;
                        params = PBES2Parameters.getInstance(algId.getParameters());
                        KeyDerivationFunc func;
                        func = params.getKeyDerivationFunc();
                        EncryptionScheme scheme;
                        scheme = params.getEncryptionScheme();
                        PBKDF2Params defParams;
                        defParams = (PBKDF2Params)func.getParameters();
                        int iterationCount;
                        iterationCount = defParams.getIterationCount().intValue();
                        byte[] salt;
                        salt = defParams.getSalt();
                        String algorithm;
                        algorithm = scheme.getAlgorithm().getId();
                        SecretKey key;
                        key = PEMUtilities.generateSecretKeyForPKCS5Scheme2(algorithm, pFinder.getPassword(), salt, iterationCount);
                        Cipher cipher;
                        cipher = Cipher.getInstance(algorithm, symProvider);
                        AlgorithmParameters algParams;
                        algParams = AlgorithmParameters.getInstance(algorithm, symProvider);
                        algParams.init(scheme.getParameters().getDERObject().getEncoded());
                        cipher.init(Cipher.DECRYPT_MODE, key, algParams);
                        PrivateKeyInfo pInfo;
                        pInfo = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(cipher.doFinal(info.getEncryptedData())));
                        PKCS8EncodedKeySpec keySpec;
                        keySpec = new PKCS8EncodedKeySpec(pInfo.getEncoded());
                        KeyFactory keyFact;
                        keyFact = KeyFactory.getInstance(pInfo.getAlgorithmId().getAlgorithm().getId(), asymProvider);
                        varB4EAC82CA7396A68D541C85D26508E83_665954182 = keyFact.generatePrivate(keySpec);
                    } //End block
                    {
                        boolean var2B57198D6FD24854351D5A053B297FA7_1860179466 = (PEMUtilities.isPKCS12(algId.getAlgorithm()));
                        {
                            PKCS12PBEParams params;
                            params = PKCS12PBEParams.getInstance(algId.getParameters());
                            String algorithm;
                            algorithm = algId.getAlgorithm().getId();
                            PBEKeySpec pbeSpec;
                            pbeSpec = new PBEKeySpec(pFinder.getPassword());
                            SecretKeyFactory secKeyFact;
                            secKeyFact = SecretKeyFactory.getInstance(algorithm, symProvider);
                            PBEParameterSpec defParams;
                            defParams = new PBEParameterSpec(params.getIV(), params.getIterations().intValue());
                            Cipher cipher;
                            cipher = Cipher.getInstance(algorithm, symProvider);
                            cipher.init(Cipher.DECRYPT_MODE, secKeyFact.generateSecret(pbeSpec), defParams);
                            PrivateKeyInfo pInfo;
                            pInfo = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(cipher.doFinal(info.getEncryptedData())));
                            PKCS8EncodedKeySpec keySpec;
                            keySpec = new PKCS8EncodedKeySpec(pInfo.getEncoded());
                            KeyFactory keyFact;
                            keyFact = KeyFactory.getInstance(pInfo.getAlgorithmId().getAlgorithm().getId(), asymProvider);
                            varB4EAC82CA7396A68D541C85D26508E83_400744928 = keyFact.generatePrivate(keySpec);
                        } //End block
                        {
                            boolean var3EC9697B1D1A3E0BA2C48E715FFC8440_1701038879 = (PEMUtilities.isPKCS5Scheme1(algId.getAlgorithm()));
                            {
                                PBEParameter params;
                                params = PBEParameter.getInstance(algId.getParameters());
                                String algorithm;
                                algorithm = algId.getAlgorithm().getId();
                                PBEKeySpec pbeSpec;
                                pbeSpec = new PBEKeySpec(pFinder.getPassword());
                                SecretKeyFactory secKeyFact;
                                secKeyFact = SecretKeyFactory.getInstance(algorithm, symProvider);
                                PBEParameterSpec defParams;
                                defParams = new PBEParameterSpec(params.getSalt(), params.getIterationCount().intValue());
                                Cipher cipher;
                                cipher = Cipher.getInstance(algorithm, symProvider);
                                cipher.init(Cipher.DECRYPT_MODE, secKeyFact.generateSecret(pbeSpec), defParams);
                                PrivateKeyInfo pInfo;
                                pInfo = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(cipher.doFinal(info.getEncryptedData())));
                                PKCS8EncodedKeySpec keySpec;
                                keySpec = new PKCS8EncodedKeySpec(pInfo.getEncoded());
                                KeyFactory keyFact;
                                keyFact = KeyFactory.getInstance(pInfo.getAlgorithmId().getAlgorithm().getId(), asymProvider);
                                varB4EAC82CA7396A68D541C85D26508E83_1056847961 = keyFact.generatePrivate(keySpec);
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
            Object varA7E53CE21691AB073D9660D615818899_1566882871; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1566882871 = varB4EAC82CA7396A68D541C85D26508E83_665954182;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1566882871 = varB4EAC82CA7396A68D541C85D26508E83_400744928;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1566882871 = varB4EAC82CA7396A68D541C85D26508E83_1056847961;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1566882871.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1566882871;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class PrivateKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.862 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.862 -0400", hash_original_method = "0877761703B26434F32E47C53A29AE74", hash_generated_method = "15BF9532DC3933BF57B695673E62B835")
        public  PrivateKeyParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.863 -0400", hash_original_method = "2553B1C8B63939D2139C3EAA36C566E7", hash_generated_method = "603AC5AE271DA81695614937913A08EA")
        public Object parseObject(PemObject obj) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_874778749 = null; //Variable for return #1
            try 
            {
                PrivateKeyInfo info;
                info = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(obj.getContent()));
                PKCS8EncodedKeySpec keySpec;
                keySpec = new PKCS8EncodedKeySpec(obj.getContent());
                KeyFactory keyFact;
                keyFact = KeyFactory.getInstance(info.getAlgorithmId().getAlgorithm().getId(), provider);
                varB4EAC82CA7396A68D541C85D26508E83_874778749 = keyFact.generatePrivate(keySpec);
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PEMException("problem parsing PRIVATE KEY: " + e.toString(), e);
            } //End block
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_874778749.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_874778749;
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

