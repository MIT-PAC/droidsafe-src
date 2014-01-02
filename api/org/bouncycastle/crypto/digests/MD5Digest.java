package org.bouncycastle.crypto.digests;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class MD5Digest extends GeneralDigest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.752 -0500", hash_original_field = "C4237AEA9E5B286171811440EA43F2CF", hash_generated_field = "D526475CCCE72C3A14D37ACEDCA80EFD")

    private static final int    DIGEST_LENGTH = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.783 -0500", hash_original_field = "D56997C4086459EDCDD8B03064BB5528", hash_generated_field = "4F2DB9E032A21D3DBCE895CC5249DE1B")

    // round 1 left rotates
    //
    private static final int S11 = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.785 -0500", hash_original_field = "96E6493F95EB2058A1D73CD0D0BC6AED", hash_generated_field = "DBA1AD4DF58FC4364A2ECB9F01D7BB53")

    private static final int S12 = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.788 -0500", hash_original_field = "84C4CB0BC87AA2DC100B8E81DA6159BF", hash_generated_field = "3177DA7F557821F17CB5799E200B6D7C")

    private static final int S13 = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.791 -0500", hash_original_field = "C32936CF78DBB5C51502BA1FFD57420A", hash_generated_field = "DF338DBE9FE7E283CA0AFFD07DC01115")

    private static final int S14 = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.793 -0500", hash_original_field = "47FAA67AFC4480E5F26A1B0A0E5F9D2D", hash_generated_field = "19D6455AC048CFE57903890582867D34")

    // round 2 left rotates
    //
    private static final int S21 = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.795 -0500", hash_original_field = "7D1BCB1FDE942F2B2D4645A5151F89EB", hash_generated_field = "B8EA319935248BF7F478A2A6A0D11C24")

    private static final int S22 = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.797 -0500", hash_original_field = "060623E8A3FDBFD711ACD69E89B4FA44", hash_generated_field = "3FA0E870FFED3B1FD03FEA917BBC6083")

    private static final int S23 = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.800 -0500", hash_original_field = "8D35C89CA45C09B07FFBB3D85180B028", hash_generated_field = "734862763017381D3DBD0014D99CCDF2")

    private static final int S24 = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.802 -0500", hash_original_field = "5F6B9521C1B56CE131CD6FDA39BA1FE3", hash_generated_field = "02931D6FF43421DCFC13A603914588BA")

    // round 3 left rotates
    //
    private static final int S31 = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.806 -0500", hash_original_field = "2CEBDAB29B4A60A318AADA43D2E33807", hash_generated_field = "202A20E024C4D185037E65E317E76161")

    private static final int S32 = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.808 -0500", hash_original_field = "9A25A10B2D87CAD4495BD6FD508A01D4", hash_generated_field = "E991735F9F3AF38D0DE76F2F9A4A92EC")

    private static final int S33 = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.811 -0500", hash_original_field = "47167E0EDFF7CF20676B7DE2B6DFF7B2", hash_generated_field = "DCFB58B2BFBA1B469F3FC1D6EF2BF750")

    private static final int S34 = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.813 -0500", hash_original_field = "4391AD91DFDDDF6EBA920276B6BB528F", hash_generated_field = "A3429499D81D8D52E43EAEC1BF84D0AB")

    // round 4 left rotates
    //
    private static final int S41 = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.815 -0500", hash_original_field = "21266A8A4415612B252CB8CB574F0AC9", hash_generated_field = "F7BEE44DBCCC9509EEB671D38CBFD59B")

    private static final int S42 = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.818 -0500", hash_original_field = "6B5167397A0E016B999F086D8DC85F09", hash_generated_field = "217785C1AB06F3B51CD59BD52988E9C8")

    private static final int S43 = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.820 -0500", hash_original_field = "87A4BFD939AE0BABC2E06223F724DBA9", hash_generated_field = "DC8F2AF3E1B9C3EFEFF1A436F9E5A237")

    private static final int S44 = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.770 -0400", hash_original_field = "106530DC42BAA21C67F8A3AF4D7FD9E1", hash_generated_field = "A20F40A5A8396B664558E10A31EADBF9")

    private int H1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.770 -0400", hash_original_field = "CA2BF3F6B7E18A508253E9521510A4B5", hash_generated_field = "5D98AFA23A2DDA6581A809AACADB99CD")

    private int H2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.770 -0400", hash_original_field = "B14763210C3AB7284E9CBE731D7DC2A5", hash_generated_field = "2FD00213764EF55752DFCD6B7F5728A6")

    private int H3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.770 -0400", hash_original_field = "6B57370BA89BD88A2D6D819D65F6007A", hash_generated_field = "9E56BF920F4B712E7DB21A0B9EF6F5AF")

    private int H4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.756 -0500", hash_original_field = "6D065F18D3AA67F35BFD608B2EB3FEF6", hash_generated_field = "9F176090F37D70875BB7E38ED405BB04")


    private int[]   X = new int[16];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.758 -0500", hash_original_field = "B7445263BE5AA36D026E05FA52197EA0", hash_generated_field = "D14E80AF1F9317982664F9E415590C80")

    private int     xOff;

    /**
     * Standard constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.761 -0500", hash_original_method = "CA98629A68DF074D716C2EED7E360A30", hash_generated_method = "D16AFD0F211EF85EF9DCA2E0F0F2606C")
    
public MD5Digest()
    {
        reset();
    }

    /**
     * Copy constructor.  This will copy the state of the provided
     * message digest.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.764 -0500", hash_original_method = "D456AB50DF678E39352B68F4F0BE277E", hash_generated_method = "7FA40D44E54000025AE6C65625164392")
    
public MD5Digest(MD5Digest t)
    {
        super(t);

        H1 = t.H1;
        H2 = t.H2;
        H3 = t.H3;
        H4 = t.H4;

        System.arraycopy(t.X, 0, X, 0, t.X.length);
        xOff = t.xOff;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.766 -0500", hash_original_method = "D54FFA3F0B368E98533F0D87F68E98DA", hash_generated_method = "1CC511C6DE0B9BB4F512574650E0C1E0")
    
public String getAlgorithmName()
    {
        return "MD5";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.768 -0500", hash_original_method = "3039C1E557EE9A1557E064C50078D361", hash_generated_method = "7FB03A29E68971CC5701D6DA0F67A19C")
    
public int getDigestSize()
    {
        return DIGEST_LENGTH;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.771 -0500", hash_original_method = "F91F442FD561833E473644F7E1FD670A", hash_generated_method = "C967B94F39F418EF3A25209D121CDF0A")
    
protected void processWord(
        byte[]  in,
        int     inOff)
    {
        X[xOff++] = (in[inOff] & 0xff) | ((in[inOff + 1] & 0xff) << 8)
            | ((in[inOff + 2] & 0xff) << 16) | ((in[inOff + 3] & 0xff) << 24); 

        if (xOff == 16)
        {
            processBlock();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.774 -0500", hash_original_method = "F76655D079767580E949272246E442C2", hash_generated_method = "B163675D5C8975C7EF44A78748A9DAAC")
    
protected void processLength(
        long    bitLength)
    {
        if (xOff > 14)
        {
            processBlock();
        }

        X[14] = (int)(bitLength & 0xffffffff);
        X[15] = (int)(bitLength >>> 32);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.776 -0500", hash_original_method = "C095FEC528E22D3933584D069B5AEBEC", hash_generated_method = "4B18F552C01293658BB99F363EB66FBA")
    
private void unpackWord(
        int     word,
        byte[]  out,
        int     outOff)
    {
        out[outOff]     = (byte)word;
        out[outOff + 1] = (byte)(word >>> 8);
        out[outOff + 2] = (byte)(word >>> 16);
        out[outOff + 3] = (byte)(word >>> 24);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.778 -0500", hash_original_method = "2C0425F44A983E26D17057A66E7774F6", hash_generated_method = "704662BD97DA1BF126EC6D7CC6188093")
    
public int doFinal(
        byte[]  out,
        int     outOff)
    {
        finish();

        unpackWord(H1, out, outOff);
        unpackWord(H2, out, outOff + 4);
        unpackWord(H3, out, outOff + 8);
        unpackWord(H4, out, outOff + 12);

        reset();

        return DIGEST_LENGTH;
    }

    /**
     * reset the chaining variables to the IV values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.781 -0500", hash_original_method = "1D88AF12F47BE66D32BA577915055CD5", hash_generated_method = "9890FA3634057FE61E5F0620C66A19E9")
    
public void reset()
    {
        super.reset();

        H1 = 0x67452301;
        H2 = 0xefcdab89;
        H3 = 0x98badcfe;
        H4 = 0x10325476;

        xOff = 0;

        for (int i = 0; i != X.length; i++)
        {
            X[i] = 0;
        }
    }

    /*
     * rotate int x left n bits.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.822 -0500", hash_original_method = "A078642CC72A2F738FA96A2966371333", hash_generated_method = "01F4DF316CBA5CD957630EE9BB83DAF4")
    
private int rotateLeft(
        int x,
        int n)
    {
        return (x << n) | (x >>> (32 - n));
    }

    /*
     * F, G, H and I are the basic MD5 functions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.825 -0500", hash_original_method = "38D2A24ABE645695148EECE5A1633407", hash_generated_method = "38A70B93C986D1108EDDBFA0D697042E")
    
private int F(
        int u,
        int v,
        int w)
    {
        return (u & v) | (~u & w);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.827 -0500", hash_original_method = "F823417414ECF2428B5CBDD347B9FAAC", hash_generated_method = "A8E72E3E5E4A8AD1B9DB51CB18FC61B9")
    
private int G(
        int u,
        int v,
        int w)
    {
        return (u & w) | (v & ~w);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.829 -0500", hash_original_method = "83C9F03736BB5BDF54EC87B24EC05890", hash_generated_method = "58EBA8EBEE20DBEF0218ECD378CDC7CD")
    
private int H(
        int u,
        int v,
        int w)
    {
        return u ^ v ^ w;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.831 -0500", hash_original_method = "23BAA908E549D3D7165335B8EBDAA412", hash_generated_method = "83800AD71417A6BE861BFE86F3FC378F")
    
private int K(
        int u,
        int v,
        int w)
    {
        return v ^ (u | ~w);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:31.837 -0500", hash_original_method = "D9E5895ECAF805883FA59A595552AAA6", hash_generated_method = "64D6654CC4597E112C6FB39E6B094C8E")
    
protected void processBlock()
    {
        int a = H1;
        int b = H2;
        int c = H3;
        int d = H4;

        //
        // Round 1 - F cycle, 16 times.
        //
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

        //
        // Round 2 - G cycle, 16 times.
        //
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

        //
        // Round 3 - H cycle, 16 times.
        //
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

        //
        // Round 4 - K cycle, 16 times.
        //
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

        //
        // reset the offset and clean out the word buffer.
        //
        xOff = 0;
        for (int i = 0; i != X.length; i++)
        {
            X[i] = 0;
        }
    }
}

