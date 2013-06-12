package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class UnsupportedCharsetException extends IllegalArgumentException {
    private static final long serialVersionUID = 1490765524727386367L;
    private String charsetName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.568 -0400", hash_original_method = "EF2B407E9854D147BA5248D252ABFDC1", hash_generated_method = "FE39C5B1D44A596F422A0BF7D5F0BE0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedCharsetException(String charsetName) {
        super((charsetName != null) ? charsetName : "null");
        dsTaint.addTaint(charsetName);
        // ---------- Original Method ----------
        //this.charsetName = charsetName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.568 -0400", hash_original_method = "62D3F36CA78A6EC4185A2D1A05C169E6", hash_generated_method = "FA76CC2E17994353A2668F77510A4CB9")
    @DSModeled(DSC.SAFE)
    public String getCharsetName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return charsetName;
    }

    
}


