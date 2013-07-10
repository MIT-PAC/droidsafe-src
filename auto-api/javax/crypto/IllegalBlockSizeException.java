package javax.crypto;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.GeneralSecurityException;

public class IllegalBlockSizeException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.069 -0400", hash_original_method = "861F6F81DB957F4D77B1EC6AAE4C23A3", hash_generated_method = "0BBC40120A5249158AD39AFDE295728B")
    public  IllegalBlockSizeException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.069 -0400", hash_original_method = "1121F9F47707C37345E2BF72D04B622E", hash_generated_method = "61CD53D6E952A5BE6116CCCB75B86933")
    public  IllegalBlockSizeException() {
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.069 -0400", hash_original_field = "1C2543952E0588E60BCA60CF7DAD7948", hash_generated_field = "B7ACA666642CD2E0C3A0051BC82DF96F")

    private static final long serialVersionUID = -1965144811953540392L;
}

