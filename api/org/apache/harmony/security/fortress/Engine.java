package org.apache.harmony.security.fortress;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Locale;






public class Engine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.973 -0400", hash_original_field = "0F096338B64A1D1B348B86DF38313C01", hash_generated_field = "ECD50B84C78A208F5EC2C3BF804F2559")

    private String serviceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.973 -0400", hash_original_field = "6049F2C5AE61D726F719974704806FC4", hash_generated_field = "4B51C6823DCD96754807CD9362D07F8A")

    private volatile ServiceCacheEntry serviceCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.974 -0400", hash_original_method = "197C44846842D871388F9BC9DA5E7C36", hash_generated_method = "E075FDC3EE78D0EB2810A12FFECF67F0")
    public  Engine(String service) {
        this.serviceName = service;
        // ---------- Original Method ----------
        //this.serviceName = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.986 -0400", hash_original_method = "5C42DE2D9EE07142D674B5F3DD7E1F43", hash_generated_method = "CDE5426FCF8339C138FEB942CF6A0201")
    public SpiAndProvider getInstance(String algorithm, Object param) throws NoSuchAlgorithmException {
        addTaint(param.getTaint());
        if(algorithm == null)        
        {
            NoSuchAlgorithmException varB586576221ABA1FE807C4CEFF2CC23ED_563387912 = new NoSuchAlgorithmException("Null algorithm name");
            varB586576221ABA1FE807C4CEFF2CC23ED_563387912.addTaint(taint);
            throw varB586576221ABA1FE807C4CEFF2CC23ED_563387912;
        } //End block
        Services.refresh();
        Provider.Service service;
        ServiceCacheEntry cacheEntry = this.serviceCache;
        if(cacheEntry != null
                && cacheEntry.algorithm.equalsIgnoreCase(algorithm)
                && Services.refreshNumber == cacheEntry.refreshNumber)        
        {
            service = cacheEntry.service;
        } //End block
        else
        {
            if(Services.isEmpty())            
            {
                java.security.NoSuchAlgorithmException varA37EC1B235CB9F6F8CBFD29D43E4368F_1341222795 = notFound(serviceName, algorithm);
                varA37EC1B235CB9F6F8CBFD29D43E4368F_1341222795.addTaint(taint);
                throw varA37EC1B235CB9F6F8CBFD29D43E4368F_1341222795;
            } //End block
            String name = this.serviceName + "." + algorithm.toUpperCase(Locale.US);
            service = Services.getService(name);
            if(service == null)            
            {
                java.security.NoSuchAlgorithmException varA37EC1B235CB9F6F8CBFD29D43E4368F_197594486 = notFound(serviceName, algorithm);
                varA37EC1B235CB9F6F8CBFD29D43E4368F_197594486.addTaint(taint);
                throw varA37EC1B235CB9F6F8CBFD29D43E4368F_197594486;
            } //End block
            this.serviceCache = new ServiceCacheEntry(algorithm, Services.refreshNumber, service);
        } //End block
SpiAndProvider var4FD37FCABA311ED3E9B8D1F9B44E3BE2_2041609979 =         new SpiAndProvider(service.newInstance(param), service.getProvider());
        var4FD37FCABA311ED3E9B8D1F9B44E3BE2_2041609979.addTaint(taint);
        return var4FD37FCABA311ED3E9B8D1F9B44E3BE2_2041609979;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.994 -0400", hash_original_method = "A7EA60582CEFDE50341F39C3F4FF4289", hash_generated_method = "036B2F2F38E7993F6F785C1ACFD5BABF")
    public Object getInstance(String algorithm, Provider provider, Object param) throws NoSuchAlgorithmException {
        addTaint(param.getTaint());
        addTaint(provider.getTaint());
        addTaint(algorithm.getTaint());
        if(algorithm == null)        
        {
            NoSuchAlgorithmException var32ECACFEC41D346E1F3A3A94950FDF34_1029352429 = new NoSuchAlgorithmException("algorithm == null");
            var32ECACFEC41D346E1F3A3A94950FDF34_1029352429.addTaint(taint);
            throw var32ECACFEC41D346E1F3A3A94950FDF34_1029352429;
        } //End block
        Provider.Service service = provider.getService(serviceName, algorithm);
        if(service == null)        
        {
            java.security.NoSuchAlgorithmException varA37EC1B235CB9F6F8CBFD29D43E4368F_710463324 = notFound(serviceName, algorithm);
            varA37EC1B235CB9F6F8CBFD29D43E4368F_710463324.addTaint(taint);
            throw varA37EC1B235CB9F6F8CBFD29D43E4368F_710463324;
        } //End block
Object var67C46C91EC95982FAA7F5AAD7A93F0B2_2042620629 =         service.newInstance(param);
        var67C46C91EC95982FAA7F5AAD7A93F0B2_2042620629.addTaint(taint);
        return var67C46C91EC95982FAA7F5AAD7A93F0B2_2042620629;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.995 -0400", hash_original_method = "30EA070B5875ADB1FAA05CA3F6CF14E2", hash_generated_method = "FDCD91660543249FDE9DF45FED50288D")
    private NoSuchAlgorithmException notFound(String serviceName, String algorithm) throws NoSuchAlgorithmException {
        addTaint(algorithm.getTaint());
        addTaint(serviceName.getTaint());
        NoSuchAlgorithmException var418B58AF9CAEF0477030DA365F382308_1657909179 = new NoSuchAlgorithmException(serviceName + " " + algorithm
                                           + " implementation not found");
        var418B58AF9CAEF0477030DA365F382308_1657909179.addTaint(taint);
        throw var418B58AF9CAEF0477030DA365F382308_1657909179;
        // ---------- Original Method ----------
        //throw new NoSuchAlgorithmException(serviceName + " " + algorithm
                                           //+ " implementation not found");
    }

    
    private static final class ServiceCacheEntry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.995 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

        private String algorithm;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.995 -0400", hash_original_field = "AC654EA2C38C36DB419C7C9810BCAA8E", hash_generated_field = "0D6A293E465C82C3661A6F3B9697F00E")

        private int refreshNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.995 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "8FB8AE8FEDEF3FE7920B87D695E1FECA")

        private Provider.Service service;
        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.996 -0400", hash_original_method = "CED34B656EC03ABCC50FF9454F3ADD00", hash_generated_method = "8800597E2F5F372C2DD11E854A6A0F47")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.996 -0400", hash_original_field = "0B0760E072413088EA8460C3B4F43DBE", hash_generated_field = "3C7DCE9DB87EFC046EAD4A2C44081C3E")

        public Object spi;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.997 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "FF85ECC0EC4D5C16081B8E608A6B7EBB")

        public Provider provider;
        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.997 -0400", hash_original_method = "CD98A36834DFC76460E887FD6F06A4ED", hash_generated_method = "20BDD65E0BE5E0F91615EFB5B93DE53F")
        private  SpiAndProvider(Object spi, Provider provider) {
            this.spi = spi;
            this.provider = provider;
            // ---------- Original Method ----------
            //this.spi = spi;
            //this.provider = provider;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.997 -0400", hash_original_field = "2FEAAF89C21770EA5C21196BC33848DD", hash_generated_field = "CA6B0B1BB271255872AE24F4B60049E7")

    public static SecurityAccess door;
}

