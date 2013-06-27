package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class DefaultedHttpContext implements HttpContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.233 -0400", hash_original_field = "F5DDAF0CA7929578B408C909429F68F2", hash_generated_field = "E015EF617CD4ED004D5007AC30C609BC")

    private HttpContext local;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.233 -0400", hash_original_field = "A4A918A45181164207929D52AEC36AEC", hash_generated_field = "7ADABA5216B59FD658450669A2A3CCAA")

    private HttpContext defaults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.235 -0400", hash_original_method = "A0575674BF73385D2F6A60AE80137BEF", hash_generated_method = "FED509538BE6B1021605219EBCAA345E")
    public  DefaultedHttpContext(final HttpContext local, final HttpContext defaults) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } //End block
        this.local = local;
        this.defaults = defaults;
        // ---------- Original Method ----------
        //if (local == null) {
            //throw new IllegalArgumentException("HTTP context may not be null");
        //}
        //this.local = local;
        //this.defaults = defaults;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.235 -0400", hash_original_method = "E6F5162D8C28E0713279EA6EC6682784", hash_generated_method = "4BE0AA0F875E85CFD33285804B3543C0")
    public Object getAttribute(final String id) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1476785118 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_447170886 = null; //Variable for return #2
        Object obj;
        obj = this.local.getAttribute(id);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1476785118 = this.defaults.getAttribute(id);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_447170886 = obj;
        } //End block
        addTaint(id.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1864656169; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1864656169 = varB4EAC82CA7396A68D541C85D26508E83_1476785118;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1864656169 = varB4EAC82CA7396A68D541C85D26508E83_447170886;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1864656169.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1864656169;
        // ---------- Original Method ----------
        //Object obj = this.local.getAttribute(id);
        //if (obj == null) {
            //return this.defaults.getAttribute(id);
        //} else {
            //return obj;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.236 -0400", hash_original_method = "0AEE49A004EDC83FD5C79915CB13681F", hash_generated_method = "201824B37F0E2A9A52983363E9664910")
    public Object removeAttribute(final String id) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1230897193 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1230897193 = this.local.removeAttribute(id);
        addTaint(id.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1230897193.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1230897193;
        // ---------- Original Method ----------
        //return this.local.removeAttribute(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.236 -0400", hash_original_method = "EE2D3704A963700B0310D3F12DCBDD4D", hash_generated_method = "991E683E87425CB8B8ABDD6BD9C7AE12")
    public void setAttribute(final String id, final Object obj) {
        this.local.setAttribute(id, obj);
        addTaint(id.getTaint());
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //this.local.setAttribute(id, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.238 -0400", hash_original_method = "FA59965C12DF7B81C110308001A0693E", hash_generated_method = "9E7E91967D9E113645EA319E3453BE6A")
    public HttpContext getDefaults() {
        HttpContext varB4EAC82CA7396A68D541C85D26508E83_517341165 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_517341165 = this.defaults;
        varB4EAC82CA7396A68D541C85D26508E83_517341165.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_517341165;
        // ---------- Original Method ----------
        //return this.defaults;
    }

    
}

