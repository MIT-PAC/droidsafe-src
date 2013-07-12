package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.sip.ClientTransaction;
import javax.sip.Timeout;
import javax.sip.address.Hop;

public interface ClientTransactionExt extends ClientTransaction, TransactionExt {

    
    public void setNotifyOnRetransmit(boolean flag);

    
    public void alertIfStillInCallingStateBy(int count);
    
    
    public Hop getNextHop();
    
    
    public boolean isSecure();
    
  
   
   

}
