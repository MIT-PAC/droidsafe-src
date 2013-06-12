package java.security.cert;

// Droidsafe Imports
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Collection;
// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;

import org.apache.harmony.security.fortress.Engine;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public class CertificateFactory {
    private static final String SERVICE = "CertificateFactory";
    private static final Engine ENGINE = new Engine(SERVICE);
    private  Provider provider;
    private  CertificateFactorySpi spiImpl;
    private  String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:54.269 -0400", hash_original_method = "8F22BB9FD67741B57F6E16F313DC406A", hash_generated_method = "5D56C491966E01A8637971DCF781DE7A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:54.270 -0400", hash_original_method = "4AD7FAA844427F176B8B65D577E52F93", hash_generated_method = "87D3B2169C00645004EE6002962939F6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:54.271 -0400", hash_original_method = "8516850578A03892E88112705C313FAD", hash_generated_method = "7918DBFDD3E629F72077CF0ECDDBD807")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:54.272 -0400", hash_original_method = "5A73DDBD4164B592F1D7657222558E65", hash_generated_method = "148B2F0E6CCE90FEBAF4EBBBA3C5CA46")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:54.272 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "45F6335264F85F3B8D73CAC979348AC1")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:54.273 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "C33423799F46A4D983B8408DB9A92B86")
    @DSModeled(DSC.SAFE)
    public final String getType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.599 -0400",hash_original_method="82C17943BE49A882CA4049864C9D79C5",hash_generated_method="0E5323511860A61E93D4658AF6451E6C")
public final Certificate generateCertificate(InputStream inStream) throws CertificateException {
        dsTaint.addTaint(inStream.dsTaint);
        Certificate var290A1817FD4922D7D781EDD67ABDDC91_121702764 = (spiImpl.engineGenerateCertificate(inStream));
        return (Certificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertificate(inStream);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.599 -0400",hash_original_method="82C17943BE49A882CA4049864C9D79C5",hash_generated_method="0E5323511860A61E93D4658AF6451E6C")
public final Iterator<String> getCertPathEncodings() {
        Iterator<String> var488C09C9180DFC2B89A37E087DE88F3D_739646593 = (spiImpl.engineGetCertPathEncodings());
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetCertPathEncodings();
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.599 -0400",hash_original_method="82C17943BE49A882CA4049864C9D79C5",hash_generated_method="0E5323511860A61E93D4658AF6451E6C")
public final CertPath generateCertPath(InputStream inStream) throws CertificateException {
        dsTaint.addTaint(inStream.dsTaint);
        Iterator<String> it;
        it = getCertPathEncodings();
        {
            boolean varF026B59EDDFD91F5680511797C117EE1_2145216215 = (!it.hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateException("There are no CertPath encodings");
            } //End block
        } //End collapsed parenthetic
        CertPath var068C0431712350623F56E31A2F2D5B58_1234489256 = (spiImpl.engineGenerateCertPath(inStream, it.next()));
        return (CertPath)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Iterator<String> it = getCertPathEncodings();
        //if (!it.hasNext()) {
            //throw new CertificateException("There are no CertPath encodings");
        //}
        //return spiImpl.engineGenerateCertPath(inStream, it.next());
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.599 -0400",hash_original_method="82C17943BE49A882CA4049864C9D79C5",hash_generated_method="0E5323511860A61E93D4658AF6451E6C")
public final CertPath generateCertPath(InputStream inStream, String encoding) throws CertificateException {
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(inStream.dsTaint);
        CertPath var279C1DB2476042E22950F547D0E6601F_2141199868 = (spiImpl.engineGenerateCertPath(inStream, encoding));
        return (CertPath)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertPath(inStream, encoding);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.599 -0400",hash_original_method="82C17943BE49A882CA4049864C9D79C5",hash_generated_method="0E5323511860A61E93D4658AF6451E6C")
public final CertPath generateCertPath(List<? extends Certificate> certificates) throws CertificateException {
        dsTaint.addTaint(certificates.dsTaint);
        CertPath varA89C55C6ED6BCE1EB185FABB0E988F1C_676129042 = (spiImpl.engineGenerateCertPath(certificates));
        return (CertPath)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertPath(certificates);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.599 -0400",hash_original_method="82C17943BE49A882CA4049864C9D79C5",hash_generated_method="0E5323511860A61E93D4658AF6451E6C")
public final Collection<? extends Certificate> generateCertificates(InputStream inStream) throws CertificateException {
        dsTaint.addTaint(inStream.dsTaint);
        Collection<? extends Certificate> varA09CF4ADE489A878BECA75E51ABB3A25_359097689 = (spiImpl.engineGenerateCertificates(inStream));
        return (Collection<? extends Certificate>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCertificates(inStream);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.599 -0400",hash_original_method="82C17943BE49A882CA4049864C9D79C5",hash_generated_method="0E5323511860A61E93D4658AF6451E6C")
public final CRL generateCRL(InputStream inStream) throws CRLException {
        dsTaint.addTaint(inStream.dsTaint);
        CRL var3BDB897853814070C31B44E3E4A2AFD8_381948674 = (spiImpl.engineGenerateCRL(inStream));
        return (CRL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCRL(inStream);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.599 -0400",hash_original_method="82C17943BE49A882CA4049864C9D79C5",hash_generated_method="0E5323511860A61E93D4658AF6451E6C")
public final Collection<? extends CRL> generateCRLs(InputStream inStream) throws CRLException {
        dsTaint.addTaint(inStream.dsTaint);
        Collection<? extends CRL> var4FEACF81F94DBCB6D0726A9371D59E76_628858977 = (spiImpl.engineGenerateCRLs(inStream));
        return (Collection<? extends CRL>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateCRLs(inStream);
    }

    
}


