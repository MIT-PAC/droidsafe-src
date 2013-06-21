package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ExceptionInInitializerError extends LinkageError {
    private Throwable exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.698 -0400", hash_original_method = "6D1A3A1944D703E56CAA922913525A43", hash_generated_method = "FD2365B6B4CCF743258ED4506CBE1824")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExceptionInInitializerError() {
        initCause(null);
        // ---------- Original Method ----------
        //initCause(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.698 -0400", hash_original_method = "CDE8F850C70A27B83A36A148C961A5A1", hash_generated_method = "4C388AC3ED0D096544F24630788BA23D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExceptionInInitializerError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        initCause(null);
        // ---------- Original Method ----------
        //initCause(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.698 -0400", hash_original_method = "C6EE88DB95324F4EE61EE6CA197E1367", hash_generated_method = "EAEC330FAB194913864AA1CDEE1B7CB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExceptionInInitializerError(Throwable exception) {
        dsTaint.addTaint(exception.dsTaint);
        initCause(exception);
        // ---------- Original Method ----------
        //this.exception = exception;
        //initCause(exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.698 -0400", hash_original_method = "7090E247F85246652792FDABBC14B51F", hash_generated_method = "9C847D984E16A65071E55A638ED7CA7E")
    @DSModeled(DSC.SAFE)
    public Throwable getException() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.698 -0400", hash_original_method = "28A8EFFB85C5CFA84BB4445EFA004CE6", hash_generated_method = "65B9BCD2F061034711B9EF836E1458EB")
    @DSModeled(DSC.SAFE)
    @Override
    public Throwable getCause() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exception;
    }

    
    private static final long serialVersionUID = 1521711792217232256L;
}

