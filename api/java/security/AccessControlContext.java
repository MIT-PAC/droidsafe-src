package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public final class AccessControlContext {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.896 -0500", hash_original_method = "45BDFEE92F46B3E06C43EB288E655269", hash_generated_method = "2473CDBBECF1831A91288A2772BD6A66")
    
public AccessControlContext(AccessControlContext acc, DomainCombiner combiner) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.898 -0500", hash_original_method = "D60AD149FA522283F5BA7717DB279F05", hash_generated_method = "60BBE0B3B65A0D9FC8CDB643ABC4E6B1")
    
public AccessControlContext(ProtectionDomain[] context) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.900 -0500", hash_original_method = "1B973012FE4490CD9CBF1AB1866FE20E", hash_generated_method = "8F3A795EE3803ABB949B2F5908D4EEBA")
    
public void checkPermission(Permission perm) throws AccessControlException { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.902 -0500", hash_original_method = "9A971105212191ED79C64AFC11FE52C6", hash_generated_method = "7E2816248A48E4F46D6769D56B1CA5BF")
    
public DomainCombiner getDomainCombiner() { return null; }

    
}

