package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import sun.misc.Unsafe;

final class UnsafeAccess {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.656 -0500", hash_original_field = "384614B22A2950A8251BF7CF99FCA6CC", hash_generated_field = "43F7273FA81332C6953EE82E08DFE9B4")

    /*package*/ static final Unsafe THE_ONE = Unsafe.getUnsafe();

    /**
     * This class is uninstantiable.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.658 -0500", hash_original_method = "0EFE42460BC7E37E4F419C0570A5DDF5", hash_generated_method = "C853337CD32C4B29B5CE9F3D93BA12E8")
    
private UnsafeAccess() {
        // This space intentionally left blank.
    }
}

