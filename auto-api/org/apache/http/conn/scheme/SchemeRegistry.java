package org.apache.http.conn.scheme;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;

public final class SchemeRegistry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.331 -0400", hash_original_field = "49E3DD06FF2AA56D06FA884BEB565B65", hash_generated_field = "F36240EAE5CF2A96AAAB44994667903B")

    private Map<String,Scheme> registeredSchemes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.332 -0400", hash_original_method = "783AF87541D2DBDBA1743DA12D81CD53", hash_generated_method = "19CED71237E12F258C2D993EF51D05E7")
    public  SchemeRegistry() {
        super();
        registeredSchemes = new LinkedHashMap<String,Scheme>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.332 -0400", hash_original_method = "C5B073CA8B29C4A4D0086C8D16427838", hash_generated_method = "470C6F438F9AB9A73B8BB8828AFAAEF9")
    public synchronized final Scheme getScheme(String name) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_234746305 = null; 
        Scheme found = get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Scheme '"+name+"' not registered.");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_234746305 = found;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_234746305.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_234746305;
        
        
        
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.333 -0400", hash_original_method = "1246E5540B6FD28C8D868D100FFA2CE0", hash_generated_method = "8C1B2187F86894E5A1330D1ACEF71C62")
    public synchronized final Scheme getScheme(HttpHost host) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_284728346 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Host must not be null.");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_284728346 = getScheme(host.getSchemeName());
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_284728346.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_284728346;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.333 -0400", hash_original_method = "CF0C42ED0F9F87284AAED270A8C47522", hash_generated_method = "3420E16BF2AB183D357FEB79D7C2B172")
    public synchronized final Scheme get(String name) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_1201298226 = null; 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name must not be null.");
        Scheme found = registeredSchemes.get(name);
        varB4EAC82CA7396A68D541C85D26508E83_1201298226 = found;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1201298226.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1201298226;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.334 -0400", hash_original_method = "BF6DF8E3D28698AF7FF4E9FD5B4A484C", hash_generated_method = "8A67CD2281D3A88CC76567381418DA62")
    public synchronized final Scheme register(Scheme sch) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_1244386932 = null; 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Scheme must not be null.");
        Scheme old = registeredSchemes.put(sch.getName(), sch);
        varB4EAC82CA7396A68D541C85D26508E83_1244386932 = old;
        addTaint(sch.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1244386932.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1244386932;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.336 -0400", hash_original_method = "68812395544991B9645F8BA0B34BB709", hash_generated_method = "1667FE97E51E5F658BFD35DA5A855B55")
    public synchronized final Scheme unregister(String name) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_750593246 = null; 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name must not be null.");
        Scheme gone = registeredSchemes.remove(name);
        varB4EAC82CA7396A68D541C85D26508E83_750593246 = gone;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_750593246.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_750593246;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.337 -0400", hash_original_method = "AC70BADA49B0F71D218410F2BC1D1DD5", hash_generated_method = "91EA11995DF7153906C645B17E574EA8")
    public synchronized final List<String> getSchemeNames() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_510819629 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_510819629 = new ArrayList<String>(registeredSchemes.keySet());
        varB4EAC82CA7396A68D541C85D26508E83_510819629.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_510819629;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.338 -0400", hash_original_method = "E53575E4E05CC4D1B4FC58DE949DDA2A", hash_generated_method = "27473A3602816200EC7D380D28F300EA")
    public synchronized void setItems(final Map<String, Scheme> map) {
        registeredSchemes.clear();
        registeredSchemes.putAll(map);
        addTaint(map.getTaint());
        
        
            
        
        
        
    }

    
}

