package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.security.auth.x500.X500Principal;

public abstract class X509Certificate extends Certificate implements X509Extension {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.990 -0400", hash_original_method = "91BE0E39C67CC71AFC40C5A05860BC17", hash_generated_method = "FA912E7D2076329B07D35CCC0B73CE9D")
    protected  X509Certificate() {
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.992 -0400", hash_original_method = "622364792700CAE6EDC2CD40345CDB0C", hash_generated_method = "06C492AB813DDF2CB2B971A1360D4E61")
    public X500Principal getIssuerX500Principal() {
        try 
        {
            CertificateFactory factory = CertificateFactory
                    .getInstance("X.509");
            X509Certificate cert = (X509Certificate) factory
                    .generateCertificate(new ByteArrayInputStream(getEncoded()));
X500Principal var52A5A8995E7C651750494F51BE6F78BC_682500918 =             cert.getIssuerX500Principal();
            var52A5A8995E7C651750494F51BE6F78BC_682500918.addTaint(taint);
            return var52A5A8995E7C651750494F51BE6F78BC_682500918;
        } //End block
        catch (Exception e)
        {
            RuntimeException varA65F8D75FA50DBD0928C8539ABB7D70F_383745342 = new RuntimeException("Failed to get X500Principal issuer", e);
            varA65F8D75FA50DBD0928C8539ABB7D70F_383745342.addTaint(taint);
            throw varA65F8D75FA50DBD0928C8539ABB7D70F_383745342;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.993 -0400", hash_original_method = "4B536E889AC2F831879320061DB28B36", hash_generated_method = "23FB92A07C8A227A58A678AD53F2ABCC")
    public X500Principal getSubjectX500Principal() {
        try 
        {
            CertificateFactory factory = CertificateFactory
                    .getInstance("X.509");
            X509Certificate cert = (X509Certificate) factory
                    .generateCertificate(new ByteArrayInputStream(getEncoded()));
X500Principal varF762730623832F6B2DE9205975DF8C9C_126065559 =             cert.getSubjectX500Principal();
            varF762730623832F6B2DE9205975DF8C9C_126065559.addTaint(taint);
            return varF762730623832F6B2DE9205975DF8C9C_126065559;
        } //End block
        catch (Exception e)
        {
            RuntimeException varD8954FBFA4F69B520F37003446B032E8_1323582143 = new RuntimeException("Failed to get X500Principal subject", e);
            varD8954FBFA4F69B520F37003446B032E8_1323582143.addTaint(taint);
            throw varD8954FBFA4F69B520F37003446B032E8_1323582143;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.996 -0400", hash_original_method = "418B9B73EF0BB9A94B6F38EF0D0811CB", hash_generated_method = "C7297EEE78010AFB5FCCDA33F0BE77FA")
    public List<String> getExtendedKeyUsage() throws CertificateParsingException {
List<String> var540C13E9E156B687226421B24F2DF178_737509032 =         null;
        var540C13E9E156B687226421B24F2DF178_737509032.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_737509032;
        // ---------- Original Method ----------
        //return null;
    }

    
    public abstract int getBasicConstraints();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.996 -0400", hash_original_method = "2F7FC96FA38F720B2ACF5452CA7F8BC4", hash_generated_method = "389F428053A1DE593BD7AF501144880A")
    public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
Collection<List<?>> var540C13E9E156B687226421B24F2DF178_1653612264 =         null;
        var540C13E9E156B687226421B24F2DF178_1653612264.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1653612264;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.996 -0400", hash_original_method = "274C80A4A7372477807793557A7E6C15", hash_generated_method = "969DC253FB0A51ED68684E816698866C")
    public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
Collection<List<?>> var540C13E9E156B687226421B24F2DF178_1691393976 =         null;
        var540C13E9E156B687226421B24F2DF178_1691393976.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1691393976;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.997 -0400", hash_original_field = "739DB704D6A3CC6EBE6C2811360DFAF7", hash_generated_field = "295358E84336F84BE14E3E6F43F3885D")

    private static final long serialVersionUID = -2491127588187038216L;
}

