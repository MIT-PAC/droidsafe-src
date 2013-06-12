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
    private static final long serialVersionUID = -8287574255936472291L;
    private transient BigInt bigInt;
    private transient boolean nativeIsValid = false;
    private transient boolean javaIsValid = false;
    transient int[] digits;
    transient int numberLength;
    transient int sign;
    public static final BigInteger ZERO = new BigInteger(0, 0);
    public static final BigInteger ONE = new BigInteger(1, 1);
    public static final BigInteger TEN = new BigInteger(1, 10);
    static final BigInteger MINUS_ONE = new BigInteger(-1, 1);
    static final BigInteger[] SMALL_VALUES = { ZERO, ONE, new BigInteger(1, 2),
            new BigInteger(1, 3), new BigInteger(1, 4), new BigInteger(1, 5),
            new BigInteger(1, 6), new BigInteger(1, 7), new BigInteger(1, 8),
            new BigInteger(1, 9), TEN };
    private transient int firstNonzeroDigit = -2;
    private int signum;
    private byte[] magnitude;
    private transient int hashCode = 0;
    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
BigInteger(BigInt bigInt) {
        dsTaint.addTaint(bigInt.dsTaint);
        {
            boolean varCBCE59BC652D0587CC25D4F0C19CC324_1480512566 = (bigInt == null || bigInt.getNativeBIGNUM() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.927 -0400", hash_original_method = "6A0326FFA4F8DFD22C6BE505D4303A06", hash_generated_method = "26FB27BACDC826B80BC3420DCAAB37C1")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.928 -0400", hash_original_method = "8FE766A630C587CF3D36C6776BEC57AB", hash_generated_method = "3E8033BC2A0BDA67062B853E6C115F34")
    @DSModeled(DSC.SAFE)
     BigInteger(int sign, int numberLength, int[] digits) {
        dsTaint.addTaint(sign);
        dsTaint.addTaint(numberLength);
        dsTaint.addTaint(digits);
        setJavaRepresentation(sign, numberLength, digits);
        // ---------- Original Method ----------
        //setJavaRepresentation(sign, numberLength, digits);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.932 -0400", hash_original_method = "858DE6DF463E0F4BFB47F99F590AB0EF", hash_generated_method = "614CD24C823F3035A3D8539E42491559")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
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
                boolean var61FDD46CB4F2D30108ACB79894E33C39_1524015130 = (value.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.936 -0400", hash_original_method = "4725614D4A9FDEE6DBC2F6DB247469CF", hash_generated_method = "0DE7BC1353B4F63AB6632AC0E208EB3C")
    @DSModeled(DSC.SAFE)
    public BigInteger(int signum, byte[] magnitude) {
        dsTaint.addTaint(signum);
        dsTaint.addTaint(magnitude);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.938 -0400", hash_original_method = "ABB1E16F13BE7B2CA5EC1AADB52B2350", hash_generated_method = "368D2C3D38015CEB007221ECE5FBDB92")
    @DSModeled(DSC.SAFE)
    public BigInteger(byte[] value) {
        dsTaint.addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.941 -0400", hash_original_method = "7B92331634E6E3BE19D048B912B09B7F", hash_generated_method = "57FA8B451D1A8DCEB88511AD19B242A9")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.943 -0400", hash_original_method = "CC364AFCED646D5BD618C239A0F61C61", hash_generated_method = "DE12F1F6F73325C83D5F10D5FEEB98F5")
    @DSModeled(DSC.SAFE)
    private void setBigInt(BigInt bigInt) {
        dsTaint.addTaint(bigInt.dsTaint);
        this.nativeIsValid = true;
        // ---------- Original Method ----------
        //this.bigInt = bigInt;
        //this.nativeIsValid = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.946 -0400", hash_original_method = "DA7CFD2DB9135F0E2C89139BCCCBB12F", hash_generated_method = "628743F2928967F2EF078B302CC617D2")
    @DSModeled(DSC.SAFE)
    private void setJavaRepresentation(int sign, int numberLength, int[] digits) {
        dsTaint.addTaint(sign);
        dsTaint.addTaint(numberLength);
        dsTaint.addTaint(digits);
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.949 -0400", hash_original_method = "C2FDE5DE76618A54A899B2942400B087", hash_generated_method = "A8EB47B8C37A45FF4BEE01EBB2EA1BF0")
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public byte[] toByteArray() {
        byte[] var3BE346B2FB665BD8F6B33361C4C01498_1317889813 = (twosComplement());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return twosComplement();
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger abs() {
        BigInt bigInt;
        bigInt = getBigInt();
        {
            boolean var62DB935F980131F1A8A6EA88CF668813_683452772 = (bigInt.sign() >= 0);
        } //End collapsed parenthetic
        BigInt a;
        a = bigInt.copy();
        a.setSign(1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.952 -0400", hash_original_method = "DFABA71B5B9AE3E4CD65AD4AD666E31C", hash_generated_method = "D6BF3278535E1F8E99D05431690C6892")
    @DSModeled(DSC.SAFE)
    public BigInteger negate() {
        BigInt bigInt;
        bigInt = getBigInt();
        int sign;
        sign = bigInt.sign();
        BigInt a;
        a = bigInt.copy();
        a.setSign(-sign);
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger add(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        BigInt lhs;
        lhs = getBigInt();
        BigInt rhs;
        rhs = value.getBigInt();
        {
            boolean var715C4C2597076EBBD7DE116903FFEC43_198911404 = (rhs.sign() == 0);
        } //End collapsed parenthetic
        {
            boolean var5A6924AA8D9332981417DC839AF99791_1610324609 = (lhs.sign() == 0);
        } //End collapsed parenthetic
        BigInteger varDCC71E701104CC481CA3182C7DBD9602_1504052839 = (new BigInteger(BigInt.addition(lhs, rhs)));
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger subtract(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        BigInt lhs;
        lhs = getBigInt();
        BigInt rhs;
        rhs = value.getBigInt();
        {
            boolean var715C4C2597076EBBD7DE116903FFEC43_1870138496 = (rhs.sign() == 0);
        } //End collapsed parenthetic
        BigInteger var10F614DD972AC31BE36C0101EDFAB3A3_1387425468 = (new BigInteger(BigInt.subtraction(lhs, rhs)));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigInt lhs = getBigInt();
        //BigInt rhs = value.getBigInt();
        //if (rhs.sign() == 0) {
            //return this;
        //}
        //return new BigInteger(BigInt.subtraction(lhs, rhs));
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public int signum() {
        int var78785A1AB216D9DE61B723A960BFD6AE_630067776 = (getBigInt().sign());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (javaIsValid) {
            //return sign;
        //}
        //return getBigInt().sign();
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger shiftRight(int n) {
        dsTaint.addTaint(n);
        BigInteger varB28ECBFFA274B3996757E093FD8ABD08_1196709455 = (shiftLeft(-n));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return shiftLeft(-n);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger shiftLeft(int n) {
        dsTaint.addTaint(n);
        int sign;
        sign = signum();
        {
            BigInteger varE9C265FDB814C3E86113009545E8D592_917782763 = (new BigInteger(BigInt.shift(getBigInt(), n)));
        } //End block
        {
            BigInteger var113E407321DA7CC6E7E4DBE771FD8153_1846445339 = (BitLevel.shiftRight(this, -n));
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
BigInteger shiftLeftOneBit() {
        {
            boolean var4E2B6D3CAD5F7C0C7183C71097140796_456863178 = ((signum() == 0));
            Object varD66DA8A117F808534F664B27C9487DCC_265310162 = (BitLevel.shiftLeftOneBit(this));
        } //End flattened ternary
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (signum() == 0) ? this : BitLevel.shiftLeftOneBit(this);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public int bitLength() {
        {
            int varEF6F0F502ED0A4A2C2EE418CF96465E4_449967455 = (BitLevel.bitLength(this));
        } //End block
        int var788BC3441C63E42B6C6F5C344E860F68_1895755396 = (getBigInt().bitLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!nativeIsValid && javaIsValid) {
            //return BitLevel.bitLength(this);
        //}
        //return getBigInt().bitLength();
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public boolean testBit(int n) {
        dsTaint.addTaint(n);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("n < 0: " + n);
        } //End block
        int sign;
        sign = signum();
        {
            boolean varF17D7AFCFA584F08AA65771D9B761AB7_1658494768 = (getBigInt().isBitSet(n));
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger setBit(int n) {
        dsTaint.addTaint(n);
        prepareJavaRepresentation();
        {
            boolean var5D4D017D7F453054D257FB916BD85DB7_945622109 = (!testBit(n));
            {
                BigInteger varEC218C3AB6671ACEE0EADB3C088FDD5A_1971219046 = (BitLevel.flipBit(this, n));
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger clearBit(int n) {
        dsTaint.addTaint(n);
        prepareJavaRepresentation();
        {
            boolean varA357D3076F2B8D19676817F90ACD1333_1046339676 = (testBit(n));
            {
                BigInteger varEC218C3AB6671ACEE0EADB3C088FDD5A_1800554317 = (BitLevel.flipBit(this, n));
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger flipBit(int n) {
        dsTaint.addTaint(n);
        prepareJavaRepresentation();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("n < 0: " + n);
        } //End block
        BigInteger varCE6581866328788450C806C8A51058FC_399408752 = (BitLevel.flipBit(this, n));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (n < 0) {
            //throw new ArithmeticException("n < 0: " + n);
        //}
        //return BitLevel.flipBit(this, n);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public int getLowestSetBit() {
        prepareJavaRepresentation();
        int i;
        i = getFirstNonzeroDigit();
        int var08486A238466E45EF685C7096473496F_1688752507 = (((i << 5) + Integer.numberOfTrailingZeros(digits[i])));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //if (sign == 0) {
            //return -1;
        //}
        //int i = getFirstNonzeroDigit();
        //return ((i << 5) + Integer.numberOfTrailingZeros(digits[i]));
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public int bitCount() {
        prepareJavaRepresentation();
        int var03F1A887008EE5D56B89D17C00839C9F_905638606 = (BitLevel.bitCount(this));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //return BitLevel.bitCount(this);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger not() {
        this.prepareJavaRepresentation();
        BigInteger varA8B60C35216CEB7FAAC25DFE6F80F72D_2052933991 = (Logical.not(this));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //return Logical.not(this);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger and(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        BigInteger var55C1929A242B0AA9AF63DE198D1F006B_647370390 = (Logical.and(this, value));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.and(this, value);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger or(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        BigInteger varC769EC071603465F0E670A12E562B150_1553902920 = (Logical.or(this, value));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.or(this, value);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger xor(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        BigInteger var68A226F12BAAE5A7FE86FA7CF04E89C8_1445611420 = (Logical.xor(this, value));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.xor(this, value);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger andNot(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        this.prepareJavaRepresentation();
        value.prepareJavaRepresentation();
        BigInteger varE4424E0B325CAF4481C7B0379B687959_1499311549 = (Logical.andNot(this, value));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //this.prepareJavaRepresentation();
        //value.prepareJavaRepresentation();
        //return Logical.andNot(this, value);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
@Override
    public int intValue() {
        {
            boolean var736C79FFC0E47BDF554712724F023607_1180590743 = (nativeIsValid && bigInt.twosCompFitsIntoBytes(4));
            {
                int var3C648FDB51952E7A4326C06E11E5D714_1687696543 = ((int) bigInt.longInt());
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
@Override
    public long longValue() {
        {
            boolean varC4F1CBA5BA1CCD278A875F7CBF5B1567_322090450 = (nativeIsValid && bigInt.twosCompFitsIntoBytes(8));
            {
                long var4AAAA41C9D1DFB9DDFD6709151B2DF14_1246039425 = (bigInt.longInt());
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
@Override
    public float floatValue() {
        float var988FDD4E54336618413CB2C701826BC6_1674963850 = ((float) doubleValue());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float) doubleValue();
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
@Override
    public double doubleValue() {
        double var986CEBD15E6E1AF84E0E0543465AB73A_1936115713 = (Conversion.bigInteger2Double(this));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return Conversion.bigInteger2Double(this);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public int compareTo(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        int varE8DF5E315CCF42EB1CBFEE65CA4A8DF2_1960373774 = (BigInt.cmp(getBigInt(), value.getBigInt()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return BigInt.cmp(getBigInt(), value.getBigInt());
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger min(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        {
            boolean varFDDD5D1F4BF5B1486C04A8886C9B0458_480375525 = (this.compareTo(value) == -1);
        } //End flattened ternary
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.compareTo(value) == -1 ? this : value;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger max(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        {
            boolean varFC42C5DBC84731BF0F65729BEB047D84_1525177888 = (this.compareTo(value) == 1);
        } //End flattened ternary
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.compareTo(value) == 1 ? this : value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.979 -0400", hash_original_method = "8BD8EE457DCE4BEA017BA4C9967BFC77", hash_generated_method = "A5A8474E6F6C8CA49EB9DE24C7E7496A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
@Override
    public boolean equals(Object x) {
        dsTaint.addTaint(x.dsTaint);
        {
            boolean var8C5538CAE31374871D89268FAA638122_1711877147 = (this.compareTo((BigInteger) x) == 0);
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
@Override
    public String toString() {
        String varA5417AB8A15D2BEFD2DE5757F2F22895_1572397154 = (getBigInt().decString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getBigInt().decString();
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public String toString(int radix) {
        dsTaint.addTaint(radix);
        {
            String var37035A50BBCD5D891E0B031EFC5DBB88_1541829190 = (getBigInt().decString());
        } //End block
        {
            prepareJavaRepresentation();
            String var4966DD704C3960933641906F719B9CAC_362493136 = (Conversion.bigInteger2String(this, radix));
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger gcd(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        BigInteger var4181B88E3C3B6D898756B442E353F175_617053144 = (new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt())));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.gcd(getBigInt(), value.getBigInt()));
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger multiply(BigInteger value) {
        dsTaint.addTaint(value.dsTaint);
        BigInteger varAA5B92C12D4804497E1AA6BE84F71BF9_1072139698 = (new BigInteger(BigInt.product(getBigInt(), value.getBigInt())));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BigInteger(BigInt.product(getBigInt(), value.getBigInt()));
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger pow(int exp) {
        dsTaint.addTaint(exp);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("exp < 0: " + exp);
        } //End block
        BigInteger var4EA8A0B8217C3491C1C94EAC2CB0C276_1551870486 = (new BigInteger(BigInt.exp(getBigInt(), exp)));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (exp < 0) {
            //throw new ArithmeticException("exp < 0: " + exp);
        //}
        //return new BigInteger(BigInt.exp(getBigInt(), exp));
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger[] divideAndRemainder(BigInteger divisor) {
        dsTaint.addTaint(divisor.dsTaint);
        BigInt divisorBigInt;
        divisorBigInt = divisor.getBigInt();
        BigInt quotient;
        quotient = new BigInt();
        BigInt remainder;
        remainder = new BigInt();
        BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        return (BigInteger[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigInt divisorBigInt = divisor.getBigInt();
        //BigInt quotient = new BigInt();
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisorBigInt, quotient, remainder);
        //return new BigInteger[] {new BigInteger(quotient), new BigInteger(remainder) };
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger divide(BigInteger divisor) {
        dsTaint.addTaint(divisor.dsTaint);
        BigInt quotient;
        quotient = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigInt quotient = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), quotient, null);
        //return new BigInteger(quotient);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger remainder(BigInteger divisor) {
        dsTaint.addTaint(divisor.dsTaint);
        BigInt remainder;
        remainder = new BigInt();
        BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigInt remainder = new BigInt();
        //BigInt.division(getBigInt(), divisor.getBigInt(), null, remainder);
        //return new BigInteger(remainder);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger modInverse(BigInteger m) {
        dsTaint.addTaint(m.dsTaint);
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_2044187022 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("modulus not positive");
            } //End block
        } //End collapsed parenthetic
        BigInteger varE4AF724360133D3A42CA57C6FF82C2B0_905598413 = (new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt())));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("modulus not positive");
        //}
        //return new BigInteger(BigInt.modInverse(getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger modPow(BigInteger exponent, BigInteger m) {
        dsTaint.addTaint(exponent.dsTaint);
        dsTaint.addTaint(m.dsTaint);
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_919070691 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("m.signum() <= 0");
            } //End block
        } //End collapsed parenthetic
        BigInteger base;
        boolean varE2809D8580A02DD733D2DE31DC8AE895_2089953908 = (exponent.signum() < 0);
        base = modInverse(m);
        base = this;
        BigInteger var9A68EF10BB8CCA9B382D53296BA966FA_726649352 = (new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt())));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //BigInteger base = exponent.signum() < 0 ? modInverse(m) : this;
        //return new BigInteger(BigInt.modExp(base.getBigInt(), exponent.getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger mod(BigInteger m) {
        dsTaint.addTaint(m.dsTaint);
        {
            boolean var15873CD3F31198FD54273FC8BF634C9A_1781153969 = (m.signum() <= 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("m.signum() <= 0");
            } //End block
        } //End collapsed parenthetic
        BigInteger var0A50EB1E896ECB9A48CE343DE22A9C95_456365181 = (new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt())));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (m.signum() <= 0) {
            //throw new ArithmeticException("m.signum() <= 0");
        //}
        //return new BigInteger(BigInt.modulus(getBigInt(), m.getBigInt()));
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public boolean isProbablePrime(int certainty) {
        dsTaint.addTaint(certainty);
        boolean var527C2D985EF61BA5C7404EDA1C84F2DB_1613013494 = (getBigInt().isPrime(certainty));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (certainty <= 0) {
            //return true;
        //}
        //return getBigInt().isPrime(certainty);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
public BigInteger nextProbablePrime() {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("sign < 0");
        } //End block
        BigInteger var7E5BC374EDC01B67E58EDF07D6428EEA_2083109188 = (Primality.nextProbablePrime(this));
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sign < 0) {
            //throw new ArithmeticException("sign < 0");
        //}
        //return Primality.nextProbablePrime(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:28.990 -0400", hash_original_method = "6FBA03CFDD0A41CE705B7E15E5C549E4", hash_generated_method = "1DEA6F01370CA61EAEFEF50084B76202")
    public static BigInteger probablePrime(int bitLength, Random unused) {
        return new BigInteger(bitLength, 100, unused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:29.004 -0400", hash_original_method = "F2F8EDC382104DB344E8DD617201B0F3", hash_generated_method = "072A11C7D3C9DB5E174D984712160E4B")
    @DSModeled(DSC.SAFE)
    private byte[] twosComplement() {
        prepareJavaRepresentation();
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
            firstByteNumber++;
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
            digitIndex++;
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
                digitIndex++;
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
                digitIndex++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:29.008 -0400", hash_original_method = "C7B24549F3F38126668B66F80A32808B", hash_generated_method = "D8C015B8260638A2E20D10D80BC5B8F4")
    static int multiplyByInt(int[] res, int[] a, int aSize, int factor) {
        long carry = 0;
        for (int i = 0; i < aSize; i++) {
            carry += (a[i] & 0xFFFFFFFFL) * (factor & 0xFFFFFFFFL);
            res[i] = (int) carry;
            carry >>>= 32;
        }
        return (int) carry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:29.009 -0400", hash_original_method = "705008DE67289C90705C837DB37F4C4C", hash_generated_method = "D38AAE882AD3DFA5EF106DD87127C5A3")
    static int inplaceAdd(int[] a, int aSize, int addend) {
        long carry = addend & 0xFFFFFFFFL;
        for (int i = 0; (carry != 0) && (i < aSize); i++) {
            carry += a[i] & 0xFFFFFFFFL;
            a[i] = (int) carry;
            carry >>= 32;
        }
        return (int) carry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:29.011 -0400", hash_original_method = "31C70867F91FE3CA68BF0BEC64F970DB", hash_generated_method = "4B2B66DE8C3AE3A88E95A320476AC24A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:29.013 -0400", hash_original_method = "4BA60B28A036933466CC713B9C7854B3", hash_generated_method = "9D374FA4F0F04F4D5CCB45C258962CE6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:29.015 -0400", hash_original_method = "FABC86F56C336DE2152BE8F133BAAD74", hash_generated_method = "F42DD1213F7FD4B0226B639A94F44797")
    @DSModeled(DSC.SAFE)
     BigInteger copy() {
        prepareJavaRepresentation();
        int[] copyDigits;
        copyDigits = new int[numberLength];
        System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //prepareJavaRepresentation();
        //int[] copyDigits = new int[numberLength];
        //System.arraycopy(digits, 0, copyDigits, 0, numberLength);
        //return new BigInteger(sign, numberLength, copyDigits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:34:29.017 -0400", hash_original_method = "883E43F5C4566D0C2A7853533F533817", hash_generated_method = "5BB5BE0F1E6EF827FCFE53AAA64F219C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.163 -0400",hash_original_method="4837A11F07A86A58815A56F1112D57DF",hash_generated_method="860954D232200766DA2C24CDC1F2B7CB")
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

    
}


