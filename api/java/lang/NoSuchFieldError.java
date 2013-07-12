package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class NoSuchFieldError extends IncompatibleClassChangeError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.024 -0400", hash_original_method = "F8D799539E9A974C8BB35DC17F7C342D", hash_generated_method = "F310D0DF0C26994229A44A3EEEF18445")
    public  NoSuchFieldError() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.024 -0400", hash_original_method = "18AA8F00FBF3130F84A1236717EEB4A7", hash_generated_method = "0EFA84EA99FF806B4CF8E9A39B8D5343")
    public  NoSuchFieldError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.025 -0400", hash_original_field = "7619DA8FAE56FFEB65AC088E02923838", hash_generated_field = "39947703B673C19D13F76ABAA2393C33")

    private static final long serialVersionUID = -3456430195886129035L;
}

