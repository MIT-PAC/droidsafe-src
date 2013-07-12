package java.util.concurrent.locks;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class AbstractOwnableSynchronizer implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.704 -0400", hash_original_field = "132FCF3C7BFF939868B511E35AD62FD4", hash_generated_field = "C1E5D5F5CE2C40C66D9F63320FBEDDDF")

    private transient Thread exclusiveOwnerThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.704 -0400", hash_original_method = "09FACEDDA2CFE0BD4863CBAC9CCC5DB1", hash_generated_method = "D297C3151434464F48AC3AE139C059A0")
    protected  AbstractOwnableSynchronizer() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.705 -0400", hash_original_method = "54BE2CB7A2B251833C1274201519DC0B", hash_generated_method = "13F014A12C92310672C211F0153DBA38")
    protected final void setExclusiveOwnerThread(Thread t) {
        exclusiveOwnerThread = t;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.705 -0400", hash_original_method = "B27D03344136636BB9AA0892188CCAE3", hash_generated_method = "286346CCED9621403ACC2B5CE7B3D544")
    protected final Thread getExclusiveOwnerThread() {
Thread var1272617ED476BD050F7F4F8E5B1A0ED8_1234075037 =         exclusiveOwnerThread;
        var1272617ED476BD050F7F4F8E5B1A0ED8_1234075037.addTaint(taint);
        return var1272617ED476BD050F7F4F8E5B1A0ED8_1234075037;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.705 -0400", hash_original_field = "FA409379A41D70A7326C19C768F673CD", hash_generated_field = "F2F59C783D5C1305604BF875D65980D6")

    private static final long serialVersionUID = 3737899427754241961L;
}

