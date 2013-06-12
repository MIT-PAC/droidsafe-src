package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class InterruptedIOException extends IOException {
    private static final long serialVersionUID = 4020568460727500567L;
    public int bytesTransferred;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.481 -0400", hash_original_method = "BB9DACD07ED93D41347C3772C10021CB", hash_generated_method = "C6B967AFE721FD0254C857AB031F3CB0")
    @DSModeled(DSC.SAFE)
    public InterruptedIOException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.481 -0400", hash_original_method = "9DCF8CB18681541ED5194D8FB0295B7F", hash_generated_method = "2A7026BB1AB82E8C3B235583F8302D28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InterruptedIOException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.481 -0400", hash_original_method = "4976F1F97DF8BBE1F3AC7D56299FEDE9", hash_generated_method = "7BFEC4495C43A892303A8898C00C91AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InterruptedIOException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


