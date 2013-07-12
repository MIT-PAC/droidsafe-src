package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.text.ParseException;

public class StringTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.772 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "ED717DDCA3146879332E3CB1E590C4E3")

    protected String buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.772 -0400", hash_original_field = "F310BA9E515FC1007B79A48DB3F601F5", hash_generated_field = "5E4B7A8AC8566734721FEEDF567651D1")

    protected int bufferLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.773 -0400", hash_original_field = "4D9AD2B37053671B594B237BD061B3F2", hash_generated_field = "3DF1878C9AB8F7D115E0E6CEFC4F73A0")

    protected int ptr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.773 -0400", hash_original_field = "4226D6C7FF127D8F1524553080F4827A", hash_generated_field = "0F0615C013337AE815CBF333AD213822")

    protected int savedPtr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.773 -0400", hash_original_method = "54BA219EC49F828609CB54EE2A82793E", hash_generated_method = "829CC47E9AA7BAE84979A930F35B1839")
    protected  StringTokenizer() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.774 -0400", hash_original_method = "DA5ACD58DF915D63245F1B44E5CF5026", hash_generated_method = "932701E03D6383C1215DA8D23CF0D394")
    public  StringTokenizer(String buffer) {
        this.buffer = buffer;
        bufferLen = buffer.length();
        ptr = 0;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.774 -0400", hash_original_method = "51D68C0C294E8AE98A6D3675712278FD", hash_generated_method = "173E0AF2F33ED85F57953A508661C371")
    public String nextToken() {
        int startIdx = ptr;
        while
(ptr < bufferLen)        
        {
            char c = buffer.charAt(ptr);
            ptr++;
    if(c == '\n')            
            {
                break;
            } 
        } 
String var6AFF5978BAB12C2506D33445AED98631_1389258036 =         buffer.substring(startIdx, ptr);
        var6AFF5978BAB12C2506D33445AED98631_1389258036.addTaint(taint);
        return var6AFF5978BAB12C2506D33445AED98631_1389258036;
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.774 -0400", hash_original_method = "CE3ED718DBD97A207FB6B56A3D84C961", hash_generated_method = "33FF441061FB087B2A8C97301CD3A35E")
    public boolean hasMoreChars() {
        boolean var39BF37FF4313B82D5AEAB5612B20E2EB_919733325 = (ptr < bufferLen);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1773577781 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1773577781;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.776 -0400", hash_original_method = "4D480BDC007302EAB6B0602B0495288F", hash_generated_method = "3489B54E7D436B5A067FF67DA178D576")
    public String getLine() {
        int startIdx = ptr;
        while
(ptr < bufferLen && buffer.charAt(ptr) != '\n')        
        {
            ptr++;
        } 
    if(ptr < bufferLen && buffer.charAt(ptr) == '\n')        
        {
            ptr++;
        } 
String var6AFF5978BAB12C2506D33445AED98631_999730499 =         buffer.substring(startIdx, ptr);
        var6AFF5978BAB12C2506D33445AED98631_999730499.addTaint(taint);
        return var6AFF5978BAB12C2506D33445AED98631_999730499;
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.776 -0400", hash_original_method = "CE231B51EB0438B81CB38E6BFC514388", hash_generated_method = "34D3273713220F0D28C3870A9FEB3E0F")
    public String peekLine() {
        int curPos = ptr;
        String retval = this.getLine();
        ptr = curPos;
String varF9E19AD6135C970F387F77C6F3DE4477_1394373865 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1394373865.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1394373865;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.776 -0400", hash_original_method = "593E91DFCA6EC80AB3947C1558B0F334", hash_generated_method = "92298377A54E643023AD42A40E0624D7")
    public char lookAhead() throws ParseException {
        char varA40DDAE514814BC55844536D2DD1C8F6_1617705763 = (lookAhead(0));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1391958916 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1391958916;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.777 -0400", hash_original_method = "3B0FA34B88A8E17E6C68E43CAD5255AA", hash_generated_method = "144B80055BAF903BADCBE4A259DD085F")
    public char lookAhead(int k) throws ParseException {
        addTaint(k);
        try 
        {
            char var3A2AA1EDB2247E6E1E464C51164D8296_2141086171 = (buffer.charAt(ptr + k));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1344295643 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1344295643;
        } 
        catch (IndexOutOfBoundsException e)
        {
            char var2FD040853066E22941CBCC768B6AFCE6_2146319462 = ('\0');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_946927107 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_946927107;
        } 
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.777 -0400", hash_original_method = "D29CC80BBA7473591484322BC854C4EB", hash_generated_method = "8705C722149F7C2B2677E1D28340BA82")
    public char getNextChar() throws ParseException {
    if(ptr >= bufferLen)        
        {
        ParseException varEFCF9663E555E1BB74E2E54256287E88_445051471 = new ParseException(
                buffer + " getNextChar: End of buffer",
                ptr);
        varEFCF9663E555E1BB74E2E54256287E88_445051471.addTaint(taint);
        throw varEFCF9663E555E1BB74E2E54256287E88_445051471;
        }
        else
        {
        char varB3E68DC74151621FC9ED6080296078D7_444942101 = (buffer.charAt(ptr++));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1743476676 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1743476676;
        }
        
        
            
                
                
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.777 -0400", hash_original_method = "5C7E03ECFF7AB12146D632F9E4D67AA3", hash_generated_method = "2A55CB0583276391A21A96648042B85C")
    public void consume() {
        ptr = savedPtr;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.778 -0400", hash_original_method = "4CE3B95DEACD36E71CE4EC6691FB056B", hash_generated_method = "3D8CF103538B45433DCFDACE276082D3")
    public void consume(int k) {
        ptr += k;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.778 -0400", hash_original_method = "790B12C2E8304128473A5E51B3B58D54", hash_generated_method = "3D32C4319B0B29C496BB5A8D87FFA33C")
    public Vector<String> getLines() {
        Vector<String> result = new Vector<String>();
        while
(hasMoreChars())        
        {
            String line = getLine();
            result.addElement(line);
        } 
Vector<String> varDC838461EE2FA0CA4C9BBB70A15456B0_697400642 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_697400642.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_697400642;
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.778 -0400", hash_original_method = "758FF66D123B700B938FDF74929D0C7F", hash_generated_method = "E9FDF7EC95CFBFFDADDA32B3A3542984")
    public String getNextToken(char delim) throws ParseException {
        addTaint(delim);
        int startIdx = ptr;
        while
(true)        
        {
            char la = lookAhead(0);
    if(la == delim)            
            break;
            else
    if(la == '\0')            
            {
            ParseException varDC410FCF0824EF4154B2896FE55A85EA_1240686688 = new ParseException("EOL reached", 0);
            varDC410FCF0824EF4154B2896FE55A85EA_1240686688.addTaint(taint);
            throw varDC410FCF0824EF4154B2896FE55A85EA_1240686688;
            }
            consume(1);
        } 
String var6AFF5978BAB12C2506D33445AED98631_52399566 =         buffer.substring(startIdx, ptr);
        var6AFF5978BAB12C2506D33445AED98631_52399566.addTaint(taint);
        return var6AFF5978BAB12C2506D33445AED98631_52399566;
        
        
        
            
            
                
            
                
            
        
        
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

