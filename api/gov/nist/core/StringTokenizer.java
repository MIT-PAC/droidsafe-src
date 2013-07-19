package gov.nist.core;

// Droidsafe Imports
import java.text.ParseException;
import java.util.Vector;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class StringTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.725 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "ED717DDCA3146879332E3CB1E590C4E3")

    protected String buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.725 -0400", hash_original_field = "F310BA9E515FC1007B79A48DB3F601F5", hash_generated_field = "5E4B7A8AC8566734721FEEDF567651D1")

    protected int bufferLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.725 -0400", hash_original_field = "4D9AD2B37053671B594B237BD061B3F2", hash_generated_field = "3DF1878C9AB8F7D115E0E6CEFC4F73A0")

    protected int ptr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.725 -0400", hash_original_field = "4226D6C7FF127D8F1524553080F4827A", hash_generated_field = "0F0615C013337AE815CBF333AD213822")

    protected int savedPtr;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.725 -0400", hash_original_method = "54BA219EC49F828609CB54EE2A82793E", hash_generated_method = "829CC47E9AA7BAE84979A930F35B1839")
    protected  StringTokenizer() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.725 -0400", hash_original_method = "DA5ACD58DF915D63245F1B44E5CF5026", hash_generated_method = "932701E03D6383C1215DA8D23CF0D394")
    public  StringTokenizer(String buffer) {
        this.buffer = buffer;
        bufferLen = buffer.length();
        ptr = 0;
        // ---------- Original Method ----------
        //this.buffer = buffer;
        //bufferLen = buffer.length();
        //ptr = 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.726 -0400", hash_original_method = "51D68C0C294E8AE98A6D3675712278FD", hash_generated_method = "7253871F6270384B8581D19E7C266B9B")
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
            } //End block
        } //End block
String var6AFF5978BAB12C2506D33445AED98631_1898343064 =         buffer.substring(startIdx, ptr);
        var6AFF5978BAB12C2506D33445AED98631_1898343064.addTaint(taint);
        return var6AFF5978BAB12C2506D33445AED98631_1898343064;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.726 -0400", hash_original_method = "CE3ED718DBD97A207FB6B56A3D84C961", hash_generated_method = "0790218561C67D21271D50BF86BE3667")
    public boolean hasMoreChars() {
        boolean var39BF37FF4313B82D5AEAB5612B20E2EB_637190696 = (ptr < bufferLen);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_970880297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_970880297;
        // ---------- Original Method ----------
        //return ptr < bufferLen;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.728 -0400", hash_original_method = "4D480BDC007302EAB6B0602B0495288F", hash_generated_method = "8BA799E2A56BE0A9DAFE0912CC54B71C")
    public String getLine() {
        int startIdx = ptr;
        while
(ptr < bufferLen && buffer.charAt(ptr) != '\n')        
        {
            ptr++;
        } //End block
        if(ptr < bufferLen && buffer.charAt(ptr) == '\n')        
        {
            ptr++;
        } //End block
String var6AFF5978BAB12C2506D33445AED98631_322181570 =         buffer.substring(startIdx, ptr);
        var6AFF5978BAB12C2506D33445AED98631_322181570.addTaint(taint);
        return var6AFF5978BAB12C2506D33445AED98631_322181570;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.728 -0400", hash_original_method = "CE231B51EB0438B81CB38E6BFC514388", hash_generated_method = "13E03335F76B779ADB2DC90D79E7D410")
    public String peekLine() {
        int curPos = ptr;
        String retval = this.getLine();
        ptr = curPos;
String varF9E19AD6135C970F387F77C6F3DE4477_1236475080 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1236475080.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1236475080;
        // ---------- Original Method ----------
        //int curPos = ptr;
        //String retval = this.getLine();
        //ptr = curPos;
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.728 -0400", hash_original_method = "593E91DFCA6EC80AB3947C1558B0F334", hash_generated_method = "4310B572455E8E1315084EC32859480A")
    public char lookAhead() throws ParseException {
        char varA40DDAE514814BC55844536D2DD1C8F6_1297661329 = (lookAhead(0));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1849496489 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1849496489;
        // ---------- Original Method ----------
        //return lookAhead(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.729 -0400", hash_original_method = "3B0FA34B88A8E17E6C68E43CAD5255AA", hash_generated_method = "6FD28030C010D1629FBAB17D53C5A018")
    public char lookAhead(int k) throws ParseException {
        addTaint(k);
        try 
        {
            char var3A2AA1EDB2247E6E1E464C51164D8296_684825502 = (buffer.charAt(ptr + k));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1662798228 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1662798228;
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            char var2FD040853066E22941CBCC768B6AFCE6_758674008 = ('\0');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1277529111 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1277529111;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return buffer.charAt(ptr + k);
        //}
        //catch (IndexOutOfBoundsException e) {
            //return '\0';
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.729 -0400", hash_original_method = "D29CC80BBA7473591484322BC854C4EB", hash_generated_method = "6522C4C856146F3E2470B9939C756BE4")
    public char getNextChar() throws ParseException {
        if(ptr >= bufferLen)        
        {
        ParseException varEFCF9663E555E1BB74E2E54256287E88_1844632078 = new ParseException(
                buffer + " getNextChar: End of buffer",
                ptr);
        varEFCF9663E555E1BB74E2E54256287E88_1844632078.addTaint(taint);
        throw varEFCF9663E555E1BB74E2E54256287E88_1844632078;
        }
        else
        {
        char varB3E68DC74151621FC9ED6080296078D7_66888081 = (buffer.charAt(ptr++));
                char varA87DEB01C5F539E6BDA34829C8EF2368_685778899 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_685778899;
        }
        // ---------- Original Method ----------
        //if (ptr >= bufferLen)
            //throw new ParseException(
                //buffer + " getNextChar: End of buffer",
                //ptr);
        //else
            //return buffer.charAt(ptr++);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.730 -0400", hash_original_method = "5C7E03ECFF7AB12146D632F9E4D67AA3", hash_generated_method = "2A55CB0583276391A21A96648042B85C")
    public void consume() {
        ptr = savedPtr;
        // ---------- Original Method ----------
        //ptr = savedPtr;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.730 -0400", hash_original_method = "4CE3B95DEACD36E71CE4EC6691FB056B", hash_generated_method = "3D8CF103538B45433DCFDACE276082D3")
    public void consume(int k) {
        ptr += k;
        // ---------- Original Method ----------
        //ptr += k;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.731 -0400", hash_original_method = "790B12C2E8304128473A5E51B3B58D54", hash_generated_method = "75343BEBFF6FC17DE7E2D58A9AD6D183")
    public Vector<String> getLines() {
        Vector<String> result = new Vector<String>();
        while
(hasMoreChars())        
        {
            String line = getLine();
            result.addElement(line);
        } //End block
Vector<String> varDC838461EE2FA0CA4C9BBB70A15456B0_577401862 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_577401862.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_577401862;
        // ---------- Original Method ----------
        //Vector<String> result = new Vector<String>();
        //while (hasMoreChars()) {
            //String line = getLine();
            //result.addElement(line);
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.732 -0400", hash_original_method = "758FF66D123B700B938FDF74929D0C7F", hash_generated_method = "40EBEACBDDCEE13ED20C8F06DE42EC9E")
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
            ParseException varDC410FCF0824EF4154B2896FE55A85EA_1350145645 = new ParseException("EOL reached", 0);
            varDC410FCF0824EF4154B2896FE55A85EA_1350145645.addTaint(taint);
            throw varDC410FCF0824EF4154B2896FE55A85EA_1350145645;
            }
            consume(1);
        } //End block
String var6AFF5978BAB12C2506D33445AED98631_251220828 =         buffer.substring(startIdx, ptr);
        var6AFF5978BAB12C2506D33445AED98631_251220828.addTaint(taint);
        return var6AFF5978BAB12C2506D33445AED98631_251220828;
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

