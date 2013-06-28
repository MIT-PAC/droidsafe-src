package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class AccessControlContext {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.048 -0400", hash_original_method = "45BDFEE92F46B3E06C43EB288E655269", hash_generated_method = "F3A7194D2ECF5EF2D12F60AE8081C9E1")
    public  AccessControlContext(AccessControlContext acc, DomainCombiner combiner) {
        addTaint(acc.getTaint());
        addTaint(combiner.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.049 -0400", hash_original_method = "D60AD149FA522283F5BA7717DB279F05", hash_generated_method = "890E271A7511CBC1E613EA7FD556AE57")
    public  AccessControlContext(ProtectionDomain[] context) {
        addTaint(context[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.049 -0400", hash_original_method = "1B973012FE4490CD9CBF1AB1866FE20E", hash_generated_method = "42159632D3F362DE6FD7BE145EAB9C02")
    public void checkPermission(Permission perm) throws AccessControlException {
        addTaint(perm.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.049 -0400", hash_original_method = "9A971105212191ED79C64AFC11FE52C6", hash_generated_method = "3F19E04E13EB3BA43487FA625E1EFBD9")
    public DomainCombiner getDomainCombiner() {
        DomainCombiner varB4EAC82CA7396A68D541C85D26508E83_985615916 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_985615916 = null;
        varB4EAC82CA7396A68D541C85D26508E83_985615916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_985615916;
        // ---------- Original Method ----------
        //return null;
    }

    
}

