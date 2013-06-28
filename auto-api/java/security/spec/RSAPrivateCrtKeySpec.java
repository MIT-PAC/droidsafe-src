package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

public class RSAPrivateCrtKeySpec extends RSAPrivateKeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.127 -0400", hash_original_field = "81999BDC63C67199D52FF9A6FC17D274", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private BigInteger publicExponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.127 -0400", hash_original_field = "5CAE89F1C995D527BC63B2129AF4DDE3", hash_generated_field = "9A9C713E9D8E7513F2417C506E73722A")

    private BigInteger primeP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.127 -0400", hash_original_field = "8565D04C7B2E3A4F9CCECDAFEB1D3DEB", hash_generated_field = "9F91AA93693120FB89947F1BE699F0CA")

    private BigInteger primeQ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.127 -0400", hash_original_field = "BEA284D4C6E280CB3D7D7DDC3A6E3DBD", hash_generated_field = "D5FB562D58D86204E98F2195C5586E56")

    private BigInteger primeExponentP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.127 -0400", hash_original_field = "7EE47383E526EFBCB610960A9A10A2D7", hash_generated_field = "1ACB6AF17AD2472C87AB927F2F837C22")

    private BigInteger primeExponentQ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.127 -0400", hash_original_field = "43B12A29E2022039F04766599862BF35", hash_generated_field = "222659EB722B867F4069225DE0B214AA")

    private BigInteger crtCoefficient;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.127 -0400", hash_original_method = "ED8A111B4A0E8F9BE0E6693F37FD176F", hash_generated_method = "52AF83CC7046EBA10510264A621798E5")
    public  RSAPrivateCrtKeySpec(BigInteger modulus,
                                BigInteger publicExponent,
                                BigInteger privateExponent,
                                BigInteger primeP,
                                BigInteger primeQ,
                                BigInteger primeExponentP,
                                BigInteger primeExponentQ,
                                BigInteger crtCoefficient) {
        super(modulus, privateExponent);
        this.publicExponent = publicExponent;
        this.primeP = primeP;
        this.primeQ = primeQ;
        this.primeExponentP = primeExponentP;
        this.primeExponentQ = primeExponentQ;
        this.crtCoefficient = crtCoefficient;
        addTaint(modulus.getTaint());
        addTaint(privateExponent.getTaint());
        // ---------- Original Method ----------
        //this.publicExponent = publicExponent;
        //this.primeP = primeP;
        //this.primeQ = primeQ;
        //this.primeExponentP = primeExponentP;
        //this.primeExponentQ = primeExponentQ;
        //this.crtCoefficient = crtCoefficient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.128 -0400", hash_original_method = "ACBFCDB81BF18ABF0A77938A5EED41BC", hash_generated_method = "1A58E007628812B14319193DDE9EC3E3")
    public BigInteger getCrtCoefficient() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1792385014 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1792385014 = crtCoefficient;
        varB4EAC82CA7396A68D541C85D26508E83_1792385014.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1792385014;
        // ---------- Original Method ----------
        //return crtCoefficient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.128 -0400", hash_original_method = "F0E07FFA226AFDFA80184533230F10C0", hash_generated_method = "29CA8ADAE30E20D0F753B562B860F93D")
    public BigInteger getPrimeExponentP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1342357301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1342357301 = primeExponentP;
        varB4EAC82CA7396A68D541C85D26508E83_1342357301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1342357301;
        // ---------- Original Method ----------
        //return primeExponentP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.129 -0400", hash_original_method = "E723F3703FB87A9BEB77BD8EB83B9C01", hash_generated_method = "82EAAB5E2B679AFEC52C2638646742A9")
    public BigInteger getPrimeExponentQ() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_927713726 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_927713726 = primeExponentQ;
        varB4EAC82CA7396A68D541C85D26508E83_927713726.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_927713726;
        // ---------- Original Method ----------
        //return primeExponentQ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.130 -0400", hash_original_method = "6B317E4DBB0CE4C27ED249BB287307E9", hash_generated_method = "7355A89FA5FE6434032F7749CEFB7343")
    public BigInteger getPrimeP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_891418310 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_891418310 = primeP;
        varB4EAC82CA7396A68D541C85D26508E83_891418310.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_891418310;
        // ---------- Original Method ----------
        //return primeP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.130 -0400", hash_original_method = "A63916054BB1CFBFE5DBD277F62696D2", hash_generated_method = "961AE284E543405D0AEBEC217C1D0D3D")
    public BigInteger getPrimeQ() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_48042894 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_48042894 = primeQ;
        varB4EAC82CA7396A68D541C85D26508E83_48042894.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_48042894;
        // ---------- Original Method ----------
        //return primeQ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.131 -0400", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "00F3811C9A36DB35E48D00499DEF0447")
    public BigInteger getPublicExponent() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_516932052 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_516932052 = publicExponent;
        varB4EAC82CA7396A68D541C85D26508E83_516932052.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_516932052;
        // ---------- Original Method ----------
        //return publicExponent;
    }

    
}

