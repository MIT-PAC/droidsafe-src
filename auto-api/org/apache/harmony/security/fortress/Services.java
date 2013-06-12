package org.apache.harmony.security.fortress;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Services {
    private static final Map<String, Provider.Service> services
            = new HashMap<String, Provider.Service>(600);
    private static Provider.Service secureRandom;
    private static boolean needRefresh;
    static int refreshNumber = 1;
    private static final List<Provider> providers = new ArrayList<Provider>(20);
    private static final Map<String, Provider> providersNames = new HashMap<String, Provider>(20);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "A097B975FD6850E0E629F1529E455924", hash_generated_method = "AA2014814BB3E488B3277B610CDC2FA2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "316A561AC6A6B1BE39036A1BA836B78A", hash_generated_method = "AB42ED3D2A856B9D6A3D21F7F01825F6")
    public static Provider[] getProviders() {
        return providers.toArray(new Provider[providers.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "E9F15408456B4B906E1451AF6A460DE1", hash_generated_method = "43FB744537E358777386D316C4A40FAB")
    public static List<Provider> getProvidersList() {
        return new ArrayList<Provider>(providers);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "3B239853BF5B7759ACB9C53292AFCEB4", hash_generated_method = "59DF82634FC8DCAA263D93F71F68ED7A")
    public static Provider getProvider(String name) {
        if (name == null) {
            return null;
        }
        return providersNames.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "C8AEE2334DE35BDFE5D79AEDA5278F3C", hash_generated_method = "BDF4F0688E667E5C086C2E6206CF07DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "9DC9E7F19092F975814277CEE7D0B356", hash_generated_method = "47D90D1B1F0565973BF670BC40A86F0C")
    public static void removeProvider(int providerNumber) {
        Provider p = providers.remove(providerNumber - 1);
        providersNames.remove(p.getName());
        setNeedRefresh();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "629F9E9D083C69E26E5C0357350415B2", hash_generated_method = "291727BD3F0B05D608031EFD37FB6747")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "63564401D8DE1BF0CEC677D15FBBF9A5", hash_generated_method = "692223D80A796C2996D58C245BCA1BF9")
    public static void updateServiceInfo() {
        services.clear();
        secureRandom = null;
        for (Provider p : providers) {
            initServiceInfo(p);
        }
        needRefresh = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "E0918E1CCE46EAB77CA0EFD0695D4743", hash_generated_method = "92548A7D12DC9B0114D1C1689B9DEA99")
    public static boolean isEmpty() {
        return services.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "A3BAA81CA1B47488F96363BDB013EB16", hash_generated_method = "CB0DB0CD40693FF69E548751890D6072")
    public static Provider.Service getService(String key) {
        return services.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "6C1E5FD74D6C9D91C3640B2B8F4D6C1E", hash_generated_method = "E8C013763F084D4F887555A0F3F3797B")
    public static Provider.Service getSecureRandomService() {
        return secureRandom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "73DA647E607F22F0677A1E09C083B188", hash_generated_method = "53E595C591FCA2EC75B25BF83AB90207")
    public static void setNeedRefresh() {
        needRefresh = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.734 -0400", hash_original_method = "41E781585F5EF3A93F8FE051E438DFA6", hash_generated_method = "71A4764486C7D6EA74D91BA9F31D39F0")
    public static void refresh() {
        if (needRefresh) {
            refreshNumber++;
            updateServiceInfo();
        }
    }

    
    static {
        loadProviders();
    }
    
}


