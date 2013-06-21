package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.math.MathUtils;

final class RealToString {
    private int firstK;
    private int[] digits = new int[64];
    private int digitCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.972 -0400", hash_original_method = "F7A95644C563B2D2A217A4C43DE10AFD", hash_generated_method = "169948A49888C1C730B719BC7C95C046")
    @DSModeled(DSC.SAFE)
    private RealToString() {
        // ---------- Original Method ----------
    }

    
        public static RealToString getInstance() {
        return INSTANCE.get();
    }

    
        private static String resultOrSideEffect(AbstractStringBuilder sb, String s) {
        if (sb != null) {
            sb.append0(s);
            return null;
        }
        return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.972 -0400", hash_original_method = "1884E8ED6DAC8970F9D7F2BC46F506BE", hash_generated_method = "F50F85F4D65CC8E41E4F31FD37C7FDA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String doubleToString(double d) {
        dsTaint.addTaint(d);
        String var2F9A2D4C630DB54197F7EDB4E815B84D_718970868 = (convertDouble(null, d));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return convertDouble(null, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.972 -0400", hash_original_method = "60FFADFBFC8614534238C3F90209FDC5", hash_generated_method = "4AFE1F6604129D158F63E3E228AB8400")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appendDouble(AbstractStringBuilder sb, double d) {
        dsTaint.addTaint(d);
        dsTaint.addTaint(sb.dsTaint);
        convertDouble(sb, d);
        // ---------- Original Method ----------
        //convertDouble(sb, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.973 -0400", hash_original_method = "3B1841CA85DCDA9CC6F8697012DC38A6", hash_generated_method = "2FCB5597C71C2B9980ED589BA6F1BA97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String convertDouble(AbstractStringBuilder sb, double inputNumber) {
        dsTaint.addTaint(sb.dsTaint);
        dsTaint.addTaint(inputNumber);
        long inputNumberBits;
        inputNumberBits = Double.doubleToRawLongBits(inputNumber);
        boolean positive;
        positive = (inputNumberBits & Double.SIGN_MASK) == 0;
        int e;
        e = (int) ((inputNumberBits & Double.EXPONENT_MASK) >> Double.MANTISSA_BITS);
        long f;
        f = inputNumberBits & Double.MANTISSA_MASK;
        boolean mantissaIsZero;
        mantissaIsZero = f == 0;
        String quickResult;
        quickResult = null;
        {
            {
                quickResult = positive ? "Infinity" : "-Infinity";
            } //End block
            {
                quickResult = "NaN";
            } //End block
        } //End block
        {
            {
                quickResult = positive ? "0.0" : "-0.0";
            } //End block
            {
                quickResult = positive ? "4.9E-324" : "-4.9E-324";
            } //End block
        } //End block
        {
            String var71D610D6640E9016FC39F7B849814E51_135238460 = (resultOrSideEffect(sb, quickResult));
        } //End block
        int p;
        p = Double.EXPONENT_BIAS + Double.MANTISSA_BITS;
        int pow;
        int numBits;
        numBits = Double.MANTISSA_BITS;
        {
            pow = 1 - p;
            long ff;
            ff = f;
            {
                ff = ff << 1;
            } //End block
        } //End block
        {
            f = f | 0x0010000000000000L;
            pow = e - p;
        } //End block
        firstK = digitCount = 0;
        {
            longDigitGenerator(f, pow, e == 0, mantissaIsZero, numBits);
        } //End block
        {
            bigIntDigitGenerator(f, pow, e == 0, numBits);
        } //End block
        AbstractStringBuilder dst;
        dst = sb;
        dst = new StringBuilder(26);
        {
            freeFormatExponential(dst, positive);
        } //End block
        {
            freeFormat(dst, positive);
        } //End block
        {
            Object varA1D9E704460129941A9AE0D5CAAF1720_900635886 = (dst.toString());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.973 -0400", hash_original_method = "2E0F3580AFBA548A22C88B300D06F425", hash_generated_method = "840BBFC9E3AB3AAA15ADBE49D920FB72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String floatToString(float f) {
        dsTaint.addTaint(f);
        String varE62E9C948E16F6272EB76723488661BA_342186233 = (convertFloat(null, f));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return convertFloat(null, f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.974 -0400", hash_original_method = "A5528970A4B6C3EDBBDAB69CF73AE9A3", hash_generated_method = "0ECE795AC9B9C633F23D213EB20D19DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appendFloat(AbstractStringBuilder sb, float f) {
        dsTaint.addTaint(f);
        dsTaint.addTaint(sb.dsTaint);
        convertFloat(sb, f);
        // ---------- Original Method ----------
        //convertFloat(sb, f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.974 -0400", hash_original_method = "E5DE8038B72ADC299B522ADF153A4152", hash_generated_method = "A1ED9FA22C1ACE8FF489CDB367F80CCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String convertFloat(AbstractStringBuilder sb, float inputNumber) {
        dsTaint.addTaint(sb.dsTaint);
        dsTaint.addTaint(inputNumber);
        int inputNumberBits;
        inputNumberBits = Float.floatToRawIntBits(inputNumber);
        boolean positive;
        positive = (inputNumberBits & Float.SIGN_MASK) == 0;
        int e;
        e = (inputNumberBits & Float.EXPONENT_MASK) >> Float.MANTISSA_BITS;
        int f;
        f = inputNumberBits & Float.MANTISSA_MASK;
        boolean mantissaIsZero;
        mantissaIsZero = f == 0;
        String quickResult;
        quickResult = null;
        {
            {
                quickResult = positive ? "Infinity" : "-Infinity";
            } //End block
            {
                quickResult = "NaN";
            } //End block
        } //End block
        {
            quickResult = positive ? "0.0" : "-0.0";
        } //End block
        {
            String var71D610D6640E9016FC39F7B849814E51_1124572596 = (resultOrSideEffect(sb, quickResult));
        } //End block
        int p;
        p = Float.EXPONENT_BIAS + Float.MANTISSA_BITS;
        int pow;
        int numBits;
        numBits = Float.MANTISSA_BITS;
        {
            pow = 1 - p;
            {
                f = f << 2;
                pow -= 2;
            } //End block
            int ff;
            ff = f;
            {
                ff = ff << 1;
            } //End block
        } //End block
        {
            f = f | 0x00800000;
            pow = e - p;
        } //End block
        firstK = digitCount = 0;
        {
            longDigitGenerator(f, pow, e == 0, mantissaIsZero, numBits);
        } //End block
        {
            bigIntDigitGenerator(f, pow, e == 0, numBits);
        } //End block
        AbstractStringBuilder dst;
        dst = sb;
        dst = new StringBuilder(26);
        {
            freeFormatExponential(dst, positive);
        } //End block
        {
            freeFormat(dst, positive);
        } //End block
        {
            Object varA1D9E704460129941A9AE0D5CAAF1720_1756554710 = (dst.toString());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.975 -0400", hash_original_method = "C9139C7071A5044040591AD73A0078E9", hash_generated_method = "303B6B8DE7EAF6C1DBE548AF53D897CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void freeFormatExponential(AbstractStringBuilder sb, boolean positive) {
        dsTaint.addTaint(sb.dsTaint);
        dsTaint.addTaint(positive);
        int digitIndex;
        digitIndex = 0;
        {
            sb.append0('-');
        } //End block
        sb.append0((char) ('0' + digits[digitIndex++]));
        sb.append0('.');
        int k;
        k = firstK;
        int exponent;
        exponent = k;
        {
            sb.append0((char) ('0' + digits[digitIndex++]));
        } //End block
        {
            sb.append0('0');
        } //End block
        sb.append0('E');
        IntegralToString.appendInt(sb, exponent);
        // ---------- Original Method ----------
        //int digitIndex = 0;
        //if (!positive) {
            //sb.append0('-');
        //}
        //sb.append0((char) ('0' + digits[digitIndex++]));
        //sb.append0('.');
        //int k = firstK;
        //int exponent = k;
        //while (true) {
            //k--;
            //if (digitIndex >= digitCount) {
                //break;
            //}
            //sb.append0((char) ('0' + digits[digitIndex++]));
        //}
        //if (k == exponent - 1) {
            //sb.append0('0');
        //}
        //sb.append0('E');
        //IntegralToString.appendInt(sb, exponent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.975 -0400", hash_original_method = "81B49BC2D9465FB81325CD1E0D55DA15", hash_generated_method = "D3EDF04DA20917E9CA6BF56BCBB18482")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void freeFormat(AbstractStringBuilder sb, boolean positive) {
        dsTaint.addTaint(sb.dsTaint);
        dsTaint.addTaint(positive);
        int digitIndex;
        digitIndex = 0;
        {
            sb.append0('-');
        } //End block
        int k;
        k = firstK;
        {
            sb.append0('0');
            sb.append0('.');
            {
                int i;
                i = k + 1;
                {
                    sb.append0('0');
                } //End block
            } //End collapsed parenthetic
        } //End block
        int U;
        U = digits[digitIndex++];
        {
            {
                sb.append0((char) ('0' + U));
            } //End block
            {
                sb.append0('0');
            } //End block
            {
                sb.append0('.');
            } //End block
            U = digitIndex < digitCount ? digits[digitIndex++] : -1;
        } //End block
        // ---------- Original Method ----------
        //int digitIndex = 0;
        //if (!positive) {
            //sb.append0('-');
        //}
        //int k = firstK;
        //if (k < 0) {
            //sb.append0('0');
            //sb.append0('.');
            //for (int i = k + 1; i < 0; ++i) {
                //sb.append0('0');
            //}
        //}
        //int U = digits[digitIndex++];
        //do {
            //if (U != -1) {
                //sb.append0((char) ('0' + U));
            //} else if (k >= -1) {
                //sb.append0('0');
            //}
            //if (k == 0) {
                //sb.append0('.');
            //}
            //k--;
            //U = digitIndex < digitCount ? digits[digitIndex++] : -1;
        //} while (U != -1 || k >= -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.975 -0400", hash_original_method = "83E7E0138396E030AA4AE60F27CCD6BF", hash_generated_method = "96FA1F09A594A3FBB4A382E23B5F515E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void bigIntDigitGenerator(long f, int e, boolean isDenormalized, int p) {
        dsTaint.addTaint(f);
        dsTaint.addTaint(isDenormalized);
        dsTaint.addTaint(e);
        dsTaint.addTaint(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.976 -0400", hash_original_method = "6A17AA5B213AA1683132D90321A5CCE9", hash_generated_method = "16820AB4EC664F778642EB721E218BF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void longDigitGenerator(long f, int e, boolean isDenormalized,
            boolean mantissaIsZero, int p) {
        dsTaint.addTaint(f);
        dsTaint.addTaint(isDenormalized);
        dsTaint.addTaint(mantissaIsZero);
        dsTaint.addTaint(e);
        dsTaint.addTaint(p);
        long R, S, M;
        {
            M = 1l << e;
            {
                R = f << (e + 1);
                S = 2;
            } //End block
            {
                R = f << (e + 2);
                S = 4;
            } //End block
        } //End block
        {
            M = 1;
            {
                R = f << 1;
                S = 1l << (1 - e);
            } //End block
            {
                R = f << 2;
                S = 1l << (2 - e);
            } //End block
        } //End block
        int k;
        k = (int) Math.ceil((e + p - 1) * invLogOfTenBaseTwo - 1e-10);
        {
            S = S * MathUtils.LONG_POWERS_OF_TEN[k];
        } //End block
        {
            long scale;
            scale = MathUtils.LONG_POWERS_OF_TEN[-k];
            R = R * scale;
            M = M == 1 ? scale : M * scale;
        } //End block
        {
            firstK = k;
        } //End block
        {
            firstK = k - 1;
            R = R * 10;
            M = M * 10;
        } //End block
        boolean low, high;
        int U;
        {
            U = 0;
            {
                int i;
                i = 3;
                {
                    long remainder;
                    remainder = R - (S << i);
                    {
                        R = remainder;
                        U += 1 << i;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            low = R < M;
            high = R + M > S;
            R = R * 10;
            M = M * 10;
            digits[digitCount++] = U;
        } //End block
        {
            digits[digitCount++] = U;
        } //End block
        {
            digits[digitCount++] = U + 1;
        } //End block
        {
            digits[digitCount++] = U;
        } //End block
        {
            digits[digitCount++] = U + 1;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final ThreadLocal<RealToString> INSTANCE = new ThreadLocal<RealToString>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.976 -0400", hash_original_method = "9364A7477DF2F9BBB2EF3C35EE7A5D92", hash_generated_method = "E056FBB72B226098D3176E0B898F0F26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected RealToString initialValue() {
            RealToString varEE64478E3C8393F7CFB612D17E773632_1188558507 = (new RealToString());
            return (RealToString)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new RealToString();
        }

        
}; //Transformed anonymous class
    private static final double invLogOfTenBaseTwo = Math.log(2.0) / Math.log(10.0);
}

