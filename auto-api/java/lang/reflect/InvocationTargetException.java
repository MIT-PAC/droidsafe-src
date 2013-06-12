package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvocationTargetException extends Exception {
    private static long serialVersionUID = 4085088731926701167L;
    private Throwable target;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:10.674 -0400", hash_original_method = "5EBB00A3899F4B7F5118F6E64DAF6A94", hash_generated_method = "C4D4C64FA57AFB9A40B8730EF2CA7BBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected InvocationTargetException() {
        super((Throwable) null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:10.679 -0400", hash_original_method = "D75C8652A4FC35D535700D06AA8AC5D8", hash_generated_method = "968E87FC98DB9848BC1ADFAD74728A97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvocationTargetException(Throwable exception) {
        super(null, exception);
        dsTaint.addTaint(exception.dsTaint);
        // ---------- Original Method ----------
        //target = exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:10.685 -0400", hash_original_method = "24D12D510338B7A1CDB30B859EF6A619", hash_generated_method = "87D62A2773AEF3C81663F0A89B4F7DBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvocationTargetException(Throwable exception, String detailMessage) {
        super(detailMessage, exception);
        dsTaint.addTaint(detailMessage);
        dsTaint.addTaint(exception.dsTaint);
        // ---------- Original Method ----------
        //target = exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:10.687 -0400", hash_original_method = "F1F2316177C546F546EA483459CFF30B", hash_generated_method = "A1D66105FF8B88A7843C72EFB2EA2903")
    @DSModeled(DSC.SAFE)
    public Throwable getTargetException() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:10.692 -0400", hash_original_method = "D8C22D14C73496EF517FF8FC6C6B2CD8", hash_generated_method = "882F8019FB1037619AE7CC39F3BE2FF2")
    @DSModeled(DSC.SAFE)
    @Override
    public Throwable getCause() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return target;
    }

    
}


