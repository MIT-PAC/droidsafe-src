package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnsupportedCharsetException extends IllegalArgumentException {
    private String charsetName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.282 -0400", hash_original_method = "EF2B407E9854D147BA5248D252ABFDC1", hash_generated_method = "1813068043828D1B9898BE582B2F2068")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedCharsetException(String charsetName) {
        super((charsetName != null) ? charsetName : "null");
        dsTaint.addTaint(charsetName);
        // ---------- Original Method ----------
        //this.charsetName = charsetName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.282 -0400", hash_original_method = "62D3F36CA78A6EC4185A2D1A05C169E6", hash_generated_method = "D3152A749E5146FD48B18AFFB6F43D9A")
    @DSModeled(DSC.SAFE)
    public String getCharsetName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return charsetName;
    }

    
    private static final long serialVersionUID = 1490765524727386367L;
}

