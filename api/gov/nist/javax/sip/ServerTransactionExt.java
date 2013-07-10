package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.ServerTransaction;

public interface ServerTransactionExt extends ServerTransaction, TransactionExt {
    
    public ServerTransaction getCanceledInviteTransaction();
}
