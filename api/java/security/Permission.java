package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public abstract class Permission implements Guard, Serializable {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.121 -0500", hash_original_method = "A3ABD4D844A912132701BDB49CC172D4", hash_generated_method = "FEB85F07824311712D827DF553B65F8F")
    
public Permission(String name) { }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.123 -0500", hash_original_method = "BD1D69B57EF82CC836CADC372B210DA8", hash_generated_method = "1FEC139DF0BDEA5B2B34BC8A24D414EF")
    
public final String getName() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.127 -0500", hash_original_method = "C84962AC42FE97CD37014EB04A226348", hash_generated_method = "9EFCB6759A3AA73FFE07BE8351A09694")
    
public void checkGuard(Object obj) throws SecurityException { }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.129 -0500", hash_original_method = "3B418AF4D3F113F25455A16498EE96FC", hash_generated_method = "72CEE043BC58F57AADD951EAAC71C1D6")
    
public PermissionCollection newPermissionCollection() {
        return new AllPermissionCollection();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.132 -0500", hash_original_method = "29B5CE65D8821EF2AD74234125DFF7AA", hash_generated_method = "9CF50528387D48395BA46B8306AF52D6")
    
public abstract String getActions();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.134 -0500", hash_original_method = "EFDD42BDCC8AFC7DB3076C40E1EA19C3", hash_generated_method = "7DCD9075AD00F391A9B7B11ED234E399")
    
public abstract boolean implies(Permission permission);
    
}

