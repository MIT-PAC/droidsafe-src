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
    private transient BigInt bigInt;
    private transient boolean nativeIsValid = false;
    private transient boolean javaIsValid = false;
    transient int[] digits;
    transient int numberLength;
    transient int sign;
    private transient int firstNonzeroDigit = -2;
    private int signum;
    private byte[] magnitude;
    private transient int hashCode = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.513 -0400", hash_original_method = "E2046ACAAE3FADB78A197B33030B87EF", hash_generated_method = "600B5573BC242B2FB9E36E4533FB9946")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BigInteger(BigInt bigInt) {
        dsTaint.addTaint(bigInt.dsTaint);
        {
            boolean varCBCE59BC652D0587CC25D4F0C19CC324_2074417131 = (bigInt == null || bigInt.getNativeBIGNUM() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
        } //End collapsed parenthetic
        setBigInt(bigInt);
        // ---------- Original Method ----------
        //if (bigInt == null || bigInt.getNativeBIGNUM() == 0) {
            //throw new AssertionError();
        //}
        //setBigInt(bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.513 -0400", hash_original_method = "6A0326FFA4F8DFD22C6BE505D4303A06", hash_generated_method = "7EC8902EF23259C7372AE366BB3430ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BigInteger(int sign, long value) {
        dsTaint.addTaint(sign);
        dsTaint.addTaint(value);
        BigInt bigInt;
        bigInt = new BigInt();
        bigInt.putULongInt(value, (sign < 0));
        setBigInt(bigInt);
        // ---------- Original Method ----------
        //BigInt bigInt = new BigInt();
        //bigInt.putULongInt(value, (sign < 0));
        //setBigInt(bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.514 -0400", hash_original_method = "8FE766A630C587CF3D36C6776BEC57AB", hash_generated_method = "5829194A1D0584B3DE2F1299D1DDC195")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BigInteger(int sign, int numberLength, int[] digits) {
        dsTaint.addTaint(sign);
        dsTaint.addTaint(numberLength);
        dsTaint.addTaint(digits[0]);
        setJavaRepresentation(sign, numberLength, digits);
        // ---------- Original Method ----------
        //setJavaRepresentation(sign, numberLength, digits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.514 -0400", hash_original_method = "0CDCBE4F35D9E336AD3EE0D0E2D0776D", hash_generated_method = "2B48B1FBB883ABCD7F4FFCF85A9584F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger(int numBits, Random random) {
        dsTaint.addTaint(numBits);
        dsTaint.addTaint(random.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.514 -0400", hash_original_method = "E06C60E93C7C91BB266029ED9C3D532A", hash_generated_method = "5D931F75C56FA65C741688EB22920893")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger(int bitLength, int certainty, Random unused) {
        dsTaint.addTaint(certainty);
        dsTaint.addTaint(unused.dsTaint);
        dsTaint.addTaint(bitLength);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("bitLength < 2: " + bitLength);
        } //End block
        setBigInt(BigInt.generatePrimeDefault(bitLength));
        // ---------- Original Method ----------
        //if (bitLength < 2) {
            //throw new ArithmeticException("bitLength < 2: " + bitLength);
        //}
        //setBigInt(BigInt.generatePrimeDefault(bitLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.514 -0400", hash_original_method = "858DE6DF463E0F4BFB47F99F590AB0EF", hash_generated_method = "2CCA4B509AADCF5F1D2DDF37DD558ABA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger(String value) {
        dsTaint.addTaint(value);
        BigInt bigInt;
        bigInt = new BigInt();
        bigInt.putDecString(value);
        setBigInt(bigInt);
        // ---------- Original Method ----------
        //BigInt bigInt = new BigInt();
        //bigInt.putDecString(value);
        //setBigInt(bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.515 -0400", hash_original_method = "A13EC41ACC3DF589C11C4779074EEB6B", hash_generated_method = "BE516AAFA1FD4E7346E51AF991A28CF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger(String value, int radix) {
        dsTaint.addTaint(radix);
        dsTaint.addTaint(value);
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
                boolean var61FDD46CB4F2D30108ACB79894E33C39_745926018 = (value.isEmpty());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("value.isEmpty()");
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.519 -0400", hash_original_method = "4725614D4A9FDEE6DBC2F6DB247469CF", hash_generated_method = "20A4653B97DB06585C05B8585C0740C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger(int signum, byte[] magnitude) {
        dsTaint.addTaint(signum);
        dsTaint.addTaint(magnitude[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.519 -0400", hash_original_method = "ABB1E16F13BE7B2CA5EC1AADB52B2350", hash_generated_method = "B96B1D48C970CEC4B61D48D1F13E0A52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger(byte[] value) {
        dsTaint.addTaint(value[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("value.length == 0");
        } //End block
        BigInt bigInt;
        bigInt = new BigInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.520 -0400", hash_original_method = "7B92331634E6E3BE19D048B912B09B7F", hash_generated_method = "4DA92084505A66DA1B9573728767EA0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BigInt getBigInt() {
        {
            BigInt bigInt;
            bigInt = new BigInt();
            bigInt.putLittleEndianInts(digits, (sign < 0));
            setBigInt(bigInt);
        } //End block
        return (BigInt)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.520 -0400", hash_original_method = "CC364AFCED646D5BD618C239A0F61C61", hash_generated_method = "89A6CF3533F93FC28CFE1C12C7A687F2")
    @DSModeled(DSC.SAFE)
    private void setBigInt(BigInt bigInt) {
        dsTaint.addTaint(bigInt.dsTaint);
        this.nativeIsValid = true;
        // ---------- Original Method ----------
        //this.bigInt = bigInt;
        //this.nativeIsValid = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.521 -0400", hash_original_method = "DA7CFD2DB9135F0E2C89139BCCCBB12F", hash_generated_method = "5CCAB52CD6B8D39014FF6883A2D4EA7F")
    @DSModeled(DSC.SAFE)
    private void setJavaRepresentation(int sign, int numberLength, int[] digits) {
        dsTaint.addTaint(sign);
        dsTaint.addTaint(numberLength);
        dsTaint.addTaint(digits[0]);
        {
            ;
        } //End block
        {
            sign = 0;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.521 -0400", hash_original_method = "E11A76F306D885B62849938EE7ACFF1F", hash_generated_method = "7FD6176B1059E967EE7FA7FB5E533B6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.522 -0400", hash_original_method = "F45D943577A758DE4A75A5CD2DF6D206", hash_generated_method = "B5A8C5B686BF368F4891460BB21DF2A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] toByteArray() {
        byte[] var3BE346B2FB665BD8F6B33361C4C01498_1301647493 = (twosComplement());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return twosComplement();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.522 -0400", hash_original_method = "4D099B3B9B18238917CAE07611FC89C9", hash_generated_method = "2C345D62CD000B590D1EAE349ACED081")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger abs() {
        BigInt bigInt;
        bigInt = getBigInt();
        {
            boolean var62DB935F980131F1A8A6EA88CF668813_744010324 = (bigInt.sign() >= 0);
        } //End collapsed parenthetic
        BigInt a;
        a = bigInt.copy();
        a.setSign(1);
        BigInteger var9006420D0C39420B25699B58EEADD938_1469872483 = (new BigInteger(a));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigInt bigInt = getBigInt();
        //if (bigInt.sign() >= 0) {
            //return this;
        //}
        //BigInt a = bigInt.copy();
        //a.setSign(1);
        //return new BigInteger(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.522 -0400", hash_original_method = "DFABA71B5B9AE3E4CD65AD4AD666E31C", hash_generated_method = "7BE445C11737E3CEAA6B6ECD539A6ED0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger negate() {
        BigInt bigInt;
        bigInt = getBigInt();
        int sign;
        sign = bigInt.sign();
        BigInt a;
        a = bigInt.copy();
        a.setSign(-sign);
        BigInteger var9006420D0C39420B25699B58EEADD938_1341175333 = (new BigInteger(a));
        return (BigInteger)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.522 -0400", hash_original_method = "5B8AB174D1647BD6610121BBBEE51EE5", hash_generated_method = "E043390214333AE8278BBAD7AC426B35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger add(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        BigInt lhs;
        lhs = getBigInt();
        BigInt rhs;
        rhs = value.getBigInt();
        {
            boolean var715C4C2597076EBBD7DE116903FFEC43_1680471791 = (rhs.sign() == 0);
        } //End collapsed parenthetic
        {
            boolean var5A6924AA8D9332981417DC839AF99791_1983423226 = (lhs.sign() == 0);
        } //End collapsed parenthetic
        BigInteger varDCC71E701104CC481CA3182C7DBD9602_1114249118 = (new BigInteger(BigInt.addition(lhs, rhs)));
        return (BigInteger)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.523 -0400", hash_original_method = "753BA04897A44EE33BA2055C50810858", hash_generated_method = "8F71452669F4DD21E9E470BE1CFD2C05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger subtract(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        BigInt lhs;
        lhs = getBigInt();
        BigInt rhs;
        rhs = value.getBigInt();
        {
            boolean var715C4C2597076EBBD7DE116903FFEC43_146497994 = (rhs.sign() == 0);
        } //End collapsed parenthetic
        BigInteger var10F614DD972AC31BE36C0101EDFAB3A3_528825558 = (new BigInteger(BigInt.subtraction(lhs, rhs)));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigInt lhs = getBigInt();
        //BigInt rhs = value.getBigInt();
        //if (rhs.sign() == 0) {
            //return this;
        //}
        //return new BigInteger(BigInt.subtraction(lhs, rhs));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.523 -0400", hash_original_method = "0A534AADB97A9D37B49476B54B03D66A", hash_generated_method = "C00E0622228CC0A7CDB406F59BAC754A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int signum() {
        int var78785A1AB216D9DE61B723A960BFD6AE_1293230744 = (getBigInt().sign());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (javaIsValid) {
            //return sign;
        //}
        //return getBigInt().sign();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.523 -0400", hash_original_method = "1B97FA7BE1DE29423609E814DD90E66F", hash_generated_method = "0D16E5FB38696553AB65840AAF5AA8F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger shiftRight(int n) {
        dsTaint.addTaint(n);
        BigInteger varB28ECBFFA274B3996757E093FD8ABD08_503406697 = (shiftLeft(-n));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return shiftLeft(-n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.523 -0400", hash_original_method = "3E0E92A5CC7CF6FE74FD251028917DBB", hash_generated_method = "FB5FB71906372D15DB20D72C57AFF94F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger shiftLeft(int n) {
        dsTaint.addTaint(n);
        int sign;
        sign = signum();
        {
            BigInteger varE9C265FDB814C3E86113009545E8D592_1520029951 = (new BigInteger(BigInt.shift(getBigInt(), n)));
        } //End block
        {
            BigInteger var113E407321DA7CC6E7E4DBE771FD8153_405427125 = (BitLevel.shiftRight(this, -n));
        } //End block
        return (BigInteger)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.524 -0400", hash_original_method = "3F948826829C47AB028976261F4B8D55", hash_generated_method = "B58BC102A4F8BC6E4A543E27378AC41B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BigInteger shiftLeftOneBit() {
        {
            boolean var4E2B6D3CAD5F7C0C7183C71097140796_399079707 = ((signum() == 0));
            Object varD66DA8A117F808534F664B27C9487DCC_988326850 = (BitLevel.shiftLeftOneBit(this));
        } //End flattened ternary
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.524 -0400", hash_original_method = "5DD770E4600136986E52E3D1EE5F1B27", hash_generated_method = "5726B9595431EC70936ECED239658524")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int bitLength() {
        {
            int varEF6F0F502ED0A4A2C2EE418CF96465E4_2084378498 = (BitLevel.bitLength(this));
        } //End block
        int var788BC3441C63E42B6C6F5C344E860F68_191058068 = (getBigInt().bitLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!nativeIsValid && javaIsValid) {
            //return BitLevel.bitLength(this);
        //}
        //return getBigInt().bitLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.524 -0400", hash_original_method = "22DB08B3CA9DDA99CEE301218284C513", hash_generated_method = "AEA6C61DFEFDE1F0E88D05E0A9022023")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean testBit(int n) {
        dsTaint.addTaint(n);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("n < 0: " + n);
        } //End block
        int sign;
        sign = signum();
        {
            boolean varF17D7AFCFA584F08AA65771D9B761AB7_1606776686 = (getBigInt().isBitSet(n));
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.525 -0400", hash_original_method = "0A60006224C30F0C8DC4E0C8D16895AE", hash_generated_method = "CE97B3F0A4D5D3FB4BC505925A8AACA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger setBit(int n) {
        dsTaint.addTaint(n);
        prepareJavaRepresentation();
        {
            boolean var5D4D017D7F453054D257FB916BD85DB7_1413596337 = (!testBit(n));
            {
                BigInteger varEC218C3AB6671ACEE0EADB3C088FDD5A_194835360 = (BitLevel.flipBit(this, n));
            } //End block
        } //End collapsed parenthetic
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (!testBit(n)) {
            //return BitLevel.flipBit(this, n);
        //} else {
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.525 -0400", hash_original_method = "8D8C5374E542B708B8A1B41B31DCBF03", hash_generated_method = "08FC1B187AFEABA2873FE72DF55643BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger clearBit(int n) {
        dsTaint.addTaint(n);
        prepareJavaRepresentation();
        {
            boolean varA357D3076F2B8D19676817F90ACD1333_2118344046 = (testBit(n));
            {
                BigInteger varEC218C3AB6671ACEE0EADB3C088FDD5A_1938035808 = (BitLevel.flipBit(this, n));
            } //End block
        } //End collapsed parenthetic
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (testBit(n)) {
            //return BitLevel.flipBit(this, n);
        //} else {
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.525 -0400", hash_original_method = "F1D37134A8936EE90081AD78D8487F59", hash_generated_method = "80F539A9288A3B6E6BA9CA2D9EEFCBA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger flipBit(int n) {
        dsTaint.addTaint(n);
        prepareJavaRepresentation();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("n < 0: " + n);
        } //End block
        BigInteger varCE6581866328788450C806C8A51058FC_569386577 = (BitLevel.flipBit(this, n));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (n < 0) {
            //throw new ArithmeticException("n < 0: " + n);
        //}
        //return BitLevel.flipBit(this, n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.525 -0400", hash_original_method = "8383F139074E92B6BF621C4AC408CB05", hash_generated_method = "8E52065A162EF0633F390E99CE062ED8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLowestSetBit() {
        prepareJavaRepresentation();
        int i;
        i = getFirstNonzeroDigit();
        int var08486A238466E45EF685C7096473496F_807652582 = (((i << 5) + Integer.numberOfTrailingZeros(digits[i])));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (sign == 0) {
            //return -1;
        //}
        //int i = getFirstNonzeroDigit();
        //return ((i << 5) + Integer.numberOfTrailingZeros(digits[i]));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.526 -0400", hash_original_method = "2461573222D281ABCA9F3F34AA40AFB9", hash_generated_method = "66B3CADDF9C323427F88713AA044D2C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int bitCount() {
        prepareJavaRepresentation();
        int var03F1A887008EE5D56B89D17C00839C9F_841255925 = (BitLevel.bitCount(this));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //return BitLevel.bitCount(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.526 -0400", hash_original_method = "CD87C1AB82AE5BD1BDB1D71C1F7F211A", hash_generated_method = "57C9250E161BB689D67DD1A11FAB5C81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger not() {
        this.prepareJavaRepresentation();
        BigInteger varA8B60C35216CEB7FAAC25DFE6F80F72D_516461485 = (Logical.not(this));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //return Logical.not(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.526 -0400", hash_original_method = "B57E8848F50ED2CEFC86EA20A70D185D", hash_generated_method = "2B2D13A592CBF5487CEA7BF951D753FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger and(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        BigInteger var55C1929A242B0AA9AF63DE198D1F006B_686307926 = (Logical.and(this, value));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.and(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.526 -0400", hash_original_method = "AED35BC9F3B39A40B35087479AE4F222", hash_generated_method = "B32B41B1055483649F40F8A724EE450D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger or(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        BigInteger varC769EC071603465F0E670A12E562B150_1091472511 = (Logical.or(this, value));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.or(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.527 -0400", hash_original_method = "0162D315FD06686CC7830A3D5D5A796E", hash_generated_method = "E016D50048CD8F02CCC2E3CECF10FE5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger xor(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        BigInteger var68A226F12BAAE5A7FE86FA7CF04E89C8_412836403 = (Logical.xor(this, value));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.xor(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.527 -0400", hash_original_method = "A8A90B9F7EBADE4F51C070D1C780A515", hash_generated_method = "69E50118AC49D7D092AB28CA1CBF822C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger andNot(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        BigInteger varE4424E0B325CAF4481C7B0379B687959_1436913578 = (Logical.andNot(this, value));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.andNot(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.527 -0400", hash_original_method = "F298334B66A6EA4DC89E250C44198AEA", hash_generated_method = "1B7C7CE4F8BBC75C812EEC6A1382B3B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int intValue() {
        {
            boolean var736C79FFC0E47BDF554712724F023607_1472416963 = (nativeIsValid && bigInt.twosCompFitsIntoBytes(4));
            {
                int var3C648FDB51952E7A4326C06E11E5D714_1985932701 = ((int) bigInt.longInt());
            } //End block
        } //End collapsed parenthetic
        this.prepareJavaRepresentation();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (nativeIsValid && bigInt.twosCompFitsIntoBytes(4)) {
            //return (int) bigInt.longInt();
        //}
        //this.prepareJavaRepresentation();
        //return (sign * digits[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.527 -0400", hash_original_method = "22A0F6A18293749D1CD57F54133930DD", hash_generated_method = "01DF148832FC8F16061608128088893A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long longValue() {
        {
            boolean varC4F1CBA5BA1CCD278A875F7CBF5B1567_1304459045 = (nativeIsValid && bigInt.twosCompFitsIntoBytes(8));
            {
                long var4AAAA41C9D1DFB9DDFD6709151B2DF14_133975024 = (bigInt.longInt());
            } //End block
        } //End collapsed parenthetic
        prepareJavaRepresentation();
        long value;
        value = ((long) digits[1]) << 32 | digits[0] & 0xFFFFFFFFL;
        value = digits[0] & 0xFFFFFFFFL;
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.528 -0400", hash_original_method = "85C514A29B5895D821780B89C4F747B0", hash_generated_method = "9321A4EC7F7F6E0DBB3EF771368CC520")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public float floatValue() {
        float var988FDD4E54336618413CB2C701826BC6_569111363 = ((float) doubleValue());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float) doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.528 -0400", hash_original_method = "3D8E394E07D4F37AF2C6D72F08026A5D", hash_generated_method = "61E54F452D1AE10A3B6572F8A6BA2E2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public double doubleValue() {
        double var986CEBD15E6E1AF84E0E0543465AB73A_440564879 = (Conversion.bigInteger2Double(this));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return Conversion.bigInteger2Double(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.529 -0400", hash_original_method = "2F090DBB15C308A00016A444F7C5A620", hash_generated_method = "AE8E6FE14C80970A99D61399D5111851")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        int varE8DF5E315CCF42EB1CBFEE65CA4A8DF2_1211605575 = (BigInt.cmp(getBigInt(), value.getBigInt()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return BigInt.cmp(getBigInt(), value.getBigInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.530 -0400", hash_original_method = "909F517DD4A19D55540D3A4577FBCF84", hash_generated_method = "88A8EE7E702664FFE5DB2EEA56635C72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger min(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        {
            boolean varFDDD5D1F4BF5B1486C04A8886C9B0458_2112300088 = (this.compareTo(value) == -1);
        } //End flattened ternary
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.compareTo(value) == -1 ? this : value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.530 -0400", hash_original_method = "6C03178B5A42138223A2B4814CF874FD", hash_generated_method = "520A7E54875DC8F3A12451024C71814D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger max(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        {
            boolean varFC42C5DBC84731BF0F65729BEB047D84_1394643678 = (this.compareTo(value) == 1);
        } //End flattened ternary
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.compareTo(value) == 1 ? this : value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.530 -0400", hash_original_method = "8BD8EE457DCE4BEA017BA4C9967BFC77", hash_generated_method = "26C568D640475C740013E8FAD0E44BD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.530 -0400", hash_original_method = "D6CA37529D0AAA6915B88189BBB9DE43", hash_generated_method = "77EEC3A6278D194EFC6D634A12E41F42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object x) {
        dsTaint.addTaint(x.dsTaint);
        {
            boolean var8C5538CAE31374871D89268FAA638122_1209868039 = (this.compareTo((BigInteger) x) == 0);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == x) {
            //return true;
        //}
        //if (x instanceof BigInteger) {
            //return this.compareTo((BigInteger) x) == 0;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.531 -0400", hash_original_method = "466A78542936FDDF00F235F55782CDB1", hash_generated_method = "C87ECEA9135234E201FE94BECEAD923E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varA5417AB8A15D2BEFD2DE5757F2F22895_1239528785 = (getBigInt().decString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getBigInt().decString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.531 -0400", hash_original_method = "DC1B34095F4DDEED7FED4CD9DAE6BCA6", hash_generated_method = "AA7C47ECF4F23C7F972B869C653D3ACE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString(int radix) {
        dsTaint.addTaint(radix);
        {
            String var37035A50BBCD5D891E0B031EFC5DBB88_2015570329 = (getBigInt().decString());
        } //End block
        {
            prepareJavaRepresentation();
            String var4966DD704C3960933641906F719B9CAC_2005915307 = (Conversion.bigInteger2String(this, radix));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (radix == 10) {
            //return getBigInt().decString();
        //} else {
            //prepareJavaRepresentation();
            //return Conversion.bigInteger2String(this, radix);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.531 -0400", hash_original_method = "DF6919CA8C1CE81A76193FCEFAE3FDAA", hash_generated_method = "95CDE9344D95FDFA050E2112E3523307")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger gcd(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        BigInteger var4181B88E3C3B6D898756B442E353F175_199926580 = (new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt())));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.531 -0400", hash_original_method = "7A377385A7A35B42B025ADA39BD9F319", hash_generated_method = "FF6D52DE07AABAEAE18203EF8877D800")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger multiply(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        BigInteger varAA5B92C12D4804497E1AA6BE84F71BF9_186345138 = (new BigInteger(BigInt.product(getBigInt(), value.getBigInt())));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.531 -0400", hash_original_method = "670CEDEE32713500748765AA85174DA4", hash_generated_method = "C09FA9A2F8E2DD42F82540EF73A34784")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger pow(int exp) {
        dsTaint.addTaint(exp);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("exp < 0: " + exp);
        } //End block
        BigInteger var4EA8A0B8217C3491C1C94EAC2CB0C276_556470517 = (new BigInteger(BigInt.exp(getBigInt(), exp)));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (exp < 0) {
            //throw new ArithmeticException("exp < 0: " + exp);
        //}
        //return new BigInteger(BigInt.exp(getBigInt(), exp));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.532 -0400", hash_original_method = "0021B26ACCFD58807A129BEBBFC75B78", hash_generated_method = "3C1E01A00EAB3B1C7D6999ECEE090427")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger[] divideAndRemainder(BigInteger divisor) {
        dsTaint.addTaint(divisor.dsTaint);
        BigInt divisorBigInt;
        divisorBigInt = divisor.getBigInt();
        BigInt quotient;
        quotient = new BigInt();
        BigInt remainder;
        remainder = new BigInt();
        BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        BigInteger[] var4ACBAB91DD384E0A9CB5EB8101BA6183_1904252698 = (new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) });
        return (BigInteger[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigInt divisorBigInt = divisor.getBigInt();
        //BigInt quotient = new BigInt();
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        //return new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.532 -0400", hash_original_method = "E605E3D77E9B13D877DA6B6F47D67F1F", hash_generated_method = "C163CEE10FE12BB17B18E4E01F79E33A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger divide(BigInteger divisor) {
        dsTaint.addTaint(divisor.dsTaint);
        BigInt quotient;
        quotient = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        BigInteger varE08CA360BAB635B0A1B74D5CBD22DF11_1364433111 = (new BigInteger(quotient));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigInt quotient = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        //return new BigInteger(quotient);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.532 -0400", hash_original_method = "FFD2A7C70BA79F9B512531A9A18B49EF", hash_generated_method = "907B73AC33DDAF21252D0450AD38A3FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger remainder(BigInteger divisor) {
        dsTaint.addTaint(divisor.dsTaint);
        BigInt remainder;
        remainder = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        BigInteger varB7C7451F58AB83D2057E687C662BEB73_839424969 = (new BigInteger(remainder));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        //return new BigInteger(remainder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.532 -0400", hash_original_method = "D09D0373DFB5DF67EDACA66D474BB75C", hash_generated_method = "16962B4B2738049238096FF25F2DC5A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger modInverse(BigInteger m) {
        dsTaint.addTaint(m.dsTaint);
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_412038451 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("modulus not positive");
            } //End block
        } //End collapsed parenthetic
        BigInteger varE4AF724360133D3A42CA57C6FF82C2B0_1272274379 = (new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt())));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("modulus not positive");
        //}
        //return new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.532 -0400", hash_original_method = "4B2E2C43A8E0C70699BFC0E4EF01E685", hash_generated_method = "E73BDFF2C7953B4F85A1E216BF093548")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger modPow(BigInteger exponent, BigInteger m) {
        dsTaint.addTaint(exponent.dsTaint);
        dsTaint.addTaint(m.dsTaint);
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_2064188665 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("m.signum() <= 0");
            } //End block
        } //End collapsed parenthetic
        BigInteger base;
        boolean varE2809D8580A02DD733D2DE31DC8AE895_2032779828 = (exponent.signum() < 0);
        base = modInverse(m);
        base = this;
        BigInteger var9A68EF10BB8CCA9B382D53296BA966FA_149450839 = (new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt())));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //BigInteger base = exponent.signum() < 0 ? modInverse(m) : this;
        //return new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.533 -0400", hash_original_method = "ADC51A8E4A4079F65268593A33DD74A7", hash_generated_method = "CAF21E9B665C27BB290A698556E15550")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger mod(BigInteger m) {
        dsTaint.addTaint(m.dsTaint);
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_1384179900 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("m.signum() <= 0");
            } //End block
        } //End collapsed parenthetic
        BigInteger var0A50EB1E896ECB9A48CE343DE22A9C95_1098421129 = (new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt())));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //return new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.533 -0400", hash_original_method = "718D211034BAE1DECACA1D72CB4CBB13", hash_generated_method = "DF720E8E703B387DBBBF0C6D5A541133")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isProbablePrime(int certainty) {
        dsTaint.addTaint(certainty);
        boolean var527C2D985EF61BA5C7404EDA1C84F2DB_1833564395 = (getBigInt().isPrime(certainty));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (certainty <= 0) {
            //return true;
        //}
        //return getBigInt().isPrime(certainty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.533 -0400", hash_original_method = "BB43921F4E806BD72B6F518E8CD8937B", hash_generated_method = "74CDF578DBCDDDE37BE7ED17583F29E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger nextProbablePrime() {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("sign < 0");
        } //End block
        BigInteger var7E5BC374EDC01B67E58EDF07D6428EEA_1109082299 = (Primality.nextProbablePrime(this));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sign < 0) {
            //throw new ArithmeticException("sign < 0");
        //}
        //return Primality.nextProbablePrime(this);
    }

    
        public static BigInteger probablePrime(int bitLength, Random unused) {
        return new BigInteger(bitLength, 100, unused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.534 -0400", hash_original_method = "F2F8EDC382104DB344E8DD617201B0F3", hash_generated_method = "5BA54AD3A04B5B5844BC9CC98E831799")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] twosComplement() {
        prepareJavaRepresentation();
        {
            byte[] var871F8A6A5DD979D0CBC073DD77C1CF91_178768186 = (new byte[] { 0 });
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
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.535 -0400", hash_original_method = "4BA60B28A036933466CC713B9C7854B3", hash_generated_method = "12901AA40B5CBF5AA345C0989CD83CE9")
    @DSModeled(DSC.SAFE)
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.535 -0400", hash_original_method = "FABC86F56C336DE2152BE8F133BAAD74", hash_generated_method = "C0D64C177B3B0181C5302BF4662F8EF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BigInteger copy() {
        prepareJavaRepresentation();
        int[] copyDigits;
        copyDigits = new int[numberLength];
        System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        BigInteger varBFBE8A28F722FB3AF7E84C6FDE284DF1_496321260 = (new BigInteger(sign, numberLength, copyDigits));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //int[] copyDigits = new int[numberLength];
        //System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        //return new BigInteger(sign, numberLength, copyDigits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.535 -0400", hash_original_method = "883E43F5C4566D0C2A7853533F533817", hash_generated_method = "493F523D928C7ACEC20B7B31D2A60EC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        in.defaultReadObject();
        BigInt bigInt;
        bigInt = new BigInt();
        bigInt.putBigEndian(magnitude, signum < 0);
        setBigInt(bigInt);
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //BigInt bigInt = new BigInt();
        //bigInt.putBigEndian(magnitude, signum < 0);
        //setBigInt(bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.535 -0400", hash_original_method = "4837A11F07A86A58815A56F1112D57DF", hash_generated_method = "73D50AB28EEC2F6BDACA2F53BB28F136")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        BigInt bigInt;
        bigInt = getBigInt();
        signum = bigInt.sign();
        magnitude = bigInt.bigEndianMagnitude();
        out.defaultWriteObject();
        // ---------- Original Method ----------
        //BigInt bigInt = getBigInt();
        //signum = bigInt.sign();
        //magnitude = bigInt.bigEndianMagnitude();
        //out.defaultWriteObject();
    }

    
    private static final long serialVersionUID = -8287574255936472291L;
    public static final BigInteger ZERO = new BigInteger(0, 0);
    public static final BigInteger ONE = new BigInteger(1, 1);
    public static final BigInteger TEN = new BigInteger(1, 10);
    static final BigInteger MINUS_ONE = new BigInteger(-1, 1);
    static final BigInteger[] SMALL_VALUES = { ZERO, ONE, new BigInteger(1, 2),
            new BigInteger(1, 3), new BigInteger(1, 4), new BigInteger(1, 5),
            new BigInteger(1, 6), new BigInteger(1, 7), new BigInteger(1, 8),
            new BigInteger(1, 9), TEN };
}

