package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;




public class BasicHttpContext implements HttpContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.956 -0500", hash_original_field = "AE9AEAD8987EA62C0A77312800FC6E06", hash_generated_field = "D1460501CCEE3C619EE4C99664E2DBB5")

    
    private  HttpContext parentContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.957 -0500", hash_original_field = "CBF5F9A9A24239AF2E2DA4DE606EC2D7", hash_generated_field = "14270C32B91E233A04B6BA686361124C")

    private Map map = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.958 -0500", hash_original_method = "7A4905790D001081AE9E7E7092B16556", hash_generated_method = "12A7496AFEC164E290DB967A345FD4D7")
    public BasicHttpContext() {
        this(null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.959 -0500", hash_original_method = "A4B2F68240B72FA009235C6627ABF17D", hash_generated_method = "DA55BE8CFECDFAA75EFE22E59F427E43")
    public BasicHttpContext(final HttpContext parentContext) {
        super();
        this.parentContext = parentContext;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.960 -0500", hash_original_method = "5AF73FFF83A5EDE5922275A66AC65FB8", hash_generated_method = "DAC84FC07D0A474AF9D1588FD5723CE3")
    public Object getAttribute(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Id may not be null");
        }
        Object obj = null;
        if (this.map != null) {
            obj = this.map.get(id);
        }
        if (obj == null && this.parentContext != null) {
            obj = this.parentContext.getAttribute(id);
        }
        return obj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.960 -0500", hash_original_method = "7CCB44BFA094973C3F41CEC20132EE3C", hash_generated_method = "E65B164F0E43B1CB569F163EC1B26840")
    public void setAttribute(final String id, final Object obj) {
        if (id == null) {
            throw new IllegalArgumentException("Id may not be null");
        }
        if (this.map == null) {
            this.map = new HashMap();
        }
        this.map.put(id, obj);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.961 -0500", hash_original_method = "F81CB5E3AB9015A95E5E2B5DBCB1E2A6", hash_generated_method = "12C51558FEC591831921FA9B2649D535")
    public Object removeAttribute(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Id may not be null");
        }
        if (this.map != null) {
            return this.map.remove(id);
        } else {
            return null;
        }
    }

    
}

