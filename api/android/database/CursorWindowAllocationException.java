package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class CursorWindowAllocationException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.177 -0400", hash_original_method = "643AF47320B69D20A3CAAFE0EBF7408E", hash_generated_method = "A8BE46BB9DCA03A3BEEE97E28F5704CA")
    public  CursorWindowAllocationException(String description) {
        super(description);
        addTaint(description.getTaint());
        
    }

    
}

