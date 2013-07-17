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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.976 -0400", hash_original_method = "2D9BCEC4939C6B2A16B59D950D508E2F", hash_generated_method = "6B0685A70028A2CF56FAA3D7A0C4B658")
    protected  X509CRL() {
        super("X.509");
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.976 -0400", hash_original_method = "B46E0DB2406C7673FA6227AB64C6E804", hash_generated_method = "ECD6CF1CE2A3D4AF08D73BF613F257BD")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1295974863 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189084800 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189084800;
        } //End block
        if(!(other instanceof X509CRL))        
        {
            boolean var68934A3E9455FA72420237EB05902327_621269714 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300026675 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_300026675;
        } //End block
        X509CRL obj = (X509CRL) other;
        try 
        {
            boolean var495B215FF1C01B42CA09E140999C6325_929856461 = (Arrays.equals(getEncoded(), obj.getEncoded()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1729044591 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1729044591;
        } //End block
        catch (CRLException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_3667046 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366746557 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_366746557;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.977 -0400", hash_original_method = "A943E96C731BD94967EC1AD73CB7A230", hash_generated_method = "5602D9B87DA2FDBD37FEF050F4145F5C")
    public int hashCode() {
        try 
        {
            int res = 0;
            byte[] array = getEncoded();
for(int i=0;i<array.length;i++)
            {
                res += array[i] & 0xFF;
            } //End block
            int var9B207167E5381C47682C6B4F58A623FB_1288450510 = (res);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1384142800 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1384142800;
        } //End block
        catch (CRLException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1036800733 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288105558 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288105558;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.978 -0400", hash_original_method = "7A37B67299F05C8453FDB868F4BBC1A9", hash_generated_method = "8AA5CE2604E4B928D243DB1F3C2F22DA")
    public X500Principal getIssuerX500Principal() {
        try 
        {
            CertificateFactory factory = CertificateFactory
                    .getInstance("X.509");
            X509CRL crl = (X509CRL) factory
                    .generateCRL(new ByteArrayInputStream(getEncoded()));
X500Principal varC2B70E1034A0A004A96CFD5C2CC4F856_1986954215 =             crl.getIssuerX500Principal();
            varC2B70E1034A0A004A96CFD5C2CC4F856_1986954215.addTaint(taint);
            return varC2B70E1034A0A004A96CFD5C2CC4F856_1986954215;
        } //End block
        catch (Exception e)
        {
            RuntimeException varA65F8D75FA50DBD0928C8539ABB7D70F_510737122 = new RuntimeException("Failed to get X500Principal issuer", e);
            varA65F8D75FA50DBD0928C8539ABB7D70F_510737122.addTaint(taint);
            throw varA65F8D75FA50DBD0928C8539ABB7D70F_510737122;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.979 -0400", hash_original_method = "22BEF0D3299982E1A7A804A3A397C4D3", hash_generated_method = "861DD58ED9FD8CF71ED5FD2F5DCE83DC")
    public X509CRLEntry getRevokedCertificate(X509Certificate certificate) {
        addTaint(certificate.getTaint());
        if(certificate == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1777475323 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1777475323.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1777475323;
        } //End block
X509CRLEntry var461BFC32BFD4CCACEEDED8126479C2CF_1939308008 =         getRevokedCertificate(certificate.getSerialNumber());
        var461BFC32BFD4CCACEEDED8126479C2CF_1939308008.addTaint(taint);
        return var461BFC32BFD4CCACEEDED8126479C2CF_1939308008;
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

