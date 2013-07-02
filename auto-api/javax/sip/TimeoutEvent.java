package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class TimeoutEvent extends TransactionTerminatedEvent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.103 -0400", hash_original_field = "A6EFB54FFD2811DD57158A62FDEF145A", hash_generated_field = "FE277A87B690B80ED89C5FD5CAD03096")

    private Timeout mTimeout;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.104 -0400", hash_original_method = "B54F2DD7A2EA500C648BF1D67EA727CB", hash_generated_method = "82F9C3444CA0666BEBB0A5B15954E30F")
    public  TimeoutEvent(Object source, ServerTransaction serverTransaction,
            Timeout timeout) {
        super(source, serverTransaction);
        mTimeout = timeout;
        addTaint(source.getTaint());
        addTaint(serverTransaction.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.105 -0400", hash_original_method = "E3A1CE6AED4C8EB398A7A856D4DC19D6", hash_generated_method = "CC1A003E1C5D902AC4213A08853B3E48")
    public  TimeoutEvent(Object source, ClientTransaction clientTransaction,
            Timeout timeout) {
        super(source, clientTransaction);
        mTimeout = timeout;
        addTaint(source.getTaint());
        addTaint(clientTransaction.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.107 -0400", hash_original_method = "83172AE614FED36EC49043A629BB9E54", hash_generated_method = "F72288A70973576E6C5138E1E8CA15FD")
    public Timeout getTimeout() {
        Timeout varB4EAC82CA7396A68D541C85D26508E83_2104950938 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2104950938 = mTimeout;
        varB4EAC82CA7396A68D541C85D26508E83_2104950938.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2104950938;
        
        
    }

    
}

