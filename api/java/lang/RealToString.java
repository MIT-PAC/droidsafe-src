package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.math.MathUtils;

final class RealToString {

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.672 -0500", hash_original_method = "30D5D492EADCC746F56566F6C51DBFB8", hash_generated_method = "6210D16B0A5F121D177C5A787BA02E44")
    
public static RealToString getInstance() {
        return INSTANCE.get();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.675 -0500", hash_original_method = "A3C59A2427D4266EFD936A5ED960D197", hash_generated_method = "0F4C501A9B62AFB41F5015526CA43006")
    
private static String resultOrSideEffect(AbstractStringBuilder sb, String s) {
        if (sb != null) {
            sb.append0(s);
            return null;
        }
        return s;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.573 -0400", hash_original_field = "2D2E92A8D0328A9801B0413D209B9EF9", hash_generated_field = "9DCB2A0234839FFA438E5D31EF7751AF")

    private static final ThreadLocal<RealToString> INSTANCE = new ThreadLocal<RealToString>() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.573 -0400", hash_original_method = "9364A7477DF2F9BBB2EF3C35EE7A5D92", hash_generated_method = "6879AD8D085EBF57CA55A5F59F935FBD")
        @Override
        protected RealToString initialValue() {
            RealToString varB4EAC82CA7396A68D541C85D26508E83_488269211 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_488269211 = new RealToString();
            varB4EAC82CA7396A68D541C85D26508E83_488269211.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_488269211;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.660 -0500", hash_original_field = "DDCFC4BA9A320738A311B6CDFAC04909", hash_generated_field = "CB87C311F6043A6FA9F065A81B47C7CD")

    private static final double invLogOfTenBaseTwo = Math.log(2.0) / Math.log(10.0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.662 -0500", hash_original_field = "7B483AA2F3A8F35DB64B8F104D661A1E", hash_generated_field = "6D9BB978CBD3D3FD82983DAB50AF5B36")

    private int firstK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.664 -0500", hash_original_field = "43D0909B7EC78B784A77E0B7A5D12574", hash_generated_field = "50690E06A9DD54E798BAB9384D861132")

    private final int[] digits = new int[64];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.667 -0500", hash_original_field = "DA306FBA251AF5817D2AA075E284A0EC", hash_generated_field = "A3250AF80A97B4CAE044DFA388B9EA6A")

    private int digitCount;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.669 -0500", hash_original_method = "F7A95644C563B2D2A217A4C43DE10AFD", hash_generated_method = "51776C658104A660CFC7D2506C25B592")
    
private RealToString() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.677 -0500", hash_original_method = "1884E8ED6DAC8970F9D7F2BC46F506BE", hash_generated_method = "C5A77350F7EC45269ABE48122B95663D")
    
public String doubleToString(double d) {
        return convertDouble(null, d);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.679 -0500", hash_original_method = "60FFADFBFC8614534238C3F90209FDC5", hash_generated_method = "CD9EC8ED1D84EEF20DEB8AFBCD0E782C")
    
public void appendDouble(AbstractStringBuilder sb, double d) {
        convertDouble(sb, d);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.683 -0500", hash_original_method = "3B1841CA85DCDA9CC6F8697012DC38A6", hash_generated_method = "5848186623705B9B0A9C31305748F30C")
    
private String convertDouble(AbstractStringBuilder sb, double inputNumber) {
    String ret = new String();
    ret.addTaint(sb.getTaint());
    ret.addTaint(inputNumber);
    return ret; 
    /*
        long inputNumberBits = Double.doubleToRawLongBits(inputNumber);
        boolean positive = (inputNumberBits & Double.SIGN_MASK) == 0;
        int e = (int) ((inputNumberBits & Double.EXPONENT_MASK) >> Double.MANTISSA_BITS);
        long f = inputNumberBits & Double.MANTISSA_MASK;
        boolean mantissaIsZero = f == 0;

        String quickResult = null;
        if (e == 2047) {
            if (mantissaIsZero) {
                quickResult = positive ? "Infinity" : "-Infinity";
            } else {
                quickResult = "NaN";
            }
        } else if (e == 0) {
            if (mantissaIsZero) {
                quickResult = positive ? "0.0" : "-0.0";
            } else if (f == 1) {
                // special case to increase precision even though 2 * Double.MIN_VALUE is 1.0e-323
                quickResult = positive ? "4.9E-324" : "-4.9E-324";
            }
        }
        if (quickResult != null) {
            return resultOrSideEffect(sb, quickResult);
        }

        int p = Double.EXPONENT_BIAS + Double.MANTISSA_BITS; // the power offset (precision)
        int pow;
        int numBits = Double.MANTISSA_BITS;
        if (e == 0) {
            pow = 1 - p; // a denormalized number
            long ff = f;
            while ((ff & 0x0010000000000000L) == 0) {
                ff = ff << 1;
                numBits--;
            }
        } else {
            // 0 < e < 2047
            // a "normalized" number
            f = f | 0x0010000000000000L;
            pow = e - p;
        }

        firstK = digitCount = 0;
        if (-59 < pow && pow < 6 || (pow == -59 && !mantissaIsZero)) {
            longDigitGenerator(f, pow, e == 0, mantissaIsZero, numBits);
        } else {
            bigIntDigitGenerator(f, pow, e == 0, numBits);
        }
        AbstractStringBuilder dst = (sb != null) ? sb : new StringBuilder(26);
        if (inputNumber >= 1e7D || inputNumber <= -1e7D
                || (inputNumber > -1e-3D && inputNumber < 1e-3D)) {
            freeFormatExponential(dst, positive);
        } else {
            freeFormat(dst, positive);
        }
        return (sb != null) ? null : dst.toString();
        */
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.685 -0500", hash_original_method = "2E0F3580AFBA548A22C88B300D06F425", hash_generated_method = "0226850FC0A373006994FC1BF3B248F6")
    
public String floatToString(float f) {
        return convertFloat(null, f);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.688 -0500", hash_original_method = "A5528970A4B6C3EDBBDAB69CF73AE9A3", hash_generated_method = "8FABAB0166BFE09DCEC037AE095C10A4")
    
public void appendFloat(AbstractStringBuilder sb, float f) {
        convertFloat(sb, f);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.692 -0500", hash_original_method = "E5DE8038B72ADC299B522ADF153A4152", hash_generated_method = "B2A7C1F6A2239EC1955869A0760FC556")
    
public String convertFloat(AbstractStringBuilder sb, float inputNumber) {
        if (sb == null)
            sb = new StringBuffer();
        
        sb.append0((char)inputNumber);
        return sb.toString();
        /*
        int inputNumberBits = Float.floatToRawIntBits(inputNumber);
        boolean positive = (inputNumberBits & Float.SIGN_MASK) == 0;
        int e = (inputNumberBits & Float.EXPONENT_MASK) >> Float.MANTISSA_BITS;
        int f = inputNumberBits & Float.MANTISSA_MASK;
        boolean mantissaIsZero = f == 0;

        String quickResult = null;
        if (e == 255) {
            if (mantissaIsZero) {
                quickResult = positive ? "Infinity" : "-Infinity";
            } else {
                quickResult = "NaN";
            }
        } else if (e == 0 && mantissaIsZero) {
            quickResult = positive ? "0.0" : "-0.0";
        }
        if (quickResult != null) {
            return resultOrSideEffect(sb, quickResult);
        }

        int p = Float.EXPONENT_BIAS + Float.MANTISSA_BITS; // the power offset (precision)
        int pow;
        int numBits = Float.MANTISSA_BITS;
        if (e == 0) {
            pow = 1 - p; // a denormalized number
            if (f < 8) { // want more precision with smallest values
                f = f << 2;
                pow -= 2;
            }
            int ff = f;
            while ((ff & 0x00800000) == 0) {
                ff = ff << 1;
                numBits--;
            }
        } else {
            // 0 < e < 255
            // a "normalized" number
            f = f | 0x00800000;
            pow = e - p;
        }

        firstK = digitCount = 0;
        if (-59 < pow && pow < 35 || (pow == -59 && !mantissaIsZero)) {
            longDigitGenerator(f, pow, e == 0, mantissaIsZero, numBits);
        } else {
            bigIntDigitGenerator(f, pow, e == 0, numBits);
        }
        AbstractStringBuilder dst = (sb != null) ? sb : new StringBuilder(26);
        if (inputNumber >= 1e7f || inputNumber <= -1e7f
                || (inputNumber > -1e-3f && inputNumber < 1e-3f)) {
                freeFormatExponential(dst, positive);
        } else {
            freeFormat(dst, positive);
        }
        return (sb != null) ? null : dst.toString();
*/
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.695 -0500", hash_original_method = "C9139C7071A5044040591AD73A0078E9", hash_generated_method = "46EC5F47320CB4889A37E8F8FCB7C1B6")
    
private void freeFormatExponential(AbstractStringBuilder sb, boolean positive) {
        int digitIndex = 0;
        if (!positive) {
            sb.append0('-');
        }
        sb.append0((char) ('0' + digits[digitIndex++]));
        sb.append0('.');

        int k = firstK;
        int exponent = k;
        while (true) {
            k--;
            if (digitIndex >= digitCount) {
                break;
            }
            sb.append0((char) ('0' + digits[digitIndex++]));
        }

        if (k == exponent - 1) {
            sb.append0('0');
        }
        sb.append0('E');
        IntegralToString.appendInt(sb, exponent);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.698 -0500", hash_original_method = "81B49BC2D9465FB81325CD1E0D55DA15", hash_generated_method = "D73E1B369B32FBCBFEDAC49BEE1134F1")
    
private void freeFormat(AbstractStringBuilder sb, boolean positive) {
        int digitIndex = 0;
        if (!positive) {
            sb.append0('-');
        }
        int k = firstK;
        if (k < 0) {
            sb.append0('0');
            sb.append0('.');
            for (int i = k + 1; i < 0; ++i) {
                sb.append0('0');
            }
        }
        int U = digits[digitIndex++];
        do {
            if (U != -1) {
                sb.append0((char) ('0' + U));
            } else if (k >= -1) {
                sb.append0('0');
            }
            if (k == 0) {
                sb.append0('.');
            }
            k--;
            U = digitIndex < digitCount ? digits[digitIndex++] : -1;
        } while (U != -1 || k >= -1);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.702 -0500", hash_original_method = "83E7E0138396E030AA4AE60F27CCD6BF", hash_generated_method = "CE87286F710EAF6BF35F0A28E4FD7CB6")
    
    private void bigIntDigitGenerator(long f, int e, boolean isDenormalized, int p){
    	//Formerly a native method
    	addTaint(f);
    	addTaint(e);
    	addTaint(isDenormalized);
    	addTaint(p);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.705 -0500", hash_original_method = "6A17AA5B213AA1683132D90321A5CCE9", hash_generated_method = "6CC7C02F98A2E528A75F213DFC3EA7C7")
    
private void longDigitGenerator(long f, int e, boolean isDenormalized,
            boolean mantissaIsZero, int p) {
        long R, S, M;
        if (e >= 0) {
            M = 1l << e;
            if (!mantissaIsZero) {
                R = f << (e + 1);
                S = 2;
            } else {
                R = f << (e + 2);
                S = 4;
            }
        } else {
            M = 1;
            if (isDenormalized || !mantissaIsZero) {
                R = f << 1;
                S = 1l << (1 - e);
            } else {
                R = f << 2;
                S = 1l << (2 - e);
            }
        }

        int k = (int) Math.ceil((e + p - 1) * invLogOfTenBaseTwo - 1e-10);

        if (k > 0) {
            S = S * MathUtils.LONG_POWERS_OF_TEN[k];
        } else if (k < 0) {
            long scale = MathUtils.LONG_POWERS_OF_TEN[-k];
            R = R * scale;
            M = M == 1 ? scale : M * scale;
        }

        if (R + M > S) { // was M_plus
            firstK = k;
        } else {
            firstK = k - 1;
            R = R * 10;
            M = M * 10;
        }

        boolean low, high;
        int U;
        while (true) {
            // Set U to floor(R/S) and R to the remainder, using *unsigned* 64-bit division
            U = 0;
            for (int i = 3; i >= 0; i--) {
                long remainder = R - (S << i);
                if (remainder >= 0) {
                    R = remainder;
                    U += 1 << i;
                }
            }

            low = R < M; // was M_minus
            high = R + M > S; // was M_plus

            if (low || high) {
                break;
            }
            R = R * 10;
            M = M * 10;
            digits[digitCount++] = U;
        }
        if (low && !high) {
            digits[digitCount++] = U;
        } else if (high && !low) {
            digits[digitCount++] = U + 1;
        } else if ((R << 1) < S) {
            digits[digitCount++] = U;
        } else {
            digits[digitCount++] = U + 1;
        }
    }
}

