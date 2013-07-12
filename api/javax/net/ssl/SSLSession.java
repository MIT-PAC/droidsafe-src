package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.Principal;
import java.security.cert.Certificate;
import javax.security.cert.X509Certificate;

public interface SSLSession {

    
    public int getApplicationBufferSize();

    
    public String getCipherSuite();

    
    public long getCreationTime();

    
    public byte[] getId();

    
    public long getLastAccessedTime();

    
    public Certificate[] getLocalCertificates();

    
    public Principal getLocalPrincipal();

    
    public int getPacketBufferSize();

    
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException;

    
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException;

    
    public String getPeerHost();

    
    public int getPeerPort();

    
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException;

    
    public String getProtocol();

    
    public SSLSessionContext getSessionContext();

    
    public Object getValue(String name);

    
    public String[] getValueNames();

    
    public void invalidate();

    
    public boolean isValid();

    
    public void putValue(String name, Object value);

    
    public void removeValue(String name);
}
