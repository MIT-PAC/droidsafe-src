package gov.nist.javax.sip.address;

// Droidsafe Imports
import javax.sip.address.Hop;
import javax.sip.address.Router;

public interface RouterExt extends Router {
    
    
    public void transactionTimeout(Hop hop);

}
