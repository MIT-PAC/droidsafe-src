package javax.security.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class DestroyFailedException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.997 -0400", hash_original_method = "22F1E573FCB9B888944769B0D578ECFF", hash_generated_method = "625155947AD09CAB3856E8CDF9BE43F0")
    public  DestroyFailedException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.997 -0400", hash_original_method = "49DB9D74B82421E273A368ED4AD8049A", hash_generated_method = "1C116CEBFB0E50E54BBB1395893F9B9C")
    public  DestroyFailedException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.997 -0400", hash_original_field = "BDD9F7635817EE9CFFDB503F651F0550", hash_generated_field = "D46412D2433956C0DBCFF8D8717318CC")

    private static final long serialVersionUID = -7790152857282749162L;
}

