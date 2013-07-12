package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public enum TransactionState {
    CALLING,
    TRYING,
    PROCEEDING,
    COMPLETED,
    CONFIRMED,
    TERMINATED;
}
