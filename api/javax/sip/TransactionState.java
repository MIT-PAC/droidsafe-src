package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public enum TransactionState {
    CALLING,
    TRYING,
    PROCEEDING,
    COMPLETED,
    CONFIRMED,
    TERMINATED;
}
