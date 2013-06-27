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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.445 -0400", hash_original_field = "33A2DB2A239C5BAAA46376495EE5F6ED", hash_generated_field = "1B931597CE47BECC94315E7FDFB3AE18")

    private transient BigInt bigInt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.445 -0400", hash_original_field = "F0121707B716C3D41C45CEC890F8FEBD", hash_generated_field = "B1CF9FA5CC5896A14634587A7438CDD0")

    private transient boolean nativeIsValid = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.445 -0400", hash_original_field = "562B560548EAC394A69BD390BABAEBE5", hash_generated_field = "36EDDB91E81C2B3A992259BBDA560C8D")

    private transient boolean javaIsValid = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.445 -0400", hash_original_field = "A2AACBD15B619A9B9E5581A6C33BD2B1", hash_generated_field = "EF92B8843E3664BCE02DEF9DAE8B81D8")

    transient int[] digits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.445 -0400", hash_original_field = "56F736C2BD891F3A00F34C71E5AD8378", hash_generated_field = "49E386B29ED8E51F4B9308F78ED67301")

    transient int numberLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.445 -0400", hash_original_field = "04B29480233F4DEF5C875875B6BDC3B1", hash_generated_field = "92BF56588B083F4EFC932B66DB92601C")

    transient int sign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.445 -0400", hash_original_field = "553C03BFED44A9505466470F56E3ADC5", hash_generated_field = "6063015DEF6F532F83AE577B35CA2F93")

    private transient int firstNonzeroDigit = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.445 -0400", hash_original_field = "327B0A3531EA3D97749FE579CC4632A4", hash_generated_field = "9E963B134F5112D99A51A8B2403DC06B")

    private int signum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.445 -0400", hash_original_field = "28C3D8F4B7E312AF5E0D6B59A50EFD1C", hash_generated_field = "62EEE6A49B1745E7CDFD636319A9ED04")

    private byte[] magnitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.445 -0400", hash_original_field = "B81E47D2AA677809E4BE3C9232B2407F", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.446 -0400", hash_original_method = "E2046ACAAE3FADB78A197B33030B87EF", hash_generated_method = "3692A01A842ED88D7B0B7D06B95E593C")
      BigInteger(BigInt bigInt) {
        {
            boolean varCBCE59BC652D0587CC25D4F0C19CC324_1919855105 = (bigInt == null || bigInt.getNativeBIGNUM() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.446 -0400", hash_original_method = "6A0326FFA4F8DFD22C6BE505D4303A06", hash_generated_method = "55FCDBFB4835752CB686FAA9AE63931C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.453 -0400", hash_original_method = "8FE766A630C587CF3D36C6776BEC57AB", hash_generated_method = "9D5A992E0E61ADC1EA67DF0D6E21AF4A")
      BigInteger(int sign, int numberLength, int[] digits) {
        setJavaRepresentation(sign, numberLength, digits);
        addTaint(sign);
        addTaint(numberLength);
        addTaint(digits[0]);
        // ---------- Original Method ----------
        //setJavaRepresentation(sign, numberLength, digits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.454 -0400", hash_original_method = "0CDCBE4F35D9E336AD3EE0D0E2D0776D", hash_generated_method = "448A70D33081051C8A47ABC82B816F43")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.455 -0400", hash_original_method = "E06C60E93C7C91BB266029ED9C3D532A", hash_generated_method = "96E12250D1C79C6C0E675539E8BA8DB3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.468 -0400", hash_original_method = "858DE6DF463E0F4BFB47F99F590AB0EF", hash_generated_method = "5B3C474263B131654FAC29BF779FBB37")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.469 -0400", hash_original_method = "A13EC41ACC3DF589C11C4779074EEB6B", hash_generated_method = "683CB73626994EBAC54E64FD0CEC28D7")
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
                boolean var61FDD46CB4F2D30108ACB79894E33C39_1753315573 = (value.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.490 -0400", hash_original_method = "4725614D4A9FDEE6DBC2F6DB247469CF", hash_generated_method = "FCFC253D52A9232745E1F72C242A3ECC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.491 -0400", hash_original_method = "ABB1E16F13BE7B2CA5EC1AADB52B2350", hash_generated_method = "5E0192300D683E47FF7F4C1D3699B570")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.503 -0400", hash_original_method = "7B92331634E6E3BE19D048B912B09B7F", hash_generated_method = "FCE35A1BFABF1BC4B9D5F234C9FC4AA4")
     BigInt getBigInt() {
        BigInt varB4EAC82CA7396A68D541C85D26508E83_820956860 = null; //Variable for return #1
        BigInt varB4EAC82CA7396A68D541C85D26508E83_981494476 = null; //Variable for return #2
        BigInt varB4EAC82CA7396A68D541C85D26508E83_656131506 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_820956860 = bigInt;
        } //End block
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_981494476 = bigInt;
            } //End block
            BigInt bigInt;
            bigInt = new BigInt();
            bigInt.putLittleEndianInts(digits, (sign < 0));
            setBigInt(bigInt);
            varB4EAC82CA7396A68D541C85D26508E83_656131506 = bigInt;
        } //End block
        BigInt varA7E53CE21691AB073D9660D615818899_1312338759; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1312338759 = varB4EAC82CA7396A68D541C85D26508E83_820956860;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1312338759 = varB4EAC82CA7396A68D541C85D26508E83_981494476;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1312338759 = varB4EAC82CA7396A68D541C85D26508E83_656131506;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1312338759.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1312338759;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.508 -0400", hash_original_method = "CC364AFCED646D5BD618C239A0F61C61", hash_generated_method = "FB8F32B7985E2B240502D873FAE13D52")
    private void setBigInt(BigInt bigInt) {
        this.bigInt = bigInt;
        this.nativeIsValid = true;
        // ---------- Original Method ----------
        //this.bigInt = bigInt;
        //this.nativeIsValid = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.509 -0400", hash_original_method = "DA7CFD2DB9135F0E2C89139BCCCBB12F", hash_generated_method = "0F64427ABCDD686DC8AEFEEE13813050")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.513 -0400", hash_original_method = "E11A76F306D885B62849938EE7ACFF1F", hash_generated_method = "7FD6176B1059E967EE7FA7FB5E533B6E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.516 -0400", hash_original_method = "F45D943577A758DE4A75A5CD2DF6D206", hash_generated_method = "4806A5E9A5E2342CC20C2669FBDEB778")
    public byte[] toByteArray() {
        byte[] var3BE346B2FB665BD8F6B33361C4C01498_1367681711 = (twosComplement());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1960527322 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1960527322;
        // ---------- Original Method ----------
        //return twosComplement();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.526 -0400", hash_original_method = "4D099B3B9B18238917CAE07611FC89C9", hash_generated_method = "5FFE376E13247436A477766EBEAE29B7")
    public BigInteger abs() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_880806920 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_71994394 = null; //Variable for return #2
        BigInt bigInt;
        bigInt = getBigInt();
        {
            boolean var62DB935F980131F1A8A6EA88CF668813_1827362047 = (bigInt.sign() >= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_880806920 = this;
            } //End block
        } //End collapsed parenthetic
        BigInt a;
        a = bigInt.copy();
        a.setSign(1);
        varB4EAC82CA7396A68D541C85D26508E83_71994394 = new BigInteger(a);
        BigInteger varA7E53CE21691AB073D9660D615818899_1827416278; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1827416278 = varB4EAC82CA7396A68D541C85D26508E83_880806920;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1827416278 = varB4EAC82CA7396A68D541C85D26508E83_71994394;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1827416278.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1827416278;
        // ---------- Original Method ----------
        //BigInt bigInt = getBigInt();
        //if (bigInt.sign() >= 0) {
            //return this;
        //}
        //BigInt a = bigInt.copy();
        //a.setSign(1);
        //return new BigInteger(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.530 -0400", hash_original_method = "DFABA71B5B9AE3E4CD65AD4AD666E31C", hash_generated_method = "E0BE2466421EB4041C427832FF47C6F7")
    public BigInteger negate() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_11219811 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1382487392 = null; //Variable for return #2
        BigInt bigInt;
        bigInt = getBigInt();
        int sign;
        sign = bigInt.sign();
        {
            varB4EAC82CA7396A68D541C85D26508E83_11219811 = this;
        } //End block
        BigInt a;
        a = bigInt.copy();
        a.setSign(-sign);
        varB4EAC82CA7396A68D541C85D26508E83_1382487392 = new BigInteger(a);
        BigInteger varA7E53CE21691AB073D9660D615818899_2035995292; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2035995292 = varB4EAC82CA7396A68D541C85D26508E83_11219811;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2035995292 = varB4EAC82CA7396A68D541C85D26508E83_1382487392;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2035995292.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2035995292;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.541 -0400", hash_original_method = "5B8AB174D1647BD6610121BBBEE51EE5", hash_generated_method = "3ADD259A899F45231102D03C8CB8739A")
    public BigInteger add(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_120997478 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1680749486 = null; //Variable for return #2
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_493262943 = null; //Variable for return #3
        BigInt lhs;
        lhs = getBigInt();
        BigInt rhs;
        rhs = value.getBigInt();
        {
            boolean var715C4C2597076EBBD7DE116903FFEC43_1969101121 = (rhs.sign() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_120997478 = this;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5A6924AA8D9332981417DC839AF99791_819239817 = (lhs.sign() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1680749486 = value;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_493262943 = new BigInteger(BigInt.addition(lhs, rhs));
        addTaint(value.getTaint());
        BigInteger varA7E53CE21691AB073D9660D615818899_668293431; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_668293431 = varB4EAC82CA7396A68D541C85D26508E83_120997478;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_668293431 = varB4EAC82CA7396A68D541C85D26508E83_1680749486;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_668293431 = varB4EAC82CA7396A68D541C85D26508E83_493262943;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_668293431.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_668293431;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.542 -0400", hash_original_method = "753BA04897A44EE33BA2055C50810858", hash_generated_method = "52044E6B03960D7BC55369F873CB28DB")
    public BigInteger subtract(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2056151822 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_493741569 = null; //Variable for return #2
        BigInt lhs;
        lhs = getBigInt();
        BigInt rhs;
        rhs = value.getBigInt();
        {
            boolean var715C4C2597076EBBD7DE116903FFEC43_1245169165 = (rhs.sign() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2056151822 = this;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_493741569 = new BigInteger(BigInt.subtraction(lhs, rhs));
        addTaint(value.getTaint());
        BigInteger varA7E53CE21691AB073D9660D615818899_1523426101; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1523426101 = varB4EAC82CA7396A68D541C85D26508E83_2056151822;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1523426101 = varB4EAC82CA7396A68D541C85D26508E83_493741569;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1523426101.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1523426101;
        // ---------- Original Method ----------
        //BigInt lhs = getBigInt();
        //BigInt rhs = value.getBigInt();
        //if (rhs.sign() == 0) {
            //return this;
        //}
        //return new BigInteger(BigInt.subtraction(lhs, rhs));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.542 -0400", hash_original_method = "0A534AADB97A9D37B49476B54B03D66A", hash_generated_method = "F600068442D549EF0C9B84C6278961F1")
    public int signum() {
        int var78785A1AB216D9DE61B723A960BFD6AE_499381314 = (getBigInt().sign());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992315479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992315479;
        // ---------- Original Method ----------
        //if (javaIsValid) {
            //return sign;
        //}
        //return getBigInt().sign();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.552 -0400", hash_original_method = "1B97FA7BE1DE29423609E814DD90E66F", hash_generated_method = "7211456D722CA665D0FEA87166AE7FB1")
    public BigInteger shiftRight(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1350005320 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1350005320 = shiftLeft(-n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_1350005320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1350005320;
        // ---------- Original Method ----------
        //return shiftLeft(-n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.620 -0400", hash_original_method = "3E0E92A5CC7CF6FE74FD251028917DBB", hash_generated_method = "475F3EE9EFDC30FCA2377B29E539BFD3")
    public BigInteger shiftLeft(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1302505582 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1169620201 = null; //Variable for return #2
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1945848303 = null; //Variable for return #3
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1852789011 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_1302505582 = this;
        } //End block
        int sign;
        sign = signum();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1169620201 = this;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1945848303 = new BigInteger(BigInt.shift(getBigInt(), n));
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1852789011 = BitLevel.shiftRight(this, -n);
        } //End block
        addTaint(n);
        BigInteger varA7E53CE21691AB073D9660D615818899_1724521611; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1724521611 = varB4EAC82CA7396A68D541C85D26508E83_1302505582;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1724521611 = varB4EAC82CA7396A68D541C85D26508E83_1169620201;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1724521611 = varB4EAC82CA7396A68D541C85D26508E83_1945848303;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1724521611 = varB4EAC82CA7396A68D541C85D26508E83_1852789011;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1724521611.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1724521611;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.621 -0400", hash_original_method = "3F948826829C47AB028976261F4B8D55", hash_generated_method = "3D3EF11C587A9D2328696588686B064F")
     BigInteger shiftLeftOneBit() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1255945769 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1255945769 = (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
        varB4EAC82CA7396A68D541C85D26508E83_1255945769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1255945769;
        // ---------- Original Method ----------
        //return (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.622 -0400", hash_original_method = "5DD770E4600136986E52E3D1EE5F1B27", hash_generated_method = "039BC42AE5644BF00EC9C331705280B4")
    public int bitLength() {
        {
            int varEF6F0F502ED0A4A2C2EE418CF96465E4_1196928387 = (BitLevel.bitLength(this));
        } //End block
        int var788BC3441C63E42B6C6F5C344E860F68_1462848084 = (getBigInt().bitLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316645247 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316645247;
        // ---------- Original Method ----------
        //if (!nativeIsValid && javaIsValid) {
            //return BitLevel.bitLength(this);
        //}
        //return getBigInt().bitLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.623 -0400", hash_original_method = "22DB08B3CA9DDA99CEE301218284C513", hash_generated_method = "EFF516B0C806E505126938ED7DAD9447")
    public boolean testBit(int n) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("n < 0: " + n);
        } //End block
        int sign;
        sign = signum();
        {
            boolean varF17D7AFCFA584F08AA65771D9B761AB7_498943562 = (getBigInt().isBitSet(n));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1337302297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1337302297;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.628 -0400", hash_original_method = "0A60006224C30F0C8DC4E0C8D16895AE", hash_generated_method = "70D84C82B1262C8EFB344CD380C66D2F")
    public BigInteger setBit(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1247049096 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1166000264 = null; //Variable for return #2
        prepareJavaRepresentation();
        {
            boolean var5D4D017D7F453054D257FB916BD85DB7_859768739 = (!testBit(n));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1247049096 = BitLevel.flipBit(this, n);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1166000264 = this;
            } //End block
        } //End collapsed parenthetic
        addTaint(n);
        BigInteger varA7E53CE21691AB073D9660D615818899_13706522; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_13706522 = varB4EAC82CA7396A68D541C85D26508E83_1247049096;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_13706522 = varB4EAC82CA7396A68D541C85D26508E83_1166000264;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_13706522.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_13706522;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (!testBit(n)) {
            //return BitLevel.flipBit(this, n);
        //} else {
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.633 -0400", hash_original_method = "8D8C5374E542B708B8A1B41B31DCBF03", hash_generated_method = "489FC68B3E2DE151A9D0AABEA1C872B6")
    public BigInteger clearBit(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_756184178 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1254048550 = null; //Variable for return #2
        prepareJavaRepresentation();
        {
            boolean varA357D3076F2B8D19676817F90ACD1333_1373078155 = (testBit(n));
            {
                varB4EAC82CA7396A68D541C85D26508E83_756184178 = BitLevel.flipBit(this, n);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1254048550 = this;
            } //End block
        } //End collapsed parenthetic
        addTaint(n);
        BigInteger varA7E53CE21691AB073D9660D615818899_1877463324; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1877463324 = varB4EAC82CA7396A68D541C85D26508E83_756184178;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1877463324 = varB4EAC82CA7396A68D541C85D26508E83_1254048550;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1877463324.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1877463324;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (testBit(n)) {
            //return BitLevel.flipBit(this, n);
        //} else {
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.634 -0400", hash_original_method = "F1D37134A8936EE90081AD78D8487F59", hash_generated_method = "3B88EFB7471D9E1799C119E8A942B117")
    public BigInteger flipBit(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2062771094 = null; //Variable for return #1
        prepareJavaRepresentation();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("n < 0: " + n);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2062771094 = BitLevel.flipBit(this, n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_2062771094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2062771094;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (n < 0) {
            //throw new ArithmeticException("n < 0: " + n);
        //}
        //return BitLevel.flipBit(this, n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.634 -0400", hash_original_method = "8383F139074E92B6BF621C4AC408CB05", hash_generated_method = "6E4FDE4DCEC927C70346B3EE220CE984")
    public int getLowestSetBit() {
        prepareJavaRepresentation();
        int i;
        i = getFirstNonzeroDigit();
        int var08486A238466E45EF685C7096473496F_613882592 = (((i << 5) + Integer.numberOfTrailingZeros(digits[i])));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135567846 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135567846;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (sign == 0) {
            //return -1;
        //}
        //int i = getFirstNonzeroDigit();
        //return ((i << 5) + Integer.numberOfTrailingZeros(digits[i]));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.635 -0400", hash_original_method = "2461573222D281ABCA9F3F34AA40AFB9", hash_generated_method = "ACC2028C29F0EA9546AC69E7DC07A50F")
    public int bitCount() {
        prepareJavaRepresentation();
        int var03F1A887008EE5D56B89D17C00839C9F_813776080 = (BitLevel.bitCount(this));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013067733 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013067733;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //return BitLevel.bitCount(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.644 -0400", hash_original_method = "CD87C1AB82AE5BD1BDB1D71C1F7F211A", hash_generated_method = "63146B76BC9834F752A9A9AD3FEB11B2")
    public BigInteger not() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1582326725 = null; //Variable for return #1
        this.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_1582326725 = Logical.not(this);
        varB4EAC82CA7396A68D541C85D26508E83_1582326725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1582326725;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //return Logical.not(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.644 -0400", hash_original_method = "B57E8848F50ED2CEFC86EA20A70D185D", hash_generated_method = "C34B471A9A507563133C30030A167601")
    public BigInteger and(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_192490926 = null; //Variable for return #1
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_192490926 = Logical.and(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_192490926.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_192490926;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.and(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.645 -0400", hash_original_method = "AED35BC9F3B39A40B35087479AE4F222", hash_generated_method = "77086F1BF036F52D0CDDB26DB9EEC806")
    public BigInteger or(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1503949610 = null; //Variable for return #1
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_1503949610 = Logical.or(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1503949610.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1503949610;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.or(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.646 -0400", hash_original_method = "0162D315FD06686CC7830A3D5D5A796E", hash_generated_method = "5D07BDEF641054874715A10ABC9B292B")
    public BigInteger xor(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1706466504 = null; //Variable for return #1
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_1706466504 = Logical.xor(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1706466504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1706466504;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.xor(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.647 -0400", hash_original_method = "A8A90B9F7EBADE4F51C070D1C780A515", hash_generated_method = "1A893B47342EF5B4749392EEC90276A5")
    public BigInteger andNot(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1306533540 = null; //Variable for return #1
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_1306533540 = Logical.andNot(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1306533540.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1306533540;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.andNot(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.647 -0400", hash_original_method = "F298334B66A6EA4DC89E250C44198AEA", hash_generated_method = "5FEBCBEF7D57B04B812CAD80F6CD8C9C")
    @Override
    public int intValue() {
        {
            boolean var736C79FFC0E47BDF554712724F023607_2010986313 = (nativeIsValid && bigInt.twosCompFitsIntoBytes(4));
            {
                int var3C648FDB51952E7A4326C06E11E5D714_461254623 = ((int) bigInt.longInt());
            } //End block
        } //End collapsed parenthetic
        this.prepareJavaRepresentation();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712656020 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712656020;
        // ---------- Original Method ----------
        //if (nativeIsValid && bigInt.twosCompFitsIntoBytes(4)) {
            //return (int) bigInt.longInt();
        //}
        //this.prepareJavaRepresentation();
        //return (sign * digits[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.657 -0400", hash_original_method = "22A0F6A18293749D1CD57F54133930DD", hash_generated_method = "7A1AA404F78ABA8F75B75DF944D537D7")
    @Override
    public long longValue() {
        {
            boolean varC4F1CBA5BA1CCD278A875F7CBF5B1567_1683071803 = (nativeIsValid && bigInt.twosCompFitsIntoBytes(8));
            {
                long var4AAAA41C9D1DFB9DDFD6709151B2DF14_101039311 = (bigInt.longInt());
            } //End block
        } //End collapsed parenthetic
        prepareJavaRepresentation();
        long value;
        value = ((long) digits[1]) << 32 | digits[0] & 0xFFFFFFFFL;
        value = digits[0] & 0xFFFFFFFFL;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_903769452 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_903769452;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.657 -0400", hash_original_method = "85C514A29B5895D821780B89C4F747B0", hash_generated_method = "45D106B47970740E89354895CEA47C66")
    @Override
    public float floatValue() {
        float var988FDD4E54336618413CB2C701826BC6_1088616665 = ((float) doubleValue());
        float var546ADE640B6EDFBC8A086EF31347E768_215516550 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_215516550;
        // ---------- Original Method ----------
        //return (float) doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.658 -0400", hash_original_method = "3D8E394E07D4F37AF2C6D72F08026A5D", hash_generated_method = "DAA6597CAE092E95F9EE5AFA0750C1EF")
    @Override
    public double doubleValue() {
        double var986CEBD15E6E1AF84E0E0543465AB73A_2050523350 = (Conversion.bigInteger2Double(this));
        double varE8CD7DA078A86726031AD64F35F5A6C0_1671625111 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1671625111;
        // ---------- Original Method ----------
        //return Conversion.bigInteger2Double(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.658 -0400", hash_original_method = "2F090DBB15C308A00016A444F7C5A620", hash_generated_method = "D28B59B518F02D9F21D96BF628C30655")
    public int compareTo(BigInteger value) {
        int varE8DF5E315CCF42EB1CBFEE65CA4A8DF2_1290576276 = (BigInt.cmp(getBigInt(), value.getBigInt()));
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1904539697 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1904539697;
        // ---------- Original Method ----------
        //return BigInt.cmp(getBigInt(), value.getBigInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.658 -0400", hash_original_method = "909F517DD4A19D55540D3A4577FBCF84", hash_generated_method = "BFE0155463F444F946C8C02EA00E71D3")
    public BigInteger min(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_486936240 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_486936240 = this.compareTo(value) == -1 ? this : value;
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_486936240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_486936240;
        // ---------- Original Method ----------
        //return this.compareTo(value) == -1 ? this : value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.659 -0400", hash_original_method = "6C03178B5A42138223A2B4814CF874FD", hash_generated_method = "560B484ABDBFB1BF84121A186F4A0DBE")
    public BigInteger max(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1891300826 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1891300826 = this.compareTo(value) == 1 ? this : value;
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1891300826.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1891300826;
        // ---------- Original Method ----------
        //return this.compareTo(value) == 1 ? this : value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.659 -0400", hash_original_method = "8BD8EE457DCE4BEA017BA4C9967BFC77", hash_generated_method = "1F8E59499DC7A950E0AB93D822787A39")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642761452 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642761452;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.664 -0400", hash_original_method = "D6CA37529D0AAA6915B88189BBB9DE43", hash_generated_method = "774A8A862AC9359FF21C36074DD2B39E")
    @Override
    public boolean equals(Object x) {
        {
            boolean var8C5538CAE31374871D89268FAA638122_2061137870 = (this.compareTo((BigInteger) x) == 0);
        } //End block
        addTaint(x.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1952727315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1952727315;
        // ---------- Original Method ----------
        //if (this == x) {
            //return true;
        //}
        //if (x instanceof BigInteger) {
            //return this.compareTo((BigInteger) x) == 0;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.665 -0400", hash_original_method = "466A78542936FDDF00F235F55782CDB1", hash_generated_method = "642F50FDD11D3C4C4B9247AE73390D7A")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1253317686 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1253317686 = getBigInt().decString();
        varB4EAC82CA7396A68D541C85D26508E83_1253317686.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1253317686;
        // ---------- Original Method ----------
        //return getBigInt().decString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.666 -0400", hash_original_method = "DC1B34095F4DDEED7FED4CD9DAE6BCA6", hash_generated_method = "8342F489C50554AAB1326973C29B9A26")
    public String toString(int radix) {
        String varB4EAC82CA7396A68D541C85D26508E83_2083975910 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1821704488 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2083975910 = getBigInt().decString();
        } //End block
        {
            prepareJavaRepresentation();
            varB4EAC82CA7396A68D541C85D26508E83_1821704488 = Conversion.bigInteger2String(this, radix);
        } //End block
        addTaint(radix);
        String varA7E53CE21691AB073D9660D615818899_1771801730; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1771801730 = varB4EAC82CA7396A68D541C85D26508E83_2083975910;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1771801730 = varB4EAC82CA7396A68D541C85D26508E83_1821704488;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1771801730.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1771801730;
        // ---------- Original Method ----------
        //if (radix == 10) {
            //return getBigInt().decString();
        //} else {
            //prepareJavaRepresentation();
            //return Conversion.bigInteger2String(this, radix);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.666 -0400", hash_original_method = "DF6919CA8C1CE81A76193FCEFAE3FDAA", hash_generated_method = "DEB18DC5DE6715D7837E5BD419CD2188")
    public BigInteger gcd(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1307647874 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1307647874 = new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1307647874.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1307647874;
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.672 -0400", hash_original_method = "7A377385A7A35B42B025ADA39BD9F319", hash_generated_method = "8DA2CCB535EB9E8B56FC8F114B43D278")
    public BigInteger multiply(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1982340447 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1982340447 = new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1982340447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1982340447;
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.672 -0400", hash_original_method = "670CEDEE32713500748765AA85174DA4", hash_generated_method = "DB811B301B5BC9A964F3D1F5A6E8E7EB")
    public BigInteger pow(int exp) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_201799483 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("exp < 0: " + exp);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_201799483 = new BigInteger(BigInt.exp(getBigInt(), exp));
        addTaint(exp);
        varB4EAC82CA7396A68D541C85D26508E83_201799483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_201799483;
        // ---------- Original Method ----------
        //if (exp < 0) {
            //throw new ArithmeticException("exp < 0: " + exp);
        //}
        //return new BigInteger(BigInt.exp(getBigInt(), exp));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.673 -0400", hash_original_method = "0021B26ACCFD58807A129BEBBFC75B78", hash_generated_method = "B6026742AF6AA40C05F29DF5E00D16AA")
    public BigInteger[] divideAndRemainder(BigInteger divisor) {
        BigInteger[] varB4EAC82CA7396A68D541C85D26508E83_2042482125 = null; //Variable for return #1
        BigInt divisorBigInt;
        divisorBigInt = divisor.getBigInt();
        BigInt quotient;
        quotient = new BigInt();
        BigInt remainder;
        remainder = new BigInt();
        BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        varB4EAC82CA7396A68D541C85D26508E83_2042482125 = new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2042482125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2042482125;
        // ---------- Original Method ----------
        //BigInt divisorBigInt = divisor.getBigInt();
        //BigInt quotient = new BigInt();
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        //return new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.673 -0400", hash_original_method = "E605E3D77E9B13D877DA6B6F47D67F1F", hash_generated_method = "3638BCA154EA92B4D298017FAE26622B")
    public BigInteger divide(BigInteger divisor) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_110034776 = null; //Variable for return #1
        BigInt quotient;
        quotient = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        varB4EAC82CA7396A68D541C85D26508E83_110034776 = new BigInteger(quotient);
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_110034776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_110034776;
        // ---------- Original Method ----------
        //BigInt quotient = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        //return new BigInteger(quotient);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.685 -0400", hash_original_method = "FFD2A7C70BA79F9B512531A9A18B49EF", hash_generated_method = "8C0862418D677E41D7655BCB3C96C14A")
    public BigInteger remainder(BigInteger divisor) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2050018883 = null; //Variable for return #1
        BigInt remainder;
        remainder = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        varB4EAC82CA7396A68D541C85D26508E83_2050018883 = new BigInteger(remainder);
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2050018883.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2050018883;
        // ---------- Original Method ----------
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        //return new BigInteger(remainder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.686 -0400", hash_original_method = "D09D0373DFB5DF67EDACA66D474BB75C", hash_generated_method = "75BE1649B463F1B895178B33B6D4657B")
    public BigInteger modInverse(BigInteger m) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1924720091 = null; //Variable for return #1
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_998794009 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("modulus not positive");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1924720091 = new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
        addTaint(m.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1924720091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1924720091;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("modulus not positive");
        //}
        //return new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.686 -0400", hash_original_method = "4B2E2C43A8E0C70699BFC0E4EF01E685", hash_generated_method = "19760D318E076FD96002D13CC22C17F0")
    public BigInteger modPow(BigInteger exponent, BigInteger m) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1445034719 = null; //Variable for return #1
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_161074520 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("m.signum() <= 0");
            } //End block
        } //End collapsed parenthetic
        BigInteger base;
        boolean varE2809D8580A02DD733D2DE31DC8AE895_1246565548 = (exponent.signum() < 0);
        base = modInverse(m);
        base = this;
        varB4EAC82CA7396A68D541C85D26508E83_1445034719 = new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
        addTaint(exponent.getTaint());
        addTaint(m.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1445034719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1445034719;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //BigInteger base = exponent.signum() < 0 ? modInverse(m) : this;
        //return new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.687 -0400", hash_original_method = "ADC51A8E4A4079F65268593A33DD74A7", hash_generated_method = "D00B03941917DB276C3529ADB10EA91E")
    public BigInteger mod(BigInteger m) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_223555240 = null; //Variable for return #1
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_257290299 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("m.signum() <= 0");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_223555240 = new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
        addTaint(m.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_223555240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_223555240;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //return new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.691 -0400", hash_original_method = "718D211034BAE1DECACA1D72CB4CBB13", hash_generated_method = "205037BDB66BB31DE2A2F806CCC3762E")
    public boolean isProbablePrime(int certainty) {
        boolean var527C2D985EF61BA5C7404EDA1C84F2DB_651055758 = (getBigInt().isPrime(certainty));
        addTaint(certainty);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016939668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016939668;
        // ---------- Original Method ----------
        //if (certainty <= 0) {
            //return true;
        //}
        //return getBigInt().isPrime(certainty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.707 -0400", hash_original_method = "BB43921F4E806BD72B6F518E8CD8937B", hash_generated_method = "A5915FBF7129E546DA0194E1E44B936E")
    public BigInteger nextProbablePrime() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1547436392 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("sign < 0");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1547436392 = Primality.nextProbablePrime(this);
        varB4EAC82CA7396A68D541C85D26508E83_1547436392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1547436392;
        // ---------- Original Method ----------
        //if (sign < 0) {
            //throw new ArithmeticException("sign < 0");
        //}
        //return Primality.nextProbablePrime(this);
    }

    
        public static BigInteger probablePrime(int bitLength, Random unused) {
        return new BigInteger(bitLength, 100, unused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.710 -0400", hash_original_method = "F2F8EDC382104DB344E8DD617201B0F3", hash_generated_method = "B20B4F214B82E4B400E9349ED7694A43")
    private byte[] twosComplement() {
        prepareJavaRepresentation();
        {
            byte[] var871F8A6A5DD979D0CBC073DD77C1CF91_871387654 = (new byte[] { 0 });
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1102504181 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1102504181;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.715 -0400", hash_original_method = "4BA60B28A036933466CC713B9C7854B3", hash_generated_method = "C0FAF23AD8B8DD21F134C46C40099717")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260773046 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260773046;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.722 -0400", hash_original_method = "FABC86F56C336DE2152BE8F133BAAD74", hash_generated_method = "232A9A799ACB0017F538B738071F3D5C")
     BigInteger copy() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1571979186 = null; //Variable for return #1
        prepareJavaRepresentation();
        int[] copyDigits;
        copyDigits = new int[numberLength];
        System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        varB4EAC82CA7396A68D541C85D26508E83_1571979186 = new BigInteger(sign, numberLength, copyDigits);
        varB4EAC82CA7396A68D541C85D26508E83_1571979186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1571979186;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //int[] copyDigits = new int[numberLength];
        //System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        //return new BigInteger(sign, numberLength, copyDigits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.723 -0400", hash_original_method = "883E43F5C4566D0C2A7853533F533817", hash_generated_method = "26081922C42C9651482BD8CDA83FCE2C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.723 -0400", hash_original_method = "4837A11F07A86A58815A56F1112D57DF", hash_generated_method = "E6B2FEC6F5BDFA37D2A8196B99A86AEC")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.723 -0400", hash_original_field = "63016A922509DF10F65084D6222C77C8", hash_generated_field = "2BEA6AB5FBF34BD6FB442D8BA65065DF")

    private static long serialVersionUID = -8287574255936472291L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.723 -0400", hash_original_field = "78897A137AA91788C51A9D5D88BD6B22", hash_generated_field = "26A57E8798A6CA862A91D3C87254CE3F")

    public static final BigInteger ZERO = new BigInteger(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.723 -0400", hash_original_field = "E938017D6125C253391B6FF2A79B2347", hash_generated_field = "61E4C0227042D85901BA98B2F2CD52C4")

    public static final BigInteger ONE = new BigInteger(1, 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.723 -0400", hash_original_field = "4252D38540440B1F1E5C9806E972B4B1", hash_generated_field = "7A2B2FAA86270609C420795EB3DF7501")

    public static final BigInteger TEN = new BigInteger(1, 10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.723 -0400", hash_original_field = "C8DE16A040E4D20B9E7749B6EA765BF0", hash_generated_field = "263B59B8310B73C674B762005157A3FB")

    static BigInteger MINUS_ONE = new BigInteger(-1, 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.723 -0400", hash_original_field = "43E384A873FB243B7D032AB564F5C6C0", hash_generated_field = "F46E265CAF65100D4BE9D793DD0AD694")

    static BigInteger[] SMALL_VALUES = ;
}

