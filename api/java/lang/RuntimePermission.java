package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.BasicPermission;
import java.security.Permission;

public final class RuntimePermission extends BasicPermission {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.613 -0500", hash_original_method = "4B2115E5C37ED723471172D5C8F80B46", hash_generated_method = "937A5F4A6EA007C3F01928EF03BB96F5")
    
public RuntimePermission(String permissionName) { super(""); }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.617 -0500", hash_original_method = "E2D7FAA6FF83E30EF411D458EDB8F08D", hash_generated_method = "A851015B203C1C0873C37FF27DADD108")
    
public RuntimePermission(String name, String actions) { super("", ""); }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.619 -0500", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "3D225D3CE47DA77C079F578AAAC6007E")
    
@Override public String getActions() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.622 -0500", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "7028504695C2B07EE227E4A73DB8D42F")
    
@Override public boolean implies(Permission permission) { return true; }
    
}

