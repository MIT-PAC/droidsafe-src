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


package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.asn1.x9.X9IntegerConverter;

public abstract class ECPoint {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.169 -0500", hash_original_field = "F357BA3E591BD4D6DB34B6CC355FDE3B", hash_generated_field = "F6B8D48C5F5A761E5DB11D930C790FFE")

    private static X9IntegerConverter converter = new X9IntegerConverter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.156 -0500", hash_original_field = "704A3581F062D90BBFC67E94998B89B2", hash_generated_field = "704A3581F062D90BBFC67E94998B89B2")

    ECCurve        curve;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.158 -0500", hash_original_field = "4962267CB3409346474982F669EDC96A", hash_generated_field = "4962267CB3409346474982F669EDC96A")

    ECFieldElement x;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.160 -0500", hash_original_field = "8FD25F34A4263F01B1FBD2F22B2F99BF", hash_generated_field = "8FD25F34A4263F01B1FBD2F22B2F99BF")

    ECFieldElement y;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.162 -0500", hash_original_field = "FE461DF1DAA1B11668B50BA700384774", hash_generated_field = "7FD389F38A41EB1BAE8714CB05D998E3")

    protected boolean withCompression;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.164 -0500", hash_original_field = "0A0491BA2D899FECF8FE9A008DC4471C", hash_generated_field = "C1F508A0F6FEA833DEEAC7A7B323D761")

    protected ECMultiplier multiplier = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.167 -0500", hash_original_field = "083C3E196756DAA29DEDCBA6B5437F30", hash_generated_field = "84CF639EBFFD87F3AC15C9EF1E1AAF42")

    protected PreCompInfo preCompInfo = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.172 -0500", hash_original_method = "5BA77B5B0277E538D25ED5D9A027BA25", hash_generated_method = "442A23BD27FB6002E411724ECB6A05FE")
    
protected ECPoint(ECCurve curve, ECFieldElement x, ECFieldElement y)
    {
        this.curve = curve;
        this.x = x;
        this.y = y;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.174 -0500", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "B9031E139E03D127788DF39899FDE161")
    
public ECCurve getCurve()
    {
        return curve;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.176 -0500", hash_original_method = "C7C8D965D2F53EB7BBE8F50406AF2883", hash_generated_method = "D18C92904425D229E3E14C0318D2C96C")
    
public ECFieldElement getX()
    {
        return x;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.178 -0500", hash_original_method = "B5FEFF99DC806D61F0BCF9BC7ACEB9BA", hash_generated_method = "58053472D47572B430F7EB1080F0351D")
    
public ECFieldElement getY()
    {
        return y;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.180 -0500", hash_original_method = "B09C1F46CE24A0176C4C3F4348C76697", hash_generated_method = "1A398EBF75CEEA930D5434001089D640")
    
public boolean isInfinity()
    {
        return x == null && y == null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.182 -0500", hash_original_method = "47BFB55B0C4A3BF2B8623783D9C43540", hash_generated_method = "306F5E560182FD6A964F17B153C684CB")
    
public boolean isCompressed()
    {
        return withCompression;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.185 -0500", hash_original_method = "8BF915B7848C2883598F0B5C0E5B1EC3", hash_generated_method = "B1CF18F38474C7B1300F51346353AD68")
    
public boolean equals(
        Object  other)
    {
        if (other == this)
        {
            return true;
        }

        if (!(other instanceof ECPoint))
        {
            return false;
        }

        ECPoint o = (ECPoint)other;

        if (this.isInfinity())
        {
            return o.isInfinity();
        }

        return x.equals(o.x) && y.equals(o.y);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.187 -0500", hash_original_method = "50EB0D4EE4BADC10EDE9CC4D5C9244FF", hash_generated_method = "2A84500AF5522BA453AA1FD2D5457EB0")
    
public int hashCode()
    {
        if (this.isInfinity())
        {
            return 0;
        }
        
        return x.hashCode() ^ y.hashCode();
    }

//    /**
//     * Mainly for testing. Explicitly set the <code>ECMultiplier</code>.
//     * @param multiplier The <code>ECMultiplier</code> to be used to multiply
//     * this <code>ECPoint</code>.
//     */
//    public void setECMultiplier(ECMultiplier multiplier)
//    {
//        this.multiplier = multiplier;
//    }

    /**
     * Sets the <code>PreCompInfo</code>. Used by <code>ECMultiplier</code>s
     * to save the precomputation for this <code>ECPoint</code> to store the
     * precomputation result for use by subsequent multiplication.
     * @param preCompInfo The values precomputed by the
     * <code>ECMultiplier</code>.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.189 -0500", hash_original_method = "3CED2898CE1D9F7EEE71D4F4E6298B52", hash_generated_method = "3CED2898CE1D9F7EEE71D4F4E6298B52")
    
void setPreCompInfo(PreCompInfo preCompInfo)
    {
        this.preCompInfo = preCompInfo;
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.192 -0500", hash_original_method = "506507D68F2DEBC7A73E26D74C8EC354", hash_generated_method = "8AD98EEA7FB40BE802733C14B55B9E93")
    
public abstract byte[] getEncoded();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.194 -0500", hash_original_method = "766446EEB6B09A1F70FAEF2B46A36784", hash_generated_method = "7BD5C118F2665F04A69154179ADD9CF0")
    
public abstract ECPoint add(ECPoint b);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.197 -0500", hash_original_method = "CDDBDFC652002828E6A5B3B5BFADA778", hash_generated_method = "044F6C9B2C83B745AA7B855CD68C2D9A")
    
public abstract ECPoint subtract(ECPoint b);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.199 -0500", hash_original_method = "B608ED29DBF5C8F3BA0748B7BC005701", hash_generated_method = "86845A2F5485AA3B7BC0F5940C14AF21")
    
public abstract ECPoint negate();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.201 -0500", hash_original_method = "A4E675BA65DA5DDB4851852EE539A9CF", hash_generated_method = "0FA8F61AE12CD44BBED274D7ED4B88A6")
    
public abstract ECPoint twice();

    /**
     * Sets the default <code>ECMultiplier</code>, unless already set. 
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.203 -0500", hash_original_method = "CFD8CCAA4A8EFD7B41616F74559C84F4", hash_generated_method = "2FA1F3E9D388BA935572AE9E822542C4")
    
synchronized void assertECMultiplier()
    {
        if (this.multiplier == null)
        {
            this.multiplier = new FpNafMultiplier();
        }
    }
    
    public static class Fp extends ECPoint {
        
        /**
         * Create a point which encodes with point compression.
         * 
         * @param curve the curve to use
         * @param x affine x co-ordinate
         * @param y affine y co-ordinate
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.208 -0500", hash_original_method = "C218E406154D6A68AEA278E34615CF99", hash_generated_method = "405064589D6E9061E69105A575C7A1FE")
        
public Fp(ECCurve curve, ECFieldElement x, ECFieldElement y)
        {
            this(curve, x, y, false);
        }

        /**
         * Create a point that encodes with or without point compresion.
         * 
         * @param curve the curve to use
         * @param x affine x co-ordinate
         * @param y affine y co-ordinate
         * @param withCompression if true encode with point compression
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.212 -0500", hash_original_method = "DA43573652764E89DCD825DB3FC87547", hash_generated_method = "02C62563D2287CC63313A1D612607F48")
        
public Fp(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression)
        {
            super(curve, x, y);

            if ((x != null && y == null) || (x == null && y != null))
            {
                throw new IllegalArgumentException("Exactly one of the field elements is null");
            }

            this.withCompression = withCompression;
        }
         
        /**
         * return the field element encoded with point compression. (S 4.3.6)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.215 -0500", hash_original_method = "122C86DAB9B6EC00B00943741F6C7C43", hash_generated_method = "295A5127F1AE5A4204F31AA4B1452964")
        
public byte[] getEncoded()
        {
            if (this.isInfinity()) 
            {
                return new byte[1];
            }

            int qLength = converter.getByteLength(x);
            
            if (withCompression)
            {
                byte    PC;
    
                if (this.getY().toBigInteger().testBit(0))
                {
                    PC = 0x03;
                }
                else
                {
                    PC = 0x02;
                }
    
                byte[]  X = converter.integerToBytes(this.getX().toBigInteger(), qLength);
                byte[]  PO = new byte[X.length + 1];
    
                PO[0] = PC;
                System.arraycopy(X, 0, PO, 1, X.length);
    
                return PO;
            }
            else
            {
                byte[]  X = converter.integerToBytes(this.getX().toBigInteger(), qLength);
                byte[]  Y = converter.integerToBytes(this.getY().toBigInteger(), qLength);
                byte[]  PO = new byte[X.length + Y.length + 1];
                
                PO[0] = 0x04;
                System.arraycopy(X, 0, PO, 1, X.length);
                System.arraycopy(Y, 0, PO, X.length + 1, Y.length);

                return PO;
            }
        }

        // B.3 pg 62
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.217 -0500", hash_original_method = "95E059CAF9907A74F8544551FF4AF334", hash_generated_method = "CA2A1AD2C7DE0DE720E8868026A16554")
        
public ECPoint add(ECPoint b)
        {
            if (this.isInfinity())
            {
                return b;
            }

            if (b.isInfinity())
            {
                return this;
            }

            // Check if b = this or b = -this
            if (this.x.equals(b.x))
            {
                if (this.y.equals(b.y))
                {
                    // this = b, i.e. this must be doubled
                    return this.twice();
                }

                // this = -b, i.e. the result is the point at infinity
                return this.curve.getInfinity();
            }

            ECFieldElement gamma = b.y.subtract(this.y).divide(b.x.subtract(this.x));

            ECFieldElement x3 = gamma.square().subtract(this.x).subtract(b.x);
            ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);

            return new ECPoint.Fp(curve, x3, y3);
        }

        // B.3 pg 62
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.220 -0500", hash_original_method = "814EC5F0BAC3EF42CB4061AB2E0CCD5F", hash_generated_method = "C1403814F365A55227AC438FF8C63B25")
        
public ECPoint twice()
        {
            if (this.isInfinity())
            {
                // Twice identity element (point at infinity) is identity
                return this;
            }

            if (this.y.toBigInteger().signum() == 0) 
            {
                // if y1 == 0, then (x1, y1) == (x1, -y1)
                // and hence this = -this and thus 2(x1, y1) == infinity
                return this.curve.getInfinity();
            }

            ECFieldElement TWO = this.curve.fromBigInteger(BigInteger.valueOf(2));
            ECFieldElement THREE = this.curve.fromBigInteger(BigInteger.valueOf(3));
            ECFieldElement gamma = this.x.square().multiply(THREE).add(curve.a).divide(y.multiply(TWO));

            ECFieldElement x3 = gamma.square().subtract(this.x.multiply(TWO));
            ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
                
            return new ECPoint.Fp(curve, x3, y3, this.withCompression);
        }

        // D.3.2 pg 102 (see Note:)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.223 -0500", hash_original_method = "6CF29EA69F961CE922C32B4E8E2284E5", hash_generated_method = "CB0467CADE1C0FFA0C4D19851AA8DA17")
        
public ECPoint subtract(ECPoint b)
        {
            if (b.isInfinity())
            {
                return this;
            }

            // Add -b
            return add(b.negate());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.225 -0500", hash_original_method = "18C2403460E252970B56CE0DE1D343AC", hash_generated_method = "16D7DB5C4BBBD996CDBF0E64830DC9CC")
        
public ECPoint negate()
        {
            return new ECPoint.Fp(curve, this.x, this.y.negate(), this.withCompression);
        }

        /**
         * Sets the default <code>ECMultiplier</code>, unless already set. 
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.228 -0500", hash_original_method = "8EF68E9821BB7A65A39BDB5C806DAEDA", hash_generated_method = "E8FC3568DF4F041FADF2DCC54BD1D6E0")
        
synchronized void assertECMultiplier()
        {
            if (this.multiplier == null)
            {
                this.multiplier = new WNafMultiplier();
            }
        }
        
    }
    
    public static class F2m extends ECPoint {

        /**
         * Check, if two <code>ECPoint</code>s can be added or subtracted.
         * @param a The first <code>ECPoint</code> to check.
         * @param b The second <code>ECPoint</code> to check.
         * @throws IllegalArgumentException if <code>a</code> and <code>b</code>
         * cannot be added.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.243 -0500", hash_original_method = "A1999CEAE21C1E2D06F6C5ECE8093E45", hash_generated_method = "BFBA3DCBF1E587F8457EEAF3730E1766")
        
private static void checkPoints(ECPoint a, ECPoint b)
        {
            // Check, if points are on the same curve
            if (!(a.curve.equals(b.curve)))
            {
                throw new IllegalArgumentException("Only points on the same "
                        + "curve can be added or subtracted");
            }

//            ECFieldElement.F2m.checkFieldElements(a.x, b.x);
        }
        /**
         * @param curve base curve
         * @param x x point
         * @param y y point
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.234 -0500", hash_original_method = "73BD63756191E5AAFB19346FBE556EB3", hash_generated_method = "A7FE56947A78B07C10E1635E97CAD5D1")
        
public F2m(ECCurve curve, ECFieldElement x, ECFieldElement y)
        {
            this(curve, x, y, false);
        }
        
        /**
         * @param curve base curve
         * @param x x point
         * @param y y point
         * @param withCompression true if encode with point compression.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.237 -0500", hash_original_method = "4610FCAEB1DDBBF845E95D34129A59A7", hash_generated_method = "DDDE1BC72A9ECB3AED209B87FF722A0E")
        
public F2m(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression)
        {
            super(curve, x, y);

            if ((x != null && y == null) || (x == null && y != null))
            {
                throw new IllegalArgumentException("Exactly one of the field elements is null");
            }
            
            if (x != null)
            {
                // Check if x and y are elements of the same field
                ECFieldElement.F2m.checkFieldElements(this.x, this.y);
    
                // Check if x and a are elements of the same field
                if (curve != null)
                {
                    ECFieldElement.F2m.checkFieldElements(this.x, this.curve.getA());
                }
            }
            
            this.withCompression = withCompression;
        }

        /* (non-Javadoc)
         * @see org.bouncycastle.math.ec.ECPoint#getEncoded()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.240 -0500", hash_original_method = "91DE6710B35AB1954917AAE97889BD70", hash_generated_method = "DE12053D8632847088BF3BDB6B95F432")
        
public byte[] getEncoded()
        {
            if (this.isInfinity()) 
            {
                return new byte[1];
            }

            int byteCount = converter.getByteLength(this.x);
            byte[] X = converter.integerToBytes(this.getX().toBigInteger(), byteCount);
            byte[] PO;

            if (withCompression)
            {
                // See X9.62 4.3.6 and 4.2.2
                PO = new byte[byteCount + 1];

                PO[0] = 0x02;
                // X9.62 4.2.2 and 4.3.6:
                // if x = 0 then ypTilde := 0, else ypTilde is the rightmost
                // bit of y * x^(-1)
                // if ypTilde = 0, then PC := 02, else PC := 03
                // Note: PC === PO[0]
                if (!(this.getX().toBigInteger().equals(ECConstants.ZERO)))
                {
                    if (this.getY().multiply(this.getX().invert())
                            .toBigInteger().testBit(0))
                    {
                        // ypTilde = 1, hence PC = 03
                        PO[0] = 0x03;
                    }
                }

                System.arraycopy(X, 0, PO, 1, byteCount);
            }
            else
            {
                byte[] Y = converter.integerToBytes(this.getY().toBigInteger(), byteCount);
    
                PO = new byte[byteCount + byteCount + 1];
    
                PO[0] = 0x04;
                System.arraycopy(X, 0, PO, 1, byteCount);
                System.arraycopy(Y, 0, PO, byteCount + 1, byteCount);    
            }

            return PO;
        }

        /* (non-Javadoc)
         * @see org.bouncycastle.math.ec.ECPoint#add(org.bouncycastle.math.ec.ECPoint)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.245 -0500", hash_original_method = "CE1FEB0E79091A4CCB0243E0EA7A28CB", hash_generated_method = "21828ACF3F7B4D9FEA0E7A8DD3C66AC8")
        
public ECPoint add(ECPoint b)
        {
            checkPoints(this, b);
            return addSimple((ECPoint.F2m)b);
        }

        /**
         * Adds another <code>ECPoints.F2m</code> to <code>this</code> without
         * checking if both points are on the same curve. Used by multiplication
         * algorithms, because there all points are a multiple of the same point
         * and hence the checks can be omitted.
         * @param b The other <code>ECPoints.F2m</code> to add to
         * <code>this</code>.
         * @return <code>this + b</code>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.248 -0500", hash_original_method = "230992766041FE2E7B78B40F0E0C1144", hash_generated_method = "ACCCE98C43936BB24AFDC69EFC58711A")
        
public ECPoint.F2m addSimple(ECPoint.F2m b)
        {
            ECPoint.F2m other = b;
            if (this.isInfinity())
            {
                return other;
            }

            if (other.isInfinity())
            {
                return this;
            }

            ECFieldElement.F2m x2 = (ECFieldElement.F2m)other.getX();
            ECFieldElement.F2m y2 = (ECFieldElement.F2m)other.getY();

            // Check if other = this or other = -this
            if (this.x.equals(x2))
            {
                if (this.y.equals(y2))
                {
                    // this = other, i.e. this must be doubled
                    return (ECPoint.F2m)this.twice();
                }

                // this = -other, i.e. the result is the point at infinity
                return (ECPoint.F2m)this.curve.getInfinity();
            }

            ECFieldElement.F2m lambda
                = (ECFieldElement.F2m)(this.y.add(y2)).divide(this.x.add(x2));

            ECFieldElement.F2m x3
                = (ECFieldElement.F2m)lambda.square().add(lambda).add(this.x).add(x2).add(this.curve.getA());

            ECFieldElement.F2m y3
                = (ECFieldElement.F2m)lambda.multiply(this.x.add(x3)).add(x3).add(this.y);

            return new ECPoint.F2m(curve, x3, y3, withCompression);
        }

        /* (non-Javadoc)
         * @see org.bouncycastle.math.ec.ECPoint#subtract(org.bouncycastle.math.ec.ECPoint)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.250 -0500", hash_original_method = "E180EBB5B66B4130D071F14F4EE083E4", hash_generated_method = "C5A75D09F3715F21CE6B100814F96B4A")
        
public ECPoint subtract(ECPoint b)
        {
            checkPoints(this, b);
            return subtractSimple((ECPoint.F2m)b);
        }

        /**
         * Subtracts another <code>ECPoints.F2m</code> from <code>this</code>
         * without checking if both points are on the same curve. Used by
         * multiplication algorithms, because there all points are a multiple
         * of the same point and hence the checks can be omitted.
         * @param b The other <code>ECPoints.F2m</code> to subtract from
         * <code>this</code>.
         * @return <code>this - b</code>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.253 -0500", hash_original_method = "FE873BC192C2EB55E75185601239ED06", hash_generated_method = "A431AC8782EDAD0F027995A8B6FCDEC7")
        
public ECPoint.F2m subtractSimple(ECPoint.F2m b)
        {
            if (b.isInfinity())
            {
                return this;
            }

            // Add -b
            return addSimple((ECPoint.F2m)b.negate());
        }

        /* (non-Javadoc)
         * @see org.bouncycastle.math.ec.ECPoint#twice()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.256 -0500", hash_original_method = "45BA33A6C8448ED0A2617484FF5E8003", hash_generated_method = "DFD12451B958FBC75986554F545690F8")
        
public ECPoint twice()
        {
            if (this.isInfinity()) 
            {
                // Twice identity element (point at infinity) is identity
                return this;
            }

            if (this.x.toBigInteger().signum() == 0) 
            {
                // if x1 == 0, then (x1, y1) == (x1, x1 + y1)
                // and hence this = -this and thus 2(x1, y1) == infinity
                return this.curve.getInfinity();
            }

            ECFieldElement.F2m lambda
                = (ECFieldElement.F2m)this.x.add(this.y.divide(this.x));

            ECFieldElement.F2m x3
                = (ECFieldElement.F2m)lambda.square().add(lambda).
                    add(this.curve.getA());

            ECFieldElement ONE = this.curve.fromBigInteger(ECConstants.ONE);
            ECFieldElement.F2m y3
                = (ECFieldElement.F2m)this.x.square().add(
                    x3.multiply(lambda.add(ONE)));

            return new ECPoint.F2m(this.curve, x3, y3, withCompression);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.258 -0500", hash_original_method = "55BA3FB66363791B05BA3007051689C2", hash_generated_method = "C2A9BA943D24F55FF8FE62B02BD3D0A7")
        
public ECPoint negate()
        {
            return new ECPoint.F2m(curve, this.getX(), this.getY().add(this.getX()), withCompression);
        }

        /**
         * Sets the appropriate <code>ECMultiplier</code>, unless already set. 
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.261 -0500", hash_original_method = "B01B67DF3607CCDD35FFA0674C4BFE3B", hash_generated_method = "A0C94A7D3EF464ECE0B33012066C1ED3")
        
synchronized void assertECMultiplier()
        {
            if (this.multiplier == null)
            {
                if (((ECCurve.F2m)this.curve).isKoblitz())
                {
                    this.multiplier = new WTauNafMultiplier();
                }
                else
                {
                    this.multiplier = new WNafMultiplier();
                }
            }
        }
        
    }

    /**
     * Multiplies this <code>ECPoint</code> by the given number.
     * @param k The multiplicator.
     * @return <code>k * this</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:38.205 -0500", hash_original_method = "0A712A2425F19F0711671167931DA051", hash_generated_method = "9BDC8D6997778AA3F1D3DB8D264B28C0")
    
public ECPoint multiply(BigInteger k)
    {
        if (k.signum() < 0)
        {
            throw new IllegalArgumentException("The multiplicator cannot be negative");
        }

        if (this.isInfinity())
        {
            return this;
        }

        if (k.signum() == 0)
        {
            return this.curve.getInfinity();
        }

        assertECMultiplier();
        return this.multiplier.multiply(this, k, preCompInfo);
    }
}

