package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import libcore.math.MathUtils;

public class BigDecimal extends Number implements Comparable<BigDecimal>, Serializable {
    public static final int ROUND_UP = 0;
    public static final int ROUND_DOWN = 1;
    public static final int ROUND_CEILING = 2;
    public static final int ROUND_FLOOR = 3;
    public static final int ROUND_HALF_UP = 4;
    public static final int ROUND_HALF_DOWN = 5;
    public static final int ROUND_HALF_EVEN = 6;
    public static final int ROUND_UNNECESSARY = 7;
    private static final long serialVersionUID = 6108874887143696463L;
    private static final double LOG10_2 = 0.3010299956639812;
    private transient String toStringImage = null;
    private transient int hashCode = 0;
    private static final BigInteger[] FIVE_POW;
    private static final BigInteger[] TEN_POW;
    private static final long[] LONG_FIVE_POW = new long[]
    {   1L,
        5L,
        25L,
        125L,
        625L,
        3125L,
        15625L,
        78125L,
        390625L,
        1953125L,
        9765625L,
        48828125L,
        244140625L,
        1220703125L,
        6103515625L,
        30517578125L,
        152587890625L,
        762939453125L,
        3814697265625L,
        19073486328125L,
        95367431640625L,
        476837158203125L,
        2384185791015625L,
        11920928955078125L,
        59604644775390625L,
        298023223876953125L,
        1490116119384765625L,
        7450580596923828125L, };
    private static final int[] LONG_FIVE_POW_BIT_LENGTH = new int[LONG_FIVE_POW.length];
    private static final int[] LONG_POWERS_OF_TEN_BIT_LENGTH = new int[MathUtils.LONG_POWERS_OF_TEN.length];
    private static final int BI_SCALED_BY_ZERO_LENGTH = 11;
    private static final BigDecimal[] BI_SCALED_BY_ZERO = new BigDecimal[BI_SCALED_BY_ZERO_LENGTH];
    private static final BigDecimal[] ZERO_SCALED_BY = new BigDecimal[11];
    private static final char[] CH_ZEROS = new char[100];
    public static final BigDecimal ZERO = new BigDecimal(0, 0);
    public static final BigDecimal ONE = new BigDecimal(1, 0);
    public static final BigDecimal TEN = new BigDecimal(10, 0);
    private BigInteger intVal;
    private transient int bitLength;
    private transient long smallValue;
    private int scale;
    private transient int precision = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.120 -0400", hash_original_method = "6BC27F867C09C0249873A4D338F8666D", hash_generated_method = "EE218B504DABB01C4CD35CE532BAB3A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private BigDecimal(long smallValue, int scale) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(smallValue);
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.120 -0400", hash_original_method = "9F6CD654516DCD03F33530EDCF81D84D", hash_generated_method = "37BFCDA2C1EA34AAB8F3B8E9ED4CE7BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private BigDecimal(int smallValue, int scale) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(smallValue);
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.121 -0400", hash_original_method = "374C425CF4086C798A21EEA670343536", hash_generated_method = "FC61497BEDB05B9096D4B3BCBBEEA88E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(char[] in, int offset, int len) {
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(in);
        int begin;
        begin = offset;
        int last;
        last = offset + (len - 1);
        String scaleString;
        StringBuilder unscaledBuffer;
        long newScale;
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        if(DroidSafeAndroidRuntime.control) {
            throw new NumberFormatException("Bad offset/length: offset=" + offset +
                    " len=" + len + " in.length=" + in.length);
        } //End block
        unscaledBuffer = new StringBuilder(len);
        int bufLength;
        bufLength = 0;
        {
            offset++;
            begin++;
        } //End block
        int counter;
        counter = 0;
        boolean wasNonZero;
        wasNonZero = false;
        {
            {
                {
                    counter++;
                } //End block
                {
                    wasNonZero = true;
                } //End block
            } //End block
        } //End block
        unscaledBuffer.append(in, begin, offset - begin);
        bufLength += offset - begin;
        {
            offset++;
            begin = offset;
            {
                {
                    {
                        counter++;
                    } //End block
                    {
                        wasNonZero = true;
                    } //End block
                } //End block
            } //End block
            scale = offset - begin;
            bufLength +=scale;
            unscaledBuffer.append(in, begin, scale);
        } //End block
        {
            scale = 0;
        } //End block
        {
            offset++;
            begin = offset;
            {
                offset++;
                {
                    begin++;
                } //End block
            } //End block
            scaleString = String.valueOf(in, begin, last + 1 - begin);
            newScale = (long)scale - Integer.parseInt(scaleString);
            scale = (int)newScale;
            if(DroidSafeAndroidRuntime.control) {
                throw new NumberFormatException("Scale out of range");
            } //End block
        } //End block
        {
            smallValue = Long.parseLong(unscaledBuffer.toString());
            bitLength = bitLength(smallValue);
        } //End block
        {
            setUnscaledValue(new BigInteger(unscaledBuffer.toString()));
        } //End block
        precision = unscaledBuffer.length() - counter;
        {
            boolean var61B48B5FEE897AE42C98AFC63C6454F8_2023594574 = (unscaledBuffer.charAt(0) == '-');
            {
                precision --;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.121 -0400", hash_original_method = "021DB19003FFCB38960FC53E0DB20D11", hash_generated_method = "C1E6E5510192B39E7F260CE35E44457A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(char[] in, int offset, int len, MathContext mc) {
        this(in, offset, len);
        dsTaint.addTaint(mc.dsTaint);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(in);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.121 -0400", hash_original_method = "2CA49E7A005F756FE298C75D3E276FBD", hash_generated_method = "0A0231A3BBE2B922D9665CAD7ECB2D02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(char[] in) {
        this(in, 0, in.length);
        dsTaint.addTaint(in);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.121 -0400", hash_original_method = "24A3A809E90D8D728111B1E9DFB6AE2B", hash_generated_method = "74ADED4964D24A1D325C3B569C352A60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(char[] in, MathContext mc) {
        this(in, 0, in.length);
        dsTaint.addTaint(mc.dsTaint);
        dsTaint.addTaint(in);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.121 -0400", hash_original_method = "97883F5F25D8C2D5B9EC2501AC7ECDA2", hash_generated_method = "C479FA13A0FB7984079302A42C66E2C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(String val) {
        this(val.toCharArray(), 0, val.length());
        dsTaint.addTaint(val);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.121 -0400", hash_original_method = "65FA78E7CB5F82CDA77BAA4B434CD165", hash_generated_method = "875C36C20ED2BF08440211762729119F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(String val, MathContext mc) {
        this(val.toCharArray(), 0, val.length());
        dsTaint.addTaint(val);
        dsTaint.addTaint(mc.dsTaint);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.121 -0400", hash_original_method = "A550123107439183BDAF78BFBC33380D", hash_generated_method = "6D3A3DDCCBAD575572218E5002D77DF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(double val) {
        dsTaint.addTaint(val);
        {
            boolean var07ED44AABC248720567522E1772FEBCB_1853613766 = (Double.isInfinite(val) || Double.isNaN(val));
            if(DroidSafeAndroidRuntime.control) {
                throw new NumberFormatException("Infinity or NaN: " + val);
            } //End block
        } //End collapsed parenthetic
        long bits;
        bits = Double.doubleToLongBits(val);
        long mantissa;
        int trailingZeros;
        scale = 1075 - (int)((bits >> 52) & 0x7FFL);
        mantissa = (scale == 1075) ? (bits & 0xFFFFFFFFFFFFFL) << 1
                : (bits & 0xFFFFFFFFFFFFFL) | 0x10000000000000L;
        {
            scale = 0;
            precision = 1;
        } //End block
        {
            trailingZeros = Math.min(scale, Long.numberOfTrailingZeros(mantissa));
            mantissa >>>= trailingZeros;
            scale -= trailingZeros;
        } //End block
        {
            mantissa = -mantissa;
        } //End block
        int mantissaBits;
        mantissaBits = bitLength(mantissa);
        {
            bitLength = mantissaBits == 0 ? 0 : mantissaBits - scale;
            {
                smallValue = mantissa << (-scale);
            } //End block
            {
                BigInt bi;
                bi = new BigInt();
                bi.putLongInt(mantissa);
                bi.shift(-scale);
                intVal = new BigInteger(bi);
            } //End block
            scale = 0;
        } //End block
        {
            {
                smallValue = mantissa * LONG_FIVE_POW[scale];
                bitLength = bitLength(smallValue);
            } //End block
            {
                setUnscaledValue(Multiplication.multiplyByFivePow(BigInteger.valueOf(mantissa), scale));
            } //End block
        } //End block
        {
            smallValue = mantissa;
            bitLength = mantissaBits;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.121 -0400", hash_original_method = "A301A521891A68A20E545213C1CF7F7F", hash_generated_method = "770B7C8164D6CCC34146B5D30B9F1945")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(double val, MathContext mc) {
        this(val);
        dsTaint.addTaint(val);
        dsTaint.addTaint(mc.dsTaint);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.121 -0400", hash_original_method = "35103202AC4D8227390F065BF679C471", hash_generated_method = "FD9E3AF3CBE94344398FD60CB4B3DC43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(BigInteger val) {
        this(val, 0);
        dsTaint.addTaint(val.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "4DD15F45D533F2889A2A72BE2BF675A6", hash_generated_method = "7702D7D1296D2F06795E9EAC82644436")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(BigInteger val, MathContext mc) {
        this(val);
        dsTaint.addTaint(val.dsTaint);
        dsTaint.addTaint(mc.dsTaint);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "E5BF86952E31D522F2FAABCF30464562", hash_generated_method = "9ED8F5BCD587EE5464164555D41BA9EC")
    @DSModeled(DSC.SAFE)
    public BigDecimal(BigInteger unscaledVal, int scale) {
        dsTaint.addTaint(unscaledVal.dsTaint);
        dsTaint.addTaint(scale);
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        setUnscaledValue(unscaledVal);
        // ---------- Original Method ----------
        //if (unscaledVal == null) {
            //throw new NullPointerException();
        //}
        //this.scale = scale;
        //setUnscaledValue(unscaledVal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "59F34EC0A04F061EC6FA9A9EFC322A4C", hash_generated_method = "BCE21CFA1CE74CD8F581949D021C32F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(BigInteger unscaledVal, int scale, MathContext mc) {
        this(unscaledVal, scale);
        dsTaint.addTaint(unscaledVal.dsTaint);
        dsTaint.addTaint(scale);
        dsTaint.addTaint(mc.dsTaint);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "5359C9BE484C4A97ECD231D115B1BCDB", hash_generated_method = "CC9FCC4BA9FB57A94093A5D711329B23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(int val) {
        this(val,0);
        dsTaint.addTaint(val);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "919820155B3DF9AD0A8E776AC27BF824", hash_generated_method = "8D79EA34ABE59AAB388A8A2B57D7ABB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(int val, MathContext mc) {
        this(val,0);
        dsTaint.addTaint(val);
        dsTaint.addTaint(mc.dsTaint);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "3B8082CDF108D6321820C9FA6A6A1D42", hash_generated_method = "5A6DC1856A69B083B58512FB03A3B70A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(long val) {
        this(val,0);
        dsTaint.addTaint(val);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "E0851629E0BD0FDB6233816479A7E4A8", hash_generated_method = "2C4E34BEC3386359A148573507C714D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal(long val, MathContext mc) {
        this(val);
        dsTaint.addTaint(val);
        dsTaint.addTaint(mc.dsTaint);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "F9892CC1443390F81D4FBFF3F20214AD", hash_generated_method = "5CE479A48454C88ED412F5E65ACE7121")
    public static BigDecimal valueOf(long unscaledVal, int scale) {
        if (scale == 0) {
            return valueOf(unscaledVal);
        }
        if ((unscaledVal == 0) && (scale >= 0)
                && (scale < ZERO_SCALED_BY.length)) {
            return ZERO_SCALED_BY[scale];
        }
        return new BigDecimal(unscaledVal, scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "6005B27E24A666ABF80A39B1F52409D2", hash_generated_method = "004BECF32C4D7725B75CD1E903B7E085")
    public static BigDecimal valueOf(long unscaledVal) {
        if ((unscaledVal >= 0) && (unscaledVal < BI_SCALED_BY_ZERO_LENGTH)) {
            return BI_SCALED_BY_ZERO[(int)unscaledVal];
        }
        return new BigDecimal(unscaledVal,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "10A95FF55B9E585002402901CCF62557", hash_generated_method = "C311EE40996D59E17B3F55D313EE4358")
    public static BigDecimal valueOf(double val) {
        if (Double.isInfinite(val) || Double.isNaN(val)) {
            throw new NumberFormatException("Infinity or NaN: " + val);
        }
        return new BigDecimal(Double.toString(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "1DCD141A7D54B6C70CB155CC6BA0AB13", hash_generated_method = "991D82EF5EA2001BE49490FD27C94998")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal add(BigDecimal augend) {
        dsTaint.addTaint(augend.dsTaint);
        int diffScale;
        diffScale = this.scale - augend.scale;
        {
            boolean var3ACAB80A5F99B906541DA9D0E446A470_1038534318 = (this.isZero());
            {
                {
                    boolean varB1908C261B547BD48CB51E1D5EF611A0_1690825305 = (augend.isZero());
                } //End collapsed parenthetic
            } //End block
            {
                boolean var133F1DCA67F284EB5AB919CE41BBA5B6_1990103437 = (augend.isZero());
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            {
                boolean varD111D3273CD5455867ABFC03E36CFA28_1528122354 = (Math.max(this.bitLength, augend.bitLength) + 1 < 64);
                {
                    BigDecimal var358BBC85340DF151830BF353CB5A5DB0_392576974 = (valueOf(this.smallValue + augend.smallValue, this.scale));
                } //End block
            } //End collapsed parenthetic
            BigDecimal var897E19791AB944D5EBED3A0E324D2FBD_1542334332 = (new BigDecimal(this.getUnscaledValue().add(augend.getUnscaledValue()), this.scale));
        } //End block
        {
            BigDecimal varF3070E92D9CBAC704F16DD821FEA66AE_2122470539 = (addAndMult10(this, augend, diffScale));
        } //End block
        {
            BigDecimal var9B335C19A37C46B6693055E1631E9CA6_1244261095 = (addAndMult10(augend, this, -diffScale));
        } //End block
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.122 -0400", hash_original_method = "A46415AE823E313D5E8C5AE45376215F", hash_generated_method = "80370484F8CE3F1AD90C7B721552903B")
    private static BigDecimal addAndMult10(BigDecimal thisValue,BigDecimal augend, int diffScale) {
        if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                Math.max(thisValue.bitLength,augend.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale])+1<64) {
            return valueOf(thisValue.smallValue+augend.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale],thisValue.scale);
        } else {
            BigInt bi = Multiplication.multiplyByTenPow(augend.getUnscaledValue(),diffScale).getBigInt();
            bi.add(thisValue.getUnscaledValue().getBigInt());
            return new BigDecimal(new BigInteger(bi), thisValue.scale);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.123 -0400", hash_original_method = "37BDD6EE07613654EB8729406017A0AF", hash_generated_method = "4FD1FBAA2D699260ACD179BFFF0B1760")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal add(BigDecimal augend, MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        dsTaint.addTaint(augend.dsTaint);
        BigDecimal larger;
        BigDecimal smaller;
        BigInteger tempBI;
        long diffScale;
        diffScale = (long)this.scale - augend.scale;
        int largerSignum;
        {
            boolean varF966BD50F4EF9C0D05117401635B161E_847925338 = ((augend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0));
            {
                BigDecimal var748D399C9F90F740EACC00ED8D5CBAA7_1261873043 = (add(augend).round(mc));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9070081FF1C89B57CAC464C53A5B31A2_1957376774 = (this.approxPrecision() < diffScale - 1);
            {
                larger = augend;
                smaller = this;
            } //End block
            {
                boolean varA5DA4849944CED3DDED10285985020BE_1345771353 = (augend.approxPrecision() < -diffScale - 1);
                {
                    larger = this;
                    smaller = augend;
                } //End block
                {
                    BigDecimal var4BF15B5E4E2148F7137714B2A3E5BBC3_690776618 = (add(augend).round(mc));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var8AFB7E1F21C67DCCAA005AEF04A9DB11_1829101239 = (mc.getPrecision() >= larger.approxPrecision());
            {
                BigDecimal var748D399C9F90F740EACC00ED8D5CBAA7_1027249300 = (add(augend).round(mc));
            } //End block
        } //End collapsed parenthetic
        largerSignum = larger.signum();
        {
            boolean varFDAEFA28D5E9E9B77BEF39981CC0842F_20218903 = (largerSignum == smaller.signum());
            {
                tempBI = Multiplication.multiplyByPositiveInt(larger.getUnscaledValue(),10)
            .add(BigInteger.valueOf(largerSignum));
            } //End block
            {
                tempBI = larger.getUnscaledValue().subtract(
                    BigInteger.valueOf(largerSignum));
                tempBI = Multiplication.multiplyByPositiveInt(tempBI,10)
            .add(BigInteger.valueOf(largerSignum * 9));
            } //End block
        } //End collapsed parenthetic
        larger = new BigDecimal(tempBI, larger.scale + 1);
        BigDecimal var41D6E4AC0E6185C36B06A2186B57AA25_988833521 = (larger.round(mc));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.123 -0400", hash_original_method = "463B27AE9A4331C20782D4CCC2226F12", hash_generated_method = "83CAE790C064D25EF0B811DF33FD2D6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal subtract(BigDecimal subtrahend) {
        dsTaint.addTaint(subtrahend.dsTaint);
        int diffScale;
        diffScale = this.scale - subtrahend.scale;
        {
            boolean var3ACAB80A5F99B906541DA9D0E446A470_202954175 = (this.isZero());
            {
                {
                    BigDecimal var7DD6D2514AA5BB40228ED312241E7B5A_1656623357 = (subtrahend.negate());
                } //End block
                {
                    boolean varD03C6CECC51E3DE3442E3774C1567DCF_1904102326 = (subtrahend.isZero());
                } //End collapsed parenthetic
            } //End block
            {
                boolean var9EB1DAC8BC084CCA52BBCF84A22F0C39_1346437526 = (subtrahend.isZero());
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            {
                boolean var716C9DB8DD66F0858D9B5D3E8474C979_2068621518 = (Math.max(this.bitLength, subtrahend.bitLength) + 1 < 64);
                {
                    BigDecimal var35D7590872D685E24665EEC21692FFDF_1524219096 = (valueOf(this.smallValue - subtrahend.smallValue,this.scale));
                } //End block
            } //End collapsed parenthetic
            BigDecimal varDEA6CD576FC41DB7DA6E17CFE1298099_112573694 = (new BigDecimal(this.getUnscaledValue().subtract(subtrahend.getUnscaledValue()), this.scale));
        } //End block
        {
            {
                boolean var920C6D472A61AE7DE113537D4CAEABA3_775615055 = (diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength,subtrahend.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale])+1<64);
                {
                    BigDecimal var25B92EC269731540B6A9C916EF19EF0A_1900321555 = (valueOf(this.smallValue-subtrahend.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale],this.scale));
                } //End block
            } //End collapsed parenthetic
            BigDecimal varC744F55C91A49C9853282476BF7EF1A4_1469349741 = (new BigDecimal(this.getUnscaledValue().subtract(
                    Multiplication.multiplyByTenPow(subtrahend.getUnscaledValue(),diffScale)), this.scale));
        } //End block
        {
            diffScale = -diffScale;
            {
                boolean var71AEEAE804686FEE863217A58EF3D39E_932633314 = (diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale],subtrahend.bitLength)+1<64);
                {
                    BigDecimal var2709FDC566CFBB9AED7E56ADA0E5382C_1267007295 = (valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale]-subtrahend.smallValue,subtrahend.scale));
                } //End block
            } //End collapsed parenthetic
            BigDecimal var8360596AB1676B7452AF9AE39DDB5907_1905507981 = (new BigDecimal(Multiplication.multiplyByTenPow(this.getUnscaledValue(),diffScale)
            .subtract(subtrahend.getUnscaledValue()), subtrahend.scale));
        } //End block
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.123 -0400", hash_original_method = "427D658D2E18BC359A41906DA92107B2", hash_generated_method = "1A5345BCF22D03E6F425613630B6316E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal subtract(BigDecimal subtrahend, MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        dsTaint.addTaint(subtrahend.dsTaint);
        long diffScale;
        diffScale = subtrahend.scale - (long)this.scale;
        int thisSignum;
        BigDecimal leftOperand;
        BigInteger tempBI;
        {
            boolean varFD92EBCDA78B63D052A84F60541F229A_1974740703 = ((subtrahend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0));
            {
                BigDecimal var6AF516DE63D993B52275617076029D0B_218521525 = (subtract(subtrahend).round(mc));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var89DC8760BF7238399EC83E1D522E73AD_867610146 = (subtrahend.approxPrecision() < diffScale - 1);
            {
                {
                    boolean varD9AB7589FCBDAD8F096FC84E02A2A50D_1740122681 = (mc.getPrecision() < this.approxPrecision());
                    {
                        thisSignum = this.signum();
                        {
                            boolean var62FB1B54913969022251702D5200468F_2108716193 = (thisSignum != subtrahend.signum());
                            {
                                tempBI = Multiplication.multiplyByPositiveInt(this.getUnscaledValue(), 10)
                    .add(BigInteger.valueOf(thisSignum));
                            } //End block
                            {
                                tempBI = this.getUnscaledValue().subtract(BigInteger.valueOf(thisSignum));
                                tempBI = Multiplication.multiplyByPositiveInt(tempBI, 10)
                    .add(BigInteger.valueOf(thisSignum * 9));
                            } //End block
                        } //End collapsed parenthetic
                        leftOperand = new BigDecimal(tempBI, this.scale + 1);
                        BigDecimal var91A552369D77AD97FDEE3B58778085C6_1343930238 = (leftOperand.round(mc));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        BigDecimal var6024E2E01FC143DD74EB2F9BDF2640AE_478343144 = (subtract(subtrahend).round(mc));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.124 -0400", hash_original_method = "0CD1948BD2366020AE6A84C7902D73D6", hash_generated_method = "692A904DFBA2AF574E0C9401D8E7B01F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal multiply(BigDecimal multiplicand) {
        dsTaint.addTaint(multiplicand.dsTaint);
        long newScale;
        newScale = (long)this.scale + multiplicand.scale;
        {
            boolean var94085E900CFE8C8A5270601770788621_1501274755 = ((this.isZero()) || (multiplicand.isZero()));
            {
                BigDecimal var8CAF19FCBD3DCCDE23A5D34275379796_1499817094 = (zeroScaledBy(newScale));
            } //End block
        } //End collapsed parenthetic
        {
            BigDecimal varFEE544F5E982D4FCF97E36A1D8B31847_1269517010 = (valueOf(this.smallValue*multiplicand.smallValue, safeLongToInt(newScale)));
        } //End block
        BigDecimal var79F7D6A3C798B34BEEEDB9B1F6375C6F_440931739 = (new BigDecimal(this.getUnscaledValue().multiply(
                multiplicand.getUnscaledValue()), safeLongToInt(newScale)));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //long newScale = (long)this.scale + multiplicand.scale;
        //if ((this.isZero()) || (multiplicand.isZero())) {
            //return zeroScaledBy(newScale);
        //}
        //if(this.bitLength + multiplicand.bitLength < 64) {
            //return valueOf(this.smallValue*multiplicand.smallValue, safeLongToInt(newScale));
        //}
        //return new BigDecimal(this.getUnscaledValue().multiply(
                //multiplicand.getUnscaledValue()), safeLongToInt(newScale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.124 -0400", hash_original_method = "C6525DC236CD6C9B7DA82BBF840C4183", hash_generated_method = "E130BC72B831E7AEC2A832C3D7415E07")
    @DSModeled(DSC.SAFE)
    public BigDecimal multiply(BigDecimal multiplicand, MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        dsTaint.addTaint(multiplicand.dsTaint);
        BigDecimal result;
        result = multiply(multiplicand);
        result.inplaceRound(mc);
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigDecimal result = multiply(multiplicand);
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.124 -0400", hash_original_method = "462A8C7DE00EC7C78FAA3F28B925453C", hash_generated_method = "01ED8A503CF2D9C96311DAF12A901402")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(roundingMode);
        dsTaint.addTaint(divisor.dsTaint);
        BigDecimal var815FD20EEED520565D82EAF32364F5A7_504462327 = (divide(divisor, scale, RoundingMode.valueOf(roundingMode)));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.124 -0400", hash_original_method = "CAF40474AE4670E1A6482892323F28CB", hash_generated_method = "B5D30B97D1D894A6512A42C2D85E4A04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(roundingMode.dsTaint);
        dsTaint.addTaint(divisor.dsTaint);
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        {
            boolean var16B71EEA539968D0D6443F65DF69A37A_1470275740 = (divisor.isZero());
            if(DroidSafeAndroidRuntime.control) {
                throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        long diffScale;
        diffScale = ((long)this.scale - divisor.scale) - scale;
        {
            {
                BigDecimal var5B3AFADDB2E7C4CE86B420BE7978931A_2082936643 = (dividePrimitiveLongs(this.smallValue,
                        divisor.smallValue,
                        scale,
                        roundingMode ));
            } //End block
            {
                {
                    BigDecimal varB57E16FE8281CECDF28ABAE9CF5694D6_747241244 = (dividePrimitiveLongs(this.smallValue,
                            divisor.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],
                            scale,
                            roundingMode));
                } //End block
            } //End block
            {
                {
                    BigDecimal var5405E5C834BD55B9747B8EFABA66B081_1293965421 = (dividePrimitiveLongs(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale],
                            divisor.smallValue,
                            scale,
                            roundingMode));
                } //End block
            } //End block
        } //End block
        BigInteger scaledDividend;
        scaledDividend = this.getUnscaledValue();
        BigInteger scaledDivisor;
        scaledDivisor = divisor.getUnscaledValue();
        {
            scaledDivisor = Multiplication.multiplyByTenPow(scaledDivisor, (int)diffScale);
        } //End block
        {
            scaledDividend  = Multiplication.multiplyByTenPow(scaledDividend, (int)-diffScale);
        } //End block
        BigDecimal varC529DC50EA59D84B3D4A3CDAB01AEC8F_290138289 = (divideBigIntegers(scaledDividend, scaledDivisor, scale, roundingMode));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.124 -0400", hash_original_method = "5942F5A028CB6724F6727335EEB4228B", hash_generated_method = "D60D2CAC36D3B6E0A3350629E50B8F87")
    private static BigDecimal divideBigIntegers(BigInteger scaledDividend, BigInteger scaledDivisor, int scale, RoundingMode roundingMode) {
        BigInteger[] quotAndRem = scaledDividend.divideAndRemainder(scaledDivisor);
        BigInteger quotient = quotAndRem[0];
        BigInteger remainder = quotAndRem[1];
        if (remainder.signum() == 0) {
            return new BigDecimal(quotient, scale);
        }
        int sign = scaledDividend.signum() * scaledDivisor.signum();
        int compRem;
        if(scaledDivisor.bitLength() < 63) { 
            long rem = remainder.longValue();
            long divisor = scaledDivisor.longValue();
            compRem = longCompareTo(Math.abs(rem) * 2,Math.abs(divisor));
            compRem = roundingBehavior(quotient.testBit(0) ? 1 : 0,
                    sign * (5 + compRem), roundingMode);
        } else {
            compRem = remainder.abs().shiftLeftOneBit().compareTo(scaledDivisor.abs());
            compRem = roundingBehavior(quotient.testBit(0) ? 1 : 0,
                    sign * (5 + compRem), roundingMode);
        }
        if (compRem != 0) {
            if(quotient.bitLength() < 63) {
                return valueOf(quotient.longValue() + compRem,scale);
            }
            quotient = quotient.add(BigInteger.valueOf(compRem));
            return new BigDecimal(quotient, scale);
        }
        return new BigDecimal(quotient, scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.124 -0400", hash_original_method = "7B0F2D11454582168AA71FF633AE192E", hash_generated_method = "31DCA178BEBD4B5B51E2F5F3514E3C67")
    private static BigDecimal dividePrimitiveLongs(long scaledDividend, long scaledDivisor, int scale, RoundingMode roundingMode) {
        long quotient = scaledDividend / scaledDivisor;
        long remainder = scaledDividend % scaledDivisor;
        int sign = Long.signum( scaledDividend ) * Long.signum( scaledDivisor );
        if (remainder != 0) {
            int compRem;                                      
            compRem = longCompareTo(Math.abs(remainder) * 2,Math.abs(scaledDivisor));
            quotient += roundingBehavior(((int)quotient) & 1,
                    sign * (5 + compRem),
                    roundingMode);
        }
        return valueOf(quotient, scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.125 -0400", hash_original_method = "2C6660A6ECCA62927D6A6B71E8D4804F", hash_generated_method = "E4A283E3F17DFAAC9AEC4354D78477BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal divide(BigDecimal divisor, int roundingMode) {
        dsTaint.addTaint(roundingMode);
        dsTaint.addTaint(divisor.dsTaint);
        BigDecimal var815FD20EEED520565D82EAF32364F5A7_1868723236 = (divide(divisor, scale, RoundingMode.valueOf(roundingMode)));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.125 -0400", hash_original_method = "5F1D784ACEFAF8C3A3D46632D71C7A92", hash_generated_method = "E733629631C37D5E2CBEF16CD858B78D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
        dsTaint.addTaint(roundingMode.dsTaint);
        dsTaint.addTaint(divisor.dsTaint);
        BigDecimal var0331CD144D567F2E7225967B63F8C7AB_1624548028 = (divide(divisor, scale, roundingMode));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return divide(divisor, scale, roundingMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.125 -0400", hash_original_method = "A7E2E0DD5FAFAFB93C0707787850F19F", hash_generated_method = "96BAC37D1487335889565DB9177A9378")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal divide(BigDecimal divisor) {
        dsTaint.addTaint(divisor.dsTaint);
        BigInteger p;
        p = this.getUnscaledValue();
        BigInteger q;
        q = divisor.getUnscaledValue();
        BigInteger gcd;
        BigInteger quotAndRem[];
        long diffScale;
        diffScale = (long)scale - divisor.scale;
        int newScale;
        int k;
        int l;
        l = 0;
        int i;
        i = 1;
        int lastPow;
        lastPow = FIVE_POW.length - 1;
        {
            boolean var16B71EEA539968D0D6443F65DF69A37A_1919789927 = (divisor.isZero());
            if(DroidSafeAndroidRuntime.control) {
                throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB2E2B4410DE8AB2A2A71DAF68472D9F8_1438506260 = (p.signum() == 0);
            {
                BigDecimal var256B83585D7CD662FD6761F24E4FF43A_645878633 = (zeroScaledBy(diffScale));
            } //End block
        } //End collapsed parenthetic
        gcd = p.gcd(q);
        p = p.divide(gcd);
        q = q.divide(gcd);
        k = q.getLowestSetBit();
        q = q.shiftRight(k);
        {
            quotAndRem = q.divideAndRemainder(FIVE_POW[i]);
            {
                boolean var56D8F8621CBF2F8B7CF2D0AA5E63D82E_1693548159 = (quotAndRem[1].signum() == 0);
                {
                    l += i;
                    {
                        i++;
                    } //End block
                    q = quotAndRem[0];
                } //End block
                {
                    i = 1;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var1CE2A649CF548A0B382B8CA8D0531C0B_38349635 = (!q.abs().equals(BigInteger.ONE));
            if(DroidSafeAndroidRuntime.control) {
                throw new ArithmeticException("Non-terminating decimal expansion; no exact representable decimal result");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1BE70AB41E4F878C9E96CBD045BE82F6_264513991 = (q.signum() < 0);
            {
                p = p.negate();
            } //End block
        } //End collapsed parenthetic
        newScale = safeLongToInt(diffScale + Math.max(k, l));
        i = k - l;
        p = (i > 0) ? Multiplication.multiplyByFivePow(p, i)
        : p.shiftLeft(-i);
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.126 -0400", hash_original_method = "E69AD17C16131904FF2F859BB6B8C3E0", hash_generated_method = "BBCF74C5E7CF18513EC0A49713DB51AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal divide(BigDecimal divisor, MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        dsTaint.addTaint(divisor.dsTaint);
        long trailingZeros;
        trailingZeros = mc.getPrecision() + 2L
                + divisor.approxPrecision() - approxPrecision();
        long diffScale;
        diffScale = (long)scale - divisor.scale;
        long newScale;
        newScale = diffScale;
        int compRem;
        int i;
        i = 1;
        int lastPow;
        lastPow = TEN_POW.length - 1;
        BigInteger integerQuot;
        BigInteger quotAndRem[] = {getUnscaledValue()};
        {
            boolean var1683CA06D9CD829DE790F5F76B24F12F_1566877169 = ((mc.getPrecision() == 0) || (this.isZero())
        || (divisor.isZero()));
            {
                BigDecimal varE2CEBDB05CF97982BA6530A56CBA428A_170089742 = (this.divide(divisor));
            } //End block
        } //End collapsed parenthetic
        {
            quotAndRem[0] = getUnscaledValue().multiply( Multiplication.powerOf10(trailingZeros) );
            newScale += trailingZeros;
        } //End block
        quotAndRem = quotAndRem[0].divideAndRemainder( divisor.getUnscaledValue() );
        integerQuot = quotAndRem[0];
        {
            boolean var519F85BAAFA83462D286D0E95FC021F7_753919105 = (quotAndRem[1].signum() != 0);
            {
                compRem = quotAndRem[1].shiftLeftOneBit().compareTo( divisor.getUnscaledValue() );
                integerQuot = integerQuot.multiply(BigInteger.TEN)
            .add(BigInteger.valueOf(quotAndRem[0].signum() * (5 + compRem)));
                newScale++;
            } //End block
            {
                {
                    boolean varD5D87A190E12C2B6C000E3A9EE8BEC7C_1120618597 = (!integerQuot.testBit(0));
                    {
                        quotAndRem = integerQuot.divideAndRemainder(TEN_POW[i]);
                        {
                            boolean var3E10FD41A4FC7BC4D742233E45936456_972864602 = ((quotAndRem[1].signum() == 0)
                        && (newScale - i >= diffScale));
                            {
                                newScale -= i;
                                {
                                    i++;
                                } //End block
                                integerQuot = quotAndRem[0];
                            } //End block
                            {
                                i = 1;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        BigDecimal varF95CBC69EB284309981C7DFF71FFFBFF_1369228234 = (new BigDecimal(integerQuot, safeLongToInt(newScale), mc));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.126 -0400", hash_original_method = "370FC7E5A1C86319865302EB832BE460", hash_generated_method = "89DC48C1A2FE2F7DA1C8896DD38EC71E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal divideToIntegralValue(BigDecimal divisor) {
        dsTaint.addTaint(divisor.dsTaint);
        BigInteger integralValue;
        BigInteger powerOfTen;
        BigInteger quotAndRem[];
        long newScale;
        newScale = (long)this.scale - divisor.scale;
        long tempScale;
        tempScale = 0;
        int i;
        i = 1;
        int lastPow;
        lastPow = TEN_POW.length - 1;
        {
            boolean var16B71EEA539968D0D6443F65DF69A37A_1942352517 = (divisor.isZero());
            if(DroidSafeAndroidRuntime.control) {
                throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var43466425044C6001C715D4744A155718_682265057 = ((divisor.approxPrecision() + newScale > this.approxPrecision() + 1L)
        || (this.isZero()));
            {
                integralValue = BigInteger.ZERO;
            } //End block
            {
                integralValue = getUnscaledValue().divide( divisor.getUnscaledValue() );
            } //End block
            {
                powerOfTen = Multiplication.powerOf10(newScale);
                integralValue = getUnscaledValue().divide( divisor.getUnscaledValue().multiply(powerOfTen) );
                integralValue = integralValue.multiply(powerOfTen);
            } //End block
            {
                powerOfTen = Multiplication.powerOf10(-newScale);
                integralValue = getUnscaledValue().multiply(powerOfTen).divide( divisor.getUnscaledValue() );
                {
                    boolean varB25FF58A943269DCC68D0EBDAAE99805_688150653 = (!integralValue.testBit(0));
                    {
                        quotAndRem = integralValue.divideAndRemainder(TEN_POW[i]);
                        {
                            boolean varCAFFF7801493718308EEBDB0CF811D99_1735385080 = ((quotAndRem[1].signum() == 0)
                        && (tempScale - i >= newScale));
                            {
                                tempScale -= i;
                                {
                                    i++;
                                } //End block
                                integralValue = quotAndRem[0];
                            } //End block
                            {
                                i = 1;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                newScale = tempScale;
            } //End block
        } //End collapsed parenthetic
        BigDecimal var10D38FAF5BA164031E84B3855AE1D339_849658070 = (((integralValue.signum() == 0)
        ? zeroScaledBy(newScale)
                : new BigDecimal(integralValue, safeLongToInt(newScale)))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.127 -0400", hash_original_method = "15ECC758BA9BF5EB2D64CC984DE4A4C9", hash_generated_method = "7DFD3764658A956F26D81A5E266E5786")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal divideToIntegralValue(BigDecimal divisor, MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        dsTaint.addTaint(divisor.dsTaint);
        int mcPrecision;
        mcPrecision = mc.getPrecision();
        int diffPrecision;
        diffPrecision = this.precision() - divisor.precision();
        int lastPow;
        lastPow = TEN_POW.length - 1;
        long diffScale;
        diffScale = (long)this.scale - divisor.scale;
        long newScale;
        newScale = diffScale;
        long quotPrecision;
        quotPrecision = diffPrecision - diffScale + 1;
        BigInteger quotAndRem[];
        quotAndRem = new BigInteger[2];
        {
            boolean var78FFC807FB0EE7608CAD1113F89EFF01_30810793 = ((mcPrecision == 0) || (this.isZero()) || (divisor.isZero()));
            {
                BigDecimal var7FC2B6D49D7D189EBF2DD81976422FB8_51015970 = (this.divideToIntegralValue(divisor));
            } //End block
        } //End collapsed parenthetic
        {
            quotAndRem[0] = BigInteger.ZERO;
        } //End block
        {
            quotAndRem[0] = this.getUnscaledValue().divide( divisor.getUnscaledValue() );
        } //End block
        {
            quotAndRem[0] = this.getUnscaledValue().divide(
                    divisor.getUnscaledValue().multiply(Multiplication.powerOf10(diffScale)) );
            newScale = Math.min(diffScale, Math.max(mcPrecision - quotPrecision + 1, 0));
            quotAndRem[0] = quotAndRem[0].multiply(Multiplication.powerOf10(newScale));
        } //End block
        {
            long exp;
            exp = Math.min(-diffScale, Math.max((long)mcPrecision - diffPrecision, 0));
            long compRemDiv;
            quotAndRem = this.getUnscaledValue().multiply(Multiplication.powerOf10(exp)).
                    divideAndRemainder(divisor.getUnscaledValue());
            newScale += exp;
            exp = -newScale;
            {
                boolean var69073325A671CB393E6130C2ECC3A3F2_606306122 = ((quotAndRem[1].signum() != 0) && (exp > 0));
                {
                    compRemDiv = (new BigDecimal(quotAndRem[1])).precision()
                + exp - divisor.precision();
                    {
                        quotAndRem[1] = quotAndRem[1].multiply(Multiplication.powerOf10(exp)).
                            divide(divisor.getUnscaledValue());
                        compRemDiv = Math.abs(quotAndRem[1].signum());
                    } //End block
                    if(DroidSafeAndroidRuntime.control) {
                        throw new ArithmeticException("Division impossible");
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varF8DE899E76CEFE3C6AC3D8F3E0A27654_271198960 = (quotAndRem[0].signum() == 0);
            {
                BigDecimal var256B83585D7CD662FD6761F24E4FF43A_973572947 = (zeroScaledBy(diffScale));
            } //End block
        } //End collapsed parenthetic
        BigInteger strippedBI;
        strippedBI = quotAndRem[0];
        BigDecimal integralValue;
        integralValue = new BigDecimal(quotAndRem[0]);
        long resultPrecision;
        resultPrecision = integralValue.precision();
        int i;
        i = 1;
        {
            boolean varFEBA48CABF974070FADE4D4043F8A64F_1935603078 = (!strippedBI.testBit(0));
            {
                quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
                {
                    boolean varA720D7C810B13E104AD0745BE1B37072_508321107 = ((quotAndRem[1].signum() == 0) &&
                    ((resultPrecision - i >= mcPrecision)
                    || (newScale - i >= diffScale)));
                    {
                        resultPrecision -= i;
                        newScale -= i;
                        {
                            i++;
                        } //End block
                        strippedBI = quotAndRem[0];
                    } //End block
                    {
                        i = 1;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        if(DroidSafeAndroidRuntime.control) {
            throw new ArithmeticException("Division impossible");
        } //End block
        integralValue.scale = safeLongToInt(newScale);
        integralValue.setUnscaledValue(strippedBI);
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.127 -0400", hash_original_method = "EBDBD1FB251B2EF1CF76CA97862E098F", hash_generated_method = "8EE804F770F09F21FC8B34F240A9C873")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal remainder(BigDecimal divisor) {
        dsTaint.addTaint(divisor.dsTaint);
        BigDecimal var346BA0E5D5AA16E263DEB551494C2576_996796247 = (divideAndRemainder(divisor)[1]);
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor)[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.127 -0400", hash_original_method = "B5D8082AFBB8A8B7919238963079BE8E", hash_generated_method = "AAF76D517815DCDA07FED3739DF0DA32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal remainder(BigDecimal divisor, MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        dsTaint.addTaint(divisor.dsTaint);
        BigDecimal var67C6FE3BA6F0312F442C49E55F425CFE_57688925 = (divideAndRemainder(divisor, mc)[1]);
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor, mc)[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.127 -0400", hash_original_method = "078854E5024F03E2C96ABDC15A98EC28", hash_generated_method = "A47DEE4D8B5064FE945B3189A6DCB3FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal[] divideAndRemainder(BigDecimal divisor) {
        dsTaint.addTaint(divisor.dsTaint);
        BigDecimal quotAndRem[];
        quotAndRem = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        return (BigDecimal[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.127 -0400", hash_original_method = "36D2BD3305B7DD5EA1226F88EE4D6B60", hash_generated_method = "D3B9675B01C78608F368AD6BD3A4ABAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal[] divideAndRemainder(BigDecimal divisor, MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        dsTaint.addTaint(divisor.dsTaint);
        BigDecimal quotAndRem[];
        quotAndRem = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        return (BigDecimal[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.128 -0400", hash_original_method = "0BA2A5CD46D450D69AC19365E08D7C5C", hash_generated_method = "74CA53D7DC010BFBE41A0B25915DFBE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal pow(int n) {
        dsTaint.addTaint(n);
        if(DroidSafeAndroidRuntime.control) {
            throw new ArithmeticException("Invalid operation");
        } //End block
        long newScale;
        newScale = scale * (long)n;
        {
            boolean var2CC22727CE5D95FFA6F7D70A538860F0_1513567091 = (isZero());
            Object varA4C895BB668F35A1A27222BD5B8A11EF_908718014 = (zeroScaledBy(newScale));
            Object var2AB9651FC5145960571EFDD8DB99EFF3_34127046 = (new BigDecimal(getUnscaledValue().pow(n), safeLongToInt(newScale)));
        } //End flattened ternary
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (n == 0) {
            //return ONE;
        //}
        //if ((n < 0) || (n > 999999999)) {
            //throw new ArithmeticException("Invalid operation");
        //}
        //long newScale = scale * (long)n;
        //return isZero() ? zeroScaledBy(newScale)
                //: new BigDecimal(getUnscaledValue().pow(n), safeLongToInt(newScale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.128 -0400", hash_original_method = "C8938AEDE89231C5AAB8CE41C7A1DE59", hash_generated_method = "15F1AFE4CC2921E3B52E4115BA66B845")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal pow(int n, MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        dsTaint.addTaint(n);
        int m;
        m = Math.abs(n);
        int mcPrecision;
        mcPrecision = mc.getPrecision();
        int elength;
        elength = (int)Math.log10(m) + 1;
        int oneBitMask;
        BigDecimal accum;
        MathContext newPrecision;
        newPrecision = mc;
        {
            boolean varBF14C2086BC4C6404D3417B69099E0C2_907535406 = ((n == 0) || ((isZero()) && (n > 0)));
            {
                BigDecimal varAEF84AD3584DFB9FF8209E3223752570_463670215 = (pow(n));
            } //End block
        } //End collapsed parenthetic
        if(DroidSafeAndroidRuntime.control) {
            throw new ArithmeticException("Invalid operation");
        } //End block
        {
            newPrecision = new MathContext( mcPrecision + elength + 1,
                    mc.getRoundingMode());
        } //End block
        accum = round(newPrecision);
        oneBitMask = Integer.highestOneBit(m) >> 1;
        {
            accum = accum.multiply(accum, newPrecision);
            {
                accum = accum.multiply(this, newPrecision);
            } //End block
            oneBitMask >>= 1;
        } //End block
        {
            accum = ONE.divide(accum, newPrecision);
        } //End block
        accum.inplaceRound(mc);
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.128 -0400", hash_original_method = "DF1CB3D65F2CAE136A2978BF9C5604B4", hash_generated_method = "375020879A31918111C1637A5D8BDE40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal abs() {
        BigDecimal var9157378BEFAC97F4EA5AEB636E2D9E62_133741100 = (((signum() < 0) ? negate() : this)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ((signum() < 0) ? negate() : this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.128 -0400", hash_original_method = "BC934B9214C4819E6720F567E9C870B9", hash_generated_method = "6A3EA79557B3E585F789656866D806CA")
    @DSModeled(DSC.SAFE)
    public BigDecimal abs(MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        BigDecimal result;
        result = abs();
        result.inplaceRound(mc);
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigDecimal result = abs();
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.128 -0400", hash_original_method = "434D4E2CBF9E3CBC75126AF4586B2CF0", hash_generated_method = "379A487EE795D48373DB631CDFD3853F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal negate() {
        {
            BigDecimal var59DA19F6E09C82A73109D4AB0E85C582_802948516 = (valueOf(-smallValue,scale));
        } //End block
        BigDecimal var99491906B43E9C73903130D3AF4ABD57_1316829208 = (new BigDecimal(getUnscaledValue().negate(), scale));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if(bitLength < 63 || (bitLength == 63 && smallValue!=Long.MIN_VALUE)) {
            //return valueOf(-smallValue,scale);
        //}
        //return new BigDecimal(getUnscaledValue().negate(), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.128 -0400", hash_original_method = "1D24791EE4ADD6E04558F8C92319E898", hash_generated_method = "70E7972B1E7FE8C7B780A4E3CC4FED6A")
    @DSModeled(DSC.SAFE)
    public BigDecimal negate(MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        BigDecimal result;
        result = negate();
        result.inplaceRound(mc);
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigDecimal result = negate();
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.128 -0400", hash_original_method = "E5A0BEEECFDAB0EB24F23ED92FDA1EE0", hash_generated_method = "590C5BEBD414E5424F9C65C0C8338F7E")
    @DSModeled(DSC.SAFE)
    public BigDecimal plus() {
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.128 -0400", hash_original_method = "06DE611812CE14E42B61206CBE361795", hash_generated_method = "997862C027FE1B16FF705DD8C6B0729D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal plus(MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        BigDecimal varF1072B561EDA0CA631BD9391B388E7A5_1099244068 = (round(mc));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return round(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.128 -0400", hash_original_method = "CA4E5917AFEF32459FAB7B79AFDA8BD4", hash_generated_method = "F5AE4DC9BF7E4B6845965DFCCEFF6A3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int signum() {
        {
            int varF032537E263740DA95D3B45D7C943C95_1106058089 = (Long.signum( this.smallValue ));
        } //End block
        int varF8C894AC9EB5FE4FA16D557236C882F9_1238350870 = (getUnscaledValue().signum());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if( bitLength < 64) {
            //return Long.signum( this.smallValue );
        //}
        //return getUnscaledValue().signum();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.128 -0400", hash_original_method = "F3E74BAAEB162D78F28E445308393563", hash_generated_method = "C93FDFD1CA98248A45E3829525D714AD")
    @DSModeled(DSC.SAFE)
    private boolean isZero() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return bitLength == 0 && this.smallValue != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.129 -0400", hash_original_method = "5F6F67A9AE4AEECC5BD64D7ACC145B6A", hash_generated_method = "E0F8990F4AEB7F2FF951455F5FD49B27")
    @DSModeled(DSC.SAFE)
    public int scale() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.129 -0400", hash_original_method = "6DFBDD0E771CAF738A0C801E888E1E3B", hash_generated_method = "7D5330C8E7236322DE7C43059BA53341")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int precision() {
        int bitLength;
        bitLength = this.bitLength;
        {
            precision = 1;
        } //End block
        {
            precision = decimalDigitsInLong(smallValue);
        } //End block
        {
            int decimalDigits;
            decimalDigits = 1 + (int) ((bitLength - 1) * LOG10_2);
            {
                boolean var8743B4113D7AA0C9B3797D73894FAAF3_1910512630 = (getUnscaledValue().divide(Multiplication.powerOf10(decimalDigits)).signum() != 0);
                {
                    decimalDigits++;
                } //End block
            } //End collapsed parenthetic
            precision = decimalDigits;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (precision > 0) {
            //return precision;
        //}
        //int bitLength = this.bitLength;
        //if (bitLength == 0) {
            //precision = 1;
        //} else if (bitLength < 64) {
            //precision = decimalDigitsInLong(smallValue);
        //} else {
            //int decimalDigits = 1 + (int) ((bitLength - 1) * LOG10_2);
            //if (getUnscaledValue().divide(Multiplication.powerOf10(decimalDigits)).signum() != 0) {
                //decimalDigits++;
            //}
            //precision = decimalDigits;
        //}
        //return precision;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.129 -0400", hash_original_method = "EAD040D94F5F819E555B537F69E87C66", hash_generated_method = "83719F66BC71957983D4E04AD258DA81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int decimalDigitsInLong(long value) {
        dsTaint.addTaint(value);
        {
            int index;
            index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (value == Long.MIN_VALUE) {
            //return 19; 
        //} else {
            //int index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
            //return (index < 0) ? (-index - 1) : (index + 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.129 -0400", hash_original_method = "067DA515CBCF3B72C5546CE6034B99CF", hash_generated_method = "8AA8EBEAEB0A8DC57091CCFBFE6D9334")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger unscaledValue() {
        BigInteger var85505DC9DEAC70E9B8D28EE675A91514_2087095689 = (getUnscaledValue());
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getUnscaledValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.129 -0400", hash_original_method = "2FC46B1D06394AF066FA7CDA852A22F8", hash_generated_method = "DB60C03C0E2AA028FBBD8C0CD7BC1392")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal round(MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        BigDecimal thisBD;
        thisBD = new BigDecimal(getUnscaledValue(), scale);
        thisBD.inplaceRound(mc);
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigDecimal thisBD = new BigDecimal(getUnscaledValue(), scale);
        //thisBD.inplaceRound(mc);
        //return thisBD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.129 -0400", hash_original_method = "7B0F1A102C68137F597240860B4573E3", hash_generated_method = "AB2239AA247E279D09E913C4D52F1C21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        dsTaint.addTaint(roundingMode.dsTaint);
        dsTaint.addTaint(newScale);
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        long diffScale;
        diffScale = newScale - (long)scale;
        {
            {
                BigDecimal varA609A88E25622A388B083FA8B0D1FC36_1700137240 = (valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],newScale));
            } //End block
            BigDecimal var1A0D3C2A2F08F65BD956E4A3831CA717_1825910733 = (new BigDecimal(Multiplication.multiplyByTenPow(getUnscaledValue(),(int)diffScale), newScale));
        } //End block
        {
            BigDecimal varCAA66E5548DEF33EE5D115BFC675B4EE_1298421547 = (dividePrimitiveLongs(this.smallValue, MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale], newScale,roundingMode));
        } //End block
        BigDecimal var1B31B08D949609358810037AB23728A9_67003988 = (divideBigIntegers(this.getUnscaledValue(),Multiplication.powerOf10(-diffScale),newScale,roundingMode));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.129 -0400", hash_original_method = "82E5CBCA5195979E97780CEADBFBD3C4", hash_generated_method = "6B3B7B6E44D7AC870B6839113CBC07D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal setScale(int newScale, int roundingMode) {
        dsTaint.addTaint(roundingMode);
        dsTaint.addTaint(newScale);
        BigDecimal varF1C2E5F18E8C20AEC695CABB5E055B00_1179276235 = (setScale(newScale, RoundingMode.valueOf(roundingMode)));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.129 -0400", hash_original_method = "ABCD452F1FC16ADBD3F58023EF098557", hash_generated_method = "D673C589AD46D19F7312C923B9545232")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal setScale(int newScale) {
        dsTaint.addTaint(newScale);
        BigDecimal var391D362138F3E634DE937DA1A11BE872_1775976227 = (setScale(newScale, RoundingMode.UNNECESSARY));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.UNNECESSARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.129 -0400", hash_original_method = "146C1C6822DF31E0F5C90B0C65347C9D", hash_generated_method = "6A09369549549A5073588EBEA100FF21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal movePointLeft(int n) {
        dsTaint.addTaint(n);
        BigDecimal var2793870D228DD745BA90BA8BC58B0147_757714016 = (movePoint(scale + (long)n));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return movePoint(scale + (long)n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.130 -0400", hash_original_method = "EF6481821B33DB93DBF91CDB78772ACF", hash_generated_method = "646D64A782AB10EC18AD2181028598B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private BigDecimal movePoint(long newScale) {
        dsTaint.addTaint(newScale);
        {
            boolean var2CC22727CE5D95FFA6F7D70A538860F0_870276297 = (isZero());
            {
                BigDecimal var0495D6AB1E378FBF8BB78D8031EBDA04_2119018761 = (zeroScaledBy(Math.max(newScale, 0)));
            } //End block
        } //End collapsed parenthetic
        {
            {
                BigDecimal var284041F97C4809FAEE3C37CD663063B3_850958027 = (valueOf(smallValue, safeLongToInt(newScale)));
            } //End block
            BigDecimal varA0CB7A58E0D4E40A780CF280C2019C87_1316979700 = (new BigDecimal(getUnscaledValue(), safeLongToInt(newScale)));
        } //End block
        {
            BigDecimal var6D02A246E6ED0EF18452239AF4FD7C1D_1351416486 = (valueOf(smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-newScale],0));
        } //End block
        BigDecimal var23250F0C640BF45C766B12F3C6F13D06_1743203326 = (new BigDecimal(Multiplication.multiplyByTenPow(
                getUnscaledValue(), safeLongToInt(-newScale)), 0));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (isZero()) {
            //return zeroScaledBy(Math.max(newScale, 0));
        //}
        //if(newScale >= 0) {
            //if(bitLength < 64) {
                //return valueOf(smallValue, safeLongToInt(newScale));
            //}
            //return new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
        //}
        //if(-newScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                //bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)-newScale] < 64 ) {
            //return valueOf(smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-newScale],0);
        //}
        //return new BigDecimal(Multiplication.multiplyByTenPow(
                //getUnscaledValue(), safeLongToInt(-newScale)), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.130 -0400", hash_original_method = "07D5C3611C3ACCF090DC6103621F9345", hash_generated_method = "559906BFF380D873A760C97A710D78E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal movePointRight(int n) {
        dsTaint.addTaint(n);
        BigDecimal varA4D0C504DF3D019299A952DCD0A038D4_1227550661 = (movePoint(scale - (long)n));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return movePoint(scale - (long)n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.130 -0400", hash_original_method = "D86719E7E7F9F283B32E5780DA0BBE23", hash_generated_method = "F58200E776C88B9187051D528750045A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal scaleByPowerOfTen(int n) {
        dsTaint.addTaint(n);
        long newScale;
        newScale = scale - (long)n;
        {
            {
                BigDecimal varC7BB63A49CBE3A2085D63CE27D0B7DE4_674271481 = (zeroScaledBy( newScale ));
            } //End block
            BigDecimal var18AFEE280C980151ADED545419F7F562_1795120492 = (valueOf(smallValue, safeLongToInt(newScale)));
        } //End block
        BigDecimal varD92A25B872DEBA876F4936734CB92CC6_1557252260 = (new BigDecimal(getUnscaledValue(), safeLongToInt(newScale)));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //long newScale = scale - (long)n;
        //if(bitLength < 64) {
            //if( smallValue==0  ){
                //return zeroScaledBy( newScale );
            //}
            //return valueOf(smallValue, safeLongToInt(newScale));
        //}
        //return new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.130 -0400", hash_original_method = "6A410D70691999CADF96A81B91BD2E64", hash_generated_method = "D1ADF4517DD5D6DABD6D081578CAF33B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal stripTrailingZeros() {
        int i;
        i = 1;
        int lastPow;
        lastPow = TEN_POW.length - 1;
        long newScale;
        newScale = scale;
        {
            boolean var2CC22727CE5D95FFA6F7D70A538860F0_1234023266 = (isZero());
        } //End collapsed parenthetic
        BigInteger strippedBI;
        strippedBI = getUnscaledValue();
        BigInteger[] quotAndRem;
        {
            boolean varFEBA48CABF974070FADE4D4043F8A64F_1906838241 = (!strippedBI.testBit(0));
            {
                quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
                {
                    boolean varC86A45592F149ACDEC5EDB396276478E_218601521 = (quotAndRem[1].signum() == 0);
                    {
                        newScale -= i;
                        {
                            i++;
                        } //End block
                        strippedBI = quotAndRem[0];
                    } //End block
                    {
                        i = 1;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        BigDecimal var388B2FBDA1524FC0F7F9693BDDC38A3E_587688005 = (new BigDecimal(strippedBI, safeLongToInt(newScale)));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.130 -0400", hash_original_method = "1C45ED34C4C1F5BEBD8BB8EF3CBE1A6B", hash_generated_method = "E66FA3542211E881EED02D061FD102F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(BigDecimal val) {
        dsTaint.addTaint(val.dsTaint);
        int thisSign;
        thisSign = signum();
        int valueSign;
        valueSign = val.signum();
        {
            long diffScale;
            diffScale = (long)this.scale - val.scale;
            int diffPrecision;
            diffPrecision = this.approxPrecision() - val.approxPrecision();
            {
                BigInteger thisUnscaled;
                thisUnscaled = this.getUnscaledValue();
                BigInteger valUnscaled;
                valUnscaled = val.getUnscaledValue();
                {
                    thisUnscaled = thisUnscaled.multiply(Multiplication.powerOf10(-diffScale));
                } //End block
                {
                    valUnscaled = valUnscaled.multiply(Multiplication.powerOf10(diffScale));
                } //End block
                int varCE3C94A5820498591ABCE6F39E1FAD3F_659041734 = (thisUnscaled.compareTo(valUnscaled));
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.130 -0400", hash_original_method = "310E755E039C5525B03EE3C0A35D27A8", hash_generated_method = "E15D080938A7582F5E9B9CD5D901AE30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object x) {
        dsTaint.addTaint(x.dsTaint);
        {
            BigDecimal x1;
            x1 = (BigDecimal) x;
            boolean var001662A341C29FE1FFD924EE7151116A_2146963720 = (x1.scale == scale
                   && (bitLength < 64 ? (x1.smallValue == smallValue)
                    : intVal.equals(x1.intVal))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == x) {
            //return true;
        //}
        //if (x instanceof BigDecimal) {
            //BigDecimal x1 = (BigDecimal) x;
            //return x1.scale == scale
                   //&& (bitLength < 64 ? (x1.smallValue == smallValue)
                    //: intVal.equals(x1.intVal));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.131 -0400", hash_original_method = "F19ED99F66E082325A61ACA186AF7454", hash_generated_method = "C29CD6E7F2EA4BA7DD0CF1ABE3554C92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal min(BigDecimal val) {
        dsTaint.addTaint(val.dsTaint);
        BigDecimal varC2D3D4AFDC4FAA10167AB73AD431C288_441932299 = (((compareTo(val) <= 0) ? this : val)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ((compareTo(val) <= 0) ? this : val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.131 -0400", hash_original_method = "4EA6A2C4CEA295044D603E0ACE9B5BC6", hash_generated_method = "521DB3C572FF996F03AFF4F7EB3B15C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal max(BigDecimal val) {
        dsTaint.addTaint(val.dsTaint);
        BigDecimal varC4CA7FCB04DBEA982A88D3300284FDA4_1024492306 = (((compareTo(val) >= 0) ? this : val)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ((compareTo(val) >= 0) ? this : val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.131 -0400", hash_original_method = "F20F131BB03F0B25B12A1EF1F413017D", hash_generated_method = "FC2835E165160B40AE4306D06717731F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        {
            hashCode = (int)(smallValue & 0xffffffff);
            hashCode = 33 * hashCode +  (int)((smallValue >> 32) & 0xffffffff);
            hashCode = 17 * hashCode + scale;
        } //End block
        hashCode = 17 * intVal.hashCode() + scale;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (hashCode != 0) {
            //return hashCode;
        //}
        //if (bitLength < 64) {
            //hashCode = (int)(smallValue & 0xffffffff);
            //hashCode = 33 * hashCode +  (int)((smallValue >> 32) & 0xffffffff);
            //hashCode = 17 * hashCode + scale;
            //return hashCode;
        //}
        //hashCode = 17 * intVal.hashCode() + scale;
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.131 -0400", hash_original_method = "7C431BE8FF70735180E872A989DC1E52", hash_generated_method = "1B040A362AA324EC51616CAD5EA6BB65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            toStringImage = Conversion.toDecimalScaledString(smallValue,scale);
        } //End block
        String intString;
        intString = getUnscaledValue().toString();
        int begin;
        boolean var5FFC8DC69DEA58D4CEC873F848ECF641_241684866 = ((getUnscaledValue().signum() < 0));
        begin = 2;
        begin = 1;
        int end;
        end = intString.length();
        long exponent;
        exponent = -(long)scale + end - begin;
        StringBuilder result;
        result = new StringBuilder();
        result.append(intString);
        {
            {
                result.insert(end - scale, '.');
            } //End block
            {
                result.insert(begin - 1, "0.");
                result.insert(begin + 1, CH_ZEROS, 0, -(int)exponent - 1);
            } //End block
        } //End block
        {
            {
                result.insert(begin, '.');
                end++;
            } //End block
            result.insert(end, 'E');
            {
                result.insert(++end, '+');
            } //End block
            result.insert(++end, Long.toString(exponent));
        } //End block
        toStringImage = result.toString();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.131 -0400", hash_original_method = "37C393D601D5FE9982CCA7EB2837999F", hash_generated_method = "A5C6B72DB297B22E15824108DC3C01B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toEngineeringString() {
        String intString;
        intString = getUnscaledValue().toString();
        int begin;
        boolean var5FFC8DC69DEA58D4CEC873F848ECF641_1638315355 = ((getUnscaledValue().signum() < 0));
        begin = 2;
        begin = 1;
        int end;
        end = intString.length();
        long exponent;
        exponent = -(long)scale + end - begin;
        StringBuilder result;
        result = new StringBuilder(intString);
        {
            {
                result.insert(end - scale, '.');
            } //End block
            {
                result.insert(begin - 1, "0.");
                result.insert(begin + 1, CH_ZEROS, 0, -(int)exponent - 1);
            } //End block
        } //End block
        {
            int delta;
            delta = end - begin;
            int rem;
            rem = (int)(exponent % 3);
            {
                {
                    boolean varF1275512AD4A7A2856364C7EFBECF78A_1245252256 = (getUnscaledValue().signum() == 0);
                    {
                        rem = (rem < 0) ? -rem : 3 - rem;
                        exponent += rem;
                    } //End block
                    {
                        rem = (rem < 0) ? rem + 3 : rem;
                        exponent -= rem;
                        begin += rem;
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        int i;
                        i = rem - delta;
                        {
                            result.insert(end++, '0');
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                result.insert(begin, '.');
                end++;
            } //End block
            {
                result.insert(end, 'E');
                {
                    result.insert(++end, '+');
                } //End block
                result.insert(++end, Long.toString(exponent));
            } //End block
        } //End block
        String varEA70154FDA28CC59402440C6317B57EF_1673699156 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.132 -0400", hash_original_method = "F2C3CA97C72252FC482FDCEF1D32932E", hash_generated_method = "5347A98BF3ADBF7BE23AE0A6B5B97B63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toPlainString() {
        String intStr;
        intStr = getUnscaledValue().toString();
        {
            boolean var5EBF43068CE74A5170A1EF5C21021CBF_1422770736 = ((scale == 0) || ((isZero()) && (scale < 0)));
        } //End collapsed parenthetic
        int begin;
        boolean var515FA627C40C3884068623DD22E9034F_2130515415 = ((signum() < 0));
        begin = 1;
        begin = 0;
        int delta;
        delta = scale;
        StringBuilder result;
        result = new StringBuilder(intStr.length() + 1 + Math.abs(scale));
        {
            result.append('-');
        } //End block
        {
            delta -= (intStr.length() - begin);
            {
                result.append("0.");
                {
                    delta -= CH_ZEROS.length;
                    {
                        result.append(CH_ZEROS);
                    } //End block
                } //End collapsed parenthetic
                result.append(CH_ZEROS, 0, delta);
                result.append(intStr.substring(begin));
            } //End block
            {
                delta = begin - delta;
                result.append(intStr.substring(begin, delta));
                result.append('.');
                result.append(intStr.substring(delta));
            } //End block
        } //End block
        {
            result.append(intStr.substring(begin));
            {
                delta += CH_ZEROS.length;
                {
                    result.append(CH_ZEROS);
                } //End block
            } //End collapsed parenthetic
            result.append(CH_ZEROS, 0, -delta);
        } //End block
        String varEA70154FDA28CC59402440C6317B57EF_58289868 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.132 -0400", hash_original_method = "E90ADE3EE93FD433EFA047972DEC5382", hash_generated_method = "AD226B959E0451BA3B2272C51B9BAFF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger toBigInteger() {
        {
            boolean var527650A3DE5B2457ABCDED439E32377E_109835770 = ((scale == 0) || (isZero()));
            {
                BigInteger var39F17725E475A8AA694FBC79F0AD1FBD_951334440 = (getUnscaledValue());
            } //End block
            {
                BigInteger var0F1719E1537C805B75C948574C44966C_1101748651 = (getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale)));
            } //End block
            {
                BigInteger var392BA88D911EEC008927EB77A9625132_230445364 = (getUnscaledValue().divide(Multiplication.powerOf10(scale)));
            } //End block
        } //End collapsed parenthetic
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if ((scale == 0) || (isZero())) {
            //return getUnscaledValue();
        //} else if (scale < 0) {
            //return getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
        //} else {
            //return getUnscaledValue().divide(Multiplication.powerOf10(scale));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.132 -0400", hash_original_method = "0E78A189176A3E6769EBE407FB203DE6", hash_generated_method = "66B5F776CEE34D36AD9536A2D1B063E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger toBigIntegerExact() {
        {
            boolean var527650A3DE5B2457ABCDED439E32377E_824503322 = ((scale == 0) || (isZero()));
            {
                BigInteger var39F17725E475A8AA694FBC79F0AD1FBD_1137147404 = (getUnscaledValue());
            } //End block
            {
                BigInteger var0F1719E1537C805B75C948574C44966C_154903291 = (getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale)));
            } //End block
            {
                BigInteger[] integerAndFraction;
                {
                    boolean varDA526623548FC456E3243F91470F7749_276152787 = ((scale > approxPrecision()) || (scale > getUnscaledValue().getLowestSetBit()));
                    if(DroidSafeAndroidRuntime.control) {
                        throw new ArithmeticException("Rounding necessary");
                    } //End block
                } //End collapsed parenthetic
                integerAndFraction = getUnscaledValue().divideAndRemainder(Multiplication.powerOf10(scale));
                {
                    boolean var295E569F979C75DF93112C8D385DE9FD_248864213 = (integerAndFraction[1].signum() != 0);
                    if(DroidSafeAndroidRuntime.control) {
                        throw new ArithmeticException("Rounding necessary");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if ((scale == 0) || (isZero())) {
            //return getUnscaledValue();
        //} else if (scale < 0) {
            //return getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
        //} else {
            //BigInteger[] integerAndFraction;
            //if ((scale > approxPrecision()) || (scale > getUnscaledValue().getLowestSetBit())) {
                //throw new ArithmeticException("Rounding necessary");
            //}
            //integerAndFraction = getUnscaledValue().divideAndRemainder(Multiplication.powerOf10(scale));
            //if (integerAndFraction[1].signum() != 0) {
                //throw new ArithmeticException("Rounding necessary");
            //}
            //return integerAndFraction[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.132 -0400", hash_original_method = "A54EDCAFB9A559A1B4EB83484BB75122", hash_generated_method = "5D5F692BBDC96381092C6AC8E8035F38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long longValue() {
        long var02BCFECEB27CDDF7BA27A8716D0E8C08_1442284641 = (((scale <= -64) || (scale > approxPrecision()) ? 0L
                : toBigInteger().longValue())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return ((scale <= -64) || (scale > approxPrecision()) ? 0L
                //: toBigInteger().longValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.132 -0400", hash_original_method = "FC36A176D0180DB1420333E5E0A5371B", hash_generated_method = "80C961B1441519E61D05D3D990FD5909")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long longValueExact() {
        long var911FCAB8DFB4008CF2390984C1A72430_386627561 = (valueExact(64));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return valueExact(64);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.133 -0400", hash_original_method = "C22AEC57669E1045E01A9977FB32CBED", hash_generated_method = "52F6B4C92C4CB1D2550C440607DFAE9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int intValue() {
        int var260F64E277497774BB8037E8D91956FC_663728697 = (((scale <= -32) || (scale > approxPrecision())
        ? 0
                : toBigInteger().intValue())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((scale <= -32) || (scale > approxPrecision())
        //? 0
                //: toBigInteger().intValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.133 -0400", hash_original_method = "3865E14853C36D94FA2C26348C89A3B8", hash_generated_method = "11D9F1F17F98E18FC8CD75B90BDEA691")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int intValueExact() {
        int var86C4522ACDF35D342B59DBE535781A9E_359770029 = ((int)valueExact(32));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int)valueExact(32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.133 -0400", hash_original_method = "D0948D36E91C12739D01E1A7BD76887B", hash_generated_method = "6FF6D9A0362129AD694076022366E9D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short shortValueExact() {
        short varA81ACCE95AC11A2580319A9BFEB7E9B2_1447869914 = ((short)valueExact(16));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short)valueExact(16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.133 -0400", hash_original_method = "D6CE76A6DF6EC675E82ED0D5BFCEAF06", hash_generated_method = "884C1005E2D836EEF5977D27EB4AF052")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte byteValueExact() {
        byte varD83BA7BD5DF600388856A2C30163822F_1453892029 = ((byte)valueExact(8));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte)valueExact(8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.133 -0400", hash_original_method = "4137052570907849FFBB7EF546BA389D", hash_generated_method = "FFC0F3A4DC5167E290A6BD45B811F812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public float floatValue() {
        float floatResult;
        floatResult = signum();
        long powerOfTwo;
        powerOfTwo = this.bitLength - (long)(scale / LOG10_2);
        {
            floatResult *= 0.0f;
        } //End block
        {
            floatResult *= Float.POSITIVE_INFINITY;
        } //End block
        {
            floatResult = (float)doubleValue();
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //float floatResult = signum();
        //long powerOfTwo = this.bitLength - (long)(scale / LOG10_2);
        //if ((powerOfTwo < -149) || (floatResult == 0.0f)) {
            //floatResult *= 0.0f;
        //} else if (powerOfTwo > 129) {
            //floatResult *= Float.POSITIVE_INFINITY;
        //} else {
            //floatResult = (float)doubleValue();
        //}
        //return floatResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.133 -0400", hash_original_method = "73F99D783081712086B11A0804DADCB9", hash_generated_method = "4283873BF161043B829288CF3649B59F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public double doubleValue() {
        int sign;
        sign = signum();
        int exponent;
        exponent = 1076;
        int lowestSetBit;
        int discardedSize;
        long powerOfTwo;
        powerOfTwo = this.bitLength - (long)(scale / LOG10_2);
        long bits;
        long tempBits;
        BigInteger mantissa;
        mantissa = getUnscaledValue().abs();
        {
            mantissa = mantissa.multiply(Multiplication.powerOf10(-scale));
        } //End block
        {
            BigInteger quotAndRem[];
            BigInteger powerOfTen;
            powerOfTen = Multiplication.powerOf10(scale);
            int k;
            k = 100 - (int)powerOfTwo;
            int compRem;
            {
                mantissa = mantissa.shiftLeft(k);
                exponent -= k;
            } //End block
            quotAndRem = mantissa.divideAndRemainder(powerOfTen);
            compRem = quotAndRem[1].shiftLeftOneBit().compareTo(powerOfTen);
            mantissa = quotAndRem[0].shiftLeft(2).add(
                    BigInteger.valueOf((compRem * (compRem + 3)) / 2 + 1));
            exponent -= 2;
        } //End block
        lowestSetBit = mantissa.getLowestSetBit();
        discardedSize = mantissa.bitLength() - 54;
        {
            bits = mantissa.shiftRight(discardedSize).longValue();
            tempBits = bits;
            {
                bits += 2;
            } //End block
        } //End block
        {
            bits = mantissa.longValue() << -discardedSize;
            tempBits = bits;
            {
                bits += 2;
            } //End block
        } //End block
        {
            bits >>= 1;
            exponent += discardedSize;
        } //End block
        {
            bits >>= 2;
            exponent += discardedSize + 1;
        } //End block
        {
            bits = tempBits >> 1;
            tempBits = bits & (-1L >>> (63 + exponent));
            bits >>= (-exponent );
            {
                bits += 1;
            } //End block
            exponent = 0;
            bits >>= 1;
        } //End block
        bits = (sign & 0x8000000000000000L) | ((long)exponent << 52)
                | (bits & 0xFFFFFFFFFFFFFL);
        double varCD654D4151F8E678076C18FA9FDC44FD_1589950786 = (Double.longBitsToDouble(bits));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.134 -0400", hash_original_method = "AE130D2701C769DD6982173139D47466", hash_generated_method = "57B0F5E234CC6ED33F7DA4D203E0588C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigDecimal ulp() {
        BigDecimal var76855C154F21ECFC00B66686C9CF1D08_1094811532 = (valueOf(1, scale));
        return (BigDecimal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return valueOf(1, scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.134 -0400", hash_original_method = "55CD7E6ED2002FE9D7C30850FBD08759", hash_generated_method = "7731BD918CE50864DAC1CCCE1CC1A65B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void inplaceRound(MathContext mc) {
        dsTaint.addTaint(mc.dsTaint);
        int mcPrecision;
        mcPrecision = mc.getPrecision();
        {
            boolean var6F010C2CB7AD09A8BC94F0B71513AC32_570344144 = (approxPrecision() < mcPrecision || mcPrecision == 0);
        } //End collapsed parenthetic
        int discardedPrecision;
        discardedPrecision = precision() - mcPrecision;
        {
            smallRound(mc, discardedPrecision);
        } //End block
        BigInteger sizeOfFraction;
        sizeOfFraction = Multiplication.powerOf10(discardedPrecision);
        BigInteger[] integerAndFraction;
        integerAndFraction = getUnscaledValue().divideAndRemainder(sizeOfFraction);
        long newScale;
        newScale = (long)scale - discardedPrecision;
        int compRem;
        BigDecimal tempBD;
        {
            boolean var117BFEC09FEE1A0EBD26552B3C18D98D_1270508862 = (integerAndFraction[1].signum() != 0);
            {
                compRem = (integerAndFraction[1].abs().shiftLeftOneBit().compareTo(sizeOfFraction));
                compRem =  roundingBehavior( integerAndFraction[0].testBit(0) ? 1 : 0,
                    integerAndFraction[1].signum() * (5 + compRem),
                    mc.getRoundingMode());
                {
                    integerAndFraction[0] = integerAndFraction[0].add(BigInteger.valueOf(compRem));
                } //End block
                tempBD = new BigDecimal(integerAndFraction[0]);
                {
                    boolean var10B8B9353B6BDAF0B62CA0F73EC5E632_1634961979 = (tempBD.precision() > mcPrecision);
                    {
                        integerAndFraction[0] = integerAndFraction[0].divide(BigInteger.TEN);
                        newScale--;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        scale = safeLongToInt(newScale);
        precision = mcPrecision;
        setUnscaledValue(integerAndFraction[0]);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.134 -0400", hash_original_method = "6F8795E63BC9049AAA9B8D7577159AC3", hash_generated_method = "2C494A30C70403F75BDC3A7CF90E78BB")
    private static int longCompareTo(long value1, long value2) {
        return value1 > value2 ? 1 : (value1 < value2 ? -1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.134 -0400", hash_original_method = "7FBE752FF3FF6B350050AE2B0F2B0308", hash_generated_method = "BFA8A1D079BC5A351A2920B61F9978B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void smallRound(MathContext mc, int discardedPrecision) {
        dsTaint.addTaint(discardedPrecision);
        dsTaint.addTaint(mc.dsTaint);
        long sizeOfFraction;
        sizeOfFraction = MathUtils.LONG_POWERS_OF_TEN[discardedPrecision];
        long newScale;
        newScale = (long)scale - discardedPrecision;
        long unscaledVal;
        unscaledVal = smallValue;
        long integer;
        integer = unscaledVal / sizeOfFraction;
        long fraction;
        fraction = unscaledVal % sizeOfFraction;
        int compRem;
        {
            compRem = longCompareTo(Math.abs(fraction) * 2, sizeOfFraction);
            integer += roundingBehavior( ((int)integer) & 1,
                    Long.signum(fraction) * (5 + compRem),
                    mc.getRoundingMode());
            {
                boolean var23E618BB7F5984728547DADF43F7547E_891861555 = (Math.log10(Math.abs(integer)) >= mc.getPrecision());
                {
                    integer /= 10;
                    newScale--;
                } //End block
            } //End collapsed parenthetic
        } //End block
        scale = safeLongToInt(newScale);
        precision = mc.getPrecision();
        smallValue = integer;
        bitLength = bitLength(integer);
        intVal = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.134 -0400", hash_original_method = "89FB81061342283FD2D255BA617B9F56", hash_generated_method = "3CB9F361905618FF6C3C3A699D421363")
    private static int roundingBehavior(int parityBit, int fraction, RoundingMode roundingMode) {
        int increment = 0;
        switch (roundingMode) {
            case UNNECESSARY:
                if (fraction != 0) {
                    throw new ArithmeticException("Rounding necessary");
                }
                break;
            case UP:
                increment = Integer.signum(fraction);
                break;
            case DOWN:
                break;
            case CEILING:
                increment = Math.max(Integer.signum(fraction), 0);
                break;
            case FLOOR:
                increment = Math.min(Integer.signum(fraction), 0);
                break;
            case HALF_UP:
                if (Math.abs(fraction) >= 5) {
                    increment = Integer.signum(fraction);
                }
                break;
            case HALF_DOWN:
                if (Math.abs(fraction) > 5) {
                    increment = Integer.signum(fraction);
                }
                break;
            case HALF_EVEN:
                if (Math.abs(fraction) + parityBit > 5) {
                    increment = Integer.signum(fraction);
                }
                break;
        }
        return increment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.135 -0400", hash_original_method = "77E444DFD73510CC8BF3E35576C17A04", hash_generated_method = "0E83E30C971CEE693740F621D402B59B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long valueExact(int bitLengthOfType) {
        dsTaint.addTaint(bitLengthOfType);
        BigInteger bigInteger;
        bigInteger = toBigIntegerExact();
        {
            boolean var34AD3BA92A978E0890FA3B0628CDDC06_1998781250 = (bigInteger.bitLength() < bitLengthOfType);
            {
                long var9D31F6DC18FE28EB42FCCA0D0D616FEB_441579990 = (bigInteger.longValue());
            } //End block
        } //End collapsed parenthetic
        if(DroidSafeAndroidRuntime.control) {
        	throw new ArithmeticException("Rounding necessary");
        }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //BigInteger bigInteger = toBigIntegerExact();
        //if (bigInteger.bitLength() < bitLengthOfType) {
            //return bigInteger.longValue();
        //}
        //throw new ArithmeticException("Rounding necessary");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.135 -0400", hash_original_method = "610DE3E95388579A8DD4E22BDEDE3C6E", hash_generated_method = "88E4D743B84EA857D98011C40A0B2D6F")
    @DSModeled(DSC.SAFE)
    private int approxPrecision() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return precision > 0
                //? precision
                //: (int) ((this.bitLength - 1) * LOG10_2) + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.135 -0400", hash_original_method = "3E37D52FCEF46233035FAF85688E9AE3", hash_generated_method = "4EFDE105A2047266074EE79EE87CC770")
    private static int safeLongToInt(long longValue) {
        if (longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
            throw new ArithmeticException("Out of int range: " + longValue);
        }
        return (int) longValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.135 -0400", hash_original_method = "02562B606C3E71F0B7DFB1304AA72DDB", hash_generated_method = "C194E961E90BA0311F68E21D1A359734")
    private static BigDecimal zeroScaledBy(long longScale) {
        if (longScale == (int) longScale) {
            return valueOf(0,(int)longScale);
            }
        if (longScale >= 0) {
            return new BigDecimal( 0, Integer.MAX_VALUE);
        }
        return new BigDecimal( 0, Integer.MIN_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.135 -0400", hash_original_method = "886E4F08C2196C85465CF795B505FE44", hash_generated_method = "85C0B506B2112FC6EC0569D9CE23FB24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        in.defaultReadObject();
        this.bitLength = intVal.bitLength();
        {
            this.smallValue = intVal.longValue();
        } //End block
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //this.bitLength = intVal.bitLength();
        //if (this.bitLength < 64) {
            //this.smallValue = intVal.longValue();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.135 -0400", hash_original_method = "19FA8CC309F5EC9C814FD711C697099A", hash_generated_method = "2D73195704945BA13ECC0E2A5664964C")
    @DSModeled(DSC.SAFE)
    private void writeObject(ObjectOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        getUnscaledValue();
        out.defaultWriteObject();
        // ---------- Original Method ----------
        //getUnscaledValue();
        //out.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.135 -0400", hash_original_method = "1C1109E2DBDCFAE7331AD37D197254D0", hash_generated_method = "B6CD7F30413DFA2ADFDC5F6148A63B07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private BigInteger getUnscaledValue() {
        {
            intVal = BigInteger.valueOf(smallValue);
        } //End block
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if(intVal == null) {
            //intVal = BigInteger.valueOf(smallValue);
        //}
        //return intVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.135 -0400", hash_original_method = "3BE919C32007DA5FAF4FB8B842EE650C", hash_generated_method = "BEAB8F723746D1FB027EF2E821D9C720")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setUnscaledValue(BigInteger unscaledValue) {
        dsTaint.addTaint(unscaledValue.dsTaint);
        this.bitLength = unscaledValue.bitLength();
        {
            this.smallValue = unscaledValue.longValue();
        } //End block
        // ---------- Original Method ----------
        //this.intVal = unscaledValue;
        //this.bitLength = unscaledValue.bitLength();
        //if(this.bitLength < 64) {
            //this.smallValue = unscaledValue.longValue();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.135 -0400", hash_original_method = "82F1645A8A86A2C28F5CBA199054A99A", hash_generated_method = "C60AF3E4191D1B3AD0803B03B056147B")
    private static int bitLength(long smallValue) {
        if(smallValue < 0) {
            smallValue = ~smallValue;
        }
        return 64 - Long.numberOfLeadingZeros(smallValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.135 -0400", hash_original_method = "DC0F77C7653E0BDC476925E875F64B26", hash_generated_method = "A286E1DAA74B22D67487DC50E36C15B2")
    private static int bitLength(int smallValue) {
        if(smallValue < 0) {
            smallValue = ~smallValue;
        }
        return 32 - Integer.numberOfLeadingZeros(smallValue);
    }

    
    static {
        Arrays.fill(CH_ZEROS, '0');
        for (int i = 0; i < ZERO_SCALED_BY.length; ++i) {
            BI_SCALED_BY_ZERO[i] = new BigDecimal(i, 0);
            ZERO_SCALED_BY[i] = new BigDecimal(0, i);
        }
        for (int i = 0; i < LONG_FIVE_POW_BIT_LENGTH.length; ++i) {
            LONG_FIVE_POW_BIT_LENGTH[i] = bitLength(LONG_FIVE_POW[i]);
        }
        for (int i = 0; i < LONG_POWERS_OF_TEN_BIT_LENGTH.length; ++i) {
            LONG_POWERS_OF_TEN_BIT_LENGTH[i] = bitLength(MathUtils.LONG_POWERS_OF_TEN[i]);
        }
        TEN_POW = Multiplication.bigTenPows;
        FIVE_POW = Multiplication.bigFivePows;
    }
    
}


