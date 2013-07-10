package java.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.security.auth.x500.X500Principal;

public abstract class X509Certificate extends Certificate implements X509Extension {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.030 -0400", hash_original_method = "91BE0E39C67CC71AFC40C5A05860BC17", hash_generated_method = "FA912E7D2076329B07D35CCC0B73CE9D")
    protected  X509Certificate() {
        super("X.509");
        
    }

    
    public abstract void checkValidity()
            throws CertificateExpiredException, CertificateNotYetValidException;

    
    public abstract void checkValidity(Date date)
            throws CertificateExpiredException, CertificateNotYetValidException;

    
    public abstract int getVersion();

    
    public abstract BigInteger getSerialNumber();

    
    public abstract Principal getIssuerDN() ;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.031 -0400", hash_original_method = "622364792700CAE6EDC2CD40345CDB0C", hash_generated_method = "FD4BCE04FDC25F1C41F1C1F7BB2E8501")
    public X500Principal getIssuerX500Principal() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_1114481198 = null; 
        try 
        {
            CertificateFactory factory = CertificateFactory
                    .getInstance("X.509");
            X509Certificate cert = (X509Certificate) factory
                    .generateCertificate(new ByteArrayInputStream(getEncoded()));
            varB4EAC82CA7396A68D541C85D26508E83_1114481198 = cert.getIssuerX500Principal();
        } 
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to get X500Principal issuer", e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1114481198.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1114481198;
        
        
            
                    
            
                    
            
        
            
        
    }

    
    public abstract Principal getSubjectDN();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.032 -0400", hash_original_method = "4B536E889AC2F831879320061DB28B36", hash_generated_method = "2F31B6BE6A27BB65AB615A59C19C3627")
    public X500Principal getSubjectX500Principal() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_1873626119 = null; 
        try 
        {
            CertificateFactory factory = CertificateFactory
                    .getInstance("X.509");
            X509Certificate cert = (X509Certificate) factory
                    .generateCertificate(new ByteArrayInputStream(getEncoded()));
            varB4EAC82CA7396A68D541C85D26508E83_1873626119 = cert.getSubjectX500Principal();
        } 
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to get X500Principal subject", e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1873626119.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1873626119;
        
        
            
                    
            
                    
            
        
            
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.034 -0400", hash_original_method = "418B9B73EF0BB9A94B6F38EF0D0811CB", hash_generated_method = "E2334DEE0A39990F790881A6706FFFBE")
    public List<String> getExtendedKeyUsage() throws CertificateParsingException {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1990278166 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1990278166 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1990278166.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1990278166;
        
        
    }

    
    public abstract int getBasicConstraints();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.035 -0400", hash_original_method = "2F7FC96FA38F720B2ACF5452CA7F8BC4", hash_generated_method = "F1DA1AAF965DA900E20E47D92445A8B4")
    public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_214444423 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_214444423 = null;
        varB4EAC82CA7396A68D541C85D26508E83_214444423.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_214444423;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.035 -0400", hash_original_method = "274C80A4A7372477807793557A7E6C15", hash_generated_method = "6ABD304EF8C1767D91B690F959BF3405")
    public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_1633563173 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1633563173 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1633563173.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1633563173;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.036 -0400", hash_original_field = "739DB704D6A3CC6EBE6C2811360DFAF7", hash_generated_field = "295358E84336F84BE14E3E6F43F3885D")

    private static final long serialVersionUID = -2491127588187038216L;
}

