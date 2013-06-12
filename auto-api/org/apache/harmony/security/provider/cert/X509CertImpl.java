package org.apache.harmony.security.provider.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.utils.AlgNameMapper;
import org.apache.harmony.security.x509.Certificate;
import org.apache.harmony.security.x509.Extension;
import org.apache.harmony.security.x509.Extensions;
import org.apache.harmony.security.x509.TBSCertificate;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSignature;

public final class X509CertImpl extends X509Certificate {
    private static final long serialVersionUID = 2972248729446736154L;
    private final Certificate certificate;
    private final TBSCertificate tbsCert;
    private final Extensions extensions;
    private volatile long notBefore = -1;
    private volatile long notAfter = -1;
    private volatile BigInteger serialNumber;
    private volatile X500Principal issuer;
    private volatile X500Principal subject;
    private volatile byte[] tbsCertificate;
    private volatile byte[] signature;
    private volatile String sigAlgName;
    private volatile String sigAlgOID;
    private volatile byte[] sigAlgParams;
    private volatile boolean nullSigAlgParams;
    private volatile PublicKey publicKey;
    private volatile byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.757 -0400", hash_original_method = "8B0F316F14E4B2EBE1AD9D0407358FB5", hash_generated_method = "1BA39AA9E90E464D40B434562EC4C533")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X509CertImpl(InputStream in) throws CertificateException {
        dsTaint.addTaint(in.dsTaint);
        try 
        {
            this.certificate = (Certificate) Certificate.ASN1.decode(in);
            this.tbsCert = certificate.getTbsCertificate();
            this.extensions = tbsCert.getExtensions();
        } //End block
        catch (IOException e)
        {
            throw new CertificateException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //this.certificate = (Certificate) Certificate.ASN1.decode(in);
            //this.tbsCert = certificate.getTbsCertificate();
            //this.extensions = tbsCert.getExtensions();
        //} catch (IOException e) {
            //throw new CertificateException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.757 -0400", hash_original_method = "8876B8D60330C38B32B3F1E3F7F33D8F", hash_generated_method = "44FAD58F28BFC6FDF91672ED177379F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X509CertImpl(Certificate certificate) {
        dsTaint.addTaint(certificate.dsTaint);
        this.tbsCert = certificate.getTbsCertificate();
        this.extensions = tbsCert.getExtensions();
        // ---------- Original Method ----------
        //this.certificate = certificate;
        //this.tbsCert = certificate.getTbsCertificate();
        //this.extensions = tbsCert.getExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.757 -0400", hash_original_method = "9C90F0AD6131A4566D6AF431EC38BE50", hash_generated_method = "4AA8753BBF45D5AAC7720F48828F02DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X509CertImpl(byte[] encoding) throws IOException {
        this((Certificate) Certificate.ASN1.decode(encoding));
        dsTaint.addTaint(encoding);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.757 -0400", hash_original_method = "92CEFDF21FC191A18696C43CA9E48D20", hash_generated_method = "B7B383B3E924A7352ED39981488DE7EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(System.currentTimeMillis());
        // ---------- Original Method ----------
        //checkValidity(System.currentTimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.757 -0400", hash_original_method = "59C6435E22C5BAEC0B6376C8B7A5112D", hash_generated_method = "A1DEC4581689B474F6EA6959D60589C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        dsTaint.addTaint(date.dsTaint);
        checkValidity(date.getTime());
        // ---------- Original Method ----------
        //checkValidity(date.getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "5C762410FB306F1308EE7204752B0EB0", hash_generated_method = "A151A767B80A7AAAA2CECB25B1202D3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkValidity(long time) throws CertificateExpiredException, CertificateNotYetValidException {
        dsTaint.addTaint(time);
        {
            boolean var264F16FDDA2F76F2C6FA01CF75941728_204913042 = (time < getNotBeforeInternal());
            {
                throw new CertificateNotYetValidException("current time: " + new Date(time)
                + ", validation time: " + new Date(getNotBeforeInternal()));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2AB2BCD0EA9D992C8DA2E852EA2D3B2C_2060941778 = (time > getNotAfterInternal());
            {
                throw new CertificateExpiredException("current time: " + new Date(time)
                + ", expiration time: " + new Date(getNotAfterInternal()));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (time < getNotBeforeInternal()) {
            //throw new CertificateNotYetValidException("current time: " + new Date(time)
                //+ ", validation time: " + new Date(getNotBeforeInternal()));
        //}
        //if (time > getNotAfterInternal()) {
            //throw new CertificateExpiredException("current time: " + new Date(time)
                //+ ", expiration time: " + new Date(getNotAfterInternal()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "89D7F1BE0C395C13D4A43DDDB6D84533", hash_generated_method = "B9B916F015D228E4A5AE9E48AD27EBE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVersion() {
        int var14209A0688FE80EBFD09C9716EC0F554_1726971609 = (tbsCert.getVersion() + 1);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return tbsCert.getVersion() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "CC90380181A21ABFD0C1237D9F2C9838", hash_generated_method = "8DE4EAD4F8D9B5E7148D663064206A6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BigInteger getSerialNumber() {
        BigInteger result;
        result = serialNumber;
        {
            serialNumber = result = tbsCert.getSerialNumber();
        } //End block
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BigInteger result = serialNumber;
        //if (result == null) {
            //serialNumber = result = tbsCert.getSerialNumber();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "2552251E229FA5F4C4BC8254C0633556", hash_generated_method = "9E76396B72124B9FFC6B9DDBBC959087")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getIssuerDN() {
        Principal varA20FA15F778F0CB50B99F7227270B53E_643191206 = (getIssuerX500Principal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getIssuerX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "B82B3361EE6501B1AD6CD55F9554225E", hash_generated_method = "7974F1639F0A8F036025F677EBFD508D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal getIssuerX500Principal() {
        X500Principal result;
        result = issuer;
        {
            issuer = result = tbsCert.getIssuer().getX500Principal();
        } //End block
        return (X500Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //X500Principal result = issuer;
        //if (result == null) {
            //issuer = result = tbsCert.getIssuer().getX500Principal();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "57EE376613339C3801C08A778AAA92CE", hash_generated_method = "24F84F034C25078A168DCB87394A285F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getSubjectDN() {
        Principal varBC9861BDB209444EEDE43C1600F8D706_582734611 = (getSubjectX500Principal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "50D7E6DD1BE4A80FFE9B722B1EC59064", hash_generated_method = "297AAD9401F142AAE76BF2A283F7FF42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal getSubjectX500Principal() {
        X500Principal result;
        result = subject;
        {
            subject = result = tbsCert.getSubject().getX500Principal();
        } //End block
        return (X500Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //X500Principal result = subject;
        //if (result == null) {
            //subject = result = tbsCert.getSubject().getX500Principal();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "42D01D75FA3640E76A288F4F69BBD1FB", hash_generated_method = "ADDB187C59B12653D99CA964A97AE807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date getNotBefore() {
        Date var13C0B2E6CE2C769071DD29A9D2C42C7E_1281206841 = (new Date(getNotBeforeInternal()));
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Date(getNotBeforeInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "4558EB8E531DC796F00773B26346E007", hash_generated_method = "52D804DE88E30A6E84B9FED81556742F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getNotBeforeInternal() {
        long result;
        result = notBefore;
        {
            notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long result = notBefore;
        //if (result == -1) {
            //notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "247B9C82A59BA08F12FC34A8D1043A8F", hash_generated_method = "0CF19992ACBB38BAE364715529BC758A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date getNotAfter() {
        Date var9E8EBB09F607766367FECF4B7791CF68_312563454 = (new Date(getNotAfterInternal()));
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Date(getNotAfterInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "DD249744796DD4B2B8069CA6B07316ED", hash_generated_method = "2095F5F2AF2DF62314DC61FB0BFF58D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getNotAfterInternal() {
        long result;
        result = notAfter;
        {
            notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long result = notAfter;
        //if (result == -1) {
            //notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "713937699882346A31B465214B9B4401", hash_generated_method = "7B159E2AA4E4B8A6C184234FFD787627")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        byte[] varD121FFCD90E6ADE6A3D68F986168F753_1150244514 = (getTbsCertificateInternal().clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return getTbsCertificateInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "3E85018628BFB50292B491E8B8B8C0CD", hash_generated_method = "C044D72007ABAE75DA0792DF275D2C8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] getTbsCertificateInternal() {
        byte[] result;
        result = tbsCertificate;
        {
            tbsCertificate = result = tbsCert.getEncoded();
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] result = tbsCertificate;
        //if (result == null) {
            //tbsCertificate = result = tbsCert.getEncoded();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "EB14E7CDB05E64025ABBA11FDD999629", hash_generated_method = "74C93011F13B67839A606C0D3B1C0412")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getSignature() {
        byte[] var8660F4CDC20C0DBFB019B538EFEA4A71_1283244183 = (getSignatureInternal().clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return getSignatureInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.758 -0400", hash_original_method = "1D526D791318CE6ACD668C92F6511A39", hash_generated_method = "042741864B4A6B833695C28A046E3DE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] getSignatureInternal() {
        byte[] result;
        result = signature;
        {
            signature = result = certificate.getSignatureValue();
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] result = signature;
        //if (result == null) {
            //signature = result = certificate.getSignatureValue();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "36C3BDBBAA85C39CA2DA1792DFF67222", hash_generated_method = "01D1BB770118E4976CDA93359B95A72E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSigAlgName() {
        String result;
        result = sigAlgName;
        {
            String sigAlgOIDLocal;
            sigAlgOIDLocal = getSigAlgOID();
            result = AlgNameMapper.map2AlgName(sigAlgOIDLocal);
            {
                result = sigAlgOIDLocal;
            } //End block
            sigAlgName = result;
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String result = sigAlgName;
        //if (result == null) {
            //String sigAlgOIDLocal = getSigAlgOID();
            //result = AlgNameMapper.map2AlgName(sigAlgOIDLocal);
            //if (result == null) {
                //result = sigAlgOIDLocal;
            //}
            //sigAlgName = result;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "C10B97AA2F949E0770EFB417749475D0", hash_generated_method = "B1B27577172D9B0F9262816EAEF973AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSigAlgOID() {
        String result;
        result = sigAlgOID;
        {
            sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String result = sigAlgOID;
        //if (result == null) {
            //sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "A4F68E4A7ABF2F614B271E042CE68DFD", hash_generated_method = "1771C9DC5C20C5B07C2F981CA51F2878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getSigAlgParams() {
        byte[] result;
        result = sigAlgParams;
        {
            result = tbsCert.getSignature().getParameters();
            {
                nullSigAlgParams = true;
            } //End block
            sigAlgParams = result;
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (nullSigAlgParams) {
            //return null;
        //}
        //byte[] result = sigAlgParams;
        //if (result == null) {
            //result = tbsCert.getSignature().getParameters();
            //if (result == null) {
                //nullSigAlgParams = true;
                //return null;
            //}
            //sigAlgParams = result;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "5910DFD7FE416853E5E8B3596C036798", hash_generated_method = "CF46ED611DECE3CB405C47A54D025A36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean[] getIssuerUniqueID() {
        boolean[] var6AE913DACA7724A438FA1168F4195172_1673853844 = (tbsCert.getIssuerUniqueID());
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //return tbsCert.getIssuerUniqueID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "97AECD47F957244BC2EDB08A3DFA1485", hash_generated_method = "F8CCB1031DEB5E73E1C5D7E6FC4BF9AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean[] getSubjectUniqueID() {
        boolean[] var10A92D91FC90601725707F1A69995DFF_567421358 = (tbsCert.getSubjectUniqueID());
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //return tbsCert.getSubjectUniqueID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "7963F25A7C6EC878E5FE59792F4927CF", hash_generated_method = "2A1D04D2ABFF7FABE3956F96D1ECD7A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean[] getKeyUsage() {
        boolean[] varAAEE1DF4A5AC8C062F13E76F8BCBB670_308512498 = (extensions.valueOfKeyUsage());
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.valueOfKeyUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "879E6EC12A8ACAB06B48BD9054F744F5", hash_generated_method = "8E506F0B4A5989BEA5E2C5F85C82B1F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<String> getExtendedKeyUsage() throws CertificateParsingException {
        try 
        {
            List<String> varDC0B4530127EB020293B9001FDAE069E_711628468 = (extensions.valueOfExtendedKeyUsage());
        } //End block
        catch (IOException e)
        {
            throw new CertificateParsingException(e);
        } //End block
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //try {
            //return extensions.valueOfExtendedKeyUsage();
        //} catch (IOException e) {
            //throw new CertificateParsingException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "338E6CEAECFAB8CF1E7BE34A5E6721D3", hash_generated_method = "8F83874A8277D31FDFCE1C7D1F904658")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBasicConstraints() {
        int var2A969C3C9701091D2359FBAB1716E253_1485552837 = (extensions.valueOfBasicConstrains());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return Integer.MAX_VALUE;
        //}
        //return extensions.valueOfBasicConstrains();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "73F2B21E8EC8FD1E84C605144B87E477", hash_generated_method = "4299C24885C42029336C853F3BA9BEFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
        try 
        {
            Collection<List<?>> varD35C6FC05E45971814152F900CC33832_225627940 = (extensions.valueOfSubjectAlternativeName());
        } //End block
        catch (IOException e)
        {
            throw new CertificateParsingException(e);
        } //End block
        return (Collection<List<?>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //try {
            //return extensions.valueOfSubjectAlternativeName();
        //} catch (IOException e) {
            //throw new CertificateParsingException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "40F7C32C55156DBF6396CA2C21DA2FF4", hash_generated_method = "F385539951DC511A4997945624CB6100")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
        try 
        {
            Collection<List<?>> varE8CBA3CC7B9B73F8362939B7F86388B2_1611844105 = (extensions.valueOfIssuerAlternativeName());
        } //End block
        catch (IOException e)
        {
            throw new CertificateParsingException(e);
        } //End block
        return (Collection<List<?>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //try {
            //return extensions.valueOfIssuerAlternativeName();
        //} catch (IOException e) {
            //throw new CertificateParsingException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "4063CD679B717558744A87C021CCD284", hash_generated_method = "9EAF920D23DF4E1345FF72D12C1ADA08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() throws CertificateEncodingException {
        byte[] varA1F6A04F214F5803CFE149F45ABBF243_770829866 = (getEncodedInternal().clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return getEncodedInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "89DAFF52A0746AEA205DFD1B0F750CF1", hash_generated_method = "22D6330D315B49F108FB304304FB343E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] getEncodedInternal() throws CertificateEncodingException {
        byte[] result;
        result = encoding;
        {
            encoding = result = certificate.getEncoded();
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] result = encoding;
        //if (encoding == null) {
            //encoding = result = certificate.getEncoded();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.759 -0400", hash_original_method = "C29BF4798FFF05217C70FFE55AFF7469", hash_generated_method = "A1DB53BAA1C952010D3BF24BC484C41E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PublicKey getPublicKey() {
        PublicKey result;
        result = publicKey;
        {
            publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        } //End block
        return (PublicKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PublicKey result = publicKey;
        //if (result == null) {
            //publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.760 -0400", hash_original_method = "3446887E135847ED5405A847AD59261D", hash_generated_method = "DC6DB2216BE9FDC7DC27B6D058EB4E18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var7DBA72E3656DD3967C9FF5CE4E5EE4A2_1482400128 = (certificate.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return certificate.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.760 -0400", hash_original_method = "900A10423E0048AD626C0269D411A2B0", hash_generated_method = "A59401F4E4F2DE64508E349EAD86298B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void verify(PublicKey key) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException,
            NoSuchProviderException, SignatureException {
        dsTaint.addTaint(key.dsTaint);
        Signature signature;
        try 
        {
            signature = OpenSSLSignature.getInstance(getSigAlgName());
        } //End block
        catch (NoSuchAlgorithmException ignored)
        {
            signature = Signature.getInstance(getSigAlgName());
        } //End block
        signature.initVerify(key);
        byte[] tbsCertificateLocal;
        tbsCertificateLocal = getTbsCertificateInternal();
        signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        {
            boolean var8A77F4902EA675748C9379BC6E1FD5F4_850346043 = (!signature.verify(certificate.getSignatureValue()));
            {
                throw new SignatureException("Signature was not verified");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Signature signature;
        //try {
            //signature = OpenSSLSignature.getInstance(getSigAlgName());
        //} catch (NoSuchAlgorithmException ignored) {
            //signature = Signature.getInstance(getSigAlgName());
        //}
        //signature.initVerify(key);
        //byte[] tbsCertificateLocal = getTbsCertificateInternal();
        //signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        //if (!signature.verify(certificate.getSignatureValue())) {
            //throw new SignatureException("Signature was not verified");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.760 -0400", hash_original_method = "F86E33551F4B4C0CF1612498F092A43C", hash_generated_method = "F7F4D3AACA629E8A390FE596FD5220B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void verify(PublicKey key, String sigProvider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException,
            NoSuchProviderException, SignatureException {
        dsTaint.addTaint(sigProvider);
        dsTaint.addTaint(key.dsTaint);
        Signature signature;
        try 
        {
            {
                signature = OpenSSLSignature.getInstance(getSigAlgName());
            } //End block
            {
                signature = Signature.getInstance(getSigAlgName(), sigProvider);
            } //End block
        } //End block
        catch (NoSuchAlgorithmException ignored)
        {
            signature = Signature.getInstance(getSigAlgName(), sigProvider);
        } //End block
        signature.initVerify(key);
        byte[] tbsCertificateLocal;
        tbsCertificateLocal = getTbsCertificateInternal();
        signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        {
            boolean var8A77F4902EA675748C9379BC6E1FD5F4_1179292807 = (!signature.verify(certificate.getSignatureValue()));
            {
                throw new SignatureException("Signature was not verified");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Signature signature;
        //try {
            //if (sigProvider == null) {
                //signature = OpenSSLSignature.getInstance(getSigAlgName());
            //} else {
                //signature = Signature.getInstance(getSigAlgName(), sigProvider);
            //}
        //} catch (NoSuchAlgorithmException ignored) {
            //signature = Signature.getInstance(getSigAlgName(), sigProvider);
        //}
        //signature.initVerify(key);
        //byte[] tbsCertificateLocal = getTbsCertificateInternal();
        //signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        //if (!signature.verify(certificate.getSignatureValue())) {
            //throw new SignatureException("Signature was not verified");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.760 -0400", hash_original_method = "D555F516A4047F5D7C4D53CF443DF432", hash_generated_method = "0342731BEE9793FA025A0DEFAF91748A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Set<String> getNonCriticalExtensionOIDs() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Set<String> var48EDFC213E073BC519BBC55F699C857D_1733208821 = (extensions.getNonCriticalExtensions());
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getNonCriticalExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.760 -0400", hash_original_method = "B95147569C30A037580BE18E2484572D", hash_generated_method = "7B6AD1F8623C056068994ADCC6BFFCCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Set<String> getCriticalExtensionOIDs() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Set<String> varE160F8D843FEDD9DE628289805E7996F_1137619056 = (extensions.getCriticalExtensions());
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getCriticalExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.760 -0400", hash_original_method = "46B3B0A81D238D78F58FF04050F493C3", hash_generated_method = "E527196F56CBA986A69DA2EF74CA42BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getExtensionValue(String oid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(oid);
        Extension ext;
        ext = extensions.getExtensionByOID(oid);
        {
            Object var9B2014C61FD04B9534F5C111F996892E_1594052346 = (ext.getRawExtnValue());
        } //End flattened ternary
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //Extension ext = extensions.getExtensionByOID(oid);
        //return (ext == null) ? null : ext.getRawExtnValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.760 -0400", hash_original_method = "CB7B238BECDE285B4B368E69C74FBD34", hash_generated_method = "D2BB4BED2640B442309B338637C6FCCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasUnsupportedCriticalExtension() {
        boolean varCD0035D29141121A191F8784F441BF54_1037944860 = (extensions.hasUnsupportedCritical());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return false;
        //}
        //return extensions.hasUnsupportedCritical();
    }

    
}


