package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractOwnableSynchronizer implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.978 -0400", hash_original_field = "132FCF3C7BFF939868B511E35AD62FD4", hash_generated_field = "C1E5D5F5CE2C40C66D9F63320FBEDDDF")

    private transient Thread exclusiveOwnerThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.979 -0400", hash_original_method = "09FACEDDA2CFE0BD4863CBAC9CCC5DB1", hash_generated_method = "D297C3151434464F48AC3AE139C059A0")
    protected  AbstractOwnableSynchronizer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.980 -0400", hash_original_method = "54BE2CB7A2B251833C1274201519DC0B", hash_generated_method = "13F014A12C92310672C211F0153DBA38")
    protected final void setExclusiveOwnerThread(Thread t) {
        exclusiveOwnerThread = t;
        // ---------- Original Method ----------
        //exclusiveOwnerThread = t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.980 -0400", hash_original_method = "B27D03344136636BB9AA0892188CCAE3", hash_generated_method = "2EE7F1EC5AC7B8D323A04C1BFEF1195B")
    protected final Thread getExclusiveOwnerThread() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_1689636751 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1689636751 = exclusiveOwnerThread;
        varB4EAC82CA7396A68D541C85D26508E83_1689636751.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1689636751;
        // ---------- Original Method ----------
        //return exclusiveOwnerThread;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.980 -0400", hash_original_field = "FA409379A41D70A7326C19C768F673CD", hash_generated_field = "25430D836D37689CA03BCD07500FFC72")

    private static long serialVersionUID = 3737899427754241961L;
}

