package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class AccessController {
    
    public static <T> T doPrivileged(PrivilegedAction<T> action) {
        return action.run();
    }
    
    public static <T> T doPrivileged(PrivilegedAction<T> action, AccessControlContext context) {
        return action.run();
    }
    
    public static <T> T doPrivileged(PrivilegedExceptionAction<T> action) throws PrivilegedActionException {
        try {
            return action.run();
        } catch (RuntimeException e) {
            throw e; 
        } catch (Exception e) {
            throw new PrivilegedActionException(e);
        }
    }
    
    public static <T> T doPrivileged(PrivilegedExceptionAction<T> action, AccessControlContext context) throws PrivilegedActionException {
        return doPrivileged(action);
    }
    
    public static <T> T doPrivilegedWithCombiner(PrivilegedAction<T> action) {
        return action.run();
    }
    
    public static <T> T doPrivilegedWithCombiner(PrivilegedExceptionAction<T> action) throws PrivilegedActionException {
        return doPrivileged(action);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.632 -0500", hash_original_method = "C13A29D7398EFEE7F24C7392CF2DCBF6", hash_generated_method = "974784B64986A9DBF19FEF16A5A51BCF")
    
public static void checkPermission(Permission permission) throws AccessControlException { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.636 -0500", hash_original_method = "08126716CBB79243816C8A8ABDB96EAD", hash_generated_method = "91BA942030296B2E25EACC4F1BE7B881")
    
public static AccessControlContext getContext() { return new AccessControlContext(null); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.617 -0500", hash_original_method = "933F644DAAB02DBBD976309C952EDFF1", hash_generated_method = "3A3592FC6CB53D901FE90FAD76D10DED")
    
private AccessController() { }
    
}

