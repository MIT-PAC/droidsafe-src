package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class Permission implements Guard, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.400 -0400", hash_original_method = "A3ABD4D844A912132701BDB49CC172D4", hash_generated_method = "7572FAD9F417E23F177C6EE478AC4312")
    @DSModeled(DSC.SAFE)
    public Permission(String name) {
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.400 -0400", hash_original_method = "BD1D69B57EF82CC836CADC372B210DA8", hash_generated_method = "86A98FA2495A1FE6D33CA00AE2935AA5")
    @DSModeled(DSC.SAFE)
    public final String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.400 -0400", hash_original_method = "C84962AC42FE97CD37014EB04A226348", hash_generated_method = "8EE53E52ED462DA9EF6E68F482949E50")
    @DSModeled(DSC.SAFE)
    public void checkGuard(Object obj) throws SecurityException {
        dsTaint.addTaint(obj.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.400 -0400", hash_original_method = "3B418AF4D3F113F25455A16498EE96FC", hash_generated_method = "166B602A6210F9717706C927A557BCB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PermissionCollection newPermissionCollection() {
        PermissionCollection var7D15FAC7674E3953D2AF7B04A646C53D_2123870715 = (new AllPermissionCollection());
        return (PermissionCollection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AllPermissionCollection();
    }

    
    public abstract String getActions();

    
    public abstract boolean implies(Permission permission);

    
}

