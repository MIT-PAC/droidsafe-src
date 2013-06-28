package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public abstract class X509CRL extends CRL implements X509Extension {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.011 -0400", hash_original_method = "2D9BCEC4939C6B2A16B59D950D508E2F", hash_generated_method = "6B0685A70028A2CF56FAA3D7A0C4B658")
    protected  X509CRL() {
        super("X.509");
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.012 -0400", hash_original_method = "B46E0DB2406C7673FA6227AB64C6E804", hash_generated_method = "22899CEA694D941F177ECCDA2756E591")
    public boolean equals(Object other) {
        {
            boolean var140A8815FDEEC27C4D8944D501CA10BC_1844839401 = (other == this);
        } //End collapsed parenthetic
        X509CRL obj = (X509CRL) other;
        try 
        {
            boolean varB5D83890052057F26DC274F831DC9052_403522085 = (Arrays.equals(getEncoded(), obj.getEncoded()));
        } //End block
        catch (CRLException e)
        { }
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103648121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103648121;
        // ---------- Original Method ----------
        //if (other == this) {
            //return true;
        //}
        //if (!(other instanceof X509CRL)) {
            //return false;
        //}
        //X509CRL obj = (X509CRL) other;
        //try {
            //return Arrays.equals(getEncoded(), obj.getEncoded());
        //} catch (CRLException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.012 -0400", hash_original_method = "A943E96C731BD94967EC1AD73CB7A230", hash_generated_method = "E05B841EA3061FF46863760FD395246C")
    public int hashCode() {
        try 
        {
            int res = 0;
            byte[] array = getEncoded();
            {
                int i = 0;
                {
                    res += array[i] & 0xFF;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (CRLException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1741007486 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1741007486;
        // ---------- Original Method ----------
        //try {
            //int res = 0;
            //byte[] array = getEncoded();
            //for (int i=0; i<array.length; i++) {
                //res += array[i] & 0xFF;
            //}
            //return res;
        //} catch (CRLException e) {
            //return 0;
        //}
    }

    
    public abstract byte[] getEncoded() throws CRLException;

    
    public abstract void verify(PublicKey key)
                     throws CRLException, NoSuchAlgorithmException,
                            InvalidKeyException, NoSuchProviderException,
                            SignatureException;

    
    public abstract void verify(PublicKey key, String sigProvider)
                     throws CRLException, NoSuchAlgorithmException,
                            InvalidKeyException, NoSuchProviderException,
                            SignatureException;

    
    public abstract int getVersion();

    
    public abstract Principal getIssuerDN();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.015 -0400", hash_original_method = "7A37B67299F05C8453FDB868F4BBC1A9", hash_generated_method = "05589A11F5F3DFB1156DA69B5FB4ECEF")
    public X500Principal getIssuerX500Principal() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_549382103 = null; //Variable for return #1
        try 
        {
            CertificateFactory factory = CertificateFactory
                    .getInstance("X.509");
            X509CRL crl = (X509CRL) factory
                    .generateCRL(new ByteArrayInputStream(getEncoded()));
            varB4EAC82CA7396A68D541C85D26508E83_549382103 = crl.getIssuerX500Principal();
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to get X500Principal issuer", e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_549382103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_549382103;
        // ---------- Original Method ----------
        //try {
            //CertificateFactory factory = CertificateFactory
                    //.getInstance("X.509");
            //X509CRL crl = (X509CRL) factory
                    //.generateCRL(new ByteArrayInputStream(getEncoded()));
            //return crl.getIssuerX500Principal();
        //} catch (Exception e) {
            //throw new RuntimeException("Failed to get X500Principal issuer", e);
        //}
    }

    
    public abstract Date getThisUpdate();

    
    public abstract Date getNextUpdate();

    
    public abstract X509CRLEntry getRevokedCertificate(BigInteger serialNumber);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.017 -0400", hash_original_method = "22BEF0D3299982E1A7A804A3A397C4D3", hash_generated_method = "B725E28CE5637A33665D0CCB7B2109A3")
    public X509CRLEntry getRevokedCertificate(X509Certificate certificate) {
        X509CRLEntry varB4EAC82CA7396A68D541C85D26508E83_767746622 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_767746622 = getRevokedCertificate(certificate.getSerialNumber());
        addTaint(certificate.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_767746622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_767746622;
        // ---------- Original Method ----------
        //if (certificate == null) {
            //throw new NullPointerException();
        //}
        //return getRevokedCertificate(certificate.getSerialNumber());
    }

    
    public abstract Set<? extends X509CRLEntry> getRevokedCertificates();

    
    public abstract byte[] getTBSCertList() throws CRLException;

    
    public abstract byte[] getSignature();

    
    public abstract String getSigAlgName();

    
    public abstract String getSigAlgOID();

    
    public abstract byte[] getSigAlgParams();

    
}

