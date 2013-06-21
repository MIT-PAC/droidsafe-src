package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalCharsetNameException extends IllegalArgumentException {
    private String charsetName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.259 -0400", hash_original_method = "363E701FA2AE5454AC2A0E287832EEC6", hash_generated_method = "46A045E777BC3508DFC2A8F2DC1CE87A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalCharsetNameException(String charsetName) {
        super((charsetName != null) ? charsetName : "null");
        dsTaint.addTaint(charsetName);
        // ---------- Original Method ----------
        //this.charsetName = charsetName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.259 -0400", hash_original_method = "62D3F36CA78A6EC4185A2D1A05C169E6", hash_generated_method = "D3152A749E5146FD48B18AFFB6F43D9A")
    @DSModeled(DSC.SAFE)
    public String getCharsetName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return charsetName;
    }

    
    private static final long serialVersionUID = 1457525358470002989L;
}

