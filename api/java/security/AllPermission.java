package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public final class AllPermission extends Permission {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.090 -0500", hash_original_method = "09A3FF901F6A2CF2EED3134C2EAC6A79", hash_generated_method = "E266338027E7A15DC5AB5F62BF11AECB")
    public AllPermission(String name, String actions) { super(""); }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.091 -0500", hash_original_method = "8D01BAC0F6DD766A4223D24BBCA0691E", hash_generated_method = "A4DE2B1B831335E9A20B2B49A39FD848")
    public AllPermission() { super(""); }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.092 -0500", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "3D225D3CE47DA77C079F578AAAC6007E")
    @Override
public String getActions() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.093 -0500", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "7028504695C2B07EE227E4A73DB8D42F")
    @Override
public boolean implies(Permission permission) { return true; }

    
}

