package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import javax.crypto.Cipher;






public class CipherSuite {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.239 -0500", hash_original_method = "3EDAD5A5AC099D703E8FCE466C4E49F5", hash_generated_method = "00A2549BB4245DF3C178A5F6BBDAE142")
    
private static int registerCipherSuitesByCode(CipherSuite[] cipherSuites) {
        int count = 0;
        for (int i = 0; i < cipherSuites.length; i++) {
            if (cipherSuites[i] == SSL_NULL_WITH_NULL_NULL) {
                continue;
            }
            if (cipherSuites[i] == null) {
                continue;
            }
            SUITES_BY_NAME.put(cipherSuites[i].getName(), cipherSuites[i]);
            if (cipherSuites[i].supported) {
                count++;
            }
        }
        return count;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.242 -0500", hash_original_method = "C64CB9829E7452D1122FA6C3039DF879", hash_generated_method = "B70BF757C96E2408F00CF51D4AB26CC4")
    
private static void registerSupportedCipherSuites(int offset, CipherSuite[] cipherSuites) {
        int count = offset;
        for (int i = 0; i < cipherSuites.length; i++) {
            if (cipherSuites[i] == SSL_NULL_WITH_NULL_NULL) {
                continue;
            }
            if (cipherSuites[i] == null) {
                continue;
            }
            if (cipherSuites[i].supported) {
                SUPPORTED_CIPHER_SUITES[count] = cipherSuites[i];
                SUPPORTED_CIPHER_SUITE_NAMES[count] = SUPPORTED_CIPHER_SUITES[count].getName();
                count++;
            }
        }
    }

    /**
     * Returns CipherSuite by name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.244 -0500", hash_original_method = "19655685C35742CC7B9539D784924513", hash_generated_method = "2270898CC731B7396F8B9F2C7674A779")
    
public static CipherSuite getByName(String name) {
        return SUITES_BY_NAME.get(name);
    }

    /**
     * Returns CipherSuite based on TLS CipherSuite code
     * @see <a href="http://www.ietf.org/rfc/rfc2246.txt">TLS 1.0 spec., A.5. The CipherSuite</a>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.247 -0500", hash_original_method = "9A699819E1F6B25CCCE0C9197119752B", hash_generated_method = "8DC1B1D9BD512A041DB98B8AD064BDA4")
    
public static CipherSuite getByCode(byte b1, byte b2) {
        int i1 = b1 & 0xff;
        int i2 = b2 & 0xff;
        CipherSuite cs = getCipherSuiteByCode(0, i1, i2);
        if (cs != null) {
            return cs;
        }
        return new CipherSuite("UNKNOWN_" + i1 + "_" + i2, false, 0, null,
                               null, null, new byte[] { b1, b2 });
    }

    /**
     * Returns CipherSuite based on V2CipherSpec code
     * as described in TLS 1.0 spec., E. Backward Compatibility With SSL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.250 -0500", hash_original_method = "7FC29106569D1D54FC46639E4695B58C", hash_generated_method = "291DCC66DA72234C5DDB531A58986FB5")
    
public static CipherSuite getByCode(byte b1, byte b2, byte b3) {
        int i1 = b1 & 0xff;
        int i2 = b2 & 0xff;
        int i3 = b3 & 0xff;
        CipherSuite cs = getCipherSuiteByCode(i1, i2, i3);
        if (cs != null) {
            return cs;
        }
        return new CipherSuite("UNKNOWN_" + i1 + "_" + i2 + "_" + i3, false, 0,
                               null, null, null, new byte[] { b1, b2, b3 });
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.252 -0500", hash_original_method = "E7DEF15CD79A5AD2F1096800ACDA8969", hash_generated_method = "728CCF898792DE4B42FF50F9804AD8C2")
    
private static CipherSuite getCipherSuiteByCode(int i1, int i2, int i3) {
        CipherSuite[] cipherSuites;
        if (i1 == 0x00 && i2 == 0x00) {
            cipherSuites = SUITES_BY_CODE_0x00;
        } else if (i1 == 0x00 && i2 == 0xc0) {
            cipherSuites = SUITES_BY_CODE_0xc0;
        } else {
            return null;
        }
        if (i3 >= cipherSuites.length) {
            return null;
        }
        return cipherSuites[i3];
    }

    /**
     * Returns array of supported CipherSuites
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.262 -0500", hash_original_method = "479A55B470634F94D9EDADBBEBCC7F31", hash_generated_method = "E83B3795BEB1C1D0E8EA1C6AADBBED99")
    
public static CipherSuite[] getSupported() {
        return SUPPORTED_CIPHER_SUITES;
    }

    /**
     * Returns array of supported cipher suites names
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.264 -0500", hash_original_method = "18FDF3B6EC05378F84422E748DCE12AC", hash_generated_method = "002FCAB1E7DDDC1B0B1B77303F0C3FFE")
    
public static String[] getSupportedCipherSuiteNames() {
        return SUPPORTED_CIPHER_SUITE_NAMES.clone();
    }

    /**
     * Similar to getServerKeyType, but returns value given TLS
     * ClientCertificateType byte values from a CertificateRequest
     * message for use with X509KeyManager.chooseClientAlias or
     * X509ExtendedKeyManager.chooseEngineClientAlias.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.321 -0500", hash_original_method = "87CAB1CF5F8CE8DF70B5B1746E78341B", hash_generated_method = "88E475DA09EADDE33A86758BC3867D59")
    
public static String getClientKeyType(byte keyType) {
        // See also http://www.ietf.org/assignments/tls-parameters/tls-parameters.xml
        switch (keyType) {
            case TLS_CT_RSA_SIGN:
                return KEY_TYPE_RSA; // RFC rsa_sign
            case TLS_CT_DSS_SIGN:
                return KEY_TYPE_DSA; // RFC dss_sign
            case TLS_CT_RSA_FIXED_DH:
                return KEY_TYPE_DH_RSA; // RFC rsa_fixed_dh
            case TLS_CT_DSS_FIXED_DH:
                return KEY_TYPE_DH_DSA; // RFC dss_fixed_dh
            case TLS_CT_ECDSA_SIGN:
                return KEY_TYPE_EC; // RFC ecdsa_sign
            case TLS_CT_RSA_FIXED_ECDH:
                return KEY_TYPE_EC_RSA; // RFC rsa_fixed_ecdh
            case TLS_CT_ECDSA_FIXED_ECDH:
                return KEY_TYPE_EC_EC; // RFC ecdsa_fixed_ecdh
            default:
                return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.929 -0500", hash_original_field = "621625FDC1F88B1E6761603976993DA4", hash_generated_field = "B56B086D65833926B963E4AF5198F74B")

    static final int KEY_EXCHANGE_RSA = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.931 -0500", hash_original_field = "A5DD60EB3098ED2D0C3EE40C329F00FC", hash_generated_field = "B66542296B758B9957EFEE140FD5AF2D")

    static final int KEY_EXCHANGE_RSA_EXPORT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.933 -0500", hash_original_field = "D05AEA1742609C82BFC0ACDBB7BEF7C8", hash_generated_field = "1A61B4E3339FDC1CC8A25C32A0BAC082")

    static final int KEY_EXCHANGE_DHE_DSS = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.936 -0500", hash_original_field = "2BE45EEE224AC2982BDDF95CA3D39808", hash_generated_field = "059AD6EFEA99DFA24C0F5B1726DC7E2D")

    static final int KEY_EXCHANGE_DHE_DSS_EXPORT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.938 -0500", hash_original_field = "BD362E8F3A58C59F8B58780F40F3B4B0", hash_generated_field = "DC1215809568225DD9D5EF7AE9619110")

    static final int KEY_EXCHANGE_DHE_RSA = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.940 -0500", hash_original_field = "212EA5978A519980347F413251822941", hash_generated_field = "48966917CF5B65C75B194D1E6ACBF65B")

    static final int KEY_EXCHANGE_DHE_RSA_EXPORT = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.943 -0500", hash_original_field = "94CCA50E7658464186523DA1B988F8F7", hash_generated_field = "D65CE8995E52285E56D36B072BE963EE")

    // static final int KEY_EXCHANGE_DH_DSS = 7;
    // static final int KEY_EXCHANGE_DH_RSA = 8;
    // END android-removed
    static final int KEY_EXCHANGE_DH_anon = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.945 -0500", hash_original_field = "F6CA143B8F440C7AC6422DA90F3FB03E", hash_generated_field = "5FC61A81184103CD6DFEB040E7A04816")

    static final int KEY_EXCHANGE_DH_anon_EXPORT = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.947 -0500", hash_original_field = "94E1868D33F7C453F8A1F334685D67E2", hash_generated_field = "286DEE99571F2CA85AEBF7BCA203F154")

    // static final int KEY_EXCHANGE_DH_DSS_EXPORT = 11;
    // static final int KEY_EXCHANGE_DH_RSA_EXPORT = 12;
    // END android-removed
    static final int KEY_EXCHANGE_ECDH_ECDSA = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.949 -0500", hash_original_field = "F14A777B7D20985C5E33DFB4C2C7CF01", hash_generated_field = "0AD5910A2A0361105C7A2BD3D17D3964")

    static final int KEY_EXCHANGE_ECDHE_ECDSA = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.953 -0500", hash_original_field = "413CB8466BFEB298748E9DC83420AA75", hash_generated_field = "8C121FC40EE8784B01445F817BD220E7")

    static final int KEY_EXCHANGE_ECDH_RSA = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.955 -0500", hash_original_field = "2AB0FF6534171021AC17749B4FB15779", hash_generated_field = "AB29779250E9AF2222BCA0BCBCEE6076")

    static final int KEY_EXCHANGE_ECDHE_RSA = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.957 -0500", hash_original_field = "14AB47979618530384A96A5602D9B7A0", hash_generated_field = "F9CDE2A1A91C64104E21D12C62431B21")

    static final int KEY_EXCHANGE_ECDH_anon = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.959 -0500", hash_original_field = "FEF1B67E55B6B8472A242CE99F272C0B", hash_generated_field = "691A74F5F2E3A2498B80995CBE553220")

    static final byte[] CODE_SSL_NULL_WITH_NULL_NULL = { 0x00, 0x00 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.961 -0500", hash_original_field = "D34A4ED2B892BAE3CC6CB62151C29A14", hash_generated_field = "498B1E3AEFAF89FC4250B1E83665AF52")

    static final byte[] CODE_SSL_RSA_WITH_NULL_MD5 = { 0x00, 0x01 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.964 -0500", hash_original_field = "B66A41E49D66E5B858DFB09786A1238D", hash_generated_field = "DCB8463CB8272650290200FA14FFEB17")

    static final byte[] CODE_SSL_RSA_WITH_NULL_SHA = { 0x00, 0x02 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.967 -0500", hash_original_field = "5CB49E03D5A8E14903ED7385D799903D", hash_generated_field = "E92FF662CD9967AA82FAD8BDD7AE725B")

    static final byte[] CODE_SSL_RSA_EXPORT_WITH_RC4_40_MD5 = { 0x00, 0x03 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.969 -0500", hash_original_field = "4008BC31080F17E91DBE77DEE938C127", hash_generated_field = "F01D3100C0E9471B5C5CA537535676E0")

    static final byte[] CODE_SSL_RSA_WITH_RC4_128_MD5 = { 0x00, 0x04 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.971 -0500", hash_original_field = "D193C03FED63FCEE5A98D46B146D0729", hash_generated_field = "409CC22954017A4D525562B15E56E2A4")

    static final byte[] CODE_SSL_RSA_WITH_RC4_128_SHA = { 0x00, 0x05 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.973 -0500", hash_original_field = "C5E7A4214ED7FD2C0E800B9CCDB34C9B", hash_generated_field = "2EA77D4F72485CDB2EC1B3A8CA8CF41C")

    static final byte[] CODE_SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5 = { 0x00, 0x06 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.976 -0500", hash_original_field = "7BADBB59C71017CC96E58617197A2894", hash_generated_field = "A051DC62737BF775469D2FDCFA403919")

    // static final byte[] CODE_TLS_RSA_WITH_IDEA_CBC_SHA = { 0x00, 0x07 };
    // END android-removed
    static final byte[] CODE_SSL_RSA_EXPORT_WITH_DES40_CBC_SHA = { 0x00, 0x08 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.978 -0500", hash_original_field = "565DB87C17DE96B665A775DED11AD182", hash_generated_field = "BE507D2D710669EBF24E4361C8BCF164")

    static final byte[] CODE_SSL_RSA_WITH_DES_CBC_SHA = { 0x00, 0x09 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.980 -0500", hash_original_field = "85AD1D1C80B9E63084BE2B03643E9BD2", hash_generated_field = "C79A008AC20D74C0E8E14A45F529D5ED")

    static final byte[] CODE_SSL_RSA_WITH_3DES_EDE_CBC_SHA = { 0x00, 0x0A };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.983 -0500", hash_original_field = "889A3036C140E16B256F5EB85D9A0052", hash_generated_field = "D94474B4BA3E5BB55CDC6867A92A4F86")

    // static final byte[] CODE_SSL_DH_DSS_EXPORT_WITH_DES40_CBC_SHA = { 0x00, 0x0B };
    // static final byte[] CODE_SSL_DH_DSS_WITH_DES_CBC_SHA = { 0x00, 0x0C };
    // static final byte[] CODE_SSL_DH_DSS_WITH_3DES_EDE_CBC_SHA = { 0x00, 0x0D };
    // static final byte[] CODE_SSL_DH_RSA_EXPORT_WITH_DES40_CBC_SHA = { 0x00, 0x0E };
    // static final byte[] CODE_SSL_DH_RSA_WITH_DES_CBC_SHA = { 0x00, 0x0F };
    // static final byte[] CODE_SSL_DH_RSA_WITH_3DES_EDE_CBC_SHA = { 0x00, 0x10 };
    // END android-removed
    static final byte[] CODE_SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = { 0x00, 0x11 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.985 -0500", hash_original_field = "09F70C87AE90CD78250D5BFDD4804FAC", hash_generated_field = "420AC1DC34391965668836FB6AB6665A")

    static final byte[] CODE_SSL_DHE_DSS_WITH_DES_CBC_SHA = { 0x00, 0x12 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.988 -0500", hash_original_field = "77A1097F0552DC9B5DC9C710BB4ED631", hash_generated_field = "48990AA7D466229F36BFB8F85C83425B")

    static final byte[] CODE_SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA = { 0x00, 0x13 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.990 -0500", hash_original_field = "FAD6FF92F1BDE63F6F26C4A00C494F93", hash_generated_field = "A36779D51A4F225EDD9323C887E26656")

    static final byte[] CODE_SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = { 0x00, 0x14 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.992 -0500", hash_original_field = "06DCE54FF6392C211C1C17417972E729", hash_generated_field = "E34A499C78E2646E57D3F05C4FBB5594")

    static final byte[] CODE_SSL_DHE_RSA_WITH_DES_CBC_SHA = { 0x00, 0x15 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.995 -0500", hash_original_field = "C241F4185DAEC23CACBB2B83B796AAA5", hash_generated_field = "CFF536299D7214DCFA136EDE2BDBF250")

    static final byte[] CODE_SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA = { 0x00, 0x16 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.997 -0500", hash_original_field = "732EF4EEB0028059BAD660DBD8A753CE", hash_generated_field = "DE8CE08DFD9968C5CA3085537C963036")

    static final byte[] CODE_SSL_DH_anon_EXPORT_WITH_RC4_40_MD5 = { 0x00, 0x17 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.999 -0500", hash_original_field = "A89CC5D755AF81EFD465C9236C4C0B64", hash_generated_field = "F371353851B0F22CB36B1B68DBCCCA3A")

    static final byte[] CODE_SSL_DH_anon_WITH_RC4_128_MD5 = { 0x00, 0x18 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.002 -0500", hash_original_field = "BA616CE96D20DF71A60C06B400E4C1DC", hash_generated_field = "F765C240FA984CBDA5C1C4006D66E442")

    static final byte[] CODE_SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA = { 0x00, 0x19 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.004 -0500", hash_original_field = "B5D3CB59A6CAF63878DFF68F7B4C1B85", hash_generated_field = "70245C03EE4DD2E11B62D532AFCA7B80")

    static final byte[] CODE_SSL_DH_anon_WITH_DES_CBC_SHA = { 0x00, 0x1A };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.006 -0500", hash_original_field = "CABECCBC106891B3149DB736271AE51F", hash_generated_field = "E64B24F125E5C3EC93A01847318CE4BC")

    static final byte[] CODE_SSL_DH_anon_WITH_3DES_EDE_CBC_SHA = { 0x00, 0x1B };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.009 -0500", hash_original_field = "22AC5250AED78C4C1543FB7A2E15B9F3", hash_generated_field = "AE11B6E320C70AAB3548539580FC9BE4")

    static final byte[] CODE_TLS_RSA_WITH_AES_128_CBC_SHA = { 0x00, 0x2F };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.011 -0500", hash_original_field = "4B163BAF150462517CEBD9227F97BF16", hash_generated_field = "E88E26C450867A6D019E3FAD43072129")

    //static final byte[] CODE_TLS_DH_RSA_WITH_AES_128_CBC_SHA = { 0x00, 0x31 };
    static final byte[] CODE_TLS_DHE_DSS_WITH_AES_128_CBC_SHA = { 0x00, 0x32 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.014 -0500", hash_original_field = "5B967D3B7AD3FDAC5A55B004049D3A2F", hash_generated_field = "FDBD59C32846AE644F34F1B1B56C5767")

    static final byte[] CODE_TLS_DHE_RSA_WITH_AES_128_CBC_SHA = { 0x00, 0x33 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.016 -0500", hash_original_field = "1A6BC781D16765F40938AAB7FC60AF0E", hash_generated_field = "AA3F905B1F17C9F7ABBAE7BF7AE56512")

    static final byte[] CODE_TLS_DH_anon_WITH_AES_128_CBC_SHA = { 0x00, 0x34 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.019 -0500", hash_original_field = "9BE27ABB8422A33BD92372C5D196B49F", hash_generated_field = "45791EBD5EB689F0EE6CA139598A6AB7")

    static final byte[] CODE_TLS_RSA_WITH_AES_256_CBC_SHA = { 0x00, 0x35 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.021 -0500", hash_original_field = "A241C49EC064F028180BE65207393F68", hash_generated_field = "F9A4BB07FCBBDB74B824B73E5919C8BB")

    //static final byte[] CODE_TLS_DH_RSA_WITH_AES_256_CBC_SHA = { 0x00, 0x37 };
    static final byte[] CODE_TLS_DHE_DSS_WITH_AES_256_CBC_SHA = { 0x00, 0x38 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.024 -0500", hash_original_field = "98B48B9E1F8B2076D36FB513D3314AD3", hash_generated_field = "EAA98B78CD032436CF016EF871DDBA34")

    static final byte[] CODE_TLS_DHE_RSA_WITH_AES_256_CBC_SHA = { 0x00, 0x39 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.026 -0500", hash_original_field = "27A0C6F3713F9905D46A5314F25C6597", hash_generated_field = "8967C134F191B5699B73056DC11B2EB3")

    static final byte[] CODE_TLS_DH_anon_WITH_AES_256_CBC_SHA = { 0x00, 0x3A };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.028 -0500", hash_original_field = "18388A300C575E89243237B8FFC6AE3A", hash_generated_field = "AA24F64E0406CE87B78B3C1D4EF6F819")

    static final byte[] CODE_TLS_ECDH_ECDSA_WITH_NULL_SHA = { (byte) 0xc0, 0x01};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.031 -0500", hash_original_field = "30425BEB72724247BB8FDFF4901F5C8F", hash_generated_field = "41F9ECB15AE7AF8BFA80616C87D18890")

    static final byte[] CODE_TLS_ECDH_ECDSA_WITH_RC4_128_SHA = { (byte) 0xc0, 0x02};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.033 -0500", hash_original_field = "7FB90030EE6C10A132F6484ECA6D4F74", hash_generated_field = "E24EE271E81AF477A40B950AA965A88C")

    static final byte[] CODE_TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = { (byte) 0xc0, 0x03};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.035 -0500", hash_original_field = "E91AFBE6293AA174A2B797C9F7018167", hash_generated_field = "5F1C7B8AAA3A95ACA011C685AEF1B89E")

    static final byte[] CODE_TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = { (byte) 0xc0, 0x04};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.038 -0500", hash_original_field = "8906E73FE2296EEC556580F2A27490F2", hash_generated_field = "366A79B525DD4E16859BC8F1FD5472A1")

    static final byte[] CODE_TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = { (byte) 0xc0, 0x05};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.040 -0500", hash_original_field = "7697E2813CCECE33C14BCFEBF62C0EE7", hash_generated_field = "2598FFBD2440EDFCBBF25AD8F2CA282A")

    static final byte[] CODE_TLS_ECDHE_ECDSA_WITH_NULL_SHA = { (byte) 0xc0, 0x06};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.042 -0500", hash_original_field = "1D384E9B21B4B1398F9ECA95B1E2938D", hash_generated_field = "5F439F1E65E070144791DE839EAD21BE")

    static final byte[] CODE_TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = { (byte) 0xc0, 0x07};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.045 -0500", hash_original_field = "6E9406A53B6D98AF18C0FB47C0E34DF3", hash_generated_field = "1EDD05DC1FD915A171C3215B2A8C28D5")

    static final byte[] CODE_TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = { (byte) 0xc0, 0x08};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.047 -0500", hash_original_field = "6B8994E2BE3F03D3E405E1136DD86034", hash_generated_field = "DBF394E607BAB98178F04F1B1897ED6F")

    static final byte[] CODE_TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = { (byte) 0xc0, 0x09};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.049 -0500", hash_original_field = "BF01CD70C252B0DEC757FD0253C80FF7", hash_generated_field = "6D155269B07669C82EE373613C434B85")

    static final byte[] CODE_TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = { (byte) 0xc0, 0x0A};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.051 -0500", hash_original_field = "EDF145A3A9312B98DBB6D6F13F201258", hash_generated_field = "DE8F7262A72EDF87FFBA05AEC440638D")

    static final byte[] CODE_TLS_ECDH_RSA_WITH_NULL_SHA = { (byte) 0xc0, 0x0B};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.053 -0500", hash_original_field = "241D5E1EF6A377D2114AF5ED7D2FF978", hash_generated_field = "ED87E6BE8A591AE239EE8ECB871C932B")

    static final byte[] CODE_TLS_ECDH_RSA_WITH_RC4_128_SHA = { (byte) 0xc0, 0x0C};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.056 -0500", hash_original_field = "B8A65F7169C3B5EDD3031A9B9819E1BC", hash_generated_field = "7821C69594E6E6928295ABFE95C182ED")

    static final byte[] CODE_TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = { (byte) 0xc0, 0x0D};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.059 -0500", hash_original_field = "4056F34102859ED51360F10413950930", hash_generated_field = "0F918AC9CB049766DD69AF3D2B39533B")

    static final byte[] CODE_TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = { (byte) 0xc0, 0x0E};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.061 -0500", hash_original_field = "D88D4F1C850C42C215CEE037C26B4574", hash_generated_field = "CCEBDAE2E1217BB8BC16B24E7008AD79")

    static final byte[] CODE_TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = { (byte) 0xc0, 0x0F};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.063 -0500", hash_original_field = "A6FF780B31CA95287D7AEAC408A13C0A", hash_generated_field = "4DC7F5601C6A8AD68292CFA1BC1C76F3")

    static final byte[] CODE_TLS_ECDHE_RSA_WITH_NULL_SHA = { (byte) 0xc0, 0x10};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.065 -0500", hash_original_field = "404E04D71A9C0F2AE5C71540F6098CE0", hash_generated_field = "C6408578BDEA4E69D3F5D225D9800A3D")

    static final byte[] CODE_TLS_ECDHE_RSA_WITH_RC4_128_SHA = { (byte) 0xc0, 0x11};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.068 -0500", hash_original_field = "67B136D358B092B8B5E09E4DA33BDD78", hash_generated_field = "DE8F7219901624D504B06D40801700A1")

    static final byte[] CODE_TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = { (byte) 0xc0, 0x12};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.070 -0500", hash_original_field = "0F3C3EF5EA2A3BB2EFEAA06FC49780AB", hash_generated_field = "829A6BBC52450E74E9E8373797A9DB7C")

    static final byte[] CODE_TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = { (byte) 0xc0, 0x13};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.073 -0500", hash_original_field = "45A0BA368729FBCC89814099688E86DA", hash_generated_field = "24AFF62C926A460F1977514BA3EDCF67")

    static final byte[] CODE_TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = { (byte) 0xc0, 0x14};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.076 -0500", hash_original_field = "9B899A732BE0BE38D63D9080AB2EA818", hash_generated_field = "8978DA832F3434B00921FD0DDDCA7318")

    static final byte[] CODE_TLS_ECDH_anon_WITH_NULL_SHA = { (byte) 0xc0, 0x15};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.078 -0500", hash_original_field = "5A3833A7CBD74510CE432D5A035297C1", hash_generated_field = "FDA21DCB4721F2D1082DB7831BB3458B")

    static final byte[] CODE_TLS_ECDH_anon_WITH_RC4_128_SHA = { (byte) 0xc0, 0x16};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.080 -0500", hash_original_field = "59EF06B41CF5E2B1C934A6CE88A3FA20", hash_generated_field = "FC46CF198DE7F02B42FCAE42D28C1303")

    static final byte[] CODE_TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = { (byte) 0xc0, 0x17};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.083 -0500", hash_original_field = "21269432ED02E488A7009048E00263B8", hash_generated_field = "4702931BE6A98AAA07830978076CCF70")

    static final byte[] CODE_TLS_ECDH_anon_WITH_AES_128_CBC_SHA = { (byte) 0xc0, 0x18};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.085 -0500", hash_original_field = "7655B9C999AF44FDE240DAB1AE380C0B", hash_generated_field = "3C66B1C99DF6E262D8538F87B599A4AA")

    static final byte[] CODE_TLS_ECDH_anon_WITH_AES_256_CBC_SHA = { (byte) 0xc0, 0x19};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.088 -0500", hash_original_field = "A7B66C598CCAC455DFA7D86680F6DBF4", hash_generated_field = "4EC2DAA3C01937C6CDA5F9177EF51C83")


    static final CipherSuite SSL_NULL_WITH_NULL_NULL = new CipherSuite(
            "SSL_NULL_WITH_NULL_NULL", true, 0, null, null, null,
            CODE_SSL_NULL_WITH_NULL_NULL);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.090 -0500", hash_original_field = "4F2A4C13001D67ADFD1A649247A7528E", hash_generated_field = "D7C3DA33765CBCB9FD34C9AB9549F186")


    static final CipherSuite SSL_RSA_WITH_NULL_MD5 = new CipherSuite(
            "SSL_RSA_WITH_NULL_MD5", true, KEY_EXCHANGE_RSA, "RSA", null, "MD5",
            CODE_SSL_RSA_WITH_NULL_MD5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.092 -0500", hash_original_field = "579D80CE417162CADC52D411AB36F41E", hash_generated_field = "AFFBA3F15943DDC119CF36F05988EA26")


    static final CipherSuite SSL_RSA_WITH_NULL_SHA = new CipherSuite(
            "SSL_RSA_WITH_NULL_SHA", true, KEY_EXCHANGE_RSA, "RSA", null, "SHA",
            CODE_SSL_RSA_WITH_NULL_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.094 -0500", hash_original_field = "FDF7184EC7F8533ABA21C08A4072EE68", hash_generated_field = "19AA66EC2BD1A1DA3E429C4B80F879DE")


    static final CipherSuite SSL_RSA_EXPORT_WITH_RC4_40_MD5 = new CipherSuite(
            "SSL_RSA_EXPORT_WITH_RC4_40_MD5", true, KEY_EXCHANGE_RSA_EXPORT,
            "RSA", "RC4_40", "MD5", CODE_SSL_RSA_EXPORT_WITH_RC4_40_MD5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.097 -0500", hash_original_field = "C9678D75BAF79D3C7FD5E889AD22204A", hash_generated_field = "8177CEF281F978E2D98457E1A4DCFB50")


    static final CipherSuite SSL_RSA_WITH_RC4_128_MD5 = new CipherSuite(
            "SSL_RSA_WITH_RC4_128_MD5", false, KEY_EXCHANGE_RSA, "RSA", "RC4_128",
            "MD5", CODE_SSL_RSA_WITH_RC4_128_MD5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.099 -0500", hash_original_field = "6C69D6A5AEB29BB28F52FD08F5D8E29C", hash_generated_field = "2AAA5288D81DCBC2B0F8F241DC6DD0D8")


    static final CipherSuite SSL_RSA_WITH_RC4_128_SHA = new CipherSuite(
            "SSL_RSA_WITH_RC4_128_SHA", false, KEY_EXCHANGE_RSA, "RSA", "RC4_128",
            "SHA", CODE_SSL_RSA_WITH_RC4_128_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.102 -0500", hash_original_field = "ACE8DC9ACF5CAF8D479807F46EBF77EF", hash_generated_field = "E8A8CA45BF6254408A32D77635496D75")


    static final CipherSuite SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5 = new CipherSuite(
            "SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5", true, KEY_EXCHANGE_RSA_EXPORT,
            "RSA", "RC2_CBC_40", "MD5", CODE_SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.104 -0500", hash_original_field = "D1CEBDA943927CFD27D7ECCA1746980E", hash_generated_field = "40CCE0E758C28DD1DA3B97F878E16A21")

    // static final CipherSuite TLS_RSA_WITH_IDEA_CBC_SHA = new CipherSuite(
    //         "TLS_RSA_WITH_IDEA_CBC_SHA", false, KEY_EXCHANGE_RSA, "RSA", "IDEA_CBC",
    //         "SHA", CODE_TLS_RSA_WITH_IDEA_CBC_SHA);
    // END android-removed

    static final CipherSuite SSL_RSA_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", true, KEY_EXCHANGE_RSA_EXPORT,
            "RSA", "DES40_CBC", "SHA", CODE_SSL_RSA_EXPORT_WITH_DES40_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.107 -0500", hash_original_field = "F9CA122961E34DE7804C8FAA8E1B3F02", hash_generated_field = "9CE80D4E1B086789B2805DE088E34D37")


    static final CipherSuite SSL_RSA_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_RSA_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_RSA, "RSA", "DES_CBC",
            "SHA", CODE_SSL_RSA_WITH_DES_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.109 -0500", hash_original_field = "5FB30F48AB357B4FB08F5B2C34E694E9", hash_generated_field = "48F8F23E83304B9714D84D5554A4AD64")


    static final CipherSuite SSL_RSA_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_RSA_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_RSA,
            "RSA", "3DES_EDE_CBC", "SHA", CODE_SSL_RSA_WITH_3DES_EDE_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.112 -0500", hash_original_field = "534E7D32E0B79A7F1ECC6F44C94F1E2E", hash_generated_field = "4C80454FD39B5B3EB6CCC52A3494815A")

    // static final CipherSuite SSL_DH_DSS_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
    //         "SSL_DH_DSS_EXPORT_WITH_DES40_CBC_SHA", true,
    //         KEY_EXCHANGE_DH_DSS_EXPORT, "DH", "DES40_CBC", "SHA",
    //         CODE_SSL_DH_DSS_EXPORT_WITH_DES40_CBC_SHA);
    //
    // static final CipherSuite SSL_DH_DSS_WITH_DES_CBC_SHA = new CipherSuite(
    //         "SSL_DH_DSS_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_DH_DSS,
    //         "DH", "DES_CBC", "SHA", CODE_SSL_DH_DSS_WITH_DES_CBC_SHA);
    //
    // static final CipherSuite SSL_DH_DSS_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
    //         "SSL_DH_DSS_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_DH_DSS,
    //         "DH", "3DES_EDE_CBC", "SHA", CODE_SSL_DH_DSS_WITH_3DES_EDE_CBC_SHA);
    //
    // static final CipherSuite SSL_DH_RSA_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
    //         "SSL_DH_RSA_EXPORT_WITH_DES40_CBC_SHA", true,
    //         KEY_EXCHANGE_DH_RSA_EXPORT, "DH", "DES40_CBC", "SHA",
    //         CODE_SSL_DH_RSA_EXPORT_WITH_DES40_CBC_SHA);
    //
    // static final CipherSuite SSL_DH_RSA_WITH_DES_CBC_SHA = new CipherSuite(
    //         "SSL_DH_RSA_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_DH_RSA,
    //         "DH", "DES_CBC", "SHA", CODE_SSL_DH_RSA_WITH_DES_CBC_SHA);
    //
    // static final CipherSuite SSL_DH_RSA_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
    //         "SSL_DH_RSA_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_DH_RSA,
    //         "DH", "3DES_EDE_CBC", "SHA", CODE_SSL_DH_RSA_WITH_3DES_EDE_CBC_SHA);
    // END android-removed

    static final CipherSuite SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", true,
            KEY_EXCHANGE_DHE_DSS_EXPORT, "DSA", "DES40_CBC", "SHA",
            CODE_SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.114 -0500", hash_original_field = "12115A8D7119666429179B6A666D6F16", hash_generated_field = "A006CDB683B4FF81C5EF2657F07711FF")


    static final CipherSuite SSL_DHE_DSS_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_DHE_DSS_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_DHE_DSS,
            "DSA", "DES_CBC", "SHA", CODE_SSL_DHE_DSS_WITH_DES_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.117 -0500", hash_original_field = "9C35BFB4C6EAE25C2E245D649916B48A", hash_generated_field = "AC0A68BB30CD8FFEE1D4D12D5F65E998")


    static final CipherSuite SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_DHE_DSS,
            "DSA", "3DES_EDE_CBC", "SHA", CODE_SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.119 -0500", hash_original_field = "63D99F380E48F7077FE9B7D34996D2DC", hash_generated_field = "1A773B5A4356A9F11C2CFD4FCF6A525B")


    static final CipherSuite SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", true,
            KEY_EXCHANGE_DHE_RSA_EXPORT, "RSA", "DES40_CBC", "SHA",
            CODE_SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.121 -0500", hash_original_field = "646766D75A33590A75A981F748017896", hash_generated_field = "F8D69EE1E19B7EC1754EC6F246A2FF26")


    static final CipherSuite SSL_DHE_RSA_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_DHE_RSA_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_DHE_RSA,
            "RSA", "DES_CBC", "SHA", CODE_SSL_DHE_RSA_WITH_DES_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.124 -0500", hash_original_field = "F30C74AEA36E317B21C69C2DC64FC245", hash_generated_field = "1515AF1779BD2D635C0DF4A11FE13EF3")


    static final CipherSuite SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_DHE_RSA,
            "RSA", "3DES_EDE_CBC", "SHA", CODE_SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.127 -0500", hash_original_field = "F497BDE958D6AA61CA25EBCD674CA093", hash_generated_field = "40BA565115737BE8643741DB1A5C43E5")


    static final CipherSuite SSL_DH_anon_EXPORT_WITH_RC4_40_MD5 = new CipherSuite(
            "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", true,
            KEY_EXCHANGE_DH_anon_EXPORT, "DH", "RC4_40", "MD5",
            CODE_SSL_DH_anon_EXPORT_WITH_RC4_40_MD5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.129 -0500", hash_original_field = "47CFCFAD6AB4D14FE27DE5408C39CD9F", hash_generated_field = "2A8F3A4351538FDD152D4881A0234A65")


    static final CipherSuite SSL_DH_anon_WITH_RC4_128_MD5 = new CipherSuite(
            "SSL_DH_anon_WITH_RC4_128_MD5", false, KEY_EXCHANGE_DH_anon,
            "DH", "RC4_128", "MD5", CODE_SSL_DH_anon_WITH_RC4_128_MD5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.132 -0500", hash_original_field = "DFE42B27597463C66E0034E7B9433AF9", hash_generated_field = "AC640F2EDA8C3EDB1185C3C26B42D220")


    static final CipherSuite SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", true,
            KEY_EXCHANGE_DH_anon_EXPORT, "DH", "DES40_CBC", "SHA",
            CODE_SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.134 -0500", hash_original_field = "42792DDE7AEA34D804EA253B538EC13C", hash_generated_field = "D9345C52E7FCB7B8BCCC41A4FD2CFEEA")


    static final CipherSuite SSL_DH_anon_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_DH_anon_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_DH_anon,
            "DH", "DES_CBC", "SHA", CODE_SSL_DH_anon_WITH_DES_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.136 -0500", hash_original_field = "8ABED314D889197CCB7FD203AD70EF85", hash_generated_field = "6EAE1711619CAE9262488BECCBD8DA00")


    static final CipherSuite SSL_DH_anon_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_DH_anon,
            "DH", "3DES_EDE_CBC", "SHA", CODE_SSL_DH_anon_WITH_3DES_EDE_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.139 -0500", hash_original_field = "EF4BF9127549CCB23DD14A8E0C14F38F", hash_generated_field = "C8755D57EFCD4FF34CC1A40F4E92A2E0")


    static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_RSA,
                              "RSA",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_RSA_WITH_AES_128_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.141 -0500", hash_original_field = "6C8CA1C75BA8FC239F05A49469771734", hash_generated_field = "1DF4BBDEAB7557D5263ADF51874009E2")

    static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_DHE_DSS_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_DSS,
                              "DSA",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_DHE_DSS_WITH_AES_128_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.143 -0500", hash_original_field = "158A72717F796C38AD8C5705C55E15E9", hash_generated_field = "88C7BB42A36BA01EA7FD13D7796EF956")

    static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_DHE_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_RSA,
                              "RSA",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_DHE_RSA_WITH_AES_128_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.146 -0500", hash_original_field = "40D36B5761410189C9140689BF6A8D1B", hash_generated_field = "0E3EE7799EBB2391F62A25FF8EEA2FA8")

    static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_DH_anon_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DH_anon,
                              "DH",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_DH_anon_WITH_AES_128_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.149 -0500", hash_original_field = "3FE60E2E6E2772780ECA6118724E4C4A", hash_generated_field = "FD7B3241876CAEFD4CABC5D90E7C32AB")

    static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_RSA,
                              "RSA",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_RSA_WITH_AES_256_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.151 -0500", hash_original_field = "CB0F2A9D258E033916C17B9CF4473D1A", hash_generated_field = "AAD783515C742E958091A4B6AFF9B893")

    static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_DSS,
                              "DSA",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_DHE_DSS_WITH_AES_256_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.154 -0500", hash_original_field = "6E21FC8DC3234B18B67A1EB73404EFB7", hash_generated_field = "6F05E1E8A00C955C12D092EDE36F7B8E")

    static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_DHE_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_RSA,
                              "RSA",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_DHE_RSA_WITH_AES_256_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.156 -0500", hash_original_field = "3BCA3A447D53361118A84AD5F0D3F6F8", hash_generated_field = "335E5630A77E2125CE8058A1267F0C68")

    static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_DH_anon_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DH_anon,
                              "DH",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_DH_anon_WITH_AES_256_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.159 -0500", hash_original_field = "E4B7673742814C070893CAE59F491BA9", hash_generated_field = "0FD043C3983298F2736EED01FE6F669F")


    static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA
            = new CipherSuite("TLS_ECDH_ECDSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_NULL_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.161 -0500", hash_original_field = "481D88A7312766A6334B999BBBD294CB", hash_generated_field = "2B08109835E833DF802EF5024346D1B9")

    static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA
            = new CipherSuite("TLS_ECDH_ECDSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_RC4_128_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.164 -0500", hash_original_field = "5EA0C55C399C442FC1542C42C442D417", hash_generated_field = "E9A523735A20B9012788D560D665B90B")

    static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA
            = new CipherSuite("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.167 -0500", hash_original_field = "25D33E1CF76157EECD61BCA4DEEBBCDF", hash_generated_field = "7D90799D379D27E152FD4D02E9676242")

    static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.169 -0500", hash_original_field = "564D96C10A22AA373E0F5DC4BD9806EE", hash_generated_field = "6560CE38BA8E16356643505AB097D48B")

    static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.172 -0500", hash_original_field = "5B8CD7D88F1427387B22266073F6DEB7", hash_generated_field = "F8B2CEAF062232368504A5E89426F9E9")

    static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA
            = new CipherSuite("TLS_ECDHE_ECDSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_NULL_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.174 -0500", hash_original_field = "9CDFB4CC3862FFB77C03D861230E3F27", hash_generated_field = "BFC1CEF8CA8000E78AF9810400D9A32D")

    static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA
            = new CipherSuite("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_RC4_128_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.177 -0500", hash_original_field = "CD0125816DBBCE41138591C83D9C84E1", hash_generated_field = "72ED4270D98336B0C3BB8A39DF005A46")

    static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA
            = new CipherSuite("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.179 -0500", hash_original_field = "50C64B3D1F9A2F8835EBE2EAC1B5F166", hash_generated_field = "B5A295C844B8E785472FA0CEF2D4AAAE")

    static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.181 -0500", hash_original_field = "8E7BB9DA520A691EE12662A2408C8104", hash_generated_field = "7D47987C7DA10ECF4AE8F44310FD9A89")

    static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.184 -0500", hash_original_field = "8B6D4E8990426125D9BCFC8C001F2CE3", hash_generated_field = "E54A2F03372969B47BABC39404D3463A")

    static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA
            = new CipherSuite("TLS_ECDH_RSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_NULL_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.186 -0500", hash_original_field = "723464E5CAB1C4495B432C7141C0236E", hash_generated_field = "A263CEE4445EE34E9D8B3C97BF46E30B")

    static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA
            = new CipherSuite("TLS_ECDH_RSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_RC4_128_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.188 -0500", hash_original_field = "CD8EC648D00F64A2E57AC695AC43B7A4", hash_generated_field = "E2EE05A590C49392CB1444A96016A2C9")

    static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA
            = new CipherSuite("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.191 -0500", hash_original_field = "C2242507D7DBCB19BAA60EFE09C3E76D", hash_generated_field = "60FCAFFD6525833D5AB2A283EFFBAC82")

    static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_AES_128_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.194 -0500", hash_original_field = "A78EC9D3F37FF1AE9738B429BABD739C", hash_generated_field = "42F62210DBBD5A4E388D9071AF9DDC43")

    static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_AES_256_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.196 -0500", hash_original_field = "F332CEB3F386BA3E227217406C64EC5A", hash_generated_field = "22B0D56DEDF9EADB572320BDB9890A1F")

    static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA
            = new CipherSuite("TLS_ECDHE_RSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_NULL_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.199 -0500", hash_original_field = "4D7717684ABFB023068AC768CAB454A8", hash_generated_field = "CA2B4B5949504180CE23F87CA6C336DA")

    static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA
            = new CipherSuite("TLS_ECDHE_RSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_RC4_128_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.201 -0500", hash_original_field = "E1197897AB5B7D7224591D29E7F1428C", hash_generated_field = "8B1BF85626C932024360B746BB010CA9")

    static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA
            = new CipherSuite("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.204 -0500", hash_original_field = "A2247FC27F3D8AA5DEC56E0F6759D4E2", hash_generated_field = "27B8886CB275773240027AD9D691281B")

    static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.206 -0500", hash_original_field = "5D41E6FB113D47BE84E1292A1FA72533", hash_generated_field = "6F2C755A81370853D491D0E2F68D5044")

    static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.208 -0500", hash_original_field = "C9BE7614F8F6D3EDF7446B6BBE53EE2F", hash_generated_field = "62718CFA67EE49461AC5A2A4673670F6")

    static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA
            = new CipherSuite("TLS_ECDH_anon_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_NULL_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.211 -0500", hash_original_field = "3894DB2A0A9EF97B99C68319B8634528", hash_generated_field = "28FA75D7208157E5847A9A9E547923E2")

    static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA
            = new CipherSuite("TLS_ECDH_anon_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_RC4_128_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.213 -0500", hash_original_field = "38A5CBCCEBC5F684673CC435CEB6E902", hash_generated_field = "76D05EDC89E8B9F072A10299EA67E763")

    static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA
            = new CipherSuite("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.216 -0500", hash_original_field = "08F035462855B490E2C1B8362E9C595E", hash_generated_field = "127ABEC3217FAB607DCFD22E091810AA")

    static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_ECDH_anon_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_AES_128_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.219 -0500", hash_original_field = "4A21F2FFE85337F99C7A836394B04BF1", hash_generated_field = "F4073C60D92B0CA28419FB7EC41DF4D2")

    static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_ECDH_anon_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_AES_256_CBC_SHA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.223 -0500", hash_original_field = "62E34D72F487E2B19B6011BA77B76405", hash_generated_field = "A17F3B676AE1FB43596BEAC11EF084F7")

    private static final CipherSuite[] SUITES_BY_CODE_0x00 = {
        // http://www.iana.org/assignments/tls-parameters/tls-parameters.xml
        SSL_NULL_WITH_NULL_NULL,                          // { 0x00, 0x00 };
        SSL_RSA_WITH_NULL_MD5,                            // { 0x00, 0x01 };
        SSL_RSA_WITH_NULL_SHA,                            // { 0x00, 0x02 };
        SSL_RSA_EXPORT_WITH_RC4_40_MD5,                   // { 0x00, 0x03 };
        SSL_RSA_WITH_RC4_128_MD5,                         // { 0x00, 0x04 };
        SSL_RSA_WITH_RC4_128_SHA,                         // { 0x00, 0x05 };
        // BEGIN android-changed
        null, // SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5,      // { 0x00, 0x06 };
        null, // TLS_RSA_WITH_IDEA_CBC_SHA,               // { 0x00, 0x07 };
        // END android-changed
        SSL_RSA_EXPORT_WITH_DES40_CBC_SHA,                // { 0x00, 0x08 };
        SSL_RSA_WITH_DES_CBC_SHA,                         // { 0x00, 0x09 };
        SSL_RSA_WITH_3DES_EDE_CBC_SHA,                    // { 0x00, 0x0a };
        // BEGIN android-changed
        null, // SSL_DH_DSS_EXPORT_WITH_DES40_CBC_SHA     // { 0x00, 0x0b };
        null, // SSL_DH_DSS_WITH_DES_CBC_SHA,             // { 0x00, 0x0c };
        null, // SSL_DH_DSS_WITH_3DES_EDE_CBC_SHA,        // { 0x00, 0x0d };
        null, // SSL_DH_RSA_EXPORT_WITH_DES40_CBC_SHA,    // { 0x00, 0x0e };
        null, // SSL_DH_RSA_WITH_DES_CBC_SHA,             // { 0x00, 0x0f };
        null, // SSL_DH_RSA_WITH_3DES_EDE_CBC_SHA,        // { 0x00, 0x10 };
        // END android-changed
        SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA,            // { 0x00, 0x11 };
        SSL_DHE_DSS_WITH_DES_CBC_SHA,                     // { 0x00, 0x12 };
        SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA,                // { 0x00, 0x13 };
        SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA,            // { 0x00, 0x14 };
        SSL_DHE_RSA_WITH_DES_CBC_SHA,                     // { 0x00, 0x15 };
        SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA,                // { 0x00, 0x16 };
        SSL_DH_anon_EXPORT_WITH_RC4_40_MD5,               // { 0x00, 0x17 };
        SSL_DH_anon_WITH_RC4_128_MD5,                     // { 0x00, 0x18 };
        SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA,            // { 0x00, 0x19 };
        SSL_DH_anon_WITH_DES_CBC_SHA,                     // { 0x00, 0x1A };
        SSL_DH_anon_WITH_3DES_EDE_CBC_SHA,                // { 0x00, 0x1B };
        // BEGIN android-added
        null, // SSL_FORTEZZA_KEA_WITH_NULL_SHA           // { 0x00, 0x1C };
        null, // SSL_FORTEZZA_KEA_WITH_FORTEZZA_CBC_SHA   // { 0x00, 0x1D };
        null, // TLS_KRB5_WITH_DES_CBC_SHA                // { 0x00, 0x1E };
        null, // TLS_KRB5_WITH_3DES_EDE_CBC_SHA           // { 0x00, 0x1F };
        null, // TLS_KRB5_WITH_RC4_128_SHA                // { 0x00, 0x20 };
        null, // TLS_KRB5_WITH_IDEA_CBC_SHA               // { 0x00, 0x21 };
        null, // TLS_KRB5_WITH_DES_CBC_MD5                // { 0x00, 0x22 };
        null, // TLS_KRB5_WITH_3DES_EDE_CBC_MD5           // { 0x00, 0x23 };
        null, // TLS_KRB5_WITH_RC4_128_MD5                // { 0x00, 0x24 };
        null, // TLS_KRB5_WITH_IDEA_CBC_MD5               // { 0x00, 0x25 };
        null, // TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA      // { 0x00, 0x26 };
        null, // TLS_KRB5_EXPORT_WITH_RC2_CBC_40_SHA      // { 0x00, 0x27 };
        null, // TLS_KRB5_EXPORT_WITH_RC4_40_SHA          // { 0x00, 0x28 };
        null, // TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5      // { 0x00, 0x29 };
        null, // TLS_KRB5_EXPORT_WITH_RC2_CBC_40_MD5      // { 0x00, 0x2A };
        null, // TLS_KRB5_EXPORT_WITH_RC4_40_MD5          // { 0x00, 0x2B };
        null, // TLS_PSK_WITH_NULL_SHA                    // { 0x00, 0x2C };
        null, // TLS_DHE_PSK_WITH_NULL_SHA                // { 0x00, 0x2D };
        null, // TLS_RSA_PSK_WITH_NULL_SHA                // { 0x00, 0x2E };
        TLS_RSA_WITH_AES_128_CBC_SHA,                     // { 0x00, 0x2F };
        null, // TLS_DH_DSS_WITH_AES_128_CBC_SHA          // { 0x00, 0x30 };
        null, // TLS_DH_RSA_WITH_AES_128_CBC_SHA          // { 0x00, 0x31 };
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA,                 // { 0x00, 0x32 };
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA,                 // { 0x00, 0x33 };
        TLS_DH_anon_WITH_AES_128_CBC_SHA,                 // { 0x00, 0x34 };
        TLS_RSA_WITH_AES_256_CBC_SHA,                     // { 0x00, 0x35 };
        null, // TLS_DH_DSS_WITH_AES_256_CBC_SHA,         // { 0x00, 0x36 };
        null, // TLS_DH_RSA_WITH_AES_256_CBC_SHA,         // { 0x00, 0x37 };
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA,                 // { 0x00, 0x38 };
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA,                 // { 0x00, 0x39 };
        TLS_DH_anon_WITH_AES_256_CBC_SHA,                 // { 0x00, 0x3A };
        // END android-added
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.226 -0500", hash_original_field = "C53A682BA4F148275A9C2C3C97324900", hash_generated_field = "4F40D15B2FDEA665F56CE25BB66BCE87")

    private static final CipherSuite[] SUITES_BY_CODE_0xc0 = {
        null,                                             // { 0xc0, 0x00};
        TLS_ECDH_ECDSA_WITH_NULL_SHA,                     // { 0xc0, 0x01};
        TLS_ECDH_ECDSA_WITH_RC4_128_SHA,                  // { 0xc0, 0x02};
        TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA,             // { 0xc0, 0x03};
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA,              // { 0xc0, 0x04};
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA,              // { 0xc0, 0x05};
        TLS_ECDHE_ECDSA_WITH_NULL_SHA,                    // { 0xc0, 0x06};
        TLS_ECDHE_ECDSA_WITH_RC4_128_SHA,                 // { 0xc0, 0x07};
        TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA,            // { 0xc0, 0x08};
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,             // { 0xc0, 0x09};
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA,             // { 0xc0, 0x0A};
        TLS_ECDH_RSA_WITH_NULL_SHA,                       // { 0xc0, 0x0B};
        TLS_ECDH_RSA_WITH_RC4_128_SHA,                    // { 0xc0, 0x0C};
        TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA,               // { 0xc0, 0x0D};
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA,                // { 0xc0, 0x0E};
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA,                // { 0xc0, 0x0F};
        TLS_ECDHE_RSA_WITH_NULL_SHA,                      // { 0xc0, 0x10};
        TLS_ECDHE_RSA_WITH_RC4_128_SHA,                   // { 0xc0, 0x11};
        TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA,              // { 0xc0, 0x12};
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,               // { 0xc0, 0x13};
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,               // { 0xc0, 0x14};
        TLS_ECDH_anon_WITH_NULL_SHA,                      // { 0xc0, 0x15};
        TLS_ECDH_anon_WITH_RC4_128_SHA,                   // { 0xc0, 0x16};
        TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA,              // { 0xc0, 0x17};
        TLS_ECDH_anon_WITH_AES_128_CBC_SHA,               // { 0xc0, 0x18};
        TLS_ECDH_anon_WITH_AES_256_CBC_SHA,               // { 0xc0, 0x19};
        // TLS_SRP_SHA_WITH_3DES_EDE_CBC_SHA,             // { 0xc0, 0x1A};
        // TLS_SRP_SHA_RSA_WITH_3DES_EDE_CBC_SHA,         // { 0xc0, 0x1B};
        // TLS_SRP_SHA_DSS_WITH_3DES_EDE_CBC_SHA,         // { 0xc0, 0x1C};
        // TLS_SRP_SHA_WITH_AES_128_CBC_SHA,              // { 0xc0, 0x1D};
        // TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA,          // { 0xc0, 0x1E};
        // TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA,          // { 0xc0, 0x1F};
        // TLS_SRP_SHA_WITH_AES_256_CBC_SHA,              // { 0xc0, 0x20};
        // TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA,          // { 0xc0, 0x21};
        // TLS_SRP_SHA_DSS_WITH_AES_256_CBC_SHA,          // { 0xc0, 0x22};
        // TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256,       // { 0xc0, 0x23};
        // TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384,       // { 0xc0, 0x24};
        // TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256,        // { 0xc0, 0x25};
        // TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384,        // { 0xc0, 0x26};
        // TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256,         // { 0xc0, 0x27};
        // TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384,         // { 0xc0, 0x28};
        // TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256,          // { 0xc0, 0x29};
        // TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384,          // { 0xc0, 0x2A};
        // TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,       // { 0xc0, 0x2B};
        // TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384,       // { 0xc0, 0x2C};
        // TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256,        // { 0xc0, 0x2D};
        // TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384,        // { 0xc0, 0x2E};
        // TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,         // { 0xc0, 0x2F};
        // TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384,         // { 0xc0, 0x30};
        // TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256,          // { 0xc0, 0x31};
        // TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384,          // { 0xc0, 0x32};
        // TLS_ECDHE_PSK_WITH_RC4_128_SHA,                // { 0xc0, 0x33};
        // TLS_ECDHE_PSK_WITH_3DES_EDE_CBC_SHA,           // { 0xc0, 0x34};
        // TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA,            // { 0xc0, 0x35};
        // TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA,            // { 0xc0, 0x36};
        // TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA256,         // { 0xc0, 0x37};
        // TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA384,         // { 0xc0, 0x38};
        // TLS_ECDHE_PSK_WITH_NULL_SHA,                   // { 0xc0, 0x39};
        // TLS_ECDHE_PSK_WITH_NULL_SHA256,                // { 0xc0, 0x3A};
        // TLS_ECDHE_PSK_WITH_NULL_SHA384,                // { 0xc0, 0x3B};
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.229 -0500", hash_original_field = "3421EBF6ABF1E6CD66EC6DEA2D8F6C2F", hash_generated_field = "E6AE8C29747288A1BFEE444F8739BBF9")

    private static  Hashtable<String, CipherSuite> SUITES_BY_NAME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.231 -0500", hash_original_field = "464B597F4CF403346482214DC4889B04", hash_generated_field = "B89B8FC2602E9D0843E9B298D0A0972D")

    //  TODO Dynamically supported suites: new providers may be dynamically
    //  added/removed and the set of supported suites may be changed
    static  CipherSuite[] SUPPORTED_CIPHER_SUITES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.233 -0500", hash_original_field = "B2A8765D2AABF85569E5112F533498ED", hash_generated_field = "376EF07F673B6998B2F9A878D03DBFB3")

    static  String[] SUPPORTED_CIPHER_SUITE_NAMES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.236 -0500", hash_original_field = "94CEBB5084FDF2135947CA8FDE483C43", hash_generated_field = "4E9325578392D367E47C3B814905F855")

    static  CipherSuite[] DEFAULT_CIPHER_SUITES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.286 -0500", hash_original_field = "E61FF3ECC46030AC921C9408991022A1", hash_generated_field = "77F19AD70EC1D24EA7A28598362432C7")


    static final String KEY_TYPE_RSA = "RSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.288 -0500", hash_original_field = "5EA64D92C9435DB6CA916DBBF2A6BE8E", hash_generated_field = "630B9C0F0D3AEF35E7DA4AFECEA78C9E")

    static final String KEY_TYPE_DSA = "DSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.290 -0500", hash_original_field = "33AC8CE77B394AFDD0A3CED4087D5BF1", hash_generated_field = "BBFA8237258AF99FD71034F7C308BAB7")

    static final String KEY_TYPE_DH_RSA = "DH_RSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.292 -0500", hash_original_field = "E692C048408CE1975DD5EEDE0CD5ACDF", hash_generated_field = "798846ECC75FFD68618D68A4E6BBEA1A")

    static final String KEY_TYPE_DH_DSA = "DH_DSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.295 -0500", hash_original_field = "409F00990B91E27D4324A3C29951C407", hash_generated_field = "6A52F3EA9F4D6C1C640E606E484D7E70")

    static final String KEY_TYPE_EC = "EC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.297 -0500", hash_original_field = "EC5EA7B2EF4E68B40AB00ACD30AB2A23", hash_generated_field = "0AFB1B56EF398E2AD8997CF42FB3B02E")

    static final String KEY_TYPE_EC_EC = "EC_EC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.299 -0500", hash_original_field = "0029853C7D9560A84DF74B7B0926CA1F", hash_generated_field = "344A5567B54FB40D54D3A25A3053E86D")

    static final String KEY_TYPE_EC_RSA = "EC_RSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.305 -0500", hash_original_field = "B2E273DC7EE515296CF530DDD667261F", hash_generated_field = "C4A8DFCA6F3D8F40BB452A430E404195")

    static final byte TLS_CT_RSA_SIGN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.307 -0500", hash_original_field = "A1ADD270E73B593C2D038930B6B13D38", hash_generated_field = "C6811E746D7BC22CF1AF4DFA56868830")

    static final byte TLS_CT_DSS_SIGN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.309 -0500", hash_original_field = "1081B3BF15CCAACE7AD392FB1DEB9DB7", hash_generated_field = "5EC79EFF91BAD8AC13CF075127EFF1E0")

    static final byte TLS_CT_RSA_FIXED_DH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.312 -0500", hash_original_field = "B9C3A9E7212B4C6AEB5B257631407780", hash_generated_field = "8C7457C0B8540DA372E8FB0BA2A79F91")

    static final byte TLS_CT_DSS_FIXED_DH = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.314 -0500", hash_original_field = "70B9BF78189179FA2773FBBA4953D580", hash_generated_field = "B70A5C7DD08BB9D673DDC6524F916C5C")

    static final byte TLS_CT_ECDSA_SIGN = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.316 -0500", hash_original_field = "58E27714387064C3442500F9B6721B13", hash_generated_field = "D6FEF529A7E04C9C8D86EB205CBFF183")

    static final byte TLS_CT_RSA_FIXED_ECDH = 65;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.319 -0500", hash_original_field = "DAFE4CCF719A575CD48BB6CE9BF4ADEB", hash_generated_field = "E4A4DDEF6F68FB196493EF24ED4F301E")

    static final byte TLS_CT_ECDSA_FIXED_ECDH = 66;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.323 -0500", hash_original_field = "CDD897EDC28A584D78690798D9636044", hash_generated_field = "75BBB8F06193906FA068195C91CC982F")


    private static final String AUTH_TYPE_RSA = "RSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.326 -0500", hash_original_field = "FD8DAE36303392795DF18AD444971C95", hash_generated_field = "8590A0B84340C915C8FC0330943D3EE4")

    private static final String AUTH_TYPE_RSA_EXPORT = "RSA_EXPORT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.329 -0500", hash_original_field = "F225DE5C862FF8A47BA3F31F84D5C3B4", hash_generated_field = "C267CFB88B3F31A3D3009A6EE4B22BFE")

    private static final String AUTH_TYPE_DHE_DSS = "DHE_DSS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.331 -0500", hash_original_field = "BCF0B131C821FF25F85022B7E7443500", hash_generated_field = "360C9EDA248CB77FB2D73A7ECB2ED787")

    private static final String AUTH_TYPE_DHE_RSA = "DHE_RSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.334 -0500", hash_original_field = "34C6D22CA411381A5569A81F677A81B3", hash_generated_field = "2983AD5B9C775809F07BA3FC6211F923")

    private static final String AUTH_TYPE_DH_DSS = "DH_DSS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.336 -0500", hash_original_field = "9C925832F0E08C9EA9C9F603C4A0E225", hash_generated_field = "0B15F4F51D7DA5484907C39F1BEA9F2C")

    private static final String AUTH_TYPE_DH_RSA = "DH_RSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.338 -0500", hash_original_field = "AE341776270BF290210E7CEC59A52552", hash_generated_field = "A37F258BAA1BF58A5C6D48FB47F926DA")

    private static final String AUTH_TYPE_ECDH_ECDSA = "ECDH_ECDSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.341 -0500", hash_original_field = "E9603DA3F53F8108F4913E683675B099", hash_generated_field = "0591670FC863EEEBF5B81DE869317CFE")

    private static final String AUTH_TYPE_ECDH_RSA = "ECDH_RSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.343 -0500", hash_original_field = "DC97F3C53E3638830CF6026A34EE25D3", hash_generated_field = "6AAF5398435B5C69C03F959E8CF31F67")

    private static final String AUTH_TYPE_ECDHE_ECDSA = "ECDHE_ECDSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.346 -0500", hash_original_field = "BEE00CFD7424CF277BB0937575B15C91", hash_generated_field = "617756BEB2E239C83DF1B98C0BC9C5C1")

    private static final String AUTH_TYPE_ECDHE_RSA = "ECDHE_RSA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.894 -0500", hash_original_field = "31167280C241F9B17D639631F29E89F8", hash_generated_field = "31167280C241F9B17D639631F29E89F8")

    boolean supported = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.896 -0500", hash_original_field = "FAA04C329C3BBD40436514A0BFECF651", hash_generated_field = "FAA04C329C3BBD40436514A0BFECF651")

     int keyExchange;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.899 -0500", hash_original_field = "646723EE143F971BA7CBBEF15A14B911", hash_generated_field = "646723EE143F971BA7CBBEF15A14B911")

     String authType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.901 -0500", hash_original_field = "D7A4AB7796DE7F7B5F28166BAC9CA14D", hash_generated_field = "D7A4AB7796DE7F7B5F28166BAC9CA14D")

     String cipherName;
    static {
        SUITES_BY_NAME = new Hashtable<String, CipherSuite>();
        int count_0x00 = registerCipherSuitesByCode(SUITES_BY_CODE_0x00);
        int count_0xc0 = registerCipherSuitesByCode(SUITES_BY_CODE_0xc0);
        int count = count_0x00 + count_0xc0;
        SUPPORTED_CIPHER_SUITES = new CipherSuite[count];
        SUPPORTED_CIPHER_SUITE_NAMES = new String[count];
        registerSupportedCipherSuites(0, SUITES_BY_CODE_0x00);
        registerSupportedCipherSuites(count_0x00, SUITES_BY_CODE_0xc0);
        CipherSuite[] defaultCipherSuites = {
                SSL_RSA_WITH_RC4_128_MD5,
                SSL_RSA_WITH_RC4_128_SHA,
                TLS_RSA_WITH_AES_128_CBC_SHA,
                TLS_DHE_RSA_WITH_AES_128_CBC_SHA,
                TLS_DHE_DSS_WITH_AES_128_CBC_SHA,
                SSL_RSA_WITH_3DES_EDE_CBC_SHA,
                SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA,
                SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA,
                SSL_RSA_WITH_DES_CBC_SHA,
                SSL_DHE_RSA_WITH_DES_CBC_SHA,
                SSL_DHE_DSS_WITH_DES_CBC_SHA,
                SSL_RSA_EXPORT_WITH_RC4_40_MD5,
                SSL_RSA_EXPORT_WITH_DES40_CBC_SHA,
                SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA,
                SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA
                };
        count = 0;
        for (int i = 0; i < defaultCipherSuites.length; i++) {
            if (defaultCipherSuites[i].supported) {
                count++;
            }
        }
        DEFAULT_CIPHER_SUITES = new CipherSuite[count];
        count = 0;
        for (int i = 0; i < defaultCipherSuites.length; i++) {
            if (defaultCipherSuites[i].supported) {
                DEFAULT_CIPHER_SUITES[count++] = defaultCipherSuites[i];
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.903 -0500", hash_original_field = "1B9CA4D35CF052E34AE02D26B8639B41", hash_generated_field = "1B9CA4D35CF052E34AE02D26B8639B41")

     int keyMaterial;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.905 -0500", hash_original_field = "82AAF67303DF25D146F91143FBDDD6E8", hash_generated_field = "82AAF67303DF25D146F91143FBDDD6E8")

     int expandedKeyMaterial;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.907 -0500", hash_original_field = "4CBDA801C187B4605E64F46AEA891A1A", hash_generated_field = "4CBDA801C187B4605E64F46AEA891A1A")

     int effectiveKeyBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.909 -0500", hash_original_field = "159387C23F190CC3FE94572A49B7E04B", hash_generated_field = "159387C23F190CC3FE94572A49B7E04B")

     int ivSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.912 -0500", hash_original_field = "E0EFC76E03EC27B0E8C1203B63FA7AC6", hash_generated_field = "04C3773A3BD2D8612D975B4AF160A96A")

     private int blockSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.914 -0500", hash_original_field = "334EFB2EBC56404F137C362D3FACAFF6", hash_generated_field = "9C6879ACFD3ACD2B8F6A3DB61F5802F7")

    private  byte[] cipherSuiteCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.917 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.919 -0500", hash_original_field = "EE7D741FAD2911DF3651180DB0CEDC76", hash_generated_field = "E3762000F131D4540CC4F5BE4F282C71")

    private  boolean isExportable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.922 -0500", hash_original_field = "8756D549895FC5C5CE91FCA407E282D3", hash_generated_field = "FA3FEC41411B55E226E2067875BD3B74")

     private String hashName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.924 -0500", hash_original_field = "231B1A106D1BC63EB07CA776DECEF1A5", hash_generated_field = "F6E855DA27DE62B9374233E3385207F7")

     private String hmacName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.927 -0500", hash_original_field = "7F57BF96D6648B96A2962CDE2843ABB3", hash_generated_field = "FBF2A1556B0034F6A3D1102F2996A7CB")

     private int hashSize;

    /**
     * Creates CipherSuite
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.256 -0500", hash_original_method = "54B6F4B5E133F8A61DA406B9859D0D86", hash_generated_method = "9E4D16CEBDD19DA15C150611BDBAA64C")
    
private CipherSuite(String name, boolean isExportable, int keyExchange,
            String authType, String cipherName, String hash, byte[] code) {
        this.name = name;
        this.keyExchange = keyExchange;
        this.authType = authType;
        this.isExportable = isExportable;
        if (cipherName == null) {
            this.cipherName = null;
            keyMaterial = 0;
            expandedKeyMaterial = 0;
            effectiveKeyBytes = 0;
            ivSize = 0;
            blockSize = 0;
        // BEGIN android-removed
        // } else if ("IDEA_CBC".equals(cipherName)) {
        //     this.cipherName = "IDEA/CBC/NoPadding";
        //     keyMaterial = 16;
        //     expandedKeyMaterial = 16;
        //     effectiveKeyBytes = 16;
        //     ivSize = 8;
        //     blockSize = 8;
        // } else if ("RC2_CBC_40".equals(cipherName)) {
        //     this.cipherName = "RC2/CBC/NoPadding";
        //     keyMaterial = 5;
        //     expandedKeyMaterial = 16;
        //     effectiveKeyBytes = 5;
        //     ivSize = 8;
        //     blockSize = 8;
        // END android-removed
        } else if ("RC4_40".equals(cipherName)) {
            this.cipherName = "RC4";
            keyMaterial = 5;
            expandedKeyMaterial = 16;
            effectiveKeyBytes = 5;
            ivSize = 0;
            blockSize = 0;
        } else if ("RC4_128".equals(cipherName)) {
            this.cipherName = "RC4";
            keyMaterial = 16;
            expandedKeyMaterial = 16;
            effectiveKeyBytes = 16;
            ivSize = 0;
            blockSize = 0;
        } else if ("DES40_CBC".equals(cipherName)) {
            this.cipherName = "DES/CBC/NoPadding";
            keyMaterial = 5;
            expandedKeyMaterial = 8;
            effectiveKeyBytes = 5;
            ivSize = 8;
            blockSize = 8;
        } else if ("DES_CBC".equals(cipherName)) {
            this.cipherName = "DES/CBC/NoPadding";
            keyMaterial = 8;
            expandedKeyMaterial = 8;
            effectiveKeyBytes = 7;
            ivSize = 8;
            blockSize = 8;
        } else if ("3DES_EDE_CBC".equals(cipherName)) {
            this.cipherName = "DESede/CBC/NoPadding";
            keyMaterial = 24;
            expandedKeyMaterial = 24;
            effectiveKeyBytes = 24;
            ivSize = 8;
            blockSize = 8;
        } else if ("AES_128_CBC".equals(cipherName)) {
            this.cipherName = "AES/CBC/NoPadding";
            keyMaterial = 16;
            expandedKeyMaterial = 16;
            effectiveKeyBytes = 16;
            ivSize = 16;
            blockSize = 16;
        } else if ("AES_256_CBC".equals(cipherName)) {
            this.cipherName = "AES/CBC/NoPadding";
            keyMaterial = 32;
            expandedKeyMaterial = 32;
            effectiveKeyBytes = 32;
            ivSize = 16;
            blockSize = 16;
        } else {
            this.cipherName = cipherName;
            keyMaterial = 0;
            expandedKeyMaterial = 0;
            effectiveKeyBytes = 0;
            ivSize = 0;
            blockSize = 0;
        }

        if ("MD5".equals(hash)) {
            this.hmacName = "HmacMD5";
            this.hashName = "MD5";
            hashSize = 16;
        } else if ("SHA".equals(hash)) {
            this.hmacName = "HmacSHA1";
            this.hashName = "SHA-1";
            hashSize = 20;
        } else {
            this.hmacName = null;
            this.hashName = null;
            hashSize = 0;
        }

        cipherSuiteCode = code;

        if (this.cipherName != null) {
            try {
                Cipher.getInstance(this.cipherName);
            } catch (GeneralSecurityException e) {
                supported = false;
            }
        }

        // We define the Elliptic Curve cipher suites for use with
        // code shared by OpenSSL, but they are not supported by
        // SSLEngine or SSLSocket's built with SSLEngine.
        if (this.name.startsWith("TLS_EC")) {
            supported = false;
        }
    }

    /**
     * Returns true if cipher suite is anonymous
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.259 -0500", hash_original_method = "92638E1F733B540A4060D31FD00C2E43", hash_generated_method = "4F508BD3E138E2D5ABBA2AFA4E75FC11")
    
public boolean isAnonymous() {
        if (keyExchange == KEY_EXCHANGE_DH_anon
                || keyExchange == KEY_EXCHANGE_DH_anon_EXPORT
                || keyExchange == KEY_EXCHANGE_ECDH_anon) {
            return true;
        }
        return false;
    }

    /**
     * Returns cipher suite name
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.266 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Returns cipher suite code as byte array
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.268 -0500", hash_original_method = "914B5E2C4522C674B906D3A88195AF81", hash_generated_method = "5F87F09CB55E38B11E6016977A9B359C")
    
public byte[] toBytes() {
        return cipherSuiteCode;
    }

    /**
     * Returns cipher suite description
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.271 -0500", hash_original_method = "D4E6F2D9338FE775902AE34CF280ED17", hash_generated_method = "4D4883972AC36241D37B12A13AB18E38")
    
@Override
    public String toString() {
        return name + ": " + cipherSuiteCode[0] + " " + cipherSuiteCode[1];
    }

    /**
     * Returns cipher algorithm name
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.273 -0500", hash_original_method = "7D208669D7EDDA60D0FD344147D9AAD6", hash_generated_method = "0A6164B58082A57A3ABDC96B5A3D6A05")
    
public String getBulkEncryptionAlgorithm() {
        return cipherName;
    }

    /**
     * Returns cipher block size
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.275 -0500", hash_original_method = "E03DB665D968D86F8F6FEC0B3CE97B35", hash_generated_method = "0EBFE41219CD77147AD588766739AE74")
    
public int getBlockSize() {
        return blockSize;
    }

    /**
     * Returns MAC algorithm name
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.277 -0500", hash_original_method = "58CBEDAB9C64FBF2F046D83798145AD9", hash_generated_method = "988AB1B385746C012DBEE3337D88BAA0")
    
public String getHmacName() {
        return hmacName;
    }

    /**
     * Returns hash algorithm name
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.279 -0500", hash_original_method = "D391A3C678BDD6A89326831F4F051E38", hash_generated_method = "F698A4A2F59D452DCB8AB0A27F8728C0")
    
public String getHashName() {
        return hashName;
    }

    /**
     * Returns hash size
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.281 -0500", hash_original_method = "5CA4B8D3CBACCFD69EE0CC1B72A2F92B", hash_generated_method = "7BD894F81B4BA43F1F95928CC354189D")
    
public int getMACLength() {
        return hashSize;
    }

    /**
     * Indicates whether this cipher suite is exportable
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.283 -0500", hash_original_method = "3DD67552ED8C1FF65B79535A2E5F00F8", hash_generated_method = "A0B77081CFA8EB5FDE9392D3EE35C8F4")
    
public boolean isExportable() {
        return isExportable;
    }

    /**
     * Returns key type constant suitable for calling
     * X509KeyManager.chooseServerAlias or
     * X509ExtendedKeyManager.chooseEngineServerAlias.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.302 -0500", hash_original_method = "936867E36B0EB6E36D3CC4941D208DF5", hash_generated_method = "6E33392349706AF17F02181FEB4ABEB8")
    
public String getServerKeyType() {
        switch (keyExchange) {
            case KEY_EXCHANGE_DHE_RSA:
            case KEY_EXCHANGE_DHE_RSA_EXPORT:
            case KEY_EXCHANGE_ECDHE_RSA:
            case KEY_EXCHANGE_RSA:
            case KEY_EXCHANGE_RSA_EXPORT:
                return KEY_TYPE_RSA;
            case KEY_EXCHANGE_DHE_DSS:
            case KEY_EXCHANGE_DHE_DSS_EXPORT:
                return KEY_TYPE_DSA;
            case KEY_EXCHANGE_ECDH_ECDSA:
            case KEY_EXCHANGE_ECDHE_ECDSA:
                return KEY_TYPE_EC_EC;
            case KEY_EXCHANGE_ECDH_RSA:
                return KEY_TYPE_EC_RSA;
            case KEY_EXCHANGE_DH_anon:
            case KEY_EXCHANGE_DH_anon_EXPORT:
            case KEY_EXCHANGE_ECDH_anon:
                return null;
            default:
                throw new IllegalStateException("Unknown key type for key exchange " + keyExchange);
        }
    }

    /**
     * Returns auth type constant suitable for calling X509TrustManager.checkServerTrusted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:16.349 -0500", hash_original_method = "0C964AFB9ED36BE0A1810A2A5E5F4637", hash_generated_method = "DDDD7CD2AB550EC2D02BFB6CD8CF6C0D")
    
public String getAuthType(boolean emphemeral) {
        switch (keyExchange) {
            case KEY_EXCHANGE_RSA:
                return AUTH_TYPE_RSA;
            case KEY_EXCHANGE_RSA_EXPORT:
                return emphemeral ? AUTH_TYPE_RSA_EXPORT : AUTH_TYPE_RSA;
            case KEY_EXCHANGE_DHE_DSS:
            case KEY_EXCHANGE_DHE_DSS_EXPORT:
                return AUTH_TYPE_DHE_DSS;
            case KEY_EXCHANGE_DHE_RSA:
            case KEY_EXCHANGE_DHE_RSA_EXPORT:
                return AUTH_TYPE_DHE_RSA;
            case KEY_EXCHANGE_ECDH_ECDSA:
                return AUTH_TYPE_ECDH_ECDSA;
            case KEY_EXCHANGE_ECDHE_ECDSA:
                return AUTH_TYPE_ECDHE_ECDSA;
            case KEY_EXCHANGE_ECDH_RSA:
                return AUTH_TYPE_ECDH_RSA;
            case KEY_EXCHANGE_ECDHE_RSA:
                return AUTH_TYPE_ECDHE_RSA;
            case KEY_EXCHANGE_DH_anon:
            case KEY_EXCHANGE_DH_anon_EXPORT:
            case KEY_EXCHANGE_ECDH_anon:
                return null;
            default:
                throw new IllegalStateException("Unknown auth type for key exchange " + keyExchange);
        }
    }
}

