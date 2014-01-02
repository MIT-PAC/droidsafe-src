package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.stack.SIPTransaction;

import java.util.EventObject;






class EventWrapper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.978 -0500", hash_original_field = "E84A2CBDB23197FA1FA24434515194D4", hash_generated_field = "D0CD1A8921064AE307FBC0EABE6947D1")


    protected EventObject sipEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.980 -0500", hash_original_field = "F62E9F7B8B14D3FE575E8796200D5FC1", hash_generated_field = "847357ABBC10F2A5746EB93EE9B9842D")

    protected SIPTransaction transaction;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.983 -0500", hash_original_method = "90A52EB1D7464A6D23F549B5DAB9B818", hash_generated_method = "90A52EB1D7464A6D23F549B5DAB9B818")
    
EventWrapper(EventObject sipEvent, SIPTransaction transaction) {
        this.sipEvent = sipEvent;
        this.transaction = transaction;
    }

    
}

