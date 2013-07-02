package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import  gov.nist.javax.sip.stack.*;
import  java.util.*;

class EventWrapper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.615 -0400", hash_original_field = "E00A136CA217047ABA7197AA403F57C7", hash_generated_field = "D0CD1A8921064AE307FBC0EABE6947D1")

    protected EventObject sipEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.615 -0400", hash_original_field = "F4D5B76A2418EBA4BAEABC1ED9142B54", hash_generated_field = "847357ABBC10F2A5746EB93EE9B9842D")

    protected SIPTransaction transaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.615 -0400", hash_original_method = "90A52EB1D7464A6D23F549B5DAB9B818", hash_generated_method = "5F0F269D069D41C60DD94AC4EC33879F")
      EventWrapper(EventObject sipEvent, SIPTransaction transaction) {
        this.sipEvent = sipEvent;
        this.transaction = transaction;
        
        
        
    }

    
}

