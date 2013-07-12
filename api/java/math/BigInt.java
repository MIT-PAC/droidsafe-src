package java.math;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class BigInt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.704 -0400", hash_original_field = "93F416957F94153A0658C38C2890FA30", hash_generated_field = "2E7F69903943700473696173A4E00017")

    transient int bignum = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.705 -0400", hash_original_method = "1310F12C90284BE28EAEC322C36620BE", hash_generated_method = "1310F12C90284BE28EAEC322C36620BE")
    public BigInt ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.705 -0400", hash_original_method = "BE6B93B7FDC95635F38722D58894F3B6", hash_generated_method = "79F2A5564B5CFEB540C376A4B1096DBB")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
    if(this.bignum != 0)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.706 -0400", hash_original_method = "AE4D2CED095C616381028CC9DA4809A2", hash_generated_method = "328AE66661DE99408315188CAA80B2DA")
    @Override
    public String toString() {
String varEE38A904DF70C757D780CC0689FFC426_1542107688 =         this.decString();
        varEE38A904DF70C757D780CC0689FFC426_1542107688.addTaint(taint);
        return varEE38A904DF70C757D780CC0689FFC426_1542107688;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.706 -0400", hash_original_method = "5BE7FB396EC56810A84432A49B351D93", hash_generated_method = "207B7A97DFBCD2EF292DD267FC341775")
     int getNativeBIGNUM() {
        int var2F62ECB1E1BFD54CAB557BA7F701A0DB_795313843 = (this.bignum);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621226979 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621226979;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.707 -0400", hash_original_method = "271E8D5D7DE583053F26E9ECE2A9ACB3", hash_generated_method = "6590B780BDA809903AB57FA813FAD850")
    private void makeValid() {
    if(this.bignum == 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.708 -0400", hash_original_method = "8941EBA58E329563221FF533A53A6CC6", hash_generated_method = "A53C2B47BE13DFD41D834C00E3021F6F")
     void putCopy(BigInt from) {
        addTaint(from.getTaint());
        this.makeValid();
        Check(NativeBN.BN_copy(this.bignum, from.bignum));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.708 -0400", hash_original_method = "05F85FC1363853C2D04A531626254DA4", hash_generated_method = "DBA7C708EE270DDC1CF1C15F675C6315")
     BigInt copy() {
        BigInt bi = new BigInt();
        bi.putCopy(this);
BigInt var87B0A797C42126F3585C9636042C24CE_1293285840 =         bi;
        var87B0A797C42126F3585C9636042C24CE_1293285840.addTaint(taint);
        return var87B0A797C42126F3585C9636042C24CE_1293285840;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.709 -0400", hash_original_method = "30A332A63D32AA82B1909AFA5FBB53FE", hash_generated_method = "39852ED1DDA1E2E553C1A24019D48134")
     void putLongInt(long val) {
        addTaint(val);
        this.makeValid();
        Check(NativeBN.putLongInt(this.bignum, val));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.709 -0400", hash_original_method = "2D149BF96A898165FFEB2983CC63FA56", hash_generated_method = "C9A6AD284B168BEDD5EEB59097BA5447")
     void putULongInt(long val, boolean neg) {
        addTaint(neg);
        addTaint(val);
        this.makeValid();
        Check(NativeBN.putULongInt(this.bignum, val, neg));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.710 -0400", hash_original_method = "9B61495EA965D6A6D5A899C3BAA9567B", hash_generated_method = "3A56FA635A03F5D24C5FD0F3F40EB5C6")
    private NumberFormatException invalidBigInteger(String s) {
        addTaint(s.getTaint());
        NumberFormatException var3E0A23870CF491D90DB3D166BB4BDFBA_1652486484 = new NumberFormatException("Invalid BigInteger: " + s);
        var3E0A23870CF491D90DB3D166BB4BDFBA_1652486484.addTaint(taint);
        throw var3E0A23870CF491D90DB3D166BB4BDFBA_1652486484;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.717 -0400", hash_original_method = "6076EA670724B5FC9E7D900E17BB8270", hash_generated_method = "97DB3DA2A6F0A45830EB6C0737950264")
     void putDecString(String original) {
        addTaint(original.getTaint());
        String s = checkString(original, 10);
        this.makeValid();
        int usedLen = NativeBN.BN_dec2bn(this.bignum, s);
        Check((usedLen > 0));
    if(usedLen < s.length())        
        {
            java.lang.NumberFormatException varE8D11AC18CAE370F8E495AB217B30BEE_479104065 = invalidBigInteger(original);
            varE8D11AC18CAE370F8E495AB217B30BEE_479104065.addTaint(taint);
            throw varE8D11AC18CAE370F8E495AB217B30BEE_479104065;
        } 
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.721 -0400", hash_original_method = "77EC4D791D3A431E14DA888080E50FCA", hash_generated_method = "C68BA695192B8103EE813673B5C70EDC")
     void putHexString(String original) {
        addTaint(original.getTaint());
        String s = checkString(original, 16);
        this.makeValid();
        int usedLen = NativeBN.BN_hex2bn(this.bignum, s);
        Check((usedLen > 0));
    if(usedLen < s.length())        
        {
            java.lang.NumberFormatException varE8D11AC18CAE370F8E495AB217B30BEE_1544842357 = invalidBigInteger(original);
            varE8D11AC18CAE370F8E495AB217B30BEE_1544842357.addTaint(taint);
            throw varE8D11AC18CAE370F8E495AB217B30BEE_1544842357;
        } 
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.728 -0400", hash_original_method = "509B8D432808DFEEDB9A2530ACB4E595", hash_generated_method = "EE0D633EA69EBD952DD674FEF8283B11")
     String checkString(String s, int base) {
        addTaint(base);
        addTaint(s.getTaint());
    if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1839930692 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1839930692.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1839930692;
        } 
        int charCount = s.length();
        int i = 0;
    if(charCount > 0)        
        {
            char ch = s.charAt(0);
    if(ch == '+')            
            {
                s = s.substring(1);
                --charCount;
            } 
            else
    if(ch == '-')            
            {
                ++i;
            } 
        } 
    if(charCount - i == 0)        
        {
            java.lang.NumberFormatException var7F9B1EBE0B97EE479C788F183C4079A9_823287794 = invalidBigInteger(s);
            var7F9B1EBE0B97EE479C788F183C4079A9_823287794.addTaint(taint);
            throw var7F9B1EBE0B97EE479C788F183C4079A9_823287794;
        } 
        boolean nonAscii = false;
for(;i < charCount;++i)
        {
            char ch = s.charAt(i);
    if(Character.digit(ch, base) == -1)            
            {
                java.lang.NumberFormatException var7F9B1EBE0B97EE479C788F183C4079A9_1999332240 = invalidBigInteger(s);
                var7F9B1EBE0B97EE479C788F183C4079A9_1999332240.addTaint(taint);
                throw var7F9B1EBE0B97EE479C788F183C4079A9_1999332240;
            } 
    if(ch > 128)            
            {
                nonAscii = true;
            } 
        } 
String varF5914D263E7A63078B23C8BE55D5C92B_488148871 =         nonAscii ? toAscii(s, base) : s;
        varF5914D263E7A63078B23C8BE55D5C92B_488148871.addTaint(taint);
        return varF5914D263E7A63078B23C8BE55D5C92B_488148871;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.728 -0400", hash_original_method = "ACDB63EFF9B325E839800C11A6F974A8", hash_generated_method = "CD9F25EF0DC2807F6172CC43AC6B926D")
     void putBigEndian(byte[] a, boolean neg) {
        addTaint(neg);
        addTaint(a[0]);
        this.makeValid();
        Check(NativeBN.BN_bin2bn(a, a.length, neg, this.bignum));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.728 -0400", hash_original_method = "F46F553C794EFAECC5CBB83791E423EA", hash_generated_method = "AD2BEF5A0E1E3E4B92D2B35F3163C829")
     void putLittleEndianInts(int[] a, boolean neg) {
        addTaint(neg);
        addTaint(a[0]);
        this.makeValid();
        Check(NativeBN.litEndInts2bn(a, a.length, neg, this.bignum));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.728 -0400", hash_original_method = "78A05CDDAF5055249AF6E8FAF4BFB01A", hash_generated_method = "55FFBF4EAA47D256331278B9CAE1E099")
     void putBigEndianTwosComplement(byte[] a) {
        addTaint(a[0]);
        this.makeValid();
        Check(NativeBN.twosComp2bn(a, a.length, this.bignum));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.729 -0400", hash_original_method = "27EA3CFBEF77EFE881C6E2FB553F4CC2", hash_generated_method = "35639FB99336D07EB846E99ED04697CD")
     long longInt() {
        long varC55BA8B2B9A00B1323A548E5B86AFCBA_939182026 = (NativeBN.longInt(this.bignum));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_540452572 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_540452572;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.729 -0400", hash_original_method = "91D15DC45533D4FB86FF476EA9D84EB9", hash_generated_method = "0A11DD6FB2A1ABBE9E99495EAC1CC332")
     String decString() {
String varCCF863F4D48E2DE62C695A86A66040EF_1818559748 =         NativeBN.BN_bn2dec(this.bignum);
        varCCF863F4D48E2DE62C695A86A66040EF_1818559748.addTaint(taint);
        return varCCF863F4D48E2DE62C695A86A66040EF_1818559748;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.729 -0400", hash_original_method = "41C3EB22F67E33809F4134B2F2306A6C", hash_generated_method = "DBCFB2C8C246081F00D786CDAE0E8768")
     String hexString() {
String varE4F8BA600302B1E57A5C31B3EB1B1B21_976697489 =         NativeBN.BN_bn2hex(this.bignum);
        varE4F8BA600302B1E57A5C31B3EB1B1B21_976697489.addTaint(taint);
        return varE4F8BA600302B1E57A5C31B3EB1B1B21_976697489;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.774 -0400", hash_original_method = "5BFAE0D787CB740802A929B95296D76B", hash_generated_method = "744207F6BAD7529130CAC83A6C0FF26E")
     byte[] bigEndianMagnitude() {
        byte[] var974B961D29BF5708EEFD709EE3C9B6C3_1968424326 = (NativeBN.BN_bn2bin(this.bignum));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1763414573 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1763414573;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.774 -0400", hash_original_method = "9306CD68F08E506A6F565B6B5DE53B97", hash_generated_method = "8178D96DCC75B2DC4B4A1FC3C4A7C118")
     int[] littleEndianIntsMagnitude() {
        int[] var4B84E68D8CDD0E00B539C5BBDD3C0297_1561325170 = (NativeBN.bn2litEndInts(this.bignum));
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1185629083 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1185629083;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.775 -0400", hash_original_method = "20C3F9921E8308474D657B401A5C4926", hash_generated_method = "61BD3661444FAD0F008649FA59BFD683")
     int sign() {
        int var30B6F63E32027C8A1E184493509869A6_664528447 = (NativeBN.sign(this.bignum));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349742467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349742467;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.776 -0400", hash_original_method = "D1EC3F455E1B2B87D60E54F4D60552ED", hash_generated_method = "3B3C7CC6824D931061A89A493C908DEF")
     void setSign(int val) {
        addTaint(val);
    if(val > 0)        
        {
            NativeBN.BN_set_negative(this.bignum, 0);
        } 
        else
        {
    if(val < 0)            
            NativeBN.BN_set_negative(this.bignum, 1);
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.777 -0400", hash_original_method = "0C4139075DA080C92B767C8D6DDC4F59", hash_generated_method = "627923ECB7DF5DFDC594F839EDE7FBA7")
     boolean twosCompFitsIntoBytes(int desiredByteCount) {
        addTaint(desiredByteCount);
        int actualByteCount = (NativeBN.bitLength(this.bignum) + 7) / 8;
        boolean var56074C02CFA094DC2F93464BDA66A9DD_9023711 = (actualByteCount <= desiredByteCount);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913516370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913516370;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.778 -0400", hash_original_method = "06E4028740CFBC5E8F4DC5B6A30B93E1", hash_generated_method = "95710ABEC58408BA28F335C99024C761")
     int bitLength() {
        int var0F9DE3413157B0BF360CFE49C565F557_2134322298 = (NativeBN.bitLength(this.bignum));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475678904 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475678904;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.779 -0400", hash_original_method = "7AF9A4C10272398CEA0DB42D124E2F09", hash_generated_method = "FE515FBDC9AB2E9A60FC6DC7492857DC")
     boolean isBitSet(int n) {
        addTaint(n);
        boolean varF06EB7850FF23805EFB6B8AE10768B04_1441630018 = (NativeBN.BN_is_bit_set(this.bignum, n));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055143334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055143334;
        
        
    }

    
        static BigInt shift(BigInt a, int n) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_shift(r.bignum, a.bignum, n));
        return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.781 -0400", hash_original_method = "E387E2D423D242DA7510EDC2247E6A5C", hash_generated_method = "C8DF347BD2BF9D83FFF9D24E2BD4B4CE")
     void shift(int n) {
        addTaint(n);
        Check(NativeBN.BN_shift(this.bignum, this.bignum, n));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.781 -0400", hash_original_method = "3376DF594C58E0E875033FD1F81D1456", hash_generated_method = "B27FF13CDDB19642C061A48A8355B465")
     void addPositiveInt(int w) {
        addTaint(w);
        Check(NativeBN.BN_add_word(this.bignum, w));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.783 -0400", hash_original_method = "5EBBBBFBA0490D7B09CF7B986217857B", hash_generated_method = "17F41774B8FE3ABEA78B4E49B7979DF3")
     void multiplyByPositiveInt(int w) {
        addTaint(w);
        Check(NativeBN.BN_mul_word(this.bignum, w));
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.787 -0400", hash_original_method = "0051E42AE39953CC88EC24F561CB2DC4", hash_generated_method = "3EAD98D568723230A39CDFDFA4439AE8")
     void add(BigInt a) {
        addTaint(a.getTaint());
        Check(NativeBN.BN_add(this.bignum, this.bignum, a.bignum));
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.800 -0400", hash_original_method = "E070D8C138AEEC2CD37718FB0D1B5E61", hash_generated_method = "EB1647A7D471406A70E50A96F8A62450")
     boolean isPrime(int certainty) {
        addTaint(certainty);
        boolean var241D89B17919157472B0C305FE26C87F_548361975 = (NativeBN.BN_is_prime_ex(bignum, certainty, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060198593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060198593;
        
        
    }

    
}

