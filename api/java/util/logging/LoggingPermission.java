package java.util.logging;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.security.BasicPermission;
import java.security.Guard;
import java.security.Permission;

public final class LoggingPermission extends BasicPermission implements Guard, Serializable {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.515 -0500", hash_original_method = "49660D4D996C1CD70562D31B56A71F27", hash_generated_method = "DB7C848776230AFA35889FBB6D95B293")
    
public LoggingPermission(String name, String actions) { super("", ""); }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.517 -0500", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "3D225D3CE47DA77C079F578AAAC6007E")
    
@Override public String getActions() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.519 -0500", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "7028504695C2B07EE227E4A73DB8D42F")
    
@Override public boolean implies(Permission permission) { return true; }
    
}

