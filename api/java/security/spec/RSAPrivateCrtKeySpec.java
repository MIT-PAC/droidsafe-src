package java.security.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

public class RSAPrivateCrtKeySpec extends RSAPrivateKeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.000 -0400", hash_original_field = "81999BDC63C67199D52FF9A6FC17D274", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private BigInteger publicExponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.000 -0400", hash_original_field = "5CAE89F1C995D527BC63B2129AF4DDE3", hash_generated_field = "9A9C713E9D8E7513F2417C506E73722A")

    private BigInteger primeP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.001 -0400", hash_original_field = "8565D04C7B2E3A4F9CCECDAFEB1D3DEB", hash_generated_field = "9F91AA93693120FB89947F1BE699F0CA")

    private BigInteger primeQ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.001 -0400", hash_original_field = "BEA284D4C6E280CB3D7D7DDC3A6E3DBD", hash_generated_field = "D5FB562D58D86204E98F2195C5586E56")

    private BigInteger primeExponentP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.001 -0400", hash_original_field = "7EE47383E526EFBCB610960A9A10A2D7", hash_generated_field = "1ACB6AF17AD2472C87AB927F2F837C22")

    private BigInteger primeExponentQ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.001 -0400", hash_original_field = "43B12A29E2022039F04766599862BF35", hash_generated_field = "222659EB722B867F4069225DE0B214AA")

    private BigInteger crtCoefficient;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.003 -0400", hash_original_method = "ED8A111B4A0E8F9BE0E6693F37FD176F", hash_generated_method = "87C4762705CC223B1D5571024BD41BEF")
    public  RSAPrivateCrtKeySpec(BigInteger modulus,
                                BigInteger publicExponent,
                                BigInteger privateExponent,
                                BigInteger primeP,
                                BigInteger primeQ,
                                BigInteger primeExponentP,
                                BigInteger primeExponentQ,
                                BigInteger crtCoefficient) {
        super(modulus, privateExponent);
        addTaint(privateExponent.getTaint());
        addTaint(modulus.getTaint());
        this.publicExponent = publicExponent;
        this.primeP = primeP;
        this.primeQ = primeQ;
        this.primeExponentP = primeExponentP;
        this.primeExponentQ = primeExponentQ;
        this.crtCoefficient = crtCoefficient;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.003 -0400", hash_original_method = "ACBFCDB81BF18ABF0A77938A5EED41BC", hash_generated_method = "2A81288F2D5F1893DCD15FFDA6E65469")
    public BigInteger getCrtCoefficient() {
BigInteger varE176544C9DF7D922EBBC7594A3F6EDA9_1675677343 =         crtCoefficient;
        varE176544C9DF7D922EBBC7594A3F6EDA9_1675677343.addTaint(taint);
        return varE176544C9DF7D922EBBC7594A3F6EDA9_1675677343;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.003 -0400", hash_original_method = "F0E07FFA226AFDFA80184533230F10C0", hash_generated_method = "5485B9A7318F7137F06205D9DA5BDDE8")
    public BigInteger getPrimeExponentP() {
BigInteger varAA074CC88CC92AEA2D4E4081F7594053_391275279 =         primeExponentP;
        varAA074CC88CC92AEA2D4E4081F7594053_391275279.addTaint(taint);
        return varAA074CC88CC92AEA2D4E4081F7594053_391275279;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.004 -0400", hash_original_method = "E723F3703FB87A9BEB77BD8EB83B9C01", hash_generated_method = "3BDF7D2DE0BF9EE30F31F1F74CF5D702")
    public BigInteger getPrimeExponentQ() {
BigInteger var898B8E46AFF67FEE963239579DEFDFFC_464109959 =         primeExponentQ;
        var898B8E46AFF67FEE963239579DEFDFFC_464109959.addTaint(taint);
        return var898B8E46AFF67FEE963239579DEFDFFC_464109959;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.004 -0400", hash_original_method = "6B317E4DBB0CE4C27ED249BB287307E9", hash_generated_method = "95BD16221A3C412A40B917B5FBE0B880")
    public BigInteger getPrimeP() {
BigInteger var829C658792E2A4C4CA698B35893B0ED5_683769495 =         primeP;
        var829C658792E2A4C4CA698B35893B0ED5_683769495.addTaint(taint);
        return var829C658792E2A4C4CA698B35893B0ED5_683769495;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.004 -0400", hash_original_method = "A63916054BB1CFBFE5DBD277F62696D2", hash_generated_method = "BAB7C319DFE48E39A1AABA4C3B5C51C8")
    public BigInteger getPrimeQ() {
BigInteger varB065CE22BAA70D9D54312187FCC8B215_1639043277 =         primeQ;
        varB065CE22BAA70D9D54312187FCC8B215_1639043277.addTaint(taint);
        return varB065CE22BAA70D9D54312187FCC8B215_1639043277;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.004 -0400", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "D01EFA45A2C87DB75777B2D7FAEADA9E")
    public BigInteger getPublicExponent() {
BigInteger varB360105573401CCC465D10C242BA5623_1953915569 =         publicExponent;
        varB360105573401CCC465D10C242BA5623_1953915569.addTaint(taint);
        return varB360105573401CCC465D10C242BA5623_1953915569;
        
        
    }

    
}

