package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

class WTauNafMultiplier implements ECMultiplier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.685 -0400", hash_original_method = "25BA0794289AAEB8CCD4FF1151858B35", hash_generated_method = "25BA0794289AAEB8CCD4FF1151858B35")
    public WTauNafMultiplier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.686 -0400", hash_original_method = "02F90693504CEA800318EF0ACD8D13BB", hash_generated_method = "F104B3039FC0DC08B60D3425BB81B921")
    public ECPoint multiply(ECPoint point, BigInteger k, PreCompInfo preCompInfo) {
        addTaint(preCompInfo.getTaint());
        addTaint(k.getTaint());
        addTaint(point.getTaint());
    if(!(point instanceof ECPoint.F2m))        
        {
            IllegalArgumentException varE5E1326E4D326E8513AE291F8CFFC7B4_1621432997 = new IllegalArgumentException("Only ECPoint.F2m can be " +
                    "used in WTauNafMultiplier");
            varE5E1326E4D326E8513AE291F8CFFC7B4_1621432997.addTaint(taint);
            throw varE5E1326E4D326E8513AE291F8CFFC7B4_1621432997;
        } //End block
        ECPoint.F2m p = (ECPoint.F2m)point;
        ECCurve.F2m curve = (ECCurve.F2m) p.getCurve();
        int m = curve.getM();
        byte a = curve.getA().toBigInteger().byteValue();
        byte mu = curve.getMu();
        BigInteger[] s = curve.getSi();
        ZTauElement rho = Tnaf.partModReduction(k, m, a, s, mu, (byte)10);
ECPoint var7D4C483E3AE81B6FBDD328B64E587BCD_155315681 =         multiplyWTnaf(p, rho, preCompInfo, a, mu);
        var7D4C483E3AE81B6FBDD328B64E587BCD_155315681.addTaint(taint);
        return var7D4C483E3AE81B6FBDD328B64E587BCD_155315681;
        // ---------- Original Method ----------
        //if (!(point instanceof ECPoint.F2m))
        //{
            //throw new IllegalArgumentException("Only ECPoint.F2m can be " +
                    //"used in WTauNafMultiplier");
        //}
        //ECPoint.F2m p = (ECPoint.F2m)point;
        //ECCurve.F2m curve = (ECCurve.F2m) p.getCurve();
        //int m = curve.getM();
        //byte a = curve.getA().toBigInteger().byteValue();
        //byte mu = curve.getMu();
        //BigInteger[] s = curve.getSi();
        //ZTauElement rho = Tnaf.partModReduction(k, m, a, s, mu, (byte)10);
        //return multiplyWTnaf(p, rho, preCompInfo, a, mu);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.688 -0400", hash_original_method = "35C9D9252ADD71DF3C65B7738D13F8CD", hash_generated_method = "F6419A6BDEDD17206D03DAEBFC0A63E3")
    private ECPoint.F2m multiplyWTnaf(ECPoint.F2m p, ZTauElement lambda,
            PreCompInfo preCompInfo, byte a, byte mu) {
        addTaint(mu);
        addTaint(a);
        addTaint(preCompInfo.getTaint());
        addTaint(lambda.getTaint());
        addTaint(p.getTaint());
        ZTauElement[] alpha;
    if(a == 0)        
        {
            alpha = Tnaf.alpha0;
        } //End block
        else
        {
            alpha = Tnaf.alpha1;
        } //End block
        BigInteger tw = Tnaf.getTw(mu, Tnaf.WIDTH);
        byte[] u = Tnaf.tauAdicWNaf(mu, lambda, Tnaf.WIDTH,
                BigInteger.valueOf(Tnaf.POW_2_WIDTH), tw, alpha);
ECPoint.F2m var8FB674322EEF53AD831EA5BF0B5AB0AB_1788803347 =         multiplyFromWTnaf(p, u, preCompInfo);
        var8FB674322EEF53AD831EA5BF0B5AB0AB_1788803347.addTaint(taint);
        return var8FB674322EEF53AD831EA5BF0B5AB0AB_1788803347;
        // ---------- Original Method ----------
        //ZTauElement[] alpha;
        //if (a == 0)
        //{
            //alpha = Tnaf.alpha0;
        //}
        //else
        //{
            //alpha = Tnaf.alpha1;
        //}
        //BigInteger tw = Tnaf.getTw(mu, Tnaf.WIDTH);
        //byte[]u = Tnaf.tauAdicWNaf(mu, lambda, Tnaf.WIDTH,
                //BigInteger.valueOf(Tnaf.POW_2_WIDTH), tw, alpha);
        //return multiplyFromWTnaf(p, u, preCompInfo);
    }

    
        private static ECPoint.F2m multiplyFromWTnaf(ECPoint.F2m p, byte[] u,
            PreCompInfo preCompInfo) {
        ECCurve.F2m curve = (ECCurve.F2m)p.getCurve();
        byte a = curve.getA().toBigInteger().byteValue();
        ECPoint.F2m[] pu;
        if ((preCompInfo == null) || !(preCompInfo instanceof WTauNafPreCompInfo))
        {
            pu = Tnaf.getPreComp(p, a);
            p.setPreCompInfo(new WTauNafPreCompInfo(pu));
        }
        else
        {
            pu = ((WTauNafPreCompInfo)preCompInfo).getPreComp();
        }
        ECPoint.F2m q = (ECPoint.F2m) p.getCurve().getInfinity();
        for (int i = u.length - 1; i >= 0; i--)
        {
            q = Tnaf.tau(q);
            if (u[i] != 0)
            {
                if (u[i] > 0)
                {
                    q = q.addSimple(pu[u[i]]);
                }
                else
                {
                    q = q.subtractSimple(pu[-u[i]]);
                }
            }
        }
        return q;
    }

    
}

