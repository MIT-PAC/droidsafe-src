package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class AccessControlContext {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.589 -0400", hash_original_method = "45BDFEE92F46B3E06C43EB288E655269", hash_generated_method = "A3D7729B1D87CBCBC87AC497C547BC7E")
    @DSModeled(DSC.SAFE)
    public AccessControlContext(AccessControlContext acc, DomainCombiner combiner) {
        dsTaint.addTaint(combiner.dsTaint);
        dsTaint.addTaint(acc.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.589 -0400", hash_original_method = "D60AD149FA522283F5BA7717DB279F05", hash_generated_method = "F429BDB639AAACD5524B7C7E31541B4E")
    @DSModeled(DSC.SAFE)
    public AccessControlContext(ProtectionDomain[] context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.589 -0400", hash_original_method = "1B973012FE4490CD9CBF1AB1866FE20E", hash_generated_method = "681C8C2DCD3735367BC8BBBA8D1A251E")
    @DSModeled(DSC.SAFE)
    public void checkPermission(Permission perm) throws AccessControlException {
        dsTaint.addTaint(perm.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.589 -0400", hash_original_method = "9A971105212191ED79C64AFC11FE52C6", hash_generated_method = "6E63C9E775F302654DC19366486486DF")
    @DSModeled(DSC.SAFE)
    public DomainCombiner getDomainCombiner() {
        return (DomainCombiner)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
}


