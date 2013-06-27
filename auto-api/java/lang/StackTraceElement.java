package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class StackTraceElement implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.344 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EDEEDC9CF5DB299DE0AADD712B8BE51C")

    String declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.344 -0400", hash_original_field = "DDAA6E8C8C412299272E183087B8F7B6", hash_generated_field = "1E5D18395D934B5D254686548A645BA9")

    String methodName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.344 -0400", hash_original_field = "5B063E275D506F65EBF1B02D926F19A4", hash_generated_field = "90A7C14E9FDE747EFC2F1C95E470FF1A")

    String fileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.344 -0400", hash_original_field = "BB8A5A0BF5B38F7D371E940DAED92DA6", hash_generated_field = "330B2760AA91CE77EFBAED3976D7655C")

    int lineNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.345 -0400", hash_original_method = "DB2419D651C8F74CAA343D4DD61F23E8", hash_generated_method = "1FEFAEDE532FDA3BE22E11D8038F7D8F")
    public  StackTraceElement(String cls, String method, String file, int line) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        declaringClass = cls;
        methodName = method;
        fileName = file;
        lineNumber = line;
        // ---------- Original Method ----------
        //if (cls == null || method == null) {
            //throw new NullPointerException();
        //}
        //declaringClass = cls;
        //methodName = method;
        //fileName = file;
        //lineNumber = line;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.345 -0400", hash_original_method = "DC3E276578F22895683C0979CF7614B3", hash_generated_method = "069C2D8BCA6C8CA3D907F0C7C60A9CFB")
    private  StackTraceElement() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.346 -0400", hash_original_method = "7AAA9568018A0DD8A42BBFC0DF2D8ABE", hash_generated_method = "BA504E5C26082B3B7F9BA9CAB8113937")
    @Override
    public boolean equals(Object obj) {
        StackTraceElement castObj;
        castObj = (StackTraceElement) obj;
        {
            boolean var4BC1CC2465203AE05F59B5EF01C2AA61_1343146158 = (!getMethodName().equals(castObj.getMethodName()));
        } //End collapsed parenthetic
        {
            boolean var0A01EA11BC874E0353CE94981782ABEC_615775880 = (!getClassName().equals(castObj.getClassName()));
        } //End collapsed parenthetic
        String localFileName;
        localFileName = getFileName();
        {
            {
                boolean var855BEABF1DC56714D1D35B65EDEEF057_1825284423 = (castObj.getFileName() != null);
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var78726935C882765323ACE0B369846920_599685502 = (!localFileName.equals(castObj.getFileName()));
            } //End collapsed parenthetic
        } //End block
        {
            boolean varAFE1BA9B8262F51E1250D8ECCBB743B3_1931715582 = (getLineNumber() != castObj.getLineNumber());
        } //End collapsed parenthetic
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_679160620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_679160620;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.346 -0400", hash_original_method = "BE14A042BD1289020FF0D183A63A0F88", hash_generated_method = "56DC3D4FBAEE496504E90769865B6766")
    public String getClassName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1542497989 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1542497989 = (declaringClass == null) ? "<unknown class>" : declaringClass;
        varB4EAC82CA7396A68D541C85D26508E83_1542497989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1542497989;
        // ---------- Original Method ----------
        //return (declaringClass == null) ? "<unknown class>" : declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.347 -0400", hash_original_method = "0038085273B4122A69DA20E0B00D2EF2", hash_generated_method = "27E6BD75B832B1901676653011859E4A")
    public String getFileName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1676868018 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1676868018 = fileName;
        varB4EAC82CA7396A68D541C85D26508E83_1676868018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1676868018;
        // ---------- Original Method ----------
        //return fileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.347 -0400", hash_original_method = "0B737233CC5342C14C595BEE1A87604B", hash_generated_method = "513AC3F862E17CEB2514FDA7B75F5E1A")
    public int getLineNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647082823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647082823;
        // ---------- Original Method ----------
        //return lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.348 -0400", hash_original_method = "B15DF5174FD0E5C814CD72B1EE2ECDA2", hash_generated_method = "A304BD1763BD72CD3C5B5F24F0A94843")
    public String getMethodName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1526670193 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1526670193 = (methodName == null) ? "<unknown method>" : methodName;
        varB4EAC82CA7396A68D541C85D26508E83_1526670193.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1526670193;
        // ---------- Original Method ----------
        //return (methodName == null) ? "<unknown method>" : methodName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.355 -0400", hash_original_method = "4C3BE92C911A1E7C2FB757777265DE77", hash_generated_method = "B27A2BA63D820BD9964605C5A5F77096")
    @Override
    public int hashCode() {
        int var8139D054AA9461A68779885460C701BB_1908093250 = (methodName.hashCode() ^ declaringClass.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525829387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525829387;
        // ---------- Original Method ----------
        //if (methodName == null) {
            //return 0;
        //}
        //return methodName.hashCode() ^ declaringClass.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.355 -0400", hash_original_method = "9234CE459C30A5F4896C026CB51E3A9C", hash_generated_method = "42F62B0F4B624986DDB79D412964A806")
    public boolean isNativeMethod() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_363406302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_363406302;
        // ---------- Original Method ----------
        //return lineNumber == NATIVE_LINE_NUMBER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.356 -0400", hash_original_method = "6555BB21F7D49ABF8ADE43CA311A7DFA", hash_generated_method = "CF57BAC43EF52683F8AC4A5628CE12AB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_429661943 = null; //Variable for return #1
        StringBuilder buf;
        buf = new StringBuilder(80);
        buf.append(getClassName());
        buf.append('.');
        buf.append(getMethodName());
        {
            boolean varA7B0F8A6FF2DC066B4C8C1B75F419AD1_759770542 = (isNativeMethod());
            {
                buf.append("(Native Method)");
            } //End block
            {
                String fName;
                fName = getFileName();
                {
                    buf.append("(Unknown Source)");
                } //End block
                {
                    int lineNum;
                    lineNum = getLineNumber();
                    buf.append('(');
                    buf.append(fName);
                    {
                        buf.append(':');
                        buf.append(lineNum);
                    } //End block
                    buf.append(')');
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_429661943 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_429661943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_429661943;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder(80);
        //buf.append(getClassName());
        //buf.append('.');
        //buf.append(getMethodName());
        //if (isNativeMethod()) {
            //buf.append("(Native Method)");
        //} else {
            //String fName = getFileName();
            //if (fName == null) {
                //buf.append("(Unknown Source)");
            //} else {
                //int lineNum = getLineNumber();
                //buf.append('(');
                //buf.append(fName);
                //if (lineNum >= 0) {
                    //buf.append(':');
                    //buf.append(lineNum);
                //}
                //buf.append(')');
            //}
        //}
        //return buf.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.356 -0400", hash_original_field = "BBEDD4D329D4F012F7C03204207859AB", hash_generated_field = "7DC25DB9FAD4913A11FAF0DEB47036A7")

    private static long serialVersionUID = 6992337162326171013L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.356 -0400", hash_original_field = "1A0742D9715371D1F34889E0BCB211DA", hash_generated_field = "3A5BC9102FB765C867A2EDAC8ECF22B9")

    private static int NATIVE_LINE_NUMBER = -2;
}

