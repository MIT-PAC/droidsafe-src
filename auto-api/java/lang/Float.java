package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Float extends Number implements Comparable<Float> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.710 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "9AC23CAA5D24AAACBEAFEC0133B195BB")

    private float value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.710 -0400", hash_original_method = "5ED6E2A1D35592501FD060BC19F5CA5B", hash_generated_method = "7E03C0D6F54F14B3903353406441D080")
    public  Float(float value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.711 -0400", hash_original_method = "F67C36B21D5AC7A6288ABF8CC3CCE46F", hash_generated_method = "88E8B31744D75DE12514BFC71619AEB7")
    public  Float(double value) {
        this.value = (float) value;
        // ---------- Original Method ----------
        //this.value = (float) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.711 -0400", hash_original_method = "4BD76BD235C983014B5B86B98889672F", hash_generated_method = "FCA7400AA92CFA204DE6C68024EE4330")
    public  Float(String string) throws NumberFormatException {
        this(parseFloat(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.711 -0400", hash_original_method = "C4AC6F26EC342AC8CCBAB08E832A244F", hash_generated_method = "6F3E27552174F1F1C31C50AB6CFF5708")
    public int compareTo(Float object) {
        int varEB17148B4676BC6C35C2467C947D57DF_171280459 = (compare(value, object.value));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376161055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376161055;
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.711 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "377EEA466B52A83AC99909A54FEE202B")
    @Override
    public byte byteValue() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1130799841 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1130799841;
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.712 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "AB7A0DF7C09AFFC509FD699AC8535F9D")
    @Override
    public double doubleValue() {
        double varE8CD7DA078A86726031AD64F35F5A6C0_161099585 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_161099585;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.712 -0400", hash_original_method = "D5A6527E8F740E6B81FAC1E35F94CBE1", hash_generated_method = "51AAC7DD4FBFC28845F1C77CB64D17F2")
    @Override
    public boolean equals(Object object) {
        boolean var28730D7D248D3C9D5827B99D21423EEE_1915700525 = ((object instanceof Float) &&
                (floatToIntBits(this.value) == floatToIntBits(((Float) object).value)));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1227217656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1227217656;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.719 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "E667E1FD226FAF1FABFB941D63E87CCC")
    @Override
    public float floatValue() {
        float var546ADE640B6EDFBC8A086EF31347E768_1834886563 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1834886563;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.719 -0400", hash_original_method = "08993E3A95048E3B463477EA75421A52", hash_generated_method = "131F52746A4FEF73BF216B9EE9C1602C")
    @Override
    public int hashCode() {
        int varE5ACA7728F015CCC929C8C822BFF9ED9_1058121355 = (floatToIntBits(value));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701919107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701919107;
        // ---------- Original Method ----------
        //return floatToIntBits(value);
    }

    
        public static float intBitsToFloat(int bits) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.719 -0400", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "525A3B0A7DAA4C6372404040D50402B2")
    @Override
    public int intValue() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830271434 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830271434;
        // ---------- Original Method ----------
        //return (int) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.724 -0400", hash_original_method = "82C3193F23F6D7770C948A8F860700C8", hash_generated_method = "D505F30AD43E62D56836A911CB02752F")
    public boolean isInfinite() {
        boolean var505176161675C49889A0D9B13A19DD63_483166254 = (isInfinite(value));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1664654082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1664654082;
        // ---------- Original Method ----------
        //return isInfinite(value);
    }

    
        public static boolean isInfinite(float f) {
        return (f == POSITIVE_INFINITY) || (f == NEGATIVE_INFINITY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.725 -0400", hash_original_method = "9E74C322CF79FFEBE378AFAB98D56D96", hash_generated_method = "1EF21CF8F2570C47D2AB55D22C34D7B0")
    public boolean isNaN() {
        boolean varF9DDC5BA77FDA1F62C5E4CA79A063EC0_1678590809 = (isNaN(value));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1850703519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1850703519;
        // ---------- Original Method ----------
        //return isNaN(value);
    }

    
        public static boolean isNaN(float f) {
        return f != f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.725 -0400", hash_original_method = "C9BB01BEFAD51CB3D65FBCA00F38E36E", hash_generated_method = "68BBB8842F3C9ECE47CC55C78CC8047B")
    @Override
    public long longValue() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1407109676 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1407109676;
        // ---------- Original Method ----------
        //return (long) value;
    }

    
        public static float parseFloat(String string) throws NumberFormatException {
        return StringToReal.parseFloat(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.726 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "DBAB830B7A0C8310B30A23BD8E12BCC8")
    @Override
    public short shortValue() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1474620978 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1474620978;
        // ---------- Original Method ----------
        //return (short) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.726 -0400", hash_original_method = "A363CDE834C704519FC1C85052C83F92", hash_generated_method = "480BF97FAB2C207DE76AFDDFD6200B7D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1168376964 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1168376964 = Float.toString(value);
        varB4EAC82CA7396A68D541C85D26508E83_1168376964.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1168376964;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.735 -0400", hash_original_field = "384F8B7F5C6BE251AD68E2602922C3A8", hash_generated_field = "8B8940E0A866D838F95EEF5A42D4956A")

    static int EXPONENT_BIAS = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.735 -0400", hash_original_field = "84F52B227BEE03286EC42E8AD119D48F", hash_generated_field = "C22318BC6EF44315676F05FCD1E4259A")

    static int EXPONENT_BITS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.735 -0400", hash_original_field = "AD9B47D4FE10768CD71396EF07D60810", hash_generated_field = "76B8FBD02814AE836ECD3F844131E171")

    static int MANTISSA_BITS = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.735 -0400", hash_original_field = "27E2800227F4747B7959AAEDCE8663FF", hash_generated_field = "4C6C75D6230C187BA0143B6A1471DA96")

    static int NON_MANTISSA_BITS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.736 -0400", hash_original_field = "9CFFA14BFD2D5097A7E589ABCD750E96", hash_generated_field = "A8818B2F5CAB5DF1C85A1870E51D5703")

    static int SIGN_MASK = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.736 -0400", hash_original_field = "4946B44F1099FCDBB8B09EA5A800FF71", hash_generated_field = "370888F11888A8B885C38F9D8FE579A2")

    static int EXPONENT_MASK = 0x7f800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.736 -0400", hash_original_field = "3574882399A820C9DCC5F5F6F3013C15", hash_generated_field = "4119ED5FCCD3E1AFCC4DEF967B5D3C4C")

    static int MANTISSA_MASK = 0x007fffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.736 -0400", hash_original_field = "5F38EBC3813CC9873C2031BB43E85838", hash_generated_field = "0BBCC62639D8A179E9E647AF5020DA6F")

    private static long serialVersionUID = -2671257302660747028L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.737 -0400", hash_original_field = "A6C775E64EB78E8EDCB22022B817DD4E", hash_generated_field = "64A78D592CBFAAAD64B3A3BFB1932908")

    public static final float MAX_VALUE = 3.40282346638528860e+38f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.738 -0400", hash_original_field = "02D1C91351F2B00784DC77986A6995CF", hash_generated_field = "4A827F8491540AF52FD9F8C6E5AEB2A2")

    public static final float MIN_VALUE = 1.40129846432481707e-45f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.738 -0400", hash_original_field = "157E943E41E08666E1446F270B79F399", hash_generated_field = "C60CF7E907A2A964678CDF2826A00539")

    public static final float NaN = 0.0f / 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.738 -0400", hash_original_field = "507ABFCD8DB48A73929AEA771130AF7C", hash_generated_field = "489A915079CFDC9521642D78AC79C490")

    public static final float POSITIVE_INFINITY = 1.0f / 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.738 -0400", hash_original_field = "CA250B2374E8E4CA7260412117B2BCDA", hash_generated_field = "0A0A6DC04A00ACB8142143545EFE7514")

    public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.738 -0400", hash_original_field = "BBD46F884793CEDE0E9EC33FC37C2B13", hash_generated_field = "17572F678E5EEF0D46D3BBCC6454815E")

    public static final float MIN_NORMAL = 1.1754943508222875E-38f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.738 -0400", hash_original_field = "362F1B13BCA0AB3C56174228B6502CCE", hash_generated_field = "12C402989413083FF31BD33A94337571")

    public static final int MAX_EXPONENT = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.738 -0400", hash_original_field = "5DAEF7C06499EBE478AC71AF3A2F92C1", hash_generated_field = "EC1E80AD9830FFEA4C4F22313425865A")

    public static final int MIN_EXPONENT = -126;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.738 -0400", hash_original_field = "7E052C221105FBC7D4CA10CB47B93A91", hash_generated_field = "42120EDB27D6BEEDC5C3C0CA73234E89")

    @SuppressWarnings("unchecked")
    public static final Class<Float> TYPE
            = (Class<Float>) float[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.738 -0400", hash_original_field = "2ADF4761385B682BC0DA2831DB6315E2", hash_generated_field = "63FA0385596F5F13183B5684F35B159F")

    public static final int SIZE = 32;
}

