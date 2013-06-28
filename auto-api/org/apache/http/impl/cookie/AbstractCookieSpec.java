package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;

public abstract class AbstractCookieSpec implements CookieSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.858 -0400", hash_original_field = "495FEB68394F20BD9FD7141BB4B46729", hash_generated_field = "25D17092F85E51EF7D67F5963CE29C57")

    private Map<String, CookieAttributeHandler> attribHandlerMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.858 -0400", hash_original_method = "0B3B80B58135DE0CE3912FEB5FB0300B", hash_generated_method = "AD2F0091602CAB4242D76446C8217611")
    public  AbstractCookieSpec() {
        super();
        this.attribHandlerMap = new HashMap<String, CookieAttributeHandler>(10);
        // ---------- Original Method ----------
        //this.attribHandlerMap = new HashMap<String, CookieAttributeHandler>(10);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.859 -0400", hash_original_method = "9190789BDD8DB6BFF150C07D3746174E", hash_generated_method = "BC8EB9126DAB413BF94898C961AF093E")
    public void registerAttribHandler(
            final String name, final CookieAttributeHandler handler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Attribute name may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Attribute handler may not be null");
        } //End block
        this.attribHandlerMap.put(name, handler);
        addTaint(name.getTaint());
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Attribute name may not be null");
        //}
        //if (handler == null) {
            //throw new IllegalArgumentException("Attribute handler may not be null");
        //}
        //this.attribHandlerMap.put(name, handler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.859 -0400", hash_original_method = "BCC9FF9C8AB53BB12822345DA7DF2FF0", hash_generated_method = "2300229794349F9BCD46D311B39FE4A7")
    protected CookieAttributeHandler findAttribHandler(final String name) {
        CookieAttributeHandler varB4EAC82CA7396A68D541C85D26508E83_357146696 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_357146696 = this.attribHandlerMap.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_357146696.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_357146696;
        // ---------- Original Method ----------
        //return this.attribHandlerMap.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.860 -0400", hash_original_method = "F6557A039F439C9724E0D7B320BEE361", hash_generated_method = "CA44DAE6AD4BF45551689CD35F0045A6")
    protected CookieAttributeHandler getAttribHandler(final String name) {
        CookieAttributeHandler varB4EAC82CA7396A68D541C85D26508E83_452258437 = null; //Variable for return #1
        CookieAttributeHandler handler = findAttribHandler(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Handler not registered for " +
                                            name + " attribute.");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_452258437 = handler;
        } //End block
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_452258437.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_452258437;
        // ---------- Original Method ----------
        //CookieAttributeHandler handler = findAttribHandler(name);
        //if (handler == null) {
            //throw new IllegalStateException("Handler not registered for " +
                                            //name + " attribute.");
        //} else {
            //return handler;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.861 -0400", hash_original_method = "BF6A284618BDB748E6134235BAFA5C45", hash_generated_method = "5686D056F68B14ECF314D08EDEA4A920")
    protected Collection<CookieAttributeHandler> getAttribHandlers() {
        Collection<CookieAttributeHandler> varB4EAC82CA7396A68D541C85D26508E83_2139855042 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2139855042 = this.attribHandlerMap.values();
        varB4EAC82CA7396A68D541C85D26508E83_2139855042.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2139855042;
        // ---------- Original Method ----------
        //return this.attribHandlerMap.values();
    }

    
}

