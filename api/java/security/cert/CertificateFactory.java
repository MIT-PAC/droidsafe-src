package java.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.630 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.630 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "B931F49514C7C80BDCB99D7936A2923D")

    private CertificateFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.630 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.631 -0400", hash_original_method = "8F22BB9FD67741B57F6E16F313DC406A", hash_generated_method = "48FF456B73A12C26B39567DE9F0035F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.633 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "EBB779162D2B695A3C3876C4D7EEAD5F")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1399065265 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_1399065265.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1399065265;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.633 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "02EF14D84C4D2439B7EC58C82A248C73")
    public final String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_1911071621 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_1911071621.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_1911071621;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.633 -0400", hash_original_method = "056686B78E96E8E09F6472D6283D322E", hash_generated_method = "36D0C449A3E906FF11BD31E79A4458B6")
    public final Certificate generateCertificate(InputStream inStream) throws CertificateException {
        addTaint(inStream.getTaint());
Certificate var9F9D4B573DBE5D77E046560951546040_1481940148 =         spiImpl.engineGenerateCertificate(inStream);
        var9F9D4B573DBE5D77E046560951546040_1481940148.addTaint(taint);
        return var9F9D4B573DBE5D77E046560951546040_1481940148;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.634 -0400", hash_original_method = "E0154FCC8B9DF343492D74548A8DABBF", hash_generated_method = "7192B9E2DBEB1ECC32C7F5E9B4A45DFA")
    public final Iterator<String> getCertPathEncodings() {
Iterator<String> var6B27921EA9F87AED9ACC12772C0D7430_1432898254 =         spiImpl.engineGetCertPathEncodings();
        var6B27921EA9F87AED9ACC12772C0D7430_1432898254.addTaint(taint);
        return var6B27921EA9F87AED9ACC12772C0D7430_1432898254;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.634 -0400", hash_original_method = "3A334BAABFC8F8F07B1C887BAAF7ABEE", hash_generated_method = "767AF71897F1F992263BFE55022A4F60")
    public final CertPath generateCertPath(InputStream inStream) throws CertificateException {
        addTaint(inStream.getTaint());
        Iterator<String> it = getCertPathEncodings();
    if(!it.hasNext())        
        {
            CertificateException var3EA95212AA505588821FB2A800B429BB_376822806 = new CertificateException("There are no CertPath encodings");
            var3EA95212AA505588821FB2A800B429BB_376822806.addTaint(taint);
            throw var3EA95212AA505588821FB2A800B429BB_376822806;
        } 
CertPath varBDCFDEACCD25CA979BA744B7C1536D27_689098717 =         spiImpl.engineGenerateCertPath(inStream, it.next());
        varBDCFDEACCD25CA979BA744B7C1536D27_689098717.addTaint(taint);
        return varBDCFDEACCD25CA979BA744B7C1536D27_689098717;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.635 -0400", hash_original_method = "2B5CC92C0290261B5C7A25A0F691CEF6", hash_generated_method = "3A8EFA53F9A275943A030279F15DE0DF")
    public final CertPath generateCertPath(InputStream inStream, String encoding) throws CertificateException {
        addTaint(encoding.getTaint());
        addTaint(inStream.getTaint());
CertPath var228E9CE69491ED7827223E0008579F48_1107304655 =         spiImpl.engineGenerateCertPath(inStream, encoding);
        var228E9CE69491ED7827223E0008579F48_1107304655.addTaint(taint);
        return var228E9CE69491ED7827223E0008579F48_1107304655;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.635 -0400", hash_original_method = "FE6370346FB92E14C140A17484E61066", hash_generated_method = "B434778D5AFBA5B30C76BAB81A0A06D9")
    public final CertPath generateCertPath(List<? extends Certificate> certificates) throws CertificateException {
        addTaint(certificates.getTaint());
CertPath varA72F36A352F789B87B191E0E9CE9E911_266960480 =         spiImpl.engineGenerateCertPath(certificates);
        varA72F36A352F789B87B191E0E9CE9E911_266960480.addTaint(taint);
        return varA72F36A352F789B87B191E0E9CE9E911_266960480;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.635 -0400", hash_original_method = "2C42C184C3EAF19809C332EBF46CD8DC", hash_generated_method = "D936C8AE2645CD3B36BF25A218A7BD58")
    public final Collection<? extends Certificate> generateCertificates(InputStream inStream) throws CertificateException {
        addTaint(inStream.getTaint());
Collection<? extends Certificate> var93F857E0ABFD39144F430F52BB4EC83F_707838947 =         spiImpl.engineGenerateCertificates(inStream);
        var93F857E0ABFD39144F430F52BB4EC83F_707838947.addTaint(taint);
        return var93F857E0ABFD39144F430F52BB4EC83F_707838947;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.636 -0400", hash_original_method = "61C041CED79E728E684417F700AE9F1B", hash_generated_method = "3B6A10BCD0DAB1EAF9753551A1C1DEC0")
    public final CRL generateCRL(InputStream inStream) throws CRLException {
        addTaint(inStream.getTaint());
CRL var1223BE834767CB6064751A594C1B891F_1411807153 =         spiImpl.engineGenerateCRL(inStream);
        var1223BE834767CB6064751A594C1B891F_1411807153.addTaint(taint);
        return var1223BE834767CB6064751A594C1B891F_1411807153;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.636 -0400", hash_original_method = "82C17943BE49A882CA4049864C9D79C5", hash_generated_method = "D94E6943FF74DC44AEBA3020E2A5D571")
    public final Collection<? extends CRL> generateCRLs(InputStream inStream) throws CRLException {
        addTaint(inStream.getTaint());
Collection<? extends CRL> varD257CDECBBA0CF8F47B41179978125E2_43255335 =         spiImpl.engineGenerateCRLs(inStream);
        varD257CDECBBA0CF8F47B41179978125E2_43255335.addTaint(taint);
        return varD257CDECBBA0CF8F47B41179978125E2_43255335;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.636 -0400", hash_original_field = "B841CBE76346F2F1B8808B92FE062632", hash_generated_field = "A66EAB910E2080B86DC151E0E257CE68")

    private static final String SERVICE = "CertificateFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.636 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
}

