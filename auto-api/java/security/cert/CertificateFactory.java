package java.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.harmony.security.fortress.Engine;

public class CertificateFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.978 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.978 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "B931F49514C7C80BDCB99D7936A2923D")

    private CertificateFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.978 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.979 -0400", hash_original_method = "8F22BB9FD67741B57F6E16F313DC406A", hash_generated_method = "48FF456B73A12C26B39567DE9F0035F0")
    protected  CertificateFactory(CertificateFactorySpi certFacSpi,
            Provider provider, String type) {
        this.provider = provider;
        this.type = type;
        this.spiImpl = certFacSpi;
        
        
        
        
    }

    
    public static final CertificateFactory getInstance(String type) throws CertificateException {
        if (type == null) {
            throw new NullPointerException();
        }
        try {
            Engine.SpiAndProvider sap = ENGINE.getInstance(type, null);
            return new CertificateFactory((CertificateFactorySpi) sap.spi, sap.provider, type);
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }

    
    public static final CertificateFactory getInstance(String type,
            String provider) throws CertificateException,
            NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(type, impProvider);
    }

    
    public static final CertificateFactory getInstance(String type,
            Provider provider) throws CertificateException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (type == null) {
            throw new NullPointerException();
        }
        try {
            Object spi = ENGINE.getInstance(type, provider, null);
            return new CertificateFactory((CertificateFactorySpi) spi, provider, type);
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.980 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "BF3FCA2386E1595B7EC9C61AFA8565DD")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_882657948 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_882657948 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_882657948.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_882657948;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.981 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "146EB617906CFF860C7977704A25AED8")
    public final String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_959007713 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_959007713 = type;
        varB4EAC82CA7396A68D541C85D26508E83_959007713.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_959007713;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.981 -0400", hash_original_method = "056686B78E96E8E09F6472D6283D322E", hash_generated_method = "567AA2B30476503319F4BF65F8C794D4")
    public final Certificate generateCertificate(InputStream inStream) throws CertificateException {
        Certificate varB4EAC82CA7396A68D541C85D26508E83_338330654 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_338330654 = spiImpl.engineGenerateCertificate(inStream);
        addTaint(inStream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_338330654.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_338330654;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.981 -0400", hash_original_method = "E0154FCC8B9DF343492D74548A8DABBF", hash_generated_method = "3018EB6449FDBA282F98D769109DED55")
    public final Iterator<String> getCertPathEncodings() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1526752891 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1526752891 = spiImpl.engineGetCertPathEncodings();
        varB4EAC82CA7396A68D541C85D26508E83_1526752891.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1526752891;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.982 -0400", hash_original_method = "3A334BAABFC8F8F07B1C887BAAF7ABEE", hash_generated_method = "7884CE1DE4E99F792C1CB79146741DCB")
    public final CertPath generateCertPath(InputStream inStream) throws CertificateException {
        CertPath varB4EAC82CA7396A68D541C85D26508E83_1788823223 = null; 
        Iterator<String> it = getCertPathEncodings();
        {
            boolean varF026B59EDDFD91F5680511797C117EE1_330058300 = (!it.hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateException("There are no CertPath encodings");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1788823223 = spiImpl.engineGenerateCertPath(inStream, it.next());
        addTaint(inStream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1788823223.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1788823223;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.982 -0400", hash_original_method = "2B5CC92C0290261B5C7A25A0F691CEF6", hash_generated_method = "B03DA44328F1BA6E32EFB31E4238BB11")
    public final CertPath generateCertPath(InputStream inStream, String encoding) throws CertificateException {
        CertPath varB4EAC82CA7396A68D541C85D26508E83_1169190631 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1169190631 = spiImpl.engineGenerateCertPath(inStream, encoding);
        addTaint(inStream.getTaint());
        addTaint(encoding.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1169190631.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1169190631;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.983 -0400", hash_original_method = "FE6370346FB92E14C140A17484E61066", hash_generated_method = "2BC5271628A7CF1280C69FAED6C98CBB")
    public final CertPath generateCertPath(List<? extends Certificate> certificates) throws CertificateException {
        CertPath varB4EAC82CA7396A68D541C85D26508E83_943034751 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_943034751 = spiImpl.engineGenerateCertPath(certificates);
        addTaint(certificates.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_943034751.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_943034751;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.983 -0400", hash_original_method = "2C42C184C3EAF19809C332EBF46CD8DC", hash_generated_method = "DC1608405A8F16BA25175E9C4F05D155")
    public final Collection<? extends Certificate> generateCertificates(InputStream inStream) throws CertificateException {
        Collection<? extends Certificate> varB4EAC82CA7396A68D541C85D26508E83_2001466826 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2001466826 = spiImpl.engineGenerateCertificates(inStream);
        addTaint(inStream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2001466826.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2001466826;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.984 -0400", hash_original_method = "61C041CED79E728E684417F700AE9F1B", hash_generated_method = "915FF73A0371542A4D30AFD79597B755")
    public final CRL generateCRL(InputStream inStream) throws CRLException {
        CRL varB4EAC82CA7396A68D541C85D26508E83_654290986 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_654290986 = spiImpl.engineGenerateCRL(inStream);
        addTaint(inStream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_654290986.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_654290986;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.984 -0400", hash_original_method = "82C17943BE49A882CA4049864C9D79C5", hash_generated_method = "B20D9802B4AAB887D3984F5C44809C7E")
    public final Collection<? extends CRL> generateCRLs(InputStream inStream) throws CRLException {
        Collection<? extends CRL> varB4EAC82CA7396A68D541C85D26508E83_1449872925 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1449872925 = spiImpl.engineGenerateCRLs(inStream);
        addTaint(inStream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1449872925.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1449872925;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.984 -0400", hash_original_field = "B841CBE76346F2F1B8808B92FE062632", hash_generated_field = "A66EAB910E2080B86DC151E0E257CE68")

    private static final String SERVICE = "CertificateFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.984 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
}

