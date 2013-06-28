package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Strings;

class X509Util {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.537 -0400", hash_original_method = "19DD25388D9EA3D8C5EFD26CD223A84A", hash_generated_method = "19DD25388D9EA3D8C5EFD26CD223A84A")
    public X509Util ()
    {
        //Synthesized constructor
    }


    private static RSASSAPSSparams creatPSSParams(AlgorithmIdentifier hashAlgId, int saltSize) {
        return new RSASSAPSSparams(
            hashAlgId,
            new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, hashAlgId),
            new DERInteger(saltSize),
            new DERInteger(1));
    }

    
    static DERObjectIdentifier getAlgorithmOID(
        String algorithmName) {
        algorithmName = Strings.toUpperCase(algorithmName);
        if (algorithms.containsKey(algorithmName))
        {
            return (DERObjectIdentifier)algorithms.get(algorithmName);
        }
        return new DERObjectIdentifier(algorithmName);
    }

    
    static AlgorithmIdentifier getSigAlgID(
        DERObjectIdentifier sigOid,
        String              algorithmName) {
        if (noParams.contains(sigOid))
        {
            return new AlgorithmIdentifier(sigOid);
        }
        algorithmName = Strings.toUpperCase(algorithmName);
        if (params.containsKey(algorithmName))
        {
            return new AlgorithmIdentifier(sigOid, (DEREncodable)params.get(algorithmName));
        }
        else
        {
            return new AlgorithmIdentifier(sigOid, DERNull.INSTANCE);
        }
    }

    
    static Iterator getAlgNames() {
        Enumeration e = algorithms.keys();
        List        l = new ArrayList();
        while (e.hasMoreElements())
        {
            l.add(e.nextElement());
        }
        return l.iterator();
    }

    
    static Signature getSignatureInstance(
        String algorithm) throws NoSuchAlgorithmException {
        return Signature.getInstance(algorithm);
    }

    
    static Signature getSignatureInstance(
        String algorithm,
        String provider) throws NoSuchProviderException, NoSuchAlgorithmException {
        if (provider != null)
        {
            return Signature.getInstance(algorithm, provider);
        }
        else
        {
            return Signature.getInstance(algorithm);
        }
    }

    
    static byte[] calculateSignature(
        DERObjectIdentifier sigOid,
        String              sigName,
        PrivateKey          key,
        SecureRandom        random,
        ASN1Encodable       object) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sig;
        if (sigOid == null)
        {
            throw new IllegalStateException("no signature algorithm specified");
        }
        sig = X509Util.getSignatureInstance(sigName);
        if (random != null)
        {
            sig.initSign(key, random);
        }
        else
        {
            sig.initSign(key);
        }
        sig.update(object.getEncoded(ASN1Encodable.DER));
        return sig.sign();
    }

    
    static byte[] calculateSignature(
        DERObjectIdentifier sigOid,
        String              sigName,
        String              provider,
        PrivateKey          key,
        SecureRandom        random,
        ASN1Encodable       object) throws IOException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sig;
        if (sigOid == null)
        {
            throw new IllegalStateException("no signature algorithm specified");
        }
        sig = X509Util.getSignatureInstance(sigName, provider);
        if (random != null)
        {
            sig.initSign(key, random);
        }
        else
        {
            sig.initSign(key);
        }
        sig.update(object.getEncoded(ASN1Encodable.DER));
        return sig.sign();
    }

    
    static X509Principal convertPrincipal(
        X500Principal principal) {
        try
        {
            return new X509Principal(principal.getEncoded());
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("cannot convert principal");
        }
    }

    
    static Implementation getImplementation(
        String      baseName,
        String      algorithm,
        Provider    prov) throws NoSuchAlgorithmException {
        algorithm = Strings.toUpperCase(algorithm);
        String      alias;
        while ((alias = prov.getProperty("Alg.Alias." + baseName + "." + algorithm)) != null)
        {
            algorithm = alias;
        }
        String      className = prov.getProperty(baseName + "." + algorithm);
        if (className != null)
        {
            try
            {
                Class       cls;
                ClassLoader clsLoader = prov.getClass().getClassLoader();
                if (clsLoader != null)
                {
                    cls = clsLoader.loadClass(className);
                }
                else
                {
                    cls = Class.forName(className);
                }
                return new Implementation(cls.newInstance(), prov);
            }
            catch (ClassNotFoundException e)
            {
                throw new IllegalStateException(
                    "algorithm " + algorithm + " in provider " + prov.getName() + " but no class \"" + className + "\" found!");
            }
            catch (Exception e)
            {
                throw new IllegalStateException(
                    "algorithm " + algorithm + " in provider " + prov.getName() + " but class \"" + className + "\" inaccessible!");
            }
        }
        throw new NoSuchAlgorithmException("cannot find implementation " + algorithm + " for provider " + prov.getName());
    }

    
    static Implementation getImplementation(
        String      baseName,
        String      algorithm) throws NoSuchAlgorithmException {
        Provider[] prov = Security.getProviders();
        for (int i = 0; i != prov.length; i++)
        {
            Implementation imp = getImplementation(baseName, Strings.toUpperCase(algorithm), prov[i]);
            if (imp != null)
            {
                return imp;
            }
            try
            {
                imp = getImplementation(baseName, algorithm, prov[i]);
            }
            catch (NoSuchAlgorithmException e)
            {
            }
        }
        throw new NoSuchAlgorithmException("cannot find implementation " + algorithm);
    }

    
    static Provider getProvider(String provider) throws NoSuchProviderException {
        Provider prov = Security.getProvider(provider);
        if (prov == null)
        {
            throw new NoSuchProviderException("Provider " + provider + " not found");
        }
        return prov;
    }

    
    static class Implementation {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.540 -0400", hash_original_field = "AD1943A9FD6D3D7EE1E6AF41A5B0D3E7", hash_generated_field = "8CEDBCDCD092B544D79CF4DDA5859D9C")

        Object engine;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.540 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "70389BF55D92237F4948951640719A18")

        Provider provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.540 -0400", hash_original_method = "9E32F4D9CC9EFE32B8319A8018F19FA9", hash_generated_method = "9949B2A2DF1D43714393D23ACBD49241")
          Implementation(
            Object      engine,
            Provider    provider) {
            this.engine = engine;
            this.provider = provider;
            // ---------- Original Method ----------
            //this.engine = engine;
            //this.provider = provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.541 -0400", hash_original_method = "BE45F36A26940534B07006714A378835", hash_generated_method = "51B522A9979A390114F57D5F0896C0D6")
         Object getEngine() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1833069912 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1833069912 = engine;
            varB4EAC82CA7396A68D541C85D26508E83_1833069912.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1833069912;
            // ---------- Original Method ----------
            //return engine;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.542 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "8AAA5E6542584067EE45A1695245FD5C")
         Provider getProvider() {
            Provider varB4EAC82CA7396A68D541C85D26508E83_1332500710 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1332500710 = provider;
            varB4EAC82CA7396A68D541C85D26508E83_1332500710.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1332500710;
            // ---------- Original Method ----------
            //return provider;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.542 -0400", hash_original_field = "B39C3BE7546FA73A752B6C68B346E2B1", hash_generated_field = "2A7E0957EAD856B3315504481686A7DE")

    private static Hashtable algorithms = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.542 -0400", hash_original_field = "0D433ED6AA05239AA7FFA603AE52EAF9", hash_generated_field = "3580C2237188FBF88703AFC814D06B98")

    private static Hashtable params = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.542 -0400", hash_original_field = "9599D5E70EEA113DAC00F7EA2B8AD147", hash_generated_field = "E222E546E7C245483C60E7B45F19B3A8")

    private static Set noParams = new HashSet();
    static {   
        algorithms.put("MD5WITHRSAENCRYPTION", PKCSObjectIdentifiers.md5WithRSAEncryption);
        algorithms.put("MD5WITHRSA", PKCSObjectIdentifiers.md5WithRSAEncryption);
        algorithms.put("SHA1WITHRSAENCRYPTION", PKCSObjectIdentifiers.sha1WithRSAEncryption);
        algorithms.put("SHA1WITHRSA", PKCSObjectIdentifiers.sha1WithRSAEncryption);
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
        algorithms.put("SHA1WITHDSA", X9ObjectIdentifiers.id_dsa_with_sha1);
        algorithms.put("DSAWITHSHA1", X9ObjectIdentifiers.id_dsa_with_sha1);
        algorithms.put("SHA256WITHDSA", NISTObjectIdentifiers.dsa_with_sha256);
        algorithms.put("SHA384WITHDSA", NISTObjectIdentifiers.dsa_with_sha384);
        algorithms.put("SHA512WITHDSA", NISTObjectIdentifiers.dsa_with_sha512);
        algorithms.put("SHA1WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA1);
        algorithms.put("ECDSAWITHSHA1", X9ObjectIdentifiers.ecdsa_with_SHA1);
        algorithms.put("SHA256WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA256);
        algorithms.put("SHA384WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA384);
        algorithms.put("SHA512WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA512);
        noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA1);
        noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA256);
        noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA384);
        noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA512);
        noParams.add(X9ObjectIdentifiers.id_dsa_with_sha1);
        noParams.add(NISTObjectIdentifiers.dsa_with_sha256);
        noParams.add(NISTObjectIdentifiers.dsa_with_sha384);
        noParams.add(NISTObjectIdentifiers.dsa_with_sha512);
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

