package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public class IllegalFormatConversionException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.627 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private char c;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.627 -0400", hash_original_field = "61DD86C2DC75C3F569EC619BD283A33F", hash_generated_field = "2ECA6A70BD4E757E3F8651900978568C")

    private Class<?> arg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.627 -0400", hash_original_method = "0438EEFB69B3388326CD0DDEA30A5038", hash_generated_method = "B5FFC411F43C88775AA69E895F90DB54")
    public  IllegalFormatConversionException(char c, Class<?> arg) {
        this.c = c;
    if(arg == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1433778863 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1433778863.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1433778863;
        } //End block
        this.arg = arg;
        // ---------- Original Method ----------
        //this.c = c;
        //if (arg == null) {
            //throw new NullPointerException();
        //}
        //this.arg = arg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.628 -0400", hash_original_method = "F6AB4FB57CDBF80A2EA14BA003E8B6E3", hash_generated_method = "29111A74CE949CD12CAB11C839784B90")
    public Class<?> getArgumentClass() {
Class<?> varFFCBE2769CA7417D59916888195AB140_1323871207 =         arg;
        varFFCBE2769CA7417D59916888195AB140_1323871207.addTaint(taint);
        return varFFCBE2769CA7417D59916888195AB140_1323871207;
        // ---------- Original Method ----------
        //return arg;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.628 -0400", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "FB1060CAC2D489500BEBE7145005A8F3")
    public char getConversion() {
        char var4A8A08F09D37B73795649038408B5F33_19992435 = (c);
                char varA87DEB01C5F539E6BDA34829C8EF2368_444888002 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_444888002;
        // ---------- Original Method ----------
        //return c;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.628 -0400", hash_original_method = "F4CE0F8EC3805161966118C119A25B11", hash_generated_method = "DD3DB78C1820E68853B9C1849F969D99")
    @Override
    public String getMessage() {
String var520040D7049D9D91CB8FD3B8A2D4196F_439119129 =         "%" + c + " can't format " + arg.getName() + " arguments";
        var520040D7049D9D91CB8FD3B8A2D4196F_439119129.addTaint(taint);
        return var520040D7049D9D91CB8FD3B8A2D4196F_439119129;
        // ---------- Original Method ----------
        //return "%" + c + " can't format " + arg.getName() + " arguments";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.628 -0400", hash_original_field = "A43B8792404A26F7B6E333F9BBF1E2D8", hash_generated_field = "25B9B9FD75AC3506217DC397F5D20733")

    private static final long serialVersionUID = 17000126L;
}

