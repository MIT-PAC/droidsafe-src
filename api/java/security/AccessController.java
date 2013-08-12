package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;




public final class AccessController {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.746 -0400", hash_original_method = "933F644DAAB02DBBD976309C952EDFF1", hash_generated_method = "413E2414F33FF227172B34BB7BB4830A")
    private  AccessController() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static void checkPermission(Permission permission) throws AccessControlException {
    }

    
    @DSModeled(DSC.SAFE)
    public static AccessControlContext getContext() {
        return new AccessControlContext(null);
    }

    
}

