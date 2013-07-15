package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.address.Hop;
import javax.sip.address.Router;

public interface RouterExt extends Router {
    
    
    public void transactionTimeout(Hop hop);

}
