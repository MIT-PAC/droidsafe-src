package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.572 -0400", hash_original_method = "8A23448EE3E63F2FDD1EDADC770A872E", hash_generated_method = "F38A362CCE128359797141D3F83E6272")
    @DSModeled(DSC.SAFE)
    private Security() {
        // ---------- Original Method ----------
    }

    
        private static void registerDefaultProviders() {
        secprops.put("security.provider.1", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider");
        secprops.put("security.provider.2", "org.apache.harmony.security.provider.cert.DRLCertFactory");
        secprops.put("security.provider.3", "org.bouncycastle.jce.provider.BouncyCastleProvider");
        secprops.put("security.provider.4", "org.apache.harmony.security.provider.crypto.CryptoProvider");
        secprops.put("security.provider.5", "org.apache.harmony.xnet.provider.jsse.JSSEProvider");
    }

    
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

    
        public static synchronized int insertProviderAt(Provider provider, int position) {
        if (getProvider(provider.getName()) != null) {
            return -1;
        }
        int result = Services.insertProviderAt(provider, position);
        renumProviders();
        return result;
    }

    
        public static int addProvider(Provider provider) {
        return insertProviderAt(provider, 0);
    }

    
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

    
        public static synchronized Provider[] getProviders() {
        return Services.getProviders();
    }

    
        public static synchronized Provider getProvider(String name) {
        return Services.getProvider(name);
    }

    
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

    
        public static void setProperty(String key, String value) {
        secprops.put(key, value);
    }

    
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

    
        private static void renumProviders() {
        Provider[] p = Services.getProviders();
        for (int i = 0; i < p.length; i++) {
            p[i].setProviderNumber(i + 1);
        }
    }

    
    private static class SecurityDoor implements SecurityAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.574 -0400", hash_original_method = "D558591B35D6F110570699A2CDF3FFEA", hash_generated_method = "D558591B35D6F110570699A2CDF3FFEA")
                public SecurityDoor ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.574 -0400", hash_original_method = "CC38396CF5E2C0D8624B241063796894", hash_generated_method = "CB29F99BA7A9E1FCCA38171345383D55")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void renumProviders() {
            Security.renumProviders();
            // ---------- Original Method ----------
            //Security.renumProviders();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.575 -0400", hash_original_method = "F916F94BFF4DBDA09034B4A04EAFBC9D", hash_generated_method = "EB3BFB6707A4E9D9E7203C28FE732CF8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<String> getAliases(Provider.Service s) {
            dsTaint.addTaint(s.dsTaint);
            List<String> var64BD6CD0E1E7BDE1E8C1790E5917E0BB_998204001 = (s.getAliases());
            return (List<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return s.getAliases();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.575 -0400", hash_original_method = "413349B417A4FA3254048F8CD1980744", hash_generated_method = "5EF678F4421063B8E595E4E765F16000")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Provider.Service getService(Provider p, String type) {
            dsTaint.addTaint(p.dsTaint);
            dsTaint.addTaint(type);
            Provider.Service varBD0332EDDD32DEC33437A69993FB6616_1432273955 = (p.getService(type));
            return (Provider.Service)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return p.getService(type);
        }

        
    }


    
    private static final Properties secprops = new Properties();
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

