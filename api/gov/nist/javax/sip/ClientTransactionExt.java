package gov.nist.javax.sip;

// Droidsafe Imports
import javax.sip.ClientTransaction;
import javax.sip.address.Hop;

public interface ClientTransactionExt extends ClientTransaction, TransactionExt {

    
    public void setNotifyOnRetransmit(boolean flag);

    
    public void alertIfStillInCallingStateBy(int count);
    
    
    public Hop getNextHop();
    
    
    public boolean isSecure();
    
  
   
   

}
