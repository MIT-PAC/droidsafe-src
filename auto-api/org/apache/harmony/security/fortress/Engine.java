package org.apache.harmony.security.fortress;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Locale;

public class Engine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.677 -0400", hash_original_field = "0F096338B64A1D1B348B86DF38313C01", hash_generated_field = "ECD50B84C78A208F5EC2C3BF804F2559")

    private String serviceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.677 -0400", hash_original_field = "6049F2C5AE61D726F719974704806FC4", hash_generated_field = "4B51C6823DCD96754807CD9362D07F8A")

    private volatile ServiceCacheEntry serviceCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.678 -0400", hash_original_method = "197C44846842D871388F9BC9DA5E7C36", hash_generated_method = "E075FDC3EE78D0EB2810A12FFECF67F0")
    public  Engine(String service) {
        this.serviceName = service;
        // ---------- Original Method ----------
        //this.serviceName = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.679 -0400", hash_original_method = "5C42DE2D9EE07142D674B5F3DD7E1F43", hash_generated_method = "1E8C821E10A9C7A1391D29A7581645F8")
    public SpiAndProvider getInstance(String algorithm, Object param) throws NoSuchAlgorithmException {
        SpiAndProvider varB4EAC82CA7396A68D541C85D26508E83_2116856556 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException("Null algorithm name");
        } //End block
        Services.refresh();
        Provider.Service service;
        ServiceCacheEntry cacheEntry;
        cacheEntry = this.serviceCache;
        {
            boolean var0CDCB9A591697202B869361CAACA582F_299541803 = (cacheEntry != null
                && cacheEntry.algorithm.equalsIgnoreCase(algorithm)
                && Services.refreshNumber == cacheEntry.refreshNumber);
            {
                service = cacheEntry.service;
            } //End block
            {
                {
                    boolean var389040427F16F8BE8ECA38F38187B5F5_1168339665 = (Services.isEmpty());
                    {
                        if (DroidSafeAndroidRuntime.control) throw notFound(serviceName, algorithm);
                    } //End block
                } //End collapsed parenthetic
                String name;
                name = this.serviceName + "." + algorithm.toUpperCase(Locale.US);
                service = Services.getService(name);
                {
                    if (DroidSafeAndroidRuntime.control) throw notFound(serviceName, algorithm);
                } //End block
                this.serviceCache = new ServiceCacheEntry(algorithm, Services.refreshNumber, service);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2116856556 = new SpiAndProvider(service.newInstance(param), service.getProvider());
        addTaint(param.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2116856556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2116856556;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.688 -0400", hash_original_method = "A7EA60582CEFDE50341F39C3F4FF4289", hash_generated_method = "B75734EE3BBB641540847F1A449350EF")
    public Object getInstance(String algorithm, Provider provider, Object param) throws NoSuchAlgorithmException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1978339516 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException("algorithm == null");
        } //End block
        Provider.Service service;
        service = provider.getService(serviceName, algorithm);
        {
            if (DroidSafeAndroidRuntime.control) throw notFound(serviceName, algorithm);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1978339516 = service.newInstance(param);
        addTaint(algorithm.getTaint());
        addTaint(provider.getTaint());
        addTaint(param.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1978339516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1978339516;
        // ---------- Original Method ----------
        //if (algorithm == null) {
            //throw new NoSuchAlgorithmException("algorithm == null");
        //}
        //Provider.Service service = provider.getService(serviceName, algorithm);
        //if (service == null) {
            //throw notFound(serviceName, algorithm);
        //}
        //return service.newInstance(param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.689 -0400", hash_original_method = "30EA070B5875ADB1FAA05CA3F6CF14E2", hash_generated_method = "7422BC79848CB708CA056224AB168949")
    private NoSuchAlgorithmException notFound(String serviceName, String algorithm) throws NoSuchAlgorithmException {
        if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(serviceName + " " + algorithm
                                           + " implementation not found");
        addTaint(serviceName.getTaint());
        addTaint(algorithm.getTaint());
        // ---------- Original Method ----------
        //throw new NoSuchAlgorithmException(serviceName + " " + algorithm
                                           //+ " implementation not found");
    }

    
    private static final class ServiceCacheEntry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.689 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

        private String algorithm;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.690 -0400", hash_original_field = "AC654EA2C38C36DB419C7C9810BCAA8E", hash_generated_field = "0D6A293E465C82C3661A6F3B9697F00E")

        private int refreshNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.690 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "8FB8AE8FEDEF3FE7920B87D695E1FECA")

        private Provider.Service service;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.690 -0400", hash_original_method = "CED34B656EC03ABCC50FF9454F3ADD00", hash_generated_method = "8800597E2F5F372C2DD11E854A6A0F47")
        private  ServiceCacheEntry(String algorithm,
                                  int refreshNumber,
                                  Provider.Service service) {
            this.algorithm = algorithm;
            this.refreshNumber = refreshNumber;
            this.service = service;
            // ---------- Original Method ----------
            //this.algorithm = algorithm;
            //this.refreshNumber = refreshNumber;
            //this.service = service;
        }

        
    }


    
    public static final class SpiAndProvider {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.690 -0400", hash_original_field = "0B0760E072413088EA8460C3B4F43DBE", hash_generated_field = "3C7DCE9DB87EFC046EAD4A2C44081C3E")

        public Object spi;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.690 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "FF85ECC0EC4D5C16081B8E608A6B7EBB")

        public Provider provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.699 -0400", hash_original_method = "CD98A36834DFC76460E887FD6F06A4ED", hash_generated_method = "20BDD65E0BE5E0F91615EFB5B93DE53F")
        private  SpiAndProvider(Object spi, Provider provider) {
            this.spi = spi;
            this.provider = provider;
            // ---------- Original Method ----------
            //this.spi = spi;
            //this.provider = provider;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.699 -0400", hash_original_field = "2FEAAF89C21770EA5C21196BC33848DD", hash_generated_field = "CA6B0B1BB271255872AE24F4B60049E7")

    public static SecurityAccess door;
}

