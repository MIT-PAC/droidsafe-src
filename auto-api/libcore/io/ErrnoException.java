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
    private String functionName;
    public int errno;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.868 -0400", hash_original_method = "0DF4193C9C2664F33DC38063504784DA", hash_generated_method = "AD0F76CF4C06C6358ECDA79D2C607016")
    @DSModeled(DSC.SAFE)
    public ErrnoException(String functionName, int errno) {
        dsTaint.addTaint(errno);
        dsTaint.addTaint(functionName);
        // ---------- Original Method ----------
        //this.functionName = functionName;
        //this.errno = errno;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.869 -0400", hash_original_method = "BE4619378388F8812C9CF2AE8895CE85", hash_generated_method = "365B6607F3D187BE240B0625DC45DA8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ErrnoException(String functionName, int errno, Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(errno);
        dsTaint.addTaint(functionName);
        // ---------- Original Method ----------
        //this.functionName = functionName;
        //this.errno = errno;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.869 -0400", hash_original_method = "911EB712B1CEA729911922ADFC942179", hash_generated_method = "684DEF5DC4FD606C1E921B74D5724A3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMessage() {
        String errnoName;
        errnoName = OsConstants.errnoName(errno);
        {
            errnoName = "errno " + errno;
        } //End block
        String description;
        description = Libcore.os.strerror(errno);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String errnoName = OsConstants.errnoName(errno);
        //if (errnoName == null) {
            //errnoName = "errno " + errno;
        //}
        //String description = Libcore.os.strerror(errno);
        //return functionName + " failed: " + errnoName + " (" + description + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.869 -0400", hash_original_method = "F39DB956D71AD491CF421ED6963B5FCE", hash_generated_method = "FAB9B943BDA18C1A029E5A3D01DB960B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IOException rethrowAsIOException() throws IOException {
        IOException newException;
        newException = new IOException(getMessage());
        newException.initCause(this);
        if (DroidSafeAndroidRuntime.control) throw newException;
        return (IOException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IOException newException = new IOException(getMessage());
        //newException.initCause(this);
        //throw newException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.869 -0400", hash_original_method = "8BB4A81BC702A752206578FEF42C6BB1", hash_generated_method = "6DCDE5F4077F81B23C4685D4B12E3F43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketException rethrowAsSocketException() throws SocketException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(getMessage(), this);
        return (SocketException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException(getMessage(), this);
    }

    
}

