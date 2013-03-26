package dk.brics.string.external;

import soot.SootClass;

/**
 * Determines which types might be extended/implemented by a non-application class.
 * 
 * @author Asger
 */
public interface ExternalSubtyping {
    /**
     * Returns true if the specified type might be extended/implemented by a
     * non-application class. More precisely, this should return <tt>true</tt> 
     * if an instance of such an external subtype can ever reach application code.
     * <p/>
     * It is always sound to return <tt>true</tt>.
     * 
     * @param clazz a class or interface. May be application or non-application.
     * @return <tt>true</tt> if an instance of a non-application subtype may reach application code
     */
    boolean hasExternalSubtype(SootClass clazz);
}
