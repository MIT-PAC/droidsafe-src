package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class AndroidException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.564 -0400", hash_original_method = "B114E564F5DD3A8162C6B705516D48E4", hash_generated_method = "3F3036938BBFFBEE9FC70E6BFE68E808")
    @DSModeled(DSC.SAFE)
    public AndroidException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.564 -0400", hash_original_method = "891590FF533F04EE265F2E23F15D3AEC", hash_generated_method = "D838C434E27D2A806CDA6DAD22CE2167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidException(String name) {
        super(name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.564 -0400", hash_original_method = "B244007C3BAFD44F95BE0B614ABC1B32", hash_generated_method = "A00CCDFF58FCFD1DDDC447460E45EC65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidException(String name, Throwable cause) {
        super(name, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.565 -0400", hash_original_method = "C5375F3D80EA6460B68F9344F734F18D", hash_generated_method = "D48977F522B99F251E7CEC68D4959EAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidException(Exception cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


