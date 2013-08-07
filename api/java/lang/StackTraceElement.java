package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;






public final class StackTraceElement implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.654 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EDEEDC9CF5DB299DE0AADD712B8BE51C")

    String declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.654 -0400", hash_original_field = "DDAA6E8C8C412299272E183087B8F7B6", hash_generated_field = "1E5D18395D934B5D254686548A645BA9")

    String methodName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.654 -0400", hash_original_field = "5B063E275D506F65EBF1B02D926F19A4", hash_generated_field = "90A7C14E9FDE747EFC2F1C95E470FF1A")

    String fileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.654 -0400", hash_original_field = "BB8A5A0BF5B38F7D371E940DAED92DA6", hash_generated_field = "330B2760AA91CE77EFBAED3976D7655C")

    int lineNumber;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.655 -0400", hash_original_method = "DB2419D651C8F74CAA343D4DD61F23E8", hash_generated_method = "6CE50CA5846D41AC905B7F56258C6088")
    public  StackTraceElement(String cls, String method, String file, int line) {
        if(cls == null || method == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_52927188 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_52927188.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_52927188;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.462 -0400", hash_original_method = "DC3E276578F22895683C0979CF7614B3", hash_generated_method = "069C2D8BCA6C8CA3D907F0C7C60A9CFB")
	public  StackTraceElement() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.656 -0400", hash_original_method = "7AAA9568018A0DD8A42BBFC0DF2D8ABE", hash_generated_method = "A6473D71202811318CB628B9A65164DB")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(!(obj instanceof StackTraceElement))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2022660075 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_999048007 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_999048007;
        } //End block
        StackTraceElement castObj = (StackTraceElement) obj;
        if((methodName == null) || (castObj.methodName == null))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2069244833 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732063641 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732063641;
        } //End block
        if(!getMethodName().equals(castObj.getMethodName()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_371286005 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_747679227 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_747679227;
        } //End block
        if(!getClassName().equals(castObj.getClassName()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1801822193 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_290584366 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_290584366;
        } //End block
        String localFileName = getFileName();
        if(localFileName == null)        
        {
            if(castObj.getFileName() != null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_122560248 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517342965 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_517342965;
            } //End block
        } //End block
        else
        {
            if(!localFileName.equals(castObj.getFileName()))            
            {
                boolean var68934A3E9455FA72420237EB05902327_233224877 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1675945454 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1675945454;
            } //End block
        } //End block
        if(getLineNumber() != castObj.getLineNumber())        
        {
            boolean var68934A3E9455FA72420237EB05902327_881732502 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_997749449 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_997749449;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_808239511 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1250840952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1250840952;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.657 -0400", hash_original_method = "BE14A042BD1289020FF0D183A63A0F88", hash_generated_method = "4030DB8CF3C880D27165FF8D5C24CF35")
    public String getClassName() {
String var1810B92D6E9A135AC1D82D9EC8FB1528_635949527 =         (declaringClass == null) ? "<unknown class>" : declaringClass;
        var1810B92D6E9A135AC1D82D9EC8FB1528_635949527.addTaint(taint);
        return var1810B92D6E9A135AC1D82D9EC8FB1528_635949527;
        // ---------- Original Method ----------
        //return (declaringClass == null) ? "<unknown class>" : declaringClass;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.657 -0400", hash_original_method = "0038085273B4122A69DA20E0B00D2EF2", hash_generated_method = "F52E81CBDF04781088A565D33CF981A6")
    public String getFileName() {
String varBD5EACC393579FDF5D0E813DB68A2F73_839950401 =         fileName;
        varBD5EACC393579FDF5D0E813DB68A2F73_839950401.addTaint(taint);
        return varBD5EACC393579FDF5D0E813DB68A2F73_839950401;
        // ---------- Original Method ----------
        //return fileName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.657 -0400", hash_original_method = "0B737233CC5342C14C595BEE1A87604B", hash_generated_method = "3589761216C2E467DBD9832C8372BD6F")
    public int getLineNumber() {
        int varBB8A5A0BF5B38F7D371E940DAED92DA6_1553170692 = (lineNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_474392055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_474392055;
        // ---------- Original Method ----------
        //return lineNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.657 -0400", hash_original_method = "B15DF5174FD0E5C814CD72B1EE2ECDA2", hash_generated_method = "B49C5C42705AEAFD039F6B4D7CFD8C4F")
    public String getMethodName() {
String varBA91F8E11CBBE6FF21CD058EFF02A40B_748018140 =         (methodName == null) ? "<unknown method>" : methodName;
        varBA91F8E11CBBE6FF21CD058EFF02A40B_748018140.addTaint(taint);
        return varBA91F8E11CBBE6FF21CD058EFF02A40B_748018140;
        // ---------- Original Method ----------
        //return (methodName == null) ? "<unknown method>" : methodName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.658 -0400", hash_original_method = "4C3BE92C911A1E7C2FB757777265DE77", hash_generated_method = "AC116383C25B6D390FFB8F5E9C817F70")
    @Override
    public int hashCode() {
        if(methodName == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_980235362 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216543245 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216543245;
        } //End block
        int varEE9527A44843E1FDEBCBCA268E20F591_509343112 = (methodName.hashCode() ^ declaringClass.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557179405 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557179405;
        // ---------- Original Method ----------
        //if (methodName == null) {
            //return 0;
        //}
        //return methodName.hashCode() ^ declaringClass.hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.658 -0400", hash_original_method = "9234CE459C30A5F4896C026CB51E3A9C", hash_generated_method = "39CC3DEE2DA3A76C0C325BFB44ADCE8F")
    public boolean isNativeMethod() {
        boolean var1A1A01A6DD717EE94BA470392F83F738_267396410 = (lineNumber == NATIVE_LINE_NUMBER);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1036226005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1036226005;
        // ---------- Original Method ----------
        //return lineNumber == NATIVE_LINE_NUMBER;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.658 -0400", hash_original_method = "6555BB21F7D49ABF8ADE43CA311A7DFA", hash_generated_method = "ECD069EEE84ECF1D216CAC2B5FA626C6")
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
String var4FC680801218E6372BC708D6FA44AE60_1667768816 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1667768816.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1667768816;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.659 -0400", hash_original_field = "BBEDD4D329D4F012F7C03204207859AB", hash_generated_field = "26C66B155644317B8367FDF23AF4DB9B")

    private static final long serialVersionUID = 6992337162326171013L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.659 -0400", hash_original_field = "1A0742D9715371D1F34889E0BCB211DA", hash_generated_field = "044B734A1D0D1997F7880A1DDED8AFF6")

    private static final int NATIVE_LINE_NUMBER = -2;
}

