package org.apache.harmony.security.fortress;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Locale;

public class Engine {
    public static SecurityAccess door;
    private final String serviceName;
    private volatile ServiceCacheEntry serviceCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.725 -0400", hash_original_method = "197C44846842D871388F9BC9DA5E7C36", hash_generated_method = "71B1EBF56002F0893C099A6A2A776B18")
    @DSModeled(DSC.SAFE)
    public Engine(String service) {
        dsTaint.addTaint(service);
        // ---------- Original Method ----------
        //this.serviceName = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.725 -0400", hash_original_method = "5C42DE2D9EE07142D674B5F3DD7E1F43", hash_generated_method = "2F7C1816B56EF73311746525F9B60DB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpiAndProvider getInstance(String algorithm, Object param) throws NoSuchAlgorithmException {
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(algorithm);
        {
            throw new NoSuchAlgorithmException("Null algorithm name");
        } //End block
        Services.refresh();
        Provider.Service service;
        ServiceCacheEntry cacheEntry;
        cacheEntry = this.serviceCache;
        {
            boolean var0CDCB9A591697202B869361CAACA582F_509060495 = (cacheEntry != null
                && cacheEntry.algorithm.equalsIgnoreCase(algorithm)
                && Services.refreshNumber == cacheEntry.refreshNumber);
            {
                service = cacheEntry.service;
            } //End block
            {
                {
                    boolean var389040427F16F8BE8ECA38F38187B5F5_1244821210 = (Services.isEmpty());
                    {
                        throw notFound(serviceName, algorithm);
                    } //End block
                } //End collapsed parenthetic
                String name;
                name = this.serviceName + "." + algorithm.toUpperCase(Locale.US);
                service = Services.getService(name);
                {
                    throw notFound(serviceName, algorithm);
                } //End block
                this.serviceCache = new ServiceCacheEntry(algorithm, Services.refreshNumber, service);
            } //End block
        } //End collapsed parenthetic
        SpiAndProvider var24C4B5FECE54E54ABB8CBD26B4919D2A_1005610527 = (new SpiAndProvider(service.newInstance(param), service.getProvider()));
        return (SpiAndProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.725 -0400", hash_original_method = "A7EA60582CEFDE50341F39C3F4FF4289", hash_generated_method = "F0F37B077416300C4B41F04BE9E804BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getInstance(String algorithm, Provider provider, Object param) throws NoSuchAlgorithmException {
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(algorithm);
        {
            throw new NoSuchAlgorithmException("algorithm == null");
        } //End block
        Provider.Service service;
        service = provider.getService(serviceName, algorithm);
        {
            throw notFound(serviceName, algorithm);
        } //End block
        Object var6243DD2A90C89292CC28F00D2FB799DF_1718387086 = (service.newInstance(param));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.725 -0400", hash_original_method = "30EA070B5875ADB1FAA05CA3F6CF14E2", hash_generated_method = "8A2D3841789E29D0D514B17134051197")
    @DSModeled(DSC.SAFE)
    private NoSuchAlgorithmException notFound(String serviceName, String algorithm) throws NoSuchAlgorithmException {
        dsTaint.addTaint(serviceName);
        dsTaint.addTaint(algorithm);
        throw new NoSuchAlgorithmException(serviceName + " " + algorithm
                                           + " implementation not found");
        return (NoSuchAlgorithmException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new NoSuchAlgorithmException(serviceName + " " + algorithm
                                           //+ " implementation not found");
    }

    
    private static final class ServiceCacheEntry {
        private final String algorithm;
        private final int refreshNumber;
        private final Provider.Service service;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.725 -0400", hash_original_method = "CED34B656EC03ABCC50FF9454F3ADD00", hash_generated_method = "905927A6540E4DE2956E3CDD50D0C751")
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
        public final Object spi;
        public final Provider provider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.725 -0400", hash_original_method = "CD98A36834DFC76460E887FD6F06A4ED", hash_generated_method = "DAE21325BCDE7E91D97DF1941696D8E7")
        @DSModeled(DSC.SAFE)
        private SpiAndProvider(Object spi, Provider provider) {
            dsTaint.addTaint(spi.dsTaint);
            dsTaint.addTaint(provider.dsTaint);
            // ---------- Original Method ----------
            //this.spi = spi;
            //this.provider = provider;
        }

        
    }


    
}


