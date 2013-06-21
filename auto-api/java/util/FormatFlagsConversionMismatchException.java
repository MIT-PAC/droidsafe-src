package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class FormatFlagsConversionMismatchException extends IllegalFormatException implements Serializable {
    private String f;
    private char c;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.000 -0400", hash_original_method = "23601B02BC801B28ADE07C396E4C34FF", hash_generated_method = "53554A6037715F346048E30AD4DE200B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FormatFlagsConversionMismatchException(String f, char c) {
        dsTaint.addTaint(f);
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (f == null) {
            //throw new NullPointerException();
        //}
        //this.f = f;
        //this.c = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.000 -0400", hash_original_method = "3582970EABB5B296536802E98213C512", hash_generated_method = "D15F58CCEA0707B868B638F49708C8B0")
    @DSModeled(DSC.SAFE)
    public String getFlags() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.000 -0400", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "45F528E7AF00ECA5115BFCF989195A39")
    @DSModeled(DSC.SAFE)
    public char getConversion() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.000 -0400", hash_original_method = "767287C022ACF72AAFFBED8242F4CC5C", hash_generated_method = "BFDB14344BCCD53C0CECC098991F6C0B")
    @DSModeled(DSC.SAFE)
    @Override
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "%" + c + " does not support '" + f + "'";
    }

    
    private static final long serialVersionUID = 19120414L;
}

