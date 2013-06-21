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
    protected String buffer;
    protected int bufferLen;
    protected int ptr;
    protected int savedPtr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.772 -0400", hash_original_method = "54BA219EC49F828609CB54EE2A82793E", hash_generated_method = "829CC47E9AA7BAE84979A930F35B1839")
    @DSModeled(DSC.SAFE)
    protected StringTokenizer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.773 -0400", hash_original_method = "DA5ACD58DF915D63245F1B44E5CF5026", hash_generated_method = "C62A58366E32D14F2F88D1ABE785244E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringTokenizer(String buffer) {
        dsTaint.addTaint(buffer);
        bufferLen = buffer.length();
        ptr = 0;
        // ---------- Original Method ----------
        //this.buffer = buffer;
        //bufferLen = buffer.length();
        //ptr = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.773 -0400", hash_original_method = "51D68C0C294E8AE98A6D3675712278FD", hash_generated_method = "6B7D0D50B0C0BF353A687CF8330AF125")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String nextToken() {
        int startIdx;
        startIdx = ptr;
        {
            char c;
            c = buffer.charAt(ptr);
        } //End block
        String var4113E8803C9F0BFB56BF5E9FF9A1020D_1105881690 = (buffer.substring(startIdx, ptr));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.773 -0400", hash_original_method = "CE3ED718DBD97A207FB6B56A3D84C961", hash_generated_method = "2D4C2142DCBEB9134FABEE278DA053B0")
    @DSModeled(DSC.SAFE)
    public boolean hasMoreChars() {
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.775 -0400", hash_original_method = "4D480BDC007302EAB6B0602B0495288F", hash_generated_method = "D81DDADFDA8A63E0069BBB6078164C09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine() {
        int startIdx;
        startIdx = ptr;
        {
            boolean var3E5C2DFEAE57C26240823D68137FFEDA_529502925 = (ptr < bufferLen && buffer.charAt(ptr) != '\n');
        } //End collapsed parenthetic
        {
            boolean var8A771B1C0BE2C3E6D5EFBE7A86678BF7_2072310675 = (ptr < bufferLen && buffer.charAt(ptr) == '\n');
        } //End collapsed parenthetic
        String var4113E8803C9F0BFB56BF5E9FF9A1020D_1357743964 = (buffer.substring(startIdx, ptr));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.776 -0400", hash_original_method = "CE231B51EB0438B81CB38E6BFC514388", hash_generated_method = "186274A28E21E11BE9BA19FAE08FFDD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String peekLine() {
        int curPos;
        curPos = ptr;
        String retval;
        retval = this.getLine();
        ptr = curPos;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int curPos = ptr;
        //String retval = this.getLine();
        //ptr = curPos;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.776 -0400", hash_original_method = "593E91DFCA6EC80AB3947C1558B0F334", hash_generated_method = "9F91797B037C102E218B6A38DEA72134")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char lookAhead() throws ParseException {
        char var68DCA68240D0BFA25831E87862A3B5AD_779201586 = (lookAhead(0));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return lookAhead(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.776 -0400", hash_original_method = "3B0FA34B88A8E17E6C68E43CAD5255AA", hash_generated_method = "69610FB5D9FC11602B0273D4AE790F98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char lookAhead(int k) throws ParseException {
        dsTaint.addTaint(k);
        try 
        {
            char var53EB20F63B0B1B93DD30B783A1C8D85B_1130520567 = (buffer.charAt(ptr + k));
        } //End block
        catch (IndexOutOfBoundsException e)
        { }
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //try {
            //return buffer.charAt(ptr + k);
        //}
        //catch (IndexOutOfBoundsException e) {
            //return '\0';
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.776 -0400", hash_original_method = "D29CC80BBA7473591484322BC854C4EB", hash_generated_method = "E4A7922EACCFA2FCD7B78CA186483BDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getNextChar() throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                buffer + " getNextChar: End of buffer",
                ptr);
        char var1B9765F94E007E5D13CF38C0B9A2E40C_888431771 = (buffer.charAt(ptr++));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (ptr >= bufferLen)
            //throw new ParseException(
                //buffer + " getNextChar: End of buffer",
                //ptr);
        //else
            //return buffer.charAt(ptr++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.776 -0400", hash_original_method = "5C7E03ECFF7AB12146D632F9E4D67AA3", hash_generated_method = "2A55CB0583276391A21A96648042B85C")
    @DSModeled(DSC.SAFE)
    public void consume() {
        ptr = savedPtr;
        // ---------- Original Method ----------
        //ptr = savedPtr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.776 -0400", hash_original_method = "4CE3B95DEACD36E71CE4EC6691FB056B", hash_generated_method = "EFD039B59E56754493E62D15C102AF14")
    @DSModeled(DSC.SAFE)
    public void consume(int k) {
        dsTaint.addTaint(k);
        // ---------- Original Method ----------
        //ptr += k;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.777 -0400", hash_original_method = "790B12C2E8304128473A5E51B3B58D54", hash_generated_method = "DFB9656087AE379076A600C6431412BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vector<String> getLines() {
        Vector<String> result;
        result = new Vector<String>();
        {
            boolean var4CD8DFB4D7D780E6A99745A5919C270E_1052017421 = (hasMoreChars());
            {
                String line;
                line = getLine();
                result.addElement(line);
            } //End block
        } //End collapsed parenthetic
        return (Vector<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Vector<String> result = new Vector<String>();
        //while (hasMoreChars()) {
            //String line = getLine();
            //result.addElement(line);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.777 -0400", hash_original_method = "758FF66D123B700B938FDF74929D0C7F", hash_generated_method = "FDCC9A17C451B7F66C9553A2B34DAEAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNextToken(char delim) throws ParseException {
        dsTaint.addTaint(delim);
        int startIdx;
        startIdx = ptr;
        {
            char la;
            la = lookAhead(0);
            if (DroidSafeAndroidRuntime.control) throw new ParseException("EOL reached", 0);
            consume(1);
        } //End block
        String var4113E8803C9F0BFB56BF5E9FF9A1020D_1388638030 = (buffer.substring(startIdx, ptr));
        return dsTaint.getTaintString();
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

