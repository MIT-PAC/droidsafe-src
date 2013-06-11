package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class IllegalCharsetNameException extends IllegalArgumentException {
    private static final long serialVersionUID = 1457525358470002989L;
    private String charsetName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.561 -0400", hash_original_method = "363E701FA2AE5454AC2A0E287832EEC6", hash_generated_method = "B8BD6E47D360EEF6FD6FC14A9D42D249")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalCharsetNameException(String charsetName) {
        super((charsetName != null) ? charsetName : "null");
        dsTaint.addTaint(charsetName);
        // ---------- Original Method ----------
        //this.charsetName = charsetName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.561 -0400", hash_original_method = "62D3F36CA78A6EC4185A2D1A05C169E6", hash_generated_method = "FA76CC2E17994353A2668F77510A4CB9")
    @DSModeled(DSC.SAFE)
    public String getCharsetName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return charsetName;
    }

    
}


