package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;





public abstract class Permission implements Guard, Serializable {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.118 -0400", hash_original_method = "A3ABD4D844A912132701BDB49CC172D4", hash_generated_method = "60BBD61DE20E08273982FAC06D418A9B")
    public  Permission(String name) {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.119 -0400", hash_original_method = "BD1D69B57EF82CC836CADC372B210DA8", hash_generated_method = "90507AD0776D321014F7A088ADFABC98")
    public final String getName() {
String var540C13E9E156B687226421B24F2DF178_385870722 =         null;
        var540C13E9E156B687226421B24F2DF178_385870722.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_385870722;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.119 -0400", hash_original_method = "C84962AC42FE97CD37014EB04A226348", hash_generated_method = "7B46358E0B69DA0AB94C3564AB046E79")
    public void checkGuard(Object obj) throws SecurityException {
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.119 -0400", hash_original_method = "3B418AF4D3F113F25455A16498EE96FC", hash_generated_method = "FF657E708793A8A1A818EC61CA56C9A9")
    public PermissionCollection newPermissionCollection() {
PermissionCollection varE4C8908E3F49EE48D2B78391A77CE8EC_982862765 =         new AllPermissionCollection();
        varE4C8908E3F49EE48D2B78391A77CE8EC_982862765.addTaint(taint);
        return varE4C8908E3F49EE48D2B78391A77CE8EC_982862765;
        // ---------- Original Method ----------
        //return new AllPermissionCollection();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract String getActions();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean implies(Permission permission);

    
}

