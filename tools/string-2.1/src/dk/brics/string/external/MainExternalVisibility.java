package dk.brics.string.external;

import soot.ArrayType;
import soot.RefType;
import soot.SootField;
import soot.SootMethod;

/**
 * Treats only main methods as externally visible, and no fields as externally visible.
 * Here, a main method is any public and static method named "main" whose only parameter
 * has type <tt>String[]</tt>.
 * <p/>
 * This is sound and quite precise for analyzing standalone applications that don't use
 * callbacks to external code.
 * 
 * @author Asger
 *
 */
public class MainExternalVisibility implements ExternalVisibility {
    public boolean isExternallyVisibleField(SootField field) {
        return false;
    }
    public boolean isExternallyVisibleMethod(SootMethod sm) {
        return sm.isPublic() && sm.isStatic() && sm.getName().equals("main")
        && sm.getParameterCount() == 1
        && sm.getParameterType(0).equals(ArrayType.v(RefType.v("java.lang.String"), 1));
    }
}
