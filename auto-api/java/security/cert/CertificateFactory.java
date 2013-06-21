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
    private Provider provider;
    private CertificateFactorySpi spiImpl;
    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.638 -0400", hash_original_method = "8F22BB9FD67741B57F6E16F313DC406A", hash_generated_method = "EF2B238CEFA1E4D0EF35D794E1D1775A")
    @DSModeled(DSC.SAFE)
    protected CertificateFactory(CertificateFactorySpi certFacSpi,
            Provider provider, String type) {
        dsTaint.addTaint(certFacSpi.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(type);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.640 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.640 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "2AE4CD67D4DDBE32BC864794C06C4464")
    @DSModeled(DSC.SAFE)
    public final String getType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.640 -0400", hash_original_method = "056686B78E96E8E09F6472D6283D322E", hash_generated_method = "CBA1921CF4D6D689EC0AE5489B9BDACA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Certificate generateCertificate(InputStream inStream) throws CertificateException {
        dsTaint.addTaint(inStream.dsTaint);
        Certificate var290A1817FD4922D7D781EDD67ABDDC91_1655891568 = (spiImpl.engineGenerateCertificate(inStream));
        return (Certificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertificate(inStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.640 -0400", hash_original_method = "E0154FCC8B9DF343492D74548A8DABBF", hash_generated_method = "79C3DE434817C20DBAFF86A9DC5C0E4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Iterator<String> getCertPathEncodings() {
        Iterator<String> var488C09C9180DFC2B89A37E087DE88F3D_1138154824 = (spiImpl.engineGetCertPathEncodings());
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetCertPathEncodings();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.641 -0400", hash_original_method = "3A334BAABFC8F8F07B1C887BAAF7ABEE", hash_generated_method = "831AC3339337393B1B78742B1B5AF549")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CertPath generateCertPath(InputStream inStream) throws CertificateException {
        dsTaint.addTaint(inStream.dsTaint);
        Iterator<String> it;
        it = getCertPathEncodings();
        {
            boolean varF026B59EDDFD91F5680511797C117EE1_960278177 = (!it.hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateException("There are no CertPath encodings");
            } //End block
        } //End collapsed parenthetic
        CertPath var068C0431712350623F56E31A2F2D5B58_1018818201 = (spiImpl.engineGenerateCertPath(inStream, it.next()));
        return (CertPath)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Iterator<String> it = getCertPathEncodings();
        //if (!it.hasNext()) {
            //throw new CertificateException("There are no CertPath encodings");
        //}
        //return spiImpl.engineGenerateCertPath(inStream, it.next());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.641 -0400", hash_original_method = "2B5CC92C0290261B5C7A25A0F691CEF6", hash_generated_method = "AD373DD47ADC892327F0B1881CF4049A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CertPath generateCertPath(InputStream inStream, String encoding) throws CertificateException {
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(inStream.dsTaint);
        CertPath var279C1DB2476042E22950F547D0E6601F_363743434 = (spiImpl.engineGenerateCertPath(inStream, encoding));
        return (CertPath)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertPath(inStream, encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.641 -0400", hash_original_method = "FE6370346FB92E14C140A17484E61066", hash_generated_method = "63CA079BD5FCDC431152D05A8B446F93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CertPath generateCertPath(List<? extends Certificate> certificates) throws CertificateException {
        dsTaint.addTaint(certificates.dsTaint);
        CertPath varA89C55C6ED6BCE1EB185FABB0E988F1C_804811984 = (spiImpl.engineGenerateCertPath(certificates));
        return (CertPath)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertPath(certificates);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.641 -0400", hash_original_method = "2C42C184C3EAF19809C332EBF46CD8DC", hash_generated_method = "4082942A6A47101C93E023D8A04FF59C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Collection<? extends Certificate> generateCertificates(InputStream inStream) throws CertificateException {
        dsTaint.addTaint(inStream.dsTaint);
        Collection<? extends Certificate> varA09CF4ADE489A878BECA75E51ABB3A25_1134903127 = (spiImpl.engineGenerateCertificates(inStream));
        return (Collection<? extends Certificate>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertificates(inStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.641 -0400", hash_original_method = "61C041CED79E728E684417F700AE9F1B", hash_generated_method = "A3B15FC0F885F24B1914005D84B8D8EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CRL generateCRL(InputStream inStream) throws CRLException {
        dsTaint.addTaint(inStream.dsTaint);
        CRL var3BDB897853814070C31B44E3E4A2AFD8_1255870181 = (spiImpl.engineGenerateCRL(inStream));
        return (CRL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCRL(inStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.642 -0400", hash_original_method = "82C17943BE49A882CA4049864C9D79C5", hash_generated_method = "F18B872C822D695C4E6FEFE3091516DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Collection<? extends CRL> generateCRLs(InputStream inStream) throws CRLException {
        dsTaint.addTaint(inStream.dsTaint);
        Collection<? extends CRL> var4FEACF81F94DBCB6D0726A9371D59E76_232936510 = (spiImpl.engineGenerateCRLs(inStream));
        return (Collection<? extends CRL>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCRLs(inStream);
    }

    
    private static final String SERVICE = "CertificateFactory";
    private static final Engine ENGINE = new Engine(SERVICE);
}

