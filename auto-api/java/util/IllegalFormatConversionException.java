package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class IllegalFormatConversionException extends IllegalFormatException implements Serializable {
    private char c;
    private Class<?> arg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.488 -0400", hash_original_method = "0438EEFB69B3388326CD0DDEA30A5038", hash_generated_method = "A6F1573165B50B7DD60C69FADEC70509")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalFormatConversionException(char c, Class<?> arg) {
        dsTaint.addTaint(arg.dsTaint);
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //this.c = c;
        //if (arg == null) {
            //throw new NullPointerException();
        //}
        //this.arg = arg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.488 -0400", hash_original_method = "F6AB4FB57CDBF80A2EA14BA003E8B6E3", hash_generated_method = "CC4B198A8997059CA21E25A225EC9430")
    @DSModeled(DSC.SAFE)
    public Class<?> getArgumentClass() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return arg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.488 -0400", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "45F528E7AF00ECA5115BFCF989195A39")
    @DSModeled(DSC.SAFE)
    public char getConversion() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.488 -0400", hash_original_method = "F4CE0F8EC3805161966118C119A25B11", hash_generated_method = "FE48F2732DB1FD372C3663485F618B0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMessage() {
        String var8CA0EA5E1D9254A27FF4FC145E9754AA_2032067705 = ("%" + c + " can't format " + arg.getName() + " arguments");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "%" + c + " can't format " + arg.getName() + " arguments";
    }

    
    private static final long serialVersionUID = 17000126L;
}

