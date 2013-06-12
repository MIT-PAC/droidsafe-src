package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.net.SocketException;

public final class ErrnoException extends Exception {
    private final String functionName;
    public final int errno;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.432 -0400", hash_original_method = "0DF4193C9C2664F33DC38063504784DA", hash_generated_method = "B6855E5D76F837FDC5C2594C287E0141")
    @DSModeled(DSC.SAFE)
    public ErrnoException(String functionName, int errno) {
        dsTaint.addTaint(errno);
        dsTaint.addTaint(functionName);
        this.functionName = functionName;
        this.errno = errno;
        // ---------- Original Method ----------
        //this.functionName = functionName;
        //this.errno = errno;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.432 -0400", hash_original_method = "BE4619378388F8812C9CF2AE8895CE85", hash_generated_method = "F4E2BFA96A4A9107785F11C410D97141")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ErrnoException(String functionName, int errno, Throwable cause) {
        super(cause);
        dsTaint.addTaint(errno);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(functionName);
        this.functionName = functionName;
        this.errno = errno;
        // ---------- Original Method ----------
        //this.functionName = functionName;
        //this.errno = errno;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.432 -0400", hash_original_method = "911EB712B1CEA729911922ADFC942179", hash_generated_method = "27A7A0EBA30DFE94C0ABA0A48D43B0AB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.432 -0400", hash_original_method = "F39DB956D71AD491CF421ED6963B5FCE", hash_generated_method = "7700F967FE6B395C44A3149244BB4A2D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.432 -0400", hash_original_method = "8BB4A81BC702A752206578FEF42C6BB1", hash_generated_method = "A57BE35D11372E7E9C0728DE36097191")
    @DSModeled(DSC.SAFE)
    public SocketException rethrowAsSocketException() throws SocketException {
    	if (DroidSafeAndroidRuntime.control) throw new SocketException(getMessage(), this);
        return (SocketException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException(getMessage(), this);
    }

    
}


