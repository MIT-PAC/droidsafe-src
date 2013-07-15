package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public final class StackTraceElement implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.459 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EDEEDC9CF5DB299DE0AADD712B8BE51C")

    String declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.459 -0400", hash_original_field = "DDAA6E8C8C412299272E183087B8F7B6", hash_generated_field = "1E5D18395D934B5D254686548A645BA9")

    String methodName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.460 -0400", hash_original_field = "5B063E275D506F65EBF1B02D926F19A4", hash_generated_field = "90A7C14E9FDE747EFC2F1C95E470FF1A")

    String fileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.460 -0400", hash_original_field = "BB8A5A0BF5B38F7D371E940DAED92DA6", hash_generated_field = "330B2760AA91CE77EFBAED3976D7655C")

    int lineNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.461 -0400", hash_original_method = "DB2419D651C8F74CAA343D4DD61F23E8", hash_generated_method = "B8283703B06CDBD382B6A0A79AA23157")
    public  StackTraceElement(String cls, String method, String file, int line) {
    if(cls == null || method == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_6304968 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_6304968.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_6304968;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.462 -0400", hash_original_method = "DC3E276578F22895683C0979CF7614B3", hash_generated_method = "069C2D8BCA6C8CA3D907F0C7C60A9CFB")
	public  StackTraceElement() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.464 -0400", hash_original_method = "7AAA9568018A0DD8A42BBFC0DF2D8ABE", hash_generated_method = "68C95595357519DC0F3947F9280911E1")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(!(obj instanceof StackTraceElement))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1672373483 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947942670 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947942670;
        } //End block
        StackTraceElement castObj = (StackTraceElement) obj;
    if((methodName == null) || (castObj.methodName == null))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1884041914 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297379832 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_297379832;
        } //End block
    if(!getMethodName().equals(castObj.getMethodName()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_591743481 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_521895706 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_521895706;
        } //End block
    if(!getClassName().equals(castObj.getClassName()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_280840253 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1525371967 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1525371967;
        } //End block
        String localFileName = getFileName();
    if(localFileName == null)        
        {
    if(castObj.getFileName() != null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_341127105 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1798219615 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1798219615;
            } //End block
        } //End block
        else
        {
    if(!localFileName.equals(castObj.getFileName()))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1370775698 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2017390208 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2017390208;
            } //End block
        } //End block
    if(getLineNumber() != castObj.getLineNumber())        
        {
            boolean var68934A3E9455FA72420237EB05902327_856823767 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954370043 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954370043;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_38430997 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1317056074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1317056074;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.465 -0400", hash_original_method = "BE14A042BD1289020FF0D183A63A0F88", hash_generated_method = "AEF5361D7F6472DF8585C5188F9987E8")
    public String getClassName() {
String var1810B92D6E9A135AC1D82D9EC8FB1528_564825024 =         (declaringClass == null) ? "<unknown class>" : declaringClass;
        var1810B92D6E9A135AC1D82D9EC8FB1528_564825024.addTaint(taint);
        return var1810B92D6E9A135AC1D82D9EC8FB1528_564825024;
        // ---------- Original Method ----------
        //return (declaringClass == null) ? "<unknown class>" : declaringClass;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.466 -0400", hash_original_method = "0038085273B4122A69DA20E0B00D2EF2", hash_generated_method = "A385670177B76B91D671309FD70C6248")
    public String getFileName() {
String varBD5EACC393579FDF5D0E813DB68A2F73_402240457 =         fileName;
        varBD5EACC393579FDF5D0E813DB68A2F73_402240457.addTaint(taint);
        return varBD5EACC393579FDF5D0E813DB68A2F73_402240457;
        // ---------- Original Method ----------
        //return fileName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.466 -0400", hash_original_method = "0B737233CC5342C14C595BEE1A87604B", hash_generated_method = "1575C4C3F297119941ECC6BADB600A6C")
    public int getLineNumber() {
        int varBB8A5A0BF5B38F7D371E940DAED92DA6_1373649676 = (lineNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620245535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620245535;
        // ---------- Original Method ----------
        //return lineNumber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.467 -0400", hash_original_method = "B15DF5174FD0E5C814CD72B1EE2ECDA2", hash_generated_method = "C07813C047867EBCB8846825D3D0C83B")
    public String getMethodName() {
String varBA91F8E11CBBE6FF21CD058EFF02A40B_1659777187 =         (methodName == null) ? "<unknown method>" : methodName;
        varBA91F8E11CBBE6FF21CD058EFF02A40B_1659777187.addTaint(taint);
        return varBA91F8E11CBBE6FF21CD058EFF02A40B_1659777187;
        // ---------- Original Method ----------
        //return (methodName == null) ? "<unknown method>" : methodName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.468 -0400", hash_original_method = "4C3BE92C911A1E7C2FB757777265DE77", hash_generated_method = "914E0387A9F851E29B3A0BD3100A0EE7")
    @Override
    public int hashCode() {
    if(methodName == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1781523283 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107603838 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107603838;
        } //End block
        int varEE9527A44843E1FDEBCBCA268E20F591_983693751 = (methodName.hashCode() ^ declaringClass.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720042251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720042251;
        // ---------- Original Method ----------
        //if (methodName == null) {
            //return 0;
        //}
        //return methodName.hashCode() ^ declaringClass.hashCode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.469 -0400", hash_original_method = "9234CE459C30A5F4896C026CB51E3A9C", hash_generated_method = "790077AC86D0B925F03BAA63162474B8")
    public boolean isNativeMethod() {
        boolean var1A1A01A6DD717EE94BA470392F83F738_1857534076 = (lineNumber == NATIVE_LINE_NUMBER);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_241212134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_241212134;
        // ---------- Original Method ----------
        //return lineNumber == NATIVE_LINE_NUMBER;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.470 -0400", hash_original_method = "6555BB21F7D49ABF8ADE43CA311A7DFA", hash_generated_method = "C31EF9731DB6F49C5A2B64C803B7A302")
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(80);
        buf.append(getClassName());
        buf.append('.');
        buf.append(getMethodName());
    if(isNativeMethod())        
        {
            buf.append("(Native Method)");
        } //End block
        else
        {
            String fName = getFileName();
    if(fName == null)            
            {
                buf.append("(Unknown Source)");
            } //End block
            else
            {
                int lineNum = getLineNumber();
                buf.append('(');
                buf.append(fName);
    if(lineNum >= 0)                
                {
                    buf.append(':');
                    buf.append(lineNum);
                } //End block
                buf.append(')');
            } //End block
        } //End block
String var4FC680801218E6372BC708D6FA44AE60_144667404 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_144667404.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_144667404;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.471 -0400", hash_original_field = "BBEDD4D329D4F012F7C03204207859AB", hash_generated_field = "26C66B155644317B8367FDF23AF4DB9B")

    private static final long serialVersionUID = 6992337162326171013L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.471 -0400", hash_original_field = "1A0742D9715371D1F34889E0BCB211DA", hash_generated_field = "044B734A1D0D1997F7880A1DDED8AFF6")

    private static final int NATIVE_LINE_NUMBER = -2;
}

