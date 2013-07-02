package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class WriteAbortedException extends ObjectStreamException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.165 -0400", hash_original_field = "951DA6B7179A4F697CC89D36ACF74E52", hash_generated_field = "C3243AD40E57E22F6ED814DD71D64096")

    public Exception detail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.166 -0400", hash_original_method = "DA6C07DB36CBC207B190B4B4ECB6B2B2", hash_generated_method = "9A68D2B382CDBEE907C2EEEBBB424150")
    public  WriteAbortedException(String detailMessage, Exception rootCause) {
        super(detailMessage);
        detail = rootCause;
        initCause(rootCause);
        addTaint(detailMessage.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.166 -0400", hash_original_method = "F8C8FA3813C752D5C72108208FEF04C6", hash_generated_method = "7E40324224DF69D2A1A4B70676A12ECF")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1156957196 = null; 
        String msg = super.getMessage();
        {
            msg = msg + "; " + detail.toString();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1156957196 = msg;
        varB4EAC82CA7396A68D541C85D26508E83_1156957196.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1156957196;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.167 -0400", hash_original_method = "CA6C7AF43E4792C258E5E6922F45606C", hash_generated_method = "1517EB7C680E499E7695516D4CC0136C")
    @Override
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1450202729 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1450202729 = detail;
        varB4EAC82CA7396A68D541C85D26508E83_1450202729.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1450202729;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.167 -0400", hash_original_field = "D14F55C6FD23B1D97DB4AE900326A4F8", hash_generated_field = "AA38F28709E0DCA1A936B26B13871FE3")

    private static final long serialVersionUID = -3326426625597282442L;
}

