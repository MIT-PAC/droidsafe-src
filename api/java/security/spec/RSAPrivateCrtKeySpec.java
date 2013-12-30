package java.security.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;






public class RSAPrivateCrtKeySpec extends RSAPrivateKeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.103 -0500", hash_original_field = "DB6D44C8A44BDBF62F098CD0EF0F38F6", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private  BigInteger publicExponent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.106 -0500", hash_original_field = "7A3E1BB8B91AABDAC8096A6AF946B79F", hash_generated_field = "9A9C713E9D8E7513F2417C506E73722A")

    private  BigInteger primeP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.108 -0500", hash_original_field = "1C81CE9A16FD4AC10BD085B1B94422AB", hash_generated_field = "9F91AA93693120FB89947F1BE699F0CA")

    private  BigInteger primeQ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.110 -0500", hash_original_field = "40B3FB6881B01131E42A79EC00848D20", hash_generated_field = "D5FB562D58D86204E98F2195C5586E56")

    private  BigInteger primeExponentP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.112 -0500", hash_original_field = "6467AFAE24BDCED779196424DCB2176F", hash_generated_field = "1ACB6AF17AD2472C87AB927F2F837C22")

    private  BigInteger primeExponentQ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.115 -0500", hash_original_field = "A68F5C4250913ADDC701F6FCEA9C0282", hash_generated_field = "222659EB722B867F4069225DE0B214AA")

    private  BigInteger crtCoefficient;

    /**
     * Creates a new {@code RSAMultiPrimePrivateCrtKeySpec} with the specified
     * modulus, public exponent, private exponent, prime factors, prime
     * exponents, crt coefficient, and additional primes.
     *
     * @param modulus
     *            the modulus {@code n}.
     * @param publicExponent
     *            the public exponent {@code e}.
     * @param privateExponent
     *            the private exponent {@code d}.
     * @param primeP
     *            the prime factor {@code p} of {@code n}.
     * @param primeQ
     *            the prime factor {@code q} of {@code n}.
     * @param primeExponentP
     *            the exponent of the prime {@code p}.
     * @param primeExponentQ
     *            the exponent of the prime {@code q}.
     * @param crtCoefficient
     *            the CRT coefficient {@code q^-1 mod p}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.118 -0500", hash_original_method = "ED8A111B4A0E8F9BE0E6693F37FD176F", hash_generated_method = "79E1A9916628D4F24E80E6549FF22414")
    
public RSAPrivateCrtKeySpec(BigInteger modulus,
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
    }

    /**
     * Returns the CRT coefficient, {@code q^-1 mod p}.
     *
     * @return the CRT coefficient, {@code q^-1 mod p}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.121 -0500", hash_original_method = "ACBFCDB81BF18ABF0A77938A5EED41BC", hash_generated_method = "97EDEC99BD89F3C3B898907864A5969A")
    
public BigInteger getCrtCoefficient() {
        return crtCoefficient;
    }

    /**
     * Returns the exponent of the prime {@code p}.
     *
     * @return the exponent of the prime {@code p}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.123 -0500", hash_original_method = "F0E07FFA226AFDFA80184533230F10C0", hash_generated_method = "B8F125E28DD971AB2A14227701C3ACA8")
    
public BigInteger getPrimeExponentP() {
        return primeExponentP;
    }

    /**
     * Returns the exponent of the prime {@code q}.
     *
     * @return the exponent of the prime {@code q}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.125 -0500", hash_original_method = "E723F3703FB87A9BEB77BD8EB83B9C01", hash_generated_method = "DB4AA43C17AF6D85BD5E97574992AC14")
    
public BigInteger getPrimeExponentQ() {
        return primeExponentQ;
    }

    /**
     * Returns the prime factor {@code p}.
     *
     * @return the prime factor {@code p}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.128 -0500", hash_original_method = "6B317E4DBB0CE4C27ED249BB287307E9", hash_generated_method = "C754147F7132081FF985241C8123FDC5")
    
public BigInteger getPrimeP() {
        return primeP;
    }

    /**
     * Returns the prime factor {@code q}.
     *
     * @return the prime factor {@code q}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.130 -0500", hash_original_method = "A63916054BB1CFBFE5DBD277F62696D2", hash_generated_method = "A67CBA40F2C5DB2C9FE6FFCCBCB86CBC")
    
public BigInteger getPrimeQ() {
        return primeQ;
    }

    /**
     * Returns the public exponent {@code e}.
     *
     * @return the public exponent {@code e}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.133 -0500", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "CDD9969A60E00BAEF22FCCEA56318047")
    
public BigInteger getPublicExponent() {
        return publicExponent;
    }

    
}

