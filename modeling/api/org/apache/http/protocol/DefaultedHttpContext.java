package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class DefaultedHttpContext implements HttpContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.521 -0500", hash_original_field = "6D2A54D860DEBB1E031F687F0830CF6F", hash_generated_field = "E015EF617CD4ED004D5007AC30C609BC")

    private  HttpContext local;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.524 -0500", hash_original_field = "FB45C7B58028E43766461E8C8059F493", hash_generated_field = "7ADABA5216B59FD658450669A2A3CCAA")

    private  HttpContext defaults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.527 -0500", hash_original_method = "A0575674BF73385D2F6A60AE80137BEF", hash_generated_method = "D2F9D43F197DE0F3D5D3425785FA8EC1")
    
public DefaultedHttpContext(final HttpContext local, final HttpContext defaults) {
        super();
        if (local == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
        this.local = local;
        this.defaults = defaults;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.529 -0500", hash_original_method = "E6F5162D8C28E0713279EA6EC6682784", hash_generated_method = "E94E515CD7BA06B5B09E33AB4660CDF3")
    
public Object getAttribute(final String id) {
        Object obj = this.local.getAttribute(id);
        if (obj == null) {
            return this.defaults.getAttribute(id);
        } else {
            return obj;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.532 -0500", hash_original_method = "0AEE49A004EDC83FD5C79915CB13681F", hash_generated_method = "CDACE077E3C198B2262748C00D934BD5")
    
public Object removeAttribute(final String id) {
        return this.local.removeAttribute(id);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.535 -0500", hash_original_method = "EE2D3704A963700B0310D3F12DCBDD4D", hash_generated_method = "230DE4EAE88EA33E341F37B703B11AF3")
    
public void setAttribute(final String id, final Object obj) {
        this.local.setAttribute(id, obj);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.538 -0500", hash_original_method = "FA59965C12DF7B81C110308001A0693E", hash_generated_method = "2417135D67EAB4F57C659CEED6FDC3B5")
    
public HttpContext getDefaults() {
        return this.defaults;
    }
    
}

