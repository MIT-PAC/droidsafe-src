package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.cert.Certificate;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.sip.SipProvider;
import javax.sip.Transaction;

public interface TransactionExt extends Transaction {

    
    public SipProvider getSipProvider();

    
    public String getPeerAddress();
    
    public int getPeerPort();
    
    public String getTransport();

    
    public String getHost();
    
    public int getPort();
    
    
    public String getCipherSuite() throws UnsupportedOperationException;
    
    
   Certificate[] getLocalCertificates() throws UnsupportedOperationException;
    
    
   Certificate[]  getPeerCertificates() throws SSLPeerUnverifiedException;
}
