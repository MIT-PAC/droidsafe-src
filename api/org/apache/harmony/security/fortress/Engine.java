package org.apache.harmony.security.fortress;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Locale;






public class Engine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.667 -0500", hash_original_field = "866C4AC448B39300A873F48EFF03F5C6", hash_generated_field = "CA6B0B1BB271255872AE24F4B60049E7")

    public static SecurityAccess door;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.668 -0500", hash_original_field = "CF2C80019C35D530635AF6206926FE84", hash_generated_field = "ECD50B84C78A208F5EC2C3BF804F2559")

    private  String serviceName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.669 -0500", hash_original_field = "D2658CCFF04D87D58F426AF3C0FFDFF7", hash_generated_field = "4B51C6823DCD96754807CD9362D07F8A")

    private volatile ServiceCacheEntry serviceCache;

    /**
     * Creates a Engine object
     *
     * @param service
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.678 -0500", hash_original_method = "197C44846842D871388F9BC9DA5E7C36", hash_generated_method = "0303D91AD47676114DDAFD5FB3C249B2")
    public Engine(String service) {
        this.serviceName = service;
    }

    /**
     * Finds the appropriate service implementation and returns an
     * {@code SpiAndProvider} instance containing a reference to SPI
     * and its {@code Provider}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.679 -0500", hash_original_method = "5C42DE2D9EE07142D674B5F3DD7E1F43", hash_generated_method = "50B65049CD843C3CE66D08A59FF54C88")
    public SpiAndProvider getInstance(String algorithm, Object param)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NoSuchAlgorithmException("Null algorithm name");
        }
        Services.refresh();
        Provider.Service service;
        ServiceCacheEntry cacheEntry = this.serviceCache;
        if (cacheEntry != null
                && cacheEntry.algorithm.equalsIgnoreCase(algorithm)
                && Services.refreshNumber == cacheEntry.refreshNumber) {
            service = cacheEntry.service;
        } else {
            if (Services.isEmpty()) {
                throw notFound(serviceName, algorithm);
            }
            String name = this.serviceName + "." + algorithm.toUpperCase(Locale.US);
            service = Services.getService(name);
            if (service == null) {
                throw notFound(serviceName, algorithm);
            }
            this.serviceCache = new ServiceCacheEntry(algorithm, Services.refreshNumber, service);
        }
        return new SpiAndProvider(service.newInstance(param), service.getProvider());
    }

    /**
     * Finds the appropriate service implementation and returns and
     * instance of the class that implements corresponding Service
     * Provider Interface.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.681 -0500", hash_original_method = "A7EA60582CEFDE50341F39C3F4FF4289", hash_generated_method = "EEDAEC110F992439486E97CEB5A34DB2")
    public Object getInstance(String algorithm, Provider provider, Object param)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NoSuchAlgorithmException("algorithm == null");
        }
        Provider.Service service = provider.getService(serviceName, algorithm);
        if (service == null) {
            throw notFound(serviceName, algorithm);
        }
        return service.newInstance(param);
    }

    
    private static final class ServiceCacheEntry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.670 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

        private  String algorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.671 -0500", hash_original_field = "1A2DADB3BB2ED384D63CD37810285BBE", hash_generated_field = "0D6A293E465C82C3661A6F3B9697F00E")

        private  int refreshNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.672 -0500", hash_original_field = "5E8CCC0A185FF45D24011DE5D23CA402", hash_generated_field = "8FB8AE8FEDEF3FE7920B87D695E1FECA")

        private  Provider.Service service;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.673 -0500", hash_original_method = "CED34B656EC03ABCC50FF9454F3ADD00", hash_generated_method = "597054526ACE3ED7B427A27E7D7CDA29")
        private ServiceCacheEntry(String algorithm,
                                  int refreshNumber,
                                  Provider.Service service) {
            this.algorithm = algorithm;
            this.refreshNumber = refreshNumber;
            this.service = service;
        }

        
    }


    
    public static final class SpiAndProvider {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.675 -0500", hash_original_field = "D0259A64FD3599D5A4C36FF7703885A7", hash_generated_field = "3C7DCE9DB87EFC046EAD4A2C44081C3E")

        public  Object spi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.676 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "FF85ECC0EC4D5C16081B8E608A6B7EBB")

        public  Provider provider;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.677 -0500", hash_original_method = "CD98A36834DFC76460E887FD6F06A4ED", hash_generated_method = "71A96CD316D3191AE4D95F2F8FC3863E")
        private SpiAndProvider(Object spi, Provider provider) {
            this.spi = spi;
            this.provider = provider;
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.681 -0500", hash_original_method = "30EA070B5875ADB1FAA05CA3F6CF14E2", hash_generated_method = "6BF0AB7B4E0177708388F98D2FD6AF14")
    private NoSuchAlgorithmException notFound(String serviceName, String algorithm)
            throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException(serviceName + " " + algorithm
                                           + " implementation not found");
    }
}

