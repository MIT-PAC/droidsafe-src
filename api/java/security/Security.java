package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.harmony.security.fortress.Engine;
import org.apache.harmony.security.fortress.SecurityAccess;
import org.apache.harmony.security.fortress.Services;




public final class Security {

    // Register default providers
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.357 -0500", hash_original_method = "4FF6FA341ED545BB45EA708ED46D5EA7", hash_generated_method = "B9FBDF6F317E6E4AE7796420935CF81D")
    
private static void registerDefaultProviders() {
        secprops.put("security.provider.1", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider");
        secprops.put("security.provider.2", "org.apache.harmony.security.provider.cert.DRLCertFactory");
        secprops.put("security.provider.3", "org.bouncycastle.jce.provider.BouncyCastleProvider");
        secprops.put("security.provider.4", "org.apache.harmony.security.provider.crypto.CryptoProvider");
        secprops.put("security.provider.5", "org.apache.harmony.xnet.provider.jsse.JSSEProvider");
    }

    /**
     * Returns value for the specified algorithm with the specified name.
     *
     * @param algName
     *            the name of the algorithm.
     * @param propName
     *            the name of the property.
     * @return value of the property.
     * @deprecated Use {@link AlgorithmParameters} and {@link KeyFactory}
     *             instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.361 -0500", hash_original_method = "D3DABD5C1A3E4046B634B4ABE7B41DC8", hash_generated_method = "348187D66E3458F2A5A813E68314E45F")
    
@Deprecated
    public static String getAlgorithmProperty(String algName, String propName) {
        if (algName == null || propName == null) {
            return null;
        }
        String prop = "Alg." + propName + "." + algName;
        Provider[] providers = getProviders();
        for (Provider provider : providers) {
            for (Enumeration e = provider.propertyNames(); e.hasMoreElements(); ) {
                String propertyName = (String) e.nextElement();
                if (propertyName.equalsIgnoreCase(prop)) {
                    return provider.getProperty(propertyName);
                }
            }
        }
        return null;
    }

    /**
     * Insert the given {@code Provider} at the specified {@code position}. The
     * positions define the preference order in which providers are searched for
     * requested algorithms.
     *
     * @param provider
     *            the provider to insert.
     * @param position
     *            the position (starting from 1).
     * @return the actual position or {@code -1} if the given {@code provider}
     *         was already in the list. The actual position may be different
     *         from the desired position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.363 -0500", hash_original_method = "67AE1CD5DCFCA41946EBB236A4A63A0E", hash_generated_method = "CD338293BEA3F7EEA009E3372E54EA98")
    
public static synchronized int insertProviderAt(Provider provider, int position) {
        // check that provider is not already
        // installed, else return -1; if (position <1) or (position > max
        // position) position = max position + 1; insert provider, shift up
        // one position for next providers; Note: The position is 1-based
        if (getProvider(provider.getName()) != null) {
            return -1;
        }
        int result = Services.insertProviderAt(provider, position);
        renumProviders();
        return result;
    }

    /**
     * Adds the given {@code provider} to the collection of providers at the
     * next available position.
     *
     * @param provider
     *            the provider to be added.
     * @return the actual position or {@code -1} if the given {@code provider}
     *         was already in the list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.366 -0500", hash_original_method = "E56D0C14EE73394DE8439EEF0879315D", hash_generated_method = "7FE6810E7DCDA05798504F90847EBF2F")
    
public static int addProvider(Provider provider) {
        return insertProviderAt(provider, 0);
    }

    /**
     * Removes the {@code Provider} with the specified name form the collection
     * of providers. If the the {@code Provider} with the specified name is
     * removed, all provider at a greater position are shifted down one
     * position.
     *
     * <p>Returns silently if {@code name} is {@code null} or no provider with the
     * specified name is installed.
     *
     * @param name
     *            the name of the provider to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.369 -0500", hash_original_method = "B96A90ADCC337AF873B627F27B354B02", hash_generated_method = "CF5C0F72EF3C10E37A661172E365FA87")
    
public static synchronized void removeProvider(String name) {
        // It is not clear from spec.:
        // 1. if name is null, should we checkSecurityAccess or not?
        //    throw SecurityException or not?
        // 2. as 1 but provider is not installed
        // 3. behavior if name is empty string?

        Provider p;
        if ((name == null) || (name.length() == 0)) {
            return;
        }
        p = getProvider(name);
        if (p == null) {
            return;
        }
        Services.removeProvider(p.getProviderNumber());
        renumProviders();
        p.setProviderNumber(-1);
    }

    /**
     * Returns an array containing all installed providers. The providers are
     * ordered according their preference order.
     *
     * @return an array containing all installed providers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.371 -0500", hash_original_method = "EAE9285B08BB32BE2AF6653E79C9F615", hash_generated_method = "ED0B530D59AB27614637C6D2551CDFE9")
    
public static synchronized Provider[] getProviders() {
        return Services.getProviders();
    }

    /**
     * Returns the {@code Provider} with the specified name. Returns {@code
     * null} if name is {@code null} or no provider with the specified name is
     * installed.
     *
     * @param name
     *            the name of the requested provider.
     * @return the provider with the specified name, maybe {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.374 -0500", hash_original_method = "129A779E3BBD24BC13650E637FDCE401", hash_generated_method = "FF9D7A73DBD193463FD11FA473E485B0")
    
public static synchronized Provider getProvider(String name) {
        return Services.getProvider(name);
    }

    /**
     * Returns the array of providers which meet the user supplied string
     * filter. The specified filter must be supplied in one of two formats:
     * <nl>
     * <li> CRYPTO_SERVICE_NAME.ALGORITHM_OR_TYPE
     * <p>
     * (for example: "MessageDigest.SHA")
     * <li> CRYPTO_SERVICE_NAME.ALGORITHM_OR_TYPE
     * ATTR_NAME:ATTR_VALUE
     * <p>
     * (for example: "Signature.MD2withRSA KeySize:512")
     * </nl>
     *
     * @param filter
     *            case-insensitive filter.
     * @return the providers which meet the user supplied string filter {@code
     *         filter}. A {@code null} value signifies that none of the
     *         installed providers meets the filter specification.
     * @throws InvalidParameterException
     *             if an unusable filter is supplied.
     * @throws NullPointerException
     *             if {@code filter} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.376 -0500", hash_original_method = "F6138CDF14D8D5962F697D1DAE8ACD56", hash_generated_method = "55A03477641E49547C5C0296E5D3979B")
    
public static Provider[] getProviders(String filter) {
        if (filter == null) {
            throw new NullPointerException();
        }
        if (filter.length() == 0) {
            throw new InvalidParameterException();
        }
        HashMap<String, String> hm = new HashMap<String, String>();
        int i = filter.indexOf(':');
        if ((i == filter.length() - 1) || (i == 0)) {
            throw new InvalidParameterException();
        }
        if (i < 1) {
            hm.put(filter, "");
        } else {
            hm.put(filter.substring(0, i), filter.substring(i + 1));
        }
        return getProviders(hm);
    }

    /**
     * Returns the array of providers which meet the user supplied set of
     * filters. The filter must be supplied in one of two formats:
     * <nl>
     * <li> CRYPTO_SERVICE_NAME.ALGORITHM_OR_TYPE
     * <p>
     * for example: "MessageDigest.SHA" The value associated with the key must
     * be an empty string. <li> CRYPTO_SERVICE_NAME.ALGORITHM_OR_TYPE
     * ATTR_NAME:ATTR_VALUE
     * <p>
     * for example: "Signature.MD2withRSA KeySize:512" where "KeySize:512" is
     * the value of the filter map entry.
     * </nl>
     *
     * @param filter
     *            case-insensitive filter.
     * @return the providers which meet the user supplied string filter {@code
     *         filter}. A {@code null} value signifies that none of the
     *         installed providers meets the filter specification.
     * @throws InvalidParameterException
     *             if an unusable filter is supplied.
     * @throws NullPointerException
     *             if {@code filter} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.381 -0500", hash_original_method = "68DDE2F39160A5938C8ECA7BA32376CA", hash_generated_method = "7CF44E4609D8AE84EA35153F03FEF320")
    
public static synchronized Provider[] getProviders(Map<String,String> filter) {
        if (filter == null) {
            throw new NullPointerException();
        }
        if (filter.isEmpty()) {
            return null;
        }
        java.util.List<Provider> result = Services.getProvidersList();
        Set<Entry<String, String>> keys = filter.entrySet();
        Map.Entry<String, String> entry;
        for (Iterator<Entry<String, String>> it = keys.iterator(); it.hasNext();) {
            entry = it.next();
            String key = entry.getKey();
            String val = entry.getValue();
            String attribute = null;
            int i = key.indexOf(' ');
            int j = key.indexOf('.');
            if (j == -1) {
                throw new InvalidParameterException();
            }
            if (i == -1) { // <crypto_service>.<algorithm_or_type>
                if (val.length() != 0) {
                    throw new InvalidParameterException();
                }
            } else { // <crypto_service>.<algorithm_or_type> <attribute_name>
                if (val.length() == 0) {
                    throw new InvalidParameterException();
                }
                attribute = key.substring(i + 1);
                if (attribute.trim().length() == 0) {
                    throw new InvalidParameterException();
                }
                key = key.substring(0, i);
            }
            String serv = key.substring(0, j);
            String alg = key.substring(j + 1);
            if (serv.length() == 0 || alg.length() == 0) {
                throw new InvalidParameterException();
            }
            Provider p;
            for (int k = 0; k < result.size(); k++) {
                try {
                    p = result.get(k);
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
                if (!p.implementsAlg(serv, alg, attribute, val)) {
                    result.remove(p);
                    k--;
                }
            }
        }
        if (result.size() > 0) {
            return result.toArray(new Provider[result.size()]);
        }
        return null;
    }

    /**
     * Returns the value of the security property named by the argument.
     *
     * @param key
     *            the name of the requested security property.
     * @return the value of the security property.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.383 -0500", hash_original_method = "FBE94713485830A30BBD5079D4570A8E", hash_generated_method = "C17246BF3337C7E14B654907595AA70A")
    
public static String getProperty(String key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        String property = secprops.getProperty(key);
        if (property != null) {
            property = property.trim();
        }
        return property;
    }

    /**
     * Sets the value of the specified security property.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.386 -0500", hash_original_method = "E9A275F23060DA3D5E42FE19B6245D55", hash_generated_method = "EE34367337CA9748B635C6659AE4E420")
    
public static void setProperty(String key, String value) {
        secprops.put(key, value);
    }

    /**
     * Returns a {@code Set} of all registered algorithms for the specified
     * cryptographic service. {@code "Signature"}, {@code "Cipher"} and {@code
     * "KeyStore"} are examples for such kind of services.
     *
     * @param serviceName
     *            the case-insensitive name of the service.
     * @return a {@code Set} of all registered algorithms for the specified
     *         cryptographic service, or an empty {@code Set} if {@code
     *         serviceName} is {@code null} or if no registered provider
     *         provides the requested service.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.389 -0500", hash_original_method = "D678C323A21AFC9C219F4C1FB9E8266D", hash_generated_method = "A6BA2A563EED770A921797C4C4690111")
    
public static Set<String> getAlgorithms(String serviceName) {
        Set<String> result = new HashSet<String>();
        // compatibility with RI
        if (serviceName == null) {
            return result;
        }
        for (Provider provider : getProviders()) {
            for (Provider.Service service: provider.getServices()) {
                if (service.getType().equalsIgnoreCase(serviceName)) {
                    result.add(service.getAlgorithm());
                }
            }
        }
        return result;
    }

    /**
     *
     * Update sequence numbers of all providers.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.391 -0500", hash_original_method = "36CAA565E766988B673C74F846171C19", hash_generated_method = "92D0B4BBA24621AE273B53B31014859B")
    
private static void renumProviders() {
        Provider[] p = Services.getProviders();
        for (int i = 0; i < p.length; i++) {
            p[i].setProviderNumber(i + 1);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.351 -0500", hash_original_field = "316C260B369C976F6D55B7C36AB88F2C", hash_generated_field = "A93753A56D3EA0009297A4F944A7CCCC")

    private static final Properties secprops = new Properties();

    
    private static class SecurityDoor implements SecurityAccess {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.458 -0400", hash_original_method = "65CA8440349C4BCE4680F5FB73F99876", hash_generated_method = "65CA8440349C4BCE4680F5FB73F99876")
        public SecurityDoor ()
        {
            //Synthesized constructor
        }
        // Access to Security.renumProviders()
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.395 -0500", hash_original_method = "CC38396CF5E2C0D8624B241063796894", hash_generated_method = "98CA43884F8237670B8F04E14A16C221")
        
public void renumProviders() {
            Security.renumProviders();
        }

        //  Access to Security.getAliases()
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.397 -0500", hash_original_method = "F916F94BFF4DBDA09034B4A04EAFBC9D", hash_generated_method = "59164752619EAC7B05D87BEC4C4A614A")
        
public List<String> getAliases(Provider.Service s) {
            return s.getAliases();
        }

        // Access to Provider.getService()
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.400 -0500", hash_original_method = "413349B417A4FA3254048F8CD1980744", hash_generated_method = "9266514A9969EEA8B09CD18F6E208031")
        
public Provider.Service getService(Provider p, String type) {
            return p.getService(type);
        }

        
    }

    /**
     * This class can't be instantiated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.354 -0500", hash_original_method = "8A23448EE3E63F2FDD1EDADC770A872E", hash_generated_method = "4BBE606056C3BCB2A6E6D86FC214144D")
    
private Security() {
    }
    static {
        boolean loaded = false;
        try {
            InputStream configStream = Security.class.getResourceAsStream("security.properties");
            InputStream input = new BufferedInputStream(configStream);
            secprops.load(input);
            loaded = true;
            configStream.close();
        } catch (Exception ex) {
            System.logE("Could not load 'security.properties'", ex);
        }
        if (!loaded) {
            registerDefaultProviders();
        }
        Engine.door = new SecurityDoor();
    }
    
}

