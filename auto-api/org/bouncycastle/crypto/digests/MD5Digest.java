package org.bouncycastle.crypto.digests;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MD5Digest extends GeneralDigest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.569 -0400", hash_original_field = "106530DC42BAA21C67F8A3AF4D7FD9E1", hash_generated_field = "A20F40A5A8396B664558E10A31EADBF9")

    private int H1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.569 -0400", hash_original_field = "CA2BF3F6B7E18A508253E9521510A4B5", hash_generated_field = "5D98AFA23A2DDA6581A809AACADB99CD")

    private int H2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.569 -0400", hash_original_field = "B14763210C3AB7284E9CBE731D7DC2A5", hash_generated_field = "2FD00213764EF55752DFCD6B7F5728A6")

    private int H3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.570 -0400", hash_original_field = "6B57370BA89BD88A2D6D819D65F6007A", hash_generated_field = "9E56BF920F4B712E7DB21A0B9EF6F5AF")

    private int H4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.570 -0400", hash_original_field = "087F99198A6B4FD30A6675940686C027", hash_generated_field = "9F176090F37D70875BB7E38ED405BB04")

    private int[] X = new int[16];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.579 -0400", hash_original_field = "C5A8521A972D9AB2588ADF57317C8D4B", hash_generated_field = "D14E80AF1F9317982664F9E415590C80")

    private int xOff;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.580 -0400", hash_original_method = "CA98629A68DF074D716C2EED7E360A30", hash_generated_method = "31A92487FDF635D7C47FB6419F68D10C")
    public  MD5Digest() {
        reset();
        // ---------- Original Method ----------
        //reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.580 -0400", hash_original_method = "D456AB50DF678E39352B68F4F0BE277E", hash_generated_method = "488DA5589A8892ECA9FA29886A372F0F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.582 -0400", hash_original_method = "D54FFA3F0B368E98533F0D87F68E98DA", hash_generated_method = "5E5A4AF5E78C43CE51BE4F0303390B1A")
    public String getAlgorithmName() {
        String varB4EAC82CA7396A68D541C85D26508E83_212772586 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_212772586 = "MD5";
        varB4EAC82CA7396A68D541C85D26508E83_212772586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_212772586;
        // ---------- Original Method ----------
        //return "MD5";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.582 -0400", hash_original_method = "3039C1E557EE9A1557E064C50078D361", hash_generated_method = "8C3A7A453F63EC78011EE12AEAFEAE2C")
    public int getDigestSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023439552 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023439552;
        // ---------- Original Method ----------
        //return DIGEST_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.583 -0400", hash_original_method = "F91F442FD561833E473644F7E1FD670A", hash_generated_method = "4A72C0CD8E91E128E6759B716F487C9C")
    protected void processWord(
        byte[]  in,
        int     inOff) {
        X[xOff++] = (in[inOff] & 0xff) | ((in[inOff + 1] & 0xff) << 8)
            | ((in[inOff + 2] & 0xff) << 16) | ((in[inOff + 3] & 0xff) << 24);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.584 -0400", hash_original_method = "F76655D079767580E949272246E442C2", hash_generated_method = "5C8E03639B26AF027E8A604BAD53C428")
    protected void processLength(
        long    bitLength) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.587 -0400", hash_original_method = "C095FEC528E22D3933584D069B5AEBEC", hash_generated_method = "078E671EEBCA6AF6F9BD309B4AA3F4DE")
    private void unpackWord(
        int     word,
        byte[]  out,
        int     outOff) {
        out[outOff]     = (byte)word;
        out[outOff + 1] = (byte)(word >>> 8);
        out[outOff + 2] = (byte)(word >>> 16);
        out[outOff + 3] = (byte)(word >>> 24);
        addTaint(word);
        addTaint(out[0]);
        addTaint(outOff);
        // ---------- Original Method ----------
        //out[outOff]     = (byte)word;
        //out[outOff + 1] = (byte)(word >>> 8);
        //out[outOff + 2] = (byte)(word >>> 16);
        //out[outOff + 3] = (byte)(word >>> 24);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.605 -0400", hash_original_method = "2C0425F44A983E26D17057A66E7774F6", hash_generated_method = "3C8B49B59749B699BC6E9F3DF929B093")
    public int doFinal(
        byte[]  out,
        int     outOff) {
        finish();
        unpackWord(H1, out, outOff);
        unpackWord(H2, out, outOff + 4);
        unpackWord(H3, out, outOff + 8);
        unpackWord(H4, out, outOff + 12);
        reset();
        addTaint(out[0]);
        addTaint(outOff);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59760133 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59760133;
        // ---------- Original Method ----------
        //finish();
        //unpackWord(H1, out, outOff);
        //unpackWord(H2, out, outOff + 4);
        //unpackWord(H3, out, outOff + 8);
        //unpackWord(H4, out, outOff + 12);
        //reset();
        //return DIGEST_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.617 -0400", hash_original_method = "1D88AF12F47BE66D32BA577915055CD5", hash_generated_method = "D99A761E62D9A8260CE7638CA2A5EEB5")
    public void reset() {
        super.reset();
        H1 = 0x67452301;
        H2 = 0xefcdab89;
        H3 = 0x98badcfe;
        H4 = 0x10325476;
        xOff = 0;
        {
            int i;
            i = 0;
            {
                X[i] = 0;
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.617 -0400", hash_original_method = "A078642CC72A2F738FA96A2966371333", hash_generated_method = "1C96D1964EBF142CCC33522EE58714FB")
    private int rotateLeft(
        int x,
        int n) {
        addTaint(x);
        addTaint(n);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396346245 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396346245;
        // ---------- Original Method ----------
        //return (x << n) | (x >>> (32 - n));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.618 -0400", hash_original_method = "38D2A24ABE645695148EECE5A1633407", hash_generated_method = "E2295733C708008CB05254C71F199735")
    private int F(
        int u,
        int v,
        int w) {
        addTaint(u);
        addTaint(v);
        addTaint(w);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569065401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569065401;
        // ---------- Original Method ----------
        //return (u & v) | (~u & w);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.618 -0400", hash_original_method = "F823417414ECF2428B5CBDD347B9FAAC", hash_generated_method = "75F8D4992EA6746930ABBECDD175FEB7")
    private int G(
        int u,
        int v,
        int w) {
        addTaint(u);
        addTaint(v);
        addTaint(w);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34293584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34293584;
        // ---------- Original Method ----------
        //return (u & w) | (v & ~w);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.619 -0400", hash_original_method = "83C9F03736BB5BDF54EC87B24EC05890", hash_generated_method = "2D843526A1B8B0E35E515581062AEBFA")
    private int H(
        int u,
        int v,
        int w) {
        addTaint(u);
        addTaint(v);
        addTaint(w);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463441613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463441613;
        // ---------- Original Method ----------
        //return u ^ v ^ w;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.619 -0400", hash_original_method = "23BAA908E549D3D7165335B8EBDAA412", hash_generated_method = "A022F5ADA8B90F8EC9006B7C820279AC")
    private int K(
        int u,
        int v,
        int w) {
        addTaint(u);
        addTaint(v);
        addTaint(w);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030830054 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030830054;
        // ---------- Original Method ----------
        //return v ^ (u | ~w);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.704 -0400", hash_original_method = "D9E5895ECAF805883FA59A595552AAA6", hash_generated_method = "15500E7FA302CB8072A9E4F48D4D95E2")
    protected void processBlock() {
        int a;
        a = H1;
        int b;
        b = H2;
        int c;
        c = H3;
        int d;
        d = H4;
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
        {
            int i;
            i = 0;
            {
                X[i] = 0;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.704 -0400", hash_original_field = "7FCCDAB4E8621E6E28CA5E3D9073F973", hash_generated_field = "51A664BC0675D7CBD42779FA98FCA02B")

    private static int DIGEST_LENGTH = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.704 -0400", hash_original_field = "CBC45673054348941E08F640351ADC8B", hash_generated_field = "E8793B3716E2223B8574E13175AFAD34")

    private static int S11 = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.704 -0400", hash_original_field = "E151AA08E55D73355D35D4C4F5BDCFED", hash_generated_field = "EA7883FF8C3BE925409D681DB21BB0D2")

    private static int S12 = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.704 -0400", hash_original_field = "664355182FEA7A9703686092E1FD7A2F", hash_generated_field = "233D2EB355B3AB783AFD42409F8F0BA9")

    private static int S13 = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.704 -0400", hash_original_field = "7C561A805C3427E20A461BE210A757A4", hash_generated_field = "7E2A232C2D0C2BA7E0BE2B25A4E9E0A1")

    private static int S14 = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.704 -0400", hash_original_field = "BC23BE3B992EE9EB2686B2030E654C1C", hash_generated_field = "4252C927B7ECB7F0391CB122A70B300F")

    private static int S21 = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.704 -0400", hash_original_field = "D78EDF19ECA3E9C50843B0669C827756", hash_generated_field = "073982BE110AD9C411FE1CFFDD9E3D05")

    private static int S22 = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.704 -0400", hash_original_field = "DA472EA526D59D2EAE02B9B33095C086", hash_generated_field = "0E0E1EAE296087AA288F7C75C394AEFA")

    private static int S23 = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.704 -0400", hash_original_field = "4A04C8E3BAE3988363F6B08FCB373717", hash_generated_field = "B1C5F40206C9A7E73EAED8852C27E946")

    private static int S24 = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.704 -0400", hash_original_field = "39488045525B1B1645DBD4337FACF9C0", hash_generated_field = "7F8734223A2C197F4A89292A21DBDE11")

    private static int S31 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.705 -0400", hash_original_field = "0C6D3228716CFCA24187D2C4328A58B1", hash_generated_field = "5A4130581E422B7258B7D864D3AF4797")

    private static int S32 = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.705 -0400", hash_original_field = "A5CAF97B98800F6F55AB5A6CCB6512C1", hash_generated_field = "6A097B62B32992D8C005003DC5AB7BA7")

    private static int S33 = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.705 -0400", hash_original_field = "079E45DAF602331297CDDC32D6FE729A", hash_generated_field = "A1847F6D71A5C098AE3BC8846E42AFCD")

    private static int S34 = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.705 -0400", hash_original_field = "638E691F05B733D979A2A1429A8CB383", hash_generated_field = "D661DF540D6F73E1F417BAB42A1E0AA5")

    private static int S41 = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.705 -0400", hash_original_field = "C14C3D1B6656100F689CF5A320CEEBA9", hash_generated_field = "313F47E84B4D4699E25DACF2725220BC")

    private static int S42 = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.705 -0400", hash_original_field = "C268E7C60ED9A9BDCCF03B78BF8C3ADE", hash_generated_field = "8C5AA6514047B22699CE8CBC7C04913E")

    private static int S43 = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.705 -0400", hash_original_field = "4D9D8DB595D90D2200E40580AC9D0A6B", hash_generated_field = "E30BCE7B81C5F2CE8DE2A7AE36C767F8")

    private static int S44 = 21;
}

