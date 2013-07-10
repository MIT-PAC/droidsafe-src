package org.bouncycastle.math.ec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;

class Tnaf {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.867 -0400", hash_original_method = "6AFB421B9578CA1EB17678ABFF5836A8", hash_generated_method = "6AFB421B9578CA1EB17678ABFF5836A8")
    public Tnaf ()
    {
        
    }


    public static BigInteger norm(final byte mu, ZTauElement lambda) {
        BigInteger norm;
        BigInteger s1 = lambda.u.multiply(lambda.u);
        BigInteger s2 = lambda.u.multiply(lambda.v);
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

    
    public static SimpleBigDecimal norm(final byte mu, SimpleBigDecimal u,
            SimpleBigDecimal v) {
        SimpleBigDecimal norm;
        SimpleBigDecimal s1 = u.multiply(u);
        SimpleBigDecimal s2 = u.multiply(v);
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

    
    @DSModeled(DSC.SAFE)
    public static ZTauElement round(SimpleBigDecimal lambda0,
            SimpleBigDecimal lambda1, byte mu) {
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
        SimpleBigDecimal eta = eta0.add(eta0);
        if (mu == 1)
        {
            eta = eta.add(eta1);
        }
        else
        {
            eta = eta.subtract(eta1);
        }
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
            check1 = eta0.add(threeEta1);
            check2 = eta0.subtract(fourEta1);
        }
        byte h0 = 0;
        byte h1 = 0;
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
            if (check2.compareTo(ECConstants.TWO) >= 0)
            {
                h1 = mu;
            }
        }
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
            if (check2.compareTo(MINUS_TWO) < 0)
            {
                h1 = (byte)-mu;
            }
        }
        BigInteger q0 = f0.add(BigInteger.valueOf(h0));
        BigInteger q1 = f1.add(BigInteger.valueOf(h1));
        return new ZTauElement(q0, q1);
    }

    
    @DSModeled(DSC.SAFE)
    public static SimpleBigDecimal approximateDivisionByN(BigInteger k,
            BigInteger s, BigInteger vm, byte a, int m, int c) {
        int _k = (m + 5)/2 + c;
        BigInteger ns = k.shiftRight(m - _k - 2 + a);
        BigInteger gs = s.multiply(ns);
        BigInteger hs = gs.shiftRight(m);
        BigInteger js = vm.multiply(hs);
        BigInteger gsPlusJs = gs.add(js);
        BigInteger ls = gsPlusJs.shiftRight(_k-c);
        if (gsPlusJs.testBit(_k-c-1))
        {
            ls = ls.add(ECConstants.ONE);
        }
        return new SimpleBigDecimal(ls, c);
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] tauAdicNaf(byte mu, ZTauElement lambda) {
        if (!((mu == 1) || (mu == -1)))
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        BigInteger norm = norm(mu, lambda);
        int log2Norm = norm.bitLength();
        int maxLength = log2Norm > 30 ? log2Norm + 4 : 34;
        byte[] u = new byte[maxLength];
        int i = 0;
        int length = 0;
        BigInteger r0 = lambda.u;
        BigInteger r1 = lambda.v;
        while(!((r0.equals(ECConstants.ZERO)) && (r1.equals(ECConstants.ZERO))))
        {
            if (r0.testBit(0))
            {
                u[i] = (byte) ECConstants.TWO.subtract((r0.subtract(r1.shiftLeft(1))).mod(ECConstants.FOUR)).intValue();
                if (u[i] == 1)
                {
                    r0 = r0.clearBit(0);
                }
                else
                {
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
                r0 = r1.subtract(s);
            }
            r1 = t.shiftRight(1).negate();
            i++;
        }
        length++;
        byte[] tnaf = new byte[length];
        System.arraycopy(u, 0, tnaf, 0, length);
        return tnaf;
    }

    
    public static ECPoint.F2m tau(ECPoint.F2m p) {
        if (p.isInfinity())
        {
            return p;
        }
        ECFieldElement x = p.getX();
        ECFieldElement y = p.getY();
        return new ECPoint.F2m(p.getCurve(), x.square(), y.square(), p.isCompressed());
    }

    
    public static byte getMu(ECCurve.F2m curve) {
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

    
    @DSModeled(DSC.SAFE)
    public static BigInteger[] getLucas(byte mu, int k, boolean doV) {
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
            BigInteger s = null;
            if (mu == 1)
            {
                s = u1;
            }
            else
            {
                s = u1.negate();
            }
            u2 = s.subtract(u0.shiftLeft(1));
            u0 = u1;
            u1 = u2;
        }
        BigInteger[] retVal = {u0, u1};
        return retVal;
    }

    
    @DSModeled(DSC.SAFE)
    public static BigInteger getTw(byte mu, int w) {
        if (w == 4)
        {
            if (mu == 1)
            {
                return BigInteger.valueOf(6);
            }
            else
            {
                return BigInteger.valueOf(10);
            }
        }
        else
        {
            BigInteger[] us = getLucas(mu, w, false);
            BigInteger twoToW = ECConstants.ZERO.setBit(w);
            BigInteger u1invert = us[1].modInverse(twoToW);
            BigInteger tw;
            tw = ECConstants.TWO.multiply(us[0]).multiply(u1invert).mod(twoToW);
            return tw;
        }
    }

    
    public static BigInteger[] getSi(ECCurve.F2m curve) {
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

    
    @DSModeled(DSC.SAFE)
    public static ZTauElement partModReduction(BigInteger k, int m, byte a,
            BigInteger[] s, byte mu, byte c) {
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
        BigInteger r0 = k.subtract(d0.multiply(q.u)).subtract(
                BigInteger.valueOf(2).multiply(s[1]).multiply(q.v));
        BigInteger r1 = s[1].multiply(q.u).subtract(s[0].multiply(q.v));
        return new ZTauElement(r0, r1);
    }

    
    public static ECPoint.F2m multiplyRTnaf(ECPoint.F2m p, BigInteger k) {
        ECCurve.F2m curve = (ECCurve.F2m) p.getCurve();
        int m = curve.getM();
        byte a = (byte) curve.getA().toBigInteger().intValue();
        byte mu = curve.getMu();
        BigInteger[] s = curve.getSi();
        ZTauElement rho = partModReduction(k, m, a, s, mu, (byte)10);
        return multiplyTnaf(p, rho);
    }

    
    public static ECPoint.F2m multiplyTnaf(ECPoint.F2m p, ZTauElement lambda) {
        ECCurve.F2m curve = (ECCurve.F2m)p.getCurve();
        byte mu = curve.getMu();
        byte[] u = tauAdicNaf(mu, lambda);
        ECPoint.F2m q = multiplyFromTnaf(p, u);
        return q;
    }

    
    public static ECPoint.F2m multiplyFromTnaf(ECPoint.F2m p, byte[] u) {
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

    
    @DSModeled(DSC.SAFE)
    public static byte[] tauAdicWNaf(byte mu, ZTauElement lambda,
            byte width, BigInteger pow2w, BigInteger tw, ZTauElement[] alpha) {
        if (!((mu == 1) || (mu == -1)))
        {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        BigInteger norm = norm(mu, lambda);
        int log2Norm = norm.bitLength();
        int maxLength = log2Norm > 30 ? log2Norm + 4 + width : 34 + width;
        byte[] u = new byte[maxLength];
        BigInteger pow2wMin1 = pow2w.shiftRight(1);
        BigInteger r0 = lambda.u;
        BigInteger r1 = lambda.v;
        int i = 0;
        while (!((r0.equals(ECConstants.ZERO))&&(r1.equals(ECConstants.ZERO))))
        {
            if (r0.testBit(0))
            {
                BigInteger uUnMod
                    = r0.add(r1.multiply(tw)).mod(pow2w);
                byte uLocal;
                if (uUnMod.compareTo(pow2wMin1) >= 0)
                {
                    uLocal = (byte) uUnMod.subtract(pow2w).intValue();
                }
                else
                {
                    uLocal = (byte) uUnMod.intValue();
                }
                u[i] = uLocal;
                boolean s = true;
                if (uLocal < 0)
                {
                    s = false;
                    uLocal = (byte)-uLocal;
                }
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
                r0 = r1.subtract(r0.shiftRight(1));
            }
            r1 = t.shiftRight(1).negate();
            i++;
        }
        return u;
    }

    
    public static ECPoint.F2m[] getPreComp(ECPoint.F2m p, byte a) {
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
            alphaTnaf = Tnaf.alpha1Tnaf;
        }
        int precompLen = alphaTnaf.length;
        for (int i = 3; i < precompLen; i = i + 2)
        {
            pu[i] = Tnaf.multiplyFromTnaf(p, alphaTnaf[i]);
        }
        return pu;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.871 -0400", hash_original_field = "46940386C5E4B7F858F2360BD51B3E0B", hash_generated_field = "E47A0708357590CCE79AC42AC8295DDF")

    private static final BigInteger MINUS_ONE = ECConstants.ONE.negate();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.871 -0400", hash_original_field = "E028E87A2D4B7B8682848C5038475291", hash_generated_field = "233983D0ED664D901E87017E2630A217")

    private static final BigInteger MINUS_TWO = ECConstants.TWO.negate();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.872 -0400", hash_original_field = "A0A4249CE7D103C1D2E1CA663ED74910", hash_generated_field = "08C22EA714BE24B9BEB625FE05C99244")

    private static final BigInteger MINUS_THREE = ECConstants.THREE.negate();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.872 -0400", hash_original_field = "672E91342A9CD68768AB135997317B75", hash_generated_field = "215F7EF58A81C276BCD0EDD9879D52DC")

    public static final byte WIDTH = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.872 -0400", hash_original_field = "DC21CE98F8126B37FACA40EE6BFEA402", hash_generated_field = "21265DFA1B96D48276E77642FD82A450")

    public static final byte POW_2_WIDTH = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.872 -0400", hash_original_field = "8F9C346BAE23F193BC224F479E430F3E", hash_generated_field = "6CD45D97DE0751113A36B5C417B90B59")

    public static final ZTauElement[] alpha0 = {
        null,
        new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null,
        new ZTauElement(MINUS_THREE, MINUS_ONE), null,
        new ZTauElement(MINUS_ONE, MINUS_ONE), null,
        new ZTauElement(ECConstants.ONE, MINUS_ONE), null
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.872 -0400", hash_original_field = "EA28EFCACE8665B00CEDB38808A55DDB", hash_generated_field = "2610932BBC232F1B35161A474C555605")

    public static final byte[][] alpha0Tnaf = {
        null, {1}, null, {-1, 0, 1}, null, {1, 0, 1}, null, {-1, 0, 0, 1}
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.872 -0400", hash_original_field = "D40189B030BA142DBB62F29BB65B3753", hash_generated_field = "B27BD535E864081052B48483622B9F55")

    public static final ZTauElement[] alpha1 = {null,
        new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null,
        new ZTauElement(MINUS_THREE, ECConstants.ONE), null,
        new ZTauElement(MINUS_ONE, ECConstants.ONE), null,
        new ZTauElement(ECConstants.ONE, ECConstants.ONE), null
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.872 -0400", hash_original_field = "B265920709CACADAC6D749B57869C9BF", hash_generated_field = "429E234FB060570ACC226375F178F480")

    public static final byte[][] alpha1Tnaf = {
        null, {1}, null, {-1, 0, 1}, null, {1, 0, 1}, null, {-1, 0, 0, -1}
    };
}

