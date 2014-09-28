package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class BigInteger extends Number implements Comparable<BigInteger>, Serializable {

    /** Returns a {@code BigInteger} whose value is equal to {@code value}. */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.051 -0500", hash_original_method = "C2FDE5DE76618A54A899B2942400B087", hash_generated_method = "8E297D69B9A8CF458E31251DBFCB859D")
    
public static BigInteger valueOf(long value) {
        if (value < 0) {
            if (value != -1) {
                return new BigInteger(-1, -value);
            }
            return MINUS_ONE;
        } else if (value < SMALL_VALUES.length) {
            return SMALL_VALUES[(int) value];
        } else {// (value > 10)
            return new BigInteger(1, value);
        }
    }

    /**
     * Returns a random positive {@code BigInteger} instance in the range {@code
     * [0, pow(2, bitLength)-1]} which is probably prime. The probability that
     * the returned {@code BigInteger} is prime is beyond {@code
     * 1 - 1/pow(2, 80)}.
     *
     * <p><b>Implementation Note:</b> Currently {@code random} is ignored.
     *
     * @param bitLength length of the new {@code BigInteger} in bits.
     * @return probably prime random {@code BigInteger} instance.
     * @throws IllegalArgumentException if {@code bitLength < 2}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.160 -0500", hash_original_method = "6FBA03CFDD0A41CE705B7E15E5C549E4", hash_generated_method = "1DEA6F01370CA61EAEFEF50084B76202")
    
public static BigInteger probablePrime(int bitLength, Random unused) {
        return new BigInteger(bitLength, 100, unused);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.171 -0500", hash_original_method = "C7B24549F3F38126668B66F80A32808B", hash_generated_method = "D8C015B8260638A2E20D10D80BC5B8F4")
    
static int multiplyByInt(int[] res, int[] a, int aSize, int factor) {
        long carry = 0;

        for (int i = 0; i < aSize; i++) {
            carry += (a[i] & 0xFFFFFFFFL) * (factor & 0xFFFFFFFFL);
            res[i] = (int) carry;
            carry >>>= 32;
        }
        return (int) carry;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.173 -0500", hash_original_method = "705008DE67289C90705C837DB37F4C4C", hash_generated_method = "D38AAE882AD3DFA5EF106DD87127C5A3")
    
static int inplaceAdd(int[] a, int aSize, int addend) {
        long carry = addend & 0xFFFFFFFFL;

        for (int i = 0; (carry != 0) && (i < aSize); i++) {
            carry += a[i] & 0xFFFFFFFFL;
            a[i] = (int) carry;
            carry >>= 32;
        }
        return (int) carry;
    }

    /** @see BigInteger#BigInteger(String, int) */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.177 -0500", hash_original_method = "31C70867F91FE3CA68BF0BEC64F970DB", hash_generated_method = "46CFFD1E7ED44ACF51128B6AB195E08E")
    
private static void parseFromString(BigInteger bi, String value, int radix) {
        int stringLength = value.length();
        int endChar = stringLength;

        int sign;
        int startChar;
        if (value.charAt(0) == '-') {
            sign = -1;
            startChar = 1;
            stringLength--;
        } else {
            sign = 1;
            startChar = 0;
        }

        /*
         * We use the following algorithm: split a string into portions of n
         * characters and convert each portion to an integer according to the
         * radix. Then convert an pow(radix, n) based number to binary using the
         * multiplication method. See D. Knuth, The Art of Computer Programming,
         * vol. 2.
         */

        int charsPerInt = Conversion.digitFitInInt[radix];
        int bigRadixDigitsLength = stringLength / charsPerInt;
        int topChars = stringLength % charsPerInt;

        if (topChars != 0) {
            bigRadixDigitsLength++;
        }
        int[] digits = new int[bigRadixDigitsLength];
        // Get the maximal power of radix that fits in int
        int bigRadix = Conversion.bigRadices[radix - 2];
        // Parse an input string and accumulate the BigInteger's magnitude
        int digitIndex = 0; // index of digits array
        int substrEnd = startChar + ((topChars == 0) ? charsPerInt : topChars);

        for (int substrStart = startChar; substrStart < endChar;
                substrStart = substrEnd, substrEnd = substrStart + charsPerInt) {
            int bigRadixDigit = Integer.parseInt(value.substring(substrStart, substrEnd), radix);
            int newDigit = multiplyByInt(digits, digits, digitIndex, bigRadix);
            newDigit += inplaceAdd(digits, digitIndex, bigRadixDigit);
            digits[digitIndex++] = newDigit;
        }
        int numberLength = digitIndex;
        bi.setJavaRepresentation(sign, numberLength, digits);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.977 -0500", hash_original_field = "B01E34841DA096139E10133167649900", hash_generated_field = "ED603E28013A68CF87DC39EDA9672B96")

    private static final long serialVersionUID = -8287574255936472291L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.993 -0500", hash_original_field = "CA50B9D0BCD5064BDD77FC670208B1F5", hash_generated_field = "26A57E8798A6CA862A91D3C87254CE3F")

    public static final BigInteger ZERO = new BigInteger(0, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.996 -0500", hash_original_field = "1AADE90F051788EB1DD85F8A6A319562", hash_generated_field = "61E4C0227042D85901BA98B2F2CD52C4")

    public static final BigInteger ONE = new BigInteger(1, 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.998 -0500", hash_original_field = "FFC69B899AC608F823E147067B44A5DF", hash_generated_field = "7A2B2FAA86270609C420795EB3DF7501")

    public static final BigInteger TEN = new BigInteger(1, 10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.001 -0500", hash_original_field = "7C78BE1CDCF527B68CDE94B4D7113B40", hash_generated_field = "3BE0BD039FD8F547BF6DF239E6C29295")

    static final BigInteger MINUS_ONE = new BigInteger(-1, 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.003 -0500", hash_original_field = "0EAB5AFB684812FC0F688B1DFE4F6FE5", hash_generated_field = "17509E6A3C7F1A18AC1574943921E065")

    static final BigInteger[] SMALL_VALUES = { ZERO, ONE, new BigInteger(1, 2),
            new BigInteger(1, 3), new BigInteger(1, 4), new BigInteger(1, 5),
            new BigInteger(1, 6), new BigInteger(1, 7), new BigInteger(1, 8),
            new BigInteger(1, 9), TEN };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.979 -0500", hash_original_field = "8B1F11A189C33308C17EAC9DE1D9EB40", hash_generated_field = "1B931597CE47BECC94315E7FDFB3AE18")

    private transient BigInt bigInt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.981 -0500", hash_original_field = "30712829ABEB3E05826E08646BCD372A", hash_generated_field = "B1CF9FA5CC5896A14634587A7438CDD0")

    private transient boolean nativeIsValid = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.983 -0500", hash_original_field = "7D97B0F2E07AB4DED8E5B5C3EBD340B7", hash_generated_field = "36EDDB91E81C2B3A992259BBDA560C8D")

    private transient boolean javaIsValid = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.985 -0500", hash_original_field = "F3BACA7431BCD9B2A0C7C12B903D5C71", hash_generated_field = "EF92B8843E3664BCE02DEF9DAE8B81D8")

    transient int[] digits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.988 -0500", hash_original_field = "2F63ECB6611EB1219270D2FB208812B3", hash_generated_field = "49E386B29ED8E51F4B9308F78ED67301")

    transient int numberLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.990 -0500", hash_original_field = "D65D12C3CC2152F78FB95A1E5A36C1C1", hash_generated_field = "92BF56588B083F4EFC932B66DB92601C")

    transient int sign;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.006 -0500", hash_original_field = "75D237340EE54C075A6ACF28486040A5", hash_generated_field = "6063015DEF6F532F83AE577B35CA2F93")

    private transient int firstNonzeroDigit = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.009 -0500", hash_original_field = "E1768AECDAE6AFB2AD0365352B89B842", hash_generated_field = "9E963B134F5112D99A51A8B2403DC06B")

    private int signum;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.011 -0500", hash_original_field = "71109E1D8D34C5788914959F000A8066", hash_generated_field = "62EEE6A49B1745E7CDFD636319A9ED04")

    private byte[] magnitude;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.013 -0500", hash_original_field = "2257B8AF42139E78B9EB6F31816249E1", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.016 -0500", hash_original_method = "E2046ACAAE3FADB78A197B33030B87EF", hash_generated_method = "E2046ACAAE3FADB78A197B33030B87EF")
    
BigInteger(BigInt bigInt) {
        if (bigInt == null || bigInt.getNativeBIGNUM() == 0) {
            throw new AssertionError();
        }
        setBigInt(bigInt);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.019 -0500", hash_original_method = "6A0326FFA4F8DFD22C6BE505D4303A06", hash_generated_method = "6A0326FFA4F8DFD22C6BE505D4303A06")
    
BigInteger(int sign, long value) {
        BigInt bigInt = new BigInt();
        bigInt.putULongInt(value, (sign < 0));
        setBigInt(bigInt);
    }

    /**
     * Constructs a number without creating new space. This construct should be
     * used only if the three fields of representation are known.
     *
     * @param sign the sign of the number.
     * @param numberLength the length of the internal array.
     * @param digits a reference of some array created before.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.022 -0500", hash_original_method = "8FE766A630C587CF3D36C6776BEC57AB", hash_generated_method = "8FE766A630C587CF3D36C6776BEC57AB")
    
BigInteger(int sign, int numberLength, int[] digits) {
        setJavaRepresentation(sign, numberLength, digits);
    }

    /**
     * Constructs a random non-negative {@code BigInteger} instance in the range
     * {@code [0, pow(2, numBits)-1]}.
     *
     * @param numBits maximum length of the new {@code BigInteger} in bits.
     * @param random is the random number generator to be used.
     * @throws IllegalArgumentException if {@code numBits} < 0.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.025 -0500", hash_original_method = "0CDCBE4F35D9E336AD3EE0D0E2D0776D", hash_generated_method = "2F7712F0158E44CE9F92A42841FE1AB4")
    
public BigInteger(int numBits, Random random) {
        if (numBits < 0) {
            throw new IllegalArgumentException("numBits < 0: " + numBits);
        }
        if (numBits == 0) {
            setJavaRepresentation(0, 1, new int[] { 0 });
        } else {
            int sign = 1;
            int numberLength = (numBits + 31) >> 5;
            int[] digits = new int[numberLength];
            for (int i = 0; i < numberLength; i++) {
                digits[i] = random.nextInt();
            }
            // Using only the necessary bits
            digits[numberLength - 1] >>>= (-numBits) & 31;
            setJavaRepresentation(sign, numberLength, digits);
        }
        javaIsValid = true;
    }

    /**
     * Constructs a random {@code BigInteger} instance in the range {@code [0,
     * pow(2, bitLength)-1]} which is probably prime. The probability that the
     * returned {@code BigInteger} is prime is beyond
     * {@code 1 - 1/pow(2, certainty)}.
     *
     * <p><b>Implementation Note:</b> the {@code Random} argument is ignored.
     * This implementation uses OpenSSL's {@code bn_rand} as a source of
     * cryptographically strong pseudo-random numbers.
     *
     * @param bitLength length of the new {@code BigInteger} in bits.
     * @param certainty tolerated primality uncertainty.
     * @throws ArithmeticException if {@code bitLength < 2}.
     * @see <a href="http://www.openssl.org/docs/crypto/BN_rand.html">
     *      Specification of random generator used from OpenSSL library</a>
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.028 -0500", hash_original_method = "E06C60E93C7C91BB266029ED9C3D532A", hash_generated_method = "7FC5B6E46A83DACD171636A0E51EB749")
    
public BigInteger(int bitLength, int certainty, Random unused) {
        if (bitLength < 2) {
            throw new ArithmeticException("bitLength < 2: " + bitLength);
        }
        setBigInt(BigInt.generatePrimeDefault(bitLength));
    }

    /**
     * Constructs a new {@code BigInteger} by parsing {@code value}. The string
     * representation consists of an optional plus or minus sign followed by a
     * non-empty sequence of decimal digits. Digits are interpreted as if by
     * {@code Character.digit(char,10)}.
     *
     * @param value string representation of the new {@code BigInteger}.
     * @throws NullPointerException if {@code value == null}.
     * @throws NumberFormatException if {@code value} is not a valid
     *     representation of a {@code BigInteger}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.030 -0500", hash_original_method = "858DE6DF463E0F4BFB47F99F590AB0EF", hash_generated_method = "A6981D88CADD3487404EAED79DA2A6AB")
    
public BigInteger(String value) {
        BigInt bigInt = new BigInt();
        bigInt.putDecString(value);
        setBigInt(bigInt);
    }

    /**
     * Constructs a new {@code BigInteger} instance by parsing {@code value}.
     * The string representation consists of an optional plus or minus sign
     * followed by a non-empty sequence of digits in the specified radix. Digits
     * are interpreted as if by {@code Character.digit(char, radix)}.
     *
     * @param value string representation of the new {@code BigInteger}.
     * @param radix the base to be used for the conversion.
     * @throws NullPointerException if {@code value == null}.
     * @throws NumberFormatException if {@code value} is not a valid
     *     representation of a {@code BigInteger} or if {@code radix <
     *     Character.MIN_RADIX} or {@code radix > Character.MAX_RADIX}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.033 -0500", hash_original_method = "A13EC41ACC3DF589C11C4779074EEB6B", hash_generated_method = "512F685274ADAFAD6DD6C70AAD154DA0")
    
public BigInteger(String value, int radix) {
        if (value == null) {
            throw new NullPointerException("value == null");
        }
        if (radix == 10) {
            BigInt bigInt = new BigInt();
            bigInt.putDecString(value);
            setBigInt(bigInt);
        } else if (radix == 16) {
            BigInt bigInt = new BigInt();
            bigInt.putHexString(value);
            setBigInt(bigInt);
        } else {
            if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
                throw new NumberFormatException("Invalid radix: " + radix);
            }
            if (value.isEmpty()) {
                throw new NumberFormatException("value.isEmpty()");
            }
            BigInteger.parseFromString(this, value, radix);
        }
    }

    /**
     * Constructs a new {@code BigInteger} instance with the given sign and
     * magnitude.
     *
     * @param signum sign of the new {@code BigInteger} (-1 for negative, 0 for
     *     zero, 1 for positive).
     * @param magnitude magnitude of the new {@code BigInteger} with the most
     *     significant byte first.
     * @throws NullPointerException if {@code magnitude == null}.
     * @throws NumberFormatException if the sign is not one of -1, 0, 1 or if
     *     the sign is zero and the magnitude contains non-zero entries.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.037 -0500", hash_original_method = "4725614D4A9FDEE6DBC2F6DB247469CF", hash_generated_method = "B96FD7194735C121EFA04CE68919A4EF")
    
public BigInteger(int signum, byte[] magnitude) {
        if (magnitude == null) {
            throw new NullPointerException("magnitude == null");
        }
        if (signum < -1 || signum > 1) {
            throw new NumberFormatException("Invalid signum: " + signum);
        }
        if (signum == 0) {
            for (byte element : magnitude) {
                if (element != 0) {
                    throw new NumberFormatException("signum-magnitude mismatch");
                }
            }
        }
        BigInt bigInt = new BigInt();
        bigInt.putBigEndian(magnitude, signum < 0);
        setBigInt(bigInt);
    }

    /**
     * Constructs a new {@code BigInteger} from the given two's complement
     * representation. The most significant byte is the entry at index 0. The
     * most significant bit of this entry determines the sign of the new {@code
     * BigInteger} instance. The array must be nonempty.
     *
     * @param value two's complement representation of the new {@code
     *     BigInteger}.
     * @throws NullPointerException if {@code value == null}.
     * @throws NumberFormatException if the length of {@code value} is zero.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.039 -0500", hash_original_method = "ABB1E16F13BE7B2CA5EC1AADB52B2350", hash_generated_method = "7618596B4E57DE2491B9082339F7E9E1")
    
public BigInteger(byte[] value) {
        if (value.length == 0) {
            throw new NumberFormatException("value.length == 0");
        }
        BigInt bigInt = new BigInt();
        bigInt.putBigEndianTwosComplement(value);
        setBigInt(bigInt);
    }

    /**
     * Returns the internal native representation of this big integer, computing
     * it if necessary.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.042 -0500", hash_original_method = "7B92331634E6E3BE19D048B912B09B7F", hash_generated_method = "7B92331634E6E3BE19D048B912B09B7F")
    
BigInt getBigInt() {
        if (nativeIsValid) {
            return bigInt;
        }

        synchronized (this) {
            if (nativeIsValid) {
                return bigInt;
            }
            BigInt bigInt = new BigInt();
            bigInt.putLittleEndianInts(digits, (sign < 0));
            setBigInt(bigInt);
            return bigInt;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.044 -0500", hash_original_method = "CC364AFCED646D5BD618C239A0F61C61", hash_generated_method = "F99F31624AA27DC230F423194AAF8792")
    
private void setBigInt(BigInt bigInt) {
        this.bigInt = bigInt;
        this.nativeIsValid = true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.047 -0500", hash_original_method = "DA7CFD2DB9135F0E2C89139BCCCBB12F", hash_generated_method = "D7289D75A154A3BB4CB7F91CC59A7131")
    
private void setJavaRepresentation(int sign, int numberLength, int[] digits) {
        // decrement numberLength to drop leading zeroes...
        while (numberLength > 0 && digits[--numberLength] == 0) {
            ;
        }
        // ... and then increment it back because we always drop one too many
        if (digits[numberLength++] == 0) {
            sign = 0;
        }
        this.sign = sign;
        this.digits = digits;
        this.numberLength = numberLength;
        this.javaIsValid = true;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.049 -0500", hash_original_method = "E11A76F306D885B62849938EE7ACFF1F", hash_generated_method = "E11A76F306D885B62849938EE7ACFF1F")
    
void prepareJavaRepresentation() {
        if (javaIsValid) {
            return;
        }

        synchronized (this) {
            if (javaIsValid) {
                return;
            }
            int sign = bigInt.sign();
            int[] digits = (sign != 0) ? bigInt.littleEndianIntsMagnitude() : new int[] { 0 };
            setJavaRepresentation(sign, digits.length, digits);
        }
    }

    /**
     * Returns the two's complement representation of this {@code BigInteger} in
     * a byte array.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.054 -0500", hash_original_method = "F45D943577A758DE4A75A5CD2DF6D206", hash_generated_method = "892F82226DA47F44D2E09C61D62E2B3B")
    
public byte[] toByteArray() {
        return twosComplement();
    }

    /**
     * Returns a {@code BigInteger} whose value is the absolute value of {@code
     * this}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.057 -0500", hash_original_method = "4D099B3B9B18238917CAE07611FC89C9", hash_generated_method = "F267A5704272BE89EA3F7C35E712A701")
    
public BigInteger abs() {
        BigInt bigInt = getBigInt();
        if (bigInt.sign() >= 0) {
            return this;
        }
        BigInt a = bigInt.copy();
        a.setSign(1);
        return new BigInteger(a);
    }

    /**
     * Returns a {@code BigInteger} whose value is the {@code -this}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.059 -0500", hash_original_method = "DFABA71B5B9AE3E4CD65AD4AD666E31C", hash_generated_method = "0DAADEE6B9A5717095A88BAABC31792C")
    
public BigInteger negate() {
        BigInt bigInt = getBigInt();
        int sign = bigInt.sign();
        if (sign == 0) {
            return this;
        }
        BigInt a = bigInt.copy();
        a.setSign(-sign);
        return new BigInteger(a);
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this + value}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.062 -0500", hash_original_method = "5B8AB174D1647BD6610121BBBEE51EE5", hash_generated_method = "103D8A482482E26FF5F1931171C13AE9")
    
public BigInteger add(BigInteger value) {
        BigInt lhs = getBigInt();
        BigInt rhs = value.getBigInt();
        if (rhs.sign() == 0) {
            return this;
        }
        if (lhs.sign() == 0) {
            return value;
        }
        return new BigInteger(BigInt.addition(lhs, rhs));
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this - value}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.064 -0500", hash_original_method = "753BA04897A44EE33BA2055C50810858", hash_generated_method = "3DF9F62B067C971AA066D993B101E311")
    
public BigInteger subtract(BigInteger value) {
        BigInt lhs = getBigInt();
        BigInt rhs = value.getBigInt();
        if (rhs.sign() == 0) {
            return this;
        }
        return new BigInteger(BigInt.subtraction(lhs, rhs));
    }

    /**
     * Returns the sign of this {@code BigInteger}.
     *
     * @return {@code -1} if {@code this < 0}, {@code 0} if {@code this == 0},
     *     {@code 1} if {@code this > 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.067 -0500", hash_original_method = "0A534AADB97A9D37B49476B54B03D66A", hash_generated_method = "856FCB7A4FE9E3AA13F89CE08BE69761")
    
public int signum() {
        if (javaIsValid) {
            return sign;
        }
        return getBigInt().sign();
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this >> n}. For
     * negative arguments, the result is also negative. The shift distance may
     * be negative which means that {@code this} is shifted left.
     *
     * <p><b>Implementation Note:</b> Usage of this method on negative values is
     * not recommended as the current implementation is not efficient.
     *
     * @param n shift distance
     * @return {@code this >> n} if {@code n >= 0}; {@code this << (-n)}
     *     otherwise
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.069 -0500", hash_original_method = "1B97FA7BE1DE29423609E814DD90E66F", hash_generated_method = "656588917C69CA3E141F8FDB7B44B04D")
    
public BigInteger shiftRight(int n) {
        return shiftLeft(-n);
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this << n}. The
     * result is equivalent to {@code this * pow(2, n)} if n >= 0. The shift
     * distance may be negative which means that {@code this} is shifted right.
     * The result then corresponds to {@code floor(this / pow(2, -n))}.
     *
     * <p><b>Implementation Note:</b> Usage of this method on negative values is
     * not recommended as the current implementation is not efficient.
     *
     * @param n shift distance.
     * @return {@code this << n} if {@code n >= 0}; {@code this >> (-n)}.
     *     otherwise
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.071 -0500", hash_original_method = "3E0E92A5CC7CF6FE74FD251028917DBB", hash_generated_method = "E6946BA63A0F030FD3EA901FC686AE89")
    
public BigInteger shiftLeft(int n) {
        if (n == 0) {
            return this;
        }
        int sign = signum();
        if (sign == 0) {
            return this;
        }
        if ((sign > 0) || (n >= 0)) {
            return new BigInteger(BigInt.shift(getBigInt(), n));
        } else {
            // Negative numbers faking 2's complement:
            // Not worth optimizing this:
            // Sticking to Harmony Java implementation.
            return BitLevel.shiftRight(this, -n);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.073 -0500", hash_original_method = "3F948826829C47AB028976261F4B8D55", hash_generated_method = "3F948826829C47AB028976261F4B8D55")
    
BigInteger shiftLeftOneBit() {
        return (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
    }

    /**
     * Returns the length of the value's two's complement representation without
     * leading zeros for positive numbers / without leading ones for negative
     * values.
     *
     * <p>The two's complement representation of {@code this} will be at least
     * {@code bitLength() + 1} bits long.
     *
     * <p>The value will fit into an {@code int} if {@code bitLength() < 32} or
     * into a {@code long} if {@code bitLength() < 64}.
     *
     * @return the length of the minimal two's complement representation for
     *     {@code this} without the sign bit.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.075 -0500", hash_original_method = "5DD770E4600136986E52E3D1EE5F1B27", hash_generated_method = "192E350244C455B1F1EE9AC859003D57")
    
public int bitLength() {
        // Optimization to avoid unnecessary duplicate representation:
        if (!nativeIsValid && javaIsValid) {
            return BitLevel.bitLength(this);
        }
        return getBigInt().bitLength();
    }

    /**
     * Tests whether the bit at position n in {@code this} is set. The result is
     * equivalent to {@code this & pow(2, n) != 0}.
     *
     * <p><b>Implementation Note:</b> Usage of this method is not recommended as
     * the current implementation is not efficient.
     *
     * @param n position where the bit in {@code this} has to be inspected.
     * @throws ArithmeticException if {@code n < 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.079 -0500", hash_original_method = "22DB08B3CA9DDA99CEE301218284C513", hash_generated_method = "42D93F7A18894E577C30E77098DC5ACF")
    
public boolean testBit(int n) {
        if (n < 0) {
            throw new ArithmeticException("n < 0: " + n);
        }
        int sign = signum();
        if (sign > 0 && nativeIsValid && !javaIsValid) {
            return getBigInt().isBitSet(n);
        } else {
            // Negative numbers faking 2's complement:
            // Not worth optimizing this:
            // Sticking to Harmony Java implementation.
            prepareJavaRepresentation();
            if (n == 0) {
                return ((digits[0] & 1) != 0);
            }
            int intCount = n >> 5;
            if (intCount >= numberLength) {
                return (sign < 0);
            }
            int digit = digits[intCount];
            n = (1 << (n & 31)); // int with 1 set to the needed position
            if (sign < 0) {
                int firstNonZeroDigit = getFirstNonzeroDigit();
                if (intCount < firstNonZeroDigit) {
                    return false;
                } else if (firstNonZeroDigit == intCount) {
                    digit = -digit;
                } else {
                    digit = ~digit;
                }
            }
            return toTaintBoolean(((digit & n) + 0));
        }
    }

    /**
     * Returns a {@code BigInteger} which has the same binary representation
     * as {@code this} but with the bit at position n set. The result is
     * equivalent to {@code this | pow(2, n)}.
     *
     * <p><b>Implementation Note:</b> Usage of this method is not recommended as
     * the current implementation is not efficient.
     *
     * @param n position where the bit in {@code this} has to be set.
     * @throws ArithmeticException if {@code n < 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.082 -0500", hash_original_method = "0A60006224C30F0C8DC4E0C8D16895AE", hash_generated_method = "ACAC396F94B806A4371B9CBF03A7E39C")
    
public BigInteger setBit(int n) {
        prepareJavaRepresentation();
        if (!testBit(n)) {
            return BitLevel.flipBit(this, n);
        } else {
            return this;
        }
    }

    /**
     * Returns a {@code BigInteger} which has the same binary representation
     * as {@code this} but with the bit at position n cleared. The result is
     * equivalent to {@code this & ~pow(2, n)}.
     *
     * <p><b>Implementation Note:</b> Usage of this method is not recommended as
     * the current implementation is not efficient.
     *
     * @param n position where the bit in {@code this} has to be cleared.
     * @throws ArithmeticException if {@code n < 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.084 -0500", hash_original_method = "8D8C5374E542B708B8A1B41B31DCBF03", hash_generated_method = "1F3A4BBB87B20B5332690F48A5AD38BB")
    
public BigInteger clearBit(int n) {
        prepareJavaRepresentation();
        if (testBit(n)) {
            return BitLevel.flipBit(this, n);
        } else {
            return this;
        }
    }

    /**
     * Returns a {@code BigInteger} which has the same binary representation
     * as {@code this} but with the bit at position n flipped. The result is
     * equivalent to {@code this ^ pow(2, n)}.
     *
     * <p><b>Implementation Note:</b> Usage of this method is not recommended as
     * the current implementation is not efficient.
     *
     * @param n position where the bit in {@code this} has to be flipped.
     * @throws ArithmeticException if {@code n < 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.087 -0500", hash_original_method = "F1D37134A8936EE90081AD78D8487F59", hash_generated_method = "C7DADDCBCCB465B23BD13D33D74B5811")
    
public BigInteger flipBit(int n) {
        prepareJavaRepresentation();
        if (n < 0) {
            throw new ArithmeticException("n < 0: " + n);
        }
        return BitLevel.flipBit(this, n);
    }

    /**
     * Returns the position of the lowest set bit in the two's complement
     * representation of this {@code BigInteger}. If all bits are zero (this==0)
     * then -1 is returned as result.
     *
     * <p><b>Implementation Note:</b> Usage of this method is not recommended as
     * the current implementation is not efficient.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.089 -0500", hash_original_method = "8383F139074E92B6BF621C4AC408CB05", hash_generated_method = "0240D4D544EB0AB147B86F0291658CBB")
    
public int getLowestSetBit() {
        prepareJavaRepresentation();
        if (sign == 0) {
            return -1;
        }
        // (sign != 0) implies that exists some non zero digit
        int i = getFirstNonzeroDigit();
        return ((i << 5) + Integer.numberOfTrailingZeros(digits[i]));
    }

    /**
     * Returns the number of bits in the two's complement representation of
     * {@code this} which differ from the sign bit. If {@code this} is negative,
     * the result is equivalent to the number of bits set in the two's
     * complement representation of {@code -this - 1}.
     *
     * <p>Use {@code bitLength(0)} to find the length of the binary value in
     * bits.
     *
     * <p><b>Implementation Note:</b> Usage of this method is not recommended as
     * the current implementation is not efficient.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.092 -0500", hash_original_method = "2461573222D281ABCA9F3F34AA40AFB9", hash_generated_method = "F64C7C88C7C41750523497099266D5F6")
    
public int bitCount() {
        prepareJavaRepresentation();
        return BitLevel.bitCount(this);
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code ~this}. The result
     * of this operation is {@code -this-1}.
     *
     * <p><b>Implementation Note:</b> Usage of this method is not recommended as
     * the current implementation is not efficient.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.094 -0500", hash_original_method = "CD87C1AB82AE5BD1BDB1D71C1F7F211A", hash_generated_method = "1B04ABA877CCBD0E1E575DF189246C8A")
    
public BigInteger not() {
        this.prepareJavaRepresentation();
        return Logical.not(this);
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this & value}.
     *
     * <p><b>Implementation Note:</b> Usage of this method is not recommended
     * as the current implementation is not efficient.
     *
     * @param value value to be and'ed with {@code this}.
     * @throws NullPointerException if {@code value == null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.096 -0500", hash_original_method = "B57E8848F50ED2CEFC86EA20A70D185D", hash_generated_method = "E390F221FD3B6EFB2D6B188269692DED")
    
public BigInteger and(BigInteger value) {
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        return Logical.and(this, value);
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this | value}.
     *
     * <p><b>Implementation Note:</b> Usage of this method is not recommended as
     * the current implementation is not efficient.
     *
     * @param value value to be or'ed with {@code this}.
     * @throws NullPointerException if {@code value == null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.098 -0500", hash_original_method = "AED35BC9F3B39A40B35087479AE4F222", hash_generated_method = "AA97662B74EE0B943FFB5E59B870DADB")
    
public BigInteger or(BigInteger value) {
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        return Logical.or(this, value);
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this ^ value}.
     *
     * <p><b>Implementation Note:</b> Usage of this method is not recommended as
     * the current implementation is not efficient.
     *
     * @param value value to be xor'ed with {@code this}
     * @throws NullPointerException if {@code value == null}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.101 -0500", hash_original_method = "0162D315FD06686CC7830A3D5D5A796E", hash_generated_method = "0A09580D6374A9ABE6FD31506656DCA0")
    
public BigInteger xor(BigInteger value) {
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        return Logical.xor(this, value);
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this & ~value}.
     * Evaluating {@code x.andNot(value)} returns the same result as {@code
     * x.and(value.not())}.
     *
     * <p><b>Implementation Note:</b> Usage of this method is not recommended
     * as the current implementation is not efficient.
     *
     * @param value value to be not'ed and then and'ed with {@code this}.
     * @throws NullPointerException if {@code value == null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.103 -0500", hash_original_method = "A8A90B9F7EBADE4F51C070D1C780A515", hash_generated_method = "5C70BF6C4CC5266A2BD636C7E48B453C")
    
public BigInteger andNot(BigInteger value) {
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        return Logical.andNot(this, value);
    }

    /**
     * Returns this {@code BigInteger} as an int value. If {@code this} is too
     * big to be represented as an int, then {@code this % (1 << 32)} is
     * returned.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.106 -0500", hash_original_method = "F298334B66A6EA4DC89E250C44198AEA", hash_generated_method = "9DDA6B2A2F12A4C05D253F20B9180AC4")
    
@Override
    public int intValue() {
        if (nativeIsValid && bigInt.twosCompFitsIntoBytes(4)) {
            return (int) bigInt.longInt();
        }
        this.prepareJavaRepresentation();
        return (sign * digits[0]);
    }

    /**
     * Returns this {@code BigInteger} as a long value. If {@code this} is too
     * big to be represented as a long, then {@code this % pow(2, 64)} is
     * returned.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.108 -0500", hash_original_method = "22A0F6A18293749D1CD57F54133930DD", hash_generated_method = "1610A53DFCD3ED2ADE18A93892CE371C")
    
@Override
    public long longValue() {
        if (nativeIsValid && bigInt.twosCompFitsIntoBytes(8)) {
            return bigInt.longInt();
        }
        prepareJavaRepresentation();
        long value = numberLength > 1
                ? ((long) digits[1]) << 32 | digits[0] & 0xFFFFFFFFL
                : digits[0] & 0xFFFFFFFFL;
        return sign * value;
    }

    /**
     * Returns this {@code BigInteger} as a float. If {@code this} is too big to
     * be represented as a float, then {@code Float.POSITIVE_INFINITY} or
     * {@code Float.NEGATIVE_INFINITY} is returned. Note that not all integers
     * in the range {@code [-Float.MAX_VALUE, Float.MAX_VALUE]} can be exactly
     * represented as a float.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.112 -0500", hash_original_method = "85C514A29B5895D821780B89C4F747B0", hash_generated_method = "EB9D0F74036E443D5420C7383738933B")
    
@Override
    public float floatValue() {
        return (float) doubleValue();
    }

    /**
     * Returns this {@code BigInteger} as a double. If {@code this} is too big
     * to be represented as a double, then {@code Double.POSITIVE_INFINITY} or
     * {@code Double.NEGATIVE_INFINITY} is returned. Note that not all integers
     * in the range {@code [-Double.MAX_VALUE, Double.MAX_VALUE]} can be exactly
     * represented as a double.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.114 -0500", hash_original_method = "3D8E394E07D4F37AF2C6D72F08026A5D", hash_generated_method = "D629396A6EDE505B81D8E6B8EB7F3814")
    
@Override
    public double doubleValue() {
        return Conversion.bigInteger2Double(this);
    }

    /**
     * Compares this {@code BigInteger} with {@code value}. Returns {@code -1}
     * if {@code this < value}, {@code 0} if {@code this == value} and {@code 1}
     * if {@code this > value}, .
     *
     * @param value value to be compared with {@code this}.
     * @throws NullPointerException if {@code value == null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.116 -0500", hash_original_method = "2F090DBB15C308A00016A444F7C5A620", hash_generated_method = "C21FCBEDF67AB8AF884268698F8718F2")
    
public int compareTo(BigInteger value) {
        return BigInt.cmp(getBigInt(), value.getBigInt());
    }

    /**
     * Returns the minimum of this {@code BigInteger} and {@code value}.
     *
     * @param value value to be used to compute the minimum with {@code this}.
     * @throws NullPointerException if {@code value == null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.118 -0500", hash_original_method = "909F517DD4A19D55540D3A4577FBCF84", hash_generated_method = "5C92EFF1C1F33A8EB1F4975CD77C3033")
    
public BigInteger min(BigInteger value) {
        return this.compareTo(value) == -1 ? this : value;
    }

    /**
     * Returns the maximum of this {@code BigInteger} and {@code value}.
     *
     * @param value value to be used to compute the maximum with {@code this}
     * @throws NullPointerException if {@code value == null}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.120 -0500", hash_original_method = "6C03178B5A42138223A2B4814CF874FD", hash_generated_method = "C116E93F93ABE46D26A06EE08621C6DB")
    
public BigInteger max(BigInteger value) {
        return this.compareTo(value) == 1 ? this : value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.123 -0500", hash_original_method = "8BD8EE457DCE4BEA017BA4C9967BFC77", hash_generated_method = "BE401F1820219CC55E21186E99D412C6")
    
@Override
    public int hashCode() {
        if (hashCode != 0) {
            return hashCode;
        }
        prepareJavaRepresentation();
        for (int i = 0; i < numberLength; ++i) {
            hashCode = hashCode * 33 + digits[i];
        }
        hashCode = hashCode * sign;
        return hashCode;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.126 -0500", hash_original_method = "D6CA37529D0AAA6915B88189BBB9DE43", hash_generated_method = "0CC9EA60E16D743DDB1F6BE2883A119A")
    
@Override
    public boolean equals(Object x) {
        return super.equals(x);
        /*
        if (this == x) {
            return true;
        }
        if (x instanceof BigInteger) {
            return this.compareTo((BigInteger) x) == 0;
        }
        return false;
        */
    }

    /**
     * Returns a string representation of this {@code BigInteger} in decimal
     * form.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.128 -0500", hash_original_method = "466A78542936FDDF00F235F55782CDB1", hash_generated_method = "421A441E6AA1D509DDF5FF8DAE96CB1F")
    
@Override
    public String toString() {
        return getBigInt().decString();
    }

    /**
     * Returns a string containing a string representation of this {@code
     * BigInteger} with base radix. If {@code radix < Character.MIN_RADIX} or
     * {@code radix > Character.MAX_RADIX} then a decimal representation is
     * returned. The characters of the string representation are generated with
     * method {@code Character.forDigit}.
     *
     * @param radix base to be used for the string representation.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.131 -0500", hash_original_method = "DC1B34095F4DDEED7FED4CD9DAE6BCA6", hash_generated_method = "8F8708D79161CA0122992C46410E050E")
    
public String toString(int radix) {
        if (radix == 10) {
            return getBigInt().decString();
        } else {
            prepareJavaRepresentation();
            return Conversion.bigInteger2String(this, radix);
        }
    }

    /**
     * Returns a {@code BigInteger} whose value is greatest common divisor
     * of {@code this} and {@code value}. If {@code this == 0} and {@code
     * value == 0} then zero is returned, otherwise the result is positive.
     *
     * @param value value with which the greatest common divisor is computed.
     * @throws NullPointerException if {@code value == null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.133 -0500", hash_original_method = "DF6919CA8C1CE81A76193FCEFAE3FDAA", hash_generated_method = "CDBE34B46DA158574080440C88EE831F")
    
public BigInteger gcd(BigInteger value) {
        return new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this * value}.
     *
     * @throws NullPointerException if {@code value == null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.135 -0500", hash_original_method = "7A377385A7A35B42B025ADA39BD9F319", hash_generated_method = "30866C3D584C9FD0D8E1E20331A054D1")
    
public BigInteger multiply(BigInteger value) {
        return new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code pow(this, exp)}.
     *
     * @throws ArithmeticException if {@code exp < 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.138 -0500", hash_original_method = "670CEDEE32713500748765AA85174DA4", hash_generated_method = "61938CAEE76221E16000670B67270984")
    
public BigInteger pow(int exp) {
        if (exp < 0) {
            throw new ArithmeticException("exp < 0: " + exp);
        }
        return new BigInteger(BigInt.exp(getBigInt(), exp));
    }

    /**
     * Returns a two element {@code BigInteger} array containing
     * {@code this / divisor} at index 0 and {@code this % divisor} at index 1.
     *
     * @param divisor value by which {@code this} is divided.
     * @throws NullPointerException if {@code divisor == null}.
     * @throws ArithmeticException if {@code divisor == 0}.
     * @see #divide
     * @see #remainder
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.140 -0500", hash_original_method = "0021B26ACCFD58807A129BEBBFC75B78", hash_generated_method = "E00BFCA0776B1CA9E1F471AB2D0D4B41")
    
public BigInteger[] divideAndRemainder(BigInteger divisor) {
        BigInt divisorBigInt = divisor.getBigInt();
        BigInt quotient = new BigInt();
        BigInt remainder = new BigInt();
        BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        return new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this / divisor}.
     *
     * @param divisor value by which {@code this} is divided.
     * @return {@code this / divisor}.
     * @throws NullPointerException if {@code divisor == null}.
     * @throws ArithmeticException if {@code divisor == 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.142 -0500", hash_original_method = "E605E3D77E9B13D877DA6B6F47D67F1F", hash_generated_method = "D5D26022F0F6A11E4AF524D9EEDC2535")
    
public BigInteger divide(BigInteger divisor) {
        BigInt quotient = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        return new BigInteger(quotient);
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this % divisor}.
     * Regarding signs this methods has the same behavior as the % operator on
     * ints: the sign of the remainder is the same as the sign of this.
     *
     * @param divisor value by which {@code this} is divided.
     * @throws NullPointerException if {@code divisor == null}.
     * @throws ArithmeticException if {@code divisor == 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.145 -0500", hash_original_method = "FFD2A7C70BA79F9B512531A9A18B49EF", hash_generated_method = "FEA3D5B4B405A1B443FCFE74B856F0D9")
    
public BigInteger remainder(BigInteger divisor) {
        BigInt remainder = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        return new BigInteger(remainder);
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code 1/this mod m}. The
     * modulus {@code m} must be positive. The result is guaranteed to be in the
     * interval {@code [0, m)} (0 inclusive, m exclusive). If {@code this} is
     * not relatively prime to m, then an exception is thrown.
     *
     * @param m the modulus.
     * @throws NullPointerException if {@code m == null}
     * @throws ArithmeticException if {@code m < 0 or} if {@code this} is not
     *     relatively prime to {@code m}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.147 -0500", hash_original_method = "D09D0373DFB5DF67EDACA66D474BB75C", hash_generated_method = "C0A22361EA7D0B8CF8F11B6A6CE200D2")
    
public BigInteger modInverse(BigInteger m) {
        if (m.signum() <= 0) {
            throw new ArithmeticException("modulus not positive");
        }
        return new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code
     * pow(this, exponent) mod m}. The modulus {@code m} must be positive. The
     * result is guaranteed to be in the interval {@code [0, m)} (0 inclusive,
     * m exclusive). If the exponent is negative, then {@code
     * pow(this.modInverse(m), -exponent) mod m} is computed. The inverse of
     * this only exists if {@code this} is relatively prime to m, otherwise an
     * exception is thrown.
     *
     * @param exponent the exponent.
     * @param m the modulus.
     * @throws NullPointerException if {@code m == null} or {@code exponent ==
     *     null}.
     * @throws ArithmeticException if {@code m < 0} or if {@code exponent<0} and
     *     this is not relatively prime to {@code m}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.150 -0500", hash_original_method = "4B2E2C43A8E0C70699BFC0E4EF01E685", hash_generated_method = "AF4A51DDF39A18F0E3B3D580E15CA1E0")
    
public BigInteger modPow(BigInteger exponent, BigInteger m) {
        if (m.signum() <= 0) {
            throw new ArithmeticException("m.signum() <= 0");
        }
        BigInteger base = exponent.signum() < 0 ? modInverse(m) : this;
        return new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
    }

    /**
     * Returns a {@code BigInteger} whose value is {@code this mod m}. The
     * modulus {@code m} must be positive. The result is guaranteed to be in the
     * interval {@code [0, m)} (0 inclusive, m exclusive). The behavior of this
     * function is not equivalent to the behavior of the % operator defined for
     * the built-in {@code int}'s.
     *
     * @param m the modulus.
     * @return {@code this mod m}.
     * @throws NullPointerException if {@code m == null}.
     * @throws ArithmeticException if {@code m < 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.153 -0500", hash_original_method = "ADC51A8E4A4079F65268593A33DD74A7", hash_generated_method = "2A32F2698B2E1BF4EF5F20921E427818")
    
public BigInteger mod(BigInteger m) {
        if (m.signum() <= 0) {
            throw new ArithmeticException("m.signum() <= 0");
        }
        return new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
    }

    /**
     * Tests whether this {@code BigInteger} is probably prime. If {@code true}
     * is returned, then this is prime with a probability beyond
     * {@code 1 - 1/pow(2, certainty)}. If {@code false} is returned, then this
     * is definitely composite. If the argument {@code certainty} <= 0, then
     * this method returns true.
     *
     * @param certainty tolerated primality uncertainty.
     * @return {@code true}, if {@code this} is probably prime, {@code false}
     *     otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.155 -0500", hash_original_method = "718D211034BAE1DECACA1D72CB4CBB13", hash_generated_method = "9014EEE3DE13F78749233CE2CB1EE311")
    
public boolean isProbablePrime(int certainty) {
        if (certainty <= 0) {
            return true;
        }
        return getBigInt().isPrime(certainty);
    }

    /**
     * Returns the smallest integer x > {@code this} which is probably prime as
     * a {@code BigInteger} instance. The probability that the returned {@code
     * BigInteger} is prime is beyond {@code 1 - 1/pow(2, 80)}.
     *
     * @return smallest integer > {@code this} which is probably prime.
     * @throws ArithmeticException if {@code this < 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.158 -0500", hash_original_method = "BB43921F4E806BD72B6F518E8CD8937B", hash_generated_method = "781AC6B567CB4C8CBD356ED7D329BD87")
    
public BigInteger nextProbablePrime() {
        if (sign < 0) {
            throw new ArithmeticException("sign < 0");
        }
        return Primality.nextProbablePrime(this);
    }

    /* Private Methods */

    /**
     * Returns the two's complement representation of this BigInteger in a byte
     * array.
     *
     * @return two's complement representation of {@code this}
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.168 -0500", hash_original_method = "F2F8EDC382104DB344E8DD617201B0F3", hash_generated_method = "578DBC5A309B191CCA3B03F182C709DB")
    
private byte[] twosComplement() {
        prepareJavaRepresentation();
        if (this.sign == 0) {
            return new byte[] { 0 };
        }
        BigInteger temp = this;
        int bitLen = bitLength();
        int iThis = getFirstNonzeroDigit();
        int bytesLen = (bitLen >> 3) + 1;
        /* Puts the little-endian int array representing the magnitude
         * of this BigInteger into the big-endian byte array. */
        byte[] bytes = new byte[bytesLen];
        int firstByteNumber = 0;
        int highBytes;
        int bytesInInteger = 4;
        int hB;

        if (bytesLen - (numberLength << 2) == 1) {
            bytes[0] = (byte) ((sign < 0) ? -1 : 0);
            highBytes = 4;
            firstByteNumber++;
        } else {
            hB = bytesLen & 3;
            highBytes = (hB == 0) ? 4 : hB;
        }

        int digitIndex = iThis;
        bytesLen -= iThis << 2;

        if (sign < 0) {
            int digit = -temp.digits[digitIndex];
            digitIndex++;
            if (digitIndex == numberLength) {
                bytesInInteger = highBytes;
            }
            for (int i = 0; i < bytesInInteger; i++, digit >>= 8) {
                bytes[--bytesLen] = (byte) digit;
            }
            while (bytesLen > firstByteNumber) {
                digit = ~temp.digits[digitIndex];
                digitIndex++;
                if (digitIndex == numberLength) {
                    bytesInInteger = highBytes;
                }
                for (int i = 0; i < bytesInInteger; i++, digit >>= 8) {
                    bytes[--bytesLen] = (byte) digit;
                }
            }
        } else {
            while (bytesLen > firstByteNumber) {
                int digit = temp.digits[digitIndex];
                digitIndex++;
                if (digitIndex == numberLength) {
                    bytesInInteger = highBytes;
                }
                for (int i = 0; i < bytesInInteger; i++, digit >>= 8) {
                    bytes[--bytesLen] = (byte) digit;
                }
            }
        }
        return bytes;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.179 -0500", hash_original_method = "4BA60B28A036933466CC713B9C7854B3", hash_generated_method = "4BA60B28A036933466CC713B9C7854B3")
    
int getFirstNonzeroDigit() {
        if (firstNonzeroDigit == -2) {
            int i;
            if (this.sign == 0) {
                i = -1;
            } else {
                for (i = 0; digits[i] == 0; i++) {
                    ;
                }
            }
            firstNonzeroDigit = i;
        }
        return firstNonzeroDigit;
    }

    /**
     * Returns a copy of the current instance to achieve immutability
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.182 -0500", hash_original_method = "FABC86F56C336DE2152BE8F133BAAD74", hash_generated_method = "FABC86F56C336DE2152BE8F133BAAD74")
    
BigInteger copy() {
        prepareJavaRepresentation();
        int[] copyDigits = new int[numberLength];
        System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        return new BigInteger(sign, numberLength, copyDigits);
    }

    /**
     * Assigns all transient fields upon deserialization of a {@code BigInteger}
     * instance.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.184 -0500", hash_original_method = "883E43F5C4566D0C2A7853533F533817", hash_generated_method = "AFBDC3B47733A92EEE74A03B880D61E5")
    
private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        BigInt bigInt = new BigInt();
        bigInt.putBigEndian(magnitude, signum < 0);
        setBigInt(bigInt);
    }

    /**
     * Prepares this {@code BigInteger} for serialization, i.e. the
     * non-transient fields {@code signum} and {@code magnitude} are assigned.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:39.188 -0500", hash_original_method = "4837A11F07A86A58815A56F1112D57DF", hash_generated_method = "117E8CA6F67089DBC4DFDF974A3BB8D1")
    
private void writeObject(ObjectOutputStream out) throws IOException {
        BigInt bigInt = getBigInt();
        signum = bigInt.sign();
        magnitude = bigInt.bigEndianMagnitude();
        out.defaultWriteObject();
    }
}

