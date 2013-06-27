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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.700 -0400", hash_original_field = "CC6F6F66788638B9CE162A8016D9F45F", hash_generated_field = "31167280C241F9B17D639631F29E89F8")

    boolean supported = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "FEAC6633BEDFBC4AC4773516EA8E93FD", hash_generated_field = "FAA04C329C3BBD40436514A0BFECF651")

    int keyExchange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "280FA711B12D488436B7CDCBFB2543FC", hash_generated_field = "646723EE143F971BA7CBBEF15A14B911")

    String authType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "817CF575E42922F70648E318DCCF300A", hash_generated_field = "D7A4AB7796DE7F7B5F28166BAC9CA14D")

    String cipherName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "A5082972924409D0A29F908314B43554", hash_generated_field = "1B9CA4D35CF052E34AE02D26B8639B41")

    int keyMaterial;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "624D654218E7641AE6377DBEDC962CF2", hash_generated_field = "82AAF67303DF25D146F91143FBDDD6E8")

    int expandedKeyMaterial;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "04AE2243EED3D14897D0F0072BEC9A06", hash_generated_field = "4CBDA801C187B4605E64F46AEA891A1A")

    int effectiveKeyBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "6D60C4F537C75876721CE7A83E7E2D52", hash_generated_field = "159387C23F190CC3FE94572A49B7E04B")

    int ivSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "480D1B61A0432D1319F7504A3D7318DD", hash_generated_field = "04C3773A3BD2D8612D975B4AF160A96A")

    private int blockSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "3FC21B7AC372D5999F431A9049C44F9D", hash_generated_field = "9C6879ACFD3ACD2B8F6A3DB61F5802F7")

    private byte[] cipherSuiteCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "32EC2D0C46903E7857469CC8DA8E01DF", hash_generated_field = "E3762000F131D4540CC4F5BE4F282C71")

    private boolean isExportable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "C065C4D306BF6E5FA1384259F0502A16", hash_generated_field = "FA3FEC41411B55E226E2067875BD3B74")

    private String hashName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "77885BF6472170A0C07034A5B96EAEC9", hash_generated_field = "F6E855DA27DE62B9374233E3385207F7")

    private String hmacName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.701 -0400", hash_original_field = "17344FAD2A9882D4E6795004CF283C78", hash_generated_field = "FBF2A1556B0034F6A3D1102F2996A7CB")

    private int hashSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.717 -0400", hash_original_method = "54B6F4B5E133F8A61DA406B9859D0D86", hash_generated_method = "951409E8F50C591689F1929DD304BE22")
    private  CipherSuite(String name, boolean isExportable, int keyExchange,
            String authType, String cipherName, String hash, byte[] code) {
        this.name = name;
        this.keyExchange = keyExchange;
        this.authType = authType;
        this.isExportable = isExportable;
        {
            this.cipherName = null;
            keyMaterial = 0;
            expandedKeyMaterial = 0;
            effectiveKeyBytes = 0;
            ivSize = 0;
            blockSize = 0;
        } //End block
        {
            boolean var83FE4A621033DBF86A035303348C9069_1022737818 = ("RC4_40".equals(cipherName));
            {
                this.cipherName = "RC4";
                keyMaterial = 5;
                expandedKeyMaterial = 16;
                effectiveKeyBytes = 5;
                ivSize = 0;
                blockSize = 0;
            } //End block
            {
                boolean varBFA52D54AB4E451C86478190B088F490_1315064927 = ("RC4_128".equals(cipherName));
                {
                    this.cipherName = "RC4";
                    keyMaterial = 16;
                    expandedKeyMaterial = 16;
                    effectiveKeyBytes = 16;
                    ivSize = 0;
                    blockSize = 0;
                } //End block
                {
                    boolean var169A581047F02ED212E0D86EC911CFF3_592518109 = ("DES40_CBC".equals(cipherName));
                    {
                        this.cipherName = "DES/CBC/NoPadding";
                        keyMaterial = 5;
                        expandedKeyMaterial = 8;
                        effectiveKeyBytes = 5;
                        ivSize = 8;
                        blockSize = 8;
                    } //End block
                    {
                        boolean varBA299225572A2EEF4B69DFBC7FAB0C2C_271130969 = ("DES_CBC".equals(cipherName));
                        {
                            this.cipherName = "DES/CBC/NoPadding";
                            keyMaterial = 8;
                            expandedKeyMaterial = 8;
                            effectiveKeyBytes = 7;
                            ivSize = 8;
                            blockSize = 8;
                        } //End block
                        {
                            boolean var2AFD38E7932DB50B2E8247936CF045C0_1802807065 = ("3DES_EDE_CBC".equals(cipherName));
                            {
                                this.cipherName = "DESede/CBC/NoPadding";
                                keyMaterial = 24;
                                expandedKeyMaterial = 24;
                                effectiveKeyBytes = 24;
                                ivSize = 8;
                                blockSize = 8;
                            } //End block
                            {
                                boolean var40782AB2EBC9AF3EEA4D4BE96870414B_607797380 = ("AES_128_CBC".equals(cipherName));
                                {
                                    this.cipherName = "AES/CBC/NoPadding";
                                    keyMaterial = 16;
                                    expandedKeyMaterial = 16;
                                    effectiveKeyBytes = 16;
                                    ivSize = 16;
                                    blockSize = 16;
                                } //End block
                                {
                                    boolean var031F9B85D3909EA1CA5883928E3FDDA1_1678912919 = ("AES_256_CBC".equals(cipherName));
                                    {
                                        this.cipherName = "AES/CBC/NoPadding";
                                        keyMaterial = 32;
                                        expandedKeyMaterial = 32;
                                        effectiveKeyBytes = 32;
                                        ivSize = 16;
                                        blockSize = 16;
                                    } //End block
                                    {
                                        this.cipherName = cipherName;
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
            boolean varFE5CFE390B831904898301B5035F64A1_787069173 = ("MD5".equals(hash));
            {
                this.hmacName = "HmacMD5";
                this.hashName = "MD5";
                hashSize = 16;
            } //End block
            {
                boolean var1247556C4F383A0C34B50551B10A24FE_1100213704 = ("SHA".equals(hash));
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
        cipherSuiteCode = code;
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
            boolean var8F5354B22BBD8A425CE718DC6EB34B8F_2044847018 = (this.name.startsWith("TLS_EC"));
            {
                supported = false;
            } //End block
        } //End collapsed parenthetic
        addTaint(hash.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.737 -0400", hash_original_method = "92638E1F733B540A4060D31FD00C2E43", hash_generated_method = "1F6D1E817E41FA57930A9114DB97FD3E")
    public boolean isAnonymous() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1128794654 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1128794654;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.738 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "7E94619CEAF5A213CCB02DBCC2E53C62")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1547619434 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1547619434 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1547619434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1547619434;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.738 -0400", hash_original_method = "914B5E2C4522C674B906D3A88195AF81", hash_generated_method = "1CD093E877CF024D8D12D0DC34FFDFD2")
    public byte[] toBytes() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1202576601 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1202576601;
        // ---------- Original Method ----------
        //return cipherSuiteCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.738 -0400", hash_original_method = "D4E6F2D9338FE775902AE34CF280ED17", hash_generated_method = "35BA7DE95D1C55A72F8CB79C1D5C1F11")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1241420994 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1241420994 = name + ": " + cipherSuiteCode[0] + " " + cipherSuiteCode[1];
        varB4EAC82CA7396A68D541C85D26508E83_1241420994.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1241420994;
        // ---------- Original Method ----------
        //return name + ": " + cipherSuiteCode[0] + " " + cipherSuiteCode[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.739 -0400", hash_original_method = "7D208669D7EDDA60D0FD344147D9AAD6", hash_generated_method = "8DB1CDA2A5D1E6E55626B8C049F4D83F")
    public String getBulkEncryptionAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1166341143 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1166341143 = cipherName;
        varB4EAC82CA7396A68D541C85D26508E83_1166341143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1166341143;
        // ---------- Original Method ----------
        //return cipherName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.742 -0400", hash_original_method = "E03DB665D968D86F8F6FEC0B3CE97B35", hash_generated_method = "A4895ACC4DC88731EF3B260A32FCE8DE")
    public int getBlockSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572225477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572225477;
        // ---------- Original Method ----------
        //return blockSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.742 -0400", hash_original_method = "58CBEDAB9C64FBF2F046D83798145AD9", hash_generated_method = "50FD84BFD091D2119C2656023DD41829")
    public String getHmacName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1948107526 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1948107526 = hmacName;
        varB4EAC82CA7396A68D541C85D26508E83_1948107526.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1948107526;
        // ---------- Original Method ----------
        //return hmacName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.742 -0400", hash_original_method = "D391A3C678BDD6A89326831F4F051E38", hash_generated_method = "223838B640F9EE1A8DE6DFA86495842B")
    public String getHashName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1428272962 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1428272962 = hashName;
        varB4EAC82CA7396A68D541C85D26508E83_1428272962.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1428272962;
        // ---------- Original Method ----------
        //return hashName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.751 -0400", hash_original_method = "5CA4B8D3CBACCFD69EE0CC1B72A2F92B", hash_generated_method = "E5D755D701CF5C0C9CFF2BE6A85FD5CA")
    public int getMACLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654408639 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654408639;
        // ---------- Original Method ----------
        //return hashSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.751 -0400", hash_original_method = "3DD67552ED8C1FF65B79535A2E5F00F8", hash_generated_method = "554064F9D0552BED89F5476DC46F9920")
    public boolean isExportable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472684232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_472684232;
        // ---------- Original Method ----------
        //return isExportable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.752 -0400", hash_original_method = "936867E36B0EB6E36D3CC4941D208DF5", hash_generated_method = "3BE1BD3899A3F6E2E57DB55CFFE35333")
    public String getServerKeyType() {
        String varB4EAC82CA7396A68D541C85D26508E83_398430455 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1756851732 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_693306568 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_2058759147 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1154417745 = null; //Variable for return #5
        //Begin case KEY_EXCHANGE_DHE_RSA KEY_EXCHANGE_DHE_RSA_EXPORT KEY_EXCHANGE_ECDHE_RSA KEY_EXCHANGE_RSA KEY_EXCHANGE_RSA_EXPORT 
        varB4EAC82CA7396A68D541C85D26508E83_398430455 = KEY_TYPE_RSA;
        //End case KEY_EXCHANGE_DHE_RSA KEY_EXCHANGE_DHE_RSA_EXPORT KEY_EXCHANGE_ECDHE_RSA KEY_EXCHANGE_RSA KEY_EXCHANGE_RSA_EXPORT 
        //Begin case KEY_EXCHANGE_DHE_DSS KEY_EXCHANGE_DHE_DSS_EXPORT 
        varB4EAC82CA7396A68D541C85D26508E83_1756851732 = KEY_TYPE_DSA;
        //End case KEY_EXCHANGE_DHE_DSS KEY_EXCHANGE_DHE_DSS_EXPORT 
        //Begin case KEY_EXCHANGE_ECDH_ECDSA KEY_EXCHANGE_ECDHE_ECDSA 
        varB4EAC82CA7396A68D541C85D26508E83_693306568 = KEY_TYPE_EC_EC;
        //End case KEY_EXCHANGE_ECDH_ECDSA KEY_EXCHANGE_ECDHE_ECDSA 
        //Begin case KEY_EXCHANGE_ECDH_RSA 
        varB4EAC82CA7396A68D541C85D26508E83_2058759147 = KEY_TYPE_EC_RSA;
        //End case KEY_EXCHANGE_ECDH_RSA 
        //Begin case KEY_EXCHANGE_DH_anon KEY_EXCHANGE_DH_anon_EXPORT KEY_EXCHANGE_ECDH_anon 
        varB4EAC82CA7396A68D541C85D26508E83_1154417745 = null;
        //End case KEY_EXCHANGE_DH_anon KEY_EXCHANGE_DH_anon_EXPORT KEY_EXCHANGE_ECDH_anon 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unknown key type for key exchange " + keyExchange);
        //End case default 
        String varA7E53CE21691AB073D9660D615818899_1360954774; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1360954774 = varB4EAC82CA7396A68D541C85D26508E83_398430455;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1360954774 = varB4EAC82CA7396A68D541C85D26508E83_1756851732;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1360954774 = varB4EAC82CA7396A68D541C85D26508E83_693306568;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1360954774 = varB4EAC82CA7396A68D541C85D26508E83_2058759147;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1360954774 = varB4EAC82CA7396A68D541C85D26508E83_1154417745;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1360954774.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1360954774;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.754 -0400", hash_original_method = "0C964AFB9ED36BE0A1810A2A5E5F4637", hash_generated_method = "E54A988E6FAA737AC658A3784F9EFFAD")
    public String getAuthType(boolean emphemeral) {
        String varB4EAC82CA7396A68D541C85D26508E83_1818294738 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1398650991 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_685237840 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_678154632 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1751194962 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_606187683 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_1074431546 = null; //Variable for return #7
        String varB4EAC82CA7396A68D541C85D26508E83_1029121745 = null; //Variable for return #8
        String varB4EAC82CA7396A68D541C85D26508E83_1483150441 = null; //Variable for return #9
        //Begin case KEY_EXCHANGE_RSA 
        varB4EAC82CA7396A68D541C85D26508E83_1818294738 = AUTH_TYPE_RSA;
        //End case KEY_EXCHANGE_RSA 
        //Begin case KEY_EXCHANGE_RSA_EXPORT 
        varB4EAC82CA7396A68D541C85D26508E83_1398650991 = emphemeral ? AUTH_TYPE_RSA_EXPORT : AUTH_TYPE_RSA;
        //End case KEY_EXCHANGE_RSA_EXPORT 
        //Begin case KEY_EXCHANGE_DHE_DSS KEY_EXCHANGE_DHE_DSS_EXPORT 
        varB4EAC82CA7396A68D541C85D26508E83_685237840 = AUTH_TYPE_DHE_DSS;
        //End case KEY_EXCHANGE_DHE_DSS KEY_EXCHANGE_DHE_DSS_EXPORT 
        //Begin case KEY_EXCHANGE_DHE_RSA KEY_EXCHANGE_DHE_RSA_EXPORT 
        varB4EAC82CA7396A68D541C85D26508E83_678154632 = AUTH_TYPE_DHE_RSA;
        //End case KEY_EXCHANGE_DHE_RSA KEY_EXCHANGE_DHE_RSA_EXPORT 
        //Begin case KEY_EXCHANGE_ECDH_ECDSA 
        varB4EAC82CA7396A68D541C85D26508E83_1751194962 = AUTH_TYPE_ECDH_ECDSA;
        //End case KEY_EXCHANGE_ECDH_ECDSA 
        //Begin case KEY_EXCHANGE_ECDHE_ECDSA 
        varB4EAC82CA7396A68D541C85D26508E83_606187683 = AUTH_TYPE_ECDHE_ECDSA;
        //End case KEY_EXCHANGE_ECDHE_ECDSA 
        //Begin case KEY_EXCHANGE_ECDH_RSA 
        varB4EAC82CA7396A68D541C85D26508E83_1074431546 = AUTH_TYPE_ECDH_RSA;
        //End case KEY_EXCHANGE_ECDH_RSA 
        //Begin case KEY_EXCHANGE_ECDHE_RSA 
        varB4EAC82CA7396A68D541C85D26508E83_1029121745 = AUTH_TYPE_ECDHE_RSA;
        //End case KEY_EXCHANGE_ECDHE_RSA 
        //Begin case KEY_EXCHANGE_DH_anon KEY_EXCHANGE_DH_anon_EXPORT KEY_EXCHANGE_ECDH_anon 
        varB4EAC82CA7396A68D541C85D26508E83_1483150441 = null;
        //End case KEY_EXCHANGE_DH_anon KEY_EXCHANGE_DH_anon_EXPORT KEY_EXCHANGE_ECDH_anon 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unknown auth type for key exchange " + keyExchange);
        //End case default 
        addTaint(emphemeral);
        String varA7E53CE21691AB073D9660D615818899_579954522; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_579954522 = varB4EAC82CA7396A68D541C85D26508E83_1818294738;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_579954522 = varB4EAC82CA7396A68D541C85D26508E83_1398650991;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_579954522 = varB4EAC82CA7396A68D541C85D26508E83_685237840;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_579954522 = varB4EAC82CA7396A68D541C85D26508E83_678154632;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_579954522 = varB4EAC82CA7396A68D541C85D26508E83_1751194962;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_579954522 = varB4EAC82CA7396A68D541C85D26508E83_606187683;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_579954522 = varB4EAC82CA7396A68D541C85D26508E83_1074431546;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_579954522 = varB4EAC82CA7396A68D541C85D26508E83_1029121745;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_579954522 = varB4EAC82CA7396A68D541C85D26508E83_1483150441;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_579954522.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_579954522;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "1EADA2FD3179B8D0FEB9D904D12CACE3", hash_generated_field = "5CD67EE5BB0770A363D637593B5FC144")

    static int KEY_EXCHANGE_RSA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "490CC8C530D1452DF9711343F18D14F1", hash_generated_field = "1734407AA79C412278C9CADBBF074595")

    static int KEY_EXCHANGE_RSA_EXPORT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "87F46877B39B062A4410F83AB5515A0E", hash_generated_field = "235D3E2B4DAC7DCD8DC4C2E804A8CACC")

    static int KEY_EXCHANGE_DHE_DSS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "40F6CEA7F55B90D129B951E9C15BE5E6", hash_generated_field = "60ABAFE74BC9A410B38521C1A83E38B9")

    static int KEY_EXCHANGE_DHE_DSS_EXPORT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "2D7852A57D9686837625361299364DAF", hash_generated_field = "F8EB44B5487CE32DB9EEECCD1578B44F")

    static int KEY_EXCHANGE_DHE_RSA = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "B800A617E5403D015415722FD2DE298A", hash_generated_field = "22A83E70727685F270BEF54E5B2428D8")

    static int KEY_EXCHANGE_DHE_RSA_EXPORT = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "17F8D1E5352C598E192C692CA944A85B", hash_generated_field = "D67F8CF6083FC53460C81B835AECCE03")

    static int KEY_EXCHANGE_DH_anon = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "BE0DA7E24112ACDF68784534FB49D212", hash_generated_field = "016149524C61233FDEBDF655061D7693")

    static int KEY_EXCHANGE_DH_anon_EXPORT = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "AA7672EC87838BCBBFC612F81A7DBFE3", hash_generated_field = "F46659946162EECFB0D15208D9133C29")

    static int KEY_EXCHANGE_ECDH_ECDSA = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "DFCB3485FA00A3EBB16BD0F4FFE54310", hash_generated_field = "52737236D57CCD3C0D2C51CEB868E69D")

    static int KEY_EXCHANGE_ECDHE_ECDSA = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "DC4C6A663915BFF1DA6F6E1E6CC829A0", hash_generated_field = "33BDD21FE7C5D26655A9876929AAA07C")

    static int KEY_EXCHANGE_ECDH_RSA = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "F28CAA3F5CCB928E6EF67CAD057AC0C4", hash_generated_field = "9FE626F8DE9A1BF3B6B4DA951050D18C")

    static int KEY_EXCHANGE_ECDHE_RSA = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "B9BE25E12B49387FC37E511161C8499C", hash_generated_field = "A824A2BC8A9DACC846A3775F4E298C96")

    static int KEY_EXCHANGE_ECDH_anon = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "A3B60EBC835C0EE0EEAA042474E74109", hash_generated_field = "65C6E9B531FB1D9D838D7E42EC02DF3B")

    static byte[] CODE_SSL_NULL_WITH_NULL_NULL = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "832058CD3C97FEEB2AFE4A8BBA131A8B", hash_generated_field = "0F755D9D2787C245279C02EFD0BD427B")

    static byte[] CODE_SSL_RSA_WITH_NULL_MD5 = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "F3AF4CD7058A0CC26CE84A7B2568FB7D", hash_generated_field = "964DE837E6713EFCF9979905C72E7D0E")

    static byte[] CODE_SSL_RSA_WITH_NULL_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "ADAEC62BC94C615532BA6A56F37FA085", hash_generated_field = "744E24839B3BF2214B6DCFF344F6FA48")

    static byte[] CODE_SSL_RSA_EXPORT_WITH_RC4_40_MD5 = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "48BD34F40882CCB17E67E15E3FD6ACE8", hash_generated_field = "0F74A5602327231256FEAE393BAED830")

    static byte[] CODE_SSL_RSA_WITH_RC4_128_MD5 = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.755 -0400", hash_original_field = "DDECEDC38650EF98CD1ABBF03712B0F3", hash_generated_field = "F0BBA199FAF085E803F84A9168A244E8")

    static byte[] CODE_SSL_RSA_WITH_RC4_128_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "87B4A61F1B6F5E388672FA42830E3F82", hash_generated_field = "5EDD1FC182379C50C840BA203DDD0E66")

    static byte[] CODE_SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5 = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "64086580268B509776CCACA32029BB33", hash_generated_field = "CA31AE39EAD2FC3CA2CFF955CBF0A60C")

    static byte[] CODE_SSL_RSA_EXPORT_WITH_DES40_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "3FFDCD0CEE501007FE5BF9E6279E78ED", hash_generated_field = "F0234185CED004DDC8A55520FAC450B3")

    static byte[] CODE_SSL_RSA_WITH_DES_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "F7BD891A1D3853B9EC5741D0DC9233BC", hash_generated_field = "4F812B03BB8E48C1A1A3135561986DB8")

    static byte[] CODE_SSL_RSA_WITH_3DES_EDE_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "38B139BCB0875D9E630A617AD18D4C79", hash_generated_field = "7A764F6101AB4D1F2CF551AEB08997CD")

    static byte[] CODE_SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "388487396F477A9D3729CD71F70DDD07", hash_generated_field = "7970E45DAB04DE2AE4E4645004462DC7")

    static byte[] CODE_SSL_DHE_DSS_WITH_DES_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "123F7F942D27F5396EEE0A5DB5055439", hash_generated_field = "81895E047EE45AE95AEC64B2A8FE83E7")

    static byte[] CODE_SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "09CB4CD30F484326CBBF4312B52A0209", hash_generated_field = "682E3E894376AE3A4976D72C49D74C1B")

    static byte[] CODE_SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "34C85B6AF17156D4A17EEDC5926CE450", hash_generated_field = "AB309CD01F36EE5A4BEFAA34623A3029")

    static byte[] CODE_SSL_DHE_RSA_WITH_DES_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "DFB585F8963B330D9FBC95252471710C", hash_generated_field = "09FD9868BD9909C2E4A5513166767A4F")

    static byte[] CODE_SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "815ABF482944674D3695908038E88D9F", hash_generated_field = "6968C84309B071D7BEFAD20A5653C36E")

    static byte[] CODE_SSL_DH_anon_EXPORT_WITH_RC4_40_MD5 = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "5E7C9472B5CC3788CF5129B08A612F50", hash_generated_field = "113F634C123FC50D5515557202319C7B")

    static byte[] CODE_SSL_DH_anon_WITH_RC4_128_MD5 = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "F415E8E0501EF84C8595852D501DA381", hash_generated_field = "3EDF319978E2D34FAD9B07A65D191223")

    static byte[] CODE_SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "C446E438CC48B486A53623DE6BF9EC47", hash_generated_field = "2A502DBE3C1DE5D906E5D46E6612E8CB")

    static byte[] CODE_SSL_DH_anon_WITH_DES_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "1D1E827885DA47D472F83ADF122E1FA8", hash_generated_field = "6DE8C861FAF677A5DF07B244FF12033B")

    static byte[] CODE_SSL_DH_anon_WITH_3DES_EDE_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "9E47734DC10691062D8070B4E5AB39AA", hash_generated_field = "AC5DCDEB093C6E352E84FA9E19608194")

    static byte[] CODE_TLS_RSA_WITH_AES_128_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "B6D0F1D6EE4C420573F0BA0B9EF44F7A", hash_generated_field = "344A3B16CA54C518A1A9FEFC663D800D")

    static byte[] CODE_TLS_DHE_DSS_WITH_AES_128_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "8AC1DE6E4718884010B01D5B44467071", hash_generated_field = "CC0F5B2A65172D26F4E2B70F3FEB2BF9")

    static byte[] CODE_TLS_DHE_RSA_WITH_AES_128_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "97CD85EA97E55E42672A21F13B06EB2F", hash_generated_field = "2565208DAEDECE8FCB81557B28300CDB")

    static byte[] CODE_TLS_DH_anon_WITH_AES_128_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "63758E2B41CDC1385A27D6A590780BA6", hash_generated_field = "A2F2087E5E6F97378B7AF0FC12B47D90")

    static byte[] CODE_TLS_RSA_WITH_AES_256_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "047FC708BA3897DDE53B56121945F594", hash_generated_field = "5EE3AEDD9C8ADE28B245E50ED989CF3A")

    static byte[] CODE_TLS_DHE_DSS_WITH_AES_256_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "05DECCE337235F1FED3912A09C408A63", hash_generated_field = "F8596F97FE2B5E32F806C2ABCBCB61E6")

    static byte[] CODE_TLS_DHE_RSA_WITH_AES_256_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "D625DC0D01728BD1D9D44005F95D6841", hash_generated_field = "8489CC92FCCDA2D752FF98692EBB4E49")

    static byte[] CODE_TLS_DH_anon_WITH_AES_256_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "545122CFACFE8AB04C4EEC549DF590F2", hash_generated_field = "5AF3E50D070BBAF361E6FD6F1DF542B0")

    static byte[] CODE_TLS_ECDH_ECDSA_WITH_NULL_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "2B41C6A9CA3D29D3232AC9825A690F69", hash_generated_field = "91A2B66049B64B3760D224E3FB80A88A")

    static byte[] CODE_TLS_ECDH_ECDSA_WITH_RC4_128_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.756 -0400", hash_original_field = "F4220CA3660BAEBA0DD271CFCBA08C47", hash_generated_field = "F6CBF8426BD78D8C8AB962502B1ED7E6")

    static byte[] CODE_TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "E2ACE0EE70A8845417753667AA9C78D6", hash_generated_field = "183B331BD576943CD936170392D71BED")

    static byte[] CODE_TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "E8E385203BC450F89D1A1E07F88D9DBB", hash_generated_field = "8DC7527604084188D0925F3998C6B009")

    static byte[] CODE_TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "B19EDBFB6F25DF72D57CDD01D9A72FCC", hash_generated_field = "B4C2B7F625CF12F1C44A642445F8B00D")

    static byte[] CODE_TLS_ECDHE_ECDSA_WITH_NULL_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "D01B407A64A18F00D506788C4866F7BD", hash_generated_field = "14B5D5C03CDDBD66C9CEBEAD374E3E59")

    static byte[] CODE_TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "3B4762D1AE694F0CF9CEABE659D038EE", hash_generated_field = "C6FB39C00B8DDC5FD3A78F559DF761D7")

    static byte[] CODE_TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "9ABDC20BA9BD1AB2199999A23F6CE5DE", hash_generated_field = "8A9BE7367BE211A907DC69FB3FB169AD")

    static byte[] CODE_TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "3E3A9E303F2171130A1CC7C4AB35C125", hash_generated_field = "807866DB869BEA11F4DB920E9C687FE9")

    static byte[] CODE_TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "51C1AE0CE9E7A2991E28165CB9731FB0", hash_generated_field = "3A4583FD5B2FEA328CAE2EED31721712")

    static byte[] CODE_TLS_ECDH_RSA_WITH_NULL_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "0729B620DD76B480CC11A4FD44018B07", hash_generated_field = "99850CB3F8B214D01347A963105C3794")

    static byte[] CODE_TLS_ECDH_RSA_WITH_RC4_128_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "AAEEF73282E9F821CFFAF81354267701", hash_generated_field = "A6D9ADBC7919B3BD1DA374CE6B6A877A")

    static byte[] CODE_TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "DBDE2C8C8AC9EBEF323EED6F576E9F1A", hash_generated_field = "BC6C365A89BD85B6CB5B55D4F4FA8D70")

    static byte[] CODE_TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "DDC9329716D48E3B41AC398E1009097C", hash_generated_field = "F373B2A1FB4826024041AEC8B8329FF3")

    static byte[] CODE_TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "53884C57D5949FF31DC6B565F8DA1D05", hash_generated_field = "F1257893351CD8CCC7EDD38E7DEA978B")

    static byte[] CODE_TLS_ECDHE_RSA_WITH_NULL_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "A03C6750E3DC000C4DC70BE6724F8501", hash_generated_field = "F86169AA48D23AA3C2E6F13B71EF6000")

    static byte[] CODE_TLS_ECDHE_RSA_WITH_RC4_128_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "A27E2E694EA4C6C4455E0DF022E77BD8", hash_generated_field = "7ADBACF70E39F5E76C59009A0516C6D0")

    static byte[] CODE_TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "58684AA63852A7DD4C7E73C0BB91C2AC", hash_generated_field = "4B8F5334ECE17A6982B66C63AE39DDBA")

    static byte[] CODE_TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "4A68CD49DE83648C8037E2BD51D64E9B", hash_generated_field = "CA8BBEC9B8222ABA0E3509AAA0C71F21")

    static byte[] CODE_TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "461BBD1E8686E07BAF9451DD71403375", hash_generated_field = "CB890082C30A47C54181C4E85AF9B73C")

    static byte[] CODE_TLS_ECDH_anon_WITH_NULL_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "126736459CDB2123CAC1ECB9F920339A", hash_generated_field = "99EB3E4E975692B820BFCF55CCF8A88D")

    static byte[] CODE_TLS_ECDH_anon_WITH_RC4_128_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "2C1E2201FFA53643758DE6FF2D2873C5", hash_generated_field = "9A74CA859DD65D200B21F41CFF434616")

    static byte[] CODE_TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "7394FC616E41F1DB89C9DCA12860126D", hash_generated_field = "1A0F4749B5C7A6A0017FDC095573B970")

    static byte[] CODE_TLS_ECDH_anon_WITH_AES_128_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "AD75CFE31C731F6ECD0500A8C803E509", hash_generated_field = "8B84E8656EF0B66AD8864BA5C77289CE")

    static byte[] CODE_TLS_ECDH_anon_WITH_AES_256_CBC_SHA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "0E026A2BB8DBF6E5A90171A125ECF050", hash_generated_field = "9EAE711E118B37C17D2C07CD767A4E86")

    static CipherSuite SSL_NULL_WITH_NULL_NULL = new CipherSuite(
            "SSL_NULL_WITH_NULL_NULL", true, 0, null, null, null,
            CODE_SSL_NULL_WITH_NULL_NULL);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "D720000B4AEEF166B48AAC897E65372B", hash_generated_field = "8FE0BF470582EF8BBD551D638A0FF22D")

    static CipherSuite SSL_RSA_WITH_NULL_MD5 = new CipherSuite(
            "SSL_RSA_WITH_NULL_MD5", true, KEY_EXCHANGE_RSA, "RSA", null, "MD5",
            CODE_SSL_RSA_WITH_NULL_MD5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "20880BF8C26E4FD06DF166BC8EFB450F", hash_generated_field = "774AA5AF9E4FD239229B1D6717BFE9F4")

    static CipherSuite SSL_RSA_WITH_NULL_SHA = new CipherSuite(
            "SSL_RSA_WITH_NULL_SHA", true, KEY_EXCHANGE_RSA, "RSA", null, "SHA",
            CODE_SSL_RSA_WITH_NULL_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.757 -0400", hash_original_field = "6753F2BA1B87D93B4A2C43D8CEC29627", hash_generated_field = "F252ABA86A590F9C4BDCCBBAE6A61309")

    static CipherSuite SSL_RSA_EXPORT_WITH_RC4_40_MD5 = new CipherSuite(
            "SSL_RSA_EXPORT_WITH_RC4_40_MD5", true, KEY_EXCHANGE_RSA_EXPORT,
            "RSA", "RC4_40", "MD5", CODE_SSL_RSA_EXPORT_WITH_RC4_40_MD5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "C8E50F28D2CF79FDF5E05A031B0EAA21", hash_generated_field = "E9F3AD558D650A04762765F39F922485")

    static CipherSuite SSL_RSA_WITH_RC4_128_MD5 = new CipherSuite(
            "SSL_RSA_WITH_RC4_128_MD5", false, KEY_EXCHANGE_RSA, "RSA", "RC4_128",
            "MD5", CODE_SSL_RSA_WITH_RC4_128_MD5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "4938B12276F524E6690A71ADB3F85591", hash_generated_field = "C1E3D12CD0F0DEDC84CB802F3C6E0BA4")

    static CipherSuite SSL_RSA_WITH_RC4_128_SHA = new CipherSuite(
            "SSL_RSA_WITH_RC4_128_SHA", false, KEY_EXCHANGE_RSA, "RSA", "RC4_128",
            "SHA", CODE_SSL_RSA_WITH_RC4_128_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "96CE0358DDE9EA717BC9A1F00576B112", hash_generated_field = "3722E86D68776693036151D3B5748ACE")

    static CipherSuite SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5 = new CipherSuite(
            "SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5", true, KEY_EXCHANGE_RSA_EXPORT,
            "RSA", "RC2_CBC_40", "MD5", CODE_SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "9304DD34416FFF64055A03DF3A8A73DA", hash_generated_field = "94D6EDE2EC297001E81F8A9E4C1FB352")

    static CipherSuite SSL_RSA_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", true, KEY_EXCHANGE_RSA_EXPORT,
            "RSA", "DES40_CBC", "SHA", CODE_SSL_RSA_EXPORT_WITH_DES40_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "6064563D7CBA50EE004045E9F7278D5F", hash_generated_field = "25064653DD23CDF0DF0AD2332747EE40")

    static CipherSuite SSL_RSA_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_RSA_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_RSA, "RSA", "DES_CBC",
            "SHA", CODE_SSL_RSA_WITH_DES_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "F61022838378E5CAF11D1E47E24F466F", hash_generated_field = "02DBCA319682ACD79E6A353DA2F21654")

    static CipherSuite SSL_RSA_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_RSA_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_RSA,
            "RSA", "3DES_EDE_CBC", "SHA", CODE_SSL_RSA_WITH_3DES_EDE_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "9D85F612C2D1BB1B8F5E4A5CDA9CED18", hash_generated_field = "C8C09CCE0168371A28E8222C6855429F")

    static CipherSuite SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", true,
            KEY_EXCHANGE_DHE_DSS_EXPORT, "DSA", "DES40_CBC", "SHA",
            CODE_SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "B908AEBD55FCCA1CE62E3643564C0CFC", hash_generated_field = "E53DC51BD8CCE2D8F0FC6BFEB7B08A0C")

    static CipherSuite SSL_DHE_DSS_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_DHE_DSS_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_DHE_DSS,
            "DSA", "DES_CBC", "SHA", CODE_SSL_DHE_DSS_WITH_DES_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "C85161F72971511CF61E69A040A1F13E", hash_generated_field = "D21D6760AA0837F6C3CC633102155B4B")

    static CipherSuite SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_DHE_DSS,
            "DSA", "3DES_EDE_CBC", "SHA", CODE_SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "138342A71D6455B7AC7A617F4A61E8AA", hash_generated_field = "CE926DB16CB26ED803CE2FCA45D37263")

    static CipherSuite SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", true,
            KEY_EXCHANGE_DHE_RSA_EXPORT, "RSA", "DES40_CBC", "SHA",
            CODE_SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "047FAAE97F183186ADB0278F529B801E", hash_generated_field = "091BE3ADD48D8FE5699F934367909379")

    static CipherSuite SSL_DHE_RSA_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_DHE_RSA_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_DHE_RSA,
            "RSA", "DES_CBC", "SHA", CODE_SSL_DHE_RSA_WITH_DES_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "8C30899685913E7E974E18030EA22231", hash_generated_field = "D1DC51BDD4E4492C683DCD25A6476509")

    static CipherSuite SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_DHE_RSA,
            "RSA", "3DES_EDE_CBC", "SHA", CODE_SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "B549BA0C272BFC6103285AD96530FC4A", hash_generated_field = "507C568CA5657C3DBF078BE5BA7168A8")

    static CipherSuite SSL_DH_anon_EXPORT_WITH_RC4_40_MD5 = new CipherSuite(
            "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", true,
            KEY_EXCHANGE_DH_anon_EXPORT, "DH", "RC4_40", "MD5",
            CODE_SSL_DH_anon_EXPORT_WITH_RC4_40_MD5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "DAB9E7A6C4C27152C1A619AFF313D22F", hash_generated_field = "D8968259F4B30CCC402B520E533E09E7")

    static CipherSuite SSL_DH_anon_WITH_RC4_128_MD5 = new CipherSuite(
            "SSL_DH_anon_WITH_RC4_128_MD5", false, KEY_EXCHANGE_DH_anon,
            "DH", "RC4_128", "MD5", CODE_SSL_DH_anon_WITH_RC4_128_MD5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "0A035189AA32BD98F728EE11A293031F", hash_generated_field = "FC12B181F79BB1202D22FE9C8BD32FCE")

    static CipherSuite SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA = new CipherSuite(
            "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", true,
            KEY_EXCHANGE_DH_anon_EXPORT, "DH", "DES40_CBC", "SHA",
            CODE_SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "2EB71540B71A447128F3FFBC63694828", hash_generated_field = "CFD2BC5D1F10829C63EF21A7DB33CB3C")

    static CipherSuite SSL_DH_anon_WITH_DES_CBC_SHA = new CipherSuite(
            "SSL_DH_anon_WITH_DES_CBC_SHA", false, KEY_EXCHANGE_DH_anon,
            "DH", "DES_CBC", "SHA", CODE_SSL_DH_anon_WITH_DES_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "C0E7252A803913AA741D34A443C3C686", hash_generated_field = "EFB8C10BD75D329BC521499F745D9B25")

    static CipherSuite SSL_DH_anon_WITH_3DES_EDE_CBC_SHA = new CipherSuite(
            "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", false, KEY_EXCHANGE_DH_anon,
            "DH", "3DES_EDE_CBC", "SHA", CODE_SSL_DH_anon_WITH_3DES_EDE_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "928B9E92478CFA583BD56D7154F4893A", hash_generated_field = "E6A8C936F9C954D3A197E78F5793DA5D")

    static CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA = new CipherSuite("TLS_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_RSA,
                              "RSA",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_RSA_WITH_AES_128_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "96196CD53F84910864B228CFFC89370F", hash_generated_field = "622810E509D4A37A062F2D9BCE3E5040")

    static CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA = new CipherSuite("TLS_DHE_DSS_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_DSS,
                              "DSA",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_DHE_DSS_WITH_AES_128_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.758 -0400", hash_original_field = "13582988BADD9996229805F118C99244", hash_generated_field = "6286F388FED5502507D316F8EB00AB1E")

    static CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA = new CipherSuite("TLS_DHE_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_RSA,
                              "RSA",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_DHE_RSA_WITH_AES_128_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.759 -0400", hash_original_field = "8CE987DF067EB03A3D00EA00B3B7BD9D", hash_generated_field = "AC2ABD35BFC4C8C08390D80286EEB1C5")

    static CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA = new CipherSuite("TLS_DH_anon_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DH_anon,
                              "DH",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_DH_anon_WITH_AES_128_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.759 -0400", hash_original_field = "CDD6C72D072162DA03C5A6CADB02BEDA", hash_generated_field = "7F0303D8E1DF18808224F4A78FF42BF2")

    static CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA = new CipherSuite("TLS_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_RSA,
                              "RSA",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_RSA_WITH_AES_256_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.774 -0400", hash_original_field = "3BA1C6C2FA496E4AD1CD21E789D5935D", hash_generated_field = "9157158569CAEF871F34064BC8081D82")

    static CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA = new CipherSuite("TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_DSS,
                              "DSA",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_DHE_DSS_WITH_AES_256_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.775 -0400", hash_original_field = "848B39E22AF0C1590EE89BACFEFF4419", hash_generated_field = "A57999668D3445FE7DE761DCBA16A18C")

    static CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA = new CipherSuite("TLS_DHE_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DHE_RSA,
                              "RSA",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_DHE_RSA_WITH_AES_256_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.775 -0400", hash_original_field = "BCB0DEAEA6B363CF07E33B821A803138", hash_generated_field = "3BEE49B5BD8D5AC7101CFBBFAE18ECF0")

    static CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA = new CipherSuite("TLS_DH_anon_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_DH_anon,
                              "DH",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_DH_anon_WITH_AES_256_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.775 -0400", hash_original_field = "529E23A8C8957496E987186F7FBE5586", hash_generated_field = "3670B1002DEA37F0F2939FEBB54088E6")

    static CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA = new CipherSuite("TLS_ECDH_ECDSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_NULL_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.775 -0400", hash_original_field = "8C247A1904DF70F7BB85CC744692DED1", hash_generated_field = "C2B429000B03B68FE2D64CF6E44B8809")

    static CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA = new CipherSuite("TLS_ECDH_ECDSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_RC4_128_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.775 -0400", hash_original_field = "C32E96948EF574761E4AD31652737E82", hash_generated_field = "90277BF0F5070138D79BEB0E1F52E638")

    static CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = new CipherSuite("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.775 -0400", hash_original_field = "538F1D49A877A579E33A5A1CF6F5D46A", hash_generated_field = "3478C6626D2BB670F8F807BE43FC7C31")

    static CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = new CipherSuite("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.775 -0400", hash_original_field = "4F27E990EB3FF0E5F96FDC408ADABF8C", hash_generated_field = "965186F63FBE55C9064720F14E8D63F3")

    static CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = new CipherSuite("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_ECDSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.775 -0400", hash_original_field = "DF1E45DBCD7CECBC8982E444DBC83F9A", hash_generated_field = "40AEE8A07B50DDD0EF65CFFAF981240F")

    static CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA = new CipherSuite("TLS_ECDHE_ECDSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_NULL_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.777 -0400", hash_original_field = "5B853E9F8D759E40ECDEEE995D8D1081", hash_generated_field = "576788FDBC0F9BB247776AB05544C702")

    static CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = new CipherSuite("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_RC4_128_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.777 -0400", hash_original_field = "3C3509437063DE28422DEB98A45F2E27", hash_generated_field = "D33A6B3E7B740AB851CC3EB7FBC54FEF")

    static CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = new CipherSuite("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.777 -0400", hash_original_field = "948AA1702BC1D5CE43FC7E2198FDFB13", hash_generated_field = "3C37DA85DD7C52F64ED98DC5679E7E02")

    static CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.777 -0400", hash_original_field = "11407F519667698994B20F3B515087E8", hash_generated_field = "7175100083AADBDD5AB414F80C731280")

    static CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_ECDSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.777 -0400", hash_original_field = "E3932CF707471E38A8BB4C64F12C5087", hash_generated_field = "4C7956D5FD75230694BF63926B5B7A26")

    static CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA = new CipherSuite("TLS_ECDH_RSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_NULL_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.777 -0400", hash_original_field = "45E0CA8E84C759D4D6E4E7DF19CA9FCA", hash_generated_field = "53C2848327B38156C3E10E11E96D1726")

    static CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA = new CipherSuite("TLS_ECDH_RSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_RC4_128_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.777 -0400", hash_original_field = "7D28328835EE4CE68B0FA23E83A05649", hash_generated_field = "4D13788526727E55F184EA4CABAFC053")

    static CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = new CipherSuite("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.777 -0400", hash_original_field = "07B504B7525AB604FA7A3E4F1EF038D1", hash_generated_field = "CDBF086DDEA5BEFEAA10BA0B83D56D74")

    static CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = new CipherSuite("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_AES_128_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.777 -0400", hash_original_field = "F030A2C0E47E01398200CA9812DE61C2", hash_generated_field = "180BC03EA1EECADBE4615C7A7BF26AF5")

    static CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = new CipherSuite("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_RSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDH_RSA_WITH_AES_256_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.777 -0400", hash_original_field = "B838B3224F90A11F97E15DB822B8A691", hash_generated_field = "F9DF3542395A6D2E5A0F0E5456C48124")

    static CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA = new CipherSuite("TLS_ECDHE_RSA_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_NULL_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.777 -0400", hash_original_field = "25169813ED49ACB302A64AC6444ECB14", hash_generated_field = "8C1A6FFAC82693AD5735A29DEC1865FD")

    static CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA = new CipherSuite("TLS_ECDHE_RSA_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_RC4_128_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.780 -0400", hash_original_field = "519C192BBC53C787AED7E8D7EACC5252", hash_generated_field = "DF50A773D9D54147FE558516A33562B3")

    static CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = new CipherSuite("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "8617F33380D9651ED97B81901341155A", hash_generated_field = "6F41FB6DE75E5A90B8A89D9CCB0C8CA7")

    static CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = new CipherSuite("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "3118B8406952E3404448A5FDA813A334", hash_generated_field = "654DB9F979D39B95F9A6F695F3EE82F6")

    static CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = new CipherSuite("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDHE_RSA,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "D2519B29CBC50B79AE029CEFA8D7F489", hash_generated_field = "8F8B86334F18AE5E26068CD520D44717")

    static CipherSuite TLS_ECDH_anon_WITH_NULL_SHA = new CipherSuite("TLS_ECDH_anon_WITH_NULL_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              null,
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_NULL_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "04883B5F6FD4D7C9F96A1702E420CD9E", hash_generated_field = "7CE62732787839B1C88FD4754AEF9FA1")

    static CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA = new CipherSuite("TLS_ECDH_anon_WITH_RC4_128_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "RC4_128",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_RC4_128_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "F3D608F24BF6548AC6A5115C1FA380E7", hash_generated_field = "7C7AA21A2BB7D846D3DAC378D4E67A38")

    static CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = new CipherSuite("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "3DES_EDE_CBC",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "99A5FDA80E518ABF45219FAC5391EE05", hash_generated_field = "CF4D042BF8600F79B1A62AD29D43635E")

    static CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA = new CipherSuite("TLS_ECDH_anon_WITH_AES_128_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "AES_128_CBC",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_AES_128_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "16C0E8C6790E6192353F3BC8BFFCB17E", hash_generated_field = "55B2439CB500B123BD062CF07A655701")

    static CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA = new CipherSuite("TLS_ECDH_anon_WITH_AES_256_CBC_SHA",
                              false,
                              KEY_EXCHANGE_ECDH_anon,
                              "EC",
                              "AES_256_CBC",
                              "SHA",
                              CODE_TLS_ECDH_anon_WITH_AES_256_CBC_SHA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "56C885DE7F21EFB338865EC44087086B", hash_generated_field = "E9565758B5358ACEBEAA5C40EB51208F")

    private static CipherSuite[] SUITES_BY_CODE_0x00 = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "300732E628E4581C5A80D09D2331A561", hash_generated_field = "1A80F5A1A97AE4063D1BA44B1D4E5C78")

    private static CipherSuite[] SUITES_BY_CODE_0xc0 = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "139C740AB5387886D95F04E59D8EBDCD", hash_generated_field = "E6AE8C29747288A1BFEE444F8739BBF9")

    private static Hashtable<String, CipherSuite> SUITES_BY_NAME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "24D46A327FE03D7E6A9CE5B8E4DCEF2E", hash_generated_field = "E9A16A2EC77F47C33B1348B57F2B0E8D")

    static CipherSuite[] SUPPORTED_CIPHER_SUITES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "6B0E8F6FA11512BFE5C0B99C8989CC6F", hash_generated_field = "376EF07F673B6998B2F9A878D03DBFB3")

    static String[] SUPPORTED_CIPHER_SUITE_NAMES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "D1C930443411A66004711F0EDB3C2B79", hash_generated_field = "4E9325578392D367E47C3B814905F855")

    static CipherSuite[] DEFAULT_CIPHER_SUITES;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "D6A7C7AEA7B6F82D08C7C56FCE6AC0D4", hash_generated_field = "021586E5947AAD22BD6066847353927E")

    static String KEY_TYPE_RSA = "RSA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "5EC220A2FE46BE6E43108AFBF766A2BD", hash_generated_field = "051F70C6EFA8E9B7EE566243265DDBE3")

    static String KEY_TYPE_DSA = "DSA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "D3C08514884E3DF537B50AB844EFB507", hash_generated_field = "70DFD90E6C7BEEE521A02E00463D0358")

    static String KEY_TYPE_DH_RSA = "DH_RSA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "4C0ADB901EFCED594ECEABA4A687901E", hash_generated_field = "CF702F1BF10BFEEF700444CEFB4BF2A4")

    static String KEY_TYPE_DH_DSA = "DH_DSA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "49516C6C3011CF57D44A59490E5A9815", hash_generated_field = "A8886AB218B102F38B7FF1FFF88079B5")

    static String KEY_TYPE_EC = "EC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.781 -0400", hash_original_field = "D9D6A8C120458B0A7F50D2DE54BC5B60", hash_generated_field = "5270E0CA364D909360213BBB2AE3F0CA")

    static String KEY_TYPE_EC_EC = "EC_EC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "6BAE5893CB2E7F42B8902E40CE60B4BA", hash_generated_field = "F92586D126791D8DE5AAC36B1C49DB50")

    static String KEY_TYPE_EC_RSA = "EC_RSA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "825D2570FD0204CF12985287D6FB24E6", hash_generated_field = "646D71A180B9928DE01849169CBA9C9C")

    static byte TLS_CT_RSA_SIGN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "777B362283CC16F0ACC5C954D7559F86", hash_generated_field = "635D6EB9C4A6A631B2DAD7FEA8602C04")

    static byte TLS_CT_DSS_SIGN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "75E050F0B0CBCDFC8EBDECC84879FBCE", hash_generated_field = "C2750409BE2B9B7812B091A2FB508ADE")

    static byte TLS_CT_RSA_FIXED_DH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "1095BF115D6D0391A86DCE1CDB2B50CB", hash_generated_field = "035B0859343B83F24B8D84B1FB28EE7B")

    static byte TLS_CT_DSS_FIXED_DH = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "BCE24F50487AC8339654DCDD6595F5E3", hash_generated_field = "9223E7C277E41BB4587352896A5DC3B5")

    static byte TLS_CT_ECDSA_SIGN = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "10D9001EB9D905E671162BA4B10E47F5", hash_generated_field = "3CBB023C17B3742CE8E242B9DF7BA6EB")

    static byte TLS_CT_RSA_FIXED_ECDH = 65;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "806F5C4FC9FE894B740FF55FD06AACCD", hash_generated_field = "CED9CE540BE2260B994D404EE3AFB242")

    static byte TLS_CT_ECDSA_FIXED_ECDH = 66;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "7AE08B7CCDD7CF8212076711C9D505CD", hash_generated_field = "C74C6C21FD0EDC9F51506BED6E200E87")

    private static String AUTH_TYPE_RSA = "RSA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "4DDEB697ED4E7D8B713A1F7579F9E489", hash_generated_field = "E3525F8D75AD20301D8A2C7AAD0E7B22")

    private static String AUTH_TYPE_RSA_EXPORT = "RSA_EXPORT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "281EAA1C5180DE50D452ECDB5DA4FF49", hash_generated_field = "C9A0ABCA60E87E28BA6A753A9D1F407C")

    private static String AUTH_TYPE_DHE_DSS = "DHE_DSS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "4B04C67C4718F76B710AAEF1F2D9D567", hash_generated_field = "9CEEA1A8A8DB2182EA3C19E0E0E47540")

    private static String AUTH_TYPE_DHE_RSA = "DHE_RSA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "960B8D6FF5DC2F6165D2A647DE0B17EA", hash_generated_field = "FE694D48017914B3541BC8049172C931")

    private static String AUTH_TYPE_DH_DSS = "DH_DSS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "D39A041502FC98BD7C71350547E77FB9", hash_generated_field = "D80C194E39EF6A46F7A8EC7816BCDFD2")

    private static String AUTH_TYPE_DH_RSA = "DH_RSA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "14048D62665387F889CAA0DB21876279", hash_generated_field = "0428DE8C894ABCF6EF0D4F9E75811E74")

    private static String AUTH_TYPE_ECDH_ECDSA = "ECDH_ECDSA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "3376756728CEAAF1BF103D7C49D9D5D8", hash_generated_field = "188A2ECD9CEC71FA66B5855D6AD05D9C")

    private static String AUTH_TYPE_ECDH_RSA = "ECDH_RSA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "5178DA7E41530757238EF1EF311F495E", hash_generated_field = "8515EADD2917C69F236E6EF35307254A")

    private static String AUTH_TYPE_ECDHE_ECDSA = "ECDHE_ECDSA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.782 -0400", hash_original_field = "2AEDCFA92F4B83C2F9ABF31B48A38FCA", hash_generated_field = "3E99AF66472CB1E032349B31165E9EF1")

    private static String AUTH_TYPE_ECDHE_RSA = "ECDHE_RSA";
}

