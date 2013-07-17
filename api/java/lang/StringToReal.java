package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class StringToReal {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.327 -0400", hash_original_method = "50763D5996F4E117B646112682AF8739", hash_generated_method = "50763D5996F4E117B646112682AF8739")
    public StringToReal ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    private static double parseDblImpl(String s, int e) {
        return DSUtils.UNKNOWN_DOUBLE;
    }

    
    @DSModeled(DSC.SAFE)
    private static float parseFltImpl(String s, int e) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    private static NumberFormatException invalidReal(String s, boolean isDouble) {
        throw new NumberFormatException("Invalid " + (isDouble ? "double" : "float") + ": \"" + s + "\"");
    }

    
    private static StringExponentPair initialParse(String s, int length, boolean isDouble) {
        StringExponentPair result = new StringExponentPair();
        if (length == 0) {
            throw invalidReal(s, isDouble);
        }
        result.negative = (s.charAt(0) == '-');
        char c = s.charAt(length - 1);
        if (c == 'D' || c == 'd' || c == 'F' || c == 'f') {
            length--;
            if (length == 0) {
                throw invalidReal(s, isDouble);
            }
        }
        int end = Math.max(s.indexOf('E'), s.indexOf('e'));
        if (end != -1) {
            if (end + 1 == length) {
                throw invalidReal(s, isDouble);
            }
            int exponentOffset = end + 1;
            boolean negativeExponent = false;
            char firstExponentChar = s.charAt(exponentOffset);
            if (firstExponentChar == '+' || firstExponentChar == '-') {
                negativeExponent = (firstExponentChar == '-');
                ++exponentOffset;
            }
            String exponentString = s.substring(exponentOffset, length);
            if (exponentString.isEmpty()) {
                throw invalidReal(s, isDouble);
            }
            for (int i = 0; i < exponentString.length(); ++i) {
                char ch = exponentString.charAt(i);
                if (ch < '0' || ch > '9') {
                    throw invalidReal(s, isDouble);
                }
            }
            try {
                result.e = Integer.parseInt(exponentString);
                if (negativeExponent) {
                    result.e = -result.e;
                }
            } catch (NumberFormatException ex) {
                if (negativeExponent) {
                    result.zero = true;
                } else {
                    result.infinity = true;
                }
                return result;
            }
        } else {
            end = length;
        }
        if (length == 0) {
            throw invalidReal(s, isDouble);
        }
        int start = 0;
        c = s.charAt(start);
        if (c == '-') {
            ++start;
            --length;
            result.negative = true;
        } else if (c == '+') {
            ++start;
            --length;
        }
        if (length == 0) {
            throw invalidReal(s, isDouble);
        }
        int decimal = s.indexOf('.');
        if (decimal > -1) {
            result.e -= end - decimal - 1;
            s = s.substring(start, decimal) + s.substring(decimal + 1, end);
        } else {
            s = s.substring(start, end);
        }
        if ((length = s.length()) == 0) {
            throw invalidReal(s, isDouble);
        }
        end = length;
        while (end > 1 && s.charAt(end - 1) == '0') {
            --end;
        }
        start = 0;
        while (start < end - 1 && s.charAt(start) == '0') {
            start++;
        }
        if (end != length || start != 0) {
            result.e += length - end;
            s = s.substring(start, end);
        }
        final int APPROX_MIN_MAGNITUDE = -359;
        final int MAX_DIGITS = 52;
        length = s.length();
        if (length > MAX_DIGITS && result.e < APPROX_MIN_MAGNITUDE) {
            int d = Math.min(APPROX_MIN_MAGNITUDE - (int) result.e, length - 1);
            s = s.substring(0, length - d);
            result.e += d;
        }
        if (result.e < -1024) {
            result.zero = true;
            return result;
        } else if (result.e > 1024) {
            result.infinity = true;
            return result;
        }
        result.s = s;
        return result;
    }

    
    private static float parseName(String name, boolean isDouble) {
        boolean negative = false;
        int i = 0;
        int length = name.length();
        char firstChar = name.charAt(i);
        if (firstChar == '-') {
            negative = true;
            ++i;
            --length;
        } else if (firstChar == '+') {
            ++i;
            --length;
        }
        if (length == 8 && name.regionMatches(false, i, "Infinity", 0, 8)) {
            return negative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
        if (length == 3 && name.regionMatches(false, i, "NaN", 0, 3)) {
            return Float.NaN;
        }
        throw invalidReal(name, isDouble);
    }

    
    public static double parseDouble(String s) {
        s = s.trim();
        int length = s.length();
        if (length == 0) {
            throw invalidReal(s, true);
        }
        char last = s.charAt(length - 1);
        if (last == 'y' || last == 'N') {
            return parseName(s, true);
        }
        if (s.indexOf("0x") != -1 || s.indexOf("0X") != -1) {
            return HexStringParser.parseDouble(s);
        }
        StringExponentPair info = initialParse(s, length, true);
        if (info.infinity || info.zero) {
            return info.specialValue();
        }
        double result = parseDblImpl(info.s, (int) info.e);
        if (Double.doubleToRawLongBits(result) == 0xffffffffffffffffL) {
            throw invalidReal(s, true);
        }
        return info.negative ? -result : result;
    }

    
    public static float parseFloat(String s) {
        s = s.trim();
        int length = s.length();
        if (length == 0) {
            throw invalidReal(s, false);
        }
        char last = s.charAt(length - 1);
        if (last == 'y' || last == 'N') {
            return parseName(s, false);
        }
        if (s.indexOf("0x") != -1 || s.indexOf("0X") != -1) {
            return HexStringParser.parseFloat(s);
        }
        StringExponentPair info = initialParse(s, length, false);
        if (info.infinity || info.zero) {
            return info.specialValue();
        }
        float result = parseFltImpl(info.s, (int) info.e);
        if (Float.floatToRawIntBits(result) == 0xffffffff) {
            throw invalidReal(s, false);
        }
        return info.negative ? -result : result;
    }

    
    private static final class StringExponentPair {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.330 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "6F3CB884E38CB76988A52AA9FBE92CE9")

        String s;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.330 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "F35FFAA6A75D4ED13D3E1F7155A8CADC")

        long e;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.330 -0400", hash_original_field = "228D6A97A9838DC800E58B3C74BA7B11", hash_generated_field = "D7F3A989FF2D2C369DC8DD3FAFC81E5F")

        boolean negative;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.330 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "0A5EBC5B0FCD11704FA7F7D3B79A6F6A")

        boolean infinity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.330 -0400", hash_original_field = "D02C4C4CDE7AE76252540D116A40F23A", hash_generated_field = "8B6B687B2003A0D3B71E98348C954562")

        boolean zero;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.330 -0400", hash_original_method = "08340FE99073C3A1F05DC2CE36487C0E", hash_generated_method = "08340FE99073C3A1F05DC2CE36487C0E")
        public StringExponentPair ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.331 -0400", hash_original_method = "910639D1FB7C57E8188938A4D56F4369", hash_generated_method = "1E22A1725F128CCFFEE3AEAD8B8D97DE")
        public float specialValue() {
            if(infinity)            
            {
                float var58A293DBE41BE1FC7DA27C34389052B6_381020269 = (negative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY);
                                float var546ADE640B6EDFBC8A086EF31347E768_1529689087 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1529689087;
            } //End block
            float var8EBD4BDE80414E3383036D59A456AD3A_422079260 = (negative ? -0.0f : 0.0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_1728961998 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1728961998;
            // ---------- Original Method ----------
            //if (infinity) {
                //return negative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            //}
            //return negative ? -0.0f : 0.0f;
        }

        
    }


    
}

