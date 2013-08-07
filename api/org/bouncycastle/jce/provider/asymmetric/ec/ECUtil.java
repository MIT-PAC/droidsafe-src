package org.bouncycastle.jce.provider.asymmetric.ec;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.JCEECPublicKey;
import org.bouncycastle.jce.provider.ProviderUtil;
import org.bouncycastle.jce.spec.ECParameterSpec;





public class ECUtil {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.686 -0400", hash_original_method = "752F644B3C790719452D11E8D47EF025", hash_generated_method = "752F644B3C790719452D11E8D47EF025")
    public ECUtil ()
    {
        //Synthesized constructor
    }


        static int[] convertMidTerms(
        int[] k) {
        int[] res = new int[3];
        if (k.length == 1)
        {
            res[0] = k[0];
        }
        else
        {
            if (k.length != 3)
            {
                throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
            }
            if (k[0] < k[1] && k[0] < k[2])
            {
                res[0] = k[0];
                if (k[1] < k[2])
                {
                    res[1] = k[1];
                    res[2] = k[2];
                }
                else
                {
                    res[1] = k[2];
                    res[2] = k[1];
                }
            }
            else if (k[1] < k[2])
            {
                res[0] = k[1];
                if (k[0] < k[2])
                {
                    res[1] = k[0];
                    res[2] = k[2];
                }
                else
                {
                    res[1] = k[2];
                    res[2] = k[0];
                }
            }
            else
            {
                res[0] = k[2];
                if (k[0] < k[1])
                {
                    res[1] = k[0];
                    res[2] = k[1];
                }
                else
                {
                    res[1] = k[1];
                    res[2] = k[0];
                }
            }
        }
        return res;
    }

    
        public static AsymmetricKeyParameter generatePublicKeyParameter(
        PublicKey    key) throws InvalidKeyException {
        if (key instanceof ECPublicKey)
        {
            ECPublicKey    k = (ECPublicKey)key;
            ECParameterSpec s = k.getParameters();
            if (s == null)
            {
                s = ProviderUtil.getEcImplicitlyCa();
                return new ECPublicKeyParameters(
                            ((JCEECPublicKey)k).engineGetQ(),
                            new ECDomainParameters(s.getCurve(), s.getG(), s.getN(), s.getH(), s.getSeed()));
            }
            else
            {
                return new ECPublicKeyParameters(
                            k.getQ(),
                            new ECDomainParameters(s.getCurve(), s.getG(), s.getN(), s.getH(), s.getSeed()));
            }
        }
        else if (key instanceof java.security.interfaces.ECPublicKey)
        {
            java.security.interfaces.ECPublicKey pubKey = (java.security.interfaces.ECPublicKey)key;
            ECParameterSpec s = EC5Util.convertSpec(pubKey.getParams(), false);
            return new ECPublicKeyParameters(
                EC5Util.convertPoint(pubKey.getParams(), pubKey.getW(), false),
                            new ECDomainParameters(s.getCurve(), s.getG(), s.getN(), s.getH(), s.getSeed()));
        }
        throw new InvalidKeyException("cannot identify EC public key.");
    }

    
        @DSModeled(DSC.SAFE)
    public static AsymmetricKeyParameter generatePrivateKeyParameter(
        PrivateKey    key) throws InvalidKeyException {
        if (key instanceof ECPrivateKey)
        {
            ECPrivateKey  k = (ECPrivateKey)key;
            ECParameterSpec s = k.getParameters();
            if (s == null)
            {
                s = ProviderUtil.getEcImplicitlyCa();
            }
            return new ECPrivateKeyParameters(
                            k.getD(),
                            new ECDomainParameters(s.getCurve(), s.getG(), s.getN(), s.getH(), s.getSeed()));
        }
        throw new InvalidKeyException("can't identify EC private key.");
    }

    
        public static DERObjectIdentifier getNamedCurveOid(
        String name) {
        DERObjectIdentifier oid = X962NamedCurves.getOID(name);
        if (oid == null)
        {
            oid = SECNamedCurves.getOID(name);
            if (oid == null)
            {
                oid = NISTNamedCurves.getOID(name);
            }
        }
        return oid;
    }

    
        public static X9ECParameters getNamedCurveByOid(
        DERObjectIdentifier oid) {
        X9ECParameters params = X962NamedCurves.getByOID(oid);
        if (params == null)
        {
            params = SECNamedCurves.getByOID(oid);
            if (params == null)
            {
                params = NISTNamedCurves.getByOID(oid);
            }
        }
        return params;
    }

    
        public static String getCurveName(
        DERObjectIdentifier oid) {
        String name = X962NamedCurves.getName(oid);
        if (name == null)
        {
            name = SECNamedCurves.getName(oid);
            if (name == null)
            {
                name = NISTNamedCurves.getName(oid);
            }
        }
        return name;
    }

    
}

