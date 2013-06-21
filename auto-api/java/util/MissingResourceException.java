package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MissingResourceException extends RuntimeException {
    String className, key;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.912 -0400", hash_original_method = "0B71E2B2311543F4039A5E1A5B0E2A4E", hash_generated_method = "64705D0D20DE1F3D987D4D3AE1BD5240")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MissingResourceException(String detailMessage, String className,
            String resourceName) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        dsTaint.addTaint(className);
        dsTaint.addTaint(resourceName);
        // ---------- Original Method ----------
        //this.className = className;
        //key = resourceName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.913 -0400", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "FD0BF2C0E71CAD43679936E5C43FD82B")
    @DSModeled(DSC.SAFE)
    public String getClassName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.913 -0400", hash_original_method = "C39C8C9D5BC81C2FE68967748762171F", hash_generated_method = "5681BD529858D11322372A21207B4A9E")
    @DSModeled(DSC.SAFE)
    public String getKey() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return key;
    }

    
    private static final long serialVersionUID = -4876345176062000401L;
}

