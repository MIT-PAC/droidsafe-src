package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.http.params.HttpParams;




public final class CookieSpecRegistry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.744 -0500", hash_original_field = "B37A8525745FEA41F536E1DEDD24F56B", hash_generated_field = "010E9F60B3F377D0B23925E8DA25B64D")


    private  Map<String,CookieSpecFactory> registeredSpecs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.744 -0500", hash_original_method = "87109D006D3940B2EC7D884D0D44DEE0", hash_generated_method = "A9BB432EBF45DB1187902365BF6F14A9")
    public CookieSpecRegistry() {
        super();
        this.registeredSpecs = new LinkedHashMap<String,CookieSpecFactory>();
    }
    
    /**
     * Registers a {@link CookieSpecFactory} with the given identifier. 
     * If a specification with the given name already exists it will be overridden.  
     * This nameis the same one used to retrieve the {@link CookieSpecFactory} 
     * from {@link #getCookieSpec(String)}.
     * 
     * @param name the identifier for this specification
     * @param factory the {@link CookieSpecFactory} class to register
     * 
     * @see #getCookieSpec(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.746 -0500", hash_original_method = "BDFFC987379352646E2DC4AD0AE6816D", hash_generated_method = "258D060C6198B6B60CD8558E2B157958")
    public synchronized void register(final String name, final CookieSpecFactory factory) {
         if (name == null) {
             throw new IllegalArgumentException("Name may not be null");
         }
        if (factory == null) {
            throw new IllegalArgumentException("Cookie spec factory may not be null");
        }
        registeredSpecs.put(name.toLowerCase(Locale.ENGLISH), factory);
    }

    /**
     * Unregisters the {@link CookieSpecFactory} with the given ID.
     * 
     * @param id the identifier of the {@link CookieSpec cookie specification} to unregister
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.747 -0500", hash_original_method = "7F517F7E1779C641A5E7B828D148D2B3", hash_generated_method = "2A383B5680309C4C1C3585D57F3DF7F3")
    public synchronized void unregister(final String id) {
         if (id == null) {
             throw new IllegalArgumentException("Id may not be null");
         }
         registeredSpecs.remove(id.toLowerCase(Locale.ENGLISH));
    }

    /**
     * Gets the {@link CookieSpec cookie specification} with the given ID.
     * 
     * @param name the {@link CookieSpec cookie specification} identifier
     * @param params the {@link HttpParams HTTP parameters} for the cookie
     *  specification. 
     * 
     * @return {@link CookieSpec cookie specification}
     * 
     * @throws IllegalStateException if a policy with the given name cannot be found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.748 -0500", hash_original_method = "8996807FE7E231444D0F4F50C2BE4E33", hash_generated_method = "D20BEFDAD6A83D519D09595EC88212A5")
    public synchronized CookieSpec getCookieSpec(final String name, final HttpParams params) 
        throws IllegalStateException {

        if (name == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        CookieSpecFactory factory = registeredSpecs.get(name.toLowerCase(Locale.ENGLISH));
        if (factory != null) {
            return factory.newInstance(params);
        } else {
            throw new IllegalStateException("Unsupported cookie spec: " + name);
        }
    } 

    /**
     * Gets the {@link CookieSpec cookie specification} with the given name.
     * 
     * @param name the {@link CookieSpec cookie specification} identifier
     * 
     * @return {@link CookieSpec cookie specification}
     * 
     * @throws IllegalStateException if a policy with the given name cannot be found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.748 -0500", hash_original_method = "44CB7B6D7C3249DF9FE20C6D12DA10E7", hash_generated_method = "A7E9E008F9FDE833787F60B566D2C238")
    public synchronized CookieSpec getCookieSpec(final String name) 
        throws IllegalStateException {
        return getCookieSpec(name, null);
    } 

    /**
     * Obtains a list containing names of all registered {@link CookieSpec cookie 
     * specs} in their default order.
     * 
     * Note that the DEFAULT policy (if present) is likely to be the same
     * as one of the other policies, but does not have to be.
     * 
     * @return list of registered cookie spec names
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.749 -0500", hash_original_method = "4CC259988AD0BC6F5659CB623EFD31B9", hash_generated_method = "40AC73DB014F53544211242E832A2F83")
    public synchronized List<String> getSpecNames(){
        return new ArrayList<String>(registeredSpecs.keySet()); 
    }
    
    /**
     * Populates the internal collection of registered {@link CookieSpec cookie 
     * specs} with the content of the map passed as a parameter.
     * 
     * @param map cookie specs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.750 -0500", hash_original_method = "5E760DEDDE84B9034662300F5010E126", hash_generated_method = "0823840F3D90FF3A7EBCEE3046F66CD8")
    public synchronized void setItems(final Map<String, CookieSpecFactory> map) {
        if (map == null) {
            return;
        }
        registeredSpecs.clear();
        registeredSpecs.putAll(map);
    }

    
}

