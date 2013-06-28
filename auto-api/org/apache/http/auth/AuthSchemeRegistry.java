package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.params.HttpParams;

public final class AuthSchemeRegistry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.551 -0400", hash_original_field = "49E3DD06FF2AA56D06FA884BEB565B65", hash_generated_field = "7DEAAE1C48DF7EB41AD4414C102662D1")

    private Map<String,AuthSchemeFactory> registeredSchemes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.552 -0400", hash_original_method = "22746583E1A94F633C7199B49397C3E9", hash_generated_method = "6E2C4AB92C73ECD444FE51CD49F9C6A6")
    public  AuthSchemeRegistry() {
        super();
        this.registeredSchemes = new LinkedHashMap<String,AuthSchemeFactory>();
        // ---------- Original Method ----------
        //this.registeredSchemes = new LinkedHashMap<String,AuthSchemeFactory>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.552 -0400", hash_original_method = "86D80B5F63163F72174F2671E9B32DD3", hash_generated_method = "65F1BE0F34934E19D962D5ACF010A707")
    public synchronized void register(
            final String name, 
            final AuthSchemeFactory factory) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Authentication scheme factory may not be null");
        } //End block
        registeredSchemes.put(name.toLowerCase(Locale.ENGLISH), factory);
        addTaint(name.getTaint());
        addTaint(factory.getTaint());
        // ---------- Original Method ----------
        //if (name == null) {
             //throw new IllegalArgumentException("Name may not be null");
         //}
        //if (factory == null) {
            //throw new IllegalArgumentException("Authentication scheme factory may not be null");
        //}
        //registeredSchemes.put(name.toLowerCase(Locale.ENGLISH), factory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.553 -0400", hash_original_method = "65CA9EEB97401D491830ABAD4DFFB0A8", hash_generated_method = "1514877D402F7C961EC074F481D69A11")
    public synchronized void unregister(final String name) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } //End block
        registeredSchemes.remove(name.toLowerCase(Locale.ENGLISH));
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //if (name == null) {
             //throw new IllegalArgumentException("Name may not be null");
         //}
        //registeredSchemes.remove(name.toLowerCase(Locale.ENGLISH));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.553 -0400", hash_original_method = "8F2D5DDAEEB3D14130F6F0EEE6300B47", hash_generated_method = "0B79568CCFDADC8CDC13A7B83759A5EF")
    public synchronized AuthScheme getAuthScheme(final String name, final HttpParams params) throws IllegalStateException {
        AuthScheme varB4EAC82CA7396A68D541C85D26508E83_1889957171 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } //End block
        AuthSchemeFactory factory = registeredSchemes.get(name.toLowerCase(Locale.ENGLISH));
        {
            varB4EAC82CA7396A68D541C85D26508E83_1889957171 = factory.newInstance(params);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unsupported authentication scheme: " + name);
        } //End block
        addTaint(name.getTaint());
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1889957171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1889957171;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Name may not be null");
        //}
        //AuthSchemeFactory factory = registeredSchemes.get(name.toLowerCase(Locale.ENGLISH));
        //if (factory != null) {
            //return factory.newInstance(params);
        //} else {
            //throw new IllegalStateException("Unsupported authentication scheme: " + name);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.554 -0400", hash_original_method = "AC70BADA49B0F71D218410F2BC1D1DD5", hash_generated_method = "496588A94429C70DD44F09505CA8CD36")
    public synchronized List<String> getSchemeNames() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1613659303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1613659303 = new ArrayList<String>(registeredSchemes.keySet());
        varB4EAC82CA7396A68D541C85D26508E83_1613659303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1613659303;
        // ---------- Original Method ----------
        //return new ArrayList<String>(registeredSchemes.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.555 -0400", hash_original_method = "34BF27E04F7109EDCEF6964572DA093F", hash_generated_method = "2F5438C9C91161D2A8D6AD7DD3A01698")
    public synchronized void setItems(final Map<String, AuthSchemeFactory> map) {
        registeredSchemes.clear();
        registeredSchemes.putAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //if (map == null) {
            //return;
        //}
        //registeredSchemes.clear();
        //registeredSchemes.putAll(map);
    }

    
}

