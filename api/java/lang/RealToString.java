package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.math.MathUtils;

final class RealToString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.235 -0400", hash_original_field = "9ABBD36D7ACD664753616E6F0C45ED20", hash_generated_field = "6D9BB978CBD3D3FD82983DAB50AF5B36")

    private int firstK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.236 -0400", hash_original_field = "D19261FDC6A043F101704BAE71C83311", hash_generated_field = "50690E06A9DD54E798BAB9384D861132")

    private final int[] digits = new int[64];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.236 -0400", hash_original_field = "FC8A7BC7ABE2BC8420967291A5AC1D9E", hash_generated_field = "A3250AF80A97B4CAE044DFA388B9EA6A")

    private int digitCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.236 -0400", hash_original_method = "F7A95644C563B2D2A217A4C43DE10AFD", hash_generated_method = "169948A49888C1C730B719BC7C95C046")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.237 -0400", hash_original_method = "1884E8ED6DAC8970F9D7F2BC46F506BE", hash_generated_method = "DCE1933FA11F6D8046822A604E6D2AD4")
    public String doubleToString(double d) {
        addTaint(d);
String varF4EEEB4C20BC8ED70835679C92A2BBC0_455954909 =         convertDouble(null, d);
        varF4EEEB4C20BC8ED70835679C92A2BBC0_455954909.addTaint(taint);
        return varF4EEEB4C20BC8ED70835679C92A2BBC0_455954909;
        // ---------- Original Method ----------
        //return convertDouble(null, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.238 -0400", hash_original_method = "60FFADFBFC8614534238C3F90209FDC5", hash_generated_method = "96B881292F90283D20AB0751FFC15BEC")
    public void appendDouble(AbstractStringBuilder sb, double d) {
        addTaint(d);
        addTaint(sb.getTaint());
        convertDouble(sb, d);
        // ---------- Original Method ----------
        //convertDouble(sb, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.240 -0400", hash_original_method = "3B1841CA85DCDA9CC6F8697012DC38A6", hash_generated_method = "F30B5F8262CA35D36A3CAEA79741AF76")
    private String convertDouble(AbstractStringBuilder sb, double inputNumber) {
        addTaint(inputNumber);
        addTaint(sb.getTaint());
        long inputNumberBits = Double.doubleToRawLongBits(inputNumber);
        boolean positive = (inputNumberBits & Double.SIGN_MASK) == 0;
        int e = (int) ((inputNumberBits & Double.EXPONENT_MASK) >> Double.MANTISSA_BITS);
        long f = inputNumberBits & Double.MANTISSA_MASK;
        boolean mantissaIsZero = f == 0;
        String quickResult = null;
    if(e == 2047)        
        {
    if(mantissaIsZero)            
            {
                quickResult = positive ? "Infinity" : "-Infinity";
            } //End block
            else
            {
                quickResult = "NaN";
            } //End block
        } //End block
        else
    if(e == 0)        
        {
    if(mantissaIsZero)            
            {
                quickResult = positive ? "0.0" : "-0.0";
            } //End block
            else
    if(f == 1)            
            {
                quickResult = positive ? "4.9E-324" : "-4.9E-324";
            } //End block
        } //End block
    if(quickResult != null)        
        {
String var9A8B76D48F32C2D137B4298AA9B38EF7_90730737 =             resultOrSideEffect(sb, quickResult);
            var9A8B76D48F32C2D137B4298AA9B38EF7_90730737.addTaint(taint);
            return var9A8B76D48F32C2D137B4298AA9B38EF7_90730737;
        } //End block
        int p = Double.EXPONENT_BIAS + Double.MANTISSA_BITS;
        int pow;
        int numBits = Double.MANTISSA_BITS;
    if(e == 0)        
        {
            pow = 1 - p;
            long ff = f;
            while
((ff & 0x0010000000000000L) == 0)            
            {
                ff = ff << 1;
                numBits--;
            } //End block
        } //End block
        else
        {
            f = f | 0x0010000000000000L;
            pow = e - p;
        } //End block
        firstK = digitCount = 0;
    if(-59 < pow && pow < 6 || (pow == -59 && !mantissaIsZero))        
        {
            longDigitGenerator(f, pow, e == 0, mantissaIsZero, numBits);
        } //End block
        else
        {
            bigIntDigitGenerator(f, pow, e == 0, numBits);
        } //End block
        AbstractStringBuilder dst = (sb != null) ? sb : new StringBuilder(26);
    if(inputNumber >= 1e7D || inputNumber <= -1e7D
                || (inputNumber > -1e-3D && inputNumber < 1e-3D))        
        {
            freeFormatExponential(dst, positive);
        } //End block
        else
        {
            freeFormat(dst, positive);
        } //End block
String var8EEABFE9064AA4A4E48633B57953C96D_1894062126 =         (sb != null) ? null : dst.toString();
        var8EEABFE9064AA4A4E48633B57953C96D_1894062126.addTaint(taint);
        return var8EEABFE9064AA4A4E48633B57953C96D_1894062126;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.242 -0400", hash_original_method = "2E0F3580AFBA548A22C88B300D06F425", hash_generated_method = "3C62F5241B7A461EFBBF178C6742FBE2")
    public String floatToString(float f) {
        addTaint(f);
String varB391F46B8760ED0A83E036BDEFCD27E0_1953274462 =         convertFloat(null, f);
        varB391F46B8760ED0A83E036BDEFCD27E0_1953274462.addTaint(taint);
        return varB391F46B8760ED0A83E036BDEFCD27E0_1953274462;
        // ---------- Original Method ----------
        //return convertFloat(null, f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.242 -0400", hash_original_method = "A5528970A4B6C3EDBBDAB69CF73AE9A3", hash_generated_method = "4C340E7C710E2526B201FB211D0F8A9E")
    public void appendFloat(AbstractStringBuilder sb, float f) {
        addTaint(f);
        addTaint(sb.getTaint());
        convertFloat(sb, f);
        // ---------- Original Method ----------
        //convertFloat(sb, f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.244 -0400", hash_original_method = "E5DE8038B72ADC299B522ADF153A4152", hash_generated_method = "7A0D9FA022DD550B01AEE65FA489E8CF")
    public String convertFloat(AbstractStringBuilder sb, float inputNumber) {
        addTaint(inputNumber);
        addTaint(sb.getTaint());
        int inputNumberBits = Float.floatToRawIntBits(inputNumber);
        boolean positive = (inputNumberBits & Float.SIGN_MASK) == 0;
        int e = (inputNumberBits & Float.EXPONENT_MASK) >> Float.MANTISSA_BITS;
        int f = inputNumberBits & Float.MANTISSA_MASK;
        boolean mantissaIsZero = f == 0;
        String quickResult = null;
    if(e == 255)        
        {
    if(mantissaIsZero)            
            {
                quickResult = positive ? "Infinity" : "-Infinity";
            } //End block
            else
            {
                quickResult = "NaN";
            } //End block
        } //End block
        else
    if(e == 0 && mantissaIsZero)        
        {
            quickResult = positive ? "0.0" : "-0.0";
        } //End block
    if(quickResult != null)        
        {
String var9A8B76D48F32C2D137B4298AA9B38EF7_892643985 =             resultOrSideEffect(sb, quickResult);
            var9A8B76D48F32C2D137B4298AA9B38EF7_892643985.addTaint(taint);
            return var9A8B76D48F32C2D137B4298AA9B38EF7_892643985;
        } //End block
        int p = Float.EXPONENT_BIAS + Float.MANTISSA_BITS;
        int pow;
        int numBits = Float.MANTISSA_BITS;
    if(e == 0)        
        {
            pow = 1 - p;
    if(f < 8)            
            {
                f = f << 2;
                pow -= 2;
            } //End block
            int ff = f;
            while
((ff & 0x00800000) == 0)            
            {
                ff = ff << 1;
                numBits--;
            } //End block
        } //End block
        else
        {
            f = f | 0x00800000;
            pow = e - p;
        } //End block
        firstK = digitCount = 0;
    if(-59 < pow && pow < 35 || (pow == -59 && !mantissaIsZero))        
        {
            longDigitGenerator(f, pow, e == 0, mantissaIsZero, numBits);
        } //End block
        else
        {
            bigIntDigitGenerator(f, pow, e == 0, numBits);
        } //End block
        AbstractStringBuilder dst = (sb != null) ? sb : new StringBuilder(26);
    if(inputNumber >= 1e7f || inputNumber <= -1e7f
                || (inputNumber > -1e-3f && inputNumber < 1e-3f))        
        {
            freeFormatExponential(dst, positive);
        } //End block
        else
        {
            freeFormat(dst, positive);
        } //End block
String var8EEABFE9064AA4A4E48633B57953C96D_1561474954 =         (sb != null) ? null : dst.toString();
        var8EEABFE9064AA4A4E48633B57953C96D_1561474954.addTaint(taint);
        return var8EEABFE9064AA4A4E48633B57953C96D_1561474954;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.245 -0400", hash_original_method = "C9139C7071A5044040591AD73A0078E9", hash_generated_method = "DF0DA0D72AB2EDCC9146BC22E27677F0")
    private void freeFormatExponential(AbstractStringBuilder sb, boolean positive) {
        addTaint(positive);
        addTaint(sb.getTaint());
        int digitIndex = 0;
    if(!positive)        
        {
            sb.append0('-');
        } //End block
        sb.append0((char) ('0' + digits[digitIndex++]));
        sb.append0('.');
        int k = firstK;
        int exponent = k;
        while
(true)        
        {
            k--;
    if(digitIndex >= digitCount)            
            {
                break;
            } //End block
            sb.append0((char) ('0' + digits[digitIndex++]));
        } //End block
    if(k == exponent - 1)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.246 -0400", hash_original_method = "81B49BC2D9465FB81325CD1E0D55DA15", hash_generated_method = "F75125C491EFD4B5CF589E85703570C4")
    private void freeFormat(AbstractStringBuilder sb, boolean positive) {
        addTaint(positive);
        addTaint(sb.getTaint());
        int digitIndex = 0;
    if(!positive)        
        {
            sb.append0('-');
        } //End block
        int k = firstK;
    if(k < 0)        
        {
            sb.append0('0');
            sb.append0('.');
for(int i = k + 1;i < 0;++i)
            {
                sb.append0('0');
            } //End block
        } //End block
        int U = digits[digitIndex++];
        do {
            {
    if(U != -1)                
                {
                    sb.append0((char) ('0' + U));
                } //End block
                else
    if(k >= -1)                
                {
                    sb.append0('0');
                } //End block
    if(k == 0)                
                {
                    sb.append0('.');
                } //End block
                k--;
                U = digitIndex < digitCount ? digits[digitIndex++] : -1;
            } //End block
} while (U != -1 || k >= -1);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.247 -0400", hash_original_method = "83E7E0138396E030AA4AE60F27CCD6BF", hash_generated_method = "E4714EA4E71BB41E4DA00CDB72CD4BD6")
    private void bigIntDigitGenerator(long f, int e, boolean isDenormalized, int p) {
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.251 -0400", hash_original_method = "6A17AA5B213AA1683132D90321A5CCE9", hash_generated_method = "E43B3BEE7A9C7BCE6E3CD8D745468F89")
    private void longDigitGenerator(long f, int e, boolean isDenormalized,
            boolean mantissaIsZero, int p) {
        addTaint(p);
        addTaint(mantissaIsZero);
        addTaint(isDenormalized);
        addTaint(e);
        addTaint(f);
        long R;
        long S;
        long M;
    if(e >= 0)        
        {
            M = 1l << e;
    if(!mantissaIsZero)            
            {
                R = f << (e + 1);
                S = 2;
            } //End block
            else
            {
                R = f << (e + 2);
                S = 4;
            } //End block
        } //End block
        else
        {
            M = 1;
    if(isDenormalized || !mantissaIsZero)            
            {
                R = f << 1;
                S = 1l << (1 - e);
            } //End block
            else
            {
                R = f << 2;
                S = 1l << (2 - e);
            } //End block
        } //End block
        int k = (int) Math.ceil((e + p - 1) * invLogOfTenBaseTwo - 1e-10);
    if(k > 0)        
        {
            S = S * MathUtils.LONG_POWERS_OF_TEN[k];
        } //End block
        else
    if(k < 0)        
        {
            long scale = MathUtils.LONG_POWERS_OF_TEN[-k];
            R = R * scale;
            M = M == 1 ? scale : M * scale;
        } //End block
    if(R + M > S)        
        {
            firstK = k;
        } //End block
        else
        {
            firstK = k - 1;
            R = R * 10;
            M = M * 10;
        } //End block
        boolean low;
        boolean high;
        int U;
        while
(true)        
        {
            U = 0;
for(int i = 3;i >= 0;i--)
            {
                long remainder = R - (S << i);
    if(remainder >= 0)                
                {
                    R = remainder;
                    U += 1 << i;
                } //End block
            } //End block
            low = R < M;
            high = R + M > S;
    if(low || high)            
            {
                break;
            } //End block
            R = R * 10;
            M = M * 10;
            digits[digitCount++] = U;
        } //End block
    if(low && !high)        
        {
            digits[digitCount++] = U;
        } //End block
        else
    if(high && !low)        
        {
            digits[digitCount++] = U + 1;
        } //End block
        else
    if((R << 1) < S)        
        {
            digits[digitCount++] = U;
        } //End block
        else
        {
            digits[digitCount++] = U + 1;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.252 -0400", hash_original_field = "2F77789CC0DAB0E5A1919C7EEAB90978", hash_generated_field = "CB87C311F6043A6FA9F065A81B47C7CD")

    private static final double invLogOfTenBaseTwo = Math.log(2.0) / Math.log(10.0);
}

