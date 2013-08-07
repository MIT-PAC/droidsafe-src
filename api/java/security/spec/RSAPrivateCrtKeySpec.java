package java.security.spec;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.math.BigInteger;






public class RSAPrivateCrtKeySpec extends RSAPrivateKeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.103 -0400", hash_original_field = "81999BDC63C67199D52FF9A6FC17D274", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private BigInteger publicExponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.103 -0400", hash_original_field = "5CAE89F1C995D527BC63B2129AF4DDE3", hash_generated_field = "9A9C713E9D8E7513F2417C506E73722A")

    private BigInteger primeP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.103 -0400", hash_original_field = "8565D04C7B2E3A4F9CCECDAFEB1D3DEB", hash_generated_field = "9F91AA93693120FB89947F1BE699F0CA")

    private BigInteger primeQ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.103 -0400", hash_original_field = "BEA284D4C6E280CB3D7D7DDC3A6E3DBD", hash_generated_field = "D5FB562D58D86204E98F2195C5586E56")

    private BigInteger primeExponentP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.103 -0400", hash_original_field = "7EE47383E526EFBCB610960A9A10A2D7", hash_generated_field = "1ACB6AF17AD2472C87AB927F2F837C22")

    private BigInteger primeExponentQ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.103 -0400", hash_original_field = "43B12A29E2022039F04766599862BF35", hash_generated_field = "222659EB722B867F4069225DE0B214AA")

    private BigInteger crtCoefficient;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.106 -0400", hash_original_method = "ED8A111B4A0E8F9BE0E6693F37FD176F", hash_generated_method = "87C4762705CC223B1D5571024BD41BEF")
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
        // ---------- Original Method ----------
        //this.publicExponent = publicExponent;
        //this.primeP = primeP;
        //this.primeQ = primeQ;
        //this.primeExponentP = primeExponentP;
        //this.primeExponentQ = primeExponentQ;
        //this.crtCoefficient = crtCoefficient;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.106 -0400", hash_original_method = "ACBFCDB81BF18ABF0A77938A5EED41BC", hash_generated_method = "FA78165591828075DF0CF5E788C657DB")
    public BigInteger getCrtCoefficient() {
BigInteger varE176544C9DF7D922EBBC7594A3F6EDA9_1795691470 =         crtCoefficient;
        varE176544C9DF7D922EBBC7594A3F6EDA9_1795691470.addTaint(taint);
        return varE176544C9DF7D922EBBC7594A3F6EDA9_1795691470;
        // ---------- Original Method ----------
        //return crtCoefficient;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.107 -0400", hash_original_method = "F0E07FFA226AFDFA80184533230F10C0", hash_generated_method = "091023A54E49AE1397B54EE46F05492E")
    public BigInteger getPrimeExponentP() {
BigInteger varAA074CC88CC92AEA2D4E4081F7594053_2137870917 =         primeExponentP;
        varAA074CC88CC92AEA2D4E4081F7594053_2137870917.addTaint(taint);
        return varAA074CC88CC92AEA2D4E4081F7594053_2137870917;
        // ---------- Original Method ----------
        //return primeExponentP;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.107 -0400", hash_original_method = "E723F3703FB87A9BEB77BD8EB83B9C01", hash_generated_method = "061F946B2557D61B2B3B56339F8AED89")
    public BigInteger getPrimeExponentQ() {
BigInteger var898B8E46AFF67FEE963239579DEFDFFC_1643142875 =         primeExponentQ;
        var898B8E46AFF67FEE963239579DEFDFFC_1643142875.addTaint(taint);
        return var898B8E46AFF67FEE963239579DEFDFFC_1643142875;
        // ---------- Original Method ----------
        //return primeExponentQ;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.108 -0400", hash_original_method = "6B317E4DBB0CE4C27ED249BB287307E9", hash_generated_method = "4A6CEDECBF9F8098AD08C5016D0DF330")
    public BigInteger getPrimeP() {
BigInteger var829C658792E2A4C4CA698B35893B0ED5_1277080451 =         primeP;
        var829C658792E2A4C4CA698B35893B0ED5_1277080451.addTaint(taint);
        return var829C658792E2A4C4CA698B35893B0ED5_1277080451;
        // ---------- Original Method ----------
        //return primeP;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.108 -0400", hash_original_method = "A63916054BB1CFBFE5DBD277F62696D2", hash_generated_method = "EFC507D6128B2D4A35834862FC9FA1B4")
    public BigInteger getPrimeQ() {
BigInteger varB065CE22BAA70D9D54312187FCC8B215_986584559 =         primeQ;
        varB065CE22BAA70D9D54312187FCC8B215_986584559.addTaint(taint);
        return varB065CE22BAA70D9D54312187FCC8B215_986584559;
        // ---------- Original Method ----------
        //return primeQ;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.109 -0400", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "A02111D23A34263F6E5D193258528B3E")
    public BigInteger getPublicExponent() {
BigInteger varB360105573401CCC465D10C242BA5623_49709895 =         publicExponent;
        varB360105573401CCC465D10C242BA5623_49709895.addTaint(taint);
        return varB360105573401CCC465D10C242BA5623_49709895;
        // ---------- Original Method ----------
        //return publicExponent;
    }

    
}

