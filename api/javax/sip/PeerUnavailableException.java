package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PeerUnavailableException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.235 -0400", hash_original_method = "4D3350AD44AB8F981C91A400EAA4427E", hash_generated_method = "44BD24A818123A78793FB64A05D90F67")
    public  PeerUnavailableException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.235 -0400", hash_original_method = "66401C22E3DAC6E7A91EB96EDEE6E4D8", hash_generated_method = "E332E917A455254124ED9AD5E1051D79")
    public  PeerUnavailableException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.235 -0400", hash_original_method = "41F06EC1DF16A2C31AA3137EDABFA9B1", hash_generated_method = "02BDBC4B756DE07139CEEA8D4E8D9E76")
    public  PeerUnavailableException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        
    }

    
}

