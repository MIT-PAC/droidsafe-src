package org.bouncycastle.jce.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

import org.bouncycastle.math.ec.ECCurve;

public class ECNamedCurveSpec extends java.security.spec.ECParameterSpec {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.678 -0500", hash_original_method = "CE1DD527477219861FDCA53909D9C5B4", hash_generated_method = "43B612AD67691A34A25D88EC51B8C458")
    
private static EllipticCurve convertCurve(
        ECCurve  curve,
        byte[]   seed)
    {
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.680 -0500", hash_original_method = "B7C4AA036ACA2A30B8E15DF061701AFE", hash_generated_method = "78DF96FB7B5A501ED10C62063FF96B6B")
    
private static ECPoint convertPoint(
        org.bouncycastle.math.ec.ECPoint  g)
    {
        return new ECPoint(g.getX().toBigInteger(), g.getY().toBigInteger());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.675 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String  name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.683 -0500", hash_original_method = "4276647301AD5567F7E81FEE94BB2F38", hash_generated_method = "F8DECD8AB5B8A43A838961802F7C69F8")
    
public ECNamedCurveSpec(
        String                              name,
        ECCurve                             curve,
        org.bouncycastle.math.ec.ECPoint    g,
        BigInteger                          n)
    {
        super(convertCurve(curve, null), convertPoint(g), n, 1);

        this.name = name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.686 -0500", hash_original_method = "CAA47738BBEABFB278C5C60E2D737E6B", hash_generated_method = "39DB2A28602EA0F32119A69BA7C88B69")
    
public ECNamedCurveSpec(
        String          name,
        EllipticCurve   curve,
        ECPoint         g,
        BigInteger      n)
    {
        super(curve, g, n, 1);

        this.name = name;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.689 -0500", hash_original_method = "AB580F26C9F3FD2CD227F13E32C2054F", hash_generated_method = "817C2C620F86E0E6627195D052D21E06")
    
public ECNamedCurveSpec(
        String                              name,
        ECCurve                             curve,
        org.bouncycastle.math.ec.ECPoint    g,
        BigInteger                          n,
        BigInteger                          h)
    {
        super(convertCurve(curve, null), convertPoint(g), n, h.intValue());

        this.name = name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.691 -0500", hash_original_method = "634A87ED1F6D5175A80B4ED088AFA7D7", hash_generated_method = "233540BFF6D661F581843428B66EAC84")
    
public ECNamedCurveSpec(
        String          name,
        EllipticCurve   curve,
        ECPoint         g,
        BigInteger      n,
        BigInteger      h)
    {
        super(curve, g, n, h.intValue());

        this.name = name;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.694 -0500", hash_original_method = "BB51292C1E41936143B80095A0485C14", hash_generated_method = "4A379DB8670880EDB88E76BCDA9BD707")
    
public ECNamedCurveSpec(
        String                              name,
        ECCurve                             curve,
        org.bouncycastle.math.ec.ECPoint    g,
        BigInteger                          n,
        BigInteger                          h,
        byte[]                              seed)
    {
        super(convertCurve(curve, seed), convertPoint(g), n, h.intValue());
        
        this.name = name;
    }

    /**
     * return the name of the curve the EC domain parameters belong to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.696 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName()
    {
        return name;
    }
    
}

