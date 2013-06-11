package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class ClassNotFoundException extends Exception {
    private static final long serialVersionUID = 9176873029745254542L;
    private Throwable ex;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.268 -0400", hash_original_method = "0639B59AB447390D4DDFBD24616B4C1C", hash_generated_method = "D5AFD90450FC0AF2E61B4224F134BBFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClassNotFoundException() {
        super((Throwable) null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.280 -0400", hash_original_method = "298BE36926392F30C6A667D05BCFC9E5", hash_generated_method = "2207279275A5426AA8D2A87A8A0822B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClassNotFoundException(String detailMessage) {
        super(detailMessage, null);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.292 -0400", hash_original_method = "3941F53B9B07ECD0ECA0F56417778218", hash_generated_method = "746C58C662A11576066EE90A7E1E2FA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClassNotFoundException(String detailMessage, Throwable exception) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        dsTaint.addTaint(exception.dsTaint);
        // ---------- Original Method ----------
        //ex = exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.300 -0400", hash_original_method = "4088520C94C7E98A0F8384BC5CAC9A7D", hash_generated_method = "F54748423AA4102C288195CB256D8771")
    @DSModeled(DSC.SAFE)
    public Throwable getException() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.313 -0400", hash_original_method = "8471E555B70ADD40A898DC66BF7F4D1C", hash_generated_method = "5A53ED346CD844A1598366B17F8017A8")
    @DSModeled(DSC.SAFE)
    @Override
    public Throwable getCause() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ex;
    }

    
}


