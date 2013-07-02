package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class AndroidRuntimeException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.136 -0400", hash_original_method = "8C5786A2A5252DB156BAEEC9B2143392", hash_generated_method = "41A0B8709066AE39095C72A04CE366E3")
    public  AndroidRuntimeException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.136 -0400", hash_original_method = "8B3545FC9B2683E7AFCB1B7C9932589B", hash_generated_method = "1D7FD430E80B4B3FE1A4A2D245C35C11")
    public  AndroidRuntimeException(String name) {
        super(name);
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.136 -0400", hash_original_method = "396EB52B778995BFC6A3E50EA6AAC7F8", hash_generated_method = "B3B31C9159CDEB4696FDA6DD647D7A2A")
    public  AndroidRuntimeException(String name, Throwable cause) {
        super(name, cause);
        addTaint(name.getTaint());
        addTaint(cause.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.137 -0400", hash_original_method = "ED4D86824E00309868D3D3E5627C1A8D", hash_generated_method = "30786B2133AD70CFDE4A2E8623A37974")
    public  AndroidRuntimeException(Exception cause) {
        super(cause);
        addTaint(cause.getTaint());
        
    }

    
}

