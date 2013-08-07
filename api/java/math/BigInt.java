package java.math;

// Droidsafe Imports
import droidsafe.annotations.*;





final class BigInt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.669 -0400", hash_original_field = "93F416957F94153A0658C38C2890FA30", hash_generated_field = "2E7F69903943700473696173A4E00017")

    transient int bignum = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.670 -0400", hash_original_method = "1310F12C90284BE28EAEC322C36620BE", hash_generated_method = "1310F12C90284BE28EAEC322C36620BE")
    public BigInt ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.670 -0400", hash_original_method = "BE6B93B7FDC95635F38722D58894F3B6", hash_generated_method = "79F2A5564B5CFEB540C376A4B1096DBB")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            if(this.bignum != 0)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.670 -0400", hash_original_method = "AE4D2CED095C616381028CC9DA4809A2", hash_generated_method = "4865B9C1A6B5B30063AA720AF3306C17")
    @Override
    public String toString() {
String varEE38A904DF70C757D780CC0689FFC426_1453104462 =         this.decString();
        varEE38A904DF70C757D780CC0689FFC426_1453104462.addTaint(taint);
        return varEE38A904DF70C757D780CC0689FFC426_1453104462;
        // ---------- Original Method ----------
        //return this.decString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.671 -0400", hash_original_method = "5BE7FB396EC56810A84432A49B351D93", hash_generated_method = "D42DA3D097F8304FC4F0BB3F057A83A7")
     int getNativeBIGNUM() {
        int var2F62ECB1E1BFD54CAB557BA7F701A0DB_1043862483 = (this.bignum);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732370945 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732370945;
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

    
    @DSModeled(DSC.BAN)
    private static void Check(boolean success) {
        if (!success) {
            StringBuilder sb = new StringBuilder("(openssl)ERR: ");
            int cnt = consumeErrors(sb);
            if (cnt > 0)
                throw new ArithmeticException(sb.toString());
        }
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.672 -0400", hash_original_method = "271E8D5D7DE583053F26E9ECE2A9ACB3", hash_generated_method = "6590B780BDA809903AB57FA813FAD850")
    private void makeValid() {
        if(this.bignum == 0)        
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

    
    @DSModeled(DSC.BAN)
    private static BigInt newBigInt() {
        BigInt bi = new BigInt();
        bi.bignum = NativeBN.BN_new();
        Check(bi.bignum != 0);
        return bi;
    }

    
    static int cmp(BigInt a, BigInt b) {
        return NativeBN.BN_cmp(a.bignum, b.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.673 -0400", hash_original_method = "8941EBA58E329563221FF533A53A6CC6", hash_generated_method = "A53C2B47BE13DFD41D834C00E3021F6F")
     void putCopy(BigInt from) {
        addTaint(from.getTaint());
        this.makeValid();
        Check(NativeBN.BN_copy(this.bignum, from.bignum));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.BN_copy(this.bignum, from.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.673 -0400", hash_original_method = "05F85FC1363853C2D04A531626254DA4", hash_generated_method = "B2AEE7E8AB741AE5163C78B0772CFB77")
     BigInt copy() {
        BigInt bi = new BigInt();
        bi.putCopy(this);
BigInt var87B0A797C42126F3585C9636042C24CE_2137102410 =         bi;
        var87B0A797C42126F3585C9636042C24CE_2137102410.addTaint(taint);
        return var87B0A797C42126F3585C9636042C24CE_2137102410;
        // ---------- Original Method ----------
        //BigInt bi = new BigInt();
        //bi.putCopy(this);
        //return bi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.674 -0400", hash_original_method = "30A332A63D32AA82B1909AFA5FBB53FE", hash_generated_method = "39852ED1DDA1E2E553C1A24019D48134")
     void putLongInt(long val) {
        addTaint(val);
        this.makeValid();
        Check(NativeBN.putLongInt(this.bignum, val));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.putLongInt(this.bignum, val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.674 -0400", hash_original_method = "2D149BF96A898165FFEB2983CC63FA56", hash_generated_method = "C9A6AD284B168BEDD5EEB59097BA5447")
     void putULongInt(long val, boolean neg) {
        addTaint(neg);
        addTaint(val);
        this.makeValid();
        Check(NativeBN.putULongInt(this.bignum, val, neg));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.putULongInt(this.bignum, val, neg));
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.674 -0400", hash_original_method = "9B61495EA965D6A6D5A899C3BAA9567B", hash_generated_method = "21F976EDF30C167A6426C42ADD3956DE")
    private NumberFormatException invalidBigInteger(String s) {
        addTaint(s.getTaint());
        NumberFormatException var3E0A23870CF491D90DB3D166BB4BDFBA_1848257066 = new NumberFormatException("Invalid BigInteger: " + s);
        var3E0A23870CF491D90DB3D166BB4BDFBA_1848257066.addTaint(taint);
        throw var3E0A23870CF491D90DB3D166BB4BDFBA_1848257066;
        // ---------- Original Method ----------
        //throw new NumberFormatException("Invalid BigInteger: " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.679 -0400", hash_original_method = "6076EA670724B5FC9E7D900E17BB8270", hash_generated_method = "37223B8298FCCAA8DA9241EA1E52D520")
     void putDecString(String original) {
        addTaint(original.getTaint());
        String s = checkString(original, 10);
        this.makeValid();
        int usedLen = NativeBN.BN_dec2bn(this.bignum, s);
        Check((usedLen > 0));
        if(usedLen < s.length())        
        {
            java.lang.NumberFormatException varE8D11AC18CAE370F8E495AB217B30BEE_879041005 = invalidBigInteger(original);
            varE8D11AC18CAE370F8E495AB217B30BEE_879041005.addTaint(taint);
            throw varE8D11AC18CAE370F8E495AB217B30BEE_879041005;
        } //End block
        // ---------- Original Method ----------
        //String s = checkString(original, 10);
        //this.makeValid();
        //int usedLen = NativeBN.BN_dec2bn(this.bignum, s);
        //Check((usedLen > 0));
        //if (usedLen < s.length()) {
            //throw invalidBigInteger(original);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.683 -0400", hash_original_method = "77EC4D791D3A431E14DA888080E50FCA", hash_generated_method = "085AB114374FCC7B6BA07020C4E05B76")
     void putHexString(String original) {
        addTaint(original.getTaint());
        String s = checkString(original, 16);
        this.makeValid();
        int usedLen = NativeBN.BN_hex2bn(this.bignum, s);
        Check((usedLen > 0));
        if(usedLen < s.length())        
        {
            java.lang.NumberFormatException varE8D11AC18CAE370F8E495AB217B30BEE_737523141 = invalidBigInteger(original);
            varE8D11AC18CAE370F8E495AB217B30BEE_737523141.addTaint(taint);
            throw varE8D11AC18CAE370F8E495AB217B30BEE_737523141;
        } //End block
        // ---------- Original Method ----------
        //String s = checkString(original, 16);
        //this.makeValid();
        //int usedLen = NativeBN.BN_hex2bn(this.bignum, s);
        //Check((usedLen > 0));
        //if (usedLen < s.length()) {
            //throw invalidBigInteger(original);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.694 -0400", hash_original_method = "509B8D432808DFEEDB9A2530ACB4E595", hash_generated_method = "E8812625B2228D52FFAFF42E259A5325")
     String checkString(String s, int base) {
        addTaint(base);
        addTaint(s.getTaint());
        if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1158455290 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1158455290.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1158455290;
        } //End block
        int charCount = s.length();
        int i = 0;
        if(charCount > 0)        
        {
            char ch = s.charAt(0);
            if(ch == '+')            
            {
                s = s.substring(1);
                --charCount;
            } //End block
            else
            if(ch == '-')            
            {
                ++i;
            } //End block
        } //End block
        if(charCount - i == 0)        
        {
            java.lang.NumberFormatException var7F9B1EBE0B97EE479C788F183C4079A9_1963229399 = invalidBigInteger(s);
            var7F9B1EBE0B97EE479C788F183C4079A9_1963229399.addTaint(taint);
            throw var7F9B1EBE0B97EE479C788F183C4079A9_1963229399;
        } //End block
        boolean nonAscii = false;
for(;i < charCount;++i)
        {
            char ch = s.charAt(i);
            if(Character.digit(ch, base) == -1)            
            {
                java.lang.NumberFormatException var7F9B1EBE0B97EE479C788F183C4079A9_902852474 = invalidBigInteger(s);
                var7F9B1EBE0B97EE479C788F183C4079A9_902852474.addTaint(taint);
                throw var7F9B1EBE0B97EE479C788F183C4079A9_902852474;
            } //End block
            if(ch > 128)            
            {
                nonAscii = true;
            } //End block
        } //End block
String varF5914D263E7A63078B23C8BE55D5C92B_1514872935 =         nonAscii ? toAscii(s, base) : s;
        varF5914D263E7A63078B23C8BE55D5C92B_1514872935.addTaint(taint);
        return varF5914D263E7A63078B23C8BE55D5C92B_1514872935;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.695 -0400", hash_original_method = "ACDB63EFF9B325E839800C11A6F974A8", hash_generated_method = "CD9F25EF0DC2807F6172CC43AC6B926D")
     void putBigEndian(byte[] a, boolean neg) {
        addTaint(neg);
        addTaint(a[0]);
        this.makeValid();
        Check(NativeBN.BN_bin2bn(a, a.length, neg, this.bignum));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.BN_bin2bn(a, a.length, neg, this.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.695 -0400", hash_original_method = "F46F553C794EFAECC5CBB83791E423EA", hash_generated_method = "AD2BEF5A0E1E3E4B92D2B35F3163C829")
     void putLittleEndianInts(int[] a, boolean neg) {
        addTaint(neg);
        addTaint(a[0]);
        this.makeValid();
        Check(NativeBN.litEndInts2bn(a, a.length, neg, this.bignum));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.litEndInts2bn(a, a.length, neg, this.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.696 -0400", hash_original_method = "78A05CDDAF5055249AF6E8FAF4BFB01A", hash_generated_method = "55FFBF4EAA47D256331278B9CAE1E099")
     void putBigEndianTwosComplement(byte[] a) {
        addTaint(a[0]);
        this.makeValid();
        Check(NativeBN.twosComp2bn(a, a.length, this.bignum));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.twosComp2bn(a, a.length, this.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.696 -0400", hash_original_method = "27EA3CFBEF77EFE881C6E2FB553F4CC2", hash_generated_method = "759E8602730CEEA37802D27F7F54DC9A")
     long longInt() {
        long varC55BA8B2B9A00B1323A548E5B86AFCBA_263961541 = (NativeBN.longInt(this.bignum));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2015228717 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2015228717;
        // ---------- Original Method ----------
        //return NativeBN.longInt(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.696 -0400", hash_original_method = "91D15DC45533D4FB86FF476EA9D84EB9", hash_generated_method = "789BF990BCC431A24780BD2A909911D1")
     String decString() {
String varCCF863F4D48E2DE62C695A86A66040EF_913052956 =         NativeBN.BN_bn2dec(this.bignum);
        varCCF863F4D48E2DE62C695A86A66040EF_913052956.addTaint(taint);
        return varCCF863F4D48E2DE62C695A86A66040EF_913052956;
        // ---------- Original Method ----------
        //return NativeBN.BN_bn2dec(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.696 -0400", hash_original_method = "41C3EB22F67E33809F4134B2F2306A6C", hash_generated_method = "77CA2B40559F74294C8F1282DA1891EC")
     String hexString() {
String varE4F8BA600302B1E57A5C31B3EB1B1B21_1353313643 =         NativeBN.BN_bn2hex(this.bignum);
        varE4F8BA600302B1E57A5C31B3EB1B1B21_1353313643.addTaint(taint);
        return varE4F8BA600302B1E57A5C31B3EB1B1B21_1353313643;
        // ---------- Original Method ----------
        //return NativeBN.BN_bn2hex(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.697 -0400", hash_original_method = "5BFAE0D787CB740802A929B95296D76B", hash_generated_method = "0B3E4F3CA6B0A10F6D705EBBE2170911")
     byte[] bigEndianMagnitude() {
        byte[] var974B961D29BF5708EEFD709EE3C9B6C3_948125143 = (NativeBN.BN_bn2bin(this.bignum));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_209291050 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_209291050;
        // ---------- Original Method ----------
        //return NativeBN.BN_bn2bin(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.697 -0400", hash_original_method = "9306CD68F08E506A6F565B6B5DE53B97", hash_generated_method = "D9779E9E54975D9AC237B7115EE6E42B")
     int[] littleEndianIntsMagnitude() {
        int[] var4B84E68D8CDD0E00B539C5BBDD3C0297_1129725257 = (NativeBN.bn2litEndInts(this.bignum));
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1573701559 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1573701559;
        // ---------- Original Method ----------
        //return NativeBN.bn2litEndInts(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.697 -0400", hash_original_method = "20C3F9921E8308474D657B401A5C4926", hash_generated_method = "5FB7C7563484C4BE47DF7DF6CD26BDDE")
     int sign() {
        int var30B6F63E32027C8A1E184493509869A6_1383626099 = (NativeBN.sign(this.bignum));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669078155 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669078155;
        // ---------- Original Method ----------
        //return NativeBN.sign(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.698 -0400", hash_original_method = "D1EC3F455E1B2B87D60E54F4D60552ED", hash_generated_method = "3B3C7CC6824D931061A89A493C908DEF")
     void setSign(int val) {
        addTaint(val);
        if(val > 0)        
        {
            NativeBN.BN_set_negative(this.bignum, 0);
        } //End block
        else
        {
            if(val < 0)            
            NativeBN.BN_set_negative(this.bignum, 1);
        } //End block
        // ---------- Original Method ----------
        //if (val > 0) {
            //NativeBN.BN_set_negative(this.bignum, 0);
        //} else {
            //if (val < 0) NativeBN.BN_set_negative(this.bignum, 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.698 -0400", hash_original_method = "0C4139075DA080C92B767C8D6DDC4F59", hash_generated_method = "021E31A648D0AB4EB1C5BAC4A783D5CE")
     boolean twosCompFitsIntoBytes(int desiredByteCount) {
        addTaint(desiredByteCount);
        int actualByteCount = (NativeBN.bitLength(this.bignum) + 7) / 8;
        boolean var56074C02CFA094DC2F93464BDA66A9DD_1824330084 = (actualByteCount <= desiredByteCount);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1924396459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1924396459;
        // ---------- Original Method ----------
        //int actualByteCount = (NativeBN.bitLength(this.bignum) + 7) / 8;
        //return actualByteCount <= desiredByteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.698 -0400", hash_original_method = "06E4028740CFBC5E8F4DC5B6A30B93E1", hash_generated_method = "69F501C54223066EA2B51CB5D877F4C6")
     int bitLength() {
        int var0F9DE3413157B0BF360CFE49C565F557_823516046 = (NativeBN.bitLength(this.bignum));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003901429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003901429;
        // ---------- Original Method ----------
        //return NativeBN.bitLength(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.699 -0400", hash_original_method = "7AF9A4C10272398CEA0DB42D124E2F09", hash_generated_method = "1B4DF630FB2058A6B297451419A25C34")
     boolean isBitSet(int n) {
        addTaint(n);
        boolean varF06EB7850FF23805EFB6B8AE10768B04_1487393732 = (NativeBN.BN_is_bit_set(this.bignum, n));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394721028 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394721028;
        // ---------- Original Method ----------
        //return NativeBN.BN_is_bit_set(this.bignum, n);
    }

    
    static BigInt shift(BigInt a, int n) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_shift(r.bignum, a.bignum, n));
        return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.699 -0400", hash_original_method = "E387E2D423D242DA7510EDC2247E6A5C", hash_generated_method = "C8DF347BD2BF9D83FFF9D24E2BD4B4CE")
     void shift(int n) {
        addTaint(n);
        Check(NativeBN.BN_shift(this.bignum, this.bignum, n));
        // ---------- Original Method ----------
        //Check(NativeBN.BN_shift(this.bignum, this.bignum, n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.700 -0400", hash_original_method = "3376DF594C58E0E875033FD1F81D1456", hash_generated_method = "B27FF13CDDB19642C061A48A8355B465")
     void addPositiveInt(int w) {
        addTaint(w);
        Check(NativeBN.BN_add_word(this.bignum, w));
        // ---------- Original Method ----------
        //Check(NativeBN.BN_add_word(this.bignum, w));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.700 -0400", hash_original_method = "5EBBBBFBA0490D7B09CF7B986217857B", hash_generated_method = "17F41774B8FE3ABEA78B4E49B7979DF3")
     void multiplyByPositiveInt(int w) {
        addTaint(w);
        Check(NativeBN.BN_mul_word(this.bignum, w));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.701 -0400", hash_original_method = "0051E42AE39953CC88EC24F561CB2DC4", hash_generated_method = "3EAD98D568723230A39CDFDFA4439AE8")
     void add(BigInt a) {
        addTaint(a.getTaint());
        Check(NativeBN.BN_add(this.bignum, this.bignum, a.bignum));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.703 -0400", hash_original_method = "E070D8C138AEEC2CD37718FB0D1B5E61", hash_generated_method = "C51488C7214F8D843ECF40E88BC69B5C")
     boolean isPrime(int certainty) {
        addTaint(certainty);
        boolean var241D89B17919157472B0C305FE26C87F_1998096002 = (NativeBN.BN_is_prime_ex(bignum, certainty, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672414494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672414494;
        // ---------- Original Method ----------
        //return NativeBN.BN_is_prime_ex(bignum, certainty, 0);
    }

    
}

