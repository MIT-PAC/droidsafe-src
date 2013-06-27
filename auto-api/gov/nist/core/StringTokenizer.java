package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import java.text.ParseException;

public class StringTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.410 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "ED717DDCA3146879332E3CB1E590C4E3")

    protected String buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.411 -0400", hash_original_field = "F310BA9E515FC1007B79A48DB3F601F5", hash_generated_field = "5E4B7A8AC8566734721FEEDF567651D1")

    protected int bufferLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.411 -0400", hash_original_field = "4D9AD2B37053671B594B237BD061B3F2", hash_generated_field = "3DF1878C9AB8F7D115E0E6CEFC4F73A0")

    protected int ptr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.411 -0400", hash_original_field = "4226D6C7FF127D8F1524553080F4827A", hash_generated_field = "0F0615C013337AE815CBF333AD213822")

    protected int savedPtr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.412 -0400", hash_original_method = "54BA219EC49F828609CB54EE2A82793E", hash_generated_method = "829CC47E9AA7BAE84979A930F35B1839")
    protected  StringTokenizer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.412 -0400", hash_original_method = "DA5ACD58DF915D63245F1B44E5CF5026", hash_generated_method = "932701E03D6383C1215DA8D23CF0D394")
    public  StringTokenizer(String buffer) {
        this.buffer = buffer;
        bufferLen = buffer.length();
        ptr = 0;
        // ---------- Original Method ----------
        //this.buffer = buffer;
        //bufferLen = buffer.length();
        //ptr = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.413 -0400", hash_original_method = "51D68C0C294E8AE98A6D3675712278FD", hash_generated_method = "49449B3F653ECF4495043814ED43AB55")
    public String nextToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_366409647 = null; //Variable for return #1
        int startIdx;
        startIdx = ptr;
        {
            char c;
            c = buffer.charAt(ptr);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_366409647 = buffer.substring(startIdx, ptr);
        varB4EAC82CA7396A68D541C85D26508E83_366409647.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_366409647;
        // ---------- Original Method ----------
        //int startIdx = ptr;
        //while (ptr < bufferLen) {
            //char c = buffer.charAt(ptr);
            //ptr++;
            //if (c == '\n') {
                //break;
            //}
        //}
        //return buffer.substring(startIdx, ptr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.413 -0400", hash_original_method = "CE3ED718DBD97A207FB6B56A3D84C961", hash_generated_method = "937DBC9030F74CD68657FECB1299E6A0")
    public boolean hasMoreChars() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471408176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_471408176;
        // ---------- Original Method ----------
        //return ptr < bufferLen;
    }

    
        public static boolean isHexDigit(char ch) {
        return (ch >= 'A' && ch <= 'F') ||
               (ch >= 'a' && ch <= 'f') ||
               isDigit(ch);
    }

    
        public static boolean isAlpha(char ch) {
        if (ch <= 127) {
            return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
        }
        else {
            return Character.isLowerCase(ch) || Character.isUpperCase(ch);
        }
    }

    
        public static boolean isDigit(char ch) {
        if (ch <= 127) {
            return (ch <= '9' && ch >= '0');
        }
        else {
            return Character.isDigit(ch);
        }
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.438 -0400", hash_original_method = "4D480BDC007302EAB6B0602B0495288F", hash_generated_method = "24354F5A0D6405496002F27B959BE887")
    public String getLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1882636926 = null; //Variable for return #1
        int startIdx;
        startIdx = ptr;
        {
            boolean var3E5C2DFEAE57C26240823D68137FFEDA_1511020498 = (ptr < bufferLen && buffer.charAt(ptr) != '\n');
        } //End collapsed parenthetic
        {
            boolean var8A771B1C0BE2C3E6D5EFBE7A86678BF7_1286996543 = (ptr < bufferLen && buffer.charAt(ptr) == '\n');
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1882636926 = buffer.substring(startIdx, ptr);
        varB4EAC82CA7396A68D541C85D26508E83_1882636926.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1882636926;
        // ---------- Original Method ----------
        //int startIdx = ptr;
        //while (ptr < bufferLen && buffer.charAt(ptr) != '\n') {
            //ptr++;
        //}
        //if (ptr < bufferLen && buffer.charAt(ptr) == '\n') {
            //ptr++;
        //}
        //return buffer.substring(startIdx, ptr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.440 -0400", hash_original_method = "CE231B51EB0438B81CB38E6BFC514388", hash_generated_method = "B267D0369AAB88CC996FFA5373668A19")
    public String peekLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_2145148862 = null; //Variable for return #1
        int curPos;
        curPos = ptr;
        String retval;
        retval = this.getLine();
        ptr = curPos;
        varB4EAC82CA7396A68D541C85D26508E83_2145148862 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2145148862.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2145148862;
        // ---------- Original Method ----------
        //int curPos = ptr;
        //String retval = this.getLine();
        //ptr = curPos;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.440 -0400", hash_original_method = "593E91DFCA6EC80AB3947C1558B0F334", hash_generated_method = "8133F06490722CD31D0E4B0B9533619F")
    public char lookAhead() throws ParseException {
        char var68DCA68240D0BFA25831E87862A3B5AD_1893782911 = (lookAhead(0));
        char varA87DEB01C5F539E6BDA34829C8EF2368_41620465 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_41620465;
        // ---------- Original Method ----------
        //return lookAhead(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.440 -0400", hash_original_method = "3B0FA34B88A8E17E6C68E43CAD5255AA", hash_generated_method = "28CB3FC3B1D822C110023549130A83F6")
    public char lookAhead(int k) throws ParseException {
        try 
        {
            char var53EB20F63B0B1B93DD30B783A1C8D85B_1861675190 = (buffer.charAt(ptr + k));
        } //End block
        catch (IndexOutOfBoundsException e)
        { }
        addTaint(k);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1009246855 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1009246855;
        // ---------- Original Method ----------
        //try {
            //return buffer.charAt(ptr + k);
        //}
        //catch (IndexOutOfBoundsException e) {
            //return '\0';
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.441 -0400", hash_original_method = "D29CC80BBA7473591484322BC854C4EB", hash_generated_method = "D9944B3A50CFFA9A79B251C31569E13D")
    public char getNextChar() throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                buffer + " getNextChar: End of buffer",
                ptr);
        char var1B9765F94E007E5D13CF38C0B9A2E40C_915354967 = (buffer.charAt(ptr++));
        char varA87DEB01C5F539E6BDA34829C8EF2368_1255088026 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1255088026;
        // ---------- Original Method ----------
        //if (ptr >= bufferLen)
            //throw new ParseException(
                //buffer + " getNextChar: End of buffer",
                //ptr);
        //else
            //return buffer.charAt(ptr++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.442 -0400", hash_original_method = "5C7E03ECFF7AB12146D632F9E4D67AA3", hash_generated_method = "2A55CB0583276391A21A96648042B85C")
    public void consume() {
        ptr = savedPtr;
        // ---------- Original Method ----------
        //ptr = savedPtr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.450 -0400", hash_original_method = "4CE3B95DEACD36E71CE4EC6691FB056B", hash_generated_method = "3D8CF103538B45433DCFDACE276082D3")
    public void consume(int k) {
        ptr += k;
        // ---------- Original Method ----------
        //ptr += k;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.450 -0400", hash_original_method = "790B12C2E8304128473A5E51B3B58D54", hash_generated_method = "C6FF36D85F2319BA36CA8D9281374F39")
    public Vector<String> getLines() {
        Vector<String> varB4EAC82CA7396A68D541C85D26508E83_1817119558 = null; //Variable for return #1
        Vector<String> result;
        result = new Vector<String>();
        {
            boolean var4CD8DFB4D7D780E6A99745A5919C270E_1930666171 = (hasMoreChars());
            {
                String line;
                line = getLine();
                result.addElement(line);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1817119558 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1817119558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1817119558;
        // ---------- Original Method ----------
        //Vector<String> result = new Vector<String>();
        //while (hasMoreChars()) {
            //String line = getLine();
            //result.addElement(line);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.462 -0400", hash_original_method = "758FF66D123B700B938FDF74929D0C7F", hash_generated_method = "FD49B4BFD43242F48F19D5D4701504B0")
    public String getNextToken(char delim) throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1114370172 = null; //Variable for return #1
        int startIdx;
        startIdx = ptr;
        {
            char la;
            la = lookAhead(0);
            if (DroidSafeAndroidRuntime.control) throw new ParseException("EOL reached", 0);
            consume(1);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1114370172 = buffer.substring(startIdx, ptr);
        addTaint(delim);
        varB4EAC82CA7396A68D541C85D26508E83_1114370172.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1114370172;
        // ---------- Original Method ----------
        //int startIdx = ptr;
        //while (true) {
            //char la = lookAhead(0);
            //if (la == delim)
                //break;
            //else if (la == '\0')
                //throw new ParseException("EOL reached", 0);
            //consume(1);
        //}
        //return buffer.substring(startIdx, ptr);
    }

    
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

    
}

