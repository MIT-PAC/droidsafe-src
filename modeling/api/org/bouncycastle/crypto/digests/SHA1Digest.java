/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.crypto.digests;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.crypto.util.Pack;

public class SHA1Digest extends GeneralDigest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.698 -0500", hash_original_field = "9301F8BE56680C2B760E8B6165DCF050", hash_generated_field = "7C0B37D298D1C343E182281986721D96")

    private static final int    DIGEST_LENGTH = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.727 -0500", hash_original_field = "E78CF4EADB66159ACD746E92AA750612", hash_generated_field = "F3A5FE8CC8D3F2AA5B89624201E14D93")

    // Additive constants
    //
    private static final int    Y1 = 0x5a827999;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.729 -0500", hash_original_field = "FF8D946D02B1A18D269308746448069C", hash_generated_field = "C744DD5CEF511258B48C71878864EB9E")

    private static final int    Y2 = 0x6ed9eba1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.732 -0500", hash_original_field = "B74F82E67FE08E3E3D33A5749E470CDD", hash_generated_field = "DB147300B59B193A3D9DEF37CDE8A07F")

    private static final int    Y3 = 0x8f1bbcdc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.734 -0500", hash_original_field = "7776A01DE165A928D044EB2DE9881540", hash_generated_field = "94BEE5D2C42B05F85DA6FB13C0C10E95")

    private static final int    Y4 = 0xca62c1d6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.944 -0400", hash_original_field = "106530DC42BAA21C67F8A3AF4D7FD9E1", hash_generated_field = "A20F40A5A8396B664558E10A31EADBF9")

    private int H1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.944 -0400", hash_original_field = "CA2BF3F6B7E18A508253E9521510A4B5", hash_generated_field = "5D98AFA23A2DDA6581A809AACADB99CD")

    private int H2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.944 -0400", hash_original_field = "B14763210C3AB7284E9CBE731D7DC2A5", hash_generated_field = "2FD00213764EF55752DFCD6B7F5728A6")

    private int H3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.944 -0400", hash_original_field = "6B57370BA89BD88A2D6D819D65F6007A", hash_generated_field = "9E56BF920F4B712E7DB21A0B9EF6F5AF")

    private int H4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.944 -0400", hash_original_field = "830652084DDA69B6B957E2C3A7BD9B18", hash_generated_field = "844FC835FC16FD7D12D2795226E03FEC")

    private int H5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.703 -0500", hash_original_field = "36DF1BB1AB0A0C3AB50B4055E588E1D7", hash_generated_field = "8F6FFE924E27CCB7C5DC0F1AC2F650D7")

    private int[]   X = new int[80];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.705 -0500", hash_original_field = "B7445263BE5AA36D026E05FA52197EA0", hash_generated_field = "D14E80AF1F9317982664F9E415590C80")

    private int     xOff;

    /**
     * Standard constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.708 -0500", hash_original_method = "1DF8B488961A33FC47935CC7CCD682F9", hash_generated_method = "D8CCC0990960E028FDB6580339F29524")
    
public SHA1Digest()
    {
        reset();
    }

    /**
     * Copy constructor.  This will copy the state of the provided
     * message digest.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.710 -0500", hash_original_method = "2658789ECEB2A700883676C5815F56AD", hash_generated_method = "4DB32607D6D42D2130FC7C45474A176D")
    
public SHA1Digest(SHA1Digest t)
    {
        super(t);

        H1 = t.H1;
        H2 = t.H2;
        H3 = t.H3;
        H4 = t.H4;
        H5 = t.H5;

        System.arraycopy(t.X, 0, X, 0, t.X.length);
        xOff = t.xOff;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.712 -0500", hash_original_method = "A93F195BA36C5C6DC02ECFC655EFA07D", hash_generated_method = "AB501A8FA52838897DF120CE1B8B8EE2")
    
public String getAlgorithmName()
    {
        return "SHA-1";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.714 -0500", hash_original_method = "3039C1E557EE9A1557E064C50078D361", hash_generated_method = "7FB03A29E68971CC5701D6DA0F67A19C")
    
public int getDigestSize()
    {
        return DIGEST_LENGTH;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.717 -0500", hash_original_method = "54433F6F6E3BCA59AD49A11DE4A21224", hash_generated_method = "38DE04120107F9C1420CBAAF12800E92")
    
protected void processWord(
        byte[]  in,
        int     inOff)
    {
        // Note: Inlined for performance
//        X[xOff] = Pack.bigEndianToInt(in, inOff);
        int n = in[  inOff] << 24;
        n |= (in[++inOff] & 0xff) << 16;
        n |= (in[++inOff] & 0xff) << 8;
        n |= (in[++inOff] & 0xff);
        X[xOff] = n;

        if (++xOff == 16)
        {
            processBlock();
        }        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.719 -0500", hash_original_method = "E48925D533DC79A9930A6F42B92C0F9E", hash_generated_method = "9ECCD02DA51EFB2020A7D5A4F17C07CD")
    
protected void processLength(
        long    bitLength)
    {
        if (xOff > 14)
        {
            processBlock();
        }

        X[14] = (int)(bitLength >>> 32);
        X[15] = (int)(bitLength & 0xffffffff);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.722 -0500", hash_original_method = "7A3A19F87647349D75F24CB81F80AF7C", hash_generated_method = "8F2A54CE6E8843D3EDD329D6635A1897")
    
public int doFinal(
        byte[]  out,
        int     outOff)
    {
        finish();

        Pack.intToBigEndian(H1, out, outOff);
        Pack.intToBigEndian(H2, out, outOff + 4);
        Pack.intToBigEndian(H3, out, outOff + 8);
        Pack.intToBigEndian(H4, out, outOff + 12);
        Pack.intToBigEndian(H5, out, outOff + 16);

        reset();

        return DIGEST_LENGTH;
    }

    /**
     * reset the chaining variables
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.724 -0500", hash_original_method = "0BD8B4210E063DA673A9D4D2CF1851E6", hash_generated_method = "54ABC94F488C001CBD8DF02BC337AE93")
    
public void reset()
    {
        super.reset();

        H1 = 0x67452301;
        H2 = 0xefcdab89;
        H3 = 0x98badcfe;
        H4 = 0x10325476;
        H5 = 0xc3d2e1f0;

        xOff = 0;
        for (int i = 0; i != X.length; i++)
        {
            X[i] = 0;
        }
    }
   
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.736 -0500", hash_original_method = "56B08AF140AAB579ED6513720D1D076E", hash_generated_method = "D73F0AA5C601AC4CF74FED73FDE32BD1")
    
private int f(
        int    u,
        int    v,
        int    w)
    {
        return ((u & v) | ((~u) & w));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.739 -0500", hash_original_method = "D49E57B066D19086A0B27FD85ECFCAA8", hash_generated_method = "3F5EDB6E375354CCAD164045583D64A4")
    
private int h(
        int    u,
        int    v,
        int    w)
    {
        return (u ^ v ^ w);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.741 -0500", hash_original_method = "1EBC13F1810260C1F73348183BDA0BFB", hash_generated_method = "DD042622BEE03CBA2B0147089AE1E6E0")
    
private int g(
        int    u,
        int    v,
        int    w)
    {
        return ((u & v) | (u & w) | (v & w));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:32.747 -0500", hash_original_method = "9525843836346F2F7CCC2D59A953FC80", hash_generated_method = "8F796C6B4EA27981DB1FE60C081818FE")
    
protected void processBlock()
    {
        //
        // expand 16 word block into 80 word block.
        //
        for (int i = 16; i < 80; i++)
        {
            int t = X[i - 3] ^ X[i - 8] ^ X[i - 14] ^ X[i - 16];
            X[i] = t << 1 | t >>> 31;
        }

        //
        // set up working variables.
        //
        int     A = H1;
        int     B = H2;
        int     C = H3;
        int     D = H4;
        int     E = H5;

        //
        // round 1
        //
        int idx = 0;
        
        for (int j = 0; j < 4; j++)
        {
            // E = rotateLeft(A, 5) + f(B, C, D) + E + X[idx++] + Y1
            // B = rotateLeft(B, 30)
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
        
        //
        // round 2
        //
        for (int j = 0; j < 4; j++)
        {
            // E = rotateLeft(A, 5) + h(B, C, D) + E + X[idx++] + Y2
            // B = rotateLeft(B, 30)
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
        
        //
        // round 3
        //
        for (int j = 0; j < 4; j++)
        {
            // E = rotateLeft(A, 5) + g(B, C, D) + E + X[idx++] + Y3
            // B = rotateLeft(B, 30)
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

        //
        // round 4
        //
        for (int j = 0; j <= 3; j++)
        {
            // E = rotateLeft(A, 5) + h(B, C, D) + E + X[idx++] + Y4
            // B = rotateLeft(B, 30)
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

        H1 += A;
        H2 += B;
        H3 += C;
        H4 += D;
        H5 += E;

        //
        // reset start of the buffer.
        //
        xOff = 0;
        for (int i = 0; i < 16; i++)
        {
            X[i] = 0;
        }
    }
}

