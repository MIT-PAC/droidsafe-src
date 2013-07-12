package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class IccVmNotSupportedException extends IccException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.822 -0400", hash_original_method = "0DA609D1A800BAC68D629EBC1C71BABF", hash_generated_method = "F1E2078F5B9AA92FE4573BDAF4BBC2A5")
      IccVmNotSupportedException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.822 -0400", hash_original_method = "BF0F5F61FF78864DF45F6E5D7B53B506", hash_generated_method = "5075D249EE9D82B05CBAE91FA6E47938")
    public  IccVmNotSupportedException(String s) {
        super(s);
        addTaint(s.getTaint());
        
    }

    
}

