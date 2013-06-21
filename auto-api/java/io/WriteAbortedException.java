package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class WriteAbortedException extends ObjectStreamException {
    public Exception detail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.354 -0400", hash_original_method = "DA6C07DB36CBC207B190B4B4ECB6B2B2", hash_generated_method = "DB3D3D10CF347550A318891DB2C7A98B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WriteAbortedException(String detailMessage, Exception rootCause) {
        super(detailMessage);
        dsTaint.addTaint(rootCause.dsTaint);
        dsTaint.addTaint(detailMessage);
        initCause(rootCause);
        // ---------- Original Method ----------
        //detail = rootCause;
        //initCause(rootCause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.355 -0400", hash_original_method = "F8C8FA3813C752D5C72108208FEF04C6", hash_generated_method = "4A5324B8CDBEBB0EF9AEE458867C8DE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMessage() {
        String msg;
        msg = super.getMessage();
        {
            msg = msg + "; " + detail.toString();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String msg = super.getMessage();
        //if (detail != null) {
            //msg = msg + "; " + detail.toString();
        //}
        //return msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.355 -0400", hash_original_method = "CA6C7AF43E4792C258E5E6922F45606C", hash_generated_method = "BE17797C3599E5E649F991EACA6EF83C")
    @DSModeled(DSC.SAFE)
    @Override
    public Throwable getCause() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return detail;
    }

    
    private static final long serialVersionUID = -3326426625597282442L;
}

