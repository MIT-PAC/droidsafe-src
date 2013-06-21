package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.security.auth.x500.X500Principal;

public abstract class X509Certificate extends Certificate implements X509Extension {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.651 -0400", hash_original_method = "91BE0E39C67CC71AFC40C5A05860BC17", hash_generated_method = "FA912E7D2076329B07D35CCC0B73CE9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected X509Certificate() {
        super("X.509");
        // ---------- Original Method ----------
    }

    
    public abstract void checkValidity()
            throws CertificateExpiredException, CertificateNotYetValidException;

    
    public abstract void checkValidity(Date date)
            throws CertificateExpiredException, CertificateNotYetValidException;

    
    public abstract int getVersion();

    
    public abstract BigInteger getSerialNumber();

    
    public abstract Principal getIssuerDN() ;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.655 -0400", hash_original_method = "622364792700CAE6EDC2CD40345CDB0C", hash_generated_method = "910A9136D195A2320ECFB9F3EE8D9EF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal getIssuerX500Principal() {
        try 
        {
            CertificateFactory factory;
            factory = CertificateFactory
                    .getInstance("X.509");
            X509Certificate cert;
            cert = (X509Certificate) factory
                    .generateCertificate(new ByteArrayInputStream(getEncoded()));
            X500Principal var0C7F60A8B34AECC12193FEF96049CBD5_448749745 = (cert.getIssuerX500Principal());
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to get X500Principal issuer", e);
        } //End block
        return (X500Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //CertificateFactory factory = CertificateFactory
                    //.getInstance("X.509");
            //X509Certificate cert = (X509Certificate) factory
                    //.generateCertificate(new ByteArrayInputStream(getEncoded()));
            //return cert.getIssuerX500Principal();
        //} catch (Exception e) {
            //throw new RuntimeException("Failed to get X500Principal issuer", e);
        //}
    }

    
    public abstract Principal getSubjectDN();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.656 -0400", hash_original_method = "4B536E889AC2F831879320061DB28B36", hash_generated_method = "AFB3080B5152C97EF7CEF6A81DEA922B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal getSubjectX500Principal() {
        try 
        {
            CertificateFactory factory;
            factory = CertificateFactory
                    .getInstance("X.509");
            X509Certificate cert;
            cert = (X509Certificate) factory
                    .generateCertificate(new ByteArrayInputStream(getEncoded()));
            X500Principal varED85CE6FE8E7A4E28BBF4124A24DA5DD_980260626 = (cert.getSubjectX500Principal());
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to get X500Principal subject", e);
        } //End block
        return (X500Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //CertificateFactory factory = CertificateFactory
                    //.getInstance("X.509");
            //X509Certificate cert = (X509Certificate) factory
                    //.generateCertificate(new ByteArrayInputStream(getEncoded()));
            //return cert.getSubjectX500Principal();
        //} catch (Exception e) {
            //throw new RuntimeException("Failed to get X500Principal subject", e);
        //}
    }

    
    public abstract Date getNotBefore();

    
    public abstract Date getNotAfter();

    
    public abstract byte[] getTBSCertificate()
                                    throws CertificateEncodingException;

    
    public abstract byte[] getSignature();

    
    public abstract String getSigAlgName();

    
    public abstract String getSigAlgOID();

    
    public abstract byte[] getSigAlgParams();

    
    public abstract boolean[] getIssuerUniqueID();

    
    public abstract boolean[] getSubjectUniqueID();

    
    public abstract boolean[] getKeyUsage();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.657 -0400", hash_original_method = "418B9B73EF0BB9A94B6F38EF0D0811CB", hash_generated_method = "61E9C955AB4AE85BD7EFD135904EAD53")
    @DSModeled(DSC.SAFE)
    public List<String> getExtendedKeyUsage() throws CertificateParsingException {
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    public abstract int getBasicConstraints();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.657 -0400", hash_original_method = "2F7FC96FA38F720B2ACF5452CA7F8BC4", hash_generated_method = "83DC4808E894225C3654D6A3359BAE97")
    @DSModeled(DSC.SAFE)
    public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
        return (Collection<List<?>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.657 -0400", hash_original_method = "274C80A4A7372477807793557A7E6C15", hash_generated_method = "7F4739214A55212CB29188F1B4870FC8")
    @DSModeled(DSC.SAFE)
    public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
        return (Collection<List<?>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    private static final long serialVersionUID = -2491127588187038216L;
}

