package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.675 -0400", hash_original_field = "BE8F80182E0C983916DA7338C2C1C040", hash_generated_field = "03657E147A117C299E988405DFDF1FE0")

    private Object obj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.675 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.675 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.675 -0400", hash_original_field = "7DDF32E17A6AC5CE04A8ECBF782CA509", hash_generated_field = "47462950F1DBF0D228B8D6FE202BDA9F")

    private SecureRandom random;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.675 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.684 -0400", hash_original_method = "C02D6ACBF889CF35766B7871B784307D", hash_generated_method = "2850ED16A7B9528D560ED52741366F34")
    public  MiscPEMGenerator(Object o) {
        this.obj = o;
        // ---------- Original Method ----------
        //this.obj = o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.685 -0400", hash_original_method = "AD2D21FAE267AE7BA19486B70A7A435E", hash_generated_method = "9975F4F1D94CD2D098CEA7C2FCAAB346")
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
        // ---------- Original Method ----------
        //this.obj = obj;
        //this.algorithm = algorithm;
        //this.password = password;
        //this.random = random;
        //this.provider = provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.686 -0400", hash_original_method = "FC3CFC06395928A5BA1B88C136A7A3A1", hash_generated_method = "8F0E47186590BFC9DE756B04ECB162F4")
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
            } //End block
        } //End block
        // ---------- Original Method ----------
        //this.obj = obj;
        //this.algorithm = algorithm;
        //this.password = password;
        //this.random = random;
        //if (provider != null)
        //{
            //this.provider = Security.getProvider(provider);
            //if (this.provider == null)
            //{
                //throw new NoSuchProviderException("cannot find provider: " + provider);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.688 -0400", hash_original_method = "BB771E0C3864CDE92E08322A05A8C925", hash_generated_method = "2404D61CADC0DE12C9887F9D442CAB06")
    private PemObject createPemObject(Object o) throws IOException {
        PemObject varB4EAC82CA7396A68D541C85D26508E83_1819864824 = null; //Variable for return #1
        PemObject varB4EAC82CA7396A68D541C85D26508E83_1496747736 = null; //Variable for return #2
        PemObject varB4EAC82CA7396A68D541C85D26508E83_375331630 = null; //Variable for return #3
        PemObject varB4EAC82CA7396A68D541C85D26508E83_395211214 = null; //Variable for return #4
        String type;
        byte[] encoding;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1819864824 = (PemObject)o;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1496747736 = ((PemObjectGenerator)o).generate();
        } //End block
        {
            type = "CERTIFICATE";
            try 
            {
                encoding = ((X509Certificate)o).getEncoded();
            } //End block
            catch (CertificateEncodingException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PemGenerationException("Cannot encode object: " + e.toString());
            } //End block
        } //End block
        {
            type = "X509 CRL";
            try 
            {
                encoding = ((X509CRL)o).getEncoded();
            } //End block
            catch (CRLException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PemGenerationException("Cannot encode object: " + e.toString());
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_375331630 = createPemObject(((KeyPair)o).getPrivate());
        } //End block
        {
            PrivateKeyInfo info;
            info = new PrivateKeyInfo(
                (ASN1Sequence) ASN1Object.fromByteArray(((Key)o).getEncoded()));
            {
                type = "RSA PRIVATE KEY";
                encoding = info.getPrivateKey().getEncoded();
            } //End block
            {
                type = "DSA PRIVATE KEY";
                DSAParameter p;
                p = DSAParameter.getInstance(info.getAlgorithmId().getParameters());
                ASN1EncodableVector v;
                v = new ASN1EncodableVector();
                v.add(new DERInteger(0));
                v.add(new DERInteger(p.getP()));
                v.add(new DERInteger(p.getQ()));
                v.add(new DERInteger(p.getG()));
                BigInteger x;
                x = ((DSAPrivateKey)o).getX();
                BigInteger y;
                y = p.getG().modPow(x, p.getP());
                v.add(new DERInteger(y));
                v.add(new DERInteger(x));
                encoding = new DERSequence(v).getEncoded();
            } //End block
            {
                boolean var32F95F35AF334BEC5DE8195500E1E92A_1109067168 = (((PrivateKey)o).getAlgorithm().equals("ECDSA"));
                {
                    type = "EC PRIVATE KEY";
                    encoding = info.getPrivateKey().getEncoded();
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Cannot identify private key");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            type = "PUBLIC KEY";
            encoding = ((PublicKey)o).getEncoded();
        } //End block
        {
            type = "ATTRIBUTE CERTIFICATE";
            encoding = ((X509V2AttributeCertificate)o).getEncoded();
        } //End block
        {
            type = "CERTIFICATE REQUEST";
            encoding = ((PKCS10CertificationRequest)o).getEncoded();
        } //End block
        {
            type = "PKCS7";
            encoding = ((ContentInfo)o).getEncoded();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new PemGenerationException("unknown object passed - can't encode.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_395211214 = new PemObject(type, encoding);
        addTaint(o.getTaint());
        PemObject varA7E53CE21691AB073D9660D615818899_94731912; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_94731912 = varB4EAC82CA7396A68D541C85D26508E83_1819864824;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_94731912 = varB4EAC82CA7396A68D541C85D26508E83_1496747736;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_94731912 = varB4EAC82CA7396A68D541C85D26508E83_375331630;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_94731912 = varB4EAC82CA7396A68D541C85D26508E83_395211214;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_94731912.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_94731912;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.690 -0400", hash_original_method = "DE836D95AE95CC4B16EC27C37C4EBA2F", hash_generated_method = "E4BBCB629537D6F4DA813E0ACA587343")
    private String getHexEncoded(byte[] bytes) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_341961984 = null; //Variable for return #1
        bytes = Hex.encode(bytes);
        char[] chars;
        chars = new char[bytes.length];
        {
            int i;
            i = 0;
            {
                chars[i] = (char)bytes[i];
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_341961984 = new String(chars);
        addTaint(bytes[0]);
        varB4EAC82CA7396A68D541C85D26508E83_341961984.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_341961984;
        // ---------- Original Method ----------
        //bytes = Hex.encode(bytes);
        //char[] chars = new char[bytes.length];
        //for (int i = 0; i != bytes.length; i++)
        //{
            //chars[i] = (char)bytes[i];
        //}
        //return new String(chars);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.698 -0400", hash_original_method = "C0940F4479949D8BE443C2F5943EB650", hash_generated_method = "03A8E585F6D6B4139578C4D3FF7A329A")
    private PemObject createPemObject(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random) throws IOException {
        PemObject varB4EAC82CA7396A68D541C85D26508E83_1755963662 = null; //Variable for return #1
        PemObject varB4EAC82CA7396A68D541C85D26508E83_956519928 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1755963662 = createPemObject(((KeyPair)obj).getPrivate(), algorithm, password, random);
        } //End block
        String type;
        type = null;
        byte[] keyData;
        keyData = null;
        {
            type = "RSA PRIVATE KEY";
            RSAPrivateCrtKey k;
            k = (RSAPrivateCrtKey)obj;
            RSAPrivateKeyStructure keyStruct;
            keyStruct = new RSAPrivateKeyStructure(
                k.getModulus(),
                k.getPublicExponent(),
                k.getPrivateExponent(),
                k.getPrimeP(),
                k.getPrimeQ(),
                k.getPrimeExponentP(),
                k.getPrimeExponentQ(),
                k.getCrtCoefficient());
            keyData = keyStruct.getEncoded();
        } //End block
        {
            type = "DSA PRIVATE KEY";
            DSAPrivateKey k;
            k = (DSAPrivateKey)obj;
            DSAParams p;
            p = k.getParams();
            ASN1EncodableVector v;
            v = new ASN1EncodableVector();
            v.add(new DERInteger(0));
            v.add(new DERInteger(p.getP()));
            v.add(new DERInteger(p.getQ()));
            v.add(new DERInteger(p.getG()));
            BigInteger x;
            x = k.getX();
            BigInteger y;
            y = p.getG().modPow(x, p.getP());
            v.add(new DERInteger(y));
            v.add(new DERInteger(x));
            keyData = new DERSequence(v).getEncoded();
        } //End block
        {
            boolean var621AD920A4A1C3B37CFC4E1CFAD8A164_968774966 = (obj instanceof PrivateKey && "ECDSA".equals(((PrivateKey)obj).getAlgorithm()));
            {
                type = "EC PRIVATE KEY";
                PrivateKeyInfo privInfo;
                privInfo = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(((PrivateKey)obj).getEncoded()));
                keyData = privInfo.getPrivateKey().getEncoded();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Object type not supported: " + obj.getClass().getName());
        } //End block
        String dekAlgName;
        dekAlgName = Strings.toUpperCase(algorithm);
        {
            boolean var8D78E20A60FC206B65EF4CDCEB738EC3_428918906 = (dekAlgName.equals("DESEDE"));
            {
                dekAlgName = "DES-EDE3-CBC";
            } //End block
        } //End collapsed parenthetic
        int ivLength;
        boolean var1D30E47A11D832D47735AD6C7AF21620_1814387140 = (dekAlgName.startsWith("AES-"));
        ivLength = 16;
        ivLength = 8;
        byte[] iv;
        iv = new byte[ivLength];
        random.nextBytes(iv);
        byte[] encData;
        encData = PEMUtilities.crypt(true, provider, keyData, password, dekAlgName, iv);
        List headers;
        headers = new ArrayList(2);
        headers.add(new PemHeader("Proc-Type", "4,ENCRYPTED"));
        headers.add(new PemHeader("DEK-Info", dekAlgName + "," + getHexEncoded(iv)));
        varB4EAC82CA7396A68D541C85D26508E83_956519928 = new PemObject(type, headers, encData);
        addTaint(obj.getTaint());
        addTaint(algorithm.getTaint());
        addTaint(password[0]);
        addTaint(random.getTaint());
        PemObject varA7E53CE21691AB073D9660D615818899_559236992; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_559236992 = varB4EAC82CA7396A68D541C85D26508E83_1755963662;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_559236992 = varB4EAC82CA7396A68D541C85D26508E83_956519928;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_559236992.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_559236992;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.700 -0400", hash_original_method = "E9B86B455C150CA2FE6340A6ABEAFEB2", hash_generated_method = "967896AF712B3C65B14DB6AA2AB70FCC")
    public PemObject generate() throws PemGenerationException {
        PemObject varB4EAC82CA7396A68D541C85D26508E83_1407871817 = null; //Variable for return #1
        PemObject varB4EAC82CA7396A68D541C85D26508E83_508843815 = null; //Variable for return #2
        try 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1407871817 = createPemObject(obj, algorithm, password, random);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_508843815 = createPemObject(obj);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new PemGenerationException("encoding exception: " + e.getMessage(), e);
        } //End block
        PemObject varA7E53CE21691AB073D9660D615818899_668321845; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_668321845 = varB4EAC82CA7396A68D541C85D26508E83_1407871817;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_668321845 = varB4EAC82CA7396A68D541C85D26508E83_508843815;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_668321845.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_668321845;
        // ---------- Original Method ----------
        //try
        //{
            //if (algorithm != null)
            //{
                //return createPemObject(obj, algorithm, password, random);
            //}
            //return createPemObject(obj);
        //}
        //catch (IOException e)
        //{
            //throw new PemGenerationException("encoding exception: " + e.getMessage(), e);
        //}
    }

    
}

