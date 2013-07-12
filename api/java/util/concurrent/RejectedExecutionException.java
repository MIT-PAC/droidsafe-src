package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class RejectedExecutionException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.119 -0400", hash_original_method = "14BCCCC5B9E76D0C33B19F741DA19A4D", hash_generated_method = "26B0BF6D0B3DF55E6E29F8355582DEAA")
    public  RejectedExecutionException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.119 -0400", hash_original_method = "685040D05C4255BE5A578536BCB19A2C", hash_generated_method = "C6C3ACFBF8FD5D8C62A55B59ACDD7299")
    public  RejectedExecutionException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.122 -0400", hash_original_method = "E48A8DF27205DB3C2384C43BB1BC845B", hash_generated_method = "C11F8D165336DD044CA4144233AA1F5F")
    public  RejectedExecutionException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.122 -0400", hash_original_method = "A7DCBE3F8485ADE0DEAC0A36B08B4222", hash_generated_method = "6294D974F9F2584F66EDD279855326D8")
    public  RejectedExecutionException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.123 -0400", hash_original_field = "CDACE29ADE0375A0FD8E2633FD91D276", hash_generated_field = "186DDE3724BE825E7BBFB6C14ECF5E8F")

    private static final long serialVersionUID = -375805702767069545L;
}

