package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class InstantiationException extends Exception {
    private static final long serialVersionUID = -8441929162975509110L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.263 -0400", hash_original_method = "4FE52ED96718E49A2C12E29EB6D41BB1", hash_generated_method = "746BA664AC9577E04120B7214F017340")
    @DSModeled(DSC.SAFE)
    public InstantiationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.265 -0400", hash_original_method = "5F54417A31BE783961475C78B79DF3BE", hash_generated_method = "2D6073754A92758B9C13C595113631A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InstantiationException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.267 -0400", hash_original_method = "6F408C13CB22C61379FA2022EB73B671", hash_generated_method = "941E46CE2E3991D9204EEC9754E1F5ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InstantiationException(Class<?> clazz) {
        super(clazz.getName());
        dsTaint.addTaint(clazz.dsTaint);
        // ---------- Original Method ----------
    }

    
}


