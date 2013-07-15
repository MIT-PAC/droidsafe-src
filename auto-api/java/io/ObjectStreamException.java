package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class ObjectStreamException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.679 -0400", hash_original_method = "7277EDCE895E14A1718765213C9E754B", hash_generated_method = "CD941114279F982226046C44432E1AD5")
    protected  ObjectStreamException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.680 -0400", hash_original_method = "B5966321481D67D0B2EAAF8863CF68D1", hash_generated_method = "5416426FB2AE7F363F122F0031CF88DA")
    protected  ObjectStreamException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.680 -0400", hash_original_field = "B6E22066C1F099CD6734655F8451563F", hash_generated_field = "E83FDCD08EA6AEFA8BBCB688FE0FD93F")

    private static final long serialVersionUID = 7260898174833392607L;
}

