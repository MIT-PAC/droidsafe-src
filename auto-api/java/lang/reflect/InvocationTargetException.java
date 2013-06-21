package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvocationTargetException extends Exception {
    private Throwable target;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.895 -0400", hash_original_method = "5EBB00A3899F4B7F5118F6E64DAF6A94", hash_generated_method = "A58F4D7E6437E4A4D86A792387D5EDF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected InvocationTargetException() {
        super((Throwable) null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.895 -0400", hash_original_method = "D75C8652A4FC35D535700D06AA8AC5D8", hash_generated_method = "6CF67FA8B00C972C0B5464A7E4AF0CDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvocationTargetException(Throwable exception) {
        super(null, exception);
        dsTaint.addTaint(exception.dsTaint);
        // ---------- Original Method ----------
        //target = exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.895 -0400", hash_original_method = "24D12D510338B7A1CDB30B859EF6A619", hash_generated_method = "6FBB2BB3AAFBACFA1F2FBA07C814BED9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvocationTargetException(Throwable exception, String detailMessage) {
        super(detailMessage, exception);
        dsTaint.addTaint(detailMessage);
        dsTaint.addTaint(exception.dsTaint);
        // ---------- Original Method ----------
        //target = exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.896 -0400", hash_original_method = "F1F2316177C546F546EA483459CFF30B", hash_generated_method = "4D46739AA1B9B47F5FE16C382A9291AD")
    @DSModeled(DSC.SAFE)
    public Throwable getTargetException() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.896 -0400", hash_original_method = "D8C22D14C73496EF517FF8FC6C6B2CD8", hash_generated_method = "F1B0F0B04612AE8080BC3DCBAD82B9F1")
    @DSModeled(DSC.SAFE)
    @Override
    public Throwable getCause() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return target;
    }

    
    private static final long serialVersionUID = 4085088731926701167L;
}

