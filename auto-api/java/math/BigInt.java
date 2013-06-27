package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class BigInt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.299 -0400", hash_original_field = "93F416957F94153A0658C38C2890FA30", hash_generated_field = "2E7F69903943700473696173A4E00017")

    transient int bignum = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.300 -0400", hash_original_method = "1310F12C90284BE28EAEC322C36620BE", hash_generated_method = "1310F12C90284BE28EAEC322C36620BE")
    public BigInt ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.301 -0400", hash_original_method = "BE6B93B7FDC95635F38722D58894F3B6", hash_generated_method = "6A3286CF45E3A22103D7740507159402")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                NativeBN.BN_free(this.bignum);
                this.bignum = 0;
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (this.bignum != 0) {
                //NativeBN.BN_free(this.bignum);
                //this.bignum = 0;
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.302 -0400", hash_original_method = "AE4D2CED095C616381028CC9DA4809A2", hash_generated_method = "6F5FB5FCAB7C6C21C11FED3052737021")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_37020232 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_37020232 = this.decString();
        varB4EAC82CA7396A68D541C85D26508E83_37020232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_37020232;
        // ---------- Original Method ----------
        //return this.decString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.315 -0400", hash_original_method = "5BE7FB396EC56810A84432A49B351D93", hash_generated_method = "BDA40D71D065BFEAEC22D5618430B3D5")
     int getNativeBIGNUM() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_711654964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_711654964;
        // ---------- Original Method ----------
        //return this.bignum;
    }

    
        static int consumeErrors(StringBuilder sb) {
        int cnt = 0;
        int e, reason;
        while ((e = NativeBN.ERR_get_error()) != 0) {
            reason = e & 255;
            if (reason == 103) {
                throw new ArithmeticException("BigInteger division by zero");
            }
            if (reason == 108) {
                throw new ArithmeticException("BigInteger not invertible");
            }
            if (reason == 65) {
                throw new OutOfMemoryError();
            }
            sb.append(e).append(": ");
            String s = NativeBN.ERR_error_string(e);
            sb.append(s);
            cnt++;
        }
        return cnt;
    }

    
        private static void Check(boolean success) {
        if (!success) {
            StringBuilder sb = new StringBuilder("(openssl)ERR: ");
            int cnt = consumeErrors(sb);
            if (cnt > 0)
                throw new ArithmeticException(sb.toString());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.316 -0400", hash_original_method = "271E8D5D7DE583053F26E9ECE2A9ACB3", hash_generated_method = "C284E5EDF24B5CD7B90D49A0CBBCB56C")
    private void makeValid() {
        {
            this.bignum = NativeBN.BN_new();
            Check(this.bignum != 0);
        } //End block
        // ---------- Original Method ----------
        //if (this.bignum == 0) {
            //this.bignum = NativeBN.BN_new();
            //Check(this.bignum != 0);
        //}
    }

    
        private static BigInt newBigInt() {
        BigInt bi = new BigInt();
        bi.bignum = NativeBN.BN_new();
        Check(bi.bignum != 0);
        return bi;
    }

    
        static int cmp(BigInt a, BigInt b) {
        return NativeBN.BN_cmp(a.bignum, b.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.320 -0400", hash_original_method = "8941EBA58E329563221FF533A53A6CC6", hash_generated_method = "2C8C5825C971E55CBCCDE2936DC422DF")
     void putCopy(BigInt from) {
        this.makeValid();
        Check(NativeBN.BN_copy(this.bignum, from.bignum));
        addTaint(from.getTaint());
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.BN_copy(this.bignum, from.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.350 -0400", hash_original_method = "05F85FC1363853C2D04A531626254DA4", hash_generated_method = "ACFE98D3D08E2047D2AD51D7F2894FA8")
     BigInt copy() {
        BigInt varB4EAC82CA7396A68D541C85D26508E83_1497972209 = null; //Variable for return #1
        BigInt bi;
        bi = new BigInt();
        bi.putCopy(this);
        varB4EAC82CA7396A68D541C85D26508E83_1497972209 = bi;
        varB4EAC82CA7396A68D541C85D26508E83_1497972209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1497972209;
        // ---------- Original Method ----------
        //BigInt bi = new BigInt();
        //bi.putCopy(this);
        //return bi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.351 -0400", hash_original_method = "30A332A63D32AA82B1909AFA5FBB53FE", hash_generated_method = "9F4FE1739F998FF63CA0C442321A153A")
     void putLongInt(long val) {
        this.makeValid();
        Check(NativeBN.putLongInt(this.bignum, val));
        addTaint(val);
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.putLongInt(this.bignum, val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.351 -0400", hash_original_method = "2D149BF96A898165FFEB2983CC63FA56", hash_generated_method = "621D5A75DD981DDD500FB666D54321E8")
     void putULongInt(long val, boolean neg) {
        this.makeValid();
        Check(NativeBN.putULongInt(this.bignum, val, neg));
        addTaint(val);
        addTaint(neg);
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.putULongInt(this.bignum, val, neg));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.351 -0400", hash_original_method = "9B61495EA965D6A6D5A899C3BAA9567B", hash_generated_method = "F37D2EFDD9099236B0A0A50FAC43A037")
    private NumberFormatException invalidBigInteger(String s) {
        if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Invalid BigInteger: " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //throw new NumberFormatException("Invalid BigInteger: " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.352 -0400", hash_original_method = "6076EA670724B5FC9E7D900E17BB8270", hash_generated_method = "D87767BE1318CA4A0020F6042139A26D")
     void putDecString(String original) {
        String s;
        s = checkString(original, 10);
        this.makeValid();
        int usedLen;
        usedLen = NativeBN.BN_dec2bn(this.bignum, s);
        Check((usedLen > 0));
        {
            boolean varA13F3142E694CF8397A4AEFE6967A458_1520942811 = (usedLen < s.length());
            {
                if (DroidSafeAndroidRuntime.control) throw invalidBigInteger(original);
            } //End block
        } //End collapsed parenthetic
        addTaint(original.getTaint());
        // ---------- Original Method ----------
        //String s = checkString(original, 10);
        //this.makeValid();
        //int usedLen = NativeBN.BN_dec2bn(this.bignum, s);
        //Check((usedLen > 0));
        //if (usedLen < s.length()) {
            //throw invalidBigInteger(original);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.352 -0400", hash_original_method = "77EC4D791D3A431E14DA888080E50FCA", hash_generated_method = "672B5E0039354CB253D4D304B5449563")
     void putHexString(String original) {
        String s;
        s = checkString(original, 16);
        this.makeValid();
        int usedLen;
        usedLen = NativeBN.BN_hex2bn(this.bignum, s);
        Check((usedLen > 0));
        {
            boolean varA13F3142E694CF8397A4AEFE6967A458_384270503 = (usedLen < s.length());
            {
                if (DroidSafeAndroidRuntime.control) throw invalidBigInteger(original);
            } //End block
        } //End collapsed parenthetic
        addTaint(original.getTaint());
        // ---------- Original Method ----------
        //String s = checkString(original, 16);
        //this.makeValid();
        //int usedLen = NativeBN.BN_hex2bn(this.bignum, s);
        //Check((usedLen > 0));
        //if (usedLen < s.length()) {
            //throw invalidBigInteger(original);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.356 -0400", hash_original_method = "509B8D432808DFEEDB9A2530ACB4E595", hash_generated_method = "43F8C95F8045845D4C81113F4479851B")
     String checkString(String s, int base) {
        String varB4EAC82CA7396A68D541C85D26508E83_198463338 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int charCount;
        charCount = s.length();
        int i;
        i = 0;
        {
            char ch;
            ch = s.charAt(0);
            {
                s = s.substring(1);
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw invalidBigInteger(s);
        } //End block
        boolean nonAscii;
        nonAscii = false;
        {
            char ch;
            ch = s.charAt(i);
            {
                boolean varF5FD1498482E4E0987145634F68F58CE_1555825459 = (Character.digit(ch, base) == -1);
                {
                    if (DroidSafeAndroidRuntime.control) throw invalidBigInteger(s);
                } //End block
            } //End collapsed parenthetic
            {
                nonAscii = true;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_198463338 = nonAscii ? toAscii(s, base) : s;
        addTaint(s.getTaint());
        addTaint(base);
        varB4EAC82CA7396A68D541C85D26508E83_198463338.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_198463338;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static String toAscii(String s, int base) {
        int length = s.length();
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            char ch = s.charAt(i);
            int value = Character.digit(ch, base);
            if (value >= 0 && value <= 9) {
                ch = (char) ('0' + value);
            }
            result.append(ch);
        }
        return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.357 -0400", hash_original_method = "ACDB63EFF9B325E839800C11A6F974A8", hash_generated_method = "43EFF414FBB7D78601A6A3E50FECCB70")
     void putBigEndian(byte[] a, boolean neg) {
        this.makeValid();
        Check(NativeBN.BN_bin2bn(a, a.length, neg, this.bignum));
        addTaint(a[0]);
        addTaint(neg);
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.BN_bin2bn(a, a.length, neg, this.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.357 -0400", hash_original_method = "F46F553C794EFAECC5CBB83791E423EA", hash_generated_method = "F0EE44A85BD597609CA749B27F66BE74")
     void putLittleEndianInts(int[] a, boolean neg) {
        this.makeValid();
        Check(NativeBN.litEndInts2bn(a, a.length, neg, this.bignum));
        addTaint(a[0]);
        addTaint(neg);
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.litEndInts2bn(a, a.length, neg, this.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.357 -0400", hash_original_method = "78A05CDDAF5055249AF6E8FAF4BFB01A", hash_generated_method = "4009FE82AC021BB5FF09463897DA8BFE")
     void putBigEndianTwosComplement(byte[] a) {
        this.makeValid();
        Check(NativeBN.twosComp2bn(a, a.length, this.bignum));
        addTaint(a[0]);
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.twosComp2bn(a, a.length, this.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.357 -0400", hash_original_method = "27EA3CFBEF77EFE881C6E2FB553F4CC2", hash_generated_method = "F44BBED08881E6C47724344CFEC363C3")
     long longInt() {
        long var568B96714232996F05A67FEC3007E730_99737671 = (NativeBN.longInt(this.bignum));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_406462704 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_406462704;
        // ---------- Original Method ----------
        //return NativeBN.longInt(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.358 -0400", hash_original_method = "91D15DC45533D4FB86FF476EA9D84EB9", hash_generated_method = "F2CDCD8DC3C9AC0751FB5469830DF388")
     String decString() {
        String varB4EAC82CA7396A68D541C85D26508E83_257378147 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_257378147 = NativeBN.BN_bn2dec(this.bignum);
        varB4EAC82CA7396A68D541C85D26508E83_257378147.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_257378147;
        // ---------- Original Method ----------
        //return NativeBN.BN_bn2dec(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.358 -0400", hash_original_method = "41C3EB22F67E33809F4134B2F2306A6C", hash_generated_method = "1E4268F18C7E592AC98253D5C6D4146F")
     String hexString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1042569955 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1042569955 = NativeBN.BN_bn2hex(this.bignum);
        varB4EAC82CA7396A68D541C85D26508E83_1042569955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1042569955;
        // ---------- Original Method ----------
        //return NativeBN.BN_bn2hex(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.359 -0400", hash_original_method = "5BFAE0D787CB740802A929B95296D76B", hash_generated_method = "4152607238492E451DCF90CD2802F330")
     byte[] bigEndianMagnitude() {
        byte[] var5713A3D0946171715E55913A347440FF_122371100 = (NativeBN.BN_bn2bin(this.bignum));
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_198058038 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_198058038;
        // ---------- Original Method ----------
        //return NativeBN.BN_bn2bin(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.359 -0400", hash_original_method = "9306CD68F08E506A6F565B6B5DE53B97", hash_generated_method = "38D2E06A9968239A4613882BBA1B9BC7")
     int[] littleEndianIntsMagnitude() {
        int[] var6E1D22610BFEAF10D5E9C9888883D31F_1847080671 = (NativeBN.bn2litEndInts(this.bignum));
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_214340742 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_214340742;
        // ---------- Original Method ----------
        //return NativeBN.bn2litEndInts(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.376 -0400", hash_original_method = "20C3F9921E8308474D657B401A5C4926", hash_generated_method = "2863C94C708BF599EF523033E8647209")
     int sign() {
        int varA6FFB2EBC8E064F4B12AFD8977763B21_23182317 = (NativeBN.sign(this.bignum));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1806911009 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1806911009;
        // ---------- Original Method ----------
        //return NativeBN.sign(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.376 -0400", hash_original_method = "D1EC3F455E1B2B87D60E54F4D60552ED", hash_generated_method = "5436B33A2F42F6E99AE3F117CEF82174")
     void setSign(int val) {
        {
            NativeBN.BN_set_negative(this.bignum, 0);
        } //End block
        {
            NativeBN.BN_set_negative(this.bignum, 1);
        } //End block
        addTaint(val);
        // ---------- Original Method ----------
        //if (val > 0) {
            //NativeBN.BN_set_negative(this.bignum, 0);
        //} else {
            //if (val < 0) NativeBN.BN_set_negative(this.bignum, 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.376 -0400", hash_original_method = "0C4139075DA080C92B767C8D6DDC4F59", hash_generated_method = "A68940F25883DB8BD42AE1F2FC0B9BAE")
     boolean twosCompFitsIntoBytes(int desiredByteCount) {
        int actualByteCount;
        actualByteCount = (NativeBN.bitLength(this.bignum) + 7) / 8;
        addTaint(desiredByteCount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1173238177 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1173238177;
        // ---------- Original Method ----------
        //int actualByteCount = (NativeBN.bitLength(this.bignum) + 7) / 8;
        //return actualByteCount <= desiredByteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.376 -0400", hash_original_method = "06E4028740CFBC5E8F4DC5B6A30B93E1", hash_generated_method = "C33B93DE978E2BD20A33BBAEFE3E0540")
     int bitLength() {
        int var27C992443C21A44A87944D4A58DDEBF4_803827721 = (NativeBN.bitLength(this.bignum));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027423900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027423900;
        // ---------- Original Method ----------
        //return NativeBN.bitLength(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.377 -0400", hash_original_method = "7AF9A4C10272398CEA0DB42D124E2F09", hash_generated_method = "1924EBC93EAB02C6E700A64A4A1CBB76")
     boolean isBitSet(int n) {
        boolean var41FF7BE6D0CC98059B7B09D26E2122CC_167661294 = (NativeBN.BN_is_bit_set(this.bignum, n));
        addTaint(n);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_62488158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_62488158;
        // ---------- Original Method ----------
        //return NativeBN.BN_is_bit_set(this.bignum, n);
    }

    
        static BigInt shift(BigInt a, int n) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_shift(r.bignum, a.bignum, n));
        return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.377 -0400", hash_original_method = "E387E2D423D242DA7510EDC2247E6A5C", hash_generated_method = "8E99E53D11860E6CEF110BC79F6C4567")
     void shift(int n) {
        Check(NativeBN.BN_shift(this.bignum, this.bignum, n));
        addTaint(n);
        // ---------- Original Method ----------
        //Check(NativeBN.BN_shift(this.bignum, this.bignum, n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.377 -0400", hash_original_method = "3376DF594C58E0E875033FD1F81D1456", hash_generated_method = "7E084BFEDB883F61C6C7FF03338957C6")
     void addPositiveInt(int w) {
        Check(NativeBN.BN_add_word(this.bignum, w));
        addTaint(w);
        // ---------- Original Method ----------
        //Check(NativeBN.BN_add_word(this.bignum, w));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.378 -0400", hash_original_method = "5EBBBBFBA0490D7B09CF7B986217857B", hash_generated_method = "BDDBD1113B4AA7D1B4E6FA7548A4EDF1")
     void multiplyByPositiveInt(int w) {
        Check(NativeBN.BN_mul_word(this.bignum, w));
        addTaint(w);
        // ---------- Original Method ----------
        //Check(NativeBN.BN_mul_word(this.bignum, w));
    }

    
        static int remainderByPositiveInt(BigInt a, int w) {
        int rem = NativeBN.BN_mod_word(a.bignum, w);
        Check(rem != -1);
        return rem;
    }

    
        static BigInt addition(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_add(r.bignum, a.bignum, b.bignum));
        return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.378 -0400", hash_original_method = "0051E42AE39953CC88EC24F561CB2DC4", hash_generated_method = "2A68044FACA0ADA2AD3A3006E9D9BB38")
     void add(BigInt a) {
        Check(NativeBN.BN_add(this.bignum, this.bignum, a.bignum));
        addTaint(a.getTaint());
        // ---------- Original Method ----------
        //Check(NativeBN.BN_add(this.bignum, this.bignum, a.bignum));
    }

    
        static BigInt subtraction(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_sub(r.bignum, a.bignum, b.bignum));
        return r;
    }

    
        static BigInt gcd(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_gcd(r.bignum, a.bignum, b.bignum));
        return r;
    }

    
        static BigInt product(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_mul(r.bignum, a.bignum, b.bignum));
        return r;
    }

    
        static BigInt bigExp(BigInt a, BigInt p) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_exp(r.bignum, a.bignum, p.bignum));
        return r;
    }

    
        static BigInt exp(BigInt a, int p) {
        BigInt power = new BigInt();
        power.putLongInt(p);
        return bigExp(a, power);
    }

    
        static void division(BigInt dividend, BigInt divisor,
            BigInt quotient, BigInt remainder) {
        int quot, rem;
        if (quotient != null) {
            quotient.makeValid();
            quot = quotient.bignum;
        } else {
            quot = 0;
        }
        if (remainder != null) {
            remainder.makeValid();
            rem = remainder.bignum;
        } else {
            rem = 0;
        }
        Check(NativeBN.BN_div(quot, rem, dividend.bignum, divisor.bignum));
    }

    
        static BigInt modulus(BigInt a, BigInt m) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_nnmod(r.bignum, a.bignum, m.bignum));
        return r;
    }

    
        static BigInt modExp(BigInt a, BigInt p, BigInt m) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_mod_exp(r.bignum, a.bignum, p.bignum, m.bignum));
        return r;
    }

    
        static BigInt modInverse(BigInt a, BigInt m) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_mod_inverse(r.bignum, a.bignum, m.bignum));
        return r;
    }

    
        static BigInt generatePrimeDefault(int bitLength) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_generate_prime_ex(r.bignum, bitLength, false, 0, 0, 0));
        return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.400 -0400", hash_original_method = "E070D8C138AEEC2CD37718FB0D1B5E61", hash_generated_method = "71CD9F08BA67E6B0F210CA5CDC4BEC65")
     boolean isPrime(int certainty) {
        boolean varC73FF920A9D497BA034F5C82FDD4C8FD_1365234923 = (NativeBN.BN_is_prime_ex(bignum, certainty, 0));
        addTaint(certainty);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_41609710 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_41609710;
        // ---------- Original Method ----------
        //return NativeBN.BN_is_prime_ex(bignum, certainty, 0);
    }

    
}

