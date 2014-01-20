package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class InstantiationException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.229 -0500", hash_original_field = "D10ACE1DDA78E9447F5C27832B5E3CDA", hash_generated_field = "57E92CFED008DEE9CBA7BDD040519D1D")

    private static final long serialVersionUID = -8441929162975509110L;

    /**
     * Constructs a new {@code InstantiationException} that includes the current
     * stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.232 -0500", hash_original_method = "4FE52ED96718E49A2C12E29EB6D41BB1", hash_generated_method = "CB14AF0C86D4D9D695ABB5BA23BB8A90")
    
public InstantiationException() {
    }

    /**
     * Constructs a new {@code InstantiationException} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.235 -0500", hash_original_method = "5F54417A31BE783961475C78B79DF3BE", hash_generated_method = "3557293837D1FC0F7C5D9E2B00C64DA3")
    
public InstantiationException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code InstantiationException} with the current stack
     * trace and the class that caused this exception.
     *
     * @param clazz
     *            the class that can not be instantiated.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.237 -0500", hash_original_method = "6F408C13CB22C61379FA2022EB73B671", hash_generated_method = "6F408C13CB22C61379FA2022EB73B671")
    
InstantiationException(Class<?> clazz) {
        super(clazz.getName());
    }
}

