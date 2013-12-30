package org.bouncycastle.jce.provider.asymmetric.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;





public class EC5Util {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.032 -0500", hash_original_method = "D2830BD07D3130852D457ED09BAC30B4", hash_generated_method = "E87384123D53EA285E4CC0C45416B41E")
    
public static EllipticCurve convertCurve(
        ECCurve curve, 
        byte[]  seed)
    {
        // TODO: the Sun EC implementation doesn't currently handle the seed properly
        // so at the moment it's set to null. Should probably look at making this configurable
        if (curve instanceof ECCurve.Fp)
        {
            return new EllipticCurve(new ECFieldFp(((ECCurve.Fp)curve).getQ()), curve.getA().toBigInteger(), curve.getB().toBigInteger(), null);
        }
        else
        {
            ECCurve.F2m curveF2m = (ECCurve.F2m)curve;
            int ks[];
            
            if (curveF2m.isTrinomial())
            {
                ks = new int[] { curveF2m.getK1() };
                
                return new EllipticCurve(new ECFieldF2m(curveF2m.getM(), ks), curve.getA().toBigInteger(), curve.getB().toBigInteger(), null);
            }
            else
            {
                ks = new int[] { curveF2m.getK3(), curveF2m.getK2(), curveF2m.getK1() };
                
                return new EllipticCurve(new ECFieldF2m(curveF2m.getM(), ks), curve.getA().toBigInteger(), curve.getB().toBigInteger(), null);
            } 
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.035 -0500", hash_original_method = "DF6321E52D95F0D8985F17FFECBD307E", hash_generated_method = "6BAA17ACA3A02144F97FA6B6FDE5FDC3")
    
public static ECCurve convertCurve(
        EllipticCurve ec)
    {
        ECField field = ec.getField();
        BigInteger a = ec.getA();
        BigInteger b = ec.getB();

        if (field instanceof ECFieldFp)
        {
            return new ECCurve.Fp(((ECFieldFp)field).getP(), a, b);
        }
        else
        {
            ECFieldF2m fieldF2m = (ECFieldF2m)field;
            int m = fieldF2m.getM();
            int ks[] = ECUtil.convertMidTerms(fieldF2m.getMidTermsOfReductionPolynomial());
            return new ECCurve.F2m(m, ks[0], ks[1], ks[2], a, b); 
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.038 -0500", hash_original_method = "A9E0E7B09923AF895DEDC68559085AD6", hash_generated_method = "3F7D8E686D4130CA670237956E88AE53")
    
public static ECParameterSpec convertSpec(
        EllipticCurve ellipticCurve,
        org.bouncycastle.jce.spec.ECParameterSpec spec)
    {
        if (spec instanceof ECNamedCurveParameterSpec)
        {
            return new ECNamedCurveSpec(
                ((ECNamedCurveParameterSpec)spec).getName(),
                ellipticCurve,
                new ECPoint(
                    spec.getG().getX().toBigInteger(),
                    spec.getG().getY().toBigInteger()),
                spec.getN(),
                spec.getH());
        }
        else
        {
            return new ECParameterSpec(
                ellipticCurve,
                new ECPoint(
                    spec.getG().getX().toBigInteger(),
                    spec.getG().getY().toBigInteger()),
                spec.getN(),
                spec.getH().intValue());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.040 -0500", hash_original_method = "BC0074BF0B610B8847FC74E7CA3D7147", hash_generated_method = "7EFEFB40F57541C8625A51EA903C7464")
    
public static org.bouncycastle.jce.spec.ECParameterSpec convertSpec(
        ECParameterSpec ecSpec,
        boolean withCompression)
    {
        ECCurve curve = convertCurve(ecSpec.getCurve());

        return new org.bouncycastle.jce.spec.ECParameterSpec(
            curve,
            convertPoint(curve, ecSpec.getGenerator(), withCompression),
            ecSpec.getOrder(),
            BigInteger.valueOf(ecSpec.getCofactor()),
            ecSpec.getCurve().getSeed());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.043 -0500", hash_original_method = "C0CB41A3DDF37702B4C06DE01CF0EA9D", hash_generated_method = "8AD181BD46D31F6CE5020D7A0874C0A6")
    
public static org.bouncycastle.math.ec.ECPoint convertPoint(
        ECParameterSpec ecSpec,
        ECPoint point,
        boolean withCompression)
    {
        return convertPoint(convertCurve(ecSpec.getCurve()), point, withCompression);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.045 -0500", hash_original_method = "4521231271BEA3B32039C4C8B132C71C", hash_generated_method = "5E2D6C70C1070268BB58A1BC65184845")
    
public static org.bouncycastle.math.ec.ECPoint convertPoint(
        ECCurve curve,
        ECPoint point,
        boolean withCompression)
    {
        return curve.createPoint(point.getAffineX(), point.getAffineY(), withCompression);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.676 -0400", hash_original_method = "11F174102611A1F3EFF98B0ED6DCCE74", hash_generated_method = "11F174102611A1F3EFF98B0ED6DCCE74")
    public EC5Util ()
    {
        //Synthesized constructor
    }

    
}

