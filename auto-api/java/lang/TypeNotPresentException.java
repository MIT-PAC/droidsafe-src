package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class TypeNotPresentException extends RuntimeException {
    private static final long serialVersionUID = -5101214195716534496L;
    private String typeName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.608 -0400", hash_original_method = "8F99105588FC99ADE0A826CA1D876689", hash_generated_method = "8437C0CC889D8FA18F1DF382A3FCA948")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypeNotPresentException(String typeName, Throwable cause) {
        super("Type " + typeName + " not present", cause);
        dsTaint.addTaint(typeName);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
        //this.typeName = typeName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.610 -0400", hash_original_method = "4654D488024911B4CA912D2186B5898B", hash_generated_method = "3E6A847367F4EDB5910048ACE2EC86AA")
    @DSModeled(DSC.SAFE)
    public String typeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return typeName;
    }

    
}


