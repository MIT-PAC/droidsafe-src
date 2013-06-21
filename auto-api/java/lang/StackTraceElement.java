package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class StackTraceElement implements Serializable {
    String declaringClass;
    String methodName;
    String fileName;
    int lineNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.096 -0400", hash_original_method = "DB2419D651C8F74CAA343D4DD61F23E8", hash_generated_method = "E4B76E297B06B13AF5E641B42C6AB7B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StackTraceElement(String cls, String method, String file, int line) {
        dsTaint.addTaint(cls);
        dsTaint.addTaint(file);
        dsTaint.addTaint(line);
        dsTaint.addTaint(method);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (cls == null || method == null) {
            //throw new NullPointerException();
        //}
        //declaringClass = cls;
        //methodName = method;
        //fileName = file;
        //lineNumber = line;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.097 -0400", hash_original_method = "DC3E276578F22895683C0979CF7614B3", hash_generated_method = "069C2D8BCA6C8CA3D907F0C7C60A9CFB")
    @DSModeled(DSC.SAFE)
    private StackTraceElement() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.097 -0400", hash_original_method = "7AAA9568018A0DD8A42BBFC0DF2D8ABE", hash_generated_method = "90B741B2EAA70E1A6CABCF5BCF0AD622")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        StackTraceElement castObj;
        castObj = (StackTraceElement) obj;
        {
            boolean var4BC1CC2465203AE05F59B5EF01C2AA61_627321167 = (!getMethodName().equals(castObj.getMethodName()));
        } //End collapsed parenthetic
        {
            boolean var0A01EA11BC874E0353CE94981782ABEC_623093548 = (!getClassName().equals(castObj.getClassName()));
        } //End collapsed parenthetic
        String localFileName;
        localFileName = getFileName();
        {
            {
                boolean var855BEABF1DC56714D1D35B65EDEEF057_269851712 = (castObj.getFileName() != null);
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var78726935C882765323ACE0B369846920_1987698591 = (!localFileName.equals(castObj.getFileName()));
            } //End collapsed parenthetic
        } //End block
        {
            boolean varAFE1BA9B8262F51E1250D8ECCBB743B3_296831210 = (getLineNumber() != castObj.getLineNumber());
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.097 -0400", hash_original_method = "BE14A042BD1289020FF0D183A63A0F88", hash_generated_method = "F83F4CFE3CCBCA8EC6EC3988532BFA5B")
    @DSModeled(DSC.SAFE)
    public String getClassName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (declaringClass == null) ? "<unknown class>" : declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.098 -0400", hash_original_method = "0038085273B4122A69DA20E0B00D2EF2", hash_generated_method = "2FA1D76E8380365B0D95BF40DE0EAEBA")
    @DSModeled(DSC.SAFE)
    public String getFileName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return fileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.098 -0400", hash_original_method = "0B737233CC5342C14C595BEE1A87604B", hash_generated_method = "8FBB8E3CC75CF90102A14D266C28BCCC")
    @DSModeled(DSC.SAFE)
    public int getLineNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.098 -0400", hash_original_method = "B15DF5174FD0E5C814CD72B1EE2ECDA2", hash_generated_method = "31699EAE98DF6F3472BF544396DDF4FC")
    @DSModeled(DSC.SAFE)
    public String getMethodName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (methodName == null) ? "<unknown method>" : methodName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.098 -0400", hash_original_method = "4C3BE92C911A1E7C2FB757777265DE77", hash_generated_method = "8A2E7A2A72E918C7127EEDBA421D56A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var8139D054AA9461A68779885460C701BB_570130377 = (methodName.hashCode() ^ declaringClass.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (methodName == null) {
            //return 0;
        //}
        //return methodName.hashCode() ^ declaringClass.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.098 -0400", hash_original_method = "9234CE459C30A5F4896C026CB51E3A9C", hash_generated_method = "9580D7857430C98EE08636E199259EE2")
    @DSModeled(DSC.SAFE)
    public boolean isNativeMethod() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return lineNumber == NATIVE_LINE_NUMBER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.099 -0400", hash_original_method = "6555BB21F7D49ABF8ADE43CA311A7DFA", hash_generated_method = "E9CEB93D74BD26BF3AE31FEEAD5F569E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder buf;
        buf = new StringBuilder(80);
        buf.append(getClassName());
        buf.append('.');
        buf.append(getMethodName());
        {
            boolean varA7B0F8A6FF2DC066B4C8C1B75F419AD1_1892356890 = (isNativeMethod());
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
        String var0C174602EFE4BFBCB80A7056CFA680FB_842846041 = (buf.toString());
        return dsTaint.getTaintString();
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

    
    private static final long serialVersionUID = 6992337162326171013L;
    private static final int NATIVE_LINE_NUMBER = -2;
}

