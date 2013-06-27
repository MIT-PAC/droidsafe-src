package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.SocketException;

public final class ErrnoException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.330 -0400", hash_original_field = "18B5CA8CBD35BC4F1D1B026A63E1062E", hash_generated_field = "3A7419DC5D02B665865D1D41C31D2769")

    private String functionName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.330 -0400", hash_original_field = "70106D0D821513F45702B7D25664AB7C", hash_generated_field = "D05FB512281BC7A92BFD5BEF738B1D62")

    public int errno;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.336 -0400", hash_original_method = "0DF4193C9C2664F33DC38063504784DA", hash_generated_method = "3D8190007CF210EB668925FD8B43A62F")
    public  ErrnoException(String functionName, int errno) {
        this.functionName = functionName;
        this.errno = errno;
        // ---------- Original Method ----------
        //this.functionName = functionName;
        //this.errno = errno;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.399 -0400", hash_original_method = "BE4619378388F8812C9CF2AE8895CE85", hash_generated_method = "4C7DBDE74038F8048AB29CBB4B780C2F")
    public  ErrnoException(String functionName, int errno, Throwable cause) {
        super(cause);
        this.functionName = functionName;
        this.errno = errno;
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //this.functionName = functionName;
        //this.errno = errno;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.399 -0400", hash_original_method = "911EB712B1CEA729911922ADFC942179", hash_generated_method = "E94B7555392A92A836717B8C47E6DB6A")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_2143109606 = null; //Variable for return #1
        String errnoName;
        errnoName = OsConstants.errnoName(errno);
        {
            errnoName = "errno " + errno;
        } //End block
        String description;
        description = Libcore.os.strerror(errno);
        varB4EAC82CA7396A68D541C85D26508E83_2143109606 = functionName + " failed: " + errnoName + " (" + description + ")";
        varB4EAC82CA7396A68D541C85D26508E83_2143109606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2143109606;
        // ---------- Original Method ----------
        //String errnoName = OsConstants.errnoName(errno);
        //if (errnoName == null) {
            //errnoName = "errno " + errno;
        //}
        //String description = Libcore.os.strerror(errno);
        //return functionName + " failed: " + errnoName + " (" + description + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.399 -0400", hash_original_method = "F39DB956D71AD491CF421ED6963B5FCE", hash_generated_method = "6726E179A0190995A9551CA49DBADA46")
    public IOException rethrowAsIOException() throws IOException {
        IOException newException;
        newException = new IOException(getMessage());
        newException.initCause(this);
        if (DroidSafeAndroidRuntime.control) throw newException;
        // ---------- Original Method ----------
        //IOException newException = new IOException(getMessage());
        //newException.initCause(this);
        //throw newException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.400 -0400", hash_original_method = "8BB4A81BC702A752206578FEF42C6BB1", hash_generated_method = "F2A1B5679AAF5B8FAA1C2D7F4EED028D")
    public SocketException rethrowAsSocketException() throws SocketException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(getMessage(), this);
        // ---------- Original Method ----------
        //throw new SocketException(getMessage(), this);
    }

    
}

