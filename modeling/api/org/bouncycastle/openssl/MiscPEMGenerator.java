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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.985 -0500", hash_original_field = "B907C3B1813ED5337E8F8B30F31ED00A", hash_generated_field = "03657E147A117C299E988405DFDF1FE0")

    private Object obj;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.988 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.990 -0500", hash_original_field = "21BCD293DE862031F898430214E88677", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.993 -0500", hash_original_field = "DB0BFD07E76FA22D79EF92D3D20AD0C9", hash_generated_field = "47462950F1DBF0D228B8D6FE202BDA9F")

    private SecureRandom random;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.995 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.997 -0500", hash_original_method = "C02D6ACBF889CF35766B7871B784307D", hash_generated_method = "83E66DD4663D34B7986388DED6A1A999")
    
public MiscPEMGenerator(Object o)
    {
        this.obj = o;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.000 -0500", hash_original_method = "AD2D21FAE267AE7BA19486B70A7A435E", hash_generated_method = "2CB8B0A31B891B2C60F90A47AE4A44A9")
    
public MiscPEMGenerator(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random,
        Provider     provider)
    {
        this.obj = obj;
        this.algorithm = algorithm;
        this.password = password;
        this.random = random;
        this.provider = provider;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.003 -0500", hash_original_method = "FC3CFC06395928A5BA1B88C136A7A3A1", hash_generated_method = "73E94ACE9E6622E323C58C3F7C1FB891")
    
public MiscPEMGenerator(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random,
        String       provider)
        throws NoSuchProviderException
    {
        this.obj = obj;
        this.algorithm = algorithm;
        this.password = password;
        this.random = random;

        if (provider != null)
        {
            this.provider = Security.getProvider(provider);
            if (this.provider == null)
            {
                throw new NoSuchProviderException("cannot find provider: " + provider);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.007 -0500", hash_original_method = "BB771E0C3864CDE92E08322A05A8C925", hash_generated_method = "3AEB8909C5A200208CB372EF0268B583")
    
private PemObject createPemObject(Object o)
        throws IOException
    {
        String  type;
        byte[]  encoding;

        if (o instanceof PemObject)
        {
            return (PemObject)o;
        }
        if (o instanceof PemObjectGenerator)
        {
            return ((PemObjectGenerator)o).generate();
        }
        if (o instanceof X509Certificate)
        {
            type = "CERTIFICATE";
            try
            {
                encoding = ((X509Certificate)o).getEncoded();
            }
            catch (CertificateEncodingException e)
            {
                throw new PemGenerationException("Cannot encode object: " + e.toString());
            }
        }
        else if (o instanceof X509CRL)
        {
            type = "X509 CRL";
            try
            {
                encoding = ((X509CRL)o).getEncoded();
            }
            catch (CRLException e)
            {
                throw new PemGenerationException("Cannot encode object: " + e.toString());
            }
        }
        else if (o instanceof KeyPair)
        {
            return createPemObject(((KeyPair)o).getPrivate());
        }
        else if (o instanceof PrivateKey)
        {
            PrivateKeyInfo info = new PrivateKeyInfo(
                (ASN1Sequence) ASN1Object.fromByteArray(((Key)o).getEncoded()));

            if (o instanceof RSAPrivateKey)
            {
                type = "RSA PRIVATE KEY";

                encoding = info.getPrivateKey().getEncoded();
            }
            else if (o instanceof DSAPrivateKey)
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
            else if (((PrivateKey)o).getAlgorithm().equals("ECDSA"))
            {
                type = "EC PRIVATE KEY";

                encoding = info.getPrivateKey().getEncoded();
            }
            else
            {
                throw new IOException("Cannot identify private key");
            }
        }
        else if (o instanceof PublicKey)
        {
            type = "PUBLIC KEY";

            encoding = ((PublicKey)o).getEncoded();
        }
        else if (o instanceof X509AttributeCertificate)
        {
            type = "ATTRIBUTE CERTIFICATE";
            encoding = ((X509V2AttributeCertificate)o).getEncoded();
        }
        else if (o instanceof PKCS10CertificationRequest)
        {
            type = "CERTIFICATE REQUEST";
            encoding = ((PKCS10CertificationRequest)o).getEncoded();
        }
        else if (o instanceof ContentInfo)
        {
            type = "PKCS7";
            encoding = ((ContentInfo)o).getEncoded();
        }
        else
        {
            throw new PemGenerationException("unknown object passed - can't encode.");
        }

        return new PemObject(type, encoding);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.009 -0500", hash_original_method = "DE836D95AE95CC4B16EC27C37C4EBA2F", hash_generated_method = "1D93C79278F5017273720A49FCC5B60F")
    
private String getHexEncoded(byte[] bytes)
        throws IOException
    {
        bytes = Hex.encode(bytes);

        char[] chars = new char[bytes.length];

        for (int i = 0; i != bytes.length; i++)
        {
            chars[i] = (char)bytes[i];
        }

        return new String(chars);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.013 -0500", hash_original_method = "C0940F4479949D8BE443C2F5943EB650", hash_generated_method = "EA647454FDF684924F3C52BFCE4D5E0C")
    
private PemObject createPemObject(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random)
        throws IOException
    {
        if (obj instanceof KeyPair)
        {
            return createPemObject(((KeyPair)obj).getPrivate(), algorithm, password, random);
        }

        String type = null;
        byte[] keyData = null;

        if (obj instanceof RSAPrivateCrtKey)
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

            // convert to bytearray
            keyData = keyStruct.getEncoded();
        }
        else if (obj instanceof DSAPrivateKey)
        {
            type = "DSA PRIVATE KEY";

            DSAPrivateKey       k = (DSAPrivateKey)obj;
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
        else if (obj instanceof PrivateKey && "ECDSA".equals(((PrivateKey)obj).getAlgorithm()))
        {
            type = "EC PRIVATE KEY";

            PrivateKeyInfo      privInfo = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(((PrivateKey)obj).getEncoded()));

            keyData = privInfo.getPrivateKey().getEncoded();
        }

        if (type == null || keyData == null)
        {
            // TODO Support other types?
            throw new IllegalArgumentException("Object type not supported: " + obj.getClass().getName());
        }

        String dekAlgName = Strings.toUpperCase(algorithm);

        // Note: For backward compatibility
        if (dekAlgName.equals("DESEDE"))
        {
            dekAlgName = "DES-EDE3-CBC";
        }

        int ivLength = dekAlgName.startsWith("AES-") ? 16 : 8;

        byte[] iv = new byte[ivLength];
        random.nextBytes(iv);

        byte[] encData = PEMUtilities.crypt(true, provider, keyData, password, dekAlgName, iv);

        List headers = new ArrayList(2);

        headers.add(new PemHeader("Proc-Type", "4,ENCRYPTED"));
        headers.add(new PemHeader("DEK-Info", dekAlgName + "," + getHexEncoded(iv)));

        return new PemObject(type, headers, encData);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.015 -0500", hash_original_method = "E9B86B455C150CA2FE6340A6ABEAFEB2", hash_generated_method = "C4AA593FA33881BD50DF03D069DF3D15")
    
public PemObject generate()
        throws PemGenerationException
    {
        try
        {
            if (algorithm != null)
            {
                return createPemObject(obj, algorithm, password, random);
            }

            return createPemObject(obj);
        }
        catch (IOException e)
        {
            throw new PemGenerationException("encoding exception: " + e.getMessage(), e);
        }
    }
    
}

