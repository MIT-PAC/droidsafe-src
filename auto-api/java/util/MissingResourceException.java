package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class MissingResourceException extends RuntimeException {
    private static final long serialVersionUID = -4876345176062000401L;
    String className, key;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.783 -0400", hash_original_method = "0B71E2B2311543F4039A5E1A5B0E2A4E", hash_generated_method = "CC079D50EB18239CFC0E473891A25C17")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.783 -0400", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "853013EA16C97FB2A8F308431B7875F0")
    @DSModeled(DSC.SAFE)
    public String getClassName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.783 -0400", hash_original_method = "C39C8C9D5BC81C2FE68967748762171F", hash_generated_method = "145A88E41404A1EBB74F5CF61F8C5638")
    @DSModeled(DSC.SAFE)
    public String getKey() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return key;
    }

    
}


