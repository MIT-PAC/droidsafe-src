package org.bouncycastle.jce.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.provider.asymmetric.ec.EC5Util;
import org.bouncycastle.jce.provider.asymmetric.ec.ECUtil;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;






public class JCEECPublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.891 -0500", hash_original_field = "33AD2E21A3D6578549470A35F5EBE102", hash_generated_field = "03A7690F51B3F9BF560AF66A2E562751")

    private String                  algorithm = "EC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.891 -0500", hash_original_field = "E0015430B52E8DC21D8477370DE05860", hash_generated_field = "1BFFE5596A381FE9DEDEC12337FB70C9")

    private org.bouncycastle.math.ec.ECPoint q;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.892 -0500", hash_original_field = "EB973ACD34C53FAD0CB136BA5F678A1A", hash_generated_field = "2F50CBE484A009E85DF08C55473AAD50")

    private ECParameterSpec         ecSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.893 -0500", hash_original_field = "FE461DF1DAA1B11668B50BA700384774", hash_generated_field = "C4E023510AEF37ABC4F4741FA8031492")

    private boolean                 withCompression;
    // BEGIN android-removed
    // private GOST3410PublicKeyAlgParameters       gostParams;
    // END android-removed

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.894 -0500", hash_original_method = "9E7728C1623EC94B5D37FACBA5DD3318", hash_generated_method = "340070F335BFD5CE5D8FF0B1C33A7725")
    public JCEECPublicKey(
        String              algorithm,
        JCEECPublicKey      key)
    {
        this.algorithm = algorithm;
        this.q = key.q;
        this.ecSpec = key.ecSpec;
        this.withCompression = key.withCompression;
        // BEGIN android-removed
        // this.gostParams = key.gostParams;
        // END android-removed
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.895 -0500", hash_original_method = "A5616D4D55CEB63F772F9CBA3C1DFD14", hash_generated_method = "B2B4728FBA7543329415A0352F25603D")
    public JCEECPublicKey(
        String              algorithm,
        ECPublicKeySpec     spec)
    {
        this.algorithm = algorithm;
        this.ecSpec = spec.getParams();
        this.q = EC5Util.convertPoint(ecSpec, spec.getW(), false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.896 -0500", hash_original_method = "111BFFE89DFF28BACA95639C99C739E4", hash_generated_method = "C3BE91760D28E89BC77D0AA7A9862862")
    public JCEECPublicKey(
        String              algorithm,
        org.bouncycastle.jce.spec.ECPublicKeySpec     spec)
    {
        this.algorithm = algorithm;
        this.q = spec.getQ();

        if (spec.getParams() != null) // can be null if implictlyCa
        {
            ECCurve curve = spec.getParams().getCurve();
            EllipticCurve ellipticCurve = EC5Util.convertCurve(curve, spec.getParams().getSeed());

            this.ecSpec = EC5Util.convertSpec(ellipticCurve, spec.getParams());
        }
        else
        {
            if (q.getCurve() == null)
            {
                org.bouncycastle.jce.spec.ECParameterSpec s = ProviderUtil.getEcImplicitlyCa();

                q = s.getCurve().createPoint(q.getX().toBigInteger(), q.getY().toBigInteger(), false);
            }               
            this.ecSpec = null;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.897 -0500", hash_original_method = "55746F5B590BA5E7E6F86647B2880B63", hash_generated_method = "8CC9BA9D03C335B66861FFD027DC48D8")
    public JCEECPublicKey(
        String                  algorithm,
        ECPublicKeyParameters   params,
        ECParameterSpec         spec)
    {
        ECDomainParameters      dp = params.getParameters();

        this.algorithm = algorithm;
        this.q = params.getQ();

        if (spec == null)
        {
            EllipticCurve ellipticCurve = EC5Util.convertCurve(dp.getCurve(), dp.getSeed());

            this.ecSpec = createSpec(ellipticCurve, dp);
        }
        else
        {
            this.ecSpec = spec;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.898 -0500", hash_original_method = "DB4C98F6CA9631B3AF629189844FA51E", hash_generated_method = "3B5008678D73869B15A635910D6A711B")
    public JCEECPublicKey(
        String                  algorithm,
        ECPublicKeyParameters   params,
        org.bouncycastle.jce.spec.ECParameterSpec         spec)
    {
        ECDomainParameters      dp = params.getParameters();

        this.algorithm = algorithm;
        this.q = params.getQ();

        if (spec == null)
        {
            EllipticCurve ellipticCurve = EC5Util.convertCurve(dp.getCurve(), dp.getSeed());

            this.ecSpec = createSpec(ellipticCurve, dp);
        }
        else
        {
            EllipticCurve ellipticCurve = EC5Util.convertCurve(spec.getCurve(), spec.getSeed());

            this.ecSpec = EC5Util.convertSpec(ellipticCurve, spec);
        }
    }

    /*
     * called for implicitCA
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.899 -0500", hash_original_method = "493E6C6367259B3C767DD7B0D44CD4AE", hash_generated_method = "B4457F9BF43D079CB8C22D0DD415B68A")
    public JCEECPublicKey(
        String                  algorithm,
        ECPublicKeyParameters   params)
    {
        this.algorithm = algorithm;
        this.q = params.getQ();
        this.ecSpec = null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.901 -0500", hash_original_method = "48FEA81B6DD226AC77A269B6C1D0920E", hash_generated_method = "8E2371D86B877A10720FEEA7F2BEF130")
    public JCEECPublicKey(
        ECPublicKey     key)
    {
        this.algorithm = key.getAlgorithm();
        this.ecSpec = key.getParams();
        this.q = EC5Util.convertPoint(this.ecSpec, key.getW(), false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.902 -0500", hash_original_method = "E3331AE678062C5B5D7432BD6E2A836D", hash_generated_method = "E3331AE678062C5B5D7432BD6E2A836D")
    JCEECPublicKey(
        SubjectPublicKeyInfo    info)
    {
        populateFromPubKeyInfo(info);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.900 -0500", hash_original_method = "78B971AFBB9FB77663E9AB2BC39F53F9", hash_generated_method = "1F63A992ABDA31E1B069D0AA20D39148")
    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters dp)
    {
        return new ECParameterSpec(
                ellipticCurve,
                new ECPoint(
                        dp.getG().getX().toBigInteger(),
                        dp.getG().getY().toBigInteger()),
                        dp.getN(),
                        dp.getH().intValue());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.903 -0500", hash_original_method = "04369E0AD06428BC33AE0A89BD867221", hash_generated_method = "C3C6B22A24A18C0190D74359896DABB5")
    private void populateFromPubKeyInfo(SubjectPublicKeyInfo info)
    {
        // BEGIN android-removed
        // if (info.getAlgorithmId().getObjectId().equals(CryptoProObjectIdentifiers.gostR3410_2001))
        // {
        //     DERBitString bits = info.getPublicKeyData();
        //     ASN1OctetString key;
        //     this.algorithm = "ECGOST3410";
        //
        //     try
        //     {
        //         key = (ASN1OctetString) ASN1Object.fromByteArray(bits.getBytes());
        //     }
        //     catch (IOException ex)
        //     {
        //         throw new IllegalArgumentException("error recovering public key");
        //     }
        //
        //     byte[]          keyEnc = key.getOctets();
        //     byte[]          x = new byte[32];
        //     byte[]          y = new byte[32];
        //
        //     for (int i = 0; i != x.length; i++)
        //     {
        //         x[i] = keyEnc[32 - 1 - i];
        //     }
        //
        //     for (int i = 0; i != y.length; i++)
        //     {
        //         y[i] = keyEnc[64 - 1 - i];
        //     }
        //
        //     gostParams = new GOST3410PublicKeyAlgParameters((ASN1Sequence)info.getAlgorithmId().getParameters());
        //
        //     ECNamedCurveParameterSpec spec = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(gostParams.getPublicKeyParamSet()));
        //
        //     ECCurve curve = spec.getCurve();
        //     EllipticCurve ellipticCurve = EC5Util.convertCurve(curve, spec.getSeed());
        //
        //     this.q = curve.createPoint(new BigInteger(1, x), new BigInteger(1, y), false);
        //
        //     ecSpec = new ECNamedCurveSpec(
        //             ECGOST3410NamedCurves.getName(gostParams.getPublicKeyParamSet()),
        //             ellipticCurve,
        //             new ECPoint(
        //                     spec.getG().getX().toBigInteger(),
        //                     spec.getG().getY().toBigInteger()),
        //                     spec.getN(), spec.getH());
        //
        // }
        // else
        // END android-removed
        {
            X962Parameters params = new X962Parameters((DERObject)info.getAlgorithmId().getParameters());
            ECCurve                 curve;
            EllipticCurve           ellipticCurve;

            if (params.isNamedCurve())
            {
                DERObjectIdentifier oid = (DERObjectIdentifier)params.getParameters();
                X9ECParameters ecP = ECUtil.getNamedCurveByOid(oid);

                curve = ecP.getCurve();
                ellipticCurve = EC5Util.convertCurve(curve, ecP.getSeed());

                ecSpec = new ECNamedCurveSpec(
                        ECUtil.getCurveName(oid),
                        ellipticCurve,
                        new ECPoint(
                                ecP.getG().getX().toBigInteger(),
                                ecP.getG().getY().toBigInteger()),
                        ecP.getN(),
                        ecP.getH());
            }
            else if (params.isImplicitlyCA())
            {
                ecSpec = null;
                curve = ProviderUtil.getEcImplicitlyCa().getCurve();
            }
            else
            {
                X9ECParameters          ecP = new X9ECParameters((ASN1Sequence)params.getParameters());

                curve = ecP.getCurve();
                ellipticCurve = EC5Util.convertCurve(curve, ecP.getSeed());

                this.ecSpec = new ECParameterSpec(
                        ellipticCurve,
                        new ECPoint(
                                ecP.getG().getX().toBigInteger(),
                                ecP.getG().getY().toBigInteger()),
                        ecP.getN(),
                        ecP.getH().intValue());
            }

            DERBitString    bits = info.getPublicKeyData();
            byte[]          data = bits.getBytes();
            ASN1OctetString key = new DEROctetString(data);

            //
            // extra octet string - one of our old certs...
            //
            if (data[0] == 0x04 && data[1] == data.length - 2
                && (data[2] == 0x02 || data[2] == 0x03))
            {
                int qLength = new X9IntegerConverter().getByteLength(curve);

                if (qLength >= data.length - 3)
                {
                    try
                    {
                        key = (ASN1OctetString) ASN1Object.fromByteArray(data);
                    }
                    catch (IOException ex)
                    {
                        throw new IllegalArgumentException("error recovering public key");
                    }
                }
            }
            X9ECPoint derQ = new X9ECPoint(curve, key);

            this.q = derQ.getPoint();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.904 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "09B8CB0F05513E7BA5A386900D5BF6E6")
    public String getAlgorithm()
    {
        return algorithm;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.904 -0500", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "7238AE3F6AC2664EEF973F2CB2EA7A49")
    public String getFormat()
    {
        return "X.509";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.906 -0500", hash_original_method = "B91F24351022908E98D855E5218CDAAE", hash_generated_method = "6527FDBC850542362DCA22A63743B546")
    public byte[] getEncoded()
    {
        ASN1Encodable        params;
        SubjectPublicKeyInfo info;

        // BEGIN android-removed
        // if (algorithm.equals("ECGOST3410"))
        // {
        //     if (gostParams != null)
        //     {
        //         params = gostParams;
        //     }
        //     else
        //     {
        //         if (ecSpec instanceof ECNamedCurveSpec)
        //         {
        //             params = new GOST3410PublicKeyAlgParameters(
        //                            ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec)ecSpec).getName()),
        //                            CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
        //         }
        //         else
        //         {   // strictly speaking this may not be applicable...
        //             ECCurve curve = EC5Util.convertCurve(ecSpec.getCurve());
        //
        //             X9ECParameters ecP = new X9ECParameters(
        //                 curve,
        //                 EC5Util.convertPoint(curve, ecSpec.getGenerator(), withCompression),
        //                 ecSpec.getOrder(),
        //                 BigInteger.valueOf(ecSpec.getCofactor()),
        //                 ecSpec.getCurve().getSeed());
        //
        //             params = new X962Parameters(ecP);
        //         }
        //     }
        //
        //     BigInteger      bX = this.q.getX().toBigInteger();
        //     BigInteger      bY = this.q.getY().toBigInteger();
        //     byte[]          encKey = new byte[64];
        //
        //     extractBytes(encKey, 0, bX);
        //     extractBytes(encKey, 32, bY);
        //
        //     info = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, params.getDERObject()), new DEROctetString(encKey));
        // }
        // else
        // END android-removed
        {
            if (ecSpec instanceof ECNamedCurveSpec)
            {
                DERObjectIdentifier curveOid = ECUtil.getNamedCurveOid(((ECNamedCurveSpec)ecSpec).getName());
                if (curveOid == null)
                {
                    curveOid = new DERObjectIdentifier(((ECNamedCurveSpec)ecSpec).getName());
                }
                params = new X962Parameters(curveOid);
            }
            else if (ecSpec == null)
            {
                params = new X962Parameters(DERNull.INSTANCE);
            }
            else
            {
                ECCurve curve = EC5Util.convertCurve(ecSpec.getCurve());

                X9ECParameters ecP = new X9ECParameters(
                    curve,
                    EC5Util.convertPoint(curve, ecSpec.getGenerator(), withCompression),
                    ecSpec.getOrder(),
                    BigInteger.valueOf(ecSpec.getCofactor()),
                    ecSpec.getCurve().getSeed());

                params = new X962Parameters(ecP);
            }

            ECCurve curve = this.engineGetQ().getCurve();
            ASN1OctetString p = (ASN1OctetString)
                new X9ECPoint(curve.createPoint(this.getQ().getX().toBigInteger(), this.getQ().getY().toBigInteger(), withCompression)).getDERObject();

            info = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, params.getDERObject()), p.getOctets());
        }

        return info.getDEREncoded();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.907 -0500", hash_original_method = "7BE58B7CFDB546DA8CA10F5D2E9502BA", hash_generated_method = "FB7EAE8355D3C84383B8E9F07B4C6DC0")
    private void extractBytes(byte[] encKey, int offSet, BigInteger bI)
    {
        byte[] val = bI.toByteArray();
        if (val.length < 32)
        {
            byte[] tmp = new byte[32];
            System.arraycopy(val, 0, tmp, tmp.length - val.length, val.length);
            val = tmp;
        }

        for (int i = 0; i != 32; i++)
        {
            encKey[offSet + i] = val[val.length - 1 - i];
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.907 -0500", hash_original_method = "F5E9634D462D35EA798E6B23EBFE4406", hash_generated_method = "B9C39808478CA1F0355CA0827C05D825")
    public ECParameterSpec getParams()
    {
        return ecSpec;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.908 -0500", hash_original_method = "81096D9364BAA8B516E2B6B9D2CC7FA4", hash_generated_method = "4E62030D307C47813F66EEB282C15F97")
    public org.bouncycastle.jce.spec.ECParameterSpec getParameters()
    {
        if (ecSpec == null)     // implictlyCA
        {
            return null;
        }

        return EC5Util.convertSpec(ecSpec, withCompression);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.909 -0500", hash_original_method = "FA9E01D5B24E77318273BFF81F13FFEE", hash_generated_method = "5B834286FC65FFB477093C7DF4D63638")
    public ECPoint getW()
    {
        return new ECPoint(q.getX().toBigInteger(), q.getY().toBigInteger());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.910 -0500", hash_original_method = "7DB4A3AB35CAAC289E69D3DC0703DC49", hash_generated_method = "60B805F62EF9FDAF5E1BE2F306902BE9")
    public org.bouncycastle.math.ec.ECPoint getQ()
    {
        if (ecSpec == null)
        {
            if (q instanceof org.bouncycastle.math.ec.ECPoint.Fp)
            {
                return new org.bouncycastle.math.ec.ECPoint.Fp(null, q.getX(), q.getY());
            }
            else
            {
                return new org.bouncycastle.math.ec.ECPoint.F2m(null, q.getX(), q.getY());
            }
        }

        return q;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.911 -0500", hash_original_method = "08945EEACB289647DD0EEBD7F3D2712E", hash_generated_method = "77FA1CDB3AFF5FE18D294E6480FA7A38")
    public org.bouncycastle.math.ec.ECPoint engineGetQ()
    {
        return q;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.912 -0500", hash_original_method = "EA50C6AAC98F0F1C8DE39B8B441A0904", hash_generated_method = "EA50C6AAC98F0F1C8DE39B8B441A0904")
    org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec()
    {
        if (ecSpec != null)
        {
            return EC5Util.convertSpec(ecSpec, withCompression);
        }

        return ProviderUtil.getEcImplicitlyCa();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.913 -0500", hash_original_method = "DA24BA2CA85DFA6FE167BE0F082D0E3F", hash_generated_method = "CB4B65C7D162FEAF0C22BCA6280EC868")
    public String toString()
    {
        StringBuffer    buf = new StringBuffer();
        String          nl = System.getProperty("line.separator");

        buf.append("EC Public Key").append(nl);
        buf.append("            X: ").append(this.q.getX().toBigInteger().toString(16)).append(nl);
        buf.append("            Y: ").append(this.q.getY().toBigInteger().toString(16)).append(nl);

        return buf.toString();

    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.913 -0500", hash_original_method = "EACE99DE9593101E486E698F887836BD", hash_generated_method = "8D7B44536C9B350B5B63EDA5AE268A45")
    public void setPointFormat(String style)
    {
       withCompression = !("UNCOMPRESSED".equalsIgnoreCase(style));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.914 -0500", hash_original_method = "D60F50DFADDF83A04F7A401D33CE399D", hash_generated_method = "03935E2D11EA3D091E1B0044C726EAFF")
    public boolean equals(Object o)
    {
        if (!(o instanceof JCEECPublicKey))
        {
            return false;
        }

        JCEECPublicKey other = (JCEECPublicKey)o;

        return engineGetQ().equals(other.engineGetQ()) && (engineGetSpec().equals(other.engineGetSpec()));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.915 -0500", hash_original_method = "218BA141B3E48ED89E83DD04DDAC204C", hash_generated_method = "6A1E6B819F1E90D11549359BBF278FE9")
    public int hashCode()
    {
        return engineGetQ().hashCode() ^ engineGetSpec().hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.916 -0500", hash_original_method = "65AAF373098ED8D46B05238E5475AB46", hash_generated_method = "6E5EFD3B714F485EC3F876D6BD2C9091")
    private void readObject(
        ObjectInputStream in)
        throws IOException, ClassNotFoundException
    {
        byte[] enc = (byte[])in.readObject();

        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Object.fromByteArray(enc)));

        this.algorithm = (String)in.readObject();
        this.withCompression = in.readBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.917 -0500", hash_original_method = "2E7E67EC6D00C929FDA46D4809812937", hash_generated_method = "00D4F0E1FC29AC287FDBAEBB452F71E5")
    private void writeObject(
        ObjectOutputStream out)
        throws IOException
    {
        out.writeObject(this.getEncoded());
        out.writeObject(algorithm);
        out.writeBoolean(withCompression);
    }

    
}

