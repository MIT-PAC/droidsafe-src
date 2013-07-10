package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class InterruptedException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.244 -0400", hash_original_method = "276D0C061081F968E041F3504D86F3DC", hash_generated_method = "54C005F360CF44F1F3D0FBF84E1920CD")
    public  InterruptedException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.244 -0400", hash_original_method = "47A24B4A9D41770C1E928AFF25C6693A", hash_generated_method = "C08CFFB48BC1BEA2415DC4DBEA5EF44C")
    public  InterruptedException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.244 -0400", hash_original_field = "62AFE00859395BA49202B2CFC900B3DF", hash_generated_field = "D6A522235FA0337AFC71B5905EFDB292")

    private static final long serialVersionUID = 6700697376100628473L;
}

