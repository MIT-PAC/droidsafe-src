package com.android.org.bouncycastle.crypto.digests;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.org.bouncycastle.crypto.util.Pack;

public class SHA1Digest extends GeneralDigest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.406 -0400", hash_original_field = "106530DC42BAA21C67F8A3AF4D7FD9E1", hash_generated_field = "A20F40A5A8396B664558E10A31EADBF9")

    private int H1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.406 -0400", hash_original_field = "CA2BF3F6B7E18A508253E9521510A4B5", hash_generated_field = "5D98AFA23A2DDA6581A809AACADB99CD")

    private int H2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.406 -0400", hash_original_field = "B14763210C3AB7284E9CBE731D7DC2A5", hash_generated_field = "2FD00213764EF55752DFCD6B7F5728A6")

    private int H3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.406 -0400", hash_original_field = "6B57370BA89BD88A2D6D819D65F6007A", hash_generated_field = "9E56BF920F4B712E7DB21A0B9EF6F5AF")

    private int H4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.406 -0400", hash_original_field = "830652084DDA69B6B957E2C3A7BD9B18", hash_generated_field = "844FC835FC16FD7D12D2795226E03FEC")

    private int H5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.406 -0400", hash_original_field = "DC2B48BC72CDA0D3F5D0E82131CE153D", hash_generated_field = "8F6FFE924E27CCB7C5DC0F1AC2F650D7")

    private int[] X = new int[80];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.406 -0400", hash_original_field = "C5A8521A972D9AB2588ADF57317C8D4B", hash_generated_field = "D14E80AF1F9317982664F9E415590C80")

    private int xOff;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.406 -0400", hash_original_method = "1DF8B488961A33FC47935CC7CCD682F9", hash_generated_method = "5BEBE9232FDB549FC09A55F3A228E9E2")
    public  SHA1Digest() {
        reset();
        // ---------- Original Method ----------
        //reset();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.407 -0400", hash_original_method = "2658789ECEB2A700883676C5815F56AD", hash_generated_method = "7057FD241BF30991DA8810797C3FC58B")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.407 -0400", hash_original_method = "A93F195BA36C5C6DC02ECFC655EFA07D", hash_generated_method = "C2FDC7102CEC8B906AD10A2263B0F392")
    public String getAlgorithmName() {
String var1E1AC6D31B058D162EAB78A22C4FBDE6_1642480044 =         "SHA-1";
        var1E1AC6D31B058D162EAB78A22C4FBDE6_1642480044.addTaint(taint);
        return var1E1AC6D31B058D162EAB78A22C4FBDE6_1642480044;
        // ---------- Original Method ----------
        //return "SHA-1";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.408 -0400", hash_original_method = "3039C1E557EE9A1557E064C50078D361", hash_generated_method = "620F0FB23128108554F36E6DAAFA528B")
    public int getDigestSize() {
        int var4582481E693E9037762BFFA6D99AC172_228481165 = (DIGEST_LENGTH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884275224 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884275224;
        // ---------- Original Method ----------
        //return DIGEST_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.408 -0400", hash_original_method = "54433F6F6E3BCA59AD49A11DE4A21224", hash_generated_method = "29503015AD4EFA8217936FFFB1E2D1FF")
    protected void processWord(
        byte[]  in,
        int     inOff) {
        addTaint(inOff);
        addTaint(in[0]);
        int n = in[  inOff] << 24;
        n |= (in[++inOff] & 0xff) << 16;
        n |= (in[++inOff] & 0xff) << 8;
        n |= (in[++inOff] & 0xff);
        X[xOff] = n;
        if(++xOff == 16)        
        {
            processBlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.410 -0400", hash_original_method = "E48925D533DC79A9930A6F42B92C0F9E", hash_generated_method = "93CAFE7A83556ACFEC7AA716CD36A091")
    protected void processLength(
        long    bitLength) {
        if(xOff > 14)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.411 -0400", hash_original_method = "7A3A19F87647349D75F24CB81F80AF7C", hash_generated_method = "CBD5D0A51FA17FEF02A0D499A6149020")
    public int doFinal(
        byte[]  out,
        int     outOff) {
        addTaint(outOff);
        addTaint(out[0]);
        finish();
        Pack.intToBigEndian(H1, out, outOff);
        Pack.intToBigEndian(H2, out, outOff + 4);
        Pack.intToBigEndian(H3, out, outOff + 8);
        Pack.intToBigEndian(H4, out, outOff + 12);
        Pack.intToBigEndian(H5, out, outOff + 16);
        reset();
        int var4582481E693E9037762BFFA6D99AC172_1802605900 = (DIGEST_LENGTH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932142906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932142906;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.412 -0400", hash_original_method = "0BD8B4210E063DA673A9D4D2CF1851E6", hash_generated_method = "661B19412C482D97794CD86078C6E2FB")
    public void reset() {
        super.reset();
        H1 = 0x67452301;
        H2 = 0xefcdab89;
        H3 = 0x98badcfe;
        H4 = 0x10325476;
        H5 = 0xc3d2e1f0;
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
        //H5 = 0xc3d2e1f0;
        //xOff = 0;
        //for (int i = 0; i != X.length; i++)
        //{
            //X[i] = 0;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.412 -0400", hash_original_method = "56B08AF140AAB579ED6513720D1D076E", hash_generated_method = "C7A42DB6CBCA8CD1ABFC8612E0EAFFD7")
    private int f(
        int    u,
        int    v,
        int    w) {
        addTaint(w);
        addTaint(v);
        addTaint(u);
        int var2487C51D3865899CC68D9844942F1A98_1766120816 = (((u & v) | ((~u) & w)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833810212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833810212;
        // ---------- Original Method ----------
        //return ((u & v) | ((~u) & w));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.412 -0400", hash_original_method = "D49E57B066D19086A0B27FD85ECFCAA8", hash_generated_method = "CFE5B84420A42E03F72A6D91DB10D1E4")
    private int h(
        int    u,
        int    v,
        int    w) {
        addTaint(w);
        addTaint(v);
        addTaint(u);
        int var34210A5656A51D318801037134EA4008_189850309 = ((u ^ v ^ w));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418864967 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418864967;
        // ---------- Original Method ----------
        //return (u ^ v ^ w);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.413 -0400", hash_original_method = "1EBC13F1810260C1F73348183BDA0BFB", hash_generated_method = "A3E4114E17C896636A598A346D52653F")
    private int g(
        int    u,
        int    v,
        int    w) {
        addTaint(w);
        addTaint(v);
        addTaint(u);
        int var279DD88AA3FA09DA950BC3D1A8E4846A_1619168868 = (((u & v) | (u & w) | (v & w)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214085199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214085199;
        // ---------- Original Method ----------
        //return ((u & v) | (u & w) | (v & w));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.420 -0400", hash_original_method = "9525843836346F2F7CCC2D59A953FC80", hash_generated_method = "5208E780E7CAFED87B904408C16A445C")
    protected void processBlock() {
for(int i = 16;i < 80;i++)
        {
            int t = X[i - 3] ^ X[i - 8] ^ X[i - 14] ^ X[i - 16];
            X[i] = t << 1 | t >>> 31;
        } //End block
        int A = H1;
        int B = H2;
        int C = H3;
        int D = H4;
        int E = H5;
        int idx = 0;
for(int j = 0;j < 4;j++)
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
for(int j = 0;j < 4;j++)
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
for(int j = 0;j < 4;j++)
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
for(int j = 0;j <= 3;j++)
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
        H1 += A;
        H2 += B;
        H3 += C;
        H4 += D;
        H5 += E;
        xOff = 0;
for(int i = 0;i < 16;i++)
        {
            X[i] = 0;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.421 -0400", hash_original_field = "0CEAA24F7308BBA7736880F7C7E9504B", hash_generated_field = "7C0B37D298D1C343E182281986721D96")

    private static final int DIGEST_LENGTH = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.421 -0400", hash_original_field = "DCA34784C348FCFCA55FFB8F9EA2372E", hash_generated_field = "4927017C46155A010BA792662D11A474")

    private static final int Y1 = 0x5a827999;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.421 -0400", hash_original_field = "51C04E8C673712A69AEFB490FB025010", hash_generated_field = "C744DD5CEF511258B48C71878864EB9E")

    private static final int Y2 = 0x6ed9eba1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.421 -0400", hash_original_field = "1CA87970FFB9AECDE86792AAAA385FF6", hash_generated_field = "DB147300B59B193A3D9DEF37CDE8A07F")

    private static final int Y3 = 0x8f1bbcdc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.421 -0400", hash_original_field = "28F53FD1C4B51EEC66AB8CB0C8C2AA70", hash_generated_field = "94BEE5D2C42B05F85DA6FB13C0C10E95")

    private static final int Y4 = 0xca62c1d6;
}

