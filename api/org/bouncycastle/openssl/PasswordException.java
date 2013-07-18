package org.bouncycastle.openssl;

// Droidsafe Imports
import java.io.IOException;

import droidsafe.annotations.DSGenerator;

public class PasswordException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.135 -0400", hash_original_method = "C6899838B1393DC816DA483F96511D69", hash_generated_method = "C013E4B6A962A13D202F4C30483D4CC7")
    public  PasswordException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

