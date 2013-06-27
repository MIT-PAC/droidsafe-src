package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ExecutionException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.433 -0400", hash_original_method = "CDEFB422B20894AAD6D4B957BC56ADC9", hash_generated_method = "B804448C05909A7FECF05F6D5D7041FB")
    protected  ExecutionException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.433 -0400", hash_original_method = "7E880AEC547973941FE5E9587A1A933C", hash_generated_method = "8DEF0772E28C638A990DF4A5CB957614")
    protected  ExecutionException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.433 -0400", hash_original_method = "8309DDE2E41584C8A0A69308778461DD", hash_generated_method = "68C91466874698B8E42445FFC580F115")
    public  ExecutionException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.434 -0400", hash_original_method = "BC8973A519EF21FB8A5BD589A5BEDC19", hash_generated_method = "4AD6F8F94B8853EA93AAB7271F02E896")
    public  ExecutionException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.434 -0400", hash_original_field = "20319A43EDFF88115EEBC5160DED63FF", hash_generated_field = "EC0C3DEFE93CF39EBA44A2B00759A7BE")

    private static long serialVersionUID = 7830266012832686185L;
}

