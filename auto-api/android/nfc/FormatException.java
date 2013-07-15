package android.nfc;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class FormatException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.866 -0400", hash_original_method = "19906B432E20947B07A71D239CA16EA4", hash_generated_method = "48A5F362D262A9A6FDB97D1CD90A6C9E")
    public  FormatException() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.866 -0400", hash_original_method = "E158CC912978354EA0BE368A340B0E91", hash_generated_method = "178DA21D6F45A601BD91C4B93FC15991")
    public  FormatException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
}

