package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Strings;






class X509Util {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.195 -0500", hash_original_method = "25B2A761D6FCD88D1F6D5EF8095097C3", hash_generated_method = "BBC0B09FA1E82C1739E7BED70CD2D30F")
    
private static RSASSAPSSparams creatPSSParams(AlgorithmIdentifier hashAlgId, int saltSize)
    {
        return new RSASSAPSSparams(
            hashAlgId,
            new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, hashAlgId),
            new DERInteger(saltSize),
            new DERInteger(1));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.198 -0500", hash_original_method = "EB96EA681AA54949640DBBFD56AFEE3D", hash_generated_method = "B96B88943A02621E35E3F201E1D154B4")
    
static DERObjectIdentifier getAlgorithmOID(
        String algorithmName)
    {
        algorithmName = Strings.toUpperCase(algorithmName);
        
        if (algorithms.containsKey(algorithmName))
        {
            return (DERObjectIdentifier)algorithms.get(algorithmName);
        }
        
        return new DERObjectIdentifier(algorithmName);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.200 -0500", hash_original_method = "86A5A472621EFAB2954CBB6F53B6DF0B", hash_generated_method = "CB0AD73CB40E7D5CD62A76E45B15C4BB")
    
static AlgorithmIdentifier getSigAlgID(
        DERObjectIdentifier sigOid,
        String              algorithmName)
    {
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
            // BEGIN android-changed
            return new AlgorithmIdentifier(sigOid, DERNull.INSTANCE);
            // END android-changed
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.203 -0500", hash_original_method = "DDE26145F473C5CDA65FAB7711F3C967", hash_generated_method = "661EB69A055DCB1B95146A4E0E78FE19")
    
static Iterator getAlgNames()
    {
        Enumeration e = algorithms.keys();
        List        l = new ArrayList();
        
        while (e.hasMoreElements())
        {
            l.add(e.nextElement());
        }
        
        return l.iterator();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.205 -0500", hash_original_method = "BC13D71A5ED2986BEC329C4BD5E6CD4D", hash_generated_method = "D1A7D177FEFF1EB8BB52C1EE40FC9A7B")
    
static Signature getSignatureInstance(
        String algorithm)
        throws NoSuchAlgorithmException
    {
        return Signature.getInstance(algorithm);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.207 -0500", hash_original_method = "7376E9D2EC8CBDFA3F5EF467F6FFBB82", hash_generated_method = "980CCDA12056C2D2C843541BEDF2BE65")
    
static Signature getSignatureInstance(
        String algorithm,
        String provider)
        throws NoSuchProviderException, NoSuchAlgorithmException
    {
        if (provider != null)
        {
            return Signature.getInstance(algorithm, provider);
        }
        else
        {
            return Signature.getInstance(algorithm);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.210 -0500", hash_original_method = "52BBD38FA535C4B63312A116C09E8119", hash_generated_method = "3573A434339168B61A73F6AB21E8E66A")
    
static byte[] calculateSignature(
        DERObjectIdentifier sigOid,
        String              sigName,
        PrivateKey          key,
        SecureRandom        random,
        ASN1Encodable       object)
        throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.213 -0500", hash_original_method = "8206942B03D277BD993D39F346F7E519", hash_generated_method = "8F3698DEBBFEBD88A481F529AA7E3E89")
    
static byte[] calculateSignature(
        DERObjectIdentifier sigOid,
        String              sigName,
        String              provider,
        PrivateKey          key,
        SecureRandom        random,
        ASN1Encodable       object)
        throws IOException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.215 -0500", hash_original_method = "F50F3B7A2230AD105E44CA884465512D", hash_generated_method = "600C5D5B441F6B68EFEAAEE4F149BA1E")
    
static X509Principal convertPrincipal(
        X500Principal principal)
    {
        try
        {
            return new X509Principal(principal.getEncoded());
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("cannot convert principal");
        }
    }

    /**
     * see if we can find an algorithm (or its alias and what it represents) in
     * the property table for the given provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.232 -0500", hash_original_method = "26D6914E98980059440520DCD9BDC8FB", hash_generated_method = "1F8EB7BC234BB92754FEA25766136DE1")
    
static Implementation getImplementation(
        String      baseName,
        String      algorithm,
        Provider    prov)
        throws NoSuchAlgorithmException
    {
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

    /**
     * return an implementation for a given algorithm/provider.
     * If the provider is null, we grab the first avalaible who has the required algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.235 -0500", hash_original_method = "543992E94F22ACE37CAF52CD3C0D2D53", hash_generated_method = "A77AF9F67C0F737D63388AE0B7BCB005")
    
static Implementation getImplementation(
        String      baseName,
        String      algorithm)
        throws NoSuchAlgorithmException
    {
        Provider[] prov = Security.getProviders();

        //
        // search every provider looking for the algorithm we want.
        //
        for (int i = 0; i != prov.length; i++)
        {
            //
            // try case insensitive
            //
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
                // continue
            }
        }

        throw new NoSuchAlgorithmException("cannot find implementation " + algorithm);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.238 -0500", hash_original_method = "E365CC40515812191B8F9F9EFF6B6E93", hash_generated_method = "F45B7EC20089B45BF28339B6E202C233")
    
static Provider getProvider(String provider)
        throws NoSuchProviderException
    {
        Provider prov = Security.getProvider(provider);

        if (prov == null)
        {
            throw new NoSuchProviderException("Provider " + provider + " not found");
        }

        return prov;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.187 -0500", hash_original_field = "A8B38EFEBE1FD690B18E15CE341717C3", hash_generated_field = "2A7E0957EAD856B3315504481686A7DE")

    private static Hashtable algorithms = new Hashtable();

    
    static class Implementation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.218 -0500", hash_original_field = "8CEDBCDCD092B544D79CF4DDA5859D9C", hash_generated_field = "8CEDBCDCD092B544D79CF4DDA5859D9C")

        Object      engine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.220 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "70389BF55D92237F4948951640719A18")

        Provider provider;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.223 -0500", hash_original_method = "9E32F4D9CC9EFE32B8319A8018F19FA9", hash_generated_method = "9E32F4D9CC9EFE32B8319A8018F19FA9")
        
Implementation(
            Object      engine,
            Provider    provider)
        {
            this.engine = engine;
            this.provider = provider;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.225 -0500", hash_original_method = "BE45F36A26940534B07006714A378835", hash_generated_method = "BE45F36A26940534B07006714A378835")
        
Object getEngine()
        {
            return engine;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.228 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "4D6A4C5C7B57C5543A93E2FA43879F89")
        
Provider getProvider()
        {
            return provider;
        }

        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.190 -0500", hash_original_field = "9F226D98C1CB8D80E9F82A4DB61E3C25", hash_generated_field = "3580C2237188FBF88703AFC814D06B98")

    private static Hashtable params = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.192 -0500", hash_original_field = "3251BB4B6326B92285C39B28EEE8EF19", hash_generated_field = "E222E546E7C245483C60E7B45F19B3A8")

    private static Set       noParams = new HashSet();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.603 -0400", hash_original_method = "19DD25388D9EA3D8C5EFD26CD223A84A", hash_generated_method = "19DD25388D9EA3D8C5EFD26CD223A84A")
    public X509Util ()
    {
        //Synthesized constructor
    }
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

