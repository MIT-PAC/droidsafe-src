package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class RuntimeException extends Exception {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.580 -0400", hash_original_method = "C630CF95A30AC67866F4ABFDC2AE9E1F", hash_generated_method = "2414371380C96DB54D1831DED250C02B")
    public  RuntimeException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.580 -0400", hash_original_method = "80B9FEB41572B74366DE05587056CF70", hash_generated_method = "B2DA1C3E317F33E13ACCF5F2FE4CD5ED")
    public  RuntimeException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.580 -0400", hash_original_method = "6494A6C5ABD2EBB06754B14C1D93C94D", hash_generated_method = "B1C2BBCE34DACF4608E7324D2D5E1C53")
    public  RuntimeException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        addTaint(throwable.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.580 -0400", hash_original_method = "2585C76CA369FC60FE687924F5D5A532", hash_generated_method = "26A83ACC4ABA5AF06AF2869241514D56")
    public  RuntimeException(Throwable throwable) {
        super(throwable);
        addTaint(throwable.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.580 -0400", hash_original_field = "93FBCF2CFFB89839E3124A3A79F13CD1", hash_generated_field = "3820080247BEE5769E364CDD33D922EF")

    private static final long serialVersionUID = -7034897190745766939L;
}

