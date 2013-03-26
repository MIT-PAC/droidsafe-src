package dk.brics.string.external;

import soot.SootField;
import soot.SootMethod;

/**
 * Defines which methods are seen by the string analysis as being
 * accessible from unknown code.
 */
public interface ExternalVisibility {

    /**
     * Defines which methods are seen by the string analysis as being
     * accessible from unknown code.
     * The arguments to these methods can contain any values,
     * and the return values might escape to unknown code.<p>
     *
     * @param sm a method in the analyzed code.
     * @return whether the method could possibly be called from unknown code.
     */
    boolean isExternallyVisibleMethod(SootMethod sm);
    
    /**
     * Defines which fields are seen by the string analysis as being
     * acecssible from unknown code. Note that this is also called for private
     * fields, so a reasonable implementation should return <tt>false</tt> for such fields.
     * <p/>
     * An externally visible field is considered to be corrupt, meaning it can spontaneously
     * change value.
     * @param field a field in the application being analyzed
     * @return <tt>true</tt> if the field is externally visible.
     */
    boolean isExternallyVisibleField(SootField field);
}
