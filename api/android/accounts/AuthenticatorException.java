package android.accounts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class AuthenticatorException extends AccountsException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.216 -0400", hash_original_method = "009F01E7B15DCE52B30E4E13B8632466", hash_generated_method = "1A7DAA5D19D8820B9379AC93220517C2")
    public  AuthenticatorException() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.218 -0400", hash_original_method = "46A5D5B214F277AEF0AE05BAEC539569", hash_generated_method = "509877330CE652CF7DE3DFCCB23C34E2")
    public  AuthenticatorException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.220 -0400", hash_original_method = "11AF1A71F6C16BA9750E55ACCBED5AED", hash_generated_method = "899AC24BF80EDA9F45F87EE6B7367D1E")
    public  AuthenticatorException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.224 -0400", hash_original_method = "649380462FDC9062DB3070254FE15E47", hash_generated_method = "F8959822A5B6E06BA3863881DAC91EB0")
    public  AuthenticatorException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        
    }

    
}

