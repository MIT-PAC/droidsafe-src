package org.bouncycastle.util.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class StreamOverflowException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.343 -0400", hash_original_method = "C7AF2A0432EDE6CAD02BD9333B19DFB6", hash_generated_method = "72D322407F063B295C92BD25AF6DD40A")
    public  StreamOverflowException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

