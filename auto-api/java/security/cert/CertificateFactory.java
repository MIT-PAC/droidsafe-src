package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.491 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.491 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "B931F49514C7C80BDCB99D7936A2923D")

    private CertificateFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.491 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.491 -0400", hash_original_method = "8F22BB9FD67741B57F6E16F313DC406A", hash_generated_method = "48FF456B73A12C26B39567DE9F0035F0")
    protected  CertificateFactory(CertificateFactorySpi certFacSpi,
            Provider provider, String type) {
        this.provider = provider;
        this.type = type;
        this.spiImpl = certFacSpi;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.type = type;
        //this.spiImpl = certFacSpi;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.498 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "D89660CFFFDD2B89B20E664861FAE1A0")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_1542246719 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1542246719 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_1542246719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1542246719;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.498 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "2E68A0D35CD34CA0EC5AA0C4D94CFD17")
    public final String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_105555841 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_105555841 = type;
        varB4EAC82CA7396A68D541C85D26508E83_105555841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_105555841;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.503 -0400", hash_original_method = "056686B78E96E8E09F6472D6283D322E", hash_generated_method = "14624E7089FF31A1CA91FC16D1710599")
    public final Certificate generateCertificate(InputStream inStream) throws CertificateException {
        Certificate varB4EAC82CA7396A68D541C85D26508E83_450412377 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_450412377 = spiImpl.engineGenerateCertificate(inStream);
        addTaint(inStream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_450412377.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_450412377;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertificate(inStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.505 -0400", hash_original_method = "E0154FCC8B9DF343492D74548A8DABBF", hash_generated_method = "E79C836F990ECC4003DFBFB053186267")
    public final Iterator<String> getCertPathEncodings() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1039127452 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1039127452 = spiImpl.engineGetCertPathEncodings();
        varB4EAC82CA7396A68D541C85D26508E83_1039127452.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1039127452;
        // ---------- Original Method ----------
        //return spiImpl.engineGetCertPathEncodings();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.514 -0400", hash_original_method = "3A334BAABFC8F8F07B1C887BAAF7ABEE", hash_generated_method = "C9AD7D1F9D6F205DE7CC361527A63276")
    public final CertPath generateCertPath(InputStream inStream) throws CertificateException {
        CertPath varB4EAC82CA7396A68D541C85D26508E83_1569912201 = null; //Variable for return #1
        Iterator<String> it;
        it = getCertPathEncodings();
        {
            boolean varF026B59EDDFD91F5680511797C117EE1_2127777535 = (!it.hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateException("There are no CertPath encodings");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1569912201 = spiImpl.engineGenerateCertPath(inStream, it.next());
        addTaint(inStream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1569912201.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1569912201;
        // ---------- Original Method ----------
        //Iterator<String> it = getCertPathEncodings();
        //if (!it.hasNext()) {
            //throw new CertificateException("There are no CertPath encodings");
        //}
        //return spiImpl.engineGenerateCertPath(inStream, it.next());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.515 -0400", hash_original_method = "2B5CC92C0290261B5C7A25A0F691CEF6", hash_generated_method = "AAD9AD3E344EA4832699DC08FCC79DD5")
    public final CertPath generateCertPath(InputStream inStream, String encoding) throws CertificateException {
        CertPath varB4EAC82CA7396A68D541C85D26508E83_1981755242 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1981755242 = spiImpl.engineGenerateCertPath(inStream, encoding);
        addTaint(inStream.getTaint());
        addTaint(encoding.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1981755242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1981755242;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertPath(inStream, encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.523 -0400", hash_original_method = "FE6370346FB92E14C140A17484E61066", hash_generated_method = "D996C26D87921008B780321DDEC7FDD3")
    public final CertPath generateCertPath(List<? extends Certificate> certificates) throws CertificateException {
        CertPath varB4EAC82CA7396A68D541C85D26508E83_1583786534 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1583786534 = spiImpl.engineGenerateCertPath(certificates);
        addTaint(certificates.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1583786534.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1583786534;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertPath(certificates);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.524 -0400", hash_original_method = "2C42C184C3EAF19809C332EBF46CD8DC", hash_generated_method = "A906001D82FB2BD3279F475B93883182")
    public final Collection<? extends Certificate> generateCertificates(InputStream inStream) throws CertificateException {
        Collection<? extends Certificate> varB4EAC82CA7396A68D541C85D26508E83_1232279292 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1232279292 = spiImpl.engineGenerateCertificates(inStream);
        addTaint(inStream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1232279292.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1232279292;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertificates(inStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.524 -0400", hash_original_method = "61C041CED79E728E684417F700AE9F1B", hash_generated_method = "93109F3F26F8CA09967221DA2718119E")
    public final CRL generateCRL(InputStream inStream) throws CRLException {
        CRL varB4EAC82CA7396A68D541C85D26508E83_1999473536 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1999473536 = spiImpl.engineGenerateCRL(inStream);
        addTaint(inStream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1999473536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1999473536;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCRL(inStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.529 -0400", hash_original_method = "82C17943BE49A882CA4049864C9D79C5", hash_generated_method = "12524E7462B665CBA77268B3AA4B2198")
    public final Collection<? extends CRL> generateCRLs(InputStream inStream) throws CRLException {
        Collection<? extends CRL> varB4EAC82CA7396A68D541C85D26508E83_1536965769 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1536965769 = spiImpl.engineGenerateCRLs(inStream);
        addTaint(inStream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1536965769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1536965769;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCRLs(inStream);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.529 -0400", hash_original_field = "B841CBE76346F2F1B8808B92FE062632", hash_generated_field = "B69254DA5A911D534D2ADF4BE9FA6F45")

    private static String SERVICE = "CertificateFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.529 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
}

