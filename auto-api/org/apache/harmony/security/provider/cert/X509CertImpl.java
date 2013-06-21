package org.apache.harmony.security.provider.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private Certificate certificate;
    private TBSCertificate tbsCert;
    private Extensions extensions;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.257 -0400", hash_original_method = "8B0F316F14E4B2EBE1AD9D0407358FB5", hash_generated_method = "564DCC841B20CF1E02C9FA094A26D003")
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
            if (DroidSafeAndroidRuntime.control) throw new CertificateException(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.257 -0400", hash_original_method = "8876B8D60330C38B32B3F1E3F7F33D8F", hash_generated_method = "E99835B88AD6504B8CCBB22253385AF4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.258 -0400", hash_original_method = "9C90F0AD6131A4566D6AF431EC38BE50", hash_generated_method = "1460408BC494A9AA9F09628619E1829D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X509CertImpl(byte[] encoding) throws IOException {
        this((Certificate) Certificate.ASN1.decode(encoding));
        dsTaint.addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.258 -0400", hash_original_method = "92CEFDF21FC191A18696C43CA9E48D20", hash_generated_method = "2E8592797B80F07DB9D925974C99BF53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(System.currentTimeMillis());
        // ---------- Original Method ----------
        //checkValidity(System.currentTimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.258 -0400", hash_original_method = "59C6435E22C5BAEC0B6376C8B7A5112D", hash_generated_method = "D4C2D1174FA79830C751BD458C10F69B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        dsTaint.addTaint(date.dsTaint);
        checkValidity(date.getTime());
        // ---------- Original Method ----------
        //checkValidity(date.getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.258 -0400", hash_original_method = "5C762410FB306F1308EE7204752B0EB0", hash_generated_method = "97FCA4FCEF724DBA8BAF7C39BE50D7D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkValidity(long time) throws CertificateExpiredException, CertificateNotYetValidException {
        dsTaint.addTaint(time);
        {
            boolean var264F16FDDA2F76F2C6FA01CF75941728_1452795458 = (time < getNotBeforeInternal());
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateNotYetValidException("current time: " + new Date(time)
                + ", validation time: " + new Date(getNotBeforeInternal()));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2AB2BCD0EA9D992C8DA2E852EA2D3B2C_2031125766 = (time > getNotAfterInternal());
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateExpiredException("current time: " + new Date(time)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.259 -0400", hash_original_method = "89D7F1BE0C395C13D4A43DDDB6D84533", hash_generated_method = "CE3587702422B0E1E8BC08933549DA4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVersion() {
        int var14209A0688FE80EBFD09C9716EC0F554_48981102 = (tbsCert.getVersion() + 1);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return tbsCert.getVersion() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.259 -0400", hash_original_method = "CC90380181A21ABFD0C1237D9F2C9838", hash_generated_method = "E48CC5A330A7A2057C7626F63B9D0044")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.259 -0400", hash_original_method = "2552251E229FA5F4C4BC8254C0633556", hash_generated_method = "345AF31309BA15008355023CEC45F75E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getIssuerDN() {
        Principal varA20FA15F778F0CB50B99F7227270B53E_203540067 = (getIssuerX500Principal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getIssuerX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.259 -0400", hash_original_method = "B82B3361EE6501B1AD6CD55F9554225E", hash_generated_method = "87A8D61667DBAFF11C3F03C11137015D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.259 -0400", hash_original_method = "57EE376613339C3801C08A778AAA92CE", hash_generated_method = "9A0D555C6547EE55127BC247FB944648")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getSubjectDN() {
        Principal varBC9861BDB209444EEDE43C1600F8D706_1308438817 = (getSubjectX500Principal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.260 -0400", hash_original_method = "50D7E6DD1BE4A80FFE9B722B1EC59064", hash_generated_method = "85CB72B3EF1CFF43873005C578691A78")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.260 -0400", hash_original_method = "42D01D75FA3640E76A288F4F69BBD1FB", hash_generated_method = "B0DE815F70AD4826DD0879160608A6FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date getNotBefore() {
        Date var13C0B2E6CE2C769071DD29A9D2C42C7E_217162561 = (new Date(getNotBeforeInternal()));
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Date(getNotBeforeInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.260 -0400", hash_original_method = "4558EB8E531DC796F00773B26346E007", hash_generated_method = "C206836198B530A9E5C1B5D8F88C865C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.260 -0400", hash_original_method = "247B9C82A59BA08F12FC34A8D1043A8F", hash_generated_method = "6F6A69101B73857EAF8796881DC8B344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date getNotAfter() {
        Date var9E8EBB09F607766367FECF4B7791CF68_1767007232 = (new Date(getNotAfterInternal()));
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Date(getNotAfterInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.261 -0400", hash_original_method = "DD249744796DD4B2B8069CA6B07316ED", hash_generated_method = "B71A7976AC6E5D158850220B70B1FF50")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.261 -0400", hash_original_method = "713937699882346A31B465214B9B4401", hash_generated_method = "B52AE8639A2241F651DE3A1F1657395B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        byte[] varD121FFCD90E6ADE6A3D68F986168F753_968762770 = (getTbsCertificateInternal().clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return getTbsCertificateInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.261 -0400", hash_original_method = "3E85018628BFB50292B491E8B8B8C0CD", hash_generated_method = "2BB4ED9FA37239A76986520DD8A43AC6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.261 -0400", hash_original_method = "EB14E7CDB05E64025ABBA11FDD999629", hash_generated_method = "9E312BCC92BD149C187D44806BBAB555")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getSignature() {
        byte[] var8660F4CDC20C0DBFB019B538EFEA4A71_988573594 = (getSignatureInternal().clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return getSignatureInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.261 -0400", hash_original_method = "1D526D791318CE6ACD668C92F6511A39", hash_generated_method = "AEF982F17527966705983D39915D158C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.262 -0400", hash_original_method = "36C3BDBBAA85C39CA2DA1792DFF67222", hash_generated_method = "494573975C1035A649FA51FA18B050FD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.262 -0400", hash_original_method = "C10B97AA2F949E0770EFB417749475D0", hash_generated_method = "D790DF57558B9DBA434923B93B85511D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.262 -0400", hash_original_method = "A4F68E4A7ABF2F614B271E042CE68DFD", hash_generated_method = "5CD2ACA50283896E18CBA98C4F7FDCE5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.262 -0400", hash_original_method = "5910DFD7FE416853E5E8B3596C036798", hash_generated_method = "9C5949DC9053B6B2CA3621BA0B178EBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean[] getIssuerUniqueID() {
        boolean[] var6AE913DACA7724A438FA1168F4195172_309587194 = (tbsCert.getIssuerUniqueID());
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //return tbsCert.getIssuerUniqueID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.263 -0400", hash_original_method = "97AECD47F957244BC2EDB08A3DFA1485", hash_generated_method = "6E3536A0511B3BBCE1E007A00E17A58E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean[] getSubjectUniqueID() {
        boolean[] var10A92D91FC90601725707F1A69995DFF_497192651 = (tbsCert.getSubjectUniqueID());
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //return tbsCert.getSubjectUniqueID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.263 -0400", hash_original_method = "7963F25A7C6EC878E5FE59792F4927CF", hash_generated_method = "C0676B2F340CA744463221AE2B933C1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean[] getKeyUsage() {
        boolean[] varAAEE1DF4A5AC8C062F13E76F8BCBB670_1024888568 = (extensions.valueOfKeyUsage());
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.valueOfKeyUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.263 -0400", hash_original_method = "879E6EC12A8ACAB06B48BD9054F744F5", hash_generated_method = "B3F087AF08917B6F5B82F4F5EEFFA9A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<String> getExtendedKeyUsage() throws CertificateParsingException {
        try 
        {
            List<String> varDC0B4530127EB020293B9001FDAE069E_516587751 = (extensions.valueOfExtendedKeyUsage());
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.263 -0400", hash_original_method = "338E6CEAECFAB8CF1E7BE34A5E6721D3", hash_generated_method = "F23358A2DD76EA79AF5E3C41BF623D56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBasicConstraints() {
        int var2A969C3C9701091D2359FBAB1716E253_1674781777 = (extensions.valueOfBasicConstrains());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return Integer.MAX_VALUE;
        //}
        //return extensions.valueOfBasicConstrains();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.264 -0400", hash_original_method = "73F2B21E8EC8FD1E84C605144B87E477", hash_generated_method = "0A2BAEF2AFEE4D0A2F5B061DDC30E09F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
        try 
        {
            Collection<List<?>> varD35C6FC05E45971814152F900CC33832_1818086751 = (extensions.valueOfSubjectAlternativeName());
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.264 -0400", hash_original_method = "40F7C32C55156DBF6396CA2C21DA2FF4", hash_generated_method = "BC7FAC5C76F8435DD5CF203275F30858")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
        try 
        {
            Collection<List<?>> varE8CBA3CC7B9B73F8362939B7F86388B2_1010607569 = (extensions.valueOfIssuerAlternativeName());
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.264 -0400", hash_original_method = "4063CD679B717558744A87C021CCD284", hash_generated_method = "02512D9127A4B199001A046545C5E5BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() throws CertificateEncodingException {
        byte[] varA1F6A04F214F5803CFE149F45ABBF243_828669060 = (getEncodedInternal().clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return getEncodedInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.264 -0400", hash_original_method = "89DAFF52A0746AEA205DFD1B0F750CF1", hash_generated_method = "93DEF9B9FCB65EF8DDC65DA386173E6B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.265 -0400", hash_original_method = "C29BF4798FFF05217C70FFE55AFF7469", hash_generated_method = "D304D1F86DCA428F9B669DE9031A9020")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.265 -0400", hash_original_method = "3446887E135847ED5405A847AD59261D", hash_generated_method = "75C78530195D2097038FAAA6E9E2D756")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var7DBA72E3656DD3967C9FF5CE4E5EE4A2_2030359237 = (certificate.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return certificate.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.265 -0400", hash_original_method = "900A10423E0048AD626C0269D411A2B0", hash_generated_method = "4ABB34AF92C4CEBD1E333503AC5CAEF7")
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
            boolean var8A77F4902EA675748C9379BC6E1FD5F4_1393980647 = (!signature.verify(certificate.getSignatureValue()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature was not verified");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.265 -0400", hash_original_method = "F86E33551F4B4C0CF1612498F092A43C", hash_generated_method = "2AB348C95534E415F4091DBDA14CA44F")
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
            boolean var8A77F4902EA675748C9379BC6E1FD5F4_485841099 = (!signature.verify(certificate.getSignatureValue()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature was not verified");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.266 -0400", hash_original_method = "D555F516A4047F5D7C4D53CF443DF432", hash_generated_method = "72C5AB380BA730C207023E393E8BC3BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Set<String> getNonCriticalExtensionOIDs() {
        Set<String> var48EDFC213E073BC519BBC55F699C857D_1471043453 = (extensions.getNonCriticalExtensions());
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getNonCriticalExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.266 -0400", hash_original_method = "B95147569C30A037580BE18E2484572D", hash_generated_method = "FC60633B509BBA1BCF4908A60FD8B877")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Set<String> getCriticalExtensionOIDs() {
        Set<String> varE160F8D843FEDD9DE628289805E7996F_1104160952 = (extensions.getCriticalExtensions());
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getCriticalExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.266 -0400", hash_original_method = "46B3B0A81D238D78F58FF04050F493C3", hash_generated_method = "E3D86BDAB31628B20C75208AEF4761D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getExtensionValue(String oid) {
        dsTaint.addTaint(oid);
        Extension ext;
        ext = extensions.getExtensionByOID(oid);
        {
            Object var9B2014C61FD04B9534F5C111F996892E_532353822 = (ext.getRawExtnValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.267 -0400", hash_original_method = "CB7B238BECDE285B4B368E69C74FBD34", hash_generated_method = "736A4E705E912FDF7C1426AFB22D8C5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasUnsupportedCriticalExtension() {
        boolean varCD0035D29141121A191F8784F441BF54_1319526448 = (extensions.hasUnsupportedCritical());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return false;
        //}
        //return extensions.hasUnsupportedCritical();
    }

    
    private static final long serialVersionUID = 2972248729446736154L;
}

