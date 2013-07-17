package org.bouncycastle.crypto.digests;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class MD5Digest extends GeneralDigest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.770 -0400", hash_original_field = "106530DC42BAA21C67F8A3AF4D7FD9E1", hash_generated_field = "A20F40A5A8396B664558E10A31EADBF9")

    private int H1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.770 -0400", hash_original_field = "CA2BF3F6B7E18A508253E9521510A4B5", hash_generated_field = "5D98AFA23A2DDA6581A809AACADB99CD")

    private int H2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.770 -0400", hash_original_field = "B14763210C3AB7284E9CBE731D7DC2A5", hash_generated_field = "2FD00213764EF55752DFCD6B7F5728A6")

    private int H3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.770 -0400", hash_original_field = "6B57370BA89BD88A2D6D819D65F6007A", hash_generated_field = "9E56BF920F4B712E7DB21A0B9EF6F5AF")

    private int H4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.770 -0400", hash_original_field = "087F99198A6B4FD30A6675940686C027", hash_generated_field = "9F176090F37D70875BB7E38ED405BB04")

    private int[] X = new int[16];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.770 -0400", hash_original_field = "C5A8521A972D9AB2588ADF57317C8D4B", hash_generated_field = "D14E80AF1F9317982664F9E415590C80")

    private int xOff;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.771 -0400", hash_original_method = "CA98629A68DF074D716C2EED7E360A30", hash_generated_method = "31A92487FDF635D7C47FB6419F68D10C")
    public  MD5Digest() {
        reset();
        // ---------- Original Method ----------
        //reset();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.772 -0400", hash_original_method = "D456AB50DF678E39352B68F4F0BE277E", hash_generated_method = "488DA5589A8892ECA9FA29886A372F0F")
    public  MD5Digest(MD5Digest t) {
        super(t);
        H1 = t.H1;
        H2 = t.H2;
        H3 = t.H3;
        H4 = t.H4;
        System.arraycopy(t.X, 0, X, 0, t.X.length);
        xOff = t.xOff;
        // ---------- Original Method ----------
        //H1 = t.H1;
        //H2 = t.H2;
        //H3 = t.H3;
        //H4 = t.H4;
        //System.arraycopy(t.X, 0, X, 0, t.X.length);
        //xOff = t.xOff;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.772 -0400", hash_original_method = "D54FFA3F0B368E98533F0D87F68E98DA", hash_generated_method = "D73571F44B6F5A91C6A2AE165186CBA9")
    public String getAlgorithmName() {
String var01833783E5A5FEFADF736A2D18E3349A_1147217742 =         "MD5";
        var01833783E5A5FEFADF736A2D18E3349A_1147217742.addTaint(taint);
        return var01833783E5A5FEFADF736A2D18E3349A_1147217742;
        // ---------- Original Method ----------
        //return "MD5";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.772 -0400", hash_original_method = "3039C1E557EE9A1557E064C50078D361", hash_generated_method = "A998041FCA91108CC247A174D022DF80")
    public int getDigestSize() {
        int var4582481E693E9037762BFFA6D99AC172_922548061 = (DIGEST_LENGTH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085298750 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085298750;
        // ---------- Original Method ----------
        //return DIGEST_LENGTH;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.773 -0400", hash_original_method = "F91F442FD561833E473644F7E1FD670A", hash_generated_method = "CF72A0EC6A34D83F505029B81559FD0D")
    protected void processWord(
        byte[]  in,
        int     inOff) {
        X[xOff++] = (in[inOff] & 0xff) | ((in[inOff + 1] & 0xff) << 8)
            | ((in[inOff + 2] & 0xff) << 16) | ((in[inOff + 3] & 0xff) << 24);
        if(xOff == 16)        
        {
            processBlock();
        } //End block
        // ---------- Original Method ----------
        //X[xOff++] = (in[inOff] & 0xff) | ((in[inOff + 1] & 0xff) << 8)
            //| ((in[inOff + 2] & 0xff) << 16) | ((in[inOff + 3] & 0xff) << 24);
        //if (xOff == 16)
        //{
            //processBlock();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.774 -0400", hash_original_method = "F76655D079767580E949272246E442C2", hash_generated_method = "8141D120BF4430AEB3A8AFCB801BE99C")
    protected void processLength(
        long    bitLength) {
        if(xOff > 14)        
        {
            processBlock();
        } //End block
        X[14] = (int)(bitLength & 0xffffffff);
        X[15] = (int)(bitLength >>> 32);
        // ---------- Original Method ----------
        //if (xOff > 14)
        //{
            //processBlock();
        //}
        //X[14] = (int)(bitLength & 0xffffffff);
        //X[15] = (int)(bitLength >>> 32);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.775 -0400", hash_original_method = "C095FEC528E22D3933584D069B5AEBEC", hash_generated_method = "32D201254469F34E37C8CDB6F6210FF9")
    private void unpackWord(
        int     word,
        byte[]  out,
        int     outOff) {
        addTaint(outOff);
        addTaint(out[0]);
        addTaint(word);
        out[outOff]     = (byte)word;
        out[outOff + 1] = (byte)(word >>> 8);
        out[outOff + 2] = (byte)(word >>> 16);
        out[outOff + 3] = (byte)(word >>> 24);
        // ---------- Original Method ----------
        //out[outOff]     = (byte)word;
        //out[outOff + 1] = (byte)(word >>> 8);
        //out[outOff + 2] = (byte)(word >>> 16);
        //out[outOff + 3] = (byte)(word >>> 24);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.775 -0400", hash_original_method = "2C0425F44A983E26D17057A66E7774F6", hash_generated_method = "914062AFFF9AAB677D43CEF0AF0E799E")
    public int doFinal(
        byte[]  out,
        int     outOff) {
        addTaint(outOff);
        addTaint(out[0]);
        finish();
        unpackWord(H1, out, outOff);
        unpackWord(H2, out, outOff + 4);
        unpackWord(H3, out, outOff + 8);
        unpackWord(H4, out, outOff + 12);
        reset();
        int var4582481E693E9037762BFFA6D99AC172_1333297032 = (DIGEST_LENGTH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409923178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409923178;
        // ---------- Original Method ----------
        //finish();
        //unpackWord(H1, out, outOff);
        //unpackWord(H2, out, outOff + 4);
        //unpackWord(H3, out, outOff + 8);
        //unpackWord(H4, out, outOff + 12);
        //reset();
        //return DIGEST_LENGTH;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.776 -0400", hash_original_method = "1D88AF12F47BE66D32BA577915055CD5", hash_generated_method = "2D0E2B2262C05E988F5E2B37638220D1")
    public void reset() {
        super.reset();
        H1 = 0x67452301;
        H2 = 0xefcdab89;
        H3 = 0x98badcfe;
        H4 = 0x10325476;
        xOff = 0;
for(int i = 0;i != X.length;i++)
        {
            X[i] = 0;
        } //End block
        // ---------- Original Method ----------
        //super.reset();
        //H1 = 0x67452301;
        //H2 = 0xefcdab89;
        //H3 = 0x98badcfe;
        //H4 = 0x10325476;
        //xOff = 0;
        //for (int i = 0; i != X.length; i++)
        //{
            //X[i] = 0;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.776 -0400", hash_original_method = "A078642CC72A2F738FA96A2966371333", hash_generated_method = "B577C0E41F82EF10BBA7B1283513A625")
    private int rotateLeft(
        int x,
        int n) {
        addTaint(n);
        addTaint(x);
        int var6FA5A2142C0B48AC269A6CD715ACE791_1518676895 = ((x << n) | (x >>> (32 - n)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126220530 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126220530;
        // ---------- Original Method ----------
        //return (x << n) | (x >>> (32 - n));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.776 -0400", hash_original_method = "38D2A24ABE645695148EECE5A1633407", hash_generated_method = "8006A8C90CBFD52B18986BCF439BAF32")
    private int F(
        int u,
        int v,
        int w) {
        addTaint(w);
        addTaint(v);
        addTaint(u);
        int var23482B7C8A09ADE7AC52A36F52C9E0A8_1607795386 = ((u & v) | (~u & w));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584838081 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584838081;
        // ---------- Original Method ----------
        //return (u & v) | (~u & w);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.777 -0400", hash_original_method = "F823417414ECF2428B5CBDD347B9FAAC", hash_generated_method = "773E3BA49CF1B023B8E775192C884EEC")
    private int G(
        int u,
        int v,
        int w) {
        addTaint(w);
        addTaint(v);
        addTaint(u);
        int varFDAFA12B724129B81B1366BAA0B17F28_281124973 = ((u & w) | (v & ~w));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583382117 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583382117;
        // ---------- Original Method ----------
        //return (u & w) | (v & ~w);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.777 -0400", hash_original_method = "83C9F03736BB5BDF54EC87B24EC05890", hash_generated_method = "BEA996C193271E75C68E33C6449807B0")
    private int H(
        int u,
        int v,
        int w) {
        addTaint(w);
        addTaint(v);
        addTaint(u);
        int varA428E8AE54A74D88A00737DF2EDE78B8_1819839078 = (u ^ v ^ w);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165436670 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165436670;
        // ---------- Original Method ----------
        //return u ^ v ^ w;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.777 -0400", hash_original_method = "23BAA908E549D3D7165335B8EBDAA412", hash_generated_method = "0DA790DDF5F73AC5C393983503A69E2F")
    private int K(
        int u,
        int v,
        int w) {
        addTaint(w);
        addTaint(v);
        addTaint(u);
        int var606D2B30FE1C5342B0D7A9DFFFDF1F70_21588699 = (v ^ (u | ~w));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1789226319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1789226319;
        // ---------- Original Method ----------
        //return v ^ (u | ~w);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.789 -0400", hash_original_method = "D9E5895ECAF805883FA59A595552AAA6", hash_generated_method = "7BD9826E5A862EF5CCE40DBB6BDA90DC")
    protected void processBlock() {
        int a = H1;
        int b = H2;
        int c = H3;
        int d = H4;
        a = rotateLeft(a + F(b, c, d) + X[ 0] + 0xd76aa478, S11) + b;
        d = rotateLeft(d + F(a, b, c) + X[ 1] + 0xe8c7b756, S12) + a;
        c = rotateLeft(c + F(d, a, b) + X[ 2] + 0x242070db, S13) + d;
        b = rotateLeft(b + F(c, d, a) + X[ 3] + 0xc1bdceee, S14) + c;
        a = rotateLeft(a + F(b, c, d) + X[ 4] + 0xf57c0faf, S11) + b;
        d = rotateLeft(d + F(a, b, c) + X[ 5] + 0x4787c62a, S12) + a;
        c = rotateLeft(c + F(d, a, b) + X[ 6] + 0xa8304613, S13) + d;
        b = rotateLeft(b + F(c, d, a) + X[ 7] + 0xfd469501, S14) + c;
        a = rotateLeft(a + F(b, c, d) + X[ 8] + 0x698098d8, S11) + b;
        d = rotateLeft(d + F(a, b, c) + X[ 9] + 0x8b44f7af, S12) + a;
        c = rotateLeft(c + F(d, a, b) + X[10] + 0xffff5bb1, S13) + d;
        b = rotateLeft(b + F(c, d, a) + X[11] + 0x895cd7be, S14) + c;
        a = rotateLeft(a + F(b, c, d) + X[12] + 0x6b901122, S11) + b;
        d = rotateLeft(d + F(a, b, c) + X[13] + 0xfd987193, S12) + a;
        c = rotateLeft(c + F(d, a, b) + X[14] + 0xa679438e, S13) + d;
        b = rotateLeft(b + F(c, d, a) + X[15] + 0x49b40821, S14) + c;
        a = rotateLeft(a + G(b, c, d) + X[ 1] + 0xf61e2562, S21) + b;
        d = rotateLeft(d + G(a, b, c) + X[ 6] + 0xc040b340, S22) + a;
        c = rotateLeft(c + G(d, a, b) + X[11] + 0x265e5a51, S23) + d;
        b = rotateLeft(b + G(c, d, a) + X[ 0] + 0xe9b6c7aa, S24) + c;
        a = rotateLeft(a + G(b, c, d) + X[ 5] + 0xd62f105d, S21) + b;
        d = rotateLeft(d + G(a, b, c) + X[10] + 0x02441453, S22) + a;
        c = rotateLeft(c + G(d, a, b) + X[15] + 0xd8a1e681, S23) + d;
        b = rotateLeft(b + G(c, d, a) + X[ 4] + 0xe7d3fbc8, S24) + c;
        a = rotateLeft(a + G(b, c, d) + X[ 9] + 0x21e1cde6, S21) + b;
        d = rotateLeft(d + G(a, b, c) + X[14] + 0xc33707d6, S22) + a;
        c = rotateLeft(c + G(d, a, b) + X[ 3] + 0xf4d50d87, S23) + d;
        b = rotateLeft(b + G(c, d, a) + X[ 8] + 0x455a14ed, S24) + c;
        a = rotateLeft(a + G(b, c, d) + X[13] + 0xa9e3e905, S21) + b;
        d = rotateLeft(d + G(a, b, c) + X[ 2] + 0xfcefa3f8, S22) + a;
        c = rotateLeft(c + G(d, a, b) + X[ 7] + 0x676f02d9, S23) + d;
        b = rotateLeft(b + G(c, d, a) + X[12] + 0x8d2a4c8a, S24) + c;
        a = rotateLeft(a + H(b, c, d) + X[ 5] + 0xfffa3942, S31) + b;
        d = rotateLeft(d + H(a, b, c) + X[ 8] + 0x8771f681, S32) + a;
        c = rotateLeft(c + H(d, a, b) + X[11] + 0x6d9d6122, S33) + d;
        b = rotateLeft(b + H(c, d, a) + X[14] + 0xfde5380c, S34) + c;
        a = rotateLeft(a + H(b, c, d) + X[ 1] + 0xa4beea44, S31) + b;
        d = rotateLeft(d + H(a, b, c) + X[ 4] + 0x4bdecfa9, S32) + a;
        c = rotateLeft(c + H(d, a, b) + X[ 7] + 0xf6bb4b60, S33) + d;
        b = rotateLeft(b + H(c, d, a) + X[10] + 0xbebfbc70, S34) + c;
        a = rotateLeft(a + H(b, c, d) + X[13] + 0x289b7ec6, S31) + b;
        d = rotateLeft(d + H(a, b, c) + X[ 0] + 0xeaa127fa, S32) + a;
        c = rotateLeft(c + H(d, a, b) + X[ 3] + 0xd4ef3085, S33) + d;
        b = rotateLeft(b + H(c, d, a) + X[ 6] + 0x04881d05, S34) + c;
        a = rotateLeft(a + H(b, c, d) + X[ 9] + 0xd9d4d039, S31) + b;
        d = rotateLeft(d + H(a, b, c) + X[12] + 0xe6db99e5, S32) + a;
        c = rotateLeft(c + H(d, a, b) + X[15] + 0x1fa27cf8, S33) + d;
        b = rotateLeft(b + H(c, d, a) + X[ 2] + 0xc4ac5665, S34) + c;
        a = rotateLeft(a + K(b, c, d) + X[ 0] + 0xf4292244, S41) + b;
        d = rotateLeft(d + K(a, b, c) + X[ 7] + 0x432aff97, S42) + a;
        c = rotateLeft(c + K(d, a, b) + X[14] + 0xab9423a7, S43) + d;
        b = rotateLeft(b + K(c, d, a) + X[ 5] + 0xfc93a039, S44) + c;
        a = rotateLeft(a + K(b, c, d) + X[12] + 0x655b59c3, S41) + b;
        d = rotateLeft(d + K(a, b, c) + X[ 3] + 0x8f0ccc92, S42) + a;
        c = rotateLeft(c + K(d, a, b) + X[10] + 0xffeff47d, S43) + d;
        b = rotateLeft(b + K(c, d, a) + X[ 1] + 0x85845dd1, S44) + c;
        a = rotateLeft(a + K(b, c, d) + X[ 8] + 0x6fa87e4f, S41) + b;
        d = rotateLeft(d + K(a, b, c) + X[15] + 0xfe2ce6e0, S42) + a;
        c = rotateLeft(c + K(d, a, b) + X[ 6] + 0xa3014314, S43) + d;
        b = rotateLeft(b + K(c, d, a) + X[13] + 0x4e0811a1, S44) + c;
        a = rotateLeft(a + K(b, c, d) + X[ 4] + 0xf7537e82, S41) + b;
        d = rotateLeft(d + K(a, b, c) + X[11] + 0xbd3af235, S42) + a;
        c = rotateLeft(c + K(d, a, b) + X[ 2] + 0x2ad7d2bb, S43) + d;
        b = rotateLeft(b + K(c, d, a) + X[ 9] + 0xeb86d391, S44) + c;
        H1 += a;
        H2 += b;
        H3 += c;
        H4 += d;
        xOff = 0;
for(int i = 0;i != X.length;i++)
        {
            X[i] = 0;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.789 -0400", hash_original_field = "7FCCDAB4E8621E6E28CA5E3D9073F973", hash_generated_field = "D526475CCCE72C3A14D37ACEDCA80EFD")

    private static final int DIGEST_LENGTH = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.789 -0400", hash_original_field = "CBC45673054348941E08F640351ADC8B", hash_generated_field = "D2367602F07E2ECF5B18B6FBC74CE9E4")

    private static final int S11 = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.789 -0400", hash_original_field = "E151AA08E55D73355D35D4C4F5BDCFED", hash_generated_field = "DBA1AD4DF58FC4364A2ECB9F01D7BB53")

    private static final int S12 = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "664355182FEA7A9703686092E1FD7A2F", hash_generated_field = "3177DA7F557821F17CB5799E200B6D7C")

    private static final int S13 = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "7C561A805C3427E20A461BE210A757A4", hash_generated_field = "DF338DBE9FE7E283CA0AFFD07DC01115")

    private static final int S14 = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "BC23BE3B992EE9EB2686B2030E654C1C", hash_generated_field = "AACDC1158B6C43616E5AE1B578598AF8")

    private static final int S21 = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "D78EDF19ECA3E9C50843B0669C827756", hash_generated_field = "B8EA319935248BF7F478A2A6A0D11C24")

    private static final int S22 = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "DA472EA526D59D2EAE02B9B33095C086", hash_generated_field = "3FA0E870FFED3B1FD03FEA917BBC6083")

    private static final int S23 = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "4A04C8E3BAE3988363F6B08FCB373717", hash_generated_field = "734862763017381D3DBD0014D99CCDF2")

    private static final int S24 = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "39488045525B1B1645DBD4337FACF9C0", hash_generated_field = "A7886E75E00D0B4F461BFE7FFEE2EFC5")

    private static final int S31 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "0C6D3228716CFCA24187D2C4328A58B1", hash_generated_field = "202A20E024C4D185037E65E317E76161")

    private static final int S32 = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "A5CAF97B98800F6F55AB5A6CCB6512C1", hash_generated_field = "E991735F9F3AF38D0DE76F2F9A4A92EC")

    private static final int S33 = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "079E45DAF602331297CDDC32D6FE729A", hash_generated_field = "DCFB58B2BFBA1B469F3FC1D6EF2BF750")

    private static final int S34 = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "638E691F05B733D979A2A1429A8CB383", hash_generated_field = "263ACAA08913E1C35C40E641F4D2125F")

    private static final int S41 = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "C14C3D1B6656100F689CF5A320CEEBA9", hash_generated_field = "F7BEE44DBCCC9509EEB671D38CBFD59B")

    private static final int S42 = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "C268E7C60ED9A9BDCCF03B78BF8C3ADE", hash_generated_field = "217785C1AB06F3B51CD59BD52988E9C8")

    private static final int S43 = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.790 -0400", hash_original_field = "4D9D8DB595D90D2200E40580AC9D0A6B", hash_generated_field = "DC8F2AF3E1B9C3EFEFF1A436F9E5A237")

    private static final int S44 = 21;
}

