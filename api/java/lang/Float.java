package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;




import droidsafe.helpers.DSUtils;

public final class Float extends Number implements Comparable<Float> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.945 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "9AC23CAA5D24AAACBEAFEC0133B195BB")

    private float value;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.946 -0400", hash_original_method = "5ED6E2A1D35592501FD060BC19F5CA5B", hash_generated_method = "7E03C0D6F54F14B3903353406441D080")
    public  Float(float value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.946 -0400", hash_original_method = "F67C36B21D5AC7A6288ABF8CC3CCE46F", hash_generated_method = "88E8B31744D75DE12514BFC71619AEB7")
    public  Float(double value) {
        this.value = (float) value;
        // ---------- Original Method ----------
        //this.value = (float) value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.946 -0400", hash_original_method = "4BD76BD235C983014B5B86B98889672F", hash_generated_method = "FCA7400AA92CFA204DE6C68024EE4330")
    public  Float(String string) throws NumberFormatException {
        this(parseFloat(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.947 -0400", hash_original_method = "C4AC6F26EC342AC8CCBAB08E832A244F", hash_generated_method = "41EADA3CD3A02EA795D667EA11DF5D13")
    public int compareTo(Float object) {
        addTaint(object.getTaint());
        int var054767143750F894747E80D9A9324D76_1305146190 = (compare(value, object.value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690566981 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690566981;
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.947 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "2598F09440BA55CB09965FB2D8880155")
    @Override
    public byte byteValue() {
        byte varF3F1FD62E8C4F529180D718EF4A7CECE_148833007 = ((byte) value);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_995116107 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_995116107;
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.947 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "5F9200D35D942D0767C139088A7A0DA6")
    @Override
    public double doubleValue() {
        double var2063C1608D6E0BAF80249C42E2BE5804_106875057 = (value);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1827228815 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1827228815;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.948 -0400", hash_original_method = "D5A6527E8F740E6B81FAC1E35F94CBE1", hash_generated_method = "D7A0C4324A0B9AEEA690BB38F739D202")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varA2E5D1E0AB9EB3689F999883CC4D1B0C_393581687 = ((object instanceof Float) &&
                (floatToIntBits(this.value) == floatToIntBits(((Float) object).value)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_663451058 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_663451058;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.948 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "37B7823DE7D3F2038BA80AAFA4DD0A45")
    @Override
    public float floatValue() {
        float var2063C1608D6E0BAF80249C42E2BE5804_751459806 = (value);
                float var546ADE640B6EDFBC8A086EF31347E768_394128749 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_394128749;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.949 -0400", hash_original_method = "08993E3A95048E3B463477EA75421A52", hash_generated_method = "5A0A2320F0BC7DED2734F5EB5972E249")
    @Override
    public int hashCode() {
        int var56724E152D84F94EE82A2A2AC8591848_586971145 = (floatToIntBits(value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543298001 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543298001;
        // ---------- Original Method ----------
        //return floatToIntBits(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static float intBitsToFloat(int bits) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.949 -0400", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "B6A85943D5F6BA53EAEA3C06114F1B52")
    @Override
    public int intValue() {
        int varA873F4A71211BFDACBAEFBA0F9FCF91B_1120192292 = ((int) value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1931299902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1931299902;
        // ---------- Original Method ----------
        //return (int) value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.949 -0400", hash_original_method = "82C3193F23F6D7770C948A8F860700C8", hash_generated_method = "736A179A71C916F9D241455297000ECF")
    public boolean isInfinite() {
        boolean varED07AD9C4CE3E6B7E975E781387699CA_1072451743 = (isInfinite(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2045014331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2045014331;
        // ---------- Original Method ----------
        //return isInfinite(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isInfinite(float f) {
        return (f == POSITIVE_INFINITY) || (f == NEGATIVE_INFINITY);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.949 -0400", hash_original_method = "9E74C322CF79FFEBE378AFAB98D56D96", hash_generated_method = "6D8930DAB61528DEC3F6F6BA7649AD6B")
    public boolean isNaN() {
        boolean varA99476A90E68FD60B10540ABE2E1DC0D_1099069600 = (isNaN(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_875167231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_875167231;
        // ---------- Original Method ----------
        //return isNaN(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isNaN(float f) {
        return f != f;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.950 -0400", hash_original_method = "C9BB01BEFAD51CB3D65FBCA00F38E36E", hash_generated_method = "D992A118579D6A3BF52CC086D08C63EC")
    @Override
    public long longValue() {
        long varFB2F999141A9BFF686902BF4F0A9690D_911538291 = ((long) value);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1546795747 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1546795747;
        // ---------- Original Method ----------
        //return (long) value;
    }

    
    @DSModeled(DSC.SAFE)
    public static float parseFloat(String string) throws NumberFormatException {
        return StringToReal.parseFloat(string);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.951 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "473D2938B9153E3D00143B6E180BDA66")
    @Override
    public short shortValue() {
        short var6C672D319E59CBACFBF678626FD3727E_41179078 = ((short) value);
                short var4F09DAA9D95BCB166A302407A0E0BABE_622740595 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_622740595;
        // ---------- Original Method ----------
        //return (short) value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.951 -0400", hash_original_method = "A363CDE834C704519FC1C85052C83F92", hash_generated_method = "E03A39A0AB65A6DF94A94F0E42EA30EE")
    @Override
    public String toString() {
String var1670CC6E6AAA264EB645B58AB0074081_1507353848 =         Float.toString(value);
        var1670CC6E6AAA264EB645B58AB0074081_1507353848.addTaint(taint);
        return var1670CC6E6AAA264EB645B58AB0074081_1507353848;
        // ---------- Original Method ----------
        //return Float.toString(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(float f) {
        return RealToString.getInstance().floatToString(f);
    }

    
    @DSModeled(DSC.SAFE)
    public static Float valueOf(String string) throws NumberFormatException {
        return parseFloat(string);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static Float valueOf(float f) {
        return new Float(f);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.952 -0400", hash_original_field = "384F8B7F5C6BE251AD68E2602922C3A8", hash_generated_field = "2D74B2AF393FD57B1253D83587B03C3D")

    static final int EXPONENT_BIAS = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.952 -0400", hash_original_field = "84F52B227BEE03286EC42E8AD119D48F", hash_generated_field = "AAB44785F4FC3A37C42CA63B6A8EBE86")

    static final int EXPONENT_BITS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.952 -0400", hash_original_field = "AD9B47D4FE10768CD71396EF07D60810", hash_generated_field = "F67817DD7050153A96F45168E72D8F28")

    static final int MANTISSA_BITS = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.952 -0400", hash_original_field = "27E2800227F4747B7959AAEDCE8663FF", hash_generated_field = "35E165A48A70B8CCA5272FC3BE589E43")

    static final int NON_MANTISSA_BITS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.952 -0400", hash_original_field = "9CFFA14BFD2D5097A7E589ABCD750E96", hash_generated_field = "7094B89EE6D925DFA81EF867594CF0A9")

    static final int SIGN_MASK = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.952 -0400", hash_original_field = "4946B44F1099FCDBB8B09EA5A800FF71", hash_generated_field = "D091E878ED0F3CCC802CE44713C89F6E")

    static final int EXPONENT_MASK = 0x7f800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "3574882399A820C9DCC5F5F6F3013C15", hash_generated_field = "3A1DB9D1750D6BCC0EE5312BC8121235")

    static final int MANTISSA_MASK = 0x007fffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "5F38EBC3813CC9873C2031BB43E85838", hash_generated_field = "1967804242F606EDCF5ADE6EBC54C263")

    private static final long serialVersionUID = -2671257302660747028L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "A6C775E64EB78E8EDCB22022B817DD4E", hash_generated_field = "64A78D592CBFAAAD64B3A3BFB1932908")

    public static final float MAX_VALUE = 3.40282346638528860e+38f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "02D1C91351F2B00784DC77986A6995CF", hash_generated_field = "4A827F8491540AF52FD9F8C6E5AEB2A2")

    public static final float MIN_VALUE = 1.40129846432481707e-45f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "157E943E41E08666E1446F270B79F399", hash_generated_field = "C60CF7E907A2A964678CDF2826A00539")

    public static final float NaN = 0.0f / 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "507ABFCD8DB48A73929AEA771130AF7C", hash_generated_field = "489A915079CFDC9521642D78AC79C490")

    public static final float POSITIVE_INFINITY = 1.0f / 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "CA250B2374E8E4CA7260412117B2BCDA", hash_generated_field = "0A0A6DC04A00ACB8142143545EFE7514")

    public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "BBD46F884793CEDE0E9EC33FC37C2B13", hash_generated_field = "17572F678E5EEF0D46D3BBCC6454815E")

    public static final float MIN_NORMAL = 1.1754943508222875E-38f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "362F1B13BCA0AB3C56174228B6502CCE", hash_generated_field = "12C402989413083FF31BD33A94337571")

    public static final int MAX_EXPONENT = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "5DAEF7C06499EBE478AC71AF3A2F92C1", hash_generated_field = "EC1E80AD9830FFEA4C4F22313425865A")

    public static final int MIN_EXPONENT = -126;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "7E052C221105FBC7D4CA10CB47B93A91", hash_generated_field = "42120EDB27D6BEEDC5C3C0CA73234E89")

    @SuppressWarnings("unchecked")
    public static final Class<Float> TYPE
            = (Class<Float>) float[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.953 -0400", hash_original_field = "2ADF4761385B682BC0DA2831DB6315E2", hash_generated_field = "63FA0385596F5F13183B5684F35B159F")

    public static final int SIZE = 32;
}

