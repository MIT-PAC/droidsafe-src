package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FactoryConfigurationError extends Error {
    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.388 -0400", hash_original_method = "6620C9D65D7B9B8AED04F1E2286BE37D", hash_generated_method = "3197EEE679B539DCD98F16DC71478ECF")
    @DSModeled(DSC.SAFE)
    public FactoryConfigurationError() {
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.389 -0400", hash_original_method = "48F1E682C4A714972A38A39D612B5275", hash_generated_method = "1585F7C32F25F261CCA8E64391C4F86C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FactoryConfigurationError(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.390 -0400", hash_original_method = "50F0E936640865FC69642EB9E9B7DACD", hash_generated_method = "7C5FD515AE4654908AAA96C62463A667")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FactoryConfigurationError(Exception e) {
        super(e.toString());
        dsTaint.addTaint(e.dsTaint);
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.390 -0400", hash_original_method = "6DA0E2DE853AFE92CEEE23D7625EA5CB", hash_generated_method = "7D76D44D97063C4E78DFC0D2C186570C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FactoryConfigurationError(Exception e, String msg) {
        super(msg);
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.390 -0400", hash_original_method = "3CFCD04CF304E9364ADFC7DBDB377B80", hash_generated_method = "EEF3F997B3CCAF3DD36B4D2B802C2369")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMessage() {
        String message;
        message = super.getMessage ();
        {
            String var408515ED3D09EC3C3B76800C4BFC9C6C_477737183 = (exception.getMessage());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String message = super.getMessage ();
        //if (message == null && exception != null) {
            //return exception.getMessage();
        //}
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.390 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "2C3AFB92F97725E71A554ACC471B64B4")
    @DSModeled(DSC.SAFE)
    public Exception getException() {
        return (Exception)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exception;
    }

    
}

