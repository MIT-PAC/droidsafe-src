package org.bouncycastle.jce.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.bouncycastle.math.ec.ECCurve;

public class ECNamedCurveSpec extends java.security.spec.ECParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.715 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.715 -0400", hash_original_method = "4276647301AD5567F7E81FEE94BB2F38", hash_generated_method = "5080E56319DD5B89AB8F302D18725B39")
    public  ECNamedCurveSpec(
        String                              name,
        ECCurve                             curve,
        org.bouncycastle.math.ec.ECPoint    g,
        BigInteger                          n) {
        super(convertCurve(curve, null), convertPoint(g), n, 1);
        addTaint(n.getTaint());
        addTaint(g.getTaint());
        addTaint(curve.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.716 -0400", hash_original_method = "CAA47738BBEABFB278C5C60E2D737E6B", hash_generated_method = "2C7C6F777AA87B1F8826E664B866684C")
    public  ECNamedCurveSpec(
        String          name,
        EllipticCurve   curve,
        ECPoint         g,
        BigInteger      n) {
        super(curve, g, n, 1);
        addTaint(n.getTaint());
        addTaint(g.getTaint());
        addTaint(curve.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.716 -0400", hash_original_method = "AB580F26C9F3FD2CD227F13E32C2054F", hash_generated_method = "CA0785FC65C943F5A5D09F43B68BD8CC")
    public  ECNamedCurveSpec(
        String                              name,
        ECCurve                             curve,
        org.bouncycastle.math.ec.ECPoint    g,
        BigInteger                          n,
        BigInteger                          h) {
        super(convertCurve(curve, null), convertPoint(g), n, h.intValue());
        addTaint(h.getTaint());
        addTaint(n.getTaint());
        addTaint(g.getTaint());
        addTaint(curve.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.717 -0400", hash_original_method = "634A87ED1F6D5175A80B4ED088AFA7D7", hash_generated_method = "3E8E9A3392A52F7C824CDED2EA2EF828")
    public  ECNamedCurveSpec(
        String          name,
        EllipticCurve   curve,
        ECPoint         g,
        BigInteger      n,
        BigInteger      h) {
        super(curve, g, n, h.intValue());
        addTaint(h.getTaint());
        addTaint(n.getTaint());
        addTaint(g.getTaint());
        addTaint(curve.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.717 -0400", hash_original_method = "BB51292C1E41936143B80095A0485C14", hash_generated_method = "EB105FA9C456F4303840DED0BD457665")
    public  ECNamedCurveSpec(
        String                              name,
        ECCurve                             curve,
        org.bouncycastle.math.ec.ECPoint    g,
        BigInteger                          n,
        BigInteger                          h,
        byte[]                              seed) {
        super(convertCurve(curve, seed), convertPoint(g), n, h.intValue());
        addTaint(seed[0]);
        addTaint(h.getTaint());
        addTaint(n.getTaint());
        addTaint(g.getTaint());
        addTaint(curve.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
        private static EllipticCurve convertCurve(
        ECCurve  curve,
        byte[]   seed) {
        if (curve instanceof ECCurve.Fp)
        {
            return new EllipticCurve(new ECFieldFp(((ECCurve.Fp)curve).getQ()), curve.getA().toBigInteger(), curve.getB().toBigInteger(), seed);
        }
        else
        {
            ECCurve.F2m curveF2m = (ECCurve.F2m)curve;
            int ks[];
            if (curveF2m.isTrinomial())
            {
                ks = new int[] { curveF2m.getK1() };
                return new EllipticCurve(new ECFieldF2m(curveF2m.getM(), ks), curve.getA().toBigInteger(), curve.getB().toBigInteger(), seed);
            }
            else
            {
                ks = new int[] { curveF2m.getK3(), curveF2m.getK2(), curveF2m.getK1() };
                return new EllipticCurve(new ECFieldF2m(curveF2m.getM(), ks), curve.getA().toBigInteger(), curve.getB().toBigInteger(), seed);
            } 
        }
    }

    
        private static ECPoint convertPoint(
        org.bouncycastle.math.ec.ECPoint  g) {
        return new ECPoint(g.getX().toBigInteger(), g.getY().toBigInteger());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.718 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "9B03B5DA4F8BD173B700252DF0C57E2D")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1826123813 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1826123813.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1826123813;
        // ---------- Original Method ----------
        //return name;
    }

    
}

