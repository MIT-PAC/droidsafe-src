package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Token {
    protected String tokenValue;
    protected int tokenType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.789 -0400", hash_original_method = "2EDF79276E055B5B1D095482BCA1C1E6", hash_generated_method = "2EDF79276E055B5B1D095482BCA1C1E6")
        public Token ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.789 -0400", hash_original_method = "F8E0993DCB6F03EA51553585BFE853D1", hash_generated_method = "9DFF54F1F0C606D45661F55E448617F0")
    @DSModeled(DSC.SAFE)
    public String getTokenValue() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.tokenValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.790 -0400", hash_original_method = "2E47E29049C2BF1025243EAE8896F2F1", hash_generated_method = "58A0BEA927C71A87BDABEE5EB6A54419")
    @DSModeled(DSC.SAFE)
    public int getTokenType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.tokenType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.790 -0400", hash_original_method = "C6D43B0C1DADE24AF5766A64C57BCE8F", hash_generated_method = "AC73BD436B374952BF44641A36AAC7FE")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "tokenValue = " + tokenValue + "/tokenType = " + tokenType;
    }

    
}

