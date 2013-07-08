package java.math;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class BigInt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.477 -0400", hash_original_field = "93F416957F94153A0658C38C2890FA30", hash_generated_field = "2E7F69903943700473696173A4E00017")

    transient int bignum = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.477 -0400", hash_original_method = "1310F12C90284BE28EAEC322C36620BE", hash_generated_method = "1310F12C90284BE28EAEC322C36620BE")
    public BigInt ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.478 -0400", hash_original_method = "BE6B93B7FDC95635F38722D58894F3B6", hash_generated_method = "6A3286CF45E3A22103D7740507159402")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                NativeBN.BN_free(this.bignum);
                this.bignum = 0;
            } 
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
                
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.478 -0400", hash_original_method = "AE4D2CED095C616381028CC9DA4809A2", hash_generated_method = "1DD1F0D90E018DFDA5D9341347B91B73")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_447150837 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_447150837 = this.decString();
        varB4EAC82CA7396A68D541C85D26508E83_447150837.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_447150837;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.479 -0400", hash_original_method = "5BE7FB396EC56810A84432A49B351D93", hash_generated_method = "5C7C156AEE831E8CA685D9E53785A522")
     int getNativeBIGNUM() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296925829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296925829;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.479 -0400", hash_original_method = "271E8D5D7DE583053F26E9ECE2A9ACB3", hash_generated_method = "C284E5EDF24B5CD7B90D49A0CBBCB56C")
    private void makeValid() {
        {
            this.bignum = NativeBN.BN_new();
            Check(this.bignum != 0);
        } 
        
        
            
            
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.480 -0400", hash_original_method = "8941EBA58E329563221FF533A53A6CC6", hash_generated_method = "2C8C5825C971E55CBCCDE2936DC422DF")
     void putCopy(BigInt from) {
        this.makeValid();
        Check(NativeBN.BN_copy(this.bignum, from.bignum));
        addTaint(from.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.481 -0400", hash_original_method = "05F85FC1363853C2D04A531626254DA4", hash_generated_method = "C71B698958E5E8D6285B23EF27734C51")
     BigInt copy() {
        BigInt varB4EAC82CA7396A68D541C85D26508E83_933129040 = null; 
        BigInt bi = new BigInt();
        bi.putCopy(this);
        varB4EAC82CA7396A68D541C85D26508E83_933129040 = bi;
        varB4EAC82CA7396A68D541C85D26508E83_933129040.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_933129040;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.482 -0400", hash_original_method = "30A332A63D32AA82B1909AFA5FBB53FE", hash_generated_method = "9F4FE1739F998FF63CA0C442321A153A")
     void putLongInt(long val) {
        this.makeValid();
        Check(NativeBN.putLongInt(this.bignum, val));
        addTaint(val);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.482 -0400", hash_original_method = "2D149BF96A898165FFEB2983CC63FA56", hash_generated_method = "621D5A75DD981DDD500FB666D54321E8")
     void putULongInt(long val, boolean neg) {
        this.makeValid();
        Check(NativeBN.putULongInt(this.bignum, val, neg));
        addTaint(val);
        addTaint(neg);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.483 -0400", hash_original_method = "9B61495EA965D6A6D5A899C3BAA9567B", hash_generated_method = "F37D2EFDD9099236B0A0A50FAC43A037")
    private NumberFormatException invalidBigInteger(String s) {
        throw new NumberFormatException("Invalid BigInteger: " + s);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.483 -0400", hash_original_method = "6076EA670724B5FC9E7D900E17BB8270", hash_generated_method = "8977C62E3F3B59F5CFCACF5A0733C828")
     void putDecString(String original) {
        String s = checkString(original, 10);
        this.makeValid();
        int usedLen = NativeBN.BN_dec2bn(this.bignum, s);
        Check((usedLen > 0));
        {
            boolean varA13F3142E694CF8397A4AEFE6967A458_165038040 = (usedLen < s.length());
            {
                if (DroidSafeAndroidRuntime.control) throw invalidBigInteger(original);
            } 
        } 
        addTaint(original.getTaint());
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.483 -0400", hash_original_method = "77EC4D791D3A431E14DA888080E50FCA", hash_generated_method = "10BB5CB2612BA113CF50105164695EC1")
     void putHexString(String original) {
        String s = checkString(original, 16);
        this.makeValid();
        int usedLen = NativeBN.BN_hex2bn(this.bignum, s);
        Check((usedLen > 0));
        {
            boolean varA13F3142E694CF8397A4AEFE6967A458_1361633217 = (usedLen < s.length());
            {
                if (DroidSafeAndroidRuntime.control) throw invalidBigInteger(original);
            } 
        } 
        addTaint(original.getTaint());
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.484 -0400", hash_original_method = "509B8D432808DFEEDB9A2530ACB4E595", hash_generated_method = "6007B0B5DB931B9B930089ED0696761E")
     String checkString(String s, int base) {
        String varB4EAC82CA7396A68D541C85D26508E83_650731180 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        int charCount = s.length();
        int i = 0;
        {
            char ch = s.charAt(0);
            {
                s = s.substring(1);
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw invalidBigInteger(s);
        } 
        boolean nonAscii = false;
        {
            char ch = s.charAt(i);
            {
                boolean varF5FD1498482E4E0987145634F68F58CE_405661564 = (Character.digit(ch, base) == -1);
                {
                    if (DroidSafeAndroidRuntime.control) throw invalidBigInteger(s);
                } 
            } 
            {
                nonAscii = true;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_650731180 = nonAscii ? toAscii(s, base) : s;
        addTaint(s.getTaint());
        addTaint(base);
        varB4EAC82CA7396A68D541C85D26508E83_650731180.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_650731180;
        
        
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.485 -0400", hash_original_method = "ACDB63EFF9B325E839800C11A6F974A8", hash_generated_method = "43EFF414FBB7D78601A6A3E50FECCB70")
     void putBigEndian(byte[] a, boolean neg) {
        this.makeValid();
        Check(NativeBN.BN_bin2bn(a, a.length, neg, this.bignum));
        addTaint(a[0]);
        addTaint(neg);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.485 -0400", hash_original_method = "F46F553C794EFAECC5CBB83791E423EA", hash_generated_method = "F0EE44A85BD597609CA749B27F66BE74")
     void putLittleEndianInts(int[] a, boolean neg) {
        this.makeValid();
        Check(NativeBN.litEndInts2bn(a, a.length, neg, this.bignum));
        addTaint(a[0]);
        addTaint(neg);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.485 -0400", hash_original_method = "78A05CDDAF5055249AF6E8FAF4BFB01A", hash_generated_method = "4009FE82AC021BB5FF09463897DA8BFE")
     void putBigEndianTwosComplement(byte[] a) {
        this.makeValid();
        Check(NativeBN.twosComp2bn(a, a.length, this.bignum));
        addTaint(a[0]);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.485 -0400", hash_original_method = "27EA3CFBEF77EFE881C6E2FB553F4CC2", hash_generated_method = "31411D911AFC7F7F3219567A6AA18F48")
     long longInt() {
        long var568B96714232996F05A67FEC3007E730_1857254413 = (NativeBN.longInt(this.bignum));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_198422447 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_198422447;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.486 -0400", hash_original_method = "91D15DC45533D4FB86FF476EA9D84EB9", hash_generated_method = "E1E4987FBDD30843E5EBE5430B6D3686")
     String decString() {
        String varB4EAC82CA7396A68D541C85D26508E83_626582918 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_626582918 = NativeBN.BN_bn2dec(this.bignum);
        varB4EAC82CA7396A68D541C85D26508E83_626582918.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_626582918;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.487 -0400", hash_original_method = "41C3EB22F67E33809F4134B2F2306A6C", hash_generated_method = "6FFE72713A0A861EC229B6CDD100D06A")
     String hexString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1698758822 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1698758822 = NativeBN.BN_bn2hex(this.bignum);
        varB4EAC82CA7396A68D541C85D26508E83_1698758822.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1698758822;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.487 -0400", hash_original_method = "5BFAE0D787CB740802A929B95296D76B", hash_generated_method = "B04680546C302F6837C8CE0091C4D9F2")
     byte[] bigEndianMagnitude() {
        byte[] var5713A3D0946171715E55913A347440FF_732763914 = (NativeBN.BN_bn2bin(this.bignum));
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1580002239 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1580002239;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.487 -0400", hash_original_method = "9306CD68F08E506A6F565B6B5DE53B97", hash_generated_method = "1C2A7D381E755A0A0A040B593B56210B")
     int[] littleEndianIntsMagnitude() {
        int[] var6E1D22610BFEAF10D5E9C9888883D31F_188949748 = (NativeBN.bn2litEndInts(this.bignum));
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_373188897 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_373188897;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.487 -0400", hash_original_method = "20C3F9921E8308474D657B401A5C4926", hash_generated_method = "A5A8CC29815ABB55C4823EB9EDA73239")
     int sign() {
        int varA6FFB2EBC8E064F4B12AFD8977763B21_1990688842 = (NativeBN.sign(this.bignum));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526533030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526533030;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.488 -0400", hash_original_method = "D1EC3F455E1B2B87D60E54F4D60552ED", hash_generated_method = "5436B33A2F42F6E99AE3F117CEF82174")
     void setSign(int val) {
        {
            NativeBN.BN_set_negative(this.bignum, 0);
        } 
        {
            NativeBN.BN_set_negative(this.bignum, 1);
        } 
        addTaint(val);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.488 -0400", hash_original_method = "0C4139075DA080C92B767C8D6DDC4F59", hash_generated_method = "69661C5259EB5EDF85B049BD23534493")
     boolean twosCompFitsIntoBytes(int desiredByteCount) {
        int actualByteCount = (NativeBN.bitLength(this.bignum) + 7) / 8;
        addTaint(desiredByteCount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835372389 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835372389;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.488 -0400", hash_original_method = "06E4028740CFBC5E8F4DC5B6A30B93E1", hash_generated_method = "03EEDEC50B9F3B6CF3B568D23C096655")
     int bitLength() {
        int var27C992443C21A44A87944D4A58DDEBF4_1341356604 = (NativeBN.bitLength(this.bignum));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450511856 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450511856;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.489 -0400", hash_original_method = "7AF9A4C10272398CEA0DB42D124E2F09", hash_generated_method = "640AD541787E9E3464BBEE44ADB907BB")
     boolean isBitSet(int n) {
        boolean var41FF7BE6D0CC98059B7B09D26E2122CC_1260158931 = (NativeBN.BN_is_bit_set(this.bignum, n));
        addTaint(n);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064079048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064079048;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    static BigInt shift(BigInt a, int n) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_shift(r.bignum, a.bignum, n));
        return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.490 -0400", hash_original_method = "E387E2D423D242DA7510EDC2247E6A5C", hash_generated_method = "8E99E53D11860E6CEF110BC79F6C4567")
     void shift(int n) {
        Check(NativeBN.BN_shift(this.bignum, this.bignum, n));
        addTaint(n);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.490 -0400", hash_original_method = "3376DF594C58E0E875033FD1F81D1456", hash_generated_method = "7E084BFEDB883F61C6C7FF03338957C6")
     void addPositiveInt(int w) {
        Check(NativeBN.BN_add_word(this.bignum, w));
        addTaint(w);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.491 -0400", hash_original_method = "5EBBBBFBA0490D7B09CF7B986217857B", hash_generated_method = "BDDBD1113B4AA7D1B4E6FA7548A4EDF1")
     void multiplyByPositiveInt(int w) {
        Check(NativeBN.BN_mul_word(this.bignum, w));
        addTaint(w);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    static int remainderByPositiveInt(BigInt a, int w) {
        int rem = NativeBN.BN_mod_word(a.bignum, w);
        Check(rem != -1);
        return rem;
    }

    
    @DSModeled(DSC.SPEC)
    static BigInt addition(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_add(r.bignum, a.bignum, b.bignum));
        return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.493 -0400", hash_original_method = "0051E42AE39953CC88EC24F561CB2DC4", hash_generated_method = "2A68044FACA0ADA2AD3A3006E9D9BB38")
     void add(BigInt a) {
        Check(NativeBN.BN_add(this.bignum, this.bignum, a.bignum));
        addTaint(a.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    static BigInt subtraction(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_sub(r.bignum, a.bignum, b.bignum));
        return r;
    }

    
    @DSModeled(DSC.SPEC)
    static BigInt gcd(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_gcd(r.bignum, a.bignum, b.bignum));
        return r;
    }

    
    @DSModeled(DSC.SPEC)
    static BigInt product(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_mul(r.bignum, a.bignum, b.bignum));
        return r;
    }

    
    @DSModeled(DSC.SAFE)
    static BigInt bigExp(BigInt a, BigInt p) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_exp(r.bignum, a.bignum, p.bignum));
        return r;
    }

    
    @DSModeled(DSC.SAFE)
    static BigInt exp(BigInt a, int p) {
        BigInt power = new BigInt();
        power.putLongInt(p);
        return bigExp(a, power);
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SAFE)
    static BigInt modulus(BigInt a, BigInt m) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_nnmod(r.bignum, a.bignum, m.bignum));
        return r;
    }

    
    @DSModeled(DSC.SAFE)
    static BigInt modExp(BigInt a, BigInt p, BigInt m) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_mod_exp(r.bignum, a.bignum, p.bignum, m.bignum));
        return r;
    }

    
    @DSModeled(DSC.SPEC)
    static BigInt modInverse(BigInt a, BigInt m) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_mod_inverse(r.bignum, a.bignum, m.bignum));
        return r;
    }

    
    @DSModeled(DSC.SPEC)
    static BigInt generatePrimeDefault(int bitLength) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_generate_prime_ex(r.bignum, bitLength, false, 0, 0, 0));
        return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.498 -0400", hash_original_method = "E070D8C138AEEC2CD37718FB0D1B5E61", hash_generated_method = "AF14FA17FE519B31ADD383BF05186534")
     boolean isPrime(int certainty) {
        boolean varC73FF920A9D497BA034F5C82FDD4C8FD_1207458150 = (NativeBN.BN_is_prime_ex(bignum, certainty, 0));
        addTaint(certainty);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776020701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776020701;
        
        
    }

    
}

