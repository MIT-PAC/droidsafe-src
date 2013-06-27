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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.927 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "ED717DDCA3146879332E3CB1E590C4E3")

    protected String buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.927 -0400", hash_original_field = "F310BA9E515FC1007B79A48DB3F601F5", hash_generated_field = "5E4B7A8AC8566734721FEEDF567651D1")

    protected int bufferLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.927 -0400", hash_original_field = "4D9AD2B37053671B594B237BD061B3F2", hash_generated_field = "3DF1878C9AB8F7D115E0E6CEFC4F73A0")

    protected int ptr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.927 -0400", hash_original_field = "4226D6C7FF127D8F1524553080F4827A", hash_generated_field = "0F0615C013337AE815CBF333AD213822")

    protected int savedPtr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.946 -0400", hash_original_method = "54BA219EC49F828609CB54EE2A82793E", hash_generated_method = "829CC47E9AA7BAE84979A930F35B1839")
    protected  StringTokenizer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.948 -0400", hash_original_method = "DA5ACD58DF915D63245F1B44E5CF5026", hash_generated_method = "932701E03D6383C1215DA8D23CF0D394")
    public  StringTokenizer(String buffer) {
        this.buffer = buffer;
        bufferLen = buffer.length();
        ptr = 0;
        // ---------- Original Method ----------
        //this.buffer = buffer;
        //bufferLen = buffer.length();
        //ptr = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.948 -0400", hash_original_method = "51D68C0C294E8AE98A6D3675712278FD", hash_generated_method = "07D47CF698B4DFA8B3371C6A5EE13B6C")
    public String nextToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_1901572515 = null; //Variable for return #1
        int startIdx;
        startIdx = ptr;
        {
            char c;
            c = buffer.charAt(ptr);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1901572515 = buffer.substring(startIdx, ptr);
        varB4EAC82CA7396A68D541C85D26508E83_1901572515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1901572515;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.949 -0400", hash_original_method = "CE3ED718DBD97A207FB6B56A3D84C961", hash_generated_method = "58E0663B6605A018313C33641B2F131B")
    public boolean hasMoreChars() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249273340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_249273340;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.958 -0400", hash_original_method = "4D480BDC007302EAB6B0602B0495288F", hash_generated_method = "1B0B2742E61395C73F348A60C31AE3B3")
    public String getLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_909611873 = null; //Variable for return #1
        int startIdx;
        startIdx = ptr;
        {
            boolean var3E5C2DFEAE57C26240823D68137FFEDA_893876770 = (ptr < bufferLen && buffer.charAt(ptr) != '\n');
        } //End collapsed parenthetic
        {
            boolean var8A771B1C0BE2C3E6D5EFBE7A86678BF7_804404701 = (ptr < bufferLen && buffer.charAt(ptr) == '\n');
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_909611873 = buffer.substring(startIdx, ptr);
        varB4EAC82CA7396A68D541C85D26508E83_909611873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_909611873;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.959 -0400", hash_original_method = "CE231B51EB0438B81CB38E6BFC514388", hash_generated_method = "C634F143B31C4546C8E9B7B8BE10FE03")
    public String peekLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_2130432692 = null; //Variable for return #1
        int curPos;
        curPos = ptr;
        String retval;
        retval = this.getLine();
        ptr = curPos;
        varB4EAC82CA7396A68D541C85D26508E83_2130432692 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2130432692.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2130432692;
        // ---------- Original Method ----------
        //int curPos = ptr;
        //String retval = this.getLine();
        //ptr = curPos;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.965 -0400", hash_original_method = "593E91DFCA6EC80AB3947C1558B0F334", hash_generated_method = "C9CAD9A8CE2F39660BB1D2C72645179A")
    public char lookAhead() throws ParseException {
        char var68DCA68240D0BFA25831E87862A3B5AD_108378939 = (lookAhead(0));
        char varA87DEB01C5F539E6BDA34829C8EF2368_862557880 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_862557880;
        // ---------- Original Method ----------
        //return lookAhead(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.965 -0400", hash_original_method = "3B0FA34B88A8E17E6C68E43CAD5255AA", hash_generated_method = "C075DF732F03D852418DF79594F9F657")
    public char lookAhead(int k) throws ParseException {
        try 
        {
            char var53EB20F63B0B1B93DD30B783A1C8D85B_161856592 = (buffer.charAt(ptr + k));
        } //End block
        catch (IndexOutOfBoundsException e)
        { }
        addTaint(k);
        char varA87DEB01C5F539E6BDA34829C8EF2368_905883523 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_905883523;
        // ---------- Original Method ----------
        //try {
            //return buffer.charAt(ptr + k);
        //}
        //catch (IndexOutOfBoundsException e) {
            //return '\0';
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.965 -0400", hash_original_method = "D29CC80BBA7473591484322BC854C4EB", hash_generated_method = "1F71E84C960F91D1EB508BA59AF747CA")
    public char getNextChar() throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                buffer + " getNextChar: End of buffer",
                ptr);
        char var1B9765F94E007E5D13CF38C0B9A2E40C_2141206838 = (buffer.charAt(ptr++));
        char varA87DEB01C5F539E6BDA34829C8EF2368_493556019 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_493556019;
        // ---------- Original Method ----------
        //if (ptr >= bufferLen)
            //throw new ParseException(
                //buffer + " getNextChar: End of buffer",
                //ptr);
        //else
            //return buffer.charAt(ptr++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.966 -0400", hash_original_method = "5C7E03ECFF7AB12146D632F9E4D67AA3", hash_generated_method = "2A55CB0583276391A21A96648042B85C")
    public void consume() {
        ptr = savedPtr;
        // ---------- Original Method ----------
        //ptr = savedPtr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.966 -0400", hash_original_method = "4CE3B95DEACD36E71CE4EC6691FB056B", hash_generated_method = "3D8CF103538B45433DCFDACE276082D3")
    public void consume(int k) {
        ptr += k;
        // ---------- Original Method ----------
        //ptr += k;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.966 -0400", hash_original_method = "790B12C2E8304128473A5E51B3B58D54", hash_generated_method = "DD5962DA3161727CF5F315B6927F4E35")
    public Vector<String> getLines() {
        Vector<String> varB4EAC82CA7396A68D541C85D26508E83_1142041920 = null; //Variable for return #1
        Vector<String> result;
        result = new Vector<String>();
        {
            boolean var4CD8DFB4D7D780E6A99745A5919C270E_1903662078 = (hasMoreChars());
            {
                String line;
                line = getLine();
                result.addElement(line);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1142041920 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1142041920.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1142041920;
        // ---------- Original Method ----------
        //Vector<String> result = new Vector<String>();
        //while (hasMoreChars()) {
            //String line = getLine();
            //result.addElement(line);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.978 -0400", hash_original_method = "758FF66D123B700B938FDF74929D0C7F", hash_generated_method = "4C1A3070325A0E565C76616A4E1DF2E6")
    public String getNextToken(char delim) throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1282034535 = null; //Variable for return #1
        int startIdx;
        startIdx = ptr;
        {
            char la;
            la = lookAhead(0);
            if (DroidSafeAndroidRuntime.control) throw new ParseException("EOL reached", 0);
            consume(1);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1282034535 = buffer.substring(startIdx, ptr);
        addTaint(delim);
        varB4EAC82CA7396A68D541C85D26508E83_1282034535.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1282034535;
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

