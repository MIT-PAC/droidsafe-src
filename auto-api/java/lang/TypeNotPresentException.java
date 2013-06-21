package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TypeNotPresentException extends RuntimeException {
    private String typeName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.628 -0400", hash_original_method = "8F99105588FC99ADE0A826CA1D876689", hash_generated_method = "48202C198ADA4D9332EC4E83A0B45BB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypeNotPresentException(String typeName, Throwable cause) {
        super("Type " + typeName + " not present", cause);
        dsTaint.addTaint(typeName);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
        //this.typeName = typeName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.629 -0400", hash_original_method = "4654D488024911B4CA912D2186B5898B", hash_generated_method = "D3C14BAA618C7EDA61A2401DD570D71D")
    @DSModeled(DSC.SAFE)
    public String typeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return typeName;
    }

    
    private static final long serialVersionUID = -5101214195716534496L;
}

