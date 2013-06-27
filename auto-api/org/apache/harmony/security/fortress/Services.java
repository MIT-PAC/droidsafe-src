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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.808 -0400", hash_original_method = "719D73AD00F3F6FC30282996B569C5B0", hash_generated_method = "719D73AD00F3F6FC30282996B569C5B0")
    public Services ()
    {
        //Synthesized constructor
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.811 -0400", hash_original_field = "D8D0A2D1EC47DC8C7B79D750C2B9003F", hash_generated_field = "DAD4B33634B1E56CA324C20814E8951D")

    private static Map<String, Provider.Service> services = new HashMap<String, Provider.Service>(600);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.811 -0400", hash_original_field = "7A369DC18E63D8C3EA510B9B660A072D", hash_generated_field = "26B31BC298C6961DC97AEDA887767040")

    private static Provider.Service secureRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.811 -0400", hash_original_field = "BF6A04D9D455D227547E0462114A9DDA", hash_generated_field = "C6172C74BF02D5F0ECE4932F6F8B1A6B")

    private static boolean needRefresh;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.811 -0400", hash_original_field = "BFABA1F9DDCCD1015B660402467D46E3", hash_generated_field = "3C3CAE17DC7A09A348AAAF9335F2BAEB")

    static int refreshNumber = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.811 -0400", hash_original_field = "8FD27C6FD4C1AB33EB50B652D92371E9", hash_generated_field = "76B7954D486A636F03D68A7F04984DB0")

    private static List<Provider> providers = new ArrayList<Provider>(20);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.811 -0400", hash_original_field = "F2254891D7AEE8429397AAC3863B565A", hash_generated_field = "2358ACAC4A17A7DEE17CA2F886A9A827")

    private static Map<String, Provider> providersNames = new HashMap<String, Provider>(20);
    static {
        loadProviders();
    }
    
}

