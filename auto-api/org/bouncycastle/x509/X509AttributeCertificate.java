package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Extension;
import java.util.Date;

public interface X509AttributeCertificate
    extends X509Extension
{   
    
    public int getVersion();
    
    
    public BigInteger getSerialNumber();
    
    
    public Date getNotBefore();
    
    
    public Date getNotAfter();
    
    
    public AttributeCertificateHolder getHolder();
    
    
    public AttributeCertificateIssuer getIssuer();
    
    
    public X509Attribute[] getAttributes();
    
    
    public X509Attribute[] getAttributes(String oid);
    
    public boolean[] getIssuerUniqueID();
    
    public void checkValidity()
        throws CertificateExpiredException, CertificateNotYetValidException;
    
    public void checkValidity(Date date)
        throws CertificateExpiredException, CertificateNotYetValidException;
    
    public byte[] getSignature();
    
    public void verify(PublicKey key, String provider)
            throws CertificateException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchProviderException, SignatureException;
    
    
    public byte[] getEncoded()
        throws IOException;
}
