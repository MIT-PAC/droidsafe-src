package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MissingFormatWidthException extends IllegalFormatException {
    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.911 -0400", hash_original_method = "3B5695383AF45988D55F3947C3C6E408", hash_generated_method = "8A5B9F6ABA2D976424BA908D182C8F7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MissingFormatWidthException(String s) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.911 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "54F37CFC770F507F3E245BB68605CF90")
    @DSModeled(DSC.SAFE)
    public String getFormatSpecifier() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.911 -0400", hash_original_method = "0A4C8E3EAB801D8800E3A2D920D74C80", hash_generated_method = "A4B95BE44C0A0175B74FB35B7F6D2121")
    @DSModeled(DSC.SAFE)
    @Override
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return s;
    }

    
    private static final long serialVersionUID = 15560123L;
}

