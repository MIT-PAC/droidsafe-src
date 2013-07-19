package org.bouncycastle.jce.provider;

// Droidsafe Imports
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.Iterator;
import java.util.Map;

import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.iana.IANAObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.jce.interfaces.ConfigurableProvider;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public final class BouncyCastleProvider extends Provider implements ConfigurableProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.611 -0400", hash_original_method = "A959A465DC8BCFFC9B23D0D2C15418FF", hash_generated_method = "08B8F66CBFBE8CA5A9C4764B5A932E78")
    public  BouncyCastleProvider() {
        super(PROVIDER_NAME, 1.46, info);
        AccessController.doPrivileged(new PrivilegedAction() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.611 -0400", hash_original_method = "BE2E02853AA4C6D3603EB21F00EC530A", hash_generated_method = "96E839369B050D7A810B4DC1EEDF94B1")
        public Object run() {
            setup();
Object var540C13E9E156B687226421B24F2DF178_1261972976 =             null;
            var540C13E9E156B687226421B24F2DF178_1261972976.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1261972976;
            // ---------- Original Method ----------
            //setup();
            //return null;
        }
});
        // ---------- Original Method ----------
        //AccessController.doPrivileged(new PrivilegedAction()
        //{
            //public Object run()
            //{
                //setup();
                //return null;
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.614 -0400", hash_original_method = "E95DD2D2AFF3ACCA1D641BC0C226DDDF", hash_generated_method = "B256A7800D009BB479F7B3324152D03F")
    private void setup() {
        loadAlgorithms(SYMMETRIC_CIPHER_PACKAGE, SYMMETRIC_CIPHERS);
        loadAlgorithms(ASYMMETRIC_CIPHER_PACKAGE, ASYMMETRIC_CIPHERS);
        put("KeyStore.BKS", "org.bouncycastle.jce.provider.JDKKeyStore");
        put("KeyStore.BouncyCastle", "org.bouncycastle.jce.provider.JDKKeyStore$BouncyCastleStore");
        put("KeyStore.PKCS12", "org.bouncycastle.jce.provider.JDKPKCS12KeyStore$BCPKCS12KeyStore");
        put("Alg.Alias.KeyStore.BCPKCS12", "PKCS12");
        put("Alg.Alias.KeyStore.PKCS12-3DES-40RC2", "PKCS12");
        put("Alg.Alias.KeyStore.UBER", "BouncyCastle");
        put("Alg.Alias.KeyStore.BOUNCYCASTLE", "BouncyCastle");
        put("Alg.Alias.KeyStore.bouncycastle", "BouncyCastle");
        put("CertificateFactory.X.509", "org.bouncycastle.jce.provider.JDKX509CertificateFactory");
        put("Alg.Alias.CertificateFactory.X509", "X.509");
        put("AlgorithmParameterGenerator.DH", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$DH");
        put("AlgorithmParameterGenerator.DSA", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$DSA");
        put("Alg.Alias.AlgorithmParameterGenerator.DIFFIEHELLMAN", "DH");
        put("AlgorithmParameters.OAEP", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$OAEP");
        put("AlgorithmParameters.DH", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$DH");
        put("Alg.Alias.AlgorithmParameters.DIFFIEHELLMAN", "DH");
        put("AlgorithmParameters.DSA", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$DSA");
        put("AlgorithmParameters.PKCS12PBE", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC2-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC4", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC2-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC4", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.1", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.2", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.3", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.4", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.5", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.6", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWithSHAAnd3KeyTripleDES", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes128_cbc.getId(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes192_cbc.getId(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes256_cbc.getId(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes128_cbc.getId(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes192_cbc.getId(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes256_cbc.getId(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + PKCSObjectIdentifiers.id_RSAES_OAEP, "OAEP");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND192BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND256BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND128BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND192BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND256BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND128BITAES-CBC-BC","PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND192BITAES-CBC-BC","PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND256BITAES-CBC-BC","PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND128BITAES-CBC-BC","PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND192BITAES-CBC-BC","PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND256BITAES-CBC-BC","PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND128BITAES-CBC-BC","PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND192BITAES-CBC-BC","PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND256BITAES-CBC-BC","PKCS12PBE");
        put("KeyAgreement.DH", "org.bouncycastle.jce.provider.JCEDHKeyAgreement");
        put("Alg.Alias.KeyAgreement.DIFFIEHELLMAN", "DH");
        put("Cipher.DES", "org.bouncycastle.jce.provider.JCEBlockCipher$DES");
        put("Alg.Alias.Cipher.PBEWithSHAAnd3KeyTripleDES",  "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        put("Cipher.RSA", "org.bouncycastle.jce.provider.JCERSACipher$NoPadding");
        put("Alg.Alias.Cipher.RSA/RAW", "RSA");
        put("Alg.Alias.Cipher.RSA//RAW", "RSA");
        put("Alg.Alias.Cipher.RSA//NOPADDING", "RSA");
        put("Cipher.PBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithMD5AndDES");
        put("Cipher.PBEWITHMD5ANDRC2", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithMD5AndRC2");
        put("Cipher.PBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHA1AndDES");
        put("Cipher.PBEWITHSHA1ANDRC2", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHA1AndRC2");
        put("Cipher.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHAAndDES3Key");
        put("Cipher.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHAAndDES2Key");
        put("Cipher.PBEWITHSHAAND128BITRC2-CBC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHAAnd128BitRC2");
        put("Cipher.PBEWITHSHAAND40BITRC2-CBC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHAAnd40BitRC2");
        put("Cipher.PBEWITHSHAAND128BITRC4", "org.bouncycastle.jce.provider.JCEStreamCipher$PBEWithSHAAnd128BitRC4");
        put("Cipher.PBEWITHSHAAND40BITRC4", "org.bouncycastle.jce.provider.JCEStreamCipher$PBEWithSHAAnd40BitRC4");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYTRIPLEDES-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYTRIPLEDES-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC2-CBC", "PBEWITHSHAAND128BITRC2-CBC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC2-CBC", "PBEWITHSHAAND40BITRC2-CBC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC4", "PBEWITHSHAAND128BITRC4");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC4", "PBEWITHSHAAND40BITRC4");
        put("Alg.Alias.Cipher." + BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes128_cbc.getId(), "PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.Cipher." + BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes192_cbc.getId(), "PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.Cipher." + BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes256_cbc.getId(), "PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.Cipher." + BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes128_cbc.getId(), "PBEWITHSHA256AND128BITAES-CBC-BC");
        put("Alg.Alias.Cipher." + BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes192_cbc.getId(), "PBEWITHSHA256AND192BITAES-CBC-BC");
        put("Alg.Alias.Cipher." + BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes256_cbc.getId(), "PBEWITHSHA256AND256BITAES-CBC-BC");
        put("Cipher.PBEWITHSHAAND128BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHAAND192BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHAAND256BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHA256AND128BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHA256AND192BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHA256AND256BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-CBC-BC","PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-CBC-BC","PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-CBC-BC","PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-CBC-BC","PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-CBC-BC","PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-CBC-BC","PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-CBC-BC","PBEWITHSHA256AND128BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-CBC-BC","PBEWITHSHA256AND192BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-CBC-BC","PBEWITHSHA256AND256BITAES-CBC-BC");
        put("Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHAAndTwofish");
        put("Alg.Alias.Cipher." + PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC, "PBEWITHMD5ANDDES");
        put("Alg.Alias.Cipher." + PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC, "PBEWITHMD5ANDDES");
        put("Alg.Alias.Cipher." + PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC, "PBEWITHSHA1ANDDES");
        put("Alg.Alias.Cipher." + PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC, "PBEWITHSHA1ANDRC2");
        put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.1", "PBEWITHSHAAND128BITRC4");
        put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.2", "PBEWITHSHAAND40BITRC4");
        put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.3", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.4", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
        put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.5", "PBEWITHSHAAND128BITRC2-CBC");
        put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.6", "PBEWITHSHAAND40BITRC2-CBC");
        put("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        put("KeyGenerator.DES", "org.bouncycastle.jce.provider.JCEKeyGenerator$DES");
        put("Alg.Alias.KeyGenerator." + OIWObjectIdentifiers.desCBC, "DES");
        put("KeyPairGenerator.RSA", "org.bouncycastle.jce.provider.JDKKeyPairGenerator$RSA");
        put("KeyPairGenerator.DH", "org.bouncycastle.jce.provider.JDKKeyPairGenerator$DH");
        put("KeyPairGenerator.DSA", "org.bouncycastle.jce.provider.JDKKeyPairGenerator$DSA");
        put("Alg.Alias.KeyPairGenerator.1.2.840.113549.1.1.1", "RSA");
        put("Alg.Alias.KeyPairGenerator.DIFFIEHELLMAN", "DH");
        put("KeyFactory.RSA", "org.bouncycastle.jce.provider.JDKKeyFactory$RSA");
        put("KeyFactory.DH", "org.bouncycastle.jce.provider.JDKKeyFactory$DH");
        put("KeyFactory.DSA", "org.bouncycastle.jce.provider.JDKKeyFactory$DSA");
        put("Alg.Alias.KeyFactory.1.2.840.113549.1.1.1", "RSA");
        put("Alg.Alias.KeyFactory.1.2.840.10040.4.1", "DSA");
        put("Alg.Alias.KeyFactory.DIFFIEHELLMAN", "DH");
        put("AlgorithmParameters.DES", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        put("Alg.Alias.AlgorithmParameters." + OIWObjectIdentifiers.desCBC, "DES");
        put("AlgorithmParameters.DESEDE", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        put("Alg.Alias.AlgorithmParameters." + PKCSObjectIdentifiers.des_EDE3_CBC, "DESEDE");
        put("SecretKeyFactory.DES", "org.bouncycastle.jce.provider.JCESecretKeyFactory$DES");
        put("Alg.Alias.SecretKeyFactory." + PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC, "PBEWITHMD5ANDDES");
        put("Alg.Alias.SecretKeyFactory." + PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC, "PBEWITHMD5ANDDES");
        put("Alg.Alias.SecretKeyFactory." + PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC, "PBEWITHSHA1ANDDES");
        put("Alg.Alias.SecretKeyFactory." + PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC, "PBEWITHSHA1ANDRC2");
        put("SecretKeyFactory.PBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithMD5AndDES");
        put("SecretKeyFactory.PBEWITHMD5ANDRC2", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithMD5AndRC2");
        put("SecretKeyFactory.PBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA1AndDES");
        put("SecretKeyFactory.PBEWITHSHA1ANDRC2", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA1AndRC2");
        put("SecretKeyFactory.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAndDES3Key");
        put("SecretKeyFactory.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAndDES2Key");
        put("SecretKeyFactory.PBEWITHSHAAND128BITRC4", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd128BitRC4");
        put("SecretKeyFactory.PBEWITHSHAAND40BITRC4", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd40BitRC4");
        put("SecretKeyFactory.PBEWITHSHAAND128BITRC2-CBC", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd128BitRC2");
        put("SecretKeyFactory.PBEWITHSHAAND40BITRC2-CBC", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd40BitRC2");
        put("SecretKeyFactory.PBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAndTwofish");
        put("SecretKeyFactory.PBEWITHHMACSHA1", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA");
        put("SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithMD5And128BitAESCBCOpenSSL");
        put("SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithMD5And192BitAESCBCOpenSSL");
        put("SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithMD5And256BitAESCBCOpenSSL");
        put("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
        put("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDRC2-CBC", "PBEWITHMD5ANDRC2");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDRC2-CBC", "PBEWITHSHA1ANDRC2");
        put("Alg.Alias.SecretKeyFactory." + PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC, "PBEWITHMD5ANDDES");
        put("Alg.Alias.SecretKeyFactory." + PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC, "PBEWITHMD5ANDRC2");
        put("Alg.Alias.SecretKeyFactory." + PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC, "PBEWITHSHA1ANDDES");
        put("Alg.Alias.SecretKeyFactory." + PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC, "PBEWITHSHA1ANDRC2");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.1", "PBEWITHSHAAND128BITRC4");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.2", "PBEWITHSHAAND40BITRC4");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.3", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.4", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.5", "PBEWITHSHAAND128BITRC2-CBC");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.6", "PBEWITHSHAAND40BITRC2-CBC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA", "PBEWITHHMACSHA1");
        put("Alg.Alias.SecretKeyFactory.1.3.14.3.2.26", "PBEWITHHMACSHA1");
        put("Alg.Alias.SecretKeyFactory.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        put("SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd128BitAESBC");
        put("SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd192BitAESBC");
        put("SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd256BitAESBC");
        put("SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA256And128BitAESBC");
        put("SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA256And192BitAESBC");
        put("SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA256And256BitAESBC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND128BITAES-CBC-BC","PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND192BITAES-CBC-BC","PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND256BITAES-CBC-BC","PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND128BITAES-CBC-BC","PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND192BITAES-CBC-BC","PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND256BITAES-CBC-BC","PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-CBC-BC","PBEWITHSHA256AND128BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-CBC-BC","PBEWITHSHA256AND192BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-CBC-BC","PBEWITHSHA256AND256BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes128_cbc.getId(), "PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes192_cbc.getId(), "PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes256_cbc.getId(), "PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes128_cbc.getId(), "PBEWITHSHA256AND128BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes192_cbc.getId(), "PBEWITHSHA256AND192BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes256_cbc.getId(), "PBEWITHSHA256AND256BITAES-CBC-BC");
        put("SecretKeyFactory.PBKDF2WithHmacSHA1", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBKDF2WithHmacSHA1");
        addMacAlgorithms();
        addMessageDigestAlgorithms();
        addSignatureAlgorithms();
        put("Alg.Alias.CertPathValidator.RFC3280", "PKIX");
        put("Alg.Alias.CertPathBuilder.RFC3280", "PKIX");
        put("CertPathValidator.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
        put("CertPathBuilder.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
        put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.617 -0400", hash_original_method = "686C79C0163D29E08379E22D5F4091D3", hash_generated_method = "225D7C032AB443D055AEF4D21BD6FD5C")
    private void loadAlgorithms(String packageName, String[] names) {
        addTaint(names[0].getTaint());
        addTaint(packageName.getTaint());
for(int i = 0;i != names.length;i++)
        {
            Class clazz = null;
            try 
            {
                ClassLoader loader = this.getClass().getClassLoader();
    if(loader != null)                
                {
                    clazz = loader.loadClass(packageName + names[i] + "$Mappings");
                } //End block
                else
                {
                    clazz = Class.forName(packageName + names[i] + "$Mappings");
                } //End block
            } //End block
            catch (ClassNotFoundException e)
            {
            } //End block
    if(clazz != null)            
            {
                try 
                {
                    addMappings((Map)clazz.newInstance());
                } //End block
                catch (Exception e)
                {
                    InternalError var3EA155D32E485A3F1F8962C0CB64AEFC_537463567 = new InternalError("cannot create instance of "
                        + packageName + names[i] + "$Mappings : " + e);
                    var3EA155D32E485A3F1F8962C0CB64AEFC_537463567.addTaint(taint);
                    throw var3EA155D32E485A3F1F8962C0CB64AEFC_537463567;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.620 -0400", hash_original_method = "5007A2B2A77D22A1FFE2768D1D69CD26", hash_generated_method = "447A07BF6A22B92A869044F857856329")
    private void addMappings(Map mappings) {
        addTaint(mappings.getTaint());
for(Iterator it = mappings.keySet().iterator();it.hasNext();)
        {
            Object key = it.next();
    if(containsKey(key))            
            {
                IllegalStateException varA1DEC78D76F37D52FBAF9A05AD18BAE8_529366671 = new IllegalStateException("duplicate provider key (" + key + ") found in " + mappings.getClass().getName());
                varA1DEC78D76F37D52FBAF9A05AD18BAE8_529366671.addTaint(taint);
                throw varA1DEC78D76F37D52FBAF9A05AD18BAE8_529366671;
            } //End block
            put(key, mappings.get(key));
        } //End block
        // ---------- Original Method ----------
        //for (Iterator it = mappings.keySet().iterator(); it.hasNext();)
        //{
            //Object key = it.next();
            //if (containsKey(key))
            //{
                //throw new IllegalStateException("duplicate provider key (" + key + ") found in " + mappings.getClass().getName());
            //}
            //put(key, mappings.get(key));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.622 -0400", hash_original_method = "BF810DB148D6F4B76C3D9477121B375F", hash_generated_method = "95ABA48C049175A237B5BDA048680B19")
    private void addMacAlgorithms() {
        addHMACAlgorithm("MD5", "org.bouncycastle.jce.provider.JCEMac$MD5", "org.bouncycastle.jce.provider.JCEKeyGenerator$MD5HMAC");
        addHMACAlias("MD5", IANAObjectIdentifiers.hmacMD5);
        addHMACAlgorithm("SHA1", "org.bouncycastle.jce.provider.JCEMac$SHA1", "org.bouncycastle.jce.provider.JCEKeyGenerator$HMACSHA1");
        addHMACAlias("SHA1", PKCSObjectIdentifiers.id_hmacWithSHA1);
        addHMACAlias("SHA1", IANAObjectIdentifiers.hmacSHA1);
        addHMACAlgorithm("SHA256", "org.bouncycastle.jce.provider.JCEMac$SHA256", "org.bouncycastle.jce.provider.JCEKeyGenerator$HMACSHA256");
        addHMACAlias("SHA256", PKCSObjectIdentifiers.id_hmacWithSHA256);
        addHMACAlgorithm("SHA384", "org.bouncycastle.jce.provider.JCEMac$SHA384", "org.bouncycastle.jce.provider.JCEKeyGenerator$HMACSHA384");
        addHMACAlias("SHA384", PKCSObjectIdentifiers.id_hmacWithSHA384);
        addHMACAlgorithm("SHA512", "org.bouncycastle.jce.provider.JCEMac$SHA512", "org.bouncycastle.jce.provider.JCEKeyGenerator$HMACSHA512");
        addHMACAlias("SHA512", PKCSObjectIdentifiers.id_hmacWithSHA512);
        put("Mac.PBEWITHHMACSHA", "org.bouncycastle.jce.provider.JCEMac$PBEWithSHA");
        put("Mac.PBEWITHHMACSHA1", "org.bouncycastle.jce.provider.JCEMac$PBEWithSHA");
        put("Alg.Alias.Mac.1.3.14.3.2.26", "PBEWITHHMACSHA");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.623 -0400", hash_original_method = "92FD2A26DA15B4D69904AC037AAE7782", hash_generated_method = "F38B9FB879FA1AE740AC29CDF34FAD31")
    private void addHMACAlgorithm(
        String algorithm,
        String algorithmClassName,
        String keyGeneratorClassName) {
        addTaint(keyGeneratorClassName.getTaint());
        addTaint(algorithmClassName.getTaint());
        addTaint(algorithm.getTaint());
        String mainName = "HMAC" + algorithm;
        put("Mac." + mainName, algorithmClassName);
        put("Alg.Alias.Mac.HMAC-" + algorithm, mainName);
        put("Alg.Alias.Mac.HMAC/" + algorithm, mainName);
        put("KeyGenerator." + mainName, keyGeneratorClassName);
        put("Alg.Alias.KeyGenerator.HMAC-" + algorithm, mainName);
        put("Alg.Alias.KeyGenerator.HMAC/" + algorithm, mainName);
        // ---------- Original Method ----------
        //String mainName = "HMAC" + algorithm;
        //put("Mac." + mainName, algorithmClassName);
        //put("Alg.Alias.Mac.HMAC-" + algorithm, mainName);
        //put("Alg.Alias.Mac.HMAC/" + algorithm, mainName);
        //put("KeyGenerator." + mainName, keyGeneratorClassName);
        //put("Alg.Alias.KeyGenerator.HMAC-" + algorithm, mainName);
        //put("Alg.Alias.KeyGenerator.HMAC/" + algorithm, mainName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.624 -0400", hash_original_method = "D71084920D31BEC8673D5601F90CF345", hash_generated_method = "0AA90759939D5D268EF7ECDACD8DE9D7")
    private void addHMACAlias(
        String              algorithm,
        DERObjectIdentifier oid) {
        addTaint(oid.getTaint());
        addTaint(algorithm.getTaint());
        String mainName = "HMAC" + algorithm;
        put("Alg.Alias.Mac." + oid, mainName);
        put("Alg.Alias.KeyGenerator." + oid, mainName);
        // ---------- Original Method ----------
        //String mainName = "HMAC" + algorithm;
        //put("Alg.Alias.Mac." + oid, mainName);
        //put("Alg.Alias.KeyGenerator." + oid, mainName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.625 -0400", hash_original_method = "D1811F612B066C9B05A7CE06AED0A036", hash_generated_method = "61C57A7CA772B2781B26B3B4F976E996")
    private void addMessageDigestAlgorithms() {
        put("MessageDigest.SHA-1", "org.bouncycastle.jce.provider.JDKMessageDigest$SHA1");
        put("Alg.Alias.MessageDigest.SHA1", "SHA-1");
        put("Alg.Alias.MessageDigest.SHA", "SHA-1");
        put("Alg.Alias.MessageDigest." + OIWObjectIdentifiers.idSHA1, "SHA-1");
        put("MessageDigest.SHA-256", "org.bouncycastle.jce.provider.JDKMessageDigest$SHA256");
        put("Alg.Alias.MessageDigest.SHA256", "SHA-256");
        put("Alg.Alias.MessageDigest." + NISTObjectIdentifiers.id_sha256, "SHA-256");
        put("MessageDigest.SHA-384", "org.bouncycastle.jce.provider.JDKMessageDigest$SHA384");
        put("Alg.Alias.MessageDigest.SHA384", "SHA-384");
        put("Alg.Alias.MessageDigest." + NISTObjectIdentifiers.id_sha384, "SHA-384");
        put("MessageDigest.SHA-512", "org.bouncycastle.jce.provider.JDKMessageDigest$SHA512");
        put("Alg.Alias.MessageDigest.SHA512", "SHA-512");
        put("Alg.Alias.MessageDigest." + NISTObjectIdentifiers.id_sha512, "SHA-512");
        put("MessageDigest.MD5", "org.bouncycastle.jce.provider.JDKMessageDigest$MD5");
        put("Alg.Alias.MessageDigest." + PKCSObjectIdentifiers.md5, "MD5");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.626 -0400", hash_original_method = "7420A66ACC92234B394212961D34DE13", hash_generated_method = "D116756CA2DB548349B7EEBE237D2169")
    private void addSignatureAlgorithms() {
        put("Signature.MD5WithRSAEncryption", "org.bouncycastle.jce.provider.JDKDigestSignature$MD5WithRSAEncryption");
        put("Signature.SHA1WithRSAEncryption", "org.bouncycastle.jce.provider.JDKDigestSignature$SHA1WithRSAEncryption");
        put("Signature.SHA256WithRSAEncryption", "org.bouncycastle.jce.provider.JDKDigestSignature$SHA256WithRSAEncryption");
        put("Signature.SHA384WithRSAEncryption", "org.bouncycastle.jce.provider.JDKDigestSignature$SHA384WithRSAEncryption");
        put("Signature.SHA512WithRSAEncryption", "org.bouncycastle.jce.provider.JDKDigestSignature$SHA512WithRSAEncryption");
        put("Signature.SHA1withDSA", "org.bouncycastle.jce.provider.JDKDSASigner$stdDSA");
        put("Signature.NONEWITHDSA", "org.bouncycastle.jce.provider.JDKDSASigner$noneDSA");
        put("Alg.Alias.Signature.RAWDSA", "NONEWITHDSA");
        put("Alg.Alias.Signature.MD5withRSAEncryption", "MD5WithRSAEncryption");
        put("Alg.Alias.Signature.SHA1withRSAEncryption", "SHA1WithRSAEncryption");
        put("Alg.Alias.Signature.SHA256withRSAEncryption", "SHA256WithRSAEncryption");
        put("Alg.Alias.Signature.SHA384withRSAEncryption", "SHA384WithRSAEncryption");
        put("Alg.Alias.Signature.SHA512withRSAEncryption", "SHA512WithRSAEncryption");
        put("Alg.Alias.Signature.SHA256WithRSAEncryption", "SHA256WithRSAEncryption");
        put("Alg.Alias.Signature.SHA384WithRSAEncryption", "SHA384WithRSAEncryption");
        put("Alg.Alias.Signature.SHA512WithRSAEncryption", "SHA512WithRSAEncryption");
        put("Alg.Alias.Signature.SHA256WITHRSAENCRYPTION", "SHA256WithRSAEncryption");
        put("Alg.Alias.Signature.SHA384WITHRSAENCRYPTION", "SHA384WithRSAEncryption");
        put("Alg.Alias.Signature.SHA512WITHRSAENCRYPTION", "SHA512WithRSAEncryption");
        put("Alg.Alias.Signature.MD5WithRSA", "MD5WithRSAEncryption");
        put("Alg.Alias.Signature.MD5withRSA", "MD5WithRSAEncryption");
        put("Alg.Alias.Signature.MD5/RSA", "MD5WithRSAEncryption");
        put("Alg.Alias.Signature." + PKCSObjectIdentifiers.md5WithRSAEncryption, "MD5WithRSAEncryption");
        put("Alg.Alias.Signature.SHA1WithRSA", "SHA1WithRSAEncryption");
        put("Alg.Alias.Signature.SHA1withRSA", "SHA1WithRSAEncryption");
        put("Alg.Alias.Signature.SHA256WithRSA", "SHA256WithRSAEncryption");
        put("Alg.Alias.Signature.SHA256withRSA", "SHA256WithRSAEncryption");
        put("Alg.Alias.Signature.SHA384WithRSA", "SHA384WithRSAEncryption");
        put("Alg.Alias.Signature.SHA384withRSA", "SHA384WithRSAEncryption");
        put("Alg.Alias.Signature.SHA512WithRSA", "SHA512WithRSAEncryption");
        put("Alg.Alias.Signature.SHA512withRSA", "SHA512WithRSAEncryption");
        put("Alg.Alias.Signature.SHA1/RSA", "SHA1WithRSAEncryption");
        put("Alg.Alias.Signature.SHA-1/RSA", "SHA1WithRSAEncryption");
        put("Alg.Alias.Signature." + PKCSObjectIdentifiers.sha1WithRSAEncryption, "SHA1WithRSAEncryption");
        put("Alg.Alias.Signature." + PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WithRSAEncryption");
        put("Alg.Alias.Signature." + PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WithRSAEncryption");
        put("Alg.Alias.Signature." + PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WithRSAEncryption");
        put("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.113549.1.1.1", "SHA1WithRSAEncryption");
        put("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.113549.1.1.5", "SHA1WithRSAEncryption");
        put("Alg.Alias.Signature.1.2.840.113549.2.5with1.2.840.113549.1.1.1", "MD5WithRSAEncryption");
        put("Alg.Alias.Signature." + OIWObjectIdentifiers.sha1WithRSA, "SHA1WithRSAEncryption");
        put("Alg.Alias.Signature.MD5WITHRSAENCRYPTION", "MD5WithRSAEncryption");
        put("Alg.Alias.Signature.SHA1WITHRSAENCRYPTION", "SHA1WithRSAEncryption");
        put("Alg.Alias.Signature.MD5WITHRSA", "MD5WithRSAEncryption");
        put("Alg.Alias.Signature.SHA1WITHRSA", "SHA1WithRSAEncryption");
        put("Alg.Alias.Signature.SHA/DSA", "SHA1withDSA");
        put("Alg.Alias.Signature.DSA", "SHA1withDSA");
        put("Alg.Alias.Signature.SHA1WITHDSA", "SHA1withDSA");
        put("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.1", "SHA1withDSA");
        put("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.3", "SHA1withDSA");
        put("Alg.Alias.Signature.DSAwithSHA1", "SHA1withDSA");
        put("Alg.Alias.Signature.DSAWITHSHA1", "SHA1withDSA");
        put("Alg.Alias.Signature.SHA1WithDSA", "SHA1withDSA");
        put("Alg.Alias.Signature.DSAWithSHA1", "SHA1withDSA");
        put("Alg.Alias.Signature.1.2.840.10040.4.3", "SHA1withDSA");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.627 -0400", hash_original_method = "393A7CD364AF31C5A55C410D9408BF1B", hash_generated_method = "A781EBC5145097C47689343C509D64EA")
    public void setParameter(String parameterName, Object parameter) {
        addTaint(parameter.getTaint());
        addTaint(parameterName.getTaint());
        ProviderUtil.setParameter(parameterName, parameter);
        // ---------- Original Method ----------
        //ProviderUtil.setParameter(parameterName, parameter);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.627 -0400", hash_original_field = "EFCE9076F905F6AB2421FDE0E0709672", hash_generated_field = "C9727C0638F2013F7B780A7BE1307CFA")

    private static String info = "BouncyCastle Security Provider v1.46";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.628 -0400", hash_original_field = "190060DC3C6933C39F9236A12F12F308", hash_generated_field = "62C3A5533E09FBDFC029A03CDDABF7BF")

    public static final String PROVIDER_NAME = "BC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.628 -0400", hash_original_field = "3F8D3CDCBB5EF8968FEAD8BB1668DA02", hash_generated_field = "0A663C871099B559824C37D3820D09A2")

    private static final String SYMMETRIC_CIPHER_PACKAGE = "org.bouncycastle.jce.provider.symmetric.";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.628 -0400", hash_original_field = "3C7CA3E7EA665113791B5760E99FE126", hash_generated_field = "25739864BEADDDF7A786902850852322")

    private static final String[] SYMMETRIC_CIPHERS = {
        
        
        
        
        
        "AES", "ARC4", "Blowfish", "DESede",
        

    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.628 -0400", hash_original_field = "86860D4B3445557E708FB997A86305C9", hash_generated_field = "30A48E7B93E404115A86D1135E5F52C1")

    private static final String ASYMMETRIC_CIPHER_PACKAGE = "org.bouncycastle.jce.provider.asymmetric.";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.628 -0400", hash_original_field = "C742CE8AE2425975342F20B2FB53C8D3", hash_generated_field = "B6CD2954F790C650C1566977B7063BED")

    private static final String[] ASYMMETRIC_CIPHERS = {
        "EC"
    };
}

