package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class BigInteger extends Number implements Comparable<BigInteger>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.887 -0400", hash_original_field = "33A2DB2A239C5BAAA46376495EE5F6ED", hash_generated_field = "1B931597CE47BECC94315E7FDFB3AE18")

    private transient BigInt bigInt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.888 -0400", hash_original_field = "F0121707B716C3D41C45CEC890F8FEBD", hash_generated_field = "B1CF9FA5CC5896A14634587A7438CDD0")

    private transient boolean nativeIsValid = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.888 -0400", hash_original_field = "562B560548EAC394A69BD390BABAEBE5", hash_generated_field = "36EDDB91E81C2B3A992259BBDA560C8D")

    private transient boolean javaIsValid = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.888 -0400", hash_original_field = "A2AACBD15B619A9B9E5581A6C33BD2B1", hash_generated_field = "EF92B8843E3664BCE02DEF9DAE8B81D8")

    transient int[] digits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.888 -0400", hash_original_field = "56F736C2BD891F3A00F34C71E5AD8378", hash_generated_field = "49E386B29ED8E51F4B9308F78ED67301")

    transient int numberLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.888 -0400", hash_original_field = "04B29480233F4DEF5C875875B6BDC3B1", hash_generated_field = "92BF56588B083F4EFC932B66DB92601C")

    transient int sign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.888 -0400", hash_original_field = "553C03BFED44A9505466470F56E3ADC5", hash_generated_field = "6063015DEF6F532F83AE577B35CA2F93")

    private transient int firstNonzeroDigit = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.888 -0400", hash_original_field = "327B0A3531EA3D97749FE579CC4632A4", hash_generated_field = "9E963B134F5112D99A51A8B2403DC06B")

    private int signum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.888 -0400", hash_original_field = "28C3D8F4B7E312AF5E0D6B59A50EFD1C", hash_generated_field = "62EEE6A49B1745E7CDFD636319A9ED04")

    private byte[] magnitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.889 -0400", hash_original_field = "B81E47D2AA677809E4BE3C9232B2407F", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.889 -0400", hash_original_method = "E2046ACAAE3FADB78A197B33030B87EF", hash_generated_method = "3E3C50692E79BCF975961B46539BD421")
      BigInteger(BigInt bigInt) {
        addTaint(bigInt.getTaint());
    if(bigInt == null || bigInt.getNativeBIGNUM() == 0)        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1864298051 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1864298051.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1864298051;
        } //End block
        setBigInt(bigInt);
        // ---------- Original Method ----------
        //if (bigInt == null || bigInt.getNativeBIGNUM() == 0) {
            //throw new AssertionError();
        //}
        //setBigInt(bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.889 -0400", hash_original_method = "6A0326FFA4F8DFD22C6BE505D4303A06", hash_generated_method = "92216124076F98A374EFEB47B7382295")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.890 -0400", hash_original_method = "8FE766A630C587CF3D36C6776BEC57AB", hash_generated_method = "48E2A9CFEFC5EDAD56DC73CAEB4CFCF6")
      BigInteger(int sign, int numberLength, int[] digits) {
        addTaint(digits[0]);
        addTaint(numberLength);
        addTaint(sign);
        setJavaRepresentation(sign, numberLength, digits);
        // ---------- Original Method ----------
        //setJavaRepresentation(sign, numberLength, digits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.891 -0400", hash_original_method = "0CDCBE4F35D9E336AD3EE0D0E2D0776D", hash_generated_method = "686B233538FAF7C902DF47CC69300AEE")
    public  BigInteger(int numBits, Random random) {
    if(numBits < 0)        
        {
            IllegalArgumentException var5EC0A1AB7358599CF1B041363EFC33DC_592896104 = new IllegalArgumentException("numBits < 0: " + numBits);
            var5EC0A1AB7358599CF1B041363EFC33DC_592896104.addTaint(taint);
            throw var5EC0A1AB7358599CF1B041363EFC33DC_592896104;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.892 -0400", hash_original_method = "E06C60E93C7C91BB266029ED9C3D532A", hash_generated_method = "96B307F3B2CBEF711EE5A8A3ED4497FA")
    public  BigInteger(int bitLength, int certainty, Random unused) {
        addTaint(unused.getTaint());
        addTaint(certainty);
        addTaint(bitLength);
    if(bitLength < 2)        
        {
            ArithmeticException var8536151F7B087B82351728E2104CCE93_1920782086 = new ArithmeticException("bitLength < 2: " + bitLength);
            var8536151F7B087B82351728E2104CCE93_1920782086.addTaint(taint);
            throw var8536151F7B087B82351728E2104CCE93_1920782086;
        } //End block
        setBigInt(BigInt.generatePrimeDefault(bitLength));
        // ---------- Original Method ----------
        //if (bitLength < 2) {
            //throw new ArithmeticException("bitLength < 2: " + bitLength);
        //}
        //setBigInt(BigInt.generatePrimeDefault(bitLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.892 -0400", hash_original_method = "858DE6DF463E0F4BFB47F99F590AB0EF", hash_generated_method = "32A998134AF57C10FF47D8D7A17DA61C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.893 -0400", hash_original_method = "A13EC41ACC3DF589C11C4779074EEB6B", hash_generated_method = "A65B44CF201C284B56A1746ABA31FE24")
    public  BigInteger(String value, int radix) {
        addTaint(radix);
        addTaint(value.getTaint());
    if(value == null)        
        {
            NullPointerException varE87D3788781943D7792D3AB15C2D739B_1895920429 = new NullPointerException("value == null");
            varE87D3788781943D7792D3AB15C2D739B_1895920429.addTaint(taint);
            throw varE87D3788781943D7792D3AB15C2D739B_1895920429;
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
                NumberFormatException var54A597476E8D47301CB272B80C5D6427_374015007 = new NumberFormatException("Invalid radix: " + radix);
                var54A597476E8D47301CB272B80C5D6427_374015007.addTaint(taint);
                throw var54A597476E8D47301CB272B80C5D6427_374015007;
            } //End block
    if(value.isEmpty())            
            {
                NumberFormatException var1344CEE7E1450045C2CE27CA1D603716_1361696626 = new NumberFormatException("value.isEmpty()");
                var1344CEE7E1450045C2CE27CA1D603716_1361696626.addTaint(taint);
                throw var1344CEE7E1450045C2CE27CA1D603716_1361696626;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.893 -0400", hash_original_method = "4725614D4A9FDEE6DBC2F6DB247469CF", hash_generated_method = "E2F436D0E1E6CD8FF195D45968F250EF")
    public  BigInteger(int signum, byte[] magnitude) {
        addTaint(magnitude[0]);
        addTaint(signum);
    if(magnitude == null)        
        {
            NullPointerException var7E85E86BDB8D9F68EC0E6C966752968B_1200774788 = new NullPointerException("magnitude == null");
            var7E85E86BDB8D9F68EC0E6C966752968B_1200774788.addTaint(taint);
            throw var7E85E86BDB8D9F68EC0E6C966752968B_1200774788;
        } //End block
    if(signum < -1 || signum > 1)        
        {
            NumberFormatException var884F9AED69FB498BC487063C000C7340_308710297 = new NumberFormatException("Invalid signum: " + signum);
            var884F9AED69FB498BC487063C000C7340_308710297.addTaint(taint);
            throw var884F9AED69FB498BC487063C000C7340_308710297;
        } //End block
    if(signum == 0)        
        {
for(byte element : magnitude)
            {
    if(element != 0)                
                {
                    NumberFormatException var5CFBC65388378A39A3646B151F1EDB94_764554991 = new NumberFormatException("signum-magnitude mismatch");
                    var5CFBC65388378A39A3646B151F1EDB94_764554991.addTaint(taint);
                    throw var5CFBC65388378A39A3646B151F1EDB94_764554991;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.894 -0400", hash_original_method = "ABB1E16F13BE7B2CA5EC1AADB52B2350", hash_generated_method = "6D6390D88492187DD4255A396D9ACD96")
    public  BigInteger(byte[] value) {
        addTaint(value[0]);
    if(value.length == 0)        
        {
            NumberFormatException var121D21579486A7E6B31DB9E37100E5DA_1536086386 = new NumberFormatException("value.length == 0");
            var121D21579486A7E6B31DB9E37100E5DA_1536086386.addTaint(taint);
            throw var121D21579486A7E6B31DB9E37100E5DA_1536086386;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.895 -0400", hash_original_method = "7B92331634E6E3BE19D048B912B09B7F", hash_generated_method = "9D4F2615FC19DDAE103241C14A25FF14")
     BigInt getBigInt() {
    if(nativeIsValid)        
        {
BigInt varF61D17EA034CC14FAE8780D55F9242B6_340626446 =             bigInt;
            varF61D17EA034CC14FAE8780D55F9242B6_340626446.addTaint(taint);
            return varF61D17EA034CC14FAE8780D55F9242B6_340626446;
        } //End block
        synchronized
(this)        {
    if(nativeIsValid)            
            {
BigInt varF61D17EA034CC14FAE8780D55F9242B6_1610853542 =                 bigInt;
                varF61D17EA034CC14FAE8780D55F9242B6_1610853542.addTaint(taint);
                return varF61D17EA034CC14FAE8780D55F9242B6_1610853542;
            } //End block
            BigInt bigInt = new BigInt();
            bigInt.putLittleEndianInts(digits, (sign < 0));
            setBigInt(bigInt);
BigInt varF61D17EA034CC14FAE8780D55F9242B6_1964298226 =             bigInt;
            varF61D17EA034CC14FAE8780D55F9242B6_1964298226.addTaint(taint);
            return varF61D17EA034CC14FAE8780D55F9242B6_1964298226;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.895 -0400", hash_original_method = "CC364AFCED646D5BD618C239A0F61C61", hash_generated_method = "FB8F32B7985E2B240502D873FAE13D52")
    private void setBigInt(BigInt bigInt) {
        this.bigInt = bigInt;
        this.nativeIsValid = true;
        // ---------- Original Method ----------
        //this.bigInt = bigInt;
        //this.nativeIsValid = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.897 -0400", hash_original_method = "DA7CFD2DB9135F0E2C89139BCCCBB12F", hash_generated_method = "DDED3CCDAC81118323E9CC670E4E61F1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.899 -0400", hash_original_method = "E11A76F306D885B62849938EE7ACFF1F", hash_generated_method = "31FBFEC90454066EAC8AA5866D1F8758")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.899 -0400", hash_original_method = "F45D943577A758DE4A75A5CD2DF6D206", hash_generated_method = "D2D63B580E818470ECED38DE308B48F8")
    public byte[] toByteArray() {
        byte[] var2417BA9EF054EFFF9DBB86DE9AAC04B5_610437940 = (twosComplement());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1196115869 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1196115869;
        // ---------- Original Method ----------
        //return twosComplement();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.900 -0400", hash_original_method = "4D099B3B9B18238917CAE07611FC89C9", hash_generated_method = "37470C96EF944DFDA1EC1849BDB463E6")
    public BigInteger abs() {
        BigInt bigInt = getBigInt();
    if(bigInt.sign() >= 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_665465318 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_665465318.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_665465318;
        } //End block
        BigInt a = bigInt.copy();
        a.setSign(1);
BigInteger var218BDCFCB1E1EC8559F56659E2425F3E_73114199 =         new BigInteger(a);
        var218BDCFCB1E1EC8559F56659E2425F3E_73114199.addTaint(taint);
        return var218BDCFCB1E1EC8559F56659E2425F3E_73114199;
        // ---------- Original Method ----------
        //BigInt bigInt = getBigInt();
        //if (bigInt.sign() >= 0) {
            //return this;
        //}
        //BigInt a = bigInt.copy();
        //a.setSign(1);
        //return new BigInteger(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.900 -0400", hash_original_method = "DFABA71B5B9AE3E4CD65AD4AD666E31C", hash_generated_method = "924D0F3ADF6209849425154CA27DDC28")
    public BigInteger negate() {
        BigInt bigInt = getBigInt();
        int sign = bigInt.sign();
    if(sign == 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_1344899147 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1344899147.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1344899147;
        } //End block
        BigInt a = bigInt.copy();
        a.setSign(-sign);
BigInteger var218BDCFCB1E1EC8559F56659E2425F3E_1363634160 =         new BigInteger(a);
        var218BDCFCB1E1EC8559F56659E2425F3E_1363634160.addTaint(taint);
        return var218BDCFCB1E1EC8559F56659E2425F3E_1363634160;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.901 -0400", hash_original_method = "5B8AB174D1647BD6610121BBBEE51EE5", hash_generated_method = "63AFC60D60553411FC8761C9D3ED109F")
    public BigInteger add(BigInteger value) {
        addTaint(value.getTaint());
        BigInt lhs = getBigInt();
        BigInt rhs = value.getBigInt();
    if(rhs.sign() == 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_2147096985 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2147096985.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2147096985;
        } //End block
    if(lhs.sign() == 0)        
        {
BigInteger varAF280DA2BC37D8BE783D8499160168DE_73034342 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_73034342.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_73034342;
        } //End block
BigInteger varFCE73B71493AA206EE9BB04AA2B4D532_560128773 =         new BigInteger(BigInt.addition(lhs, rhs));
        varFCE73B71493AA206EE9BB04AA2B4D532_560128773.addTaint(taint);
        return varFCE73B71493AA206EE9BB04AA2B4D532_560128773;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.902 -0400", hash_original_method = "753BA04897A44EE33BA2055C50810858", hash_generated_method = "E9B469D8A2E8D71162797886E4FB672E")
    public BigInteger subtract(BigInteger value) {
        addTaint(value.getTaint());
        BigInt lhs = getBigInt();
        BigInt rhs = value.getBigInt();
    if(rhs.sign() == 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_121878033 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_121878033.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_121878033;
        } //End block
BigInteger var9C5AECC26DFF2341DA3847576C025808_1448082657 =         new BigInteger(BigInt.subtraction(lhs, rhs));
        var9C5AECC26DFF2341DA3847576C025808_1448082657.addTaint(taint);
        return var9C5AECC26DFF2341DA3847576C025808_1448082657;
        // ---------- Original Method ----------
        //BigInt lhs = getBigInt();
        //BigInt rhs = value.getBigInt();
        //if (rhs.sign() == 0) {
            //return this;
        //}
        //return new BigInteger(BigInt.subtraction(lhs, rhs));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.902 -0400", hash_original_method = "0A534AADB97A9D37B49476B54B03D66A", hash_generated_method = "3E8F3313CDB0F0625C334F875FB9E374")
    public int signum() {
    if(javaIsValid)        
        {
            int var04B29480233F4DEF5C875875B6BDC3B1_10643068 = (sign);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935345765 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935345765;
        } //End block
        int var44D38B436477B6C5DAAD2675644143CF_1565933576 = (getBigInt().sign());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827891463 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827891463;
        // ---------- Original Method ----------
        //if (javaIsValid) {
            //return sign;
        //}
        //return getBigInt().sign();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.903 -0400", hash_original_method = "1B97FA7BE1DE29423609E814DD90E66F", hash_generated_method = "F854580F41CDED481D74E26B8A806249")
    public BigInteger shiftRight(int n) {
        addTaint(n);
BigInteger var3A0432B3A6E28F9F920E85C8122DDC2A_773008001 =         shiftLeft(-n);
        var3A0432B3A6E28F9F920E85C8122DDC2A_773008001.addTaint(taint);
        return var3A0432B3A6E28F9F920E85C8122DDC2A_773008001;
        // ---------- Original Method ----------
        //return shiftLeft(-n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.903 -0400", hash_original_method = "3E0E92A5CC7CF6FE74FD251028917DBB", hash_generated_method = "62DA0B29B17F8F9594772A2DB5734811")
    public BigInteger shiftLeft(int n) {
        addTaint(n);
    if(n == 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_1649583297 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1649583297.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1649583297;
        } //End block
        int sign = signum();
    if(sign == 0)        
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_382485433 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_382485433.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_382485433;
        } //End block
    if((sign > 0) || (n >= 0))        
        {
BigInteger varA6312464C4A34A11B7570DD1D595F9FE_1821319533 =             new BigInteger(BigInt.shift(getBigInt(), n));
            varA6312464C4A34A11B7570DD1D595F9FE_1821319533.addTaint(taint);
            return varA6312464C4A34A11B7570DD1D595F9FE_1821319533;
        } //End block
        else
        {
BigInteger var262D1F38C2279DC0C07C480384AD549E_367226106 =             BitLevel.shiftRight(this, -n);
            var262D1F38C2279DC0C07C480384AD549E_367226106.addTaint(taint);
            return var262D1F38C2279DC0C07C480384AD549E_367226106;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.904 -0400", hash_original_method = "3F948826829C47AB028976261F4B8D55", hash_generated_method = "C43A517283EC14AE930E990B5097320F")
     BigInteger shiftLeftOneBit() {
BigInteger varA731EB205789D913808863FEF09D7362_1064051659 =         (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
        varA731EB205789D913808863FEF09D7362_1064051659.addTaint(taint);
        return varA731EB205789D913808863FEF09D7362_1064051659;
        // ---------- Original Method ----------
        //return (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.904 -0400", hash_original_method = "5DD770E4600136986E52E3D1EE5F1B27", hash_generated_method = "876ED3451A1906579B95940C36F16314")
    public int bitLength() {
    if(!nativeIsValid && javaIsValid)        
        {
            int var45B0BE12C3229B34DBB2E60779D54632_677417429 = (BitLevel.bitLength(this));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307616323 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307616323;
        } //End block
        int var01DCFFD04AB0700B9FD2F77D42BA35EF_1948732963 = (getBigInt().bitLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431055223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431055223;
        // ---------- Original Method ----------
        //if (!nativeIsValid && javaIsValid) {
            //return BitLevel.bitLength(this);
        //}
        //return getBigInt().bitLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.906 -0400", hash_original_method = "22DB08B3CA9DDA99CEE301218284C513", hash_generated_method = "863CAFF4598B338BD387CBF1B6750E28")
    public boolean testBit(int n) {
        addTaint(n);
    if(n < 0)        
        {
            ArithmeticException var11571F466B41E34C11FB6A2CA1558885_1211012543 = new ArithmeticException("n < 0: " + n);
            var11571F466B41E34C11FB6A2CA1558885_1211012543.addTaint(taint);
            throw var11571F466B41E34C11FB6A2CA1558885_1211012543;
        } //End block
        int sign = signum();
    if(sign > 0 && nativeIsValid && !javaIsValid)        
        {
            boolean varDC86AAD185DEF12FE95555DDD60CBAF7_1702880101 = (getBigInt().isBitSet(n));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769681902 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_769681902;
        } //End block
        else
        {
            prepareJavaRepresentation();
    if(n == 0)            
            {
                boolean var67C90134A2D9075B820EBC0763F57082_343020460 = (((digits[0] & 1) != 0));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_403809234 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_403809234;
            } //End block
            int intCount = n >> 5;
    if(intCount >= numberLength)            
            {
                boolean varA9F8101E55BCD1D83866DEA546EB449E_1428421157 = ((sign < 0));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_263944587 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_263944587;
            } //End block
            int digit = digits[intCount];
            n = (1 << (n & 31));
    if(sign < 0)            
            {
                int firstNonZeroDigit = getFirstNonzeroDigit();
    if(intCount < firstNonZeroDigit)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1765061101 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1836026812 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1836026812;
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
            boolean varDEB0AA44EC788CFB125469B3B8C9AE09_1508854422 = (((digit & n) != 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1160786465 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1160786465;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.907 -0400", hash_original_method = "0A60006224C30F0C8DC4E0C8D16895AE", hash_generated_method = "7FDA9D818F6591DF1B7B4DA64ABE6FBE")
    public BigInteger setBit(int n) {
        addTaint(n);
        prepareJavaRepresentation();
    if(!testBit(n))        
        {
BigInteger var0E324DA30C13DE74A7B667C295B326B0_850447875 =             BitLevel.flipBit(this, n);
            var0E324DA30C13DE74A7B667C295B326B0_850447875.addTaint(taint);
            return var0E324DA30C13DE74A7B667C295B326B0_850447875;
        } //End block
        else
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_1255147358 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1255147358.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1255147358;
        } //End block
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (!testBit(n)) {
            //return BitLevel.flipBit(this, n);
        //} else {
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.907 -0400", hash_original_method = "8D8C5374E542B708B8A1B41B31DCBF03", hash_generated_method = "42F686B00D5C46D6D055142EFE013D0E")
    public BigInteger clearBit(int n) {
        addTaint(n);
        prepareJavaRepresentation();
    if(testBit(n))        
        {
BigInteger var0E324DA30C13DE74A7B667C295B326B0_2054825854 =             BitLevel.flipBit(this, n);
            var0E324DA30C13DE74A7B667C295B326B0_2054825854.addTaint(taint);
            return var0E324DA30C13DE74A7B667C295B326B0_2054825854;
        } //End block
        else
        {
BigInteger var72A74007B2BE62B849F475C7BDA4658B_1268557524 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1268557524.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1268557524;
        } //End block
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (testBit(n)) {
            //return BitLevel.flipBit(this, n);
        //} else {
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.908 -0400", hash_original_method = "F1D37134A8936EE90081AD78D8487F59", hash_generated_method = "FB91962044E6770EEF461706A6044177")
    public BigInteger flipBit(int n) {
        addTaint(n);
        prepareJavaRepresentation();
    if(n < 0)        
        {
            ArithmeticException var11571F466B41E34C11FB6A2CA1558885_1476305 = new ArithmeticException("n < 0: " + n);
            var11571F466B41E34C11FB6A2CA1558885_1476305.addTaint(taint);
            throw var11571F466B41E34C11FB6A2CA1558885_1476305;
        } //End block
BigInteger var0E324DA30C13DE74A7B667C295B326B0_1594001756 =         BitLevel.flipBit(this, n);
        var0E324DA30C13DE74A7B667C295B326B0_1594001756.addTaint(taint);
        return var0E324DA30C13DE74A7B667C295B326B0_1594001756;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (n < 0) {
            //throw new ArithmeticException("n < 0: " + n);
        //}
        //return BitLevel.flipBit(this, n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.908 -0400", hash_original_method = "8383F139074E92B6BF621C4AC408CB05", hash_generated_method = "791BB629B5F554FD9EA5C4F377D76F68")
    public int getLowestSetBit() {
        prepareJavaRepresentation();
    if(sign == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_579500017 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345056834 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345056834;
        } //End block
        int i = getFirstNonzeroDigit();
        int var9653D777938763685E5D6CC32A6ECFA2_1273405721 = (((i << 5) + Integer.numberOfTrailingZeros(digits[i])));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034988039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034988039;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (sign == 0) {
            //return -1;
        //}
        //int i = getFirstNonzeroDigit();
        //return ((i << 5) + Integer.numberOfTrailingZeros(digits[i]));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.909 -0400", hash_original_method = "2461573222D281ABCA9F3F34AA40AFB9", hash_generated_method = "854BC5DB664BB30E294BE2D0662BCEDA")
    public int bitCount() {
        prepareJavaRepresentation();
        int var81F61709759DC20E20BE73FBCFCEEC28_130754437 = (BitLevel.bitCount(this));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399489906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399489906;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //return BitLevel.bitCount(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.909 -0400", hash_original_method = "CD87C1AB82AE5BD1BDB1D71C1F7F211A", hash_generated_method = "308773D8CF98A39DDCD53F083FA85234")
    public BigInteger not() {
        this.prepareJavaRepresentation();
BigInteger var4AE08097D2179E3BC1F88C3AF11543CB_765573438 =         Logical.not(this);
        var4AE08097D2179E3BC1F88C3AF11543CB_765573438.addTaint(taint);
        return var4AE08097D2179E3BC1F88C3AF11543CB_765573438;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //return Logical.not(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.910 -0400", hash_original_method = "B57E8848F50ED2CEFC86EA20A70D185D", hash_generated_method = "F2785B5AD6532E8B5D06E18823135CE1")
    public BigInteger and(BigInteger value) {
        addTaint(value.getTaint());
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
BigInteger varEC02C5E60DB5787DEFEACB2489D5D715_1115893497 =         Logical.and(this, value);
        varEC02C5E60DB5787DEFEACB2489D5D715_1115893497.addTaint(taint);
        return varEC02C5E60DB5787DEFEACB2489D5D715_1115893497;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.and(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.910 -0400", hash_original_method = "AED35BC9F3B39A40B35087479AE4F222", hash_generated_method = "2B7616C2EACE4129E56077B10A3003F4")
    public BigInteger or(BigInteger value) {
        addTaint(value.getTaint());
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
BigInteger var62F1052A5BD52D57F62233EF70DC95C7_1165395634 =         Logical.or(this, value);
        var62F1052A5BD52D57F62233EF70DC95C7_1165395634.addTaint(taint);
        return var62F1052A5BD52D57F62233EF70DC95C7_1165395634;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.or(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.910 -0400", hash_original_method = "0162D315FD06686CC7830A3D5D5A796E", hash_generated_method = "E2ABD118569892BD0C96E1092B5A6B3D")
    public BigInteger xor(BigInteger value) {
        addTaint(value.getTaint());
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
BigInteger varE711E834E077A084755787F8CA0BDEF7_1296949809 =         Logical.xor(this, value);
        varE711E834E077A084755787F8CA0BDEF7_1296949809.addTaint(taint);
        return varE711E834E077A084755787F8CA0BDEF7_1296949809;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.xor(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.911 -0400", hash_original_method = "A8A90B9F7EBADE4F51C070D1C780A515", hash_generated_method = "31B800D01EAA2C0609DF99B80E69B39B")
    public BigInteger andNot(BigInteger value) {
        addTaint(value.getTaint());
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
BigInteger var3671885F1BEED0B63D869325BB4A0FBE_1550012030 =         Logical.andNot(this, value);
        var3671885F1BEED0B63D869325BB4A0FBE_1550012030.addTaint(taint);
        return var3671885F1BEED0B63D869325BB4A0FBE_1550012030;
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.andNot(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.911 -0400", hash_original_method = "F298334B66A6EA4DC89E250C44198AEA", hash_generated_method = "01C8096135E4587A5E2AA822F819D8FE")
    @Override
    public int intValue() {
    if(nativeIsValid && bigInt.twosCompFitsIntoBytes(4))        
        {
            int var5F3DAB238C48AC6AC195B921EC05B94D_1998253841 = ((int) bigInt.longInt());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944680449 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944680449;
        } //End block
        this.prepareJavaRepresentation();
        int var5085F8A117DFA417EE117E0AD549F783_2032252489 = ((sign * digits[0]));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557499712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557499712;
        // ---------- Original Method ----------
        //if (nativeIsValid && bigInt.twosCompFitsIntoBytes(4)) {
            //return (int) bigInt.longInt();
        //}
        //this.prepareJavaRepresentation();
        //return (sign * digits[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.912 -0400", hash_original_method = "22A0F6A18293749D1CD57F54133930DD", hash_generated_method = "9F772C23A1985CCE82CDD969F63EBA6E")
    @Override
    public long longValue() {
    if(nativeIsValid && bigInt.twosCompFitsIntoBytes(8))        
        {
            long varBEB266E496531BF0ED724E960420F41D_643253656 = (bigInt.longInt());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_427801617 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_427801617;
        } //End block
        prepareJavaRepresentation();
        long value = numberLength > 1
                ? ((long) digits[1]) << 32 | digits[0] & 0xFFFFFFFFL
                : digits[0] & 0xFFFFFFFFL;
        long var35F8744C2ED517A7D1514FC8972FC733_1964965691 = (sign * value);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_832902832 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_832902832;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.913 -0400", hash_original_method = "85C514A29B5895D821780B89C4F747B0", hash_generated_method = "1045BE585F05BF9A75710594EEDD9ECF")
    @Override
    public float floatValue() {
        float var7AF3918BFD2A8BA8BF7150448D9ED402_140184282 = ((float) doubleValue());
                float var546ADE640B6EDFBC8A086EF31347E768_957475141 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_957475141;
        // ---------- Original Method ----------
        //return (float) doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.913 -0400", hash_original_method = "3D8E394E07D4F37AF2C6D72F08026A5D", hash_generated_method = "3DA9D71891C3AD5CFC68D6AAEFF4E4D2")
    @Override
    public double doubleValue() {
        double var2781D155E69A996741A3E634E49E0EDD_1370756013 = (Conversion.bigInteger2Double(this));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1744465805 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1744465805;
        // ---------- Original Method ----------
        //return Conversion.bigInteger2Double(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.914 -0400", hash_original_method = "2F090DBB15C308A00016A444F7C5A620", hash_generated_method = "D93E5075756052DCE146C237B549EC31")
    public int compareTo(BigInteger value) {
        addTaint(value.getTaint());
        int varDA0AAC958F826B901631A78AE0474090_1096123536 = (BigInt.cmp(getBigInt(), value.getBigInt()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113322151 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113322151;
        // ---------- Original Method ----------
        //return BigInt.cmp(getBigInt(), value.getBigInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.914 -0400", hash_original_method = "909F517DD4A19D55540D3A4577FBCF84", hash_generated_method = "6340BC7809241A1C3A8B708C0CB4730F")
    public BigInteger min(BigInteger value) {
        addTaint(value.getTaint());
BigInteger var51D22EBE4ECE3B3E1220E267AD5A4525_1870516492 =         this.compareTo(value) == -1 ? this : value;
        var51D22EBE4ECE3B3E1220E267AD5A4525_1870516492.addTaint(taint);
        return var51D22EBE4ECE3B3E1220E267AD5A4525_1870516492;
        // ---------- Original Method ----------
        //return this.compareTo(value) == -1 ? this : value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.915 -0400", hash_original_method = "6C03178B5A42138223A2B4814CF874FD", hash_generated_method = "D4DC5D563275CF68A9E64DEC2A05ED6F")
    public BigInteger max(BigInteger value) {
        addTaint(value.getTaint());
BigInteger var871A769D3B888770DCECBD01C1D60F65_193491009 =         this.compareTo(value) == 1 ? this : value;
        var871A769D3B888770DCECBD01C1D60F65_193491009.addTaint(taint);
        return var871A769D3B888770DCECBD01C1D60F65_193491009;
        // ---------- Original Method ----------
        //return this.compareTo(value) == 1 ? this : value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.916 -0400", hash_original_method = "8BD8EE457DCE4BEA017BA4C9967BFC77", hash_generated_method = "1BB8D1E93BD9D3119644BE0D8E0BA4B9")
    @Override
    public int hashCode() {
    if(hashCode != 0)        
        {
            int var550D1CC054A1B23A411DDDA46FD64811_45576186 = (hashCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557377963 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557377963;
        } //End block
        prepareJavaRepresentation();
for(int i = 0;i < numberLength;++i)
        {
            hashCode = hashCode * 33 + digits[i];
        } //End block
        hashCode = hashCode * sign;
        int var550D1CC054A1B23A411DDDA46FD64811_1287923251 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327219761 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327219761;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.916 -0400", hash_original_method = "D6CA37529D0AAA6915B88189BBB9DE43", hash_generated_method = "3C42FA369571C064F83930CEE4EBEB52")
    @Override
    public boolean equals(Object x) {
        addTaint(x.getTaint());
    if(this == x)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1440994097 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_848352754 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_848352754;
        } //End block
    if(x instanceof BigInteger)        
        {
            boolean varE297602C835F0C20AE532BD84AFE1753_1114425620 = (this.compareTo((BigInteger) x) == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467402666 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467402666;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1050543022 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1812471934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1812471934;
        // ---------- Original Method ----------
        //if (this == x) {
            //return true;
        //}
        //if (x instanceof BigInteger) {
            //return this.compareTo((BigInteger) x) == 0;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.917 -0400", hash_original_method = "466A78542936FDDF00F235F55782CDB1", hash_generated_method = "F250DE86609A0CB6AE36BF726EF39108")
    @Override
    public String toString() {
String var890F38AC87AB6F8B6AD38900DD43311E_1111813619 =         getBigInt().decString();
        var890F38AC87AB6F8B6AD38900DD43311E_1111813619.addTaint(taint);
        return var890F38AC87AB6F8B6AD38900DD43311E_1111813619;
        // ---------- Original Method ----------
        //return getBigInt().decString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.917 -0400", hash_original_method = "DC1B34095F4DDEED7FED4CD9DAE6BCA6", hash_generated_method = "5FF01CEF78CE127CB9779D06E48D6215")
    public String toString(int radix) {
        addTaint(radix);
    if(radix == 10)        
        {
String var890F38AC87AB6F8B6AD38900DD43311E_1231187700 =             getBigInt().decString();
            var890F38AC87AB6F8B6AD38900DD43311E_1231187700.addTaint(taint);
            return var890F38AC87AB6F8B6AD38900DD43311E_1231187700;
        } //End block
        else
        {
            prepareJavaRepresentation();
String var9A521DCF7FE8B57B3B67450DD37EC19F_351657599 =             Conversion.bigInteger2String(this, radix);
            var9A521DCF7FE8B57B3B67450DD37EC19F_351657599.addTaint(taint);
            return var9A521DCF7FE8B57B3B67450DD37EC19F_351657599;
        } //End block
        // ---------- Original Method ----------
        //if (radix == 10) {
            //return getBigInt().decString();
        //} else {
            //prepareJavaRepresentation();
            //return Conversion.bigInteger2String(this, radix);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.918 -0400", hash_original_method = "DF6919CA8C1CE81A76193FCEFAE3FDAA", hash_generated_method = "DA112DFE322CF78135A45B2F3EE648A5")
    public BigInteger gcd(BigInteger value) {
        addTaint(value.getTaint());
BigInteger var8DD0FF5974D2E7767BA555726449CFF4_1255076021 =         new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
        var8DD0FF5974D2E7767BA555726449CFF4_1255076021.addTaint(taint);
        return var8DD0FF5974D2E7767BA555726449CFF4_1255076021;
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.918 -0400", hash_original_method = "7A377385A7A35B42B025ADA39BD9F319", hash_generated_method = "C8A254D03883D5DFB53F46688354A975")
    public BigInteger multiply(BigInteger value) {
        addTaint(value.getTaint());
BigInteger var76F2E6FB322F14B01150731913C02DE4_1372912959 =         new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
        var76F2E6FB322F14B01150731913C02DE4_1372912959.addTaint(taint);
        return var76F2E6FB322F14B01150731913C02DE4_1372912959;
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.919 -0400", hash_original_method = "670CEDEE32713500748765AA85174DA4", hash_generated_method = "86835C96BD15D69AD2615F86E56EC06F")
    public BigInteger pow(int exp) {
        addTaint(exp);
    if(exp < 0)        
        {
            ArithmeticException var001E700924694F29455645A53E6DD278_1903483094 = new ArithmeticException("exp < 0: " + exp);
            var001E700924694F29455645A53E6DD278_1903483094.addTaint(taint);
            throw var001E700924694F29455645A53E6DD278_1903483094;
        } //End block
BigInteger var9DA8D0215E054A2BF16296FC85448AF2_1214504566 =         new BigInteger(BigInt.exp(getBigInt(), exp));
        var9DA8D0215E054A2BF16296FC85448AF2_1214504566.addTaint(taint);
        return var9DA8D0215E054A2BF16296FC85448AF2_1214504566;
        // ---------- Original Method ----------
        //if (exp < 0) {
            //throw new ArithmeticException("exp < 0: " + exp);
        //}
        //return new BigInteger(BigInt.exp(getBigInt(), exp));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.919 -0400", hash_original_method = "0021B26ACCFD58807A129BEBBFC75B78", hash_generated_method = "19BF589D8D81D1ACD94AAA08B02E5345")
    public BigInteger[] divideAndRemainder(BigInteger divisor) {
        addTaint(divisor.getTaint());
        BigInt divisorBigInt = divisor.getBigInt();
        BigInt quotient = new BigInt();
        BigInt remainder = new BigInt();
        BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
BigInteger[] var8A8A7904E86E4D13D3E7DAF7038CED0E_374202401 =         new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
        var8A8A7904E86E4D13D3E7DAF7038CED0E_374202401.addTaint(taint);
        return var8A8A7904E86E4D13D3E7DAF7038CED0E_374202401;
        // ---------- Original Method ----------
        //BigInt divisorBigInt = divisor.getBigInt();
        //BigInt quotient = new BigInt();
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        //return new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.920 -0400", hash_original_method = "E605E3D77E9B13D877DA6B6F47D67F1F", hash_generated_method = "364222A882C0B48110684F8940FCE367")
    public BigInteger divide(BigInteger divisor) {
        addTaint(divisor.getTaint());
        BigInt quotient = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
BigInteger varF5E42F05753A027547C1024D73D25558_859850796 =         new BigInteger(quotient);
        varF5E42F05753A027547C1024D73D25558_859850796.addTaint(taint);
        return varF5E42F05753A027547C1024D73D25558_859850796;
        // ---------- Original Method ----------
        //BigInt quotient = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        //return new BigInteger(quotient);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.920 -0400", hash_original_method = "FFD2A7C70BA79F9B512531A9A18B49EF", hash_generated_method = "E130A28268C3D5F372323E8241FDBD49")
    public BigInteger remainder(BigInteger divisor) {
        addTaint(divisor.getTaint());
        BigInt remainder = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
BigInteger var10BF6620D7E0C707A7C8019C4ACFA109_1635670610 =         new BigInteger(remainder);
        var10BF6620D7E0C707A7C8019C4ACFA109_1635670610.addTaint(taint);
        return var10BF6620D7E0C707A7C8019C4ACFA109_1635670610;
        // ---------- Original Method ----------
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        //return new BigInteger(remainder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.921 -0400", hash_original_method = "D09D0373DFB5DF67EDACA66D474BB75C", hash_generated_method = "79DBD60D8F00F2DE3C8D8CDFA5D16700")
    public BigInteger modInverse(BigInteger m) {
        addTaint(m.getTaint());
    if(m.signum() <= 0)        
        {
            ArithmeticException var8BB81AC6BF082C408E532E8B3473346D_1957936186 = new ArithmeticException("modulus not positive");
            var8BB81AC6BF082C408E532E8B3473346D_1957936186.addTaint(taint);
            throw var8BB81AC6BF082C408E532E8B3473346D_1957936186;
        } //End block
BigInteger varA5CB9EAB50195FCBCCD7D723E2487DD4_775382259 =         new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
        varA5CB9EAB50195FCBCCD7D723E2487DD4_775382259.addTaint(taint);
        return varA5CB9EAB50195FCBCCD7D723E2487DD4_775382259;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("modulus not positive");
        //}
        //return new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.921 -0400", hash_original_method = "4B2E2C43A8E0C70699BFC0E4EF01E685", hash_generated_method = "704C5B8226FC950ED79B0F736B2D7C3F")
    public BigInteger modPow(BigInteger exponent, BigInteger m) {
        addTaint(m.getTaint());
        addTaint(exponent.getTaint());
    if(m.signum() <= 0)        
        {
            ArithmeticException varA3FE4C88BF590ACADE595D9B17B1082A_703849732 = new ArithmeticException("m.signum() <= 0");
            varA3FE4C88BF590ACADE595D9B17B1082A_703849732.addTaint(taint);
            throw varA3FE4C88BF590ACADE595D9B17B1082A_703849732;
        } //End block
        BigInteger base = exponent.signum() < 0 ? modInverse(m) : this;
BigInteger var5B49E59CA7186F0F5E18AE1173246194_1144802679 =         new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
        var5B49E59CA7186F0F5E18AE1173246194_1144802679.addTaint(taint);
        return var5B49E59CA7186F0F5E18AE1173246194_1144802679;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //BigInteger base = exponent.signum() < 0 ? modInverse(m) : this;
        //return new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.922 -0400", hash_original_method = "ADC51A8E4A4079F65268593A33DD74A7", hash_generated_method = "FD29BB3C3C875CFC01474B0DEDD735B2")
    public BigInteger mod(BigInteger m) {
        addTaint(m.getTaint());
    if(m.signum() <= 0)        
        {
            ArithmeticException varA3FE4C88BF590ACADE595D9B17B1082A_1497362101 = new ArithmeticException("m.signum() <= 0");
            varA3FE4C88BF590ACADE595D9B17B1082A_1497362101.addTaint(taint);
            throw varA3FE4C88BF590ACADE595D9B17B1082A_1497362101;
        } //End block
BigInteger var468BC46EEB8D3FB30B6C4266C9D9D6A8_1078290144 =         new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
        var468BC46EEB8D3FB30B6C4266C9D9D6A8_1078290144.addTaint(taint);
        return var468BC46EEB8D3FB30B6C4266C9D9D6A8_1078290144;
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //return new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.922 -0400", hash_original_method = "718D211034BAE1DECACA1D72CB4CBB13", hash_generated_method = "359837F25E5A2F45397FCAE795EED961")
    public boolean isProbablePrime(int certainty) {
        addTaint(certainty);
    if(certainty <= 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_230690880 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1300276471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1300276471;
        } //End block
        boolean varAE2D570DFC9FA0E1324E3EE0328F6C55_1737735681 = (getBigInt().isPrime(certainty));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1416189787 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1416189787;
        // ---------- Original Method ----------
        //if (certainty <= 0) {
            //return true;
        //}
        //return getBigInt().isPrime(certainty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.923 -0400", hash_original_method = "BB43921F4E806BD72B6F518E8CD8937B", hash_generated_method = "C0B62E77AB3CCCAC4B17742613CD5092")
    public BigInteger nextProbablePrime() {
    if(sign < 0)        
        {
            ArithmeticException var7421D3B8C101F0FD22BC8BC1B4CC03E6_1833755817 = new ArithmeticException("sign < 0");
            var7421D3B8C101F0FD22BC8BC1B4CC03E6_1833755817.addTaint(taint);
            throw var7421D3B8C101F0FD22BC8BC1B4CC03E6_1833755817;
        } //End block
BigInteger var94FA3EB230AA07017F3209E36A021E1F_77535317 =         Primality.nextProbablePrime(this);
        var94FA3EB230AA07017F3209E36A021E1F_77535317.addTaint(taint);
        return var94FA3EB230AA07017F3209E36A021E1F_77535317;
        // ---------- Original Method ----------
        //if (sign < 0) {
            //throw new ArithmeticException("sign < 0");
        //}
        //return Primality.nextProbablePrime(this);
    }

    
        public static BigInteger probablePrime(int bitLength, Random unused) {
        return new BigInteger(bitLength, 100, unused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.925 -0400", hash_original_method = "F2F8EDC382104DB344E8DD617201B0F3", hash_generated_method = "52BAADB252CC69F4BEB8183696A5752E")
    private byte[] twosComplement() {
        prepareJavaRepresentation();
    if(this.sign == 0)        
        {
            byte[] var84902D44E1D087509E7DC8DF24127009_1412535775 = (new byte[] { 0 });
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2076242360 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_2076242360;
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
        byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_1566175819 = (bytes);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1397945458 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1397945458;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.928 -0400", hash_original_method = "4BA60B28A036933466CC713B9C7854B3", hash_generated_method = "0A31E70A47F4B5125044B61FCF76451E")
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
        int varEA5F8BC6444FBE57A3FF3B039126B1F2_1983348591 = (firstNonzeroDigit);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509482867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509482867;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.929 -0400", hash_original_method = "FABC86F56C336DE2152BE8F133BAAD74", hash_generated_method = "7D69FB323919070D6805FF086C1C1781")
     BigInteger copy() {
        prepareJavaRepresentation();
        int[] copyDigits = new int[numberLength];
        System.arraycopy(digits, 0, copyDigits, 0, numberLength);
BigInteger var07385F68A35B2993CB0AE05D58EC8825_2137465073 =         new BigInteger(sign, numberLength, copyDigits);
        var07385F68A35B2993CB0AE05D58EC8825_2137465073.addTaint(taint);
        return var07385F68A35B2993CB0AE05D58EC8825_2137465073;
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //int[] copyDigits = new int[numberLength];
        //System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        //return new BigInteger(sign, numberLength, copyDigits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.929 -0400", hash_original_method = "883E43F5C4566D0C2A7853533F533817", hash_generated_method = "6D0CEE76D89BFC579C407DC5297AE36E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.930 -0400", hash_original_method = "4837A11F07A86A58815A56F1112D57DF", hash_generated_method = "9E3A39E058765404F6C23020BE61F28B")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.931 -0400", hash_original_field = "63016A922509DF10F65084D6222C77C8", hash_generated_field = "ED603E28013A68CF87DC39EDA9672B96")

    private static final long serialVersionUID = -8287574255936472291L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.931 -0400", hash_original_field = "78897A137AA91788C51A9D5D88BD6B22", hash_generated_field = "26A57E8798A6CA862A91D3C87254CE3F")

    public static final BigInteger ZERO = new BigInteger(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.931 -0400", hash_original_field = "E938017D6125C253391B6FF2A79B2347", hash_generated_field = "61E4C0227042D85901BA98B2F2CD52C4")

    public static final BigInteger ONE = new BigInteger(1, 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.931 -0400", hash_original_field = "4252D38540440B1F1E5C9806E972B4B1", hash_generated_field = "7A2B2FAA86270609C420795EB3DF7501")

    public static final BigInteger TEN = new BigInteger(1, 10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.931 -0400", hash_original_field = "C8DE16A040E4D20B9E7749B6EA765BF0", hash_generated_field = "3BE0BD039FD8F547BF6DF239E6C29295")

    static final BigInteger MINUS_ONE = new BigInteger(-1, 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.932 -0400", hash_original_field = "43E384A873FB243B7D032AB564F5C6C0", hash_generated_field = "17509E6A3C7F1A18AC1574943921E065")

    static final BigInteger[] SMALL_VALUES = { ZERO, ONE, new BigInteger(1, 2),
            new BigInteger(1, 3), new BigInteger(1, 4), new BigInteger(1, 5),
            new BigInteger(1, 6), new BigInteger(1, 7), new BigInteger(1, 8),
            new BigInteger(1, 9), TEN };
}

