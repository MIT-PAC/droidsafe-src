package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MissingFormatArgumentException extends IllegalFormatException {
    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.910 -0400", hash_original_method = "3488C8E98AE00375533889C559694B58", hash_generated_method = "BEE30FFD7B9A182F7B88BACB81739636")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MissingFormatArgumentException(String s) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.910 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "54F37CFC770F507F3E245BB68605CF90")
    @DSModeled(DSC.SAFE)
    public String getFormatSpecifier() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.910 -0400", hash_original_method = "D7277B29886D06334EB30606D08F78F5", hash_generated_method = "917D6FE8DCAC49C31E806D88B1EA0EC6")
    @DSModeled(DSC.SAFE)
    @Override
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Format specifier: " + s;
    }

    
    private static final long serialVersionUID = 19190115L;
}

