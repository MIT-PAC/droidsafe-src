package com.android.internal.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;

import javax.security.auth.x500.X500Principal;



public final class DNParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.185 -0500", hash_original_field = "EA1B57D73AF22D42FFBE3F9C03A150D5", hash_generated_field = "8755658AF290FD110892EDFB73434ADB")

    private static final String TAG = "DNParser";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.200 -0500", hash_original_field = "AC5649507EA15733DFCCC1FBFEB5DC6A", hash_generated_field = "F6565CB51CDFFE700B2DBF94ED832F63")

    private static final String ERROR_PARSE_ERROR = "Failed to parse DN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.188 -0500", hash_original_field = "74A77BA6BAB71A1CFF838B8FBBD6D72C", hash_generated_field = "3D2CB8429158C4900E9EA4B3985C38C4")

    private  String dn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.190 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

    private  int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.322 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.322 -0400", hash_original_field = "63A08F52A29E0F7A1F987F4495164AB0", hash_generated_field = "281969654EB14E15446253F1D771C5B0")

    private int beg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.322 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.195 -0500", hash_original_field = "2F4877CE6BA21232C2B8D66924B60128", hash_generated_field = "574083FEFFA006A1773B42DB36035D30")

    private int cur;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.197 -0500", hash_original_field = "BABA8C00F9965D74411919B77DB127E3", hash_generated_field = "8CFCF0E96717F68959883591D279E158")

    private char[] chars;

    /**
     * Constructor.
     *
     * @param principal - {@link X500Principal} to be parsed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.203 -0500", hash_original_method = "3E2925D928731F8540EF17AB0FA8675E", hash_generated_method = "515592831E5B57905D11A2F212070F53")
    
public DNParser(X500Principal principal) {
        this.dn = principal.getName(X500Principal.RFC2253);
        this.length = dn.length();
    }

    // gets next attribute type: (ALPHA 1*keychar) / oid
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.206 -0500", hash_original_method = "FF4BEB2C3B52F01ACB9FD25F4CE8A230", hash_generated_method = "F0D0BF57D4C2BD93F75155F728BA4DC0")
    
private String nextAT() throws IOException {

        // skip preceding space chars, they can present after
        // comma or semicolon (compatibility with RFC 1779)
        for (; pos < length && chars[pos] == ' '; pos++) {
        }
        if (pos == length) {
            return null; // reached the end of DN
        }

        // mark the beginning of attribute type
        beg = pos;

        // attribute type chars
        pos++;
        for (; pos < length && chars[pos] != '=' && chars[pos] != ' '; pos++) {
            // we don't follow exact BNF syntax here:
            // accept any char except space and '='
        }
        if (pos >= length) {
            // unexpected end of DN
            throw new IOException(ERROR_PARSE_ERROR);
        }

        // mark the end of attribute type
        end = pos;

        // skip trailing space chars between attribute type and '='
        // (compatibility with RFC 1779)
        if (chars[pos] == ' ') {
            for (; pos < length && chars[pos] != '=' && chars[pos] == ' '; pos++) {
            }

            if (chars[pos] != '=' || pos == length) {
                // unexpected end of DN
                throw new IOException(ERROR_PARSE_ERROR);
            }
        }

        pos++; //skip '=' char

        // skip space chars between '=' and attribute value
        // (compatibility with RFC 1779)
        for (; pos < length && chars[pos] == ' '; pos++) {
        }

        // in case of oid attribute type skip its prefix: "oid." or "OID."
        // (compatibility with RFC 1779)
        if ((end - beg > 4) && (chars[beg + 3] == '.')
                && (chars[beg] == 'O' || chars[beg] == 'o')
                && (chars[beg + 1] == 'I' || chars[beg + 1] == 'i')
                && (chars[beg + 2] == 'D' || chars[beg + 2] == 'd')) {
            beg += 4;
        }

        return new String(chars, beg, end - beg);
    }

    // gets quoted attribute value: QUOTATION *( quotechar / pair ) QUOTATION
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.208 -0500", hash_original_method = "6CE0A226336916B0D0BD29FA44800404", hash_generated_method = "C8479615C8221D0B73A1DA6D2665FBAB")
    
private String quotedAV() throws IOException {

        pos++;
        beg = pos;
        end = beg;
        while (true) {

            if (pos == length) {
                // unexpected end of DN
                throw new IOException(ERROR_PARSE_ERROR);
            }

            if (chars[pos] == '"') {
                // enclosing quotation was found
                pos++;
                break;
            } else if (chars[pos] == '\\') {
                chars[end] = getEscaped();
            } else {
                // shift char: required for string with escaped chars
                chars[end] = chars[pos];
            }
            pos++;
            end++;
        }

        // skip trailing space chars before comma or semicolon.
        // (compatibility with RFC 1779)
        for (; pos < length && chars[pos] == ' '; pos++) {
        }

        return new String(chars, beg, end - beg);
    }

    // gets hex string attribute value: "#" hexstring
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.212 -0500", hash_original_method = "F2971F3EEE8ADD1AC7CDED4BAC19B062", hash_generated_method = "F1094E0759D42A95372AF458E2BC086C")
    
private String hexAV() throws IOException {

        if (pos + 4 >= length) {
            // encoded byte array  must be not less then 4 c
            throw new IOException(ERROR_PARSE_ERROR);
        }

        beg = pos; // store '#' position
        pos++;
        while (true) {

            // check for end of attribute value
            // looks for space and component separators
            if (pos == length || chars[pos] == '+' || chars[pos] == ','
                    || chars[pos] == ';') {
                end = pos;
                break;
            }

            if (chars[pos] == ' ') {
                end = pos;
                pos++;
                // skip trailing space chars before comma or semicolon.
                // (compatibility with RFC 1779)
                for (; pos < length && chars[pos] == ' '; pos++) {
                }
                break;
            } else if (chars[pos] >= 'A' && chars[pos] <= 'F') {
                chars[pos] += 32; //to low case
            }

            pos++;
        }

        // verify length of hex string
        // encoded byte array  must be not less then 4 and must be even number
        int hexLen = end - beg; // skip first '#' char
        if (hexLen < 5 || (hexLen & 1) == 0) {
            throw new IOException(ERROR_PARSE_ERROR);
        }

        // get byte encoding from string representation
        byte[] encoded = new byte[hexLen / 2];
        for (int i = 0, p = beg + 1; i < encoded.length; p += 2, i++) {
            encoded[i] = (byte) getByte(p);
        }

        return new String(chars, beg, hexLen);
    }

    // gets string attribute value: *( stringchar / pair )
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.215 -0500", hash_original_method = "4DC639394A31828D7BD68247B83FBA07", hash_generated_method = "FA340660B1DC19FDC8860502F86C8A8C")
    
private String escapedAV() throws IOException {

        beg = pos;
        end = pos;
        while (true) {

            if (pos >= length) {
                // the end of DN has been found
                return new String(chars, beg, end - beg);
            }

            switch (chars[pos]) {
            case '+':
            case ',':
            case ';':
                // separator char has beed found
                return new String(chars, beg, end - beg);
            case '\\':
                // escaped char
                chars[end++] = getEscaped();
                pos++;
                break;
            case ' ':
                // need to figure out whether space defines
                // the end of attribute value or not
                cur = end;

                pos++;
                chars[end++] = ' ';

                for (; pos < length && chars[pos] == ' '; pos++) {
                    chars[end++] = ' ';
                }
                if (pos == length || chars[pos] == ',' || chars[pos] == '+'
                        || chars[pos] == ';') {
                    // separator char or the end of DN has beed found
                    return new String(chars, beg, cur - beg);
                }
                break;
            default:
                chars[end++] = chars[pos];
                pos++;
            }
        }
    }

    // returns escaped char
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.217 -0500", hash_original_method = "53196F6413879CFC1842AAE874B37E3B", hash_generated_method = "C460509F8FDC988A9540230C9CA971BE")
    
private char getEscaped() throws IOException {

        pos++;
        if (pos == length) {
            throw new IOException(ERROR_PARSE_ERROR);
        }

        switch (chars[pos]) {
        case '"':
        case '\\':
        case ',':
        case '=':
        case '+':
        case '<':
        case '>':
        case '#':
        case ';':
        case ' ':
        case '*':
        case '%':
        case '_':
            //FIXME: escaping is allowed only for leading or trailing space char
            return chars[pos];
        default:
            // RFC doesn't explicitly say that escaped hex pair is
            // interpreted as UTF-8 char. It only contains an example of such DN.
            return getUTF8();
        }
    }

    // decodes UTF-8 char
    // see http://www.unicode.org for UTF-8 bit distribution table
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.221 -0500", hash_original_method = "1AF4B344FDDD447575D7BAE99B8C4CD1", hash_generated_method = "05008221DC4D81DCF8CC27935EE71897")
    
private char getUTF8() throws IOException {

        int res = getByte(pos);
        pos++; //FIXME tmp

        if (res < 128) { // one byte: 0-7F
            return (char) res;
        } else if (res >= 192 && res <= 247) {

            int count;
            if (res <= 223) { // two bytes: C0-DF
                count = 1;
                res = res & 0x1F;
            } else if (res <= 239) { // three bytes: E0-EF
                count = 2;
                res = res & 0x0F;
            } else { // four bytes: F0-F7
                count = 3;
                res = res & 0x07;
            }

            int b;
            for (int i = 0; i < count; i++) {
                pos++;
                if (pos == length || chars[pos] != '\\') {
                    return 0x3F; //FIXME failed to decode UTF-8 char - return '?'
                }
                pos++;

                b = getByte(pos);
                pos++; //FIXME tmp
                if ((b & 0xC0) != 0x80) {
                    return 0x3F; //FIXME failed to decode UTF-8 char - return '?'
                }

                res = (res << 6) + (b & 0x3F);
            }
            return (char) res;
        } else {
            return 0x3F; //FIXME failed to decode UTF-8 char - return '?'
        }
    }

    // Returns byte representation of a char pair
    // The char pair is composed of DN char in
    // specified 'position' and the next char
    // According to BNF syntax:
    // hexchar    = DIGIT / "A" / "B" / "C" / "D" / "E" / "F"
    //                    / "a" / "b" / "c" / "d" / "e" / "f"
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.224 -0500", hash_original_method = "2374C761E42CEC3E752725D6A1CCC05C", hash_generated_method = "91DA66F05902E6D47D3876FBD601DB01")
    
private int getByte(int position) throws IOException {

        if ((position + 1) >= length) {
            // to avoid ArrayIndexOutOfBoundsException
            throw new IOException(ERROR_PARSE_ERROR);
        }

        int b1, b2;

        b1 = chars[position];
        if (b1 >= '0' && b1 <= '9') {
            b1 = b1 - '0';
        } else if (b1 >= 'a' && b1 <= 'f') {
            b1 = b1 - 87; // 87 = 'a' - 10
        } else if (b1 >= 'A' && b1 <= 'F') {
            b1 = b1 - 55; // 55 = 'A' - 10
        } else {
            throw new IOException(ERROR_PARSE_ERROR);
        }

        b2 = chars[position + 1];
        if (b2 >= '0' && b2 <= '9') {
            b2 = b2 - '0';
        } else if (b2 >= 'a' && b2 <= 'f') {
            b2 = b2 - 87; // 87 = 'a' - 10
        } else if (b2 >= 'A' && b2 <= 'F') {
            b2 = b2 - 55; // 55 = 'A' - 10
        } else {
            throw new IOException(ERROR_PARSE_ERROR);
        }

        return (b1 << 4) + b2;
    }

    /**
     * Parses the DN and returns the attribute value for an attribute type.
     *
     * @param attributeType attribute type to look for (e.g. "ca")
     * @return value of the attribute that first found, or null if none found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.227 -0500", hash_original_method = "35FC8516F494B2993CB4F015ABFC8107", hash_generated_method = "797FCFBAD15E51E156BF4478A85641DF")
    
public String find(String attributeType) {
        try {
            // Initialize internal state.
            pos = 0;
            beg = 0;
            end = 0;
            cur = 0;
            chars = dn.toCharArray();

            String attType = nextAT();
            if (attType == null) {
                return null;
            }
            while (true) {
                String attValue = "";

                if (pos == length) {
                    return null;
                }

                switch (chars[pos]) {
                case '"':
                    attValue = quotedAV();
                    break;
                case '#':
                    attValue = hexAV();
                    break;
                case '+':
                case ',':
                case ';': // compatibility with RFC 1779: semicolon can separate RDNs
                    //empty attribute value
                    break;
                default:
                    attValue = escapedAV();
                }

                if (attributeType.equalsIgnoreCase(attType)) {
                    return attValue;
                }

                if (pos >= length) {
                    return null;
                }

                if (chars[pos] == ',' || chars[pos] == ';') {
                } else if (chars[pos] != '+') {
                    throw new IOException(ERROR_PARSE_ERROR);
                }

                pos++;
                attType = nextAT();
                if (attType == null) {
                    throw new IOException(ERROR_PARSE_ERROR);
                }
            }
        } catch (IOException e) {
            // Parse error shouldn't happen, because we only handle DNs that
            // X500Principal.getName() returns, which shouldn't be malformed.
            Log.e(TAG, "Failed to parse DN: " + dn);
            return null;
        }
    }
}

