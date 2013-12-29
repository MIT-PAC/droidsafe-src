package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.BasicPermission;
import java.security.Permission;





public final class NetPermission extends BasicPermission {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.951 -0500", hash_original_method = "AF713E88B3605596EC00E48857DBF46B", hash_generated_method = "8A38DEDEB0B3F11C771B93C018CA43BF")
    public NetPermission(String name) { super(""); }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.951 -0500", hash_original_method = "342AA26435633C300D2029E398212CA8", hash_generated_method = "BF5FADA05C49A7EE96AFC26495A2268B")
    public NetPermission(String name, String actions) { super("", ""); }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.952 -0500", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "3D225D3CE47DA77C079F578AAAC6007E")
    @Override
public String getActions() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.953 -0500", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "7028504695C2B07EE227E4A73DB8D42F")
    @Override
public boolean implies(Permission permission) { return true; }

    
}

