package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.UnknownHostException;
import libcore.io.OsConstants;

public final class GaiException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.916 -0400", hash_original_field = "18B5CA8CBD35BC4F1D1B026A63E1062E", hash_generated_field = "3A7419DC5D02B665865D1D41C31D2769")

    private String functionName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.916 -0400", hash_original_field = "CB5E100E5A9A3E7F6D1FD97512215282", hash_generated_field = "BB4B5831C4D0D33F468CF74A7B49F52F")

    public int error;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.917 -0400", hash_original_method = "BA53EB307FD31FC241DD4C6044D04AD1", hash_generated_method = "E8AF62B805AA6C835F1A36515273810B")
    public  GaiException(String functionName, int error) {
        this.functionName = functionName;
        this.error = error;
        // ---------- Original Method ----------
        //this.functionName = functionName;
        //this.error = error;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.917 -0400", hash_original_method = "845DC588FB53DD48B2B7818DC3F43C36", hash_generated_method = "DD7BA15F46D49D82D1D21B469F811AC4")
    public  GaiException(String functionName, int error, Throwable cause) {
        super(cause);
        this.functionName = functionName;
        this.error = error;
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //this.functionName = functionName;
        //this.error = error;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.917 -0400", hash_original_method = "6B923BF9D17AE00E606BE15037C1D30D", hash_generated_method = "D52F3F786A7B13439DFAE9FDDD5AC3DA")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1525589801 = null; //Variable for return #1
        String gaiName;
        gaiName = OsConstants.gaiName(error);
        {
            gaiName = "GAI_ error " + error;
        } //End block
        String description;
        description = Libcore.os.gai_strerror(error);
        varB4EAC82CA7396A68D541C85D26508E83_1525589801 = functionName + " failed: " + gaiName + " (" + description + ")";
        varB4EAC82CA7396A68D541C85D26508E83_1525589801.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1525589801;
        // ---------- Original Method ----------
        //String gaiName = OsConstants.gaiName(error);
        //if (gaiName == null) {
            //gaiName = "GAI_ error " + error;
        //}
        //String description = Libcore.os.gai_strerror(error);
        //return functionName + " failed: " + gaiName + " (" + description + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.918 -0400", hash_original_method = "5B589888D552552C8BEA12CEE384825F", hash_generated_method = "4F0DFA0183366BE727917E9DFC15B86E")
    public UnknownHostException rethrowAsUnknownHostException(String detailMessage) throws UnknownHostException {
        UnknownHostException newException;
        newException = new UnknownHostException(detailMessage);
        newException.initCause(this);
        if (DroidSafeAndroidRuntime.control) throw newException;
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //UnknownHostException newException = new UnknownHostException(detailMessage);
        //newException.initCause(this);
        //throw newException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.919 -0400", hash_original_method = "81B83C8D72DB912D679B4B84F9977C22", hash_generated_method = "1F1035B2C54E0A812B5D92858BC61427")
    public UnknownHostException rethrowAsUnknownHostException() throws UnknownHostException {
        if (DroidSafeAndroidRuntime.control) throw rethrowAsUnknownHostException(getMessage());
        // ---------- Original Method ----------
        //throw rethrowAsUnknownHostException(getMessage());
    }

    
}

