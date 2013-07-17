package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class AccessControlContext {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.716 -0400", hash_original_method = "45BDFEE92F46B3E06C43EB288E655269", hash_generated_method = "90BBD92CB92B0D323F72BA262FBC1539")
    public  AccessControlContext(AccessControlContext acc, DomainCombiner combiner) {
        addTaint(combiner.getTaint());
        addTaint(acc.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.717 -0400", hash_original_method = "D60AD149FA522283F5BA7717DB279F05", hash_generated_method = "890E271A7511CBC1E613EA7FD556AE57")
    public  AccessControlContext(ProtectionDomain[] context) {
        addTaint(context[0].getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.717 -0400", hash_original_method = "1B973012FE4490CD9CBF1AB1866FE20E", hash_generated_method = "42159632D3F362DE6FD7BE145EAB9C02")
    public void checkPermission(Permission perm) throws AccessControlException {
        addTaint(perm.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.717 -0400", hash_original_method = "9A971105212191ED79C64AFC11FE52C6", hash_generated_method = "36C8A21F024436D92E25B34C5B5A9AB8")
    public DomainCombiner getDomainCombiner() {
DomainCombiner var540C13E9E156B687226421B24F2DF178_642155401 =         null;
        var540C13E9E156B687226421B24F2DF178_642155401.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_642155401;
        // ---------- Original Method ----------
        //return null;
    }

    
}

