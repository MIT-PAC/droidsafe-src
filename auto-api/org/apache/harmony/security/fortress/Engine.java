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
    private String serviceName;
    private volatile ServiceCacheEntry serviceCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.134 -0400", hash_original_method = "197C44846842D871388F9BC9DA5E7C36", hash_generated_method = "EE866B4AED926408014D49E3C8C9C54B")
    @DSModeled(DSC.SAFE)
    public Engine(String service) {
        dsTaint.addTaint(service);
        // ---------- Original Method ----------
        //this.serviceName = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.135 -0400", hash_original_method = "5C42DE2D9EE07142D674B5F3DD7E1F43", hash_generated_method = "EEA9E65F7B3C1EBDA0395BCEA76785B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpiAndProvider getInstance(String algorithm, Object param) throws NoSuchAlgorithmException {
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(algorithm);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException("Null algorithm name");
        } //End block
        Services.refresh();
        Provider.Service service;
        ServiceCacheEntry cacheEntry;
        cacheEntry = this.serviceCache;
        {
            boolean var0CDCB9A591697202B869361CAACA582F_453704585 = (cacheEntry != null
                && cacheEntry.algorithm.equalsIgnoreCase(algorithm)
                && Services.refreshNumber == cacheEntry.refreshNumber);
            {
                service = cacheEntry.service;
            } //End block
            {
                {
                    boolean var389040427F16F8BE8ECA38F38187B5F5_512973865 = (Services.isEmpty());
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
        SpiAndProvider var24C4B5FECE54E54ABB8CBD26B4919D2A_1771970420 = (new SpiAndProvider(service.newInstance(param), service.getProvider()));
        return (SpiAndProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.135 -0400", hash_original_method = "A7EA60582CEFDE50341F39C3F4FF4289", hash_generated_method = "D9C035E84648DCB3038BFBFE45634169")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getInstance(String algorithm, Provider provider, Object param) throws NoSuchAlgorithmException {
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(algorithm);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException("algorithm == null");
        } //End block
        Provider.Service service;
        service = provider.getService(serviceName, algorithm);
        {
            if (DroidSafeAndroidRuntime.control) throw notFound(serviceName, algorithm);
        } //End block
        Object var6243DD2A90C89292CC28F00D2FB799DF_722122718 = (service.newInstance(param));
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.135 -0400", hash_original_method = "30EA070B5875ADB1FAA05CA3F6CF14E2", hash_generated_method = "056EE84EA5A8DD849DA82EFB3ED4024D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NoSuchAlgorithmException notFound(String serviceName, String algorithm) throws NoSuchAlgorithmException {
        dsTaint.addTaint(algorithm);
        dsTaint.addTaint(serviceName);
        if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(serviceName + " " + algorithm
                                           + " implementation not found");
        return (NoSuchAlgorithmException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new NoSuchAlgorithmException(serviceName + " " + algorithm
                                           //+ " implementation not found");
    }

    
    private static final class ServiceCacheEntry {
        private String algorithm;
        private int refreshNumber;
        private Provider.Service service;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.136 -0400", hash_original_method = "CED34B656EC03ABCC50FF9454F3ADD00", hash_generated_method = "9CB4A7314EFBD298672E5C5CBB1E036C")
        @DSModeled(DSC.SAFE)
        private ServiceCacheEntry(String algorithm,
                                  int refreshNumber,
                                  Provider.Service service) {
            dsTaint.addTaint(refreshNumber);
            dsTaint.addTaint(service.dsTaint);
            dsTaint.addTaint(algorithm);
            // ---------- Original Method ----------
            //this.algorithm = algorithm;
            //this.refreshNumber = refreshNumber;
            //this.service = service;
        }

        
    }


    
    public static final class SpiAndProvider {
        public Object spi;
        public Provider provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.136 -0400", hash_original_method = "CD98A36834DFC76460E887FD6F06A4ED", hash_generated_method = "B0D76E96EC26B2E7A66E1DE3CA1A98E3")
        @DSModeled(DSC.SAFE)
        private SpiAndProvider(Object spi, Provider provider) {
            dsTaint.addTaint(spi.dsTaint);
            dsTaint.addTaint(provider.dsTaint);
            // ---------- Original Method ----------
            //this.spi = spi;
            //this.provider = provider;
        }

        
    }


    
    public static SecurityAccess door;
}

