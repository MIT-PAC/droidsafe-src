package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.AndroidRuntimeException;

public class ReceiverCallNotAllowedException extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.251 -0400", hash_original_method = "AFC9E27B420303F62AF3B362BCC79465", hash_generated_method = "A9BA6CA01738F043FA6EE9601C06B57B")
    public  ReceiverCallNotAllowedException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
}

