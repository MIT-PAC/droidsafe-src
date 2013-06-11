package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class ExceptionInInitializerError extends LinkageError {
    private static final long serialVersionUID = 1521711792217232256L;
    private Throwable exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.725 -0400", hash_original_method = "6D1A3A1944D703E56CAA922913525A43", hash_generated_method = "FCEDD88C720F90B1860D46241EB95926")
    @DSModeled(DSC.SAFE)
    public ExceptionInInitializerError() {
        initCause(null);
        // ---------- Original Method ----------
        //initCause(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.737 -0400", hash_original_method = "CDE8F850C70A27B83A36A148C961A5A1", hash_generated_method = "8DD4CF2D332077F13C538D76449BDD86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExceptionInInitializerError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        initCause(null);
        // ---------- Original Method ----------
        //initCause(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.739 -0400", hash_original_method = "C6EE88DB95324F4EE61EE6CA197E1367", hash_generated_method = "00085A735DB122F781785C50FF59A6E5")
    @DSModeled(DSC.SAFE)
    public ExceptionInInitializerError(Throwable exception) {
        dsTaint.addTaint(exception.dsTaint);
        initCause(exception);
        // ---------- Original Method ----------
        //this.exception = exception;
        //initCause(exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.750 -0400", hash_original_method = "7090E247F85246652792FDABBC14B51F", hash_generated_method = "ABE3A3C5B4A6AA162461541B320C4751")
    @DSModeled(DSC.SAFE)
    public Throwable getException() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.752 -0400", hash_original_method = "28A8EFFB85C5CFA84BB4445EFA004CE6", hash_generated_method = "6933A56385F3837BA01123E585ACFD80")
    @DSModeled(DSC.SAFE)
    @Override
    public Throwable getCause() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exception;
    }

    
}


