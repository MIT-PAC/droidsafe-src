package org.bouncycastle.jce.provider;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.653 -0400", hash_original_field = "4CE104ED21742E2616088672EB5F3AE9", hash_generated_field = "03A7690F51B3F9BF560AF66A2E562751")

    private String algorithm = "EC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.653 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "1BFFE5596A381FE9DEDEC12337FB70C9")

    private org.bouncycastle.math.ec.ECPoint q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.653 -0400", hash_original_field = "33C0F9688A267E08DB13329BAA18AEAF", hash_generated_field = "2F50CBE484A009E85DF08C55473AAD50")

    private ECParameterSpec ecSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.653 -0400", hash_original_field = "A04A91040E7D1CAA0270269A913F52BB", hash_generated_field = "C4E023510AEF37ABC4F4741FA8031492")

    private boolean withCompression;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.654 -0400", hash_original_method = "9E7728C1623EC94B5D37FACBA5DD3318", hash_generated_method = "327156E540554B6E64088EADD09A1AA5")
    public  JCEECPublicKey(
        String              algorithm,
        JCEECPublicKey      key) {
        this.algorithm = algorithm;
        this.q = key.q;
        this.ecSpec = key.ecSpec;
        this.withCompression = key.withCompression;
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
        //this.q = key.q;
        //this.ecSpec = key.ecSpec;
        //this.withCompression = key.withCompression;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.654 -0400", hash_original_method = "A5616D4D55CEB63F772F9CBA3C1DFD14", hash_generated_method = "F0E18FE70983065F38D66BBCC1D37881")
    public  JCEECPublicKey(
        String              algorithm,
        ECPublicKeySpec     spec) {
        this.algorithm = algorithm;
        this.ecSpec = spec.getParams();
        this.q = EC5Util.convertPoint(ecSpec, spec.getW(), false);
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
        //this.ecSpec = spec.getParams();
        //this.q = EC5Util.convertPoint(ecSpec, spec.getW(), false);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.655 -0400", hash_original_method = "111BFFE89DFF28BACA95639C99C739E4", hash_generated_method = "DA5A9316F343B2974C9F9C723F746697")
    public  JCEECPublicKey(
        String              algorithm,
        org.bouncycastle.jce.spec.ECPublicKeySpec     spec) {
        this.algorithm = algorithm;
        this.q = spec.getQ();
    if(spec.getParams() != null)        
        {
            ECCurve curve = spec.getParams().getCurve();
            EllipticCurve ellipticCurve = EC5Util.convertCurve(curve, spec.getParams().getSeed());
            this.ecSpec = EC5Util.convertSpec(ellipticCurve, spec.getParams());
        } //End block
        else
        {
    if(q.getCurve() == null)            
            {
                org.bouncycastle.jce.spec.ECParameterSpec s = ProviderUtil.getEcImplicitlyCa();
                q = s.getCurve().createPoint(q.getX().toBigInteger(), q.getY().toBigInteger(), false);
            } //End block
            this.ecSpec = null;
        } //End block
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
        //this.q = spec.getQ();
        //if (spec.getParams() != null) 
        //{
            //ECCurve curve = spec.getParams().getCurve();
            //EllipticCurve ellipticCurve = EC5Util.convertCurve(curve, spec.getParams().getSeed());
            //this.ecSpec = EC5Util.convertSpec(ellipticCurve, spec.getParams());
        //}
        //else
        //{
            //if (q.getCurve() == null)
            //{
                //org.bouncycastle.jce.spec.ECParameterSpec s = ProviderUtil.getEcImplicitlyCa();
                //q = s.getCurve().createPoint(q.getX().toBigInteger(), q.getY().toBigInteger(), false);
            //}               
            //this.ecSpec = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.656 -0400", hash_original_method = "55746F5B590BA5E7E6F86647B2880B63", hash_generated_method = "2C0036D42620838F47761AA7BD78455B")
    public  JCEECPublicKey(
        String                  algorithm,
        ECPublicKeyParameters   params,
        ECParameterSpec         spec) {
        ECDomainParameters dp = params.getParameters();
        this.algorithm = algorithm;
        this.q = params.getQ();
    if(spec == null)        
        {
            EllipticCurve ellipticCurve = EC5Util.convertCurve(dp.getCurve(), dp.getSeed());
            this.ecSpec = createSpec(ellipticCurve, dp);
        } //End block
        else
        {
            this.ecSpec = spec;
        } //End block
        // ---------- Original Method ----------
        //ECDomainParameters      dp = params.getParameters();
        //this.algorithm = algorithm;
        //this.q = params.getQ();
        //if (spec == null)
        //{
            //EllipticCurve ellipticCurve = EC5Util.convertCurve(dp.getCurve(), dp.getSeed());
            //this.ecSpec = createSpec(ellipticCurve, dp);
        //}
        //else
        //{
            //this.ecSpec = spec;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.657 -0400", hash_original_method = "DB4C98F6CA9631B3AF629189844FA51E", hash_generated_method = "E96C3A560222EA73AA62606C6E52167A")
    public  JCEECPublicKey(
        String                  algorithm,
        ECPublicKeyParameters   params,
        org.bouncycastle.jce.spec.ECParameterSpec         spec) {
        ECDomainParameters dp = params.getParameters();
        this.algorithm = algorithm;
        this.q = params.getQ();
    if(spec == null)        
        {
            EllipticCurve ellipticCurve = EC5Util.convertCurve(dp.getCurve(), dp.getSeed());
            this.ecSpec = createSpec(ellipticCurve, dp);
        } //End block
        else
        {
            EllipticCurve ellipticCurve = EC5Util.convertCurve(spec.getCurve(), spec.getSeed());
            this.ecSpec = EC5Util.convertSpec(ellipticCurve, spec);
        } //End block
        // ---------- Original Method ----------
        //ECDomainParameters      dp = params.getParameters();
        //this.algorithm = algorithm;
        //this.q = params.getQ();
        //if (spec == null)
        //{
            //EllipticCurve ellipticCurve = EC5Util.convertCurve(dp.getCurve(), dp.getSeed());
            //this.ecSpec = createSpec(ellipticCurve, dp);
        //}
        //else
        //{
            //EllipticCurve ellipticCurve = EC5Util.convertCurve(spec.getCurve(), spec.getSeed());
            //this.ecSpec = EC5Util.convertSpec(ellipticCurve, spec);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.658 -0400", hash_original_method = "493E6C6367259B3C767DD7B0D44CD4AE", hash_generated_method = "634D67CD4940A417D642DCB8EEDC2CFC")
    public  JCEECPublicKey(
        String                  algorithm,
        ECPublicKeyParameters   params) {
        this.algorithm = algorithm;
        this.q = params.getQ();
        this.ecSpec = null;
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
        //this.q = params.getQ();
        //this.ecSpec = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.659 -0400", hash_original_method = "48FEA81B6DD226AC77A269B6C1D0920E", hash_generated_method = "88F95272856F11D242A41CB37C342F8B")
    public  JCEECPublicKey(
        ECPublicKey     key) {
        this.algorithm = key.getAlgorithm();
        this.ecSpec = key.getParams();
        this.q = EC5Util.convertPoint(this.ecSpec, key.getW(), false);
        // ---------- Original Method ----------
        //this.algorithm = key.getAlgorithm();
        //this.ecSpec = key.getParams();
        //this.q = EC5Util.convertPoint(this.ecSpec, key.getW(), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.659 -0400", hash_original_method = "E3331AE678062C5B5D7432BD6E2A836D", hash_generated_method = "C3AD784478B0C86AF86FFE5C65E107D3")
      JCEECPublicKey(
        SubjectPublicKeyInfo    info) {
        addTaint(info.getTaint());
        populateFromPubKeyInfo(info);
        // ---------- Original Method ----------
        //populateFromPubKeyInfo(info);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.659 -0400", hash_original_method = "78B971AFBB9FB77663E9AB2BC39F53F9", hash_generated_method = "9BEEA40AAEC25916117B65D6415F788D")
    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters dp) {
        addTaint(dp.getTaint());
        addTaint(ellipticCurve.getTaint());
ECParameterSpec var8C65F275FF8FF83A477F44D642732DE2_528758807 =         new ECParameterSpec(
                ellipticCurve,
                new ECPoint(
                        dp.getG().getX().toBigInteger(),
                        dp.getG().getY().toBigInteger()),
                        dp.getN(),
                        dp.getH().intValue());
        var8C65F275FF8FF83A477F44D642732DE2_528758807.addTaint(taint);
        return var8C65F275FF8FF83A477F44D642732DE2_528758807;
        // ---------- Original Method ----------
        //return new ECParameterSpec(
                //ellipticCurve,
                //new ECPoint(
                        //dp.getG().getX().toBigInteger(),
                        //dp.getG().getY().toBigInteger()),
                        //dp.getN(),
                        //dp.getH().intValue());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.661 -0400", hash_original_method = "04369E0AD06428BC33AE0A89BD867221", hash_generated_method = "0831EB7941687E56C16DB6DB7DA4DFB1")
    private void populateFromPubKeyInfo(SubjectPublicKeyInfo info) {
        addTaint(info.getTaint());
        {
            X962Parameters params = new X962Parameters((DERObject)info.getAlgorithmId().getParameters());
            ECCurve curve;
            EllipticCurve ellipticCurve;
    if(params.isNamedCurve())            
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
            } //End block
            else
    if(params.isImplicitlyCA())            
            {
                ecSpec = null;
                curve = ProviderUtil.getEcImplicitlyCa().getCurve();
            } //End block
            else
            {
                X9ECParameters ecP = new X9ECParameters((ASN1Sequence)params.getParameters());
                curve = ecP.getCurve();
                ellipticCurve = EC5Util.convertCurve(curve, ecP.getSeed());
                this.ecSpec = new ECParameterSpec(
                        ellipticCurve,
                        new ECPoint(
                                ecP.getG().getX().toBigInteger(),
                                ecP.getG().getY().toBigInteger()),
                        ecP.getN(),
                        ecP.getH().intValue());
            } //End block
            DERBitString bits = info.getPublicKeyData();
            byte[] data = bits.getBytes();
            ASN1OctetString key = new DEROctetString(data);
    if(data[0] == 0x04 && data[1] == data.length - 2
                && (data[2] == 0x02 || data[2] == 0x03))            
            {
                int qLength = new X9IntegerConverter().getByteLength(curve);
    if(qLength >= data.length - 3)                
                {
                    try 
                    {
                        key = (ASN1OctetString) ASN1Object.fromByteArray(data);
                    } //End block
                    catch (IOException ex)
                    {
                        IllegalArgumentException varE08E6E96B2926EC14F24CEDEF6430CCA_1034495034 = new IllegalArgumentException("error recovering public key");
                        varE08E6E96B2926EC14F24CEDEF6430CCA_1034495034.addTaint(taint);
                        throw varE08E6E96B2926EC14F24CEDEF6430CCA_1034495034;
                    } //End block
                } //End block
            } //End block
            X9ECPoint derQ = new X9ECPoint(curve, key);
            this.q = derQ.getPoint();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.662 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "91E3B371183A9DE802383F20F4238CCB")
    public String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_1955553569 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_1955553569.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_1955553569;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.662 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "29D8E31D367C417ED8D5A40D461E4362")
    public String getFormat() {
String varF820115C876B7F160DE375988A3E1CA1_653130863 =         "X.509";
        varF820115C876B7F160DE375988A3E1CA1_653130863.addTaint(taint);
        return varF820115C876B7F160DE375988A3E1CA1_653130863;
        // ---------- Original Method ----------
        //return "X.509";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.663 -0400", hash_original_method = "B91F24351022908E98D855E5218CDAAE", hash_generated_method = "36FCE3D113FF99BC15D5555C269222F9")
    public byte[] getEncoded() {
        ASN1Encodable params;
        SubjectPublicKeyInfo info;
        {
    if(ecSpec instanceof ECNamedCurveSpec)            
            {
                DERObjectIdentifier curveOid = ECUtil.getNamedCurveOid(((ECNamedCurveSpec)ecSpec).getName());
    if(curveOid == null)                
                {
                    curveOid = new DERObjectIdentifier(((ECNamedCurveSpec)ecSpec).getName());
                } //End block
                params = new X962Parameters(curveOid);
            } //End block
            else
    if(ecSpec == null)            
            {
                params = new X962Parameters(DERNull.INSTANCE);
            } //End block
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
            } //End block
            ECCurve curve = this.engineGetQ().getCurve();
            ASN1OctetString p = (ASN1OctetString)
                new X9ECPoint(curve.createPoint(this.getQ().getX().toBigInteger(), this.getQ().getY().toBigInteger(), withCompression)).getDERObject();
            info = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, params.getDERObject()), p.getOctets());
        } //End block
        byte[] var04C73CDA127A4D9C2DA5D254C9D9B84E_696915828 = (info.getDEREncoded());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1713545842 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1713545842;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.664 -0400", hash_original_method = "7BE58B7CFDB546DA8CA10F5D2E9502BA", hash_generated_method = "6211640010B5B8182AF3F0157D7D9303")
    private void extractBytes(byte[] encKey, int offSet, BigInteger bI) {
        addTaint(bI.getTaint());
        addTaint(offSet);
        addTaint(encKey[0]);
        byte[] val = bI.toByteArray();
    if(val.length < 32)        
        {
            byte[] tmp = new byte[32];
            System.arraycopy(val, 0, tmp, tmp.length - val.length, val.length);
            val = tmp;
        } //End block
for(int i = 0;i != 32;i++)
        {
            encKey[offSet + i] = val[val.length - 1 - i];
        } //End block
        // ---------- Original Method ----------
        //byte[] val = bI.toByteArray();
        //if (val.length < 32)
        //{
            //byte[] tmp = new byte[32];
            //System.arraycopy(val, 0, tmp, tmp.length - val.length, val.length);
            //val = tmp;
        //}
        //for (int i = 0; i != 32; i++)
        //{
            //encKey[offSet + i] = val[val.length - 1 - i];
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.664 -0400", hash_original_method = "F5E9634D462D35EA798E6B23EBFE4406", hash_generated_method = "F44EF27B339626CE4A1B0B4288426116")
    public ECParameterSpec getParams() {
ECParameterSpec var2050BD22F02FAF79E0E50E99F724B032_2045543333 =         ecSpec;
        var2050BD22F02FAF79E0E50E99F724B032_2045543333.addTaint(taint);
        return var2050BD22F02FAF79E0E50E99F724B032_2045543333;
        // ---------- Original Method ----------
        //return ecSpec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.664 -0400", hash_original_method = "81096D9364BAA8B516E2B6B9D2CC7FA4", hash_generated_method = "83177AB44F81B50CA02F6C464165606D")
    public org.bouncycastle.jce.spec.ECParameterSpec getParameters() {
    if(ecSpec == null)        
        {
org.bouncycastle.jce.spec.ECParameterSpec var540C13E9E156B687226421B24F2DF178_70279857 =             null;
            var540C13E9E156B687226421B24F2DF178_70279857.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_70279857;
        } //End block
org.bouncycastle.jce.spec.ECParameterSpec var50F76CD4865FC2697FA8B52025D95BD0_287354199 =         EC5Util.convertSpec(ecSpec, withCompression);
        var50F76CD4865FC2697FA8B52025D95BD0_287354199.addTaint(taint);
        return var50F76CD4865FC2697FA8B52025D95BD0_287354199;
        // ---------- Original Method ----------
        //if (ecSpec == null)     
        //{
            //return null;
        //}
        //return EC5Util.convertSpec(ecSpec, withCompression);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.665 -0400", hash_original_method = "FA9E01D5B24E77318273BFF81F13FFEE", hash_generated_method = "7465D659EA5019735F99CBC64A5E7535")
    public ECPoint getW() {
ECPoint varAC1ED615D9C1C7CE6EB4F0B7D3687588_557535968 =         new ECPoint(q.getX().toBigInteger(), q.getY().toBigInteger());
        varAC1ED615D9C1C7CE6EB4F0B7D3687588_557535968.addTaint(taint);
        return varAC1ED615D9C1C7CE6EB4F0B7D3687588_557535968;
        // ---------- Original Method ----------
        //return new ECPoint(q.getX().toBigInteger(), q.getY().toBigInteger());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.665 -0400", hash_original_method = "7DB4A3AB35CAAC289E69D3DC0703DC49", hash_generated_method = "263E2215006D7DD91BEAE7CC638D6233")
    public org.bouncycastle.math.ec.ECPoint getQ() {
    if(ecSpec == null)        
        {
    if(q instanceof org.bouncycastle.math.ec.ECPoint.Fp)            
            {
org.bouncycastle.math.ec.ECPoint var9DF88C536F20138E2F014EC10A54FCD9_1281428877 =                 new org.bouncycastle.math.ec.ECPoint.Fp(null, q.getX(), q.getY());
                var9DF88C536F20138E2F014EC10A54FCD9_1281428877.addTaint(taint);
                return var9DF88C536F20138E2F014EC10A54FCD9_1281428877;
            } //End block
            else
            {
org.bouncycastle.math.ec.ECPoint varD24B0E59B14C3032FF04539C52097008_2092541007 =                 new org.bouncycastle.math.ec.ECPoint.F2m(null, q.getX(), q.getY());
                varD24B0E59B14C3032FF04539C52097008_2092541007.addTaint(taint);
                return varD24B0E59B14C3032FF04539C52097008_2092541007;
            } //End block
        } //End block
org.bouncycastle.math.ec.ECPoint varBEF1B7662E10AF6D5747729987514CB6_665005716 =         q;
        varBEF1B7662E10AF6D5747729987514CB6_665005716.addTaint(taint);
        return varBEF1B7662E10AF6D5747729987514CB6_665005716;
        // ---------- Original Method ----------
        //if (ecSpec == null)
        //{
            //if (q instanceof org.bouncycastle.math.ec.ECPoint.Fp)
            //{
                //return new org.bouncycastle.math.ec.ECPoint.Fp(null, q.getX(), q.getY());
            //}
            //else
            //{
                //return new org.bouncycastle.math.ec.ECPoint.F2m(null, q.getX(), q.getY());
            //}
        //}
        //return q;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.665 -0400", hash_original_method = "08945EEACB289647DD0EEBD7F3D2712E", hash_generated_method = "3A4A59E4CC035732665E060B11351844")
    public org.bouncycastle.math.ec.ECPoint engineGetQ() {
org.bouncycastle.math.ec.ECPoint varBEF1B7662E10AF6D5747729987514CB6_605569573 =         q;
        varBEF1B7662E10AF6D5747729987514CB6_605569573.addTaint(taint);
        return varBEF1B7662E10AF6D5747729987514CB6_605569573;
        // ---------- Original Method ----------
        //return q;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.666 -0400", hash_original_method = "EA50C6AAC98F0F1C8DE39B8B441A0904", hash_generated_method = "ED3B766F87F10344E295C96B377D0C24")
     org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
    if(ecSpec != null)        
        {
org.bouncycastle.jce.spec.ECParameterSpec var50F76CD4865FC2697FA8B52025D95BD0_1640243766 =             EC5Util.convertSpec(ecSpec, withCompression);
            var50F76CD4865FC2697FA8B52025D95BD0_1640243766.addTaint(taint);
            return var50F76CD4865FC2697FA8B52025D95BD0_1640243766;
        } //End block
org.bouncycastle.jce.spec.ECParameterSpec var24C37D3B3F7EADB894890AFBF82C4655_187028461 =         ProviderUtil.getEcImplicitlyCa();
        var24C37D3B3F7EADB894890AFBF82C4655_187028461.addTaint(taint);
        return var24C37D3B3F7EADB894890AFBF82C4655_187028461;
        // ---------- Original Method ----------
        //if (ecSpec != null)
        //{
            //return EC5Util.convertSpec(ecSpec, withCompression);
        //}
        //return ProviderUtil.getEcImplicitlyCa();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.666 -0400", hash_original_method = "DA24BA2CA85DFA6FE167BE0F082D0E3F", hash_generated_method = "440796CAF0E07B1174B53036B8A6EB4D")
    public String toString() {
        StringBuffer buf = new StringBuffer();
        String nl = System.getProperty("line.separator");
        buf.append("EC Public Key").append(nl);
        buf.append("            X: ").append(this.q.getX().toBigInteger().toString(16)).append(nl);
        buf.append("            Y: ").append(this.q.getY().toBigInteger().toString(16)).append(nl);
String var4FC680801218E6372BC708D6FA44AE60_947856697 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_947856697.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_947856697;
        // ---------- Original Method ----------
        //StringBuffer    buf = new StringBuffer();
        //String          nl = System.getProperty("line.separator");
        //buf.append("EC Public Key").append(nl);
        //buf.append("            X: ").append(this.q.getX().toBigInteger().toString(16)).append(nl);
        //buf.append("            Y: ").append(this.q.getY().toBigInteger().toString(16)).append(nl);
        //return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.666 -0400", hash_original_method = "EACE99DE9593101E486E698F887836BD", hash_generated_method = "C875AD2160A133E587C0A6CA363211F7")
    public void setPointFormat(String style) {
        withCompression = !("UNCOMPRESSED".equalsIgnoreCase(style));
        // ---------- Original Method ----------
        //withCompression = !("UNCOMPRESSED".equalsIgnoreCase(style));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.667 -0400", hash_original_method = "D60F50DFADDF83A04F7A401D33CE399D", hash_generated_method = "5B38B8366E6481BCB5E8753990F2F11F")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(!(o instanceof JCEECPublicKey))        
        {
            boolean var68934A3E9455FA72420237EB05902327_5622906 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_597476359 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_597476359;
        } //End block
        JCEECPublicKey other = (JCEECPublicKey)o;
        boolean varAA33E9ECCBF57EB9D1708F8B3793C104_1739089061 = (engineGetQ().equals(other.engineGetQ()) && (engineGetSpec().equals(other.engineGetSpec())));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2118331749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2118331749;
        // ---------- Original Method ----------
        //if (!(o instanceof JCEECPublicKey))
        //{
            //return false;
        //}
        //JCEECPublicKey other = (JCEECPublicKey)o;
        //return engineGetQ().equals(other.engineGetQ()) && (engineGetSpec().equals(other.engineGetSpec()));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.667 -0400", hash_original_method = "218BA141B3E48ED89E83DD04DDAC204C", hash_generated_method = "5A9394344987178F6EF97CD67E12AA58")
    public int hashCode() {
        int varE96486F0260DE6367039D0E23462B514_1414124825 = (engineGetQ().hashCode() ^ engineGetSpec().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527208255 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527208255;
        // ---------- Original Method ----------
        //return engineGetQ().hashCode() ^ engineGetSpec().hashCode();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.667 -0400", hash_original_method = "65AAF373098ED8D46B05238E5475AB46", hash_generated_method = "93BDAF02EB2E47650C4355683F4D4D9D")
    private void readObject(
        ObjectInputStream in) throws IOException, ClassNotFoundException {
        byte[] enc = (byte[])in.readObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Object.fromByteArray(enc)));
        this.algorithm = (String)in.readObject();
        this.withCompression = in.readBoolean();
        // ---------- Original Method ----------
        //byte[] enc = (byte[])in.readObject();
        //populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Object.fromByteArray(enc)));
        //this.algorithm = (String)in.readObject();
        //this.withCompression = in.readBoolean();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.668 -0400", hash_original_method = "2E7E67EC6D00C929FDA46D4809812937", hash_generated_method = "9B99901F14687E210B002216F8C2690C")
    private void writeObject(
        ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.writeObject(this.getEncoded());
        out.writeObject(algorithm);
        out.writeBoolean(withCompression);
        // ---------- Original Method ----------
        //out.writeObject(this.getEncoded());
        //out.writeObject(algorithm);
        //out.writeBoolean(withCompression);
    }

    
}

