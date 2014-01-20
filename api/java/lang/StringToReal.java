package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

final class StringToReal {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static double parseDblImpl(String s, int e) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static float parseFltImpl(String s, int e) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.958 -0500", hash_original_method = "A702FCC630766BC818EED71038E1F86B", hash_generated_method = "9CB60A6EB8F810F62B75FEF194266678")
    
private static NumberFormatException invalidReal(String s, boolean isDouble) {
        throw new NumberFormatException("Invalid " + (isDouble ? "double" : "float") + ": \"" + s + "\"");
    }

    /**
     * Returns a StringExponentPair containing a String with no leading or trailing white
     * space and trailing zeroes eliminated. The exponent of the
     * StringExponentPair will be used to calculate the floating point number by
     * taking the positive integer the String represents and multiplying by 10
     * raised to the power of the of the exponent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.964 -0500", hash_original_method = "B867FADDD04B9C54EFA439F8C65B2912", hash_generated_method = "2AEA6912E716FBBF2B1EB5A0793C0439")
    
private static StringExponentPair initialParse(String s, int length, boolean isDouble) {
        StringExponentPair result = new StringExponentPair();
        if (length == 0) {
            throw invalidReal(s, isDouble);
        }
        result.negative = (s.charAt(0) == '-');

        // We ignore trailing double or float indicators; the method you called determines
        // what you'll get.
        char c = s.charAt(length - 1);
        if (c == 'D' || c == 'd' || c == 'F' || c == 'f') {
            length--;
            if (length == 0) {
                throw invalidReal(s, isDouble);
            }
        }

        int end = Math.max(s.indexOf('E'), s.indexOf('e'));
        if (end != -1) {
            // Is there anything after the 'e'?
            if (end + 1 == length) {
                throw invalidReal(s, isDouble);
            }

            // Do we have an optional explicit sign?
            int exponentOffset = end + 1;
            boolean negativeExponent = false;
            char firstExponentChar = s.charAt(exponentOffset);
            if (firstExponentChar == '+' || firstExponentChar == '-') {
                negativeExponent = (firstExponentChar == '-');
                ++exponentOffset;
            }

            // Do we have a valid positive integer?
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

            // Parse the integer exponent.
            try {
                result.e = Integer.parseInt(exponentString);
                if (negativeExponent) {
                    result.e = -result.e;
                }
            } catch (NumberFormatException ex) {
                // We already checked the string, so the exponent must have been out of range for an int.
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

        // This is a hack for https://issues.apache.org/jira/browse/HARMONY-329
        // Trim the length of very small numbers, natives can only handle down
        // to E-309
        final int APPROX_MIN_MAGNITUDE = -359;
        final int MAX_DIGITS = 52;
        length = s.length();
        if (length > MAX_DIGITS && result.e < APPROX_MIN_MAGNITUDE) {
            int d = Math.min(APPROX_MIN_MAGNITUDE - (int) result.e, length - 1);
            s = s.substring(0, length - d);
            result.e += d;
        }

        // This is a hack for https://issues.apache.org/jira/browse/HARMONY-6641
        // The magic 1024 was determined experimentally; the more plausible -324 and +309 were
        // not sufficient to pass both our tests and harmony's tests.
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

    // Parses "+Nan", "NaN", "-Nan", "+Infinity", "Infinity", and "-Infinity", case-insensitively.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.967 -0500", hash_original_method = "C3B0EB4C3A7AB8C70DFA65D2731C2433", hash_generated_method = "9B518F4A12033630F3E4F76CC37006FD")
    
private static float parseName(String name, boolean isDouble) {
        // Explicit sign?
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

    /**
     * Returns the closest double value to the real number in the string.
     *
     * @param s
     *            the String that will be parsed to a floating point
     * @return the double closest to the real number
     *
     * @exception NumberFormatException
     *                if the String doesn't represent a double
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.970 -0500", hash_original_method = "E57D4562AEDEAB80F792BC05E60E369F", hash_generated_method = "D002B6E4C939C115DC173C4803445A35")
    
public static double parseDouble(String s) {
        s = s.trim();
        int length = s.length();

        if (length == 0) {
            throw invalidReal(s, true);
        }

        // See if this could be a named double
        char last = s.charAt(length - 1);
        if (last == 'y' || last == 'N') {
            return parseName(s, true);
        }

        // See if it could be a hexadecimal representation.
        // We don't use startsWith because there might be a leading sign.
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

    /**
     * Returns the closest float value to the real number in the string.
     *
     * @param s
     *            the String that will be parsed to a floating point
     * @return the float closest to the real number
     *
     * @exception NumberFormatException
     *                if the String doesn't represent a float
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.973 -0500", hash_original_method = "F4AB8400AD0DFE9B5884DACBEFD7642E", hash_generated_method = "63E41CADB6CCBE345B7915745BC2D9E4")
    
public static float parseFloat(String s) {
        s = s.trim();
        int length = s.length();

        if (length == 0) {
            throw invalidReal(s, false);
        }

        // See if this could be a named float
        char last = s.charAt(length - 1);
        if (last == 'y' || last == 'N') {
            return parseName(s, false);
        }

        // See if it could be a hexadecimal representation
        // We don't use startsWith because there might be a leading sign.
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.327 -0400", hash_original_method = "50763D5996F4E117B646112682AF8739", hash_generated_method = "50763D5996F4E117B646112682AF8739")
    public StringToReal ()
    {
        //Synthesized constructor
    }
    
    private static final class StringExponentPair {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.932 -0500", hash_original_field = "6F3CB884E38CB76988A52AA9FBE92CE9", hash_generated_field = "6F3CB884E38CB76988A52AA9FBE92CE9")

        String s;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.935 -0500", hash_original_field = "F35FFAA6A75D4ED13D3E1F7155A8CADC", hash_generated_field = "F35FFAA6A75D4ED13D3E1F7155A8CADC")

        long e;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.937 -0500", hash_original_field = "D7F3A989FF2D2C369DC8DD3FAFC81E5F", hash_generated_field = "D7F3A989FF2D2C369DC8DD3FAFC81E5F")

        boolean negative;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.940 -0500", hash_original_field = "0A5EBC5B0FCD11704FA7F7D3B79A6F6A", hash_generated_field = "0A5EBC5B0FCD11704FA7F7D3B79A6F6A")

        boolean infinity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.942 -0500", hash_original_field = "8B6B687B2003A0D3B71E98348C954562", hash_generated_field = "8B6B687B2003A0D3B71E98348C954562")

        boolean zero;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.330 -0400", hash_original_method = "08340FE99073C3A1F05DC2CE36487C0E", hash_generated_method = "08340FE99073C3A1F05DC2CE36487C0E")
        public StringExponentPair ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.945 -0500", hash_original_method = "910639D1FB7C57E8188938A4D56F4369", hash_generated_method = "D07775A3D58E6A208D82CA2F641CE123")
        
public float specialValue() {
            if (infinity) {
                return negative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            }
            return negative ? -0.0f : 0.0f;
        }
        
    }
    
}

