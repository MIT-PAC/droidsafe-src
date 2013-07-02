package java.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class UndeclaredThrowableException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.955 -0400", hash_original_field = "825B95FFAA185A2942F567CF19409336", hash_generated_field = "BF3D8746B5EF92EBFB7AAFB8779CD82F")

    private Throwable undeclaredThrowable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.956 -0400", hash_original_method = "2E4465C869474A92C89F11543A5003FF", hash_generated_method = "003F8FCC5CFD4CD28608CB2975428D96")
    public  UndeclaredThrowableException(Throwable exception) {
        this.undeclaredThrowable = exception;
        initCause(exception);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.956 -0400", hash_original_method = "6F99F5FACA33DF39A2D7F5348E0FE855", hash_generated_method = "FDE69BF550E91F95F2D2964CAE8EE1F9")
    public  UndeclaredThrowableException(Throwable exception,
            String detailMessage) {
        super(detailMessage);
        this.undeclaredThrowable = exception;
        initCause(exception);
        addTaint(detailMessage.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.957 -0400", hash_original_method = "01FF2A365C1FC09F8BDCAF7FAA2D9177", hash_generated_method = "E117D2F32C41F7DB1AA1D3FD3C4B0321")
    public Throwable getUndeclaredThrowable() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_170412318 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_170412318 = undeclaredThrowable;
        varB4EAC82CA7396A68D541C85D26508E83_170412318.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_170412318;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.958 -0400", hash_original_method = "1E11CE865934C875382AA6A691DB2EF1", hash_generated_method = "8B83D48C28A89FECB8B12B87C40E7A49")
    @Override
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1247306951 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1247306951 = undeclaredThrowable;
        varB4EAC82CA7396A68D541C85D26508E83_1247306951.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1247306951;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.958 -0400", hash_original_field = "53D761AD1C9E854CEC105978664623EE", hash_generated_field = "D26E659D3C6F2BAC21FB5EA803CB906E")

    private static final long serialVersionUID = 330127114055056639L;
}

