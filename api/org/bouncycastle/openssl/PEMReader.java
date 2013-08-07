package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.062 -0400", hash_original_field = "DFAA5B65B87CDDE1589034B535B31A0A", hash_generated_field = "1B324848B9CCB600B6F9F412146CB5D6")

    private final Map parsers = new HashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.062 -0400", hash_original_field = "5CD9C2E7D64B912B29078A3E35C28F5E", hash_generated_field = "7A318D1FC589B8A927004A5BBE837049")

    private PasswordFinder pFinder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.063 -0400", hash_original_method = "2732903E834E35077990228D3EC5372C", hash_generated_method = "9D0E243820E7950FE695D0C348CB2B9F")
    public  PEMReader(
        Reader reader) {
        this(reader, null, "BC");
        addTaint(reader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.063 -0400", hash_original_method = "264D7373D1280C46B7B3C63F3DA0F057", hash_generated_method = "705B33BAACE1A8A98B2560263763B8D5")
    public  PEMReader(
        Reader reader,
        PasswordFinder pFinder) {
        this(reader, pFinder, "BC");
        addTaint(pFinder.getTaint());
        addTaint(reader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.063 -0400", hash_original_method = "F26FB5757482F756B15ADBECFFA22920", hash_generated_method = "0168B3B6DCC204D41581A4E4A23DEF2E")
    public  PEMReader(
        Reader reader,
        PasswordFinder pFinder,
        String provider) {
        this(reader, pFinder, provider, provider);
        addTaint(provider.getTaint());
        addTaint(pFinder.getTaint());
        addTaint(reader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.064 -0400", hash_original_method = "CEFEBB919AD354EB1A0A7FBF2E2E3ECF", hash_generated_method = "DB91BC49650093E23DF34F596B13748D")
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.065 -0400", hash_original_method = "127E22226D67F5F9289AA2863D2E5AFD", hash_generated_method = "B6937B370CAF564D03458A1EF8C893E2")
    public Object readObject() throws IOException {
        PemObject obj = readPemObject();
        if(obj != null)        
        {
            String type = obj.getType();
            if(parsers.containsKey(type))            
            {
Object var3A81707C91CA6721ECEB781CDBC013C2_1133551358 =                 ((PemObjectParser)parsers.get(type)).parseObject(obj);
                var3A81707C91CA6721ECEB781CDBC013C2_1133551358.addTaint(taint);
                return var3A81707C91CA6721ECEB781CDBC013C2_1133551358;
            } //End block
            else
            {
                IOException var70A619DCC02CED381329A437D633B59D_601715278 = new IOException("unrecognised object: " + type);
                var70A619DCC02CED381329A437D633B59D_601715278.addTaint(taint);
                throw var70A619DCC02CED381329A437D633B59D_601715278;
            } //End block
        } //End block
Object var540C13E9E156B687226421B24F2DF178_620129068 =         null;
        var540C13E9E156B687226421B24F2DF178_620129068.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_620129068;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.065 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "AFDE0FC943DF429CC56BE81349BC4014")

        protected String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.066 -0400", hash_original_method = "D97A7462FC5E95C470F1E84C9A4F9D7B", hash_generated_method = "AEB043DD3F85D4A6336E5753ECB334C0")
        public  KeyPairParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.066 -0400", hash_original_method = "D2B938CFC8BBB876E5EB510A00C9CCB3", hash_generated_method = "A3DBB722D66ADF3E690A0F5932387A7D")
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
                } //End block
                else
                if(hdr.getName().equals("DEK-Info"))                
                {
                    dekInfo = hdr.getValue();
                } //End block
            } //End block
            byte[] keyBytes = obj.getContent();
            if(isEncrypted)            
            {
                if(pFinder == null)                
                {
                    PasswordException var91FF4DCF86A2042EE65FD11154EAEAB6_1236066786 = new PasswordException("No password finder specified, but a password is required");
                    var91FF4DCF86A2042EE65FD11154EAEAB6_1236066786.addTaint(taint);
                    throw var91FF4DCF86A2042EE65FD11154EAEAB6_1236066786;
                } //End block
                char[] password = pFinder.getPassword();
                if(password == null)                
                {
                    PasswordException var72B5E4C3645EE62C98877BEE4FA7A205_726450289 = new PasswordException("Password is null, but a password is required");
                    var72B5E4C3645EE62C98877BEE4FA7A205_726450289.addTaint(taint);
                    throw var72B5E4C3645EE62C98877BEE4FA7A205_726450289;
                } //End block
                StringTokenizer tknz = new StringTokenizer(dekInfo, ",");
                String dekAlgName = tknz.nextToken();
                byte[] iv = Hex.decode(tknz.nextToken());
                keyBytes = PEMUtilities.crypt(false, provider, keyBytes, password, dekAlgName, iv);
            } //End block
            try 
            {
ASN1Sequence var2E579F18C8B32DEE34ED2B653450B91E_1310034899 =                 (ASN1Sequence)ASN1Object.fromByteArray(keyBytes);
                var2E579F18C8B32DEE34ED2B653450B91E_1310034899.addTaint(taint);
                return var2E579F18C8B32DEE34ED2B653450B91E_1310034899;
            } //End block
            catch (IOException e)
            {
                if(isEncrypted)                
                {
                    PEMException var23ADDE189C9D3294BE4E23AAC9C6C524_1589437169 = new PEMException("exception decoding - please check password and data.", e);
                    var23ADDE189C9D3294BE4E23AAC9C6C524_1589437169.addTaint(taint);
                    throw var23ADDE189C9D3294BE4E23AAC9C6C524_1589437169;
                } //End block
                else
                {
                    PEMException var0E2F75B091E2B3678FDBDFC9DA487A03_1637481497 = new PEMException(e.getMessage(), e);
                    var0E2F75B091E2B3678FDBDFC9DA487A03_1637481497.addTaint(taint);
                    throw var0E2F75B091E2B3678FDBDFC9DA487A03_1637481497;
                } //End block
            } //End block
            catch (ClassCastException e)
            {
                if(isEncrypted)                
                {
                    PEMException var23ADDE189C9D3294BE4E23AAC9C6C524_1153840104 = new PEMException("exception decoding - please check password and data.", e);
                    var23ADDE189C9D3294BE4E23AAC9C6C524_1153840104.addTaint(taint);
                    throw var23ADDE189C9D3294BE4E23AAC9C6C524_1153840104;
                } //End block
                else
                {
                    PEMException var0E2F75B091E2B3678FDBDFC9DA487A03_1862695731 = new PEMException(e.getMessage(), e);
                    var0E2F75B091E2B3678FDBDFC9DA487A03_1862695731.addTaint(taint);
                    throw var0E2F75B091E2B3678FDBDFC9DA487A03_1862695731;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.067 -0400", hash_original_method = "ADBD617F929757840A0FD32FA3C710F1", hash_generated_method = "98E9B2A9DBB6C5434EE239E1D433E12C")
        public  DSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.068 -0400", hash_original_method = "ADE2E96FAD316F0BCF76F4FEB2795A67", hash_generated_method = "8EEAE4CD9EDB32FF9A9663D600668A7B")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                ASN1Sequence seq = readKeyPair(obj);
                if(seq.size() != 6)                
                {
                    PEMException varEE7D65505957B3E6B6E02FD39B74044F_680972523 = new PEMException("malformed sequence in DSA private key");
                    varEE7D65505957B3E6B6E02FD39B74044F_680972523.addTaint(taint);
                    throw varEE7D65505957B3E6B6E02FD39B74044F_680972523;
                } //End block
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
Object varEAE0B1873A9922293A96783FD42EB56C_49954851 =                 new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
                varEAE0B1873A9922293A96783FD42EB56C_49954851.addTaint(taint);
                return varEAE0B1873A9922293A96783FD42EB56C_49954851;
            } //End block
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } //End block
            catch (Exception e)
            {
                PEMException var73A90879EB20D8885E68D8211442ED4B_1993840527 = new PEMException(
                    "problem creating DSA private key: " + e.toString(), e);
                var73A90879EB20D8885E68D8211442ED4B_1993840527.addTaint(taint);
                throw var73A90879EB20D8885E68D8211442ED4B_1993840527;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class ECDSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.068 -0400", hash_original_method = "3D5918BC33C2E8750A0F79CF102B6DFC", hash_generated_method = "9454600B5FFF7DD0CC1E82DDDFCBAB29")
        public  ECDSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.069 -0400", hash_original_method = "C19C67ADBE6E6117AD29F18C950B281B", hash_generated_method = "61C9A8506EEF6890DA67120A6E023008")
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
Object varEAE0B1873A9922293A96783FD42EB56C_1782388867 =                 new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
                varEAE0B1873A9922293A96783FD42EB56C_1782388867.addTaint(taint);
                return varEAE0B1873A9922293A96783FD42EB56C_1782388867;
            } //End block
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } //End block
            catch (Exception e)
            {
                PEMException var7818C22FBFAD5DBAD24C042C426D3FD8_962719357 = new PEMException(
                    "problem creating EC private key: " + e.toString(), e);
                var7818C22FBFAD5DBAD24C042C426D3FD8_962719357.addTaint(taint);
                throw var7818C22FBFAD5DBAD24C042C426D3FD8_962719357;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class RSAKeyPairParser extends KeyPairParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.069 -0400", hash_original_method = "77B6A791758EAFC47A0B2DE5F4E18FED", hash_generated_method = "DDA6623EB3D7AC273FEBB7D9CBACF755")
        public  RSAKeyPairParser(String provider) {
            super(provider);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.070 -0400", hash_original_method = "C48B53F279450A4E2A5829BDF7A98326", hash_generated_method = "55AC1E1EB0702224B0BA9CBCF41409E5")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                ASN1Sequence seq = readKeyPair(obj);
                if(seq.size() != 9)                
                {
                    PEMException varD35B5544DCEC0F2768B5D4A85981A218_1388846951 = new PEMException("malformed sequence in RSA private key");
                    varD35B5544DCEC0F2768B5D4A85981A218_1388846951.addTaint(taint);
                    throw varD35B5544DCEC0F2768B5D4A85981A218_1388846951;
                } //End block
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
Object varEAE0B1873A9922293A96783FD42EB56C_984859776 =                 new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
                varEAE0B1873A9922293A96783FD42EB56C_984859776.addTaint(taint);
                return varEAE0B1873A9922293A96783FD42EB56C_984859776;
            } //End block
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } //End block
            catch (Exception e)
            {
                PEMException varFA2BBA67F244E3218E96D4A808E1DD95_1482632208 = new PEMException(
                    "problem creating RSA private key: " + e.toString(), e);
                varFA2BBA67F244E3218E96D4A808E1DD95_1482632208.addTaint(taint);
                throw varFA2BBA67F244E3218E96D4A808E1DD95_1482632208;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class PublicKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.070 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.071 -0400", hash_original_method = "0B170982AEB3AA2304D2A6B36AB698F1", hash_generated_method = "6FEA18513C00881A82B8B19C6587D7C1")
        public  PublicKeyParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.071 -0400", hash_original_method = "5FFFDE03CF0C93B31D80B463283D2455", hash_generated_method = "77C800E576CDED1194DFB0B0FBEBA794")
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
Object var1AFC1D83658F9274302DC97B89F2B6FD_1589611610 =                     pubKey;
                    var1AFC1D83658F9274302DC97B89F2B6FD_1589611610.addTaint(taint);
                    return var1AFC1D83658F9274302DC97B89F2B6FD_1589611610;
                } //End block
                catch (NoSuchAlgorithmException e)
                {
                } //End block
                catch (InvalidKeySpecException e)
                {
                } //End block
                catch (NoSuchProviderException e)
                {
                    RuntimeException var06E4C1177140C070A53A854F6BF67B9E_785148214 = new RuntimeException("can't find provider " + provider);
                    var06E4C1177140C070A53A854F6BF67B9E_785148214.addTaint(taint);
                    throw var06E4C1177140C070A53A854F6BF67B9E_785148214;
                } //End block
            } //End block
Object var540C13E9E156B687226421B24F2DF178_569905279 =             null;
            var540C13E9E156B687226421B24F2DF178_569905279.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_569905279;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class RSAPublicKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.071 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.072 -0400", hash_original_method = "43B57D7EBB5BEFFE4B105714BFD44A53", hash_generated_method = "84CF85625A64D3F5A7330BBE15B0C603")
        public  RSAPublicKeyParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.072 -0400", hash_original_method = "2B7340E6F342A11B50254F4EBFCAD61E", hash_generated_method = "5143A3D4D2CD6E3AA344D2CE79690CD0")
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
Object var94012F6C458E41964D9D2A9EDC7EEEAB_220062019 =                 keyFact.generatePublic(keySpec);
                var94012F6C458E41964D9D2A9EDC7EEEAB_220062019.addTaint(taint);
                return var94012F6C458E41964D9D2A9EDC7EEEAB_220062019;
            } //End block
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } //End block
            catch (NoSuchProviderException e)
            {
                IOException var06C07CB5CCA95B2BB388BD250A1D1C79_1368664980 = new IOException("can't find provider " + provider);
                var06C07CB5CCA95B2BB388BD250A1D1C79_1368664980.addTaint(taint);
                throw var06C07CB5CCA95B2BB388BD250A1D1C79_1368664980;
            } //End block
            catch (Exception e)
            {
                PEMException var3A65DA81297E461EF32141452EA84422_1157766241 = new PEMException("problem extracting key: " + e.toString(), e);
                var3A65DA81297E461EF32141452EA84422_1157766241.addTaint(taint);
                throw var3A65DA81297E461EF32141452EA84422_1157766241;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class X509CertificateParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.072 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.073 -0400", hash_original_method = "A94C5E4D766266E16A102DAB21BC091D", hash_generated_method = "568E9262F1819DF68669D1C2DA0166D3")
        public  X509CertificateParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.073 -0400", hash_original_method = "E970ED81058B7D7B34834ED92B99A71B", hash_generated_method = "8879BBA40A5296B8F7D90FCE0797AEE2")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            ByteArrayInputStream bIn = new ByteArrayInputStream(obj.getContent());
            try 
            {
                CertificateFactory certFact = CertificateFactory.getInstance("X.509", provider);
Object var3EC6CBB1AD67E157BDCC0ED4E890A225_1433313601 =                 certFact.generateCertificate(bIn);
                var3EC6CBB1AD67E157BDCC0ED4E890A225_1433313601.addTaint(taint);
                return var3EC6CBB1AD67E157BDCC0ED4E890A225_1433313601;
            } //End block
            catch (Exception e)
            {
                PEMException varA7138674E94C4196DD2BFC018DCB434A_494581697 = new PEMException("problem parsing cert: " + e.toString(), e);
                varA7138674E94C4196DD2BFC018DCB434A_494581697.addTaint(taint);
                throw varA7138674E94C4196DD2BFC018DCB434A_494581697;
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.074 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.074 -0400", hash_original_method = "E353A700BDAAD44A8DB485E4FB446A3F", hash_generated_method = "0CF046E0608AEC29C4EF1AD8599D11E1")
        public  X509CRLParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.074 -0400", hash_original_method = "FC6031BD5FB1B476FDF70740E2B2704D", hash_generated_method = "3348AC59C4576ECBBD3848BC467CAF4E")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            ByteArrayInputStream bIn = new ByteArrayInputStream(obj.getContent());
            try 
            {
                CertificateFactory certFact = CertificateFactory.getInstance("X.509", provider);
Object var13675BEC202B29D0EFD6471DB06EE52F_802225166 =                 certFact.generateCRL(bIn);
                var13675BEC202B29D0EFD6471DB06EE52F_802225166.addTaint(taint);
                return var13675BEC202B29D0EFD6471DB06EE52F_802225166;
            } //End block
            catch (Exception e)
            {
                PEMException varA7138674E94C4196DD2BFC018DCB434A_300252603 = new PEMException("problem parsing cert: " + e.toString(), e);
                varA7138674E94C4196DD2BFC018DCB434A_300252603.addTaint(taint);
                throw varA7138674E94C4196DD2BFC018DCB434A_300252603;
            } //End block
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.075 -0400", hash_original_method = "33AF8B880E8127EFE5F17F2D4C65D4F3", hash_generated_method = "33AF8B880E8127EFE5F17F2D4C65D4F3")
        public PKCS10CertificationRequestParser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.075 -0400", hash_original_method = "CDCCA4D777F3AF625C0928D23D03AC75", hash_generated_method = "CCB2E4B2667CF51FCBA2FFA66609034E")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
Object varB794FF0D3385F65F500FAC6419C1B46C_642344932 =                 new PKCS10CertificationRequest(obj.getContent());
                varB794FF0D3385F65F500FAC6419C1B46C_642344932.addTaint(taint);
                return varB794FF0D3385F65F500FAC6419C1B46C_642344932;
            } //End block
            catch (Exception e)
            {
                PEMException varA65D34D20F4675BAB153354016AA3ED6_1830547338 = new PEMException("problem parsing certrequest: " + e.toString(), e);
                varA65D34D20F4675BAB153354016AA3ED6_1830547338.addTaint(taint);
                throw varA65D34D20F4675BAB153354016AA3ED6_1830547338;
            } //End block
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.075 -0400", hash_original_method = "7BCD24730CEC01AC7ECF6E6CD774D6E0", hash_generated_method = "7BCD24730CEC01AC7ECF6E6CD774D6E0")
        public PKCS7Parser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.076 -0400", hash_original_method = "349205E9CFEFFD40FE2D93E7DAF8E867", hash_generated_method = "EC14FD8B25222FC3BC4FDFA740CF0EDA")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                ASN1InputStream aIn = new ASN1InputStream(obj.getContent());
Object varF87DDC234F8DB0B9A0944ABF7DB1E9CC_1670992535 =                 ContentInfo.getInstance(aIn.readObject());
                varF87DDC234F8DB0B9A0944ABF7DB1E9CC_1670992535.addTaint(taint);
                return varF87DDC234F8DB0B9A0944ABF7DB1E9CC_1670992535;
            } //End block
            catch (Exception e)
            {
                PEMException varF608CD1D605CAD111A2F2B5702096743_16154699 = new PEMException("problem parsing PKCS7 object: " + e.toString(), e);
                varF608CD1D605CAD111A2F2B5702096743_16154699.addTaint(taint);
                throw varF608CD1D605CAD111A2F2B5702096743_16154699;
            } //End block
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.076 -0400", hash_original_method = "45D9D0D62A34F27B8FC81044406762B2", hash_generated_method = "45D9D0D62A34F27B8FC81044406762B2")
        public X509AttributeCertificateParser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.077 -0400", hash_original_method = "C751E950E815D18D55C97B4D94E88025", hash_generated_method = "61A65A3220887DEA6A05165F0D10C99F")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
Object var3F85B151310A14F674B5DCDA5ED75C7E_1725220575 =             new X509V2AttributeCertificate(obj.getContent());
            var3F85B151310A14F674B5DCDA5ED75C7E_1725220575.addTaint(taint);
            return var3F85B151310A14F674B5DCDA5ED75C7E_1725220575;
            // ---------- Original Method ----------
            //return new X509V2AttributeCertificate(obj.getContent());
        }

        
    }


    
    private class ECNamedCurveSpecParser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.077 -0400", hash_original_method = "6EE69FC59FA5D4825234247899DC0928", hash_generated_method = "6EE69FC59FA5D4825234247899DC0928")
        public ECNamedCurveSpecParser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.078 -0400", hash_original_method = "76529322BBA013222CE8C144A2985A3B", hash_generated_method = "762A806346F0C56BF89D91D929111A81")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                DERObjectIdentifier oid = (DERObjectIdentifier)ASN1Object.fromByteArray(obj.getContent());
                Object params = ECNamedCurveTable.getParameterSpec(oid.getId());
                if(params == null)                
                {
                    IOException var87F20EEB43CF33054FED1AD546747571_1976733733 = new IOException("object ID not found in EC curve table");
                    var87F20EEB43CF33054FED1AD546747571_1976733733.addTaint(taint);
                    throw var87F20EEB43CF33054FED1AD546747571_1976733733;
                } //End block
Object varD15CEB6F45B18F7EB233792D020C6115_720597052 =                 params;
                varD15CEB6F45B18F7EB233792D020C6115_720597052.addTaint(taint);
                return varD15CEB6F45B18F7EB233792D020C6115_720597052;
            } //End block
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } //End block
            catch (Exception e)
            {
                PEMException var803B5A55ABF2064F29EB5D223301A05E_673567740 = new PEMException("exception extracting EC named curve: " + e.toString());
                var803B5A55ABF2064F29EB5D223301A05E_673567740.addTaint(taint);
                throw var803B5A55ABF2064F29EB5D223301A05E_673567740;
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.078 -0400", hash_original_field = "4EACA8834A05AB66E18F6DFB559CED3E", hash_generated_field = "7250E15B2C636F0751D5B7C0DD47B256")

        private String symProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.078 -0400", hash_original_field = "CCA8F5193CBB2A08D508AA8F4F55F412", hash_generated_field = "0F549A2B688E81487E68FB3369A216E4")

        private String asymProvider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.079 -0400", hash_original_method = "E8D8629FC61D2C1E41CC63DCCA2261A4", hash_generated_method = "9E67816548B159C198D0387C48F7FAEF")
        public  EncryptedPrivateKeyParser(String symProvider, String asymProvider) {
            this.symProvider = symProvider;
            this.asymProvider = asymProvider;
            // ---------- Original Method ----------
            //this.symProvider = symProvider;
            //this.asymProvider = asymProvider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.082 -0400", hash_original_method = "B158B358DBE9E580DC539CC61ABD0BEA", hash_generated_method = "0820EC74CE0885A88FCA24C75D7C94BB")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                EncryptedPrivateKeyInfo info = EncryptedPrivateKeyInfo.getInstance(ASN1Object.fromByteArray(obj.getContent()));
                AlgorithmIdentifier algId = info.getEncryptionAlgorithm();
                if(pFinder == null)                
                {
                    PEMException var7032D0EE8B06618A4D668D31B1ADCE99_962650425 = new PEMException("no PasswordFinder specified");
                    var7032D0EE8B06618A4D668D31B1ADCE99_962650425.addTaint(taint);
                    throw var7032D0EE8B06618A4D668D31B1ADCE99_962650425;
                } //End block
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
Object varE1F9B715DB83CAAF9524B7CFB020968C_151698393 =                     keyFact.generatePrivate(keySpec);
                    varE1F9B715DB83CAAF9524B7CFB020968C_151698393.addTaint(taint);
                    return varE1F9B715DB83CAAF9524B7CFB020968C_151698393;
                } //End block
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
Object varE1F9B715DB83CAAF9524B7CFB020968C_1269220278 =                     keyFact.generatePrivate(keySpec);
                    varE1F9B715DB83CAAF9524B7CFB020968C_1269220278.addTaint(taint);
                    return varE1F9B715DB83CAAF9524B7CFB020968C_1269220278;
                } //End block
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
Object varE1F9B715DB83CAAF9524B7CFB020968C_108232674 =                     keyFact.generatePrivate(keySpec);
                    varE1F9B715DB83CAAF9524B7CFB020968C_108232674.addTaint(taint);
                    return varE1F9B715DB83CAAF9524B7CFB020968C_108232674;
                } //End block
                else
                {
                    PEMException var4685040ECFE3A1A694DDE8DF71645E3D_448902844 = new PEMException("Unknown algorithm: " + algId.getAlgorithm());
                    var4685040ECFE3A1A694DDE8DF71645E3D_448902844.addTaint(taint);
                    throw var4685040ECFE3A1A694DDE8DF71645E3D_448902844;
                } //End block
            } //End block
            catch (IOException e)
            {
                e.addTaint(taint);
                throw e;
            } //End block
            catch (Exception e)
            {
                PEMException var7994463B2C9D40477BDBCFCE7AC1BFB9_14747951 = new PEMException("problem parsing ENCRYPTED PRIVATE KEY: " + e.toString(), e);
                var7994463B2C9D40477BDBCFCE7AC1BFB9_14747951.addTaint(taint);
                throw var7994463B2C9D40477BDBCFCE7AC1BFB9_14747951;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class PrivateKeyParser implements PemObjectParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.083 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.084 -0400", hash_original_method = "0877761703B26434F32E47C53A29AE74", hash_generated_method = "15BF9532DC3933BF57B695673E62B835")
        public  PrivateKeyParser(String provider) {
            this.provider = provider;
            // ---------- Original Method ----------
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.085 -0400", hash_original_method = "2553B1C8B63939D2139C3EAA36C566E7", hash_generated_method = "B4061E09CB146B2320CD6A721192A8E0")
        public Object parseObject(PemObject obj) throws IOException {
            addTaint(obj.getTaint());
            try 
            {
                PrivateKeyInfo info = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(obj.getContent()));
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(obj.getContent());
                KeyFactory keyFact = KeyFactory.getInstance(info.getAlgorithmId().getAlgorithm().getId(), provider);
Object varE1F9B715DB83CAAF9524B7CFB020968C_506524753 =                 keyFact.generatePrivate(keySpec);
                varE1F9B715DB83CAAF9524B7CFB020968C_506524753.addTaint(taint);
                return varE1F9B715DB83CAAF9524B7CFB020968C_506524753;
            } //End block
            catch (Exception e)
            {
                PEMException var4A1EFFF69C98A3BD87AA816E3B244482_1385350636 = new PEMException("problem parsing PRIVATE KEY: " + e.toString(), e);
                var4A1EFFF69C98A3BD87AA816E3B244482_1385350636.addTaint(taint);
                throw var4A1EFFF69C98A3BD87AA816E3B244482_1385350636;
            } //End block
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

