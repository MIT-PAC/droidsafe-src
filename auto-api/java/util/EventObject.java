package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class EventObject implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.263 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "B89FD14140C3D96FD5EE1AB3347DDB03")

    @FindBugsSuppressWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED") protected transient Object source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.264 -0400", hash_original_method = "19E83C4C00CF513D7C219A8F2CE4B9FA", hash_generated_method = "3DB05AC0797366E6B6CD8950CB4C625E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.264 -0400", hash_original_method = "9C6E9403B2BCB843296731DEDAEEBBC7", hash_generated_method = "91BDB2853B01DBD9311156A7C3710D8B")
    public Object getSource() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2021324665 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2021324665 = source;
        varB4EAC82CA7396A68D541C85D26508E83_2021324665.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2021324665;
        // ---------- Original Method ----------
        //return source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.267 -0400", hash_original_method = "50A98C78FE68558BA94E5BDF90A15613", hash_generated_method = "0CB9D9678404293D4B2850EE314E8AF2")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_879447521 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_879447521 = getClass().getName() + "[source=" + source + ']';
        varB4EAC82CA7396A68D541C85D26508E83_879447521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_879447521;
        // ---------- Original Method ----------
        //return getClass().getName() + "[source=" + source + ']';
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.267 -0400", hash_original_field = "D96D8741991E0FF309E98E4D0FF23C6A", hash_generated_field = "7EDA1B54A84BB88DBCC9E4ADB18207F4")

    private static final long serialVersionUID = 5516075349620653480L;
}

