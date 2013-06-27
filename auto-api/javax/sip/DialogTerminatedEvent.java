package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class DialogTerminatedEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.469 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.469 -0400", hash_original_method = "29E943173FC1AF8A051089F6D7E9A828", hash_generated_method = "0BEAFB8C68929B035D1D672C38F6174E")
    public  DialogTerminatedEvent(Object source, Dialog dialog) {
        super(source);
        mDialog = dialog;
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //mDialog = dialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.470 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "48D21DF23147A49F14A00AF0D4A1FE0B")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_297646429 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_297646429 = mDialog;
        varB4EAC82CA7396A68D541C85D26508E83_297646429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_297646429;
        // ---------- Original Method ----------
        //return mDialog;
    }

    
}

