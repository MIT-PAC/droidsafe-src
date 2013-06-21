package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UndeclaredThrowableException extends RuntimeException {
    private Throwable undeclaredThrowable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.030 -0400", hash_original_method = "2E4465C869474A92C89F11543A5003FF", hash_generated_method = "BBF8D6761DDDE2FEE710D7BA6908D6D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UndeclaredThrowableException(Throwable exception) {
        dsTaint.addTaint(exception.dsTaint);
        initCause(exception);
        // ---------- Original Method ----------
        //this.undeclaredThrowable = exception;
        //initCause(exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.030 -0400", hash_original_method = "6F99F5FACA33DF39A2D7F5348E0FE855", hash_generated_method = "F0440FDDC4928ABC1E14CAAB7FBF1C81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UndeclaredThrowableException(Throwable exception,
            String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        dsTaint.addTaint(exception.dsTaint);
        initCause(exception);
        // ---------- Original Method ----------
        //this.undeclaredThrowable = exception;
        //initCause(exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.031 -0400", hash_original_method = "01FF2A365C1FC09F8BDCAF7FAA2D9177", hash_generated_method = "884CD7789610ED46FF758CC1DC2CAE74")
    @DSModeled(DSC.SAFE)
    public Throwable getUndeclaredThrowable() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return undeclaredThrowable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.031 -0400", hash_original_method = "1E11CE865934C875382AA6A691DB2EF1", hash_generated_method = "E2A67A593F2CF0E77380AA098C3F9BE7")
    @DSModeled(DSC.SAFE)
    @Override
    public Throwable getCause() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return undeclaredThrowable;
    }

    
    private static final long serialVersionUID = 330127114055056639L;
}

