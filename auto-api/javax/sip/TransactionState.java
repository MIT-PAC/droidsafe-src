package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public enum TransactionState {
    CALLING,
    TRYING,
    PROCEEDING,
    COMPLETED,
    CONFIRMED,
    TERMINATED;
}
