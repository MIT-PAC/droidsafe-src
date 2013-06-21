package org.apache.harmony.security.fortress;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Services {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.153 -0400", hash_original_method = "50089DF9D1EF1626BDC5CE9399B6E987", hash_generated_method = "50089DF9D1EF1626BDC5CE9399B6E987")
        public Services ()
    {
    }


        private static void loadProviders() {
        String providerClassName = null;
        int i = 1;
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Provider p;
        while ((providerClassName = Security.getProperty("security.provider."
                + i++)) != null) {
            try {
                p = (Provider) Class
                        .forName(providerClassName.trim(), true, cl)
                        .newInstance();
                providers.add(p);
                providersNames.put(p.getName(), p);
                initServiceInfo(p);
            } catch (ClassNotFoundException e) { 
            } catch (IllegalAccessException e) {
            } catch (InstantiationException e) {
            }
        }
        Engine.door.renumProviders();
    }

    
        public static Provider[] getProviders() {
        return providers.toArray(new Provider[providers.size()]);
    }

    
        public static List<Provider> getProvidersList() {
        return new ArrayList<Provider>(providers);
    }

    
        public static Provider getProvider(String name) {
        if (name == null) {
            return null;
        }
        return providersNames.get(name);
    }

    
        public static int insertProviderAt(Provider provider, int position) {
        int size = providers.size();
        if ((position < 1) || (position > size)) {
            position = size + 1;
        }
        providers.add(position - 1, provider);
        providersNames.put(provider.getName(), provider);
        setNeedRefresh();
        return position;
    }

    
        public static void removeProvider(int providerNumber) {
        Provider p = providers.remove(providerNumber - 1);
        providersNames.remove(p.getName());
        setNeedRefresh();
    }

    
        public static void initServiceInfo(Provider p) {
        for (Provider.Service serv : p.getServices()) {
            String type = serv.getType();
            if (secureRandom == null && type.equals("SecureRandom")) {
                secureRandom = serv;
            }
            String key = type + "." + serv.getAlgorithm().toUpperCase(Locale.US);
            if (!services.containsKey(key)) {
                services.put(key, serv);
            }
            for (String alias : Engine.door.getAliases(serv)) {
                key = type + "." + alias.toUpperCase(Locale.US);
                if (!services.containsKey(key)) {
                    services.put(key, serv);
                }
            }
        }
    }

    
        public static void updateServiceInfo() {
        services.clear();
        secureRandom = null;
        for (Provider p : providers) {
            initServiceInfo(p);
        }
        needRefresh = false;
    }

    
        public static boolean isEmpty() {
        return services.isEmpty();
    }

    
        public static Provider.Service getService(String key) {
        return services.get(key);
    }

    
        public static Provider.Service getSecureRandomService() {
        return secureRandom;
    }

    
        public static void setNeedRefresh() {
        needRefresh = true;
    }

    
        public static void refresh() {
        if (needRefresh) {
            refreshNumber++;
            updateServiceInfo();
        }
    }

    
    private static final Map<String, Provider.Service> services
            = new HashMap<String, Provider.Service>(600);
    private static Provider.Service secureRandom;
    private static boolean needRefresh;
    static int refreshNumber = 1;
    private static final List<Provider> providers = new ArrayList<Provider>(20);
    private static final Map<String, Provider> providersNames = new HashMap<String, Provider>(20);
    static {
        loadProviders();
    }
    
}

