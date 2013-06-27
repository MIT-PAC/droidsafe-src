package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class EventObject implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.677 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "B89FD14140C3D96FD5EE1AB3347DDB03")

    @FindBugsSuppressWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED") protected transient Object source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.677 -0400", hash_original_method = "19E83C4C00CF513D7C219A8F2CE4B9FA", hash_generated_method = "3DB05AC0797366E6B6CD8950CB4C625E")
    public  EventObject(Object source) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        this.source = source;
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new IllegalArgumentException();
        //}
        //this.source = source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.678 -0400", hash_original_method = "9C6E9403B2BCB843296731DEDAEEBBC7", hash_generated_method = "D0026D96156DCDE53AFA199FF291A29A")
    public Object getSource() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1319228248 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1319228248 = source;
        varB4EAC82CA7396A68D541C85D26508E83_1319228248.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1319228248;
        // ---------- Original Method ----------
        //return source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.678 -0400", hash_original_method = "50A98C78FE68558BA94E5BDF90A15613", hash_generated_method = "FB0F6DE97E49CB1CA4A9B07B7D4DA9CF")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_396423246 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_396423246 = getClass().getName() + "[source=" + source + ']';
        varB4EAC82CA7396A68D541C85D26508E83_396423246.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_396423246;
        // ---------- Original Method ----------
        //return getClass().getName() + "[source=" + source + ']';
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.679 -0400", hash_original_field = "D96D8741991E0FF309E98E4D0FF23C6A", hash_generated_field = "7192979B1D8287ED40A80D853CC64221")

    private static long serialVersionUID = 5516075349620653480L;
}

