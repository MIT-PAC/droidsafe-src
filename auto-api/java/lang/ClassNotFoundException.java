package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ClassNotFoundException extends Exception {
    private Throwable ex;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.656 -0400", hash_original_method = "0639B59AB447390D4DDFBD24616B4C1C", hash_generated_method = "1E5153620BBC3A8E1E248DD972E06BD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClassNotFoundException() {
        super((Throwable) null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.656 -0400", hash_original_method = "298BE36926392F30C6A667D05BCFC9E5", hash_generated_method = "7649C440BEA9777DC8D1B7A5B96E4E12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClassNotFoundException(String detailMessage) {
        super(detailMessage, null);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.656 -0400", hash_original_method = "3941F53B9B07ECD0ECA0F56417778218", hash_generated_method = "4E3E985474ACCC8050CA920D6EC3516B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClassNotFoundException(String detailMessage, Throwable exception) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        dsTaint.addTaint(exception.dsTaint);
        // ---------- Original Method ----------
        //ex = exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.656 -0400", hash_original_method = "4088520C94C7E98A0F8384BC5CAC9A7D", hash_generated_method = "9985307F655C9BC04CCA4FAA65AEB462")
    @DSModeled(DSC.SAFE)
    public Throwable getException() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.656 -0400", hash_original_method = "8471E555B70ADD40A898DC66BF7F4D1C", hash_generated_method = "8439D421E99944484163562DBFFDCB48")
    @DSModeled(DSC.SAFE)
    @Override
    public Throwable getCause() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ex;
    }

    
    private static final long serialVersionUID = 9176873029745254542L;
}

