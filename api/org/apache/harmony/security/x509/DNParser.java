package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x501.AttributeValue;

public final class DNParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.059 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.062 -0500", hash_original_field = "2A98354EEE0CC0C0E9C78DAE42E0EFE7", hash_generated_field = "281969654EB14E15446253F1D771C5B0")

    private int beg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.064 -0500", hash_original_field = "302E5A3147803830441A79AED31F4022", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.066 -0500", hash_original_field = "BABA8C00F9965D74411919B77DB127E3", hash_generated_field = "8CFCF0E96717F68959883591D279E158")

    private  char[] chars;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.069 -0500", hash_original_field = "60A47098D83F88DA9997B0BA3591E851", hash_generated_field = "790BB9C226E70D863513D01FB9E5249C")

    private boolean hasQE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.071 -0500", hash_original_field = "B26EA4441AC976CE9D513DB2C8639526", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;

    /**
     * @param dn - distinguished name string to be parsed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.073 -0500", hash_original_method = "66B2F9736FABC0973929FB105735B82E", hash_generated_method = "F90446B44064D82158374C2B18511920")
    
public DNParser(String dn) throws IOException {
        chars = dn.toCharArray();
    }

    /**
     * Returns the next attribute type: (ALPHA 1*keychar) / oid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.076 -0500", hash_original_method = "7D5C37EF81BA8B102CA672C27E3E2647", hash_generated_method = "D580D2B6997CA0AD3EA3DA28A6D39DD5")
    
private String nextAT() throws IOException {
        hasQE = false; // reset

        // skip preceding space chars, they can present after
        // comma or semicolon (compatibility with RFC 1779)
        for (; pos < chars.length && chars[pos] == ' '; pos++) {
        }
        if (pos == chars.length) {
            return null; // reached the end of DN
        }

        // mark the beginning of attribute type
        beg = pos;

        // attribute type chars
        pos++;
        for (; pos < chars.length && chars[pos] != '=' && chars[pos] != ' '; pos++) {
            // we don't follow exact BNF syntax here:
            // accept any char except space and '='
        }
        if (pos >= chars.length) {
            // unexpected end of DN
            throw new IOException("Invalid distinguished name string");
        }

        // mark the end of attribute type
        end = pos;

        // skip trailing space chars between attribute type and '='
        // (compatibility with RFC 1779)
        if (chars[pos] == ' ') {
            for (; pos < chars.length && chars[pos] != '=' && chars[pos] == ' '; pos++) {
            }

            if (chars[pos] != '=' || pos == chars.length) {
                // unexpected end of DN
                throw new IOException("Invalid distinguished name string");
            }
        }

        pos++; //skip '=' char

        // skip space chars between '=' and attribute value
        // (compatibility with RFC 1779)
        for (; pos < chars.length && chars[pos] == ' '; pos++) {
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

    /**
     * Returns a quoted attribute value: QUOTATION *( quotechar / pair ) QUOTATION
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.080 -0500", hash_original_method = "5F9B58135FF863A8E24F4B2AD9DF48BE", hash_generated_method = "E3DD63383478888733F50795F38A2121")
    
private String quotedAV() throws IOException {
        pos++;
        beg = pos;
        end = beg;
        while (true) {
            if (pos == chars.length) {
                // unexpected end of DN
                throw new IOException("Invalid distinguished name string");
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
        for (; pos < chars.length && chars[pos] == ' '; pos++) {
        }

        return new String(chars, beg, end - beg);
    }

    /**
     * Returns a hex string attribute value: "#" hexstring
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.083 -0500", hash_original_method = "59E635302CD6807B36C1A45A26BE591E", hash_generated_method = "E777F4D20A3E452EC8A82B9D572FAC41")
    
private String hexAV() throws IOException {
        if (pos + 4 >= chars.length) {
            // encoded byte array  must be not less then 4 c
            throw new IOException("Invalid distinguished name string");
        }

        beg = pos; // store '#' position
        pos++;
        while (true) {
            // check for end of attribute value
            // looks for space and component separators
            if (pos == chars.length || chars[pos] == '+' || chars[pos] == ','
                    || chars[pos] == ';') {
                end = pos;
                break;
            }

            if (chars[pos] == ' ') {
                end = pos;
                pos++;
                // skip trailing space chars before comma or semicolon.
                // (compatibility with RFC 1779)
                for (; pos < chars.length && chars[pos] == ' '; pos++) {
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
            throw new IOException("Invalid distinguished name string");
        }

        // get byte encoding from string representation
        encoded = new byte[hexLen / 2];
        for (int i = 0, p = beg + 1; i < encoded.length; p += 2, i++) {
            encoded[i] = (byte) getByte(p);
        }

        return new String(chars, beg, hexLen);
    }

    /**
     * Returns a string attribute value: *( stringchar / pair ).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.085 -0500", hash_original_method = "FC33535E1A62E80F93C12FF4F8D2E290", hash_generated_method = "91DA17AAED4411BDAFC72B3BC9DDFF89")
    
private String escapedAV() throws IOException {
        beg = pos;
        end = pos;
        while (true) {
            if (pos >= chars.length) {
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
                int cur = end;

                pos++;
                chars[end++] = ' ';

                for (; pos < chars.length && chars[pos] == ' '; pos++) {
                    chars[end++] = ' ';
                }
                if (pos == chars.length || chars[pos] == ',' || chars[pos] == '+'
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

    /**
     * Returns an escaped char
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.088 -0500", hash_original_method = "1A89A1602A29634CB35E16E135F5FE74", hash_generated_method = "968F3EFAE4329412C847E640E9C94692")
    
private char getEscaped() throws IOException {
        pos++;
        if (pos == chars.length) {
            throw new IOException("Invalid distinguished name string");
        }

        char ch = chars[pos];
        switch (ch) {
        case '"':
        case '\\':
            hasQE = true;
            return ch;
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
            return ch;
        default:
            // RFC doesn't explicitly say that escaped hex pair is
            // interpreted as UTF-8 char. It only contains an example of such DN.
            return getUTF8();
        }
    }

    /**
     * Decodes a UTF-8 char.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.091 -0500", hash_original_method = "12C3774F0261E7D12FCB54FD470B78E6", hash_generated_method = "588B076DFA49A30C4009835A440F9A60")
    
protected char getUTF8() throws IOException {
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
                if (pos == chars.length || chars[pos] != '\\') {
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

    /**
     * Returns byte representation of a char pair
     * The char pair is composed of DN char in
     * specified 'position' and the next char
     * According to BNF syntax:
     * hexchar    = DIGIT / "A" / "B" / "C" / "D" / "E" / "F"
     *                     / "a" / "b" / "c" / "d" / "e" / "f"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.094 -0500", hash_original_method = "C98D163E17FC33654783E302104D54C8", hash_generated_method = "738B429D26797DFD36B981BBB0BD184C")
    
private int getByte(int position) throws IOException {
        if ((position + 1) >= chars.length) {
            // to avoid ArrayIndexOutOfBoundsException
            throw new IOException("Invalid distinguished name string");
        }

        int b1 = chars[position];
        if (b1 >= '0' && b1 <= '9') {
            b1 = b1 - '0';
        } else if (b1 >= 'a' && b1 <= 'f') {
            b1 = b1 - 87; // 87 = 'a' - 10
        } else if (b1 >= 'A' && b1 <= 'F') {
            b1 = b1 - 55; // 55 = 'A' - 10
        } else {
            throw new IOException("Invalid distinguished name string");
        }

        int b2 = chars[position + 1];
        if (b2 >= '0' && b2 <= '9') {
            b2 = b2 - '0';
        } else if (b2 >= 'a' && b2 <= 'f') {
            b2 = b2 - 87; // 87 = 'a' - 10
        } else if (b2 >= 'A' && b2 <= 'F') {
            b2 = b2 - 55; // 55 = 'A' - 10
        } else {
            throw new IOException("Invalid distinguished name string");
        }

        return (b1 << 4) + b2;
    }

    /**
     * Parses DN
     *
     * @return a list of Relative Distinguished Names(RND),
     *         each RDN is represented as a list of AttributeTypeAndValue objects
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.097 -0500", hash_original_method = "17512CE00D4450F012CF195B2D29239B", hash_generated_method = "0D8D59A4B9A117C6EE0DA6D251D5C754")
    
public List<List<AttributeTypeAndValue>> parse() throws IOException {
        List<List<AttributeTypeAndValue>> list = new ArrayList<List<AttributeTypeAndValue>>();

        String attType = nextAT();
        if (attType == null) {
            return list; //empty list of RDNs
        }

        List<AttributeTypeAndValue> atav = new ArrayList<AttributeTypeAndValue>();
        while (true) {
            if (pos == chars.length) {
                //empty Attribute Value
                atav.add(new AttributeTypeAndValue(attType, new AttributeValue("", false)));
                list.add(0, atav);
                return list;
            }

            switch (chars[pos]) {
            case '"':
                atav.add(new AttributeTypeAndValue(attType, new AttributeValue(quotedAV(), hasQE)));
                break;
            case '#':
                atav.add(new AttributeTypeAndValue(attType, new AttributeValue(hexAV(), encoded)));
                break;
            case '+':
            case ',':
            case ';': // compatibility with RFC 1779: semicolon can separate RDNs
                //empty attribute value
                atav.add(new AttributeTypeAndValue(attType, new AttributeValue("", false)));
                break;
            default:
                atav.add(new AttributeTypeAndValue(attType, new AttributeValue(
                        escapedAV(), hasQE)));
            }

            if (pos >= chars.length) {
                list.add(0, atav);
                return list;
            }

            if (chars[pos] == ',' || chars[pos] == ';') {
                list.add(0, atav);
                atav = new ArrayList<AttributeTypeAndValue>();
            } else if (chars[pos] != '+') {
                throw new IOException("Invalid distinguished name string");
            }

            pos++;
            attType = nextAT();
            if (attType == null) {
                throw new IOException("Invalid distinguished name string");
            }
        }
    }
    
}

