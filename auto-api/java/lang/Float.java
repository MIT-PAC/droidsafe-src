package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Float extends Number implements Comparable<Float> {
    private float value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.706 -0400", hash_original_method = "5ED6E2A1D35592501FD060BC19F5CA5B", hash_generated_method = "24AA3CA4F8CE3395467E93A13E3C46C5")
    @DSModeled(DSC.SAFE)
    public Float(float value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.706 -0400", hash_original_method = "F67C36B21D5AC7A6288ABF8CC3CCE46F", hash_generated_method = "77508FBD1A17C0C69337319F11BEDAF9")
    @DSModeled(DSC.SAFE)
    public Float(double value) {
        dsTaint.addTaint(value);
        this.value = (float) value;
        // ---------- Original Method ----------
        //this.value = (float) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.706 -0400", hash_original_method = "4BD76BD235C983014B5B86B98889672F", hash_generated_method = "05BD666DC9BF023E4BE88C0E3E462FBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Float(String string) throws NumberFormatException {
        this(parseFloat(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.706 -0400", hash_original_method = "C4AC6F26EC342AC8CCBAB08E832A244F", hash_generated_method = "F836BF565D04401D27B75AD004E4B300")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Float object) {
        dsTaint.addTaint(object.dsTaint);
        int varEB17148B4676BC6C35C2467C947D57DF_1124942509 = (compare(value, object.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.706 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "4F78E57EE61A27A10E7A632140A3DDA6")
    @DSModeled(DSC.SAFE)
    @Override
    public byte byteValue() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.706 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "02C8EAF77A98DB2CD3BC8AC0566EBE67")
    @DSModeled(DSC.SAFE)
    @Override
    public double doubleValue() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.707 -0400", hash_original_method = "D5A6527E8F740E6B81FAC1E35F94CBE1", hash_generated_method = "A8F2F5401F7B586110C46D06824378DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var28730D7D248D3C9D5827B99D21423EEE_1063325016 = ((object instanceof Float) &&
                (floatToIntBits(this.value) == floatToIntBits(((Float) object).value)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object instanceof Float) &&
                //(floatToIntBits(this.value) == floatToIntBits(((Float) object).value));
    }

    
        public static int floatToIntBits(float value) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int floatToRawIntBits(float value) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.707 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "89D86731B5289C6353CA0DC29E484746")
    @DSModeled(DSC.SAFE)
    @Override
    public float floatValue() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.707 -0400", hash_original_method = "08993E3A95048E3B463477EA75421A52", hash_generated_method = "9522C0AEF6299A4BD778AE31CD842C56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE5ACA7728F015CCC929C8C822BFF9ED9_1057760737 = (floatToIntBits(value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return floatToIntBits(value);
    }

    
        public static float intBitsToFloat(int bits) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.707 -0400", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "7F343EC6551F993ABCCC87486B9C3CD6")
    @DSModeled(DSC.SAFE)
    @Override
    public int intValue() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.708 -0400", hash_original_method = "82C3193F23F6D7770C948A8F860700C8", hash_generated_method = "D38A425BAC52D909ABBBE67146B20859")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInfinite() {
        boolean var505176161675C49889A0D9B13A19DD63_912794261 = (isInfinite(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isInfinite(value);
    }

    
        public static boolean isInfinite(float f) {
        return (f == POSITIVE_INFINITY) || (f == NEGATIVE_INFINITY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.708 -0400", hash_original_method = "9E74C322CF79FFEBE378AFAB98D56D96", hash_generated_method = "05C7D419EC650E9021823E73026D8099")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNaN() {
        boolean varF9DDC5BA77FDA1F62C5E4CA79A063EC0_1573798517 = (isNaN(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isNaN(value);
    }

    
        public static boolean isNaN(float f) {
        return f != f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.708 -0400", hash_original_method = "C9BB01BEFAD51CB3D65FBCA00F38E36E", hash_generated_method = "258C8F0A8E550593F600871FBDCC6C37")
    @DSModeled(DSC.SAFE)
    @Override
    public long longValue() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return (long) value;
    }

    
        public static float parseFloat(String string) throws NumberFormatException {
        return StringToReal.parseFloat(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.708 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "41D347FA9B5B0AF32CD8FBD284185B0B")
    @DSModeled(DSC.SAFE)
    @Override
    public short shortValue() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.709 -0400", hash_original_method = "A363CDE834C704519FC1C85052C83F92", hash_generated_method = "9C396ECFB18E34E847E32C2955888AE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var985E82ADBDDB626BF87F5176FCD5FF12_968667068 = (Float.toString(value));
        return dsTaint.getTaintString();
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

    
    static final int EXPONENT_BIAS = 127;
    static final int EXPONENT_BITS = 9;
    static final int MANTISSA_BITS = 23;
    static final int NON_MANTISSA_BITS = 9;
    static final int SIGN_MASK     = 0x80000000;
    static final int EXPONENT_MASK = 0x7f800000;
    static final int MANTISSA_MASK = 0x007fffff;
    private static final long serialVersionUID = -2671257302660747028L;
    public static final float MAX_VALUE = 3.40282346638528860e+38f;
    public static final float MIN_VALUE = 1.40129846432481707e-45f;
    public static final float NaN = 0.0f / 0.0f;
    public static final float POSITIVE_INFINITY = 1.0f / 0.0f;
    public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;
    public static final float MIN_NORMAL = 1.1754943508222875E-38f;
    public static final int MAX_EXPONENT = 127;
    public static final int MIN_EXPONENT = -126;
    @SuppressWarnings("unchecked") public static final Class<Float> TYPE
            = (Class<Float>) float[].class.getComponentType();
    public static final int SIZE = 32;
}

