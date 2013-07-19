package java.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class UndeclaredThrowableException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.191 -0400", hash_original_field = "825B95FFAA185A2942F567CF19409336", hash_generated_field = "BF3D8746B5EF92EBFB7AAFB8779CD82F")

    private Throwable undeclaredThrowable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.191 -0400", hash_original_method = "2E4465C869474A92C89F11543A5003FF", hash_generated_method = "003F8FCC5CFD4CD28608CB2975428D96")
    public  UndeclaredThrowableException(Throwable exception) {
        this.undeclaredThrowable = exception;
        initCause(exception);
        // ---------- Original Method ----------
        //this.undeclaredThrowable = exception;
        //initCause(exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.192 -0400", hash_original_method = "6F99F5FACA33DF39A2D7F5348E0FE855", hash_generated_method = "EE7B8C0D554069D1EB3BD838523A6DAB")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.192 -0400", hash_original_method = "01FF2A365C1FC09F8BDCAF7FAA2D9177", hash_generated_method = "06E291F5BE5CF5B9248BC730E305D948")
    public Throwable getUndeclaredThrowable() {
Throwable var7F54B02A9ED5AA7DD5EAA6DD3318D69C_771162674 =         undeclaredThrowable;
        var7F54B02A9ED5AA7DD5EAA6DD3318D69C_771162674.addTaint(taint);
        return var7F54B02A9ED5AA7DD5EAA6DD3318D69C_771162674;
        // ---------- Original Method ----------
        //return undeclaredThrowable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.192 -0400", hash_original_method = "1E11CE865934C875382AA6A691DB2EF1", hash_generated_method = "335FA74672C020257EF02CE4BC9A5EE1")
    @Override
    public Throwable getCause() {
Throwable var7F54B02A9ED5AA7DD5EAA6DD3318D69C_573347095 =         undeclaredThrowable;
        var7F54B02A9ED5AA7DD5EAA6DD3318D69C_573347095.addTaint(taint);
        return var7F54B02A9ED5AA7DD5EAA6DD3318D69C_573347095;
        // ---------- Original Method ----------
        //return undeclaredThrowable;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.193 -0400", hash_original_field = "53D761AD1C9E854CEC105978664623EE", hash_generated_field = "D26E659D3C6F2BAC21FB5EA803CB906E")

    private static final long serialVersionUID = 330127114055056639L;
}

