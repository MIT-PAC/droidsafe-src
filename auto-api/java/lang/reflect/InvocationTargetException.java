package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvocationTargetException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.110 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "5298B1A2336EAF80BB6B016828DD3384")

    private Throwable target;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.120 -0400", hash_original_method = "5EBB00A3899F4B7F5118F6E64DAF6A94", hash_generated_method = "A58F4D7E6437E4A4D86A792387D5EDF3")
    protected  InvocationTargetException() {
        super((Throwable) null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.123 -0400", hash_original_method = "D75C8652A4FC35D535700D06AA8AC5D8", hash_generated_method = "73039F919DC222FD102CF91F64E77875")
    public  InvocationTargetException(Throwable exception) {
        super(null, exception);
        target = exception;
        // ---------- Original Method ----------
        //target = exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.123 -0400", hash_original_method = "24D12D510338B7A1CDB30B859EF6A619", hash_generated_method = "150A9440C1919080016A5B2157066B47")
    public  InvocationTargetException(Throwable exception, String detailMessage) {
        super(detailMessage, exception);
        target = exception;
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //target = exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.124 -0400", hash_original_method = "F1F2316177C546F546EA483459CFF30B", hash_generated_method = "EC620D209A8BB8D4D6528514587A213E")
    public Throwable getTargetException() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_795404079 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_795404079 = target;
        varB4EAC82CA7396A68D541C85D26508E83_795404079.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_795404079;
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.132 -0400", hash_original_method = "D8C22D14C73496EF517FF8FC6C6B2CD8", hash_generated_method = "35496657EB9F1012ACDD9CFE7D0EB870")
    @Override
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_2100835716 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2100835716 = target;
        varB4EAC82CA7396A68D541C85D26508E83_2100835716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2100835716;
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.136 -0400", hash_original_field = "BDF7A26B10B2089AC01B7CC4154F2EC6", hash_generated_field = "016ED252CAF1CA6D3B40CFB8FD2E7C1F")

    private static long serialVersionUID = 4085088731926701167L;
}

