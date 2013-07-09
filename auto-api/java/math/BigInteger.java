package java.math;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class BigInteger extends Number implements Comparable<BigInteger>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.562 -0400", hash_original_field = "33A2DB2A239C5BAAA46376495EE5F6ED", hash_generated_field = "1B931597CE47BECC94315E7FDFB3AE18")

    private transient BigInt bigInt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.562 -0400", hash_original_field = "F0121707B716C3D41C45CEC890F8FEBD", hash_generated_field = "B1CF9FA5CC5896A14634587A7438CDD0")

    private transient boolean nativeIsValid = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.562 -0400", hash_original_field = "562B560548EAC394A69BD390BABAEBE5", hash_generated_field = "36EDDB91E81C2B3A992259BBDA560C8D")

    private transient boolean javaIsValid = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.562 -0400", hash_original_field = "A2AACBD15B619A9B9E5581A6C33BD2B1", hash_generated_field = "EF92B8843E3664BCE02DEF9DAE8B81D8")

    transient int[] digits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.562 -0400", hash_original_field = "56F736C2BD891F3A00F34C71E5AD8378", hash_generated_field = "49E386B29ED8E51F4B9308F78ED67301")

    transient int numberLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.562 -0400", hash_original_field = "04B29480233F4DEF5C875875B6BDC3B1", hash_generated_field = "92BF56588B083F4EFC932B66DB92601C")

    transient int sign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.562 -0400", hash_original_field = "553C03BFED44A9505466470F56E3ADC5", hash_generated_field = "6063015DEF6F532F83AE577B35CA2F93")

    private transient int firstNonzeroDigit = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.562 -0400", hash_original_field = "327B0A3531EA3D97749FE579CC4632A4", hash_generated_field = "9E963B134F5112D99A51A8B2403DC06B")

    private int signum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.562 -0400", hash_original_field = "28C3D8F4B7E312AF5E0D6B59A50EFD1C", hash_generated_field = "62EEE6A49B1745E7CDFD636319A9ED04")

    private byte[] magnitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.562 -0400", hash_original_field = "B81E47D2AA677809E4BE3C9232B2407F", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.563 -0400", hash_original_method = "E2046ACAAE3FADB78A197B33030B87EF", hash_generated_method = "A09E606E6464EB83AACE309EF804020E")
      BigInteger(BigInt bigInt) {
        {
            boolean varCBCE59BC652D0587CC25D4F0C19CC324_922056636 = (bigInt == null || bigInt.getNativeBIGNUM() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } 
        } 
        setBigInt(bigInt);
        addTaint(bigInt.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.563 -0400", hash_original_method = "6A0326FFA4F8DFD22C6BE505D4303A06", hash_generated_method = "178D26DF38FA6841B47EBC9E245CB303")
      BigInteger(int sign, long value) {
        BigInt bigInt = new BigInt();
        bigInt.putULongInt(value, (sign < 0));
        setBigInt(bigInt);
        addTaint(sign);
        addTaint(value);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.564 -0400", hash_original_method = "8FE766A630C587CF3D36C6776BEC57AB", hash_generated_method = "9D5A992E0E61ADC1EA67DF0D6E21AF4A")
      BigInteger(int sign, int numberLength, int[] digits) {
        setJavaRepresentation(sign, numberLength, digits);
        addTaint(sign);
        addTaint(numberLength);
        addTaint(digits[0]);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.564 -0400", hash_original_method = "0CDCBE4F35D9E336AD3EE0D0E2D0776D", hash_generated_method = "7F9B46B7E83C2CD7EB545772870BD94E")
    public  BigInteger(int numBits, Random random) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("numBits < 0: " + numBits);
        } 
        {
            setJavaRepresentation(0, 1, new int[] { 0 });
        } 
        {
            int sign = 1;
            int numberLength = (numBits + 31) >> 5;
            int[] digits = new int[numberLength];
            {
                int i = 0;
                {
                    digits[i] = random.nextInt();
                } 
            } 
            digits[numberLength - 1] >>>= (-numBits) & 31;
            setJavaRepresentation(sign, numberLength, digits);
        } 
        javaIsValid = true;
        
        
            
        
        
            
        
            
            
            
            
                
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.565 -0400", hash_original_method = "E06C60E93C7C91BB266029ED9C3D532A", hash_generated_method = "96E12250D1C79C6C0E675539E8BA8DB3")
    public  BigInteger(int bitLength, int certainty, Random unused) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("bitLength < 2: " + bitLength);
        } 
        setBigInt(BigInt.generatePrimeDefault(bitLength));
        addTaint(bitLength);
        addTaint(certainty);
        addTaint(unused.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.565 -0400", hash_original_method = "858DE6DF463E0F4BFB47F99F590AB0EF", hash_generated_method = "52841481AB8DA2D65ABFFD712C047BED")
    public  BigInteger(String value) {
        BigInt bigInt = new BigInt();
        bigInt.putDecString(value);
        setBigInt(bigInt);
        addTaint(value.getTaint());
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.566 -0400", hash_original_method = "A13EC41ACC3DF589C11C4779074EEB6B", hash_generated_method = "5745DE8EB9449C40E2FACAAAA57EE39E")
    public  BigInteger(String value, int radix) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("value == null");
        } 
        {
            BigInt bigInt = new BigInt();
            bigInt.putDecString(value);
            setBigInt(bigInt);
        } 
        {
            BigInt bigInt = new BigInt();
            bigInt.putHexString(value);
            setBigInt(bigInt);
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Invalid radix: " + radix);
            } 
            {
                boolean var61FDD46CB4F2D30108ACB79894E33C39_1151713102 = (value.isEmpty());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("value.isEmpty()");
                } 
            } 
            BigInteger.parseFromString(this, value, radix);
        } 
        addTaint(value.getTaint());
        addTaint(radix);
        
        
            
        
        
            
            
            
        
            
            
            
        
            
                
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.570 -0400", hash_original_method = "4725614D4A9FDEE6DBC2F6DB247469CF", hash_generated_method = "BA6C0ACA323D039E0FFFE53F21FCE09D")
    public  BigInteger(int signum, byte[] magnitude) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("magnitude == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Invalid signum: " + signum);
        } 
        {
            {
                byte element = magnitude[0];
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("signum-magnitude mismatch");
                    } 
                } 
            } 
        } 
        BigInt bigInt = new BigInt();
        bigInt.putBigEndian(magnitude, signum < 0);
        setBigInt(bigInt);
        addTaint(signum);
        addTaint(magnitude[0]);
        
        
            
        
        
            
        
        
            
                
                    
                
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.570 -0400", hash_original_method = "ABB1E16F13BE7B2CA5EC1AADB52B2350", hash_generated_method = "6B072CDA4BAFF0CF5D571B2F4B5D3ABB")
    public  BigInteger(byte[] value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("value.length == 0");
        } 
        BigInt bigInt = new BigInt();
        bigInt.putBigEndianTwosComplement(value);
        setBigInt(bigInt);
        addTaint(value[0]);
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.571 -0400", hash_original_method = "7B92331634E6E3BE19D048B912B09B7F", hash_generated_method = "F387D03F096887BED26E9E02FB32EF25")
     BigInt getBigInt() {
        BigInt varB4EAC82CA7396A68D541C85D26508E83_918386367 = null; 
        BigInt varB4EAC82CA7396A68D541C85D26508E83_955962232 = null; 
        BigInt varB4EAC82CA7396A68D541C85D26508E83_659584467 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_918386367 = bigInt;
        } 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_955962232 = bigInt;
            } 
            BigInt bigInt = new BigInt();
            bigInt.putLittleEndianInts(digits, (sign < 0));
            setBigInt(bigInt);
            varB4EAC82CA7396A68D541C85D26508E83_659584467 = bigInt;
        } 
        BigInt varA7E53CE21691AB073D9660D615818899_1009195178; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1009195178 = varB4EAC82CA7396A68D541C85D26508E83_918386367;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1009195178 = varB4EAC82CA7396A68D541C85D26508E83_955962232;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1009195178 = varB4EAC82CA7396A68D541C85D26508E83_659584467;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1009195178.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1009195178;
        
        
            
        
        
            
                
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.571 -0400", hash_original_method = "CC364AFCED646D5BD618C239A0F61C61", hash_generated_method = "FB8F32B7985E2B240502D873FAE13D52")
    private void setBigInt(BigInt bigInt) {
        this.bigInt = bigInt;
        this.nativeIsValid = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.571 -0400", hash_original_method = "DA7CFD2DB9135F0E2C89139BCCCBB12F", hash_generated_method = "0F64427ABCDD686DC8AEFEEE13813050")
    private void setJavaRepresentation(int sign, int numberLength, int[] digits) {
        {
            ;
        } 
        {
            sign = 0;
        } 
        this.sign = sign;
        this.digits = digits;
        this.numberLength = numberLength;
        this.javaIsValid = true;
        
        
            
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.572 -0400", hash_original_method = "E11A76F306D885B62849938EE7ACFF1F", hash_generated_method = "AC2BEF0A1DB61768713D6C33C1277B8B")
     void prepareJavaRepresentation() {
        {
            int sign = bigInt.sign();
            int[] digits;
            digits = bigInt.littleEndianIntsMagnitude();
            digits = new int[] { 0 };
            setJavaRepresentation(sign, digits.length, digits);
        } 
        
        
            
        
        
            
                
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.572 -0400", hash_original_method = "F45D943577A758DE4A75A5CD2DF6D206", hash_generated_method = "2F87C908748A86B9896A3FF6F423E8CF")
    public byte[] toByteArray() {
        byte[] var3BE346B2FB665BD8F6B33361C4C01498_179556928 = (twosComplement());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_630993023 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_630993023;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.573 -0400", hash_original_method = "4D099B3B9B18238917CAE07611FC89C9", hash_generated_method = "497FF3D8465B85607CD58D0831432E48")
    public BigInteger abs() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_897011774 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1309900935 = null; 
        BigInt bigInt = getBigInt();
        {
            boolean var62DB935F980131F1A8A6EA88CF668813_694392085 = (bigInt.sign() >= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_897011774 = this;
            } 
        } 
        BigInt a = bigInt.copy();
        a.setSign(1);
        varB4EAC82CA7396A68D541C85D26508E83_1309900935 = new BigInteger(a);
        BigInteger varA7E53CE21691AB073D9660D615818899_1990908221; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1990908221 = varB4EAC82CA7396A68D541C85D26508E83_897011774;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1990908221 = varB4EAC82CA7396A68D541C85D26508E83_1309900935;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1990908221.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1990908221;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.573 -0400", hash_original_method = "DFABA71B5B9AE3E4CD65AD4AD666E31C", hash_generated_method = "A87A0BD04DA64C3D1F43EC5FFD3CC124")
    public BigInteger negate() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_54709732 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_329899734 = null; 
        BigInt bigInt = getBigInt();
        int sign = bigInt.sign();
        {
            varB4EAC82CA7396A68D541C85D26508E83_54709732 = this;
        } 
        BigInt a = bigInt.copy();
        a.setSign(-sign);
        varB4EAC82CA7396A68D541C85D26508E83_329899734 = new BigInteger(a);
        BigInteger varA7E53CE21691AB073D9660D615818899_302703883; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_302703883 = varB4EAC82CA7396A68D541C85D26508E83_54709732;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_302703883 = varB4EAC82CA7396A68D541C85D26508E83_329899734;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_302703883.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_302703883;
        
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.574 -0400", hash_original_method = "5B8AB174D1647BD6610121BBBEE51EE5", hash_generated_method = "7E5BFF806CBE79AA33E35B687E1465E1")
    public BigInteger add(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2021281243 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_987975445 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1082287603 = null; 
        BigInt lhs = getBigInt();
        BigInt rhs = value.getBigInt();
        {
            boolean var715C4C2597076EBBD7DE116903FFEC43_1251194179 = (rhs.sign() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2021281243 = this;
            } 
        } 
        {
            boolean var5A6924AA8D9332981417DC839AF99791_648795579 = (lhs.sign() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_987975445 = value;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1082287603 = new BigInteger(BigInt.addition(lhs, rhs));
        addTaint(value.getTaint());
        BigInteger varA7E53CE21691AB073D9660D615818899_1972912891; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1972912891 = varB4EAC82CA7396A68D541C85D26508E83_2021281243;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1972912891 = varB4EAC82CA7396A68D541C85D26508E83_987975445;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1972912891 = varB4EAC82CA7396A68D541C85D26508E83_1082287603;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1972912891.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1972912891;
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.574 -0400", hash_original_method = "753BA04897A44EE33BA2055C50810858", hash_generated_method = "E58BEFF5F526FDF184F25E8929F2D526")
    public BigInteger subtract(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_251694600 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1288436762 = null; 
        BigInt lhs = getBigInt();
        BigInt rhs = value.getBigInt();
        {
            boolean var715C4C2597076EBBD7DE116903FFEC43_2037275683 = (rhs.sign() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_251694600 = this;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1288436762 = new BigInteger(BigInt.subtraction(lhs, rhs));
        addTaint(value.getTaint());
        BigInteger varA7E53CE21691AB073D9660D615818899_2038325093; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2038325093 = varB4EAC82CA7396A68D541C85D26508E83_251694600;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2038325093 = varB4EAC82CA7396A68D541C85D26508E83_1288436762;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2038325093.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2038325093;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.575 -0400", hash_original_method = "0A534AADB97A9D37B49476B54B03D66A", hash_generated_method = "047B12B26A241EEC2746451767B42F52")
    public int signum() {
        int var78785A1AB216D9DE61B723A960BFD6AE_83062282 = (getBigInt().sign());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645300248 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645300248;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.575 -0400", hash_original_method = "1B97FA7BE1DE29423609E814DD90E66F", hash_generated_method = "DBAC374C41A2A0FA469605D6C3253CD4")
    public BigInteger shiftRight(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1585427938 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1585427938 = shiftLeft(-n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_1585427938.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1585427938;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.576 -0400", hash_original_method = "3E0E92A5CC7CF6FE74FD251028917DBB", hash_generated_method = "3A3C3D93D1BB5707C7AD88B20C243BCE")
    public BigInteger shiftLeft(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1177387295 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1556152643 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1651207215 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2087573346 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1177387295 = this;
        } 
        int sign = signum();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1556152643 = this;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1651207215 = new BigInteger(BigInt.shift(getBigInt(), n));
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2087573346 = BitLevel.shiftRight(this, -n);
        } 
        addTaint(n);
        BigInteger varA7E53CE21691AB073D9660D615818899_1474178317; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1474178317 = varB4EAC82CA7396A68D541C85D26508E83_1177387295;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1474178317 = varB4EAC82CA7396A68D541C85D26508E83_1556152643;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1474178317 = varB4EAC82CA7396A68D541C85D26508E83_1651207215;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1474178317 = varB4EAC82CA7396A68D541C85D26508E83_2087573346;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1474178317.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1474178317;
        
        
            
        
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.576 -0400", hash_original_method = "3F948826829C47AB028976261F4B8D55", hash_generated_method = "57A08DF084DE62F0B1BF65FCC6BB7651")
     BigInteger shiftLeftOneBit() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2144515070 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2144515070 = (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
        varB4EAC82CA7396A68D541C85D26508E83_2144515070.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2144515070;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.577 -0400", hash_original_method = "5DD770E4600136986E52E3D1EE5F1B27", hash_generated_method = "48ECB33EE54F45C6AD12B752152A42D0")
    public int bitLength() {
        {
            int varEF6F0F502ED0A4A2C2EE418CF96465E4_1242800703 = (BitLevel.bitLength(this));
        } 
        int var788BC3441C63E42B6C6F5C344E860F68_2113904813 = (getBigInt().bitLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817021822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817021822;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.578 -0400", hash_original_method = "22DB08B3CA9DDA99CEE301218284C513", hash_generated_method = "7FA4FEFCA6205C650840D3E25D31D94B")
    public boolean testBit(int n) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("n < 0: " + n);
        } 
        int sign = signum();
        {
            boolean varF17D7AFCFA584F08AA65771D9B761AB7_1882337549 = (getBigInt().isBitSet(n));
        } 
        {
            prepareJavaRepresentation();
            int intCount = n >> 5;
            int digit = digits[intCount];
            n = (1 << (n & 31));
            {
                int firstNonZeroDigit = getFirstNonzeroDigit();
                {
                    digit = -digit;
                } 
                {
                    digit = ~digit;
                } 
            } 
        } 
        addTaint(n);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1669531824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1669531824;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.579 -0400", hash_original_method = "0A60006224C30F0C8DC4E0C8D16895AE", hash_generated_method = "A28147B9456E5115AB27095630B457C0")
    public BigInteger setBit(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_405379299 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1180814341 = null; 
        prepareJavaRepresentation();
        {
            boolean var5D4D017D7F453054D257FB916BD85DB7_614850685 = (!testBit(n));
            {
                varB4EAC82CA7396A68D541C85D26508E83_405379299 = BitLevel.flipBit(this, n);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1180814341 = this;
            } 
        } 
        addTaint(n);
        BigInteger varA7E53CE21691AB073D9660D615818899_2119901403; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2119901403 = varB4EAC82CA7396A68D541C85D26508E83_405379299;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2119901403 = varB4EAC82CA7396A68D541C85D26508E83_1180814341;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2119901403.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2119901403;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.580 -0400", hash_original_method = "8D8C5374E542B708B8A1B41B31DCBF03", hash_generated_method = "D9847AD00B7B2D47F14F8BCB4CE6FEAB")
    public BigInteger clearBit(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_892530878 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1468214697 = null; 
        prepareJavaRepresentation();
        {
            boolean varA357D3076F2B8D19676817F90ACD1333_923997944 = (testBit(n));
            {
                varB4EAC82CA7396A68D541C85D26508E83_892530878 = BitLevel.flipBit(this, n);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1468214697 = this;
            } 
        } 
        addTaint(n);
        BigInteger varA7E53CE21691AB073D9660D615818899_103407704; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_103407704 = varB4EAC82CA7396A68D541C85D26508E83_892530878;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_103407704 = varB4EAC82CA7396A68D541C85D26508E83_1468214697;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_103407704.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_103407704;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.581 -0400", hash_original_method = "F1D37134A8936EE90081AD78D8487F59", hash_generated_method = "4392893A9D7A48145FEA0F1324E05895")
    public BigInteger flipBit(int n) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_721232284 = null; 
        prepareJavaRepresentation();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("n < 0: " + n);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_721232284 = BitLevel.flipBit(this, n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_721232284.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_721232284;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.581 -0400", hash_original_method = "8383F139074E92B6BF621C4AC408CB05", hash_generated_method = "36A3B586A2221945F07E82641968FC35")
    public int getLowestSetBit() {
        prepareJavaRepresentation();
        int i = getFirstNonzeroDigit();
        int var08486A238466E45EF685C7096473496F_377707596 = (((i << 5) + Integer.numberOfTrailingZeros(digits[i])));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744808003 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744808003;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.582 -0400", hash_original_method = "2461573222D281ABCA9F3F34AA40AFB9", hash_generated_method = "D17D65F91B1C55F47D15A38C91ABDDAC")
    public int bitCount() {
        prepareJavaRepresentation();
        int var03F1A887008EE5D56B89D17C00839C9F_30960759 = (BitLevel.bitCount(this));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803253061 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803253061;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.583 -0400", hash_original_method = "CD87C1AB82AE5BD1BDB1D71C1F7F211A", hash_generated_method = "4814A85AA117389384BED112910415D1")
    public BigInteger not() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1503730343 = null; 
        this.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_1503730343 = Logical.not(this);
        varB4EAC82CA7396A68D541C85D26508E83_1503730343.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1503730343;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.583 -0400", hash_original_method = "B57E8848F50ED2CEFC86EA20A70D185D", hash_generated_method = "4421D09BC32D4C783A19C3D02B7D699E")
    public BigInteger and(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_578250896 = null; 
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_578250896 = Logical.and(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_578250896.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_578250896;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.584 -0400", hash_original_method = "AED35BC9F3B39A40B35087479AE4F222", hash_generated_method = "B5F4219735F528A8102F191CD29370FE")
    public BigInteger or(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_429872573 = null; 
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_429872573 = Logical.or(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_429872573.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_429872573;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.584 -0400", hash_original_method = "0162D315FD06686CC7830A3D5D5A796E", hash_generated_method = "30092EB9AE502AD0A00E4ACFB029C56F")
    public BigInteger xor(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_660686492 = null; 
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_660686492 = Logical.xor(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_660686492.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_660686492;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.586 -0400", hash_original_method = "A8A90B9F7EBADE4F51C070D1C780A515", hash_generated_method = "C2294CDAC0EF5449EBFF6B7C44EF5BDE")
    public BigInteger andNot(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_537900358 = null; 
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        varB4EAC82CA7396A68D541C85D26508E83_537900358 = Logical.andNot(this, value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_537900358.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_537900358;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.586 -0400", hash_original_method = "F298334B66A6EA4DC89E250C44198AEA", hash_generated_method = "252468DCA41BA683013DCCE7387BAB06")
    @Override
    public int intValue() {
        {
            boolean var736C79FFC0E47BDF554712724F023607_1722896806 = (nativeIsValid && bigInt.twosCompFitsIntoBytes(4));
            {
                int var3C648FDB51952E7A4326C06E11E5D714_879972604 = ((int) bigInt.longInt());
            } 
        } 
        this.prepareJavaRepresentation();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1480492705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1480492705;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.587 -0400", hash_original_method = "22A0F6A18293749D1CD57F54133930DD", hash_generated_method = "9FE50187AE1F275692321E52143F190A")
    @Override
    public long longValue() {
        {
            boolean varC4F1CBA5BA1CCD278A875F7CBF5B1567_1264776635 = (nativeIsValid && bigInt.twosCompFitsIntoBytes(8));
            {
                long var4AAAA41C9D1DFB9DDFD6709151B2DF14_257756368 = (bigInt.longInt());
            } 
        } 
        prepareJavaRepresentation();
        long value;
        value = ((long) digits[1]) << 32 | digits[0] & 0xFFFFFFFFL;
        value = digits[0] & 0xFFFFFFFFL;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_854330709 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_854330709;
        
        
            
        
        
        
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.588 -0400", hash_original_method = "85C514A29B5895D821780B89C4F747B0", hash_generated_method = "6B0A862D8D09BD76644D68DDD2B403E4")
    @Override
    public float floatValue() {
        float var988FDD4E54336618413CB2C701826BC6_1011100165 = ((float) doubleValue());
        float var546ADE640B6EDFBC8A086EF31347E768_1492226090 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1492226090;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.589 -0400", hash_original_method = "3D8E394E07D4F37AF2C6D72F08026A5D", hash_generated_method = "62C0CF1AB2D4D3AFDA969E20C78B54C8")
    @Override
    public double doubleValue() {
        double var986CEBD15E6E1AF84E0E0543465AB73A_1350695128 = (Conversion.bigInteger2Double(this));
        double varE8CD7DA078A86726031AD64F35F5A6C0_1623255977 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1623255977;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.591 -0400", hash_original_method = "2F090DBB15C308A00016A444F7C5A620", hash_generated_method = "FE78D147177201F9961CB73D7FF3B947")
    public int compareTo(BigInteger value) {
        int varE8DF5E315CCF42EB1CBFEE65CA4A8DF2_925064574 = (BigInt.cmp(getBigInt(), value.getBigInt()));
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108327003 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108327003;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.594 -0400", hash_original_method = "909F517DD4A19D55540D3A4577FBCF84", hash_generated_method = "12F08AE62F178CF99FDF778CBFDEE2BC")
    public BigInteger min(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_890799292 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_890799292 = this.compareTo(value) == -1 ? this : value;
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_890799292.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_890799292;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.595 -0400", hash_original_method = "6C03178B5A42138223A2B4814CF874FD", hash_generated_method = "FA9EB85C63C71242658AAF0AAA3780F2")
    public BigInteger max(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1280010708 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1280010708 = this.compareTo(value) == 1 ? this : value;
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1280010708.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1280010708;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.597 -0400", hash_original_method = "8BD8EE457DCE4BEA017BA4C9967BFC77", hash_generated_method = "5B42CD83A9C38391D6FF7DD49B8EFCED")
    @Override
    public int hashCode() {
        prepareJavaRepresentation();
        {
            int i = 0;
            {
                hashCode = hashCode * 33 + digits[i];
            } 
        } 
        hashCode = hashCode * sign;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574240269 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574240269;
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.597 -0400", hash_original_method = "D6CA37529D0AAA6915B88189BBB9DE43", hash_generated_method = "8CB76F995017BCB5E87E8AAE3C33A6C1")
    @Override
    public boolean equals(Object x) {
        {
            boolean var8C5538CAE31374871D89268FAA638122_523217262 = (this.compareTo((BigInteger) x) == 0);
        } 
        addTaint(x.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_406930365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_406930365;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.599 -0400", hash_original_method = "466A78542936FDDF00F235F55782CDB1", hash_generated_method = "938B428B717DC15863EE8180C40D9129")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2091015514 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2091015514 = getBigInt().decString();
        varB4EAC82CA7396A68D541C85D26508E83_2091015514.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2091015514;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.600 -0400", hash_original_method = "DC1B34095F4DDEED7FED4CD9DAE6BCA6", hash_generated_method = "9D633B155ED771C894BBE6D24D33209D")
    public String toString(int radix) {
        String varB4EAC82CA7396A68D541C85D26508E83_2075430653 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1133375007 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2075430653 = getBigInt().decString();
        } 
        {
            prepareJavaRepresentation();
            varB4EAC82CA7396A68D541C85D26508E83_1133375007 = Conversion.bigInteger2String(this, radix);
        } 
        addTaint(radix);
        String varA7E53CE21691AB073D9660D615818899_881503719; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_881503719 = varB4EAC82CA7396A68D541C85D26508E83_2075430653;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_881503719 = varB4EAC82CA7396A68D541C85D26508E83_1133375007;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_881503719.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_881503719;
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.601 -0400", hash_original_method = "DF6919CA8C1CE81A76193FCEFAE3FDAA", hash_generated_method = "D367BF6C3EB8D943359FDB8114A46895")
    public BigInteger gcd(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_56525478 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_56525478 = new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_56525478.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_56525478;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.602 -0400", hash_original_method = "7A377385A7A35B42B025ADA39BD9F319", hash_generated_method = "3FD3016A7C2494EC74365FD1A789EADC")
    public BigInteger multiply(BigInteger value) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1680532942 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1680532942 = new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1680532942.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1680532942;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.602 -0400", hash_original_method = "670CEDEE32713500748765AA85174DA4", hash_generated_method = "4666DB4D363FCBA4C242B07B97659092")
    public BigInteger pow(int exp) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1939853814 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("exp < 0: " + exp);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1939853814 = new BigInteger(BigInt.exp(getBigInt(), exp));
        addTaint(exp);
        varB4EAC82CA7396A68D541C85D26508E83_1939853814.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1939853814;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.603 -0400", hash_original_method = "0021B26ACCFD58807A129BEBBFC75B78", hash_generated_method = "A4CB9B459F37E07B826FDB08C726E249")
    public BigInteger[] divideAndRemainder(BigInteger divisor) {
        BigInteger[] varB4EAC82CA7396A68D541C85D26508E83_342116114 = null; 
        BigInt divisorBigInt = divisor.getBigInt();
        BigInt quotient = new BigInt();
        BigInt remainder = new BigInt();
        BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        varB4EAC82CA7396A68D541C85D26508E83_342116114 = new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_342116114.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_342116114;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.603 -0400", hash_original_method = "E605E3D77E9B13D877DA6B6F47D67F1F", hash_generated_method = "102BB8C5EBDAF7F1C3E9F618AFAF32D4")
    public BigInteger divide(BigInteger divisor) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1676714767 = null; 
        BigInt quotient = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        varB4EAC82CA7396A68D541C85D26508E83_1676714767 = new BigInteger(quotient);
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1676714767.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1676714767;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.604 -0400", hash_original_method = "FFD2A7C70BA79F9B512531A9A18B49EF", hash_generated_method = "D64A55700270C43C9FFFDB6379C1EFD6")
    public BigInteger remainder(BigInteger divisor) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_445720609 = null; 
        BigInt remainder = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        varB4EAC82CA7396A68D541C85D26508E83_445720609 = new BigInteger(remainder);
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_445720609.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_445720609;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.605 -0400", hash_original_method = "D09D0373DFB5DF67EDACA66D474BB75C", hash_generated_method = "81ECB6DD0E8B19FF18F0A2CAFAA6DF7D")
    public BigInteger modInverse(BigInteger m) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1002387296 = null; 
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_376108365 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("modulus not positive");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1002387296 = new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
        addTaint(m.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1002387296.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1002387296;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.605 -0400", hash_original_method = "4B2E2C43A8E0C70699BFC0E4EF01E685", hash_generated_method = "352F10B954F331376A8802B3A007D134")
    public BigInteger modPow(BigInteger exponent, BigInteger m) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_122819236 = null; 
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_1899374109 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("m.signum() <= 0");
            } 
        } 
        BigInteger base;
        boolean varE2809D8580A02DD733D2DE31DC8AE895_788162671 = (exponent.signum() < 0);
        base = modInverse(m);
        base = this;
        varB4EAC82CA7396A68D541C85D26508E83_122819236 = new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
        addTaint(exponent.getTaint());
        addTaint(m.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_122819236.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_122819236;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.606 -0400", hash_original_method = "ADC51A8E4A4079F65268593A33DD74A7", hash_generated_method = "18EF6A7A3169FF5AD7589DBEBB8DD943")
    public BigInteger mod(BigInteger m) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1404583373 = null; 
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_597517806 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("m.signum() <= 0");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1404583373 = new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
        addTaint(m.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1404583373.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1404583373;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.608 -0400", hash_original_method = "718D211034BAE1DECACA1D72CB4CBB13", hash_generated_method = "BFC2E4FDB6F548EC38C205A37DEF6700")
    public boolean isProbablePrime(int certainty) {
        boolean var527C2D985EF61BA5C7404EDA1C84F2DB_1383473566 = (getBigInt().isPrime(certainty));
        addTaint(certainty);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1132462693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1132462693;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.610 -0400", hash_original_method = "BB43921F4E806BD72B6F518E8CD8937B", hash_generated_method = "A0A203265CDCCD8DCF9197C397DC03A0")
    public BigInteger nextProbablePrime() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1504291881 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("sign < 0");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1504291881 = Primality.nextProbablePrime(this);
        varB4EAC82CA7396A68D541C85D26508E83_1504291881.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1504291881;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static BigInteger probablePrime(int bitLength, Random unused) {
        return new BigInteger(bitLength, 100, unused);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.612 -0400", hash_original_method = "F2F8EDC382104DB344E8DD617201B0F3", hash_generated_method = "B790C77B141F3FDBE559F2217884D5C3")
    private byte[] twosComplement() {
        prepareJavaRepresentation();
        {
            byte[] var871F8A6A5DD979D0CBC073DD77C1CF91_92208619 = (new byte[] { 0 });
        } 
        BigInteger temp = this;
        int bitLen = bitLength();
        int iThis = getFirstNonzeroDigit();
        int bytesLen = (bitLen >> 3) + 1;
        byte[] bytes = new byte[bytesLen];
        int firstByteNumber = 0;
        int highBytes;
        int bytesInInteger = 4;
        int hB;
        {
            bytes[0] = (byte) ((sign < 0) ? -1 : 0);
            highBytes = 4;
        } 
        {
            hB = bytesLen & 3;
            highBytes = (hB == 0) ? 4 : hB;
        } 
        int digitIndex = iThis;
        bytesLen -= iThis << 2;
        {
            int digit = -temp.digits[digitIndex];
            {
                bytesInInteger = highBytes;
            } 
            {
                int i = 0;
                digit >>= 8;
                {
                    bytes[--bytesLen] = (byte) digit;
                } 
            } 
            {
                digit = ~temp.digits[digitIndex];
                {
                    bytesInInteger = highBytes;
                } 
                {
                    int i = 0;
                    digit >>= 8;
                    {
                        bytes[--bytesLen] = (byte) digit;
                    } 
                } 
            } 
        } 
        {
            {
                int digit = temp.digits[digitIndex];
                {
                    bytesInInteger = highBytes;
                } 
                {
                    int i = 0;
                    digit >>= 8;
                    {
                        bytes[--bytesLen] = (byte) digit;
                    } 
                } 
            } 
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1908530090 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1908530090;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static int multiplyByInt(int[] res, int[] a, int aSize, int factor) {
        long carry = 0;
        for (int i = 0; i < aSize; i++) {
            carry += (a[i] & 0xFFFFFFFFL) * (factor & 0xFFFFFFFFL);
            res[i] = (int) carry;
            carry >>>= 32;
        }
        return (int) carry;
    }

    
    @DSModeled(DSC.SAFE)
    static int inplaceAdd(int[] a, int aSize, int addend) {
        long carry = addend & 0xFFFFFFFFL;
        for (int i = 0; (carry != 0) && (i < aSize); i++) {
            carry += a[i] & 0xFFFFFFFFL;
            a[i] = (int) carry;
            carry >>= 32;
        }
        return (int) carry;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.614 -0400", hash_original_method = "4BA60B28A036933466CC713B9C7854B3", hash_generated_method = "11DCEAD92348CB58EE0C96028BC3BF78")
     int getFirstNonzeroDigit() {
        {
            int i;
            {
                i = -1;
            } 
            {
                {
                    i = 0;
                    {
                        ;
                    } 
                } 
            } 
            firstNonzeroDigit = i;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814400286 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814400286;
        
        
            
            
                
            
                
                    
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.617 -0400", hash_original_method = "FABC86F56C336DE2152BE8F133BAAD74", hash_generated_method = "074B1D8E91BBE8B4EC394128DDBBB605")
     BigInteger copy() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2048816250 = null; 
        prepareJavaRepresentation();
        int[] copyDigits = new int[numberLength];
        System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        varB4EAC82CA7396A68D541C85D26508E83_2048816250 = new BigInteger(sign, numberLength, copyDigits);
        varB4EAC82CA7396A68D541C85D26508E83_2048816250.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2048816250;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.618 -0400", hash_original_method = "883E43F5C4566D0C2A7853533F533817", hash_generated_method = "DF4C331A63AF4FE349507EA4C6337DAC")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        BigInt bigInt = new BigInt();
        bigInt.putBigEndian(magnitude, signum < 0);
        setBigInt(bigInt);
        addTaint(in.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.619 -0400", hash_original_method = "4837A11F07A86A58815A56F1112D57DF", hash_generated_method = "01908E3E3387A40C50F9D1E99D7D799D")
    private void writeObject(ObjectOutputStream out) throws IOException {
        BigInt bigInt = getBigInt();
        signum = bigInt.sign();
        magnitude = bigInt.bigEndianMagnitude();
        out.defaultWriteObject();
        addTaint(out.getTaint());
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.620 -0400", hash_original_field = "63016A922509DF10F65084D6222C77C8", hash_generated_field = "ED603E28013A68CF87DC39EDA9672B96")

    private static final long serialVersionUID = -8287574255936472291L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.620 -0400", hash_original_field = "78897A137AA91788C51A9D5D88BD6B22", hash_generated_field = "26A57E8798A6CA862A91D3C87254CE3F")

    public static final BigInteger ZERO = new BigInteger(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.620 -0400", hash_original_field = "E938017D6125C253391B6FF2A79B2347", hash_generated_field = "61E4C0227042D85901BA98B2F2CD52C4")

    public static final BigInteger ONE = new BigInteger(1, 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.620 -0400", hash_original_field = "4252D38540440B1F1E5C9806E972B4B1", hash_generated_field = "7A2B2FAA86270609C420795EB3DF7501")

    public static final BigInteger TEN = new BigInteger(1, 10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.620 -0400", hash_original_field = "C8DE16A040E4D20B9E7749B6EA765BF0", hash_generated_field = "3BE0BD039FD8F547BF6DF239E6C29295")

    static final BigInteger MINUS_ONE = new BigInteger(-1, 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.620 -0400", hash_original_field = "43E384A873FB243B7D032AB564F5C6C0", hash_generated_field = "17509E6A3C7F1A18AC1574943921E065")

    static final BigInteger[] SMALL_VALUES = { ZERO, ONE, new BigInteger(1, 2),
            new BigInteger(1, 3), new BigInteger(1, 4), new BigInteger(1, 5),
            new BigInteger(1, 6), new BigInteger(1, 7), new BigInteger(1, 8),
            new BigInteger(1, 9), TEN };
}

