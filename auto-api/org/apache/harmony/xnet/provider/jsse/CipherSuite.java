package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import javax.crypto.Cipher;

public class CipherSuite {
    boolean supported = true;
    int keyExchange;
    String authType;
    String cipherName;
    int keyMaterial;
    int expandedKeyMaterial;
    int effectiveKeyBytes;
    int ivSize;
    private int blockSize;
    private byte[] cipherSuiteCode;
    private String name;
    private boolean isExportable;
    private String hashName;
    private String hmacName;
    private int hashSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.580 -0400", hash_original_method = "54B6F4B5E133F8A61DA406B9859D0D86", hash_generated_method = "4D3B05CAF2BCC5B6E07AD07BF1816E20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CipherSuite(String name, boolean isExportable, int keyExchange,
            String authType, String cipherName, String hash, byte[] code) {
        dsTaint.addTaint(hash);
        dsTaint.addTaint(cipherName);
        dsTaint.addTaint(name);
        dsTaint.addTaint(code[0]);
        dsTaint.addTaint(authType);
        dsTaint.addTaint(keyExchange);
        dsTaint.addTaint(isExportable);
        {
            this.cipherName = null;
            keyMaterial = 0;
            expandedKeyMaterial = 0;
            effectiveKeyBytes = 0;
            ivSize = 0;
            blockSize = 0;
        } //End block
        {
            boolean var83FE4A621033DBF86A035303348C9069_1188104528 = ("RC4_40".equals(cipherName));
            {
                this.cipherName = "RC4";
                keyMaterial = 5;
                expandedKeyMaterial = 16;
                effectiveKeyBytes = 5;
                ivSize = 0;
                blockSize = 0;
            } //End block
            {
                boolean varBFA52D54AB4E451C86478190B088F490_1576968138 = ("RC4_128".equals(cipherName));
                {
                    this.cipherName = "RC4";
                    keyMaterial = 16;
                    expandedKeyMaterial = 16;
                    effectiveKeyBytes = 16;
                    ivSize = 0;
                    blockSize = 0;
                } //End block
                {
                    boolean var169A581047F02ED212E0D86EC911CFF3_844974391 = ("DES40_CBC".equals(cipherName));
                    {
                        this.cipherName = "DES/CBC/NoPadding";
                        keyMaterial = 5;
                        expandedKeyMaterial = 8;
                        effectiveKeyBytes = 5;
                        ivSize = 8;
                        blockSize = 8;
                    } //End block
                    {
                        boolean varBA299225572A2EEF4B69DFBC7FAB0C2C_1090367817 = ("DES_CBC".equals(cipherName));
                        {
                            this.cipherName = "DES/CBC/NoPadding";
                            keyMaterial = 8;
                            expandedKeyMaterial = 8;
                            effectiveKeyBytes = 7;
                            ivSize = 8;
                            blockSize = 8;
                        } //End block
                        {
                            boolean var2AFD38E7932DB50B2E8247936CF045C0_1380043162 = ("3DES_EDE_CBC".equals(cipherName));
                            {
                                this.cipherName = "DESede/CBC/NoPadding";
                                keyMaterial = 24;
                                expandedKeyMaterial = 24;
                                effectiveKeyBytes = 24;
                                ivSize = 8;
                                blockSize = 8;
                            } //End block
                            {
                                boolean var40782AB2EBC9AF3EEA4D4BE96870414B_1698561559 = ("AES_128_CBC".equals(cipherName));
                                {
                                    this.cipherName = "AES/CBC/NoPadding";
                                    keyMaterial = 16;
                                    expandedKeyMaterial = 16;
                                    effectiveKeyBytes = 16;
                                    ivSize = 16;
                                    blockSize = 16;
                                } //End block
                                {
                                    boolean var031F9B85D3909EA1CA5883928E3FDDA1_931843494 = ("AES_256_CBC".equals(cipherName));
                                    {
                                        this.cipherName = "AES/CBC/NoPadding";
                                        keyMaterial = 32;
                                        expandedKeyMaterial = 32;
                                        effectiveKeyBytes = 32;
                                        ivSize = 16;
                                        blockSize = 16;
                                    } //End block
                                    {
                                        keyMaterial = 0;
                                        expandedKeyMaterial = 0;
                                        effectiveKeyBytes = 0;
                                        ivSize = 0;
                                        blockSize = 0;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varFE5CFE390B831904898301B5035F64A1_1756288933 = ("MD5".equals(hash));
            {
                this.hmacName = "HmacMD5";
                this.hashName = "MD5";
                hashSize = 16;
            } //End block
            {
                boolean var1247556C4F383A0C34B50551B10A24FE_2092160973 = ("SHA".equals(hash));
                {
                    this.hmacName = "HmacSHA1";
                    this.hashName = "SHA-1";
                    hashSize = 20;
                } //End block
                {
                    this.hmacName = null;
                    this.hashName = null;
                    hashSize = 0;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            try 
            {
                Cipher.getInstance(this.cipherName);
            } //End block
            catch (GeneralSecurityException e)
            {
                supported = false;
            } //End block
        } //End block
        {
            boolean var8F5354B22BBD8A425CE718DC6EB34B8F_931251850 = (this.name.startsWith("TLS_EC"));
            {
                supported = false;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
        public static CipherSuite getByName(String name) {
        return SUITES_BY_NAME.get(name);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.581 -0400", hash_original_method = "92638E1F733B540A4060D31FD00C2E43", hash_generated_method = "A271F56C585B9FCB72CCC61CD531D169")
    @DSModeled(DSC.SAFE)
    public boolean isAnonymous() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (keyExchange == KEY_EXCHANGE_DH_anon
                //|| keyExchange == KEY_EXCHANGE_DH_anon_EXPORT
                //|| keyExchange == KEY_EXCHANGE_ECDH_anon) {
            //return true;
        //}
        //return false;
    }

    
        public static CipherSuite[] getSupported() {
        return SUPPORTED_CIPHER_SUITES;
    }

    
        public static String[] getSupportedCipherSuiteNames() {
        return SUPPORTED_CIPHER_SUITE_NAMES.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.582 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.582 -0400", hash_original_method = "914B5E2C4522C674B906D3A88195AF81", hash_generated_method = "C2AE16377F3B02572D06424C8CD69AF0")
    @DSModeled(DSC.SAFE)
    public byte[] toBytes() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return cipherSuiteCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.582 -0400", hash_original_method = "D4E6F2D9338FE775902AE34CF280ED17", hash_generated_method = "004E3DCF30D150AE67128766C237F9FB")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name + ": " + cipherSuiteCode[0] + " " + cipherSuiteCode[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.582 -0400", hash_original_method = "7D208669D7EDDA60D0FD344147D9AAD6", hash_generated_method = "92315C3C50A65A336D4CCE8C4F68333F")
    @DSModeled(DSC.SAFE)
    public String getBulkEncryptionAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return cipherName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.582 -0400", hash_original_method = "E03DB665D968D86F8F6FEC0B3CE97B35", hash_generated_method = "422FDA5557CC6A6431EE4436CBB81E91")
    @DSModeled(DSC.SAFE)
    public int getBlockSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return blockSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.583 -0400", hash_original_method = "58CBEDAB9C64FBF2F046D83798145AD9", hash_generated_method = "991FA00D6885E770F881848147A7392A")
    @DSModeled(DSC.SAFE)
    public String getHmacName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return hmacName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.583 -0400", hash_original_method = "D391A3C678BDD6A89326831F4F051E38", hash_generated_method = "DA769A7A8B76D3BC5E804E0BCB73A86D")
    @DSModeled(DSC.SAFE)
    public String getHashName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return hashName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.583 -0400", hash_original_method = "5CA4B8D3CBACCFD69EE0CC1B72A2F92B", hash_generated_method = "5DAF1AB1445B112B5DD1494E7897823D")
    @DSModeled(DSC.SAFE)
    public int getMACLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return hashSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.583 -0400", hash_original_method = "3DD67552ED8C1FF65B79535A2E5F00F8", hash_generated_method = "93996C2A84D4D72B9A48084057A9D3C8")
    @DSModeled(DSC.SAFE)
    public boolean isExportable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isExportable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.583 -0400", hash_original_method = "936867E36B0EB6E36D3CC4941D208DF5", hash_generated_method = "05F790033352E3D81E1B07AD54DAC3EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getServerKeyType() {
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unknown key type for key exchange " + keyExchange);
        //End case default 
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static String getClientKeyType(byte keyType) {
        switch (keyType) {
            case TLS_CT_RSA_SIGN:
                return KEY_TYPE_RSA; 
            case TLS_CT_DSS_SIGN:
                return KEY_TYPE_DSA; 
            case TLS_CT_RSA_FIXED_DH:
                return KEY_TYPE_DH_RSA; 
            case TLS_CT_DSS_FIXED_DH:
                return KEY_TYPE_DH_DSA; 
            case TLS_CT_ECDSA_SIGN:
                return KEY_TYPE_EC; 
            case TLS_CT_RSA_FIXED_ECDH:
                return KEY_TYPE_EC_RSA; 
            case TLS_CT_ECDSA_FIXED_ECDH:
                return KEY_TYPE_EC_EC; 
            default:
                return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.585 -0400", hash_original_method = "0C964AFB9ED36BE0A1810A2A5E5F4637", hash_generated_method = "88BD2ED4DFE4FB002E68C0AFC47084F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAuthType(boolean emphemeral) {
        dsTaint.addTaint(emphemeral);
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unknown auth type for key exchange " + keyExchange);
        //End case default 
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static final int KEY_EXCHANGE_RSA = 1;
    static final int KEY_EXCHANGE_RSA_EXPORT = 2;
    static final int KEY_EXCHANGE_DHE_DSS = 3;
    static final int KEY_EXCHANGE_DHE_DSS_EXPORT = 4;
    static final int KEY_EXCHANGE_DHE_RSA = 5;
    static final int KEY_EXCHANGE_DHE_RSA_EXPORT = 6;
    static final int KEY_EXCHANGE_DH_anon = 9;
    static final int KEY_EXCHANGE_DH_anon_EXPORT = 10;
    static final int KEY_EXCHANGE_ECDH_ECDSA = 13;
    static final int KEY_EXCHANGE_ECDHE_ECDSA = 14;
    static final int KEY_EXCHANGE_ECDH_RSA = 15;
    static final int KEY_EXCHANGE_ECDHE_RSA = 16;
    static final int KEY_EXCHANGE_ECDH_anon = 17;
    static final byte[] CODE_SSL_NULL_WITH_NULL_NULL = { 0x00, 0x00 };
    static final byte[] CODE_SSL_RSA_WITH_NULL_MD5 = { 0x00, 0x01 };
    static final byte[] CODE_SSL_RSA_WITH_NULL_SHA = { 0x00, 0x02 };
    static final byte[] CODE_SSL_RSA_EXPORT_WITH_RC4_40_MD5 = { 0x00, 0x03 };
    static final byte[] CODE_SSL_RSA_WITH_RC4_128_MD5 = { 0x00, 0x04 };
    static final byte[] CODE_SSL_RSA_WITH_RC4_128_SHA = { 0x00, 0x05 };
    static final byte[] CODE_SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5 = { 0x00, 0x06 };
    static final byte[] CODE_SSL_RSA_EXPORT_WITH_DES40_CBC_SHA = { 0x00, 0x08 };
    static final byte[] CODE_SSL_RSA_WITH_DES_CBC_SHA = { 0x00, 0x09 };
    static final byte[] CODE_SSL_RSA_WITH_3DES_EDE_CBC_SHA = { 0x00, 0x0A };
    static final byte[] CODE_SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = { 0x00, 0x11 };
    static final byte[] CODE_SSL_DHE_DSS_WITH_DES_CBC_SHA = { 0x00, 0x12 };
    static final byte[] CODE_SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA = { 0x00, 0x13 };
    static final byte[] CODE_SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = { 0x00, 0x14 };
    static final byte[] CODE_SSL_DHE_RSA_WITH_DES_CBC_SHA = { 0x00, 0x15 };
    static final byte[] CODE_SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA = { 0x00, 0x16 };
    static final byte[] CODE_SSL_DH_anon_EXPORT_WITH_RC4_40_MD5 = { 0x00, 0x17 };
    static final byte[] CODE_SSL_DH_anon_WITH_RC4_128_MD5 = { 0x00, 0x18 };
    static final byte[] CODE_SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA = { 0x00, 0x19 };
    static final byte[] CODE_SSL_DH_anon_WITH_DES_CBC_SHA = { 0x00, 0x1A };
    static final byte[] CODE_SSL_DH_anon_WITH_3DES_EDE_CBC_SHA = { 0x00, 0x1B };
    static final byte[] CODE_TLS_RSA_WITH_AES_128_CBC_SHA = { 0x00, 0x2F };
    static final byte[] CODE_TLS_DHE_DSS_WITH_AES_128_CBC_SHA = { 0x00, 0x32 };
    static final byte[] CODE_TLS_DHE_RSA_WITH_AES_128_CBC_SHA = { 0x00, 0x33 };
    static final byte[] CODE_TLS_DH_anon_WITH_AES_128_CBC_SHA = { 0x00, 0x34 };
    static final byte[] CODE_TLS_RSA_WITH_AES_256_CBC_SHA = { 0x00, 0x35 };
    static final byte[] CODE_TLS_DHE_DSS_WITH_AES_256_CBC_SHA = { 0x00, 0x38 };
    static final byte[] CODE_TLS_DHE_RSA_WITH_AES_256_CBC_SHA = { 0x00, 0x39 };
    static final byte[] CODE_TLS_DH_anon_WITH_AES_256_CBC_SHA = { 0x00, 0x3A };
    static final byte[] CODE_TLS_ECDH_ECDSA_WITH_NULL_SHA = { (byte) 0xc0, 0x01};
    static final byte[] CODE_TLS_ECDH_ECDSA_WITH_RC4_128_SHA = { (byte) 0xc0, 0x02};
    static final byte[] CODE_TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = { (byte) 0xc0, 0x03};
    static final byte[] CODE_TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = { (byte) 0xc0, 0x04};
    static final byte[] CODE_TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = { (byte) 0xc0, 0x05};
    static final byte[] CODE_TLS_ECDHE_ECDSA_WITH_NULL_SHA = { (byte) 0xc0, 0x06};
    static final byte[] CODE_TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = { (byte) 0xc0, 0x07};
    static final byte[] CODE_TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = { (byte) 0xc0, 0x08};
    static final byte[] CODE_TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = { (byte) 0xc0, 0x09};
    static final byte[] CODE_TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = { (byte) 0xc0, 0x0A};
    static final byte[] CODE_TLS_ECDH_RSA_WITH_NULL_SHA = { (byte) 0xc0, 0x0B};
    static final byte[] CODE_TLS_ECDH_RSA_WITH_RC4_128_SHA = { (byte) 0xc0, 0x0C};
    static final byte[] CODE_TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = { (byte) 0xc0, 0x0D};
    static final byte[] CODE_TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = { (byte) 0xc0, 0x0E};
    static final byte[] CODE_TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = { (byte) 0xc0, 0x0F};
    static final byte[] CODE_TLS_ECDHE_RSA_WITH_NULL_SHA = { (byte) 0xc0, 0x10};
    static final byte[] CODE_TLS_ECDHE_RSA_WITH_RC4_128_SHA = { (byte) 0xc0, 0x11};
    static final byte[] CODE_TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = { (byte) 0xc0, 0x12};
    static final byte[] CODE_TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = { (byte) 0xc0, 0x13};
    static final byte[] CODE_TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = { (byte) 0xc0, 0x14};
    static final byte[] CODE_TLS_ECDH_anon_WITH_NULL_SHA = { (byte) 0xc0, 0x15};
    static final byte[] CODE_TLS_ECDH_anon_WITH_RC4_128_SHA = { (byte) 0xc0, 0x16};
    static final byte[] CODE_TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = { (byte) 0xc0, 0x17};
    static final byte[] CODE_TLS_ECDH_anon_WITH_AES_128_CBC_SHA = { (byte) 0xc0, 0x18};
    static final byte[] CODE_TLS_ECDH_anon_WITH_AES_256_CBC_SHA = { (byte) 0xc0, 0x19};
    static final CipherSuite SSL_NULL_WITH_NULL_NULL = new CipherSuite(
            "SSL_NULL_WITH_NULL_NULL", true, 0, null, null, null,
            CODE_SSL_NULL_WITH_NULL_NULL);
    static final CipherSuite SSL_RSA_WITH_NULL_MD5 = new CipherSuite(
            "SSL_RSA_WITH_NULL_MD5", true, KEY_EXCHANGE_RSA, "RSA", null, "MD5",
            CODE_SSL_RSA_WITH_NULL_MD5);
    static final CipherSuite SSL_RSA_WITH_NULL_SHA = new CipherSuite(
            "SSL_RSA_WITH_NULL_SHA", true, KEY_EXCHANGE_RSA, "RSA", null, "SHA",
            CODE_SSL_RSA_WITH_NULL_SHA);
    static final CipherSuite SSL_RSA_EXPORT_WITH_RC4_40_MD5 = new CipherSuite(
            "SSL_RSA_EXPORT_WITH_RC4_40_MD5", true, KEY_EXCHANGE_RSA_EXPORT,
            "RSA", "RC4_40", "MD5", CODE_SSL_RSA_EXPORT_WITH_RC4_40_MD5);
    static final CipherSuite SSL_RSA_WITH_RC4_128_MD5 = new CipherSuite(
            "SSL_RSA_WITH_RC4_128_MD5", false, KEY_EXCHANGE_RSA, "RSA", "RC4_128",
            "MD5", CODE_SSL_RSA_WITH_RC4_128_MD5);
    static final CipherSuite SSL_RSA_WITH_RC4_128_SHA = new CipherSuite(
            "SSL_RSA_WITH_RC4_128_SHA", false, KEY_EXCHANGE_RSA, "RSA", "RC4_128",
            "SHA", CODE_SSL_RSA_WITH_RC4_128_SHA);
    static final CipherSuite SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5 = new CipherSuite(
            "SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5", true, KEY_EXCHANGE_RSA_EXPORT,
            "RSA", "RC2_CBC_40", "MD5", CODE_SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5);
    static final CipherSuite SSL_RSA_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", true, KEY_EXCHANGE_RSA_EXPORT,
            "RSA", "DES40_CBC", "SHA", CODE_SSL_RSA_EXPORT_WITH_DES40_CBC_SHA);
    static final CipherSuite SSL_RSA_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_RSA_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_RSA, "RSA", "DES_CBC",
            "SHA", CODE_SSL_RSA_WITH_DES_CBC_SHA);
    static final CipherSuite SSL_RSA_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_RSA_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_RSA,
            "RSA", "3DES_EDE_CBC", "SHA", CODE_SSL_RSA_WITH_3DES_EDE_CBC_SHA);
    static final CipherSuite SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", true,
            KEY_EXCHANGE_DHE_DSS_EXPORT, "DSA", "DES40_CBC", "SHA",
            CODE_SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA);
    static final CipherSuite SSL_DHE_DSS_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_DHE_DSS_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_DHE_DSS,
            "DSA", "DES_CBC", "SHA", CODE_SSL_DHE_DSS_WITH_DES_CBC_SHA);
    static final CipherSuite SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_DHE_DSS,
            "DSA", "3DES_EDE_CBC", "SHA", CODE_SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA);
    static final CipherSuite SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", true,
            KEY_EXCHANGE_DHE_RSA_EXPORT, "RSA", "DES40_CBC", "SHA",
            CODE_SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA);
    static final CipherSuite SSL_DHE_RSA_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_DHE_RSA_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_DHE_RSA,
            "RSA", "DES_CBC", "SHA", CODE_SSL_DHE_RSA_WITH_DES_CBC_SHA);
    static final CipherSuite SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_DHE_RSA,
            "RSA", "3DES_EDE_CBC", "SHA", CODE_SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA);
    static final CipherSuite SSL_DH_anon_EXPORT_WITH_RC4_40_MD5 = new CipherSuite(
            "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", true,
            KEY_EXCHANGE_DH_anon_EXPORT, "DH", "RC4_40", "MD5",
            CODE_SSL_DH_anon_EXPORT_WITH_RC4_40_MD5);
    static final CipherSuite SSL_DH_anon_WITH_RC4_128_MD5 = new CipherSuite(
            "SSL_DH_anon_WITH_RC4_128_MD5", false, KEY_EXCHANGE_DH_anon,
            "DH", "RC4_128", "MD5", CODE_SSL_DH_anon_WITH_RC4_128_MD5);
    static final CipherSuite SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", true,
            KEY_EXCHANGE_DH_anon_EXPORT, "DH", "DES40_CBC", "SHA",
            CODE_SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA);
    static final CipherSuite SSL_DH_anon_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_DH_anon_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_DH_anon,
            "DH", "DES_CBC", "SHA", CODE_SSL_DH_anon_WITH_DES_CBC_SHA);
    static final CipherSuite SSL_DH_anon_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_DH_anon,
            "DH", "3DES_EDE_CBC", "SHA", CODE_SSL_DH_anon_WITH_3DES_EDE_CBC_SHA);
    static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_RSA,
                              "RSA",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_RSA_WITH_AES_128_CBC_SHA);
    static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_DHE_DSS_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_DSS,
                              "DSA",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_DHE_DSS_WITH_AES_128_CBC_SHA);
    static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_DHE_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_RSA,
                              "RSA",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_DHE_RSA_WITH_AES_128_CBC_SHA);
    static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_DH_anon_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DH_anon,
                              "DH",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_DH_anon_WITH_AES_128_CBC_SHA);
    static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_RSA,
                              "RSA",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_RSA_WITH_AES_256_CBC_SHA);
    static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_DSS,
                              "DSA",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_DHE_DSS_WITH_AES_256_CBC_SHA);
    static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_DHE_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_RSA,
                              "RSA",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_DHE_RSA_WITH_AES_256_CBC_SHA);
    static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_DH_anon_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DH_anon,
                              "DH",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_DH_anon_WITH_AES_256_CBC_SHA);
    static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA
            = new CipherSuite("TLS_ECDH_ECDSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_NULL_SHA);
    static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA
            = new CipherSuite("TLS_ECDH_ECDSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_RC4_128_SHA);
    static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA
            = new CipherSuite("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA);
    static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA);
    static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA);
    static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA
            = new CipherSuite("TLS_ECDHE_ECDSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_NULL_SHA);
    static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA
            = new CipherSuite("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_RC4_128_SHA);
    static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA
            = new CipherSuite("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA);
    static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA);
    static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);
    static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA
            = new CipherSuite("TLS_ECDH_RSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_NULL_SHA);
    static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA
            = new CipherSuite("TLS_ECDH_RSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_RC4_128_SHA);
    static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA
            = new CipherSuite("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA);
    static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_AES_128_CBC_SHA);
    static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_AES_256_CBC_SHA);
    static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA
            = new CipherSuite("TLS_ECDHE_RSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_NULL_SHA);
    static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA
            = new CipherSuite("TLS_ECDHE_RSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_RC4_128_SHA);
    static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA
            = new CipherSuite("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA);
    static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
    static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA);
    static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA
            = new CipherSuite("TLS_ECDH_anon_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_NULL_SHA);
    static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA
            = new CipherSuite("TLS_ECDH_anon_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_RC4_128_SHA);
    static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA
            = new CipherSuite("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA);
    static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA
            = new CipherSuite("TLS_ECDH_anon_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_AES_128_CBC_SHA);
    static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA
            = new CipherSuite("TLS_ECDH_anon_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_AES_256_CBC_SHA);
    private static final CipherSuite[] SUITES_BY_CODE_0x00 = {
        
        SSL_NULL_WITH_NULL_NULL,                          
        SSL_RSA_WITH_NULL_MD5,                            
        SSL_RSA_WITH_NULL_SHA,                            
        SSL_RSA_EXPORT_WITH_RC4_40_MD5,                   
        SSL_RSA_WITH_RC4_128_MD5,                         
        SSL_RSA_WITH_RC4_128_SHA,                         
        
        null, 
        null, 
        
        SSL_RSA_EXPORT_WITH_DES40_CBC_SHA,                
        SSL_RSA_WITH_DES_CBC_SHA,                         
        SSL_RSA_WITH_3DES_EDE_CBC_SHA,                    
        
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        
        SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA,            
        SSL_DHE_DSS_WITH_DES_CBC_SHA,                     
        SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA,                
        SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA,            
        SSL_DHE_RSA_WITH_DES_CBC_SHA,                     
        SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA,                
        SSL_DH_anon_EXPORT_WITH_RC4_40_MD5,               
        SSL_DH_anon_WITH_RC4_128_MD5,                     
        SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA,            
        SSL_DH_anon_WITH_DES_CBC_SHA,                     
        SSL_DH_anon_WITH_3DES_EDE_CBC_SHA,                
        
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        null, 
        TLS_RSA_WITH_AES_128_CBC_SHA,                     
        null, 
        null, 
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA,                 
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA,                 
        TLS_DH_anon_WITH_AES_128_CBC_SHA,                 
        TLS_RSA_WITH_AES_256_CBC_SHA,                     
        null, 
        null, 
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA,                 
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA,                 
        TLS_DH_anon_WITH_AES_256_CBC_SHA,                 
        
    };
    private static final CipherSuite[] SUITES_BY_CODE_0xc0 = {
        null,                                             
        TLS_ECDH_ECDSA_WITH_NULL_SHA,                     
        TLS_ECDH_ECDSA_WITH_RC4_128_SHA,                  
        TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA,             
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA,              
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA,              
        TLS_ECDHE_ECDSA_WITH_NULL_SHA,                    
        TLS_ECDHE_ECDSA_WITH_RC4_128_SHA,                 
        TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA,            
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,             
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA,             
        TLS_ECDH_RSA_WITH_NULL_SHA,                       
        TLS_ECDH_RSA_WITH_RC4_128_SHA,                    
        TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA,               
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA,                
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA,                
        TLS_ECDHE_RSA_WITH_NULL_SHA,                      
        TLS_ECDHE_RSA_WITH_RC4_128_SHA,                   
        TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA,              
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,               
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,               
        TLS_ECDH_anon_WITH_NULL_SHA,                      
        TLS_ECDH_anon_WITH_RC4_128_SHA,                   
        TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA,              
        TLS_ECDH_anon_WITH_AES_128_CBC_SHA,               
        TLS_ECDH_anon_WITH_AES_256_CBC_SHA,               
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    };
    private static final Hashtable<String, CipherSuite> SUITES_BY_NAME;
    static final CipherSuite[] SUPPORTED_CIPHER_SUITES;
    static final String[] SUPPORTED_CIPHER_SUITE_NAMES;
    static final CipherSuite[] DEFAULT_CIPHER_SUITES;
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
    
    static final String KEY_TYPE_RSA = "RSA";
    static final String KEY_TYPE_DSA = "DSA";
    static final String KEY_TYPE_DH_RSA = "DH_RSA";
    static final String KEY_TYPE_DH_DSA = "DH_DSA";
    static final String KEY_TYPE_EC = "EC";
    static final String KEY_TYPE_EC_EC = "EC_EC";
    static final String KEY_TYPE_EC_RSA = "EC_RSA";
    static final byte TLS_CT_RSA_SIGN = 1;
    static final byte TLS_CT_DSS_SIGN = 2;
    static final byte TLS_CT_RSA_FIXED_DH = 3;
    static final byte TLS_CT_DSS_FIXED_DH = 4;
    static final byte TLS_CT_ECDSA_SIGN = 64;
    static final byte TLS_CT_RSA_FIXED_ECDH = 65;
    static final byte TLS_CT_ECDSA_FIXED_ECDH = 66;
    private static final String AUTH_TYPE_RSA = "RSA";
    private static final String AUTH_TYPE_RSA_EXPORT = "RSA_EXPORT";
    private static final String AUTH_TYPE_DHE_DSS = "DHE_DSS";
    private static final String AUTH_TYPE_DHE_RSA = "DHE_RSA";
    private static final String AUTH_TYPE_DH_DSS = "DH_DSS";
    private static final String AUTH_TYPE_DH_RSA = "DH_RSA";
    private static final String AUTH_TYPE_ECDH_ECDSA = "ECDH_ECDSA";
    private static final String AUTH_TYPE_ECDH_RSA = "ECDH_RSA";
    private static final String AUTH_TYPE_ECDHE_ECDSA = "ECDHE_ECDSA";
    private static final String AUTH_TYPE_ECDHE_RSA = "ECDHE_RSA";
}

