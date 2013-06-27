package org.bouncycastle.crypto.digests;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.crypto.util.Pack;

public class SHA1Digest extends GeneralDigest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.189 -0400", hash_original_field = "106530DC42BAA21C67F8A3AF4D7FD9E1", hash_generated_field = "A20F40A5A8396B664558E10A31EADBF9")

    private int H1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.189 -0400", hash_original_field = "CA2BF3F6B7E18A508253E9521510A4B5", hash_generated_field = "5D98AFA23A2DDA6581A809AACADB99CD")

    private int H2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.189 -0400", hash_original_field = "B14763210C3AB7284E9CBE731D7DC2A5", hash_generated_field = "2FD00213764EF55752DFCD6B7F5728A6")

    private int H3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.190 -0400", hash_original_field = "6B57370BA89BD88A2D6D819D65F6007A", hash_generated_field = "9E56BF920F4B712E7DB21A0B9EF6F5AF")

    private int H4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.190 -0400", hash_original_field = "830652084DDA69B6B957E2C3A7BD9B18", hash_generated_field = "844FC835FC16FD7D12D2795226E03FEC")

    private int H5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.190 -0400", hash_original_field = "DC2B48BC72CDA0D3F5D0E82131CE153D", hash_generated_field = "8F6FFE924E27CCB7C5DC0F1AC2F650D7")

    private int[] X = new int[80];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.190 -0400", hash_original_field = "C5A8521A972D9AB2588ADF57317C8D4B", hash_generated_field = "D14E80AF1F9317982664F9E415590C80")

    private int xOff;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.190 -0400", hash_original_method = "1DF8B488961A33FC47935CC7CCD682F9", hash_generated_method = "5BEBE9232FDB549FC09A55F3A228E9E2")
    public  SHA1Digest() {
        reset();
        // ---------- Original Method ----------
        //reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.198 -0400", hash_original_method = "2658789ECEB2A700883676C5815F56AD", hash_generated_method = "7057FD241BF30991DA8810797C3FC58B")
    public  SHA1Digest(SHA1Digest t) {
        super(t);
        H1 = t.H1;
        H2 = t.H2;
        H3 = t.H3;
        H4 = t.H4;
        H5 = t.H5;
        System.arraycopy(t.X, 0, X, 0, t.X.length);
        xOff = t.xOff;
        // ---------- Original Method ----------
        //H1 = t.H1;
        //H2 = t.H2;
        //H3 = t.H3;
        //H4 = t.H4;
        //H5 = t.H5;
        //System.arraycopy(t.X, 0, X, 0, t.X.length);
        //xOff = t.xOff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.199 -0400", hash_original_method = "A93F195BA36C5C6DC02ECFC655EFA07D", hash_generated_method = "F1264E7DC8886BA8C63530F9ED87809F")
    public String getAlgorithmName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1749669548 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1749669548 = "SHA-1";
        varB4EAC82CA7396A68D541C85D26508E83_1749669548.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1749669548;
        // ---------- Original Method ----------
        //return "SHA-1";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.200 -0400", hash_original_method = "3039C1E557EE9A1557E064C50078D361", hash_generated_method = "52B71C1DDB52C65FA2E6B3FAE1AE1CCF")
    public int getDigestSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1791175179 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1791175179;
        // ---------- Original Method ----------
        //return DIGEST_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.203 -0400", hash_original_method = "54433F6F6E3BCA59AD49A11DE4A21224", hash_generated_method = "CBCCFA4596E3F49A213A89577B3939BA")
    protected void processWord(
        byte[]  in,
        int     inOff) {
        int n;
        n = in[  inOff] << 24;
        n |= (in[++inOff] & 0xff) << 16;
        n |= (in[++inOff] & 0xff) << 8;
        n |= (in[++inOff] & 0xff);
        X[xOff] = n;
        {
            processBlock();
        } //End block
        addTaint(in[0]);
        addTaint(inOff);
        // ---------- Original Method ----------
        //int n = in[  inOff] << 24;
        //n |= (in[++inOff] & 0xff) << 16;
        //n |= (in[++inOff] & 0xff) << 8;
        //n |= (in[++inOff] & 0xff);
        //X[xOff] = n;
        //if (++xOff == 16)
        //{
            //processBlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.203 -0400", hash_original_method = "E48925D533DC79A9930A6F42B92C0F9E", hash_generated_method = "328DE703BF93274E67C5AB9A832B3D85")
    protected void processLength(
        long    bitLength) {
        {
            processBlock();
        } //End block
        X[14] = (int)(bitLength >>> 32);
        X[15] = (int)(bitLength & 0xffffffff);
        // ---------- Original Method ----------
        //if (xOff > 14)
        //{
            //processBlock();
        //}
        //X[14] = (int)(bitLength >>> 32);
        //X[15] = (int)(bitLength & 0xffffffff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.211 -0400", hash_original_method = "7A3A19F87647349D75F24CB81F80AF7C", hash_generated_method = "06106FE7EBA5DAF8CD4AA430B285A588")
    public int doFinal(
        byte[]  out,
        int     outOff) {
        finish();
        Pack.intToBigEndian(H1, out, outOff);
        Pack.intToBigEndian(H2, out, outOff + 4);
        Pack.intToBigEndian(H3, out, outOff + 8);
        Pack.intToBigEndian(H4, out, outOff + 12);
        Pack.intToBigEndian(H5, out, outOff + 16);
        reset();
        addTaint(out[0]);
        addTaint(outOff);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1749606206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1749606206;
        // ---------- Original Method ----------
        //finish();
        //Pack.intToBigEndian(H1, out, outOff);
        //Pack.intToBigEndian(H2, out, outOff + 4);
        //Pack.intToBigEndian(H3, out, outOff + 8);
        //Pack.intToBigEndian(H4, out, outOff + 12);
        //Pack.intToBigEndian(H5, out, outOff + 16);
        //reset();
        //return DIGEST_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.211 -0400", hash_original_method = "0BD8B4210E063DA673A9D4D2CF1851E6", hash_generated_method = "BFF5B8A84814F34EEB52CAD29505502A")
    public void reset() {
        super.reset();
        H1 = 0x67452301;
        H2 = 0xefcdab89;
        H3 = 0x98badcfe;
        H4 = 0x10325476;
        H5 = 0xc3d2e1f0;
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
        //H5 = 0xc3d2e1f0;
        //xOff = 0;
        //for (int i = 0; i != X.length; i++)
        //{
            //X[i] = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.223 -0400", hash_original_method = "56B08AF140AAB579ED6513720D1D076E", hash_generated_method = "B6A360DAC5B07796B2571F7ECC99E340")
    private int f(
        int    u,
        int    v,
        int    w) {
        addTaint(u);
        addTaint(v);
        addTaint(w);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657245330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657245330;
        // ---------- Original Method ----------
        //return ((u & v) | ((~u) & w));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.223 -0400", hash_original_method = "D49E57B066D19086A0B27FD85ECFCAA8", hash_generated_method = "4E80058811A52FD528B53F4C34F82650")
    private int h(
        int    u,
        int    v,
        int    w) {
        addTaint(u);
        addTaint(v);
        addTaint(w);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617337600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617337600;
        // ---------- Original Method ----------
        //return (u ^ v ^ w);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.223 -0400", hash_original_method = "1EBC13F1810260C1F73348183BDA0BFB", hash_generated_method = "7B722FCA73A1BCF6EECCB7D9B8C2A531")
    private int g(
        int    u,
        int    v,
        int    w) {
        addTaint(u);
        addTaint(v);
        addTaint(w);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656950393 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656950393;
        // ---------- Original Method ----------
        //return ((u & v) | (u & w) | (v & w));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.242 -0400", hash_original_method = "9525843836346F2F7CCC2D59A953FC80", hash_generated_method = "94EF2DC3389FBA0B2A46C8CBB04CB8D4")
    protected void processBlock() {
        {
            int i;
            i = 16;
            {
                int t;
                t = X[i - 3] ^ X[i - 8] ^ X[i - 14] ^ X[i - 16];
                X[i] = t << 1 | t >>> 31;
            } //End block
        } //End collapsed parenthetic
        int A;
        A = H1;
        int B;
        B = H2;
        int C;
        C = H3;
        int D;
        D = H4;
        int E;
        E = H5;
        int idx;
        idx = 0;
        {
            int j;
            j = 0;
            {
                E += (A << 5 | A >>> 27) + f(B, C, D) + X[idx++] + Y1;
                B = B << 30 | B >>> 2;
                D += (E << 5 | E >>> 27) + f(A, B, C) + X[idx++] + Y1;
                A = A << 30 | A >>> 2;
                C += (D << 5 | D >>> 27) + f(E, A, B) + X[idx++] + Y1;
                E = E << 30 | E >>> 2;
                B += (C << 5 | C >>> 27) + f(D, E, A) + X[idx++] + Y1;
                D = D << 30 | D >>> 2;
                A += (B << 5 | B >>> 27) + f(C, D, E) + X[idx++] + Y1;
                C = C << 30 | C >>> 2;
            } //End block
        } //End collapsed parenthetic
        {
            int j;
            j = 0;
            {
                E += (A << 5 | A >>> 27) + h(B, C, D) + X[idx++] + Y2;
                B = B << 30 | B >>> 2;
                D += (E << 5 | E >>> 27) + h(A, B, C) + X[idx++] + Y2;
                A = A << 30 | A >>> 2;
                C += (D << 5 | D >>> 27) + h(E, A, B) + X[idx++] + Y2;
                E = E << 30 | E >>> 2;
                B += (C << 5 | C >>> 27) + h(D, E, A) + X[idx++] + Y2;
                D = D << 30 | D >>> 2;
                A += (B << 5 | B >>> 27) + h(C, D, E) + X[idx++] + Y2;
                C = C << 30 | C >>> 2;
            } //End block
        } //End collapsed parenthetic
        {
            int j;
            j = 0;
            {
                E += (A << 5 | A >>> 27) + g(B, C, D) + X[idx++] + Y3;
                B = B << 30 | B >>> 2;
                D += (E << 5 | E >>> 27) + g(A, B, C) + X[idx++] + Y3;
                A = A << 30 | A >>> 2;
                C += (D << 5 | D >>> 27) + g(E, A, B) + X[idx++] + Y3;
                E = E << 30 | E >>> 2;
                B += (C << 5 | C >>> 27) + g(D, E, A) + X[idx++] + Y3;
                D = D << 30 | D >>> 2;
                A += (B << 5 | B >>> 27) + g(C, D, E) + X[idx++] + Y3;
                C = C << 30 | C >>> 2;
            } //End block
        } //End collapsed parenthetic
        {
            int j;
            j = 0;
            {
                E += (A << 5 | A >>> 27) + h(B, C, D) + X[idx++] + Y4;
                B = B << 30 | B >>> 2;
                D += (E << 5 | E >>> 27) + h(A, B, C) + X[idx++] + Y4;
                A = A << 30 | A >>> 2;
                C += (D << 5 | D >>> 27) + h(E, A, B) + X[idx++] + Y4;
                E = E << 30 | E >>> 2;
                B += (C << 5 | C >>> 27) + h(D, E, A) + X[idx++] + Y4;
                D = D << 30 | D >>> 2;
                A += (B << 5 | B >>> 27) + h(C, D, E) + X[idx++] + Y4;
                C = C << 30 | C >>> 2;
            } //End block
        } //End collapsed parenthetic
        H1 += A;
        H2 += B;
        H3 += C;
        H4 += D;
        H5 += E;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.243 -0400", hash_original_field = "0CEAA24F7308BBA7736880F7C7E9504B", hash_generated_field = "EED3E9D1455E9B1987E39B952746898C")

    private static int DIGEST_LENGTH = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.243 -0400", hash_original_field = "DCA34784C348FCFCA55FFB8F9EA2372E", hash_generated_field = "BD48E45BC7618A50E29CAC01A63889FF")

    private static int Y1 = 0x5a827999;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.243 -0400", hash_original_field = "51C04E8C673712A69AEFB490FB025010", hash_generated_field = "7B358DA971015E4A78AF92E743C66829")

    private static int Y2 = 0x6ed9eba1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.243 -0400", hash_original_field = "1CA87970FFB9AECDE86792AAAA385FF6", hash_generated_field = "0B11DE48F477DF295AF043927F6A744C")

    private static int Y3 = 0x8f1bbcdc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.243 -0400", hash_original_field = "28F53FD1C4B51EEC66AB8CB0C8C2AA70", hash_generated_field = "C6A35AE025EDA1054FBEAED257CE0F0B")

    private static int Y4 = 0xca62c1d6;
}

