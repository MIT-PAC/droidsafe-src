package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public final class Float extends Number implements Comparable<Float> {
    static final int EXPONENT_BIAS = 127;
    static final int EXPONENT_BITS = 9;
    static final int MANTISSA_BITS = 23;
    static final int NON_MANTISSA_BITS = 9;
    static final int SIGN_MASK     = 0x80000000;
    static final int EXPONENT_MASK = 0x7f800000;
    static final int MANTISSA_MASK = 0x007fffff;
    private static final long serialVersionUID = -2671257302660747028L;
    private final float value;
    public static final float MAX_VALUE = 3.40282346638528860e+38f;
    public static final float MIN_VALUE = 1.40129846432481707e-45f;
    public static final float NaN = 0.0f / 0.0f;
    public static final float POSITIVE_INFINITY = 1.0f / 0.0f;
    public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;
    public static final float MIN_NORMAL = 1.1754943508222875E-38f;
    public static final int MAX_EXPONENT = 127;
    public static final int MIN_EXPONENT = -126;
    @SuppressWarnings("unchecked")
    public static final Class<Float> TYPE
            = (Class<Float>) float[].class.getComponentType();
    public static final int SIZE = 32;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.372 -0400", hash_original_method = "5ED6E2A1D35592501FD060BC19F5CA5B", hash_generated_method = "F31D4EDAE3CD44B17E65B51EBDEA9A8A")
    @DSModeled(DSC.SAFE)
    public Float(float value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.374 -0400", hash_original_method = "F67C36B21D5AC7A6288ABF8CC3CCE46F", hash_generated_method = "2A2934B61793073BB2A5F12D2D53E4D0")
    @DSModeled(DSC.SAFE)
    public Float(double value) {
        dsTaint.addTaint(value);
        this.value = (float) value;
        // ---------- Original Method ----------
        //this.value = (float) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.375 -0400", hash_original_method = "4BD76BD235C983014B5B86B98889672F", hash_generated_method = "3CE05DD9569C54E2385E6D94A66CF949")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Float(String string) throws NumberFormatException {
        this(parseFloat(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.386 -0400", hash_original_method = "C4AC6F26EC342AC8CCBAB08E832A244F", hash_generated_method = "7966A59B8970B237E591BF0F859F9908")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Float object) {
        dsTaint.addTaint(object.dsTaint);
        int varEB17148B4676BC6C35C2467C947D57DF_347429883 = (compare(value, object.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.388 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "736992B7E67C3D999A201F9A84C24906")
    @DSModeled(DSC.SAFE)
    @Override
    public byte byteValue() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.390 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "49EEC8EBB7ED6B4F36B5020D75D881E3")
    @DSModeled(DSC.SAFE)
    @Override
    public double doubleValue() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.398 -0400", hash_original_method = "D5A6527E8F740E6B81FAC1E35F94CBE1", hash_generated_method = "8127C218CA5F05012C44D659A1C4DB7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var28730D7D248D3C9D5827B99D21423EEE_468872741 = ((object instanceof Float) &&
                (floatToIntBits(this.value) == floatToIntBits(((Float) object).value)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object instanceof Float) &&
                //(floatToIntBits(this.value) == floatToIntBits(((Float) object).value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.404 -0400", hash_original_method = "1BE13123F187CA3BCB858B3165731809", hash_generated_method = "1074DC43FC95CC923F59D85737BAE4E1")
    public static int floatToIntBits(float value) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return (int)value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.406 -0400", hash_original_method = "EB451C75DEB4DC141340548D13E4DED5", hash_generated_method = "C028B7531654B9C17DF31DF077D6127B")
    public static int floatToRawIntBits(float value) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return (int)value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.411 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "DB3CE558B9651E2B1B184E75E5F9E192")
    @DSModeled(DSC.SAFE)
    @Override
    public float floatValue() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.413 -0400", hash_original_method = "08993E3A95048E3B463477EA75421A52", hash_generated_method = "BB781581A8E5D193C66E6EC4DEE024A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE5ACA7728F015CCC929C8C822BFF9ED9_1562445004 = (floatToIntBits(value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return floatToIntBits(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.418 -0400", hash_original_method = "7A9B6232B794E3EC95C6AF3043D79891", hash_generated_method = "B45EA0CD3AA3496424530352B16675DE")
    public static float intBitsToFloat(int bits) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return (float)bits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.427 -0400", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "50D86FD909925B6CFB3056BE4427F1CA")
    @DSModeled(DSC.SAFE)
    @Override
    public int intValue() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.431 -0400", hash_original_method = "82C3193F23F6D7770C948A8F860700C8", hash_generated_method = "CF12A395259D7617AF567672576C03E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInfinite() {
        boolean var505176161675C49889A0D9B13A19DD63_1794345792 = (isInfinite(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isInfinite(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.437 -0400", hash_original_method = "F3C86372B308CB7AC0FC99B1DB4B622C", hash_generated_method = "683D8A9E5B30B40DB742F066FBD6598C")
    public static boolean isInfinite(float f) {
        return (f == POSITIVE_INFINITY) || (f == NEGATIVE_INFINITY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.448 -0400", hash_original_method = "9E74C322CF79FFEBE378AFAB98D56D96", hash_generated_method = "033153983B9418029793E6B0B1C8A67F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNaN() {
        boolean varF9DDC5BA77FDA1F62C5E4CA79A063EC0_1932515560 = (isNaN(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isNaN(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.457 -0400", hash_original_method = "797988AA09B377AAD595A673B0C7988B", hash_generated_method = "D920FE10DB13EBBC00F5D9F8CC7066A9")
    public static boolean isNaN(float f) {
        return f != f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.464 -0400", hash_original_method = "C9BB01BEFAD51CB3D65FBCA00F38E36E", hash_generated_method = "D35C73DB99AD5CCC98B431DBDEADE48B")
    @DSModeled(DSC.SAFE)
    @Override
    public long longValue() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return (long) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.473 -0400", hash_original_method = "E332FB0E1CB7130552914B4D301DE791", hash_generated_method = "5A5D0EA79CAFDCAECA35E7E93C07C205")
    public static float parseFloat(String string) throws NumberFormatException {
        return StringToReal.parseFloat(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.477 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "9D74A9F80DCC02694F100928EBEB58C3")
    @DSModeled(DSC.SAFE)
    @Override
    public short shortValue() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.479 -0400", hash_original_method = "A363CDE834C704519FC1C85052C83F92", hash_generated_method = "CDC311665CABA5CF083A0EF3E78CE378")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var985E82ADBDDB626BF87F5176FCD5FF12_1384832042 = (Float.toString(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Float.toString(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.486 -0400", hash_original_method = "B7E1BCC1B7A5845C5179DE746CBEEF71", hash_generated_method = "D5F9E6B59E5CA5AC8021B7D7B2DC2734")
    public static String toString(float f) {
        return RealToString.getInstance().floatToString(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.490 -0400", hash_original_method = "642ABD7E73780470D384DD3A60166E0E", hash_generated_method = "0A0CF9F1A77E65FC8EAE564F16A81F7F")
    public static Float valueOf(String string) throws NumberFormatException {
        return parseFloat(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.493 -0400", hash_original_method = "437B20A71BAFB5FA99C486D62470A20A", hash_generated_method = "C95305101F8283CD040AC178E99CDFFE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.500 -0400", hash_original_method = "D6416EFEFB750655A8B1DFB2823F2602", hash_generated_method = "63606CBCD564F19C028A0CDFCD104D78")
    public static Float valueOf(float f) {
        return new Float(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.503 -0400", hash_original_method = "10B7F57DA48FEE510D3FE44F096FB152", hash_generated_method = "405BD2A04F5F7B46A12B6DFE15824CCC")
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

    
}


