package java.util.concurrent.locks;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class AbstractOwnableSynchronizer implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.590 -0400", hash_original_field = "132FCF3C7BFF939868B511E35AD62FD4", hash_generated_field = "C1E5D5F5CE2C40C66D9F63320FBEDDDF")

    private transient Thread exclusiveOwnerThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.591 -0400", hash_original_method = "09FACEDDA2CFE0BD4863CBAC9CCC5DB1", hash_generated_method = "D297C3151434464F48AC3AE139C059A0")
    protected  AbstractOwnableSynchronizer() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.592 -0400", hash_original_method = "54BE2CB7A2B251833C1274201519DC0B", hash_generated_method = "13F014A12C92310672C211F0153DBA38")
    protected final void setExclusiveOwnerThread(Thread t) {
        exclusiveOwnerThread = t;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.593 -0400", hash_original_method = "B27D03344136636BB9AA0892188CCAE3", hash_generated_method = "80F8FCFC69B4D9A39440A6B2DB950EA7")
    protected final Thread getExclusiveOwnerThread() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_449850095 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_449850095 = exclusiveOwnerThread;
        varB4EAC82CA7396A68D541C85D26508E83_449850095.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_449850095;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.593 -0400", hash_original_field = "FA409379A41D70A7326C19C768F673CD", hash_generated_field = "F2F59C783D5C1305604BF875D65980D6")

    private static final long serialVersionUID = 3737899427754241961L;
}

