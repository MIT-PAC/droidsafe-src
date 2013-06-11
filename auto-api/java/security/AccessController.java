package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class AccessController {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.591 -0400", hash_original_method = "933F644DAAB02DBBD976309C952EDFF1", hash_generated_method = "032DE1E6042BAF18C336E8E681A68C55")
    @DSModeled(DSC.SAFE)
    private AccessController() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.591 -0400", hash_original_method = "5B0B3D99F947E3927281A328E814E859", hash_generated_method = "44A87FA05FB39A7CAE583E1FB5523BA0")
    public static <T> T doPrivileged(PrivilegedAction<T> action) {
        return action.run();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.591 -0400", hash_original_method = "7F9FD73A82D428E60582CCE3540B5BC6", hash_generated_method = "50BA9A106E2C5F2442D236A764F85716")
    public static <T> T doPrivileged(PrivilegedAction<T> action, AccessControlContext context) {
        return action.run();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.591 -0400", hash_original_method = "003510C08A13C865AE8FDD1CD0E525C0", hash_generated_method = "22896FA780673CA018F5A9150E44E7E8")
    public static <T> T doPrivileged(PrivilegedExceptionAction<T> action) throws PrivilegedActionException {
        try {
            return action.run();
        } catch (RuntimeException e) {
            throw e; 
        } catch (Exception e) {
            throw new PrivilegedActionException(e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.591 -0400", hash_original_method = "31DABEB23F087CF9D565AEB874104652", hash_generated_method = "3C1097CBF1C1235CE88442C627D0D2CB")
    public static <T> T doPrivileged(PrivilegedExceptionAction<T> action, AccessControlContext context) throws PrivilegedActionException {
        return doPrivileged(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.591 -0400", hash_original_method = "78292A7FDEA631C95B35CFDDAD0FDA03", hash_generated_method = "294160BD504AD0997D0C5004B42AA81E")
    public static <T> T doPrivilegedWithCombiner(PrivilegedAction<T> action) {
        return action.run();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.591 -0400", hash_original_method = "289472EA752FAED9D39B9FF11F456243", hash_generated_method = "542FE58DD2000C6DD15DB758506783AB")
    public static <T> T doPrivilegedWithCombiner(PrivilegedExceptionAction<T> action) throws PrivilegedActionException {
        return doPrivileged(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.591 -0400", hash_original_method = "C13A29D7398EFEE7F24C7392CF2DCBF6", hash_generated_method = "974784B64986A9DBF19FEF16A5A51BCF")
    public static void checkPermission(Permission permission) throws AccessControlException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.591 -0400", hash_original_method = "08126716CBB79243816C8A8ABDB96EAD", hash_generated_method = "91BA942030296B2E25EACC4F1BE7B881")
    public static AccessControlContext getContext() {
        return new AccessControlContext(null);
    }

    
}


