package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ClassFormatError extends LinkageError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.549 -0400", hash_original_method = "425CA80A6692859A51AA327ECCF27B34", hash_generated_method = "BF82F7972D435F9EE4D71CA7D0625D1F")
    public  ClassFormatError() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.549 -0400", hash_original_method = "BAE3B13B354B16D7CAA986D0ECE3EF81", hash_generated_method = "B2AB2C4D43C370115B45008C4ACD2EEC")
    public  ClassFormatError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.549 -0400", hash_original_field = "D280089B89EA3EF97019C2C1064183E7", hash_generated_field = "5EA27B59C36E073C15C01C9D2F77DFE8")

    private static final long serialVersionUID = -8420114879011949195L;
}

