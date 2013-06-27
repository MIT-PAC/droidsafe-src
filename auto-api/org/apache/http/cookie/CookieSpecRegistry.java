package org.apache.http.cookie;

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

public final class CookieSpecRegistry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.764 -0400", hash_original_field = "601891FA30D304E1116F68409D06FF18", hash_generated_field = "010E9F60B3F377D0B23925E8DA25B64D")

    private Map<String,CookieSpecFactory> registeredSpecs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.764 -0400", hash_original_method = "87109D006D3940B2EC7D884D0D44DEE0", hash_generated_method = "849BE43B7A2F1D6C8BC4FFD5DDB64A6F")
    public  CookieSpecRegistry() {
        super();
        this.registeredSpecs = new LinkedHashMap<String,CookieSpecFactory>();
        // ---------- Original Method ----------
        //this.registeredSpecs = new LinkedHashMap<String,CookieSpecFactory>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.772 -0400", hash_original_method = "BDFFC987379352646E2DC4AD0AE6816D", hash_generated_method = "DEBF154ED136E03C4412772D77526CC2")
    public synchronized void register(final String name, final CookieSpecFactory factory) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie spec factory may not be null");
        } //End block
        registeredSpecs.put(name.toLowerCase(Locale.ENGLISH), factory);
        addTaint(name.getTaint());
        addTaint(factory.getTaint());
        // ---------- Original Method ----------
        //if (name == null) {
             //throw new IllegalArgumentException("Name may not be null");
         //}
        //if (factory == null) {
            //throw new IllegalArgumentException("Cookie spec factory may not be null");
        //}
        //registeredSpecs.put(name.toLowerCase(Locale.ENGLISH), factory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.776 -0400", hash_original_method = "7F517F7E1779C641A5E7B828D148D2B3", hash_generated_method = "1C131D4B29A2C6A62090437665374636")
    public synchronized void unregister(final String id) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Id may not be null");
        } //End block
        registeredSpecs.remove(id.toLowerCase(Locale.ENGLISH));
        addTaint(id.getTaint());
        // ---------- Original Method ----------
        //if (id == null) {
             //throw new IllegalArgumentException("Id may not be null");
         //}
        //registeredSpecs.remove(id.toLowerCase(Locale.ENGLISH));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.780 -0400", hash_original_method = "8996807FE7E231444D0F4F50C2BE4E33", hash_generated_method = "6D017C08743128EDA2304DF5BA30E635")
    public synchronized CookieSpec getCookieSpec(final String name, final HttpParams params) throws IllegalStateException {
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_101950839 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } //End block
        CookieSpecFactory factory;
        factory = registeredSpecs.get(name.toLowerCase(Locale.ENGLISH));
        {
            varB4EAC82CA7396A68D541C85D26508E83_101950839 = factory.newInstance(params);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unsupported cookie spec: " + name);
        } //End block
        addTaint(name.getTaint());
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_101950839.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_101950839;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Name may not be null");
        //}
        //CookieSpecFactory factory = registeredSpecs.get(name.toLowerCase(Locale.ENGLISH));
        //if (factory != null) {
            //return factory.newInstance(params);
        //} else {
            //throw new IllegalStateException("Unsupported cookie spec: " + name);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.784 -0400", hash_original_method = "44CB7B6D7C3249DF9FE20C6D12DA10E7", hash_generated_method = "F77302F20465DAF1D3E9D50B1A979AB4")
    public synchronized CookieSpec getCookieSpec(final String name) throws IllegalStateException {
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_1538249430 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1538249430 = getCookieSpec(name, null);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1538249430.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1538249430;
        // ---------- Original Method ----------
        //return getCookieSpec(name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.791 -0400", hash_original_method = "4CC259988AD0BC6F5659CB623EFD31B9", hash_generated_method = "E8716C53444C5AF87C982741942DF1A0")
    public synchronized List<String> getSpecNames() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_2122972870 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2122972870 = new ArrayList<String>(registeredSpecs.keySet());
        varB4EAC82CA7396A68D541C85D26508E83_2122972870.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2122972870;
        // ---------- Original Method ----------
        //return new ArrayList<String>(registeredSpecs.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.792 -0400", hash_original_method = "5E760DEDDE84B9034662300F5010E126", hash_generated_method = "9CA81B36E02268EA21793E42BCD48408")
    public synchronized void setItems(final Map<String, CookieSpecFactory> map) {
        registeredSpecs.clear();
        registeredSpecs.putAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //if (map == null) {
            //return;
        //}
        //registeredSpecs.clear();
        //registeredSpecs.putAll(map);
    }

    
}

