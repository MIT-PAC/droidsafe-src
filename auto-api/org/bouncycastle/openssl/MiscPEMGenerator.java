package org.bouncycastle.openssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.jce.PKCS10CertificationRequest;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.io.pem.PemGenerationException;
import org.bouncycastle.util.io.pem.PemHeader;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.bouncycastle.x509.X509AttributeCertificate;
import org.bouncycastle.x509.X509V2AttributeCertificate;

public class MiscPEMGenerator implements PemObjectGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.995 -0400", hash_original_field = "BE8F80182E0C983916DA7338C2C1C040", hash_generated_field = "03657E147A117C299E988405DFDF1FE0")

    private Object obj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.995 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.995 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.995 -0400", hash_original_field = "7DDF32E17A6AC5CE04A8ECBF782CA509", hash_generated_field = "47462950F1DBF0D228B8D6FE202BDA9F")

    private SecureRandom random;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.995 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.995 -0400", hash_original_method = "C02D6ACBF889CF35766B7871B784307D", hash_generated_method = "2850ED16A7B9528D560ED52741366F34")
    public  MiscPEMGenerator(Object o) {
        this.obj = o;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.996 -0400", hash_original_method = "AD2D21FAE267AE7BA19486B70A7A435E", hash_generated_method = "9975F4F1D94CD2D098CEA7C2FCAAB346")
    public  MiscPEMGenerator(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random,
        Provider     provider) {
        this.obj = obj;
        this.algorithm = algorithm;
        this.password = password;
        this.random = random;
        this.provider = provider;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.996 -0400", hash_original_method = "FC3CFC06395928A5BA1B88C136A7A3A1", hash_generated_method = "8F0E47186590BFC9DE756B04ECB162F4")
    public  MiscPEMGenerator(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random,
        String       provider) throws NoSuchProviderException {
        this.obj = obj;
        this.algorithm = algorithm;
        this.password = password;
        this.random = random;
        {
            this.provider = Security.getProvider(provider);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchProviderException("cannot find provider: " + provider);
            } 
        } 
        
        
        
        
        
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.998 -0400", hash_original_method = "BB771E0C3864CDE92E08322A05A8C925", hash_generated_method = "F10B018644319F7C1AFCE43E53FDDC93")
    private PemObject createPemObject(Object o) throws IOException {
        PemObject varB4EAC82CA7396A68D541C85D26508E83_453449152 = null; 
        PemObject varB4EAC82CA7396A68D541C85D26508E83_619031605 = null; 
        PemObject varB4EAC82CA7396A68D541C85D26508E83_1187530678 = null; 
        PemObject varB4EAC82CA7396A68D541C85D26508E83_165482801 = null; 
        String type;
        byte[] encoding;
        {
            varB4EAC82CA7396A68D541C85D26508E83_453449152 = (PemObject)o;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_619031605 = ((PemObjectGenerator)o).generate();
        } 
        {
            type = "CERTIFICATE";
            try 
            {
                encoding = ((X509Certificate)o).getEncoded();
            } 
            catch (CertificateEncodingException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PemGenerationException("Cannot encode object: " + e.toString());
            } 
        } 
        {
            type = "X509 CRL";
            try 
            {
                encoding = ((X509CRL)o).getEncoded();
            } 
            catch (CRLException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PemGenerationException("Cannot encode object: " + e.toString());
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1187530678 = createPemObject(((KeyPair)o).getPrivate());
        } 
        {
            PrivateKeyInfo info = new PrivateKeyInfo(
                (ASN1Sequence) ASN1Object.fromByteArray(((Key)o).getEncoded()));
            {
                type = "RSA PRIVATE KEY";
                encoding = info.getPrivateKey().getEncoded();
            } 
            {
                type = "DSA PRIVATE KEY";
                DSAParameter p = DSAParameter.getInstance(info.getAlgorithmId().getParameters());
                ASN1EncodableVector v = new ASN1EncodableVector();
                v.add(new DERInteger(0));
                v.add(new DERInteger(p.getP()));
                v.add(new DERInteger(p.getQ()));
                v.add(new DERInteger(p.getG()));
                BigInteger x = ((DSAPrivateKey)o).getX();
                BigInteger y = p.getG().modPow(x, p.getP());
                v.add(new DERInteger(y));
                v.add(new DERInteger(x));
                encoding = new DERSequence(v).getEncoded();
            } 
            {
                boolean var32F95F35AF334BEC5DE8195500E1E92A_1072664020 = (((PrivateKey)o).getAlgorithm().equals("ECDSA"));
                {
                    type = "EC PRIVATE KEY";
                    encoding = info.getPrivateKey().getEncoded();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Cannot identify private key");
                } 
            } 
        } 
        {
            type = "PUBLIC KEY";
            encoding = ((PublicKey)o).getEncoded();
        } 
        {
            type = "ATTRIBUTE CERTIFICATE";
            encoding = ((X509V2AttributeCertificate)o).getEncoded();
        } 
        {
            type = "CERTIFICATE REQUEST";
            encoding = ((PKCS10CertificationRequest)o).getEncoded();
        } 
        {
            type = "PKCS7";
            encoding = ((ContentInfo)o).getEncoded();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new PemGenerationException("unknown object passed - can't encode.");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_165482801 = new PemObject(type, encoding);
        addTaint(o.getTaint());
        PemObject varA7E53CE21691AB073D9660D615818899_538579244; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_538579244 = varB4EAC82CA7396A68D541C85D26508E83_453449152;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_538579244 = varB4EAC82CA7396A68D541C85D26508E83_619031605;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_538579244 = varB4EAC82CA7396A68D541C85D26508E83_1187530678;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_538579244 = varB4EAC82CA7396A68D541C85D26508E83_165482801;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_538579244.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_538579244;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.000 -0400", hash_original_method = "DE836D95AE95CC4B16EC27C37C4EBA2F", hash_generated_method = "D4983773D80B6B21ECB2AD53A3DA322F")
    private String getHexEncoded(byte[] bytes) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1957309397 = null; 
        bytes = Hex.encode(bytes);
        char[] chars = new char[bytes.length];
        {
            int i = 0;
            {
                chars[i] = (char)bytes[i];
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1957309397 = new String(chars);
        addTaint(bytes[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1957309397.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1957309397;
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.002 -0400", hash_original_method = "C0940F4479949D8BE443C2F5943EB650", hash_generated_method = "5CA384A1D824333875D16E267BE33C7D")
    private PemObject createPemObject(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random) throws IOException {
        PemObject varB4EAC82CA7396A68D541C85D26508E83_18399006 = null; 
        PemObject varB4EAC82CA7396A68D541C85D26508E83_242265949 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_18399006 = createPemObject(((KeyPair)obj).getPrivate(), algorithm, password, random);
        } 
        String type = null;
        byte[] keyData = null;
        {
            type = "RSA PRIVATE KEY";
            RSAPrivateCrtKey k = (RSAPrivateCrtKey)obj;
            RSAPrivateKeyStructure keyStruct = new RSAPrivateKeyStructure(
                k.getModulus(),
                k.getPublicExponent(),
                k.getPrivateExponent(),
                k.getPrimeP(),
                k.getPrimeQ(),
                k.getPrimeExponentP(),
                k.getPrimeExponentQ(),
                k.getCrtCoefficient());
            keyData = keyStruct.getEncoded();
        } 
        {
            type = "DSA PRIVATE KEY";
            DSAPrivateKey k = (DSAPrivateKey)obj;
            DSAParams p = k.getParams();
            ASN1EncodableVector v = new ASN1EncodableVector();
            v.add(new DERInteger(0));
            v.add(new DERInteger(p.getP()));
            v.add(new DERInteger(p.getQ()));
            v.add(new DERInteger(p.getG()));
            BigInteger x = k.getX();
            BigInteger y = p.getG().modPow(x, p.getP());
            v.add(new DERInteger(y));
            v.add(new DERInteger(x));
            keyData = new DERSequence(v).getEncoded();
        } 
        {
            boolean var621AD920A4A1C3B37CFC4E1CFAD8A164_1089152390 = (obj instanceof PrivateKey && "ECDSA".equals(((PrivateKey)obj).getAlgorithm()));
            {
                type = "EC PRIVATE KEY";
                PrivateKeyInfo privInfo = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(((PrivateKey)obj).getEncoded()));
                keyData = privInfo.getPrivateKey().getEncoded();
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Object type not supported: " + obj.getClass().getName());
        } 
        String dekAlgName = Strings.toUpperCase(algorithm);
        {
            boolean var8D78E20A60FC206B65EF4CDCEB738EC3_184737617 = (dekAlgName.equals("DESEDE"));
            {
                dekAlgName = "DES-EDE3-CBC";
            } 
        } 
        int ivLength;
        boolean var1D30E47A11D832D47735AD6C7AF21620_1039871409 = (dekAlgName.startsWith("AES-"));
        ivLength = 16;
        ivLength = 8;
        byte[] iv = new byte[ivLength];
        random.nextBytes(iv);
        byte[] encData = PEMUtilities.crypt(true, provider, keyData, password, dekAlgName, iv);
        List headers = new ArrayList(2);
        headers.add(new PemHeader("Proc-Type", "4,ENCRYPTED"));
        headers.add(new PemHeader("DEK-Info", dekAlgName + "," + getHexEncoded(iv)));
        varB4EAC82CA7396A68D541C85D26508E83_242265949 = new PemObject(type, headers, encData);
        addTaint(obj.getTaint());
        addTaint(algorithm.getTaint());
        addTaint(password[0]);
        addTaint(random.getTaint());
        PemObject varA7E53CE21691AB073D9660D615818899_2145949823; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2145949823 = varB4EAC82CA7396A68D541C85D26508E83_18399006;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2145949823 = varB4EAC82CA7396A68D541C85D26508E83_242265949;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2145949823.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2145949823;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.003 -0400", hash_original_method = "E9B86B455C150CA2FE6340A6ABEAFEB2", hash_generated_method = "8F53E9D12F0260319613CE17789DBC8A")
    public PemObject generate() throws PemGenerationException {
        PemObject varB4EAC82CA7396A68D541C85D26508E83_654788706 = null; 
        PemObject varB4EAC82CA7396A68D541C85D26508E83_987707347 = null; 
        try 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_654788706 = createPemObject(obj, algorithm, password, random);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_987707347 = createPemObject(obj);
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new PemGenerationException("encoding exception: " + e.getMessage(), e);
        } 
        PemObject varA7E53CE21691AB073D9660D615818899_548164310; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_548164310 = varB4EAC82CA7396A68D541C85D26508E83_654788706;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_548164310 = varB4EAC82CA7396A68D541C85D26508E83_987707347;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_548164310.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_548164310;
        
        
        
            
            
                
            
            
        
        
        
            
        
    }

    
}

