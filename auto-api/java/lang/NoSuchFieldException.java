package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchFieldException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.886 -0400", hash_original_method = "C9B6E52CB5F5184DC84559DF357B6964", hash_generated_method = "0AA9C44117E303F6AB30495E8744B93B")
    public  NoSuchFieldException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.887 -0400", hash_original_method = "3003F78B5EA782042D23C70E768D6CA2", hash_generated_method = "16F4AEC15F62FE0969E0A32A1F6B837B")
    public  NoSuchFieldException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.887 -0400", hash_original_field = "8189C7A1DAF87054365B436182307C13", hash_generated_field = "EB78E79A018B9EEAF566DD4DAD302D65")

    private static long serialVersionUID = -6143714805279938260L;
}

