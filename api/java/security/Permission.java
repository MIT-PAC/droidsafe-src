package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public abstract class Permission implements Guard, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.136 -0400", hash_original_method = "A3ABD4D844A912132701BDB49CC172D4", hash_generated_method = "60BBD61DE20E08273982FAC06D418A9B")
    public  Permission(String name) {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.137 -0400", hash_original_method = "BD1D69B57EF82CC836CADC372B210DA8", hash_generated_method = "BB6C2FE5FD21267AE1E94C9E6569FB90")
    public final String getName() {
String var540C13E9E156B687226421B24F2DF178_1049872263 =         null;
        var540C13E9E156B687226421B24F2DF178_1049872263.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1049872263;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.137 -0400", hash_original_method = "C84962AC42FE97CD37014EB04A226348", hash_generated_method = "7B46358E0B69DA0AB94C3564AB046E79")
    public void checkGuard(Object obj) throws SecurityException {
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.137 -0400", hash_original_method = "3B418AF4D3F113F25455A16498EE96FC", hash_generated_method = "48416AE1032F2CBC5A08BE5C205F2F7C")
    public PermissionCollection newPermissionCollection() {
PermissionCollection varE4C8908E3F49EE48D2B78391A77CE8EC_597181795 =         new AllPermissionCollection();
        varE4C8908E3F49EE48D2B78391A77CE8EC_597181795.addTaint(taint);
        return varE4C8908E3F49EE48D2B78391A77CE8EC_597181795;
        // ---------- Original Method ----------
        //return new AllPermissionCollection();
    }

    
    public abstract String getActions();

    
    public abstract boolean implies(Permission permission);

    
}

