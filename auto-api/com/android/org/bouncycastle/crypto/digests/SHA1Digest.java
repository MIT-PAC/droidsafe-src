package com.android.org.bouncycastle.crypto.digests;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.org.bouncycastle.crypto.util.Pack;

public class SHA1Digest extends GeneralDigest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.789 -0400", hash_original_field = "106530DC42BAA21C67F8A3AF4D7FD9E1", hash_generated_field = "A20F40A5A8396B664558E10A31EADBF9")

    private int H1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.802 -0400", hash_original_field = "CA2BF3F6B7E18A508253E9521510A4B5", hash_generated_field = "5D98AFA23A2DDA6581A809AACADB99CD")

    private int H2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.802 -0400", hash_original_field = "B14763210C3AB7284E9CBE731D7DC2A5", hash_generated_field = "2FD00213764EF55752DFCD6B7F5728A6")

    private int H3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.803 -0400", hash_original_field = "6B57370BA89BD88A2D6D819D65F6007A", hash_generated_field = "9E56BF920F4B712E7DB21A0B9EF6F5AF")

    private int H4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.803 -0400", hash_original_field = "830652084DDA69B6B957E2C3A7BD9B18", hash_generated_field = "844FC835FC16FD7D12D2795226E03FEC")

    private int H5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.804 -0400", hash_original_field = "DC2B48BC72CDA0D3F5D0E82131CE153D", hash_generated_field = "8F6FFE924E27CCB7C5DC0F1AC2F650D7")

    private int[] X = new int[80];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.805 -0400", hash_original_field = "C5A8521A972D9AB2588ADF57317C8D4B", hash_generated_field = "D14E80AF1F9317982664F9E415590C80")

    private int xOff;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.808 -0400", hash_original_method = "1DF8B488961A33FC47935CC7CCD682F9", hash_generated_method = "5BEBE9232FDB549FC09A55F3A228E9E2")
    public  SHA1Digest() {
        reset();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.821 -0400", hash_original_method = "2658789ECEB2A700883676C5815F56AD", hash_generated_method = "7057FD241BF30991DA8810797C3FC58B")
    public  SHA1Digest(SHA1Digest t) {
        super(t);
        H1 = t.H1;
        H2 = t.H2;
        H3 = t.H3;
        H4 = t.H4;
        H5 = t.H5;
        System.arraycopy(t.X, 0, X, 0, t.X.length);
        xOff = t.xOff;
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.824 -0400", hash_original_method = "A93F195BA36C5C6DC02ECFC655EFA07D", hash_generated_method = "9699BF59CF51C60B23EC9EFE156D7EB4")
    public String getAlgorithmName() {
        String varB4EAC82CA7396A68D541C85D26508E83_691139264 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_691139264 = "SHA-1";
        varB4EAC82CA7396A68D541C85D26508E83_691139264.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_691139264;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.826 -0400", hash_original_method = "3039C1E557EE9A1557E064C50078D361", hash_generated_method = "C7A02400B49163E1D3B0494B871811BD")
    public int getDigestSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113110315 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113110315;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.834 -0400", hash_original_method = "54433F6F6E3BCA59AD49A11DE4A21224", hash_generated_method = "E22DC88BD70ADBE3D285DB8E03E981DE")
    protected void processWord(
        byte[]  in,
        int     inOff) {
        int n = in[  inOff] << 24;
        n |= (in[++inOff] & 0xff) << 16;
        n |= (in[++inOff] & 0xff) << 8;
        n |= (in[++inOff] & 0xff);
        X[xOff] = n;
        {
            processBlock();
        } 
        addTaint(in[0]);
        addTaint(inOff);
        
        
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.838 -0400", hash_original_method = "E48925D533DC79A9930A6F42B92C0F9E", hash_generated_method = "328DE703BF93274E67C5AB9A832B3D85")
    protected void processLength(
        long    bitLength) {
        {
            processBlock();
        } 
        X[14] = (int)(bitLength >>> 32);
        X[15] = (int)(bitLength & 0xffffffff);
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.843 -0400", hash_original_method = "7A3A19F87647349D75F24CB81F80AF7C", hash_generated_method = "09FE995F05C870855290D16270CD5C3E")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522974593 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522974593;
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.850 -0400", hash_original_method = "0BD8B4210E063DA673A9D4D2CF1851E6", hash_generated_method = "6E4BF35C87FB6E69931DEE93CDA81108")
    public void reset() {
        super.reset();
        H1 = 0x67452301;
        H2 = 0xefcdab89;
        H3 = 0x98badcfe;
        H4 = 0x10325476;
        H5 = 0xc3d2e1f0;
        xOff = 0;
        {
            int i = 0;
            {
                X[i] = 0;
            } 
        } 
        
        
        
        
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.854 -0400", hash_original_method = "56B08AF140AAB579ED6513720D1D076E", hash_generated_method = "C1FE0E324E92A164E10D4A3165963D8C")
    private int f(
        int    u,
        int    v,
        int    w) {
        addTaint(u);
        addTaint(v);
        addTaint(w);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249121229 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249121229;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.856 -0400", hash_original_method = "D49E57B066D19086A0B27FD85ECFCAA8", hash_generated_method = "432075AC4A1815EEE4766E9824EE931D")
    private int h(
        int    u,
        int    v,
        int    w) {
        addTaint(u);
        addTaint(v);
        addTaint(w);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948024858 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948024858;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.857 -0400", hash_original_method = "1EBC13F1810260C1F73348183BDA0BFB", hash_generated_method = "B6BA259FADE57BDBFA22919920729E99")
    private int g(
        int    u,
        int    v,
        int    w) {
        addTaint(u);
        addTaint(v);
        addTaint(w);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9047603 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9047603;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.921 -0400", hash_original_method = "9525843836346F2F7CCC2D59A953FC80", hash_generated_method = "83A79CD4129F86820E6DC25E62DFF972")
    protected void processBlock() {
        {
            int i = 16;
            {
                int t = X[i - 3] ^ X[i - 8] ^ X[i - 14] ^ X[i - 16];
                X[i] = t << 1 | t >>> 31;
            } 
        } 
        int A = H1;
        int B = H2;
        int C = H3;
        int D = H4;
        int E = H5;
        int idx = 0;
        {
            int j = 0;
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
            } 
        } 
        {
            int j = 0;
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
            } 
        } 
        {
            int j = 0;
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
            } 
        } 
        {
            int j = 0;
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
            } 
        } 
        H1 += A;
        H2 += B;
        H3 += C;
        H4 += D;
        H5 += E;
        xOff = 0;
        {
            int i = 0;
            {
                X[i] = 0;
            } 
        } 
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.927 -0400", hash_original_field = "0CEAA24F7308BBA7736880F7C7E9504B", hash_generated_field = "7C0B37D298D1C343E182281986721D96")

    private static final int DIGEST_LENGTH = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.927 -0400", hash_original_field = "DCA34784C348FCFCA55FFB8F9EA2372E", hash_generated_field = "4927017C46155A010BA792662D11A474")

    private static final int Y1 = 0x5a827999;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.928 -0400", hash_original_field = "51C04E8C673712A69AEFB490FB025010", hash_generated_field = "C744DD5CEF511258B48C71878864EB9E")

    private static final int Y2 = 0x6ed9eba1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.929 -0400", hash_original_field = "1CA87970FFB9AECDE86792AAAA385FF6", hash_generated_field = "DB147300B59B193A3D9DEF37CDE8A07F")

    private static final int Y3 = 0x8f1bbcdc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:43:17.929 -0400", hash_original_field = "28F53FD1C4B51EEC66AB8CB0C8C2AA70", hash_generated_field = "94BEE5D2C42B05F85DA6FB13C0C10E95")

    private static final int Y4 = 0xca62c1d6;
}

