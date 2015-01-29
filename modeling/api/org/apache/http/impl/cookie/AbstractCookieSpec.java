package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;

public abstract class AbstractCookieSpec implements CookieSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.604 -0500", hash_original_field = "43A9094CB57C2C7C4EEDCFB17CF21065", hash_generated_field = "25D17092F85E51EF7D67F5963CE29C57")

    private  Map<String, CookieAttributeHandler> attribHandlerMap;

    /** 
     * Default constructor 
     * */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.606 -0500", hash_original_method = "0B3B80B58135DE0CE3912FEB5FB0300B", hash_generated_method = "86A9B77828C40B0D962397C0CA763DAC")
    
public AbstractCookieSpec() {
        super();
        this.attribHandlerMap = new HashMap<String, CookieAttributeHandler>(10);        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.608 -0500", hash_original_method = "9190789BDD8DB6BFF150C07D3746174E", hash_generated_method = "5DC1CF3DD658C7B900F0E5AA6BEABEC8")
    
public void registerAttribHandler(
            final String name, final CookieAttributeHandler handler) {
        if (name == null) {
            throw new IllegalArgumentException("Attribute name may not be null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("Attribute handler may not be null");
        }
        this.attribHandlerMap.put(name, handler);
    }
    
    /**
     * Finds an attribute handler {@link CookieAttributeHandler} for the
     * given attribute. Returns <tt>null</tt> if no attribute handler is
     * found for the specified attribute.
     *
     * @param name attribute name. e.g. Domain, Path, etc.
     * @return an attribute handler or <tt>null</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.610 -0500", hash_original_method = "BCC9FF9C8AB53BB12822345DA7DF2FF0", hash_generated_method = "A19E40CFE4D3700251430B85E09A9A15")
    
protected CookieAttributeHandler findAttribHandler(final String name) {
        return this.attribHandlerMap.get(name);
    }
    
    /**
     * Gets attribute handler {@link CookieAttributeHandler} for the
     * given attribute.
     *
     * @param name attribute name. e.g. Domain, Path, etc.
     * @throws IllegalStateException if handler not found for the
     *          specified attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.613 -0500", hash_original_method = "F6557A039F439C9724E0D7B320BEE361", hash_generated_method = "671F2766A8551191777C6CE147645DE3")
    
protected CookieAttributeHandler getAttribHandler(final String name) {
        CookieAttributeHandler handler = findAttribHandler(name);
        if (handler == null) {
            throw new IllegalStateException("Handler not registered for " +
                                            name + " attribute.");
        } else {
            return handler;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.615 -0500", hash_original_method = "BF6A284618BDB748E6134235BAFA5C45", hash_generated_method = "93061CCFA4D56EE62B9F8B8C7F8FA92F")
    
protected Collection<CookieAttributeHandler> getAttribHandlers() {
        return this.attribHandlerMap.values();
    }
    
}

