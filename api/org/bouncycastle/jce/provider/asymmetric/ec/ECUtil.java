package org.bouncycastle.jce.provider.asymmetric.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
    /**
     * Returns a sorted array of middle terms of the reduction polynomial.
     * @param k The unsorted array of middle terms of the reduction polynomial
     * of length 1 or 3.
     * @return the sorted array of middle terms of the reduction polynomial.
     * This array always has length 3.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:35.936 -0500", hash_original_method = "F61560D6410770019EFCEB5BB2747D12", hash_generated_method = "0BD637A5C843FA735D6186DCA29E94AF")
    
static int[] convertMidTerms(
        int[] k)
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:35.939 -0500", hash_original_method = "8A09C41342945B0A3D4C640CD2728034", hash_generated_method = "0FBF73609C3F6366E6DEBFBEE94338EB")
    
public static AsymmetricKeyParameter generatePublicKeyParameter(
        PublicKey    key)
        throws InvalidKeyException
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:35.942 -0500", hash_original_method = "D78C8BC2AB778E36C16A199AE31942DC", hash_generated_method = "6940C76D7E79F1CAA8340262E8BCED43")
    
public static AsymmetricKeyParameter generatePrivateKeyParameter(
        PrivateKey    key)
        throws InvalidKeyException
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:35.944 -0500", hash_original_method = "B09318820B1BB1E7BF65E456E65CCDF4", hash_generated_method = "A46C330A84CCA63D66D0E1963B1E4054")
    
public static DERObjectIdentifier getNamedCurveOid(
        String name)
    {
        DERObjectIdentifier oid = X962NamedCurves.getOID(name);
        
        if (oid == null)
        {
            oid = SECNamedCurves.getOID(name);
            if (oid == null)
            {
                oid = NISTNamedCurves.getOID(name);
            }
            // BEGIN android-removed
            // if (oid == null)
            // {
            //     oid = TeleTrusTNamedCurves.getOID(name);
            // }
            // if (oid == null)
            // {
            //     oid = ECGOST3410NamedCurves.getOID(name);
            // }
            // END android-removed
        }

        return oid;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:35.947 -0500", hash_original_method = "99D54083A5A2CE9260B377C5AE531596", hash_generated_method = "E4BE302DDA7101436330F3001BD8FDA6")
    
public static X9ECParameters getNamedCurveByOid(
        DERObjectIdentifier oid)
    {
        X9ECParameters params = X962NamedCurves.getByOID(oid);
        
        if (params == null)
        {
            params = SECNamedCurves.getByOID(oid);
            if (params == null)
            {
                params = NISTNamedCurves.getByOID(oid);
            }
            // BEGIN android-removed
            // if (params == null)
            // {
            //     params = TeleTrusTNamedCurves.getByOID(oid);
            // }
            // END android-removed
        }

        return params;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:35.950 -0500", hash_original_method = "F9131D554D124B354B6D5A9BCCAADA2B", hash_generated_method = "19AA32B5282C3D869916AD5D5C6D72C0")
    
public static String getCurveName(
        DERObjectIdentifier oid)
    {
        String name = X962NamedCurves.getName(oid);
        
        if (name == null)
        {
            name = SECNamedCurves.getName(oid);
            if (name == null)
            {
                name = NISTNamedCurves.getName(oid);
            }
            // BEGIN android-removed
            // if (name == null)
            // {
            //     name = TeleTrusTNamedCurves.getName(oid);
            // }
            // if (name == null)
            // {
            //     name = ECGOST3410NamedCurves.getName(oid);
            // }
            // END android-removed
        }

        return name;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.686 -0400", hash_original_method = "752F644B3C790719452D11E8D47EF025", hash_generated_method = "752F644B3C790719452D11E8D47EF025")
    public ECUtil ()
    {
        //Synthesized constructor
    }
    
}

