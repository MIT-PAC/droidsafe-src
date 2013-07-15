package javax.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.277 -0400", hash_original_method = "0337B060243DB2E8E059CE304C023100", hash_generated_method = "9BA920E90C5C7EE22A37FD86BC262ED2")
    public  X509Certificate() {
        // ---------- Original Method ----------
    }

    
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.278 -0400", hash_original_field = "6CA268371EEB5D93EEFEB68F96157666", hash_generated_field = "2112A4F4A023E8F770192D2021400B78")

    private static Constructor constructor;
    static {
        try {
            String classname = Security.getProperty("cert.provider.x509v1");
            Class cl = Class.forName(classname);
            constructor = cl.getConstructor(new Class[] {InputStream.class});
        } catch (Throwable e) {
        }
    }
    
}

