package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.882 -0400", hash_original_method = "2D9BCEC4939C6B2A16B59D950D508E2F", hash_generated_method = "6B0685A70028A2CF56FAA3D7A0C4B658")
    protected  X509CRL() {
        super("X.509");
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.883 -0400", hash_original_method = "B46E0DB2406C7673FA6227AB64C6E804", hash_generated_method = "52D30EB31ACD119110ECC59C0D45BCA4")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_768239861 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1376076660 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1376076660;
        } //End block
    if(!(other instanceof X509CRL))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1407499537 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147781953 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147781953;
        } //End block
        X509CRL obj = (X509CRL) other;
        try 
        {
            boolean var495B215FF1C01B42CA09E140999C6325_716596731 = (Arrays.equals(getEncoded(), obj.getEncoded()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1504571157 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1504571157;
        } //End block
        catch (CRLException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1247978368 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2041602216 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2041602216;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.883 -0400", hash_original_method = "A943E96C731BD94967EC1AD73CB7A230", hash_generated_method = "277FD7E50AE7389459627267BE5A317F")
    public int hashCode() {
        try 
        {
            int res = 0;
            byte[] array = getEncoded();
for(int i=0;i<array.length;i++)
            {
                res += array[i] & 0xFF;
            } //End block
            int var9B207167E5381C47682C6B4F58A623FB_1238791746 = (res);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310896231 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310896231;
        } //End block
        catch (CRLException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1165930279 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1471642460 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1471642460;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.885 -0400", hash_original_method = "7A37B67299F05C8453FDB868F4BBC1A9", hash_generated_method = "FF114EACE410E2B121C451D5D911F686")
    public X500Principal getIssuerX500Principal() {
        try 
        {
            CertificateFactory factory = CertificateFactory
                    .getInstance("X.509");
            X509CRL crl = (X509CRL) factory
                    .generateCRL(new ByteArrayInputStream(getEncoded()));
X500Principal varC2B70E1034A0A004A96CFD5C2CC4F856_877543918 =             crl.getIssuerX500Principal();
            varC2B70E1034A0A004A96CFD5C2CC4F856_877543918.addTaint(taint);
            return varC2B70E1034A0A004A96CFD5C2CC4F856_877543918;
        } //End block
        catch (Exception e)
        {
            RuntimeException varA65F8D75FA50DBD0928C8539ABB7D70F_1481529162 = new RuntimeException("Failed to get X500Principal issuer", e);
            varA65F8D75FA50DBD0928C8539ABB7D70F_1481529162.addTaint(taint);
            throw varA65F8D75FA50DBD0928C8539ABB7D70F_1481529162;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.886 -0400", hash_original_method = "22BEF0D3299982E1A7A804A3A397C4D3", hash_generated_method = "E833A516EB265E6BE5BA9F822CACBB15")
    public X509CRLEntry getRevokedCertificate(X509Certificate certificate) {
        addTaint(certificate.getTaint());
    if(certificate == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_67654381 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_67654381.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_67654381;
        } //End block
X509CRLEntry var461BFC32BFD4CCACEEDED8126479C2CF_1154338376 =         getRevokedCertificate(certificate.getSerialNumber());
        var461BFC32BFD4CCACEEDED8126479C2CF_1154338376.addTaint(taint);
        return var461BFC32BFD4CCACEEDED8126479C2CF_1154338376;
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

