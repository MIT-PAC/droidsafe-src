package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;




class Tnaf {

    /**
     * Computes the norm of an element <code>&lambda;</code> of
     * <code><b>Z</b>[&tau;]</code>.
     * @param mu The parameter <code>&mu;</code> of the elliptic curve.
     * @param lambda The element <code>&lambda;</code> of
     * <code><b>Z</b>[&tau;]</code>.
     * @return The norm of <code>&lambda;</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.002 -0500", hash_original_method = "A3F4AD10FE1FBABD5486B6D7CD090B7A", hash_generated_method = "866284A0FC5071C1D7B5954B6592A2CD")
    
public static BigInteger norm(final byte mu, ZTauElement lambda)
    {
        BigInteger norm;

        // s1 = u^2
        BigInteger s1 = lambda.u.multiply(lambda.u);

        // s2 = u * v
        BigInteger s2 = lambda.u.multiply(lambda.v);

        // s3 = 2 * v^2
        BigInteger s3 = lambda.v.multiply(lambda.v).shiftLeft(1);

        if (mu == 1)
        {
            norm = s1.add(s2).add(s3);
        }
        else if (mu == -1)
        {
            norm = s1.subtract(s2).add(s3);
        }
        else
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }

        return norm;
    }

    /**
     * Computes the norm of an element <code>&lambda;</code> of
     * <code><b>R</b>[&tau;]</code>, where <code>&lambda; = u + v&tau;</code>
     * and <code>u</code> and <code>u</code> are real numbers (elements of
     * <code><b>R</b></code>). 
     * @param mu The parameter <code>&mu;</code> of the elliptic curve.
     * @param u The real part of the element <code>&lambda;</code> of
     * <code><b>R</b>[&tau;]</code>.
     * @param v The <code>&tau;</code>-adic part of the element
     * <code>&lambda;</code> of <code><b>R</b>[&tau;]</code>.
     * @return The norm of <code>&lambda;</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.005 -0500", hash_original_method = "3713DD7DCA331E2397E6660D223579BE", hash_generated_method = "2E20EDA91E2E0A0AF5A940E0A5099B52")
    
public static SimpleBigDecimal norm(final byte mu, SimpleBigDecimal u,
            SimpleBigDecimal v)
    {
        SimpleBigDecimal norm;

        // s1 = u^2
        SimpleBigDecimal s1 = u.multiply(u);

        // s2 = u * v
        SimpleBigDecimal s2 = u.multiply(v);

        // s3 = 2 * v^2
        SimpleBigDecimal s3 = v.multiply(v).shiftLeft(1);

        if (mu == 1)
        {
            norm = s1.add(s2).add(s3);
        }
        else if (mu == -1)
        {
            norm = s1.subtract(s2).add(s3);
        }
        else
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }

        return norm;
    }

    /**
     * Rounds an element <code>&lambda;</code> of <code><b>R</b>[&tau;]</code>
     * to an element of <code><b>Z</b>[&tau;]</code>, such that their difference
     * has minimal norm. <code>&lambda;</code> is given as
     * <code>&lambda; = &lambda;<sub>0</sub> + &lambda;<sub>1</sub>&tau;</code>.
     * @param lambda0 The component <code>&lambda;<sub>0</sub></code>.
     * @param lambda1 The component <code>&lambda;<sub>1</sub></code>.
     * @param mu The parameter <code>&mu;</code> of the elliptic curve. Must
     * equal 1 or -1.
     * @return The rounded element of <code><b>Z</b>[&tau;]</code>.
     * @throws IllegalArgumentException if <code>lambda0</code> and
     * <code>lambda1</code> do not have same scale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.009 -0500", hash_original_method = "FD3DD036A6C7DDF93DF974FBA106518E", hash_generated_method = "490FBC8002396BC9A6D71F9C763F0C17")
    
public static ZTauElement round(SimpleBigDecimal lambda0,
            SimpleBigDecimal lambda1, byte mu)
    {
        int scale = lambda0.getScale();
        if (lambda1.getScale() != scale)
        {
            throw new IllegalArgumentException("lambda0 and lambda1 do not " +
                    "have same scale");
        }

        if (!((mu == 1) || (mu == -1)))
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }

        BigInteger f0 = lambda0.round();
        BigInteger f1 = lambda1.round();

        SimpleBigDecimal eta0 = lambda0.subtract(f0);
        SimpleBigDecimal eta1 = lambda1.subtract(f1);

        // eta = 2*eta0 + mu*eta1
        SimpleBigDecimal eta = eta0.add(eta0);
        if (mu == 1)
        {
            eta = eta.add(eta1);
        }
        else
        {
            // mu == -1
            eta = eta.subtract(eta1);
        }

        // check1 = eta0 - 3*mu*eta1
        // check2 = eta0 + 4*mu*eta1
        SimpleBigDecimal threeEta1 = eta1.add(eta1).add(eta1);
        SimpleBigDecimal fourEta1 = threeEta1.add(eta1);
        SimpleBigDecimal check1;
        SimpleBigDecimal check2;
        if (mu == 1)
        {
            check1 = eta0.subtract(threeEta1);
            check2 = eta0.add(fourEta1);
        }
        else
        {
            // mu == -1
            check1 = eta0.add(threeEta1);
            check2 = eta0.subtract(fourEta1);
        }

        byte h0 = 0;
        byte h1 = 0;

        // if eta >= 1
        if (eta.compareTo(ECConstants.ONE) >= 0)
        {
            if (check1.compareTo(MINUS_ONE) < 0)
            {
                h1 = mu;
            }
            else
            {
                h0 = 1;
            }
        }
        else
        {
            // eta < 1
            if (check2.compareTo(ECConstants.TWO) >= 0)
            {
                h1 = mu;
            }
        }

        // if eta < -1
        if (eta.compareTo(MINUS_ONE) < 0)
        {
            if (check1.compareTo(ECConstants.ONE) >= 0)
            {
                h1 = (byte)-mu;
            }
            else
            {
                h0 = -1;
            }
        }
        else
        {
            // eta >= -1
            if (check2.compareTo(MINUS_TWO) < 0)
            {
                h1 = (byte)-mu;
            }
        }

        BigInteger q0 = f0.add(BigInteger.valueOf(h0));
        BigInteger q1 = f1.add(BigInteger.valueOf(h1));
        return new ZTauElement(q0, q1);
    }

    /**
     * Approximate division by <code>n</code>. For an integer
     * <code>k</code>, the value <code>&lambda; = s k / n</code> is
     * computed to <code>c</code> bits of accuracy.
     * @param k The parameter <code>k</code>.
     * @param s The curve parameter <code>s<sub>0</sub></code> or
     * <code>s<sub>1</sub></code>.
     * @param vm The Lucas Sequence element <code>V<sub>m</sub></code>.
     * @param a The parameter <code>a</code> of the elliptic curve.
     * @param m The bit length of the finite field
     * <code><b>F</b><sub>m</sub></code>.
     * @param c The number of bits of accuracy, i.e. the scale of the returned
     * <code>SimpleBigDecimal</code>.
     * @return The value <code>&lambda; = s k / n</code> computed to
     * <code>c</code> bits of accuracy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.012 -0500", hash_original_method = "72BC4C8EEC8B936DCFF970785A880F0C", hash_generated_method = "1C27BAF01D2DC6F38A59C65D34552DA5")
    
public static SimpleBigDecimal approximateDivisionByN(BigInteger k,
            BigInteger s, BigInteger vm, byte a, int m, int c)
    {
        int _k = (m + 5)/2 + c;
        BigInteger ns = k.shiftRight(m - _k - 2 + a);

        BigInteger gs = s.multiply(ns);

        BigInteger hs = gs.shiftRight(m);

        BigInteger js = vm.multiply(hs);

        BigInteger gsPlusJs = gs.add(js);
        BigInteger ls = gsPlusJs.shiftRight(_k-c);
        if (gsPlusJs.testBit(_k-c-1))
        {
            // round up
            ls = ls.add(ECConstants.ONE);
        }

        return new SimpleBigDecimal(ls, c);
    }

    /**
     * Computes the <code>&tau;</code>-adic NAF (non-adjacent form) of an
     * element <code>&lambda;</code> of <code><b>Z</b>[&tau;]</code>.
     * @param mu The parameter <code>&mu;</code> of the elliptic curve.
     * @param lambda The element <code>&lambda;</code> of
     * <code><b>Z</b>[&tau;]</code>.
     * @return The <code>&tau;</code>-adic NAF of <code>&lambda;</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.015 -0500", hash_original_method = "963F98A8FDC7B7AF2796AD66CC439076", hash_generated_method = "6FFAEEF21DE26EF3C5E04574282E7986")
    
public static byte[] tauAdicNaf(byte mu, ZTauElement lambda)
    {
        if (!((mu == 1) || (mu == -1)))
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        
        BigInteger norm = norm(mu, lambda);

        // Ceiling of log2 of the norm 
        int log2Norm = norm.bitLength();

        // If length(TNAF) > 30, then length(TNAF) < log2Norm + 3.52
        int maxLength = log2Norm > 30 ? log2Norm + 4 : 34;

        // The array holding the TNAF
        byte[] u = new byte[maxLength];
        int i = 0;

        // The actual length of the TNAF
        int length = 0;

        BigInteger r0 = lambda.u;
        BigInteger r1 = lambda.v;

        while(!((r0.equals(ECConstants.ZERO)) && (r1.equals(ECConstants.ZERO))))
        {
            // If r0 is odd
            if (r0.testBit(0))
            {
                u[i] = (byte) ECConstants.TWO.subtract((r0.subtract(r1.shiftLeft(1))).mod(ECConstants.FOUR)).intValue();

                // r0 = r0 - u[i]
                if (u[i] == 1)
                {
                    r0 = r0.clearBit(0);
                }
                else
                {
                    // u[i] == -1
                    r0 = r0.add(ECConstants.ONE);
                }
                length = i;
            }
            else
            {
                u[i] = 0;
            }

            BigInteger t = r0;
            BigInteger s = r0.shiftRight(1);
            if (mu == 1)
            {
                r0 = r1.add(s);
            }
            else
            {
                // mu == -1
                r0 = r1.subtract(s);
            }

            r1 = t.shiftRight(1).negate();
            i++;
        }

        length++;

        // Reduce the TNAF array to its actual length
        byte[] tnaf = new byte[length];
        System.arraycopy(u, 0, tnaf, 0, length);
        return tnaf;
    }

    /**
     * Applies the operation <code>&tau;()</code> to an
     * <code>ECPoint.F2m</code>. 
     * @param p The ECPoint.F2m to which <code>&tau;()</code> is applied.
     * @return <code>&tau;(p)</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.017 -0500", hash_original_method = "0AF9661B39DF89BA2CB28B0B7702F643", hash_generated_method = "12CFD1E25E85643ED325C9AD18CFEEC0")
    
public static ECPoint.F2m tau(ECPoint.F2m p)
    {
        if (p.isInfinity())
        {
            return p;
        }

        ECFieldElement x = p.getX();
        ECFieldElement y = p.getY();

        return new ECPoint.F2m(p.getCurve(), x.square(), y.square(), p.isCompressed());
    }

    /**
     * Returns the parameter <code>&mu;</code> of the elliptic curve.
     * @param curve The elliptic curve from which to obtain <code>&mu;</code>.
     * The curve must be a Koblitz curve, i.e. <code>a</code> equals
     * <code>0</code> or <code>1</code> and <code>b</code> equals
     * <code>1</code>. 
     * @return <code>&mu;</code> of the elliptic curve.
     * @throws IllegalArgumentException if the given ECCurve is not a Koblitz
     * curve.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.020 -0500", hash_original_method = "54A08A57EB6D682D1E1FABEB6CEDFDE7", hash_generated_method = "071FCFDE691A9399465C0094D37F00E4")
    
public static byte getMu(ECCurve.F2m curve)
    {
        BigInteger a = curve.getA().toBigInteger();
        byte mu;

        if (a.equals(ECConstants.ZERO))
        {
            mu = -1;
        }
        else if (a.equals(ECConstants.ONE))
        {
            mu = 1;
        }
        else
        {
            throw new IllegalArgumentException("No Koblitz curve (ABC), " +
                    "TNAF multiplication not possible");
        }
        return mu;
    }

    /**
     * Calculates the Lucas Sequence elements <code>U<sub>k-1</sub></code> and
     * <code>U<sub>k</sub></code> or <code>V<sub>k-1</sub></code> and
     * <code>V<sub>k</sub></code>.
     * @param mu The parameter <code>&mu;</code> of the elliptic curve.
     * @param k The index of the second element of the Lucas Sequence to be
     * returned.
     * @param doV If set to true, computes <code>V<sub>k-1</sub></code> and
     * <code>V<sub>k</sub></code>, otherwise <code>U<sub>k-1</sub></code> and
     * <code>U<sub>k</sub></code>.
     * @return An array with 2 elements, containing <code>U<sub>k-1</sub></code>
     * and <code>U<sub>k</sub></code> or <code>V<sub>k-1</sub></code>
     * and <code>V<sub>k</sub></code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.023 -0500", hash_original_method = "B78760B6B76AB776070241E43E861258", hash_generated_method = "F9CF7F93C4CEEC6A276A14C546E83E81")
    
public static BigInteger[] getLucas(byte mu, int k, boolean doV)
    {
        if (!((mu == 1) || (mu == -1)))
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }

        BigInteger u0;
        BigInteger u1;
        BigInteger u2;

        if (doV)
        {
            u0 = ECConstants.TWO;
            u1 = BigInteger.valueOf(mu);
        }
        else
        {
            u0 = ECConstants.ZERO;
            u1 = ECConstants.ONE;
        }

        for (int i = 1; i < k; i++)
        {
            // u2 = mu*u1 - 2*u0;
            BigInteger s = null;
            if (mu == 1)
            {
                s = u1;
            }
            else
            {
                // mu == -1
                s = u1.negate();
            }
            
            u2 = s.subtract(u0.shiftLeft(1));
            u0 = u1;
            u1 = u2;
//            System.out.println(i + ": " + u2);
//            System.out.println();
        }

        BigInteger[] retVal = {u0, u1};
        return retVal;
    }

    /**
     * Computes the auxiliary value <code>t<sub>w</sub></code>. If the width is
     * 4, then for <code>mu = 1</code>, <code>t<sub>w</sub> = 6</code> and for
     * <code>mu = -1</code>, <code>t<sub>w</sub> = 10</code> 
     * @param mu The parameter <code>&mu;</code> of the elliptic curve.
     * @param w The window width of the WTNAF.
     * @return the auxiliary value <code>t<sub>w</sub></code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.025 -0500", hash_original_method = "39A2EE88735ABA3F952333D86E844A33", hash_generated_method = "54F564BB8437B0E8A1A94F08141E9C7E")
    
public static BigInteger getTw(byte mu, int w)
    {
        if (w == 4)
        {
            if (mu == 1)
            {
                return BigInteger.valueOf(6);
            }
            else
            {
                // mu == -1
                return BigInteger.valueOf(10);
            }
        }
        else
        {
            // For w <> 4, the values must be computed
            BigInteger[] us = getLucas(mu, w, false);
            BigInteger twoToW = ECConstants.ZERO.setBit(w);
            BigInteger u1invert = us[1].modInverse(twoToW);
            BigInteger tw;
            tw = ECConstants.TWO.multiply(us[0]).multiply(u1invert).mod(twoToW);
//            System.out.println("mu = " + mu);
//            System.out.println("tw = " + tw);
            return tw;
        }
    }

    /**
     * Computes the auxiliary values <code>s<sub>0</sub></code> and
     * <code>s<sub>1</sub></code> used for partial modular reduction. 
     * @param curve The elliptic curve for which to compute
     * <code>s<sub>0</sub></code> and <code>s<sub>1</sub></code>.
     * @throws IllegalArgumentException if <code>curve</code> is not a
     * Koblitz curve (Anomalous Binary Curve, ABC).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.028 -0500", hash_original_method = "EEB9AA9DB567B9E2271C925A0847E421", hash_generated_method = "29406FBE232E570250E9151E603C86F4")
    
public static BigInteger[] getSi(ECCurve.F2m curve)
    {
        if (!curve.isKoblitz())
        {
            throw new IllegalArgumentException("si is defined for Koblitz curves only");
        }

        int m = curve.getM();
        int a = curve.getA().toBigInteger().intValue();
        byte mu = curve.getMu();
        int h = curve.getH().intValue();
        int index = m + 3 - a;
        BigInteger[] ui = getLucas(mu, index, false);

        BigInteger dividend0;
        BigInteger dividend1;
        if (mu == 1)
        {
            dividend0 = ECConstants.ONE.subtract(ui[1]);
            dividend1 = ECConstants.ONE.subtract(ui[0]);
        }
        else if (mu == -1)
        {
            dividend0 = ECConstants.ONE.add(ui[1]);
            dividend1 = ECConstants.ONE.add(ui[0]);
        }
        else
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }

        BigInteger[] si = new BigInteger[2];

        if (h == 2)
        {
            si[0] = dividend0.shiftRight(1);
            si[1] = dividend1.shiftRight(1).negate();
        }
        else if (h == 4)
        {
            si[0] = dividend0.shiftRight(2);
            si[1] = dividend1.shiftRight(2).negate();
        }
        else
        {
            throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
        }

        return si;
    }

    /**
     * Partial modular reduction modulo
     * <code>(&tau;<sup>m</sup> - 1)/(&tau; - 1)</code>.
     * @param k The integer to be reduced.
     * @param m The bitlength of the underlying finite field.
     * @param a The parameter <code>a</code> of the elliptic curve.
     * @param s The auxiliary values <code>s<sub>0</sub></code> and
     * <code>s<sub>1</sub></code>.
     * @param mu The parameter &mu; of the elliptic curve.
     * @param c The precision (number of bits of accuracy) of the partial
     * modular reduction.
     * @return <code>&rho; := k partmod (&tau;<sup>m</sup> - 1)/(&tau; - 1)</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.031 -0500", hash_original_method = "FB2EC5D8B12C04BA891CB7A7EE47F374", hash_generated_method = "31271D7CFBBC50634D1AB6E6BC6B2559")
    
public static ZTauElement partModReduction(BigInteger k, int m, byte a,
            BigInteger[] s, byte mu, byte c)
    {
        // d0 = s[0] + mu*s[1]; mu is either 1 or -1
        BigInteger d0;
        if (mu == 1)
        {
            d0 = s[0].add(s[1]);
        }
        else
        {
            d0 = s[0].subtract(s[1]);
        }

        BigInteger[] v = getLucas(mu, m, true);
        BigInteger vm = v[1];

        SimpleBigDecimal lambda0 = approximateDivisionByN(
                k, s[0], vm, a, m, c);
        
        SimpleBigDecimal lambda1 = approximateDivisionByN(
                k, s[1], vm, a, m, c);

        ZTauElement q = round(lambda0, lambda1, mu);

        // r0 = n - d0*q0 - 2*s1*q1
        BigInteger r0 = k.subtract(d0.multiply(q.u)).subtract(
                BigInteger.valueOf(2).multiply(s[1]).multiply(q.v));

        // r1 = s1*q0 - s0*q1
        BigInteger r1 = s[1].multiply(q.u).subtract(s[0].multiply(q.v));
        
        return new ZTauElement(r0, r1);
    }

    /**
     * Multiplies a {@link org.bouncycastle.math.ec.ECPoint.F2m ECPoint.F2m}
     * by a <code>BigInteger</code> using the reduced <code>&tau;</code>-adic
     * NAF (RTNAF) method.
     * @param p The ECPoint.F2m to multiply.
     * @param k The <code>BigInteger</code> by which to multiply <code>p</code>.
     * @return <code>k * p</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.034 -0500", hash_original_method = "1F7273EF26745CBC11E1C712393F22D5", hash_generated_method = "ED2028B7D89E2C3685C44EE7E5A67214")
    
public static ECPoint.F2m multiplyRTnaf(ECPoint.F2m p, BigInteger k)
    {
        ECCurve.F2m curve = (ECCurve.F2m) p.getCurve();
        int m = curve.getM();
        byte a = (byte) curve.getA().toBigInteger().intValue();
        byte mu = curve.getMu();
        BigInteger[] s = curve.getSi();
        ZTauElement rho = partModReduction(k, m, a, s, mu, (byte)10);

        return multiplyTnaf(p, rho);
    }

    /**
     * Multiplies a {@link org.bouncycastle.math.ec.ECPoint.F2m ECPoint.F2m}
     * by an element <code>&lambda;</code> of <code><b>Z</b>[&tau;]</code>
     * using the <code>&tau;</code>-adic NAF (TNAF) method.
     * @param p The ECPoint.F2m to multiply.
     * @param lambda The element <code>&lambda;</code> of
     * <code><b>Z</b>[&tau;]</code>.
     * @return <code>&lambda; * p</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.037 -0500", hash_original_method = "667D0F740EF0109574C00B67AB1F0586", hash_generated_method = "16B3D0A6D8696FA6905F460637320268")
    
public static ECPoint.F2m multiplyTnaf(ECPoint.F2m p, ZTauElement lambda)
    {
        ECCurve.F2m curve = (ECCurve.F2m)p.getCurve();
        byte mu = curve.getMu();
        byte[] u = tauAdicNaf(mu, lambda);

        ECPoint.F2m q = multiplyFromTnaf(p, u);

        return q;
    }

    /**
    * Multiplies a {@link org.bouncycastle.math.ec.ECPoint.F2m ECPoint.F2m}
    * by an element <code>&lambda;</code> of <code><b>Z</b>[&tau;]</code>
    * using the <code>&tau;</code>-adic NAF (TNAF) method, given the TNAF
    * of <code>&lambda;</code>.
    * @param p The ECPoint.F2m to multiply.
    * @param u The the TNAF of <code>&lambda;</code>..
    * @return <code>&lambda; * p</code>
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.039 -0500", hash_original_method = "0833A62905CCEFC5583EA9F31E32AF2B", hash_generated_method = "4857D9150D6293877CC9DA74B7B81E9D")
    
public static ECPoint.F2m multiplyFromTnaf(ECPoint.F2m p, byte[] u)
    {
        ECCurve.F2m curve = (ECCurve.F2m)p.getCurve();
        ECPoint.F2m q = (ECPoint.F2m) curve.getInfinity();
        for (int i = u.length - 1; i >= 0; i--)
        {
            q = tau(q);
            if (u[i] == 1)
            {
                q = (ECPoint.F2m)q.addSimple(p);
            }
            else if (u[i] == -1)
            {
                q = (ECPoint.F2m)q.subtractSimple(p);
            }
        }
        return q;
    }

    /**
     * Computes the <code>[&tau;]</code>-adic window NAF of an element
     * <code>&lambda;</code> of <code><b>Z</b>[&tau;]</code>.
     * @param mu The parameter &mu; of the elliptic curve.
     * @param lambda The element <code>&lambda;</code> of
     * <code><b>Z</b>[&tau;]</code> of which to compute the
     * <code>[&tau;]</code>-adic NAF.
     * @param width The window width of the resulting WNAF.
     * @param pow2w 2<sup>width</sup>.
     * @param tw The auxiliary value <code>t<sub>w</sub></code>.
     * @param alpha The <code>&alpha;<sub>u</sub></code>'s for the window width.
     * @return The <code>[&tau;]</code>-adic window NAF of
     * <code>&lambda;</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.043 -0500", hash_original_method = "44ECAB7CCF1E1A7E957F1A152FF180D4", hash_generated_method = "00EE6B3274706ED9634D310BB4AA658E")
    
public static byte[] tauAdicWNaf(byte mu, ZTauElement lambda,
            byte width, BigInteger pow2w, BigInteger tw, ZTauElement[] alpha)
    {
        if (!((mu == 1) || (mu == -1)))
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }

        BigInteger norm = norm(mu, lambda);

        // Ceiling of log2 of the norm 
        int log2Norm = norm.bitLength();

        // If length(TNAF) > 30, then length(TNAF) < log2Norm + 3.52
        int maxLength = log2Norm > 30 ? log2Norm + 4 + width : 34 + width;

        // The array holding the TNAF
        byte[] u = new byte[maxLength];

        // 2^(width - 1)
        BigInteger pow2wMin1 = pow2w.shiftRight(1);

        // Split lambda into two BigIntegers to simplify calculations
        BigInteger r0 = lambda.u;
        BigInteger r1 = lambda.v;
        int i = 0;

        // while lambda <> (0, 0)
        while (!((r0.equals(ECConstants.ZERO))&&(r1.equals(ECConstants.ZERO))))
        {
            // if r0 is odd
            if (r0.testBit(0))
            {
                // uUnMod = r0 + r1*tw mod 2^width
                BigInteger uUnMod
                    = r0.add(r1.multiply(tw)).mod(pow2w);
                
                byte uLocal;
                // if uUnMod >= 2^(width - 1)
                if (uUnMod.compareTo(pow2wMin1) >= 0)
                {
                    uLocal = (byte) uUnMod.subtract(pow2w).intValue();
                }
                else
                {
                    uLocal = (byte) uUnMod.intValue();
                }
                // uLocal is now in [-2^(width-1), 2^(width-1)-1]

                u[i] = uLocal;
                boolean s = true;
                if (uLocal < 0)
                {
                    s = false;
                    uLocal = (byte)-uLocal;
                }
                // uLocal is now >= 0

                if (s)
                {
                    r0 = r0.subtract(alpha[uLocal].u);
                    r1 = r1.subtract(alpha[uLocal].v);
                }
                else
                {
                    r0 = r0.add(alpha[uLocal].u);
                    r1 = r1.add(alpha[uLocal].v);
                }
            }
            else
            {
                u[i] = 0;
            }

            BigInteger t = r0;

            if (mu == 1)
            {
                r0 = r1.add(r0.shiftRight(1));
            }
            else
            {
                // mu == -1
                r0 = r1.subtract(r0.shiftRight(1));
            }
            r1 = t.shiftRight(1).negate();
            i++;
        }
        return u;
    }

    /**
     * Does the precomputation for WTNAF multiplication.
     * @param p The <code>ECPoint</code> for which to do the precomputation.
     * @param a The parameter <code>a</code> of the elliptic curve.
     * @return The precomputation array for <code>p</code>. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.046 -0500", hash_original_method = "F49CFE570CFFA710E0434F95AECBF72A", hash_generated_method = "3E1BE1BE91CA1F009C38580CF65A5C27")
    
public static ECPoint.F2m[] getPreComp(ECPoint.F2m p, byte a)
    {
        ECPoint.F2m[] pu;
        pu = new ECPoint.F2m[16];
        pu[1] = p;
        byte[][] alphaTnaf;
        if (a == 0)
        {
            alphaTnaf = Tnaf.alpha0Tnaf;
        }
        else
        {
            // a == 1
            alphaTnaf = Tnaf.alpha1Tnaf;
        }

        int precompLen = alphaTnaf.length;
        for (int i = 3; i < precompLen; i = i + 2)
        {
            pu[i] = Tnaf.multiplyFromTnaf(p, alphaTnaf[i]);
        }
        
        return pu;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.979 -0500", hash_original_field = "6F806218DB13548C10588489C40B6F4F", hash_generated_field = "E47A0708357590CCE79AC42AC8295DDF")

    private static final BigInteger MINUS_ONE = ECConstants.ONE.negate();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.982 -0500", hash_original_field = "F580B06ED70B12BDA9965CB64C411E24", hash_generated_field = "233983D0ED664D901E87017E2630A217")

    private static final BigInteger MINUS_TWO = ECConstants.TWO.negate();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.984 -0500", hash_original_field = "2DA6C735D9084DDFA252CD9E3592375B", hash_generated_field = "08C22EA714BE24B9BEB625FE05C99244")

    private static final BigInteger MINUS_THREE = ECConstants.THREE.negate();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.987 -0500", hash_original_field = "DF9E386CC9CDE2D1C05A101CBF196C0F", hash_generated_field = "215F7EF58A81C276BCD0EDD9879D52DC")

    public static final byte WIDTH = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.989 -0500", hash_original_field = "CF3CF90483E0134F0DDA89C5D0E6CDFA", hash_generated_field = "21265DFA1B96D48276E77642FD82A450")

    public static final byte POW_2_WIDTH = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.991 -0500", hash_original_field = "B9660E76D7E309D8177EC8F30DC9875D", hash_generated_field = "6CD45D97DE0751113A36B5C417B90B59")

    public static final ZTauElement[] alpha0 = {
        null,
        new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null,
        new ZTauElement(MINUS_THREE, MINUS_ONE), null,
        new ZTauElement(MINUS_ONE, MINUS_ONE), null,
        new ZTauElement(ECConstants.ONE, MINUS_ONE), null
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.994 -0500", hash_original_field = "DD158E6E00D6C1196FA563835C8B60B8", hash_generated_field = "2610932BBC232F1B35161A474C555605")

    public static final byte[][] alpha0Tnaf = {
        null, {1}, null, {-1, 0, 1}, null, {1, 0, 1}, null, {-1, 0, 0, 1}
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:39.997 -0500", hash_original_field = "ACAB0FF2FC90B3234130F7D2CFB76364", hash_generated_field = "B27BD535E864081052B48483622B9F55")

    public static final ZTauElement[] alpha1 = {null,
        new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null,
        new ZTauElement(MINUS_THREE, ECConstants.ONE), null,
        new ZTauElement(MINUS_ONE, ECConstants.ONE), null,
        new ZTauElement(ECConstants.ONE, ECConstants.ONE), null
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.000 -0500", hash_original_field = "4D543AB17D63F5D9AAA3A0D71A216094", hash_generated_field = "429E234FB060570ACC226375F178F480")

    public static final byte[][] alpha1Tnaf = {
        null, {1}, null, {-1, 0, 1}, null, {1, 0, 1}, null, {-1, 0, 0, -1}
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.864 -0400", hash_original_method = "6AFB421B9578CA1EB17678ABFF5836A8", hash_generated_method = "6AFB421B9578CA1EB17678ABFF5836A8")
    public Tnaf ()
    {
        //Synthesized constructor
    }
}

