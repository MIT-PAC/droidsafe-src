package org.bouncycastle.openssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.293 -0400", hash_original_field = "DFAA5B65B87CDDE1589034B535B31A0A", hash_generated_field = "1B324848B9CCB600B6F9F412146CB5D6")

    private final Map parsers = new HashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.293 -0400", hash_original_field = "5CD9C2E7D64B912B29078A3E35C28F5E", hash_generated_field = "7A318D1FC589B8A927004A5BBE837049")

    private PasswordFinder pFinder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.293 -0400", hash_original_method = "2732903E834E35077990228D3EC5372C", hash_generated_method = "9D0E243820E7950FE695D0C348CB2B9F")
    public  PEMReader(
        Reader reader) {
        this(reader, null, "BC");
        addTaint(reader.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.293 -0400", hash_original_method = "264D7373D1280C46B7B3C63F3DA0F057", hash_generated_method = "705B33BAACE1A8A98B2560263763B8D5")
    public  PEMReader(
        Reader reader,
        PasswordFinder pFinder) {
        this(reader, pFinder, "BC");
        addTaint(pFinder.getTaint());
        addTaint(reader.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.294 -0400", hash_original_method = "F26FB5757482F756B15ADBECFFA22920", hash_generated_method = "0168B3B6DCC204D41581A4E4A23DEF2E")
    public  PEMReader(
        Reader reader,
        PasswordFinder pFinder,
        String provider) {
        this(reader, pFinder, provider, provider);
        addTaint(provider.getTaint());
        addTaint(pFinder.getTaint());
        addTaint(reader.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.295 -0400", hash_original_method = "CEFEBB919AD354EB1A0A7FBF2E2E3ECF", hash_generated_method = "DB91BC49650093E23DF34F596B13748D")
    public  PEMReader(
        Reader reader,
        PasswordFinder pFinder,
        String symProvider,
        String asymProvider) {
        super(reader);
        addTaint(asymProvider.getTaint());
        addTaint(symProvider.getTaint());
        addTaint(reader.getTaint());
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
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.296 -0400", hash_original_method = "127E22226D67F5F9289AA2863D2E5AFD", hash_generated_method = "E23D286A83270232A32F8CDCFD3DF1C9")
    public Object readObject() throws IOException {
        PemObject obj = readPemObject();
    if(obj != null)        
        {
            String type = obj.getType();
    if(parsers.containsKey(type))            
            {
Object var3A81707C91CA6721ECEB781CDBC013C2_1828462483 =                 ((PemObjectParser)parsers.get(type)).parseObject(obj);
                var3A81707C91CA6721ECEB781CDBC013C2_1828462483.addTaint(taint);
                return var3A81707C91CA6721ECEB781CDBC013C2_1828462483;
            } 
            else
            {
                IOException var70A619DCC02CED381329A437D633B59D_1147989594 = new IOException("unrecognised object: " + type);
                var70A619DCC02CED381329A437D633B59D_1147989594.addTaint(taint);
                throw var70A619DCC02CED381329A437D633B59D_1147989594;
            } 
        } 
Object var540C13E9E156B687226421B24F2DF178_1989460065 =         null;
        var540C13E9E156B687226421B24F2DF178_1989460065.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1989460065;
        
        
        
        
            
            
            
                
            
            
            
                
            
        
        
    }

    
    private abstract class KeyPairParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.296 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "AFDE0FC943DF429CC56BE81349BC4014")

        protected String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.297 -0400", hash_original_method = "D97A7462FC5E95C470F1E84C9A4F9D7B", hash_generated_method = "AEB043DD3F85D4A6336E5753ECB334C0")
        public  KeyPairParser(String provider) {
            this.provider = provider;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.299 -0400", hash_original_method = "D2B938CFC8BBB876E5EB510A00C9CCB3", hash_generated_method = "11C276732499EB76CA31E2C040F3A696")
        protected ASN1Sequence readKeyPair(
            PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            boolean isEncrypted = false;
            String dekInfo = null;
            List headers = obj.getHeaders();
for(Iterator it = headers.iterator();it.hasNext();)
            {
                PemHeader hdr = (PemHeader)it.next();
    if(hdr.getName().equals("Proc-Type") && hdr.getValue().equals("4,ENCRYPTED"))                
                {
                    isEncrypted = true;
                } 
                else
    if(hdr.getName().equals("DEK-Info"))                
                {
                    dekInfo = hdr.getValue();
                } 
            } 
            byte[] keyBytes = obj.getContent();
    if(isEncrypted)            
            {
    if(pFinder == null)                
                {
                    PasswordException var91FF4DCF86A2042EE65FD11154EAEAB6_471851284 = new PasswordException("No password finder specified, but a password is required");
                    var91FF4DCF86A2042EE65FD11154EAEAB6_471851284.addTaint(taint);
                    throw var91FF4DCF86A2042EE65FD11154EAEAB6_471851284;
                } 
                char[] password = pFinder.getPassword();
    if(password == null)                
                {
                    PasswordException var72B5E4C3645EE62C98877BEE4FA7A205_64741146 = new PasswordException("Password is null, but a password is required");
                    var72B5E4C3645EE62C98877BEE4FA7A205_64741146.addTaint(taint);
                    throw var72B5E4C3645EE62C98877BEE4FA7A205_64741146;
                } 
                StringTokenizer tknz = new StringTokenizer(dekInfo, ",");
                String dekAlgName = tknz.nextToken();
                byte[] iv = Hex.decode(tknz.nextToken());
                keyBytes = PEMUtilities.crypt(false, provider, keyBytes, password, dekAlgName, iv);
            } 
            try 
            {
ASN1Sequence var2E579F18C8B32DEE34ED2B653450B91E_2128542017 =                 (ASN1Sequence)ASN1Object.fromByteArray(keyBytes);
                var2E579F18C8B32DEE34ED2B653450B91E_2128542017.addTaint(taint);
                return var2E579F18C8B32DEE34ED2B653450B91E_2128542017;
            } 
            catch (IOException e)
            {
    if(isEncrypted)                
                {
                    PEMException var23ADDE189C9D3294BE4E23AAC9C6C524_1820672839 = new PEMException("exception decoding - please check password and data.", e);
                    var23ADDE189C9D3294BE4E23AAC9C6C524_1820672839.addTaint(taint);
                    throw var23ADDE189C9D3294BE4E23AAC9C6C524_1820672839;
                } 
                else
                {
                    PEMException var0E2F75B091E2B3678FDBDFC9DA487A03_572072636 = new PEMException(e.getMessage(), e);
                    var0E2F75B091E2B3678FDBDFC9DA487A03_572072636.addTaint(taint);
                    throw var0E2F75B091E2B3678FDBDFC9DA487A03_572072636;
                } 
            } 
            catch (ClassCastException e)
            {
    if(isEncrypted)                
                {
                    PEMException var23ADDE189C9D3294BE4E23AAC9C6C524_1352331956 = new PEMException("exception decoding - please check password and data.", e);
                    var23ADDE189C9D3294BE4E23AAC9C6C524_1352331956.addTaint(taint);
                    throw var23ADDE189C9D3294BE4E23AAC9C6C524_1352331956;
                } 
                else
                {
                    PEMException var0E2F75B091E2B3678FDBDFC9DA487A03_1094039239 = new PEMException(e.getMessage(), e);
                    var0E2F75B091E2B3678FDBDFC9DA487A03_1094039239.addTaint(taint);
                    throw var0E2F75B091E2B3678FDBDFC9DA487A03_1094039239;
                } 
            } 
            
            
        }

        
    }


    
    private class DSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.300 -0400", hash_original_method = "ADBD617F929757840A0FD32FA3C710F1", hash_generated_method = "98E9B2A9DBB6C5434EE239E1D433E12C")
        public  DSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.301 -0400", hash_original_method = "ADE2E96FAD316F0BCF76F4FEB2795A67", hash_generated_method = "B95DFE8485441279B9C67292CECF4390")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                ASN1Sequence seq = readKeyPair(obj);
    if(seq.size() != 6)                
                {
                    PEMException varEE7D65505957B3E6B6E02FD39B74044F_1952104416 = new PEMException("malformed sequence in DSA private key");
                    varEE7D65505957B3E6B6E02FD39B74044F_1952104416.addTaint(taint);
                    throw varEE7D65505957B3E6B6E02FD39B74044F_1952104416;
                } 
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
Object varEAE0B1873A9922293A96783FD42EB56C_34275040 =                 new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
                varEAE0B1873A9922293A96783FD42EB56C_34275040.addTaint(taint);
                return varEAE0B1873A9922293A96783FD42EB56C_34275040;
            } 
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } 
            catch (Exception e)
            {
                PEMException var73A90879EB20D8885E68D8211442ED4B_867632547 = new PEMException(
                    "problem creating DSA private key: " + e.toString(), e);
                var73A90879EB20D8885E68D8211442ED4B_867632547.addTaint(taint);
                throw var73A90879EB20D8885E68D8211442ED4B_867632547;
            } 
            
            
        }

        
    }


    
    private class ECDSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.301 -0400", hash_original_method = "3D5918BC33C2E8750A0F79CF102B6DFC", hash_generated_method = "9454600B5FFF7DD0CC1E82DDDFCBAB29")
        public  ECDSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.302 -0400", hash_original_method = "C19C67ADBE6E6117AD29F18C950B281B", hash_generated_method = "27C0C7C3A7B2C46006AC4FE2C47D29DB")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
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
Object varEAE0B1873A9922293A96783FD42EB56C_912895490 =                 new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
                varEAE0B1873A9922293A96783FD42EB56C_912895490.addTaint(taint);
                return varEAE0B1873A9922293A96783FD42EB56C_912895490;
            } 
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } 
            catch (Exception e)
            {
                PEMException var7818C22FBFAD5DBAD24C042C426D3FD8_1500088694 = new PEMException(
                    "problem creating EC private key: " + e.toString(), e);
                var7818C22FBFAD5DBAD24C042C426D3FD8_1500088694.addTaint(taint);
                throw var7818C22FBFAD5DBAD24C042C426D3FD8_1500088694;
            } 
            
            
        }

        
    }


    
    private class RSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.302 -0400", hash_original_method = "77B6A791758EAFC47A0B2DE5F4E18FED", hash_generated_method = "DDA6623EB3D7AC273FEBB7D9CBACF755")
        public  RSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.303 -0400", hash_original_method = "C48B53F279450A4E2A5829BDF7A98326", hash_generated_method = "21FCFAE2BD476057E58C8B1E65520CFB")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                ASN1Sequence seq = readKeyPair(obj);
    if(seq.size() != 9)                
                {
                    PEMException varD35B5544DCEC0F2768B5D4A85981A218_166108113 = new PEMException("malformed sequence in RSA private key");
                    varD35B5544DCEC0F2768B5D4A85981A218_166108113.addTaint(taint);
                    throw varD35B5544DCEC0F2768B5D4A85981A218_166108113;
                } 
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
Object varEAE0B1873A9922293A96783FD42EB56C_900264537 =                 new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
                varEAE0B1873A9922293A96783FD42EB56C_900264537.addTaint(taint);
                return varEAE0B1873A9922293A96783FD42EB56C_900264537;
            } 
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } 
            catch (Exception e)
            {
                PEMException varFA2BBA67F244E3218E96D4A808E1DD95_381395824 = new PEMException(
                    "problem creating RSA private key: " + e.toString(), e);
                varFA2BBA67F244E3218E96D4A808E1DD95_381395824.addTaint(taint);
                throw varFA2BBA67F244E3218E96D4A808E1DD95_381395824;
            } 
            
            
        }

        
    }


    
    private class PublicKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.303 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.303 -0400", hash_original_method = "0B170982AEB3AA2304D2A6B36AB698F1", hash_generated_method = "6FEA18513C00881A82B8B19C6587D7C1")
        public  PublicKeyParser(String provider) {
            this.provider = provider;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.304 -0400", hash_original_method = "5FFFDE03CF0C93B31D80B463283D2455", hash_generated_method = "4013765C34DEB615636205EDD44AD45F")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            KeySpec keySpec = new X509EncodedKeySpec(obj.getContent());
            String[] algorithms = {"DSA", "RSA"};
for(int i = 0;i < algorithms.length;i++)
            {
                try 
                {
                    KeyFactory keyFact = KeyFactory.getInstance(algorithms[i], provider);
                    PublicKey pubKey = keyFact.generatePublic(keySpec);
Object var1AFC1D83658F9274302DC97B89F2B6FD_1211844875 =                     pubKey;
                    var1AFC1D83658F9274302DC97B89F2B6FD_1211844875.addTaint(taint);
                    return var1AFC1D83658F9274302DC97B89F2B6FD_1211844875;
                } 
                catch (NoSuchAlgorithmException e)
                {
                } 
                catch (InvalidKeySpecException e)
                {
                } 
                catch (NoSuchProviderException e)
                {
                    RuntimeException var06E4C1177140C070A53A854F6BF67B9E_1904466492 = new RuntimeException("can't find provider " + provider);
                    var06E4C1177140C070A53A854F6BF67B9E_1904466492.addTaint(taint);
                    throw var06E4C1177140C070A53A854F6BF67B9E_1904466492;
                } 
            } 
Object var540C13E9E156B687226421B24F2DF178_1094951894 =             null;
            var540C13E9E156B687226421B24F2DF178_1094951894.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1094951894;
            
            
        }

        
    }


    
    private class RSAPublicKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.304 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.304 -0400", hash_original_method = "43B57D7EBB5BEFFE4B105714BFD44A53", hash_generated_method = "84CF85625A64D3F5A7330BBE15B0C603")
        public  RSAPublicKeyParser(String provider) {
            this.provider = provider;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.305 -0400", hash_original_method = "2B7340E6F342A11B50254F4EBFCAD61E", hash_generated_method = "11FC5DF2BBD0F7E184410D510C7A07DC")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
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
Object var94012F6C458E41964D9D2A9EDC7EEEAB_187644138 =                 keyFact.generatePublic(keySpec);
                var94012F6C458E41964D9D2A9EDC7EEEAB_187644138.addTaint(taint);
                return var94012F6C458E41964D9D2A9EDC7EEEAB_187644138;
            } 
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } 
            catch (NoSuchProviderException e)
            {
                IOException var06C07CB5CCA95B2BB388BD250A1D1C79_1687204729 = new IOException("can't find provider " + provider);
                var06C07CB5CCA95B2BB388BD250A1D1C79_1687204729.addTaint(taint);
                throw var06C07CB5CCA95B2BB388BD250A1D1C79_1687204729;
            } 
            catch (Exception e)
            {
                PEMException var3A65DA81297E461EF32141452EA84422_1684038732 = new PEMException("problem extracting key: " + e.toString(), e);
                var3A65DA81297E461EF32141452EA84422_1684038732.addTaint(taint);
                throw var3A65DA81297E461EF32141452EA84422_1684038732;
            } 
            
            
        }

        
    }


    
    private class X509CertificateParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.305 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.305 -0400", hash_original_method = "A94C5E4D766266E16A102DAB21BC091D", hash_generated_method = "568E9262F1819DF68669D1C2DA0166D3")
        public  X509CertificateParser(String provider) {
            this.provider = provider;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.306 -0400", hash_original_method = "E970ED81058B7D7B34834ED92B99A71B", hash_generated_method = "854697A8035FD52D583EDD7E275221F4")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            ByteArrayInputStream bIn = new ByteArrayInputStream(obj.getContent());
            try 
            {
                CertificateFactory certFact = CertificateFactory.getInstance("X.509", provider);
Object var3EC6CBB1AD67E157BDCC0ED4E890A225_1577076581 =                 certFact.generateCertificate(bIn);
                var3EC6CBB1AD67E157BDCC0ED4E890A225_1577076581.addTaint(taint);
                return var3EC6CBB1AD67E157BDCC0ED4E890A225_1577076581;
            } 
            catch (Exception e)
            {
                PEMException varA7138674E94C4196DD2BFC018DCB434A_663591727 = new PEMException("problem parsing cert: " + e.toString(), e);
                varA7138674E94C4196DD2BFC018DCB434A_663591727.addTaint(taint);
                throw varA7138674E94C4196DD2BFC018DCB434A_663591727;
            } 
            
            
            
            
                
                    
                
            
            
            
                
            
        }

        
    }


    
    private class X509CRLParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.306 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.306 -0400", hash_original_method = "E353A700BDAAD44A8DB485E4FB446A3F", hash_generated_method = "0CF046E0608AEC29C4EF1AD8599D11E1")
        public  X509CRLParser(String provider) {
            this.provider = provider;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.307 -0400", hash_original_method = "FC6031BD5FB1B476FDF70740E2B2704D", hash_generated_method = "1B87E6BCF563F03FDE6936272570F5A1")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            ByteArrayInputStream bIn = new ByteArrayInputStream(obj.getContent());
            try 
            {
                CertificateFactory certFact = CertificateFactory.getInstance("X.509", provider);
Object var13675BEC202B29D0EFD6471DB06EE52F_349137679 =                 certFact.generateCRL(bIn);
                var13675BEC202B29D0EFD6471DB06EE52F_349137679.addTaint(taint);
                return var13675BEC202B29D0EFD6471DB06EE52F_349137679;
            } 
            catch (Exception e)
            {
                PEMException varA7138674E94C4196DD2BFC018DCB434A_1635980894 = new PEMException("problem parsing cert: " + e.toString(), e);
                varA7138674E94C4196DD2BFC018DCB434A_1635980894.addTaint(taint);
                throw varA7138674E94C4196DD2BFC018DCB434A_1635980894;
            } 
            
            
            
            
                
                    
                
            
            
            
                
            
        }

        
    }


    
    private class PKCS10CertificationRequestParser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.307 -0400", hash_original_method = "33AF8B880E8127EFE5F17F2D4C65D4F3", hash_generated_method = "33AF8B880E8127EFE5F17F2D4C65D4F3")
        public PKCS10CertificationRequestParser ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.308 -0400", hash_original_method = "CDCCA4D777F3AF625C0928D23D03AC75", hash_generated_method = "EAB38B8CA2ED629F5B46798047BAF188")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
Object varB794FF0D3385F65F500FAC6419C1B46C_1789133599 =                 new PKCS10CertificationRequest(obj.getContent());
                varB794FF0D3385F65F500FAC6419C1B46C_1789133599.addTaint(taint);
                return varB794FF0D3385F65F500FAC6419C1B46C_1789133599;
            } 
            catch (Exception e)
            {
                PEMException varA65D34D20F4675BAB153354016AA3ED6_607452215 = new PEMException("problem parsing certrequest: " + e.toString(), e);
                varA65D34D20F4675BAB153354016AA3ED6_607452215.addTaint(taint);
                throw varA65D34D20F4675BAB153354016AA3ED6_607452215;
            } 
            
            
            
                
            
            
            
                
            
        }

        
    }


    
    private class PKCS7Parser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.308 -0400", hash_original_method = "7BCD24730CEC01AC7ECF6E6CD774D6E0", hash_generated_method = "7BCD24730CEC01AC7ECF6E6CD774D6E0")
        public PKCS7Parser ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.308 -0400", hash_original_method = "349205E9CFEFFD40FE2D93E7DAF8E867", hash_generated_method = "877C8BE023F1E4423B256BA42CE16CBA")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                ASN1InputStream aIn = new ASN1InputStream(obj.getContent());
Object varF87DDC234F8DB0B9A0944ABF7DB1E9CC_2144555350 =                 ContentInfo.getInstance(aIn.readObject());
                varF87DDC234F8DB0B9A0944ABF7DB1E9CC_2144555350.addTaint(taint);
                return varF87DDC234F8DB0B9A0944ABF7DB1E9CC_2144555350;
            } 
            catch (Exception e)
            {
                PEMException varF608CD1D605CAD111A2F2B5702096743_1378251513 = new PEMException("problem parsing PKCS7 object: " + e.toString(), e);
                varF608CD1D605CAD111A2F2B5702096743_1378251513.addTaint(taint);
                throw varF608CD1D605CAD111A2F2B5702096743_1378251513;
            } 
            
            
            
                
                
            
            
            
                
            
        }

        
    }


    
    private class X509AttributeCertificateParser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.308 -0400", hash_original_method = "45D9D0D62A34F27B8FC81044406762B2", hash_generated_method = "45D9D0D62A34F27B8FC81044406762B2")
        public X509AttributeCertificateParser ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.309 -0400", hash_original_method = "C751E950E815D18D55C97B4D94E88025", hash_generated_method = "74CE5A3CB32F031EEB8C7D8F5387A502")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
Object var3F85B151310A14F674B5DCDA5ED75C7E_676932055 =             new X509V2AttributeCertificate(obj.getContent());
            var3F85B151310A14F674B5DCDA5ED75C7E_676932055.addTaint(taint);
            return var3F85B151310A14F674B5DCDA5ED75C7E_676932055;
            
            
        }

        
    }


    
    private class ECNamedCurveSpecParser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.309 -0400", hash_original_method = "6EE69FC59FA5D4825234247899DC0928", hash_generated_method = "6EE69FC59FA5D4825234247899DC0928")
        public ECNamedCurveSpecParser ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.309 -0400", hash_original_method = "76529322BBA013222CE8C144A2985A3B", hash_generated_method = "A921F220C91AA84E218D2EBA10023A7E")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                DERObjectIdentifier oid = (DERObjectIdentifier)ASN1Object.fromByteArray(obj.getContent());
                Object params = ECNamedCurveTable.getParameterSpec(oid.getId());
    if(params == null)                
                {
                    IOException var87F20EEB43CF33054FED1AD546747571_14345686 = new IOException("object ID not found in EC curve table");
                    var87F20EEB43CF33054FED1AD546747571_14345686.addTaint(taint);
                    throw var87F20EEB43CF33054FED1AD546747571_14345686;
                } 
Object varD15CEB6F45B18F7EB233792D020C6115_1468747024 =                 params;
                varD15CEB6F45B18F7EB233792D020C6115_1468747024.addTaint(taint);
                return varD15CEB6F45B18F7EB233792D020C6115_1468747024;
            } 
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } 
            catch (Exception e)
            {
                PEMException var803B5A55ABF2064F29EB5D223301A05E_2123412100 = new PEMException("exception extracting EC named curve: " + e.toString());
                var803B5A55ABF2064F29EB5D223301A05E_2123412100.addTaint(taint);
                throw var803B5A55ABF2064F29EB5D223301A05E_2123412100;
            } 
            
            
            
                
                
                
                
                    
                
                
            
            
            
                
            
            
            
                
            
        }

        
    }


    
    private class EncryptedPrivateKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.310 -0400", hash_original_field = "4EACA8834A05AB66E18F6DFB559CED3E", hash_generated_field = "7250E15B2C636F0751D5B7C0DD47B256")

        private String symProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.310 -0400", hash_original_field = "CCA8F5193CBB2A08D508AA8F4F55F412", hash_generated_field = "0F549A2B688E81487E68FB3369A216E4")

        private String asymProvider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.310 -0400", hash_original_method = "E8D8629FC61D2C1E41CC63DCCA2261A4", hash_generated_method = "9E67816548B159C198D0387C48F7FAEF")
        public  EncryptedPrivateKeyParser(String symProvider, String asymProvider) {
            this.symProvider = symProvider;
            this.asymProvider = asymProvider;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.311 -0400", hash_original_method = "B158B358DBE9E580DC539CC61ABD0BEA", hash_generated_method = "B6C109072297424BCC077BDD73E2D99B")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                EncryptedPrivateKeyInfo info = EncryptedPrivateKeyInfo.getInstance(ASN1Object.fromByteArray(obj.getContent()));
                AlgorithmIdentifier algId = info.getEncryptionAlgorithm();
    if(pFinder == null)                
                {
                    PEMException var7032D0EE8B06618A4D668D31B1ADCE99_1424619845 = new PEMException("no PasswordFinder specified");
                    var7032D0EE8B06618A4D668D31B1ADCE99_1424619845.addTaint(taint);
                    throw var7032D0EE8B06618A4D668D31B1ADCE99_1424619845;
                } 
    if(PEMUtilities.isPKCS5Scheme2(algId.getAlgorithm()))                
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
Object varE1F9B715DB83CAAF9524B7CFB020968C_881175909 =                     keyFact.generatePrivate(keySpec);
                    varE1F9B715DB83CAAF9524B7CFB020968C_881175909.addTaint(taint);
                    return varE1F9B715DB83CAAF9524B7CFB020968C_881175909;
                } 
                else
    if(PEMUtilities.isPKCS12(algId.getAlgorithm()))                
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
Object varE1F9B715DB83CAAF9524B7CFB020968C_1566622641 =                     keyFact.generatePrivate(keySpec);
                    varE1F9B715DB83CAAF9524B7CFB020968C_1566622641.addTaint(taint);
                    return varE1F9B715DB83CAAF9524B7CFB020968C_1566622641;
                } 
                else
    if(PEMUtilities.isPKCS5Scheme1(algId.getAlgorithm()))                
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
Object varE1F9B715DB83CAAF9524B7CFB020968C_156440620 =                     keyFact.generatePrivate(keySpec);
                    varE1F9B715DB83CAAF9524B7CFB020968C_156440620.addTaint(taint);
                    return varE1F9B715DB83CAAF9524B7CFB020968C_156440620;
                } 
                else
                {
                    PEMException var4685040ECFE3A1A694DDE8DF71645E3D_1126049577 = new PEMException("Unknown algorithm: " + algId.getAlgorithm());
                    var4685040ECFE3A1A694DDE8DF71645E3D_1126049577.addTaint(taint);
                    throw var4685040ECFE3A1A694DDE8DF71645E3D_1126049577;
                } 
            } 
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } 
            catch (Exception e)
            {
                PEMException var7994463B2C9D40477BDBCFCE7AC1BFB9_2012372225 = new PEMException("problem parsing ENCRYPTED PRIVATE KEY: " + e.toString(), e);
                var7994463B2C9D40477BDBCFCE7AC1BFB9_2012372225.addTaint(taint);
                throw var7994463B2C9D40477BDBCFCE7AC1BFB9_2012372225;
            } 
            
            
        }

        
    }


    
    private class PrivateKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.312 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.312 -0400", hash_original_method = "0877761703B26434F32E47C53A29AE74", hash_generated_method = "15BF9532DC3933BF57B695673E62B835")
        public  PrivateKeyParser(String provider) {
            this.provider = provider;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.312 -0400", hash_original_method = "2553B1C8B63939D2139C3EAA36C566E7", hash_generated_method = "93BC94CC5050C087C000C58CE983C042")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                PrivateKeyInfo info = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(obj.getContent()));
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(obj.getContent());
                KeyFactory keyFact = KeyFactory.getInstance(info.getAlgorithmId().getAlgorithm().getId(), provider);
Object varE1F9B715DB83CAAF9524B7CFB020968C_698369501 =                 keyFact.generatePrivate(keySpec);
                varE1F9B715DB83CAAF9524B7CFB020968C_698369501.addTaint(taint);
                return varE1F9B715DB83CAAF9524B7CFB020968C_698369501;
            } 
            catch (Exception e)
            {
                PEMException var4A1EFFF69C98A3BD87AA816E3B244482_458422107 = new PEMException("problem parsing PRIVATE KEY: " + e.toString(), e);
                var4A1EFFF69C98A3BD87AA816E3B244482_458422107.addTaint(taint);
                throw var4A1EFFF69C98A3BD87AA816E3B244482_458422107;
            } 
            
            
            
                
                
                
                
            
            
            
                
            
        }

        
    }


    
}

