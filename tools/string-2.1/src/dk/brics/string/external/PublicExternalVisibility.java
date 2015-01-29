package dk.brics.string.external;

import soot.SootField;
import soot.SootMethod;

/**
 * Treats public fields and methods as externally visible, and non-public fields
 * and methods as not externally visible.
 * <p/>
 * Under rare circumstances, a non-application class may access a protected or package-private
 * field or method, in which case this strategy is not sound.
 * 
 * @author Asger
 *
 */
public class PublicExternalVisibility implements ExternalVisibility {
    public boolean isExternallyVisibleField(SootField field) {
        return field.isPublic();
    }
    public boolean isExternallyVisibleMethod(SootMethod sm) {
        return sm.isPublic();
    }
}
