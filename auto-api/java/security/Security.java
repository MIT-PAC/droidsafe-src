package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
    private static final Properties secprops = new Properties();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.720 -0400", hash_original_method = "8A23448EE3E63F2FDD1EDADC770A872E", hash_generated_method = "B89A2AE6CD021A2638E89A202AD9D906")
    @DSModeled(DSC.SAFE)
    private Security() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.720 -0400", hash_original_method = "4FF6FA341ED545BB45EA708ED46D5EA7", hash_generated_method = "B9FBDF6F317E6E4AE7796420935CF81D")
    private static void registerDefaultProviders() {
        secprops.put("security.provider.1", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider");
        secprops.put("security.provider.2", "org.apache.harmony.security.provider.cert.DRLCertFactory");
        secprops.put("security.provider.3", "org.bouncycastle.jce.provider.BouncyCastleProvider");
        secprops.put("security.provider.4", "org.apache.harmony.security.provider.crypto.CryptoProvider");
        secprops.put("security.provider.5", "org.apache.harmony.xnet.provider.jsse.JSSEProvider");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.720 -0400", hash_original_method = "D3DABD5C1A3E4046B634B4ABE7B41DC8", hash_generated_method = "348187D66E3458F2A5A813E68314E45F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.720 -0400", hash_original_method = "67AE1CD5DCFCA41946EBB236A4A63A0E", hash_generated_method = "FCA850A31149C054E117F749A9B56F81")
    public static synchronized int insertProviderAt(Provider provider, int position) {
        if (getProvider(provider.getName()) != null) {
            return -1;
        }
        int result = Services.insertProviderAt(provider, position);
        renumProviders();
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.720 -0400", hash_original_method = "E56D0C14EE73394DE8439EEF0879315D", hash_generated_method = "7FE6810E7DCDA05798504F90847EBF2F")
    public static int addProvider(Provider provider) {
        return insertProviderAt(provider, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.720 -0400", hash_original_method = "B96A90ADCC337AF873B627F27B354B02", hash_generated_method = "881E33304B3731A927725E56825ABCB9")
    public static synchronized void removeProvider(String name) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.720 -0400", hash_original_method = "EAE9285B08BB32BE2AF6653E79C9F615", hash_generated_method = "ED0B530D59AB27614637C6D2551CDFE9")
    public static synchronized Provider[] getProviders() {
        return Services.getProviders();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.720 -0400", hash_original_method = "129A779E3BBD24BC13650E637FDCE401", hash_generated_method = "FF9D7A73DBD193463FD11FA473E485B0")
    public static synchronized Provider getProvider(String name) {
        return Services.getProvider(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.720 -0400", hash_original_method = "F6138CDF14D8D5962F697D1DAE8ACD56", hash_generated_method = "55A03477641E49547C5C0296E5D3979B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.720 -0400", hash_original_method = "68DDE2F39160A5938C8ECA7BA32376CA", hash_generated_method = "F1C285F01EEAD4C34177D9F501DBCE55")
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
            if (i == -1) { 
                if (val.length() != 0) {
                    throw new InvalidParameterException();
                }
            } else { 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.720 -0400", hash_original_method = "FBE94713485830A30BBD5079D4570A8E", hash_generated_method = "C17246BF3337C7E14B654907595AA70A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.721 -0400", hash_original_method = "E9A275F23060DA3D5E42FE19B6245D55", hash_generated_method = "EE34367337CA9748B635C6659AE4E420")
    public static void setProperty(String key, String value) {
        secprops.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.721 -0400", hash_original_method = "D678C323A21AFC9C219F4C1FB9E8266D", hash_generated_method = "421F12F80D2C853CCDBAC89A19BC726F")
    public static Set<String> getAlgorithms(String serviceName) {
        Set<String> result = new HashSet<String>();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.721 -0400", hash_original_method = "36CAA565E766988B673C74F846171C19", hash_generated_method = "92D0B4BBA24621AE273B53B31014859B")
    private static void renumProviders() {
        Provider[] p = Services.getProviders();
        for (int i = 0; i < p.length; i++) {
            p[i].setProviderNumber(i + 1);
        }
    }

    
    private static class SecurityDoor implements SecurityAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.721 -0400", hash_original_method = "CC38396CF5E2C0D8624B241063796894", hash_generated_method = "2313BEC6F98273A24C79AA6D46A0E38A")
        @DSModeled(DSC.SAFE)
        public void renumProviders() {
            Security.renumProviders();
            // ---------- Original Method ----------
            //Security.renumProviders();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.721 -0400", hash_original_method = "F916F94BFF4DBDA09034B4A04EAFBC9D", hash_generated_method = "BA19F8CDD60089FB07D5BFC09A4B346F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<String> getAliases(Provider.Service s) {
            dsTaint.addTaint(s.dsTaint);
            List<String> var64BD6CD0E1E7BDE1E8C1790E5917E0BB_878866254 = (s.getAliases());
            return (List<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return s.getAliases();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.721 -0400", hash_original_method = "413349B417A4FA3254048F8CD1980744", hash_generated_method = "2617D5BBBC260ECDFD11E51A15776841")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Provider.Service getService(Provider p, String type) {
            dsTaint.addTaint(p.dsTaint);
            dsTaint.addTaint(type);
            Provider.Service varBD0332EDDD32DEC33437A69993FB6616_2087210078 = (p.getService(type));
            return (Provider.Service)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return p.getService(type);
        }

        
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


