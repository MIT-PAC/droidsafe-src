package org.json;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class JSONTokener {

    /**
     * Returns the integer [0..15] value for the given hex character, or -1
     * for non-hex input.
     *
     * @param hex a character in the ranges [0-9], [A-F] or [a-f]. Any other
     *     character will yield a -1 result.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.662 -0500", hash_original_method = "C49A07C43A7B951DB1FE6415A49FA28D", hash_generated_method = "F44AF192845D160080012C2E7CDCA275")
    
public static int dehexchar(char hex) {
        if (hex >= '0' && hex <= '9') {
            return hex - '0';
        } else if (hex >= 'A' && hex <= 'F') {
            return hex - 'A' + 10;
        } else if (hex >= 'a' && hex <= 'f') {
            return hex - 'a' + 10;
        } else {
            return -1;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.578 -0500", hash_original_field = "BA93529D831303861763326966A95648", hash_generated_field = "955F96F6D73BCB070D987B819612F71F")

    private  String in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.582 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;

    /**
     * @param in JSON encoded string. Null is not permitted and will yield a
     *     tokener that throws {@code NullPointerExceptions} when methods are
     *     called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.587 -0500", hash_original_method = "F6CFC64A950C47985AB98A953B97554C", hash_generated_method = "768A98DE2468BF4F644FD74A4A929925")
    
public JSONTokener(String in) {
        // consume an optional byte order mark (BOM) if it exists
        if (in != null && in.startsWith("\ufeff")) {
            in = in.substring(1);
        }
        this.in = in;
    }

    /**
     * Returns the next value from the input.
     *
     * @return a {@link JSONObject}, {@link JSONArray}, String, Boolean,
     *     Integer, Long, Double or {@link JSONObject#NULL}.
     * @throws JSONException if the input is malformed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.590 -0500", hash_original_method = "B349C062BB24F17BF02BDCB43C03970C", hash_generated_method = "E5AAAA462ED94F752AE89B378C3DDB02")
    
public Object nextValue() throws JSONException {
        int c = nextCleanInternal();
        switch (c) {
            case -1:
                throw syntaxError("End of input");

            case '{':
                return readObject();

            case '[':
                return readArray();

            case '\'':
            case '"':
                return nextString((char) c);

            default:
                pos--;
                return readLiteral();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.594 -0500", hash_original_method = "1C1094F3B0EBF3FC35F6CA7F4976DC54", hash_generated_method = "957C5E349030E3D16ECB3AD1E414E518")
    
private int nextCleanInternal() throws JSONException {
        while (pos < in.length()) {
            int c = in.charAt(pos++);
            switch (c) {
                case '\t':
                case ' ':
                case '\n':
                case '\r':
                    continue;

                case '/':
                    if (pos == in.length()) {
                        return c;
                    }

                    char peek = in.charAt(pos);
                    switch (peek) {
                        case '*':
                            // skip a /* c-style comment */
                            pos++;
                            int commentEnd = in.indexOf("*/", pos);
                            if (commentEnd == -1) {
                                throw syntaxError("Unterminated comment");
                            }
                            pos = commentEnd + 2;
                            continue;

                        case '/':
                            // skip a // end-of-line comment
                            pos++;
                            skipToEndOfLine();
                            continue;

                        default:
                            return c;
                    }

                case '#':
                    /*
                     * Skip a # hash end-of-line comment. The JSON RFC doesn't
                     * specify this behavior, but it's required to parse
                     * existing documents. See http://b/2571423.
                     */
                    skipToEndOfLine();
                    continue;

                default:
                    return c;
            }
        }

        return -1;
    }

    /**
     * Advances the position until after the next newline character. If the line
     * is terminated by "\r\n", the '\n' must be consumed as whitespace by the
     * caller.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.597 -0500", hash_original_method = "A96A54ECB7E0243FC9401A9259237DF7", hash_generated_method = "B0DFF07F1CCB9ED8CBD3B522463021AE")
    
private void skipToEndOfLine() {
        for (; pos < in.length(); pos++) {
            char c = in.charAt(pos);
            if (c == '\r' || c == '\n') {
                pos++;
                break;
            }
        }
    }

    /**
     * Returns the string up to but not including {@code quote}, unescaping any
     * character escape sequences encountered along the way. The opening quote
     * should have already been read. This consumes the closing quote, but does
     * not include it in the returned string.
     *
     * @param quote either ' or ".
     * @throws NumberFormatException if any unicode escape sequences are
     *     malformed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.601 -0500", hash_original_method = "7B01D454BE0369CA1502DDC9AB2083EB", hash_generated_method = "63AFC60416B80DD6344C5708E7202C08")
    
public String nextString(char quote) throws JSONException {
        /*
         * For strings that are free of escape sequences, we can just extract
         * the result as a substring of the input. But if we encounter an escape
         * sequence, we need to use a StringBuilder to compose the result.
         */
        StringBuilder builder = null;

        /* the index of the first character not yet appended to the builder. */
        int start = pos;

        while (pos < in.length()) {
            int c = in.charAt(pos++);
            if (c == quote) {
                if (builder == null) {
                    // a new string avoids leaking memory
                    return new String(in.substring(start, pos - 1));
                } else {
                    builder.append(in, start, pos - 1);
                    return builder.toString();
                }
            }

            if (c == '\\') {
                if (pos == in.length()) {
                    throw syntaxError("Unterminated escape sequence");
                }
                if (builder == null) {
                    builder = new StringBuilder();
                }
                builder.append(in, start, pos - 1);
                builder.append(readEscapeCharacter());
                start = pos;
            }
        }

        throw syntaxError("Unterminated string");
    }

    /**
     * Unescapes the character identified by the character or characters that
     * immediately follow a backslash. The backslash '\' should have already
     * been read. This supports both unicode escapes "u000A" and two-character
     * escapes "\n".
     *
     * @throws NumberFormatException if any unicode escape sequences are
     *     malformed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.604 -0500", hash_original_method = "A0F5694EA3978EBF3A8A4E5207628E80", hash_generated_method = "A46B49E033C2A2CEFAE583A4DD53B3CE")
    
private char readEscapeCharacter() throws JSONException {
        char escaped = in.charAt(pos++);
        switch (escaped) {
            case 'u':
                if (pos + 4 > in.length()) {
                    throw syntaxError("Unterminated escape sequence");
                }
                String hex = in.substring(pos, pos + 4);
                pos += 4;
                return (char) Integer.parseInt(hex, 16);

            case 't':
                return '\t';

            case 'b':
                return '\b';

            case 'n':
                return '\n';

            case 'r':
                return '\r';

            case 'f':
                return '\f';

            case '\'':
            case '"':
            case '\\':
            default:
                return escaped;
        }
    }

    /**
     * Reads a null, boolean, numeric or unquoted string literal value. Numeric
     * values will be returned as an Integer, Long, or Double, in that order of
     * preference.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.608 -0500", hash_original_method = "921E97B7A015080CE0A01C361479BF49", hash_generated_method = "E90500B5A498AD228C58A5454954722F")
    
private Object readLiteral() throws JSONException {
        String literal = nextToInternal("{}[]/\\:,=;# \t\f");

        if (literal.length() == 0) {
            throw syntaxError("Expected literal value");
        } else if ("null".equalsIgnoreCase(literal)) {
            return JSONObject.NULL;
        } else if ("true".equalsIgnoreCase(literal)) {
            return Boolean.TRUE;
        } else if ("false".equalsIgnoreCase(literal)) {
            return Boolean.FALSE;
        }

        /* try to parse as an integral type... */
        if (literal.indexOf('.') == -1) {
            int base = 10;
            String number = literal;
            if (number.startsWith("0x") || number.startsWith("0X")) {
                number = number.substring(2);
                base = 16;
            } else if (number.startsWith("0") && number.length() > 1) {
                number = number.substring(1);
                base = 8;
            }
            try {
                long longValue = Long.parseLong(number, base);
                if (longValue <= Integer.MAX_VALUE && longValue >= Integer.MIN_VALUE) {
                    return (int) longValue;
                } else {
                    return longValue;
                }
            } catch (NumberFormatException e) {
                /*
                 * This only happens for integral numbers greater than
                 * Long.MAX_VALUE, numbers in exponential form (5e-10) and
                 * unquoted strings. Fall through to try floating point.
                 */
            }
        }

        /* ...next try to parse as a floating point... */
        try {
            return Double.valueOf(literal);
        } catch (NumberFormatException ignored) {
        }

        /* ... finally give up. We have an unquoted string */
        return new String(literal); // a new string avoids leaking memory
    }

    /**
     * Returns the string up to but not including any of the given characters or
     * a newline character. This does not consume the excluded character.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.610 -0500", hash_original_method = "593B1F2EF0668764A615A5DB85CFDCCD", hash_generated_method = "96B0B2272C559422F2F421A9F89F6A66")
    
private String nextToInternal(String excluded) {
        int start = pos;
        for (; pos < in.length(); pos++) {
            char c = in.charAt(pos);
            if (c == '\r' || c == '\n' || excluded.indexOf(c) != -1) {
                return in.substring(start, pos);
            }
        }
        return in.substring(start);
    }

    /**
     * Reads a sequence of key/value pairs and the trailing closing brace '}' of
     * an object. The opening brace '{' should have already been read.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.614 -0500", hash_original_method = "D694401380EAF5A76DF87137C67448EA", hash_generated_method = "EB427EC91A987E882813E4C55FB0CDE1")
    
private JSONObject readObject() throws JSONException {
        JSONObject result = new JSONObject();

        /* Peek to see if this is the empty object. */
        int first = nextCleanInternal();
        if (first == '}') {
            return result;
        } else if (first != -1) {
            pos--;
        }

        while (true) {
            Object name = nextValue();
            if (!(name instanceof String)) {
                if (name == null) {
                    throw syntaxError("Names cannot be null");
                } else {
                    throw syntaxError("Names must be strings, but " + name
                            + " is of type " + name.getClass().getName());
                }
            }

            /*
             * Expect the name/value separator to be either a colon ':', an
             * equals sign '=', or an arrow "=>". The last two are bogus but we
             * include them because that's what the original implementation did.
             */
            int separator = nextCleanInternal();
            if (separator != ':' && separator != '=') {
                throw syntaxError("Expected ':' after " + name);
            }
            if (pos < in.length() && in.charAt(pos) == '>') {
                pos++;
            }

            result.put((String) name, nextValue());

            switch (nextCleanInternal()) {
                case '}':
                    return result;
                case ';':
                case ',':
                    continue;
                default:
                    throw syntaxError("Unterminated object");
            }
        }
    }

    /**
     * Reads a sequence of values and the trailing closing brace ']' of an
     * array. The opening brace '[' should have already been read. Note that
     * "[]" yields an empty array, but "[,]" returns a two-element array
     * equivalent to "[null,null]".
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.618 -0500", hash_original_method = "E76B205E92636F1E7B3FC6B2B934FE47", hash_generated_method = "CB336D3608CC6D764C4BDC3C24CB76A2")
    
private JSONArray readArray() throws JSONException {
        JSONArray result = new JSONArray();

        /* to cover input that ends with ",]". */
        boolean hasTrailingSeparator = false;

        while (true) {
            switch (nextCleanInternal()) {
                case -1:
                    throw syntaxError("Unterminated array");
                case ']':
                    if (hasTrailingSeparator) {
                        result.put(null);
                    }
                    return result;
                case ',':
                case ';':
                    /* A separator without a value first means "null". */
                    result.put(null);
                    hasTrailingSeparator = true;
                    continue;
                default:
                    pos--;
            }

            result.put(nextValue());

            switch (nextCleanInternal()) {
                case ']':
                    return result;
                case ',':
                case ';':
                    hasTrailingSeparator = true;
                    continue;
                default:
                    throw syntaxError("Unterminated array");
            }
        }
    }

    /**
     * Returns an exception containing the given message plus the current
     * position and the entire input string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.622 -0500", hash_original_method = "33F4C16D40F1C908E16B89E59A552BE8", hash_generated_method = "7DC58D320C8632A43365B81E8CE70546")
    
public JSONException syntaxError(String message) {
        return new JSONException(message + this);
    }

    /**
     * Returns the current position and the entire input string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.625 -0500", hash_original_method = "D61A5D8B8E38C1530E1AB8F6DB368DAC", hash_generated_method = "4285F17E6EE9ADBD6970C3F9D9BCE520")
    
@Override public String toString() {
        // consistent with the original implementation
        return " at character " + pos + " of " + in;
    }

    /*
     * Legacy APIs.
     *
     * None of the methods below are on the critical path of parsing JSON
     * documents. They exist only because they were exposed by the original
     * implementation and may be used by some clients.
     */

    /**
     * Returns true until the input has been exhausted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.627 -0500", hash_original_method = "6281E295952C34947D74AA92CC697B16", hash_generated_method = "0BFF8C9EE4FB80415F134AE778E04B54")
    
public boolean more() {
        return pos < in.length();
    }

    /**
     * Returns the next available character, or the null character '\0' if all
     * input has been exhausted. The return value of this method is ambiguous
     * for JSON strings that contain the character '\0'.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.631 -0500", hash_original_method = "213D34FB491711CFF086DB4B25220A73", hash_generated_method = "DE80E8A4A362E5C8FE3D32DB67B0C882")
    
public char next() {
        return pos < in.length() ? in.charAt(pos++) : '\0';
    }

    /**
     * Returns the next available character if it equals {@code c}. Otherwise an
     * exception is thrown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.633 -0500", hash_original_method = "95912FB15799A75254D0EFB27A4965DA", hash_generated_method = "4EC75861281F7E0AF46C93821B302432")
    
public char next(char c) throws JSONException {
        char result = next();
        if (result != c) {
            throw syntaxError("Expected " + c + " but was " + result);
        }
        return result;
    }

    /**
     * Returns the next character that is not whitespace and does not belong to
     * a comment. If the input is exhausted before such a character can be
     * found, the null character '\0' is returned. The return value of this
     * method is ambiguous for JSON strings that contain the character '\0'.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.637 -0500", hash_original_method = "8888AACA46E7314FC33FB1B59D843324", hash_generated_method = "64A07152E1DD1B44B78BA36B11FFD423")
    
public char nextClean() throws JSONException {
        int nextCleanInt = nextCleanInternal();
        return nextCleanInt == -1 ? '\0' : (char) nextCleanInt;
    }

    /**
     * Returns the next {@code length} characters of the input.
     *
     * <p>The returned string shares its backing character array with this
     * tokener's input string. If a reference to the returned string may be held
     * indefinitely, you should use {@code new String(result)} to copy it first
     * to avoid memory leaks.
     *
     * @throws JSONException if the remaining input is not long enough to
     *     satisfy this request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.639 -0500", hash_original_method = "9816A4D386531BCA80B95E34249E012D", hash_generated_method = "785D9EDB1A4CFFA6CC34B5511FD235B9")
    
public String next(int length) throws JSONException {
        if (pos + length > in.length()) {
            throw syntaxError(length + " is out of bounds");
        }
        String result = in.substring(pos, pos + length);
        pos += length;
        return result;
    }

    /**
     * Returns the {@link String#trim trimmed} string holding the characters up
     * to but not including the first of:
     * <ul>
     *   <li>any character in {@code excluded}
     *   <li>a newline character '\n'
     *   <li>a carriage return '\r'
     * </ul>
     *
     * <p>The returned string shares its backing character array with this
     * tokener's input string. If a reference to the returned string may be held
     * indefinitely, you should use {@code new String(result)} to copy it first
     * to avoid memory leaks.
     *
     * @return a possibly-empty string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.647 -0500", hash_original_method = "EA130CCB3E2CFC0C10CD8E8D4F88F4FA", hash_generated_method = "F3DB63DBA9EC2D3D72DD01DF1381FC0E")
    
public String nextTo(String excluded) {
        if (excluded == null) {
            throw new NullPointerException();
        }
        return nextToInternal(excluded).trim();
    }

    /**
     * Equivalent to {@code nextTo(String.valueOf(excluded))}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.650 -0500", hash_original_method = "9F2D4FCC02E225188C000422795F1B2D", hash_generated_method = "582B776FCA49CEEB1273FA9778716FA7")
    
public String nextTo(char excluded) {
        return nextToInternal(String.valueOf(excluded)).trim();
    }

    /**
     * Advances past all input up to and including the next occurrence of
     * {@code thru}. If the remaining input doesn't contain {@code thru}, the
     * input is exhausted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.653 -0500", hash_original_method = "705EE299D0C421425210CB39FE7F29B9", hash_generated_method = "F2C99825F760FF74F7753A5E58455290")
    
public void skipPast(String thru) {
        int thruStart = in.indexOf(thru, pos);
        pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
    }

    /**
     * Advances past all input up to but not including the next occurrence of
     * {@code to}. If the remaining input doesn't contain {@code to}, the input
     * is unchanged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.656 -0500", hash_original_method = "A067EA373EE4201A369E9BCAA7E25460", hash_generated_method = "CDE3FAE9CD27BFCD1A901CF86E355ECB")
    
public char skipTo(char to) {
        int index = in.indexOf(to, pos);
        if (index != -1) {
            pos = index;
            return to;
        } else {
            return '\0';
        }
    }

    /**
     * Unreads the most recent character of input. If no input characters have
     * been read, the input is unchanged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.659 -0500", hash_original_method = "8E6F2519C4EF5016C5BDFABD97F81370", hash_generated_method = "4ECDE48F6CDDB5198636F8451EC49FCF")
    
public void back() {
        if (--pos == -1) {
            pos = 0;
        }
    }
    
}

