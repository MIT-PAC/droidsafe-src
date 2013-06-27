package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UndeclaredThrowableException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.189 -0400", hash_original_field = "825B95FFAA185A2942F567CF19409336", hash_generated_field = "BF3D8746B5EF92EBFB7AAFB8779CD82F")

    private Throwable undeclaredThrowable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.189 -0400", hash_original_method = "2E4465C869474A92C89F11543A5003FF", hash_generated_method = "003F8FCC5CFD4CD28608CB2975428D96")
    public  UndeclaredThrowableException(Throwable exception) {
        this.undeclaredThrowable = exception;
        initCause(exception);
        // ---------- Original Method ----------
        //this.undeclaredThrowable = exception;
        //initCause(exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.190 -0400", hash_original_method = "6F99F5FACA33DF39A2D7F5348E0FE855", hash_generated_method = "FDE69BF550E91F95F2D2964CAE8EE1F9")
    public  UndeclaredThrowableException(Throwable exception,
            String detailMessage) {
        super(detailMessage);
        this.undeclaredThrowable = exception;
        initCause(exception);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //this.undeclaredThrowable = exception;
        //initCause(exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.190 -0400", hash_original_method = "01FF2A365C1FC09F8BDCAF7FAA2D9177", hash_generated_method = "F4E9BF2B0C14476C9EECA9BE00224D64")
    public Throwable getUndeclaredThrowable() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1879489902 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1879489902 = undeclaredThrowable;
        varB4EAC82CA7396A68D541C85D26508E83_1879489902.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1879489902;
        // ---------- Original Method ----------
        //return undeclaredThrowable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.191 -0400", hash_original_method = "1E11CE865934C875382AA6A691DB2EF1", hash_generated_method = "1C4E616DEC535884738BAD0783EABD6A")
    @Override
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_2124270301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2124270301 = undeclaredThrowable;
        varB4EAC82CA7396A68D541C85D26508E83_2124270301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2124270301;
        // ---------- Original Method ----------
        //return undeclaredThrowable;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.191 -0400", hash_original_field = "53D761AD1C9E854CEC105978664623EE", hash_generated_field = "5871D60F300637DCEFA6E122FF026863")

    private static long serialVersionUID = 330127114055056639L;
}

