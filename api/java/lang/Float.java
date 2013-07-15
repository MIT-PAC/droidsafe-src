package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class Float extends Number implements Comparable<Float> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.747 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "9AC23CAA5D24AAACBEAFEC0133B195BB")

    private float value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.748 -0400", hash_original_method = "5ED6E2A1D35592501FD060BC19F5CA5B", hash_generated_method = "7E03C0D6F54F14B3903353406441D080")
    public  Float(float value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.748 -0400", hash_original_method = "F67C36B21D5AC7A6288ABF8CC3CCE46F", hash_generated_method = "88E8B31744D75DE12514BFC71619AEB7")
    public  Float(double value) {
        this.value = (float) value;
        // ---------- Original Method ----------
        //this.value = (float) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.749 -0400", hash_original_method = "4BD76BD235C983014B5B86B98889672F", hash_generated_method = "FCA7400AA92CFA204DE6C68024EE4330")
    public  Float(String string) throws NumberFormatException {
        this(parseFloat(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.749 -0400", hash_original_method = "C4AC6F26EC342AC8CCBAB08E832A244F", hash_generated_method = "FD4B74DBFBC4F0558CACCC7CC5D138FC")
    public int compareTo(Float object) {
        addTaint(object.getTaint());
        int var054767143750F894747E80D9A9324D76_1679730696 = (compare(value, object.value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316201049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316201049;
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.750 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "EB6B50133C83539DA5DE667F9D0FBE6C")
    @Override
    public byte byteValue() {
        byte varF3F1FD62E8C4F529180D718EF4A7CECE_647972672 = ((byte) value);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_978285874 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_978285874;
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.750 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "C8964B47B2FE5066A88F6703D9EB47D1")
    @Override
    public double doubleValue() {
        double var2063C1608D6E0BAF80249C42E2BE5804_856217197 = (value);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1238626255 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1238626255;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.751 -0400", hash_original_method = "D5A6527E8F740E6B81FAC1E35F94CBE1", hash_generated_method = "48390EBD51AD619EB9D7D8A22F6E871B")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varA2E5D1E0AB9EB3689F999883CC4D1B0C_2000801460 = ((object instanceof Float) &&
                (floatToIntBits(this.value) == floatToIntBits(((Float) object).value)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_454854462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_454854462;
        // ---------- Original Method ----------
        //return (object instanceof Float) &&
                //(floatToIntBits(this.value) == floatToIntBits(((Float) object).value));
    }

    
    @DSModeled(DSC.SAFE)
    public static int floatToIntBits(float value) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static int floatToRawIntBits(float value) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.752 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "1EE88EF8C7381A2E66E134C2E520CC1D")
    @Override
    public float floatValue() {
        float var2063C1608D6E0BAF80249C42E2BE5804_1228763478 = (value);
                float var546ADE640B6EDFBC8A086EF31347E768_907050794 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_907050794;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.752 -0400", hash_original_method = "08993E3A95048E3B463477EA75421A52", hash_generated_method = "3FEA80CFB0F774DCBAFE93778190BFEE")
    @Override
    public int hashCode() {
        int var56724E152D84F94EE82A2A2AC8591848_1773758682 = (floatToIntBits(value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204209282 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204209282;
        // ---------- Original Method ----------
        //return floatToIntBits(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static float intBitsToFloat(int bits) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.753 -0400", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "3C52F67F3BFD6A8BFB979E9BC33D745D")
    @Override
    public int intValue() {
        int varA873F4A71211BFDACBAEFBA0F9FCF91B_1410158650 = ((int) value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052973528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052973528;
        // ---------- Original Method ----------
        //return (int) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.754 -0400", hash_original_method = "82C3193F23F6D7770C948A8F860700C8", hash_generated_method = "51F508D6F6925C78F60EA11FA7970C79")
    public boolean isInfinite() {
        boolean varED07AD9C4CE3E6B7E975E781387699CA_2116751725 = (isInfinite(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1364381045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1364381045;
        // ---------- Original Method ----------
        //return isInfinite(value);
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean isInfinite(float f) {
        return (f == POSITIVE_INFINITY) || (f == NEGATIVE_INFINITY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.754 -0400", hash_original_method = "9E74C322CF79FFEBE378AFAB98D56D96", hash_generated_method = "160DFE23B1348DE610874BC47CF295AE")
    public boolean isNaN() {
        boolean varA99476A90E68FD60B10540ABE2E1DC0D_1044811095 = (isNaN(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_238184632 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_238184632;
        // ---------- Original Method ----------
        //return isNaN(value);
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean isNaN(float f) {
        return f != f;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.755 -0400", hash_original_method = "C9BB01BEFAD51CB3D65FBCA00F38E36E", hash_generated_method = "CB60CC5D635E73F1CE3C9FB2D21792BD")
    @Override
    public long longValue() {
        long varFB2F999141A9BFF686902BF4F0A9690D_1509270584 = ((long) value);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2134800479 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2134800479;
        // ---------- Original Method ----------
        //return (long) value;
    }

    
        public static float parseFloat(String string) throws NumberFormatException {
        return StringToReal.parseFloat(string);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.756 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "8F7C79E93EB3D7A1CDC611877641C2CB")
    @Override
    public short shortValue() {
        short var6C672D319E59CBACFBF678626FD3727E_96845486 = ((short) value);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1573285557 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1573285557;
        // ---------- Original Method ----------
        //return (short) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.756 -0400", hash_original_method = "A363CDE834C704519FC1C85052C83F92", hash_generated_method = "089AD7E031E6B6E786DC68D38CC9D94D")
    @Override
    public String toString() {
String var1670CC6E6AAA264EB645B58AB0074081_1887096770 =         Float.toString(value);
        var1670CC6E6AAA264EB645B58AB0074081_1887096770.addTaint(taint);
        return var1670CC6E6AAA264EB645B58AB0074081_1887096770;
        // ---------- Original Method ----------
        //return Float.toString(value);
    }

    
        public static String toString(float f) {
        return RealToString.getInstance().floatToString(f);
    }

    
        public static Float valueOf(String string) throws NumberFormatException {
        return parseFloat(string);
    }

    
        public static int compare(float float1, float float2) {
        if (float1 > float2) {
            return 1;
        }
        if (float2 > float1) {
            return -1;
        }
        if (float1 == float2 && 0.0f != float1) {
            return 0;
        }
        if (isNaN(float1)) {
            if (isNaN(float2)) {
                return 0;
            }
            return 1;
        } else if (isNaN(float2)) {
            return -1;
        }
        int f1 = floatToRawIntBits(float1);
        int f2 = floatToRawIntBits(float2);
        return (f1 >> 31) - (f2 >> 31);
    }

    
        public static Float valueOf(float f) {
        return new Float(f);
    }

    
        public static String toHexString(float f) {
        if (f != f) {
            return "NaN";
        }
        if (f == POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (f == NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        int bitValue = floatToIntBits(f);
        boolean negative = (bitValue & 0x80000000) != 0;
        int exponent = (bitValue & 0x7f800000) >>> 23;
        int significand = (bitValue & 0x007FFFFF) << 1;
        if (exponent == 0 && significand == 0) {
            return (negative ? "-0x0.0p0" : "0x0.0p0");
        }
        StringBuilder hexString = new StringBuilder(10);
        if (negative) {
            hexString.append("-0x");
        } else {
            hexString.append("0x");
        }
        if (exponent == 0) { 
            hexString.append("0.");
            int fractionDigits = 6;
            while ((significand != 0) && ((significand & 0xF) == 0)) {
                significand >>>= 4;
                fractionDigits--;
            }
            String hexSignificand = Integer.toHexString(significand);
            if (significand != 0 && fractionDigits > hexSignificand.length()) {
                int digitDiff = fractionDigits - hexSignificand.length();
                while (digitDiff-- != 0) {
                    hexString.append('0');
                }
            }
            hexString.append(hexSignificand);
            hexString.append("p-126");
        } else { 
            hexString.append("1.");
            int fractionDigits = 6;
            while ((significand != 0) && ((significand & 0xF) == 0)) {
                significand >>>= 4;
                fractionDigits--;
            }
            String hexSignificand = Integer.toHexString(significand);
            if (significand != 0 && fractionDigits > hexSignificand.length()) {
                int digitDiff = fractionDigits - hexSignificand.length();
                while (digitDiff-- != 0) {
                    hexString.append('0');
                }
            }
            hexString.append(hexSignificand);
            hexString.append('p');
            hexString.append(exponent - 127);
        }
        return hexString.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.759 -0400", hash_original_field = "384F8B7F5C6BE251AD68E2602922C3A8", hash_generated_field = "2D74B2AF393FD57B1253D83587B03C3D")

    static final int EXPONENT_BIAS = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.759 -0400", hash_original_field = "84F52B227BEE03286EC42E8AD119D48F", hash_generated_field = "AAB44785F4FC3A37C42CA63B6A8EBE86")

    static final int EXPONENT_BITS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.759 -0400", hash_original_field = "AD9B47D4FE10768CD71396EF07D60810", hash_generated_field = "F67817DD7050153A96F45168E72D8F28")

    static final int MANTISSA_BITS = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.759 -0400", hash_original_field = "27E2800227F4747B7959AAEDCE8663FF", hash_generated_field = "35E165A48A70B8CCA5272FC3BE589E43")

    static final int NON_MANTISSA_BITS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.759 -0400", hash_original_field = "9CFFA14BFD2D5097A7E589ABCD750E96", hash_generated_field = "7094B89EE6D925DFA81EF867594CF0A9")

    static final int SIGN_MASK = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.760 -0400", hash_original_field = "4946B44F1099FCDBB8B09EA5A800FF71", hash_generated_field = "D091E878ED0F3CCC802CE44713C89F6E")

    static final int EXPONENT_MASK = 0x7f800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.760 -0400", hash_original_field = "3574882399A820C9DCC5F5F6F3013C15", hash_generated_field = "3A1DB9D1750D6BCC0EE5312BC8121235")

    static final int MANTISSA_MASK = 0x007fffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.760 -0400", hash_original_field = "5F38EBC3813CC9873C2031BB43E85838", hash_generated_field = "1967804242F606EDCF5ADE6EBC54C263")

    private static final long serialVersionUID = -2671257302660747028L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.760 -0400", hash_original_field = "A6C775E64EB78E8EDCB22022B817DD4E", hash_generated_field = "64A78D592CBFAAAD64B3A3BFB1932908")

    public static final float MAX_VALUE = 3.40282346638528860e+38f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.760 -0400", hash_original_field = "02D1C91351F2B00784DC77986A6995CF", hash_generated_field = "4A827F8491540AF52FD9F8C6E5AEB2A2")

    public static final float MIN_VALUE = 1.40129846432481707e-45f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.761 -0400", hash_original_field = "157E943E41E08666E1446F270B79F399", hash_generated_field = "C60CF7E907A2A964678CDF2826A00539")

    public static final float NaN = 0.0f / 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.761 -0400", hash_original_field = "507ABFCD8DB48A73929AEA771130AF7C", hash_generated_field = "489A915079CFDC9521642D78AC79C490")

    public static final float POSITIVE_INFINITY = 1.0f / 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.761 -0400", hash_original_field = "CA250B2374E8E4CA7260412117B2BCDA", hash_generated_field = "0A0A6DC04A00ACB8142143545EFE7514")

    public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.761 -0400", hash_original_field = "BBD46F884793CEDE0E9EC33FC37C2B13", hash_generated_field = "17572F678E5EEF0D46D3BBCC6454815E")

    public static final float MIN_NORMAL = 1.1754943508222875E-38f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.761 -0400", hash_original_field = "362F1B13BCA0AB3C56174228B6502CCE", hash_generated_field = "12C402989413083FF31BD33A94337571")

    public static final int MAX_EXPONENT = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.761 -0400", hash_original_field = "5DAEF7C06499EBE478AC71AF3A2F92C1", hash_generated_field = "EC1E80AD9830FFEA4C4F22313425865A")

    public static final int MIN_EXPONENT = -126;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.762 -0400", hash_original_field = "7E052C221105FBC7D4CA10CB47B93A91", hash_generated_field = "42120EDB27D6BEEDC5C3C0CA73234E89")

    @SuppressWarnings("unchecked")
    public static final Class<Float> TYPE
            = (Class<Float>) float[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.762 -0400", hash_original_field = "2ADF4761385B682BC0DA2831DB6315E2", hash_generated_field = "63FA0385596F5F13183B5684F35B159F")

    public static final int SIZE = 32;
}

