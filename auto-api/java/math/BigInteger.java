package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class BigInteger extends Number implements Comparable<BigInteger>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.527 -0400", hash_original_field = "33A2DB2A239C5BAAA46376495EE5F6ED", hash_generated_field = "1B931597CE47BECC94315E7FDFB3AE18")

    private transient BigInt bigInt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.527 -0400", hash_original_field = "F0121707B716C3D41C45CEC890F8FEBD", hash_generated_field = "B1CF9FA5CC5896A14634587A7438CDD0")

    private transient boolean nativeIsValid = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.527 -0400", hash_original_field = "562B560548EAC394A69BD390BABAEBE5", hash_generated_field = "36EDDB91E81C2B3A992259BBDA560C8D")

    private transient boolean javaIsValid = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.527 -0400", hash_original_field = "A2AACBD15B619A9B9E5581A6C33BD2B1", hash_generated_field = "EF92B8843E3664BCE02DEF9DAE8B81D8")

    transient int[] digits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.527 -0400", hash_original_field = "56F736C2BD891F3A00F34C71E5AD8378", hash_generated_field = "49E386B29ED8E51F4B9308F78ED67301")

    transient int numberLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.527 -0400", hash_original_field = "04B29480233F4DEF5C875875B6BDC3B1", hash_generated_field = "92BF56588B083F4EFC932B66DB92601C")

    transient int sign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.527 -0400", hash_original_field = "553C03BFED44A9505466470F56E3ADC5", hash_generated_field = "6063015DEF6F532F83AE577B35CA2F93")

    private transient int firstNonzeroDigit = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.527 -0400", hash_original_field = "327B0A3531EA3D97749FE579CC4632A4", hash_generated_field = "9E963B134F5112D99A51A8B2403DC06B")

    private int signum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.527 -0400", hash_original_field = "28C3D8F4B7E312AF5E0D6B59A50EFD1C", hash_generated_field = "62EEE6A49B1745E7CDFD636319A9ED04")

    private byte[] magnitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.527 -0400", hash_original_field = "B81E47D2AA677809E4BE3C9232B2407F", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.528 -0400", hash_original_method = "E2046ACAAE3FADB78A197B33030B87EF", hash_generated_method = "2D4C2A18CF2E929A950786C145C59844")
      BigInteger(BigInt bigInt) {
        {
            boolean varCBCE59BC652D0587CC25D4F0C19CC324_1610908485 = (bigInt == null || bigInt.getNativeBIGNUM() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
        } //End collapsed parenthetic
        setBigInt(bigInt);
        addTaint(bigInt.getTaint());
        // ---------- Original Method ----------
        //if (bigInt == null || bigInt.getNativeBIGNUM() == 0) {
            //throw new AssertionError();
        //}
        //setBigInt(bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.529 -0400", hash_original_method = "6A0326FFA4F8DFD22C6BE505D4303A06", hash_generated_method = "55FCDBFB4835752CB686FAA9AE63931C")
      BigInteger(int sign, long value) {
        BigInt bigInt;
        bigInt = new BigInt();
        bigInt.putULongInt(value, (sign < 0));
        setBigInt(bigInt);
        addTaint(sign);
        addTaint(value);
        // ---------- Original Method ----------
        //BigInt bigInt = new BigInt();
        //bigInt.putULongInt(value, (sign < 0));
        //setBigInt(bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.529 -0400", hash_original_method = "8FE766A630C587CF3D36C6776BEC57AB", hash_generated_method = "9D5A992E0E61ADC1EA67DF0D6E21AF4A")
      BigInteger(int sign, int numberLength, int[] digits) {
        setJavaRepresentation(sign, numberLength, digits);
        addTaint(sign);
        addTaint(numberLength);
        addTaint(digits[0]);
        // ---------- Original Method ----------
        //setJavaRepresentation(sign, numberLength, digits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.533 -0400", hash_original_method = "0CDCBE4F35D9E336AD3EE0D0E2D0776D", hash_generated_method = "448A70D33081051C8A47ABC82B816F43")
    public  BigInteger(int numBits, Random random) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("numBits < 0: " + numBits);
        } //End block
        {
            setJavaRepresentation(0, 1, new int[] { 0 });
        } //End block
        {
            int sign;
            sign = 1;
            int numberLength;
            numberLength = (numBits + 31) >> 5;
            int[] digits;
            digits = new int[numberLength];
            {
                int i;
                i = 0;
                {
                    digits[i] = random.nextInt();
                } //End block
            } //End collapsed parenthetic
            digits[numberLength - 1] >>>= (-numBits) & 31;
            setJavaRepresentation(sign, numberLength, digits);
        } //End block
        javaIsValid = true;
        // ---------- Original Method ----------
        //if (numBits < 0) {
            //throw new IllegalArgumentException("numBits < 0: " + numBits);
        //}
        //if (numBits == 0) {
            //setJavaRepresentation(0, 1, new int[] { 0 });
        //} else {
            //int sign = 1;
            //int numberLength = (numBits + 31) >> 5;
            //int[] digits = new int[numberLength];
            //for (int i = 0; i < numberLength; i++) {
                //digits[i] = random.nextInt();
            //}
            //digits[numberLength - 1] >>>= (-numBits) & 31;
            //setJavaRepresentation(sign, numberLength, digits);
        //}
        //javaIsValid = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.534 -0400", hash_original_method = "E06C60E93C7C91BB266029ED9C3D532A", hash_generated_method = "96E12250D1C79C6C0E675539E8BA8DB3")
    public  BigInteger(int bitLength, int certainty, Random unused) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("bitLength < 2: " + bitLength);
        } //End block
        setBigInt(BigInt.generatePrimeDefault(bitLength));
        addTaint(bitLength);
        addTaint(certainty);
        addTaint(unused.getTaint());
        // ---------- Original Method ----------
        //if (bitLength < 2) {
            //throw new ArithmeticException("bitLength < 2: " + bitLength);
        //}
        //setBigInt(BigInt.generatePrimeDefault(bitLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.535 -0400", hash_original_method = "858DE6DF463E0F4BFB47F99F590AB0EF", hash_generated_method = "5B3C474263B131654FAC29BF779FBB37")
    public  BigInteger(String value) {
        BigInt bigInt;
        bigInt = new BigInt();
        bigInt.putDecString(value);
        setBigInt(bigInt);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //BigInt bigInt = new BigInt();
        //bigInt.putDecString(value);
        //setBigInt(bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.637 -0400", hash_original_method = "A13EC41ACC3DF589C11C4779074EEB6B", hash_generated_method = "8ADEDBBEF4899CE7EF7ACC8C1ECA5B43")
    public  BigInteger(String value, int radix) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("value == null");
        } //End block
        {
            BigInt bigInt;
            bigInt = new BigInt();
            bigInt.putDecString(value);
            setBigInt(bigInt);
        } //End block
        {
            BigInt bigInt;
            bigInt = new BigInt();
            bigInt.putHexString(value);
            setBigInt(bigInt);
        } //End block
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Invalid radix: " + radix);
            } //End block
            {
                boolean var61FDD46CB4F2D30108ACB79894E33C39_1271891149 = (value.isEmpty());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("value.isEmpty()");
                } //End block
            } //End collapsed parenthetic
            BigInteger.parseFromString(this, value, radix);
        } //End block
        addTaint(value.getTaint());
        addTaint(radix);
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException("value == null");
        //}
        //if (radix == 10) {
            //BigInt bigInt = new BigInt();
            //bigInt.putDecString(value);
            //setBigInt(bigInt);
        //} else if (radix == 16) {
            //BigInt bigInt = new BigInt();
            //bigInt.putHexString(value);
            //setBigInt(bigInt);
        //} else {
            //if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
                //throw new NumberFormatException("Invalid radix: " + radix);
            //}
            //if (value.isEmpty()) {
                //throw new NumberFormatException("value.isEmpty()");
            //}
            //BigInteger.parseFromString(this, value, radix);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.694 -0400", hash_original_method = "4725614D4A9FDEE6DBC2F6DB247469CF", hash_generated_method = "FCFC253D52A9232745E1F72C242A3ECC")
    public  BigInteger(int signum, byte[] magnitude) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("magnitude == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Invalid signum: " + signum);
        } //End block
        {
            {
                byte element = magnitude[0];
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("signum-magnitude mismatch");
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        BigInt bigInt;
        bigInt = new BigInt();
        bigInt.putBigEndian(magnitude, signum < 0);
        setBigInt(bigInt);
        addTaint(signum);
        addTaint(magnitude[0]);
        // ---------- Original Method ----------
        //if (magnitude == null) {
            //throw new NullPointerException("magnitude == null");
        //}
        //if (signum < -1 || signum > 1) {
            //throw new NumberFormatException("Invalid signum: " + signum);
        //}
        //if (signum == 0) {
            //for (byte element : magnitude) {
                //if (element != 0) {
                    //throw new NumberFormatException("signum-magnitude mismatch");
                //}
            //}
        //}
        //BigInt bigInt = new BigInt();
        //bigInt.putBigEndian(magnitude, signum < 0);
        //setBigInt(bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.694 -0400", hash_original_method = "ABB1E16F13BE7B2CA5EC1AADB52B2350", hash_generated_method = "5E0192300D683E47FF7F4C1D3699B570")
    public  BigInteger(byte[] value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("value.length == 0");
        } //End block
        BigInt bigInt;
        bigInt = new BigInt();
        bigInt.putBigEndianTwosComplement(value);
        setBigInt(bigInt);
        addTaint(value[0]);
        // ---------- Original Method ----------
        //if (value.length == 0) {
            //throw new NumberFormatException("value.length == 0");
        //}
        //BigInt bigInt = new BigInt();
        //bigInt.putBigEndianTwosComplement(value);
        //setBigInt(bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.695 -0400", hash_original_method = "7B92331634E6E3BE19D048B912B09B7F", hash_generated_method = "69193076BCB5DFD5F8B105F180046033")
     BigInt getBigInt() {
        BigInt varB4EAC82CA7396A68D541C85D26508E83_398434665 = null; //Variable for return #1
        BigInt varB4EAC82CA7396A68D541C85D26508E83_227862459 = null; //Variable for return #2
        BigInt varB4EAC82CA7396A68D541C85D26508E83_1941622117 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_398434665 = bigInt;
        } //End block
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_227862459 = bigInt;
            } //End block
            BigInt bigInt;
            bigInt = new BigInt();
            bigInt.putLittleEndianInts(digits, (sign < 0));
            setBigInt(bigInt);
            varB4EAC82CA7396A68D541C85D26508E83_1941622117 = bigInt;
        } //End block
        BigInt varA7E53CE21691AB073D9660D615818899_311156344; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_311156344 = varB4EAC82CA7396A68D541C85D26508E83_398434665;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_311156344 = varB4EAC82CA7396A68D541C85D26508E83_227862459;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_311156344 = varB4EAC82CA7396A68D541C85D26508E83_1941622117;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_311156344.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_311156344;
        // ---------- Original Method ----------
        //if (nativeIsValid) {
            //return bigInt;
        //}
        //synchronized (this) {
            //if (nativeIsValid) {
                //return bigInt;
            //}
            //BigInt bigInt = new BigInt();
            //bigInt.putLittleEndianInts(digits, (sign < 0));
            //setBigInt(bigInt);
            //return bigInt;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.714 -0400", hash_original_method = "CC364AFCED646D5BD618C239A0F61C61", hash_generated_method = "FB8F32B7985E2B240502D873FAE13D52")
    private void setBigInt(BigInt bigInt) {
        this.bigInt = bigInt;
        this.nativeIsValid = true;
        // ---------- Original Method ----------
        //this.bigInt = bigInt;
        //this.nativeIsValid = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.714 -0400", hash_original_method = "DA7CFD2DB9135F0E2C89139BCCCBB12F", hash_generated_method = "0F64427ABCDD686DC8AEFEEE13813050")
    private void setJavaRepresentation(int sign, int numberLength, int[] digits) {
        {
            ;
        } //End block
        {
            sign = 0;
        } //End block
        this.sign = sign;
        this.digits = digits;
        this.numberLength = numberLength;
        this.javaIsValid = true;
        // ---------- Original Method ----------
        //while (numberLength > 0 && digits[--numberLength] == 0) {
            //;
        //}
        //if (digits[numberLength++] == 0) {
            //sign = 0;
        //}
        //this.sign = sign;
        //this.digits = digits;
        //this.numberLength = numberLength;
        //this.javaIsValid = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.715 -0400", hash_original_method = "E11A76F306D885B62849938EE7ACFF1F", hash_generated_method = "7FD6176B1059E967EE7FA7FB5E533B6E")
     void prepareJavaRepresentation() {
        {
            int sign;
            sign = bigInt.sign();
            int[] digits;
            digits = bigInt.littleEndianIntsMagnitude();
            digits = new int[] { 0 };
            setJavaRepresentation(sign, digits.length, digits);
        } //End block
        // ---------- Original Method ----------
        //if (javaIsValid) {
            //return;
        //}
        //synchronized (this) {
            //if (javaIsValid) {
                //return;
            //}
            //int sign = bigInt.sign();
            //int[] digits = (sign != 0) ? bigInt.littleEndianIntsMagnitude() : new int[] { 0 };
            //setJavaRepresentation(sign, digits.length, digits);
        //}
    }

    
        public static BigInteger valueOf(long value) {
        if (value < 0) {
            if (value != -1) {
                return new BigInteger(-1, -value);
            }
            return MINUS_ONE;
        } else if (value < SMALL_VALUES.length) {
            return SMALL_VALUES[(int) value];
        } else {
            return new BigInteger(1, value);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.715 -0400", hash_original_method = "F45D943577A758DE4A75A5CD2DF6D206", hash_generated_method = "DA6C99B5E645C4B06CCC2EA75F37DF7F")
    public byte[] toByteArray() {
        byte[] var3BE346B2FB665BD8F6B33361C4C01498_1830508281 = (twosComplement());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2027732959 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2027732959;
        // ---------- Original Method ----------
        //return twosComplement();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.745 -0400", hash_original_method = "4D099B3B9B18238917CAE07611FC89C9", hash_generated_method = "6CC5E25028D88CEF0E39CCF89C0FBE71")
    public BigInteger abs() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_254179352 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_285307811 = null; //Variable for return #2
        BigInt bigInt;
        bigInt = getBigInt();
        {
            boolean var62DB935F980131F1A8A6EA88CF668813_1968297033 = (bigInt.sign() >= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_254179352 = this;
            } //End block
        } //End collapsed parenthetic
        BigInt a;
        a = bigInt.copy();
        a.setSign(1);
        varB4EAC82CA7396A68D541C85D26508E83_285307811 = new BigInteger(a);
        BigInteger varA7E53CE21691AB073D9660D615818899_475949899; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_475949899 = varB4EAC82CA7396A68D541C85D26508E83_254179352;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_475949899 = varB4EAC82CA7396A68D541C85D26508E83_285307811;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_475949899.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_475949899;
        // ---------- Original Method ----------
        //BigInt bigInt = getBigInt();
        //if (bigInt.sign() >= 0) {
            //return this;
        //}
        //BigInt a = bigInt.copy();
        //a.setSign(1);
        //return new BigInteger(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.746 -0400", hash_original_method = "DFABA71B5B9AE3E4CD65AD4AD666E31C", hash_generated_method = "51524BC6DB8E2D5DBE8176DDC2303ABE")
    public BigInteger negate() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_486983117 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_231461936 = null; //Variable for return #2
        BigInt bigInt;
        bigInt = getBigInt();
        int sign;
        sign = bigInt.sign();
        {
            varB4EAC82CA7396A68D541C85D26508E83_486983117 = this;
        } //End block
        BigInt a;
        a = bigInt.copy();
        a.setSign(-sign);
        varB4EAC82CA7396A68D541C85D26508E83_231461936 = new BigInteger(a);
        BigInteger varA7E53CE21691AB073D9660D615818899_43155509; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_43155509 = varB4EAC82CA7396A68D541C85D26508E83_486983117;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_43155509 = varB4EAC82CA7396A68D541C85D26508E83_231461936;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_43155509.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_43155509;
        // ---------- Original Method ----------
        //BigInt bigInt = getBigInt();
        //int sign = bigInt.sign();
        //if (sign == 0) {
            //return this;
        //}
        //BigInt a = bigInt.copy();
        //a.setSign(-sign);
        //return new BigInteger(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.747 -0400", hash_original_method = "5B8AB174D1647BD6610121BBBEE51EE5", hash_generated_method = "36AEC8ABCD13AEB4A9C370A583F37A39")
    public BigInteger add(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1929377503 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_124583440 = null; //Variable for return #2
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1875359715 = null; //Variable for return #3
        BigInt lhs;
        lhs = getBigInt();
        BigInt rhs;
        rhs = value.getBigInt();
        {
            boolean var715C4C2597076EBBD7DE116903FFEC43_2373266 = (rhs.sign() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1929377503 = this;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5A6924AA8D9332981417DC839AF99791_1637225298 = (lhs.sign() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_124583440 = value;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1875359715 = new BigInteger(BigInt.addition(lhs, rhs));
        addTaint(value.getTaint());
        BigInteger varA7E53CE21691AB073D9660D615818899_613993180; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_613993180 = varB4EAC82CA7396A68D541C85D26508E83_1929377503;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_613993180 = varB4EAC82CA7396A68D541C85D26508E83_124583440;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_613993180 = varB4EAC82CA7396A68D541C85D26508E83_1875359715;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_613993180.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_613993180;
        // ---------- Original Method ----------
        //BigInt lhs = getBigInt();
        //BigInt rhs = value.getBigInt();
        //if (rhs.sign() == 0) {
            //return this;
        //}
        //if (lhs.sign() == 0) {
            //return value;
        //}
        //return new BigInteger(BigInt.addition(lhs, rhs));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.775 -0400", hash_original_method = "753BA04897A44EE33BA2055C50810858", hash_generated_method = "C650B3A78382F9518D377ABD5B9EE45D")
    public BigInteger subtract(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_818433472 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1755520225 = null; //Variable for return #2
        BigInt lhs;
        lhs = getBigInt();
        BigInt rhs;
        rhs = value.getBigInt();
        {
            boolean var715C4C2597076EBBD7DE116903FFEC43_685469133 = (rhs.sign() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_818433472 = this;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1755520225 = new BigInteger(BigInt.subtraction(lhs, rhs));
        addTaint(value.getTaint());
        BigInteger varA7E53CE21691AB073D9660D615818899_1636535236; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1636535236 = varB4EAC82CA7396A68D541C85D26508E83_818433472;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1636535236 = varB4EAC82CA7396A68D541C85D26508E83_1755520225;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1636535236.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1636535236;
        // ---------- Original Method ----------
        //BigInt lhs = getBigInt();
        //BigInt rhs = value.getBigInt();
        //if (rhs.sign() == 0) {
            //return this;
        //}
        //return new BigInteger(BigInt.subtraction(lhs, rhs));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.775 -0400", hash_original_method = "0A534AADB97A9D37B49476B54B03D66A", hash_generated_method = "9034658DEA3E1C1A9A2A3B19F9A2BB87")
    public int signum() {
        int var78785A1AB216D9DE61B723A960BFD6AE_805216032 = (getBigInt().sign());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495586116 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495586116;
        // ---------- Original Method ----------
        //if (javaIsValid) {
            //return sign;
        //}
        //return getBigInt().sign();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.776 -0400", hash_original_method = "1B97FA7BE1DE29423609E814DD90E66F", hash_generated_method = "399976A2889AE4E88BE5DB2359657AE4")
    public BigInteger shiftRight(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1773824659 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1773824659 = shiftLeft(-n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_1773824659.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1773824659;
        // ---------- Original Method ----------
        //return shiftLeft(-n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.793 -0400", hash_original_method = "3E0E92A5CC7CF6FE74FD251028917DBB", hash_generated_method = "61A7768CDF2A1E601992623FAA10F512")
    public BigInteger shiftLeft(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1112862918 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1683956868 = null; //Variable for return #2
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_840224402 = null; //Variable for return #3
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2075035348 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_1112862918 = this;
        } //End block
        int sign;
        sign = signum();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1683956868 = this;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_840224402 = new BigInteger(BigInt.shift(getBigInt(), n));
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2075035348 = BitLevel.shiftRight(this, -n);
        } //End block
        addTaint(n);
        BigInteger varA7E53CE21691AB073D9660D615818899_783046601; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_783046601 = varB4EAC82CA7396A68D541C85D26508E83_1112862918;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_783046601 = varB4EAC82CA7396A68D541C85D26508E83_1683956868;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_783046601 = varB4EAC82CA7396A68D541C85D26508E83_840224402;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_783046601 = varB4EAC82CA7396A68D541C85D26508E83_2075035348;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_783046601.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_783046601;
        // ---------- Original Method ----------
        //if (n == 0) {
            //return this;
        //}
        //int sign = signum();
        //if (sign == 0) {
            //return this;
        //}
        //if ((sign > 0) || (n >= 0)) {
            //return new BigInteger(BigInt.shift(getBigInt(), n));
        //} else {
            //return BitLevel.shiftRight(this, -n);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.797 -0400", hash_original_method = "3F948826829C47AB028976261F4B8D55", hash_generated_method = "A6DE91BE4F7AF87650F922DE4956C4DA")
     BigInteger shiftLeftOneBit() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1319656221 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1319656221 = (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
        varB4EAC82CA7396A68D541C85D26508E83_1319656221.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1319656221;
        // ---------- Original Method ----------
        //return (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.797 -0400", hash_original_method = "5DD770E4600136986E52E3D1EE5F1B27", hash_generated_method = "71F6604FA128A13D1C422D01596E20FE")
    public int bitLength() {
        {
            int varEF6F0F502ED0A4A2C2EE418CF96465E4_1383822639 = (BitLevel.bitLength(this));
        } //End block
        int var788BC3441C63E42B6C6F5C344E860F68_525687463 = (getBigInt().bitLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851296755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851296755;
        // ---------- Original Method ----------
        //if (!nativeIsValid && javaIsValid) {
            //return BitLevel.bitLength(this);
        //}
        //return getBigInt().bitLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.817 -0400", hash_original_method = "22DB08B3CA9DDA99CEE301218284C513", hash_generated_method = "D998E355FC9B60A932C1DCEA5C47C52F")
    public boolean testBit(int n) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("n < 0: " + n);
        } //End block
        int sign;
        sign = signum();
        {
            boolean varF17D7AFCFA584F08AA65771D9B761AB7_983455977 = (getBigInt().isBitSet(n));
        } //End block
        {
            prepareJavaRepresentation();
            int intCount;
            intCount = n >> 5;
            int digit;
            digit = digits[intCount];
            n = (1 << (n & 31));
            {
                int firstNonZeroDigit;
                firstNonZeroDigit = getFirstNonzeroDigit();
                {
                    digit = -digit;
                } //End block
                {
                    digit = ~digit;
                } //End block
            } //End block
        } //End block
        addTaint(n);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710508289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_710508289;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.818 -0400", hash_original_method = "0A60006224C30F0C8DC4E0C8D16895AE", hash_generated_method = "6A169A4C1CCD910B926A25CFE070A0D4")
    public BigInteger setBit(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_896720467 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1308435951 = null; //Variable for return #2
        prepareJavaRepresentation();
        {
            boolean var5D4D017D7F453054D257FB916BD85DB7_1339199145 = (!testBit(n));
            {
                varB4EAC82CA7396A68D541C85D26508E83_896720467 = BitLevel.flipBit(this, n);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1308435951 = this;
            } //End block
        } //End collapsed parenthetic
        addTaint(n);
        BigInteger varA7E53CE21691AB073D9660D615818899_158017596; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_158017596 = varB4EAC82CA7396A68D541C85D26508E83_896720467;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_158017596 = varB4EAC82CA7396A68D541C85D26508E83_1308435951;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_158017596.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_158017596;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (!testBit(n)) {
            //return BitLevel.flipBit(this, n);
        //} else {
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.819 -0400", hash_original_method = "8D8C5374E542B708B8A1B41B31DCBF03", hash_generated_method = "962B64D2ABCADFC7D97A2DB77B081007")
    public BigInteger clearBit(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1436460147 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2061886243 = null; //Variable for return #2
        prepareJavaRepresentation();
        {
            boolean varA357D3076F2B8D19676817F90ACD1333_1452860963 = (testBit(n));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1436460147 = BitLevel.flipBit(this, n);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_2061886243 = this;
            } //End block
        } //End collapsed parenthetic
        addTaint(n);
        BigInteger varA7E53CE21691AB073D9660D615818899_1352352001; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1352352001 = varB4EAC82CA7396A68D541C85D26508E83_1436460147;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1352352001 = varB4EAC82CA7396A68D541C85D26508E83_2061886243;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1352352001.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1352352001;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (testBit(n)) {
            //return BitLevel.flipBit(this, n);
        //} else {
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.842 -0400", hash_original_method = "F1D37134A8936EE90081AD78D8487F59", hash_generated_method = "58F6237A17A3F6F69D8A5E67EE992A44")
    public BigInteger flipBit(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1258592751 = null; //Variable for return #1
        prepareJavaRepresentation();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("n < 0: " + n);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1258592751 = BitLevel.flipBit(this, n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_1258592751.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1258592751;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (n < 0) {
            //throw new ArithmeticException("n < 0: " + n);
        //}
        //return BitLevel.flipBit(this, n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.843 -0400", hash_original_method = "8383F139074E92B6BF621C4AC408CB05", hash_generated_method = "77EC4CF0392E7EB21173C46D1C1EB0D4")
    public int getLowestSetBit() {
        prepareJavaRepresentation();
        int i;
        i = getFirstNonzeroDigit();
        int var08486A238466E45EF685C7096473496F_1750814877 = (((i << 5) + Integer.numberOfTrailingZeros(digits[i])));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_100066080 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_100066080;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (sign == 0) {
            //return -1;
        //}
        //int i = getFirstNonzeroDigit();
        //return ((i << 5) + Integer.numberOfTrailingZeros(digits[i]));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.843 -0400", hash_original_method = "2461573222D281ABCA9F3F34AA40AFB9", hash_generated_method = "FD31068AB75F3DCD36CD31DEFF0499F4")
    public int bitCount() {
        prepareJavaRepresentation();
        int var03F1A887008EE5D56B89D17C00839C9F_573351492 = (BitLevel.bitCount(this));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629589476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629589476;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //return BitLevel.bitCount(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.843 -0400", hash_original_method = "CD87C1AB82AE5BD1BDB1D71C1F7F211A", hash_generated_method = "B8E6BEB7ADCF98BA370A1728D6F243F8")
    public BigInteger not() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_327972889 = null; //Variable for return #1
        this.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_327972889 = Logical.not(this);
        varB4EAC82CA7396A68D541C85D26508E83_327972889.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_327972889;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //return Logical.not(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.844 -0400", hash_original_method = "B57E8848F50ED2CEFC86EA20A70D185D", hash_generated_method = "8E0220FC1C51E3883FCF173B02D6C95A")
    public BigInteger and(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_441375607 = null; //Variable for return #1
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_441375607 = Logical.and(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_441375607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_441375607;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.and(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.865 -0400", hash_original_method = "AED35BC9F3B39A40B35087479AE4F222", hash_generated_method = "ED0FCB2D3F13FCC6070122FB4BBAA9C3")
    public BigInteger or(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1837641267 = null; //Variable for return #1
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_1837641267 = Logical.or(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1837641267.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1837641267;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.or(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.866 -0400", hash_original_method = "0162D315FD06686CC7830A3D5D5A796E", hash_generated_method = "6F0D5D1ECAD3FB7D95EDF2E655324410")
    public BigInteger xor(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_579335806 = null; //Variable for return #1
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_579335806 = Logical.xor(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_579335806.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_579335806;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.xor(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.867 -0400", hash_original_method = "A8A90B9F7EBADE4F51C070D1C780A515", hash_generated_method = "C7AD63416F1CDC0B80AFBC713A8916A0")
    public BigInteger andNot(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1740631538 = null; //Variable for return #1
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_1740631538 = Logical.andNot(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1740631538.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1740631538;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.andNot(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.867 -0400", hash_original_method = "F298334B66A6EA4DC89E250C44198AEA", hash_generated_method = "98B3B8CA24EAC4907AEAB96D47D076C9")
    @Override
    public int intValue() {
        {
            boolean var736C79FFC0E47BDF554712724F023607_1573441001 = (nativeIsValid && bigInt.twosCompFitsIntoBytes(4));
            {
                int var3C648FDB51952E7A4326C06E11E5D714_188984426 = ((int) bigInt.longInt());
            } //End block
        } //End collapsed parenthetic
        this.prepareJavaRepresentation();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965082246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965082246;
        // ---------- Original Method ----------
        //if (nativeIsValid && bigInt.twosCompFitsIntoBytes(4)) {
            //return (int) bigInt.longInt();
        //}
        //this.prepareJavaRepresentation();
        //return (sign * digits[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.893 -0400", hash_original_method = "22A0F6A18293749D1CD57F54133930DD", hash_generated_method = "97BC7C0C2FA0DB7A515660344A7D0CC0")
    @Override
    public long longValue() {
        {
            boolean varC4F1CBA5BA1CCD278A875F7CBF5B1567_1806721493 = (nativeIsValid && bigInt.twosCompFitsIntoBytes(8));
            {
                long var4AAAA41C9D1DFB9DDFD6709151B2DF14_639659926 = (bigInt.longInt());
            } //End block
        } //End collapsed parenthetic
        prepareJavaRepresentation();
        long value;
        value = ((long) digits[1]) << 32 | digits[0] & 0xFFFFFFFFL;
        value = digits[0] & 0xFFFFFFFFL;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_49131581 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_49131581;
        // ---------- Original Method ----------
        //if (nativeIsValid && bigInt.twosCompFitsIntoBytes(8)) {
            //return bigInt.longInt();
        //}
        //prepareJavaRepresentation();
        //long value = numberLength > 1
                //? ((long) digits[1]) << 32 | digits[0] & 0xFFFFFFFFL
                //: digits[0] & 0xFFFFFFFFL;
        //return sign * value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.893 -0400", hash_original_method = "85C514A29B5895D821780B89C4F747B0", hash_generated_method = "E84AD82A057735AE33FB0E4D422710BD")
    @Override
    public float floatValue() {
        float var988FDD4E54336618413CB2C701826BC6_532607700 = ((float) doubleValue());
        float var546ADE640B6EDFBC8A086EF31347E768_76796907 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_76796907;
        // ---------- Original Method ----------
        //return (float) doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.894 -0400", hash_original_method = "3D8E394E07D4F37AF2C6D72F08026A5D", hash_generated_method = "349945F62230CE8D2C66CD679BF373FF")
    @Override
    public double doubleValue() {
        double var986CEBD15E6E1AF84E0E0543465AB73A_2095482360 = (Conversion.bigInteger2Double(this));
        double varE8CD7DA078A86726031AD64F35F5A6C0_765226394 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_765226394;
        // ---------- Original Method ----------
        //return Conversion.bigInteger2Double(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.894 -0400", hash_original_method = "2F090DBB15C308A00016A444F7C5A620", hash_generated_method = "81A7622E5814B365E9A782295D4798D9")
    public int compareTo(BigInteger value) {
        int varE8DF5E315CCF42EB1CBFEE65CA4A8DF2_1886325791 = (BigInt.cmp(getBigInt(), value.getBigInt()));
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031263616 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031263616;
        // ---------- Original Method ----------
        //return BigInt.cmp(getBigInt(), value.getBigInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.907 -0400", hash_original_method = "909F517DD4A19D55540D3A4577FBCF84", hash_generated_method = "A6022091775636A7C3F0B919780041B7")
    public BigInteger min(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1410298320 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1410298320 = this.compareTo(value) == -1 ? this : value;
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1410298320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1410298320;
        // ---------- Original Method ----------
        //return this.compareTo(value) == -1 ? this : value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.907 -0400", hash_original_method = "6C03178B5A42138223A2B4814CF874FD", hash_generated_method = "64D4CD3B8EAC098FFC843E1E46F0FF28")
    public BigInteger max(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_347555100 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_347555100 = this.compareTo(value) == 1 ? this : value;
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_347555100.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_347555100;
        // ---------- Original Method ----------
        //return this.compareTo(value) == 1 ? this : value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.908 -0400", hash_original_method = "8BD8EE457DCE4BEA017BA4C9967BFC77", hash_generated_method = "C30E92A83EFFC9A86A44BD67D4860BAE")
    @Override
    public int hashCode() {
        prepareJavaRepresentation();
        {
            int i;
            i = 0;
            {
                hashCode = hashCode * 33 + digits[i];
            } //End block
        } //End collapsed parenthetic
        hashCode = hashCode * sign;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521733990 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521733990;
        // ---------- Original Method ----------
        //if (hashCode != 0) {
            //return hashCode;
        //}
        //prepareJavaRepresentation();
        //for (int i = 0; i < numberLength; ++i) {
            //hashCode = hashCode * 33 + digits[i];
        //}
        //hashCode = hashCode * sign;
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.908 -0400", hash_original_method = "D6CA37529D0AAA6915B88189BBB9DE43", hash_generated_method = "FAB15DA899D93AE4A1D62660E3631D4B")
    @Override
    public boolean equals(Object x) {
        {
            boolean var8C5538CAE31374871D89268FAA638122_1355736921 = (this.compareTo((BigInteger) x) == 0);
        } //End block
        addTaint(x.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700583093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700583093;
        // ---------- Original Method ----------
        //if (this == x) {
            //return true;
        //}
        //if (x instanceof BigInteger) {
            //return this.compareTo((BigInteger) x) == 0;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.908 -0400", hash_original_method = "466A78542936FDDF00F235F55782CDB1", hash_generated_method = "D7F97961A87F56719481EBDF57E02549")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_80783947 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_80783947 = getBigInt().decString();
        varB4EAC82CA7396A68D541C85D26508E83_80783947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_80783947;
        // ---------- Original Method ----------
        //return getBigInt().decString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.909 -0400", hash_original_method = "DC1B34095F4DDEED7FED4CD9DAE6BCA6", hash_generated_method = "149F05DCEABF7B31EFCD2AF0EE6E9D22")
    public String toString(int radix) {
        String varB4EAC82CA7396A68D541C85D26508E83_253046666 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1262485770 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_253046666 = getBigInt().decString();
        } //End block
        {
            prepareJavaRepresentation();
            varB4EAC82CA7396A68D541C85D26508E83_1262485770 = Conversion.bigInteger2String(this, radix);
        } //End block
        addTaint(radix);
        String varA7E53CE21691AB073D9660D615818899_240554549; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_240554549 = varB4EAC82CA7396A68D541C85D26508E83_253046666;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_240554549 = varB4EAC82CA7396A68D541C85D26508E83_1262485770;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_240554549.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_240554549;
        // ---------- Original Method ----------
        //if (radix == 10) {
            //return getBigInt().decString();
        //} else {
            //prepareJavaRepresentation();
            //return Conversion.bigInteger2String(this, radix);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.909 -0400", hash_original_method = "DF6919CA8C1CE81A76193FCEFAE3FDAA", hash_generated_method = "14C159AAB7171CAAC17A71F00AF53837")
    public BigInteger gcd(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1206453592 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1206453592 = new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1206453592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1206453592;
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.912 -0400", hash_original_method = "7A377385A7A35B42B025ADA39BD9F319", hash_generated_method = "57750CE76AC36EC2EB7B1BAD418365EA")
    public BigInteger multiply(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1378083530 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1378083530 = new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1378083530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1378083530;
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.913 -0400", hash_original_method = "670CEDEE32713500748765AA85174DA4", hash_generated_method = "1081A855D4A6759FE2E32AD001DF1955")
    public BigInteger pow(int exp) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1582402313 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("exp < 0: " + exp);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1582402313 = new BigInteger(BigInt.exp(getBigInt(), exp));
        addTaint(exp);
        varB4EAC82CA7396A68D541C85D26508E83_1582402313.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1582402313;
        // ---------- Original Method ----------
        //if (exp < 0) {
            //throw new ArithmeticException("exp < 0: " + exp);
        //}
        //return new BigInteger(BigInt.exp(getBigInt(), exp));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.913 -0400", hash_original_method = "0021B26ACCFD58807A129BEBBFC75B78", hash_generated_method = "E5C680CDA5446121FCD40E5C400D36B4")
    public BigInteger[] divideAndRemainder(BigInteger divisor) {
        BigInteger[] varB4EAC82CA7396A68D541C85D26508E83_1793069679 = null; //Variable for return #1
        BigInt divisorBigInt;
        divisorBigInt = divisor.getBigInt();
        BigInt quotient;
        quotient = new BigInt();
        BigInt remainder;
        remainder = new BigInt();
        BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        varB4EAC82CA7396A68D541C85D26508E83_1793069679 = new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1793069679.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1793069679;
        // ---------- Original Method ----------
        //BigInt divisorBigInt = divisor.getBigInt();
        //BigInt quotient = new BigInt();
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        //return new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.951 -0400", hash_original_method = "E605E3D77E9B13D877DA6B6F47D67F1F", hash_generated_method = "CF2595EF165A4B0801433A4AAD7B11BE")
    public BigInteger divide(BigInteger divisor) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_471971652 = null; //Variable for return #1
        BigInt quotient;
        quotient = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        varB4EAC82CA7396A68D541C85D26508E83_471971652 = new BigInteger(quotient);
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_471971652.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_471971652;
        // ---------- Original Method ----------
        //BigInt quotient = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        //return new BigInteger(quotient);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.951 -0400", hash_original_method = "FFD2A7C70BA79F9B512531A9A18B49EF", hash_generated_method = "FDF716BF8E128882CAB554433AF71642")
    public BigInteger remainder(BigInteger divisor) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_185835368 = null; //Variable for return #1
        BigInt remainder;
        remainder = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        varB4EAC82CA7396A68D541C85D26508E83_185835368 = new BigInteger(remainder);
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_185835368.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_185835368;
        // ---------- Original Method ----------
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        //return new BigInteger(remainder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.952 -0400", hash_original_method = "D09D0373DFB5DF67EDACA66D474BB75C", hash_generated_method = "065471E3082D8C48D56E3966C7869879")
    public BigInteger modInverse(BigInteger m) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_297290776 = null; //Variable for return #1
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_399856692 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("modulus not positive");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_297290776 = new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
        addTaint(m.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_297290776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_297290776;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("modulus not positive");
        //}
        //return new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.953 -0400", hash_original_method = "4B2E2C43A8E0C70699BFC0E4EF01E685", hash_generated_method = "07BCF22BE8409E8E860E09B765AD5F80")
    public BigInteger modPow(BigInteger exponent, BigInteger m) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1058768696 = null; //Variable for return #1
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_1146397189 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("m.signum() <= 0");
            } //End block
        } //End collapsed parenthetic
        BigInteger base;
        boolean varE2809D8580A02DD733D2DE31DC8AE895_1154484530 = (exponent.signum() < 0);
        base = modInverse(m);
        base = this;
        varB4EAC82CA7396A68D541C85D26508E83_1058768696 = new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
        addTaint(exponent.getTaint());
        addTaint(m.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1058768696.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1058768696;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //BigInteger base = exponent.signum() < 0 ? modInverse(m) : this;
        //return new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.953 -0400", hash_original_method = "ADC51A8E4A4079F65268593A33DD74A7", hash_generated_method = "4BBBD6893A42BB9E90DF8E9D1F7C961D")
    public BigInteger mod(BigInteger m) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1258474310 = null; //Variable for return #1
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_448423406 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("m.signum() <= 0");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1258474310 = new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
        addTaint(m.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1258474310.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1258474310;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //return new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.953 -0400", hash_original_method = "718D211034BAE1DECACA1D72CB4CBB13", hash_generated_method = "323C360CE71977E3C2DFF4D27CDE8230")
    public boolean isProbablePrime(int certainty) {
        boolean var527C2D985EF61BA5C7404EDA1C84F2DB_209807019 = (getBigInt().isPrime(certainty));
        addTaint(certainty);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1574571650 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1574571650;
        // ---------- Original Method ----------
        //if (certainty <= 0) {
            //return true;
        //}
        //return getBigInt().isPrime(certainty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.954 -0400", hash_original_method = "BB43921F4E806BD72B6F518E8CD8937B", hash_generated_method = "DB474646CFAFEDE6806D750BBCF8BD5F")
    public BigInteger nextProbablePrime() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1154506237 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("sign < 0");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1154506237 = Primality.nextProbablePrime(this);
        varB4EAC82CA7396A68D541C85D26508E83_1154506237.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1154506237;
        // ---------- Original Method ----------
        //if (sign < 0) {
            //throw new ArithmeticException("sign < 0");
        //}
        //return Primality.nextProbablePrime(this);
    }

    
        public static BigInteger probablePrime(int bitLength, Random unused) {
        return new BigInteger(bitLength, 100, unused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.962 -0400", hash_original_method = "F2F8EDC382104DB344E8DD617201B0F3", hash_generated_method = "C7CE4A32B02FB36526210624C92CECC3")
    private byte[] twosComplement() {
        prepareJavaRepresentation();
        {
            byte[] var871F8A6A5DD979D0CBC073DD77C1CF91_1790649568 = (new byte[] { 0 });
        } //End block
        BigInteger temp;
        temp = this;
        int bitLen;
        bitLen = bitLength();
        int iThis;
        iThis = getFirstNonzeroDigit();
        int bytesLen;
        bytesLen = (bitLen >> 3) + 1;
        byte[] bytes;
        bytes = new byte[bytesLen];
        int firstByteNumber;
        firstByteNumber = 0;
        int highBytes;
        int bytesInInteger;
        bytesInInteger = 4;
        int hB;
        {
            bytes[0] = (byte) ((sign < 0) ? -1 : 0);
            highBytes = 4;
        } //End block
        {
            hB = bytesLen & 3;
            highBytes = (hB == 0) ? 4 : hB;
        } //End block
        int digitIndex;
        digitIndex = iThis;
        bytesLen -= iThis << 2;
        {
            int digit;
            digit = -temp.digits[digitIndex];
            {
                bytesInInteger = highBytes;
            } //End block
            {
                int i;
                i = 0;
                digit >>= 8;
                {
                    bytes[--bytesLen] = (byte) digit;
                } //End block
            } //End collapsed parenthetic
            {
                digit = ~temp.digits[digitIndex];
                {
                    bytesInInteger = highBytes;
                } //End block
                {
                    int i;
                    i = 0;
                    digit >>= 8;
                    {
                        bytes[--bytesLen] = (byte) digit;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                int digit;
                digit = temp.digits[digitIndex];
                {
                    bytesInInteger = highBytes;
                } //End block
                {
                    int i;
                    i = 0;
                    digit >>= 8;
                    {
                        bytes[--bytesLen] = (byte) digit;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_119119890 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_119119890;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static int multiplyByInt(int[] res, int[] a, int aSize, int factor) {
        long carry = 0;
        for (int i = 0; i < aSize; i++) {
            carry += (a[i] & 0xFFFFFFFFL) * (factor & 0xFFFFFFFFL);
            res[i] = (int) carry;
            carry >>>= 32;
        }
        return (int) carry;
    }

    
        static int inplaceAdd(int[] a, int aSize, int addend) {
        long carry = addend & 0xFFFFFFFFL;
        for (int i = 0; (carry != 0) && (i < aSize); i++) {
            carry += a[i] & 0xFFFFFFFFL;
            a[i] = (int) carry;
            carry >>= 32;
        }
        return (int) carry;
    }

    
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
        int charsPerInt = Conversion.digitFitInInt[radix];
        int bigRadixDigitsLength = stringLength / charsPerInt;
        int topChars = stringLength % charsPerInt;
        if (topChars != 0) {
            bigRadixDigitsLength++;
        }
        int[] digits = new int[bigRadixDigitsLength];
        int bigRadix = Conversion.bigRadices[radix - 2];
        int digitIndex = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.977 -0400", hash_original_method = "4BA60B28A036933466CC713B9C7854B3", hash_generated_method = "389C078F18E2C727E58F06CACE018134")
     int getFirstNonzeroDigit() {
        {
            int i;
            {
                i = -1;
            } //End block
            {
                {
                    i = 0;
                    {
                        ;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            firstNonzeroDigit = i;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223112125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223112125;
        // ---------- Original Method ----------
        //if (firstNonzeroDigit == -2) {
            //int i;
            //if (this.sign == 0) {
                //i = -1;
            //} else {
                //for (i = 0; digits[i] == 0; i++) {
                    //;
                //}
            //}
            //firstNonzeroDigit = i;
        //}
        //return firstNonzeroDigit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.977 -0400", hash_original_method = "FABC86F56C336DE2152BE8F133BAAD74", hash_generated_method = "903A58B8DCEA19FB54611D6E83199F29")
     BigInteger copy() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1075135014 = null; //Variable for return #1
        prepareJavaRepresentation();
        int[] copyDigits;
        copyDigits = new int[numberLength];
        System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        varB4EAC82CA7396A68D541C85D26508E83_1075135014 = new BigInteger(sign, numberLength, copyDigits);
        varB4EAC82CA7396A68D541C85D26508E83_1075135014.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1075135014;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //int[] copyDigits = new int[numberLength];
        //System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        //return new BigInteger(sign, numberLength, copyDigits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.978 -0400", hash_original_method = "883E43F5C4566D0C2A7853533F533817", hash_generated_method = "26081922C42C9651482BD8CDA83FCE2C")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        BigInt bigInt;
        bigInt = new BigInt();
        bigInt.putBigEndian(magnitude, signum < 0);
        setBigInt(bigInt);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //BigInt bigInt = new BigInt();
        //bigInt.putBigEndian(magnitude, signum < 0);
        //setBigInt(bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.979 -0400", hash_original_method = "4837A11F07A86A58815A56F1112D57DF", hash_generated_method = "E6B2FEC6F5BDFA37D2A8196B99A86AEC")
    private void writeObject(ObjectOutputStream out) throws IOException {
        BigInt bigInt;
        bigInt = getBigInt();
        signum = bigInt.sign();
        magnitude = bigInt.bigEndianMagnitude();
        out.defaultWriteObject();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //BigInt bigInt = getBigInt();
        //signum = bigInt.sign();
        //magnitude = bigInt.bigEndianMagnitude();
        //out.defaultWriteObject();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.985 -0400", hash_original_field = "63016A922509DF10F65084D6222C77C8", hash_generated_field = "2BEA6AB5FBF34BD6FB442D8BA65065DF")

    private static long serialVersionUID = -8287574255936472291L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.985 -0400", hash_original_field = "78897A137AA91788C51A9D5D88BD6B22", hash_generated_field = "26A57E8798A6CA862A91D3C87254CE3F")

    public static final BigInteger ZERO = new BigInteger(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.996 -0400", hash_original_field = "E938017D6125C253391B6FF2A79B2347", hash_generated_field = "61E4C0227042D85901BA98B2F2CD52C4")

    public static final BigInteger ONE = new BigInteger(1, 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.997 -0400", hash_original_field = "4252D38540440B1F1E5C9806E972B4B1", hash_generated_field = "7A2B2FAA86270609C420795EB3DF7501")

    public static final BigInteger TEN = new BigInteger(1, 10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.997 -0400", hash_original_field = "C8DE16A040E4D20B9E7749B6EA765BF0", hash_generated_field = "263B59B8310B73C674B762005157A3FB")

    static BigInteger MINUS_ONE = new BigInteger(-1, 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.997 -0400", hash_original_field = "43E384A873FB243B7D032AB564F5C6C0", hash_generated_field = "E6E5745F3F4A7C923A5A27C33D7E64F9")

    static BigInteger[] SMALL_VALUES = { ZERO, ONE, new BigInteger(1, 2),
            new BigInteger(1, 3), new BigInteger(1, 4), new BigInteger(1, 5),
            new BigInteger(1, 6), new BigInteger(1, 7), new BigInteger(1, 8),
            new BigInteger(1, 9), TEN };
}

