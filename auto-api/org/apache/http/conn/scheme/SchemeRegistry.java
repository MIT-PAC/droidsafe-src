package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;

public final class SchemeRegistry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.494 -0400", hash_original_field = "49E3DD06FF2AA56D06FA884BEB565B65", hash_generated_field = "F36240EAE5CF2A96AAAB44994667903B")

    private Map<String,Scheme> registeredSchemes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.494 -0400", hash_original_method = "783AF87541D2DBDBA1743DA12D81CD53", hash_generated_method = "19CED71237E12F258C2D993EF51D05E7")
    public  SchemeRegistry() {
        super();
        registeredSchemes = new LinkedHashMap<String,Scheme>();
        // ---------- Original Method ----------
        //registeredSchemes = new LinkedHashMap<String,Scheme>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.495 -0400", hash_original_method = "C5B073CA8B29C4A4D0086C8D16427838", hash_generated_method = "3DD09C3E56D24D2F6F27192ECEE1152E")
    public synchronized final Scheme getScheme(String name) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_1867208138 = null; //Variable for return #1
        Scheme found;
        found = get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Scheme '"+name+"' not registered.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1867208138 = found;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1867208138.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1867208138;
        // ---------- Original Method ----------
        //Scheme found = get(name);
        //if (found == null) {
            //throw new IllegalStateException
                //("Scheme '"+name+"' not registered.");
        //}
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.496 -0400", hash_original_method = "1246E5540B6FD28C8D868D100FFA2CE0", hash_generated_method = "95CB52174FE97921EF9B50C1A130AF2A")
    public synchronized final Scheme getScheme(HttpHost host) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_556737964 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Host must not be null.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_556737964 = getScheme(host.getSchemeName());
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_556737964.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_556737964;
        // ---------- Original Method ----------
        //if (host == null) {
            //throw new IllegalArgumentException("Host must not be null.");
        //}
        //return getScheme(host.getSchemeName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.497 -0400", hash_original_method = "CF0C42ED0F9F87284AAED270A8C47522", hash_generated_method = "0DB73813C833F50CA1427AF397BDA6EC")
    public synchronized final Scheme get(String name) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_288709267 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name must not be null.");
        Scheme found;
        found = registeredSchemes.get(name);
        varB4EAC82CA7396A68D541C85D26508E83_288709267 = found;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_288709267.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_288709267;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new IllegalArgumentException("Name must not be null.");
        //Scheme found = registeredSchemes.get(name);
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.527 -0400", hash_original_method = "BF6DF8E3D28698AF7FF4E9FD5B4A484C", hash_generated_method = "5E23574AB0BD7821847EB59F084067A7")
    public synchronized final Scheme register(Scheme sch) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_1324764468 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Scheme must not be null.");
        Scheme old;
        old = registeredSchemes.put(sch.getName(), sch);
        varB4EAC82CA7396A68D541C85D26508E83_1324764468 = old;
        addTaint(sch.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1324764468.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1324764468;
        // ---------- Original Method ----------
        //if (sch == null)
            //throw new IllegalArgumentException("Scheme must not be null.");
        //Scheme old = registeredSchemes.put(sch.getName(), sch);
        //return old;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.529 -0400", hash_original_method = "68812395544991B9645F8BA0B34BB709", hash_generated_method = "C6BC5961632A34B304054CF58A7EE45A")
    public synchronized final Scheme unregister(String name) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_1060940795 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name must not be null.");
        Scheme gone;
        gone = registeredSchemes.remove(name);
        varB4EAC82CA7396A68D541C85D26508E83_1060940795 = gone;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1060940795.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1060940795;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new IllegalArgumentException("Name must not be null.");
        //Scheme gone = registeredSchemes.remove(name);
        //return gone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.532 -0400", hash_original_method = "AC70BADA49B0F71D218410F2BC1D1DD5", hash_generated_method = "FA53C89A3F46C4294BA8E2047A3FD796")
    public synchronized final List<String> getSchemeNames() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1594618577 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1594618577 = new ArrayList<String>(registeredSchemes.keySet());
        varB4EAC82CA7396A68D541C85D26508E83_1594618577.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1594618577;
        // ---------- Original Method ----------
        //return new ArrayList<String>(registeredSchemes.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.532 -0400", hash_original_method = "E53575E4E05CC4D1B4FC58DE949DDA2A", hash_generated_method = "27473A3602816200EC7D380D28F300EA")
    public synchronized void setItems(final Map<String, Scheme> map) {
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

