package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class BigInt {
    transient int bignum = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.448 -0400", hash_original_method = "4BDD2FB5BA3A95393178CD82E6D74B74", hash_generated_method = "4BDD2FB5BA3A95393178CD82E6D74B74")
        public BigInt ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.456 -0400", hash_original_method = "BE6B93B7FDC95635F38722D58894F3B6", hash_generated_method = "6A3286CF45E3A22103D7740507159402")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.457 -0400", hash_original_method = "AE4D2CED095C616381028CC9DA4809A2", hash_generated_method = "FB2C9C5DE3048A30D22DE0D6C75F5419")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var3CC7B8F4F95D45CD564BBBF3D3714232_1036559245 = (this.decString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.decString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.457 -0400", hash_original_method = "5BE7FB396EC56810A84432A49B351D93", hash_generated_method = "1E859F9B96F4A43E7BE1EEEEE7F80173")
    @DSModeled(DSC.SAFE)
     int getNativeBIGNUM() {
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.458 -0400", hash_original_method = "271E8D5D7DE583053F26E9ECE2A9ACB3", hash_generated_method = "C284E5EDF24B5CD7B90D49A0CBBCB56C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.459 -0400", hash_original_method = "8941EBA58E329563221FF533A53A6CC6", hash_generated_method = "84FEF7E7251A1C987223B7B020607351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void putCopy(BigInt from) {
        dsTaint.addTaint(from.dsTaint);
        this.makeValid();
        Check(NativeBN.BN_copy(this.bignum, from.bignum));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.BN_copy(this.bignum, from.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.459 -0400", hash_original_method = "05F85FC1363853C2D04A531626254DA4", hash_generated_method = "FCF1C9EFDDFF8DCE2194DE39D292C5AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BigInt copy() {
        BigInt bi;
        bi = new BigInt();
        bi.putCopy(this);
        return (BigInt)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigInt bi = new BigInt();
        //bi.putCopy(this);
        //return bi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.460 -0400", hash_original_method = "30A332A63D32AA82B1909AFA5FBB53FE", hash_generated_method = "B43ED0C6BFD33DF76C1A9AD85FF7D5AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void putLongInt(long val) {
        dsTaint.addTaint(val);
        this.makeValid();
        Check(NativeBN.putLongInt(this.bignum, val));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.putLongInt(this.bignum, val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.460 -0400", hash_original_method = "2D149BF96A898165FFEB2983CC63FA56", hash_generated_method = "2A77BDBF68825EC024937D236D7F5322")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void putULongInt(long val, boolean neg) {
        dsTaint.addTaint(val);
        dsTaint.addTaint(neg);
        this.makeValid();
        Check(NativeBN.putULongInt(this.bignum, val, neg));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.putULongInt(this.bignum, val, neg));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.460 -0400", hash_original_method = "9B61495EA965D6A6D5A899C3BAA9567B", hash_generated_method = "F36D12D263E2AEEEE50A58E6F2EE0155")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NumberFormatException invalidBigInteger(String s) {
        dsTaint.addTaint(s);
        if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Invalid BigInteger: " + s);
        return (NumberFormatException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new NumberFormatException("Invalid BigInteger: " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.461 -0400", hash_original_method = "6076EA670724B5FC9E7D900E17BB8270", hash_generated_method = "06704A0297B266EC868B6B23A1E7F9D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void putDecString(String original) {
        dsTaint.addTaint(original);
        String s;
        s = checkString(original, 10);
        this.makeValid();
        int usedLen;
        usedLen = NativeBN.BN_dec2bn(this.bignum, s);
        Check((usedLen > 0));
        {
            boolean varA13F3142E694CF8397A4AEFE6967A458_336014224 = (usedLen < s.length());
            {
                if (DroidSafeAndroidRuntime.control) throw invalidBigInteger(original);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String s = checkString(original, 10);
        //this.makeValid();
        //int usedLen = NativeBN.BN_dec2bn(this.bignum, s);
        //Check((usedLen > 0));
        //if (usedLen < s.length()) {
            //throw invalidBigInteger(original);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.461 -0400", hash_original_method = "77EC4D791D3A431E14DA888080E50FCA", hash_generated_method = "2E11A4D63CAE6604C66743E84811B6F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void putHexString(String original) {
        dsTaint.addTaint(original);
        String s;
        s = checkString(original, 16);
        this.makeValid();
        int usedLen;
        usedLen = NativeBN.BN_hex2bn(this.bignum, s);
        Check((usedLen > 0));
        {
            boolean varA13F3142E694CF8397A4AEFE6967A458_1515894449 = (usedLen < s.length());
            {
                if (DroidSafeAndroidRuntime.control) throw invalidBigInteger(original);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String s = checkString(original, 16);
        //this.makeValid();
        //int usedLen = NativeBN.BN_hex2bn(this.bignum, s);
        //Check((usedLen > 0));
        //if (usedLen < s.length()) {
            //throw invalidBigInteger(original);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.462 -0400", hash_original_method = "509B8D432808DFEEDB9A2530ACB4E595", hash_generated_method = "09B3A11C2982B86FD2E7251709A8ABF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String checkString(String s, int base) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(base);
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
                boolean varF5FD1498482E4E0987145634F68F58CE_1238174520 = (Character.digit(ch, base) == -1);
                {
                    if (DroidSafeAndroidRuntime.control) throw invalidBigInteger(s);
                } //End block
            } //End collapsed parenthetic
            {
                nonAscii = true;
            } //End block
        } //End block
        {
            Object varB5F5A26F93A2E990D6691629F8036A0D_1735531839 = (toAscii(s, base));
        } //End flattened ternary
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.477 -0400", hash_original_method = "ACDB63EFF9B325E839800C11A6F974A8", hash_generated_method = "D8651FFF26828AF6D1744B4683405FB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void putBigEndian(byte[] a, boolean neg) {
        dsTaint.addTaint(neg);
        dsTaint.addTaint(a[0]);
        this.makeValid();
        Check(NativeBN.BN_bin2bn(a, a.length, neg, this.bignum));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.BN_bin2bn(a, a.length, neg, this.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.478 -0400", hash_original_method = "F46F553C794EFAECC5CBB83791E423EA", hash_generated_method = "A1F3C2A15E3EFAF2C3DCF122D2FAF653")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void putLittleEndianInts(int[] a, boolean neg) {
        dsTaint.addTaint(neg);
        dsTaint.addTaint(a[0]);
        this.makeValid();
        Check(NativeBN.litEndInts2bn(a, a.length, neg, this.bignum));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.litEndInts2bn(a, a.length, neg, this.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.478 -0400", hash_original_method = "78A05CDDAF5055249AF6E8FAF4BFB01A", hash_generated_method = "18939C44A1A289CA12D5A1996F5FE4BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void putBigEndianTwosComplement(byte[] a) {
        dsTaint.addTaint(a[0]);
        this.makeValid();
        Check(NativeBN.twosComp2bn(a, a.length, this.bignum));
        // ---------- Original Method ----------
        //this.makeValid();
        //Check(NativeBN.twosComp2bn(a, a.length, this.bignum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.478 -0400", hash_original_method = "27EA3CFBEF77EFE881C6E2FB553F4CC2", hash_generated_method = "B894382EFAC20C10C85E2268F80E657D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     long longInt() {
        long var568B96714232996F05A67FEC3007E730_486010677 = (NativeBN.longInt(this.bignum));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return NativeBN.longInt(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.478 -0400", hash_original_method = "91D15DC45533D4FB86FF476EA9D84EB9", hash_generated_method = "D1494416C1F71B03AFD3894329892968")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String decString() {
        String var5A47DA5D3E43120D41343DABBE5AC364_1778179885 = (NativeBN.BN_bn2dec(this.bignum));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return NativeBN.BN_bn2dec(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.478 -0400", hash_original_method = "41C3EB22F67E33809F4134B2F2306A6C", hash_generated_method = "AF67F59BB4414E0F18B9550A91472F35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String hexString() {
        String var06AEA38752C175D9E728ED660283F1F9_802980072 = (NativeBN.BN_bn2hex(this.bignum));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return NativeBN.BN_bn2hex(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.479 -0400", hash_original_method = "5BFAE0D787CB740802A929B95296D76B", hash_generated_method = "64A60FF31E38A77BBD5996436D78B3E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     byte[] bigEndianMagnitude() {
        byte[] var5713A3D0946171715E55913A347440FF_1940560306 = (NativeBN.BN_bn2bin(this.bignum));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return NativeBN.BN_bn2bin(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.479 -0400", hash_original_method = "9306CD68F08E506A6F565B6B5DE53B97", hash_generated_method = "4C73A401A44726694014D8FC137B8D47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int[] littleEndianIntsMagnitude() {
        int[] var6E1D22610BFEAF10D5E9C9888883D31F_167997651 = (NativeBN.bn2litEndInts(this.bignum));
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return NativeBN.bn2litEndInts(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.479 -0400", hash_original_method = "20C3F9921E8308474D657B401A5C4926", hash_generated_method = "2B3DDE83FCA9062CC62CA0C6F26F692C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int sign() {
        int varA6FFB2EBC8E064F4B12AFD8977763B21_1513285805 = (NativeBN.sign(this.bignum));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeBN.sign(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.479 -0400", hash_original_method = "D1EC3F455E1B2B87D60E54F4D60552ED", hash_generated_method = "E59866852D74982334F00618269CB566")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setSign(int val) {
        dsTaint.addTaint(val);
        {
            NativeBN.BN_set_negative(this.bignum, 0);
        } //End block
        {
            NativeBN.BN_set_negative(this.bignum, 1);
        } //End block
        // ---------- Original Method ----------
        //if (val > 0) {
            //NativeBN.BN_set_negative(this.bignum, 0);
        //} else {
            //if (val < 0) NativeBN.BN_set_negative(this.bignum, 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.479 -0400", hash_original_method = "0C4139075DA080C92B767C8D6DDC4F59", hash_generated_method = "A1B3F846AD32D22E23801EA9EFF95CA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean twosCompFitsIntoBytes(int desiredByteCount) {
        dsTaint.addTaint(desiredByteCount);
        int actualByteCount;
        actualByteCount = (NativeBN.bitLength(this.bignum) + 7) / 8;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int actualByteCount = (NativeBN.bitLength(this.bignum) + 7) / 8;
        //return actualByteCount <= desiredByteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.480 -0400", hash_original_method = "06E4028740CFBC5E8F4DC5B6A30B93E1", hash_generated_method = "67268A876ACFBCB6CC2CB9AA04E4FC37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int bitLength() {
        int var27C992443C21A44A87944D4A58DDEBF4_158816259 = (NativeBN.bitLength(this.bignum));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeBN.bitLength(this.bignum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.480 -0400", hash_original_method = "7AF9A4C10272398CEA0DB42D124E2F09", hash_generated_method = "52A6298589B390438163B77A115685AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isBitSet(int n) {
        dsTaint.addTaint(n);
        boolean var41FF7BE6D0CC98059B7B09D26E2122CC_403025065 = (NativeBN.BN_is_bit_set(this.bignum, n));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return NativeBN.BN_is_bit_set(this.bignum, n);
    }

    
        static BigInt shift(BigInt a, int n) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_shift(r.bignum, a.bignum, n));
        return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.480 -0400", hash_original_method = "E387E2D423D242DA7510EDC2247E6A5C", hash_generated_method = "B39A6ACE8CFC9FD605CA96D4DADBA3F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void shift(int n) {
        dsTaint.addTaint(n);
        Check(NativeBN.BN_shift(this.bignum, this.bignum, n));
        // ---------- Original Method ----------
        //Check(NativeBN.BN_shift(this.bignum, this.bignum, n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.481 -0400", hash_original_method = "3376DF594C58E0E875033FD1F81D1456", hash_generated_method = "7CDBA3D5BB72658BFBBE20037B4D3399")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void addPositiveInt(int w) {
        dsTaint.addTaint(w);
        Check(NativeBN.BN_add_word(this.bignum, w));
        // ---------- Original Method ----------
        //Check(NativeBN.BN_add_word(this.bignum, w));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.481 -0400", hash_original_method = "5EBBBBFBA0490D7B09CF7B986217857B", hash_generated_method = "4117AEB65B23184D5644EBB6F394545B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void multiplyByPositiveInt(int w) {
        dsTaint.addTaint(w);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.481 -0400", hash_original_method = "0051E42AE39953CC88EC24F561CB2DC4", hash_generated_method = "30F7F5096493C709A2F70B613C5BD0D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void add(BigInt a) {
        dsTaint.addTaint(a.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.483 -0400", hash_original_method = "E070D8C138AEEC2CD37718FB0D1B5E61", hash_generated_method = "1B96ED81621FBF6226645ABFC49913B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isPrime(int certainty) {
        dsTaint.addTaint(certainty);
        boolean varC73FF920A9D497BA034F5C82FDD4C8FD_292508794 = (NativeBN.BN_is_prime_ex(bignum, certainty, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return NativeBN.BN_is_prime_ex(bignum, certainty, 0);
    }

    
}

