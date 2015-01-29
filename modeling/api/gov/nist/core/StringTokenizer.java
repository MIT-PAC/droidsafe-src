package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;
import java.util.Vector;

public class StringTokenizer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.413 -0500", hash_original_method = "D59BD2FA8BCAA8F295BA9C3EB4B8AFB2", hash_generated_method = "CF587A23EF72B905CEA0BC90656AF9D5")
    
public static boolean isHexDigit(char ch) {
        return (ch >= 'A' && ch <= 'F') ||
               (ch >= 'a' && ch <= 'f') ||
               isDigit(ch);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.416 -0500", hash_original_method = "7D5254566BCC9A7A67DABAF673D32238", hash_generated_method = "6E9E797246080C01FD90A2AE3017BEF3")
    
public static boolean isAlpha(char ch) {
        if (ch <= 127) {
            return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
        }
        else {
            return Character.isLowerCase(ch) || Character.isUpperCase(ch);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.418 -0500", hash_original_method = "95BB6A90D42B7D83DE6762188C810E6F", hash_generated_method = "0F51E0DC3F903E17ECF2B3FA26CD1BFC")
    
public static boolean isDigit(char ch) {
        if (ch <= 127) {
            return (ch <= '9' && ch >= '0');
        }
        else {
            return Character.isDigit(ch);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.421 -0500", hash_original_method = "0F27860958B0FA5CB1EDC448D322C447", hash_generated_method = "0634F4581EF46AF36A6A170CAA95C7DE")
    
public static boolean isAlphaDigit(char ch) {
        if (ch <= 127) {
            return (ch >= 'a' && ch <= 'z') ||
                (ch >= 'A' && ch <= 'Z') ||
                (ch <= '9' && ch >= '0');
        }
        else {
            return Character.isLowerCase(ch) ||
                Character.isUpperCase(ch) ||
                Character.isDigit(ch);
        }
    }

    /** get the SDP field name of the line
     *  @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.448 -0500", hash_original_method = "7A10C3E016CC004EAF4F29E4A9D459FE", hash_generated_method = "CA4E7625FD3E7EB7CD1E90666AC79C43")
    
public static String getSDPFieldName(String line) {
        if (line == null)
            return null;
        String fieldName = null;
        try {
            int begin = line.indexOf("=");
            fieldName = line.substring(0, begin);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return fieldName;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.392 -0500", hash_original_field = "5691B23D11017F76E02A170C10F2BD89", hash_generated_field = "ED717DDCA3146879332E3CB1E590C4E3")

    protected String buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.395 -0500", hash_original_field = "08B12890D20EE0820616653E031FE559", hash_generated_field = "5E4B7A8AC8566734721FEEDF567651D1")

    protected int bufferLen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.397 -0500", hash_original_field = "407F33A4FEC278EC364347D42DC7DA18", hash_generated_field = "3DF1878C9AB8F7D115E0E6CEFC4F73A0")

    protected int ptr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.399 -0500", hash_original_field = "72AAF0754B240C03D0D8426B81014E38", hash_generated_field = "0F0615C013337AE815CBF333AD213822")

    protected int savedPtr;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.402 -0500", hash_original_method = "54BA219EC49F828609CB54EE2A82793E", hash_generated_method = "0E93752D6CB767CE259C282DCA9D66A9")
    
protected StringTokenizer() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.405 -0500", hash_original_method = "DA5ACD58DF915D63245F1B44E5CF5026", hash_generated_method = "78FD72F7B05EE8561BF3C29D9AE2B15C")
    
public StringTokenizer(String buffer) {
        this.buffer = buffer;
        bufferLen = buffer.length();
        ptr = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.408 -0500", hash_original_method = "51D68C0C294E8AE98A6D3675712278FD", hash_generated_method = "3903A5FC8AC7FED841F2D5DDDF0F68C1")
    
public String nextToken() {
        int startIdx = ptr;

        while (ptr < bufferLen) {
            char c = buffer.charAt(ptr);
            ptr++;
            if (c == '\n') {
                break;
            }
        }

        return buffer.substring(startIdx, ptr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.410 -0500", hash_original_method = "CE3ED718DBD97A207FB6B56A3D84C961", hash_generated_method = "A67EC5A2E26FA1CD8D8CE8C054272F7A")
    
public boolean hasMoreChars() {
        return ptr < bufferLen;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.424 -0500", hash_original_method = "4D480BDC007302EAB6B0602B0495288F", hash_generated_method = "CDBA0B6A16BCA3D24BA2D531DC6B7E61")
    
public String getLine() {
        int startIdx = ptr;
        while (ptr < bufferLen && buffer.charAt(ptr) != '\n') {
            ptr++;
        }
        if (ptr < bufferLen && buffer.charAt(ptr) == '\n') {
            ptr++;
        }
        return buffer.substring(startIdx, ptr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.427 -0500", hash_original_method = "CE231B51EB0438B81CB38E6BFC514388", hash_generated_method = "6649363E5A8C0FE37387B0B0855AD93D")
    
public String peekLine() {
        int curPos = ptr;
        String retval = this.getLine();
        ptr = curPos;
        return retval;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.429 -0500", hash_original_method = "593E91DFCA6EC80AB3947C1558B0F334", hash_generated_method = "5A5D3FB1E023C8D348AF66216B8E5837")
    
public char lookAhead() throws ParseException {
        return lookAhead(0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.433 -0500", hash_original_method = "3B0FA34B88A8E17E6C68E43CAD5255AA", hash_generated_method = "B721A4921578419DDCE754805A6F2E52")
    
public char lookAhead(int k) throws ParseException {
        // Debug.out.println("ptr = " + ptr);
        try {
            return buffer.charAt(ptr + k);
        }
        catch (IndexOutOfBoundsException e) {
            return '\0';
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.435 -0500", hash_original_method = "D29CC80BBA7473591484322BC854C4EB", hash_generated_method = "FFE99E8753ADAC44D4D9B464C2DC77A1")
    
public char getNextChar() throws ParseException {
        if (ptr >= bufferLen)
            throw new ParseException(
                buffer + " getNextChar: End of buffer",
                ptr);
        else
            return buffer.charAt(ptr++);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.437 -0500", hash_original_method = "5C7E03ECFF7AB12146D632F9E4D67AA3", hash_generated_method = "2E345F054B33F5DAE6ECCF27D89FE1E6")
    
public void consume() {
        ptr = savedPtr;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.440 -0500", hash_original_method = "4CE3B95DEACD36E71CE4EC6691FB056B", hash_generated_method = "E89CBFE1B747D473E143AC704C654193")
    
public void consume(int k) {
        ptr += k;
    }

    /** Get a Vector of the buffer tokenized by lines
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.442 -0500", hash_original_method = "790B12C2E8304128473A5E51B3B58D54", hash_generated_method = "CC392EE82C80CDC1182CF47135ADAA15")
    
public Vector<String> getLines() {
        Vector<String> result = new Vector<String>();
        while (hasMoreChars()) {
            String line = getLine();
            result.addElement(line);
        }
        return result;
    }

    /** Get the next token from the buffer.
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.445 -0500", hash_original_method = "758FF66D123B700B938FDF74929D0C7F", hash_generated_method = "DEC02768A488301A544CA126DE10B91E")
    
public String getNextToken(char delim) throws ParseException {
        int startIdx = ptr;
        while (true) {
            char la = lookAhead(0);
            if (la == delim)
                break;
            else if (la == '\0')
                throw new ParseException("EOL reached", 0);
            consume(1);
        }
        return buffer.substring(startIdx, ptr);
    }
    
}

