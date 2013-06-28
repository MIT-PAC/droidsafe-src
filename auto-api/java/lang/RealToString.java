package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.math.MathUtils;

final class RealToString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.562 -0400", hash_original_field = "9ABBD36D7ACD664753616E6F0C45ED20", hash_generated_field = "6D9BB978CBD3D3FD82983DAB50AF5B36")

    private int firstK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.562 -0400", hash_original_field = "D19261FDC6A043F101704BAE71C83311", hash_generated_field = "50690E06A9DD54E798BAB9384D861132")

    private final int[] digits = new int[64];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.562 -0400", hash_original_field = "FC8A7BC7ABE2BC8420967291A5AC1D9E", hash_generated_field = "A3250AF80A97B4CAE044DFA388B9EA6A")

    private int digitCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.563 -0400", hash_original_method = "F7A95644C563B2D2A217A4C43DE10AFD", hash_generated_method = "169948A49888C1C730B719BC7C95C046")
    private  RealToString() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.563 -0400", hash_original_method = "1884E8ED6DAC8970F9D7F2BC46F506BE", hash_generated_method = "B42A8C4BD15320CF78C39B3224963A04")
    public String doubleToString(double d) {
        String varB4EAC82CA7396A68D541C85D26508E83_558437787 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_558437787 = convertDouble(null, d);
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_558437787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_558437787;
        // ---------- Original Method ----------
        //return convertDouble(null, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.564 -0400", hash_original_method = "60FFADFBFC8614534238C3F90209FDC5", hash_generated_method = "6F6CB68B08DB53031C03A376136229F9")
    public void appendDouble(AbstractStringBuilder sb, double d) {
        convertDouble(sb, d);
        addTaint(sb.getTaint());
        addTaint(d);
        // ---------- Original Method ----------
        //convertDouble(sb, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.565 -0400", hash_original_method = "3B1841CA85DCDA9CC6F8697012DC38A6", hash_generated_method = "91996B83EF98D372F39743E7DB2E00C7")
    private String convertDouble(AbstractStringBuilder sb, double inputNumber) {
        String varB4EAC82CA7396A68D541C85D26508E83_1824548726 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2002386318 = null; //Variable for return #2
        long inputNumberBits = Double.doubleToRawLongBits(inputNumber);
        boolean positive = (inputNumberBits & Double.SIGN_MASK) == 0;
        int e = (int) ((inputNumberBits & Double.EXPONENT_MASK) >> Double.MANTISSA_BITS);
        long f = inputNumberBits & Double.MANTISSA_MASK;
        boolean mantissaIsZero = f == 0;
        String quickResult = null;
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
            varB4EAC82CA7396A68D541C85D26508E83_1824548726 = resultOrSideEffect(sb, quickResult);
        } //End block
        int p = Double.EXPONENT_BIAS + Double.MANTISSA_BITS;
        int pow;
        int numBits = Double.MANTISSA_BITS;
        {
            pow = 1 - p;
            long ff = f;
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
        varB4EAC82CA7396A68D541C85D26508E83_2002386318 = (sb != null) ? null : dst.toString();
        addTaint(sb.getTaint());
        addTaint(inputNumber);
        String varA7E53CE21691AB073D9660D615818899_1675477023; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1675477023 = varB4EAC82CA7396A68D541C85D26508E83_1824548726;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1675477023 = varB4EAC82CA7396A68D541C85D26508E83_2002386318;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1675477023.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1675477023;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.567 -0400", hash_original_method = "2E0F3580AFBA548A22C88B300D06F425", hash_generated_method = "519DF9513BE47D0DCA4326918A3C4CAD")
    public String floatToString(float f) {
        String varB4EAC82CA7396A68D541C85D26508E83_119369140 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_119369140 = convertFloat(null, f);
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_119369140.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_119369140;
        // ---------- Original Method ----------
        //return convertFloat(null, f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.567 -0400", hash_original_method = "A5528970A4B6C3EDBBDAB69CF73AE9A3", hash_generated_method = "3440F8A62C477EB04CD42815519F7650")
    public void appendFloat(AbstractStringBuilder sb, float f) {
        convertFloat(sb, f);
        addTaint(sb.getTaint());
        addTaint(f);
        // ---------- Original Method ----------
        //convertFloat(sb, f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.569 -0400", hash_original_method = "E5DE8038B72ADC299B522ADF153A4152", hash_generated_method = "740E5176FFA27ED22EF00EE9B38BA68D")
    public String convertFloat(AbstractStringBuilder sb, float inputNumber) {
        String varB4EAC82CA7396A68D541C85D26508E83_714442967 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_654333207 = null; //Variable for return #2
        int inputNumberBits = Float.floatToRawIntBits(inputNumber);
        boolean positive = (inputNumberBits & Float.SIGN_MASK) == 0;
        int e = (inputNumberBits & Float.EXPONENT_MASK) >> Float.MANTISSA_BITS;
        int f = inputNumberBits & Float.MANTISSA_MASK;
        boolean mantissaIsZero = f == 0;
        String quickResult = null;
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
            varB4EAC82CA7396A68D541C85D26508E83_714442967 = resultOrSideEffect(sb, quickResult);
        } //End block
        int p = Float.EXPONENT_BIAS + Float.MANTISSA_BITS;
        int pow;
        int numBits = Float.MANTISSA_BITS;
        {
            pow = 1 - p;
            {
                f = f << 2;
                pow -= 2;
            } //End block
            int ff = f;
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
        varB4EAC82CA7396A68D541C85D26508E83_654333207 = (sb != null) ? null : dst.toString();
        addTaint(sb.getTaint());
        addTaint(inputNumber);
        String varA7E53CE21691AB073D9660D615818899_1666153374; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1666153374 = varB4EAC82CA7396A68D541C85D26508E83_714442967;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1666153374 = varB4EAC82CA7396A68D541C85D26508E83_654333207;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1666153374.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1666153374;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.570 -0400", hash_original_method = "C9139C7071A5044040591AD73A0078E9", hash_generated_method = "EF84AA1351762C7ADDDC52DAE48EF704")
    private void freeFormatExponential(AbstractStringBuilder sb, boolean positive) {
        int digitIndex = 0;
        {
            sb.append0('-');
        } //End block
        sb.append0((char) ('0' + digits[digitIndex++]));
        sb.append0('.');
        int k = firstK;
        int exponent = k;
        {
            sb.append0((char) ('0' + digits[digitIndex++]));
        } //End block
        {
            sb.append0('0');
        } //End block
        sb.append0('E');
        IntegralToString.appendInt(sb, exponent);
        addTaint(sb.getTaint());
        addTaint(positive);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.570 -0400", hash_original_method = "81B49BC2D9465FB81325CD1E0D55DA15", hash_generated_method = "349944AD9F7407C08C351E94F437DB11")
    private void freeFormat(AbstractStringBuilder sb, boolean positive) {
        int digitIndex = 0;
        {
            sb.append0('-');
        } //End block
        int k = firstK;
        {
            sb.append0('0');
            sb.append0('.');
            {
                int i = k + 1;
                {
                    sb.append0('0');
                } //End block
            } //End collapsed parenthetic
        } //End block
        int U = digits[digitIndex++];
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
        addTaint(sb.getTaint());
        addTaint(positive);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.571 -0400", hash_original_method = "83E7E0138396E030AA4AE60F27CCD6BF", hash_generated_method = "E4714EA4E71BB41E4DA00CDB72CD4BD6")
    private void bigIntDigitGenerator(long f, int e, boolean isDenormalized, int p) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.572 -0400", hash_original_method = "6A17AA5B213AA1683132D90321A5CCE9", hash_generated_method = "A7F720FD15004E6997EE550F2C11FD44")
    private void longDigitGenerator(long f, int e, boolean isDenormalized,
            boolean mantissaIsZero, int p) {
        long R;
        long S;
        long M;
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
        int k = (int) Math.ceil((e + p - 1) * invLogOfTenBaseTwo - 1e-10);
        {
            S = S * MathUtils.LONG_POWERS_OF_TEN[k];
        } //End block
        {
            long scale = MathUtils.LONG_POWERS_OF_TEN[-k];
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
        boolean low;
        boolean high;
        int U;
        {
            U = 0;
            {
                int i = 3;
                {
                    long remainder = R - (S << i);
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
        addTaint(f);
        addTaint(e);
        addTaint(isDenormalized);
        addTaint(mantissaIsZero);
        addTaint(p);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.573 -0400", hash_original_field = "2D2E92A8D0328A9801B0413D209B9EF9", hash_generated_field = "9DCB2A0234839FFA438E5D31EF7751AF")

    private static final ThreadLocal<RealToString> INSTANCE = new ThreadLocal<RealToString>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.573 -0400", hash_original_method = "9364A7477DF2F9BBB2EF3C35EE7A5D92", hash_generated_method = "6879AD8D085EBF57CA55A5F59F935FBD")
        @Override
        protected RealToString initialValue() {
            RealToString varB4EAC82CA7396A68D541C85D26508E83_488269211 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_488269211 = new RealToString();
            varB4EAC82CA7396A68D541C85D26508E83_488269211.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_488269211;
            // ---------- Original Method ----------
            //return new RealToString();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.573 -0400", hash_original_field = "2F77789CC0DAB0E5A1919C7EEAB90978", hash_generated_field = "CB87C311F6043A6FA9F065A81B47C7CD")

    private static final double invLogOfTenBaseTwo = Math.log(2.0) / Math.log(10.0);
}

