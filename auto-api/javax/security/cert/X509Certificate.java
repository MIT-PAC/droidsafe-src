package javax.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.util.Date;

public abstract class X509Certificate extends Certificate {
    private static Constructor constructor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.509 -0400", hash_original_method = "0337B060243DB2E8E059CE304C023100", hash_generated_method = "460B224B2237B305BCFCD2A5573D70E4")
    @DSModeled(DSC.SAFE)
    public X509Certificate() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.510 -0400", hash_original_method = "87F1229CF520DB9BF87CB67582242D96", hash_generated_method = "B3DF29D7D73306426D18F71AD1526C77")
    public static final X509Certificate getInstance(InputStream inStream) throws CertificateException {
        if (inStream == null) {
            throw new CertificateException("inStream == null");
        }
        if (constructor != null) {
            try {
                return (X509Certificate)
                    constructor.newInstance(new Object[] {inStream});
            } catch (Throwable e) {
                throw new CertificateException(e.getMessage());
            }
        }
        final java.security.cert.X509Certificate cert;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            cert = (java.security.cert.X509Certificate)
                                            cf.generateCertificate(inStream);
        } catch (java.security.cert.CertificateException e) {
            throw new CertificateException(e.getMessage());
        }
        return new X509Certificate() {
            public byte[] getEncoded() throws CertificateEncodingException {
                try {
                    return cert.getEncoded();
                } catch (java.security.cert.CertificateEncodingException e) {
                    throw new CertificateEncodingException(e.getMessage());
                }
            }
            public void verify(PublicKey key) throws CertificateException,
                                NoSuchAlgorithmException, InvalidKeyException,
                                NoSuchProviderException, SignatureException {
                try {
                    cert.verify(key);
                } catch (java.security.cert.CertificateException e) {
                    throw new CertificateException(e.getMessage());
                }
            }
            public void verify(PublicKey key, String sigProvider)
                            throws CertificateException,
                                NoSuchAlgorithmException, InvalidKeyException,
                                NoSuchProviderException, SignatureException {
                try {
                    cert.verify(key, sigProvider);
                } catch (java.security.cert.CertificateException e) {
                    throw new CertificateException(e.getMessage());
                }
            }
            public String toString() {
                return cert.toString();
            }
            public PublicKey getPublicKey() {
                return cert.getPublicKey();
            }
            public void checkValidity() throws CertificateExpiredException,
                                   CertificateNotYetValidException {
                try {
                    cert.checkValidity();
                } catch (java.security.cert.CertificateNotYetValidException e) {
                    throw new CertificateNotYetValidException(e.getMessage());
                } catch (java.security.cert.CertificateExpiredException e) {
                    throw new CertificateExpiredException(e.getMessage());
                }
            }
            public void checkValidity(Date date)
                            throws CertificateExpiredException,
                                   CertificateNotYetValidException {
                try {
                    cert.checkValidity(date);
                } catch (java.security.cert.CertificateNotYetValidException e) {
                    throw new CertificateNotYetValidException(e.getMessage());
                } catch (java.security.cert.CertificateExpiredException e) {
                    throw new CertificateExpiredException(e.getMessage());
                }
            }
            public int getVersion() {
                return 2;
            }
            public BigInteger getSerialNumber() {
                return cert.getSerialNumber();
            }
            public Principal getIssuerDN() {
                return cert.getIssuerDN();
            }
            public Principal getSubjectDN() {
                return cert.getSubjectDN();
            }
            public Date getNotBefore() {
                return cert.getNotBefore();
            }
            public Date getNotAfter() {
                return cert.getNotAfter();
            }
            public String getSigAlgName() {
                return cert.getSigAlgName();
            }
            public String getSigAlgOID() {
                return cert.getSigAlgOID();
            }
            public byte[] getSigAlgParams() {
                return cert.getSigAlgParams();
            }
        };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.510 -0400", hash_original_method = "4740B2B56500AAF60D83C231AF13C259", hash_generated_method = "0C866782C071AAF4B318273EC6BE3C9F")
    public static final X509Certificate getInstance(byte[] certData) throws CertificateException {
        if (certData == null) {
            throw new CertificateException("certData == null");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(certData);
        return getInstance(bais);
    }

    
    public abstract void checkValidity()
            throws CertificateExpiredException, CertificateNotYetValidException;

    
    public abstract void checkValidity(Date date)
            throws CertificateExpiredException, CertificateNotYetValidException;

    
    public abstract int getVersion();

    
    public abstract BigInteger getSerialNumber();

    
    public abstract Principal getIssuerDN();

    
    public abstract Principal getSubjectDN();

    
    public abstract Date getNotBefore();

    
    public abstract Date getNotAfter();

    
    public abstract String getSigAlgName();

    
    public abstract String getSigAlgOID();

    
    public abstract byte[] getSigAlgParams();

    
    static {
        try {
            String classname = Security.getProperty("cert.provider.x509v1");
            Class cl = Class.forName(classname);
            constructor = cl.getConstructor(new Class[] {InputStream.class});
        } catch (Throwable e) {
        }
    }
    
}


