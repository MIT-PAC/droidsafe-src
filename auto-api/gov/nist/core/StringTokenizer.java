package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.*;
import java.text.ParseException;

public class StringTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.873 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "ED717DDCA3146879332E3CB1E590C4E3")

    protected String buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.873 -0400", hash_original_field = "F310BA9E515FC1007B79A48DB3F601F5", hash_generated_field = "5E4B7A8AC8566734721FEEDF567651D1")

    protected int bufferLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.873 -0400", hash_original_field = "4D9AD2B37053671B594B237BD061B3F2", hash_generated_field = "3DF1878C9AB8F7D115E0E6CEFC4F73A0")

    protected int ptr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.873 -0400", hash_original_field = "4226D6C7FF127D8F1524553080F4827A", hash_generated_field = "0F0615C013337AE815CBF333AD213822")

    protected int savedPtr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.873 -0400", hash_original_method = "54BA219EC49F828609CB54EE2A82793E", hash_generated_method = "829CC47E9AA7BAE84979A930F35B1839")
    protected  StringTokenizer() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.873 -0400", hash_original_method = "DA5ACD58DF915D63245F1B44E5CF5026", hash_generated_method = "932701E03D6383C1215DA8D23CF0D394")
    public  StringTokenizer(String buffer) {
        this.buffer = buffer;
        bufferLen = buffer.length();
        ptr = 0;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.874 -0400", hash_original_method = "51D68C0C294E8AE98A6D3675712278FD", hash_generated_method = "AF6A4A0E718092CDFF578F9BF2DCBD69")
    public String nextToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_1039351300 = null; 
        int startIdx = ptr;
        {
            char c = buffer.charAt(ptr);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1039351300 = buffer.substring(startIdx, ptr);
        varB4EAC82CA7396A68D541C85D26508E83_1039351300.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1039351300;
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.874 -0400", hash_original_method = "CE3ED718DBD97A207FB6B56A3D84C961", hash_generated_method = "F5D8FA92BE1FD26B03FA089AA54200E6")
    public boolean hasMoreChars() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350158486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350158486;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isHexDigit(char ch) {
        return (ch >= 'A' && ch <= 'F') ||
               (ch >= 'a' && ch <= 'f') ||
               isDigit(ch);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isAlpha(char ch) {
        if (ch <= 127) {
            return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
        }
        else {
            return Character.isLowerCase(ch) || Character.isUpperCase(ch);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isDigit(char ch) {
        if (ch <= 127) {
            return (ch <= '9' && ch >= '0');
        }
        else {
            return Character.isDigit(ch);
        }
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.876 -0400", hash_original_method = "4D480BDC007302EAB6B0602B0495288F", hash_generated_method = "EE203C6038DA5BEBB15E73856BA224C0")
    public String getLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1757578132 = null; 
        int startIdx = ptr;
        {
            boolean var3E5C2DFEAE57C26240823D68137FFEDA_224745343 = (ptr < bufferLen && buffer.charAt(ptr) != '\n');
        } 
        {
            boolean var8A771B1C0BE2C3E6D5EFBE7A86678BF7_1454545214 = (ptr < bufferLen && buffer.charAt(ptr) == '\n');
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1757578132 = buffer.substring(startIdx, ptr);
        varB4EAC82CA7396A68D541C85D26508E83_1757578132.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1757578132;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.877 -0400", hash_original_method = "CE231B51EB0438B81CB38E6BFC514388", hash_generated_method = "4659718494AA94E69C567784605C0B97")
    public String peekLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_124465904 = null; 
        int curPos = ptr;
        String retval = this.getLine();
        ptr = curPos;
        varB4EAC82CA7396A68D541C85D26508E83_124465904 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_124465904.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_124465904;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.877 -0400", hash_original_method = "593E91DFCA6EC80AB3947C1558B0F334", hash_generated_method = "ADE0A4D87568A91DED7BED976B3FD77F")
    public char lookAhead() throws ParseException {
        char var68DCA68240D0BFA25831E87862A3B5AD_337877404 = (lookAhead(0));
        char varA87DEB01C5F539E6BDA34829C8EF2368_578615998 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_578615998;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.878 -0400", hash_original_method = "3B0FA34B88A8E17E6C68E43CAD5255AA", hash_generated_method = "2B6D981E61CF1A05E7A88FFC4B7B757B")
    public char lookAhead(int k) throws ParseException {
        try 
        {
            char var53EB20F63B0B1B93DD30B783A1C8D85B_302712936 = (buffer.charAt(ptr + k));
        } 
        catch (IndexOutOfBoundsException e)
        { }
        addTaint(k);
        char varA87DEB01C5F539E6BDA34829C8EF2368_957985563 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_957985563;
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.878 -0400", hash_original_method = "D29CC80BBA7473591484322BC854C4EB", hash_generated_method = "488B6217734A22292E4A18757EBD8192")
    public char getNextChar() throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                buffer + " getNextChar: End of buffer",
                ptr);
        char var1B9765F94E007E5D13CF38C0B9A2E40C_1691665949 = (buffer.charAt(ptr++));
        char varA87DEB01C5F539E6BDA34829C8EF2368_986905305 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_986905305;
        
        
            
                
                
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.878 -0400", hash_original_method = "5C7E03ECFF7AB12146D632F9E4D67AA3", hash_generated_method = "2A55CB0583276391A21A96648042B85C")
    public void consume() {
        ptr = savedPtr;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.878 -0400", hash_original_method = "4CE3B95DEACD36E71CE4EC6691FB056B", hash_generated_method = "3D8CF103538B45433DCFDACE276082D3")
    public void consume(int k) {
        ptr += k;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.879 -0400", hash_original_method = "790B12C2E8304128473A5E51B3B58D54", hash_generated_method = "DA434076A74AAAD12F6E6898B2B27BF0")
    public Vector<String> getLines() {
        Vector<String> varB4EAC82CA7396A68D541C85D26508E83_1228911567 = null; 
        Vector<String> result = new Vector<String>();
        {
            boolean var4CD8DFB4D7D780E6A99745A5919C270E_2001004343 = (hasMoreChars());
            {
                String line = getLine();
                result.addElement(line);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1228911567 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1228911567.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1228911567;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.880 -0400", hash_original_method = "758FF66D123B700B938FDF74929D0C7F", hash_generated_method = "460C9708CAE09E57953F3E5E448C4259")
    public String getNextToken(char delim) throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1733011622 = null; 
        int startIdx = ptr;
        {
            char la = lookAhead(0);
            if (DroidSafeAndroidRuntime.control) throw new ParseException("EOL reached", 0);
            consume(1);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1733011622 = buffer.substring(startIdx, ptr);
        addTaint(delim);
        varB4EAC82CA7396A68D541C85D26508E83_1733011622.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1733011622;
        
        
        
            
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

