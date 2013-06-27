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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.468 -0400", hash_original_field = "49E3DD06FF2AA56D06FA884BEB565B65", hash_generated_field = "F36240EAE5CF2A96AAAB44994667903B")

    private Map<String,Scheme> registeredSchemes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.468 -0400", hash_original_method = "783AF87541D2DBDBA1743DA12D81CD53", hash_generated_method = "19CED71237E12F258C2D993EF51D05E7")
    public  SchemeRegistry() {
        super();
        registeredSchemes = new LinkedHashMap<String,Scheme>();
        // ---------- Original Method ----------
        //registeredSchemes = new LinkedHashMap<String,Scheme>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.469 -0400", hash_original_method = "C5B073CA8B29C4A4D0086C8D16427838", hash_generated_method = "FC8D51EDD00CFF1CD8C498494BAA9FBF")
    public synchronized final Scheme getScheme(String name) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_1944702718 = null; //Variable for return #1
        Scheme found;
        found = get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Scheme '"+name+"' not registered.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1944702718 = found;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1944702718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1944702718;
        // ---------- Original Method ----------
        //Scheme found = get(name);
        //if (found == null) {
            //throw new IllegalStateException
                //("Scheme '"+name+"' not registered.");
        //}
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.469 -0400", hash_original_method = "1246E5540B6FD28C8D868D100FFA2CE0", hash_generated_method = "6CB049B7EC71E2189940CEA3C0DBB906")
    public synchronized final Scheme getScheme(HttpHost host) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_1537069829 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Host must not be null.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1537069829 = getScheme(host.getSchemeName());
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1537069829.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1537069829;
        // ---------- Original Method ----------
        //if (host == null) {
            //throw new IllegalArgumentException("Host must not be null.");
        //}
        //return getScheme(host.getSchemeName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.470 -0400", hash_original_method = "CF0C42ED0F9F87284AAED270A8C47522", hash_generated_method = "F24A1E542ACC41CFC95C4AC218848896")
    public synchronized final Scheme get(String name) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_40202875 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name must not be null.");
        Scheme found;
        found = registeredSchemes.get(name);
        varB4EAC82CA7396A68D541C85D26508E83_40202875 = found;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_40202875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_40202875;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new IllegalArgumentException("Name must not be null.");
        //Scheme found = registeredSchemes.get(name);
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.470 -0400", hash_original_method = "BF6DF8E3D28698AF7FF4E9FD5B4A484C", hash_generated_method = "CC23F1EB62F2BFDF72F0261058DBEEC1")
    public synchronized final Scheme register(Scheme sch) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_1571559326 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Scheme must not be null.");
        Scheme old;
        old = registeredSchemes.put(sch.getName(), sch);
        varB4EAC82CA7396A68D541C85D26508E83_1571559326 = old;
        addTaint(sch.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1571559326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1571559326;
        // ---------- Original Method ----------
        //if (sch == null)
            //throw new IllegalArgumentException("Scheme must not be null.");
        //Scheme old = registeredSchemes.put(sch.getName(), sch);
        //return old;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.485 -0400", hash_original_method = "68812395544991B9645F8BA0B34BB709", hash_generated_method = "BFFDE9494CE764B615F4C59E34147EC7")
    public synchronized final Scheme unregister(String name) {
        Scheme varB4EAC82CA7396A68D541C85D26508E83_833672144 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name must not be null.");
        Scheme gone;
        gone = registeredSchemes.remove(name);
        varB4EAC82CA7396A68D541C85D26508E83_833672144 = gone;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_833672144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_833672144;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new IllegalArgumentException("Name must not be null.");
        //Scheme gone = registeredSchemes.remove(name);
        //return gone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.485 -0400", hash_original_method = "AC70BADA49B0F71D218410F2BC1D1DD5", hash_generated_method = "A6695DD701CFFBC87AF94B0749FC4968")
    public synchronized final List<String> getSchemeNames() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_296635529 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_296635529 = new ArrayList<String>(registeredSchemes.keySet());
        varB4EAC82CA7396A68D541C85D26508E83_296635529.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_296635529;
        // ---------- Original Method ----------
        //return new ArrayList<String>(registeredSchemes.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.485 -0400", hash_original_method = "E53575E4E05CC4D1B4FC58DE949DDA2A", hash_generated_method = "27473A3602816200EC7D380D28F300EA")
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

