package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class UndeclaredThrowableException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:52.558 -0400", hash_original_field = "825B95FFAA185A2942F567CF19409336", hash_generated_field = "BF3D8746B5EF92EBFB7AAFB8779CD82F")

    private Throwable undeclaredThrowable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:52.559 -0400", hash_original_method = "2E4465C869474A92C89F11543A5003FF", hash_generated_method = "003F8FCC5CFD4CD28608CB2975428D96")
    public  UndeclaredThrowableException(Throwable exception) {
        this.undeclaredThrowable = exception;
        initCause(exception);
        // ---------- Original Method ----------
        //this.undeclaredThrowable = exception;
        //initCause(exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:52.562 -0400", hash_original_method = "6F99F5FACA33DF39A2D7F5348E0FE855", hash_generated_method = "EE7B8C0D554069D1EB3BD838523A6DAB")
    public  UndeclaredThrowableException(Throwable exception,
            String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        this.undeclaredThrowable = exception;
        initCause(exception);
        // ---------- Original Method ----------
        //this.undeclaredThrowable = exception;
        //initCause(exception);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:52.563 -0400", hash_original_method = "01FF2A365C1FC09F8BDCAF7FAA2D9177", hash_generated_method = "A5877CDD9FFD71ED239082BBE16E255D")
    public Throwable getUndeclaredThrowable() {
Throwable var7F54B02A9ED5AA7DD5EAA6DD3318D69C_1977795885 =         undeclaredThrowable;
        var7F54B02A9ED5AA7DD5EAA6DD3318D69C_1977795885.addTaint(taint);
        return var7F54B02A9ED5AA7DD5EAA6DD3318D69C_1977795885;
        // ---------- Original Method ----------
        //return undeclaredThrowable;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:52.563 -0400", hash_original_method = "1E11CE865934C875382AA6A691DB2EF1", hash_generated_method = "D389EDE059136F5FC03CEE23F321EE60")
    @Override
    public Throwable getCause() {
Throwable var7F54B02A9ED5AA7DD5EAA6DD3318D69C_1489498225 =         undeclaredThrowable;
        var7F54B02A9ED5AA7DD5EAA6DD3318D69C_1489498225.addTaint(taint);
        return var7F54B02A9ED5AA7DD5EAA6DD3318D69C_1489498225;
        // ---------- Original Method ----------
        //return undeclaredThrowable;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:52.563 -0400", hash_original_field = "53D761AD1C9E854CEC105978664623EE", hash_generated_field = "D26E659D3C6F2BAC21FB5EA803CB906E")

    private static final long serialVersionUID = 330127114055056639L;
}

