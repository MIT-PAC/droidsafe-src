package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TimeoutEvent extends TransactionTerminatedEvent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.568 -0400", hash_original_field = "A6EFB54FFD2811DD57158A62FDEF145A", hash_generated_field = "FE277A87B690B80ED89C5FD5CAD03096")

    private Timeout mTimeout;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.569 -0400", hash_original_method = "B54F2DD7A2EA500C648BF1D67EA727CB", hash_generated_method = "82F9C3444CA0666BEBB0A5B15954E30F")
    public  TimeoutEvent(Object source, ServerTransaction serverTransaction,
            Timeout timeout) {
        super(source, serverTransaction);
        mTimeout = timeout;
        addTaint(source.getTaint());
        addTaint(serverTransaction.getTaint());
        // ---------- Original Method ----------
        //mTimeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.569 -0400", hash_original_method = "E3A1CE6AED4C8EB398A7A856D4DC19D6", hash_generated_method = "CC1A003E1C5D902AC4213A08853B3E48")
    public  TimeoutEvent(Object source, ClientTransaction clientTransaction,
            Timeout timeout) {
        super(source, clientTransaction);
        mTimeout = timeout;
        addTaint(source.getTaint());
        addTaint(clientTransaction.getTaint());
        // ---------- Original Method ----------
        //mTimeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.571 -0400", hash_original_method = "83172AE614FED36EC49043A629BB9E54", hash_generated_method = "7C869CF0A875C30C47A688EFBF4A5AA4")
    public Timeout getTimeout() {
        Timeout varB4EAC82CA7396A68D541C85D26508E83_400026343 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_400026343 = mTimeout;
        varB4EAC82CA7396A68D541C85D26508E83_400026343.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_400026343;
        // ---------- Original Method ----------
        //return mTimeout;
    }

    
}

