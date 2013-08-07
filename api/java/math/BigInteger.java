package java.math;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;






public class BigInteger extends Number implements Comparable<BigInteger>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.770 -0400", hash_original_field = "33A2DB2A239C5BAAA46376495EE5F6ED", hash_generated_field = "1B931597CE47BECC94315E7FDFB3AE18")

    private transient BigInt bigInt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.770 -0400", hash_original_field = "F0121707B716C3D41C45CEC890F8FEBD", hash_generated_field = "B1CF9FA5CC5896A14634587A7438CDD0")

    private transient boolean nativeIsValid = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.770 -0400", hash_original_field = "562B560548EAC394A69BD390BABAEBE5", hash_generated_field = "36EDDB91E81C2B3A992259BBDA560C8D")

    private transient boolean javaIsValid = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.770 -0400", hash_original_field = "A2AACBD15B619A9B9E5581A6C33BD2B1", hash_generated_field = "EF92B8843E3664BCE02DEF9DAE8B81D8")

    transient int[] digits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.771 -0400", hash_original_field = "56F736C2BD891F3A00F34C71E5AD8378", hash_generated_field = "49E386B29ED8E51F4B9308F78ED67301")

    transient int numberLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.771 -0400", hash_original_field = "04B29480233F4DEF5C875875B6BDC3B1", hash_generated_field = "92BF56588B083F4EFC932B66DB92601C")

    transient int sign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.771 -0400", hash_original_field = "553C03BFED44A9505466470F56E3ADC5", hash_generated_field = "6063015DEF6F532F83AE577B35CA2F93")

    private transient int firstNonzeroDigit = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.771 -0400", hash_original_field = "327B0A3531EA3D97749FE579CC4632A4", hash_generated_field = "9E963B134F5112D99A51A8B2403DC06B")

    private int signum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.771 -0400", hash_original_field = "28C3D8F4B7E312AF5E0D6B59A50EFD1C", hash_generated_field = "62EEE6A49B1745E7CDFD636319A9ED04")

    private byte[] magnitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.771 -0400", hash_original_field = "B81E47D2AA677809E4BE3C9232B2407F", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.771 -0400", hash_original_method = "E2046ACAAE3FADB78A197B33030B87EF", hash_generated_method = "4F44B5F559F14B514050FB85042E070E")
      BigInteger(BigInt bigInt) {
        addTaint(bigInt.getTaint());
        if(bigInt == null || bigInt.getNativeBIGNUM() == 0)        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1921724433 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1921724433.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1921724433;
        } //End block
        setBigInt(bigInt);
        // ---------- Original Method ----------
        //if (bigInt == null || bigInt.getNativeBIGNUM() == 0) {
            //throw new AssertionError();
        //}
        //setBigInt(bigInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.771 -0400", hash_original_method = "6A0326FFA4F8DFD22C6BE505D4303A06", hash_generated_method = "92216124076F98A374EFEB47B7382295")
      BigInteger(int sign, long value) {
        addTaint(value);
        addTaint(sign);
        BigInt bigInt = new BigInt();
        bigInt.putULongInt(value, (sign < 0));
        setBigInt(bigInt);
        // ---------- Original Method ----------
        //BigInt bigInt = new BigInt();
        //bigInt.putULongInt(value, (sign < 0));
        //setBigInt(bigInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.772 -0400", hash_original_method = "8FE766A630C587CF3D36C6776BEC57AB", hash_generated_method = "48E2A9CFEFC5EDAD56DC73CAEB4CFCF6")
      BigInteger(int sign, int numberLength, int[] digits) {
        addTaint(digits[0]);
        addTaint(numberLength);
        addTaint(sign);
        setJavaRepresentation(sign, numberLength, digits);
        // ---------- Original Method ----------
        //setJavaRepresentation(sign, numberLength, digits);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.773 -0400", hash_original_method = "0CDCBE4F35D9E336AD3EE0D0E2D0776D", hash_generated_method = "18E665153A8650556EBE94437F0F95E9")
    public  BigInteger(int numBits, Random random) {
        if(numBits < 0)        
        {
            IllegalArgumentException var5EC0A1AB7358599CF1B041363EFC33DC_1730991183 = new IllegalArgumentException("numBits < 0: " + numBits);
            var5EC0A1AB7358599CF1B041363EFC33DC_1730991183.addTaint(taint);
            throw var5EC0A1AB7358599CF1B041363EFC33DC_1730991183;
        } //End block
        if(numBits == 0)        
        {
            setJavaRepresentation(0, 1, new int[] { 0 });
        } //End block
        else
        {
            int sign = 1;
            int numberLength = (numBits + 31) >> 5;
            int[] digits = new int[numberLength];
for(int i = 0;i < numberLength;i++)
            {
                digits[i] = random.nextInt();
            } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.773 -0400", hash_original_method = "E06C60E93C7C91BB266029ED9C3D532A", hash_generated_method = "BB33F199D7D40B091C3709DAA3AF3576")
    public  BigInteger(int bitLength, int certainty, Random unused) {
        addTaint(unused.getTaint());
        addTaint(certainty);
        addTaint(bitLength);
        if(bitLength < 2)        
        {
            ArithmeticException var8536151F7B087B82351728E2104CCE93_469319037 = new ArithmeticException("bitLength < 2: " + bitLength);
            var8536151F7B087B82351728E2104CCE93_469319037.addTaint(taint);
            throw var8536151F7B087B82351728E2104CCE93_469319037;
        } //End block
        setBigInt(BigInt.generatePrimeDefault(bitLength));
        // ---------- Original Method ----------
        //if (bitLength < 2) {
            //throw new ArithmeticException("bitLength < 2: " + bitLength);
        //}
        //setBigInt(BigInt.generatePrimeDefault(bitLength));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.774 -0400", hash_original_method = "858DE6DF463E0F4BFB47F99F590AB0EF", hash_generated_method = "32A998134AF57C10FF47D8D7A17DA61C")
    public  BigInteger(String value) {
        addTaint(value.getTaint());
        BigInt bigInt = new BigInt();
        bigInt.putDecString(value);
        setBigInt(bigInt);
        // ---------- Original Method ----------
        //BigInt bigInt = new BigInt();
        //bigInt.putDecString(value);
        //setBigInt(bigInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.774 -0400", hash_original_method = "A13EC41ACC3DF589C11C4779074EEB6B", hash_generated_method = "F0448914B0B9DE92E375A940EE165B64")
    public  BigInteger(String value, int radix) {
        addTaint(radix);
        addTaint(value.getTaint());
        if(value == null)        
        {
            NullPointerException varE87D3788781943D7792D3AB15C2D739B_52474320 = new NullPointerException("value == null");
            varE87D3788781943D7792D3AB15C2D739B_52474320.addTaint(taint);
            throw varE87D3788781943D7792D3AB15C2D739B_52474320;
        } //End block
        if(radix == 10)        
        {
            BigInt bigInt = new BigInt();
            bigInt.putDecString(value);
            setBigInt(bigInt);
        } //End block
        else
        if(radix == 16)        
        {
            BigInt bigInt = new BigInt();
            bigInt.putHexString(value);
            setBigInt(bigInt);
        } //End block
        else
        {
            if(radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)            
            {
                NumberFormatException var54A597476E8D47301CB272B80C5D6427_319951038 = new NumberFormatException("Invalid radix: " + radix);
                var54A597476E8D47301CB272B80C5D6427_319951038.addTaint(taint);
                throw var54A597476E8D47301CB272B80C5D6427_319951038;
            } //End block
            if(value.isEmpty())            
            {
                NumberFormatException var1344CEE7E1450045C2CE27CA1D603716_1053332633 = new NumberFormatException("value.isEmpty()");
                var1344CEE7E1450045C2CE27CA1D603716_1053332633.addTaint(taint);
                throw var1344CEE7E1450045C2CE27CA1D603716_1053332633;
            } //End block
            BigInteger.parseFromString(this, value, radix);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.775 -0400", hash_original_method = "4725614D4A9FDEE6DBC2F6DB247469CF", hash_generated_method = "4A271748A738B8A911042514ACE94C30")
    public  BigInteger(int signum, byte[] magnitude) {
        addTaint(magnitude[0]);
        addTaint(signum);
        if(magnitude == null)        
        {
            NullPointerException var7E85E86BDB8D9F68EC0E6C966752968B_1470355524 = new NullPointerException("magnitude == null");
            var7E85E86BDB8D9F68EC0E6C966752968B_1470355524.addTaint(taint);
            throw var7E85E86BDB8D9F68EC0E6C966752968B_1470355524;
        } //End block
        if(signum < -1 || signum > 1)        
        {
            NumberFormatException var884F9AED69FB498BC487063C000C7340_1970927851 = new NumberFormatException("Invalid signum: " + signum);
            var884F9AED69FB498BC487063C000C7340_1970927851.addTaint(taint);
            throw var884F9AED69FB498BC487063C000C7340_1970927851;
        } //End block
        if(signum == 0)        
        {
for(byte element : magnitude)
            {
                if(element != 0)                
                {
                    NumberFormatException var5CFBC65388378A39A3646B151F1EDB94_1615644417 = new NumberFormatException("signum-magnitude mismatch");
                    var5CFBC65388378A39A3646B151F1EDB94_1615644417.addTaint(taint);
                    throw var5CFBC65388378A39A3646B151F1EDB94_1615644417;
                } //End block
            } //End block
        } //End block
        BigInt bigInt = new BigInt();
        bigInt.putBigEndian(magnitude, signum < 0);
        setBigInt(bigInt);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.776 -0400", hash_original_method = "ABB1E16F13BE7B2CA5EC1AADB52B2350", hash_generated_method = "248F2E06FE6D4C575BF3684635CC8DFA")
    public  BigInteger(byte[] value) {
        addTaint(value[0]);
        if(value.length == 0)        
        {
            NumberFormatException var121D21579486A7E6B31DB9E37100E5DA_719899705 = new NumberFormatException("value.length == 0");
            var121D21579486A7E6B31DB9E37100E5DA_719899705.addTaint(taint);
            throw var121D21579486A7E6B31DB9E37100E5DA_719899705;
        } //End block
        BigInt bigInt = new BigInt();
        bigInt.putBigEndianTwosComplement(value);
        setBigInt(bigInt);
        // ---------- Original Method ----------
        //if (value.length == 0) {
            //throw new NumberFormatException("value.length == 0");
        //}
        //BigInt bigInt = new BigInt();
        //bigInt.putBigEndianTwosComplement(value);
        //setBigInt(bigInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.777 -0400", hash_original_method = "7B92331634E6E3BE19D048B912B09B7F", hash_generated_method = "659B9DB4B5B489D7C5F6AE6897161CF9")
     BigInt getBigInt() {
        if(nativeIsValid)        
        {
BigInt varF61D17EA034CC14FAE8780D55F9242B6_1377937663 =             bigInt;
            varF61D17EA034CC14FAE8780D55F9242B6_1377937663.addTaint(taint);
            return varF61D17EA034CC14FAE8780D55F9242B6_1377937663;
        } //End block
        synchronized
(this)        {
            if(nativeIsValid)            
            {
BigInt varF61D17EA034CC14FAE8780D55F9242B6_364400772 =                 bigInt;
                varF61D17EA034CC14FAE8780D55F9242B6_364400772.addTaint(taint);
                return varF61D17EA034CC14FAE8780D55F9242B6_364400772;
            } //End block
            BigInt bigInt = new BigInt();
            bigInt.putLittleEndianInts(digits, (sign < 0));
            setBigInt(bigInt);
BigInt varF61D17EA034CC14FAE8780D55F9242B6_1859815725 =             bigInt;
            varF61D17EA034CC14FAE8780D55F9242B6_1859815725.addTaint(taint);
            return varF61D17EA034CC14FAE8780D55F9242B6_1859815725;
        } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.777 -0400", hash_original_method = "CC364AFCED646D5BD618C239A0F61C61", hash_generated_method = "FB8F32B7985E2B240502D873FAE13D52")
    private void setBigInt(BigInt bigInt) {
        this.bigInt = bigInt;
        this.nativeIsValid = true;
        // ---------- Original Method ----------
        //this.bigInt = bigInt;
        //this.nativeIsValid = true;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.778 -0400", hash_original_method = "DA7CFD2DB9135F0E2C89139BCCCBB12F", hash_generated_method = "DDED3CCDAC81118323E9CC670E4E61F1")
    private void setJavaRepresentation(int sign, int numberLength, int[] digits) {
        while
(numberLength > 0 && digits[--numberLength] == 0)        
        {
            ;
        } //End block
        if(digits[numberLength++] == 0)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.779 -0400", hash_original_method = "E11A76F306D885B62849938EE7ACFF1F", hash_generated_method = "31FBFEC90454066EAC8AA5866D1F8758")
     void prepareJavaRepresentation() {
        if(javaIsValid)        
        {
            return;
        } //End block
        synchronized
(this)        {
            if(javaIsValid)            
            {
                return;
            } //End block
            int sign = bigInt.sign();
            int[] digits = (sign != 0) ? bigInt.littleEndianIntsMagnitude() : new int[] { 0 };
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.780 -0400", hash_original_method = "F45D943577A758DE4A75A5CD2DF6D206", hash_generated_method = "66003CD87E8274DFB6E136C12D1F9F26")
    public byte[] toByteArray() {
        byte[] var2417BA9EF054EFFF9DBB86DE9AAC04B5_1363064366 = (twosComplement());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_537737248 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_537737248;
        // ---------- Original Method ----------
        //return twosComplement();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.780 -0400", hash_original_method = "4D099B3B9B18238917CAE07611FC89C9", hash_generated_method = "36165DDA4787D57E39D03CA2B024B270")
    public BigInteger abs() {
        BigInt bigInt = getBigInt();
        if(bigInt.sign() >= 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_647556916 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_647556916.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_647556916;
        } //End block
        BigInt a = bigInt.copy();
        a.setSign(1);
BigInteger var218BDCFCB1E1EC8559F56659E2425F3E_1085979009 =         new BigInteger(a);
        var218BDCFCB1E1EC8559F56659E2425F3E_1085979009.addTaint(taint);
        return var218BDCFCB1E1EC8559F56659E2425F3E_1085979009;
        // ---------- Original Method ----------
        //BigInt bigInt = getBigInt();
        //if (bigInt.sign() >= 0) {
            //return this;
        //}
        //BigInt a = bigInt.copy();
        //a.setSign(1);
        //return new BigInteger(a);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.780 -0400", hash_original_method = "DFABA71B5B9AE3E4CD65AD4AD666E31C", hash_generated_method = "1D1D901E9DC419A5FD802DE8D5F2B1CB")
    public BigInteger negate() {
        BigInt bigInt = getBigInt();
        int sign = bigInt.sign();
        if(sign == 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_1574921450 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1574921450.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1574921450;
        } //End block
        BigInt a = bigInt.copy();
        a.setSign(-sign);
BigInteger var218BDCFCB1E1EC8559F56659E2425F3E_699048883 =         new BigInteger(a);
        var218BDCFCB1E1EC8559F56659E2425F3E_699048883.addTaint(taint);
        return var218BDCFCB1E1EC8559F56659E2425F3E_699048883;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.781 -0400", hash_original_method = "5B8AB174D1647BD6610121BBBEE51EE5", hash_generated_method = "594EA8DD9AA4E7A44DB89F7124683269")
    public BigInteger add(BigInteger value) {
        addTaint(value.getTaint());
        BigInt lhs = getBigInt();
        BigInt rhs = value.getBigInt();
        if(rhs.sign() == 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_1918344158 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1918344158.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1918344158;
        } //End block
        if(lhs.sign() == 0)        
        {
BigInteger varAF280DA2BC37D8BE783D8499160168DE_604076780 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_604076780.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_604076780;
        } //End block
BigInteger varFCE73B71493AA206EE9BB04AA2B4D532_761572796 =         new BigInteger(BigInt.addition(lhs, rhs));
        varFCE73B71493AA206EE9BB04AA2B4D532_761572796.addTaint(taint);
        return varFCE73B71493AA206EE9BB04AA2B4D532_761572796;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.781 -0400", hash_original_method = "753BA04897A44EE33BA2055C50810858", hash_generated_method = "67602C32667EA409EFC4C4FD3D90B1A6")
    public BigInteger subtract(BigInteger value) {
        addTaint(value.getTaint());
        BigInt lhs = getBigInt();
        BigInt rhs = value.getBigInt();
        if(rhs.sign() == 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_1070643086 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1070643086.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1070643086;
        } //End block
BigInteger var9C5AECC26DFF2341DA3847576C025808_2052729858 =         new BigInteger(BigInt.subtraction(lhs, rhs));
        var9C5AECC26DFF2341DA3847576C025808_2052729858.addTaint(taint);
        return var9C5AECC26DFF2341DA3847576C025808_2052729858;
        // ---------- Original Method ----------
        //BigInt lhs = getBigInt();
        //BigInt rhs = value.getBigInt();
        //if (rhs.sign() == 0) {
            //return this;
        //}
        //return new BigInteger(BigInt.subtraction(lhs, rhs));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.782 -0400", hash_original_method = "0A534AADB97A9D37B49476B54B03D66A", hash_generated_method = "BA441FECB8C4854D53758ACDF9CD2687")
    public int signum() {
        if(javaIsValid)        
        {
            int var04B29480233F4DEF5C875875B6BDC3B1_1386908843 = (sign);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572659709 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572659709;
        } //End block
        int var44D38B436477B6C5DAAD2675644143CF_240449731 = (getBigInt().sign());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21052881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21052881;
        // ---------- Original Method ----------
        //if (javaIsValid) {
            //return sign;
        //}
        //return getBigInt().sign();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.783 -0400", hash_original_method = "1B97FA7BE1DE29423609E814DD90E66F", hash_generated_method = "74BA1B7A4E3B6D83E242C6B21BBD1339")
    public BigInteger shiftRight(int n) {
        addTaint(n);
BigInteger var3A0432B3A6E28F9F920E85C8122DDC2A_1565785664 =         shiftLeft(-n);
        var3A0432B3A6E28F9F920E85C8122DDC2A_1565785664.addTaint(taint);
        return var3A0432B3A6E28F9F920E85C8122DDC2A_1565785664;
        // ---------- Original Method ----------
        //return shiftLeft(-n);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.783 -0400", hash_original_method = "3E0E92A5CC7CF6FE74FD251028917DBB", hash_generated_method = "554D9A12AD637CAEF2B5F61A2F19C203")
    public BigInteger shiftLeft(int n) {
        addTaint(n);
        if(n == 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_2084011160 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2084011160.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2084011160;
        } //End block
        int sign = signum();
        if(sign == 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_1858878130 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1858878130.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1858878130;
        } //End block
        if((sign > 0) || (n >= 0))        
        {
BigInteger varA6312464C4A34A11B7570DD1D595F9FE_149423919 =             new BigInteger(BigInt.shift(getBigInt(), n));
            varA6312464C4A34A11B7570DD1D595F9FE_149423919.addTaint(taint);
            return varA6312464C4A34A11B7570DD1D595F9FE_149423919;
        } //End block
        else
        {
BigInteger var262D1F38C2279DC0C07C480384AD549E_1351391281 =             BitLevel.shiftRight(this, -n);
            var262D1F38C2279DC0C07C480384AD549E_1351391281.addTaint(taint);
            return var262D1F38C2279DC0C07C480384AD549E_1351391281;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.784 -0400", hash_original_method = "3F948826829C47AB028976261F4B8D55", hash_generated_method = "A45206D2C2FF63B629D084475EB6EFE9")
     BigInteger shiftLeftOneBit() {
BigInteger varA731EB205789D913808863FEF09D7362_782554454 =         (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
        varA731EB205789D913808863FEF09D7362_782554454.addTaint(taint);
        return varA731EB205789D913808863FEF09D7362_782554454;
        // ---------- Original Method ----------
        //return (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.784 -0400", hash_original_method = "5DD770E4600136986E52E3D1EE5F1B27", hash_generated_method = "F0D8F6539F683A04A9C57855EB809E00")
    public int bitLength() {
        if(!nativeIsValid && javaIsValid)        
        {
            int var45B0BE12C3229B34DBB2E60779D54632_1986591145 = (BitLevel.bitLength(this));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904806707 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904806707;
        } //End block
        int var01DCFFD04AB0700B9FD2F77D42BA35EF_583732559 = (getBigInt().bitLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_172586006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_172586006;
        // ---------- Original Method ----------
        //if (!nativeIsValid && javaIsValid) {
            //return BitLevel.bitLength(this);
        //}
        //return getBigInt().bitLength();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.786 -0400", hash_original_method = "22DB08B3CA9DDA99CEE301218284C513", hash_generated_method = "01FA38C1C6C5981856115BABCC78E67F")
    public boolean testBit(int n) {
        addTaint(n);
        if(n < 0)        
        {
            ArithmeticException var11571F466B41E34C11FB6A2CA1558885_1037131299 = new ArithmeticException("n < 0: " + n);
            var11571F466B41E34C11FB6A2CA1558885_1037131299.addTaint(taint);
            throw var11571F466B41E34C11FB6A2CA1558885_1037131299;
        } //End block
        int sign = signum();
        if(sign > 0 && nativeIsValid && !javaIsValid)        
        {
            boolean varDC86AAD185DEF12FE95555DDD60CBAF7_808829247 = (getBigInt().isBitSet(n));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544436793 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_544436793;
        } //End block
        else
        {
            prepareJavaRepresentation();
            if(n == 0)            
            {
                boolean var67C90134A2D9075B820EBC0763F57082_1331683002 = (((digits[0] & 1) != 0));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1884310548 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1884310548;
            } //End block
            int intCount = n >> 5;
            if(intCount >= numberLength)            
            {
                boolean varA9F8101E55BCD1D83866DEA546EB449E_1396405904 = ((sign < 0));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1361667481 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1361667481;
            } //End block
            int digit = digits[intCount];
            n = (1 << (n & 31));
            if(sign < 0)            
            {
                int firstNonZeroDigit = getFirstNonzeroDigit();
                if(intCount < firstNonZeroDigit)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1360409602 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771217675 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771217675;
                } //End block
                else
                if(firstNonZeroDigit == intCount)                
                {
                    digit = -digit;
                } //End block
                else
                {
                    digit = ~digit;
                } //End block
            } //End block
            boolean varDEB0AA44EC788CFB125469B3B8C9AE09_1076380445 = (((digit & n) != 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130294705 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130294705;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.787 -0400", hash_original_method = "0A60006224C30F0C8DC4E0C8D16895AE", hash_generated_method = "DBF22454151AEC76F74CC2350ACBE8C6")
    public BigInteger setBit(int n) {
        addTaint(n);
        prepareJavaRepresentation();
        if(!testBit(n))        
        {
BigInteger var0E324DA30C13DE74A7B667C295B326B0_2046858560 =             BitLevel.flipBit(this, n);
            var0E324DA30C13DE74A7B667C295B326B0_2046858560.addTaint(taint);
            return var0E324DA30C13DE74A7B667C295B326B0_2046858560;
        } //End block
        else
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_2008124567 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2008124567.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2008124567;
        } //End block
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (!testBit(n)) {
            //return BitLevel.flipBit(this, n);
        //} else {
            //return this;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.787 -0400", hash_original_method = "8D8C5374E542B708B8A1B41B31DCBF03", hash_generated_method = "BE117F376E9A96CDA070EF66F800C62B")
    public BigInteger clearBit(int n) {
        addTaint(n);
        prepareJavaRepresentation();
        if(testBit(n))        
        {
BigInteger var0E324DA30C13DE74A7B667C295B326B0_924326827 =             BitLevel.flipBit(this, n);
            var0E324DA30C13DE74A7B667C295B326B0_924326827.addTaint(taint);
            return var0E324DA30C13DE74A7B667C295B326B0_924326827;
        } //End block
        else
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_1050193442 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1050193442.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1050193442;
        } //End block
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (testBit(n)) {
            //return BitLevel.flipBit(this, n);
        //} else {
            //return this;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.788 -0400", hash_original_method = "F1D37134A8936EE90081AD78D8487F59", hash_generated_method = "7A9276B4AF957A8A0DE13530B945DFD6")
    public BigInteger flipBit(int n) {
        addTaint(n);
        prepareJavaRepresentation();
        if(n < 0)        
        {
            ArithmeticException var11571F466B41E34C11FB6A2CA1558885_132580142 = new ArithmeticException("n < 0: " + n);
            var11571F466B41E34C11FB6A2CA1558885_132580142.addTaint(taint);
            throw var11571F466B41E34C11FB6A2CA1558885_132580142;
        } //End block
BigInteger var0E324DA30C13DE74A7B667C295B326B0_1408543900 =         BitLevel.flipBit(this, n);
        var0E324DA30C13DE74A7B667C295B326B0_1408543900.addTaint(taint);
        return var0E324DA30C13DE74A7B667C295B326B0_1408543900;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (n < 0) {
            //throw new ArithmeticException("n < 0: " + n);
        //}
        //return BitLevel.flipBit(this, n);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.788 -0400", hash_original_method = "8383F139074E92B6BF621C4AC408CB05", hash_generated_method = "54174ECCC29A05B95728F4467FABF2F5")
    public int getLowestSetBit() {
        prepareJavaRepresentation();
        if(sign == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2073509235 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269892801 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269892801;
        } //End block
        int i = getFirstNonzeroDigit();
        int var9653D777938763685E5D6CC32A6ECFA2_794974684 = (((i << 5) + Integer.numberOfTrailingZeros(digits[i])));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259070610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259070610;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (sign == 0) {
            //return -1;
        //}
        //int i = getFirstNonzeroDigit();
        //return ((i << 5) + Integer.numberOfTrailingZeros(digits[i]));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.789 -0400", hash_original_method = "2461573222D281ABCA9F3F34AA40AFB9", hash_generated_method = "2795C7E7798383817321949B4660CD08")
    public int bitCount() {
        prepareJavaRepresentation();
        int var81F61709759DC20E20BE73FBCFCEEC28_1729669761 = (BitLevel.bitCount(this));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148087452 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148087452;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //return BitLevel.bitCount(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.789 -0400", hash_original_method = "CD87C1AB82AE5BD1BDB1D71C1F7F211A", hash_generated_method = "916C88AE9780925F0770E3FBDA32505A")
    public BigInteger not() {
        this.prepareJavaRepresentation();
BigInteger var4AE08097D2179E3BC1F88C3AF11543CB_1730178671 =         Logical.not(this);
        var4AE08097D2179E3BC1F88C3AF11543CB_1730178671.addTaint(taint);
        return var4AE08097D2179E3BC1F88C3AF11543CB_1730178671;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //return Logical.not(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.789 -0400", hash_original_method = "B57E8848F50ED2CEFC86EA20A70D185D", hash_generated_method = "B2C036281C6FE5B5DB9408F0279E477F")
    public BigInteger and(BigInteger value) {
        addTaint(value.getTaint());
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
BigInteger varEC02C5E60DB5787DEFEACB2489D5D715_1347919683 =         Logical.and(this, value);
        varEC02C5E60DB5787DEFEACB2489D5D715_1347919683.addTaint(taint);
        return varEC02C5E60DB5787DEFEACB2489D5D715_1347919683;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.and(this, value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.789 -0400", hash_original_method = "AED35BC9F3B39A40B35087479AE4F222", hash_generated_method = "9FBB8E119800AECA9DE2D9EB6AB2BF0B")
    public BigInteger or(BigInteger value) {
        addTaint(value.getTaint());
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
BigInteger var62F1052A5BD52D57F62233EF70DC95C7_332080105 =         Logical.or(this, value);
        var62F1052A5BD52D57F62233EF70DC95C7_332080105.addTaint(taint);
        return var62F1052A5BD52D57F62233EF70DC95C7_332080105;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.or(this, value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.790 -0400", hash_original_method = "0162D315FD06686CC7830A3D5D5A796E", hash_generated_method = "AB3A43D429C6AD243EF270BE7D58C301")
    public BigInteger xor(BigInteger value) {
        addTaint(value.getTaint());
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
BigInteger varE711E834E077A084755787F8CA0BDEF7_289847220 =         Logical.xor(this, value);
        varE711E834E077A084755787F8CA0BDEF7_289847220.addTaint(taint);
        return varE711E834E077A084755787F8CA0BDEF7_289847220;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.xor(this, value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.790 -0400", hash_original_method = "A8A90B9F7EBADE4F51C070D1C780A515", hash_generated_method = "829500EB7388A26F7FCAB9B4B1820AA3")
    public BigInteger andNot(BigInteger value) {
        addTaint(value.getTaint());
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
BigInteger var3671885F1BEED0B63D869325BB4A0FBE_265491481 =         Logical.andNot(this, value);
        var3671885F1BEED0B63D869325BB4A0FBE_265491481.addTaint(taint);
        return var3671885F1BEED0B63D869325BB4A0FBE_265491481;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.andNot(this, value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.790 -0400", hash_original_method = "F298334B66A6EA4DC89E250C44198AEA", hash_generated_method = "9502DCB6E6C146F31DBE9246194CDA86")
    @Override
    public int intValue() {
        if(nativeIsValid && bigInt.twosCompFitsIntoBytes(4))        
        {
            int var5F3DAB238C48AC6AC195B921EC05B94D_659392182 = ((int) bigInt.longInt());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854804879 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854804879;
        } //End block
        this.prepareJavaRepresentation();
        int var5085F8A117DFA417EE117E0AD549F783_932595807 = ((sign * digits[0]));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1554550381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1554550381;
        // ---------- Original Method ----------
        //if (nativeIsValid && bigInt.twosCompFitsIntoBytes(4)) {
            //return (int) bigInt.longInt();
        //}
        //this.prepareJavaRepresentation();
        //return (sign * digits[0]);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.791 -0400", hash_original_method = "22A0F6A18293749D1CD57F54133930DD", hash_generated_method = "80FEE1C7EFAECEBA5D33560289DBF68F")
    @Override
    public long longValue() {
        if(nativeIsValid && bigInt.twosCompFitsIntoBytes(8))        
        {
            long varBEB266E496531BF0ED724E960420F41D_548928279 = (bigInt.longInt());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2114070369 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2114070369;
        } //End block
        prepareJavaRepresentation();
        long value = numberLength > 1
                ? ((long) digits[1]) << 32 | digits[0] & 0xFFFFFFFFL
                : digits[0] & 0xFFFFFFFFL;
        long var35F8744C2ED517A7D1514FC8972FC733_265056577 = (sign * value);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_445361765 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_445361765;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.792 -0400", hash_original_method = "85C514A29B5895D821780B89C4F747B0", hash_generated_method = "5D115B613C4E7866954F4066BBD37A6C")
    @Override
    public float floatValue() {
        float var7AF3918BFD2A8BA8BF7150448D9ED402_519272218 = ((float) doubleValue());
                float var546ADE640B6EDFBC8A086EF31347E768_1546064107 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1546064107;
        // ---------- Original Method ----------
        //return (float) doubleValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.792 -0400", hash_original_method = "3D8E394E07D4F37AF2C6D72F08026A5D", hash_generated_method = "9B83AB06F43B26B8C867CDE7ADEE1F7D")
    @Override
    public double doubleValue() {
        double var2781D155E69A996741A3E634E49E0EDD_1329652720 = (Conversion.bigInteger2Double(this));
                double varE8CD7DA078A86726031AD64F35F5A6C0_983056414 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_983056414;
        // ---------- Original Method ----------
        //return Conversion.bigInteger2Double(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.792 -0400", hash_original_method = "2F090DBB15C308A00016A444F7C5A620", hash_generated_method = "DF4673537A9472714C5E35206A3483A6")
    public int compareTo(BigInteger value) {
        addTaint(value.getTaint());
        int varDA0AAC958F826B901631A78AE0474090_255037923 = (BigInt.cmp(getBigInt(), value.getBigInt()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746415000 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746415000;
        // ---------- Original Method ----------
        //return BigInt.cmp(getBigInt(), value.getBigInt());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.793 -0400", hash_original_method = "909F517DD4A19D55540D3A4577FBCF84", hash_generated_method = "CD6A949626C5AB8421C3D27692D91B51")
    public BigInteger min(BigInteger value) {
        addTaint(value.getTaint());
BigInteger var51D22EBE4ECE3B3E1220E267AD5A4525_416780811 =         this.compareTo(value) == -1 ? this : value;
        var51D22EBE4ECE3B3E1220E267AD5A4525_416780811.addTaint(taint);
        return var51D22EBE4ECE3B3E1220E267AD5A4525_416780811;
        // ---------- Original Method ----------
        //return this.compareTo(value) == -1 ? this : value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.793 -0400", hash_original_method = "6C03178B5A42138223A2B4814CF874FD", hash_generated_method = "136037BA8C859C06CFAA3380DE08C934")
    public BigInteger max(BigInteger value) {
        addTaint(value.getTaint());
BigInteger var871A769D3B888770DCECBD01C1D60F65_155013274 =         this.compareTo(value) == 1 ? this : value;
        var871A769D3B888770DCECBD01C1D60F65_155013274.addTaint(taint);
        return var871A769D3B888770DCECBD01C1D60F65_155013274;
        // ---------- Original Method ----------
        //return this.compareTo(value) == 1 ? this : value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.794 -0400", hash_original_method = "8BD8EE457DCE4BEA017BA4C9967BFC77", hash_generated_method = "B2D73314916151FDA7A3F6D19797E9CF")
    @Override
    public int hashCode() {
        if(hashCode != 0)        
        {
            int var550D1CC054A1B23A411DDDA46FD64811_2034081810 = (hashCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954197672 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954197672;
        } //End block
        prepareJavaRepresentation();
for(int i = 0;i < numberLength;++i)
        {
            hashCode = hashCode * 33 + digits[i];
        } //End block
        hashCode = hashCode * sign;
        int var550D1CC054A1B23A411DDDA46FD64811_897811518 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391453585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391453585;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.795 -0400", hash_original_method = "D6CA37529D0AAA6915B88189BBB9DE43", hash_generated_method = "104C11436E41D00CF5C5732215DE7892")
    @Override
    public boolean equals(Object x) {
        addTaint(x.getTaint());
        if(this == x)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_541813416 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_841222896 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_841222896;
        } //End block
        if(x instanceof BigInteger)        
        {
            boolean varE297602C835F0C20AE532BD84AFE1753_1618256 = (this.compareTo((BigInteger) x) == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863813528 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863813528;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_854436297 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_641665963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_641665963;
        // ---------- Original Method ----------
        //if (this == x) {
            //return true;
        //}
        //if (x instanceof BigInteger) {
            //return this.compareTo((BigInteger) x) == 0;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.796 -0400", hash_original_method = "466A78542936FDDF00F235F55782CDB1", hash_generated_method = "1F6FB68222786B0839F6DCAAC89D160C")
    @Override
    public String toString() {
String var890F38AC87AB6F8B6AD38900DD43311E_932712312 =         getBigInt().decString();
        var890F38AC87AB6F8B6AD38900DD43311E_932712312.addTaint(taint);
        return var890F38AC87AB6F8B6AD38900DD43311E_932712312;
        // ---------- Original Method ----------
        //return getBigInt().decString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.796 -0400", hash_original_method = "DC1B34095F4DDEED7FED4CD9DAE6BCA6", hash_generated_method = "6BAA25D18F663A64B3A58F3A3DFA0560")
    public String toString(int radix) {
        addTaint(radix);
        if(radix == 10)        
        {
String var890F38AC87AB6F8B6AD38900DD43311E_1776373649 =             getBigInt().decString();
            var890F38AC87AB6F8B6AD38900DD43311E_1776373649.addTaint(taint);
            return var890F38AC87AB6F8B6AD38900DD43311E_1776373649;
        } //End block
        else
        {
            prepareJavaRepresentation();
String var9A521DCF7FE8B57B3B67450DD37EC19F_670236612 =             Conversion.bigInteger2String(this, radix);
            var9A521DCF7FE8B57B3B67450DD37EC19F_670236612.addTaint(taint);
            return var9A521DCF7FE8B57B3B67450DD37EC19F_670236612;
        } //End block
        // ---------- Original Method ----------
        //if (radix == 10) {
            //return getBigInt().decString();
        //} else {
            //prepareJavaRepresentation();
            //return Conversion.bigInteger2String(this, radix);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.797 -0400", hash_original_method = "DF6919CA8C1CE81A76193FCEFAE3FDAA", hash_generated_method = "2E22E5223F0357F6C284BC8435AC1D26")
    public BigInteger gcd(BigInteger value) {
        addTaint(value.getTaint());
BigInteger var8DD0FF5974D2E7767BA555726449CFF4_170796806 =         new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
        var8DD0FF5974D2E7767BA555726449CFF4_170796806.addTaint(taint);
        return var8DD0FF5974D2E7767BA555726449CFF4_170796806;
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.797 -0400", hash_original_method = "7A377385A7A35B42B025ADA39BD9F319", hash_generated_method = "AF79321B195F638F1D657361084B1F32")
    public BigInteger multiply(BigInteger value) {
        addTaint(value.getTaint());
BigInteger var76F2E6FB322F14B01150731913C02DE4_1145025094 =         new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
        var76F2E6FB322F14B01150731913C02DE4_1145025094.addTaint(taint);
        return var76F2E6FB322F14B01150731913C02DE4_1145025094;
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.798 -0400", hash_original_method = "670CEDEE32713500748765AA85174DA4", hash_generated_method = "276297C4AA19FA4EA2BD4155C4E1B2F5")
    public BigInteger pow(int exp) {
        addTaint(exp);
        if(exp < 0)        
        {
            ArithmeticException var001E700924694F29455645A53E6DD278_641355540 = new ArithmeticException("exp < 0: " + exp);
            var001E700924694F29455645A53E6DD278_641355540.addTaint(taint);
            throw var001E700924694F29455645A53E6DD278_641355540;
        } //End block
BigInteger var9DA8D0215E054A2BF16296FC85448AF2_335958721 =         new BigInteger(BigInt.exp(getBigInt(), exp));
        var9DA8D0215E054A2BF16296FC85448AF2_335958721.addTaint(taint);
        return var9DA8D0215E054A2BF16296FC85448AF2_335958721;
        // ---------- Original Method ----------
        //if (exp < 0) {
            //throw new ArithmeticException("exp < 0: " + exp);
        //}
        //return new BigInteger(BigInt.exp(getBigInt(), exp));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.799 -0400", hash_original_method = "0021B26ACCFD58807A129BEBBFC75B78", hash_generated_method = "9BA421D045774DC7DCB654C8B93F4CE0")
    public BigInteger[] divideAndRemainder(BigInteger divisor) {
        addTaint(divisor.getTaint());
        BigInt divisorBigInt = divisor.getBigInt();
        BigInt quotient = new BigInt();
        BigInt remainder = new BigInt();
        BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
BigInteger[] var8A8A7904E86E4D13D3E7DAF7038CED0E_1185270148 =         new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
        var8A8A7904E86E4D13D3E7DAF7038CED0E_1185270148.addTaint(taint);
        return var8A8A7904E86E4D13D3E7DAF7038CED0E_1185270148;
        // ---------- Original Method ----------
        //BigInt divisorBigInt = divisor.getBigInt();
        //BigInt quotient = new BigInt();
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        //return new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.800 -0400", hash_original_method = "E605E3D77E9B13D877DA6B6F47D67F1F", hash_generated_method = "21BAAC8D0339DBFD76622A9C5B24F426")
    public BigInteger divide(BigInteger divisor) {
        addTaint(divisor.getTaint());
        BigInt quotient = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
BigInteger varF5E42F05753A027547C1024D73D25558_735621947 =         new BigInteger(quotient);
        varF5E42F05753A027547C1024D73D25558_735621947.addTaint(taint);
        return varF5E42F05753A027547C1024D73D25558_735621947;
        // ---------- Original Method ----------
        //BigInt quotient = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        //return new BigInteger(quotient);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.801 -0400", hash_original_method = "FFD2A7C70BA79F9B512531A9A18B49EF", hash_generated_method = "89347AE8DD79FE3341FA2EBBA2BB8E00")
    public BigInteger remainder(BigInteger divisor) {
        addTaint(divisor.getTaint());
        BigInt remainder = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
BigInteger var10BF6620D7E0C707A7C8019C4ACFA109_2050363798 =         new BigInteger(remainder);
        var10BF6620D7E0C707A7C8019C4ACFA109_2050363798.addTaint(taint);
        return var10BF6620D7E0C707A7C8019C4ACFA109_2050363798;
        // ---------- Original Method ----------
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        //return new BigInteger(remainder);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.802 -0400", hash_original_method = "D09D0373DFB5DF67EDACA66D474BB75C", hash_generated_method = "C6AA85E1483905EC4A4BE6599DC6E46F")
    public BigInteger modInverse(BigInteger m) {
        addTaint(m.getTaint());
        if(m.signum() <= 0)        
        {
            ArithmeticException var8BB81AC6BF082C408E532E8B3473346D_55592586 = new ArithmeticException("modulus not positive");
            var8BB81AC6BF082C408E532E8B3473346D_55592586.addTaint(taint);
            throw var8BB81AC6BF082C408E532E8B3473346D_55592586;
        } //End block
BigInteger varA5CB9EAB50195FCBCCD7D723E2487DD4_932824115 =         new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
        varA5CB9EAB50195FCBCCD7D723E2487DD4_932824115.addTaint(taint);
        return varA5CB9EAB50195FCBCCD7D723E2487DD4_932824115;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("modulus not positive");
        //}
        //return new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.802 -0400", hash_original_method = "4B2E2C43A8E0C70699BFC0E4EF01E685", hash_generated_method = "A463C3B4D152E47F4A73F3379A13863A")
    public BigInteger modPow(BigInteger exponent, BigInteger m) {
        addTaint(m.getTaint());
        addTaint(exponent.getTaint());
        if(m.signum() <= 0)        
        {
            ArithmeticException varA3FE4C88BF590ACADE595D9B17B1082A_634661439 = new ArithmeticException("m.signum() <= 0");
            varA3FE4C88BF590ACADE595D9B17B1082A_634661439.addTaint(taint);
            throw varA3FE4C88BF590ACADE595D9B17B1082A_634661439;
        } //End block
        BigInteger base = exponent.signum() < 0 ? modInverse(m) : this;
BigInteger var5B49E59CA7186F0F5E18AE1173246194_508720883 =         new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
        var5B49E59CA7186F0F5E18AE1173246194_508720883.addTaint(taint);
        return var5B49E59CA7186F0F5E18AE1173246194_508720883;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //BigInteger base = exponent.signum() < 0 ? modInverse(m) : this;
        //return new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.803 -0400", hash_original_method = "ADC51A8E4A4079F65268593A33DD74A7", hash_generated_method = "72254F0329ABFBF8F1393A9EA78725A3")
    public BigInteger mod(BigInteger m) {
        addTaint(m.getTaint());
        if(m.signum() <= 0)        
        {
            ArithmeticException varA3FE4C88BF590ACADE595D9B17B1082A_2046485499 = new ArithmeticException("m.signum() <= 0");
            varA3FE4C88BF590ACADE595D9B17B1082A_2046485499.addTaint(taint);
            throw varA3FE4C88BF590ACADE595D9B17B1082A_2046485499;
        } //End block
BigInteger var468BC46EEB8D3FB30B6C4266C9D9D6A8_471909413 =         new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
        var468BC46EEB8D3FB30B6C4266C9D9D6A8_471909413.addTaint(taint);
        return var468BC46EEB8D3FB30B6C4266C9D9D6A8_471909413;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //return new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.803 -0400", hash_original_method = "718D211034BAE1DECACA1D72CB4CBB13", hash_generated_method = "B88F2631C9EDBF0E5233598D9382DFC9")
    public boolean isProbablePrime(int certainty) {
        addTaint(certainty);
        if(certainty <= 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_746064293 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972429943 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_972429943;
        } //End block
        boolean varAE2D570DFC9FA0E1324E3EE0328F6C55_487306991 = (getBigInt().isPrime(certainty));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1657408779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1657408779;
        // ---------- Original Method ----------
        //if (certainty <= 0) {
            //return true;
        //}
        //return getBigInt().isPrime(certainty);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.804 -0400", hash_original_method = "BB43921F4E806BD72B6F518E8CD8937B", hash_generated_method = "C46A64D38C448BC5AD999B02F4E67B41")
    public BigInteger nextProbablePrime() {
        if(sign < 0)        
        {
            ArithmeticException var7421D3B8C101F0FD22BC8BC1B4CC03E6_1004779804 = new ArithmeticException("sign < 0");
            var7421D3B8C101F0FD22BC8BC1B4CC03E6_1004779804.addTaint(taint);
            throw var7421D3B8C101F0FD22BC8BC1B4CC03E6_1004779804;
        } //End block
BigInteger var94FA3EB230AA07017F3209E36A021E1F_924548947 =         Primality.nextProbablePrime(this);
        var94FA3EB230AA07017F3209E36A021E1F_924548947.addTaint(taint);
        return var94FA3EB230AA07017F3209E36A021E1F_924548947;
        // ---------- Original Method ----------
        //if (sign < 0) {
            //throw new ArithmeticException("sign < 0");
        //}
        //return Primality.nextProbablePrime(this);
    }

    
    @DSModeled(DSC.SAFE)
    public static BigInteger probablePrime(int bitLength, Random unused) {
        return new BigInteger(bitLength, 100, unused);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.805 -0400", hash_original_method = "F2F8EDC382104DB344E8DD617201B0F3", hash_generated_method = "AECCC739F85D786AC2DB0078826155AF")
    private byte[] twosComplement() {
        prepareJavaRepresentation();
        if(this.sign == 0)        
        {
            byte[] var84902D44E1D087509E7DC8DF24127009_1326020411 = (new byte[] { 0 });
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_590229587 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_590229587;
        } //End block
        BigInteger temp = this;
        int bitLen = bitLength();
        int iThis = getFirstNonzeroDigit();
        int bytesLen = (bitLen >> 3) + 1;
        byte[] bytes = new byte[bytesLen];
        int firstByteNumber = 0;
        int highBytes;
        int bytesInInteger = 4;
        int hB;
        if(bytesLen - (numberLength << 2) == 1)        
        {
            bytes[0] = (byte) ((sign < 0) ? -1 : 0);
            highBytes = 4;
            firstByteNumber++;
        } //End block
        else
        {
            hB = bytesLen & 3;
            highBytes = (hB == 0) ? 4 : hB;
        } //End block
        int digitIndex = iThis;
        bytesLen -= iThis << 2;
        if(sign < 0)        
        {
            int digit = -temp.digits[digitIndex];
            digitIndex++;
            if(digitIndex == numberLength)            
            {
                bytesInInteger = highBytes;
            } //End block
for(int i = 0;i < bytesInInteger;i++,digit >>= 8)
            {
                bytes[--bytesLen] = (byte) digit;
            } //End block
            while
(bytesLen > firstByteNumber)            
            {
                digit = ~temp.digits[digitIndex];
                digitIndex++;
                if(digitIndex == numberLength)                
                {
                    bytesInInteger = highBytes;
                } //End block
for(int i = 0;i < bytesInInteger;i++,digit >>= 8)
                {
                    bytes[--bytesLen] = (byte) digit;
                } //End block
            } //End block
        } //End block
        else
        {
            while
(bytesLen > firstByteNumber)            
            {
                int digit = temp.digits[digitIndex];
                digitIndex++;
                if(digitIndex == numberLength)                
                {
                    bytesInInteger = highBytes;
                } //End block
for(int i = 0;i < bytesInInteger;i++,digit >>= 8)
                {
                    bytes[--bytesLen] = (byte) digit;
                } //End block
            } //End block
        } //End block
        byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_1211684003 = (bytes);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1892797441 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1892797441;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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

    
    @DSModeled(DSC.BAN)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.806 -0400", hash_original_method = "4BA60B28A036933466CC713B9C7854B3", hash_generated_method = "D451F041CE6449D6A5F850F5E8DD9F2B")
     int getFirstNonzeroDigit() {
        if(firstNonzeroDigit == -2)        
        {
            int i;
            if(this.sign == 0)            
            {
                i = -1;
            } //End block
            else
            {
for(i = 0;digits[i] == 0;i++)
                {
                    ;
                } //End block
            } //End block
            firstNonzeroDigit = i;
        } //End block
        int varEA5F8BC6444FBE57A3FF3B039126B1F2_27314703 = (firstNonzeroDigit);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990088159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990088159;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.806 -0400", hash_original_method = "FABC86F56C336DE2152BE8F133BAAD74", hash_generated_method = "CB1774CAA4DE9DAF73827928F3C8D570")
     BigInteger copy() {
        prepareJavaRepresentation();
        int[] copyDigits = new int[numberLength];
        System.arraycopy(digits, 0, copyDigits, 0, numberLength);
BigInteger var07385F68A35B2993CB0AE05D58EC8825_2050929495 =         new BigInteger(sign, numberLength, copyDigits);
        var07385F68A35B2993CB0AE05D58EC8825_2050929495.addTaint(taint);
        return var07385F68A35B2993CB0AE05D58EC8825_2050929495;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //int[] copyDigits = new int[numberLength];
        //System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        //return new BigInteger(sign, numberLength, copyDigits);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.806 -0400", hash_original_method = "883E43F5C4566D0C2A7853533F533817", hash_generated_method = "6D0CEE76D89BFC579C407DC5297AE36E")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
        BigInt bigInt = new BigInt();
        bigInt.putBigEndian(magnitude, signum < 0);
        setBigInt(bigInt);
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //BigInt bigInt = new BigInt();
        //bigInt.putBigEndian(magnitude, signum < 0);
        //setBigInt(bigInt);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.806 -0400", hash_original_method = "4837A11F07A86A58815A56F1112D57DF", hash_generated_method = "9E3A39E058765404F6C23020BE61F28B")
    private void writeObject(ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        BigInt bigInt = getBigInt();
        signum = bigInt.sign();
        magnitude = bigInt.bigEndianMagnitude();
        out.defaultWriteObject();
        // ---------- Original Method ----------
        //BigInt bigInt = getBigInt();
        //signum = bigInt.sign();
        //magnitude = bigInt.bigEndianMagnitude();
        //out.defaultWriteObject();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.806 -0400", hash_original_field = "63016A922509DF10F65084D6222C77C8", hash_generated_field = "ED603E28013A68CF87DC39EDA9672B96")

    private static final long serialVersionUID = -8287574255936472291L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.806 -0400", hash_original_field = "78897A137AA91788C51A9D5D88BD6B22", hash_generated_field = "26A57E8798A6CA862A91D3C87254CE3F")

    public static final BigInteger ZERO = new BigInteger(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.806 -0400", hash_original_field = "E938017D6125C253391B6FF2A79B2347", hash_generated_field = "61E4C0227042D85901BA98B2F2CD52C4")

    public static final BigInteger ONE = new BigInteger(1, 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.806 -0400", hash_original_field = "4252D38540440B1F1E5C9806E972B4B1", hash_generated_field = "7A2B2FAA86270609C420795EB3DF7501")

    public static final BigInteger TEN = new BigInteger(1, 10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.807 -0400", hash_original_field = "C8DE16A040E4D20B9E7749B6EA765BF0", hash_generated_field = "3BE0BD039FD8F547BF6DF239E6C29295")

    static final BigInteger MINUS_ONE = new BigInteger(-1, 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.807 -0400", hash_original_field = "43E384A873FB243B7D032AB564F5C6C0", hash_generated_field = "17509E6A3C7F1A18AC1574943921E065")

    static final BigInteger[] SMALL_VALUES = { ZERO, ONE, new BigInteger(1, 2),
            new BigInteger(1, 3), new BigInteger(1, 4), new BigInteger(1, 5),
            new BigInteger(1, 6), new BigInteger(1, 7), new BigInteger(1, 8),
            new BigInteger(1, 9), TEN };
}

