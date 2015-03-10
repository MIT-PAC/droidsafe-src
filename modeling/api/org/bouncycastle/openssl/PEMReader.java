/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.361 -0500", hash_original_field = "9B1CD2D518DEAD091777D6CB81C5816E", hash_generated_field = "1B324848B9CCB600B6F9F412146CB5D6")

    private final Map parsers = new HashMap();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.363 -0500", hash_original_field = "75C5E5F13C2720237139D3675B80F4E6", hash_generated_field = "7A318D1FC589B8A927004A5BBE837049")

    private PasswordFinder pFinder;

    /**
     * Create a new PEMReader
     *
     * @param reader the Reader
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.366 -0500", hash_original_method = "2732903E834E35077990228D3EC5372C", hash_generated_method = "874B62147D53C021C6F32B5DF2CF4549")
    
public PEMReader(
        Reader reader)
    {
        this(reader, null, "BC");
    }

    /**
     * Create a new PEMReader with a password finder
     *
     * @param reader  the Reader
     * @param pFinder the password finder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.369 -0500", hash_original_method = "264D7373D1280C46B7B3C63F3DA0F057", hash_generated_method = "0BBF51B5D4A1AFD777DF9DF211414B13")
    
public PEMReader(
        Reader reader,
        PasswordFinder pFinder)
    {
        this(reader, pFinder, "BC");
    }

    /**
     * Create a new PEMReader with a password finder
     *
     * @param reader   the Reader
     * @param pFinder  the password finder
     * @param provider the cryptography provider to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.371 -0500", hash_original_method = "F26FB5757482F756B15ADBECFFA22920", hash_generated_method = "866E2D88D33729E33FBF0566E77B7956")
    
public PEMReader(
        Reader reader,
        PasswordFinder pFinder,
        String provider)
    {
        this(reader, pFinder, provider, provider);
    }

    /**
     * Create a new PEMReader with a password finder and differing providers for secret and public key
     * operations.
     *
     * @param reader   the Reader
     * @param pFinder  the password finder
     * @param symProvider  provider to use for symmetric operations
     * @param asymProvider provider to use for asymmetric (public/private key) operations
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.374 -0500", hash_original_method = "CEFEBB919AD354EB1A0A7FBF2E2E3ECF", hash_generated_method = "1D6284387BD85B0E08A4B494D5BEC91A")
    
public PEMReader(
        Reader reader,
        PasswordFinder pFinder,
        String symProvider,
        String asymProvider)
    {
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.377 -0500", hash_original_method = "127E22226D67F5F9289AA2863D2E5AFD", hash_generated_method = "E7B4598E68D943668CA5499F2933BCA8")
    
public Object readObject()
        throws IOException
    {
        PemObject obj = readPemObject();

        if (obj != null)
        {
            String type = obj.getType();
            if (parsers.containsKey(type))
            {
                return ((PemObjectParser)parsers.get(type)).parseObject(obj);
            }
            else
            {
                throw new IOException("unrecognised object: " + type);
            }
        }

        return null;
    }
    
    private abstract class KeyPairParser implements PemObjectParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.380 -0500", hash_original_field = "A5A1D795BB0E6A860404CE54547A2FCF", hash_generated_field = "AFDE0FC943DF429CC56BE81349BC4014")

        protected String provider;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.383 -0500", hash_original_method = "D97A7462FC5E95C470F1E84C9A4F9D7B", hash_generated_method = "F8C46D382714D6BC9EE642A403775A5A")
        
public KeyPairParser(String provider)
        {
            this.provider = provider;
        }

        /**
         * Read a Key Pair
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.387 -0500", hash_original_method = "D2B938CFC8BBB876E5EB510A00C9CCB3", hash_generated_method = "424654138E7F0D121A69909EF97DBEFA")
        
protected ASN1Sequence readKeyPair(
            PemObject obj)
            throws IOException
        {
            boolean isEncrypted = false;
            String dekInfo = null;
            List headers = obj.getHeaders();

            for (Iterator it = headers.iterator(); it.hasNext();)
            {
                PemHeader hdr = (PemHeader)it.next();

                if (hdr.getName().equals("Proc-Type") && hdr.getValue().equals("4,ENCRYPTED"))
                {
                    isEncrypted = true;
                }
                else if (hdr.getName().equals("DEK-Info"))
                {
                    dekInfo = hdr.getValue();
                }
            }

            //
            // extract the key
            //
            byte[] keyBytes = obj.getContent();

            if (isEncrypted)
            {
                if (pFinder == null)
                {
                    throw new PasswordException("No password finder specified, but a password is required");
                }

                char[] password = pFinder.getPassword();

                if (password == null)
                {
                    throw new PasswordException("Password is null, but a password is required");
                }

                StringTokenizer tknz = new StringTokenizer(dekInfo, ",");
                String dekAlgName = tknz.nextToken();
                byte[] iv = Hex.decode(tknz.nextToken());

                keyBytes = PEMUtilities.crypt(false, provider, keyBytes, password, dekAlgName, iv);
            }

            try
            {
                return (ASN1Sequence)ASN1Object.fromByteArray(keyBytes);
            }
            catch (IOException e)
            {
                if (isEncrypted)
                {
                    throw new PEMException("exception decoding - please check password and data.", e);
                }
                else
                {
                    throw new PEMException(e.getMessage(), e);
                }
            }
            catch (ClassCastException e)
            {
                if (isEncrypted)
                {
                    throw new PEMException("exception decoding - please check password and data.", e);
                }
                else
                {
                    throw new PEMException(e.getMessage(), e);
                }
            }
        }
        
    }
    
    private class DSAKeyPairParser extends KeyPairParser {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.392 -0500", hash_original_method = "ADBD617F929757840A0FD32FA3C710F1", hash_generated_method = "5DE1123A8D868D13C61FFB66BA6883C1")
        
public DSAKeyPairParser(String provider)
        {
            super(provider);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.395 -0500", hash_original_method = "ADE2E96FAD316F0BCF76F4FEB2795A67", hash_generated_method = "487B04015C51652D46919394D99D2075")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
            try
            {
                ASN1Sequence seq = readKeyPair(obj);

                if (seq.size() != 6)
                {
                    throw new PEMException("malformed sequence in DSA private key");
                }

                //            DERInteger              v = (DERInteger)seq.getObjectAt(0);
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

                return new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
            }
            catch (IOException e)
            {
                throw e;
            }
            catch (Exception e)
            {
                throw new PEMException(
                    "problem creating DSA private key: " + e.toString(), e);
            }
        }
        
    }
    
    private class ECDSAKeyPairParser extends KeyPairParser {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.400 -0500", hash_original_method = "3D5918BC33C2E8750A0F79CF102B6DFC", hash_generated_method = "FC6CB8564356E7B70EFBC5E495CF5A60")
        
public ECDSAKeyPairParser(String provider)
        {
            super(provider);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.403 -0500", hash_original_method = "C19C67ADBE6E6117AD29F18C950B281B", hash_generated_method = "318147FC558244690A9888F2218B1B56")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
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

                return new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
            }
            catch (IOException e)
            {
                throw e;
            }
            catch (Exception e)
            {
                throw new PEMException(
                    "problem creating EC private key: " + e.toString(), e);
            }
        }
        
    }
    
    private class RSAKeyPairParser extends KeyPairParser {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.408 -0500", hash_original_method = "77B6A791758EAFC47A0B2DE5F4E18FED", hash_generated_method = "46B4C2C7A3D7DE2ED540B58D362D44E3")
        
public RSAKeyPairParser(String provider)
        {
            super(provider);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.412 -0500", hash_original_method = "C48B53F279450A4E2A5829BDF7A98326", hash_generated_method = "40F4F96513AEBCB1B6AC6A8FC560295B")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
            try
            {
                ASN1Sequence seq = readKeyPair(obj);

                if (seq.size() != 9)
                {
                    throw new PEMException("malformed sequence in RSA private key");
                }

                //            DERInteger              v = (DERInteger)seq.getObjectAt(0);
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

                return new KeyPair(
                    fact.generatePublic(pubSpec),
                    fact.generatePrivate(privSpec));
            }
            catch (IOException e)
            {
                throw e;
            }
            catch (Exception e)
            {
                throw new PEMException(
                    "problem creating RSA private key: " + e.toString(), e);
            }
        }
        
    }
    
    private class PublicKeyParser implements PemObjectParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.416 -0500", hash_original_field = "A5A1D795BB0E6A860404CE54547A2FCF", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.419 -0500", hash_original_method = "0B170982AEB3AA2304D2A6B36AB698F1", hash_generated_method = "3315DCC7E4C58C58B29D54F0DE196036")
        
public PublicKeyParser(String provider)
        {
            this.provider = provider;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.421 -0500", hash_original_method = "5FFFDE03CF0C93B31D80B463283D2455", hash_generated_method = "CD0022AFE0FF8DA75BD93E11F944523D")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
            KeySpec keySpec = new X509EncodedKeySpec(obj.getContent());
            String[] algorithms = {"DSA", "RSA"};
            for (int i = 0; i < algorithms.length; i++)
            {
                try
                {
                    KeyFactory keyFact = KeyFactory.getInstance(algorithms[i], provider);
                    PublicKey pubKey = keyFact.generatePublic(keySpec);

                    return pubKey;
                }
                catch (NoSuchAlgorithmException e)
                {
                    // ignore
                }
                catch (InvalidKeySpecException e)
                {
                    // ignore
                }
                catch (NoSuchProviderException e)
                {
                    throw new RuntimeException("can't find provider " + provider);
                }
            }

            return null;
        }
        
    }
    
    private class RSAPublicKeyParser implements PemObjectParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.426 -0500", hash_original_field = "A5A1D795BB0E6A860404CE54547A2FCF", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.429 -0500", hash_original_method = "43B57D7EBB5BEFFE4B105714BFD44A53", hash_generated_method = "F85D61DE0903DABC00822B4CEEDD59CB")
        
public RSAPublicKeyParser(String provider)
        {
            this.provider = provider;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.432 -0500", hash_original_method = "2B7340E6F342A11B50254F4EBFCAD61E", hash_generated_method = "CFDB245EA0A9C0E3EDDA62CEBEC1B15B")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
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

                    return keyFact.generatePublic(keySpec);
            }
            catch (IOException e)
            {
                throw e;
            }
            catch (NoSuchProviderException e)
            {
                throw new IOException("can't find provider " + provider);
            }
            catch (Exception e)
            {
                throw new PEMException("problem extracting key: " + e.toString(), e);
            }
        }
        
    }
    
    private class X509CertificateParser implements PemObjectParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.436 -0500", hash_original_field = "A5A1D795BB0E6A860404CE54547A2FCF", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.439 -0500", hash_original_method = "A94C5E4D766266E16A102DAB21BC091D", hash_generated_method = "027336EF1FCF3AD4ABA53400BBD00565")
        
public X509CertificateParser(String provider)
        {
            this.provider = provider;
        }

        /**
         * Reads in a X509Certificate.
         *
         * @return the X509Certificate
         * @throws IOException if an I/O error occured
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.442 -0500", hash_original_method = "E970ED81058B7D7B34834ED92B99A71B", hash_generated_method = "F807A53F2862992E0847ADBEAEAD50F3")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
            ByteArrayInputStream bIn = new ByteArrayInputStream(obj.getContent());

            try
            {
                CertificateFactory certFact
                    = CertificateFactory.getInstance("X.509", provider);

                return certFact.generateCertificate(bIn);
            }
            catch (Exception e)
            {
                throw new PEMException("problem parsing cert: " + e.toString(), e);
            }
        }
        
    }
    
    private class X509CRLParser implements PemObjectParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.446 -0500", hash_original_field = "A5A1D795BB0E6A860404CE54547A2FCF", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.449 -0500", hash_original_method = "E353A700BDAAD44A8DB485E4FB446A3F", hash_generated_method = "6A07270B8654B9B2FA04A120ECC2DEDE")
        
public X509CRLParser(String provider)
        {
            this.provider = provider;
        }

        /**
         * Reads in a X509CRL.
         *
         * @return the X509Certificate
         * @throws IOException if an I/O error occured
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.452 -0500", hash_original_method = "FC6031BD5FB1B476FDF70740E2B2704D", hash_generated_method = "4A36EA2E1CF5F8C9F0C14493D39E6A3A")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
            ByteArrayInputStream bIn = new ByteArrayInputStream(obj.getContent());

            try
            {
                CertificateFactory certFact
                    = CertificateFactory.getInstance("X.509", provider);

                return certFact.generateCRL(bIn);
            }
            catch (Exception e)
            {
                throw new PEMException("problem parsing cert: " + e.toString(), e);
            }
        }
        
    }
    
    private class PKCS10CertificationRequestParser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.075 -0400", hash_original_method = "33AF8B880E8127EFE5F17F2D4C65D4F3", hash_generated_method = "33AF8B880E8127EFE5F17F2D4C65D4F3")
        public PKCS10CertificationRequestParser ()
        {
            //Synthesized constructor
        }
        /**
         * Reads in a PKCS10 certification request.
         *
         * @return the certificate request.
         * @throws IOException if an I/O error occured
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.457 -0500", hash_original_method = "CDCCA4D777F3AF625C0928D23D03AC75", hash_generated_method = "B4A77407821EC07A865080265F744865")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
            try
            {
                return new PKCS10CertificationRequest(obj.getContent());
            }
            catch (Exception e)
            {
                throw new PEMException("problem parsing certrequest: " + e.toString(), e);
            }
        }
        
    }
    
    private class PKCS7Parser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.075 -0400", hash_original_method = "7BCD24730CEC01AC7ECF6E6CD774D6E0", hash_generated_method = "7BCD24730CEC01AC7ECF6E6CD774D6E0")
        public PKCS7Parser ()
        {
            //Synthesized constructor
        }
        /**
         * Reads in a PKCS7 object. This returns a ContentInfo object suitable for use with the CMS
         * API.
         *
         * @return the X509Certificate
         * @throws IOException if an I/O error occured
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.461 -0500", hash_original_method = "349205E9CFEFFD40FE2D93E7DAF8E867", hash_generated_method = "D8B4D1F60CD4A49FD451D41BAE0D9EB6")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
            try
            {
                ASN1InputStream aIn = new ASN1InputStream(obj.getContent());

                return ContentInfo.getInstance(aIn.readObject());
            }
            catch (Exception e)
            {
                throw new PEMException("problem parsing PKCS7 object: " + e.toString(), e);
            }
        }
        
    }
    
    private class X509AttributeCertificateParser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.076 -0400", hash_original_method = "45D9D0D62A34F27B8FC81044406762B2", hash_generated_method = "45D9D0D62A34F27B8FC81044406762B2")
        public X509AttributeCertificateParser ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.465 -0500", hash_original_method = "C751E950E815D18D55C97B4D94E88025", hash_generated_method = "91DF4FCE1261ABC12FEDDA47562DBD6B")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
            return new X509V2AttributeCertificate(obj.getContent());
        }
        
    }
    
    private class ECNamedCurveSpecParser implements PemObjectParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.077 -0400", hash_original_method = "6EE69FC59FA5D4825234247899DC0928", hash_generated_method = "6EE69FC59FA5D4825234247899DC0928")
        public ECNamedCurveSpecParser ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.471 -0500", hash_original_method = "76529322BBA013222CE8C144A2985A3B", hash_generated_method = "D1DCA3A13E434F18A9E36F1625C33347")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
            try
            {
                DERObjectIdentifier oid = (DERObjectIdentifier)ASN1Object.fromByteArray(obj.getContent());

                Object params = ECNamedCurveTable.getParameterSpec(oid.getId());

                if (params == null)
                {
                    throw new IOException("object ID not found in EC curve table");
                }

                return params;
            }
            catch (IOException e)
            {
                throw e;
            }
            catch (Exception e)
            {
                throw new PEMException("exception extracting EC named curve: " + e.toString());
            }
        }
        
    }
    
    private class EncryptedPrivateKeyParser implements PemObjectParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.475 -0500", hash_original_field = "9BA4AFAAF50A40E3743CD384237FD874", hash_generated_field = "7250E15B2C636F0751D5B7C0DD47B256")

        private String symProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.477 -0500", hash_original_field = "DCA3883F62A97A4D3520EFAE3870D858", hash_generated_field = "0F549A2B688E81487E68FB3369A216E4")

        private String asymProvider;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.481 -0500", hash_original_method = "E8D8629FC61D2C1E41CC63DCCA2261A4", hash_generated_method = "B65A5CE8FFAC4A3ED445D30D40B67CBB")
        
public EncryptedPrivateKeyParser(String symProvider, String asymProvider)
        {
            this.symProvider = symProvider;
            this.asymProvider = asymProvider;
        }

        /**
         * Reads in a X509CRL.
         *
         * @return the X509Certificate
         * @throws IOException if an I/O error occured
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.485 -0500", hash_original_method = "B158B358DBE9E580DC539CC61ABD0BEA", hash_generated_method = "C47E3BBBC709FD56F3EC8334F23C2758")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
            try
            {
                EncryptedPrivateKeyInfo info = EncryptedPrivateKeyInfo.getInstance(ASN1Object.fromByteArray(obj.getContent()));
                AlgorithmIdentifier algId = info.getEncryptionAlgorithm();

                if (pFinder == null)
                {
                    throw new PEMException("no PasswordFinder specified");
                }

                if (PEMUtilities.isPKCS5Scheme2(algId.getAlgorithm()))
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

                    return keyFact.generatePrivate(keySpec);
                }
                else if (PEMUtilities.isPKCS12(algId.getAlgorithm()))
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

                    return keyFact.generatePrivate(keySpec);
                }
                else if (PEMUtilities.isPKCS5Scheme1(algId.getAlgorithm()))
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

                    return keyFact.generatePrivate(keySpec);
                }
                else
                {
                    throw new PEMException("Unknown algorithm: " + algId.getAlgorithm());
                }
            }
            catch (IOException e)
            {
                throw e;
            }
            catch (Exception e)
            {
                throw new PEMException("problem parsing ENCRYPTED PRIVATE KEY: " + e.toString(), e);
            }
        }
        
    }
    
    private class PrivateKeyParser implements PemObjectParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.491 -0500", hash_original_field = "A5A1D795BB0E6A860404CE54547A2FCF", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

        private String provider;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.494 -0500", hash_original_method = "0877761703B26434F32E47C53A29AE74", hash_generated_method = "802A668420942984C1CC115E54B34B68")
        
public PrivateKeyParser(String provider)
        {
            this.provider = provider;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.497 -0500", hash_original_method = "2553B1C8B63939D2139C3EAA36C566E7", hash_generated_method = "E940A6EEFA95A38A762E20D5E2F53DC9")
        
public Object parseObject(PemObject obj)
            throws IOException
        {
            try
            {
                PrivateKeyInfo info = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(obj.getContent()));
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(obj.getContent());

                KeyFactory keyFact = KeyFactory.getInstance(info.getAlgorithmId().getAlgorithm().getId(), provider);

                return keyFact.generatePrivate(keySpec);
            }
            catch (Exception e)
            {
                throw new PEMException("problem parsing PRIVATE KEY: " + e.toString(), e);
            }
        }
        
    }
    
}

