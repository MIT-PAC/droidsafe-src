package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class AccessControlContext {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.287 -0400", hash_original_method = "45BDFEE92F46B3E06C43EB288E655269", hash_generated_method = "8354176120AA5AD2BF8A53DB4652B85C")
    @DSModeled(DSC.SAFE)
    public AccessControlContext(AccessControlContext acc, DomainCombiner combiner) {
        dsTaint.addTaint(combiner.dsTaint);
        dsTaint.addTaint(acc.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.288 -0400", hash_original_method = "D60AD149FA522283F5BA7717DB279F05", hash_generated_method = "8661E82F173F297F50D5C55239B28530")
    @DSModeled(DSC.SAFE)
    public AccessControlContext(ProtectionDomain[] context) {
        dsTaint.addTaint(context[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.289 -0400", hash_original_method = "1B973012FE4490CD9CBF1AB1866FE20E", hash_generated_method = "ECA3CF2F9825979032CF28AF17B6B1FE")
    @DSModeled(DSC.SAFE)
    public void checkPermission(Permission perm) throws AccessControlException {
        dsTaint.addTaint(perm.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.289 -0400", hash_original_method = "9A971105212191ED79C64AFC11FE52C6", hash_generated_method = "978A70E4A428411C339763E5443ED0B9")
    @DSModeled(DSC.SAFE)
    public DomainCombiner getDomainCombiner() {
        return (DomainCombiner)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
}

