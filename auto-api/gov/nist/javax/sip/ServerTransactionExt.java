package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.ServerTransaction;

public interface ServerTransactionExt extends ServerTransaction, TransactionExt {
    
    public ServerTransaction getCanceledInviteTransaction();
}
