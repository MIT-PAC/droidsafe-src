package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnknownFormatConversionException extends IllegalFormatException {
    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.143 -0400", hash_original_method = "0FB4C71CADE23BA4642C2B1DAECF427B", hash_generated_method = "0A598A6662CBB957F7B2615A66F124E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnknownFormatConversionException(String s) {
        dsTaint.addTaint(s);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new NullPointerException();
        //}
        //this.s = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.144 -0400", hash_original_method = "F42E87FF5499AB643BB7E67C5DADAA6D", hash_generated_method = "C4BD05C73956DC86FEDBEBAED26F918E")
    @DSModeled(DSC.SAFE)
    public String getConversion() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.144 -0400", hash_original_method = "E0B7E8AB02E28C66CE17D4B71D9F5BCF", hash_generated_method = "3A26F1E20A33C71E15A756690E0AD7E7")
    @DSModeled(DSC.SAFE)
    @Override
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Conversion: " + s;
    }

    
    private static final long serialVersionUID = 19060418L;
}

